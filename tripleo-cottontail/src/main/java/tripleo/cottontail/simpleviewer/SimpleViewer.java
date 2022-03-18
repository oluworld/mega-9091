//package tripleo.cottontail.simpleviewer;
//
//import com.cloudgarden.resource.SWTResourceManager;
//import org.eclipse.swt.*;
//import org.eclipse.swt.custom.*;
//import org.eclipse.swt.events.*;
//import org.eclipse.swt.layout.*;
//import org.eclipse.swt.widgets.*;
//
//import silk.*;
//
//public class SimpleViewer extends org.eclipse.swt.widgets.Composite implements KeyListener {
//
//	private Menu menu1;
//	private SashForm sashForm1;
//	private MenuItem aboutMenuItem;
//	private MenuItem prefsMenuItem;
//	private Menu helpMenu;
//	private MenuItem views_menu;
//	private MenuItem exitMenuItem;
//	private MenuItem closeFileMenuItem;
//	private MenuItem saveFileMenuItem;
//	private MenuItem newFileMenuItem;
//	private MenuItem openFileMenuItem;
//	private Group group1;
//	private Text text1;
//	private Combo combo1;
//	private StyledText resultWindow;
//	private StyledText consoleWindow;
//	private StyledText historyWindow;
//	private SashForm sashForm2;
//	private Menu fileMenu;
//	private MenuItem appMenuItem;
//
//	{
//		//Register as a resource user - SWTResourceManager will
//		//handle the obtaining and disposing of resources
//		SWTResourceManager.registerResourceUser(this);
//	}
//
//	public SimpleViewer(Composite aparent, int astyle) {
//		super(aparent, astyle);
//		initGUI();
//	}
//
//	/**
//	 * Initializes the GUI.
//	 */
//	private void initGUI() {
//		try {
//			this.setSize(new org.eclipse.swt.graphics.Point(400, 300));
//			this.setBackground(SWTResourceManager.getColor(192, 192, 192));
//			GridLayout thisLayout = new GridLayout(1, true);
//			thisLayout.marginWidth = 5;
//			thisLayout.marginHeight = 5;
//			thisLayout.numColumns = 1;
//			thisLayout.makeColumnsEqualWidth = true;
//			thisLayout.horizontalSpacing = 5;
//			thisLayout.verticalSpacing = 5;
//			this.setLayout(thisLayout);
//			{
//				sashForm1 = new SashForm(this, SWT.NONE);
//				GridData sashForm1LData = new GridData();
//				sashForm1.setLayoutData(sashForm1LData);
//				{
//					sashForm2 = new SashForm(sashForm1, SWT.NONE);
//					sashForm2.setOrientation(SWT.VERTICAL);
//					{
//						historyWindow = new StyledText(sashForm2, SWT.NONE);
////						historyWindow.setBounds(0, 0, 228, 77);
//						historyWindow.setEditable(false);
//					}
//					{
//						consoleWindow = new StyledText(sashForm2, SWT.NONE);
////						consoleWindow.setSize(60, 30);
//						consoleWindow.addKeyListener(this);
//					}
//					{
//						resultWindow = new StyledText(sashForm2, SWT.NONE);
////						resultWindow.setSize(60, 30);
//						resultWindow.setEditable(false);
//					}
//				}
//				{
//					group1 = new Group(sashForm1, SWT.NONE);
//					RowLayout group1Layout = new RowLayout(org.eclipse.swt.SWT.HORIZONTAL);
//					group1.setLayout(group1Layout);
//					group1.setText("group1");
//					group1.setSize(56, 14);
//					{
//						combo1 = new Combo(group1, SWT.NONE);
//						combo1.setText("combo1");
//						combo1.setSize(60, 30);
//					}
//					{
//						text1 = new Text(group1, SWT.MULTI | SWT.WRAP);
//						text1.setText("text1");
//						text1.setSize(58, 28);
//					}
//				}
////				sashForm1.setSize(60, 30);
////				sashForm1LData.widthHint = 60;
////				sashForm1LData.heightHint = 30;
//				sashForm1LData.grabExcessHorizontalSpace = true;
//				sashForm1LData.grabExcessVerticalSpace = true;
//				sashForm1LData.widthHint = 390;
//				sashForm1LData.heightHint = 300;
//			}
//			{
//				menu1 = new Menu(getShell(), SWT.BAR);
//				getShell().setMenuBar(menu1);
//				{
//					appMenuItem = new MenuItem(menu1, SWT.CASCADE);
//					appMenuItem.setText("A&pp");
//					appMenuItem.setSelection(false);
//					{
//						helpMenu = new Menu(appMenuItem);
//						appMenuItem.setMenu(helpMenu);
//						{
//							prefsMenuItem = new MenuItem(helpMenu, SWT.CASCADE);
//							prefsMenuItem.setText("&Preferences");
//						}
//						{
//							aboutMenuItem = new MenuItem(helpMenu, SWT.CASCADE);
//							aboutMenuItem.setText("About");
//						}
//						{
//							exitMenuItem = new MenuItem(helpMenu, SWT.CASCADE);
//							exitMenuItem.setText("E&xit");
//						}
//					}
//				}
//				{
//					views_menu = new MenuItem(menu1, SWT.CASCADE);
//					views_menu.setText("Views");
//					{
//						fileMenu = new Menu(views_menu);
//						views_menu.setMenu(fileMenu);
//						{
//							openFileMenuItem = new MenuItem(fileMenu, SWT.CASCADE);
//							openFileMenuItem.setText("Open");
//						}
//						{
//							newFileMenuItem = new MenuItem(fileMenu, SWT.CASCADE);
//							newFileMenuItem.setText("New");
//						}
//						{
//							saveFileMenuItem = new MenuItem(fileMenu,
//							        SWT.CASCADE);
//							saveFileMenuItem.setText("Save");
//						}
//						{
//							closeFileMenuItem = new MenuItem(fileMenu,
//							        SWT.CASCADE);
//							closeFileMenuItem.setText("Close");
//						}
//					}
//				}
//			}
//			this.layout();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	/**
//	 * Auto-generated main method to display this
//	 * org.eclipse.swt.widgets.Composite inside a new Shell.
//	 */
//	public static void main(String[] args) {
//		Display display = Display.getDefault();
//		Shell shell = new Shell(display);
//		/*SimpleViewer inst =*/ new SimpleViewer(shell, SWT.NULL);
////		Point size = inst.getSize();
//		shell.setLayout(new RowLayout());//FillLayout());
//		shell.layout();
////		if(size.x == 0 && size.y == 0) {
////			inst.pack();
////			shell.pack();
////		} else {
////			Rectangle shellBounds = shell.computeTrim(0, 0, size.x, size.y);
////			if (shell.getMenuBar() != null)
////				shellBounds.height -= 22;
////			shell.setSize(shellBounds.width, shellBounds.height);
////		}
//		shell.open();
//		while (!shell.isDisposed()) {
//			if (!display.readAndDispatch())
//				display.sleep();
//		}
//	}
//
//	public void keyPressed(KeyEvent e) {
////		return super.key
//	}
//
//	public void keyReleased(KeyEvent e) {
//
//		if (e.keyCode == '\r') { // ENTER key
//			if (meta_mode) {
//				meta_mode = false;
//			} else {
//				final String text = ((StyledText) e.getSource()).getText();
//				historyWindow.append("----\n" + text);
//				final String res = engine.result(text);
//				resultWindow.append("----\n" + res);
//			}
//		} else if ((e.stateMask & SWT.ALT) == SWT.ALT && (e.keyCode == 'x')) {
//			System.out.println("Meta-x");
//			meta_mode = true;
//		} else if (e.keyCode == SWT.BS) { // backspace
//			if (meta_mode) {}
//		}
//
//	}
//
//	boolean meta_mode;
//	ViewerEngine engine = new ViewerEngine();
//
//}
