package com.test.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CurrencyCheck extends Methods{

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
			
		
		
		
		
	    Methods forLogin = new Methods();
	    forLogin.loginSIT(1126, 3, 3, "dmitry.gromov@gta-travel.com",null, driver);
				
		Select currency = new Select(driver.findElement(By
				.name("currency")));
		currency.selectByIndex(indexCurrency);
		
				
		driver.findElement(By.id("freeFormatCityEntry")).sendKeys(
				"Dubai");
		Thread.sleep(1000);
		driver.findElement(By.id("freeFormatCityEntry")).sendKeys("\n");
		driver.findElement(By.xpath("//button[@name='search']")).click();
		Thread.sleep(3000);
		String roomPrice = driver.findElement(By.id("price01")).getText();
		String totalPrice = driver.findElement(By.id("selecteditemprice0")).getText();
	
		System.out.println("Room price is: "+roomPrice+"\nTotal price is: "+totalPrice);
		indexCurrency++;
		driver.quit();
		}
		
		System.exit(0); 

	}
}
