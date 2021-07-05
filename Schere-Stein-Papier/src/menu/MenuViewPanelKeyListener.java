package menu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.SwingUtilities;

import main.MainFrame;
import main.ViewPanelRegistryItems;

public class MenuViewPanelKeyListener implements KeyListener {
	
	@Override
	public void keyPressed(KeyEvent event) {
		int key = event.getKeyCode();
		if (key == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		} else if (key == KeyEvent.VK_ENTER) {
			((MainFrame) SwingUtilities.windowForComponent(event.getComponent())).viewPanelRegistry.setCurrentView(ViewPanelRegistryItems.GAME);
		} else if (key == KeyEvent.VK_H) {
			((MainFrame) SwingUtilities.windowForComponent(event.getComponent())).viewPanelRegistry.setCurrentView(ViewPanelRegistryItems.HIGHSCORES);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
	
}

