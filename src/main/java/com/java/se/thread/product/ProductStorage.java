package com.java.se.thread.product;

/**
 * 库存商品管理类
 */
public class ProductStorage
{

	/**
	 * 最大库存量
	 */
	public static final int Maximum = 100;

	/**
	 * 当前库存量
	 */
	public static int Currentimum = 50;

	/**
	 * 库存管理实例
	 */
	private static ProductStorage instance;

	private ProductStorage()
	{
	}

	/**
	 * 获取单例
	 * 
	 * @return
	 */
	public static ProductStorage getInstance()
	{
		if (instance == null)
		{
			instance = new ProductStorage();
		}
		return instance;
	}

	/**
	 * 生产产品
	 */
	public synchronized void product()
	{
		while (Currentimum >= Maximum / 2)
		{
			try
			{
				wait();
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		Currentimum++;
		System.out.println("当前线程：" + Thread.currentThread().getName()
				+ "--生产者生产了一个商品，当前库存量：" + Currentimum);
		notifyAll();
	}

	/**
	 * 消费产品
	 */
	public synchronized void consume()
	{
		while (Currentimum <= 0)
		{
			try
			{
				wait();
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		Currentimum--;
		System.out.println("当前线程：" + Thread.currentThread().getName()
				+ "--消费者消费了一个商品，当前库存量：" + Currentimum);
		notifyAll();
	}
}
