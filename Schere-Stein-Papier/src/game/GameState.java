package game;

public class GameState {

	private GestureTypes pickedGesturePlayer;
	private GestureTypes pickedGestureComputer;
	
	public GameState() {
		this.resetRoundState();
	}
	
	public void resetRoundState() {
		this.pickedGesturePlayer = null;
		this.pickedGestureComputer = null;
	}
	
	public void pickGesturePlayer(GestureTypes type) {
		this.pickedGesturePlayer = type;
		System.out.println("Player picked " + this.pickedGesturePlayer);
	}
	
}
