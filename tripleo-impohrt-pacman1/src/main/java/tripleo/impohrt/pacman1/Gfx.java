package tripleo.impohrt.pacman1;

import java.awt.Image;
import java.awt.Toolkit;

/**
 * class that hold all the graphics in the game
 */

public class Gfx {
	public static Image ghost_img;
	public static Image coin_img;
	public static Image floor_img;
	public static Image wall_img;
	public static Image cherry_img;
	public static Image powerup_img;
	public static Image siren_img;

	public static Image pacman_up_img;
	public static Image pacman_down_img;
	public static Image pacman_left_img;
	public static Image pacman_right_img;

	/**
	 * load all the images
	 */
	public static void load() {
		System.out.print("Loading graphics...");
		ghost_img = Toolkit.getDefaultToolkit().getImage("../resources/gfx/ghost.gif");
		coin_img = Toolkit.getDefaultToolkit().getImage("../resources/gfx/coin.gif");
		floor_img = Toolkit.getDefaultToolkit().getImage("../resources/gfx/floor.jpg");
		wall_img = Toolkit.getDefaultToolkit().getImage("../resources/gfx/wall.jpg");
		cherry_img = Toolkit.getDefaultToolkit().getImage("../resources/gfx/cherry.gif");
		powerup_img = Toolkit.getDefaultToolkit().getImage("../resources/gfx/powerup.gif");
		siren_img = Toolkit.getDefaultToolkit().getImage("../resources/gfx/siren.gif");

		pacman_up_img = Toolkit.getDefaultToolkit().getImage("../resources/gfx/pacman_up.gif");
		pacman_down_img = Toolkit.getDefaultToolkit().getImage("../resources/gfx/pacman_down.gif");
		pacman_left_img = Toolkit.getDefaultToolkit().getImage("../resources/gfx/pacman_left.gif");
		pacman_right_img = Toolkit.getDefaultToolkit().getImage("../resources/gfx/pacman_right.gif");

		System.out.print("Done!");
	}
}
