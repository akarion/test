package com.test.demo;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CurrencyCheckRBSJP extends Methods {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.ie.driver",
				"C:\\IEDriverServer_Win32_2.41.0\\IEDriverServer.exe"); // Sets
																		// the
																		// location
																		// of
																		// Chromedriver
																		// and
																		// IEdriver
		System.setProperty("webdriver.chrome.driver",
				"C:\\ChromeDriver\\ChromeDriver.exe");

		// Firefox driver is included to default selenium package

		WebDriver driver;
		
		
		int indexCurrency = 1;
		
		
		while(indexCurrency < 11){
			
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.get("http://interface.test.gta-travel.com/rbsjp/Enter.jsp?&lang=S");
//		driver.switchTo().frame("Main"); // switches to needed frame
		
		
		
	//	driver.findElement(By.xpath("//html/body/table[2]/tbody/tr/td[1]/table[2]/tbody/tr/td/a")).click();

//		driver.findElement(
//				By.xpath("//input[contains(@id,'clientIdHS')]"))
//				.sendKeys("1290");
//		Select Licence = new Select(driver.findElement(By
//				.xpath("//select[@id='licenceTypeHS']")));
//		Licence.selectByIndex(3);
//		driver.findElement(By.id("licenceNumberHS")).sendKeys("3");
//		driver.findElement(By.id("emailHS")).sendKeys(
//				"dmitry.gromov@gta-travel.com");
//		driver.findElement(By.xpath("//button[@name='signOn']")).click();
		
		Methods niceMethods = new Methods();
		
		niceMethods.loginSIT(1126, 3, 3, "dmitry.gromov@gta-travel.com", "E", driver);
		Thread.sleep(1000);
		
		
		
		
		
		
		
		
	
		niceMethods.homePageSrchPaxNRooms(1, 5, "Dubai", driver, "23-07-2014", "25-07-2014", 1);
		Select currency = new Select(driver.findElement(By
				.name("currency")));
		currency.selectByIndex(indexCurrency);
		driver.findElement(By.name("search")).click();
//		driver.findElement(By.id("freeFormatCityEntry")).sendKeys(
//				"Dubai");
//		Thread.sleep(1000);
//		driver.findElement(By.id("freeFormatCityEntry")).sendKeys("\n");
//		driver.findElement(By.xpath("//button[@name='search']")).click();
		Thread.sleep(3000);
		String roomPrice = driver.findElement(By.id("price01")).getText();
		String totalPrice = driver.findElement(By.id("selecteditemprice0")).getText();
	
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		FileUtils.copyFile(scrFile, new File("c:\\SeleniumScrnshots\\screenshot"+ indexCurrency +".png"));
		
		System.out.println("Room price is: "+roomPrice+"\nTotal price is: "+totalPrice);
		indexCurrency++;
		
		
		driver.quit();
		}
		
		System.exit(0); 

	}
}
