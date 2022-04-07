/*
 * Created on May 24, 2004
 *
 * $Id: SimpleTestClient.java,v 1.4 2005/09/16 15:23:09 olu Exp $
 *
 */
package tripleo.appz.net.number_server;

import EDU.oswego.cs.dl.concurrent.FJTask;
import EDU.oswego.cs.dl.concurrent.FJTaskRunnerGroup;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.xmlrpc.XmlRpcClient;
import org.apache.xmlrpc.XmlRpcException;

import tripleo.space.*;
import tripleo.util.*;

import java.io.*;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Vector;

class MyFJTask extends FJTask {

    private final STC_Parent p;
    private final STC_Request x;

    public MyFJTask(STC_Parent aP, STC_Request aX) {
        p = aP;
        x = aX;
    }

    public STC_Request getRequest() {
        return x;
    }

    public void run() {
        STC_Response resp = p.send_request(x);
        SpaceNugget<STC_Response> spaceNugget = new SpaceNugget<>("responses", resp);
        p.space().add(spaceNugget);
        p.responses.add(resp);
    }
}

public final class SimpleTestClient implements STC_Constants {

    final static private List<STC_Response> EmptyList = new Vector<>();

//	private volatile boolean cont = true;
    final private STC_Parent p;
    FJTaskRunnerGroup trg;
    final private boolean useProxy;

    TasksWatcher<FJTask> xx1;
    private final NumberServerApp app;

    /**
     * ctor assigns final values
     *
     * @param aUseProxy
     * @param aApp
     * @param aP
     */
    public SimpleTestClient(boolean aUseProxy, NumberServerApp aApp, STC_Parent aP) {
        useProxy = aUseProxy;
        app = aApp;
        p = aP;
    }

    /**
     * after this is done, we can call init again or reinit and then call
     * #doWork
     *
     */
    public void doWork() {
        _init();
        DD dd = new DD();
        dd.pre();

        for (int iter = 0; iter < TEST_ITERATIONS; iter++) {
            dd.loop(iter);
        }

        dd.post();
        app.locker.offer(("Please unlock now").intern()); // TODO:
    }

    /**
     * assign other [private] values
     */
    private void _init() {
//		p = new STC_Parent(useProxy, p.space());
        p.make();
        xx1 = new TasksWatcher<FJTask>(this, p.space());
    }

    class D {

        private void pre() {
        }

        private void post() {
            p.start();
        }

        private void xxdo_one(final HttpClient hc, final int i) {
            if (true) {
                final GetMethod getmeth = new GetMethod("/" + i);
                boolean ok = false;
                String ee = null;
                //
                try {
                    final int code = hc.executeMethod(getmeth);
                    if (code == HTTP_OK) {
                        String s = getmeth.getResponseBodyAsString();
                        if (s.equals(UT.string_times(i))) {
                            ok = true;
                        } else {
                            ee = "" + i + " not equal ((" + s + "))";
                        }
                    }
                } catch (HttpException e) {
                    /* Assert.not_reached(); */
                    ee = ("httpex " + e);
                } catch (IOException e) {
                    /* Assert.not_reached(); */
                    ee = ("ioex " + e);
                }
                Assert.check("valid_err_set", ok && ee == null);
                if (!ok) {
                    System.out.println("ko " + i + " " + ee.toString());
                } else {
                    System.out.println("ok " + i);
                }
            }
        }

        private void loop(final int iter) {
            final STC_Request req = new STC_Request(new Integer(iter));
            p.add_request(req);
        }
    }

    class DD {

        private void pre() {
            trg = new FJTaskRunnerGroup(4);
        }

        private void post() {
        }

        /**
         * b = False self._init() dd = DD() dd.pre() [ xx1.onSubmit(MYFJTask(p,
         * STC_Request(iter))) for iter in range(TEST_ITERATIONS)] dd.post()
         */
        private void loop(int iter) {
            final STC_Request req = new STC_Request(new Integer(iter));
            final FJTask task = new MyFJTask(p, req);
            xx1.onSubmit(task);
        }
    }

    public List<STC_Response> responses() {
        List<STC_Response> R = EmptyList;
        //
        if (p != null && p.responses != null) {
            R = p.responses;
        }
//		if (R == null) R = EmptyList;
        //
        Assert.postcondition("not_null", R != null);
        //
        return R;
    }

//	public boolean still_serving() {
//		// TODO: replace with a function from p.space()
//		return cont;
//	}
}

interface STC_Constants {

