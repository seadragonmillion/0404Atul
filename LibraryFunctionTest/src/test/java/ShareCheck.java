import java.io.File;
import java.util.concurrent.TimeUnit;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ShareCheck {
	
	private String password = "S2FsZWplbmtpbnNAMTIz";
	
	public void shareTwice (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		Thread.sleep(2000);
		//Enters sharer username
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-uhshare-search-input"))).sendKeys("jenkins_1_nonadmin");
		Thread.sleep(2000);
    	//Selects from dropdown
		WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhshare-blocks']/div[2]/ul")));
		dropdown.findElement(By.cssSelector(".ui-first-child")).click();
		//Clicks on add user
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		Thread.sleep(2000);
		//Click on new shared row
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("QAA (jenkins_1_nonadmin)"))).click();
		//Click on remove sharing
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
	}
	
	public void checkNoReportAfterDelete (WebDriver driver, String sharer, SoftAssertions softly) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//LogOut
		Login obj = new Login();
		obj.logout(driver);
		Thread.sleep(2000);
		//If browser is firefox then switch to default content
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		if(browserName.equals("firefox"))
		{
		  	driver.switchTo().defaultContent();
		}
		Thread.sleep(8000);
		int login = obj.LoginUser(driver, sharer, password);
		System.out.println("Title after login: "+driver.getTitle());
		Thread.sleep(10000);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Switches to the iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		Thread.sleep(8000);
		if (login==1)
		{
          
          while(true)
		  {
         	 Thread.sleep(1000);
			  if (driver.findElement(By.cssSelector(".sticky.border-top-right.sticky-error")).isDisplayed())
			  {
				  WebElement ele =driver.findElement(By.cssSelector(".sticky.border-top-right.sticky-error"));
				  ele.findElement(By.className("sticky-close")).click();
				  break;
			  }
			  else break;
		  }
        }	
		Thread.sleep(4000);
		//Click on notification
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-notification-button"))).click();
		Thread.sleep(2000);
		jse.executeScript("scroll(0,0)");
		Thread.sleep(2000);
		//Click on 1st record/notification
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-notif-jqgrid']/tbody/tr[2]"))).click();
		//Click on Open Report button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-notif-report-btn"))).click();
		//Wait for black server load message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			  }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }		
		//Check in sticky pop up that the report is deleted
		try{
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note"))).getText();
			softly.assertThat(s).as("test data").contains("Data not found ");
			softly.assertThat(s).as("test data").contains("It could have been deleted.");
		}catch (org.openqa.selenium.TimeoutException e)
		  {
			System.out.println("Report deleted and yellow pop up suggesting same has disappeared");  
		  }	
		//Check if open report button is still present on page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-notif-report-btn")));
	}
	
	public void checkCriticalNotification (WebDriver driver, String sharer, String username, String password1, SoftAssertions softly) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//LogOut
		Login obj = new Login();
		obj.logout(driver);
		Thread.sleep(2000);
		//If browser is firefox then switch to default content
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		if(browserName.equals("firefox"))
		{
		  	driver.switchTo().defaultContent();
		}
		Thread.sleep(8000);
		int login = obj.LoginUser(driver, sharer, password);
		System.out.println("Title after login: "+driver.getTitle());
		Thread.sleep(10000);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Switches to the iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		Thread.sleep(8000);
		if (login==1)
		{
          
          while(true)
		  {
         	 Thread.sleep(1000);
			  if (driver.findElement(By.cssSelector(".sticky.border-top-right.sticky-error")).isDisplayed())
			  {
				  WebElement ele =driver.findElement(By.cssSelector(".sticky.border-top-right.sticky-error"));
				  ele.findElement(By.className("sticky-close")).click();
				  break;
			  }
			  else break;
		  }
        }	
		Thread.sleep(4000);
		//Get count from notification
		String count = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-notification-count"))).getText();
		System.out.println("Number of notifications: "+count);
		int n = Integer.parseInt(count);
		Thread.sleep(2000);
		//Click on notification
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-notification-button"))).click();
		Thread.sleep(2000);
		jse.executeScript("scroll(0,0)");
		Thread.sleep(2000);
		//Click on 1st record/notification
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-notif-jqgrid']/tbody/tr[2]"))).click();
		//Verify if notification is of marked critical
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-notif-jqgrid']/tbody/tr[2]/td[6]"))).getText();
		softly.assertThat(s).as("test data").contains("Critical");
		Thread.sleep(2000);
		if(browserName.equals("internet explorer"))
		{
			Actions act = new Actions (driver);
			Thread.sleep(2000);
			for(int i=1;i<=n;i++)
			{
			Thread.sleep(2000);
			//Click on 1st record/notification
			WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-notif-jqgrid']/tbody/tr[2]")));
			act.click(ele).build().perform();
			Thread.sleep(4000);
			//Click on read
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-notif-ack-btn")));
			act.click(ele).build().perform();
			Thread.sleep(2000);
			//Click on mark as read
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-notifcenter-dialog-confirmed")));
			act.click(ele).build().perform();
			Thread.sleep(2000);
			}
		}
		else{
			Thread.sleep(2000);
			for(int i=1;i<=n;i++)
			{
			Thread.sleep(2000);
			//Click on 1st record/notification
			WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-notif-jqgrid']/tbody/tr[2]")));
			if(ele.isSelected()==false)
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-notif-jqgrid']/tbody/tr[2]"))).click();
			Thread.sleep(2000);
			//Click on read
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-notif-ack-btn")));
			if(ele.isEnabled()==false)
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-notif-jqgrid']/tbody/tr[2]"))).click();
			ele.click();
			Thread.sleep(2000);
			//Click on mark as read
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-notifcenter-dialog-confirmed")));
			ele.click();
			}
		}		
		//Wait for black server load message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			  }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//LogOut
		obj.logout(driver);
		if(browserName.equals("firefox"))
		{
		  	driver.switchTo().defaultContent();
		}
		Thread.sleep(6000);
		int login1 = obj.LoginUser(driver, username, password1);
		System.out.println("Title after login: "+driver.getTitle());
		Thread.sleep(5000);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Switches to the iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		Thread.sleep(8000);
		if (login1==1)
		{
          
          while(true)
		  {
         	 Thread.sleep(1000);
			  if (driver.findElement(By.cssSelector(".sticky.border-top-right.sticky-error")).isDisplayed())
			  {
				  WebElement ele =driver.findElement(By.cssSelector(".sticky.border-top-right.sticky-error"));
				  ele.findElement(By.className("sticky-close")).click();
				  break;
			  }
			  else break;
		  }
        }	
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		if(browserName.equals("firefox"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-activity"))).click();
			Thread.sleep(4000);
		}
		else
		{
		//Clicks on admin user name on top right corner
		WebElement ele =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname")));
		act.click(ele).build().perform();
		Thread.sleep(3000);
		//Clicks on Activity
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-activity")));
		WebElement ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-activity")));
		act.click(ele1).build().perform();
		Thread.sleep(4000);
		}
	}

	public void receiptReport(WebDriver driver, String sharer, String username, String password1) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//LogOut
		Login obj = new Login();
		obj.logout(driver);
		Thread.sleep(2000);
		//If browser is firefox then switch to default content
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		if(browserName.equals("firefox"))
		{
		  	driver.switchTo().defaultContent();
		}
		Thread.sleep(8000);
		int login = obj.LoginUser(driver, sharer, password);
		System.out.println("Title after login: "+driver.getTitle());
		Thread.sleep(10000);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Switches to the iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		Thread.sleep(8000);
		if (login==1)
		{
          
          while(true)
		  {
         	 Thread.sleep(1000);
			  if (driver.findElement(By.cssSelector(".sticky.border-top-right.sticky-error")).isDisplayed())
			  {
				  WebElement ele =driver.findElement(By.cssSelector(".sticky.border-top-right.sticky-error"));
				  ele.findElement(By.className("sticky-close")).click();
				  break;
			  }
			  else break;
		  }
        }	
		Thread.sleep(4000);
		//Get count from notification
		String count = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-notification-count"))).getText();
		System.out.println("Number of notifications: "+count);
		int n= Integer.parseInt(count);
		Thread.sleep(2000);
		//Click on notification
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-notification-button"))).click();
		Thread.sleep(1000);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		if(browserName.equals("firefox")==false)
		{
		  	Thread.sleep(4000);
		  	jse.executeScript("scroll(0,0)");
		  	Thread.sleep(2000);
		}
		//Click on 1st record/notification
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-notif-jqgrid']/tbody/tr[2]"))).click();
		//Click on Open Report button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-notif-report-btn"))).click();
		//Wait for black server load message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			  }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }		
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-title"))).getText();
		if(s.contains("iRCA")||s.contains("SPV Error Meter")||s.contains("Remote Verification"))
		{
		//Click on Download report
		//Get version
		String v = cap.getVersion().toString();
	    System.out.println(v);
	    //Download report to check pdf
	    if (browserName.equals("chrome"))
	    	downloadReportChrome(driver);
	    if (browserName.equals("firefox"))
	    	downloadReportFirefox(driver);
	    if (browserName.equals("internet explorer"))
	    {
	    	if (v.startsWith("10"))
	    		downloadReportIE(driver);
	    	if (v.startsWith("11"))
	    		downloadReportIE11(driver);
	    }}
		Thread.sleep(2000);
		Thread.sleep(2000);
		if(browserName.equals("internet explorer"))
		{
			Actions act = new Actions (driver);
			//Go back to notifications
			WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-notification-button")));
			act.click(ele).build().perform();
			Thread.sleep(2000);
			for(int i=1;i<=n;i++)
			{
			Thread.sleep(2000);
			//Click on 1st record/notification
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-notif-jqgrid']/tbody/tr[2]")));
			act.click(ele).build().perform();
			Thread.sleep(4000);
			//Click on read
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-notif-ack-btn")));
			act.click(ele).build().perform();
			Thread.sleep(2000);
			//Click on mark as read
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-notifcenter-dialog-confirmed")));
			act.click(ele).build().perform();
			Thread.sleep(2000);
			}
		}
		else{
			//Go back to notifications
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-notification-button"))).click();
			Thread.sleep(2000);
			for(int i=1;i<=n;i++)
			{
			Thread.sleep(2000);
			//Click on 1st record/notification
			WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-notif-jqgrid']/tbody/tr[2]")));
			if(ele.isSelected()==false)
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-notif-jqgrid']/tbody/tr[2]"))).click();
			Thread.sleep(4000);
			//Click on read
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-notif-ack-btn")));
			if(ele.isEnabled()==false)
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-notif-jqgrid']/tbody/tr[2]"))).click();
			ele.click();
			Thread.sleep(2000);
			//Click on mark as read
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-notifcenter-dialog-confirmed")));
			ele.click();
			Thread.sleep(2000);
			}
		}		
		//Wait for black server load message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			  }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//LogOut
		obj.logout(driver);
		if(browserName.equals("firefox"))
		{
		  	driver.switchTo().defaultContent();
		}
		Thread.sleep(6000);
		int login1 = obj.LoginUser(driver, username, password1);
		System.out.println("Title after login: "+driver.getTitle());
		Thread.sleep(5000);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Switches to the iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		Thread.sleep(8000);
		if (login1==1)
		{
          
          while(true)
		  {
         	 Thread.sleep(1000);
			  if (driver.findElement(By.cssSelector(".sticky.border-top-right.sticky-error")).isDisplayed())
			  {
				  WebElement ele =driver.findElement(By.cssSelector(".sticky.border-top-right.sticky-error"));
				  ele.findElement(By.className("sticky-close")).click();
				  break;
			  }
			  else break;
		  }
        }	
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		if(browserName.equals("firefox"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-activity"))).click();
			Thread.sleep(4000);
		}
		else
		{
		//Clicks on admin user name on top right corner
		WebElement ele =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname")));
		act.click(ele).build().perform();
		Thread.sleep(3000);
		//Clicks on Activity
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-activity")));
		WebElement ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-activity")));
		act.click(ele1).build().perform();
		Thread.sleep(4000);
		}
	}
	
	public void downloadReportChrome (WebDriver driver) throws Exception {
		
		//deletes files in reports folder before starting to download
    	File file = new File("C://Users//IEUser//Downloads//reports//");
    	HiRCAEvent obj1 = new HiRCAEvent();
    	obj1.deleteFiles(file);
    	WebDriverWait wait1 = new WebDriverWait(driver,60);
    	String window = driver.getWindowHandle();
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a"))).click();
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
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
    	Thread.sleep(8000);
    	for(String winHandle : driver.getWindowHandles()){
	    driver.switchTo().window(winHandle);
	    }
        driver.close();
        Thread.sleep(2000);
    	driver.switchTo().window(window);
    	Thread.sleep(5000);
    	//Switches to the iframe
        wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
	}
	
	public void downloadReportFirefox(WebDriver driver) throws Exception {
		
		//deletes files in reports folder before starting to download
    	File file = new File("C://Users//IEUser//Downloads//reports//");
    	HiRCAEvent obj1 = new HiRCAEvent();
    	obj1.deleteFiles(file);
    	WebDriverWait wait1 = new WebDriverWait(driver,60);
    	//Clicks on download button		
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a"))).click();
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
    	Thread.sleep(8000);
    	for(String winHandle : driver.getWindowHandles()){
    	    driver.switchTo().window(winHandle);
    	}
    	Thread.sleep(4000);
    	driver.close();
    	Thread.sleep(4000);
    	driver.switchTo().window(window);
    	driver.switchTo().defaultContent();    
    	Thread.sleep(4000);
    	//Switches to the iframe
		wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
    }
	
	public void downloadReportIE(WebDriver driver) throws Exception {
		
		//deletes files in reports folder before starting to download
    	File file = new File("C://Users//IEUser//Downloads//reports//");
    	HiRCAEvent obj1 = new HiRCAEvent();
    	obj1.deleteFiles(file);
    	WebDriverWait wait1 = new WebDriverWait(driver,60);
    	//Clicks on download button		
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a"))).click();
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
    	Thread.sleep(8000);
    	try {
			  Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/OpenPdf.exe");
			  q.waitFor();
			  }catch (UnhandledAlertException f){	
				  System.out.println("Unexpected alert");
				  driver.switchTo().alert().accept();
				  
		  	  }catch (NoAlertPresentException f){
		  		  System.out.println ("No unexpected alert");
		  		  }
    	Thread.sleep(10000);
    	//Close pdf
    	Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/ClosePdf.exe");
		q.waitFor();
		Thread.sleep(4000);
		//Switch to window    	
    	driver.switchTo().window(window);
    	driver.switchTo().defaultContent();
    	Thread.sleep(4000);
    	//Switches to the iframe
		wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
	}

	public void downloadReportIE11(WebDriver driver) throws Exception {
		
		//deletes files in reports folder before starting to download
    	File file = new File("C://Users//IEUser//Downloads//reports//");
    	HiRCAEvent obj1 = new HiRCAEvent();
    	obj1.deleteFiles(file);
    	WebDriverWait wait1 = new WebDriverWait(driver,60);
    	//Clicks on download button		
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a"))).click();
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
    	Thread.sleep(8000);
    	try {
			  Process q = Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/OpenPdf.exe");
			  q.waitFor();
			  }catch (UnhandledAlertException f){	
				  System.out.println("Unexpected alert");
				  driver.switchTo().alert().accept();
				  
		  	  }catch (NoAlertPresentException f){
		  		  System.out.println ("No unexpected alert");
		  		  }
    	Thread.sleep(10000);
    	//Close pdf
    	Process q = Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/ClosePdf.exe");
		q.waitFor();
		Thread.sleep(4000);
		//Switch to window    	
    	driver.switchTo().window(window);
    	driver.switchTo().defaultContent();
    	Thread.sleep(4000);
    	//Switches to the iframe
		wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
	}
}
