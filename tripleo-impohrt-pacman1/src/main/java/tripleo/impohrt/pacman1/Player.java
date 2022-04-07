package tripleo.impohrt.pacman1;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.TimerTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Player gameobject
 * this is that game object that you controle in the game.
 * Like all other gameobjects it inherit @see GameObject
 */
public class Player extends GameObject {
	private String name = "";
	private int score = 0;
	private int lives = 3;
	private int coins = 0;
	private int collected = 0;
	private int moveDirection = 0;
	private boolean killable = true;
	private final Font font = new Font("score_font", Font.BOLD, 22);
//	private Timer timer = new Timer();
	static ScheduledThreadPoolExecutor sch=new ScheduledThreadPoolExecutor(7);

	/**
	 * constructor for player objects
	 *
	 * @param World  w - is the world the gameobject belong to
	 * @param String name - the name of the player
	 * @param XYpos  pos - is the init pos for the player
	 */
	public Player(World w, String name, XYpos pos) {
		super(w);
		this.name = name;
		setStartPos(pos);
	}

	/**
	 * Listen for key's (movements) and store it, this way the player dont have
	 * push the button all the time just once when he want to turn
	 */
	public void onMove(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			moveDirection = Const.LEFT;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			moveDirection = Const.RIGHT;
		if (e.getKeyCode() == KeyEvent.VK_UP)
			moveDirection = Const.UP;
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			moveDirection = Const.DOWN;
	}

	/**
	 * draw the player object on screen and the hearts at the bottom of the screen
	 */
	public void draw(Graphics g, java.awt.image.ImageObserver imgObs) {
		// draw lifes
		for (int i = 0; i < lives; i++)
			g.drawImage(Gfx.pacman_right_img, i * 30, 421, imgObs);

		// draw score
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString("Score: " + score, 200, 445);
		if (!killable) g.drawImage(Gfx.siren_img, 140, 418, imgObs);

		// draw player
		switch (moveDirection) {
			case 0:
				g.drawImage(Gfx.pacman_up_img, getXpos(), getYpos(), imgObs);
				break;
			case Const.UP:
				g.drawImage(Gfx.pacman_up_img, getXpos(), getYpos(), imgObs);
				break;
			case Const.DOWN:
				g.drawImage(Gfx.pacman_down_img, getXpos(), getYpos(), imgObs);
				break;
			case Const.LEFT:
				g.drawImage(Gfx.pacman_left_img, getXpos(), getYpos(), imgObs);
				break;
			case Const.RIGHT:
				g.drawImage(Gfx.pacman_right_img, getXpos(), getYpos(), imgObs);
				break;
		}
	}

	/**
	 * update the player object possision. check if the player can stand there
	 * if there is a coin there.
	 */
	public void tick() {
		switch (moveDirection) // move if the move is possible!
		{
			case Const.RIGHT:
				if (world.moveOk(moveDirection, getXpos(), getYpos() + 10))
					setXpos(getXpos() + 1);
				break;
			case Const.DOWN:
				if (world.moveOk(moveDirection, getXpos() + 10, getYpos()))
					setYpos(getYpos() + 1);
				break;
			case Const.LEFT:
				if (world.moveOk(moveDirection, getXpos() + Const.TITLE_SIZE, getYpos() + 10))
					setXpos(getXpos() - 1);
				break;
			case Const.UP:
				if (world.moveOk(moveDirection, getXpos() + 10, getYpos() + Const.TITLE_SIZE))
					setYpos(getYpos() - 1);
				break;
		}

		// check if player grab coin
		if (world.containCoin(getXpos() + 10, getYpos() + 10)) {
			addScore(1);
			collected += 1;
		}

		// check if player grab cherry
		if (world.containCherry(getXpos() + 10, getYpos() + 10)) {
			addScore(200);
		}

		// check if player grab powerup
		if (world.containPowerup(getXpos() + 10, getYpos() + 10)) {
			killable = false;
			sch.schedule(new Powerup(), Const.POWERUPTIME, TimeUnit.NANOSECONDS);
		}
	}

	/**
	 * return true if the game is over, player has no lives left
	 */
	public boolean gameOver() {
		if (lives > 0)
			return false;
		else
			return true;
	}

	/**
	 * get the player name
	 */
	public String getName() {
		return name;
	}

	/**
	 * get the player score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * add score to the player score
	 */
	public void addScore(int x) {
		score += x;
	}

	/**
	 * reset the player if he got killed
	 */
	public boolean killed() {
		if (killable) {
			Sound.dieSound.play();
			lives -= 1;
			world.reset();
		}

		return killable;
	}

	/**
	 * set the nummber of coins the player have to collect before he is done
	 * on the specified level
	 */
	public void setCoins(int x) {
		coins = x;
	}

	/**
	 * return true if the player has collected all the coins on
	 * the level.
	 */
	public boolean finished() {
		if (collected >= coins) {
			collected = 0;
			return true;
		} else
			return false;
	}

	/**
	 * return true if the player is possible to kill or not
	 * used for siren sound
	 */
	public boolean getKillable() {
		return killable;
	}

	private class Powerup extends TimerTask {
		public void run() {
			killable = true;
		}
	}
}
