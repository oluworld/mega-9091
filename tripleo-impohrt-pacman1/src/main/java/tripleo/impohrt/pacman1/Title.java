package tripleo.impohrt.pacman1;

import java.awt.Image;

/**
 * Title class represent a 20x20 pixel size square on the screen. the level is
 * built up with 19x21 title objects
 */
public class Title {

    private Image image = null;
    boolean walkable = false;
    boolean coin = false;
    boolean cherry = false;
    boolean powerup = false;

    /**
     * constructor to create a new title object
     *
     * @param Image img - the image this title show
     * @param boolean walkable - can playerobjects walkhere
     * @param boolean coin - does it contain a coin
     * @param boolean cherry - does it contain a cherry
     * @param boolean powerut - does it contain a powerup
     */
    public Title(Image img, boolean walkable, boolean coin, boolean cherry, boolean powerup) {
        this.image = img;
        this.walkable = walkable;
        this.coin = coin;
        this.cherry = cherry;
        this.powerup = powerup;
    }

    /**
     * return the image for this title object
     *
     * @return Image
     */
    public Image getImage() {
        return image;
    }

    /**
     * return if it's possible to walk on the current title
     *
     * @return boolean
     */
    public boolean getWalkable() {
        return walkable;
    }

    /**
     * return if the title contain a coin or not
     *
     * @return true it there is a coin in this title
     */
    public boolean getCoin() {
        return coin;
    }

    /**
     * @return true if the title contain a cherry or not
     */
    public boolean getCherry() {
        return cherry;
    }

    /**
     * @return true if the title contain a powerup or not
     */
    public boolean getPowerup() {
        return powerup;
    }

    /**
     * set the title to contain a coin
     */
    public void setCoin(boolean val) {
        coin = val;
    }

    /**
     * set the title to contain a cherry
     */
    public void setCherry(boolean val) {
        cherry = val;
    }

    /**
     * Set the title to contain a cherry
     */
    public void setPowerup(boolean val) {
        powerup = val;
    }
}
