package main;

import java.util.HashMap;
import java.util.Map;

import game.GameViewPanel;
import highscores.HighscoresViewPanel;
import menu.MenuViewPanel;
import menu.MenuViewPanelKeyListener;
import welcome.WelcomeViewPanel;
import welcome.WelcomeViewPanelKeyListener;

public class ViewPanelRegistry {

	private final Map<ViewPanelRegistryItems, ViewPanelRegistryItem> views = new HashMap<ViewPanelRegistryItems, ViewPanelRegistryItem>();

	private final MainFrame mainFrame;
	
	private ViewPanelRegistryItem currentView = null;
	
	public ViewPanelRegistry(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.registerViewPanels();
	}
	
	public ViewPanelRegistryItem getViewById(ViewPanelRegistryItems id) {
		return this.views.get(id);
	}
	
	public void setCurrentView(ViewPanelRegistryItems id) {
		if (this.currentView != null) {
			this.removeKeyListenersForCurrentView();
		}
		this.currentView = this.getViewById(id);
		this.paintCurrentView();
		this.addKeyListenersForCurrentView();
	}
	
	private void paintCurrentView() {
		this.mainFrame.getContentPane().removeAll();   
		this.mainFrame.revalidate();
		this.currentView.panel.repaint();
		this.mainFrame.getContentPane().add(this.currentView.panel);
		this.mainFrame.pack();
	}
	
	private void addKeyListenersForCurrentView() {		
		this.currentView.keyListeners.forEach(
			(listener) -> this.mainFrame.addKeyListener(listener)
		);
	}
	
	private void removeKeyListenersForCurrentView() {
		this.currentView.keyListeners.forEach(
			(listener) -> this.mainFrame.removeKeyListener(listener)
		);		
	}

	private void registerViewPanels() {
		
		// register welcome view
		ViewPanelRegistryItem welcome = new ViewPanelRegistryItem(new WelcomeViewPanel());
		welcome.addKeyListener(new WelcomeViewPanelKeyListener());
		this.views.put(ViewPanelRegistryItems.WELCOME, welcome);
		
		// register menu view
		ViewPanelRegistryItem menu = new ViewPanelRegistryItem(new MenuViewPanel());
		menu.addKeyListener(new MenuViewPanelKeyListener());
		this.views.put(ViewPanelRegistryItems.MENU, menu);
		
		// register game view
		ViewPanelRegistryItem game = new ViewPanelRegistryItem(new GameViewPanel());
		this.views.put(ViewPanelRegistryItems.GAME, game);
		
		// register highscores view
		ViewPanelRegistryItem highscores = new ViewPanelRegistryItem(new HighscoresViewPanel());
		this.views.put(ViewPanelRegistryItems.HIGHSCORES, highscores);
	}
}
