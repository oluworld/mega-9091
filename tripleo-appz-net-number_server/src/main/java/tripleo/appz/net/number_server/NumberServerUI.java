/**
 *  $Id: NumberServerUI.java,v 1.2 2005/09/16 15:23:09 olu Exp $
 *   ========================================================================
 *  $Log: NumberServerUI.java,v $
 *  Revision 1.2  2005/09/16 15:23:09  olu
 *  NSUI updates and added NSApp
 *
 */ 
package tripleo.appz.net.number_server;

import java.lang.management.ClassLoadingMXBean;

import thinlet.FrameLauncher;
import thinlet.Thinlet;
import tripleo.space.SpaceNugget;

/**
 * Run the application in GUI mode (using Thinlet)
 * 
 * @author alimoe
 */
public class NumberServerUI extends Thinlet {
	private final boolean useProxy = true;

	/**
	 * @param aApp
	 */
	public NumberServerUI(NumberServerApp aApp) {
		app=aApp;
	}

	public void fixvis(Object o1, Object o2) {
		setBoolean(o1, "visible", getBoolean(o2,"enabled"));	
	}
	
	public void start_ui() throws Exception {
		try {
			final Object component = parse(path);
			add(component);
			app.t(this);
			//
			setBoolean(find("stc_pnl"), "visible", false);
			setBoolean(find("pr_pnl"),  "visible", false);
			setBoolean(find("xml_pnl"), "visible", false);
		} catch (Exception exc) {
			exc.printStackTrace();
			throw exc;
		}
	}

	public void run_() {
		app.start_normal();
		setBoolean(find("stc_pnl"),   "visible", true);
		setBoolean(find("stc-launch"),"visible", true);
	}
	
	public void ShutDown() {
		app.t(this).cancel();
		System.exit(1);
		//close(); // TODO: close the main frame we created below
	}

	boolean tx = true;

	public void checkcheckBox(Object o, boolean userJustChecked) {
		if (userJustChecked) { // use just clicked it on
			// TODO parse the time in the box ((String)(o.text))
			tx=true;
			setBoolean(o, "editable", false);

		} else {
			tx=false;
			setBoolean(o, "editable", true);
		}
	}

	public void pyrun() {
		app.pyrun();
	}
	
	public void start_stc() {
		app.start_stc();
	}

	public void start_xmlsrv() {
		app.run_xmlrpc_server();
	}

	public void set_ns(String nsrootName, String nsportnum) {
		app.space().add(new SpaceNugget<>("ns-host", nsrootName));
		app.space().add(new SpaceNugget<>("ns-port", nsportnum));
	}
	
	public void connectToNewRoot(String rootName, String sportnum) {
		try {
			int portnum = Integer.parseInt(sportnum);
		} catch (NumberFormatException nfe) {
			getToolkit().beep();
		}
	}

	public static void main(String[] args) throws Exception {
		ClassLoadingMXBean b = java.lang.management.ManagementFactory.getClassLoadingMXBean();
		b.setVerbose(false);
		NumberServerApp app = new NumberServerApp();
		final NumberServerUI ui = new NumberServerUI(app);
		ui.start_ui();
		new FrameLauncher("number_server", ui, 450, 240);
	}

	private final String path = "NumberServerUI.xml";
	private final NumberServerApp app;

}

