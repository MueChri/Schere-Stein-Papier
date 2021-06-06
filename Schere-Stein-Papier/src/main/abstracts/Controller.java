package main.abstracts;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.MainController;
import main.enums.Views;

public abstract class Controller implements KeyListener {

	public Views id;
	
	protected MainController main;

	public Controller(Views id, MainController main) {
		this.main = main;
		this.id = id;
	}

	public void setAsCurrentView() {
		this.main.setViewById(this.id);
	}
	
	@Override
	public void keyPressed(KeyEvent event) {
	}
	
	@Override
	public void keyTyped(KeyEvent event) {
	}

	@Override
	public void keyReleased(KeyEvent event) {
	}	
	
}
