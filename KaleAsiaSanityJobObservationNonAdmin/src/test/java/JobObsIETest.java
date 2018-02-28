import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.junit.Rule;
import org.junit.rules.Timeout;
import java.util.concurrent.TimeoutException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.assertj.core.api.SoftAssertions;
import java.util.Base64;

public class JobObsIETest {

	private InternetExplorerDriver driver;
	private String username ="qaacfi";
	 private String password = "S2FsZTk0OTM1ODMwQA==";
	private String ie_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\IEDriverServer.exe";
	private String url = "https://kaleasia.error-free.com/";
	private int login =0;
	SoftAssertions softly = new SoftAssertions();
	
	@SuppressWarnings("deprecation")
	@Rule
	  public Timeout globalTimeout= new Timeout(1000000);
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Performing sanity test on Job Observation Analysis in Internet Explorer non admin");
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
	
	public String decode(String pw){
		
		byte[] decryptedPasswordBytes = Base64.getDecoder().decode(pw);
		String decryptedPassword = new String(decryptedPasswordBytes);
		return (decryptedPassword);
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
		  driver.findElement(By.id("pii-pw")).sendKeys(decode(password));
		  //Sign in button is located and clicked
		  String user = driver.findElement(By.id("pii-un")).getAttribute("value");
		  String pw = driver.findElement(By.id("pii-pw")).getAttribute("value");
		  int c=1;
		  if (user.equals(username)==true)
		  {
			  if(pw.equals(decode(password))==true)
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
						  driver.findElement(By.id("pii-pw")).sendKeys(decode(password));
						  //Sign in button is located and clicked
						  driver.findElement(By.id("pii-signin-button")).click();
						  login =1;
						  break;
					  }
					  			  
				  }
				  else break;
			  }}
			
		  }
		  if ((user.equals(username)==false)||(pw.equals(decode(password))==false))
		    {
				  while(c>0)
				  {
					  Thread.sleep(1000);
					  driver.findElement(By.id("pii-un")).clear();
					  driver.findElement(By.id("pii-pw")).clear();
					  //Username text field is located and the username is entered
					  driver.findElement(By.id("pii-un")).sendKeys(username);
					  //Password field is located and the password is entered
					  driver.findElement(By.id("pii-pw")).sendKeys(decode(password));
					  user = driver.findElement(By.id("pii-un")).getAttribute("value");
					  pw = driver.findElement(By.id("pii-pw")).getAttribute("value");
					  if (user.equals(username)==true)
					  {
						  if(pw.equals(decode(password))==true)
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
		  
		  //Clicks on delete button
		  driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a")).click();
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title")));
		  //Clicks on delete report
		  driver.findElement(By.id("pii-user-home-dialog-confirmed")).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  Thread.sleep(2000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-joa"))).click();
		  //Verify record deleted
		  //Click on 1st record
		  String name = driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-joa']/ul/li[2]/a")).getText();
		  System.out.println(name);
		  if (name!=recordName)
			  System.out.println("Record deleted");
		  else
			  System.out.println("Record could not be deleted");
		  			  
	  }


	  public void shareReport() throws Exception{
	    	
	    	//CLicks on first newly created record
		    driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-joa']/ul/li[2]/a")).click();
		   	WebDriverWait wait1 = new WebDriverWait(driver,60);
			//Clicks on share button
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).click();
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
			String critical=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='joa-rpt']/div/div/span[3]/strong"))).getText();
			softly.assertThat(critical).as("test data").contains("Critical");
			if(driver.findElement(By.xpath(".//*[@id='joa-rpt']/div/div/span[3]/strong")).isDisplayed())
				System.out.println("Marked critical");
			//Clicks on mark critical again
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div[2]/div/label"))).click();
	    	//Clicks on confirm change
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
			Thread.sleep(2000);
			if(driver.findElement(By.xpath(".//*[@id='joa-rpt']/div/div/span[3]/strong")).isDisplayed()==false)
			{
				System.out.println("Unmarked critical");
			}
				
	    }

	
	@Test
	  public void SanityTest() throws Exception{
		  try{ 
		  Login();
		  System.out.println("Title after login: "+driver.getTitle());
		  //Waits for the page to load
	      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	      Thread.sleep(3000);
	      //Switches to the iframe
		  driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		  
		  Thread.sleep(6000);
		  WebDriverWait wait = new WebDriverWait(driver,20);
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
		  //Clicks on Job Observation Analysis
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-jo"))).click();
		  //Clicks on new
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-new"))).click();
		  //Click on new report
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-dialog-title"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-dialog-confirmed"))).click();
		  //Fills mandatory details in step1
		  driver.findElement(By.id("pii-joa-tab-1-observer")).sendKeys("Sanity Test");
		  driver.findElement(By.id("pii-joa-tab-1-location")).sendKeys("Sanity Test");
		  driver.findElement(By.id("pii-joa-tab-1-job")).sendKeys("Sanity Test");
		  String ev1 = driver.findElement(By.id("pii-joa-tab-1-observer")).getAttribute("value");
		  String ev2 = driver.findElement(By.id("pii-joa-tab-1-location")).getAttribute("value");
		  String ev3 = driver.findElement(By.id("pii-joa-tab-1-job")).getAttribute("value");
		  if ((ev1.equals("Sanity Test")==false))
		  {
			  driver.findElement(By.id("pii-joa-tab-1-observer")).clear();
			  driver.findElement(By.id("pii-joa-tab-1-observer")).sendKeys("Sanity Test");
		  }
		  if ((ev2.equals("Sanity Test")==false))
		  {
			  driver.findElement(By.id("pii-joa-tab-1-location")).clear();
			  driver.findElement(By.id("pii-joa-tab-1-location")).sendKeys("Sanity Test");
		  }
		  if ((ev3.equals("Sanity Test")==false))
		  {
			  driver.findElement(By.id("pii-joa-tab-1-job")).clear();
			  driver.findElement(By.id("pii-joa-tab-1-job")).sendKeys("Sanity Test");
		  }
		  //Clicks on next
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-joa-tab-1-form']/div[6]/div/button"))).click();
		  
		  
		  //Uploads a picture on next page in step 2
		  Thread.sleep(1000);
		  driver.findElement(By.id("pii-joa-tab-2-photo-input")).click();
		  WebElement element =  driver.findElement(By.id("pii-joa-tab-2-photo-input"));
		  Actions act = new Actions(driver);
		  act.doubleClick(element).build().perform();
		  Thread.sleep(5000);
		  //Uploads picture
		  try{
			  try {
		  Process p = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaChrysanthemumJOBOBS.exe");
		  p.waitFor();
		   }catch (UnhandledAlertException f){		
					  System.out.println("Unexpected alert for picture 2");
					  driver.switchTo().alert().accept();
				  }
			  
		  }catch (NoAlertPresentException f){			  
			  System.out.println ("No unexpected alert for picture 2");
		  }
	     
		  Thread.sleep(9000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-photo-img")));
		  //Clicks on next
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-next"))).click();
		  //Clicks on Knowledge based button in step 3
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-s3-KB"))).click();
		  //Clicks on Attention bank & span insufficiency button in step 4
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-DDOT-5"))).click();
		  //CLicks on both answers in step 5
		  Thread.sleep(1000);
		  element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-5-answer-0")));
		  act.moveToElement(element).click().build().perform();
		  Thread.sleep(1000);
		  element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-5-answer-1")));
		  act.moveToElement(element).click().build().perform();
		  //Clicks on Next
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-5-button"))).click();
		  //Clicks on both answers in step 6
		  element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-6-answer-0")));
		  act.moveToElement(element).click().build().perform();
		  Thread.sleep(1000);
		  element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-6-answer-1")));
		  act.moveToElement(element).click().build().perform();
		  //Clicks on build report
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-6-report"))).click();
		  //Clicks on build report
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-dialog-title"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-dialog-confirmed"))).click();
		  //Clicks on save
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-save"))).click();
		  //Clicks on save report
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-dialog-title"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-dialog-confirmed"))).click();
		  //Waits for the green popup on the right top corner
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  //Clicks on saved activities
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-btn-savedactivities"))).click();
		  //Clicks on side panel option for job observation
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-joa"))).click();
		  //Gets the name of the record created
		  WebElement record = driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-joa']/ul/li[2]/a"));
		  String recordName = record.getText();
		  if (record.isDisplayed())
		  {
			  System.out.println("Record found: "+ recordName);
		  }
		  else
			  System.out.println ("Record not found.");
		  
		  Thread.sleep(2000);
		  //Shares report
		  shareReport();
		  Thread.sleep(2000);
		  //Mark critical
		  markCritical();
		  Thread.sleep(2000);
		  //Deletes the record
		  deleteNewRecord(recordName);
		 while(true)
		  {
			  Thread.sleep(1000);
			  try{
			  if (driver.findElement(By.className("sticky-note")).isDisplayed())
			  {
			  	if (driver.findElement(By.className("sticky-close")).isDisplayed())
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();
				  
			  }}catch (NoSuchElementException e)
			  {
				  break;
			  }
			  catch( StaleElementReferenceException f)
			  {
				  
				 break;
			  }
			  catch (org.openqa.selenium.TimeoutException u)
			  {
				 break;
			  }
			  catch (org.openqa.selenium.ElementNotInteractableException r)
			  {
				 break;
			  }
		  }
		  
		  //Logs out
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-signout-button"))).click();
		  Thread.sleep(2000);
		  afterTest();
		  }catch(TimeoutException e)
		  {
			  System.out.println(e);
			  /*driver.findElement(By.id("pii-home")).sendKeys(Keys.CONTROL);
			  driver.findElement(By.id("pii-home")).sendKeys(Keys.F11);*/
			  
			  driver.quit();
		  }
		   
		 
		  
	}
	
	
	public void afterTest(){
		
		/*driver.findElement(By.id("pii-home")).sendKeys(Keys.CONTROL);
		driver.findElement(By.id("pii-home")).sendKeys(Keys.F11);*/
		//Browser closes
		driver.quit();
		softly.assertAll();
	}

}
