import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class deleteNotifications {

	String urlDev= "https://kaledev.error-free.com/";
	String urlUS= "https://kale.error-free.com/";
	
	public void deleteNotif(WebDriver driver,Login obj, int login) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
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
		//Click on notification
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-notification-button"))).click();
		Thread.sleep(2000);
		jse.executeScript("scroll(0,0)");
		Thread.sleep(2000);
		//Click on check box for selecting all noifications
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-notif-jqgrid_cb"))).click();
		Thread.sleep(2000);
		//Click on delete button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-notif-del-btn"))).click();
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-notifcenter-dialog-confirmed"))).click();
		}catch(org.openqa.selenium.TimeoutException r){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-notif-dialog-confirmed"))).click();
		}
		Thread.sleep(2000);
		ShareCheck obj1 = new ShareCheck();
		obj1.loadingServer(driver);
		//LogOut
		obj.logout(driver);
		Thread.sleep(4000);		
	}

}
