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
		//�������� ���ص�getLastRowNumΪ2
		int rowtotalnum = sheet.getLastRowNum();
		
		String [][] str = new String [rowtotalnum][];
		
		//�ȶ���
		for(int i=1;i<=rowtotalnum;i++){
			Row row = sheet.getRow(i);
			//9�з���getLastCellNum��Ϊ9
			int celltotalnum = row.getLastCellNum();
			String [] arr = new String[celltotalnum];
			//����,�������һ��Ϊ�ջ���������
			for(int j=0;j<celltotalnum;j++){
				Cell cell = row.getCell(j);
				str[i-1] = arr;
				//�����Ԫ��Ϊ�ձ�nullpoint�쳣
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
