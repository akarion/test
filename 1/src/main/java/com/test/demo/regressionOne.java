package com.test.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class regressionOne extends Methods {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.ie.driver",
				"C:\\IEDriverServer_Win32_2.41.0\\IEDriverServer.exe"); 
		System.setProperty("webdriver.chrome.driver",
				"C:\\ChromeDriver\\ChromeDriver.exe");

		
		WebDriver driver;
		driver = new FirefoxDriver();
    	driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Methods niceMethods = new Methods();
		
		loginMethods.loginRBSJP(2006, 1, 1, "dmitry.gromov@gta-travel.com", null, driver);
		niceMethods.homePageSrchRTLicenceOne(1, 1, "Taipei, Taiwan", driver, 15, 17, "Oct 2014", "Oct 2014");
		driver.findElement(By.name("search")).click();
		driver.findElement(By.name("hotelName")).sendKeys("SITUJ23XMLAUTO");
		driver.findElement(By.name("search")).click();
		
		int stepNo = 1;
		
		niceMethods.regressionHelp("16/01/2015", "17/01/2015", "Taipei", false, stepNo, driver); stepNo++;
		niceMethods.regressionHelp("17/01/2015", "18/01/2015", "Taipei", false, stepNo, driver); stepNo++;
		niceMethods.regressionHelp("18/01/2015", "19/01/2015", "Taipei", true, stepNo, driver); stepNo++;
		niceMethods.regressionHelp("20/01/2015", "21/01/2015", "Taipei", true, stepNo, driver); stepNo++; 
		niceMethods.regressionHelp("21/01/2015", "22/01/2015", "Taipei", true, stepNo, driver); stepNo++;
		niceMethods.regressionHelp("22/01/2015", "23/01/2015", "Taipei", false, stepNo, driver); stepNo++;
		niceMethods.regressionHelp("23/01/2015", "24/01/2015", "Taipei", false, stepNo, driver); stepNo++;
		niceMethods.regressionHelp("24/01/2015", "25/01/2015", "Taipei", false, stepNo, driver); stepNo++;
		niceMethods.regressionHelp("25/01/2015", "26/01/2015", "Taipei", false, stepNo, driver); stepNo++;
		niceMethods.regressionHelp("27/01/2015", "28/01/2015", "Taipei", false, stepNo, driver); stepNo++;
		
		System.out.println("End of Pax test");
		System.out.println("");
		System.out.println("------------------------");
		System.out.println("");
		driver.quit();
		driver = new FirefoxDriver();
    	driver.manage().window().maximize();
    	
    	loginMethods.loginRBSJP(1993, 1, 1, "dmitry.gromov@gta-travel.com", null, driver);
    	stepNo = 1;
		
    	niceMethods.homePageSrchRTLicenceOne(1, 1, "Taipei", driver, 15, 16, "Jan 2015", "Jan 2015");
    	driver.findElement(By.name("search")).click();
		driver.findElement(By.name("hotelName")).sendKeys("SITUJ23XMLAUTO");
		driver.findElement(By.name("search")).click();
	
		niceMethods.regressionHelpRT("Taipei", true, stepNo, driver, 16, 17, "Jan 2015", "Jan 2015"); stepNo++;
		niceMethods.regressionHelpRT("Taipei", false, stepNo, driver, 17, 18, "Jan 2015", "Jan 2015"); stepNo++;
		niceMethods.regressionHelpRT("Taipei", true, stepNo, driver, 18, 19, "Jan 2015", "Jan 2015"); stepNo++;
		niceMethods.regressionHelpRT("Taipei", true, stepNo, driver, 20, 21, "Jan 2015", "Jan 2015"); stepNo++;
		niceMethods.regressionHelpRT("Taipei", true, stepNo, driver, 21, 22, "Jan 2015", "Jan 2015"); stepNo++;
		niceMethods.regressionHelpRT("Taipei", false, stepNo, driver, 22, 23, "Jan 2015", "Jan 2015"); stepNo++;
		niceMethods.regressionHelpRT("Taipei", false, stepNo, driver, 23, 24, "Jan 2015", "Jan 2015"); stepNo++;
		niceMethods.regressionHelpRT("Taipei", false, stepNo, driver, 24, 25, "Jan 2015", "Jan 2015"); stepNo++;
		niceMethods.regressionHelpRT("Taipei", false, stepNo, driver, 25, 26, "Jan 2015", "Jan 2015"); stepNo++;
		niceMethods.regressionHelpRT("Taipei", false, stepNo, driver, 27, 28, "Jan 2015", "Jan 2015"); stepNo++;
		
		System.out.println("End of Roomtype test");
	
	
	
	
}}
