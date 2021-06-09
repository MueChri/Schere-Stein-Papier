package game;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import common.CenteredText;

public class GameStepOpponentGestureSelectionPanel extends JPanel {

	public GameStepOpponentGestureSelectionPanel() {

		this.setLayout(null);
		this.setBounds(0, 30, 370, 400);
		this.setOpaque(false);
	
	}
	
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Image image = new ImageIcon("images/RockGesture2.png").getImage();
		graphics.drawImage(image, 0, 0, this);
	}


}
