package tripleo.cottontail.viewer;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;

class SourceViewAction extends Action {
	private SourceViewWindow window;

	public SourceViewAction(SourceViewWindow w) {
		window = w;
		setToolTipText("Open a new SourceView window");
//		setText("Copy File &Names@Ctrl+Shift+C");
		setText("Open Source View");
		setImageDescriptor(ImageDescriptor.createFromURL(Util.newURL("file:icons/copy.gif")));
	}

	public void run() {
		new SourceViewWindow().open();
	}
}

class ExitAction extends Action {
	private ControlExample window;

	public ExitAction(ControlExample w) {
		window = w;
		setText("E&xit@Ctrl+W");
		setToolTipText("Exit the application");
		setImageDescriptor(ImageDescriptor.createFromURL(Util.newURL("file:icons/close.gif")));
	}

	public void run() {
		window.close();
	}
}
class PreferencesAction extends Action {
	private ControlExample window;

	public PreferencesAction(ControlExample w) {
		window = w;
		setText("&Preferences@Ctrl+e");
		setToolTipText("Preferences");
		setImageDescriptor(ImageDescriptor.createFromURL(Util.newURL("file:icons/close.gif")));
	}

	public void run() {
		window.close();
	}
}


/*class OpenAction
        extends Action
        implements ISelectionChangedListener, IDoubleClickListener {
	private SourceViewMain window;

	public OpenAction(SourceViewMain w) {
		window = w;
		setText("Run");
		setToolTipText("Run the associated program on a file");
		setEnabled(false);
		setImageDescriptor(ImageDescriptor.createFromURL(Util.newURL("file:icons/run.gif")));
	}

	public void run() {
		IStructuredSelection selection = null;//window.getTableSelection();
		if (selection.size() != 1) {
			return;
		}

		File selected_file = (File) selection.getFirstElement();
		if (selected_file.isFile()) {
			Program.launch(selected_file.getAbsolutePath());
		}
	}

	public void selectionChanged(SelectionChangedEvent event) {
		setText("Run");
		setToolTipText("Run the associated program on a file");
		setEnabled(false);

		IStructuredSelection selection = null;//window.getTableSelection();
		if (selection.size() != 1) {
			setToolTipText(getToolTipText() + " (Only enabled when exactly one item is selected)");
			return;
		}

		File file = (File) selection.getFirstElement();
		if (file.isFile()) {
			setEnabled(true);
			setText("Run the associated program on " + file.getName());
			setToolTipText("Run the program asociated with "
			        + file.getName()
			        + " with this file as the argument");
		}
	}

	public void doubleClick(DoubleClickEvent event) {
		run();
	}
}*/
/*class RefreshAction extends Action {
	private SourceViewMain window;

	public RefreshAction(SourceViewMain w) {
		window = w;
		setToolTipText("Copy absolute file names of selected files to the clipboard");
		setText("Copy File &Names@Ctrl+Shift+C");
		setImageDescriptor(ImageDescriptor.createFromURL(Util.newURL("file:icons/copy.gif")));
	}

	public void run() {
		window.stv.setText("Hello");
//		window.setStatus(string_buffer.toString());
	}
}
*/
