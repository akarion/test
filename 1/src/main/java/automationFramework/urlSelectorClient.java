package automationFramework;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import java.io.*;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class urlSelectorClient {

	String langCode;
	static String siteURL;
	
	private static String getURL() throws InvalidFormatException, IOException{
			
		FileInputStream fis = new FileInputStream("C:/GIT/1/src/main/java/testData/Desktop/testData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheetAt(0);
		
		CellReference cellRef = new CellReference(1, 0);
		
		Row row = sheet.getRow(cellRef.getRow());
		Cell cell = row.getCell(cellRef.getCol());
		
		siteURL = cell.getRichStringCellValue().getString();
		
		
		

	
	
	
	return siteURL;
	
	}
	

	public static String setLanguageCode(String langCode){
		
		
		
		
		return langCode;
	}
	
	public static void main(String[] args) throws Exception { 
		
		getURL();
		System.out.println(siteURL);}
	
	
}
