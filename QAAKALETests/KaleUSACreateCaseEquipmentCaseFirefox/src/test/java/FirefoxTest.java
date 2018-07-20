import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class FirefoxTest {

	private WebDriver driver;
	private String username ="jenkinsvm";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String gecko_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\geckodriver.exe";
	private String url = "https://kale.error-free.com/";
	SoftAssertions softly = new SoftAssertions();
	
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		 System.out.println("Equipment Case Upload in Firefox");
		 System.setProperty("webdriver.gecko.driver",gecko_path);
		 ProfilesIni ffProfiles = new ProfilesIni();
		 FirefoxProfile profile = ffProfiles.getProfile("HiRCAEvent");
		 profile.setPreference("browser.download.folderList", 2);
		 profile.setPreference("browser.download.dir", "C:\\Users\\IEUser\\Downloads\\reports");
		 FirefoxOptions options = new FirefoxOptions();
		 options.setCapability(FirefoxDriver.PROFILE, profile);
		 driver = new FirefoxDriver(options);
		 Dimension initialSize= driver.manage().window().getSize();
		 System.out.println(initialSize);
		 int height=initialSize.getHeight();
		 if(height<950)
		 {
			//Browser is maximized
			driver.manage().window().maximize(); 
		 }
		 Dimension finalSize=driver.manage().window().getSize();
		 System.out.println(finalSize);
		  //Browser navigates to the KALE url
		  driver.navigate().to(url);
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }
	  

	@Test
	  public void SanityTest() throws Exception{
		  
		CaseBrowse obj = new CaseBrowse();
		CreateEquipmentCase obj1 = new CreateEquipmentCase();
		Login obj2 = new Login();
		int login = obj2.LoginUser(driver, username, password);
		System.out.println("Title after login: "+driver.getTitle());
		Thread.sleep(8000);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    Thread.sleep(4000);
		//Switches to the iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		Thread.sleep(8000);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		if (login==1)
      {
			while(true)
  		  {
             	 Thread.sleep(1000);
  			  if (driver.findElement(By.cssSelector(".sticky.border-top-right.sticky-error")).isDisplayed())
  			  {
  				  WebElement ele =driver.findElement(By.cssSelector(".sticky.border-top-right.sticky-error"));
  				  ele.findElement(By.className("sticky-close")).click();
  				  break;
  			  }
  			  else break;
  		  }
      }		  
		obj1.deletePreviousCase(driver, obj1.eq_titleUS);
		Thread.sleep(1000);
		obj1.deletePreviousCase(driver, obj1.ee_titleUS);
		Thread.sleep(1000);
		obj1.deletePreviousCase(driver, obj1.me_titleUS);
		Thread.sleep(1000);
		//Creates 5 slides for Equipment Case Search
		List<String> eqCases = obj1.createCaseFirefox(driver, obj1.keyword_same_eqUS, obj1.key1_eqUS, obj1.key2_eqUS, obj1.key3_eqUS, obj1.eq_titleUS);
		System.out.println("Slides created for equipment: "+ eqCases);
		Thread.sleep(2000);
		//Creates 5 slides for Electrical Case Search
		List<String> eeCases = obj1.createCaseFirefox(driver, obj1.keywordUS_same_ee, obj1.key1_eeUS, obj1.key2_eeUS, obj1.key3_eeUS, obj1.ee_titleUS);
		System.out.println("Slides created for electrical "+eeCases);
		Thread.sleep(2000);
		//Creates 5 slides for Mechanical Case Search
		List<String> meCases = obj1.createCaseFirefox(driver, obj1.keywordUS_same_me, obj1.key1_meUS, obj1.key2_meUS, obj1.key3_meUS, obj1.me_titleUS);
		System.out.println("Slides created for mechanical "+meCases);
		Thread.sleep(2000);
		//Checks slides for one Equipment non PII case
		obj1.compareSlide(driver, eqCases.get(0), obj1.eq_titleUS, 0);
		System.out.println("Slide checked for equipment");
		//Search with keyword with all special characters
		obj.searchWithKeyKeywordWithAllSpecialCharacters(driver, eqCases.get(0));
		//Search with keyword with special character in middle
		obj.searchWithKeywordKALE1964(driver, softly);
		Thread.sleep(2000);
		//Checks slides for one Equipment PII case
		obj1.compareSlide(driver, eqCases.get(0), obj1.eq_titleUS, 1);
		System.out.println("Slide checked for equipment pii");
		Thread.sleep(2000);
		//Checks slides for one Electrical case
		obj1.compareSlide(driver, eeCases.get(0), obj1.ee_titleUS, 0);
		System.out.println("Slide checked for electrical");
		Thread.sleep(2000);
		//Checks slides for one Mechanical case
		obj1.compareSlide(driver, meCases.get(0), obj1.me_titleUS, 0);
		System.out.println("Slide checked for mechanical");
		Thread.sleep(2000);
		//Check the keyword search for Equipment
		obj1.checkkeyword(driver, eqCases, obj1.keyword_same_eqUS, obj1.key1_eqUS, obj1.key2_eqUS, obj1.key3_eqUS, 0,obj1.eq_titleUS);
		System.out.println("Keyword checked for equipment");
		Thread.sleep(2000);
		//Check the keyword search for Equipment PII
		obj1.checkkeyword(driver, eqCases, obj1.keyword_same_eqUS, obj1.key1_eqUS, obj1.key2_eqUS, obj1.key3_eqUS, 1,obj1.eq_titleUS);
		System.out.println("Keyword checked for equipment pii");
		Thread.sleep(2000);
		//Check the keyword search for Electrical
		obj1.checkkeyword(driver, eeCases, obj1.keywordUS_same_ee, obj1.key1_eeUS, obj1.key2_eeUS, obj1.key3_eeUS, 0,obj1.ee_titleUS);
		System.out.println("Keyword checked for electrical");
		Thread.sleep(2000);
		//Check the keyword search for Mechanical
		obj1.checkkeyword(driver, meCases, obj1.keywordUS_same_me, obj1.key1_meUS, obj1.key2_meUS, obj1.key3_meUS, 0,obj1.me_titleUS);
		System.out.println("Keyword checked for mechanical");
		Thread.sleep(2000);
		//Check for presence of Equipment cases in Mechanical or Electrical modules
		obj1.checkCase(driver, eqCases.get(1), eeCases.get(1), meCases.get(1), obj1.keyword_same_eqUS, obj1.keywordUS_same_ee);
		System.out.println("Cases checked in each module");
		Thread.sleep(2000);
		//Look for equipment cases with Type Advanced Learning
		obj1.searchEquipmentDatabankOnly(driver,obj1.keyword_same_eqUS,eqCases,username,password);
		//Look for equipment cases with all filters
		obj1.searchEquipmentPerformanceAllFilters(driver, obj1.keyword_same_eqUS, eqCases.get(5), username, password);
		//Change keyword and search for it
		obj1.changeKeywordKALE1969(driver,eqCases,obj1.keyword_same_eqUS);
		Thread.sleep(2000);
		//Add keyword to equipment case and search for case
		obj1.addKeywordKALE2168(driver, eqCases, obj1.keyword_same_eqUS);
		//Youtube link test
		obj1.searchCaseWithLinks(driver, obj1.keywordUS_same_ee, eeCases);
		//View case with links and then a case without links
		obj1.viewCaseInAdmin(driver, eqCases, eeCases, obj1.keyword_same_eqUS);
		//Edit links
		obj1.editLinks(driver, eeCases);
		//Delete links
		obj1.deleteLinks(driver, eeCases);
		//Deletes Equipment cases
		obj1.deleteCase(driver, eqCases);
		System.out.println("Slides deleted for equipment");
		Thread.sleep(2000);
		//Deletes Electrical cases
		obj1.deleteCase(driver, eeCases);
		System.out.println("Slides deleted for electrical");
		Thread.sleep(2000);
		//Deletes Mechanical cases
		obj1.deleteCase(driver, meCases);
		System.out.println("Slides deleted for mechanical");
		Thread.sleep(2000);
		//Logs out
		obj2.logout(driver);
		afterTest(obj1);		
	}
	
	public void afterTest(CreateEquipmentCase obj) throws Exception{
		
		driver.manage().window().maximize();
		//Browser closes
		driver.quit();
		obj.softAssert();
	}

}