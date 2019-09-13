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
import kaleTestSoftware.CreateEquipmentCase2;
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
	@When("user gets failure mode link with admin nonadmin as {int}")
	public void user_gets_failure_mode_link(int y) throws Exception {

		CaseBrowse obj = new CaseBrowse();
		obj.getElecFailureModeLink(driver, y);
	}

	@When("verify all search options for {string} in {string}")
	public void verify_all_search_options_for_in(String caseType, String devProd) throws Exception {

		CaseBrowse obj = new CaseBrowse();
		EquipmentPDDandEF obj1 = new EquipmentPDDandEF ();
		if(caseType.contains("FM"))
		{
			if(devProd.contains("dev"))
				obj.verifySearchOptionsEquip(driver, obj.keywordElecDev, obj.caseElecDev);
			if(devProd.contains("prod"))
				obj.verifySearchOptionsEquip(driver, obj.keywordElecProd, obj.caseElecProd);
		}	
		if(caseType.contains("EF"))
		{
			if(devProd.contains("dev"))
				obj.verifySearchOptionsEquip(driver, obj1.keywordEFDev, obj1.caseEFDev);
			if(devProd.contains("prod"))
				obj.verifySearchOptionsEquip(driver, obj1.keywordEFProd, obj1.caseEFProd);
		}	
		if(caseType.contains("EQ"))
		{
			if(devProd.contains("dev"))
				obj.verifySearchOptionsEquip(driver, obj.keywordEquipDev, obj.caseEquipDev);
			if(devProd.contains("prod"))
				obj.verifySearchOptionsEquip(driver, obj.keywordEquipProd, obj.caseEquipProd);
		}	
		if(caseType.contains("MFM"))
		{
			if(devProd.contains("dev"))
				obj.verifySearchOptionsEquip(driver, obj.keywordMechDev, obj.caseMechDev);
			if(devProd.contains("prod"))
				obj.verifySearchOptionsEquip(driver, obj.keywordMechProd, obj.caseMechProd);
		}
		if(caseType.contains("PDD"))
		{
			if(devProd.contains("dev"))
				obj.verifySearchOptionsEquip(driver, obj1.keywordPDDDev, obj1.casePDDDev);
			if(devProd.contains("prod"))
				obj.verifySearchOptionsEquip(driver, obj1.keywordPDDProd, obj1.casePDDProd);
		}	
	}

	@When("checks with keyword with percentage for {string} in {string}")
	public void checks_with_keyword_with_percentage_for_in(String caseType, String devProd) throws Exception {

		CaseBrowse obj = new CaseBrowse();
		EquipmentPDDandEF obj1 = new EquipmentPDDandEF ();
		if(caseType.contains("FM"))
		{
			if(devProd.contains("dev"))
				obj.searchWithPercentEquip(driver, obj.keywordElecDevPercent, obj.caseElecDev);
		}
		if(caseType.contains("EF"))
		{
			if(devProd.contains("dev"))
				obj.searchWithPercentEquip(driver, obj1.keywordEFDevPercent, obj1.caseEFDev);
		}
		if(caseType.contains("EQ"))
		{
			if(devProd.contains("dev"))
				obj.searchWithPercentEquip(driver, obj.keywordEquipDevPercent, obj.caseEquipDev);
		}
		if(caseType.contains("MFM"))
		{
			if(devProd.contains("dev"))
				obj.searchWithPercentEquip(driver, obj.keywordMechDevPercent, obj.caseMechDev);
		}
		if(caseType.contains("PDD"))
		{
			if(devProd.contains("dev"))
				obj.searchWithPercentEquip(driver, obj1.keywordPDDDevPercent, obj1.casePDDDev);
		}
	}

	@When("checks with new keyword with period and slash for {string} in {string}")
	public void checks_with_new_keyword_with_period_and_slash_for_in(String caseType, String devProd) throws Exception {

		CaseBrowse obj = new CaseBrowse();
		EquipmentPDDandEF obj1 = new EquipmentPDDandEF ();
		if(caseType.contains("FM"))
		{
			if(devProd.contains("dev"))
				obj.searchWithSpclEquip(driver, obj.keywordElecDevSpcl, obj.caseElecDev);
		}
		if(caseType.contains("EF"))
		{
			if(devProd.contains("dev"))
				obj.searchWithSpclEquip(driver, obj1.keywordEFDevSpcl, obj1.caseEFDev);
		}
		if(caseType.contains("EQ"))
		{
			if(devProd.contains("dev"))
				obj.searchWithSpclEquip(driver, obj.keywordEquipDevSpcl, obj.caseEquipDev);
		}
		if(caseType.contains("MFM"))
		{
			if(devProd.contains("dev"))
				obj.searchWithSpclEquip(driver, obj.keywordMechDevSpcl, obj.caseMechDev);
		}
		if(caseType.contains("PDD"))
		{
			if(devProd.contains("dev"))
				obj.searchWithSpclEquip(driver, obj1.keywordPDDDevSpcl, obj1.casePDDDev);
		}
	}

	@When("keyword search for {string} in {string}")
	public void keyword_search_for_in(String caseType, String devProd) throws Exception {

		CaseBrowse obj = new CaseBrowse();
		EquipmentPDDandEF obj1 = new EquipmentPDDandEF ();
		if(caseType.contains("FM"))
		{
			if(devProd.contains("dev"))
				obj.browseTermEquip(driver, obj.keywordElecDev, obj.caseElecDev, obj.titleDev);
			if(devProd.contains("prod"))
				obj.browseTermEquip(driver, obj.keywordElecProd, obj.caseElecProd, obj.titleElecProd);
		}
		if(caseType.contains("EF"))
		{
			if(devProd.contains("dev"))
				obj.browseTermEquip(driver, obj1.keywordEFDev, obj1.caseEFDev, obj1.titleEFDev);
			if(devProd.contains("prod"))
				obj.browseTermEquip(driver, obj1.keywordEFProd, obj1.caseEFProd, obj1.titleEFProd);
		}
		if(caseType.contains("EQ"))
		{
			if(devProd.contains("dev"))
				obj.browseTermEquip(driver, obj.keywordEquipDev, obj.caseEquipDev, obj.titleDev);
			if(devProd.contains("prod"))
				obj.browseTermEquip(driver, obj.keywordEquipProd, obj.caseEquipProd, obj.titleEquipProd);
		}
		if(caseType.contains("MFM"))
		{
			if(devProd.contains("dev"))
				obj.browseTermEquip(driver, obj.keywordMechDev, obj.caseMechDev, obj.titleDev);
			if(devProd.contains("prod"))
				obj.browseTermEquip(driver, obj.keywordMechProd, obj.caseMechProd, obj.titleMechProd);
		}
		if(caseType.contains("PDD"))
		{
			if(devProd.contains("dev"))
				obj.browseTermEquip(driver, obj1.keywordPDDDev, obj1.casePDDDev, obj1.titlePDDDev);
			if(devProd.contains("prod"))
				obj.browseTermEquip(driver, obj1.keywordPDDProd, obj1.casePDDProd, obj1.titlePDDProd);
		}
	}
	
	@When("keyword search nonadmin user for {string} in {string}")
	public void keyword_search_nonadmin_user_for_in(String caseType, String devProd) throws Exception {

		CaseBrowse obj = new CaseBrowse();
		EquipmentPDDandEF obj1 = new EquipmentPDDandEF ();
		if(caseType.contains("FM"))
		{
			if(devProd.contains("dev"))
				obj.browseCaseNonAdminEquip(driver, obj.keywordElecDev, obj.caseElecDev, obj.titleDev);
			if(devProd.contains("prod"))
				obj.browseCaseNonAdminEquip(driver, obj.keywordElecProd, obj.caseElecProd, obj.titleElecProd);
		}
		if(caseType.contains("EF"))
		{
			if(devProd.contains("dev"))
				obj.browseCaseNonAdminEquip(driver, obj1.keywordEFDev, obj1.caseEFDev, obj1.titleEFDev);
			if(devProd.contains("prod"))
				obj.browseCaseNonAdminEquip(driver, obj1.keywordEFProd, obj1.caseEFProd, obj1.titleEFProd);
		}
		if(caseType.contains("EQ"))
		{
			if(devProd.contains("dev"))
				obj.browseCaseNonAdminEquip(driver, obj.keywordEquipDev, obj.caseEquipDev, obj.titleDev);
			if(devProd.contains("prod"))
				obj.browseCaseNonAdminEquip(driver, obj.keywordEquipProd, obj.caseEquipProd, obj.titleEquipProd);
		}
		if(caseType.contains("MFM"))
		{
			if(devProd.contains("dev"))
				obj.browseCaseNonAdminEquip(driver, obj.keywordMechDev, obj.caseMechDev, obj.titleDev);
			if(devProd.contains("prod"))
				obj.browseCaseNonAdminEquip(driver, obj.keywordMechProd, obj.caseMechProd, obj.titleMechProd);
		}
		if(caseType.contains("PDD"))
		{
			if(devProd.contains("dev"))
				obj.browseCaseNonAdminEquip(driver, obj1.keywordPDDDev, obj1.casePDDDev, obj1.titlePDDDev);
			if(devProd.contains("prod"))
				obj.browseCaseNonAdminEquip(driver, obj1.keywordPDDProd, obj1.casePDDProd, obj1.titlePDDProd);
		}
	}

	@When("case id search for {string} in {string}")
	public void case_id_search_for_in(String caseType, String devProd) throws Exception {

		CaseBrowse obj = new CaseBrowse();
		EquipmentPDDandEF obj1 = new EquipmentPDDandEF ();
		if(caseType.contains("FM"))
		{
			if(devProd.contains("dev"))
				obj.browseCaseIDEquip(driver, obj.caseElecDev, obj.titleDev);
			if(devProd.contains("prod"))
				obj.browseCaseIDEquip(driver, obj.caseElecProd, obj.titleElecProd);
		}
		if(caseType.contains("EF"))
		{
			if(devProd.contains("dev"))
				obj.browseCaseIDEquip(driver, obj1.caseEFDev, obj1.titleEFDev);
			if(devProd.contains("prod"))
				obj.browseCaseIDEquip(driver, obj1.caseEFProd, obj1.titleEFProd);
		}
		if(caseType.contains("EQ"))
		{
			if(devProd.contains("dev"))
				obj.browseCaseIDEquip(driver, obj.caseEquipDev, obj.titleDev);
			if(devProd.contains("prod"))
				obj.browseCaseIDEquip(driver, obj.caseEquipProd, obj.titleEquipProd);
		}
		if(caseType.contains("MFM"))
		{
			if(devProd.contains("dev"))
				obj.browseCaseIDEquip(driver, obj.caseMechDev, obj.titleDev);
			if(devProd.contains("prod"))
				obj.browseCaseIDEquip(driver, obj.caseMechProd, obj.titleMechProd);
		}
		if(caseType.contains("PDD"))
		{
			if(devProd.contains("dev"))
				obj.browseCaseIDEquip(driver, obj1.casePDDDev, obj1.titlePDDDev);
			if(devProd.contains("prod"))
				obj.browseCaseIDEquip(driver, obj1.casePDDProd, obj1.titlePDDProd);
		}
	}

	@When("select discipline and verify change in number of cases displayed")
	public void select_discipline_and_verify_change_in_number_of_cases_displayed() throws Exception {

		CaseBrowse obj = new CaseBrowse();
		obj.chooseDisciplineFailureModeSearch(driver);
	}
	
	@When("user gets engineering fundamentals link")
	public void user_gets_engineering_fundamentals_link() throws Exception {

		EquipmentPDDandEF obj1 = new EquipmentPDDandEF ();
		obj1.getEFLink(driver);
	}
	
	@When("user gets prevention of design deficiencies link")
	public void user_gets_prevention_of_design_deficiencies_link() throws Exception {

		EquipmentPDDandEF obj1 = new EquipmentPDDandEF ();
		obj1.getPDDLink(driver);
	}

	@When("search for case in equipment non pii by keyword for {string} in {string}")
	public void search_for_case_in_equipment_non_pii_by_keyword_for_in(String caseType, String devProd) throws Exception {

		EquipmentPDDandEF obj1 = new EquipmentPDDandEF ();
		if(caseType.contains("EF"))
		{
			if(devProd.contains("dev"))
				obj1.searchCaseInEquipSearchByKeyword(driver, obj1.keywordEFDev, obj1.caseEFDev);
			if(devProd.contains("prod"))
				obj1.searchCaseInEquipSearchByKeyword(driver, obj1.keywordEFProd, obj1.caseEFProd);
		}
		if(caseType.contains("PDD"))
		{
			if(devProd.contains("dev"))
				obj1.searchCaseInEquipSearchByKeyword(driver, obj1.keywordPDDDev, obj1.casePDDDev);
			if(devProd.contains("prod"))
				obj1.searchCaseInEquipSearchByKeyword(driver, obj1.keywordPDDProd, obj1.casePDDProd);
		}
	}

	@When("search for case in equipment non pii by case id for {string} in {string}")
	public void search_for_case_in_equipment_non_pii_by_case_id_for_in(String caseType, String devProd) throws Exception {

		EquipmentPDDandEF obj1 = new EquipmentPDDandEF ();
		if(caseType.contains("EF"))
		{
			if(devProd.contains("dev"))
				obj1.searchCaseInEquipSearchByCaseID(driver, obj1.caseEFDev);
			if(devProd.contains("prod"))
				obj1.searchCaseInEquipSearchByCaseID(driver, obj1.caseEFProd);
		}
		if(caseType.contains("PDD"))
		{
			if(devProd.contains("dev"))
				obj1.searchCaseInEquipSearchByCaseID(driver, obj1.casePDDDev);
			if(devProd.contains("prod"))
				obj1.searchCaseInEquipSearchByCaseID(driver, obj1.casePDDProd);
		}
	}

	@When("add new keyword to old case only in dev in {string}")
	public void add_new_keyword_to_old_case_only_in_dev_in(String caseType) throws Exception {

		CreateEquipmentCase2 obj = new CreateEquipmentCase2();
		EquipmentPDDandEF obj1 = new EquipmentPDDandEF ();
		CaseBrowse obj2 = new CaseBrowse();
		if(caseType.contains("EF"))
			obj.addNewKeywordToOldCase(driver, obj1.caseEFDev);
		if(caseType.contains("EQ"))
			obj.addNewKeywordToOldCase(driver, obj2.caseEquipDev);
		if(caseType.contains("MFM"))
			obj.addNewKeywordToOldCase(driver, obj2.caseMechDev);
		if(caseType.contains("PDD"))
			obj.addNewKeywordToOldCase(driver, obj1.casePDDDev);
	}
	
	@When("user gets equipment performance link with admin nonadmin as {int}")
	public void user_gets_equipment_performance_link_with_admin_nonadmin_as(Integer y) throws Exception {
		
		CaseBrowse obj = new CaseBrowse();
		obj.getEquipPerformanceLink(driver, y);
	}

	@When("search with keyword color oil")
	public void search_with_keyword_color_oil() throws Exception {
		
		CaseBrowse obj = new CaseBrowse();
		obj.searchColorCasesEquip(driver);
	}
	
	@When("user gets equipment databank link with admin nonadmin as {int}")
	public void user_gets_equipment_databank_link_with_admin_nonadmin_as(Integer y) throws Exception {

		CaseBrowse obj = new CaseBrowse();
		obj.getEquipPerformancePIILink(driver, y);
	}
	
	@When("user gets mechanical failure mode link with admin nonadmin as {int}")
	public void user_gets_mechanical_failure_mode_link_with_admin_nonadmin_as(Integer y) throws Exception {

		CaseBrowse obj = new CaseBrowse();
		obj.getMechFailureModeLink(driver, y);
	}

	@When("case search with filter")
	public void case_search_with_filter() throws Exception {

		CaseBrowse obj = new CaseBrowse();
		obj.caseSearchEquipmentDatabank(driver);
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
