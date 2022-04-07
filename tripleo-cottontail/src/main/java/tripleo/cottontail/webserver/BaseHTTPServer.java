package tripleo.cottontail.webserver;

import org.python.core.*;

public class BaseHTTPServer extends java.lang.Object {

    static String[] jpy$properties = new String[]{"python.modules.builtin", "exceptions:org.python.core.exceptions", "python.options.showJavaExceptions", "true"};
    static String[] jpy$packages = new String[]{"java.lang", null};

    public static class _PyInner extends PyFunctionTable implements PyRunnable {

        private static PyObject s$0;
        private static PyObject s$1;
        private static PyObject s$2;
        private static PyObject s$3;
        private static PyObject i$4;
        private static PyObject s$5;
        private static PyObject s$6;
        private static PyObject i$7;
        private static PyObject s$8;
        private static PyObject s$9;
        private static PyObject s$10;
        private static PyObject s$11;
        private static PyObject i$12;
        private static PyObject s$13;
        private static PyObject s$14;
        private static PyObject i$15;
        private static PyObject i$16;
        private static PyObject s$17;
        private static PyObject i$18;
        private static PyObject s$19;
        private static PyObject s$20;
        private static PyObject s$21;
        private static PyObject s$22;
        private static PyObject s$23;
        private static PyObject s$24;
        private static PyObject i$25;
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
        private static PyObject s$39;
        private static PyObject s$40;
        private static PyObject s$41;
        private static PyObject s$42;
        private static PyObject s$43;
        private static PyObject s$44;
        private static PyObject s$45;
        private static PyObject s$46;
        private static PyObject s$47;
        private static PyObject s$48;
        private static PyObject s$49;
        private static PyObject s$50;
        private static PyObject s$51;
        private static PyObject s$52;
        private static PyObject s$53;
        private static PyObject s$54;
        private static PyObject s$55;
        private static PyObject s$56;
        private static PyObject s$57;
        private static PyObject s$58;
        private static PyObject s$59;
        private static PyObject s$60;
        private static PyObject s$61;
        private static PyObject s$62;
        private static PyObject s$63;
        private static PyObject s$64;
        private static PyObject s$65;
        private static PyObject s$66;
        private static PyObject s$67;
        private static PyObject s$68;
        private static PyObject s$69;
        private static PyObject s$70;
        private static PyObject s$71;
        private static PyObject s$72;
        private static PyObject s$73;
        private static PyObject i$74;
        private static PyObject s$75;
        private static PyObject s$76;
        private static PyObject i$77;
        private static PyObject s$78;
        private static PyObject s$79;
        private static PyObject i$80;
        private static PyObject s$81;
        private static PyObject s$82;
        private static PyObject i$83;
        private static PyObject s$84;
        private static PyObject s$85;
        private static PyObject i$86;
        private static PyObject s$87;
        private static PyObject s$88;
        private static PyObject i$89;
        private static PyObject s$90;
        private static PyObject s$91;
        private static PyObject i$92;
        private static PyObject s$93;
        private static PyObject s$94;
        private static PyObject i$95;
        private static PyObject s$96;
        private static PyObject s$97;
        private static PyObject i$98;
        private static PyObject s$99;
        private static PyObject s$100;
        private static PyObject s$101;
        private static PyObject s$102;
        private static PyObject i$103;
        private static PyObject s$104;
        private static PyObject s$105;
        private static PyObject i$106;
        private static PyObject s$107;
        private static PyObject s$108;
        private static PyObject i$109;
        private static PyObject s$110;
        private static PyObject s$111;
        private static PyObject i$112;
        private static PyObject s$113;
        private static PyObject s$114;
        private static PyObject i$115;
        private static PyObject s$116;
        private static PyObject s$117;
        private static PyObject s$118;
        private static PyObject s$119;
        private static PyObject i$120;
        private static PyObject s$121;
        private static PyObject s$122;
        private static PyObject i$123;
        private static PyObject s$124;
        private static PyObject s$125;
        private static PyObject s$126;
        private static PyObject i$127;
        private static PyObject s$128;
        private static PyObject s$129;
        private static PyObject s$130;
        private static PyObject s$131;
        private static PyFunctionTable funcTable;
        private static PyCode c$0_server_bind;
        private static PyCode c$1_HTTPServer;
        private static PyCode c$2_parse_request;
        private static PyCode c$3_handle;
        private static PyCode c$4_send_error;
        private static PyCode c$5_send_response;
        private static PyCode c$6_send_header;
        private static PyCode c$7_end_headers;
        private static PyCode c$8_log_request;
        private static PyCode c$9_log_error;
        private static PyCode c$10_log_message;
        private static PyCode c$11_version_string;
        private static PyCode c$12_date_time_string;
        private static PyCode c$13_log_date_time_string;
        private static PyCode c$14_address_string;
        private static PyCode c$15_BaseHTTPRequestHandler;
        private static PyCode c$16_m;
        private static PyCode c$17_test;
        private static PyCode c$18_main;

