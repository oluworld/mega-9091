/*
 * Created on Feb 6, 2005
 *
 * $Id: ResourceViewHelper.java,v 1.1.1.1 2005/02/27 22:27:21 olu Exp $
 */
package tripleo.cottontail.viewer;

import java.io.File;
import java.util.*;

import org.eclipse.jface.viewers.*;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.*;

import tripleo.util.Pair;
import tripleo.util.DomainMap;
import tripleo.cottontail.objects.V.ResourceObject;

public class ResourceViewHelper
		extends LabelProvider 
		implements IColorProvider, ITreeContentProvider, 
			ISelectionChangedListener, IOpenListener, IDoubleClickListener {

	private final ControlExample mExample;
	private       Object         initial = null;
	private       ResourceObject mSelection;
	final static  KeyChain       keychain = new KeyChain();
	private final Map<ResourceObject, Pair> opentabs=new HashMap<>();

	public ResourceViewHelper(ControlExample aExample) {
		mExample = aExample;
	}
	
	private ResourceObject find_domain_object(Object element) {
		return keychain.get(element);
	}

	public Object[] getChildren(Object element) {
		final ResourceObject domain_object = find_domain_object(element);
		Object[] R = domain_object.getKids();
		return R;
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
		if (fcwe.isOdd())
			C = new Color(Display.getCurrent(), 0xff, 0, 0);
		else
			C = new Color(Display.getCurrent(), 0, 0xff, 0);
		return C;
	}

	Object initial() {
		if (initial == null) {
			final File kid = new File(".");
			final ResourceObject K = new ResourceObject(kid, this);
			initial = keychain.allocate();
			keychain.write(initial, K); // TODO: cumbersome
		}
		return initial;
	}

	ListViewer make_lv(final Composite aParent) {
		return make_lv(aParent, initial(), mExample);
	}

	private ListViewer make_lv(
			final Composite aParent, 
			final Object aInitial, 
			final ControlExample aP) {
		ListViewer R = new ListViewer(aParent);
		R.setContentProvider(this);
		R.setLabelProvider(this);
		R.addFilter(new ViewerFilter() {
			public boolean select(Viewer viewer, Object parent, Object element) {
				final ResourceObject fcwe = keychain.get(element);
				final String name = fcwe.kid().getName();
				//
				return !name.endsWith(".svn");
			}
		});
		R.setInput(aInitial);
		R.getControl().setSize(-1, -1);
		R.addSelectionChangedListener(this);
		R.addOpenListener(this);
		return R;
	}

	public static KeyChain keychain() {
		return keychain;
	}

	public void open(OpenEvent event) {
		// System.out.println(event.getSelection());
		final ISelection selection = event.getSelection();
		final ResourceObject fcw = keychain.get(selection);
		//
		System.err.println("100 " + fcw.getContentText());
		//
		mExample.stv.setText(fcw.getContentText());
	}
	
	public void selectionChanged(SelectionChangedEvent event) {
		final StructuredSelection selection = (StructuredSelection) event.getSelection();
		final Object              H         = selection.getFirstElement();
		final ResourceObject      fcw       = (ResourceObject) keychain.get(H);
		//
		changeTo(fcw, H);
	}

	private void changeTo(ResourceObject aFcw, Object H) {
		if (!opentabs.containsKey(aFcw)) {
			openTabFor(aFcw);
			mExample.vvh.changeTo(H);
		} else {
			Pair b = opentabs.get(aFcw);
			mExample.tabFolder.setSelection(new TabItem[]{(TabItem) b.second});
		}
		//
		final String T = aFcw.getContentText();
		mExample.stv.append("\n" + T);
		this.mSelection = aFcw;
	}

	private void openTabFor(ResourceObject aResource) {
		final TabFolder tabFolder = mExample.tabFolder;
		final String         name = aResource.getName();
		final StyledText  content = newStv(tabFolder);
		final TabItem           f = Util.add_tab_to_folder(tabFolder, name, content, aResource);
		opentabs.put(aResource, Pair.make(content,f));
		content.setText("open a version from the right...");
	}

	private StyledText newStv(Composite parent) {
		StyledText R = new StyledText(parent, 0xb02);
		R.setEditable(false);
//		ctv.setMenu(menu_manager.createContextMenu(ctv)); // TODO:
		return R;
	}

	public void doubleClick(DoubleClickEvent event) {
		final ISelection selection = event.getSelection();
		final ResourceObject fcw = find_domain_object(selection);
		//
		System.err.println("200 " + fcw.getContentText());
		//
		mExample.stv.setText(fcw.getContentText());
		this.mSelection=fcw;
	}

	public Object getSelection() {
		return mSelection;
	}

	public static final class KeyChain extends DomainMap<Integer, ResourceObject> {

		public Integer allocate() {
			Integer R = new Integer(++id);
			return R;
		}

		// covaraint returns. no it actually matches!
		@Override public ResourceObject get(Object i) {return Get((Integer)i);}
		public ResourceObject Get(Integer i) {
			return super.get(i);
		}

		private /*static*/ int id = 0;
	}

}
