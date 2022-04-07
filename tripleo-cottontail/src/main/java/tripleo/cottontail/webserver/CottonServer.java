package tripleo.cottontail.webserver;

import org.apache.commons.logging.LogFactory;
import rabbit.http.GeneralHeader;
import rabbit.http.HTTPHeader;
import rabbit.io.HTTPInputStream;
import tripleo.nio.*;
import tripleo.util.Assert;
import tripleo.util.UT;

import java.io.*;
import java.net.Socket;

public class CottonServer {

	static class StartTrans implements Transaction {
		private final CottonServer parent;

		StartTrans(CottonServer s) {parent = s;}

		public void start() {parent.start_serving();}
	}

	static org.apache.commons.logging.Log log = LogFactory.getLog(CottonServer.class);
	private final int myPort;

	public CottonServer(int aPort) {myPort = aPort;}

	public Transaction<CottonServer> make_trans() {
		// TODO: implement me
		Assert.not_implemented();
		return new StartTrans(this);
	}

	private void start_serving() {
		log.trace("staring server");
		/*PythonInterpreter p = new PythonInterpreter();
		p.set("HandlerClass", "BaseHTTPRequestHandler");
		p.set("host", "");
		p.set("port", new Long(myPort));
		BaseHTTPServer b = new BaseHTTPServer();
		//Py.runCode(code,locals,globals);
		p.exec("import BaseHTTPServer\nhttpd=BaseHTTPServer.HTTPServer((host, port), 0)");
		p.exec("print 'Serving HTTP on port', port, '...'");
		p.exec("httpd.serve_forever()");*/
		new InternalCottonServer(myPort).doWork();
	}


}
/**
 * NumberServer servers HTTP requests in the form of /1 ... /2000
 */
/*public*/ class InternalCottonServer implements IAcceptable {


	static final String CRLF = GeneralHeader.CRLF;
	static final int DEFAULT_PORT = 9070;

	static final String server_string = "Server: InternalCottonServer";

	static volatile boolean stop;
	private BlockingAcceptor acptr;

	private final int mPort;
	private final String mThread_name = "accept thread";
	private Thread t;
	//private static final Space space = new Space();
	//static boolean stop = false;

	public InternalCottonServer() {
		this(DEFAULT_PORT);
	}

	InternalCottonServer(int aPort) {
		mPort = aPort;
	}

	private void action(ISocket aClientSocket, HTTPInputStream in, OutputStream os)
	        throws IOException {
		HTTPHeader header = in.readHTTPHeader();
		String requesturi = header.getRequestURI();
		String method = header.getMethod();
		String V = null;
		int n = -1;

		try {
			String s = requesturi.substring(1);

			//final String[] m = s.split("/", 1);
			//rootobj.serve(m);
			n = Integer.parseInt(s);
			UT.vvv("started serving " + n);
		} catch (NumberFormatException e) {
			V = "" + n + " bad URL";
			//		UT.vvv("failed serving " + n);
		}
		if (n >= 0 && n <= 2000) {
			byte[] S=serve_string(os, header, method, n);
			os.write(S);
			os.flush();
		} else {
			V = "" + n + " out of bounds";
		}
		if (V != null) {
			String S = make_error(method, server_string, V, 400);
			os.write(S.getBytes());
			os.flush();
		}
		if (!method.endsWith("/1.1")) {
			in.close();
			os.close();
			aClientSocket.close();
		}
		//	if (n != -1)
		UT.vvv("finished serving " + n);
	}

	/**
	 * start a thread serving on m_port
	 */
	public void doWork() {
		acptr = new BlockingAcceptor(mPort, this);
		t = new Thread(mThread_name) {
			public void run() {
				for (; ;) {
					if (stop) // TODO:
						t.interrupt();
					acptr.accept_one();
				}
			}
		};
		t.start();
	}

	public void handle_accept(ISocket sock) {
		try {
			final Socket netsock = ((BlockingAcceptor.NetSocketWrapper) sock).get();
			HTTPInputStream in = new HTTPInputStream(new BufferedInputStream(netsock.getInputStream()));
/*
			HTTPInputStream in = new HTTPInputStream(netsock.getInputStream(), new Logger() {
				@Override
				public void logError(final String error) {
					System.err.println(error);
				}

				@Override
				public void logError(final int type, final String error) {
					System.err.println(error);
				}
			});
*/
			OutputStream os = netsock.getOutputStream();
			action(sock, in, os);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void handle_accept_failed(ISocket sock, Exception e) {
		e.printStackTrace();
	}

	String make_error(String aMethod, final String aServer_string, String aV, int n) {
		String S = aMethod + " " + n + " OK" + CRLF + aServer_string + CRLF;
//				"Date: who cares"+CRLF+
//				"Last-Modified: who cares"+CRLF+
		S += "Content-type: text/plain" + CRLF;
		S += "Content-length: " + aV.length();
		S += CRLF + CRLF;
		S += aV;
		//
		return S;
	}

	byte[] serve_string(OutputStream os, HTTPHeader aHeader, String method, int content_length)
	        throws IOException {
		//
		String string = UT.string_times(content_length);
		//
		String xmethod = "HTTP/1.0"; //TODO:
		String S = xmethod + " 200 OK" + CRLF;
		S += server_string + CRLF;
		//"Server: who cares" + CRLF;
		//			"Date: who cares"+CRLF+
		//			"Last-Modified: who cares"+CRLF+
		S += "Content-type: text/plain" + CRLF;
		S += "Content-length: " + content_length + CRLF;
		S += CRLF + string;
		//
		return (S.getBytes());
	}

}
