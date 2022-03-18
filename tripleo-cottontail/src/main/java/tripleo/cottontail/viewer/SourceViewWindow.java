/*
 * Created on Feb 6, 2005
 *
 * $Id: SourceViewWindow.java,v 1.1.1.1 2005/02/21 23:13:15 olu Exp $
 */
package tripleo.cottontail.viewer;

import java.util.*;
import java.io.InputStream;
import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.custom.*;
import org.eclipse.swt.graphics.*;

import org.eclipse.jface.action.*;
import org.eclipse.jface.window.*;
import tripleo.util.DomainMap;


public class SourceViewWindow extends ControlExample {
	private ExitAction exit_action;
//	private OpenAction open_action;
//	private RefreshAction refresh_action;
	private SourceViewAction source_view_action; 
	
	public SourceViewWindow() {
		super(null);

		exit_action = new ExitAction(this);
//		refresh_action = new RefreshAction(this);
//		open_action = new OpenAction(this);
		source_view_action = new SourceViewAction(this);
		
		addStatusLine();
		addMenuBar();
		addToolBar(SWT.FLAT | SWT.WRAP);
	}

	void mm(MenuManager aMenu_manager) {
		aMenu_manager.add(exit_action);
//		aMenu_manager.add(refresh_action);
//		aMenu_manager.add(open_action);
	}
	void mm3(ToolBarManager aTool_bar_manager) {
		aTool_bar_manager.add(exit_action);
//		aTool_bar_manager.add(refresh_action);
//		aTool_bar_manager.add(open_action);
	}
	MenuManager i_createMenuManager() {
		MenuManager bar_menu = new MenuManager("");
	
		MenuManager file_menu = new MenuManager("&App");
//		MenuManager edit_menu = new MenuManager("&Edit");
		MenuManager view_menu = new MenuManager("&Views");
	
		bar_menu.add(file_menu);
//		bar_menu.add(edit_menu);
		bar_menu.add(view_menu);
	
		file_menu.add(exit_action);
//		edit_menu.add(refresh_action);
//		edit_menu.add(open_action);
		view_menu.add(source_view_action);
	
		return bar_menu;
	}

}

abstract class ControlExample extends ApplicationWindow {

// public static void main(String args[])
//	{
//		Display display = new Display();
//		Shell shell = new Shell(display);
//		shell.setLayout(new FillLayout());
//		ControlExample instance = new ControlExample(shell);
//		shell.setText(getResourceString("window.title"));
//		setShellSize(display, shell);
//		shell.open();
//		while(!shell.isDisposed()) 
//			if(!display.readAndDispatch())
//				display.sleep();
//		instance.dispose();
//	}

	static final int ciClosedFolder = 0;
	static final int ciOpenFolder = 1;
	static final int ciTarget = 2;
	static final String[] imageLocations = {
		"icons/closedFolder.gif", "icons/openFolder.gif", "icons/target.gif"
	};
	TabFolder tabFolder;

	public static String getResourceString(String s) {
		return s;
	}
	
	public boolean startup;

//	private ListViewer lv;
//	private TreeViewer tv;
	public StyledText stv,ctv;
//	public TableViewer tbv;

	Vector<Object[]> vvv = new Vector<Object[]>();
	
	public ControlExample(Shell aShell) {
		super(aShell);
	}

//	public void add(long time, int index, short code, String msg) {
//		Object[] m = new Object[]{new Long(time), new Integer(index), new Integer(code), msg};
//		vvv.add(m);
//	}

	protected Control createContents(Composite parent) {
		getShell().setText("SourceView");
		
		initResources();

		MenuManager menu_manager = new MenuManager();
		SashForm sash_form = new SashForm(parent, SWT.HORIZONTAL | SWT.NULL);

		rvh.make_lv(sash_form);

		{
//			SashForm vertsash = new SashForm(sash_form , SWT.VERTICAL | SWT.NULL);
			SashForm vertsash = sash_form;
			tabFolder = mktabs(vertsash);
			if (true) {
				stv = new StyledText(tabFolder, 0xb02);
				stv.setEditable(false);
				stv.setMenu(menu_manager.createContextMenu(stv));
				//
				Util.add_tab_to_folder(tabFolder, "stv", stv, stv);
			}
		}

		{
			SashForm sash_form2 = new SashForm(sash_form, SWT.VERTICAL | SWT.NULL);
			vvh.make_lv(sash_form2);
			{
				ctv = new StyledText(sash_form2, 0xb02);
				ctv.setEditable(false);
				ctv.setMenu(menu_manager.createContextMenu(ctv));
			}
		}

		mm(menu_manager);

		return sash_form;
	}

	TabFolder mktabs(SashForm parent) {
		Tab tabs[] = createTabs();
		TabFolder tabFolder2 = new TabFolder(parent, SWT.NULL);
		for (Tab tab : tabs) {
			Util.add_tab_to_folder(tabFolder2, tab.getTabText(), tab.createTabFolderPage(tabFolder2), tab);
		}
		return tabFolder2;
	}

	abstract MenuManager i_createMenuManager() ;
	protected MenuManager createMenuManager() {
		return i_createMenuManager();
	}

	Tab[] createTabs() {
		return (new Tab[]{
//			new ButtonTab(this),
//			new StyledTextTab(this)
		});

	}

	protected ToolBarManager createToolBarManager(int style) {
		ToolBarManager tool_bar_manager = new ToolBarManager(style);
		mm3(tool_bar_manager);
		return tool_bar_manager;
	}
	
	void freeResources(){}

	ResourceViewHelper rvh = new ResourceViewHelper(this);
	VersionViewHelper  vvh = new VersionViewHelper(this);

	void initResources() {
		Class clazz = ControlExample.class;
//		if (resourceBundle != null)
			try {
				if (images == null) {
					images = new Image[imageLocations.length];
					for (int i = 0; i < imageLocations.length; i++) {
						InputStream sourceStream = clazz
								.getResourceAsStream(imageLocations[i]);
						ImageData source = new ImageData(sourceStream);
						ImageData mask = source.getTransparencyMask();
						images[i] = new Image(null, source, mask);
						try {
							sourceStream.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				return;
			} catch (Throwable _ex) {
				_ex.printStackTrace();
			}
//		String error = resourceBundle == null ? "Unable to load resources"
//				: getResourceString("error.CouldNotLoadResources");
			freeResources();
//		throw new RuntimeException(error);
	}


	abstract void mm(MenuManager aMenu_manager);
	abstract void mm3(ToolBarManager aTool_bar_manager) ;

	Image[] images;
}
