package tripleo.http.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import tripleo.annotation.CtorSet;
import tripleo.nio.javanio.Handler;
import tripleo.nio.javanio.http.RequestHandler;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Date: Aug 22, 2005
 * Time: 1:51:04 AM
 * <p></p>
 * $Id: UrlSinkSelector.java,v 1.1 2005/10/16 14:24:59 olu Exp $
 */
public class DefaultSelector implements Runnable {

	final private Object gate = new Object();
	private final @CtorSet Selector sel;
	static private final Log log = LogFactory.getLog(DefaultSelector.class);

	void dispatch() throws IOException {
		sel.select();
		for (Iterator<SelectionKey> i = sel.selectedKeys().iterator(); i.hasNext();) {
			SelectionKey sk = (SelectionKey) i.next();
			i.remove();
			final Handler h = (Handler) sk.attachment();
			try {
				h.handle(sk);
			} catch (IOException e) {
				System.err.println("SWallowing exception ============================================");
				e.printStackTrace(new PrintWriter(System.err)); // TODO: add to log
				log.warn("Failure during handle ", e);
				System.err.println("==================== ======================================= done");
			}
		}
		synchronized (gate) { }
	}

	public DefaultSelector() throws IOException {
		sel = Selector.open();
	}

	public void run() {
		try {
			do{dispatch();}while(true);
		} catch (IOException e) {
			log.warn("Failure during dispatch ", e);
//				e.printStackTrace(new PrintStream(System.err));
		}
	}

	public void register(final SocketChannel ch,
	                     final int ops,
	                     final RequestHandler rh) throws ClosedChannelException {
		synchronized (gate) {
			sel.wakeup();
			ch.register(sel, ops, rh);
		}
	}

}
