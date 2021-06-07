package welcome;

import java.awt.event.KeyEvent;

import main.MainFrame;
import main.ViewPanelKeyListener;
import main.ViewPanelRegistryItems;

public class WelcomeViewPanelKeyListener extends ViewPanelKeyListener {
	
	public WelcomeViewPanelKeyListener() {
		super();
	}
	
	@Override
	public void keyPressed(KeyEvent event) {
		int key = event.getKeyCode();
		if (key == KeyEvent.VK_ENTER) {
			((MainFrame) event.getComponent()).viewPanelRegistry.setCurrentView(ViewPanelRegistryItems.MENU);
		}
	}
	
}
