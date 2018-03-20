import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirefoxTest {
	private FirefoxDriver driver;
	private String username ="jenkinsvmnonadmin";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String gecko_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\geckodriver.exe";
	private String url = "https://kaledev.error-free.com/";
	SoftAssertions softly = new SoftAssertions();
	
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
		  RemoteVerification obj1 = new RemoteVerification();
		  //Logs in
		  int login = obj.LoginUser(driver,username,password);
		  Thread.sleep(5000);
		  System.out.println("Title after login: "+driver.getTitle());
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
		  WebDriverWait wait = new WebDriverWait(driver,30);
		  try
		  {
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-a"))).click();
			  
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
		  Thread.sleep(2000);
		  String verifier= driver.findElement(By.id("pii-rv-verifier-name")).getAttribute("piivalue");
		  //Clicks on browse button of 2nd picture
		  driver.findElement(By.id("pii-rv-imgperson-photo-input")).click();
		  Thread.sleep(2000);
		  //Uploads picture 2
		  Process p3=Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaChrysanthemum.exe");
		  p3.waitFor();
		  Thread.sleep(8000);
		  //*Clears image
		  WebDriverWait wait1 = new WebDriverWait(driver,20);
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-imgperson-clear"))).click();
		  //Re-uploads picture 2
		  driver.findElement(By.id("pii-rv-imgperson-photo-input")).click();
		  Thread.sleep(2000);
		  Process p2=Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaChrysanthemum.exe");
		  p2.waitFor();
		  Thread.sleep(8000);
		  //Rotates image 2 once
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-imgperson-rotate"))).click();
		  //*
		 
		  jse.executeScript("scroll(0, 250)");
		  //Clicks on browse button of 1st picture
		  driver.findElement(By.id("pii-rv-imgwork-photo-input")).click();
		  Thread.sleep(2000);
		  //Uploads picture 1
		  Process p=Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaDesert.exe");
		  p.waitFor();
		  Thread.sleep(4000);
		  //*Clears image
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-imgwork-clear"))).click();
		  //Re-uploads picture 1
		  driver.findElement(By.id("pii-rv-imgwork-photo-input")).click();
		  Thread.sleep(2000);
		  Process p1=Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaDesert.exe");
		  p1.waitFor();
		  Thread.sleep(4000);
		  //Rotates image 1 twice
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-imgwork-rotate"))).click();
		  Thread.sleep(1000);
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-imgwork-rotate"))).click();
		  jse.executeScript("scroll(0, 0)");
		  //Verifies Date and time
		  obj1.verifyDateTime(driver);
		  //Verifies location of office
		  obj1.verifyLongitudeLatitude(driver);
		  //Clicks on Save and Send
		  driver.findElement(By.xpath("//*[@id='pii-rv-tabs']/div[2]/div/a[2]")).click();
		  //Clicks on save and send report
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-dialog-title"))).click();
		  driver.findElement(By.id("pii-rv-dialog-confirmed")).click();
		  Thread.sleep(3000);
		  //Creates the expected name of record
		  String creation_date = driver.findElement(By.xpath(".//*[@id='rv-rpt']/div[1]/div[2]/div[3]")).getText();
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
		  assertEquals(name, recordName);
		  //Downloads record
		  obj1.downloadRecordFirefox(driver,verifier,username);
		  //Shares report, the integer indicates admin test =0 and non admin test =1
		  obj1.shareReport(driver,verifier,username,1);
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
		 
		 driver.switchTo().defaultContent();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 //Browser is closed
		 driver.quit();
		 softly.assertAll();
	  }


}
