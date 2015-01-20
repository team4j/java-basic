package com.java.se.thread;

public class Sample
{
	public static void main(String[] args)
	{
		Customer c = new Customer();

		Thread t0 = new Thread(c);
		Thread t1 = new Thread(c);

		t0.start();
		t1.start();
	}
}

class Customer implements Runnable
{
	Bank bank = new Bank();

	@Override
	public void run()
	{
		for (int i = 0; i < 3; i++)
		{
			bank.doposit(100);
		}
	}
}

class Bank
{
	private int sum;

	public void doposit(int money)
	{
		synchronized (this)
		{
			sum = sum + money;
			System.out.println(Thread.currentThread().getName() + "\t"
					+ "total money:" + sum);
		}
	}
}