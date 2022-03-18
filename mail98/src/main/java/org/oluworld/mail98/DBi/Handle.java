package mail98.DBi;

import org.python.core.Py;
import org.python.core.PyCode;
import org.python.core.PyDictionary;
import org.python.core.PyException;
import org.python.core.PyFrame;
import org.python.core.PyFunction;
import org.python.core.PyFunctionTable;
import org.python.core.PyObject;
import org.python.core.PyRunnable;
import org.python.core.PyString;
import org.python.core.imp;

public class Handle {
   static String[] jpy$properties = new String[]{"python.modules.builtin", "exceptions:org.python.core.exceptions", "python.options.showJavaExceptions", "true"};
   static String[] jpy$packages = new String[]{"java.io", null, "javax.swing.text", null, "javax.swing.tree", null, "java.awt.print", null, "java.awt.peer", null, "java.awt.font", null, "javax.swing.colorchooser", null, "java.awt.datatransfer", null, "java.awt.geom", null, "java.lang", null, "javax.swing.undo", null, "java.awt", "Choice,PrintGraphics,ImageCapabilities,DisplayMode,Cursor,GradientPaint,Robot,GridLayout,CheckboxMenuItem,Window,GraphicsConfiguration,BasicStroke,AWTEvent,TextField,AWTException,Menu,Insets,Shape,PointerInfo,GraphicsEnvironment,MenuShortcut,LayoutManager2,AlphaComposite,GridBagLayout,Frame,Font,KeyEventPostProcessor,Scrollbar,Panel,MouseInfo,FileDialog,ScrollPaneAdjustable,Event,Checkbox,ItemSelectable,DefaultKeyboardFocusManager,GraphicsConfigTemplate,FontMetrics,ComponentOrientation,BufferCapabilities,AWTKeyStroke,DefaultFocusTraversalPolicy,PaintContext,List,CompositeContext,MenuContainer,TextComponent,KeyEventDispatcher,PrintJob,SystemColor,ActiveEvent,TextArea,GraphicsDevice,Adjustable,FontFormatException,Rectangle,FocusTraversalPolicy,RenderingHints,AWTPermission,Component,TexturePaint,AWTEventMulticaster,Stroke,MediaTracker,BorderLayout,Point,HeadlessException,Paint,ScrollPane,Graphics,MenuBar,Color,FlowLayout,Label,Button,Transparency,Graphics2D,GridBagConstraints,IllegalComponentStateException,CardLayout,KeyboardFocusManager,CheckboxGroup,Toolkit,Dialog,Polygon,PageAttributes,Container,Composite,JobAttributes,MenuComponent,Canvas,ContainerOrderFocusTraversalPolicy,EventQueue,PopupMenu,LayoutManager,MenuItem,Image,Dimension,AWTError", "javax.swing.event", "PopupMenuListener,HyperlinkEvent,MenuKeyEvent,UndoableEditEvent,MenuDragMouseListener,ChangeEvent,TreeExpansionEvent,InternalFrameListener,TreeWillExpandListener,AncestorEvent,ListSelectionEvent,HyperlinkListener,DocumentListener,TableColumnModelEvent,AncestorListener,TreeModelEvent,TableModelEvent,TreeExpansionListener,ListSelectionListener,InternalFrameEvent,MouseInputListener,TreeSelectionEvent,SwingPropertyChangeSupport,ChangeListener,ListDataEvent,TableModelListener,CaretEvent,PopupMenuEvent,EventListenerList,MenuEvent,MouseInputAdapter,UndoableEditListener,ListDataListener,MenuListener,DocumentEvent,MenuDragMouseEvent,InternalFrameAdapter,CaretListener,TreeModelListener,MenuKeyListener,TableColumnModelListener,CellEditorListener,TreeSelectionListener", "javax.swing.border", null, "javax.swing.filechooser", null, "java.awt.im", null, "java.awt.image", null, "javax.swing.table", "TableColumnModel,TableColumn,TableCellEditor,DefaultTableModel,AbstractTableModel,DefaultTableColumnModel,JTableHeader,TableModel,TableCellRenderer,DefaultTableCellRenderer", "java.awt.dnd", null, "java.awt.color", null, "java.awt.event", "ComponentEvent,PaintEvent,InvocationEvent,FocusListener,HierarchyBoundsAdapter,MouseListener,MouseWheelEvent,FocusEvent,WindowEvent,AdjustmentListener,MouseEvent,ComponentListener,ItemEvent,KeyListener,HierarchyEvent,KeyEvent,InputEvent,WindowListener,HierarchyBoundsListener,MouseMotionListener,ActionListener,WindowAdapter,WindowStateListener,InputMethodEvent,MouseWheelListener,TextListener,KeyAdapter,AdjustmentEvent,ItemListener,ContainerAdapter,ActionEvent,InputMethodListener,MouseAdapter,FocusAdapter,TextEvent,HierarchyListener,ContainerListener,AWTEventListenerProxy,WindowFocusListener,ComponentAdapter,MouseMotionAdapter,AWTEventListener,ContainerEvent", "javax.swing", "WindowConstants,ComboBoxModel,DefaultListModel,PopupFactory,Timer,JRootPane,AbstractAction,DebugGraphics,DefaultButtonModel,ListSelectionModel,JMenuItem,ScrollPaneConstants,ComponentInputMap,DefaultComboBoxModel,UIManager,JTextField,AbstractButton,MutableComboBoxModel,AbstractCellEditor,SpinnerModel,JLabel,OverlayLayout,DesktopManager,JColorChooser,ToolTipManager,DefaultListCellRenderer,BoxLayout,SpringLayout,SwingUtilities,JTabbedPane,ProgressMonitorInputStream,JInternalFrame,ImageIcon,JRadioButton,TransferHandler,Box,SizeRequirements,InternalFrameFocusTraversalPolicy,LookAndFeel,ViewportLayout,JProgressBar,ButtonGroup,JToolBar,JDialog,BorderFactory,JTextArea,Renderer,JSeparator,JApplet,MenuElement,JToggleButton,JPasswordField,SpinnerDateModel,ListCellRenderer,JTree,InputVerifier,AbstractListModel,JMenu,JComboBox,MenuSelectionManager,JScrollPane,UIDefaults,FocusManager,SingleSelectionModel,InputMap,CellEditor,JFrame,JFormattedTextField,JTable,Spring,ButtonModel,JComponent,ComboBoxEditor,RootPaneContainer,SortingFocusTraversalPolicy,SpinnerListModel,JSpinner,BoundedRangeModel,JCheckBox,DefaultBoundedRangeModel,JMenuBar,JPopupMenu,ProgressMonitor,Popup,CellRendererPane,RepaintManager,Scrollable,AbstractSpinnerModel,ListModel,DefaultSingleSelectionModel,GrayFilter,KeyStroke,SizeSequence,UnsupportedLookAndFeelException,JLayeredPane,LayoutFocusTraversalPolicy,JCheckBoxMenuItem,ScrollPaneLayout,DefaultDesktopManager,JSplitPane,SpinnerNumberModel,JPanel,JDesktopPane,DefaultFocusManager,JRadioButtonMenuItem,JWindow,JToolTip,JSlider,JList,Action,JViewport,JTextPane,JScrollBar,JEditorPane,DefaultListSelectionModel,JFileChooser,JButton,DefaultCellEditor,SwingConstants,JOptionPane,Icon,ActionMap", "javax.swing.plaf", null};

