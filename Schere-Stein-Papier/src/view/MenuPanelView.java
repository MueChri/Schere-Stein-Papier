package view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MenuPanelView extends JPanel {
	
	
	public MenuPanelView() {
		this.setPreferredSize(new Dimension(370,500));
	}
	
	
	
	protected void paintComponent (Graphics g ) {
		super.paintComponent(g);
	
		g.drawImage(new ImageIcon("..\\src\\images\\backgroundProject.png").getImage(),0,0,this);
		g.drawImage(new ImageIcon("..\\src\\images\\HighscoreShadow.png").getImage(),90,127,182,115,this);
		g.drawImage(new ImageIcon("..\\src\\images\\StartNowButtonShadow.png").getImage(),48,228,270,272,this);
		g.drawImage(new ImageIcon("..\\src\\images\\closeButton.png").getImage(),340,0,28,28,this);
		g.drawImage(new ImageIcon("..\\src\\images\\infoButton.png").getImage(),310,0,27,27,this);

}
}