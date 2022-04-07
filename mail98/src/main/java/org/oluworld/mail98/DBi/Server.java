package org.oluworld.mail98.DBi;

import org.python.core.Py;
import org.python.core.PyCode;
import org.python.core.PyDictionary;
import org.python.core.PyException;
import org.python.core.PyFrame;
import org.python.core.PyFunction;
import org.python.core.PyFunctionTable;
import org.python.core.PyList;
import org.python.core.PyObject;
import org.python.core.PyRunnable;
import org.python.core.PyString;
import org.python.core.PyTuple;
import org.python.core.imp;

public class Server {

    static String[] jpy$properties = new String[]{"python.modules.builtin", "exceptions:org.python.core.exceptions", "python.options.showJavaExceptions", "true"};
    static String[] jpy$packages = new String[]{"java.io", null, "javax.swing.text", null, "javax.swing.tree", null, "java.awt.print", null, "java.awt.peer", null, "java.awt.font", null, "javax.swing.colorchooser", null, "java.awt.datatransfer", null, "java.awt.geom", null, "java.lang", null, "javax.swing.undo", null, "java.awt", "Choice,PrintGraphics,ImageCapabilities,DisplayMode,Cursor,GradientPaint,Robot,GridLayout,CheckboxMenuItem,Window,GraphicsConfiguration,BasicStroke,AWTEvent,TextField,AWTException,Menu,Insets,Shape,PointerInfo,GraphicsEnvironment,MenuShortcut,LayoutManager2,AlphaComposite,GridBagLayout,Frame,Font,KeyEventPostProcessor,Scrollbar,Panel,MouseInfo,FileDialog,ScrollPaneAdjustable,Event,Checkbox,ItemSelectable,DefaultKeyboardFocusManager,GraphicsConfigTemplate,FontMetrics,ComponentOrientation,BufferCapabilities,AWTKeyStroke,DefaultFocusTraversalPolicy,PaintContext,List,CompositeContext,MenuContainer,TextComponent,KeyEventDispatcher,PrintJob,SystemColor,ActiveEvent,TextArea,GraphicsDevice,Adjustable,FontFormatException,Rectangle,FocusTraversalPolicy,RenderingHints,AWTPermission,Component,TexturePaint,AWTEventMulticaster,Stroke,MediaTracker,BorderLayout,Point,HeadlessException,Paint,ScrollPane,Graphics,MenuBar,Color,FlowLayout,Label,Button,Transparency,Graphics2D,GridBagConstraints,IllegalComponentStateException,CardLayout,KeyboardFocusManager,CheckboxGroup,Toolkit,Dialog,Polygon,PageAttributes,Container,Composite,JobAttributes,MenuComponent,Canvas,ContainerOrderFocusTraversalPolicy,EventQueue,PopupMenu,LayoutManager,MenuItem,Image,Dimension,AWTError", "javax.swing.event", "PopupMenuListener,HyperlinkEvent,MenuKeyEvent,UndoableEditEvent,MenuDragMouseListener,ChangeEvent,TreeExpansionEvent,InternalFrameListener,TreeWillExpandListener,AncestorEvent,ListSelectionEvent,HyperlinkListener,DocumentListener,TableColumnModelEvent,AncestorListener,TreeModelEvent,TableModelEvent,TreeExpansionListener,ListSelectionListener,InternalFrameEvent,MouseInputListener,TreeSelectionEvent,SwingPropertyChangeSupport,ChangeListener,ListDataEvent,TableModelListener,CaretEvent,PopupMenuEvent,EventListenerList,MenuEvent,MouseInputAdapter,UndoableEditListener,ListDataListener,MenuListener,DocumentEvent,MenuDragMouseEvent,InternalFrameAdapter,CaretListener,TreeModelListener,MenuKeyListener,TableColumnModelListener,CellEditorListener,TreeSelectionListener", "javax.swing.border", null, "javax.swing.filechooser", null, "java.awt.im", null, "java.awt.image", null, "javax.swing.table", "TableColumnModel,TableColumn,TableCellEditor,DefaultTableModel,AbstractTableModel,DefaultTableColumnModel,JTableHeader,TableModel,TableCellRenderer,DefaultTableCellRenderer", "java.awt.dnd", null, "java.awt.color", null, "java.awt.event", "ComponentEvent,PaintEvent,InvocationEvent,FocusListener,HierarchyBoundsAdapter,MouseListener,MouseWheelEvent,FocusEvent,WindowEvent,AdjustmentListener,MouseEvent,ComponentListener,ItemEvent,KeyListener,HierarchyEvent,KeyEvent,InputEvent,WindowListener,HierarchyBoundsListener,MouseMotionListener,ActionListener,WindowAdapter,WindowStateListener,InputMethodEvent,MouseWheelListener,TextListener,KeyAdapter,AdjustmentEvent,ItemListener,ContainerAdapter,ActionEvent,InputMethodListener,MouseAdapter,FocusAdapter,TextEvent,HierarchyListener,ContainerListener,AWTEventListenerProxy,WindowFocusListener,ComponentAdapter,MouseMotionAdapter,AWTEventListener,ContainerEvent", "javax.swing", "WindowConstants,ComboBoxModel,DefaultListModel,PopupFactory,Timer,JRootPane,AbstractAction,DebugGraphics,DefaultButtonModel,ListSelectionModel,JMenuItem,ScrollPaneConstants,ComponentInputMap,DefaultComboBoxModel,UIManager,JTextField,AbstractButton,MutableComboBoxModel,AbstractCellEditor,SpinnerModel,JLabel,OverlayLayout,DesktopManager,JColorChooser,ToolTipManager,DefaultListCellRenderer,BoxLayout,SpringLayout,SwingUtilities,JTabbedPane,ProgressMonitorInputStream,JInternalFrame,ImageIcon,JRadioButton,TransferHandler,Box,SizeRequirements,InternalFrameFocusTraversalPolicy,LookAndFeel,ViewportLayout,JProgressBar,ButtonGroup,JToolBar,JDialog,BorderFactory,JTextArea,Renderer,JSeparator,JApplet,MenuElement,JToggleButton,JPasswordField,SpinnerDateModel,ListCellRenderer,JTree,InputVerifier,AbstractListModel,JMenu,JComboBox,MenuSelectionManager,JScrollPane,UIDefaults,FocusManager,SingleSelectionModel,InputMap,CellEditor,JFrame,JFormattedTextField,JTable,Spring,ButtonModel,JComponent,ComboBoxEditor,RootPaneContainer,SortingFocusTraversalPolicy,SpinnerListModel,JSpinner,BoundedRangeModel,JCheckBox,DefaultBoundedRangeModel,JMenuBar,JPopupMenu,ProgressMonitor,Popup,CellRendererPane,RepaintManager,Scrollable,AbstractSpinnerModel,ListModel,DefaultSingleSelectionModel,GrayFilter,KeyStroke,SizeSequence,UnsupportedLookAndFeelException,JLayeredPane,LayoutFocusTraversalPolicy,JCheckBoxMenuItem,ScrollPaneLayout,DefaultDesktopManager,JSplitPane,SpinnerNumberModel,JPanel,JDesktopPane,DefaultFocusManager,JRadioButtonMenuItem,JWindow,JToolTip,JSlider,JList,Action,JViewport,JTextPane,JScrollBar,JEditorPane,DefaultListSelectionModel,JFileChooser,JButton,DefaultCellEditor,SwingConstants,JOptionPane,Icon,ActionMap", "javax.swing.plaf", null};

