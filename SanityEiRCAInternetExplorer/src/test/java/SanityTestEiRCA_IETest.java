import static org.junit.Assert.*;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;

public class SanityTestEiRCA_IETest {

	private InternetExplorerDriver driver;
	private int login =0;
	  
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Performing sanity test on HiRCA in Internet Explorer");
		  System.setProperty("webdriver.ie.driver","C:\\Users\\rramakrishnan\\DriversForSelenium\\IEDriverServer.exe");
		  DesiredCapabilities cap = new DesiredCapabilities(); 
		  cap.setCapability("ignoreZoomSettings", true);
		  cap.setCapability("requireWindowFocus", true);
		  driver = new InternetExplorerDriver(cap);
		  //Browser is maximized
		  driver.manage().window().maximize();
		  //Browser navigates to the KALE url
		  driver.navigate().to("https://kaledev.error-free.com/");
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }
	  
	
	  public void Login() {
		  
		  System.out.println("Title before login: "+driver.getTitle());
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  //Login button is located and clicked
		  jse.executeScript("return document.getElementById('pii-login-button').click();");
		  //Login pop up is located and clicked
		  WebDriverWait wait = new WebDriverWait(driver,20);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("popupLogin"))).click();
		  //Username text field is located and the username is entered
		  driver.findElement(By.id("pii-un")).sendKeys("jenkins");
		  //Password field is located and the password is entered
		  driver.findElement(By.id("pii-pw")).sendKeys("Kalejenkins@123");
		  //Sign in button is located and clicked
		  jse.executeScript("return document.getElementById('pii-signin-button').click();");
		  WebElement element = driver.findElement(By.id("pii-signin-message"));
                String text = element.getText();
                if (element.isDisplayed())
                {
                       if(text.isEmpty())
                             System.out.println("Logged in");
                       else
                       {
                             driver.findElement(By.id("pii-pw")).sendKeys("Kalejenkins@123");
                             //Sign in button is located and clicked
                             jse.executeScript("return document.getElementById('pii-signin-button').click();");
                             login =1;
                       }
                                            
                }
		  
	  }
	  
	  public void deleteNewRecord(String recordName) throws Exception{
		  
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  //CLicks on first newly created record
		  driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-mirca']/ul/li[2]/a")).click();
		  //Clicks on delete button
		  driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[3]")).click();
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title")));
		  //Clicks on delete report
		  jse.executeScript("return document.getElementById('pii-user-home-dialog-confirmed').click();");
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  Thread.sleep(2000);
		  jse.executeScript("return document.getElementById('pii-user-home-panel-btn-mirca').click();");
		  //Verify record deleted
		  //Click on 1st record
		  String name = driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-mirca']/ul/li[2]/a")).getText();
		  System.out.println(name);
		  if (name!=recordName)
			  System.out.println("Record deleted");
		  else
			  System.out.println("Record could not be deleted");
		  			  
	  }
	  
	  @Test
	  public void SanityTest() throws Exception{
		  
		  Login();
		  System.out.println("Title after login: "+driver.getTitle());
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  Thread.sleep(5000);
		  //Switches to the iframe
		  WebDriverWait wait = new WebDriverWait(driver,20);
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
		  System.out.println("Waiting for page to load");
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  try{
                       if (login==1)
                       {
                             WebDriverWait wait2 = new WebDriverWait(driver,20);
                             wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();
                       }
                }catch (NoSuchElementException e){
                       throw e;
                }
		  //Clicks on Analysis
		  jse.executeScript("return document.getElementById('pii-main-menu-button-a').click();");
		  //Clicks on EiRCA
		  jse.executeScript("return document.getElementById('pii-a-menu-eirca').click();");
		  Thread.sleep(1000);
		  //Fills all mandatory fields
		  driver.findElement(By.id("pii-ircam-tab-1-title")).sendKeys("Sanity Test IE");
		  driver.findElement(By.id("pii-ircam-tab-1-location")).sendKeys("San Diego");
		  driver.findElement(By.id("pii-ircam-tab-1-who")).sendKeys("Sanity Test"); 
		  driver.findElement(By.id("pii-ircam-tab-1-investigators")).sendKeys("Sanity Test");
		  driver.findElement(By.id("pii-ircam-tab-1-reviewer")).sendKeys("Sanity Test");
		  driver.findElement(By.id("pii-ircam-tab-1-management-sponsor")).sendKeys("Sanity Test");
		  driver.findElement(By.id("pii-ircam-tab-1-problem-statement")).sendKeys("Sanity Test");
		  driver.findElement(By.id("pii-ircam-tab-1-failed-component")).sendKeys("Sanity Test");
		  //Clicks on Save button
		  jse.executeScript("return document.getElementById('pii-ircam-save').click();");
		  //Clicks on Save Report button
		  WebDriverWait wait1 = new WebDriverWait(driver,10);
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-ircam-dialog-title"))).click();
		  jse.executeScript("return document.getElementById('pii-ircam-dialog-confirmed').click();");
		  //Waits for the green popup on the right top corner
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  //Gets the value from the text field report creation date
		  String creationDate = driver.findElement(By.id("pii-ircam-tab-1-repdatetime")).getAttribute("value");
		  String name = creationDate + "_jenkins_Sanity Test IE" ;
		  System.out.println(name);
		  //Clicks on Saved activities button
		  jse.executeScript("return document.getElementById('pii-ircam-savedactivities').click();");
		  Thread.sleep(2000);
		  //Clicks on panel on the left on EiRCA
		  jse.executeScript("return document.getElementById('pii-user-home-panel-btn-mirca').click();");
		  Thread.sleep(2000);
		  //Gets the name of the record created
		  WebElement record = driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-mirca']/ul/li[2]/a"));
		  String recordName = record.getText();
		  if (record.isDisplayed())
		  {
			  System.out.println("Record found: "+ recordName);
		  }
		  else
			  System.out.println ("Record not found.");
		  //Checks if the name displayed on record is same as expected
		  assertEquals(name, recordName);
		  //Deletes the newly created record
		  deleteNewRecord(recordName);
		  //Logs out
		  jse.executeScript("return document.getElementById('pii-user-loginname').click();");
		  jse.executeScript("return document.getElementById('pii-signout-button').click();");
		  Thread.sleep(3000);
		  afterTest();
		  		  
	  }
	  
	  
	  public void afterTest() {
		   driver.quit();
	  }

}
