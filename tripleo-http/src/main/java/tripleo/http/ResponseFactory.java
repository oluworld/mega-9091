/*
 * Created on Oct 9, 2005 12:50:33 AM
 * 
 * $Id: ResponseFactory.java,v 1.4 2005/10/16 14:16:31 olu Exp $
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package tripleo.http;

import java.io.OutputStream;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import tripleo.http.impl.*;

public abstract class ResponseFactory {

    public static IResponse FromOutputStream(OutputStream os, IRequest req) {
        return new OS_Response(os, req);
    }

    public static IResponse ForStringBuilder(IRequest req) {
        return new SB_Response(req);
    }

    public static IResponse FromApache(HttpClient aHttpClient, GetMethod aGetmeth) {
        return new HC_Response(aHttpClient, aGetmeth);
    }
}

/*
 * eof
 */
