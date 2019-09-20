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
import kaleTestSoftware.CreateHumanCase;
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



public class CreateHumanCaseTest {

	static WebDriver driver;
	List<String> caseID = new ArrayList<String>();
	int m;

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

	@When("she deletes previous cases {string}")
	public void she_deletes_previous_cases(String devAsiaUSIE11) throws Exception {

		CreateHumanCase obj1 = new CreateHumanCase();
		if(devAsiaUSIE11.contains("devAsia"))
			m = obj1.deletePreviousCase(driver, obj1.title);
		if(devAsiaUSIE11.contains("devAsiaIE11"))
			m = obj1.deletePreviousCase(driver, obj1.titleie11);
		if(devAsiaUSIE11.contains("US"))
			m = obj1.deletePreviousCase(driver, obj1.titleUS);
		if(devAsiaUSIE11.contains("USIE11"))
			m = obj1.deletePreviousCase(driver, obj1.titleUSie11);
	}

	@When("create human cases in {string}")
	public void create_human_cases_in(String devAsiaUSIE11) throws Exception {

		CreateHumanCase obj1 = new CreateHumanCase();		
		if(devAsiaUSIE11.contains("devAsia"))
			caseID.addAll(obj1.createCase(driver, m, obj1.title, obj1.keyword_same, obj1.key1, obj1.key2, obj1.key3));
		if(devAsiaUSIE11.contains("devAsiaIE11"))
			caseID.addAll(obj1.createCase(driver, m, obj1.titleie11, obj1.keyword_sameie11, obj1.key1ie11, obj1.key2ie11, obj1.key3ie11));
		if(devAsiaUSIE11.contains("US"))
			caseID.addAll(obj1.createCase(driver, m, obj1.titleUS, obj1.keyword_sameUS, obj1.key1US, obj1.key2US, obj1.key3US));
		if(devAsiaUSIE11.contains("USIE11"))
			caseID.addAll(obj1.createCase(driver, m, obj1.titleUSie11, obj1.keyword_sameUSie11, obj1.key1USie11, obj1.key2USie11, obj1.key3USie11));
	}

	@When("browse through human case in {string}")
	public void browse_through_human_case_in(String devAsiaUSIE11) throws Exception {

		CreateHumanCase obj1 = new CreateHumanCase();
		if(devAsiaUSIE11.contains("devAsia"))
			obj1.compareSlide(driver, caseID, obj1.title);
		if(devAsiaUSIE11.contains("devAsiaIE11"))
			obj1.compareSlide(driver, caseID, obj1.titleie11);
		if(devAsiaUSIE11.contains("US"))
			obj1.compareSlide(driver, caseID, obj1.titleUS);
		if(devAsiaUSIE11.contains("USIE11"))
			obj1.compareSlide(driver, caseID, obj1.titleUSie11);
	}

	@When("check the keyword search in {string}")
	public void check_the_keyword_search_in(String devAsiaUSIE11) throws Exception {

		CreateHumanCase obj1 = new CreateHumanCase();	
		if(devAsiaUSIE11.contains("devAsia"))
			obj1.checkkeyword(driver, caseID, obj1.keyword_same, obj1.key1, obj1.key2, obj1.key3, obj1.title);
		if(devAsiaUSIE11.contains("devAsiaIE11"))
			obj1.checkkeyword(driver, caseID, obj1.keyword_sameie11, obj1.key1ie11, obj1.key2ie11, obj1.key3ie11, obj1.titleie11);
		if(devAsiaUSIE11.contains("US"))
			obj1.checkkeyword(driver, caseID, obj1.keyword_sameUS, obj1.key1US, obj1.key2US, obj1.key3US, obj1.titleUS);
		if(devAsiaUSIE11.contains("USIE11"))
			obj1.checkkeyword(driver, caseID, obj1.keyword_sameUSie11, obj1.key1USie11, obj1.key2USie11, obj1.key3USie11, obj1.titleUSie11);
	}

	@When("search with keyword with all special characters")
	public void search_with_keyword_with_all_special_characters() throws Exception {

		CaseBrowse obj = new CaseBrowse();
		obj.searchWithKeyKeywordWithAllSpecialCharacters(driver,caseID.get(0));
	}

	@When("search with keyword with special character in middle")
	public void search_with_keyword_with_special_character_in_middle() throws Exception {

		CaseBrowse obj = new CaseBrowse();
		CreateHumanCase obj1 = new CreateHumanCase();
		obj.searchWithKeywordKALE1964(driver,obj1.softly);
	}

	@When("change keyword and search for it in {string}")
	public void change_keyword_and_search_for_it_in(String devAsiaUSIE11) throws Exception {

		CreateHumanCase obj1 = new CreateHumanCase();
		if(devAsiaUSIE11.contains("devAsia"))
			obj1.changeKeywordKALE1969(driver,caseID,obj1.keyword_same);
		if(devAsiaUSIE11.contains("devAsiaIE11"))
			obj1.changeKeywordKALE1969(driver,caseID,obj1.keyword_sameie11);
		if(devAsiaUSIE11.contains("US"))
			obj1.changeKeywordKALE1969(driver,caseID,obj1.keyword_sameUS);
		if(devAsiaUSIE11.contains("USIE11"))
			obj1.changeKeywordKALE1969(driver,caseID,obj1.keyword_sameUSie11);
	}

	@When("verify youtube link work in case in {string}")
	public void verify_youtube_link_work_in_case_in(String devAsiaUSIE11) throws Exception {

		CreateHumanCase obj1 = new CreateHumanCase();
		if(devAsiaUSIE11.contains("devAsia"))
			obj1.searchCaseWithLinks(driver, obj1.keyword_same, caseID);
		if(devAsiaUSIE11.contains("devAsiaIE11"))
			obj1.searchCaseWithLinks(driver, obj1.keyword_sameie11, caseID);
		if(devAsiaUSIE11.contains("US"))
			obj1.searchCaseWithLinks(driver, obj1.keyword_sameUS, caseID);
		if(devAsiaUSIE11.contains("USIE11"))
			obj1.searchCaseWithLinks(driver, obj1.keyword_sameUSie11, caseID);
	}


	@When("verify cases with and without links in {string}")
	public void verify_cases_with_and_without_links_in(String devAsiaUSIE11) throws Exception {

		CreateHumanCase obj1 = new CreateHumanCase();
		if(devAsiaUSIE11.contains("devAsia"))
			obj1.viewCaseInAdmin(driver, caseID, obj1.keyword_same);
		if(devAsiaUSIE11.contains("devAsiaIE11"))
			obj1.viewCaseInAdmin(driver, caseID, obj1.keyword_sameie11);
		if(devAsiaUSIE11.contains("US"))
			obj1.viewCaseInAdmin(driver, caseID, obj1.keyword_sameUS);
		if(devAsiaUSIE11.contains("USIE11"))
			obj1.viewCaseInAdmin(driver, caseID, obj1.keyword_sameUSie11);
	}

	@When("edit links")
	public void edit_links() throws Exception {

		CreateHumanCase obj1 = new CreateHumanCase();
		obj1.editLinks(driver, caseID);
	}

	@When("delete links")
	public void delete_links() throws Exception {

		CreateHumanCase obj1 = new CreateHumanCase();
		obj1.deleteLinks(driver, caseID);
	}

	@When("delete cases")
	public void delete_cases() throws Exception {

		CreateHumanCase obj1 = new CreateHumanCase();
		obj1.deleteCase(driver, caseID);
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
		CreateHumanCase obj = new CreateHumanCase();
		obj.softAssert();
	}

}
