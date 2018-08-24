import java.awt.Robot;
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
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class EquipmentPDDandEF {

	SoftAssertions softly = new SoftAssertions();	
	String keywordPDD = "QAAPDDTestSlides";
	String keywordEF = "QAAEFTestSlides";
	String key1PDD = "QAAzebraPDD";
	String key2PDD = "QAAcamelPDD";
	String key3PDD = "QAAhorsePDD";
	String key1EF = "QAAzebraEF";
	String key2EF = "QAAcamelEF";
	String key3EF = "QAAhorseEF";
	String titlePDD = "QAA PDD Test Slides";
	String titleEF = "QAA EF Test Slides";
	String keywordPDDie11 = "QAAPDDTestSlidesie11";
	String keywordEFie11 = "QAAEFTestSlidesie11";
	String key1PDDie11 = "QAAzebraPDDie11";
	String key2PDDie11 = "QAAcamelPDDie11";
	String key3PDDie11 = "QAAhorsePDDie11";
	String key1EFie11 = "QAAzebraEFie11";
	String key2EFie11 = "QAAcamelEFie11";
	String key3EFie11 = "QAAhorseEFie11";
	String titlePDDie11 = "QAA IE11 PDD Test Slides";
	String titleEFie11 = "QAA IE11 EF Test Slides";
	String keywordPDDUS = "QAAUSPDDTestSlides";
	String keywordEFUS = "QAAUSEFTestSlides";
	String key1PDDUS = "QAAUSzebraPDD";
	String key2PDDUS = "QAAUScamelPDD";
	String key3PDDUS = "QAAUShorsePDD";
	String key1EFUS = "QAAUSzebraEF";
	String key2EFUS = "QAAUScamelEF";
	String key3EFUS = "QAAUShorseEF";
	String titlePDDUS = "QAA US PDD Test Slides";
	String titleEFUS = "QAA US EF Test Slides";
	String keywordPDDUSie11 = "QAAUSPDDTestSlidesie11";
	String keywordEFUSie11 = "QAAUSEFTestSlidesie11";
	String key1PDDUSie11 = "QAAUSzebraPDDie11";
	String key2PDDUSie11 = "QAAUScamelPDDie11";
	String key3PDDUSie11 = "QAAUShorsePDDie11";
	String key1EFUSie11 = "QAAUSzebraEFie11";
	String key2EFUSie11 = "QAAUScamelEFie11";
	String key3EFUSie11 = "QAAUShorseEFie11";
	String titlePDDUSie11 = "QAA US IE11 PDD Test Slides";
	String titleEFUSie11 = "QAA US IE11 EF Test Slides";
	String expected_copyright = "Copyright and Proprietary, Error-Free Inc. and Performance Improvement International LLC, 2018. Derivative Product Strictly Prohibited.";
	String keywordPDDDev ="SanityPDD";
	String keywordPDDDevPercent ="SanityPDD%";
	String keywordPDDDevSpcl ="SanityPDD./";
	String keywordEFDev ="SanityEF";
	String keywordEFDevPercent ="SanityEF%";
	String keywordEFDevSpcl ="SanityEF./";
	String keywordPDDProd = "packing friction force";
	String keywordPDDProdPercent = "90%";
	String keywordEFProd = "Ampere Electromagnetism Law";
	String keywordEFProdSpcl = "PM2.5 meter";
	String caseEFDev = "7450";
	String casePDDDev = "7890";
	String caseEFProd = "2014";
	String casePDDProd = "3005";
	String caseEFProdSpcl = "2017";
	String casePDDProdPercent = "3037";
	String titleEFDev = "Sanity: QAA Test (DO NOT DELETE)";
	String titlePDDDev = "Sanity: QAA Test (DO NOT DELETE)";
	String titleEFProd = "What is Faraday’s Law and Ampere’s Law?"+"\n";
	String titlePDDProd = "How do you reduce valve packing friction force?";

	public void searchCaseInFailureModes(WebDriver driver, String identifierEF, String identifierPDD, String keywordEF, String keywordPDD) throws Exception {

		//Verify PDD case
		searchCaseIdInFailureModes(driver, identifierPDD);
		searchCaseInFMWithKeyword(driver, keywordPDD, identifierPDD);
		//Verify EF case
		searchCaseIdInFailureModes(driver, identifierEF);
		searchCaseInFMWithKeyword(driver, keywordEF, identifierEF);
	}

	public void searchCasesInPDDAndEFModules(WebDriver driver, String identifierEF, String identifierPDD, String keywordEF, String keywordPDD)throws Exception {

		//Verify that PDD does not appear in EF
		searchCaseInEngineeringFundamentalsWithKeyword(driver, keywordPDD, identifierPDD);
		searchCaseIdInEngineeringFundamentals(driver, identifierPDD);
		//Verify that EF does not appear in PDD
		searchCaseInPreventionOfDesignDeficienciesWithKeyword(driver, keywordEF, identifierEF);
		searchCaseIdInPreventionOfDesignDeficiencies(driver, identifierEF);
	}

	public void searchCaseInPreventionOfDesignDeficienciesWithKeyword (WebDriver driver, String keyword, String identifier) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		ShareCheck obj = new ShareCheck();
		CaseBrowse obj1 = new CaseBrowse();
		CreateHumanCase obj2 = new CreateHumanCase ();
		CreateEquipmentCase obj3 = new CreateEquipmentCase();
		obj.loadingServer(driver);
		//Clicks on Error free bank
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.ErrorFreeBankTopLink)).click();
		}catch (UnhandledAlertException f){			  
			driver.switchTo().alert().dismiss();
		}
		//Clicks on Prevention of Design Deficiencies
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj3.PreventionOfDesignDeficienciesLink)).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Verifies no case appears
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
			softly.fail("Case found in Prevention of Design Deficiencies: "+identifier);
		}catch(org.openqa.selenium.TimeoutException r)
		{
			System.out.println("Case not found in Prevention of Design Deficiencies");
		}		
		try{
			//Verifies warning message
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(obj3.EquipSearchMessage)).getText();
			softly.assertThat(s).as("test data").contains("Warning: No Prevention of Design Deficiencies case found");	
			System.out.println(s);
			Thread.sleep(2000);	
			//Verify case in error link
			verifyErrorModuleLinkWithKeyword(driver, keyword, identifier);
		}catch(org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e)
		{
			System.out.println("warning message not found keyword exists in Prevention of Design Deficiencies: "+keyword);
		}
		//Clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
	}

	public void searchCaseIdInPreventionOfDesignDeficiencies(WebDriver driver, String identifier) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		ShareCheck obj = new ShareCheck();
		CaseBrowse obj1 = new CaseBrowse();
		CreateHumanCase obj2 = new CreateHumanCase ();
		CreateEquipmentCase obj3 = new CreateEquipmentCase();
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
		//Clicks on Error free bank
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.ErrorFreeBankTopLink)).click();
		}catch (UnhandledAlertException f){			  
			driver.switchTo().alert().dismiss();
		}
		//Clicks on Prevention Of Design Deficiencies
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj3.PreventionOfDesignDeficienciesLink)).click();
		//Clicks on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
		//Enters Equipment Case id to see if it exists
		driver.findElement(obj1.EquipmentSearchCaseIdField).sendKeys(identifier);
		driver.findElement(obj1.EquipmentSearchCaseIdField).sendKeys(Keys.ENTER);
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
		//Verifies no case appears
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
			softly.fail("Case found in Prevention of Design Deficiencies: "+identifier);
		}catch(org.openqa.selenium.TimeoutException r)
		{
			System.out.println("Case not found in Prevention of Design Deficiencies");
		}
		try{
			//Verifies warning message
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(obj3.EquipSearchMessage)).getText();
			softly.assertThat(s).as("test data").contains("Warning: No Prevention of Design Deficiencies case found");	
			System.out.println(s);
			//Verify case in link in error message
			verifyErrorModuleLinkWithCaseId(driver,identifier);
		}catch(org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e)
		{
			System.out.println("warning message not found case exists in Prevention of Design Deficiencies: "+identifier);
		}
		//Clicks on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
	}

	public void searchCaseInEngineeringFundamentalsWithKeyword (WebDriver driver, String keyword, String identifier) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		ShareCheck obj = new ShareCheck();
		CaseBrowse obj1 = new CaseBrowse();
		CreateHumanCase obj2 = new CreateHumanCase ();
		CreateEquipmentCase obj3 = new CreateEquipmentCase();
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Clicks on Error free bank
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.ErrorFreeBankTopLink)).click();
		}catch (UnhandledAlertException f){			  
			driver.switchTo().alert().dismiss();
		}
		//Clicks on Engineering Fundamentals
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj3.EngineeringFundamentalsLink)).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Verifies no case appears
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
			softly.fail("Case found in Engineering Fundamentals: "+identifier);
		}catch(org.openqa.selenium.TimeoutException r)
		{
			System.out.println("Case not found in Engineering Fundamentals");
		}	
		try{
			//Verifies warning message
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(obj3.EquipSearchMessage)).getText();
			softly.assertThat(s).as("test data").contains("Warning: No Engineering Fundamentals case found");	
			System.out.println(s);
			Thread.sleep(2000);	
			//Verify case in error link
			verifyErrorModuleLinkWithKeyword(driver, keyword, identifier);
		}catch(org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e)
		{
			System.out.println("warning message not found keyword exists in Engineering Fundamentals: "+keyword);
		}
		//Clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
	}

	public void searchCaseIdInEngineeringFundamentals(WebDriver driver, String identifier) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		ShareCheck obj = new ShareCheck();
		CaseBrowse obj1 = new CaseBrowse();
		CreateHumanCase obj2 = new CreateHumanCase ();
		CreateEquipmentCase obj3 = new CreateEquipmentCase();
		//Clicks on Error free bank
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.ErrorFreeBankTopLink)).click();
		}catch (UnhandledAlertException f){			  
			driver.switchTo().alert().dismiss();
		}
		//Clicks on Engineering Fundamentals
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj3.EngineeringFundamentalsLink)).click();
		//Clicks on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
		//Enters Equipment Case id to see if it exists
		driver.findElement(obj1.EquipmentSearchCaseIdField).sendKeys(identifier);
		driver.findElement(obj1.EquipmentSearchCaseIdField).sendKeys(Keys.ENTER);
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
		//Verifies no case appears
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
			softly.fail("Case found in Engineering Fundamentals: "+identifier);
		}catch(org.openqa.selenium.TimeoutException r)
		{
			System.out.println("Case not found in Engineering Fundamentals");
		}	
		try{
			//Verifies warning message
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(obj3.EquipSearchMessage)).getText();
			softly.assertThat(s).as("test data").contains("Warning: No Engineering Fundamentals case found");	
			System.out.println(s);
			//Verify case in link in error message
			verifyErrorModuleLinkWithCaseId(driver,identifier);
		}catch(org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e)
		{
			System.out.println("warning message not found case exists in Engineering Fundamentals: "+identifier);
		}
		//Clicks on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
	}

	public void searchCaseIdInFailureModes(WebDriver driver, String identifier) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		ShareCheck obj = new ShareCheck();
		CaseBrowse obj1 = new CaseBrowse();
		CreateHumanCase obj2 = new CreateHumanCase ();
		CreateEquipmentCase obj3 = new CreateEquipmentCase();
		//Verify that Failure mode cases do not appear in Engineering Fundamentals
		//Clicks on Error free bank
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.ErrorFreeBankTopLink)).click();
		}catch (UnhandledAlertException f){			  
			driver.switchTo().alert().dismiss();
		}
		//Clicks on Failure Modes
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.FailureModeLink)).click();
		//Clicks on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
		//Enters Equipment Case id to see if it exists
		driver.findElement(obj1.EquipmentSearchCaseIdField).sendKeys(identifier);
		driver.findElement(obj1.EquipmentSearchCaseIdField).sendKeys(Keys.ENTER);
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
		//Verifies no case appears
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
			softly.fail("Case found in Failure Modes: "+identifier);
		}catch(org.openqa.selenium.TimeoutException r)
		{
			System.out.println("Case not found in Failure Modes");
		}	
		try{
			//Verifies warning message
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(obj3.EquipSearchMessage)).getText();
			softly.assertThat(s).as("test data").contains("Warning: No Failure Modes case found");	
			System.out.println(s);
			//Verify case in link in error message
			verifyErrorModuleLinkWithCaseId(driver,identifier);
		}catch(org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e)
		{
			System.out.println("warning message not found case exists in Failure modes: "+identifier);
		}
		//Clicks on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
	}

	public void searchCaseInFMWithKeyword (WebDriver driver, String keyword, String identifier) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		ShareCheck obj = new ShareCheck();
		CaseBrowse obj1 = new CaseBrowse();
		CreateHumanCase obj2 = new CreateHumanCase ();
		CreateEquipmentCase obj3 = new CreateEquipmentCase();
		//Clicks on Error free bank
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.ErrorFreeBankTopLink)).click();
		}catch (UnhandledAlertException f){			  
			driver.switchTo().alert().dismiss();
		}
		//Clicks on Failure Modes
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.FailureModeLink)).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Verifies no case appears
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
			softly.fail("Case found in Failure Modes: "+identifier);
		}catch(org.openqa.selenium.TimeoutException r)
		{
			System.out.println("Case not found in Failure Modes");
		}	
		try{
			//Verifies warning message
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(obj3.EquipSearchMessage)).getText();
			softly.assertThat(s).as("test data").contains("Warning: No Failure Modes case found");	
			System.out.println(s);
			Thread.sleep(2000);	
			//Verify case in error link
			verifyErrorModuleLinkWithKeyword(driver, keyword, identifier);
		}catch(org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e)
		{
			System.out.println("warning message not found keyword exists in Failure modes: "+keyword);
		}
		//Clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
	}

	public void searchWithPercent(WebDriver driver, String keypercent, String identifier) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		CaseBrowse obj = new CaseBrowse();
		Thread.sleep(3000);
		//Checks with new keyword with %
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EquipmentSearchKeywordField)).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EquipmentSearchKeywordField)).sendKeys(keypercent);
		if(identifier.equals(casePDDProdPercent))
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		else
			clickDropdown(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
		Thread.sleep(2000);		  
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EquipmentSearchClearButton)).click();
	}

	public void searchCaseInEquipSearchByCaseID(WebDriver driver, String identifier) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		CreateHumanCase obj1 = new CreateHumanCase();
		ShareCheck obj = new ShareCheck();	
		CaseBrowse obj2 = new CaseBrowse();
		CreateEquipmentCase obj3 = new CreateEquipmentCase();
		//Clicks on ErrorFree Bank
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.ErrorFreeBankTopLink)).click();
		//Clicks on Equipment Performance
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.EquipmentPerformanceLink)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.EquipmentSearchCaseIdField)).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.EquipmentSearchCaseIdField)).sendKeys(identifier);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.EquipmentSearchCaseIdField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Verifies no case appears
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
			System.out.println("case found in url:" + driver.getCurrentUrl());
			if((driver.getCurrentUrl().contains("kaleasia")||driver.getCurrentUrl().contains("kale."))==false)
				softly.fail("Case found in Equipment Search: "+identifier);
		}catch(org.openqa.selenium.TimeoutException r)
		{
			System.out.println("Case not found in Equipment Search");
		}		
		Thread.sleep(2000);	
		try{
			//Verifies warning message
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(obj3.EquipSearchMessage)).getText();
			softly.assertThat(s).as("test data").contains("Warning: No Equipment Performance case found");	
			System.out.println(s);
			//Verify case in link in error message
			verifyErrorModuleLinkWithCaseId(driver,identifier);
		}catch(org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e)
		{
			System.out.println("warning message not found case exists in Equipment Performance: "+identifier);
		}
		//Clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.EquipmentSearchClearButton)).click();
	}

	public void verifyErrorModuleLinkWithCaseId(WebDriver driver, String identifier) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		ShareCheck obj = new ShareCheck();	
		CaseBrowse obj1 = new CaseBrowse();
		CreateEquipmentCase obj2 = new CreateEquipmentCase();
		//Click on link
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.EquipSearchMessageErrorLink)).click();
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
		//Search for case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchCaseIdField)).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchCaseIdField)).sendKeys(identifier);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchCaseIdField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Verify case appears
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
	}

	public void searchCaseInEquipSearchByKeyword(WebDriver driver, String keyword, String identifier) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		CreateHumanCase obj = new CreateHumanCase();
		ShareCheck obj1 = new ShareCheck();		
		CaseBrowse obj2 = new CaseBrowse();
		CreateEquipmentCase obj3 = new CreateEquipmentCase();
		//Clicks on ErrorFree Bank
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ErrorFreeBankTopLink)).click();
		//Clicks on Equipment Performance
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.EquipmentPerformanceLink)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.EquipmentSearchKeywordField)).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.EquipmentSearchKeywordField)).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		obj1.loadingServer(driver);
		//Verifies no case appears
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
			System.out.println("case found in url:" + driver.getCurrentUrl());
			if((driver.getCurrentUrl().contains("kaleasia")||driver.getCurrentUrl().contains("kale."))==false)
				softly.fail("Case found in Equipment Search: "+identifier);
		}catch(org.openqa.selenium.TimeoutException r)
		{
			System.out.println("Case not found in Equipment Search");
		}
		try{
			//Verifies warning message
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(obj3.EquipSearchMessage)).getText();
			softly.assertThat(s).as("test data").contains("Warning: No Equipment Performance case found");	
			System.out.println(s);
			Thread.sleep(2000);	
			//Verify case in error link
			verifyErrorModuleLinkWithKeyword(driver, keyword, identifier);
		}catch(org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e)
		{
			System.out.println("warning message not found keyword exists in Equipment Performance: "+keyword);
		}
		//Clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.EquipmentSearchClearButton)).click();
	}

	public void verifyErrorModuleLinkWithKeyword(WebDriver driver, String keyword, String identifier) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		ShareCheck obj = new ShareCheck();	
		CaseBrowse obj1 = new CaseBrowse();
		CreateEquipmentCase obj2 = new CreateEquipmentCase();
		//Click on link
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.EquipSearchMessageErrorLink)).click();
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
		//Search for case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Verify case appears
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
	}

	public void searchWithSpcl(WebDriver driver, String keyspcl, String identifier) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		ShareCheck obj = new ShareCheck();
		CaseBrowse obj1 = new CaseBrowse();
		Thread.sleep(3000);
		//Checks with new keyword with %
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(keyspcl);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);		
		obj.loadingServer(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
		Thread.sleep(2000);		  
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
	}

	public void verifySearchOptions (WebDriver driver, String keyword, String identifier) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		ShareCheck obj = new ShareCheck();
		CaseBrowse obj1 = new CaseBrowse();
		//Clears Everything
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
		Thread.sleep(2000);
		//Checks if clear feature works on term field
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(keyword);
		Thread.sleep(1000);
		WebElement act= wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordFieldClearButton));
		act.click();
		//Checks for search method with magnifying glass
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordFieldSearchButton)).click();
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
		Thread.sleep(2000);
		//Enters the term and check the search by enter
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
		Thread.sleep(2000);
		//Checks for search method with dropdown
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(keyword);
		Thread.sleep(2000);
		clickDropdown(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));		
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
	}

	public void clickDropdown(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		ShareCheck obj1 = new ShareCheck();
		CaseBrowse obj = new CaseBrowse ();
		WebElement match=wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EquipmentDropDownList));
		String text = match.getText();
		System.out.println(text);
		if(text.equals("Exact Match Keywords"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EquipmentDropDownListTitle)).click();				  
		}
		else if(text.equals("Similar Match Keywords"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EquipmentDropDownListTitle)).click();
		}
		else if(text.equals("Other Match Keywords"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EquipmentDropDownListTitle)).click();
		}
		//Wait for loading message to disappear
		obj1.loadingServer(driver);	
	}

	public void verifyCaseModuleNames (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		ShareCheck obj = new ShareCheck();
		CreateHumanCase obj1 = new CreateHumanCase();
		CaseBrowse obj2 = new CaseBrowse();
		CreateEquipmentCase  obj3 = new CreateEquipmentCase();
		obj.loadingServer(driver);
		//Clicks on ErrorFree Bank
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.ErrorFreeBankTopLink)).click();
		//Look for Human Performance
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.HumanPerformanceLink));
		//Look for Equipment Data Bank (Instructor Only)
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.EquipmentDatabankOnlyLink));
		//Look for Failure modes
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.FailureModeLink));
		//Look for Equipment Performance
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.EquipmentPerformanceLink));
		//Look for Engineering Fundamentals
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj3.EngineeringFundamentalsLink));
		//Look for Prevention of Design Deficiencies
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj3.PreventionOfDesignDeficienciesLink));	    
	}

	public void browseCaseID (WebDriver driver, String identifier, String title) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		ShareCheck obj = new ShareCheck();
		CaseBrowse obj1 = new CaseBrowse();
		//Checks if clear feature works on case id field
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchCaseIdField)).sendKeys(identifier);
		Thread.sleep(1000);
		WebElement ele= driver.findElement(obj1.EquipmentSearchCaseIDFieldClearButton);
		ele.click();
		//Checks for search method with magnifying glass
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchCaseIdField)).sendKeys(identifier);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchCaseIDFieldSearchButton)).click();
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
		Thread.sleep(2000);
		//Enters case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchCaseIdField)).sendKeys(identifier);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchCaseIdField)).sendKeys(Keys.ENTER);
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
		//Click Next
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.SlideNextButton)).click();
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
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.SlideNextButton)).click();
		}
		//Click previous button to browse through case
		previousBrowse(driver,n,expected_title,identifier);
		//Closes the slideshow
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+identifier+"']/a"))).click();
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
	}

	public void verifyNoCaseIDSearch (WebDriver driver) throws Exception {

		CaseBrowse obj = new CaseBrowse();
		//Searches for case id box
		try{
			WebElement caseSearch= driver.findElement(obj.EquipmentSearchCaseIdField);
			if (caseSearch.isDisplayed()==true)
				softly.fail("Case id search displayed");
			if(caseSearch.isDisplayed()==false)
				System.out.println("Case id search box not displayed");

		}catch(NoSuchElementException e)
		{
			System.out.println("Case id search box not present.");
		}
	}

	public void browseCaseNonAdmin(WebDriver driver, String keyword, String identifier, String title) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,20);
		CaseBrowse obj1 = new CaseBrowse();
		ShareCheck obj = new ShareCheck();
		//Types in the keyword to get slide
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).clear();
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(keyword);
		//Get name of current module
		String str = wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentModuleTitle)).getText();
		if(str.contains("equipment performance cases (PII)"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		}
		else{
			//Look for case by clicking on dropdown
			Thread.sleep(4000);
			WebElement match = null;
			try{
				match=driver.findElement(obj1.EquipmentDropDownList);
			}catch(NoSuchElementException r)
			{
				//Wait for a few seconds and then try again
				Thread.sleep(3000);
				//Types in the keyword to get slide
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).clear();
				Thread.sleep(4000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(keyword);
				Thread.sleep(3000);
				match=driver.findElement(obj1.EquipmentDropDownList);
			}
			String text = match.getText();
			System.out.println(text);
			if(text.equals("Exact Match Keywords"))
			{
				driver.findElement(obj1.EquipmentDropDownListTitle).click();				  
			}
			else if(text.equals("Similar Match Keywords"))
			{
				driver.findElement(obj1.EquipmentDropDownListTitle).click();
			}
			else if(text.equals("Other Match Keywords"))
			{
				driver.findElement(obj1.EquipmentDropDownListTitle).click();
			}
		}
		//Wait for loading message to disappear
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
		Thread.sleep(1000);
		String expected_title = "F"+identifier+": "+title;
		//Click Next
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.SlideNextButton)).click();
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
				Point coordinates = driver.findElement(obj1.SlideNextButton).getLocation();
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
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.SlideNextButton)).click();
		}
		if(keyword.equals(keywordPDDDev)||keyword.equals(keywordEFDev)||keyword.equals(keywordEFProd)||keyword.equals(keywordPDDProd))
		{
			//Click previous button to browse through case
			previousBrowse(driver,n,expected_title,identifier);
		}
		//Closes the slideshow
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+identifier+"']/a"))).click();
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
		//verify no case id box
		verifyNoCaseIDSearch (driver);
	}

	public void browseCase(WebDriver driver, String keyword, String identifier, String title) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,20);
		CaseBrowse obj1 = new CaseBrowse();
		ShareCheck obj = new ShareCheck();		
		//Types in the keyword to get slide
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).clear();
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(keyword);
		//Get name of current module
		String str = wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentModuleTitle)).getText();
		if(str.contains("equipment performance cases (PII)"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		}
		else{
			//Look for case by clicking on dropdown
			Thread.sleep(4000);
			WebElement match = null;
			try{
				match=driver.findElement(obj1.EquipmentDropDownList);
			}catch(NoSuchElementException r)
			{
				//Wait for a few seconds and then try again
				Thread.sleep(3000);
				//Types in the keyword to get slide
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).clear();
				Thread.sleep(4000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(keyword);
				Thread.sleep(3000);
				match=driver.findElement(obj1.EquipmentDropDownList);
			}
			String text = match.getText();
			System.out.println(text);
			if(text.equals("Exact Match Keywords"))
			{
				driver.findElement(obj1.EquipmentDropDownListTitle).click();				  
			}
			else if(text.equals("Similar Match Keywords"))
			{
				driver.findElement(obj1.EquipmentDropDownListTitle).click();
			}
			else if(text.equals("Other Match Keywords"))
			{
				driver.findElement(obj1.EquipmentDropDownListTitle).click();
			}
		}
		//Wait for loading message to disappear
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
		Thread.sleep(1000);
		String expected_title = "F"+identifier+": "+title;
		//Click Next
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.SlideNextButton)).click();
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
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.SlideNextButton)).click();
		}
		if(keyword.equals(keywordPDDDev)||keyword.equals(keywordEFDev)||keyword.equals(keywordEFProd)||keyword.equals(keywordPDDProd))
		{
			//Click previous button to browse through case
			previousBrowse(driver,n,expected_title,identifier);
		}
		//Closes the slideshow
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+identifier+"']/a"))).click();
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
	}

	public void previousBrowse(WebDriver driver, int n, String expected_title, String identifier) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		CaseBrowse obj = new CaseBrowse();
		//Click on previous
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.SlidePreviousButton)).click();
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
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj.SlidePreviousButton)).click();
		}
	}

	public void getEquipPerformancePIILink(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,40);
		CreateHumanCase obj = new CreateHumanCase();
		CaseBrowse obj1 = new CaseBrowse();
		CaseBrowse obj2 = new CaseBrowse ();
		ShareCheck obj3 = new ShareCheck();
		//Waits for black loading message to disappear
		obj3.loadingServer(driver);
		try{
			//Clicks on ErrorFree Bank
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ErrorFreeBankTopLink)).click();
		}catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.ErrorFreeBankLink)).click();
		}
		//Clicks on Equipment Performance Search PII
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentDatabankOnlyLink1)).click();
	}

	public void getPDDLink(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,40);
		CreateHumanCase obj = new CreateHumanCase();
		CreateEquipmentCase obj1 = new CreateEquipmentCase();
		CaseBrowse obj2 = new CaseBrowse ();
		ShareCheck obj3 = new ShareCheck();
		//Waits for black loading message to disappear
		obj3.loadingServer(driver);
		try{
			//Clicks on ErrorFree Bank
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ErrorFreeBankTopLink)).click();
		}catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.ErrorFreeBankLink)).click();
		}
		//Clicks on Prevention of Design Deficiencies
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.PreventionOfDesignDeficienciesLink)).click();
	}

	public void getEFLink(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,40);
		CreateHumanCase obj = new CreateHumanCase();
		CreateEquipmentCase obj1 = new CreateEquipmentCase();
		CaseBrowse obj2 = new CaseBrowse ();
		ShareCheck obj3 = new ShareCheck();
		//Waits for black loading message to disappear
		obj3.loadingServer(driver);
		try{
			//Clicks on ErrorFree Bank
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ErrorFreeBankTopLink)).click();
		}catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.ErrorFreeBankLink)).click();
		}
		//Clicks on Engineering Fundamentals
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EngineeringFundamentalsLink)).click();
	}

	public void selectTypeEFPDD(WebDriver driver, String keyword) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		CreateEquipmentCase obj1 = new CreateEquipmentCase();
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
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseTypes)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseTypes)).sendKeys(Keys.ENTER);
			}
			if (v.startsWith("11")==true)
			{
				//Type
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseTypes)).click();
			}
		}
		else{
			//Type
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseTypes)).click();
		}
		Thread.sleep(1000);
		//Waits for the page to load
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipListBoxTypes));
		if(keyword.equals(keywordEF)||keyword.equals(keywordEFie11)||keyword.equals(keywordEFUS)||keyword.equals(keywordEFUSie11))
		{
			if (browserName.contains("internet")==true)
			{
				obj1.clickTypesDisciplineIE(driver, obj1.EquipListTypesFundamentals);
			}
			else
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipListTypesFundamentals)).click();
		}
		if(keyword.equals(keywordPDD)||keyword.equals(keywordPDDie11)||keyword.equals(keywordPDDUS)||keyword.equals(keywordPDDUSie11))
		{
			if (browserName.contains("internet")==true)
			{
				obj1.clickTypesDisciplineIE(driver, obj1.EquipListTypesDesign);
			}
			else
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipListTypesDesign)).click();
		}
		try{
			driver.findElement(obj1.ListCrossSymbol).click();
		}catch (NoSuchElementException | ElementNotInteractableException e)
		{
			driver.findElement(obj1.EquipListBoxTypesCrossSymbol).click();
		}
	}

	public void selectDisciplineEFPDD(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		CreateEquipmentCase obj1 = new CreateEquipmentCase();
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		String v = cap.getVersion().toString();
		if (browserName.contains("internet")==true)
		{
			if (v.startsWith("10")==true)
			{
				//Discipline
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseDiscipline)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseDiscipline)).sendKeys(Keys.ENTER);
			}
			if (v.startsWith("11")==true)
			{
				//Discipline
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseDiscipline)).click();
			}
		}
		else{
			//Discipline
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseDiscipline)).click();
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipListBoxDiscipline));
		Thread.sleep(1000);
		//Waits for the page to load
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		if (browserName.contains("internet")==true)
		{
			obj1.clickTypesDisciplineIE(driver, obj1.EquipListDisciplineGeneral);
		}
		else
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipListDisciplineGeneral)).click();
		try{
			driver.findElement(obj1.ListCrossSymbol).click();
		}catch (NoSuchElementException | ElementNotInteractableException e)
		{
			driver.findElement(obj1.EquipListBoxDisciplineCrossSymbol).click();
		}
	}

	public List<String> createCaseChrome(WebDriver driver, String keyword_same, String key1, String key2, String key3, String title) throws Exception{

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebDriverWait wait = new WebDriverWait(driver,40);
		CreateEquipmentCase obj1 = new CreateEquipmentCase();
		ShareCheck obj = new ShareCheck();
		CreateHumanCase obj2 = new CreateHumanCase();
		Login obj3 = new Login ();
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj3.LoginNameOnTopRight)).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.AdminOption)).click();
		//Clicks on Errorfree bank option
		if (driver.findElement(obj1.EquipCasesLink).isDisplayed()==false)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.ErrorFreeBankLink)).click();
		}
		//Clicks on Equipment cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCasesLink)).click();
		//Pick a Random number for case id
		Random random = new Random();
		List<String> caseID = new ArrayList<String>();
		String caseId="";
		for(int count=1;count<=5;count++)
		{		
			//Wait for loading message to disappear
			obj.loadingServer(driver);
			//Clicks on new case button
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewButton)).click();
			//Clicks on new case
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCasePopupTitle)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCasePopupConfirmButton)).click();
			//Wait for loading message to disappear
			obj.loadingServer(driver);
			while (true)
			{
				Thread.sleep(1000);
				int y=random.nextInt(10000);
				if(y<1000)
					continue;
				caseId = String.format("%d", y);
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseIDField)).sendKeys(caseId);
				Thread.sleep(1000);
				Thread.sleep(1000);
				WebElement errorCaseId;
				try{
					errorCaseId=driver.findElement(obj1.EquipCaseIDFieldError);
				}catch(org.openqa.selenium.NoSuchElementException e)
				{
					break;
				}
				if(errorCaseId.isDisplayed()==true)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseIDField)).clear();
					continue;
				}
				if(errorCaseId.isDisplayed()==false)
					break;
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseIDField)).clear();
			}
			System.out.println("Case id: "+ caseId);
			//Add Case is to list
			caseID.add(caseId);
			//Select Type
			selectTypeEFPDD(driver,keyword_same);
			//Select Discipline
			selectDisciplineEFPDD(driver);
			//Select Fields
			obj1.selectFields(driver);
			//Enters Question
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseQuestion)).sendKeys(title);
			//Enters Answer
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseAnswer)).sendKeys(title);
			Thread.sleep(1000);
			jse.executeScript("scroll(0,1700)");
			Thread.sleep(1000);
			//Enters Keyword
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewKeywordField)).sendKeys(keyword_same);
			Thread.sleep(2000);
			if(count==1)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewKeywordAddButton)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewKeywordField)).clear();
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewKeywordField)).sendKeys(key1);
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewKeywordAddButton)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewKeywordField)).clear();
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewKeywordField)).sendKeys(key2);
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewKeywordAddButton)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewKeywordField)).clear();
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewKeywordField)).sendKeys(key3);
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewKeywordAddButton)).click();			  
			}
			else 
			{
				Thread.sleep(1000);
				jse.executeScript("scroll(0,1700)");
				Thread.sleep(1000);
				WebElement element = driver.findElement(obj1.EquipCaseKeywordExistingList);
				element.findElement(obj2.FirstAndLastChildInList).click();
			}
			Thread.sleep(2000);
			//Uploads 5 slides
			WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipImageCollapsible));
			obj.scrollToElement(driver, l);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipImageUploadField)).click();
			Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlides.exe");
			p.waitFor();
			Thread.sleep(3000);
			//Checks if 5 images have been uploaded
			if(driver.findElement(obj1.EquipImageCollapsibleExpanded).isDisplayed()==false)
			{
				l = wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipImageCollapsible));
				obj.scrollToElement(driver, l);
				l.click();
			}
			int i;
			for (i=0; i<5;i++)
			{
				String xpath = ".//*[@id='pii-admin-efse-upload-form-selectedfiles']/div["+(i+1)+"]";
				if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).isDisplayed())
				{
					System.out.println("Uploaded Image : " + (i+1));
					//list.add(driver.findElement(By.xpath(xpath)));
				}

			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipImageCollapsible)).click();
			obj.scrollToTop(driver);
			Thread.sleep(2000);
			//Clicks on save
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseSaveButton)).click();
			//Clicks on create case
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCasePopupTitle)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCasePopupConfirmButton)).click();
			//Wait for loading message to disappear
			obj.loadingServer(driver);
		}
		return caseID;
	}

	public List<String> createCaseFirefox(WebDriver driver, String keyword_same, String key1, String key2, String key3, String title) throws Exception{

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebDriverWait wait = new WebDriverWait(driver,40);
		CreateEquipmentCase obj1 = new CreateEquipmentCase();
		CreateHumanCase obj2 = new CreateHumanCase();
		Login obj3 = new Login ();
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj3.LoginNameOnTopRight)).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.AdminOption)).click();
		//Clicks on Errorfree bank option
		if (driver.findElement(obj1.EquipCasesLink).isDisplayed()==false)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.ErrorFreeBankLink)).click();
		}
		//Clicks on Equipment cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCasesLink)).click();
		//Wait for loading message to disappear
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);
		Thread.sleep(1000);
		obj.scrollToTop(driver);
		Thread.sleep(1000);
		Random random = new Random();
		String caseId="";
		List<String> caseID = new ArrayList<String>();
		for(int count=1;count<=5;count++)
		{	
			//Clicks on new case button
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewButton)).click();
			//Clicks on new case
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCasePopupTitle)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCasePopupConfirmButton)).click();
			//Pick a Random number for case id
			while (true)
			{
				Thread.sleep(1000);
				int y=random.nextInt(10000);
				if(y<1000)
					continue;
				caseId = String.format("%d", y);
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseIDField)).sendKeys(caseId);
				Thread.sleep(1000);
				Thread.sleep(1000);
				WebElement errorCaseId;
				try{
					errorCaseId=driver.findElement(obj1.EquipCaseIDFieldError);
				}catch(org.openqa.selenium.NoSuchElementException e)
				{
					break;
				}
				if(errorCaseId.isDisplayed()==true)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseIDField)).clear();
					continue;
				}
				if(errorCaseId.isDisplayed()==false)
					break;
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseIDField)).clear();
			}
			System.out.println("Case id: "+ caseId);
			//Add case to list
			caseID.add(caseId);
			//Select Type
			selectTypeEFPDD(driver,keyword_same);
			//Select Discipline
			selectDisciplineEFPDD(driver);
			//Select Fields
			obj1.selectFields(driver);
			//Enters Question
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseQuestion)).sendKeys(title);
			//Enters Answer
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseAnswer)).sendKeys(title);
			Thread.sleep(1000);
			jse.executeScript("scroll(0,1700)");
			Thread.sleep(1000);
			//Enters Keyword
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewKeywordField)).sendKeys(keyword_same);
			Thread.sleep(2000);
			if(count==1)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewKeywordAddButton)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewKeywordField)).clear();
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewKeywordField)).sendKeys(key1);
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewKeywordAddButton)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewKeywordField)).clear();
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewKeywordField)).sendKeys(key2);
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewKeywordAddButton)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewKeywordField)).clear();
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewKeywordField)).sendKeys(key3);
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewKeywordAddButton)).click();			  
			}
			else 
			{
				Thread.sleep(1000);
				jse.executeScript("scroll(0,1700)");
				Thread.sleep(1000);
				WebElement element = driver.findElement(obj1.EquipCaseKeywordExistingList);
				element.findElement(obj2.FirstAndLastChildInList).click();
			}
			Thread.sleep(2000);
			//Uploads 5 slides
			WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipImageCollapsible));
			obj.scrollToElement(driver, l);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipImageUploadField)).click();
			Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlides_Firefox.exe");
			p.waitFor();
			Thread.sleep(3000);
			//Checks if 5 images have been uploaded
			if(driver.findElement(obj1.EquipImageCollapsibleExpanded).isDisplayed()==false)
			{
				l = wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipImageCollapsible));
				obj.scrollToElement(driver, l);
				l.click();
			}
			int i;
			for (i=0; i<5;i++)
			{
				String xpath = ".//*[@id='pii-admin-efse-upload-form-selectedfiles']/div["+(i+1)+"]";
				if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).isDisplayed())
				{
					System.out.println("Uploaded Image : " + (i+1));
				}

			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipImageCollapsible)).click();
			obj.scrollToTop(driver);
			Thread.sleep(2000);
			//Clicks on save
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseSaveButton)).click();
			//Clicks on create case
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCasePopupTitle)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCasePopupConfirmButton)).click();
			//Wait for loading message to disappear
			obj.loadingServer(driver);
		}
		return caseID;
	}

	public List<String> createCaseIE10(WebDriver driver, String keyword_same, String key1, String key2, String key3, String title) throws Exception{

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebDriverWait wait = new WebDriverWait(driver,40);
		CreateEquipmentCase obj1 = new CreateEquipmentCase();
		ShareCheck obj = new ShareCheck();		
		CreateHumanCase obj2 = new CreateHumanCase();
		Login obj3 = new Login ();
		List<String> caseID = new ArrayList<String>();
		for(int count=1;count<=5;count++)
		{			
			//Clicks on admin user name on top right corner
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj3.LoginNameOnTopRight)).click();
			//Clicks on admin option
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.AdminOption)).click();
			//Clicks on Errorfree bank option
			if (driver.findElement(obj1.EquipCasesLink).isDisplayed()==false)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.ErrorFreeBankLink)).click();
			}
			//Clicks on Equipment cases
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCasesLink)).click();
			//Wait for loading message to disappear
			obj.loadingServer(driver);
			Thread.sleep(1000);
			obj.scrollToTop(driver);
			Thread.sleep(1000);
			//Clicks on new case button
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewButton)).click();
			//Clicks on new case
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCasePopupTitle)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCasePopupConfirmButton)).click();
			//Pick a Random number for case id
			Random random = new Random();
			String caseId="";
			while (true)
			{
				Thread.sleep(1000);
				int y=random.nextInt(10000);
				if(y<1000)
					continue;
				caseId = String.format("%d", y);
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseIDField)).sendKeys(caseId);
				Thread.sleep(1000);
				Thread.sleep(1000);
				WebElement errorCaseId;
				try{
					errorCaseId=driver.findElement(obj1.EquipCaseIDFieldError);
				}catch(org.openqa.selenium.NoSuchElementException e)
				{
					break;
				}
				if(errorCaseId.isDisplayed()==true)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseIDField)).clear();
					continue;
				}
				if(errorCaseId.isDisplayed()==false)
					break;
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseIDField)).clear();
			}
			System.out.println("Case id: "+ caseId);
			//Add case to list
			caseID.add(caseId);
			//Select Type
			selectTypeEFPDD(driver,keyword_same);
			//Select Discipline
			selectDisciplineEFPDD(driver);
			//Select Fields
			obj1.selectFields(driver);
			//Enters Question
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseQuestion)).sendKeys(title);
			//Enters Answer
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseAnswer)).sendKeys(title);
			Thread.sleep(1000);
			try{
				jse.executeScript("scroll(0,1700)");
			}catch(org.openqa.selenium.ScriptTimeoutException r)
			{
				Thread.sleep(3000);
				jse.executeScript("scroll(0,1700)");
			}
			Thread.sleep(1000);
			//Enters Keyword
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewKeywordField)).sendKeys(keyword_same);
			Thread.sleep(2000);
			if(count==1)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewKeywordAddButton)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewKeywordField)).clear();
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewKeywordField)).sendKeys(key1);
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewKeywordAddButton)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewKeywordField)).clear();
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewKeywordField)).sendKeys(key2);
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewKeywordAddButton)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewKeywordField)).clear();
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewKeywordField)).sendKeys(key3);
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewKeywordAddButton)).click();			  
			}
			else 
			{
				Thread.sleep(1000);
				try{
					jse.executeScript("scroll(0,1700)");
				}catch(org.openqa.selenium.ScriptTimeoutException r)
				{
					Thread.sleep(3000);
					jse.executeScript("scroll(0,1700)");
				}
				Thread.sleep(1000);
				WebElement element = driver.findElement(obj1.EquipCaseKeywordExistingList);
				element.findElement(obj2.FirstAndLastChildInList).click();
			}
			Thread.sleep(2000);
			//Uploads 5 slides
			WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipImageCollapsible));
			obj.scrollToElement(driver, l);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipImageUploadField));
			try{
			jse.executeScript("return document.getElementById('pii-admin-efse-upload-file-input').click();");
			}catch(org.openqa.selenium.ScriptTimeoutException r)
			{
				Thread.sleep(2000);
				jse.executeScript("return document.getElementById('pii-admin-efse-upload-file-input').click();");
				Thread.sleep(2000);
			}
			Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlides_IE10.exe");
			p.waitFor();
			Thread.sleep(4000);
			//Checks if 5 images have been uploaded
			if(driver.findElement(obj1.EquipImageCollapsibleExpanded).isDisplayed()==false)
			{
				l = wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipImageCollapsible));
				obj.scrollToElement(driver, l);
				l.click();
			}
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
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipImageCollapsible)).click();
			obj.scrollToTop(driver);
			Thread.sleep(2000);
			//Clicks on save
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseSaveButton)).click();
			//Clicks on create case
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCasePopupTitle)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCasePopupConfirmButton)).click();
			//Wait for loading message to disappear
			obj.loadingServer(driver);
		}
		return caseID;
	}

	public List<String> createCaseIE11(WebDriver driver, String keyword_same, String key1, String key2, String key3, String title) throws Exception{

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		CreateEquipmentCase obj1 = new CreateEquipmentCase();
		WebDriverWait wait = new WebDriverWait(driver,40);
		ShareCheck obj = new ShareCheck();		
		CreateHumanCase obj2 = new CreateHumanCase();
		Login obj3 = new Login ();
		List<String> caseID = new ArrayList<String>();
		for(int count=1;count<=5;count++)
		{
			//Wait for loading message to disappear
			obj.loadingServer(driver);
			if(driver.getCurrentUrl().contains("kale.")||driver.getCurrentUrl().contains("kaleasia"))
				obj.loadingServer(driver);
			while(true)
			{
				try{
					if (driver.findElement(obj3.StickyNote).isDisplayed())
					{
						Thread.sleep(2000);
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
				//Clicks on admin user name on top right corner
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj3.LoginNameOnTopRight)).click();
				try{
					//Clicks on admin option
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.AdminOption)).click();
					break;
				}catch(org.openqa.selenium.TimeoutException|org.openqa.selenium.NoSuchElementException t)
				{
					continue;
				}
			}
			//Clicks on Errorfree bank option
			if (driver.findElement(obj1.EquipCasesLink).isDisplayed()==false)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.ErrorFreeBankLink)).click();
			}
			//Clicks on Equipment cases
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCasesLink)).click();
			//Wait for loading message to disappear
			obj.loadingServer(driver);
			Thread.sleep(1000);
			obj.scrollToTop(driver);
			Thread.sleep(1000);
			//Clicks on new case button
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewButton)).click();
			//Clicks on new case
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCasePopupTitle)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCasePopupConfirmButton)).click();
			//Pick a Random number for case id
			Random random = new Random();
			String caseId="";
			while (true)
			{
				Thread.sleep(1000);
				int y=random.nextInt(10000);
				if(y<1000)
					continue;
				caseId = String.format("%d", y);
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseIDField)).sendKeys(caseId);
				Thread.sleep(1000);
				Thread.sleep(1000);
				WebElement errorCaseId;
				try{
					errorCaseId=driver.findElement(obj1.EquipCaseIDFieldError);
				}catch(org.openqa.selenium.NoSuchElementException e)
				{
					break;
				}
				if(errorCaseId.isDisplayed()==true)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseIDField)).clear();
					continue;
				}
				if(errorCaseId.isDisplayed()==false)
					break;
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseIDField)).clear();
			}
			System.out.println("Case id: "+ caseId);
			//Add case to list
			caseID.add(caseId);
			//Select Type
			selectTypeEFPDD(driver,keyword_same);
			//Select Discipline
			selectDisciplineEFPDD(driver);
			//Select Fields
			obj1.selectFields(driver);
			//Enters Question
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseQuestion)).sendKeys(title);
			//Enters Answer
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseAnswer)).sendKeys(title);
			Thread.sleep(1000);
			jse.executeScript("scroll(0,1700)");
			Thread.sleep(1000);
			//Enters Keyword
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewKeywordField)).sendKeys(keyword_same);
			Thread.sleep(2000);
			if(count==1)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewKeywordAddButton)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewKeywordField)).clear();
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewKeywordField)).sendKeys(key1);
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewKeywordAddButton)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewKeywordField)).clear();
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewKeywordField)).sendKeys(key2);
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewKeywordAddButton)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewKeywordField)).clear();
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewKeywordField)).sendKeys(key3);
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCaseNewKeywordAddButton)).click();			  
			}
			else 
			{
				Thread.sleep(1000);
				jse.executeScript("scroll(0,1700)");
				Thread.sleep(1000);
				WebElement element = driver.findElement(obj1.EquipCaseKeywordExistingList);
				element.findElement(obj2.FirstAndLastChildInList).click();
			}
			Thread.sleep(2000);
			//Uploads 5 slides
			WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipImageCollapsible));
			obj.scrollToElement(driver, l);
			jse.executeScript("return document.getElementById('pii-admin-efse-upload-file-input').click();");
			Process p =Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/UploadHumanCaseSlides_IE10.exe");
			p.waitFor();
			Thread.sleep(4000);
			//Checks if 5 images have been uploaded
			if(driver.findElement(obj1.EquipImageCollapsibleExpanded).isDisplayed()==false)
			{
				l = wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipImageCollapsible));
				obj.scrollToElement(driver, l);
				l.click();
			}
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
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipImageCollapsible)).click();
			obj.scrollToTop(driver);
			Thread.sleep(2000);
			//Clicks on save
			jse.executeScript("return document.getElementById('pii-admin-efse-button-save').click();");
			//Clicks on create case
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCasePopupTitle));
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipCasePopupConfirmButton)).click();
			//Wait for loading message to disappear
			obj.loadingServer(driver);
			//Wait again for ie11
			obj.loadingServer(driver);
		}
		return caseID;
	}

	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}
}
