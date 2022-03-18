package tripleo.impohrt.pyyaml;

import org.python.core.*;

public class __init__ extends java.lang.Object {
    static String[] jpy$properties = new String[] {"python.modules.builtin", "exceptions:org.python.core.exceptions", "python.options.showJavaExceptions", "true"};
    static String[] jpy$packages = new String[] {"org.python.core", null, "java.lang", null, "java.io", null, "java.net", null};
    
    public static class _PyInner extends PyFunctionTable implements PyRunnable {
        private static PyObject s$0;
        private static PyObject s$1;
        private static PyObject s$2;
        private static PyObject s$3;
        private static PyFunctionTable funcTable;
        private static PyCode c$0_ypath;
        private static PyCode c$1_main;
        private static void initConstants() {
            s$0 = Py.newString("0.25");
            s$1 = Py.newString("ypath requires Python 2.2");
            s$2 = Py.newString("");
            s$3 = Py.newString("/local/src/i/Rabbit3/runtime/py-lib/yaml/__init__.py");
            funcTable = new _PyInner();
            c$0_ypath = Py.newCode(3, new String[] {"expr", "target", "cntx"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/__init__.py", "ypath", false, false, funcTable, 0, null, null, 0, 1);
            c$1_main = Py.newCode(0, new String[] {}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/__init__.py", "main", false, false, funcTable, 1, null, null, 0, 0);
        }
        
        
        public PyCode getMain() {
            if (c$1_main == null) _PyInner.initConstants();
            return c$1_main;
        }
        
        public PyObject call_function(int index, PyFrame frame) {
            switch (index){
                case 0:
                return _PyInner.ypath$1(frame);
                case 1:
                return _PyInner.main$2(frame);
                default:
                return null;
            }
        }
        
        private static PyObject ypath$1(PyFrame frame) {
            throw Py.makeException(frame.getglobal("NotImplementedError").__call__(s$1));
        }
        
        private static PyObject main$2(PyFrame frame) {
            frame.setglobal("__file__", s$3);
            
            PyObject[] imp_accu;
            // Temporary Variables
            PyException t$0$PyException;
            
            // Code
            frame.setlocal("__version__", s$0);
            imp_accu = org.python.core.imp.importFrom("load", new String[] {"loadFile"}, frame);
            frame.setlocal("loadFile", imp_accu[0]);
            imp_accu = org.python.core.imp.importFrom("load", new String[] {"load"}, frame);
            frame.setlocal("load", imp_accu[0]);
            imp_accu = org.python.core.imp.importFrom("dump", new String[] {"dump"}, frame);
            frame.setlocal("dump", imp_accu[0]);
            imp_accu = org.python.core.imp.importFrom("dump", new String[] {"dumpToFile"}, frame);
            frame.setlocal("dumpToFile", imp_accu[0]);
            imp_accu = org.python.core.imp.importFrom("dump", new String[] {"Dumper"}, frame);
            frame.setlocal("Dumper", imp_accu[0]);
            imp_accu = org.python.core.imp.importFrom("timestamp", new String[] {"timestamp"}, frame);
            frame.setlocal("timestamp", imp_accu[0]);
            try {
                imp_accu = org.python.core.imp.importFrom("ypath", new String[] {"ypath"}, frame);
                frame.setlocal("ypath", imp_accu[0]);
            }
            catch (Throwable x$0) {
                t$0$PyException = Py.setException(x$0, frame);
                if (Py.matchException(t$0$PyException, frame.getname("NameError"))) {
                    frame.setlocal("ypath", new PyFunction(frame.f_globals, new PyObject[] {s$2, s$2}, c$0_ypath));
                }
                else throw t$0$PyException;
            }
            return Py.None;
        }
        
    }
    public static void moduleDictInit(PyObject dict) {
        dict.__setitem__("__name__", new PyString("__init__"));
        Py.runCode(new _PyInner().getMain(), dict, dict);
    }
    
    public static void main(String[] args) throws Exception {
        String[] newargs = new String[args.length+1];
        newargs[0] = "__init__";
        System.arraycopy(args, 0, newargs, 1, args.length);
        Py.runMain(__init__._PyInner.class, newargs, jpy$packages, jpy$properties, "yaml", new String[] {"socket", "ftplib", "yaml.klass", "yaml.__init__", "dummy", "macurl2path", "rfc822", "string", "yaml.inline", "yaml.dump", "tempfile", "yaml.load", "base64", "sre", "StringIO", "copy_reg", "random", "getopt", "nturl2path", "httplib", "mimetools", "sre_parse", "sre_compile", "quopri", "yaml.implicit", "sre_constants", "javapath", "yaml.ypath", "urllib", "re", "mimetypes", "posixpath", "errno", "gopherlib", "yaml.stream", "stat", "yaml.timestamp", "javaos"});
    }
    
}
