package tripleo.nio.javanio.http;

/*
 * @(#)RequestHandler.java  1.2 04/07/26
 *
 * Copyright (c) 2004 Sun Microsystems, Inc. All Rights Reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * -Redistribution of source code must retain the above copyright notice, this
 *  list of conditions and the following disclaimer.
 *
 * -Redistribution in binary form must reproduce the above copyright notice,
 *  this list of conditions and the following disclaimer in the documentation
 *  and/or other materials provided with the distribution.
 *
 * Neither the name of Sun Microsystems, Inc. or the names of contributors may
 * be used to endorse or promote products derived from this software without
 * specific prior written permission.
 *
 * This software is provided "AS IS," without a warranty of any kind. ALL
 * EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND WARRANTIES, INCLUDING
 * ANY IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE
 * OR NON-INFRINGEMENT, ARE HEREBY EXCLUDED. SUN MIDROSYSTEMS, INC. ("SUN")
 * AND ITS LICENSORS SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE
 * AS A RESULT OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS
 * DERIVATIVES. IN NO EVENT WILL SUN OR ITS LICENSORS BE LIABLE FOR ANY LOST
 * REVENUE, PROFIT OR DATA, OR FOR DIRECT, INDIRECT, SPECIAL, CONSEQUENTIAL,
 * INCIDENTAL OR PUNITIVE DAMAGES, HOWEVER CAUSED AND REGARDLESS OF THE THEORY
 * OF LIABILITY, ARISING OUT OF THE USE OF OR INABILITY TO USE THIS SOFTWARE,
 * EVEN IF SUN HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.
 *
 * You acknowledge that this software is not designed, licensed or intended
 * for use in the design, construction, operation or maintenance of any
 * nuclear facility.
 */
import org.jetbrains.annotations.NotNull;
import tripleo.http.HttpException;
import tripleo.nio.javanio.ChannelIO;
import tripleo.nio.javanio.Handler;
import tripleo.nio.javanio.StringContent;
import tripleo.nio.javanio.http.CustomRequest.CRR;
import tripleo.util.Assert;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;

/**
 * Primary driver class used by non-blocking Servers to receive, prepare, send,
 * and shutdown requests.
 *
 * @author Mark Reinhold
 * @author Brad R. Wetmore
 * @version 1.2, 04/07/26
 */
public class RequestHandler implements Handler {

    protected ChannelIO cio;
    protected ByteBuffer rbb = null;

    private boolean requestReceived = false;
    protected Request request = null;
    protected Reply reply = null;

    private static int created = 0;

    public RequestHandler(ChannelIO xcio) {
        this.cio = xcio;

        heartbeat();
    }

    private static void heartbeat() {// Simple heartbeat to let user know we're alive.
        synchronized (RequestHandler.class) {
            created++;
            if ((created % 50) == 0) {
                System.out.println(".");
                created = 0;
            } else {
                System.out.print(".");
            }
        }
    }

    /**
     * Called when there is more input from async socket.
     *
     * @param sk the SelctionKey
     * @return true when request is complete
     * @throws IOException
     */
    protected boolean receive(SelectionKey sk) throws IOException {
        boolean R = false;
        try {
            if (requestReceived) {
                R = true;
            } else if (!cio.doHandshake(sk)) {
                R = false;
            } else if ((cio.read() < 0) || JN_Request.isComplete(cio.getReadBuf())) {
                rbb = cio.getReadBuf();
                R = (requestReceived = true);
            } else {
                R = false;
            }
        } finally {
            Assert.postcondition("valid_state", R && requestReceived);
        }
        return R;
    }

    public CustomRequest getCustom() {
        return mCustom;
    }

    // TODO: implement pushCustom and removeCustom
    public void setCustom(CustomRequest aMCustom) {
        mCustom = aMCustom;
    }

    private CustomRequest mCustom = null;
    private final CustomRequest mDefCustom = new DefaultCustomReuest();

    // When parse is successfull, saves request and returns true
    //
    protected @NotNull
    boolean parse() throws HttpException {
        boolean handled = false;
        CRR res = null; // Java should fix its flow analysis

        request = null;

        if (getCustom() != null) {
            CustomRequest custom = getCustom();
            if (custom.parse()) {
                handled = true;
                res = custom.parseResult(rbb);

            }
        }

        if (!handled) {
            res = mDefCustom.parseResult(rbb);
        }

        if (handled) {
            request = res.request;
            reply = res.reply;
            if (res.exc != null) {
                throw res.exc;
            }
            assert (Object) res.request != (Object) res.reply; // HACK for a null test
        }

        return request != null;
    }

    // Ensures that reply field is non-null
    //
    protected Reply build() throws IOException {
        CustomRequest custom;
        //
        if ((custom = getCustom()) != null && custom.build()) {
            custom = getCustom();
        } else {
            custom = mDefCustom;
        }
        //
        reply = custom.buildResult(request);
        //
        Assert.postcondition("ensure_valid_reply", reply != null);
        return reply;
    }

    public void handle(SelectionKey sk) throws IOException {
        try {

            if (request == null) {
                if (!receive(sk)) {
                    return;
                }
                rbb.flip();
                if (parse()) {
                    build();
                }

                try {
                    reply.prepare();
                } catch (IOException x) {
                    reply.release();
                    reply = new Reply(Reply.Code.NOT_FOUND,
                            new StringContent(x));
                    reply.prepare();
                }
                if (send()) {
                    // More bytes remain to be written
                    sk.interestOps(SelectionKey.OP_WRITE);
                } else {
                    // Reply completely written; we're done
                    if (cio.shutdown()) {
                        cio.close();
                        reply.release();
                    }
                }
            } else {
                if (!send()) {  // Should be rp.send()
                    if (cio.shutdown()) {
                        cio.close();
                        reply.release();
                    }
                }
            }
        } catch (IOException x) {
            String m = x.getMessage();
            if (!m.equals("Broken pipe")
                    && !m.equals("Connection reset by peer")) {
                System.err.println("RequestHandler: " + x);
            }

            try {
                /*
				* We had a failure here, so we'll try to be nice
				* before closing down and send off a close_notify,
				* but if we can't get the message off with one try,
				* we'll just shutdown.
                 */
                cio.shutdown();
            } catch (IOException e) {
                // ignore
            }

            cio.close();
            if (reply != null) {
                reply.release();
            }
        } catch (HttpException e) {
            final IOException exception = new IOException("exception during http");
            exception.initCause(e);
            throw exception;  // TODO: Use covariant returns here?
        }

    }

    protected boolean send() throws IOException {
        try {
            return reply.send(cio);
        } catch (IOException x) {
            if (x.getMessage().startsWith("Resource temporarily")) {
                System.err.println("## RTA");
                return true;
            }
            throw x;
        }
    }
}
