package com.yhq.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;






public class ExcelWriter {
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	
	
	 
	public List<List<String>> readAllData(String filePath,String sheetName)
	{
		ArrayList<List<String>> result=new ArrayList<List<String>>();
       try 
       {
    	   InputStream in = new FileInputStream(new File(filePath));
			workbook = new XSSFWorkbook(in);
       	//Object workBook=getWorkBook(filePath, ExtensionType.XLSX);  
       	sheet =workbook.getSheet(sheetName);
       	Iterator<Row> rit2 = sheet.rowIterator();
       	System.out.println(rit2.toString());
       	for (Iterator<Row> rit = sheet.rowIterator(); rit.hasNext();)
       	{
               ArrayList<String> rowValue=new ArrayList<String>();
               XSSFRow row = (XSSFRow) rit.next();

  		    for (Integer i=0;i<row.getPhysicalNumberOfCells();i++ )
		        {
		            XSSFCell cell = (XSSFCell)row.getCell(i);
		            String value = cell.getStringCellValue();
		            rowValue.add(value);
		        }
  		        result.add(rowValue);
       	}
		}
      catch (Exception e)
      {
			e.printStackTrace();
	   }	    
      return result;
		
	}
//创建excel
	public void write(String path,String sheetName,String str){
		workbook = new XSSFWorkbook();
		try {
			
			sheet = workbook.createSheet(sheetName);
			XSSFRow row = sheet.createRow(0);
			row.createCell(0).setCellValue("第一列");
			row.createCell(1).setCellValue("第二列");
			row.createCell(2).setCellValue("第三列");
			FileOutputStream out = new FileOutputStream(path);
			workbook.write(out);
			out.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	//在已有的excel里面追加内容
	public void writeisExit(String path,String sheetName,String str){
		
		try {
			InputStream in = new FileInputStream(new File(path));
			workbook = new XSSFWorkbook(in);
			sheet = workbook.getSheet(sheetName);
			int m = sheet.getLastRowNum();
			for(int i=1;i<=sheet.getLastRowNum();i++){
				XSSFRow row = sheet.getRow(i);
				int num = row.getLastCellNum();
				XSSFCell cell = row.getCell(num-1);
				cell.setCellValue(str);
			}
			
			FileOutputStream out = new FileOutputStream(path);
			workbook.write(out);
			out.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	//在已有的excel里面追加内容
	public void writeisExit(String path,String sheetName,String str,int rowid){
		try {
			InputStream in = new FileInputStream(new File(path));
			workbook = new XSSFWorkbook(in);
			sheet = workbook.getSheet(sheetName);
			
			XSSFRow row = sheet.getRow(rowid);
			int num = row.getLastCellNum();
			XSSFCell cell = row.getCell(num-1);
			cell.setCellValue(str);
		
			
			FileOutputStream out = new FileOutputStream(path);
			workbook.write(out);
			out.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	
	//读excle
	public ArrayList <ArrayList<String>> read(String path,String sheetName){
		ArrayList <ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		try {
			InputStream in = new FileInputStream(new File(path));
			workbook = new XSSFWorkbook(in);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			int m = sheet.getLastRowNum();
			for(int i=0;i<sheet.getLastRowNum();i++){
				ArrayList<String> rowResult = new ArrayList<String>();
				XSSFRow row = sheet.getRow(i);
				int num = row.getLastCellNum();
				for(int j=0;j<row.getLastCellNum();j++){
					XSSFCell cell = row.getCell(j);
					String str = cell.getStringCellValue();
					rowResult.add(str);
				}
				result.add(rowResult);
				
			}
			System.out.println(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
