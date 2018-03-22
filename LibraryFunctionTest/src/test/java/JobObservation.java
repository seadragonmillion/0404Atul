import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class JobObservation {

	SoftAssertions softly = new SoftAssertions();
	
	public void dateTimeModifyChrome (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		//Edit Date
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-date"))).click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-date"))).sendKeys(Keys.ARROW_LEFT);
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-date"))).sendKeys(Keys.ARROW_LEFT);
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-date"))).sendKeys(Keys.ARROW_LEFT);
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-date"))).sendKeys("01");
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-date"))).sendKeys("01");
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-date"))).sendKeys("2018");
		Thread.sleep(500);
		//Edit Time
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-time"))).click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-date"))).sendKeys(Keys.ARROW_LEFT);
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-date"))).sendKeys(Keys.ARROW_LEFT);
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-date"))).sendKeys(Keys.ARROW_LEFT);
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-date"))).sendKeys(Keys.ARROW_LEFT);
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-time"))).sendKeys("01");
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-time"))).sendKeys("00");
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-time"))).sendKeys("00");
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-time"))).sendKeys("AM");
		//Click outside
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-photo-div"))).click();
	}
	
	public void dateTimeModifyFirefox (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		//CLick on rotate
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-rotate"))).click();
		//Press tab to get to date
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-rotate"))).sendKeys(Keys.TAB);
		//Edit Date
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-date"))).sendKeys("01");
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-date"))).sendKeys("01");
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-date"))).sendKeys("2018");
		Thread.sleep(500);
		//Press tab to get to time
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-date"))).sendKeys(Keys.TAB);
		//Edit Time
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-time"))).sendKeys("01");
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-time"))).sendKeys("00");
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-time"))).sendKeys("00");
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-time"))).sendKeys("AM");
		//Click outside
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-photo-div"))).click();
	}
	
	
	public void dateTimeModifyIE (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		//Edit Date
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-date"))).click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-date"))).clear();
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-date"))).sendKeys("2018-01-01");
		Thread.sleep(500);
		//Edit Time
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-time"))).click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-time"))).clear();
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-time"))).sendKeys("01:01:01");
		Thread.sleep(500);
		//Click outside
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-photo-div"))).click();
	}
	
	public void imageUploadChrome(WebDriver driver) throws Exception{
				
		WebDriverWait wait = new WebDriverWait(driver,10);
		//Uploads a picture on next page in step 2
		driver.findElement(By.id("pii-joa-tab-2-photo-input")).sendKeys("C:/Users/Public/Pictures/Sample Pictures/Chrysanthemum.jpg");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-photo-img")));
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-clear"))).click();
		//Re-upload photo
		driver.findElement(By.id("pii-joa-tab-2-photo-input")).sendKeys("C:/Users/Public/Pictures/Sample Pictures/Chrysanthemum.jpg");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-photo-img")));
		//Clicks on rotate
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-rotate"))).click();
	}
	
	public void imageUploadFirefox(WebDriver driver) throws Exception{
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		//Uploads a picture on next page in step 2
		driver.findElement(By.id("pii-joa-tab-2-photo-input")).click();
		Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaChrysanthemum.exe");
		p.waitFor();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-photo-img")));
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-clear"))).click();
		//Re-upload photo
		driver.findElement(By.id("pii-joa-tab-2-photo-input")).click();
		Process q =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaChrysanthemum.exe");
		q.waitFor();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-photo-img")));
		//Clicks on rotate
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-rotate"))).click();
	}
	
	
	public void imageUploadIE(WebDriver driver) throws Exception{
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		//Uploads a picture on next page in step 2
		Thread.sleep(1000);
		driver.findElement(By.id("pii-joa-tab-2-photo-input")).click();
		WebElement element =  driver.findElement(By.id("pii-joa-tab-2-photo-input"));
		Actions act = new Actions(driver);
		act.doubleClick(element).build().perform();
		Thread.sleep(3000);
		//Uploads picture
		try{
		  try {
		Process p = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaChrysanthemumJOBOBS.exe");
		p.waitFor();
		}catch (UnhandledAlertException f){		
				  System.out.println("Unexpecetd alert for picture 2");
				  driver.switchTo().alert().accept();
			  }
		  
		 }catch (NoAlertPresentException f){			  
		  System.out.println ("No unexpected alert for picture 2");
		 }
	    Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-photo-img")));
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-clear"))).click();
		//Re-upload photo
		Thread.sleep(1000);
		driver.findElement(By.id("pii-joa-tab-2-photo-input")).click();
		act.doubleClick(element).build().perform();
		Thread.sleep(3000);
		//Uploads picture
		try{
		  try {
		Process p = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/IEDesert.exe");
		p.waitFor();
		}catch (UnhandledAlertException f){		
				  System.out.println("Unexpecetd alert for picture 2");
				  driver.switchTo().alert().accept();
			  }
		  
		 }catch (NoAlertPresentException f){			  
		  System.out.println ("No unexpected alert for picture 2");
		 }
	    Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-photo-img")));
		//Clicks on rotate
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-rotate"))).click();
	}
	
	public void imageUploadIE11(WebDriver driver) throws Exception{
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		//Uploads a picture on next page in step 2
		Thread.sleep(1000);
		WebElement element =  driver.findElement(By.id("pii-joa-tab-2-photo-input"));
		Actions act = new Actions(driver);
		act.click(element).build().perform();
		Thread.sleep(2000);
		//Uploads picture
		  try{
			  try {
		  Process p = Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/IE11MozillaChrysanthemumJOBOBS.exe");
		  p.waitFor();
		  }catch (UnhandledAlertException f){		
					  driver.switchTo().alert().accept();
				  }
			  
		  }catch (NoAlertPresentException f){			  
			  System.out.println ("No unexpected alert for picture 2");
		  }
	    Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-photo-img")));
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-clear"))).click();
		//Re-upload photo
		Thread.sleep(1000);
		act.click(element).build().perform();
		Thread.sleep(2000);
		//Uploads picture
		  try{
			  try {
		  Process p = Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/IE11MozillaChrysanthemumJOBOBS.exe");
		  p.waitFor();
		  }catch (UnhandledAlertException f){		
					  System.out.println("Unexpeceted alert for picture 2");
					  driver.switchTo().alert().accept();
				  }
			  
		  }catch (NoAlertPresentException f){			  
			  System.out.println ("No unexpected alert for picture 2");
		  }
	    Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-photo-img")));
		//Clicks on rotate
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-rotate"))).click();
	}

	
	public void deleteNewRecord(WebDriver driver, String recordName) throws Exception{
		  
		  //Clicks on delete button
		  driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a")).click();
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title")));
		  //Clicks on delete report
		  driver.findElement(By.id("pii-user-home-dialog-confirmed")).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  Thread.sleep(2000);
		  driver.findElement(By.id("pii-user-home-panel-btn-joa")).click();
		  Thread.sleep(2000);
		  //Verify record deleted
		  //Click on 1st record
		  String name = driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-joa']/ul/li[2]/a")).getText();
		  System.out.println(name);
		  if (name!=recordName)
			  System.out.println("Record deleted");
		  else
			  System.out.println("Record could not be deleted");
		  while(true)
		  {
			  Thread.sleep(1000);
			  try{
			  if (driver.findElement(By.className("sticky-note")).isDisplayed())
			  {
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
			  
			 
		  }
		  			  
	  }

	  public void shareReport(WebDriver driver,int y) throws Exception{
		  
		    ErrorMeter obj = new ErrorMeter();
		    String sharer = obj.decideSharer (y);
	    	String sharerAdded = obj.decideSharerAdded (y);	    	
	    	//CLicks on first newly created record
		    driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-joa']/ul/li[2]/a")).click();
		   	WebDriverWait wait1 = new WebDriverWait(driver,60);
			//Switches to the iframe
			//wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
	    	//Clicks on share button
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).click();
			//Enters username
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-uhshare-search-input"))).sendKeys(sharer);
	    	//Selects from dropdown
			WebElement dropdown = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhshare-blocks']/div[2]/ul")));
			dropdown.findElement(By.cssSelector(".ui-first-child.ui-last-child")).click();
			//Clicks on add user
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
			//Verifies user added
			String user=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhshare-blocks']/div/form/div/ul/li/a"))).getText();
			softly.assertThat(user).as("test data").isEqualTo(sharerAdded);
			//Clicks on save
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-uhshare-save"))).click();
	    }
	    
	    public void markCritical(WebDriver driver) throws Exception{
	    	
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
}
