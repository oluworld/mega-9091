/* VersaStream -- Provides a stream of bytes which can be read and written to in random order.Portions of this software are Copyright (c) 2001, Elifarley Callado Coelho -http://www.geocities.com/elifarley/LicenseRedistribution and use in source and binary forms,with or without modification, are permitted provided thatthe following conditions are met:*	Redistributions of source code must retain the abovecopyright notice, this list of conditions and the followingdisclaimer. *	Redistributions in binary form must reproduce the abovecopyright notice, this list of conditions and the followingdisclaimer in the documentation, about box and/or othermaterials provided with the distribution. *	No personal names or organizations names associatedwith the Indy project may be used to endorse or promoteproducts derived from this software without specific priorwritten permission of the specific individual ororganization. THIS SOFTWARE IS PROVIDED BY ITS AUTHOR (ELIFARLEY CALLADO COELHO) "AS IS'' AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.   */ package elifarley.io;import elifarley.util.StreamUtil;import java.io.DataInput;import java.io.DataInputStream;import java.io.DataOutput;import java.io.EOFException;import java.io.IOException;import java.io.InputStream;import java.io.OutputStream;import java.io.Reader;import java.io.UTFDataFormatException;import java.io.Writer;public abstract class VersaStream implements VersaStreamConstants, DataInput, DataOutput {    private String newLine = NEWLINE_UNIX;     private long fMark = 0;    //private int readLimit = Integer.MAX_VALUE;	protected short accessPriority = AP_DEFAULT;	protected short compressionFormat = CF_NONE;		public abstract long seek(long offset, short origin) throws IOException;	public abstract int read() throws IOException;	public abstract void write(int b) throws IOException;	public abstract void setSize(long newSize) throws IOException;	public void close() throws IOException {}	public void flush() throws IOException {}	protected void finalize() {		try{			close();		} catch (IOException ioe) {			ioe.printStackTrace();		}	}		public short getCompressionFormat() {		return compressionFormat;	}	public short getAccessPriority() {		return accessPriority;	}		public void setAccessPriority(short pri) {		if (accessPriority == pri) return;		switch(pri) {			case AP_DEFAULT: break;			case AP_SEQUENTIAL: break;			case AP_RANDOM: break;			default: throw new IllegalArgumentException("Invalid access priority: " + pri);		}				accessPriority = pri;	}	    public int available() throws IOException {		return (int) (getSize() - getPosition());    }    public boolean canRead() {    	return false;    }    public boolean canWrite() {    	return false;    }    public boolean canSeekFromEnd() {    	return false;    }    public boolean canSeekBackwards() {    	return false;    }    public boolean canSeekForward() {    	return false;    }    public boolean canSetSize() {    	return false;    }    public boolean markSupported() {		return false;    }	public synchronized void mark(int readLimit) {    	    	try {    		fMark = getPosition();    	}    	catch (Exception e) {    		e.printStackTrace();    	}    	    	//this.readLimit = readLimit;	}        public synchronized void reset() throws IOException {		//if (getPosition() - fMark > readLimit) throw new IOException("readLimit exceeded");		setPosition(fMark);    }	public long getPosition() throws IOException {		return seek(0, FROM_CURRENT);		}		public void setPosition(long pos) throws IOException {		seek(pos, FROM_BEGINNING);	}	public synchronized long getSize() throws IOException {		long pos = getPosition(); //seek(0, FROM_CURRENT);	  	long result = seek(0, FROM_END);	  	setPosition(pos); //seek(pos, FROM_BEGINNING);  		return result;	}			public String getNewLine() {		return newLine;	}		public void setNewLine(String nl) {		newLine = new String(nl);	}	    public VersaStreamInputStream getInputStream(long pos, long maxLen) throws IOException {    	return new VersaStreamInputStream(this, pos, maxLen);    }    public VersaStreamInputStream getInputStream(long pos) throws IOException {    	return new VersaStreamInputStream(this, pos, 0);    }    /**     * Returns an input stream associated with this VersaStream.      * <p>     * The input stream will start reading from the current position in the VersaStream.     *     * @exception  IOException  if an I/O error occurs.     */    public VersaStreamInputStream getInputStream() throws IOException {    	return getInputStream(this.getPosition());    }    public OutputStream getOutputStream(long pos) throws IOException {    	return new VersaStreamOutputStream(this, pos);    }    public OutputStream getOutputStream() throws IOException {    	return getOutputStream(this.getPosition());    }    public final long copyFrom(VersaStream source, long count) throws IOException {		return StreamUtil.copy(source, this, count);	}   		  		    public final long copyFrom(VersaStream source) throws IOException {		return copyFrom(source, -1);	}	    public final long copyFrom(InputStream source, long count) throws IOException { 		return StreamUtil.copy(source, this, count); 	}    public final long copyFrom(InputStream source) throws IOException {		return copyFrom(source, -1);	}    public final long copyFrom(Reader source, long count) throws IOException {		return StreamUtil.copy(source, this, count);  	}    public final long copyFrom(Reader source) throws IOException {		return copyFrom(source, -1);	}    public final long copyFrom(DataInput source, long count) throws IOException {		return StreamUtil.copy(source, this, count);  	}    public final long copyFrom(DataInput source) throws IOException {		return copyFrom(source, 0);	}        public long copyTo(DataOutput dest, long count) throws IOException { 		return StreamUtil.copy(this, dest, count);  	}    public final long copyTo(DataOutput dest) throws IOException {		return copyTo(dest, -1);	}	    public long copyTo(OutputStream dest, long count) throws IOException { 		return StreamUtil.copy(this, dest, count);  	}    public final long copyTo(OutputStream dest) throws IOException {		return copyTo(dest, -1);	}    public long copyTo(Writer dest, long count) throws IOException { 		return StreamUtil.copy(this, dest, count);  	}    public final long copyTo(Writer dest) throws IOException {		return copyTo(dest, -1);	}	    public String toString() {		StringBuffer sb = new StringBuffer();    	    	synchronized(this) {	    	try {	  			if (this.getPosition() != 0 && this.canSeekBackwards()) this.setPosition(0);				final int bufSize = StreamUtil.MAXBUFSIZE;		  		byte buffer[] = new byte[bufSize];		  		int i;		  			  			while ((i = this.read(buffer, 0, bufSize)) != -1) {					sb.append(new String(buffer, 0, i));		    	}			  				  		buffer = null;	    	} catch (IOException ioe) {	    		ioe.printStackTrace();	    		sb.append('\n' + ioe.toString());	    	}		}		    	    	return sb.toString();    	    }	public synchronized int peek() throws IOException {		long theMark = getPosition();		int result = -1;		try {			result = read();		} catch (IOException e) {			setPosition(theMark);			throw e;				}				setPosition(theMark);		return result;		}		public synchronized int peek(byte b[], int off, int len) throws IOException{		long theMark = getPosition();		int result = -1;				try {			result = read(b, off, len);		} catch (IOException e) {			setPosition(theMark);			throw e;				}				setPosition(theMark);		return result;		}	    public synchronized int peek(byte b[]) throws IOException {		return peek(b, 0, b.length);    }	public synchronized void peekFully(byte b[], int off, int len) throws IOException {		long theMark = getPosition();		try {			readFully(b, off, len);		} catch (IOException e) {			setPosition(theMark);			throw e;				}		setPosition(theMark);    }    public synchronized void peekFully(byte b[]) throws IOException {		peekFully(b, 0, b.length);    }	public synchronized void discardToEnd(long off) throws IOException {		//long s = getSize();		setSize(off);		setPosition(off);		//return s - off;	}	public synchronized void discardToEnd() throws IOException {		discardToEnd(getPosition());		}	public synchronized void discard(long off, long len) throws IOException {  				if (len < 1) throw new IOException("Cannot discard " + len + " bytes");  		  		  		byte buffer[] = new byte[StreamUtil.MAXBUFSIZE];  		  		int i;   		long result = 0;  		long dest = off, source = dest + len;  				while ( (i = read(source, buffer, 0, StreamUtil.MAXBUFSIZE)) != -1 ) {					source += i;			write(dest, buffer, 0, i);			dest += i;			result += i;		}		  		  		buffer = null;  		setSize(result + off);  		setPosition(off);  			}	public synchronized void discard(long len) throws IOException {		discard(getPosition(), len);			}			public void trimStart(long len) throws IOException {		if (len > 0) discard(0, len);	}		public synchronized void trimStart() throws IOException {		trimStart(getPosition());	}	    /**     * Discards all bytes from curent position up to the end of the stream.     *     * @exception  IOException  if an I/O error occurs.     */	public synchronized void trimEnd() throws IOException {		setSize(getPosition());	}	public synchronized void trimEnd(long len) throws IOException {		if (len == 0) return;		setSize(seek(-len, FROM_END));	}		  			public void insert(long pos,long len) throws IOException {  		if (len <= 0) return;  		long s = this.getSize();  		long count = s - pos;  		this.setSize(s + len);  		  		  		  		int step = count >= StreamUtil.MAXBUFSIZE ? StreamUtil.MAXBUFSIZE : (int)count;  		byte buffer[] = new byte[step];  			int i;  		long source = s - step, dest = source + len;  				while ( count > 0 && (i = this.read(source, buffer, 0, step)) != -1 ) {					this.write(dest, buffer, 0, i);			count -= i;			step = count >= StreamUtil.MAXBUFSIZE ? StreamUtil.MAXBUFSIZE : (int)count;			source -= step;			dest -= step;		}		  		  		buffer = null; 	}		public final void insert(long pos, byte b[], int off, int len) throws IOException {    		if (len > 0) {  			insert(pos, len);  			write(pos, b, off, len);  			setPosition(pos + len);  		}  			}	public final void insert(byte b[], int off, int len) throws IOException {		insert(getPosition(), b, off, len);	}	public final void insert(byte b[]) throws IOException {		insert(b, 0, b.length);	}	public final void insert(long pos, byte b[]) throws IOException {		insert(pos, b, 0, b.length);	}	public synchronized final void replace(long pos, long lenDel, byte b[], int off, int len) throws IOException {  		int lenDif = (int)(lenDel - len);  		   		if (lenDif >= 0) {  			if (b != null) write(pos, b, off, len);  			if (lenDif > 0) discard(pos + len, lenDif);	  		} else {	   			   		if (b != null) {		   		write(pos, b, off, (int)lenDel);		  		insert(pos + lenDel, b, off + (int)lenDel, -lenDif);			} else {				insert(pos + lenDel, -lenDif);	  		}	  			  	}	}	public final void replace(long pos, long lenDel, byte b[]) throws IOException {		replace(pos, lenDel, b, 0, b.length);	}		public final void replace(long lenDel, byte b[], int off, int len) throws IOException {		replace(getPosition(), lenDel, b, off, len);	}		public final void replace(long lenDel, byte b[]) throws IOException {		replace(lenDel, b, 0, b.length);	}		public final void replace(long pos, long lenDel, int len) throws IOException {		replace(pos, lenDel, null, 0, len);	}    public synchronized int read(long pos) throws IOException {		this.setPosition(pos);		return this.read();    }    public synchronized int read(long pos, byte b[], int off, int len)	throws IOException    {		this.setPosition(pos);		return this.read(b, off, len);    }    public synchronized void write(long pos, int b) throws IOException {		this.setPosition(pos);		this.write(b);    }    public synchronized void write(long pos, byte b[], int off, int len)	throws IOException    {		this.setPosition(pos);	 	this.write(b, off, len);    }	public final void readFully(byte b[], int off, int len) throws IOException {		int total_read = 0, bytes_read;		while (total_read < len)		{			bytes_read = read(b, off + total_read, len - total_read);			if (bytes_read == -1)				throw new EOFException("Unexpected end of stream");			total_read += bytes_read;		}    }	    public final void readFully(byte b[]) throws IOException {		readFully(b, 0, b.length);    }		    public int read(byte b[], int off, int len) throws IOException{		if (len <= 0)		    return 0;		int c = read();		if ( c == -1 )			return -1;				int pos = off;		b[pos++] = (byte)c;		int i=1;				try {		    		    for (; i < len ; i++) {				c = read();				if (c == -1) 				    break;								if (b != null) {				    b[pos++] = (byte)c;				}		    }		} catch (IOException ioe) {		}		return i;    }    public int read(byte b[]) throws IOException {	return read(b, 0, b.length);    }	    public int skipBytes(int n) throws IOException {		if (n <= 0)			return 0;    	long pos = getPosition();    	return (int) (seek(n,FROM_CURRENT) - pos);    }    public final boolean readBoolean() throws IOException {		int byte_read = read();		if (byte_read == -1)			throw new EOFException("Unexpected end of stream");		return byte_read != 0;			}    public final byte readByte() throws EOFException, IOException {		int byte_read = read();		if (byte_read == -1)		throw new EOFException("Unexpected end of stream");		return(byte)byte_read;    }    public final int readUnsignedByte() throws EOFException, IOException {		int byte_read = read();		if (byte_read == -1)			throw new EOFException("Unexpected end of stream");		return byte_read;    }    public final short readShort() throws EOFException, IOException {		byte[] buf = new byte[2];		readFully(buf);		return (short) ( ( (buf[0] & 0xFF) << 8) | (buf[1] & 0xFF) );    }    public final int readUnsignedShort() throws IOException {		byte[] buf = new byte[2];		readFully(buf);		return ( (buf[0] & 0xFF) << 8) | (buf[1] & 0xFF);    }    public final char readChar() throws EOFException, IOException {		return (char)readUnsignedShort();	        }    public final int read24BitInt() throws IOException {		byte[] buf = new byte[3];		readFully(buf);				return (int) ( ( (buf[0] & 0xFF) << 16) | ( (buf[1] & 0xFF) << 8) | (buf[2] & 0xFF) );    }    public final int readUnsigned24BitInt() throws IOException {		byte[] buf = new byte[3];		readFully(buf);				return ( (buf[0] & 0xFF) << 16) | ( (buf[1] & 0xFF) << 8) | (buf[2] & 0xFF);		    }    public final int readInt() throws IOException {		byte[] buf = new byte[4];		readFully(buf);		return (( (buf[0] & 0xFF) << 24) | ( (buf[1] & 0xFF) << 16) | ( (buf[2] & 0xFF) << 8) | (buf[3] & 0xFF) );    }    public final long readUnsignedInt() throws IOException {		byte[] buf = new byte[4];		readFully(buf);		return (( (buf[0] & 0xFF) << 24) | ( (buf[1] & 0xFF) << 16) | ( (buf[2] & 0xFF) << 8) | (buf[3] & 0xFF) );    }    public final long readLong() throws IOException {		byte[] buf = new byte[8];		readFully(buf);		return (long) (( (buf[0] & 0xFF) << 56) | ( (buf[1] & 0xFF) << 48) | ( (buf[2] & 0xFF) << 40) | ( (buf[3] & 0xFF) << 32) | ( (buf[4] & 0xFF) << 24) | ( (buf[5] & 0xFF) << 16) | ( (buf[6] & 0xFF) << 8) | (buf[7] & 0xFF) );    }    public final float readFloat() throws IOException {		return Float.intBitsToFloat(readInt());    }    public final double readDouble() throws IOException {		return Double.longBitsToDouble(readLong());    }    /**     * Reads a line of text.  A line is considered to be terminated by      * the contents of data member newLine. The VersaStream does not need     * to be able to mark(), reset(), neither to seek backwards.     *     * @return     A String containing the contents of the line, not including     *             any line-termination characters, or null if the end of the     *             stream has been reached     *      *     * @exception  IOException  If an I/O error occurs     */    public final String readLine() throws IOException {		final char nl1 = newLine.charAt(0);		final char nl2 = newLine.length() > 1 ? newLine.charAt(1) : (char)-1;		StringBuffer input = new StringBuffer(256);		int c;		if (nl2 == (char)-1) {			while (((c = read()) != -1) && (c != nl1)) {			    input.append((char)c);			}		} else {			int lastC = -1;			while ( true ) {				c = read();								if ( lastC == nl1 ) {					if ( c != nl2)						input.append(nl1);					else						break;				}				 				if ( c == -1) break;				lastC = c;				if ( c == nl1 ) continue;								input.append((char)c);			}				}				if ((c == -1) && (input.length() == 0)) {		    return null;		}				return input.toString();    }        public final String readUTF() throws IOException {		return DataInputStream.readUTF(this);    }	    public void write(byte b[], int off, int len) throws IOException {		for (int i = 0 ; i < len ; i++) {		    write(b[off + i]);		}    }    public void write(byte b[]) throws IOException {		write(b, 0, b.length);    }	    public final void writeBoolean(boolean v) throws IOException {		write(v ? 1 : 0);    }	    public final void writeByte(int v) throws IOException {		write(v);	}	    public final void writeShort(int v) throws IOException {		write((v >>> 8) & 0xFF);		write(v & 0xFF);    }    public final void write24BitInt(int v) throws IOException {		write((v >>> 16) & 0xFF);		write((v >>>  8) & 0xFF);		write(v & 0xFF);    }    public final void writeChar(int v) throws IOException {		write((v >>> 8) & 0xFF);		write(v & 0xFF);    }    public final void writeInt(int v) throws IOException {		write((v >>> 24) & 0xFF);		write((v >>> 16) & 0xFF);		write((v >>>  8) & 0xFF);		write(v & 0xFF);    }    public final void writeInt(long lv) throws IOException {		int v = (int) lv;		write((v >>> 24) & 0xFF);		write((v >>> 16) & 0xFF);		write((v >>>  8) & 0xFF);		write(v & 0xFF);    }    public final void writeLong(long v) throws IOException {		write((int)(v >>> 56) & 0xFF);		write((int)(v >>> 48) & 0xFF);		write((int)(v >>> 40) & 0xFF);		write((int)(v >>> 32) & 0xFF);		write((int)(v >>> 24) & 0xFF);		write((int)(v >>> 16) & 0xFF);		write((int)(v >>>  8) & 0xFF);		write( ( (int)v ) & 0xFF);    }    public final void writeFloat(float v) throws IOException {		writeInt(Float.floatToIntBits(v));    }    public final void writeDouble(double v) throws IOException {		writeLong(Double.doubleToLongBits(v));    }    public final void writeBytes(String s) throws IOException {		int len = s.length();				if (len == 0)			return;				byte[] b = new byte[len];		s.getBytes(0, len, b, 0);		write(b, 0, len);    }    public final void writeChars(String s) throws IOException {		int clen = s.length();		int blen = 2*clen;		byte[] b = new byte[blen];		char[] c = new char[clen];		s.getChars(0, clen, c, 0);		for (int i = 0, j = 0; i < clen; i++) {		    b[j++] = (byte)(c[i] >>> 8);		    b[j++] = (byte)(c[i] >>> 0);		}		write(b, 0, blen);    }    public final void writeUTF(String str) throws IOException {		int strlen = str.length();		int utflen = 0;		for (int i = 0 ; i < strlen ; i++) {		    int c = str.charAt(i);		    if ((c >= 0x0001) && (c <= 0x007F)) {				utflen++;		    } else if (c > 0x07FF) {				utflen += 3;		    } else {				utflen += 2;		    }		}		if (utflen > 65535)		    throw new UTFDataFormatException();		  		write((utflen >>> 8) & 0xFF);		write((utflen >>> 0) & 0xFF);				for (int i = 0 ; i < strlen ; i++) {				    int c = str.charAt(i);				    if ((c >= 0x0001) && (c <= 0x007F)) {				write(c);		    } else if (c > 0x07FF) {						write(0xE0 | ((c >> 12) & 0x0F));				write(0x80 | ((c >>  6) & 0x3F));				write(0x80 | ((c >>  0) & 0x3F));					    } else {						write(0xC0 | ((c >>  6) & 0x1F));				write(0x80 | ((c >>  0) & 0x3F));					    }		}		    }}