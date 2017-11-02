import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.assertj.core.api.SoftAssertions;
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
import org.openqa.selenium.NoSuchElementException;
import org.junit.Rule;
import org.junit.rules.Timeout;
import java.util.concurrent.TimeoutException;

public class SanityTestEiRCA_ChromeTest {

	private WebDriver driver;
	private int login =0;
	private String username ="qaacfi";
	 private String password = "Kale94935830@";
	SoftAssertions softly = new SoftAssertions();

	@SuppressWarnings("deprecation")
	@Rule
	  public Timeout globalTimeout= new Timeout(600000);
	  
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Performing sanity test non admin on EiRCA in Chrome");
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\rramakrishnan\\DriversForSelenium\\chromedriver.exe");
		  driver = new ChromeDriver();
		  //Browser is maximized
		  driver.manage().window().maximize();
		  //Browser navigates to the KALE url
		  driver.navigate().to("https://kaledev.error-free.com/");
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
		  //driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-mirca']/ul/li[2]/a")).click();
		  //Clicks on delete button
		  driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[3]")).click();
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title")));
		  //Clicks on delete report
		  driver.findElement(By.id("pii-user-home-dialog-confirmed")).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  Thread.sleep(2000);
		  driver.findElement(By.id("pii-user-home-panel-btn-mirca")).click();
		  //Verify record deleted
		  //Click on 1st record
		  String name = driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-mirca']/ul/li[2]/a")).getText();
		  System.out.println(name);
		  if (name!=recordName)
			  System.out.println("Record deleted");
		  else
			  System.out.println("Record could not be deleted");
		  			  
	  }


	  public void openReport() throws Exception{

		  WebDriverWait wait1 = new WebDriverWait(driver,30);
		//Clicks on first newly created record
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-mirca']/ul/li[2]/a"))).click();		  
		    //Clicks on Open button
	    	
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a"))).click();
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
	    	//Clicks on open report
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
	    	//Clicks on Save
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-ircam-save"))).click();
			//Clicks on Save report
		    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-ircam-dialog-title"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-ircam-dialog-confirmed"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-success")));
			Thread.sleep(1000);
	        //Clicks on Saved activities
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-ircam-savedactivities"))).click();
			Thread.sleep(2000);
	    }
	    
	    public void downloadRecord() throws Exception {
	    	
	    	WebDriverWait wait1 = new WebDriverWait(driver,60);
	    	//Clicks on first newly created record
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-mirca']/ul/li[2]/a"))).click();
			String window = driver.getWindowHandle();
			//Clicks on download button
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).click();
			try{
				  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
				  wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
				 }catch (org.openqa.selenium.TimeoutException e)
				  {
					  
				  }
			
			//Clicks on open pdf report
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
	    	Thread.sleep(2000);
	    	driver.switchTo().window(window);
	    	Thread.sleep(1000);
	    		    	
	    }
	    
	    public void shareReport() throws Exception{
	    	
	    	WebDriverWait wait1 = new WebDriverWait(driver,60);
			//Switches to the iframe
			wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
	    	//Clicks on share button
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[4]"))).click();
			//Enters username
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-uhshare-search-input"))).sendKeys("qaacfiverifier");
	    	//Selects from dropdown
			WebElement dropdown = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhshare-blocks']/div[2]/ul")));
			dropdown.findElement(By.cssSelector(".ui-first-child.ui-last-child")).click();
			//Clicks on add user
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
			//Verifies user added
			String user=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhshare-blocks']/div/form/div/ul/li/a"))).getText();
			softly.assertThat(user).as("test data").isEqualTo("qaacfiverifier");
			//Clicks on save
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-uhshare-save"))).click();
	    }
	    
	    public void markCritical() throws Exception{
	    	
	    	WebDriverWait wait1 = new WebDriverWait(driver,60);
	    	//Clicks on mark critical
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div[2]/div/label"))).click();
	    	//Clicks on confirm change
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
			//Checks if marked critical
			String critical=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div/table/thead/tr/th/strong"))).getText();
			softly.assertThat(critical).as("test data").contains("Critical");
			if(driver.findElement(By.xpath(".//*[@id='mirca-rpt']/div/table/thead/tr/th/strong")).isDisplayed())
				System.out.println("Marked critical");
			//Clicks on mark critical again
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div[2]/div/label"))).click();
	    	//Clicks on confirm change
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
			Thread.sleep(1000);
			if(driver.findElement(By.xpath(".//*[@id='mirca-rpt']/div/table/thead/tr/th/strong")).isDisplayed()==false)
			{
				System.out.println("Unmarked critical");
			}
				
	    }
	  

	  
	  @Test
	  public void SanityTest() throws Exception{
		  try{
		  Login();
		  Thread.sleep(3000);
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
		  //Clicks on EiRCA
		  driver.findElement(By.id("pii-a-menu-eirca")).click();
		  Thread.sleep(1000);
		  //Fills all mandatory fields
		  driver.findElement(By.id("pii-ircam-tab-1-title")).sendKeys("Sanity Test Chrome");
		  driver.findElement(By.id("pii-ircam-tab-1-location")).sendKeys("San Diego");
		  driver.findElement(By.id("pii-ircam-tab-1-who")).sendKeys("Sanity Test"); 
		  driver.findElement(By.id("pii-ircam-tab-1-investigators")).sendKeys("Sanity Test");
		  driver.findElement(By.id("pii-ircam-tab-1-reviewer")).sendKeys("Sanity Test");
		  driver.findElement(By.id("pii-ircam-tab-1-management-sponsor")).sendKeys("Sanity Test");
		  driver.findElement(By.id("pii-ircam-tab-1-problem-statement")).sendKeys("Sanity Test");
		  driver.findElement(By.id("pii-ircam-tab-1-failed-component")).sendKeys("Sanity Test");
		  String ev1 = driver.findElement(By.id("pii-ircam-tab-1-title")).getAttribute("value");
		  String ev2 = driver.findElement(By.id("pii-ircam-tab-1-location")).getAttribute("value");
		  String ev3 = driver.findElement(By.id("pii-ircam-tab-1-who")).getAttribute("value");
		  String ev4 = driver.findElement(By.id("pii-ircam-tab-1-investigators")).getAttribute("value");
		  String ev5 = driver.findElement(By.id("pii-ircam-tab-1-reviewer")).getAttribute("value");
		  String ev6 = driver.findElement(By.id("pii-ircam-tab-1-management-sponsor")).getAttribute("value");
		  String ev7= driver.findElement(By.id("pii-ircam-tab-1-problem-statement")).getAttribute("value");
		  String ev8= driver.findElement(By.id("pii-ircam-tab-1-failed-component")).getAttribute("value");
		  if ((ev1.equals("Sanity Test Chrome")==false))
		  {
			  driver.findElement(By.id("pii-ircam-tab-1-title")).clear();
			  driver.findElement(By.id("pii-ircam-tab-1-title")).sendKeys("Sanity Test Chrome");
		  }
		  if ((ev2.equals("San Diego")==false))
		  {
			  driver.findElement(By.id("pii-ircam-tab-1-location")).clear();
			  driver.findElement(By.id("pii-ircam-tab-1-location")).sendKeys("San Diego");
		  }
		  if ((ev3.equals("Sanity Test")==false))
		  {
			  driver.findElement(By.id("pii-ircam-tab-1-who")).clear();
			  driver.findElement(By.id("pii-ircam-tab-1-who")).sendKeys("Sanity Test");
		  }
		  if ((ev4.equals("Sanity Test")==false))
		  {
			  driver.findElement(By.id("pii-ircam-tab-1-investigators")).clear();
			  driver.findElement(By.id("pii-ircam-tab-1-investigators")).sendKeys("Sanity Test");
		  }
		  if ((ev5.equals("Sanity Test")==false))
		  {
			  driver.findElement(By.id("pii-ircam-tab-1-reviewer")).clear();
			  driver.findElement(By.id("pii-ircam-tab-1-reviewer")).sendKeys("Sanity Test");
		  }
		  if ((ev6.equals("Sanity Test")==false))
		  {
			  driver.findElement(By.id("pii-ircam-tab-1-management-sponsor")).clear();
			  driver.findElement(By.id("pii-ircam-tab-1-management-sponsor")).sendKeys("Sanity Test");
		  }
		  if ((ev7.equals("Sanity Test")==false))
		  {
			  driver.findElement(By.id("pii-ircam-tab-1-problem-statement")).clear();
			  driver.findElement(By.id("pii-ircam-tab-1-problem-statement")).sendKeys("Sanity Test");
		  }
		  if ((ev8.equals("Sanity Test")==false))
		  {
			  driver.findElement(By.id("pii-ircam-tab-1-failed-component")).clear();
			  driver.findElement(By.id("pii-ircam-tab-1-failed-component")).sendKeys("Sanity Test");
		  }
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
		  String name = creationDate + "_"+username+"_Sanity Test Chrome" ;
		  System.out.println(name);
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
		  //Opens record
		  openReport();
		  //Downloads record
		  downloadRecord();
		  //Shares report
		  shareReport();
		  //Mark critical
		  markCritical();
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
	  
		 
		  public void afterTest() throws Exception{
			 //Waits for the login button
			  WebDriverWait wait = new WebDriverWait(driver,20);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-login-button")));
			  //Browser is closed
			  driver.quit();
			  softly.assertAll();
		  }

}
