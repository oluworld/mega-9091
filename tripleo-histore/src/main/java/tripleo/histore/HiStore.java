package tripleo.histore;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Date: Feb 8, 2005
 * Time: 11:04:27 PM
 * <p/>
 * $Id: HiStore.java,v 1.1.1.1 2005/06/20 07:48:00 olu Exp $
 */
public interface HiStore {
	InputStream readStreamFor(long identifier, char aFor) throws ConsistencyFailure;

	OutputStream writeStreamFor(long identifier, char aFor) throws ConsistencyFailure;

	String mangle_name(long identifier, char aFor);

	HiStoreEntry alloc(String aKey) throws AllocationFailure, ConsistencyFailure;

	HiStoreEntry insert(String aKey) throws AllocationFailure, ConsistencyFailure;

	HiStoreEntry first();

	//void removeEntryForKey() throws ConsistencyFailure;

	// in the same tradition as alloc/insert
	// TODO: change alloc/insert to <OpaqueIdentifier>, and to return EntryCap
	// TODO: then add HiStoreEntry entry_for_cap(EntryCap aec)
	// Java really needs a typedef
	HiStoreEntry walk_open(String aPath);
}
// TODO: fix this
// enum AllocFor { FOR_CONTENT = 'C', FOR_METADATA = 'M'; }

