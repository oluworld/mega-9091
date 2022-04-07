package tripleo.http.impl;

import java.net.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import rabbit.http.BinaryFunctor;
import rabbit.http.HTTPHeader;
import tripleo.http.*;
import tripleo.http.impl.*;
import tripleo.nio.javanio.http.JN_Request;
import tripleo.nio.javanio.http.JN_Request.Action;
import tripleo.util.Assert;

/**
 * Date: Aug 18, 2005 Time: 7:21:13 PM
 * <p/>
 * $Id: HeaderRequest.java,v 1.1 2005/10/16 14:16:31 olu Exp $
 */
public class HeaderRequest implements IRequest {

    final private HTTPHeader _header;
    final private CharBuffer _cb;

    public HeaderRequest(HTTPHeader a_header, CharBuffer aCb) {
        _header = a_header;
        _cb = CharBuffer.wrap(aCb);
    }

    public String getUri() {
        return _header.getRequestURI();
    }

    public List getHeaders() {
        return _header.copyOfHeaders();
    }

    public ByteBuffer getContent() {
//		final int rem = _cb.remaining();
//		final ByteBuffer r = ByteBuffer.allocate(rem);
        return Charset.defaultCharset().encode(_cb);
//		_cb.read(r);
//		return r;
    }

    public String version() {
        return _header.getHTTPVersion();
    }

    public String requestLine() {
        return _header.getRequestLine();
    }

    public List<IHeader> copyOfHeaders() {
        final List<IHeader> r = new ArrayList<IHeader>();
        _header.iterateHeaders(new BinaryFunctor<String, String>() {
            public boolean call(String s, String s2) {
                r.add(DefaultHeaderImpl.make(s, s2));
                return false;
            }
        });
        return r;
    }

    public IHTTPRequestLine getRequestLine() {
        return new DefaultHeaderLine(_header);
    }

    public JN_Request createRequest() {

        IHTTPRequestLine requestLine = getRequestLine();
        try {
            return new JN_Request(
                    JN_Request.Action.parse(requestLine.method()),
                    requestLine.version(),
                    new java.net.URI(requestLine.uri()));
        } catch (URISyntaxException e) {
            Assert.not_reached();
            return null;
        }

    }
}
