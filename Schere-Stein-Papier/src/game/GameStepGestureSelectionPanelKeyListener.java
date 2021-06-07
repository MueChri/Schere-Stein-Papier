package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameStepGestureSelectionPanelKeyListener implements KeyListener {

	@Override
	public void keyPressed(KeyEvent event) {
		int key = event.getKeyCode();
		GameState gameState = ((GameViewPanel) event.getComponent()).gameState;
		switch(key) {
		case KeyEvent.VK_DOWN:
			gameState.pickGesturePlayer(GestureTypes.PAPER);
			break;
		case KeyEvent.VK_LEFT:
			gameState.pickGesturePlayer(GestureTypes.ROCK);
			break;
		case KeyEvent.VK_RIGHT:
			gameState.pickGesturePlayer(GestureTypes.SCISSORS);
			break;
		default:
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
	
}