    public static void moduleDictInit(PyObject var0) {
        var0.__setitem__("__name__", new PyString("Server"));
        Py.runCode((new Server._PyInner()).getMain(), var0, var0);
    }

    public static void main(String[] var0) throws Exception {
        String[] var1 = new String[var0.length + 1];
        var1[0] = "Server";
        System.arraycopy(var0, 0, var1, 1, var0.length);
        Py.runMain(Server._PyInner.class, var1, jpy$packages, jpy$properties, "mail98.DBi", new String[]{"DBi.Server", "etoffiutils", "DBi.Handle", "javapath", "MMS", "traceback", "stat", "string", "linecache", "DBi.__init__", "javaos", "rfc822"});
    }

    public static class _PyInner extends PyFunctionTable implements PyRunnable {

        private static PyObject s$0;
        private static PyObject s$1;
        private static PyObject s$2;
        private static PyObject s$3;
        private static PyObject s$4;
        private static PyObject s$5;
        private static PyObject i$6;
        private static PyObject s$7;
        private static PyObject s$8;
        private static PyObject s$9;
        private static PyFunctionTable funcTable;
        private static PyCode c$0_errNotFound;
        private static PyCode c$1_enum;
        private static PyCode c$2_x_enum;
        private static PyCode c$3_get;
        private static PyCode c$4_getStr;
        private static PyCode c$5_getStrOrNil;
        private static PyCode c$6___lookup;
        private static PyCode c$7_replace_begin;
        private static PyCode c$8__fix;
        private static PyCode c$9_translatePath;
        private static PyCode c$10_handlerForPath;
        private static PyCode c$11_lock;
        private static PyCode c$12_unlock;
        private static PyCode c$13_addAddListener;
        private static PyCode c$14_removeAddListener;
        private static PyCode c$15_add;
        private static PyCode c$16_getRoot;
        private static PyCode c$17___init__;
        private static PyCode c$18___del__;
        private static PyCode c$19_AwxDBiServer;
        private static PyCode c$20_main;

