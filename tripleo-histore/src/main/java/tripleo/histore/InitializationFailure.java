package tripleo.histore;

/**
 * Date: Feb 8, 2005 Time: 2:41:50 PM <p/>$Id: InitializationFailure.java,v 1.2
 * 2005/02/09 04:19:19 olu Exp $
 */
public class InitializationFailure extends HiStoreException {
	private Exception because_of;

	// @Override
	@Unique public Exception getReason() {
		return because_of;
	}

	public InitializationFailure(Exception aE) {
		because_of = aE;
	}
}

@interface Unique {
}
