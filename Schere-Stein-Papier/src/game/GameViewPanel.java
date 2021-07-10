package game;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import common.CenteredText;
import common.HomeButtonPanel;
import main.ViewPanel;

public class GameViewPanel extends ViewPanel {
	
	public final GameState gameState = new GameState();
	
	private JLabel roundsInfo = null;
	private JPanel stepPanel = null;
	private KeyListener keyListener = null;

	public GameViewPanel() {
		this.add(new HomeButtonPanel());

		this.roundsInfo = new CenteredText("", 18, Font.BOLD);
		this.roundsInfo.setBounds(40, 5, 290, 20);
		this.add(this.roundsInfo);
		
		this.addKeyListener(new GameViewPanelKeyListener());

		this.showPlayerGestureSelection();
	}
	
	public void showPlayerGestureSelection() {
		this.setStepPanel(
			new GameStepGestureSelectionPanel(),
			new GameStepGestureSelectionPanelKeyListener()
		);
	}
	
	public void showOpponentGestureSelection() {
		this.setStepPanel(
			new GameStepOpponentGestureAnimationPanel(),
			null
		);
	}
	
	public void showRoundResult() {
		this.setStepPanel(
			new GameStepRoundResultPanel(),
			new GameStepRoundResultPanelKeyListener()
		);
	}
	
	public void showGameResult() {
		this.setStepPanel(
			new GameStepGameResultPanel(),
			null
		);
	}
	
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		int currentRound = this.gameState.getCurrentRound();
		String roundsInfoText = (currentRound <= this.gameState.maxRounds && !this.gameState.isGameClosed()) ? "ROUND " + currentRound + " OF 10" : "";  
		this.roundsInfo.setText(roundsInfoText);
	}
	
	private void setStepPanel(JPanel stepPanel, KeyListener keyListener) {
		if (this.stepPanel != null) {
			this.remove(this.stepPanel);
		}
		this.stepPanel = stepPanel;
		this.add(this.stepPanel);
		this.setKeyListener(keyListener);
		this.revalidate();
		this.repaint();
	}
	
	public void setKeyListener(KeyListener keyListener) {
		if (this.keyListener != null) {
			this.removeKeyListener(this.keyListener);
		}
		this.keyListener = keyListener;
		if (keyListener != null) {
			this.addKeyListener(keyListener);
		}
	}
	
}
