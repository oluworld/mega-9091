package tripleo.impohrt.andreasnibbles;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Nibbles extends JPanel /*Applet*/ implements Runnable {

	public static void main(String[] args) {
		Nibbles n = new Nibbles();
		JFrame j = new JFrame();
		j.getContentPane().add(n);
		n.setSize(n.rows*20,n.cols*20);
		n.init();
		j.setVisible(true);
		n.start();
	}

	int cols = 30;
	int rows = 30;
	Grid grid;
	Thread runner;
	int pausTime = 100; 	// Tiden mellan varje flytt (i milisek).
	int dir = Worm.RIGHT;  	// Riktningen för masken (1,2,3,4)=(D,U,R,L).
	int dir_CPU = Worm.LEFT;
	Worm worm;
	Worm worm_CPU;
	Color color = Color.black;
	Color color_CPU = Color.red;
	int length = 15;
	JLabel scoreplayer;
	JLabel scoreCPU;

	public void init() {
		String xcols = xgetParameter("COLUMNS");
		String xrows = xgetParameter("ROWS");
		String speed = xgetParameter("SPEED");
		String xlength = xgetParameter("LENGTH");
		if (xcols != null) {
			try {
				this.cols = Integer.parseInt(xcols);
			} catch (NumberFormatException e) {}
		}
		if (xrows != null) {
			try {
				this.rows = Integer.parseInt(xrows);
			} catch (NumberFormatException e) {}
		}
		if (speed != null) {
			try {
				pausTime = Integer.parseInt(speed);
			} catch (NumberFormatException e) {}
		}
		if (xlength != null) {
			try {
				this.length = Integer.parseInt(xlength);
			} catch (NumberFormatException e) {}
		}
		grid = new Grid(this.cols, this.rows, size().width, size().height - 14);
		this.setLayout(new BorderLayout());
		scoreplayer = new JLabel("0", Label.RIGHT);
		scoreplayer.setForeground(color);
		scoreCPU = new JLabel("0", Label.RIGHT);
		scoreCPU.setForeground(color_CPU);
		Panel p = new Panel();
		p.add(scoreplayer);
		p.add(scoreCPU);
		add("North", p);
		add("South", grid);
		worm = new Worm(grid, this.length, 0, 0, color);
		worm_CPU = new Worm(grid, this.length, grid.getCols() - 1, grid.getRows() - 1, color_CPU);
	}

	private String xgetParameter(String s) {
		return  h.get(s);
	}

	Map<String, String> h = new HashMap();
	{
		h.put("COLUMNS", "30");
		h.put("SPEED", "80");
		h.put("ROWS", "30");
		h.put("LENGTH", "20");
	}

	public void start() {
		if (runner == null) {
			runner = new Thread(this);
			runner.start();
		} else if (runner.isAlive()) {
			runner.resume();
		}
	}

	public void stop() {
		if (runner.isAlive())
			runner.suspend();
	}

	public void destroy() {
		if (runner.isAlive())
			runner.stop();
		runner = null;
	}

	public synchronized boolean keyDown(Event evt, int key) {
		switch (key) {
			case Event.DOWN:
				if (dir != tripleo.impohrt.andreasnibbles.Worm.UP)
					dir = tripleo.impohrt.andreasnibbles.Worm.DOWN;
				break;
			case Event.UP:
				if (dir != tripleo.impohrt.andreasnibbles.Worm.DOWN)
					dir = tripleo.impohrt.andreasnibbles.Worm.UP;
				break;
			case Event.RIGHT:
				if (dir != tripleo.impohrt.andreasnibbles.Worm.LEFT)
					dir = tripleo.impohrt.andreasnibbles.Worm.RIGHT;
				break;
			case Event.LEFT:
				if (dir != tripleo.impohrt.andreasnibbles.Worm.RIGHT)
					dir = tripleo.impohrt.andreasnibbles.Worm.LEFT;
				break;
		}

		return true;
	}

	public void run() {
		while (true) {	// Forävvär, mään.
			if (!worm.move(dir)) {
				a1(worm_CPU, scoreCPU, 1000);
			}

			int koll = 0;
			if (Math.random() > 0.9)
				dir_CPU = (int) ((Math.random() * 4 + 1));
			while (!worm_CPU.move(dir_CPU)) {
				dir_CPU = (int) ((Math.random() * 4) + 1);
				koll++;
				if (koll > 10) {  // Om den inte hittat en utväg efter 10 gissningar
					a1(worm, scoreplayer, 2000);
//					grid.clear(); // så antar jag att det inte finns någon.
//					worm.score++;
//					scoreplayer.setText(Integer.toString(worm.score));
//					try { Thread.sleep(2000); } catch (InterruptedException e) { }
				}
			}

			try { Thread.sleep(pausTime); } catch (InterruptedException e) { }
		}
	}

	private void a1(final Worm aWorm, final JLabel aScoreLabel, final int delay) {
		grid.clear();
		aWorm.score++;		// Öka datorns poäng med 1.
		aScoreLabel.setText(Integer.toString(aWorm.score));
		try { Thread.sleep(delay); }	// Låt kombatanterna ta igen sig 1 sek.
		catch (InterruptedException e) { }
	}
}
