import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SanityTestEiRCA_ChromeTest {

	private WebDriver driver;
	private String username ="ritica";
	private String password = "Kale46191802@";
	private String chrome_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\chromedriver.exe";
	private String url = "https://kaleasia.error-free.com/";
	private String EventTitleChrome = "Sanity Test Chrome";	
	  
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Performing sanity test on EiRCA in Chrome");
		  System.setProperty("webdriver.chrome.driver",chrome_path);
		  driver = new ChromeDriver();
		  //Browser is maximized
		  driver.manage().window().maximize();
		  //Browser navigates to the KALE url
		  driver.navigate().to(url);
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }
	  
	
	  public void Login() {
		  
		  System.out.println("Title before login: "+driver.getTitle());
		  //Login button is located and clicked
		  driver.findElement(By.id("pii-login-button")).click();
		  //Login pop up is located and clicked
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("popupLogin"))).click();
		  //Username text field is located and the username is entered
		  driver.findElement(By.id("pii-un")).sendKeys(username);
		  //Password field is located and the password is entered
		  driver.findElement(By.id("pii-pw")).sendKeys(password);
		  //Sign in button is located and clicked
		  driver.findElement(By.id("pii-signin-button")).click();
	  }
	  
	  @Test
	  public void SanityTest() throws Exception{
		  
		  Login();
		  System.out.println("Title after login: "+driver.getTitle());
		  Thread.sleep(6000);
		  //Waits for the page to load
	      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  //Switches to the iframe
		  driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		  Thread.sleep(5000);
		  //Clicks on Analysis 
		  try
		  {
			  driver.findElement(By.id("pii-main-menu-button-a")).click();
		  }catch (UnhandledAlertException f){			  
			  driver.switchTo().alert().dismiss();
		  }
		  //Clicks on EiRCA
		  driver.findElement(By.id("pii-a-menu-eirca")).click();
		  Thread.sleep(1000);
		  //Fills all mandatory fields
		  driver.findElement(By.id("pii-ircam-tab-1-title")).sendKeys(EventTitleChrome);
		  driver.findElement(By.id("pii-ircam-tab-1-location")).sendKeys("San Diego");
		  driver.findElement(By.id("pii-ircam-tab-1-who")).sendKeys("Sanity Test"); 
		  driver.findElement(By.id("pii-ircam-tab-1-investigators")).sendKeys("Sanity Test");
		  driver.findElement(By.id("pii-ircam-tab-1-reviewer")).sendKeys("Sanity Test");
		  driver.findElement(By.id("pii-ircam-tab-1-management-sponsor")).sendKeys("Sanity Test");
		  driver.findElement(By.id("pii-ircam-tab-1-problem-statement")).sendKeys("Sanity Test");
		  driver.findElement(By.id("pii-ircam-tab-1-failed-component")).sendKeys("Sanity Test");
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  jse.executeScript("scroll(250, 0)");
		  //Clicks on Save button
		  driver.findElement(By.id("pii-ircam-save")).click();
		  //Clicks on Save Report button
		  WebDriverWait wait1 = new WebDriverWait(driver,10);
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-ircam-dialog-title"))).click();
		  driver.findElement(By.id("pii-ircam-dialog-confirmed")).click();
		  //Waits for the green popup on the right top corner
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  //Gets the value from the text field report creation date
		  String creationDate = driver.findElement(By.id("pii-ircam-tab-1-repdatetime")).getAttribute("value");
		  String name = creationDate + "_" +username+"_"+ EventTitleChrome;
		  System.out.println("Expected name of record: " + name);
		  //Clicks on Saved activities button
		  driver.findElement(By.id("pii-ircam-savedactivities")).click();
		  Thread.sleep(2000);
		  //Clicks on panel on the left on EiRCA
		  driver.findElement(By.id("pii-user-home-panel-btn-mirca")).click();
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
		  }

}
