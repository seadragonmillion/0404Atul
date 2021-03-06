package seleniumTests;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import kaleTestSoftware.HiRCAChinese;
import kaleTestSoftware.Login;
import kaleTestSoftware.RemoteVerificationChinese;
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



public class RV_Chinese {

	static WebDriver driver;
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

	@When("she changes language to chinese")
	public void she_changes_language_to_chinese() throws Exception {
		HiRCAChinese hc = new HiRCAChinese();
		//Change language to chinese
		hc.changeToChinese(driver);
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
	@When("verify chinese translation for RV report with username as {string} and password as {string} and verifier indicator equals {int}")
	public void verify_chinese_translation_for_RV_report_with_username_as_and_password_as_and_verifier_indicator_equals(String username, String password, int y) throws Exception {
		RemoteVerificationChinese rvc = new RemoteVerificationChinese();
		rvc.verifyChineseRV(driver, y, username, password);
	}

	@When("she changes language to english")
	public void she_changes_language_to_english() throws Exception {
		HiRCAChinese hc = new HiRCAChinese();
		//Change language to chinese
		hc.changeToEnglish(driver);
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
		RemoteVerificationChinese rvc = new RemoteVerificationChinese();
		rvc.softAssert();
	}

}
