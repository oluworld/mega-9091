/*
 * Date: Mar 23, 2004
 * Time: 5:21:11 PM
 */
package tripleo.util;

public interface Schedulable {

    void run(Scheduler aScheduler) throws Exception;
}
