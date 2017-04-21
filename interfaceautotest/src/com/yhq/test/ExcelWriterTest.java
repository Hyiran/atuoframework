package com.yhq.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.testng.annotations.Test;

import com.yhq.util.ExcelWriter;

public class ExcelWriterTest {
  @Test
  public void f() {
	  
	  String[] strings = {"A", "B", "C", "D"};
	  Collection stringList = java.util.Arrays.asList(strings);
	  /* 开始遍历 */
	  for (Iterator a = stringList.iterator(); a.hasNext();) {
	  Object str = a.next();
	  System.out.println(str);/* 依次输出“A”、“B”、“C”、“D” */
	  }
	  
	  String excelPath=System.getProperty("user.dir")+"\\res\\merchant.xlsx";
	  //读取的sheet名
	  String sheetName="channelList";
	  String response ="";
	  ExcelWriter writere = new ExcelWriter();
	  ArrayList <ArrayList<String>> result = new ArrayList<ArrayList<String>>();
	 // result = writere.read(excelPath, "Sheet1");
	  for(int i=0;i<result.size();i++){
		  
		 // System.out.println("======================"+result.get(i));
	  }
	  System.out.println(writere.readAllData(excelPath,sheetName));
	  
	  
  }
}
