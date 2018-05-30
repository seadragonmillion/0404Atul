import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;


public class OPiRCA {
	
	SoftAssertions softly = new SoftAssertions();
	String event_title = "Sanity Test";

	public void deleteNewRecord(WebDriver driver,String recordName, int y) throws Exception{
		  		
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  //CLicks on first newly created record
		  //driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-opa']/ul/li[2]/a")).click();
		  //Clicks on delete button
		  driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[3]")).click();
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title")));
		  //Clicks on delete report
		  jse.executeScript("return document.getElementById('pii-user-home-dialog-confirmed').click();");
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  Thread.sleep(2000);
		  jse.executeScript("return document.getElementById('pii-user-home-panel-btn-opa').click();");
		  //Verify record deleted
		  //Click on 1st record
		  String name = driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-opa']/ul/li[2]/a")).getText();
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


	  public void openReport(WebDriver driver) throws Exception{

		  WebDriverWait wait1 = new WebDriverWait(driver,30);
			//Wait for loading message to disappear
		  ShareCheck obj = new ShareCheck();
			obj.loadingServer(driver);
		//Clicks on first newly created record
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-opa']/ul/li[2]/a"))).click();	
			//Wait for loading message to disappear
			obj.loadingServer(driver);
		    //Clicks on Open button	    	
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a"))).click();
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
	    	//Clicks on open report
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
	    	//Clicks on Save
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-opa-button-save"))).click();
			//Clicks on Save report
		    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-opa-dialog-title"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-opa-dialog-confirmed"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-success")));
			Thread.sleep(1000);
	        //Clicks on Saved activities
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-opa-btn-savedactivities"))).click();
			Thread.sleep(2000);
	    }
	  
	  public void downloadRecordChrome(WebDriver driver) throws Exception {
	    	
	    	WebDriverWait wait1 = new WebDriverWait(driver,60);
	    	//Clicks on first newly created record
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-opa']/ul/li[2]/a"))).click();
			String window = driver.getWindowHandle();
			//Clicks on download button
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).click();
			//Wait for loading message to disappear
			ShareCheck obj = new ShareCheck();
			obj.loadingServer(driver);
			//Clicks on open pdf report
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
	    	Thread.sleep(2000);
	    	driver.switchTo().window(window);
	    	Thread.sleep(1000);
	    		    	
	    }
	  
	  public void downloadRecordFirefox(WebDriver driver) throws Exception {
	    	
	    	WebDriverWait wait1 = new WebDriverWait(driver,60);
	    	//Clicks on first newly created record
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-opa']/ul/li[2]/a"))).click();
			//Clicks on download button
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).click();
			//Wait for loading message to disappear
			ShareCheck obj = new ShareCheck();
			obj.loadingServer(driver);
			String window = driver.getWindowHandle();
			//Clicks on open pdf report
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
	    	Thread.sleep(6000);
	    	driver.switchTo().window(window);
	    	for(String winHandle : driver.getWindowHandles()){
	    	    driver.switchTo().window(winHandle);
	    	}
	    	
