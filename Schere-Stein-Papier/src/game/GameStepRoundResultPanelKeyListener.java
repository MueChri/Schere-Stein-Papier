package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameStepRoundResultPanelKeyListener implements KeyListener {

	@Override
	public void keyPressed(KeyEvent event) {
		int key = event.getKeyCode();
		GameViewPanel panel = (GameViewPanel) event.getComponent();
		if (key == KeyEvent.VK_ENTER) {
			if (panel.gameState.getRoundsCounted() < panel.gameState.maxRounds) {
				panel.gameState.nextRound();
				panel.showPlayerGestureSelection();
			} else {
				panel.gameState.closeGame();
				panel.showGameResult();
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
	
}
