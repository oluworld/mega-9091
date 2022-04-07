package tripleo.histore;

/**
 * Date: Feb 8, 2005 Time: 2:41:50 PM
 * <p/>
 * $Id: ConsistencyFailure.java,v 1.1.1.1 2005/02/09 04:19:16 olu Exp $
 */
public class ConsistencyFailure extends HiStoreException {

    private final Constants because_of;

    @Unique
    public Constants getReason() {
        return because_of;
    }

    public ConsistencyFailure(Constants aE) {
        because_of = aE;
    }
}
