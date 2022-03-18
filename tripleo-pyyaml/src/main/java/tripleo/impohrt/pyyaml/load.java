package tripleo.impohrt.pyyaml;

import org.python.core.*;

public class load extends java.lang.Object {
    static String[] jpy$properties = new String[] {"python.modules.builtin", "exceptions:org.python.core.exceptions", "python.options.showJavaExceptions", "true"};
    static String[] jpy$packages = new String[] {"org.python.core", null, "java.lang", null, "java.io", null, "java.net", null};
    
    public static class _PyInner extends PyFunctionTable implements PyRunnable {
        private static PyObject s$0;
        private static PyObject i$1;
        private static PyObject i$2;
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
        private static PyObject s$13;
        private static PyObject s$14;
        private static PyObject i$15;
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
        private static PyObject s$26;
        private static PyObject s$27;
        private static PyObject s$28;
        private static PyObject s$29;
        private static PyObject s$30;
        private static PyObject s$31;
        private static PyObject s$32;
        private static PyObject s$33;
        private static PyObject s$34;
        private static PyObject s$35;
        private static PyObject s$36;
        private static PyObject s$37;
        private static PyObject s$38;
        private static PyFunctionTable funcTable;
        private static PyCode c$0___init__;
        private static PyCode c$1___iter__;
        private static PyCode c$2_next;
        private static PyCode c$3_loadIterator;
        private static PyCode c$4_StopIteration;
        private static PyCode c$5_iter;
        private static PyCode c$6___init__;
        private static PyCode c$7___len__;
        private static PyCode c$8___getitem__;
        private static PyCode c$9_next;
        private static PyCode c$10_loadIterator;
        private static PyCode c$11_loadFile;
public static PyCode c$12_load;
        private static PyCode c$13_loadStream;
        private static PyCode c$14_tryProductions;
        private static PyCode c$15___init__;
        private static PyCode c$16_error;
        private static PyCode c$17_nestPop;
        private static PyCode c$18_value;
        private static PyCode c$19_getNextDocument;
        private static PyCode c$20_parseLines;
        private static PyCode c$21_parse_collection;
        private static PyCode c$22_parse_seq_line;
        private static PyCode c$23_parse_map_line;
        private static PyCode c$24_parse_map_line_nested;
        private static PyCode c$25_parse_map_line_simple;
        private static PyCode c$26_is_map;
        private static PyCode c$27_parse_seq_value;
        private static PyCode c$28_parse_compressed_map;
        private static PyCode c$29_parse_value;
        private static PyCode c$30_parse_unaliased_value;
        private static PyCode c$31_parseInlineArray;
        private static PyCode c$32_parseInlineHash;
        private static PyCode c$33_parseInlineArrayItem;
        private static PyCode c$34_parseInlineHashItem;
        private static PyCode c$35_parseInline;
        private static PyCode c$36_parseSpecial;
        private static PyCode c$37_parse_untyped_value;
        private static PyCode c$38_parseNative;
        private static PyCode c$39_parseMultiLineScalar;
        private static PyCode c$40_parseFolded;
        private static PyCode c$41_parseLiteral;
        private static PyCode c$42_parseBlock;
        private static PyCode c$43_testForAlias;
        private static PyCode c$44_testForRepeatOfAlias;
        private static PyCode c$45_Parser;
        private static PyCode c$46_getToken;
        private static PyCode c$47_key_value;
        private static PyCode c$48_pruneTrailingEmpties;
        private static PyCode c$49_foldChar;
        private static PyCode c$50_getIndicator;
        private static PyCode c$51_joinLines;
        private static PyCode c$52_main;
	    public static final String yaml_load_dot_py = "/local/src/i/Rabbit3/runtime/py-lib/yaml/load.py";

