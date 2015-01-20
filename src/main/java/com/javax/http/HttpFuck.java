package com.javax.http;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpFuck
{
	public static void main(String[] args)
	{
		execute();
	}

	public static void execute()
	{
		int pThreadSize = 1000;
		ExecutorService pool = Executors.newFixedThreadPool(pThreadSize);
		for (int i = 0; i < pThreadSize; i++)
		{
			Consumer Consumer = new Consumer();
			Thread thread = new Thread(Consumer);
			pool.execute(thread);
		}
	}
	
}

class Consumer implements Runnable
{
	@Override
	public void run()
	{
		while (true)
		{
			try
			{
				this.task();
			} catch (ClientProtocolException e)
			{
				e.printStackTrace();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	public void task() throws ClientProtocolException, IOException
	{

		CloseableHttpClient httpclient = HttpClients.createDefault();
		try
		{
			HttpGet httpget = new HttpGet("http://1111.tmall.com");

			System.out.println("Executing request " + httpget.getRequestLine());

			// Create a custom response handler
			ResponseHandler<String> responseHandler = new ResponseHandler<String>()
			{

				public String handleResponse(final HttpResponse response)
						throws ClientProtocolException, IOException
				{
					int status = response.getStatusLine().getStatusCode();
					if (status >= 200 && status < 300)
					{
						HttpEntity entity = response.getEntity();
						return entity != null ? EntityUtils.toString(entity)
								: null;
					} else
					{
						throw new ClientProtocolException(
								"Unexpected response status: " + status);
					}
				}

			};
			String responseBody = httpclient.execute(httpget, responseHandler);
			System.out.println("----------------------------------------");
			System.out.println(responseBody);
		} finally
		{
			httpclient.close();
		}
	}
}
