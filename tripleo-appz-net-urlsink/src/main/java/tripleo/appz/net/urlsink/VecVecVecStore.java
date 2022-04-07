/*
 * Date: Dec 12, 2004
 * Time: 9:34:49 AM
 */
package tripleo.appz.net.urlsink;

import java.util.ArrayList;
import java.util.List;

import org.prevayler.implementation.AbstractPrevalentSystem;

import rabbit.http.HTTPHeader;

class VecVecVecStore extends AbstractPrevalentSystem {

//    private static final long serialVersionUID = 3690480199305476150L;
    /*private*/ final List<Datum> requests = new ArrayList<>();

    void deactivate(String aDate, String aURI) {
        //numbers.add(new VecVecVec.VecVecVecStore.Datum(aDate, aURI));
        //TODO:
    }

    void keep(String aDate, String aURI, HTTPHeader header) {
        requests.add(new Datum(aDate, aURI, header, true, "falsecat"));
    }

    List<Datum> storage() {
        return requests;
    }

//		long lastNumber() {
//			return numbers.isEmpty() ? 0 : ((Long) numbers.get(numbers.size() - 1))
//					.longValue();
//		}
//
//		boolean allocated(long target) {
//			return numbers.contains(new Long(target));
//		}
}
