package seleniumTests;

import java.util.ArrayList;
import java.util.List;

import kaleTestSoftware.Login;
import kaleTestSoftware.RemoteVerification;
import kaleTestSoftware.beforeFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;



public class RV_Sanity {

	WebDriver driver;
	List<String> b = new ArrayList<String>();

	/*@ClassRule
    public static TestWatcher watcher = new TestWatcher() {
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
		login.LoginUser(driver, username, password);
		//Switches to the iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
	}

	@When("^he creates an RV report with username as \"([^\"]*)\" and admin nonadmin environment indicator equals (\\d+)$")
	public void he_creates_an_RV_report_with_username_as_and_admin_nonadmin_environment_indicator_equals(String username, int k) throws Exception {
		RemoteVerification rv = new RemoteVerification();
		b.addAll(rv.createReport(driver, username, k));
	}

	@When("^downloads RV report with username as \"([^\"]*)\" on browser \"([^\"]*)\"$")
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

	@When("^share RV report with username as \"([^\"]*)\" and password as \"([^\"]*)\" and admin nonadmin environment indicator equals (\\d+)$")
	public void share_RV_report_with_username_as_and_password_as_and_admin_nonadmin_environment_indicator_equals(String username, String password, int y) throws Exception {
		RemoteVerification rv = new RemoteVerification();
		rv.shareReport(driver, b.get(0), username, password, y);
	}

	@When("^mark critical RV report with username as \"([^\"]*)\" and password as \"([^\"]*)\" and admin nonadmin environment indicator equals (\\d+)$")
	public void mark_critical_RV_report_with_username_as_and_password_as_and_admin_nonadmin_environment_indicator_equals(String username, String password, int y) throws Exception {
		RemoteVerification rv = new RemoteVerification();
		rv.markCritical(driver, username, password, y);
	}

	@When("^delete RV report with admin nonadmin environment indicator equals (\\d+)$")
	public void delete_RV_report_with_admin_nonadmin_environment_indicator_equals(int y) throws Exception {
		RemoteVerification rv = new RemoteVerification();
		rv.deleteNewRecord(driver, b.get(1), y);
	}

	@When("^logout from KALE$")
	public void logout_from_KALE() throws Exception {
		Login login = new Login();
		login.logout(driver);
		driver.manage().window().maximize();
		driver.quit();
	}

}
