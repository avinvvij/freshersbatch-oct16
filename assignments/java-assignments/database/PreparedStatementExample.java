package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PreparedStatementExample {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con  = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
		//Statement st = con.createStatement();
		
		PreparedStatement ps = con.prepareStatement("Update dept set name = ? where id = ?");
		ps.setString(1, "resarch");
		ps.setInt(2, 3);
		int updates = ps.executeUpdate();
		System.out.println("Number of Updates: "+updates);
		
		PreparedStatement ps_delete = con.prepareStatement("Delete from dept where id = ?");
		ps_delete.setInt(1, 5);
		
		int delete = ps_delete.executeUpdate();
		System.out.println("Number of deletes: "+delete);
		
		PreparedStatement ps_select = con.prepareStatement("Select * from dept");
		ResultSet rs =  ps_select.executeQuery();
		while(rs.next()){
			System.out.println(rs.getInt("id")+" "+rs.getString("name"));
		}
		
		
		
		
		rs.close();
		ps.close();
		ps_delete.close();
		ps_select.close();
		con.close();
	}
	
}
