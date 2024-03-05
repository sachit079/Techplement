package DaoPrograms;
import java.sql.*;


import databaseprograms.DbConnection;
public class SaveHistoryDao {
	public int k=0;
	
	public int saveHistoryToDatabase(String expression, String result,String uname) {
		try {
			Connection con =DbConnection.getCon();
			PreparedStatement ps =con.prepareStatement("insert into history_details values(your_table_seq.NEXTVAL,?,?,?)");
			ps.setString(1, uname);
			ps.setString(2, expression);
			ps.setString(3, result);
			k=ps.executeUpdate();
		}catch(Exception e){e.printStackTrace();}
		return k;
	}
}
