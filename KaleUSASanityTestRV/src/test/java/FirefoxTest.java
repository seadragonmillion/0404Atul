import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Rule;
import org.junit.rules.Timeout;
import java.util.concurrent.TimeoutException;

public class FirefoxTest {
	private FirefoxDriver driver;
	private String username ="ritica";
	private String password = "Kale46191802@";
	private String event_title="Sanity Test Firefox";
	private String gecko_path = "C:\\Users\\rramakrishnan\\Downloads\\geckodriver-v0.19.0-win64\\geckodriver.exe";
	private String url = "https://kale.error-free.com/";
	private int login =0;
	
	@SuppressWarnings("deprecation")
	@Rule
	  public Timeout globalTimeout= new Timeout(240000);

	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		 System.out.println("Performing sanity test on Remote Verification in Firefox");
		 System.setProperty("webdriver.gecko.driver",gecko_path);
		 ProfilesIni ffProfiles = new ProfilesIni();
		 FirefoxProfile profile = ffProfiles.getProfile("customFirefox");
		 DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		 capabilities.setCapability(FirefoxDriver.PROFILE, profile);
		 driver = new FirefoxDriver(capabilities);
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
						  break;
						  }
					  else
					  {
						  driver.findElement(By.id("pii-pw")).sendKeys(password);
						  //Sign in button is located and clicked
						  driver.findElement(By.id("pii-signin-button")).click();
						  login =1;
						  break;
					  }
					  			  
				  }
				  else break;
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
							  driver.findElement(By.id("pii-signin-button")).click();
							  break;
						  }
						
					  }
				  }
			  
			  
		  }
			  
		}
	
	public void deleteNewRecord(String recordName) throws Exception{
		  
		  //CLicks on first newly created record
		  driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-rv']/ul/li[2]/a")).click();
		  Thread.sleep(2000);
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  //Clicks on delete button
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).click();
		  
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title")));
		  //Clicks on delete report
		  driver.findElement(By.id("pii-user-home-dialog-confirmed")).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  Thread.sleep(2000);
		  driver.findElement(By.id("pii-user-home-panel-btn-rv")).click();
		  //Verify record deleted
		  //Click on 1st record
		  String name = driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-rv']/ul/li[2]/a")).getText();
		  System.out.println(name);
		  if (name!=recordName)
			  System.out.println("Record deleted");
		  else
			  System.out.println("Record could not be deleted");
		  			  
	  }
	  
	   
	  @Test
	  public void SanityTest() throws Exception{
		  try{
		  Login();
		  Thread.sleep(7000);
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
		  driver.findElement(By.id("pii-rv-tab-1-title")).sendKeys(event_title);
		  driver.findElement(By.id("pii-rv-tab-1-details")).sendKeys("Sanity Test");
		  String ev1 = driver.findElement(By.id("pii-rv-tab-1-title")).getAttribute("value");
		  String ev2 = driver.findElement(By.id("pii-rv-tab-1-details")).getAttribute("value");
		  if ((ev1.equals(event_title)==false))
		  {
			  driver.findElement(By.id("pii-rv-tab-1-title")).clear();
			  driver.findElement(By.id("pii-rv-tab-1-title")).sendKeys(event_title);
		  }
		  if((ev2.equals("Sanity Test"))==false)
		  {
			  driver.findElement(By.id("pii-rv-tab-1-details")).clear();
			  driver.findElement(By.id("pii-rv-tab-1-details")).sendKeys("Sanity Test");
		  }
		  //Selects the remote verifier
		  driver.findElement(By.id("pii-rv-verifier-list-input")).sendKeys("qaa");
		  WebElement select = driver.findElement(By.id("pii-rv-verifier-list-ul"));
		  WebElement option = select.findElement(By.cssSelector(".ui-li-static.ui-body-inherit.ui-last-child"));
		  option.click();
		  //Clicks on browse button of 2nd picture
		  driver.findElement(By.id("pii-rv-imgperson-photo-input")).click();
		  Thread.sleep(2000);
		 //Uploads picture 2
		  Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaChrysanthemum.exe");
		  Thread.sleep(8000);
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  jse.executeScript("scroll(0, 250)");
		  //Clicks on browse button of 1st picture
		  driver.findElement(By.id("pii-rv-imgwork-photo-input")).click();
		  Thread.sleep(2000);
		  //Uploads picture 1
		  Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaDesert.exe");
		  Thread.sleep(4000);
		  jse.executeScript("scroll(0, 0)");
		  //Clicks on Save and Send
		  driver.findElement(By.xpath("//*[@id='pii-rv-tabs']/div[2]/div/a[2]")).click();
		  //Clicks on save and send report
		  WebDriverWait wait1 = new WebDriverWait(driver,10);
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-dialog-title"))).click();
		  driver.findElement(By.id("pii-rv-dialog-confirmed")).click();
		  Thread.sleep(3000);
		  //Creates the expected name of record
		  String creation_date = driver.findElement(By.xpath(".//*[@id='rv-rpt']/div/div[2]/div[3]")).getText();
		  creation_date= creation_date.substring(22, creation_date.length());
		  String name = creation_date +"_"+ username + "_" + event_title;
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
		 //Deletes the newly created record
		  deleteNewRecord(recordName);
		  //Logs out
		  driver.findElement(By.id("pii-user-loginname")).click();
		  driver.findElement(By.id("pii-signout-button")).click();	
		  afterTest();
		  }catch (TimeoutException e)
			  {
				  driver.quit();
			  }

	  }
	  
	
	  public void afterTest() {
		 
		 driver.switchTo().defaultContent();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 //Waits for the login button
		 WebDriverWait wait = new WebDriverWait(driver,20);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-home-buttons-div")));
		 //Browser is closed
		 driver.quit();
	  }


}
