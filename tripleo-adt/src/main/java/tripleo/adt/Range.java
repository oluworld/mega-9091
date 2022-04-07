package tripleo.adt;

import java.util.List;
import java.util.ArrayList;

public class Range<T> {

    public boolean contains(T t) {
        return backing.contains(t);
    }

    public void add(T t) {
        backing.add(t);
    }

    List<T> backing = new ArrayList<>();
}