        private static void initConstants() {
            s$0 = Py.newString("~/");
            s$1 = Py.newString("search =");
            s$2 = Py.newString("/");
            s$3 = Py.newString("No handler for path %s");
            s$4 = Py.newString("/local/DBi/");
            s$5 = Py.newString("");
            i$6 = Py.newInteger(1);
            s$7 = Py.newString("/local/DBi/FileTypes/%s/Handlers/DBiHandler");
            s$8 = Py.newString("%s()");
            s$9 = Py.newString("/local/data/Projects/98-mail/98/DBi/Server.py");
            funcTable = new Server._PyInner();
            c$0_errNotFound = Py.newCode(0, new String[0], "/local/data/Projects/98-mail/98/DBi/Server.py", "errNotFound", false, false, funcTable, 0, (String[]) null, (String[]) null, 0, 0);
            c$1_enum = Py.newCode(4, new String[]{"self", "topkey", "root", "kind", "each", "top", "Result"}, "/local/data/Projects/98-mail/98/DBi/Server.py", "enum", false, false, funcTable, 1, (String[]) null, (String[]) null, 0, 1);
            c$2_x_enum = Py.newCode(4, new String[]{"self", "topkey", "root", "kind", "el", "Result", "top", "each"}, "/local/data/Projects/98-mail/98/DBi/Server.py", "x_enum", false, false, funcTable, 2, (String[]) null, (String[]) null, 0, 1);
            c$3_get = Py.newCode(3, new String[]{"self", "path", "root", "search", "look"}, "/local/data/Projects/98-mail/98/DBi/Server.py", "get", false, false, funcTable, 3, (String[]) null, (String[]) null, 0, 1);
            c$4_getStr = Py.newCode(3, new String[]{"self", "path", "root", "rv"}, "/local/data/Projects/98-mail/98/DBi/Server.py", "getStr", false, false, funcTable, 4, (String[]) null, (String[]) null, 0, 1);
            c$5_getStrOrNil = Py.newCode(3, new String[]{"self", "path", "root"}, "/local/data/Projects/98-mail/98/DBi/Server.py", "getStrOrNil", false, false, funcTable, 5, (String[]) null, (String[]) null, 0, 1);
            c$6___lookup = Py.newCode(2, new String[]{"self", "path", "rv", "h", "iterdata", "b", "parsePath", "AWX_DBI_NEWACTION"}, "/local/data/Projects/98-mail/98/DBi/Server.py", "__lookup", false, false, funcTable, 6, (String[]) null, (String[]) null, 0, 1);
            c$7_replace_begin = Py.newCode(3, new String[]{"instr", "replacethis", "withthis", "rv"}, "/local/data/Projects/98-mail/98/DBi/Server.py", "replace_begin", false, false, funcTable, 7, (String[]) null, (String[]) null, 0, 1);
            c$8__fix = Py.newCode(2, new String[]{"root", "path", "replace_begin"}, "/local/data/Projects/98-mail/98/DBi/Server.py", "_fix", false, false, funcTable, 8, (String[]) null, (String[]) null, 0, 1);
            c$9_translatePath = Py.newCode(3, new String[]{"self", "path", "root", "_fix", "rv"}, "/local/data/Projects/98-mail/98/DBi/Server.py", "translatePath", false, false, funcTable, 9, (String[]) null, (String[]) null, 0, 1);
            c$10_handlerForPath = Py.newCode(2, new String[]{"self", "path", "fd", "rv", "handlerPath", "handlerName", "s"}, "/local/data/Projects/98-mail/98/DBi/Server.py", "handlerForPath", false, false, funcTable, 10, (String[]) null, (String[]) null, 0, 1);
            c$11_lock = Py.newCode(1, new String[]{"self"}, "/local/data/Projects/98-mail/98/DBi/Server.py", "lock", false, false, funcTable, 11, (String[]) null, (String[]) null, 0, 1);
            c$12_unlock = Py.newCode(1, new String[]{"self"}, "/local/data/Projects/98-mail/98/DBi/Server.py", "unlock", false, false, funcTable, 12, (String[]) null, (String[]) null, 0, 1);
            c$13_addAddListener = Py.newCode(2, new String[]{"self", "aListener"}, "/local/data/Projects/98-mail/98/DBi/Server.py", "addAddListener", false, false, funcTable, 13, (String[]) null, (String[]) null, 0, 1);
            c$14_removeAddListener = Py.newCode(2, new String[]{"self", "aListener"}, "/local/data/Projects/98-mail/98/DBi/Server.py", "removeAddListener", false, false, funcTable, 14, (String[]) null, (String[]) null, 0, 1);
            c$15_add = Py.newCode(2, new String[]{"self", "line", "evt", "each"}, "/local/data/Projects/98-mail/98/DBi/Server.py", "add", false, false, funcTable, 15, (String[]) null, (String[]) null, 0, 1);
            c$16_getRoot = Py.newCode(1, new String[]{"self"}, "/local/data/Projects/98-mail/98/DBi/Server.py", "getRoot", false, false, funcTable, 16, (String[]) null, (String[]) null, 0, 1);
            c$17___init__ = Py.newCode(1, new String[]{"self", "rc", "dhl"}, "/local/data/Projects/98-mail/98/DBi/Server.py", "__init__", false, false, funcTable, 17, (String[]) null, (String[]) null, 0, 1);
            c$18___del__ = Py.newCode(1, new String[]{"self", "each"}, "/local/data/Projects/98-mail/98/DBi/Server.py", "__del__", false, false, funcTable, 18, (String[]) null, (String[]) null, 0, 1);
            c$19_AwxDBiServer = Py.newCode(0, new String[0], "/local/data/Projects/98-mail/98/DBi/Server.py", "AwxDBiServer", false, false, funcTable, 19, (String[]) null, (String[]) null, 0, 0);
            c$20_main = Py.newCode(0, new String[0], "/local/data/Projects/98-mail/98/DBi/Server.py", "main", false, false, funcTable, 20, (String[]) null, (String[]) null, 0, 0);
        }

