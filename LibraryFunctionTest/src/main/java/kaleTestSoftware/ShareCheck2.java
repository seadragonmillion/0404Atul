package kaleTestSoftware;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ShareCheck2 {

	ShareCheckPageObj share = new ShareCheckPageObj();
	LoginPageObj lpo = new LoginPageObj();

	public void loadingServer(WebDriver driver) throws Exception {

		while (true)
		{
			try{
				Thread.sleep(4000);
				if(driver.findElement(share.LoadingMessage).isDisplayed())
				{
					Thread.sleep(5000);
				}
				else
					break;
			}catch (org.openqa.selenium.NoSuchElementException |org.openqa.selenium.StaleElementReferenceException e)
			{
				break;
			}
			catch (org.openqa.selenium.ScriptTimeoutException e)
			{
				Thread.sleep(6000);
			}
		}
	}

	public void checkIfUserProfileNoFieldsMissing(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on LoginName
		wait.until(ExpectedConditions.visibilityOfElementLocated(share.LoginNameOnTopRight)).click();
		//Close any sticky if there
		while(true)
		{
			try{
				if (driver.findElement(lpo.StickyNote).isDisplayed())
				{
					Thread.sleep(1000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.StickyClose)).click();
				}
			}catch (NoSuchElementException |StaleElementReferenceException | org.openqa.selenium.TimeoutException | org.openqa.selenium.ElementNotInteractableException |org.openqa.selenium.JavascriptException e)
			{
				break;
			}
		}
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		if(browserName.equals("internet")==false)
		{
			while(true)				
			{
				Thread.sleep(500);
				//Clicks on Account
				wait.until(ExpectedConditions.visibilityOfElementLocated(share.LoginNameOnTopRight)).click();
				Thread.sleep(500);
				if(driver.findElement(share.AccountOnTopRight).isDisplayed())
					break;
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(share.AccountOnTopRight)).click();
		}
		else
		{
			Actions act = new Actions (driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(share.LoginNameOnTopRight));
			WebElement element = driver.findElement(share.LoginNameOnTopRight);
			act.click(element).build().perform();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(share.AccountOnTopRight));
			element = driver.findElement(share.AccountOnTopRight);
			act.click(element).build().perform();
			Thread.sleep(2000);
		}
		scrollToTop(driver);
		while(true)				
		{
			Thread.sleep(500);
			//Clicks on save
			wait.until(ExpectedConditions.visibilityOfElementLocated(share.UserAccountSaveButton)).click();
			Thread.sleep(500);
			if(browserName.contains("safari"))
				Thread.sleep(2000);
			if(driver.findElement(share.UserAccountSavePopupTitle).isDisplayed())
				break;
		}
		String saveMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(share.UserAccountSavePopupTitle)).getText().trim();
		softly.assertThat(saveMessage).as("test data").isEqualTo("Are you sure you want to save changes of current user data?");
		wait.until(ExpectedConditions.visibilityOfElementLocated(share.UserAccountSavePopupSaveButton)).click();
		//Waits for loading message to disappear
		loadingServer(driver);
	}

	public void scrollToAPoint(WebDriver driver, int yaxis)throws Exception{

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Thread.sleep(1000);
		try{
			jse.executeScript("scroll(0,"+yaxis+")");
		}catch (org.openqa.selenium.ScriptTimeoutException r)
		{
			Thread.sleep(3000);
			jse.executeScript("scroll(0,"+yaxis+")");
		}
		Thread.sleep(1000);
	}

	public void scrollToElement(WebDriver driver, WebElement l)throws Exception{

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Point p = l.getLocation();
		int yaxis= p.getY()-250;
		Thread.sleep(1000);
		try{
			jse.executeScript("scroll(0,"+yaxis+")");
		}catch (org.openqa.selenium.ScriptTimeoutException r)
		{
			Thread.sleep(3000);
			jse.executeScript("scroll(0,"+yaxis+")");
		}
		Thread.sleep(1000);
	}

	public void scrollToTop(WebDriver driver) throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Thread.sleep(1000);
		try{
			jse.executeScript("scroll(0,0)");
		}catch (org.openqa.selenium.ScriptTimeoutException r)
		{
			Thread.sleep(3000);
			jse.executeScript("scroll(0,0)");
		}
		Thread.sleep(1000);
	}
}
