package mail98;

import org.python.core.*;

public class stat extends java.lang.Object {
    static String[] jpy$properties = new String[] {"python.modules.builtin", "exceptions:org.python.core.exceptions", "python.options.showJavaExceptions", "true"};
    static String[] jpy$packages = new String[] {"java.io", null, "javax.swing.text", null, "javax.swing.tree", null, "java.awt.print", null, "java.awt.peer", null, "java.awt.font", null, "javax.swing.colorchooser", null, "java.awt.datatransfer", null, "java.awt.geom", null, "java.lang", null, "javax.swing.undo", null, "java.awt", "Choice,PrintGraphics,ImageCapabilities,DisplayMode,Cursor,GradientPaint,Robot,GridLayout,CheckboxMenuItem,Window,GraphicsConfiguration,BasicStroke,AWTEvent,TextField,AWTException,Menu,Insets,Shape,PointerInfo,GraphicsEnvironment,MenuShortcut,LayoutManager2,AlphaComposite,GridBagLayout,Frame,Font,KeyEventPostProcessor,Scrollbar,Panel,MouseInfo,FileDialog,ScrollPaneAdjustable,Event,Checkbox,ItemSelectable,DefaultKeyboardFocusManager,GraphicsConfigTemplate,FontMetrics,ComponentOrientation,BufferCapabilities,AWTKeyStroke,DefaultFocusTraversalPolicy,PaintContext,List,CompositeContext,MenuContainer,TextComponent,KeyEventDispatcher,PrintJob,SystemColor,ActiveEvent,TextArea,GraphicsDevice,Adjustable,FontFormatException,Rectangle,FocusTraversalPolicy,RenderingHints,AWTPermission,Component,TexturePaint,AWTEventMulticaster,Stroke,MediaTracker,BorderLayout,Point,HeadlessException,Paint,ScrollPane,Graphics,MenuBar,Color,FlowLayout,Label,Button,Transparency,Graphics2D,GridBagConstraints,IllegalComponentStateException,CardLayout,KeyboardFocusManager,CheckboxGroup,Toolkit,Dialog,Polygon,PageAttributes,Container,Composite,JobAttributes,MenuComponent,Canvas,ContainerOrderFocusTraversalPolicy,EventQueue,PopupMenu,LayoutManager,MenuItem,Image,Dimension,AWTError", "javax.swing.event", "PopupMenuListener,HyperlinkEvent,MenuKeyEvent,UndoableEditEvent,MenuDragMouseListener,ChangeEvent,TreeExpansionEvent,InternalFrameListener,TreeWillExpandListener,AncestorEvent,ListSelectionEvent,HyperlinkListener,DocumentListener,TableColumnModelEvent,AncestorListener,TreeModelEvent,TableModelEvent,TreeExpansionListener,ListSelectionListener,InternalFrameEvent,MouseInputListener,TreeSelectionEvent,SwingPropertyChangeSupport,ChangeListener,ListDataEvent,TableModelListener,CaretEvent,PopupMenuEvent,EventListenerList,MenuEvent,MouseInputAdapter,UndoableEditListener,ListDataListener,MenuListener,DocumentEvent,MenuDragMouseEvent,InternalFrameAdapter,CaretListener,TreeModelListener,MenuKeyListener,TableColumnModelListener,CellEditorListener,TreeSelectionListener", "javax.swing.border", null, "javax.swing.filechooser", null, "java.awt.im", null, "java.awt.image", null, "javax.swing.table", "TableColumnModel,TableColumn,TableCellEditor,DefaultTableModel,AbstractTableModel,DefaultTableColumnModel,JTableHeader,TableModel,TableCellRenderer,DefaultTableCellRenderer", "java.awt.dnd", null, "java.awt.color", null, "java.awt.event", "ComponentEvent,PaintEvent,InvocationEvent,FocusListener,HierarchyBoundsAdapter,MouseListener,MouseWheelEvent,FocusEvent,WindowEvent,AdjustmentListener,MouseEvent,ComponentListener,ItemEvent,KeyListener,HierarchyEvent,KeyEvent,InputEvent,WindowListener,HierarchyBoundsListener,MouseMotionListener,ActionListener,WindowAdapter,WindowStateListener,InputMethodEvent,MouseWheelListener,TextListener,KeyAdapter,AdjustmentEvent,ItemListener,ContainerAdapter,ActionEvent,InputMethodListener,MouseAdapter,FocusAdapter,TextEvent,HierarchyListener,ContainerListener,AWTEventListenerProxy,WindowFocusListener,ComponentAdapter,MouseMotionAdapter,AWTEventListener,ContainerEvent", "javax.swing", "WindowConstants,ComboBoxModel,DefaultListModel,PopupFactory,Timer,JRootPane,AbstractAction,DebugGraphics,DefaultButtonModel,ListSelectionModel,JMenuItem,ScrollPaneConstants,ComponentInputMap,DefaultComboBoxModel,UIManager,JTextField,AbstractButton,MutableComboBoxModel,AbstractCellEditor,SpinnerModel,JLabel,OverlayLayout,DesktopManager,JColorChooser,ToolTipManager,DefaultListCellRenderer,BoxLayout,SpringLayout,SwingUtilities,JTabbedPane,ProgressMonitorInputStream,JInternalFrame,ImageIcon,JRadioButton,TransferHandler,Box,SizeRequirements,InternalFrameFocusTraversalPolicy,LookAndFeel,ViewportLayout,JProgressBar,ButtonGroup,JToolBar,JDialog,BorderFactory,JTextArea,Renderer,JSeparator,JApplet,MenuElement,JToggleButton,JPasswordField,SpinnerDateModel,ListCellRenderer,JTree,InputVerifier,AbstractListModel,JMenu,JComboBox,MenuSelectionManager,JScrollPane,UIDefaults,FocusManager,SingleSelectionModel,InputMap,CellEditor,JFrame,JFormattedTextField,JTable,Spring,ButtonModel,JComponent,ComboBoxEditor,RootPaneContainer,SortingFocusTraversalPolicy,SpinnerListModel,JSpinner,BoundedRangeModel,JCheckBox,DefaultBoundedRangeModel,JMenuBar,JPopupMenu,ProgressMonitor,Popup,CellRendererPane,RepaintManager,Scrollable,AbstractSpinnerModel,ListModel,DefaultSingleSelectionModel,GrayFilter,KeyStroke,SizeSequence,UnsupportedLookAndFeelException,JLayeredPane,LayoutFocusTraversalPolicy,JCheckBoxMenuItem,ScrollPaneLayout,DefaultDesktopManager,JSplitPane,SpinnerNumberModel,JPanel,JDesktopPane,DefaultFocusManager,JRadioButtonMenuItem,JWindow,JToolTip,JSlider,JList,Action,JViewport,JTextPane,JScrollBar,JEditorPane,DefaultListSelectionModel,JFileChooser,JButton,DefaultCellEditor,SwingConstants,JOptionPane,Icon,ActionMap", "javax.swing.plaf", null};
    
