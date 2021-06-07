package menu;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import main.ViewPanel;

public class MenuViewPanel extends ViewPanel {
		
	public MenuViewPanel() {
		super();
		this.add(new StartButtonPanel());
		this.add(new HighscoresButtonPanel());
		this.add(new InfoButtonPanel());
	}
	
}