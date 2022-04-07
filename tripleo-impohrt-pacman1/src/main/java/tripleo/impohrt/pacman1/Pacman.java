package tripleo.impohrt.pacman1;

import java.awt.BorderLayout;
import java.awt.event.*;

import javax.swing.*;

/**
 * <p>
 * Pacman v. 1.0</p>
 * Made by:<br>
 * Andreas Henningsson nd02aho@student.hig.se<br>
 * Erik Bergerfors nf02ebs@student.hig.se<br>
 * Homepage: http://student.hig.se/~nd02aho/pacman/<br>
 */
public class Pacman {

    private final boolean playMusic = true;
    private JFrame frame = null;
    private final JPanel northPanel = new JPanel();
    private final JPanel mainpanel = new JPanel();
    private final World world = new World();
    private final JMenuBar menubar = new JMenuBar();
    private final JFrame jFrame;

    // removed until we get it working in Windows (Works in linux)
    //private static MidiPlayer music = new MidiPlayer("../resources/sound/California_Girls.mid");
    /**
     * constructor - init the menus and main window
     */
    public Pacman() {
        jFrame = new JFrame("PacMan");
        frame = jFrame;

        // add the menus
        JMenu menu;
        JMenuItem menuItem;
        menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_F);
        menuItem = new JMenuItem("New Game");
        menuItem.addActionListener(new NewListener());
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
        menu.add(menuItem);
        menuItem = new JMenuItem("Highscore");
        menuItem.addActionListener(new HighScoreListener());
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_MASK));
        menu.add(menuItem);
        menuItem = new JMenuItem("Quit");
        menuItem.addActionListener(new ExitListener());
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
        menu.add(menuItem);
        menubar.add(menu);

        menu = new JMenu("Help");
        menu.setMnemonic(KeyEvent.VK_H);
        menuItem = new JMenuItem("About");
        menuItem.addActionListener(new AboutListener());
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
        menu.add(menuItem);
        menubar.add(menu);

        // fix the screen layout
        mainpanel.setLayout(new BorderLayout());
        northPanel.setLayout(new BorderLayout());
        northPanel.add(menubar);
        mainpanel.add(world.jPanel, BorderLayout.CENTER);
        mainpanel.add(northPanel, BorderLayout.NORTH);

        jFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        jFrame.setContentPane(mainpanel);
        jFrame.setSize(390, 500);
        jFrame.setResizable(false);
        jFrame.setVisible(true);
        jFrame.addWindowListener(new CloseListener());
    }

    public class NewListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            new NewGameGui(frame, world);
        }
    }

    public class HighScoreListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            new HighScoreGui(frame);
        }
    }

    public class ExitListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            quit();
        }
    }

    public class CloseListener extends WindowAdapter //implements WindowEvent
    {

        public void windowClosing(WindowEvent e) {
            quit();
        }
    }

    public class AboutListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            JOptionPane.showMessageDialog(frame, "Made by:\nAndreas Henningsson (andreas.henningsson@telia.com)\nErik Bergerfors (erik.bergerfors@home.se) \n\n 2003 (C) All rights reserved.\n ", "About", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void quit() {

        Object[] options = {"Yes! I am very convinced", "No I want to play again!"};
        int n = JOptionPane.showOptionDialog(mainpanel,
                "Sure you want to quit this wonderful game?",
                "Exit",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, //don't use a custom Icon
                options, //the titles of buttons
                options[0]); //default button title

        if (n == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    /**
     * load musik, load gfx, start the game
     */
    public static void main(String args[]) {
        // removed until we get it working in Windows (Works in linux)
        //music.play();		// start the music
        Gfx.load();		// load the gfx
        Sound.load();           // loads th sound
        new Pacman();           // init
    }

}
