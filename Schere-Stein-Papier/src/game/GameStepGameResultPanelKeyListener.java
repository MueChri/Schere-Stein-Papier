package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameStepGameResultPanelKeyListener implements KeyListener {

	@Override
	public void keyPressed(KeyEvent event) {
		int key = event.getKeyCode();
		GameViewPanel panel = (GameViewPanel) event.getComponent();
		if (key == KeyEvent.VK_ENTER) {
			panel.gameState.resetGameState();
			panel.showPlayerGestureSelection();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
	
}
