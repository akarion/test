package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class homePage {

	private static WebDriver driver;



//	public homePage(WebDriver driver){	
//		this.driver = driver;
//	}
	
	
	
	public static void arrDayDropdown(int x){
		
		Select arrDay = new Select(driver.findElement(By.name("arrivalDay")));		
		String value = Integer.toString(x);
		arrDay.selectByValue(value);
						
		}
	
public static void depDayDropdown(int x){
		
		Select arrDay = new Select(driver.findElement(By.name("departureDay")));		
		String value = Integer.toString(x);
		arrDay.selectByValue(value);
						
		}

public static void arrMonthYear(int x){
	
	try{
		int index = x;
		}
		catch(DmitryException e){
			
			
			
		}
	
	System.out.println("Can't choose index 0 as it is empty in the dropdown, selecting index 1 (current month and year)");
	arrDay.selectByIndex(index);
	System.out.println(arrDay.toString());
	
	Select arrDay = new Select(driver.findElement(By.name("arrivalDate")));		
//	String value = Integer.toString(x);
	
	
					
	}
		
		
		
	}
	
	
	
	
	
