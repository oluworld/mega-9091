/**
 * 
 */
package tripleo.http.impl;

import rabbit.http.HTTPHeader;
import tripleo.http.IHTTPRequestLine;

public final class DefaultHeaderLine implements IHTTPRequestLine {
	private final HTTPHeader _header;

	public DefaultHeaderLine(HTTPHeader aHeader) {
		this._header = aHeader;
	}

	public String method() {
		return _header.getMethod();
	}

	public String version() {
		return _header.getHTTPVersion();
	}

	public String uri() {
		return _header.getRequestURI();
	}
	
}