	    private static void initConstants() {
            s$0 = Py.newString("\012  This module is considered to be private implementation\012  details and is subject to change.  Please only use the\012  objects and methods exported to the top level yaml package.\012");
            i$1 = Py.newInteger(1);
            i$2 = Py.newInteger(0);
            s$3 = Py.newString("\\s*(.*)");
            s$4 = Py.newString("\\s*-");
            s$5 = Py.newString("-");
            s$6 = Py.newString("missing '-' for seq");
            s$7 = Py.newString("?");
            s$8 = Py.newString(":");
            s$9 = Py.newString("key has no value for nested map");
            s$10 = Py.newString("bad key for map");
            s$11 = Py.newString("'");
            s$12 = Py.newString(":(\\s|$)");
            s$13 = Py.newString("(\\s*-\\s*)");
            s$14 = Py.newString("(!\\S*)(.*)");
            i$15 = Py.newInteger(2);
            s$16 = Py.newString("!!");
            s$17 = Py.newString("\\s*\\[");
            s$18 = Py.newString("]");
            s$19 = Py.newString("\\s*{");
            s$20 = Py.newString("}");
            s$21 = Py.newString("(\\S.*)");
            s$22 = Py.newString(">");
            s$23 = Py.newString("|");
            s$24 = Py.newString("");
            s$25 = Py.newString("\012");
            s$26 = Py.newString("&(\\S*)\\s*(.*)");
            s$27 = Py.newString("\\*(\\S*)");
            s$28 = Py.newString("Unknown alias");
            s$29 = Py.newString("[\"'](.+)[\"']\\s*:\\s*(.*)");
            s$30 = Py.newString("(.+?)\\s*:\\s*(.*)");
            s$31 = Py.newString("#");
            s$32 = Py.newString("^\\S");
            s$33 = Py.newString(" ");
            s$34 = Py.newString("(#YAML:\\d+\\.\\d+\\s*){0,1}");
            s$35 = Py.newString("--- ");
            s$36 = Py.newString("(\\S*.*)");
            s$37 = Py.newString("\\");
            s$38 = Py.newString(yaml_load_dot_py);
            funcTable = new _PyInner();
            c$0___init__ = Py.newCode(2, new String[] {"self", "parser"}, yaml_load_dot_py, "__init__", false, false, funcTable, 0, null, null, 0, 1);
            c$1___iter__ = Py.newCode(1, new String[] {"self"}, yaml_load_dot_py, "__iter__", false, false, funcTable, 1, null, null, 0, 1);
            c$2_next = Py.newCode(1, new String[] {"self"}, yaml_load_dot_py, "next", false, false, funcTable, 2, null, null, 0, 1);
            c$3_loadIterator = Py.newCode(0, new String[] {}, yaml_load_dot_py, "loadIterator", false, false, funcTable, 3, null, null, 0, 0);
            c$4_StopIteration = Py.newCode(0, new String[] {}, yaml_load_dot_py, "StopIteration", false, false, funcTable, 4, null, null, 0, 0);
            c$5_iter = Py.newCode(1, new String[] {"x"}, yaml_load_dot_py, "iter", false, false, funcTable, 5, null, null, 0, 1);
            c$6___init__ = Py.newCode(2, new String[] {"self", "parser"}, yaml_load_dot_py, "__init__", false, false, funcTable, 6, null, null, 0, 1);
            c$7___len__ = Py.newCode(1, new String[] {"self"}, yaml_load_dot_py, "__len__", false, false, funcTable, 7, null, null, 0, 1);
            c$8___getitem__ = Py.newCode(2, new String[] {"self", "idx"}, yaml_load_dot_py, "__getitem__", false, false, funcTable, 8, null, null, 0, 1);
            c$9_next = Py.newCode(1, new String[] {"self", "ret"}, yaml_load_dot_py, "next", false, false, funcTable, 9, null, null, 0, 1);
            c$10_loadIterator = Py.newCode(0, new String[] {}, yaml_load_dot_py, "loadIterator", false, false, funcTable, 10, null, null, 0, 0);
            c$11_loadFile = Py.newCode(2, new String[] {"filename", "typeResolver"}, yaml_load_dot_py, "loadFile", false, false, funcTable, 11, null, null, 0, 1);
            c$12_load = Py.newCode(2, new String[] {"str", "typeResolver"}, yaml_load_dot_py, "load", false, false, funcTable, 12, null, null, 0, 1);
            c$13_loadStream = Py.newCode(2, new String[] {"stream", "typeResolver"}, yaml_load_dot_py, "loadStream", false, false, funcTable, 13, null, null, 0, 1);
            c$14_tryProductions = Py.newCode(2, new String[] {"productions", "value", "result", "ok", "results", "production"}, yaml_load_dot_py, "tryProductions", false, false, funcTable, 14, null, null, 0, 1);
            c$15___init__ = Py.newCode(3, new String[] {"self", "stream", "typeResolver"}, yaml_load_dot_py, "__init__", false, false, funcTable, 15, null, null, 0, 1);
            c$16_error = Py.newCode(2, new String[] {"self", "msg"}, yaml_load_dot_py, "error", false, false, funcTable, 16, null, null, 0, 1);
            c$17_nestPop = Py.newCode(1, new String[] {"self", "line"}, yaml_load_dot_py, "nestPop", false, false, funcTable, 17, null, null, 0, 1);
            c$18_value = Py.newCode(2, new String[] {"self", "indicator"}, yaml_load_dot_py, "value", false, false, funcTable, 18, null, null, 0, 1);
            c$19_getNextDocument = Py.newCode(1, new String[] {"self", "indicator", "line"}, yaml_load_dot_py, "getNextDocument", false, false, funcTable, 19, null, null, 0, 1);
            c$20_parseLines = Py.newCode(1, new String[] {"self", "peekLine"}, yaml_load_dot_py, "parseLines", false, false, funcTable, 20, null, null, 0, 1);
            c$21_parse_collection = Py.newCode(3, new String[] {"self", "items", "lineParser"}, yaml_load_dot_py, "parse_collection", false, false, funcTable, 21, null, null, 0, 1);
            c$22_parse_seq_line = Py.newCode(2, new String[] {"self", "items", "value"}, yaml_load_dot_py, "parse_seq_line", false, false, funcTable, 22, null, null, 0, 1);
            c$23_parse_map_line = Py.newCode(2, new String[] {"self", "items"}, yaml_load_dot_py, "parse_map_line", false, false, funcTable, 23, null, null, 0, 1);
            c$24_parse_map_line_nested = Py.newCode(2, new String[] {"self", "items", "key", "value"}, yaml_load_dot_py, "parse_map_line_nested", false, false, funcTable, 24, null, null, 0, 1);
            c$25_parse_map_line_simple = Py.newCode(3, new String[] {"self", "items", "line", "key", "value", "map_item"}, yaml_load_dot_py, "parse_map_line_simple", false, false, funcTable, 25, null, null, 0, 1);
            c$26_is_map = Py.newCode(2, new String[] {"self", "value"}, yaml_load_dot_py, "is_map", false, false, funcTable, 26, null, null, 0, 1);
            c$27_parse_seq_value = Py.newCode(2, new String[] {"self", "value"}, yaml_load_dot_py, "parse_seq_value", false, false, funcTable, 27, null, null, 0, 1);
            c$28_parse_compressed_map = Py.newCode(2, new String[] {"self", "value", "line", "items", "token"}, yaml_load_dot_py, "parse_compressed_map", false, false, funcTable, 28, null, null, 0, 1);
            c$29_parse_value = Py.newCode(2, new String[] {"self", "value", "alias"}, yaml_load_dot_py, "parse_value", false, false, funcTable, 29, null, null, 0, 1);
            c$30_parse_unaliased_value = Py.newCode(2, new String[] {"self", "value", "url", "match"}, yaml_load_dot_py, "parse_unaliased_value", false, false, funcTable, 30, null, null, 0, 1);
            c$31_parseInlineArray = Py.newCode(2, new String[] {"self", "value"}, yaml_load_dot_py, "parseInlineArray", false, false, funcTable, 31, null, null, 0, 1);
            c$32_parseInlineHash = Py.newCode(2, new String[] {"self", "value"}, yaml_load_dot_py, "parseInlineHash", false, false, funcTable, 32, null, null, 0, 1);
            c$33_parseInlineArrayItem = Py.newCode(3, new String[] {"self", "result", "token"}, yaml_load_dot_py, "parseInlineArrayItem", false, false, funcTable, 33, null, null, 0, 1);
            c$34_parseInlineHashItem = Py.newCode(3, new String[] {"self", "result", "token", "key", "value"}, yaml_load_dot_py, "parseInlineHashItem", false, false, funcTable, 34, null, null, 0, 1);
            c$35_parseInline = Py.newCode(5, new String[] {"self", "result", "value", "end_marker", "itemMethod", "token", "tokenizer"}, yaml_load_dot_py, "parseInline", false, false, funcTable, 35, null, null, 0, 1);
            c$36_parseSpecial = Py.newCode(2, new String[] {"self", "value", "productions"}, yaml_load_dot_py, "parseSpecial", false, false, funcTable, 36, null, null, 0, 1);
            c$37_parse_untyped_value = Py.newCode(2, new String[] {"self", "value", "token", "parse", "data", "ok", "lines"}, yaml_load_dot_py, "parse_untyped_value", false, false, funcTable, 37, null, null, 0, 1);
            c$38_parseNative = Py.newCode(2, new String[] {"self", "value"}, yaml_load_dot_py, "parseNative", false, false, funcTable, 38, null, null, 0, 1);
            c$39_parseMultiLineScalar = Py.newCode(2, new String[] {"self", "value"}, yaml_load_dot_py, "parseMultiLineScalar", false, false, funcTable, 39, null, null, 0, 1);
            c$40_parseFolded = Py.newCode(1, new String[] {"self", "i", "data", "resultString"}, yaml_load_dot_py, "parseFolded", false, false, funcTable, 40, null, null, 0, 1);
            c$41_parseLiteral = Py.newCode(1, new String[] {"self"}, yaml_load_dot_py, "parseLiteral", false, false, funcTable, 41, null, null, 0, 1);
            c$42_parseBlock = Py.newCode(1, new String[] {"self", "data"}, yaml_load_dot_py, "parseBlock", false, false, funcTable, 42, null, null, 0, 1);
            c$43_testForAlias = Py.newCode(2, new String[] {"self", "value", "match"}, yaml_load_dot_py, "testForAlias", false, false, funcTable, 43, null, null, 0, 1);
            c$44_testForRepeatOfAlias = Py.newCode(2, new String[] {"self", "value", "match", "alias"}, yaml_load_dot_py, "testForRepeatOfAlias", false, false, funcTable, 44, null, null, 0, 1);
            c$45_Parser = Py.newCode(0, new String[] {}, yaml_load_dot_py, "Parser", false, false, funcTable, 45, null, null, 0, 0);
            c$46_getToken = Py.newCode(2, new String[] {"regex", "value", "match"}, yaml_load_dot_py, "getToken", false, false, funcTable, 46, null, null, 0, 1);
            c$47_key_value = Py.newCode(1, new String[] {"str", "match", "key", "value"}, yaml_load_dot_py, "key_value", false, false, funcTable, 47, null, null, 0, 1);
            c$48_pruneTrailingEmpties = Py.newCode(1, new String[] {"data"}, yaml_load_dot_py, "pruneTrailingEmpties", false, false, funcTable, 48, null, null, 0, 1);
            c$49_foldChar = Py.newCode(2, new String[] {"line1", "line2"}, yaml_load_dot_py, "foldChar", false, false, funcTable, 49, null, null, 0, 1);
            c$50_getIndicator = Py.newCode(1, new String[] {"line", "match", "header"}, yaml_load_dot_py, "getIndicator", false, false, funcTable, 50, null, null, 0, 1);
            c$51_joinLines = Py.newCode(1, new String[] {"lines", "result", "line"}, yaml_load_dot_py, "joinLines", false, false, funcTable, 51, null, null, 0, 1);
            c$52_main = Py.newCode(0, new String[] {}, yaml_load_dot_py, "main", false, false, funcTable, 52, null, null, 0, 0);
        }
        
        
        public PyCode getMain() {
            if (c$52_main == null) _PyInner.initConstants();
            return c$52_main;
        }
        
