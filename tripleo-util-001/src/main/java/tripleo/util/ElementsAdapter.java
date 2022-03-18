/*
 * Date: Oct 13, 2003
 * Time: 4:32:54 AM
 */
package tripleo.util;

import java.util.Enumeration;
import java.util.Iterator;

public class ElementsAdapter implements Enumeration {
	Iterator it;

	public ElementsAdapter(Iterator ait) {
		it = ait;
	}

	public boolean hasMoreElements() {
		return it.hasNext();
	}

	public Object nextElement() {
		return it.next();
	}
}