        private static void initConstants() {
            s$0 = Py.newString("0.2");
            s$1 = Py.newString("HTTPServer");
            s$2 = Py.newString("BaseHTTPRequestHandler");
            s$3 = Py.newString("<head>\012<title>Error response</title>\012</head>\012<body>\012<h1>Error response</h1>\012<p>Error code %(code)d.\012<p>Message: %(message)s.\012<p>Error code explanation: %(code)s = %(explain)s.\012</body>\012");
            i$4 = Py.newInteger(1);
            s$5 = Py.newString("Override server_bind to store the server name.");
            s$6 = Py.newString("Python/");
            i$7 = Py.newInteger(0);
            s$8 = Py.newString("BaseHTTP/");
            s$9 = Py.newString("@sig public void parse_request()");
            s$10 = Py.newString("Parse a request (internal).\012\012\011\011The request should be stored in self.raw_request; the results\012\011\011are in self.command, self.path, self.request_version and\012\011\011self.headers.\012\012\011\011Return value is 1 for success, 0 for failure; on failure, an\012\011\011error is sent back.\012\012\011\011");
            s$11 = Py.newString("HTTP/0.9");
            i$12 = Py.newInteger(2);
            s$13 = Py.newString("\015\012");
            s$14 = Py.newString("\012");
            i$15 = Py.newInteger(3);
            i$16 = Py.newInteger(5);
            s$17 = Py.newString("HTTP/");
            i$18 = Py.newInteger(400);
            s$19 = Py.newString("Bad request version (%s)");
            s$20 = Py.newString("GET");
            s$21 = Py.newString("Bad HTTP/0.9 request type (%s)");
            s$22 = Py.newString("Bad request syntax (%s)");
            s$23 = Py.newString("Handle a single HTTP request.\012\012\011\011You normally don't need to override this method; see the class\012\011\011__doc__ string for information on how to handle specific HTTP\012\011\011commands such as GET and POST.\012\012\011\011");
            s$24 = Py.newString("do_");
            i$25 = Py.newInteger(501);
            s$26 = Py.newString("Unsupported method (%s)");
            s$27 = Py.newString("Send and log an error reply.\012\012\011\011Arguments are the error code, and a detailed message.\012\011\011The detailed message defaults to the short entry matching the\012\011\011response code.\012\012\011\011This sends an error response (so it must be called before any\012\011\011output has been generated), logs the error, and finally sends\012\011\011a piece of HTML explaining the error to the user.\012\012\011\011");
            s$28 = Py.newString("???");
            s$29 = Py.newString("code %d, message %s");
            s$30 = Py.newString("code");
            s$31 = Py.newString("message");
            s$32 = Py.newString("explain");
            s$33 = Py.newString("Send the response header and log the response code.\012\012\011\011Also send two standard headers with the server software\012\011\011version and the current date.\012\012\011\011");
            s$34 = Py.newString("");
            s$35 = Py.newString("%s %s %s\015\012");
            s$36 = Py.newString("Server");
            s$37 = Py.newString("Date");
            s$38 = Py.newString("Send a MIME header.");
            s$39 = Py.newString("%s: %s\015\012");
            s$40 = Py.newString("Send the blank line ending the MIME headers.");
            s$41 = Py.newString("Log an accepted request.\012\012\011\011This is called by send_reponse().\012\012\011\011");
            s$42 = Py.newString("\"%s\" %s %s");
            s$43 = Py.newString("-");
            s$44 = Py.newString("Log an error.\012\012\011\011This is called when a request cannot be fulfilled.  By\012\011\011default it passes the message on to log_message().\012\012\011\011Arguments are the same as for log_message().\012\012\011\011XXX This should go to the separate error log.\012\012\011\011");
            s$45 = Py.newString("Log an arbitrary message.\012\012\011\011This is used by all other logging functions.  Override\012\011\011it if you have specific logging wishes.\012\012\011\011The first argument, FORMAT, is a format string for the\012\011\011message to be logged.  If the format string contains\012\011\011any % escapes requiring parameters, they should be\012\011\011specified as subsequent arguments (it's just like\012\011\011printf!).\012\012\011\011The client host and current date/time are prefixed to\012\011\011every message.\012\012\011\011");
            s$46 = Py.newString("%s - - [%s] %s\012");
            s$47 = Py.newString("Return the server software version string.");
            s$48 = Py.newString(" ");
            s$49 = Py.newString("Return the current date and time formatted for a message header.");
            s$50 = Py.newString("%s, %02d %3s %4d %02d:%02d:%02d GMT");
            s$51 = Py.newString("Return the current time formatted for logging.");
            s$52 = Py.newString("%02d/%3s/%04d %02d:%02d:%02d");
            s$53 = Py.newString("Mon");
            s$54 = Py.newString("Tue");
            s$55 = Py.newString("Wed");
            s$56 = Py.newString("Thu");
            s$57 = Py.newString("Fri");
            s$58 = Py.newString("Sat");
            s$59 = Py.newString("Sun");
            s$60 = Py.newString("Jan");
            s$61 = Py.newString("Feb");
            s$62 = Py.newString("Mar");
            s$63 = Py.newString("Apr");
            s$64 = Py.newString("May");
            s$65 = Py.newString("Jun");
            s$66 = Py.newString("Jul");
            s$67 = Py.newString("Aug");
            s$68 = Py.newString("Sep");
            s$69 = Py.newString("Oct");
            s$70 = Py.newString("Nov");
            s$71 = Py.newString("Dec");
            s$72 = Py.newString("Return the client address formatted for logging.\012\012\011\011This version looks up the full hostname using gethostbyaddr(),\012\011\011and tries to find a name that contains at least one dot.\012\012\011\011");
            s$73 = Py.newString("HTTP/1.0");
            i$74 = Py.newInteger(200);
            s$75 = Py.newString("OK");
            s$76 = Py.newString("Request fulfilled, document follows");
            i$77 = Py.newInteger(201);
            s$78 = Py.newString("Created");
            s$79 = Py.newString("Document created, URL follows");
            i$80 = Py.newInteger(202);
            s$81 = Py.newString("Accepted");
            s$82 = Py.newString("Request accepted, processing continues off-line");
            i$83 = Py.newInteger(203);
            s$84 = Py.newString("Partial information");
            s$85 = Py.newString("Request fulfilled from cache");
            i$86 = Py.newInteger(204);
            s$87 = Py.newString("No response");
            s$88 = Py.newString("Request fulfilled, nothing follows");
            i$89 = Py.newInteger(301);
            s$90 = Py.newString("Moved");
            s$91 = Py.newString("Object moved permanently -- see URI list");
            i$92 = Py.newInteger(302);
            s$93 = Py.newString("Found");
            s$94 = Py.newString("Object moved temporarily -- see URI list");
            i$95 = Py.newInteger(303);
            s$96 = Py.newString("Method");
            s$97 = Py.newString("Object moved -- see Method and URL list");
            i$98 = Py.newInteger(304);
            s$99 = Py.newString("Not modified");
            s$100 = Py.newString("Document has not changed singe given time");
            s$101 = Py.newString("Bad request");
            s$102 = Py.newString("Bad request syntax or unsupported method");
            i$103 = Py.newInteger(401);
            s$104 = Py.newString("Unauthorized");
            s$105 = Py.newString("No permission -- see authorization schemes");
            i$106 = Py.newInteger(402);
            s$107 = Py.newString("Payment required");
            s$108 = Py.newString("No payment -- see charging schemes");
            i$109 = Py.newInteger(403);
            s$110 = Py.newString("Forbidden");
            s$111 = Py.newString("Request forbidden -- authorization will not help");
            i$112 = Py.newInteger(404);
            s$113 = Py.newString("Not found");
            s$114 = Py.newString("Nothing matches the given URI");
            i$115 = Py.newInteger(500);
            s$116 = Py.newString("Internal error");
            s$117 = Py.newString("Server got itself in trouble");
            s$118 = Py.newString("Not implemented");
            s$119 = Py.newString("Server does not support this operation");
            i$120 = Py.newInteger(502);
            s$121 = Py.newString("Service temporarily overloaded");
            s$122 = Py.newString("The server cannot process the request due to a high load");
            i$123 = Py.newInteger(503);
            s$124 = Py.newString("Gateway timeout");
            s$125 = Py.newString("The gateway server did not receive a timely response");
            s$126 = Py.newString("Test the HTTP request handler class.\012\012    This runs an HTTP server on port 8000 (or the first command line\012    argument).\012\012    ");
            i$127 = Py.newInteger(8000);
            s$128 = Py.newString("Serving HTTP on port");
            s$129 = Py.newString("...");
            s$130 = Py.newString("__main__");
            s$131 = Py.newString("/local/src/i/Rabbit/src/jpywork/BaseHTTPServer.py");
            funcTable = new _PyInner();
            c$0_server_bind = Py.newCode(1, new String[]{"self", "port", "host"}, "/local/src/i/Rabbit/src/jpywork/BaseHTTPServer.py", "server_bind", false, false, funcTable, 0, null, null, 0, 1);
            c$1_HTTPServer = Py.newCode(0, new String[]{}, "/local/src/i/Rabbit/src/jpywork/BaseHTTPServer.py", "HTTPServer", false, false, funcTable, 1, null, null, 0, 0);
            c$2_parse_request = Py.newCode(1, new String[]{"self", "requestline", "version", "path", "command", "words"}, "/local/src/i/Rabbit/src/jpywork/BaseHTTPServer.py", "parse_request", false, false, funcTable, 2, null, null, 0, 1);
            c$3_handle = Py.newCode(1, new String[]{"self", "mname", "method"}, "/local/src/i/Rabbit/src/jpywork/BaseHTTPServer.py", "handle", false, false, funcTable, 3, null, null, 0, 1);
            c$4_send_error = Py.newCode(3, new String[]{"self", "code", "message", "short", "explain", "long"}, "/local/src/i/Rabbit/src/jpywork/BaseHTTPServer.py", "send_error", false, false, funcTable, 4, null, null, 0, 1);
            c$5_send_response = Py.newCode(3, new String[]{"self", "code", "message"}, "/local/src/i/Rabbit/src/jpywork/BaseHTTPServer.py", "send_response", false, false, funcTable, 5, null, null, 0, 1);
            c$6_send_header = Py.newCode(3, new String[]{"self", "keyword", "value"}, "/local/src/i/Rabbit/src/jpywork/BaseHTTPServer.py", "send_header", false, false, funcTable, 6, null, null, 0, 1);
            c$7_end_headers = Py.newCode(1, new String[]{"self"}, "/local/src/i/Rabbit/src/jpywork/BaseHTTPServer.py", "end_headers", false, false, funcTable, 7, null, null, 0, 1);
            c$8_log_request = Py.newCode(3, new String[]{"self", "code", "size"}, "/local/src/i/Rabbit/src/jpywork/BaseHTTPServer.py", "log_request", false, false, funcTable, 8, null, null, 0, 1);
            c$9_log_error = Py.newCode(2, new String[]{"self", "args"}, "/local/src/i/Rabbit/src/jpywork/BaseHTTPServer.py", "log_error", true, false, funcTable, 9, null, null, 0, 1);
            c$10_log_message = Py.newCode(3, new String[]{"self", "format", "args"}, "/local/src/i/Rabbit/src/jpywork/BaseHTTPServer.py", "log_message", true, false, funcTable, 10, null, null, 0, 1);
            c$11_version_string = Py.newCode(1, new String[]{"self"}, "/local/src/i/Rabbit/src/jpywork/BaseHTTPServer.py", "version_string", false, false, funcTable, 11, null, null, 0, 1);
            c$12_date_time_string = Py.newCode(1, new String[]{"self", "now", "wd", "hh", "mm", "month", "z", "year", "y", "day", "s", "ss"}, "/local/src/i/Rabbit/src/jpywork/BaseHTTPServer.py", "date_time_string", false, false, funcTable, 12, null, null, 0, 1);
            c$13_log_date_time_string = Py.newCode(1, new String[]{"self", "now", "hh", "mm", "month", "z", "year", "y", "day", "x", "s", "ss"}, "/local/src/i/Rabbit/src/jpywork/BaseHTTPServer.py", "log_date_time_string", false, false, funcTable, 13, null, null, 0, 1);
            c$14_address_string = Py.newCode(1, new String[]{"self", "port", "host"}, "/local/src/i/Rabbit/src/jpywork/BaseHTTPServer.py", "address_string", false, false, funcTable, 14, null, null, 0, 1);
            c$15_BaseHTTPRequestHandler = Py.newCode(0, new String[]{}, "/local/src/i/Rabbit/src/jpywork/BaseHTTPServer.py", "BaseHTTPRequestHandler", false, false, funcTable, 15, null, null, 0, 0);
            c$16_m = Py.newCode(0, new String[]{}, "/local/src/i/Rabbit/src/jpywork/BaseHTTPServer.py", "m", false, false, funcTable, 16, null, null, 0, 0);
            c$17_test = Py.newCode(2, new String[]{"HandlerClass", "ServerClass", "httpd", "port", "server_address"}, "/local/src/i/Rabbit/src/jpywork/BaseHTTPServer.py", "test", false, false, funcTable, 17, null, null, 0, 1);
            c$18_main = Py.newCode(0, new String[]{}, "/local/src/i/Rabbit/src/jpywork/BaseHTTPServer.py", "main", false, false, funcTable, 18, null, null, 0, 0);
        }

