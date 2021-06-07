package menu;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import main.MainFrame;
import main.ViewPanelRegistryItems;

public class HighscoresButtonPanelMouseListener implements MouseListener {

	public HighscoresButtonPanelMouseListener() {
		
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		((MainFrame) SwingUtilities.windowForComponent(event.getComponent())).viewPanelRegistry.setCurrentView(ViewPanelRegistryItems.HIGHSCORES);
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
