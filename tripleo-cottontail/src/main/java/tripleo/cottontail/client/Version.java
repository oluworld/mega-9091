package tripleo.cottontail.client;

import java.io.*;
import java.util.Iterator;

/**
 * Date: Feb 27, 2005
 * Time: 5:22:20 PM
 * <p/>
 * $Id: Version.java,v 1.1.1.1 2005/03/11 07:38:06 olu Exp $
 */
class Version implements IVersion {
	private VerKey rv;
	private Resource res;

	Version(VerKey arv, Resource aResource) {
		rv  = arv;
		res = aResource;
	}

	public void setName(String aName) {	name = aName;	}

	public void setContent(String aContent) {	content = aContent;	}
	public void setComment(String aComment) {	comment = aComment;	}

	public Iterator<CmntKey> comments() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	public String getName()     {	return rv.get();	}
	public String getComment()  {	return comment;		}

	public String getContent() {
		final File file = res.rk.get();
		String R;
		try {
			final FileReader fr = new FileReader(file);
			final int l = (int) file.length();
			final char[] by = new char[l];
			fr.read(by);
			fr.close();
			return R = new String(by);
		} catch (IOException e) {
			return "exception: [" + e + "]";
		}
	}

	String name, content, comment;

}
