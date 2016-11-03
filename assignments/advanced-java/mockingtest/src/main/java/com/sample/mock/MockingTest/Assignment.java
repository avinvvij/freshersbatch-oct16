package com.sample.mock.MockingTest;

import java.sql.Connection;
import static org.mockito.Mockito.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import oracle.jdbc.driver.OracleDriver;

public class Assignment {
	
	
	public String selectQuery() throws ClassNotFoundException, SQLException{
		String str = "";
		OracleDriver dm = new OracleDriver();
		Connection con  = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("Select * from emp");
		rs.next();
		System.out.println(rs.getString("name"));
		str = rs.getString("name");
		return str;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException  {
		// TODO Auto-generated method stub
		//Assignment a = new Assignment();
		//ArrayList<String> aa =  a.selectQuery();
	}

}
