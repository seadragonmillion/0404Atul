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
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import kaleTestSoftware.EiRCAPageObj;
import kaleTestSoftware.Login;
import kaleTestSoftware.RemoteVerificationPageObj;
import kaleTestSoftware.ShareCheck2;
import kaleTestSoftware.ShareCheckPageObj;

public class ChromeOffline4 {

	WebDriver driver;
//	private String username ="jenkins";
//	private String url = "https://kaleqa.error-free.com/";
//	private String password = "S2FsZWplbmtpbnNAMTIz";
	
	private String username ="tester03am";
	private String url = "https://kale.error-free.com/";
	private String password = "SHBAMTIzNDU=";
	
	private String chrome_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\chromedriver.exe";
	SoftAssertions softly = new SoftAssertions();
	ShareCheck2 share2 = new ShareCheck2();
	ShareCheckPageObj share = new ShareCheckPageObj();
	RemoteVerificationPageObj rv = new RemoteVerificationPageObj();
	EiRCAPageObj eirca = new EiRCAPageObj();
	Login login2 = new Login();

	
	  @Rule public TestWatcher watcher = new TestWatcher() {
	  
	  @Override protected void failed(Throwable throwable, Description description)
	  { File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  try { FileUtils.copyFile(scrFile, new
	  File("target/screenshots/"+"failshot.png")); } catch (IOException exception)
	  { exception.printStackTrace(); } }
	  
	  @Override protected void finished(Description description) {  
		  //driver.quit();
      }
	};

	@Before
	public void beforeTest() throws MalformedURLException, InterruptedException {
		System.out.println(
				"RV OfflineSync4: file01 online, file02 added offline, 2 files should display when back online");

		System.setProperty("webdriver.chrome.driver", chrome_path);

//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("user-data-dir=C:/Users/mama/AppData/Local/Google/Chrome/User Data/");
//		options.addArguments("profile-directory=Profile 4");
		driver = new ChromeDriver();

		Thread.sleep(5000);
		driver.manage().deleteAllCookies(); // delete all cookies
		Thread.sleep(7000); // wait 7 seconds to clear cookies.

		// Browser is maximized
		driver.manage().window().maximize();
		// Browser navigates to the KALE url
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws Exception {
		// Login User
		Login obj = new Login();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		int login = obj.LoginUser(driver, username, password);
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

		// Click on Analysis on main menu
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-a"))).click();
		// Click on RV module
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-rv"))).click();
		// Fill in (1) Verification report information.(create random number at the end
		// of report title)
		Random rn = new Random();
		rn.nextInt(999999);
		String title = "OfflineRVreportSyncTest" + rn;
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-tab-1-title"))).sendKeys(title);

		// Click checkbox I certify...
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-imgwork-photo-icertify-checkbox")))
				.click();
		// (2) Upload Supporting files
		String filepath = "C:/Users/mama/Pictures/Upload/CCYC2355.JPG";
		// Click on Supporting file details
		share2.scrollToElement(driver,
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-event-filecollapsible-0"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-event-filecollapsible-0"))).click();
		// Under Supporting file: Click on Choose File button
		share2.scrollToElement(driver,
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-event-file-button-0"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-event-file-button-0"))).click();
		// Fill 1st supporting file title
		String title_id = "pii-rv-event-file-title-0";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(title_id))).sendKeys("Title00");
		// Fill 1st supporting file description
		String des_id = "pii-rv-event-file-description-0";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(des_id))).sendKeys("Des00");
		// Choose File upload photo
		driver.findElement(By.id("pii-rv-event-file-0")).sendKeys(filepath);
		Runtime.getRuntime().exec("C:\\Users\\rramakrishnan\\AutoItScripts\\clickcancel2.exe");
		// Wait for image
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-event-file-img-0")));
		if (driver.findElement(By.id("pii-rv-event-file-img-0")).isDisplayed()) {
			System.out.println("Supporting 1 uploaded online " + " is displayed");

		}
		/*
		// Upload photo (3) Take or choose a photo of the person requesting
		// verification.
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();",
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-imgperson-photo-input"))));
		driver.findElement(By.id("pii-rv-imgperson-photo-input")).sendKeys(filepath);
		Runtime.getRuntime().exec("C:\\Users\\mama\\Downloads\\clickcancel2.exe");*/
		// Fill in (4) Fill in relevant details and description of work needing
		// verification.
		share2.scrollToElement(driver,
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-tab-1-details"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-tab-1-details")))
				.sendKeys("work evaluation");
		share2.scrollToAPoint(driver, 400);
		// Click on (5) Select whether this verification is: In Person
		jse.executeScript("arguments[0].click();",
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-tab-1-5-inperson-radio-ip"))));
		// Click (6) Verifier sign-off checkbox: I certify that...
		jse.executeScript("arguments[0].click();",
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-tab-1-6ip-icertify-checkbox"))));
		// Fill in (6) Verifier sign-off's Name
				jse.executeScript("arguments[0].scrollIntoView(true);",wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-tab-1-6-inperson-name"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-tab-1-6-inperson-name")))
				.sendKeys("MarryAnne");
		// Fill in (6) Verifier sign-off's Title
		share2.scrollToAPoint(driver, 400);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-tab-1-6-inperson-title")))
				.sendKeys("Site Manager");
		// Click on Save Button
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-save2"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-save2"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-save2"))).click();
		// Click Save in Save report popup
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-dialog-confirmed"))));
		Thread.sleep(8000);
