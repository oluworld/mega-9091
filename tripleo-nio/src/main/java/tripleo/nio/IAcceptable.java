/*
 * Date: Feb 20, 2004
 * Time: 11:44:41 PM
 */
package tripleo.nio;

public interface IAcceptable {

    void handle_accept_failed(ISocket sock, Exception e);

    void handle_accept(ISocket sock);
}
