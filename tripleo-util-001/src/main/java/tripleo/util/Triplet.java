package tripleo.util;

/**
 * Date: Feb 8, 2005
 * Time: 4:10:53 PM
 * <p/>
 * $Id: Triplet.java,v 1.1.1.1 2005/02/20 01:46:40 olu Exp $
 */
public class Triplet <A,B,C> {
	public A o1;
	public B o2;
	public C o3;

//	public static Triplet make(A a1, B a2, C a3) {
	public static Triplet make(Object a1, Object a2, Object a3) {
		Triplet his=new Triplet();
		his.o1 = a1;
		his.o2 = a2;
		his.o3 = a3;
		return his;
	}
}
