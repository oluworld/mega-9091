/**
 * Created May 21, 2004 -- Time: 12:33:13 PM
 *   ========================================================================
 *  $Id: NumberServerMain.java,v 1.3 2005/09/16 15:23:09 olu Exp $
 *   ========================================================================
 *  $Log: NumberServerMain.java,v $
 *  Revision 1.3  2005/09/16 15:23:09  olu
 *  NSUI updates and added NSApp
 *
 */
package tripleo.appz.net.number_server;

import java.lang.management.ClassLoadingMXBean;

/**
 * Run the application in command-line mode
 *
 * PURPOSE: this is mostly just a launcher
 *
 * @author alimoe
 *
 */
public class NumberServerMain {

    private static NumberServerApp app;

    private void normal_run() {
        final boolean useProxy = true;
        STC_Parent p = new STC_Parent(useProxy, app.space());
        //
        NumberServer f = new NumberServer(app);
        f.doWork();
        //
        SimpleTestClient c = new SimpleTestClient(useProxy, app, p);
        app.run_xmlrpc_server();
        //
        System.out.print(100100 + " ");
        System.out.print(c + " ");
        System.out.println(c.responses());
        //
        c.doWork();

        try {
            Thread.sleep(20000); // TODO: wait 20 secs for app to finish
            app.locker.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//		stop = true;
    }

    private void run_program(String[] args) {
        if (false) {
            app.pyrun();
        } else {
            app.start_normal();
        }
    }

    public static void main(String[] args) {
        ClassLoadingMXBean b = java.lang.management.ManagementFactory.getClassLoadingMXBean();
        b.setVerbose(false);

        app = new NumberServerApp();
        app.start_normal();
    }
}
