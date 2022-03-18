package tripleo.impohrt.pacman1;

import java.util.Random;

/**
 * class that return random values
 */
class MyRand {
	private static Random rand = new Random();

	public static int getRandValue(int max) {
		return rand.nextInt(max);
	}
}
