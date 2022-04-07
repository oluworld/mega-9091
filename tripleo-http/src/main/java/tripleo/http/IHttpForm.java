package tripleo.http;

public interface IHttpForm {

    void action();

    void setRequest(IRequest aReq);

    void setResponse(IResponse aRsp);

    void validate();

}
