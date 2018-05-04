import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
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
		Thread.sleep(5000);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Switches to the iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		Thread.sleep(5000);
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
		Thread.sleep(2000);
		//Go back to notifications
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-notification-button"))).click();
		//Click on 1st record/notification
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-notif-jqgrid']/tbody/tr[2]"))).click();
		Thread.sleep(2000);
		//Click on read
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-notif-ack-btn"))).click();
		Thread.sleep(2000);
		//Click on mark as read
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-notifcenter-dialog-confirmed"))).click();
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
	

}
