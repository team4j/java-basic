package com.java;


public class TestClass
{
	public static void main(String[] args)
	{
		Test1 t = new Test1(11);
		change(t);
		System.out.println(t.a);
	}
	
	public static void change(Test1 t)
	{
		t = new Test1(22);
	}
}

class Test1
{
	int a;
	
	Test1(int a)
	{
		this.a = a;
	}
}