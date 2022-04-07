package tripleo.linuxtuples.example;

import tripleo.linuxtuples.gen.tuple;
import tripleo.linuxtuples.gen.tuples;
import tripleo.linuxtuples.quick;
import tripleo.linuxtuples.TupleFactory;

public class quick_test {

    private static final int PORT = 9000;
    private static final String HOSTNAME = "maury";

    public static void main(String[] args) {
        new quick_test().r();
    }

    void r() {
        new Thread(new Runnable() {

            public void run() {
                // Now we'll set up a client that performs some computational work.
                // On another machine, go into Python and type the following.

                quick conn = new quick();
                conn.connect(HOSTNAME, PORT);
                while (true) {
                    // Handle requests to perform square roots
                    tuple request = conn.get(TupleFactory.make(new Object[]{"sqrt", null}));
                    double x = tuples.tuple_get_double(request, 1);
                    conn.put(TupleFactory.make(new Object[]{
                        "sqrt done",
                        new Double(x),
                        new Double(Math.pow(x, .5))}));
                }

            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                // This will set up a worker task that performs square roots.
                // Open up another Python interpreter, on the same machine or
                // another on the network, and exercise the square root worker
                // task with this squart root client.

                quick conn = new quick();
                conn.connect(HOSTNAME, PORT);
                conn.put(TupleFactory.make("sqrt", 5.0));
                conn.put(TupleFactory.make("sqrt", 6.0));
                conn.put(TupleFactory.make("sqrt", 7.0));
                System.out.println(conn.get(TupleFactory.make("sqrt done", 5.0, null)));
                System.out.println(conn.get(TupleFactory.make("sqrt done", 6.0, null)));
                System.out.println(conn.get(TupleFactory.make("sqrt done", 7.0, null)));

            }
        }).start();

    }
}
