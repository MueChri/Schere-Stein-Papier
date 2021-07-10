package game;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import common.CenteredText;

public class GestureButtonPanel extends JPanel {
	
	private final String arrow;
	private final String image;
	private final int xPosition;
	
	public GestureButtonPanel(Gesture type) {
		this.arrow = this.getGestureArrow(type);
		this.image = this.getGestureImage(type);
		this.xPosition = this.getXPosition(type);

		this.setLayout(null);
		this.setSize(120, 170);
		this.setLocation(this.xPosition, 210);
		this.setOpaque(false);
		
		JLabel arrow = new CenteredText(this.arrow, 48, Font.BOLD);
		arrow.setBounds(0, 0, 120, 50);
		this.add(arrow);

		JLabel name = new CenteredText("" + type, 18, Font.BOLD);
		name.setBounds(0, 150, 120, 20);
		this.add(name);
}
	
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		ImageIcon icon = new ImageIcon(getClass().getResource(this.image));
		graphics.drawImage(icon.getImage(), 20, 60, 80, 80, this);
	}
	

	private String getGestureArrow(Gesture type) {
		switch(type) {
			case ROCK:
				return "←";
			case PAPER:
				return "↓";
			case SCISSORS:
			default:
				return "→";
		}
	}
	
	private String getGestureImage(Gesture type) {
		switch(type) {
		case ROCK:
			return "/RockGesture.png";
		case PAPER:
			return "/PaperGesture.png";
		case SCISSORS:
		default:
			return "/ScissorsGesture.png";
		}
	}
	
	private int getXPosition(Gesture type) {
		switch (type) {
		case ROCK:
			return 5;
		case PAPER:
			return 125;
		case SCISSORS:
		default:
			return 245;
		}
	}
	
}
