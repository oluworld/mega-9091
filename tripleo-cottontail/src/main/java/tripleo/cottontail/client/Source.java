package tripleo.cottontail.client;

import java.io.FilenameFilter;
import java.io.File;
import java.util.*;

/**
 * Date: Feb 27, 2005 Time: 5:22:45 PM
 * <p/>
 * $Id: Source.java,v 1.1.1.1 2005/02/28 00:06:42 olu Exp $
 */
public class Source implements FilenameFilter {

    private final String source;
    private final File f;

    public Source(String s) {
        source = s;
        f = new File(source);
    }

    public Resource open(ResKey ark) {
        return new Resource(ark);
    }

    /**
     * return [ResKey(fi) for fi in os.listdir(self._f)
     *
     * @return
     */
    public Iterator<ResKey> iterate() {
        final File[] X = f.listFiles(this);
        List<File> rl;
        if (X != null) {
            rl = Arrays.asList(X);
        } else {
            rl = new ArrayList<File>(0); // empty list
        }
        List<ResKey> rrl = new ArrayList<ResKey>(rl.size());
        for (File fi : rl) {
            rrl.add(new ResKey(fi));
        }
        return rrl.iterator();
    }

    public boolean accept(File dir, String name) {
        return name.endsWith(".py");
    }
}
