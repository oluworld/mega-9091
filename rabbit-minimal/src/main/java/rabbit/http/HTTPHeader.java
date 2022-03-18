package rabbit.http;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

import rabbit.io.HTTPInputStream;

// $Id: HTTPHeader.java,v 1.5 2005/10/11 19:22:08 olu Exp $

/**
 * A class to handle a HTTPHeader.
 */
public class HTTPHeader extends GeneralHeader {
	/**
	 * @serial
	 */
	private String line;                      // the request- or statusline
	/**
	 * @serial
	 */
	private String method = "";
	/**
	 * @serial
	 */
	private String requestURI = "";
	/**
	 * @serial
	 */
	private String httpVersion = null;
	/**
	 * @serial
	 */
	private String content = null;              // the content of the request/response (mostly not set for responses).
	private HTTPInputStream contentStream = null;

	/**
	 * Create a new HTTPHeader from scratch
	 */
	public HTTPHeader() {
	}

	/**
	 * Read in a HTTPHeader from an inputstream.
	 *
	 * @param in the stream from which this header is read.
	 * @throws IOException if reading from in results in exceptions.
	 */
	public HTTPHeader(DataInputStream in) throws IOException {
		readHTTPHeader(in);
	}

	public void readHTTPHeader(DataInputStream in) throws IOException {
		do {
			line = readLine(in);
			if (line == null)
				throw new IOException("Couldnt read requestline, connection prolly closed");
		} while (line.length() == 0);   // empty string
		setRequestLine(line);

		if (!isDot9Request()) {
			String msg;

			// ok, allow for some evil webservers (Domino) that allow this...
			msg = readLine(in);
			char ch;
			while (msg != null &&
			        msg.length() > 0 &&
			        ((ch = msg.charAt(0)) == ' ' ||
			        ch == '\t')) {
				setReasonPhrase(getReasonPhrase() + msg);
				msg = readLine(in);
			}
			super.readHeader(in, msg);
		}
	}

	/**
	 * get the text value of this header
	 *
	 * @return a String describing this HTTP-Header.
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer(getRequestLine());
		ret.append(CRLF);
		ret.append(super.toString());
		if (content != null)
			ret.append(content);

		return ret.toString();
	}

	/**
	 * Get the statusline of this header (only valid for responses).
	 *
	 * @return the status of the request.
	 */
	public String getStatusLine() {
		return getRequestLine();
	}

	/**
	 * Set the statusline of this header.
	 *
	 * @param aLine a Status-Line )RFC 2068: 6.1)
	 */
	public void setStatusLine(String aLine) {
		setRequestLine(aLine);
	}

	/**
	 * Get the requestline of this header (only valid for requests).
	 *
	 * @return the request.
	 */
	public String getRequestLine() {
		return method + ' ' + requestURI + (httpVersion != null ? ' ' + httpVersion : "");
	}

	/**
	 * Set the requestline of this header
	 *
	 * @param aLine a Request-Line (RFC 2068: 5.1)
	 */
	public void setRequestLine(String aLine) {
		line = aLine;
		int s1 = line.indexOf(' ');
		if (s1 < 0) {
			method = line;
			return;
		}
		int s2 = line.indexOf(' ', s1 + 1);
		method = line.substring(0, s1);
		if (s2 > 0) {
			requestURI = line.substring(s1 + 1, s2);
			httpVersion = line.substring(s2 + 1).trim();
		} else {
			requestURI = line.substring(s1 + 1);
			httpVersion = null;
		}
	}

	/**
	 * Is this request for the head only?
	 *
	 * @return true if this request is for HEAD, false otherwise
	 */
	public boolean isHeadOnlyRequest() {
		return method.equals("HEAD");     // method is casesensitive.
	}

	/**
	 * Get the request method of this header (only valid for requests).
	 *
	 * @return the request method.
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * Sets the request method of this header
	 *
	 * @param aMethod the new requestmethod
	 */
	public void setMehtod(String aMethod) {
		method = aMethod;
	}

	/**
	 * Get the requestURI of this request (only valid for requests).
	 *
	 * @return the requestURI.
	 */
	public String getRequestURI() {
		return requestURI;
	}

	/**
	 * Sets the request URI of this header
	 *
	 * @param aRequestURI the new URI
	 */
	public void setRequestURI(String aRequestURI) {
		requestURI = aRequestURI;
	}

