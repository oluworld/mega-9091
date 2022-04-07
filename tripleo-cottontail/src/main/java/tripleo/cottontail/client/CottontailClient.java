package tripleo.cottontail.client;

import tripleo.util.Holder;

import java.io.*;
import java.util.*;

public class CottontailClient {

    public static void main(String[] args) {
        new CottontailClient().r();
    }

    private void r() {
        Source s = new Source(source());
        Iterator<ResKey> irk = s.iterate();
        while (irk.hasNext()) {
            final ResKey rk = irk.next();
            final Resource resource = s.open(rk);
            Iterator<VerKey> irv = resource.versions();
            while (irv.hasNext()) {
                IVersion v = resource.open(irv.next());

                System.out.println(resource.getName());
                System.out.println();
                System.out.println(v.getName());
                System.out.println(v.getComment());
                System.out.println(v.getContent());
                System.out.println("--");
            }
        }
    }

    String source() {
        return "pyrt/";
    }

}
