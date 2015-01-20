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
			// 1.��������
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2.�õ�����
			ct = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:orcl", "HONG", "123");

			// 3.����CallableStatement
			cs = ct.prepareCall("{call fenye(?,?,?,?,?,?)}");

			// 4.���ڣ���ֵ
			cs.setString(1, "emp");
			cs.setInt(2, 5);
			cs.setInt(3, 2);

			// ע���ܼ�¼��
			cs.registerOutParameter(4, oracle.jdbc.OracleTypes.INTEGER);
			// ע����ҳ��
			cs.registerOutParameter(5, oracle.jdbc.OracleTypes.INTEGER);
			// ע�᷵�صĽ����
			cs.registerOutParameter(6, oracle.jdbc.OracleTypes.CURSOR);

			// 5.ִ��
			cs.execute();

			// ȡ���ܼ�¼�� /����Ҫע�⣬getInt(4)��4�����ɸò�����λ�þ�����
			int rowNum = cs.getInt(4);

			int pageCount = cs.getInt(5);
			ResultSet rs = (ResultSet) cs.getObject(6);

			// ��ʾһ�£������Բ���
			System.out.println("rowNum=" + rowNum);
			System.out.println("��ҳ��=" + pageCount);

			while (rs.next())
			{
				System.out.println("��ţ�" + rs.getInt(1) + " ���֣�"
						+ rs.getString(2) + " ���ʣ�" + rs.getFloat(6));
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			// 6.�رո����򿪵���Դ
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
