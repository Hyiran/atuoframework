package com.yhq.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MyHttpsConnection {
	//application/x-www-from-urlencoded��ʽ����
	public String myPost(String url,String parm){
		//���ص�����
		StringBuffer reponse = new StringBuffer();
		String line = null;
		URL urlpath = null;
		HttpsURLConnection conn = null;
		PrintWriter  writer = null;
		BufferedReader reader = null;
		try {
			urlpath = new URL(url);
			conn = (HttpsURLConnection) urlpath.openConnection();
			//��������
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setConnectTimeout(5000);
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
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		finally{
			try{
				if (reader !=null){
					reader.close();
				}
				if (writer !=null){
					writer.close();
				}
				if(conn!=null){
					conn.disconnect();
				}
			}
			
			catch(IOException e){
				e.printStackTrace();
			}


		}
		return reponse.toString();
		
	}
///get
	
	public String myGet(String url,String parm){
		
		String urlPath = url+"?"+parm;
		BufferedReader reader = null;
		StringBuffer reponse = new StringBuffer();
		String line = null;
		try {
			URL  myurl = new URL(urlPath);
			HttpsURLConnection myconn = (HttpsURLConnection) myurl.openConnection();
			myconn.setDoOutput(true);
			myconn.connect();
			InputStreamReader inputstream = new InputStreamReader(myconn.getInputStream(),"UTF-8");
			reader = new BufferedReader(inputstream);
			//��ʼ��
			while((line = reader.readLine())!=null){
				reponse.append(line);
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return reponse.toString();
		
		
	}
}
