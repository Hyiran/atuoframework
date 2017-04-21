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
	//每次执行用例之前需要先初始化一下数据库
	String token="";
	String response="";
	MyHttpsConnection myconn=null ;
	//几个列几个参数
/*  @Test(dataProvider ="datasource")
  public void test2(String flag,String caseName,String interfaceName,String domain,String interfaceAddr,String method,String precondition,String username,String pwd,String scenario,String pattern,String parm,String expectRes,String expectederrMsg) {
	 //判断excel里的执行标识是否为YES和方法是post，否知不执行
	  if("YES".equalsIgnoreCase(flag) &&"post".equalsIgnoreCase(method)){
		  //如果是getLogin接口需要获取token
		  if(interfaceAddr.contains("getLogin.action")){
			  MyHttpsConnection myconn = new MyHttpsConnection();
			  response = myconn.myPost(domain+interfaceAddr, parm);
			  JSONObject jsonres = JSON.parseObject(response);
			  String isexit = jsonres.getString("token");
			   if(jsonres.getString("token")!=null){
				   token = jsonres.getString("token");
			   }
			   System.out.println("登录用例返回结果"+response);
		  }
		  //非登录接口
		  else if(scenario.contains("缺少token")){
			  MyHttpsConnection myconn = new MyHttpsConnection();
			  response = myconn.myPost(domain+interfaceAddr, parm);
			  System.out.println("缺少token用例返回结果"+response);
			  
		  }
		  else{
		  MyHttpsConnection myconn = new MyHttpsConnection();
		  response = myconn.myPost(domain+interfaceAddr, parm+"token="+token);
		  System.out.println("非登录非缺少token用例返回结果"+response);
		  }
		  
		  JSONObject jsonres = JSON.parseObject(response);
		  String actual = jsonres.getString("res");
		  
		 //添加断言
		  Assert.assertEquals(actual, expectRes);
	  }
	 
	  else if("YES".equalsIgnoreCase(flag) &&"get".equalsIgnoreCase(method)) {
		  MyHttpsConnection myconn = new MyHttpsConnection();
		  response = myconn.myGet(domain+interfaceAddr, parm+"token="+token);
		  System.out.println("get请求返回结果"+response);
	  }
	 
	  
  }*/
  
//  @Test(dependsOnMethods="test")
//  public void print(){
//	  System.out.println(token);
//  }
//  
  //解析json
  
  
  
  //读excel表格的测试用例
  @DataProvider(name="datasource")
  public String[][] getData(){
	  //excel的路径
	  String excelPath=System.getProperty("user.dir")+"\\res\\Book1.xlsx";
	  //读取的sheet名
	  String sheetName="Sheet1";
	  ExcelReader reader = new ExcelReader(excelPath,sheetName);
	  return reader.read();
	  
	  
  }
  
  @Test(dataProvider ="datasource")
  public void test(String flag,String caseName,String interfaceName,String domain,String interfaceAddr,String method,String precondition,String username,String pwd,String scenario,String pattern,String parm,String expectRes,String expectederrMsg) {
	  //判断excel里的执行标识是否为YES和方法是post，否知不执行
	  if("YES".equalsIgnoreCase(flag)){
		  myconn = new MyHttpsConnection();
		  //判断前置条件,
		  if("NeedLogin".equalsIgnoreCase(precondition)){
			  //如果需要登录先调用登录接口
			  
			  String logres= myconn.myPost(domain+username, pwd);
			 
			  token = JSON.parseObject(logres).getString("token");
			  if("post".equalsIgnoreCase(method)){
				  response = myconn.myPost(domain+interfaceAddr,parm+"token="+token);
				  System.out.println("需要登录的post返回结果"+response);
			  }else if("get".equalsIgnoreCase(method)){
				  response = myconn.myGet(domain+interfaceAddr,parm+"token="+token);
				  System.out.println("需要登录的get返回结果"+response);
			  }
			 
		  }
		  else{
			  if("post".equalsIgnoreCase(method)){
				  response = myconn.myPost(domain+interfaceAddr,parm);
				  System.out.println("不需要登录的post返回结果"+response);
			  }else if("get".equalsIgnoreCase(method)){
				  response = myconn.myGet(domain+interfaceAddr,parm);
				  System.out.println("不需要登录的get返回结果"+response);
			  }
			  
		  }
	}
	 JSONObject jsonres = JSON.parseObject(response);
	  String actual = jsonres.getString("res");
	  
	 //添加断言
	  Assert.assertEquals(actual, expectRes); 
  }
}
