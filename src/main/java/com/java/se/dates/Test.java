package com.java.se.dates;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test
{
	public static void main(String[] args)
	{
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/DD HH:mm:ss");
		System.out.println(sf.format(date));
		
		
		String[][] str = new String[5][2];
		
		System.out.println(str[0].length);
	}
}
