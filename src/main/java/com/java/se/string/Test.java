package com.java.se.string;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Test
{
	public static void main(String[] args) throws IOException
	{
		String fileName = "中文";
		byte[] datas = fileName.getBytes("gb2312");
		for(byte data : datas)
		{
			System.out.print(data);
		}

		System.out.println();
		
		fileName = new String(datas,"iso-8859-1");
		for(byte data : fileName.getBytes())
		{
			System.out.print(data);
		}
		
		
		OutputStream os = new FileOutputStream("E:\\Test\\io.txt");
		
		os.write(fileName.getBytes("gb2312"));
		
		os.close();
	}
}
