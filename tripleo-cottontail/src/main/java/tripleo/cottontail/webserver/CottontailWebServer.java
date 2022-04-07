package tripleo.cottontail.webserver;

import tripleo.cottontail.Cottontail;
import tripleo.histore.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CottontailWebServer {

    public static void main(String[] args) throws InitializationFailure, AllocationFailure, IOException, ConsistencyFailure {
        new CottontailWebServer().r();
    }

    private void r() throws InitializationFailure, IOException, AllocationFailure, ConsistencyFailure {
        Cottontail c = new Cottontail("srvdemo");
        /*
		PythonScript s = c.create_python("hello");
		s.preprocess("cherry");
		s.set_content("print 'hello', bill or 'world'");
		s.add_param("bill", "string", false);
		s.write();

		c.call("hello", new HashMap());

		Map p= new HashMap();
		p.put("bill","bill");
		c.call("hello", p);
         */
        Transaction<CottonServer> T = c.create_http(9070);
        T.start();
    }
}
