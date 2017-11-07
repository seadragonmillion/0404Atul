import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Rule;
import org.junit.rules.Timeout;
import java.util.concurrent.TimeoutException;
import org.assertj.core.api.SoftAssertions;

public class IETest {

	private InternetExplorerDriver driver;
	private String username ="qaacfi";
	 private String password = "Kale94935830@";
	private String event_title="Sanity Test IE";
	private String ie_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\IEDriverServer.exe";
	private String url = "https://kaleasia.error-free.com/";
	private int login =0;
	SoftAssertions softly = new SoftAssertions();

	@SuppressWarnings("deprecation")
	@Rule
	  public Timeout globalTimeout= new Timeout(600000);
	  
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
		  
		JavascriptExecutor jse = (JavascriptExecutor)driver;  
		//CLicks on first newly created record
		  //driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-rv']/ul/li[2]/a")).click();
		  Thread.sleep(4000);
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  //Clicks on delete button
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title")));
		  //Clicks on delete report
		  jse.executeScript("return document.getElementById('pii-user-home-dialog-confirmed').click();");
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  Thread.sleep(4000);
		  jse.executeScript("return document.getElementById('pii-user-home-panel-btn-rv').click();");
		  //Verify record deleted
		  //Click on 1st record
		  String name = driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-rv']/ul/li[2]/a")).getText();
		  System.out.println(name);
		  if (name!=recordName)
			  System.out.println("Record deleted");
		  else
			  System.out.println("Record could not be deleted");
		  			  
	  }


	   public void downloadRecord() throws Exception {
	    	
	    	WebDriverWait wait1 = new WebDriverWait(driver,60);
	    	//Clicks on first newly created record
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-rv']/ul/li[2]/a"))).click();
			//Clicks on download button
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a"))).click();
			try{
				  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
				  wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
				 }catch (org.openqa.selenium.TimeoutException e)
				  {
					  
				  }
			
			String window = driver.getWindowHandle();
			//Clicks on open pdf report
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
	    	try {
				  Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/OpenPdf.exe");
				  q.waitFor();
				  }catch (UnhandledAlertException f){	
					  System.out.println("Unexpected alert for picture 2");
					  driver.switchTo().alert().accept();
					  
			  	  }catch (NoAlertPresentException f){
			  		  System.out.println ("No unexpected alert for picture 2");
			  		  }
	    	Thread.sleep(8000);
	    	//Close pdf
	    	Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/ClosePdf.exe");
			q.waitFor();
			Thread.sleep(4000);
			//Switch to window    	
	    	driver.switchTo().window(window);
	    	driver.switchTo().defaultContent();
	    		    	
	    }
	    
	    public void shareReport() throws Exception{
	    	
	    	WebDriverWait wait1 = new WebDriverWait(driver,60);
			//Switches to the iframe
			wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
	    	//Clicks on share button
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[3]"))).click();
			//Enters username
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-uhshare-search-input"))).sendKeys("qaacreator");
	    	//Selects from dropdown
			WebElement dropdown = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhshare-blocks']/div[2]/ul")));
			dropdown.findElement(By.cssSelector(".ui-first-child.ui-last-child")).click();
			//Clicks on add user
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
			//Verifies user added
			String user=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhshare-blocks']/div/form/div/ul/li[2]/a"))).getText();
			softly.assertThat(user).as("test data").isEqualTo("qaacreator");
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
			String critical=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='rv-rpt']/div/div/table/tbody/tr/th/strong"))).getText();
			softly.assertThat(critical).as("test data").contains("Critical");
			if(driver.findElement(By.xpath(".//*[@id='rv-rpt']/div/div/table/tbody/tr/th/strong")).isDisplayed())
				System.out.println("Marked critical");
			//Clicks on mark critical again
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div[2]/div/label"))).click();
	    	//Clicks on confirm change
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
			Thread.sleep(2000);
			if(driver.findElement(By.xpath(".//*[@id='rv-rpt']/div/div/table/tbody/tr/th/strong")).isDisplayed()==false)
			{
				System.out.println("Unmarked critical");
			}
				
	    }
	  
	  
	  @Test
	  public void SanityTest() throws Exception{
		  try{
		  Login();
		  Thread.sleep(7000);
		  System.out.println("Title after login: "+driver.getTitle());
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
		  Thread.sleep(8000);
		  System.out.println("Waiting for page to load");
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-a")));
		  //Clicks on Analysis
		  jse.executeScript("return document.getElementById('pii-main-menu-button-a').click();");
		  //Clicks on Remote Verification
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-rv")));
		  jse.executeScript("return document.getElementById('pii-a-menu-rv').click();");
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
		  WebElement option = select.findElement(By.cssSelector(".ui-li-static.ui-body-inherit.ui-first-child"));
		  option.click();
		  //Clicks twice on browse button of 2nd picture
		  WebElement element =  driver.findElement(By.id("pii-rv-imgperson-photo-input"));
		  Actions act = new Actions(driver);
		  act.doubleClick(element).build().perform();
		  Thread.sleep(6000);
		  try{
			  try {
					//Uploads picture 2
					  Process p=Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/IEChrysanthemum.exe");
					  p.waitFor();
					  		  
				  }catch (UnhandledAlertException f){		
					  System.out.println("Unexpecetd alert for picture 2");
					  driver.switchTo().alert().accept();
				  }
			  
		  }catch (NoAlertPresentException f){			  
			  System.out.println ("No unexpected alert for picture 2");
		  }
		  Thread.sleep(8000);
		  jse.executeScript("scroll(0, 250)");
		  //Clicks twice on browse button of 1st picture
		  WebElement element2 =  driver.findElement(By.id("pii-rv-imgwork-photo-input"));
		  act.doubleClick(element2).build().perform();
		  Thread.sleep(6000);
		  try{
			  try {
					  //Uploads picture 1
					  Process q=Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/IEDesert.exe");		
					  q.waitFor();
			      }catch (UnhandledAlertException g){
			    	  System.out.println("Unexpecetd alert for picture 1");
					  driver.switchTo().alert().accept();
			      }
		     }catch (NoAlertPresentException g){			  
			  System.out.println ("No unexpected alerts for picture 1");
		     }
			 
		  Thread.sleep(8000);
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
		  Thread.sleep(6000);
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
		  Thread.sleep(3000);
		  //Downloads record
		  downloadRecord();
		  //Shares report
		  shareReport();
		  //Mark critical
		  markCritical();
		 //Deletes the newly created record
		  deleteNewRecord(recordName);
		  //Logs out
		  jse.executeScript("return document.getElementById('pii-user-loginname').click();");
		  jse.executeScript("return document.getElementById('pii-signout-button').click();");
		  Thread.sleep(4000);	  
		  afterTest();
		  }catch (TimeoutException e)
			  {
				  driver.quit();
			  }
	  }

	  
	  public void afterTest() {
		   driver.quit();
		   softly.assertAll();
	  }

}