        public PyCode getMain() {
            if (c$18_main == null) {
                _PyInner.initConstants();
            }
            return c$18_main;
        }

        public PyObject call_function(int index, PyFrame frame) {
            switch (index) {
                case 0:
                    return _PyInner.server_bind$1(frame);
                case 1:
                    return _PyInner.HTTPServer$2(frame);
                case 2:
                    return _PyInner.parse_request$3(frame);
                case 3:
                    return _PyInner.handle$4(frame);
                case 4:
                    return _PyInner.send_error$5(frame);
                case 5:
                    return _PyInner.send_response$6(frame);
                case 6:
                    return _PyInner.send_header$7(frame);
                case 7:
                    return _PyInner.end_headers$8(frame);
                case 8:
                    return _PyInner.log_request$9(frame);
                case 9:
                    return _PyInner.log_error$10(frame);
                case 10:
                    return _PyInner.log_message$11(frame);
                case 11:
                    return _PyInner.version_string$12(frame);
                case 12:
                    return _PyInner.date_time_string$13(frame);
                case 13:
                    return _PyInner.log_date_time_string$14(frame);
                case 14:
                    return _PyInner.address_string$15(frame);
                case 15:
                    return _PyInner.BaseHTTPRequestHandler$16(frame);
                case 16:
                    return _PyInner.m$17(frame);
                case 17:
                    return _PyInner.test$18(frame);
                case 18:
                    return _PyInner.main$19(frame);
                default:
                    return null;
            }
        }

