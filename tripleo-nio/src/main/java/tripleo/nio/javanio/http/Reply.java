package tripleo.nio.javanio.http;



import java.io.IOException;
import java.nio.*;
import java.nio.charset.Charset;

import tripleo.nio.javanio.*;

/**
 * An object used for sending Content to the requestor.
 *
 * @author Mark Reinhold
 * @author Brad R. Wetmore
 * @version 1.2, 04/07/26
 */
public class Reply implements Sendable {

	/**
	 * A helper class which define the HTTP response codes
	 */
	public static class Code {

		private final int number;
		private final String reason;

		public Code(int i, String r) {
			number = i;
			reason = r;
		}

		public String toString() { return number + " " + reason; }

		public static Code OK = new Code(200, "OK");
		public static Code BAD_REQUEST = new Code(400, "Bad Request");
		public static Code NOT_FOUND = new Code(404, "Not Found");
		public static Code METHOD_NOT_ALLOWED = new Code(405, "Method Not Allowed");
		public static Code INTERNAL_ERROR = new Code(500, "Internal Erro");

	}

	private final Code code;
	protected Content content;
	private final boolean headersOnly;

	public Reply(Code rc, Content c) {
		this(rc, c, null);
	}

	public Reply(Code rc, Content c, JN_Request.Action head) {
		code = rc;
		content = c;
		headersOnly = (head == JN_Request.Action.HEAD);
	}

	private static final String CRLF = "\r\n";
	private static final Charset ascii = Charset.forName("US-ASCII");

	protected ByteBuffer hbb = null;

	private ByteBuffer headers() {
		CharBuffer cb = CharBuffer.allocate(1024);
		for (; ;) {
			try {
				cb.put("HTTP/1.0 ").put(code.toString()).put(CRLF);
				cb.put("Server: niossl/0.1").put(CRLF);
				cb.put("Content-type: ").put(content.type()).put(CRLF);
				cb.put("Content-length: ")
				        .put(Long.toString(content.length())).put(CRLF);
				cb.put(CRLF);
				break;
			} catch (BufferOverflowException x) {
				assert(cb.capacity() < (1 << 16));
				cb = CharBuffer.allocate(cb.capacity() * 2);
				continue;
			}
		}
		cb.flip();
		return ascii.encode(cb);
	}

	public void prepare() throws IOException {
		content.prepare();
		hbb = headers();
	}

	public boolean send(ChannelIO cio) throws IOException {

		if (hbb == null)
			throw new IllegalStateException();

		if (hbb.hasRemaining()) {
			if (cio.write(hbb) <= 0)
				return true;
		}

		if (!headersOnly) {
			if (content.send(cio))
				return true;
		}

		if (!cio.dataFlush())
			return true;

		return false;
	}

	public void release() throws IOException {
		content.release();
	}
}
