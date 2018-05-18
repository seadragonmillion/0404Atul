import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class EiRCA {
	
	SoftAssertions softly = new SoftAssertions();	

	public void deleteNewRecord(WebDriver driver,String recordName, int y) throws Exception{
		  
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  //CLicks on first newly created record
		  //driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-mirca']/ul/li[2]/a")).click();
		  //Clicks on delete button
		  driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[3]")).click();
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title")));
		  //Clicks on delete report
		  jse.executeScript("return document.getElementById('pii-user-home-dialog-confirmed').click();");
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  Thread.sleep(2000);
		  jse.executeScript("return document.getElementById('pii-user-home-panel-btn-mirca').click();");
		  //Verify record deleted
		  //Click on 1st record
		  String name = driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-mirca']/ul/li[2]/a")).getText();
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
	   
	   public void downloadRecordChrome(WebDriver driver) throws Exception {
	    	
	    	WebDriverWait wait1 = new WebDriverWait(driver,60);
	    	//Clicks on first newly created record
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-mirca']/ul/li[2]/a"))).click();
			String window = driver.getWindowHandle();
			//Clicks on download button
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).click();
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
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-mirca']/ul/li[2]/a"))).click();
			//Clicks on download button
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).click();
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
					  
				  }
			  }
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
	    	Thread.sleep(2000);
	    	driver.switchTo().defaultContent();
	    		    	
	    }
	   
	    public void downloadRecordIE10(WebDriver driver) throws Exception {
	    	
	    	WebDriverWait wait1 = new WebDriverWait(driver,60);
	    	//Clicks on first newly created record
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-mirca']/ul/li[2]/a"))).click();
			//Clicks on download button
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).click();
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
					  
				  }
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
	    	Thread.sleep(10000);
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
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-mirca']/ul/li[2]/a"))).click();
			//Clicks on download button
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).click();
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
	    	
	    	WebDriverWait wait1 = new WebDriverWait(driver,30);
	    	ErrorMeter obj = new ErrorMeter();
		    String sharer = obj.decideSharer (y);
	    	String sharerAdded = obj.decideSharerAdded (y);	
	    	//Waits for the page to load
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			//Switches to the iframe
			wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
	    	//Clicks on share button
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[4]"))).click();
			//Enters username
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-uhshare-search-input"))).sendKeys(sharer);
			Thread.sleep(2000);
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
			//Calls the Share check function
			obj1.receiptReport(driver, sharer, username, password1);
			//Clicks on EiRCA side panel
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-mirca"))).click();
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
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-mirca']/ul/li[2]/a"))).click();
	    }
	    
	    public void markCritical(WebDriver driver,String username, String password1,int y) throws Exception{
	    	
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
			Thread.sleep(2000);
			if(driver.findElement(By.xpath(".//*[@id='mirca-rpt']/div/table/thead/tr/th/strong")).isDisplayed()==false)
			{
				System.out.println("Unmarked critical");
			}
			//Verify report not retrieved by shared to person
		    ErrorMeter obj = new ErrorMeter();
			String sharer = obj.decideSharer (y);
			ShareCheck obj1 = new ShareCheck();
			obj1.checkCriticalNotification(driver, sharer, username, password1, softly);		
			//Clicks on EiRCA side panel
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-mirca"))).click();
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
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-mirca']/ul/li[2]/a"))).click();
	    }
	    
	    public void reportCreate(WebDriver driver,String username) throws Exception {
	    	
	    	  JavascriptExecutor jse = (JavascriptExecutor)driver;
	    	  //Clicks on EiRCA
			  jse.executeScript("return document.getElementById('pii-a-menu-eirca').click();");
			  Thread.sleep(1000);
			  //Fills all mandatory fields
			  driver.findElement(By.id("pii-ircam-tab-1-title")).sendKeys("Sanity Test");
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
			  if ((ev1.equals("Sanity Test")==false))
			  {
				  driver.findElement(By.id("pii-ircam-tab-1-title")).clear();
				  driver.findElement(By.id("pii-ircam-tab-1-title")).sendKeys("Sanity Test");
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
			  //Clicks on Save button
			  jse.executeScript("return document.getElementById('pii-ircam-save').click();");
			  //Clicks on Save Report button
			  WebDriverWait wait1 = new WebDriverWait(driver,10);
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-ircam-dialog-title"))).click();
			  jse.executeScript("return document.getElementById('pii-ircam-dialog-confirmed').click();");
			  //Waits for the green popup on the right top corner
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
			  //Gets the value from the text field report creation date
			  String creationDate = driver.findElement(By.id("pii-ircam-tab-1-repdatetime")).getAttribute("value");
			  String name = creationDate + "_"+username+"_Sanity Test" ;
			  System.out.println(name);
			  //Clicks on Saved activities button
			  jse.executeScript("return document.getElementById('pii-ircam-savedactivities').click();");
			  Thread.sleep(2000);
			  //Clicks on panel on the left on EiRCA
			  jse.executeScript("return document.getElementById('pii-user-home-panel-btn-mirca').click();");
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
	    }
	    
	    public void softAssert() throws Exception {
			softly.assertAll();
			System.gc();
		}

}