        public PyCode getMain() {
            if (c$20_main == null) {
                initConstants();
            }

            return c$20_main;
        }

        public PyObject call_function(int var1, PyFrame var2) {
            switch (var1) {
                case 0:
                    return errNotFound$1(var2);
                case 1:
                    return enum$2(var2);
                case 2:
                    return x_enum$3(var2);
                case 3:
                    return get$4(var2);
                case 4:
                    return getStr$5(var2);
                case 5:
                    return getStrOrNil$6(var2);
                case 6:
                    return __lookup$7(var2);
                case 7:
                    return replace_begin$8(var2);
                case 8:
                    return _fix$9(var2);
                case 9:
                    return translatePath$10(var2);
                case 10:
                    return handlerForPath$11(var2);
                case 11:
                    return lock$12(var2);
                case 12:
                    return unlock$13(var2);
                case 13:
                    return addAddListener$14(var2);
                case 14:
                    return removeAddListener$15(var2);
                case 15:
                    return add$16(var2);
                case 16:
                    return getRoot$17(var2);
                case 17:
                    return __init__$18(var2);
                case 18:
                    return __del__$19(var2);
                case 19:
                    return AwxDBiServer$20(var2);
                case 20:
                    return main$21(var2);
                default:
                    return null;
            }
        }

