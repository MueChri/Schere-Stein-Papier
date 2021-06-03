package view;

import java.awt.Dimension;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import controller.EnterKeyListenerController;


public class WelcomePanelView extends JPanel {
	
	private EnterKeyListenerController controller;  
	
	public WelcomePanelView() {
		this.setPreferredSize(new Dimension(370,500));  
		
		controller= new EnterKeyListenerController();     
		controller.setWelcomePanel(this);       //
		addKeyListener(controller);             //
		 
	}
	
	protected void paintComponent (Graphics g ) {
		super.paintComponent(g);
	
		g.drawImage(new ImageIcon("C:\\Users\\araml\\eclipse-workspace\\Semester2\\src\\backgroundProject.png").getImage(),0,0,this);
		g.drawImage(new ImageIcon("C:\\Users\\araml\\eclipse-workspace\\Semester2\\src\\Welcometransparent.png").getImage(),-11,119,404,262,this);
		g.drawImage(new ImageIcon("C:\\Users\\araml\\eclipse-workspace\\Semester2\\src\\closeButton.png").getImage(),340,0,28,28,this);
	

}

}