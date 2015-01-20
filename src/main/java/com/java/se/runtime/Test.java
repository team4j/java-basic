package com.java.se.runtime;

import java.io.IOException;

public class Test
{
	public static void main(String[] args)
	{
		Process process = null;
		try
		{
			process = Runtime.getRuntime().exec("cmd.exe /c dir");
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
