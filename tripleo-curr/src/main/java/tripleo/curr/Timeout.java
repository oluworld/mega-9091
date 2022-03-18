package tripleo.curr;

import java.util.ArrayList;
import java.util.List;

class Messages {
	static private long alloced=0;
	static long alloc() {return ++alloced;}
}

public class Timeout implements Runnable, Process {
	static Timeout instance = new Timeout();
	private It first = null;
	ProcessQ queue = ProcessQ.defaultInstance();
	private static final long WAKE = Messages.alloc();

	public void run() {
		while (true) {
			if (first == null) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				try {
					Thread.sleep(first.pros - curTime());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				while (curTime() >= first.pros) {
					queue.send(this, first.cont, WAKE, first.value);
					if (its.size() > 1) {
						first = its.get(0);
						its.remove(0);
					} else first = null;
				}
			}
		}
	}

	private long curTime() {
		return System.currentTimeMillis();
	}

	public void rcv(Process sender, long aMessage, Object aValue) {
		switch((int) aMessage ){

		}
	}

	Object lk=new Object();
	public Object sendLock() {
		return lk;
	}

	class It {
		long inc, pros;
		Process cont;
		Object value;
	}

	List<It> its = new ArrayList();

	public void add(long ainc, Process aproc, Object avalue) {
		It it = new It();
		it.inc = ainc;
		it.pros = ainc + curTime();
		it.cont = aproc;
		it.value = avalue;
		its.add(it);
	}

	public void start() {
		new Thread(this, "Timeout").start();
	}
}

class  ProcessQ {
	private static ProcessQ instance;

	void send(Process from, Process to, long aMessage, Object aValue) {
		synchronized (to.sendLock()) {
			to.rcv(from, aMessage, aValue);
		}
	}

	public static ProcessQ defaultInstance() {
		if (instance == null) {
			instance = new ProcessQ();
		}
		return instance;
	}
}

interface Process {
	void rcv(final Process sender, long aMessage, Object aValue);

	Object sendLock();
}

class TOT {
	static class Proc1 implements Process {
		public void rcv(Process sender, long aMessage, Object aValue) {
			int y=2;
			System.out.println("** 1 5 senconds");
		}

		Object lk=new Object();
		public Object sendLock() { return lk; }
	}
	static class Proc2 implements Process {
		Object lk=new Object();

		public void rcv(Process sender, long aMessage, Object aValue) {
			int y=2;
			System.out.println("** 2 2.5 senconds");
		}

		public Object sendLock() { return lk; }

	}
	public static void main(String[] args) {
		Process p1=new Proc1();
		Process p2=new Proc2();
		Timeout.instance.add(5000,p1,null);
		Timeout.instance.add(2500,p2,null);
	}
}
