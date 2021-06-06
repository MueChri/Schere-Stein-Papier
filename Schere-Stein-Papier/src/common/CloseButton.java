package common;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class CloseButton extends JPanel {

	public CloseButton() {
		this.addMouseListener(new CloseButtonListener());
		this.setSize(28, 28);
		this.setLocation(340, 0);
		this.setOpaque(false);
	}
	
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		ImageIcon icon = new ImageIcon("images/closeButton.png");
		graphics.drawImage(icon.getImage(), 0, 0, 28, 28, this);
	}
		
}
