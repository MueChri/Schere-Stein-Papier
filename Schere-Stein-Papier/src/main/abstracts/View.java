package main.abstracts;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import common.CloseButton;
import main.MainController;
import main.enums.Views;

public abstract class View extends JPanel {

	public final Views id;
	public final Controller controller;

	protected final MainController main;
	
	public View(Views id, MainController main, Controller controller) {
		this.main = main;
		this.id = id;
		this.controller = controller;
		this.setLayout(null);
		this.setPreferredSize(new Dimension(370, 500));
		this.add(new CloseButton());
	}
	
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		graphics.drawImage(new ImageIcon("images/backgroundProject.png").getImage(),0,0,this);
	}

	
}
