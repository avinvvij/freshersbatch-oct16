package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CrudDatabase {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con  = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
		Statement st = con.createStatement();
		
		int updates = st.executeUpdate("Update dept set name = 'resarch and development' where id = 3");
		System.out.println("Number of Updates: "+updates);
		
		int delete = st.executeUpdate("Delete from dept where id = 4");
		System.out.println("Number of deletes: "+delete);
		
		ResultSet rs = st.executeQuery("Select * from dept");
		while(rs.next()){
			System.out.println(rs.getInt("id")+" "+rs.getString("name"));
		}
		
		
		rs = st.executeQuery("Select sysdate from dual");
		rs.next();
		System.out.println(rs.getString("sysdate"));
		
		
		rs.close();
		st.close();
		con.close();
	}

}
