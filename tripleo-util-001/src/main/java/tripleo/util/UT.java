/*
 * Date: Nov 6, 2003
 * Time: 1:36:32 PM
 */
package tripleo.util;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import org.python.core.PyInteger;
import org.python.util.PythonInterpreter;

public class UT {
	public static PrintWriter errW = new PrintWriter(new OutputStreamWriter(System.err));

	public static String hexify(long id) {
		String R = "";
		String s1 = Long.toString(id, 16);
		R = UT.repeatChar('0', 8 - s1.length()) + s1;
		return R;
	}

	public static String repeatChar(char c, int n) {
		String R = "";
		while (n-- > 0) R+=c;
		return R;
	}

	public static boolean string_in(String aVal, String aString, String aString2) {
		return aVal.equals(aString) || aVal.equals(aString2);
	}

	public static String string_times(int i) {
		StringBuffer R = new StringBuffer();
		while (i-- > 0) {
			R.append('*');
		}
		return R.toString();
	}

	public static synchronized void vvv(String aString) {
		System.out.println(aString);
	}

    public static PythonInterpreter newInterp() {
    	PythonInterpreter interp2 = new PythonInterpreter();
    
    	interp2.exec ("import sys\nsys.path+=['py-lib']\n");
    	interp2.set  ("True", new PyInteger(1));
    	return interp2;
    }
}
