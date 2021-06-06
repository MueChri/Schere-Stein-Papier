package welcome;

import java.awt.Dimension;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import main.MainController;
import main.abstracts.View;
import main.enums.Views;


public class WelcomeView extends View {

	public WelcomeView(Views id, MainController main) {
		super(id, main, new WelcomeController(id, main));
	}
	
	protected void paintComponent (Graphics g ) {
		super.paintComponent(g);
		g.drawImage(new ImageIcon("images/backgroundProject.png").getImage(),0,0,this);
		g.drawImage(new ImageIcon("images/Welcometransparent.png").getImage(),-11,119,404,262,this);
		g.drawImage(new ImageIcon("images/closeButton.png").getImage(),340,0,28,28,this);
	}

}