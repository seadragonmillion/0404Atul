package kaleTestSoftware;

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
	LoginPageObj lpo = new LoginPageObj();
	Login login = new Login();
	CreateEquipPageObj equipObj = new CreateEquipPageObj();
	CreateEquipmentCase2 equip2 = new CreateEquipmentCase2();
	CreateEquipmentCase3 equip3 = new CreateEquipmentCase3();
	ShareCheck2 share2 = new ShareCheck2();
	ShareCheck share = new ShareCheck();
	ShareCheckPageObj shareObj = new ShareCheckPageObj();
	CaseBrowsePageObj cb = new CaseBrowsePageObj();
	CreateHumanCasePageObj chc = new CreateHumanCasePageObj();

	public String titleCombo = "QAA Type Discipline Field Filters Combo Test";
	public String titleComboUS = "QAA US Type Discipline Field Filters Combo Test";
	public String titleComboie11 = "QAA IE11 Type Disciplineie11 Fieldie11 Filters Combo Test";
	public String titleComboUSie11 = "QAA US IE11 Type Disciplineie11 Fieldie11 Filters Combo Test";
	public String keywordCombo = "QAADiscFieldCombo";
	public String keywordComboUS = "QAAUSDiscFieldCombo";
	public String keywordComboie11 = "QAAie11DiscFieldCombo";
	public String keywordComboUSie11 = "QAAUSie11DiscFieldCombo";
	public String noVideoLink = "http://www.murdoch.edu.au/School-of-Engineering-and-Information-Technology/";
	public String noVideoLinkTitle1 = "Apple \"pie\"";
	public String noVideoLinkTitle2 = "Banana";
	public String noVideoLinkTitle3 = "Coconut";
	public String noVideoLinkTitle4 = "Dance";
	public String noVideoLinkTitle5 = "Elephant";
	public String noVideoLinkTitle6 = "Fruit";
	public String noVideoLinkTitle7 = "Guava";
	public String noVideoLinkTitle8 = "Honey";
	public String noVideoLinkTitle9 = "Ink";
	public String noVideoLinkTitle10 = "Jamaica";
	public String videoLink = "https://www.youtube.com/watch?v=KQ9Za0oLPPM";
	public String videoLinkTitle1 = "Tiger";
	public String videoLinkTitle2 = "Whale";
	public String videoLinkTitle3 = "Zebra";
	public String keyword_same_eq="QAAfiveeq";
	public String key1_eq="QAAzebraeq";
	public String key2_eq="QAAcameleq";
	public String key3_eq="QAAgiraffeeq";
	public String keyword_same_ee="QAAfiveee";
	public String key1_ee="QAAzebraee";
	public String key2_ee="QAAcamelee";
	public String key3_ee="QAAgiraffeee";
	public String keyword_same_me="QAAfiveme";
	public String key1_me="QAAzebrame";
	public String key2_me="QAAcamelme";
	public String key3_me="QAAgiraffeme";
	public String eq_title="QAA Equipment Search Case Upload";
	public String ee_title="QAA Electrical Failure Case Upload";
	public String me_title="QAA Mechanical Failure Case Upload";
	public String keyword_same_eqUS="QAAfiveeqUS";
	public String key1_eqUS="QAAzebraeqUS";
	public String key2_eqUS="QAAcameleqUS";
	public String key3_eqUS="QAAgiraffeeqUS";
	public String keywordUS_same_ee="QAAfiveeeUS";
	public String key1_eeUS="QAAzebraeeUS";
	public String key2_eeUS="QAAcameleeUS";
	public String key3_eeUS="QAAgiraffeeeUS";
	public String keywordUS_same_me="QAAfivemeUS";
	public String key1_meUS="QAAzebrameUS";
	public String key2_meUS="QAAcamelmeUS";
	public String key3_meUS="QAAgiraffemeUS";
	public String eq_titleUS="QAA US Equipment Search Case Upload";
	public String ee_titleUS="QAA US Electrical Failure Case Upload";
	public String me_titleUS="QAA US Mechanical Failure Case Upload";
	public String keyword_same_eqie11="QAAie11fiveeq";
	public String key1_eqie11="QAAie11zebraeq";
	public String key2_eqie11="QAAie11cameleq";
	public String key3_eqie11="QAAie11giraffeeq";
	public String keyword_same_eeie11="QAAie11fiveee";
	public String key1_eeie11="QAAie11zebraee";
	public String key2_eeie11="QAAie11camelee";
	public String key3_eeie11="QAAie11giraffeee";
	public String keyword_same_meie11="QAAie11fiveme";
	public String key1_meie11="QAAie11zebrame";
	public String key2_meie11="QAAie11camelme";
	public String key3_meie11="QAAie11giraffeme";
	public String eq_titleie11="QAA IE11 Equipment Case Upload";
	public String ee_titleie11="QAA IE11 Electrical Case Upload";
	public String me_titleie11="QAA IE11 Mechanical Case Upload";
	public String keyword_same_eqie11US="QAAie11fiveeqUS";
	public String key1_eqie11US="QAAie11zebraeqUS";
	public String key2_eqie11US="QAAie11cameleqUS";
	public String key3_eqie11US="QAAie11giraffeeqUS";
	public String keyword_same_eeie11US="QAAie11fiveeeUS";
	public String key1_eeie11US="QAAie11zebraeeUS";
	public String key2_eeie11US="QAAie11cameleeUS";
	public String key3_eeie11US="QAAie11giraffeeeUS";
	public String keyword_same_meie11US="QAAie11fivemeUS";
	public String key1_meie11US="QAAie11zebrameUS";
	public String key2_meie11US="QAAie11camelmeUS";
	public String key3_meie11US="QAAie11giraffemeUS";
	public String eq_titleie11US="QAA US IE11 Equipment Case Upload";
	public String ee_titleie11US="QAA US IE11 Electrical Case Upload";
	public String me_titleie11US="QAA US IE11 Mechanical Case Upload";


	public void createCaseWithDifferentDisciplineField (WebDriver driver, String title, String keyword) throws Exception {

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebDriverWait wait = new WebDriverWait(driver,10);
		//Login obj3 = new Login();
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
		int x=equipObj.selectNumberForType();
		//Chrome or Firefox
		if(browserName.equals("chrome")||browserName.equals("firefox"))
		{
			//Clicks on admin user name on top right corner
			wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.LoginNameOnTopRight)).click();
			//Clicks on admin option
			wait.until(ExpectedConditions.visibilityOfElementLocated(chc.AdminOption)).click();
			//Clicks on Errorfree bank option
			if (driver.findElement(equipObj.EquipCasesLink).isDisplayed()==false)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankAdminLink)).click();
			}	
			//Clicks on Equipment cases
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink)).click();	
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
					share2.loadingServer(driver);
					//Waits for black loading message to disappear
					share2.loadingServer(driver);
					share.scrollToTop(driver);
					//Close sticky
					login.closePopUpSticky(driver);
					while(true)
					{
						if(driver.findElement(chc.AdminOption).isDisplayed()==false)
						{
							//Clicks on admin user name on top right corner
							wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.LoginNameOnTopRight)).click();
						}
						else
						{
							//Clicks on admin option
							wait.until(ExpectedConditions.visibilityOfElementLocated(chc.AdminOption)).click();
							break;
						}
					}
					//Clicks on Errorfree bank option
					if (driver.findElement(equipObj.EquipCasesLink).isDisplayed()==false)
					{
						wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankAdminLink)).click();
					}	
					//Clicks on Equipment cases
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink)).click();	
				}
				//Waits for black loading message to disappear
				share2.loadingServer(driver);
				//Scroll to top
				Thread.sleep(1000);
				share.scrollToTop(driver);
				Thread.sleep(1000);
				//Clicks on new case button
				if(browserName.equals("internet explorer"))
					jse.executeScript("return document.getElementById('pii-admin-efse-button-new').click();");
				else{
					WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewButton));
					ele.click();		
				}
				Thread.sleep(1000);
				//Clicks on new case
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupTitle));
				WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupConfirmButton));
				ele.click();
				//Waits for black loading message to disappear
				share2.loadingServer(driver);
				//Scroll to top
				Thread.sleep(1000);
				share.scrollToTop(driver);
				Thread.sleep(1000);
				//Add Case is to list
				caseID.add(chooseCaseId(driver));
				//Selects types and returns assigned numeric value of type
				equip2.selectTypeRandom(driver, x, browserName, v);
				//Verify type not empty
				equip2.verifyTypeNotEmpty(driver, x, browserName, v);
				//Select Discipline
				equip3.selectDisciplineForComboTest(driver, disc_list.get(i), browserName, v);
				//Verify discipline not empty
				equip2.verifyDisciplineNotEmpty(driver, disc_list.get(i), browserName, v);
				//Select Fields
				equip3.selectFieldsForComboTest(driver, field_list.get(j), browserName, v);
				//Verify field no empty
				equip2.verifyFieldNotEmpty(driver, field_list.get(j), browserName, v);
				//Enters Question
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseQuestion)).sendKeys(title);
				//Make sure Question typed in right
				String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseQuestion)).getAttribute("textContent");
				if(s1.equals(keyword) == false)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseQuestion)).clear();
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseQuestion)).sendKeys(title);
				}
				//Enters Answer
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseAnswer)).sendKeys(title);
				//Make sure Answer typed in right
				String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseAnswer)).getAttribute("textContent");
				if(s2.equals(keyword) == false)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseAnswer)).clear();
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseAnswer)).sendKeys(title);
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
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(keyword);
				Thread.sleep(2000);
				//Make sure keyword typed in right
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).getAttribute("value");
				if(s.equals(keyword) == false)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).clear();
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(keyword);
				}					
				if(i==0 && j==0)
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
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
					WebElement element = driver.findElement(equipObj.EquipCaseKeywordExistingList);
					element.findElement(chc.FirstAndLastChildInList).click();
				}
				//Upload images
				WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipImageCollapsible));
				share.scrollToElement(driver, l);
				ele = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipImageUploadField));
				if(browserName.equals("chrome"))
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipImageUploadField)).click();
					Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlides.exe");
					p.waitFor();
				}
				if(browserName.equals("firefox"))
				{
					jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipImageUploadField)));
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
				if(driver.findElement(equipObj.EquipImageCollapsibleExpanded).isDisplayed()==false)
				{
					l = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipImageCollapsible));
					share.scrollToElement(driver, l);
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
					share.scrollToTop(driver);
				}catch (org.openqa.selenium.ScriptTimeoutException r)
				{
					Thread.sleep(3000);
					share.scrollToTop(driver);
				}
				Thread.sleep(1000);
				//Clicks on save
				if(browserName.equals("internet explorer")){
					jse.executeScript("return document.getElementById('pii-admin-efse-button-save').click();");
					Thread.sleep(1000);}
				else{
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSaveButton)).click();
				}
				//Clicks on create case
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupTitle));
				System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupTitle)).getText());
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupConfirmButton)).click();
				//Waits for black loading message to disappear
				share2.loadingServer(driver);
				//Scroll to top
				Thread.sleep(1000);
				try{
					share.scrollToTop(driver);
				}catch (org.openqa.selenium.ScriptTimeoutException r)
				{
					Thread.sleep(3000);
					share.scrollToTop(driver);
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
		equip2.caseSearchWithDisciplineFieldComboEquipmentDatabank(driver, x, keyword, electrical, general, ic, mechanical, software, structural);
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
		//CreateEquipmentCase2 obj3 = new CreateEquipmentCase2();
		//Go to Failure mode
		//Clicks on Error free bank
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankTopLink)).click();
		}catch (UnhandledAlertException f){			  
			driver.switchTo().alert().dismiss();
		}
		//Clicks on Equipment module as per x value
		equip2.decideEquipmentModule(driver,x);
		//Search for keyword
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Wait for loading message
		share2.loadingServer(driver);
		//Look for all cases without filter
		equip3.lookForCases(driver, electrical);
		equip3.lookForCases(driver, general);
		equip3.lookForCases(driver, ic);
		equip3.lookForCases(driver, mechanical);
		equip3.lookForCases(driver, software);
		equip3.lookForCases(driver, structural);
		//Look for case with filter
		//Create a list with discipline filters for case search
		List<By> discList = equip3.disciplineCaseSearchList();
		//Create a list with field filters for case search
		List<By> fieldList = equip3.fieldCaseSearchList();
		//Search and verify case with filter
		for(int i=0;i<discList.size();i++)
		{
			//Clicks on clear
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
			//Select filter for Equipment Performance
			if((x == 1)||(x==2)||(x==6))
			{
				//Select Type
				equip2.selectTypeAsPerX(driver,x);
			}
			//Click on discipline box
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchDisciplineBox)).click();
			//Wait for popup
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchDisciplineList));
			//Click on discipline
			wait.until(ExpectedConditions.visibilityOfElementLocated(discList.get(i))).click();
			//Close pop up
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchDisciplinePopupClose)).click();
			//Search for keyword
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(keyword);
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
			//Wait for loading message
			share2.loadingServer(driver);
			//Verify cases with only discipline filter
			verifyCasesWithOnlyDisciplineFilter(driver, i, electrical, general, ic, mechanical, software, structural);
			//Select field filter and disc filter
			selectFieldDiscFilter (driver, x, i, discList, fieldList, keyword, electrical, general, ic, mechanical, software, structural);
		}
	}

	public void selectFieldDiscFilter (WebDriver driver, int x,int i, List<By> discList, List<By> fieldList, String keyword, List<String> electrical, List<String> general, List<String> ic, List<String> mechanical, List<String> software, List<String> structural) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//CreateEquipmentCase2 obj2 = new CreateEquipmentCase2();
		for(int j=0;j<fieldList.size();j++)
		{
			//Clicks on clear
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
			//Select filter for Equipment Performance
			if((x == 1)||(x==2)||(x==6))
			{
				//Select Type
				equip2.selectTypeAsPerX(driver,x);
			}
			//Click on discipline box
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchDisciplineBox)).click();
			//Wait for popup
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchDisciplineList));
			//Click on 1st discipline
			wait.until(ExpectedConditions.visibilityOfElementLocated(discList.get(i))).click();
			//Close pop up
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchDisciplinePopupClose)).click();
			//Click on field box
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchFieldBox)).click();
			//Wait for popup
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchFieldList));
			//Click on field
			wait.until(ExpectedConditions.visibilityOfElementLocated(fieldList.get(j))).click();
			//Close pop up
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchFieldPopupClose)).click();
			//Search for keyword
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(keyword);
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
			//Wait for loading message
			share2.loadingServer(driver);
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
		equip3.lookForCases(driver, cases);
	}

	public void selectFMTypes(WebDriver driver, String browserName, String v) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		if (browserName.contains("internet")==true)
		{
			if (v.startsWith("10")==true)
			{
				//Type
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseTypes)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseTypes)).sendKeys(Keys.ENTER);
			}
			if (v.startsWith("11")==true)
			{
				//Type
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseTypes)).click();
			}
		}
		else{
			//Type
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseTypes)).click();
		}
		Thread.sleep(1000);
		//Waits for popup
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListBoxTypes));
		//Click type failure mode
		if (browserName.contains("internet")==true)
			equip3.clickTypesDisciplineIE(driver, equipObj.EquipListTypesFailureModes);
		else
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListTypesFailureModes)).click();
		//Close pop up
		try{
			driver.findElement(equipObj.ListCrossSymbol).click();
		}catch (NoSuchElementException | ElementNotInteractableException e)
		{
			driver.findElement(equipObj.EquipListBoxTypesCrossSymbol).click();
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
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseIDField)).sendKeys(caseId);
			Thread.sleep(1000);
			Thread.sleep(1000);
			WebElement errorCaseId;
			try{
				errorCaseId=driver.findElement(equipObj.EquipCaseIDFieldError);
			}catch(org.openqa.selenium.NoSuchElementException e)
			{
				break;
			}
			if(errorCaseId.isDisplayed()==true)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseIDField)).clear();
				continue;
			}
			if(errorCaseId.isDisplayed()==false)
				break;
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseIDField)).clear();
		}
		System.out.println("Case id: "+ caseId);
		return caseId;
	}

	public List<By> disciplineList()  throws Exception{

		List<By> dl = new ArrayList<By>();
		//Add discipline to list
		Collections.addAll(dl, equipObj.EquipListDisciplineElectrical, equipObj.EquipListDisciplineGeneral, equipObj.EquipListDisciplineIC, equipObj.EquipListDisciplineMechanical, equipObj.EquipListDisciplineSoftware, equipObj.EquipListDisciplineStructural);
		return dl;
	}

	public List<By> fieldList()  throws Exception{

		List<By> fl = new ArrayList<By>();
		//Add discipline to list
		Collections.addAll(fl, equipObj.EquipListFieldsAuto, equipObj.EquipListFieldsNuclear, equipObj.EquipListFieldsOther, equipObj.EquipListFieldsPharmaceutical, equipObj.EquipListFieldsWelding);
		return fl;
	}

	public void deletePreviousCase(WebDriver driver, String title) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,40);
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		//Clicks on Error free bank
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.ErrorFreeBankLinkHomePage)).click();
		//Clicks on Equipment Performance Search (PII)
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentDatabankOnlyLink1)).click();
		//Enters the title in term search field
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(title);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		//Checks if Exact matches appear
		WebElement exact = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipDropwdownTitle_1st));
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.KaleHomePage)).click();
		Thread.sleep(1000);		
	}

	public void deleteLinks (WebDriver driver, List<String> ee_case) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.LoginNameOnTopRight)).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(chc.AdminOption)).click();
		Thread.sleep(1000);
		//Clicks on Errorfree bank option
		if (driver.findElement(equipObj.EquipCasesLink).isDisplayed()==false)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankAdminLink)).click();
		}
		//Clicks on Equipment cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(1000);
		Thread.sleep(1000);
		//Enter FM case id with links
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSearchCaseIDAdmin)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSearchCaseIDAdmin)).sendKeys(ee_case.get(2));
		Thread.sleep(2000);
		//Clicks on case id
	/*	WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSearchCaseIDDropdownAdmin));
		List<WebElement> casesList = ele.findElements(By.tagName("li"));
		for(WebElement li : casesList)
		{
			if(li.getText().equals(ee_case.get(2)))
				li.click();
		}*/
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSearchCaseIDDropdownAdmin)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		//Click on Edit
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseEditButton)).click();
		Thread.sleep(2000);
		//Scroll to 2nd Link title
		WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink1TitleCrossSymbol));
		share.scrollToElement(driver, l);
		//Click on delete link 2 cross symbol of Title
		wait.until(ExpectedConditions.elementToBeClickable(equipObj.EquipCasesLink1Title)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink1TitleCrossSymbol)).click();
		//Click on delete link 2 cross symbol of URL
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink1URLCrossSymbol)).click();
		//Save case
		try{
			share.scrollToTop(driver);
		}catch (org.openqa.selenium.ScriptTimeoutException r)
		{
			Thread.sleep(3000);
			share.scrollToTop(driver);
		}
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSaveButton)).click();
		//Clicks on create case
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupConfirmButton)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on Errorfree bank option
		if (driver.findElement(equipObj.EquipCasesLink).isDisplayed()==false)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankAdminLink)).click();
		}
		//Clicks on Equipment cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Enter FM case id with links
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSearchCaseIDAdmin)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSearchCaseIDAdmin)).sendKeys(ee_case.get(2));
		Thread.sleep(2000);
		//Clicks on case id
	/*	ele = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSearchCaseIDDropdownAdmin));
		List<WebElement> casesList1 = ele.findElements(By.tagName("li"));
		for(WebElement li : casesList1)
		{
			if(li.getText().equals(ee_case.get(2)))
				li.click();
		}*/
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSearchCaseIDDropdownAdmin)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		//Scroll up
		Thread.sleep(1000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Click on Edit
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseEditButton)).click();
		//Scroll to 1st Link title
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink2Title));
		share.scrollToElement(driver, l);
		//delete 2 to 12
		for(int i=1;i<=11;i++)
		{
			//Click on delete link 2 cross symbol of URL
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink2URLCrossSymbol)).click();
			//Click on delete link 2 cross symbol of Title
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink2TitleCrossSymbol)).click();
			Thread.sleep(500);
		}		
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		if (browserName.contains("internet")==true)
		{
			while(true)
			{
				try{
					share.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink2URLCrossSymbol)));
					//Click on delete link 1 cross symbol of URL
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink2URLCrossSymbol)).click();
					//Click on delete link 1 cross symbol of Title
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink2TitleCrossSymbol)).click();
				}catch(org.openqa.selenium.TimeoutException t)
				{
					break;
				}
			}
		}
		//Click on delete link 1 cross symbol of URL
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink1URLCrossSymbol)).click();
		//Click on delete link 1 cross symbol of Title
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink1TitleCrossSymbol)).click();
		if (browserName.contains("internet")==true)
		{
			while(true)
			{
				try{
					share.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink1URLCrossSymbol)));
					//Click on delete link 1 cross symbol of URL
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink1URLCrossSymbol)).click();
					//Click on delete link 1 cross symbol of Title
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink1TitleCrossSymbol)).click();
				}catch(org.openqa.selenium.TimeoutException t)
				{
					break;
				}
			}
		}
		//Save case
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSaveButton)).click();
		//Clicks on create case
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupConfirmButton)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(1000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Verify no text from previous links present in text boxes
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink1Title)).getAttribute("textContent");
		softly.assertThat(s).as("test data").isEmpty();
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink1URL)).getAttribute("textContent");
		softly.assertThat(s1).as("test data").isEmpty();
		try{
			WebDriverWait wait1 = new WebDriverWait(driver,3);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink2Title));
			softly.fail("after deleting all links still there is an extra link row visible");
		}catch(org.openqa.selenium.NoSuchElementException |org.openqa.selenium.TimeoutException r)
		{

		}
		//Go back to case browse and verify that no Related Links slide
		//Clicks on Error free bank
		WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankTopLink));
		/*Actions act = new Actions(driver);
		act.click(element1).build().perform();*/
		element1.click();
		//Go to  FM
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.FailureModeLink)).click();
		Thread.sleep(1000);
		//Browse case 
		//Check for case
		//Enters case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchCaseIdField)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchCaseIdField)).sendKeys(ee_case.get(2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchCaseIdField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Click on collapsible 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+ee_case.get(2)))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.SlidePreviousButton)).click();
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
	}

	public void editLinks (WebDriver driver, List<String> ee_case) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.LoginNameOnTopRight)).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(chc.AdminOption)).click();
		Thread.sleep(1000);
		//Clicks on Errorfree bank option
		if (driver.findElement(equipObj.EquipCasesLink).isDisplayed()==false)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankAdminLink)).click();
		}
		//Clicks on Equipment cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(1000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Enter FM case id with links
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSearchCaseIDAdmin)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSearchCaseIDAdmin)).sendKeys(ee_case.get(2));
		Thread.sleep(2000);
		//Clicks on case id
	/*	WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSearchCaseIDDropdownAdmin));
		List<WebElement> casesList = ele.findElements(By.tagName("li"));
		for(WebElement li : casesList)
		{
			if(li.getText().equals(ee_case.get(2)))
				li.click();
		}*/
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSearchCaseIDDropdownAdmin)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		//Click on Edit
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseEditButton)).click();
		//Scroll to 1st Link title
		WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink1Title));
		share.scrollToElement(driver, l);
		//Edit link title
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink1Title)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink1Title)).sendKeys("Edited: "+videoLinkTitle1);
		//Save case
		Thread.sleep(2000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSaveButton)).click();
		//Clicks on create case
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupConfirmButton)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(1000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on Error free bank
		WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankTopLink));
		element1.click();
		//Go to  FM
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.FailureModeLink)).click();
		Thread.sleep(1000);
		//Check for case
		//Enters case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchCaseIdField)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchCaseIdField)).sendKeys(ee_case.get(2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchCaseIdField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Click on collapsible 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+ee_case.get(2)))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.SlidePreviousButton)).click();
		//Click on previous
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.SlidePreviousButton)).click();
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
	}

	public void viewCaseInAdmin(WebDriver driver, List<String> eq_case, List<String> ee_case, String keyword_same_eq) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,20);
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.LoginNameOnTopRight)).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(chc.AdminOption)).click();
		Thread.sleep(1000);
		//Clicks on Errorfree bank option
		if (driver.findElement(equipObj.EquipCasesLink).isDisplayed()==false)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankAdminLink)).click();
		}
		//Clicks on Equipment cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(1000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Enter FM case id with links
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSearchCaseIDAdmin)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSearchCaseIDAdmin)).sendKeys(ee_case.get(2));
		Thread.sleep(2000);
		//Clicks on case id
	/*	WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSearchCaseIDDropdownAdmin));
		List<WebElement> casesList = ele.findElements(By.tagName("li"));
		for(WebElement li : casesList)
		{
			if(li.getText().equals(ee_case.get(2)))
				li.click();
		}*/
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSearchCaseIDDropdownAdmin)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		//Enter Equipment Performance case id without links
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSearchCaseIDAdmin)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSearchCaseIDAdmin)).sendKeys(eq_case.get(2));
		Thread.sleep(2000);
		//Clicks on case id
	/*	ele = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSearchCaseIDDropdownAdmin));
		List<WebElement> casesList1 = ele.findElements(By.tagName("li"));
		for(WebElement li : casesList1)
		{
			if(li.getText().equals(eq_case.get(2)))
				li.click();
		}*/
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSearchCaseIDDropdownAdmin)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		//Verify all fields
		verifyCaseFieldsInAdmin(driver, keyword_same_eq);
		Thread.sleep(1000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Click on Edit
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseEditButton)).click();
		Thread.sleep(2000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSaveButton)).click();
		//Clicks on create case
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupConfirmButton)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(1000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Verify all fields
		verifyCaseFieldsInAdmin(driver, keyword_same_eq);
		//Verify new case form after viewing case with links
		verifyNewCaseForm(driver, ee_case.get(2));
	}

	public void verifyNewCaseForm(WebDriver driver, String caseID) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,40);
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.LoginNameOnTopRight)).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(chc.AdminOption)).click();
		Thread.sleep(1000);
		//Clicks on Errorfree bank option
		if (driver.findElement(equipObj.EquipCasesLink).isDisplayed()==false)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankAdminLink)).click();
		}
		//Clicks on Equip cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(1000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(1000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Enter case id with links
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSearchCaseIDAdmin)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSearchCaseIDAdmin)).sendKeys(caseID);
		Thread.sleep(2000);
		//Clicks on case id
	/*	WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSearchCaseIDDropdownAdmin));
		List<WebElement> casesList = ele.findElements(By.tagName("li"));
		for(WebElement li : casesList)
		{
			if(li.getText().equals(caseID))
				li.click();
		}*/
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSearchCaseIDDropdownAdmin)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(1000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on new case button
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewButton)).click();
		//Clicks on new case
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupConfirmButton)).click();
		//Verify Link title is empty
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink1Title)).getAttribute("textContent");
		softly.assertThat(s).as("test data").isEmpty();
		//Verify Link url is empty
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink1URL)).getAttribute("textContent");
		softly.assertThat(s1).as("test data").isEmpty();
		//Verify case id is empty
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseIDField)).getAttribute("textContent");
		softly.assertThat(s2).as("test data").isEmpty();
		//Verify questions is empty
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseQuestion)).getAttribute("textContent");
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
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseAnswer)).getAttribute("textContent");
		if (browserName.contains("internet")==true)
		{
			softly.assertThat(s4).as("test data").isEqualTo("Enter case answer");
		}
		else
			softly.assertThat(s4).as("test data").isEmpty();
		//Verify type is empty
		String s5 = driver.findElement(equipObj.EquipCasesTypeList).getText();
		softly.assertThat(s5).as("test data").isEqualTo("");
		//Verify discipline is empty
		String s6 = driver.findElement(equipObj.EquipCasesDisciplineList).getText();
		softly.assertThat(s6).as("test data").isEqualTo("");
		//Verify field is empty
		String s7 = driver.findElement(equipObj.EquipCasesFieldList).getText();
		softly.assertThat(s7).as("test data").isEqualTo("");
		//Verify no keywords present
		try{
			WebDriverWait wait1 = new WebDriverWait(driver,4);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseExistingKeywordOnlyOne));
			softly.fail("keyword present in new form");
		}catch (org.openqa.selenium.TimeoutException r)
		{

		}
		Thread.sleep(1000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on Equip cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
	}

	public void verifyCaseFieldsInAdmin(WebDriver driver, String keyword_same) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify Link title is empty
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink1Title)).getAttribute("textContent");
		softly.assertThat(s).as("test data").isEmpty();
		//Verify Link url is empty
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink1URL)).getAttribute("textContent");
		softly.assertThat(s1).as("test data").isEmpty();
		//Verify keyword
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseExistingKeywordOnlyOne)).getText();
		softly.assertThat(s2).as("test data").isEqualTo(keyword_same);
	}



	public void addKeywordKALE2168(WebDriver driver, List<String> caseID, String keyword_same) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Add keyword
		equip3.addKeywordEquip(driver,caseID.get(2),keyword_same+"added");
		//Clicks on Equipment Performance Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentPerformanceLink)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		//Checks for search method with magnifying glass
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(keyword_same+"added");
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseID.get(2))));
	}

	public void changeKeywordKALE1969(WebDriver driver, List<String> caseID, String keyword_same) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.LoginNameOnTopRight)).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(chc.AdminOption)).click();
		Thread.sleep(1000);
		//Clicks on Errorfree bank option
		if (driver.findElement(equipObj.EquipCasesLink).isDisplayed()==false)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankAdminLink)).click();
		}
		//Clicks on Equipment cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(1000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//CLick on enter case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSearchCaseIDAdmin)).sendKeys(caseID.get(1));
		Thread.sleep(2000);
		//Clicks on case id
	/*	WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSearchCaseIDDropdownAdmin));
		List<WebElement> casesList = ele.findElements(By.tagName("li"));
		for(WebElement li : casesList)
		{
			if(li.getText().equals(caseID.get(1)))
				li.click();
		}*/
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSearchCaseIDDropdownAdmin)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(1000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Click on Edit
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseEditButton)).click();
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseExistingKeywordOnlyOne)).click();
		Thread.sleep(2000);
		//Clicks on remove keyword
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupConfirmButton)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(keyword_same+"changed");
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
		Thread.sleep(1000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSaveButton)).click();
		//Clicks on create case
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupConfirmButton)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(1000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on Error free bank
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankTopLink)).click();
		}catch (UnhandledAlertException f){			  
			driver.switchTo().alert().dismiss();
		}
		//Clicks on Human Performance Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentPerformanceLink)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		//Checks for search method with magnifying glass
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(keyword_same+"changed");
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseID.get(1))));
	}



	public void verifyTypesList(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verifies that list contains the required options
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListTypesAdvancedLearning)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Advanced Learning");
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListTypesCaseStudies)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Case Studies");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListTypesDesign)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Design");
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListTypesFailureModes)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("Failure Modes");
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListTypesFundamentals)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Fundamentals");
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListTypesGeneral)).getText();
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
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseTypes)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseTypes)).sendKeys(Keys.ENTER);
			}
			if (v.startsWith("11")==true)
			{
				//Type
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseTypes)).click();
			}
		}
		else{
			//Type
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseTypes)).click();
		}
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListBoxTypes));
		//Verify types list
		verifyTypesList(driver);
		if(title.equals(ee_title)||title.equals(ee_titleUS)||title.equals(ee_titleie11US)||title.equals(me_title)||title.equals(me_titleUS)||title.equals(me_titleie11US)||title.equals(me_titleie11)||title.equals(ee_titleie11))
		{
			if (browserName.contains("internet")==true)
			{
				equip3.clickTypesDisciplineIE(driver, equipObj.EquipListTypesFailureModes);			    	
			}
			else
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListTypesFailureModes)).click();
		}
		if(count<5){
			if(title.equals(eq_title)||title.equals(eq_titleUS)||title.equals(eq_titleie11US)||title.equals(eq_titleie11))
			{
				if (browserName.contains("internet"))
				{
					equip3.clickTypesDisciplineIE(driver, equipObj.EquipListTypesAdvancedLearning);			    	
				}
				else
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListTypesAdvancedLearning)).click();		 
			}
		}		
		//Choose a number between 1 and 6 for number of types
		Random random = new Random ();
		int y;
		if(count == 5)
		{
			if(title.equals(eq_title)||title.equals(eq_titleUS)||title.equals(eq_titleie11US)||title.equals(eq_titleie11))
			{
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
								equip3.clickTypesDisciplineIE(driver, equipObj.EquipListTypesAdvancedLearning);
							}
							else
								wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListTypesAdvancedLearning)).click();
							categories.add("Advanced Learning");
						}
					}
					if(x==2)
					{
						if(categories.contains("Case Studies")==false)
						{
							if (browserName.contains("internet"))
							{
								equip3.clickTypesDisciplineIE(driver, equipObj.EquipListTypesCaseStudies);
							}
							else
								wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListTypesCaseStudies)).click();
							categories.add("Case Studies");
						}
					}
					if(x==3)
					{
						if(categories.contains("Design")==false)
						{
							if (browserName.contains("internet"))
							{
								equip3.clickTypesDisciplineIE(driver, equipObj.EquipListTypesDesign);
							}
							else
								wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListTypesDesign)).click();
							categories.add("Design");
						}
					}
					if(x==4)
					{
						if(categories.contains("Failure Modes")==false)
						{
							if (browserName.contains("internet"))
							{
								equip3.clickTypesDisciplineIE(driver, equipObj.EquipListTypesFailureModes);
							}
							else
								wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListTypesFailureModes)).click();
							categories.add("Failure Modes");
						}
					}
					if(x==5)
					{
						if(categories.contains("Fundamentals")==false)
						{
							if (browserName.contains("internet"))
							{
								equip3.clickTypesDisciplineIE(driver, equipObj.EquipListTypesFundamentals);
							}
							else
								wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListTypesFundamentals)).click();
							categories.add("Fundamentals");
						}
					}
					if(categories.contains("General")==false)
					{
						if (browserName.contains("internet"))
						{
							equip3.clickTypesDisciplineIE(driver, equipObj.EquipListTypesGeneral);
						}
						else
							wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListTypesGeneral)).click();
						categories.add("General");
					}
				}
			}}
		try{
			driver.findElement(equipObj.ListCrossSymbol).click();
		}catch (NoSuchElementException | ElementNotInteractableException e)
		{
			driver.findElement(equipObj.EquipListBoxTypesCrossSymbol).click();
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
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseTypes)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseTypes)).sendKeys(Keys.ENTER);
			}
			if (v.startsWith("11")==true)
			{
				//Type
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseTypes)).click();
			}
		}
		else{
			//Type
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseTypes)).click();
		}
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListBoxTypes));
		if (browserName.contains("internet"))
		{
			equip3.clickTypesDisciplineIE(driver, equipObj.EquipListTypesAdvancedLearning);	
			equip3.clickTypesDisciplineIE(driver, equipObj.EquipListTypesCaseStudies);
			equip3.clickTypesDisciplineIE(driver, equipObj.EquipListTypesDesign);
			equip3.clickTypesDisciplineIE(driver, equipObj.EquipListTypesFailureModes);
			equip3.clickTypesDisciplineIE(driver, equipObj.EquipListTypesFundamentals);
			equip3.clickTypesDisciplineIE(driver, equipObj.EquipListTypesGeneral);
		}
		else
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListTypesAdvancedLearning)).click();		
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListTypesCaseStudies)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListTypesDesign)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListTypesFailureModes)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListTypesFundamentals)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListTypesGeneral)).click();
		}
		try{
			driver.findElement(equipObj.ListCrossSymbol).click();
		}catch (NoSuchElementException | ElementNotInteractableException e)
		{
			driver.findElement(equipObj.EquipListBoxTypesCrossSymbol).click();
		}
	}

	public void searchFailurModeCaseWith2Discipline(WebDriver driver, String keyword, String caseId) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,40);
		Thread.sleep(1000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on Error free bank
		WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankTopLink));
		element1.click();
		Thread.sleep(1000);
		try{
			//Go to  FM
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.FailureModeLink)).click();
		}catch(org.openqa.selenium.TimeoutException r)
		{
			element1.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.FailureModeLink)).click();
		}
		Thread.sleep(2000);
		//Check for case
		//Enters case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId)));
		//Clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
	}

	public void searchCaseWithMultipleCategories(WebDriver driver, List<String> categories, String caseId) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,40);
		Thread.sleep(1000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		if (categories.contains("Case Studies")||categories.contains("Advanced Learning")||categories.contains("General"))
		{
			//Clicks on Error free bank
			WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankTopLink));
			element1.click();
			Thread.sleep(1000);
			//Go to Equipment Performance
			try{
				wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentPerformanceLink)).click();
			}catch (org.openqa.selenium.TimeoutException w)
			{
				Thread.sleep(1000);
				element1.click();
				Thread.sleep(1000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentPerformanceLink)).click();
			}
			Thread.sleep(1000);
			//Check for case
			//Enters case id
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchCaseIdField)).sendKeys(caseId);
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchCaseIdField)).sendKeys(Keys.ENTER);
			//Wait for loading message to disappear
			share2.loadingServer(driver);
			//Clicks on case
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId)));
		}
		if (categories.contains("Failure Mode"))
		{
			//Clicks on Error free bank
			WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankTopLink));
			element1.click();
			Thread.sleep(1000);
			//Go to  FM
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.FailureModeLink)).click();
			Thread.sleep(1000);
			//Check for case
			//Enters case id
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchCaseIdField)).sendKeys(caseId);
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchCaseIdField)).sendKeys(Keys.ENTER);
			//Wait for loading message to disappear
			share2.loadingServer(driver);
			//Clicks on case
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId)));
		}
		if (categories.contains("Design"))
		{
			//Clicks on Error free bank
			WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankTopLink));
			element1.click();
			Thread.sleep(1000);
			//Go to Prevention of Design Deficiencies
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.PreventionOfDesignDeficienciesLink)).click();
			Thread.sleep(1000);
			//Check for case
			//Enters case id
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchCaseIdField)).sendKeys(caseId);
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchCaseIdField)).sendKeys(Keys.ENTER);
			//Wait for loading message to disappear
			share2.loadingServer(driver);
			//Clicks on case
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId)));
		}
		if (categories.contains("Fundamentals"))
		{
			//Clicks on Error free bank
			WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankTopLink));
			element1.click();
			Thread.sleep(1000);
			//Go to Engineering Fundamentals
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EngineeringFundamentalsLink)).click();
			Thread.sleep(1000);
			//Check for case
			//Enters case id
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchCaseIdField)).sendKeys(caseId);
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchCaseIdField)).sendKeys(Keys.ENTER);
			//Wait for loading message to disappear
			share2.loadingServer(driver);
			//Clicks on case
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId)));
		}
	}

	public void verifyFieldsList(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verifies that list contains the required options
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListFieldsAuto)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Auto");
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListFieldsNuclear)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Nuclear");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListFieldsOther)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Other");
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListFieldsPharmaceutical)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("Pharmaceutical");
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListFieldsWelding)).getText();
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
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseFields)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseFields)).sendKeys(Keys.ENTER);
			}
			if (v.startsWith("11")==true)
			{
				//Fields
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseFields)).click();
			}
		}
		else{
			//Fields
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseFields)).click();
		}
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListBoxFields));	
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
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListFieldsAuto)).click();			
		}
		if(x==2)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListFieldsNuclear)).click();				
		}
		if(x==3)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListFieldsOther)).click();			
		}
		if(x==4)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListFieldsPharmaceutical)).click();			
		}
		if(x==5)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListFieldsWelding)).click();			
		}
		try{
			driver.findElement(equipObj.ListCrossSymbol).click();
		}catch (NoSuchElementException | ElementNotInteractableException e)
		{
			driver.findElement(equipObj.EquipListBoxFieldsCrossSymbol).click();
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
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseFields)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseFields)).sendKeys(Keys.ENTER);
			}
			if (v.startsWith("11")==true)
			{
				//Fields
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseFields)).click();
			}
		}
		else{
			//Fields
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseFields)).click();
		}
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListBoxFields));	
		//Click all fields
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListFieldsAuto)).click();		
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListFieldsNuclear)).click();				
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListFieldsOther)).click();			
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListFieldsPharmaceutical)).click();			
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListFieldsWelding)).click();	
		try{
			driver.findElement(equipObj.ListCrossSymbol).click();
		}catch (NoSuchElementException | ElementNotInteractableException e)
		{
			driver.findElement(equipObj.EquipListBoxFieldsCrossSymbol).click();
		}
	}

	public void verifyDisciplineList(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verifies that list contains the required options
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListDisciplineElectrical)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Electrical");
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListDisciplineGeneral)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("General");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListDisciplineIC)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("I&C");
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListDisciplineMechanical)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("Mechanical");
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListDisciplineSoftware)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Software");
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListDisciplineStructural)).getText();
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
				equip3.clickTypesDisciplineIE(driver, equipObj.EquipListDisciplineElectrical);
			}
			else
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListDisciplineElectrical)).click();			
		}
		if(x==2)
		{
			if (browserName.contains("internet")==true)
			{
				equip3.clickTypesDisciplineIE(driver, equipObj.EquipListDisciplineGeneral);
			}
			else
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListDisciplineGeneral)).click();				
		}
		if(x==3)
		{
			if (browserName.contains("internet")==true)
			{
				equip3.clickTypesDisciplineIE(driver, equipObj.EquipListDisciplineIC);
			}
			else
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListDisciplineIC)).click();			
		}
		if(x==4)
		{
			if (browserName.contains("internet")==true)
			{
				equip3.clickTypesDisciplineIE(driver, equipObj.EquipListDisciplineMechanical);
			}
			else
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListDisciplineMechanical)).click();		
		}
		if(x==5)
		{
			if (browserName.contains("internet")==true)
			{
				equip3.clickTypesDisciplineIE(driver, equipObj.EquipListDisciplineSoftware);
			}
			else
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListDisciplineSoftware)).click();			
		}
		if(x==6)
		{
			if (browserName.contains("internet")==true)
			{
				equip3.clickTypesDisciplineIE(driver, equipObj.EquipListDisciplineStructural);
			}
			else
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListDisciplineStructural)).click();		
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
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseDiscipline)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseDiscipline)).sendKeys(Keys.ENTER);
			}
			if (v.startsWith("11")==true)
			{
				//Discipline
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseDiscipline)).click();
			}
		}
		else{
			//Discipline
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseDiscipline)).click();
		}
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListBoxDiscipline));	 
		//Verify Discipline list
		verifyDisciplineList(driver);
		if(title.equals(ee_title)||title.equals(ee_titleUS)||title.equals(ee_titleie11US)||title.equals(ee_titleie11))
		{
			if (browserName.contains("internet")==true)
			{
				equip3.clickTypesDisciplineIE(driver, equipObj.EquipListDisciplineElectrical);
			}
			else
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListDisciplineElectrical)).click();		
		}
		if(title.equals(me_title)||title.equals(me_titleUS)||title.equals(me_titleie11US)||title.equals(me_titleie11))
		{
			if (browserName.contains("internet")==true)
			{
				equip3.clickTypesDisciplineIE(driver, equipObj.EquipListDisciplineMechanical);
			}
			else
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListDisciplineMechanical)).click();	
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
			driver.findElement(equipObj.ListCrossSymbol).click();
		}catch (NoSuchElementException | ElementNotInteractableException e)
		{
			driver.findElement(equipObj.EquipListBoxDisciplineCrossSymbol).click();
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
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseDiscipline)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseDiscipline)).sendKeys(Keys.ENTER);
			}
			if (v.startsWith("11")==true)
			{
				//Discipline
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseDiscipline)).click();
			}
		}
		else{
			//Discipline
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseDiscipline)).click();
		}
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListBoxDiscipline));	 
		if (browserName.contains("internet")==true)
		{
			equip3.clickTypesDisciplineIE(driver, equipObj.EquipListDisciplineElectrical);
			equip3.clickTypesDisciplineIE(driver, equipObj.EquipListDisciplineGeneral);
			equip3.clickTypesDisciplineIE(driver, equipObj.EquipListDisciplineIC);
			equip3.clickTypesDisciplineIE(driver, equipObj.EquipListDisciplineMechanical);
			equip3.clickTypesDisciplineIE(driver, equipObj.EquipListDisciplineSoftware);
			equip3.clickTypesDisciplineIE(driver, equipObj.EquipListDisciplineStructural);
		}
		else
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListDisciplineElectrical)).click();	
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListDisciplineGeneral)).click();	
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListDisciplineIC)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListDisciplineMechanical)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListDisciplineSoftware)).click();	
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListDisciplineStructural)).click();
		}
		try{
			driver.findElement(equipObj.ListCrossSymbol).click();
		}catch (NoSuchElementException | ElementNotInteractableException e)
		{
			driver.findElement(equipObj.EquipListBoxDisciplineCrossSymbol).click();
		}
	}

	public void searchEquipmentDatabankOnly(WebDriver driver, String keyword_same, List<String> caseId, String username, String password)throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Login obj = new Login();
		CaseBrowse obj2 = new CaseBrowse();
		//Logout as admin/new user
		login.logout(driver);
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
		int login1 = login.LoginUser(driver, username, password);
		System.out.println("Title after login: "+driver.getTitle());
		Thread.sleep(5000);
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
		Thread.sleep(5000);
		share2.loadingServer(driver);
		//Click on Error-free bank link
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.ErrorFreeBankLinkHomePage)).click();
		//Click on Databank Only
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentDatabankOnlyLink1)).click();
		//Clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		//Select randomly type
		selectTypeGeneralInSearchCase(driver);
		//Search for keyword
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(keyword_same);
		//Click 1st keyword in dropdown
		obj2.clickDropdownEquip(driver);
		//Wait for loading message
		share2.loadingServer(driver);
		//Look for cases with keyword and type
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId.get(0))));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId.get(1))));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId.get(2))));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId.get(3))));
		//Click on search button
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordFieldSearchButton)).click();
		//Wait for loading message
		share2.loadingServer(driver);
		//Look for cases with keyword and type
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId.get(0))));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId.get(1))));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId.get(2))));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId.get(3))));
		//Clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
	}

	public void selectTypeGeneralInSearchCase(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		String v = cap.getVersion().toString();
		if (browserName.contains("internet")==true)
		{
			if (v.startsWith("10")==true)
			{
				//Types
				wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchTypeBox));
				wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchTypeBox)).sendKeys(Keys.ENTER);
			}
			if (v.startsWith("11")==true)
			{
				//Types
				wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchTypeBox)).click();
			}
		}
		else{
			//Types
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchTypeBox)).click();
		}
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchTypeList));
		if (browserName.contains("internet"))
		{
			equip3.clickTypesDisciplineIE(driver, cb.EquipCaseSearchListTypesAdvancedLearning);
		}
		else
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipCaseSearchListTypesAdvancedLearning)).click();
		//Close Types pop up
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchTypesPopupClose)).click();
	}

	public void searchEquipmentPerformanceAllFilters(WebDriver driver, String keyword_same, String caseId, String username, String password)throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,10);
		CaseBrowse obj2 = new CaseBrowse();
		//Click on Error-free bank link
		wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankTopLink)).click();
		//Go to Equipment Performance
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentPerformanceLink)).click();
		Thread.sleep(1000);
		//Look for case in Equipment performance
		obj2.verifySearchOptionsEquip(driver, keyword_same+"joker", caseId);
		//Enters case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchCaseIdField)).sendKeys(caseId);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchCaseIdField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
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
		//Adding non video links first
		//Scroll to Link element
		WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink1Title));
		share.scrollToElement(driver, l);
		//Enter title for link 3 coconut
		l.sendKeys(noVideoLinkTitle3);
		Thread.sleep(1000);
		//Enter url 3
		wait.until(ExpectedConditions.elementToBeClickable(equipObj.EquipCasesLink1URL)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink1URL)).sendKeys(noVideoLink);	
		//To make url form appear click on title for link 1
		clickToShowNextRowForLink(driver,equipObj.EquipCasesLink1Title);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Scroll to link 2
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink2Title));
		share.scrollToElement(driver, l);
		//Enter title for link 2 banana
		l.sendKeys(noVideoLinkTitle2);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink2URL)).click();
		//Link 2 becomes Link 1
		//Enter url 2
		wait.until(ExpectedConditions.elementToBeClickable(equipObj.EquipCasesLink1URL)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink1URL)).sendKeys(noVideoLink);
		//To make url form appear click on title for link
		clickToShowNextRowForLink(driver,equipObj.EquipCasesLink1Title);
		share.scrollToTop(driver);
		//Scroll to link 3
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink3Title));
		share.scrollToElement(driver, l);
		//Enter title for link 1 apple
		l.sendKeys(noVideoLinkTitle1);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink3URL)).click();
		//Link 3 becomes Link 1
		//Enter url 3
		wait.until(ExpectedConditions.elementToBeClickable(equipObj.EquipCasesLink1URL)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink1URL)).sendKeys(noVideoLink);
		//To make url form appear click on title for link
		clickToShowNextRowForLink(driver,equipObj.EquipCasesLink1Title);
		share.scrollToTop(driver);
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
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink4Title));
		share.scrollToElement(driver, l);
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink4Title)).sendKeys(videoLinkTitle1);
		Thread.sleep(1000);
		//Enter url 4
		wait.until(ExpectedConditions.elementToBeClickable(equipObj.EquipCasesLink4URL)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink4URL)).sendKeys(videoLink);
		//Move to video checkbox
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink4VideoCheckbox));
		share.scrollToElement(driver, l);
		//Click on video checkbox
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink4VideoCheckbox)).click();
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink4VideoCheckbox));
		share.scrollToElement(driver, l);
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink4VideoCheckbox)).click();
		Thread.sleep(1000);
		//verify video link became the first link
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink1Title)).getAttribute("value");
		softly.assertThat(s).as("test data").contains(videoLinkTitle1);
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink1URL)).getAttribute("value");
		softly.assertThat(s1).as("test data").contains(videoLink);
		//Enter title for link 5 : video link 2
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink5Title));
		share.scrollToElement(driver, l);
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink5Title)).sendKeys(videoLinkTitle2);	
		Thread.sleep(1000);
		//Enter url 5
		wait.until(ExpectedConditions.elementToBeClickable(equipObj.EquipCasesLink5URL)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink5URL)).sendKeys(videoLink);
		//Move to viedo checkbox
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink5VideoCheckbox));
		share.scrollToElement(driver, l);
		//Click on video checkbox
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink5VideoCheckbox)).click();
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink5VideoCheckbox));
		share.scrollToElement(driver, l);
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink5VideoCheckbox)).click();
		Thread.sleep(1000);
		//verify video link became the first link
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink2Title)).getAttribute("value");
		softly.assertThat(s3).as("test data").contains(videoLinkTitle2);
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink2URL)).getAttribute("value");
		softly.assertThat(s4).as("test data").contains(videoLink);
		//Enter title for link 6 : video link 3
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink6Title));
		share.scrollToElement(driver, l);
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink6Title)).sendKeys(videoLinkTitle3);	
		Thread.sleep(1000);
		//Enter url 5
		wait.until(ExpectedConditions.elementToBeClickable(equipObj.EquipCasesLink6URL)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink6URL)).sendKeys(videoLink);
		//Move to video checkbox
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink6VideoCheckbox));
		share.scrollToElement(driver, l);
		//Click on video checkbox
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink6VideoCheckbox)).click();
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink6VideoCheckbox));
		share.scrollToElement(driver, l);
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink6VideoCheckbox)).click();
		Thread.sleep(1000);
		//verify video link became the first link
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink3Title)).getAttribute("value");
		softly.assertThat(s5).as("test data").contains(videoLinkTitle3);
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink3URL)).getAttribute("value");
		softly.assertThat(s6).as("test data").contains(videoLink);
		//Scroll to link 7
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink7Title));
		share.scrollToElement(driver, l);
		//Enter title for link 7
		l.sendKeys(noVideoLinkTitle4);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink7URL)).click();
		//Enter url 7
		wait.until(ExpectedConditions.elementToBeClickable(equipObj.EquipCasesLink7URL)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink7URL)).sendKeys(noVideoLink);
		//To make url form appear click on title for link
		clickToShowNextRowForLink(driver,equipObj.EquipCasesLink7Title);
		share.scrollToTop(driver);
		//Scroll to link 8
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink8Title));
		share.scrollToElement(driver, l);
		//Enter title for link 8
		l.sendKeys(noVideoLinkTitle5);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink8URL)).click();
		//Enter url 8
		wait.until(ExpectedConditions.elementToBeClickable(equipObj.EquipCasesLink8URL)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink8URL)).sendKeys(noVideoLink);
		//To make url form appear click on title for link
		clickToShowNextRowForLink(driver,equipObj.EquipCasesLink8Title);
		share.scrollToTop(driver);
		//Scroll to link 9
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink9Title));
		share.scrollToElement(driver, l);
		//Enter title for link 9
		l.sendKeys(noVideoLinkTitle6);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink9URL)).click();
		//Enter url 9
		wait.until(ExpectedConditions.elementToBeClickable(equipObj.EquipCasesLink9URL)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink9URL)).sendKeys(noVideoLink);
		//To make url form appear click on title for link
		clickToShowNextRowForLink(driver,equipObj.EquipCasesLink9Title);
		share.scrollToTop(driver);
		//Scroll to link 10
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink10Title));
		share.scrollToElement(driver, l);
		//Enter title for link 10
		l.sendKeys(noVideoLinkTitle7);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink10URL)).click();
		//Enter url 10
		wait.until(ExpectedConditions.elementToBeClickable(equipObj.EquipCasesLink10URL)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink10URL)).sendKeys(noVideoLink);
		//To make url form appear click on title for link
		clickToShowNextRowForLink(driver,equipObj.EquipCasesLink10Title);
		share.scrollToTop(driver);
		//Scroll to link 11
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink11Title));
		share.scrollToElement(driver, l);
		//Enter title for link 11
		l.sendKeys(noVideoLinkTitle8);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink11URL)).click();
		//Enter url 11
		wait.until(ExpectedConditions.elementToBeClickable(equipObj.EquipCasesLink11URL)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink11URL)).sendKeys(noVideoLink);
		//To make url form appear click on title for link
		clickToShowNextRowForLink(driver,equipObj.EquipCasesLink11Title);
		share.scrollToTop(driver);
		//Scroll to link 12
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink12Title));
		share.scrollToElement(driver, l);
		//Enter title for link 12
		l.sendKeys(noVideoLinkTitle9);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink12URL)).click();
		//Enter url 12
		wait.until(ExpectedConditions.elementToBeClickable(equipObj.EquipCasesLink12URL)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink12URL)).sendKeys(noVideoLink);
		//To make url form appear click on title for link
		clickToShowNextRowForLink(driver,equipObj.EquipCasesLink12Title);
		share.scrollToTop(driver);
		//Scroll to link 13
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink13Title));
		share.scrollToElement(driver, l);
		//Enter title for link 13
		l.sendKeys(noVideoLinkTitle10);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink13URL)).click();
		//Enter url 13
		wait.until(ExpectedConditions.elementToBeClickable(equipObj.EquipCasesLink13URL)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink13URL)).sendKeys(noVideoLink);
		//To make url form appear click on title for link
		clickToShowNextRowForLink(driver,equipObj.EquipCasesLink13Title);
		share.scrollToTop(driver);
	}

	public void addLink2FirefoxBrowser(WebDriver driver, String caseId)throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Save case
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSaveButton)).click();
		//Clicks on create case
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupConfirmButton)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		//Click on enter case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSearchCaseIDAdmin)).sendKeys(caseId);
		Thread.sleep(2000);
		//Clicks on case id
		Thread.sleep(2000);
	/*	WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSearchCaseIDDropdownAdmin));
		List<WebElement> casesList = ele.findElements(By.tagName("li"));
		for(WebElement li : casesList)
		{
			if(li.getText().equals(caseId))
				li.click();
		}*/
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSearchCaseIDDropdownAdmin)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		//Click on edi button
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseEditButton)).click();
	}

	public void addKeywordToLinkCaseAndSearchInEquipmentDatabank(WebDriver driver, List<String> caseID, String existingKeyword) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		CaseBrowse obj2 = new CaseBrowse();
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.LoginNameOnTopRight)).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(chc.AdminOption)).click();
		Thread.sleep(1000);
		//Clicks on Errorfree bank option
		if (driver.findElement(equipObj.EquipCasesLink).isDisplayed()==false)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankAdminLink)).click();
		}
		//Clicks on Equipment cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(1000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//CLick on enter case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSearchCaseIDAdmin)).sendKeys(caseID.get(2));
		Thread.sleep(2000);
		//Clicks on case id
