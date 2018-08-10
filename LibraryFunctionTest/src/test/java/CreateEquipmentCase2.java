import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CreateEquipmentCase2 {
	
	public void decideEquipmentModule(WebDriver driver, int x) throws Exception {
	    
		WebDriverWait wait = new WebDriverWait(driver,10);
		CaseBrowse obj = new CaseBrowse();
		CreateEquipmentCase obj1 = new CreateEquipmentCase ();
		if((x == 1)||(x==2)||(x==6))
		{
			//click on Equipment performance
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EquipmentPerformanceLink)).click();
			//Clicks on clear
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EquipmentSearchClearButton)).click();
			//Select Type
			selectTypeAsPerX(driver,x);
		}
		if(x==3)
		{
			//Click on Prevention of Design Deficiencies
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.PreventionOfDesignDeficienciesLink)).click();
			//Clicks on clear
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EquipmentSearchClearButton)).click();
		}
		if(x==4)
		{
			//Click on Failure mode
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj.FailureModeLink)).click();
			//Clicks on clear
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EquipmentSearchClearButton)).click();
		}
		if(x==5)
		{
			//Click on Engineering Fundamentals
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EngineeringFundamentalsLink)).click();
			//Clicks on clear
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EquipmentSearchClearButton)).click();
		}
	}
	
	public int selectNumberForType(WebDriver driver) throws Exception {
		
		//Choose a number between 
		Random random = new Random ();
		int x;
		//Choose a number between 1 and 6
		while(true)
		{
			x = random.nextInt(7);
			if(x==0)
				continue;
			break;
		}
		return x;
	}
	
	
	public void selectTypeRandom (WebDriver driver, int x, String browserName, String v) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		CreateEquipmentCase obj = new CreateEquipmentCase();
	    if (browserName.contains("internet")==true)
	    {
	    	if (v.startsWith("10")==true)
	    	{
	    		//Type
	    		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EquipCaseTypes)).click();
	    		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EquipCaseTypes)).sendKeys(Keys.ENTER);	    		
	    	}
	    	if (v.startsWith("11")==true)
	    	{
	    		//Type
	    		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EquipCaseTypes)).click();
	    	}
	    }
	    else{
	    	//Type
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EquipCaseTypes)).click();
	    }
	    Thread.sleep(1000);
	    //Waits for popup
	    wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EquipListBoxTypes));
	    //Click type random
	    if(x==1)
		{
			if (browserName.contains("internet"))
			{
				obj.clickTypesDisciplineIE(driver, obj.EquipListTypesAdvancedLearning);
			}
			else
			   	wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EquipListTypesAdvancedLearning)).click();
		}
		if(x==2)
		{
			if (browserName.contains("internet"))
			{
			  	obj.clickTypesDisciplineIE(driver, obj.EquipListTypesCaseStudies);
			}
			else
			  	wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EquipListTypesCaseStudies)).click();
		}
		if(x==3)
		{
			if (browserName.contains("internet"))
			{
				obj.clickTypesDisciplineIE(driver, obj.EquipListTypesDesign);
			}
			else
			   	wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EquipListTypesDesign)).click();
		}
		if(x==4)
		{
			if (browserName.contains("internet"))
			{
				obj.clickTypesDisciplineIE(driver, obj.EquipListTypesFailureModes);
			}
			else
			   	wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EquipListTypesFailureModes)).click();
		}
		if(x==5)
		{
			if (browserName.contains("internet"))
			{
				obj.clickTypesDisciplineIE(driver, obj.EquipListTypesFundamentals);
			}
			else
			   	wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EquipListTypesFundamentals)).click();
		}
		if(x==6)
		{
		    if (browserName.contains("internet"))
			    {
		    	obj.clickTypesDisciplineIE(driver, obj.EquipListTypesGeneral);
			    }
			else
			   	wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EquipListTypesGeneral)).click();
		}		
	    try{
	    	driver.findElement(obj.ListCrossSymbol).click();
	    }catch (NoSuchElementException | ElementNotInteractableException e)
		  {
		     driver.findElement(obj.EquipListBoxTypesCrossSymbol).click();
		  }
	    System.out.println("Selected type: "+x);	
	}
	
	public void caseSearchWithDisciplineFieldComboEquipmentDatabank(WebDriver driver, int x, String keyword, List<String> electrical, List<String> general, List<String> ic, List<String> mechanical, List<String> software, List<String> structural) throws Exception {
	    
		WebDriverWait wait = new WebDriverWait(driver,10);
		ShareCheck obj = new ShareCheck();
		CaseBrowse obj1 = new CaseBrowse();
		CreateHumanCase obj2 = new CreateHumanCase ();
		CreateEquipmentCase obj3 = new CreateEquipmentCase();
		//Go to Failure mode
		//Clicks on Error free bank
		try
		{
		  wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.ErrorFreeBankTopLink)).click();
		}catch (UnhandledAlertException f){			  
		  driver.switchTo().alert().dismiss();
		}
		//Clicks on Equipment Databank (Instructor only)
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentDatabankOnlyLink1)).click();
		//Clicks on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
		//Search for keyword
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Wait for loading message
		obj.loadingServer(driver);
		//Look for all cases without filter
		obj3.lookForCases(driver, electrical);
		obj3.lookForCases(driver, general);
		obj3.lookForCases(driver, ic);
		obj3.lookForCases(driver, mechanical);
		obj3.lookForCases(driver, software);
		obj3.lookForCases(driver, structural);
		//Look for case with filter
		//Create a list with discipline filters for case search
		List<By> discList = obj3.disciplineCaseSearchList();
		//Create a list with field filters for case search
		List<By> fieldList = obj3.fieldCaseSearchList();
		//Search and verify case with filter
		for(int i=0;i<discList.size();i++)
		{
			//Clicks on clear
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
			//Select Type
			selectTypeAsPerX(driver, x);
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
	
	public void selectTypeAsPerX(WebDriver driver, int x) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		CaseBrowse obj = new CaseBrowse();
		//Click on type box
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.CaseSearchTypeBox)).click();
		//Wait for popup
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.CaseSearchTypeList));
		//Click on type
		if(x==1)
		{
			//Click on Advanced Learning 
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EquipCaseSearchListTypesAdvancedLearning)).click();
		}
		if(x==2)
		{
			//Click on Case Studies
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EquipCaseSearchListTypesCaseStudies)).click();
		}
		if(x==3)
		{
			//Click on Design
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EquipCaseSearchListTypesDesign)).click();
		}
		if(x==4)
		{
			//Click on Failure mode
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EquipCaseSearchListTypesFailureMode)).click();
		}
		if(x==5)
		{
			//Click on Fundamentals
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EquipCaseSearchListTypesFundamentals)).click();
		}
		if(x==6)
		{
			//Click on General
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EquipCaseSearchListTypesGeneral)).click();
		}	
		//Close pop up
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.CaseSearchTypesPopupClose)).click();
	}
	
	public void selectTypeAdvancedLearning(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		CaseBrowse obj = new CaseBrowse();
		//Click on type box
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.CaseSearchTypeBox)).click();
		//Wait for popup
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.CaseSearchTypeList));
		//Click on type
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EquipCaseSearchListTypesAdvancedLearning)).click();
		//Close pop up
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.CaseSearchTypesPopupClose)).click();
	}
	
	public void selectTypeGeneral(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		CaseBrowse obj = new CaseBrowse();
		//Click on type box
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.CaseSearchTypeBox)).click();
		//Wait for popup
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.CaseSearchTypeList));
		//Click on type
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EquipCaseSearchListTypesGeneral)).click();
		//Close pop up
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.CaseSearchTypesPopupClose)).click();
	}
	
	public void selectTypeFailureMode(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		CaseBrowse obj = new CaseBrowse();
		//Click on type box
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.CaseSearchTypeBox)).click();
		//Wait for popup
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.CaseSearchTypeList));
		//Click on type
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EquipCaseSearchListTypesFailureMode)).click();
		//Close pop up
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.CaseSearchTypesPopupClose)).click();
	}
	
	public void selectTypeCaseStudies(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		CaseBrowse obj = new CaseBrowse();
		//Click on type box
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.CaseSearchTypeBox)).click();
		//Wait for popup
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.CaseSearchTypeList));
		//Click on type
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EquipCaseSearchListTypesCaseStudies)).click();
		//Close pop up
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.CaseSearchTypesPopupClose)).click();
	}
	
	public void selectTypeDesign(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		CaseBrowse obj = new CaseBrowse();
		//Click on type box
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.CaseSearchTypeBox)).click();
		//Wait for popup
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.CaseSearchTypeList));
		//Click on type
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EquipCaseSearchListTypesDesign)).click();
		//Close pop up
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.CaseSearchTypesPopupClose)).click();
	}
	
	public void selectTypeFundamentals(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		CaseBrowse obj = new CaseBrowse();
		//Click on type box
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.CaseSearchTypeBox)).click();
		//Wait for popup
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.CaseSearchTypeList));
		//Click on type
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EquipCaseSearchListTypesFundamentals)).click();
		//Close pop up
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.CaseSearchTypesPopupClose)).click();
	}
	
	public void selectFieldDiscFilter (WebDriver driver, int x, int i, List<By> discList, List<By> fieldList, String keyword, List<String> electrical, List<String> general, List<String> ic, List<String> mechanical, List<String> software, List<String> structural) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		ShareCheck obj = new ShareCheck();
		CaseBrowse obj1 = new CaseBrowse();
		for(int j=0;j<fieldList.size();j++)
		{
			//Clicks on clear
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
			//Select Type
			selectTypeAsPerX(driver,x);
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
		CreateEquipmentCase obj = new CreateEquipmentCase();
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
		obj.lookForCases(driver, cases);
	}

}
