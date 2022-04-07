/*
 * Created on May 24, 2004
 *
 */
package tripleo.appz.net.number_server;

import rabbit.http.GeneralHeader;
import rabbit.http.HTTPHeader;
import rabbit.io.HTTPInputStream;

import tripleo.nio.BlockingAcceptor;
import tripleo.nio.IAcceptable;
import tripleo.nio.ISocket;
import tripleo.util.UT;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.BindException;
import java.net.Socket;

/**
 * NumberServer servers HTTP requests in the form of /1 ... /2000
 */
public class NumberServer implements /*Runnable,*/ IAcceptable {

    private final int mPort;
    BlockingAcceptor acptr;

    static final String server_string = "Server: NumberServer";
    static final int DEFAULT_PORT = STC_Constants.PORT;
    Thread t;
    final private NumberServerApp app;

    public NumberServer(int aMPort, NumberServerApp aMain_inst) {
        mPort = aMPort;
        app = aMain_inst;
    }

    public NumberServer(NumberServerApp aMain_inst) {
        this(DEFAULT_PORT, aMain_inst);
    }

    /**
     * start a thread serving on m_port
     */
    public void doWork() {
        acptr = new BlockingAcceptor(mPort, this);
        t = new Thread("accept thread") {
            public void run() {
                for (;;) {
                    if (app.locker.size() > 0) // TODO: this should work
                    {
                        t.interrupt();
                    }
                    if (t.isInterrupted()) {
                        break;
                    }
                    acptr.accept_one();
                }
            }
        };
        t.start();
    }

    private void action(ISocket aClientSocket, HTTPInputStream in, OutputStream os)
            throws IOException {
        HTTPHeader header = in.readHTTPHeader();
        String requesturi = header.getRequestURI();
        String method = header.getMethod();
        String V = null;
        int n = -1;

        try {
            final String s = requesturi.substring(1);
            final String[] m = s.split("/", 1);
            //rootobj.serve(m);
            n = Integer.parseInt(s);
            UT.vvv("started serving " + n);
        } catch (NumberFormatException e) {
            V = "" + n + " bad URL";
        }
        if (n >= 0 && n <= 2000) {
            serve_string(os, header, method, n);
        } else {
            V = "" + n + " out of bounds";
        }
        if (V != null) {
            String S = make_error(method, server_string, V, 400);
            UT.vvv("failed serving " + V);
            os.write(S.getBytes());
        }
        if (!method.endsWith("/1.1")) {
            in.close();
            os.close();
//			final Socket netsock = ((BlockingAcceptor.NetSocketWrapper) aClientSocket).get();
//			netsock.close();
            aClientSocket.close();
        }
        //	if (n != -1)
        UT.vvv("finished serving " + n);
    }

    String make_error(String aMethod, final String aServer_string, String aV, int n) {
        String S = aMethod + " " + n + " OK" + CRLF + aServer_string + CRLF;
//				"Date: who cares"+CRLF+
//				"Last-Modified: who cares"+CRLF+
        S += "Content-type: text/plain" + CRLF;
        S += "Content-length: " + +aV.length();
        S += CRLF + CRLF;
        S += aV;
        //
        return S;
    }

    void serve_string(OutputStream os, HTTPHeader header, String method, int http_code)
            throws IOException {
        //
        String string = UT.string_times(http_code);
        //
        String S = method + " 200 OK" + CRLF;
        S += "Server: who cares" + CRLF;
        //			"Date: who cares"+CRLF+
        //			"Last-Modified: who cares"+CRLF+
        S += "Content-type: text/plain" + CRLF;
        S += "Content-length: " + http_code + CRLF;
        S += CRLF + string;
        //
        os.write(S.getBytes());
    }

    static final String CRLF = GeneralHeader.CRLF;

    public void handle_accept_failed(ISocket sock, Exception e) {
        if (e instanceof BindException)
			try {
            Thread.sleep(5000);
        } catch (InterruptedException ee) {
            ee.printStackTrace();
        }
        e.printStackTrace();
    }

    public void handle_accept(ISocket sock) {
        try {
            final Socket netsock = ((BlockingAcceptor.NetSocketWrapper) sock).get();
            HTTPInputStream in = new HTTPInputStream(new BufferedInputStream(netsock.getInputStream()));
            OutputStream os = netsock.getOutputStream();
            action(sock, in, os);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
