package rabbit.io;

// $Id: HTTPInputStream.java,v 1.5 2005/10/11 19:22:08 olu Exp $

import java.io.*;
import java.util.StringTokenizer;

import rabbit.http.*;

/** This is an extended DataInputStream suitable for reading data from the web.
 *  It handles chunked encoding etc.
 *
 *  If the underlying input is chunked this class will throw away any
 *  trailing footer.
 */
public class HTTPInputStream extends DataInputStream {
	private InputStream is;
	private boolean keepalive = true;
	private boolean ischunked = false;
	private long dataSize = -1;   // -1 for unknown.
	private HTTPHeader header = null;
//	private long readBytes = 0;

	/** An input stream suitable for reading chunked streams
	 */
	private class Chunker extends InputStream {
		private HTTPInputStream in = null;
		private byte[] buf;
		private int idx = 0;
		private int chunksize = -1;
		private HTTPFooter footer;

		/** Create a new chunk handler on the underlying stream
		 * @param in the underlying stream.
		 */
		Chunker(HTTPInputStream in) throws IOException {
			this.in = in;
			getChunk();
		}

		/** read byte.
		 * @return a byte or  (int)-1 if end of stream.
		 */
		public int read() throws IOException {
			if (buf.length == 0)
				return -1;
			if (buf.length <= idx) {
				getChunk();
				return read();
			}
			return buf[idx++];
		}

		/** Try to read up to b.length bytes.
		 * @param b the byte array to read data into.
		 * @return the number of bytes read, -1 if end of stream.
		 */
		public int read(byte[] b) throws IOException {
			return read(b, 0, b.length);
		}

		/** Try to read up to len bytes.
		 * @param b the byte array to read data into.
		 * @param off the offset into b where data is stored.
		 * @param len read at most this many bytes.
		 * @return the number of bytes read, -1 if end of stream.
		 */
		public int read(byte[] b, int off, int len) throws IOException {
			if (buf.length == 0)
				return -1;
			if (buf.length <= idx) {
				getChunk();
				return read(b, off, len);
			}
			int left = buf.length - idx;
			int toread = Math.min(left, len);
			System.arraycopy(buf, idx, b, off, toread);
			idx += toread;
			return toread;
		}

		/** Try to skip n bytes.
		 * @param n the number of bytes to skip.
		 * @return the number of bytes actually skipped.
		 */
		public long skip(long n) throws IOException {
			if (buf.length == 0)
				return 0;
			if (buf.length <= idx) {
				getChunk();
				return skip(n);
			}
			int left = buf.length - idx;
			if (n < left) {
				idx += n;
				return n;
			} else {
				idx = buf.length;
				return (left + skip(n - left));
			}
		}

		/** Get the number of bytes that can be read without blocking.
		 * @return the number of bytes we can read without blocking.
		 */
		public int available() throws IOException {
			if (buf.length == 0)
				return 0;
			if (buf.length <= idx)
				return 0;
			return buf.length - idx;
		}

		/** Close this stream.
		 */
		public void close() throws IOException {
			in.close();
		}

		/** Get the next chunk.
		 */
		private void getChunk() throws IOException {
			chunksize = getChunkSize();
			if (chunksize > 0) {
				buf = new byte[chunksize];
				in.readFully(buf);
				in.readCRLF();
				idx = 0;
			} else {
				buf = new byte[0];
				idx = 0;
				// read the footer and throw it away...
				footer = new HTTPFooter(in);
			}
		}
	}


	/** Create a new HTTPInputStream on the underlying stream.
	 * @param is the underlying stream
	 */
	public HTTPInputStream(InputStream is) {
		super(is);
		this.is = is;
	}

