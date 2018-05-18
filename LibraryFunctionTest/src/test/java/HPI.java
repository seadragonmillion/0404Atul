import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HPI {
	
	SoftAssertions softly = new SoftAssertions();
	
	public void createReport (WebDriver driver,String username) throws Exception{
		
		  WebDriverWait wait = new WebDriverWait(driver,10);
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
		  hops(driver);
		  hopsBottomUp(driver);
		  //Click on finalize
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-btn-done"))).click();
		  Thread.sleep(2000);
		  //Click on finalize and save
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-dialog-title"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-dialog-confirmed"))).click(); 
		  //Waits for the green popup on the right top corner
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  //Waits for black loading message to disappear
		  String r3 = driver.getCurrentUrl();
		  if(r3.contains("kaleasia")==true)
		  {
			  while (true)
			  {
				  try{
					  Thread.sleep(2000);
					  if(driver.findElement(By.className("ui-icon-loading")).isDisplayed())
					  {
						  Thread.sleep(3000);
					  }
					  else
						  break;
					  }catch (org.openqa.selenium.NoSuchElementException e)
					  {
						  break;
					  }
			  }
		  }
		  else{
		  try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }}
		  //Creates expected record name
		  Thread.sleep(3000);
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
	}

	public void deleteNewRecord(WebDriver driver, String recordName, int y) throws Exception{
		  
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  //CLicks on first newly created record
		  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-hpi']/ul/li[2]/a"))).click();
		  //Clicks on delete button
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title")));
		  //Clicks on delete report
		  driver.findElement(By.id("pii-user-home-dialog-confirmed")).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  Thread.sleep(2000);
		  //Click on side panel
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
		  //Verify report not retrieved by shared to person
	      ErrorMeter obj = new ErrorMeter();
		  String sharer = obj.decideSharer (y);
		  ShareCheck obj1 = new ShareCheck();
		  obj1.checkNoReportAfterDelete(driver, sharer, softly);
		  			  
	  }


	  public void shareReport(WebDriver driver, String username, String password1, int y) throws Exception{
	    	
	    	WebDriverWait wait1 = new WebDriverWait(driver,60);
	    	ErrorMeter obj = new ErrorMeter();
		    String sharer = obj.decideSharer (y);
	    	String sharerAdded = obj.decideSharerAdded (y);	
	    	 //CLicks on first newly created record
		     wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-hpi']/ul/li[2]/a"))).click();
			//Switches to the iframe
			//wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
	    	//Clicks on share button
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).click();
			//Enters username
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-uhshare-search-input"))).sendKeys(sharer);
	    	//Selects from dropdown
			WebElement dropdown = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhshare-blocks']/div[2]/ul")));
			dropdown.findElement(By.cssSelector(".ui-first-child")).click();
			//Clicks on add user
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
			//Verifies user added
			String user=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhshare-blocks']/div/form/div/ul/li/a"))).getText();
			softly.assertThat(user).as("test data").isEqualTo(sharerAdded);
			ShareCheck obj1 = new ShareCheck();
			obj1.shareTwice (driver);
			//Clicks on save
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-uhshare-save"))).click();
			//Waits for black loading message to disappear
			  String r3 = driver.getCurrentUrl();
			  if(r3.contains("kaleasia")==true)
			  {
				  while (true)
				  {
					  try{
						  Thread.sleep(2000);
						  if(driver.findElement(By.className("ui-icon-loading")).isDisplayed())
						  {
							  Thread.sleep(3000);
						  }
						  else
							  break;
						  }catch (org.openqa.selenium.NoSuchElementException e)
						  {
							  break;
						  }
				  }
			  }
			  else{
			  try{
				  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
				  wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
				 }catch (org.openqa.selenium.TimeoutException e)
				  {
					  
				  }	}
			 //Checks the username of creator and verifier
			 WebElement creator = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='hpi-rpt']/div/span[2]/span")));
			 String creatorUsername= creator.getText();
			 System.out.println(creatorUsername);
			 softly.assertThat(username).as("test data").isEqualTo(creatorUsername);
			 WebElement sharedTo=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='hpi-rpt']/div/span[3]/span")));
			 String sharedToUsername = sharedTo.getText();
			 System.out.println(sharedToUsername);
			 softly.assertThat(sharer).as("test data").isEqualTo(sharedToUsername);
			 WebElement shared=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='hpi-rpt']/div/span[3]")));
			 String sharedText = shared.getText();
			 System.out.println(sharedText);
			 softly.assertThat("Shared to:").as("test data").isSubstringOf(sharedText);
			 //Calls the Share check function
			 obj1.receiptReport(driver, sharer, username, password1);
			 //Clicks on HPI side panel
			 wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-hpi"))).click();
			  if(r3.contains("kaleasia")==true)
			  {
				  while (true)
				  {
					  try{
						  Thread.sleep(2000);
						  if(driver.findElement(By.className("ui-icon-loading")).isDisplayed())
						  {
							  Thread.sleep(3000);
						  }
						  else
							  break;
						  }catch (org.openqa.selenium.NoSuchElementException e)
						  {
							  break;
						  }
				  }
			  }
			  else{
			 try{
				  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
				  wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
				 }catch (org.openqa.selenium.TimeoutException e)
				  {
					  
				  }}
		     //Clicks on first newly created record
		     wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-hpi']/ul/li[2]/a"))).click();
	    }

	    public void markCritical(WebDriver driver,String username, String password1,int y) throws Exception{
	    	
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
			//Verify report not retrieved by shared to person
		    ErrorMeter obj = new ErrorMeter();
			String sharer = obj.decideSharer (y);
			ShareCheck obj1 = new ShareCheck();
			obj1.checkCriticalNotification(driver, sharer, username, password1, softly);		
			//Clicks on EiRCA side panel
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-hpi"))).click();
		    String r3 = driver.getCurrentUrl();
			if(r3.contains("kaleasia")==true)
			{
			  while (true)
			  {
				  try{
					  Thread.sleep(2000);
					  if(driver.findElement(By.className("ui-icon-loading")).isDisplayed())
					  {
						  Thread.sleep(3000);
					  }
					  else
						  break;
					  }catch (org.openqa.selenium.NoSuchElementException e)
					  {
						  break;
					  }
			  }
			}
			else{
			try{
				  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
				  wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
				 }catch (org.openqa.selenium.TimeoutException e)
				  {
					  
				  }}
	    	//Clicks on first newly created record
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-hpi']/ul/li[2]/a"))).click();
	    }
		
		
		public void hops(WebDriver driver) throws Exception{
			
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

		public void hopsBottomUp(WebDriver driver) throws Exception{
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
		
		public void softAssert() throws Exception {
			softly.assertAll();
			System.gc();
		}

}
