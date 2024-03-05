package databaseprograms;

import java.sql.*;
import static databaseprograms.DbInfo.*;

public class DbConnection {
	private static Connection con=null;
	private DbConnection() {}

	static {
		try {
			  Class.forName("oracle.jdbc.driver.OracleDriver");
			  con=DriverManager.getConnection(dbUrl,uNmae,pWord);
		}catch(Exception e) {e.printStackTrace();}
	}// end of block


	public static Connection getCon() {
		return con;
	}

}
