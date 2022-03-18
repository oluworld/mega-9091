package tripleo.http.impl;

import tripleo.http.*;
import tripleo.nio.javanio.StringContent;
import tripleo.nio.javanio.http.*;

/**
 * Date: Aug 18, 2005
 * Time: 7:21:23 PM
 * <p/>
 * $Id: SB_Response.java,v 1.1 2005/10/16 14:16:31 olu Exp $
 */
public class SB_Response extends AbstractResponse {

	public SB_Response(final IRequest a_req) {
		super(null, a_req);
	}

	public void _conduit_write(StringBuilder aXx) throws HttpException {
		_sb=(aXx);
	}

	public StringBuilder sb() { return _sb;}

	private StringBuilder _sb;

	public boolean invariant() {
		return _sb.toString().equals(getContent());
	}

	public Reply createReply() {
		return new Reply(
				new Reply.Code(1000, "GO AWAY"), 
				new StringContent(getContent()), 
				JN_Request.Action.parse("GET")); 
	}
	
}
