package rabbit.util;

/*


 * Date: Nov 6, 2003
 * Time: 3:58:22 PM


 */

import java.util.Date;

import tripleo.util.Assert;

public class RabbitUT {
	public static final boolean ncache = false;

	public static void log (Object anObject) {
		String s = "== [TuffLog] "+new Date()+" "+anObject;
		xerr_a0(s);
	}

	public static void sys_exit() {
		Assert.not_reached();
		System.exit(-1);
	}

	public static void xerr_a0(String s) {
		System.err.println(s);
	}
}
