package tripleo.util;

import java.util.Map;
import java.util.HashMap;

/**
 * Date: Jan 6, 2005
 * Time: 11:49:45 AM
 */
public abstract class DomainMap <A, K> {
	private Map<A, K> resin = new HashMap();

	abstract public A allocate();
//	abstract public Object allocate();

	public void write(Object o, K f) {
		awrite((A)o, f);
	}

	public void awrite(A o, K f) {
//		assert o instanceof A;  // TODO: idea4 fails this
		//
		resin.put((A) o, f);
	}

	public K get(Object i) {
		return resin.get(i);
	}

	public K aget(A i) {
		return resin.get(i);
	}

}
