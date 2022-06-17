package example.spmvc.project10;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class ProductQuery {
	private DataSource dataSource;
	
	public ProductQuery(DataSource dataSource) {
		this.dataSource=dataSource;
	}
	
	public String showProductList() {
		String showSQL="select * from PRODUCT";
		Connection conn=null;
		try {
			conn=dataSource.getConnection(); 
			try(Statement stmt=conn.createStatement(); 
					ResultSet rs=stmt.executeQuery(showSQL)){
				String result; 
				result="PRODUCT ID\t\t PRODUCT NAME\t\tPRICE\t\t<br>"; 
				while(rs.next()) {
					result=result+ rs.getInt("PRODUCTID")+"\t\t"+
					rs.getString("PRODUCTNAME")+"\t\t"+rs.getInt("PRICE")+"\t\t"+"<br>"; 
				}
				return result; 
			}
		}
		catch(SQLException e) {
			throw new RuntimeException(e); 
		}

	}
	
	public String searchProduct(String name) {
		String searchSQL="select * from product where productname='"+name+"';";
		Connection conn=null; 
		
		try {
			conn=dataSource.getConnection();
			try(Statement stmt=conn.createStatement(); 
					ResultSet rs=stmt.executeQuery(searchSQL)){
				String result; 
				result="PRODUCT ID\t\t PRODUCT NAME\t\tPRICE\t\t <br>"; 
				while(rs.next()) {
					result=result+ rs.getInt("PRODUCTID")+"\t\t"+
					rs.getString("PRODUCTNAME")+"\t\t"+rs.getInt("PRICE")+"\t\t"+"<br>"; 
				}
				return result; 
			}
		}catch(SQLException e) {
			throw new RuntimeException(e); 
		}
	}
	public String printInfo() {
		String searchSQL="select * from product";
		Connection conn=null; 
		
		try {
			conn=dataSource.getConnection();
			try(Statement stmt=conn.createStatement(); 
					ResultSet rs=stmt.executeQuery(searchSQL)){
				String result; 
				result="PRODUCT NAME: \t\t PRODUCT INFO\t\t <br>"; 
				while(rs.next()) {
					result=result+ rs.getString("productname")+": \t\t"+rs.getString("INFO")+"\t\t"+"<br>"; 
				}
				return result; 
			}
		}catch(SQLException e) {
			throw new RuntimeException(e); 
		}
	}
	
	
	public String productDetail(String name) {
		String detailSQL="select * from product where productname='"+name+"';";
		Connection conn=null; 
		
		try {
			conn=dataSource.getConnection();
			try(Statement stmt=conn.createStatement(); 
					ResultSet rs=stmt.executeQuery(detailSQL)){
				String result; 
				result="PRODUCT NAME: \t\tINFO <br>"; 
				while(rs.next()) {
					result=result+ rs.getString("PRODUCTNAME")+": \t\t"+rs.getString("INFO")+"\t\t"+"<br>"; 
				}
				return result; 
			}
		}catch(SQLException e) {
			throw new RuntimeException(e); 
		}
	}
}
