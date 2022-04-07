package tripleo.histore/*.tests*/;

import tripleo.histore.j1.HiStore_J1;
import tripleo.util.Assert;
import tripleo.util.UT;

import java.io.IOException;

/**
 * Date: Feb 8, 2005
 * Time: 2:37:34 PM
 * <p/>
 * $Id: PersistentSpaceTest.java,v 1.1.1.1 2005/02/20 01:46:40 olu Exp $
 */
public class PersistentSpaceTest {
	public static void main(String[] args)
	        throws InitializationFailure, AllocationFailure, IOException, ConsistencyFailure {
		HiStore n = HiStore_J1.New("PersistentSpaceTest");
		for (int i = 0; i < 100; ++i) {
			String s = Integer.toString(i);
			HiStoreEntry e = n.alloc(s);
			e.contentWriter().write(UT.hexify(i).getBytes());
			e.contentWriter().close();
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
