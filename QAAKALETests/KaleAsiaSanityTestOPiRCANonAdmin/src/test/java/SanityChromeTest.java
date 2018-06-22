import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SanityChromeTest {
	
	private WebDriver driver;
	private String username ="qaacfi";
	 private String password = "S2FsZTk0OTM1ODMwQA==";
	private String chrome_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\chromedriver.exe";
	private String url = "https://kaleasia.error-free.com/";

	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Performing sanity test on O&P-IRCA in Chrome");
		  System.setProperty("webdriver.chrome.driver",chrome_path);
		  ChromeOptions options = new ChromeOptions();
          HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
          chromeOptionsMap.put("plugins.plugins_disabled", new String[] {
        		    "Chrome PDF Viewer"
        		});
          chromeOptionsMap.put("plugins.always_open_pdf_externally", true);
          options.setExperimentalOption("prefs", chromeOptionsMap);
          String downloadFilepath = "C:\\Users\\IEUser\\Downloads\\reports";
          chromeOptionsMap.put("download.default_directory", downloadFilepath);
          options.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
          options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
          options.setCapability(ChromeOptions.CAPABILITY, options);
          driver = new ChromeDriver(options);
		  //Browser is maximized
		  driver.manage().window().maximize();
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
		  obj1.shareReport(driver, username, password, 1);
		  //Mark critical integer same as shareReport
		  obj1.markCritical(driver,username, password,1);
		  WebElement record = driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-opa']/ul/li[2]/a"));
		  String recordName = record.getText();
		  //Deletes the newly created record, integer same as shareReport
		  obj1.deleteNewRecord(driver, recordName,1);
		  //Logs out
		  obj.logout(driver);
		  afterTest(obj1);		  
	}
	
	public void afterTest(OPiRCA obj1) throws Exception{
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-login-button")));
		//Browser closes
		driver.quit();
		obj1.softAssert();
	}
}
