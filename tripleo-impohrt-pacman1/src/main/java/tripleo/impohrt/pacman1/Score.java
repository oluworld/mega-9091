package tripleo.impohrt.pacman1;

import java.io.Serializable;

/**
 * highscore have a list of Score objects the score object represent a result
 * from one game name, score and how many rounds the player made
 */
class Score implements Serializable, Comparable {

    private final String name;
    private final int points;
    private final int round;

    /**
     * constructor for Score objects
     */
    public Score(String p, int round, int po) {
        this.name = p;
        this.round = round;
        this.points = po;
    }

    /**
     * used for sorting in the highscore
     */
    public int compareTo(Object o) {
        int result = -1;
        if (o instanceof Score) {
            Score s = (Score) o;
            result = s.points - points;
        }
        return result;
    }

    /**
     * returna the players name
     *
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * returna the players score
     *
     * @return String score
     */
    public String getScore() {
        return Integer.toString(points);
    }

    /**
     * returna the players round
     *
     * @return String round
     */
    public String getRound() {
        return Integer.toString(round);
    }

    /**
     * debug purpose
     */
    public String toString() {
        return "" + name + " " + round + " " + points;
    }
}
