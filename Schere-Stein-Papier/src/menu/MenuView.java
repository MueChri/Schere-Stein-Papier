package menu;

import java.awt.Dimension;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import main.MainController;
import main.abstracts.View;
import main.enums.Views;

public class MenuView extends View {
		
	public MenuView(Views id, MainController main) {
		super(id, main, new MenuController(id, main));
	}
	
	protected void paintComponent (Graphics g ) {
		super.paintComponent(g);
		g.drawImage(new ImageIcon("images/backgroundProject.png").getImage(),0,0,this);
		g.drawImage(new ImageIcon("images/HighscoreShadow.png").getImage(),90,127,182,115,this);
		g.drawImage(new ImageIcon("images/StartNowButtonShadow.png").getImage(),48,228,270,272,this);
		g.drawImage(new ImageIcon("images/infoButton.png").getImage(),310,0,27,27,this);
	}
}