package tripleo.cottontail.webserver;

import tripleo.histore.*;
import tripleo.util.Pair;
import tripleo.cottontail.Cottontail;

import java.util.Map;
import java.util.HashMap;
import java.io.IOException;

public class PythonScript {
	private final IContainer ctr;

	public PythonScript(String aName, IContainer actr) {
		script_name = aName;
		ctr = actr;
	}

	String script_name, content;

	void preprocess(String aCode) {}

	void set_content(String s) {content = s;}

	Map<String,Param> params=new HashMap<>();

	static class Param {
		/**
		 * @param aS
		 * @param aT
		 * @param aReq
		 */
		public Param(String aS, String aT, boolean aReq) {
			param_name=aS;
			type=aT;
			req= aReq;
		}
		String param_name;
		String type;
		boolean req; /*enum {STRING} Type;*/
	}


	void add_param(String s, String t, boolean aReq) {
		params.put(s, new Param(s, t, aReq));
	}

	void write() throws AllocationFailure, ConsistencyFailure, IOException {
		HiStoreEntry e = ctr.alloc(script_name); // TODO: whole path

		final Map<String, Pair> tree = ((Cottontail)ctr).tree;
		assert !tree.containsKey(script_name);
		tree.put(script_name, Pair.make(new Long(e.getIdentifier()),new HashMap()));

		e.contentWriter().write(content.getBytes("UTF-8"));
		e.contentWriter().close();
//		}
//		HiStoreEntry e = n.insert("101");
//		try {
//			e = n.insert("101");
//			Assert.not_reached();
//		} catch (ConsistencyFailure cf) {
//			UT.errW.println("Success in double insert");
//		}


	}
}
