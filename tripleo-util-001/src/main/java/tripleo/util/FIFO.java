/*
 * Date: Nov 6, 2003
 * Time: 2:41:53 PM
 */
package tripleo.util;

public interface FIFO {

    Object xout();

    void xin(Object t);

    boolean isEmpty();
}
