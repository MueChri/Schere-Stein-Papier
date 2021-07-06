package highscores;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class HighscoresViewPanelPreviousPageMouseListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent event) {
		((HighscoresViewPanel) event.getComponent().getParent()).previousPage();
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
