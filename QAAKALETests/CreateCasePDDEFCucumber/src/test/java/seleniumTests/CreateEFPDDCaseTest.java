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
import kaleTestSoftware.EquipmentPDDandEF;
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

public class CreateEFPDDCaseTest {

	static WebDriver driver;
	List<String> casePDD = new ArrayList<String>();
	List<String> caseEF = new ArrayList<String>();

	/**
	 * @ClassRule public static TestRule watcher = new TestWatcher() {
	 * @Override protected void failed(Throwable throwable, Description description)
	 *           { File scrFile =
	 *           ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); try {
	 *           FileUtils.copyFile(scrFile, new
	 *           File("target/screenshots/"+"failshot.png")); } catch (IOException
	 *           exception) { exception.printStackTrace(); } }
	 * 
	 * @Override protected void finished(Description description) { driver.quit(); }
	 *           };
	 */

	@Given("^user is on KALE Home Page \"([^\"]*)\" with username as \"([^\"]*)\" and password as \"([^\"]*)\" on browser \"([^\"]*)\"$")
	public void user_is_on_KALE_Home_Page_with_username_as_and_password_as_on_browser(String url, String username,
			String password, String browser) throws Exception {
		// Launch chrome browser
		beforeFunctions bf = new beforeFunctions();
		Login login = new Login();
		if (browser.equals("chrome"))
			driver = bf.beforeChromeTest(driver, url);
		if (browser.equals("firefox"))
			driver = bf.beforeFirefoxTest(driver, url);
		if (browser.equals("ie10"))
			driver = bf.beforeIE10Test(driver, url);
		if (browser.equals("ie11"))
			driver = bf.beforeIE11Test(driver, url);
		int login1 = login.LoginUser(driver, username, password);
		// Switches to the iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		try {
			if (login1 == 1) {
				WebDriverWait wait2 = new WebDriverWait(driver, 20);
				wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();
			}
		} catch (NoSuchElementException e) {
			throw e;
		}
	}

	@When("she deletes previous cases for {string} in {string}")
	public void she_deletes_previous_cases_for_in(String caseType, String devAsiaUSIE11) throws Exception {

		CreateEquipmentCase obj1 = new CreateEquipmentCase();
		EquipmentPDDandEF obj = new EquipmentPDDandEF();
		if (caseType.contains("PDD")) {
			if (devAsiaUSIE11.contains("devAsia"))
				obj1.deletePreviousCase(driver, obj.titlePDD);
			if (devAsiaUSIE11.contains("devAsiaIE11"))
				obj1.deletePreviousCase(driver, obj.titlePDDie11);
			if (devAsiaUSIE11.contains("US"))
				obj1.deletePreviousCase(driver, obj.titlePDDUS);
			if (devAsiaUSIE11.contains("USIE11"))
				obj1.deletePreviousCase(driver, obj.titlePDDUSie11);
		} else {
			if (devAsiaUSIE11.contains("devAsia"))
				obj1.deletePreviousCase(driver, obj.titleEF);
			if (devAsiaUSIE11.contains("devAsiaIE11"))
				obj1.deletePreviousCase(driver, obj.titleEFie11);
			if (devAsiaUSIE11.contains("US"))
				obj1.deletePreviousCase(driver, obj.titleEFUS);
			if (devAsiaUSIE11.contains("USIE11"))
				obj1.deletePreviousCase(driver, obj.titleEFUSie11);
		}
		Thread.sleep(2000);
	}

	@When("create cases for {string} in {string}")
	public void create_cases_for_in(String caseType, String devAsiaUSIE11) throws Exception {

		EquipmentPDDandEF obj = new EquipmentPDDandEF();
		if (caseType.contains("PDD")) {
			if (devAsiaUSIE11.contains("devAsia"))
				casePDD.addAll(
						obj.createCase(driver, obj.keywordPDD, obj.key1PDD, obj.key2PDD, obj.key3PDD, obj.titlePDD));
			if (devAsiaUSIE11.contains("devAsiaIE11"))
				casePDD.addAll(obj.createCase(driver, obj.keywordPDDie11, obj.key1PDDie11, obj.key2PDDie11,
						obj.key3PDDie11, obj.titlePDDie11));
			if (devAsiaUSIE11.contains("US"))
				casePDD.addAll(obj.createCase(driver, obj.keywordPDDUS, obj.key1PDDUS, obj.key2PDDUS, obj.key3PDDUS,
						obj.titlePDDUS));
			if (devAsiaUSIE11.contains("USIE11"))
				casePDD.addAll(obj.createCase(driver, obj.keywordPDDUSie11, obj.key1PDDUSie11, obj.key2PDDUSie11,
						obj.key3PDDUSie11, obj.titlePDDUSie11));
			System.out.println("Cases for Design " + casePDD);
		} else {
			if (devAsiaUSIE11.contains("devAsia"))
				caseEF.addAll(obj.createCase(driver, obj.keywordEF, obj.key1EF, obj.key2EF, obj.key3EF, obj.titleEF));
			if (devAsiaUSIE11.contains("devAsiaIE11"))
				caseEF.addAll(obj.createCase(driver, obj.keywordEFie11, obj.key1EFie11, obj.key2EFie11, obj.key3EFie11,
						obj.titleEFie11));
			if (devAsiaUSIE11.contains("US"))
				caseEF.addAll(obj.createCase(driver, obj.keywordEFUS, obj.key1EFUS, obj.key2EFUS, obj.key3EFUS,
						obj.titleEFUS));
			if (devAsiaUSIE11.contains("USIE11"))
				caseEF.addAll(obj.createCase(driver, obj.keywordEFUSie11, obj.key1EFUSie11, obj.key2EFUSie11,
						obj.key3EFUSie11, obj.titleEFUSie11));
			System.out.println("Cases for Fundamentals " + caseEF);
		}
		Thread.sleep(2000);
	}

	@When("verify if names of case modules correct")
	public void verify_if_names_of_case_modules_correct() throws Exception {

		EquipmentPDDandEF obj = new EquipmentPDDandEF();
		obj.verifyCaseModuleNames(driver);
	}

	@When("go to equipment databank link")
	public void go_to_equipment_databank_link() throws Exception {

		EquipmentPDDandEF obj = new EquipmentPDDandEF();
		obj.getEquipPerformancePIILink(driver);
	}

	@When("browse for case for {string} in {string}")
	public void browse_for_case_for_in(String caseType, String devAsiaUSIE11) throws Exception {

		EquipmentPDDandEF obj = new EquipmentPDDandEF();
		if (caseType.contains("PDD")) {
			if (devAsiaUSIE11.contains("devAsia"))
				obj.browseCase(driver, obj.keywordPDD, casePDD.get(0), obj.titlePDD);
			if (devAsiaUSIE11.contains("devAsiaIE11"))
				obj.browseCase(driver, obj.keywordPDDie11, casePDD.get(0), obj.titlePDDie11);
			if (devAsiaUSIE11.contains("US"))
				obj.browseCase(driver, obj.keywordPDDUS, casePDD.get(0), obj.titlePDDUS);
			if (devAsiaUSIE11.contains("USIE11"))
				obj.browseCase(driver, obj.keywordPDDUSie11, casePDD.get(0), obj.titlePDDUSie11);
		} else {
			if (devAsiaUSIE11.contains("devAsia"))
				obj.browseCase(driver, obj.keywordEF, caseEF.get(0), obj.titleEF);
			if (devAsiaUSIE11.contains("devAsiaIE11"))
				obj.browseCase(driver, obj.keywordEFie11, caseEF.get(0), obj.titleEFie11);
			if (devAsiaUSIE11.contains("US"))
				obj.browseCase(driver, obj.keywordEFUS, caseEF.get(0), obj.titleEFUS);
			if (devAsiaUSIE11.contains("USIE11"))
				obj.browseCase(driver, obj.keywordEFUSie11, caseEF.get(0), obj.titleEFUSie11);
		}
	}

	@When("go to prevention of design deficiencies link")
	public void go_to_prevention_of_design_deficiencies_link() throws Exception {

		EquipmentPDDandEF obj = new EquipmentPDDandEF();
		obj.getPDDLink(driver);
	}

	@When("go to engineering fundamentals link")
	public void go_to_engineering_fundamentals_link() throws Exception {

		EquipmentPDDandEF obj = new EquipmentPDDandEF();
		obj.getEFLink(driver);
	}

	@When("search for case in equipment performance by keyword for {string} in {string}")
	public void search_for_case_in_equipment_performance_by_keyword_for_in(String caseType, String devAsiaUSIE11)
			throws Exception {

		EquipmentPDDandEF obj = new EquipmentPDDandEF();
		if (caseType.contains("PDD")) {
			if (devAsiaUSIE11.contains("devAsia"))
				obj.searchCaseInEquipSearchByKeyword(driver, obj.keywordPDD, casePDD.get(0));
			if (devAsiaUSIE11.contains("devAsiaIE11"))
				obj.searchCaseInEquipSearchByKeyword(driver, obj.keywordPDDie11, casePDD.get(0));
			if (devAsiaUSIE11.contains("US"))
				obj.searchCaseInEquipSearchByKeyword(driver, obj.keywordPDDUS, casePDD.get(0));
			if (devAsiaUSIE11.contains("USIE11"))
				obj.searchCaseInEquipSearchByKeyword(driver, obj.keywordPDDUSie11, casePDD.get(0));
		} else {
			if (devAsiaUSIE11.contains("devAsia"))
				obj.searchCaseInEquipSearchByKeyword(driver, obj.keywordEF, caseEF.get(0));
			if (devAsiaUSIE11.contains("devAsiaIE11"))
				obj.searchCaseInEquipSearchByKeyword(driver, obj.keywordEFie11, caseEF.get(0));
			if (devAsiaUSIE11.contains("US"))
				obj.searchCaseInEquipSearchByKeyword(driver, obj.keywordEFUS, caseEF.get(0));
			if (devAsiaUSIE11.contains("USIE11"))
				obj.searchCaseInEquipSearchByKeyword(driver, obj.keywordEFUSie11, caseEF.get(0));
		}
	}

	@When("search for case in equipment performance by case id for {string}")
	public void search_for_case_in_equipment_performance_by_case_id_for_in(String caseType) throws Exception {

		EquipmentPDDandEF obj = new EquipmentPDDandEF();
		if (caseType.contains("PDD"))
			obj.searchCaseInEquipSearchByCaseID(driver, casePDD.get(0));
		else
			obj.searchCaseInEquipSearchByCaseID(driver, caseEF.get(0));
	}

	@When("search for PDD and EF case in failure modes in {string}")
	public void search_for_PDD_and_EF_case_in_failure_modes_in(String devAsiaUSIE11) throws Exception {

		EquipmentPDDandEF obj = new EquipmentPDDandEF();
		if (devAsiaUSIE11.contains("devAsia"))
			obj.searchCaseInFailureModes(driver, caseEF.get(0), casePDD.get(0), obj.keywordEF, obj.keywordPDD);
		if (devAsiaUSIE11.contains("devAsiaIE11"))
			obj.searchCaseInFailureModes(driver, caseEF.get(0), casePDD.get(0), obj.keywordEFie11, obj.keywordPDDie11);
		if (devAsiaUSIE11.contains("US"))
			obj.searchCaseInFailureModes(driver, caseEF.get(0), casePDD.get(0), obj.keywordEFUS, obj.keywordPDDUS);
		if (devAsiaUSIE11.contains("USIE11"))
			obj.searchCaseInFailureModes(driver, caseEF.get(0), casePDD.get(0), obj.keywordEFUSie11,
					obj.keywordPDDUSie11);
	}

	@When("search for PDD and EF case in each other in {string}")
	public void search_for_PDD_and_EF_case_in_each_other_in(String devAsiaUSIE11) throws Exception {

		EquipmentPDDandEF obj = new EquipmentPDDandEF();
		if (devAsiaUSIE11.contains("devAsia"))
			obj.searchCasesInPDDAndEFModules(driver, caseEF.get(0), casePDD.get(0), obj.keywordEF, obj.keywordPDD);
		if (devAsiaUSIE11.contains("devAsiaIE11"))
			obj.searchCasesInPDDAndEFModules(driver, caseEF.get(0), casePDD.get(0), obj.keywordEFie11,
					obj.keywordPDDie11);
		if (devAsiaUSIE11.contains("US"))
			obj.searchCasesInPDDAndEFModules(driver, caseEF.get(0), casePDD.get(0), obj.keywordEFUS, obj.keywordPDDUS);
		if (devAsiaUSIE11.contains("USIE11"))
			obj.searchCasesInPDDAndEFModules(driver, caseEF.get(0), casePDD.get(0), obj.keywordEFUSie11,
					obj.keywordPDDUSie11);
	}

	@When("check the keyword search for {string} in {string} for pii indicator {int}")
	public void check_the_keyword_search_for_in_for_pii_indicator(String caseType, String devAsiaUSIE11,
			Integer piiNonpii) throws Exception {

		CreateEquipmentCase obj1 = new CreateEquipmentCase();
		EquipmentPDDandEF obj = new EquipmentPDDandEF();
		if (caseType.contains("PDD")) {
			if (devAsiaUSIE11.contains("devAsia"))
				obj1.checkkeyword(driver, casePDD, obj.keywordPDD, obj.key1PDD, obj.key2PDD, obj.key3PDD, piiNonpii,
						obj.titlePDD);
			if (devAsiaUSIE11.contains("devAsiaIE11"))
				obj1.checkkeyword(driver, casePDD, obj.keywordPDDie11, obj.key1PDDie11, obj.key2PDDie11,
						obj.key3PDDie11, piiNonpii, obj.titlePDDie11);
			if (devAsiaUSIE11.contains("US"))
				obj1.checkkeyword(driver, casePDD, obj.keywordPDDUS, obj.key1PDDUS, obj.key2PDDUS, obj.key3PDDUS,
						piiNonpii, obj.titlePDDUS);
			if (devAsiaUSIE11.contains("USIE11"))
				obj1.checkkeyword(driver, casePDD, obj.keywordPDDUSie11, obj.key1PDDUSie11, obj.key2PDDUSie11,
						obj.key3PDDUSie11, piiNonpii, obj.titlePDDUSie11);
		} else {
			if (devAsiaUSIE11.contains("devAsia"))
				obj1.checkkeyword(driver, caseEF, obj.keywordEF, obj.key1EF, obj.key2EF, obj.key3EF, piiNonpii,
						obj.titleEF);
			if (devAsiaUSIE11.contains("devAsiaIE11"))
				obj1.checkkeyword(driver, caseEF, obj.keywordEFie11, obj.key1EF, obj.key2EF, obj.key3EF, piiNonpii,
						obj.titleEFie11);
			if (devAsiaUSIE11.contains("US"))
				obj1.checkkeyword(driver, caseEF, obj.keywordEFUS, obj.key1EFUS, obj.key2EFUS, obj.key3EFUS, piiNonpii,
						obj.titleEFUS);
			if (devAsiaUSIE11.contains("USIE11"))
				obj1.checkkeyword(driver, caseEF, obj.keywordEFUSie11, obj.key1EF, obj.key2EF, obj.key3EF, piiNonpii,
						obj.titleEFUSie11);
		}
		Thread.sleep(2000);
	}

	@When("delete cases for {string}")
	public void delete_cases_for_in(String caseType) throws Exception {

		CreateEquipmentCase obj1 = new CreateEquipmentCase();
		if (caseType.contains("PDD"))
			obj1.deleteCase(driver, casePDD);
		else
			obj1.deleteCase(driver, caseEF);
		Thread.sleep(2000);
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
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(scrFile, new File("target/screenshots/" + "failshot.png"));
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
//		driver.quit();
		EquipmentPDDandEF obj = new EquipmentPDDandEF();
		obj.softAssert();
	}

}
