/*
 * Created on Aug 8, 2005 10:16:35 AM
 * 
 * $Id$
 *
 */
package tripleo.histore;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author alimoe
 *
 */
public class HiStoreTests {

	public static void main(String[] args) {
		junit.swingui.TestRunner.run(HiStoreTests.class);
	}

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for tripleo.histore");
		//$JUnit-BEGIN$

		//$JUnit-END$
		
		suite.addTestSuite(HiStoreTest.class);
		
		return suite;
	}
}

