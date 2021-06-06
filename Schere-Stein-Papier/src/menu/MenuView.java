package menu;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import main.MainController;
import main.abstracts.View;
import main.enums.Views;

public class MenuView extends View {
		
	public MenuView(Views id, MainController main) {
		super(id, main, new MenuController(id, main));
	}
	
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		graphics.drawImage(new ImageIcon("images/HighscoreShadow.png").getImage(),90,127,182,115,this);
		graphics.drawImage(new ImageIcon("images/StartNowButtonShadow.png").getImage(),48,228,270,272,this);
		graphics.drawImage(new ImageIcon("images/infoButton.png").getImage(),310,0,27,27,this);
	}
}