package welcome;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import common.CenteredText;
import main.ViewPanel;

public class WelcomeViewPanel extends ViewPanel {

	public WelcomeViewPanel() {

		JLabel welcomeLabel = new CenteredText("ROCK PAPER SCISSOR", 29, Font.BOLD);
		welcomeLabel.setBounds(4, 39, 373, 36);
		this.add(welcomeLabel);

		JLabel continueLabel = new CenteredText("press enter...", 18, Font.BOLD);
		continueLabel.setBounds(98,417,173,44);
		this.add(continueLabel);
		
		this.addKeyListener(new WelcomeViewPanelKeyListener());

	}
	
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		graphics.drawImage(new ImageIcon("images/Welcometransparent.png").getImage(),-11,119,404,262,this);
	}

}