        public PyObject call_function(int index, PyFrame frame) {
            switch (index){
                case 0:
                return _PyInner.__init__$1(frame);
                case 1:
                return _PyInner.__iter__$2(frame);
                case 2:
                return _PyInner.next$3(frame);
                case 3:
                return _PyInner.loadIterator$4(frame);
                case 4:
                return _PyInner.StopIteration$5(frame);
                case 5:
                return _PyInner.iter$6(frame);
                case 6:
                return _PyInner.__init__$7(frame);
                case 7:
                return _PyInner.__len__$8(frame);
                case 8:
                return _PyInner.__getitem__$9(frame);
                case 9:
                return _PyInner.next$10(frame);
                case 10:
                return _PyInner.loadIterator$11(frame);
                case 11:
                return _PyInner.loadFile$12(frame);
                case 12:
                return _PyInner.load$13(frame);
                case 13:
                return _PyInner.loadStream$14(frame);
                case 14:
                return _PyInner.tryProductions$15(frame);
                case 15:
                return _PyInner.__init__$16(frame);
                case 16:
                return _PyInner.error$17(frame);
                case 17:
                return _PyInner.nestPop$18(frame);
                case 18:
                return _PyInner.value$19(frame);
                case 19:
                return _PyInner.getNextDocument$20(frame);
                case 20:
                return _PyInner.parseLines$21(frame);
                case 21:
                return _PyInner.parse_collection$22(frame);
                case 22:
                return _PyInner.parse_seq_line$23(frame);
                case 23:
                return _PyInner.parse_map_line$24(frame);
                case 24:
                return _PyInner.parse_map_line_nested$25(frame);
                case 25:
                return _PyInner.parse_map_line_simple$26(frame);
                case 26:
                return _PyInner.is_map$27(frame);
                case 27:
                return _PyInner.parse_seq_value$28(frame);
                case 28:
                return _PyInner.parse_compressed_map$29(frame);
                case 29:
                return _PyInner.parse_value$30(frame);
                case 30:
                return _PyInner.parse_unaliased_value$31(frame);
                case 31:
                return _PyInner.parseInlineArray$32(frame);
                case 32:
                return _PyInner.parseInlineHash$33(frame);
                case 33:
                return _PyInner.parseInlineArrayItem$34(frame);
                case 34:
                return _PyInner.parseInlineHashItem$35(frame);
                case 35:
                return _PyInner.parseInline$36(frame);
                case 36:
                return _PyInner.parseSpecial$37(frame);
                case 37:
                return _PyInner.parse_untyped_value$38(frame);
                case 38:
                return _PyInner.parseNative$39(frame);
                case 39:
                return _PyInner.parseMultiLineScalar$40(frame);
                case 40:
                return _PyInner.parseFolded$41(frame);
                case 41:
                return _PyInner.parseLiteral$42(frame);
                case 42:
                return _PyInner.parseBlock$43(frame);
                case 43:
                return _PyInner.testForAlias$44(frame);
                case 44:
                return _PyInner.testForRepeatOfAlias$45(frame);
                case 45:
                return _PyInner.Parser$46(frame);
                case 46:
                return _PyInner.getToken$47(frame);
                case 47:
                return _PyInner.key_value$48(frame);
                case 48:
                return _PyInner.pruneTrailingEmpties$49(frame);
                case 49:
                return _PyInner.foldChar$50(frame);
                case 50:
                return _PyInner.getIndicator$51(frame);
                case 51:
                return _PyInner.joinLines$52(frame);
                case 52:
                return _PyInner.main$53(frame);
                default:
                return null;
            }
        }
        
        private static PyObject __init__$1(PyFrame frame) {
            frame.getlocal(0).__setattr__("_parser", frame.getlocal(1));
            return Py.None;
        }
        
        private static PyObject __iter__$2(PyFrame frame) {
            return frame.getlocal(0);
        }
        
        private static PyObject next$3(PyFrame frame) {
            return frame.getlocal(0).__getattr__("_parser").invoke("getNextDocument");
        }
        
        private static PyObject loadIterator$4(PyFrame frame) {
            frame.setlocal("__init__", new PyFunction(frame.f_globals, new PyObject[] {}, c$0___init__));
            frame.setlocal("__iter__", new PyFunction(frame.f_globals, new PyObject[] {}, c$1___iter__));
            frame.setlocal("next", new PyFunction(frame.f_globals, new PyObject[] {}, c$2_next));
            frame.setlocal("__next__", frame.getname("next"));
            return frame.getf_locals();
        }
        
        private static PyObject StopIteration$5(PyFrame frame) {
            // pass
            return frame.getf_locals();
        }
        
