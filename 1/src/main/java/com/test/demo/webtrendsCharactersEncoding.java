package com.test.demo;

import java.sql.Driver;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@SuppressWarnings("unused")
public class webtrendsCharactersEncoding {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.ie.driver",
				"C:\\IEDriverServer_Win32_2.41.0\\IEDriverServer.exe"); // Sets
																		// the
																		// location
																		// of
																		// Chromedriver
																		// and
																		// IEdriver
		System.setProperty("webdriver.chrome.driver",
				"C:\\ChromeDriver\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		loginMethods login = new loginMethods();
		Methods method = new Methods();
		
		login.loginSIT(1126, 3, 3, "dmitry.gromov@gta-travel.com", "E", driver);
		method.homePageSrchPaxNRooms(1, 1, "Moscow", driver, "01/03/2015", "05/03/2015", 1);
		method.clickSearch(driver);
//		String array[] = method.generateName();
		String randomNamePartOne, randomNamePartTwo, randomNamePartThree;
		
//		randomNamePartOne = array[0];
//		randomNamePartTwo = array [1];
//		randomNamePartThree = array[2];
		
		int countOne = 0;
		int countTwo = 0;
		int countThree = 0;
		int countFour = 0;
		
		while (countOne<=50){
			String array[] = method.generateWord();
			randomNamePartOne = array[0];
			driver.findElement(By.id("hotelName")).clear();
			driver.findElement(By.id("hotelName")).sendKeys(randomNamePartOne);
			System.out.println("Russian Array picked: "+randomNamePartOne);
			method.clickSearch(driver);
			countOne++;
			
		}
		System.out.println();
		System.out.println();
		System.out.println("End of Russian array");
		System.out.println();
		System.out.println();
		
		while (countTwo<=50){
			String array[] = method.generateWord();
			randomNamePartTwo = array[1];
			driver.findElement(By.id("hotelName")).clear();
			driver.findElement(By.id("hotelName")).sendKeys(randomNamePartTwo);
			System.out.println("Arabic Array picked: "+randomNamePartTwo);
			method.clickSearch(driver);
			countTwo++;
			
		}
		System.out.println();
		System.out.println();
		System.out.println("End of Arabic array");
		System.out.println();
		System.out.println();
		while (countThree<=50){
			String array[] = method.generateWord();
			randomNamePartThree = array[2];
			driver.findElement(By.id("hotelName")).clear();
			driver.findElement(By.id("hotelName")).sendKeys(randomNamePartThree);
			System.out.println("Japanese Array picked: "+randomNamePartThree);
			method.clickSearch(driver);
			countThree++;
			
		}
		
		System.out.println();
		System.out.println();
		System.out.println("End of Japanese array");
		System.out.println();
		System.out.println();
		while(countFour<=50){
			String array[] = method.generateWord();
			
			randomNamePartOne = array[0];
			randomNamePartTwo = array [1];
			randomNamePartThree = array[2];
			driver.findElement(By.id("hotelName")).clear();
		driver.findElement(By.id("hotelName")).sendKeys(randomNamePartOne+" "+randomNamePartTwo+" "+randomNamePartThree);
		method.clickSearch(driver);
		countFour++;
		
		}
		System.out.println();
		System.out.println();
		System.out.println("End of Mixed array");
		System.out.println();
		System.out.println();
			
		
		driver.quit();
	}
	
	

}
