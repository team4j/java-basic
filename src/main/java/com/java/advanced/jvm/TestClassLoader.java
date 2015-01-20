package com.java.advanced.jvm;

public class TestClassLoader
{

	public static int a = 3;

	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException
	{
//		System.out.println(TestClassLoader.class.getClassLoader());
//		System.out.println(String.class.getClassLoader());
//		System.out.println(TestClassLoader.a);
		
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		Class<?> clazz = cl.loadClass("com.java.advanced.jvm.People");
		
//		 = Class.forName("com.java.advanced.jvm.People")
		
		People p = (People)clazz.newInstance();
		
		System.out.println(p);
		
	}
}

class People
{
}