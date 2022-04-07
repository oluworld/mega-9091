/*
 * Created on May 24, 2004
 *
 * Proxy that stores any URL given
 *
 */
package tripleo.appz.net.urlsink;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import rabbit.http.GeneralHeader;
import rabbit.http.HTTPHeader;
import rabbit.io.HTTPInputStream;
import tripleo.util.Assert;
import tripleo.util.Pair;
import tripleo.util.UT;

/**
 * This is a very simple webserver used for some simple testing of RabbIT2
 */

public class UrlSinkServer implements Runnable {

    static class PickApartList {

        private List<Datum> mList;

        private int mStart;

        /**
         * take the last MAXSIZE elements from aList
         * 
         * @param aList
         *            the list to break
         */
        public void pick_apart_list(final List<Datum> aList) {
            final int MAXSIZE = 10;
            //
            final int size = aList.size();
            final int a1 = Math.max(0, size - MAXSIZE);
            final List<Datum> subList = aList.subList(a1, size);
            //
            Assert.postcondition("sublist_size", subList.size() >= 0
                    && subList.size() <= MAXSIZE);
            //
            mStart = a1;
            mList = subList;
        }

    }

    static final  String  CRLF = GeneralHeader.CRLF;
    static final  String  ct   = "text/plain";
    static           int  nn   = 0;
    private ServerSocket  ss;
    private final PickApartList pal  = new PickApartList();
//    private static String basedir = null;

    /* private */
    static String ddate() {
        return new Date().toString();
    }

    UrlSinkServer() {
        // todo make basedir and port configurable
        this(".", 8085); // args[0]
    }

    private UrlSinkServer(String aBasedir, int port) {
//        basedir = aBasedir;
        try {
            ss = new ServerSocket(port);
            new Thread(this, "UrlSink Server").start();
        } catch (Exception e) {
            e.printStackTrace(); // TODO: why catch an error here?
        }
    }

    private void action(Socket s, HTTPInputStream in, OutputStream os)
            throws IOException {
        HTTPHeader header = in.readHTTPHeader(); // channel read
        String requesturi = header.getRequestURI();
        String method = header.getHTTPVersion();

        if (requesturi.equals("http://stop.stop/")) {
            // final StopCommand command = new StopCommand(ddate(), requesturi,
            // header);
            // UrlSink.processRequest(command);
            serve(os, header, "HTTP/1.0", nn, "text/html",
                    "thats all folks. <br>successfully down (i think)");
            UrlSinkMain.stop = true;
            return;
        } else if (requesturi.startsWith("http://view.view/")) {
            view_action(os, header, requesturi);
        } else {

            // System.err.println(header.toString());
            // FileInputStream fis = new FileInputStream(basedir +
            // File.separator +
            // requesturi);
            // byte[] buf = new byte[1024];
            // int read;
            // while ((read = fis.read(buf)) > 0)
            // os.write(buf, 0, read);

            try {
                final RequestStorageCommand command = new RequestStorageCommand(
                        ddate(), requesturi, header);
                UrlSinkMain.processRequest(command);
            } catch (Exception e) {
                System.err.println("ignoring exception fromm prevayler "
                        + requesturi + "\n" + e + "\n---------------");
            }

            write_response(os, header);
        }

        if (!method.endsWith("/1.1")) {
            in.close();
            os.close();
            s.close();
        }

        UT.vvv("finished serving " + requesturi);
    }

    private Pair pick_apart_list(final List<Datum> aList) {
        pal.pick_apart_list(aList);

//        List l1 = new Vector();
//        l1.add(new Integer(pal.mStart));
//        l1.add(pal.mList);

        Pair R = Pair.make(new Integer(pal.mStart), pal.mList);
        return R;
//        return l1;
    }

    private String preserve_list(List a, int n) {
        String R = "";
        for (Object o : a) {
            Datum datum = (Datum) o;
            R += "<b>" + n++ + "</b> " + datum + " <br>";
        }
        return R;
    }

