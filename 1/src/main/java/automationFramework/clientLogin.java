package automationFramework;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class clientLogin extends urlSelectorClient{

	private static WebDriver driver = new FirefoxDriver();
	
	
	public clientLogin(WebDriver driver) { //constructor
		this.driver = driver;
				}
		
	public static String agentId;
	public static String agentLicenceType;
	public static String agentLicenceNum;
	public static String agentEmail;
	public static String agentPass;
			
	
public static void loginFill(String siteUrl) throws Exception {
    
	FileInputStream fs = new FileInputStream("C://GIT/1/src/main/java/automationFramework/testData.xlsx");
	
	Workbook wb = WorkbookFactory.create(fs);
	Sheet sheet = wb.getSheetAt(0);	
	
	
	CellReference agentIdCell = new CellReference("C2");	//agent id
	Row agentRow = sheet.getRow(agentIdCell.getRow());	
	Cell agentCell = agentRow.getCell(agentIdCell.getCol());
	double agentIdValue = agentCell.getNumericCellValue();
	int agentIdValueInt = (int) agentIdValue;
	agentId = String.valueOf(agentIdValueInt);
	
	
	CellReference licenceTypeCell = new CellReference("D2");  //licence type
	Row licTypeRow = sheet.getRow(licenceTypeCell.getRow());	
	Cell licTypeCell = licTypeRow.getCell(licenceTypeCell.getCol());
	double agentLicenceTypeDouble = licTypeCell.getNumericCellValue(); 
	int agentLicenceTypeInt = (int) agentLicenceTypeDouble;
	agentLicenceType = String.valueOf(agentLicenceTypeInt);
	
	CellReference licenceNumCell = new CellReference("E2");  //licence num
	Row licNumRow = sheet.getRow(licenceNumCell.getRow());	
	Cell licNumCell = licNumRow.getCell(licenceNumCell.getCol());
	double agentLicenceNumDouble = licNumCell.getNumericCellValue();
	int agentLicenceNumInt = (int) agentLicenceNumDouble;
	agentLicenceNum = String.valueOf(agentLicenceNumInt);
	
	CellReference emailCellRef = new CellReference("F2");  //email
	Row emailRow = sheet.getRow(emailCellRef.getRow());	
	Cell emailCell = emailRow.getCell(emailCellRef.getCol());
	agentEmail = emailCell.getRichStringCellValue().getString();
	

		driver.get(siteUrl);
		driver.switchTo().frame("Main"); // switches to needed frame
		Thread.sleep(3000);
			       	       
	       driver.findElement(By.xpath("//html/body/table[2]/tbody/tr/td/table[2]/tbody/tr/td/a")).click();
	       driver.findElement(By.name("clientId")).sendKeys(agentId);
			Select Licence = new Select(driver.findElement(By.name("licenseType")));
			Licence.selectByIndex(agentLicenceTypeInt);
			driver.findElement(By.name("licenseNumber")).sendKeys(agentLicenceNum);
			driver.findElement(By.name("email")).sendKeys(agentEmail);
						
	}

public static void passFill() throws InvalidFormatException, IOException{
	
	FileInputStream fs = new FileInputStream("C://GIT/1/src/main/java/automationFramework/testData.xlsx");
	Workbook wb = WorkbookFactory.create(fs);
	Sheet sheet = wb.getSheetAt(0);	
	try{
		
		CellReference passwordCellRef = new CellReference("G2");  //password
		Row passwordRow = sheet.getRow(passwordCellRef.getRow());	
		Cell passwordCell = passwordRow.getCell(passwordCellRef.getCol());
		agentPass = passwordCell.getRichStringCellValue().getString();
		
	}
		catch(NullPointerException e){	
			System.out.println();
			System.out.println("Empty password cell, proceeding without agent password");
//			e.printStackTrace();
			
		}
		if(agentPass!=null){
		System.out.println(agentPass);
		driver.findElement(By.name("password")).sendKeys(agentPass);
	}
	
}

public static void clickContinue() throws InterruptedException{
	
	driver.findElement(By.xpath("//button[@name='continue']")).click();
	Thread.sleep(1000);
}

public static void main(String[] args) throws Exception {  //use for debugging
	 
//	urlSelectorClient test = new urlSelectorClient();
	
	urlSelectorClient.getURL();
	loginFill(siteURL);
	passFill();
	clickContinue();
	
//	driver.quit();
	
	
	
}
}
