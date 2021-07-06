import java.sql.Connection;
import java.sql.SQLException;

import highscores.OracleDsSingleton;
import main.MainFrame;

public class SchereSteinPapier {

	public static void main(String[] args) throws SQLException {

		Connection dbConnection = OracleDsSingleton.getInstance().getConnection();
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				try {
					dbConnection.close();
				} catch (SQLException error) {
					error.printStackTrace();
				}
		    }
		});
		
		// just start the main view...
		new MainFrame();

	}

}
