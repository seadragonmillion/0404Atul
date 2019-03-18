package kaleTestSoftware;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.Point;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Finder;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;


public class ShareCheck {

	public String password = "S2FsZWplbmtpbnNAMTIz";
	SoftAssertions softly = new SoftAssertions();

	RemoteVerificationPageObj rv = new RemoteVerificationPageObj();
	OPiRCAPageObj opirca = new OPiRCAPageObj();
	EiRCAPageObj eirca = new EiRCAPageObj();
	EiRCA3 eirca3 = new EiRCA3();
	ShareCheckPageObj share = new ShareCheckPageObj();
	ShareCheck2 share2 = new ShareCheck2();
	LoginPageObj login = new LoginPageObj();
	Login loginFunction = new Login();

	public void checkColorOfElement(WebDriver driver, By locator,SoftAssertions softly) throws Exception {

		List<String> hexValue = new ArrayList<String>();
		//Get color
		String color = driver.findElement(locator).getCssValue("color");
		//System.out.println(color);
		//Format to # from rgba
		if(color.contains("rgba"))
			hexValue.addAll(Arrays.asList(color.replace("rgba(", "").replace(")", "").split(",")));
		else
			hexValue.addAll(Arrays.asList(color.replace("rgb(", "").replace(")", "").split(",")));
		//System.out.println(hexValue);
		int hexValue1=Integer.parseInt(hexValue.get(0));
		int hexValue2=Integer.parseInt(hexValue.get(1).trim());
		int hexValue3=Integer.parseInt(hexValue.get(2).trim());		 
		String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
		//System.out.println(actualColor);
		//compare with expected color
		softly.assertThat(actualColor).as("test data").isEqualTo("#333333");
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

	public void shareTwice (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		Thread.sleep(2000);
		//Enters sharer username
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ShareTextBox)).sendKeys("jenkins_1_nonadmin");
		Thread.sleep(2000);
		//Selects from dropdown
		WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ShareDropdown));
		dropdown.findElement(eirca.FirstSelectionUnderDropdown).click();
		//Verify add sharer pop up
		eirca3.verifyAddSharerPopup(driver, softly, "QAA (jenkins_1_nonadmin)");
		//Clicks on add user
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
		Thread.sleep(2000);
		//Click on new shared row
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("QAA (jenkins_1_nonadmin)"))).click();
		//Verify remove sharer pop up
		eirca3.verifyRemoveSharerPopup(driver, softly, "QAA (jenkins_1_nonadmin)");
		//Click on remove sharing
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
	}

	public void checkNoReportAfterDelete (WebDriver driver, String sharer, SoftAssertions softly) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//LogOut
		loginFunction.logout(driver);
		Thread.sleep(2000);
		//If browser is firefox then switch to default content
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		if(browserName.equals("firefox")||browserName.contains("safari"))
		{
			driver.switchTo().defaultContent();
		}
		Thread.sleep(8000);
		int login1 = loginFunction.LoginUser(driver, sharer, password);
		System.out.println("Title after login: "+driver.getTitle());
		Thread.sleep(10000);
		//Switches to the iframe
		driver.switchTo().frame(driver.findElement(login.Iframe));
		Thread.sleep(8000);
		if (login1==1)
		{

			while(true)
			{
				Thread.sleep(1000);
				if (driver.findElement(share.StickyPopUp).isDisplayed())
				{
					WebElement ele =driver.findElement(share.StickyPopUp);
					ele.findElement(login.StickyClose).click();
					break;
				}
				else break;
			}
		}	
		Thread.sleep(4000);
		//Click on notification
		wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationBell)).click();
		Thread.sleep(2000);
		jse.executeScript("scroll(0,0)");
		Thread.sleep(2000);
		//Click on 1st record/notification
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationFirstRecord)));
		//Click on Open Report button
		wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationOpenButton)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Check in sticky pop up that the report is deleted
		try{
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyNote)).getText();
			softly.assertThat(s).as("test data").contains("not found ");
			softly.assertThat(s).as("test data").contains("It could have been deleted.");
		}catch (org.openqa.selenium.TimeoutException e)
		{
			System.out.println("Report deleted and yellow pop up suggesting same has disappeared");  
		}	
		//Check if open report button is still present on page
		wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationOpenButton));
	}

	public void checkCriticalNotification (WebDriver driver, String sharer, String username, String password1, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		//LogOut
		loginFunction.logout(driver);
		Thread.sleep(2000);
		//If browser is firefox then switch to default content
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		if(browserName.equals("firefox")||browserName.contains("safari"))
		{
			driver.switchTo().defaultContent();
		}
		Thread.sleep(8000);
		int login1 = loginFunction.LoginUser(driver, sharer, password);
		System.out.println("Title after login: "+driver.getTitle());
		Thread.sleep(10000);
		//Switches to the iframe
		driver.switchTo().frame(driver.findElement(login.Iframe));
		Thread.sleep(8000);
		if (login1==1)
		{

			while(true)
			{
				Thread.sleep(1000);
				if (driver.findElement(share.StickyPopUp).isDisplayed())
				{
					WebElement ele =driver.findElement(share.StickyPopUp);
					ele.findElement(login.StickyClose).click();
					break;
				}
				else break;
			}
		}	
		Thread.sleep(4000);
		//Get count from notification
		String count = wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationCount)).getText();
		System.out.println("Number of notifications: "+count);
		int n = Integer.parseInt(count);
		Thread.sleep(2000);
		//Click on notification
		wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationBell)).click();
		scrollToTop(driver);
		share2.loadingServer(driver);
		//Click on 1st record/notification
		//Verify if notification is of marked critical
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationFirstRecordDescriptionText)).getText();
		softly.assertThat(s).as("test data").contains("Critical");
		Thread.sleep(2000);
		Thread.sleep(2000);
		for(int i=1;i<=n;i++)
		{
			Thread.sleep(2000);
			//Click on 1st record/notification
			WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationFirstRecord));
			if(wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationFirstRecord)).isSelected()==false)
				executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationFirstRecord)));
			Thread.sleep(2000);
			//Click on read
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationReadButton));
			if(ele.isEnabled()==false)
				wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationFirstRecord)).click();
			ele.click();
			Thread.sleep(2000);
			//Click on mark as read
			try{
				ele = wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationReadConfirmButton));
				ele.click();
			}catch(org.openqa.selenium.TimeoutException g)
			{
				//Click on 1st record/notification
				if(wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationFirstRecord)).isSelected()==false)
					executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationFirstRecord)));
				Thread.sleep(2000);
				//Click on read
				ele = wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationReadButton));
				if(ele.isEnabled()==false)
					executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationFirstRecord)));
				ele.click();
				//Mark as read
				ele = wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationReadConfirmButton));
				ele.click();				
			}
		}
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Log in back to user
		logInToUser(driver,username,password1);
	}

	public void receiptReport(WebDriver driver, String sharer, String username, String password1) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		//LogOut
		loginFunction.logout(driver);
		Thread.sleep(2000);
		//If browser is firefox then switch to default content
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		if(browserName.equals("firefox")||browserName.contains("safari"))
		{
			driver.switchTo().defaultContent();
		}
		Thread.sleep(8000);
		int login1 = loginFunction.LoginUser(driver, sharer, password);
		System.out.println("Title after login: "+driver.getTitle());
		Thread.sleep(10000);
		//Switches to the iframe
		driver.switchTo().frame(driver.findElement(login.Iframe));
		Thread.sleep(8000);
		if (login1==1)
		{

			while(true)
			{
				Thread.sleep(1000);
				if (driver.findElement(share.StickyPopUp).isDisplayed())
				{
					WebElement ele =driver.findElement(share.StickyPopUp);
					ele.findElement(login.StickyClose).click();
					break;
				}
				else break;
			}
		}	
		Thread.sleep(4000);
		//Get count from notification
		String count = wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationCount)).getText();
		System.out.println("Number of notifications: "+count);
		int n= Integer.parseInt(count);
		Thread.sleep(2000);
		//Click on notification
		wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationBell)).click();
		Thread.sleep(1000);
		if(browserName.equals("firefox")==false)
		{
			scrollToTop(driver);
		}
		//Click on 1st record/notification
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationFirstRecord)));
		//Click on Open Report button
		wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationOpenButton)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		share2.loadingServer(driver);
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(share.ModuleTitle)).getText();
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
			}
		}
		Thread.sleep(2000);
		Thread.sleep(2000);
		if(browserName.equals("internet explorer"))
		{
			Actions act = new Actions (driver);
			//Go back to notifications
			WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationBell));
			act.click(ele).build().perform();
			Thread.sleep(4000);
			for(int i=1;i<=n;i++)
			{
				//verify the title in remote verification title
				if(s.contains("Remote Verification"))
				{
					String title = wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationFirstRecordReportTitle)).getText();
					System.out.println("Title in rv in sharer notification center: "+title);
					softly.assertThat(title).as("test data").contains(rv.eventTitle(driver));
				}
				share2.loadingServer(driver);
				//Click on 1st record/notification
				ele = wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationFirstRecord));
				Thread.sleep(4000);
				if(wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationFirstRecord)).isSelected()==false)
					act.click(ele).build().perform();
				//Click on read
				ele = wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationReadButton));
				if(ele.isEnabled()==false)
					wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationFirstRecord)).click();
				act.click(ele).build().perform();
				Thread.sleep(2000);
				//Click on mark as read
				while(true)
				{
					try{
						ele = wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationReadConfirmButton));
						break;
					}catch(org.openqa.selenium.TimeoutException t)
					{
						ele = wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationReadButton));
						try{
						act.click(ele).build().perform();
						}catch(org.openqa.selenium.WebDriverException w)
						{
							continue;
						}
					}
				}
				ele = wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationReadConfirmButton));
				act.click(ele).build().perform();
				Thread.sleep(2000);
			}
		}
		else{
			//Go back to notifications
			wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationBell)).click();
			Thread.sleep(2000);
			for(int i=1;i<=n;i++)
			{
				Thread.sleep(2000);
				//Click on 1st record/notification
				WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationFirstRecord));
				if(ele.isSelected()==false)
					executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationFirstRecord)));
				Thread.sleep(4000);
				//Click on read
				ele = wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationReadButton));
				if(ele.isEnabled()==false)
					executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationFirstRecord)));
				ele.click();
				Thread.sleep(2000);
				//Click on mark as read
				ele = wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationReadConfirmButton));
				ele.click();
				Thread.sleep(2000);
			}
		}		
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Log in back to user
		logInToUser(driver,username,password1);
	}

	public void logInToUser(WebDriver driver,String username, String password1) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		//LogOut
		loginFunction.logout(driver);
		if(browserName.equals("firefox")||browserName.contains("safari"))
		{
			driver.switchTo().defaultContent();
		}
		Thread.sleep(6000);
		int login1 = loginFunction.LoginUser(driver, username, password1);
		System.out.println("Title after login: "+driver.getTitle());
		Thread.sleep(5000);
		//Switches to the iframe
		driver.switchTo().frame(driver.findElement(login.Iframe));
		Thread.sleep(8000);
		if (login1==1)
		{

			while(true)
			{
				Thread.sleep(1000);
				if (driver.findElement(share.StickyPopUp).isDisplayed())
				{
					WebElement ele =driver.findElement(share.StickyPopUp);
					ele.findElement(login.StickyClose).click();
					break;
				}
				else break;
			}
		}	
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		if(browserName.equals("firefox"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(share.LoginNameOnTopRight)).click();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(share.ActivityOnTopRight)).click();
			Thread.sleep(4000);
		}
		else
		{
			//Clicks on admin user name on top right corner
			WebElement ele =wait.until(ExpectedConditions.visibilityOfElementLocated(share.LoginNameOnTopRight));
			act.click(ele).build().perform();
			Thread.sleep(3000);
			//Clicks on Activity
			wait.until(ExpectedConditions.visibilityOfElementLocated(share.ActivityOnTopRight));
			WebElement ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(share.ActivityOnTopRight));
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
		wait1.until(ExpectedConditions.visibilityOfElementLocated(share.SharedReportDownloadButton)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
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
		wait1.until(ExpectedConditions.visibilityOfElementLocated(share.SharedReportDownloadButton)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
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
		wait1.until(ExpectedConditions.visibilityOfElementLocated(share.SharedReportDownloadButton)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
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
		wait1.until(ExpectedConditions.visibilityOfElementLocated(share.SharedReportDownloadButton)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
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



	public void helpEmailCheck(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Wait for loading server message
		share2.loadingServer(driver);
		//Scroll to contact
		WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(share.PIIContactButton));
		scrollToElement(driver,l);
		//Click on contact
		l.click();
		//Wait for loading server message
		share2.loadingServer(driver);
		//Click on KALE support
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(share.KALESupportButton));
		l.click();
		String kaleWindow = driver.getWindowHandle();
		//get email from mail client
		Process p = Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/GetEmailFromEMMailClient.exe");
		p.waitFor();
		BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line;
		while ((line = input.readLine()) != null) {
			System.out.println(line);
		}
		System.out.println("0000");
		Thread.sleep(4000);
		Screen screen = new Screen();
		ImageIO.write(screen.capture().getImage(), "png", new File("C:\\Users\\IEUser\\screenshots\\screenshots1.png"));
		Thread.sleep(4000);
		//Crop image
		File fileToWrite = new File("C:\\Users\\IEUser\\screenshots\\screenshots1.png");
		BufferedImage bufferedImage = cropImage(fileToWrite, 0, 0, 300, 300);
		File outputfile = new File("C:\\Users\\IEUser\\screenshots\\screenshots2.png");
		ImageIO.write(bufferedImage, "png", outputfile);
		//Compare the 2 images
		compareImage();
		//Close the email client
		Process p1 = Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/CloseEMClient.exe");
		p1.waitFor();
		Process p2 = Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/CloseEMClient.exe");
		p2.waitFor();
		//Switch to kale window
		driver.switchTo().window(kaleWindow);
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		if (browserName.equals("firefox")||browserName.contains("safari"))
			driver.switchTo().defaultContent();
		//Switches to the iframe
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
		closeMailClient();
	}

	public void closeMailClient() throws Exception {
		ProcessBuilder builder = new ProcessBuilder(
				"cmd.exe", "/c", "taskkill /F /IM MailClient.exe");
		builder.redirectErrorStream(true);
		Process p = builder.start();
		BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line;
		while (true) {
			line = r.readLine();
			if (line == null) { break; }
			System.out.println(line);
		}
	}

	public void compareImage() throws IOException {

		Pattern searchImage = new Pattern("C:\\Users\\IEUser\\screenshots\\screenshotPermanent.png").similar((float)0.9);
		//In this case, the image you want to search
		String ScreenImage = "C:\\Users\\IEUser\\screenshots\\screenshots2.png"; 
		Finder objFinder = null;
		objFinder = new Finder(ScreenImage);
		//searchImage is the image you want to search within ScreenImage
		objFinder.find(searchImage);
		int counter = 0;
		while(objFinder.hasNext())
		{
			objFinder.next(); //objMatch gives you the matching region.
			counter++;
		}
		if(counter!=0)
			System.out.println("Match Found!");
		else softly.fail("No the email is wrong as image did not match");
	}

	public BufferedImage cropImage(File filePath, int x, int y, int w, int h){

		try {
			BufferedImage originalImgage = ImageIO.read(filePath);
			BufferedImage subImgage = originalImgage.getSubimage(x, y, w, h);
			return subImgage;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<String> usersSharedDevAsia(WebDriver driver)throws Exception {
		List<String> text = new ArrayList<String>();
		text.add("qaasharer_1");
		text.add("qaasharer_2");
		text.add("qaasharer_3");
		text.add("qaasharer_4");
		text.add("qaasharer_5");
		text.add("qaasharer_6");
		text.add("qaasharer_7");
		text.add("qaasharer_8");
		text.add("qaasharer_9");
		text.add("qaasharer_10");
		return text;
	}

	public List<String> usersSharedDevAsiaIE11(WebDriver driver)throws Exception {
		List<String> text = new ArrayList<String>();
		text.add("qaasharer_ie11_11");
		text.add("qaasharer_ie11_2");
		text.add("qaasharer_ie11_3");
		text.add("qaasharer_ie11_4");
		text.add("qaasharer_ie11_5");
		text.add("qaasharer_ie11_6");
		text.add("qaasharer_ie11_7");
		text.add("qaasharer_ie11_8");
		text.add("qaasharer_ie11_9");
		text.add("qaasharer_ie11_10");
		return text;
	}

	public List<String> usersSharedUS(WebDriver driver)throws Exception {
		List<String> text = new ArrayList<String>();
		text.add("qaasharerus1");
		text.add("qaasharerus2");
		text.add("qaasharerus3");
		text.add("qaasharerus4");
		text.add("qaasharerus5");
		text.add("qaasharerus6");
		text.add("qaasharerus7");
		text.add("qaasharerus8");
		text.add("qaasharerus9");
		text.add("qaasharerus10");
		return text;
	}

	public List<String> usersSharedUSIE11(WebDriver driver)throws Exception {
		List<String> text = new ArrayList<String>();
		text.add("qaasharerus_ie11_1");
		text.add("qaasharerus_ie11_2");
		text.add("qaasharerus_ie11_3");
		text.add("qaasharerus_ie11_4");
		text.add("qaasharerus_ie11_5");
		text.add("qaasharerus_ie11_6");
		text.add("qaasharerus_ie11_7");
		text.add("qaasharerus_ie11_8");
		text.add("qaasharerus_ie11_9");
		text.add("qaasharerus_ie11_10");
		return text;
	}

	public void shareReportMultipleTimesAnalysisModules(WebDriver driver, String username, String password1) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		PassReview obj2 = new PassReview();
		share2.loadingServer(driver);
		//Go to Activity
		wait.until(ExpectedConditions.visibilityOfElementLocated(share.LoginNameOnTopRight)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(share.ActivityOnTopRight)).click();
		//Error meter
		//Click on side panel 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-epm"))).click();
		share2.loadingServer(driver);
		//First record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-epm']/ul/li[2]/a"))).click();
		share2.loadingServer(driver);
		//click on share button
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.ShareButton)).click();
		//share to 10 users
		shareReportToManyUsers(driver,username,password1);
		//HPI
		//Click on side panel 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-hpi"))).click();
		share2.loadingServer(driver);
		//First record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-hpi']/ul/li[2]/a"))).click();
		share2.loadingServer(driver);
		//click on share button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).click();
		//share to 10 users
		shareReportToManyUsers(driver,username,password1);
		//HiRCA
		//Click on side panel 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-irca"))).click();
		share2.loadingServer(driver);
		//First record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();
		share2.loadingServer(driver);
		//click on share button
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ShareButton)).click();
		//share to 10 users
		shareReportToManyUsers(driver,username,password1);
		//EiRCA
		//Click on side panel 
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASidePanel)).click();
		share2.loadingServer(driver);
		//First record
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAFirstRecord)).click();
		share2.loadingServer(driver);
		//click on share button
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ShareButton)).click();
		//share to 10 users
		shareReportToManyUsers(driver,username,password1);
		//O&PiRCA
		//Click on side panel 
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASidePanel)).click();
		share2.loadingServer(driver);
		//First record
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAFirstRecord)).click();
		share2.loadingServer(driver);
		//click on share button
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ShareButton)).click();
		//share to 10 users
		shareReportToManyUsers(driver,username,password1);
		//Job Observation
		//Click on side panel 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-joa"))).click();
		share2.loadingServer(driver);
		//First record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-joa']/ul/li[2]/a"))).click();
		share2.loadingServer(driver);
		//click on share button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).click();
		//share to 10 users
		shareReportToManyUsers(driver,username,password1);
		//3 Pass Review
		//Click on side panel 
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.PassReviewSidePanel)).click();
		share2.loadingServer(driver);
		//First record
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.FirstRecord)).click();
		share2.loadingServer(driver);
		//click on share button
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.ShareButton)).click();
		//share to 10 users
		shareReportToManyUsers(driver,username,password1);
		//Remote Verification
		//Click on side panel 
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSidePanel)).click();
		share2.loadingServer(driver);
		//First record
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVNewlyCreatedFirstRecord)).click();
		share2.loadingServer(driver);
		//click on share button
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVShareButton)).click();
		//share to 10 users
		shareReportToManyUsers(driver,username,password1);
	}

	public void shareReportToManyUsers(WebDriver driver, String username, String password1) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		List<String> users = new ArrayList<String>();
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		String v = cap.getVersion().toString();
		//Decide on sharer list
		if(driver.getCurrentUrl().contains("kale."))
		{
			if(browserName.equals("internet explorer")&&v.startsWith("11"))
				users.addAll(usersSharedUSIE11(driver));
			else
				users.addAll(usersSharedUS(driver));
		}
		else
		{
			if(browserName.equals("internet explorer")&&v.startsWith("11"))
				users.addAll(usersSharedDevAsiaIE11(driver));
			else
				users.addAll(usersSharedDevAsia(driver));
		}
		for(int i=0;i<users.size();i++)
		{
			//Enters sharer username
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ShareTextBox)).sendKeys(users.get(i));
			Thread.sleep(2000);
			//Selects from dropdown
			WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ShareDropdown));
			dropdown.findElement(eirca.FirstSelectionUnderDropdown).click();
			//Clicks on add user
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
			Thread.sleep(2000);
		}
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ShareSaveButton)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Verify notificaion received by shared users
		verifyNoificationsInSharedUsers(driver,users,username,password1);
	}

	public void verifyNoificationsInSharedUsers(WebDriver driver, List<String> users, String username, String password1) throws Exception {

		for(int i=0;i<users.size();i++)
		{
			if((i+1)<users.size())
			{
				//Verify if notification is visible and mark it read
				receiveNotification(driver, users.get(i));
			}
		}
		//Log back into user
		logInToUser(driver,username,password1);
	}

	public void receiveNotification(WebDriver driver, String sharer) throws Exception {

		//LogOut
		loginFunction.logout(driver);
		Thread.sleep(2000);
		//If browser is firefox then switch to default content
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		if(browserName.equals("firefox")||browserName.contains("safari"))
		{
			driver.switchTo().defaultContent();
		}
		Thread.sleep(8000);
		int login1 = loginFunction.LoginUser(driver, sharer, password);
		System.out.println("Title after login: "+driver.getTitle());
		Thread.sleep(10000);
		//Switches to the iframe
		driver.switchTo().frame(driver.findElement(login.Iframe));
		Thread.sleep(8000);
		if (login1==1)
		{

			while(true)
			{
				Thread.sleep(1000);
				if (driver.findElement(share.StickyPopUp).isDisplayed())
				{
					WebElement ele =driver.findElement(share.StickyPopUp);
					ele.findElement(login.StickyClose).click();
					break;
				}
				else break;
			}
		}	
		Thread.sleep(4000);
		//Mark read all notifications
		markNotificationsRead(driver,browserName);
	}

	public void markNotificationsRead(WebDriver driver, String browserName) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		//Get count from notification
		String count = wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationCount)).getText();
		System.out.println("Number of notifications: "+count);
		int n= Integer.parseInt(count);
		//Click on notification
		wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationBell)).click();
		Thread.sleep(1000);
		if(browserName.equals("firefox")==false)
			scrollToTop(driver);
		if(browserName.equals("internet explorer"))
		{
			Actions act = new Actions (driver);
			for(int i=1;i<=n;i++)
			{
				Thread.sleep(2000);
				//Click on 1st record/notification
				WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationFirstRecord));
				act.click(ele).build().perform();
				share2.loadingServer(driver);
				if(wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationReadButton)).isSelected()==false)
					wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationFirstRecord)).click();
				//Click on read
				ele = wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationReadButton));
				if(ele.isEnabled()==false)
					wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationFirstRecord)).click();
				act.click(ele).build().perform();
				Thread.sleep(2000);
				//Click on mark as read
				ele = wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationReadConfirmButton));
				act.click(ele).build().perform();
				share2.loadingServer(driver);
			}
		}
		else
		{
			for(int i=1;i<=n;i++)
			{
				Thread.sleep(2000);
				//Click on 1st record/notification
				WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationFirstRecord));
				if(ele.isSelected()==false)
					executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationFirstRecord)));
				Thread.sleep(4000);
				//Click on read
				ele = wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationReadButton));
				if(ele.isEnabled()==false)
					executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationFirstRecord)));
				ele.click();
				Thread.sleep(2000);
				//Click on mark as read
				ele = wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationReadConfirmButton));
				ele.click();
				share2.loadingServer(driver);
			}
		}		
		//Wait for loading message to disappear
		share2.loadingServer(driver);
	}


	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}
}
