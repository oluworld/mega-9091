/*
 * Date: Feb 20, 2004
 * Time: 11:47:06 PM
 */
package tripleo.nio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BlockingAcceptor implements IAcceptor {

    private ServerSocket ss;
    private final IAcceptable aa;
    private int port;

    public BlockingAcceptor(ServerSocket aServerSocket, IAcceptable anAcceptable) {
        ss = aServerSocket;
        aa = anAcceptable;
    }

    public BlockingAcceptor(int aPort, IAcceptable anAcceptable) {
        port = aPort;
        ss = null;
        aa = anAcceptable;
    }

    /**
     * optionally create a ServerSocket and wait for a client to connect then
     * call one of the Acceptable methods with the socket and/or exception
     *
     * @note this call blocks on SOCKET.accept
     *
     * @return the [client] socket that connected or null in case of error
     *
     */
    public ISocket accept_one() {
        Socket ssock = null;
        NetSocketWrapper sock = null;
        try {
            if (ss == null) {
                ss = new ServerSocket(port);
            }
            ssock = ss.accept();
            sock = new NetSocketWrapper(ssock);
            aa.handle_accept(sock);
        } catch (SecurityException e) {
            aa.handle_accept_failed(sock, e);
        } catch (IOException e) {
            aa.handle_accept_failed(sock, e);
        }
        return sock;
    }

    public void close() // IOException??
    {
        try {
            ss.close();
        } catch (IOException e) {
            e.printStackTrace();  //Todo: swallow
        }
    }

    /**
     * invariant: [ctor]ss == null && port is valid
     */
    public static class NetSocketWrapper implements ISocket {

        public NetSocketWrapper(Socket aNetSock) {
            mNetSock = aNetSock;
        }

        public Socket get() {
            return mNetSock;
        }

        Socket mNetSock;

        public void close() {
            try {
                mNetSock.close();
            } catch (IOException e) {
                // todo swallow
                e.printStackTrace();
            }
        }

        /* avoid spurious casting
         */
        public Object getCarrier() {
            return mNetSock;
        }
    }

}