    String HOSTNAME = "localhost";
    int HTTP_OK = 200;
    int PORT = 8081;
    int PROXYPORT = 8080;
    int TEST_ITERATIONS = 100;
}

final class STC_Parent implements STC_Constants {

    static class TT {

        int code;
        STC_Response q;
        Integer req;
        long t;

        public TT(STC_Response aQ) {
            t = System.currentTimeMillis();
            q = aQ;
            req = aQ.req.get();
            code = aQ.code;
        }

        public String get() {
            return m(q);
        }

        public String m(final STC_Response aQ) {
            String R;
            if (aQ.e == null) {
                R = aQ.body;
            } else {
                R = "" + aQ.e + "\n--\n";
                final StringWriter w = new StringWriter();
                aQ.e.printStackTrace(new PrintWriter(w));
                R += w;
            }
            return R;
        }
    }

    private Space m_st_Space;

    public final void start() {
//		for (STC_Request element : requests) {
//			send_request(element);
//		}
    }

    public Space space() {
        return m_st_Space;
    }

    public void space(Space aSpace) {
        assert aSpace != null;
        assert m_st_Space == null;
        m_st_Space = aSpace;
    }

    private HttpClient hc;
    private List<STC_Request> requests;
    List<STC_Response> responses;
    private final boolean usingProxy;
    private XmlRpcClient xrc;

    STC_Parent(boolean aUseProxy, Space sp) {
        usingProxy = aUseProxy;
        space(sp);
    }

    final void add_request(STC_Request aRequest) {
        requests.add(aRequest);
    }

    void make() {
        hc = new HttpClient();
        requests = new Vector<>();
        responses = new Vector<>();
        //
        if (usingProxy) {
            hc.startSession(HOSTNAME, PORT, HOSTNAME, PROXYPORT);
        } else {
            hc.startSession(HOSTNAME, PORT);
        }
        //
        try {
            xrc = new XmlRpcClient("localhost", 9087);
        } catch (MalformedURLException e) {
            // TODO: swallow
            e.printStackTrace();
        }
        space().addWatcher(new W1(), "responses");
    }

    private static Vector mktt(SpaceNugget<STC_Response> aSpaceNugget) {
        final STC_Response Q = aSpaceNugget.value();
        TT tt = new TT(Q);
        final Vector<Object> V = new Vector();
        V.add("" + tt.t);
//		V.add(new Long(tt.t));
        V.add(tt.req);
        V.add(new Integer(tt.code));
        V.add(tt.get());
        return V;
    }

    /**
     * send an http req over the channel, and save the response to our resp
     * vector
     *
     * @param aRequest
     */
    STC_Response send_request(STC_Request aRequest) {
        return aRequest.sendOn(hc);
    }

    private class W1 implements SpaceWatcher {

        public boolean watch(SpaceNugget aSpaceNugget) {
            boolean b = false;
            try {
                b = xwatch(aSpaceNugget);
            } catch (XmlRpcException e) {
                // TODO: swallow
                e.printStackTrace();
            } catch (IOException e) {
                // TODO: swallow
                e.printStackTrace();
            }

            return b;
        }

        public boolean xwatch(SpaceNugget<STC_Response> aSpaceNugget) throws IOException, XmlRpcException {
            // time index code result
            final Vector V = mktt(aSpaceNugget);
            xrc.execute("a1a", V);
            return false;
        }
    }
}

final class STC_Request extends Holder<Integer> {

    public STC_Request(Integer aInteger) {
        super(aInteger);
    }

    public STC_Response sendOn(HttpClient hc) {
        STC_Response resp = new STC_Response();
        resp.req = this;
        //
        GetMethod getmeth = new GetMethod("/" + this.get());
        try {
            resp.code = hc.executeMethod(getmeth);
            resp.body = getmeth.getResponseBodyAsString();
            resp.e = null;
        } catch (IOException e) {
            resp.code = -1;
            resp.e = e;
            resp.body = null;
//		} catch (HttpException e) {
//			resp.code = -1;
//			resp.e = e;
//			resp.body = null;
        }
        //
        return resp;
    }
}

final class STC_Response {

    String body; // TODO: change to bytes or tripleo.ByteStream
    int code;
    Exception e;
    STC_Request req;

    void invariant() {
        Assert.postcondition("valid_exc_or_body", e != null && body == null);
        Assert.postcondition("req_not_null", req != null);
        Assert.postcondition("http_code_in_range", code <= 1000 && code >= 99); // TODO: check HTTP spec
    }
}
