package mail98;

import org.python.core.*;

public class MMS extends java.lang.Object {
    static String[] jpy$properties = new String[] {"python.modules.builtin", "exceptions:org.python.core.exceptions", "python.options.showJavaExceptions", "true"};
    static String[] jpy$packages = new String[] {"java.io", null, "javax.swing.text", null, "javax.swing.tree", null, "java.awt.print", null, "java.awt.peer", null, "java.awt.font", null, "javax.swing.colorchooser", null, "java.awt.datatransfer", null, "java.awt.geom", null, "java.lang", null, "javax.swing.undo", null, "java.awt", "Choice,PrintGraphics,ImageCapabilities,DisplayMode,Cursor,GradientPaint,Robot,GridLayout,CheckboxMenuItem,Window,GraphicsConfiguration,BasicStroke,AWTEvent,TextField,AWTException,Menu,Insets,Shape,PointerInfo,GraphicsEnvironment,MenuShortcut,LayoutManager2,AlphaComposite,GridBagLayout,Frame,Font,KeyEventPostProcessor,Scrollbar,Panel,MouseInfo,FileDialog,ScrollPaneAdjustable,Event,Checkbox,ItemSelectable,DefaultKeyboardFocusManager,GraphicsConfigTemplate,FontMetrics,ComponentOrientation,BufferCapabilities,AWTKeyStroke,DefaultFocusTraversalPolicy,PaintContext,List,CompositeContext,MenuContainer,TextComponent,KeyEventDispatcher,PrintJob,SystemColor,ActiveEvent,TextArea,GraphicsDevice,Adjustable,FontFormatException,Rectangle,FocusTraversalPolicy,RenderingHints,AWTPermission,Component,TexturePaint,AWTEventMulticaster,Stroke,MediaTracker,BorderLayout,Point,HeadlessException,Paint,ScrollPane,Graphics,MenuBar,Color,FlowLayout,Label,Button,Transparency,Graphics2D,GridBagConstraints,IllegalComponentStateException,CardLayout,KeyboardFocusManager,CheckboxGroup,Toolkit,Dialog,Polygon,PageAttributes,Container,Composite,JobAttributes,MenuComponent,Canvas,ContainerOrderFocusTraversalPolicy,EventQueue,PopupMenu,LayoutManager,MenuItem,Image,Dimension,AWTError", "javax.swing.event", "PopupMenuListener,HyperlinkEvent,MenuKeyEvent,UndoableEditEvent,MenuDragMouseListener,ChangeEvent,TreeExpansionEvent,InternalFrameListener,TreeWillExpandListener,AncestorEvent,ListSelectionEvent,HyperlinkListener,DocumentListener,TableColumnModelEvent,AncestorListener,TreeModelEvent,TableModelEvent,TreeExpansionListener,ListSelectionListener,InternalFrameEvent,MouseInputListener,TreeSelectionEvent,SwingPropertyChangeSupport,ChangeListener,ListDataEvent,TableModelListener,CaretEvent,PopupMenuEvent,EventListenerList,MenuEvent,MouseInputAdapter,UndoableEditListener,ListDataListener,MenuListener,DocumentEvent,MenuDragMouseEvent,InternalFrameAdapter,CaretListener,TreeModelListener,MenuKeyListener,TableColumnModelListener,CellEditorListener,TreeSelectionListener", "javax.swing.border", null, "javax.swing.filechooser", null, "java.awt.im", null, "java.awt.image", null, "javax.swing.table", "TableColumnModel,TableColumn,TableCellEditor,DefaultTableModel,AbstractTableModel,DefaultTableColumnModel,JTableHeader,TableModel,TableCellRenderer,DefaultTableCellRenderer", "java.awt.dnd", null, "java.awt.color", null, "java.awt.event", "ComponentEvent,PaintEvent,InvocationEvent,FocusListener,HierarchyBoundsAdapter,MouseListener,MouseWheelEvent,FocusEvent,WindowEvent,AdjustmentListener,MouseEvent,ComponentListener,ItemEvent,KeyListener,HierarchyEvent,KeyEvent,InputEvent,WindowListener,HierarchyBoundsListener,MouseMotionListener,ActionListener,WindowAdapter,WindowStateListener,InputMethodEvent,MouseWheelListener,TextListener,KeyAdapter,AdjustmentEvent,ItemListener,ContainerAdapter,ActionEvent,InputMethodListener,MouseAdapter,FocusAdapter,TextEvent,HierarchyListener,ContainerListener,AWTEventListenerProxy,WindowFocusListener,ComponentAdapter,MouseMotionAdapter,AWTEventListener,ContainerEvent", "javax.swing", "WindowConstants,ComboBoxModel,DefaultListModel,PopupFactory,Timer,JRootPane,AbstractAction,DebugGraphics,DefaultButtonModel,ListSelectionModel,JMenuItem,ScrollPaneConstants,ComponentInputMap,DefaultComboBoxModel,UIManager,JTextField,AbstractButton,MutableComboBoxModel,AbstractCellEditor,SpinnerModel,JLabel,OverlayLayout,DesktopManager,JColorChooser,ToolTipManager,DefaultListCellRenderer,BoxLayout,SpringLayout,SwingUtilities,JTabbedPane,ProgressMonitorInputStream,JInternalFrame,ImageIcon,JRadioButton,TransferHandler,Box,SizeRequirements,InternalFrameFocusTraversalPolicy,LookAndFeel,ViewportLayout,JProgressBar,ButtonGroup,JToolBar,JDialog,BorderFactory,JTextArea,Renderer,JSeparator,JApplet,MenuElement,JToggleButton,JPasswordField,SpinnerDateModel,ListCellRenderer,JTree,InputVerifier,AbstractListModel,JMenu,JComboBox,MenuSelectionManager,JScrollPane,UIDefaults,FocusManager,SingleSelectionModel,InputMap,CellEditor,JFrame,JFormattedTextField,JTable,Spring,ButtonModel,JComponent,ComboBoxEditor,RootPaneContainer,SortingFocusTraversalPolicy,SpinnerListModel,JSpinner,BoundedRangeModel,JCheckBox,DefaultBoundedRangeModel,JMenuBar,JPopupMenu,ProgressMonitor,Popup,CellRendererPane,RepaintManager,Scrollable,AbstractSpinnerModel,ListModel,DefaultSingleSelectionModel,GrayFilter,KeyStroke,SizeSequence,UnsupportedLookAndFeelException,JLayeredPane,LayoutFocusTraversalPolicy,JCheckBoxMenuItem,ScrollPaneLayout,DefaultDesktopManager,JSplitPane,SpinnerNumberModel,JPanel,JDesktopPane,DefaultFocusManager,JRadioButtonMenuItem,JWindow,JToolTip,JSlider,JList,Action,JViewport,JTextPane,JScrollBar,JEditorPane,DefaultListSelectionModel,JFileChooser,JButton,DefaultCellEditor,SwingConstants,JOptionPane,Icon,ActionMap", "javax.swing.plaf", null};
    
