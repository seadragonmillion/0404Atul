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
	String text = "I think I will buy the red car, or I will lease the blue one.";
	String text1 = "As it currently stands, this question is not a good fit for our Q&A format. We expect answers to be supported by facts.";
	
	public void path(WebDriver driver) throws Exception {
		
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  //Clicks on next
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-next"))).click();
		  //Clicks on Knowledge based button in step 3
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-s3-KB"))).click();
		  //Clicks on Attention bank & span insufficiency button in step 4
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-DDOT-5"))).click();
		  //Clicks on both answers in step 5
		  Thread.sleep(1000);
		  Actions act = new Actions(driver);
		  WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-5-answer-0")));
		  act.moveToElement(element).click().build().perform();
		  Thread.sleep(1000);
		  element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-5-answer-1")));
		  act.moveToElement(element).click().build().perform();
		  //Enters text 
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-notes-step5"))).sendKeys(text);
		  //Clicks on Next
		  driver.findElement(By.id("pii-joa-tab-5-button")).click();
		  //Clicks on both answers in step 6
		  element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-6-answer-0")));
		  act.moveToElement(element).click().build().perform();
		  Thread.sleep(1000);
		  element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-6-answer-1")));
		  act.moveToElement(element).click().build().perform();
		  //Enters text
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-notes-step6"))).sendKeys(text1);
		  //Clicks on build report
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-6-report"))).click();
		  //Clicks on build report
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-dialog-title"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-dialog-confirmed"))).click();
		  //Verifies the text entered before
		  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-jo-rpt-data']/div[6]/div[5]/span/ul/li[1]"))).getText();
		  softly.assertThat(s).as("test data").contains(text);
		  String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-jo-rpt-data']/div[6]/div[5]/span/ul/li[2]"))).getText();
		  softly.assertThat(s1).as("test data").contains(text1);
		  //Clicks on save
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-save"))).click();
		  //Clicks on save report
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-dialog-title"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-dialog-confirmed"))).click();
	}
	
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
		//Re-upload photo same photo
		driver.findElement(By.id("pii-joa-tab-2-photo-input")).sendKeys("C:/Users/Public/Pictures/Sample Pictures/Chrysanthemum.jpg");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-photo-img")));
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-clear"))).click();
		//Re-upload different photo
		driver.findElement(By.id("pii-joa-tab-2-photo-input")).sendKeys("C:/Users/Public/Pictures/Sample Pictures/Desert.jpg");		
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
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-clear"))).click();
		//Re-upload different photo
		driver.findElement(By.id("pii-joa-tab-2-photo-input")).click();
		Process w =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaDesert.exe");
		w.waitFor();
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
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-clear"))).click();
		//Re-upload photo
		Thread.sleep(1000);
		act.click(element).build().perform();
		Thread.sleep(2000);
		//Uploads a different picture
		  try{
			  try {
		  Process p = Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/IEDesert.exe");
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
	
	public void verifyTextReport(WebDriver driver) throws Exception {
		
		  WebDriverWait wait = new WebDriverWait(driver,20);
		  //Verifies the text entered before
		  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-jo-rpt-data']/div[6]/div[5]/span/ul/li[1]"))).getText();
		  softly.assertThat(s).as("test data").contains(text);
		  String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-jo-rpt-data']/div[6]/div[5]/span/ul/li[2]"))).getText();
		  softly.assertThat(s1).as("test data").contains(text1);
	}

	  public void shareReport(WebDriver driver,String username, String password1,int y ) throws Exception{
		  
		    ErrorMeter obj = new ErrorMeter();
		    String sharer = obj.decideSharer (y);
	    	String sharerAdded = obj.decideSharerAdded (y);	    	
	    	//CLicks on first newly created record
		    driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-joa']/ul/li[2]/a")).click();
		   	WebDriverWait wait1 = new WebDriverWait(driver,60);
			//Calls verifyTextReport to check text entered
		   	verifyTextReport(driver);
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
			//Clicks on save
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-uhshare-save"))).click();
			//Calls the Share check function
			ShareCheck obj1 = new ShareCheck();
			obj1.receiptReport(driver, sharer, username, password1);
			//Clicks on Job Observation side panel
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-joa"))).click();
			try{
				  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
				  wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
				 }catch (org.openqa.selenium.TimeoutException e)
				  {
					  
				  }
			 //Clicks on first newly created record
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-joa']/ul/li[2]/a"))).click();;
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
	    
	    public void softAssert() throws Exception {
			softly.assertAll();
		}
}