        private static PyObject server_bind$1(PyFrame frame) {
            // Temporary Variables
            PyObject t$0$PyObject;

            // Code
            /* Override server_bind to store the server name. */
            frame.getglobal("SocketServer").__getattr__("TCPServer").__getattr__("server_bind").__call__(frame.getlocal(0));
            t$0$PyObject = frame.getlocal(0).__getattr__("socket").invoke("getsockname");
            frame.setlocal(2, t$0$PyObject.__getitem__(0));
            frame.setlocal(1, t$0$PyObject.__getitem__(1));
            frame.getlocal(0).__setattr__("server_name", frame.getglobal("socket").__getattr__("getfqdn").__call__(frame.getlocal(2)));
            frame.getlocal(0).__setattr__("server_port", frame.getlocal(1));
            return Py.None;
        }

        private static PyObject HTTPServer$2(PyFrame frame) {
            frame.setlocal("allow_reuse_address", i$4);
            frame.setlocal("server_bind", new PyFunction(frame.f_globals, new PyObject[]{}, c$0_server_bind));
            return frame.getf_locals();
        }

        private static PyObject parse_request$3(PyFrame frame) {
            // Temporary Variables
            PyObject t$0$PyObject;

            // Code
            /* @sig public void parse_request() */
 /* Parse a request (internal).
            
            		The request should be stored in self.raw_request; the results
            		are in self.command, self.path, self.request_version and
            		self.headers.
            
            		Return value is 1 for success, 0 for failure; on failure, an
            		error is sent back.
            
             */
            t$0$PyObject = s$11;
            frame.getlocal(0).__setattr__("request_version", t$0$PyObject);
            frame.setlocal(2, t$0$PyObject);
            frame.setlocal(1, frame.getlocal(0).__getattr__("raw_requestline"));
            if (frame.getlocal(1).__getslice__(i$12.__neg__(), null, null)._eq(s$13).__nonzero__()) {
                frame.setlocal(1, frame.getlocal(1).__getslice__(null, i$12.__neg__(), null));
            } else if (frame.getlocal(1).__getslice__(i$4.__neg__(), null, null)._eq(s$14).__nonzero__()) {
                frame.setlocal(1, frame.getlocal(1).__getslice__(null, i$4.__neg__(), null));
            }
            frame.getlocal(0).__setattr__("requestline", frame.getlocal(1));
            frame.setlocal(5, frame.getlocal(1).invoke("split"));
            if (frame.getglobal("len").__call__(frame.getlocal(5))._eq(i$15).__nonzero__()) {
                t$0$PyObject = frame.getlocal(5);
                frame.setlocal(4, t$0$PyObject.__getitem__(0));
                frame.setlocal(3, t$0$PyObject.__getitem__(1));
                frame.setlocal(2, t$0$PyObject.__getitem__(2));
                if (frame.getlocal(2).__getslice__(null, i$16, null)._ne(s$17).__nonzero__()) {
                    frame.getlocal(0).invoke("send_error", i$18, s$19._mod(frame.getlocal(2).__repr__()));
                    return i$7;
                }
            } else if (frame.getglobal("len").__call__(frame.getlocal(5))._eq(i$12).__nonzero__()) {
                t$0$PyObject = frame.getlocal(5);
                frame.setlocal(4, t$0$PyObject.__getitem__(0));
                frame.setlocal(3, t$0$PyObject.__getitem__(1));
                if (frame.getlocal(4)._ne(s$20).__nonzero__()) {
                    frame.getlocal(0).invoke("send_error", i$18, s$21._mod(frame.getlocal(4).__repr__()));
                    return i$7;
                }
            } else {
                frame.getlocal(0).invoke("send_error", i$18, s$22._mod(frame.getlocal(1).__repr__()));
                return i$7;
            }
            t$0$PyObject = new PyTuple(new PyObject[]{frame.getlocal(4), frame.getlocal(3), frame.getlocal(2)});
            frame.getlocal(0).__setattr__("command", t$0$PyObject.__getitem__(0));
            frame.getlocal(0).__setattr__("path", t$0$PyObject.__getitem__(1));
            frame.getlocal(0).__setattr__("request_version", t$0$PyObject.__getitem__(2));
            frame.getlocal(0).__setattr__("headers", frame.getlocal(0).invoke("MessageClass", frame.getlocal(0).__getattr__("rfile"), i$7));
            return i$4;
        }

