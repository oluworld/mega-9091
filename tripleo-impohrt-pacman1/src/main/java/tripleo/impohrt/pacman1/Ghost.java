package tripleo.impohrt.pacman1;

import java.awt.Graphics;

/**
 * Ghost gameobject
 */
public class Ghost extends GameObject {

    private int moveDirection = 0;
    private Player player = null;

    /**
     * constructor to create gameobjects
     *
     * @param world
     * @param XPpos @see XYpos
     * @param Player @see Player used to know where the player is
     */
    public Ghost(World w, XYpos pos, Player player) {
        super(w);
        this.player = player;
        setStartPos(pos);
        moveDirection = getDirection();
    }

    /**
     * This is our AI code. it check if the move is possible. if not then it
     * change the direction until it find a possible direction.
     */
    public void tick() {

        switch (moveDirection) // move if the move is possible!
        {
            case Const.RIGHT:
                if (world.moveOk(moveDirection, getXpos(), getYpos() + 10)) {
                    setXpos(getXpos() + 1);
                } else {
                    moveDirection = getDirection();
                }
                break;
            case Const.DOWN:
                if (world.moveOk(moveDirection, getXpos() + 10, getYpos())) {
                    setYpos(getYpos() + 1);
                } else {
                    moveDirection = getDirection();
                }
                break;
            case Const.LEFT:
                if (world.moveOk(moveDirection, getXpos() + 20, getYpos() + 10)) {
                    setXpos(getXpos() - 1);
                } else {
                    moveDirection = getDirection();
                }
                break;
            case Const.UP:
                if (world.moveOk(moveDirection, getXpos() + 10, getYpos() + 20)) {
                    setYpos(getYpos() - 1);
                } else {
                    moveDirection = getDirection();
                }
                break;
        }

        // check if the player is killed
        if (player != null) {
            if (dist(player.getXpos(), player.getYpos(), getXpos(), getYpos()) < 15) {
                if (!player.killed()) // ghost dies! add some score to the player move
                {                     // ghost back to level-start pos
                    Sound.ghostDieSound.play();
                    player.addScore(10);
                    reset();
                }
            }
        }
    }

    /**
     * the method that draw the ghost on the screen
     */
    public void draw(Graphics g, java.awt.image.ImageObserver imgObs) {
        g.drawImage(Gfx.ghost_img, getXpos(), getYpos(), imgObs);
    }

    private int pow(int x) {
        return x * x;
    }

    /**
     * return the distance between point1 and point2 in a 2D space
     */
    private double dist(int x1, int y1, int x2, int y2) {
        int a = x1 - x2;
        int b = y1 - y2;
        double hotSpot = pow(a) + pow(b);
        double distance = Math.sqrt(hotSpot);
        return Math.sqrt(hotSpot);
    }

    /**
     * returns a new move direction for the ghost
     */
    private int getDirection() {
        int dir = MyRand.getRandValue(4);
        switch (dir) {
            case 0:
                return Const.UP;
            case 1:
                return Const.DOWN;
            case 2:
                return Const.LEFT;
            case 3:
                return Const.RIGHT;
        }
        return Const.UP;
    }

}