    public static class _PyInner extends PyFunctionTable implements PyRunnable {
        private static PyObject s$0;
        private static PyObject s$1;
        private static PyObject s$2;
        private static PyObject s$3;
        private static PyObject i$4;
        private static PyObject s$5;
        private static PyObject i$6;
        private static PyObject s$7;
        private static PyObject s$8;
        private static PyObject s$9;
        private static PyObject i$10;
        private static PyObject s$11;
        private static PyObject s$12;
        private static PyObject s$13;
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
        private static PyObject s$24;
        private static PyObject s$25;
        private static PyObject i$26;
        private static PyObject i$27;
        private static PyObject s$28;
        private static PyObject s$29;
        private static PyObject s$30;
        private static PyObject s$31;
        private static PyObject s$32;
        private static PyObject s$33;
        private static PyObject s$34;
        private static PyObject s$35;
        private static PyObject i$36;
        private static PyObject s$37;
        private static PyObject s$38;
        private static PyObject s$39;
        private static PyObject s$40;
        private static PyObject s$41;
        private static PyObject s$42;
        private static PyObject s$43;
        private static PyObject s$44;
        private static PyObject i$45;
        private static PyObject i$46;
        private static PyObject i$47;
        private static PyObject i$48;
        private static PyObject s$49;
        private static PyObject s$50;
        private static PyObject s$51;
        private static PyFunctionTable funcTable;
        private static PyCode c$0___init__;
        private static PyCode c$1_content;
        private static PyCode c$2_get;
        private static PyCode c$3_MMSMessage;
        private static PyCode c$4_ST;
        private static PyCode c$5_getColumnCount;
        private static PyCode c$6_getRowCount;
        private static PyCode c$7_getColumnName;
        private static PyCode c$8_getValueAt;
        private static PyCode c$9_getColumnClass;
        private static PyCode c$10_isCellEditable;
        private static PyCode c$11_setValueAt;
        private static PyCode c$12___printDebugData;
        private static PyCode c$13_MyTableModel;
        private static PyCode c$14_SW;
        private static PyCode c$15_tableSelectionChanged;
        private static PyCode c$16_go;
        private static PyCode c$17_MsgView;
        private static PyCode c$18___init__;
        private static PyCode c$19_valueChanged;
        private static PyCode c$20_L;
        private static PyCode c$21_go;
        private static PyCode c$22_tableSelectionChanged;
        private static PyCode c$23_HeadersView;
        private static PyCode c$24_initColumnSizes;
        private static PyCode c$25_go;
        private static PyCode c$26_MMSMsgViewFrame;
        private static PyCode c$27_lambda;
        private static PyCode c$28_tell;
        private static PyCode c$29_UI;
        private static PyCode c$30_strsplit;
        private static PyCode c$31__int_checkmail;
        private static PyCode c$32___init__;
        private static PyCode c$33_EE;
        private static PyCode c$34_main;
        private static void initConstants() {
            s$0 = Py.newString("Subject From Date Size");
            s$1 = Py.newString("Dont read this spam letter");
            s$2 = Py.newString("Angela Andrews");
            s$3 = Py.newString("Sun May 31 1999 20:11 EST");
            i$4 = Py.newInteger(1111);
            s$5 = Py.newString("/data");
            i$6 = Py.newInteger(2);
            s$7 = Py.newString("-C");
            s$8 = Py.newString("/data/");
            s$9 = Py.newString("");
            i$10 = Py.newInteger(0);
            s$11 = Py.newString("Setting value at ");
            s$12 = Py.newString(",");
            s$13 = Py.newString(" to ");
            s$14 = Py.newString(" (an instance of ");
            s$15 = Py.newString(")");
            s$16 = Py.newString("xx1");
            s$17 = Py.newString("xx2");
            s$18 = Py.newString("The \"");
            s$19 = Py.newString("\" column accepts only integer values.");
            s$20 = Py.newString("xx3");
            s$21 = Py.newString("New value of data:");
            s$22 = Py.newString("    row ");
            s$23 = Py.newString(":");
            s$24 = Py.newString("  ");
            s$25 = Py.newString("--------------------------");
            i$26 = Py.newInteger(3);
            i$27 = Py.newInteger(5);
            s$28 = Py.newString("From");
            s$29 = Py.newString("Date");
            s$30 = Py.newString("Subject");
            s$31 = Py.newString("No rows are selected");
            s$32 = Py.newString("selectedRow");
            s$33 = Py.newString("contentLen");
            s$34 = Py.newString("(no content)");
            s$35 = Py.newString("Row %s is now selected.");
            i$36 = Py.newInteger(1);
            s$37 = Py.newString("content");
            s$38 = Py.newString("Null pointer exception!");
            s$39 = Py.newString("  getHeaderRenderer returns null in 1.3.");
            s$40 = Py.newString("  The replacement is getDefaultRenderer.");
            s$41 = Py.newString("Initializing width of column ");
            s$42 = Py.newString(". ");
            s$43 = Py.newString("headerWidth = ");
            s$44 = Py.newString("; cellWidth = ");
            i$45 = Py.newInteger(525);
            i$46 = Py.newInteger(200);
            i$47 = Py.newInteger(500);
            i$48 = Py.newInteger(75);
            s$49 = Py.newString("/");
            s$50 = Py.newString("Finished checking all sources");
            s$51 = Py.newString("/local/data/Projects/98-mail/98/MMS.py");
            funcTable = new _PyInner();
            c$0___init__ = Py.newCode(3, new String[] {"self", "D", "M"}, "/local/data/Projects/98-mail/98/MMS.py", "__init__", false, false, funcTable, 0, null, null, 0, 1);
            c$1_content = Py.newCode(1, new String[] {"self"}, "/local/data/Projects/98-mail/98/MMS.py", "content", false, false, funcTable, 1, null, null, 0, 1);
            c$2_get = Py.newCode(2, new String[] {"self", "key"}, "/local/data/Projects/98-mail/98/MMS.py", "get", false, false, funcTable, 2, null, null, 0, 1);
            c$3_MMSMessage = Py.newCode(0, new String[] {}, "/local/data/Projects/98-mail/98/MMS.py", "MMSMessage", false, false, funcTable, 3, null, null, 0, 0);
            c$4_ST = Py.newCode(2, new String[] {"self", "msgs", "D", "m", "R", "e", "d", "Message", "each"}, "/local/data/Projects/98-mail/98/MMS.py", "ST", false, false, funcTable, 4, null, null, 0, 1);
            c$5_getColumnCount = Py.newCode(1, new String[] {"self"}, "/local/data/Projects/98-mail/98/MMS.py", "getColumnCount", false, false, funcTable, 5, null, null, 0, 1);
            c$6_getRowCount = Py.newCode(1, new String[] {"self", "R"}, "/local/data/Projects/98-mail/98/MMS.py", "getRowCount", false, false, funcTable, 6, null, null, 0, 1);
            c$7_getColumnName = Py.newCode(2, new String[] {"self", "col"}, "/local/data/Projects/98-mail/98/MMS.py", "getColumnName", false, false, funcTable, 7, null, null, 0, 1);
            c$8_getValueAt = Py.newCode(3, new String[] {"self", "row", "col"}, "/local/data/Projects/98-mail/98/MMS.py", "getValueAt", false, false, funcTable, 8, null, null, 0, 1);
            c$9_getColumnClass = Py.newCode(2, new String[] {"self", "c", "val"}, "/local/data/Projects/98-mail/98/MMS.py", "getColumnClass", false, false, funcTable, 9, null, null, 0, 1);
            c$10_isCellEditable = Py.newCode(3, new String[] {"self", "row", "col"}, "/local/data/Projects/98-mail/98/MMS.py", "isCellEditable", false, false, funcTable, 10, null, null, 0, 1);
            c$11_setValueAt = Py.newCode(4, new String[] {"self", "value", "row", "col", "e"}, "/local/data/Projects/98-mail/98/MMS.py", "setValueAt", false, false, funcTable, 11, null, null, 0, 1);
            c$12___printDebugData = Py.newCode(1, new String[] {"self", "j", "i", "numRows", "numCols"}, "/local/data/Projects/98-mail/98/MMS.py", "__printDebugData", false, false, funcTable, 12, null, null, 0, 1);
            c$13_MyTableModel = Py.newCode(0, new String[] {}, "/local/data/Projects/98-mail/98/MMS.py", "MyTableModel", false, false, funcTable, 13, null, null, 0, 0);
            c$14_SW = Py.newCode(2, new String[] {"self", "p"}, "/local/data/Projects/98-mail/98/MMS.py", "SW", false, false, funcTable, 14, null, null, 0, 1);
            c$15_tableSelectionChanged = Py.newCode(2, new String[] {"self", "lsm", "content", "selectedRow"}, "/local/data/Projects/98-mail/98/MMS.py", "tableSelectionChanged", false, false, funcTable, 15, null, null, 0, 1);
            c$16_go = Py.newCode(2, new String[] {"self", "Messages", "jp"}, "/local/data/Projects/98-mail/98/MMS.py", "go", false, false, funcTable, 16, null, null, 0, 1);
            c$17_MsgView = Py.newCode(0, new String[] {}, "/local/data/Projects/98-mail/98/MMS.py", "MsgView", false, false, funcTable, 17, null, null, 0, 0);
            c$18___init__ = Py.newCode(2, new String[] {"self", "x"}, "/local/data/Projects/98-mail/98/MMS.py", "__init__", false, false, funcTable, 18, null, null, 0, 1);
            c$19_valueChanged = Py.newCode(2, new String[] {"self", "e", "lsm"}, "/local/data/Projects/98-mail/98/MMS.py", "valueChanged", false, false, funcTable, 19, null, null, 0, 1);
            c$20_L = Py.newCode(0, new String[] {}, "/local/data/Projects/98-mail/98/MMS.py", "L", false, false, funcTable, 20, null, null, 0, 0);
            c$21_go = Py.newCode(3, new String[] {"self", "msgs", "x", "rowSM", "ll"}, "/local/data/Projects/98-mail/98/MMS.py", "go", false, false, funcTable, 21, null, null, 0, 1);
            c$22_tableSelectionChanged = Py.newCode(2, new String[] {"self", "lsm", "selectedRow"}, "/local/data/Projects/98-mail/98/MMS.py", "tableSelectionChanged", false, false, funcTable, 22, null, null, 0, 1);
            c$23_HeadersView = Py.newCode(0, new String[] {}, "/local/data/Projects/98-mail/98/MMS.py", "HeadersView", false, false, funcTable, 23, null, null, 0, 0);
            c$24_initColumnSizes = Py.newCode(3, new String[] {"self", "table", "model", "kl", "cellWidth", "column", "i", "longValues", "comp", "e", "headerWidth"}, "/local/data/Projects/98-mail/98/MMS.py", "initColumnSizes", false, false, funcTable, 24, null, null, 0, 1);
            c$25_go = Py.newCode(1, new String[] {"self", "bottom", "sp", "Messages", "myModel", "top", "table"}, "/local/data/Projects/98-mail/98/MMS.py", "go", false, false, funcTable, 25, null, null, 0, 1);
            c$26_MMSMsgViewFrame = Py.newCode(0, new String[] {}, "/local/data/Projects/98-mail/98/MMS.py", "MMSMsgViewFrame", false, false, funcTable, 26, null, null, 0, 0);
            c$27_lambda = Py.newCode(1, new String[] {"x"}, "/local/data/Projects/98-mail/98/MMS.py", "<lambda>", false, false, funcTable, 27, null, null, 0, 1);
            c$28_tell = Py.newCode(2, new String[] {"self", "x"}, "/local/data/Projects/98-mail/98/MMS.py", "tell", false, false, funcTable, 28, null, null, 0, 1);
            c$29_UI = Py.newCode(0, new String[] {}, "/local/data/Projects/98-mail/98/MMS.py", "UI", false, false, funcTable, 29, null, null, 0, 0);
            c$30_strsplit = Py.newCode(2, new String[] {"instr", "splitby", "pos"}, "/local/data/Projects/98-mail/98/MMS.py", "strsplit", false, false, funcTable, 30, null, null, 0, 1);
            c$31__int_checkmail = Py.newCode(3, new String[] {"self", "dbiroot", "getting", "acct_name", "Sources", "root", "each", "strsplit"}, "/local/data/Projects/98-mail/98/MMS.py", "_int_checkmail", false, false, funcTable, 31, null, null, 0, 1);
            c$32___init__ = Py.newCode(3, new String[] {"self", "deleting", "ui"}, "/local/data/Projects/98-mail/98/MMS.py", "__init__", false, false, funcTable, 32, null, null, 0, 1);
            c$33_EE = Py.newCode(0, new String[] {}, "/local/data/Projects/98-mail/98/MMS.py", "EE", false, false, funcTable, 33, null, null, 0, 0);
            c$34_main = Py.newCode(0, new String[] {}, "/local/data/Projects/98-mail/98/MMS.py", "main", false, false, funcTable, 34, null, null, 0, 0);
        }
        
        
        public PyCode getMain() {
            if (c$34_main == null) _PyInner.initConstants();
            return c$34_main;
        }
        