        private static PyObject handle$4(PyFrame frame) {
            /* Handle a single HTTP request.
            
            		You normally don't need to override this method; see the class
            		__doc__ string for information on how to handle specific HTTP
            		commands such as GET and POST.
            
             */
            frame.getlocal(0).__setattr__("raw_requestline", frame.getlocal(0).__getattr__("rfile").invoke("readline"));
            if (frame.getlocal(0).invoke("parse_request").__not__().__nonzero__()) {
                return Py.None;
            }
            frame.setlocal(1, s$24._add(frame.getlocal(0).__getattr__("command")));
            if (frame.getglobal("hasattr").__call__(frame.getlocal(0), frame.getlocal(1)).__not__().__nonzero__()) {
                frame.getlocal(0).invoke("send_error", i$25, s$26._mod(frame.getlocal(0).__getattr__("command").__repr__()));
                return Py.None;
            }
            frame.setlocal(2, frame.getglobal("getattr").__call__(frame.getlocal(0), frame.getlocal(1)));
            frame.getlocal(2).__call__();
            return Py.None;
        }

        private static PyObject send_error$5(PyFrame frame) {
            // Temporary Variables
            PyException t$0$PyException;
            PyObject t$0$PyObject;

            // Code
            /* Send and log an error reply.
            
            		Arguments are the error code, and a detailed message.
            		The detailed message defaults to the short entry matching the
            		response code.
            
            		This sends an error response (so it must be called before any
            		output has been generated), logs the error, and finally sends
            		a piece of HTML explaining the error to the user.
            
             */
            try {
                t$0$PyObject = frame.getlocal(0).__getattr__("responses").__getitem__(frame.getlocal(1));
                frame.setlocal(3, t$0$PyObject.__getitem__(0));
                frame.setlocal(5, t$0$PyObject.__getitem__(1));
            } catch (Throwable x$0) {
                t$0$PyException = Py.setException(x$0, frame);
                if (Py.matchException(t$0$PyException, frame.getglobal("KeyError"))) {
                    t$0$PyObject = new PyTuple(new PyObject[]{s$28, s$28});
                    frame.setlocal(3, t$0$PyObject.__getitem__(0));
                    frame.setlocal(5, t$0$PyObject.__getitem__(1));
                } else {
                    throw t$0$PyException;
                }
            }
            if (frame.getlocal(2).__not__().__nonzero__()) {
                frame.setlocal(2, frame.getlocal(3));
            }
            frame.setlocal(4, frame.getlocal(5));
            frame.getlocal(0).invoke("log_error", new PyObject[]{s$29, frame.getlocal(1), frame.getlocal(2)});
            frame.getlocal(0).invoke("send_response", frame.getlocal(1), frame.getlocal(2));
            frame.getlocal(0).invoke("end_headers");
            frame.getlocal(0).__getattr__("wfile").invoke("write", frame.getlocal(0).__getattr__("error_message_format")._mod(new PyDictionary(new PyObject[]{s$30, frame.getlocal(1), s$31, frame.getlocal(2), s$32, frame.getlocal(4)})));
            return Py.None;
        }

