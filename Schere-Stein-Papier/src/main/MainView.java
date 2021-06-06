package main;

import javax.swing.JFrame;

import welcome.WelcomeView;

public class MainView extends JFrame {
	
	public final MainController controller;
		
	public MainView() {
		
		// set window title
		super("Schere, Stein, Papier");
		
		// close app on window close 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// set window to visible
		this.setVisible(true);

		// create view controller
		this.controller = new MainController(this);

		// start with initial view
		this.controller.setInitialView();
		
	}

}
