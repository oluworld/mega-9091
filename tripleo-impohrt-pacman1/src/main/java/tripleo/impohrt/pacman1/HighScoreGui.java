package tripleo.impohrt.pacman1;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Gui for the highscore
 */
public class HighScoreGui extends JDialog {
	private HighScore highScore = new HighScore("highscore.dat");
	private JButton cancelButton = new JButton("Cancel");
	private JLabel nameLabel = new JLabel("Name:");
	private JLabel roundLabel = new JLabel("Round:");
	private JLabel scoreLabel = new JLabel("Score:");
	private JLabel tempLabel = null;

	/**
	 * constructor for load the gui and higescore
	 */
	public HighScoreGui(JFrame frame) {
		super(frame, "HighScore");
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new GridLayout(0, 3));
		contentPane.add(nameLabel);
		contentPane.add(roundLabel);
		contentPane.add(scoreLabel);
		cancelButton.addActionListener(new CancelListener());
		this.setResizable(false);

		int l = 1;
		for (int i = 0; i < 10; i++) // add all the results
		{
			Score score;
			score = (Score) highScore.getPos(i);
			tempLabel = new JLabel(l + ". " + score.getName());
			contentPane.add(tempLabel);
			tempLabel = new JLabel(score.getRound());
			contentPane.add(tempLabel);
			tempLabel = new JLabel(score.getScore());
			contentPane.add(tempLabel);
			l++;
		}
		contentPane.add(new JPanel());
		contentPane.add(cancelButton);

		setSize(400, 400);
		setVisible(true);
	}

	public class CancelListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
	}
}
