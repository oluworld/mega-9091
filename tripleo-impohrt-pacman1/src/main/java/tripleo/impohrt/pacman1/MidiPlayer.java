package tripleo.impohrt.pacman1;

import java.io.File;

import javax.sound.midi.*;

/**
 * class that play midi files
 */
public class MidiPlayer implements Runnable {
	private static Sequencer sm_sequencer = null;
	private static Sequence sequence = null;

	/*
	 * constructor for MidiPlayer objects
	 * @param file - file path
	 */
	public MidiPlayer(String file) {
		File midifile = ResourceLoader.load(file);
		if (midifile.exists()) {
			try {
				sequence = MidiSystem.getSequence(midifile);
				sm_sequencer = MidiSystem.getSequencer();
				sm_sequencer.open();
				sm_sequencer.setSequence(sequence);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	/**
	 * start playing the file
	 */
	public void play() {
		stop();
		Executer.run(this);
	}

	/**
	 * play the file forever
	 */
	public void run() {
		// repeat forever
		while (true) sm_sequencer.start();
	}

	/**
	 * stop playing the file
	 */
	public void stop() {
		sm_sequencer.stop();
	}

}
class Executer {
	public static void run(Runnable aRunnable) {
		Thread thread = new Thread(aRunnable);
		thread.start();
	}
}