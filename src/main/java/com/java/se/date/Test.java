package com.java.se.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test
{
	public static void main(String[] args)
	{
		System.out.println(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
				.format(new Date()));
	}
}