        private static PyObject iter$6(PyFrame frame) {
            return frame.getlocal(0);
        }
        
        private static PyObject __init__$7(PyFrame frame) {
            // Temporary Variables
            PyException t$0$PyException;
            
            // Code
            frame.getlocal(0).__setattr__("_docs", new PyList(new PyObject[] {}));
            try {
                while (i$1.__nonzero__()) {
                    frame.getlocal(0).__getattr__("_docs").invoke("append", frame.getlocal(1).invoke("getNextDocument"));
                }
            }
            catch (Throwable x$0) {
                t$0$PyException = Py.setException(x$0, frame);
                if (Py.matchException(t$0$PyException, frame.getglobal("StopIteration"))) {
                    // pass
                }
                else throw t$0$PyException;
            }
            frame.getlocal(0).__setattr__("_idx", i$2);
            return Py.None;
        }
        
        private static PyObject __len__$8(PyFrame frame) {
            return frame.getglobal("len").__call__(frame.getlocal(0).__getattr__("_docs"));
        }
        
        private static PyObject __getitem__$9(PyFrame frame) {
            return frame.getlocal(0).__getattr__("_docs").__getitem__(frame.getlocal(1));
        }
        
        private static PyObject next$10(PyFrame frame) {
            if (frame.getlocal(0).__getattr__("_idx")._lt(frame.getglobal("len").__call__(frame.getlocal(0).__getattr__("_docs"))).__nonzero__()) {
                frame.setlocal(1, frame.getlocal(0).__getattr__("_docs").__getitem__(frame.getlocal(0).__getattr__("_idx")));
                frame.getlocal(0).__setattr__("_idx", frame.getlocal(0).__getattr__("_idx")._add(i$1));
                return frame.getlocal(1);
            }
            throw Py.makeException(frame.getglobal("StopIteration"));
        }
        
        private static PyObject loadIterator$11(PyFrame frame) {
            frame.setlocal("__init__", new PyFunction(frame.f_globals, new PyObject[] {}, c$6___init__));
            frame.setlocal("__len__", new PyFunction(frame.f_globals, new PyObject[] {}, c$7___len__));
            frame.setlocal("__getitem__", new PyFunction(frame.f_globals, new PyObject[] {}, c$8___getitem__));
            frame.setlocal("next", new PyFunction(frame.f_globals, new PyObject[] {}, c$9_next));
            frame.setlocal("__next__", frame.getname("next"));
            return frame.getf_locals();
        }
        
        private static PyObject loadFile$12(PyFrame frame) {
            return frame.getglobal("loadStream").__call__(frame.getglobal("FileStream").__call__(frame.getlocal(0)), frame.getlocal(1));
        }
        
        private static PyObject load$13(PyFrame frame) {
            return frame.getglobal("loadStream").__call__(frame.getglobal("StringStream").__call__(frame.getlocal(0)), frame.getlocal(1));
        }
        
        private static PyObject loadStream$14(PyFrame frame) {
            return frame.getglobal("iter").__call__(frame.getglobal("loadIterator").__call__(frame.getglobal("Parser").__call__(frame.getlocal(0), frame.getlocal(1))));
        }
        
        private static PyObject tryProductions$15(PyFrame frame) {
            // Temporary Variables
            int t$0$int;
            PyObject t$0$PyObject, t$1$PyObject, t$2$PyObject;
            
            // Code
            t$0$int = 0;
            t$1$PyObject = frame.getlocal(0);
            while ((t$0$PyObject = t$1$PyObject.__finditem__(t$0$int++)) != null) {
                frame.setlocal(5, t$0$PyObject);
                frame.setlocal(4, frame.getlocal(5).__call__(frame.getlocal(1)));
                if (frame.getlocal(4).__nonzero__()) {
                    t$2$PyObject = frame.getlocal(4);
                    frame.setlocal(3, t$2$PyObject.__getitem__(0));
                    frame.setlocal(2, t$2$PyObject.__getitem__(1));
                    if (frame.getlocal(3).__nonzero__()) {
                        return new PyTuple(new PyObject[] {i$1, frame.getlocal(2)});
                    }
                }
            }
            return Py.None;
        }
        
        private static PyObject __init__$16(PyFrame frame) {
            frame.getlocal(0).__setattr__("nestedDocs", frame.getglobal("NestedDocs").__call__(frame.getlocal(1)));
            frame.getlocal(0).__setattr__("aliases", new PyDictionary(new PyObject[] {}));
            if (frame.getlocal(2).__nonzero__()) {
                frame.getlocal(0).__setattr__("typeResolver", frame.getlocal(2));
            }
            else {
                frame.getlocal(0).__setattr__("typeResolver", frame.getglobal("DefaultResolver").__call__());
            }
            return Py.None;
        }
        
        private static PyObject error$17(PyFrame frame) {
            frame.getlocal(0).__getattr__("nestedDocs").invoke("error", frame.getlocal(1), frame.getlocal(0).__getattr__("line"));
            return Py.None;
        }
        
        private static PyObject nestPop$18(PyFrame frame) {
            frame.setlocal(1, frame.getlocal(0).__getattr__("nestedDocs").invoke("pop"));
            if (frame.getlocal(1)._isnot(frame.getglobal("None")).__nonzero__()) {
                frame.getlocal(0).__setattr__("line", frame.getlocal(1));
                return i$1;
            }
            return Py.None;
        }
        
        private static PyObject value$19(PyFrame frame) {
            return frame.getglobal("getToken").__call__(frame.getlocal(1)._add(s$3), frame.getlocal(0).__getattr__("line"));
        }
        
        private static PyObject getNextDocument$20(PyFrame frame) {
            frame.setlocal(2, frame.getlocal(0).__getattr__("nestedDocs").invoke("popDocSep"));
            frame.setlocal(1, frame.getglobal("getIndicator").__call__(frame.getlocal(2)));
            if (frame.getlocal(1).__nonzero__()) {
                return frame.getlocal(0).invoke("parse_value", frame.getlocal(1));
            }
            if (frame.getlocal(2).__nonzero__()) {
                frame.getlocal(0).__getattr__("nestedDocs").invoke("nestToNextLine");
                return frame.getlocal(0).invoke("parseLines");
            }
            throw Py.makeException(frame.getglobal("StopIteration"));
        }
        
        private static PyObject parseLines$21(PyFrame frame) {
            frame.setlocal(1, frame.getlocal(0).__getattr__("nestedDocs").invoke("peek"));
            if (frame.getlocal(1).__nonzero__()) {
                if (frame.getglobal("re").__getattr__("match").__call__(s$4, frame.getlocal(1)).__nonzero__()) {
                    return frame.getlocal(0).invoke("parse_collection", new PyList(new PyObject[] {}), frame.getlocal(0).__getattr__("parse_seq_line"));
                }
                else {
                    return frame.getlocal(0).invoke("parse_collection", new PyDictionary(new PyObject[] {}), frame.getlocal(0).__getattr__("parse_map_line"));
                }
            }
            throw Py.makeException(frame.getglobal("StopIteration"));
        }
        
