package com.test.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@SuppressWarnings("unused")
public class bookingRouteOne extends Methods{
	
	public static void main(String[] args) throws Exception {
	
	System.setProperty("webdriver.ie.driver",
			"C:\\IEDriverServer_Win32_2.41.0\\IEDriverServer.exe"); 
	System.setProperty("webdriver.chrome.driver",
			"C:\\ChromeDriver\\ChromeDriver.exe");

	

    Methods niceMethods = new Methods();
    int numOfTimes = 0;
    
    while(numOfTimes < 10){
    	WebDriver driver;
    	driver = new FirefoxDriver();
    	driver.manage().window().maximize();
    niceMethods.loginSIT(1126, 3, 3, "dmitry.gromov@gta-travel.com","E" , driver);
    niceMethods.homePageSrchPaxNRooms(5, 1, "Madrid", driver, "01-02-2015", "05-02-2015", 1);
    driver.findElement(By.name("search")).click();
    niceMethods.startBooking(false, "1", driver);
    niceMethods.passengerDetails(1, driver);
    driver.findElement(By.name("book")).click();
    driver.switchTo().frame("Main");
    driver.findElement(By.name("proceedBtm")).click();
    driver.switchTo().frame("Main");
    driver.findElement(By.xpath("//a[contains(@onclick,'return sbm();')]")).click();
    numOfTimes++;
    driver.quit();
    }
	}
}
