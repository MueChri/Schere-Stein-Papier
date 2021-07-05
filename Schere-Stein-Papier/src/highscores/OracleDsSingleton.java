package highscores;

import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;

public class OracleDsSingleton {	
	private static OracleDsSingleton dss = null;
	private static OracleDataSource ds = null;
	private OracleDsSingleton(){
		try {
			ds = new OracleDataSource();
			ds.setDataSourceName("HWROracleDataSource");
			ds.setURL("jdbc:oracle:thin:@//10.50.205.21:1521/dbk.hwr-berlin.de");
			ds.setUser("oop2_ss21_g1_p4");
			ds.setPassword("Lx9_w");
		} catch (SQLException e) {}
	}
	
	public static OracleDsSingleton getInstance() {
		if (dss == null) dss = new OracleDsSingleton();
		return dss;
	}

	public Connection getConnection() throws SQLException{
		Connection con = null;
		con = ds.getConnection();
		return con;
	}

}

