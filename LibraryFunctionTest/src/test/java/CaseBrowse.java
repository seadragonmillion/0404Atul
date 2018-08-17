import java.awt.Robot;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CaseBrowse {
	
	SoftAssertions softly = new SoftAssertions();
	String expected_copyright = "Copyright and Proprietary, Error-Free Inc. and Performance Improvement International LLC, 2018. Derivative Product Strictly Prohibited.";
	String caseEquipALProd = "1545";
	String caseEquipGProd = "1636";
	String caseEquipCSDev = "1985";
	String keywordEquipALDev = "QAA oil color";
	String keywordEquipCSDev = "QAACaseStudiesEquipment";
	String keywordEquipALProd = "bolted flange";
	String keywordEquipGProd = "positive sequence";
	String caseHumanColor = "Q1516";
	String caseEquipColor = "F1516";
	String caseHumanDev = "1459";
	String caseEquipDev = "1974";
	String caseElecDev = "1678";
	String caseMechDev = "1988";
	String caseHumanProd = "746";
	String caseHumanProdPercent = "618";
	String caseEquipProd = "231";
	String caseEquipProdPercent = "1341";
	String caseElecProd = "1260";
	String caseMechProd = "1638";
	String keywordHumanDev = "test data";
	String keywordHumanDevSpcl = "test.1/1";
	String keywordHumanDevPercent = "Testpercentage%";
	String keywordEquipDev = "test data";
	String keywordEquipDevSpcl = "test.1/1";
	String keywordEquipDevPercent = "Testpercentage%";
	String keywordElecDev = "sanity";
	String keywordElecDevSpcl = "test.1/1";
	String keywordElecDevPercent = "Testpercentel%";
	String keywordMechDev = "Sanity test";
	String keywordMechDevSpcl = "test.1/1";
	String keywordMechDevPercent = "Testpercentme%";
	String keywordHumanProd = "power plant worker";
	String keywordHumanProdPercent = "50%";
	String keywordEquipProd = "Static electrification failure mechanism";
	String keywordEquipProdPercent = "20%";
	String keywordElecProd = "pneumatic controller";
	String keywordMechProd = "Failure modes of U-cup Seals";
	String titleDev = "Sanity Test: DO NOT DELETE: QAA";
	String titleHumanProd = "How is an Error-Free® work day achieved for power plant workers?";	
	String titleEquipProd = "What are the controlling parameters affecting static electrification in a transformer?";
	String titleElecProd = "What are the operating principles and failure modes of a pneumatic controller?";
	String titleMechProd = "What are the benefits and failure modes of U-cup (U-ring) or an O-ring Loaded U-cup?";
	String keywordHumanProdAllSpecial = "Testqaa!@#$%^&*,.?/+-=;:_";
	String keywordHumanProdAllSpecial_ie11 = "Testie11qaa!@#$%^&*,.?/+-=;:_";
	String keywordEquipProdAllSpecial = "Testqaa!@#$%^&*,.?/+-=;:";
	String keywordEquipProdAllSpecial_ie11 = "Testie11qaa!@#$%^&*,.?/+-=;:_";
	String keywordHumanDevAllSpecial = "Testqaa!@#$%^&*,.?/+-=;:_";
	String keywordHumanDevAllSpecial_ie11 = "Testie11qaa!@#$%^&*,.?/+-=;:_";
	String keywordEquipDevAllSpecial = "Testqaa!@#$%^&*,.?/+-=;:_";
	String keywordEquipDevAllSpecial_ie11 = "Testie11qaa!@#$%^&*,.?/+-=;:_";
	String[] s= {"@","!","#","$","%","&"," ","/","?",",","."};
	
	
	By ErrorFreeBankLink = By.id("pii-main-menu-button-e");
	By HumanPerformanceLink = By.linkText("Human Performance");
	By EquipmentPerformanceLink = By.linkText("Equipment Performance");
	By EquipmentDatabankOnlyLink = By.linkText("Equipment Data Bank (Instructor Only)");
	By ElectricalFailureModeLink = By.linkText("Electrical Failure Modes");
	By MechanicalFailureModeLink = By.linkText("Mechanical Failure Modes");
	By FailureModeLink = By.linkText("Failure Modes");
	By EquipmentDatabankOnlyLink1 = By.id("pii-e-menu-equipPII");
	
	//Error-free Bank Module page
	By HumanPerformancePosition = By.xpath(".//*[@id='pii-e-menu']/article/div[2]/ul/li[1]/a");
	By EngineeringFundamentalPosition = By.xpath(".//*[@id='pii-e-menu']/article/div[2]/ul/li[2]/a");
	By EquipmentPerformancePosition = By.xpath(".//*[@id='pii-e-menu']/article/div[2]/ul/li[3]/a");
	By FailureModesPosition = By.xpath(".//*[@id='pii-e-menu']/article/div[2]/ul/li[4]/a");
	By PreventionOfDesignDeficienciesPosition = By.xpath(".//*[@id='pii-e-menu']/article/div[2]/ul/li[5]/a");
	By EquipmentDatabankOnlyPosition = By.xpath(".//*[@id='pii-e-menu']/article/div[2]/ul/li[6]/a");
	
	//Equipment Case
	By EquipmentAddKeywordField = By.id("pii-admin-efse-keyword-search-input");
	By EquipmentAddKeywordButton = By.id("pii-admin-efse-keyword-new");
	
	//Equipment Search
	By EquipmentSearchKeywordField = By.id("pii-efse-searchbykw-input");
	By EquipmentSearchClearButton = By.id("pii-efse-clear");
	By EquipmentSearchKeywordFieldSearchButton = By.id("pii-efse-searchbykw-btn");
	By EquipmentDropDownList = By.xpath(".//*[@id='pii-efse-keyword-list']/li");
	By EquipmentDropDownListTitle = By.xpath(".//*[@id='pii-efse-keyword-list']/li[2]");
	By EquipmentSearchCaseIDFieldClearButton = By.xpath(".//*[@id='pii-keyword-block-equip']/div[3]/div/div/a");
	By EquipmentSearchCaseIdField = By.id("pii-efse-searchbyid-input");
	By EquipmentModuleTitle = By.id("pii-efse-search-label");
	By EquipmentSearchDropDown = By.id("pii-efse-keyword-list");
	By EquipmentSearchKeywordFieldClearButton = By.xpath(".//*[@id='pii-keyword-block-equip']/div[4]/div/div/a");
	By EquipmentSearchCaseIDFieldSearchButton = By.id("pii-efse-searchbyid-btn");
	By EquipSearch1stCollapsibleCases = By.xpath(".//*[@id='pii-question-list-equip']/div[1]/h4/a");
	By EquipSearch2ndCollapsibleCases = By.xpath(".//*[@id='pii-question-list-equip']/div[2]/h4/a");
	By CaseSearchDisciplineBoxText = By.xpath(".//*[@id='pii-efse-filter-discipline-button']/span[1]");
	By CaseSearchDisciplineBox = By.id("pii-efse-filter-discipline-button");
	By CaseSearchDisciplineList = By.id("pii-efse-filter-discipline-listbox");
	By CaseSearchDisciplinePopupClose = By.xpath(".//*[@id='pii-efse-filter-discipline-listbox']/div/a");
	By EquipCaseSearchListDisciplineElectrical = By.xpath(".//*[@id='pii-efse-filter-discipline-menu']/li[1]/a");
	By EquipCaseSearchListDisciplineGeneral = By.xpath(".//*[@id='pii-efse-filter-discipline-menu']/li[2]/a");
	By EquipCaseSearchListDisciplineIC = By.xpath(".//*[@id='pii-efse-filter-discipline-menu']/li[3]/a");
	By EquipCaseSearchListDisciplineMechanical = By.xpath(".//*[@id='pii-efse-filter-discipline-menu']/li[4]/a");
	By EquipCaseSearchListDisciplineSoftware = By.xpath(".//*[@id='pii-efse-filter-discipline-menu']/li[5]/a");
	By EquipCaseSearchListDisciplineStructural = By.xpath(".//*[@id='pii-efse-filter-discipline-menu']/li[6]/a");
	By CaseSearchFieldBox = By.id("pii-efse-filter-field-button");
	By CaseSearchFieldList = By.id("pii-efse-filter-field-listbox");
	By CaseSearchFieldPopupClose = By.xpath(".//*[@id='pii-efse-filter-field-listbox']/div/a");
	By EquipCaseSearchListFieldAuto = By.xpath(".//*[@id='pii-efse-filter-field-menu']/li[1]/a");
	By EquipCaseSearchListFieldNuclear = By.xpath(".//*[@id='pii-efse-filter-field-menu']/li[2]/a");
	By EquipCaseSearchListFieldOther = By.xpath(".//*[@id='pii-efse-filter-field-menu']/li[3]/a");
	By EquipCaseSearchListFieldPharmaceutical = By.xpath(".//*[@id='pii-efse-filter-field-menu']/li[4]/a");
	By EquipCaseSearchListFieldWelding = By.xpath(".//*[@id='pii-efse-filter-field-menu']/li[5]/a");
	By CaseSearchTypeBox = By.id("pii-efse-filter-type-button");
	By CaseSearchTypeList = By.id("pii-efse-filter-type-listbox");
	By CaseSearchTypesPopupClose = By.xpath(".//*[@id='pii-efse-filter-type-listbox']/div/a");
	By EquipCaseSearchListTypesAdvancedLearning = By.xpath(".//*[@id='pii-efse-filter-type-menu']/li[1]/a");
	By EquipCaseSearchListTypesCaseStudies = By.xpath(".//*[@id='pii-efse-filter-type-menu']/li[2]/a");
	By EquipCaseSearchListTypesDesign = By.xpath(".//*[@id='pii-efse-filter-type-menu']/li[3]/a");
	By EquipCaseSearchListTypesFailureMode = By.xpath(".//*[@id='pii-efse-filter-type-menu']/li[4]/a");
	By EquipCaseSearchListTypesFundamentals = By.xpath(".//*[@id='pii-efse-filter-type-menu']/li[5]/a");
	By EquipCaseSearchListTypesGeneral = By.xpath(".//*[@id='pii-efse-filter-type-menu']/li[6]/a");
	
	//Human Case
	By HumanAddKeywordField = By.id("pii-admin-efsh-keyword-search-input");
	By HumanAddKeywordButton = By.id("pii-admin-efsh-keyword-new");
	
	//Human Search
	By HumanSearchKeywordField = By.id("pii-efsh-searchbykw-input");
	By HumanSearchClearButton = By.id("pii-efsh-clear");
	By HumanSearchCaseIdField = By.id("pii-efsh-searchbyid-input");
	By HumanSearchCaseIDFieldClearButton = By.xpath(".//*[@id='pii-keyword-block']/div[3]/div/div/a");
	By HumanSearchCaseIDFieldSearchButton = By.id("pii-efsh-searchbyid-btn");
	By HumanSearchDropDown = By.id("pii-efsh-keyword-list");
	By HumanSearchKeywordFieldSearchButton = By.id("pii-efsh-searchbykw-btn");
	By HumanDropDownList = By.xpath(".//*[@id='pii-efsh-keyword-list']/li");
	By HumanDropDownListTitle = By.xpath(".//*[@id='pii-efsh-keyword-list']/li[2]");
	By HumanSearchKeywordFieldClearButton = By.xpath(".//*[@id='pii-keyword-block']/div[4]/div/div/a");
	By HumanSearchDropdownListLoaded = By.xpath(".//*[@id='pii-question-list']/div/h4/a/div");
	By HumanSearch1stCollapsibleCases = By.xpath(".//*[@id='pii-question-list']/div[1]/h4/a");
	By HumanSearch2ndCollapsibleCases = By.xpath(".//*[@id='pii-question-list']/div[2]/h4/a");
	
	//Slides
	By SlideNextButton = By.linkText("Next");
	By SlidePreviousButton = By.linkText("Previous");
	
	public void caseSearchEquipmentDatabank(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		EquipmentPDDandEF obj = new EquipmentPDDandEF();
		String caseEquipColor1 = caseEquipColor.replace("F", "");
		//Clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchClearButton)).click();
		if(driver.getCurrentUrl().contains("kaleasia")||driver.getCurrentUrl().contains("kale."))
		{
			searchWithTypeFilter(driver, keywordEquipALProd, keywordEquipProd, keywordEquipGProd, obj.keywordPDDProd, obj.keywordEFProd, keywordElecProd, obj.caseEFProd, obj.casePDDProd, caseEquipALProd, caseEquipProd, caseEquipGProd, caseElecProd);
		}
		else
		{
			searchWithTypeFilter(driver, keywordEquipALDev, keywordEquipCSDev, keywordEquipDev, obj.keywordPDDDev, obj.keywordEFDev, keywordElecDev, obj.caseEFDev, obj.casePDDDev, caseEquipColor1, caseEquipCSDev, caseEquipDev, caseElecDev);
		}
	}

	public void searchWithTypeFilter(WebDriver driver, String keywordAL, String keywordCS, String keywordG, String keywordPDD, String keywordEF, String keywordFM, String caseEF, String casePDD, String caseAL, String caseCS, String caseG, String caseFM) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		CreateEquipmentCase2 obj = new CreateEquipmentCase2 ();
		//Clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchClearButton)).click();
		//Select Type Advanced Learning
		obj.selectTypeAdvancedLearning(driver);
		//Put in keyword and look for case
		lookForCaseWithTypeFilter(driver, keywordAL, caseAL);
		//Clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchClearButton)).click();
		//Select Type Case Studies
		obj.selectTypeCaseStudies(driver);
		//Put in keyword and look for case
		lookForCaseWithTypeFilter(driver, keywordCS, caseCS);
		//Clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchClearButton)).click();
		//Select Type General
		obj.selectTypeGeneral(driver);
		//Put in keyword and look for case
		lookForCaseWithTypeFilter(driver, keywordG, caseG);
		//Clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchClearButton)).click();
		//Select Type Engineering Fundamentals
		obj.selectTypeFundamentals(driver);
		//Put in keyword and look for case
		lookForCaseWithTypeFilter(driver, keywordEF, caseEF);
		//Clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchClearButton)).click();
		//Select Type Design
		obj.selectTypeDesign(driver);
		//Put in keyword and look for case
		lookForCaseWithTypeFilter(driver, keywordPDD, casePDD);
		//Clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchClearButton)).click();
		//Select Type Failure modes
		obj.selectTypeFailureMode(driver);
		//Put in keyword and look for case
		lookForCaseWithTypeFilter(driver, keywordFM, caseFM);
	}
	
	public void lookForCaseWithTypeFilter(WebDriver driver, String keyword, String caseId) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		ShareCheck obj = new ShareCheck();
		//Search for keyword
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchKeywordField)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchKeywordField)).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Wait for loading message
		obj.loadingServer(driver);
		//Look for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId)));
	}
	
	public void getHumanPerformanceLink(WebDriver driver, int y) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		ShareCheck obj = new ShareCheck();
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
		//Clicks on ErrorFree Bank
	    wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorFreeBankLink)).click();
	    /*Verify order or modules
	     * admin = 0
	     * nonadmin = 1
	    */
	    verifyOrderOfModules(driver, y);
		//Clicks on Human Performance
	    wait.until(ExpectedConditions.visibilityOfElementLocated(HumanPerformanceLink)).click();
	}
	
	public void getEquipPerformanceLink(WebDriver driver, int y) throws Exception {
	
		WebDriverWait wait = new WebDriverWait(driver,20);
		ShareCheck obj = new ShareCheck();
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
	    //Clicks on ErrorFree Bank
        wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorFreeBankLink)).click();
	    /*Verify order or modules
	     * admin = 0
	     * nonadmin = 1
	    */
	    verifyOrderOfModules(driver, y);
	    //Clicks on Equipment Performance
	    wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentPerformanceLink)).click();
	}
	
	public void getEquipPerformancePIILink(WebDriver driver, int y) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		ShareCheck obj = new ShareCheck();
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
	    //Clicks on ErrorFree Bank
        wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorFreeBankLink)).click();
	    /*Verify order or modules
	     * admin = 0
	     * nonadmin = 1
	    */
	    verifyOrderOfModules(driver, y);
	    //Clicks on Equipment Performance PII
	    wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentDatabankOnlyLink)).click();
	}
	
	public void getElecFailureModeLink(WebDriver driver, int y) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		ShareCheck obj = new ShareCheck();
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
	    //Clicks on ErrorFree Bank
        wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorFreeBankLink)).click();
	    /*Verify order or modules
	     * admin = 0
	     * nonadmin = 1
	    */
	    verifyOrderOfModules(driver, y);
	    //Clicks on Electrical Failure Mode
        try{
	    wait.until(ExpectedConditions.visibilityOfElementLocated(ElectricalFailureModeLink)).click();
        }catch(NoSuchElementException | org.openqa.selenium.TimeoutException e)
        {
        	wait.until(ExpectedConditions.visibilityOfElementLocated(FailureModeLink)).click();
        }
	}
	
	public void getMechFailureModeLink(WebDriver driver, int y) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		ShareCheck obj = new ShareCheck();
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
	    //Clicks on ErrorFree Bank
        wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorFreeBankLink)).click();
	    /*Verify order or modules
	     * admin = 0
	     * nonadmin = 1
	    */
	    verifyOrderOfModules(driver, y);
	    //Clicks on Mechanical Failure Mode
        try{
	    wait.until(ExpectedConditions.visibilityOfElementLocated(MechanicalFailureModeLink)).click();
        }catch(NoSuchElementException | org.openqa.selenium.TimeoutException e)
        {
        	wait.until(ExpectedConditions.visibilityOfElementLocated(FailureModeLink)).click();
        }	    
	}
	
	public void chooseDisciplineFailureModeSearch(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		CreateHumanCase obj = new CreateHumanCase();
		ShareCheck obj1 = new ShareCheck();
		//Click on top Error-free bank link
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ErrorFreeBankTopLink)).click();
		//Click on Failure Modes
		wait.until(ExpectedConditions.visibilityOfElementLocated(FailureModeLink)).click();
		//Search for keyword
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchKeywordField)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchKeywordField)).sendKeys("failure");
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Wait for loading message
		obj1.loadingServer(driver);
		//Get number of cases displayed when no discipline is selected
		int i = getNumberOfCasesIn1stCollapsibleListEquip(driver);
		System.out.println("Number of cases without any discipline chosen: "+(i));
		//Select random discipline in Failure mode search
		selectRandomDisciplineInSearchCase(driver);
		Thread.sleep(1000);
		//Click on search button
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchKeywordFieldSearchButton)).click();
		//Wait for loading message
		obj1.loadingServer(driver);
		//Get number of cases displayed when no discipline is selected
		int j = getNumberOfCasesIn1stCollapsibleListEquip(driver);
		//Get text of Discipline box
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(CaseSearchDisciplineBoxText)).getText();
		System.out.println("Number of cases with one random discipline ("+s+") chosen: "+(j));
		softly.assertThat(j).as("test data").isLessThanOrEqualTo(i);
	}
	
	public void selectRandomDisciplineInSearchCase(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		CreateEquipmentCase obj = new CreateEquipmentCase();
    	//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
	    String browserName = cap.getBrowserName().toLowerCase();
	    String v = cap.getVersion().toString();
	    if (browserName.contains("internet")==true)
	    {
	    	if (v.startsWith("10")==true)
	    	{
	    		//Discipline
	    		wait.until(ExpectedConditions.visibilityOfElementLocated(CaseSearchDisciplineBox));
	    		wait.until(ExpectedConditions.visibilityOfElementLocated(CaseSearchDisciplineBox)).sendKeys(Keys.ENTER);
	    	}
	    	if (v.startsWith("11")==true)
		    {
				//Discipline
				wait.until(ExpectedConditions.visibilityOfElementLocated(CaseSearchDisciplineBox)).click();
			}
	    }
	    else{
	    //Discipline
		wait.until(ExpectedConditions.visibilityOfElementLocated(CaseSearchDisciplineBox)).click();
	    }
		Thread.sleep(1000);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(CaseSearchDisciplineList));
		//Choose a number between 1 and 6 for number of Discipline
		Random random = new Random ();
		int y;
		//Choose a number between 1 and 6
		while(true)
		{
			y = random.nextInt(7);
			if(y==0)
				continue;
			break;
		}
		for(int i=1;i<y;i++)
		{
			int x;
			//Choose a number between 1 and 6
			while(true)
			{
				x = random.nextInt(7);
				if(x==0)
					continue;
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-efse-filter-discipline-menu']/li["+x+"]/a"))).getAttribute("class");
				if(s.contains("ui-checkbox-on"))
					continue;
				break;
			}
		if(x==1)
		{
		    if (browserName.contains("internet")==true)
		    {
		    	obj.clickTypesDisciplineIE(driver, EquipCaseSearchListDisciplineElectrical);
		    }
		    else
		    	wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSearchListDisciplineElectrical)).click();			
		}
		if(x==2)
		{
		    if (browserName.contains("internet")==true)
		    {
		    	obj.clickTypesDisciplineIE(driver, EquipCaseSearchListDisciplineGeneral);
		    }
		    else
		    	wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSearchListDisciplineGeneral)).click();				
		}
		if(x==3)
		{
		    if (browserName.contains("internet")==true)
		    {
		    	obj.clickTypesDisciplineIE(driver, EquipCaseSearchListDisciplineIC);
		    }
		    else
		    	wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSearchListDisciplineIC)).click();			
		}
		if(x==4)
		{
		    if (browserName.contains("internet")==true)
		    {
		    	obj.clickTypesDisciplineIE(driver, EquipCaseSearchListDisciplineMechanical);
		    }
		    else
		    	wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSearchListDisciplineMechanical)).click();		
		}
		if(x==5)
		{
		    if (browserName.contains("internet")==true)
		    {
		    	obj.clickTypesDisciplineIE(driver, EquipCaseSearchListDisciplineSoftware);
		    }
		    else
		    	wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSearchListDisciplineSoftware)).click();			
		}
		if(x==6)
		{
		    if (browserName.contains("internet")==true)
		    {
		    	obj.clickTypesDisciplineIE(driver, EquipCaseSearchListDisciplineStructural);
		    }
		    else
		    	wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseSearchListDisciplineStructural)).click();		
		}
		}
		//Close Discipline pop up
		wait.until(ExpectedConditions.visibilityOfElementLocated(CaseSearchDisciplinePopupClose)).click();
	}
	
	public int getNumberOfCasesIn1stCollapsibleListEquip(WebDriver driver) throws Exception {
		
		//Get number of cases displayed when no discipline is selected
		int i=1;
		while(true)
		{
			try
			{
				//Look for case collapsibles
				driver.findElement(By.xpath(".//*[@id='pii-question-list-equip']/div[1]/div[1]/div["+i+"]"));				
				i=i+1;
			}catch(NoSuchElementException e)
			{
				break;
			}
		}
		return (i-1);
	}
	 
	public void searchColorKeywordEquip(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		CreateHumanCase obj = new CreateHumanCase();
		//Click on top Error-free bank link
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ErrorFreeBankTopLink)).click();
		//Click on Equipment Data Bank only
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentDatabankOnlyLink1)).click();
		//Enter keyword oil color
		searchColorCasesEquip(driver);
		//Click on top Error-free bank link
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ErrorFreeBankTopLink)).click();
		//Click on Equipment Data Bank only
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentPerformanceLink)).click();
		//Enter keyword oil color
		searchColorCasesEquip(driver);
	}
	
	public void searchColorKeywordHuman(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		CreateHumanCase obj = new CreateHumanCase();
		//Click on top Error-free bank link
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ErrorFreeBankTopLink)).click();
		//Click on Human Performance only
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanPerformanceLink)).click();
		//Enter keyword oil color
		searchColorCasesHuman(driver);
	}
	
	public void searchColorCasesHuman(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		ShareCheck obj = new ShareCheck();
		//Search for keyword oil
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanSearchKeywordField)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanSearchKeywordField)).sendKeys("oil color");
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanSearchKeywordField)).sendKeys(Keys.ENTER);
		//Wait for loading message
		obj.loadingServer(driver);
		int i=1;
		//Check for titles for 1st set of cases (Similar results)
		while(true)
		{
			try
			{
				//Get title
				String title = driver.findElement(By.xpath(".//*[@id='pii-question-list']/div[1]/div[1]/div["+i+"]/h4/a")).getText();
				softly.assertThat(title).as("test data").doesNotContain("color:blue");
				i=i+1;
			}catch(NoSuchElementException e)
			{
				break;
			}
		}
		//Get URL
		String url = driver.getCurrentUrl();
		if(url.contains("kaleqa"))
		{
			browseCaseForColorKeywordHuman(driver,caseHumanColor);
		}
		//Choose any one random case from the list of Similar Results cases
		Random random = new Random();
		int num;
		while(true)
		{
			num = random.nextInt(i);
			if(num == 0)
				continue;
			break;
		}
		if(url.contains("kaleasia")||url.contains("kale."))
		{
			//Get case id
			String caseID = driver.findElement(By.xpath(".//*[@id='pii-question-list']/div[1]/div[1]/div["+num+"]")).getAttribute("qid");
			browseCaseForColorKeywordHuman(driver,caseID);
		}
		//Close 1st collapsible and open 2nd collapsible for cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanSearch1stCollapsibleCases)).click();
		//open 2nd collapsible
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(HumanSearch2ndCollapsibleCases)).click();
		}catch(NoSuchElementException | org.openqa.selenium.TimeoutException e)
		{
			
		}
		int j=1;
		//Check for titles for 2nd set of cases (Other results)
		while(true)
		{
			try
			{
				//Get title
				String title = driver.findElement(By.xpath(".//*[@id='pii-question-list']/div[2]/div[1]/div["+j+"]/h4/a")).getText();
				softly.assertThat(title).as("test data").doesNotContain("color:blue");
				j=j+1;
			}catch(NoSuchElementException e)
			{
				break;
			}
		}

	}
	
	public void browseCaseForColorKeywordHuman(WebDriver driver, String caseID) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		ShareCheck obj = new ShareCheck();
		//Scroll to case
		WebElement l = driver.findElement(By.id("pii-collapsible-"+caseID));
		obj.scrollToElement(driver, l);
		//Click on case collapsible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-"+caseID))).click();
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Check in description of case inside collapsible if it has color:blue
		String desc1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-collapsible-"+caseID+"']/div/p[1]"))).getText();
		softly.assertThat(desc1).as("test data").doesNotContain("color:blue");
		String desc2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-collapsible-"+caseID+"']/div/p[2]"))).getText();
		softly.assertThat(desc2).as("test data").doesNotContain("color:blue");
		//Show Slides
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-button-"+caseID)));
		WebElement element =  driver.findElement(By.id("pii-slideshow-button-"+caseID));
		String slide = element.getText();
		System.out.println(slide);
		while (slide.contains("Show Slides(")==false)
		{
			Thread.sleep(1000);
			System.out.println(slide);
			slide = element.getText();
		}
		//Click on Show Slides
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-button-"+caseID))).sendKeys(Keys.TAB);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-button-"+caseID))).sendKeys(Keys.ENTER);
		//Get title of case and verify if it has color:white
		String titleCase = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-"+caseID+"']/ul/li[1]/div"))).getAttribute("textContent");
		softly.assertThat(titleCase).as("test data").doesNotContain("color:white");
		//Close case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-"+caseID+"']/a"))).click();
	}
	
	public void searchColorCasesEquip(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		ShareCheck obj = new ShareCheck();
		//Search for keyword oil
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchKeywordField)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchKeywordField)).sendKeys("oil color");
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Wait for loading message
		obj.loadingServer(driver);
		int i=1;
		//Check for titles for 1st set of cases (Similar results)
		while(true)
		{
			try
			{
				//Get title
				String title = driver.findElement(By.xpath(".//*[@id='pii-question-list-equip']/div[1]/div[1]/div["+i+"]/h4/a")).getText();
				softly.assertThat(title).as("test data").doesNotContain("color:blue");
				i=i+1;
			}catch(NoSuchElementException e)
			{
				break;
			}
		}
		//Get URL
		String url = driver.getCurrentUrl();
		if(url.contains("kaleqa"))
		{
			browseCaseForColorKeywordEquip(driver,caseEquipColor);
		}
		//Choose any one random case from the list of Similar Results cases
		Random random = new Random();
		int num;
		while(true)
		{
			num = random.nextInt(i);
			if(num == 0)
				continue;
			break;
		}
		if(url.contains("kaleasia")||url.contains("kale."))
		{
			//Get case id
			String caseID = driver.findElement(By.xpath(".//*[@id='pii-question-list-equip']/div[1]/div[1]/div["+num+"]")).getAttribute("qid");
			browseCaseForColorKeywordEquip(driver,caseID);
		}
		//Close 1st collapsible and open 2nd collapsible for cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipSearch1stCollapsibleCases)).click();
		//open 2nd collapsible
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipSearch2ndCollapsibleCases)).click();
		}catch(NoSuchElementException | org.openqa.selenium.TimeoutException e)
		{
			
		}
		int j=1;
		//Check for titles for 2nd set of cases (Other results)
		while(true)
		{
			try
			{
				//Get title
				String title = driver.findElement(By.xpath(".//*[@id='pii-question-list-equip']/div[2]/div[1]/div["+j+"]/h4/a")).getText();
				softly.assertThat(title).as("test data").doesNotContain("color:blue");
				j=j+1;
			}catch(NoSuchElementException e)
			{
				break;
			}
		}

	}
	
	public void browseCaseForColorKeywordEquip(WebDriver driver, String caseID) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		ShareCheck obj = new ShareCheck();
		//Scroll to case
		WebElement l = driver.findElement(By.id("pii-collapsible-equip-"+caseID));
		obj.scrollToElement(driver, l);
		//Click on case collapsible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-"+caseID))).click();
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Check in description of case inside collapsible if it has color:blue
		String desc1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-collapsible-equip-"+caseID+"']/div/p[1]"))).getText();
		softly.assertThat(desc1).as("test data").doesNotContain("color:blue");
		String desc2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-collapsible-equip-"+caseID+"']/div/p[2]"))).getText();
		softly.assertThat(desc2).as("test data").doesNotContain("color:blue");
		//Show Slides
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-button-equip-"+caseID)));
		WebElement element =  driver.findElement(By.id("pii-slideshow-button-equip-"+caseID));
		String slide = element.getText();
		System.out.println(slide);
		while (slide.contains("Show Slides(")==false)
		{
			Thread.sleep(1000);
			System.out.println(slide);
			slide = element.getText();
		}
		//Click on Show Slides
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-button-equip-"+caseID))).sendKeys(Keys.TAB);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-button-equip-"+caseID))).sendKeys(Keys.ENTER);
		//Get title of case and verify if it has color:white
		String titleCase = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-"+caseID+"']/ul/li[1]/div"))).getAttribute("textContent");
		softly.assertThat(titleCase).as("test data").doesNotContain("color:white");
		//Close case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-"+caseID+"']/a"))).click();
	}
	
	public void verifyOrderOfModules(WebDriver driver, int y) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify order
		//Human Performance
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HumanPerformancePosition)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Human Performance");
		//Engineering Fundamentals
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(EngineeringFundamentalPosition)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Engineering Fundamentals");
		//Equipment Performance
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentPerformancePosition)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Equipment Performance");
		//Failure Modes
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(FailureModesPosition)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("Failure Modes");
		//Prevention of Design Deficiencies
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(PreventionOfDesignDeficienciesPosition)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Prevention of Design Deficiencies");
		if(y==0)
		{
			//Equipment Data Bank (Instructor Only)
			String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentDatabankOnlyPosition)).getText();
			softly.assertThat(s5).as("test data").isEqualTo("Equipment Data Bank (Instructor Only)");
		}
		if(y==1)
			verifyNoEquipPII(driver);
	}
	
	public void verifyNoEquipPII(WebDriver driver) throws Exception {
		
		//Checks for equipment search pii
		if(driver.findElement(EquipmentDatabankOnlyLink1).isDisplayed()==false)
		{
		  System.out.println("Non admin user cannot see Equipment Search PII");
	    }
		else softly.fail("Equipment PII is present in non admin");
	}
	
	public void addKeywordWithAllSpecialCharactersEquip(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
	    String browserName = cap.getBrowserName().toLowerCase();
	    System.out.println(browserName);
	    String v = cap.getVersion().toString();
	    System.out.println(v);
	    String url = driver.getCurrentUrl();
	    //Clear keyword field
	    wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentAddKeywordField)).clear();
	    //Assigns keyword as per browser and url
	    if(url.contains("kaleqa"))
	    {
	    	if ((browserName.equals("internet explorer"))&&(v.startsWith("11")))
	    	{
	    		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentAddKeywordField)).sendKeys(keywordEquipDevAllSpecial_ie11);
	    	}
	    	else
	    	{
	    		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentAddKeywordField)).sendKeys(keywordEquipDevAllSpecial);
	    	}
	    }
	    else
	    {
	    	if ((browserName.equals("internet explorer"))&&(v.startsWith("11")))
	    	{
	    		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentAddKeywordField)).sendKeys(keywordEquipProdAllSpecial_ie11);
	    	}
	    	else
	    	{
	    		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentAddKeywordField)).sendKeys(keywordEquipProdAllSpecial);
	    	}
	    }
	    Thread.sleep(2000);
	    jse.executeScript("scroll(0,2000)");	
	    Thread.sleep(2000);
	    //Click on add keyword
	    wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentAddKeywordButton)).click();	
	    WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentAddKeywordField));
	    for (int i=0; i<s.length;i++)
		{
			//clear keyword field
			ele.clear();
			Thread.sleep(1000);
			//search for foo<special character>foo
			if ((browserName.equals("internet explorer"))&&(v.startsWith("11")))
				ele.sendKeys("qaafooie"+s[i]+"qaafooie");
			else
				ele.sendKeys("qaafoo"+s[i]+"qaafoo");
			Thread.sleep(1500);
			jse.executeScript("scroll(0,2000)");	
		    Thread.sleep(2000);
			//Click on add keyword
		    wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentAddKeywordButton)).click();	
		}
	    Thread.sleep(2000);
	    try{
	    jse.executeScript("scroll(0,2000)");	
	    }catch (org.openqa.selenium.ScriptTimeoutException e)
	    {
	    	Thread.sleep(2000);
	    	jse.executeScript("scroll(0,2000)");	
	    }
	    Thread.sleep(2000);
	}
	
	public void addKeywordWithAllSpecialCharactersHuman(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
	    String browserName = cap.getBrowserName().toLowerCase();
	    System.out.println(browserName);
	    String v = cap.getVersion().toString();
	    System.out.println(v);
	    String url = driver.getCurrentUrl();
	    //Clear keyword field
	    wait.until(ExpectedConditions.visibilityOfElementLocated(HumanAddKeywordField)).clear();
	    Thread.sleep(1000);
	    //Assigns keyword as per browser and url
	    if(url.contains("kaleqa"))
	    {
	    	if ((browserName.equals("internet explorer"))&&(v.startsWith("11")))
	    	{
	    		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanAddKeywordField)).sendKeys(keywordHumanDevAllSpecial_ie11);
	    	}
	    	else
	    	{
	    		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanAddKeywordField)).sendKeys(keywordHumanDevAllSpecial);
	    	}
	    }
	    else
	    {
	    	if ((browserName.equals("internet explorer"))&&(v.startsWith("11")))
	    	{
	    		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanAddKeywordField)).sendKeys(keywordHumanProdAllSpecial_ie11);
	    	}
	    	else
	    	{
	    		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanAddKeywordField)).sendKeys(keywordHumanProdAllSpecial);
	    	}
	    }
	    Thread.sleep(2000);
	    WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(HumanAddKeywordField));
	    //Click on add keyword
	    wait.until(ExpectedConditions.visibilityOfElementLocated(HumanAddKeywordButton)).click();	
	    for (int i=0; i<s.length;i++)
		{
			//clear keyword field
			ele.clear();
			Thread.sleep(1000);
			//search for foo<special character>foo
			if ((browserName.equals("internet explorer"))&&(v.startsWith("11")))
				ele.sendKeys("qaafooie"+s[i]+"qaafooie");
			else
				ele.sendKeys("qaafoo"+s[i]+"qaafoo");
			Thread.sleep(1500);
			//Click on add keyword
		    wait.until(ExpectedConditions.visibilityOfElementLocated(HumanAddKeywordButton)).click();	
		}
	    jse.executeScript("scroll(0,2000)");	
	    Thread.sleep(2000);
	}
	
	public void searchWithKeyKeywordWithAllSpecialCharacters(WebDriver driver,String identifier) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement ele=null;
		//Search for either Human or Equipment search element for Term field
		try{
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchKeywordField));
		}catch (NoSuchElementException | org.openqa.selenium.TimeoutException e)
		{
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(HumanSearchKeywordField));
		}
		//clear term field
		ele.clear();
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
	    String browserName = cap.getBrowserName().toLowerCase();
	    System.out.println(browserName);
	    String v = cap.getVersion().toString();
	    System.out.println(v);
	    String url = driver.getCurrentUrl();
		//Assigns keyword as per browser and url
	    if(url.contains("kaleqa"))
	    {
	    	if ((browserName.equals("internet explorer"))&&(v.startsWith("11")))
	    	{
	    		ele.sendKeys(keywordHumanDevAllSpecial_ie11);
	    	}
	    	else
	    	{
	    		ele.sendKeys(keywordHumanDevAllSpecial);
	    	}
	    }
	    else
	    {
	    	if ((browserName.equals("internet explorer"))&&(v.startsWith("11")))
	    	{
	    		ele.sendKeys(keywordHumanProdAllSpecial_ie11);
	    	}
	    	else
	    	{
	    		ele.sendKeys(keywordHumanProdAllSpecial);
	    	}
	    }
	    Thread.sleep(2000);
	    //Press ENTER
	    ele.sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);
		//Look for case
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
		}catch (NoSuchElementException | org.openqa.selenium.TimeoutException e)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+identifier)));
		}		
		//Clear
		try{
			driver.findElement(EquipmentSearchClearButton).click();
		}catch (NoSuchElementException | org.openqa.selenium.TimeoutException | org.openqa.selenium.ElementNotInteractableException e)
		{
			driver.findElement(HumanSearchClearButton).click();
		}
	}

	
	public void searchWithKeywordKALE1964(WebDriver driver, SoftAssertions softly1) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebDriverWait wait1 = new WebDriverWait(driver,5);
		WebElement ele=null;
		//Search for either Human or Equipment search element for Term field
		try{
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchKeywordField));
		}catch (NoSuchElementException | org.openqa.selenium.TimeoutException e)
		{
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(HumanSearchKeywordField));
		}
		//Array of special characters
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
	    String browserName = cap.getBrowserName().toLowerCase();
	    String v = cap.getVersion().toString();
		for (int i=0; i<s.length;i++)
		{
			//clear term field
			ele.clear();
			//search for foo<special character>foo
			if ((browserName.equals("internet explorer"))&&(v.startsWith("11")))
				ele.sendKeys("qaafooie"+s[i]+"qaafooie");
			else
				ele.sendKeys("qaafoo"+s[i]+"qaafoo");
			WebElement dropdown;
			//Look for dynamic dropdown
			try{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchDropDown));
			}catch (NoSuchElementException | org.openqa.selenium.TimeoutException e)
			{
				try{
					wait1.until(ExpectedConditions.visibilityOfElementLocated(HumanSearchDropDown));
				}catch (NoSuchElementException | org.openqa.selenium.TimeoutException e1)
				{
					System.out.println("Dropdown not visible as no case exists with keyword: " +"qaafoo"+s[i]+"qaafoo");
				}				
			}
			//Press Enter
			ele.sendKeys(Keys.ENTER);
			//Wait for loading message to disappear
			ShareCheck obj = new ShareCheck();
			obj.loadingServer(driver);
			//Verify dropdown has disappeared
			try{
				dropdown = driver.findElement(EquipmentSearchDropDown);
			}catch (NoSuchElementException u)
			{
				dropdown = driver.findElement(HumanSearchDropDown);
			}
			if(dropdown.isDisplayed()==true)
			{
				softly1.fail("Dropdown visible and the webelement is: "+dropdown.getAttribute("id"));
			}
			//Clear
			try{
				driver.findElement(EquipmentSearchClearButton).click();
			}catch (NoSuchElementException | org.openqa.selenium.TimeoutException | org.openqa.selenium.ElementNotInteractableException e)
			{
				driver.findElement(HumanSearchClearButton).click();
			}
		}	
	}	
		
	public void searchWithPercentEquip(WebDriver driver, String keypercent, String identifier) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		Thread.sleep(3000);
		//Checks with new keyword with %
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchKeywordField)).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchKeywordField)).sendKeys(keypercent);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchKeywordFieldSearchButton)).click();
		//Wait for loading message to disappear
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
		Thread.sleep(2000);		  
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchClearButton)).click();
	}
	
	public void searchWithSpclEquip(WebDriver driver, String keyspcl, String identifier) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		Thread.sleep(3000);
		//Checks with new keyword with %
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchKeywordField)).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchKeywordField)).sendKeys(keyspcl);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchKeywordFieldSearchButton)).click();
		//Wait for loading message to disappear
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
		Thread.sleep(2000);		  
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchClearButton)).click();
	}
	
	public void verifySearchOptionsEquip (WebDriver driver, String keyword, String identifier) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		WebDriverWait wait1 = new WebDriverWait(driver,5);
		//Clears Everything
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchClearButton)).click();
		Thread.sleep(2000);
		//Checks if clear feature works on term field
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchKeywordField)).sendKeys(keyword);
		Thread.sleep(1000);
		Actions act1 = new Actions(driver);
		WebElement act= wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchKeywordFieldClearButton));
		act1.click(act).build().perform();
		//Checks for search method with magnifying glass
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchKeywordField)).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchKeywordFieldSearchButton)).click();
		//Wait for loading message to disappear
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Look for dynamic dropdown
		try{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchDropDown));
			softly.fail("Dynamic dropdown visible after click on search button for keyword search");
		}catch (NoSuchElementException | org.openqa.selenium.TimeoutException e)
		{
			System.out.println("Dropdown not visible");				
		}
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchClearButton)).click();
		//Enters the term and check the search by enter
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchKeywordField)).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Look for dynamic dropdown
		try{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchDropDown));
			softly.fail("Dynamic dropdown visible after click on search button for keyword search");
		}catch (NoSuchElementException | org.openqa.selenium.TimeoutException e)
		{
			System.out.println("Dropdown not visible");				
		}
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchClearButton)).click();
		Thread.sleep(2000);
		//Checks for search method with dropdown
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchKeywordField)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchKeywordField)).sendKeys(keyword);
		Thread.sleep(2000);
		clickDropdownEquip(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));		
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchClearButton)).click();
	}
	
	public void clickDropdownEquip(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		WebElement match=wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentDropDownList));
		String text = match.getText();
		System.out.println(text);
		if(text.equals("Exact Match Keywords"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentDropDownListTitle)).click();				  
		}
		else if(text.equals("Similar Match Keywords"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentDropDownListTitle)).click();
		}
		else if(text.equals("Other Match Keywords"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentDropDownListTitle)).click();
		}
		//Wait for loading message to disappear
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);	
	}
	
	public void browseTermEquip (WebDriver driver, String keyword, String identifier, String title) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
	    int n = searchKeywordForBrowseCaseEquip(driver,keyword,identifier);
		Thread.sleep(1000);
		String expected_title = "F"+identifier+": "+title;
		//Click next button to browse through case
		nextBrowseEquipAdmin(driver,n,expected_title,identifier);
		//Click previous button to browse through case
		previousBrowseEquip(driver,n,expected_title,identifier);
		//Closes the slideshow
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+identifier+"']/a"))).click();
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchClearButton)).click();
	}
	
	public void browseCaseIDEquip (WebDriver driver, String identifier, String title) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		//Checks if clear feature works on case id field
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchCaseIdField)).sendKeys(identifier);
		Thread.sleep(1000);
		WebElement ele= driver.findElement(EquipmentSearchCaseIDFieldClearButton);
		Actions act = new Actions (driver);
		act.click(ele).build().perform();
		//Checks for search method with magnifying glass
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchCaseIdField)).sendKeys(identifier);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchCaseIDFieldSearchButton)).click();
		//Wait for loading message to disappear
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchClearButton)).click();
		Thread.sleep(2000);
		//Enters case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchCaseIdField)).sendKeys(identifier);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchCaseIdField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Clicks on case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier))).click();
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Clicks on Show Slides
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-button-equip-F"+identifier)));
		WebElement element =  driver.findElement(By.id("pii-slideshow-button-equip-F"+identifier));
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
		driver.findElement(By.id("pii-slideshow-equip-F"+identifier+"-popup"));
		System.out.println(number);
		int n = Integer.parseInt(number);
		Thread.sleep(1000);
		String expected_title = "F"+identifier+": "+title;
		//Click next button to browse through case
		nextBrowseEquipAdmin(driver,n,expected_title,identifier);
		//Click previous button to browse through case
		previousBrowseEquip(driver,n,expected_title,identifier);
		//Closes the slideshow
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+identifier+"']/a"))).click();
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchClearButton)).click();
	}
	
	public void browseTermHuman (WebDriver driver, String keyword, String identifier, String title) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
	    int n = searchKeywordForBrowseCaseHuman(driver,keyword,identifier);
		Thread.sleep(1000);
		String expected_title = "Q"+identifier+": "+title;
		//Click next button to browse through case
		nextBrowseHumanAdmin(driver,n,expected_title,identifier);
		//Click previous button to browse through case
		previousBrowseHuman(driver,n,expected_title,identifier);
		//Closes the slideshow
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-Q"+identifier+"']/a"))).click();
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanSearchClearButton)).click();
	}
	
	public void browseCaseNonAdminHuman(WebDriver driver, String keyword, String identifier, String title) throws Exception{
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		Thread.sleep(1000);
		int n = searchKeywordForBrowseCaseHuman(driver,keyword,identifier);
		String expected_title = "Q"+identifier+": "+title;
		//Click next button to browse through case
		nextBrowseHumanNonAdmin(driver,n,expected_title,identifier);
		//Click previous button to browse through case
		previousBrowseHuman(driver,n,expected_title,identifier);
		//Closes the slideshow
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-Q"+identifier+"']/a"))).click();
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanSearchClearButton)).click();
		//verify no case id box
		verifyNoCaseIDSearchHuman (driver);
	}
	
	public void browseCaseIDHuman (WebDriver driver, String identifier, String title) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		//Checks if clear feature works on case id field
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanSearchCaseIdField)).sendKeys(identifier);
		Thread.sleep(1000);
		WebElement ele= driver.findElement(HumanSearchCaseIDFieldClearButton);
		Actions act = new Actions (driver);
		act.click(ele).build().perform();
		//Checks for search method with magnifying glass
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanSearchCaseIdField)).sendKeys(identifier);
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanSearchCaseIDFieldSearchButton)).click();
		//Wait for loading message to disappear
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+identifier)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanSearchClearButton)).click();
		Thread.sleep(2000);
		//Enters case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanSearchCaseIdField)).sendKeys(identifier);
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanSearchCaseIdField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Clicks on case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+identifier))).click();
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Clicks on Show Slides
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-button-Q"+identifier)));
		WebElement element =  driver.findElement(By.id("pii-slideshow-button-Q"+identifier));
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
		driver.findElement(By.id("pii-slideshow-Q"+identifier+"-popup"));
		System.out.println(number);
		int n = Integer.parseInt(number);
		Thread.sleep(1000);
		String expected_title = "Q"+identifier+": "+title;
		//Click next button to browse through case
		nextBrowseHumanAdmin(driver,n,expected_title,identifier);
		//Click previous button to browse through case
		previousBrowseHuman(driver,n,expected_title,identifier);
		//Closes the slideshow
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-Q"+identifier+"']/a"))).click();
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanSearchClearButton)).click();
	}
	
	public void verifyNoCaseIDSearchEquip (WebDriver driver) throws Exception {
		
		//Searches for case id box
		  try{
		  	WebElement caseSearch= driver.findElement(EquipmentSearchCaseIdField);
		  	if (caseSearch.isDisplayed()==true)
		  		softly.fail("Case id search displayed");
		  	if(caseSearch.isDisplayed()==false)
		  		System.out.println("Case id search box not displayed");

		  }catch(NoSuchElementException e)
		  {
			  System.out.println("Case id search box not present.");
		  }
	}
	
	public void verifyNoCaseIDSearchHuman (WebDriver driver) throws Exception {
		
		//Searches for case id box
		  try{
		  	WebElement caseSearch= driver.findElement(HumanSearchCaseIdField);
		  	if (caseSearch.isDisplayed()==true)
		  		softly.fail("Case id search displayed");
		  	if(caseSearch.isDisplayed()==false)
		  		System.out.println("Case id search box not displayed");

		  }catch(NoSuchElementException e)
		  {
			  System.out.println("Case id search box not present.");
		  }
	}
	
	public int searchKeywordForBrowseCaseHuman(WebDriver driver, String keyword, String identifier) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		//Types in the keyword to get slide
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanSearchKeywordField)).clear();
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanSearchKeywordField)).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanSearchKeywordField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);
		//Click on collapsible 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+identifier))).click();
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Clicks on Show Slides
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-button-Q"+identifier)));
		WebElement element =  driver.findElement(By.id("pii-slideshow-button-Q"+identifier));
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
		driver.findElement(By.id("pii-slideshow-Q"+identifier+"-popup"));
		System.out.println(number);
		int n = Integer.parseInt(number);
		return n;
	}
	
	public int searchKeywordForBrowseCaseEquip(WebDriver driver, String keyword, String identifier) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		//Types in the keyword to get slide
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchKeywordField)).clear();
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchKeywordField)).sendKeys(keyword);
		//Get name of current module
		String str = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentModuleTitle)).getText();
		if(str.contains("equipment performance cases (PII)"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		}
		else{
		//Look for case by clicking on dropdown
		Thread.sleep(4000);
		WebElement match = null;
		try{
			match=driver.findElement(EquipmentDropDownList);
		}catch(NoSuchElementException r)
		{
			//Wait for a few seconds and then try again
			Thread.sleep(3000);
			//Types in the keyword to get slide
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchKeywordField)).clear();
			Thread.sleep(4000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchKeywordField)).sendKeys(keyword);
			Thread.sleep(3000);
			match=driver.findElement(EquipmentDropDownList);
		}
		String text = match.getText();
		System.out.println(text);
		if(text.equals("Exact Match Keywords"))
		{
		  driver.findElement(EquipmentDropDownListTitle).click();				  
		}
		else if(text.equals("Similar Match Keywords"))
		{
		  driver.findElement(EquipmentDropDownListTitle).click();
		}
		else if(text.equals("Other Match Keywords"))
		{
		  driver.findElement(EquipmentDropDownListTitle).click();
		}
		}
		//Wait for loading message to disappear
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);
		//Click on collapsible 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier))).click();
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Clicks on Show Slides
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-button-equip-F"+identifier)));
		WebElement element =  driver.findElement(By.id("pii-slideshow-button-equip-F"+identifier));
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
		driver.findElement(By.id("pii-slideshow-equip-F"+identifier+"-popup"));
		System.out.println(number);
		int n = Integer.parseInt(number);
		return n;
	}
	
	public void browseCaseNonAdminEquip(WebDriver driver, String keyword, String identifier, String title) throws Exception{
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		Thread.sleep(1000);
		int n = searchKeywordForBrowseCaseEquip(driver,keyword,identifier);
		String expected_title = "F"+identifier+": "+title;
		//Click next button to browse through case
		nextBrowseEquipNonAdmin(driver,n,expected_title,identifier);
		//Click previous button to browse through case
		previousBrowseEquip(driver,n,expected_title,identifier);
		//Closes the slideshow
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+identifier+"']/a"))).click();
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(EquipmentSearchClearButton)).click();
		//verify no case id box
		verifyNoCaseIDSearchEquip (driver);
	}
	
	public void nextBrowseEquipNonAdmin(WebDriver driver, int n, String expected_title, String identifier) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		//Click Next
		wait.until(ExpectedConditions.visibilityOfElementLocated(SlideNextButton)).click();
		for(int i=2;i<=n;i++)
		{
			System.out.println("Slide "+(i-1));
			String id = "pii-slideimg-F"+identifier+"-"+(i-1);
			Thread.sleep(2000);
			driver.findElement(By.id(id));
			Thread.sleep(1500);
			//Checking if title is correct
			String title_xpath = ".//*[@id='pii-slideshow-equip-F"+identifier+"']/ul/li["+i+"]/div";
			String actual_title = driver.findElement(By.xpath(title_xpath)).getAttribute("textContent");
			softly.assertThat(actual_title).as("test data").isEqualTo(expected_title);
			//Checking if copyright is correct
			String copyright_xpath = ".//*[@id='pii-slideshow-equip-F"+identifier+"']/ul/li["+i+"]/span/span";
			String actual_copyright = driver.findElement(By.xpath(copyright_xpath)).getAttribute("textContent");
			softly.assertThat(actual_copyright).as("test data").isEqualTo(expected_copyright);
			//Checking if footer image appears
			String image_xpath = ".//*[@id='pii-slideshow-equip-F"+identifier+"']/ul/li["+i+"]/span/img";
			if(driver.findElement(By.xpath(image_xpath)).isDisplayed())
				System.out.println("Logo is displayed");
			//Checking if slide number appears and is correct
			String slide_xpath = ".//*[@id='pii-slideshow-equip-F"+identifier+"']/ul/li["+i+"]/span/span[2]";
			String actual_slide = driver.findElement(By.xpath(slide_xpath)).getAttribute("textContent");
			String expected_slide = i+"/"+n;
			softly.assertThat(actual_slide).as("test data").isEqualTo(expected_slide);
			 //Moves out of the slideshow and checks for security
			  Thread.sleep(1000);
			  //Clicks on copyright
			  if(i==2)
				  driver.findElement(By.xpath(copyright_xpath)).click();
			  //Clicks on logo
			  if(i==3)
				  driver.findElement(By.xpath(image_xpath)).click();
			  //Clicks outside
			  if(i==4)
			  {
				  Actions act2 = new Actions(driver);
				  Point coordinates = driver.findElement(SlideNextButton).getLocation();
				  Robot robot = new Robot();
				  robot.mouseMove(coordinates.getX()+100,coordinates.getY());
				  Thread.sleep(2000);
				  act2.click().build().perform();
			  }
			  //Clicks on title
			  else 
				  driver.findElement(By.xpath(title_xpath)).click();
			  Thread.sleep(3000);
			  //Show slides
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-equip-show-F"+identifier))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(SlideNextButton)).click();
		}
	}
	
	public void nextBrowseHumanNonAdmin(WebDriver driver, int n, String expected_title, String identifier) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		//Click Next
		wait.until(ExpectedConditions.visibilityOfElementLocated(SlideNextButton)).click();
		for(int i=2;i<=n;i++)
		{
			System.out.println("Slide "+(i-1));
			String id = "pii-slideimg-Q"+identifier+"-"+(i-1);
			Thread.sleep(2000);
			driver.findElement(By.id(id));
			Thread.sleep(1500);
			//Checking if title is correct
			String title_xpath = ".//*[@id='pii-slideshow-Q"+identifier+"']/ul/li["+i+"]/div";
			String actual_title = driver.findElement(By.xpath(title_xpath)).getAttribute("textContent");
			softly.assertThat(actual_title).as("test data").isEqualTo(expected_title);
			//Checking if copyright is correct
			String copyright_xpath = ".//*[@id='pii-slideshow-Q"+identifier+"']/ul/li["+i+"]/span/span";
			String actual_copyright = driver.findElement(By.xpath(copyright_xpath)).getAttribute("textContent");
			softly.assertThat(actual_copyright).as("test data").isEqualTo(expected_copyright);
			//Checking if footer image appears
			String image_xpath = ".//*[@id='pii-slideshow-Q"+identifier+"']/ul/li["+i+"]/span/img";
			if(driver.findElement(By.xpath(image_xpath)).isDisplayed())
				System.out.println("Logo is displayed");
			//Checking if slide number appears and is correct
			String slide_xpath = ".//*[@id='pii-slideshow-Q"+identifier+"']/ul/li["+i+"]/span/span[2]";
			String actual_slide = driver.findElement(By.xpath(slide_xpath)).getAttribute("textContent");
			String expected_slide = i+"/"+n;
			softly.assertThat(actual_slide).as("test data").isEqualTo(expected_slide);
			 //Moves out of the slideshow and checks for security
			  Thread.sleep(1000);
			  //Clicks on copyright
			  if(i==2)
				  driver.findElement(By.xpath(copyright_xpath)).click();
			  //Clicks on logo
			  if(i==3)
				  driver.findElement(By.xpath(image_xpath)).click();
			  //Clicks outside
			  if(i==4)
			  {
				  Actions act2 = new Actions(driver);
				  Point coordinates = driver.findElement(SlideNextButton).getLocation();
				  Robot robot = new Robot();
				  robot.mouseMove(coordinates.getX()+100,coordinates.getY());
				  Thread.sleep(2000);
				  act2.click().build().perform();
			  }
			  //Clicks on title
			  else 
				  driver.findElement(By.xpath(title_xpath)).click();
			  Thread.sleep(3000);
			  //Show slides
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-show-Q"+identifier))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(SlideNextButton)).click();
		}
	}
	
	public void nextBrowseHumanAdmin(WebDriver driver, int n, String expected_title, String identifier) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		//Click Next
		wait.until(ExpectedConditions.visibilityOfElementLocated(SlideNextButton)).click();
		for(int i=2;i<=n;i++)
		{
			System.out.println("Slide "+(i-1));
			String id = "pii-slideimg-Q"+identifier+"-"+(i-1);
			Thread.sleep(2000);
			driver.findElement(By.id(id));
			Thread.sleep(1500);
			//Checking if title is correct
			String title_xpath = ".//*[@id='pii-slideshow-Q"+identifier+"']/ul/li["+i+"]/div";
			String actual_title = driver.findElement(By.xpath(title_xpath)).getAttribute("textContent");
			softly.assertThat(actual_title).as("test data").isEqualTo(expected_title);
			//Checking if copyright is correct
			String copyright_xpath = ".//*[@id='pii-slideshow-Q"+identifier+"']/ul/li["+i+"]/span/span";
			String actual_copyright = driver.findElement(By.xpath(copyright_xpath)).getAttribute("textContent");
			softly.assertThat(actual_copyright).as("test data").isEqualTo(expected_copyright);
			//Checking if footer image appears
			String image_xpath = ".//*[@id='pii-slideshow-Q"+identifier+"']/ul/li["+i+"]/span/img";
			if(driver.findElement(By.xpath(image_xpath)).isDisplayed())
				System.out.println("Logo is displayed");
			//Checking if slide number appears and is correct
			String slide_xpath = ".//*[@id='pii-slideshow-Q"+identifier+"']/ul/li["+i+"]/span/span[2]";
			String actual_slide = driver.findElement(By.xpath(slide_xpath)).getAttribute("textContent");
			String expected_slide = i+"/"+n;
			softly.assertThat(actual_slide).as("test data").isEqualTo(expected_slide);
			wait.until(ExpectedConditions.visibilityOfElementLocated(SlideNextButton)).click();
		}
	}
	
	public void previousBrowseHuman(WebDriver driver, int n, String expected_title, String identifier) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		//Click on previous
		wait.until(ExpectedConditions.visibilityOfElementLocated(SlidePreviousButton)).click();
		//Checks if there are slides present
		for (int i=n;i>=2;i--)
		{
			System.out.println("Slide "+(i));
			String id = "pii-slideimg-Q"+identifier+"-"+(i-1);
			Thread.sleep(2000);
			driver.findElement(By.id(id));
			Thread.sleep(1500);
		    //Checking if title is correct
			String title_xpath = ".//*[@id='pii-slideshow-Q"+identifier+"']/ul/li["+i+"]/div";
			String actual_title = driver.findElement(By.xpath(title_xpath)).getAttribute("textContent");
			softly.assertThat(actual_title).as("test data").isEqualTo(expected_title);
			//Checking if copyright is correct
			String copyright_xpath = ".//*[@id='pii-slideshow-Q"+identifier+"']/ul/li["+i+"]/span/span";
			String actual_copyright = driver.findElement(By.xpath(copyright_xpath)).getAttribute("textContent");
			softly.assertThat(actual_copyright).as("test data").isEqualTo(expected_copyright);
			//Checking if footer image appears
			String image_xpath = ".//*[@id='pii-slideshow-Q"+identifier+"']/ul/li["+i+"]/span/img";
			if(driver.findElement(By.xpath(image_xpath)).isDisplayed())
				System.out.println("Logo is displayed");
			//Checking if slide number appears and is correct
			String slide_xpath = ".//*[@id='pii-slideshow-Q"+identifier+"']/ul/li["+i+"]/span/span[2]";
			String actual_slide = driver.findElement(By.xpath(slide_xpath)).getAttribute("textContent");
			String expected_slide = i+"/"+n;
			softly.assertThat(actual_slide).as("test data").isEqualTo(expected_slide);
		    //Click on previous
			wait.until(ExpectedConditions.visibilityOfElementLocated(SlidePreviousButton)).click();
		}
	}
	
	public void nextBrowseEquipAdmin(WebDriver driver, int n, String expected_title, String identifier) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		//Click Next
		wait.until(ExpectedConditions.visibilityOfElementLocated(SlideNextButton)).click();
		for(int i=2;i<=n;i++)
		{
			System.out.println("Slide "+(i-1));
			String id = "pii-slideimg-F"+identifier+"-"+(i-1);
			Thread.sleep(2000);
			driver.findElement(By.id(id));
			Thread.sleep(1500);
			//Checking if title is correct
			String title_xpath = ".//*[@id='pii-slideshow-equip-F"+identifier+"']/ul/li["+i+"]/div";
			String actual_title = driver.findElement(By.xpath(title_xpath)).getAttribute("textContent");
			softly.assertThat(actual_title).as("test data").isEqualTo(expected_title);
			//Checking if copyright is correct
			String copyright_xpath = ".//*[@id='pii-slideshow-equip-F"+identifier+"']/ul/li["+i+"]/span/span";
			String actual_copyright = driver.findElement(By.xpath(copyright_xpath)).getAttribute("textContent");
			softly.assertThat(actual_copyright).as("test data").isEqualTo(expected_copyright);
			//Checking if footer image appears
			String image_xpath = ".//*[@id='pii-slideshow-equip-F"+identifier+"']/ul/li["+i+"]/span/img";
			if(driver.findElement(By.xpath(image_xpath)).isDisplayed())
				System.out.println("Logo is displayed");
			//Checking if slide number appears and is correct
			String slide_xpath = ".//*[@id='pii-slideshow-equip-F"+identifier+"']/ul/li["+i+"]/span/span[2]";
			String actual_slide = driver.findElement(By.xpath(slide_xpath)).getAttribute("textContent");
			String expected_slide = i+"/"+n;
			softly.assertThat(actual_slide).as("test data").isEqualTo(expected_slide);
			wait.until(ExpectedConditions.visibilityOfElementLocated(SlideNextButton)).click();
		}
	}
	
	public void previousBrowseEquip(WebDriver driver, int n, String expected_title, String identifier) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		//Click on previous
		wait.until(ExpectedConditions.visibilityOfElementLocated(SlidePreviousButton)).click();
		//Checks if there are slides present
		for (int i=n;i>=2;i--)
		{
			System.out.println("Slide "+(i));
			String id = "pii-slideimg-F"+identifier+"-"+(i-1);
			Thread.sleep(2000);
			driver.findElement(By.id(id));
			Thread.sleep(1500);
		    //Checking if title is correct
			String title_xpath = ".//*[@id='pii-slideshow-equip-F"+identifier+"']/ul/li["+i+"]/div";
			String actual_title = driver.findElement(By.xpath(title_xpath)).getAttribute("textContent");
			softly.assertThat(actual_title).as("test data").isEqualTo(expected_title);
			//Checking if copyright is correct
			String copyright_xpath = ".//*[@id='pii-slideshow-equip-F"+identifier+"']/ul/li["+i+"]/span/span";
			String actual_copyright = driver.findElement(By.xpath(copyright_xpath)).getAttribute("textContent");
			softly.assertThat(actual_copyright).as("test data").isEqualTo(expected_copyright);
			//Checking if footer image appears
			String image_xpath = ".//*[@id='pii-slideshow-equip-F"+identifier+"']/ul/li["+i+"]/span/img";
			if(driver.findElement(By.xpath(image_xpath)).isDisplayed())
				System.out.println("Logo is displayed");
			//Checking if slide number appears and is correct
			String slide_xpath = ".//*[@id='pii-slideshow-equip-F"+identifier+"']/ul/li["+i+"]/span/span[2]";
			String actual_slide = driver.findElement(By.xpath(slide_xpath)).getAttribute("textContent");
			String expected_slide = i+"/"+n;
			softly.assertThat(actual_slide).as("test data").isEqualTo(expected_slide);
		    //Click on previous
			wait.until(ExpectedConditions.visibilityOfElementLocated(SlidePreviousButton)).click();
		}
	}
	
	public void searchWithPercentHuman(WebDriver driver, String keypercent, String identifier) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		Thread.sleep(3000);
		//Checks with new keyword with %
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanSearchKeywordField)).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanSearchKeywordField)).sendKeys(keypercent);
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanSearchKeywordFieldSearchButton)).click();
		//Wait for loading message to disappear
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+identifier)));
		Thread.sleep(2000);		  
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanSearchClearButton)).click();
	}
	
	public void searchWithSpclHuman(WebDriver driver, String keyspcl, String identifier) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		Thread.sleep(3000);
		//Checks with new keyword with %
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanSearchKeywordField)).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanSearchKeywordField)).sendKeys(keyspcl);
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanSearchKeywordFieldSearchButton)).click();
		//Wait for loading message to disappear
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+identifier)));
		Thread.sleep(2000);		  
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanSearchClearButton)).click();
	}
	
	public void verifySearchOptionsHuman (WebDriver driver, String keyword, String identifier) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		WebDriverWait wait1 = new WebDriverWait(driver,5);
		//Clears Everything
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanSearchClearButton)).click();
		Thread.sleep(2000);
		//Checks if clear feature works on term field
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanSearchKeywordField)).sendKeys(keyword);
		Thread.sleep(1000);
		Actions act1 = new Actions(driver);
		WebElement act= wait.until(ExpectedConditions.visibilityOfElementLocated(HumanSearchKeywordFieldClearButton));
		act1.click(act).build().perform();
		//Checks for search method with magnifying glass
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanSearchKeywordField)).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanSearchKeywordFieldSearchButton)).click();
		//Wait for loading message to disappear
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+identifier)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanSearchClearButton)).click();
		Thread.sleep(2000);
		//Look for dynamic dropdown
		try{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(HumanSearchDropDown));
			softly.fail("Dynamic dropdown visible after click on search button for keyword search");
		}catch (NoSuchElementException | org.openqa.selenium.TimeoutException e)
		{
			System.out.println("Dropdown not visible");				
		}
		//Enters the term and check the search by enter
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanSearchKeywordField)).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanSearchKeywordField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Look for dynamic dropdown
		try{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(HumanSearchDropDown));
			softly.fail("Dynamic dropdown visible after click on search button for keyword search");
		}catch (NoSuchElementException | org.openqa.selenium.TimeoutException e)
		{
			System.out.println("Dropdown not visible");				
		}
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+identifier)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanSearchClearButton)).click();
		Thread.sleep(2000);
		//Checks for search method with dropdown
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanSearchKeywordField)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanSearchKeywordField)).sendKeys(keyword);
		Thread.sleep(2000);
		clickDropdownHuman(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+identifier)));		
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanSearchClearButton)).click();
	}
	
	public void clickDropdownHuman(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		WebElement match=wait.until(ExpectedConditions.visibilityOfElementLocated(HumanDropDownList));
		String text = match.getText();
		System.out.println(text);
		if(text.equals("Exact Match Keywords"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(HumanDropDownListTitle)).click();				  
		}
		else if(text.equals("Similar Match Keywords"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(HumanDropDownListTitle)).click();
		}
		else if(text.equals("Other Match Keywords"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(HumanDropDownListTitle)).click();
		}
		//Wait for loading message to disappear
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);		
	}
	
	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}

}
