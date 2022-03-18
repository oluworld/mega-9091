/*
 * Created on Oct 9, 2005 9:26:53 AM
 * 
 * $Id: CtorSet.java,v 1.3 2005/10/11 19:21:44 olu Exp $
 *
 */
package tripleo.annotation;

import java.lang.annotation.*;

/**
 * The target variable is only assigned within a constructor 
 * 
 * @author alimoe
 *
 */
@Documented
@Target(ElementType.FIELD)
public @interface CtorSet {

}