    public static class _PyInner extends PyFunctionTable implements PyRunnable {
        private static PyObject s$0;
        private static PyObject i$1;
        private static PyObject i$2;
        private static PyObject i$3;
        private static PyObject i$4;
        private static PyObject i$5;
        private static PyObject i$6;
        private static PyObject i$7;
        private static PyObject i$8;
        private static PyObject i$9;
        private static PyObject i$10;
        private static PyObject i$11;
        private static PyObject i$12;
        private static PyObject i$13;
        private static PyObject i$14;
        private static PyObject i$15;
        private static PyObject i$16;
        private static PyObject i$17;
        private static PyObject i$18;
        private static PyObject i$19;
        private static PyObject i$20;
        private static PyObject i$21;
        private static PyObject i$22;
        private static PyObject i$23;
        private static PyObject i$24;
        private static PyObject i$25;
        private static PyObject i$26;
        private static PyObject i$27;
        private static PyObject i$28;
        private static PyObject i$29;
        private static PyObject s$30;
        private static PyFunctionTable funcTable;
        private static PyCode c$0_S_IMODE;
        private static PyCode c$1_S_IFMT;
        private static PyCode c$2_S_ISDIR;
        private static PyCode c$3_S_ISCHR;
        private static PyCode c$4_S_ISBLK;
        private static PyCode c$5_S_ISREG;
        private static PyCode c$6_S_ISFIFO;
        private static PyCode c$7_S_ISLNK;
        private static PyCode c$8_S_ISSOCK;
        private static PyCode c$9_main;
        private static void initConstants() {
            s$0 = Py.newString("Constants/functions for interpreting results of os.stat() and os.lstat().\012\012Suggested usage: from stat import *\012");
            i$1 = Py.newInteger(0);
            i$2 = Py.newInteger(1);
            i$3 = Py.newInteger(2);
            i$4 = Py.newInteger(3);
            i$5 = Py.newInteger(4);
            i$6 = Py.newInteger(5);
            i$7 = Py.newInteger(6);
            i$8 = Py.newInteger(7);
            i$9 = Py.newInteger(8);
            i$10 = Py.newInteger(9);
            i$11 = Py.newInteger(4095);
            i$12 = Py.newInteger(61440);
            i$13 = Py.newInteger(16384);
            i$14 = Py.newInteger(8192);
            i$15 = Py.newInteger(24576);
            i$16 = Py.newInteger(32768);
            i$17 = Py.newInteger(4096);
            i$18 = Py.newInteger(40960);
            i$19 = Py.newInteger(49152);
            i$20 = Py.newInteger(2048);
            i$21 = Py.newInteger(1024);
            i$22 = Py.newInteger(512);
            i$23 = Py.newInteger(256);
            i$24 = Py.newInteger(128);
            i$25 = Py.newInteger(64);
            i$26 = Py.newInteger(448);
            i$27 = Py.newInteger(56);
            i$28 = Py.newInteger(32);
            i$29 = Py.newInteger(16);
            s$30 = Py.newString("/fm/appz/jython_2.1a3__GG/runtime/Lib/stat.py");
            funcTable = new _PyInner();
            c$0_S_IMODE = Py.newCode(1, new String[] {"mode"}, "/fm/appz/jython_2.1a3__GG/runtime/Lib/stat.py", "S_IMODE", false, false, funcTable, 0, null, null, 0, 1);
            c$1_S_IFMT = Py.newCode(1, new String[] {"mode"}, "/fm/appz/jython_2.1a3__GG/runtime/Lib/stat.py", "S_IFMT", false, false, funcTable, 1, null, null, 0, 1);
            c$2_S_ISDIR = Py.newCode(1, new String[] {"mode"}, "/fm/appz/jython_2.1a3__GG/runtime/Lib/stat.py", "S_ISDIR", false, false, funcTable, 2, null, null, 0, 1);
            c$3_S_ISCHR = Py.newCode(1, new String[] {"mode"}, "/fm/appz/jython_2.1a3__GG/runtime/Lib/stat.py", "S_ISCHR", false, false, funcTable, 3, null, null, 0, 1);
            c$4_S_ISBLK = Py.newCode(1, new String[] {"mode"}, "/fm/appz/jython_2.1a3__GG/runtime/Lib/stat.py", "S_ISBLK", false, false, funcTable, 4, null, null, 0, 1);
            c$5_S_ISREG = Py.newCode(1, new String[] {"mode"}, "/fm/appz/jython_2.1a3__GG/runtime/Lib/stat.py", "S_ISREG", false, false, funcTable, 5, null, null, 0, 1);
            c$6_S_ISFIFO = Py.newCode(1, new String[] {"mode"}, "/fm/appz/jython_2.1a3__GG/runtime/Lib/stat.py", "S_ISFIFO", false, false, funcTable, 6, null, null, 0, 1);
            c$7_S_ISLNK = Py.newCode(1, new String[] {"mode"}, "/fm/appz/jython_2.1a3__GG/runtime/Lib/stat.py", "S_ISLNK", false, false, funcTable, 7, null, null, 0, 1);
            c$8_S_ISSOCK = Py.newCode(1, new String[] {"mode"}, "/fm/appz/jython_2.1a3__GG/runtime/Lib/stat.py", "S_ISSOCK", false, false, funcTable, 8, null, null, 0, 1);
            c$9_main = Py.newCode(0, new String[] {}, "/fm/appz/jython_2.1a3__GG/runtime/Lib/stat.py", "main", false, false, funcTable, 9, null, null, 0, 0);
        }
        
        
        public PyCode getMain() {
            if (c$9_main == null) _PyInner.initConstants();
            return c$9_main;
        }
        
