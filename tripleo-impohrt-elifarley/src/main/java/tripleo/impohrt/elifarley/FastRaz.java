package tripleo.impohrt.elifarley;

/* FastRaz 1.0.0 alpha 1 -- Example application.
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
import java.util.zip.Inflater;

import elifarley.io.*;
import elifarley.io.fs.VersaFS;
import elifarley.razip.RAZipConstants;
import elifarley.razip.RAZipVersaStream;

public class FastRaz implements RAZipConstants {

    public static VersaFS myVFS;

    protected static boolean archLoaded = false;

    static String archName = "default-arc";
    static String archDest;

    public static void main(String args[]) {

        try {

            if (args.length > 0) {
                archName = args[0];
            }

            if (args.length > 1) {

                archDest = args[1];
            } else {
                archDest = archName + "-transformed";
            }

            if (args.length > 2) {
                System.out.println("Usage: java ZeeProxy [file] [port]");
                return;
            }
        } catch (NumberFormatException e) {
        }

        //System.out.println(VersaFS.globalVFS.getVersion());
        try {

            //testInf(archName);
            //stress(archName);
            transcode(archName);

        } catch (Exception e) {
            e.printStackTrace();
            //System.err.println(e.toString());
        }

    }

    public static void transcode(String s) throws IOException {

        VersaStream vs = VersaStreamFactory.getVersaStream(s, "r");
        vs.setAccessPriority(VersaStream.AP_SEQUENTIAL);
        VersaStream outVS = VersaStreamFactory.getVersaStream(archDest, "rw", vs.getCompressionFormat() == VersaStreamConstants.CF_RAZIP);

        if (outVS.getCompressionFormat() == VersaStreamConstants.CF_RAZIP) {
            RAZipVersaStream rvs = (RAZipVersaStream) outVS;

            rvs.setMaxBlockSize(256 * 1024);

            rvs.RAZ_H.setFlagNC0((byte) ( //F_HAS_MORE_FLAG_NC |
                    //FNC0_NON_STANDARD_COMPRESSION |
                    //FNC0_ENCRYPTED |
                    FNC0_ECC
                    | FNC0_HEADER_NOT_ENCODED
                    | FNC0_NON_STANDARD_INTEGRITY_CHECK
                    | FNC0_HEADER_CRC
                    | FNC0_BLOCK_INTEGRITY_CHECK));

            rvs.RAZ_H.setFlag0((byte) (F_HAS_MORE_FLAG_BYTES
                    | F0_EXTENDED_MTIME_INFO
                    | F0_EXTENDED_CTIME_INFO
                    | F0_TYPE_CREATOR
                    | F0_NAME
                    | F0_COMMENT
                    | F0_PROPERTIES //F0_RESFORK
                    ));

            rvs.RAZ_H.setFlag1((byte) (F1_EXTRA_FIELD_8
                    | //F1_EXTRA_FIELD_16 |
                    //F1_EXTRA_FIELD_32 |
                    F1_NON_STANDARD_TEXT_ENCODING));

        }

        outVS.copyFrom(vs);
        outVS.close();
        System.out.println("Ready");

        try {
            Thread.sleep(60000);
        } catch (InterruptedException ie) {
        }

    }

    public static void stress(String s) throws IOException {

        VersaStream vs = VersaStreamFactory.getVersaStream(s, "r");
        vs.setAccessPriority(VersaStream.AP_SEQUENTIAL);

        Streamtresser st = new Streamtresser(vs);
        st.setMaxIter(100);
        st.setMaxBlockSize(1);
        System.out.println("result: " + st.randomStress() / 1024f);

    }

    public static void testInf(String s) throws IOException {
        /*
		(BlockInfo)cpVector.elementAt(0)).cPos 4
		(BlockInfo)cpVector.elementAt(0)).uPos 0
		(BlockInfo)cpVector.elementAt(0)).cLen 134588
		(BlockInfo)cpVector.elementAt(0)).uLen 716800
         */
        // 700k-arc-infOnly
        // 700k-arc-4bheader+garbage

        long cPos = 4;

        VersaStream vs = VersaStreamFactory.getVersaStream("700k-arc-4bheader+garbage", "r", true);
        VersaStreamInputStream vsis = vs.getInputStream(cPos, 134588);
        InflaterVersaStream ivs = new InflaterVersaStream(vsis, new Inflater(true),
                134000);

        //ivs.informSize(716800);
        System.out.println("maxLen: " + ((VersaStreamInputStream) ivs.getParentInputStream()).getMaxLen());

        int p = 716799;
        int off = 1012;
        // (100000 , 1012) is the lowest

        vsis.skip(134000);
        byte b[] = new byte[200000];
        System.out.println("read " + vsis.read(b, 0, 600));
        //ivs.setPosition(247807);
        ivs.setPosition(p);
        System.out.println("read " + ivs.read());

        try {
            Thread.sleep(600000);
        } catch (InterruptedException ie) {
        }

    }

}
