package pyyaml;

import org.python.core.*;

public class dump extends java.lang.Object {
    static String[] jpy$properties = new String[] {"python.modules.builtin", "exceptions:org.python.core.exceptions", "python.options.showJavaExceptions", "true"};
    static String[] jpy$packages = new String[] {"org.python.core", null, "java.lang", null, "java.io", null, "java.net", null};
    
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
        private static PyObject i$12;
        private static PyObject s$13;
        private static PyObject s$14;
        private static PyObject s$15;
        private static PyObject s$16;
        private static PyObject s$17;
        private static PyObject s$18;
        private static PyObject s$19;
        private static PyObject i$20;
        private static PyObject i$21;
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
        private static PyObject i$33;
        private static PyObject s$34;
        private static PyFunctionTable funcTable;
        private static PyCode c$0_dump;
        private static PyCode c$1_dumpToFile;
        private static PyCode c$2___init__;
        private static PyCode c$3_setIndent;
        private static PyCode c$4_setSort;
        private static PyCode c$5_lambda;
public static PyCode c$6_dump;
        private static PyCode c$7_lambda;
public static PyCode c$8_dumpToFile;
        private static PyCode c$9_dumpDocuments;
        private static PyCode c$10_indentDump;
        private static PyCode c$11_dumpData;
        private static PyCode c$12_dumpTransformedObject;
        private static PyCode c$13_dumpRawObject;
        private static PyCode c$14_dumpDict;
        private static PyCode c$15_dumpKey;
        private static PyCode c$16_dumpList;
        private static PyCode c$17_dumpScalar;
        private static PyCode c$18_dumpMultiLineScalar;
        private static PyCode c$19_raiseToYamlSyntaxError;
        private static PyCode c$20_Dumper;
        private static PyCode c$21_accumulate;
        private static PyCode c$22___init__;
        private static PyCode c$23_shouldAnchor;
        private static PyCode c$24_isAlias;
        private static PyCode c$25_YamlAnchors;
        private static PyCode c$26_sort_keys;
        private static PyCode c$27_sortMethod;
        private static PyCode c$28_quote;
        private static PyCode c$29_needsSingleQuote;
        private static PyCode c$30_hasSpecialChar;
        private static PyCode c$31_isMulti;
        private static PyCode c$32_cleanUnicode;
        private static PyCode c$33_main;
        private static void initConstants() {
            s$0 = Py.newString("\012  The methods from this module that are exported to the top \012  level yaml package should remain stable.  If you call\012  directly into other methods of this module, be aware that \012  they may change or go away in future implementations.\012  Contact the authors if there are methods in this file \012  that you wish to remain stable.\012");
            s$1 = Py.newString("\012");
            s$2 = Py.newString("    ");
            s$3 = Py.newString("");
            s$4 = Py.newString("---");
            s$5 = Py.newString(" &%d");
            s$6 = Py.newString(" *%d");
            s$7 = Py.newString(" ~");
            s$8 = Py.newString("to_yaml");
            s$9 = Py.newString("to_yaml_implicit");
            s$10 = Py.newString(" ");
            s$11 = Py.newString(" !!%s.%s");
            i$12 = Py.newInteger(0);
            s$13 = Py.newString(" {}");
            s$14 = Py.newString(":");
            s$15 = Py.newString("?");
            s$16 = Py.newString(" []");
            s$17 = Py.newString("-");
            s$18 = Py.newString(" |");
            s$19 = Py.newString("\012to_yaml should return tuple w/object to dump \012and optional YAML type.  Example:\012({'foo': 'bar'}, '!!foobar')\012");
            i$20 = Py.newInteger(32);
            i$21 = Py.newInteger(1);
            s$22 = Py.newString("~");
            s$23 = Py.newString("'");
            s$24 = Py.newString("\"");
            s$25 = Py.newString("''");
            s$26 = Py.newString("\\x08");
            s$27 = Py.newString("\\b");
            s$28 = Py.newString("%s%s%s");
            s$29 = Py.newString("^\\d");
            s$30 = Py.newString("[-:]");
            s$31 = Py.newString("(\\d\\.){2}");
            s$32 = Py.newString("[\\t\\b\\r\\f#]");
            i$33 = Py.newInteger(2);
            s$34 = Py.newString("/local/src/i/Rabbit3/runtime/py-lib/yaml/dump.py");
            funcTable = new _PyInner();
            c$0_dump = Py.newCode(1, new String[] {"data"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/dump.py", "dump", true, false, funcTable, 1, null, null, 0, 1);
            c$1_dumpToFile = Py.newCode(2, new String[] {"file", "data"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/dump.py", "dumpToFile", true, false, funcTable, 2, null, null, 0, 1);
            c$2___init__ = Py.newCode(1, new String[] {"self"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/dump.py", "__init__", false, false, funcTable, 3, null, null, 0, 1);
            c$3_setIndent = Py.newCode(2, new String[] {"self", "indent"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/dump.py", "setIndent", false, false, funcTable, 4, null, null, 0, 1);
            c$4_setSort = Py.newCode(2, new String[] {"self", "sort_hint"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/dump.py", "setSort", false, false, funcTable, 5, null, null, 0, 1);
            c$5_lambda = Py.newCode(2, new String[] {"data", "result"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/dump.py", "<lambda>", false, false, funcTable, 6, null, null, 0, 1);
            c$6_dump = Py.newCode(2, new String[] {"self", "data", "result"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/dump.py", "dump", true, false, funcTable, 7, null, null, 0, 1);
            c$7_lambda = Py.newCode(2, new String[] {"data", "file"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/dump.py", "<lambda>", false, false, funcTable, 8, null, null, 0, 1);
            c$8_dumpToFile = Py.newCode(3, new String[] {"self", "file", "data"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/dump.py", "dumpToFile", true, false, funcTable, 9, null, null, 0, 1);
            c$9_dumpDocuments = Py.newCode(2, new String[] {"self", "data", "obj"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/dump.py", "dumpDocuments", false, false, funcTable, 10, null, null, 0, 1);
            c$10_indentDump = Py.newCode(2, new String[] {"self", "data", "oldIndent"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/dump.py", "indentDump", false, false, funcTable, 11, null, null, 0, 1);
            c$11_dumpData = Py.newCode(2, new String[] {"self", "data", "anchor"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/dump.py", "dumpData", false, false, funcTable, 12, null, null, 0, 1);
            c$12_dumpTransformedObject = Py.newCode(2, new String[] {"self", "data", "typestring", "obj_yaml"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/dump.py", "dumpTransformedObject", false, false, funcTable, 13, null, null, 0, 1);
            c$13_dumpRawObject = Py.newCode(2, new String[] {"self", "data"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/dump.py", "dumpRawObject", false, false, funcTable, 14, null, null, 0, 1);
            c$14_dumpDict = Py.newCode(2, new String[] {"self", "data", "key", "keys"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/dump.py", "dumpDict", false, false, funcTable, 15, null, null, 0, 1);
            c$15_dumpKey = Py.newCode(2, new String[] {"self", "key"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/dump.py", "dumpKey", false, false, funcTable, 16, null, null, 0, 1);
            c$16_dumpList = Py.newCode(2, new String[] {"self", "data", "item"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/dump.py", "dumpList", false, false, funcTable, 17, null, null, 0, 1);
            c$17_dumpScalar = Py.newCode(2, new String[] {"self", "data"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/dump.py", "dumpScalar", false, false, funcTable, 18, null, null, 0, 1);
            c$18_dumpMultiLineScalar = Py.newCode(2, new String[] {"self", "lines", "line"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/dump.py", "dumpMultiLineScalar", false, false, funcTable, 19, null, null, 0, 1);
            c$19_raiseToYamlSyntaxError = Py.newCode(1, new String[] {"self"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/dump.py", "raiseToYamlSyntaxError", false, false, funcTable, 20, null, null, 0, 1);
            c$20_Dumper = Py.newCode(0, new String[] {}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/dump.py", "Dumper", false, false, funcTable, 21, null, null, 0, 0);
            c$21_accumulate = Py.newCode(2, new String[] {"obj", "occur", "typ", "obid", "y", "x"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/dump.py", "accumulate", false, false, funcTable, 22, null, null, 0, 1);
            c$22___init__ = Py.newCode(2, new String[] {"self", "data", "obid", "occur", "anchorVisits"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/dump.py", "__init__", false, false, funcTable, 23, null, null, 0, 1);
            c$23_shouldAnchor = Py.newCode(2, new String[] {"self", "obj", "ret"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/dump.py", "shouldAnchor", false, false, funcTable, 24, null, null, 0, 1);
            c$24_isAlias = Py.newCode(2, new String[] {"self", "obj"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/dump.py", "isAlias", false, false, funcTable, 25, null, null, 0, 1);
            c$25_YamlAnchors = Py.newCode(0, new String[] {}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/dump.py", "YamlAnchors", false, false, funcTable, 26, null, null, 0, 0);
            c$26_sort_keys = Py.newCode(2, new String[] {"keys", "fn", "x", "key", "tmp", "val", "y"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/dump.py", "sort_keys", false, false, funcTable, 27, null, null, 0, 1);
            c$27_sortMethod = Py.newCode(1, new String[] {"sort_hint", "typ", "indexes", "idx", "item"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/dump.py", "sortMethod", false, false, funcTable, 28, null, null, 0, 1);
            c$28_quote = Py.newCode(1, new String[] {"data", "quote", "single", "double"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/dump.py", "quote", false, false, funcTable, 29, null, null, 0, 1);
            c$29_needsSingleQuote = Py.newCode(1, new String[] {"data"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/dump.py", "needsSingleQuote", false, false, funcTable, 30, null, null, 0, 1);
            c$30_hasSpecialChar = Py.newCode(1, new String[] {"data"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/dump.py", "hasSpecialChar", false, false, funcTable, 31, null, null, 0, 1);
            c$31_isMulti = Py.newCode(1, new String[] {"data"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/dump.py", "isMulti", false, false, funcTable, 32, null, null, 0, 1);
            c$32_cleanUnicode = Py.newCode(1, new String[] {"data"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/dump.py", "cleanUnicode", false, false, funcTable, 33, null, null, 0, 1);
            c$33_main = Py.newCode(0, new String[] {}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/dump.py", "main", false, false, funcTable, 34, null, null, 0, 0);
        }
        
        
        public PyCode getMain() {
            if (c$33_main == null) _PyInner.initConstants();
            return c$33_main;
        }
        
        public PyObject call_function(int index, PyFrame frame) {
            switch (index){
                case 0:
                return _PyInner.__listcomprehension$1(frame);
                case 1:
                return _PyInner.dump$2(frame);
                case 2:
                return _PyInner.dumpToFile$3(frame);
                case 3:
                return _PyInner.__init__$4(frame);
                case 4:
                return _PyInner.setIndent$5(frame);
                case 5:
                return _PyInner.setSort$6(frame);
                case 6:
                return _PyInner.lambda$7(frame);
                case 7:
                return _PyInner.dump$8(frame);
                case 8:
                return _PyInner.lambda$9(frame);
                case 9:
                return _PyInner.dumpToFile$10(frame);
                case 10:
                return _PyInner.dumpDocuments$11(frame);
                case 11:
                return _PyInner.indentDump$12(frame);
                case 12:
                return _PyInner.dumpData$13(frame);
                case 13:
                return _PyInner.dumpTransformedObject$14(frame);
                case 14:
                return _PyInner.dumpRawObject$15(frame);
                case 15:
                return _PyInner.dumpDict$16(frame);
                case 16:
                return _PyInner.dumpKey$17(frame);
                case 17:
                return _PyInner.dumpList$18(frame);
                case 18:
                return _PyInner.dumpScalar$19(frame);
                case 19:
                return _PyInner.dumpMultiLineScalar$20(frame);
                case 20:
                return _PyInner.raiseToYamlSyntaxError$21(frame);
                case 21:
                return _PyInner.Dumper$22(frame);
                case 22:
                return _PyInner.accumulate$23(frame);
                case 23:
                return _PyInner.__init__$24(frame);
                case 24:
                return _PyInner.shouldAnchor$25(frame);
                case 25:
                return _PyInner.isAlias$26(frame);
                case 26:
                return _PyInner.YamlAnchors$27(frame);
                case 27:
                return _PyInner.sort_keys$28(frame);
                case 28:
                return _PyInner.sortMethod$29(frame);
                case 29:
                return _PyInner.quote$30(frame);
                case 30:
                return _PyInner.needsSingleQuote$31(frame);
                case 31:
                return _PyInner.hasSpecialChar$32(frame);
                case 32:
                return _PyInner.isMulti$33(frame);
                case 33:
                return _PyInner.cleanUnicode$34(frame);
                case 34:
                return _PyInner.main$35(frame);
                default:
                return null;
            }
        }
        
        private static PyObject __listcomprehension$1(PyFrame frame) {
            // Temporary Variables
            int t$0$int;
            PyObject t$0$PyObject, t$1$PyObject, t$2$PyObject, t$3$PyObject, t$4$PyObject;
            
            t$0$PyObject = new PyList(new PyObject[] {});
            t$1$PyObject = t$0$PyObject.__getattr__("append");
            t$0$int = 0;
            t$3$PyObject = frame.getlocal(4);
            while ((t$2$PyObject = t$3$PyObject.__finditem__(t$0$int++)) != null) {
                t$4$PyObject = t$2$PyObject;
                frame.setlocal(2, t$4$PyObject.__getitem__(0));
                frame.setlocal(6, t$4$PyObject.__getitem__(1));
                t$1$PyObject.__call__(frame.getlocal(6));
            }
            return t$0$PyObject;
        }
        
        private static PyObject dump$2(PyFrame frame) {
            return frame.getglobal("Dumper").__call__().__getattr__("dump")._callextra(new PyObject[] {}, new String[] {}, frame.getlocal(0), null);
        }
        
        private static PyObject dumpToFile$3(PyFrame frame) {
            return frame.getglobal("Dumper").__call__().__getattr__("dumpToFile")._callextra(new PyObject[] {frame.getlocal(0)}, new String[] {}, frame.getlocal(1), null);
        }
        
        private static PyObject __init__$4(PyFrame frame) {
            frame.getlocal(0).__setattr__("currIndent", s$1);
            frame.getlocal(0).__setattr__("indent", s$2);
            frame.getlocal(0).__setattr__("keysrt", frame.getglobal("None"));
            return Py.None;
        }
        
        private static PyObject setIndent$5(PyFrame frame) {
            frame.getlocal(0).__setattr__("indent", frame.getlocal(1));
            return frame.getlocal(0);
        }
        
        private static PyObject setSort$6(PyFrame frame) {
            frame.getlocal(0).__setattr__("keysrt", frame.getglobal("sortMethod").__call__(frame.getlocal(1)));
            return frame.getlocal(0);
        }
        
        private static PyObject lambda$7(PyFrame frame) {
            return frame.getlocal(1).invoke("append", frame.getlocal(0));
        }
        
        private static PyObject dump$8(PyFrame frame) {
            frame.setlocal(2, new PyList(new PyObject[] {}));
            frame.getlocal(0).__setattr__("output", new PyFunction(frame.f_globals, new PyObject[] {frame.getlocal(2)}, c$5_lambda));
            frame.getlocal(0).invoke("dumpDocuments", frame.getlocal(1));
            return frame.getglobal("string").__getattr__("join").__call__(frame.getlocal(2), s$3);
        }
        
        private static PyObject lambda$9(PyFrame frame) {
            return frame.getlocal(1).invoke("write", frame.getlocal(0));
        }
        
        private static PyObject dumpToFile$10(PyFrame frame) {
            frame.getlocal(0).__setattr__("output", new PyFunction(frame.f_globals, new PyObject[] {frame.getlocal(1)}, c$7_lambda));
            frame.getlocal(0).invoke("dumpDocuments", frame.getlocal(2));
            return Py.None;
        }
        
        private static PyObject dumpDocuments$11(PyFrame frame) {
            // Temporary Variables
            int t$0$int;
            PyObject t$0$PyObject, t$1$PyObject;
            
            // Code
            t$0$int = 0;
            t$1$PyObject = frame.getlocal(1);
            while ((t$0$PyObject = t$1$PyObject.__finditem__(t$0$int++)) != null) {
                frame.setlocal(2, t$0$PyObject);
                frame.getlocal(0).__setattr__("anchors", frame.getglobal("YamlAnchors").__call__(frame.getlocal(2)));
                frame.getlocal(0).invoke("output", s$4);
                frame.getlocal(0).invoke("dumpData", frame.getlocal(2));
                frame.getlocal(0).invoke("output", s$1);
            }
            return Py.None;
        }
        
        private static PyObject indentDump$12(PyFrame frame) {
            // Temporary Variables
            PyObject t$0$PyObject, t$1$PyObject;
            
            // Code
            frame.setlocal(2, frame.getlocal(0).__getattr__("currIndent"));
            t$0$PyObject = frame.getlocal(0).__getattr__("indent");
            t$1$PyObject = frame.getlocal(0);
            t$1$PyObject.__setattr__("currIndent", t$1$PyObject.__getattr__("currIndent").__iadd__(t$0$PyObject));
            frame.getlocal(0).invoke("dumpData", frame.getlocal(1));
            frame.getlocal(0).__setattr__("currIndent", frame.getlocal(2));
            return Py.None;
        }
        
        private static PyObject dumpData$13(PyFrame frame) {
            frame.setlocal(2, frame.getlocal(0).__getattr__("anchors").invoke("shouldAnchor", frame.getlocal(1)));
            if (frame.getlocal(2).__nonzero__()) {
                frame.getlocal(0).invoke("output", s$5._mod(frame.getlocal(2)));
            }
            else {
                frame.setlocal(2, frame.getlocal(0).__getattr__("anchors").invoke("isAlias", frame.getlocal(1)));
                if (frame.getlocal(2).__nonzero__()) {
                    frame.getlocal(0).invoke("output", s$6._mod(frame.getlocal(2)));
                    return Py.None;
                }
            }
            if (frame.getlocal(1)._is(frame.getglobal("None")).__nonzero__()) {
                frame.getlocal(0).invoke("output", s$7);
            }
            else if (frame.getglobal("hasMethod").__call__(frame.getlocal(1), s$8).__nonzero__()) {
                frame.getlocal(0).invoke("dumpTransformedObject", frame.getlocal(1));
            }
            else if (frame.getglobal("hasMethod").__call__(frame.getlocal(1), s$9).__nonzero__()) {
                frame.getlocal(0).invoke("output", s$10._add(frame.getlocal(1).invoke("to_yaml_implicit")));
            }
            else if (frame.getglobal("type").__call__(frame.getlocal(1))._is(frame.getglobal("InstanceType")).__nonzero__()) {
                frame.getlocal(0).invoke("dumpRawObject", frame.getlocal(1));
            }
            else if (frame.getglobal("type").__call__(frame.getlocal(1))._is(frame.getglobal("DictType")).__nonzero__()) {
                frame.getlocal(0).invoke("dumpDict", frame.getlocal(1));
            }
            else if (frame.getglobal("type").__call__(frame.getlocal(1))._in(new PyList(new PyObject[] {frame.getglobal("ListType"), frame.getglobal("TupleType")})).__nonzero__()) {
                frame.getlocal(0).invoke("dumpList", frame.getlocal(1));
            }
            else {
                frame.getlocal(0).invoke("dumpScalar", frame.getlocal(1));
            }
            return Py.None;
        }
        
        private static PyObject dumpTransformedObject$14(PyFrame frame) {
            // Temporary Variables
            PyObject t$0$PyObject;
            
            // Code
            frame.setlocal(3, frame.getlocal(1).invoke("to_yaml"));
            if (frame.getglobal("type").__call__(frame.getlocal(3))._isnot(frame.getglobal("TupleType")).__nonzero__()) {
                frame.getlocal(0).invoke("raiseToYamlSyntaxError");
            }
            t$0$PyObject = frame.getlocal(3);
            frame.setlocal(1, t$0$PyObject.__getitem__(0));
            frame.setlocal(2, t$0$PyObject.__getitem__(1));
            if (frame.getlocal(2).__nonzero__()) {
                frame.getlocal(0).invoke("output", s$10._add(frame.getlocal(2)));
            }
            frame.getlocal(0).invoke("dumpData", frame.getlocal(1));
            return Py.None;
        }
        
        private static PyObject dumpRawObject$15(PyFrame frame) {
            frame.getlocal(0).invoke("output", s$11._mod(new PyTuple(new PyObject[] {frame.getlocal(1).__getattr__("__module__"), frame.getlocal(1).__getattr__("__class__").__getattr__("__name__")})));
            frame.getlocal(0).invoke("dumpData", frame.getlocal(1).__getattr__("__dict__"));
            return Py.None;
        }
        
        private static PyObject dumpDict$16(PyFrame frame) {
            // Temporary Variables
            int t$0$int;
            PyObject t$0$PyObject, t$1$PyObject;
            
            // Code
            frame.setlocal(3, frame.getlocal(1).invoke("keys"));
            if (frame.getglobal("len").__call__(frame.getlocal(3))._eq(i$12).__nonzero__()) {
                frame.getlocal(0).invoke("output", s$13);
                return Py.None;
            }
            if (frame.getlocal(0).__getattr__("keysrt").__nonzero__()) {
                frame.setlocal(3, frame.getglobal("sort_keys").__call__(frame.getlocal(3), frame.getlocal(0).__getattr__("keysrt")));
            }
            else {
                frame.getlocal(3).invoke("sort");
            }
            t$0$int = 0;
            t$1$PyObject = frame.getlocal(3);
            while ((t$0$PyObject = t$1$PyObject.__finditem__(t$0$int++)) != null) {
                frame.setlocal(2, t$0$PyObject);
                frame.getlocal(0).invoke("output", frame.getlocal(0).__getattr__("currIndent"));
                frame.getlocal(0).invoke("dumpKey", frame.getlocal(2));
                frame.getlocal(0).invoke("output", s$14);
                frame.getlocal(0).invoke("indentDump", frame.getlocal(1).__getitem__(frame.getlocal(2)));
            }
            return Py.None;
        }
        
        private static PyObject dumpKey$17(PyFrame frame) {
            if (frame.getglobal("type").__call__(frame.getlocal(1))._is(frame.getglobal("TupleType")).__nonzero__()) {
                frame.getlocal(0).invoke("output", s$15);
                frame.getlocal(0).invoke("indentDump", frame.getlocal(1));
                frame.getlocal(0).invoke("output", s$1);
            }
            else {
                frame.getlocal(0).invoke("output", frame.getglobal("quote").__call__(frame.getlocal(1)));
            }
            return Py.None;
        }
        
        private static PyObject dumpList$18(PyFrame frame) {
            // Temporary Variables
            int t$0$int;
            PyObject t$0$PyObject, t$1$PyObject;
            
            // Code
            if (frame.getglobal("len").__call__(frame.getlocal(1))._eq(i$12).__nonzero__()) {
                frame.getlocal(0).invoke("output", s$16);
                return Py.None;
            }
            t$0$int = 0;
            t$1$PyObject = frame.getlocal(1);
            while ((t$0$PyObject = t$1$PyObject.__finditem__(t$0$int++)) != null) {
                frame.setlocal(2, t$0$PyObject);
                frame.getlocal(0).invoke("output", frame.getlocal(0).__getattr__("currIndent"));
                frame.getlocal(0).invoke("output", s$17);
                frame.getlocal(0).invoke("indentDump", frame.getlocal(2));
            }
            return Py.None;
        }
        
        private static PyObject dumpScalar$19(PyFrame frame) {
            frame.setlocal(1, frame.getglobal("cleanUnicode").__call__(frame.getlocal(1)));
            if (frame.getglobal("isMulti").__call__(frame.getlocal(1)).__nonzero__()) {
                frame.getlocal(0).invoke("dumpMultiLineScalar", frame.getlocal(1).invoke("splitlines"));
            }
            else {
                frame.getlocal(0).invoke("output", s$10);
                frame.getlocal(0).invoke("output", frame.getglobal("quote").__call__(frame.getlocal(1)));
            }
            return Py.None;
        }
        
        private static PyObject dumpMultiLineScalar$20(PyFrame frame) {
            // Temporary Variables
            int t$0$int;
            PyObject t$0$PyObject, t$1$PyObject;
            
            // Code
            frame.getlocal(0).invoke("output", s$18);
            t$0$int = 0;
            t$1$PyObject = frame.getlocal(1);
            while ((t$0$PyObject = t$1$PyObject.__finditem__(t$0$int++)) != null) {
                frame.setlocal(2, t$0$PyObject);
                frame.getlocal(0).invoke("output", frame.getlocal(0).__getattr__("currIndent"));
                frame.getlocal(0).invoke("output", frame.getlocal(2));
            }
            return Py.None;
        }
        
        private static PyObject raiseToYamlSyntaxError$21(PyFrame frame) {
            throw Py.makeException(s$19);
        }
        
        private static PyObject Dumper$22(PyFrame frame) {
            frame.setlocal("__init__", new PyFunction(frame.f_globals, new PyObject[] {}, c$2___init__));
            frame.setlocal("setIndent", new PyFunction(frame.f_globals, new PyObject[] {}, c$3_setIndent));
            frame.setlocal("setSort", new PyFunction(frame.f_globals, new PyObject[] {}, c$4_setSort));
            frame.setlocal("dump", new PyFunction(frame.f_globals, new PyObject[] {}, c$6_dump));
            frame.setlocal("dumpToFile", new PyFunction(frame.f_globals, new PyObject[] {}, c$8_dumpToFile));
            frame.setlocal("dumpDocuments", new PyFunction(frame.f_globals, new PyObject[] {}, c$9_dumpDocuments));
            frame.setlocal("indentDump", new PyFunction(frame.f_globals, new PyObject[] {}, c$10_indentDump));
            frame.setlocal("dumpData", new PyFunction(frame.f_globals, new PyObject[] {}, c$11_dumpData));
            frame.setlocal("dumpTransformedObject", new PyFunction(frame.f_globals, new PyObject[] {}, c$12_dumpTransformedObject));
            frame.setlocal("dumpRawObject", new PyFunction(frame.f_globals, new PyObject[] {}, c$13_dumpRawObject));
            frame.setlocal("dumpDict", new PyFunction(frame.f_globals, new PyObject[] {}, c$14_dumpDict));
            frame.setlocal("dumpKey", new PyFunction(frame.f_globals, new PyObject[] {}, c$15_dumpKey));
            frame.setlocal("dumpList", new PyFunction(frame.f_globals, new PyObject[] {}, c$16_dumpList));
            frame.setlocal("dumpScalar", new PyFunction(frame.f_globals, new PyObject[] {}, c$17_dumpScalar));
            frame.setlocal("dumpMultiLineScalar", new PyFunction(frame.f_globals, new PyObject[] {}, c$18_dumpMultiLineScalar));
            frame.setlocal("raiseToYamlSyntaxError", new PyFunction(frame.f_globals, new PyObject[] {}, c$19_raiseToYamlSyntaxError));
            return frame.getf_locals();
        }
        
        private static PyObject accumulate$23(PyFrame frame) {
            // Temporary Variables
            int t$0$int, t$1$int;
            PyObject t$0$PyObject, t$1$PyObject, t$2$PyObject, t$3$PyObject, t$4$PyObject;
            
            // Code
            frame.setlocal(2, frame.getglobal("type").__call__(frame.getlocal(0)));
            if (((t$0$PyObject = ((t$1$PyObject = ((t$2$PyObject = frame.getlocal(0)._is(frame.getglobal("None"))).__nonzero__() ? t$2$PyObject : frame.getlocal(2)._is(frame.getglobal("IntType")))).__nonzero__() ? t$1$PyObject : frame.getlocal(2)._is(frame.getglobal("FloatType")))).__nonzero__() ? t$0$PyObject : ((t$1$PyObject = ((t$2$PyObject = frame.getlocal(2)._is(frame.getglobal("StringType"))).__nonzero__() ? t$2$PyObject : frame.getlocal(2)._is(frame.getglobal("UnicodeType")))).__nonzero__() ? frame.getglobal("len").__call__(frame.getlocal(0))._lt(i$20) : t$1$PyObject)).__nonzero__()) {
                return Py.None;
            }
            frame.setlocal(3, frame.getglobal("id").__call__(frame.getlocal(0)));
            if (i$12._eq(frame.getlocal(1).invoke("get", frame.getlocal(3), i$12)).__nonzero__()) {
                frame.getlocal(1).__setitem__(frame.getlocal(3), i$21);
                if (frame.getlocal(2)._is(frame.getglobal("ListType")).__nonzero__()) {
                    t$0$int = 0;
                    t$1$PyObject = frame.getlocal(0);
                    while ((t$0$PyObject = t$1$PyObject.__finditem__(t$0$int++)) != null) {
                        frame.setlocal(5, t$0$PyObject);
                        frame.getglobal("accumulate").__call__(frame.getlocal(5), frame.getlocal(1));
                    }
                }
                if (frame.getlocal(2)._is(frame.getglobal("DictType")).__nonzero__()) {
                    t$1$int = 0;
                    t$3$PyObject = frame.getlocal(0).invoke("items");
                    while ((t$2$PyObject = t$3$PyObject.__finditem__(t$1$int++)) != null) {
                        t$4$PyObject = t$2$PyObject;
                        frame.setlocal(5, t$4$PyObject.__getitem__(0));
                        frame.setlocal(4, t$4$PyObject.__getitem__(1));
                        frame.getglobal("accumulate").__call__(frame.getlocal(5), frame.getlocal(1));
                        frame.getglobal("accumulate").__call__(frame.getlocal(4), frame.getlocal(1));
                    }
                }
            }
            else {
                frame.getlocal(1).__setitem__(frame.getlocal(3), frame.getlocal(1).__getitem__(frame.getlocal(3))._add(i$21));
            }
            return Py.None;
        }
        
        private static PyObject __init__$24(PyFrame frame) {
            // Temporary Variables
            int t$0$int;
            PyObject t$0$PyObject, t$1$PyObject, t$2$PyObject;
            
            // Code
            frame.setlocal(3, new PyDictionary(new PyObject[] {}));
            frame.getglobal("accumulate").__call__(frame.getlocal(1), frame.getlocal(3));
            frame.setlocal(4, new PyDictionary(new PyObject[] {}));
            t$0$int = 0;
            t$1$PyObject = frame.getlocal(3).invoke("items");
            while ((t$0$PyObject = t$1$PyObject.__finditem__(t$0$int++)) != null) {
                t$2$PyObject = t$0$PyObject;
                frame.setlocal(2, t$2$PyObject.__getitem__(0));
                frame.setlocal(3, t$2$PyObject.__getitem__(1));
                if (frame.getlocal(3)._gt(i$21).__nonzero__()) {
                    frame.getlocal(4).__setitem__(frame.getlocal(2), i$12);
                }
            }
            frame.getlocal(0).__setattr__("_anchorVisits", frame.getlocal(4));
            frame.getlocal(0).__setattr__("_currentAliasIndex", i$12);
            return Py.None;
        }
        
        private static PyObject shouldAnchor$25(PyFrame frame) {
            frame.setlocal(2, frame.getlocal(0).__getattr__("_anchorVisits").invoke("get", frame.getglobal("id").__call__(frame.getlocal(1)), frame.getglobal("None")));
            if (i$12._eq(frame.getlocal(2)).__nonzero__()) {
                frame.getlocal(0).__setattr__("_currentAliasIndex", frame.getlocal(0).__getattr__("_currentAliasIndex")._add(i$21));
                frame.setlocal(2, frame.getlocal(0).__getattr__("_currentAliasIndex"));
                frame.getlocal(0).__getattr__("_anchorVisits").__setitem__(frame.getglobal("id").__call__(frame.getlocal(1)), frame.getlocal(2));
                return frame.getlocal(2);
            }
            return i$12;
        }
        
        private static PyObject isAlias$26(PyFrame frame) {
            return frame.getlocal(0).__getattr__("_anchorVisits").invoke("get", frame.getglobal("id").__call__(frame.getlocal(1)), i$12);
        }
        
        private static PyObject YamlAnchors$27(PyFrame frame) {
            frame.setlocal("__init__", new PyFunction(frame.f_globals, new PyObject[] {}, c$22___init__));
            frame.setlocal("shouldAnchor", new PyFunction(frame.f_globals, new PyObject[] {}, c$23_shouldAnchor));
            frame.setlocal("isAlias", new PyFunction(frame.f_globals, new PyObject[] {}, c$24_isAlias));
            return frame.getf_locals();
        }
        
        private static PyObject sort_keys$28(PyFrame frame) {
            // Temporary Variables
            int t$0$int;
            PyObject t$0$PyObject, t$1$PyObject;
            
            // Code
            frame.setlocal(4, new PyList(new PyObject[] {}));
            t$0$int = 0;
            t$1$PyObject = frame.getlocal(0);
            while ((t$0$PyObject = t$1$PyObject.__finditem__(t$0$int++)) != null) {
                frame.setlocal(3, t$0$PyObject);
                frame.setlocal(5, frame.getlocal(1).__call__(frame.getlocal(3)));
                if (frame.getlocal(5)._is(frame.getglobal("None")).__nonzero__()) {
                    frame.setlocal(5, s$22);
                }
                frame.getlocal(4).invoke("append", new PyTuple(new PyObject[] {frame.getlocal(5), frame.getlocal(3)}));
            }
            frame.getlocal(4).invoke("sort");
            return __listcomprehension$1(frame);
        }
        
        private static PyObject sortMethod$29(PyFrame frame) {
            // Temporary Variables
            int t$0$int;
            PyObject t$0$PyObject, t$1$PyObject, t$2$PyObject;
            
            // Code
            frame.setlocal(1, frame.getglobal("type").__call__(frame.getlocal(0)));
            if (frame.getglobal("DictType")._eq(frame.getlocal(1)).__nonzero__()) {
                return frame.getlocal(0).__getattr__("get");
            }
            else if (((t$0$PyObject = frame.getglobal("ListType")._eq(frame.getlocal(1))).__nonzero__() ? t$0$PyObject : frame.getglobal("TupleType")._eq(frame.getlocal(1))).__nonzero__()) {
                frame.setlocal(2, new PyDictionary(new PyObject[] {}));
                frame.setlocal(3, i$12);
                t$0$int = 0;
                t$1$PyObject = frame.getlocal(0);
                while ((t$0$PyObject = t$1$PyObject.__finditem__(t$0$int++)) != null) {
                    frame.setlocal(4, t$0$PyObject);
                    frame.getlocal(2).__setitem__(frame.getlocal(4), frame.getlocal(3));
                    t$2$PyObject = i$21;
                    frame.setlocal(3, frame.getlocal(3).__iadd__(t$2$PyObject));
                }
                return frame.getlocal(2).__getattr__("get");
            }
            else {
                return frame.getlocal(0);
            }
        }
        
        private static PyObject quote$30(PyFrame frame) {
            // Temporary Variables
            PyObject t$0$PyObject;
            
            // Code
            if (frame.getglobal("type").__call__(frame.getlocal(0))._ne(frame.getglobal("str")).__nonzero__()) {
                return frame.getglobal("str").__call__(frame.getlocal(0));
            }
            frame.setlocal(2, s$23);
            frame.setlocal(3, s$24);
            frame.setlocal(1, s$3);
            if (frame.getglobal("len").__call__(frame.getlocal(0))._eq(i$12).__nonzero__()) {
                return s$25;
            }
            if (((t$0$PyObject = frame.getglobal("hasSpecialChar").__call__(frame.getlocal(0))).__nonzero__() ? t$0$PyObject : frame.getlocal(0).__getitem__(i$12)._eq(frame.getlocal(2))).__nonzero__()) {
                frame.setlocal(0, frame.getlocal(0).__repr__().__getslice__(i$21, i$21.__neg__(), null));
                frame.setlocal(0, frame.getglobal("string").__getattr__("replace").__call__(frame.getlocal(0), s$26, s$27));
                frame.setlocal(1, frame.getlocal(3));
            }
            if (frame.getglobal("needsSingleQuote").__call__(frame.getlocal(0)).__nonzero__()) {
                frame.setlocal(1, frame.getlocal(2));
            }
            return s$28._mod(new PyTuple(new PyObject[] {frame.getlocal(1), frame.getlocal(0), frame.getlocal(1)}));
        }
        
        private static PyObject needsSingleQuote$31(PyFrame frame) {
            // Temporary Variables
            PyObject t$0$PyObject;
            
            // Code
            if (frame.getglobal("re").__getattr__("match").__call__(s$29, frame.getlocal(0)).__nonzero__()) {
                return i$21;
            }
            return (t$0$PyObject = frame.getglobal("re").__getattr__("search").__call__(s$30, frame.getlocal(0))).__nonzero__() ? t$0$PyObject : frame.getglobal("re").__getattr__("search").__call__(s$31, frame.getlocal(0));
        }
        
        private static PyObject hasSpecialChar$32(PyFrame frame) {
            return frame.getglobal("re").__getattr__("search").__call__(s$32, frame.getlocal(0));
        }
        
        private static PyObject isMulti$33(PyFrame frame) {
            if (frame.getglobal("type").__call__(frame.getlocal(0))._is(frame.getglobal("str")).__not__().__nonzero__()) {
                return i$12;
            }
            if (frame.getglobal("hasSpecialChar").__call__(frame.getlocal(0)).__nonzero__()) {
                return i$12;
            }
            return frame.getglobal("re").__getattr__("search").__call__(s$1, frame.getlocal(0));
        }
        
        private static PyObject cleanUnicode$34(PyFrame frame) {
            // Temporary Variables
            PyObject t$0$PyObject;
            
            // Code
            if (((t$0$PyObject = frame.getglobal("hasUnicode")).__nonzero__() ? frame.getglobal("type").__call__(frame.getlocal(0))._eq(frame.getglobal("unicode")) : t$0$PyObject).__nonzero__()) {
                return s$24._add(frame.getlocal(0).invoke("__repr__").__getslice__(i$33, i$21.__neg__(), null))._add(s$24);
            }
            return frame.getlocal(0);
        }
        
        private static PyObject main$35(PyFrame frame) {
            frame.setglobal("__file__", s$34);
            
            PyObject[] imp_accu;
            // Temporary Variables
            PyException t$0$PyException;
            
            // Code
            frame.setlocal("types", org.python.core.imp.importOne("types", frame));
            frame.setlocal("string", org.python.core.imp.importOne("string", frame));
            imp_accu = org.python.core.imp.importFrom("types", new String[] {"StringType", "IntType", "FloatType"}, frame);
            frame.setlocal("StringType", imp_accu[0]);
            frame.setlocal("IntType", imp_accu[1]);
            frame.setlocal("FloatType", imp_accu[2]);
            imp_accu = org.python.core.imp.importFrom("types", new String[] {"DictType", "ListType", "TupleType", "InstanceType"}, frame);
            frame.setlocal("DictType", imp_accu[0]);
            frame.setlocal("ListType", imp_accu[1]);
            frame.setlocal("TupleType", imp_accu[2]);
            frame.setlocal("InstanceType", imp_accu[3]);
            imp_accu = org.python.core.imp.importFrom("yaml.klass", new String[] {"hasMethod"}, frame);
            frame.setlocal("hasMethod", imp_accu[0]);
            frame.setlocal("re", org.python.core.imp.importOne("re", frame));
            /* 
              The methods from this module that are exported to the top 
              level yaml package should remain stable.  If you call
              directly into other methods of this module, be aware that 
              they may change or go away in future implementations.
              Contact the authors if there are methods in this file 
              that you wish to remain stable.
             */
            frame.setlocal("dump", new PyFunction(frame.f_globals, new PyObject[] {}, c$0_dump));
            frame.setlocal("dumpToFile", new PyFunction(frame.f_globals, new PyObject[] {}, c$1_dumpToFile));
            frame.setlocal("Dumper", Py.makeClass("Dumper", new PyObject[] {}, c$20_Dumper, null));
            frame.setlocal("accumulate", new PyFunction(frame.f_globals, new PyObject[] {}, c$21_accumulate));
            frame.setlocal("YamlAnchors", Py.makeClass("YamlAnchors", new PyObject[] {}, c$25_YamlAnchors, null));
            frame.setlocal("sort_keys", new PyFunction(frame.f_globals, new PyObject[] {}, c$26_sort_keys));
            frame.setlocal("sortMethod", new PyFunction(frame.f_globals, new PyObject[] {}, c$27_sortMethod));
            frame.setlocal("quote", new PyFunction(frame.f_globals, new PyObject[] {}, c$28_quote));
            frame.setlocal("needsSingleQuote", new PyFunction(frame.f_globals, new PyObject[] {}, c$29_needsSingleQuote));
            frame.setlocal("hasSpecialChar", new PyFunction(frame.f_globals, new PyObject[] {}, c$30_hasSpecialChar));
            frame.setlocal("isMulti", new PyFunction(frame.f_globals, new PyObject[] {}, c$31_isMulti));
            try {
                imp_accu = org.python.core.imp.importFrom("types", new String[] {"UnicodeType"}, frame);
                frame.setlocal("UnicodeType", imp_accu[0]);
                frame.setlocal("hasUnicode", i$21);
            }
            catch (Throwable x$0) {
                t$0$PyException = Py.setException(x$0, frame);
                frame.setlocal("hasUnicode", i$12);
                frame.setlocal("UnicodeType", frame.getname("StringType"));
            }
            frame.setlocal("cleanUnicode", new PyFunction(frame.f_globals, new PyObject[] {}, c$32_cleanUnicode));
            return Py.None;
        }
        
    }
    public static void moduleDictInit(PyObject dict) {
        dict.__setitem__("__name__", new PyString("dump"));
        Py.runCode(new _PyInner().getMain(), dict, dict);
    }
    
    public static void main(String[] args) throws Exception {
        String[] newargs = new String[args.length+1];
        newargs[0] = "dump";
        System.arraycopy(args, 0, newargs, 1, args.length);
        Py.runMain(dump._PyInner.class/*"yaml.dump$_PyInner"*/, newargs, jpy$packages, jpy$properties, "yaml", new String[] {"socket", "ftplib", "yaml.klass", "yaml.__init__", "dummy", "macurl2path", "rfc822", "string", "yaml.inline", "yaml.dump", "tempfile", "yaml.load", "base64", "sre", "StringIO", "copy_reg", "random", "getopt", "nturl2path", "httplib", "mimetools", "sre_parse", "sre_compile", "quopri", "yaml.implicit", "sre_constants", "javapath", "yaml.ypath", "urllib", "re", "mimetypes", "posixpath", "errno", "gopherlib", "yaml.stream", "stat", "yaml.timestamp", "javaos"});
    }
    
}