        public PyObject call_function(int index, PyFrame frame) {
            switch (index){
                case 0:
                return _PyInner.__init__$1(frame);
                case 1:
                return _PyInner.content$2(frame);
                case 2:
                return _PyInner.get$3(frame);
                case 3:
                return _PyInner.MMSMessage$4(frame);
                case 4:
                return _PyInner.ST$5(frame);
                case 5:
                return _PyInner.getColumnCount$6(frame);
                case 6:
                return _PyInner.getRowCount$7(frame);
                case 7:
                return _PyInner.getColumnName$8(frame);
                case 8:
                return _PyInner.getValueAt$9(frame);
                case 9:
                return _PyInner.getColumnClass$10(frame);
                case 10:
                return _PyInner.isCellEditable$11(frame);
                case 11:
                return _PyInner.setValueAt$12(frame);
                case 12:
                return _PyInner.__printDebugData$13(frame);
                case 13:
                return _PyInner.MyTableModel$14(frame);
                case 14:
                return _PyInner.SW$15(frame);
                case 15:
                return _PyInner.tableSelectionChanged$16(frame);
                case 16:
                return _PyInner.go$17(frame);
                case 17:
                return _PyInner.MsgView$18(frame);
                case 18:
                return _PyInner.__init__$19(frame);
                case 19:
                return _PyInner.valueChanged$20(frame);
                case 20:
                return _PyInner.L$21(frame);
                case 21:
                return _PyInner.go$22(frame);
                case 22:
                return _PyInner.tableSelectionChanged$23(frame);
                case 23:
                return _PyInner.HeadersView$24(frame);
                case 24:
                return _PyInner.initColumnSizes$25(frame);
                case 25:
                return _PyInner.go$26(frame);
                case 26:
                return _PyInner.MMSMsgViewFrame$27(frame);
                case 27:
                return _PyInner.lambda$28(frame);
                case 28:
                return _PyInner.tell$29(frame);
                case 29:
                return _PyInner.UI$30(frame);
                case 30:
                return _PyInner.strsplit$31(frame);
                case 31:
                return _PyInner._int_checkmail$32(frame);
                case 32:
                return _PyInner.__init__$33(frame);
                case 33:
                return _PyInner.EE$34(frame);
                case 34:
                return _PyInner.main$35(frame);
                default:
                return null;
            }
        }
        
        private static PyObject __init__$1(PyFrame frame) {
            frame.getlocal(0).__setattr__("D", frame.getlocal(1));
            frame.getlocal(2).invoke("rewindbody");
            frame.getlocal(0).__setattr__("MM", frame.getlocal(2).__getattr__("fp").invoke("read"));
            return Py.None;
        }
        
        private static PyObject content$2(PyFrame frame) {
            return frame.getlocal(0).__getattr__("MM");
        }
        
        private static PyObject get$3(PyFrame frame) {
            return frame.getlocal(0).__getattr__("D").__getitem__(frame.getlocal(1));
        }
        
        private static PyObject MMSMessage$4(PyFrame frame) {
            frame.setlocal("__init__", new PyFunction(frame.f_globals, new PyObject[] {}, c$0___init__));
            frame.setlocal("content", new PyFunction(frame.f_globals, new PyObject[] {}, c$1_content));
            frame.setlocal("get", new PyFunction(frame.f_globals, new PyObject[] {}, c$2_get));
            return frame.getf_locals();
        }
        
        private static PyObject ST$5(PyFrame frame) {
            PyObject[] imp_accu;
            // Temporary Variables
            int t$0$int, t$1$int;
            PyException t$0$PyException;
            PyObject t$0$PyObject, t$1$PyObject, t$2$PyObject, t$3$PyObject;
            
            // Code
            imp_accu = org.python.core.imp.importFrom("rfc822", new String[] {"Message"}, frame);
            frame.setlocal(7, imp_accu[0]);
            frame.getlocal(0).__setattr__("data", frame.getlocal(1));
            frame.setlocal(6, frame.getglobal("os").__getattr__("listdir").__call__(frame.getlocal(0).__getattr__("root")._add(s$5)));
            t$0$int = 0;
            t$1$PyObject = frame.getlocal(6);
            while ((t$0$PyObject = t$1$PyObject.__finditem__(t$0$int++)) != null) {
                frame.setlocal(5, t$0$PyObject);
                if (frame.getlocal(5).__getslice__(i$6.__neg__(), null, null)._ne(s$7).__nonzero__()) {
                    continue;
                }
                frame.setlocal(3, frame.getlocal(7).__call__(frame.getglobal("open").__call__(frame.getlocal(0).__getattr__("root")._add(s$8)._add(frame.getlocal(5)))));
                frame.setlocal(2, new PyDictionary(new PyObject[] {}));
                t$1$int = 0;
                t$3$PyObject = frame.getlocal(0).__getattr__("columnNames");
                while ((t$2$PyObject = t$3$PyObject.__finditem__(t$1$int++)) != null) {
                    frame.setlocal(8, t$2$PyObject);
                    frame.setlocal(4, s$9);
                    try {
                        frame.setlocal(4, frame.getlocal(3).invoke("getheader", frame.getlocal(8)));
                    }
                    catch (Throwable x$0) {
                        t$0$PyException = Py.setException(x$0, frame);
                        // pass
                    }
                    frame.getlocal(2).__setitem__(frame.getlocal(8), frame.getlocal(4));
                }
                frame.getlocal(0).__getattr__("data").invoke("append", frame.getglobal("MMSMessage").__call__(frame.getlocal(2), frame.getlocal(3)));
            }
            return Py.None;
        }
        
        private static PyObject getColumnCount$6(PyFrame frame) {
            return frame.getglobal("len").__call__(frame.getlocal(0).__getattr__("columnNames"));
        }
        
        private static PyObject getRowCount$7(PyFrame frame) {
            frame.setlocal(1, frame.getglobal("len").__call__(frame.getlocal(0).__getattr__("data")));
            return frame.getlocal(1);
        }
        
        private static PyObject getColumnName$8(PyFrame frame) {
            return frame.getlocal(0).__getattr__("columnNames").__getitem__(frame.getlocal(1));
        }
        
        private static PyObject getValueAt$9(PyFrame frame) {
            return frame.getlocal(0).__getattr__("data").__getitem__(frame.getlocal(1)).invoke("get", frame.getlocal(0).__getattr__("columnNames").__getitem__(frame.getlocal(2)));
        }
        
        private static PyObject getColumnClass$10(PyFrame frame) {
            frame.setlocal(2, frame.getlocal(0).invoke("getValueAt", i$10, frame.getlocal(1)));
            return frame.getlocal(2).__getattr__("__class__");
        }
        
        private static PyObject isCellEditable$11(PyFrame frame) {
            if (frame.getlocal(2)._lt(i$6).__nonzero__()) {
                return frame.getglobal("false");
            }
            else {
                return frame.getglobal("true");
            }
        }
        
        private static PyObject setValueAt$12(PyFrame frame) {
            // Temporary Variables
            PyException t$0$PyException;
            PyObject t$0$PyObject;
            
            // Code
            if (frame.getglobal("DEBUG").__nonzero__()) {
                Py.println(s$11._add(frame.getlocal(2))._add(s$12)._add(frame.getlocal(3))._add(s$13)._add(frame.getlocal(1))._add(s$14)._add(frame.getlocal(1).invoke("getClass"))._add(s$15));
            }
            Py.println(s$16);
            if (((t$0$PyObject = frame.getlocal(0).__getattr__("data").__getitem__(i$10).__getitem__(frame.getlocal(0).__getattr__("columnNames").__getitem__(frame.getlocal(3)))._is(frame.getglobal("Integer"))).__nonzero__() ? frame.getlocal(1)._is(frame.getglobal("Integer")).__not__() : t$0$PyObject).__nonzero__()) {
                Py.println(s$17);
                try {
                    frame.getlocal(0).__getattr__("data").__getitem__(frame.getlocal(2)).__setitem__(frame.getlocal(3), frame.getglobal("Integer").__call__(frame.getlocal(1).invoke("toString")));
                    frame.getlocal(0).invoke("fireTableCellUpdated", frame.getlocal(2), frame.getlocal(3));
                }
                catch (Throwable x$0) {
                    t$0$PyException = Py.setException(x$0, frame);
                    if (Py.matchException(t$0$PyException, frame.getglobal("NumberFormatException"))) {
                        frame.setlocal(4, t$0$PyException.value);
                        frame.getglobal("JOptionPane").__getattr__("showMessageDialog").__call__(frame.getglobal("None"), s$18._add(frame.getlocal(0).invoke("getColumnName", frame.getlocal(3)))._add(s$19));
                    }
                    else throw t$0$PyException;
                }
            }
            else {
                Py.println(s$17);
                frame.getlocal(0).__getattr__("data").__getitem__(frame.getlocal(2)).__setitem__(frame.getlocal(3), frame.getlocal(1));
                frame.getlocal(0).invoke("fireTableCellUpdated", frame.getlocal(2), frame.getlocal(3));
            }
            Py.println(s$20);
            if (frame.getglobal("DEBUG").__nonzero__()) {
                Py.println(s$21);
                frame.getlocal(0).invoke("printDebugData");
            }
            return Py.None;
        }
        
