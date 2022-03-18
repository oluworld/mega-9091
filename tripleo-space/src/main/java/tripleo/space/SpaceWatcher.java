package tripleo.space;

/**
 * Date: Dec 27, 2004
 * Time: 11:51:48 PM
 *
 * $Id: SpaceWatcher.java,v 1.1.1.1 2005/02/04 04:25:30 olu Exp $
 *
 */
public interface SpaceWatcher<J> {
	boolean watch(SpaceNugget<J> aNugget);
}
