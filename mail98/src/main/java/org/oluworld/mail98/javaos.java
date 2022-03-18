package mail98;

import org.python.core.*;

public class javaos extends java.lang.Object {
    static String[] jpy$properties = new String[] {"python.modules.builtin", "exceptions:org.python.core.exceptions", "python.options.showJavaExceptions", "true"};
    static String[] jpy$packages = new String[] {"java.io", null, "javax.swing.text", null, "javax.swing.tree", null, "java.awt.print", null, "java.awt.peer", null, "java.awt.font", null, "javax.swing.colorchooser", null, "java.awt.datatransfer", null, "java.awt.geom", null, "java.lang", null, "javax.swing.undo", null, "java.awt", "Choice,PrintGraphics,ImageCapabilities,DisplayMode,Cursor,GradientPaint,Robot,GridLayout,CheckboxMenuItem,Window,GraphicsConfiguration,BasicStroke,AWTEvent,TextField,AWTException,Menu,Insets,Shape,PointerInfo,GraphicsEnvironment,MenuShortcut,LayoutManager2,AlphaComposite,GridBagLayout,Frame,Font,KeyEventPostProcessor,Scrollbar,Panel,MouseInfo,FileDialog,ScrollPaneAdjustable,Event,Checkbox,ItemSelectable,DefaultKeyboardFocusManager,GraphicsConfigTemplate,FontMetrics,ComponentOrientation,BufferCapabilities,AWTKeyStroke,DefaultFocusTraversalPolicy,PaintContext,List,CompositeContext,MenuContainer,TextComponent,KeyEventDispatcher,PrintJob,SystemColor,ActiveEvent,TextArea,GraphicsDevice,Adjustable,FontFormatException,Rectangle,FocusTraversalPolicy,RenderingHints,AWTPermission,Component,TexturePaint,AWTEventMulticaster,Stroke,MediaTracker,BorderLayout,Point,HeadlessException,Paint,ScrollPane,Graphics,MenuBar,Color,FlowLayout,Label,Button,Transparency,Graphics2D,GridBagConstraints,IllegalComponentStateException,CardLayout,KeyboardFocusManager,CheckboxGroup,Toolkit,Dialog,Polygon,PageAttributes,Container,Composite,JobAttributes,MenuComponent,Canvas,ContainerOrderFocusTraversalPolicy,EventQueue,PopupMenu,LayoutManager,MenuItem,Image,Dimension,AWTError", "javax.swing.event", "PopupMenuListener,HyperlinkEvent,MenuKeyEvent,UndoableEditEvent,MenuDragMouseListener,ChangeEvent,TreeExpansionEvent,InternalFrameListener,TreeWillExpandListener,AncestorEvent,ListSelectionEvent,HyperlinkListener,DocumentListener,TableColumnModelEvent,AncestorListener,TreeModelEvent,TableModelEvent,TreeExpansionListener,ListSelectionListener,InternalFrameEvent,MouseInputListener,TreeSelectionEvent,SwingPropertyChangeSupport,ChangeListener,ListDataEvent,TableModelListener,CaretEvent,PopupMenuEvent,EventListenerList,MenuEvent,MouseInputAdapter,UndoableEditListener,ListDataListener,MenuListener,DocumentEvent,MenuDragMouseEvent,InternalFrameAdapter,CaretListener,TreeModelListener,MenuKeyListener,TableColumnModelListener,CellEditorListener,TreeSelectionListener", "javax.swing.border", null, "javax.swing.filechooser", null, "java.awt.im", null, "java.awt.image", null, "javax.swing.table", "TableColumnModel,TableColumn,TableCellEditor,DefaultTableModel,AbstractTableModel,DefaultTableColumnModel,JTableHeader,TableModel,TableCellRenderer,DefaultTableCellRenderer", "java.awt.dnd", null, "java.awt.color", null, "java.awt.event", "ComponentEvent,PaintEvent,InvocationEvent,FocusListener,HierarchyBoundsAdapter,MouseListener,MouseWheelEvent,FocusEvent,WindowEvent,AdjustmentListener,MouseEvent,ComponentListener,ItemEvent,KeyListener,HierarchyEvent,KeyEvent,InputEvent,WindowListener,HierarchyBoundsListener,MouseMotionListener,ActionListener,WindowAdapter,WindowStateListener,InputMethodEvent,MouseWheelListener,TextListener,KeyAdapter,AdjustmentEvent,ItemListener,ContainerAdapter,ActionEvent,InputMethodListener,MouseAdapter,FocusAdapter,TextEvent,HierarchyListener,ContainerListener,AWTEventListenerProxy,WindowFocusListener,ComponentAdapter,MouseMotionAdapter,AWTEventListener,ContainerEvent", "javax.swing", "WindowConstants,ComboBoxModel,DefaultListModel,PopupFactory,Timer,JRootPane,AbstractAction,DebugGraphics,DefaultButtonModel,ListSelectionModel,JMenuItem,ScrollPaneConstants,ComponentInputMap,DefaultComboBoxModel,UIManager,JTextField,AbstractButton,MutableComboBoxModel,AbstractCellEditor,SpinnerModel,JLabel,OverlayLayout,DesktopManager,JColorChooser,ToolTipManager,DefaultListCellRenderer,BoxLayout,SpringLayout,SwingUtilities,JTabbedPane,ProgressMonitorInputStream,JInternalFrame,ImageIcon,JRadioButton,TransferHandler,Box,SizeRequirements,InternalFrameFocusTraversalPolicy,LookAndFeel,ViewportLayout,JProgressBar,ButtonGroup,JToolBar,JDialog,BorderFactory,JTextArea,Renderer,JSeparator,JApplet,MenuElement,JToggleButton,JPasswordField,SpinnerDateModel,ListCellRenderer,JTree,InputVerifier,AbstractListModel,JMenu,JComboBox,MenuSelectionManager,JScrollPane,UIDefaults,FocusManager,SingleSelectionModel,InputMap,CellEditor,JFrame,JFormattedTextField,JTable,Spring,ButtonModel,JComponent,ComboBoxEditor,RootPaneContainer,SortingFocusTraversalPolicy,SpinnerListModel,JSpinner,BoundedRangeModel,JCheckBox,DefaultBoundedRangeModel,JMenuBar,JPopupMenu,ProgressMonitor,Popup,CellRendererPane,RepaintManager,Scrollable,AbstractSpinnerModel,ListModel,DefaultSingleSelectionModel,GrayFilter,KeyStroke,SizeSequence,UnsupportedLookAndFeelException,JLayeredPane,LayoutFocusTraversalPolicy,JCheckBoxMenuItem,ScrollPaneLayout,DefaultDesktopManager,JSplitPane,SpinnerNumberModel,JPanel,JDesktopPane,DefaultFocusManager,JRadioButtonMenuItem,JWindow,JToolTip,JSlider,JList,Action,JViewport,JTextPane,JScrollBar,JEditorPane,DefaultListSelectionModel,JFileChooser,JButton,DefaultCellEditor,SwingConstants,JOptionPane,Icon,ActionMap", "javax.swing.plaf", null};
    
