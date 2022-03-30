package com.vtiger.Genericutility;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author saraswata 
 *
 */

public class ExcelUtility {
	 /**
	 * 
	 * it is used to fetch the data from excel sheet
	 * @param sheetname
     * @param rowNum
     * @param cellNum
     * @return data
	 * @throws Throwable 
	 */
	public String getDataFromExcel(String sheetName,int rowNum,int cellNum) throws Throwable {
		FileInputStream fis=new FileInputStream("./src/test/resources/contactdata.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(sheetName);
		Row row=sh.getRow(rowNum);
		String data=row.getCell(cellNum).getStringCellValue();
	
		book.close();
		return data;
		
	}

/**
 * 
 * it is used to get the last used row number on specified sheet
 * @param sheetName
 * @throws Throwable 
 * 
 * 
 */
public int getRowCount(String sheetName) throws Throwable {
	FileInputStream fis=new FileInputStream("./src/test/resources/contactdata.xlsx");
	Workbook book=WorkbookFactory.create(fis);
	Sheet sh=book.getSheet(sheetName);
	
	book.close();
	 return sh.getLastRowNum();
}
/**
 * 
 * it is used to set the data in excel sheet
 * @param sheetName
 * @param rowNum
 * @param cellNum
 * @param data
 * @throws Throwable 
 */
public void setDataexcel(String sheetName,int rownum,int cellNum,String data) throws Throwable {
	FileInputStream fis=new FileInputStream("./src/test/resources/contactdata.xlsx");
	Workbook book=WorkbookFactory.create(fis);
	Sheet sh=book.getSheet(sheetName);
	Row row=sh.getRow(rownum);
	Cell cel=row.createCell(cellNum);
	
	cel.setCellValue(data);
	FileOutputStream fos=new FileOutputStream("./src/test/resources/contactdata.xlsx");
	book.write(fos);
	book.close();
	
}

}


