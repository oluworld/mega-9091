/* URLVersaStream -- Returns a VersaStream from a URL.Portions of this software are Copyright (c) 2001, Elifarley Callado Coelho -http://www.geocities.com/elifarley/LicenseRedistribution and use in source and binary forms,with or without modification, are permitted provided thatthe following conditions are met:*	Redistributions of source code must retain the abovecopyright notice, this list of conditions and the followingdisclaimer. *	Redistributions in binary form must reproduce the abovecopyright notice, this list of conditions and the followingdisclaimer in the documentation, about box and/or othermaterials provided with the distribution. *	No personal names or organizations names associatedwith the Indy project may be used to endorse or promoteproducts derived from this software without specific priorwritten permission of the specific individual ororganization. THIS SOFTWARE IS PROVIDED BY ITS AUTHOR (ELIFARLEY CALLADO COELHO) "AS IS'' AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.  */ package elifarley.io;import java.io.IOException;import java.io.InputStream;import java.net.URL;import java.net.URLConnection;import java.net.HttpURLConnection;import java.util.*;public class URLVersaStream extends VersaStream {		private URL url;	private long pos = 0;	protected InputStream in;	public Hashtable URLProperties;		public URLVersaStream(String url) throws IOException {		this.url = new URL(url);		reset();	}	    public boolean canRead() {    	return true;    }    public boolean canWrite() {    	return false; // for now    }    public boolean canSeekFromEnd() {    	return false;    }    public boolean canSeekBackwards() {    	return in.markSupported();    }    public boolean canSeekForward() {    	return true;    }    public boolean canSetSize() {    	return false;    }	public long seek(long offset, short origin) throws IOException {		long newPos;				switch(origin){			case FROM_BEGINNING: newPos = offset; break;			case FROM_CURRENT: newPos = pos + offset; break;			case FROM_END: throw new CannotSeekToEndException(); //newPos = pos + offset; break; // Should we throw an exception here?			default: throw new IOException("Invalid origin: " + origin);		}				if (newPos > pos) {			pos += in.skip(newPos - pos);		}		else			if (newPos < pos) {				//in.reset();				this.reset();				pos = in.skip(newPos);			}				if (pos != newPos) throw new IOException("Tried to seek to " + newPos + " but could seek only to " + pos);				return pos;	}		public void setSize(long newSize) throws IOException {		throw new CannotSetSizeException("Can't set size on a URL stream yet");	}    public boolean markSupported() {		return in.markSupported();    }	public synchronized void mark(int readLimit) {		in.mark(readLimit);		}    public synchronized void reset() throws IOException {		in = getStream(this.url);		//in.reset();	}		public void close() throws IOException {		in.close();	}    public synchronized void reset(long off) throws IOException {		in = getStream(this.url, off);	}	    protected InputStream getStream(URL page, long off) throws IOException {		URLConnection conn = page.openConnection();		if (conn instanceof HttpURLConnection) {		    HttpURLConnection hconn = (HttpURLConnection) conn;		    //hconn.setInstanceFollowRedirects(false);		    //if (off > 0) hconn.setHeaderField("Range", "bytes=" + off + "-");		    int response = hconn.getResponseCode();		    boolean redirect = (response >= 300 && response <= 399);		    /*		     * In the case of a redirect, we want to actually change the URL		     * that was input to the new, redirected URL		     */		    if (redirect) {			String loc = conn.getHeaderField("Location");			if (loc.startsWith("http", 0)) {			    page = new URL(loc);			} else {			    page = new URL(page, loc);			}			return getStream(page);		    }		}						if (URLProperties == null) {		    URLProperties = new Hashtable();		}						String type = conn.getContentType();		if (type != null) {		    //setContentType(type);		    URLProperties.put("content-type", type);		}		//URLProperties.put(Document.StreamDescriptionProperty, page);		String enc = conn.getContentEncoding();		if (enc != null) {		    URLProperties.put("content-encoding", enc);		}		InputStream in = conn.getInputStream();		return in;    }    protected InputStream getStream(URL page) throws IOException {		return getStream(page, 0);	}	public int read() throws IOException {		int n = in.read();		if (n != -1) pos++;		return n;	}		    public int read(byte b[], int off, int len) throws IOException {		len = in.read(b, off, len);		if (len != -1) pos += len;		return len;	}		public void write(int b) throws IOException {		throw new IOException("Writing not allowed");	}		}