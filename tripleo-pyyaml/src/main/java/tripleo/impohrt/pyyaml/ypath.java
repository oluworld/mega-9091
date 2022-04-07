package tripleo.impohrt.pyyaml;

import org.python.core.*;

public class ypath extends java.lang.Object {

    static String[] jpy$properties = new String[]{"python.modules.builtin", "exceptions:org.python.core.exceptions", "python.options.showJavaExceptions", "true"};
    static String[] jpy$packages = new String[]{"org.python.core", null, "java.lang", null, "java.io", null, "java.net", null};

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
        private static PyObject i$9;
        private static PyObject s$10;
        private static PyObject i$11;
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
        private static PyObject s$26;
        private static PyObject s$27;
        private static PyObject s$28;
        private static PyObject s$29;
        private static PyObject i$30;
        private static PyObject s$31;
        private static PyObject s$32;
        private static PyObject s$33;
        private static PyObject s$34;
        private static PyObject s$35;
        private static PyObject s$36;
        private static PyObject s$37;
        private static PyObject s$38;
        private static PyObject s$39;
        private static PyObject s$40;
        private static PyObject s$41;
        private static PyObject s$42;
        private static PyObject s$43;
        private static PyObject s$44;
        private static PyObject s$45;
        private static PyObject s$46;
        private static PyObject s$47;
        private static PyFunctionTable funcTable;
        private static PyCode c$0_escape;
        private static PyCode c$1___init__;
        private static PyCode c$2___setattr__;
        private static PyCode c$3___hash__;
        private static PyCode c$4___cmp__;
        private static PyCode c$5___str__;
        private static PyCode c$6_context;
        private static PyCode c$7_to_context;
        private static PyCode c$8_context_test;
        private static PyCode c$9___iter__;
        private static PyCode c$10_next_null;
        private static PyCode c$11_bind;
        private static PyCode c$12_apply;
        private static PyCode c$13_exists;
        private static PyCode c$14_null_seg;
        private static PyCode c$15___str__;
        private static PyCode c$16_next_self;
        private static PyCode c$17_bind;
        private static PyCode c$18_self_seg;
        private static PyCode c$19___str__;
        private static PyCode c$20_bind;
        private static PyCode c$21_root_seg;
        private static PyCode c$22___str__;
        private static PyCode c$23_bind;
        private static PyCode c$24_parent_seg;
        private static PyCode c$25___str__;
        private static PyCode c$26_next_wild;
        private static PyCode c$27_bind;
        private static PyCode c$28_wild_seg;
        private static PyCode c$29___str__;
        private static PyCode c$30_next;
        private static PyCode c$31_bind;
        private static PyCode c$32_trav_seg;
        private static PyCode c$33___str__;
        private static PyCode c$34___init__;
        private static PyCode c$35_bind;
        private static PyCode c$36_match_seg;
        private static PyCode c$37___str__;
        private static PyCode c$38___init__;
        private static PyCode c$39_next;
        private static PyCode c$40_bind;
        private static PyCode c$41_conn_seg;
        private static PyCode c$42___str__;
        private static PyCode c$43___init__;
        private static PyCode c$44_next;
        private static PyCode c$45_bind;
        private static PyCode c$46_pred_seg;
        private static PyCode c$47___str__;
        private static PyCode c$48___init__;
        private static PyCode c$49_next;
        private static PyCode c$50_bind;
        private static PyCode c$51_or_seg;
        private static PyCode c$52___init__;
        private static PyCode c$53___str__;
        private static PyCode c$54_value;
        private static PyCode c$55_scalar;
        private static PyCode c$56_exists_true;
        private static PyCode c$57_exists_false;
        private static PyCode c$58_exists_scalar;
        private static PyCode c$59_exists_segment;
        private static PyCode c$60___init__;
        private static PyCode c$61_equal_pred;
        private static PyCode c$62_parse_segment;
        private static PyCode c$63_parse_term;
        private static PyCode c$64_parse_predicate;
        private static PyCode c$65_parse_start;
        private static PyCode c$66_parse;
        private static PyCode c$67___init__;
        private static PyCode c$68_next;
        private static PyCode c$69_bind;
        private static PyCode c$70_convert_to_value;
        private static PyCode c$71_ypath;
        private static PyCode c$72_main;

