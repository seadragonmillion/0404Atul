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

public class SanityHiRCAInternetExplorerTest {

	private InternetExplorerDriver driver;
	private String username ="ritica";
	private String password = "Kale46191802@";
	private String ie_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\IEDriverServer.exe";
	private String url = "https://kaleasia.error-free.com/";
	private String EventTitleIE = "Sanity Test IE";
	private int login =0;
	  
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Performing sanity test on HiRCA in Internet Explorer");
		  System.setProperty("webdriver.ie.driver",ie_path);
		  DesiredCapabilities cap = new DesiredCapabilities(); 
		  cap.setCapability("ignoreZoomSettings", true);
		  //cap.setCapability("requireWindowFocus", true);
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
		  jse.executeScript("return document.getElementById('pii-signin-button').click();");
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
                             jse.executeScript("return document.getElementById('pii-signin-button').click();");
                             login =1;
                       }
                                            
                }
	  }
	  
	  public void deleteNewRecord(String recordName) throws Exception{
		  
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  //CLicks on first newly created record
		  driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a")).click();
		  //Clicks on delete button
		  driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[3]")).click();
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title")));
		  //Clicks on delete report
		  jse.executeScript("return document.getElementById('pii-user-home-dialog-confirmed').click();");
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  Thread.sleep(3000);
		  jse.executeScript("return document.getElementById('pii-user-home-panel-btn-irca').click();");
		  //Verify record deleted
		  //Click on 1st record
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
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  Thread.sleep(7000);
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
          Thread.sleep(3000);     
		  System.out.println("Waiting for page to load");
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  //Clicks on Analysis
		  jse.executeScript("return document.getElementById('pii-main-menu-button-a').click();");
		  Thread.sleep(2000);
		  //Clicks on HiRCA
		  jse.executeScript("return document.getElementById('pii-a-menu-hirca').click();");
		  Thread.sleep(2000);
		  //Fills in all mandatory fields
		  driver.findElement(By.id("pii-irca-event-title")).sendKeys(EventTitleIE);
		  driver.findElement(By.id("pii-irca-event-location")).sendKeys("San Diego");
		  driver.findElement(By.id("pii-irca-event-pbstatement")).sendKeys("Sanity Test");
		  driver.findElement(By.id("pii-irca-event-events")).sendKeys("Sanity Test");
		  driver.findElement(By.id("pii-irca-event-bginfos")).sendKeys("Sanity Test");
		  driver.findElement(By.id("pii-irca-event-investigators")).sendKeys("Sanity Test");
		  //Clicks on save button
		  jse.executeScript("return document.getElementById('efi-irca-button-save').click();");
		  //Clicks on save confirmed
		  WebDriverWait wait1 = new WebDriverWait(driver,10);
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).click();
		  Thread.sleep(2000);
		  jse.executeScript("return document.getElementById('pii-irca-dialog-confirmed').click();");
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-success")));
		  String creationDate = driver.findElement(By.id("pii-irca-event-repdatetime")).getAttribute("value");
		  String name = creationDate + "_" +username +"_" + EventTitleIE;
		  System.out.println("Expected record name: "+ name);
		  //Clicks on saved activities button
		  jse.executeScript("return document.getElementById('efi-irca-btn-savedactivities').click();");
		  jse.executeScript("return document.getElementById('pii-user-home-panel-btn-irca').click();");
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
		  //Clicks on logout
		  jse.executeScript("return document.getElementById('pii-user-loginname').click();");
		  jse.executeScript("return document.getElementById('pii-signout-button').click();");
		  Thread.sleep(2000);
		  afterTest();
		  		 
	  }
	  
	  		  
	  
	  public void afterTest() {
		   driver.close();
	  }

}
