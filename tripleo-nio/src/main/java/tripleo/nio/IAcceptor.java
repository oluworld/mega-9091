package tripleo.nio;

/**
 * Date: Dec 27, 2004 Time: 5:54:46 AM
 *
 * $Id: IAcceptor.java,v 1.1.1.1 2005/02/04 04:25:30 olu Exp $
 *
 */
public interface IAcceptor {

    ISocket accept_one();

    void close(); // IOException??
}
