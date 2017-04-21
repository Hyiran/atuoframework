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
//	  String response="{\"errorMsg\":\"用户名不存在\",\"nres\":\"83010003\",\"remantCount\":0,\"res\":\"40000001\"}";
//	  
//
//	  String code ="res";
//	  JsonUtil jsu = new JsonUtil();
//	  jsu.getJson(response, code);
//  }
  
  @Test(dataProvider ="datasource")
  public void test(String response){
	  //解析登陆成功返回的json
	  //首先反序列化
	  //最外层
	  JSONObject  json = JSON.parseObject(response);
	  json.getString("token");
	  
	  //往里一层
	  
	  JSONObject data = json.getJSONObject("data");
	  //获取data里面的storeName
	  data.getString("storeName");
	  
	  //读取data中menus
	  
	 //menus 是list 中嵌套map
	  
	  JSONArray array = data.getJSONArray("menus");
	  //把 array转化成 list<map<>>
	  List<Map<String,String>> list = json.parseObject(array.toJSONString(), new TypeReference<List<Map<String,String>>>(){});
	  
	  for(Map<String,String> m :list){
		  System.out.println(m.get("name"));
	  }
  
  }
  
  //读excel表格的测试用例
  @DataProvider(name="datasource")
  public String[][] getData(){
	  //excel的路径
	  String excelPath=System.getProperty("user.dir")+"\\res\\test.xlsx";
	  //读取的sheet名
	  String sheetName="Sheet1";
	  ExcelReader reader = new ExcelReader(excelPath,sheetName);
	  return reader.read();
	  
	  
  }
}
