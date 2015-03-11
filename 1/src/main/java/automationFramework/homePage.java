package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.WebElementHandler;
import org.openqa.selenium.support.ui.Select;

public class homePage {

	private static WebDriver driver;



//	public homePage(WebDriver driver){	
//		this.driver = driver;
//	}
	
public static void selectCurrency(String curency){
	
	
	
	
}
	
	
	
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
	
	Select arrMonthYear = new Select(driver.findElement(By.name("arrivalDate"))); // change this!!!!!!!!11
	
	if  (x==0){
	System.out.println("Can't choose index 0 as it is empty in the dropdown, selecting index 1 (current month and year)");
	x = 1;
	}
	arrMonthYear.selectByIndex(x);	
    String selected = arrMonthYear.getFirstSelectedOption().getText();
	
	System.out.println("Selected value is: "+selected);
	
	}

public static void depMonthYear(int x){
	
	Select depMonthYear = new Select(driver.findElement(By.name("departureDate"))); // change this!!!!!!!!11
	System.out.println("Selecting by index value of: "+x);
	
	if  (x==0){
	System.out.println("Can't choose index 0 as it is empty in the dropdown, selecting index 1 (current month and year)");
	x = 1;
	}
	
	depMonthYear.selectByIndex(x);
	
	String selected = depMonthYear.getFirstSelectedOption().getText();
	
	System.out.println("Selected value is: "+selected);
		
		
	}

public static void selectRoomTypeRoom(int x){
	
	Select roomType = new Select(driver.findElement(By.name("Room0")));
	System.out.println("Selecting by index value of: "+x);
	if  (x==0 || x>10 ){
		System.out.println("Can't choose index value 0 or >10, selecting index 1 (twin bedroom)");
		x = 1;
		}
	roomType.selectByIndex(x);
	
	String selected = roomType.getFirstSelectedOption().getText();
	
	System.out.println("Selected value is: "+selected);
	
}

public static void selectNumberOfRoomsRT(int x){   //rework to apply >1 rooms
	
	Select roomCount = new Select(driver.findElement(By.name("Room0Count")));
	System.out.println("Selecting by index value of: "+x);
	if  (x<=0 | x>9){
		System.out.println("Can't choose index 0 or >9, selecting index 1 with a vlalue of 1");
		x = 1;
		}
	roomCount.selectByIndex(x);
	
    String selected = roomCount.getFirstSelectedOption().getText();
	
	System.out.println("Selected value is: "+selected);
	
}

public static void selectCots(int x){
	
	Select cotCount = new Select(driver.findElement(By.name("Room0Cots")));
	System.out.println("Selecting by index value of: "+x);
	
	if(x > 3 || x<=0){
		System.out.println("Can't choose index whic is <=0 ,setting to 1 ");
		x = 1;		
	}
	cotCount.selectByIndex(x);
    String selected = cotCount.getFirstSelectedOption().getText();
	
	System.out.println("Selected value is: "+selected);
	
}


}
	
	
	
	
	
