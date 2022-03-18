/*
 * Date: Dec 12, 2004
 * Time: 9:35:25 AM
 */
package tripleo.appz.net.urlsink;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import rabbit.http.HTTPHeader;

class Datum implements Serializable {
	String a, b;
	String category = "0"; //TODO: can't change categories
	boolean active = true;
	transient HTTPHeader header;
	Collection v;
	String rql;
	byte[] cont; // FIXME: maybe this holds header content?

	public Datum(String a, String b, HTTPHeader header, boolean active, String category) {
		this.a = a;
		this.b = b;
		this.header = header;
		this.active = active;
		this.category = category;
		v = header.copyOfHeaders();
		rql = header.getRequestLine();
		InputStream xa = header.getContentStream();
		if (xa == null) {
			final String content = header.getContent();
			if (content == null)
				cont = new byte[0];
			else
				cont = content.getBytes();
		} else {
			List<byte[]> l = new ArrayList();
			int ba, ta = 0;
			try {
				while ((ba = xa.available()) > 0) {
					byte[] tcont = new byte[ba];
					xa.read(tcont);
					l.add(tcont);
					ta += ba;
				}
			} catch (IOException e) {
				System.err.println("ignoring exception fromm create datum " + b + "\n" + e + "---------------");
			} finally {
				int x0 = 0;
				cont = new byte[ta];
				for (Iterator<byte[]> it = l.iterator(); it.hasNext();) {
					byte[] bytes = /*(byte[])*/ it.next();
					System.arraycopy(bytes, 0, cont, x0, bytes.length);
					x0 += bytes.length;
				}
//				while (x0<ta)
//					System.arraycopy();
			}
		}
	}

	public String toString() {
		return "Datum (" + a + ") (" + b + ") (" //+ header + ") ("
				+ category + ") (" + active + ")";
	}
}
