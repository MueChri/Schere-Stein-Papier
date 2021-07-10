package main;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import common.CloseButtonPanel;

public abstract class ViewPanel extends JPanel {

	public ViewPanel() {
		this.setLayout(null); // this enables absolute positioning of sub-layers
		this.setPreferredSize(new Dimension(370, 500));
		this.add(new CloseButtonPanel());
		this.setFocusable(true);		
	}
	
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		this.requestFocusInWindow(); // this allows to catch key events in the panel
		graphics.drawImage(new ImageIcon(getClass().getResource("/backgroundProject.png")).getImage(), 0, 0, this);
	}

	
}
