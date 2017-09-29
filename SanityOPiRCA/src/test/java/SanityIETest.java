import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SanityIETest {

	private InternetExplorerDriver driver;
	private String username ="jenkins";
	private String password = "Kalejenkins@123";
	private String event_title="Sanity Test IE";
	private String ie_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\IEDriverServer.exe";
	private String url = "https://kaledev.error-free.com/";
	private int login =0;
	
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Performing sanity test on O&P IRCA in Internet Explorer");
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
	
	public void Login() throws Exception{
		  
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  System.out.println("Title before login: "+driver.getTitle());
		  //Login button is located and clicked
		  jse.executeScript("return document.getElementById('pii-login-button').click();");
		  //Login pop up is located and clicked
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("popupLogin"))).click();
		  Thread.sleep(2000);
		  //Username text field is located and the username is entered
		  driver.findElement(By.id("pii-un")).sendKeys(username);
		  //Password field is located and the password is entered
		  driver.findElement(By.id("pii-pw")).sendKeys(password);
		  Thread.sleep(2000);
		  //Sign in button is located and clicked
		  String user = driver.findElement(By.id("pii-un")).getAttribute("value");
		  String pw = driver.findElement(By.id("pii-pw")).getAttribute("value");
		  int c=1;
		  if (user.equals(username)==true)
		  {
			  if(pw.equals(password)==true)
			  {
				  //Sign in button is located and clicked
				  jse.executeScript("return document.getElementById('pii-signin-button').click();");  
				  while(c>0)
				  {
				  Thread.sleep(2000);
				  WebElement element = driver.findElement(By.id("pii-signin-message"));
				  String text = element.getText();
				  if (element.isDisplayed())
				  {
					  if(text.isEmpty())
					  {
						  System.out.println("Logged in");
					  else
					  {
						  driver.findElement(By.id("pii-pw")).sendKeys(password);
						  break;
						  }
						  //Sign in button is located and clicked
						  jse.executeScript("return document.getElementById('pii-signin-button').click();");
						  login =1;
						  break;
					  }
					  			  
				  }
			  }}
			
		  }
		  if ((user.equals(username)==false)||(pw.equals(password)==false))
		    {
				  while(c>0)
				  {
					  Thread.sleep(1000);
					  driver.findElement(By.id("pii-un")).clear();
					  driver.findElement(By.id("pii-pw")).clear();
					  //Username text field is located and the username is entered
					  driver.findElement(By.id("pii-un")).sendKeys(username);
					  //Password field is located and the password is entered
					  driver.findElement(By.id("pii-pw")).sendKeys(password);
					  user = driver.findElement(By.id("pii-un")).getAttribute("value");
					  pw = driver.findElement(By.id("pii-pw")).getAttribute("value");
					  if (user.equals(username)==true)
					  {
						  if(pw.equals(password)==true)
						  {
							  //Sign in button is located and clicked
							  jse.executeScript("return document.getElementById('pii-signin-button').click();");
							  break;
						  }
						
					  }
				  }
			  
			  
		  }
	  }
	
	
	public void deleteNewRecord(String recordName) throws Exception{
		  
		
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  //CLicks on first newly created record
		  driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-opa']/ul/li[2]/a")).click();
		  //Clicks on delete button
		  driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[3]")).click();
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title")));
		  //Clicks on delete report
		  jse.executeScript("return document.getElementById('pii-user-home-dialog-confirmed').click();");
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  Thread.sleep(2000);
		  jse.executeScript("return document.getElementById('pii-user-home-panel-btn-opa').click();");
		  //Verify record deleted
		  //Click on 1st record
		  String name = driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-opa']/ul/li[2]/a")).getText();
		  System.out.println(name);
		  if (name!=recordName)
			  System.out.println("Record deleted");
		  else
			  System.out.println("Record could not be deleted");
		  			  
	  }
	
	
	@Test
	public void test() throws Exception{
		  Login();
		  System.out.println("Title after login: "+driver.getTitle());
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  Thread.sleep(5000);
		  //Switches to the iframe
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
		  try{
              if (login==1)
              {
                    WebDriverWait wait2 = new WebDriverWait(driver,20);
                    wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();
              }
              }catch (NoSuchElementException e){
              throw e;
              }
		  System.out.println("Waiting for page to load");
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  //Clicks on Analysis
		  jse.executeScript("return document.getElementById('pii-main-menu-button-a').click();");
		  //Clicks on O&P IRCA
		  jse.executeScript("return document.getElementById('pii-a-menu-opirca').click();");
		  //Fills the mandatory fields
		  driver.findElement(By.id("pii-opa-event-title")).sendKeys(event_title);
		  driver.findElement(By.id("pii-opa-event-location")).sendKeys("San Diego");
		  driver.findElement(By.id("pii-opa-event-pbstatement")).sendKeys("Sanity Test");
		  driver.findElement(By.id("pii-opa-event-events")).sendKeys("Sanity Test");
		  driver.findElement(By.id("pii-opa-event-bginfos")).sendKeys("Sanity Test");
		  driver.findElement(By.id("pii-opa-event-investigators")).sendKeys("Sanity Test");
		  String ev1 = driver.findElement(By.id("pii-opa-event-title")).getAttribute("value");
		  String ev2 = driver.findElement(By.id("pii-opa-event-location")).getAttribute("value");
		  String ev3 = driver.findElement(By.id("pii-opa-event-pbstatement")).getAttribute("value");
		  String ev4 = driver.findElement(By.id("pii-opa-event-events")).getAttribute("value");
		  String ev5 = driver.findElement(By.id("pii-opa-event-bginfos")).getAttribute("value");
		  String ev6 = driver.findElement(By.id("pii-opa-event-investigators")).getAttribute("value");
		  if ((ev1.equals(event_title)==false))
		  {
			  driver.findElement(By.id("pii-opa-event-title")).clear();
			  driver.findElement(By.id("pii-opa-event-title")).sendKeys(event_title);
		  }
		  if ((ev2.equals("San Diego")==false))
		  {
			  driver.findElement(By.id("pii-opa-event-location")).clear();
			  driver.findElement(By.id("pii-opa-event-location")).sendKeys("San Diego");
		  }
		  if ((ev3.equals("Sanity Test")==false))
		  {
			  driver.findElement(By.id("pii-opa-event-pbstatement")).clear();
			  driver.findElement(By.id("pii-opa-event-pbstatement")).sendKeys("Sanity Test");
		  }
		  if ((ev4.equals("Sanity Test")==false))
		  {
			  driver.findElement(By.id("pii-opa-event-events")).clear();
			  driver.findElement(By.id("pii-opa-event-events")).sendKeys("Sanity Test");
		  }
		  if ((ev5.equals("Sanity Test")==false))
		  {
			  driver.findElement(By.id("pii-opa-event-bginfos")).clear();
			  driver.findElement(By.id("pii-opa-event-bginfos")).sendKeys("Sanity Test");
		  }
		  if ((ev6.equals("Sanity Test")==false))
		  {
			  driver.findElement(By.id("pii-opa-event-investigators")).clear();
			  driver.findElement(By.id("pii-opa-event-investigators")).sendKeys("Sanity Test");
		  }
		  
		  //Clicks on save button
		  jse.executeScript("return document.getElementById('efi-opa-button-save').click();");
		  //Clicks on save report
		  WebDriverWait wait1 = new WebDriverWait(driver,30);
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-opa-dialog-title")));
		  jse.executeScript("return document.getElementById('pii-opa-dialog-confirmed').click();");
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  
		  //Creates the expected name of record
		  String creationDate = driver.findElement(By.id("pii-opa-event-repdatetime")).getAttribute("value");
		  String name = creationDate +"_"+ username + "_" + event_title;
		  System.out.println("Expected name of record: " + name);
		  
		  //Click on saved activities
		  jse.executeScript("return document.getElementById('efi-opa-btn-savedactivities').click();");
		  Thread.sleep(3000);
		  //Clicks on O&P IRCA side panel
		  jse.executeScript("return document.getElementById('pii-user-home-panel-btn-opa').click();");
		  WebElement record = driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-opa']/ul/li[2]/a"));
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
		  if (driver.findElement(By.className("sticky-close")).isDisplayed())
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();
		  //Logs out
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-signout-button"))).click();
		  Thread.sleep(2000);
		  afterTest();
	}
	
	
	public void afterTest(){
		
		//Browser closes
		driver.quit();
	}

}
