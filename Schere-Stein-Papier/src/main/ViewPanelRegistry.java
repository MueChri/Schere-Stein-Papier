package main;

import java.util.HashMap;
import java.util.Map;

import game.GameViewPanel;
import highscores.HighscoresViewPanel;
import menu.MenuViewPanel;
import welcome.WelcomeViewPanel;

public class ViewPanelRegistry {

	private final Map<ViewPanelRegistryItems, ViewPanel> views = new HashMap<ViewPanelRegistryItems, ViewPanel>();

	private final MainFrame mainFrame;
	
	private ViewPanel currentView = null;
	
	public ViewPanelRegistry(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.registerViewPanels();
	}
	
	public ViewPanel getViewById(ViewPanelRegistryItems id) {
		return this.views.get(id);
	}
	
	public void setCurrentView(ViewPanelRegistryItems id) {
		this.currentView = this.getViewById(id);
		this.paintCurrentView();
	}
	
	private void paintCurrentView() {
		this.mainFrame.getContentPane().removeAll();   
		this.mainFrame.getContentPane().add(this.currentView);
		this.mainFrame.revalidate();
		this.currentView.repaint();
		this.mainFrame.pack();
	}
	
	private void registerViewPanels() {
		
		// register welcome view
		this.views.put(ViewPanelRegistryItems.WELCOME, new WelcomeViewPanel());
		
		// register menu view
		this.views.put(ViewPanelRegistryItems.MENU, new MenuViewPanel());
		
		// register game view
		this.views.put(ViewPanelRegistryItems.GAME, new GameViewPanel());
		
		// register highscores view
		this.views.put(ViewPanelRegistryItems.HIGHSCORES, new HighscoresViewPanel());
	}
}
