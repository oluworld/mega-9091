package tripleo.cottontail.client;

import tripleo.util.Holder;

import java.io.File;

/**
 * Date: Feb 27, 2005
 * Time: 5:10:04 PM
 * <p/>
 * $Id: ResKey.java,v 1.1.1.1 2005/02/27 22:46:01 olu Exp $
 */
public class ResKey extends Holder<File> {
	public ResKey(File aFile) {	super(aFile); }

	public String name() {
		return "<default reskey name>";
	}
}
