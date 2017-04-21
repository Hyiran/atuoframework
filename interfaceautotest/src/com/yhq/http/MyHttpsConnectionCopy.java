package com.yhq.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MyHttpsConnectionCopy {
	//application/x-www-from-urlencoded方式传参
	public String myPost(String url,String parm){
		//返回的内容
		StringBuffer reponse = new StringBuffer();
		try {
			
			String line = null;
			URL urlpath = null;
			HttpsURLConnection conn = null;
			PrintWriter  writer = null;
			BufferedReader reader = null;
			urlpath = new URL(url);
			conn = (HttpsURLConnection) urlpath.openConnection();
			//设置属性
			
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestMethod("POST");
			System.out.println("***********"+conn.getRequestMethod());
			System.out.println("***********"+conn.getDoOutput());
			System.out.println("***********"+conn.getDoInput());
			conn.setReadTimeout(0);
			conn.setUseCaches(false);
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setConnectTimeout(0);
			//打开连接
			conn.connect();
			//传参数
			writer = new PrintWriter(conn.getOutputStream());
			writer.write(parm);
			writer.flush();
		
			//读取返回的
			InputStreamReader inputstream = new InputStreamReader(conn.getInputStream(),"UTF-8");
			reader = new BufferedReader(inputstream);
			//开始读
			while((line = reader.readLine())!=null){
				reponse.append(line);
			}
			if (reader !=null){
				reader.close();
			}
			if (writer !=null){
				writer.close();
			}
			if(conn!=null){
				conn.disconnect();
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
		return reponse.toString();
		
	}

}