        public PyObject call_function(int index, PyFrame frame) {
            switch (index){
                case 0:
                return _PyInner.S_IMODE$1(frame);
                case 1:
                return _PyInner.S_IFMT$2(frame);
                case 2:
                return _PyInner.S_ISDIR$3(frame);
                case 3:
                return _PyInner.S_ISCHR$4(frame);
                case 4:
                return _PyInner.S_ISBLK$5(frame);
                case 5:
                return _PyInner.S_ISREG$6(frame);
                case 6:
                return _PyInner.S_ISFIFO$7(frame);
                case 7:
                return _PyInner.S_ISLNK$8(frame);
                case 8:
                return _PyInner.S_ISSOCK$9(frame);
                case 9:
                return _PyInner.main$10(frame);
                default:
                return null;
            }
        }
        
        private static PyObject S_IMODE$1(PyFrame frame) {
            return frame.getlocal(0)._and(i$11);
        }
        
        private static PyObject S_IFMT$2(PyFrame frame) {
            return frame.getlocal(0)._and(i$12);
        }
        
        private static PyObject S_ISDIR$3(PyFrame frame) {
            return frame.getglobal("S_IFMT").__call__(frame.getlocal(0))._eq(frame.getglobal("S_IFDIR"));
        }
        
        private static PyObject S_ISCHR$4(PyFrame frame) {
            return frame.getglobal("S_IFMT").__call__(frame.getlocal(0))._eq(frame.getglobal("S_IFCHR"));
        }
        
