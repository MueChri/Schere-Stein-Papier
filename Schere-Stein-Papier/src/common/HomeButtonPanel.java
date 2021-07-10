package common;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class HomeButtonPanel extends JPanel {

	public HomeButtonPanel() {
		this.addMouseListener(new HomeButtonPanelMouseListener());
		this.setSize(30, 30);
		this.setLocation(0, 470);
		this.setOpaque(false);
	}
	
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		ImageIcon icon = new ImageIcon(getClass().getResource("/HomeButton.png"));
		graphics.drawImage(icon.getImage(), 0, 0, this);
	}
}
