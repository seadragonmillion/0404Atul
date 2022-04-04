import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import kaleTestSoftware.Login;
import kaleTestSoftware.RemoteVerificationPageObj;
import kaleTestSoftware.ShareCheck2;

public class Case_SlideSecurity {

	private WebDriver driver;
	private String username = "jenkinsvmnonadmin";
	private String url = "https://kaleqa.error-free.com/";
	private String password = "S2FsZWplbmtpbnNAMTIz";

//	private String username ="tester03am";
//	private String url = "https://kale.error-free.com/";
//	private String password = "SHBAMTIzNDU=";

//	private String username ="jenkins_2_nonadmin";
//	private String url = "https://kaleasia.error-free.com/";
//	private String password = "S2FsZWplbmtpbnNAMTIz";

	/*
	 * if(driver.getCurrentUrl().contains("kale.")) { private String username
	 * ="tester03am"; private String password = "SHBAMTIzNDU="; }else
	 * if(driver.getCurrentUrl().contains("kaleasia")){ username
	 * ="jenkins_2_nonadmin"; password = "S2FsZWplbmtpbnNAMTIz"; }else { username
	 * ="jenkins"; password = "S2FsZWplbmtpbnNAMTIz"; }
	 */

	private String chrome_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\chromedriver.exe";

	SoftAssertions softly = new SoftAssertions();
	ShareCheck2 share2 = new ShareCheck2();
	RemoteVerificationPageObj rv = new RemoteVerificationPageObj();

	@Rule
	public TestWatcher watcher = new TestWatcher() {
		@Override
		protected void failed(Throwable throwable, Description description) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(scrFile, new File("target/screenshots/" + "failshot.png"));
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}

		@Override
		protected void finished(Description description) {
			// driver.quit();
		}
	};

	@Before
	public void beforeTest() throws MalformedURLException, InterruptedException {

		System.out.println("Case_non admin_testCaseSlideSecurity_QAA1043");
		System.setProperty("webdriver.chrome.driver", chrome_path);
		driver = new ChromeDriver();
		Thread.sleep(5000);
		driver.manage().deleteAllCookies(); // delete all cookies
		Thread.sleep(7000); // wait 7 seconds to clear cookies.

		// Browser is maximized
		driver.manage().window().maximize();
		// Browser navigates to the KALE url
		driver.navigate().to(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws Exception {
		// Login User
		Login obj = new Login();
		int login = obj.LoginUser(driver, username, password);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		System.out.println("Title after login: " + driver.getTitle());
		Thread.sleep(2000);
		// Waits for the page to load
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// Switches to the iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		try {
			if (login == 1) {
				WebDriverWait wait2 = new WebDriverWait(driver, 20);
				wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();
			}
		} catch (NoSuchElementException e) {
			throw e;
		}
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		// Wait for loading message to disappear
		share2.loadingServer(driver);
		// Clicks on Error free bank
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankTopLink)).click();
		} catch (UnhandledAlertException f) {
			driver.switchTo().alert().dismiss();
		}
		// Clicks on Equipment Performance
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentPerformanceLink)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		// Click on collapsible
		try {
			builder.moveToElement(driver.findElement(By.id("pii-collapsible-equip-F" + cases.get(2)))).click().build()
					.perform();
			jse.executeScript("arguments[0].click();", wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F" + cases.get(2)))));
			Thread.sleep(500);
		} catch (Exception e) {
			try {
				wait.until(
						ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F" + cases.get(2))));
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.id("pii-collapsible-equip-F" + cases.get(2)))));
				Thread.sleep(500);
			} catch (Exception e1) {
			}
		}
		//Click on 'Show Slides'
		WebElement element =  driver.findElement(By.id("pii-slideshow-button-equip-F"+cases.get(2)));
		element.sendKeys(Keys.TAB);
		element.sendKeys(Keys.ENTER);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//1. mouse clicks anywhere inside the slide
		jse.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slides-equip-F1729"))));
		String xpath = ".//*[text()[contains(.,'Slides are deactivated')]]";
		if (driver.findElement(By.xpath(xpath)).isDisplayed())
		{
			System.out.println("Slide Security is activated (click inside Slide)");
		}
		      //Closes the slideshow
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+cases.get(2)+"']/a"))));
				
		//2. mouse clicks outside of slide
		jse.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slides-equip-F1729"))));
		if (driver.findElement(By.xpath(xpath)).isDisplayed())
		{
			System.out.println("Slide Security is activated (click outside Slide)");
		}
		       //Closes the slideshow
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+cases.get(2)+"']/a"))));
				
		//3. keyboard click
		
		
		//4. mouse moves outside of slide for 2 seconds or longer
		
		   
				//Closes the slideshow
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+cases.get(2)+"']/a"))));
				
		// Fill in (1) Verification report information.(create random number at the end
		// of report title)
		Random rn = new Random();
		rn.nextInt(999999);
		String title = "OfflineRVreportSyncTest" + rn;
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-tab-1-title"))).sendKeys(title);


		// Logout User
		Login login2 = new Login();
		login2.logout(driver);
		driver.manage().window().maximize();
	}

	public void afterTest() {
//		  driver.quit();
		softly.assertAll();

	}

}
