package example.spmvc.project10;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javax.sql.DataSource;

import org.springframework.format.annotation.DateTimeFormat;

public class OrderQuery {
	@DateTimeFormat(pattern="yyyyMMdd")
	public LocalDate now; 
	
	private DataSource dataSource;
	
	public OrderQuery(DataSource dataSource) {
		this.dataSource=dataSource;
	}
	
	
	public void addOrderList(String name, String productName, LocalDate orderdate) {
		String parsingdate=orderdate.toString();
		String searchProductSQL="select * from product where productname='"+productName+"';";

		int price=0;
		
		Connection conn=null;

		try {
			conn=dataSource.getConnection(); 
			Statement stmt=conn.createStatement(); 
			ResultSet rs1=stmt.executeQuery(searchProductSQL);
			while(rs1.next()){
				price=rs1.getInt("price");
			}
			rs1.close();
		}catch(SQLException e) {
			throw new RuntimeException(e); 
		}finally {
			try {
				if(conn!=null)
				conn.close(); 
			}catch(SQLException e) {
				
			}
		}
		try {
			conn=dataSource.getConnection(); 
			Statement stmt=conn.createStatement(); 
			String addSQL="INSERT INTO ORDERLIST VALUES(null, '"+name+"', '"+productName+"',"+price+", '"+parsingdate+"');";
			stmt.executeUpdate(addSQL);
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
	
	
	public String showOrderList(String name) {
		String showListSQL="select * from orderlist where membername='"+name+"';"; 
		
		Connection conn=null;
		try {
			conn=dataSource.getConnection(); 
			try(Statement stmt=conn.createStatement(); 
					ResultSet rs=stmt.executeQuery(showListSQL)){
				String result; 
				result="ORDERID  \t\t MEMBERNAME \t\tPRODUCTNAME \t\t PRICE \t\t ORDERDATE <br>"; 
				while(rs.next()) {
					result=result+ rs.getInt("ORDERID")+"\t\t"+
					rs.getString("MEMBERNAME")+"\t\t"+rs.getString("PRODUCTNAME")+"\t\t"+rs.getInt("PRICE")+"\t\t"+rs.getString("ORDERDATE")+"\t\t"+"<br>"; 
				}
				return result; 
			}
		}
		catch(SQLException e) {
			throw new RuntimeException(e); 
		}
	}
	
	public String searchName(String membername, String productname) {
//		
		String showListSQL="select * from orderlist where membername='"+membername+"' AND productname='"+productname+"';";
		
		Connection conn=null;
		try {
			conn=dataSource.getConnection(); 
			try(Statement stmt=conn.createStatement(); 
					ResultSet rs=stmt.executeQuery(showListSQL)){
				String result; 
				result="ORDERID  \t\t MEMBERNAME \t\tPRODUCTNAME \t\t PRICE \t\t ORDERDATE <br>"; 
				while(rs.next()) {
					result=result+ rs.getInt("ORDERID")+"\t\t"+
					rs.getString("MEMBERNAME")+"\t\t"+rs.getString("PRODUCTNAME")+"\t\t"+rs.getInt("PRICE")+"\t\t"+rs.getString("ORDERDATE")+"\t\t"+"<br>"; 
				}
				return result; 
			}
		}
		catch(SQLException e) {
			throw new RuntimeException(e); 
		}
	}
	
	public String searchDate(String membername, LocalDate date) {
	
		String showListSQL="select * from orderlist where membername='"+membername+"' AND orderdate>=DATE_FORMAT('"+date+"', '%Y-%m-%d');";
		
		Connection conn=null;
		try {
			conn=dataSource.getConnection(); 
			try(Statement stmt=conn.createStatement(); 
					ResultSet rs=stmt.executeQuery(showListSQL)){
				String result; 
				result="ORDERID  \t\t MEMBERNAME \t\tPRODUCTNAME \t\t PRICE \t\t ORDERDATE <br>"; 
				while(rs.next()) {
					result=result+ rs.getInt("ORDERID")+"\t\t"+
					rs.getString("MEMBERNAME")+"\t\t"+rs.getString("PRODUCTNAME")+"\t\t"+rs.getInt("PRICE")+"\t\t"+rs.getString("ORDERDATE")+"\t\t"+"<br>"; 
				}
				return result; 
			}
		}
		catch(SQLException e) {
			throw new RuntimeException(e); 
		}
	}
	
}



