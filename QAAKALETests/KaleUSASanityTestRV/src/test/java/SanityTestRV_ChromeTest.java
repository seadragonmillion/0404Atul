import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SanityTestRV_ChromeTest {

	private WebDriver driver;
	private String username ="jenkinsvm";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String chrome_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\chromedriver.exe";
	private String url = "https://kale.error-free.com/";
	SoftAssertions softly = new SoftAssertions();

	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Performing sanity test on Remote Verification admin in Chrome");
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
		  RemoteVerification obj1 = new RemoteVerification();
		  //Logs in
		  int login = obj.LoginUser(driver,username,password);
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
		  Thread.sleep(2000);
		  //Clicks on Analysis 
		  try
		  {
			  driver.findElement(By.id("pii-main-menu-button-a")).click();
		  }catch (UnhandledAlertException f){			  
			  driver.switchTo().alert().dismiss();
		  }
		  //Clicks on Remote Verification
		  driver.findElement(By.id("pii-a-menu-rv")).click();
		  //Fills the mandatory fields
		  driver.findElement(By.id("pii-rv-tab-1-title")).sendKeys(obj1.event_title);
		  driver.findElement(By.id("pii-rv-tab-1-details")).sendKeys(obj1.details);
		  String ev1 = driver.findElement(By.id("pii-rv-tab-1-title")).getAttribute("value");
		  String ev2 = driver.findElement(By.id("pii-rv-tab-1-details")).getAttribute("value");
		  if ((ev1.equals(obj1.event_title)==false))
		  {
			  driver.findElement(By.id("pii-rv-tab-1-title")).clear();
			  driver.findElement(By.id("pii-rv-tab-1-title")).sendKeys(obj1.event_title);
		  }
		  if((ev2.equals(obj1.details))==false)
		  {
			  driver.findElement(By.id("pii-rv-tab-1-details")).clear();
			  driver.findElement(By.id("pii-rv-tab-1-details")).sendKeys(obj1.details);
		  }
		  
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  //Select verifier
		  obj1.verifierSelect(driver);
		  Thread.sleep(1000);
		  String verifier= driver.findElement(By.id("pii-rv-verifier-name")).getAttribute("piivalue");
		  //Uploads picture 2
		  String file2 = "C:/Users/Public/Pictures/Sample Pictures/Desert.jpg";
		  driver.findElement(By.id("pii-rv-imgperson-photo-input")).sendKeys(file2);
		  //*Clears image
		  WebDriverWait wait1 = new WebDriverWait(driver,20);
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-imgperson-clear"))).click();
		  //Re-uploads picture 2
		  driver.findElement(By.id("pii-rv-imgperson-photo-input")).sendKeys(file2);
		  //Rotates image 2 once
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-imgperson-rotate"))).click();
		  //*
		  jse.executeScript("scroll(0, 250)");
		  Thread.sleep(3000);
		  //Uploads picture 1
		  String filepath = "C:/Users/Public/Pictures/Sample Pictures/Chrysanthemum.jpg";
		  driver.findElement(By.id("pii-rv-imgwork-photo-input")).sendKeys(filepath);
		  //*Clears image
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-imgwork-clear"))).click();
		  //Re-uploads picture 1
		  driver.findElement(By.id("pii-rv-imgwork-photo-input")).sendKeys(filepath);
		  //Rotates image 1 twice
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-imgwork-rotate"))).click();
		  Thread.sleep(1000);
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-imgwork-rotate"))).click();
		  //*
		  Thread.sleep(3000);
		  jse.executeScript("scroll(0, 0)");
		  //Verifies Date and time
		  obj1.verifyDateTime(driver);
		  //Verifies location of office
		  obj1.verifyLongitudeLatitude(driver);
		  //Clicks on Save and Send
		  driver.findElement(By.xpath("//*[@id='pii-rv-tabs']/div[2]/div/a[2]")).click();
		  //Clicks on save and send report
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-dialog-title"))).click();
		  driver.findElement(By.id("pii-rv-dialog-confirmed")).click();
		  Thread.sleep(3000);
		  //Creates the expected name of record
		  String creation_date = driver.findElement(By.xpath(".//*[@id='rv-rpt']/div/div[2]/div[3]")).getText();
		  creation_date= creation_date.substring(22, creation_date.length());
		  String name = creation_date +"_"+ username + "_" + obj1.event_title;
		  System.out.println("Expected name of record: " + name);
		  //Clicks on Remote Verification
		  driver.findElement(By.id("pii-user-home-panel-btn-rv")).click();
		  Thread.sleep(3000);
		  //Gets the name of the record created
		  WebElement record = driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-rv']/ul/li[2]/a"));
		  String recordName = record.getText();
		  if (record.isDisplayed())
		  {
			  System.out.println("Record found: "+ recordName);
		  }
		  else
			  System.out.println ("Record not found.");
		  //Checks if the name displayed on record is same as expected
		  softly.assertThat(recordName).as("test data").isEqualTo(name);
		  //Downloads record
		  obj1.downloadRecordChrome(driver,verifier,username);
		  //Shares report, the integer indicates admin test =0 and non admin test =1
		  obj1.shareReport(driver,verifier,username,0);
		  //Mark critical
		  obj1.markCritical(driver);
		  //Deletes the newly created record
		  obj1.deleteNewRecord(driver,recordName);
		  //Logs out
		  driver.findElement(By.id("pii-user-loginname")).click();
		  driver.findElement(By.id("pii-signout-button")).click();	
		  afterTest();
		  
	  }
	  
	  
	  public void afterTest() {
		 //Waits for the login button
		  WebDriverWait wait = new WebDriverWait(driver,20);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-login-button")));
		  //Browser is closed
		  driver.quit();
		  softly.assertAll();
	  }
	  
}
