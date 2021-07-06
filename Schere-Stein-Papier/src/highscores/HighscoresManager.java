package highscores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class HighscoresManager {
	
	private final OracleDsSingleton ora;

	private final String table = "ROCK_PAPER_SCISSORS_HIGHSCORES";
	
	public final int itemsPerPage = 10;
	
	public HighscoresManager() {
		this.ora = OracleDsSingleton.getInstance();
	}
	
	public void save(Highscore highscore) {
		try {
			Statement statement = this.ora.getConnection().createStatement();
  			String query = "INSERT into " + this.table + " (NAME, TIME, ROUNDS_WON, ROUNDS_DRAW) VALUES (" +
  				"'" + highscore.name + "', " +
  				this.getDate(highscore.time) + ", " + 
  				highscore.roundsWon + ", " +
  				highscore.roundsDraw +
			")";
		    ResultSet results = statement.executeQuery(query);
            statement.close();
			results.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	public ArrayList<Highscore> get() {
		return this.get(1);
	}
	
	public ArrayList<Highscore> get(int page) {
	    ArrayList<Highscore> highscores = new ArrayList<Highscore>();
		try {
			Statement statement = this.ora.getConnection().createStatement();
			String query = "SELECT * FROM " + this.table + " " +
				"ORDER BY (ROUNDS_WON) DESC, (ROUNDS_DRAW) DESC, (TIME) ASC " +
				"OFFSET " + (this.itemsPerPage * (page - 1)) + " ROWS FETCH NEXT " + this.itemsPerPage + " ROWS ONLY"; 
		    ResultSet results = statement.executeQuery(query);
			while(results.next()) {
				Highscore highscore = new Highscore(
					results.getString("NAME"),
					results.getDate("TIME"),
					results.getInt("ROUNDS_WON"),
					results.getInt("ROUNDS_DRAW")
				);
				highscores.add(highscore);
			}
            statement.close();
			results.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
		return highscores;
	}
	
	public int count() {
		int count = 0;
		try {
			Statement statement = this.ora.getConnection().createStatement();
			String query = "SELECT COUNT(*) FROM " + this.table; 
		    ResultSet results = statement.executeQuery(query);
			while(results.next()) {
				count = results.getInt(1);
			}
            statement.close();
			results.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
		return count;
	}
	
	public int numberOfPages() {
		return (int) Math.ceil((double) this.count() / this.itemsPerPage); 
	}
	
	public int getRank(Highscore highscore) {
		int count = 0;
		try {
			Statement statement = this.ora.getConnection().createStatement();
			String query = "SELECT COUNT(*) FROM " + this.table + " WHERE " +
				"(ROUNDS_WON > " + highscore.roundsWon + ") OR " +
				"(ROUNDS_WON = " + highscore.roundsWon + " AND ROUNDS_DRAW > " + highscore.roundsDraw + ") OR " +
				"(ROUNDS_WON = " + highscore.roundsWon + " AND ROUNDS_DRAW = " + highscore.roundsDraw + " AND TIME < " + this.getDate(highscore.time) + ")"; 
		    ResultSet results = statement.executeQuery(query);
			while(results.next()) {
				count = results.getInt(1) + 1;
			}
            statement.close();
			results.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
		return count;		
	}
	
	private String getDate(Date date) {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return "TO_TIMESTAMP('" + dateFormatter.format(date) + "', 'yyyy-mm-dd hh24:mi:ss')";
	}
	
}
