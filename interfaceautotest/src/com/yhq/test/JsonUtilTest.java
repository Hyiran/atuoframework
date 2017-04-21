package com.yhq.test;


import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.yhq.util.ExcelReader;
import com.yhq.util.JsonUtil;
import com.yhq.util.Menus;

public class JsonUtilTest {
 
//  public void test() {
//	  String response="{\"errorMsg\":\"�û���������\",\"nres\":\"83010003\",\"remantCount\":0,\"res\":\"40000001\"}";
//	  
//
//	  String code ="res";
//	  JsonUtil jsu = new JsonUtil();
//	  jsu.getJson(response, code);
//  }
  
  @Test(dataProvider ="datasource")
  public void test(String response){
	  //������½�ɹ����ص�json
	  //���ȷ����л�
	  //�����
	  JSONObject  json = JSON.parseObject(response);
	  json.getString("token");
	  
	  //����һ��
	  
	  JSONObject data = json.getJSONObject("data");
	  //��ȡdata�����storeName
	  data.getString("storeName");
	  
	  //��ȡdata��menus
	  
	 //menus ��list ��Ƕ��map
	  
	  JSONArray array = data.getJSONArray("menus");
	  //�� arrayת���� list<map<>>
	  List<Map<String,String>> list = json.parseObject(array.toJSONString(), new TypeReference<List<Map<String,String>>>(){});
	  
	  for(Map<String,String> m :list){
		  System.out.println(m.get("name"));
	  }
  
  }
  
  //��excel���Ĳ�������
  @DataProvider(name="datasource")
  public String[][] getData(){
	  //excel��·��
	  String excelPath=System.getProperty("user.dir")+"\\res\\test.xlsx";
	  //��ȡ��sheet��
	  String sheetName="Sheet1";
	  ExcelReader reader = new ExcelReader(excelPath,sheetName);
	  return reader.read();
	  
	  
  }
}
