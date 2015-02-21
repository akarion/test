package com.test.demo;

import java.sql.Driver;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

@SuppressWarnings("unused")
public class Methods {

	public static int startRooms = 1;
	public static int inexNumber = 1;
	
	Random randomNum = new Random();
	
	private WebDriver driver;
	public int huj;
	
	public void setHuj(int val) {
		this.huj = val;
	}
	
	public Methods(WebDriver driver,int huj) { //constructor
		this.driver = driver;
		this.huj = huj;
	}
	
	public void loginRBSJP(int agentID, int licenceTypeIndex, int licenceNumber, String agentEmail, String countryCode, WebDriver driver) throws Exception {
		
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
	
public void loginRBSJPcc(String ccName,String ccPass) throws Exception {
		
		this.driver.get("http://interface.test.gta-travel.com/rbsjp/enter.jsp?siteid=PAXCC");
		this.driver.switchTo().frame("Main") ;// switches to needed frame
		this.driver.findElement(By.xpath("//html/body/form[1]/table/tbody/tr[1]/td[2]/input")).sendKeys(ccName);
		this.driver.findElement(By.xpath("//html/body/form[1]/table/tbody/tr[2]/td[2]/input")).sendKeys(ccPass);
		this.driver.findElement(By.name("continue")).click();
		Thread.sleep(3000);
		System.out.println("LOL");
			
	}

public void uatCChomepageSearch(String agentID, int nationalityIndex, int currencyIndex, String cityName, 
		                        String startDay, String endDay, int startMonth, int endMonth, WebDriver driver){
	
	
//	driver.switchTo().frame("Main");
	driver.findElement(By.name("agentUI")).sendKeys(agentID);
	
	Select nationality = new Select(driver.findElement(By.name("country")));
	nationality.selectByIndex(nationalityIndex);
	
	Select currency = new Select(driver.findElement(By.name("currency")));
	currency.selectByIndex(currencyIndex);
	
	driver.findElement(By.id("freeFormatCityEntry")).sendKeys(cityName);
	WebElement waitCity = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.name("freeFormatCitySelection")));
	driver.findElement(By.id("freeFormatCityEntry")).sendKeys("\n");
	
	Select fromDate = new Select(driver.findElement(By.id("arrivalDay")));
	fromDate.selectByVisibleText(startDay);
	
	Select toDate = new Select(driver.findElement(By.id("departureDay")));
	toDate.selectByVisibleText(endDay);
	
	Select fromMonth = new Select(driver.findElement(By.id("arrivalDate")));
	fromMonth.selectByIndex(startMonth);
	
