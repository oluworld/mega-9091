package tripleo.cottontail;

import tripleo.cottontail.webserver.CottonServer;
import tripleo.cottontail.webserver.IContainer;
import tripleo.cottontail.webserver.PythonScript;
import tripleo.cottontail.webserver.Transaction;
import tripleo.histore.AllocationFailure;
import tripleo.histore.ConsistencyFailure;
import tripleo.histore.HiStore;
import tripleo.histore.HiStoreEntry;
import tripleo.histore.InitializationFailure;
import tripleo.histore.j1.HiStore_J1;
import tripleo.util.Pair;
import tripleo.util.Assert;

import java.util.Map;
import java.util.HashMap;
import java.io.InputStream;
import java.io.IOException;

import org.python.util.PythonInterpreter;
import org.python.core.PyException;
import org.python.core.PyObject;

public class Cottontail implements IContainer {

    private final String root;
    private final HiStore store;
    private Script script;
    public Map<String, Pair/*<Long,Map>*/> tree = new HashMap<>();

    public HiStoreEntry alloc(String aS) throws AllocationFailure, ConsistencyFailure {
        return store.alloc(aS);
    }

    public Cottontail(String aRoot) throws InitializationFailure {
        root = aRoot;
        store = HiStore_J1.New(root);
    }

    public PythonScript create_python(String aScriptName) {
        //
        return new PythonScript(aScriptName, this);
    }

    static class Resp {

        public void set_content_type(String s) {
            //To change body of created methods use File | Settings | File Templates.
            // TODO: implement me
            Assert.not_implemented();

        }

        public void send() {
            //To change body of created methods use File | Settings | File Templates.
            // TODO: implement me
            Assert.not_implemented();

        }

        public void set_content(Object aFakeout) {
            //To change body of created methods use File | Settings | File Templates.
            // TODO: implement me
            Assert.not_implemented();

        }
    }

    void interpret(IContainer container, Object app, Req req) {
        Resp resp = req.def_response();
        resp.set_content_type("text/html");
        //
        Object fakein = null, fakeout = null;
        script.run(fakein, fakeout);
        resp.set_content(fakeout);
        resp.send();

    }

    public CallResult call(String aCallPath, Map anArgumentMap) {
//		HiStoreEntry m=store.walk_open(aCallPath);

        if (tree.containsKey(aCallPath)) {
            Pair/*<Long, Map>*/ p = tree.get(aCallPath);
            long l = (Long) p.first;
            Map m = (Map) p.second;
            //
            try {
                InputStream S = store.readStreamFor(l, 'C');
                byte[] bs = new byte[S.available()];
                S.read(bs);
                {
                    PythonInterpreter interp = new PythonInterpreter();

//					System.out.println("Hello, brave new world");
//					interp.exec("import sys");
//					interp.exec("print sys");
                    interp.set("mm", this);
                    interp.set("m", anArgumentMap);
                    interp.set("i", anArgumentMap.keySet().iterator());

                    interp.exec("d = {}\nmm.l()#mm.update(m,d)");
                    interp.exec("#i=m.keySet().iterator()\nwhile i.hasNext():\n"
                            + "\tf=i.next()\n\td[f]=m[f]\n");
                    PyObject d = interp.get("d");
                    interp.setLocals(d);
                    final String found_content = new String(bs);
                    try {
                        interp.exec(found_content);
                    } catch (PyException e) {
                        return CallResult.from(e);
                    }
                }
                S.close();
            } catch (ConsistencyFailure aConsistencyFailure) {
                aConsistencyFailure.printStackTrace();
                return CallResult.from(aConsistencyFailure);
            } catch (IOException e) {
                e.printStackTrace();
                return CallResult.from(e);
            }
        }

        return new CallResult();
    }

    public void l() {
        int y = 2;
    }

    public Transaction<CottonServer> create_http(int aPort) {
        CottonServer S = new CottonServer(aPort);
        return S.make_trans();
    }
}

class CallResult {

    public Object getResult() {
        return result;
    }

    private Object result;
    private Exception e;

//	public Transaction<CallResult> mt() {
//		//To change body of created methods use File | Settings | File Templates.
//		// TODO: implement me
//		Assert.not_implemented();
//		return null;
//	}
    /**
     * @param aE
     * @return
     */
    public static CallResult from(Exception aE) {
        // TODO Auto-generated method stub
        CallResult c = new CallResult();
        c.e = aE;
        return c;
    }
}

class Req {

    Cottontail.Resp def_response() {
        return null;
    }
}
