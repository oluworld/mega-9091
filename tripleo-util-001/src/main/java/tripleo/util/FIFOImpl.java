/*
 * Date: Nov 6, 2003
 * Time: 2:42:01 PM
 */
package tripleo.util;

import java.util.Vector;

public class FIFOImpl implements FIFO {

    public Vector l = new Vector(); // for iterator

    public boolean isEmpty() {
        return l.size() == 0;
    }

    public Object xout() {
        Object o = l.lastElement();
        l.removeElementAt(l.size() - 1);
        return o;
    }

    public void xin(Object t) {
        l.addElement(t);
    }
}
