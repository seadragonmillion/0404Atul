import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CreateEquipmentCase {
	
	SoftAssertions softly = new SoftAssertions();
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
	By PreventionOfDesignDeficienciesLink = By.linkText("Prevention of Design Deficiencies");
	By EngineeringFundamentalsLink = By.linkText("Engineering Fundamentals");
	
	//Create equipment case page
	By EquipCaseNewButton = By.id("pii-admin-efse-button-new");
	By EquipCasePopupTitle = By.id("pii-admin-efse-dialog-title");
	By EquipCasePopupConfirmButton = By.id("pii-admin-efse-dialog-confirmed");
	By EquipCaseIDField = By.id("pii-admin-efse-id");
	By EquipCaseIDFieldError = By.id("pii-admin-efse-id-error");
	By EquipCaseTypes = By.id("pii-admin-efse-type-button");
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
	By EquipImageCollapsibleExpanded = By.xpath(".//*[@id='pii-admin-efse-upload-form-selectedfiles']/div");
	By EquipCaseFields = By.id("pii-admin-efse-field-button");
	By EquipCaseDiscipline = By.id("pii-admin-efse-discipline-button");
	By EquipListBoxTypes = By.id("pii-admin-efse-type-listbox");
	By ListCrossSymbol = By.cssSelector(".ui-btn.ui-corner-all.ui-btn-left.ui-btn-icon-notext.ui-icon-delete");
	By EquipListBoxTypesCrossSymbol = By.xpath(".//*[@id='pii-admin-efse-type-listbox']/div/a");
	By EquipListBoxDisciplineCrossSymbol = By.xpath(".//*[@id='pii-admin-efse-discipline-listbox']/div/a");
	By EquipListBoxDiscipline = By.id("pii-admin-efse-discipline-listbox");
	By EquipListBoxFields = By.id("pii-admin-efse-field-listbox");
	By EquipListBoxFieldsCrossSymbol = By.xpath(".//*[@id='pii-admin-efse-field-listbox']/div/a");
	
	By EquipListTypesAdvancedLearning = By.xpath(".//*[@id='pii-admin-efse-type-menu']/li[1]/a");
	By EquipListTypesCaseStudies = By.xpath(".//*[@id='pii-admin-efse-type-menu']/li[2]/a");
	By EquipListTypesDesign = By.xpath(".//*[@id='pii-admin-efse-type-menu']/li[3]/a");
	By EquipListTypesFailureModes = By.xpath(".//*[@id='pii-admin-efse-type-menu']/li[4]/a");
	By EquipListTypesFundamentals = By.xpath(".//*[@id='pii-admin-efse-type-menu']/li[5]/a");
	By EquipListTypesGeneral = By.xpath(".//*[@id='pii-admin-efse-type-menu']/li[6]/a");
	
	By EquipListDisciplineElectrical = By.xpath(".//*[@id='pii-admin-efse-discipline-menu']/li[1]/a");
	By EquipListDisciplineGeneral = By.xpath(".//*[@id='pii-admin-efse-discipline-menu']/li[2]/a");
	By EquipListDisciplineIC = By.xpath(".//*[@id='pii-admin-efse-discipline-menu']/li[3]/a");
	By EquipListDisciplineMechanical = By.xpath(".//*[@id='pii-admin-efse-discipline-menu']/li[4]/a");
	By EquipListDisciplineSoftware = By.xpath(".//*[@id='pii-admin-efse-discipline-menu']/li[5]/a");
	By EquipListDisciplineStructural = By.xpath(".//*[@id='pii-admin-efse-discipline-menu']/li[6]/a");
	
	By EquipListFieldsAuto = By.xpath(".//*[@id='pii-admin-efse-field-menu']/li[1]/a");
	By EquipListFieldsNuclear = By.xpath(".//*[@id='pii-admin-efse-field-menu']/li[2]/a");
	By EquipListFieldsOther = By.xpath(".//*[@id='pii-admin-efse-field-menu']/li[3]/a");
	By EquipListFieldsPharmaceutical = By.xpath(".//*[@id='pii-admin-efse-field-menu']/li[4]/a");
	By EquipListFieldsWelding = By.xpath(".//*[@id='pii-admin-efse-field-menu']/li[5]/a");

	public void deletePreviousCase(WebDriver driver, String title) throws Exception{
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		ShareCheck obj = new ShareCheck();
		CaseBrowse obj1 = new CaseBrowse();
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
	
	public void addKeywordKALE2168(WebDriver driver, List<String> caseID, String keyword_same) throws Exception {
		
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
		jse.executeScript("scroll(0,0)");
		Thread.sleep(1000);
		//CLick on enter case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSearchCaseIDAdmin)).sendKeys(caseID.get(2));
		Thread.sleep(2000);
		//Clicks on case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSearchCaseIDDropdownAdmin)).click();
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
		Thread.sleep(1000);
		jse.executeScript("scroll(0,0)");
		Thread.sleep(1000);
		//Click on Edit
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseEditButton)).click();
		Thread.sleep(2000);
		//Scroll down
		jse.executeScript("scroll(0,2000)");
		Thread.sleep(1000);
		//Add new keyword
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).sendKeys(keyword_same+"added");
		Thread.sleep(1500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordAddButton)).click();
		Thread.sleep(1000);
	    jse.executeScript("scroll(0,0)");
	    Thread.sleep(1000);
	    //Clicks on save
	    wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSaveButton)).click();
	    //Clicks on create case
	    wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupTitle)).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupConfirmButton)).click();
	    //Waits for black loading message to disappear
	    obj.loadingServer(driver);
	    Thread.sleep(1000);
	    jse.executeScript("scroll(0,0)");
	    Thread.sleep(1000);
	    //Clicks on Error free bank
		try
		{
		  wait.until(ExpectedConditions.visibilityOfElementLocated(obj3.ErrorFreeBankTopLink)).click();
		}catch (UnhandledAlertException f){			  
		  driver.switchTo().alert().dismiss();
		}
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
		jse.executeScript("scroll(0,0)");
		Thread.sleep(1000);
		//CLick on enter case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSearchCaseIDAdmin)).sendKeys(caseID.get(1));
		Thread.sleep(2000);
		//Clicks on case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSearchCaseIDDropdownAdmin)).click();
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
		Thread.sleep(1000);
		jse.executeScript("scroll(0,0)");
		Thread.sleep(1000);
		//Click on Edit
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseEditButton)).click();
		Thread.sleep(2000);
		//Scroll down
		jse.executeScript("scroll(0,2000)");
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
		jse.executeScript("scroll(0,2000)");
		Thread.sleep(1000);
		//Add new keyword
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).sendKeys(keyword_same+"changed");
		Thread.sleep(1500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordAddButton)).click();
		Thread.sleep(1000);
	    jse.executeScript("scroll(0,0)");
	    Thread.sleep(1000);
	    //Clicks on save
	    wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSaveButton)).click();
	    //Clicks on create case
	    wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupTitle)).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupConfirmButton)).click();
	    //Waits for black loading message to disappear
	    obj.loadingServer(driver);
	    Thread.sleep(1000);
	    jse.executeScript("scroll(0,0)");
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
			String cl = wait.until(ExpectedConditions.visibilityOfElementLocated(element)).getAttribute("class");
			if(cl.contains("ui-checkbox-on")==true)
				break;
	    	Actions act = new Actions(driver);
	    	act.click(wait.until(ExpectedConditions.visibilityOfElementLocated(element))).build().perform();
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
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
		//Clicks on Error free bank
		WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.ErrorFreeBankTopLink));
		Actions act = new Actions(driver);
		act.click(element1).build().perform();
		//Go to  FM
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.FailureModeLink)).click();
		Thread.sleep(1000);
		//Check for case
		//Enters case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Clicks on case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId)));
	}
	
	public void searchCaseWithMultipleCategories(WebDriver driver, List<String> categories, String caseId) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		CaseBrowse obj1 = new CaseBrowse();
		ShareCheck obj = new ShareCheck();
		CreateHumanCase obj2 = new CreateHumanCase ();
		Thread.sleep(1000);
		if (categories.contains("Case Studies")||categories.contains("Advanced Learning")||categories.contains("General"))
		{
			//Clicks on Error free bank
			WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.ErrorFreeBankTopLink));
			Actions act = new Actions(driver);
			act.click(element1).build().perform();
			//Go to Equipment Performance
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentPerformanceLink)).click();
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
			Actions act = new Actions(driver);
			act.click(element1).build().perform();
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
			Actions act = new Actions(driver);
			act.click(element1).build().perform();
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
			Actions act = new Actions(driver);
			act.click(element1).build().perform();
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
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
		  Thread.sleep(2000);
		  //Login as new user/admin
		  int login = obj.LoginUser(driver, username, password);
		  System.out.println("Title after login: "+driver.getTitle());
		  Thread.sleep(5000);
		  //Waits for the page to load
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
		  jse.executeScript("scroll(0,1700)");
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
			  jse.executeScript("scroll(0,1700)");
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
				  jse.executeScript("scroll(0,1700)");
				  Thread.sleep(1000);
				 wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordAddButton)).click();
			  }
		 }
		 if(count == 6)
		 {
			 wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).clear();
			 wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).sendKeys(keyword_same+"joker");
			 Thread.sleep(2000);
			  jse.executeScript("scroll(0,1700)");
			  Thread.sleep(1000);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordAddButton)).click();
		 }
		  //Uploads 5 slides
		  WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipImageCollapsible));
		  Point p1 = l.getLocation();
		  int yaxis= p1.getY()-250;
		  Thread.sleep(2000);
		  jse.executeScript("scroll(0,"+yaxis+")");
		  Thread.sleep(2000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(EquipImageUploadField)).click();
		  Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlides.exe");
		  p.waitFor();
		  Thread.sleep(3000);
		  //Checks if 5 images have been uploaded
		  if(driver.findElement(EquipImageCollapsibleExpanded).isDisplayed()==false)
		  {
			  l = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipImageCollapsible));
			  p1 = l.getLocation();
			  yaxis= p1.getY()-250;
			  Thread.sleep(2000);
			  jse.executeScript("scroll(0,"+yaxis+")");
			  Thread.sleep(2000);
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
		  jse.executeScript("scroll(0,0)");
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
			  //Scroll to top
			  Thread.sleep(1000);
			  jse.executeScript("scroll(0,0)");
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
			  jse.executeScript("scroll(0,0)");
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
		  jse.executeScript("scroll(0,1700)");
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
			  jse.executeScript("scroll(0,1700)");
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
					  jse.executeScript("scroll(0,1700)");
					  Thread.sleep(1000);
					 wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordAddButton)).click();
				  }
			 }
			 if(count == 6)
			 {
				 wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).clear();
				 wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).sendKeys(keyword_same+"joker");
				 Thread.sleep(2000);
				  jse.executeScript("scroll(0,1700)");
				  Thread.sleep(1000);
				 wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordAddButton)).click();
			 }
		  //Uploads 5 slides
		  WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipImageCollapsible));
		  Point p1 = l.getLocation();
		  int yaxis= p1.getY()-250;
		  Thread.sleep(2000);
		  jse.executeScript("scroll(0,"+yaxis+")");
		  Thread.sleep(2000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(EquipImageUploadField)).click();
		  Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlides_Firefox.exe");
		  p.waitFor();
		  Thread.sleep(3000);
		  //Checks if 5 images have been uploaded
		  if(driver.findElement(EquipImageCollapsibleExpanded).isDisplayed()==false)
		  {
			  l = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipImageCollapsible));
			  p1 = l.getLocation();
			  yaxis= p1.getY()-250;
			  Thread.sleep(2000);
			  jse.executeScript("scroll(0,"+yaxis+")");
			  Thread.sleep(2000);
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
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(1000);
		  //Clicks on save
		  wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSaveButton)).click();
		  //Clicks on create case
		  wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupTitle)).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupConfirmButton)).click();
		  //Waits for black loading message to disappear
		  obj.loadingServer(driver);
		  //Scroll to top
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,0)");
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
		  WebDriverWait wait = new WebDriverWait(driver,40);
		  ShareCheck obj = new ShareCheck();
		  CaseBrowse obj1 = new CaseBrowse();
		  CreateHumanCase obj2 = new CreateHumanCase ();
		  Login obj3 = new Login();
		  Actions act= new Actions(driver);
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
			  //Scroll to top
			  Thread.sleep(1000);
			  jse.executeScript("scroll(0,0)");
			  Thread.sleep(1000);
			  //Clicks on new case button
			  WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewButton));
			  act.click(ele).build().perform();
			  //Clicks on new case
			  wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupTitle));
			  ele = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupConfirmButton));
			  act.click(ele).build().perform();
			  //Waits for black loading message to disappear
			  obj.loadingServer(driver);
			  //Scroll to top
			  Thread.sleep(1000);
			  jse.executeScript("scroll(0,0)");
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
		  jse.executeScript("scroll(0,1700)");
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
			  jse.executeScript("scroll(0,1700)");
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
					  jse.executeScript("scroll(0,1700)");
					  Thread.sleep(1000);
					 wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordAddButton)).click();
				  }
			 }
			 if(count == 6)
			 {
				 wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).clear();
				 wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).sendKeys(keyword_same+"joker");
				 Thread.sleep(2000);
				  jse.executeScript("scroll(0,1700)");
				  Thread.sleep(1000);
				 wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordAddButton)).click();
			 }
		  //Uploads 5 slides
		  WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipImageCollapsible));
		  Point p1 = l.getLocation();
		  int yaxis= p1.getY()-250;
		  Thread.sleep(2000);
		  jse.executeScript("scroll(0,"+yaxis+")");
		  Thread.sleep(2000);
		  ele = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipImageUploadField));
		  act.doubleClick(ele).build().perform();
		  Thread.sleep(3000);
		  Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlides_IE10.exe");
		  p.waitFor();
		  Thread.sleep(3000);
		  //Checks if 5 images have been uploaded
		  if(driver.findElement(EquipImageCollapsibleExpanded).isDisplayed()==false)
		  {
			  l = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipImageCollapsible));
			  p1 = l.getLocation();
			  yaxis= p1.getY()-250;
			  Thread.sleep(2000);
			  jse.executeScript("scroll(0,"+yaxis+")");
			  Thread.sleep(2000);
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
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(1000);
		  //Clicks on save
		  wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSaveButton)).click();
		  //Clicks on create case
		  wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupTitle)).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupConfirmButton)).click();
		  //Waits for black loading message to disappear
		  obj.loadingServer(driver);
		  //Scroll to top
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,0)");
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
		  Actions act = new Actions(driver);
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
			  //Scroll to top
			  Thread.sleep(1000);
			  jse.executeScript("scroll(0,0)");
			  Thread.sleep(1000);
			  //Clicks on new case button
			  WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewButton));
			  act.click(ele).build().perform();
			  //Clicks on new case
			  wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupTitle));
			  ele = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupConfirmButton));
			  act.click(ele).build().perform();
			  //Waits for black loading message to disappear
			  obj.loadingServer(driver);
			  //Scroll to top
			  Thread.sleep(1000);
			  jse.executeScript("scroll(0,0)");
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
		  jse.executeScript("scroll(0,1700)");
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
			  jse.executeScript("scroll(0,1700)");
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
					  jse.executeScript("scroll(0,1700)");
					  Thread.sleep(1000);
					 wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordAddButton)).click();
				  }
			 }
			 if(count == 6)
			 {
				 wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).clear();
				 wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordField)).sendKeys(keyword_same+"joker");
				 Thread.sleep(2000);
				  jse.executeScript("scroll(0,1700)");
				  Thread.sleep(1000);
				 wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseNewKeywordAddButton)).click();
			 }
		  //Uploads 5 slides
		  WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipImageCollapsible));
		  Point p1 = l.getLocation();
		  int yaxis= p1.getY()-250;
		  Thread.sleep(2000);
		  jse.executeScript("scroll(0,"+yaxis+")");
		  Thread.sleep(2000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(EquipImageUploadField)).click();
		  Process p =Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/UploadHumanCaseSlides_IE10.exe");
		  p.waitFor();
		  Thread.sleep(3000);
		  //Checks if 5 images have been uploaded
		  if(driver.findElement(EquipImageCollapsibleExpanded).isDisplayed()==false)
		  {
			  l = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipImageCollapsible));
			  p1 = l.getLocation();
			  yaxis= p1.getY()-250;
			  Thread.sleep(2000);
			  jse.executeScript("scroll(0,"+yaxis+")");
			  Thread.sleep(2000);
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
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(1000);
		  //Clicks on save
		  wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSaveButton)).click();
		  //Clicks on create case
		  wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupTitle)).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupConfirmButton)).click();
		  //Waits for black loading message to disappear
		  obj.loadingServer(driver);
		  //Scroll to top
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,0)");
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
		  Actions act = new Actions(driver);
		  act.click(element1).build().perform();
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
	
	public void checkCase(WebDriver driver, String eq_caseId, String ee_caseId, String me_caseId) throws Exception{
		
		  WebDriverWait wait = new WebDriverWait(driver,40);
		  ShareCheck obj = new ShareCheck();
		  CaseBrowse obj1 = new CaseBrowse();
		  CreateHumanCase obj2 = new CreateHumanCase ();
		  //Clicks on Error free bank
		  try
		  {
			  wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.ErrorFreeBankTopLink)).click();
		  }catch (UnhandledAlertException f){			  
			  driver.switchTo().alert().dismiss();
		  }
		  //Clicks on Equipment Performance Search
		  wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentPerformanceLink)).click();
		  //Clicks on clear
		  wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
		  //Enters Electrical Case id to see if it exists
		  driver.findElement(obj1.EquipmentSearchCaseIdField).sendKeys(ee_caseId);
		  driver.findElement(obj1.EquipmentSearchCaseIdField).sendKeys(Keys.ENTER);
		  //Waits for black loading message to disappear
		  obj.loadingServer(driver);
		  //Checks for the error message
		  if (driver.findElement(EquipSearchMessage).isDisplayed())
			  System.out.println("Electrical case not found in Equipment Search");
		  //Clicks on clear
		  wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
		  //Enters Mechanical Case id to see if it exists
		  driver.findElement(obj1.EquipmentSearchCaseIdField).sendKeys(me_caseId);
		  driver.findElement(obj1.EquipmentSearchCaseIdField).sendKeys(Keys.ENTER);
		  //Waits for black loading message to disappear
		  obj.loadingServer(driver);
		  //Checks for the error message
		  if (driver.findElement(EquipSearchMessage).isDisplayed())
			  System.out.println("Mechanical case not found in Equipment Search");
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
		  //Enters Mechanical Case id to see if it exists
		  driver.findElement(obj1.EquipmentSearchCaseIdField).sendKeys(me_caseId);
		  driver.findElement(obj1.EquipmentSearchCaseIdField).sendKeys(Keys.ENTER);
		  //Waits for black loading message to disappear
		  obj.loadingServer(driver);
		  //Checks for mechanical case
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+me_caseId)));
		  System.out.println("Mechanical case found in Equipment Databank only");
		  //Clicks on Error free bank
		  try
		  {
			  wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.ErrorFreeBankTopLink)).click();
		  }catch (UnhandledAlertException f){			  
			  driver.switchTo().alert().dismiss();
		  }
		  //Clicks on Failure Mode Search
		  wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.FailureModeLink)).click();
		  //Clicks on clear
		  wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
		  //Enters Equipment Case id to see if it exists
		  driver.findElement(obj1.EquipmentSearchCaseIdField).sendKeys(eq_caseId);
		  driver.findElement(obj1.EquipmentSearchCaseIdField).sendKeys(Keys.ENTER);
		  //Waits for black loading message to disappear
		  obj.loadingServer(driver);
		  //Checks for the error message
		  if (driver.findElement(EquipSearchMessage).isDisplayed())
			  System.out.println("Equipment case not found in Electrical Search");
		  //Clicks on clear
		  wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
		  //Clicks on Error free bank
		  try
		  {
			  wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.ErrorFreeBankTopLink)).click();
		  }catch (UnhandledAlertException f){			  
			  driver.switchTo().alert().dismiss();
		  }
		  //Clicks on Failure Mode Search
		  wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.FailureModeLink)).click();
		  //Clicks on clear
		  wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
		  //Enters Equipment Case id to see if it exists
		  driver.findElement(obj1.EquipmentSearchCaseIdField).sendKeys(eq_caseId);
		  driver.findElement(obj1.EquipmentSearchCaseIdField).sendKeys(Keys.ENTER);
		  //Waits for black loading message to disappear
		  obj.loadingServer(driver);
		  //Checks for the error message
		  if (driver.findElement(EquipSearchMessage).isDisplayed())
			  System.out.println("Equipment case not found in Mechanical Search");
		  //Clicks on clear
		  wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
		  //Verify that Failure mode cases do not appear in Engineering Fundamentals
		  //Clicks on Error free bank
		  try
		  {
			  wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.ErrorFreeBankTopLink)).click();
		  }catch (UnhandledAlertException f){			  
			  driver.switchTo().alert().dismiss();
		  }
		  //Clicks on Engineering Fundametals
		  wait.until(ExpectedConditions.visibilityOfElementLocated(EngineeringFundamentalsLink)).click();
		  //Clicks on clear
		  wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
		  //Enters Equipment Case id to see if it exists
		  driver.findElement(obj1.EquipmentSearchCaseIdField).sendKeys(ee_caseId);
		  driver.findElement(obj1.EquipmentSearchCaseIdField).sendKeys(Keys.ENTER);
		  //Waits for black loading message to disappear
		  obj.loadingServer(driver);
		  //Checks for the error message
		  if (driver.findElement(EquipSearchMessage).isDisplayed())
			  System.out.println("Electrical failure mode case not found in Engineering Fundamentals");
		  //Clicks on clear
		  wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
		  //Enters Equipment Case id to see if it exists
		  driver.findElement(obj1.EquipmentSearchCaseIdField).sendKeys(me_caseId);
		  driver.findElement(obj1.EquipmentSearchCaseIdField).sendKeys(Keys.ENTER);
		  //Waits for black loading message to disappear
		  obj.loadingServer(driver);
		  //Checks for the error message
		  if (driver.findElement(EquipSearchMessage).isDisplayed())
			  System.out.println("Mechanical failure mode case not found in Engineering Fundamentals");
		  //Clicks on clear
		  wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
		  //Verify that Failure mode cases do not appear in Prevention of Design Deficiencies
		  //Clicks on Error free bank
		  try
		  {
			  wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.ErrorFreeBankTopLink)).click();
		  }catch (UnhandledAlertException f){			  
			  driver.switchTo().alert().dismiss();
		  }
		  //Clicks on Prevention of Design Deficiencies
		  wait.until(ExpectedConditions.visibilityOfElementLocated(PreventionOfDesignDeficienciesLink)).click();
		  //Clicks on clear
		  wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
		  //Enters Equipment Case id to see if it exists
		  driver.findElement(obj1.EquipmentSearchCaseIdField).sendKeys(ee_caseId);
		  driver.findElement(obj1.EquipmentSearchCaseIdField).sendKeys(Keys.ENTER);
		  //Waits for black loading message to disappear
		  obj.loadingServer(driver);
		  //Checks for the error message
		  if (driver.findElement(EquipSearchMessage).isDisplayed())
			  System.out.println("Electrical failure mode case not found in Prevention of Design Deficiencies");
		  //Clicks on clear
		  wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
		  //Enters Equipment Case id to see if it exists
		  driver.findElement(obj1.EquipmentSearchCaseIdField).sendKeys(me_caseId);
		  driver.findElement(obj1.EquipmentSearchCaseIdField).sendKeys(Keys.ENTER);
		  //Waits for black loading message to disappear
		  obj.loadingServer(driver);
		  //Checks for the error message
		  if (driver.findElement(EquipSearchMessage).isDisplayed())
			  System.out.println("Mechanical failure mode case not found in Prevention of Design Deficiencies");
		  //Clicks on clear
		  wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
	}
	
	public void deleteCase(WebDriver driver, List<String> caseId1) throws Exception{
		
		  WebDriverWait wait = new WebDriverWait(driver,40);
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
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
		  //Clicks on delete button
		  wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseDeleteButton)).click();
		  //Clicks on delete case
		  wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupTitle)).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCasePopupConfirmButton)).click();
		  //Waits for black loading message to disappear
		  obj.loadingServer(driver);
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(1000);
		  //Checks if case deleted
		  wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSearchCaseIDAdmin)).clear();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSearchCaseIDAdmin)).sendKeys(caseId);
		  Thread.sleep(2000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSearchCaseIDAdmin)).sendKeys(Keys.ENTER);
		  Thread.sleep(1000);
		  if(driver.findElement(EquipCaseSearchCaseIDDropdownAdmin).isDisplayed()==false)
			  System.out.println("Case deleted: "+caseId1.get(i));
		  }
		  //Clicks on Errorfree bank option to close the collapsible menu
		  wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.ErrorFreeBankLink)).click();
	}
	
	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}

}
