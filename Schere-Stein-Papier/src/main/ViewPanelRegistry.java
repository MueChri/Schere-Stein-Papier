package main;

import game.GameViewPanel;
import highscores.HighscoresViewPanel;
import menu.MenuViewPanel;
import welcome.WelcomeViewPanel;

public class ViewPanelRegistry {

	private final MainFrame mainFrame;
	
	private ViewPanel currentView = null;
	
	public ViewPanelRegistry(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	
	public ViewPanel getViewById(ViewPanelRegistryItems id) {
		switch (id) {
			case WELCOME:
				return new WelcomeViewPanel();
			case GAME:
				return new GameViewPanel();
			case HIGHSCORES:
				return new HighscoresViewPanel();	
			case MENU:
			default:
				return new MenuViewPanel();
		}
	}
	
	public void setCurrentView(ViewPanelRegistryItems id) {
		this.currentView = this.getViewById(id);
		this.paintCurrentView();
	}
	
	public ViewPanel getCurrentView() {
		return this.currentView;
	}
	
	private void paintCurrentView() {
		this.mainFrame.getContentPane().removeAll();   
		this.mainFrame.getContentPane().add(this.currentView);
		this.mainFrame.revalidate();
		this.currentView.repaint();
		this.mainFrame.pack();
	}
}
