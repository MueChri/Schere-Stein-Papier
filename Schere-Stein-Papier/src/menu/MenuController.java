package menu;

import java.awt.event.KeyEvent;

import main.MainController;
import main.abstracts.Controller;
import main.enums.Views;

public class MenuController extends Controller {
	
	public MenuController(Views id, MainController main) {
		super(id, main);
	}
	
	@Override
	public void keyPressed(KeyEvent event) {
		int key = event.getKeyCode();
		if (key == KeyEvent.VK_ESCAPE) {
			this.main.exit();
		}
	}
	
}