        private static PyObject errNotFound$1(PyFrame var0) {
            return var0.getf_locals();
        }

        private static PyObject enum$2(PyFrame var0) {
            var0.setlocal(6, new PyList(new PyObject[0]));
            var0.setlocal(5, var0.getlocal(0).invoke("translatePath", var0.getlocal(1), var0.getlocal(2)));
            int var1 = 0;
            PyObject var3 = var0.getlocal(0).__getattr__("handlers");

            PyObject var2;
            while ((var2 = var3.__finditem__(var1++)) != null) {
                var0.setlocal(4, var2);
                if (var0.getlocal(4).invoke("canOpen", var0.getlocal(5), var0.getglobal("FOR_ENUM")).__nonzero__()) {
                    var0.setlocal(6, var0.getlocal(4).invoke("enum", var0.getlocal(5)));
                }
            }

            return var0.getlocal(6);
        }

        private static PyObject x_enum$3(PyFrame var0) {
            var0.setlocal(4, var0.getglobal("DBiServerEnumListener").__call__());
            var0.getlocal(0).invoke("addAddListener", var0.getlocal(4));
            var0.setlocal(6, var0.getlocal(0).invoke("translatePath", var0.getlocal(1), var0.getlocal(2)));
            int var1 = 0;
            PyObject var3 = var0.getlocal(0).__getattr__("handlers");

            PyObject var2;
            while ((var2 = var3.__finditem__(var1++)) != null) {
                var0.setlocal(7, var2);
                if (var0.getlocal(7).invoke("canOpen", var0.getlocal(6), var0.getglobal("FOR_ENUM")).__nonzero__()) {
                    var0.getlocal(7).invoke("enum", var0.getlocal(6));
                    break;
                }
            }

            var0.setlocal(5, var0.getlocal(4).invoke("getResult"));
            var0.getlocal(0).invoke("removeAddListener", var0.getlocal(4));
            return var0.getlocal(5);
        }

        private static PyObject get$4(PyFrame var0) {
            var0.setlocal(3, var0.getlocal(0).invoke("translatePath", var0.getlocal(1), var0.getlocal(2)));
            if (var0.getlocal(0).__getattr__("entries").invoke("has_key", var0.getlocal(3)).__nonzero__()) {
                return var0.getlocal(0).__getattr__("entries").__getitem__(var0.getlocal(3));
            } else {
                var0.setlocal(4, var0.getlocal(0).invoke("__lookup", var0.getlocal(3)));
                if (var0.getlocal(4).__not__().__nonzero__()) {
                    Py.printComma(s$1);
                    Py.println(var0.getlocal(3));
                    throw Py.makeException(var0.getglobal("errNotFound").__call__());
                } else {
                    var0.getlocal(0).__getattr__("entries").__setitem__(var0.getlocal(3), var0.getlocal(4));
                    return var0.getlocal(4);
                }
            }
        }

