import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.Timeout;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class IETest {

	private InternetExplorerDriver driver;
	private String username ="ritica";
	private String password = "Kale46191802@";
	private String ie_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\IEDriverServer.exe";
	private String url = "https://kale.error-free.com/";
	private int login =0;
	
	@SuppressWarnings("deprecation")
	@Rule
	  public Timeout globalTimeout= new Timeout(240000);
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Performing sanity test on HPI in Internet Explorer");
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
		  /*driver.findElement(By.id("pii-home")).sendKeys(Keys.CONTROL);
		  driver.findElement(By.id("pii-home")).sendKeys(Keys.F11);*/
		  
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
						  break;
						  }
					  else
					  {
						  driver.findElement(By.id("pii-pw")).sendKeys(password);
						  //Sign in button is located and clicked
						  jse.executeScript("return document.getElementById('pii-signin-button').click();");
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
							  jse.executeScript("return document.getElementById('pii-signin-button').click();");
							  break;
						  }
						
					  }
				  }
			  
			  
		  }
	  }
	
	public void deleteNewRecord(String recordName) throws Exception{
		  
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  //CLicks on first newly created record
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-hpi']/ul/li[2]/a"))).click();
		  //Clicks on delete button
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title")));
		  //Clicks on delete report
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  Thread.sleep(2000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-hpi"))).click();
		  //Verify record deleted
		  //Click on 1st record
		  Thread.sleep(2000);
		  String name = driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-hpi']/ul/li[2]/a")).getText();
		  System.out.println(name);
		  if (name!=recordName)
			  System.out.println("Record deleted");
		  else
			  System.out.println("Record could not be deleted");
		  
		  
		  			  
	  }
	
	@Test
	  public void SanityTest() throws Exception{
		try{
		WebDriverWait wait = new WebDriverWait(driver,20);  
		
		  Login();
		  System.out.println("Title after login: "+driver.getTitle());
		  //Waits for the page to load
	      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	      Thread.sleep(2000);
	      //Switches to the iframe
		  driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		  
		  Thread.sleep(10000);
		  
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
		  
		  //Clicks on HPI
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-hpi"))).click();
		  Thread.sleep(2000);
		  //Select Purpose from dropdown
		  WebElement element = driver.findElement(By.id("pii-hpi-select-purpose"));
		  Select s = new Select (element);
		  s.selectByVisibleText("PJB");
		  Thread.sleep(2000);
		  //Select Job type
		  element = driver.findElement(By.id("pii-hpi-select-condition"));
		  Select s1 = new Select (element);
		  s1.selectByVisibleText("Analysis");
		  Thread.sleep(2000);
		  //Click on next
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-btn-next"))).click();
		  Thread.sleep(2000);
		  //Click on finalize
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-btn-done"))).click();
		  Thread.sleep(2000);
		  //Click on finalize and save
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-dialog-title"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-dialog-confirmed"))).click(); 
		  //Waits for the green popup on the right top corner
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  //Creates expected record name
		  Thread.sleep(2000);
		  String date= driver.findElement(By.xpath(".//*[@id='pii-hpi-rpt-header']/span/span")).getText();
		  System.out.println(date);
		  String name = date + "_" +username;
		  System.out.println ("Expected name of record: " +name);
		  //Clicks on side panel
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-hpi"))).click();
		  //Gets the name of the record created
		  WebElement record = driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-hpi']/ul/li[2]/a"));
		  String recordName = record.getText();
		  if (record.isDisplayed())
		  {
			  System.out.println("Record found: "+ recordName);
		  }
		  else
			  System.out.println ("Record not found.");
		  	
		  //Checks if the record name is correct
		  assertEquals(name,recordName);
		  //Deletes the record
		   deleteNewRecord(recordName);
		  //Logs out
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-signout-button"))).click();
		  Thread.sleep(2000);
		  afterTest();
		}catch(TimeoutException e)
		{
			/*driver.findElement(By.id("pii-home")).sendKeys(Keys.CONTROL);
			driver.findElement(By.id("pii-home")).sendKeys(Keys.F11);*/
			driver.quit();
		}
	
		 
		  
	}
	
	
	public void afterTest(){
		
	/*	driver.findElement(By.id("pii-home")).sendKeys(Keys.CONTROL);
		driver.findElement(By.id("pii-home")).sendKeys(Keys.F11);*/
		//Browser closes
		driver.quit();
	}
	
	
	

}
