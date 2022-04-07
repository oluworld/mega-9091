/*
 * Date: Dec 12, 2004
 * Time: 9:35:05 AM
 */
package tripleo.appz.net.urlsink;

import java.io.Serializable;

import org.prevayler.Command;
import org.prevayler.PrevalentSystem;

import rabbit.http.HTTPHeader;

class RequestStorageCommand implements Command {

    final String date;
    final String uri;
    final HTTPHeader header;

    public RequestStorageCommand(String date, String uri, HTTPHeader header) {
        this.date = date;
        this.uri = uri;
        this.header = header;
    }

    public Serializable execute(PrevalentSystem system) throws Exception {
        ((VecVecVecStore) system).keep(date, uri, header);
        return null;
    }
}
