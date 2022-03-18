package tripleo.cottontail.client;

import tripleo.util.Holder;

public class CmntKey extends Holder<String> {
	public CmntKey(String s) {super(s);}
	public String name() {return get();}
}
