package example.spmvc.project10;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class UserInfoQuery {

	private DataSource dataSource;
	
	public UserInfoQuery(DataSource dataSource) {
		this.dataSource=dataSource;
	}
	
	public UserInfo setUserInfo(String id, UserInfo userInfo) {
		String matchSQL="select * from Member where id='"+id+"'; ";
		Connection conn=null;
		try {
			conn=dataSource.getConnection(); 
			Statement stmt=conn.createStatement(); 
			ResultSet rs=stmt.executeQuery(matchSQL);
			while(rs.next()) {
				userInfo.setEmail(rs.getString("email"));
				userInfo.setAddr(rs.getString("addr"));
				userInfo.setPhone(rs.getString("phone"));
			}
			return userInfo; 
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
	
	public void updateUserInfo(String email, String addr, String phone) {
		String updateEmail="update Member SET email='"+email+"';";
		String updateAddr="update Member SET addr='"+addr+"';";
		String updatePhone="update Member SET phone='"+phone+"';";
		Connection conn=null;
		try {
			conn=dataSource.getConnection(); 
			Statement stmt=conn.createStatement(); 
			if(!email.isEmpty()) {
				int rs=stmt.executeUpdate(updateEmail);
			}
			if(!addr.isEmpty()) {
				int rs=stmt.executeUpdate(updateAddr);
			}
			if(!phone.isEmpty()) {
				int rs=stmt.executeUpdate(updatePhone);
			}
			
			
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