    public static class _PyInner extends PyFunctionTable implements PyRunnable {
        private static PyObject s$0;
        private static PyObject s$1;
        private static PyObject s$2;
        private static PyObject s$3;
        private static PyObject s$4;
        private static PyObject s$5;
        private static PyObject s$6;
        private static PyObject s$7;
        private static PyObject s$8;
        private static PyObject s$9;
        private static PyObject s$10;
        private static PyObject s$11;
        private static PyObject s$12;
        private static PyObject i$13;
        private static PyObject s$14;
        private static PyObject s$15;
        private static PyObject s$16;
        private static PyObject s$17;
        private static PyObject s$18;
        private static PyObject s$19;
        private static PyObject s$20;
        private static PyObject s$21;
        private static PyObject s$22;
        private static PyObject s$23;
        private static PyObject f$24;
        private static PyObject s$25;
        private static PyFunctionTable funcTable;
        private static PyCode c$0__exit;
        private static PyCode c$1_getcwd;
        private static PyCode c$2_listdir;
        private static PyCode c$3_mkdir;
        private static PyCode c$4_makedirs;
        private static PyCode c$5_remove;
        private static PyCode c$6_rename;
        private static PyCode c$7_rmdir;
        private static PyCode c$8_stat;
        private static PyCode c$9_main;
        private static void initConstants() {
            s$0 = Py.newString("OS routines for Mac, DOS, NT, or Posix depending on what system we're on.\012\012This exports:\012  - all functions from posix, nt, dos, os2, mac, or ce, e.g. unlink, stat, etc.\012  - os.path is one of the modules posixpath, ntpath, macpath, or dospath\012  - os.name is 'posix', 'nt', 'dos', 'os2', 'mac', 'ce' or 'riscos'\012  - os.curdir is a string representing the current directory ('.' or ':')\012  - os.pardir is a string representing the parent directory ('..' or '::')\012  - os.sep is the (or a most common) pathname separator ('/' or ':' or '\\\\')\012  - os.altsep is the alternate pathname separator (None or '/')\012  - os.pathsep is the component separator used in $PATH etc\012  - os.linesep is the line separator in text files ('\\r' or '\\n' or '\\r\\n')\012  - os.defpath is the default search path for executables\012\012Programs that import and use 'os' stand a better chance of being\012portable between different platforms.  Of course, they must then\012only use functions that are defined by all platforms (e.g., unlink\012and opendir), and leave all pathname manipulation to os.path\012(e.g., split and join).\012");
            s$1 = Py.newString("altsep");
            s$2 = Py.newString("curdir");
            s$3 = Py.newString("pardir");
            s$4 = Py.newString("sep");
            s$5 = Py.newString("pathsep");
            s$6 = Py.newString("linesep");
            s$7 = Py.newString("defpath");
            s$8 = Py.newString("name");
            s$9 = Py.newString("java");
            s$10 = Py.newString(".");
            s$11 = Py.newString("..");
            s$12 = Py.newString("line.separator");
            i$13 = Py.newInteger(0);
            s$14 = Py.newString("foo");
            s$15 = Py.newString("No such directory");
            s$16 = Py.newString("couldn't make directory");
            s$17 = Py.newString("ignored");
            s$18 = Py.newString("couldn't make directories");
            s$19 = Py.newString("couldn't delete file");
            s$20 = Py.newString("couldn't rename file");
            s$21 = Py.newString("couldn't delete directory");
            s$22 = Py.newString("The Java stat implementation only returns a small subset of\012    the standard fields");
            s$23 = Py.newString("No such file or directory");
            f$24 = Py.newFloat(1000.0);
            s$25 = Py.newString("/fm/appz/jython_2.1a3__GG/runtime/Lib/javaos.py");
            funcTable = new _PyInner();
            c$0__exit = Py.newCode(1, new String[] {"n"}, "/fm/appz/jython_2.1a3__GG/runtime/Lib/javaos.py", "_exit", false, false, funcTable, 0, null, null, 0, 1);
            c$1_getcwd = Py.newCode(0, new String[] {"foo"}, "/fm/appz/jython_2.1a3__GG/runtime/Lib/javaos.py", "getcwd", false, false, funcTable, 1, null, null, 0, 1);
            c$2_listdir = Py.newCode(1, new String[] {"path", "l"}, "/fm/appz/jython_2.1a3__GG/runtime/Lib/javaos.py", "listdir", false, false, funcTable, 2, null, null, 0, 1);
            c$3_mkdir = Py.newCode(2, new String[] {"path", "mode"}, "/fm/appz/jython_2.1a3__GG/runtime/Lib/javaos.py", "mkdir", false, false, funcTable, 3, null, null, 0, 1);
            c$4_makedirs = Py.newCode(2, new String[] {"path", "mode"}, "/fm/appz/jython_2.1a3__GG/runtime/Lib/javaos.py", "makedirs", false, false, funcTable, 4, null, null, 0, 1);
            c$5_remove = Py.newCode(1, new String[] {"path"}, "/fm/appz/jython_2.1a3__GG/runtime/Lib/javaos.py", "remove", false, false, funcTable, 5, null, null, 0, 1);
            c$6_rename = Py.newCode(2, new String[] {"path", "newpath"}, "/fm/appz/jython_2.1a3__GG/runtime/Lib/javaos.py", "rename", false, false, funcTable, 6, null, null, 0, 1);
            c$7_rmdir = Py.newCode(1, new String[] {"path"}, "/fm/appz/jython_2.1a3__GG/runtime/Lib/javaos.py", "rmdir", false, false, funcTable, 7, null, null, 0, 1);
            c$8_stat = Py.newCode(1, new String[] {"path", "mtime", "size", "f"}, "/fm/appz/jython_2.1a3__GG/runtime/Lib/javaos.py", "stat", false, false, funcTable, 8, null, null, 0, 1);
            c$9_main = Py.newCode(0, new String[] {}, "/fm/appz/jython_2.1a3__GG/runtime/Lib/javaos.py", "main", false, false, funcTable, 9, null, null, 0, 0);
        }
        
        
        public PyCode getMain() {
            if (c$9_main == null) _PyInner.initConstants();
            return c$9_main;
        }
        