        private static PyObject __printDebugData$13(PyFrame frame) {
            // Temporary Variables
            int t$0$int, t$1$int;
            PyObject t$0$PyObject, t$1$PyObject, t$2$PyObject, t$3$PyObject;
            
            // Code
            frame.setlocal(3, frame.getlocal(0).invoke("getRowCount"));
            frame.setlocal(4, frame.getlocal(0).invoke("getColumnCount"));
            frame.setlocal(2, i$10);
            t$0$int = 0;
            t$1$PyObject = frame.getlocal(3);
            while ((t$0$PyObject = t$1$PyObject.__finditem__(t$0$int++)) != null) {
                frame.setlocal(2, t$0$PyObject);
                Py.println(s$22._add(frame.getlocal(2))._add(s$23));
                t$1$int = 0;
                t$3$PyObject = frame.getglobal("numcols");
                while ((t$2$PyObject = t$3$PyObject.__finditem__(t$1$int++)) != null) {
                    frame.setlocal(1, t$2$PyObject);
                    Py.println(s$24._add(frame.getglobal("data").__getitem__(frame.getlocal(2)).__getitem__(frame.getlocal(1))));
                }
                Py.println();
            }
            Py.println(s$25);
            return Py.None;
        }
        
        private static PyObject MyTableModel$14(PyFrame frame) {
            frame.setlocal("columnNames", s$0.invoke("split"));
            frame.setlocal("longValues", new PyList(new PyObject[] {s$1, s$2, s$3, i$4}));
            frame.setlocal("ST", new PyFunction(frame.f_globals, new PyObject[] {}, c$4_ST));
            frame.setlocal("getColumnCount", new PyFunction(frame.f_globals, new PyObject[] {}, c$5_getColumnCount));
            frame.setlocal("getRowCount", new PyFunction(frame.f_globals, new PyObject[] {}, c$6_getRowCount));
            frame.setlocal("getColumnName", new PyFunction(frame.f_globals, new PyObject[] {}, c$7_getColumnName));
            frame.setlocal("getValueAt", new PyFunction(frame.f_globals, new PyObject[] {}, c$8_getValueAt));
            frame.setlocal("getColumnClass", new PyFunction(frame.f_globals, new PyObject[] {}, c$9_getColumnClass));
            frame.setlocal("isCellEditable", new PyFunction(frame.f_globals, new PyObject[] {}, c$10_isCellEditable));
            frame.setlocal("setValueAt", new PyFunction(frame.f_globals, new PyObject[] {}, c$11_setValueAt));
            frame.setlocal("__printDebugData", new PyFunction(frame.f_globals, new PyObject[] {}, c$12___printDebugData));
            return frame.getf_locals();
        }
        
        private static PyObject SW$15(PyFrame frame) {
            frame.getlocal(1).__setattr__("layout", frame.getglobal("GridLayout").__call__(new PyObject[] {i$26, i$6, i$27, i$27}));
            frame.getlocal(0).__setattr__("fromField", frame.getglobal("JTextField").__call__(new PyObject[] {frame.getglobal("false")}, new String[] {"editable"}));
            frame.getlocal(0).__setattr__("dateField", frame.getglobal("JTextField").__call__(new PyObject[] {frame.getglobal("false")}, new String[] {"editable"}));
            frame.getlocal(0).__setattr__("subjectField", frame.getglobal("JTextField").__call__(new PyObject[] {frame.getglobal("false")}, new String[] {"editable"}));
            frame.getlocal(1).invoke("add", frame.getglobal("JLabel").__call__(s$28));
            frame.getlocal(1).invoke("add", frame.getlocal(0).__getattr__("fromField"));
            frame.getlocal(1).invoke("add", frame.getglobal("JLabel").__call__(s$29));
            frame.getlocal(1).invoke("add", frame.getlocal(0).__getattr__("dateField"));
            frame.getlocal(1).invoke("add", frame.getglobal("JLabel").__call__(s$30));
            frame.getlocal(1).invoke("add", frame.getlocal(0).__getattr__("subjectField"));
            return Py.None;
        }
        
        private static PyObject tableSelectionChanged$16(PyFrame frame) {
            if (frame.getlocal(1).invoke("isSelectionEmpty").__nonzero__()) {
                Py.println(s$31);
            }
            else {
                frame.setlocal(3, frame.getlocal(1).invoke("getMinSelectionIndex"));
                Py.printComma(s$32);
                Py.println(frame.getlocal(3));
                frame.setlocal(2, frame.getlocal(0).__getattr__("Messages").__getitem__(frame.getlocal(3)).invoke("content"));
                Py.printComma(s$33);
                Py.println(frame.getglobal("len").__call__(frame.getlocal(2)));
                if (frame.getglobal("len").__call__(frame.getlocal(2))._eq(i$10).__nonzero__()) {
                    frame.getlocal(0).__getattr__("tp").__setattr__("text", s$34);
                }
                else {
                    frame.getlocal(0).__getattr__("tp").__setattr__("text", frame.getlocal(2));
                }
                Py.println(s$35._mod(frame.getlocal(3).__repr__()));
            }
            return Py.None;
        }
        
        private static PyObject go$17(PyFrame frame) {
            frame.getlocal(0).invoke("setLayout", frame.getglobal("BoxLayout").__call__(frame.getlocal(0), frame.getglobal("BoxLayout").__getattr__("Y_AXIS")));
            frame.getlocal(0).__setattr__("tp", frame.getglobal("JTextPane").__call__(new PyObject[] {i$36}, new String[] {"visible"}));
            frame.getlocal(0).__setattr__("Messages", frame.getlocal(1));
            frame.setlocal(2, frame.getglobal("JPanel").__call__());
            frame.getlocal(0).invoke("SW", frame.getlocal(2));
            frame.getlocal(0).invoke("add", frame.getlocal(2));
            frame.getlocal(0).invoke("add", frame.getlocal(0).__getattr__("tp"));
            return Py.None;
        }
        
        private static PyObject MsgView$18(PyFrame frame) {
            frame.setlocal("SW", new PyFunction(frame.f_globals, new PyObject[] {}, c$14_SW));
            frame.setlocal("tableSelectionChanged", new PyFunction(frame.f_globals, new PyObject[] {}, c$15_tableSelectionChanged));
            frame.setlocal("go", new PyFunction(frame.f_globals, new PyObject[] {}, c$16_go));
            return frame.getf_locals();
        }
        
        private static PyObject __init__$19(PyFrame frame) {
            frame.getlocal(0).__setattr__("x", frame.getlocal(1));
            return Py.None;
        }
        
        private static PyObject valueChanged$20(PyFrame frame) {
            if (frame.getlocal(1).invoke("getValueIsAdjusting").__nonzero__()) {
                return Py.None;
            }
            frame.setlocal(2, frame.getlocal(1).invoke("getSource"));
            frame.getlocal(0).__getattr__("x").invoke("tableSelectionChanged", frame.getlocal(2));
            return Py.None;
        }
        
        private static PyObject L$21(PyFrame frame) {
            frame.setlocal("__init__", new PyFunction(frame.f_globals, new PyObject[] {}, c$18___init__));
            frame.setlocal("valueChanged", new PyFunction(frame.f_globals, new PyObject[] {}, c$19_valueChanged));
            return frame.getf_locals();
        }
        
        private static PyObject go$22(PyFrame frame) {
            frame.setlocal(4, frame.getglobal("L").__call__(frame.getlocal(2)));
            frame.setlocal(3, frame.getlocal(0).invoke("getSelectionModel"));
            frame.getlocal(3).invoke("addListSelectionListener", frame.getlocal(4));
            frame.getlocal(0).__setattr__("Messages", frame.getlocal(1));
            return Py.None;
        }
        
        private static PyObject tableSelectionChanged$23(PyFrame frame) {
            if (frame.getlocal(1).invoke("isSelectionEmpty").__nonzero__()) {
                Py.println(s$31);
            }
            else {
                frame.setlocal(2, frame.getlocal(1).invoke("getMinSelectionIndex"));
                Py.printComma(s$32);
                Py.println(frame.getlocal(2));
                Py.printComma(s$37);
                Py.println(frame.getlocal(0).__getattr__("Messages").__getitem__(frame.getlocal(2)).invoke("content"));
                Py.println(s$35._mod(frame.getlocal(2).__repr__()));
            }
            return Py.None;
        }
        
        private static PyObject HeadersView$24(PyFrame frame) {
            frame.setlocal("go", new PyFunction(frame.f_globals, new PyObject[] {}, c$21_go));
            frame.setlocal("tableSelectionChanged", new PyFunction(frame.f_globals, new PyObject[] {}, c$22_tableSelectionChanged));
            return frame.getf_locals();
        }
        