        private static PyObject getStr$5(PyFrame var0) {
            var0.setlocal(3, var0.getlocal(0).invoke("get", var0.getlocal(1), var0.getlocal(2)).invoke("getStr"));
            return var0.getlocal(3);
        }

        private static PyObject getStrOrNil$6(PyFrame var0) {
            try {
                return var0.getlocal(0).invoke("getStr", var0.getlocal(1), var0.getlocal(2));
            } catch (Throwable var3) {
                PyException var1 = Py.setException(var3, var0);
                if (Py.matchException(var1, var0.getglobal("errNotFound"))) {
                    return var0.getglobal("None");
                } else {
                    throw var1;
                }
            }
        }

        private static PyObject __lookup$7(PyFrame var0) {
            var0.setlocal(2, var0.getglobal("None"));
            var0.setlocal(7, var0.getglobal("false"));
            if (var0.getlocal(7)._eq(var0.getglobal("true")).__nonzero__()) {
                var0.setlocal(5, var0.getglobal("progressiveParse").__call__(var0.getlocal(1), s$2));
                int var1 = 0;
                PyObject var4 = var0.getlocal(5);

                PyObject var3;
                while ((var3 = var4.__finditem__(var1++)) != null) {
                    var0.setlocal(6, var3);
                    if (var0.getglobal("fileSystem").invoke("exists", var0.getlocal(6)).__nonzero__()) {
                        var0.setlocal(3, var0.getlocal(0).invoke("handlerForPath", var0.getlocal(6)));
                        if (var0.getlocal(3).__nonzero__()) {
                            var0.setlocal(2, var0.getlocal(3).invoke("getValue", var0.getlocal(1)));
                        } else {
                            var0.getlocal(0).invoke("log", s$3._mod(var0.getlocal(6)));
                        }
                    }
                }
            } else {
                int var2 = 0;
                PyObject var6 = var0.getlocal(0).__getattr__("handlers");

                PyObject var5;
                while ((var5 = var6.__finditem__(var2++)) != null) {
                    var0.setlocal(4, var5);
                    if (var0.getlocal(4).invoke("canOpen", var0.getlocal(1), var0.getglobal("FOR_GET")).__nonzero__()) {
                        var0.setlocal(2, var0.getlocal(4).invoke("getValue", var0.getlocal(1)));
                    }
                }
            }

            return var0.getlocal(2);
        }

        private static PyObject replace_begin$8(PyFrame var0) {
            if (var0.getglobal("nequals").__call__(var0.getlocal(0), var0.getlocal(1)).__nonzero__()) {
                var0.setlocal(3, var0.getlocal(2)._add(var0.getlocal(0).__getslice__(var0.getglobal("len").__call__(var0.getlocal(1)), (PyObject) null, (PyObject) null)));
            } else {
                var0.setlocal(3, var0.getlocal(0));
            }

            return var0.getlocal(3);
        }

        private static PyObject _fix$9(PyFrame var0) {
            var0.setlocal(2, new PyFunction(var0.f_globals, new PyObject[0], c$7_replace_begin));
            var0.setlocal(0, var0.getlocal(2).__call__(var0.getlocal(0), s$0, s$4));
            PyObject var1;
            var0.setlocal(1, var0.getlocal(2).__call__(var0.getlocal(1), s$0, (var1 = var0.getlocal(0)).__nonzero__() ? var1 : s$4));
            return new PyTuple(new PyObject[]{var0.getlocal(0), var0.getlocal(1)});
        }

