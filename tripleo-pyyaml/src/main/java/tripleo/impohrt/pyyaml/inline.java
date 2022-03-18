package tripleo.impohrt.pyyaml;

import org.python.core.*;

public class inline extends java.lang.Object {
    static String[] jpy$properties = new String[] {"python.modules.builtin", "exceptions:org.python.core.exceptions", "python.options.showJavaExceptions", "true"};
    static String[] jpy$packages = new String[] {"org.python.core", null, "java.lang", null, "java.io", null, "java.net", null};
    
    public static class _PyInner extends PyFunctionTable implements PyRunnable {
        private static PyObject s$0;
        private static PyObject s$1;
        private static PyObject s$2;
        private static PyObject s$3;
        private static PyObject i$4;
        private static PyObject i$5;
        private static PyObject s$6;
        private static PyObject s$7;
        private static PyObject s$8;
        private static PyFunctionTable funcTable;
        private static PyCode c$0___init__;
        private static PyCode c$1_punctuation;
        private static PyCode c$2_up_to_comma;
        private static PyCode c$3_up_to_end_brace;
        private static PyCode c$4_next;
        private static PyCode c$5_InlineTokenizer;
        private static PyCode c$6_main;
        private static void initConstants() {
            s$0 = Py.newString("[");
            s$1 = Py.newString("]");
            s$2 = Py.newString("{");
            s$3 = Py.newString("}");
            i$4 = Py.newInteger(0);
            i$5 = Py.newInteger(1);
            s$6 = Py.newString("(.*?)\\s*, (.*)");
            s$7 = Py.newString("(.*?)(\\s*[\\]}].*)");
            s$8 = Py.newString("/local/src/i/Rabbit3/runtime/py-lib/yaml/inline.py");
            funcTable = new _PyInner();
            c$0___init__ = Py.newCode(2, new String[] {"self", "data"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/inline.py", "__init__", false, false, funcTable, 0, null, null, 0, 1);
            c$1_punctuation = Py.newCode(1, new String[] {"self", "puncts", "punct"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/inline.py", "punctuation", false, false, funcTable, 1, null, null, 0, 1);
            c$2_up_to_comma = Py.newCode(1, new String[] {"self", "match"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/inline.py", "up_to_comma", false, false, funcTable, 2, null, null, 0, 1);
            c$3_up_to_end_brace = Py.newCode(1, new String[] {"self", "match"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/inline.py", "up_to_end_brace", false, false, funcTable, 3, null, null, 0, 1);
            c$4_next = Py.newCode(1, new String[] {"self", "productions", "token", "production"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/inline.py", "next", false, false, funcTable, 4, null, null, 0, 1);
            c$5_InlineTokenizer = Py.newCode(0, new String[] {}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/inline.py", "InlineTokenizer", false, false, funcTable, 5, null, null, 0, 0);
            c$6_main = Py.newCode(0, new String[] {}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/inline.py", "main", false, false, funcTable, 6, null, null, 0, 0);
        }
        
        
        public PyCode getMain() {
            if (c$6_main == null) _PyInner.initConstants();
            return c$6_main;
        }
        
        public PyObject call_function(int index, PyFrame frame) {
            switch (index){
                case 0:
                return _PyInner.__init__$1(frame);
                case 1:
                return _PyInner.punctuation$2(frame);
                case 2:
                return _PyInner.up_to_comma$3(frame);
                case 3:
                return _PyInner.up_to_end_brace$4(frame);
                case 4:
                return _PyInner.next$5(frame);
                case 5:
                return _PyInner.InlineTokenizer$6(frame);
                case 6:
                return _PyInner.main$7(frame);
                default:
                return null;
            }
        }
        
        private static PyObject __init__$1(PyFrame frame) {
            frame.getlocal(0).__setattr__("data", frame.getlocal(1));
            return Py.None;
        }
        
        private static PyObject punctuation$2(PyFrame frame) {
            // Temporary Variables
            int t$0$int;
            PyObject t$0$PyObject, t$1$PyObject;
            
            // Code
            frame.setlocal(1, new PyList(new PyObject[] {s$0, s$1, s$2, s$3}));
            t$0$int = 0;
            t$1$PyObject = frame.getlocal(1);
            while ((t$0$PyObject = t$1$PyObject.__finditem__(t$0$int++)) != null) {
                frame.setlocal(2, t$0$PyObject);
                if (frame.getlocal(0).__getattr__("data").__getitem__(i$4)._eq(frame.getlocal(2)).__nonzero__()) {
                    frame.getlocal(0).__setattr__("data", frame.getlocal(0).__getattr__("data").__getslice__(i$5, null, null));
                    return frame.getlocal(2);
                }
            }
            return Py.None;
        }
        
        private static PyObject up_to_comma$3(PyFrame frame) {
            frame.setlocal(1, frame.getglobal("re").__getattr__("match").__call__(s$6, frame.getlocal(0).__getattr__("data")));
            if (frame.getlocal(1).__nonzero__()) {
                frame.getlocal(0).__setattr__("data", frame.getlocal(1).invoke("groups").__getitem__(i$5));
                return frame.getlocal(1).invoke("groups").__getitem__(i$4);
            }
            return Py.None;
        }
        
        private static PyObject up_to_end_brace$4(PyFrame frame) {
            frame.setlocal(1, frame.getglobal("re").__getattr__("match").__call__(s$7, frame.getlocal(0).__getattr__("data")));
            if (frame.getlocal(1).__nonzero__()) {
                frame.getlocal(0).__setattr__("data", frame.getlocal(1).invoke("groups").__getitem__(i$5));
                return frame.getlocal(1).invoke("groups").__getitem__(i$4);
            }
            return Py.None;
        }
        
        private static PyObject next$5(PyFrame frame) {
            // Temporary Variables
            int t$0$int;
            PyObject t$0$PyObject, t$1$PyObject;
            
            // Code
            frame.getlocal(0).__setattr__("data", frame.getglobal("string").__getattr__("strip").__call__(frame.getlocal(0).__getattr__("data")));
            frame.setlocal(1, new PyList(new PyObject[] {frame.getlocal(0).__getattr__("punctuation"), frame.getlocal(0).__getattr__("up_to_comma"), frame.getlocal(0).__getattr__("up_to_end_brace")}));
            t$0$int = 0;
            t$1$PyObject = frame.getlocal(1);
            while ((t$0$PyObject = t$1$PyObject.__finditem__(t$0$int++)) != null) {
                frame.setlocal(3, t$0$PyObject);
                frame.setlocal(2, frame.getlocal(3).__call__());
                if (frame.getlocal(2).__nonzero__()) {
                    return frame.getlocal(2);
                }
            }
            return Py.None;
        }
        
        private static PyObject InlineTokenizer$6(PyFrame frame) {
            frame.setlocal("__init__", new PyFunction(frame.f_globals, new PyObject[] {}, c$0___init__));
            frame.setlocal("punctuation", new PyFunction(frame.f_globals, new PyObject[] {}, c$1_punctuation));
            frame.setlocal("up_to_comma", new PyFunction(frame.f_globals, new PyObject[] {}, c$2_up_to_comma));
            frame.setlocal("up_to_end_brace", new PyFunction(frame.f_globals, new PyObject[] {}, c$3_up_to_end_brace));
            frame.setlocal("next", new PyFunction(frame.f_globals, new PyObject[] {}, c$4_next));
            return frame.getf_locals();
        }
        
        private static PyObject main$7(PyFrame frame) {
            frame.setglobal("__file__", s$8);
            
            frame.setlocal("re", org.python.core.imp.importOne("re", frame));
            frame.setlocal("string", org.python.core.imp.importOne("string", frame));
            frame.setlocal("InlineTokenizer", Py.makeClass("InlineTokenizer", new PyObject[] {}, c$5_InlineTokenizer, null));
            return Py.None;
        }
        
    }
    public static void moduleDictInit(PyObject dict) {
        dict.__setitem__("__name__", new PyString("inline"));
        Py.runCode(new _PyInner().getMain(), dict, dict);
    }
    
    public static void main(String[] args) throws Exception {
        String[] newargs = new String[args.length+1];
        newargs[0] = "inline";
        System.arraycopy(args, 0, newargs, 1, args.length);
        Py.runMain(inline._PyInner.class, newargs, jpy$packages, jpy$properties, "yaml", new String[] {"socket", "ftplib", "yaml.klass", "yaml.__init__", "dummy", "macurl2path", "rfc822", "string", "yaml.inline", "yaml.dump", "tempfile", "yaml.load", "base64", "sre", "StringIO", "copy_reg", "random", "getopt", "nturl2path", "httplib", "mimetools", "sre_parse", "sre_compile", "quopri", "yaml.implicit", "sre_constants", "javapath", "yaml.ypath", "urllib", "re", "mimetypes", "posixpath", "errno", "gopherlib", "yaml.stream", "stat", "yaml.timestamp", "javaos"});
    }
    
}
