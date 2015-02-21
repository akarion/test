package com.test.demo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.*;

public class kupi4meLogin extends Methods {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.ie.driver",
				"C:\\IEDriverServer_Win32_2.41.0\\IEDriverServer.exe"); 
		System.setProperty("webdriver.chrome.driver",
				"C:\\ChromeDriver\\ChromeDriver.exe");

		
		WebDriver driver;
		driver = new FirefoxDriver();
    	driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String timeStamp = new SimpleDateFormat("HH:mm DD/MM/YYYY").format(Calendar.getInstance().getTime());
		Random randomNum = new Random();
		
		driver.get("http://kupi4.me");
		driver.findElement(By.name("j_username")).sendKeys("gromov.d.s@gmail.com");
		driver.findElement(By.name("j_password")).sendKeys("agent007");
		driver.findElement(By.cssSelector("html body div#footer_to_bottom.start_page div#main div.wrapper div#content.start_page div.forms div.left_col button")).click();
		System.out.println("Logged in successfully");
		System.out.println("Adding a product");
		driver.findElement(By.className("b-create")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("title")).sendKeys("HP laptop");
		driver.findElement(By.id("description")).sendKeys("Autotest at: "+ timeStamp);
		driver.findElement(By.id("URL")).sendKeys("http://www.amazon.co.uk/dp/B00FYUCHCU");
		driver.findElement(By.id("price")).click();
		Thread.sleep(3000);		
		driver.findElement(By.xpath("/html/body/div[6]/section/div[3]/form/div[1]/div/p[2]/img")).click();
		Thread.sleep(1500);
		driver.findElement(By.id("price")).sendKeys(randomNum.nextInt(1300)+" GBP");
		WebElement starRating = driver.findElement(By.xpath("/html/body/div[6]/section/div[3]/form/div[2]/div[7]/span/span/a[1]"));
		Actions build = new Actions(driver);
		build.moveToElement(starRating, 90, 0).click().perform();
		driver.findElement(By.cssSelector("html body div#popupContainer section#popup-wish.l-popup-box div.switch-block form#form footer.b-form__footer button")).click();
		System.out.println("Product added");
		
		System.exit(1);
		
}

}