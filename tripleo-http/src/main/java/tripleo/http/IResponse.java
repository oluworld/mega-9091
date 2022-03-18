/*
 * Created on Feb 21, 2004
 * 
 * $Id: IResponse.java,v 1.5 2005/10/11 19:22:08 olu Exp $
 *
 */
package tripleo.http;

import java.io.IOException;
import java.util.List;

public interface IResponse {

	/** Each response is to a particular request
	 * @return the assocaited request object
	 */
	IRequest getRequest();

	IResponse setHeader(String name, String value);
	IResponse addHeader(String name, String value);
	//
	
	/**
	 * Reset the contetn stream
	 * 
	 * @param cs What we now want it to be
	 * @return self (to chain
	 */
	IResponse setContent(CharSequence cs);

	CharSequence getContent() throws IOException;

	/**
	 * Add some text to the end of our content
	 * 
	 * @param cs What to add
	 * @return self (to chain
	 */
	IResponse append(CharSequence cs);
	
	/**
	 * Each response is associated with a channel.
	 * This method sends the header and content over that channel
	 * @throws HttpException 
	 */
	void send() throws HttpException;

	IResponse firstline(String aMethod, int aCode, String aCodeString);

	String firstline();

	List<IHeader> copyOfHeaders();
}
