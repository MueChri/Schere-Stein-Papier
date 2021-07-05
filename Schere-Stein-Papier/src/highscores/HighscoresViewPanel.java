package highscores;

import java.util.Date;

import common.HomeButtonPanel;
import main.ViewPanel;

public class HighscoresViewPanel extends ViewPanel {

	private HighscoresManager manager;
	
	public HighscoresViewPanel() {
		this.add(new HomeButtonPanel());
		this.manager = new HighscoresManager();
		System.out.println(this.manager.count());
		System.out.println(this.manager.getRank(new Highscore("Foo", new Date(), 5, 4, 3)));
//		this.manager.save(new Highscore("Foo", new Date(), 5, 4, 3));
	}
	
}
