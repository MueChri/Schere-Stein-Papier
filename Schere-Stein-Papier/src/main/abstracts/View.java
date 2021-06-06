package main.abstracts;

import java.awt.Dimension;

import javax.swing.JPanel;

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
		this.setPreferredSize(new Dimension(370, 500));
	}
	
}
