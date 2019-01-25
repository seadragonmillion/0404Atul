import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CreateEquipmentCase {

	SoftAssertions softly = new SoftAssertions();
	String titleCombo = "QAA Type Discipline Field Filters Combo Test";
	String titleComboUS = "QAA US Type Discipline Field Filters Combo Test";
	String titleComboie11 = "QAA IE11 Type Disciplineie11 Fieldie11 Filters Combo Test";
	String titleComboUSie11 = "QAA US IE11 Type Disciplineie11 Fieldie11 Filters Combo Test";
	String keywordCombo = "QAADiscFieldCombo";
	String keywordComboUS = "QAAUSDiscFieldCombo";
	String keywordComboie11 = "QAAie11DiscFieldCombo";
	String keywordComboUSie11 = "QAAUSie11DiscFieldCombo";
	String noVideoLink = "http://www.murdoch.edu.au/School-of-Engineering-and-Information-Technology/";
	String noVideoLinkTitle1 = "Apple \"pie\"";
	String noVideoLinkTitle2 = "Banana";
	String noVideoLinkTitle3 = "Coconut";
	String noVideoLinkTitle4 = "Dance";
	String noVideoLinkTitle5 = "Elephant";
	String noVideoLinkTitle6 = "Fruit";
	String noVideoLinkTitle7 = "Guava";
	String noVideoLinkTitle8 = "Honey";
	String noVideoLinkTitle9 = "Ink";
	String noVideoLinkTitle10 = "Jamaica";
	String videoLink = "https://www.youtube.com/watch?v=KQ9Za0oLPPM";
	String videoLinkTitle1 = "Tiger";
	String videoLinkTitle2 = "Whale";
	String videoLinkTitle3 = "Zebra";
	String keyword_same_eq="QAAfiveeq";
	String key1_eq="QAAzebraeq";
	String key2_eq="QAAcameleq";
	String key3_eq="QAAgiraffeeq";
	String keyword_same_ee="QAAfiveee";
	String key1_ee="QAAzebraee";
	String key2_ee="QAAcamelee";
	String key3_ee="QAAgiraffeee";
	String keyword_same_me="QAAfiveme";
	String key1_me="QAAzebrame";
	String key2_me="QAAcamelme";
	String key3_me="QAAgiraffeme";
	String eq_title="QAA Equipment Search Case Upload";
	String ee_title="QAA Electrical Failure Case Upload";
	String me_title="QAA Mechanical Failure Case Upload";
	String keyword_same_eqUS="QAAfiveeqUS";
	String key1_eqUS="QAAzebraeqUS";
	String key2_eqUS="QAAcameleqUS";
	String key3_eqUS="QAAgiraffeeqUS";
	String keywordUS_same_ee="QAAfiveeeUS";
	String key1_eeUS="QAAzebraeeUS";
	String key2_eeUS="QAAcameleeUS";
	String key3_eeUS="QAAgiraffeeeUS";
	String keywordUS_same_me="QAAfivemeUS";
	String key1_meUS="QAAzebrameUS";
	String key2_meUS="QAAcamelmeUS";
	String key3_meUS="QAAgiraffemeUS";
	String eq_titleUS="QAA US Equipment Search Case Upload";
	String ee_titleUS="QAA US Electrical Failure Case Upload";
	String me_titleUS="QAA US Mechanical Failure Case Upload";
	String keyword_same_eqie11="QAAie11fiveeq";
	String key1_eqie11="QAAie11zebraeq";
	String key2_eqie11="QAAie11cameleq";
	String key3_eqie11="QAAie11giraffeeq";
	String keyword_same_eeie11="QAAie11fiveee";
	String key1_eeie11="QAAie11zebraee";
	String key2_eeie11="QAAie11camelee";
	String key3_eeie11="QAAie11giraffeee";
	String keyword_same_meie11="QAAie11fiveme";
	String key1_meie11="QAAie11zebrame";
	String key2_meie11="QAAie11camelme";
	String key3_meie11="QAAie11giraffeme";
	String eq_titleie11="QAA IE11 Equipment Case Upload";
	String ee_titleie11="QAA IE11 Electrical Case Upload";
	String me_titleie11="QAA IE11 Mechanical Case Upload";
	String keyword_same_eqie11US="QAAie11fiveeqUS";
	String key1_eqie11US="QAAie11zebraeqUS";
	String key2_eqie11US="QAAie11cameleqUS";
	String key3_eqie11US="QAAie11giraffeeqUS";
	String keyword_same_eeie11US="QAAie11fiveeeUS";
	String key1_eeie11US="QAAie11zebraeeUS";
	String key2_eeie11US="QAAie11cameleeUS";
	String key3_eeie11US="QAAie11giraffeeeUS";
	String keyword_same_meie11US="QAAie11fivemeUS";
	String key1_meie11US="QAAie11zebrameUS";
	String key2_meie11US="QAAie11camelmeUS";
	String key3_meie11US="QAAie11giraffemeUS";
	String eq_titleie11US="QAA US IE11 Equipment Case Upload";
	String ee_titleie11US="QAA US IE11 Electrical Case Upload";
	String me_titleie11US="QAA US IE11 Mechanical Case Upload";

	By KaleHomePage = By.className("pii-logo-div-element-kale");

	//Equipment databank only search page
	By EquipDropwdownTitle = By.xpath(".//*[@id='pii-question-list-equip']/div/h4/a/div");
	By EquipSearchMessage = By.xpath(".//*[@id='pii-efse-search-message']/div");
	By EquipSearchMessageErrorLink = By.xpath(".//*[@id='pii-efse-search-message']/div/a");
	By PreventionOfDesignDeficienciesLink = By.linkText("Prevention of Design Deficiencies");
	By EngineeringFundamentalsLink = By.linkText("Engineering Fundamentals");

	//Create equipment case page
	By EquipCaseNewButton = By.id("pii-admin-efse-button-new");
	By EquipCasePopupTitle = By.id("pii-admin-efse-dialog-title");
	By EquipCasePopupConfirmButton = By.id("pii-admin-efse-dialog-confirmed");
	By EquipCaseIDField = By.id("pii-admin-efse-id");
	By EquipCaseIDFieldError = By.id("pii-admin-efse-id-error");
	By EquipCaseTypes = By.id("pii-admin-efse-type-button");
	By EquipCaseTypeFieldText = By.xpath(".//*[@id='pii-admin-efse-type-button']/span[1]");
	By EquipCaseQuestion = By.id("pii-admin-efse-question");
	By EquipCaseAnswer = By.id("pii-admin-efse-answer");
	By EquipCaseNewKeywordField = By.id("pii-admin-efse-keyword-search-input");
	By EquipCaseNewKeywordAddButton = By.id("pii-admin-efse-keyword-new");
	By EquipCaseKeywordExistingList = By.xpath(".//*[@id='pii-admin-efse-keyword-blocks']/div[2]/ul");
	By EquipImageUploadField = By.id("pii-admin-efse-upload-file-input");
	By EquipImageCollapsible = By.xpath(".//*[@id='pii-admin-efse-upload-form-selectedfiles-div']/h5/a");
	By EquipCaseSaveButton = By.id("pii-admin-efse-button-save");
	By EquipCasesLink = By.id("pii-admin-efse-manage-button");
	By EquipCaseSearchCaseIDAdmin = By.id("pii-admin-efse-list-input");
	By EquipCaseSearchCaseIDDropdownAdmin = By.id("pii-admin-efse-list-ul");
	By EquipCaseDeleteButton = By.id("pii-admin-efse-button-delete");
	By EquipCaseEditButton = By.id("pii-admin-efse-button-edit");
	By EquipCaseExistingKeywordOnlyOne = By.xpath(".//*[@id='pii-admin-efse-keyword-form']/div/ul/li/a");
	By EquipCaseKeywordList = By.id("pii-admin-efse-keyword-list");
	By EquipImageCollapsibleExpanded = By.xpath(".//*[@id='pii-admin-efse-upload-form-selectedfiles']/div");
	By EquipCaseFields = By.id("pii-admin-efse-field-button");
	By EquipCaseFieldsFieldText = By.xpath(".//*[@id='pii-admin-efse-field-button']/span[1]");
	By EquipCaseDiscipline = By.id("pii-admin-efse-discipline-button");
	By EquipCaseDisciplineFieldText = By.xpath(".//*[@id='pii-admin-efse-discipline-button']/span[1]");
	By EquipListBoxTypes = By.id("pii-admin-efse-type-listbox");
	By ListCrossSymbol = By.cssSelector(".ui-btn.ui-corner-all.ui-btn-left.ui-btn-icon-notext.ui-icon-delete");
	By EquipListBoxTypesCrossSymbol = By.xpath(".//*[@id='pii-admin-efse-type-listbox']/div/a");
	By EquipListBoxDisciplineCrossSymbol = By.xpath(".//*[@id='pii-admin-efse-discipline-listbox']/div/a");
	By EquipListBoxDiscipline = By.id("pii-admin-efse-discipline-listbox");
	By EquipListBoxFields = By.id("pii-admin-efse-field-listbox");
	By EquipListBoxFieldsCrossSymbol = By.xpath(".//*[@id='pii-admin-efse-field-listbox']/div/a");
	By EquipCasesLink1Title = By.id("pii-admin-efse-linktitle-0");
	By EquipCasesLink1URL = By.id("pii-admin-efse-linkurl-0");
	By EquipCasesLink2Title = By.id("pii-admin-efse-linktitle-1");
	By EquipCasesLink2URL = By.id("pii-admin-efse-linkurl-1");
	By EquipCasesLink3Title = By.id("pii-admin-efse-linktitle-2");
	By EquipCasesLink3URL = By.id("pii-admin-efse-linkurl-2");
	By EquipCasesLink4Title = By.id("pii-admin-efse-linktitle-3");
	By EquipCasesLink4URL = By.id("pii-admin-efse-linkurl-3");
	By EquipCasesLink5Title = By.id("pii-admin-efse-linktitle-4");
	By EquipCasesLink5URL = By.id("pii-admin-efse-linkurl-4");
	By EquipCasesLink6Title = By.id("pii-admin-efse-linktitle-5");
	By EquipCasesLink6URL = By.id("pii-admin-efse-linkurl-5");
	By EquipCasesLink7Title = By.id("pii-admin-efse-linktitle-6");
	By EquipCasesLink7URL = By.id("pii-admin-efse-linkurl-6");
	By EquipCasesLink8Title = By.id("pii-admin-efse-linktitle-7");
	By EquipCasesLink8URL = By.id("pii-admin-efse-linkurl-7");
	By EquipCasesLink9Title = By.id("pii-admin-efse-linktitle-8");
	By EquipCasesLink9URL = By.id("pii-admin-efse-linkurl-8");
	By EquipCasesLink10Title = By.id("pii-admin-efse-linktitle-9");
	By EquipCasesLink10URL = By.id("pii-admin-efse-linkurl-9");
	By EquipCasesLink11Title = By.id("pii-admin-efse-linktitle-10");
	By EquipCasesLink11URL = By.id("pii-admin-efse-linkurl-10");
	By EquipCasesLink12Title = By.id("pii-admin-efse-linktitle-11");
	By EquipCasesLink12URL = By.id("pii-admin-efse-linkurl-11");
	By EquipCasesLink13Title = By.id("pii-admin-efse-linktitle-12");
	By EquipCasesLink13URL = By.id("pii-admin-efse-linkurl-12");
	By EquipCasesLink1VideoCheckbox = By.xpath(".//*[@id='pii-admin-efse-linkdiv-0']/div[2]/table/tbody/tr[1]/td[1]/div/label");
	By EquipCasesLink2VideoCheckbox = By.xpath(".//*[@id='pii-admin-efse-linkdiv-1']/div[2]/table/tbody/tr[1]/td[1]/div/label");
	By EquipCasesLink3VideoCheckbox = By.xpath(".//*[@id='pii-admin-efse-linkdiv-2']/div[2]/table/tbody/tr[1]/td[1]/div/label");
	By EquipCasesLink4VideoCheckbox = By.xpath(".//*[@id='pii-admin-efse-linkdiv-3']/div[2]/table/tbody/tr[1]/td[1]/div/label");
	By EquipCasesLink5VideoCheckbox = By.xpath(".//*[@id='pii-admin-efse-linkdiv-4']/div[2]/table/tbody/tr[1]/td[1]/div/label");
	By EquipCasesLink6VideoCheckbox = By.xpath(".//*[@id='pii-admin-efse-linkdiv-5']/div[2]/table/tbody/tr[1]/td[1]/div/label");
	By EquipCasesLinkTitleOnSide = By.id("pii-admin-efse-linklabel-0");
	By EquipCasesLink1TitleCrossSymbol = By.xpath(".//*[@id='pii-admin-efse-linkdiv-0']/div[1]/div/a");
	By EquipCasesLink1URLCrossSymbol = By.xpath(".//*[@id='pii-admin-efse-linkdiv-0']/div[2]/table/tbody/tr[1]/td[2]/div/a");
	By EquipCasesLink2TitleCrossSymbol = By.xpath(".//*[@id='pii-admin-efse-linkdiv-1']/div[1]/div/a");
	By EquipCasesLink2URLCrossSymbol = By.xpath(".//*[@id='pii-admin-efse-linkdiv-1']/div[2]/table/tbody/tr[1]/td[2]/div/a");

	By EquipCasesTypeList = By.xpath(".//*[@id='pii-admin-efse-data-form']/div[2]/div/a/span[2]");
	By EquipListTypesAdvancedLearning = By.xpath(".//*[@id='pii-admin-efse-type-menu']/li[1]/a");
	By EquipListTypesCaseStudies = By.xpath(".//*[@id='pii-admin-efse-type-menu']/li[2]/a");
	By EquipListTypesDesign = By.xpath(".//*[@id='pii-admin-efse-type-menu']/li[3]/a");
	By EquipListTypesFailureModes = By.xpath(".//*[@id='pii-admin-efse-type-menu']/li[4]/a");
	By EquipListTypesFundamentals = By.xpath(".//*[@id='pii-admin-efse-type-menu']/li[5]/a");
	By EquipListTypesGeneral = By.xpath(".//*[@id='pii-admin-efse-type-menu']/li[6]/a");

	By EquipCasesDisciplineList = By.xpath(".//*[@id='pii-admin-efse-data-form']/div[3]/div/a/span[2]");
	By EquipListDisciplineElectrical = By.xpath(".//*[@id='pii-admin-efse-discipline-menu']/li[1]/a");
	By EquipListDisciplineGeneral = By.xpath(".//*[@id='pii-admin-efse-discipline-menu']/li[2]/a");
	By EquipListDisciplineIC = By.xpath(".//*[@id='pii-admin-efse-discipline-menu']/li[3]/a");
	By EquipListDisciplineMechanical = By.xpath(".//*[@id='pii-admin-efse-discipline-menu']/li[4]/a");
	By EquipListDisciplineSoftware = By.xpath(".//*[@id='pii-admin-efse-discipline-menu']/li[5]/a");
	By EquipListDisciplineStructural = By.xpath(".//*[@id='pii-admin-efse-discipline-menu']/li[6]/a");

	By EquipCasesFieldList = By.xpath(".//*[@id='pii-admin-efse-data-form']/div[4]/div/a/span[2]");
	By EquipListFieldsAuto = By.xpath(".//*[@id='pii-admin-efse-field-menu']/li[1]/a");
	By EquipListFieldsNuclear = By.xpath(".//*[@id='pii-admin-efse-field-menu']/li[2]/a");
	By EquipListFieldsOther = By.xpath(".//*[@id='pii-admin-efse-field-menu']/li[3]/a");
	By EquipListFieldsPharmaceutical = By.xpath(".//*[@id='pii-admin-efse-field-menu']/li[4]/a");
	By EquipListFieldsWelding = By.xpath(".//*[@id='pii-admin-efse-field-menu']/li[5]/a");

	//Related links slide
	//	By RelatedLinksSlideTitle = By.xpath(".//*[@class='pii-linkslide']/div[1]/div");
	/*	By RelatedLinksSlideLink1Title = By.xpath(".//*[@class='pii-linkslide']/div[2]");
	By RelatedLinksSlideLink2Title = By.xpath(".//*[@class='pii-linkslide']/div[3]");
	By RelatedLinksSlideLink3Title = By.xpath(".//*[@class='pii-linkslide']/div[4]");
	By RelatedLinksSlideLink4Title = By.xpath(".//*[@class='pii-linkslide']/div[5]");
	By RelatedLinksSlideLink5Title = By.xpath(".//*[@class='pii-linkslide']/div[6]");
	By RelatedLinksSlideLink6Title = By.xpath(".//*[@class='pii-linkslide']/div[7]");
	By RelatedLinksSlideLink7Title = By.xpath(".//*[@class='pii-linkslide']/div[8]");
	By RelatedLinksSlideLink8Title = By.xpath(".//*[@class='pii-linkslide']/div[9]");
	By RelatedLinksSlideLink9Title = By.xpath(".//*[@class='pii-linkslide']/div[10]");
	By RelatedLinksSlideLink1URL = By.xpath(".//*[@class='pii-linkslide']/div[2]/a");
	By RelatedLinksSlideLink2URL = By.xpath(".//*[@class='pii-linkslide']/div[3]/a");
	By RelatedLinksSlideLink4URL = By.xpath(".//*[@class='pii-linkslide']/div[5]/a");
	 */
	public void createCaseWithDifferentDisciplineField (WebDriver driver, String title, String keyword) throws Exception {

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebDriverWait wait = new WebDriverWait(driver,10);
		ShareCheck obj = new ShareCheck();
		CreateHumanCase obj2 = new CreateHumanCase ();
		CreateEquipmentCase2 obj4 = new CreateEquipmentCase2();
		Login obj3 = new Login();
		//Create list with discipline By elements
		List<By> disc_list = disciplineList();
		//Create list with field By elements
		List<By> field_list = fieldList();	
		//Lists for cases per discipline
		List<String> electrical = new ArrayList<String>();
		List<String> general = new ArrayList<String>();
		List<String> ic = new ArrayList<String>();
		List<String> mechanical = new ArrayList<String>();
		List<String> software = new ArrayList<String>();
		List<String> structural = new ArrayList<String>();
		//Get browser name and version
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		String v = cap.getVersion().toString();
		System.out.println(v);
		int x=obj4.selectNumberForType(driver);
		//Chrome or Firefox
		if(browserName.equals("chrome")||browserName.equals("firefox"))
		{
			//Clicks on admin user name on top right corner
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj3.LoginNameOnTopRight)).click();
			//Clicks on admin option
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.AdminOption)).click();
			//Clicks on Errorfree bank option
			if (driver.findElement(EquipCasesLink).isDisplayed()==false)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.ErrorFreeBankLink)).click();
			}	
			//Clicks on Equipment cases
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink)).click();	
		}
		for(int i=0;i<disc_list.size();i++)
		{
			//create a list for storing case id s
			List<String> caseID = new ArrayList<String>();
			for(int j=0;j<field_list.size();j++)
			{
				if(browserName.equals("internet explorer"))
				{
					//Waits for black loading message to disappear
					obj.loadingServer(driver);
					//Waits for black loading message to disappear
					obj.loadingServer(driver);
					obj.scrollToTop(driver);
					//Close sticky
					obj3.closePopUpSticky(driver);
					while(true)
					{
						if(driver.findElement(obj2.AdminOption).isDisplayed()==false)
						{
							//Clicks on admin user name on top right corner
							wait.until(ExpectedConditions.visibilityOfElementLocated(obj3.LoginNameOnTopRight)).click();
						}
						else
						{
							//Clicks on admin option
							wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.AdminOption)).click();
							break;
						}
					}
					//Clicks on Errorfree bank option
					if (driver.findElement(EquipCasesLink).isDisplayed()==false)
					{
						wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.ErrorFreeBankLink)).click();
					}	
					//Clicks on Equipment cases
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink)).click();	
				}
				//Waits for black loading message to disappear
				obj.loadingServer(driver);
				//Scroll to top
				Thread.sleep(1000);
				obj.scrollToTop(driver);
				Thread.sleep(1000);
				//Clicks on new case button
				if(browserName.equals("internet explorer"))
					jse.executeScript("return document.getElementById('pii-admin-efse-button-new').click();");
				else{
					WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewButton));
					ele.click();		
				}
				Thread.sleep(1000);
				//Clicks on new case
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupTitle));
				WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupConfirmButton));
				ele.click();
				//Waits for black loading message to disappear
				obj.loadingServer(driver);
				//Scroll to top
				Thread.sleep(1000);
				obj.scrollToTop(driver);
				Thread.sleep(1000);
				//Add Case is to list
				caseID.add(chooseCaseId(driver));
				//Selects types and returns assigned numeric value of type
				obj4.selectTypeRandom(driver, x, browserName, v);
				//Verify type not empty
				obj4.verifyTypeNotEmpty(driver, x, browserName, v);
				//Select Discipline
				selectDisciplineForComboTest(driver, disc_list.get(i), browserName, v);
				//Verify discipline not empty
				obj4.verifyDisciplineNotEmpty(driver, disc_list.get(i), browserName, v);
				//Select Fields
				selectFieldsForComboTest(driver, field_list.get(j), browserName, v);
				//Verify field no empty
				obj4.verifyFieldNotEmpty(driver, field_list.get(j), browserName, v);
				//Enters Question
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseQuestion)).sendKeys(title);
				//Make sure Question typed in right
				String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseQuestion)).getAttribute("textContent");
				if(s1.equals(keyword) == false)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseQuestion)).clear();
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseQuestion)).sendKeys(title);
				}
				//Enters Answer
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseAnswer)).sendKeys(title);
				//Make sure Answer typed in right
				String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseAnswer)).getAttribute("textContent");
				if(s2.equals(keyword) == false)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseAnswer)).clear();
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseAnswer)).sendKeys(title);
				}
				Thread.sleep(1000);
				try{
					jse.executeScript("scroll(0,1700)");
				}catch (org.openqa.selenium.ScriptTimeoutException r)
				{
					Thread.sleep(3000);
					jse.executeScript("scroll(0,1700)");
				}
				Thread.sleep(1000);
				Thread.sleep(1000);
				//Enters Keyword
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).sendKeys(keyword);
				Thread.sleep(2000);
				//Make sure keyword typed in right
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).getAttribute("value");
				if(s.equals(keyword) == false)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).clear();
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).sendKeys(keyword);
				}					
				if(i==0 && j==0)
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordAddButton)).click();
				else
				{
					Thread.sleep(1000);
					try{
						jse.executeScript("scroll(0,1700)");
					}catch (org.openqa.selenium.ScriptTimeoutException r)
					{
						Thread.sleep(3000);
						jse.executeScript("scroll(0,1700)");
					}
					Thread.sleep(1000);
					WebElement element = driver.findElement(EquipCaseKeywordExistingList);
					element.findElement(obj2.FirstAndLastChildInList).click();
				}
				//Upload images
				WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipImageCollapsible));
				obj.scrollToElement(driver, l);
				ele = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipImageUploadField));
				if(browserName.equals("chrome"))
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipImageUploadField)).click();
					Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlides.exe");
					p.waitFor();
				}
				if(browserName.equals("firefox"))
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipImageUploadField)).click();
					Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlides_Firefox.exe");
					p.waitFor();
				}
				if(browserName.equals("internet explorer"))
				{
					if(v.startsWith("10"))
					{
						try{
							jse.executeScript("return document.getElementById('pii-admin-efse-upload-file-input').click();");
						}catch (org.openqa.selenium.ScriptTimeoutException r)
						{
							Thread.sleep(3000);
							jse.executeScript("return document.getElementById('pii-admin-efse-upload-file-input').click();");
						}
						Thread.sleep(3000);
						Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlides_IE10.exe");
						p.waitFor();
					}
					if(v.startsWith("11"))
					{
						jse.executeScript("return document.getElementById('pii-admin-efse-upload-file-input').click();");
						Thread.sleep(3000);
						Process p =Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/UploadHumanCaseSlides_IE10.exe");
						p.waitFor();
					}
				}
				Thread.sleep(3000);
				//Checks if 5 images have been uploaded
				if(driver.findElement(EquipImageCollapsibleExpanded).isDisplayed()==false)
				{
					l = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipImageCollapsible));
					obj.scrollToElement(driver, l);
					l.click();
				}
				Thread.sleep(2000);
				for (int k=1; k<=5;k++)
				{
					String xpath = ".//*[@id='pii-admin-efse-upload-form-selectedfiles']/div["+(k)+"]";
					try{
						if (driver.findElement(By.xpath(xpath)).isDisplayed())
						{
							System.out.println("Uploaded Image : " + (k));
						}
					}catch(org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException r)
					{
						break;
					}
					Thread.sleep(1000);
				}
				try{
					obj.scrollToTop(driver);
				}catch (org.openqa.selenium.ScriptTimeoutException r)
				{
					Thread.sleep(3000);
					obj.scrollToTop(driver);
				}
				Thread.sleep(1000);
				//Clicks on save
				if(browserName.equals("internet explorer")){
					jse.executeScript("return document.getElementById('pii-admin-efse-button-save').click();");
					Thread.sleep(1000);}
				else{
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSaveButton)).click();
				}
				//Clicks on create case
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupTitle));
				System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupTitle)).getText());
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupConfirmButton)).click();
				//Waits for black loading message to disappear
				obj.loadingServer(driver);
				//Scroll to top
				Thread.sleep(1000);
				try{
					obj.scrollToTop(driver);
				}catch (org.openqa.selenium.ScriptTimeoutException r)
				{
					Thread.sleep(3000);
					obj.scrollToTop(driver);
				}
				Thread.sleep(1000);
			}	
			//Add case list to different discipline lists
			if(i==0)
			{
				electrical.addAll(caseID);
				System.out.println("Discipline : Electrical ="+electrical);
			}
			if(i==1)
			{
				general.addAll(caseID);
				System.out.println("Discipline : General ="+general);
			}
			if(i==2)
			{
				ic.addAll(caseID);
				System.out.println("Discipline : I&C ="+ic);
			}
			if(i==3)
			{
				mechanical.addAll(caseID);
				System.out.println("Discipline : Mechanical ="+mechanical);
			}
			if(i==4)
			{
				software.addAll(caseID);
				System.out.println("Discipline : Software ="+software);
			}
			if(i==5)
			{
				structural.addAll(caseID);
				System.out.println("Discipline : Structural ="+structural);
			}
		}
		//Search for cases in any filter type
		caseSearchWithDisciplineFieldCombo(driver, x, keyword, electrical, general, ic, mechanical, software, structural);
		//Search for cases in Equipment Databank (Instructor Only)
		obj4.caseSearchWithDisciplineFieldComboEquipmentDatabank(driver, x, keyword, electrical, general, ic, mechanical, software, structural);
		//Delete cases
		deleteCase(driver, electrical);
		System.out.println("Deleted cases for Discipline : Electrical");
		deleteCase(driver, general);
		System.out.println("Deleted cases for Discipline : General");
		deleteCase(driver, ic);
		System.out.println("Deleted cases for Discipline : I&C");
		deleteCase(driver, mechanical);
		System.out.println("Deleted cases for Discipline : Mechanical");
		deleteCase(driver, software);
		System.out.println("Deleted cases for Discipline : Software");
		deleteCase(driver, structural);
		System.out.println("Deleted cases for Discipline : Structural");
	}

	public void caseSearchWithDisciplineFieldCombo(WebDriver driver, int x, String keyword, List<String> electrical, List<String> general, List<String> ic, List<String> mechanical, List<String> software, List<String> structural) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		ShareCheck obj = new ShareCheck();
		CaseBrowse obj1 = new CaseBrowse();
		CreateHumanCase obj2 = new CreateHumanCase ();
		CreateEquipmentCase2 obj3 = new CreateEquipmentCase2();
		//Go to Failure mode
		//Clicks on Error free bank
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.ErrorFreeBankTopLink)).click();
		}catch (UnhandledAlertException f){			  
			driver.switchTo().alert().dismiss();
		}
		//Clicks on Equipment module as per x value
		obj3.decideEquipmentModule(driver,x);
		//Search for keyword
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Wait for loading message
		obj.loadingServer(driver);
		//Look for all cases without filter
		lookForCases(driver, electrical);
		lookForCases(driver, general);
		lookForCases(driver, ic);
		lookForCases(driver, mechanical);
		lookForCases(driver, software);
		lookForCases(driver, structural);
		//Look for case with filter
		//Create a list with discipline filters for case search
		List<By> discList = disciplineCaseSearchList();
		//Create a list with field filters for case search
		List<By> fieldList = fieldCaseSearchList();
		//Search and verify case with filter
		for(int i=0;i<discList.size();i++)
		{
			//Clicks on clear
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
			//Select filter for Equipment Performance
			if((x == 1)||(x==2)||(x==6))
			{
				//Select Type
				obj3.selectTypeAsPerX(driver,x);
			}
			//Click on discipline box
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.CaseSearchDisciplineBox)).click();
			//Wait for popup
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.CaseSearchDisciplineList));
			//Click on discipline
			wait.until(ExpectedConditions.visibilityOfElementLocated(discList.get(i))).click();
			//Close pop up
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.CaseSearchDisciplinePopupClose)).click();
			//Search for keyword
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(keyword);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
			//Wait for loading message
			obj.loadingServer(driver);
			//Verify cases with only discipline filter
			verifyCasesWithOnlyDisciplineFilter(driver, i, electrical, general, ic, mechanical, software, structural);
			//Select field filter and disc filter
			selectFieldDiscFilter (driver, x, i, discList, fieldList, keyword, electrical, general, ic, mechanical, software, structural);
		}
	}

	public void selectFieldDiscFilter (WebDriver driver, int x,int i, List<By> discList, List<By> fieldList, String keyword, List<String> electrical, List<String> general, List<String> ic, List<String> mechanical, List<String> software, List<String> structural) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		ShareCheck obj = new ShareCheck();
		CaseBrowse obj1 = new CaseBrowse();
		CreateEquipmentCase2 obj2 = new CreateEquipmentCase2();
		for(int j=0;j<fieldList.size();j++)
		{
			//Clicks on clear
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
			//Select filter for Equipment Performance
			if((x == 1)||(x==2)||(x==6))
			{
				//Select Type
				obj2.selectTypeAsPerX(driver,x);
			}
			//Click on discipline box
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.CaseSearchDisciplineBox)).click();
			//Wait for popup
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.CaseSearchDisciplineList));
			//Click on 1st discipline
			wait.until(ExpectedConditions.visibilityOfElementLocated(discList.get(i))).click();
			//Close pop up
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.CaseSearchDisciplinePopupClose)).click();
			//Click on field box
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.CaseSearchFieldBox)).click();
			//Wait for popup
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.CaseSearchFieldList));
			//Click on field
			wait.until(ExpectedConditions.visibilityOfElementLocated(fieldList.get(j))).click();
			//Close pop up
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.CaseSearchFieldPopupClose)).click();
			//Search for keyword
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(keyword);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
			//Wait for loading message
			obj.loadingServer(driver);
			//Look for case with 2 filters
			verifyCasesWith2DisciplineFieldFilters(driver, i, j, electrical, general, ic, mechanical, software, structural);
		}
	}

	public void verifyCasesWith2DisciplineFieldFilters(WebDriver driver, int i, int j, List<String> electrical, List<String> general, List<String> ic, List<String> mechanical, List<String> software, List<String> structural) throws Exception{

		List<String> cases = new ArrayList<String>();
		WebDriverWait wait = new WebDriverWait(driver,10);
		if(i==0)
		{
			cases.addAll(electrical);
		}
		if(i==1)
		{
			cases.addAll(general);
		}
		if(i==2)
		{
			cases.addAll(ic);
		}
		if(i==3)
		{
			cases.addAll(mechanical);
		}
		if(i==4)
		{
			cases.addAll(software);
		}
		if(i==5)
		{
			cases.addAll(structural);
		}
		//Look for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+cases.get(j))));
	}

	public void verifyCasesWithOnlyDisciplineFilter(WebDriver driver, int i, List<String> electrical, List<String> general, List<String> ic, List<String> mechanical, List<String> software, List<String> structural) throws Exception{

		List<String> cases = new ArrayList<String>();
		if(i==0)
		{
			cases.addAll(electrical);
		}
		if(i==1)
		{
			cases.addAll(general);
		}
		if(i==2)
		{
			cases.addAll(ic);
		}
		if(i==3)
		{
			cases.addAll(mechanical);
		}
		if(i==4)
		{
			cases.addAll(software);
		}
		if(i==5)
		{
			cases.addAll(structural);
		}
		lookForCases(driver, cases);
	}

	public void lookForCases(WebDriver driver, List<String> cases) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		for(int j=0;j<cases.size();j++)
		{
			//Look for case
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+cases.get(j))));
		}
	}

	public List<By> disciplineCaseSearchList()  throws Exception{

		List<By> dl = new ArrayList<By>();
		CaseBrowse obj = new CaseBrowse();
		//Add discipline to list
		Collections.addAll(dl, obj.EquipCaseSearchListDisciplineElectrical, obj.EquipCaseSearchListDisciplineGeneral, obj.EquipCaseSearchListDisciplineIC, obj.EquipCaseSearchListDisciplineMechanical, obj.EquipCaseSearchListDisciplineSoftware, obj.EquipCaseSearchListDisciplineStructural);
		return dl;
	}

	public List<By> fieldCaseSearchList()  throws Exception{

		List<By> fl = new ArrayList<By>();
		CaseBrowse obj = new CaseBrowse();
		//Add discipline to list
		Collections.addAll(fl, obj.EquipCaseSearchListFieldAuto, obj.EquipCaseSearchListFieldNuclear, obj.EquipCaseSearchListFieldOther, obj.EquipCaseSearchListFieldPharmaceutical, obj.EquipCaseSearchListFieldWelding);
		return fl;
	}

	public void selectFieldsForComboTest(WebDriver driver, By element, String browserName, String v) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		if (browserName.contains("internet")==true)
		{
			if (v.startsWith("10")==true)
			{
				//Fields
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseFields)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseFields)).sendKeys(Keys.ENTER);
			}
			if (v.startsWith("11")==true)
			{
				//Fields
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseFields)).click();
			}
		}
		else{
			//Fields
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseFields)).click();
		}
		Thread.sleep(1000);
		//Waits for the popup
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListBoxFields));	
		//Click on field
		wait.until(ExpectedConditions.visibilityOfElementLocated(element)).click();		
		//Close pop up
		try{
			driver.findElement(ListCrossSymbol).click();
		}catch (NoSuchElementException | ElementNotInteractableException e)
		{
			driver.findElement(EquipListBoxFieldsCrossSymbol).click();
		}
	}

	public void selectDisciplineForComboTest(WebDriver driver, By element, String browserName, String v) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		if (browserName.contains("internet")==true)
		{
			if (v.startsWith("10")==true)
			{
				//Discipline
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseDiscipline)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseDiscipline)).sendKeys(Keys.ENTER);
			}
			if (v.startsWith("11")==true)
			{
				//Discipline
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseDiscipline)).click();
			}
		}
		else{
			//Discipline
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseDiscipline)).click();
		}
		Thread.sleep(1000);
		//Waits for the page to load
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListBoxDiscipline));
		if (browserName.contains("internet")==true)
			clickTypesDisciplineIE(driver, element);
		else
			wait.until(ExpectedConditions.visibilityOfElementLocated(element)).click();
		//Close pop up
		try{
			driver.findElement(ListCrossSymbol).click();
		}catch (NoSuchElementException | ElementNotInteractableException e)
		{
			driver.findElement(EquipListBoxDisciplineCrossSymbol).click();
		}
	}

	public void selectFMTypes(WebDriver driver, String browserName, String v) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		if (browserName.contains("internet")==true)
		{
			if (v.startsWith("10")==true)
			{
				//Type
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseTypes)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseTypes)).sendKeys(Keys.ENTER);
			}
			if (v.startsWith("11")==true)
			{
				//Type
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseTypes)).click();
			}
		}
		else{
			//Type
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseTypes)).click();
		}
		Thread.sleep(1000);
		//Waits for popup
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListBoxTypes));
		//Click type failure mode
		if (browserName.contains("internet")==true)
			clickTypesDisciplineIE(driver, EquipListTypesFailureModes);
		else
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListTypesFailureModes)).click();
		//Close pop up
		try{
			driver.findElement(ListCrossSymbol).click();
		}catch (NoSuchElementException | ElementNotInteractableException e)
		{
			driver.findElement(EquipListBoxTypesCrossSymbol).click();
		}
	}

	public String chooseCaseId(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		Random random = new Random();
		String caseId = "";
		while (true)
		{
			Thread.sleep(1000);
			int y=random.nextInt(10000);
			if(y<1000)
				continue;
			caseId = String.format("%d", y);
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseIDField)).sendKeys(caseId);
			Thread.sleep(1000);
			Thread.sleep(1000);
			WebElement errorCaseId;
			try{
				errorCaseId=driver.findElement(EquipCaseIDFieldError);
			}catch(org.openqa.selenium.NoSuchElementException e)
			{
				break;
			}
			if(errorCaseId.isDisplayed()==true)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseIDField)).clear();
				continue;
			}
			if(errorCaseId.isDisplayed()==false)
				break;
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseIDField)).clear();
		}
		System.out.println("Case id: "+ caseId);
		return caseId;
	}

	public List<By> disciplineList()  throws Exception{

		List<By> dl = new ArrayList<By>();
		//Add discipline to list
		Collections.addAll(dl, EquipListDisciplineElectrical, EquipListDisciplineGeneral, EquipListDisciplineIC, EquipListDisciplineMechanical, EquipListDisciplineSoftware, EquipListDisciplineStructural);
		return dl;
	}

	public List<By> fieldList()  throws Exception{

		List<By> fl = new ArrayList<By>();
		//Add discipline to list
		Collections.addAll(fl, EquipListFieldsAuto, EquipListFieldsNuclear, EquipListFieldsOther, EquipListFieldsPharmaceutical, EquipListFieldsWelding);
		return fl;
	}

	public void deletePreviousCase(WebDriver driver, String title) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,40);
		ShareCheck obj = new ShareCheck();
		CaseBrowse obj1 = new CaseBrowse();
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
		//Clicks on Error free bank
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.ErrorFreeBankLink)).click();
		//Clicks on Equipment Performance Search (PII)
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentDatabankOnlyLink1)).click();
		//Enters the title in term search field
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(title);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
		//Checks if Exact matches appear
		WebElement exact = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipDropwdownTitle));
		String exactText=exact.getText();		
		if(exactText.equals("Results")==true)
		{
			int i=1;
			List<String> caseIdArray=new ArrayList<String>();
			while(true)
			{
				try
				{
					String xpath=".//*[@id='pii-question-list-equip']/div[1]/div[1]/div["+i+"]";
					System.out.println(xpath);
					WebElement row=driver.findElement(By.xpath(xpath));
					String rowCaseId=row.getAttribute("qid");
					rowCaseId=rowCaseId.substring(1);
					System.out.println("Case id:" +rowCaseId);
					caseIdArray.add(rowCaseId);
					i=i+1;
				}catch(NoSuchElementException e)
				{
					break;
				}
			}
			deleteCase(driver, caseIdArray);
		}
		else 
		{
			System.out.println("No existing cases for: "+title);
		}
		//Go to KALE homepage
		wait.until(ExpectedConditions.visibilityOfElementLocated(KaleHomePage)).click();
		Thread.sleep(1000);		
	}

	public void deleteLinks (WebDriver driver, List<String> ee_case) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		ShareCheck obj = new ShareCheck();
		CreateHumanCase obj1 = new CreateHumanCase();
		CaseBrowse obj2 = new CaseBrowse();
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.LoginNameOnTopRight)).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.AdminOption)).click();
		Thread.sleep(1000);
		//Clicks on Errorfree bank option
		if (driver.findElement(EquipCasesLink).isDisplayed()==false)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.ErrorFreeBankLink)).click();
		}
		//Clicks on Equipment cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink)).click();
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
		Thread.sleep(1000);
		Thread.sleep(1000);
		//Enter FM case id with links
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSearchCaseIDAdmin)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSearchCaseIDAdmin)).sendKeys(ee_case.get(2));
		Thread.sleep(2000);
		//Clicks on case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSearchCaseIDDropdownAdmin)).click();
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
		//Click on Edit
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseEditButton)).click();
		Thread.sleep(2000);
		//Scroll to 2nd Link title
		WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink1TitleCrossSymbol));
		obj.scrollToElement(driver, l);
		//Click on delete link 2 cross symbol of Title
		wait.until(ExpectedConditions.elementToBeClickable(EquipCasesLink1Title)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink1TitleCrossSymbol)).click();
		//Click on delete link 2 cross symbol of URL
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink1URLCrossSymbol)).click();
		//Save case
		try{
			obj.scrollToTop(driver);
		}catch (org.openqa.selenium.ScriptTimeoutException r)
		{
			Thread.sleep(3000);
			obj.scrollToTop(driver);
		}
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSaveButton)).click();
		//Clicks on create case
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupConfirmButton)).click();
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
		obj.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on Errorfree bank option
		if (driver.findElement(EquipCasesLink).isDisplayed()==false)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.ErrorFreeBankLink)).click();
		}
		//Clicks on Equipment cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink)).click();
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
		obj.scrollToTop(driver);
		Thread.sleep(1000);
		//Enter FM case id with links
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSearchCaseIDAdmin)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSearchCaseIDAdmin)).sendKeys(ee_case.get(2));
		Thread.sleep(2000);
		//Clicks on case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSearchCaseIDDropdownAdmin)).click();
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
		//Scroll up
		Thread.sleep(1000);
		obj.scrollToTop(driver);
		Thread.sleep(1000);
		//Click on Edit
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseEditButton)).click();
		//Scroll to 1st Link title
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink2Title));
		obj.scrollToElement(driver, l);
		//delete 2 to 12
		for(int i=1;i<=11;i++)
		{
			//Click on delete link 2 cross symbol of URL
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink2URLCrossSymbol)).click();
			//Click on delete link 2 cross symbol of Title
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink2TitleCrossSymbol)).click();
			Thread.sleep(500);
		}
		//Click on delete link 1 cross symbol of URL
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink1URLCrossSymbol)).click();
		//Click on delete link 1 cross symbol of Title
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink1TitleCrossSymbol)).click();
		//Save case
		obj.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSaveButton)).click();
		//Clicks on create case
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupConfirmButton)).click();
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
		Thread.sleep(1000);
		obj.scrollToTop(driver);
		Thread.sleep(1000);
		//Verify no text from previous links present in text boxes
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink1Title)).getAttribute("textContent");
		softly.assertThat(s).as("test data").isEmpty();
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink1URL)).getAttribute("textContent");
		softly.assertThat(s1).as("test data").isEmpty();
		try{
			WebDriverWait wait1 = new WebDriverWait(driver,3);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink2Title));
			softly.fail("after deleting all links still there is an extra link row visible");
		}catch(org.openqa.selenium.NoSuchElementException |org.openqa.selenium.TimeoutException r)
		{

		}
		//Go back to case browse and verify that no Related Links slide
		//Clicks on Error free bank
		WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.ErrorFreeBankTopLink));
		/*Actions act = new Actions(driver);
		act.click(element1).build().perform();*/
		element1.click();
		//Go to  FM
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.FailureModeLink)).click();
		Thread.sleep(1000);
		//Browse case 
		//Check for case
		//Enters case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.EquipmentSearchCaseIdField)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.EquipmentSearchCaseIdField)).sendKeys(ee_case.get(2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.EquipmentSearchCaseIdField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Click on collapsible 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+ee_case.get(2)))).click();
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Clicks on Show Slides
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-button-equip-F"+ee_case.get(2))));
		WebElement element =  driver.findElement(By.id("pii-slideshow-button-equip-F"+ee_case.get(2)));
		String slide = element.getText();
		System.out.println(slide);
		while (slide.contains("Show Slides(")==false)
		{
			Thread.sleep(1000);
			System.out.println(slide);
			slide = element.getText();
		}		
		System.out.println(slide);
		System.out.println(slide.indexOf("(") + "  "+ slide.indexOf(")"));
		String number= slide.substring(slide.indexOf("(")+1, slide.indexOf(")"));
		element.sendKeys(Keys.TAB);
		element.sendKeys(Keys.ENTER);
		driver.findElement(By.id("pii-slideshow-equip-F"+ee_case.get(2)+"-popup"));
		System.out.println(number);
		//Click on previous
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.SlidePreviousButton)).click();
		//Verify title of Related Links slide doesnt exist
		try{
			String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+ee_case.get(2)+"']/ul/li["+Integer.parseInt(number)+"]/div[2]/div/div"))).getText();
			softly.assertThat(s2).as("test data").doesNotContain("Related Links");		
		}catch(org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException t)
		{
			System.out.println("Related links slide not present");
		}
		//Closes the slideshow
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+ee_case.get(2)+"']/a"))).click();
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.EquipmentSearchClearButton)).click();
	}

	public void editLinks (WebDriver driver, List<String> ee_case) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		ShareCheck obj = new ShareCheck();
		CreateHumanCase obj1 = new CreateHumanCase();
		CaseBrowse obj2 = new CaseBrowse();
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.LoginNameOnTopRight)).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.AdminOption)).click();
		Thread.sleep(1000);
		//Clicks on Errorfree bank option
		if (driver.findElement(EquipCasesLink).isDisplayed()==false)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.ErrorFreeBankLink)).click();
		}
		//Clicks on Equipment cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink)).click();
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
		Thread.sleep(1000);
		obj.scrollToTop(driver);
		Thread.sleep(1000);
		//Enter FM case id with links
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSearchCaseIDAdmin)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSearchCaseIDAdmin)).sendKeys(ee_case.get(2));
		Thread.sleep(2000);
		//Clicks on case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSearchCaseIDDropdownAdmin)).click();
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
		//Click on Edit
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseEditButton)).click();
		//Scroll to 1st Link title
		WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink1Title));
		obj.scrollToElement(driver, l);
		//Edit link title
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink1Title)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink1Title)).sendKeys("Edited: "+videoLinkTitle1);
		//Save case
		Thread.sleep(2000);
		obj.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSaveButton)).click();
		//Clicks on create case
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupConfirmButton)).click();
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
		Thread.sleep(1000);
		obj.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on Error free bank
		WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.ErrorFreeBankTopLink));
		element1.click();
		//Go to  FM
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.FailureModeLink)).click();
		Thread.sleep(1000);
		//Check for case
		//Enters case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.EquipmentSearchCaseIdField)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.EquipmentSearchCaseIdField)).sendKeys(ee_case.get(2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.EquipmentSearchCaseIdField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Click on collapsible 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+ee_case.get(2)))).click();
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Clicks on Show Slides
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-button-equip-F"+ee_case.get(2))));
		WebElement element =  driver.findElement(By.id("pii-slideshow-button-equip-F"+ee_case.get(2)));
		String slide = element.getText();
		System.out.println(slide);
		while (slide.contains("Show Slides(")==false)
		{
			Thread.sleep(1000);
			System.out.println(slide);
			slide = element.getText();
		}		
		System.out.println(slide);
		System.out.println(slide.indexOf("(") + "  "+ slide.indexOf(")"));
		String number= slide.substring(slide.indexOf("(")+1, slide.indexOf(")"));
		element.sendKeys(Keys.TAB);
		element.sendKeys(Keys.ENTER);
		driver.findElement(By.id("pii-slideshow-equip-F"+ee_case.get(2)+"-popup"));
		System.out.println(number);
		//Click on previous twice
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.SlidePreviousButton)).click();
		//Click on previous
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.SlidePreviousButton)).click();
		//Verify title of Related Links slide
		int number1 = Integer.parseInt(number)-1;
		try{
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+ee_case.get(2)+"']/ul/li["+number1+"]/div[2]/div/div"))).getText();
			softly.assertThat(s).as("test data").isEqualTo("Related Links");
		}catch(org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException t)
		{
			System.out.println("Related links slide not present");
		}
		//Verify title of 1st link
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+ee_case.get(2)+"']/ul/li["+number1+"]/div[2]/div[2]"))).getText();
		softly.assertThat(s1).as("test data").contains("1. Video");
		softly.assertThat(s1).as("test data").contains("Edited: "+videoLinkTitle1);
		//Closes the slideshow
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+ee_case.get(2)+"']/a"))).click();
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.EquipmentSearchClearButton)).click();
	}

	public void viewCaseInAdmin(WebDriver driver, List<String> eq_case, List<String> ee_case, String keyword_same_eq) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,20);
		ShareCheck obj = new ShareCheck();
		CreateHumanCase obj1 = new CreateHumanCase();
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.LoginNameOnTopRight)).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.AdminOption)).click();
		Thread.sleep(1000);
		//Clicks on Errorfree bank option
		if (driver.findElement(EquipCasesLink).isDisplayed()==false)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.ErrorFreeBankLink)).click();
		}
		//Clicks on Equipment cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink)).click();
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
		Thread.sleep(1000);
		obj.scrollToTop(driver);
		Thread.sleep(1000);
		//Enter FM case id with links
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSearchCaseIDAdmin)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSearchCaseIDAdmin)).sendKeys(ee_case.get(2));
		Thread.sleep(2000);
		//Clicks on case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSearchCaseIDDropdownAdmin)).click();
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
		//Enter Equipment Performance case id without links
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSearchCaseIDAdmin)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSearchCaseIDAdmin)).sendKeys(eq_case.get(2));
		Thread.sleep(2000);
		//Clicks on case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSearchCaseIDDropdownAdmin)).click();
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
		//Verify all fields
		verifyCaseFieldsInAdmin(driver, keyword_same_eq);
		Thread.sleep(1000);
		obj.scrollToTop(driver);
		Thread.sleep(1000);
		//Click on Edit
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseEditButton)).click();
		Thread.sleep(2000);
		obj.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSaveButton)).click();
		//Clicks on create case
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupConfirmButton)).click();
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
		Thread.sleep(1000);
		obj.scrollToTop(driver);
		Thread.sleep(1000);
		//Verify all fields
		verifyCaseFieldsInAdmin(driver, keyword_same_eq);
		//Verify new case form after viewing case with links
		verifyNewCaseForm(driver, ee_case.get(2));
	}

	public void verifyNewCaseForm(WebDriver driver, String caseID) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,40);
		ShareCheck obj = new ShareCheck();
		CreateHumanCase obj1 = new CreateHumanCase();
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.LoginNameOnTopRight)).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.AdminOption)).click();
		Thread.sleep(1000);
		//Clicks on Errorfree bank option
		if (driver.findElement(EquipCasesLink).isDisplayed()==false)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.ErrorFreeBankLink)).click();
		}
		//Clicks on Equip cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink)).click();
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
		Thread.sleep(1000);
		obj.scrollToTop(driver);
		Thread.sleep(1000);
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
		Thread.sleep(1000);
		obj.scrollToTop(driver);
		Thread.sleep(1000);
		//Enter case id with links
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSearchCaseIDAdmin)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSearchCaseIDAdmin)).sendKeys(caseID);
		Thread.sleep(2000);
		//Clicks on case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSearchCaseIDDropdownAdmin)).click();
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
		Thread.sleep(1000);
		obj.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on new case button
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewButton)).click();
		//Clicks on new case
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupConfirmButton)).click();
		//Verify Link title is empty
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink1Title)).getAttribute("textContent");
		softly.assertThat(s).as("test data").isEmpty();
		//Verify Link url is empty
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink1URL)).getAttribute("textContent");
		softly.assertThat(s1).as("test data").isEmpty();
		//Verify case id is empty
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseIDField)).getAttribute("textContent");
		softly.assertThat(s2).as("test data").isEmpty();
		//Verify questions is empty
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseQuestion)).getAttribute("textContent");
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		if (browserName.contains("internet")==true)
		{
			softly.assertThat(s3).as("test data").isEqualTo("Enter case question (max length: 160)");
		}
		else
			softly.assertThat(s3).as("test data").isEmpty();
		//Verify answer is empty
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseAnswer)).getAttribute("textContent");
		if (browserName.contains("internet")==true)
		{
			softly.assertThat(s4).as("test data").isEqualTo("Enter case answer");
		}
		else
			softly.assertThat(s4).as("test data").isEmpty();
		//Verify type is empty
		String s5 = driver.findElement(EquipCasesTypeList).getText();
		softly.assertThat(s5).as("test data").isEqualTo("");
		//Verify discipline is empty
		String s6 = driver.findElement(EquipCasesDisciplineList).getText();
		softly.assertThat(s6).as("test data").isEqualTo("");
		//Verify field is empty
		String s7 = driver.findElement(EquipCasesFieldList).getText();
		softly.assertThat(s7).as("test data").isEqualTo("");
		//Verify no keywords present
		try{
			WebDriverWait wait1 = new WebDriverWait(driver,4);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseExistingKeywordOnlyOne));
			softly.fail("keyword present in new form");
		}catch (org.openqa.selenium.TimeoutException r)
		{

		}
		Thread.sleep(1000);
		obj.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on Equip cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink)).click();
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
	}

	public void verifyCaseFieldsInAdmin(WebDriver driver, String keyword_same) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify Link title is empty
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink1Title)).getAttribute("textContent");
		softly.assertThat(s).as("test data").isEmpty();
		//Verify Link url is empty
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink1URL)).getAttribute("textContent");
		softly.assertThat(s1).as("test data").isEmpty();
		//Verify keyword
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseExistingKeywordOnlyOne)).getText();
		softly.assertThat(s2).as("test data").isEqualTo(keyword_same);
	}

	public void addKeywordEquip(WebDriver driver, String caseID, String keyword_same)throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		ShareCheck obj = new ShareCheck();
		Login obj1 = new Login();
		CreateHumanCase obj3 = new CreateHumanCase();
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.LoginNameOnTopRight)).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj3.AdminOption)).click();
		Thread.sleep(1000);
		//Clicks on Errorfree bank option
		if (driver.findElement(EquipCasesLink).isDisplayed()==false)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj3.ErrorFreeBankLink)).click();
		}
		//Clicks on Equipment cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink)).click();
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
		Thread.sleep(1000);
		obj.scrollToTop(driver);
		Thread.sleep(1000);
		//CLick on enter case id
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSearchCaseIDAdmin)).sendKeys(caseID);
		}catch(org.openqa.selenium.WebDriverException t)
		{
			Thread.sleep(1000);
			obj.scrollToTop(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSearchCaseIDAdmin)).sendKeys(caseID);
		}
		Thread.sleep(2000);
		//Clicks on case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSearchCaseIDDropdownAdmin)).click();
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
		Thread.sleep(1000);
		obj.scrollToTop(driver);
		Thread.sleep(1000);
		//Click on Edit
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseEditButton)).click();
		Thread.sleep(2000);
		//Scroll down
		try{
			jse.executeScript("scroll(0,2000)");
		}catch (org.openqa.selenium.ScriptTimeoutException r)
		{
			Thread.sleep(3000);
			jse.executeScript("scroll(0,2000)");
		}
		Thread.sleep(3000);
		//Add new keyword
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).clear();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).sendKeys(keyword_same);
		obj.loadingServer(driver);
		obj.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordAddButton)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordAddButton)).click();
		Thread.sleep(1000);
		obj.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSaveButton)).click();
		//Clicks on create case
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupConfirmButton)).click();
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
		Thread.sleep(1000);
		obj.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on Error free bank
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj3.ErrorFreeBankTopLink)).click();
		}catch (UnhandledAlertException f){			  
			driver.switchTo().alert().dismiss();
		}
	}

	public void addKeywordKALE2168(WebDriver driver, List<String> caseID, String keyword_same) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		ShareCheck obj = new ShareCheck();
		CaseBrowse obj2 = new CaseBrowse();
		//Add keyword
		addKeywordEquip(driver,caseID.get(2),keyword_same+"added");
		//Clicks on Equipment Performance Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.EquipmentPerformanceLink)).click();
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
		//Checks for search method with magnifying glass
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.EquipmentSearchKeywordField)).sendKeys(keyword_same+"added");
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseID.get(2))));
	}

	public void changeKeywordKALE1969(WebDriver driver, List<String> caseID, String keyword_same) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		ShareCheck obj = new ShareCheck();
		Login obj1 = new Login();
		CaseBrowse obj2 = new CaseBrowse();
		CreateHumanCase obj3 = new CreateHumanCase();
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.LoginNameOnTopRight)).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj3.AdminOption)).click();
		Thread.sleep(1000);
		//Clicks on Errorfree bank option
		if (driver.findElement(EquipCasesLink).isDisplayed()==false)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj3.ErrorFreeBankLink)).click();
		}
		//Clicks on Equipment cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink)).click();
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
		Thread.sleep(1000);
		obj.scrollToTop(driver);
		Thread.sleep(1000);
		//CLick on enter case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSearchCaseIDAdmin)).sendKeys(caseID.get(1));
		Thread.sleep(2000);
		//Clicks on case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSearchCaseIDDropdownAdmin)).click();
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
		Thread.sleep(1000);
		obj.scrollToTop(driver);
		Thread.sleep(1000);
		//Click on Edit
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseEditButton)).click();
		Thread.sleep(2000);
		//Scroll down
		try{
			jse.executeScript("scroll(0,2000)");
		}catch (org.openqa.selenium.ScriptTimeoutException r)
		{
			Thread.sleep(3000);
			jse.executeScript("scroll(0,2000)");
		}
		Thread.sleep(1000);
		//Click on added existing keyword
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseExistingKeywordOnlyOne)).click();
		Thread.sleep(2000);
		//Clicks on remove keyword
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupConfirmButton)).click();
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
		Thread.sleep(2000);
		//Scroll down
		try{
			jse.executeScript("scroll(0,2000)");
		}catch (org.openqa.selenium.ScriptTimeoutException r)
		{
			Thread.sleep(3000);
			jse.executeScript("scroll(0,2000)");
		}
		Thread.sleep(1000);
		//Add new keyword
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).sendKeys(keyword_same+"changed");
		Thread.sleep(1000);
		//Scroll down
		try{
			jse.executeScript("scroll(0,2000)");
		}catch (org.openqa.selenium.ScriptTimeoutException r)
		{
			Thread.sleep(3000);
			jse.executeScript("scroll(0,2000)");
		}
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordAddButton)).click();
		Thread.sleep(1000);
		obj.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSaveButton)).click();
		//Clicks on create case
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupConfirmButton)).click();
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
		Thread.sleep(1000);
		obj.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on Error free bank
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj3.ErrorFreeBankTopLink)).click();
		}catch (UnhandledAlertException f){			  
			driver.switchTo().alert().dismiss();
		}
		//Clicks on Human Performance Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.EquipmentPerformanceLink)).click();
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
		//Checks for search method with magnifying glass
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.EquipmentSearchKeywordField)).sendKeys(keyword_same+"changed");
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseID.get(1))));
	}

	public void clickTypesDisciplineIE(WebDriver driver, By element) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Get checkbox clicked or not value
		while(true)
		{
			Thread.sleep(1000);
			String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(element)).getAttribute("class");
			System.out.println(c1);
			if(c1.contains("ui-checkbox-on")==true)
				break;
			wait.until(ExpectedConditions.visibilityOfElementLocated(element)).click();
			Thread.sleep(1000);
		}
	}

	public void verifyTypesList(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verifies that list contains the required options
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListTypesAdvancedLearning)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Advanced Learning");
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListTypesCaseStudies)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Case Studies");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListTypesDesign)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Design");
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListTypesFailureModes)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("Failure Modes");
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListTypesFundamentals)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Fundamentals");
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListTypesGeneral)).getText();
		softly.assertThat(s5).as("test data").isEqualTo("General");
	}


	public List<String> selectTypes (WebDriver driver, int count, String title) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		List<String> categories = new ArrayList<String> ();
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		String v = cap.getVersion().toString();
		System.out.println(v);
		if (browserName.contains("internet")==true)
		{
			if (v.startsWith("10")==true)
			{
				//Type
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseTypes)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseTypes)).sendKeys(Keys.ENTER);
			}
			if (v.startsWith("11")==true)
			{
				//Type
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseTypes)).click();
			}
		}
		else{
			//Type
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseTypes)).click();
		}
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListBoxTypes));
		//Verify types list
		verifyTypesList(driver);
		if(title.equals(ee_title)||title.equals(ee_titleUS)||title.equals(ee_titleie11US)||title.equals(me_title)||title.equals(me_titleUS)||title.equals(me_titleie11US)||title.equals(me_titleie11)||title.equals(ee_titleie11))
		{
			if (browserName.contains("internet")==true)
			{
				clickTypesDisciplineIE(driver, EquipListTypesFailureModes);			    	
			}
			else
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListTypesFailureModes)).click();
		}
		if(count<5){
			if(title.equals(eq_title)||title.equals(eq_titleUS)||title.equals(eq_titleie11US)||title.equals(eq_titleie11))
			{
				if (browserName.contains("internet"))
				{
					clickTypesDisciplineIE(driver, EquipListTypesAdvancedLearning);			    	
				}
				else
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListTypesAdvancedLearning)).click();		 
			}
		}		
		//Choose a number between 1 and 6 for number of types
		Random random = new Random ();
		int y;
		if(count == 5){
			if(title.equals(eq_title)||title.equals(eq_titleUS)||title.equals(eq_titleie11US)||title.equals(eq_titleie11)){
				while(true)
				{
					y = random.nextInt(7);
					if(y==0)
						continue;
					break;
				}
				//Select the types
				for(int i=1;i<=y;i++)
				{
					int x;
					//Choose a number between 1 and 6
					while(true)
					{
						x = random.nextInt(7);
						if(x==0)
							continue;
						break;
					}
					if(x==1)
					{
						if(categories.contains("Advanced Learning")==false)
						{
							if (browserName.contains("internet"))
							{
								clickTypesDisciplineIE(driver, EquipListTypesAdvancedLearning);
							}
							else
								wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListTypesAdvancedLearning)).click();
							categories.add("Advanced Learning");
						}
					}
					if(x==2)
					{
						if(categories.contains("Case Studies")==false)
						{
							if (browserName.contains("internet"))
							{
								clickTypesDisciplineIE(driver, EquipListTypesCaseStudies);
							}
							else
								wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListTypesCaseStudies)).click();
							categories.add("Case Studies");
						}
					}
					if(x==3)
					{
						if(categories.contains("Design")==false)
						{
							if (browserName.contains("internet"))
							{
								clickTypesDisciplineIE(driver, EquipListTypesDesign);
							}
							else
								wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListTypesDesign)).click();
							categories.add("Design");
						}
					}
					if(x==4)
					{
						if(categories.contains("Failure Modes")==false)
						{
							if (browserName.contains("internet"))
							{
								clickTypesDisciplineIE(driver, EquipListTypesFailureModes);
							}
							else
								wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListTypesFailureModes)).click();
							categories.add("Failure Modes");
						}
					}
					if(x==5)
					{
						if(categories.contains("Fundamentals")==false)
						{
							if (browserName.contains("internet"))
							{
								clickTypesDisciplineIE(driver, EquipListTypesFundamentals);
							}
							else
								wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListTypesFundamentals)).click();
							categories.add("Fundamentals");
						}
					}
					if(categories.contains("General")==false)
					{
						if (browserName.contains("internet"))
						{
							clickTypesDisciplineIE(driver, EquipListTypesGeneral);
						}
						else
							wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListTypesGeneral)).click();
						categories.add("General");
					}
				}
			}}
		try{
			driver.findElement(ListCrossSymbol).click();
		}catch (NoSuchElementException | ElementNotInteractableException e)
		{
			driver.findElement(EquipListBoxTypesCrossSymbol).click();
		}
		return categories;
	}

	public void selectAllTypes (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		String v = cap.getVersion().toString();
		System.out.println(v);
		if (browserName.contains("internet")==true)
		{
			if (v.startsWith("10")==true)
			{
				//Type
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseTypes)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseTypes)).sendKeys(Keys.ENTER);
			}
			if (v.startsWith("11")==true)
			{
				//Type
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseTypes)).click();
			}
		}
		else{
			//Type
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseTypes)).click();
		}
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListBoxTypes));
		if (browserName.contains("internet"))
		{
			clickTypesDisciplineIE(driver, EquipListTypesAdvancedLearning);	
			clickTypesDisciplineIE(driver, EquipListTypesCaseStudies);
			clickTypesDisciplineIE(driver, EquipListTypesDesign);
			clickTypesDisciplineIE(driver, EquipListTypesFailureModes);
			clickTypesDisciplineIE(driver, EquipListTypesFundamentals);
			clickTypesDisciplineIE(driver, EquipListTypesGeneral);
		}
		else
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListTypesAdvancedLearning)).click();		
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListTypesCaseStudies)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListTypesDesign)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListTypesFailureModes)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListTypesFundamentals)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListTypesGeneral)).click();
		}
		try{
			driver.findElement(ListCrossSymbol).click();
		}catch (NoSuchElementException | ElementNotInteractableException e)
		{
			driver.findElement(EquipListBoxTypesCrossSymbol).click();
		}
	}

	public void searchFailurModeCaseWith2Discipline(WebDriver driver, String keyword, String caseId) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,40);
		CaseBrowse obj1 = new CaseBrowse();
		ShareCheck obj = new ShareCheck();
		CreateHumanCase obj2 = new CreateHumanCase ();
		Thread.sleep(1000);
		obj.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on Error free bank
		WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.ErrorFreeBankTopLink));
		element1.click();
		Thread.sleep(1000);
		try{
			//Go to  FM
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.FailureModeLink)).click();
		}catch(org.openqa.selenium.TimeoutException r)
		{
			element1.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.FailureModeLink)).click();
		}
		Thread.sleep(2000);
		//Check for case
		//Enters case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Clicks on case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId)));
		//Clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
	}

	public void searchCaseWithMultipleCategories(WebDriver driver, List<String> categories, String caseId) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,40);
		CaseBrowse obj1 = new CaseBrowse();
		ShareCheck obj = new ShareCheck();
		CreateHumanCase obj2 = new CreateHumanCase ();
		Thread.sleep(1000);
		obj.scrollToTop(driver);
		Thread.sleep(1000);
		if (categories.contains("Case Studies")||categories.contains("Advanced Learning")||categories.contains("General"))
		{
			//Clicks on Error free bank
			WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.ErrorFreeBankTopLink));
			element1.click();
			Thread.sleep(1000);
			//Go to Equipment Performance
			try{
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentPerformanceLink)).click();
			}catch (org.openqa.selenium.TimeoutException w)
			{
				Thread.sleep(1000);
				element1.click();
				Thread.sleep(1000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentPerformanceLink)).click();
			}
			Thread.sleep(1000);
			//Check for case
			//Enters case id
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchCaseIdField)).sendKeys(caseId);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchCaseIdField)).sendKeys(Keys.ENTER);
			//Wait for loading message to disappear
			obj.loadingServer(driver);
			//Clicks on case
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId)));
		}
		if (categories.contains("Failure Mode"))
		{
			//Clicks on Error free bank
			WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.ErrorFreeBankTopLink));
			element1.click();
			Thread.sleep(1000);
			//Go to  FM
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.FailureModeLink)).click();
			Thread.sleep(1000);
			//Check for case
			//Enters case id
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchCaseIdField)).sendKeys(caseId);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchCaseIdField)).sendKeys(Keys.ENTER);
			//Wait for loading message to disappear
			obj.loadingServer(driver);
			//Clicks on case
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId)));
		}
		if (categories.contains("Design"))
		{
			//Clicks on Error free bank
			WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.ErrorFreeBankTopLink));
			element1.click();
			Thread.sleep(1000);
			//Go to Prevention of Design Deficiencies
			wait.until(ExpectedConditions.visibilityOfElementLocated(PreventionOfDesignDeficienciesLink)).click();
			Thread.sleep(1000);
			//Check for case
			//Enters case id
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchCaseIdField)).sendKeys(caseId);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchCaseIdField)).sendKeys(Keys.ENTER);
			//Wait for loading message to disappear
			obj.loadingServer(driver);
			//Clicks on case
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId)));
		}
		if (categories.contains("Fundamentals"))
		{
			//Clicks on Error free bank
			WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.ErrorFreeBankTopLink));
			element1.click();
			Thread.sleep(1000);
			//Go to Engineering Fundamentals
			wait.until(ExpectedConditions.visibilityOfElementLocated(EngineeringFundamentalsLink)).click();
			Thread.sleep(1000);
			//Check for case
			//Enters case id
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchCaseIdField)).sendKeys(caseId);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchCaseIdField)).sendKeys(Keys.ENTER);
			//Wait for loading message to disappear
			obj.loadingServer(driver);
			//Clicks on case
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId)));
		}
	}

	public void verifyFieldsList(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verifies that list contains the required options
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListFieldsAuto)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Auto");
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListFieldsNuclear)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Nuclear");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListFieldsOther)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Other");
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListFieldsPharmaceutical)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("Pharmaceutical");
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListFieldsWelding)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Welding");
	}

	public void selectFields(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		String v = cap.getVersion().toString();
		if (browserName.contains("internet")==true)
		{
			if (v.startsWith("10")==true)
			{
				//Fields
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseFields)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseFields)).sendKeys(Keys.ENTER);
			}
			if (v.startsWith("11")==true)
			{
				//Fields
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseFields)).click();
			}
		}
		else{
			//Fields
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseFields)).click();
		}
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListBoxFields));	
		//Verify fields list
		verifyFieldsList(driver);
		//Choose a number between 1 and 5 for number of Fields
		Random random = new Random ();
		int x;
		//Choose a number between 1 and 5
		while(true)
		{
			x = random.nextInt(6);
			if(x==0)
				continue;
			break;
		}
		if(x==1)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListFieldsAuto)).click();			
		}
		if(x==2)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListFieldsNuclear)).click();				
		}
		if(x==3)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListFieldsOther)).click();			
		}
		if(x==4)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListFieldsPharmaceutical)).click();			
		}
		if(x==5)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListFieldsWelding)).click();			
		}
		try{
			driver.findElement(ListCrossSymbol).click();
		}catch (NoSuchElementException | ElementNotInteractableException e)
		{
			driver.findElement(EquipListBoxFieldsCrossSymbol).click();
		}
	}

	public void selectAllFields(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		String v = cap.getVersion().toString();
		if (browserName.contains("internet")==true)
		{
			if (v.startsWith("10")==true)
			{
				//Fields
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseFields)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseFields)).sendKeys(Keys.ENTER);
			}
			if (v.startsWith("11")==true)
			{
				//Fields
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseFields)).click();
			}
		}
		else{
			//Fields
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseFields)).click();
		}
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListBoxFields));	
		//Click all fields
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListFieldsAuto)).click();		
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListFieldsNuclear)).click();				
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListFieldsOther)).click();			
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListFieldsPharmaceutical)).click();			
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListFieldsWelding)).click();	
		try{
			driver.findElement(ListCrossSymbol).click();
		}catch (NoSuchElementException | ElementNotInteractableException e)
		{
			driver.findElement(EquipListBoxFieldsCrossSymbol).click();
		}
	}

	public void verifyDisciplineList(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verifies that list contains the required options
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListDisciplineElectrical)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Electrical");
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListDisciplineGeneral)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("General");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListDisciplineIC)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("I&C");
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListDisciplineMechanical)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("Mechanical");
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListDisciplineSoftware)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Software");
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListDisciplineStructural)).getText();
		softly.assertThat(s5).as("test data").isEqualTo("Structural");
	}

	public void selectRandomDiscipline(WebDriver driver, String browserName, String title) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Choose a number between 1 and 6 for number of Discipline
		Random random = new Random ();
		int x;
		//Choose a number between 1 and 6
		while(true)
		{
			x = random.nextInt(7);
			if(x==0)
				continue;
			//if title is ee or me then don't select ee or me
			if(title.equals(ee_title)||title.equals(ee_titleUS)||title.equals(ee_titleie11US)||title.equals(ee_titleie11)||(title.equals(me_title)||title.equals(me_titleUS)||title.equals(me_titleie11US)||title.equals(me_titleie11)))
			{
				if((x==1)||(x==4))
					continue;
			}
			break;
		}
		if(x==1)
		{
			if (browserName.contains("internet")==true)
			{
				clickTypesDisciplineIE(driver, EquipListDisciplineElectrical);
			}
			else
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListDisciplineElectrical)).click();			
		}
		if(x==2)
		{
			if (browserName.contains("internet")==true)
			{
				clickTypesDisciplineIE(driver, EquipListDisciplineGeneral);
			}
			else
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListDisciplineGeneral)).click();				
		}
		if(x==3)
		{
			if (browserName.contains("internet")==true)
			{
				clickTypesDisciplineIE(driver, EquipListDisciplineIC);
			}
			else
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListDisciplineIC)).click();			
		}
		if(x==4)
		{
			if (browserName.contains("internet")==true)
			{
				clickTypesDisciplineIE(driver, EquipListDisciplineMechanical);
			}
			else
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListDisciplineMechanical)).click();		
		}
		if(x==5)
		{
			if (browserName.contains("internet")==true)
			{
				clickTypesDisciplineIE(driver, EquipListDisciplineSoftware);
			}
			else
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListDisciplineSoftware)).click();			
		}
		if(x==6)
		{
			if (browserName.contains("internet")==true)
			{
				clickTypesDisciplineIE(driver, EquipListDisciplineStructural);
			}
			else
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListDisciplineStructural)).click();		
		}
	}

	public void selectDiscipline(WebDriver driver, String title, int count) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		String v = cap.getVersion().toString();
		if (browserName.contains("internet")==true)
		{
			if (v.startsWith("10")==true)
			{
				//Discipline
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseDiscipline)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseDiscipline)).sendKeys(Keys.ENTER);
			}
			if (v.startsWith("11")==true)
			{
				//Discipline
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseDiscipline)).click();
			}
		}
		else{
			//Discipline
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseDiscipline)).click();
		}
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListBoxDiscipline));	 
		//Verify Discipline list
		verifyDisciplineList(driver);
		if(title.equals(ee_title)||title.equals(ee_titleUS)||title.equals(ee_titleie11US)||title.equals(ee_titleie11))
		{
			if (browserName.contains("internet")==true)
			{
				clickTypesDisciplineIE(driver, EquipListDisciplineElectrical);
			}
			else
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListDisciplineElectrical)).click();		
		}
		if(title.equals(me_title)||title.equals(me_titleUS)||title.equals(me_titleie11US)||title.equals(me_titleie11))
		{
			if (browserName.contains("internet")==true)
			{
				clickTypesDisciplineIE(driver, EquipListDisciplineMechanical);
			}
			else
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListDisciplineMechanical)).click();	
		}
		if(title.equals(eq_title)||title.equals(eq_titleUS)||title.equals(eq_titleie11US)||title.equals(eq_titleie11))
		{
			selectRandomDiscipline(driver, browserName, title);
		}
		if(count == 5)
		{
			if(title.equals(ee_title)||title.equals(ee_titleUS)||title.equals(ee_titleie11US)||title.equals(ee_titleie11)||title.equals(me_title)||title.equals(me_titleUS)||title.equals(me_titleie11US)||title.equals(me_titleie11))
			{
				selectRandomDiscipline(driver, browserName, title);
			}
		}
		try{
			driver.findElement(ListCrossSymbol).click();
		}catch (NoSuchElementException | ElementNotInteractableException e)
		{
			driver.findElement(EquipListBoxDisciplineCrossSymbol).click();
		}
	}

	public void selectAllDiscipline(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		String v = cap.getVersion().toString();
		if (browserName.contains("internet")==true)
		{
			if (v.startsWith("10")==true)
			{
				//Discipline
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseDiscipline)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseDiscipline)).sendKeys(Keys.ENTER);
			}
			if (v.startsWith("11")==true)
			{
				//Discipline
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseDiscipline)).click();
			}
		}
		else{
			//Discipline
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseDiscipline)).click();
		}
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListBoxDiscipline));	 
		if (browserName.contains("internet")==true)
		{
			clickTypesDisciplineIE(driver, EquipListDisciplineElectrical);
			clickTypesDisciplineIE(driver, EquipListDisciplineGeneral);
			clickTypesDisciplineIE(driver, EquipListDisciplineIC);
			clickTypesDisciplineIE(driver, EquipListDisciplineMechanical);
			clickTypesDisciplineIE(driver, EquipListDisciplineSoftware);
			clickTypesDisciplineIE(driver, EquipListDisciplineStructural);
		}
		else
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListDisciplineElectrical)).click();	
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListDisciplineGeneral)).click();	
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListDisciplineIC)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListDisciplineMechanical)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListDisciplineSoftware)).click();	
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipListDisciplineStructural)).click();
		}
		try{
			driver.findElement(ListCrossSymbol).click();
		}catch (NoSuchElementException | ElementNotInteractableException e)
		{
			driver.findElement(EquipListBoxDisciplineCrossSymbol).click();
		}
	}

	public void searchEquipmentDatabankOnly(WebDriver driver, String keyword_same, List<String> caseId, String username, String password)throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,10);
		Login obj = new Login();
		ShareCheck obj1 = new ShareCheck();
		CaseBrowse obj2 = new CaseBrowse();
		//Logout as admin/new user
		obj.logout(driver);
		//If browser is firefox then switch to default content
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		if(browserName.equals("firefox"))
		{
			driver.switchTo().defaultContent();
		}
		Thread.sleep(4000);
		//Login as new user/admin
		int login = obj.LoginUser(driver, username, password);
		System.out.println("Title after login: "+driver.getTitle());
		Thread.sleep(5000);
		//Switches to the iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		try{
			if (login==1)
			{
				WebDriverWait wait2 = new WebDriverWait(driver,20);
				wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();
			}
		}catch (NoSuchElementException e){
			throw e;
		}
		Thread.sleep(5000);
		obj1.loadingServer(driver);
		//Click on Error-free bank link
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.ErrorFreeBankLink)).click();
		//Click on Databank Only
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.EquipmentDatabankOnlyLink1)).click();
		//Clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.EquipmentSearchClearButton)).click();
		//Select randomly type
		selectTypeGeneralInSearchCase(driver);
		//Search for keyword
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.EquipmentSearchKeywordField)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.EquipmentSearchKeywordField)).sendKeys(keyword_same);
		//Click 1st keyword in dropdown
		obj2.clickDropdownEquip(driver);
		//Wait for loading message
		obj1.loadingServer(driver);
		//Look for cases with keyword and type
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId.get(0))));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId.get(1))));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId.get(2))));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId.get(3))));
		//Click on search button
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.EquipmentSearchKeywordFieldSearchButton)).click();
		//Wait for loading message
		obj1.loadingServer(driver);
		//Look for cases with keyword and type
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId.get(0))));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId.get(1))));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId.get(2))));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId.get(3))));
		//Clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.EquipmentSearchClearButton)).click();
	}

	public void selectTypeGeneralInSearchCase(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		CaseBrowse obj = new CaseBrowse();
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		String v = cap.getVersion().toString();
		if (browserName.contains("internet")==true)
		{
			if (v.startsWith("10")==true)
			{
				//Types
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj.CaseSearchTypeBox));
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj.CaseSearchTypeBox)).sendKeys(Keys.ENTER);
			}
			if (v.startsWith("11")==true)
			{
				//Types
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj.CaseSearchTypeBox)).click();
			}
		}
		else{
			//Types
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj.CaseSearchTypeBox)).click();
		}
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.CaseSearchTypeList));
		if (browserName.contains("internet"))
		{
			clickTypesDisciplineIE(driver, obj.EquipCaseSearchListTypesAdvancedLearning);
		}
		else
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EquipCaseSearchListTypesAdvancedLearning)).click();
		//Close Types pop up
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.CaseSearchTypesPopupClose)).click();
	}

	public void searchEquipmentPerformanceAllFilters(WebDriver driver, String keyword_same, String caseId, String username, String password)throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,10);
		ShareCheck obj1 = new ShareCheck();
		CaseBrowse obj2 = new CaseBrowse();
		CreateHumanCase obj = new CreateHumanCase();
		//Click on Error-free bank link
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ErrorFreeBankTopLink)).click();
		//Go to Equipment Performance
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.EquipmentPerformanceLink)).click();
		Thread.sleep(1000);
		//Look for case in Equipment performance
		obj2.verifySearchOptionsEquip(driver, keyword_same+"joker", caseId);
		//Enters case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.EquipmentSearchCaseIdField)).sendKeys(caseId);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.EquipmentSearchCaseIdField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		obj1.loadingServer(driver);
		//Looks for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId)));
	}

	public void clickToShowNextRowForLink(WebDriver driver, By locator) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
		}catch(org.openqa.selenium.StaleElementReferenceException r)
		{
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
		}
	}

	public void addLinks(WebDriver driver, String title, String caseID) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		ShareCheck obj = new ShareCheck ();
		//Adding non video links first
		//Scroll to Link element
		WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink1Title));
		obj.scrollToElement(driver, l);
		//Enter title for link 3 coconut
		l.sendKeys(noVideoLinkTitle3);
		Thread.sleep(1000);
		//Enter url 3
		wait.until(ExpectedConditions.elementToBeClickable(EquipCasesLink1URL)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink1URL)).sendKeys(noVideoLink);	
		//To make url form appear click on title for link 1
		clickToShowNextRowForLink(driver,EquipCasesLink1Title);
		obj.scrollToTop(driver);
		Thread.sleep(1000);
		//Scroll to link 2
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink2Title));
		obj.scrollToElement(driver, l);
		//Enter title for link 2 banana
		l.sendKeys(noVideoLinkTitle2);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink2URL)).click();
		//Link 2 becomes Link 1
		//Enter url 2
		wait.until(ExpectedConditions.elementToBeClickable(EquipCasesLink1URL)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink1URL)).sendKeys(noVideoLink);
		//To make url form appear click on title for link
		clickToShowNextRowForLink(driver,EquipCasesLink1Title);
		obj.scrollToTop(driver);
		//Scroll to link 3
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink3Title));
		obj.scrollToElement(driver, l);
		//Enter title for link 1 apple
		l.sendKeys(noVideoLinkTitle1);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink3URL)).click();
		//Link 3 becomes Link 1
		//Enter url 3
		wait.until(ExpectedConditions.elementToBeClickable(EquipCasesLink1URL)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink1URL)).sendKeys(noVideoLink);
		//To make url form appear click on title for link
		clickToShowNextRowForLink(driver,EquipCasesLink1Title);
		obj.scrollToTop(driver);
		/*
		//For firefox 
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		if(browserName.equals("firefox"))
		{
			//Save case edit case and then 
			addLink2FirefoxBrowser(driver,caseID);
		}*/
		//Adding video links
		//Enter title for link 4 : video link 1
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink4Title));
		obj.scrollToElement(driver, l);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink4Title)).sendKeys(videoLinkTitle1);
		Thread.sleep(1000);
		//Enter url 4
		wait.until(ExpectedConditions.elementToBeClickable(EquipCasesLink4URL)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink4URL)).sendKeys(videoLink);
		//Move to video checkbox
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink4VideoCheckbox));
		obj.scrollToElement(driver, l);
		//Click on video checkbox
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink4VideoCheckbox)).click();
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink4VideoCheckbox));
		obj.scrollToElement(driver, l);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink4VideoCheckbox)).click();
		Thread.sleep(1000);
		//verify video link became the first link
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink1Title)).getAttribute("value");
		softly.assertThat(s).as("test data").contains(videoLinkTitle1);
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink1URL)).getAttribute("value");
		softly.assertThat(s1).as("test data").contains(videoLink);
		//Enter title for link 5 : video link 2
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink5Title));
		obj.scrollToElement(driver, l);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink5Title)).sendKeys(videoLinkTitle2);	
		Thread.sleep(1000);
		//Enter url 5
		wait.until(ExpectedConditions.elementToBeClickable(EquipCasesLink5URL)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink5URL)).sendKeys(videoLink);
		//Move to viedo checkbox
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink5VideoCheckbox));
		obj.scrollToElement(driver, l);
		//Click on video checkbox
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink5VideoCheckbox)).click();
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink5VideoCheckbox));
		obj.scrollToElement(driver, l);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink5VideoCheckbox)).click();
		Thread.sleep(1000);
		//verify video link became the first link
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink2Title)).getAttribute("value");
		softly.assertThat(s3).as("test data").contains(videoLinkTitle2);
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink2URL)).getAttribute("value");
		softly.assertThat(s4).as("test data").contains(videoLink);
		//Enter title for link 6 : video link 3
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink6Title));
		obj.scrollToElement(driver, l);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink6Title)).sendKeys(videoLinkTitle3);	
		Thread.sleep(1000);
		//Enter url 5
		wait.until(ExpectedConditions.elementToBeClickable(EquipCasesLink6URL)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink6URL)).sendKeys(videoLink);
		//Move to video checkbox
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink6VideoCheckbox));
		obj.scrollToElement(driver, l);
		//Click on video checkbox
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink6VideoCheckbox)).click();
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink6VideoCheckbox));
		obj.scrollToElement(driver, l);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink6VideoCheckbox)).click();
		Thread.sleep(1000);
		//verify video link became the first link
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink3Title)).getAttribute("value");
		softly.assertThat(s5).as("test data").contains(videoLinkTitle3);
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink3URL)).getAttribute("value");
		softly.assertThat(s6).as("test data").contains(videoLink);
		//Scroll to link 7
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink7Title));
		obj.scrollToElement(driver, l);
		//Enter title for link 7
		l.sendKeys(noVideoLinkTitle4);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink7URL)).click();
		//Enter url 7
		wait.until(ExpectedConditions.elementToBeClickable(EquipCasesLink7URL)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink7URL)).sendKeys(noVideoLink);
		//To make url form appear click on title for link
		clickToShowNextRowForLink(driver,EquipCasesLink7Title);
		obj.scrollToTop(driver);
		//Scroll to link 8
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink8Title));
		obj.scrollToElement(driver, l);
		//Enter title for link 8
		l.sendKeys(noVideoLinkTitle5);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink8URL)).click();
		//Enter url 8
		wait.until(ExpectedConditions.elementToBeClickable(EquipCasesLink8URL)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink8URL)).sendKeys(noVideoLink);
		//To make url form appear click on title for link
		clickToShowNextRowForLink(driver,EquipCasesLink8Title);
		obj.scrollToTop(driver);
		//Scroll to link 9
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink9Title));
		obj.scrollToElement(driver, l);
		//Enter title for link 9
		l.sendKeys(noVideoLinkTitle6);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink9URL)).click();
		//Enter url 9
		wait.until(ExpectedConditions.elementToBeClickable(EquipCasesLink9URL)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink9URL)).sendKeys(noVideoLink);
		//To make url form appear click on title for link
		clickToShowNextRowForLink(driver,EquipCasesLink9Title);
		obj.scrollToTop(driver);
		//Scroll to link 10
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink10Title));
		obj.scrollToElement(driver, l);
		//Enter title for link 10
		l.sendKeys(noVideoLinkTitle7);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink10URL)).click();
		//Enter url 10
		wait.until(ExpectedConditions.elementToBeClickable(EquipCasesLink10URL)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink10URL)).sendKeys(noVideoLink);
		//To make url form appear click on title for link
		clickToShowNextRowForLink(driver,EquipCasesLink10Title);
		obj.scrollToTop(driver);
		//Scroll to link 11
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink11Title));
		obj.scrollToElement(driver, l);
		//Enter title for link 11
		l.sendKeys(noVideoLinkTitle8);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink11URL)).click();
		//Enter url 11
		wait.until(ExpectedConditions.elementToBeClickable(EquipCasesLink11URL)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink11URL)).sendKeys(noVideoLink);
		//To make url form appear click on title for link
		clickToShowNextRowForLink(driver,EquipCasesLink11Title);
		obj.scrollToTop(driver);
		//Scroll to link 12
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink12Title));
		obj.scrollToElement(driver, l);
		//Enter title for link 12
		l.sendKeys(noVideoLinkTitle9);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink12URL)).click();
		//Enter url 12
		wait.until(ExpectedConditions.elementToBeClickable(EquipCasesLink12URL)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink12URL)).sendKeys(noVideoLink);
		//To make url form appear click on title for link
		clickToShowNextRowForLink(driver,EquipCasesLink12Title);
		obj.scrollToTop(driver);
		//Scroll to link 13
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink13Title));
		obj.scrollToElement(driver, l);
		//Enter title for link 13
		l.sendKeys(noVideoLinkTitle10);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink13URL)).click();
		//Enter url 13
		wait.until(ExpectedConditions.elementToBeClickable(EquipCasesLink13URL)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink13URL)).sendKeys(noVideoLink);
		//To make url form appear click on title for link
		clickToShowNextRowForLink(driver,EquipCasesLink13Title);
		obj.scrollToTop(driver);
	}

	public void addLink2FirefoxBrowser(WebDriver driver, String caseId)throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,10);
		ShareCheck obj = new ShareCheck();
		//Save case
		obj.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSaveButton)).click();
		//Clicks on create case
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupConfirmButton)).click();
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
		//Click on enter case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSearchCaseIDAdmin)).sendKeys(caseId);
		Thread.sleep(2000);
		//Clicks on case id
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSearchCaseIDDropdownAdmin)).click();
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
		//Click on edi button
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseEditButton)).click();
	}

	public void addKeywordToLinkCaseAndSearchInEquipmentDatabank(WebDriver driver, List<String> caseID, String existingKeyword) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		ShareCheck obj = new ShareCheck();
		Login obj1 = new Login();
		CaseBrowse obj2 = new CaseBrowse();
		CreateHumanCase obj3 = new CreateHumanCase();
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.LoginNameOnTopRight)).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj3.AdminOption)).click();
		Thread.sleep(1000);
		//Clicks on Errorfree bank option
		if (driver.findElement(EquipCasesLink).isDisplayed()==false)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj3.ErrorFreeBankLink)).click();
		}
		//Clicks on Equipment cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink)).click();
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
		Thread.sleep(1000);
		obj.scrollToTop(driver);
		Thread.sleep(1000);
		//CLick on enter case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSearchCaseIDAdmin)).sendKeys(caseID.get(2));
		Thread.sleep(2000);
		//Clicks on case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSearchCaseIDDropdownAdmin)).click();
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
		Thread.sleep(1000);
		obj.scrollToTop(driver);
		Thread.sleep(1000);
		//Click on Edit
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseEditButton)).click();
		Thread.sleep(2000);
		//Scroll down
		try{
			jse.executeScript("scroll(0,2000)");
		}catch (org.openqa.selenium.ScriptTimeoutException r)
		{
			Thread.sleep(3000);
			jse.executeScript("scroll(0,2000)");
		}
		Thread.sleep(1000);
		//Add existing keyword
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).sendKeys(existingKeyword);
		Thread.sleep(1500);
		//Scroll down
		try{
			jse.executeScript("scroll(0,2000)");
		}catch (org.openqa.selenium.ScriptTimeoutException r)
		{
			Thread.sleep(3000);
			jse.executeScript("scroll(0,2000)");
		}
		Thread.sleep(1000);
		WebElement element = driver.findElement(EquipCaseKeywordExistingList);
		element.findElement(obj3.FirstAndLastChildInList).click();
		Thread.sleep(1000);
		obj.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSaveButton)).click();
		//Clicks on create case
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupConfirmButton)).click();
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
		Thread.sleep(1000);
		obj.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on Error free bank
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj3.ErrorFreeBankTopLink)).click();
		}catch (UnhandledAlertException f){			  
			driver.switchTo().alert().dismiss();
		}
		//Clicks on Equipment Databank
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.EquipmentDatabankOnlyLink1)).click();
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.EquipmentSearchClearButton)).click();
		//Checks for search method with magnifying glass
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.EquipmentSearchKeywordField)).sendKeys(existingKeyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseID.get(2))));
		verifyCaseWithLinks(driver, caseID);
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.EquipmentSearchClearButton)).click();
		//Enters keyword and search with dropdown
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.EquipmentSearchKeywordField)).sendKeys(existingKeyword);
		Thread.sleep(2000);
		obj2.clickDropdownEquip(driver);	  
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseID.get(2))));
		verifyCaseWithLinks(driver, caseID);
	}

	public void searchCaseWithSameKeywordWithAndWithoutLinksInEquipDatabank(WebDriver driver, String keyword, List<String>ee_cases)throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,10);
		CaseBrowse obj1 = new CaseBrowse();
		ShareCheck obj = new ShareCheck();
		CreateHumanCase obj2 = new CreateHumanCase ();
		//Clicks on Error free bank
		WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.ErrorFreeBankTopLink));
		element1.click();
		//Go to Equipment Databank Only
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentDatabankOnlyLink1)).click();
		Thread.sleep(1000);
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
		//Check for case
		//Enters keyword and search with ENTER
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		obj.loadingServer(driver);		  
		//Verify cases with links and without links with same keyword
		for(int i=0;i<ee_cases.size();i++)
		{
			//Verify case with links for i=2
			if(i==2)
				verifyCaseWithLinks(driver, ee_cases);
			else{
				//Verify all cases without links
				verifyCasesWithoutLinks(driver, ee_cases.get(i));
			}			  
		}
		//Scroll up
		Thread.sleep(2000);
		obj.scrollToTop(driver);
		Thread.sleep(1000);
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
		//Enters keyword and search with dropdown
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(keyword);
		Thread.sleep(2000);
		obj1.clickDropdownEquip(driver);	  
		//Verify cases with links and without links with same keyword
		for(int i=0;i<ee_cases.size();i++)
		{
			//Verify case with links for i=2
			if(i==2)
				verifyCaseWithLinks(driver, ee_cases);
			else{
				//Verify all cases without links
				verifyCasesWithoutLinks(driver, ee_cases.get(i));
			}			  
		}
		//Scroll up
		Thread.sleep(1000);
		obj.scrollToTop(driver);
		Thread.sleep(1000);
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
	}

	public void verifyCasesWithoutLinks (WebDriver driver, String caseId) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,5);
		CaseBrowse obj1 = new CaseBrowse();  
		ShareCheck obj = new ShareCheck();
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Move to case collapsible
		WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId)));
		obj.scrollToElement(driver, l);
		//Click on collapsible 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId))).click();
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Move to show slides button
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-button-equip-F"+caseId)));
		obj.scrollToElement(driver, l);
		//Clicks on Show Slides
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-button-equip-F"+caseId)));
		WebElement element =  driver.findElement(By.id("pii-slideshow-button-equip-F"+caseId));
		String slide = element.getText();
		System.out.println(slide);
		while (slide.contains("Show Slides(")==false)
		{
			Thread.sleep(1000);
			System.out.println(slide);
			slide = element.getText();
		}		
		System.out.println(slide);
		System.out.println(slide.indexOf("(") + "  "+ slide.indexOf(")"));
		String number= slide.substring(slide.indexOf("(")+1, slide.indexOf(")"));
		element.sendKeys(Keys.TAB);
		element.sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-equip-F"+caseId+"-popup")));
		System.out.println(number);
		Thread.sleep(1000);
		//Wait for pop up
		//Click on previous
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.SlidePreviousButton)).click();
		}catch(org.openqa.selenium.TimeoutException |org.openqa.selenium.NoSuchElementException r)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+caseId+"']/a[2]"))).click();
		}
		//Verify title of Related Links slide doesnt exist		
		try{
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+caseId+"']/ul/li["+Integer.parseInt(number)+"]/div[2]/div[1]/div"))).getText();
		softly.assertThat(s2).as("test data").doesNotContain("Related Links");
		}catch (org.openqa.selenium.TimeoutException t)
		{
			System.out.println("No related links slide");
		}
		//Closes the slideshow
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+caseId+"']/a"))).click();
		//Scroll to element
		obj.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId))));
		//Click on collapsible to close 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId))).click();
	}

	public void verifyCaseWithLinks (WebDriver driver, List<String>cases) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,5);
		CaseBrowse obj1 = new CaseBrowse();  
		ShareCheck obj = new ShareCheck();
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Move to case collapsible
		WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+cases.get(2))));
		obj.scrollToElement(driver, l);
		//Click on collapsible 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+cases.get(2)))).click();
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Move to show slides button
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-button-equip-F"+cases.get(2))));
		obj.scrollToElement(driver, l);
		//Clicks on Show Slides
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-button-equip-F"+cases.get(2))));
		WebElement element =  driver.findElement(By.id("pii-slideshow-button-equip-F"+cases.get(2)));
		String slide = element.getText();
		System.out.println(slide);
		while (slide.contains("Show Slides(")==false)
		{
			Thread.sleep(1000);
			System.out.println(slide);
			slide = element.getText();
		}		
		System.out.println(slide);
		System.out.println(slide.indexOf("(") + "  "+ slide.indexOf(")"));
		String number= slide.substring(slide.indexOf("(")+1, slide.indexOf(")"));
		element.sendKeys(Keys.TAB);
		element.sendKeys(Keys.ENTER);
		driver.findElement(By.id("pii-slideshow-equip-F"+cases.get(2)+"-popup"));
		System.out.println(number);
		//Click on previous
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.SlidePreviousButton)).click();
		}catch(org.openqa.selenium.TimeoutException |org.openqa.selenium.NoSuchElementException r)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+cases.get(2)+"']/a[2]"))).click();
		}
		//View 2nd page of related links
		//Verify title of 1st link with no video
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+cases.get(2)+"']/ul/li["+Integer.parseInt(number)+"]/div[2]/div[2]"))).getText();
		softly.assertThat(s10).as("test data").contains("10. ");
		softly.assertThat(s10).as("test data").contains(noVideoLinkTitle7);
		//Verify title of 2nd link with no video
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+cases.get(2)+"']/ul/li["+Integer.parseInt(number)+"]/div[2]/div[3]"))).getText();
		softly.assertThat(s11).as("test data").contains("11. ");
		softly.assertThat(s11).as("test data").contains(noVideoLinkTitle8);
		//Verify title of 3rd link with no video
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+cases.get(2)+"']/ul/li["+Integer.parseInt(number)+"]/div[2]/div[4]"))).getText();
		softly.assertThat(s12).as("test data").contains("12. ");
		softly.assertThat(s12).as("test data").contains(noVideoLinkTitle9);
		//Verify title of 4th link with no video
		String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+cases.get(2)+"']/ul/li["+Integer.parseInt(number)+"]/div[2]/div[5]"))).getText();
		softly.assertThat(s13).as("test data").contains("13. ");
		softly.assertThat(s13).as("test data").contains(noVideoLinkTitle10);
		//Click on previous
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.SlidePreviousButton)).click();
		}catch(org.openqa.selenium.TimeoutException |org.openqa.selenium.NoSuchElementException r)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+cases.get(2)+"']/a[2]"))).click();
		}
		int number1 = Integer.parseInt(number)-1;
		//Verify title of Related Links slide
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+cases.get(2)+"']/ul/li["+number1+"]/div[2]/div[1]/div"))).getText();
		softly.assertThat(s).as("test data").isEqualTo("Related Links");
		//Verify title of 1st link with video
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+cases.get(2)+"']/ul/li["+number1+"]/div[2]/div[2]"))).getText();
		softly.assertThat(s1).as("test data").contains("1. Video: ");
		softly.assertThat(s1).as("test data").contains(videoLinkTitle1);
		//Verify title of 2nd link with video
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+cases.get(2)+"']/ul/li["+number1+"]/div[2]/div[3]"))).getText();
		softly.assertThat(s2).as("test data").contains("2. Video: ");
		softly.assertThat(s2).as("test data").contains(videoLinkTitle2);
		//Verify title of 3rd link with video
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+cases.get(2)+"']/ul/li["+number1+"]/div[2]/div[4]"))).getText();
		softly.assertThat(s3).as("test data").contains("3. Video: ");
		softly.assertThat(s3).as("test data").contains(videoLinkTitle3);
		//Verify title of 4th link with no video
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+cases.get(2)+"']/ul/li["+number1+"]/div[2]/div[5]"))).getText();
		softly.assertThat(s4).as("test data").contains("4. ");
		softly.assertThat(s4).as("test data").contains(noVideoLinkTitle1);
		//Verify title of 5th link with no video
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+cases.get(2)+"']/ul/li["+number1+"]/div[2]/div[6]"))).getText();
		softly.assertThat(s5).as("test data").contains("5. ");
		softly.assertThat(s5).as("test data").contains(noVideoLinkTitle2);
		//Verify title of 6th link with no video
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+cases.get(2)+"']/ul/li["+number1+"]/div[2]/div[7]"))).getText();
		softly.assertThat(s6).as("test data").contains("6. ");
		softly.assertThat(s6).as("test data").contains(noVideoLinkTitle3);
		//Verify title of 4th link with no video
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+cases.get(2)+"']/ul/li["+number1+"]/div[2]/div[8]"))).getText();
		softly.assertThat(s7).as("test data").contains("7. ");
		softly.assertThat(s7).as("test data").contains(noVideoLinkTitle4);
		//Verify title of 5th link with no video
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+cases.get(2)+"']/ul/li["+number1+"]/div[2]/div[9]"))).getText();
		softly.assertThat(s8).as("test data").contains("8. ");
		softly.assertThat(s8).as("test data").contains(noVideoLinkTitle5);
		//Verify title of 6th link with no video
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+cases.get(2)+"']/ul/li["+number1+"]/div[2]/div[10]"))).getText();
		softly.assertThat(s9).as("test data").contains("9. ");
		softly.assertThat(s9).as("test data").contains(noVideoLinkTitle6);
		//Closes the slideshow
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+cases.get(2)+"']/a"))).click();
	}

	public void slideSecurityOnTest(WebDriver driver, String keyword, List<String>cases, String title, String username)throws Exception{

		//change slide security off to on
		changeSlideSecurity(driver,username, 1);
		//Search for case and click on link
		searchCaseWithLinks(driver,keyword,cases,title);
		//change slide security on to off
		changeSlideSecurity(driver,username, 0);
	}

	public void changeSlideSecurity(WebDriver driver, String username, int x)throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,10);
		ShareCheck obj = new ShareCheck();
		Login obj1 = new Login();
		CreateHumanCase obj2 = new CreateHumanCase();
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.LoginNameOnTopRight)).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.AdminOption)).click();
		Thread.sleep(1000);
		if(driver.findElement(By.id("pii-admin-customers-button")).isDisplayed()==false)
		{
			//Click on Accounts
			driver.findElement(By.xpath(".//*[@id='pii-admin-accounts']/h3/a")).click();
		}
		//Clicks on Edit user
		driver.findElement(By.id("pii-admin-user-edit")).click();
		//Wait for loading message
		obj.loadingServer(driver);
		//Searches for newly created user
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-user-list']/form/div/input"))).clear();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-user-list']/form/div/input"))).sendKeys(username);
		driver.findElement(By.xpath(".//*[@id='pii-admin-user-list']/form/div/input")).sendKeys(Keys.ENTER);
		//Wait for loading message
		obj.loadingServer(driver);
		//Selects the newly created user
		WebElement select = driver.findElement(By.id("pii-admin-user-list"));
		WebElement option = select.findElement(By.cssSelector(".ui-first-child"));
		option.click();
		//Wait for loading message
		obj.loadingServer(driver);
		WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-admin-user-slidesecurity-on']")));
		obj.scrollToElement(driver, l);
		if(x==1)
		{
			//Turn slide security on
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-admin-user-slidesecurity-on']"))).click();
		}
		if(x==0)
		{
			//Turn slide security off
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-admin-user-slidesecurity-off']"))).click();
		}
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		Thread.sleep(1000);
		obj.scrollToTop(driver);
		Thread.sleep(1000);
		//Click on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-button-save"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-confirmed"))).click();
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		Thread.sleep(1000);
		obj.scrollToTop(driver);
		Thread.sleep(1000);
	}

	public void searchCaseWithLinks(WebDriver driver, String keyword, List<String>cases, String title)throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,10);
		CaseBrowse obj1 = new CaseBrowse();
		ShareCheck obj = new ShareCheck();
		CreateHumanCase obj2 = new CreateHumanCase ();
		Thread.sleep(1000);
		obj.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on Error free bank
		WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.ErrorFreeBankTopLink));
		element1.click();
		Thread.sleep(1000);
		try{
			//Go to  FM
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.FailureModeLink)).click();
		}catch(org.openqa.selenium.TimeoutException r)
		{
			Thread.sleep(1000);
			obj.scrollToTop(driver);
			Thread.sleep(1000);
			element1.click();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.FailureModeLink)).click();
		}
		Thread.sleep(1000);
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
		//Check for case
		//Enters case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Click on collapsible 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+cases.get(2)))).click();
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Get window id
		String window = driver.getWindowHandle();
		//Clicks on Show Slides
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-button-equip-F"+cases.get(2))));
		WebElement element =  driver.findElement(By.id("pii-slideshow-button-equip-F"+cases.get(2)));
		String slide = element.getText();
		System.out.println(slide);
		while (slide.contains("Show Slides(")==false)
		{
			Thread.sleep(1000);
			System.out.println(slide);
			slide = element.getText();
		}		
		System.out.println(slide);
		System.out.println(slide.indexOf("(") + "  "+ slide.indexOf(")"));
		String number= slide.substring(slide.indexOf("(")+1, slide.indexOf(")"));
		element.sendKeys(Keys.TAB);
		element.sendKeys(Keys.ENTER);
		driver.findElement(By.id("pii-slideshow-equip-F"+cases.get(2)+"-popup"));
		System.out.println(number);
		//View 2nd page of related links
		//Click on previous
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.SlidePreviousButton)).click();
		//Verify title of Related Links slide
		String s14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+cases.get(2)+"']/ul/li["+Integer.parseInt(number)+"]/div[2]/div/div"))).getText();
		softly.assertThat(s14).as("test data").isEqualTo("Related Links");
		//Verify title of 1st link with video
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+cases.get(2)+"']/ul/li["+Integer.parseInt(number)+"]/div[2]/div[2]"))).getText();
		softly.assertThat(s10).as("test data").contains("10. ");
		softly.assertThat(s10).as("test data").contains(noVideoLinkTitle7);
		//Verify title of 2nd link with video
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+cases.get(2)+"']/ul/li["+Integer.parseInt(number)+"]/div[2]/div[3]"))).getText();
		softly.assertThat(s11).as("test data").contains("11. ");
		softly.assertThat(s11).as("test data").contains(noVideoLinkTitle8);
		//Verify title of 3rd link with video
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+cases.get(2)+"']/ul/li["+Integer.parseInt(number)+"]/div[2]/div[4]"))).getText();
		softly.assertThat(s12).as("test data").contains("12. ");
		softly.assertThat(s12).as("test data").contains(noVideoLinkTitle9);
		//Verify title of 4th link with no video
		String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+cases.get(2)+"']/ul/li["+Integer.parseInt(number)+"]/div[2]/div[5]"))).getText();
		softly.assertThat(s13).as("test data").contains("13. ");
		softly.assertThat(s13).as("test data").contains(noVideoLinkTitle10);
		//Verify slide attributes
		verifyAttributesOfSlide (driver,cases,title,Integer.parseInt(number),number);
		//Click on 1st link
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+cases.get(2)+"']/ul/li["+Integer.parseInt(number)+"]/div[2]/div[2]/a"))).click();
		Thread.sleep(2000);
		//Switch window
		switchWindow(driver,window);
		//View 1st page of related links
		//Click on previous
		int number1 = (Integer.parseInt(number))-1;
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.SlidePreviousButton)).click();
		//Verify title of Related Links slide
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+cases.get(2)+"']/ul/li["+number1+"]/div[2]/div/div"))).getText();
		softly.assertThat(s).as("test data").isEqualTo("Related Links");
		//Verify title of 1st link with video
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+cases.get(2)+"']/ul/li["+number1+"]/div[2]/div[2]"))).getText();
		softly.assertThat(s1).as("test data").contains("1. Video: ");
		softly.assertThat(s1).as("test data").contains(videoLinkTitle1);
		//Verify title of 2nd link with video
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+cases.get(2)+"']/ul/li["+number1+"]/div[2]/div[3]"))).getText();
		softly.assertThat(s2).as("test data").contains("2. Video: ");
		softly.assertThat(s2).as("test data").contains(videoLinkTitle2);
		//Verify title of 3rd link with video
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+cases.get(2)+"']/ul/li["+number1+"]/div[2]/div[4]"))).getText();
		softly.assertThat(s3).as("test data").contains("3. Video: ");
		softly.assertThat(s3).as("test data").contains(videoLinkTitle3);
		//Verify title of 4th link with no video
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+cases.get(2)+"']/ul/li["+number1+"]/div[2]/div[5]"))).getText();
		softly.assertThat(s4).as("test data").contains("4. ");
		softly.assertThat(s4).as("test data").contains(noVideoLinkTitle1);
		//Verify title of 5th link with no video
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+cases.get(2)+"']/ul/li["+number1+"]/div[2]/div[6]"))).getText();
		softly.assertThat(s5).as("test data").contains("5. ");
		softly.assertThat(s5).as("test data").contains(noVideoLinkTitle2);
		//Verify title of 6th link with no video
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+cases.get(2)+"']/ul/li["+number1+"]/div[2]/div[7]"))).getText();
		softly.assertThat(s6).as("test data").contains("6. ");
		softly.assertThat(s6).as("test data").contains(noVideoLinkTitle3);
		//Verify title of 4th link with no video
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+cases.get(2)+"']/ul/li["+number1+"]/div[2]/div[8]"))).getText();
		softly.assertThat(s7).as("test data").contains("7. ");
		softly.assertThat(s7).as("test data").contains(noVideoLinkTitle4);
		//Verify title of 5th link with no video
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+cases.get(2)+"']/ul/li["+number1+"]/div[2]/div[9]"))).getText();
		softly.assertThat(s8).as("test data").contains("8. ");
		softly.assertThat(s8).as("test data").contains(noVideoLinkTitle5);
		//Verify title of 6th link with no video
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+cases.get(2)+"']/ul/li["+number1+"]/div[2]/div[10]"))).getText();
		softly.assertThat(s9).as("test data").contains("9. ");
		softly.assertThat(s9).as("test data").contains(noVideoLinkTitle6);
		//Verify slide attributes
		verifyAttributesOfSlide (driver,cases,title,number1,number);
		Thread.sleep(2000);
		//Click on 1st link
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+cases.get(2)+"']/ul/li["+number1+"]/div[2]/div[2]/a"))).click();
		Thread.sleep(2000);
		//Switch window
		switchWindow(driver,window);
		//Click on 4th link
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+cases.get(2)+"']/ul/li["+number1+"]/div[2]/div[5]/a"))).click();
		Thread.sleep(2000);
		//Switch window
		switchWindow(driver,window);
		//Closes the slideshow
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+cases.get(2)+"']/a"))).click();
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
	}

	public void verifyAttributesOfSlide(WebDriver driver, List<String> cases, String title, int number1, String numberAll) throws Exception {

		CaseBrowse obj1 = new CaseBrowse();
		//Verify title of slide
		String expected_title = "F"+cases.get(2)+": "+title;
		String title_xpath = ".//*[@id='pii-slideshow-equip-F"+cases.get(2)+"']/ul/li["+number1+"]/div[1]";
		String actual_title = driver.findElement(By.xpath(title_xpath)).getAttribute("textContent");
		softly.assertThat(actual_title).as("test data").isEqualTo(expected_title);
		//Checking if copyright is correct
		String copyright_xpath = ".//*[@id='pii-slideshow-equip-F"+cases.get(2)+"']/ul/li["+number1+"]/span/span[1]";
		String actual_copyright = driver.findElement(By.xpath(copyright_xpath)).getAttribute("textContent");
		if(driver.getCurrentUrl().contains("kaleqa"))
			softly.assertThat(actual_copyright).as("test data").isEqualTo(obj1.expected_copyright);
		else
			softly.assertThat(actual_copyright).as("test data").isEqualTo(obj1.expected_copyright1);
		//Checking if footer image appears
		String image_xpath = ".//*[@id='pii-slideshow-equip-F"+cases.get(2)+"']/ul/li["+number1+"]/span/img";
		if(driver.findElement(By.xpath(image_xpath)).isDisplayed())
			System.out.println("Logo is displayed");
		//Checking if slide number appears and is correct
		String slide_xpath = ".//*[@id='pii-slideshow-equip-F"+cases.get(2)+"']/ul/li["+number1+"]/span/span[2]";
		String actual_slide = driver.findElement(By.xpath(slide_xpath)).getAttribute("textContent");
		String expected_slide = number1+"/"+Integer.parseInt(numberAll);
		softly.assertThat(actual_slide).as("test data").isEqualTo(expected_slide);
		//Verify Height of slide
		String slideHeight = driver.findElement(By.xpath(".//*[@id='pii-slideshow-equip-F"+cases.get(2)+"']/ul/li["+number1+"]/div[2]")).getAttribute("style");
		softly.assertThat(slideHeight).as("test data").contains("height: 715px");
	}

	public void switchWindow(WebDriver driver, String window) throws Exception{

		EiRCAChinese obj = new EiRCAChinese();
		//Switch to new window
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		//Get window title
		String newWindowTitle = driver.getTitle();
		System.out.println(newWindowTitle);	
		Thread.sleep(4000);
		if((newWindowTitle.contains("kale")||newWindowTitle.contains("KALE"))==false)
			driver.close();
		else
		{
			Set<String> handles = driver.getWindowHandles();
			List<String> list = new ArrayList<String>(handles);
			//Size of handles
			int size = list.size();
			for(int i=0;i<size;i++)
			{
				driver.switchTo().window(list.get(i));
				Thread.sleep(1000);
				if(driver.getCurrentUrl().contains("kale")==false)
					driver.close();
			}
		}
		Thread.sleep(2000);
		driver.switchTo().window(window);
		Thread.sleep(4000);
		//Get browser name and version
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		//Chrome or Firefox
		if(browserName.equals("firefox"))
			driver.switchTo().defaultContent();   
		if(driver.getCurrentUrl().contains("kaleasia") && browserName.equals("internet explorer"))
			Thread.sleep(4000);
		Thread.sleep(8000);
		//Switch to iframe
		driver.switchTo().frame(driver.findElement(obj.IFrame));
		Thread.sleep(2000);
	}


	public List<String> createCaseChrome(WebDriver driver, String keyword_same, String key1, String key2, String key3, String title)throws Exception{

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebDriverWait wait = new WebDriverWait(driver,40);
		ShareCheck obj = new ShareCheck();
		CaseBrowse obj1 = new CaseBrowse();
		CreateHumanCase obj2 = new CreateHumanCase ();
		Login obj3 = new Login();
		List<String> categories = new ArrayList<String>();
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj3.LoginNameOnTopRight)).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.AdminOption)).click();
		//Clicks on Errorfree bank option
		if (driver.findElement(EquipCasesLink).isDisplayed()==false)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.ErrorFreeBankLink)).click();
		}			
		//Clicks on Equipment cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink)).click();			
		//Creates 5 cases
		int num =5;
		if(title.equals(eq_title)||title.equals(eq_titleUS)||title.equals(eq_titleie11US)||title.equals(eq_titleie11))
		{
			num = 6;
		}
		//Enters mandatory data
		//Enters case id
		Random random = new Random();
		List<String> caseID = new ArrayList<String>();
		String caseId = "";
		for(int count=1;count<=num;count++)
		{
			if(count==6)
			{
				//Clicks on admin user name on top right corner
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj3.LoginNameOnTopRight)).click();
				//Clicks on admin option
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.AdminOption)).click();
				//Clicks on Errorfree bank option
				if (driver.findElement(EquipCasesLink).isDisplayed()==false)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.ErrorFreeBankLink)).click();
				}			
				//Clicks on Equipment cases
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink)).click();
			}
			//Waits for black loading message to disappear
			obj.loadingServer(driver);
			//Clicks on new case button
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewButton)).click();
			//Clicks on new case
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupTitle)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupConfirmButton)).click();
			//Waits for black loading message to disappear
			obj.loadingServer(driver);
			while (true)
			{
				Thread.sleep(1000);
				int y=random.nextInt(10000);
				if(y<1000)
					continue;
				caseId = String.format("%d", y);
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseIDField)).sendKeys(caseId);
				Thread.sleep(1000);
				Thread.sleep(1000);
				WebElement errorCaseId;
				try{
					errorCaseId=driver.findElement(EquipCaseIDFieldError);
				}catch(org.openqa.selenium.NoSuchElementException e)
				{
					break;
				}
				if(errorCaseId.isDisplayed()==true)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseIDField)).clear();
					continue;
				}
				if(errorCaseId.isDisplayed()==false)
					break;
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseIDField)).clear();
			}
			System.out.println("Case id: "+ caseId);
			//Add Case is to list
			caseID.add(caseId);
			if(count<6){
				//Selects types
				categories.addAll(selectTypes(driver, count, title));
				//Select Discipline
				selectDiscipline(driver, title, count);
				//Select Fields
				selectFields(driver);
			}
			if(count == 6 )
			{
				//Select all Filters
				selectAllTypes(driver);
				selectAllDiscipline(driver);
				selectAllFields(driver);
			}
			//Enters Question
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseQuestion)).sendKeys(title);
			//Enters Answer
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseAnswer)).sendKeys(title);
			Thread.sleep(1000);
			try{
				jse.executeScript("scroll(0,1700)");
			}catch (org.openqa.selenium.ScriptTimeoutException r)
			{
				Thread.sleep(3000);
				jse.executeScript("scroll(0,1700)");
			}
			Thread.sleep(1000);
			if(count<6){
				//Enters Keyword
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).sendKeys(keyword_same);
				Thread.sleep(4000);
				if(count==1)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordAddButton)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).clear();
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).sendKeys(key1);
					Thread.sleep(4000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordAddButton)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).clear();
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).sendKeys(key2);
					Thread.sleep(4000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordAddButton)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).clear();
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).sendKeys(key3);
					Thread.sleep(4000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordAddButton)).click();
					if(title.equals(eq_title)||title.equals(eq_titleUS)||title.equals(eq_titleie11US)||title.equals(eq_titleie11))
					{
						//Add keyword with all special characters
						obj1.addKeywordWithAllSpecialCharactersEquip(driver);
					}
				}
				else 
				{
					Thread.sleep(1000);
					try{
						jse.executeScript("scroll(0,1700)");
					}catch (org.openqa.selenium.ScriptTimeoutException r)
					{
						Thread.sleep(3000);
						jse.executeScript("scroll(0,1700)");
					}
					Thread.sleep(1000);
					WebElement element = driver.findElement(EquipCaseKeywordExistingList);
					element.findElement(obj2.FirstAndLastChildInList).click();
				}}
			if(count == 5)
			{
				if(title.equals(ee_title)||title.equals(ee_titleUS)||title.equals(ee_titleie11US)||title.equals(ee_titleie11)||title.equals(me_title)||title.equals(me_titleUS)||title.equals(me_titleie11US)||title.equals(me_titleie11))
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).clear();
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).sendKeys(keyword_same+"begonia");
					Thread.sleep(2000);
					try{
						jse.executeScript("scroll(0,1700)");
					}catch (org.openqa.selenium.ScriptTimeoutException r)
					{
						Thread.sleep(3000);
						jse.executeScript("scroll(0,1700)");
					}
					Thread.sleep(1000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordAddButton)).click();
				}
			}
			if(count == 6)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).clear();
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).sendKeys(keyword_same+"joker");
				Thread.sleep(2000);
				try{
					jse.executeScript("scroll(0,1700)");
				}catch (org.openqa.selenium.ScriptTimeoutException r)
				{
					Thread.sleep(3000);
					jse.executeScript("scroll(0,1700)");
				}
				Thread.sleep(1000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordAddButton)).click();
			}
			//Uploads 5 slides
			WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipImageCollapsible));
			obj.scrollToElement(driver, l);
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipImageUploadField)).click();
			Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlides.exe");
			p.waitFor();
			Thread.sleep(3000);
			//Checks if 5 images have been uploaded
			if(driver.findElement(EquipImageCollapsibleExpanded).isDisplayed()==false)
			{
				l = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipImageCollapsible));
				obj.scrollToElement(driver, l);
				l.click();
			}
			Thread.sleep(2000);
			int i;
			for (i=0; i<5;i++)
			{
				String xpath = ".//*[@id='pii-admin-efse-upload-form-selectedfiles']/div["+(i+1)+"]";
				if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).isDisplayed())
				{
					System.out.println("Uploaded Image : " + (i+1));
				}
				Thread.sleep(1000);
			}
			//Add links in case number 3 of Electrical FM	
			if(count==3){
				if(title.equals(ee_title)||title.equals(ee_titleUS)||title.equals(ee_titleie11US)||title.equals(ee_titleie11))
				{
					addLinks(driver,title,caseId);
				}}
			obj.scrollToTop(driver);
			Thread.sleep(1000);
			//Clicks on save
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSaveButton)).click();
			//Clicks on create case
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupTitle)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupConfirmButton)).click();
			//Waits for black loading message to disappear
			obj.loadingServer(driver);
			if(count==5){
				//Look for the multiple selected categories
				searchCaseWithMultipleCategories(driver,categories,caseID.get(4));
				if(title.equals(ee_title)||title.equals(ee_titleUS)||title.equals(ee_titleie11US)||title.equals(ee_titleie11)||title.equals(me_title)||title.equals(me_titleUS)||title.equals(me_titleie11US)||title.equals(me_titleie11))
				{
					searchFailurModeCaseWith2Discipline(driver,keyword_same+"begonia",caseID.get(4));
				}
			}
		}	
		return caseID;
	}

	public List<String> createCaseFirefox(WebDriver driver, String keyword_same, String key1, String key2, String key3, String title)throws Exception{

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebDriverWait wait = new WebDriverWait(driver,40);
		ShareCheck obj = new ShareCheck();
		CaseBrowse obj1 = new CaseBrowse();
		CreateHumanCase obj2 = new CreateHumanCase ();
		Login obj3 = new Login();
		List<String> categories = new ArrayList<String>();
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj3.LoginNameOnTopRight)).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.AdminOption)).click();
		//Clicks on Errorfree bank option
		if (driver.findElement(EquipCasesLink).isDisplayed()==false)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.ErrorFreeBankLink)).click();
		}	
		//Clicks on Equipment cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink)).click();	
		//Creates 5 cases
		int num =5;
		if(title.equals(eq_title)||title.equals(eq_titleUS)||title.equals(eq_titleie11US)||title.equals(eq_titleie11))
		{
			num = 6;
		}
		//Enters mandatory data
		//Enters case id
		Random random = new Random();
		List<String> caseID = new ArrayList<String>();
		String caseId = "";
		for(int count=1;count<=num;count++)
		{
			if(count==6)
			{
				//Clicks on admin user name on top right corner
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj3.LoginNameOnTopRight)).click();
				//Clicks on admin option
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.AdminOption)).click();
				//Clicks on Errorfree bank option
				if (driver.findElement(EquipCasesLink).isDisplayed()==false)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.ErrorFreeBankLink)).click();
				}			
				//Clicks on Equipment cases
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink)).click();
			}
			//Waits for black loading message to disappear
			obj.loadingServer(driver);
			obj.loadingServer(driver);
			//Scroll to top
			Thread.sleep(1000);
			obj.scrollToTop(driver);
			Thread.sleep(1000);
			//Clicks on new case button
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewButton)).click();
			//Clicks on new case
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupTitle)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupConfirmButton)).click();
			//Waits for black loading message to disappear
			obj.loadingServer(driver);
			//Scroll to top
			Thread.sleep(1000);
			obj.scrollToTop(driver);
			Thread.sleep(1000);
			while (true)
			{
				Thread.sleep(1000);
				int y=random.nextInt(10000);
				if(y<1000)
					continue;
				caseId = String.format("%d", y);
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseIDField)).sendKeys(caseId);
				Thread.sleep(1000);
				Thread.sleep(1000);
				WebElement errorCaseId;
				try{
					errorCaseId=driver.findElement(EquipCaseIDFieldError);
				}catch(org.openqa.selenium.NoSuchElementException e)
				{
					break;
				}
				if(errorCaseId.isDisplayed()==true)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseIDField)).clear();
					continue;
				}
				if(errorCaseId.isDisplayed()==false)
					break;
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseIDField)).clear();
			}
			System.out.println("Case id: "+ caseId);
			//Add Case is to list
			caseID.add(caseId);
			if(count<6){
				//Selects types
				categories.addAll(selectTypes(driver, count, title));
				//Select Discipline
				selectDiscipline(driver, title, count);
				//Select Fields
				selectFields(driver);
			}
			if(count == 6 )
			{
				//Select all Filters
				selectAllTypes(driver);
				selectAllDiscipline(driver);
				selectAllFields(driver);
			}
			//Enters Question
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseQuestion)).sendKeys(title);
			//Enters Answer
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseAnswer)).sendKeys(title);
			Thread.sleep(1000);
			try{
				jse.executeScript("scroll(0,1700)");
			}catch (org.openqa.selenium.ScriptTimeoutException r)
			{
				Thread.sleep(3000);
				jse.executeScript("scroll(0,1700)");
			}
			Thread.sleep(1000);
			if(count<6){
				//Enters Keyword
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).sendKeys(keyword_same);
				Thread.sleep(2000);
				if(count==1)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordAddButton)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).clear();
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).sendKeys(key1);
					Thread.sleep(2000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordAddButton)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).clear();
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).sendKeys(key2);
					Thread.sleep(2000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordAddButton)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).clear();
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).sendKeys(key3);
					Thread.sleep(2000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordAddButton)).click();
					if(title.equals(eq_title)||title.equals(eq_titleUS)||title.equals(eq_titleie11US))
					{
						//Add keyword with all special characters
						obj1.addKeywordWithAllSpecialCharactersEquip(driver);
					}
				}
				else 
				{
					Thread.sleep(1000);
					try{
						jse.executeScript("scroll(0,1700)");
					}catch (org.openqa.selenium.ScriptTimeoutException r)
					{
						Thread.sleep(3000);
						jse.executeScript("scroll(0,1700)");
					}
					Thread.sleep(1000);
					WebElement element = driver.findElement(EquipCaseKeywordExistingList);
					element.findElement(obj2.FirstAndLastChildInList).click();
				}}
			if(count == 5)
			{
				if(title.equals(ee_title)||title.equals(ee_titleUS)||title.equals(ee_titleie11US)||title.equals(ee_titleie11)||title.equals(me_title)||title.equals(me_titleUS)||title.equals(me_titleie11US)||title.equals(me_titleie11))
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).clear();
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).sendKeys(keyword_same+"begonia");
					Thread.sleep(2000);
					try{
						jse.executeScript("scroll(0,1700)");
					}catch (org.openqa.selenium.ScriptTimeoutException r)
					{
						Thread.sleep(3000);
						jse.executeScript("scroll(0,1700)");
					}
					Thread.sleep(1000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordAddButton)).click();
				}
			}
			if(count == 6)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).clear();
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).sendKeys(keyword_same+"joker");
				Thread.sleep(2000);
				try{
					jse.executeScript("scroll(0,1700)");
				}catch (org.openqa.selenium.ScriptTimeoutException r)
				{
					Thread.sleep(3000);
					jse.executeScript("scroll(0,1700)");
				}
				Thread.sleep(1000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordAddButton)).click();
			}
			//Uploads 5 slides
			WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipImageCollapsible));
			obj.scrollToElement(driver, l);
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipImageUploadField)).click();
			Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlides_Firefox.exe");
			p.waitFor();
			Thread.sleep(3000);
			//Checks if 5 images have been uploaded
			if(driver.findElement(EquipImageCollapsibleExpanded).isDisplayed()==false)
			{
				l = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipImageCollapsible));
				obj.scrollToElement(driver, l);
				l.click();
			}
			Thread.sleep(2000);
			int i;
			for (i=0; i<5;i++)
			{
				String xpath = ".//*[@id='pii-admin-efse-upload-form-selectedfiles']/div["+(i+1)+"]";
				try{
					if (driver.findElement(By.xpath(xpath)).isDisplayed())
					{
						System.out.println("Uploaded Image : " + (i+1));
					}
				}catch(org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException r)
				{
					break;
				}
				Thread.sleep(1000);
			}
			//Add links in case number 3 of Electrical FM	
			if(count==3){
				if(title.equals(ee_title)||title.equals(ee_titleUS)||title.equals(ee_titleie11US)||title.equals(ee_titleie11))
				{
					addLinks(driver,title,caseId);
				}}
			obj.scrollToTop(driver);
			Thread.sleep(1000);
			//Clicks on save
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSaveButton)).click();
			//Clicks on create case
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupTitle)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupConfirmButton)).click();
			//Waits for black loading message to disappear
			obj.loadingServer(driver);
			obj.loadingServer(driver);
			//Scroll to top
			Thread.sleep(1000);
			obj.scrollToTop(driver);
			Thread.sleep(1000);
			if(count==5){
				//Look for the multiple selected categories
				searchCaseWithMultipleCategories(driver,categories,caseID.get(4));
				if(title.equals(ee_title)||title.equals(ee_titleUS)||title.equals(ee_titleie11US)||title.equals(ee_titleie11)||title.equals(me_title)||title.equals(me_titleUS)||title.equals(me_titleie11US)||title.equals(me_titleie11))
				{
					searchFailurModeCaseWith2Discipline(driver,keyword_same+"begonia",caseID.get(4));
				}
			}
		}	
		return caseID;
	}

	public List<String> createCaseIE10(WebDriver driver, String keyword_same, String key1, String key2, String key3, String title)throws Exception{

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebDriverWait wait = new WebDriverWait(driver,10);
		ShareCheck obj = new ShareCheck();
		CaseBrowse obj1 = new CaseBrowse();
		CreateHumanCase obj2 = new CreateHumanCase ();
		Login obj3 = new Login();
		List<String> categories = new ArrayList<String>();
		//Creates 5 cases
		int num =5;
		if(title.equals(eq_title)||title.equals(eq_titleUS)||title.equals(eq_titleie11US)||title.equals(eq_titleie11))
		{
			num = 6;
		}
		//Enters mandatory data
		//Enters case id
		Random random = new Random();
		List<String> caseID = new ArrayList<String>();
		String caseId = "";
		for(int count=1;count<=num;count++)
		{
			while(true)
			{
				try{
					if (driver.findElement(obj3.StickyNote).isDisplayed())
					{
						Thread.sleep(1000);
						wait.until(ExpectedConditions.visibilityOfElementLocated(obj3.StickyClose)).click();

					}}catch (NoSuchElementException e)
				{
						break;
				}
				catch( StaleElementReferenceException f)
				{

					break;
				}
				catch (org.openqa.selenium.TimeoutException u)
				{
					break;
				}
				catch (org.openqa.selenium.ElementNotInteractableException u)
				{
					break;
				}
				catch (org.openqa.selenium.JavascriptException t)
				{
					Thread.sleep(2000);
					break;
				}

			}
			while(true)
			{
				if(driver.findElement(obj2.AdminOption).isDisplayed()==false)
				{
					//Clicks on admin user name on top right corner
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj3.LoginNameOnTopRight)).click();
				}
				else
				{
					//Clicks on admin option
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.AdminOption)).click();
					break;
				}
			}
			//Clicks on Errorfree bank option
			if (driver.findElement(EquipCasesLink).isDisplayed()==false)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.ErrorFreeBankLink)).click();
			}	
			//Clicks on Equipment cases
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink)).click();	
			//Waits for black loading message to disappear
			obj.loadingServer(driver);
			obj.loadingServer(driver);
			//Scroll to top
			Thread.sleep(1000);
			obj.scrollToTop(driver);
			Thread.sleep(1000);
			//Clicks on new case button
			WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewButton));
			ele.click();
			//Clicks on new case
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupTitle));
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupConfirmButton));
			ele.click();
			//Waits for black loading message to disappear
			obj.loadingServer(driver);
			obj.loadingServer(driver);
			//Scroll to top
			Thread.sleep(1000);
			obj.scrollToTop(driver);
			Thread.sleep(1000);
			while (true)
			{
				Thread.sleep(1000);
				int y=random.nextInt(10000);
				if(y<1000)
					continue;
				caseId = String.format("%d", y);
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseIDField)).sendKeys(caseId);
				Thread.sleep(1000);
				Thread.sleep(1000);
				WebElement errorCaseId;
				try{
					errorCaseId=driver.findElement(EquipCaseIDFieldError);
				}catch(org.openqa.selenium.NoSuchElementException e)
				{
					break;
				}
				if(errorCaseId.isDisplayed()==true)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseIDField)).clear();
					continue;
				}
				if(errorCaseId.isDisplayed()==false)
					break;
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseIDField)).clear();
			}
			System.out.println("Case id: "+ caseId);
			//Add Case is to list
			caseID.add(caseId);
			if(count<6){
				//Selects types
				categories.addAll(selectTypes(driver, count, title));
				//Select Discipline
				selectDiscipline(driver, title, count);
				//Select Fields
				selectFields(driver);
			}
			if(count == 6 )
			{
				//Select all Filters
				selectAllTypes(driver);
				selectAllDiscipline(driver);
				selectAllFields(driver);
			}
			//Enters Question
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseQuestion)).sendKeys(title);
			//Enters Answer
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseAnswer)).sendKeys(title);
			Thread.sleep(1000);
			try{
				jse.executeScript("scroll(0,1700)");
			}catch (org.openqa.selenium.ScriptTimeoutException r)
			{
				Thread.sleep(3000);
				jse.executeScript("scroll(0,1700)");
			}
			Thread.sleep(1000);
			if(count<6){
				//Enters Keyword
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).sendKeys(keyword_same);
				Thread.sleep(2000);
				if(count==1)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordAddButton)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).clear();
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).sendKeys(key1);
					Thread.sleep(2000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordAddButton)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).clear();
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).sendKeys(key2);
					Thread.sleep(2000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordAddButton)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).clear();
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).sendKeys(key3);
					Thread.sleep(2000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordAddButton)).click();
					if(title.equals(eq_title)||title.equals(eq_titleUS)||title.equals(eq_titleie11US))
					{
						//Add keyword with all special characters
						obj1.addKeywordWithAllSpecialCharactersEquip(driver);
					}
				}
				else 
				{
					Thread.sleep(1000);
					try{
						jse.executeScript("scroll(0,1700)");
					}catch (org.openqa.selenium.ScriptTimeoutException r)
					{
						Thread.sleep(3000);
						jse.executeScript("scroll(0,1700)");
					}
					Thread.sleep(1000);
					WebElement element = driver.findElement(EquipCaseKeywordExistingList);
					element.findElement(obj2.FirstAndLastChildInList).click();
				}}
			if(count == 5)
			{
				if(title.equals(ee_title)||title.equals(ee_titleUS)||title.equals(ee_titleie11US)||title.equals(ee_titleie11)||title.equals(me_title)||title.equals(me_titleUS)||title.equals(me_titleie11US)||title.equals(me_titleie11))
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).clear();
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).sendKeys(keyword_same+"begonia");
					Thread.sleep(2000);
					try{
						jse.executeScript("scroll(0,1700)");
					}catch (org.openqa.selenium.ScriptTimeoutException r)
					{
						Thread.sleep(3000);
						jse.executeScript("scroll(0,1700)");
					}
					Thread.sleep(1000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordAddButton)).click();
				}
			}
			if(count == 6)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).clear();
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).sendKeys(keyword_same+"joker");
				Thread.sleep(2000);
				try{
					jse.executeScript("scroll(0,1700)");
				}catch (org.openqa.selenium.ScriptTimeoutException r)
				{
					Thread.sleep(3000);
					jse.executeScript("scroll(0,1700)");
				}
				Thread.sleep(1000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordAddButton)).click();
			}
			//Uploads 5 slides
			WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipImageCollapsible));
			obj.scrollToElement(driver, l);
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipImageUploadField));
			jse.executeScript("return document.getElementById('pii-admin-efse-upload-file-input').click();");
			Thread.sleep(3000);
			Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlides_IE10.exe");
			p.waitFor();
			Thread.sleep(3000);
			//Checks if 5 images have been uploaded
			if(driver.findElement(EquipImageCollapsibleExpanded).isDisplayed()==false)
			{
				l = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipImageCollapsible));
				obj.scrollToElement(driver, l);
				l.click();
			}
			Thread.sleep(2000);
			int i;
			for (i=0; i<5;i++)
			{
				String xpath = ".//*[@id='pii-admin-efse-upload-form-selectedfiles']/div["+(i+1)+"]";
				try{
					if (driver.findElement(By.xpath(xpath)).isDisplayed())
					{
						System.out.println("Uploaded Image : " + (i+1));
					}
				}catch(org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException r)
				{
					break;
				}
				Thread.sleep(1000);
			}
			//Add links in case number 3 of Electrical FM	
			if(count==3){
				if(title.equals(ee_title)||title.equals(ee_titleUS)||title.equals(ee_titleie11US)||title.equals(ee_titleie11))
				{
					addLinks(driver,title,caseId);
				}}
			obj.scrollToTop(driver);
			Thread.sleep(1000);
			//Clicks on save
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSaveButton)).click();
			//Clicks on create case
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupTitle)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupConfirmButton)).click();
			//Waits for black loading message to disappear
			obj.loadingServer(driver);
			obj.loadingServer(driver);
			//Scroll to top
			Thread.sleep(1000);
			obj.scrollToTop(driver);
			Thread.sleep(1000);
			if(count==5){
				//Look for the multiple selected categories
				searchCaseWithMultipleCategories(driver,categories,caseID.get(4));
				if(title.equals(ee_title)||title.equals(ee_titleUS)||title.equals(ee_titleie11US)||title.equals(ee_titleie11)||title.equals(me_title)||title.equals(me_titleUS)||title.equals(me_titleie11US)||title.equals(me_titleie11))
				{
					searchFailurModeCaseWith2Discipline(driver,keyword_same+"begonia",caseID.get(4));
				}
			}
		}	
		return caseID;
	}

	public List<String> createCaseIE11(WebDriver driver, String keyword_same, String key1, String key2, String key3, String title)throws Exception{

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebDriverWait wait = new WebDriverWait(driver,40);
		ShareCheck obj = new ShareCheck();
		CaseBrowse obj1 = new CaseBrowse();
		CreateHumanCase obj2 = new CreateHumanCase ();
		Login obj3 = new Login();
		List<String> categories = new ArrayList<String>();
		//Creates 5 cases
		int num =5;
		if(title.equals(eq_title)||title.equals(eq_titleUS)||title.equals(eq_titleie11US)||title.equals(eq_titleie11))
		{
			num = 6;
		}
		//Enters mandatory data
		//Enters case id
		Random random = new Random();
		List<String> caseID = new ArrayList<String>();
		String caseId = "";
		for(int count=1;count<=num;count++)
		{
			obj3.closePopUpSticky(driver);
			//Clicks on admin user name on top right corner
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj3.LoginNameOnTopRight)).click();
			//Clicks on admin option
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.AdminOption)).click();
			//Clicks on Errorfree bank option
			if (driver.findElement(EquipCasesLink).isDisplayed()==false)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.ErrorFreeBankLink)).click();
			}	
			//Clicks on Equipment cases
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink)).click();	
			//Waits for black loading message to disappear
			obj.loadingServer(driver);
			obj.loadingServer(driver);
			//Scroll to top
			Thread.sleep(1000);
			obj.scrollToTop(driver);
			Thread.sleep(1000);
			//Clicks on new case button
			/*	WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewButton));
			ele.click();*/
			jse.executeScript("return document.getElementById('pii-admin-efse-button-new').click();");
			Thread.sleep(1000);
			//Clicks on new case
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupTitle));
			WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupConfirmButton));
			ele.click();
			//Waits for black loading message to disappear
			obj.loadingServer(driver);
			obj.loadingServer(driver);
			//Scroll to top
			Thread.sleep(1000);
			obj.scrollToTop(driver);
			Thread.sleep(1000);
			while (true)
			{
				Thread.sleep(1000);
				int y=random.nextInt(10000);
				if(y<1000)
					continue;
				caseId = String.format("%d", y);
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseIDField)).sendKeys(caseId);
				Thread.sleep(1000);
				Thread.sleep(1000);
				WebElement errorCaseId;
				try{
					errorCaseId=driver.findElement(EquipCaseIDFieldError);
				}catch(org.openqa.selenium.NoSuchElementException e)
				{
					break;
				}
				if(errorCaseId.isDisplayed()==true)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseIDField)).clear();
					continue;
				}
				if(errorCaseId.isDisplayed()==false)
					break;
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseIDField)).clear();
			}
			System.out.println("Case id: "+ caseId);
			//Add Case is to list
			caseID.add(caseId);
			if(count<6){
				//Selects types
				categories.addAll(selectTypes(driver, count, title));
				//Select Discipline
				selectDiscipline(driver, title, count);
				//Select Fields
				selectFields(driver);
			}
			if(count == 6 )
			{
				//Select all Filters
				selectAllTypes(driver);
				selectAllDiscipline(driver);
				selectAllFields(driver);
			}
			//Enters Question
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseQuestion)).sendKeys(title);
			//Enters Answer
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseAnswer)).sendKeys(title);
			Thread.sleep(1000);
			try{
				jse.executeScript("scroll(0,1700)");
			}catch (org.openqa.selenium.ScriptTimeoutException r)
			{
				Thread.sleep(3000);
				jse.executeScript("scroll(0,1700)");
			}
			Thread.sleep(1000);
			if(count<6){
				//Enters Keyword
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).sendKeys(keyword_same);
				Thread.sleep(2000);
				if(count==1)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordAddButton)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).clear();
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).sendKeys(key1);
					Thread.sleep(2000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordAddButton)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).clear();
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).sendKeys(key2);
					Thread.sleep(2000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordAddButton)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).clear();
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).sendKeys(key3);
					Thread.sleep(2000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordAddButton)).click();
					if(title.equals(eq_title)||title.equals(eq_titleUS)||title.equals(eq_titleie11US)||title.equals(eq_titleie11))
					{
						//Add keyword with all special characters
						obj1.addKeywordWithAllSpecialCharactersEquip(driver);
					}
				}
				else 
				{
					Thread.sleep(1000);
					try{
						jse.executeScript("scroll(0,1700)");
					}catch (org.openqa.selenium.ScriptTimeoutException r)
					{
						Thread.sleep(3000);
						jse.executeScript("scroll(0,1700)");
					}
					Thread.sleep(1000);
					WebElement element = driver.findElement(EquipCaseKeywordExistingList);
					element.findElement(obj2.FirstAndLastChildInList).click();
				}}
			if(count == 5)
			{
				if(title.equals(ee_title)||title.equals(ee_titleUS)||title.equals(ee_titleie11US)||title.equals(ee_titleie11)||title.equals(me_title)||title.equals(me_titleUS)||title.equals(me_titleie11US)||title.equals(me_titleie11))
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).clear();
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).sendKeys(keyword_same+"begonia");
					Thread.sleep(2000);
					try{
						jse.executeScript("scroll(0,1700)");
					}catch (org.openqa.selenium.ScriptTimeoutException r)
					{
						Thread.sleep(3000);
						jse.executeScript("scroll(0,1700)");
					}
					Thread.sleep(1000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordAddButton)).click();
				}
			}
			if(count == 6)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).clear();
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).sendKeys(keyword_same+"joker");
				Thread.sleep(2000);
				try{
					jse.executeScript("scroll(0,1700)");
				}catch (org.openqa.selenium.ScriptTimeoutException r)
				{
					Thread.sleep(3000);
					jse.executeScript("scroll(0,1700)");
				}
				Thread.sleep(1000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordAddButton)).click();
			}
			//Uploads 5 slides
			WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipImageCollapsible));
			obj.scrollToElement(driver, l);
			jse.executeScript("return document.getElementById('pii-admin-efse-upload-file-input').click();");
			Thread.sleep(2000);
			Process p =Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/UploadHumanCaseSlides_IE10.exe");
			p.waitFor();
			Thread.sleep(4000);
			//Checks if 5 images have been uploaded
			try{
				driver.findElement(EquipImageCollapsibleExpanded);
			}catch(org.openqa.selenium.NoSuchElementException e)
			{
				l = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipImageCollapsible));
				obj.scrollToElement(driver, l);
				l.click();
			}
			if(driver.findElement(EquipImageCollapsibleExpanded).isDisplayed()==false)
			{
				l = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipImageCollapsible));
				obj.scrollToElement(driver, l);
				l.click();
			}
			Thread.sleep(2000);
			int i;
			for (i=0; i<5;i++)
			{
				String xpath = ".//*[@id='pii-admin-efse-upload-form-selectedfiles']/div["+(i+1)+"]";
				try{
					if (driver.findElement(By.xpath(xpath)).isDisplayed())
					{
						System.out.println("Uploaded Image : " + (i+1));
					}
				}catch(org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException r)
				{
					break;
				}
				Thread.sleep(1000);
			}
			//Add links in case number 3 of Electrical FM	
			if(count==3){
				if(title.equals(ee_title)||title.equals(ee_titleUS)||title.equals(ee_titleie11US)||title.equals(ee_titleie11))
				{
					addLinks(driver,title,caseId);
				}}
			obj.scrollToTop(driver);
			Thread.sleep(1000);
			//Clicks on save
			jse.executeScript("return document.getElementById('pii-admin-efse-button-save').click();");
			Thread.sleep(1000);
			//Clicks on create case
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupTitle));
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupConfirmButton)).click();
			//Waits for black loading message to disappear
			obj.loadingServer(driver);
			obj.loadingServer(driver);
			//Scroll to top
			Thread.sleep(1000);
			obj.scrollToTop(driver);
			Thread.sleep(1000);
			if(count==5){
				//Look for the multiple selected categories
				searchCaseWithMultipleCategories(driver,categories,caseID.get(4));
				if(title.equals(ee_title)||title.equals(ee_titleUS)||title.equals(ee_titleie11US)||title.equals(ee_titleie11)||title.equals(me_title)||title.equals(me_titleUS)||title.equals(me_titleie11US)||title.equals(me_titleie11))
				{
					searchFailurModeCaseWith2Discipline(driver,keyword_same+"begonia",caseID.get(4));
				}
			}
		}	
		return caseID;
	}

	public void compareSlide(WebDriver driver, String caseId, String title, int y) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,40);
		CaseBrowse obj = new CaseBrowse();
		CreateHumanCase obj1 = new CreateHumanCase ();
		Thread.sleep(1000);
		//Clicks on Error free bank
		WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.ErrorFreeBankTopLink));
		element1.click();
		Thread.sleep(2000);
		if(y==0){
			if(title.equals(eq_title)||title.equals(eq_titleUS)||title.equals(eq_titleie11US)||title.equals(eq_titleie11))
			{
				//Clicks on Equipment Performance Search
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EquipmentPerformanceLink)).click();
			}}
		if(y==1)
		{
			//Clicks on Equipment Performance Search (PII)
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EquipmentDatabankOnlyLink1)).click();
		}
		if(title.equals(ee_title)||title.equals(ee_titleUS)||title.equals(ee_titleie11US)||title.equals(ee_titleie11))
		{
			//Clicks on Failure Mode Search
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj.FailureModeLink)).click();
		}
		if(title.equals(me_title)||title.equals(me_titleUS)||title.equals(me_titleie11US)||title.equals(me_titleie11))
		{
			//Clicks on Failure Mode Search
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj.FailureModeLink)).click();
		}
		obj.browseCaseIDEquip(driver,caseId,title); 
	}

	public void checkkeyword (WebDriver driver, List<String>caseId, String keyword_same, String key1, String key2, String key3, int y,String title) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,40);
		ShareCheck obj = new ShareCheck();
		CaseBrowse obj1 = new CaseBrowse();
		CreateHumanCase obj2 = new CreateHumanCase ();
		EquipmentPDDandEF obj3 = new EquipmentPDDandEF ();
		//Clicks on Error free bank
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.ErrorFreeBankTopLink)).click();
		}catch (UnhandledAlertException f){			  
			driver.switchTo().alert().dismiss();
		}
		if(y==0){
			if(keyword_same.equals(keyword_same_eq)||keyword_same.equals(keyword_same_eqUS)||keyword_same.equals(keyword_same_eqie11US)||keyword_same.equals(keyword_same_eqie11))
			{
				//Clicks on Equipment Performance Search
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentPerformanceLink)).click();
			}}
		if(y==1)
		{
			//Clicks on Equipment Performance Search (PII)
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentDatabankOnlyLink1)).click();
		}
		if(keyword_same.equals(keyword_same_ee)||keyword_same.equals(keywordUS_same_ee)||keyword_same.equals(keyword_same_eeie11US)||keyword_same.equals(keyword_same_eeie11))
		{
			//Clicks on  Failure Mode Search
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.FailureModeLink)).click();
		}
		if(keyword_same.equals(keyword_same_me)||keyword_same.equals(keywordUS_same_me)||keyword_same.equals(keyword_same_meie11US)||keyword_same.equals(keyword_same_meie11))
		{
			//Clicks on  Failure Mode Search
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.FailureModeLink)).click();
		}
		if(keyword_same.equals(obj3.keywordEF)||keyword_same.equals(obj3.keywordEFie11)||keyword_same.equals(obj3.keywordEFUS)||keyword_same.equals(obj3.keywordEFUSie11))
		{
			//Clicks on  Engineering Fundamentals
			wait.until(ExpectedConditions.visibilityOfElementLocated(EngineeringFundamentalsLink)).click();
		}
		if(keyword_same.equals(obj3.keywordPDD)||keyword_same.equals(obj3.keywordPDDie11)||keyword_same.equals(obj3.keywordPDDUS)||keyword_same.equals(obj3.keywordPDDUSie11))
		{
			//Clicks on Prevention of Design Deficiencies
			wait.until(ExpectedConditions.visibilityOfElementLocated(PreventionOfDesignDeficienciesLink)).click();
		}
		//Enters the term and check the search by enter
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
		Thread.sleep(1000);
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(keyword_same);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Checks for the five cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId.get(0))));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId.get(1))));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId.get(2))));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId.get(3))));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId.get(4))));
		Thread.sleep(1000);
		//Clicks on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
		//Enters the term with 3 unique keywords
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(key1);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Checks for the case id 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId.get(0))));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(key2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Checks for the case id 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId.get(0))));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(key3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
		//Checks for the case id 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId.get(0))));
		Thread.sleep(1000);		 
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
		Thread.sleep(1000);
		//Search with title
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(title);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Checks for the five cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId.get(0))));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId.get(1))));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId.get(2))));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId.get(3))));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId.get(4))));
		Thread.sleep(1000);
		//Clicks on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
	}

	public void checkCase(WebDriver driver, String eq_caseId, String ee_caseId, String keyword_same_eq, String keyword_same_ee) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,40);
		ShareCheck obj = new ShareCheck();
		CaseBrowse obj1 = new CaseBrowse();
		CreateHumanCase obj2 = new CreateHumanCase ();
		EquipmentPDDandEF obj3 = new EquipmentPDDandEF();
		//Verify electrical case not in equipment performance
		obj3.searchCaseInEquipSearchByCaseID(driver, ee_caseId);
		//Clicks on Error free bank
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.ErrorFreeBankTopLink)).click();
		}catch (UnhandledAlertException f){			  
			driver.switchTo().alert().dismiss();
		}
		//Clicks on Equipment Performance Search (PII)
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentDatabankOnlyLink1)).click();
		//Clicks on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
		//Enters Electrical Case id to see if it exists
		driver.findElement(obj1.EquipmentSearchCaseIdField).sendKeys(ee_caseId);
		driver.findElement(obj1.EquipmentSearchCaseIdField).sendKeys(Keys.ENTER);
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
		//Checks for electrical case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+ee_caseId)));
		System.out.println("Electrical case found in Equipment Databank only");
		//Clicks on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
		//Verify Equipment case in Failure mode
		obj3.searchCaseIdInFailureModes(driver, eq_caseId);
		//Clicks on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
		//Verify that Failure mode cases do not appear in Engineering Fundamentals
		obj3.searchCaseIdInEngineeringFundamentals(driver, ee_caseId);
		//Clicks on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
		//Verify that Equipment Performance cases do not appear in Engineering Fundamentals
		obj3.searchCaseIdInEngineeringFundamentals(driver, eq_caseId);
		//Clicks on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
		//Clicks on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
		//Verify that Equipment Performance cases do not appear in Prevention of Design Deficiencies
		obj3.searchCaseIdInPreventionOfDesignDeficiencies(driver, eq_caseId);
		//Clicks on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
		//Search with keywords for error message
		//Electrical Failure mode in Equip
		obj3.searchCaseInEquipSearchByKeyword(driver, keyword_same_ee, ee_caseId);
		//Equip in Failure mode
		obj3.searchCaseInFMWithKeyword(driver, keyword_same_eq, eq_caseId);
		//FM in PDD
		obj3.searchCaseInPreventionOfDesignDeficienciesWithKeyword(driver, keyword_same_ee, ee_caseId);
		//Equip in PDD
		obj3.searchCaseInPreventionOfDesignDeficienciesWithKeyword(driver, keyword_same_eq, eq_caseId);
		//FM in EF
		obj3.searchCaseInEngineeringFundamentalsWithKeyword(driver, keyword_same_ee, ee_caseId);
		//Equip in EF
		obj3.searchCaseInEngineeringFundamentalsWithKeyword(driver, keyword_same_eq, eq_caseId);
	}

	public void checkCaseInOtherModulesWithKeywords(WebDriver driver, String keywordeq, String keywordee, String eq_caseId, String ee_caseId) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,40);
		CaseBrowse obj1 = new CaseBrowse();
		EquipmentPDDandEF obj3 = new EquipmentPDDandEF();
		//Verify mechanical case not in equipment performance
		obj3.searchCaseInEquipSearchByKeyword(driver, keywordee, ee_caseId);
		//Verify Equipment case in Failure mode
		obj3.searchCaseInFMWithKeyword(driver, keywordeq, eq_caseId);
		//Clicks on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
		//Verify that Failure mode cases do not appear in Engineering Fundamentals
		obj3.searchCaseInEngineeringFundamentalsWithKeyword(driver, keywordee, ee_caseId);
		//Clicks on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
		//Verify that Equipment Performance cases do not appear in Engineering Fundamentals
		obj3.searchCaseInFMWithKeyword(driver, keywordeq, eq_caseId);
		//Clicks on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
		//Verify that Failure mode cases do not appear in Prevention of Design Deficiencies
		obj3.searchCaseInPreventionOfDesignDeficienciesWithKeyword(driver, keywordee, ee_caseId);
		//Clicks on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
		//Verify that Equipment Performance cases do not appear in Prevention of Design Deficiencies
		obj3.searchCaseInPreventionOfDesignDeficienciesWithKeyword(driver, keywordeq, eq_caseId);
		//Clicks on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
	}

	public void deleteCase(WebDriver driver, List<String> caseId1) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,40);
		ShareCheck obj = new ShareCheck();
		CreateHumanCase obj1 = new CreateHumanCase();
		Login obj2 = new Login ();
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.LoginNameOnTopRight)).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.AdminOption)).click();
		Thread.sleep(1000);
		//Clicks on Errorfree bank option
		if (driver.findElement(EquipCasesLink).isDisplayed()==false)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.ErrorFreeBankLink)).click();
		}		
		for(int i=0;i<caseId1.size();i++)
		{
			String caseId = caseId1.get(i);
			//Clicks on Equipment cases
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasesLink)).click();
			//Waits for black loading message to disappear
			obj.loadingServer(driver);
			//Click on enter case id
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSearchCaseIDAdmin)).sendKeys(caseId);
			Thread.sleep(2000);
			//Clicks on case id
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSearchCaseIDDropdownAdmin)).click();
			//Waits for black loading message to disappear
			obj.loadingServer(driver);
			obj.scrollToTop(driver);
			//Clicks on delete button
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseDeleteButton)).click();
			//Waits for black loading message to disappear
			obj.loadingServer(driver);
			//Clicks on delete case
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupTitle));
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupConfirmButton)).click();
			//Waits for black loading message to disappear
			obj.loadingServer(driver);
			Thread.sleep(1000);
			obj.scrollToTop(driver);
			Thread.sleep(1000);
			//Checks if case deleted
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSearchCaseIDAdmin)).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSearchCaseIDAdmin)).sendKeys(caseId);
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSearchCaseIDAdmin)).sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			if(driver.findElement(EquipCaseSearchCaseIDDropdownAdmin).isDisplayed()==false)
				System.out.println("Case deleted: "+caseId1.get(i));
			else softly.fail("Case did not get deleted: "+caseId1.get(i) );
		}		 
		//Clicks on Errorfree bank option to close the collapsible menu
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.ErrorFreeBankLink)).click();
	}

	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}

}
