package welcome;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.MainController;
import main.abstracts.Controller;
import main.enums.Views;

public class WelcomeController extends Controller implements KeyListener {
	
	public WelcomeController(Views id, MainController main) {
		super(id, main);
	}
	
	@Override
	public void keyPressed(KeyEvent event) {
		int key = event.getKeyCode();
		if (key == KeyEvent.VK_ENTER) {
			this.main.setViewById(Views.MENU);
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
	
	
}
