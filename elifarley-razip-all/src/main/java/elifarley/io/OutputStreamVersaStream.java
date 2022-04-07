/* OutputStreamVersaStream -- Returns a VersaStream from an OutputStream.Portions of this software are Copyright (c) 2001, Elifarley Callado Coelho -http://www.geocities.com/elifarley/LicenseRedistribution and use in source and binary forms,with or without modification, are permitted provided thatthe following conditions are met:*	Redistributions of source code must retain the abovecopyright notice, this list of conditions and the followingdisclaimer. *	Redistributions in binary form must reproduce the abovecopyright notice, this list of conditions and the followingdisclaimer in the documentation, about box and/or othermaterials provided with the distribution. *	No personal names or organizations names associatedwith the Indy project may be used to endorse or promoteproducts derived from this software without specific priorwritten permission of the specific individual ororganization. THIS SOFTWARE IS PROVIDED BY ITS AUTHOR (ELIFARLEY CALLADO COELHO) "AS IS'' AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.   */ package elifarley.io;import java.io.IOException;import java.io.OutputStream;public class OutputStreamVersaStream extends VersaStream {		private final OutputStream out;	private long pos = 0;		public OutputStreamVersaStream(OutputStream out) throws IOException {		this.out = out;	}		public int read() throws IOException {		throw new IOException("Reading not allowed");	}				public void write(int b) throws IOException {		out.write(b);		pos++;	}    public void write(byte b[], int off, int len) throws IOException {		out.write(b, off, len);		pos += len;	}		public long seek(long offset, short origin) throws IOException {		long newPos;				switch(origin){			case FROM_BEGINNING: newPos = offset; break;			case FROM_CURRENT: newPos = pos + offset; break;			case FROM_END: throw new CannotSeekToEndException();//newPos = pos + offset; break; // Should we throw an exception here?			default: throw new IOException("Invalid origin: " + origin);		}						if (pos != newPos) throw new IOException("Seek is allowed only to the current position");				return pos;	}	    public boolean canRead() {    	return false;    }    public boolean canWrite() {    	return true;    }    public boolean canSeekFromEnd() {    	return false;    }    public boolean canSeekBackwards() {    	return false;    }    public boolean canSeekForward() {    	return false;    }	public synchronized long getSize() throws IOException {		return pos;	}	public void setSize(long newSize) throws IOException {		throw new CannotSetSizeException();	}	public synchronized void mark(int readLimit) {			}    public void flush() throws IOException {		out.flush();	}		public void close() throws IOException {		out.close();	}		}