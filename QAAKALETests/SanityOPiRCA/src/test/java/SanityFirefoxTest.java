import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Rule;
import org.junit.rules.Timeout;
import java.util.concurrent.TimeoutException;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.Dimension;
import java.util.Base64;

public class SanityFirefoxTest {

	private FirefoxDriver driver;
	private String username ="jenkinsvm";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String gecko_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\geckodriver.exe";
	private String url = "https://kaledev.error-free.com/";
		  
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		 System.out.println("Performing sanity test on O&P-IRCA in Firefox");
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
		 if(height<1900)
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
		  
		  Login obj = new Login();
		  OPiRCA obj1 = new OPiRCA();
		  //Logs in
		  int login = obj.LoginUser(driver, username, password);
		  System.out.println("Title after login: "+driver.getTitle());
		  Thread.sleep(5000);
		  //Waits for the page to load
	      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  //Switches to the iframe
		  driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		  try{
                   if (login==1)
                   {
                         WebDriverWait wait2 = new WebDriverWait(driver,20);
                         wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();
                   }
            }catch (NoSuchElementException e){
                   throw e;
            }
		  Thread.sleep(5000);
		  //Clicks on Analysis 
		  try
		  {
			  driver.findElement(By.id("pii-main-menu-button-a")).click();
		  }catch (UnhandledAlertException f){			  
			  driver.switchTo().alert().dismiss();
		  }
		  obj1.reportCreate(driver, username);
		  WebElement record = driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-opa']/ul/li[2]/a"));
		  String recordName = record.getText();
		  //Open report
		  obj1.openReport(driver);
		  //Downloads record
		  obj1.downloadRecordFirefox(driver);
		//Shares report
		  /* Dev/Asia
		 * 0=admin
		 * 1=non admin
		 * 2= admin ie11
		 * 3= non admin ie11
		 * US
		 * 4=admin
		 * 5=non admin
		 * 6=admin ie11
		 * 7=non admin ie11
		 */
		  obj1.shareReport(driver, username, password, 0);
		  //Mark critical
		  obj1.markCritical(driver);
		  //Deletes the newly created record
		  obj1.deleteNewRecord(driver, recordName);
		  //Logs out
		  obj.logout(driver);
		  afterTest(obj1);		  	  
	}
	
	public void afterTest(OPiRCA obj1) throws Exception{
		
		driver.manage().window().maximize();
		//Browser closes
		driver.quit();
		obj1.softAssert();
	}	

}