        public PyObject call_function(int index, PyFrame frame) {
            switch (index){
                case 0:
                return _PyInner._exit$1(frame);
                case 1:
                return _PyInner.getcwd$2(frame);
                case 2:
                return _PyInner.listdir$3(frame);
                case 3:
                return _PyInner.mkdir$4(frame);
                case 4:
                return _PyInner.makedirs$5(frame);
                case 5:
                return _PyInner.remove$6(frame);
                case 6:
                return _PyInner.rename$7(frame);
                case 7:
                return _PyInner.rmdir$8(frame);
                case 8:
                return _PyInner.stat$9(frame);
                case 9:
                return _PyInner.main$10(frame);
                default:
                return null;
            }
        }
        
        private static PyObject _exit$1(PyFrame frame) {
            frame.getglobal("java").__getattr__("lang").__getattr__("System").__getattr__("exit").__call__(frame.getlocal(0));
            return Py.None;
        }
        
        private static PyObject getcwd$2(PyFrame frame) {
            frame.setlocal(0, frame.getglobal("File").__call__(frame.getglobal("File").__call__(s$14).invoke("getAbsolutePath")));
            return frame.getlocal(0).invoke("getParent");
        }
        
        private static PyObject listdir$3(PyFrame frame) {
            frame.setlocal(1, frame.getglobal("File").__call__(frame.getlocal(0)).invoke("list"));
            if (frame.getlocal(1)._is(frame.getglobal("None")).__nonzero__()) {
                throw Py.makeException(frame.getglobal("OSError").__call__(i$13, s$15, frame.getlocal(0)));
            }
            return frame.getglobal("list").__call__(frame.getlocal(1));
        }
        
