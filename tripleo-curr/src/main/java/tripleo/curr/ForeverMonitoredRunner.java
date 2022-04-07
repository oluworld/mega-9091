/*
 * Created on Aug 8, 2005 11:04:27 AM
 * 
 * $Id$
 *
 */
package tripleo.curr;

public final class ForeverMonitoredRunner implements MonitoredRunner {

    public boolean stillRunning() {
        return true;
    }
}
