package tripleo.impohrt.elifarley;

/*
Portions of this software are Copyright (c) 1993 -
2001, Chad Z. Hower (Kudzu) and the Indy Pit Crew -
http://www.nevrona.com/Indy/

Portions of this software are Copyright (c) 2001, 
Elifarley Callado Coelho -
http://www.geocities.com/elifarley/

License

Redistribution and use in source and binary forms,
with or without modification, are permitted provided that
the following conditions are met:

*       Redistributions of source code must retain the above
copyright notice, this list of conditions and the following
disclaimer. 
*       Redistributions in binary form must reproduce the above
copyright notice, this list of conditions and the following
disclaimer in the documentation, about box and/or other
materials provided with the distribution. 
*       No personal names or organizations names associated
with the Indy project may be used to endorse or promote
products derived from this software without specific prior
written permission of the specific individual or
organization. 

THIS SOFTWARE IS PROVIDED BY Chad Z. Hower (Kudzu) and the
Indy Pit Crew "AS IS'' AND ANY EXPRESS OR IMPLIED
WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE REGENTS OR
CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

 */

 /* ZeeProxy 1.0.0 alpha 2 -- Example application.
 * Copyright (C) 2001 Elifarley Callado Coelho
 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License, version 2,
 * as published by the Free Software Foundation;

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.

 * See the file "COPYING" for the software license.
 
 * Elifarley Callado Coelho
 * Belo Horizonte, Brazil
 * elifarley@yahoo.com
 * http://www.geocities.com/elifarley/
 *
 
 */
import java.io.IOException;

import elifarley.io.VersaStream;
import elifarley.io.VersaStreamFactory;
import elifarley.io.fs.*;
import elifarley.jandy.*;
import elifarley.razip.RAZipConstants;

public class ZeeProxy implements RAZipConstants {

    protected static boolean archLoaded = false;
    public static final int PORT = 11443;
    public static VersaFS myVFS;

    public static void main(String args[]) {

        int port = PORT;

        String archName = "default-arc";

        try {
            if (args.length > 0) {
                archName = args[0];
            }
            if (args.length > 1) {
                port = Integer.parseInt(args[1]);
            }
            if (args.length > 2) {
                System.out.println("Usage: java ZeeProxy [file] [port]");
                return;
            }
        } catch (NumberFormatException e) {
        }

        try {

            //System.out.println("Oh well, let's sleep...");
            // this will release the inflater and put it in its cache
            //Thread.sleep(10000);
            System.out.println("Opening archive " + archName);

            VersaStream vs;

            // If the file is compressed in RAZip or GZip format,
            // vs will access the uncompressed content of it.
            // Otherwise, vs will access the raw content of it.
            vs = VersaStreamFactory.getVersaStream(archName, "r");

            // When mounting the TAR FS, we will sequentially read the file, so let's
            // optimize the VersaStream to sequential access
            vs.setAccessPriority(VersaStream.AP_SEQUENTIAL);

            System.out.println("File open, let's sleep a bit...");
            Thread.sleep(5000);

            System.out.println("Now let's mount the File System...");

            long itime = System.currentTimeMillis();

            myVFS = VersaFSFactory.getVersaFS(vs);
            //myVFS = (TarFS) VersaFSFactory.getVersaFS(archName, "r");

            long ftime = System.currentTimeMillis();

            System.out.println("Time: " + (ftime - itime) / 1000f + "s");
            System.out.println("Entries: " + myVFS.getCount());
            System.out.println("Time per entry: " + (ftime - itime) * 1f / myVFS.getCount() + "ms");
            System.out.println("Entries per second: " + 1000f * myVFS.getCount() / (ftime - itime));

            archLoaded = true;

        } catch (Exception e) {
            e.printStackTrace();
            //System.err.println(e.toString());
        }

        HTTPServer server = new HTTPServer(null);
        server.onCommand = (new HTTPEventListener() {
            public void HTTPCommand(HTTPEvent e) {
                serve(e);
            }
        });

        try {
            server.setPort(port);
            server.setActive(true);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        System.out.println("Server is active on port " + server.getPort());

        int lastTN = -1, TN;

        while (true) {
            try {
                if ((TN = server.getThreads().size()) != lastTN) {
                    lastTN = TN;
                    System.out.println("Threads: " + TN);
                }
                Thread.sleep(500);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
                break;
            }

        }

    }

    public static void serve(HTTPEvent e) {

        int contentLength = 0;

        if (!archLoaded) {
            return;
        }

        final HTTPResponseInfo rspi = e.responseInfo;
        rspi.setIsProxy(true);
        rspi.setConnectionKeepAlive(false);
        rspi.setServerSoftware("ZeeProxy / alpha 2 (Java)");

        final HTTPRequestInfo rqi = e.requestInfo;
        System.out.println("Entry: " + rqi.getHost() + rqi.getDocument());

        VersaFSEntry myVFSE;

        try {
            myVFSE = myVFS.getEntry(rqi.getHost() + rqi.getDocument());
            contentLength = (int) myVFSE.getSize();
        } catch (IOException ioe) {
            rspi.setResponseNo(404);
            rspi.setContentText("<B>" + rspi.getResponseText() + "</B><P>" + ioe);
            return;
        }

        // --------------------------------------
        // Quick hack to determine content type
        String sCType = "text/html";

        if (rqi.getDocument().toLowerCase().endsWith(".html")) {
            sCType = "text/html";
        }

        if (rqi.getDocument().toLowerCase().endsWith(".htm")) {
            sCType = "text/html";
        }

        if (rqi.getDocument().toLowerCase().endsWith(".gif")) {
            sCType = "image/gif";
        }

        if (rqi.getDocument().toLowerCase().endsWith(".jpg")) {
            sCType = "image/jpeg";
        }
        // --------------------------------------

        try {
            VersaStream cvs = myVFS.getVersaStream(myVFSE);
            rspi.setContentType(sCType);
            rspi.setContentLength(contentLength);
            rspi.setContentStream(cvs);
        } catch (IOException ioe) {
            rspi.setResponseNo(500);
            rspi.setContentText("Error sending stream: " + ioe);
        }

    }

}
