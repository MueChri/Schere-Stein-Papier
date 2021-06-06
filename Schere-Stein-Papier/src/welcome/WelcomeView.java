package welcome;

import java.awt.Dimension;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import common.CloseButton;
import main.MainController;
import main.abstracts.View;
import main.enums.Views;


public class WelcomeView extends View {

	public WelcomeView(Views id, MainController main) {
		super(id, main, new WelcomeController(id, main));
	}
	
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		graphics.drawImage(new ImageIcon("images/Welcometransparent.png").getImage(),-11,119,404,262,this);
	}

}