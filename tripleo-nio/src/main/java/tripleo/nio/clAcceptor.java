/*
 * Date: Feb 20, 2004
 * Time: 11:47:06 PM
 */
package tripleo.nio;

import tripleo.impohrt.cl.SWIGTYPE_p_SOCKET;
import static tripleo.impohrt.cl.cl.*;

public class clAcceptor implements IAcceptor {
	public SWIGTYPE_p_SOCKET ss;
	private IAcceptable   aa;
	private int port;

	public clAcceptor(SWIGTYPE_p_SOCKET ss, IAcceptable aa) {
		this.ss = ss;
		this.aa = aa;
	}

	public clAcceptor(int aPort, IAcceptable aa) {
		port = aPort;
		ss = null;
		this.aa = aa;
	}

	/**
	 * optionally create a ServerSocket and wait for a client to connect
	 * then call one of the Acceptable methods with the socket and/or exception
	 *
	 * @note this call blocks on SOCKET.accept
	 *
	 * @return the [client] socket that connected or null in case of error
	 *
	 */
	public ISocket accept_one(){
		// TODO: check erorrs
		SWIGTYPE_p_SOCKET ssock = null;
		ISocket sock;
//		try {
			if (ss == null) {
				ss = clEstablish (port, 5); // backlog
			}
			// find a non-blocking accept
			ssock = clWaitNewConnection(ss);
			sock = new SwigSocketWrapper(ssock);
			aa.handle_accept(sock);
//		} catch (SecurityException e) {
//			aa.handle_accept_failed(sock,e);
//		} catch (IOException e) {
//			aa.handle_accept_failed(sock,e);
//		}
		return sock;
	}

	public void close() // IOException??
	{
		clClose(ss);
	}

	class SwigSocketWrapper implements ISocket {
		public SwigSocketWrapper(SWIGTYPE_p_SOCKET aSwigSock) {
			mSwigSock = aSwigSock;
		}

		SWIGTYPE_p_SOCKET mSwigSock;

		public void close() {
			clClose(mSwigSock);
		}

		public Object getCarrier() {
			return mSwigSock;
		}
	}

	/**
	 * invariant:
	 *      [ctor]ss == null && port is valid
	 */
}
