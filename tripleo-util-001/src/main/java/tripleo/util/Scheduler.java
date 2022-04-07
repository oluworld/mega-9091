/*
 * Date: Oct 13, 2003
 * Time: 3:05:16 AM
 */
package tripleo.util;

import java.util.LinkedList;

public class Scheduler {
	static class SchedulerDatum { // aka Job
		long wakeuptime, interval;
		Schedulable closure;
		SchedulerListener handler;
	}

	class Sleeper implements Runnable {
		public void run() {
			while (true) {
				try {
					Thread.currentThread().sleep(lowest.wakeuptime);
				} catch (InterruptedException e) {
					synchronized (prospects) {
						lowest = prospects.getFirst();
						prospects.removeFirst();
					}
				}
			}
		}
	}

	public void schedule(long milli, Schedulable aRunnable) {
		schedule(milli, aRunnable, nullListener);
	}

	// TODO: add adapter for lava.lang.runnable
	public void schedule(long milli, Schedulable aRunnable, SchedulerListener sl) {
		SchedulerDatum sd = new SchedulerDatum();
		sd.closure = aRunnable;
		sd.handler = sl;
		sd.interval = milli;
		sd.wakeuptime = milli+System.currentTimeMillis();
		//
		addDatum(sd);
//		Assert.not_implemented();
		UT.errW.println("// TODO: Scheduler.schedule");
		// use s LinkedList and insertionSort to add a datum
		// use a thread to sleep until lowest.wakeuptime
	}

	public void addDatum(SchedulerDatum aDatum) {
		UT.errW.println("// TODO: Scheduler.addDatum");
		if (prospects.size() > 0 && lowest != null) {
			SchedulerDatum sd = prospects.getFirst();

			prospects.add(aDatum);
		} else {
			// empty list
			lowest = aDatum;
			sleeperThread.interrupt();
		}
	}

	SchedulerDatum lowest;
	LinkedList<SchedulerDatum> prospects;

	public Scheduler() {
		lowest        = null;
		prospects     = new LinkedList<>();
		sleeperThread = new Thread(new Sleeper(), "SleeperThread");
	}

	public void start() {sleeperThread.start();}

	Thread sleeperThread;

	public static SchedulerListener nullListener = new SchedulerListener.NullListener();
}