        private static void initConstants() {
            s$0 = Py.newString("\012        summary: >\012            This function escapes a given key so that it\012            may appear within a ypath.  URI style escaping\012            is used so that ypath expressions can be a \012            valid URI expression.\012    ");
            s$1 = Py.newString("");
            s$2 = Py.newString("TODO: Support more than just string and integer keys.");
            s$3 = Py.newString("\012        summary: >\012            A ypath visit context through a YAML rooted graph.\012            This is implemented as a 3-tuple including the parent\012            node, the current key/index and the value.  This is\012            an immutable object so it can be cached.\012        properties: \012            key:    mapping key or index within the parent collection\012            value:  current value within the parent's range\012            parent: the parent context\012            root:   the very top of the yaml graph\012            path:   a tuple of the domain keys\012        notes: >\012            The context class doesn't yet handle going down the\012            domain side of the tree... \012    ");
            s$4 = Py.newString("\012            args:\012                parent: parent context (or None if this is the root)\012                key:    mapping key or index for this context\012                value:  value of current location...\012        ");
            s$5 = Py.newString("parent");
            s$6 = Py.newString("key");
            s$7 = Py.newString("value");
            s$8 = Py.newString("context is read-only");
            i$9 = Py.newInteger(1);
            s$10 = Py.newString("/");
            i$11 = Py.newInteger(0);
            s$12 = Py.newString("/key");
            s$13 = Py.newString("/key/0");
            s$14 = Py.newString("\012        summary: >\012            This is the simplest path segment, it\012            doesn't return any results and doesn't\012            depend upon its context.  It also happens to \012            be the base class which all segments derive.\012    ");
            s$15 = Py.newString("\012            summary: >\012                The bind function is called whenever\012                the parent context has changed.\012        ");
            s$16 = Py.newString("\012        summary: >\012            This path segment returns the context\012            node exactly once.\012    ");
            s$17 = Py.newString(".");
            s$18 = Py.newString("..");
            s$19 = Py.newString("\012        summary: >\012            The wild segment simply loops through\012            all of the sub-contexts for a given object.\012            If there aren't any children, this isn't an\012            error it just doesn't return anything.\012    ");
            s$20 = Py.newString("*");
            s$21 = Py.newString("\012        summary: >\012            This is a recursive traversal of the range, preorder.\012            It is a recursive combination of self and wild.\012    ");
            s$22 = Py.newString("\012        summary: >\012            Matches a particular key within the\012            current context.  Kinda boring.\012    ");
            s$23 = Py.newString("\012        summary: >\012            When two segments are connected via a slash,\012            this is a composite.  For each context of the\012            parent, it binds the child, and returns each\012            context of the child.\012    ");
            s$24 = Py.newString("/%s");
            s$25 = Py.newString("%s/%s");
            s$26 = Py.newString("%s[%s]");
            s$27 = Py.newString("%s|%s");
            s$28 = Py.newString("^(\\w+|/|\\.|\\*|\\\"|\\')");
            s$29 = Py.newString("\012        Segments occur between the slashes...\012    ");
            i$30 = Py.newInteger(2);
            s$31 = Py.newString("\"");
            s$32 = Py.newString("'");
            s$33 = Py.newString("^(\\w+|/|\\.|\\(|\\\"|\\')");
            s$34 = Py.newString("(");
            s$35 = Py.newString(")");
            s$36 = Py.newString("term expected: '%s'");
            s$37 = Py.newString("=");
            s$38 = Py.newString("No functions allowed... yet!");
            s$39 = Py.newString("]");
            s$40 = Py.newString("ypath: expecting operator '%s'");
            s$41 = Py.newString("\012        Initial checking on the expression, and \012        determine if it is relative or absolute.\012    ");
            s$42 = Py.newString("string required: ");
            s$43 = Py.newString("\012        This the parser entry point, the top level node\012        is always a root or self segment.  The self isn't\012        strictly necessary, but it keeps things simple.\012    ");
            s$44 = Py.newString("[");
            s$45 = Py.newString("|");
            s$46 = Py.newString("ypath parse error `%s`");
            s$47 = Py.newString("/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py");
            funcTable = new _PyInner();
            c$0_escape = Py.newCode(1, new String[]{"node", "typ"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "escape", false, false, funcTable, 0, null, null, 0, 1);
            c$1___init__ = Py.newCode(4, new String[]{"self", "parent", "key", "value"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "__init__", false, false, funcTable, 1, null, null, 0, 1);
            c$2___setattr__ = Py.newCode(3, new String[]{"self", "attname", "attval"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "__setattr__", false, false, funcTable, 2, null, null, 0, 1);
            c$3___hash__ = Py.newCode(1, new String[]{"self"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "__hash__", false, false, funcTable, 3, null, null, 0, 1);
            c$4___cmp__ = Py.newCode(2, new String[]{"self", "other"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "__cmp__", false, false, funcTable, 4, null, null, 0, 1);
            c$5___str__ = Py.newCode(1, new String[]{"self"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "__str__", false, false, funcTable, 5, null, null, 0, 1);
            c$6_context = Py.newCode(0, new String[]{}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "context", false, false, funcTable, 6, null, null, 0, 0);
            c$7_to_context = Py.newCode(1, new String[]{"target"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "to_context", false, false, funcTable, 7, null, null, 0, 1);
            c$8_context_test = Py.newCode(0, new String[]{"map", "lst", "z", "y", "x"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "context_test", false, false, funcTable, 8, null, null, 0, 1);
            c$9___iter__ = Py.newCode(1, new String[]{"self"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "__iter__", false, false, funcTable, 9, null, null, 0, 1);
            c$10_next_null = Py.newCode(1, new String[]{"self"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "next_null", false, false, funcTable, 10, null, null, 0, 1);
            c$11_bind = Py.newCode(2, new String[]{"self", "cntx"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "bind", false, false, funcTable, 11, null, null, 0, 1);
            c$12_apply = Py.newCode(2, new String[]{"self", "target"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "apply", false, false, funcTable, 12, null, null, 0, 1);
            c$13_exists = Py.newCode(2, new String[]{"self", "cntx"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "exists", false, false, funcTable, 13, null, null, 0, 1);
            c$14_null_seg = Py.newCode(0, new String[]{}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "null_seg", false, false, funcTable, 14, null, null, 0, 0);
            c$15___str__ = Py.newCode(1, new String[]{"self"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "__str__", false, false, funcTable, 15, null, null, 0, 1);
            c$16_next_self = Py.newCode(1, new String[]{"self"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "next_self", false, false, funcTable, 16, null, null, 0, 1);
            c$17_bind = Py.newCode(2, new String[]{"self", "cntx"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "bind", false, false, funcTable, 17, null, null, 0, 1);
            c$18_self_seg = Py.newCode(0, new String[]{}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "self_seg", false, false, funcTable, 18, null, null, 0, 0);
            c$19___str__ = Py.newCode(1, new String[]{"self"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "__str__", false, false, funcTable, 19, null, null, 0, 1);
            c$20_bind = Py.newCode(2, new String[]{"self", "cntx"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "bind", false, false, funcTable, 20, null, null, 0, 1);
            c$21_root_seg = Py.newCode(0, new String[]{}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "root_seg", false, false, funcTable, 21, null, null, 0, 0);
            c$22___str__ = Py.newCode(1, new String[]{"self"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "__str__", false, false, funcTable, 22, null, null, 0, 1);
            c$23_bind = Py.newCode(2, new String[]{"self", "cntx"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "bind", false, false, funcTable, 23, null, null, 0, 1);
            c$24_parent_seg = Py.newCode(0, new String[]{}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "parent_seg", false, false, funcTable, 24, null, null, 0, 0);
            c$25___str__ = Py.newCode(1, new String[]{"self"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "__str__", false, false, funcTable, 25, null, null, 0, 1);
            c$26_next_wild = Py.newCode(1, new String[]{"self", "key"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "next_wild", false, false, funcTable, 26, null, null, 0, 1);
            c$27_bind = Py.newCode(2, new String[]{"self", "cntx", "typ"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "bind", false, false, funcTable, 27, null, null, 0, 1);
            c$28_wild_seg = Py.newCode(0, new String[]{}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "wild_seg", false, false, funcTable, 28, null, null, 0, 0);
            c$29___str__ = Py.newCode(1, new String[]{"self"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "__str__", false, false, funcTable, 29, null, null, 0, 1);
            c$30_next = Py.newCode(1, new String[]{"self", "seg", "cntx"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "next", false, false, funcTable, 30, null, null, 0, 1);
            c$31_bind = Py.newCode(2, new String[]{"self", "cntx"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "bind", false, false, funcTable, 31, null, null, 0, 1);
            c$32_trav_seg = Py.newCode(0, new String[]{}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "trav_seg", false, false, funcTable, 32, null, null, 0, 0);
            c$33___str__ = Py.newCode(1, new String[]{"self"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "__str__", false, false, funcTable, 33, null, null, 0, 1);
            c$34___init__ = Py.newCode(2, new String[]{"self", "key"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "__init__", false, false, funcTable, 34, null, null, 0, 1);
            c$35_bind = Py.newCode(2, new String[]{"self", "cntx", "mtch"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "bind", false, false, funcTable, 35, null, null, 0, 1);
            c$36_match_seg = Py.newCode(0, new String[]{}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "match_seg", false, false, funcTable, 36, null, null, 0, 0);
            c$37___str__ = Py.newCode(1, new String[]{"self"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "__str__", false, false, funcTable, 37, null, null, 0, 1);
            c$38___init__ = Py.newCode(3, new String[]{"self", "parent", "child"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "__init__", false, false, funcTable, 38, null, null, 0, 1);
            c$39_next = Py.newCode(1, new String[]{"self", "cntx"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "next", false, false, funcTable, 39, null, null, 0, 1);
            c$40_bind = Py.newCode(2, new String[]{"self", "cntx"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "bind", false, false, funcTable, 40, null, null, 0, 1);
            c$41_conn_seg = Py.newCode(0, new String[]{}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "conn_seg", false, false, funcTable, 41, null, null, 0, 0);
            c$42___str__ = Py.newCode(1, new String[]{"self"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "__str__", false, false, funcTable, 42, null, null, 0, 1);
            c$43___init__ = Py.newCode(3, new String[]{"self", "parent", "filter"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "__init__", false, false, funcTable, 43, null, null, 0, 1);
            c$44_next = Py.newCode(1, new String[]{"self", "ret"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "next", false, false, funcTable, 44, null, null, 0, 1);
            c$45_bind = Py.newCode(2, new String[]{"self", "cntx"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "bind", false, false, funcTable, 45, null, null, 0, 1);
            c$46_pred_seg = Py.newCode(0, new String[]{}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "pred_seg", false, false, funcTable, 46, null, null, 0, 0);
            c$47___str__ = Py.newCode(1, new String[]{"self"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "__str__", false, false, funcTable, 47, null, null, 0, 1);
            c$48___init__ = Py.newCode(3, new String[]{"self", "lhs", "rhs"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "__init__", false, false, funcTable, 48, null, null, 0, 1);
            c$49_next = Py.newCode(1, new String[]{"self", "seg", "nxt"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "next", false, false, funcTable, 49, null, null, 0, 1);
            c$50_bind = Py.newCode(2, new String[]{"self", "cntx"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "bind", false, false, funcTable, 50, null, null, 0, 1);
            c$51_or_seg = Py.newCode(0, new String[]{}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "or_seg", false, false, funcTable, 51, null, null, 0, 0);
            c$52___init__ = Py.newCode(2, new String[]{"self", "val"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "__init__", false, false, funcTable, 52, null, null, 0, 1);
            c$53___str__ = Py.newCode(1, new String[]{"self"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "__str__", false, false, funcTable, 53, null, null, 0, 1);
            c$54_value = Py.newCode(1, new String[]{"self"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "value", false, false, funcTable, 54, null, null, 0, 1);
            c$55_scalar = Py.newCode(0, new String[]{}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "scalar", false, false, funcTable, 55, null, null, 0, 0);
            c$56_exists_true = Py.newCode(2, new String[]{"self", "cntx"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "exists_true", false, false, funcTable, 56, null, null, 0, 1);
            c$57_exists_false = Py.newCode(2, new String[]{"self", "cntx"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "exists_false", false, false, funcTable, 57, null, null, 0, 1);
            c$58_exists_scalar = Py.newCode(2, new String[]{"self", "cntx"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "exists_scalar", false, false, funcTable, 58, null, null, 0, 1);
            c$59_exists_segment = Py.newCode(2, new String[]{"self", "cntx"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "exists_segment", false, false, funcTable, 59, null, null, 0, 1);
            c$60___init__ = Py.newCode(3, new String[]{"self", "lhs", "rhs"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "__init__", false, false, funcTable, 60, null, null, 0, 1);
            c$61_equal_pred = Py.newCode(0, new String[]{}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "equal_pred", false, false, funcTable, 61, null, null, 0, 0);
            c$62_parse_segment = Py.newCode(1, new String[]{"expr", "siz", "seg", "mtch", "cur", "tok"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "parse_segment", false, false, funcTable, 62, null, null, 0, 1);
            c$63_parse_term = Py.newCode(1, new String[]{"expr", "siz", "val", "term", "mtch", "tok"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "parse_term", false, false, funcTable, 63, null, null, 0, 1);
            c$64_parse_predicate = Py.newCode(1, new String[]{"expr", "term", "rhs", "tok"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "parse_predicate", false, false, funcTable, 64, null, null, 0, 1);
            c$65_parse_start = Py.newCode(1, new String[]{"expr", "ypth"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "parse_start", false, false, funcTable, 65, null, null, 0, 1);
            c$66_parse = Py.newCode(1, new String[]{"expr", "filter", "child", "rhs", "ypth", "tok"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "parse", false, false, funcTable, 66, null, null, 0, 1);
            c$67___init__ = Py.newCode(2, new String[]{"self", "itr"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "__init__", false, false, funcTable, 67, null, null, 0, 1);
            c$68_next = Py.newCode(1, new String[]{"self"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "next", false, false, funcTable, 68, null, null, 0, 1);
            c$69_bind = Py.newCode(2, new String[]{"self", "cntx"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "bind", false, false, funcTable, 69, null, null, 0, 1);
            c$70_convert_to_value = Py.newCode(0, new String[]{}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "convert_to_value", false, false, funcTable, 70, null, null, 0, 0);
            c$71_ypath = Py.newCode(3, new String[]{"expr", "target", "cntx", "ret"}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "ypath", false, false, funcTable, 71, null, null, 0, 1);
            c$72_main = Py.newCode(0, new String[]{}, "/local/src/i/Rabbit3/runtime/py-lib/yaml/ypath.py", "main", false, false, funcTable, 72, null, null, 0, 0);
        }

        public PyCode getMain() {
            if (c$72_main == null) {
                _PyInner.initConstants();
            }
            return c$72_main;
        }

        public PyObject call_function(int index, PyFrame frame) {
            switch (index) {
                case 0:
                    return _PyInner.escape$1(frame);
                case 1:
                    return _PyInner.__init__$2(frame);
                case 2:
                    return _PyInner.__setattr__$3(frame);
                case 3:
                    return _PyInner.__hash__$4(frame);
                case 4:
                    return _PyInner.__cmp__$5(frame);
                case 5:
                    return _PyInner.__str__$6(frame);
                case 6:
                    return _PyInner.context$7(frame);
                case 7:
                    return _PyInner.to_context$8(frame);
                case 8:
                    return _PyInner.context_test$9(frame);
                case 9:
                    return _PyInner.__iter__$10(frame);
                case 10:
                    return _PyInner.next_null$11(frame);
                case 11:
                    return _PyInner.bind$12(frame);
                case 12:
                    return _PyInner.apply$13(frame);
                case 13:
                    return _PyInner.exists$14(frame);
                case 14:
                    return _PyInner.null_seg$15(frame);
                case 15:
                    return _PyInner.__str__$16(frame);
                case 16:
                    return _PyInner.next_self$17(frame);
                case 17:
                    return _PyInner.bind$18(frame);
                case 18:
                    return _PyInner.self_seg$19(frame);
                case 19:
                    return _PyInner.__str__$20(frame);
                case 20:
                    return _PyInner.bind$21(frame);
                case 21:
                    return _PyInner.root_seg$22(frame);
                case 22:
                    return _PyInner.__str__$23(frame);
                case 23:
                    return _PyInner.bind$24(frame);
                case 24:
                    return _PyInner.parent_seg$25(frame);
                case 25:
                    return _PyInner.__str__$26(frame);
                case 26:
                    return _PyInner.next_wild$27(frame);
                case 27:
                    return _PyInner.bind$28(frame);
                case 28:
                    return _PyInner.wild_seg$29(frame);
                case 29:
                    return _PyInner.__str__$30(frame);
                case 30:
                    return _PyInner.next$31(frame);
                case 31:
                    return _PyInner.bind$32(frame);
                case 32:
                    return _PyInner.trav_seg$33(frame);
                case 33:
                    return _PyInner.__str__$34(frame);
                case 34:
                    return _PyInner.__init__$35(frame);
                case 35:
                    return _PyInner.bind$36(frame);
                case 36:
                    return _PyInner.match_seg$37(frame);
                case 37:
                    return _PyInner.__str__$38(frame);
                case 38:
                    return _PyInner.__init__$39(frame);
                case 39:
                    return _PyInner.next$40(frame);
                case 40:
                    return _PyInner.bind$41(frame);
                case 41:
                    return _PyInner.conn_seg$42(frame);
                case 42:
                    return _PyInner.__str__$43(frame);
                case 43:
                    return _PyInner.__init__$44(frame);
                case 44:
                    return _PyInner.next$45(frame);
                case 45:
                    return _PyInner.bind$46(frame);
                case 46:
                    return _PyInner.pred_seg$47(frame);
                case 47:
                    return _PyInner.__str__$48(frame);
                case 48:
                    return _PyInner.__init__$49(frame);
                case 49:
                    return _PyInner.next$50(frame);
                case 50:
                    return _PyInner.bind$51(frame);
                case 51:
                    return _PyInner.or_seg$52(frame);
                case 52:
                    return _PyInner.__init__$53(frame);
                case 53:
                    return _PyInner.__str__$54(frame);
                case 54:
                    return _PyInner.value$55(frame);
                case 55:
                    return _PyInner.scalar$56(frame);
                case 56:
                    return _PyInner.exists_true$57(frame);
                case 57:
                    return _PyInner.exists_false$58(frame);
                case 58:
                    return _PyInner.exists_scalar$59(frame);
                case 59:
                    return _PyInner.exists_segment$60(frame);
                case 60:
                    return _PyInner.__init__$61(frame);
                case 61:
                    return _PyInner.equal_pred$62(frame);
                case 62:
                    return _PyInner.parse_segment$63(frame);
                case 63:
                    return _PyInner.parse_term$64(frame);
                case 64:
                    return _PyInner.parse_predicate$65(frame);
                case 65:
                    return _PyInner.parse_start$66(frame);
                case 66:
                    return _PyInner.parse$67(frame);
                case 67:
                    return _PyInner.__init__$68(frame);
                case 68:
                    return _PyInner.next$69(frame);
                case 69:
                    return _PyInner.bind$70(frame);
                case 70:
                    return _PyInner.convert_to_value$71(frame);
                case 71:
                    return _PyInner.ypath$72(frame);
                case 72:
                    return _PyInner.main$73(frame);
                default:
                    return null;
            }
        }

        private static PyObject escape$1(PyFrame frame) {
            /* 
                    summary: >
                        This function escapes a given key so that it
                        may appear within a ypath.  URI style escaping
                        is used so that ypath expressions can be a 
                        valid URI expression.
             */
            frame.setlocal(1, frame.getglobal("type").__call__(frame.getlocal(0)));
            if (frame.getlocal(1)._is(frame.getglobal("IntType")).__nonzero__()) {
                return frame.getglobal("str").__call__(frame.getlocal(0));
            }
            if (frame.getlocal(1)._is(frame.getglobal("StringType")).__nonzero__()) {
                return frame.getglobal("quote").__call__(frame.getlocal(0), s$1);
            }
            throw Py.makeException(frame.getglobal("ValueError").__call__(s$2));
        }

        private static PyObject __init__$2(PyFrame frame) {
            /* 
                        args:
                            parent: parent context (or None if this is the root)
                            key:    mapping key or index for this context
                            value:  value of current location...
             */
            frame.getlocal(0).__setattr__("parent", frame.getlocal(1));
            frame.getlocal(0).__setattr__("key", frame.getlocal(2));
            frame.getlocal(0).__setattr__("value", frame.getlocal(3));
            if (frame.getlocal(1).__nonzero__()) {
                if (frame.getglobal("__debug__").__nonzero__()) {
                    Py.assert_(frame.getlocal(1).__getattr__("__class__")._is(frame.getlocal(0).__getattr__("__class__")));
                }
                frame.getlocal(0).__setattr__("path", frame.getlocal(1).__getattr__("path")._add(new PyTuple(new PyObject[]{frame.getglobal("escape").__call__(frame.getlocal(2))})));
                frame.getlocal(0).__setattr__("root", frame.getlocal(1).__getattr__("root"));
            } else {
                if (frame.getglobal("__debug__").__nonzero__()) {
                    Py.assert_(frame.getlocal(2).__not__());
                }
                frame.getlocal(0).__setattr__("path", frame.getglobal("tuple").__call__());
                frame.getlocal(0).__setattr__("root", frame.getlocal(0));
            }
            return Py.None;
        }

        private static PyObject __setattr__$3(PyFrame frame) {
            if (frame.getlocal(1)._in(new PyTuple(new PyObject[]{s$5, s$6, s$7})).__nonzero__()) {
                if (frame.getlocal(0).__getattr__("__dict__").invoke("get", frame.getlocal(1)).__nonzero__()) {
                    throw Py.makeException(frame.getglobal("ValueError").__call__(s$8));
                }
            }
            frame.getlocal(0).__getattr__("__dict__").__setitem__(frame.getlocal(1), frame.getlocal(2));
            return Py.None;
        }

        private static PyObject __hash__$4(PyFrame frame) {
            return frame.getglobal("hash").__call__(frame.getlocal(0).__getattr__("path"));
        }

        private static PyObject __cmp__$5(PyFrame frame) {
            // Temporary Variables
            PyException t$0$PyException;

            // Code
            try {
                return frame.getglobal("cmp").__call__(frame.getlocal(0).__getattr__("path"), frame.getlocal(1).__getattr__("path"));
            } catch (Throwable x$0) {
                t$0$PyException = Py.setException(x$0, frame);
                if (Py.matchException(t$0$PyException, frame.getglobal("AttributeError"))) {
                    return i$9.__neg__();
                } else {
                    throw t$0$PyException;
                }
            }
        }

        private static PyObject __str__$6(PyFrame frame) {
            if (frame.getlocal(0).__getattr__("path").__nonzero__()) {
                return s$10.invoke("join", new PyTuple(new PyObject[]{s$1})._add(frame.getlocal(0).__getattr__("path")));
            } else {
                return s$10;
            }
        }

        private static PyObject context$7(PyFrame frame) {
            /* 
                    summary: >
                        A ypath visit context through a YAML rooted graph.
                        This is implemented as a 3-tuple including the parent
                        node, the current key/index and the value.  This is
                        an immutable object so it can be cached.
                    properties: 
                        key:    mapping key or index within the parent collection
                        value:  current value within the parent's range
                        parent: the parent context
                        root:   the very top of the yaml graph
                        path:   a tuple of the domain keys
                    notes: >
                        The context class doesn't yet handle going down the
                        domain side of the tree... 
             */
            frame.setlocal("__init__", new PyFunction(frame.f_globals, new PyObject[]{}, c$1___init__));
            frame.setlocal("__setattr__", new PyFunction(frame.f_globals, new PyObject[]{}, c$2___setattr__));
            frame.setlocal("__hash__", new PyFunction(frame.f_globals, new PyObject[]{}, c$3___hash__));
            frame.setlocal("__cmp__", new PyFunction(frame.f_globals, new PyObject[]{}, c$4___cmp__));
            frame.setlocal("__str__", new PyFunction(frame.f_globals, new PyObject[]{}, c$5___str__));
            return frame.getf_locals();
        }

        private static PyObject to_context$8(PyFrame frame) {
            if (frame.getglobal("type").__call__(frame.getlocal(0))._is(frame.getglobal("InstanceType")).__nonzero__()) {
                if (frame.getlocal(0).__getattr__("__class__")._is(frame.getglobal("context")).__nonzero__()) {
                    return frame.getlocal(0);
                }
            }
            return frame.getglobal("context").__call__(frame.getglobal("None"), frame.getglobal("None"), frame.getlocal(0));
        }

        private static PyObject context_test$9(PyFrame frame) {
            frame.setlocal(1, new PyList(new PyObject[]{s$7}));
            frame.setlocal(0, new PyDictionary(new PyObject[]{s$6, frame.getlocal(1)}));
            frame.setlocal(4, frame.getglobal("context").__call__(frame.getglobal("None"), frame.getglobal("None"), frame.getlocal(0)));
            frame.setlocal(3, frame.getglobal("context").__call__(frame.getlocal(4), s$6, frame.getlocal(1)));
            frame.setlocal(2, frame.getglobal("context").__call__(frame.getlocal(3), i$11, s$7));
            if (frame.getglobal("__debug__").__nonzero__()) {
                Py.assert_(new PyTuple(new PyObject[]{s$6})._eq(frame.getlocal(3).__getattr__("path")));
            }
            if (frame.getglobal("__debug__").__nonzero__()) {
                Py.assert_(s$6._eq(frame.getlocal(3).__getattr__("key")));
            }
            if (frame.getglobal("__debug__").__nonzero__()) {
                Py.assert_(frame.getlocal(1)._eq(frame.getlocal(3).__getattr__("value")));
            }
            if (frame.getglobal("__debug__").__nonzero__()) {
                Py.assert_(frame.getlocal(4)._eq(frame.getlocal(3).__getattr__("parent")));
            }
            if (frame.getglobal("__debug__").__nonzero__()) {
                Py.assert_(frame.getlocal(4)._eq(frame.getlocal(3).__getattr__("root")));
            }
            if (frame.getglobal("__debug__").__nonzero__()) {
                Py.assert_(i$11._eq(frame.getlocal(2).__getattr__("key")));
            }
            if (frame.getglobal("__debug__").__nonzero__()) {
                Py.assert_(s$7._eq(frame.getlocal(2).__getattr__("value")));
            }
            if (frame.getglobal("__debug__").__nonzero__()) {
                Py.assert_(frame.getlocal(3)._eq(frame.getlocal(2).__getattr__("parent")));
            }
            if (frame.getglobal("__debug__").__nonzero__()) {
                Py.assert_(frame.getlocal(4)._eq(frame.getlocal(2).__getattr__("root")));
            }
            if (frame.getglobal("__debug__").__nonzero__()) {
                Py.assert_(frame.getglobal("hash").__call__(frame.getlocal(4)));
            }
            if (frame.getglobal("__debug__").__nonzero__()) {
                Py.assert_(frame.getglobal("hash").__call__(frame.getlocal(3)));
            }
            if (frame.getglobal("__debug__").__nonzero__()) {
                Py.assert_(frame.getglobal("hash").__call__(frame.getlocal(2)));
            }
            if (frame.getglobal("__debug__").__nonzero__()) {
                Py.assert_(s$10._eq(frame.getglobal("str").__call__(frame.getlocal(4))));
            }
            if (frame.getglobal("__debug__").__nonzero__()) {
                Py.assert_(s$12._eq(frame.getglobal("str").__call__(frame.getlocal(3))));
            }
            if (frame.getglobal("__debug__").__nonzero__()) {
                Py.assert_(s$13._eq(frame.getglobal("str").__call__(frame.getlocal(2))));
            }
            return Py.None;
        }

        private static PyObject __iter__$10(PyFrame frame) {
            return frame.getlocal(0);
        }

        private static PyObject next_null$11(PyFrame frame) {
            throw Py.makeException(frame.getglobal("StopIteration"));
        }

        private static PyObject bind$12(PyFrame frame) {
            /* 
                        summary: >
                            The bind function is called whenever
                            the parent context has changed.
             */
            if (frame.getglobal("__debug__").__nonzero__()) {
                Py.assert_(frame.getlocal(1).__getattr__("__class__")._is(frame.getglobal("context")));
            }
            frame.getlocal(0).__setattr__("cntx", frame.getlocal(1));
            return Py.None;
        }

        private static PyObject apply$13(PyFrame frame) {
            frame.getlocal(0).invoke("bind", frame.getglobal("to_context").__call__(frame.getlocal(1)));
            return frame.getglobal("iter").__call__(frame.getlocal(0));
        }

        private static PyObject exists$14(PyFrame frame) {
            // Temporary Variables
            PyException t$0$PyException;

            // Code
            try {
                frame.getlocal(0).invoke("bind", frame.getlocal(1));
                frame.getlocal(0).invoke("next");
                return i$9;
            } catch (Throwable x$0) {
                t$0$PyException = Py.setException(x$0, frame);
                if (Py.matchException(t$0$PyException, frame.getglobal("StopIteration"))) {
                    return i$11;
                } else {
                    throw t$0$PyException;
                }
            }
        }

        private static PyObject null_seg$15(PyFrame frame) {
            /* 
                    summary: >
                        This is the simplest path segment, it
                        doesn't return any results and doesn't
                        depend upon its context.  It also happens to 
                        be the base class which all segments derive.
             */
            frame.setlocal("__iter__", new PyFunction(frame.f_globals, new PyObject[]{}, c$9___iter__));
            frame.setlocal("next_null", new PyFunction(frame.f_globals, new PyObject[]{}, c$10_next_null));
            frame.setlocal("bind", new PyFunction(frame.f_globals, new PyObject[]{}, c$11_bind));
            frame.setlocal("apply", new PyFunction(frame.f_globals, new PyObject[]{}, c$12_apply));
            frame.setlocal("exists", new PyFunction(frame.f_globals, new PyObject[]{}, c$13_exists));
            frame.setlocal("next", frame.getname("next_null"));
            return frame.getf_locals();
        }

        private static PyObject __str__$16(PyFrame frame) {
            return s$17;
        }

        private static PyObject next_self$17(PyFrame frame) {
            frame.getlocal(0).__setattr__("next", frame.getlocal(0).__getattr__("next_null"));
            return frame.getlocal(0).__getattr__("cntx");
        }

        private static PyObject bind$18(PyFrame frame) {
            frame.getglobal("null_seg").invoke("bind", frame.getlocal(0), frame.getlocal(1));
            frame.getlocal(0).__setattr__("next", frame.getlocal(0).__getattr__("next_self"));
            return Py.None;
        }

        private static PyObject self_seg$19(PyFrame frame) {
            /* 
                    summary: >
                        This path segment returns the context
                        node exactly once.
             */
            frame.setlocal("__str__", new PyFunction(frame.f_globals, new PyObject[]{}, c$15___str__));
            frame.setlocal("next_self", new PyFunction(frame.f_globals, new PyObject[]{}, c$16_next_self));
            frame.setlocal("bind", new PyFunction(frame.f_globals, new PyObject[]{}, c$17_bind));
            return frame.getf_locals();
        }

        private static PyObject __str__$20(PyFrame frame) {
            return s$10;
        }

        private static PyObject bind$21(PyFrame frame) {
            frame.getglobal("self_seg").invoke("bind", frame.getlocal(0), frame.getlocal(1).__getattr__("root"));
            return Py.None;
        }

        private static PyObject root_seg$22(PyFrame frame) {
            frame.setlocal("__str__", new PyFunction(frame.f_globals, new PyObject[]{}, c$19___str__));
            frame.setlocal("bind", new PyFunction(frame.f_globals, new PyObject[]{}, c$20_bind));
            return frame.getf_locals();
        }

        private static PyObject __str__$23(PyFrame frame) {
            return s$18;
        }

        private static PyObject bind$24(PyFrame frame) {
            if (frame.getlocal(1).__getattr__("parent").__nonzero__()) {
                frame.setlocal(1, frame.getlocal(1).__getattr__("parent"));
            }
            frame.getglobal("self_seg").invoke("bind", frame.getlocal(0), frame.getlocal(1));
            return Py.None;
        }

        private static PyObject parent_seg$25(PyFrame frame) {
            frame.setlocal("__str__", new PyFunction(frame.f_globals, new PyObject[]{}, c$22___str__));
            frame.setlocal("bind", new PyFunction(frame.f_globals, new PyObject[]{}, c$23_bind));
            return frame.getf_locals();
        }

        private static PyObject __str__$26(PyFrame frame) {
            return s$20;
        }

        private static PyObject next_wild$27(PyFrame frame) {
            frame.setlocal(1, frame.getlocal(0).__getattr__("keys").invoke("next"));
            return frame.getglobal("context").__call__(frame.getlocal(0).__getattr__("cntx"), frame.getlocal(1), frame.getlocal(0).__getattr__("values").__getitem__(frame.getlocal(1)));
        }

        private static PyObject bind$28(PyFrame frame) {
            frame.getglobal("null_seg").invoke("bind", frame.getlocal(0), frame.getlocal(1));
            frame.setlocal(2, frame.getglobal("type").__call__(frame.getlocal(1).__getattr__("value")));
            if (frame.getlocal(2)._is(frame.getglobal("ListType")).__nonzero__()) {
                frame.getlocal(0).__setattr__("keys", frame.getglobal("iter").__call__(frame.getglobal("xrange").__call__(i$11, frame.getglobal("len").__call__(frame.getlocal(1).__getattr__("value")))));
                frame.getlocal(0).__setattr__("values", frame.getlocal(1).__getattr__("value"));
                frame.getlocal(0).__setattr__("next", frame.getlocal(0).__getattr__("next_wild"));
                return Py.None;
            }
            if (frame.getlocal(2)._is(frame.getglobal("DictType")).__nonzero__()) {
                frame.getlocal(0).__setattr__("keys", frame.getglobal("iter").__call__(frame.getlocal(1).__getattr__("value")));
                frame.getlocal(0).__setattr__("values", frame.getlocal(1).__getattr__("value"));
                frame.getlocal(0).__setattr__("next", frame.getlocal(0).__getattr__("next_wild"));
                return Py.None;
            }
            frame.getlocal(0).__setattr__("next", frame.getlocal(0).__getattr__("next_null"));
            return Py.None;
        }

        private static PyObject wild_seg$29(PyFrame frame) {
            /* 
                    summary: >
                        The wild segment simply loops through
                        all of the sub-contexts for a given object.
                        If there aren't any children, this isn't an
                        error it just doesn't return anything.
             */
            frame.setlocal("__str__", new PyFunction(frame.f_globals, new PyObject[]{}, c$25___str__));
            frame.setlocal("next_wild", new PyFunction(frame.f_globals, new PyObject[]{}, c$26_next_wild));
            frame.setlocal("bind", new PyFunction(frame.f_globals, new PyObject[]{}, c$27_bind));
            return frame.getf_locals();
        }

        private static PyObject __str__$30(PyFrame frame) {
            return s$10;
        }

        private static PyObject next$31(PyFrame frame) {
            // Temporary Variables
            PyException t$0$PyException;
            PyObject t$0$PyObject;

            // Code
            while (i$9.__nonzero__()) {
                t$0$PyObject = frame.getlocal(0).__getattr__("stk").__getitem__(i$9.__neg__());
                frame.setlocal(2, t$0$PyObject.__getitem__(0));
                frame.setlocal(1, t$0$PyObject.__getitem__(1));
                if (frame.getlocal(1).__not__().__nonzero__()) {
                    frame.setlocal(1, frame.getglobal("wild_seg").__call__());
                    frame.getlocal(1).invoke("bind", frame.getlocal(2));
                    frame.getlocal(0).__getattr__("stk").__setitem__(i$9.__neg__(), new PyTuple(new PyObject[]{frame.getlocal(2), frame.getlocal(1)}));
                    return frame.getlocal(2);
                }
                try {
                    frame.setlocal(2, frame.getlocal(1).invoke("next"));
                    frame.getlocal(0).__getattr__("stk").invoke("append", new PyTuple(new PyObject[]{frame.getlocal(2), frame.getglobal("None")}));
                } catch (Throwable x$0) {
                    t$0$PyException = Py.setException(x$0, frame);
                    if (Py.matchException(t$0$PyException, frame.getglobal("StopIteration"))) {
                        frame.getlocal(0).__getattr__("stk").invoke("pop");
                        if (frame.getlocal(0).__getattr__("stk").__not__().__nonzero__()) {
                            frame.getlocal(0).__setattr__("next", frame.getlocal(0).__getattr__("next_null"));
                            throw Py.makeException(frame.getglobal("StopIteration"));
                        }
                    } else {
                        throw t$0$PyException;
                    }
                }
            }
            return Py.None;
        }

        private static PyObject bind$32(PyFrame frame) {
            frame.getglobal("null_seg").invoke("bind", frame.getlocal(0), frame.getlocal(1));
            frame.getlocal(0).__setattr__("stk", new PyList(new PyObject[]{new PyTuple(new PyObject[]{frame.getlocal(1), frame.getglobal("None")})}));
            return Py.None;
        }

        private static PyObject trav_seg$33(PyFrame frame) {
            /* 
                    summary: >
                        This is a recursive traversal of the range, preorder.
                        It is a recursive combination of self and wild.
             */
            frame.setlocal("__str__", new PyFunction(frame.f_globals, new PyObject[]{}, c$29___str__));
            frame.setlocal("next", new PyFunction(frame.f_globals, new PyObject[]{}, c$30_next));
            frame.setlocal("bind", new PyFunction(frame.f_globals, new PyObject[]{}, c$31_bind));
            return frame.getf_locals();
        }

        private static PyObject __str__$34(PyFrame frame) {
            return frame.getglobal("str").__call__(frame.getlocal(0).__getattr__("key"));
        }

        private static PyObject __init__$35(PyFrame frame) {
            // Temporary Variables
            PyException t$0$PyException;

            // Code
            try {
                frame.setlocal(1, frame.getglobal("int").__call__(frame.getlocal(1)));
            } catch (Throwable x$0) {
                t$0$PyException = Py.setException(x$0, frame);
                // pass
            }
            frame.getlocal(0).__setattr__("key", frame.getlocal(1));
            return Py.None;
        }

        private static PyObject bind$36(PyFrame frame) {
            // Temporary Variables
            PyException t$0$PyException;

            // Code
            try {
                frame.setlocal(2, frame.getlocal(1).__getattr__("value").__getitem__(frame.getlocal(0).__getattr__("key")));
                frame.setlocal(1, frame.getglobal("context").__call__(frame.getlocal(1), frame.getlocal(0).__getattr__("key"), frame.getlocal(2)));
                frame.getglobal("self_seg").invoke("bind", frame.getlocal(0), frame.getlocal(1));
            } catch (Throwable x$0) {
                t$0$PyException = Py.setException(x$0, frame);
                frame.getglobal("null_seg").invoke("bind", frame.getlocal(0), frame.getlocal(1));
            }
            return Py.None;
        }

        private static PyObject match_seg$37(PyFrame frame) {
            /* 
                    summary: >
                        Matches a particular key within the
                        current context.  Kinda boring.
             */
            frame.setlocal("__str__", new PyFunction(frame.f_globals, new PyObject[]{}, c$33___str__));
            frame.setlocal("__init__", new PyFunction(frame.f_globals, new PyObject[]{}, c$34___init__));
            frame.setlocal("bind", new PyFunction(frame.f_globals, new PyObject[]{}, c$35_bind));
            return frame.getf_locals();
        }

        private static PyObject __str__$38(PyFrame frame) {
            if (frame.getlocal(0).__getattr__("parent").__getattr__("__class__")._eq(frame.getglobal("root_seg")).__nonzero__()) {
                return s$24._mod(frame.getlocal(0).__getattr__("child"));
            }
            return s$25._mod(new PyTuple(new PyObject[]{frame.getlocal(0).__getattr__("parent"), frame.getlocal(0).__getattr__("child")}));
        }

        private static PyObject __init__$39(PyFrame frame) {
            frame.getlocal(0).__setattr__("parent", frame.getlocal(1));
            frame.getlocal(0).__setattr__("child", frame.getlocal(2));
            return Py.None;
        }

        private static PyObject next$40(PyFrame frame) {
            // Temporary Variables
            PyException t$0$PyException;

            // Code
            while (i$9.__nonzero__()) {
                try {
                    return frame.getlocal(0).__getattr__("child").invoke("next");
                } catch (Throwable x$0) {
                    t$0$PyException = Py.setException(x$0, frame);
                    if (Py.matchException(t$0$PyException, frame.getglobal("StopIteration"))) {
                        frame.setlocal(1, frame.getlocal(0).__getattr__("parent").invoke("next"));
                        frame.getlocal(0).__getattr__("child").invoke("bind", frame.getlocal(1));
                    } else {
                        throw t$0$PyException;
                    }
                }
            }
            return Py.None;
        }

        private static PyObject bind$41(PyFrame frame) {
            // Temporary Variables
            PyException t$0$PyException;

            // Code
            frame.getglobal("null_seg").invoke("bind", frame.getlocal(0), frame.getlocal(1));
            frame.getlocal(0).__getattr__("parent").invoke("bind", frame.getlocal(1));
            try {
                frame.setlocal(1, frame.getlocal(0).__getattr__("parent").invoke("next"));
            } catch (Throwable x$0) {
                t$0$PyException = Py.setException(x$0, frame);
                if (Py.matchException(t$0$PyException, frame.getglobal("StopIteration"))) {
                    return Py.None;
                } else {
                    throw t$0$PyException;
                }
            }
            frame.getlocal(0).__getattr__("child").invoke("bind", frame.getlocal(1));
            return Py.None;
        }

        private static PyObject conn_seg$42(PyFrame frame) {
            /* 
                    summary: >
                        When two segments are connected via a slash,
                        this is a composite.  For each context of the
                        parent, it binds the child, and returns each
                        context of the child.
             */
            frame.setlocal("__str__", new PyFunction(frame.f_globals, new PyObject[]{}, c$37___str__));
            frame.setlocal("__init__", new PyFunction(frame.f_globals, new PyObject[]{}, c$38___init__));
            frame.setlocal("next", new PyFunction(frame.f_globals, new PyObject[]{}, c$39_next));
            frame.setlocal("bind", new PyFunction(frame.f_globals, new PyObject[]{}, c$40_bind));
            return frame.getf_locals();
        }

        private static PyObject __str__$43(PyFrame frame) {
            return s$26._mod(new PyTuple(new PyObject[]{frame.getlocal(0).__getattr__("parent"), frame.getlocal(0).__getattr__("filter")}));
        }

        private static PyObject __init__$44(PyFrame frame) {
            frame.getlocal(0).__setattr__("parent", frame.getlocal(1));
            frame.getlocal(0).__setattr__("filter", frame.getlocal(2));
            return Py.None;
        }

        private static PyObject next$45(PyFrame frame) {
            while (i$9.__nonzero__()) {
                frame.setlocal(1, frame.getlocal(0).__getattr__("parent").invoke("next"));
                if (frame.getlocal(0).__getattr__("filter").invoke("exists", frame.getlocal(1)).__nonzero__()) {
                    return frame.getlocal(1);
                }
            }
            return Py.None;
        }

        private static PyObject bind$46(PyFrame frame) {
            frame.getglobal("null_seg").invoke("bind", frame.getlocal(0), frame.getlocal(1));
            frame.getlocal(0).__getattr__("parent").invoke("bind", frame.getlocal(1));
            return Py.None;
        }

        private static PyObject pred_seg$47(PyFrame frame) {
            frame.setlocal("__str__", new PyFunction(frame.f_globals, new PyObject[]{}, c$42___str__));
            frame.setlocal("__init__", new PyFunction(frame.f_globals, new PyObject[]{}, c$43___init__));
            frame.setlocal("next", new PyFunction(frame.f_globals, new PyObject[]{}, c$44_next));
            frame.setlocal("bind", new PyFunction(frame.f_globals, new PyObject[]{}, c$45_bind));
            return frame.getf_locals();
        }

        private static PyObject __str__$48(PyFrame frame) {
            return s$27._mod(new PyTuple(new PyObject[]{frame.getlocal(0).__getattr__("lhs"), frame.getlocal(0).__getattr__("rhs")}));
        }

        private static PyObject __init__$49(PyFrame frame) {
            frame.getlocal(0).__setattr__("rhs", frame.getlocal(2));
            frame.getlocal(0).__setattr__("lhs", frame.getlocal(1));
            frame.getlocal(0).__setattr__("unq", new PyDictionary(new PyObject[]{}));
            return Py.None;
        }

        private static PyObject next$50(PyFrame frame) {
            // Temporary Variables
            PyException t$0$PyException;

            // Code
            frame.setlocal(1, frame.getlocal(0).__getattr__("lhs"));
            try {
                frame.setlocal(2, frame.getlocal(1).invoke("next"));
                frame.getlocal(0).__getattr__("unq").__setitem__(frame.getlocal(2), frame.getlocal(2));
                return frame.getlocal(2);
            } catch (Throwable x$0) {
                t$0$PyException = Py.setException(x$0, frame);
                if (Py.matchException(t$0$PyException, frame.getglobal("StopIteration"))) {
                    // pass
                } else {
                    throw t$0$PyException;
                }
            }
            frame.setlocal(1, frame.getlocal(0).__getattr__("rhs"));
            while (i$9.__nonzero__()) {
                frame.setlocal(2, frame.getlocal(1).invoke("next"));
                if (frame.getlocal(0).__getattr__("unq").invoke("get", frame.getlocal(2), frame.getglobal("None")).__nonzero__()) {
                    continue;
                }
                return frame.getlocal(2);
            }
            return Py.None;
        }

        private static PyObject bind$51(PyFrame frame) {
            frame.getglobal("null_seg").invoke("bind", frame.getlocal(0), frame.getlocal(1));
            frame.getlocal(0).__getattr__("lhs").invoke("bind", frame.getlocal(1));
            frame.getlocal(0).__getattr__("rhs").invoke("bind", frame.getlocal(1));
            return Py.None;
        }

        private static PyObject or_seg$52(PyFrame frame) {
            frame.setlocal("__str__", new PyFunction(frame.f_globals, new PyObject[]{}, c$47___str__));
            frame.setlocal("__init__", new PyFunction(frame.f_globals, new PyObject[]{}, c$48___init__));
            frame.setlocal("next", new PyFunction(frame.f_globals, new PyObject[]{}, c$49_next));
            frame.setlocal("bind", new PyFunction(frame.f_globals, new PyObject[]{}, c$50_bind));
            return frame.getf_locals();
        }

        private static PyObject __init__$53(PyFrame frame) {
            frame.getlocal(0).__setattr__("val", frame.getlocal(1));
            return Py.None;
        }

        private static PyObject __str__$54(PyFrame frame) {
            return frame.getglobal("str").__call__(frame.getlocal(0).__getattr__("val"));
        }

        private static PyObject value$55(PyFrame frame) {
            return frame.getlocal(0).__getattr__("val");
        }

        private static PyObject scalar$56(PyFrame frame) {
            frame.setlocal("__init__", new PyFunction(frame.f_globals, new PyObject[]{}, c$52___init__));
            frame.setlocal("__str__", new PyFunction(frame.f_globals, new PyObject[]{}, c$53___str__));
            frame.setlocal("value", new PyFunction(frame.f_globals, new PyObject[]{}, c$54_value));
            return frame.getf_locals();
        }

        private static PyObject exists_true$57(PyFrame frame) {
            return i$9;
        }

        private static PyObject exists_false$58(PyFrame frame) {
            return i$11;
        }

        private static PyObject exists_scalar$59(PyFrame frame) {
            // Temporary Variables
            PyException t$0$PyException;

            // Code
            frame.getlocal(0).__getattr__("rhs").invoke("bind", frame.getlocal(1));
            try {
                while (i$9.__nonzero__()) {
                    frame.setlocal(1, frame.getlocal(0).__getattr__("rhs").invoke("next"));
                    if (frame.getglobal("str").__call__(frame.getlocal(1).__getattr__("value"))._eq(frame.getlocal(0).__getattr__("lhs")).__nonzero__()) {
                        return i$9;
                    }
                }
            } catch (Throwable x$0) {
                t$0$PyException = Py.setException(x$0, frame);
                if (Py.matchException(t$0$PyException, frame.getglobal("StopIteration"))) {
                    // pass
                } else {
                    throw t$0$PyException;
                }
            }
            return i$11;
        }

        private static PyObject exists_segment$60(PyFrame frame) {
            throw Py.makeException(frame.getglobal("NotImplementedError").__call__());
        }

        private static PyObject __init__$61(PyFrame frame) {
            // Temporary Variables
            PyObject t$0$PyObject;

            // Code
            if (frame.getlocal(1).__getattr__("__class__")._eq(frame.getglobal("scalar")).__nonzero__()) {
                if (frame.getlocal(2).__getattr__("__class__")._eq(frame.getglobal("scalar")).__nonzero__()) {
                    if (frame.getlocal(2).invoke("value")._eq(frame.getlocal(1).invoke("value")).__nonzero__()) {
                        frame.getlocal(0).__setattr__("exists", frame.getlocal(0).__getattr__("exists_true"));
                    } else {
                        frame.getlocal(0).__setattr__("exists", frame.getlocal(0).__getattr__("exists_false"));
                    }
                } else {
                    frame.getlocal(0).__setattr__("exists", frame.getlocal(0).__getattr__("exists_scalar"));
                }
            } else {
                if (frame.getlocal(2).__getattr__("__class__")._eq(frame.getglobal("scalar")).__nonzero__()) {
                    t$0$PyObject = new PyTuple(new PyObject[]{frame.getlocal(2), frame.getlocal(1)});
                    frame.setlocal(1, t$0$PyObject.__getitem__(0));
                    frame.setlocal(2, t$0$PyObject.__getitem__(1));
                    frame.getlocal(0).__setattr__("exists", frame.getlocal(0).__getattr__("exists_scalar"));
                } else {
                    frame.getlocal(0).__setattr__("exists", frame.getlocal(0).__getattr__("exists_segment"));
                }
            }
            frame.getlocal(0).__setattr__("lhs", frame.getglobal("str").__call__(frame.getlocal(1).invoke("value")));
            frame.getlocal(0).__setattr__("rhs", frame.getlocal(2));
            return Py.None;
        }

        private static PyObject equal_pred$62(PyFrame frame) {
            frame.setlocal("exists_true", new PyFunction(frame.f_globals, new PyObject[]{}, c$56_exists_true));
            frame.setlocal("exists_false", new PyFunction(frame.f_globals, new PyObject[]{}, c$57_exists_false));
            frame.setlocal("exists_scalar", new PyFunction(frame.f_globals, new PyObject[]{}, c$58_exists_scalar));
            frame.setlocal("exists_segment", new PyFunction(frame.f_globals, new PyObject[]{}, c$59_exists_segment));
            frame.setlocal("__init__", new PyFunction(frame.f_globals, new PyObject[]{}, c$60___init__));
            return frame.getf_locals();
        }

        private static PyObject parse_segment$63(PyFrame frame) {
            // Temporary Variables
            PyObject t$0$PyObject;

            // Code
            /* 
                    Segments occur between the slashes...
             */
            frame.setlocal(3, frame.getglobal("matchSegment").invoke("search", frame.getlocal(0)));
            if (frame.getlocal(3).__not__().__nonzero__()) {
                return new PyTuple(new PyObject[]{frame.getglobal("None"), frame.getlocal(0)});
            }
            frame.setlocal(5, frame.getlocal(3).invoke("group"));
            frame.setlocal(1, frame.getglobal("len").__call__(frame.getlocal(5)));
            if (s$10._eq(frame.getlocal(5)).__nonzero__()) {
                return new PyTuple(new PyObject[]{frame.getglobal("trav_seg").__call__(), frame.getlocal(0)});
            } else if (s$17._eq(frame.getlocal(5)).__nonzero__()) {
                if (((t$0$PyObject = frame.getglobal("len").__call__(frame.getlocal(0))._gt(i$9)).__nonzero__() ? s$17._eq(frame.getlocal(0).__getitem__(i$9)) : t$0$PyObject).__nonzero__()) {
                    frame.setlocal(2, frame.getglobal("parent_seg").__call__());
                    frame.setlocal(1, i$30);
                } else {
                    frame.setlocal(2, frame.getglobal("self_seg").__call__());
                }
            } else if (s$20._eq(frame.getlocal(5)).__nonzero__()) {
                frame.setlocal(2, frame.getglobal("wild_seg").__call__());
            } else if (((t$0$PyObject = s$31._eq(frame.getlocal(5))).__nonzero__() ? t$0$PyObject : s$32._eq(frame.getlocal(5))).__nonzero__()) {
                t$0$PyObject = frame.getglobal("unquote").__call__(frame.getlocal(0));
                frame.setlocal(4, t$0$PyObject.__getitem__(0));
                frame.setlocal(1, t$0$PyObject.__getitem__(1));
                frame.setlocal(2, frame.getglobal("match_seg").__call__(frame.getlocal(4)));
            } else {
                frame.setlocal(2, frame.getglobal("match_seg").__call__(frame.getlocal(5)));
            }
            return new PyTuple(new PyObject[]{frame.getlocal(2), frame.getlocal(0).__getslice__(frame.getlocal(1), null, null)});
        }

        private static PyObject parse_term$64(PyFrame frame) {
            // Temporary Variables
            PyObject t$0$PyObject;

            // Code
            frame.setlocal(4, frame.getglobal("matchTerm").invoke("search", frame.getlocal(0)));
            if (frame.getlocal(4).__not__().__nonzero__()) {
                return new PyTuple(new PyObject[]{frame.getglobal("None"), frame.getlocal(0)});
            }
            frame.setlocal(5, frame.getlocal(4).invoke("group"));
            frame.setlocal(1, frame.getglobal("len").__call__(frame.getlocal(5)));
            if (((t$0$PyObject = s$10._eq(frame.getlocal(5))).__nonzero__() ? t$0$PyObject : s$17._eq(frame.getlocal(5))).__nonzero__()) {
                return frame.getglobal("parse").__call__(frame.getlocal(0));
            }
            if (s$34._eq(frame.getlocal(5)).__nonzero__()) {
                t$0$PyObject = frame.getglobal("parse_predicate").__call__(frame.getlocal(0));
                frame.setlocal(3, t$0$PyObject.__getitem__(0));
                frame.setlocal(0, t$0$PyObject.__getitem__(1));
                if (frame.getglobal("__debug__").__nonzero__()) {
                    Py.assert_(s$35._eq(frame.getlocal(0).__getitem__(i$11)));
                }
                return new PyTuple(new PyObject[]{frame.getlocal(3), frame.getlocal(0).__getslice__(i$9, null, null)});
            } else if (((t$0$PyObject = s$31._eq(frame.getlocal(5))).__nonzero__() ? t$0$PyObject : s$32._eq(frame.getlocal(5))).__nonzero__()) {
                t$0$PyObject = frame.getglobal("unquote").__call__(frame.getlocal(0));
                frame.setlocal(2, t$0$PyObject.__getitem__(0));
                frame.setlocal(1, t$0$PyObject.__getitem__(1));
            } else {
                frame.setlocal(2, frame.getlocal(5));
                frame.setlocal(1, frame.getglobal("len").__call__(frame.getlocal(5)));
            }
            return new PyTuple(new PyObject[]{frame.getglobal("scalar").__call__(frame.getlocal(2)), frame.getlocal(0).__getslice__(frame.getlocal(1), null, null)});
        }

        private static PyObject parse_predicate$65(PyFrame frame) {
            // Temporary Variables
            PyObject t$0$PyObject;

            // Code
            t$0$PyObject = frame.getglobal("parse_term").__call__(frame.getlocal(0));
            frame.setlocal(1, t$0$PyObject.__getitem__(0));
            frame.setlocal(0, t$0$PyObject.__getitem__(1));
            if (frame.getlocal(1).__not__().__nonzero__()) {
                throw Py.makeException(frame.getglobal("SyntaxError").__call__(s$36._mod(frame.getlocal(0))));
            }
            frame.setlocal(3, frame.getlocal(0).__getitem__(i$11));
            if (s$37._eq(frame.getlocal(3)).__nonzero__()) {
                t$0$PyObject = frame.getglobal("parse_term").__call__(frame.getlocal(0).__getslice__(i$9, null, null));
                frame.setlocal(2, t$0$PyObject.__getitem__(0));
                frame.setlocal(0, t$0$PyObject.__getitem__(1));
                return new PyTuple(new PyObject[]{frame.getglobal("equal_pred").__call__(frame.getlocal(1), frame.getlocal(2)), frame.getlocal(0)});
            }
            if (s$34._eq(frame.getlocal(3)).__nonzero__()) {
                throw Py.makeException(s$38);
            }
            if (((t$0$PyObject = s$39._eq(frame.getlocal(3))).__nonzero__() ? t$0$PyObject : s$35._eq(frame.getlocal(3))).__nonzero__()) {
                if (frame.getlocal(1).__getattr__("__class__")._is(frame.getglobal("scalar")).__nonzero__()) {
                    frame.setlocal(1, frame.getglobal("match_seg").__call__(frame.getglobal("str").__call__(frame.getlocal(1))));
                }
                return new PyTuple(new PyObject[]{frame.getlocal(1), frame.getlocal(0)});
            }
            throw Py.makeException(frame.getglobal("SyntaxError").__call__(s$40._mod(frame.getlocal(0))));
        }

        private static PyObject parse_start$66(PyFrame frame) {
            // Temporary Variables
            PyObject t$0$PyObject;

            // Code
            /* 
                    Initial checking on the expression, and 
                    determine if it is relative or absolute.
             */
            if (((t$0$PyObject = frame.getglobal("type").__call__(frame.getlocal(0))._ne(frame.getglobal("StringType"))).__nonzero__() ? t$0$PyObject : frame.getglobal("len").__call__(frame.getlocal(0))._lt(i$9)).__nonzero__()) {
                throw Py.makeException(frame.getglobal("TypeError").__call__(s$42._add(frame.getglobal("repr").__call__(frame.getlocal(0)))));
            }
            if (s$10._eq(frame.getlocal(0).__getitem__(i$11)).__nonzero__()) {
                frame.setlocal(1, frame.getglobal("root_seg").__call__());
            } else {
                frame.setlocal(1, frame.getglobal("self_seg").__call__());
                frame.setlocal(0, s$10._add(frame.getlocal(0)));
            }
            return new PyTuple(new PyObject[]{frame.getlocal(1), frame.getlocal(0)});
        }

        private static PyObject parse$67(PyFrame frame) {
            // Temporary Variables
            PyObject t$0$PyObject;

            // Code
            /* 
                    This the parser entry point, the top level node
                    is always a root or self segment.  The self isn't
                    strictly necessary, but it keeps things simple.
             */
            t$0$PyObject = frame.getglobal("parse_start").__call__(frame.getlocal(0));
            frame.setlocal(4, t$0$PyObject.__getitem__(0));
            frame.setlocal(0, t$0$PyObject.__getitem__(1));
            while (frame.getlocal(0).__nonzero__()) {
                frame.setlocal(5, frame.getlocal(0).__getitem__(i$11));
                if (s$10._eq(frame.getlocal(5)).__nonzero__()) {
                    t$0$PyObject = frame.getglobal("parse_segment").__call__(frame.getlocal(0).__getslice__(i$9, null, null));
                    frame.setlocal(2, t$0$PyObject.__getitem__(0));
                    frame.setlocal(0, t$0$PyObject.__getitem__(1));
                    if (frame.getlocal(2).__nonzero__()) {
                        frame.setlocal(4, frame.getglobal("conn_seg").__call__(frame.getlocal(4), frame.getlocal(2)));
                    }
                    continue;
                }
                if (s$44._eq(frame.getlocal(5)).__nonzero__()) {
                    t$0$PyObject = frame.getglobal("parse_predicate").__call__(frame.getlocal(0).__getslice__(i$9, null, null));
                    frame.setlocal(1, t$0$PyObject.__getitem__(0));
                    frame.setlocal(0, t$0$PyObject.__getitem__(1));
                    if (frame.getglobal("__debug__").__nonzero__()) {
                        Py.assert_(s$39._eq(frame.getlocal(0).__getitem__(i$11)));
                    }
                    frame.setlocal(0, frame.getlocal(0).__getslice__(i$9, null, null));
                    frame.setlocal(4, frame.getglobal("pred_seg").__call__(frame.getlocal(4), frame.getlocal(1)));
                    continue;
                }
                if (s$45._eq(frame.getlocal(5)).__nonzero__()) {
                    t$0$PyObject = frame.getglobal("parse").__call__(frame.getlocal(0).__getslice__(i$9, null, null));
                    frame.setlocal(3, t$0$PyObject.__getitem__(0));
                    frame.setlocal(0, t$0$PyObject.__getitem__(1));
                    frame.setlocal(4, frame.getglobal("or_seg").__call__(frame.getlocal(4), frame.getlocal(3)));
                    continue;
                }
                if (s$34._eq(frame.getlocal(5)).__nonzero__()) {
                    t$0$PyObject = frame.getglobal("parse").__call__(frame.getlocal(0).__getslice__(i$9, null, null));
                    frame.setlocal(2, t$0$PyObject.__getitem__(0));
                    frame.setlocal(0, t$0$PyObject.__getitem__(1));
                    if (frame.getglobal("__debug__").__nonzero__()) {
                        Py.assert_(s$35._eq(frame.getlocal(0).__getitem__(i$11)));
                    }
                    frame.setlocal(0, frame.getlocal(0).__getslice__(i$9, null, null));
                    frame.setlocal(4, frame.getglobal("conn_seg").__call__(frame.getlocal(4), frame.getlocal(2)));
                    continue;
                }
                break;
            }
            return new PyTuple(new PyObject[]{frame.getlocal(4), frame.getlocal(0)});
        }

        private static PyObject __init__$68(PyFrame frame) {
            frame.getlocal(0).__setattr__("itr", frame.getlocal(1));
            return Py.None;
        }

        private static PyObject next$69(PyFrame frame) {
            return frame.getlocal(0).__getattr__("itr").invoke("next").__getattr__("value");
        }

        private static PyObject bind$70(PyFrame frame) {
            frame.getlocal(0).__getattr__("itr").invoke("bind", frame.getlocal(1));
            return Py.None;
        }

        private static PyObject convert_to_value$71(PyFrame frame) {
            frame.setlocal("__init__", new PyFunction(frame.f_globals, new PyObject[]{}, c$67___init__));
            frame.setlocal("next", new PyFunction(frame.f_globals, new PyObject[]{}, c$68_next));
            frame.setlocal("bind", new PyFunction(frame.f_globals, new PyObject[]{}, c$69_bind));
            return frame.getf_locals();
        }

        private static PyObject ypath$72(PyFrame frame) {
            // Temporary Variables
            PyObject t$0$PyObject;

            // Code
            t$0$PyObject = frame.getglobal("parse").__call__(frame.getlocal(0));
            frame.setlocal(3, t$0$PyObject.__getitem__(0));
            frame.setlocal(0, t$0$PyObject.__getitem__(1));
            if (frame.getlocal(0).__nonzero__()) {
                throw Py.makeException(frame.getglobal("SyntaxError").__call__(s$46._mod(frame.getlocal(0))));
            }
            if (frame.getlocal(2).__not__().__nonzero__()) {
                frame.setlocal(3, frame.getglobal("convert_to_value").__call__(frame.getlocal(3)));
            }
            if (frame.getlocal(1)._is(frame.getglobal("noTarget")).__nonzero__()) {
                return frame.getlocal(3);
            }
            return frame.getlocal(3).invoke("apply", frame.getlocal(1));
        }

        private static PyObject main$73(PyFrame frame) {
            frame.setglobal("__file__", s$47);

            PyObject[] imp_accu;
            // Code
            imp_accu = org.python.core.imp.importFrom("types", new String[]{"ListType", "StringType", "IntType", "DictType", "InstanceType"}, frame);
            frame.setlocal("ListType", imp_accu[0]);
            frame.setlocal("StringType", imp_accu[1]);
            frame.setlocal("IntType", imp_accu[2]);
            frame.setlocal("DictType", imp_accu[3]);
            frame.setlocal("InstanceType", imp_accu[4]);
            frame.setlocal("re", org.python.core.imp.importOne("re", frame));
            imp_accu = org.python.core.imp.importFrom("urllib", new String[]{"quote"}, frame);
            frame.setlocal("quote", imp_accu[0]);
            imp_accu = org.python.core.imp.importFrom("timestamp", new String[]{"unquote"}, frame);
            frame.setlocal("unquote", imp_accu[0]);
            frame.setlocal("noTarget", frame.getname("object").__call__());
            frame.setlocal("escape", new PyFunction(frame.f_globals, new PyObject[]{}, c$0_escape));
            frame.setlocal("context", Py.makeClass("context", new PyObject[]{}, c$6_context, null));
            frame.setlocal("to_context", new PyFunction(frame.f_globals, new PyObject[]{}, c$7_to_context));
            frame.setlocal("context_test", new PyFunction(frame.f_globals, new PyObject[]{}, c$8_context_test));
            frame.setlocal("null_seg", Py.makeClass("null_seg", new PyObject[]{}, c$14_null_seg, null));
            frame.setlocal("self_seg", Py.makeClass("self_seg", new PyObject[]{frame.getname("null_seg")}, c$18_self_seg, null));
            frame.setlocal("root_seg", Py.makeClass("root_seg", new PyObject[]{frame.getname("self_seg")}, c$21_root_seg, null));
            frame.setlocal("parent_seg", Py.makeClass("parent_seg", new PyObject[]{frame.getname("self_seg")}, c$24_parent_seg, null));
            frame.setlocal("wild_seg", Py.makeClass("wild_seg", new PyObject[]{frame.getname("null_seg")}, c$28_wild_seg, null));
            frame.setlocal("trav_seg", Py.makeClass("trav_seg", new PyObject[]{frame.getname("null_seg")}, c$32_trav_seg, null));
            frame.setlocal("match_seg", Py.makeClass("match_seg", new PyObject[]{frame.getname("self_seg")}, c$36_match_seg, null));
            frame.setlocal("conn_seg", Py.makeClass("conn_seg", new PyObject[]{frame.getname("null_seg")}, c$41_conn_seg, null));
            frame.setlocal("pred_seg", Py.makeClass("pred_seg", new PyObject[]{frame.getname("null_seg")}, c$46_pred_seg, null));
            frame.setlocal("or_seg", Py.makeClass("or_seg", new PyObject[]{frame.getname("null_seg")}, c$51_or_seg, null));
            frame.setlocal("scalar", Py.makeClass("scalar", new PyObject[]{}, c$55_scalar, null));
            frame.setlocal("equal_pred", Py.makeClass("equal_pred", new PyObject[]{}, c$61_equal_pred, null));
            frame.setlocal("matchSegment", frame.getname("re").__getattr__("compile").__call__(s$28));
            frame.setlocal("parse_segment", new PyFunction(frame.f_globals, new PyObject[]{}, c$62_parse_segment));
            frame.setlocal("matchTerm", frame.getname("re").__getattr__("compile").__call__(s$33));
            frame.setlocal("parse_term", new PyFunction(frame.f_globals, new PyObject[]{}, c$63_parse_term));
            frame.setlocal("parse_predicate", new PyFunction(frame.f_globals, new PyObject[]{}, c$64_parse_predicate));
            frame.setlocal("parse_start", new PyFunction(frame.f_globals, new PyObject[]{}, c$65_parse_start));
            frame.setlocal("parse", new PyFunction(frame.f_globals, new PyObject[]{}, c$66_parse));
            frame.setlocal("convert_to_value", Py.makeClass("convert_to_value", new PyObject[]{frame.getname("null_seg")}, c$70_convert_to_value, null));
            frame.setlocal("ypath", new PyFunction(frame.f_globals, new PyObject[]{frame.getname("noTarget"), i$11}, c$71_ypath));
            return Py.None;
        }

    }

    public static void moduleDictInit(PyObject dict) {
        dict.__setitem__("__name__", new PyString("ypath"));
        Py.runCode(new _PyInner().getMain(), dict, dict);
    }

    public static void main(String[] args) throws Exception {
        String[] newargs = new String[args.length + 1];
        newargs[0] = "ypath";
        System.arraycopy(args, 0, newargs, 1, args.length);
        Py.runMain(ypath._PyInner.class, newargs, jpy$packages, jpy$properties, "yaml", new String[]{"socket", "ftplib", "yaml.klass", "yaml.__init__", "dummy", "macurl2path", "rfc822", "string", "yaml.inline", "yaml.dump", "tempfile", "yaml.load", "base64", "sre", "StringIO", "copy_reg", "random", "getopt", "nturl2path", "httplib", "mimetools", "sre_parse", "sre_compile", "quopri", "yaml.implicit", "sre_constants", "javapath", "yaml.ypath", "urllib", "re", "mimetypes", "posixpath", "errno", "gopherlib", "yaml.stream", "stat", "yaml.timestamp", "javaos"});
    }

}
