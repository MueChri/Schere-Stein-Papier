package menu;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class InfoButtonPanel extends JPanel {

	public InfoButtonPanel() {
		this.setSize(27, 27);
		this.setLocation(310, 0);
		this.setOpaque(false);	
	}
	
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		graphics.drawImage(new ImageIcon("src/images/infoButton.png").getImage(), 0, 0, this);
	}

	
}
