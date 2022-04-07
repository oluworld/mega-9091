/*
 * Created on Mar 23, 2004
 *
 * $Id: J1_System.java,v 1.2 2005/08/08 02:31:59 olu Exp $
 * 
 * Korsikovs disease
 */
package tripleo.histore.j1;

import org.prevayler.Command;
import org.prevayler.PrevalentSystem;
import org.prevayler.implementation.AbstractPrevalentSystem;

import java.io.*;
import java.util.*;

import tripleo.util.Assert;
import tripleo.util.FuckUp;
import tripleo.histore.HiStoreEntry;
import tripleo.curr.MonitoredRunner;

// TODO: maybe integrate System and Store?? why have them separate?
/**
 * the methods modify the members, which are always in a consistent state
 */
public class J1_System extends AbstractPrevalentSystem implements Serializable {

    transient /*final*/ HiStore_J1 store; // damn serialization
    transient private /*final*/ List<HiStoreEntry_J1> dirty;

    private final List<Long> numbers;
    final Map<String, lazyEntry> entrymap; // Used in HiStoreSystem

    public J1_System(HiStore_J1 st) {
        store = st;
        numbers = new ArrayList<Long>();
        dirty = new Vector<HiStoreEntry_J1>();
        entrymap = new Hashtable<String, lazyEntry>();
    }

    void keep(long nextNumber) {
        // TODO: now that we have a ref to store, just ask #entrymap, right?
        // TODO: why store data twice?
        //
        // might need to store locally in a dirty list until we can ensure
        // it will be removed by an add_entry command
        //
        numbers.add(new Long(nextNumber));
    }

    boolean allocated(long target) {
        return numbers.contains(new Long(target));
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

        private final MonitoredRunner monitored_instance;

        public void run() {
            while (monitored_instance.stillRunning()) {
                try {
                    Thread.sleep(90 * 1000);
                } catch (InterruptedException e) {
                }
                if (dirty == null) {
                    dirty = new Vector<>(); // HACK
                }
                synchronized (dirty) {
                    Writer wr = c1();
                    c2(wr);
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
            Iterator<HiStoreEntry_J1> dit = dirty.iterator();
            while (dit.hasNext()) {
                HiStoreEntry_J1 storeEntry = dit.next();
                boolean b = storeEntry.commit(aWr);
                if (b) {
                    dit.remove();
                }
            }
        }
    }

    /*
	private List numbers() {
		return numbers;
	}

	private long lastNumber() {
		return numbers.isEmpty() ? 0 : ((Long) numbers.get(numbers.size() - 1))
		        .longValue();
	}
     */
    /**
     * To change the state of the business objects, the client code must use a
     * Command like this one.
     */
    public static class NumberStorageCommand implements Command {

        private final long numberToKeep;

        public NumberStorageCommand(long anumberToKeep) {
            numberToKeep = anumberToKeep;
        }

        public Serializable execute(PrevalentSystem system) throws Exception {
            ((J1_System) system).keep(numberToKeep);
            return null;
        }
    }

    /**
     * To change the state of the business objects, the client code must use a
     * Command like this one.
     */
    public static class EntryStorageCommand implements Command {

        private final String name;
        private final HiStoreEntry_J1 value;

        public EntryStorageCommand(String aName, HiStoreEntry_J1 aEntry) {
            name = aName;
            value = aEntry;
        }

        public Serializable execute(PrevalentSystem system) throws Exception {
            ((J1_System) system).add_entry(name, value);
            return null;
        }
    }

    /**
     * This is a callback method used to enforce encapsulation. Maybe use an
     * inner class...
     *
     * @param aKey
     * @param entry
     */
    void add_entry(final String aKey, final HiStoreEntry_J1 entry) {
        final lazyEntry te = mkEntry(entry);
        entrymap.put(aKey, te/*new Long(identifier)*/);
        dirty.add(entry);
        //
        Assert.postcondition("keycontained", has_entry_for_key(aKey));
        Assert.postcondition("associated", entry_for_key(aKey, store) == te);
        Assert.postcondition("newEntryIsDirty", dirty.contains(entry)); // was AKey: kept failing
    }

    private lazyEntry mkEntry(HiStoreEntry_J1 aEntry) {
        final lazyEntry R;
        if (aEntry.host_store == null) {
            R = new serialEntry(aEntry);
        } else {
            R = new diskEntry(aEntry);
        }
        return R;
    }

    boolean has_entry_for_key(String aKey) {
        return entrymap.containsKey(aKey);
    }

    HiStoreEntry entry_for_key(String aKey, HiStore_J1 aHiStore_j1) {
        final HiStoreEntry_J1 R = entrymap.get(aKey).get();
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
        if (dirty.contains(entry)) {
            dirty.remove(entry);
        }
        //
        Assert.postcondition("!keycontained", !has_entry_for_key(aKey));
//		Assert.postcondition("!associated",      entry_for_key(aKey, store)==entry);
        Assert.postcondition("!newEntryIsDirty", !dirty.contains(entry)); // was AKey: kept failing
    }

    interface lazyEntry {

        HiStoreEntry_J1 get();
    }

    static class diskEntry implements lazyEntry, Serializable {

        public diskEntry(HiStoreEntry_J1 aMember) {
            member = aMember;
        }
        private final HiStoreEntry_J1 member;

        public HiStoreEntry_J1 get() {
            return member;
        }
    }

    class serialEntry implements lazyEntry, Serializable {

        public serialEntry(HiStoreEntry_J1 aMember) {
            member = aMember;
        }
        private final HiStoreEntry_J1 member;

        public HiStoreEntry_J1 get() {
            final HiStoreEntry_J1 R = member;//entrymap.get(aKey);
//		// fix serialization error
//		if (store == null) {store = aHiStore_j1;dirty=new Vector();}
//		if (R.host_store ==  null && store != null)
//			R.host_store =  store;
//		return R;
            assert R.host_store == null;
            assert store != null;
            R.host_store = store;
            return R;
        }
    }
}