	/** Read a HTTPHeader of this stream.
	 *  If data is chunked the whole page will be read in so to get it
	 *  use the getChunkStream. something like this <xmp>
	 *  HTTPHeader header = readHeader ();
	 *  if (chunked) {
	 *      contentStream = getChunkStream ();
	 *  }
	 *  </xmp>
	 * @return a new HTTPHeader read from the stream.
	 * @throws IOException if the HTTPHeader could not be read correctly.
	 */
	public HTTPHeader readHTTPHeader() throws IOException {
		header = null;  // to be nicer while we wait...
		header = new HTTPHeader(this);
		dataSize = -1;
		String cl = header.getHeader("Content-Length");
		if (cl != null) {
			try {
				dataSize = Long.parseLong(cl);
			} catch (NumberFormatException e) {
				dataSize = -1;
			}
		}
		String con = header.getHeader("Connection");
		String pcon = header.getHeader("Proxy-Connection");
		if (con != null && con.equalsIgnoreCase("close"))
			setKeepAlive(false);
		if (keepalive && pcon != null && pcon.equalsIgnoreCase("close"))
			setKeepAlive(false);

		if (header.isResponse()) {
			if (header.getResponseHTTPVersion().equals("HTTP/1.1")) {
				String chunked = header.getHeader("Transfer-Encoding");
				setKeepAlive(true);
				ischunked = false;

				if (chunked != null && chunked.equalsIgnoreCase("chunked")) {
					/* If we handle chunked data we must read the whole page
                     * before continuing, since the chunk footer must be appended
                     * to the header (read the RFC)...
                     *
                     * As of RFC 2616 this is not true anymore...
                     * this means that we throw away footers and it is legal...
                     */
					ischunked = true;
					header.removeHeader("Content-Length");
					dataSize = -1;
				}
			} else {
				setKeepAlive(false);
			}
		}

		if (!(dataSize > -1 || ischunked))
			setKeepAlive(false);

		return header;
	}

	/** Get the keep alive value.
	 * @return if this stream is in keepalive mode.
	 */
	public boolean getKeepAlive() {
		return keepalive;
	}

	/** Set the keep alive value to currentkeepalive & keepalive
	 * @param keepalive the new keepalive value.
	 */
	public void setKeepAlive(boolean keepalive) {
		this.keepalive = (this.keepalive && keepalive);
	}

	/** Get the chunked value.
	 * @return true if the last read HTTPHeader was chunked.
	 */
	public boolean chunked() {
		return ischunked;
	}

	/** Get the size of the page being read.
	 * @return the size of the page being read or -1 if unknown.
	 */
	public long dataSize() {
		return dataSize;
	}

	/** Get the size of the next chunk.
	 * @return the size of the next chunk.
	 * @throws IOException if the chunk size could not be read correctly.
	 */
	protected int getChunkSize() throws IOException {
		int chunksize = 0;
		String line = GeneralHeader.readLine(this);
		if (line == null)
			throw new IOException("Failed to read chunk block size");
		StringTokenizer st = new StringTokenizer(line, "\t \n\r(;");
		if (st.hasMoreTokens()) {
			String hex = st.nextToken();
			try {
				chunksize = Integer.parseInt(hex, 16);
			} catch (NumberFormatException e) {
				throw new IOException("Chunk size is not a hex number: '" + line + "', '" + hex + "'.");
			}
		} else {
			throw new IOException("Chunk size is not available.");
		}
		return chunksize;
	}

	/** Read of an CR LF combination.
	 * @throws IOException if the CR LF combination could not be read correctly.
	 */
	public void readCRLF() throws IOException {
		int cr = read();
		int lf = read();
		if (cr != 13 && lf != 10) // well could check for '\r' and '\n' but the spec say it should be 13 and 10!.
			throw new IOException("Could not read CRLF correctly: " + cr + ", " + lf);
	}

	/** Get the chunked page.
	 * @return an InputStream to the previously read chunked pagel.
	 */
	public InputStream getChunkStream() {
		InputStream is = null;
		try {
			is = new Chunker(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return is;
	}

	protected void finish() {
		header = null;
	}

	public void close() throws IOException {
		header = null;
		super.close();
		is = null;
		dataSize = -1;
	}

//	public String a001() {
//		return x.getHeader().getRequestLine();
//	}
}

