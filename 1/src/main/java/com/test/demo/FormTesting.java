package com.test.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FormTesting {

	public static void main(String[] args) {
		System.setProperty("webdriver.ie.driver",
				"C:\\IEDriverServer_Win32_2.41.0\\IEDriverServer.exe"); 
		System.setProperty("webdriver.chrome.driver",
				"C:\\ChromeDriver\\ChromeDriver.exe");

		
		WebDriver driver;
		driver = new FirefoxDriver();
    	driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
		
		driver.get("http://interface.test.gta-travel.com/site23/EmailUs.jsp");
		driver.switchTo().frame("Main");
		
		driver.findElement(By.id("00N20000002HZ5L")).sendKeys(""); //Agent ID
		driver.findElement(By.id("00N2000000319H8")).sendKeys("123456789"); //Booking ID
		driver.findElement(By.id("00N20000002HZ5k")).sendKeys("0bJNCPB1ctuOGwkc89X0H2cbQAmvHUxrs3oupWiOp3beUR9TDO"); //Client name
		driver.findElement(By.id("company")).sendKeys("OWBxyImmjcnuUjCoVWy9m50ClCOLNpmPDaW3MagTprRdOJ5Wxau1qDIabWF11vNKNmzV9wurjFboMIOV"); //Travel Agency name
		driver.findElement(By.id("00N20000003BKYZ")).sendKeys("ZXJjxpDflowJu9RLpaPXt0YRWjy078ToTjkAPsGJPWGpMRxtueU5jOEicKPremIX9UXujN3XmXT6280UfOzvgvNTZZb5sZ2jTovKSmRTKl6ikfY4IxGlWWkD");//Trvel Agent name
		
	}

}
