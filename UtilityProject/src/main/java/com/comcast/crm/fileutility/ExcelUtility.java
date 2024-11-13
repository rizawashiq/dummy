package com.comcast.crm.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public  String getDataFromExcel(String sheet , int row , int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./TestData/test_data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		return wb.getSheet(sheet).getRow(row).getCell(cell).toString();
	}
	
	public  void writeDataoExcel(String sheet , int row , int cell , String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./TestData/test_data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		 wb.getSheet(sheet).getRow(row).getCell(cell).setCellValue(data);
		 FileOutputStream fos = new FileOutputStream("./TestData/test_data.xlsx");
		 wb.write(fos);
		 wb.close();
	}
	
	
	
}
