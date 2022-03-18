/*
 * Created on Apr 12, 2004
 *
 */
package tripleo.util;

public class Pair { 
	public Object first, second;
	public static Pair make(Object aFirst, Object aSecond) {
		Pair R=new Pair();
		R.first = aFirst;
		R.second = aSecond;
		return R;
	}
	public String toString( ){
		String s="<"+first+ " "+second +">";
		return s;
	}
}