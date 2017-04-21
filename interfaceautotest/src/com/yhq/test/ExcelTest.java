package com.yhq.test;

import org.testng.annotations.Test;

import com.yhq.util.ExcelReader;

public class ExcelTest {
  @Test
  public void f() {
	  String path = System.getProperty("user.dir")+"\\res\\Book1.xlsx";
	  System.out.println("Â·¾¶£º"+path);
	  ExcelReader reader = new ExcelReader(path,"Sheet1");
	  String[][] s = reader.read();
	  for(int i=0;i<s.length;i++){
		  int length = s[1].length;
		  for (int j=0;j<length;j++){
			  System.out.println(s[i][j]);
		  }
		  
	  }
	  
  }
}