///////////////////////////////////////////////////////////////////////////////////////		
		// Disconnect with WiFi
		Runtime.getRuntime().exec("netsh wlan disconnect");
		// Assert: Confirm Offline warning message and print and close
		try {
			// Closes server warning
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note"))).getText()
					.trim();
			System.out.println("Disconnecting wifi sticky: " + s);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();
		} catch (org.openqa.selenium.TimeoutException e) {

		}
		Thread.sleep(7000);

		// Click on Open existing RV report
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.OpenButton)).click();
		String noHtml = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).getText();
		softly.assertThat(noHtml).as("test data").doesNotContain("<br/>");
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
		Thread.sleep(1000);

		// Click on attach another file
		WebElement add = driver.findElement(By.id("pii-rv-addnewfile-button"));
		jse.executeScript("arguments[0].focus();", add);
		jse.executeScript("arguments[0].click();", add);
//		share2.scrollToElement(driver, add);
//		add.click();
		// Fill 2nd supporting file title
		String title_id1 = "pii-rv-event-file-title-1";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(title_id1))).sendKeys("Title01");
		// Fill 2nd supporting file description
		String des_id1 = "pii-rv-event-file-description-1";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(des_id1))).sendKeys("Des01");
		// Choose File upload photo
		driver.findElement(By.id("pii-rv-event-file-1")).sendKeys(filepath);
		Runtime.getRuntime().exec("C:\\Users\\rramakrishnan\\AutoItScripts\\clickcancel2.exe");
		// Wait for image
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-event-file-img-1")));
		if (driver.findElement(By.id("pii-rv-event-file-img-1")).isDisplayed()) {
			System.out.println("Supporting 2 uploaded offline " + " is displayed");
		}
		//Scroll to page buttom
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(1000);
		// Click on Save Button
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-save2"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-save2"))));
//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-save2"))).click();
		// Click Save in Save report popup
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-dialog-confirmed"))));
		Thread.sleep(5000);
		// Click on Open RV report in order to check 2 supporting file photos exist
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.OpenButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
		Thread.sleep(1000);
		// Verify 2 Supporting files photos present Offline
		for (int j = 0; j < 2; j++) {
			// Click on Supporting file details
			share2.scrollToElement(driver, wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-event-filecollapsible-" + j))));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-event-filecollapsible-" + j)))
					.click();
			// Wait for image
			share2.scrollToAPoint(driver, 700);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-event-file-img-" + j)));
			if (driver.findElement(By.id("pii-rv-event-file-img-" + j)).isDisplayed()) {
				System.out.println("Supporting file image " + j + "is displayed");

			}
		}
//////////////////////////////////////////////////////////////////////////////////////////			
		// Connect wifi, insert network name
		Runtime.getRuntime().exec("netsh wlan connect name=\"AMBO-5G\"");
		Thread.sleep(3000);
		// Catch Back online Green sticky
		try {
			// Closes server warning
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note"))).getText()
					.trim();
			System.out.println("Offline report saved in Offline mode sticky: " + s);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();
		} catch (org.openqa.selenium.TimeoutException e) {

		}
		Thread.sleep(7000);
		// Click on Saved activities
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavedActivitiesButton)));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavedActivitiesButton)));
//	wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavedActivitiesButton)).click();
		// Wait for loading message to disappear
		share2.loadingServer(driver);
		// Assert: Offline report display in Online Listing
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVNewlyCreatedFirstRecord)).getText();
		softly.assertThat(s).as("test data").contains("//a[contains(text(),'" + title + "')]");
		System.out.println(s);
///////////////////////////////////////////////////////////////////////////////////////////////////////////				
		// Click on first record to open the report (Back Online)
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVNewlyCreatedFirstRecord)).click();
		share2.loadingServer(driver);
		// Click on Open offline RV report
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.OpenButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
		Thread.sleep(1000);
		// Verify 2 Supporting files photos present Offline
		for (int j = 0; j < 2; j++) {
			/*
			// Click on Supporting file details
			share2.scrollToElement(driver, wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-event-filecollapsible-" + j))));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-event-filecollapsible-" + j)))
					.click();*/
			// Wait for image
			share2.scrollToAPoint(driver, 700);
			jse.executeScript("arguments[0].scrollIntoView(true);",wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-event-file-img-" + j))));
			if (driver.findElement(By.id("pii-rv-event-file-img-" + j)).isDisplayed()) {
				System.out.println("Supporting file image " + j + "is displayed");

			}
		}
		// Click on User icon
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		} catch (org.openqa.selenium.UnhandledAlertException t) {
			driver.switchTo().alert().dismiss();
		}
		// Click Logout
		login2.logout(driver);
		driver.manage().window().maximize();
	}

	public void afterTest() {
//		driver.quit();
		softly.assertAll();

	}

	  }
