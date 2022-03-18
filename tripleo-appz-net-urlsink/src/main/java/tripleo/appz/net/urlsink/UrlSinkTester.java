/*
 * Created on May 24, 2004
 *
 */
package tripleo.appz.net.urlsink;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import tripleo.util.UT;


class UrlSinkTester {

public UrlSinkTester(boolean b) {
	//			final WebConnection wc = new WebConnection(InetAddress.getLocalHost(),
	// 8080);
	//			final HTTPOutputStream os = wc.getOutputStream();
	//			final HTTPInputStream is = wc.getInputStream();
	//			//
	//			os.write("GET".getBytes());
	final HttpClient hc = new HttpClient();
	if (b)
		hc.startSession("localhost", 8080, "localhost", 9666);
	else
		hc.startSession("localhost", 8080);
	for (int i = 0; i < 100; i++) {
		do_one(hc, i);
	}
}

private void do_one(final HttpClient hc, int i) {
	final GetMethod getmeth = new GetMethod("/" + i);
	boolean ok = false;
	String ee = null;
	try {
		final int code = hc.executeMethod(getmeth);
		if (code == 200) {
			String s = getmeth.getResponseBodyAsString();
			if (s.equals(UT.string_times(i)))
				ok = true;
			else
				ee = "" + i + " not equal ((" + s + "))";
		}
	} catch (HttpException e) {
		/* Assert.not_reached(); */ee = ("httpex " + e);
	} catch (IOException e) {
		/* Assert.not_reached(); */ee = ("ioex " + e);
	}
	if (!ok) {
		System.out.println("ko " + i + " " + ee.toString());
	} else {
		System.out.println("ok " + i);
	}
}
}
