package tripleo.nio.javanio.http;

import java.net.URI;

import tripleo.nio.javanio.http.JN_Request.Action;

public interface Request {

	Action action();
	String version();
	URI uri();
	String toString();

}