        private static PyObject initColumnSizes$25(PyFrame frame) {
            // Temporary Variables
            int t$0$int;
            PyException t$0$PyException;
            PyObject t$0$PyObject, t$1$PyObject;
            
            // Code
            frame.setlocal(5, frame.getglobal("None"));
            frame.setlocal(8, frame.getglobal("None"));
            frame.setlocal(10, i$10);
            frame.setlocal(4, i$10);
            frame.setlocal(7, frame.getlocal(2).__getattr__("longValues"));
            t$0$int = 0;
            t$1$PyObject = frame.getglobal("range").__call__(frame.getlocal(2).invoke("getColumnCount"));
            while ((t$0$PyObject = t$1$PyObject.__finditem__(t$0$int++)) != null) {
                frame.setlocal(6, t$0$PyObject);
                frame.setlocal(5, frame.getlocal(1).invoke("getColumnModel").invoke("getColumn", frame.getlocal(6)));
                try {
                    frame.setlocal(8, frame.getlocal(5).invoke("getHeaderRenderer").invoke("getTableCellRendererComponent", new PyObject[] {frame.getglobal("None"), frame.getlocal(5).invoke("getHeaderValue"), frame.getglobal("false"), frame.getglobal("false"), i$10, i$10}));
                    frame.setlocal(10, frame.getlocal(8).invoke("getPreferredSize").__getattr__("width"));
                }
                catch (Throwable x$0) {
                    t$0$PyException = Py.setException(x$0, frame);
                    if (Py.matchException(t$0$PyException, new PyTuple(new PyObject[] {frame.getglobal("AttributeError"), frame.getglobal("java").__getattr__("lang").__getattr__("NullPointerException")}))) {
                        frame.setlocal(9, t$0$PyException.value);
                        Py.println(s$38);
                        Py.println(s$39);
                        Py.println(s$40);
                    }
                    else throw t$0$PyException;
                }
                frame.setlocal(3, frame.getlocal(1).invoke("getDefaultRenderer", frame.getlocal(2).invoke("getColumnClass", frame.getlocal(6))));
                frame.setlocal(8, frame.getlocal(3).invoke("getTableCellRendererComponent", new PyObject[] {frame.getlocal(1), frame.getlocal(7).__getitem__(frame.getlocal(6)), frame.getglobal("false"), frame.getglobal("false"), i$10, frame.getlocal(6)}));
                frame.setlocal(4, frame.getlocal(8).invoke("getPreferredSize").__getattr__("width"));
                if (frame.getglobal("DEBUG").__nonzero__()) {
                    Py.println(s$41._add(frame.getlocal(6))._add(s$42)._add(s$43)._add(frame.getlocal(10))._add(s$44)._add(frame.getlocal(4)));
                }
                frame.getlocal(5).__setattr__("preferredWidth", frame.getglobal("java").__getattr__("lang").__getattr__("Math").__getattr__("max").__call__(frame.getlocal(10), frame.getlocal(4)));
            }
            return Py.None;
        }
        
        private static PyObject go$26(PyFrame frame) {
            frame.getlocal(0).__setattr__("visible", i$36);
            frame.getlocal(0).invoke("setMinimumSize", frame.getglobal("Dimension").__call__(i$45, i$46));
            frame.setlocal(3, new PyList(new PyObject[] {}));
            frame.setlocal(4, frame.getglobal("MyTableModel").__call__());
            frame.getlocal(4).__setattr__("root", frame.getglobal("os").__getattr__("getcwd").__call__());
            frame.getlocal(4).invoke("ST", frame.getlocal(3));
            frame.getlocal(0).__setattr__("myModel", frame.getlocal(4));
            frame.setlocal(1, frame.getglobal("MsgView").__call__());
            frame.getlocal(1).invoke("go", frame.getlocal(3));
            frame.setlocal(6, frame.getglobal("HeadersView").__call__(frame.getlocal(4)));
            frame.getlocal(6).invoke("go", frame.getlocal(3), frame.getlocal(1));
            frame.getlocal(6).__setattr__("preferredScrollableViewportSize", frame.getglobal("Dimension").__call__(i$47, i$48));
            frame.getlocal(0).invoke("initColumnSizes", frame.getlocal(6), frame.getlocal(4));
            frame.getlocal(0).__getattr__("contentPane").invoke("setLayout", frame.getglobal("BoxLayout").__call__(frame.getlocal(0).__getattr__("contentPane"), frame.getglobal("BoxLayout").__getattr__("Y_AXIS")));
            frame.getlocal(0).invoke("pack");
            frame.setlocal(5, frame.getglobal("JScrollPane").__call__(frame.getlocal(6)));
            frame.setlocal(2, frame.getglobal("JSplitPane").__call__(new PyObject[] {frame.getglobal("JSplitPane").__getattr__("VERTICAL_SPLIT"), frame.getglobal("false"), frame.getlocal(5), frame.getlocal(1)}));
            frame.getlocal(0).__getattr__("contentPane").invoke("add", frame.getlocal(2));
            return Py.None;
        }
        
        private static PyObject MMSMsgViewFrame$27(PyFrame frame) {
            frame.setlocal("initColumnSizes", new PyFunction(frame.f_globals, new PyObject[] {}, c$24_initColumnSizes));
            frame.setlocal("go", new PyFunction(frame.f_globals, new PyObject[] {}, c$25_go));
            return frame.getf_locals();
        }
        
        private static PyObject lambda$28(PyFrame frame) {
            return frame.getglobal("sys").__getattr__("exit").__call__(i$10);
        }
        
        private static PyObject tell$29(PyFrame frame) {
            Py.println(frame.getlocal(1));
            return Py.None;
        }
        
        private static PyObject UI$30(PyFrame frame) {
            frame.setlocal("tell", new PyFunction(frame.f_globals, new PyObject[] {}, c$28_tell));
            return frame.getf_locals();
        }
        
        private static PyObject strsplit$31(PyFrame frame) {
            frame.setlocal(2, frame.getlocal(0).invoke("rfind", frame.getlocal(1)));
            return new PyTuple(new PyObject[] {frame.getlocal(0).__getslice__(null, frame.getlocal(2), null), frame.getlocal(0).__getslice__(frame.getlocal(2)._add(i$36), null, null)});
        }
        
        private static PyObject _int_checkmail$32(PyFrame frame) {
            // Temporary Variables
            int t$0$int;
            PyObject t$0$PyObject, t$1$PyObject, t$2$PyObject;
            
            // Code
            frame.setlocal(7, new PyFunction(frame.f_globals, new PyObject[] {}, c$30_strsplit));
            frame.setlocal(4, frame.getlocal(0).__getattr__("myDBi").invoke("enum", frame.getlocal(1), frame.getglobal("EnumFlat")));
            t$0$int = 0;
            t$1$PyObject = frame.getlocal(4);
            while ((t$0$PyObject = t$1$PyObject.__finditem__(t$0$int++)) != null) {
                frame.setlocal(6, t$0$PyObject);
                t$2$PyObject = frame.getlocal(7).__call__(frame.getlocal(6).__getattr__("path"), s$49);
                frame.setlocal(5, t$2$PyObject.__getitem__(0));
                frame.setlocal(3, t$2$PyObject.__getitem__(1));
                frame.getlocal(0).__getattr__("myDBi").invoke("setRoot", frame.getlocal(6).__getattr__("path"));
                Py.println(frame.getlocal(3));
            }
            frame.getlocal(0).__getattr__("ui").invoke("tell", s$50);
            return Py.None;
        }
        
        private static PyObject __init__$33(PyFrame frame) {
            frame.getlocal(0).__setattr__("myDBi", frame.getglobal("AwxDBi").__call__());
            frame.getlocal(0).__setattr__("ui", frame.getlocal(2));
            return Py.None;
        }
        
        private static PyObject EE$34(PyFrame frame) {
            frame.setlocal("_int_checkmail", new PyFunction(frame.f_globals, new PyObject[] {}, c$31__int_checkmail));
            frame.setlocal("__init__", new PyFunction(frame.f_globals, new PyObject[] {i$36, frame.getname("None")}, c$32___init__));
            return frame.getf_locals();
        }
        
