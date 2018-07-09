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
		  
		 System.out.println("Human Case Upload in Firefox");
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
		  CreateHumanCase obj1 = new CreateHumanCase();
		  Login obj2 = new Login();
		  int login = obj2.LoginUser(driver, username, password);
		  System.out.println("Title after login: "+driver.getTitle());
		  Thread.sleep(5000);
		  //Waits for the page to load
	      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  //Switches to the iframe
		  driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		  Thread.sleep(5000);
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
		  int m=obj1.deletePreviousCase(driver, obj1.titleUS);
		  //Create case
		  List<String> caseID = obj1.createCaseHumanFirefox(driver, m, obj1.titleUS, obj1.keyword_sameUS, obj1.key1US, obj1.key2US, obj1.key3US);
		  Thread.sleep(2000);
		  //Browse through a slide
		  obj1.compareSlide(driver, caseID, obj1.titleUS);
		  Thread.sleep(2000);
		  obj1.checkkeyword(driver, caseID, obj1.keyword_sameUS, obj1.key1US, obj1.key2US, obj1.key3US, obj1.titleUS);
		  //Search for keyword with all Special characters
		  obj.searchWithKeyKeywordWithAllSpecialCharacters(driver,caseID.get(0));
		  //Search for keyword with special character in middle and check if dropdown disappears
		  obj.searchWithKeywordKALE1964(driver,softly);
		  //Change keyword and search for it
		  obj1.changeKeywordKALE1969(driver,caseID,obj1.keyword_sameUS);
		  Thread.sleep(2000);
		  //Delete case
		  obj1.deleteCase(driver, caseID);
		  Thread.sleep(2000);
		  //Logs out
		  obj2.logout(driver);
		  afterTest(obj1);
	}
	
	public void afterTest(CreateHumanCase obj)throws Exception{
		
		//Browser closes
	    driver.manage().window().maximize();
		driver.quit();
		obj.softAssert();
	}

}
