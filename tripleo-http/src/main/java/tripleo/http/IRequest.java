/*
 * Created on Feb 21, 2004
 *
 */
package tripleo.http;

import java.nio.ByteBuffer;
import java.util.List;

public interface IRequest {

    String getUri();

    List getHeaders();

    ByteBuffer getContent();

    String version();

    List<IHeader> copyOfHeaders();

    String requestLine();

    IHTTPRequestLine getRequestLine();

}
