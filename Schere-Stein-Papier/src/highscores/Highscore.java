package highscores;

import java.util.Date;

public class Highscore {

	public final String name;
	public final Date time;
	public final int roundsWon;
	public final int roundsLost;
	public final int roundsDraw;

	public Highscore(String name, Date time, int roundsWon, int roundsLost, int roundsDraw) {
		this.name = name;
		this.time = time;
		this.roundsWon = roundsWon;
		this.roundsLost = roundsLost;
		this.roundsDraw = roundsDraw;
	}
	
	public String toString() {
		return this.name + ", " + this.time + ", " + this.roundsWon + ", " + this.roundsLost + ", " + this.roundsDraw; 
	}
}
