package menu;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class HighscoresButtonPanel extends JPanel {

	public HighscoresButtonPanel() {
		this.addMouseListener(new HighscoresButtonPanelMouseListener());
		this.setSize(182, 115);
		this.setLocation(90, 127);
		this.setOpaque(false);	
	}
	
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		graphics.drawImage(new ImageIcon("images/HighscoreShadow.png").getImage(), 0, 0, this);
	}
	
}
