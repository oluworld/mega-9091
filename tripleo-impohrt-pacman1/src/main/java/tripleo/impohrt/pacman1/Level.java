package tripleo.impohrt.pacman1;

import java.awt.Image;
import java.io.*;
import java.util.Vector;

/**
 * Level class take care of the level load levels and take care of hit-detection
 */
public class Level {
	private final Vector<Title> titles = new Vector<Title>();
	private File file = null;
	private int playerStartTitle = 0;
	private int ghostStartTitle = 0;
	private int coinCount = 0;
	private String lastLevel = "";

	/**
	 * loads a level file
	 */
	public void load(String level) {
		titles.clear(); // some clean up first
		lastLevel = level;
		playerStartTitle = 0;
		ghostStartTitle = 0;
		coinCount = 0;

		String path = "resources/levels/" + level;
		File xfile = ResourceLoader.load(path);
		System.out.print("Loading level (" + xfile.getAbsolutePath() + ")...");
		if (xfile.exists()) { // load file if it exists
			loadLevel(xfile);
		}
	}

	private void loadLevel(File xfile) {
		try {
			file = xfile;
			BufferedReader reader = null;
			reader = new BufferedReader(new FileReader(file));

			String lineText;
			lineText = reader.readLine();
			while (lineText != null) {
				// for each line of text

				for (int i = 0; i < lineText.length(); i++)
					klkl(lineText.charAt(i));
			}
			System.out.print("Done!\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void klkl(char c) {
		switch (c) {
		case ('#'): { // wall
			Title title = new Title(Gfx.wall_img, false, false, false, false);
			addTitle(title);
			break;
		}
		case '*': { // floor with coin
			Title title = new Title(Gfx.coin_img, true, true, false, false);
			addTitle(title);
			coinCount += 1;
			break;
		}
		case ('-'): { // floor without coin
			Title title = new Title(Gfx.floor_img, true, false, false, false);
			addTitle(title);
			break;
		}
		case ('@'): { // Player stating point
			Title title = new Title(Gfx.floor_img, true, false, false, false);
			addTitle(title);
			playerStartTitle = titles.size() - 1;
			break;
		}
		case ('$'): { // ghost stating point
			Title title = new Title(Gfx.floor_img, true, false, false, false);
			addTitle(title);
			ghostStartTitle = titles.size() - 1;
			break;
		}
		case ('&'): { // cherry
			Title title = new Title(Gfx.cherry_img, true, false, true, false);
			addTitle(title);
			break;
		}
		case ('?'): { // powerup
			Title title = new Title(Gfx.powerup_img, true, false, false, true);
			addTitle(title);
			break;
		}
		default:
		}
	}

	/**
	 * reset a level after we have played it once we simply reload the same
	 * level
	 */
	public void reset() {
		synchronized (titles) {
			load(lastLevel);
		}
	}

	/**
	 * add title to the level
	 */
	private void addTitle(Title t) {
		titles.addElement(t);
	}

	/**
	 * return the image of the title
	 * 
	 * @return Image
	 */
	public Image getTitleImage(int pos) {
		if (titles.isEmpty())
			throw new NullPointerException();
		Title t = titles.elementAt(pos);
		return t.getImage();
	}

	/**
	 * check if the title at pos contain coin
	 * 
	 * @param int
	 *            the title
	 * @return if there is a coin there
	 */
	public boolean coinAt(int pos) {
		Title title = titles.elementAt(pos);
		return title.getCoin();
	}

	/**
	 * check if the title at pos contain cherry
	 * 
	 * @param int
	 *            the title
	 * @return if there is a cherry there
	 */
	public boolean cherryAt(int pos) {
		Title title = titles.elementAt(pos);
		return title.getCherry();
	}

	/**
	 * check if the title at pos contain powerup
	 * 
	 * @param int
	 *            the title
	 * @return if there is a powerup there
	 */
	public boolean powerupAt(int pos) {
		Title title = titles.elementAt(pos);
		return title.getPowerup();
	}

	/**
	 * grab the item at a pos
	 * 
	 * @param int
	 *            pos
	 */
	public void grabCoinAt(int pos) {
		Title title = titles.elementAt(pos);
		// boolean coin = title.getCoin();
		title.setCoin(false);
	}

	/**
	 * grab the item at a pos
	 * 
	 * @param int
	 *            pos
	 */
	public void grabCherryAt(int pos) {
		Title title = titles.elementAt(pos);
		// boolean cherry = title.getCherry();
		title.setCherry(false);
	}

	/**
	 * grab the item at a pos
	 * 
	 * @param int
	 *            pos
	 */
	public void grabPowerupAt(int pos) {
		Title title = titles.elementAt(pos);
		title.setPowerup(false);
	}

	/**
	 * return the player startpos from the level
	 * 
	 * @return XYpos
	 * @see XYpos
	 */
	public XYpos getPlayerStartPos() {
		return titleToXy(playerStartTitle);
	}

	/**
	 * return the Ghost startpos from the level
	 * 
	 * @return XYpos
	 * @see XYpos
	 */
	public XYpos getGhostStartPos() {
		return titleToXy(ghostStartTitle);
	}

	/**
	 * return the total number of coins on the level So the
	 * 
	 * @see Player object know when he got them all
	 */
	public int getCoins() {
		return coinCount;
	}

	/**
	 * convert a title pos to screen xy cordinate
	 * 
	 * @return
	 * @see XYpos
	 */
	public XYpos titleToXy(int requested) {
		int pos = 0;
		for (int y = 0; y < Const.HEIGHT; y++) {
			for (int x = 0; x < Const.WIDTH; x++) {
				if (requested == pos) {
					XYpos xypos = new XYpos(x * Const.TITLE_SIZE, y
							* Const.TITLE_SIZE);
					return xypos;
				}
				pos += 1;
			}
		}
		return null;
	}

	/**
	 * convert x,y pos to a title nummber
	 * 
	 * @return int the title nummber
	 */
	public int xyToTitle(int x, int y) {
		int pos = 0;
		for (int ytit = 0; ytit < Const.HEIGHT; ytit++) {
		for (int xtit = 0; xtit < Const.WIDTH; xtit++) {
final int xx = xtit * Const.TITLE_SIZE;
final int yy = ytit * Const.TITLE_SIZE;
				if (between(x, xx, xx + 20) && between(y, yy, yy + 20)) {
					return pos;
				}
				pos++;
			}
		}
		return 0;
	}

	/**
	 * check if is is possible to move from the possition given in the specifyed
	 * direction
	 * 
	 * @return true if it is possible
	 */
	public boolean checkMove(int direction, int x, int y) {
		int pos = 0;
		for (int ytit = 0; ytit < Const.HEIGHT; ytit++) {
			for (int xtit = 0; xtit < Const.WIDTH; xtit++) {
				if (between(x, xtit * Const.TITLE_SIZE, xtit * Const.TITLE_SIZE
						+ 21)
						&& between(y, ytit * Const.TITLE_SIZE, ytit
								* Const.TITLE_SIZE + 21)) {
					int nextTitle = 0;
					switch (direction) {
					case Const.RIGHT:
						nextTitle = pos + 1;
						break;
					case Const.DOWN:
						nextTitle = pos + 19;
						break;
					case Const.LEFT:
						nextTitle = pos - 1;
						break;
					case Const.UP:
						nextTitle = pos - 19;
						break;
					}

					if (between(nextTitle, 0, Const.TITLES + 1)) {
						Title title = titles.elementAt(nextTitle);
						return title.getWalkable();
					} else
						return false;
				}
				pos += 1;
			}
		}
		return true;
	}

	/**
	 * check if tal is between intS and intE
	 */
	private boolean between(int tal, int intS, int intE) {
		return (tal > intS && tal < intE)
;	}
}
class ResourceLoader {
	public static File load(String aFile) {
		return new File(aFile);
	}

	public static String[] loadAll(String s) {
		return new File(s).list();
	}
}