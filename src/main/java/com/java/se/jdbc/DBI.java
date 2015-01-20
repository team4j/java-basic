package com.java.se.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBI
{
	private static DBI dbi;

	private DBI()
	{
	}

	public static DBI getInstance()
	{
		if (null == dbi)
		{
			dbi = new DBI();
		}
		return dbi;
	}

	public Connection getConnection()
	{
		Connection conn = null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "HONG", "123");
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

		return conn;
	}
}
