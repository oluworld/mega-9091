/* FileVersaStream -- Returns a VersaStream from a local file.Portions of this software are Copyright (c) 2001, Elifarley Callado Coelho -http://www.geocities.com/elifarley/LicenseRedistribution and use in source and binary forms,with or without modification, are permitted provided thatthe following conditions are met:*	Redistributions of source code must retain the abovecopyright notice, this list of conditions and the followingdisclaimer. *	Redistributions in binary form must reproduce the abovecopyright notice, this list of conditions and the followingdisclaimer in the documentation, about box and/or othermaterials provided with the distribution. *	No personal names or organizations names associatedwith the Indy project may be used to endorse or promoteproducts derived from this software without specific priorwritten permission of the specific individual ororganization. THIS SOFTWARE IS PROVIDED BY ITS AUTHOR (ELIFARLEY CALLADO COELHO) "AS IS'' AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.   */ package elifarley.io;import java.io.RandomAccessFile;import java.io.IOException;import java.io.File;//import java.io.FileDescriptor;public class FileVersaStream extends VersaStream {		//private FileDescriptor fd;	private RandomAccessFile raf;	private boolean canWrite = false;		public FileVersaStream(String name, String mode) throws IOException {		raf = new RandomAccessFile(name, mode);		this.canWrite = mode.toLowerCase().indexOf('w') != -1;		/*		boolean rw = mode.equals("rw");		if (!rw && !mode.equals("r"))			throw new IllegalArgumentException("mode must be r or rw");		SecurityManager security = System.getSecurityManager();		if (security != null) {		    security.checkRead(name);		    if (rw) {			security.checkWrite(name);		    }		}		fd = new FileDescriptor();		open(name, rw);		*/	}	    public FileVersaStream(File file, String mode) throws IOException {		this(file.getPath(), mode);    }	public int read() throws IOException {		return raf.read();	}		    public int read(byte b[], int off, int len) throws IOException {		return raf.read(b, off, len);		//return readBytes(b, off, len);	}	    public int read(byte b[]) throws IOException {		return raf.read(b, 0, b.length);		//return readBytes(b, 0, b.length);    }    /*    public int skipBytes(int n) throws IOException {        seek(getFilePointer() + n);        return n;    }	*/	    public void write(byte b[], int off, int len) throws IOException {		raf.write(b, off, len);		//writeBytes(b, off, len);    }    public void write(byte b[]) throws IOException {		raf.write(b, 0, b.length);		//writeBytes(b, 0, b.length);     }    public void write(int i) throws IOException{		//System.out.println("RAF will write " + i + " ("+ Integer.toHexString(i)+") at " + raf.getFilePointer());		raf.write(i);	}        public boolean canRead() {    	return true;    }    public boolean canWrite() {    	    	return canWrite;    }    public boolean canSeekBackwards() {    	return true;    }    public boolean canSeekForward() {    	return true;    }    public boolean canSeekFromEnd() {    	return true;    }    public boolean canSetSize() {    	return false; // can't set size for now    }	public long seek(long offset, short origin) throws IOException {		long newPos;				switch(origin){			case FROM_BEGINNING: newPos = offset; break;			case FROM_CURRENT: newPos = raf.getFilePointer() + offset; break;			case FROM_END: newPos = raf.length() + offset; break;			default: throw new IOException("Invalid origin: " + origin);		}				//if (newPos < 0) newPos = 0;		if (newPos < 0) throw new IOException("Can't position stream at " + newPos);		if (raf.getFilePointer() != newPos) raf.seek(newPos);		return newPos;	}		public long getSize() throws IOException {		return raf.length();	}	public void setSize(long newSize) throws IOException {		//raf.setSize(newSize);		throw new CannotSetSizeException();	}		public long getPosition() throws IOException {		return raf.getFilePointer();	}		public void setPosition(long pos) throws IOException {		if (pos < 0) throw new IOException("Can't position stream at " + pos);		raf.seek(pos);		}    public boolean markSupported() {		return true;    }    //public native void close() throws IOException;    public void close() throws IOException {    	raf.close();    }	/*    public final FileDescriptor getFD() throws IOException {		if (fd != null) return fd;		throw new IOException();    }	*/	    /*    private native void open(String name, boolean writeable) throws IOException;    private native int readBytes(byte b[], int off, int len) throws IOException;    public native int read() throws IOException;    public native void seek(long pos) throws IOException;    public native void write(int b) throws IOException;    private native void writeBytes(byte b[], int off, int len) throws IOException;    public native long length() throws IOException;    public native long getFilePointer() throws IOException;	*/	}