/*
 * Created on Mar 23, 2004
 *
 */
package tripleo.util;

import java.io.PrintWriter;
import java.io.StringWriter;

public class FuckUp extends RuntimeException {

    public Exception ae;
    public String payload;

    public FuckUp(Exception aE) {
        ae = aE;
    }

    public FuckUp(String aPayload) {
        payload = aPayload;
    }

    public String phuk() {
        String R = "";
        if (ae != null) {
            StringWriter sw = new StringWriter();
            PrintWriter sos = new PrintWriter(sw);
            ae.printStackTrace(sos);
            R += sw + "\n\n";
        }
        if (payload != null) {
            R += payload;
        }
        return R;
    }
}
