package tripleo.impohrt.pyyaml;

import org.python.core.*;

public class klass extends java.lang.Object {
    static String[] jpy$properties = new String[] {"python.modules.builtin", "exceptions:org.python.core.exceptions", "python.options.showJavaExceptions", "true"};
    static String[] jpy$packages = new String[] {"org.python.core", null, "java.lang", null, "java.io", null, "java.net", null};
    
    public static class _PyInner extends PyFunctionTable implements PyRunnable {
        private static PyObject s$0;
        private static PyObject s$1;
        private static PyObject s$2;
        private static PyObject s$3;
        private static PyObject s$4;
        private static PyObject i$5;
        private static PyObject i$6;
        private static PyObject s$7;
        private static PyFunctionTable funcTable;
        private static PyCode c$0_resolveType;
        private static PyCode c$1_DefaultResolver;
        private static PyCode c$2_makeClass;
        private static PyCode c$3_hasMethod;
        private static PyCode c$4_main;
        private static void initConstants() {
            s$0 = Py.newString("!!(.*?)\\.(.*)");
            s$1 = Py.newString("Invalid private type specifier");
            s$2 = Py.newString("import %s");
            s$3 = Py.newString("%s.%s");
            s$4 = Py.newString("from_yaml");
            i$5 = Py.newInteger(0);
            i$6 = Py.newInteger(1);
            s$7 = Py.newString("/local/src/i/Rabbit3/runtime/py-lib/yaml/klass.py");
            funcTable = new _PyInner();
            c$0_resolveType = Py.newCode(3, new String[] {"self", "data", "typestring", "match", "classname", "modname"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/klass.py", "resolveType", false, false, funcTable, 0, null, null, 0, 1);
            c$1_DefaultResolver = Py.newCode(0, new String[] {}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/klass.py", "DefaultResolver", false, false, funcTable, 1, null, null, 0, 0);
            c$2_makeClass = Py.newCode(3, new String[] {"module", "classname", "dict", "klass", "obj"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/klass.py", "makeClass", false, false, funcTable, 2, null, null, 0, 0);
            c$3_hasMethod = Py.newCode(2, new String[] {"object", "method_name", "klass", "method"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/klass.py", "hasMethod", false, false, funcTable, 3, null, null, 0, 1);
            c$4_main = Py.newCode(0, new String[] {}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/klass.py", "main", false, false, funcTable, 4, null, null, 0, 0);
        }
        
        
        public PyCode getMain() {
            if (c$4_main == null) _PyInner.initConstants();
            return c$4_main;
        }
        
        public PyObject call_function(int index, PyFrame frame) {
            switch (index){
                case 0:
                return _PyInner.resolveType$1(frame);
                case 1:
                return _PyInner.DefaultResolver$2(frame);
                case 2:
                return _PyInner.makeClass$3(frame);
                case 3:
                return _PyInner.hasMethod$4(frame);
                case 4:
                return _PyInner.main$5(frame);
                default:
                return null;
            }
        }
        
        private static PyObject resolveType$1(PyFrame frame) {
            // Temporary Variables
            PyObject t$0$PyObject;
            
            // Code
            frame.setlocal(3, frame.getglobal("re").__getattr__("match").__call__(s$0, frame.getlocal(2)));
            if (frame.getlocal(3).__not__().__nonzero__()) {
                throw Py.makeException(s$1);
            }
            t$0$PyObject = frame.getlocal(3).invoke("groups");
            frame.setlocal(5, t$0$PyObject.__getitem__(0));
            frame.setlocal(4, t$0$PyObject.__getitem__(1));
            return frame.getglobal("makeClass").__call__(frame.getlocal(5), frame.getlocal(4), frame.getlocal(1));
        }
        
        private static PyObject DefaultResolver$2(PyFrame frame) {
            frame.setlocal("resolveType", new PyFunction(frame.f_globals, new PyObject[] {}, c$0_resolveType));
            return frame.getf_locals();
        }
        
        private static PyObject makeClass$3(PyFrame frame) {
            Py.exec(s$2._mod(frame.getlocal(0)), null, null);
            frame.setlocal(3, frame.getname("eval").__call__(s$3._mod(new PyTuple(new PyObject[] {frame.getlocal(0), frame.getlocal(1)}))));
            frame.setlocal(4, frame.getname("new").__getattr__("instance").__call__(frame.getlocal(3)));
            if (frame.getname("hasMethod").__call__(frame.getlocal(4), s$4).__nonzero__()) {
                return frame.getlocal(4).invoke("from_yaml", frame.getlocal(2));
            }
            frame.getlocal(4).__setattr__("__dict__", frame.getlocal(2));
            return frame.getlocal(4);
        }
        
        private static PyObject hasMethod$4(PyFrame frame) {
            frame.setlocal(2, frame.getlocal(0).__getattr__("__class__"));
            if (frame.getglobal("hasattr").__call__(frame.getlocal(2), frame.getlocal(1)).__not__().__nonzero__()) {
                return i$5;
            }
            frame.setlocal(3, frame.getglobal("getattr").__call__(frame.getlocal(2), frame.getlocal(1)));
            if (frame.getglobal("callable").__call__(frame.getlocal(3)).__not__().__nonzero__()) {
                return i$5;
            }
            return i$6;
        }
        
        private static PyObject main$5(PyFrame frame) {
            frame.setglobal("__file__", s$7);
            
            frame.setlocal("new", org.python.core.imp.importOne("new", frame));
            frame.setlocal("re", org.python.core.imp.importOne("re", frame));
            frame.setlocal("DefaultResolver", Py.makeClass("DefaultResolver", new PyObject[] {}, c$1_DefaultResolver, null));
            frame.setlocal("makeClass", new PyFunction(frame.f_globals, new PyObject[] {}, c$2_makeClass));
            frame.setlocal("hasMethod", new PyFunction(frame.f_globals, new PyObject[] {}, c$3_hasMethod));
            return Py.None;
        }
        
    }
    public static void moduleDictInit(PyObject dict) {
        dict.__setitem__("__name__", new PyString("klass"));
        Py.runCode(new _PyInner().getMain(), dict, dict);
    }
    
    public static void main(String[] args) throws Exception {
        String[] newargs = new String[args.length+1];
        newargs[0] = "klass";
        System.arraycopy(args, 0, newargs, 1, args.length);
        Py.runMain(klass._PyInner.class, newargs, jpy$packages, jpy$properties, "yaml", new String[] {"socket", "ftplib", "yaml.klass", "yaml.__init__", "dummy", "macurl2path", "rfc822", "string", "yaml.inline", "yaml.dump", "tempfile", "yaml.load", "base64", "sre", "StringIO", "copy_reg", "random", "getopt", "nturl2path", "httplib", "mimetools", "sre_parse", "sre_compile", "quopri", "yaml.implicit", "sre_constants", "javapath", "yaml.ypath", "urllib", "re", "mimetypes", "posixpath", "errno", "gopherlib", "yaml.stream", "stat", "yaml.timestamp", "javaos"});
    }
    
}
