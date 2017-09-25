import static org.junit.Assert.*;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SanityTestRV_IE {

	private InternetExplorerDriver driver;
	private String username ="jenkins";
	private String password = "Kalejenkins@123";
	private String event_title="Sanity Test IE";
	private String ie_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\IEDriverServer.exe";
	private String url = "https://kaledev.error-free.com/";
	  
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Performing sanity test on Remote Verification in Internet Explorer");
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
	  
	
	  public void Login() {
		  
		  System.out.println("Title before login: "+driver.getTitle());
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  //Login button is located and clicked
		  jse.executeScript("return document.getElementById('pii-login-button').click();");
		  //Login pop up is located and clicked
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("popupLogin")));
		  //Username text field is located and the username is entered
		  driver.findElement(By.id("pii-un")).sendKeys(username);
		  //Password field is located and the password is entered
		  driver.findElement(By.id("pii-pw")).sendKeys(password);
		  //Sign in button is located and clicked
		  jse.executeScript("return document.getElementById('pii-signin-button').click();");
		  
	  }
	  
	  
	  @Test
	  public void SanityTest() throws Exception{
		  
		  Login();
		  System.out.println("Title after login: "+driver.getTitle());
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  Thread.sleep(5000);
		  //Switches to the iframe
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
		  System.out.println("Waiting for page to load");
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  //Clicks on Analysis
		  jse.executeScript("return document.getElementById('pii-main-menu-button-a').click();");
		  //Clicks on Remote Verification
		  jse.executeScript("return document.getElementById('pii-a-menu-rv').click();");
		  //Fills the mandatory fields
		  driver.findElement(By.id("pii-rv-tab-1-title")).sendKeys(event_title);
		  driver.findElement(By.id("pii-rv-tab-1-details")).sendKeys("Sanity Test");
		  //Selects the remote verifier
		  driver.findElement(By.id("pii-rv-verifier-list-input")).sendKeys("qaa");
		  WebElement select = driver.findElement(By.id("pii-rv-verifier-list-ul"));
		  WebElement option = select.findElement(By.cssSelector(".ui-li-static.ui-body-inherit.ui-first-child"));
		  option.click();
		  //Clicks twice on browse button of 2nd picture
		  WebElement element =  driver.findElement(By.id("pii-rv-imgperson-photo-input"));
		  Actions act = new Actions(driver);
		  act.doubleClick(element).build().perform();
		  Thread.sleep(2000);
		  try{
			  try {
					//Uploads picture 2
					  Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/IEChrysanthemum.exe");
					  		  
				  }catch (UnhandledAlertException f){		
					  System.out.println("Unexpecetd alert for picture 2");
					  driver.switchTo().alert().accept();
				  }
			  
		  }catch (NoAlertPresentException f){			  
			  System.out.println ("No unexpected alert for picture 2");
		  }
		  Thread.sleep(2000);
		  jse.executeScript("scroll(0, 250)");
		  //Clicks twice on browse button of 1st picture
		  WebElement element2 =  driver.findElement(By.id("pii-rv-imgwork-photo-input"));
		  act.doubleClick(element2).build().perform();
		  Thread.sleep(2000);
		  try{
			  try {
					  //Uploads picture 1
					  Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/IEDesert.exe");				  
			      }catch (UnhandledAlertException g){
			    	  System.out.println("Unexpecetd alert for picture 1");
					  driver.switchTo().alert().accept();
			      }
		     }catch (NoAlertPresentException g){			  
			  System.out.println ("No unexpected alerts for picture 1");
		     }
			 
		  Thread.sleep(4000);
		  jse.executeScript("scroll(0, 0)");
		  //Clicks on Save and Send
		  jse.executeScript("return document.querySelector(\"[class='pii-rv-save-send pii-new-button pii-color-purple ui-block-c ui-btn ui-btn-inline']\").click();");
		  //Clicks on save and send report
		  WebDriverWait wait1 = new WebDriverWait(driver,10);
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-dialog-title")));
		  jse.executeScript("return document.getElementById('pii-rv-dialog-confirmed').click();");
		  Thread.sleep(3000);
		  //Creates the expected name of record
		  String creation_date = driver.findElement(By.xpath(".//*[@id='rv-rpt']/div/div[2]/div[3]")).getText();
		  creation_date= creation_date.substring(22, creation_date.length());
		  String name = creation_date +"_"+ username + "_" + event_title;
		  System.out.println("Expected name of record: " + name);
		  //Clicks on Remote Verification
		  jse.executeScript("return document.getElementById('pii-user-home-panel-btn-rv').click();");
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
		  //Logs out
		  jse.executeScript("return document.getElementById('pii-user-loginname').click();");
		  jse.executeScript("return document.getElementById('pii-signout-button').click();");
		  Thread.sleep(2000);	  
	  }

	  @After
	  public void afterTest() {
		   driver.quit();
	  }
}
