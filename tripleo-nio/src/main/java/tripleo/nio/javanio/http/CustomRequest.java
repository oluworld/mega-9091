package tripleo.nio.javanio.http;

import tripleo.util.Triplet;
import tripleo.http.*;
import tripleo.http.impl.HeaderRequest;
import tripleo.http.impl.SB_Response;

import java.nio.ByteBuffer;

/**
 * Date: Oct 16, 2005
 * Time: 8:10:04 AM
 * <p/>
 * $Id: CustomRequest.java,v 1.1 2005/10/16 14:18:53 olu Exp $
 */
public interface CustomRequest {
	boolean parse();
	boolean build();

	CRR parseResult(ByteBuffer rbb);
	Reply buildResult(Request request);

	class CRR {
		Request request;
		Reply reply;
		HttpException exc;

		public static CRR make(IRequest aRequest, IResponse aResponse, HttpException e) {
			CRR R=new CRR();
//			R.request=aRequest;
//			R.reply=aReply;
			R.exc=e;
			return R;
		}

		public static CRR make(Request aRequest, Reply aReply, HttpException e) {
			CRR R=new CRR();
			R.request=aRequest;
			R.reply=aReply;
			R.exc=e;
			return R;
		}
	}
}

// TODO at some date in the future, simplify this class
