/* Streamtresser -- Tests the performance of a VersaStream.Portions of this software are Copyright (c) 2001, Elifarley Callado Coelho -http://www.geocities.com/elifarley/LicenseRedistribution and use in source and binary forms,with or without modification, are permitted provided thatthe following conditions are met:*	Redistributions of source code must retain the abovecopyright notice, this list of conditions and the followingdisclaimer. *	Redistributions in binary form must reproduce the abovecopyright notice, this list of conditions and the followingdisclaimer in the documentation, about box and/or othermaterials provided with the distribution. *	No personal names or organizations names associatedwith the Indy project may be used to endorse or promoteproducts derived from this software without specific priorwritten permission of the specific individual ororganization. THIS SOFTWARE IS PROVIDED BY ITS AUTHOR (ELIFARLEY CALLADO COELHO) "AS IS'' AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.  */package elifarley.io;import java.io.IOException;import java.util.Random;public class Streamtresser {    protected VersaStream vs;    protected int maxIter = 5000;    protected int maxBlockSize = 16 * 1024;    protected Random rnd = new Random(1L);    public Streamtresser() {    }    public Streamtresser(VersaStream vs) {        this();        setStream(vs);    }    public void setStream(VersaStream vs) {        this.vs = vs;    }    public void setMaxIter(int maxIter) {        this.maxIter = maxIter;    }    public void setMaxBlockSize(int maxBlockSize) {        this.maxBlockSize = maxBlockSize;    }    public float stress() {        float result = 0;        result = .5f * (sequentialStress() + randomStress());        return result;    }    public float sequentialStress() {        System.out.println("Sequential stress");        int bs = maxBlockSize;        int pass = 0;        float result = 0;        float tempR;        try {            vs.setPosition(0);        } catch (IOException ioe) {        }        rnd.setSeed(123456L);        while (bs > 0 && pass < 10) {            //rnd.setSeed(123456L);			            tempR = sequentialStress(bs, 0);            result += tempR;            pass++;            System.out.println("size: " + (bs + 1) + "; rate: " + (tempR / 1024f / 1024f));        }        return result / pass;    }    public float sequentialStress(int blockSize, int skipSize) {        long iTime, fTime;        byte block[] = new byte[blockSize];        int i = 0;        int bytes = 0;        int len;        try {            if (skipSize > 0) {                long pos = 0;                iTime = System.currentTimeMillis();                while (i++ < maxIter) {                    vs.setPosition(pos += skipSize);                    //skipSize = 400000 +1024 * (int) ( 512f * 2f * rnd.nextFloat() );                    if ((len = vs.read(block, 0, blockSize)) != -1) {                        bytes += len;                        pos += len;                    } else {                        pos = 0;                        vs.setPosition(0);                    }                }            } else {                iTime = System.currentTimeMillis();                while (i++ < maxIter) {                    if ((len = vs.read(block, 0, blockSize)) != -1) {                        bytes += len;                    } else {                        vs.setPosition(0);                    }                }            }        } catch (IOException ioe) {            ioe.printStackTrace();            return 0;        }        fTime = System.currentTimeMillis();        System.out.println("bytes read: " + bytes);        return bytes * 1000f / (fTime - iTime);    }    public float randomStress() {        System.out.println("Random stress");        int bs = maxBlockSize;        int pass = 0;        float result = 0;        float tempR;        rnd.setSeed(123456L);        while (bs > 0) {            tempR = randomStress(bs--);            result += tempR;            pass++;            System.out.println("size: " + (bs + 1) + "; rate: " + (tempR / 1024f));        }        return result / pass;    }    public float randomStress(int blockSize) {        long iTime, fTime;        byte block[] = new byte[blockSize];        int i = 0;        int bytes = 0;        int len;        try {            long pos = 0;            long size = vs.getSize();            iTime = System.currentTimeMillis();            while (i++ < maxIter) {                pos = (long) (size * rnd.nextFloat());                //System.out.println("pos: " + pos);                if ((len = vs.read(pos, block, 0, blockSize)) != -1) {                    bytes += len;                    //pos += len;                }            }        } catch (IOException ioe) {            ioe.printStackTrace();            return 0;        }        fTime = System.currentTimeMillis();        System.out.println("bytes read: " + bytes);        return bytes * 1000f / (fTime - iTime);    }}