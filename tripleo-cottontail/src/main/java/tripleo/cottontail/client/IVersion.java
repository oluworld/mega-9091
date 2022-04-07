package tripleo.cottontail.client;

import java.util.Iterator;

/**
 * Date: Feb 19, 2005 Time: 6:44:04 PM
 * <p/>
 * $Id: IVersion.java,v 1.1.1.1 2005/02/27 23:24:04 olu Exp $
 */
public interface IVersion {

    String getName();

    String getContent();

    String getComment();

    void setName(String aName);

    void setContent(String aContent);

    void setComment(String aComment);

    Iterator<CmntKey> comments();
}
