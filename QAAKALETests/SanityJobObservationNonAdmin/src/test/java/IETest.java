import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IETest {

	private InternetExplorerDriver driver;
	private String username ="jenkinsvmnonadmin";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String ie_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\IEDriverServer.exe";
	private String url = "https://kaledev.error-free.com/";
	SoftAssertions softly = new SoftAssertions();
	
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Performing sanity test on Job Observation Analysis in Internet Explorer");
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
		  JobObservation obj1 = new JobObservation();
		  //Logs in
		  int login = obj.LoginUser(driver, username, password);
		  System.out.println("Title after login: "+driver.getTitle());
		  //Waits for the page to load
	      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	      Thread.sleep(2000);
	      //Switches to the iframe
		  driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		  
		  Thread.sleep(4000);
		  WebDriverWait wait = new WebDriverWait(driver,20);
		  //Clicks on Analysis 
		  try
		  {
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-a"))).click();
		  }catch (UnhandledAlertException f){			  
			  driver.switchTo().alert().dismiss();
		  }
		  if (login==1)
          {
                
                while(true)
    		  {
               	 Thread.sleep(1000);
    			  if (driver.findElement(By.cssSelector(".sticky-queue.top-right")).isDisplayed())
    			  {
    				  WebElement ele =driver.findElement(By.cssSelector(".sticky-queue.top-right"));
    				  ele.findElement(By.className("sticky-close")).click();
    				  break;
    			  }
    			  else break;
    		  }
          }
		  //Clicks on Job Observation Analysis
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-jo"))).click();
		  //Clicks on new
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-new"))).click();
		  //Click on new report
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-dialog-title"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-dialog-confirmed"))).click();
		  //Fills mandatory details in step1
		  driver.findElement(By.id("pii-joa-tab-1-observer")).sendKeys("Sanity Test");
		  driver.findElement(By.id("pii-joa-tab-1-location")).sendKeys("Sanity Test");
		  driver.findElement(By.id("pii-joa-tab-1-job")).sendKeys("Sanity Test");
		  String ev1 = driver.findElement(By.id("pii-joa-tab-1-observer")).getAttribute("value");
		  String ev2 = driver.findElement(By.id("pii-joa-tab-1-location")).getAttribute("value");
		  String ev3 = driver.findElement(By.id("pii-joa-tab-1-job")).getAttribute("value");
		  if ((ev1.equals("Sanity Test")==false))
		  {
			  driver.findElement(By.id("pii-joa-tab-1-observer")).clear();
			  driver.findElement(By.id("pii-joa-tab-1-observer")).sendKeys("Sanity Test");
		  }
		  if ((ev2.equals("Sanity Test")==false))
		  {
			  driver.findElement(By.id("pii-joa-tab-1-location")).clear();
			  driver.findElement(By.id("pii-joa-tab-1-location")).sendKeys("Sanity Test");
		  }
		  if ((ev3.equals("Sanity Test")==false))
		  {
			  driver.findElement(By.id("pii-joa-tab-1-job")).clear();
			  driver.findElement(By.id("pii-joa-tab-1-job")).sendKeys("Sanity Test");
		  }
		  //Clicks on next
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-joa-tab-1-form']/div[6]/div/button"))).click();
		  //Uploads image, clears it, rotates it
		  obj1.imageUploadIE(driver);
		  //Modify date time
		  obj1.dateTimeModifyIE(driver);
		  //Continues on 
		  obj1.path(driver);
		  //Waits for the green popup on the right top corner
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  //Clicks on saved activities
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-btn-savedactivities"))).click();
		  //Clicks on side panel option for job observation
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-joa"))).click();
		  //Gets the name of the record created
		  WebElement record = driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-joa']/ul/li[2]/a"));
		  String recordName = record.getText();
		  if (record.isDisplayed())
		  {
			  System.out.println("Record found: "+ recordName);
		  }
		  else
			  System.out.println ("Record not found.");
		  
		  Thread.sleep(2000);
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
		  obj1.shareReport(driver,username,password, 1);
		  Thread.sleep(2000);
		  //Mark critical integer same as shareReport
		  obj1.markCritical(driver,username, password,1);
		  //Deletes the newly created record, integer same as shareReport
		  obj1.deleteNewRecord(driver, recordName,1);
		  //Logs out
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-signout-button"))).click();
		  Thread.sleep(2000);
		  afterTest();
		  		  
	}
	
	
	public void afterTest(){
		
	    //Browser closes
		driver.quit();
		softly.assertAll();
	}

}
