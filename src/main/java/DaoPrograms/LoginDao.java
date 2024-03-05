package DaoPrograms;
import java.sql.*;

import beansprograms.CalcUserBean;
import databaseprograms.DbConnection;
public class LoginDao {
	public CalcUserBean cub=null;
    public CalcUserBean login(String uN,String pW) {
    	try {
    		Connection con= DbConnection.getCon ();
    		PreparedStatement ps =con.prepareStatement("select * from calc_user where UNAME=? and pword=?");
    		ps.setString(1, uN);
    		ps.setString(2, pW);
    		ResultSet rs=ps.executeQuery();
    	    if(rs.next()) {
    	    	cub = new CalcUserBean();
    	    	cub.setuName(rs.getString(1));
    	    	cub.setfName(rs.getString(2));
    	    	cub.setlName(rs.getString(3));
    	    	cub.seteId(rs.getString(4));
    	    	cub.setpWord(rs.getString(5));
    	    	
    	    }
    	    }catch(Exception e) {e.printStackTrace();}
	    return cub;
    }
}
