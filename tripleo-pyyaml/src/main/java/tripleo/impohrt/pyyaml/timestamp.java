package tripleo.impohrt.pyyaml;

import org.python.core.*;

public class timestamp extends java.lang.Object {

    static String[] jpy$properties = new String[]{"python.modules.builtin", "exceptions:org.python.core.exceptions", "python.options.showJavaExceptions", "true"};
    static String[] jpy$packages = new String[]{"org.python.core", null, "java.lang", null, "java.io", null, "java.net", null};

    public static class _PyInner extends PyFunctionTable implements PyRunnable {

        private static PyObject s$0;
        private static PyObject s$1;
        private static PyObject s$2;
        private static PyObject i$3;
        private static PyObject i$4;
        private static PyObject i$5;
        private static PyObject i$6;
        private static PyObject i$7;
        private static PyObject i$8;
        private static PyObject i$9;
        private static PyObject i$10;
        private static PyObject s$11;
        private static PyObject i$12;
        private static PyObject i$13;
        private static PyObject i$14;
        private static PyObject i$15;
        private static PyObject i$16;
        private static PyObject i$17;
        private static PyObject i$18;
        private static PyObject i$19;
        private static PyObject i$20;
        private static PyObject s$21;
        private static PyObject i$22;
        private static PyObject s$23;
        private static PyObject s$24;
        private static PyObject s$25;
        private static PyObject s$26;
        private static PyObject s$27;
        private static PyObject s$28;
        private static PyObject s$29;
        private static PyObject s$30;
        private static PyFunctionTable funcTable;
        private static PyCode c$0__parseTime;
        private static PyCode c$1___init__;
        private static PyCode c$2___getitem__;
        private static PyCode c$3___len__;
        private static PyCode c$4_strftime;
        private static PyCode c$5_mktime;
        private static PyCode c$6_asctime;
        private static PyCode c$7_isotime;
        private static PyCode c$8___repr__;
        private static PyCode c$9___str__;
        private static PyCode c$10_to_yaml_implicit;
        private static PyCode c$11___hash__;
        private static PyCode c$12___cmp__;
        private static PyCode c$13__timestamp;
        private static PyCode c$14___init__;
        private static PyCode c$15___getattr__;
        private static PyCode c$16_timestamp;
        private static PyCode c$17_timestamp;
        private static PyCode c$18_unquote;
        private static PyCode c$19_main;