   public static void moduleDictInit(PyObject var0) {
      var0.__setitem__("__name__", new PyString("Handle"));
      Py.runCode((new Handle._PyInner()).getMain(), var0, var0);
   }

   public static void main(String[] var0) {
      String[] var1 = new String[var0.length + 1];
      var1[0] = "Handle";
      System.arraycopy(var0, 0, var1, 1, var0.length);
      Py.runMain("mail98.DBi.Handle$_PyInner", var1, jpy$packages, jpy$properties, "mail98.DBi", new String[]{"DBi.Server", "etoffiutils", "DBi.Handle", "javapath", "MMS", "traceback", "stat", "string", "linecache", "DBi.__init__", "javaos", "rfc822"});
   }

   public static class _PyInner extends PyFunctionTable implements PyRunnable {
      private static PyObject s$0;
      private static PyObject s$1;
      private static PyFunctionTable funcTable;
      private static PyCode c$0_enum;
      private static PyCode c$1_getStrWithDefault;
      private static PyCode c$2_getStr;
      private static PyCode c$3_setRoot;
      private static PyCode c$4___init__;
      private static PyCode c$5_AwxDBi;
      private static PyCode c$6_main;

      private static void initConstants() {
         s$0 = Py.newString("/local/DBi/");
         s$1 = Py.newString("/local/data/Projects/98-mail/98/DBi/Handle.py");
         funcTable = new Handle._PyInner();
         c$0_enum = Py.newCode(3, new String[]{"self", "Key", "kind", "rv"}, "/local/data/Projects/98-mail/98/DBi/Handle.py", "enum", false, false, funcTable, 0, (String[])null, (String[])null, 0, 1);
         c$1_getStrWithDefault = Py.newCode(3, new String[]{"self", "Key", "default", "rv"}, "/local/data/Projects/98-mail/98/DBi/Handle.py", "getStrWithDefault", false, false, funcTable, 1, (String[])null, (String[])null, 0, 1);
         c$2_getStr = Py.newCode(2, new String[]{"self", "Key", "rv"}, "/local/data/Projects/98-mail/98/DBi/Handle.py", "getStr", false, false, funcTable, 2, (String[])null, (String[])null, 0, 1);
         c$3_setRoot = Py.newCode(2, new String[]{"self", "root"}, "/local/data/Projects/98-mail/98/DBi/Handle.py", "setRoot", false, false, funcTable, 3, (String[])null, (String[])null, 0, 1);
         c$4___init__ = Py.newCode(2, new String[]{"self", "root"}, "/local/data/Projects/98-mail/98/DBi/Handle.py", "__init__", false, false, funcTable, 4, (String[])null, (String[])null, 0, 1);
         c$5_AwxDBi = Py.newCode(0, new String[0], "/local/data/Projects/98-mail/98/DBi/Handle.py", "AwxDBi", false, false, funcTable, 5, (String[])null, (String[])null, 0, 0);
         c$6_main = Py.newCode(0, new String[0], "/local/data/Projects/98-mail/98/DBi/Handle.py", "main", false, false, funcTable, 6, (String[])null, (String[])null, 0, 0);
      }

