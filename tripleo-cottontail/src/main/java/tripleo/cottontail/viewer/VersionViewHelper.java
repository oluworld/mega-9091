/*
 * Created on Feb 6, 2005
 *
 * $Id: VersionViewHelper.java,v 1.1.1.1 2005/02/27 22:27:22 olu Exp $
 */
package tripleo.cottontail.viewer;

import java.util.*;

import org.eclipse.jface.viewers.*;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import tripleo.cottontail.objects.V.ResourceObject;
import tripleo.cottontail.objects.V.VersionObject;

class VersionViewHelper extends LabelProvider implements IColorProvider,
        ITreeContentProvider, ISelectionChangedListener, IOpenListener,
        IDoubleClickListener {

    private final ControlExample mExample;
    private ListViewer vvh;

//	private Object initial = null;
    public VersionViewHelper(ControlExample aExample) {
        mExample = aExample;
    }

    private ResourceObject find_domain_object(Object element) {
        return ResourceViewHelper.keychain.get(element);
    }

    public Object[] getChildren(Object element) {
        final ResourceObject fcwe = find_domain_object(element);
        if (fcwe != null) {
            return fcwe.getKids();
        } else {
            return new Object[0];
        }
    }

    public Object[] getElements(Object element) {
        return getChildren(element);
    }

    public boolean hasChildren(Object element) {
        return getChildren(element).length > 0;
    }

    public Object getParent(Object element) {
        final ResourceObject fcwe = find_domain_object(element);
        return fcwe.kid().getParent();
    }

    public void dispose() {
    }

    public void inputChanged(Viewer viewer, Object old_input, Object new_input) {
        int y = 2;//Assert.not_implemented();
    }

    public String getText(Object element) {
        final ResourceObject fcwe = find_domain_object(element);
        return fcwe.kid().getName();
    }

    public Image getImage(Object element) {
        final ResourceObject fcwe = find_domain_object(element);
        final String s = fcwe.kid().isDirectory() ? "folder" : "file";
        //
        return Util.getImageRegistry().get(s);
    }

    public Color getForeground(Object element) {
        return null;
    }

    public Color getBackground(Object element) {
        Color C;
        final ResourceObject fcwe = find_domain_object(element);
        if (fcwe.isOdd()) {
            C = new Color(Display.getCurrent(), 0xff, 0, 0);
        } else {
            C = new Color(Display.getCurrent(), 0, 0xff, 0);
        }
        return C;
    }

    Object initial() {
        return mExample.rvh.getSelection();
//		if (initial == null) {
//			final File kid = new File("/");
//			final ResourceObject K = new ResourceObject(kid);
//			initial = SourceViewMain.keychain.allocate();
//			SourceViewMain.keychain.write(initial, K); // TODO: cumbersome
//		}
//		return initial;
    }

    ListViewer make_lv(final Composite aParent) {
        return vvh = make_lv(aParent, initial(), mExample);
    }

    private ListViewer make_lv(final Composite aParent, final Object aInitial,
            final ControlExample aP) {
        ListViewer R = new ListViewer(aParent);
        R.setContentProvider(this);
        R.setLabelProvider(this);
        // R.addFilter(new ViewerFilter() {
        // public boolean select(Viewer viewer, Object parent, Object element) {
        // final ResourceObject fcwe =
        // SourceViewMain.keychain.get(element);
        // //
        // return fcwe.kid().isDirectory();
        // }
        // });
        R.setInput(aInitial);
        R.getControl().setSize(-1, -1);
        R.addSelectionChangedListener(this);
        R.addOpenListener(this);
        return R;
    }

    public void open(OpenEvent event) {
        // System.out.println(event.getSelection());
        final ISelection selection = event.getSelection();
        final ResourceObject fcw = ResourceViewHelper.keychain.get(selection);
        //
        System.err.println("200 " + fcw.getContentText());
        //
        mExample.stv.setText(fcw.getContentText());
    }

    public void selectionChanged(SelectionChangedEvent event) {
        final StructuredSelection selection = (StructuredSelection) event
                .getSelection();
        final Object o = ResourceViewHelper.keychain.get(selection.getFirstElement());
        FileContentWrapper fcw = (FileContentWrapper) o;
        //
        System.out.println("210 " + fcw.getContentText());
        //
        mExample.stv.setText("" + fcw.getContentText());
    }

    public void doubleClick(DoubleClickEvent event) {
        final ISelection selection = event.getSelection();
        final ResourceObject fcw = ResourceViewHelper.keychain.get(selection);
        //
        System.err.println("200 " + fcw.getContentText());
        //
        mExample.stv.setText(fcw.getContentText());
    }

    public void changeTo(Object anObject) {
        ResourceObject res = ResourceViewHelper.keychain.get(anObject);
        List<VersionObject> verslist = res.getVersions();
        vvh.setInput(anObject);
    }
}

//
// eof
//
