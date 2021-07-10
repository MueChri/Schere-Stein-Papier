package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import common.CenteredText;
import highscores.Highscore;
import highscores.HighscoresManager;
import main.MainFrame;

public class GameStepGameResultPanel extends JPanel {

	private JLabel textRoundsWon;
	private JLabel textRoundsLost;
	private JLabel textRoundsDraw;
	private JLabel textContinue;
	private JLabel textClaim;
	private JTextField textfield;
	private JButton button;
	private boolean highscoreSaved = false;
	private int rank = 0;
	
	private HighscoresManager manager = new HighscoresManager();

	public GameStepGameResultPanel() {
		this.setLayout(null);
		this.setBounds(0, 30, 370, 440);
		this.setOpaque(false);

		this.textRoundsWon = new CenteredText("", 18, Font.BOLD);
		this.textRoundsWon.setBounds(0, 25, 370, 20);
		this.add(this.textRoundsWon);

		this.textRoundsLost = new CenteredText("", 18, Font.BOLD);
		this.textRoundsLost.setBounds(0, 55, 370, 20);
		this.add(this.textRoundsLost);

		this.textRoundsDraw = new CenteredText("", 18, Font.BOLD);
		this.textRoundsDraw.setBounds(0, 85, 370, 20);
		this.add(this.textRoundsDraw);
		
		this.textClaim = new CenteredText("CALCULATING RANK...", 18, Font.BOLD);
		this.textClaim.setBounds(0, 150, 370, 20);
		this.add(this.textClaim);

		JLabel textName = new CenteredText("YOUR NAME", 18, Font.BOLD);
		textName.setBounds(0, 205, 370, 20);
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
        this.textfield.setBounds(100, 235, 170, 36);
        this.textfield.addActionListener(new SaveHighscoreListener());
        this.add(this.textfield);
 
        this.button = new JButton("SAVE HIGHSCORE");
        this.button.setFont(new Font("Montserrat", Font.BOLD, 13));
        this.button.setBounds(100, 280, 170, 30);
        this.button.setForeground(Color.BLACK);
        this.button.addActionListener(new SaveHighscoreListener());
        this.add(this.button);
   	}

	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);

		GameState gameState = ((GameViewPanel) getParent()).gameState;
		String playerName = ((MainFrame) SwingUtilities.windowForComponent(this)).playerName;
		
		if (this.textfield.getText() == "") {
			this.textfield.setText(playerName);
		}

		if (this.rank == 0) {
			this.loadRank();
		} else {
			this.textClaim.setText("YOU CLAIMED RANK " + this.rank);
		}
    
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
		((MainFrame) SwingUtilities.windowForComponent(this)).playerName = playerName;
		this.textfield.setEditable(false);
		this.button.setEnabled(false);
		this.button.setText("SAVING...");
		this.insertHighscore();
		this.repaint();
	}

	public class SaveHighscoreListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			saveHighscore();
		}
	}
	
	public void insertHighscore() {
		Thread t = new Thread() {
			public void run() {
				GameViewPanel gameView = (GameViewPanel) getParent();
				GameState gameState = gameView.gameState;
				manager.save(new Highscore(textfield.getText(), new Date(), gameState.getRoundsWon(), gameState.getRoundsDraw()));;
				button.setText("HIGHSCORE SAVED");
				highscoreSaved = true;
				gameView.setKeyListener(new GameStepGameResultPanelKeyListener());
				repaint();
			}
		};
		t.start();		
	}
	
	private void loadRank() {
		Thread t = new Thread() {
			public void run() {
				GameState gameState = ((GameViewPanel) getParent()).gameState;
				rank = manager.getRank(new Highscore("", new Date(), gameState.getRoundsWon(), gameState.getRoundsDraw()));
				repaint();
			}
		};
		t.start();
	}
	
}