        private static PyObject mkdir$4(PyFrame frame) {
            if (frame.getglobal("File").__call__(frame.getlocal(0)).invoke("mkdir").__not__().__nonzero__()) {
                throw Py.makeException(frame.getglobal("OSError").__call__(i$13, s$16, frame.getlocal(0)));
            }
            return Py.None;
        }
        
        private static PyObject makedirs$5(PyFrame frame) {
            if (frame.getglobal("File").__call__(frame.getlocal(0)).invoke("mkdirs").__not__().__nonzero__()) {
                throw Py.makeException(frame.getglobal("OSError").__call__(i$13, s$18, frame.getlocal(0)));
            }
            return Py.None;
        }
        
        private static PyObject remove$6(PyFrame frame) {
            if (frame.getglobal("File").__call__(frame.getlocal(0)).invoke("delete").__not__().__nonzero__()) {
                throw Py.makeException(frame.getglobal("OSError").__call__(i$13, s$19, frame.getlocal(0)));
            }
            return Py.None;
        }
        
        private static PyObject rename$7(PyFrame frame) {
            if (frame.getglobal("File").__call__(frame.getlocal(0)).invoke("renameTo", frame.getglobal("File").__call__(frame.getlocal(1))).__not__().__nonzero__()) {
                throw Py.makeException(frame.getglobal("OSError").__call__(i$13, s$20, frame.getlocal(0)));
            }
            return Py.None;
        }
        
        private static PyObject rmdir$8(PyFrame frame) {
            if (frame.getglobal("File").__call__(frame.getlocal(0)).invoke("delete").__not__().__nonzero__()) {
                throw Py.makeException(frame.getglobal("OSError").__call__(i$13, s$21, frame.getlocal(0)));
            }
            return Py.None;
        }
        
        private static PyObject stat$9(PyFrame frame) {
            // Temporary Variables
            PyObject t$0$PyObject;
            
            // Code
            /* The Java stat implementation only returns a small subset of
                the standard fields */
            frame.setlocal(3, frame.getglobal("File").__call__(frame.getlocal(0)));
            frame.setlocal(2, frame.getlocal(3).invoke("length"));
            if (((t$0$PyObject = frame.getlocal(2)._eq(i$13)).__nonzero__() ? frame.getlocal(3).invoke("exists").__not__() : t$0$PyObject).__nonzero__()) {
                throw Py.makeException(frame.getglobal("OSError").__call__(i$13, s$23, frame.getlocal(0)));
            }
            frame.setlocal(1, frame.getlocal(3).invoke("lastModified")._div(f$24));
            return new PyTuple(new PyObject[] {i$13, i$13, i$13, i$13, i$13, i$13, frame.getlocal(2), frame.getlocal(1), frame.getlocal(1), i$13});
        }
        
