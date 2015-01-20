package com.java.se.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class Test
{
	public static void main(String[] args) throws IOException
	{
//		read();
		
		read0();
	}

	public static void read() throws IOException
	{
		InputStream is = new FileInputStream("E:\\Test\\a.txt");
		
		int ch = 0;
//		byte[] data = new byte[5];
		while(-1 != (ch = is.read()))
		{
			ch = is.read();
			System.out.println((char)ch);
		}
	}
	
	public static void read0() throws IOException
	{
		Reader reader = new FileReader("E:\\Test\\a.txt");
		
		while(true)
		{
			System.out.println((char)reader.read());
		}
	}
}