        private static PyObject S_ISBLK$5(PyFrame frame) {
            return frame.getglobal("S_IFMT").__call__(frame.getlocal(0))._eq(frame.getglobal("S_IFBLK"));
        }
        
        private static PyObject S_ISREG$6(PyFrame frame) {
            return frame.getglobal("S_IFMT").__call__(frame.getlocal(0))._eq(frame.getglobal("S_IFREG"));
        }
        
        private static PyObject S_ISFIFO$7(PyFrame frame) {
            return frame.getglobal("S_IFMT").__call__(frame.getlocal(0))._eq(frame.getglobal("S_IFIFO"));
        }
        
        private static PyObject S_ISLNK$8(PyFrame frame) {
            return frame.getglobal("S_IFMT").__call__(frame.getlocal(0))._eq(frame.getglobal("S_IFLNK"));
        }
        
        private static PyObject S_ISSOCK$9(PyFrame frame) {
            return frame.getglobal("S_IFMT").__call__(frame.getlocal(0))._eq(frame.getglobal("S_IFSOCK"));
        }
        
        private static PyObject main$10(PyFrame frame) {
            frame.setglobal("__file__", s$30);
            
            /* Constants/functions for interpreting results of os.stat() and os.lstat().
            
            Suggested usage: from stat import *
             */
            frame.setlocal("ST_MODE", i$1);
            frame.setlocal("ST_INO", i$2);
            frame.setlocal("ST_DEV", i$3);
            frame.setlocal("ST_NLINK", i$4);
            frame.setlocal("ST_UID", i$5);
            frame.setlocal("ST_GID", i$6);
            frame.setlocal("ST_SIZE", i$7);
            frame.setlocal("ST_ATIME", i$8);
            frame.setlocal("ST_MTIME", i$9);
            frame.setlocal("ST_CTIME", i$10);
            frame.setlocal("S_IMODE", new PyFunction(frame.f_globals, new PyObject[] {}, c$0_S_IMODE));
            frame.setlocal("S_IFMT", new PyFunction(frame.f_globals, new PyObject[] {}, c$1_S_IFMT));
            frame.setlocal("S_IFDIR", i$13);
            frame.setlocal("S_IFCHR", i$14);
            frame.setlocal("S_IFBLK", i$15);
            frame.setlocal("S_IFREG", i$16);
            frame.setlocal("S_IFIFO", i$17);
            frame.setlocal("S_IFLNK", i$18);
            frame.setlocal("S_IFSOCK", i$19);
            frame.setlocal("S_ISDIR", new PyFunction(frame.f_globals, new PyObject[] {}, c$2_S_ISDIR));
            frame.setlocal("S_ISCHR", new PyFunction(frame.f_globals, new PyObject[] {}, c$3_S_ISCHR));
            frame.setlocal("S_ISBLK", new PyFunction(frame.f_globals, new PyObject[] {}, c$4_S_ISBLK));
            frame.setlocal("S_ISREG", new PyFunction(frame.f_globals, new PyObject[] {}, c$5_S_ISREG));
            frame.setlocal("S_ISFIFO", new PyFunction(frame.f_globals, new PyObject[] {}, c$6_S_ISFIFO));
            frame.setlocal("S_ISLNK", new PyFunction(frame.f_globals, new PyObject[] {}, c$7_S_ISLNK));
            frame.setlocal("S_ISSOCK", new PyFunction(frame.f_globals, new PyObject[] {}, c$8_S_ISSOCK));
            frame.setlocal("S_ISUID", i$20);
            frame.setlocal("S_ISGID", i$21);
            frame.setlocal("S_ENFMT", frame.getname("S_ISGID"));
            frame.setlocal("S_ISVTX", i$22);
            frame.setlocal("S_IREAD", i$23);
            frame.setlocal("S_IWRITE", i$24);
            frame.setlocal("S_IEXEC", i$25);
            frame.setlocal("S_IRWXU", i$26);
            frame.setlocal("S_IRUSR", i$23);
            frame.setlocal("S_IWUSR", i$24);
            frame.setlocal("S_IXUSR", i$25);
            frame.setlocal("S_IRWXG", i$27);
            frame.setlocal("S_IRGRP", i$28);
            frame.setlocal("S_IWGRP", i$29);
            frame.setlocal("S_IXGRP", i$9);
            frame.setlocal("S_IRWXO", i$8);
            frame.setlocal("S_IROTH", i$5);
            frame.setlocal("S_IWOTH", i$3);
            frame.setlocal("S_IXOTH", i$2);
            return Py.None;
        }
        
    }
    public static void moduleDictInit(PyObject dict) {
        dict.__setitem__("__name__", new PyString("stat"));
        Py.runCode(new _PyInner().getMain(), dict, dict);
    }
    
    public static void main(String[] args) {
        String[] newargs = new String[args.length+1];
        newargs[0] = "stat";
        System.arraycopy(args, 0, newargs, 1, args.length);
        Py.runMain("mail98.stat$_PyInner", newargs, jpy$packages, jpy$properties, "mail98", new String[] {"DBi.Server", "etoffiutils", "DBi.Handle", "javapath", "MMS", "traceback", "stat", "string", "linecache", "DBi.__init__", "javaos", "rfc822"});
    }
    
}