      public PyCode getMain() {
         if (c$6_main == null) {
            initConstants();
         }

         return c$6_main;
      }

      public PyObject call_function(int var1, PyFrame var2) {
         switch(var1) {
         case 0:
            return enum$1(var2);
         case 1:
            return getStrWithDefault$2(var2);
         case 2:
            return getStr$3(var2);
         case 3:
            return setRoot$4(var2);
         case 4:
            return __init__$5(var2);
         case 5:
            return AwxDBi$6(var2);
         case 6:
            return main$7(var2);
         default:
            return null;
         }
      }

      private static PyObject enum$1(PyFrame var0) {
         var0.setlocal(3, var0.getglobal("DBiServer").__getattr__("enum").__call__(var0.getlocal(1), var0.getlocal(0).__getattr__("root"), var0.getlocal(2)));
         return var0.getlocal(3);
      }

      private static PyObject getStrWithDefault$2(PyFrame var0) {
         try {
            var0.setlocal(3, var0.getlocal(0).invoke("getStr", var0.getlocal(1)));
         } catch (Throwable var3) {
            PyException var1 = Py.setException(var3, var0);
            if (!Py.matchException(var1, var0.getglobal("KeyError"))) {
               throw var1;
            }

            var0.setlocal(3, var0.getlocal(2));
         }

         return var0.getlocal(3);
      }

      private static PyObject getStr$3(PyFrame var0) {
         var0.setlocal(2, var0.getglobal("DBiServer").__getattr__("getStr").__call__(var0.getlocal(1), var0.getlocal(0).__getattr__("root")));
         return var0.getlocal(2);
      }

      private static PyObject setRoot$4(PyFrame var0) {
         var0.getlocal(0).__setattr__("root", var0.getlocal(1));
         return Py.None;
      }

      private static PyObject __init__$5(PyFrame var0) {
         var0.getlocal(0).__setattr__("values", new PyDictionary(new PyObject[0]));
         var0.getlocal(0).invoke("setRoot", var0.getlocal(1));
         return Py.None;
      }

      private static PyObject AwxDBi$6(PyFrame var0) {
         var0.setlocal("enum", new PyFunction(var0.f_globals, new PyObject[]{var0.getname("EnumRecursive")}, c$0_enum));
         var0.setlocal("getStrWithDefault", new PyFunction(var0.f_globals, new PyObject[0], c$1_getStrWithDefault));
         var0.setlocal("getStr", new PyFunction(var0.f_globals, new PyObject[0], c$2_getStr));
         var0.setlocal("setRoot", new PyFunction(var0.f_globals, new PyObject[0], c$3_setRoot));
         var0.setlocal("__init__", new PyFunction(var0.f_globals, new PyObject[]{s$0}, c$4___init__));
         return var0.getf_locals();
      }

      private static PyObject main$7(PyFrame var0) {
         var0.setglobal("__file__", s$1);
         PyObject[] var1 = imp.importFrom("Server", new String[]{"DBiServer"}, var0);
         var0.setlocal("DBiServer", var1[0]);
         var1 = imp.importFrom("Structure", new String[]{"EnumFlat", "EnumRecursive"}, var0);
         var0.setlocal("EnumFlat", var1[0]);
         var0.setlocal("EnumRecursive", var1[1]);
         var0.setlocal("AwxDBi", Py.makeClass("AwxDBi", new PyObject[0], c$5_AwxDBi, (PyObject)null));
         return Py.None;
      }
   }
}
