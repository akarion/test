package com.test.demo;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@SuppressWarnings("unused")
public class InsuranceReportBookings extends Methods{
	
	public static void main(String[] args) throws Exception {
	
	System.setProperty("webdriver.ie.driver",
			"C:\\IEDriverServer_Win32_2.41.0\\IEDriverServer.exe"); 
	System.setProperty("webdriver.chrome.driver",
			"C:\\ChromeDriver\\ChromeDriver.exe");

	

    Methods niceMethods = new Methods();
    int numOfTimes = 1;
    int paxNum;
    int dayStart = 21;
    int dayEnd = 23;
    WebDriver driver;
    while(numOfTimes <= 20){
    	
    	driver = new FirefoxDriver();
    	driver.manage().window().maximize();
    niceMethods.loginRBSJP(1126, 3, 3, "dmitry.gromov@gta-travel.com", "E", driver);
    niceMethods.homePageSrchPaxNRooms(5, 1, "Madrid", driver, ""+dayStart+"/12/2014", ""+dayEnd+"/12/2014", 1);
    driver.findElement(By.name("search")).click();
    niceMethods.startBooking(false, "1", driver);
    niceMethods.passengerDetails(1, driver);
    driver.findElement(By.name("book")).click();
    Thread.sleep(2500);
    driver.switchTo().frame("Main");
    driver.findElement(By.xpath("//html/body/table/tbody/tr/td[2]/table[1]/tbody/tr[5]/td[7]/a")).click();
    paxNum = new Random().nextInt(1);
    driver.findElement(By.name("pax"+paxNum)).click();
    driver.findElement(By.xpath("//button[@name='continue']")).click();
    driver.findElement(By.xpath("//button[@name='proceedTop']")).click();
    driver.switchTo().frame("Main");
    System.out.println("Booking id for try "+numOfTimes+" is: "+driver.findElement(By.xpath("//html/body/table/tbody/tr/td[2]/p[1]/a")).getText());
    
    numOfTimes++;
    dayStart++;
    dayEnd++;
    
    
    driver.quit();
    }
	}
}