        private static PyObject main$35(PyFrame frame) {
            frame.setglobal("__file__", s$51);
            
            org.python.core.imp.importAll("DBi.Handle", frame);
            org.python.core.imp.importAll("DBi.Server", frame);
            frame.setlocal("os", org.python.core.imp.importOne("os", frame));
            frame.setlocal("sys", org.python.core.imp.importOne("sys", frame));
            frame.setlocal("java", org.python.core.imp.importOne("java", frame));
            frame.setlocal("DynamicTree", org.python.core.imp.importOne("DynamicTree", frame));
            org.python.core.imp.importAll("java.awt", frame);
            org.python.core.imp.importAll("javax.swing", frame);
            org.python.core.imp.importAll("java.awt.event", frame);
            org.python.core.imp.importAll("javax.swing.event", frame);
            org.python.core.imp.importAll("javax.swing.table", frame);
            frame.setlocal("false", frame.getname("java").__getattr__("lang").__getattr__("Boolean").__getattr__("FALSE"));
            frame.setlocal("true", frame.getname("java").__getattr__("lang").__getattr__("Boolean").__getattr__("TRUE"));
            frame.setlocal("Boolean", frame.getname("java").__getattr__("lang").__getattr__("Boolean"));
            frame.setlocal("Integer", frame.getname("java").__getattr__("lang").__getattr__("Integer"));
            frame.setlocal("ItemListener", frame.getname("java").__getattr__("awt").__getattr__("event").__getattr__("ItemListener"));
            frame.setlocal("DEBUG", frame.getname("false"));
            frame.setlocal("MMSMessage", Py.makeClass("MMSMessage", new PyObject[] {}, c$3_MMSMessage, null));
            frame.setlocal("MyTableModel", Py.makeClass("MyTableModel", new PyObject[] {frame.getname("AbstractTableModel")}, c$13_MyTableModel, null, MyTableModel.class));
            frame.setlocal("MsgView", Py.makeClass("MsgView", new PyObject[] {frame.getname("JPanel")}, c$17_MsgView, null, MsgView.class));
            frame.setlocal("L", Py.makeClass("L", new PyObject[] {frame.getname("ListSelectionListener")}, c$20_L, null, L.class));
            frame.setlocal("HeadersView", Py.makeClass("HeadersView", new PyObject[] {frame.getname("JTable")}, c$23_HeadersView, null, HeadersView.class));
            frame.setlocal("MMSMsgViewFrame", Py.makeClass("MMSMsgViewFrame", new PyObject[] {frame.getname("JFrame"), frame.getname("ItemListener")}, c$26_MMSMsgViewFrame, null, MMSMsgViewFrame.class));
            frame.setlocal("cw", frame.getname("MMSMsgViewFrame").__call__(new PyObject[] {new PyFunction(frame.f_globals, new PyObject[] {}, c$27_lambda)}, new String[] {"windowClosing"}));
            frame.getname("cw").invoke("go");
            frame.setlocal("UI", Py.makeClass("UI", new PyObject[] {}, c$29_UI, null));
            frame.setlocal("EE", Py.makeClass("EE", new PyObject[] {}, c$33_EE, null));
            return Py.None;
        }
        
    }
    public static class L extends java.lang.Object implements javax.swing.event.ListSelectionListener, org.python.core.PyProxy, org.python.core.ClassDictInit {
        public void valueChanged(javax.swing.event.ListSelectionEvent arg0) {
            PyObject inst = Py.jgetattr(this, "valueChanged");
            inst._jcall(new Object[] {arg0});
        }
        
        public L() {
            super();
            __initProxy__(new Object[] {});
        }
        
        private PyInstance __proxy;
        public void _setPyInstance(PyInstance inst) {
            __proxy = inst;
        }
        
        public PyInstance _getPyInstance() {
            return __proxy;
        }
        
        private PySystemState __sysstate;
        public void _setPySystemState(PySystemState inst) {
            __sysstate = inst;
        }
        
        public PySystemState _getPySystemState() {
            return __sysstate;
        }
        
        public void __initProxy__(Object[] args) {
            Py.initProxy(this, "mail98.MMS", "L", args, jpy$packages, jpy$properties, "mail98", new String[] {"DBi.Server", "etoffiutils", "DBi.Handle", "javapath", "MMS", "traceback", "stat", "string", "linecache", "DBi.__init__", "javaos", "rfc822"});
        }
        
        static public void classDictInit(PyObject dict) {
            dict.__setitem__("__supernames__", Py.java2py(new String[] {}));
        }
        
    }
    public static class HeadersView extends javax.swing.JTable implements org.python.core.PyProxy, org.python.core.ClassDictInit {
        public void addImpl(java.awt.Component arg0, java.lang.Object arg1, int arg2) {
            super.addImpl(arg0, arg1, arg2);
        }
        
        public java.lang.Object clone() throws java.lang.CloneNotSupportedException {
            return super.clone();
        }
        
        public java.awt.AWTEvent coalesceEvents(java.awt.AWTEvent arg0, java.awt.AWTEvent arg1) {
            return super.coalesceEvents(arg0, arg1);
        }
        
        public void configureEnclosingScrollPane() {
            super.configureEnclosingScrollPane();
        }
        
        public javax.swing.table.TableColumnModel createDefaultColumnModel() {
            return super.createDefaultColumnModel();
        }
        
        public javax.swing.table.TableModel createDefaultDataModel() {
            return super.createDefaultDataModel();
        }
        
        public void createDefaultEditors() {
            super.createDefaultEditors();
        }
        
        public void createDefaultRenderers() {
            super.createDefaultRenderers();
        }
        
        public javax.swing.ListSelectionModel createDefaultSelectionModel() {
            return super.createDefaultSelectionModel();
        }
        
        public javax.swing.table.JTableHeader createDefaultTableHeader() {
            return super.createDefaultTableHeader();
        }
        
        public void super__disableEvents(long arg0) {
            super.disableEvents(arg0);
        }
        
        public void super__enableEvents(long arg0) {
            super.enableEvents(arg0);
        }
        
        public void finalize() throws java.lang.Throwable {
            super.finalize();
        }
        
        public void firePropertyChange(java.lang.String arg0, java.lang.Object arg1, java.lang.Object arg2) {
            super.firePropertyChange(arg0, arg1, arg2);
        }
        
        public void fireVetoableChange(java.lang.String arg0, java.lang.Object arg1, java.lang.Object arg2) throws java.beans.PropertyVetoException {
            super.fireVetoableChange(arg0, arg1, arg2);
        }
        
        public java.awt.Graphics getComponentGraphics(java.awt.Graphics arg0) {
            return super.getComponentGraphics(arg0);
        }
        
        public void initializeLocalVars() {
            super.initializeLocalVars();
        }
        
        public void paintBorder(java.awt.Graphics arg0) {
            super.paintBorder(arg0);
        }
        
        public void paintChildren(java.awt.Graphics arg0) {
            super.paintChildren(arg0);
        }
        
        public void paintComponent(java.awt.Graphics arg0) {
            super.paintComponent(arg0);
        }
        
        public java.lang.String paramString() {
            return super.paramString();
        }
        
        public void printBorder(java.awt.Graphics arg0) {
            super.printBorder(arg0);
        }
        
        public void printChildren(java.awt.Graphics arg0) {
            super.printChildren(arg0);
        }
        
        public void printComponent(java.awt.Graphics arg0) {
            super.printComponent(arg0);
        }
        
        public void processComponentEvent(java.awt.event.ComponentEvent arg0) {
            super.processComponentEvent(arg0);
        }
        
        public void processComponentKeyEvent(java.awt.event.KeyEvent arg0) {
            super.processComponentKeyEvent(arg0);
        }
        
        public void processContainerEvent(java.awt.event.ContainerEvent arg0) {
            super.processContainerEvent(arg0);
        }
        
        public void processEvent(java.awt.AWTEvent arg0) {
            super.processEvent(arg0);
        }
        
        public void processFocusEvent(java.awt.event.FocusEvent arg0) {
            super.processFocusEvent(arg0);
        }
        
        public void processHierarchyBoundsEvent(java.awt.event.HierarchyEvent arg0) {
            super.processHierarchyBoundsEvent(arg0);
        }
        
        public void processHierarchyEvent(java.awt.event.HierarchyEvent arg0) {
            super.processHierarchyEvent(arg0);
        }
        
        public void processInputMethodEvent(java.awt.event.InputMethodEvent arg0) {
            super.processInputMethodEvent(arg0);
        }
        
        public boolean processKeyBinding(javax.swing.KeyStroke arg0, java.awt.event.KeyEvent arg1, int arg2, boolean arg3) {
            return super.processKeyBinding(arg0, arg1, arg2, arg3);
        }
        
        public void processKeyEvent(java.awt.event.KeyEvent arg0) {
            super.processKeyEvent(arg0);
        }
        
        public void processMouseEvent(java.awt.event.MouseEvent arg0) {
            super.processMouseEvent(arg0);
        }
        
        public void processMouseMotionEvent(java.awt.event.MouseEvent arg0) {
            super.processMouseMotionEvent(arg0);
        }
        
        public void processMouseWheelEvent(java.awt.event.MouseWheelEvent arg0) {
            super.processMouseWheelEvent(arg0);
        }
        
        public boolean requestFocusInWindow(boolean arg0) {
            return super.requestFocusInWindow(arg0);
        }
        
        public void resizeAndRepaint() {
            super.resizeAndRepaint();
        }
        
        public void setUI(javax.swing.plaf.ComponentUI arg0) {
            super.setUI(arg0);
        }
        
        public void unconfigureEnclosingScrollPane() {
            super.unconfigureEnclosingScrollPane();
        }
        
        public void validateTree() {
            super.validateTree();
        }
        
        public HeadersView() {
            super();
            __initProxy__(new Object[] {});
        }
        
        public HeadersView(javax.swing.table.TableModel arg0) {
            super(arg0);
            __initProxy__(new Object[] {arg0});
        }
        
        public HeadersView(javax.swing.table.TableModel arg0, javax.swing.table.TableColumnModel arg1) {
            super(arg0, arg1);
            __initProxy__(new Object[] {arg0, arg1});
        }
        
        public HeadersView(javax.swing.table.TableModel arg0, javax.swing.table.TableColumnModel arg1, javax.swing.ListSelectionModel arg2) {
            super(arg0, arg1, arg2);
            __initProxy__(new Object[] {arg0, arg1, arg2});
        }
        
        public HeadersView(int arg0, int arg1) {
            super(arg0, arg1);
            __initProxy__(new Object[] {Py.newInteger(arg0), Py.newInteger(arg1)});
        }
        
        public HeadersView(java.util.Vector arg0, java.util.Vector arg1) {
            super(arg0, arg1);
            __initProxy__(new Object[] {arg0, arg1});
        }
        
        public HeadersView(java.lang.Object[][] arg0, java.lang.Object[] arg1) {
            super(arg0, arg1);
            __initProxy__(new Object[] {arg0, arg1});
        }
        
        private PyInstance __proxy;
        public void _setPyInstance(PyInstance inst) {
            __proxy = inst;
        }
        
        public PyInstance _getPyInstance() {
            return __proxy;
        }
        
