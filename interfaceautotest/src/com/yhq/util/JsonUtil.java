package com.yhq.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JsonUtil {
	
	//������Ҫ������string������Ҫȡ �Ľڵ�
	public String getJson(String response,String code){
		
		//�����л���map
		JSONObject json = JSON.parseObject(response);
		//System.out.println(json.getString(code));
		
		return json.getString(code);
	}
}
