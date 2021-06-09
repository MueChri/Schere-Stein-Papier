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
				panel.gameState.setGestureOpponent();
				//panel.gameState.setGesturePlayer(GestureTypes.PAPER);
				break;
			case KeyEvent.VK_LEFT:
				panel.gameState.setGestureOpponent();
				//panel.gameState.setGesturePlayer(GestureTypes.ROCK);
				break;
			case KeyEvent.VK_RIGHT:
				panel.gameState.setGestureOpponent();
				//panel.gameState.setGesturePlayer(GestureTypes.SCISSORS);
				break;
			default:
		}
		// panel.nextStep()
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
	
}
