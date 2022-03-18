package tripleo.http.impl;

import java.io.Serializable;

import tripleo.http.IHeader;

/**
 * Date: Aug 18, 2005
 * Time: 7:35:52 PM
 * <p/>
 * $Id: DefaultHeaderImpl.java,v 1.1 2005/10/16 14:16:31 olu Exp $
 */
public class DefaultHeaderImpl implements IHeader, Serializable {

	public static IHeader make(String name,String value) {
		DefaultHeaderImpl R = new DefaultHeaderImpl(name,value);
		return R;
	}

	String name,value;

	public DefaultHeaderImpl(String aName, String aValue) {
		name = aName;
		value = aValue;
	}

	public String getName() {
		return name;
	}

	public void setName(String aName) {
		name = aName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String aValue) {
		value = aValue;
	}
}
