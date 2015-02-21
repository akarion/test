package com.test.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class checkResponseTimeIE {

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

		// Firefox driver is included to default selenium package

		WebDriver driver;
		driver = new InternetExplorerDriver();

		Thread.sleep(10000);

		driver.get("http://interface.test.gta-travel.com/site04/Enter.jsp");
		driver.switchTo().frame("Main"); // switches to needed frame

		driver.findElement(By.linkText("Sign On/Register")).click();

		driver.findElement(
				By.xpath("//html/body/form/table[2]/tbody/tr[2]/td[2]/nobr/input"))
				.sendKeys("1126");
		Select Licence = new Select(driver.findElement(By
				.xpath("//html/body/form/table[2]/tbody/tr[3]/td[2]/select")));
		Licence.selectByVisibleText("Type 3");
		driver.findElement(By.name("licenseNumber")).sendKeys("3");
		driver.findElement(By.name("email")).sendKeys(
				"dmitry.gromov@gta-travel.com");
		driver.findElement(By.xpath("//button[@name='continue']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("freeFormatCityEntry")).sendKeys(
				"New York, United States");
		Thread.sleep(1000);
		driver.findElement(By.id("freeFormatCityEntry")).sendKeys("\n");
		driver.findElement(By.id("arrivalFieldInput")).sendKeys("28/04/2014");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(.,'28')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("freeFormatCityEntry")).sendKeys("\n");
		driver.findElement(By.xpath("//a[contains(.,'Add room')]")).click();
		driver.findElement(By.xpath("//a[contains(.,'Add room')]")).click();
		driver.findElement(By.xpath("//a[contains(.,'Add room')]")).click();
		driver.findElement(By.xpath("//a[contains(.,'Add room')]")).click();
		driver.findElement(By.xpath("//a[contains(.,'Add room')]")).click();
		driver.findElement(By.xpath("//a[contains(.,'Add room')]")).click();
		driver.findElement(By.xpath("//a[contains(.,'Add room')]")).click();
		driver.findElement(By.xpath("//a[contains(.,'Add room')]")).click();
		Select adultsOne = new Select(driver.findElement(By.name(("adults_1"))));
		adultsOne.selectByVisibleText("1");
		Select adultsTwo = new Select(
				driver.findElement(By
						.xpath(("//html/body/div/div/form/div[4]/div[6]/table/tbody/tr[3]/td[2]/select"))));
		adultsTwo.selectByVisibleText("1");
		Select adultsThree = new Select(
				driver.findElement(By
						.xpath(("//html/body/div/div/form/div[4]/div[6]/table/tbody/tr[4]/td[2]/select"))));
		adultsThree.selectByVisibleText("1");
		Select adultsFour = new Select(
				driver.findElement(By
						.xpath(("//html/body/div/div/form/div[4]/div[6]/table/tbody/tr[5]/td[2]/select"))));
		adultsFour.selectByVisibleText("1");
		Select adultsFive = new Select(
				driver.findElement(By
						.xpath(("//html/body/div/div/form/div[4]/div[6]/table/tbody/tr[6]/td[2]/select"))));
		adultsFive.selectByVisibleText("1");
		Select adultsSix = new Select(
				driver.findElement(By
						.xpath(("//html/body/div/div/form/div[4]/div[6]/table/tbody/tr[7]/td[2]/select"))));
		adultsSix.selectByVisibleText("1");
		Select adultsSeven = new Select(
				driver.findElement(By
						.xpath(("//html/body/div/div/form/div[4]/div[6]/table/tbody/tr[8]/td[2]/select"))));
		adultsSeven.selectByVisibleText("1");
		Select adultsEight = new Select(
				driver.findElement(By
						.xpath(("//html/body/div/div/form/div[4]/div[6]/table/tbody/tr[9]/td[2]/select"))));
		adultsEight.selectByVisibleText("1");
		Select adultsNine = new Select(
				driver.findElement(By
						.xpath(("//html/body/div/div/form/div[4]/div[6]/table/tbody/tr[10]/td[2]/select"))));
		adultsNine.selectByVisibleText("1");
		long start = System.currentTimeMillis();
		driver.findElement(By.xpath("//button[@name='search']")).click();

		// WebElement myDynamicElement = (new WebDriverWait(driver, 10))
		//		.until(ExpectedConditions.presenceOfElementLocated(By
			//			.cssSelector("#hotel0 > tbody > tr:nth-child(2) > td:nth-child(2) > div > a")));

		long finish = System.currentTimeMillis();
		long totalTime = (finish - start) / 1000;
		System.out.println("Total Time for page load (first search) - "
				+ totalTime);
	}

}
