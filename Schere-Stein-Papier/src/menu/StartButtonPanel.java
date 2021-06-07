package menu;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class StartButtonPanel extends JPanel {

	public StartButtonPanel() {
		super();
		this.setSize(270, 272);
		this.setLocation(48, 228);
		this.setOpaque(false);
		this.addMouseListener(new StartButtonPanelMouseListener());
	}
	
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		graphics.drawImage(new ImageIcon("images/StartNowButtonShadow.png").getImage(), 0, 0, this);
	}
	
}