        private PySystemState __sysstate;
        public void _setPySystemState(PySystemState inst) {
            __sysstate = inst;
        }
        
        public PySystemState _getPySystemState() {
            return __sysstate;
        }
        
        public void __initProxy__(Object[] args) {
            Py.initProxy(this, "mail98.MMS", "HeadersView", args, jpy$packages, jpy$properties, "mail98", new String[] {"DBi.Server", "etoffiutils", "DBi.Handle", "javapath", "MMS", "traceback", "stat", "string", "linecache", "DBi.__init__", "javaos", "rfc822"});
        }
        
        static public void classDictInit(PyObject dict) {
            dict.__setitem__("__supernames__", Py.java2py(new String[] {"setUI", "processInputMethodEvent", "resizeAndRepaint", "processHierarchyEvent", "processKeyEvent", "unconfigureEnclosingScrollPane", "addImpl", "processHierarchyBoundsEvent", "processKeyBinding", "getComponentGraphics", "firePropertyChange", "createDefaultEditors", "createDefaultTableHeader", "paramString", "processMouseWheelEvent", "fireVetoableChange", "coalesceEvents", "clone", "paintBorder", "processMouseEvent", "printComponent", "super__enableEvents", "processEvent", "validateTree", "processComponentKeyEvent", "paintComponent", "createDefaultColumnModel", "paintChildren", "processContainerEvent", "createDefaultSelectionModel", "finalize", "configureEnclosingScrollPane", "super__disableEvents", "createDefaultDataModel", "processComponentEvent", "processFocusEvent", "createDefaultRenderers", "printChildren", "requestFocusInWindow", "printBorder", "initializeLocalVars", "processMouseMotionEvent"}));
        }
        
    }
    public static class MMSMsgViewFrame extends javax.swing.JFrame implements org.python.core.PyProxy, org.python.core.ClassDictInit {
        public void addImpl(java.awt.Component arg0, java.lang.Object arg1, int arg2) {
            super.addImpl(arg0, arg1, arg2);
        }
        
        public java.lang.Object clone() throws java.lang.CloneNotSupportedException {
            return super.clone();
        }
        
        public java.awt.AWTEvent coalesceEvents(java.awt.AWTEvent arg0, java.awt.AWTEvent arg1) {
            return super.coalesceEvents(arg0, arg1);
        }
        
        public javax.swing.JRootPane createRootPane() {
            return super.createRootPane();
        }
        
        public void super__disableEvents(long arg0) {
            super.disableEvents(arg0);
        }
        
        public void super__enableEvents(long arg0) {
            super.enableEvents(arg0);
        }
        
        public void finalize() throws java.lang.Throwable {
            super.finalize();
        }
        
        public void firePropertyChange(java.lang.String arg0, java.lang.Object arg1, java.lang.Object arg2) {
            super.firePropertyChange(arg0, arg1, arg2);
        }
        
        public void firePropertyChange(java.lang.String arg0, boolean arg1, boolean arg2) {
            super.firePropertyChange(arg0, arg1, arg2);
        }
        
        public void firePropertyChange(java.lang.String arg0, int arg1, int arg2) {
            super.firePropertyChange(arg0, arg1, arg2);
        }
        
        public void frameInit() {
            super.frameInit();
        }
        
        public boolean isRootPaneCheckingEnabled() {
            return super.isRootPaneCheckingEnabled();
        }
        
        public java.lang.String paramString() {
            return super.paramString();
        }
        
        public void processComponentEvent(java.awt.event.ComponentEvent arg0) {
            super.processComponentEvent(arg0);
        }
        
        public void processContainerEvent(java.awt.event.ContainerEvent arg0) {
            super.processContainerEvent(arg0);
        }
        
        public void processEvent(java.awt.AWTEvent arg0) {
            super.processEvent(arg0);
        }
        
        public void processFocusEvent(java.awt.event.FocusEvent arg0) {
            super.processFocusEvent(arg0);
        }
        
        public void processHierarchyBoundsEvent(java.awt.event.HierarchyEvent arg0) {
            super.processHierarchyBoundsEvent(arg0);
        }
        
        public void processHierarchyEvent(java.awt.event.HierarchyEvent arg0) {
            super.processHierarchyEvent(arg0);
        }
        
        public void processInputMethodEvent(java.awt.event.InputMethodEvent arg0) {
            super.processInputMethodEvent(arg0);
        }
        
        public void processKeyEvent(java.awt.event.KeyEvent arg0) {
            super.processKeyEvent(arg0);
        }
        
        public void processMouseEvent(java.awt.event.MouseEvent arg0) {
            super.processMouseEvent(arg0);
        }
        
        public void processMouseMotionEvent(java.awt.event.MouseEvent arg0) {
            super.processMouseMotionEvent(arg0);
        }
        
        public void processMouseWheelEvent(java.awt.event.MouseWheelEvent arg0) {
            super.processMouseWheelEvent(arg0);
        }
        
        public void processWindowEvent(java.awt.event.WindowEvent arg0) {
            super.processWindowEvent(arg0);
        }
        
        public void processWindowFocusEvent(java.awt.event.WindowEvent arg0) {
            super.processWindowFocusEvent(arg0);
        }
        
        public void processWindowStateEvent(java.awt.event.WindowEvent arg0) {
            super.processWindowStateEvent(arg0);
        }
        
        public boolean requestFocus(boolean arg0) {
            return super.requestFocus(arg0);
        }
        
        public boolean requestFocusInWindow(boolean arg0) {
            return super.requestFocusInWindow(arg0);
        }
        
        public void setRootPane(javax.swing.JRootPane arg0) {
            super.setRootPane(arg0);
        }
        
        public void setRootPaneCheckingEnabled(boolean arg0) {
            super.setRootPaneCheckingEnabled(arg0);
        }
        
        public void validateTree() {
            super.validateTree();
        }
        
        public MMSMsgViewFrame() throws java.awt.HeadlessException {
            super();
            __initProxy__(new Object[] {});
        }
        
        public MMSMsgViewFrame(java.awt.GraphicsConfiguration arg0) {
            super(arg0);
            __initProxy__(new Object[] {arg0});
        }
        
        public MMSMsgViewFrame(java.lang.String arg0) throws java.awt.HeadlessException {
            super(arg0);
            __initProxy__(new Object[] {arg0});
        }
        
        public MMSMsgViewFrame(java.lang.String arg0, java.awt.GraphicsConfiguration arg1) {
            super(arg0, arg1);
            __initProxy__(new Object[] {arg0, arg1});
        }
        
        private PyInstance __proxy;
        public void _setPyInstance(PyInstance inst) {
            __proxy = inst;
        }
        
        public PyInstance _getPyInstance() {
            return __proxy;
        }
        
        private PySystemState __sysstate;
        public void _setPySystemState(PySystemState inst) {
            __sysstate = inst;
        }
        
        public PySystemState _getPySystemState() {
            return __sysstate;
        }
        
        public void __initProxy__(Object[] args) {
            Py.initProxy(this, "mail98.MMS", "MMSMsgViewFrame", args, jpy$packages, jpy$properties, "mail98", new String[] {"DBi.Server", "etoffiutils", "DBi.Handle", "javapath", "MMS", "traceback", "stat", "string", "linecache", "DBi.__init__", "javaos", "rfc822"});
        }
        
        static public void classDictInit(PyObject dict) {
            dict.__setitem__("__supernames__", Py.java2py(new String[] {"processInputMethodEvent", "finalize", "requestFocus", "firePropertyChange", "setRootPaneCheckingEnabled", "processMouseWheelEvent", "processWindowEvent", "processEvent", "processComponentEvent", "processWindowStateEvent", "paramString", "coalesceEvents", "requestFocusInWindow", "super__disableEvents", "super__enableEvents", "processMouseEvent", "processKeyEvent", "addImpl", "validateTree", "processWindowFocusEvent", "processHierarchyBoundsEvent", "processMouseMotionEvent", "clone", "processContainerEvent", "processFocusEvent", "createRootPane", "frameInit", "processHierarchyEvent", "setRootPane", "isRootPaneCheckingEnabled"}));
        }
        
    }
    public static class MsgView extends javax.swing.JPanel implements org.python.core.PyProxy, org.python.core.ClassDictInit {
        public void addImpl(java.awt.Component arg0, java.lang.Object arg1, int arg2) {
            super.addImpl(arg0, arg1, arg2);
        }
        
        public java.lang.Object clone() throws java.lang.CloneNotSupportedException {
            return super.clone();
        }
        
        public java.awt.AWTEvent coalesceEvents(java.awt.AWTEvent arg0, java.awt.AWTEvent arg1) {
            return super.coalesceEvents(arg0, arg1);
        }
        
        public void super__disableEvents(long arg0) {
            super.disableEvents(arg0);
        }
        
        public void super__enableEvents(long arg0) {
            super.enableEvents(arg0);
        }
        
        public void finalize() throws java.lang.Throwable {
            super.finalize();
        }
        
        public void firePropertyChange(java.lang.String arg0, java.lang.Object arg1, java.lang.Object arg2) {
            super.firePropertyChange(arg0, arg1, arg2);
        }
        
        public void fireVetoableChange(java.lang.String arg0, java.lang.Object arg1, java.lang.Object arg2) throws java.beans.PropertyVetoException {
            super.fireVetoableChange(arg0, arg1, arg2);
        }
        
        public java.awt.Graphics getComponentGraphics(java.awt.Graphics arg0) {
            return super.getComponentGraphics(arg0);
        }
        
