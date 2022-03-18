/*   FILE: Utils.java
 *   DATE OF CREATION:   10/27/2001
 *   AUTHOR :            Emmanuel Pietriga (emmanuel@w3.org)
 *   MODIF:              Fri Oct 15 08:56:25 2004 by Emmanuel Pietriga (emmanuel.pietriga@inria.fr)
 *   $Id: Utils.java,v 1.1.1.1 2005/06/20 08:00:35 olu Exp $
 *
 *  (c) COPYRIGHT World Wide Web Consortium, 1994-2003.
 *  (c) COPYRIGHT INRIA (Institut National de Recherche en Informatique et en Automatique), 2004.
 *  Please first read the full copyright statement in file copyright.html
 *
 */


package tripleo.appz.pythondebug;

public class Utils {

	/**various misc utility methods*/

	/**
	 * increment a byte representing a char value with the following values (in order) 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0
	 */
	public static byte incByte(byte b) {
		byte res;
		if (b < 0x7a) {
			if (b == 0x39) {res = 0x41;} else if (b == 0x5a) {res = 0x61;} else {res = ++b;}
		} else {res = 0x30;}
		return res;
	}


	/**
	 * tells whether the underlying OS is Windows(Win32) or not
	 */
	public static boolean osIsWindows() {
		String osName = System.getProperty("os.name");
		if (osName.toLowerCase().startsWith("windows")) {
			return true;
		} else
			return false;
	}

	/**
	 * Replaces all occurences of key in input by replacement
	 * RDFValidator was using Jakarta's regexp package to do the same thing - rewrote a similar function so that we do not need users to install Jakarta
	 */
	public static String replaceString(String input, String key, String replacement) {
		String res = "";
		int keyLength = key.length();
		int index = input.indexOf(key);
		int lastIndex = 0;
		while (index >= 0) {
			res = res + input.substring(lastIndex, index) + replacement;
			lastIndex = index + keyLength;
			index = input.indexOf(key, lastIndex);
		}
		res += input.substring(lastIndex, input.length());
		return res;
	}


	/**
	 * @param aBase_uri
	 * @return
	 */
	public static boolean isWhiteSpaceCharsOnly(String aBase_uri) {
		// TODO Auto-generated method stub
		return false;
	}


}
