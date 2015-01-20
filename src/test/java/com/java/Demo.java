package com.java;

public class Demo
{
	/**
	 * 通过两种方式创建对象，以做对比。
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException
	{
		// 我们认为这种方方式，Demo类和Basic类是耦合的，
		// 编译Demo类时，Basic类必须存在,拓展性不强。
		Basic basic0 = new Basic();

		
		// 很明显这种方式，在编译Demo类时，并不需要
		// Basic类的存在，只要在运行Demo类时，存在即可，
		// 所以我们认为Demo类和Basic是松耦合的，
		// 为后期的拓展提供了空间，好处显而易见。这么说，如果没有
		// 反射机制，就没有struts、spring、hibernate等等这些web框架。
		Class clazz = Class.forName("com.java.Basic");

		Basic basic1 = (Basic) clazz.newInstance();
	}
}

class Basic
{
}