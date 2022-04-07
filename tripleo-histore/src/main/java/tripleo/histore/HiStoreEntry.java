package tripleo.histore;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;

/**
 * Date: Feb 8, 2005 Time: 11:21:30 PM
 * <p/>
 * $Id: HiStoreEntry.java,v 1.1.1.1 2005/02/20 01:45:30 olu Exp $
 */
public interface HiStoreEntry {

    HiStoreEntry advance(); // TODO:

    InputStream contentReader() throws ConsistencyFailure;

    OutputStream contentWriter() throws ConsistencyFailure;

    InputStream metaReader() throws ConsistencyFailure;

    OutputStream metaWriter() throws ConsistencyFailure;

    boolean commit(Writer aWriter);

    boolean periodic_clean();

    void setDataForDomain(String aKey, Object aValue, String aDomain);

    void setContent(Object aContent);

    long getIdentifier();
}
