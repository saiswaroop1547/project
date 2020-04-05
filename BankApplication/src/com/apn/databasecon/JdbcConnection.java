package com.apn.databasecon;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;


public class JdbcConnection {
	Connection con = null;
	static
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (Exception  e)
		{
			System.out.println(e);
		}
	}
	
	public Connection getJdbcConnection()
	{
		
		try
		{
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","root");
			
			
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return con;
	}
	public void closeJdbcConnection() throws SQLException
	{
		con.close();
	}
}
