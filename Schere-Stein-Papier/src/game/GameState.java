package game;

import java.util.Random;

public class GameState {
	
	private Gesture pickedGesturePlayer;
	private Gesture pickedGestureOpponent;
	private boolean roundCounted = false;
	
	private int roundsWon = 0;
	private int roundsLost = 0;
	private int roundsDraw = 0;
	
	public GameState() {
		this.resetGameState();
	}
	
	public int getRoundsPlayed() {
		return this.roundsWon + this.roundsLost + this.roundsDraw;
	}
	
	public int getRoundsWon() {
		return this.roundsWon;
	}
	
	public int getRoundsLost() {
		return this.roundsLost;
	}
	
	public int getRoundsDraw() {
		return this.roundsDraw;
	}
	
	public void resetGameState() {
		this.roundsWon = 0;
		this.roundsLost = 0;
		this.roundsDraw = 0;
		this.resetRoundState();
	}
	
	public void resetRoundState() {
		this.pickedGesturePlayer = null;
		this.pickedGestureOpponent = null;
		this.roundCounted = false;
	}
	
	public void setGesturePlayer(Gesture gesture) {
		if (this.pickedGesturePlayer != null) {
			return;
		}
		this.pickedGesturePlayer = gesture;
		System.out.println("Player picked " + this.pickedGesturePlayer);
	}
	
	public void setGestureOpponent() {
		if (this.pickedGestureOpponent != null) {
			return;
		}
		this.pickedGestureOpponent = this.getRandomGesture();
		System.out.println("Opponent picked " + this.pickedGestureOpponent);
	}
	
	public void countRound() {
		if (this.roundCounted) {
			return;
		}
		GameRoundResult result = this.getRoundResult();
		if (result == GameRoundResult.WON) {
			this.roundsWon++;
		} else if (result == GameRoundResult.LOST) {
			this.roundsLost++;
		} else {
			this.roundsDraw++;
		}
		this.roundCounted = true;
	}
	
	private GameRoundResult getRoundResult() {
		if (this.pickedGesturePlayer == Gesture.ROCK) {
			if (this.pickedGestureOpponent == Gesture.ROCK) {
				return GameRoundResult.DRAW;
			} else if (this.pickedGestureOpponent == Gesture.PAPER) {
				return GameRoundResult.LOST;
			} else {
				return GameRoundResult.WON;
			}
		} else if (this.pickedGesturePlayer == Gesture.PAPER) {
			if (this.pickedGestureOpponent == Gesture.ROCK) {
				return GameRoundResult.WON;
			} else if (this.pickedGestureOpponent == Gesture.PAPER) {
				return GameRoundResult.DRAW;
			} else {
				return GameRoundResult.LOST;
			}
		} else {
			if (this.pickedGestureOpponent == Gesture.ROCK) {
				return GameRoundResult.LOST;
			} else if (this.pickedGestureOpponent == Gesture.PAPER) {
				return GameRoundResult.WON;
			} else {
				return GameRoundResult.DRAW;
			}
		}
	}
	
	private Gesture getRandomGesture() {
		Gesture[] gestures = {Gesture.ROCK, Gesture.PAPER, Gesture.SCISSORS};
		int random = new Random().nextInt(gestures.length);
		System.out.println(random);
		return gestures[random];
	}
	
}
