package com.java.advanced.jvm;

public class MyClassLoader extends ClassLoader
{
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException
	{
		return Class.forName(name);
	}
}
