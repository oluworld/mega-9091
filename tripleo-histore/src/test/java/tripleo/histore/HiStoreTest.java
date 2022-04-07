/*
 * Created on Aug 8, 2005 10:22:10 AM
 * 
 * $Id$
 *
 */
package tripleo.histore;

import tripleo.histore.j1.HiStore_J1;
import tripleo.util.Assert;
import tripleo.util.UT;
import junit.framework.TestCase;

/**
 * @author alimoe
 *
 */
public class HiStoreTest extends TestCase {

    public final void testGetFileName() {
        //TODO Implement getFileName().
    }

    public final void testReadStreamFor() {
        //TODO Implement readStreamFor().
    }

    public final void testWriteStreamFor() {
        //TODO Implement writeStreamFor().
    }

    public final void testMangle_name() {
        //TODO Implement mangle_name().
    }

    public final void testFind() {
        //TODO Implement find().
    }

    public final void testAlloc() {
        //TODO Implement alloc().
    }

    public final void testInsert() {
        //TODO Implement insert().
    }

    /*
	 * Class under test for HiStore_J1 New(String)
     */
    public final void testNewString() {
        //TODO Implement New().
    }

    /*
	 * Class under test for HiStore_J1 New(String, MonitoredRunner)
     */
    public final void testNewStringMonitoredRunner() {
        //TODO Implement New().
    }

    public final void testRead() {
        //TODO Implement read().
    }

    public final void testManualRead() {
        //TODO Implement manualRead().
    }

    public final void testWrite() {
        //TODO Implement write().
    }

    public final void testGetEntrymap() {
        //TODO Implement getEntrymap().
    }

    public final void testEntries() {
        //TODO Implement entries().
    }

    public final void testRemove() {
        //TODO Implement remove().
    }

    public final void testFirst() {
        //TODO Implement first().
    }

    public final void testWalk_open() {
        //TODO Implement walk_open().
    }

    public final void testBacking() {
        //TODO Implement backing().
    }

    public final void testContentSetter() throws HiStoreException {
        HiStore n = HiStore_J1.New("PersistentSpaceTest2");
        for (int i = 0; i < 100; ++i) {
            String s = Integer.toString(i);
            HiStoreEntry e = n.alloc(s);
            e.setContent(UT.hexify(i).getBytes());
        }
        HiStoreEntry e = n.insert("101");
        try {
            e = n.insert("101");
            Assert.not_reached();
        } catch (ConsistencyFailure cf) {
            UT.errW.println("Success in double insert");
        }
    }
}
