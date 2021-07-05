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
	
	private final int itemsPerPage = 10;
	
	private final SimpleDateFormat dateFormatter;
	
	public HighscoresManager() {
		this.ora = OracleDsSingleton.getInstance();
		this.dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	}
	
	public void save(Highscore highscore) {
		try {
			Statement statement = this.ora.getConnection().createStatement();
  			String query = "INSERT into " + this.table + " (NAME, TIME, ROUNDS_WON, ROUNDS_LOST, ROUNDS_DRAW) VALUES (" +
  				"'" + highscore.name + "', " +
  				this.getDate(highscore.time) + ", " + 
  				highscore.roundsWon + ", " +
  				highscore.roundsLost + ", " +
  				highscore.roundsDraw +
			")";
		    ResultSet results = statement.executeQuery(query);
		    while (results.next()) {
		    	System.out.println(results.getRow());
		    }
            statement.close();
			results.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	public ArrayList<Highscore> get() {
		return this.get(0);
	}
	
	public ArrayList<Highscore> get(int page) {
	    ArrayList<Highscore> highscores = new ArrayList<Highscore>();
		try {
			Statement statement = this.ora.getConnection().createStatement();
			String query = "SELECT * FROM " + this.table + " " +
				"ORDER BY (ROUNDS_WON) DESC, (ROUNDS_DRAW) DESC, (TIME) ASC " +
				"OFFSET " + (this.itemsPerPage * page) + " ROUNDS FETCH NEXT " + page + " ROUNDS ONLY"; 
		    ResultSet results = statement.executeQuery(query);
			while(results.next()) {
				Highscore highscore = new Highscore(
					results.getString("NAME"),
					results.getDate("TIME"),
					results.getInt("ROUNDS_WON"),
					results.getInt("ROUNDS_LOST"),
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
		return (int) Math.ceil(this.count() / this.itemsPerPage); 
	}
	
	public int getRank(Highscore highscore) {
		int count = 0;
		try {
			Statement statement = this.ora.getConnection().createStatement();
			String query = "SELECT COUNT(*) FROM " + this.table + " WHERE " +
				"(ROUNDS_WON > " + highscore.roundsWon + ") OR " +
				"(ROUNDS_WON = " + highscore.roundsWon + " AND ROUNDS_DRAW < " + highscore.roundsDraw + ") OR " +
				"(ROUNDS_WON = " + highscore.roundsWon + " AND ROUNDS_DRAW = " + highscore.roundsDraw + " AND TIME < " + this.getDate(highscore.time) + ")"; 
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
	
	private String getDate(Date date) {
		return "TO_DATE('" + this.dateFormatter.format(date) + "', 'yyyy-mm-dd hh24:mi:ss')";
		
	}
	
}
