/*
 * Created on Mar 23, 2004
 *
 * $Id: J2_System.java,v 1.1 2005/08/08 02:31:59 olu Exp $
 * 
 * Korsikovs disease
 */

package tripleo.histore.j2;

import tripleo.curr.MonitoredRunner;
import tripleo.histore.HiStoreEntry;
import tripleo.util.Assert;
import tripleo.util.FuckUp;
import tripleo.adt.Range;
import tripleo.curr.MonitoredRunner;

import java.io.*;
import java.util.*;

@Deprecated interface Command {
	Serializable execute(PrevalentSystem system) throws Exception;
}
@Deprecated interface PrevalentSystem {/**/}

// TODO: maybe integrate System and Store?? why have them separate?

/**
 * the methods modify the members, which are always in a consistent state
 */
public class J2_System implements PrevalentSystem {

	transient private HiStore_J2 store; // damn serialization
	transient private List<HiStoreEntry_J2> dirty;

	final EntryMap entrymap; // Used in HiStoreSystem
//	final Map<String, lazyEntry> entrymap; // Used in HiStoreSystem
	final private Range<Long> range = new Range();

	public J2_System(HiStore_J2 st) {
		store    = st;
		dirty    = new Vector<HiStoreEntry_J2>();
		entrymap = new EntryMap();//Hashtable<String, lazyEntry>();
	}
	
	void keep(long nextNumber) {
		// TODO: now that we have a ref to store, just ask #entrymap, right?
		// TODO: why store data twice?
		//
		// might need to store locally in a dirty list until we can ensure
		// it will be removed by an add_entry command
		//
		range.add(new Long(nextNumber));
	}

	boolean allocated(long target) {
		return range.contains(new Long(target));
	}

	void start_cleaner(MonitoredRunner m) {
		//let t = Timer (90 * SECONDS) (fun -> map dirty (fun x -> commit x))
		// TODO: use scheduler to compensate for multiple HiStores
		new Thread(new Cleaner(m), "HiStore.cleaner").start();
	}

	private class Cleaner implements Runnable {
		public Cleaner(MonitoredRunner aMonitored_instance) {
			monitored_instance = aMonitored_instance;
		}

		private MonitoredRunner monitored_instance;

		public void run() {
			while (monitored_instance.stillRunning()) {
				try {
					Thread.sleep(90 * 1000);
				} catch (InterruptedException e) {
				}
				synchronized (dirty) {
					Writer wr = c1() ;
					c2(wr);
				}
				synchronized (entrymap) {
					store.write();
					store.read();
				}
			}

		}

		private Writer c1() {
			File f = new File(store.backing(), "entries");
			Writer wr;
			try {
				final boolean appendMode = true;
				wr = new BufferedWriter(new FileWriter(f.getPath(), appendMode));
			} catch (IOException e1) {
				throw new FuckUp("failed during commit " + e1);
			}
			return wr;
		}

		private void c2(Writer aWr) {
			Iterator<HiStoreEntry_J2> dit = dirty.iterator();
			while (dit.hasNext()) {
				HiStoreEntry_J2 storeEntry = dit.next();
				boolean b = storeEntry.commit(aWr);
				if (b) dit.remove();
			}
		}
	}

	/**
	 * To change the state of the business objects, the client code must use a Command like this one.
	 */
	public static class NumberStorageCommand implements Command {

		private final long numberToKeep;

		public NumberStorageCommand(long anumberToKeep) {
			numberToKeep = anumberToKeep;
		}

		public Serializable execute(PrevalentSystem system) throws Exception {
			((J2_System) system).keep(numberToKeep);
			return null;
		}
	}

	/**
	 * To change the state of the business objects, the client code must use a Command like this one.
	 */
	public static class EntryStorageCommand implements Command {

		private String       name;
		private HiStoreEntry_J2 value;

		public EntryStorageCommand(String aName, HiStoreEntry_J2 aEntry) {
			name = aName;
			value = aEntry;
		}

		public Serializable execute(PrevalentSystem system) throws Exception {
			((J2_System) system).add_entry(name, value);
			return null;
		}
	}

	/**
	 * This is a callback method used to enforce encapsulation.
	 * Maybe use an inner class...
	 *
	 * @param aKey
	 * @param entry
	 */
	void add_entry(final String aKey, final HiStoreEntry_J2 entry) {
		entrymap.put(aKey, mkEntry(entry)/*new Long(identifier)*/);
		dirty.add(entry);
		//
		Assert.postcondition("keycontained",    has_entry_for_key(aKey));
		Assert.postcondition("associated",      entry_for_key(aKey, store)==entry);
		Assert.postcondition("newEntryIsDirty", dirty.contains(entry)); // was AKey: kept failing
	}

	private lazyEntry mkEntry(HiStoreEntry_J2 aEntry) {
		final lazyEntry R ;
		if (aEntry.host_store == null) {
			R=null;
//			R = new serialEntry(aEntry);
		} else {
			R = new diskEntry(aEntry);
		}
		return R;
	}

	boolean has_entry_for_key(String aKey) {
		return entrymap.containsKey(aKey);
	}

	HiStoreEntry entry_for_key(String aKey, HiStore_J2 aHiStore_j1) {
		final HiStoreEntry_J2 R = entrymap.get(aKey).get();
//		// fix serialization error
//		if (store == null) {store = aHiStore_j1;dirty=new Vector();}
//		if (R.host_store ==  null && store != null)
//			R.host_store =  store;
		return R;
	}

	/**
	 * do the opposite of #add_entry
	 *
	 * @param aKey
	 */
	public void remove_entry_for_key(String aKey) {
		HiStoreEntry entry = entry_for_key(aKey, store);
		entrymap.remove(aKey);
		if (dirty.contains(entry)) {dirty.remove(entry);}
		//
		Assert.postcondition("!keycontained",    !has_entry_for_key(aKey));
//		Assert.postcondition("!associated",      entry_for_key(aKey, store)==entry);
		Assert.postcondition("!newEntryIsDirty", !dirty.contains(entry)); // was AKey: kept failing
	}

	static interface lazyEntry {
		HiStoreEntry_J2 get();
		long ident();
	}
	static class diskEntry implements lazyEntry {
		public diskEntry(HiStoreEntry_J2 aMember) { member = aMember; }
		private HiStoreEntry_J2 member;
		public HiStoreEntry_J2 get() {return member;}

		public long ident() {
			return member.getIdentifier();
		}
	}
	static class serialEntry implements lazyEntry {
		private HiStore_J2 store;
		private long _ident;
//		private String key;

		public serialEntry(HiStore_J2 aStore, long a_ident) {
			store = aStore;
			_ident = a_ident;
		}

//		public serialEntry(HiStoreEntry_J2 aMember) { member = aMember;}
//		private HiStoreEntry_J2 member;

		public HiStoreEntry_J2 get() {
			final HiStoreEntry_J2 R = new HiStoreEntry_J2(store, ident());
////		// fix serialization error
////		if (store == null) {store = aHiStore_j1;dirty=new Vector();}
////		if (R.host_store ==  null &&!= null)
////			R.host_store =  store;
////		return R;
//			assert R.host_store == null;
//			assert store != null;
//			R.host_store = store;
			return R;
		}

		public long ident() {
			return _ident;
		}
	}
}
