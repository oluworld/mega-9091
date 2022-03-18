package tripleo.http;

/**
 * Date: Aug 18, 2005
 * Time: 7:36:02 PM
 * <p/>
 * $Id: IHeader.java,v 1.5 2005/10/11 19:22:08 olu Exp $
 */
public interface IHeader {
	String getName();

	void setName(String aName);

	String getValue();

	void setValue(String aValue);
}
