/*
 * Date: Oct 13, 2003
 * Time: 2:51:22 AM
 */
package tripleo.histore.j1;

import java.io.*;
import java.util.List;
import java.util.Vector;

import tripleo.util.Assert;
import tripleo.util.UT;
import tripleo.util.Triplet;
import tripleo.histore.HiStoreEntry;
import tripleo.histore.ConsistencyFailure;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HiStoreEntry_J1 implements HiStoreEntry, Serializable {

    transient /*final*/ HiStore_J1 host_store;   //% ctorset
    transient private boolean committed;
    transient private static final Log log = LogFactory.getLog(HiStoreEntry_J1.class);

    private static final char FOR_CONTENT = 'C';
    private static final char FOR_METADATA = 'M';

    private /*final*/ long identifier; //% ctorset // java int32's rollover apparently

    transient private OutputStream cw; // TODO: renull these variables when close is called
    transient private InputStream cr;  // TODO: either on them or this
    transient private InputStream mr;
    transient private OutputStream mw;

//	private boolean cws;    // cw accesscondition -> cws != null
    // Closable<IS> cw...
//	Hashtable metaData = new Hashtable();
//	Vector metaDomains
    // TODO: what to do with this??
    transient private final List<Triplet<Object, Object, Object>> umd = new Vector<>();
    transient private Object uc = null;

    public HiStoreEntry advance() {
        final HiStoreEntry entry = new HiStoreEntry_J1(host_store, identifier + 1);
        return entry;
    }

    private HiStoreEntry_J1() {
        super();
    }

    public HiStoreEntry_J1(HiStore_J1 aStore, long anAllocatedId) {
        host_store = aStore;
        identifier = anAllocatedId;
        committed = false;
    }

    private void writeObject(java.io.ObjectOutputStream out)
            throws IOException {
        out.writeLong(identifier);
    }

    private void readObject(java.io.ObjectInputStream in)
            throws IOException, ClassNotFoundException {
        identifier = in.readLong();
    }

    public InputStream contentReader() throws ConsistencyFailure {
        if (cr == null) {
            cr = host_store.readStreamFor(identifier, FOR_CONTENT);
        }
        return cr;
    }

    public OutputStream contentWriter() throws ConsistencyFailure {
//		assert host_store!=null; // fials when object is serialized
//		log.info("host_store "+host_store);
        if (cw == null) {
            cw = host_store.writeStreamFor(identifier, FOR_CONTENT);
        }
//		assert cw!=null;
        return cw;
    }

    public InputStream metaReader() throws ConsistencyFailure {
        if (mr == null) {
            mr = host_store.readStreamFor(identifier, FOR_METADATA);
        }
        return mr;
    }

    public OutputStream metaWriter() throws ConsistencyFailure {
        if (mw == null) {
            mw = host_store.writeStreamFor(identifier, FOR_METADATA);
        }
        return mw;
    }

    public boolean commit(Writer aWriter) {
        log.info("~~ HIS Commit " + identifier);
        //
        boolean R = false;
        if (__commit()) {
            writeMeta(aWriter); // TODO: done twicw
            R = true;
        }
        log.info("~~ HIS Commit <<done>>" + identifier);
        return R;
    }

    private boolean __commit() { // TODO: throws commit failure
        Assert.check("not committed", !committed);
        synchronized (umd) {
//			PrintWriter pw;
            try {
                writeMeta0(new FileWriter(getFileName(FOR_METADATA)));
                committed = true;
            } catch (IOException e) {
                final String S = "789789 metadata " + e;
                UT.errW.println(S);
                log.warn(S);
            }
            if (uc == null) {
                final String S = "978978 commit entry(" + getIdentifier() + "): null content  ";
                UT.errW.println(S);
                log.warn(S);
            } else {
                _writeHelper(FOR_CONTENT, uc.toString(), "789789 content  ");
            }
        }
        return committed;
    }

    private void writeMeta0(Writer aWriter) throws IOException {
        log.trace("twice");
        PrintWriter pw;
        pw = new PrintWriter(aWriter);
        // TODO: _writeHelper(FOR_METADATA, aa, "789789 content  ");
        for (Object o : umd) {
            Triplet triplet = (Triplet) o;
            c_put((String) triplet.o3, pw); // domain
            c_put((triplet.o1).toString(), pw); // key
            c_put((String) triplet.o2, pw); // value
        }
        pw.close();
    }

    private void writeMeta(Writer aWriter) {
        try {
            // TODO: write a contract for these methods
            writeMeta0(aWriter);
            committed = true;
        } catch (IOException e) {
            // TODO: provide access to exception?
            committed = false;
        }
    }

    private void _writeHelper(char cOm, String aFileContent, String aDuring) {
        FileWriter os;
        try {
            os = new FileWriter(getFileName(cOm));
            os.write(aFileContent);
            os.close();
        } catch (IOException e) {
            UT.errW.println(aDuring + e);
        }
    }

    private String getFileName(char c) {
        return host_store.getFileName(identifier, c);
    }

    public void c_put(String s1, PrintWriter pw) {
        final byte[] bytes = s1.getBytes();
        pw.print(UT.hexify(identifier));
        pw.print(bytes);
    }

    public boolean periodic_clean() {
        boolean R = false;
        if (!committed) {
            R = __commit();
        }
        return R;
    }

    public void setDataForDomain(String aKey, Object aValue, String aDomain) {
        /*
		if (aValue instanceof String) {
			Assert.not_implemented();
		} else if (aValue instanceof InputStream) {
			Assert.not_implemented();
		} else {
			Assert.not_implemented();
		}
         */
//		metaData.put(aKey,
        umd.add(Triplet.make(aKey, aValue, aDomain));
    }

    public void setContent(Object aContent) {
        if (uc != null) {
            throw new IllegalArgumentException("uc != null");
        }
        if (aContent == null) {
            throw new IllegalArgumentException("aContent == null");
        }
        /*
		if (aContent instanceof String) {
			Assert.not_implemented();
		} else if (aContent instanceof InputStream) {
			Assert.not_implemented();
		} else {
			Assert.not_implemented();
		}
         */
        uc = aContent;
    }

    public long getIdentifier() {
        return identifier;
    }

}
