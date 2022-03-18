/*CopyrightPortions of this software are Copyright (c) 1993 -2001, Chad Z. Hower (Kudzu) and the Indy Pit Crew -http://www.nevrona.com/Indy/Portions of this software are Copyright (c) 2001, Elifarley Callado Coelho -http://www.geocities.com/elifarley/LicenseRedistribution and use in source and binary forms,with or without modification, are permitted provided thatthe following conditions are met:*	Redistributions of source code must retain the abovecopyright notice, this list of conditions and the followingdisclaimer. *	Redistributions in binary form must reproduce the abovecopyright notice, this list of conditions and the followingdisclaimer in the documentation, about box and/or othermaterials provided with the distribution. *	No personal names or organizations names associatedwith the Indy project may be used to endorse or promoteproducts derived from this software without specific priorwritten permission of the specific individual ororganization. THIS SOFTWARE IS PROVIDED BY Chad Z. Hower (Kudzu) and theIndy Pit Crew "AS IS'' AND ANY EXPRESS OR IMPLIEDWARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIEDWARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULARPURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE REGENTS ORCONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUTNOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER INCONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OROTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THISSOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.*/package elifarley.jandy;import elifarley.io.VersaStream;import elifarley.io.OutputStreamVersaStream;import elifarley.util.StringListVector;import elifarley.util.NameValueString;import java.util.Enumeration;import java.io.IOException;import java.net.URL;public class HTTPResponseInfo implements Messages{    protected static final String HTTP_VERSION = "HTTP/1.0";	//protected HTTPSession session;		protected String serverSoftware, authRealm, responseText, contentType; 	//protected TCPServerConnection connection;	protected VersaStream remoteStream;	protected boolean headerHasBeenWritten = false;	protected boolean connectionKeepAlive = false;	protected boolean isProxy = false;	protected boolean hasBeenSent = false;	protected boolean triedToWriteContent = false;	protected int responseNo, contentLength; 	protected StringListVector cookies = new StringListVector();	protected StringListVector headers = new StringListVector();    protected VersaStream contentStream;    protected String contentText;		public HTTPResponseInfo( VersaStream remoteStream) {		setServerSoftware("ECC" + '/' + "1.0");		setContentType("text/html");		setContentLength(-1);		this.remoteStream = remoteStream;		setResponseNo(200);	}	public String getAuthRealm() {		return new String(authRealm);	}		public void setAuthRealm(String value) {		authRealm = value.trim();	}	public VersaStream getContentStream() {		return contentStream;	}		public void setContentStream(VersaStream value) {		contentStream = value;	}	public String getContentText() {		return new String(contentText);	}		public void setContentText(String value) {		contentText = new String(value);	}	public boolean getHeaderHasBeenWritten() {		return headerHasBeenWritten;	}	public boolean getConnectionKeepAlive() {		return connectionKeepAlive;	}	public void setConnectionKeepAlive(boolean value) {		connectionKeepAlive = value;	}	public boolean getIsProxy() {		return isProxy;	}	public void setIsProxy(boolean value) {		isProxy = value;	}	public boolean getHasBeenSent() {		return hasBeenSent;	}	public void setHasBeenSent(boolean value) {		hasBeenSent = value;	}	public boolean getTriedToWriteContent() {		return triedToWriteContent;	}	public void setTriedToWriteContent(boolean value) {		triedToWriteContent = value;	}	public int getResponseNo() {		return responseNo;	}		public void setResponseNo(int value) {		responseNo = value;		switch (responseNo) {			// 1xx: Informational            case 100: responseText = "Continue"; break;            case 101: responseText = "Switching Protocols"; break;						// 2xx: Success			case 200: responseText = RSHTTPOK; break;			case 201: responseText = RSHTTPCreated; break;			case 202: responseText = RSHTTPAccepted; break;			case 203: responseText = RSHTTPNonAuthoritativeInformation; break;			case 204: responseText = RSHTTPNoContent; break;			case 205: responseText = RSHTTPResetContent; break;			case 206: responseText = RSHTTPPartialContent; break;			// 3xx: Redirections			case 301: responseText = RSHTTPMovedPermanently; break;			case 302: responseText = RSHTTPMovedTemporarily; break;			case 303: responseText = RSHTTPSeeOther; break;			case 304: responseText = RSHTTPNotModified; break;			case 305: responseText = RSHTTPUseProxy; break;			case 307: responseText = "Temporary Redirect"; break;			// 4xx Client Errors			case 400: responseText = RSHTTPBadRequest; break;			case 401: responseText = RSHTTPUnauthorized; break;			case 403: responseText = RSHTTPForbidden; break;			case 404: responseText = RSHTTPNotFound; break;			case 405: responseText = RSHTTPMethodNotAllowed; break;			case 406: responseText = RSHTTPNotAcceptable; break;			case 407: responseText = RSHTTPProxyAuthenticationRequired; break;			case 408: responseText = RSHTTPRequestTimeout; break;			case 409: responseText = RSHTTPConflict; break;			case 410: responseText = RSHTTPGone; break;			case 411: responseText = RSHTTPLengthRequired; break;			case 412: responseText = RSHTTPPreconditionFailed; break;			case 413: responseText = RSHTTPRequestEntityToLong; break;			case 414: responseText = RSHTTPRequestURITooLong; break;			case 415: responseText = RSHTTPUnsupportedMediaType; break;			case 416: responseText = "Requested range not satisfiable"; break;			case 417: responseText = "Expectation Failed"; break;			// 5xx Server errors			case 500: responseText = RSHTTPInternalServerError; break;			case 501: responseText = RSHTTPNotImplemented; break;			case 502: responseText = RSHTTPBadGateway; break;			case 503: responseText = RSHTTPServiceUnavailable; break;			case 504: responseText = RSHTTPGatewayTimeout; break;			case 505: responseText = RSHTTPHTTPVersionNotSupported; break;			default: responseText = RSHTTPUnknownResponseCode; break;		}			} 	public String getResponseText() {		return new String(responseText);	}		public void setResponseText(String value) {		responseText = value.trim();	} 	public int getContentLength() {		return contentLength;	}		public void setContentLength(int value) {		contentLength = value;	} 	public String getContentType() {		return new String(contentType);	}		public void setContentType(String value) {		contentType = value.trim();	} 	public String getServerSoftware() {		return new String(serverSoftware);	}		public void setServerSoftware(String value) {		serverSoftware = value.trim();	}   //property Session: TIdHTTPSession read FSession;    //property Cookies: Tstrings read FCookies write SetCookies;    //property Headers: TStrings read FHeaders write SetHeaders;    //	/*  protected    procedure SetCookies(const AValue: TStrings);    procedure SetHeaders(const AValue: TStrings);  public    //  }*/	public void send() {		try {			if (!getHeaderHasBeenWritten()) writeHeader(null);			if (!getHasBeenSent()) {				writeContent();				if (!getHasBeenSent() && getTriedToWriteContent()) {					System.err.println("Could not send content to stream");				}			}		} catch (Exception e) {			e.printStackTrace();			try {				writeHeader(new OutputStreamVersaStream(System.out));			} catch (Exception e2) {}		}					}	public void writeHeader(VersaStream outStream) throws Exception {		VersaStream os = outStream != null ? outStream : remoteStream;	  		  	if (getHeaderHasBeenWritten()) {	    	throw new Exception(RSHTTPHeaderAlreadyWritten);	  	}	  		  	// Prepare headers	  	headers.setValue("Server", getServerSoftware(), ':' );	  	headers.setValue("Content-Type", getContentType(), ':' );		int cLen = -1;				// Try to determine content-length		if (getContentLength() > -1) {			cLen = getContentLength();		} else {			if (contentStream != null) {				if (contentStream.canSeekFromEnd()) {					//long p = contentStream.getPosition();					cLen = contentStream.available();				}			} else {				if (contentText != null) {					cLen = contentText.length();				}			}		}		if (cLen > -1) {			headers.setValue("Content-Length", Integer.toString(cLen), ':' );		}			  	if (authRealm != null && authRealm.length() > 0) {	    	setResponseNo(401);	    	headers.setValue("WWW-Authenticate", "Basic realm=\"" + authRealm + '"', ':');	  	}	  	headers.setValue( (getIsProxy() ? "Proxy-" : "") + "Connection", getConnectionKeepAlive() ? "keep-alive" : "close", ':' );	    // Write HTTP status response	    //System.out.print( "response: " + HTTP_VERSION + ' ' + Integer.toString(getResponseNo()) + ' ' + getResponseText() + NET_NEWLINE);	    os.writeBytes(HTTP_VERSION + ' ' + Integer.toString(getResponseNo()) + ' ' + getResponseText() + NET_NEWLINE);	    	    NameValueString tempNVS;	    	    // Write cookies	    for (int i = 0; i < cookies.size() ; i++) {	    	tempNVS = (NameValueString)cookies.elementAt(i);	    	//System.out.print( "response: " + "Set-Cookie: " + tempNVS.toString() + NET_NEWLINE);	    	os.writeBytes("Set-Cookie: " + tempNVS.toString() + NET_NEWLINE);	    }	    	    // Write headers	    for (int i = 0; i < headers.size() ; i++) {	    	tempNVS = (NameValueString)headers.elementAt(i);	    	//System.out.print( "response: " + tempNVS.name() + ": " + tempNVS.value().toString() + NET_NEWLINE);	    	os.writeBytes(tempNVS.name() + ": " + tempNVS.value().toString() + NET_NEWLINE);	    }	    	    // HTTP headers ends with a double CR+LF	    os.writeBytes(NET_NEWLINE);	  	headerHasBeenWritten = true;    	}	public void writeContent() {		// only send data back if the response is OK or if a client error occured.	  		  	if (getResponseNo() >= 200 && getResponseNo() < 500) {	  		if (contentStream != null) {	        	try {	        		setTriedToWriteContent(true);	        		//contentStream.copyTo(remoteStream, getContentLength() > 0 ? getContentLength() : 0);	        		remoteStream.copyFrom(contentStream, getContentLength() > 0 ? getContentLength() : 0);	      			setHasBeenSent(true);	      		} catch(IOException ioe) {	      			ioe.printStackTrace();	      			try {	      				remoteStream.writeBytes("<P><B>" + ioe.toString() + "</B><P>");	      			} catch (IOException ioe2) {	      				ioe2.printStackTrace();	      			}	      		}	      			      			      	} else if (contentText != null && contentText.length() > 0 ) {		       	try {		        	setTriedToWriteContent(true);		        	remoteStream.writeBytes(contentText);		        	contentText = null;		        	setHasBeenSent(true);	      		} catch (IOException ioe) {	      			ioe.printStackTrace();	      			try {	      				remoteStream.writeBytes("<P><B>" + ioe.toString() + "</B><P>");	      			} catch (IOException ioe2) {	      				ioe2.printStackTrace();	      			}	      		}	      	}	    }  else {	    	try {	    		remoteStream.writeBytes( "<B>" + getResponseNo() + ' ' + getResponseText() + "</B><P>" + ( (contentText == null) ? "" : contentText ) );	 			setHasBeenSent(true);	 		} catch(IOException ioe) {	 			ioe.printStackTrace();	 			try {	 				remoteStream.writeBytes("<P><B>" + ioe.toString() + "</B><P>");	 			} catch (IOException ioe2) {	 				ioe2.printStackTrace();	 			}			}  		  	}		// Now let's close the remoteStream		try {			remoteStream.close();		} catch (IOException ioe) {			ioe.printStackTrace();		}	}	}