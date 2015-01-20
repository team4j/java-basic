package com.java.se.innerclass;

public class Test
{
	private int j = 1;

	public static void main(String[] args)
	{
		new Test().fun0();
	}

	public void fun0()
	{
		final int i = 0;
		fun1(new Log()
		{
			@Override
			public void callBack()
			{
				System.out.println(i + j);
			}

		});

	}

	public void fun1(Log log)
	{
		log.callBack();
	}
}

interface Log
{
	void callBack();
}