        private static void initConstants() {
            s$0 = Py.newString("\012  This module is considered to be private implementation\012  details and is subject to change.  Please only use the\012  objects and methods exported to the top level yaml package.\012");
            s$1 = Py.newString("\\-|\\s|T|t|:|\\.|Z");
            s$2 = Py.newString("\\d+-\\d+-\\d+([\\s|T|t]\\d+:\\d+:\\d+.\\d+(Z|(\\s?[\\-|\\+]\\d+:\\d+)))?");
            i$3 = Py.newInteger(0);
            i$4 = Py.newInteger(3);
            i$5 = Py.newInteger(1);
            i$6 = Py.newInteger(7);
            i$7 = Py.newInteger(8);
            i$8 = Py.newInteger(9);
            i$9 = Py.newInteger(10);
            i$10 = Py.newInteger(60);
            s$11 = Py.newString("+");
            i$12 = Py.newInteger(12);
            i$13 = Py.newInteger(2);
            i$14 = Py.newInteger(31);
            i$15 = Py.newInteger(24);
            i$16 = Py.newInteger(4);
            i$17 = Py.newInteger(61);
            i$18 = Py.newInteger(5);
            i$19 = Py.newInteger(2038);
            i$20 = Py.newInteger(18);
            s$21 = Py.newString("%04d-%02d-%02dT%02d:%02d:%02d.00Z");
            i$22 = Py.newInteger(6);
            s$23 = Py.newString("yaml.timestamp('%s')");
            s$24 = Py.newString("\012        summary: >\012           Simply returns the unquoted string, and the\012           length of the quoted string token at the \012           beginning of the expression.\012    ");
            s$25 = Py.newString("'");
            s$26 = Py.newString("");
            s$27 = Py.newString("\"");
            s$28 = Py.newString("\\");
            s$29 = Py.newString("unmatched quote: ");
            s$30 = Py.newString("/local/src/i/Rabbit3/runtime/py-lib/yaml/timestamp.py");
            funcTable = new _PyInner();
            c$0__parseTime = Py.newCode(1, new String[]{"val", "siz", "mn", "sec", "tpl", "ret", "idx", "hr"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/timestamp.py", "_parseTime", false, false, funcTable, 0, null, null, 0, 1);
            c$1___init__ = Py.newCode(2, new String[]{"self", "val", "typ"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/timestamp.py", "__init__", false, false, funcTable, 1, null, null, 0, 1);
            c$2___getitem__ = Py.newCode(2, new String[]{"self", "idx"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/timestamp.py", "__getitem__", false, false, funcTable, 2, null, null, 0, 1);
            c$3___len__ = Py.newCode(1, new String[]{"self"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/timestamp.py", "__len__", false, false, funcTable, 3, null, null, 0, 1);
            c$4_strftime = Py.newCode(2, new String[]{"self", "format"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/timestamp.py", "strftime", false, false, funcTable, 4, null, null, 0, 1);
            c$5_mktime = Py.newCode(1, new String[]{"self"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/timestamp.py", "mktime", false, false, funcTable, 5, null, null, 0, 1);
            c$6_asctime = Py.newCode(1, new String[]{"self"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/timestamp.py", "asctime", false, false, funcTable, 6, null, null, 0, 1);
            c$7_isotime = Py.newCode(1, new String[]{"self"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/timestamp.py", "isotime", false, false, funcTable, 7, null, null, 0, 1);
            c$8___repr__ = Py.newCode(1, new String[]{"self"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/timestamp.py", "__repr__", false, false, funcTable, 8, null, null, 0, 1);
            c$9___str__ = Py.newCode(1, new String[]{"self"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/timestamp.py", "__str__", false, false, funcTable, 9, null, null, 0, 1);
            c$10_to_yaml_implicit = Py.newCode(1, new String[]{"self"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/timestamp.py", "to_yaml_implicit", false, false, funcTable, 10, null, null, 0, 1);
            c$11___hash__ = Py.newCode(1, new String[]{"self"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/timestamp.py", "__hash__", false, false, funcTable, 11, null, null, 0, 1);
            c$12___cmp__ = Py.newCode(2, new String[]{"self", "other"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/timestamp.py", "__cmp__", false, false, funcTable, 12, null, null, 0, 1);
            c$13__timestamp = Py.newCode(0, new String[]{}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/timestamp.py", "_timestamp", false, false, funcTable, 13, null, null, 0, 0);
            c$14___init__ = Py.newCode(2, new String[]{"self", "val"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/timestamp.py", "__init__", false, false, funcTable, 14, null, null, 0, 1);
            c$15___getattr__ = Py.newCode(2, new String[]{"self", "name"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/timestamp.py", "__getattr__", false, false, funcTable, 15, null, null, 0, 1);
            c$16_timestamp = Py.newCode(0, new String[]{}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/timestamp.py", "timestamp", false, false, funcTable, 16, null, null, 0, 0);
            c$17_timestamp = Py.newCode(0, new String[]{}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/timestamp.py", "timestamp", false, false, funcTable, 17, null, null, 0, 0);
            c$18_unquote = Py.newCode(1, new String[]{"expr", "chr", "ret", "esc", "idx", "tok", "odd"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/timestamp.py", "unquote", false, false, funcTable, 18, null, null, 0, 1);
            c$19_main = Py.newCode(0, new String[]{}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/timestamp.py", "main", false, false, funcTable, 19, null, null, 0, 0);
        }

        public PyCode getMain() {
            if (c$19_main == null) {
                _PyInner.initConstants();
            }
            return c$19_main;
        }

        public PyObject call_function(int index, PyFrame frame) {
            switch (index) {
                case 0:
                    return _PyInner._parseTime$1(frame);
                case 1:
                    return _PyInner.__init__$2(frame);
                case 2:
                    return _PyInner.__getitem__$3(frame);
                case 3:
                    return _PyInner.__len__$4(frame);
                case 4:
                    return _PyInner.strftime$5(frame);
                case 5:
                    return _PyInner.mktime$6(frame);
                case 6:
                    return _PyInner.asctime$7(frame);
                case 7:
                    return _PyInner.isotime$8(frame);
                case 8:
                    return _PyInner.__repr__$9(frame);
                case 9:
                    return _PyInner.__str__$10(frame);
                case 10:
                    return _PyInner.to_yaml_implicit$11(frame);
                case 11:
                    return _PyInner.__hash__$12(frame);
                case 12:
                    return _PyInner.__cmp__$13(frame);
                case 13:
                    return _PyInner._timestamp$14(frame);
                case 14:
                    return _PyInner.__init__$15(frame);
                case 15:
                    return _PyInner.__getattr__$16(frame);
                case 16:
                    return _PyInner.timestamp$17(frame);
                case 17:
                    return _PyInner.timestamp$18(frame);
                case 18:
                    return _PyInner.unquote$19(frame);
                case 19:
                    return _PyInner.main$20(frame);
                default:
                    return null;
            }
        }

        private static PyObject _parseTime$1(PyFrame frame) {
            // Temporary Variables
            PyObject t$0$PyObject;

            // Code
            if (frame.getglobal("matchTime").invoke("match", frame.getlocal(0)).__not__().__nonzero__()) {
                throw Py.makeException(frame.getglobal("ValueError").__call__(frame.getlocal(0)));
            }
            frame.setlocal(4, frame.getglobal("_splitTime").invoke("split", frame.getlocal(0)));
            if (frame.getlocal(4).__not__().__nonzero__()) {
                throw Py.makeException(frame.getglobal("ValueError").__call__(frame.getlocal(0)));
            }
            frame.setlocal(1, frame.getglobal("len").__call__(frame.getlocal(4)));
            frame.setlocal(3, i$3);
            if (i$4._eq(frame.getlocal(1)).__nonzero__()) {
                t$0$PyObject = new PyList(new PyObject[]{i$3, i$3, i$3, i$3, i$3, i$5.__neg__()});
                frame.setlocal(4, frame.getlocal(4).__iadd__(t$0$PyObject));
            } else if (i$6._eq(frame.getlocal(1)).__nonzero__()) {
                frame.getlocal(4).invoke("append", i$3);
                frame.getlocal(4).invoke("append", i$5.__neg__());
            } else if (i$7._eq(frame.getlocal(1)).__nonzero__()) {
                if (frame.getglobal("len").__call__(frame.getlocal(4).invoke("pop"))._gt(i$3).__nonzero__()) {
                    throw Py.makeException(frame.getglobal("ValueError").__call__(frame.getlocal(0)));
                }
                frame.getlocal(4).invoke("append", i$3);
                frame.getlocal(4).invoke("append", i$5.__neg__());
            } else if (((t$0$PyObject = i$8._eq(frame.getlocal(1))).__nonzero__() ? t$0$PyObject : i$9._eq(frame.getlocal(1))).__nonzero__()) {
                frame.setlocal(2, frame.getglobal("int").__call__(frame.getlocal(4).invoke("pop")));
                frame.setlocal(7, frame.getglobal("int").__call__(frame.getlocal(4).invoke("pop")));
                frame.setlocal(3, frame.getlocal(7)._mul(i$10)._add(frame.getlocal(2))._mul(i$10));
                if (frame.getlocal(0).invoke("find", s$11)._gt(i$5.__neg__()).__nonzero__()) {
                    frame.setlocal(3, frame.getlocal(3).__neg__());
                }
                if (i$9._eq(frame.getlocal(1)).__nonzero__()) {
                    frame.getlocal(4).invoke("pop");
                }
                frame.getlocal(4).invoke("append", i$3);
                frame.getlocal(4).invoke("append", i$5.__neg__());
            } else {
                throw Py.makeException(frame.getglobal("ValueError").__call__(frame.getlocal(0)));
            }
            frame.setlocal(6, i$3);
            while (frame.getlocal(6)._lt(i$8).__nonzero__()) {
                frame.getlocal(4).__setitem__(frame.getlocal(6), frame.getglobal("int").__call__(frame.getlocal(4).__getitem__(frame.getlocal(6))));
                t$0$PyObject = i$5;
                frame.setlocal(6, frame.getlocal(6).__iadd__(t$0$PyObject));
            }
            if (((t$0$PyObject = frame.getlocal(4).__getitem__(i$5)._lt(i$5)).__nonzero__() ? t$0$PyObject : frame.getlocal(4).__getitem__(i$5)._gt(i$12)).__nonzero__()) {
                throw Py.makeException(frame.getglobal("ValueError").__call__(frame.getlocal(0)));
            }
            if (((t$0$PyObject = frame.getlocal(4).__getitem__(i$13)._lt(i$5)).__nonzero__() ? t$0$PyObject : frame.getlocal(4).__getitem__(i$13)._gt(i$14)).__nonzero__()) {
                throw Py.makeException(frame.getglobal("ValueError").__call__(frame.getlocal(0)));
            }
            if (frame.getlocal(4).__getitem__(i$4)._gt(i$15).__nonzero__()) {
                throw Py.makeException(frame.getglobal("ValueError").__call__(frame.getlocal(0)));
            }
            if (frame.getlocal(4).__getitem__(i$16)._gt(i$17).__nonzero__()) {
                throw Py.makeException(frame.getglobal("ValueError").__call__(frame.getlocal(0)));
            }
            if (frame.getlocal(4).__getitem__(i$18)._gt(i$17).__nonzero__()) {
                throw Py.makeException(frame.getglobal("ValueError").__call__(frame.getlocal(0)));
            }
            if (frame.getlocal(4).__getitem__(i$3)._gt(i$19).__nonzero__()) {
                frame.setlocal(4, new PyTuple(new PyObject[]{i$19, i$5, i$20, i$3, i$3, i$3, i$3, i$3, i$5.__neg__()}));
            }
            frame.setlocal(4, frame.getglobal("tuple").__call__(frame.getlocal(4)));
            frame.setlocal(5, frame.getglobal("time").__getattr__("mktime").__call__(frame.getlocal(4)));
            frame.setlocal(5, frame.getglobal("time").__getattr__("localtime").__call__(frame.getlocal(5)._add(frame.getlocal(3))));
            frame.setlocal(5, frame.getlocal(5).__getslice__(null, i$7, null)._add(new PyTuple(new PyObject[]{i$3})));
            return frame.getlocal(5);
        }

        private static PyObject __init__$2(PyFrame frame) {
            if (frame.getlocal(1).__not__().__nonzero__()) {
                frame.getlocal(0).__setattr__("__tval", frame.getglobal("time").__getattr__("gmtime").__call__());
            } else {
                frame.setlocal(2, frame.getglobal("type").__call__(frame.getlocal(1)));
                if (frame.getglobal("ListType")._eq(frame.getlocal(2)).__nonzero__()) {
                    frame.getlocal(0).__setattr__("__tval", frame.getglobal("tuple").__call__(frame.getlocal(1)));
                } else if (frame.getglobal("TupleType")._eq(frame.getlocal(2)).__nonzero__()) {
                    frame.getlocal(0).__setattr__("__tval", frame.getlocal(1));
                } else {
                    frame.getlocal(0).__setattr__("__tval", frame.getglobal("_parseTime").__call__(frame.getlocal(1)));
                }
                if (i$8._ne(frame.getglobal("len").__call__(frame.getlocal(0).__getattr__("__tval"))).__nonzero__()) {
                    throw Py.makeException(frame.getglobal("ValueError"));
                }
            }
            return Py.None;
        }

        private static PyObject __getitem__$3(PyFrame frame) {
            return frame.getlocal(0).__getattr__("__tval").__getitem__(frame.getlocal(1));
        }

        private static PyObject __len__$4(PyFrame frame) {
            return i$8;
        }

        private static PyObject strftime$5(PyFrame frame) {
            return frame.getglobal("time").__getattr__("strftime").__call__(frame.getlocal(1), frame.getlocal(0).__getattr__("__tval"));
        }

        private static PyObject mktime$6(PyFrame frame) {
            return frame.getglobal("time").__getattr__("mktime").__call__(frame.getlocal(0).__getattr__("__tval"));
        }

        private static PyObject asctime$7(PyFrame frame) {
            return frame.getglobal("time").__getattr__("asctime").__call__(frame.getlocal(0).__getattr__("__tval"));
        }

        private static PyObject isotime$8(PyFrame frame) {
            return s$21._mod(frame.getlocal(0).__getattr__("__tval").__getslice__(null, i$22, null));
        }

        private static PyObject __repr__$9(PyFrame frame) {
            return s$23._mod(frame.getlocal(0).invoke("isotime"));
        }

        private static PyObject __str__$10(PyFrame frame) {
            return frame.getlocal(0).invoke("isotime");
        }

        private static PyObject to_yaml_implicit$11(PyFrame frame) {
            return frame.getlocal(0).invoke("isotime");
        }

        private static PyObject __hash__$12(PyFrame frame) {
            return frame.getglobal("hash").__call__(frame.getlocal(0).__getattr__("__tval").__getslice__(null, i$22, null));
        }

        private static PyObject __cmp__$13(PyFrame frame) {
            // Temporary Variables
            PyException t$0$PyException;

            // Code
            try {
                return frame.getglobal("cmp").__call__(frame.getlocal(0).__getattr__("__tval").__getslice__(null, i$22, null), frame.getlocal(1).__getattr__("__tval").__getslice__(null, i$22, null));
            } catch (Throwable x$0) {
                t$0$PyException = Py.setException(x$0, frame);
                if (Py.matchException(t$0$PyException, frame.getglobal("AttributeError"))) {
                    return i$5.__neg__();
                } else {
                    throw t$0$PyException;
                }
            }
        }

        private static PyObject _timestamp$14(PyFrame frame) {
            frame.setlocal("__init__", new PyFunction(frame.f_globals, new PyObject[]{frame.getname("None")}, c$1___init__));
            frame.setlocal("__getitem__", new PyFunction(frame.f_globals, new PyObject[]{}, c$2___getitem__));
            frame.setlocal("__len__", new PyFunction(frame.f_globals, new PyObject[]{}, c$3___len__));
            frame.setlocal("strftime", new PyFunction(frame.f_globals, new PyObject[]{}, c$4_strftime));
            frame.setlocal("mktime", new PyFunction(frame.f_globals, new PyObject[]{}, c$5_mktime));
            frame.setlocal("asctime", new PyFunction(frame.f_globals, new PyObject[]{}, c$6_asctime));
            frame.setlocal("isotime", new PyFunction(frame.f_globals, new PyObject[]{}, c$7_isotime));
            frame.setlocal("__repr__", new PyFunction(frame.f_globals, new PyObject[]{}, c$8___repr__));
            frame.setlocal("__str__", new PyFunction(frame.f_globals, new PyObject[]{}, c$9___str__));
            frame.setlocal("to_yaml_implicit", new PyFunction(frame.f_globals, new PyObject[]{}, c$10_to_yaml_implicit));
            frame.setlocal("__hash__", new PyFunction(frame.f_globals, new PyObject[]{}, c$11___hash__));
            frame.setlocal("__cmp__", new PyFunction(frame.f_globals, new PyObject[]{}, c$12___cmp__));
            return frame.getf_locals();
        }

        private static PyObject __init__$15(PyFrame frame) {
            frame.getglobal("_timestamp").invoke("__init__", frame.getlocal(0), frame.getlocal(1));
            frame.getlocal(0).__setattr__("__mxdt", frame.getglobal("DateTime").__getattr__("mktime").__call__(frame.getlocal(0).__getattr__("__tval")));
            return Py.None;
        }

        private static PyObject __getattr__$16(PyFrame frame) {
            return frame.getglobal("getattr").__call__(frame.getlocal(0).__getattr__("__mxdt"), frame.getlocal(1));
        }

        private static PyObject timestamp$17(PyFrame frame) {
            frame.setlocal("__init__", new PyFunction(frame.f_globals, new PyObject[]{frame.getname("None")}, c$14___init__));
            frame.setlocal("__getattr__", new PyFunction(frame.f_globals, new PyObject[]{}, c$15___getattr__));
            return frame.getf_locals();
        }

        private static PyObject timestamp$18(PyFrame frame) {
            // pass
            return frame.getf_locals();
        }

        private static PyObject unquote$19(PyFrame frame) {
            // Temporary Variables
            PyObject t$0$PyObject;

            // Code
            /* 
                    summary: >
                       Simply returns the unquoted string, and the
                       length of the quoted string token at the 
                       beginning of the expression.
             */
            frame.setlocal(5, frame.getlocal(0).__getitem__(i$3));
            if (s$25._eq(frame.getlocal(5)).__nonzero__()) {
                frame.setlocal(4, i$5);
                frame.setlocal(6, i$3);
                frame.setlocal(2, s$26);
                while (frame.getlocal(4)._lt(frame.getglobal("len").__call__(frame.getlocal(0))).__nonzero__()) {
                    frame.setlocal(1, frame.getlocal(0).__getitem__(frame.getlocal(4)));
                    if (s$25._eq(frame.getlocal(1)).__nonzero__()) {
                        if (frame.getlocal(6).__nonzero__()) {
                            t$0$PyObject = frame.getlocal(1);
                            frame.setlocal(2, frame.getlocal(2).__iadd__(t$0$PyObject));
                        }
                        frame.setlocal(6, frame.getlocal(6).__not__());
                    } else {
                        if (frame.getlocal(6).__nonzero__()) {
                            frame.setlocal(5, frame.getlocal(0).__getslice__(null, frame.getlocal(4), null));
                            break;
                        }
                        t$0$PyObject = frame.getlocal(1);
                        frame.setlocal(2, frame.getlocal(2).__iadd__(t$0$PyObject));
                    }
                    t$0$PyObject = i$5;
                    frame.setlocal(4, frame.getlocal(4).__iadd__(t$0$PyObject));
                }
                if (s$25._eq(frame.getlocal(5)).__nonzero__()) {
                    frame.setlocal(5, frame.getlocal(0));
                }
                return new PyTuple(new PyObject[]{frame.getlocal(2), frame.getglobal("len").__call__(frame.getlocal(5))});
            }
            if (s$27._eq(frame.getlocal(5)).__nonzero__()) {
                frame.setlocal(4, i$5);
                frame.setlocal(3, i$3);
                while (frame.getlocal(4)._lt(frame.getglobal("len").__call__(frame.getlocal(0))).__nonzero__()) {
                    frame.setlocal(1, frame.getlocal(0).__getitem__(frame.getlocal(4)));
                    if (((t$0$PyObject = s$27._eq(frame.getlocal(1))).__nonzero__() ? frame.getlocal(3).__not__() : t$0$PyObject).__nonzero__()) {
                        frame.setlocal(5, frame.getlocal(0).__getslice__(null, frame.getlocal(4), null)._add(s$27));
                        break;
                    }
                    if (((t$0$PyObject = s$28._eq(frame.getlocal(1))).__nonzero__() ? frame.getlocal(3).__not__() : t$0$PyObject).__nonzero__()) {
                        frame.setlocal(3, i$5);
                    } else {
                        frame.setlocal(3, i$3);
                    }
                    t$0$PyObject = i$5;
                    frame.setlocal(4, frame.getlocal(4).__iadd__(t$0$PyObject));
                }
                if (s$27._eq(frame.getlocal(5)).__nonzero__()) {
                    throw Py.makeException(frame.getglobal("SyntaxError").__call__(s$29._add(frame.getlocal(0))));
                }
                frame.setlocal(2, frame.getglobal("eval").__call__(frame.getlocal(5)));
                return new PyTuple(new PyObject[]{frame.getlocal(2), frame.getglobal("len").__call__(frame.getlocal(5))});
            }
            return new PyTuple(new PyObject[]{frame.getlocal(0), frame.getglobal("len").__call__(frame.getlocal(0))});
        }

        private static PyObject main$20(PyFrame frame) {
            frame.setglobal("__file__", s$30);

            PyObject[] imp_accu;
            // Temporary Variables
            PyException t$0$PyException;

            // Code
            frame.setlocal("time", org.python.core.imp.importOne("time", frame));
            frame.setlocal("re", org.python.core.imp.importOne("re", frame));
            frame.setlocal("string", org.python.core.imp.importOne("string", frame));
            imp_accu = org.python.core.imp.importFrom("types", new String[]{"ListType", "TupleType"}, frame);
            frame.setlocal("ListType", imp_accu[0]);
            frame.setlocal("TupleType", imp_accu[1]);
            frame.setlocal("PRIVATE_NOTICE", s$0);
            frame.setlocal("_splitTime", frame.getname("re").__getattr__("compile").__call__(s$1));
            frame.setlocal("matchTime", frame.getname("re").__getattr__("compile").__call__(s$2));
            frame.setlocal("_parseTime", new PyFunction(frame.f_globals, new PyObject[]{}, c$0__parseTime));
            frame.setlocal("_timestamp", Py.makeClass("_timestamp", new PyObject[]{}, c$13__timestamp, null));
            try {
                imp_accu = org.python.core.imp.importFrom("mx", new String[]{"DateTime"}, frame);
                frame.setlocal("DateTime", imp_accu[0]);
                frame.setlocal("timestamp", Py.makeClass("timestamp", new PyObject[]{frame.getname("_timestamp")}, c$16_timestamp, null));
            } catch (Throwable x$0) {
                t$0$PyException = Py.setException(x$0, frame);
                frame.setlocal("timestamp", Py.makeClass("timestamp", new PyObject[]{frame.getname("_timestamp")}, c$17_timestamp, null));
            }
            frame.setlocal("unquote", new PyFunction(frame.f_globals, new PyObject[]{}, c$18_unquote));
            return Py.None;
        }

    }

    public static void moduleDictInit(PyObject dict) {
        dict.__setitem__("__name__", new PyString("timestamp"));
        Py.runCode(new _PyInner().getMain(), dict, dict);
    }

    public static void main(String[] args) throws Exception {
        String[] newargs = new String[args.length + 1];
        newargs[0] = "timestamp";
        System.arraycopy(args, 0, newargs, 1, args.length);
        Py.runMain(timestamp._PyInner.class, newargs, jpy$packages, jpy$properties, "yaml", new String[]{"socket", "ftplib", "yaml.klass", "yaml.__init__", "dummy", "macurl2path", "rfc822", "string", "yaml.inline", "yaml.dump", "tempfile", "yaml.load", "base64", "sre", "StringIO", "copy_reg", "random", "getopt", "nturl2path", "httplib", "mimetools", "sre_parse", "sre_compile", "quopri", "yaml.implicit", "sre_constants", "javapath", "yaml.ypath", "urllib", "re", "mimetypes", "posixpath", "errno", "gopherlib", "yaml.stream", "stat", "yaml.timestamp", "javaos"});
    }

}
