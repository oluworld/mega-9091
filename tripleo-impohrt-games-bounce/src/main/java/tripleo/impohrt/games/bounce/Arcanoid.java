// ------------------------------------------------------------------------------
// Andreas Swensson 1998
// ------------------------------------------------------------------------------
package tripleo.impohrt.games.bounce;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;

public class Arcanoid extends JApplet //Component
{

    public Ball ball;		// The bouncing ball.
    public Paddle paddle;	// The paddle.
    public AudioClip sndWall;	// Sound when ball hits wall.
    public AudioClip sndPaddle;	// Sound when ball hits paddle.

    public void init() {
        setBackground(Color.black);
        paddle = new Paddle(0, this.getSize().height - 20, 100, 15, Color.red, this);
        sndWall = getAudioClip(getDocumentBase(), "wall.au");
        sndPaddle = getAudioClip(getDocumentBase(), "paddle.au");
        ball = new Ball(20, 40, 10, 4, 3, 20, Color.yellow, this, sndWall, sndPaddle, paddle);
    }

    public boolean keyDown(Event evt, int key) {
        switch (key) {
            case Event.RIGHT:
                paddle.move("RIGHT");
                repaint();
                break;
            case Event.LEFT:
                paddle.move("LEFT");
                repaint();
                break;
        }
        return true;
    }

    public void paint(Graphics g) {
        paddle.paint(g);
    }

    // This takes care of the bouncing ball thread.
    public void start() {
        if (ball.runner.isAlive()) {
            ball.runner.resume();
        }
    }

    public void stop() {
        if (ball.runner.isAlive()) {
            ball.runner.suspend();
        }
    }

    public void destroy() {
        if (ball.runner.isAlive()) {
            ball.runner.stop();
        }
        ball.runner = null;
    }
}
