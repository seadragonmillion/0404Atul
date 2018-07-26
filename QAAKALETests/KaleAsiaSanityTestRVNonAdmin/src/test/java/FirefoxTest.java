import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirefoxTest {
	private FirefoxDriver driver;
	private String username ="qaacfi";
	private String password = "S2FsZTk0OTM1ODMwQA==";
	private String gecko_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\geckodriver.exe";
	private String url = "https://kaleasia.error-free.com/";
	
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		 System.out.println("Performing sanity test on Remote Verification admin in Firefox");
		 System.setProperty("webdriver.gecko.driver",gecko_path);
		 ProfilesIni ffProfiles = new ProfilesIni();
		 FirefoxProfile profile = ffProfiles.getProfile("customFirefox");
		 profile.setPreference("browser.download.folderList", 2);
		 profile.setPreference("browser.download.dir", "C:\\Users\\IEUser\\Downloads\\reports");
		 FirefoxOptions options = new FirefoxOptions();
		 options.setCapability(FirefoxDriver.PROFILE, profile);
		 driver = new FirefoxDriver(options);
		 Dimension initialSize= driver.manage().window().getSize();
		 System.out.println(initialSize);
		 int height=initialSize.getHeight();
		 if(height<930)
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
		  RemoteVerification obj1 = new RemoteVerification();
		  //Logs in
		  int login = obj.LoginUser(driver,username,password);
		  System.out.println("Title after login: "+driver.getTitle());
		  Thread.sleep(8000);		  
		  //Assigns wait time to driver element
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
		  Thread.sleep(2000);
		  //create report
		  List<String> b = obj1.createReport(driver, username);
		  //Downloads record
		  obj1.downloadRecordFirefox(driver,b.get(0),username);
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
		  obj1.shareReport(driver,b.get(0),username,password,1);
		  //Mark critical integer same as shareReport
		  obj1.markCritical(driver,username, password,1);
		  //Deletes the newly created record, integer same as shareReport
		  obj1.deleteNewRecord(driver, b.get(1),1);
		  //Logs out
		  obj.logout(driver);
		  afterTest(obj1);		 
	  }
	  
	
	  public void afterTest(RemoteVerification obj) throws Exception {
		 
		 driver.manage().window().maximize();
		  //Browser is closed
		 driver.quit();
		 obj.softAssert();
	  }


}
