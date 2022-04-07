/*
 * Created on Oct 16, 2005 7:00:22 AM
 * 
 * $Id: IHttpServer.java,v 1.1 2005/10/16 14:21:55 olu Exp $
 *
 */
package tripleo.http;

public interface IHttpServer {

//---------------------------------------------------------------------------
//  Client can use this
//---------------------------------------------------------------------------
    void run_server();

//	---------------------------------------------------------------------------
//  Reimplement these
//---------------------------------------------------------------------------
    /**
     *
     * @param aRequest
     * @param aResponse
     * @throws HttpException
     */
    void action(IRequest aRequest, IResponse aResponse) throws HttpException;

    ReWriter rewriter();

    void serve_action();

    boolean still_serving();

}
