package com.test.demo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class cacheTimeFrameCheck extends Methods {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.ie.driver",
				"C:\\IEDriverServer_Win32_2.41.0\\IEDriverServer.exe"); 
		System.setProperty("webdriver.chrome.driver",
				"C:\\ChromeDriver\\ChromeDriver.exe");

		
		WebDriver driver;
		driver = new FirefoxDriver();
    	driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Methods niceMethods = new Methods();
		Calendar.getInstance();
		
		
		
		niceMethods.loginCC2("lcp29s", "sawa", driver);
		
		
		Select currency = new Select(driver.findElement(By
				.name("currency")));
		currency.selectByVisibleText("euro");
		
		Select country = new Select(driver.findElement(By
				.name("cntySelection")));
		country.selectByVisibleText("France");
		
		Thread.sleep(3000);
		
		Select city = new Select(driver.findElement(By
				.name("cityCode")));
		city.selectByVisibleText("Nice & Surrounding Area, France");
		
		Select dep = new Select(driver.findElement(By
				.name("departureDay")));
		dep.selectByVisibleText("27");
		
		driver.findElement(By.name("search")).click();
		
		String timeStamp = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
		
		int i;
		
		
		String newPrice;
		String oldPrice = "€1.50";
		System.out.println("Grand Aston Hotel, Nice");
		System.out.println("Initial price: "+oldPrice);
		
		System.out.println("Current time: "+timeStamp);
		System.out.println("Test will start in...");
		for(i=10; i>0; i--){
			System.out.println(i);
			Thread.sleep(1000);
			
		}
		do{
			driver.findElement(By.name("search")).click();
			
			Thread.sleep(5000);
			newPrice = driver.findElement(By.cssSelector("#FullDetails1 > table:nth-child(4) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(4) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(6) > span:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > nobr:nth-child(1) > a:nth-child(1)")).getText();
			timeStamp = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
			System.out.println("Current time: "+timeStamp+" Current value: "+newPrice);
		}
		while(oldPrice.equals(newPrice));
		
		System.out.println("Price changed at: "+timeStamp);
		
		
}

}