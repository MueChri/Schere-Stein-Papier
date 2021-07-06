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
		this.textPlayerPicked.setBounds(0, 7, 185, 70);
		this.add(this.textPlayerPicked);

		this.textOpponentPicked = new CenteredText("", 18, Font.BOLD);
		this.textOpponentPicked.setBounds(185, 7, 185, 70);
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
    	String playerPickImagePath;
    	String opponentPickImagePath;
    	GameRoundResult result = gameState.getLastResult();

    	if (result == GameRoundResult.WON) {
    		resultImagePath = "src/images/YouWon.png";
    	} else if (result == GameRoundResult.LOST) {
    		resultImagePath = "src/images/YouLost.png";
    	} else {
    		resultImagePath = "src/images/DrawGame.png";
    	}

    	if (gameState.getGesturePlayer() == Gesture.ROCK) {
    		playerPickImagePath = "src/images/RockGesture2.png";
    	} else if (gameState.getGesturePlayer() == Gesture.PAPER) {
    		playerPickImagePath = "src/images/PaperGesture2.png";
    	} else {
    		playerPickImagePath = "src/images/ScissorsGesture2.png";
    	}

    	if (gameState.getGestureOpponent() == Gesture.ROCK) {
    		opponentPickImagePath = "src/images/RockGesture2.png";
    	} else if (gameState.getGestureOpponent() == Gesture.PAPER) {
    		opponentPickImagePath = "src/images/PaperGesture2.png";
    	} else {
    		opponentPickImagePath = "src/images/ScissorsGesture2.png";
    	}

    	this.textPlayerPicked.setText("<html><center>YOU<br>PICKED<br>" + gameState.getGesturePlayer() + "</center></html>");
		this.textOpponentPicked.setText("<html><center>OPPONENT<br>PICKED<br>" + gameState.getGestureOpponent() + "</center></html>");
		this.textContinue.setText("PRESS ENTER " + (gameState.getRoundsCounted() < gameState.maxRounds ? "FOR NEXT ROUND" : "TO FINISH GAME"));

		ImageIcon icon = new ImageIcon(resultImagePath);
		graphics.drawImage(icon.getImage(), 10, 170, this);

		ImageIcon playerImage = new ImageIcon(playerPickImagePath);
		graphics.drawImage(playerImage.getImage(), 53, 90, 80, 80, this);
		
		ImageIcon opponentImage = new ImageIcon(opponentPickImagePath);
		graphics.drawImage(opponentImage.getImage(), 238, 90, 80, 80, this);
	}
}
