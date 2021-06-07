package main;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import common.CloseButtonPanel;

public abstract class ViewPanel extends JPanel {

	public ViewPanel() {
		// this enables absolute positioning of sub-layers
		this.setLayout(null);
		this.setPreferredSize(new Dimension(370, 500));
		this.add(new CloseButtonPanel());
	}
	
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		graphics.drawImage(new ImageIcon("images/backgroundProject.png").getImage(), 0, 0, this);
	}

	
}
