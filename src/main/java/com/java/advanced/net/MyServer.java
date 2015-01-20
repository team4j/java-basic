package com.java.advanced.net;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer
{
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException
	{
		ServerSocket ss = new ServerSocket(9999);
		System.out.println("�ȴ�����");
		
		Socket s = null;
		OutputStream os = null;
		BufferedReader br = null;
		while (true)
		{
			s = ss.accept();
			System.out.println("���ӳɹ�");
			os = s.getOutputStream();
			
			br = new BufferedReader(
					new FileReader(
							"d:/Workspaces4j/1st/web-parent/java-basic/src/main/resources/response.html"));
			String line = "";
			while ((line = br.readLine()) != null)
			{
				System.out.println(line);
				os.write(line.getBytes());
			}
			br.close();
			os.close();
			s.close();
		}
	}
}
