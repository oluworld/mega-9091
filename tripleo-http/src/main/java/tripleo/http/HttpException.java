/*
 * Created on Oct 9, 2005 1:16:11 AM
 * 
 * $Id: HttpException.java,v 1.3 2005/10/11 19:22:08 olu Exp $
 * 
 */
package tripleo.http;

import java.io.IOException;

public class HttpException extends Exception {

    public HttpException(Exception aE) {
        super(aE);
    }

    public HttpException(String aMessage, Throwable aCause) {
        super(aMessage, aCause);
    }

    public static HttpException wrap(Exception exception) {
        HttpException e = new HttpException(exception);
        return e;
    }
}
