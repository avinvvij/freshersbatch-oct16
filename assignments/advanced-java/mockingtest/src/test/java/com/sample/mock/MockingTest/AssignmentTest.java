package com.sample.mock.MockingTest;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


@RunWith(PowerMockRunner.class)
@PrepareForTest(Assignment.class)
public class AssignmentTest {

	
	
	@Mock
	public static Connection con;
	
	@Mock
	public static Statement stmt;
	
	@Mock
	public static ResultSet rs;
	
	
	@BeforeClass
	public static void setUp() throws SQLException{
		con = mock(Connection.class);
		stmt = mock(Statement.class);
		rs = mock(ResultSet.class);
		PowerMockito.mockStatic(DriverManager.class);
		when(DriverManager.getConnection(anyString(),anyString(),anyString())).thenReturn(con);
		when(con.createStatement()).thenReturn(stmt);
		when(stmt.executeQuery(anyString())).thenReturn(rs);
		when(rs.next()).thenReturn(true);
		when(rs.getString("name")).thenReturn("Hello");
	}
	
	@Test
	public void selectQueryTest() throws ClassNotFoundException, SQLException{
		Assignment a = new Assignment();
		Assert.assertEquals("Hello",a.selectQuery());
	}
	
}
