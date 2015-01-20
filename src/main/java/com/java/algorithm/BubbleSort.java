package com.java.algorithm;

public class BubbleSort
{
	public static void main(String[] args)
	{
		int[] nums = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

		int[] result = BubbleSort.sort(nums);

		for (int e : result)
		{
			System.out.print(e + "\t");
		}
	}

	public static int[] sort(int[] nums)
	{
		int store = 0;
		for (int i = 0; i < nums.length - 1; i++)
		{
			for (int j = 0; j < nums.length - 1 - i; j++)
			{
				if (nums[j] > nums[j + 1])
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
