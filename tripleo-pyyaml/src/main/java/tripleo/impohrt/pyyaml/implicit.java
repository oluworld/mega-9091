package tripleo.impohrt.pyyaml;

import org.python.core.*;

public class implicit extends java.lang.Object {
    static String[] jpy$properties = new String[] {"python.modules.builtin", "exceptions:org.python.core.exceptions", "python.options.showJavaExceptions", "true"};
    static String[] jpy$packages = new String[] {"org.python.core", null, "java.lang", null, "java.io", null, "java.net", null};
    
    public static class _PyInner extends PyFunctionTable implements PyRunnable {
        private static PyObject s$0;
        private static PyObject s$1;
        private static PyObject i$2;
        private static PyObject s$3;
        private static PyObject i$4;
        private static PyObject s$5;
        private static PyObject s$6;
        private static PyObject s$7;
        private static PyObject s$8;
        private static PyObject s$9;
        private static PyObject s$10;
        private static PyObject s$11;
        private static PyObject s$12;
        private static PyObject s$13;
        private static PyObject i$14;
        private static PyObject s$15;
        private static PyObject i$16;
        private static PyObject s$17;
        private static PyObject s$18;
        private static PyObject s$19;
        private static PyObject s$20;
        private static PyFunctionTable funcTable;
        private static PyCode c$0_convertImplicit;
        private static PyCode c$1_cleanseNumber;
        private static PyCode c$2_main;
        private static void initConstants() {
            s$0 = Py.newString("~");
            s$1 = Py.newString("+");
            i$2 = Py.newInteger(1);
            s$3 = Py.newString("-");
            i$4 = Py.newInteger(0);
            s$5 = Py.newString("'");
            s$6 = Py.newString("''");
            s$7 = Py.newString("\"");
            s$8 = Py.newString("\\u");
            s$9 = Py.newString("u");
            s$10 = Py.newString("^[0-9]{4}-[0-9]{2}-[0-9]{2}$");
            s$11 = Py.newString("^[-+]?[0-9][0-9,]*\\.[0-9,]*$");
            s$12 = Py.newString("^[-+]?[0-9][0-9,]*\\.[0-9.]*[eE][-+][0-9]+$");
            s$13 = Py.newString("^[-+]?([0][0-7,]*)$");
            i$14 = Py.newInteger(8);
            s$15 = Py.newString("^[-+]?0x[0-9a-fA-F,]+$");
            i$16 = Py.newInteger(16);
            s$17 = Py.newString("^[-+]?(0|[1-9][0-9,]*)$");
            s$18 = Py.newString(",");
            s$19 = Py.newString("");
            s$20 = Py.newString("/local/src/i/Rabbit3/runtime/py-lib/yaml/implicit.py");
            funcTable = new _PyInner();
            c$0_convertImplicit = Py.newCode(1, new String[] {"val", "unescapedStr"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/implicit.py", "convertImplicit", false, false, funcTable, 0, null, null, 0, 1);
            c$1_cleanseNumber = Py.newCode(1, new String[] {"str"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/implicit.py", "cleanseNumber", false, false, funcTable, 1, null, null, 0, 1);
            c$2_main = Py.newCode(0, new String[] {}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/implicit.py", "main", false, false, funcTable, 2, null, null, 0, 0);
        }
        
        
        public PyCode getMain() {
            if (c$2_main == null) _PyInner.initConstants();
            return c$2_main;
        }
        
        public PyObject call_function(int index, PyFrame frame) {
            switch (index){
                case 0:
                return _PyInner.convertImplicit$1(frame);
                case 1:
                return _PyInner.cleanseNumber$2(frame);
                case 2:
                return _PyInner.main$3(frame);
                default:
                return null;
            }
        }
        
        private static PyObject convertImplicit$1(PyFrame frame) {
            // Temporary Variables
            PyObject t$0$PyObject;
            
            // Code
            if (frame.getlocal(0)._eq(s$0).__nonzero__()) {
                return frame.getglobal("None");
            }
            if (frame.getlocal(0)._eq(s$1).__nonzero__()) {
                return i$2;
            }
            if (frame.getlocal(0)._eq(s$3).__nonzero__()) {
                return i$4;
            }
            if (((t$0$PyObject = frame.getlocal(0).__getitem__(i$4)._eq(s$5)).__nonzero__() ? frame.getlocal(0).__getitem__(i$2.__neg__())._eq(s$5) : t$0$PyObject).__nonzero__()) {
                frame.setlocal(0, frame.getlocal(0).__getslice__(i$2, i$2.__neg__(), null));
                return frame.getglobal("string").__getattr__("replace").__call__(frame.getlocal(0), s$6, s$5);
            }
            if (((t$0$PyObject = frame.getlocal(0).__getitem__(i$4)._eq(s$7)).__nonzero__() ? frame.getlocal(0).__getitem__(i$2.__neg__())._eq(s$7) : t$0$PyObject).__nonzero__()) {
                if (frame.getglobal("re").__getattr__("search").__call__(s$8, frame.getlocal(0)).__nonzero__()) {
                    frame.setlocal(0, s$9._add(frame.getlocal(0)));
                }
                frame.setlocal(1, frame.getglobal("eval").__call__(frame.getlocal(0)));
                return frame.getlocal(1);
            }
            if (frame.getglobal("matchTime").__getattr__("match").__call__(frame.getlocal(0)).__nonzero__()) {
                return frame.getglobal("timestamp").__call__(frame.getlocal(0));
            }
            if (frame.getglobal("re").__getattr__("match").__call__(s$10, frame.getlocal(0)).__nonzero__()) {
                return frame.getlocal(0);
            }
            if (frame.getglobal("re").__getattr__("match").__call__(s$11, frame.getlocal(0)).__nonzero__()) {
                return frame.getglobal("float").__call__(frame.getglobal("cleanseNumber").__call__(frame.getlocal(0)));
            }
            if (frame.getglobal("re").__getattr__("match").__call__(s$12, frame.getlocal(0)).__nonzero__()) {
                return frame.getglobal("float").__call__(frame.getglobal("cleanseNumber").__call__(frame.getlocal(0)));
            }
            if (frame.getglobal("re").__getattr__("match").__call__(s$13, frame.getlocal(0)).__nonzero__()) {
                return frame.getglobal("int").__call__(frame.getlocal(0), i$14);
            }
            if (frame.getglobal("re").__getattr__("match").__call__(s$15, frame.getlocal(0)).__nonzero__()) {
                return frame.getglobal("int").__call__(frame.getlocal(0), i$16);
            }
            if (frame.getglobal("re").__getattr__("match").__call__(s$17, frame.getlocal(0)).__nonzero__()) {
                return frame.getglobal("int").__call__(frame.getglobal("cleanseNumber").__call__(frame.getlocal(0)));
            }
            return frame.getlocal(0);
        }
        
        private static PyObject cleanseNumber$2(PyFrame frame) {
            if (frame.getlocal(0).__getitem__(i$4)._eq(s$1).__nonzero__()) {
                frame.setlocal(0, frame.getlocal(0).__getslice__(i$2, null, null));
            }
            frame.setlocal(0, frame.getglobal("string").__getattr__("replace").__call__(frame.getlocal(0), s$18, s$19));
            return frame.getlocal(0);
        }
        
        private static PyObject main$3(PyFrame frame) {
            frame.setglobal("__file__", s$20);
            
            PyObject[] imp_accu;
            // Code
            frame.setlocal("re", org.python.core.imp.importOne("re", frame));
            frame.setlocal("string", org.python.core.imp.importOne("string", frame));
            imp_accu = org.python.core.imp.importFrom("timestamp", new String[] {"timestamp", "matchTime"}, frame);
            frame.setlocal("timestamp", imp_accu[0]);
            frame.setlocal("matchTime", imp_accu[1]);
            frame.setlocal("convertImplicit", new PyFunction(frame.f_globals, new PyObject[] {}, c$0_convertImplicit));
            frame.setlocal("cleanseNumber", new PyFunction(frame.f_globals, new PyObject[] {}, c$1_cleanseNumber));
            return Py.None;
        }
        
    }
    public static void moduleDictInit(PyObject dict) {
        dict.__setitem__("__name__", new PyString("implicit"));
        Py.runCode(new _PyInner().getMain(), dict, dict);
    }
    
    public static void main(String[] args) throws Exception {
        String[] newargs = new String[args.length+1];
        newargs[0] = "implicit";
        System.arraycopy(args, 0, newargs, 1, args.length);
        Py.runMain(implicit._PyInner.class, newargs, jpy$packages, jpy$properties, "yaml", new String[] {"socket", "ftplib", "yaml.klass", "yaml.__init__", "dummy", "macurl2path", "rfc822", "string", "yaml.inline", "yaml.dump", "tempfile", "yaml.load", "base64", "sre", "StringIO", "copy_reg", "random", "getopt", "nturl2path", "httplib", "mimetools", "sre_parse", "sre_compile", "quopri", "yaml.implicit", "sre_constants", "javapath", "yaml.ypath", "urllib", "re", "mimetypes", "posixpath", "errno", "gopherlib", "yaml.stream", "stat", "yaml.timestamp", "javaos"});
    }
    
}
