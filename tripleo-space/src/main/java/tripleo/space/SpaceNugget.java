/**
 * Date: Dec 27, 2004
 * Time: 11:47:09 PM
 *
 * $Id: SpaceNugget.java,v 1.1.1.1 2005/02/08 22:34:16 olu Exp $
 */
package tripleo.space;

public class SpaceNugget<T> {

    private final String mName;
    private final T mObject;

    public SpaceNugget(String spot_name, T o) {
        mName = spot_name;
        mObject = o;
    }

    public Object key() {
        return mName;
    }

    public T value() {
        return mObject;
    }

    void close() {
        if (persistent != null) {
            persistent.write();
        }
    }

    INuggetWriter persistent;

}

interface INuggetWriter {

    void write();
}
