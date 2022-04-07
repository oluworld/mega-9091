package tripleo.impohrt.pacman1;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.List;

import javax.swing.*;

/**
 * new game gui dialog where you can enter your name and
 * select the level you want to play
 */
public class NewGameGui {
//	private JPanel mainPanel = new JPanel();
	private final JTextField nameText = new JTextField();
	private final JButton cancelButton = new JButton("Cancel");
	private final JButton startButton = new JButton("Start");
	private final JLabel nameLabel = new JLabel("Name:");
	private final JLabel levelLabel = new JLabel("Level:");
	private JComboBox<String> levelCombo = null;
	private World world = null;
	private final JDialog jDialog;

	/**
	 * constructor for the class
	 */
	public NewGameGui(JFrame frame, World aWorld) {
		jDialog = new JDialog(frame, "New Game");
		this.world = aWorld;
		nameText.setText("John Doe");
		levelCombo = new JComboBox<>(new Vector<>(getLevels()));
		Container contentPane = jDialog.getContentPane();
		contentPane.setLayout(new GridLayout(0, 2));
		contentPane.add(nameLabel);
		contentPane.add(nameText);
		contentPane.add(levelLabel);
		contentPane.add(levelCombo);
		contentPane.add(startButton);
		contentPane.add(cancelButton);
		cancelButton.addActionListener(new CancelListener());
		startButton.addActionListener(new StartListener());
		nameText.selectAll();
		jDialog.setSize(300, 100);
		jDialog.setResizable(false);
		jDialog.setVisible(true);
	}

	/**
	 * Read all levels from the level dir and add to combobox.
	 * Level files is all files with extention .lev
	 */
	private List<String> getLevels() {
		List<String> v = new Vector<String>();
		String[] files= ResourceLoader.loadAll("../resources/levels/");
//		String files[] = dir.list();

        for (String file : files) {
            if (file.endsWith(".lev"))    //add all lev files to the vector
            {
                v.add(file);
            }
        }
		return v;
	}

	public JDialog getjDialog() {
		return jDialog;
	}

	public class CancelListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			jDialog.setVisible(false);
		}
	}

	public class StartListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			jDialog.setVisible(false);
			String value = (String) levelCombo.getSelectedItem();
			world.setLevel(value);
			world.newGame(nameCheck(nameText.getText()));
		}
	}

	/**
	 * check the length of the name and cut it if it's to long
	 * so it dont mess up the highscore totaly
	 */
	private String nameCheck(String s) {
		if (s.length() >= 15) {
			System.out.println(s.substring(0, 14) + "...");
			return s.substring(0, 14) + "... ";
		}
		return s;
	}
}
