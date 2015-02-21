package com.test.demo;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


@SuppressWarnings("unused")
public class rbsCallCenterPaxRoomsBkRoute1 {

	public static void main(String[] args) throws Exception {
	
//	System.setProperty("webdriver.ie.driver",
//			"C:\\IEDriverServer_Win32_2.41.0\\IEDriverServer.exe"); 
//	System.setProperty("webdriver.chrome.driver",
//			"C:\\ChromeDriver\\ChromeDriver.exe");
	WebDriver driver;	
	driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Methods niceMethods = new Methods(driver);

	
	Calendar calendar = Calendar.getInstance();
	String day = Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
	String dayTwo = Integer.toString(calendar.get(Calendar.DAY_OF_MONTH)+2);
	
	
	
			//Methods.loginRBSJPcc("lcp41s", "dmitry", driver);
	
			niceMethods.loginRBSJPcc("lcp41s", "dmitry");
			niceMethods.setHuj(1);
			niceMethods.huj = 1;
			/*
			niceMethods.uatCChomepageSearch("1126", 1, 1, "London, United", day, dayTwo, 3, 3, driver);
			
//			niceMethods.createRooms(1, driver);
			niceMethods.popRoomPAX(1, 1, 0, 0, driver);		
			
			niceMethods.clickSearch(driver);
			
			niceMethods.starRatingFilter(3, driver);
			niceMethods.clickSearch(driver);
			
			niceMethods.verifyStarRating(2, driver);
			
			*/
			
			
	
	
	}}
