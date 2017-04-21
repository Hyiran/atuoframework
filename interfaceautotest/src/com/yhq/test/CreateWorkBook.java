package com.yhq.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateWorkBook {

	public static void main(String[] args) {
		
		ArrayList <ArrayList<String>> lists = new ArrayList<ArrayList<String>>();
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("�����");
		list1.add("ѧ��8��");
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("���");
		list2.add("ѧ��2��");
		lists.add(list1);
		lists.add(list2);
		System.out.print(lists.toString());
		
		HSSFWorkbook  workbook = new HSSFWorkbook();
		try{
			Sheet sheet = workbook.createSheet("first sheet");
			Row row = sheet.createRow(0);
			row.createCell(0).setCellValue("��һ��");
			row.createCell(1).setCellValue("�ڶ���");
			row.createCell(2).setCellValue("������");
			FileOutputStream out = new FileOutputStream("createWorkBook.xls");
			workbook.write(out);
			out.close();
			System.out.println("createWorkBook success");
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

}
