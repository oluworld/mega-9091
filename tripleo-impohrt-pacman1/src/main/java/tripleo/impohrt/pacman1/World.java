package tripleo.impohrt.pacman1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;

/**
 * this is the world class, the entire game "lives" in this class.
 */
class World implements Runnable {

    private final java.util.List<GameObject> objects = new ArrayList<GameObject>();
    private final Level level = new Level();
    private Player player = null;
    private String world_name = "";
    final MyJPanel jPanel;

    /**
     * world constructor
     */
    public World() {
        jPanel = new MyJPanel(true);
        setLevel("Newtestlevel.lev");
        jPanel.setFocusable(true);
        new ScreenText(this, "Version 1.0", 130, 370);
    }

    /**
     * the game thread, this is runned when you start a new game
     */
    public void run() {
        objects.clear();

        // stuff we need
        int round = 1;
        XYpos player_pos = level.getPlayerStartPos();
        XYpos ghost_pos = level.getGhostStartPos();
        player = new Player(this, world_name, player_pos);

        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                new Ghost(this, ghost_pos, player);
            }
        }
        jPanel.addKeyListener(new onMove());  // register the keyListener
        Sound.startSound.play();
        new ScreenText(this, "New round: " + round, Const.STXPOS, Const.STYPOS, 3);

        while (!player.gameOver()) {
            reset();
            player.setCoins(level.getCoins());

            while (!player.gameOver() && !player.finished()) {
                jPanel.repaint();
                try {
                    Thread.sleep(20);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

            Sound.levelSound.play();

            if (!player.gameOver()) {
                round += 1;
                new ScreenText(this, "New round: " + round, Const.STXPOS, Const.STYPOS, 3);
                /*ghost =*/ new Ghost(this, ghost_pos, player); // add 2 new ghosts per completed level
                /*ghost =*/ new Ghost(this, ghost_pos, player); // to make it a bit more difficult
                level.reset(); // prepare the level for the next round
            } else {
                objects.clear();
            }
        }

        Sound.gameOverSound.play();
        jPanel.removeKeyListener(new onMove());

        HighScore highscore = new HighScore("highscore.dat"); // add result to highscore
        Score score = new Score(player.getName(), round, player.getScore());
        highscore.addScore(score);

        objects.clear();

        new ScreenText(this, "Game Over!", Const.STXPOS, Const.STYPOS);
        new ScreenText(this, "Score: " + player.getScore(), Const.STXPOS, Const.STYPOS + 20);
    }

    /**
     * Starts a new game
     */
    public void newGame(String name) {
        this.world_name = name;
        Executer.run(this);
    }

    /**
     * load the specified level
     */
    public void setLevel(String lev) {
        level.load(lev);
        jPanel.repaint();
    }

    /**
     * Add the gameobjects to the object list
     */
    public void add(GameObject gameObject) {
        objects.add(gameObject);
    }

    /**
     * Check's if it's possible to move in the specified direction from the xy
     * pos
     */
    public boolean moveOk(int direction, int x, int y) {
        return level.checkMove(direction, x, y);
    }

    /**
     * check if this xy pos contain a coin
     */
    public boolean containCoin(int x, int y) {
        int pos = level.xyToTitle(x, y);
        if (level.coinAt(pos)) {
            level.grabCoinAt(pos);
            Sound.coinSound.play();
            return true;
        } else {
            return false;
        }
    }

    /**
     * check if position contain cherry
     *
     * @param x - x val
     * @param y - y val
     * @return if it possible
     */
    public boolean containCherry(int x, int y) {
        int pos = level.xyToTitle(x, y);
        if (level.cherryAt(pos)) {
            level.grabCherryAt(pos);
            new ScreenText(this, "200 points!!", Const.STXPOS, Const.STYPOS - 40, 3);
            Sound.cherrySound.play();
            return true;
        } else {
            return false;
        }
    }

    /**
     * check if position contain powerup
     *
     * @param x - x val
     * @param y - y val
     * @return if it possible
     */
    public boolean containPowerup(int x, int y) {
        int pos = level.xyToTitle(x, y);
        if (level.powerupAt(pos)) {
            level.grabPowerupAt(pos);
            if (player.getKillable()) {
                Sound.sirenSound.play(Const.POWERUPTIME);
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Listener class that listen for player input
     */
    public class onMove extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            player.onMove(e);
        }
    }

    /**
     * reset the starting possisions for all GameObjects
     */
    public void reset() {
        for (GameObject o : objects) {   // draw the game objects
            o.reset();
        }
    }

    private class MyJPanel extends JPanel {

        public MyJPanel(boolean isDoubleBuffered) {
            super(isDoubleBuffered);
        }

        /**
         * redraw the scene
         */
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.black); // draw black bg
            g.fillRect(0, 0, this.getWidth(), this.getHeight());

            int pos = 0; // draw the level
            for (int y = 0; y < Const.HEIGHT; y++) {
                for (int x = 0; x < Const.WIDTH; x++) {
                    final int yy = y * Const.TITLE_SIZE;
                    final int xx = x * Const.TITLE_SIZE;
                    g.drawImage(level.getTitleImage(pos), xx, yy, this);

                    Image image = null;
                    // draw what here?
                    if (level.coinAt(pos)) {
                        image = Gfx.coin_img;
                    } else if (level.cherryAt(pos)) {
                        image = Gfx.cherry_img;
                    } else if (level.powerupAt(pos)) {
                        image = Gfx.powerup_img;
                    }
                    assert image != null;
                    g.drawImage(image, xx, yy, this);

                    pos++; // next title
                }
            }

            for (GameObject o : objects) {   // game objects
                o.tick();       // move game object
                o.draw(g, this); // draw game object
            }
        }
    }
}