        private static PyObject parse_collection$22(PyFrame frame) {
            while (frame.getlocal(0).invoke("nestPop").__nonzero__()) {
                if (frame.getlocal(0).__getattr__("line").__nonzero__()) {
                    frame.getlocal(2).__call__(frame.getlocal(1));
                }
            }
            return frame.getlocal(1);
        }
        
        private static PyObject parse_seq_line$23(PyFrame frame) {
            frame.setlocal(2, frame.getlocal(0).invoke("value", s$5));
            if (frame.getlocal(2)._isnot(frame.getglobal("None")).__nonzero__()) {
                frame.getlocal(1).invoke("append", frame.getlocal(0).invoke("parse_seq_value", frame.getlocal(2)));
            }
            else {
                frame.getlocal(0).invoke("error", s$6);
            }
            return Py.None;
        }
        
        private static PyObject parse_map_line$24(PyFrame frame) {
            if (frame.getlocal(0).__getattr__("line")._eq(s$7).__nonzero__()) {
                frame.getlocal(0).invoke("parse_map_line_nested", frame.getlocal(1));
            }
            else {
                frame.getlocal(0).invoke("parse_map_line_simple", frame.getlocal(1), frame.getlocal(0).__getattr__("line"));
            }
            return Py.None;
        }
        
        private static PyObject parse_map_line_nested$25(PyFrame frame) {
            frame.getlocal(0).__getattr__("nestedDocs").invoke("nestToNextLine");
            frame.setlocal(2, frame.getlocal(0).invoke("parseLines"));
            if (frame.getlocal(0).invoke("nestPop").__nonzero__()) {
                frame.setlocal(3, frame.getlocal(0).invoke("value", s$8));
                if (frame.getlocal(3)._isnot(frame.getglobal("None")).__nonzero__()) {
                    frame.getlocal(1).__setitem__(frame.getglobal("tuple").__call__(frame.getlocal(2)), frame.getlocal(0).invoke("parse_value", frame.getlocal(3)));
                    return Py.None;
                }
            }
            frame.getlocal(0).invoke("error", s$9);
            return Py.None;
        }
        
        private static PyObject parse_map_line_simple$26(PyFrame frame) {
            // Temporary Variables
            PyObject t$0$PyObject;
            
            // Code
            frame.setlocal(5, frame.getglobal("key_value").__call__(frame.getlocal(2)));
            if (frame.getlocal(5).__nonzero__()) {
                t$0$PyObject = frame.getlocal(5);
                frame.setlocal(3, t$0$PyObject.__getitem__(0));
                frame.setlocal(4, t$0$PyObject.__getitem__(1));
                frame.setlocal(3, frame.getglobal("convertImplicit").__call__(frame.getlocal(3)));
                frame.getlocal(1).__setitem__(frame.getlocal(3), frame.getlocal(0).invoke("parse_value", frame.getlocal(4)));
            }
            else {
                frame.getlocal(0).invoke("error", s$10);
            }
            return Py.None;
        }
        
        private static PyObject is_map$27(PyFrame frame) {
            if (frame.getglobal("len").__call__(frame.getlocal(1))._eq(i$2).__nonzero__()) {
                return i$2;
            }
            if (frame.getlocal(1).__getitem__(i$2)._eq(s$11).__nonzero__()) {
                return i$2;
            }
            if (frame.getglobal("re").__getattr__("search").__call__(s$12, frame.getlocal(1)).__nonzero__()) {
                return i$1;
            }
            return Py.None;
        }
        
        private static PyObject parse_seq_value$28(PyFrame frame) {
            if (frame.getlocal(0).invoke("is_map", frame.getlocal(1)).__nonzero__()) {
                return frame.getlocal(0).invoke("parse_compressed_map", frame.getlocal(1));
            }
            else {
                return frame.getlocal(0).invoke("parse_value", frame.getlocal(1));
            }
        }
        
        private static PyObject parse_compressed_map$29(PyFrame frame) {
            frame.setlocal(3, new PyDictionary(new PyObject[] {}));
            frame.setlocal(2, frame.getlocal(0).__getattr__("line"));
            frame.setlocal(4, frame.getglobal("getToken").__call__(s$13, frame.getlocal(2)));
            frame.getlocal(0).__getattr__("nestedDocs").invoke("nestBySpecificAmount", frame.getglobal("len").__call__(frame.getlocal(4)));
            frame.getlocal(0).invoke("parse_map_line_simple", frame.getlocal(3), frame.getlocal(1));
            return frame.getlocal(0).invoke("parse_collection", frame.getlocal(3), frame.getlocal(0).__getattr__("parse_map_line"));
        }
        
        private static PyObject parse_value$30(PyFrame frame) {
            // Temporary Variables
            PyObject t$0$PyObject;
            
            // Code
            t$0$PyObject = frame.getlocal(0).invoke("testForRepeatOfAlias", frame.getlocal(1));
            frame.setlocal(2, t$0$PyObject.__getitem__(0));
            frame.setlocal(1, t$0$PyObject.__getitem__(1));
            if (frame.getlocal(2).__nonzero__()) {
                return frame.getlocal(1);
            }
            t$0$PyObject = frame.getlocal(0).invoke("testForAlias", frame.getlocal(1));
            frame.setlocal(2, t$0$PyObject.__getitem__(0));
            frame.setlocal(1, t$0$PyObject.__getitem__(1));
            frame.setlocal(1, frame.getlocal(0).invoke("parse_unaliased_value", frame.getlocal(1)));
            if (frame.getlocal(2).__nonzero__()) {
                frame.getlocal(0).__getattr__("aliases").__setitem__(frame.getlocal(2), frame.getlocal(1));
            }
            return frame.getlocal(1);
        }
        
        private static PyObject parse_unaliased_value$31(PyFrame frame) {
            // Temporary Variables
            PyObject t$0$PyObject;
            
            // Code
            frame.setlocal(3, frame.getglobal("re").__getattr__("match").__call__(s$14, frame.getlocal(1)));
            if (frame.getlocal(3).__nonzero__()) {
                t$0$PyObject = frame.getlocal(3).invoke("groups");
                frame.setlocal(2, t$0$PyObject.__getitem__(0));
                frame.setlocal(1, t$0$PyObject.__getitem__(1));
                frame.setlocal(1, frame.getlocal(0).invoke("parse_untyped_value", frame.getlocal(1)));
                if (frame.getlocal(2).__getslice__(null, i$15, null)._eq(s$16).__nonzero__()) {
                    return frame.getlocal(0).__getattr__("typeResolver").invoke("resolveType", frame.getlocal(1), frame.getlocal(2));
                }
                else {
                    return frame.getlocal(1);
                }
            }
            return frame.getlocal(0).invoke("parse_untyped_value", frame.getlocal(1));
        }
        
