// ------------------------------------------------------------------------------
// (c) Andreas Swensson, 1998.
// e-mail: as@home.se
// ------------------------------------------------------------------------------
package tripleo.impohrt.andreasnibbles;

import java.awt.*;

class Grid extends Canvas {

    final private int rows;
    final private int cols;
    final private int width;
    final private int height;
    private Graphics gr;
    final private int r_width;
    final private int r_height;
    final private Color[][] color;

    public Grid(int cols, int rows, int width, int height) {
        this(cols, rows, width, height, Color.white);
    }

    public Grid(int cols, int rows, int width, int height, Color backcolor) {
        this.cols = cols;
        this.rows = rows;
        if (width < cols) // S� att inte antalet kolumner och rader
        {
            width = cols;		// �r st�rre �n bredden och h�jden i pixels.
        }
        if (height < rows) //
        {
            height = rows;		//
        }
        r_width = (int) (width / cols);     	// Kollar s� att width och height �r multiplar
        width = r_width * cols;		// av r_width och r_height.
        r_height = (int) (height / rows);	//
        height = r_height * rows;		//
        this.width = width;
        this.height = height;
        resize(width, height);
        setBackground(backcolor);
        color = new Color[cols][rows];
        for (int i = 0; i < cols; i++) // Nollst�ller griden.
        {
            for (int j = 0; j < rows; j++) //
            {
                color[i][j] = null;	//
            }
        }
        show();
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public void clear() {
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                color[i][j] = null;
            }
        }
        Color c = getBackground();
        gr = getGraphics();
        gr.setColor(c);
        gr.fillRect(0, 0, width, height);
    }

    public void setColor(int col, int row, Color c) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return;
        }
        color[col][row] = c;
        if (c != null) {
            gr = getGraphics();
            if (gr != null) {
                gr.setColor(c);
                gr.fillRect(col * r_width, row * r_height, r_width, r_height);
            }
        }
    }

    public Color getColor(int col, int row) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return null;
        }
        return color[col][row];
    }

    public void paint(Graphics g) {
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                if (color[col][row] != null) {
                    g.setColor(color[col][row]);
                    g.fillRect(col * r_width, row * r_height, r_width, r_height);
                }
            }
        }
    }

}// ------------------------------------------------------------------------------

// (c) Andreas Swensson, 1998.
// e-mail: as@home.se
// ------------------------------------------------------------------------------
class Worm {

    final static int DOWN = 1;
    final static int UP = 2;
    final static int RIGHT = 3;
    final static int LEFT = 4;
    private final int[] x;
    private final int[] y;
    private final int cols;
    private final int rows;
    private final int length;
    public Color color;
    public Grid grid;
    public int score = 0;

    public Worm(Grid xgrid, int xlength, int startx, int starty, Color xcolor) {
        this.grid = xgrid;
        this.length = xlength;
        this.color = xcolor;
        cols = xgrid.getCols();
        rows = xgrid.getRows();
        x = new int[xlength];
        y = new int[xlength];
        if ((startx >= xgrid.getCols()) || (startx < 0)) // Kollar s� att startpositionerna
        {
            startx = 0;				// inte ligger utanf�r griden.
        }
        if ((starty >= xgrid.getRows()) || (starty < 0)) //
        {
            starty = 0;				//
        }
        for (int i = 0; i < xlength; i++) {
            x[i] = startx;
            y[i] = starty;
        }
        xgrid.setColor(startx, starty, xcolor);
    }

    public boolean move(int direction) // 1=Ner 2=Upp 3=H�ger 4=V�nster
    {						// Returnerar False vid krock.
        int col, row;
        switch (direction) {
            case DOWN:
                if (y[0] == rows - 1) {
                    row = 0;
                } else {
                    row = y[0] + 1;
                }
                col = x[0];
                break;
            case UP:
                if (y[0] == 0) {
                    row = rows - 1;
                } else {
                    row = y[0] - 1;
                }
                col = x[0];
                break;
            case RIGHT:
                if (x[0] == cols - 1) {
                    col = 0;
                } else {
                    col = x[0] + 1;
                }
                row = y[0];
                break;
            case LEFT:
                if (x[0] == 0) {
                    col = cols - 1;
                } else {
                    col = x[0] - 1;
                }
                row = y[0];
                break;
            default:
                return false;  // Om en annan direction har angivits.
        }
        boolean ret = false;
        if (grid.getColor(col, row) == null) {
            ret = true;
            grid.setColor(col, row, color);
            grid.setColor(x[length - 1], y[length - 1], grid.getBackground()); // Ta bort sista.
            grid.setColor(x[length - 1], y[length - 1], null);
            for (int i = length - 1; i > 0; i--) {
                x[i] = x[i - 1];
                y[i] = y[i - 1];
            }
            x[0] = col;
            y[0] = row;
        }
        return ret;
    }

}
