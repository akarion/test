package com.test.demo;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

// @SuppressWarnings("unused")

public class Webtrends_Form_and_Submission extends Methods{

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.ie.driver",
				"C:\\IEDriverServer_Win32_2.41.0\\IEDriverServer.exe"); 
		System.setProperty("webdriver.chrome.driver",
				"C:\\ChromeDriver\\ChromeDriver.exe");

		
		
		
		

		WebDriver driver;
		int count = 1;
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
			
		
	    Methods niceMethods = new Methods();
	    niceMethods.loginSIT(1126, 3, 3, "dmitry.gromov@gta-travel.com", "E", driver);
	    
	    do{
	    driver.findElement(By.xpath("//html/body/div[1]/div[1]/div[2]/div[4]/a")).click();
	    Thread.sleep(1000);
	    String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
	    String subWindowHandler = null;

	    Set<String> handles = driver.getWindowHandles(); // get all window handles
	    Iterator<String> iterator = handles.iterator();
	    while (iterator.hasNext()){
	        subWindowHandler = iterator.next();
	    }
	    driver.switchTo().window(subWindowHandler); // switch to popup window
	                                                // perform operations on popup
	    driver.findElement(By.id("00N20000002HZ5L")).sendKeys("1126");
	    driver.findElement(By.xpath("//input[@id='00N2000000319H8']")).sendKeys("123456789");
	    driver.findElement(By.xpath("//input[@id='00N20000002HZ5k']")).sendKeys("Dmitry Gromov");
	    driver.findElement(By.xpath("//input[@id='00N20000003BKYZ']")).sendKeys("Dmitry Agent");
	    driver.findElement(By.xpath("//input[@id='email']")).sendKeys("dmitry.gromov@gta-travel.com");
	    driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("0-000-000-0000");
	    driver.findElement(By.xpath("//input[@id='00N20000003BKWd']")).sendKeys("25/07/2014");
	    driver.findElement(By.xpath("//input[@id='subject']")).sendKeys("Webtrends Test");
	    driver.findElement(By.name("description")).sendKeys("This is automated script. It will submit the form 50 times in a row in order to see if Webtrends pick up that info ");
	    
	    
	    driver.findElement(By.id("submitBtn")).click();
	    System.out.println("Count so far: "+count);
	    driver.findElement(By.name("closeBtn")).click();
	    driver.switchTo().window(parentWindowHandler);
	    Thread.sleep(1500);
	    driver.switchTo().frame("Main");
	    	    	    
//        System.out.println("Window URL:"+driver.getCurrentUrl());
	    count++;
	    }
	    while(count <=50);
	   
	    
	    
//		System.exit(1);
		}
		
		
	}

