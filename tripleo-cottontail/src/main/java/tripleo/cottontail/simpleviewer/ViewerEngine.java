///*
// * Created on Feb 27, 2005 12:40:47 PM
// *
// * $Id: ViewerEngine.java,v 1.1.1.1 2005/03/06 17:48:28 olu Exp $
// */
//package tripleo.cottontail.simpleviewer;
//
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.util.Iterator;
//
//import silk.InputPort;
//import silk.Scheme;
//import interact.Interactor;
//import tripleo.cottontail.client.*;
//
//public class ViewerEngine {
//	private Source so;
//	private ResKey rk;
//	private VerKey vk;
//	private CmntKey ck;
//	private Resource rz;
//	private IVersion vr;
//
//	private static silk.Scheme mkscheme(final ViewerEngine anEngine) {
//		System.setProperty("scheme.eval",
//				"(set! scheme.roots '(lib/Java-Jar-Files/jar/scheme.jar))");
//		Scheme R = new Scheme();
//		try {
//			R.setGlobal("ctn", anEngine);
//			R.load(new InputPort(new FileReader("pyrt/defs.sch")));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}
//		return R;
//	}
//
//	public String result(String aRequest) {
//		Scheme S = ourscheme();
//		Object R = S.evalString(aRequest);
//		return (R == null) ? null : R.toString();
//	}
//
//	static Scheme ourscheme;
//
//	Scheme ourscheme() {
//		if (ourscheme==null)
//			ourscheme=mkscheme(this);
//		return ourscheme;
//	}
//
//	public void zero_cb(String s) {
//		new Interactor(false, "Silk Interactor", null, 24, 80, s.split(" "));
//	}
//	public void connect_cb(String s) {
//		so=new Source(s);
//	}
//	public void set_part_cb(String s, String s2) {
//		if (s.equals("RESOURCE")) {
//			rk = find_resource_key(s2);
//			if (rk != null) System.out.println("** FOUND "+s+" "+s2);
//		} else if (s.equals("VERSION"))  {
//			vk = find_version_key(s2);
//			if (vk != null) System.out.println("** FOUND "+s+" "+s2);
//		} else if (s.equals("COMMENTS")) {
//			ck = find_comment_key(s2);
//			if (ck != null) System.out.println("** FOUND "+s+" "+s2);
//		}
//	}
//
//	public void show_part_cb(String s) {
//		if (s.equals("RESOURCE")) {
//			Iterator<ResKey> w = so.iterate();
//			int N=0;for(;w.hasNext();++N) {
//				ResKey t = w.next();
//				System.out.println("RESOURCE: "+t.name());
//			}
//			System.out.println("++ listed "+N);
//		} else if (s.equals("VERSION"))  {
//			Resource w = so.open(rk);
//			Iterator<VerKey> vi = w.versions();
//			int N=0; while (vi.hasNext()) {
//				final VerKey vk2 = vi.next();
//				System.out.println("VERSION: "+vk2.name());++N;
//			} System.out.println("++ listed "+N);
//		} else if (s.equals("COMMENTS")) {
////			Resource w = so.open(rk);
////			Iterator<VerKey> vi = w.versions();
////			while (vi.hasNext()) {
////				final VerKey vk2 = vi.next();
//////				IVersion v = w.open(vk2);
////				System.out.println("VERSION: "+vk2.name());
////			}
//////			if (rk != null) System.out.println("** FOUND "+s+" "+s2);
//			assert false;
//		}
//	}
//	public void edit_part_cb(String s, String s2) {
//		int y=2;
//	}
//	public void remove_cb(String s) {
//		int y=2;
//	}
//
//	private ResKey find_resource_key(String key_name) {
//		assert so!=null;
//		Iterator<ResKey> irk = so.iterate();
//		ResKey R=null,rr;
//		while (irk.hasNext() && R==null) {
//			rr = irk.next();
//			if (R.name().equals(key_name)) {
//				R=rr;
//			}
//		}
//		return R;
//	}
//	private VerKey find_version_key(String key_name) {
//		assert so!=null;
//		assert rk!=null;
//		//
//		rz = so.open(rk);
//		Iterator<VerKey> irv = rz.versions();
//		VerKey R=null,rr;
//		while (irv.hasNext() && R==null) {
//			rr = irv.next();
//			if (R.name().equals(key_name)) {
//				R=rr;
//			}
//		}
//		return R;
//	}
//	private CmntKey find_comment_key(String key_name) {
//		assert so!=null;
//		assert rz!=null;
//		//
//		vr = rz.open(vk);
//		Iterator<CmntKey> irv = vr.comments();
//		CmntKey R=null,rr;
//		while (irv.hasNext() && R==null) {
//			rr = irv.next();
//			if (R.name().equals(key_name)) {
//				R=rr;
//			}
//		}
//		return R;
//	}
//
//}
