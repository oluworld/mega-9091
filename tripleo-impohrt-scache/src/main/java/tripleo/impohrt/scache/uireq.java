package tripleo.impohrt.scache;

/*
 *  Smart Cache, http proxy cache server
 *  Copyright (C) 1998-2003 Radim Kolar
 *
 *    Smart Cache is Open Source Software; you may redistribute it
 *  and/or modify it under the terms of the GNU General Public
 *  License as published by the Free Software Foundation; either
 *  version 2, or (at your option) any later version.
 *
 *    This program distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 *  General Public License for more details.
 *
 *    A copy of the GNU General Public License is available as
 *  /usr/doc/copyright/GPL in the Debian GNU/Linux distribution or on
 *  the World Wide Web at http://www.gnu.org/copyleft/gpl.html. You
 *  can also obtain it by writing to the Free Software Foundation,
 *  Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */
import java.io.*;
import java.net.Socket;
import java.util.Date;
import java.util.StringTokenizer;
import tripleo.fs.File;

public class uireq implements Runnable {

    Socket s;
    DataInputStream in;
    DataOutputStream ou;
    boolean http10;

    uireq(Socket cs) {
        s = cs;
    }

    public void run() {
        http10 = true;
        boolean badhost = false;
        try {
            in = new DataInputStream(new BufferedInputStream(s.getInputStream()));
            ou = new DataOutputStream(new BufferedOutputStream(s.getOutputStream()));

            /* precteme radku GET / */
            s.setSoTimeout(httpreq.client_timeout);

            String req = in.readLine();
            if (req == null) {
                s.close();
                ou.close();
                s = null;
                ou = null;
                return;
            }
            if (httpreq.trace_timestamp) {
                System.out.println("[UI TRACE " + Thread.currentThread().getName() + "] T Current time " + new Date());
            }
            if (httpreq.trace_url == true) {
                System.out.println("[UI TRACE " + Thread.currentThread().getName() + "] > " + req);
            }

            StringTokenizer st = new StringTokenizer(req);
            int req_method;
            req_method = req.indexOf(" HTTP/1.", 0);
            if (req_method == -1) {
                http10 = false;
            } else {
                while (true) {
                    String line;
                    /* read rest of HTTP headers */
                    line = in.readLine();
                    if (line == null) {
                        break;
                    }
                    if (line.length() == 0) {
                        break;
                    }
                    String s1, s2;
                    int j;
                    j = line.indexOf(':', 0);
                    if (j == -1) {
                        continue;
                    }
                    s1 = line.substring(0, j).toLowerCase();
                    s2 = line.substring(j + 1);
                    if (s1.equals("host") && s2.indexOf(ui.ui_hostname) == -1) {
                        badhost = true;
                    }
                }
            }
            String req2 = null;

            if (!req.startsWith("GET ")) {
                httpreq.server_error(http10 ? 10 : 9, 501, "Only GET access method is possible for UI", ou);
            }
            /* access check */
            if (!mgr.checkInetAdr(s.getInetAddress().getAddress())) {
                httpreq.server_error(http10 ? 10 : 9, 403, "Cache access denied.", ou);
            }

            /* extract URL as req2 */
            int space;
            space = req.indexOf(' ');
            if (space == -1) {
                httpreq.server_error(http10 ? 10 : 9, 400, "Can not find method and URI in request", ou);
            }
            if (req_method == -1) {
                req2 = req.substring(space + 1);
            } else {
                req2 = req.substring(space + 1, req_method);
            }

            req2 = req2.trim();
            if (req2.length() == 0) {
                httpreq.server_error(http10 ? 10 : 9, 400, "Can not find URI in request", ou);
            }

            if (req2.charAt(0) != '/') {
                httpreq.server_error(http10 ? 10 : 9, 400, "Request URL not starting with /", ou);
            }
            /* handle redirected homepage */
            if (req2.equals("/")) {
                req2 = "/homepage";
                badhost = true;
            }

            if (badhost == false) {
                send_reply(ui.process(req2));
            } else {
                StringBuilder ans = new StringBuilder(2048);
                ans.append("HTTP/1.0 301 Wrong_HOSTNAME\r\nContent-Type: text/html\r\n");
                ans.append("Location: http://");
                ans.append(ui.ui_hostname);
                ans.append(':');
                ans.append(ui.uiport);
                ans.append(req2);
                ans.append("\r\n\r\nBAD HOSTNAME/REDIRECTING TO WELCOME PAGE!\n");

                ou.writeBytes(ans.toString());
                ou.close();
                ou = null;
                s = null;
            }
        } catch (IOException err) {
        }
    }

    public final void send_reply(String reply) throws IOException {
        StringBuilder ans = new StringBuilder(2048);
        if (http10) {
            ans.append("HTTP/1.0 200 UI Reply Follows\r\n");
            ans.append("Server: ");
            ans.append(scache.CACHENAME);
            ans.append(" UI ");
            ans.append(ui.VERSION);
            ans.append("\r\nPragma: no-cache\r\nCache-Control: no-cache\r\nExpires: Sat, 03 Jan 1970 07:33:19 GMT\r\nContent-Type: text/html\r\nConnection: close\r\n\r\n");
        }
        if (reply == null) {
            ans.append("{-No reply- from UI. This is an internal error. }\n");
        } else {
            ans.append(reply);
        }
        ou.writeBytes(ans.toString());
        ou.close();
        ou = null;
        s = null;
    }

}
