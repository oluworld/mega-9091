package tripleo.cottontail.client;

import java.util.*;

/**
 * Date: Feb 27, 2005
 * Time: 5:21:50 PM
 * <p/>
 * $Id: Resource.java,v 1.1.1.1 2005/02/27 23:01:26 olu Exp $
 */
public class Resource {
	ResKey rk;
	Version theVersion;

	public Resource(ResKey aRk) {rk = aRk;}

	public Iterator<VerKey> versions() {
		List v = Arrays.asList(new Object[]{"1.0"});
		List<VerKey> rrl = new ArrayList<VerKey>(v.size());
		for (Object fi : v) {
			rrl.add(new VerKey((String) fi));
		}
		return rrl.iterator();
	}

	public IVersion open(VerKey aIrv) {
		return new Version(aIrv, this);
	}

	public String getName() {
		return rk.get().getName();
	}
}
