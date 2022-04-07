/*
 * Created on Aug 17, 2005 12:50:27 PM
 *
 * $Id: CGI_PY.java,v 1.1 2005/10/16 14:21:55 olu Exp $
 *
 */
package tripleo.http;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tripleo.util.Pair;

class CGI_PY {

	/*
	 * def parse_qs(qs, keep_blank_values=0, strict_parsing=0): """Parse a query
	 * given as a string argument.
	 * 
	 * Arguments:
	 * 
	 * qs: URL-encoded query string to be parsed
	 * 
	 * keep_blank_values: flag indicating whether blank values in URL encoded
	 * queries should be treated as blank strings. A true value indicates that
	 * blanks should be retained as blank strings. The default false value
	 * indicates that blank values are to be ignored and treated as if they were
	 * not included.
	 * 
	 * strict_parsing: flag indicating what to do with parsing errors. If false
	 * (the default), errors are silently ignored. If true, errors raise a
	 * ValueError exception. """
	 */
	Map<String, List<String>> parse_qs(String qs, boolean keep_blank_values,
			boolean strict_parsing) {
		Map<String, List<String>> dict = new HashMap<>();
		List<Pair/* <String,String> */> _t0 = parse_qsl(qs, keep_blank_values,
				strict_parsing);
		//
		for (Pair/* <String,String> */_t1 : _t0) {
			final String name = (String) _t1.first;
			final String value = (String) _t1.second;
			//
			if (dict.containsKey(name)) {
				dict.get(name).add(value);
			} else {
				final ArrayList<String> _t2 = new ArrayList<>();
				_t2.add(value);
				dict.put(name, _t2);
			}
		}

		return dict;
	}

	/*
	 * Parse a query given as a string argument.
	 * 
	 * Arguments:
	 * 
	 * qs: URL-encoded query string to be parsed
	 * 
	 * keep_blank_values: flag indicating whether blank values in URL encoded
	 * queries should be treated as blank strings. A true value indicates that
	 * blanks should be retained as blank strings. The default false value
	 * indicates that blank values are to be ignored and treated as if they were
	 * not included.
	 * 
	 * strict_parsing: flag indicating what to do with parsing errors. If false
	 * (the default), errors are silently ignored. If true, errors raise a
	 * ValueError exception.
	 * 
	 * Returns a list, as God intended.
	 */
	List<Pair> parse_qsl(String qs, boolean keep_blank_values,
			boolean strict_parsing) {
		String[] name_value_pairs = qs.split("&");
		List<Pair> r = new ArrayList<>();
		for (String name_value : name_value_pairs) {
			String[] nv = name_value.split("=");
			if (nv.length != 2) {
				if (strict_parsing) {
					throw new ValueError("bad query field: " + name_value);
				}
				continue;
			}
			String name = urllib_unquote(nv[0].replace('+', ' '));
			String value = urllib_unquote(nv[1].replace('+', ' '));
			r.add(Pair.make(name, value));
		}

		return r;
	}

	static String urllib_unquote(String s) {
		String[] xlist = s.split("%");
		List<String> res = new ArrayList<>();
		res.add(xlist[1]);
		List<String> list = Arrays.asList(xlist);
		list.remove(0); // java-ism: this is always ''
		list.remove(0);

		// replace res.add below?
//		StringBuilder sb = new StringBuilder();
//		sb.delete(0, sb.length());
//		sb.length();

		for (String item : list) {
			try {
				int x = Integer.valueOf(item.substring(0, 2), 16).intValue();
				res.add("" + (char) x + item.substring(2));
			} catch (Exception e) {
				res.add("%" + item);
			}
		}
		StringBuilder x = new StringBuilder();
		for (String t2 : res) {
			x.append(t2);
		}
		return x.toString();
	}

	static class ValueError extends RuntimeException {
		private final String reason;

		public ValueError(final String aString) {
			reason = aString;
		}

		@Override
		public String getMessage() {
			return reason;
		}
	}
}
