package highscores;

import java.util.Date;

public class Highscore {

	public final String name;
	public final Date time;
	public final int roundsWon;
	public final int roundsDraw;

	public Highscore(String name, Date time, int roundsWon, int roundsDraw) {
		this.name = name;
		this.time = time;
		this.roundsWon = roundsWon;
		this.roundsDraw = roundsDraw;
	}
	
	public String toString() {
		return this.name + ", " + this.time + ", " + this.roundsWon + ", " + this.roundsDraw; 
	}
}
