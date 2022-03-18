package tripleo.linuxtuples;

import tripleo.linuxtuples.gen.*;

public class TupleFactory {

	public static tuple make(String s, double v) {
		tuple t = tuples.create_tuple(2);
		tuples.tuple_set_str(t, 0, s, s.length());
		tuples.tuple_set_double(t, 1, v);
		return t;
	}

	public static tuple make(Object[] oar) {
		tuple t = tuples.create_tuple(oar.length);
		int i=0;
		for (Object o : oar) {
			if (o==null) {
				tuples.tuple_set_nil(t, i);
			} else if (o instanceof Integer) {
				Integer ii =(Integer) o;
				tuples.tuple_set_double(t, i, ii.intValue());
			} else if (o instanceof Double) {
				Double d=(Double) o;
				tuples.tuple_set_double(t, i, d.doubleValue());
			} else if (o instanceof String) {
				String s=(String) o;
				tuples.tuple_set_str(t, i, s, s.length());
			}
			//
			i++;
		}
		return t;
	}

	public static tuple make(String s, double v, Object o) {
		tuple t = tuples.create_tuple(3);
		tuples.tuple_set_str(t, 0, s, s.length());
		tuples.tuple_set_double(t, 1, v);
		if (o instanceof Double)
			tuples.tuple_set_double(t, 2, ((Double)o).doubleValue());
		else
			tuples.tuple_set_str(t, 2, null, 0);
		return t;
	}

	public static tuple make(String s, Object o) {
		tuple t = tuples.create_tuple(2);
		tuples.tuple_set_str(t, 0, s, s.length());
		tuples.tuple_set_str(t, 1, null, 0);
		return t;
	}
}
