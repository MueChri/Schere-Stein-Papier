package welcome;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.SwingUtilities;

import main.MainFrame;
import main.ViewPanelRegistryItems;

public class WelcomeViewPanelKeyListener implements KeyListener {
	
	public WelcomeViewPanelKeyListener() {
	}
	
	@Override
	public void keyPressed(KeyEvent event) {
		int key = event.getKeyCode();
		if (key == KeyEvent.VK_ENTER) {
			((MainFrame) SwingUtilities.windowForComponent(event.getComponent())).viewPanelRegistry.setCurrentView(ViewPanelRegistryItems.MENU);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
	
}
