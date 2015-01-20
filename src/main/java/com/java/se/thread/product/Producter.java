package com.java.se.thread.product;

/**
 * 商品生产者模型
 */
public class Producter implements Runnable
{

	@Override
	public void run()
	{
		while (true)
		{
			try
			{
				Thread.sleep(500);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			ProductStorage.getInstance().product();
		}
	}
}