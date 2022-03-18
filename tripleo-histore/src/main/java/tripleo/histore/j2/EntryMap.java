package tripleo.histore.j2;

import org.python.util.PythonInterpreter;
import org.python.core.*;

import java.util.*;
import java.io.*;
import java.beans.XMLEncoder;
import java.beans.XMLDecoder;

import tripleo.util.UT;
//import pyyaml.dummy;

public class EntryMap {
	private Map<String,J2_System.lazyEntry> _m = new Hashtable();

	public void load(final String fn) {
//		Map m=new Hashtable();
		if (false) {
			getI().set("m", _m);
			getI().set("fn", fn);
			final String s = "import yaml\n"+
					        "m.clear()\n"+
					        "try:\n\tf=yaml.load(open(fn).read())\n"+
					        "\tfor (x,y) in f.next(): print (x,y); m.put(x,y)\n"+
					        "except IOError, e: \n\tprint 100, e\n";
			getI().exec( s );
		} else if (false) {getI();
			PyDictionary locals = new PyDictionary();

			final PyObject yaml_mod = imp.import_name("yaml", true, null);
//			final PyObject yaml_mod = imp.import_name("pyyaml.__init__", true, null);
			_m.clear();
			locals.__setitem__("yaml", yaml_mod);
//			this.x(((PyString)locals.__getitem__(Py.java2py("d"))).toString());
			PyFile fp = null;
			try {
				fp = __builtin__.open(fn);
				PyString contents = fp.read();
				fp.close();
				locals.__setitem__("f", yaml_mod.__getattr__("load").__call__(new PyObject[]{Py.java2py(contents)}));
				PyTuple o = (PyTuple)locals.__getitem__(new PyString("f")).__getattr__("next").__call__();
				String x= ((PyString) o.__getitem__(0)).toString();
				PyObject y=o.__getitem__(1);
				_m.put(x,(J2_System.lazyEntry)y.__tojava__(J2_System.lazyEntry.class));
			} catch (IOException e) {
				e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
			} catch (PyException e) {
				e.printStackTrace();
			}

		} else {
			XMLDecoder d = null;
			try {
				d = new XMLDecoder(new BufferedInputStream(new FileInputStream(entriesFileName())));
				Object result = d.readObject();
				_m = (Map<String,J2_System.lazyEntry>) result;
				d.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	public void store(final String fn) {
		if (false) {
			final List m=new ArrayList();
			final Map<String, J2_System.lazyEntry> M = this._m;

			for(String s: M.keySet()) {
				J2_System.lazyEntry k = M.get(s);
				final List<Object> m2=new ArrayList();
				m2.add(s);
				m2.add(new Long(k.ident()));
				m.add(m2);
			}
//		dummy d=new dummy();
//		Py.runCode(new dummy._PyInner().getMain(),null,null);

			PyDictionary locals = new PyDictionary();

			final PyObject yaml_mod = imp.import_name("pyyaml.__init__", true, null);
			locals.__setitem__("yaml", yaml_mod);
			locals.__setitem__("d", yaml_mod.__getattr__("dump").__call__(new PyObject[]{Py.java2py(m)}));
			this.x(((PyString)locals.__getitem__(Py.java2py("d"))).toString());
			PyFile fp = null;
			try {
				fp = __builtin__.open(fn,"w");
				fp.write(ss);
				fp.close();
			} catch (IOException e) {
				e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
			}

//		Py.println(frame.getname("yaml").__getattr__("load").__call__(frame.getname("open").__call__(s$3).invoke("read")));

			if (false) {
				getI().set("m", m);
				getI().set("th", this);
				getI().set("fn", fn);
				getI().exec( "import yaml\n"+
				        "d=yaml.dump(m);th.x(d)\n"+
				        "fp=open(fn,'w');fp.write(d);fp.close()\n"
				);
			}
		} else {
			try {
				XMLEncoder e = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(entriesFileName())));
				e.writeObject(this._m);
				e.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
	}

	String entriesFileName() {
		return "Test.xml";
	}

	public void x(String s) {
		ss=s;
	}

	String ss;

	transient private static PythonInterpreter i;

	public PythonInterpreter getI() {
		if (i==null) i = UT.newInterp();
		return i;
	}

	public void put(String aKey, J2_System.lazyEntry aLazyEntry) {
														 _m.put(aKey, aLazyEntry); }
	public void clear()                                              { _m.clear(); }
	public J2_System.lazyEntry get(String aKey)             { return _m.get(aKey); }
	public boolean containsKey(String aKey)         { return _m.containsKey(aKey); }
	public Map unmodifiable()            { return Collections.unmodifiableMap(_m); }
	public void remove(String aKey)                             { _m.remove(aKey); }
}
