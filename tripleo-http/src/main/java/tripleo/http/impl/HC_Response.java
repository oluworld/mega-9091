/*
 * Created on Oct 9, 2005 1:07:28 AM
 * 
 * $Id: HC_Response.java,v 1.1 2005/10/16 14:16:31 olu Exp $
 *
 */
package tripleo.http.impl;

import java.io.IOException;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import tripleo.http.*;
import tripleo.util.Assert;

public class HC_Response implements IResponse {

	private final GetMethod carrier;
	private final HttpClient client;
	private int code_;

	public HC_Response(HttpClient aHttpClient, GetMethod aGetmeth) {
		client=aHttpClient;
		carrier=aGetmeth;
	}

	public IRequest getRequest() {
		Assert.not_implemented();
		return null;
	}

	public IResponse setHeader(String aName, String aValue) {
		carrier.addRequestHeader(aName,aValue);
		return this;
	}

	public IResponse addHeader(String aName, String aValue) {
		// TODO??
		carrier.addRequestHeader(aName,carrier.getRequestHeader(aName)+" "+aValue);
		return this;
	}

	public IResponse setContent(CharSequence aCs) {
		Assert.not_reached();
		return this;
	}

	public IResponse append(CharSequence aCs) {
		Assert.not_reached();
		return this;
	}

	public void send() throws HttpException {
		try {
			code_ = client.executeMethod(carrier);
		} catch (IOException e) {
			throw HttpException.wrap(e);
//		} catch (org.apache.commons.httpclient.HttpException e) {
//			throw HttpException.wrap(e);
		}
	}

	public IResponse firstline(String aMethod, int aCode, String aCodeString) {
		Assert.not_reached();
		return this;
	}

	public String firstline() {
		boolean somethingOrOther=true;
		assert somethingOrOther;
		return String.format("%s %d %s", carrier.getName(), code_, carrier.getStatusText());
	}

	public List<IHeader> copyOfHeaders() {
		Assert.not_implemented();
		return null;
	}

	public CharSequence getContent() throws IOException {
		// TODO: plz chk this. mb make "once" function?
		return carrier.getResponseBodyAsString();
	}

}
