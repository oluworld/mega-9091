package tripleo.impohrt.pacman1;

public class Sound {

    public static WavePlayer levelSound;
    public static WavePlayer coinSound;
    public static WavePlayer startSound;
    public static WavePlayer gameOverSound;
    public static WavePlayer sirenSound;
    public static WavePlayer cherrySound;
    public static WavePlayer ghostDieSound;
    public static WavePlayer dieSound;

    public static void load() {
        System.out.print("\nLoading sounds...");
        ghostDieSound = new WavePlayer("../resources/sound/sheep2.wav");
        cherrySound = new WavePlayer("../resources/sound/coinst1.wav");
        sirenSound = new WavePlayer("../resources/sound/siren.wav");
        gameOverSound = new WavePlayer("../resources/sound/bong.wav");
        startSound = new WavePlayer("../resources/sound/bong.wav");
        coinSound = new WavePlayer("../resources/sound/coin.wav");
        levelSound = new WavePlayer("../resources/sound/level.wav");
        dieSound = new WavePlayer("../resources/sound/out.wav");
        System.out.print("Done!\n");
    }
}
