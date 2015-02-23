

package com.test.demo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class Demo {
    // Here's the element

    public static void main(String[] args) throws Exception {


        System.setProperty("webdriver.ie.driver","C:\\IEDriverServer_Win32_2.41.0\\IEDriverServer.exe");    //Sets the location of Chromedriver and IEdriver
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\ChromeDriver.exe");
       
        //Firefox driver is included to default selenium package


        int browser = 1;
        WebDriver driver;

        while (browser <= 3) {
            if (browser == 1) {
                driver = new FirefoxDriver();
                System.out.println("Browser: Firefox");
            } else if (browser == 2) {
                 driver = new ChromeDriver();
                 System.out.println("Browser: Google Chrome");
            } else {
                driver = new InternetExplorerDriver();
                System.out.println("Browser: Internet Explorer");
            }


            driver.get("http://interface.test.gta-travel.com/rbsjp/Enter.jsp");
            driver.switchTo().frame("Main"); //switches to needed frame
            driver.findElement(By.linkText("Sign On/Register")).click();

            driver.findElement(By.xpath("//html/body/form/table[2]/tbody/tr[2]/td[2]/nobr/input")).sendKeys("1126");
            Select Licence = new Select(driver.findElement(By.xpath("//html/body/form/table[2]/tbody/tr[3]/td[2]/select")));
            Licence.selectByVisibleText("Type 3");
            driver.findElement(By.name("licenseNumber")).sendKeys("3");
            driver.findElement(By.name("email")).sendKeys("dmitry.gromov@gta-travel.com");
            driver.findElement(By.xpath("//button[@name='continue']")).click();
            Thread.sleep(1000);

            Select Nationality = new Select(driver.findElement(By.xpath("//select[@name='country']"))); //object for a dropdown?
            Nationality.selectByVisibleText("United Kingdom");
            driver.findElement(By.id("freeFormatCityEntry")).sendKeys("Sydney, Australia"); //Here you can change the city where you are looki8ng for accommodation
            Thread.sleep(3000);
            driver.findElement(By.id("freeFormatCityEntry")).sendKeys("\n"); // \n = press ENTER
            driver.findElement(By.xpath("//button[@name='search']")).click();
            Thread.sleep(4000); // Makes Selenium to wait for 4000ms before moving to the next action
            String firstHotel = driver.findElement(By.xpath("//html/body/table/tbody/tr/td[3]/form/div[2]/div[3]/div/div[2]/div/table/tbody/tr/td/table/tbody/tr[2]/td[2]/div/a/span")).getText();
            // assertEquals(firstHotel, "Vulcan");
            if (firstHotel.equals("Vulcan")) {
                System.out.println("Name of the first hotel is correct: " + firstHotel);
            } else {
                System.out.println("Expected name is Vulcan. Actual name is: " + firstHotel);
            }
            Thread.sleep(5000); //10 sec wait
            driver.close();
            browser++;
            if(browser>3){System.out.println("End of tests.");}
        }
    }
}
