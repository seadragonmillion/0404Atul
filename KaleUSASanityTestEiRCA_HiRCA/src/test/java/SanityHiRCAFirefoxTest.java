import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SanityHiRCAFirefoxTest {
	private FirefoxDriver driver;
	private String username ="ritica";
	private String password = "Kale46191802@";
	private String gecko_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\geckodriver.exe";
	private String url = "https://kale.error-free.com/";
	private String EventTitleFirefox = "Sanity Test Firefox";		
	  
		@Before
		  public void beforeTest() throws MalformedURLException{
			  System.out.println("Performing sanity test on HiRCA in Firefox");
			  System.setProperty("webdriver.gecko.driver",gecko_path);
			  driver = new FirefoxDriver();
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
			  Thread.sleep(4000);
			  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			  //Switches to the iframe
			  driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
			  driver.findElement(By.id("pii-main-menu-button-a")).click();
			 
			  
			  driver.findElement(By.id("pii-a-menu-hirca")).click();
			  driver.findElement(By.id("pii-irca-event-title")).sendKeys(EventTitleFirefox);
			  driver.findElement(By.id("pii-irca-event-location")).sendKeys("San Diego");
			  driver.findElement(By.id("pii-irca-event-pbstatement")).sendKeys("Sanity Test");
			  driver.findElement(By.id("pii-irca-event-events")).sendKeys("Sanity Test - No timeline");
			  driver.findElement(By.id("pii-irca-event-bginfos")).sendKeys("Sanity Test - No background information");
			  driver.findElement(By.id("pii-irca-event-investigators")).sendKeys("Sanity Test - Ritica Ramakrishnan");
			  driver.findElement(By.id("efi-irca-button-save")).click();
			  WebDriverWait wait1 = new WebDriverWait(driver,10);
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).click();
			  driver.findElement(By.id("pii-irca-dialog-confirmed")).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-success")));
			  String creationDate = driver.findElement(By.id("pii-irca-event-repdatetime")).getAttribute("value");
			  String name = creationDate  + "_" +username +"_" + EventTitleFirefox;
			  System.out.println("Expected record name: " + name);
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
			  driver.findElement(By.id("pii-user-loginname")).click();
			  driver.findElement(By.id("pii-signout-button")).click();		 
		  }
		  
		  		  
		 @After
		  public void afterTest() throws Exception{
			  driver.switchTo().defaultContent();
			  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			  WebDriverWait wait = new WebDriverWait(driver,20);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-login-button")));
			  driver.quit();
		  }

}
