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
	
	By ShareTextBox = By.id("pii-uhshare-search-input");
	By ShareDropdown = By.xpath(".//*[@id='pii-uhshare-blocks']/div[2]/ul");
	By FirstSelectionUnderDropdown = By.cssSelector(".ui-first-child");
	By ConfirmPopupTitle = By.id("pii-user-home-dialog-title");
	By ConfirmPopupButton = By.id("pii-user-home-dialog-confirmed");
	By LoadingMessage = By.className("ui-icon-loading");
	By IFrame = By.xpath("//iframe[@name='pii-iframe-main']");
	By StickyPopUp = By.cssSelector(".sticky.border-top-right.sticky-error");
	By StickyNote = By.className("sticky-note");
	By StickyClose = By.className("sticky-close");
	By NotificationBell = By.id("pii-notification-button");
	By NotificationFirstRecord = By.xpath(".//*[@id='pii-notif-jqgrid']/tbody/tr[2]");
	By NotificationOpenButton = By.id("pii-notif-report-btn");
	By NotificationCount = By.id("pii-notification-count");
	By NotificationFirstRecordDescriptionText = By.xpath(".//*[@id='pii-notif-jqgrid']/tbody/tr[2]/td[6]");
	By NotificationReadButton = By.id("pii-notif-ack-btn");
	By NotificationReadConfirmButton = By.id("pii-notifcenter-dialog-confirmed");
	By LoginNameOnTopRight = By.id("pii-user-loginname");
	By ActivityOnTopRight = By.id("pii-user-activity");
	By ModuleTitle = By.id("pii-user-home-title");
	By SharedReportDownloadButton = By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a");
	
	public void shareTwice (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		Thread.sleep(2000);
		//Enters sharer username
		wait.until(ExpectedConditions.visibilityOfElementLocated(ShareTextBox)).sendKeys("jenkins_1_nonadmin");
		Thread.sleep(2000);
    	//Selects from dropdown
		WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(ShareDropdown));
		dropdown.findElement(FirstSelectionUnderDropdown).click();
		//Clicks on add user
		wait.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupButton)).click();
		Thread.sleep(2000);
		//Click on new shared row
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("QAA (jenkins_1_nonadmin)"))).click();
		//Click on remove sharing
		wait.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupButton)).click();
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
		driver.switchTo().frame(driver.findElement(IFrame));
		Thread.sleep(8000);
		if (login==1)
		{
          
          while(true)
		  {
         	 Thread.sleep(1000);
			  if (driver.findElement(StickyPopUp).isDisplayed())
			  {
				  WebElement ele =driver.findElement(StickyPopUp);
				  ele.findElement(StickyClose).click();
				  break;
			  }
			  else break;
		  }
        }	
		Thread.sleep(4000);
		//Click on notification
		wait.until(ExpectedConditions.visibilityOfElementLocated(NotificationBell)).click();
		Thread.sleep(2000);
		jse.executeScript("scroll(0,0)");
		Thread.sleep(2000);
		//Click on 1st record/notification
		wait.until(ExpectedConditions.visibilityOfElementLocated(NotificationFirstRecord)).click();
		//Click on Open Report button
		wait.until(ExpectedConditions.visibilityOfElementLocated(NotificationOpenButton)).click();
		//Wait for loading message to disappear
		loadingServer(driver);
		//Check in sticky pop up that the report is deleted
		try{
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(StickyNote)).getText();
			softly.assertThat(s).as("test data").contains("not found ");
			softly.assertThat(s).as("test data").contains("It could have been deleted.");
		}catch (org.openqa.selenium.TimeoutException e)
		  {
			System.out.println("Report deleted and yellow pop up suggesting same has disappeared");  
		  }	
		//Check if open report button is still present on page
		wait.until(ExpectedConditions.visibilityOfElementLocated(NotificationOpenButton));
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
		driver.switchTo().frame(driver.findElement(IFrame));
		Thread.sleep(8000);
		if (login==1)
		{
          
          while(true)
		  {
         	 Thread.sleep(1000);
			  if (driver.findElement(StickyPopUp).isDisplayed())
			  {
				  WebElement ele =driver.findElement(StickyPopUp);
				  ele.findElement(StickyClose).click();
				  break;
			  }
			  else break;
		  }
        }	
		Thread.sleep(4000);
		//Get count from notification
		String count = wait.until(ExpectedConditions.visibilityOfElementLocated(NotificationCount)).getText();
		System.out.println("Number of notifications: "+count);
		int n = Integer.parseInt(count);
		Thread.sleep(2000);
		//Click on notification
		wait.until(ExpectedConditions.visibilityOfElementLocated(NotificationBell)).click();
		Thread.sleep(2000);
		jse.executeScript("scroll(0,0)");
		Thread.sleep(2000);
		//Click on 1st record/notification
		//wait.until(ExpectedConditions.visibilityOfElementLocated(NotificationFirstRecord)).click();
		//Verify if notification is of marked critical
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(NotificationFirstRecordDescriptionText)).getText();
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
			WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(NotificationFirstRecord));
			act.click(ele).build().perform();
			Thread.sleep(4000);
			//Click on read
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(NotificationReadButton));
			act.click(ele).build().perform();
			Thread.sleep(2000);
			//Click on mark as read
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(NotificationReadConfirmButton));
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
			WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(NotificationFirstRecord));
			if(ele.isSelected()==false)
				wait.until(ExpectedConditions.visibilityOfElementLocated(NotificationFirstRecord)).click();
			Thread.sleep(2000);
			//Click on read
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(NotificationReadButton));
			if(ele.isEnabled()==false)
				wait.until(ExpectedConditions.visibilityOfElementLocated(NotificationFirstRecord)).click();
			ele.click();
			Thread.sleep(2000);
			//Click on mark as read
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(NotificationReadConfirmButton));
			ele.click();
			}
		}		
		//Wait for loading message to disappear
		loadingServer(driver);
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
		driver.switchTo().frame(driver.findElement(IFrame));
		Thread.sleep(8000);
		if (login1==1)
		{
          
          while(true)
		  {
         	 Thread.sleep(1000);
			  if (driver.findElement(StickyPopUp).isDisplayed())
			  {
				  WebElement ele =driver.findElement(StickyPopUp);
				  ele.findElement(StickyClose).click();
				  break;
			  }
			  else break;
		  }
        }	
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		if(browserName.equals("firefox"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(LoginNameOnTopRight)).click();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(ActivityOnTopRight)).click();
			Thread.sleep(4000);
		}
		else
		{
		//Clicks on admin user name on top right corner
		WebElement ele =wait.until(ExpectedConditions.visibilityOfElementLocated(LoginNameOnTopRight));
		act.click(ele).build().perform();
		Thread.sleep(3000);
		//Clicks on Activity
		wait.until(ExpectedConditions.visibilityOfElementLocated(ActivityOnTopRight));
		WebElement ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(ActivityOnTopRight));
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
		driver.switchTo().frame(driver.findElement(IFrame));
		Thread.sleep(8000);
		if (login==1)
		{
          
          while(true)
		  {
         	 Thread.sleep(1000);
			  if (driver.findElement(StickyPopUp).isDisplayed())
			  {
				  WebElement ele =driver.findElement(StickyPopUp);
				  ele.findElement(StickyClose).click();
				  break;
			  }
			  else break;
		  }
        }	
		Thread.sleep(4000);
		//Get count from notification
		String count = wait.until(ExpectedConditions.visibilityOfElementLocated(NotificationCount)).getText();
		System.out.println("Number of notifications: "+count);
		int n= Integer.parseInt(count);
		Thread.sleep(2000);
		//Click on notification
		wait.until(ExpectedConditions.visibilityOfElementLocated(NotificationBell)).click();
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(NotificationFirstRecord)).click();
		//Click on Open Report button
		wait.until(ExpectedConditions.visibilityOfElementLocated(NotificationOpenButton)).click();
		//Wait for loading message to disappear
		loadingServer(driver);
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(ModuleTitle)).getText();
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
			WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(NotificationBell));
			act.click(ele).build().perform();
			Thread.sleep(4000);
			for(int i=1;i<=n;i++)
			{
			Thread.sleep(2000);
			//Click on 1st record/notification
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(NotificationFirstRecord));
			act.click(ele).build().perform();
			Thread.sleep(4000);
			//Click on read
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(NotificationReadButton));
			act.click(ele).build().perform();
			Thread.sleep(2000);
			//Click on mark as read
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(NotificationReadConfirmButton));
			act.click(ele).build().perform();
			Thread.sleep(2000);
			}
		}
		else{
			//Go back to notifications
			wait.until(ExpectedConditions.visibilityOfElementLocated(NotificationBell)).click();
			Thread.sleep(2000);
			for(int i=1;i<=n;i++)
			{
			Thread.sleep(2000);
			//Click on 1st record/notification
			WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(NotificationFirstRecord));
			if(ele.isSelected()==false)
				wait.until(ExpectedConditions.visibilityOfElementLocated(NotificationFirstRecord)).click();
			Thread.sleep(4000);
			//Click on read
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(NotificationReadButton));
			if(ele.isEnabled()==false)
				wait.until(ExpectedConditions.visibilityOfElementLocated(NotificationFirstRecord)).click();
			ele.click();
			Thread.sleep(2000);
			//Click on mark as read
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(NotificationReadConfirmButton));
			ele.click();
			Thread.sleep(2000);
			}
		}		
		//Wait for loading message to disappear
		loadingServer(driver);
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
		driver.switchTo().frame(driver.findElement(IFrame));
		Thread.sleep(8000);
		if (login1==1)
		{
          
          while(true)
		  {
         	 Thread.sleep(1000);
			  if (driver.findElement(StickyPopUp).isDisplayed())
			  {
				  WebElement ele =driver.findElement(StickyPopUp);
				  ele.findElement(StickyClose).click();
				  break;
			  }
			  else break;
		  }
        }	
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		if(browserName.equals("firefox"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(LoginNameOnTopRight)).click();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(ActivityOnTopRight)).click();
			Thread.sleep(4000);
		}
		else
		{
		//Clicks on admin user name on top right corner
		WebElement ele =wait.until(ExpectedConditions.visibilityOfElementLocated(LoginNameOnTopRight));
		act.click(ele).build().perform();
		Thread.sleep(3000);
		//Clicks on Activity
		wait.until(ExpectedConditions.visibilityOfElementLocated(ActivityOnTopRight));
		WebElement ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(ActivityOnTopRight));
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
		wait1.until(ExpectedConditions.visibilityOfElementLocated(SharedReportDownloadButton)).click();
		//Wait for loading message to disappear
		loadingServer(driver);
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupTitle)).click();
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupButton)).click();
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
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(SharedReportDownloadButton)).click();
		//Wait for loading message to disappear
		loadingServer(driver);
		String window = driver.getWindowHandle();
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupTitle)).click();
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupButton)).click();
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
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(SharedReportDownloadButton)).click();
		//Wait for loading message to disappear
		loadingServer(driver);
		String window = driver.getWindowHandle();
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupTitle)).click();
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupButton)).click();
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
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(SharedReportDownloadButton)).click();
		//Wait for loading message to disappear
		loadingServer(driver);
		String window = driver.getWindowHandle();
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupTitle)).click();
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupButton)).click();
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
	
	public void loadingServer(WebDriver driver) throws Exception {
		
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
		while (true)
		  {
			  try{
				  Thread.sleep(4000);
				  if(driver.findElement(LoadingMessage).isDisplayed())
				  {
					  Thread.sleep(5000);
				  }
				  else
					  break;
				  }catch (org.openqa.selenium.NoSuchElementException e)
				  {
					  break;
				  }
			  catch (org.openqa.selenium.StaleElementReferenceException e)
			  {
				  break;
			  }
		  }
	}
}
