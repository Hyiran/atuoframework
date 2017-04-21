package com.yhq.util;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {
	private String path;
	private String sheetname;
	
	private Workbook workbook;
	private Sheet sheet;
	
	public ExcelReader(String path,String sheetname){
		this.path = path;
		this.sheetname = sheetname;
		
		try {
			workbook = WorkbookFactory.create(new File(path));
			sheet = workbook.getSheet(sheetname);
		} catch (InvalidFormatException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	public String[][] read(){
		//三行数据 返回的getLastRowNum为2
		int rowtotalnum = sheet.getLastRowNum();
		
		String [][] str = new String [rowtotalnum][];
		
		//先读行
		for(int i=1;i<=rowtotalnum;i++){
			Row row = sheet.getRow(i);
			//9列返回getLastCellNum就为9
			int celltotalnum = row.getLastCellNum();
			String [] arr = new String[celltotalnum];
			//读列,但是最后一列为空还有有问题
			for(int j=0;j<celltotalnum;j++){
				Cell cell = row.getCell(j);
				str[i-1] = arr;
				//解决单元格为空报nullpoint异常
				if(cell!=null){
					str[i-1][j] = cell.getStringCellValue();
				}
				else{
					str[i-1][j] = "";
				}
				
				
				
			}
		}
		//System.out.println(rowtotalnum);
		return str;
		
	}
	
}