        private static PyObject parseInlineArray$32(PyFrame frame) {
            if (frame.getglobal("re").__getattr__("match").__call__(s$17, frame.getlocal(1)).__nonzero__()) {
                return frame.getlocal(0).invoke("parseInline", new PyObject[] {new PyList(new PyObject[] {}), frame.getlocal(1), s$18, frame.getlocal(0).__getattr__("parseInlineArrayItem")});
            }
            return Py.None;
        }
        
        private static PyObject parseInlineHash$33(PyFrame frame) {
            if (frame.getglobal("re").__getattr__("match").__call__(s$19, frame.getlocal(1)).__nonzero__()) {
                return frame.getlocal(0).invoke("parseInline", new PyObject[] {new PyDictionary(new PyObject[] {}), frame.getlocal(1), s$20, frame.getlocal(0).__getattr__("parseInlineHashItem")});
            }
            return Py.None;
        }
        
        private static PyObject parseInlineArrayItem$34(PyFrame frame) {
            return frame.getlocal(1).invoke("append", frame.getglobal("convertImplicit").__call__(frame.getlocal(2)));
        }
        
        private static PyObject parseInlineHashItem$35(PyFrame frame) {
            // Temporary Variables
            PyObject t$0$PyObject;
            
            // Code
            t$0$PyObject = frame.getglobal("key_value").__call__(frame.getlocal(2));
            frame.setlocal(3, t$0$PyObject.__getitem__(0));
            frame.setlocal(4, t$0$PyObject.__getitem__(1));
            frame.getlocal(1).__setitem__(frame.getlocal(3), frame.getlocal(4));
            return Py.None;
        }
        
        private static PyObject parseInline$36(PyFrame frame) {
            frame.setlocal(6, frame.getglobal("InlineTokenizer").__call__(frame.getlocal(2)));
            frame.getlocal(6).invoke("next");
            while (i$1.__nonzero__()) {
                frame.setlocal(5, frame.getlocal(6).invoke("next"));
                if (frame.getlocal(5)._eq(frame.getlocal(3)).__nonzero__()) {
                    break;
                }
                frame.getlocal(4).__call__(frame.getlocal(1), frame.getlocal(5));
            }
            return new PyTuple(new PyObject[] {i$1, frame.getlocal(1)});
        }
        
        private static PyObject parseSpecial$37(PyFrame frame) {
            frame.setlocal(2, new PyList(new PyObject[] {frame.getlocal(0).__getattr__("parseMultiLineScalar"), frame.getlocal(0).__getattr__("parseInlineHash"), frame.getlocal(0).__getattr__("parseInlineArray")}));
            return frame.getglobal("tryProductions").__call__(frame.getlocal(2), frame.getlocal(1));
        }
        
        private static PyObject parse_untyped_value$38(PyFrame frame) {
            // Temporary Variables
            PyObject t$0$PyObject;
            
            // Code
            frame.setlocal(3, frame.getlocal(0).invoke("parseSpecial", frame.getlocal(1)));
            if (frame.getlocal(3).__nonzero__()) {
                t$0$PyObject = frame.getlocal(3);
                frame.setlocal(5, t$0$PyObject.__getitem__(0));
                frame.setlocal(4, t$0$PyObject.__getitem__(1));
                return frame.getlocal(4);
            }
            frame.setlocal(2, frame.getglobal("getToken").__call__(s$21, frame.getlocal(1)));
            if (frame.getlocal(2).__nonzero__()) {
                frame.setlocal(6, new PyList(new PyObject[] {frame.getlocal(2)})._add(frame.getglobal("pruneTrailingEmpties").__call__(frame.getlocal(0).__getattr__("nestedDocs").invoke("popNestedLines"))));
                return frame.getglobal("convertImplicit").__call__(frame.getglobal("joinLines").__call__(frame.getlocal(6)));
            }
            else {
                frame.getlocal(0).__getattr__("nestedDocs").invoke("nestToNextLine");
                return frame.getlocal(0).invoke("parseLines");
            }
        }
        
        private static PyObject parseNative$39(PyFrame frame) {
            return new PyTuple(new PyObject[] {i$1, frame.getglobal("convertImplicit").__call__(frame.getlocal(1))});
        }
        
        private static PyObject parseMultiLineScalar$40(PyFrame frame) {
            if (frame.getlocal(1)._eq(s$22).__nonzero__()) {
                return new PyTuple(new PyObject[] {i$1, frame.getlocal(0).invoke("parseFolded")});
            }
            else if (frame.getlocal(1)._eq(s$23).__nonzero__()) {
                return new PyTuple(new PyObject[] {i$1, frame.getlocal(0).invoke("parseLiteral")});
            }
            return Py.None;
        }
        
        private static PyObject parseFolded$41(PyFrame frame) {
            frame.setlocal(2, frame.getlocal(0).invoke("parseBlock"));
            frame.setlocal(1, i$2);
            frame.setlocal(3, s$24);
            while (frame.getlocal(1)._lt(frame.getglobal("len").__call__(frame.getlocal(2))._sub(i$1)).__nonzero__()) {
                frame.setlocal(3, frame.getlocal(3)._add(frame.getlocal(2).__getitem__(frame.getlocal(1))));
                frame.setlocal(3, frame.getlocal(3)._add(frame.getglobal("foldChar").__call__(frame.getlocal(2).__getitem__(frame.getlocal(1)), frame.getlocal(2).__getitem__(frame.getlocal(1)._add(i$1)))));
                frame.setlocal(1, frame.getlocal(1)._add(i$1));
            }
            return frame.getlocal(3)._add(frame.getlocal(2).__getitem__(i$1.__neg__()))._add(s$25);
        }
        
        private static PyObject parseLiteral$42(PyFrame frame) {
            return frame.getglobal("string").__getattr__("join").__call__(frame.getlocal(0).invoke("parseBlock"), s$25)._add(s$25);
        }
        
        private static PyObject parseBlock$43(PyFrame frame) {
            frame.getlocal(0).__getattr__("nestedDocs").invoke("nestToNextLine");
            frame.setlocal(1, new PyList(new PyObject[] {}));
            while (frame.getlocal(0).invoke("nestPop").__nonzero__()) {
                frame.getlocal(1).invoke("append", frame.getlocal(0).__getattr__("line"));
            }
            return frame.getglobal("pruneTrailingEmpties").__call__(frame.getlocal(1));
        }
        
        private static PyObject testForAlias$44(PyFrame frame) {
            frame.setlocal(2, frame.getglobal("re").__getattr__("match").__call__(s$26, frame.getlocal(1)));
            if (frame.getlocal(2).__nonzero__()) {
                return frame.getlocal(2).invoke("groups");
            }
            return new PyTuple(new PyObject[] {frame.getglobal("None"), frame.getlocal(1)});
        }
        
