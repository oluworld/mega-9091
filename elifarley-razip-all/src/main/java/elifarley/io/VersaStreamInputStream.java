package elifarley.io;

import java.io.IOException;
import java.io.InputStream;

public class VersaStreamInputStream extends InputStream {

    protected VersaStream vs;
    protected long vs_offset, pos, fMark, maxLen, maxLenAndOffset;
    protected int readLimit = Integer.MAX_VALUE;
    protected boolean useMaxLen = false;

    VersaStreamInputStream(VersaStream vs, long pos, long maxLen) {
        this.vs = vs;
        setMaxLen(maxLen);
        setVSOffset(pos);
    }

    VersaStreamInputStream(VersaStream vs, long pos) {
        this(vs, pos, 0);
    }

    public VersaStream getParentVersaStream() {
        return vs;
    }

    public long getMaxLen() {
        return maxLen;
    }

    public void setMaxLen(long maxLen) {
        this.maxLen = maxLen;
        this.maxLenAndOffset = maxLen + vs_offset;
        useMaxLen = (maxLen > 0);
    }

    public long getVSOffset() {
        return vs_offset;
    }

    /*
     *returns true if offset has been changed
     */
    public boolean setVSOffset(long vs_offset) {

        boolean result = false;

        if (this.vs_offset != vs_offset) {

            this.vs_offset = vs_offset;
            this.pos = vs_offset;
            this.maxLenAndOffset = maxLen + vs_offset;
            this.fMark = vs_offset;
            result = true;

        }

        return result;
    }

    public int read() throws IOException {

        if (useMaxLen && pos >= maxLenAndOffset) return -1;

        int n = vs.read(pos);
        if (n != -1) {
            pos++;
        }
        return n;
    }

    public int read(byte b[], int off, int len) throws IOException {

        if (useMaxLen) {
            long diff = maxLenAndOffset - pos;
            if (diff <= 0) return -1;
            if (len > diff) len = (int) diff;
        }

        len = vs.read(pos, b, off, len);
        if (len != -1) {
            pos += len;
        }
        return len;

    }

    public long skip(long n) {
        pos += n;
        return n;
    }

    public boolean markSupported() {
        return vs.markSupported();
    }

    public synchronized void mark(int readLimit) {
        fMark = pos;
        this.readLimit = readLimit;
    }

    public synchronized void reset() throws IOException {
        //if (pos - fMark > readLimit) throw new IOException("readLimit exceeded");
        pos = fMark;
    }

}
