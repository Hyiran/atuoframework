package com.yhq.util;


//生成随机字符串的类
public class RandomString {
	
	private static String strRan="abcdefghijkl";
	
	
	private static int getRandom(int count){
		return (int) Math.round(Math.random()*count);
	}
	
	public static String getRandonString(){
		 int length = strRan.length();
		StringBuffer buffer = new StringBuffer();
		for(int i=0;i<length;i++){
			buffer.append(strRan.charAt(getRandom(length-1)));
		}
		
		return buffer.toString();
	}

}
