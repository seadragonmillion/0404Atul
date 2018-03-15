import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ErrorMeterChromeTest {

	private WebDriver driver;
	private String username ="jenkinsvm";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String chrome_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\chromedriver.exe";
	private String url = "https://kale.error-free.com/";
	private String title = "Sanity Test";
	SoftAssertions softly = new SoftAssertions();
	
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Performing sanity test on SPV Error Meter in Chrome");
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
		  ErrorMeter obj1 = new ErrorMeter();
		  //Logs in
		  int login = obj.LoginUser(driver,username,password);
		  System.out.println("Title after login: "+driver.getTitle());
		  Thread.sleep(4000);
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
		  Thread.sleep(4000);
		  WebDriverWait wait = new WebDriverWait(driver,20);
		  //Clicks on Analysis 
		  try
		  {
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-a"))).click();
		  }catch (UnhandledAlertException f){			  
			  driver.switchTo().alert().dismiss();
		  }
		  //Clicks on SPV Error meter
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-em"))).click();
		  Thread.sleep(2000);
		  //Select Purpose from dropdown
		  WebElement element = driver.findElement(By.id("pii-epm-select-purpose"));
		  Select s = new Select (element);
		  s.selectByVisibleText("PJB");
		  Thread.sleep(2000);
		  //Select Job type
		  element = driver.findElement(By.id("pii-epm-select-condition"));
		  Select s1 = new Select (element);
		  s1.selectByVisibleText("Construction");
		  Thread.sleep(2000);
		  //Fills Job title
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-job-title"))).sendKeys(title);
		  String ev1= driver.findElement(By.id("pii-epm-job-title")).getAttribute("value");
		  if(ev1.equals(title)==false)
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-job-title"))).sendKeys(title);
		  Thread.sleep(2000);
		  //Click on next
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-btn-next"))).click();
		  Thread.sleep(2000);
		  obj1.papeError50(driver);
		  Thread.sleep(2000);
		  //Click on finalize
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-btn-done"))).click();
		  Thread.sleep(2000);
		  //Click on finalize and save
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-dialog-title"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-dialog-confirmed"))).click(); 
		  //Waits for the green popup on the right top corner
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  //Creates expected record name
		  String date= driver.findElement(By.xpath(".//*[@id='epm-rpt']/table/tbody/tr/td[2]")).getText();
		  date = date.substring(14);
		  String time = driver.findElement(By.xpath(".//*[@id='epm-rpt']/table/tbody/tr[2]/td[2]")).getText();
		  time = time.substring(14);
		  String time2 = time.substring(0, 8);
		  String time1=time.substring(9);
		  String purpose = driver.findElement(By.xpath(".//*[@id='epm-rpt']/div/div/span/abbr")).getText();
		  String name = date + "_" + time2+"_"+time1 + "_" + username +"_" + purpose + "_" + title;
		  System.out.println ("Expected name of record: " +name);
		  //Clicks on side panel
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-epm"))).click();
		  //Gets the name of the record created
		  WebElement record = driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-epm']/ul/li[2]/a"));
		  String recordName = record.getText();
		  if (record.isDisplayed())
		  {
			  System.out.println("Record found: "+ recordName);
		  }
		  else
			  System.out.println ("Record not found.");
		  	
		  //Checks if the record name is correct
		  assertEquals(name,recordName);
		  Thread.sleep(2000);
		  obj1.reportCheck0(driver);
		  //Downloads record, the integer indicates error meter tests based on error %= 0,50,100
		  obj1.downloadReportChrome(driver, 50);
		  Thread.sleep(2000);
		  //Shares report, the integer indicates admin test =0 and non admin test =1
		  obj1.shareReport(driver,username,0);
		  Thread.sleep(2000);
		  //Mark critical
		  obj1.markCritical(driver);
		  Thread.sleep(2000);
		  //Deletes the record
		   obj1.deleteNewRecord(recordName,driver);
		   Thread.sleep(2000);
		  while(true)
			  {
				  Thread.sleep(1000);
				  try{
				  if (driver.findElement(By.className("sticky-note")).isDisplayed())
				  {
					  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();
					  
				  }}catch (NoSuchElementException e)
				  {
					  break;
				  }
				  catch( StaleElementReferenceException f)
				  {
					  
					 break;
				  }
				  catch (org.openqa.selenium.TimeoutException u)
				  {
					  break;
				  }
				 
			  }
		  
		  //Logs out
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-signout-button"))).click();
		  Thread.sleep(2000);
		  afterTest();
		   	 
		  
	}
	
	
	public void afterTest(){
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-login-button")));
		//Browser closes
		driver.quit();
		softly.assertAll();
	}
}
