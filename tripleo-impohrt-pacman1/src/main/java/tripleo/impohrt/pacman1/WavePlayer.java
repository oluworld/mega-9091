package tripleo.impohrt.pacman1;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.util.TimerTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Very simple class that play a wav file
 */
public class WavePlayer implements AudioClip {
	private AudioClip clip1 = null;
	private boolean looping = false;
//	private Timer timer = new Timer();
	static ScheduledThreadPoolExecutor sch=new ScheduledThreadPoolExecutor(7);
	private boolean debug = false;
	private final String file;

	/**
	 * constructor take a path to the wav file to play
	 *
	 * @param filename to file
	 */
	public WavePlayer(String filename) {
		file = filename;
		load();
	}

	/**
	 * constructor take a path to the wav file to play
	 *
	 * @param filename to file
	 * @param args     if you want to show debug information
	 */
	public WavePlayer(String filename, boolean args) {
		debug = args;
		file = filename;
		load();
	}

	/**
	 * Loads the sound files
	 */
	private void load() {
		if (debug)
			System.out.print("\nLoading sound file: " + file + ".... ");
		File wavefile = ResourceLoader.load(file);
		try {clip1 = Applet.newAudioClip(wavefile.toURL());} catch (Exception e) {
			System.out.print("Error in file! ");
			System.err.print(e);
		}
		if (debug)
			System.out.print("Done!");
	}


	/**
	 * starts playing the wav file
	 */
	public void play() {
		new WaveThread();
	}

	/**
	 * Starts playing a loop, takes looptime (secs) as argument
	 */
	public void play(int time) {
		looping = true;
		new WaveThread();
		sch.schedule(new LoopTime(), time, TimeUnit.MILLISECONDS);
//		timer.schedule(new LoopTime(), time);
	}

	/**
	 * Stops playing the sound file
	 */
	public void stop() {
		if (looping)
			looping = false;
		clip1.stop();
	}

	/**
	 * Loops the selected sound file
	 */
	public void loop() {
		looping = true;
		new WaveThread();
	}

	private class WaveThread implements Runnable {
		public WaveThread() {
			Executer.run(this);
		}

		public void run() {
			if (looping)
				clip1.loop();
			clip1.play();
		}
	}

	private class LoopTime extends TimerTask {
		public void run() {
			if (looping)
				looping = false;
			clip1.stop();
		}
	}
}