        private static PyObject main$10(PyFrame frame) {
            frame.setglobal("__file__", s$25);
            
            PyObject[] imp_accu;
            // Code
            /* OS routines for Mac, DOS, NT, or Posix depending on what system we're on.
            
            This exports:
              - all functions from posix, nt, dos, os2, mac, or ce, e.g. unlink, stat, etc.
              - os.path is one of the modules posixpath, ntpath, macpath, or dospath
              - os.name is 'posix', 'nt', 'dos', 'os2', 'mac', 'ce' or 'riscos'
              - os.curdir is a string representing the current directory ('.' or ':')
              - os.pardir is a string representing the parent directory ('..' or '::')
              - os.sep is the (or a most common) pathname separator ('/' or ':' or '\\')
              - os.altsep is the alternate pathname separator (None or '/')
              - os.pathsep is the component separator used in $PATH etc
              - os.linesep is the line separator in text files ('\r' or '\n' or '\r\n')
              - os.defpath is the default search path for executables
            
            Programs that import and use 'os' stand a better chance of being
            portable between different platforms.  Of course, they must then
            only use functions that are defined by all platforms (e.g., unlink
            and opendir), and leave all pathname manipulation to os.path
            (e.g., split and join).
             */
            frame.setlocal("__all__", new PyList(new PyObject[] {s$1, s$2, s$3, s$4, s$5, s$6, s$7, s$8}));
            frame.setlocal("java", org.python.core.imp.importOne("java", frame));
            imp_accu = org.python.core.imp.importFrom("java.io", new String[] {"File"}, frame);
            frame.setlocal("File", imp_accu[0]);
            frame.setlocal("javapath", org.python.core.imp.importOne("javapath", frame));
            frame.setlocal("path", frame.getname("javapath"));
            frame.setlocal("error", frame.getname("OSError"));
            frame.setlocal("name", s$9);
            frame.setlocal("curdir", s$10);
            frame.setlocal("pardir", s$11);
            frame.setlocal("sep", frame.getname("java").__getattr__("io").__getattr__("File").__getattr__("separator"));
            frame.setlocal("altsep", frame.getname("None"));
            frame.setlocal("pathsep", frame.getname("java").__getattr__("io").__getattr__("File").__getattr__("pathSeparator"));
            frame.setlocal("defpath", s$10);
            frame.setlocal("linesep", frame.getname("java").__getattr__("lang").__getattr__("System").__getattr__("getProperty").__call__(s$12));
            frame.setlocal("environ", new PyDictionary(new PyObject[] {}));
            frame.setlocal("_exit", new PyFunction(frame.f_globals, new PyObject[] {i$13}, c$0__exit));
            frame.setlocal("getcwd", new PyFunction(frame.f_globals, new PyObject[] {}, c$1_getcwd));
            frame.setlocal("listdir", new PyFunction(frame.f_globals, new PyObject[] {}, c$2_listdir));
            frame.setlocal("mkdir", new PyFunction(frame.f_globals, new PyObject[] {s$17}, c$3_mkdir));
            frame.setlocal("makedirs", new PyFunction(frame.f_globals, new PyObject[] {s$17}, c$4_makedirs));
            frame.setlocal("remove", new PyFunction(frame.f_globals, new PyObject[] {}, c$5_remove));
            frame.setlocal("rename", new PyFunction(frame.f_globals, new PyObject[] {}, c$6_rename));
            frame.setlocal("rmdir", new PyFunction(frame.f_globals, new PyObject[] {}, c$7_rmdir));
            frame.setlocal("unlink", frame.getname("remove"));
            frame.setlocal("stat", new PyFunction(frame.f_globals, new PyObject[] {}, c$8_stat));
            return Py.None;
        }
        
    }
    public static void moduleDictInit(PyObject dict) {
        dict.__setitem__("__name__", new PyString("javaos"));
        Py.runCode(new _PyInner().getMain(), dict, dict);
    }
    
    public static void main(String[] args) {
        String[] newargs = new String[args.length+1];
        newargs[0] = "javaos";
        System.arraycopy(args, 0, newargs, 1, args.length);
        Py.runMain("mail98.javaos$_PyInner", newargs, jpy$packages, jpy$properties, "mail98", new String[] {"DBi.Server", "etoffiutils", "DBi.Handle", "javapath", "MMS", "traceback", "stat", "string", "linecache", "DBi.__init__", "javaos", "rfc822"});
    }
    
}
