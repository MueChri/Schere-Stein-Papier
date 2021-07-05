package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import common.CenteredText;

public class GameStepGameResultPanel extends JPanel {

	private JLabel textRoundsWon;
	private JLabel textRoundsLost;
	private JLabel textRoundsDraw;
	private JLabel textContinue;
	private JTextField textfield;
	private JButton button;
	private boolean highscoreSaved = false;

	public GameStepGameResultPanel() {
		this.setLayout(null);
		this.setBounds(0, 30, 370, 440);
		this.setOpaque(false);

		this.textRoundsWon = new CenteredText("", 18, Font.BOLD);
		this.textRoundsWon.setBounds(0, 5, 370, 20);
		this.add(this.textRoundsWon);

		this.textRoundsLost = new CenteredText("", 18, Font.BOLD);
		this.textRoundsLost.setBounds(0, 35, 370, 20);
		this.add(this.textRoundsLost);

		this.textRoundsDraw = new CenteredText("", 18, Font.BOLD);
		this.textRoundsDraw.setBounds(0, 65, 370, 20);
		this.add(this.textRoundsDraw);

		JLabel textName = new CenteredText("YOUR NAME", 18, Font.BOLD);
		textName.setBounds(0, 125, 370, 20);
		this.add(textName);

		this.textContinue = new CenteredText("", 18, Font.BOLD);
		this.textContinue.setBounds(0, 400, 370, 20);
		this.add(this.textContinue);
		
		Color color = new Color(199, 186, 217);
        this.textfield = new JTextField("", 5);
        this.textfield.setForeground(color);
        this.textfield.setBackground(Color.BLACK);
        this.textfield.setFont(new Font("Montserrat", Font.BOLD, 18));
        this.textfield.setBorder(new LineBorder(color, 3, true));
        this.textfield.setBounds(100, 155, 170, 36);
        this.textfield.addActionListener(new SaveHighscoreListener());
        this.add(this.textfield);
 
        this.button = new JButton("SAVE HIGHSCORE");
        this.button.setFont(new Font("Montserrat", Font.BOLD, 13));
        this.button.setBounds(100, 200, 170, 30);
        this.button.setForeground(Color.BLACK);
        this.button.addActionListener(new SaveHighscoreListener());
        this.add(this.button);
	}

	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);

		GameState gameState = ((GameViewPanel) getParent()).gameState;
    
		this.textRoundsWon.setText("ROUNDS WON: " + gameState.getRoundsWon());
		this.textRoundsLost.setText("ROUNDS LOST: " + gameState.getRoundsLost());
		this.textRoundsDraw.setText("DRAW ROUNDS: " + gameState.getRoundsDraw());
		
		if (this.highscoreSaved) {
			this.textContinue.setText("PRESS ENTER TO START NEW GAME");
		}
	}
	
	private void saveHighscore() {
		if (this.highscoreSaved) {
			return;
		}
		String playerName = this.textfield.getText();
		if (playerName == "") {
			return;
		}
		System.out.println("SAVE: " + playerName);
		this.textfield.setEditable(false);
		this.button.setEnabled(false);
		this.button.setText("HIGHSCORE SAVED");
		this.highscoreSaved = true;
		GameViewPanel gameView = (GameViewPanel) this.getParent();
		gameView.setKeyListener(new GameStepGameResultPanelKeyListener());
		this.repaint();
	}

	public class SaveHighscoreListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			saveHighscore();
		}
	}
	
}