	    	driver.close();
	    	Thread.sleep(6000);
	    	driver.switchTo().window(window);
	    	driver.switchTo().defaultContent();
	    		    	
	    }
	    
	    public void downloadRecordIE10(WebDriver driver) throws Exception {
	    	
	    	WebDriverWait wait1 = new WebDriverWait(driver,60);
	    	//Clicks on first newly created record
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-opa']/ul/li[2]/a"))).click();
			//Clicks on download button
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).click();
			//Wait for loading message to disappear
			ShareCheck obj = new ShareCheck();
			obj.loadingServer(driver);
			String window = driver.getWindowHandle();
			//Clicks on open pdf report
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
	    	Thread.sleep(4000);
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
	    
	    public void downloadRecordIE11(WebDriver driver) throws Exception {
	    	
	    	WebDriverWait wait1 = new WebDriverWait(driver,60);
	    	//Clicks on first newly created record
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-opa']/ul/li[2]/a"))).click();
			//Clicks on download button
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).click();
			//Wait for loading message to disappear
			ShareCheck obj = new ShareCheck();
			obj.loadingServer(driver);
			//String window = driver.getWindowHandle();
			//Clicks on open pdf report
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
	    	try {
				  Process q = Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/OpenPdf.exe");
				  q.waitFor();
				  }catch (UnhandledAlertException f){	
					  System.out.println("Unexpected alert for picture 2");
					  driver.switchTo().alert().accept();
					  
			  	  }catch (NoAlertPresentException f){
			  		  System.out.println ("No unexpected alert for picture 2");
			  		  }
			System.out.println("Opened pdf");
	    	Thread.sleep(4000);
	    	//Close pdf
	    	Process q = Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/ClosePdf.exe");
			q.waitFor();
			Thread.sleep(8000);
			System.out.println("Closed pdf");
			//Switch to window  
			for(String winHandle : driver.getWindowHandles()){
	    	    driver.switchTo().window(winHandle);
	    	}
			Thread.sleep(2000);
	    	driver.switchTo().defaultContent();
			System.out.println("Switched to window");
	    		    	
	    }
	    
	    public void shareReport(WebDriver driver,String username, String password1,int y ) throws Exception{
	    	
	    	WebDriverWait wait1 = new WebDriverWait(driver,60);
	    	ErrorMeter obj = new ErrorMeter();
		    String sharer = obj.decideSharer (y);
	    	String sharerAdded = obj.decideSharerAdded (y);	 
			//Switches to the iframe
			wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
	    	//Clicks on share button
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[4]"))).click();
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
			//Wait for loading message to disappear
			obj1.loadingServer(driver);
			 //Checks the username of creator
			 WebElement creator = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='opa-rpt']/div/table/tbody/tr[6]/td[2]")));
			 String creatorUsername= creator.getText();
			 System.out.println(creatorUsername);
			 softly.assertThat(creatorUsername).as("test data").isEqualTo(username);
			//Calls the Share check function
			obj1.receiptReport(driver, sharer, username, password1);
			//Clicks on OPiRCA side panel
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-opa"))).click();
			//Wait for loading message to disappear
			obj1.loadingServer(driver);
		    //Clicks on first newly created record
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-opa']/ul/li[2]/a"))).click();
	    }
	    
	    public void markCritical(WebDriver driver,String username, String password1,int y) throws Exception{
	    	
	    	WebDriverWait wait1 = new WebDriverWait(driver,60);
	    	//Clicks on mark critical
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div[2]/div/label"))).click();
	    	//Clicks on confirm change
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
			//Checks if marked critical
			String critical=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='opa-rpt']/div/table/thead/tr/th/strong"))).getText();
			softly.assertThat(critical).as("test data").contains("Critical");
			if(driver.findElement(By.xpath(".//*[@id='opa-rpt']/div/table/thead/tr/th/strong")).isDisplayed())
				System.out.println("Marked critical");
			//Clicks on mark critical again
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div[2]/div/label"))).click();
	    	//Clicks on confirm change
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
			Thread.sleep(2000);
			if(driver.findElement(By.xpath(".//*[@id='opa-rpt']/div/table/thead/tr/th/strong")).isDisplayed()==false)
			{
				System.out.println("Unmarked critical");
			}
			//Verify report not retrieved by shared to person
		    ErrorMeter obj = new ErrorMeter();
			String sharer = obj.decideSharer (y);
			ShareCheck obj1 = new ShareCheck();
			obj1.checkCriticalNotification(driver, sharer, username, password1, softly);		
			//Clicks on EiRCA side panel
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-opa"))).click();
			//Wait for loading message to disappear
			obj1.loadingServer(driver);
	    	//Clicks on first newly created record
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-opa']/ul/li[2]/a"))).click();
				
	    }
	    
	    public void reportCreate(WebDriver driver, String username) throws Exception {
	    	
	    	  JavascriptExecutor jse = (JavascriptExecutor)driver;
	    	  //Clicks on O&P IRCA
			  jse.executeScript("return document.getElementById('pii-a-menu-opirca').click();");
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
			  jse.executeScript("return document.getElementById('efi-opa-button-save').click();");
			  //Clicks on save report
			  WebDriverWait wait1 = new WebDriverWait(driver,20);
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-opa-dialog-title")));
			  jse.executeScript("return document.getElementById('pii-opa-dialog-confirmed').click();");
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
			  
			  //Creates the expected name of record
			  String creationDate = driver.findElement(By.id("pii-opa-event-repdatetime")).getAttribute("value");
			  String name = creationDate +"_"+ username + "_" + event_title;
			  System.out.println("Expected name of record: " + name);
			  
			  //Click on saved activities
			  jse.executeScript("return document.getElementById('efi-opa-btn-savedactivities').click();");
			  Thread.sleep(3000);
			  //Clicks on O&P IRCA side panel
			  jse.executeScript("return document.getElementById('pii-user-home-panel-btn-opa').click();");
			  WebElement record = driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-opa']/ul/li[2]/a"));
			  String recordName = record.getText();
			  if (record.isDisplayed())
			  {
				  System.out.println("Record found: "+ recordName);
			  }
			  else
				  System.out.println ("Record not found.");
			  assertEquals(name, recordName);
	    }
	    
	    public void softAssert() throws Exception {
			softly.assertAll();
			System.gc();
		}

}
