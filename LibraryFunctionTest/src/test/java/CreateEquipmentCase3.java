import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CreateEquipmentCase3 {

	CreateEquipPageObj equipObj = new CreateEquipPageObj();
	LoginPageObj lpo = new LoginPageObj();
	ShareCheck2 share2 = new ShareCheck2();
	
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
		//Waits for the popup
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListBoxFields));	
		//Click on field
		wait.until(ExpectedConditions.visibilityOfElementLocated(element)).click();		
		//Close pop up
		try{
			driver.findElement(equipObj.ListCrossSymbol).click();
		}catch (NoSuchElementException | ElementNotInteractableException e)
		{
			driver.findElement(equipObj.EquipListBoxFieldsCrossSymbol).click();
		}
	}
	
	public void selectDisciplineForComboTest(WebDriver driver, By element, String browserName, String v) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
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
		//Waits for the page to load
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListBoxDiscipline));
		if (browserName.contains("internet")==true)
			clickTypesDisciplineIE(driver, element);
		else
			wait.until(ExpectedConditions.visibilityOfElementLocated(element)).click();
		//Close pop up
		try{
			driver.findElement(equipObj.ListCrossSymbol).click();
		}catch (NoSuchElementException | ElementNotInteractableException e)
		{
			driver.findElement(equipObj.EquipListBoxDisciplineCrossSymbol).click();
		}
	}

	public void addKeywordEquip(WebDriver driver, String caseID, String keyword_same)throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		ShareCheck obj = new ShareCheck();
		CreateHumanCase obj3 = new CreateHumanCase();
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.LoginNameOnTopRight)).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj3.AdminOption)).click();
		Thread.sleep(1000);
		//Clicks on Errorfree bank option
		if (driver.findElement(equipObj.EquipCasesLink).isDisplayed()==false)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj3.ErrorFreeBankLink)).click();
		}
		//Clicks on Equipment cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(1000);
		obj.scrollToTop(driver);
		Thread.sleep(1000);
		//CLick on enter case id
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSearchCaseIDAdmin)).sendKeys(caseID);
		}catch(org.openqa.selenium.WebDriverException t)
		{
			Thread.sleep(1000);
			obj.scrollToTop(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSearchCaseIDAdmin)).sendKeys(caseID);
		}
		Thread.sleep(2000);
		//Clicks on case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSearchCaseIDDropdownAdmin)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(1000);
		obj.scrollToTop(driver);
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
		Thread.sleep(3000);
		//Add new keyword
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).clear();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(keyword_same);
		share2.loadingServer(driver);
		obj.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
		Thread.sleep(1000);
		obj.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSaveButton)).click();
		//Clicks on create case
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupConfirmButton)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
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

}
