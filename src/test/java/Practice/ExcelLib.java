package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLib {
	
	public String accessData(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("‪‪D:\\sheet.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		DataFormatter format=new DataFormatter();
		
		return format.formatCellValue(book.getSheet(sheetName).getRow(rowNum).getCell(cellNum));
		
		}

}
