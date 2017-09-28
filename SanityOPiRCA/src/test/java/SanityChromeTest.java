import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SanityChromeTest {
	
	private WebDriver driver;
	private String username ="jenkins";
	private String password = "Kalejenkins@123";
	private String event_title="Sanity Test Chrome";
	private String chrome_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\chromedriver.exe";
	private String url = "https://kaledev.error-free.com/";
	private int login =0;
		  
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Performing sanity test on O&P-IRCA in Chrome");
		  System.setProperty("webdriver.chrome.driver",chrome_path);
		  driver = new ChromeDriver();
		  //Browser is maximized
		  driver.manage().window().maximize();
		  //Browser navigates to the KALE url
		  driver.navigate().to(url);
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }
	  

	public void Login() throws Exception{
		  
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
		  String user = driver.findElement(By.id("pii-un")).getAttribute("value");
		  String pw = driver.findElement(By.id("pii-pw")).getAttribute("value");
		  int c=1;
		  if (user.equals(username)==true)
		  {
			  if(pw.equals(password)==true)
			  {
				  //Sign in button is located and clicked
				  driver.findElement(By.id("pii-signin-button")).click();  
				  WebElement element = driver.findElement(By.id("pii-signin-message"));
				  String text = element.getText();
				  if (element.isDisplayed())
				  {
					  if(text.isEmpty())
						  System.out.println("Logged in");
					  else
					  {
						  driver.findElement(By.id("pii-pw")).sendKeys(password);
						  //Sign in button is located and clicked
						  driver.findElement(By.id("pii-signin-button")).click();
						  login =1;
					  }
					  			  
				  }
			  }
			
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
							  driver.findElement(By.id("pii-signin-button")).click();
							  break;
						  }
						
					  }
				  }
			  
			  
		  }
			  
		}
	
	
	public void deleteNewRecord(String recordName) throws Exception{
		  
		  //CLicks on first newly created record
		  driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-opa']/ul/li[2]/a")).click();
		  //Clicks on delete button
		  driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[3]")).click();
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title")));
		  //Clicks on delete report
		  driver.findElement(By.id("pii-user-home-dialog-confirmed")).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  Thread.sleep(2000);
		  driver.findElement(By.id("pii-user-home-panel-btn-opa")).click();
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
	  public void SanityTest() throws Exception{
		  
		Login();
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
		  Thread.sleep(5000);
		  //Clicks on Analysis 
		  try
		  {
			  driver.findElement(By.id("pii-main-menu-button-a")).click();
		  }catch (UnhandledAlertException f){			  
			  driver.switchTo().alert().dismiss();
		  }
		  //Clicks on O&P IRCA
		  driver.findElement(By.id("pii-a-menu-opirca")).click();
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
		  driver.findElement(By.id("efi-opa-button-save")).click();
		  //Clicks on save report
		  WebDriverWait wait = new WebDriverWait(driver,30);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-opa-dialog-title")));
		  driver.findElement(By.id("pii-opa-dialog-confirmed")).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  
		  //Creates the expected name of record
		  String creationDate = driver.findElement(By.id("pii-opa-event-repdatetime")).getAttribute("value");
		  String name = creationDate +"_"+ username + "_" + event_title;
		  System.out.println("Expected name of record: " + name);
		  
		  //Click on saved activities
		  driver.findElement(By.id("efi-opa-btn-savedactivities")).click();
		  Thread.sleep(3000);
		  //Clicks on O&P IRCA side panel
		  driver.findElement(By.id("pii-user-home-panel-btn-opa")).click();
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
			  driver.findElement(By.className("sticky-close")).click();
		  //Logs out
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-signout-button"))).click();
		  afterTest();
		  
	}
	
	public void afterTest(){
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-login-button")));
		//Browser closes
		driver.quit();
	}
	

}
