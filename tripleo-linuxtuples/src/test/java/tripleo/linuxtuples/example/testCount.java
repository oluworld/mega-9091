// Do a little unit testing to make sure the new count feature is
// working correctly.
package tripleo.linuxtuples.example;

import tripleo.linuxtuples.TupleFactory;
import tripleo.linuxtuples.gen.tuple;
import tripleo.linuxtuples.quick;

import java.util.Arrays;

public class testCount {

    private quick conn;

    public static void main(String[] args) {
        new testCount().r();
    }

    void r() {
        conn = new quick();
        conn.connect(/*"desktop", 25000*/);

        setUp();
    }

    private void setUp() {//# Empty the tuple space
        final int MAX = 9;
        //
        Object[] a = new Object[MAX];
        //
        int i = 1;
        while (i < MAX) {
            Arrays.fill(a, null);
            tuple template = TupleFactory.make(a);
            while ((conn.get_nonblocking(template)) != null) {
                // This exposed an interesting bug: a zero-length tuple will
                // cause get_nonblocking to just sit there forever, which it
                // should never do.
            }
        }
    }

    private void testLinuxTuples() {

        /*
		final A1 self = this;
		self.assertEquals(conn.count(), 0);

		conn.put((1, 2));
		conn.put((1, 2, 3));
		conn.put((2, 4, 6));
		self.assertEquals(conn.count(), 3);
		self.assertEquals(conn.count([(1, None)]), 1);
		self.assertEquals(conn.count([(1, None, None)]), 1);
		self.assertEquals(conn.count([(1, None, None), (None, 4, None)]), 2);
		self.assertEquals(conn.count([(2, None, None), (None, 4, None)]), 1);

		conn.get((None, 2, None));
		self.assertEquals(conn.count(), 2);
		self.assertEquals(conn.count([(1, None)]), 1);
		self.assertEquals(conn.count([(1, None, None)]), 0);
		self.assertEquals(conn.count([(2, None, None)]), 1);
		self.assertEquals(conn.count([(1, None, None), (None, 4, None)]), 1);
		self.assertEquals(conn.count([(2, None, None), (None, 4, None)]), 1);

		conn.get((None, None, 6));
		self.assertEquals(conn.count(), 1);
		self.assertEquals(conn.count([(1, None)]), 1);
		self.assertEquals(conn.count([(1, None, None)]), 0);
		self.assertEquals(conn.count([(2, None, None)]), 0);
		self.assertEquals(conn.count([(1, None, None), (None, 4, None)]), 0);
		self.assertEquals(conn.count([(2, None, None), (None, 4, None)]), 0);

		conn.get((None, None));
		self.assertEquals(conn.count(), 0);
		self.assertEquals(conn.count([(1, None)]), 0);
		self.assertEquals(conn.count([(1, None, None)]), 0);
		self.assertEquals(conn.count([(2, None, None)]), 0);
		self.assertEquals(conn.count([(1, None, None), (None, 4, None)]), 0);
		self.assertEquals(conn.count([(2, None, None), (None, 4, None)]), 0);
         */
    }
}
