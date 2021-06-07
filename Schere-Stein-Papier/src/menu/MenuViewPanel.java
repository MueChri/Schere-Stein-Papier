package menu;

import java.awt.Font;

import javax.swing.JLabel;

import common.CenteredText;
import main.ViewPanel;

public class MenuViewPanel extends ViewPanel {
		
	public MenuViewPanel() {
		this.add(new StartButtonPanel());
		this.add(new HighscoresButtonPanel());
		this.add(new InfoButtonPanel());

		JLabel menuLabel = new CenteredText("MAIN MENU", 29, Font.BOLD);
		menuLabel.setBounds(4, 39, 373, 36);
		this.add(menuLabel);
	
		this.addKeyListener(new MenuViewPanelKeyListener());
	}
	
}