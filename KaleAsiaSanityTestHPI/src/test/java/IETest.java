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
import org.assertj.core.api.SoftAssertions;
import java.util.Iterator;
import java.util.List;

public class IETest {

	private InternetExplorerDriver driver;
	private String username ="ritica";
	private String password = "Kale46191802@";
	private String ie_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\IEDriverServer.exe";
	private String url = "https://kaleasia.error-free.com/";
	private int login =0;
	SoftAssertions softly = new SoftAssertions();
	
	@SuppressWarnings("deprecation")
	@Rule
	  public Timeout globalTimeout= new Timeout(700000);
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
		  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-hpi']/ul/li[2]/a"))).click();
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


	  public void shareReport() throws Exception{
	    	
	    	WebDriverWait wait1 = new WebDriverWait(driver,60);
	    	//CLicks on first newly created record
		    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-hpi']/ul/li[2]/a"))).click();
			//Switches to the iframe
			//wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
	    	//Clicks on share button
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).click();
			//Enters username
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-uhshare-search-input"))).sendKeys("qaacreator");
	    	//Selects from dropdown
			WebElement dropdown = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhshare-blocks']/div[2]/ul")));
			dropdown.findElement(By.cssSelector(".ui-first-child.ui-last-child")).click();
			//Clicks on add user
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
			//Verifies user added
			String user=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhshare-blocks']/div/form/div/ul/li/a"))).getText();
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
			String critical=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='hpi-rpt']/div/span[4]/strong"))).getText();
			softly.assertThat(critical).as("test data").contains("Critical");
			if(driver.findElement(By.xpath(".//*[@id='hpi-rpt']/div/span[4]/strong")).isDisplayed())
				System.out.println("Marked critical");
			//Clicks on mark critical again
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div[2]/div/label"))).click();
	    	//Clicks on confirm change
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
			Thread.sleep(2000);
			if(driver.findElement(By.xpath(".//*[@id='hpi-rpt']/div/span[4]/strong")).isDisplayed()==false)
			{
				System.out.println("Unmarked critical");
			}
				
	    }
		
		public void hops() throws Exception{
			
			WebDriverWait wait1 = new WebDriverWait(driver,60);
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			//Clicks on check boxes on of H for HOPS
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q1-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q2-l"))).click();
			try{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m1-l")));
			}catch (org.openqa.selenium.TimeoutException u)
				  {
					  System.out.println("Corrective action not visible");
				  }
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q1-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q2-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m1-l"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m1-l"))).click();
			
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q3-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q4-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q5-l"))).click();
			try{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m2-l")));
			}catch (org.openqa.selenium.TimeoutException u)
				  {
					  System.out.println("Corrective action not visible");
				  }
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q3-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q4-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q5-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m2-l"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m2-l"))).click();
			
			
			jse.executeScript("scroll(0, 1500)");
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q6-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q7-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q8-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q9-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q10-l"))).click();
			try{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m3-l")));
			}catch (org.openqa.selenium.TimeoutException u)
				  {
					  System.out.println("Corrective action not visible");
				  }
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q6-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q7-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q8-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q9-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q10-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m3-l"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m3-l"))).click();
			
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q11-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q12-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q13-l"))).click();
			try{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m4-l")));
			}catch (org.openqa.selenium.TimeoutException u)
				  {
					  System.out.println("Corrective action not visible");
				  }
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q11-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q12-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q13-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m4-l"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m4-l"))).click();
			
			
			//Click on O of HOPS
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(1000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-navbar-tab-2"))).click();
			//Click on checkboxes of O in HOPS
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q1-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q2-l"))).click();
			try{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m1-l")));
			}catch (org.openqa.selenium.TimeoutException u)
				  {
					  System.out.println("Corrective action not visible");
				  }
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q1-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q2-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m1-l"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m1-l"))).click();
			
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q3-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q4-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q5-l"))).click();
			try{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m2-l")));
			}catch (org.openqa.selenium.TimeoutException u)
				  {
					  System.out.println("Corrective action not visible");
				  }
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q3-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q4-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q5-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m2-l"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m2-l"))).click();
			
			
			jse.executeScript("scroll(0, 1500)");
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q6-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q7-l"))).click();
			try{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m3-l")));
			}catch (org.openqa.selenium.TimeoutException u)
				  {
					  System.out.println("Corrective action not visible");
				  }
		    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q6-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q7-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m3-l"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m3-l"))).click();
			
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q8-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q9-l"))).click();
			try{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m4-l")));
			}catch (org.openqa.selenium.TimeoutException u)
				  {
					  System.out.println("Corrective action not visible");
				  }
		    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q8-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q9-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m4-l"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m4-l"))).click();
			
			
			//Click on P of HOPS
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(1000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-navbar-tab-3"))).click();
			//Click on checkboxes of P in HOPS
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q1-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q2-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q3-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q4-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q5-l"))).click();
			try{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m1-l")));
			}catch (org.openqa.selenium.TimeoutException u)
				  {
					  System.out.println("Corrective action not visible");
				  }
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q1-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q2-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q3-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q4-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q5-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m1-l"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m1-l"))).click();


			jse.executeScript("scroll(0, 500)");
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q6-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q7-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q8-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q9-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q10-l"))).click();
			try{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m2-l")));
			}catch (org.openqa.selenium.TimeoutException u)
				  {
					  System.out.println("Corrective action not visible");
				  }
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q6-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q7-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q8-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q9-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q10-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m2-l"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m2-l"))).click();
			
			
			jse.executeScript("scroll(0, 1500)");
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q11-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q12-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q13-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q16-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q17-l"))).click();
			try{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m3-l")));
			}catch (org.openqa.selenium.TimeoutException u)
				  {
					  System.out.println("Corrective action not visible");
				  }
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q11-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q12-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q13-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q16-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q17-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m3-l"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m3-l"))).click();
			
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q14-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q15-l"))).click();
			try{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m4-l")));
			}catch (org.openqa.selenium.TimeoutException u)
				  {
					  System.out.println("Corrective action not visible");
				  }
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q14-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q15-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m4-l"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m4-l"))).click();
			
			
			//Click on S of HOPS
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(1000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-navbar-tab-4"))).click();
			//Click on checkboxes of S in HOPS
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q1-l"))).click();
			try{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m1-l")));
			}catch (org.openqa.selenium.TimeoutException u)
				  {
					  System.out.println("Corrective action not visible");
				  }
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q1-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m1-l"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m1-l"))).click();
			
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q3-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q4-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q5-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q6-l"))).click();
			try{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m2-l")));
			}catch (org.openqa.selenium.TimeoutException u)
				  {
					  System.out.println("Corrective action not visible");
				  }
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q3-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q4-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q5-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q6-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m2-l"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m2-l"))).click();
			
			
			jse.executeScript("scroll(0, 1500)");
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q7-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q8-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q9-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q10-l"))).click();
			try{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m3-l")));
			}catch (org.openqa.selenium.TimeoutException u)
				  {
					  System.out.println("Corrective action not visible");
				  }
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q7-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q8-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q9-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q10-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m3-l"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m3-l"))).click();
			
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q11-l"))).click();
			try{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m4-l")));
			}catch (org.openqa.selenium.TimeoutException u)
				  {
					  System.out.println("Corrective action not visible");
				  }
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q11-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m4-l"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m4-l"))).click();
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(1000);
			WebElement element_id=driver.findElement(By.id("pii-hpi-gauge"));
			List<WebElement> element =element_id.findElements(By.tagName("text"));
			Iterator<WebElement> iter = element.iterator();
			iter.next();
			String readiness=iter.next().getText();
			System.out.println("Readiness is: "+readiness);
			if (readiness.equals("0"))
				System.out.println("Shows 0%");
			else softly.fail("Doesnt show 0%");
			
		}

		public void hopsBottomUp() throws Exception{
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			//Clicks on H of HOPS
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-navbar-tab-1"))).click();
			//Clicks on bottom up on H for HOPS
			//Corrective action click
			Thread.sleep(1000);
			jse.executeScript("scroll(0, 2000)");
			Thread.sleep(1000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m4-l"))).click();
			//Click on other checkboxes
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q13-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q12-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q11-l"))).click();
			Thread.sleep(1000);
			//Checks if corrective action checkbox got unselected
			if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m4-l"))).isSelected()==false)
			{
				System.out.println("Corrective action not checked");
			}
			if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m4-l"))).isSelected()==true)
			{
				softly.fail("Failed: Corrective action checked in Adequate situation awareness?");
			}
			//Corrective action click
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m3-l"))).click();
			//Click other checkboxes 
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q10-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q9-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q8-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q7-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q6-l"))).click();
			Thread.sleep(1000);
			//Checks if corrective action checkbox got unselected
			if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m3-l"))).isSelected()==false)
			{
				System.out.println("Corrective action not checked");
			}
			if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m3-l"))).isSelected()==true)
			{
				softly.fail("Failed: Corrective action checked in Adequate resources, structure, and TQA?");
			}
			Thread.sleep(1000);
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(1000);
			//Corrective action click
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m2-l"))).click();
			//Click other checkboxes 
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q5-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q4-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q3-l"))).click();
			Thread.sleep(1000);
			//Checks if corrective action checkbox got unselected
			if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m2-l"))).isSelected()==false)
			{
				System.out.println("Corrective action not checked");
			}
			if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m2-l"))).isSelected()==true)
			{
				softly.fail("Failed: Corrective action checked in Participants ready for PJB?");
			}
			//Corrective action click
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m1-l"))).click();
			//Click other checkboxes 
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q2-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q1-l"))).click();
			Thread.sleep(1000);
			//Checks if corrective action checkbox got unselected
			if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m1-l"))).isSelected()==false)
			{
				System.out.println("Corrective action not checked");
			}
			if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m1-l"))).isSelected()==true)
			{
				softly.fail("Failed: Corrective action checked in Adequate PJB level selection?");
			}
			
			
			//Click on O of HOPS
			Thread.sleep(1000);
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(1000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-navbar-tab-2"))).click();
			//Clicks on bottom up on O for HOPS
			//Corrective action click
			Thread.sleep(1000);
			jse.executeScript("scroll(0, 2000)");
			Thread.sleep(1000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m4-l"))).click();
			//Click other checkboxes
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q9-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q8-l"))).click();
			Thread.sleep(1000);
			//Checks if corrective action checkbox got unselected
			if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m4-l"))).isSelected()==false)
			{
				System.out.println("Corrective action not checked");
			}
			if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m4-l"))).isSelected()==true)
			{
				softly.fail("Failed: Corrective action checked in Environment related operating experience addressed?");
			}
			//Corrective action click
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m3-l"))).click();
			//Click other checkboxes
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q7-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q6-l"))).click();
			Thread.sleep(1000);
			//Checks if corrective action checkbox got unselected
			if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m3-l"))).isSelected()==false)
			{
				System.out.println("Corrective action not checked");
			}
			if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m3-l"))).isSelected()==true)
			{
				softly.fail("Failed: Corrective action checked in Person related operating experience addressed?");
			}
			Thread.sleep(1000);
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(1000);
			//Corrective action click
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m2-l"))).click();
			//Click other checkboxes
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q5-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q4-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q3-l"))).click();
			Thread.sleep(1000);
			//Checks if corrective action checkbox got unselected
			if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m2-l"))).isSelected()==false)
			{
				System.out.println("Corrective action not checked");
			}
			if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m2-l"))).isSelected()==true)
			{
				softly.fail("Failed: Corrective action checked in Activity related operating experience addressed?");
			}
			//Corrective action click
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m1-l"))).click();
			//Click other checkboxes
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q2-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q1-l"))).click();
			Thread.sleep(1000);
			//Checks if corrective action checkbox got unselected
			if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m1-l"))).isSelected()==false)
			{
				System.out.println("Corrective action not checked");
			}
			if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m1-l"))).isSelected()==true)
			{
				softly.fail("Failed: Corrective action checked in Time related operating experience addressed?");
			}
			
			
			//Click on P of HOPS
			Thread.sleep(1000);
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(1000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-navbar-tab-3"))).click();
			//Clicks on bottom up on P for HOPS
			//Corrective action click
			Thread.sleep(1000);
			jse.executeScript("scroll(0, 2000)");
			Thread.sleep(1000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m4-l"))).click();
			//Click other checkboxes
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q15-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q14-l"))).click();
			Thread.sleep(1000);
			//Checks if corrective action checkbox got unselected
			if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m4-l"))).isSelected()==false)
			{
				System.out.println("Corrective action not checked");
			}
			if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m4-l"))).isSelected()==true)
			{
				softly.fail("Failed: Corrective action checked in Adequate deviation scenario management?");
			}
			//Corrective action click
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m3-l"))).click();
			//Click other checkboxes
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q17-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q16-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q13-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q12-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q11-l"))).click();
			Thread.sleep(1000);
			//Checks if corrective action checkbox got unselected
			if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m3-l"))).isSelected()==false)
			{
				System.out.println("Corrective action not checked");
			}
			if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m3-l"))).isSelected()==true)
			{
				softly.fail("Failed: Corrective action checked in Adequate single-point-vulnerability (SPV) control?");
			}
			Thread.sleep(1000);
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(1000);
			//Corrective action click
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m2-l"))).click();
			//Click other checkboxes
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q10-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q9-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q8-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q7-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q6-l"))).click();
			Thread.sleep(1000);
			//Checks if corrective action checkbox got unselected
			if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m2-l"))).isSelected()==false)
			{
				System.out.println("Corrective action not checked");
			}
			if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m2-l"))).isSelected()==true)
			{
				softly.fail("Failed: Corrective action checked in Plan complete (ROAST)?");
			}
			//Corrective action click
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m1-l"))).click();
			//Click other checkboxes
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q5-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q4-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q3-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q2-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q1-l"))).click();
			Thread.sleep(1000);
			//Checks if corrective action checkbox got unselected
			if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m1-l"))).isSelected()==false)
			{
				System.out.println("Corrective action not checked");
			}
			if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m1-l"))).isSelected()==true)
			{
				softly.fail("Failed: Corrective action checked in Tool and equipment ready?");
			}
			
			
			//Click on S of HOPS
			Thread.sleep(1000);
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(1000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-navbar-tab-4"))).click();
			//Clicks on bottom up on S for HOPS
			//Corrective action click
			Thread.sleep(1000);
			jse.executeScript("scroll(0, 2000)");
			Thread.sleep(1000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m4-l"))).click();
			//Click other checkboxes
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q11-l"))).click();
			Thread.sleep(1000);
			//Checks if corrective action checkbox got unselected
			if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m4-l"))).isSelected()==false)
			{
				System.out.println("Corrective action not checked");
			}
			if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m4-l"))).isSelected()==true)
			{
				softly.fail("Failed: Corrective action checked in Project risk");
			}
			//Corrective action click
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m3-l"))).click();
			//Click other checkboxes
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q10-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q9-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q8-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q7-l"))).click();
			Thread.sleep(1000);
			//Checks if corrective action checkbox got unselected
			if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m3-l"))).isSelected()==false)
			{
				System.out.println("Corrective action not checked");
			}
			if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m3-l"))).isSelected()==true)
			{
				softly.fail("Failed: Corrective action checked in FUSE items mitigated?");
			}
			Thread.sleep(1000);
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(1000);
			//Corrective action click
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m2-l"))).click();
			//Click other checkboxes
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q6-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q5-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q4-l"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q3-l"))).click();
			Thread.sleep(1000);
			//Checks if corrective action checkbox got unselected
			if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m2-l"))).isSelected()==false)
			{
				System.out.println("Corrective action not checked");
			}
			if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m2-l"))).isSelected()==true)
			{
				softly.fail("Failed: Corrective action checked in FUSE items identified?");
			}
			//Corrective action click
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m1-l"))).click();
			//Click other checkboxes
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q1-l"))).click();
			Thread.sleep(1000);
			//Checks if corrective action checkbox got unselected
			if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m1-l"))).isSelected()==false)
			{
				System.out.println("Corrective action not checked");
			}
			if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m1-l"))).isSelected()==true)
			{
				softly.fail("Failed: Corrective action checked in Project failure");
			}
			
			
			//Checks if the Readiness meter is 100%id("pii-hpi-gauge")/svg[1]/text[2]/tspan[1]
			//String readiness=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-hpi-gauge']/svg[1]/text[2]/tspan[1]"))).getText();
			WebElement element_id=driver.findElement(By.id("pii-hpi-gauge"));
			List<WebElement> element =element_id.findElements(By.tagName("text"));
			Iterator<WebElement> iter = element.iterator();
			iter.next();
			String readiness=iter.next().getText();
			System.out.println("Readiness is: "+readiness);
			if (readiness.equals("100"))
				System.out.println("Shows 100%");
			else softly.fail("Doesnt show 100%");
			
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
		  hops();
		  hopsBottomUp();
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
		  //Checks for 100% readiness in report
		  WebElement element_id=driver.findElement(By.id("pii-hpi-rpt-gauge"));
		  List<WebElement> element1 =element_id.findElements(By.tagName("text"));
		  Iterator<WebElement> iter = element1.iterator();
		  iter.next();
		  String readiness=iter.next().getText();
		  System.out.println("Readiness in report is: "+readiness);
			if (readiness.equals("100"))
				System.out.println("Shows in report 100%");
			else softly.fail("Doesnt show in report 100%");
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
		  //Shares report
		  shareReport();
		  Thread.sleep(2000);
		  //Mark critical
		  markCritical();
		  Thread.sleep(2000);
		  //Deletes the record
		  deleteNewRecord(recordName);
		  Thread.sleep(2000);
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
		
		/*driver.findElement(By.id("pii-home")).sendKeys(Keys.CONTROL);
		driver.findElement(By.id("pii-home")).sendKeys(Keys.F11);*/
		//Browser closes
		driver.quit();
		softly.assertAll();
	}
	
	
	

}
