package tripleo.http.impl;

import java.io.OutputStream;
import java.util.*;

import tripleo.http.*;

/**
 * Date: Aug 18, 2005
 * Time: 8:09:10 PM
 * <p/>
 * $Id: AbstractResponse.java,v 1.1 2005/10/16 14:16:31 olu Exp $
 */
abstract public class AbstractResponse implements IResponse {
	private static final Object CRLF = "\r\n";
	final private StringBuilder _cont= new StringBuilder();
	final private Map<String,List<String>> _hdrs=new HashMap<>();
	protected final OutputStream  _conduit;

	public AbstractResponse(OutputStream a_conduit, IRequest a_req) {
		_conduit = a_conduit;
		_req = a_req;
	}

	protected final IRequest _req;
	private int _code;
	private String _method;
	private String _text;

	public IResponse addHeader(String aName, String aValue) {
		if (!_hdrs.containsKey(aName)){
			return setHeader(aName,aValue);
		} else {
			_hdrs.get(aName).add(aValue);
			return this;
		}
	}

	/**
	 *
	 * @return a duplicate string holding our content
	 */
	public CharSequence getContent() {
		return (_cont.subSequence(0,_cont.length()));
//		return new String(_cont);
	}

	public IResponse append(CharSequence aCs) {
		_cont.append(aCs);
		return this;
	}

	public String firstline() {
		return String.format("%s %d %s",_method,new Integer(_code),_text);
	}

	public IResponse firstline(String method, int code, String text) {
		_method=method;
		_code=code;
		_text=text;
		return this;
	}

	public List<IHeader> copyOfHeaders() {
		List<IHeader> r=new ArrayList<>();
		for (Map.Entry<String, List<String>> h : _hdrs.entrySet()) {
			r.add(DefaultHeaderImpl.make(h.getKey(), _singleHeader(h.getValue())));
		}
		return r;
	}

	public IRequest getRequest() {
		return _req;
	}

	/**
	 * @see Reply#headers
	 */
        @Override
	public void send() throws HttpException {
		StringBuilder xx = new StringBuilder();
		xx.append(firstline())
		  .append(CRLF);

		for (Map.Entry<String, List<String>> h : _hdrs.entrySet()) {
			xx.append(h.getKey())
			  .append(": ");

			final List<String> value = h.getValue();
			_singleHeader(value, xx);
			xx.append(CRLF);
		}

		xx.append(CRLF)
		  .append(_cont);

		_conduit_write(xx);
	}

	abstract void _conduit_write(StringBuilder aStringBuilder) throws HttpException;

	private void _singleHeader(List<String> value, StringBuilder aXx) {
		boolean flag = false;

		for (String v : value) {
			if (flag)
				aXx.append(", "); // TODO should this be a semi-colon?
			aXx.append(v);
			flag = true;
		}
	}

	String _singleHeader(List<String> value) {
		StringBuilder x= new StringBuilder();
		_singleHeader(value, x);
		return x.toString();
	}

	public IResponse setContent(CharSequence aCs) {
		_cont.delete(0, _cont.length());
		_cont.append(aCs);
		return this;
	}

	public IResponse setHeader(String aName, String aValue) {
		List<String> l=new ArrayList<>();
		l.add(aValue);
		_hdrs.put(aName, l);
		return this;
	}
}
