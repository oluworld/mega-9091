package tripleo.impohrt.pacman1;

/**
 * class used to represent a point in a 2D space.
 */
public class XYpos {

    private int x = 0;
    private int y = 0;

    /**
     * constructor to make a new point
     */
    public XYpos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * get the x value
     */
    public int getX() {
        return x;
    }

    /**
     * get the y value
     */
    public int getY() {
        return y;
    }
}
