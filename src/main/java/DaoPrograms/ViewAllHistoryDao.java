package DaoPrograms;
import java.util.*;

import beansprograms.CalcBean;
import databaseprograms.DbConnection;

import java.sql.*;

public class ViewAllHistoryDao {
	public ArrayList<CalcBean> al =new ArrayList<CalcBean>();
	
	public ArrayList<CalcBean> retrive( String uname){
		try {
			Connection con = DbConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from history_details where UNAME = ?");
			ps.setString(1, uname);
		 ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			CalcBean cb =new CalcBean();
			cb.setSlno(rs.getInt(1));
			cb.setUname(rs.getString(2));
			cb.setExpression(rs.getString(3));
			cb.setResult(rs.getString(4));
			al.add(cb);
		}
	}catch(Exception e) {e.printStackTrace();}
		return al;
	}
}
