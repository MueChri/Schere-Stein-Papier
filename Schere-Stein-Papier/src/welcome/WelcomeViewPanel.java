package welcome;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import common.CenteredText;
import main.ViewPanel;

public class WelcomeViewPanel extends ViewPanel {

	public WelcomeViewPanel() {

		JLabel welcomeLabel = new CenteredText("ROCK PAPER SCISSORS", 29, Font.BOLD);
		welcomeLabel.setBounds(0, 40, 370, 35);
		this.add(welcomeLabel);

		JLabel continueLabel = new CenteredText("PRESS ENTER TO CONTINUE", 18, Font.BOLD);
		continueLabel.setBounds(0, 400, 370, 25);
		this.add(continueLabel);
		
		this.addKeyListener(new WelcomeViewPanelKeyListener());

	}
	
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		graphics.drawImage(new ImageIcon(getClass().getResource("/Welcometransparent.png")).getImage(),-11,119,404,262,this);
	}

}




