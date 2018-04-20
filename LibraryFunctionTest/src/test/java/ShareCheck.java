import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ShareCheck {
	
	private String password = "S2FsZWplbmtpbnNAMTIz";

	public void receiptReport(WebDriver driver, String sharer, String username, String password1) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//LogOut
		Login obj = new Login();
		obj.logout(driver);
		//If browser is firefox then switch to default content
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		if(browserName.equals("firefox"))
		{
		  	driver.switchTo().defaultContent();
		}
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
		//Click on read
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-notif-ack-btn"))).click();
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
		login = obj.LoginUser(driver, username, password1);
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
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		//Clicks on Activity
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-activity"))).click();		
	}
	

}