        public void paintBorder(java.awt.Graphics arg0) {
            super.paintBorder(arg0);
        }
        
        public void paintChildren(java.awt.Graphics arg0) {
            super.paintChildren(arg0);
        }
        
        public void paintComponent(java.awt.Graphics arg0) {
            super.paintComponent(arg0);
        }
        
        public java.lang.String paramString() {
            return super.paramString();
        }
        
        public void printBorder(java.awt.Graphics arg0) {
            super.printBorder(arg0);
        }
        
        public void printChildren(java.awt.Graphics arg0) {
            super.printChildren(arg0);
        }
        
        public void printComponent(java.awt.Graphics arg0) {
            super.printComponent(arg0);
        }
        
        public void processComponentEvent(java.awt.event.ComponentEvent arg0) {
            super.processComponentEvent(arg0);
        }
        
        public void processComponentKeyEvent(java.awt.event.KeyEvent arg0) {
            super.processComponentKeyEvent(arg0);
        }
        
        public void processContainerEvent(java.awt.event.ContainerEvent arg0) {
            super.processContainerEvent(arg0);
        }
        
        public void processEvent(java.awt.AWTEvent arg0) {
            super.processEvent(arg0);
        }
        
        public void processFocusEvent(java.awt.event.FocusEvent arg0) {
            super.processFocusEvent(arg0);
        }
        
        public void processHierarchyBoundsEvent(java.awt.event.HierarchyEvent arg0) {
            super.processHierarchyBoundsEvent(arg0);
        }
        
        public void processHierarchyEvent(java.awt.event.HierarchyEvent arg0) {
            super.processHierarchyEvent(arg0);
        }
        
        public void processInputMethodEvent(java.awt.event.InputMethodEvent arg0) {
            super.processInputMethodEvent(arg0);
        }
        
        public boolean processKeyBinding(javax.swing.KeyStroke arg0, java.awt.event.KeyEvent arg1, int arg2, boolean arg3) {
            return super.processKeyBinding(arg0, arg1, arg2, arg3);
        }
        
        public void processKeyEvent(java.awt.event.KeyEvent arg0) {
            super.processKeyEvent(arg0);
        }
        
        public void processMouseEvent(java.awt.event.MouseEvent arg0) {
            super.processMouseEvent(arg0);
        }
        
        public void processMouseMotionEvent(java.awt.event.MouseEvent arg0) {
            super.processMouseMotionEvent(arg0);
        }
        
        public void processMouseWheelEvent(java.awt.event.MouseWheelEvent arg0) {
            super.processMouseWheelEvent(arg0);
        }
        
        public boolean requestFocusInWindow(boolean arg0) {
            return super.requestFocusInWindow(arg0);
        }
        
        public void setUI(javax.swing.plaf.ComponentUI arg0) {
            super.setUI(arg0);
        }
        
        public void validateTree() {
            super.validateTree();
        }
        
        public MsgView(java.awt.LayoutManager arg0, boolean arg1) {
            super(arg0, arg1);
            __initProxy__(new Object[] {arg0, Py.newBoolean(arg1)});
        }
        
        public MsgView(java.awt.LayoutManager arg0) {
            super(arg0);
            __initProxy__(new Object[] {arg0});
        }
        
        public MsgView(boolean arg0) {
            super(arg0);
            __initProxy__(new Object[] {Py.newBoolean(arg0)});
        }
        
        public MsgView() {
            super();
            __initProxy__(new Object[] {});
        }
        
        private PyInstance __proxy;
        public void _setPyInstance(PyInstance inst) {
            __proxy = inst;
        }
        
        public PyInstance _getPyInstance() {
            return __proxy;
        }
        
        private PySystemState __sysstate;
        public void _setPySystemState(PySystemState inst) {
            __sysstate = inst;
        }
        
        public PySystemState _getPySystemState() {
            return __sysstate;
        }
        
        public void __initProxy__(Object[] args) {
            Py.initProxy(this, "mail98.MMS", "MsgView", args, jpy$packages, jpy$properties, "mail98", new String[] {"DBi.Server", "etoffiutils", "DBi.Handle", "javapath", "MMS", "traceback", "stat", "string", "linecache", "DBi.__init__", "javaos", "rfc822"});
        }
        
        static public void classDictInit(PyObject dict) {
            dict.__setitem__("__supernames__", Py.java2py(new String[] {"fireVetoableChange", "processInputMethodEvent", "finalize", "paintComponent", "firePropertyChange", "processMouseWheelEvent", "printBorder", "processEvent", "paintBorder", "processComponentEvent", "paintChildren", "paramString", "coalesceEvents", "processComponentKeyEvent", "requestFocusInWindow", "super__disableEvents", "super__enableEvents", "setUI", "processMouseEvent", "processKeyEvent", "printComponent", "addImpl", "printChildren", "validateTree", "processKeyBinding", "processHierarchyBoundsEvent", "getComponentGraphics", "processMouseMotionEvent", "processFocusEvent", "processContainerEvent", "clone", "processHierarchyEvent"}));
        }
        
    }
    public static class MyTableModel extends javax.swing.table.AbstractTableModel implements org.python.core.PyProxy, org.python.core.ClassDictInit {
        public java.lang.Object clone() throws java.lang.CloneNotSupportedException {
            return super.clone();
        }
        
        public void finalize() throws java.lang.Throwable {
            super.finalize();
        }
        
        public java.lang.Class super__getColumnClass(int arg0) {
            return super.getColumnClass(arg0);
        }
        
        public java.lang.Class getColumnClass(int arg0) {
            PyObject inst = Py.jfindattr(this, "getColumnClass");
            if (inst != null) return (java.lang.Class)Py.tojava(inst._jcall(new Object[] {Py.newInteger(arg0)}), "java.lang.Class");
            else return super.getColumnClass(arg0);
        }
        
        public int getColumnCount() {
            PyObject inst = Py.jgetattr(this, "getColumnCount");
            return Py.py2int(inst._jcall(new Object[] {}));
        }
        
        public java.lang.String super__getColumnName(int arg0) {
            return super.getColumnName(arg0);
        }
        
        public java.lang.String getColumnName(int arg0) {
            PyObject inst = Py.jfindattr(this, "getColumnName");
            if (inst != null) return (java.lang.String)Py.tojava(inst._jcall(new Object[] {Py.newInteger(arg0)}), "java.lang.String");
            else return super.getColumnName(arg0);
        }
        
        public int getRowCount() {
            PyObject inst = Py.jgetattr(this, "getRowCount");
            return Py.py2int(inst._jcall(new Object[] {}));
        }
        
        public java.lang.Object getValueAt(int arg0, int arg1) {
            PyObject inst = Py.jgetattr(this, "getValueAt");
            return (java.lang.Object)Py.tojava(inst._jcall(new Object[] {Py.newInteger(arg0), Py.newInteger(arg1)}), "java.lang.Object");
        }
        
        public boolean super__isCellEditable(int arg0, int arg1) {
            return super.isCellEditable(arg0, arg1);
        }
        
        public boolean isCellEditable(int arg0, int arg1) {
            PyObject inst = Py.jfindattr(this, "isCellEditable");
            if (inst != null) return Py.py2boolean(inst._jcall(new Object[] {Py.newInteger(arg0), Py.newInteger(arg1)}));
            else return super.isCellEditable(arg0, arg1);
        }
        
        public void super__setValueAt(java.lang.Object arg0, int arg1, int arg2) {
            super.setValueAt(arg0, arg1, arg2);
        }
        
        public void setValueAt(java.lang.Object arg0, int arg1, int arg2) {
            PyObject inst = Py.jfindattr(this, "setValueAt");
            if (inst != null) inst._jcall(new Object[] {arg0, Py.newInteger(arg1), Py.newInteger(arg2)});
            else super.setValueAt(arg0, arg1, arg2);
        }
        
        public MyTableModel() {
            super();
            __initProxy__(new Object[] {});
        }
        
        private PyInstance __proxy;
        public void _setPyInstance(PyInstance inst) {
            __proxy = inst;
        }
        
        public PyInstance _getPyInstance() {
            return __proxy;
        }
        
        private PySystemState __sysstate;
        public void _setPySystemState(PySystemState inst) {
            __sysstate = inst;
        }
        
        public PySystemState _getPySystemState() {
            return __sysstate;
        }
        
        public void __initProxy__(Object[] args) {
            Py.initProxy(this, "mail98.MMS", "MyTableModel", args, jpy$packages, jpy$properties, "mail98", new String[] {"DBi.Server", "etoffiutils", "DBi.Handle", "javapath", "MMS", "traceback", "stat", "string", "linecache", "DBi.__init__", "javaos", "rfc822"});
        }
        
        static public void classDictInit(PyObject dict) {
            dict.__setitem__("__supernames__", Py.java2py(new String[] {"super__isCellEditable", "super__setValueAt", "super__getColumnName", "super__getColumnClass", "finalize", "clone"}));
        }
        
    }
    public static void moduleDictInit(PyObject dict) {
        dict.__setitem__("__name__", new PyString("MMS"));
        Py.runCode(new _PyInner().getMain(), dict, dict);
    }
    
    public static void main(String[] args) {
        String[] newargs = new String[args.length+1];
        newargs[0] = "MMS";
        System.arraycopy(args, 0, newargs, 1, args.length);
        Py.runMain("mail98.MMS$_PyInner", newargs, jpy$packages, jpy$properties, "mail98", new String[] {"DBi.Server", "etoffiutils", "DBi.Handle", "javapath", "MMS", "traceback", "stat", "string", "linecache", "DBi.__init__", "javaos", "rfc822"});
    }
    
}
