package game;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import common.CenteredText;

public class GameStepGestureSelectionPanel extends JPanel {

	public GameStepGestureSelectionPanel() {
		
		this.setLayout(null);
		this.setBounds(0, 30, 370, 440);
		this.setOpaque(false);
		
		this.add(new GestureButtonPanel(Gesture.ROCK));
		this.add(new GestureButtonPanel(Gesture.PAPER));
		this.add(new GestureButtonPanel(Gesture.SCISSORS));

		JLabel pickGesture = new CenteredText("PICK YOUR GESTURE", 29, Font.BOLD);
		pickGesture.setBounds(0, 40, 370, 30);
		this.add(pickGesture);
			
		JLabel pressKeys = new CenteredText("PRESS AN ARROW KEY", 18, Font.BOLD);
		pressKeys.setBounds(0, 135, 370, 30);
		this.add(pressKeys);
	}
}
