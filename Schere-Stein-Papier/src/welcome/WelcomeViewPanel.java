package welcome;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import main.ViewPanel;

public class WelcomeViewPanel extends ViewPanel {

	public WelcomeViewPanel() {
		super();
	}
	
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		graphics.drawImage(new ImageIcon("images/Welcometransparent.png").getImage(),-11,119,404,262,this);
	}

}