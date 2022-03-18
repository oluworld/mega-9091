package tripleo.impohrt.pacman1;

import java.awt.Graphics;
import java.awt.Image;

/**
 * GameObject class is a abstract class that contin stuff
 * that all our gameobjects need.
 */
abstract class GameObject {
	protected World world = null;
	protected int x_pos = 2000;
	protected int y_pos = 2000;
	protected Image image = null;
	protected XYpos startPos = new XYpos(2000, 2000); // debug

	public GameObject(World aWorld) {
		this.world = aWorld;
		aWorld.add(this);
	}

	/**
	 * tick method that all gameobjects over-ride
	 * take care of the movement of gameobjects
	 */
	public void tick() {
	}

	/**
	 * draw method that every gameobject over-ride.
	 * take care of the
	 */
	public void draw(Graphics g, java.awt.image.ImageObserver imgObs) {
	}

	/**
	 * return the on screen X pos for the gameobject
	 *
	 * @return X pos
	 */
	public int getXpos() {
		return x_pos;
	}

	/**
	 * return the on screen Y pos for the gameobject
	 *
	 * @return Y pos
	 */
	public int getYpos() {
		return y_pos;
	}

	/**
	 * set the on screen Y pos for the gameobject
	 *
	 * @param pos y value
	 */
	public void setYpos(int pos) {
		y_pos = pos;
	}

	/**
	 * set the on screen X pos for the gameobject
	 *
	 * @param pos x value
	 */
	public void setXpos(int pos) {
		x_pos = pos;
	}

	/**
	 * return the XYpos object
	 *
	 * @return @see XYpos
	 */
	public XYpos getStartPos() {
		return startPos;
	}

	/**
	 * set the start pos for a gameobject
	 *
	 * @param pos @see XYpos
	 */
	public void setStartPos(XYpos pos) {
		startPos = pos;
	}

	/**
	 * move the gameObject back to it's starting possition
	 */
	public void reset() {
		setXpos(startPos.getX());
		setYpos(startPos.getY());
	}
}