	/**
	 * Get the HTTP Version of this request (only valid for requests).
	 *
	 * @return the http version.
	 */
	public String getHTTPVersion() {
		return httpVersion;
	}

	/**
	 * Set the HTTP Version to use for request.
	 *
	 * @param version the version to use.
	 */
	public void setHTTPVersion(String version) {
		httpVersion = version;
	}

	/**
	 * Get the HTTP version of the response (only valid for responses).
	 *
	 * @return the HTTP version.
	 */
	public String getResponseHTTPVersion() {
		return method;
	}

	/**
	 * Set the HTTP version for this response.
	 *
	 * @param httpVersion the version to use.
	 */
	public void setResponseHTTPVersion(String httpVersion) {
		method = httpVersion;
	}

	/**
	 * Get the Status code of the response (only valid for responses).
	 *
	 * @return the status code.
	 */
	public String getStatusCode() {
		return requestURI;
	}

	/**
	 * Set the Status code for this response.
	 *
	 * @param status the new status code.
	 */
	public void setStatusCode(String status) {
		requestURI = status;
	}

	/**
	 * Get the Reason phrase of the response (only valid for responses).
	 *
	 * @return the reason phrase.
	 */
	public String getReasonPhrase() {
		return httpVersion;
	}

	/**
	 * Set the reason phrase for this reqponse.
	 *
	 * @param reason the new reasonphrase
	 */
	public void setReasonPhrase(String reason) {
		httpVersion = reason;
	}

	/**
	 * Set the Content for the request/response
	 * Mostly not used for responses.
	 * As a side effect the &quot;Content-Length&quot; header is also set.
	 *
	 * @param aContent the binary content.
	 */
	public void setContent(String aContent) {
		content = aContent;
		setHeader("Content-Length", "" + content.length());
	}

	/**
	 * Set the content for the request/response
	 * This is a way to set up handling of a chunked input request
	 * As a side effect the &quot;Transer-Encoding&quot; header is also set.
	 *
	 * @param ain the binary content.
	 */
	public void setContentStream(HTTPInputStream ain) {
		contentStream = ain;
	}

	public HTTPInputStream getContentStream() {
		return contentStream;
	}

	/**
	 * Get the content of the request/response.
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Is this request a HTTP/0.9 type request?
	 * A 0.9 request doesnt have a full HTTPheader, only a requestline
	 * so we need to treat it differently.
	 */
	public boolean isDot9Request() {
		return httpVersion == null;
	}

	/**
	 * Get the hashCode for this header.
	 *
	 * @return the hash code for this object.
	 */
	public int hashCode() {
		return getRequestURI().hashCode();
	}

	/**
	 * Is this Header equal to the other object?
	 * Two HTTPHeaders are assumed equal if the requesURI's are equal.
	 *
	 * @param o the Object to compare to.
	 * @return true if o and this object are equal, false otherwise.
	 */
	public boolean equals(Object o) {
		if (o instanceof HTTPHeader)
			return getRequestURI().equals(((HTTPHeader) o).getRequestURI());
		return false;
	}

	/**
	 * Try to guess if this header is a request.
	 *
	 * @return true if this (probably) is a request, false otherwise.
	 */
	public boolean isRequest() {
		return !isResponse();
	}

	/**
	 * Try to guess if this header is a response.
	 *
	 * @return true if this (probably) is a response, false otherwise.
	 */
	public boolean isResponse() {
		return (getResponseHTTPVersion() != null &&
		        getResponseHTTPVersion().toLowerCase().startsWith("http/"));
	}

	/**
	 * Try to guess if this header is a secure thing.
	 *
	 * @return true if this (probably) is a secure connection.
	 */
	public boolean isSecure() {
		return (getMethod() != null &&
		        getMethod().equals("CONNECT"));
	}

	public static HTTPHeader From(HTTPInputStream in) throws IOException {
		return in.readHTTPHeader();
	}

	public List<Header> copyOfHeaders() {
		return new Vector<Header>(headers);
	}

	/**
	 * Loop over all headers
	 *
	 * @param fun specifies a predicate that can terminate the loop
	 */
	public void iterateHeaders(final BinaryFunctor fun) {
		for (Header h : copyOfHeaders())
			if (!fun.call(h.type, h.value)) return;
	}
}
