/**
 * Date: Dec 27, 2004
 * Time: 11:49:21 PM
 */

package tripleo.space;

import java.util.*;

public class Space {
	Map<String, Collection<SpaceWatcher>> watchers=new TreeMap<>();
	Map<String, Collection<SpaceNugget>>  nuggets =new TreeMap<>();

	public void addWatcher(SpaceWatcher aW, String aFor) {
		synchronized (watchers) {
			if (watchers.containsKey(aFor)) {
				Collection<SpaceWatcher> wl = watchers.get(aFor);
				wl.add(aW);
			} else {
				Collection<SpaceWatcher> wl = new ArrayList<>();
				wl.add(aW);
				watchers.put(aFor, wl);
			}
		}
	}

	public void add(SpaceNugget aNugget) {
		if(watchers.containsKey(aNugget.key())) {
			Collection<SpaceWatcher> wl = watchers.get(aNugget.key());
			for(SpaceWatcher w : wl) {
				if (w.watch(aNugget))
					wl.remove(w);
			}
		}
		synchronized (nuggets) {
			Object aFor = aNugget.key();
			Collection<SpaceNugget> m;
			//
			if (nuggets.containsKey(aFor)) {
				m = nuggets.get(aFor);
//				m.add(aNugget);
			} else {
				m = new ArrayList<>();
				nuggets.put((String)aNugget.key(), m);
			}
			m.add(aNugget);
		}
	}

	/**
	 * doesnt take 
	 */
	public Object getOr(Object aKey, Object aDefault) {
		synchronized (nuggets) {
			if (!nuggets.containsKey(aKey)) {
				return aDefault;
			}
			return nuggets.get (aKey);
		}
	}
}
