package com.yhq.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MyHttpsConnectionCopy {
	//application/x-www-from-urlencoded��ʽ����
	public String myPost(String url,String parm){
		//���ص�����
		StringBuffer reponse = new StringBuffer();
		try {
			
			String line = null;
			URL urlpath = null;
			HttpsURLConnection conn = null;
			PrintWriter  writer = null;
			BufferedReader reader = null;
			urlpath = new URL(url);
			conn = (HttpsURLConnection) urlpath.openConnection();
			//��������
			
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
			//������
			conn.connect();
			//������
			writer = new PrintWriter(conn.getOutputStream());
			writer.write(parm);
			writer.flush();
		
			//��ȡ���ص�
			InputStreamReader inputstream = new InputStreamReader(conn.getInputStream(),"UTF-8");
			reader = new BufferedReader(inputstream);
			//��ʼ��
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
