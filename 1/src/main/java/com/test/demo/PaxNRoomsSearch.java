package com.test.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

// @SuppressWarnings("unused")

public class PaxNRoomsSearch extends Methods{

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.ie.driver",
				"C:\\IEDriverServer_Win32_2.41.0\\IEDriverServer.exe"); 
		System.setProperty("webdriver.chrome.driver",
				"C:\\ChromeDriver\\ChromeDriver.exe");

		
		
		
		

		WebDriver driver;
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
			
		
	    Methods niceMethods = new Methods();
	    niceMethods.loginSIT(1126, 3, 3, "dmitry.gromov@gta-travel.com", "E", driver);
	    niceMethods.homePageSrchPaxNRooms(5, 1, "New york, United states", driver, "30/08/2014","11/09/2014", 1);  
	    int Rooms = startRooms;
	    System.out.println("Num of rooms:" +Rooms);
	    
	    
//	    niceMethods.populateRooms(Rooms, driver);
	    driver.findElement(By.name("search")).click();
	    
	    niceMethods.startBooking(false, "3", driver);
	    
	    niceMethods.passengerDetails(1, driver);
	    driver.findElement(By.name("book")).click();	
	    
	    Thread.sleep(1000);
	    
	    driver.switchTo().frame("Main");
	    driver.findElement(By.name("proceedBtm")).click();
	    
	    Thread.sleep(1500);
	  
		
	    driver.switchTo().frame("Main");
	    driver.findElement(By.xpath("//a[contains(@onclick,'return sbm();')]")).click();
	   
		Thread.sleep(3000);
		System.exit(1);
		}
		
		
	}

