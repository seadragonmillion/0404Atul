import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SanityHiRCAInternetExplorerTest {

	private WebDriver driver;
	
	  
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Performing sanity test on HiRCA in Internet Explorer");
		 System.setProperty("webdriver.ie.driver","C:\\Ritica\\selenium\\IEDriverServer.exe");
		 DesiredCapabilities cap = new DesiredCapabilities(); 
		// InternetExplorerOptions options = new InternetExplorerOptions();
		  //options.introduceFlakinessByIgnoringSecurityDomains();
		  //options.requireWindowFocus();
		  //options.ignoreZoomSettings();
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
		  //Login button is located and clicked
		  driver.findElement(By.id("pii-login-button")).click();
		  //Login pop up is located and clicked
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("popupLogin"))).click();
		  //Username text field is located and the username is entered
		  driver.findElement(By.id("pii-un")).sendKeys("ritica");
		  //Password field is located and the password is entered
		  driver.findElement(By.id("pii-pw")).sendKeys("Kale24982417@");
		  //Sign in button is located and clicked
		  driver.findElement(By.id("pii-signin-button")).click();
	  }
	  
	  @Test
	  public void SanityTest() throws Exception{
		  
		  Login();
		  System.out.println("Title after login: "+driver.getTitle());
		 
		  //assertEquals (driver.getTitle(), "KALE�");
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		  Thread.sleep(5000);
		  System.out.println("Waiting for page to load");
		  System.out.print(driver.getPageSource());
		  driver.findElement(By.xpath("/html/body/section/article[1]/div[2]/div/a[2]/b")).sendKeys(Keys.ENTER);
		 /* try
		  {
			  Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		                .withTimeout(20, TimeUnit.SECONDS)

		                .pollingEvery(5, TimeUnit.SECONDS)

		        .ignoring(org.openqa.selenium.NoSuchElementException.class);
			  WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
				     public WebElement apply(WebDriver driver) {
				       return driver.findElement(By.className("pii-main-menu-button ui-icon-kale-a ui-btn-inline ui-btn"));
				     }
			   });
			  if (foo.isDisplayed())
				  System.out.println("\n");
			  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-a"))).click();
			  //driver.findElement(By.id("pii-main-menu-button-a")).click();
		  }catch (UnhandledAlertException f){			  
			  driver.switchTo().alert().dismiss();
		  }*/
		  /*
		  driver.findElement(By.id("pii-a-menu-hirca")).click();
		  driver.findElement(By.id("pii-irca-event-title")).sendKeys("Sanity Test 24");
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
		  String name = creationDate + "_ritica_Sanity Test 24" ;
		  System.out.println(name);
		  driver.findElement(By.id("efi-irca-btn-savedactivities")).click();
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
		  driver.findElement(By.id("pii-signout-button")).click();			 */
	  }
	  
	  		  
	 @After
	  public void afterTest() {/*
		  WebDriverWait wait = new WebDriverWait(driver,20);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-login-button")));
		  driver.quit();*/
	  }

}