        private static PyObject translatePath$10(PyFrame var0) {
            var0.setlocal(3, new PyFunction(var0.f_globals, new PyObject[0], c$8__fix));
            PyObject var1 = var0.getlocal(3).__call__(var0.getlocal(2), var0.getlocal(1));
            var0.setlocal(2, var1.__getitem__(0));
            var0.setlocal(1, var1.__getitem__(1));
            var0.setlocal(4, s$5);
            if (var0.getglobal("nequals").__call__(var0.getlocal(1), var0.getlocal(2)).__not__().__nonzero__()) {
                if (var0.getglobal("len").__call__(var0.getlocal(2)).__nonzero__()) {
                    var1 = var0.getlocal(2);
                    var0.setlocal(4, var0.getlocal(4).__iadd__(var1));
                }

                if (var0.getlocal(4).__getslice__(i$6.__neg__(), (PyObject) null, (PyObject) null)._ne(s$2).__nonzero__()) {
                    var1 = s$2;
                    var0.setlocal(4, var0.getlocal(4).__iadd__(var1));
                }
            }

            var0.setlocal(4, var0.getlocal(4)._add(var0.getlocal(1)));
            return var0.getlocal(4);
        }

        private static PyObject handlerForPath$11(PyFrame var0) {
            var0.setlocal(2, var0.getglobal("FileDesc").__call__(var0.getlocal(1)));
            var0.setlocal(6, s$7);
            var0.setlocal(4, var0.getlocal(6)._mod(var0.getlocal(2).invoke("getType").invoke("toString")));
            var0.setlocal(5, var0.getglobal("DBiServer").invoke("getStr", var0.getlocal(4)));
            var0.setlocal(3, var0.getglobal("eval").__call__(s$8._mod(var0.getlocal(5))));
            return var0.getlocal(3);
        }

        private static PyObject lock$12(PyFrame var0) {
            var0.getlocal(0).__setattr__("locked", var0.getglobal("true"));
            return Py.None;
        }

        private static PyObject unlock$13(PyFrame var0) {
            var0.getlocal(0).__setattr__("locked", var0.getglobal("false"));
            var0.getlocal(0).__setattr__("lockedlist", new PyList(new PyObject[0]));
            return Py.None;
        }

        private static PyObject addAddListener$14(PyFrame var0) {
            var0.getlocal(0).__getattr__("addListeners").invoke("append", var0.getlocal(1));
            return Py.None;
        }

        private static PyObject removeAddListener$15(PyFrame var0) {
            var0.getlocal(0).__getattr__("addListeners").invoke("remove", var0.getlocal(1));
            return Py.None;
        }

        private static PyObject add$16(PyFrame var0) {
            var0.getlocal(0).__getattr__("entries").__setitem__(var0.getlocal(1).__getattr__("path"), var0.getlocal(1));
            var0.setlocal(2, var0.getglobal("DBiServerAddEvent").__call__(var0.getlocal(1), var0.getlocal(1).__getattr__("path"), var0.getlocal(0)));
            int var1 = 0;
            PyObject var3 = var0.getlocal(0).__getattr__("addListeners");

            PyObject var2;
            while ((var2 = var3.__finditem__(var1++)) != null) {
                var0.setlocal(3, var2);
                var0.getlocal(3).invoke("actionPerformed", var0.getlocal(2));
            }

            var0.setlocal(2, var0.getglobal("None"));
            if (var0.getlocal(0).__getattr__("locked").__nonzero__()) {
                var0.getlocal(0).__getattr__("lockedlist").invoke("append", var0.getlocal(1));
            }

            return Py.None;
        }

        private static PyObject getRoot$17(PyFrame var0) {
            return var0.getlocal(0).__getattr__("DBIROOT");
        }

        private static PyObject __init__$18(PyFrame var0) {
            var0.getlocal(0).invoke("unlock");
            var0.setlocal(2, var0.getglobal("DBiHandlerListener").__call__(var0.getlocal(0)));
            var0.setlocal(1, var0.getglobal("RCDBiHandler").__call__(var0.getlocal(0).__getattr__("getRoot")));
            var0.getlocal(1).invoke("addAddListener", var0.getlocal(2));
            var0.getlocal(0).__setattr__("handlers", new PyList(new PyObject[]{var0.getlocal(1)}));
            var0.getlocal(0).__setattr__("entries", new PyDictionary(new PyObject[0]));
            var0.getlocal(0).__setattr__("addListeners", new PyList(new PyObject[0]));
            return Py.None;
        }

