/**
 *  Created May 21, 2004 -- Time: 12:33:13 PM
 *   ========================================================================
 *  $Id: NumberServerApp.java,v 1.1 2005/09/16 15:23:09 olu Exp $
 *   ========================================================================
 *  $Log: NumberServerApp.java,v $
 *  Revision 1.1  2005/09/16 15:23:09  olu
 *  NSUI updates and added NSApp
 *
 */

package tripleo.appz.net.number_server;

import tripleo.space.Space;
import tripleo.util.UT;
import org.python.util.PythonInterpreter;
import org.apache.xmlrpc.*;

import java.util.concurrent.*;
import java.util.*;
import java.util.Timer;
import java.util.Vector;
import java.net.*;
import java.lang.management.ClassLoadingMXBean;

/**
 * Hold all the application logic
 */
public class NumberServerApp {

	private final Space space = new Space();
	final BlockingQueue locker=new ArrayBlockingQueue(1);

	private STC_Parent p;
	SimpleTestClient client;
	private Timer m_my_Timer;
	private boolean useProxy;

	Timer t(final NumberServerUI ui) {
		if (m_my_Timer==null) {
			m_my_Timer = new Timer();
			TimerTask ttsk = new TimerTask() {
				int n=60*10*1000; // sec * min * msec (10 minutes)
				public void run() {
					final String value = ""+(n-=1000)+"  "+n/60000;
					if (n<1) ui.ShutDown();
					Object comp = ui.find("timeout");
					assert comp != null;
					ui.setString(comp, "text", value);
				}
			};
			m_my_Timer.scheduleAtFixedRate(ttsk, 1000, 1000);
		}
		return m_my_Timer;
	}


	public void start_normal() {
		p = new STC_Parent(useProxy, space());
		//
		NumberServer f = new NumberServer(this);
		f.doWork();
	}

	public void start_stc() {
		assert p != null; // start_normal called
		client = new SimpleTestClient(useProxy, this, p);
		//
		System.out.print(100100+" ");
		System.out.print(client+" ");
		System.out.println(client.responses());
		//
		client.doWork();
	}
	
	void run_xmlrpc_server() {
		XmlRpcServer xrs = new XmlRpcServer();
		xrs.addHandler("p_resp", new XmlRpcHandler() {
			public Object execute(String method, Vector params) throws Exception {
				return client.responses();
			}
		});
		xrs.addHandler("a1a", new XmlRpcHandler() {
			public Object execute(String method, Vector params) throws Exception {
				System.out.println("++ NumberServerMain.execute> "+params);
				return null;
			}
		});
		try {
			WebServer ws = new WebServer(9087, InetAddress.getLocalHost(), xrs);
			ws.start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	void pyrun() {
		PythonInterpreter interp = newInterp(this.space());

		System.out.println("Hello, brave new world");

		p = new STC_Parent(useProxy, space());
		interp.set  ("c", new SimpleTestClient(useProxy, this,p));
		interp.set  ("th", this);

		{
			PythonInterpreter interp2 = newInterp(this.space());

//			interp2.set("xmlrpcport", space.getOr("1.xmlrpcport", new Integer(9192)));
//			interp2.set("xmlrpchost", space.getOr("1.xmlrpchost", "localhost"));
			interp2.set("c", interp.get("c"));

			String S3="print 100100, c, c.responses()\n";
			interp2.exec(S3);

			interp2.execfile("pyrt/1.py");
			interp2.execfile("pyrt/0.py");
		}

	    String S="f = NumberServer()\n"+
			"c.doWork(th)\n"+
			"f.doWork()\n"+
			"f.t.interrupt()\n";

		interp.exec(S); 		// setErr, setOut

//		stop = true;
		System.out.println("Goodbye, cruel world");
	}

	private static PythonInterpreter newInterp(Space aSpace) {
		PythonInterpreter interp2 = UT.newInterp();
		interp2.set  ("space", aSpace);
		return interp2;
	}


	public Space space() {
		return space;
	}
}

