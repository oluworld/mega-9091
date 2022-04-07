package tripleo.cottontail.objects.V;

import tripleo.cottontail.viewer.ResourceViewHelper;

import java.io.File;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Vector;

public class ResourceObject {

    File file;
    WeakReference<ResourceObject> parent;
    private final ResourceViewHelper allocator;

    public ResourceObject(File aFile, WeakReference<ResourceObject> aParent, ResourceViewHelper anAllocator) {
        file = aFile;
        parent = aParent;
        allocator = anAllocator;
    }

    public ResourceObject(File afile, ResourceViewHelper anAllocator) {
        file = afile;
        allocator = anAllocator;
    }

    public List<VersionObject> getVersions() {
        final List<VersionObject> R = new Vector<VersionObject>();
        R.add(new VersionObject("1.0"));
        return R;
    }

    public Object[] getKids() {
        assert file != null;
//		return file.list();
        File[] kids1 = ((File) (Object) file).listFiles();
        Object[] R;
        //
        if (kids1 != null) {
            R = new Object[kids1.length]; // TODO: change Object here and watch idea4 fail
            for (int i1 = 0; i1 < kids1.length; i1++) {
                final File kid1 = (File) kids1[i1];
                final ResourceObject K = new ResourceObject(kid1, new WeakReference<>(this), allocator);

                Object or = allocator.keychain().allocate();
                allocator.keychain().write(or, K);

                R[i1] = or;
            }
        } else {
            R = new Object[0];
        }
        return R;
    }

    public File kid() {
        return file;
    }

    public Object getParent() {
        return file.getParent();
    }

    public String getName() {
        return file.getName();
    }

//	public boolean isDirectory() {
//		return false;
//	}
    public boolean isOdd() {
        return false;  // TODO:
    }

    public String getContentText() {
        return new Long(this.hashCode()).toString();
    }

    public String toString() {
        return "<ResourceObject file=" + file + ">";
    }
}
