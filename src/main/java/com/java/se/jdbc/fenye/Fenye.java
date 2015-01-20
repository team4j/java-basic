package com.java.se.jdbc.fenye;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Fenye
{
	public static void main(String[] args)
	{
		Connection ct = null;
		CallableStatement cs = null;
		try
		{
			// 1.加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2.得到连接
			ct = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:orcl", "HONG", "123");

			// 3.创建CallableStatement
			cs = ct.prepareCall("{call fenye(?,?,?,?,?,?)}");

			// 4.给第？赋值
			cs.setString(1, "emp");
			cs.setInt(2, 5);
			cs.setInt(3, 2);

			// 注册总记录数
			cs.registerOutParameter(4, oracle.jdbc.OracleTypes.INTEGER);
			// 注册总页数
			cs.registerOutParameter(5, oracle.jdbc.OracleTypes.INTEGER);
			// 注册返回的结果集
			cs.registerOutParameter(6, oracle.jdbc.OracleTypes.CURSOR);

			// 5.执行
			cs.execute();

			// 取出总记录数 /这里要注意，getInt(4)中4，是由该参数的位置决定的
			int rowNum = cs.getInt(4);

			int pageCount = cs.getInt(5);
			ResultSet rs = (ResultSet) cs.getObject(6);

			// 显示一下，看看对不对
			System.out.println("rowNum=" + rowNum);
			System.out.println("总页数=" + pageCount);

			while (rs.next())
			{
				System.out.println("编号：" + rs.getInt(1) + " 名字："
						+ rs.getString(2) + " 工资：" + rs.getFloat(6));
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			// 6.关闭各个打开的资源
			try
			{
				if (null != cs)
				{
					cs.close();
				}
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
			try
			{
				if (null != ct)
				{
					ct.close();
				}

			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}

}
