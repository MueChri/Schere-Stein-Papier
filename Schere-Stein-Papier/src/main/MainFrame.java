package main;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	
	public final ViewPanelRegistry viewPanelRegistry;
	
	public String playerName = "";
		
	public MainFrame() {
		
		// set window title
		super("Schere, Stein, Papier");
		
		// close app on window close 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// set window to visible
		this.setVisible(true);

		// create view panel registry
		this.viewPanelRegistry = new ViewPanelRegistry(this);

		// start with initial view
		this.viewPanelRegistry.setCurrentView(ViewPanelRegistryItems.WELCOME);
		
	}
	
}
