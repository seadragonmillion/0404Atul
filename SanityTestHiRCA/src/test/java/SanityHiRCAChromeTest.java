import static org.junit.Assert.*;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SanityHiRCAChromeTest {

	 private WebDriver driver;
		
	  
		@Before
		  public void beforeTest() throws MalformedURLException{
			  
			  System.out.println("Performing sanity test on HiRCA in Chrome");
			  System.setProperty("webdriver.chrome.driver","C:\\Users\\rramakrishnan\\DriversForSelenium\\chromedriver.exe");
			  driver = new ChromeDriver();
			  //Browser is maximized
			  driver.manage().window().maximize();
			  //Browser navigates to the KALE url
			  driver.navigate().to("https://kaledev.error-free.com/");
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
			  driver.findElement(By.id("pii-un")).sendKeys("jenkins");
			  //Password field is located and the password is entered
			  driver.findElement(By.id("pii-pw")).sendKeys("Kalejenkins@123");
			  //Sign in button is located and clicked
			  driver.findElement(By.id("pii-signin-button")).click();
		  }
		  
		    public void deleteNewRecord(String recordName) {
			  
			  //CLicks on first newly created record
			  driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a")).click();
			  //Clicks on delete button
			  driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[3]")).click();
			  WebDriverWait wait = new WebDriverWait(driver,10);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title")));
			  //Clicks on delete report
			  driver.findElement(By.id("pii-user-home-dialog-confirmed")).click();
			  driver.findElement(By.id("pii-user-home-panel-btn-irca")).click();
			  //Verify record deleted
			  //Click on 1st record
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
			  String name = driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a")).getText();
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
			 
			 // assertEquals (driver.getTitle(), "KALE�");
			  Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		                .withTimeout(40, TimeUnit.SECONDS)

		                .pollingEvery(5, TimeUnit.SECONDS)

		        .ignoring(org.openqa.selenium.NoSuchElementException.class);
			  WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
				     public WebElement apply(WebDriver driver) {
				       return driver.findElement(By.className("ui-controlgroup-controls "));
				     }
			   });
			  if (foo.isDisplayed())
				  System.out.println("\n");
			  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			  driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
			  Thread.sleep(5000);
			  try
			  {
				  driver.findElement(By.id("pii-main-menu-button-a")).click();
			  }catch (UnhandledAlertException f){			  
				  driver.switchTo().alert().dismiss();
			  }
			  
			  driver.findElement(By.id("pii-a-menu-hirca")).click();
			  Thread.sleep(5000);
			  driver.findElement(By.id("pii-irca-event-title")).sendKeys("Sanity Test 24");
			  driver.findElement(By.id("pii-irca-event-location")).sendKeys("San Diego");
			  driver.findElement(By.id("pii-irca-event-pbstatement")).sendKeys("Sanity Test");
			  driver.findElement(By.id("pii-irca-event-events")).sendKeys("Sanity Test - No timeline");
			  driver.findElement(By.id("pii-irca-event-bginfos")).sendKeys("Sanity Test - No background information");
			  driver.findElement(By.id("pii-irca-event-investigators")).sendKeys("Sanity Test - Ritica Ramakrishnan");
			  JavascriptExecutor jse = (JavascriptExecutor)driver;
			  jse.executeScript("scroll(250, 0)");
			  WebDriverWait wait2 = new WebDriverWait(driver,10);
			  wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save")));
			  driver.findElement(By.id("efi-irca-button-save")).click();
			  WebDriverWait wait1 = new WebDriverWait(driver,10);
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).click();
			  driver.findElement(By.id("pii-irca-dialog-confirmed")).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-success")));
			  String creationDate = driver.findElement(By.id("pii-irca-event-repdatetime")).getAttribute("value");
			  String name = creationDate + "_jenkins_Sanity Test 24" ;
			  System.out.println(name);
			  driver.findElement(By.id("efi-irca-btn-savedactivities")).click();
			  Thread.sleep(2000);
			  driver.findElement(By.id("pii-user-home-panel-btn-irca")).click();
			  Thread.sleep(2000);
			  WebElement record = driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"));
			  String recordName = record.getText();
			  if (record.isDisplayed())
			  {
				  System.out.println("Record found: "+ recordName);
			  }
			  else
				  System.out.println ("Record not found.");
			  assertEquals(name, recordName);
			  //Deletes the newly created record
			  deleteNewRecord(recordName);
			  driver.findElement(By.id("pii-user-loginname")).click();
			  driver.findElement(By.id("pii-signout-button")).click();	
			  afterTest();
		  }
		  
		  		  
		 
		  public void afterTest() {
			  WebDriverWait wait = new WebDriverWait(driver,20);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-login-button")));
			  driver.quit();
		  }

}
