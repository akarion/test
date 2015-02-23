package com.test.demo;

import java.sql.Driver;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

@SuppressWarnings("unused")
public class loginMethods {

	public static int startRooms = 1;
	public static int inexNumber = 1;
	
	Random randomNum = new Random();
	
	public static void loginRBSJP(int agentID, int licenceTypeIndex, int licenceNumber, String agentEmail, String countryCode, WebDriver driver) throws Exception {
		
		driver.get("http://interface.test.gta-travel.com/rbsjp/Enter.jsp?&lang="+countryCode);
		driver.switchTo().frame("Main"); // switches to needed frame
		Thread.sleep(5000);
		
       String agentIdString = Integer.toString(agentID);
       // String agentLicenceType = Integer.toString(licenceTypeIndex);
       String agentLicenceNumber = Integer.toString(licenceNumber);
       
      	
		driver.findElement(
				By.xpath("//input[@id='clientIdHS']"))
				.sendKeys(agentIdString);
		Select Licence = new Select(driver.findElement(By
				.xpath("//select[@id='licenceTypeHS']")));
		Licence.selectByIndex(licenceTypeIndex);
		driver.findElement(By.name("licenseNumber")).sendKeys(agentLicenceNumber);
		driver.findElement(By.name("email")).sendKeys(
				agentEmail);
		driver.findElement(By.xpath("//button[@id='loginButtonHS']")).click();
		Thread.sleep(1000);
		
		
	}
	
public static void loginRBSJPcc(String ccName,String ccPass, WebDriver driver) throws Exception {
		
		driver.get("http://interface.test.gta-travel.com/rbsjp/enter.jsp?siteid=PAXCC");
		driver.switchTo().frame("Main") ;// switches to needed frame
		driver.findElement(By.xpath("//html/body/form[1]/table/tbody/tr[1]/td[2]/input")).sendKeys(ccName);
		driver.findElement(By.xpath("//html/body/form[1]/table/tbody/tr[2]/td[2]/input")).sendKeys(ccPass);
		driver.findElement(By.name("continue")).click();
		Thread.sleep(3000);
			
	}

public void loginSIT(int agentID, int licenceTypeIndex, int licenceNumber, String agentEmail, String countryCode, WebDriver driver) throws Exception {
		

		driver.get("http://interface.test.gta-travel.com/site23/Enter.jsp?&lang="+countryCode);
		driver.switchTo().frame("Main"); // switches to needed frame
		Thread.sleep(3000);
		
	       String agentIdString = Integer.toString(agentID);
	      //  String agentLicenceType = Integer.toString(licenceTypeIndex);
	       String agentLicenceNumber = Integer.toString(licenceNumber);
	       
	       driver.findElement(By.xpath("//html/body/table[2]/tbody/tr/td/table[2]/tbody/tr/td/a")).click();
	       driver.findElement(
					By.xpath("//html/body/form/table[2]/tbody/tr[2]/td[2]/nobr/input"))
					.sendKeys(agentIdString);
			Select Licence = new Select(driver.findElement(By
					.xpath("//html/body/form/table[2]/tbody/tr[3]/td[2]/select")));
			Licence.selectByIndex(licenceTypeIndex);
			driver.findElement(By.name("licenseNumber")).sendKeys(agentLicenceNumber);
			driver.findElement(By.name("email")).sendKeys(
					"dmitry.gromov@gta-travel.com");
			driver.findElement(By.xpath("//button[@name='continue']")).click();
			Thread.sleep(1000);
	}
	
	public static void loginCC2(String login, String pass, WebDriver driver) throws Exception{
		
		driver.get("http://interface.test.gta-travel.com/site23/Enter.jsp?siteid=cc2");
		driver.switchTo().frame("Main"); // switches to needed frame
		Thread.sleep(1000);
		
		driver.findElement(By.name("user")).sendKeys("lcp29s");
		driver.findElement(By.name("password")).sendKeys("sawa");
		driver.findElement(By.name("continue")).click();
		
	}
	
	public void stageLogin(int agentID, int licenceTypeIndex, int licenceNumber, String agentEmail, String countryCode, WebDriver driver) throws Exception{
		
		driver.get("http://interface.demo.gta-travel.com/rbsjp/Enter.jsp?&lang="+countryCode);
		driver.switchTo().frame("Main"); // switches to needed frame
		Thread.sleep(3000);
		
	       String agentIdString = Integer.toString(agentID);
	      //  String agentLicenceType = Integer.toString(licenceTypeIndex);
	       String agentLicenceNumber = Integer.toString(licenceNumber);
	       
	       driver.findElement(By.xpath("//html/body/table[2]/tbody/tr/td/table[2]/tbody/tr/td/a")).click();
	       driver.findElement(
					By.xpath("//html/body/form/table[2]/tbody/tr[2]/td[2]/nobr/input"))
					.sendKeys(agentIdString);
			Select Licence = new Select(driver.findElement(By
					.xpath("//html/body/form/table[2]/tbody/tr[3]/td[2]/select")));
			Licence.selectByIndex(licenceTypeIndex);
			driver.findElement(By.name("licenseNumber")).sendKeys(agentLicenceNumber);
			driver.findElement(By.name("email")).sendKeys(
					"dmitry.gromov@gta-travel.com");
			driver.findElement(By.xpath("//button[@name='continue']")).click();
			Thread.sleep(1000);
		
	}	
}
	
 
