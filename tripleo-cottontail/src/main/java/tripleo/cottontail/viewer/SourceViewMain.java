/*
* $Id: SourceViewMain.java,v 1.1.1.1 2005/02/20 02:07:31 olu Exp $
 */
package tripleo.cottontail.viewer;

import org.eclipse.swt.widgets.Display;

public class SourceViewMain {

    public static SourceViewWindow instance;

    public static void main(String[] args) {
        instance = new SourceViewWindow();
        instance.setBlockOnOpen(true);
        //
        instance.open();
        Display.getCurrent().dispose();
//		Util.getClipboard().dispose();
    }
}
