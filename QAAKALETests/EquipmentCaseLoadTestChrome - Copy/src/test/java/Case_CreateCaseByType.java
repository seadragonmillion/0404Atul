import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
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

public class Case_CreateCaseByType {

	private WebDriver driver;
	private String username = "jenkinsvm";
	private String url = "https://kaleqa.error-free.com/";
	private String password = "S2FsZWplbmtpbnNAMTIz";

	private String usernamenonadmin = "jenkinsvmnonadmin";

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
	public By EquipmentDatabankOnlyLink = By.linkText("Equipment Data Bank (Instructor Only)");
	public By ErrorFreeBankTopLink = By.xpath(".//*[@id='links']/a[4]");
	public By EquipmentSearchCaseIdField = By.id("pii-efse-searchbyid-input");
	public By EquipmentSearchKeywordField = By.id("pii-efse-searchbykw-input");
	public By EngineeringFundamentalsLink = By.linkText("Engineering Fundamentals");
	public By ErrorFreeBankLinkHomePage = By.id("pii-main-menu-button-e");

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

		System.out.println("Case_create case by type and verify them display in correct module ");
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
		/*
		 * test steps (admin) create case for each type
		 * 
		 * (non-admin) verify case shows up in the correct module
		 * 
		 * (non-admin) verify cases that do not belong in module do not show
		 * 
		 * (admin) verify all cases show in instructor module
		 */

		// Login Admin User
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
			// Clicks on ErrorFree Bank
			wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorFreeBankLinkHomePage)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorFreeBankTopLink)).click();
		} catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorFreeBankTopLink)).click();
		}
		// Click Equipment Data Bank (Instructor Only)
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentDatabankOnlyLink)).click();
		// Enters case id
		for (int i = 1; i <= 7; i++) {
			jse.executeScript("arguments[0].click();", driver.findElement(EquipmentSearchCaseIdField));
			Thread.sleep(500);
			driver.findElement(EquipmentSearchCaseIdField).sendKeys("700" + i);
			jse.executeScript("arguments[0].click();", driver.findElement(By.id("pii-efse-searchbyid-btn")));
			Thread.sleep(1000);
			WebElement element = driver.findElement(By.id("pii-collapsible-equip-F700" + i));
			String caseText = element.getText();
			System.out.println("caseText:  " + caseText);
			softly.assertThat(caseText).as("test data").contains("700" + i);
			jse.executeScript("arguments[0].click();",
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchCaseIdField)));
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchCaseIdField)).clear();
		}
		// Logout Admin User
		Login login2 = new Login();
		login2.logout(driver);
		// Login Non Admin User
		obj.LoginUser(driver, usernamenonadmin, password);
		// Waits for the page to load
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// Switches to the iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		// Clicks on Error free bank
		try {
			// Clicks on ErrorFree Bank
			wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorFreeBankLinkHomePage)).click();
		} catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorFreeBankLinkHomePage)).click();
		}
		// Clicks on Engineering Fundamentals
		wait.until(ExpectedConditions.visibilityOfElementLocated(EngineeringFundamentalsLink)).click();
		// Enter keyword to search case
		jse.executeScript("arguments[0].click();", driver.findElement(EquipmentSearchKeywordField ));
		Thread.sleep(500);
		driver.findElement(EquipmentSearchKeywordField).sendKeys("monkey laughing");
		driver.findElement(EquipmentSearchKeywordField).sendKeys(Keys.ENTER);
		// Assert only Case 7005 display
		WebElement case7005 = driver.findElement(By.xpath(".//*[@id='pii-collapsible-equip-F7005']/h4/a"));
		String case7005Text = case7005.getText();
		System.out.println("caseText:  " + case7005Text);
		softly.assertThat(case7005Text).as("test data").contains("7005");
	}

	
	public void lookForCases(WebDriver driver, List<String> cases) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		for(int j=0;j<cases.size();j++)
		{
			//Look for case
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+cases.get(j))));
		}
	}
	
	public void afterTest() {
//		  driver.quit();
		softly.assertAll();

	}

}
