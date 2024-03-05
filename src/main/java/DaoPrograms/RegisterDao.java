package DaoPrograms;
import java.sql.*;
import beansprograms.CalcUserBean;
import databaseprograms.DbConnection;

public class RegisterDao {
	public int k=0;
	public int i=0;
	public int register(CalcUserBean cub) {
		try {
			Connection con = DbConnection.getCon();
			PreparedStatement ps=con.prepareStatement("insert into calc_user values(?,?,?,?,?)");
			ps.setString(1, cub.getuName());
			ps.setString(2, cub.getfName());
			ps.setString(3, cub.getlName());
			ps.setString(4, cub.geteId());
			ps.setString(5, cub.getpWord());
			k=ps.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
		return k;
		}// end of method
}
