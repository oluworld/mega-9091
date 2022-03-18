/*
 * Date: Oct 9, 2003
 * Time: 3:16:38 PM
 */
package tripleo.util;

public class Assert {
	static class PositionLogger extends Exception {}

	public static void precondition(String s, boolean f) {
		check(s, f);
	}

	public static void postcondition(String s, boolean f) {
		check(s, f);
	}

	public static void check(String s, boolean f) {
		if(!f) {
			System.err.println("assertion failed --> "+s);
//			log_position();
		}
	}

	public static void not_reached() {
		System.err.println("not_reached");
		log_position();
	}

	public static void not_implemented() {
		System.err.println("not_implemented");
		log_position();
	}

	public static void log_position() {
		new PositionLogger().printStackTrace(System.err);
	}
}
