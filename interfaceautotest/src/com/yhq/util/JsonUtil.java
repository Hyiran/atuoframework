package com.yhq.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JsonUtil {
	
	//传入需要解析的string传，和要取 的节点
	public String getJson(String response,String code){
		
		//反序列化成map
		JSONObject json = JSON.parseObject(response);
		//System.out.println(json.getString(code));
		
		return json.getString(code);
	}
}
