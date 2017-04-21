package com.yhq.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yhq.http.MyHttpsConnection;
import com.yhq.util.ExcelReader;
import com.yhq.util.ExcelWriter;

public class NewTest {
	String token="";
	String responseReslut="";
	MyHttpsConnection myconn=null ;
  @Test
  public void begin() {
	  //��ȡexcle
	//excel��·��
	  String excelPath=System.getProperty("user.dir")+"\\res\\Book1.xlsx";
	  //��ȡ��sheet��
	  String sheetName="Sheet1";
	  ExcelReader reader = new ExcelReader(excelPath,sheetName);
	  String[][] response = reader.read();
	  for(int i=0;i<response.length;i++){
		  String flag = response[i][0];
		  String caseName = response[i][1];
		  String interfaceName = response[i][2];
		  String domain = response[i][3];
		  String interfaceAddr = response[i][4];
		  String method = response[i][5];
		  String precondition = response[i][6];
		  String username = response[i][7];
		  String pwd = response[i][8];
		  String scenario = response[i][9];
		  String pattern = response[i][10];
		  String parm =response[i][11];
		  String expectRes =response[i][12];
		  String expectederrMsg =response[i][13];
		  
		 String Reslut= Luoji(flag,precondition,domain,username,pwd,method,interfaceAddr,parm);

		  JSONObject jsonres = JSON.parseObject(Reslut);
		  String actual = jsonres.getString("res");
		  
		  ExcelWriter writer = new ExcelWriter();
		  //���صĽ����һ�¾Ͱѷ��صı���д��excel
		  if(!(actual.equalsIgnoreCase(expectRes))){
			  //дexcel
			  writer.writeisExit(excelPath, sheetName, Reslut,i+1);
		  }else{
			  writer.writeisExit(excelPath, sheetName, "�ɹ�",i+1);
		  }
			  
	  }
	  
	  
  }
  
  public void sendRequest(){
	  
  }
  public String Luoji(String flag,String precondition,String domain,String username,String pwd,String method,String interfaceAddr,String parm){
	 // String responseReslut="";
	  //�ж�excel���ִ�б�ʶ�Ƿ�ΪYES�ͷ�����post����֪��ִ��
	  if("YES".equalsIgnoreCase(flag)){
		  myconn = new MyHttpsConnection();
		  //�ж�ǰ������,
		  if("NeedLogin".equalsIgnoreCase(precondition)){
			  //�����Ҫ��¼�ȵ��õ�¼�ӿ�
			  
			  String logres= myconn.myPost(domain+username, pwd);
			 
			  token = JSON.parseObject(logres).getString("token");
			  if("post".equalsIgnoreCase(method)){
				  responseReslut = myconn.myPost(domain+interfaceAddr,parm+"token="+token);
				  System.out.println("��Ҫ��¼��post���ؽ��"+responseReslut);
			  }else if("get".equalsIgnoreCase(method)){
				  responseReslut = myconn.myGet(domain+interfaceAddr,parm+"token="+token);
				  System.out.println("��Ҫ��¼��get���ؽ��"+responseReslut);
			  }
			 
		  }
		  else{
			  if("post".equalsIgnoreCase(method)){
				  responseReslut = myconn.myPost(domain+interfaceAddr,parm);
				  System.out.println("����Ҫ��¼��post���ؽ��"+responseReslut);
			  }else if("get".equalsIgnoreCase(method)){
				  responseReslut = myconn.myGet(domain+interfaceAddr,parm);
				  System.out.println("����Ҫ��¼��get���ؽ��"+responseReslut);
			  }
			  
		  }
	}
	  return responseReslut;
  }
}
