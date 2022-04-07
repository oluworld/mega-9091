/**
 *
 */
package tripleo.http;

/**
 * @author client
 *
 */
public interface IHTTPRequestLine {

    String method();

    String version();

    String uri();

}
