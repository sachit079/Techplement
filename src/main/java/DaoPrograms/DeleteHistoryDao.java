package DaoPrograms;
import java.sql.*;

import databaseprograms.DbConnection;
public class DeleteHistoryDao {
  public int k=0;
  public int delete(int slno) {
	  try {
		  Connection con = DbConnection.getCon();
		  PreparedStatement ps = con.prepareStatement(" delete from history_details where id =?");
		  ps.setInt(1, slno);
		  k=ps.executeUpdate();
	  }catch(Exception e) {e.printStackTrace();}
	return k;
	  
  }
}
