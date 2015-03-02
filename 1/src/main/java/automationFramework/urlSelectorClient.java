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

	static String langCode;
	static String siteURL;
	
	public static String  getURL() throws InvalidFormatException, IOException{
			
		FileInputStream fis = new FileInputStream("C://GIT/1/src/main/java/automationFramework/testData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheetAt(0);
		
		CellReference urlRef = new CellReference(1, 0);
		
		Row urlRow = sheet.getRow(urlRef.getRow());
		Cell urlCell = urlRow.getCell(urlRef.getCol());
		
		if(langCode!=null){
		siteURL = urlCell.getRichStringCellValue().getString()+langCode;}
		
		else{
			siteURL = urlCell.getRichStringCellValue().getString();
		}
		
        		
		return siteURL;
	
	}
	

	public static String getLanguageCode() throws InvalidFormatException, IOException{
		
        FileInputStream fis = new FileInputStream("C://GIT/1/src/main/java/automationFramework/testData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis); 
		Sheet sheet = wb.getSheetAt(0); //chooses sheet 1 (default)
		
		CellReference langRef = new CellReference(1, 1); //references a cell with language code 
		
		Row langRow = sheet.getRow(langRef.getRow());
		Cell langCell = langRow.getCell(langRef.getCol());
		
		langCode = "?lang="+langCell.getRichStringCellValue().getString();
		
		return langCode;
	}
	
//	public static void main(String[] args) throws Exception { 
//		
//		getLanguageCode();
//		System.out.println(langCode);
//		
//		getURL();
//		System.out.println(siteURL);
//		
//		
//		
//	
//	
//	}
	
	
}
