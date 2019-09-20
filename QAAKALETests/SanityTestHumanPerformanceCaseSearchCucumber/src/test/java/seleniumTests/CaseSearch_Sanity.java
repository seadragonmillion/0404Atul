package seleniumTests;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import kaleTestSoftware.CaseBrowse;
import kaleTestSoftware.Login;
import kaleTestSoftware.beforeFunctions;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CaseSearch_Sanity {

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

	/*Verify order or modules
	 * admin = 0
	 * nonadmin = 1
	 */
	@When("user gets human performance link with admin nonadmin as {int}")
	public void user_gets_human_performance_link_with_admin_nonadmin_as(Integer y) throws Exception {

		CaseBrowse obj1 = new CaseBrowse();
		obj1.getHumanPerformanceLink(driver, y);
	}

	@When("verify all search options in {string}")
	public void verify_all_search_options_in(String devProd) throws Exception {

		CaseBrowse obj1 = new CaseBrowse();
		if(devProd.contains("dev"))
			obj1.verifySearchOptionsHuman(driver, obj1.keywordHumanDev, obj1.caseHumanDev);
		if(devProd.contains("prod"))
			obj1.verifySearchOptionsHuman(driver, obj1.keywordHumanProd, obj1.caseHumanProd);
	}

	@When("checks with keyword with percentage in {string}")
	public void checks_with_keyword_with_percentage_in(String devProd) throws Exception {

		CaseBrowse obj1 = new CaseBrowse();
		if(devProd.contains("dev"))
			obj1.searchWithPercentHuman(driver, obj1.keywordHumanDevPercent, obj1.caseHumanDev);	
		if(devProd.contains("prod"))
			obj1.searchWithPercentHuman(driver, obj1.keywordHumanProdPercent, obj1.caseHumanProdPercent);	
	}

	@When("checks with new keyword with period and slash  in {string}")
	public void checks_with_new_keyword_with_period_and_slash_in(String devProd) throws Exception {

		CaseBrowse obj1 = new CaseBrowse();
		obj1.searchWithSpclHuman(driver, obj1.keywordHumanDevSpcl, obj1.caseHumanDev);
	}

	@When("keyword search in {string}")
	public void keyword_search_in(String devProd) throws Exception {

		CaseBrowse obj1 = new CaseBrowse();
		if(devProd.contains("dev"))
			obj1.browseTermHuman(driver, obj1.keywordHumanDev, obj1.caseHumanDev, obj1.titleDev);
		if(devProd.contains("prod"))
			obj1.browseTermHuman(driver, obj1.keywordHumanProd, obj1.caseHumanProd, obj1.titleHumanProd);
	}

	@When("case id search in {string}")
	public void case_id_search_in(String devProd) throws Exception {

		CaseBrowse obj1 = new CaseBrowse();
		if(devProd.contains("dev"))
			obj1.browseCaseIDHuman(driver, obj1.caseHumanDev, obj1.titleDev);
		if(devProd.contains("prod"))
			obj1.browseCaseIDHuman(driver, obj1.caseHumanProd, obj1.titleHumanProd);
	}

	@When("search with keyword color oil")
	public void search_with_keyword_color_oil() throws Exception {

		CaseBrowse obj1 = new CaseBrowse();
		obj1.searchColorCasesHuman(driver);
	}


	@When("logout from KALE")
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
		CaseBrowse obj = new CaseBrowse();
		obj.softAssert();
	}

}
