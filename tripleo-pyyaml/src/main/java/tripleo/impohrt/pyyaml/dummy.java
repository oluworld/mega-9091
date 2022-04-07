package tripleo.impohrt.pyyaml;

import org.python.core.*;

public class dummy extends java.lang.Object {

    static String[] jpy$properties = new String[]{"python.modules.builtin", "exceptions:org.python.core.exceptions", "python.options.showJavaExceptions", "true"};
    static String[] jpy$packages = new String[]{"org.python.core", null, "java.lang", null, "java.io", null, "java.net", null};

    public static class _PyInner extends PyFunctionTable implements PyRunnable {

        private static PyObject s$0;
        private static PyObject s$1;
        private static PyObject s$2;
        private static PyObject s$3;
        private static PyObject s$4;
        private static PyObject s$5;
        private static PyFunctionTable funcTable;
        private static PyCode c$0_main;

        private static void initConstants() {
            s$0 = Py.newString("e");
            s$1 = Py.newString("f");
            s$2 = Py.newString("g");
            s$3 = Py.newString("x");
            s$4 = Py.newString("w");
            s$5 = Py.newString("/local/src/i/Rabbit3/runtime/py-lib/dummy.py");
            funcTable = new _PyInner();
            c$0_main = Py.newCode(0, new String[]{}, "/local/src/i/Rabbit3/runtime/py-lib/dummy.py", "main", false, false, funcTable, 0, null, null, 0, 0);
        }

        public PyCode getMain() {
            if (c$0_main == null) {
                _PyInner.initConstants();
            }
            return c$0_main;
        }

        public PyObject call_function(int index, PyFrame frame) {
            switch (index) {
                case 0:
                    return _PyInner.main$1(frame);
                default:
                    return null;
            }
        }

        private static PyObject main$1(PyFrame frame) {
            frame.setglobal("__file__", s$5);

            frame.setlocal("yaml", org.python.core.imp.importOne("yaml", frame));
            frame.setlocal("x", new PyDictionary(new PyObject[]{s$0, s$0, s$1, s$1, s$2, s$2}));
            new PyFile("x", "w", 8196).write(((PyString) (frame.getname("yaml").__getattr__("dump").__call__(frame.getname("x")))).toString());
//          frame.getname("open").__call__(s$3, s$4).invoke("write", frame.getname("yaml").__getattr__("dump").__call__(frame.getname("x")));
            Py.println(frame.getname("yaml").__getattr__("load").__call__(frame.getname("open").__call__(s$3).invoke("read")));
            return Py.None;
        }

    }

    public static void moduleDictInit(PyObject dict) {
        dict.__setitem__("__name__", new PyString("dummy"));
        Py.runCode(new _PyInner().getMain(), dict, dict);
    }

    public static void main(String[] args) throws Exception {
        String[] newargs = new String[args.length + 1];
        newargs[0] = "dummy";
        System.arraycopy(args, 0, newargs, 1, args.length);
        Py.runMain(dummy._PyInner.class, newargs, jpy$packages, jpy$properties, "", new String[]{"socket", "ftplib", "yaml.klass", "yaml.__init__", "dummy", "macurl2path", "rfc822", "string", "yaml.inline", "yaml.dump", "tempfile", "yaml.load", "base64", "sre", "StringIO", "copy_reg", "random", "getopt", "nturl2path", "httplib", "mimetools", "sre_parse", "sre_compile", "quopri", "yaml.implicit", "sre_constants", "javapath", "yaml.ypath", "urllib", "re", "mimetypes", "posixpath", "errno", "gopherlib", "yaml.stream", "stat", "yaml.timestamp", "javaos"});
    }

}
