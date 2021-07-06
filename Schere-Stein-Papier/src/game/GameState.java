package game;

import java.util.Random;

public class GameState {
	
	private Gesture pickedGesturePlayer = null;
	private Gesture pickedGestureOpponent = null;
	private int currentRound = 0;
	private boolean roundCounted = false;
	private boolean gameClosed = false;
	private GameRoundResult lastResult = null;
	
	private int roundsWon = 0;
	private int roundsLost = 0;
	private int roundsDraw = 0;
	
	public final int maxRounds = 10;
	
	public GameState() {
		this.resetGameState();
	}
	
	public int getRoundsCounted() {
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
		this.gameClosed = false;
		this.roundsWon = 0;
		this.roundsLost = 0;
		this.roundsDraw = 0;
		this.currentRound = 0;
		this.nextRound();
	}
	
	public void nextRound() {
		if (this.gameClosed) {
			return;
		}
		this.pickedGesturePlayer = null;
		this.pickedGestureOpponent = null;
		this.roundCounted = false;
		this.currentRound = this.currentRound < this.maxRounds ? this.currentRound + 1 : this.maxRounds;
	}
	
	public void closeGame() {
		this.gameClosed = true;
	}
	
	public boolean isGameClosed() {
		return this.gameClosed;
	}
	
	public int getCurrentRound() {
		return this.currentRound;
	}
	
	public void setGesturePlayer(Gesture gesture) {
		if (this.pickedGesturePlayer != null) {
			return;
		}
		this.pickedGesturePlayer = gesture;
	}
	
	public Gesture getGesturePlayer() {
		return this.pickedGesturePlayer;
	}
	
	public void setGestureOpponent() {
		if (this.pickedGestureOpponent != null) {
			return;
		}
		this.pickedGestureOpponent = this.getRandomGesture();
	}
	
	public Gesture getGestureOpponent() {
		return this.pickedGestureOpponent;
	}
	
	public void countRound() {
		if (this.roundCounted || this.hasMaxRoundsPlayed()) {
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
		this.lastResult = result;
		this.roundCounted = true;
	}
	
	public GameRoundResult getLastResult() {
		return this.lastResult;
	}

	private boolean hasMaxRoundsPlayed() {
		return this.getRoundsCounted() >= this.maxRounds;
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
		} else { // scissors
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
		return gestures[random];
	}
	
}
