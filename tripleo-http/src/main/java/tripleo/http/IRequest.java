/*
 * Created on Feb 21, 2004
 *
 */
package tripleo.http;

import java.nio.ByteBuffer;
import java.util.List;

public interface IRequest {
	public String     getUri() ;
	public List       getHeaders() ;
	public ByteBuffer getContent();
	
	public String version();
	public List<IHeader> copyOfHeaders();
	public String requestLine();
	public IHTTPRequestLine getRequestLine();
	
}