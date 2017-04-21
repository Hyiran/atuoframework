package com.yhq.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yhq.http.MyHttpsConnection;
import com.yhq.http.MyHttpsConnectionCopy;
import com.yhq.util.ExcelReader;
import com.yhq.util.JsonUtil;
import com.yhq.util.RandomString;

public class ReadTestCase {
	//ÿ��ִ������֮ǰ��Ҫ�ȳ�ʼ��һ�����ݿ�
	String token="";
	String response="";
	MyHttpsConnection myconn=null ;
	//�����м�������
/*  @Test(dataProvider ="datasource")
  public void test2(String flag,String caseName,String interfaceName,String domain,String interfaceAddr,String method,String precondition,String username,String pwd,String scenario,String pattern,String parm,String expectRes,String expectederrMsg) {
	 //�ж�excel���ִ�б�ʶ�Ƿ�ΪYES�ͷ�����post����֪��ִ��
	  if("YES".equalsIgnoreCase(flag) &&"post".equalsIgnoreCase(method)){
		  //�����getLogin�ӿ���Ҫ��ȡtoken
		  if(interfaceAddr.contains("getLogin.action")){
			  MyHttpsConnection myconn = new MyHttpsConnection();
			  response = myconn.myPost(domain+interfaceAddr, parm);
			  JSONObject jsonres = JSON.parseObject(response);
			  String isexit = jsonres.getString("token");
			   if(jsonres.getString("token")!=null){
				   token = jsonres.getString("token");
			   }
			   System.out.println("��¼�������ؽ��"+response);
		  }
		  //�ǵ�¼�ӿ�
		  else if(scenario.contains("ȱ��token")){
			  MyHttpsConnection myconn = new MyHttpsConnection();
			  response = myconn.myPost(domain+interfaceAddr, parm);
			  System.out.println("ȱ��token�������ؽ��"+response);
			  
		  }
		  else{
		  MyHttpsConnection myconn = new MyHttpsConnection();
		  response = myconn.myPost(domain+interfaceAddr, parm+"token="+token);
		  System.out.println("�ǵ�¼��ȱ��token�������ؽ��"+response);
		  }
		  
		  JSONObject jsonres = JSON.parseObject(response);
		  String actual = jsonres.getString("res");
		  
		 //��Ӷ���
		  Assert.assertEquals(actual, expectRes);
	  }
	 
	  else if("YES".equalsIgnoreCase(flag) &&"get".equalsIgnoreCase(method)) {
		  MyHttpsConnection myconn = new MyHttpsConnection();
		  response = myconn.myGet(domain+interfaceAddr, parm+"token="+token);
		  System.out.println("get���󷵻ؽ��"+response);
	  }
	 
	  
  }*/
  
//  @Test(dependsOnMethods="test")
//  public void print(){
//	  System.out.println(token);
//  }
//  
  //����json
  
  
  
  //��excel���Ĳ�������
  @DataProvider(name="datasource")
  public String[][] getData(){
	  //excel��·��
	  String excelPath=System.getProperty("user.dir")+"\\res\\Book1.xlsx";
	  //��ȡ��sheet��
	  String sheetName="Sheet1";
	  ExcelReader reader = new ExcelReader(excelPath,sheetName);
	  return reader.read();
	  
	  
  }
  
  @Test(dataProvider ="datasource")
  public void test(String flag,String caseName,String interfaceName,String domain,String interfaceAddr,String method,String precondition,String username,String pwd,String scenario,String pattern,String parm,String expectRes,String expectederrMsg) {
	  //�ж�excel���ִ�б�ʶ�Ƿ�ΪYES�ͷ�����post����֪��ִ��
	  if("YES".equalsIgnoreCase(flag)){
		  myconn = new MyHttpsConnection();
		  //�ж�ǰ������,
		  if("NeedLogin".equalsIgnoreCase(precondition)){
			  //�����Ҫ��¼�ȵ��õ�¼�ӿ�
			  
			  String logres= myconn.myPost(domain+username, pwd);
			 
			  token = JSON.parseObject(logres).getString("token");
			  if("post".equalsIgnoreCase(method)){
				  response = myconn.myPost(domain+interfaceAddr,parm+"token="+token);
				  System.out.println("��Ҫ��¼��post���ؽ��"+response);
			  }else if("get".equalsIgnoreCase(method)){
				  response = myconn.myGet(domain+interfaceAddr,parm+"token="+token);
				  System.out.println("��Ҫ��¼��get���ؽ��"+response);
			  }
			 
		  }
		  else{
			  if("post".equalsIgnoreCase(method)){
				  response = myconn.myPost(domain+interfaceAddr,parm);
				  System.out.println("����Ҫ��¼��post���ؽ��"+response);
			  }else if("get".equalsIgnoreCase(method)){
				  response = myconn.myGet(domain+interfaceAddr,parm);
				  System.out.println("����Ҫ��¼��get���ؽ��"+response);
			  }
			  
		  }
	}
	 JSONObject jsonres = JSON.parseObject(response);
	  String actual = jsonres.getString("res");
	  
	 //��Ӷ���
	  Assert.assertEquals(actual, expectRes); 
  }
}
