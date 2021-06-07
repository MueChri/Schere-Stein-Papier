package game;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import common.CenteredText;

public class GameStepGestureSelectionPanel extends JPanel {

	public GameStepGestureSelectionPanel() {
		
		this.setLayout(null);
		//this.setPreferredSize(new Dimension(370, 440));
		this.setBounds(0, 30, 370, 400);
		this.setOpaque(false);
		
		this.add(new GestureButtonPanel(GestureTypes.ROCK));
		this.add(new GestureButtonPanel(GestureTypes.PAPER));
		this.add(new GestureButtonPanel(GestureTypes.SCISSORS));

		JLabel pickGesture = new CenteredText("PICK GESTURE", 30, Font.BOLD);
		pickGesture.setBounds(75, 31, 235, 36);
		this.add(pickGesture);
			
		JLabel pressKeys = new CenteredText("press arrow keys", 18, Font.BOLD);
		pressKeys.setBounds(107, 135, 170, 44);
		this.add(pressKeys);
	}
}
