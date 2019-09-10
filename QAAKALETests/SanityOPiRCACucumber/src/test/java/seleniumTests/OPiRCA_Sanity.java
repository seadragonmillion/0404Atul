package seleniumTests;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import kaleTestSoftware.Login;
import kaleTestSoftware.OPiRCA;
import kaleTestSoftware.beforeFunctions;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;



public class OPiRCA_Sanity {

	static WebDriver driver;
	List<String> b = new ArrayList<String>();

	/**	@ClassRule
	public static TestRule watcher = new TestWatcher() {
		@Override
		protected void failed(Throwable throwable, Description description) {
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(scrFile,
						new File("target/screenshots/"+"failshot.png"));
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}

		@Override
		protected void finished(Description description) {
			driver.quit();
		}
	};*/

	@Given("^user is on KALE Home Page \"([^\"]*)\" with username as \"([^\"]*)\" and password as \"([^\"]*)\" on browser \"([^\"]*)\"$")
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

	@When("^she creates an OPiRCA report with username as \"([^\"]*)\"$")
	public void she_creates_an_OPiRCA_report_with_username_as(String username) throws Exception {

		OPiRCA opirca = new OPiRCA();
		b.add(opirca.reportCreate(driver,username));
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
	@When("^share OPiRCA report with username as \"([^\"]*)\" and password as \"([^\"]*)\" and admin nonadmin environment indicator equals (\\d+)$")
	public void share_OPiRCA_report_with_username_as_and_password_as_and_admin_nonadmin_environment_indicator_equals(String username, String password, int y) throws Exception {

		OPiRCA opirca = new OPiRCA();
		opirca.shareReport(driver, username, password, y);
	}

	@When("^mark critical OPiRCA report with username as \"([^\"]*)\" and password as \"([^\"]*)\" and admin nonadmin environment indicator equals (\\d+)$")
	public void mark_critical_OPiRCA_report_with_username_as_and_password_as_and_admin_nonadmin_environment_indicator_equals(String username, String password, int y) throws Exception {

		OPiRCA opirca = new OPiRCA();
		opirca.markCritical(driver, username, password, y);
	}

	@When("^delete OPiRCA report with admin nonadmin environment indicator equals (\\d+)$")
	public void delete_OPiRCA_report_with_admin_nonadmin_environment_indicator_equals(int y) throws Exception {

		OPiRCA opirca = new OPiRCA();
		opirca.deleteNewRecord(driver, b.get(0), y);
	}

	@When("^logout from KALE$")
	public void logout_from_KALE() throws Exception {
		Login login = new Login();
		login.logout(driver);
		driver.manage().window().maximize();
	}


	@After
	public void tearDown(Scenario scenario) throws Exception {
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
		OPiRCA opirca = new OPiRCA();
		opirca.softAssert();
	}

}
