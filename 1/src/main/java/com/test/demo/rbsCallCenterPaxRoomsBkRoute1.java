package com.test.demo;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


@SuppressWarnings("unused")
public class rbsCallCenterPaxRoomsBkRoute1 extends Methods {

	public static void main(String[] args) throws Exception {
	
	System.setProperty("webdriver.ie.driver",
			"C:\\IEDriverServer_Win32_2.41.0\\IEDriverServer.exe"); 
	System.setProperty("webdriver.chrome.driver",
			"C:\\ChromeDriver\\ChromeDriver.exe");
	Methods niceMethods = new Methods();
	WebDriver driver;	
	driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	
	Calendar calendar = Calendar.getInstance();
	String day = Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
	String dayTwo = Integer.toString(calendar.get(Calendar.DAY_OF_MONTH)+2);
	
	
	
	
	
			loginMethods.loginRBSJPcc("lcp41s", "dmitry", driver);
			
			niceMethods.uatCChomepageSearch("1126", 1, 1, "London, United", day, dayTwo, 3, 3, driver);
			
//			niceMethods.createRooms(1, driver);
			niceMethods.popRoomPAX(1, 1, 0, 0, driver);		
			
			niceMethods.clickSearch(driver);
			
			for(int x=1;x<=5;x++){

			niceMethods.starRatingFilter(x, driver);
			niceMethods.clickSearch(driver);			
			niceMethods.verifyStarRating(x, driver);
			
			System.out.println();
			System.out.println("------------------------------------------------------");
			System.out.println();
			System.out.println();
			}
			
			
			
			
	
	
	}}
