package tripleo.appz.net.number_server;

import EDU.oswego.cs.dl.util.concurrent.FJTask;
import tripleo.space.SpaceWatcher;
import tripleo.space.Space;
import tripleo.space.SpaceNugget;
import tripleo.util.Assert;

/**
 * Date: Jan 16, 2005
 * Time: 10:18:18 PM
 * <p/>
 * $Id: TasksWatcher.java,v 1.2 2005/09/16 15:23:09 olu Exp $
 */
class TasksWatcher<F1> implements SpaceWatcher<FJTask> {
	final private Space mSpace;
	final private SimpleTestClient client;

	public TasksWatcher(SimpleTestClient aSimpleTestClient, Space aSpace) {
		client = aSimpleTestClient;
		mSpace = aSpace;
		//
		ps().addWatcher(this, "tasks");
	}

	void onSubmit(F1 o) {
		ps().add(new SpaceNugget<FJTask>("tasks", (FJTask) (Object) o));
		//trg.executeTask((FJTask)(Object)o); // TODO: bug in idea4?
	}

	public boolean watch(SpaceNugget<FJTask> aNugget) {
		FJTask o = aNugget.value();
		// TODO: look up java.util.concurrent
		client.trg.executeTask(o);
		return false; // do not remove us from watcher
	}

	private Space ps() {
		return mSpace;//p.space();
	}

	void invariant() {
		Assert.postcondition("parent not null", client != null);
	}
}
