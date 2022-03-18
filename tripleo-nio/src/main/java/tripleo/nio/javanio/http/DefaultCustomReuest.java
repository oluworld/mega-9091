package tripleo.nio.javanio.http;

import tripleo.nio.javanio.*;
import tripleo.nio.javanio.http.CustomRequest.CRR;
import tripleo.util.Pair;

import java.nio.ByteBuffer;

/**
 * Date: Oct 16, 2005
 * Time: 8:09:54 AM
 * <p/>
 * $Id: DefaultCustomReuest.java,v 1.1 2005/10/16 14:18:53 olu Exp $
 */
class DefaultCustomReuest implements CustomRequest {

	public boolean parse() {return true;}
	public boolean build() {return true;}

	public CRR parseResult(ByteBuffer rbb) {
		Request request = null;
		Reply   reply   = null;
		//
		try {
			request = JN_Request.parse(rbb);
		} catch (MalformedRequestException x) {
			reply = new Reply(Reply.Code.BAD_REQUEST, new StringContent(x));
		}
		return CRR.make(request, reply, null);
	}

	public Reply buildResult(Request request) {
		JN_Request.Action action = request.action();
/*	    if ((action != Request.Action.GET) &&
			    (action != Request.Action.HEAD)) {
		    reply = new Reply(Reply.Code.METHOD_NOT_ALLOWED,
				    new StringContent(request.toString()));
	    }
	    reply = new Reply(Reply.Code.OK,
			    new FileContent(request.uri()), action);
*/
		final DynamicContent dynamicContent = new DynamicContent(request.uri());
		return new Reply(Reply.Code.OK, dynamicContent, action);
	}
}