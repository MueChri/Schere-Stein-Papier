package menu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MenuViewPanelKeyListener implements KeyListener {
	
	public MenuViewPanelKeyListener() {
		super();
	}
	
	@Override
	public void keyPressed(KeyEvent event) {
		int key = event.getKeyCode();
		if (key == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
	
}

