package com.java.se.array;

public class Demo
{
	public static void main(String[] args)
	{
		int[] array0 = { 10, 20, 30 };
		int[] array1 = { 40, 50, 60 };

		int[] arrayResult = Demo.combine(array0, array1);
		
		//循环输出结果
		for (int e : arrayResult)
		{
			System.out.print(e + "\t");
		}

		int[] descResult = Demo.sort(arrayResult);

		System.out.println();
		//循环输出结果
		for (int r : descResult)
		{
			System.out.print(r + "\t");
		}
	}

	/**
	 * 合并
	 * @param arg0
	 * @param arg1
	 * @return
	 */
	public static int[] combine(int[] arg0, int[] arg1)
	{
		int[] result = new int[arg0.length + arg1.length];

		for (int i = 0; i < arg0.length; i++)
		{
			result[i] = arg0[i];
		}

		for (int j = 0; j < arg1.length; j++)
		{
			result[arg0.length + j] = arg1[j];
		}

		return result;
	}

	/**
	 * 排序
	 * @param nums
	 * @param flag
	 * @return
	 */
	public static int[] sort(int[] nums)
	{
		int store = 0;
		for (int i = 0; i < nums.length - 1; i++)
		{
			for (int j = 0; j < nums.length - 1 - i; j++)
			{
				if (nums[j] < nums[j + 1])
				{
					store = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = store;
				}
			}
		}
		return nums;
	}
}
