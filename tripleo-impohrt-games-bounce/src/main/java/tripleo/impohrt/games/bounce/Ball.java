//------------------------------------------------------------------------------
//Andreas Swensson 1998
//------------------------------------------------------------------------------
package tripleo.impohrt.games.bounce;

import java.awt.*;
import java.applet.AudioClip;

public class Ball implements Runnable
{
	private final int radius;			// Radius of ball.
	private final Color color;		// Color of ball.
	private final int delay_time;		// Sleep-time of thread.
	private int X_coof;			// Pixels to move in the X direction every move.
	private int Y_coof;			// Pixels to move in the Y direction every move.
	private int X;				// X-position of ball.
	private int Y;				// Y-position of ball.
	private final Component area;		// The area where the ball bounces.
	public Thread runner;		// The Thread.
	private final AudioClip sndWall;	// Sound when ball hits wall.
	private final AudioClip sndPaddle;// Sound when ball hits paddle.
	private final Graphics gr;		// Something to draw on.
	private final Paddle paddle;		// The paddle to bounce on.
	
	public Ball(int X, int Y, int radius, int X_coof, int Y_coof, int delay_time, Color color, Component area, AudioClip sndWall, AudioClip sndPaddle, Paddle paddle)
	{
		// Initialize private class members.
		this.X=X;
		this.Y=Y;
		this.radius=radius;
		this.X_coof=X_coof;
		this.Y_coof=Y_coof;
		this.delay_time=delay_time;
		this.color=color;
		this.area=area;		
		this.sndWall=sndWall;
		this.sndPaddle=sndPaddle;
		this.paddle=paddle;
		gr=area.getGraphics();
		// Start the thread.
		runner = new Thread(this);
        runner.start();      		
	}
	
	// Thread
	public void run()
	{
		// Repeat forever.
	   while (true)
		{
		// Moves the ball.
			// Remove old ball.
		gr.setColor(area.getBackground());
		gr.fillOval(X, Y, radius*2, radius*2);
		X=X+X_coof;
		Y=Y+Y_coof;
			// Paint at new location.
		gr.setColor(color);
		gr.fillOval(X, Y, radius*2, radius*2);
		// Checks if ball bounces on paddle.
		if ((X>=paddle.X) && (X<(paddle.X+paddle.width)) && ((Y+(radius*2))>=paddle.Y))
			{
				Y_coof=-Y_coof;
				sndPaddle.play();
			}
		// If ball is outside the borders then "bounce".
		if (X+(radius*2)>area.getSize().width)
			{
				X_coof=-X_coof;
				sndWall.play();
			}
		if (X<0)
			{
				X_coof=-X_coof;
				sndWall.play();
			}
		if (Y+(radius*2)>area.getSize().height)
			{
				Y_coof=-Y_coof;
				sndWall.play();
			}
		if (Y<0)
			{
				Y_coof=-Y_coof;					
				sndWall.play();
			}
		// Slow things up a bit.
		try { Thread.sleep(delay_time); }         		
		catch (InterruptedException e) { }
		}
	}
}


