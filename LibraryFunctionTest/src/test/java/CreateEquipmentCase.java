import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
	By EquipCaseCategory = By.id("pii-admin-efse-level");
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
	
	public List<String> selectCategories (WebDriver driver) throws Exception {
		
		//Category
		WebElement dropdown = driver.findElement(EquipCaseCategory);
		Select s = new Select (dropdown);
		//Choose a number between 1 and 11 for number of categories
		Random random = new Random ();
		List<String> categories = new ArrayList<String> ();
		int y;
		while(true)
		{
			y = random.nextInt(12);
			if(y==0)
				continue;
			break;
		}
		//Select the categories
		for(int i=1;i<=y;i++)
		{
			int x;
			//Choose a number between 1 and 11
			while(true)
			{
				x = random.nextInt(12);
				if(x==0)
					continue;
				break;
			}
			if(x==1)
			{
				if(categories.contains("General")==false)
				{
					s.selectByVisibleText("General");
					categories.add("General");
				}
			}
			if(x==2)
			{
				if(categories.contains("Failure Mode")==false)
				{
					s.selectByVisibleText("Failure Mode");
					categories.add("Failure Mode");
				}
			}
			if(x==3)
			{
				if(categories.contains("I&C Case Study")==false)
				{
					s.selectByVisibleText("I&C Case Study");
					categories.add("I&C Case Study");
				}
			}
			if(x==4)
			{
				if(categories.contains("Electrical Case Study")==false)
				{
					s.selectByVisibleText("Electrical Case Study");
					categories.add("Electrical Case Study");
				}
			}
			if(x==5)
			{
				if(categories.contains("Software Case Study")==false)
				{
					s.selectByVisibleText("Software Case Study");
					categories.add("Software Case Study");
				}
			}
			if(x==6)
			{
				if(categories.contains("Structural Case Study")==false)
				{
					s.selectByVisibleText("Structural Case Study");
					categories.add("Structural Case Study");
				}
			}
			if(x==7)
			{
				if(categories.contains("Mechanical Case Study")==false)
				{
					s.selectByVisibleText("Mechanical Case Study");
					categories.add("Mechanical Case Study");
				}
			}
			if(x==8)
			{
				if(categories.contains("Electrical Failure Mode")==false)
				{
					s.selectByVisibleText("Electrical Failure Mode");
					categories.add("Electrical Failure Mode");
				}
			}
			if(x==9)
			{
				if(categories.contains("Mechanical Failure Mode")==false)
				{
					s.selectByVisibleText("Mechanical Failure Mode");
					categories.add("Mechanical Failure Mode");
				}
			}
			if(x==10)
			{
				if(categories.contains("Prevention of Design Deficiencies")==false)
				{
					s.selectByVisibleText("Prevention of Design Deficiencies");
					categories.add("Prevention of Design Deficiencies");
				}
			}
			if(x==11)
			{
				if(categories.contains("Engineering Fundamentals")==false)
				{
					s.selectByVisibleText("Engineering Fundamentals");
					categories.add("Engineering Fundamentals");
				}
			}
		}
		return categories;
	}
	
	public void searchCaseWithMultipleCategories(WebDriver driver, List<String> categories, String caseId) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		CaseBrowse obj1 = new CaseBrowse();
		ShareCheck obj = new ShareCheck();
		CreateHumanCase obj2 = new CreateHumanCase ();
		Thread.sleep(1000);
		if (categories.contains("Failure Mode")||categories.contains("General")||categories.contains("I&C Case Study")||categories.contains("Electrical Case Study")||categories.contains("Software Case Study")||categories.contains("Structural Case Study")||categories.contains("Mechanical Case Study"))
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
		if (categories.contains("Electrical Failure Mode"))
		{
			//Clicks on Error free bank
			WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.ErrorFreeBankTopLink));
			Actions act = new Actions(driver);
			act.click(element1).build().perform();
			//Go to Electrical FM
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.ElectricalFailureModeLink)).click();
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
		if (categories.contains("Mechanical Failure Mode"))
		{
			//Clicks on Error free bank
			WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.ErrorFreeBankTopLink));
			Actions act = new Actions(driver);
			act.click(element1).build().perform();
			//Go to Mechanical FM
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.MechanicalFailureModeLink)).click();
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
		if (categories.contains("Prevention of Design Deficiencies"))
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
		if (categories.contains("Engineering Fundamentals"))
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
		  //Enters mandatory data
		  //Enters case id
		  Random random = new Random();
		  List<String> caseID = new ArrayList<String>();
		  String caseId = "";
		  for(int count=1;count<=5;count++)
		  {
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
		  //Selects Category
		  if (count ==5)
		  {
			  if(title.equals(eq_title)||title.equals(eq_titleUS)||title.equals(eq_titleie11US))
			  {
				  //Select multiple categories randomly
				  categories.addAll(selectCategories(driver));
			  }
		  }
		  if(count<5){
		  if(title.equals(eq_title)||title.equals(eq_titleUS)||title.equals(eq_titleie11US))
		  {
			  WebElement dropdown = driver.findElement(EquipCaseCategory);
			  Select s = new Select (dropdown);
			  if(count==1)
				  s.selectByVisibleText("General");
			  if(count==2)
				  s.selectByVisibleText("Mechanical Case Study");
			  if(count==3)
				  s.selectByVisibleText("I&C Case Study");
			  if(count==4)
				  s.selectByVisibleText("Electrical Case Study");
			  if(count==5)
				  s.selectByVisibleText("Software Case Study");
		  }}
		  if(title.equals(ee_title)||title.equals(ee_titleUS)||title.equals(ee_titleie11US))
		  {
			  WebElement dropdown = driver.findElement(EquipCaseCategory);
			  Select s = new Select (dropdown);
			  s.selectByVisibleText("Electrical Failure Mode");
		  }
		  if(title.equals(me_title)||title.equals(me_titleUS)||title.equals(me_titleie11US))
		  {
			  WebElement dropdown = driver.findElement(EquipCaseCategory);
			  Select s = new Select (dropdown);
			  s.selectByVisibleText("Mechanical Failure Mode");
		  }
		  //Enters Question
		  wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseQuestion)).sendKeys(title);
		  //Enters Answer
		  wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseAnswer)).sendKeys(title);
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,1700)");
		  Thread.sleep(1000);
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
		  }
		 
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(1000);
		  //Uploads 5 slides
		  wait.until(ExpectedConditions.visibilityOfElementLocated(EquipImageUploadField)).click();
		  Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlides.exe");
		  p.waitFor();
		  Thread.sleep(3000);
		  //Checks if 5 images have been uploaded
		  if(driver.findElement(EquipImageCollapsibleExpanded).isDisplayed()==false)
		  {
			  wait.until(ExpectedConditions.visibilityOfElementLocated(EquipImageCollapsible)).click();
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
		  //Enters mandatory data
		  //Enters case id
		  Random random = new Random();
		  List<String> caseID = new ArrayList<String>();
		  String caseId = "";
		  for(int count=1;count<=5;count++)
		  {
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
		  //Selects Category
		  if (count ==5)
		  {
			  if(title.equals(eq_title)||title.equals(eq_titleUS)||title.equals(eq_titleie11US))
			  {
				  //Select multiple categories randomly
				  categories.addAll(selectCategories(driver));
			  }
		  }
		  if(count<5){
		  if(title.equals(eq_title)||title.equals(eq_titleUS)||title.equals(eq_titleie11US))
		  {
			  WebElement dropdown = driver.findElement(EquipCaseCategory);
			  Select s = new Select (dropdown);
			  if(count==1)
				  s.selectByVisibleText("General");
			  if(count==2)
				  s.selectByVisibleText("Mechanical Case Study");
			  if(count==3)
				  s.selectByVisibleText("I&C Case Study");
			  if(count==4)
				  s.selectByVisibleText("Electrical Case Study");
			  if(count==5)
				  s.selectByVisibleText("Software Case Study");
		  }}
		  if(title.equals(ee_title)||title.equals(ee_titleUS)||title.equals(ee_titleie11US))
		  {
			  WebElement dropdown = driver.findElement(EquipCaseCategory);
			  Select s = new Select (dropdown);
			  s.selectByVisibleText("Electrical Failure Mode");
		  }
		  if(title.equals(me_title)||title.equals(me_titleUS)||title.equals(me_titleie11US))
		  {
			  WebElement dropdown = driver.findElement(EquipCaseCategory);
			  Select s = new Select (dropdown);
			  s.selectByVisibleText("Mechanical Failure Mode");
		  }
		  //Enters Question
		  wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseQuestion)).sendKeys(title);
		  //Enters Answer
		  wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseAnswer)).sendKeys(title);
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,1700)");
		  Thread.sleep(1000);
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
		  }
		 
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(1000);
		  //Uploads 5 slides
		  wait.until(ExpectedConditions.visibilityOfElementLocated(EquipImageUploadField)).click();
		  Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlides_Firefox.exe");
		  p.waitFor();
		  Thread.sleep(3000);
		  //Checks if 5 images have been uploaded
		  //Checks if 5 images have been uploaded
		  if(driver.findElement(EquipImageCollapsibleExpanded).isDisplayed()==false)
		  {
			  wait.until(ExpectedConditions.visibilityOfElementLocated(EquipImageCollapsible)).click();
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
		  //Enters mandatory data
		  //Enters case id
		  Random random = new Random();
		  List<String> caseID = new ArrayList<String>();
		  String caseId = "";
		  for(int count=1;count<=5;count++)
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
		  //Selects Category
		  if (count ==5)
		  {
			  if(title.equals(eq_title)||title.equals(eq_titleUS)||title.equals(eq_titleie11US))
			  {
				  //Select multiple categories randomly
				  categories.addAll(selectCategories(driver));
			  }
		  }
		  if(count<5){
		  if(title.equals(eq_title)||title.equals(eq_titleUS)||title.equals(eq_titleie11US))
		  {
			  WebElement dropdown = driver.findElement(EquipCaseCategory);
			  Select s = new Select (dropdown);
			  if(count==1)
				  s.selectByVisibleText("General");
			  if(count==2)
				  s.selectByVisibleText("Mechanical Case Study");
			  if(count==3)
				  s.selectByVisibleText("I&C Case Study");
			  if(count==4)
				  s.selectByVisibleText("Electrical Case Study");
			  if(count==5)
				  s.selectByVisibleText("Software Case Study");
		  }}
		  if(title.equals(ee_title)||title.equals(ee_titleUS)||title.equals(ee_titleie11US))
		  {
			  WebElement dropdown = driver.findElement(EquipCaseCategory);
			  Select s = new Select (dropdown);
			  s.selectByVisibleText("Electrical Failure Mode");
		  }
		  if(title.equals(me_title)||title.equals(me_titleUS)||title.equals(me_titleie11US))
		  {
			  WebElement dropdown = driver.findElement(EquipCaseCategory);
			  Select s = new Select (dropdown);
			  s.selectByVisibleText("Mechanical Failure Mode");
		  }
		  //Enters Question
		  wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseQuestion)).sendKeys(title);
		  //Enters Answer
		  wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseAnswer)).sendKeys(title);
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,1700)");
		  Thread.sleep(1000);
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
		  }
		 
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(1000);
		  //Uploads 5 slides
		  ele = wait.until(ExpectedConditions.visibilityOfElementLocated(EquipImageUploadField));
		  act.doubleClick(ele).build().perform();
		  Thread.sleep(3000);
		  Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlides_IE10.exe");
		  p.waitFor();
		  Thread.sleep(3000);
		  //Checks if 5 images have been uploaded
		  if(driver.findElement(EquipImageCollapsibleExpanded).isDisplayed()==false)
		  {
			  wait.until(ExpectedConditions.visibilityOfElementLocated(EquipImageCollapsible)).click();
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
		  //Enters mandatory data
		  //Enters case id
		  Random random = new Random();
		  List<String> caseID = new ArrayList<String>();
		  String caseId = "";
		  for(int count=1;count<=5;count++)
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
		  //Selects Category
		  if (count ==5)
		  {
			  if(title.equals(eq_title)||title.equals(eq_titleUS)||title.equals(eq_titleie11US))
			  {
				  //Select multiple categories randomly
				  categories.addAll(selectCategories(driver));
			  }
		  }
		  if(count<5){
		  if(title.equals(eq_title)||title.equals(eq_titleUS)||title.equals(eq_titleie11US))
		  {
			  WebElement dropdown = driver.findElement(EquipCaseCategory);
			  Select s = new Select (dropdown);
			  if(count==1)
				  s.selectByVisibleText("General");
			  if(count==2)
				  s.selectByVisibleText("Mechanical Case Study");
			  if(count==3)
				  s.selectByVisibleText("I&C Case Study");
			  if(count==4)
				  s.selectByVisibleText("Electrical Case Study");
			  if(count==5)
				  s.selectByVisibleText("Software Case Study");
		  }}
		  if(title.equals(ee_title)||title.equals(ee_titleUS)||title.equals(ee_titleie11US))
		  {
			  WebElement dropdown = driver.findElement(EquipCaseCategory);
			  Select s = new Select (dropdown);
			  s.selectByVisibleText("Electrical Failure Mode");
		  }
		  if(title.equals(me_title)||title.equals(me_titleUS)||title.equals(me_titleie11US))
		  {
			  WebElement dropdown = driver.findElement(EquipCaseCategory);
			  Select s = new Select (dropdown);
			  s.selectByVisibleText("Mechanical Failure Mode");
		  }
		  //Enters Question
		  wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseQuestion)).sendKeys(title);
		  //Enters Answer
		  wait.until(ExpectedConditions.visibilityOfElementLocated(EquipCaseAnswer)).sendKeys(title);
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,1700)");
		  Thread.sleep(1000);
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
		  }
		 
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(1000);
		  //Uploads 5 slides
		  wait.until(ExpectedConditions.visibilityOfElementLocated(EquipImageUploadField)).click();
		  Process p =Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/UploadHumanCaseSlides_IE10.exe");
		  p.waitFor();
		  Thread.sleep(3000);
		  //Checks if 5 images have been uploaded
		  if(driver.findElement(EquipImageCollapsibleExpanded).isDisplayed()==false)
		  {
			  wait.until(ExpectedConditions.visibilityOfElementLocated(EquipImageCollapsible)).click();
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
		  Thread.sleep(1000);
		  if(y==0){
		  if(title.equals(eq_title)||title.equals(eq_titleUS)||title.equals(eq_titleie11US))
		  {
			//Clicks on Equipment Performance Search
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EquipmentPerformanceLink)).click();
		  }}
		  if(y==1)
		  {
			//Clicks on Equipment Performance Search (PII)
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EquipmentDatabankOnlyLink1)).click();
		  }
		  if(title.equals(ee_title)||title.equals(ee_titleUS)||title.equals(ee_titleie11US))
		  {
			//Clicks on Electrical Failure Mode Search
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ElectricalFailureModeLink)).click();
		  }
		  if(title.equals(me_title)||title.equals(me_titleUS)||title.equals(me_titleie11US))
		  {
			//Clicks on Mechanical Failure Mode Search
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj.MechanicalFailureModeLink)).click();
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
		  if(keyword_same.equals(keyword_same_eq)||keyword_same.equals(keyword_same_eqUS)||keyword_same.equals(keyword_same_eqie11US))
		  {
			//Clicks on Equipment Performance Search
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentPerformanceLink)).click();
		  }}
		  if(y==1)
		  {
			//Clicks on Equipment Performance Search (PII)
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentDatabankOnlyLink1)).click();
		  }
		  if(keyword_same.equals(keyword_same_ee)||keyword_same.equals(keywordUS_same_ee)||keyword_same.equals(keyword_same_eeie11US))
		  {
			//Clicks on Electrical Failure Mode Search
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.ElectricalFailureModeLink)).click();
		  }
		  if(keyword_same.equals(keyword_same_me)||keyword_same.equals(keywordUS_same_me)||keyword_same.equals(keyword_same_meie11US))
		  {
			//Clicks on Mechanical Failure Mode Search
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.MechanicalFailureModeLink)).click();
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
		  System.out.println("Electrical case found in Equipment Performance Search (PII)");
		  //Clicks on clear
		  wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.EquipmentSearchClearButton)).click();
		  //Enters Mechanical Case id to see if it exists
		  driver.findElement(obj1.EquipmentSearchCaseIdField).sendKeys(me_caseId);
		  driver.findElement(obj1.EquipmentSearchCaseIdField).sendKeys(Keys.ENTER);
		  //Waits for black loading message to disappear
		  obj.loadingServer(driver);
		  //Checks for mechanical case
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+me_caseId)));
		  System.out.println("Mechanical case found in Equipment Performance Search (PII)");
		  //Clicks on Error free bank
		  try
		  {
			  wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.ErrorFreeBankTopLink)).click();
		  }catch (UnhandledAlertException f){			  
			  driver.switchTo().alert().dismiss();
		  }
		  //Clicks on Electrical Failure Mode Search
		  wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.ElectricalFailureModeLink)).click();
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
		  //Clicks on Mechanical Failure Mode Search
		  wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.MechanicalFailureModeLink)).click();
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
