/*
 * Created on Aug 18, 2005 5:22:41 PM
 * 
 * $Id: OS_Response.java,v 1.1 2005/10/16 14:16:31 olu Exp $
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package tripleo.http.impl;

import java.io.*;

import tripleo.http.*;


public class OS_Response extends AbstractResponse {

	private OS_Response() {	super(null, null); }
	
	public OS_Response(final OutputStream a_conduit, final IRequest a_req) {
		super(a_conduit, a_req);
	}

        @Override
	public void _conduit_write(StringBuilder aXx) throws HttpException {
		byte[] bytes = aXx.toString().getBytes(); // ascii-7

		try {
			_conduit.write(bytes);
		} catch (IOException e) {
			throw HttpException.wrap(e);
		}
	}

}