        private static PyObject testForRepeatOfAlias$45(PyFrame frame) {
            frame.setlocal(2, frame.getglobal("re").__getattr__("match").__call__(s$27, frame.getlocal(1)));
            if (frame.getlocal(2).__nonzero__()) {
                frame.setlocal(3, frame.getlocal(2).invoke("groups").__getitem__(i$2));
                if (frame.getlocal(0).__getattr__("aliases").invoke("has_key", frame.getlocal(3)).__nonzero__()) {
                    return new PyTuple(new PyObject[] {frame.getlocal(3), frame.getlocal(0).__getattr__("aliases").__getitem__(frame.getlocal(3))});
                }
                else {
                    frame.getlocal(0).invoke("error", s$28);
                }
            }
            return new PyTuple(new PyObject[] {frame.getglobal("None"), frame.getlocal(1)});
        }
        
        private static PyObject Parser$46(PyFrame frame) {
            frame.setlocal("__init__", new PyFunction(frame.f_globals, new PyObject[] {frame.getname("None")}, c$15___init__));
            frame.setlocal("error", new PyFunction(frame.f_globals, new PyObject[] {}, c$16_error));
            frame.setlocal("nestPop", new PyFunction(frame.f_globals, new PyObject[] {}, c$17_nestPop));
            frame.setlocal("value", new PyFunction(frame.f_globals, new PyObject[] {}, c$18_value));
            frame.setlocal("getNextDocument", new PyFunction(frame.f_globals, new PyObject[] {}, c$19_getNextDocument));
            frame.setlocal("parseLines", new PyFunction(frame.f_globals, new PyObject[] {}, c$20_parseLines));
            frame.setlocal("parse_collection", new PyFunction(frame.f_globals, new PyObject[] {}, c$21_parse_collection));
            frame.setlocal("parse_seq_line", new PyFunction(frame.f_globals, new PyObject[] {}, c$22_parse_seq_line));
            frame.setlocal("parse_map_line", new PyFunction(frame.f_globals, new PyObject[] {}, c$23_parse_map_line));
            frame.setlocal("parse_map_line_nested", new PyFunction(frame.f_globals, new PyObject[] {}, c$24_parse_map_line_nested));
            frame.setlocal("parse_map_line_simple", new PyFunction(frame.f_globals, new PyObject[] {}, c$25_parse_map_line_simple));
            frame.setlocal("is_map", new PyFunction(frame.f_globals, new PyObject[] {}, c$26_is_map));
            frame.setlocal("parse_seq_value", new PyFunction(frame.f_globals, new PyObject[] {}, c$27_parse_seq_value));
            frame.setlocal("parse_compressed_map", new PyFunction(frame.f_globals, new PyObject[] {}, c$28_parse_compressed_map));
            frame.setlocal("parse_value", new PyFunction(frame.f_globals, new PyObject[] {}, c$29_parse_value));
            frame.setlocal("parse_unaliased_value", new PyFunction(frame.f_globals, new PyObject[] {}, c$30_parse_unaliased_value));
            frame.setlocal("parseInlineArray", new PyFunction(frame.f_globals, new PyObject[] {}, c$31_parseInlineArray));
            frame.setlocal("parseInlineHash", new PyFunction(frame.f_globals, new PyObject[] {}, c$32_parseInlineHash));
            frame.setlocal("parseInlineArrayItem", new PyFunction(frame.f_globals, new PyObject[] {}, c$33_parseInlineArrayItem));
            frame.setlocal("parseInlineHashItem", new PyFunction(frame.f_globals, new PyObject[] {}, c$34_parseInlineHashItem));
            frame.setlocal("parseInline", new PyFunction(frame.f_globals, new PyObject[] {}, c$35_parseInline));
            frame.setlocal("parseSpecial", new PyFunction(frame.f_globals, new PyObject[] {}, c$36_parseSpecial));
            frame.setlocal("parse_untyped_value", new PyFunction(frame.f_globals, new PyObject[] {}, c$37_parse_untyped_value));
            frame.setlocal("parseNative", new PyFunction(frame.f_globals, new PyObject[] {}, c$38_parseNative));
            frame.setlocal("parseMultiLineScalar", new PyFunction(frame.f_globals, new PyObject[] {}, c$39_parseMultiLineScalar));
            frame.setlocal("parseFolded", new PyFunction(frame.f_globals, new PyObject[] {}, c$40_parseFolded));
            frame.setlocal("parseLiteral", new PyFunction(frame.f_globals, new PyObject[] {}, c$41_parseLiteral));
            frame.setlocal("parseBlock", new PyFunction(frame.f_globals, new PyObject[] {}, c$42_parseBlock));
            frame.setlocal("testForAlias", new PyFunction(frame.f_globals, new PyObject[] {}, c$43_testForAlias));
            frame.setlocal("testForRepeatOfAlias", new PyFunction(frame.f_globals, new PyObject[] {}, c$44_testForRepeatOfAlias));
            return frame.getf_locals();
        }
        
        private static PyObject getToken$47(PyFrame frame) {
            frame.setlocal(2, frame.getglobal("re").__getattr__("search").__call__(frame.getlocal(0), frame.getlocal(1)));
            if (frame.getlocal(2).__nonzero__()) {
                return frame.getlocal(2).invoke("groups").__getitem__(i$2);
            }
            return Py.None;
        }
        
        private static PyObject key_value$48(PyFrame frame) {
            // Temporary Variables
            PyObject t$0$PyObject;
            
            // Code
            frame.setlocal(1, frame.getglobal("re").__getattr__("match").__call__(s$29, frame.getlocal(0)));
            if (frame.getlocal(1).__nonzero__()) {
                t$0$PyObject = frame.getlocal(1).invoke("groups");
                frame.setlocal(2, t$0$PyObject.__getitem__(0));
                frame.setlocal(3, t$0$PyObject.__getitem__(1));
                return new PyTuple(new PyObject[] {frame.getlocal(2), frame.getlocal(3)});
            }
            frame.setlocal(1, frame.getglobal("re").__getattr__("match").__call__(s$30, frame.getlocal(0)));
            if (frame.getlocal(1).__nonzero__()) {
                t$0$PyObject = frame.getlocal(1).invoke("groups");
                frame.setlocal(2, t$0$PyObject.__getitem__(0));
                frame.setlocal(3, t$0$PyObject.__getitem__(1));
                if (((t$0$PyObject = frame.getglobal("len").__call__(frame.getlocal(3))).__nonzero__() ? frame.getlocal(3).__getitem__(i$2)._eq(s$31) : t$0$PyObject).__nonzero__()) {
                    frame.setlocal(3, s$24);
                }
                return new PyTuple(new PyObject[] {frame.getlocal(2), frame.getlocal(3)});
            }
            return Py.None;
        }
        
