package game;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import common.CenteredText;

public class GameStepOpponentGestureAnimationPanel extends JPanel {

	private int minPosY = 70;
	private int maxPosY = 250;
	private int posY = minPosY;
	private boolean animateBackwards = false;
	private Timer timer;
	
	public GameStepOpponentGestureAnimationPanel() {
		this.setLayout(null);
		this.setBounds(0, 30, 370, 400);
		this.setOpaque(false);

		JLabel opponentPicking = new CenteredText("OPPONENT IS PICKING A GESTURE...", 18, Font.BOLD);
		opponentPicking.setBounds(0, 20, 370, 20);
		this.add(opponentPicking);

		timer = new Timer(10, new TimerListener());
		timer.start();
		
		TimerTask task = new TimerTask() {
	        public void run() {
	        	GameViewPanel gameView = (GameViewPanel) getParent();
	        	gameView.gameState.setGestureOpponent();
	        	gameView.showRoundResult();
	            
	        }
	    };
	    java.util.Timer timer = new java.util.Timer();
	    long delay = 2000L;
	    timer.schedule(task, delay);

		
	}
	
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Image image = new ImageIcon(getClass().getResource("/Fist.png")).getImage();
		graphics.drawImage(image, 87, posY, 176, 150, this);
	}

	public class TimerListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(!animateBackwards && posY < maxPosY) {
				posY += 10;
			} else if (animateBackwards && posY > minPosY) {
				posY -= 10;
			} else {
				animateBackwards = !animateBackwards;
			}
			repaint();
		}
	}
	
}
