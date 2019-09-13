package seleniumTests;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import kaleTestSoftware.Login;
import kaleTestSoftware.RemoteVerification;
import kaleTestSoftware.beforeFunctions;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;



public class RV_Sanity {

	WebDriver driver;
	List<String> b = new ArrayList<String>();

	@Given("user is on KALE Home Page {string} with username as {string} and password as {string} on browser {string}")
	public void user_is_on_KALE_Home_Page_with_username_as_and_password_as_on_browser(String url, String username, String password, String browser) throws Exception {
		//Launch chrome browser
		beforeFunctions bf = new beforeFunctions();
		Login login = new Login();
		if(browser.equals("chrome"))
			driver = bf.beforeChromeTest(driver, url);
		if(browser.equals("firefox"))
			driver = bf.beforeFirefoxTest(driver, url);
		if(browser.equals("ie10"))
			driver = bf.beforeIE10Test(driver, url);
		if(browser.equals("ie11"))
			driver = bf.beforeIE11Test(driver, url);
		int login1 = login.LoginUser(driver, username, password);
		//Switches to the iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		try{
			if (login1==1)
			{
				WebDriverWait wait2 = new WebDriverWait(driver,20);
				wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();
			}
		}catch (NoSuchElementException e){
			throw e;
		}
	}
	  /*
	 * 1=admin dev
	 * 2= nonadmin dev
	 * 3= admin ie11 dev
	 * 4= nonadmin ie11 dev
	 * ASIA
	 * 5= admin asia
	 * 6= nonadmin asia
	 * 7= admin ie11 asia
	 * 8= nonadmin ie11 asia
	 * US
	 * 9=admin us
	 * 10=non admin us
	 * 11=admin ie11 us
	 * 12=non admin ie11 us
	   */
	@When("he creates an RV report with username as {string} and admin nonadmin environment indicator equals {int}")
	public void he_creates_an_RV_report_with_username_as_and_admin_nonadmin_environment_indicator_equals(String username, int k) throws Exception {
		RemoteVerification rv = new RemoteVerification();
		b.addAll(rv.createReport(driver, username, k));
	}

	@When("downloads RV report with username as {string} on browser {string}")
	public void downloads_RV_report_with_username_as_on_browser(String username, String browser) throws Exception {
		RemoteVerification rv = new RemoteVerification();
		if(browser.equals("chrome"))
			rv.downloadRecordChrome(driver, b.get(0), username);
		if(browser.equals("firefox"))
			rv.downloadRecordFirefox(driver, b.get(0), username);
		if(browser.equals("ie10"))
			rv.downloadRecordIE(driver, b.get(0), username);
		if(browser.equals("ie11"))
			rv.downloadRecordIE11(driver, b.get(0), username);		
	}
	
	  /* Dev/Asia
	 * 0=admin
	 * 1=non admin
	 * 2= admin ie11
	 * 3= non admin ie11
	 * US
	 * 4=admin
	 * 5=non admin
	 * 6=admin ie11
	 * 7=non admin ie11
	 */
	@When("share RV report with username as {string} and password as {string} and admin nonadmin environment indicator equals {int}")
	public void share_RV_report_with_username_as_and_password_as_and_admin_nonadmin_environment_indicator_equals(String username, String password, int y) throws Exception {
		RemoteVerification rv = new RemoteVerification();
		rv.shareReport(driver, b.get(0), username, password, y);
	}

	@When("mark critical RV report with username as {string} and password as {string} and admin nonadmin environment indicator equals {int}")
	public void mark_critical_RV_report_with_username_as_and_password_as_and_admin_nonadmin_environment_indicator_equals(String username, String password, int y) throws Exception {
		RemoteVerification rv = new RemoteVerification();
		rv.markCritical(driver, username, password, y);
	}

	@When("delete RV report with admin nonadmin environment indicator equals {int}")
	public void delete_RV_report_with_admin_nonadmin_environment_indicator_equals(int y) throws Exception {
		RemoteVerification rv = new RemoteVerification();
		rv.deleteNewRecord(driver, b.get(1), y);
	}

	@When("logout from KALE")
	public void logout_from_KALE() throws Exception {
		Login login = new Login();
		login.logout(driver);
		driver.manage().window().maximize();
	}

	@After
	public void tearDown(Scenario scenario)  throws Exception {
		if (scenario.isFailed()) {
			// Take a screenshot...
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png"); // ... and embed it in the report.
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(scrFile,
						new File("target/screenshots/"+"failshot.png"));
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
		driver.quit();
		RemoteVerification rv = new RemoteVerification();
		rv.softAssert();
	}

}
