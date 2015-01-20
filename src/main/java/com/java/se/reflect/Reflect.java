package com.java.se.reflect;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Reflect
{
	public static void main(String[] args) throws IOException,
			ClassNotFoundException, InstantiationException,
			IllegalAccessException
	{
		InputStream is = Reflect.class.getClassLoader().getResourceAsStream(
				"Spring.properties");

		Properties propers = new Properties();

		propers.load(is);

		String name = propers.getProperty("1");

		Class<?> clazz = Class.forName(name);

		People p = (People) clazz.newInstance();

		p.setName("yudequan");

		System.out.println(p.getName());
		
		System.out.println();
		
//		clazz.getMethod("", String.class).invoke(obj, args)
	}
}

class People
{
	private String name;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

}