/*
 * Created on Mar 23, 2004
 *
 */
package tripleo.histore;

public class AllocationFailure extends HiStoreException {

    public Exception myException;
    public Constants myReason;

    public AllocationFailure(Constants aMyReason, Exception aMyException) {
        myException = aMyException;
        myReason = aMyReason;
    }

    public String toString() {
        return "AllocationFailure: " + myException.toString();
    }
}
