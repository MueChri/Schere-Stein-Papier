package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameStepGestureSelectionPanelKeyListener implements KeyListener {

	@Override
	public void keyPressed(KeyEvent event) {
		int key = event.getKeyCode();
		GameViewPanel panel = (GameViewPanel) event.getComponent();
		switch(key) {
			case KeyEvent.VK_DOWN:
				panel.gameState.setGesturePlayer(Gesture.PAPER);
				break;
			case KeyEvent.VK_LEFT:
				panel.gameState.setGesturePlayer(Gesture.ROCK);
				break;
			case KeyEvent.VK_RIGHT:
				panel.gameState.setGesturePlayer(Gesture.SCISSORS);
				break;
			default:
		}
		if (panel.gameState.getGesturePlayer() != null) {
			panel.showOpponentGestureSelection();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
	
}
