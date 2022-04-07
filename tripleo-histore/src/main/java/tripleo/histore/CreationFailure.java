/*
 * Created on Mar 23, 2004
 *
 */
package tripleo.histore;

public class CreationFailure extends Exception {

	private final Exception ae;

	public CreationFailure(Exception aException) {
		ae= aException;
	}

	public String toString() {
		return "CreationFailure: "+ae.toString();
	}
}
