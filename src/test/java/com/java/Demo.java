package com.java;

public class Demo
{
	/**
	 * ͨ�����ַ�ʽ�������������Աȡ�
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException
	{
		// ������Ϊ���ַ���ʽ��Demo���Basic������ϵģ�
		// ����Demo��ʱ��Basic��������,��չ�Բ�ǿ��
		Basic basic0 = new Basic();

		
		// ���������ַ�ʽ���ڱ���Demo��ʱ��������Ҫ
		// Basic��Ĵ��ڣ�ֻҪ������Demo��ʱ�����ڼ��ɣ�
		// ����������ΪDemo���Basic������ϵģ�
		// Ϊ���ڵ���չ�ṩ�˿ռ䣬�ô��Զ��׼�����ô˵�����û��
		// ������ƣ���û��struts��spring��hibernate�ȵ���Щweb��ܡ�
		Class clazz = Class.forName("com.java.Basic");

		Basic basic1 = (Basic) clazz.newInstance();
	}
}

class Basic
{
}