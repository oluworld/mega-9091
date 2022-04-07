package tripleo.impohrt.pyyaml;

import org.python.core.*;

public class stream extends java.lang.Object {

    static String[] jpy$properties = new String[]{"python.modules.builtin", "exceptions:org.python.core.exceptions", "python.options.showJavaExceptions", "true"};
    static String[] jpy$packages = new String[]{"org.python.core", null, "java.lang", null, "java.io", null, "java.net", null};

    public static class _PyInner extends PyFunctionTable implements PyRunnable {

        private static PyObject i$0;
        private static PyObject s$1;
        private static PyObject i$2;
        private static PyObject s$3;
        private static PyObject s$4;
        private static PyObject s$5;
        private static PyObject s$6;
        private static PyObject s$7;
        private static PyObject i$8;
        private static PyObject s$9;
        private static PyObject s$10;
        private static PyObject s$11;
        private static PyObject s$12;
        private static PyFunctionTable funcTable;
        private static PyCode c$0_indentLevel;
        private static PyCode c$1___init__;
        private static PyCode c$2_peek;
        private static PyCode c$3_pop;
        private static PyCode c$4_lastLineRead;
        private static PyCode c$5_AbstractStream;
        private static PyCode c$6___init__;
        private static PyCode c$7_getLine;
        private static PyCode c$8_FileStream;
        private static PyCode c$9___init__;
        private static PyCode c$10_getLine;
        private static PyCode c$11_StringStream;
        private static PyCode c$12___init__;
        private static PyCode c$13_reset;
        private static PyCode c$14_lastLineRead;
        private static PyCode c$15__peek;
        private static PyCode c$16_peek;
        private static PyCode c$17_pop;
        private static PyCode c$18_popNestedLines;
        private static PyCode c$19_eatComments;
        private static PyCode c$20_eatNewLines;
        private static PyCode c$21_nestToNextLine;
        private static PyCode c$22_nestBySpecificAmount;
        private static PyCode c$23_setNewIndent;
        private static PyCode c$24_NestedText;
        private static PyCode c$25___init__;
        private static PyCode c$26_startsWithSep;
        private static PyCode c$27_popDocSep;
        private static PyCode c$28_pop;
        private static PyCode c$29_error;
        private static PyCode c$30_NestedDocs;
        private static PyCode c$31_noLineFeed;
        private static PyCode c$32_main;

