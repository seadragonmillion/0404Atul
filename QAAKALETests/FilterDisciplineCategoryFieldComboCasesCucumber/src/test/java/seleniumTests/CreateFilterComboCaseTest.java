package seleniumTests;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import kaleTestSoftware.CreateEquipmentCase;
import kaleTestSoftware.CreateEquipmentCase3;
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



public class CreateFilterComboCaseTest {

	static WebDriver driver;
	List<String> casePDD = new ArrayList<String>();
	List<String> caseEF = new ArrayList<String>();

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

	@When("she deletes previous cases for combo filters discipline field category in {string}")
	public void she_deletes_previous_cases_for_combo_filters_discipline_field_category_in(String devAsiaUSIE11) throws Exception {

		CreateEquipmentCase obj1 = new CreateEquipmentCase();
		CreateEquipmentCase3 obj3 = new CreateEquipmentCase3 ();
		if(devAsiaUSIE11.contains("devAsia"))
			obj1.deletePreviousCase(driver, obj3.titleCombo);
		if(devAsiaUSIE11.contains("devAsiaIE11"))
			obj1.deletePreviousCase(driver, obj3.titleComboie11);
		if(devAsiaUSIE11.contains("US"))
			obj1.deletePreviousCase(driver, obj3.titleComboUS);
		if(devAsiaUSIE11.contains("USIE11"))
			obj1.deletePreviousCase(driver, obj3.titleComboUSie11);
	}

	@When("create cases for combo filters discipline field category in {string}")
	public void create_cases_for_combo_filters_discipline_field_category_in(String devAsiaUSIE11) throws Exception {

		CreateEquipmentCase obj1 = new CreateEquipmentCase();
		CreateEquipmentCase3 obj3 = new CreateEquipmentCase3 ();
		if(devAsiaUSIE11.contains("devAsia"))
			obj1.createCaseWithDifferentDisciplineField(driver, obj3.titleCombo, obj3.keywordCombo);
		if(devAsiaUSIE11.contains("devAsiaIE11"))
			obj1.createCaseWithDifferentDisciplineField(driver, obj3.titleComboie11, obj3.keywordComboie11);
		if(devAsiaUSIE11.contains("US"))
			obj1.createCaseWithDifferentDisciplineField(driver, obj3.titleComboUS, obj3.keywordComboUS);
		if(devAsiaUSIE11.contains("USIE11"))
			obj1.createCaseWithDifferentDisciplineField(driver, obj3.titleComboUSie11, obj3.keywordComboUSie11);
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
		CreateEquipmentCase obj = new CreateEquipmentCase();
		obj.softAssert();
	}

}
