package tripleo.util;

public class Holder<Q> {

    final private Q held;

    public Holder(Q i) {
        held = i;
    }

    public Q get() {
        return held;
    }
}
