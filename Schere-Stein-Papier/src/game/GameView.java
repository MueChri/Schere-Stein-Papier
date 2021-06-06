package game;

import main.MainController;
import main.abstracts.View;
import main.enums.Views;

public class GameView extends View {

	public GameView(Views id, MainController main) {
		super(id, main, new GameController(id, main));
	}
}
