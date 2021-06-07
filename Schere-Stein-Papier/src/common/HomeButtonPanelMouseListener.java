package common;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import main.MainFrame;
import main.ViewPanelRegistryItems;

public class HomeButtonPanelMouseListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent event) {
		((MainFrame) SwingUtilities.windowForComponent(event.getComponent())).viewPanelRegistry.setCurrentView(ViewPanelRegistryItems.MENU);
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
