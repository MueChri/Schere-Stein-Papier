package game;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import common.CenteredText;

public class GameStepRoundResultPanel  extends JPanel {

	private JLabel textPlayerPicked;
	private JLabel textOpponentPicked;
	private JLabel textContinue;
	
	public GameStepRoundResultPanel() {
		this.setLayout(null);
		this.setBounds(0, 30, 370, 440);
		this.setOpaque(false);
		
		this.textPlayerPicked = new CenteredText("", 18, Font.BOLD);
		this.textPlayerPicked.setBounds(0, 5, 370, 20);
		this.add(this.textPlayerPicked);

		this.textOpponentPicked = new CenteredText("", 18, Font.BOLD);
		this.textOpponentPicked.setBounds(0, 35, 370, 20);
		this.add(this.textOpponentPicked);

		this.textContinue = new CenteredText("", 18, Font.BOLD);
		this.textContinue.setBounds(0, 400, 370, 20);
		this.add(this.textContinue);
	}
	
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);

		GameState gameState = ((GameViewPanel) getParent()).gameState;
    	gameState.countRound();
    	String resultImagePath;
    	GameRoundResult result = gameState.getLastResult();

    	if (result == GameRoundResult.WON) {
    		resultImagePath = "images/YouWon.png";
    	} else if (result == GameRoundResult.LOST) {
    		resultImagePath = "images/YouLost.png";
    	} else {
    		resultImagePath = "images/DrawGame.png";
    	}

    	this.textPlayerPicked.setText("YOU PICKED: " + gameState.getGesturePlayer());
		this.textOpponentPicked.setText("OPPONENT PICKED: " + gameState.getGestureOpponent());
		this.textContinue.setText("PRESS ENTER " + (gameState.getRoundsCounted() < gameState.maxRounds ? "FOR NEXT ROUND" : "TO FINISH GAME"));

		ImageIcon icon = new ImageIcon(resultImagePath);
		graphics.drawImage(icon.getImage(), 10, 80, this);
	}
}
