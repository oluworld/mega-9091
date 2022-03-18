package tripleo.cottontail.viewer;

import org.eclipse.jface.resource.*;
import org.eclipse.swt.widgets.*;

import java.net.*;

class Util {
	private static ImageRegistry image_registry;
//	private static Clipboard clipboard;

	private Util() {}

	public static URL newURL(String url_name) {
		try {
			return new URL(url_name);
		} catch (MalformedURLException e) {
			throw new RuntimeException("Malformed URL " + url_name);//, e); //TODO
		}
	}

	public static ImageRegistry getImageRegistry() {
		if (Util.image_registry == null) {
			Util.image_registry = new ImageRegistry();
			Util.image_registry.put("folder",
			        ImageDescriptor.createFromURL(Util.newURL("file:icons/folder.gif")));
			Util.image_registry.put("file",
			        ImageDescriptor.createFromURL(Util.newURL("file:icons/file.gif")));
		}
		return Util.image_registry;
	}

/*	public static Clipboard getClipboard() {
		if (Util.clipboard == null) {
			Util.clipboard = new Clipboard(Display.getCurrent());
		}

		return Util.clipboard;
	}
*/
	public static TabItem add_tab_to_folder(final TabFolder aTabFolder, final String title, final Composite content, final Object data) {
		TabItem item = new TabItem(aTabFolder, 0);
		item.setText(title);
		item.setControl(content);
		item.setData(data);
		return item;
	}
}
/*
class FileTreeLabelProvider extends LabelProvider implements IColorProvider {
	public String getText(Object element) {
		final FileContentWrapper<File> fcwe = SourceViewMain.keychain.get(element);
		return fcwe.kid().getName();
	}

	public Image getImage(Object element) {
		final FileContentWrapper<File> fcwe = SourceViewMain.keychain.get(element);
		final String s = fcwe.kid().isDirectory()
		        ? "folder"
		        : "file";
		//
		return Util.getImageRegistry().get(s);
	}

	public Color getForeground(Object element) {
		return null;
	}

	public Color getBackground(Object element) {
		Color C;
		final FileContentWrapper<File> fcwe = SourceViewMain.keychain.get(element);
		if (fcwe.isOdd())
			C = new Color(Display.getCurrent(), 0xff, 0, 0);
		else
			C = new Color(Display.getCurrent(), 0, 0xff, 0);
		return C;
	}
}

class FileTableLabelProvider implements ITableLabelProvider {
	public String getColumnText(Object element, int column_index) {
		if (column_index == 0) {
			return ((File) element).getName();
		}

		if (column_index == 1) {
			return "" + ((File) element).length();
		}

		return "";
	}

	public void addListener(ILabelProviderListener ilabelproviderlistener) {
	}

	public void dispose() {
	}

	public boolean isLabelProperty(Object obj, String s) {
		return false;
	}

	public void removeListener(ILabelProviderListener ilabelproviderlistener) {
	}

	public Image getColumnImage(Object element, int column_index) {

		if (column_index != 0) {
			return null;
		}

		if (((File) element).isDirectory()) {
			return Util.getImageRegistry().get("folder");
		} else {
			return Util.getImageRegistry().get("file");
		}
	}
}

class FileTableContentProvider implements IStructuredContentProvider {
	public Object[] getElements(Object element) {
		Object[] kids;
		assert element instanceof FileContentWrapper;
		final FileContentWrapper<File> fcwe = (FileContentWrapper<File>) element;
		kids = fcwe.kid().listFiles();
		return kids == null ? new Object[0] : kids;
	}

	public void dispose() {
	}

	public void inputChanged(Viewer viewer, Object old_object, Object new_object) {
		int y = 2;
	}
}

class FileSorter extends ViewerSorter {

	public int compare(Viewer viewer, Object e1, Object e2) {
		return super.compare(viewer, e1, e2);
	}

	public boolean isSorterProperty(Object element, String property) {
		return super.isSorterProperty(element, property);
	}

	public void sort(Viewer viewer, Object[] elements) {
		super.sort(viewer, elements);
	}

	public int category(Object element) {
		return ((File) element).isDirectory() ? 0 : 1;
	}
}
*/

class FileContentWrapper <T> {

	public FileContentWrapper(T aKid) {
		kid = (T) aKid;
		id = FileContentWrapper.i++;
	}

	public boolean isOdd() {
		return (id % 2) == 0x0;
	}

	public T kid() {
		return kid;
	}

// ------------------------------
	private Object[] kids;
	private T kid;
	private int id;
	private boolean checked;
	private static int i = 1;
// ------------------------------

	public String getContentText() {
		return "" + id;
	}

/*
	private Object[] __getKids() {
		File[] kids1 = ((File) (Object) kid).listFiles(); // TODO: hardcoded
		Object[] R;
		//
		if (kids1 != null) {
			R = new Object[kids1.length]; // TODO: change Object here and watch idea4 fail
			for (int i1 = 0; i1 < kids1.length; i1++) {
				final File kid1 = (File) kids1[i1];
				final ResourceObject K = new ResourceObject(kid1);

				Object or = ResourceViewHelper.keychain.allocate();
				ResourceViewHelper.keychain.write(or, K);

				R[i1] = or;
			}
		} else {
			R = new Object[0];
		}
		return R;
	}
*/

/*
	public Object[] getKids() {
		Object[] R;
		if (checked) {
			R = kids;
		} else {
			R = __getKids();
			checked = true;
			kids = R;
		}
		return R;
	}
*/
}

/*
class AllowOnlyFoldersFilter extends ViewerFilter {
	public boolean select(Viewer viewer, Object parent, Object element) {
		final FileContentWrapper<File> fcwe = SourceViewMain.keychain.get(element);

		return fcwe.kid().isDirectory();
	}

}

class ListContentProvider implements ITreeContentProvider {
	public Object[] getChildren(Object element) {
		// will prolly use xmlrpc to ask NumberServer for responses
		Object[] R;
		final FileContentWrapper<File> fcwe = SourceViewMain.keychain.get(element);
		R = fcwe.getKids();
		return R;
	}

	public Object[] getElements(Object element) {
		return getChildren(element);
	}

	public boolean hasChildren(Object element) {
		return getChildren(element).length > 0;
	}

	public Object getParent(Object element) {
		final FileContentWrapper<File> fcwe = SourceViewMain.keychain.get(element);
		return fcwe.kid().getParent();
	}

	public void dispose() {
	}

	public void inputChanged(Viewer viewer, Object old_input, Object new_input) {
	}
}
*/
