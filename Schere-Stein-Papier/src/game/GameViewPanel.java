package game;

import common.HomeButtonPanel;
import main.ViewPanel;

public class GameViewPanel extends ViewPanel {
	
	public final GameState gameState = new GameState();

	public GameViewPanel() {
		
		this.add(new HomeButtonPanel());
		this.addKeyListener(new GameStepGestureSelectionPanelKeyListener());
		
		this.add(new GameStepGestureSelectionPanel());

	}
	
}
