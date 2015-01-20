package com.java.se.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test
{
	public static final Connection conn;

	static
	{
		conn = DBI.getInstance().getConnection();
	}

	public static void main(String[] args) throws SQLException
	{
		// callProcedure();
		queryUser();
	}

	public static void callProcedure() throws SQLException
	{
		CallableStatement call = conn
				.prepareCall("{call HONG.PROCEDURE_ADD_USER(?, ?)}");
		// call.setInt(1, 4);
		call.setString(1, "5");
		call.setString(2, "zhangwenjing");
		call.execute();

	}

	public static void queryUser() throws SQLException
	{
		CallableStatement call = conn
				.prepareCall("{call P_QUERY_USER_NAME(?)}");
		call.registerOutParameter(1, oracle.jdbc.OracleTypes.VARCHAR);
		call.execute();
		// Object obj = call.getObject(1);
		Object obj = call.getString(1);
		System.out.println(obj.toString());
	}

}
