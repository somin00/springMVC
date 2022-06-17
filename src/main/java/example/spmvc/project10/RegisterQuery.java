package example.spmvc.project10;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.validation.Errors;

public class RegisterQuery {
	
	private DataSource dataSource;
	
	public RegisterQuery(DataSource dataSource) {
		this.dataSource=dataSource;
	}
	
	public void insertMember(String id, String name, String email, String pwd, String addr, String phone, Errors errors) {
		String insertSQL="INSERT INTO MEMBER VALUES('"+id+"', '"+name+"', '"+email+"', '"+pwd+"', '"+addr+"', '"+phone+"');";
		Connection conn=null;
		try {
			conn=dataSource.getConnection(); 
			Statement stmt=conn.createStatement();
			stmt.execute(insertSQL);
		
			
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
	
	public int duplicate(String field, String args) {
		int count=0; 
		String searchSQL="SELECT count(*) from MEMBER WHERE "+field+"='"+args+"';";
		Connection conn=null;
		try {
			conn=dataSource.getConnection(); 
			Statement stmt=conn.createStatement(); 
			ResultSet rs=stmt.executeQuery(searchSQL);
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