        private static void initConstants() {
            i$0 = Py.newInteger(0);
            s$1 = Py.newString(" ");
            i$2 = Py.newInteger(1);
            s$3 = Py.newString("");
            s$4 = Py.newString("\012");
            s$5 = Py.newString("\\s*#");
            s$6 = Py.newString("Inadequate indentation");
            s$7 = Py.newString("---");
            i$8 = Py.newInteger(3);
            s$9 = Py.newString("error");
            s$10 = Py.newString("%s:\012near line %d:\012%s\012");
            s$11 = Py.newString("\015");
            s$12 = Py.newString("/local/src/i/Rabbit3/runtime/py-lib/yaml/stream.py");
            funcTable = new _PyInner();
            c$0_indentLevel = Py.newCode(1, new String[]{"line", "n"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/stream.py", "indentLevel", false, false, funcTable, 0, null, null, 0, 1);
            c$1___init__ = Py.newCode(1, new String[]{"self"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/stream.py", "__init__", false, false, funcTable, 1, null, null, 0, 1);
            c$2_peek = Py.newCode(1, new String[]{"self"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/stream.py", "peek", false, false, funcTable, 2, null, null, 0, 1);
            c$3_pop = Py.newCode(1, new String[]{"self", "data"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/stream.py", "pop", false, false, funcTable, 3, null, null, 0, 1);
            c$4_lastLineRead = Py.newCode(1, new String[]{"self"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/stream.py", "lastLineRead", false, false, funcTable, 4, null, null, 0, 1);
            c$5_AbstractStream = Py.newCode(0, new String[]{}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/stream.py", "AbstractStream", false, false, funcTable, 5, null, null, 0, 0);
            c$6___init__ = Py.newCode(2, new String[]{"self", "filename"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/stream.py", "__init__", false, false, funcTable, 6, null, null, 0, 1);
            c$7_getLine = Py.newCode(1, new String[]{"self", "line"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/stream.py", "getLine", false, false, funcTable, 7, null, null, 0, 1);
            c$8_FileStream = Py.newCode(0, new String[]{}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/stream.py", "FileStream", false, false, funcTable, 8, null, null, 0, 0);
            c$9___init__ = Py.newCode(2, new String[]{"self", "text"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/stream.py", "__init__", false, false, funcTable, 9, null, null, 0, 1);
            c$10_getLine = Py.newCode(1, new String[]{"self"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/stream.py", "getLine", false, false, funcTable, 10, null, null, 0, 1);
            c$11_StringStream = Py.newCode(0, new String[]{}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/stream.py", "StringStream", false, false, funcTable, 11, null, null, 0, 0);
            c$12___init__ = Py.newCode(2, new String[]{"self", "stream"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/stream.py", "__init__", false, false, funcTable, 12, null, null, 0, 1);
            c$13_reset = Py.newCode(1, new String[]{"self"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/stream.py", "reset", false, false, funcTable, 13, null, null, 0, 1);
            c$14_lastLineRead = Py.newCode(1, new String[]{"self"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/stream.py", "lastLineRead", false, false, funcTable, 14, null, null, 0, 1);
            c$15__peek = Py.newCode(1, new String[]{"self"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/stream.py", "_peek", false, false, funcTable, 15, null, null, 0, 1);
            c$16_peek = Py.newCode(1, new String[]{"self", "nextLine"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/stream.py", "peek", false, false, funcTable, 16, null, null, 0, 1);
            c$17_pop = Py.newCode(1, new String[]{"self", "line"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/stream.py", "pop", false, false, funcTable, 17, null, null, 0, 1);
            c$18_popNestedLines = Py.newCode(1, new String[]{"self", "line", "lines", "nextLine"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/stream.py", "popNestedLines", false, false, funcTable, 18, null, null, 0, 1);
            c$19_eatComments = Py.newCode(1, new String[]{"self", "line"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/stream.py", "eatComments", false, false, funcTable, 19, null, null, 0, 1);
            c$20_eatNewLines = Py.newCode(1, new String[]{"self", "line"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/stream.py", "eatNewLines", false, false, funcTable, 20, null, null, 0, 1);
            c$21_nestToNextLine = Py.newCode(1, new String[]{"self", "line", "indentation"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/stream.py", "nestToNextLine", false, false, funcTable, 21, null, null, 0, 1);
            c$22_nestBySpecificAmount = Py.newCode(2, new String[]{"self", "adjust"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/stream.py", "nestBySpecificAmount", false, false, funcTable, 22, null, null, 0, 1);
            c$23_setNewIndent = Py.newCode(2, new String[]{"self", "indentLevel"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/stream.py", "setNewIndent", false, false, funcTable, 23, null, null, 0, 1);
            c$24_NestedText = Py.newCode(0, new String[]{}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/stream.py", "NestedText", false, false, funcTable, 24, null, null, 0, 0);
            c$25___init__ = Py.newCode(2, new String[]{"self", "stream", "line"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/stream.py", "__init__", false, false, funcTable, 25, null, null, 0, 1);
            c$26_startsWithSep = Py.newCode(2, new String[]{"self", "line"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/stream.py", "startsWithSep", false, false, funcTable, 26, null, null, 0, 1);
            c$27_popDocSep = Py.newCode(1, new String[]{"self", "line"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/stream.py", "popDocSep", false, false, funcTable, 27, null, null, 0, 1);
            c$28_pop = Py.newCode(1, new String[]{"self", "line"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/stream.py", "pop", false, false, funcTable, 28, null, null, 0, 1);
            c$29_error = Py.newCode(3, new String[]{"self", "msg", "line"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/stream.py", "error", false, false, funcTable, 29, null, null, 0, 1);
            c$30_NestedDocs = Py.newCode(0, new String[]{}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/stream.py", "NestedDocs", false, false, funcTable, 30, null, null, 0, 0);
            c$31_noLineFeed = Py.newCode(1, new String[]{"s"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/stream.py", "noLineFeed", false, false, funcTable, 31, null, null, 0, 1);
            c$32_main = Py.newCode(0, new String[]{}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/stream.py", "main", false, false, funcTable, 32, null, null, 0, 0);
        }

        public PyCode getMain() {
            if (c$32_main == null) {
                _PyInner.initConstants();
            }
            return c$32_main;
        }

        public PyObject call_function(int index, PyFrame frame) {
            switch (index) {
                case 0:
                    return _PyInner.indentLevel$1(frame);
                case 1:
                    return _PyInner.__init__$2(frame);
                case 2:
                    return _PyInner.peek$3(frame);
                case 3:
                    return _PyInner.pop$4(frame);
                case 4:
                    return _PyInner.lastLineRead$5(frame);
                case 5:
                    return _PyInner.AbstractStream$6(frame);
                case 6:
                    return _PyInner.__init__$7(frame);
                case 7:
                    return _PyInner.getLine$8(frame);
                case 8:
                    return _PyInner.FileStream$9(frame);
                case 9:
                    return _PyInner.__init__$10(frame);
                case 10:
                    return _PyInner.getLine$11(frame);
                case 11:
                    return _PyInner.StringStream$12(frame);
                case 12:
                    return _PyInner.__init__$13(frame);
                case 13:
                    return _PyInner.reset$14(frame);
                case 14:
                    return _PyInner.lastLineRead$15(frame);
                case 15:
                    return _PyInner._peek$16(frame);
                case 16:
                    return _PyInner.peek$17(frame);
                case 17:
                    return _PyInner.pop$18(frame);
                case 18:
                    return _PyInner.popNestedLines$19(frame);
                case 19:
                    return _PyInner.eatComments$20(frame);
                case 20:
                    return _PyInner.eatNewLines$21(frame);
                case 21:
                    return _PyInner.nestToNextLine$22(frame);
                case 22:
                    return _PyInner.nestBySpecificAmount$23(frame);
                case 23:
                    return _PyInner.setNewIndent$24(frame);
                case 24:
                    return _PyInner.NestedText$25(frame);
                case 25:
                    return _PyInner.__init__$26(frame);
                case 26:
                    return _PyInner.startsWithSep$27(frame);
                case 27:
                    return _PyInner.popDocSep$28(frame);
                case 28:
                    return _PyInner.pop$29(frame);
                case 29:
                    return _PyInner.error$30(frame);
                case 30:
                    return _PyInner.NestedDocs$31(frame);
                case 31:
                    return _PyInner.noLineFeed$32(frame);
                case 32:
                    return _PyInner.main$33(frame);
                default:
                    return null;
            }
        }

        private static PyObject indentLevel$1(PyFrame frame) {
            // Temporary Variables
            PyObject t$0$PyObject;

            // Code
            frame.setlocal(1, i$0);
            while (((t$0$PyObject = frame.getlocal(1)._lt(frame.getglobal("len").__call__(frame.getlocal(0)))).__nonzero__() ? frame.getlocal(0).__getitem__(frame.getlocal(1))._eq(s$1) : t$0$PyObject).__nonzero__()) {
                frame.setlocal(1, frame.getlocal(1)._add(i$2));
            }
            return frame.getlocal(1);
        }

        private static PyObject __init__$2(PyFrame frame) {
            frame.getlocal(0).__setattr__("curLine", i$0);
            frame.getlocal(0).__setattr__("peeked", i$0);
            return Py.None;
        }

        private static PyObject peek$3(PyFrame frame) {
            // Temporary Variables
            PyObject t$0$PyObject, t$1$PyObject;

            // Code
            if (frame.getlocal(0).__getattr__("peeked").__nonzero__()) {
                return frame.getlocal(0).__getattr__("line");
            }
            frame.getlocal(0).__setattr__("line", frame.getlocal(0).invoke("getLine"));
            t$0$PyObject = i$2;
            t$1$PyObject = frame.getlocal(0);
            t$1$PyObject.__setattr__("curLine", t$1$PyObject.__getattr__("curLine").__iadd__(t$0$PyObject));
            frame.getlocal(0).__setattr__("peeked", i$2);
            if (frame.getlocal(0).__getattr__("line").__nonzero__()) {
                frame.getlocal(0).__setattr__("line", frame.getglobal("noLineFeed").__call__(frame.getlocal(0).__getattr__("line")));
            }
            return frame.getlocal(0).__getattr__("line");
        }

        private static PyObject pop$4(PyFrame frame) {
            frame.setlocal(1, frame.getlocal(0).invoke("peek"));
            frame.getlocal(0).__setattr__("peeked", i$0);
            return frame.getlocal(1);
        }

        private static PyObject lastLineRead$5(PyFrame frame) {
            return frame.getlocal(0).__getattr__("curLine");
        }

        private static PyObject AbstractStream$6(PyFrame frame) {
            frame.setlocal("__init__", new PyFunction(frame.f_globals, new PyObject[]{}, c$1___init__));
            frame.setlocal("peek", new PyFunction(frame.f_globals, new PyObject[]{}, c$2_peek));
            frame.setlocal("pop", new PyFunction(frame.f_globals, new PyObject[]{}, c$3_pop));
            frame.setlocal("lastLineRead", new PyFunction(frame.f_globals, new PyObject[]{}, c$4_lastLineRead));
            return frame.getf_locals();
        }

        private static PyObject __init__$7(PyFrame frame) {
            frame.getlocal(0).__setattr__("fp", frame.getglobal("open").__call__(frame.getlocal(1)));
            frame.getglobal("AbstractStream").invoke("__init__", frame.getlocal(0));
            return Py.None;
        }

        private static PyObject getLine$8(PyFrame frame) {
            frame.setlocal(1, frame.getlocal(0).__getattr__("fp").invoke("readline"));
            if (frame.getlocal(1)._eq(s$3).__nonzero__()) {
                frame.setlocal(1, frame.getglobal("None"));
            }
            return frame.getlocal(1);
        }

        private static PyObject FileStream$9(PyFrame frame) {
            frame.setlocal("__init__", new PyFunction(frame.f_globals, new PyObject[]{}, c$6___init__));
            frame.setlocal("getLine", new PyFunction(frame.f_globals, new PyObject[]{}, c$7_getLine));
            return frame.getf_locals();
        }

        private static PyObject __init__$10(PyFrame frame) {
            frame.getlocal(0).__setattr__("lines", frame.getglobal("string").__getattr__("split").__call__(frame.getlocal(1), s$4));
            frame.getlocal(0).__setattr__("numLines", frame.getglobal("len").__call__(frame.getlocal(0).__getattr__("lines")));
            frame.getglobal("AbstractStream").invoke("__init__", frame.getlocal(0));
            return Py.None;
        }

        private static PyObject getLine$11(PyFrame frame) {
            if (frame.getlocal(0).__getattr__("curLine")._lt(frame.getlocal(0).__getattr__("numLines")).__nonzero__()) {
                return frame.getlocal(0).__getattr__("lines").__getitem__(frame.getlocal(0).__getattr__("curLine"));
            }
            return Py.None;
        }

        private static PyObject StringStream$12(PyFrame frame) {
            frame.setlocal("__init__", new PyFunction(frame.f_globals, new PyObject[]{}, c$9___init__));
            frame.setlocal("getLine", new PyFunction(frame.f_globals, new PyObject[]{}, c$10_getLine));
            return frame.getf_locals();
        }

        private static PyObject __init__$13(PyFrame frame) {
            frame.getlocal(0).__setattr__("stream", frame.getlocal(1));
            frame.getlocal(0).invoke("reset");
            return Py.None;
        }

        private static PyObject reset$14(PyFrame frame) {
            frame.getlocal(0).__setattr__("indentLevel", i$0);
            frame.getlocal(0).__setattr__("oldIndents", new PyList(new PyObject[]{i$0}));
            return Py.None;
        }

        private static PyObject lastLineRead$15(PyFrame frame) {
            return frame.getlocal(0).__getattr__("stream").invoke("lastLineRead");
        }

        private static PyObject _peek$16(PyFrame frame) {
            frame.getlocal(0).invoke("eatComments");
            return frame.getlocal(0).__getattr__("stream").invoke("peek");
        }

        private static PyObject peek$17(PyFrame frame) {
            frame.setlocal(1, frame.getlocal(0).invoke("_peek"));
            if (frame.getlocal(1)._isnot(frame.getglobal("None")).__nonzero__()) {
                if (frame.getglobal("indentLevel").__call__(frame.getlocal(1))._ge(frame.getlocal(0).__getattr__("indentLevel")).__nonzero__()) {
                    return frame.getlocal(1).__getslice__(frame.getlocal(0).__getattr__("indentLevel"), null, null);
                } else if (frame.getlocal(1)._eq(s$3).__nonzero__()) {
                    return s$3;
                }
            }
            return Py.None;
        }

        private static PyObject pop$18(PyFrame frame) {
            frame.setlocal(1, frame.getlocal(0).invoke("peek"));
            if (frame.getlocal(1)._is(frame.getglobal("None")).__nonzero__()) {
                frame.getlocal(0).__setattr__("indentLevel", frame.getlocal(0).__getattr__("oldIndents").invoke("pop"));
                return Py.None;
            }
            frame.getlocal(0).__getattr__("stream").invoke("pop");
            return frame.getlocal(1);
        }

        private static PyObject popNestedLines$19(PyFrame frame) {
            // Temporary Variables
            PyObject t$0$PyObject, t$1$PyObject;

            // Code
            frame.setlocal(3, frame.getlocal(0).invoke("peek"));
            if (((t$0$PyObject = ((t$1$PyObject = frame.getlocal(3)._is(frame.getglobal("None"))).__nonzero__() ? t$1$PyObject : frame.getlocal(3)._eq(s$3))).__nonzero__() ? t$0$PyObject : frame.getlocal(3).__getitem__(i$0)._ne(s$1)).__nonzero__()) {
                return new PyList(new PyObject[]{});
            }
            frame.getlocal(0).invoke("nestToNextLine");
            frame.setlocal(2, new PyList(new PyObject[]{}));
            while (i$2.__nonzero__()) {
                frame.setlocal(1, frame.getlocal(0).invoke("pop"));
                if (frame.getlocal(1)._is(frame.getglobal("None")).__nonzero__()) {
                    break;
                }
                frame.getlocal(2).invoke("append", frame.getlocal(1));
            }
            return frame.getlocal(2);
        }

        private static PyObject eatComments$20(PyFrame frame) {
            // Temporary Variables
            PyObject t$0$PyObject;

            // Code
            while (i$2.__nonzero__()) {
                frame.setlocal(1, frame.getlocal(0).__getattr__("stream").invoke("peek"));
                if (((t$0$PyObject = frame.getlocal(1)._is(frame.getglobal("None"))).__nonzero__() ? t$0$PyObject : frame.getglobal("re").__getattr__("match").__call__(s$5, frame.getlocal(1)).__not__()).__nonzero__()) {
                    return Py.None;
                }
                frame.getlocal(0).__getattr__("stream").invoke("pop");
            }
            return Py.None;
        }

        private static PyObject eatNewLines$21(PyFrame frame) {
            // Temporary Variables
            PyObject t$0$PyObject;

            // Code
            while (i$2.__nonzero__()) {
                frame.setlocal(1, frame.getlocal(0).__getattr__("stream").invoke("peek"));
                if (((t$0$PyObject = frame.getlocal(1)._is(frame.getglobal("None"))).__nonzero__() ? t$0$PyObject : frame.getglobal("len").__call__(frame.getglobal("string").__getattr__("strip").__call__(frame.getlocal(1)))).__nonzero__()) {
                    return Py.None;
                }
                frame.getlocal(0).__getattr__("stream").invoke("pop");
            }
            return Py.None;
        }

        private static PyObject nestToNextLine$22(PyFrame frame) {
            // Temporary Variables
            PyObject t$0$PyObject;

            // Code
            frame.getlocal(0).invoke("eatComments");
            frame.setlocal(1, frame.getlocal(0).__getattr__("stream").invoke("peek"));
            frame.setlocal(2, frame.getglobal("indentLevel").__call__(frame.getlocal(1)));
            if (((t$0$PyObject = frame.getglobal("len").__call__(frame.getlocal(0).__getattr__("oldIndents"))._gt(i$2)).__nonzero__() ? frame.getlocal(2)._le(frame.getlocal(0).__getattr__("indentLevel")) : t$0$PyObject).__nonzero__()) {
                frame.getlocal(0).invoke("error", s$6, frame.getlocal(1));
            }
            frame.getlocal(0).invoke("setNewIndent", frame.getlocal(2));
            return Py.None;
        }

        private static PyObject nestBySpecificAmount$23(PyFrame frame) {
            frame.getlocal(0).invoke("setNewIndent", frame.getlocal(0).__getattr__("indentLevel")._add(frame.getlocal(1)));
            return Py.None;
        }

        private static PyObject setNewIndent$24(PyFrame frame) {
            frame.getlocal(0).__getattr__("oldIndents").invoke("append", frame.getlocal(0).__getattr__("indentLevel"));
            frame.getlocal(0).__setattr__("indentLevel", frame.getlocal(1));
            return Py.None;
        }

        private static PyObject NestedText$25(PyFrame frame) {
            frame.setlocal("__init__", new PyFunction(frame.f_globals, new PyObject[]{}, c$12___init__));
            frame.setlocal("reset", new PyFunction(frame.f_globals, new PyObject[]{}, c$13_reset));
            frame.setlocal("lastLineRead", new PyFunction(frame.f_globals, new PyObject[]{}, c$14_lastLineRead));
            frame.setlocal("_peek", new PyFunction(frame.f_globals, new PyObject[]{}, c$15__peek));
            frame.setlocal("peek", new PyFunction(frame.f_globals, new PyObject[]{}, c$16_peek));
            frame.setlocal("pop", new PyFunction(frame.f_globals, new PyObject[]{}, c$17_pop));
            frame.setlocal("popNestedLines", new PyFunction(frame.f_globals, new PyObject[]{}, c$18_popNestedLines));
            frame.setlocal("eatComments", new PyFunction(frame.f_globals, new PyObject[]{}, c$19_eatComments));
            frame.setlocal("eatNewLines", new PyFunction(frame.f_globals, new PyObject[]{}, c$20_eatNewLines));
            frame.setlocal("nestToNextLine", new PyFunction(frame.f_globals, new PyObject[]{}, c$21_nestToNextLine));
            frame.setlocal("nestBySpecificAmount", new PyFunction(frame.f_globals, new PyObject[]{}, c$22_nestBySpecificAmount));
            frame.setlocal("setNewIndent", new PyFunction(frame.f_globals, new PyObject[]{}, c$23_setNewIndent));
            return frame.getf_locals();
        }

        private static PyObject __init__$26(PyFrame frame) {
            frame.getglobal("NestedText").invoke("__init__", frame.getlocal(0), frame.getlocal(1));
            frame.getlocal(0).invoke("eatNewLines");
            frame.setlocal(2, frame.getglobal("NestedText").invoke("peek", frame.getlocal(0)));
            frame.getlocal(0).__setattr__("sep", s$7);
            if (frame.getlocal(0).invoke("startsWithSep", frame.getlocal(2)).__nonzero__()) {
                frame.getlocal(0).__setattr__("eatenDocSep", frame.getglobal("NestedText").invoke("pop", frame.getlocal(0)));
            } else {
                frame.getlocal(0).__setattr__("eatenDocSep", frame.getlocal(0).__getattr__("sep"));
            }
            return Py.None;
        }

        private static PyObject startsWithSep$27(PyFrame frame) {
            // Temporary Variables
            PyObject t$0$PyObject;

            // Code
            if (((t$0$PyObject = frame.getlocal(1)).__nonzero__() ? frame.getlocal(0).__getattr__("sep")._eq(frame.getlocal(1).__getslice__(null, i$8, null)) : t$0$PyObject).__nonzero__()) {
                return i$2;
            }
            return i$0;
        }

        private static PyObject popDocSep$28(PyFrame frame) {
            frame.setlocal(1, frame.getlocal(0).__getattr__("eatenDocSep"));
            frame.getlocal(0).__setattr__("eatenDocSep", frame.getglobal("None"));
            frame.getlocal(0).invoke("reset");
            return frame.getlocal(1);
        }

        private static PyObject pop$29(PyFrame frame) {
            // Temporary Variables
            PyObject t$0$PyObject;

            // Code
            if (frame.getlocal(0).__getattr__("eatenDocSep")._isnot(frame.getglobal("None")).__nonzero__()) {
                throw Py.makeException(s$9);
            }
            frame.setlocal(1, frame.getlocal(0).invoke("_peek"));
            if (((t$0$PyObject = frame.getlocal(1)).__nonzero__() ? frame.getlocal(0).invoke("startsWithSep", frame.getlocal(1)) : t$0$PyObject).__nonzero__()) {
                frame.getlocal(0).__setattr__("eatenDocSep", frame.getglobal("NestedText").invoke("pop", frame.getlocal(0)));
                return frame.getglobal("None");
            }
            return frame.getglobal("NestedText").invoke("pop", frame.getlocal(0));
        }

        private static PyObject error$30(PyFrame frame) {
            throw Py.makeException(frame.getglobal("Exception").__call__(s$10._mod(new PyTuple(new PyObject[]{frame.getlocal(1), frame.getlocal(0).invoke("lastLineRead"), frame.getlocal(2)}))));
        }

        private static PyObject NestedDocs$31(PyFrame frame) {
            frame.setlocal("__init__", new PyFunction(frame.f_globals, new PyObject[]{}, c$25___init__));
            frame.setlocal("startsWithSep", new PyFunction(frame.f_globals, new PyObject[]{}, c$26_startsWithSep));
            frame.setlocal("popDocSep", new PyFunction(frame.f_globals, new PyObject[]{}, c$27_popDocSep));
            frame.setlocal("pop", new PyFunction(frame.f_globals, new PyObject[]{}, c$28_pop));
            frame.setlocal("error", new PyFunction(frame.f_globals, new PyObject[]{}, c$29_error));
            return frame.getf_locals();
        }

        private static PyObject noLineFeed$32(PyFrame frame) {
            while (frame.getlocal(0).__getslice__(i$2.__neg__(), null, null)._in(new PyTuple(new PyObject[]{s$4, s$11})).__nonzero__()) {
                frame.setlocal(0, frame.getlocal(0).__getslice__(null, i$2.__neg__(), null));
            }
            return frame.getlocal(0);
        }

        private static PyObject main$33(PyFrame frame) {
            frame.setglobal("__file__", s$12);

            frame.setlocal("re", org.python.core.imp.importOne("re", frame));
            frame.setlocal("string", org.python.core.imp.importOne("string", frame));
            frame.setlocal("indentLevel", new PyFunction(frame.f_globals, new PyObject[]{}, c$0_indentLevel));
            frame.setlocal("AbstractStream", Py.makeClass("AbstractStream", new PyObject[]{}, c$5_AbstractStream, null));
            frame.setlocal("FileStream", Py.makeClass("FileStream", new PyObject[]{frame.getname("AbstractStream")}, c$8_FileStream, null));
            frame.setlocal("StringStream", Py.makeClass("StringStream", new PyObject[]{frame.getname("AbstractStream")}, c$11_StringStream, null));
            frame.setlocal("NestedText", Py.makeClass("NestedText", new PyObject[]{}, c$24_NestedText, null));
            frame.setlocal("NestedDocs", Py.makeClass("NestedDocs", new PyObject[]{frame.getname("NestedText")}, c$30_NestedDocs, null));
            frame.setlocal("noLineFeed", new PyFunction(frame.f_globals, new PyObject[]{}, c$31_noLineFeed));
            return Py.None;
        }

    }

    public static void moduleDictInit(PyObject dict) {
        dict.__setitem__("__name__", new PyString("stream"));
        Py.runCode(new _PyInner().getMain(), dict, dict);
    }

    public static void main(String[] args) throws Exception {
        String[] newargs = new String[args.length + 1];
        newargs[0] = "stream";
        System.arraycopy(args, 0, newargs, 1, args.length);
        Py.runMain(stream._PyInner.class, newargs, jpy$packages, jpy$properties, "yaml", new String[]{"socket", "ftplib", "yaml.klass", "yaml.__init__", "dummy", "macurl2path", "rfc822", "string", "yaml.inline", "yaml.dump", "tempfile", "yaml.load", "base64", "sre", "StringIO", "copy_reg", "random", "getopt", "nturl2path", "httplib", "mimetools", "sre_parse", "sre_compile", "quopri", "yaml.implicit", "sre_constants", "javapath", "yaml.ypath", "urllib", "re", "mimetypes", "posixpath", "errno", "gopherlib", "yaml.stream", "stat", "yaml.timestamp", "javaos"});
    }

}
