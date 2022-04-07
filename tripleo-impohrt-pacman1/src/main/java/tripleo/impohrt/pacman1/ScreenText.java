package tripleo.impohrt.pacman1;

import java.awt.*;
import java.util.TimerTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ScreenText show a text on the screen at a point and a given time used to draw
 * ingame messages
 */
public class ScreenText extends GameObject {

    private final Font font = new Font("score_font", Font.BOLD, 22);
    private boolean visible = false;
    private String text = null;
    private int xpos = 0;
    private int ypos = 0;
    private final int count = 0;
//	private Timer timer = new Timer();
    static ScheduledThreadPoolExecutor sch = new ScheduledThreadPoolExecutor(7);

    /**
     * constructor to screentext objects
     */
    public ScreenText(World w, String t, int x, int y, int secs) {
        super(w);
        XYpos pos = new XYpos(x, y);
        setStartPos(pos);
        setXpos(-1000);
        setYpos(-1000);
        ypos = y;
        xpos = x;
        text = t;
//		timer.schedule(new done(), secs * 1000);
        sch.schedule(new done(), secs * 1000, TimeUnit.NANOSECONDS);
        visible = true;
    }

    /**
     * constructor to screentext objects
     */
    public ScreenText(World w, String t, int x, int y) {
        super(w);
        XYpos pos = new XYpos(x, y);
        setStartPos(pos);
        setXpos(-1000);
        setYpos(-1000);
        ypos = y;
        xpos = x;
        text = t;
        visible = true;
    }

    public void tick() {

    }

    /**
     * draw the text on the screen
     */
    public void draw(Graphics g, java.awt.image.ImageObserver imgObs) {
        if (visible) {
            g.setFont(font);
            g.setColor(Color.white);
            g.drawString(text, xpos, ypos);
        }
    }

    /**
     * timer class that show the message a given time
     */
    private class done extends TimerTask {

        public void run() {
            visible = false;
//			timer.cancel();
            sch.shutdownNow();
        }
    }
}
