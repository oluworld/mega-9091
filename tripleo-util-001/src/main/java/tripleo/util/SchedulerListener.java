/*
 * Date: Oct 13, 2003
 * Time: 3:05:02 AM
 */
package tripleo.util;

public interface SchedulerListener {
	void handlerError(Exception e);
	void handleSuccess();
	//void expired(Scheduler sch);

	public static class NullListener implements SchedulerListener {
		public void handlerError(Exception e) {
		}

		public void handleSuccess() {
		}
	}

}