        private static PyObject send_response$6(PyFrame frame) {
            /* Send the response header and log the response code.
            
            		Also send two standard headers with the server software
            		version and the current date.
            
             */
            frame.getlocal(0).invoke("log_request", frame.getlocal(1));
            if (frame.getlocal(2)._is(frame.getglobal("None")).__nonzero__()) {
                if (frame.getlocal(0).__getattr__("responses").invoke("has_key", frame.getlocal(1)).__nonzero__()) {
                    frame.setlocal(2, frame.getlocal(0).__getattr__("responses").__getitem__(frame.getlocal(1)).__getitem__(i$7));
                } else {
                    frame.setlocal(2, s$34);
                }
            }
            if (frame.getlocal(0).__getattr__("request_version")._ne(s$11).__nonzero__()) {
                frame.getlocal(0).__getattr__("wfile").invoke("write", s$35._mod(new PyTuple(new PyObject[]{frame.getlocal(0).__getattr__("protocol_version"), frame.getglobal("str").__call__(frame.getlocal(1)), frame.getlocal(2)})));
            }
            frame.getlocal(0).invoke("send_header", s$36, frame.getlocal(0).invoke("version_string"));
            frame.getlocal(0).invoke("send_header", s$37, frame.getlocal(0).invoke("date_time_string"));
            return Py.None;
        }

        private static PyObject send_header$7(PyFrame frame) {
            /* Send a MIME header. */
            if (frame.getlocal(0).__getattr__("request_version")._ne(s$11).__nonzero__()) {
                frame.getlocal(0).__getattr__("wfile").invoke("write", s$39._mod(new PyTuple(new PyObject[]{frame.getlocal(1), frame.getlocal(2)})));
            }
            return Py.None;
        }

        private static PyObject end_headers$8(PyFrame frame) {
            /* Send the blank line ending the MIME headers. */
            if (frame.getlocal(0).__getattr__("request_version")._ne(s$11).__nonzero__()) {
                frame.getlocal(0).__getattr__("wfile").invoke("write", s$13);
            }
            return Py.None;
        }

        private static PyObject log_request$9(PyFrame frame) {
            /* Log an accepted request.
            
            		This is called by send_reponse().
            
             */
            frame.getlocal(0).invoke("log_message", new PyObject[]{s$42, frame.getlocal(0).__getattr__("requestline"), frame.getglobal("str").__call__(frame.getlocal(1)), frame.getglobal("str").__call__(frame.getlocal(2))});
            return Py.None;
        }

        private static PyObject log_error$10(PyFrame frame) {
            /* Log an error.
            
            		This is called when a request cannot be fulfilled.  By
            		default it passes the message on to log_message().
            
            		Arguments are the same as for log_message().
            
            		XXX This should go to the separate error log.
            
             */
            frame.getglobal("apply").__call__(frame.getlocal(0).__getattr__("log_message"), frame.getlocal(1));
            return Py.None;
        }

        private static PyObject log_message$11(PyFrame frame) {
            /* Log an arbitrary message.
            
            		This is used by all other logging functions.  Override
            		it if you have specific logging wishes.
            
            		The first argument, FORMAT, is a format string for the
            		message to be logged.  If the format string contains
            		any % escapes requiring parameters, they should be
            		specified as subsequent arguments (it's just like
            		printf!).
            
            		The client host and current date/time are prefixed to
            		every message.
            
             */
            frame.getglobal("sys").__getattr__("stderr").__getattr__("write").__call__(s$46._mod(new PyTuple(new PyObject[]{frame.getlocal(0).invoke("address_string"), frame.getlocal(0).invoke("log_date_time_string"), frame.getlocal(1)._mod(frame.getlocal(2))})));
            return Py.None;
        }

        private static PyObject version_string$12(PyFrame frame) {
            /* Return the server software version string. */
            return frame.getlocal(0).__getattr__("server_version")._add(s$48)._add(frame.getlocal(0).__getattr__("sys_version"));
        }

