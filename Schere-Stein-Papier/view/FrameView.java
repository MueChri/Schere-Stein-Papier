package view;



import javax.swing.JFrame;

public class FrameView extends JFrame {
	
	public FrameView() {
		super("Schere, Stein, Papier");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(new WelcomePanelView());
		//getContentPane().add(new MenuPanelView()); ///
		pack();
		setVisible(true);
		
		
	}
	
	
	
	
	

}
