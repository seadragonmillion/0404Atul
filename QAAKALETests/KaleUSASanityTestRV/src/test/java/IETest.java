import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IETest {

	private InternetExplorerDriver driver;
	private String username ="jenkinsvm";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String ie_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\IEDriverServer.exe";
	private String url = "https://kale.error-free.com/";
	SoftAssertions softly = new SoftAssertions();
	  
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Performing sanity test on Remote Verification in Internet Explorer");
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
		  Login obj = new Login();
		  RemoteVerification obj1 = new RemoteVerification();
		  //Logs in
		  int login = obj.LoginUser(driver,username,password);
		  Thread.sleep(5000);
		  System.out.println("Title after login: "+driver.getTitle());
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 
		  Thread.sleep(2000);
		  //Switches to the iframe
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
		  System.out.println("Waiting for page to load");
		  Thread.sleep(3000);
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  //Clicks on Analysis
		  jse.executeScript("return document.getElementById('pii-main-menu-button-a').click();");
		   try{
                       if (login==1)
                       {
                             WebDriverWait wait2 = new WebDriverWait(driver,20);
                             wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();
                       }
                }catch (NoSuchElementException e){
                       throw e;
                }
		  //Clicks on Remote Verification
		  jse.executeScript("return document.getElementById('pii-a-menu-rv').click();");
		  //Fills the mandatory fields
		  driver.findElement(By.id("pii-rv-tab-1-title")).sendKeys(obj1.event_title);
		  int i=0;
		  while(i<=obj1.details.length())
		  {
			  if(i+5<=obj1.details.length())
			  {
				  String ch= obj1.details.substring(i, i+5) ;
				  driver.findElement(By.id("pii-rv-tab-1-details")).sendKeys(ch);
			  }		
			  else
			  {
				  String ch= obj1.details.substring(i, obj1.details.length()) ;
				  driver.findElement(By.id("pii-rv-tab-1-details")).sendKeys(ch);
			  }	
			  i=i+5;
			  
		  }
		  Thread.sleep(2000);
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
			  i=0;
			  while(i<=obj1.details.length())
			  {
				  if(i+5<=obj1.details.length())
				  {
					  String ch= obj1.details.substring(i, i+5) ;
					  driver.findElement(By.id("pii-rv-tab-1-details")).sendKeys(ch);
				  }		
				  else
				  {
					  String ch= obj1.details.substring(i, obj1.details.length()) ;
					  driver.findElement(By.id("pii-rv-tab-1-details")).sendKeys(ch);
				  }	
				  i=i+5;
				  
			  }
		  }
		  //Select verifier
		  obj1.verifierSelect(driver);
		  Thread.sleep(1000);
		  String verifier= driver.findElement(By.id("pii-rv-verifier-name")).getAttribute("piivalue");
		  //Clicks twice on browse button of 2nd picture
		  WebElement element =  driver.findElement(By.id("pii-rv-imgperson-photo-input"));
		  Actions act = new Actions(driver);
		  act.doubleClick(element).build().perform();
		  Thread.sleep(3000);
		  try{
			  try {
					//Uploads picture 2
					  Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/IEChrysanthemum.exe");
					  p.waitFor();
				  }catch (UnhandledAlertException f){		
					  System.out.println("Unexpected alert for picture 2");
					  driver.switchTo().alert().accept();
				  }
			  
		  }catch (NoAlertPresentException f){			  
			  System.out.println ("No unexpected alert for picture 2");
		  }
		  Thread.sleep(4000);
		  //*Clears image
		  WebDriverWait wait1 = new WebDriverWait(driver,20);
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-imgperson-clear"))).click();
		  //Re-uploads picture 2
		  act.doubleClick(element).build().perform();
		  Thread.sleep(3000);
		  try{
			  try {
					//Uploads picture 2
					  Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/IEDesert.exe");
					  p.waitFor();
				  }catch (UnhandledAlertException f){		
					  System.out.println("Unexpected alert for picture 2");
					  driver.switchTo().alert().accept();
				  }
			  
		  }catch (NoAlertPresentException f){			  
			  System.out.println ("No unexpected alert for picture 2");
		  }
		  Thread.sleep(4000);
		  //Rotates image 2 once
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-imgperson-rotate"))).click();
		  //*
		  jse.executeScript("scroll(0, 250)");
		  Thread.sleep(3000);
		  //Clicks twice on browse button of 1st picture
		  WebElement element2 =  driver.findElement(By.id("pii-rv-imgwork-photo-input"));
		  act.doubleClick(element2).build().perform();
		  Thread.sleep(3000);
		  try{
			  try {
					  //Uploads picture 1
					  Process q=Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/IEChrysanthemum.exe");				  
					  q.waitFor();
			      }catch (UnhandledAlertException g){
			    	  System.out.println("Unexpected alert for picture 1");
					  driver.switchTo().alert().accept();
			      }
		     }catch (NoAlertPresentException g){			  
			  System.out.println ("No unexpected alerts for picture 1");
		     }			 
		  Thread.sleep(4000);
		  //*Clears image
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-imgwork-clear"))).click();
		  //Re-uploads picture 1
		  act.doubleClick(element2).build().perform();
		  Thread.sleep(3000);
		  try{
			  try {
					  //Uploads picture 1
					  Process q=Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/IEDesert.exe");				  
					  q.waitFor();
			      }catch (UnhandledAlertException g){
			    	  System.out.println("Unexpected alert for picture 1");
					  driver.switchTo().alert().accept();
			      }
		     }catch (NoAlertPresentException g){			  
			  System.out.println ("No unexpected alerts for picture 1");
		     }			 
		  Thread.sleep(4000);
		  //Rotates image 1 twice
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-imgwork-rotate"))).click();
		  Thread.sleep(1000);
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-imgwork-rotate"))).click();
		  //*
		  jse.executeScript("scroll(0, 0)");
		  //Verifies Date and time
		  obj1.verifyDateTime(driver);
		  //Verifies location of office
		  obj1.verifyLongitudeLatitude(driver);
		  //Clicks on Save and Send
		  jse.executeScript("return document.querySelector(\"[class='pii-rv-save-send pii-new-button pii-color-purple ui-block-c ui-btn ui-btn-inline']\").click();");
		  //Clicks on save and send report
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-dialog-title")));
		  jse.executeScript("return document.getElementById('pii-rv-dialog-confirmed').click();");
		  Thread.sleep(3000);
		  //Creates the expected name of record
		  String creation_date = driver.findElement(By.xpath(".//*[@id='rv-rpt']/div/div[2]/div[3]")).getText();
		  creation_date= creation_date.substring(22, creation_date.length());
		  String name = creation_date +"_"+ username + "_" + obj1.event_title;
		  System.out.println("Expected name of record: " + name);
		  //Clicks on Remote Verification
		  jse.executeScript("return document.getElementById('pii-user-home-panel-btn-rv').click();");
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
		  obj1.downloadRecordIE(driver,verifier,username);
		  //Shares report, the integer indicates admin test =0 and non admin test =1
		  obj1.shareReport(driver,verifier,username,0);
		  //Mark critical
		  obj1.markCritical(driver);
		  //Deletes the newly created record
		  obj1.deleteNewRecord(driver,recordName);
		  //Logs out
		  jse.executeScript("return document.getElementById('pii-user-loginname').click();");
		  jse.executeScript("return document.getElementById('pii-signout-button').click();");
		  Thread.sleep(2000);	  
		  afterTest();
	  }

	  
	  public void afterTest() {
		   driver.quit();
		   softly.assertAll();
	  }

}