/*		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSearchCaseIDDropdownAdmin));
		List<WebElement> casesList = ele.findElements(By.tagName("li"));
		for(WebElement li : casesList)
		{
			if(li.getText().equals(caseID.get(2)))
				li.click();
		}*/
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSearchCaseIDDropdownAdmin)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(1000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Click on Edit
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseEditButton)).click();
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(existingKeyword);
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
		WebElement element = driver.findElement(equipObj.EquipCaseKeywordExistingList);
		element.findElement(chc.FirstAndLastChildInList).click();
		Thread.sleep(1000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSaveButton)).click();
		//Clicks on create case
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupConfirmButton)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(1000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on Error free bank
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankTopLink)).click();
		}catch (UnhandledAlertException f){			  
			driver.switchTo().alert().dismiss();
		}
		//Clicks on Equipment Databank
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentDatabankOnlyLink1)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		//Checks for search method with magnifying glass
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(existingKeyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseID.get(2))));
		verifyCaseWithLinks(driver, caseID);
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		//Enters keyword and search with dropdown
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(existingKeyword);
		Thread.sleep(2000);
		obj2.clickDropdownEquip(driver);	  
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseID.get(2))));
		verifyCaseWithLinks(driver, caseID);
	}

	public void searchCaseWithSameKeywordWithAndWithoutLinksInEquipDatabank(WebDriver driver, String keyword, List<String>ee_cases)throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,10);
		CaseBrowse obj1 = new CaseBrowse();
		//Clicks on Error free bank
		WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankTopLink));
		element1.click();
		//Go to Equipment Databank Only
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentDatabankOnlyLink1)).click();
		Thread.sleep(1000);
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		//Check for case
		//Enters keyword and search with ENTER
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		share2.loadingServer(driver);		  
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
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		//Enters keyword and search with dropdown
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(keyword);
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
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
	}

	public void verifyCasesWithoutLinks (WebDriver driver, String caseId) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,5);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Move to case collapsible
		WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId)));
		share.scrollToElement(driver, l);
		//Click on collapsible 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Move to show slides button
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-button-equip-F"+caseId)));
		share.scrollToElement(driver, l);
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
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.SlidePreviousButton)).click();
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
		share.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId))));
		//Click on collapsible to close 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId))).click();
	}

	public void verifyCaseWithLinks (WebDriver driver, List<String>cases) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,5);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Move to case collapsible
		WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+cases.get(2))));
		share.scrollToElement(driver, l);
		//Click on collapsible 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+cases.get(2)))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Move to show slides button
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-button-equip-F"+cases.get(2))));
		share.scrollToElement(driver, l);
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
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.SlidePreviousButton)).click();
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
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.SlidePreviousButton)).click();
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
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.LoginNameOnTopRight)).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(chc.AdminOption)).click();
		Thread.sleep(1000);
		if(driver.findElement(By.id("pii-admin-customers-button")).isDisplayed()==false)
		{
			//Click on Accounts
			driver.findElement(By.xpath(".//*[@id='pii-admin-accounts']/h3/a")).click();
		}
		//Clicks on Edit user
		driver.findElement(By.id("pii-admin-user-edit")).click();
		//Wait for loading message
		share2.loadingServer(driver);
		//Searches for newly created user
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-user-list']/form/div/input"))).clear();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-user-list']/form/div/input"))).sendKeys(username);
		driver.findElement(By.xpath(".//*[@id='pii-admin-user-list']/form/div/input")).sendKeys(Keys.ENTER);
		//Wait for loading message
		share2.loadingServer(driver);
		//Selects the newly created user
		WebElement select = driver.findElement(By.id("pii-admin-user-list"));
		WebElement option = select.findElement(By.cssSelector(".ui-first-child"));
		option.click();
		//Wait for loading message
		share2.loadingServer(driver);
		WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-admin-user-slidesecurity-on']")));
		share.scrollToElement(driver, l);
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
		share2.loadingServer(driver);
		Thread.sleep(1000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Click on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-button-save"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-confirmed"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(1000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
	}

	public void searchCaseWithLinks(WebDriver driver, String keyword, List<String>cases, String title)throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,10);
		Thread.sleep(1000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on Error free bank
		WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankTopLink));
		element1.click();
		Thread.sleep(1000);
		try{
			//Go to  FM
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.FailureModeLink)).click();
		}catch(org.openqa.selenium.TimeoutException r)
		{
			Thread.sleep(1000);
			share.scrollToTop(driver);
			Thread.sleep(1000);
			element1.click();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.FailureModeLink)).click();
		}
		Thread.sleep(1000);
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		//Check for case
		//Enters case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Click on collapsible 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+cases.get(2)))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.SlidePreviousButton)).click();
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.SlidePreviousButton)).click();
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
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
		driver.switchTo().frame(driver.findElement(lpo.Iframe));
		Thread.sleep(2000);
	}


	public List<String> createCaseChrome(WebDriver driver, String keyword_same, String key1, String key2, String key3, String title)throws Exception{

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebDriverWait wait = new WebDriverWait(driver,40);
		CaseBrowse obj1 = new CaseBrowse();
		List<String> categories = new ArrayList<String>();
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.LoginNameOnTopRight)).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(chc.AdminOption)).click();
		//Clicks on Errorfree bank option
		if (driver.findElement(equipObj.EquipCasesLink).isDisplayed()==false)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankAdminLink)).click();
		}			
		//Clicks on Equipment cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink)).click();			
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
				wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.LoginNameOnTopRight)).click();
				//Clicks on admin option
				wait.until(ExpectedConditions.visibilityOfElementLocated(chc.AdminOption)).click();
				//Clicks on Errorfree bank option
				if (driver.findElement(equipObj.EquipCasesLink).isDisplayed()==false)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankAdminLink)).click();
				}			
				//Clicks on Equipment cases
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink)).click();
			}
			//Waits for black loading message to disappear
			share2.loadingServer(driver);
			//Clicks on new case button
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewButton)).click();
			//Clicks on new case
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupTitle)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupConfirmButton)).click();
			//Waits for black loading message to disappear
			share2.loadingServer(driver);
			if(count==1)
			{
				if(driver.getCurrentUrl().contains("kaleqa"))
					equip3.verifyErrorOnPage(driver, softly);
			}
			while (true)
			{
				Thread.sleep(1000);
				int y=random.nextInt(10000);
				if(y<1000)
					continue;
				caseId = String.format("%d", y);
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseIDField)).sendKeys(caseId);
				Thread.sleep(1000);
				Thread.sleep(1000);
				WebElement errorCaseId;
				try{
					errorCaseId=driver.findElement(equipObj.EquipCaseIDFieldError);
				}catch(org.openqa.selenium.NoSuchElementException e)
				{
					break;
				}
				if(errorCaseId.isDisplayed()==true)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseIDField)).clear();
					continue;
				}
				if(errorCaseId.isDisplayed()==false)
					break;
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseIDField)).clear();
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
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseQuestion)).sendKeys(title);
			//Enters Answer
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseAnswer)).sendKeys(title);
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
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(keyword_same);
				Thread.sleep(4000);
				if(count==1)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).clear();
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(key1);
					Thread.sleep(4000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).clear();
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(key2);
					Thread.sleep(4000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).clear();
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(key3);
					Thread.sleep(4000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
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
					WebElement element = driver.findElement(equipObj.EquipCaseKeywordExistingList);
					element.findElement(chc.FirstAndLastChildInList).click();
				}}
			if(count == 5)
			{
				if(title.equals(ee_title)||title.equals(ee_titleUS)||title.equals(ee_titleie11US)||title.equals(ee_titleie11)||title.equals(me_title)||title.equals(me_titleUS)||title.equals(me_titleie11US)||title.equals(me_titleie11))
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).clear();
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(keyword_same+"begonia");
					Thread.sleep(2000);
					try{
						jse.executeScript("scroll(0,1700)");
					}catch (org.openqa.selenium.ScriptTimeoutException r)
					{
						Thread.sleep(3000);
						jse.executeScript("scroll(0,1700)");
					}
					Thread.sleep(1000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
				}
			}
			if(count == 6)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).clear();
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(keyword_same+"joker");
				Thread.sleep(2000);
				try{
					jse.executeScript("scroll(0,1700)");
				}catch (org.openqa.selenium.ScriptTimeoutException r)
				{
					Thread.sleep(3000);
					jse.executeScript("scroll(0,1700)");
				}
				Thread.sleep(1000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
			}
			//Uploads 5 slides
			WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipImageCollapsible));
			share.scrollToElement(driver, l);
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipImageUploadField)).click();
			Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlides.exe");
			p.waitFor();
			Thread.sleep(3000);
			//Checks if 5 images have been uploaded
			if(driver.findElement(equipObj.EquipImageCollapsibleExpanded).isDisplayed()==false)
			{
				l = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipImageCollapsible));
				share.scrollToElement(driver, l);
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
			share.scrollToTop(driver);
			Thread.sleep(1000);
			//Clicks on save
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSaveButton)).click();
			//Clicks on create case
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupTitle)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupConfirmButton)).click();
			//Waits for black loading message to disappear
			share2.loadingServer(driver);
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
		CaseBrowse obj1 = new CaseBrowse();
		List<String> categories = new ArrayList<String>();
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.LoginNameOnTopRight)).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(chc.AdminOption)).click();
		//Clicks on Errorfree bank option
		if (driver.findElement(equipObj.EquipCasesLink).isDisplayed()==false)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankAdminLink)).click();
		}	
		//Clicks on Equipment cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink)).click();	
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
				wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.LoginNameOnTopRight)).click();
				//Clicks on admin option
				wait.until(ExpectedConditions.visibilityOfElementLocated(chc.AdminOption)).click();
				//Clicks on Errorfree bank option
				if (driver.findElement(equipObj.EquipCasesLink).isDisplayed()==false)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankAdminLink)).click();
				}			
				//Clicks on Equipment cases
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink)).click();
			}
			//Waits for black loading message to disappear
			share2.loadingServer(driver);
			share2.loadingServer(driver);
			//Scroll to top
			Thread.sleep(1000);
			share.scrollToTop(driver);
			Thread.sleep(1000);
			//Clicks on new case button
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewButton)).click();
			//Clicks on new case
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupTitle)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupConfirmButton)).click();
			//Waits for black loading message to disappear
			share2.loadingServer(driver);
			//Scroll to top
			Thread.sleep(1000);
			share.scrollToTop(driver);
			Thread.sleep(1000);
			if(count==1)
			{
				if(driver.getCurrentUrl().contains("kaleqa"))
					equip3.verifyErrorOnPage(driver, softly);
			}
			while (true)
			{
				Thread.sleep(1000);
				int y=random.nextInt(10000);
				if(y<1000)
					continue;
				caseId = String.format("%d", y);
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseIDField)).sendKeys(caseId);
				Thread.sleep(1000);
				Thread.sleep(1000);
				WebElement errorCaseId;
				try{
					errorCaseId=driver.findElement(equipObj.EquipCaseIDFieldError);
				}catch(org.openqa.selenium.NoSuchElementException e)
				{
					break;
				}
				if(errorCaseId.isDisplayed()==true)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseIDField)).clear();
					continue;
				}
				if(errorCaseId.isDisplayed()==false)
					break;
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseIDField)).clear();
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
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseQuestion)).sendKeys(title);
			//Enters Answer
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseAnswer)).sendKeys(title);
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
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(keyword_same);
				Thread.sleep(2000);
				if(count==1)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).clear();
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(key1);
					Thread.sleep(2000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).clear();
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(key2);
					Thread.sleep(2000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).clear();
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(key3);
					Thread.sleep(2000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
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
					WebElement element = driver.findElement(equipObj.EquipCaseKeywordExistingList);
					element.findElement(chc.FirstAndLastChildInList).click();
				}}
			if(count == 5)
			{
				if(title.equals(ee_title)||title.equals(ee_titleUS)||title.equals(ee_titleie11US)||title.equals(ee_titleie11)||title.equals(me_title)||title.equals(me_titleUS)||title.equals(me_titleie11US)||title.equals(me_titleie11))
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).clear();
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(keyword_same+"begonia");
					Thread.sleep(2000);
					try{
						jse.executeScript("scroll(0,1700)");
					}catch (org.openqa.selenium.ScriptTimeoutException r)
					{
						Thread.sleep(3000);
						jse.executeScript("scroll(0,1700)");
					}
					Thread.sleep(1000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
				}
			}
			if(count == 6)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).clear();
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(keyword_same+"joker");
				Thread.sleep(2000);
				try{
					jse.executeScript("scroll(0,1700)");
				}catch (org.openqa.selenium.ScriptTimeoutException r)
				{
					Thread.sleep(3000);
					jse.executeScript("scroll(0,1700)");
				}
				Thread.sleep(1000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
			}
			//Uploads 5 slides
			WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipImageCollapsible));
			share.scrollToElement(driver, l);/*
			String uploadFilePath1 = "C:/Users/rramakrishnan/KALE Case Test 1-20/KALE Case Test 1-20/Upload5/Slide1.png";
			String uploadFilePath2 = "C:/Users/rramakrishnan/KALE Case Test 1-20/KALE Case Test 1-20/Upload5/Slide2.png";
			String uploadFilePath3 = "C:/Users/rramakrishnan/KALE Case Test 1-20/KALE Case Test 1-20/Upload5/Slide3.png";
			String uploadFilePath4 = "C:/Users/rramakrishnan/KALE Case Test 1-20/KALE Case Test 1-20/Upload5/Slide4.png";
			String uploadFilePath5 = "C:/Users/rramakrishnan/KALE Case Test 1-20/KALE Case Test 1-20/Upload5/Slide5.png";*/
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipImageUploadField)));
			Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlides_Firefox.exe");
			p.waitFor();
			Thread.sleep(3000);
			//Checks if 5 images have been uploaded
			if(driver.findElement(equipObj.EquipImageCollapsibleExpanded).isDisplayed()==false)
			{
				l = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipImageCollapsible));
				share.scrollToElement(driver, l);
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
			share.scrollToTop(driver);
			Thread.sleep(1000);
			//Clicks on save
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSaveButton)).click();
			//Clicks on create case
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupTitle)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupConfirmButton)).click();
			//Waits for black loading message to disappear
			share2.loadingServer(driver);
			share2.loadingServer(driver);
			//Scroll to top
			Thread.sleep(1000);
			share.scrollToTop(driver);
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
		CaseBrowse obj1 = new CaseBrowse();
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
					if (driver.findElement(lpo.StickyNote).isDisplayed())
					{
						Thread.sleep(1000);
						wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.StickyClose)).click();

					}
				}catch (NoSuchElementException e)
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
				if(driver.findElement(chc.AdminOption).isDisplayed()==false)
				{
					//Clicks on admin user name on top right corner
					wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.LoginNameOnTopRight)).click();
				}
				else
				{
					//Clicks on admin option
					wait.until(ExpectedConditions.visibilityOfElementLocated(chc.AdminOption)).click();
					break;
				}
			}
			//Clicks on Errorfree bank option
			if (driver.findElement(equipObj.EquipCasesLink).isDisplayed()==false)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankAdminLink)).click();
			}	
			//Clicks on Equipment cases
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink)).click();	
			//Waits for black loading message to disappear
			share2.loadingServer(driver);
			share2.loadingServer(driver);
			//Scroll to top
			Thread.sleep(1000);
			share.scrollToTop(driver);
			Thread.sleep(1000);
			//Clicks on new case button
			WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewButton));
			ele.click();
			//Clicks on new case
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupTitle));
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupConfirmButton));
			ele.click();
			//Waits for black loading message to disappear
			share2.loadingServer(driver);
			share2.loadingServer(driver);
			//Scroll to top
			Thread.sleep(1000);
			share.scrollToTop(driver);
			Thread.sleep(1000);
			if(count==1)
			{
				if(driver.getCurrentUrl().contains("kaleqa"))
					equip3.verifyErrorOnPage(driver, softly);
			}
			while (true)
			{
				Thread.sleep(1000);
				int y=random.nextInt(10000);
				if(y<1000)
					continue;
				caseId = String.format("%d", y);
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseIDField)).sendKeys(caseId);
				Thread.sleep(1000);
				Thread.sleep(1000);
				WebElement errorCaseId;
				try{
					errorCaseId=driver.findElement(equipObj.EquipCaseIDFieldError);
				}catch(org.openqa.selenium.NoSuchElementException e)
				{
					break;
				}
				if(errorCaseId.isDisplayed()==true)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseIDField)).clear();
					continue;
				}
				if(errorCaseId.isDisplayed()==false)
					break;
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseIDField)).clear();
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
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseQuestion)).sendKeys(title);
			//Enters Answer
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseAnswer)).sendKeys(title);
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
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(keyword_same);
				Thread.sleep(2000);
				if(count==1)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).clear();
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(key1);
					Thread.sleep(2000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).clear();
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(key2);
					Thread.sleep(2000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).clear();
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(key3);
					Thread.sleep(2000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
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
					WebElement element = driver.findElement(equipObj.EquipCaseKeywordExistingList);
					element.findElement(chc.FirstAndLastChildInList).click();
				}}
			if(count == 5)
			{
				if(title.equals(ee_title)||title.equals(ee_titleUS)||title.equals(ee_titleie11US)||title.equals(ee_titleie11)||title.equals(me_title)||title.equals(me_titleUS)||title.equals(me_titleie11US)||title.equals(me_titleie11))
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).clear();
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(keyword_same+"begonia");
					Thread.sleep(2000);
					try{
						jse.executeScript("scroll(0,1700)");
					}catch (org.openqa.selenium.ScriptTimeoutException r)
					{
						Thread.sleep(3000);
						jse.executeScript("scroll(0,1700)");
					}
					Thread.sleep(1000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
				}
			}
			if(count == 6)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).clear();
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(keyword_same+"joker");
				Thread.sleep(2000);
				try{
					jse.executeScript("scroll(0,1700)");
				}catch (org.openqa.selenium.ScriptTimeoutException r)
				{
					Thread.sleep(3000);
					jse.executeScript("scroll(0,1700)");
				}
				Thread.sleep(1000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
			}
			//Uploads 5 slides
			WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipImageCollapsible));
			share.scrollToElement(driver, l);
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipImageUploadField));
			jse.executeScript("return document.getElementById('pii-admin-efse-upload-file-input').click();");
			Thread.sleep(3000);
			Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlides_IE10.exe");
			p.waitFor();
			Thread.sleep(3000);
			//Checks if 5 images have been uploaded
			if(driver.findElement(equipObj.EquipImageCollapsibleExpanded).isDisplayed()==false)
			{
				l = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipImageCollapsible));
				share.scrollToElement(driver, l);
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
			if(count==3)
			{
				if(title.equals(ee_title)||title.equals(ee_titleUS)||title.equals(ee_titleie11US)||title.equals(ee_titleie11))
				{
					addLinks(driver,title,caseId);
				}
			}
			share.scrollToTop(driver);
			Thread.sleep(1000);
			//Clicks on save
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSaveButton)).click();
			//Clicks on create case
			System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupTitle)).getText());
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupTitle)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupConfirmButton)).click();
			//Waits for black loading message to disappear
			share2.loadingServer(driver);
			share2.loadingServer(driver);
			//Scroll to top
			Thread.sleep(1000);
			share.scrollToTop(driver);
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
		CaseBrowse obj1 = new CaseBrowse();
		//Login obj3 = new Login();
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
			login.closePopUpSticky(driver);
			//Clicks on admin user name on top right corner
			wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.LoginNameOnTopRight)).click();
			//Clicks on admin option
			wait.until(ExpectedConditions.visibilityOfElementLocated(chc.AdminOption)).click();
			//Clicks on Errorfree bank option
			if (driver.findElement(equipObj.EquipCasesLink).isDisplayed()==false)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankAdminLink)).click();
			}	
			//Clicks on Equipment cases
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink)).click();	
			//Waits for black loading message to disappear
			share2.loadingServer(driver);
			share2.loadingServer(driver);
			//Scroll to top
			Thread.sleep(1000);
			share.scrollToTop(driver);
			Thread.sleep(1000);
			//Clicks on new case button
			/*	WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewButton));
			ele.click();*/
			jse.executeScript("return document.getElementById('pii-admin-efse-button-new').click();");
			Thread.sleep(1000);
			//Clicks on new case
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupTitle));
			WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupConfirmButton));
			ele.click();
			//Waits for black loading message to disappear
			share2.loadingServer(driver);
			share2.loadingServer(driver);
			//Scroll to top
			Thread.sleep(1000);
			share.scrollToTop(driver);
			Thread.sleep(1000);
			if(count==1)
			{
				if(driver.getCurrentUrl().contains("kaleqa"))
					equip3.verifyErrorOnPage(driver, softly);
			}
			while (true)
			{
				Thread.sleep(1000);
				int y=random.nextInt(10000);
				if(y<1000)
					continue;
				caseId = String.format("%d", y);
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseIDField)).sendKeys(caseId);
				Thread.sleep(1000);
				Thread.sleep(1000);
				WebElement errorCaseId;
				try{
					errorCaseId=driver.findElement(equipObj.EquipCaseIDFieldError);
				}catch(org.openqa.selenium.NoSuchElementException e)
				{
					break;
				}
				if(errorCaseId.isDisplayed()==true)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseIDField)).clear();
					continue;
				}
				if(errorCaseId.isDisplayed()==false)
					break;
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseIDField)).clear();
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
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseQuestion)).sendKeys(title);
			//Enters Answer
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseAnswer)).sendKeys(title);
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
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(keyword_same);
				Thread.sleep(2000);
				if(count==1)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).clear();
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(key1);
					Thread.sleep(2000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).clear();
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(key2);
					Thread.sleep(2000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).clear();
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(key3);
					Thread.sleep(2000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
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
					WebElement element = driver.findElement(equipObj.EquipCaseKeywordExistingList);
					element.findElement(chc.FirstAndLastChildInList).click();
				}}
			if(count == 5)
			{
				if(title.equals(ee_title)||title.equals(ee_titleUS)||title.equals(ee_titleie11US)||title.equals(ee_titleie11)||title.equals(me_title)||title.equals(me_titleUS)||title.equals(me_titleie11US)||title.equals(me_titleie11))
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).clear();
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(keyword_same+"begonia");
					Thread.sleep(2000);
					try{
						jse.executeScript("scroll(0,1700)");
					}catch (org.openqa.selenium.ScriptTimeoutException r)
					{
						Thread.sleep(3000);
						jse.executeScript("scroll(0,1700)");
					}
					Thread.sleep(1000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
				}
			}
			if(count == 6)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).clear();
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(keyword_same+"joker");
				Thread.sleep(2000);
				try{
					jse.executeScript("scroll(0,1700)");
				}catch (org.openqa.selenium.ScriptTimeoutException r)
				{
					Thread.sleep(3000);
					jse.executeScript("scroll(0,1700)");
				}
				Thread.sleep(1000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
			}
			//Uploads 5 slides
			WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipImageCollapsible));
			share.scrollToElement(driver, l);
			jse.executeScript("return document.getElementById('pii-admin-efse-upload-file-input').click();");
			Thread.sleep(2000);
			Process p =Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/UploadHumanCaseSlides_IE10.exe");
			p.waitFor();
			Thread.sleep(4000);
			//Checks if 5 images have been uploaded
			try{
				driver.findElement(equipObj.EquipImageCollapsibleExpanded);
			}catch(org.openqa.selenium.NoSuchElementException e)
			{
				l = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipImageCollapsible));
				share.scrollToElement(driver, l);
				l.click();
			}
			if(driver.findElement(equipObj.EquipImageCollapsibleExpanded).isDisplayed()==false)
			{
				l = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipImageCollapsible));
				share.scrollToElement(driver, l);
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
			share.scrollToTop(driver);
			Thread.sleep(1000);
			//Clicks on save
			jse.executeScript("return document.getElementById('pii-admin-efse-button-save').click();");
			Thread.sleep(1000);
			//Clicks on create case
			System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupTitle)).getText());
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupTitle));
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupConfirmButton)).click();
			//Waits for black loading message to disappear
			share2.loadingServer(driver);
			share2.loadingServer(driver);
			//Scroll to top
			Thread.sleep(1000);
			share.scrollToTop(driver);
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
		Thread.sleep(1000);
		//Clicks on Error free bank
		WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankTopLink));
		element1.click();
		Thread.sleep(2000);
		if(y==0){
			if(title.equals(eq_title)||title.equals(eq_titleUS)||title.equals(eq_titleie11US)||title.equals(eq_titleie11))
			{
				//Clicks on Equipment Performance Search
				wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentPerformanceLink)).click();
			}}
		if(y==1)
		{
			//Clicks on Equipment Performance Search (PII)
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentDatabankOnlyLink1)).click();
		}
		if(title.equals(ee_title)||title.equals(ee_titleUS)||title.equals(ee_titleie11US)||title.equals(ee_titleie11))
		{
			//Clicks on Failure Mode Search
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.FailureModeLink)).click();
		}
		if(title.equals(me_title)||title.equals(me_titleUS)||title.equals(me_titleie11US)||title.equals(me_titleie11))
		{
			//Clicks on Failure Mode Search
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.FailureModeLink)).click();
		}
		obj.browseCaseIDEquip(driver,caseId,title); 
	}

	public void checkkeyword (WebDriver driver, List<String>caseId, String keyword_same, String key1, String key2, String key3, int y,String title) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,40);
		EquipmentPDDandEF obj3 = new EquipmentPDDandEF ();
		//Clicks on Error free bank
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankTopLink)).click();
		}catch (UnhandledAlertException f){			  
			driver.switchTo().alert().dismiss();
		}
		if(y==0){
			if(keyword_same.equals(keyword_same_eq)||keyword_same.equals(keyword_same_eqUS)||keyword_same.equals(keyword_same_eqie11US)||keyword_same.equals(keyword_same_eqie11))
			{
				//Clicks on Equipment Performance Search
				wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentPerformanceLink)).click();
			}}
		if(y==1)
		{
			//Clicks on Equipment Performance Search (PII)
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentDatabankOnlyLink1)).click();
		}
		if(keyword_same.equals(keyword_same_ee)||keyword_same.equals(keywordUS_same_ee)||keyword_same.equals(keyword_same_eeie11US)||keyword_same.equals(keyword_same_eeie11))
		{
			//Clicks on  Failure Mode Search
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.FailureModeLink)).click();
		}
		if(keyword_same.equals(keyword_same_me)||keyword_same.equals(keywordUS_same_me)||keyword_same.equals(keyword_same_meie11US)||keyword_same.equals(keyword_same_meie11))
		{
			//Clicks on  Failure Mode Search
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.FailureModeLink)).click();
		}
		if(keyword_same.equals(obj3.keywordEF)||keyword_same.equals(obj3.keywordEFie11)||keyword_same.equals(obj3.keywordEFUS)||keyword_same.equals(obj3.keywordEFUSie11))
		{
			//Clicks on  Engineering Fundamentals
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EngineeringFundamentalsLink)).click();
		}
		if(keyword_same.equals(obj3.keywordPDD)||keyword_same.equals(obj3.keywordPDDie11)||keyword_same.equals(obj3.keywordPDDUS)||keyword_same.equals(obj3.keywordPDDUSie11))
		{
			//Clicks on Prevention of Design Deficiencies
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.PreventionOfDesignDeficienciesLink)).click();
		}
		//Enters the term and check the search by enter
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		Thread.sleep(1000);
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(keyword_same);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		//Enters the term with 3 unique keywords
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(key1);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Checks for the case id 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId.get(0))));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(key2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Checks for the case id 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId.get(0))));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(key3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		//Checks for the case id 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId.get(0))));
		Thread.sleep(1000);		 
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		Thread.sleep(1000);
		//Search with title
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(title);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
	}

	public void checkCase(WebDriver driver, String eq_caseId, String ee_caseId, String keyword_same_eq, String keyword_same_ee) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,40);
		EquipmentPDDandEF obj3 = new EquipmentPDDandEF();
		//Verify electrical case not in equipment performance
		obj3.searchCaseInEquipSearchByCaseID(driver, ee_caseId);
		//Clicks on Error free bank
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankTopLink)).click();
		}catch (UnhandledAlertException f){			  
			driver.switchTo().alert().dismiss();
		}
		//Clicks on Equipment Performance Search (PII)
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentDatabankOnlyLink1)).click();
		//Clicks on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		//Enters Electrical Case id to see if it exists
		driver.findElement(cb.EquipmentSearchCaseIdField).sendKeys(ee_caseId);
		driver.findElement(cb.EquipmentSearchCaseIdField).sendKeys(Keys.ENTER);
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		//Checks for electrical case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+ee_caseId)));
		System.out.println("Electrical case found in Equipment Databank only");
		//Clicks on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		//Verify Equipment case in Failure mode
		obj3.searchCaseIdInFailureModes(driver, eq_caseId);
		//Clicks on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		//Verify that Failure mode cases do not appear in Engineering Fundamentals
		obj3.searchCaseIdInEngineeringFundamentals(driver, ee_caseId);
		//Clicks on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		//Verify that Equipment Performance cases do not appear in Engineering Fundamentals
		obj3.searchCaseIdInEngineeringFundamentals(driver, eq_caseId);
		//Clicks on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		//Clicks on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		//Verify that Equipment Performance cases do not appear in Prevention of Design Deficiencies
		obj3.searchCaseIdInPreventionOfDesignDeficiencies(driver, eq_caseId);
		//Clicks on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
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
		EquipmentPDDandEF obj3 = new EquipmentPDDandEF();
		//Verify mechanical case not in equipment performance
		obj3.searchCaseInEquipSearchByKeyword(driver, keywordee, ee_caseId);
		//Verify Equipment case in Failure mode
		obj3.searchCaseInFMWithKeyword(driver, keywordeq, eq_caseId);
		//Clicks on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		//Verify that Failure mode cases do not appear in Engineering Fundamentals
		obj3.searchCaseInEngineeringFundamentalsWithKeyword(driver, keywordee, ee_caseId);
		//Clicks on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		//Verify that Equipment Performance cases do not appear in Engineering Fundamentals
		obj3.searchCaseInFMWithKeyword(driver, keywordeq, eq_caseId);
		//Clicks on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		//Verify that Failure mode cases do not appear in Prevention of Design Deficiencies
		obj3.searchCaseInPreventionOfDesignDeficienciesWithKeyword(driver, keywordee, ee_caseId);
		//Clicks on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		//Verify that Equipment Performance cases do not appear in Prevention of Design Deficiencies
		obj3.searchCaseInPreventionOfDesignDeficienciesWithKeyword(driver, keywordeq, eq_caseId);
		//Clicks on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
	}

	public void deleteCase(WebDriver driver, List<String> caseId1) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,40);
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.LoginNameOnTopRight)).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(chc.AdminOption)).click();
		Thread.sleep(1000);
		//Clicks on Errorfree bank option
		if (driver.findElement(equipObj.EquipCasesLink).isDisplayed()==false)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankAdminLink)).click();
		}		
		for(int i=0;i<caseId1.size();i++)
		{
			String caseId = caseId1.get(i);
			//Clicks on Equipment cases
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink)).click();
			//Waits for black loading message to disappear
			share2.loadingServer(driver);
			//Click on enter case id
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSearchCaseIDAdmin)).sendKeys(caseId);
			Thread.sleep(2000);
			//Clicks on case id
			Thread.sleep(2000);
			/*WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSearchCaseIDDropdownAdmin));
			List<WebElement> casesList = ele.findElements(By.tagName("li"));
			for(WebElement li : casesList)
			{
				if(li.getText().equals(caseId))
					li.click();
			}*/
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSearchCaseIDDropdownAdmin)).click();
			//Waits for black loading message to disappear
			share2.loadingServer(driver);
			share.scrollToTop(driver);
			//Clicks on delete button
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseDeleteButton)).click();
			//Waits for black loading message to disappear
			share2.loadingServer(driver);
			//Clicks on delete case
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupTitle));
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupConfirmButton)).click();
			//Waits for black loading message to disappear
			share2.loadingServer(driver);
			Thread.sleep(1000);
			share.scrollToTop(driver);
			Thread.sleep(1000);
			//Checks if case deleted
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSearchCaseIDAdmin)).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSearchCaseIDAdmin)).sendKeys(caseId);
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSearchCaseIDAdmin)).sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			if(driver.findElement(equipObj.EquipCaseSearchCaseIDDropdownAdmin).isDisplayed()==false)
				System.out.println("Case deleted: "+caseId1.get(i));
			else softly.fail("Case did not get deleted: "+caseId1.get(i) );
		}		 
		//Clicks on Errorfree bank option to close the collapsible menu
		wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankAdminLink)).click();
	}

	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}

}
