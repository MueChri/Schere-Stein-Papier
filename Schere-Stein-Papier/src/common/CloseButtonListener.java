package common;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import main.MainView;

public class CloseButtonListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent event) {
		((MainView) SwingUtilities.windowForComponent(event.getComponent())).controller.exit();		
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
