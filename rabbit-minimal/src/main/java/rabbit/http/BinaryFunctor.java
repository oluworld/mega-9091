package rabbit.http;

public interface BinaryFunctor<X,Y> {
	/**
	 *
	 * @param s
	 * @param s2
	 * @return true to terminate loop
	 */
    boolean call(X s, Y s2);
}
