/*
 * Date: May 21, 2004
 * Time: 12:33:13 PM
 */
package tripleo.appz.net.urlsink;

import java.io.IOException;

import org.prevayler.Prevayler;
import org.prevayler.implementation.SnapshotPrevayler;

import rabbit.util.RabbitUT;
import tripleo.util.Assert;

public class UrlSinkMain {

static volatile boolean stop;

public static void main(String[] args) throws Exception {
//	try {
		D = new DD();
//	} catch (Exception e) {
//	}
	Assert.check("prevayler created", D!=null);
	new UrlSinkServer();
	new UrlSinkTester(false);
//	stop = true;
}

	static DD D ;

//public static String string_times(int i) {
//	StringBuffer R = new StringBuffer();
//	while (i-- > 0) {
//		R.append('*');
//	}
//	return R.toString();
//}
//
//static synchronized void vvv(String aString) {
//	System.out.println(aString);
//}

	static class DD {
		final Prevayler prevayler;

		public DD() throws Exception {
			try {
				prevayler = new SnapshotPrevayler(new VecVecVecStore(), "vec-vec-vec");
				if (prevayler instanceof SnapshotPrevayler) {
					// snapshot as soon as possible
					// reduce state space
					// assemble all log states into latest [meta] state
					((SnapshotPrevayler) prevayler).takeSnapshot();
				}
			} catch (IOException e) {
				RabbitUT.xerr_a0("~~ [UrlSink::createPrevayler] " + e);
				throw e;
			} catch (ClassNotFoundException e) {
				RabbitUT.xerr_a0("~~ [UrlSink::createPrevayler] " + e);
				throw e;
			}
		}

		public VecVecVecStore storage() {
			return (VecVecVecStore) (D.prevayler.system());
		}
	}

	static void processRequest(final RequestStorageCommand aCommand) throws Exception {
		D.prevayler.executeCommand(aCommand);
	}
}
