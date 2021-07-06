package highscores;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.SwingUtilities;

import main.MainFrame;
import main.ViewPanelRegistryItems;

public class HighscoresViewPanelKeyListener implements KeyListener {
	
	@Override
	public void keyPressed(KeyEvent event) {
		int key = event.getKeyCode();
		if (key == KeyEvent.VK_ESCAPE) {
			((MainFrame) SwingUtilities.windowForComponent(event.getComponent())).viewPanelRegistry.setCurrentView(ViewPanelRegistryItems.MENU);
		} else if (key == KeyEvent.VK_LEFT) {
			((HighscoresViewPanel) event.getComponent()).previousPage();
		} else if (key == KeyEvent.VK_RIGHT) {
			((HighscoresViewPanel) event.getComponent()).nextPage();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
	
}