	Select toMonth = new Select(driver.findElement(By.id("departureDate")));
	toMonth.selectByIndex(endMonth);
		
}

	public void clickSearch(WebDriver driver){
		
		driver.findElement(By.name("search")).click();
		
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
	
	public void homePageSrchPaxNRooms(int nationalityIndex, int currencyIndex, String cityName, WebDriver driver, String dateOfArrival, String dateOfDeparture, int numOfRooms ) throws Exception {
				
				
			    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			    Thread.sleep(500);
			    
			    Select currency = new Select(driver.findElement(By.name("currency")));
			    currency.selectByIndex(currencyIndex);
			    
			    Select nationality = new Select(driver.findElement(By.name("country")));
			    Thread.sleep(500);
			    nationality.selectByIndex(nationalityIndex);
			    
			    
			    
				driver.findElement(By.id("freeFormatCityEntry")).sendKeys(
						cityName);
				Thread.sleep(1500);
				driver.findElement(By.id("freeFormatCityEntry")).sendKeys("\n");
				
				driver.findElement(By.id("arrivalFieldInput")).clear();
				driver.findElement(By.id("arrivalFieldInput")).sendKeys(dateOfArrival);
				Thread.sleep(1000);
				driver.findElement(By.id("freeFormatCityEntry")).sendKeys("\n");
				
				driver.findElement(By.id("departureFieldInput")).clear();
				driver.findElement(By.id("departureFieldInput")).sendKeys(dateOfDeparture);
				Thread.sleep(1500);
				
				driver.findElement(By.id("freeFormatCityEntry")).sendKeys("\n");
				Thread.sleep(1000);
			
				
				
				Thread.sleep(2000);
				if (numOfRooms < 1 | numOfRooms > 9){    // less than 1 or more than 9 condition
					System.out.println("Invalid number of rooms, setting number of rooms to a random number between 1 and 9");
					numOfRooms = (int) (Math.random()*9);
					System.out.println("The number of rooms which was set is:"+numOfRooms);
					
					
				}
				while (startRooms < numOfRooms ){
				driver.findElement(By.id("freeFormatCityEntry")).sendKeys("\n");
				driver.findElement(By.xpath("//a[contains(.,'Add room')]")).click();
				startRooms = startRooms + 1;
//				return startRooms;
				} 
				driver.findElement(By.cssSelector("html body#IndexPage div#mainpage div#sidebar.sideBox form div#hhQuickSearch div#toDate div#departureField.calendarContainer nobr img.ui-datepicker-trigger")).click();

			}
			
	public void populateRooms (int numOfRooms, WebDriver driver) throws Exception{ //no longer in use
		
				int totalAdults = 0;
				int totalChildren = 0;
				int adultsArray[] = new int[9];
				int childrenArray[];
				
				int sum = 0;
				do{ 
					totalAdults = randomNum.nextInt(9);
				    
					
				}
				while((totalAdults + totalChildren) > 9 | totalAdults < numOfRooms | (totalAdults + totalChildren) < 1 | totalAdults < 1 );
				 System.out.println("Total Adults: "+ totalAdults);
				 System.out.println("Total children: "+ totalChildren);
				do{  //change to for() later
					sum = 0;
					if (adultsArray[0] == 0){ adultsArray[0] = adultsArray[0] +1;}
					Thread.sleep(1);
					adultsArray[1] = randomNum.nextInt(totalAdults);
					Thread.sleep(1);
					if (adultsArray[1] == 0){ adultsArray[1] = adultsArray[1] +1;}
					Thread.sleep(1);
					adultsArray[2] = randomNum.nextInt(totalAdults);
					if (adultsArray[2] == 0){ adultsArray[2] = adultsArray[2] +1;}
					Thread.sleep(1);
					adultsArray[3] = randomNum.nextInt(totalAdults);
					if (adultsArray[3] == 0){ adultsArray[3] = adultsArray[3] +1;}
					Thread.sleep(1);
					adultsArray[4] = randomNum.nextInt(totalAdults);
					if (adultsArray[4] == 0){ adultsArray[4] = adultsArray[4] +1;}
					Thread.sleep(1);
					adultsArray[5] = randomNum.nextInt(totalAdults);
					if (adultsArray[5] == 0){ adultsArray[5] = adultsArray[5] +1;}
					Thread.sleep(1);
					adultsArray[6] = randomNum.nextInt(totalAdults);
					if (adultsArray[6] == 0){ adultsArray[6] = adultsArray[6] +1;}
					Thread.sleep(1);
					adultsArray[7] = randomNum.nextInt(totalAdults);
					if (adultsArray[7] == 0){ adultsArray[7] = adultsArray[7] +1;}
					Thread.sleep(1);
					adultsArray[8] = randomNum.nextInt(totalAdults);
					if (adultsArray[8] == 0){ adultsArray[8] = adultsArray[8] +1;}
					
					int i = numOfRooms -1;
						
						do{
							sum = sum + adultsArray[i];
							i = i - 1;
						} while(i >= 0);
						
						
					
				
					}
				
				 while(sum != totalAdults || sum > totalAdults);
				
				
				
				Select adultsOne = new Select(driver.findElement(By.name(("adults_1"))));
				adultsOne.selectByIndex(adultsArray[0]);
				
				if (numOfRooms >1){
				Select adultsTwo = new Select(
						driver.findElement(By
								.xpath(("//html/body/div/div/form/div[4]/div[6]/table/tbody/tr[3]/td[2]/select"))));
				adultsTwo.selectByIndex(adultsArray[1]);}
				
			    if (numOfRooms > 2){
				Select adultsThree = new Select(
						driver.findElement(By
								.xpath(("//html/body/div/div/form/div[4]/div[6]/table/tbody/tr[4]/td[2]/select"))));
				adultsThree.selectByIndex(adultsArray[2]);}
			    
				if (numOfRooms > 3){
				Select adultsFour = new Select(
						driver.findElement(By
								.xpath(("//html/body/div/div/form/div[4]/div[6]/table/tbody/tr[5]/td[2]/select"))));
				adultsFour.selectByIndex(adultsArray[3]);}
				if (numOfRooms > 4){
				Select adultsFive = new Select(
						driver.findElement(By
								.xpath(("//html/body/div/div/form/div[4]/div[6]/table/tbody/tr[6]/td[2]/select"))));
				adultsFive.selectByIndex(adultsArray[4]);}
				
				if (numOfRooms > 5){
				Select adultsSix = new Select(
						driver.findElement(By
								.xpath(("//html/body/div/div/form/div[4]/div[6]/table/tbody/tr[7]/td[2]/select"))));
				adultsSix.selectByIndex(adultsArray[5]);}
				
				if (numOfRooms > 6){				
				Select adultsSeven = new Select(
						driver.findElement(By
								.xpath(("//html/body/div/div/form/div[4]/div[6]/table/tbody/tr[8]/td[2]/select"))));
				adultsSeven.selectByIndex(adultsArray[6]);}
				
				if (numOfRooms > 7){
				Select adultsEight = new Select(
						driver.findElement(By
								.xpath(("//html/body/div/div/form/div[4]/div[6]/table/tbody/tr[9]/td[2]/select"))));
				adultsEight.selectByIndex(adultsArray[7]);}
				if (numOfRooms > 8){
				Select adultsNine = new Select(
						driver.findElement(By
								.xpath(("//html/body/div/div/form/div[4]/div[6]/table/tbody/tr[10]/td[2]/select"))));
				adultsNine.selectByIndex(adultsArray[8]);}
				
				
				
				
				
				
			}

	public void createRooms (int number, WebDriver driver) throws InterruptedException{
		
		int num;
		
		for(num=1; num <number; num++){
			
			driver.findElement(By.linkText("Add room")).click();
			Thread.sleep(100);
			
		}
		
		
	}
	
	public void popRoomPAX (int roomNum,int adults, int children, int infants, WebDriver driver) throws InterruptedException{
		
		// no exception handling again, add later
		
		
		String a = Integer.toString(adults);
		String c = Integer.toString(children);
		String i = Integer.toString(infants);
		
		Select adult = new Select(driver.findElement(By.className("adults_"+roomNum)));
		
		adult.selectByVisibleText(a);
		if (children >0){
        Select child = new Select(driver.findElement(By.className("children_"+roomNum)));		
		child.selectByVisibleText(c);
		
		if (children>0){
			
			int count = 1;

                while (count <=children){				
				Select c1 = new Select(driver.findElement(By.className("childRoom_"+roomNum+"_"+count)));
				Random ageGen = new Random();
				int generatedAgeIndex = ageGen.nextInt(18);
				c1.selectByIndex(generatedAgeIndex);
				count++;
		
			}
			
		}
		}
		if(infants>0){
		Select infant = new Select(driver.findElement(By.className("cots_"+roomNum)));
		
		infant.selectByVisibleText(i); }
		
		
		
	}
	
	
	public void startBooking (boolean randomOrNot,String hotelNumber, WebDriver driver) throws Exception{
		
		
		/* 
		 * Room selection by index to be added in the future
		 * 
		 * 
		 * 
		 */
		
		String bookPath;
		
		if(randomOrNot == true){
			String rnum;
			Integer preCond;
			
			
		    preCond = randomNum.nextInt(25); 
		    rnum = preCond.toString();
		    if(rnum == "0") {rnum = "1";}
		    
		    bookPath = "//html/body/table/tbody/tr/td[3]/form/div[2]/div[3]/div/div[2]/div/table/tbody/tr[" +rnum+ "]/td/table/tbody/tr[7]/td/div/button";
		} else{
			
			bookPath = "//html/body/table/tbody/tr/td[3]/form/div[2]/div[3]/div/div[2]/div/table/tbody/tr[" +hotelNumber+ "]/td/table/tbody/tr[7]/td/div/button"; }
		   
		    Thread.sleep(1000);
		   driver.findElement(By.xpath(bookPath)).click(); 
		    Thread.sleep(2000);
			
			
		}

	public void passengerDetails (int numOfRooms, WebDriver driver) throws Exception{
		
		// Add mechanism for several rooms
		
		String names[] = {"Dmitry","Vladimir","Boris","Ivan","Victor","Elena","Anastasia","Natalia","Maria","Dasha","Victoria","Olga"};
		String titles[] = {"the Cute","the Insured","the Mighty","the Fool","Fish","Cake","the Bad","Cheerful","the Immortal","of Kuoni","the Brave","Random"};
		
		int nameIndex = new Random().nextInt(names.length);
		String randomName = (names[nameIndex]);
		
		int titleIndex = new Random().nextInt(titles.length);
		String randomTitle = (titles[titleIndex]);
		
		driver.findElement(By.xpath("//input[@name='newName0']")).sendKeys(randomName+" "+randomTitle);
		
		nameIndex = new Random().nextInt(names.length);
		titleIndex = new Random().nextInt(titles.length);
		randomName = (names[nameIndex]);
		randomTitle = (titles[titleIndex]);
		
		driver.findElement(By.xpath("//input[@name='newName1']")).sendKeys(randomName+" "+randomTitle);
		
		driver.findElement(By.xpath("//input[@name='conditionConfirmed']")).click();
		Thread.sleep(1000);
		
		
		
	}
	
	public void loginCC2(String login, String pass, WebDriver driver) throws Exception{
		
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
	
	public void homePageSrchRT(int nationalityIndex, int currencyIndex, String cityName, WebDriver driver, String dateOfArrival, String dateOfDeparture ) throws Exception {
		
		
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    Thread.sleep(500);
	    
	    Select currency = new Select(driver.findElement(By.name("currency")));
	    currency.selectByIndex(currencyIndex);
	    
	    Select nationality = new Select(driver.findElement(By.name("country")));
	    Thread.sleep(500);
	    nationality.selectByIndex(nationalityIndex);
	    
	    
	    
		driver.findElement(By.id("freeFormatCityEntry")).sendKeys(
				cityName);
		Thread.sleep(1500);
		driver.findElement(By.id("freeFormatCityEntry")).sendKeys("\n");
		
		driver.findElement(By.id("arrivalFieldInput")).clear();
		driver.findElement(By.id("arrivalFieldInput")).sendKeys(dateOfArrival);
		Thread.sleep(1000);
		driver.findElement(By.id("freeFormatCityEntry")).sendKeys("\n");
		
		driver.findElement(By.id("departureFieldInput")).clear();
		driver.findElement(By.id("departureFieldInput")).sendKeys(dateOfDeparture);
		Thread.sleep(1000);
		
		driver.findElement(By.id("freeFormatCityEntry")).sendKeys("\n");
		Thread.sleep(1000);
	
		
		
		
		
		

	}
	
	public int regressionHelp(String arrivalDate, String departureDate, String cityName, boolean expectedOrNot, int stepNo, WebDriver driver) throws Exception{
		
		
		
		driver.findElement(By.id("arrivalFieldInput")).clear();
		driver.findElement(By.id("arrivalFieldInput")).sendKeys(arrivalDate);
		Thread.sleep(1000);				
		driver.findElement(By.id("departureFieldInput")).clear();
		driver.findElement(By.id("departureFieldInput")).sendKeys(departureDate);
		driver.findElement(By.id("departureFieldInput")).sendKeys("\n");
		Thread.sleep(1000);
		driver.findElement(By.id("freeFormatCityEntry")).clear();
		driver.findElement(By.id("freeFormatCityEntry")).sendKeys(
				cityName);
		Thread.sleep(1500);
		driver.findElement(By.id("freeFormatCityEntry")).sendKeys("\n");
		driver.findElement(By.name("search")).click();
		
		Thread.sleep(2000);
		if(expectedOrNot == true && driver.findElements(By.xpath("/html/body/table/tbody/tr/td[3]/form/div[2]/div[3]/div/div[2]/div/table/tbody/tr/td/table/tbody/tr[2]/td[2]/div/a/span")).isEmpty() == false){
			System.out.println("Step "+stepNo+ " ok.");}
			
		else if(expectedOrNot == false && driver.findElements(By.xpath("/html/body/table/tbody/tr/td[3]/form/div[2]/div[3]/div/div[2]/div/table/tbody/tr/td/table/tbody/tr[2]/td[2]/div/a/span")).isEmpty() == true){
			System.out.println("Step "+stepNo+ " ok.");
		}
			else {
			System.out.println("Step "+stepNo+" failed.");	
			}
			stepNo++;
			return stepNo;
			
		}
	
	public void homePageSrchRTLicenceOne(int nationalityIndex, int currencyIndex, String cityName, WebDriver driver, int arrivalDay, int departureDay, String arrMonthYear, String depMonthYear) throws Exception{
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    Thread.sleep(500);
	    
	    Select currency = new Select(driver.findElement(By.name("currency")));
	    currency.selectByIndex(currencyIndex);
	    
	    Select nationality = new Select(driver.findElement(By.name("country")));
	    Thread.sleep(500);
	    nationality.selectByIndex(nationalityIndex);
	    
	    Select aDay = new Select(driver.findElement(By.id("arrivalDay")));
	    Thread.sleep(500);
	    aDay.selectByIndex(arrivalDay);
	    
	    Select aMonthYear = new Select(driver.findElement(By.id("arrivalDate")));
	    Thread.sleep(500);
	    aMonthYear.selectByVisibleText(arrMonthYear);
	    
	    Select dDay = new Select(driver.findElement(By.id("departureDay")));
	    Thread.sleep(500);
	    dDay.selectByIndex(departureDay);
	    
	    Select dMonthYear = new Select(driver.findElement(By.id("departureDate")));
	    Thread.sleep(500);
	    dMonthYear.selectByVisibleText(depMonthYear);
	    
	    
		driver.findElement(By.id("freeFormatCityEntry")).sendKeys(
				cityName);
		Thread.sleep(1500);
		driver.findElement(By.id("freeFormatCityEntry")).sendKeys("\n");
		
		
		
		driver.findElement(By.id("freeFormatCityEntry")).sendKeys("\n");
		Thread.sleep(1000);
	}
	
	public int starRatingFilter (int ratingIndex, WebDriver driver) throws InterruptedException{  
		
	    /* index = value
		 * 0 = all stars
		 * 1 = 1-2
		 * 2 = 2-3
		 * 4 = 3-4
		 * 5 = 4-5
		 * 5 = 5 
		*/
		
		Select ratingChoice = new Select(driver.findElement(By.name("star")));
		ratingChoice.selectByIndex(ratingIndex);
//		driver.findElement(By.name("search")).click();
		Thread.sleep(1000);
		return ratingIndex;
		
	}
	
	
	
	public void verifyStarRating(int ratingIndex, WebDriver driver){
		
		int otherIndexes = 1;
		
		while(otherIndexes<=5){
			if(otherIndexes == ratingIndex+1){otherIndexes++;}
			
		try{
			driver.findElements(By.xpath("//img[@alt='"+otherIndexes+" Star']"));
//			System.out.println("No hotels with star rating of "+otherIndexes);
			
		}
		catch(Throwable e){
			System.out.println("Exception");
		
		}
		 
		otherIndexes++; 
		if (otherIndexes == ratingIndex){otherIndexes++;}
		
	}
	}
    
	public int regressionHelpRT(String cityName, boolean expectedOrNot, int stepNo, WebDriver driver, int arrivalDay, int departureDay, String arrMonthYear, String depMonthYear) throws Exception{
		
		
		Select aDay = new Select(driver.findElement(By.id("arrivalDay")));
	    Thread.sleep(500);
	    aDay.selectByIndex(arrivalDay);
	    
	    Select aMonthYear = new Select(driver.findElement(By.id("arrivalDate")));
	    Thread.sleep(500);
	    aMonthYear.selectByVisibleText(arrMonthYear);
	    
	    Select dDay = new Select(driver.findElement(By.id("departureDay")));
	    Thread.sleep(500);
	    dDay.selectByIndex(departureDay);
	    
	    Select dMonthYear = new Select(driver.findElement(By.id("departureDate")));
	    Thread.sleep(500);
	    dMonthYear.selectByVisibleText(depMonthYear);
		
		Thread.sleep(1000);
		driver.findElement(By.id("freeFormatCityEntry")).clear();
		driver.findElement(By.id("freeFormatCityEntry")).sendKeys(
				cityName);
		Thread.sleep(1500);
		driver.findElement(By.id("freeFormatCityEntry")).sendKeys("\n");
		driver.findElement(By.name("search")).click();
		
		Thread.sleep(2000);
		if(expectedOrNot == true && driver.findElements(By.xpath("/html/body/table/tbody/tr/td[3]/form/div[3]/div[4]/div/div[2]/div/table/tbody/tr/td/table/tbody/tr[2]/td[2]/div/a/span")).isEmpty() == false){
			System.out.println("Step "+stepNo+ " ok.");}
			
		else if(expectedOrNot == false && driver.findElements(By.xpath("/html/body/table/tbody/tr/td[3]/form/div[3]/div[4]/div/div[2]/div/table/tbody/tr/td/table/tbody/tr[2]/td[2]/div/a/span")).isEmpty() == true){
			System.out.println("Step "+stepNo+ " ok.");
		}
			else {
			System.out.println("Step "+stepNo+" failed.");	
			}
			stepNo++;
			return stepNo;
			
		}	
}
	
 
