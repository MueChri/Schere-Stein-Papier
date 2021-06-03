package controller;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import view.FrameView;
import view.MenuPanelView;
import view.WelcomePanelView;

public class EnterKeyListenerController implements KeyListener {
	WelcomePanelView welcomePanel;
	FrameView myFrame;
	MenuPanelView menuPanel;
	
															
	
	
	public void setWelcomePanel(WelcomePanelView welcomePanel) { //Verbindung mit WelcomePanel
		this.welcomePanel=welcomePanel;
	}
	
	public void setMenuPanel(MenuPanelView menuPanel) {
		this.menuPanel=menuPanel;
	}
	
	public void setFrame(FrameView myFrame) { //Verbindung mit Frame
		this.myFrame=myFrame;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {            //// finden wir noch was !!!!!!!!!!!!!!!!!!!!!
			
			
//			myFrame.getContentPane().removeAll();   
//			myFrame.getContentPane().add(menuPanel);
//			myFrame.add(menuPanel);
//			menuPanel.repaint();
			
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	

}