    public void run() {
        while (true) {
            if (still_serving())
	            try {
	                Socket s = ss.accept();
	                HTTPInputStream in = new HTTPInputStream(
	                        new BufferedInputStream(s.getInputStream()));
	                OutputStream os = s.getOutputStream();
	                action(s, in, os);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
        }
    }

	private boolean still_serving() {
		return !UrlSinkMain.stop;
	}

	void serve(OutputStream os, HTTPHeader header, String method, int n,
            String act, String cont) throws IOException {
        UT.vvv("started serving " + n);
        //
        String S = method + " 200 OK" + CRLF +
                "Server: who cares" + CRLF +
                // "Date: who cares"+CRLF+
                // "Last-Modified: who cares"+CRLF+
                "Content-type: "   + act + CRLF +
                "Content-length: " + cont.length() + CRLF +
                CRLF + cont;
        os.write(S.getBytes());
    }

    /**
     * @param os
     * @param header
     * @param requesturi
     * @throws IOException
     */
    private void view_action(OutputStream os, HTTPHeader header, String requesturi) throws IOException {
        int n=0, max=10;
        Dictionary<String,String> d=new Hashtable<>();
        String m=requesturi.substring(("http://view.view/").length());
        if (m.charAt(0)=='?') {
            String[] ml = m.substring(1).split("&");
            for (String s : ml) {
                String[] ml2 = s.split("=");
                for (int j = 0; j < ml2.length; j += 2) {
                    if (ml2.length == 2)
                        d.put(ml2[0], ml2[1]);
                }
            }
        }
        //
        try {
            final String fromstr = (String)d.get("from");
            if (fromstr != null)
                n   = Integer.parseInt(fromstr);
        } catch (NumberFormatException e) {
            // TODO warn user (or just log)
            // resp.d['errs]+=Error(...);
            e.printStackTrace();
        }
        try {
            final String maxstr = (String)d.get("max");
            if (maxstr !=null) {
                max = Integer.parseInt(maxstr);
            }
        } catch (NumberFormatException e1) {
            // TODO warn user (or just log)
            // resp.d['errs]+=Error(...);
            e1.printStackTrace();
        }
        //
        write_view_response(os, header, n, max);
    }

    /**
     * @param os
     * @param header
     * @throws IOException
     */
    private void write_response(OutputStream os, HTTPHeader header)
            throws IOException {
        String cont = "<body><p><a href='javascript:window.close();'>close window</a><br/></p>";
        cont += "<a href='http://stop.stop/'>kill proxy</a></p>";
        cont += "<a href='http://view.view/?from=0'>view</a></p>";
        //
        final VecVecVecStore store = (VecVecVecStore) UrlSinkMain.D.prevayler
                .system();
        final Pair m = pick_apart_list(store.requests);
//        int nn = ((Integer) m.get(0)).intValue();
//        final List subList = (List) m.get(1);
        final int  nn      = ((Integer)m.first ).intValue();
        final List subList = (List)m.second;
        cont += "" + preserve_list(subList, nn);
        serve(os, header, "HTTP/1.0", nn+1, "text/html", cont);
    }

    /**
     * @param os
     * @param header
     * @param aMax
     * @throws IOException
     */
    private void write_view_response(OutputStream os, HTTPHeader header, int start, int aMax)
            throws IOException {
        //
        aMax = Math.min(aMax, 100); // TODO warn user
        //
        String cont = "<body><p><a href='javascript:window.close();'>close window</a><br/></p>";
        cont += "<a href='http://stop.stop/'>kill proxy</a></p>";
        cont += "<a href='http://view.view/?from=0'>view</a></p>";
        //
        final VecVecVecStore store = (VecVecVecStore) UrlSinkMain.D.prevayler
                .system();
        final List<Datum> reqs = store.requests;
        
        int n=Math.max(0,start);
        while (n<start+aMax) {
            String a;
            try {
                a = ((Datum)reqs.get(n)).b;
                // else ...
                cont += "<a href='"+a+"'>[ "+n+" ]  "+a+"</a><br/>\n"; 
                n++;
                // ...
            } catch (IndexOutOfBoundsException e) {
                // TODO
                break;
            }
        }
        
        cont += "<p><a href='http://view.view/?from="+Math.max(0,start-aMax)+"'>prev page</a>  ";
        if (reqs.size()>(start+aMax))
            cont += "<a href='http://view.view/?from="+Math.min(5000,start+aMax)+"'>next page</a></p>";
        
        serve(os, header, "HTTP/1.0", -1, "text/html", cont);
    }
}
class CGI_PY {

/*
	 def parse_qs(qs, keep_blank_values=0, strict_parsing=0):
	 """Parse a query given as a string argument.

	 Arguments:

	 qs: URL-encoded query string to be parsed

	 keep_blank_values: flag indicating whether blank values in
	 URL encoded queries should be treated as blank strings.
	 A true value inicates that blanks should be retained as
	 blank strings.  The default false value indicates that
	 blank values are to be ignored and treated as if they were
	 not included.

	 strict_parsing: flag indicating what to do with parsing errors.
	 If false (the default), errors are silently ignored.
	 If true, errors raise a ValueError exception.
	 """
	 */

	//    Dict parse_qs(String qs, boolean keep_blank_values, boolean strict_parsing) {
	//        Dict dict = new Dict();
	//        AA A = parse_qsl(qs, keep_blank_values, strict_parsing);
	//        //
	//        boolean G=A.next();;
	//        while (G) {
	//
	//            name  = A.key();
	//            value = A.value();
	//
	//            if (value.length() || keep_blank_values) {
	//                if (dict.has_key(name)){
	//                    dict[name].append(value);}
	//                else{
	//                    dict.set(name,value);}
	//
	//            }
	//        }
	//
	//        return dict;
	//    }
	/*
	 def parse_qsl(qs, keep_blank_values=0, strict_parsing=0):
	 """Parse a query given as a string argument.

	 Arguments:

	 qs: URL-encoded query string to be parsed

	 keep_blank_values: flag indicating whether blank values in
	 URL encoded queries should be treated as blank strings.
	 A true value inicates that blanks should be retained as
	 blank strings.  The default false value indicates that
	 blank values are to be ignored and treated as if they were
	 not included.

	 strict_parsing: flag indicating what to do with parsing errors.
	 If false (the default), errors are silently ignored.
	 If true, errors raise a ValueError exception.

	 Returns a list, as God intended.
	 """
	 name_value_pairs = string.splitfields(qs, '&')
	 r=[]
	 for name_value in name_value_pairs:
	 nv = string.splitfields(name_value, '=')
	 if len(nv) != 2:
	 if strict_parsing:
	 raise ValueError, "bad query field: %s" % `name_value`
	 continue
	 name = urllib.unquote(string.replace(nv[0], '+', ' '))
	 value = urllib.unquote(string.replace(nv[1], '+', ' '))
	 r.append((name, value))

	 return r

	 */
}