        private static PyObject date_time_string$13(PyFrame frame) {
            // Temporary Variables
            PyObject t$0$PyObject;

            // Code
            /* Return the current date and time formatted for a message header. */
            frame.setlocal(1, frame.getglobal("time").__getattr__("time").__call__());
            t$0$PyObject = frame.getglobal("time").__getattr__("gmtime").__call__(frame.getlocal(1));
            frame.setlocal(7, t$0$PyObject.__getitem__(0));
            frame.setlocal(5, t$0$PyObject.__getitem__(1));
            frame.setlocal(9, t$0$PyObject.__getitem__(2));
            frame.setlocal(3, t$0$PyObject.__getitem__(3));
            frame.setlocal(4, t$0$PyObject.__getitem__(4));
            frame.setlocal(11, t$0$PyObject.__getitem__(5));
            frame.setlocal(2, t$0$PyObject.__getitem__(6));
            frame.setlocal(8, t$0$PyObject.__getitem__(7));
            frame.setlocal(6, t$0$PyObject.__getitem__(8));
            frame.setlocal(10, s$50._mod(new PyTuple(new PyObject[]{frame.getlocal(0).__getattr__("weekdayname").__getitem__(frame.getlocal(2)), frame.getlocal(9), frame.getlocal(0).__getattr__("monthname").__getitem__(frame.getlocal(5)), frame.getlocal(7), frame.getlocal(3), frame.getlocal(4), frame.getlocal(11)})));
            return frame.getlocal(10);
        }

        private static PyObject log_date_time_string$14(PyFrame frame) {
            // Temporary Variables
            PyObject t$0$PyObject;

            // Code
            /* Return the current time formatted for logging. */
            frame.setlocal(1, frame.getglobal("time").__getattr__("time").__call__());
            t$0$PyObject = frame.getglobal("time").__getattr__("localtime").__call__(frame.getlocal(1));
            frame.setlocal(6, t$0$PyObject.__getitem__(0));
            frame.setlocal(4, t$0$PyObject.__getitem__(1));
            frame.setlocal(8, t$0$PyObject.__getitem__(2));
            frame.setlocal(2, t$0$PyObject.__getitem__(3));
            frame.setlocal(3, t$0$PyObject.__getitem__(4));
            frame.setlocal(11, t$0$PyObject.__getitem__(5));
            frame.setlocal(9, t$0$PyObject.__getitem__(6));
            frame.setlocal(7, t$0$PyObject.__getitem__(7));
            frame.setlocal(5, t$0$PyObject.__getitem__(8));
            frame.setlocal(10, s$52._mod(new PyTuple(new PyObject[]{frame.getlocal(8), frame.getlocal(0).__getattr__("monthname").__getitem__(frame.getlocal(4)), frame.getlocal(6), frame.getlocal(2), frame.getlocal(3), frame.getlocal(11)})));
            return frame.getlocal(10);
        }

        private static PyObject address_string$15(PyFrame frame) {
            // Temporary Variables
            PyObject t$0$PyObject;

            // Code
            /* Return the client address formatted for logging.
            
            		This version looks up the full hostname using gethostbyaddr(),
            		and tries to find a name that contains at least one dot.
            
             */
            t$0$PyObject = frame.getlocal(0).__getattr__("client_address");
            frame.setlocal(2, t$0$PyObject.__getitem__(0));
            frame.setlocal(1, t$0$PyObject.__getitem__(1));
            return frame.getglobal("socket").__getattr__("getfqdn").__call__(frame.getlocal(2));
        }

        private static PyObject BaseHTTPRequestHandler$16(PyFrame frame) {
            frame.setlocal("sys_version", s$6._add(frame.getname("sys").__getattr__("version").__getattr__("split").__call__().__getitem__(i$7)));
            frame.setlocal("server_version", s$8._add(frame.getname("__version__")));
            frame.setlocal("parse_request", new PyFunction(frame.f_globals, new PyObject[]{}, c$2_parse_request));
            frame.setlocal("handle", new PyFunction(frame.f_globals, new PyObject[]{}, c$3_handle));
            frame.setlocal("send_error", new PyFunction(frame.f_globals, new PyObject[]{frame.getname("None")}, c$4_send_error));
            frame.setlocal("error_message_format", frame.getname("DEFAULT_ERROR_MESSAGE"));
            frame.setlocal("send_response", new PyFunction(frame.f_globals, new PyObject[]{frame.getname("None")}, c$5_send_response));
            frame.setlocal("send_header", new PyFunction(frame.f_globals, new PyObject[]{}, c$6_send_header));
            frame.setlocal("end_headers", new PyFunction(frame.f_globals, new PyObject[]{}, c$7_end_headers));
            frame.setlocal("log_request", new PyFunction(frame.f_globals, new PyObject[]{s$43, s$43}, c$8_log_request));
            frame.setlocal("log_error", new PyFunction(frame.f_globals, new PyObject[]{}, c$9_log_error));
            frame.setlocal("log_message", new PyFunction(frame.f_globals, new PyObject[]{}, c$10_log_message));
            frame.setlocal("version_string", new PyFunction(frame.f_globals, new PyObject[]{}, c$11_version_string));
            frame.setlocal("date_time_string", new PyFunction(frame.f_globals, new PyObject[]{}, c$12_date_time_string));
            frame.setlocal("log_date_time_string", new PyFunction(frame.f_globals, new PyObject[]{}, c$13_log_date_time_string));
            frame.setlocal("weekdayname", new PyList(new PyObject[]{s$53, s$54, s$55, s$56, s$57, s$58, s$59}));
            frame.setlocal("monthname", new PyList(new PyObject[]{frame.getname("None"), s$60, s$61, s$62, s$63, s$64, s$65, s$66, s$67, s$68, s$69, s$70, s$71}));
            frame.setlocal("address_string", new PyFunction(frame.f_globals, new PyObject[]{}, c$14_address_string));
            frame.setlocal("protocol_version", s$73);
            frame.setlocal("MessageClass", frame.getname("mimetools").__getattr__("Message"));
            frame.setlocal("responses", new PyDictionary(new PyObject[]{i$74, new PyTuple(new PyObject[]{s$75, s$76}), i$77, new PyTuple(new PyObject[]{s$78, s$79}), i$80, new PyTuple(new PyObject[]{s$81, s$82}), i$83, new PyTuple(new PyObject[]{s$84, s$85}), i$86, new PyTuple(new PyObject[]{s$87, s$88}), i$89, new PyTuple(new PyObject[]{s$90, s$91}), i$92, new PyTuple(new PyObject[]{s$93, s$94}), i$95, new PyTuple(new PyObject[]{s$96, s$97}), i$98, new PyTuple(new PyObject[]{s$99, s$100}), i$18, new PyTuple(new PyObject[]{s$101, s$102}), i$103, new PyTuple(new PyObject[]{s$104, s$105}), i$106, new PyTuple(new PyObject[]{s$107, s$108}), i$109, new PyTuple(new PyObject[]{s$110, s$111}), i$112, new PyTuple(new PyObject[]{s$113, s$114}), i$115, new PyTuple(new PyObject[]{s$116, s$117}), i$25, new PyTuple(new PyObject[]{s$118, s$119}), i$120, new PyTuple(new PyObject[]{s$121, s$122}), i$123, new PyTuple(new PyObject[]{s$124, s$125})}));
            return frame.getf_locals();
        }