        private static PyObject pruneTrailingEmpties$49(PyFrame frame) {
            // Temporary Variables
            PyObject t$0$PyObject;
            
            // Code
            while (((t$0$PyObject = frame.getglobal("len").__call__(frame.getlocal(0))._gt(i$2)).__nonzero__() ? frame.getlocal(0).__getitem__(i$1.__neg__())._eq(s$24) : t$0$PyObject).__nonzero__()) {
                frame.setlocal(0, frame.getlocal(0).__getslice__(null, i$1.__neg__(), null));
            }
            return frame.getlocal(0);
        }
        
        private static PyObject foldChar$50(PyFrame frame) {
            // Temporary Variables
            PyObject t$0$PyObject;
            
            // Code
            if (((t$0$PyObject = frame.getglobal("re").__getattr__("match").__call__(s$32, frame.getlocal(0))).__nonzero__() ? frame.getglobal("re").__getattr__("match").__call__(s$32, frame.getlocal(1)) : t$0$PyObject).__nonzero__()) {
                return s$33;
            }
            return s$25;
        }
        
        private static PyObject getIndicator$51(PyFrame frame) {
            if (frame.getlocal(0).__nonzero__()) {
                frame.setlocal(2, s$34);
                frame.setlocal(1, frame.getglobal("re").__getattr__("match").__call__(s$35._add(frame.getlocal(2))._add(s$36), frame.getlocal(0)));
                if (frame.getlocal(1).__nonzero__()) {
                    return frame.getlocal(1).invoke("groups").__getitem__(i$1.__neg__());
                }
            }
            return Py.None;
        }
        
        private static PyObject joinLines$52(PyFrame frame) {
            // Temporary Variables
            int t$0$int;
            PyObject t$0$PyObject, t$1$PyObject;
            
            // Code
            frame.setlocal(1, s$24);
            t$0$int = 0;
            t$1$PyObject = frame.getlocal(0).__getslice__(null, i$1.__neg__(), null);
            while ((t$0$PyObject = t$1$PyObject.__finditem__(t$0$int++)) != null) {
                frame.setlocal(2, t$0$PyObject);
                if (frame.getlocal(2).__getitem__(i$1.__neg__())._eq(s$37).__nonzero__()) {
                    frame.setlocal(1, frame.getlocal(1)._add(frame.getlocal(2).__getslice__(null, i$1.__neg__(), null)));
                }
                else {
                    frame.setlocal(1, frame.getlocal(1)._add(frame.getlocal(2))._add(s$33));
                }
            }
            return frame.getlocal(1)._add(frame.getlocal(0).__getitem__(i$1.__neg__()));
        }
        
        private static PyObject main$53(PyFrame frame) {
            frame.setglobal("__file__", s$38);
            
            PyObject[] imp_accu;
            // Temporary Variables
            PyException t$0$PyException;
            
            // Code
            frame.setlocal("re", org.python.core.imp.importOne("re", frame));
            frame.setlocal("string", org.python.core.imp.importOne("string", frame));
            imp_accu = org.python.core.imp.importFrom("implicit", new String[] {"convertImplicit"}, frame);
            frame.setlocal("convertImplicit", imp_accu[0]);
            imp_accu = org.python.core.imp.importFrom("inline", new String[] {"InlineTokenizer"}, frame);
            frame.setlocal("InlineTokenizer", imp_accu[0]);
            imp_accu = org.python.core.imp.importFrom("yaml.klass", new String[] {"DefaultResolver"}, frame);
            frame.setlocal("DefaultResolver", imp_accu[0]);
            imp_accu = org.python.core.imp.importFrom("yaml.stream", new String[] {"FileStream", "StringStream", "NestedDocs"}, frame);
            frame.setlocal("FileStream", imp_accu[0]);
            frame.setlocal("StringStream", imp_accu[1]);
            frame.setlocal("NestedDocs", imp_accu[2]);
            frame.setlocal("PRIVATE_NOTICE", s$0);
            try {
                frame.getname("iter").__call__(frame.getname("list").__call__());
                frame.setlocal("StopIteration", frame.getname("StopIteration"));
                frame.setlocal("loadIterator", Py.makeClass("loadIterator", new PyObject[] {}, c$3_loadIterator, null));
            }
            catch (Throwable x$0) {
                t$0$PyException = Py.setException(x$0, frame);
                frame.setlocal("StopIteration", Py.makeClass("StopIteration", new PyObject[] {}, c$4_StopIteration, null));
                frame.setlocal("iter", new PyFunction(frame.f_globals, new PyObject[] {}, c$5_iter));
                frame.setlocal("loadIterator", Py.makeClass("loadIterator", new PyObject[] {}, c$10_loadIterator, null));
            }
            frame.setlocal("loadFile", new PyFunction(frame.f_globals, new PyObject[] {frame.getname("None")}, c$11_loadFile));
            frame.setlocal("load", new PyFunction(frame.f_globals, new PyObject[] {frame.getname("None")}, c$12_load));
            frame.setlocal("loadStream", new PyFunction(frame.f_globals, new PyObject[] {}, c$13_loadStream));
            frame.setlocal("tryProductions", new PyFunction(frame.f_globals, new PyObject[] {}, c$14_tryProductions));
            frame.setlocal("Parser", Py.makeClass("Parser", new PyObject[] {}, c$45_Parser, null));
            frame.setlocal("getToken", new PyFunction(frame.f_globals, new PyObject[] {}, c$46_getToken));
            frame.setlocal("key_value", new PyFunction(frame.f_globals, new PyObject[] {}, c$47_key_value));
            frame.setlocal("pruneTrailingEmpties", new PyFunction(frame.f_globals, new PyObject[] {}, c$48_pruneTrailingEmpties));
            frame.setlocal("foldChar", new PyFunction(frame.f_globals, new PyObject[] {}, c$49_foldChar));
            frame.setlocal("getIndicator", new PyFunction(frame.f_globals, new PyObject[] {}, c$50_getIndicator));
            frame.setlocal("joinLines", new PyFunction(frame.f_globals, new PyObject[] {}, c$51_joinLines));
            return Py.None;
        }
        
    }
    public static void moduleDictInit(PyObject dict) {
        dict.__setitem__("__name__", new PyString("load"));
        Py.runCode(new _PyInner().getMain(), dict, dict);
    }
    
    public static void main(String[] args) throws Exception {
        String[] newargs = new String[args.length+1];
        newargs[0] = "load";
        System.arraycopy(args, 0, newargs, 1, args.length);
        Py.runMain(load._PyInner.class, newargs, jpy$packages, jpy$properties, "yaml", new String[] {"socket", "ftplib", "yaml.klass", "yaml.__init__", "dummy", "macurl2path", "rfc822", "string", "yaml.inline", "yaml.dump", "tempfile", "yaml.load", "base64", "sre", "StringIO", "copy_reg", "random", "getopt", "nturl2path", "httplib", "mimetools", "sre_parse", "sre_compile", "quopri", "yaml.implicit", "sre_constants", "javapath", "yaml.ypath", "urllib", "re", "mimetypes", "posixpath", "errno", "gopherlib", "yaml.stream", "stat", "yaml.timestamp", "javaos"});
    }
    
}
