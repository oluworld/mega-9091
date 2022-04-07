/* ReaderVersaStream -- Returns a VersaStream from a Reader.Portions of this software are Copyright (c) 2001, Elifarley Callado Coelho -http://www.geocities.com/elifarley/LicenseRedistribution and use in source and binary forms,with or without modification, are permitted provided thatthe following conditions are met:*	Redistributions of source code must retain the abovecopyright notice, this list of conditions and the followingdisclaimer. *	Redistributions in binary form must reproduce the abovecopyright notice, this list of conditions and the followingdisclaimer in the documentation, about box and/or othermaterials provided with the distribution. *	No personal names or organizations names associatedwith the Indy project may be used to endorse or promoteproducts derived from this software without specific priorwritten permission of the specific individual ororganization. THIS SOFTWARE IS PROVIDED BY ITS AUTHOR (ELIFARLEY CALLADO COELHO) "AS IS'' AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.   */ package elifarley.io;import java.io.IOException;import java.io.Reader;public class ReaderVersaStream extends VersaStream {		private final Reader in;	private long pos = 0;		public ReaderVersaStream(Reader in) throws IOException {		this.in = in;	}		public int read() throws IOException {		int n = in.read();		if (n != -1) pos++;		return n;	}		    public int read(byte b[], int off, int len) throws IOException {		char cbuff[] = new char[len];		len = in.read(cbuff, off, len);		if (len != -1) pos += len;		new String(cbuff).getBytes(0, len, b, 0);		return len;	}		public void write(int b) throws IOException {		throw new IOException("Writing not allowed");	}	public long seek(long offset, short origin) throws IOException {		long newPos;				switch(origin){			case FROM_BEGINNING: newPos = offset; break;			case FROM_CURRENT: newPos = pos + offset; break;			case FROM_END: newPos = pos + offset; break; // Should we throw an exception here?			default: throw new IOException("Invalid origin: " + origin);		}				if (newPos > pos) {			pos += in.skip(newPos - pos);		}		else			if (newPos < pos) {				in.reset();				pos = in.skip(newPos);			}				if (pos != newPos) throw new IOException("Tried to seek to " + newPos + " but could seek only to " + pos);				return pos;	}		public void setSize(long newSize) throws IOException {		//raf.setSize(newSize);		throw new IOException("Can't set size on a Reader");	}    public boolean canRead() {    	return true;    }    public boolean canWrite() {    	return false;    }    public boolean canSeekFromEnd() {    	return false;    }    public boolean canSeekBackwards() {    	return in.markSupported(); // ?    }    public boolean canSeekForward() {    	return true;    }    public boolean canSetSize() {    	return false;    }    public boolean markSupported() {		return in.markSupported();    }	public synchronized void mark(int readLimit) {		try {			in.mark(readLimit);			} catch (IOException ioe) {		}			}    public synchronized void reset() throws IOException {		in.reset();	}	public void close() throws IOException {		in.close();	}		}