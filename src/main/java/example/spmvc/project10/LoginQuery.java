package example.spmvc.project10;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class LoginQuery {

private DataSource dataSource;
	
	public LoginQuery(DataSource dataSource) {
		this.dataSource=dataSource;
	}
	
	public int checkLogin(String field1, String id, String field2,  String pwd) {
		String compareSQL="select count(*) from Member WHERE "+field1+"='"+id+"' AND "+field2+"='"+pwd+"'";
		Connection conn=null;
		try {
			conn=dataSource.getConnection(); 
			Statement stmt=conn.createStatement(); 
			ResultSet rs=stmt.executeQuery(compareSQL);
			rs.next(); 
			return rs.getInt(1); 
		}catch(SQLException e) {
			throw new RuntimeException(e); 
		}finally {
			try {
				if(conn!=null)
				conn.close(); 
			}catch(SQLException e) {
				
			}
		}
	}
}
