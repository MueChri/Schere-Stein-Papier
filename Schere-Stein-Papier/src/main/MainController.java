package main;

import java.util.HashMap;
import java.util.Map;

import game.GameView;
import highscores.HighscoresView;
import main.abstracts.View;
import main.enums.Views;
import menu.MenuView;
import welcome.WelcomeView;

public class MainController {

	private View currentView;
	private MainView frame;
	
	private final Map<Views, View> views = new HashMap<Views, View>();
	
	public final Views initialView = Views.WELCOME;
	
	public MainController(MainView frame) {
		this.frame = frame;
		this.registerViews();
	}
	
	public void setInitialView() {
		this.getViewById(this.initialView).controller.setAsCurrentView();
	}
	
	public View getViewById(Views id) {
		return this.views.get(id);
	}
	
	public void setViewById(Views id) {
		// System.out.println("Setting view id: " + id);
		this.setView(this.getViewById(id));
	}
	
	private void setView(View view) {
		if (this.currentView != null) {
			this.frame.removeKeyListener(this.currentView.controller);
		}
		this.currentView = view;
		this.frame.addKeyListener(this.currentView.controller);
		this.paintView();
	}
	
	private void paintView() {
		this.frame.getContentPane().removeAll();   
		this.frame.getContentPane().add(this.currentView);
		this.frame.revalidate();
		this.frame.pack();
		// this.frame.repaint();
	}

	private void registerViews() {
		this.views.put(Views.WELCOME, new WelcomeView(Views.WELCOME, this));
		this.views.put(Views.MENU, new MenuView(Views.MENU, this));
		this.views.put(Views.GAME, new GameView(Views.GAME, this));
		this.views.put(Views.HIGHSCORES, new HighscoresView(Views.HIGHSCORES, this));
	}
}
