package tripleo.impohrt.pacman1;

import java.io.*;
import java.util.Collections;
import java.util.Vector;

/**
 * highscore class for the game
 */
public class HighScore {
	private Vector<Score> vector = null;
	private File file = null;

	/**
	 * constructor for highscore objects
	 *
	 * @param path to file to store in
	 */
	public HighScore(String filename) {
		file = new File(filename);
		load();
	}

	/**
	 * load an old highscore
	 */
	public void load() {
		try {
			ObjectInputStream fileIn = new ObjectInputStream(new FileInputStream(file));
			vector = (Vector<Score>) fileIn.readObject();
		} catch (IOException e) {} catch (ClassNotFoundException f) {
			System.err.println(f);
		}
		if (vector == null) {
			vector = new Vector<Score>();
		}
	}

	/**
	 * store the highscore to file
	 */
	private void save() {
		try {
			ObjectOutputStream fileOut = new ObjectOutputStream(new FileOutputStream(file));
			fileOut.writeObject(vector);
		} catch (IOException e) {System.err.println(e);}
	}

	/**
	 * add a new game result to the highscore
	 *
	 * @param Score @see Score
	 */
	public void addScore(Score s) {
		if (s != null) {
			vector.add(s);
			Collections.sort(vector);
			while (vector.size() > Const.MAX_RESULTS && Const.MAX_RESULTS > 0) {
				vector.remove(vector.size() - 1);
			}
			save();

		}
	}

	/**
	 * return a score from a highscore
	 *
	 * @param the pos in the highscore
	 */
	public Score getPos(int p) {
		int pos = p;
		if (pos > vector.size() - 1) {
			return new Score("NoName", 0, 0);
		} else {
			return vector.get(pos);
		}
	}
}