        private static PyObject m$17(PyFrame frame) {
            // pass
            return frame.getf_locals();
        }

        private static PyObject test$18(PyFrame frame) {
            /* Test the HTTP request handler class.
            
                This runs an HTTP server on port 8000 (or the first command line
                argument).
            
             */
            if (frame.getglobal("sys").__getattr__("argv").__getslice__(i$4, null, null).__nonzero__()) {
                frame.setlocal(3, frame.getglobal("int").__call__(frame.getglobal("sys").__getattr__("argv").__getitem__(i$4)));
            } else {
                frame.setlocal(3, i$127);
            }
            frame.setlocal(4, new PyTuple(new PyObject[]{s$34, frame.getlocal(3)}));
            frame.setlocal(2, frame.getlocal(1).__call__(frame.getlocal(4), frame.getlocal(0)));
            Py.printComma(s$128);
            Py.printComma(frame.getlocal(3));
            Py.println(s$129);
            frame.getlocal(2).invoke("serve_forever");
            return Py.None;
        }

        private static PyObject main$19(PyFrame frame) {
            frame.setglobal("__file__", s$131);

            frame.setlocal("__version__", s$0);
            frame.setlocal("__all__", new PyList(new PyObject[]{s$1, s$2}));
            frame.setlocal("jobject", org.python.core.imp.importOneAs("java.lang.object", frame));
            frame.setlocal("sys", org.python.core.imp.importOne("sys", frame));
            frame.setlocal("time", org.python.core.imp.importOne("time", frame));
            frame.setlocal("socket", org.python.core.imp.importOne("socket", frame));
            frame.setlocal("mimetools", org.python.core.imp.importOne("mimetools", frame));
            frame.setlocal("SocketServer", org.python.core.imp.importOne("SocketServer", frame));
            frame.setlocal("DEFAULT_ERROR_MESSAGE", s$3);
            frame.setlocal("HTTPServer", Py.makeClass("HTTPServer", new PyObject[]{frame.getname("SocketServer").__getattr__("TCPServer"), frame.getname("jobject")}, c$1_HTTPServer, null));
            frame.setlocal("BaseHTTPRequestHandler", Py.makeClass("BaseHTTPRequestHandler", new PyObject[]{frame.getname("SocketServer").__getattr__("StreamRequestHandler")}, c$15_BaseHTTPRequestHandler, null));
            frame.setlocal("m", Py.makeClass("m", new PyObject[]{frame.getname("jobject"), frame.getname("BaseHTTPRequestHandler")}, c$16_m, null));
            frame.setlocal("test", new PyFunction(frame.f_globals, new PyObject[]{frame.getname("BaseHTTPRequestHandler"), frame.getname("HTTPServer")}, c$17_test));
            if (frame.getname("__name__")._eq(s$130).__nonzero__()) {
                frame.getname("test").__call__();
            }
            return Py.None;
        }

    }

    public static void moduleDictInit(PyObject dict) {
        dict.__setitem__("__name__", new PyString("BaseHTTPServer"));
        Py.runCode(new _PyInner().getMain(), dict, dict);
    }

    public static void main(String[] args) {
        String[] newargs = new String[args.length + 1];
        newargs[0] = "BaseHTTPServer";
        System.arraycopy(args, 0, newargs, 1, args.length);
        Py.runMain("tripleo.cottontail.webserver.BaseHTTPServer$_PyInner", newargs, jpy$packages, jpy$properties, null, new String[]{"BaseHTTPServer"});
    }

}
