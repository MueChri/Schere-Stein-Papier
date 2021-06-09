package game;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import common.CenteredText;

public class GestureButtonPanel extends JPanel {
	
	private final Gesture type;
	private final String arrow;
	private final String image;
	private final int xPosition;
	
	public GestureButtonPanel(Gesture type) {
		this.type = type;
		this.arrow = this.getGestureArrow(type);
		this.image = this.getGestureImage(type);
		this.xPosition = this.getXPosition(type);

		this.setSize(80, 140);
		this.setLocation(this.xPosition, 210);
		this.setOpaque(false);
		
		JLabel continueLabel = new CenteredText(this.arrow, 32, Font.BOLD);
		continueLabel.setBounds(0, 0, 60, 120);
		this.add(continueLabel);
	}
	
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		ImageIcon icon = new ImageIcon(this.image);
		graphics.drawImage(icon.getImage(), 0, 60, 80, 80, this);
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
			return "images/RockGesture.png";
		case PAPER:
			return "images/PaperGesture.png";
		case SCISSORS:
		default:
			return "images/ScissorsGesture.png";
		}
	}
	
	private int getXPosition(Gesture type) {
		switch (type) {
		case ROCK:
			return 30;
		case PAPER:
			return 145;
		case SCISSORS:
		default:
			return 260;
		}
	}
	
}
