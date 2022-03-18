//------------------------------------------------------------------------------
//Andreas Swensson 1998
//------------------------------------------------------------------------------
package tripleo.impohrt.games.bounce;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

public class Paddle
{
	final static int MOVE_PIXELS = 10; 	// The number of pixels the paddle
										// moves when move() is invoked.
	public int X;			// Coordinates
	public int Y;			//   - " -
	public int width;		// Dimensions
	public int height;		//   - " -
	private final Color color;	// Color of paddle.
	private final Component area;	// Where the paddle is to be drawn.
	
	public Paddle(int X, int Y, int width, int height, Color color, Component area)
	{
		// Initialize class members.
		this.area=area;
		this.X=X;
		this.Y=Y;
		this.width=width;
		this.height=height;
		this.color=color;
	}
	
	// Moves the paddle. parameters: "RIGHT" or "LEFT".
	public void move(String direction)
	{
		if (direction.equals("RIGHT"))
		{
			X=X+MOVE_PIXELS;
			// If paddle is outside right edge.
			if ((X+width) > (area.getSize().width))
				X=(area.getSize().width-width);
		}
		else if (direction.equals("LEFT"))
		{
			X=X-MOVE_PIXELS;
			// If paddle is outside left edge.
			if (X < 0)
				X=0;
		}
	}
	
	public void paint(Graphics g)
	{
		g.setColor(color);
		g.fillRect(X, Y, width, height);
	}
	
}

