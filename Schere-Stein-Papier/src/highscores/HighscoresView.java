package highscores;

import main.MainController;
import main.abstracts.View;
import main.enums.Views;

public class HighscoresView extends View {

	public HighscoresView(Views id, MainController main) {
		super(id, main, new HighscoresController(id, main));
	}
	
}
