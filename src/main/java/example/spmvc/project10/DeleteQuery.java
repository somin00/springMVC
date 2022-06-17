package example.spmvc.project10;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class DeleteQuery {
	private DataSource dataSource;
	
	public DeleteQuery(DataSource dataSource) {
		this.dataSource=dataSource;
	}
	
	public void deleteUser(String id) {
		String deleteSQL="delete from Member where id='"+id+"';"; 
		
		Connection conn=null;
		try {
			conn=dataSource.getConnection(); 
			Statement stmt=conn.createStatement(); 
			stmt.executeUpdate(deleteSQL);
			
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
