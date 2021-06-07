package common;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class CenteredText extends JLabel {

	public CenteredText(String text, int size, int weight) {
		super(text);
		Color textColor = new Color(199,186,217);
		Font welcomeFont = new Font("Montserrat", weight, size);
		this.setForeground(textColor);
		this.setFont(welcomeFont);
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setVerticalAlignment(JLabel.CENTER);
	}
	
}
