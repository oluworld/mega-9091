package tripleo.impohrt.scache;

import java.lang.reflect.Method;

public class Java13_routines extends Thread {
	public Thread directory_saver_thread;


	public void run() {
		System.out.println("[INFO] shutdown hook is running...");
		directory_saver_thread.interrupt();
		try {
			directory_saver_thread.join(15000);
			System.out.println("[INFO] shutdown hook is done.");
		} catch (Exception ex) {
			System.out.println("[ERROR] shutdown hook join failed:" + ex);
		}
	}

	public static void activate_ShutdownHook(Thread saver) {
		Java13_routines th = new Java13_routines();
		th.setName("shutdown_hook");
		th.directory_saver_thread = saver;
		Runtime rt = Runtime.getRuntime();
		Class<? extends Runtime> rt_class = rt.getClass();
		Class[] par_cl = {Thread.class};

		try {
			Method hook_meth = rt_class.getMethod("addShutdownHook", par_cl);
			Object[] pars = {th};
			hook_meth.invoke(rt, pars);
			// System.out.println("shutdown hook is activated!");
		} catch (Exception ex) {
			// System.out.println("hook failed:"+ex.toString());
		}
	}
}
