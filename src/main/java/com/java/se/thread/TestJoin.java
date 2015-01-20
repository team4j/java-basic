package com.java.se.thread;

public class TestJoin
{
	public static void main(String[] args)
	{
		Caculator0 c0 = new Caculator0();
		Caculator1 c1 = new Caculator1();
		Caculator2 c2 = new Caculator2();
		
		Thread t0 = new Thread(c0);
		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c2);
		
		c2.setThread(t1);
		c1.setThread(t0);
		
		t0.start();
		t1.start();
		t2.start();
	}
}

class Caculator0 implements Runnable
{
	private Thread thread;

	public void setThread(Thread thread)
	{
		this.thread = thread;
	}

	@Override
	public void run()
	{
		try
		{
			if(null != this.thread)
			{
				this.thread.join();
			}
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}

		// 自己的业务逻辑
		System.out.println(0);
	}
}

class Caculator1 implements Runnable
{
	private Thread thread;

	public void setThread(Thread thread)
	{
		this.thread = thread;
	}

	@Override
	public void run()
	{
		try
		{
			if(null != this.thread)
			{
				this.thread.join();
			}
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}

		// 自己的业务逻辑
		System.out.println(1);
	}
}

class Caculator2 implements Runnable
{
	private Thread thread;

	public void setThread(Thread thread)
	{
		this.thread = thread;
	}

	@Override
	public void run()
	{
		try
		{
			if(null != this.thread)
			{
				this.thread.join();
			}
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}

		// 自己的业务逻辑
		System.out.println(2);
	}
}
