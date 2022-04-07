/*
 * Date: Nov 6, 2003
 * Time: 5:41:53 PM
 */
package tripleo.util;

public class Log {

    /**
     * Show all messages in the log.
     */
    public static final int DEBUG = 0;
    /**
     * Show all normal messages and higher.
     */
    public static final int ALL = 5;
    /**
     * Show information messages and higher.
     */
    public static final int INFO = 10;
    /**
     * Show warnings and higer.
     */
    public static final int WARN = 15;
    /**
     * Show important messages and above.
     */
    public static final int MSG = 20;
    /**
     * Show error messages and higer.
     */
    public static final int ERROR = 25;
    /**
     * Show only fatal messages.
     */
    public static final int FATAL = 30;

    /**
     * Get the actual error level from the given String.
     *
     * @param errorlevel the String to translate.
     * @return the errorlevel suitable for the given String.
     */
    public static int getErrorLevel(String errorlevel) {
        if (errorlevel.equals("DEBUG")) {
            return Log.DEBUG;
        }
        if (errorlevel.equals("ALL")) {
            return Log.ALL;
        }
        if (errorlevel.equals("INFO")) {
            return Log.INFO;
        }
        if (errorlevel.equals("WARN")) {
            return Log.WARN;
        }
        if (errorlevel.equals("MSG")) {
            return Log.MSG;
        }
        if (errorlevel.equals("ERROR")) {
            return Log.ERROR;
        }
        if (errorlevel.equals("FATAL")) {
            return Log.FATAL;
        }
        return Log.FATAL;
    }

    /**
     * Get the String description of the given error level
     *
     * @param errorlevel the int to translate to a String.
     * @return the String describing the errorlevel.
     */
    public static String LevelName(int errorlevel) {
        if (errorlevel <= Log.DEBUG) {
            return "DEBUG";
        }
        if (errorlevel <= Log.ALL) {
            return "ALL";
        }
        if (errorlevel <= Log.INFO) {
            return "INFO";
        }
        if (errorlevel <= Log.WARN) {
            return "WARN";
        }
        if (errorlevel <= Log.MSG) {
            return "MSG";
        }
        if (errorlevel <= Log.ERROR) {
            return "ERROR";
        }
        if (errorlevel <= Log.FATAL) {
            return "FATAL";
        }
        return "UNKNOWN";
    }
}
