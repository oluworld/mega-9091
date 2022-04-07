package rabbit.http;

import java.io.DataInputStream;
import java.io.IOException;

// $Id: HTTPFooter.java,v 1.5 2005/10/11 19:22:08 olu Exp $
/**
 * A class to handle a HTTP Footer.
 */
public class HTTPFooter extends GeneralHeader {

    /**
     * Create a new HTTPHeader from scratch
     */
    public HTTPFooter() {
    }

    /**
     * Create a new HTTPHeader from scratch
     */
    public HTTPFooter(DataInputStream in) throws IOException {
        readHeader(in);
    }

}
