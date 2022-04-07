package tripleo.nio.javanio;

/*
 * @(#)AcceptHandler.java	1.2 04/07/26
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
import java.io.IOException;
import java.nio.channels.*;

import javax.net.ssl.SSLContext;

import tripleo.nio.javanio.http.RequestHandler;

/**
 * A single threaded Handler that performs accepts SocketChannels and registers
 * the Channels with the read/write Selector.
 *
 * @author Mark Reinhold
 * @author Brad R. Wetmore
 * @version 1.2, 04/07/26
 */
class AcceptHandler implements Handler {

    private final ServerSocketChannel channel;
    private final Dispatcher dsp;

    private final SSLContext sslContext;

    AcceptHandler(ServerSocketChannel ssc, Dispatcher dsp,
            SSLContext sslContext) {
        channel = ssc;
        this.dsp = dsp;
        this.sslContext = sslContext;
    }

    public void handle(SelectionKey sk) throws IOException {

        if (!sk.isAcceptable()) {
            return;
        }

        SocketChannel sc = channel.accept();
        if (sc == null) {
            return;
        }

        final boolean nb = false;
        /* non-blocking */
        ChannelIO cio = (sslContext != null
                ? null //ChannelIOSecure.getInstance(sc, nb, sslContext)
                : ChannelIO.getInstance(sc, nb));

        RequestHandler rh = new RequestHandler(cio);
        dsp.register(cio.getSocketChannel(), SelectionKey.OP_READ, rh);
    }
}