        private static PyObject __del__$19(PyFrame var0) {
            try {
                int var1 = 0;
                PyObject var4 = var0.getlocal(0).__getattr__("handlers");

                PyObject var3;
                while ((var3 = var4.__finditem__(var1++)) != null) {
                    var0.setlocal(1, var3);
                    var0.setlocal(1, var0.getglobal("None"));
                }
            } catch (Throwable var6) {
                PyException var2 = Py.setException(var6, var0);
                if (!Py.matchException(var2, var0.getglobal("AttributeError"))) {
                    throw var2;
                }
            }

            return Py.None;
        }

        private static PyObject AwxDBiServer$20(PyFrame var0) {
            var0.setlocal("enum", new PyFunction(var0.f_globals, new PyObject[]{s$0, var0.getname("EnumFlat")}, c$1_enum));
            var0.setlocal("x_enum", new PyFunction(var0.f_globals, new PyObject[]{s$0, var0.getname("EnumFlat")}, c$2_x_enum));
            var0.setlocal("get", new PyFunction(var0.f_globals, new PyObject[0], c$3_get));
            var0.setlocal("getStr", new PyFunction(var0.f_globals, new PyObject[0], c$4_getStr));
            var0.setlocal("getStrOrNil", new PyFunction(var0.f_globals, new PyObject[0], c$5_getStrOrNil));
            var0.setlocal("__lookup", new PyFunction(var0.f_globals, new PyObject[0], c$6___lookup));
            var0.setlocal("translatePath", new PyFunction(var0.f_globals, new PyObject[0], c$9_translatePath));
            var0.setlocal("handlerForPath", new PyFunction(var0.f_globals, new PyObject[0], c$10_handlerForPath));
            var0.setlocal("lock", new PyFunction(var0.f_globals, new PyObject[0], c$11_lock));
            var0.setlocal("unlock", new PyFunction(var0.f_globals, new PyObject[0], c$12_unlock));
            var0.setlocal("addAddListener", new PyFunction(var0.f_globals, new PyObject[0], c$13_addAddListener));
            var0.setlocal("removeAddListener", new PyFunction(var0.f_globals, new PyObject[0], c$14_removeAddListener));
            var0.setlocal("add", new PyFunction(var0.f_globals, new PyObject[0], c$15_add));
            var0.setlocal("getRoot", new PyFunction(var0.f_globals, new PyObject[0], c$16_getRoot));
            var0.setlocal("__init__", new PyFunction(var0.f_globals, new PyObject[0], c$17___init__));
            var0.setlocal("__del__", new PyFunction(var0.f_globals, new PyObject[0], c$18___del__));
            return var0.getf_locals();
        }

        private static PyObject main$21(PyFrame var0) {
            var0.setglobal("__file__", s$9);
            var0.setlocal("Value", imp.importOne("Value", var0));
            PyObject[] var1 = imp.importFrom("etoffiutils", new String[]{"true", "false", "nequals"}, var0);
            var0.setlocal("true", var1[0]);
            var0.setlocal("false", var1[1]);
            var0.setlocal("nequals", var1[2]);
            var1 = imp.importFrom("RCDBiHandler", new String[]{"RCDBiHandler"}, var0);
            var0.setlocal("RCDBiHandler", var1[0]);
            var0.setlocal("sys", imp.importOne("sys", var0));
            var0.setlocal("traceback", imp.importOne("traceback", var0));
            imp.importAll("Structure", var0);
            imp.importAll("AwxDBiServerConfig", var0);
            var0.setlocal("errNotFound", Py.makeClass("errNotFound", new PyObject[]{var0.getname("Exception")}, c$0_errNotFound, (PyObject) null));
            var0.setlocal("AwxDBiServer", Py.makeClass("AwxDBiServer", new PyObject[]{var0.getname("AwxDBiServerConfig")}, c$19_AwxDBiServer, (PyObject) null));
            var0.setlocal("DBiServer", var0.getname("AwxDBiServer").__call__());
            return Py.None;
        }
    }
}
