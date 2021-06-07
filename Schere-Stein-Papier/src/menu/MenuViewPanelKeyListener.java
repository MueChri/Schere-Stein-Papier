package menu;

import java.awt.event.KeyEvent;

import main.ViewPanelKeyListener;

public class MenuViewPanelKeyListener extends ViewPanelKeyListener {
	
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
	
}

