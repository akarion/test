package com.test.demo;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class callCentreChecks extends Methods {

	 public static void main(String[] args) throws Exception {


	        System.setProperty("webdriver.ie.driver","C:\\IEDriverServer_Win32_2.41.0\\IEDriverServer.exe");    //Sets the location of Chromedriver and IEdriver
	        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\ChromeDriver.exe");
	       
	        //Firefox driver is included to default selenium package
	        
	        WebDriver driver;
	        int browsers = 1;
	        		while(browsers <=3){
	        			if(browsers ==1 ){
		             driver = new FirefoxDriver();}
	        			else if(browsers == 2){
	        				driver = new ChromeDriver();
	        			}
	        			else{
	        				driver = new InternetExplorerDriver();
	        				Thread.sleep(5000);
	        			}
	        		
	        			String names[] = {"Dmitry","Vladimir","Boris","Ivan","Victor","Elena","Anastasia","Natalia","Maria","Dasha","Victoria","Olga"};
	        			String titles[] = {"the Cute","the Mad","the Mighty","the Fool","Fish","Cake","the Bad","Cheerful","the Immortal","of Kuoni","the Brave","Random"};
	        			
	        			int nameIndex = new Random().nextInt(names.length);
	        			String randomName = (names[nameIndex]);
	        			
	        			int titleIndex = new Random().nextInt(titles.length);
	        			String randomTitle = (titles[titleIndex]);
	        			
	        Thread.sleep(3000);
	                
	            //String siteName = "http://interface.test.gta-travel.com/site04/Enter.jsp?siteid=ccj";
	            driver.manage().window().maximize();	
	            driver.get("http://interface.test.gta-travel.com/site23/Enter.jsp?siteid=cc4");
	            driver.switchTo().frame("Main"); //switches to needed frame
	            
	            driver.findElement(By.name("user")).sendKeys("lcp29s");
	            
	            driver.findElement(By.name("password")).sendKeys("sawa");
	            
	            driver.findElement(By.name("continue")).click();
	            Thread.sleep(3000);
	            
	            driver.findElement(By.linkText("Quick Entry")).click();
	            Thread.sleep(1000);
	           
	            driver.findElement(By.name("client")).sendKeys("1126");
	            driver.findElement(By.name("iata")).sendKeys("3");
	            driver.findElement(By.name("formEmail")).sendKeys("dmitry.gromov@gta-travel.com");
	            driver.findElement(By.name("continue")).click();
	            Thread.sleep(1000);
	            
	            Select currency = new Select(driver.findElement(By.name("currencySelection")));
	            currency.selectByIndex(1);
	            driver.findElement(By.name("cityCode")).sendKeys("NYC");
	            driver.findElement(By.name("hotelCode")).sendKeys("MARH");
	            
	            Select checkinMonth = new Select(driver.findElement(By.id("arrivalDate")));
	            checkinMonth.selectByIndex(5);
	            
	            int indexOne = (int) (Math.random()*9);
	            Thread.sleep(1000);
	            Select nights = new Select(driver.findElement(By.name("Nts")));
	            nights.selectByIndex(indexOne);
	            Thread.sleep(1000);
	           
	            // int indexTwo = (int) (Math.random()*8);
	            Select roomOne = new Select(driver.findElement(By.name("Room0")));
	            roomOne.selectByIndex(5);
	            boolean b = driver.getPageSource().contains("Room type");
	            if(b == true){System.out.println("Room Type search");}
	            driver.findElement(By.name("continue")).click();
	            Thread.sleep(2000);
	            
	            driver.findElement(By.name("newName0")).sendKeys(randomName +" "+ randomTitle);
	            boolean cancellationCharge = driver.getPageSource().contains("Cancellation Charge:");
	            boolean chargeConditions = driver.getPageSource().contains("Charge Conditions For Arrival");
	            if(cancellationCharge == true && chargeConditions == true){
	            	
	            	System.out.println("Charge conditions / Cancellation charge is present");
	            	} 
	            else {
	            	System.out.println("No cancellation charge present!");
	            	}
	            Thread.sleep(4000);
	            driver.findElement(By.name("sendToGTA")).click();
	           
	            
	            browsers++;
	        		} 
} } 
