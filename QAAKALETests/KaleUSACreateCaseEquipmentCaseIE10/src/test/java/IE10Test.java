import kaleTestSoftware.*;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class IE10Test {

	private WebDriver driver;
	private String username ="jenkinsvm";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String ie_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\IEDriverServer.exe";
	private String url = "https://kale.error-free.com/";
	SoftAssertions softly = new SoftAssertions();
			
	@Rule
    public TestWatcher watcher = new TestWatcher() {
        @Override
        protected void failed(Throwable throwable, Description description) {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(scrFile,
                        new File("target/screenshots/"+"failshot.png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }

        @Override
        protected void finished(Description description) {
            driver.quit();
        }
	};
	
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Equipment case upload in Internet Explorer");
		  System.setProperty("webdriver.ie.driver",ie_path);
		  DesiredCapabilities cap = new DesiredCapabilities(); 
		  cap.setCapability("ignoreZoomSettings", true);
		  cap.setCapability("requireWindowFocus", true);
		  driver = new InternetExplorerDriver(cap);
		  //Browser is maximized
		  driver.manage().window().maximize();
		  //Browser navigates to the KALE url
		  driver.navigate().to(url);
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		  
	  }
	  
	@Test
	  public void SanityTest() throws Exception{
		  
		CaseBrowse obj = new CaseBrowse();
		CreateEquipmentCase obj1 = new CreateEquipmentCase();
		CreateEquipmentCase3 obj3 = new CreateEquipmentCase3();
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
		obj1.deletePreviousCase(driver, obj3.eq_titleUS);
		Thread.sleep(1000);
		obj1.deletePreviousCase(driver, obj3.ee_titleUS);
		Thread.sleep(1000);
		//Creates 5 slides for Equipment Case Search
		List<String> eqCases = obj1.createCaseIE10(driver, obj3.keyword_same_eqUS, obj3.key1_eqUS, obj3.key2_eqUS, obj3.key3_eqUS, obj3.eq_titleUS);
		System.out.println("Slides created for equipment: "+ eqCases);
		Thread.sleep(2000);
		//Creates 5 slides for Electrical Case Search
		List<String> eeCases = obj1.createCaseIE10(driver, obj3.keywordUS_same_ee, obj3.key1_eeUS, obj3.key2_eeUS, obj3.key3_eeUS, obj3.ee_titleUS);
		System.out.println("Slides created for electrical "+eeCases);
		Thread.sleep(2000);
		//Checks slides for one Equipment non PII case
		obj1.compareSlide(driver, eqCases.get(0), obj3.eq_titleUS, 0);
		System.out.println("Slide checked for equipment");
		//Search with keyword with all special characters
		obj.searchWithKeyKeywordWithAllSpecialCharacters(driver, eqCases.get(0));
		//Search with keyword with special character in middle
		obj.searchWithKeywordKALE1964(driver, softly);
		Thread.sleep(2000);
		//Checks slides for one Equipment PII case
		obj1.compareSlide(driver, eqCases.get(0), obj3.eq_titleUS, 1);
		System.out.println("Slide checked for equipment pii");
		Thread.sleep(2000);
		//Checks slides for one Electrical case
		obj1.compareSlide(driver, eeCases.get(0), obj3.ee_titleUS, 0);
		System.out.println("Slide checked for electrical");
		Thread.sleep(2000);
		//Check the keyword search for Equipment
		obj1.checkkeyword(driver, eqCases, obj3.keyword_same_eqUS, obj3.key1_eqUS, obj3.key2_eqUS, obj3.key3_eqUS, 0,obj3.eq_titleUS);
		System.out.println("Keyword checked for equipment");
		Thread.sleep(2000);
		//Check the keyword search for Equipment PII
		obj1.checkkeyword(driver, eqCases, obj3.keyword_same_eqUS, obj3.key1_eqUS, obj3.key2_eqUS, obj3.key3_eqUS, 1,obj3.eq_titleUS);
		System.out.println("Keyword checked for equipment pii");
		Thread.sleep(2000);
		//Check the keyword search for Electrical
		obj1.checkkeyword(driver, eeCases, obj3.keywordUS_same_ee, obj3.key1_eeUS, obj3.key2_eeUS, obj3.key3_eeUS, 0,obj3.ee_titleUS);
		System.out.println("Keyword checked for electrical");
		Thread.sleep(2000);
		//Check for presence of Equipment cases in Mechanical or Electrical modules
		obj1.checkCase(driver, eqCases.get(1), eeCases.get(1), obj3.keyword_same_eqUS, obj3.keywordUS_same_ee);
		System.out.println("Cases checked in each module");
		Thread.sleep(2000);
		//Look for equipment cases with Type Advanced Learning
		obj1.searchEquipmentDatabankOnly(driver,obj3.keyword_same_eqUS,eqCases,username,password);
		//Look for equipmen cases with all 
		obj1.searchEquipmentPerformanceAllFilters(driver, obj3.keyword_same_eqUS, eqCases.get(5), username, password);
		//Change keyword and search for it
		obj1.changeKeywordKALE1969(driver,eqCases,obj3.keyword_same_eqUS);
		Thread.sleep(2000);
		//Add keyword to equipment case and search for case
		obj1.addKeywordKALE2168(driver, eqCases, obj3.keyword_same_eqUS);
		//Youtube link test
		obj1.searchCaseWithLinks(driver, obj3.keywordUS_same_ee, eeCases,obj3.ee_titleUS);
		//View case with links and then a case without links
		obj1.viewCaseInAdmin(driver, eqCases, eeCases, obj3.keyword_same_eqUS);
		//Verify cases with and without links with same keyword in Equipment Databank only
		obj1.searchCaseWithSameKeywordWithAndWithoutLinksInEquipDatabank(driver, obj3.keywordUS_same_ee, eeCases);
		//Add an existing keyword to case with links and search for case
		obj1.addKeywordToLinkCaseAndSearchInEquipmentDatabank(driver, eeCases, obj.keywordEquipProd);
		//Turn slide security on and click on links in Related links slide
		obj1.slideSecurityOnTest(driver, obj3.keywordUS_same_ee, eeCases, obj3.ee_titleUS, username);
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
		//Logs out
		obj2.logout(driver);
		afterTest(obj1);		
	}
	
	public void afterTest(CreateEquipmentCase obj) throws Exception{
		
		//Browser closes
		driver.quit();
		obj.softAssert();
	}

}