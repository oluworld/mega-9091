package elifarley.io;

import java.io.IOException;
import java.io.OutputStream;

public class VersaStreamOutputStream extends OutputStream {

    private VersaStream vs;
    private long pos;

    VersaStreamOutputStream(VersaStream vs, long pos) {
        this.vs = vs;
        this.pos = pos;
    }

    public void write(int b) throws IOException {
        vs.write(pos++, b);
    }

    public void write(byte b[], int off, int len) throws IOException {
        vs.write(pos, b, off, len);
        pos += len;

    }

    public void flush() throws IOException {
        vs.flush();
    }

    public void close() throws IOException {
        // vs.close(); // ?!?!?!?!!!!???!!!
        System.out.println("outputstream tried to close versaStream !!!!!");
    }

}
