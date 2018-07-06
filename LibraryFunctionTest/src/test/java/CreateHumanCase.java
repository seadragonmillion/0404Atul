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
import org.openqa.selenium.support.ui.WebDriverWait;


public class CreateHumanCase {

	SoftAssertions softly = new SoftAssertions();
	int numberOfImages=5;
	String keyword_same="QAAfive";
	String key1="QAAzebra";
	String key2="QAAcamel";
	String key3="QAAgiraffe";
	String title ="QAA Human Performance Case Upload";
	String keyword_sameUS="QAAfiveUS";
	String key1US="QAAzebraUS";
	String key2US="QAAcamelUS";
	String key3US="QAAgiraffeUS";
	String titleUS ="QAA US Human Performance Case Upload";
	String keyword_sameie11="QAAie11fifth";
	String key1ie11="QAAie11lion";
	String key2ie11="QAAie11tiger";
	String key3ie11="QAAie11horse";
	String titleie11="QAA IE11 Human Case Upload";
	String keyword_sameUSie11="QAAie11fifthUS";
	String key1USie11="QAAie11lionUS";
	String key2USie11="QAAie11tigerUS";
	String key3USie11="QAAie11horseUS";
	String titleUSie11 ="QAA US IE11 Human Case Upload";
	
	//User dropdown
	By AdminOption = By.id("pii-user-admin");
	
	By ErrorFreeBankTopLink = By.xpath(".//*[@id='links']/a[4]");
	
	//User Management
	By ErrorFreeBankLink = By.xpath(".//*[@id='pii-admin-efbank']/h3/a");
	By HumanCasesLink = By.id("pii-admin-efsh-manage-button");
	By HumanCaseSearchCaseIDAdmin = By.id("pii-admin-efsh-list-input");
	By HumanCaseSearchCaseIDDropdownAdmin = By.id("pii-admin-efsh-list-ul");
	By HumanCaseDeleteButton = By.id("pii-admin-efsh-button-delete");
	By HumanCaseAdminPopupTitle = By.id("pii-admin-efsh-dialog-title");
	By HumanCaseAdminPopupConfirmButton = By.id("pii-admin-efsh-dialog-confirmed");
	By HumanCaseNewButton = By.id("pii-admin-efsh-button-new");
	By HumanCaseIDField = By.id("pii-admin-efsh-id");
	By HumanCaseIDFieldError = By.id("pii-admin-efsh-id-error");
	By HumanCaseQuestion = By.id("pii-admin-efsh-question");
	By HumanCaseAnswer = By.id("pii-admin-efsh-answer");
	By HumanCaseKeywordNewField = By.id("pii-admin-efsh-keyword-search-input");
	By HumanCaseKeywordNewAddButton = By.id("pii-admin-efsh-keyword-new");
	By HumanCaseKeywordExistingList = By.xpath(".//*[@id='pii-admin-efsh-keyword-blocks']/div[2]/ul");
	By FirstAndLastChildInList = By.cssSelector(".ui-first-child.ui-last-child");
	By HumanCaseTaskNewField = By.id("pii-admin-efsh-task-search-input");
	By HumanCaseTaskNewAddButton = By.id("pii-admin-efsh-task-new");
	By HumanCaseTaskExistingList = By.xpath(".//*[@id='pii-admin-efsh-task-blocks']/div[2]/ul");
	By HumanCasePurposeNewField = By.id("pii-admin-efsh-purpose-search-input");
	By HumanCasePurposeNewAddButton = By.id("pii-admin-efsh-purpose-new");
	By HumanCasePurposeExistingList = By.xpath(".//*[@id='pii-admin-efsh-purpose-blocks']/div[2]/ul");
	By HumanCaseConditionNewField = By.id("pii-admin-efsh-condition-search-input");
	By HumanCaseConditionNewAddButton = By.id("pii-admin-efsh-condition-new");
	By HumanCaseConditionExistingList = By.xpath(".//*[@id='pii-admin-efsh-condition-blocks']/div[2]/ul");
	By HumanCaseImageInputField = By.id("pii-admin-efsh-upload-file-input");
	By HumanCaseImageInputCollapsible = By.xpath(".//*[@id='pii-admin-efsh-upload-form-selectedfiles-div']/h5/a");
	By HumanCaseSaveButton = By.id("pii-admin-efsh-button-save");
	By HumanCaseEditButton = By.id("pii-admin-efsh-button-edit");
	By HumanCaseExistingKeywordOnlyOne = By.xpath(".//*[@id='pii-admin-efsh-keyword-form']/div/ul/li/a");

	public int deletePreviousCase(WebDriver driver, String title) throws Exception{
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		CaseBrowse obj1 = new CaseBrowse();
		ShareCheck obj = new ShareCheck();
		//Clicks on Error free bank
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.ErrorFreeBankLink)).click();
		//Clicks on Human Performance Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.HumanPerformanceLink)).click();
		//Enters the title in term search field
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.HumanSearchClearButton)).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.HumanSearchKeywordField)).sendKeys(title);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.HumanSearchKeywordField)).sendKeys(Keys.ENTER);
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
		//Checks if Exact matches appear
		WebElement exact = wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.HumanSearchDropdownListLoaded));
		String exactText=exact.getText();		
		if(exactText.equals("Results")==true)
		{
			int i=1;
			List<String> caseIdList = new ArrayList<String>();
			while(true)
			{
				try
				{
					String xpath=".//*[@id='pii-question-list']/div[1]/div[1]/div["+i+"]";
					System.out.println(xpath);
					WebElement row=driver.findElement(By.xpath(xpath));
					String rowCaseId=row.getAttribute("qid");
					rowCaseId=rowCaseId.substring(1);
					System.out.println("Case id:" +rowCaseId);
					caseIdList.add(rowCaseId);
					i=i+1;
				}catch(NoSuchElementException e)
				{
					break;
				}
			}
			deleteCase(driver,caseIdList);
			return 1;
		}
		else 
		{
			System.out.println("No existing cases");
			return 0;
		}		
	}

	public void deleteCase(WebDriver driver, List<String> caseID) throws Exception{
		
		  WebDriverWait wait = new WebDriverWait(driver,40);
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  ShareCheck obj = new ShareCheck();
		  for(int i=0;i<caseID.size();i++)
		  {
		  //Clicks on admin user name on top right corner
		  wait.until(ExpectedConditions.visibilityOfElementLocated(obj.LoginNameOnTopRight)).click();
		  //Clicks on admin option
		  wait.until(ExpectedConditions.visibilityOfElementLocated(AdminOption)).click();
		  Thread.sleep(1000);
		  //Clicks on Errorfree bank option
		  if (driver.findElement(HumanCasesLink).isDisplayed()==false)
		  {
			  wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorFreeBankLink)).click();
		  }
		  //Clicks on Human cases
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink)).click();
		  //Waits for black loading message to disappear
		  obj.loadingServer(driver);
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(1000);
		  //CLick on enter case id
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSearchCaseIDAdmin)).sendKeys(caseID.get(i));
		  Thread.sleep(2000);
		  //Clicks on case id
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSearchCaseIDDropdownAdmin)).click();
		  //Waits for black loading message to disappear
		  obj.loadingServer(driver);
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(1000);
		  //Clicks on delete button
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseDeleteButton)).click();
		  //Clicks on delete case
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupTitle)).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupConfirmButton)).click();
		  //Waits for black loading message to disappear
		  obj.loadingServer(driver);
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(1000);
		  //Checks if case deleted
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSearchCaseIDAdmin)).clear();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSearchCaseIDAdmin)).sendKeys(caseID.get(i));
		  Thread.sleep(2000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSearchCaseIDAdmin)).sendKeys(Keys.ENTER);
		  Thread.sleep(1000);
		  if(driver.findElement(HumanCaseSearchCaseIDDropdownAdmin).isDisplayed()==false)
			  System.out.println("Case deleted");		
		  }
	}
	
	public List<String> createCaseHumanChrome (WebDriver driver, int m) throws Exception {
		
		  WebDriverWait wait = new WebDriverWait(driver,40);  
		  List<String> caseID = new ArrayList<String>();
		  CaseBrowse obj = new CaseBrowse();
		  ShareCheck obj1 = new ShareCheck();
		  Login obj2 = new Login();
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  //Clicks on admin user name on top right corner
		  wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.LoginNameOnTopRight)).click();
		  //Clicks on admin option
		  wait.until(ExpectedConditions.visibilityOfElementLocated(AdminOption)).click();
		  //Clicks on Errorfree bank option
		  if(m==0)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorFreeBankLink)).click();
		  //Clicks on Human cases
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink)).click();
		  //Creates 5 cases
		  //Enters mandatory data
		  //Enters case id
		  Random random = new Random();
		  String caseId="";
		  for(int count=1;count<=5;count++)
		  {
			  //Waits for black loading message to disappear
			  obj1.loadingServer(driver);
			  Thread.sleep(1000);
			  jse.executeScript("scroll(0,0)");
			  Thread.sleep(1000);
			  //Clicks on new case button
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseNewButton)).click();
			  //Clicks on new case
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupTitle)).click();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupConfirmButton)).click();
			  while (true)
		      {
			  Thread.sleep(1000);
			  int y=random.nextInt(10000);
			  if(y<1000)
			     continue;
			  caseId = String.format("%d", y);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseIDField)).sendKeys(caseId);
			  Thread.sleep(1000);
			  WebElement errorCaseId=driver.findElement(HumanCaseIDFieldError);
			  if(errorCaseId.isDisplayed()==true)
			  {
				  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseIDField)).clear();
				  continue;
			  }
			  if(errorCaseId.isDisplayed()==false)
				  break;
		      }
		  System.out.println("Case id: "+ caseId);
		  //Add case id to list
		  caseID.add(caseId);
		  //Enters Question
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseQuestion)).sendKeys(title);
		  //Enters Answer
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAnswer)).sendKeys(title);
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,1700)");
		  Thread.sleep(1000);
		  //Enters Keyword
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewField)).sendKeys(keyword_same);
		  Thread.sleep(1500);
		  if(count==1)
		  {
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewAddButton)).click();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewField)).clear();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewField)).sendKeys(key1);
			  Thread.sleep(1000);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewAddButton)).click();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewField)).clear();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewField)).sendKeys(key2);
			  Thread.sleep(1000);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewAddButton)).click();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewField)).clear();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewField)).sendKeys(key3);
			  Thread.sleep(1000);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewAddButton)).click();
			  //Add keyword with all special characters
			  obj.addKeywordWithAllSpecialCharactersHuman(driver);
		  }
		  else 
		  {
			  WebElement element = driver.findElement(HumanCaseKeywordExistingList);
			  element.findElement(FirstAndLastChildInList).click();
		  }		 
		  //Enters task
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseTaskNewField)).sendKeys(keyword_same);
		  Thread.sleep(1500);
		  if(count==1)
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseTaskNewAddButton)).click();
		  else
		  {
			  WebElement element = driver.findElement(HumanCaseTaskExistingList);
			  element.findElement(FirstAndLastChildInList).click();			  
		  }
		  //Enters purpose
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasePurposeNewField)).sendKeys(keyword_same);
		  Thread.sleep(1500);
		  if(count==1)
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasePurposeNewAddButton)).click();
		  else
		  {
			  WebElement element = driver.findElement(HumanCasePurposeExistingList);
			  element.findElement(FirstAndLastChildInList).click();	
		  }
		  jse.executeScript("scroll(0,2000)");
		  //Enters condition
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseConditionNewField)).sendKeys(keyword_same);
		  Thread.sleep(1500);
		  jse.executeScript("scroll(0,2000)");
		  if(count==1)
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseConditionNewAddButton)).click();
		  else
		  {
			  WebElement element = driver.findElement(HumanCaseConditionExistingList);
			  element.findElement(FirstAndLastChildInList).click();	
		  }
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(1000);
		  //Uploads 5 slides
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseImageInputField)).click();
		  Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlides.exe");
		  p.waitFor();
		  Thread.sleep(3000);
		  //Checks if 5 images have been uploaded
		  if(count==1)
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseImageInputCollapsible)).click();
		  Thread.sleep(2000);
		  int i;
		  int n=1000;
		  for (i=0; i<5;i++)
		  {
			  String xpath = ".//*[@id='pii-admin-efsh-upload-form-selectedfiles']/div["+(i+1)+"]";
			  if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).isDisplayed())
			  {
				  System.out.println("Uploaded Image : " + (i+1));
			  }
			  n=n+100;
			  String scroll = "scroll(0,"+n+")";
			  Thread.sleep(1000);
			  jse.executeScript(scroll);
			  Thread.sleep(1000);
		  }
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(1000);
		  //Clicks on save
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSaveButton)).click();
		  //Clicks on create case
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupTitle)).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupConfirmButton)).click();
		  //Waits for black loading message to disappear
		  obj1.loadingServer(driver);
		  }
		  return caseID;
	}
	
	public List<String> createCaseHumanFirefox (WebDriver driver, int m) throws Exception {
		
		  WebDriverWait wait = new WebDriverWait(driver,40);  
		  List<String> caseID = new ArrayList<String>();
		  CaseBrowse obj = new CaseBrowse();
		  ShareCheck obj1 = new ShareCheck();
		  Login obj2 = new Login();
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  //Clicks on admin user name on top right corner
		  wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.LoginNameOnTopRight)).click();
		  //Clicks on admin option
		  wait.until(ExpectedConditions.visibilityOfElementLocated(AdminOption)).click();
		  //Waits for black loading message to disappear
		  obj1.loadingServer(driver);
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(1000);
		  //Clicks on Errorfree bank option
		  if(m==0)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorFreeBankLink)).click();
		  //Waits for black loading message to disappear
		  obj1.loadingServer(driver);
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(1000);
		  //Clicks on Human cases
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink)).click();
		  //Waits for black loading message to disappear
		  obj1.loadingServer(driver);
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(1000);
		  //Creates 5 cases
		  //Enters mandatory data
		  //Enters case id
		  Random random = new Random();
		  String caseId="";
		  for(int count=1;count<=5;count++)
		  {
			  //Waits for black loading message to disappear
			  obj1.loadingServer(driver);
			  Thread.sleep(1000);
			  jse.executeScript("scroll(0,0)");
			  Thread.sleep(1000);
			  //Clicks on new case button
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseNewButton)).click();
			  //Clicks on new case
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupTitle)).click();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupConfirmButton)).click();
			  //Waits for black loading message to disappear
			  obj1.loadingServer(driver);
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
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseIDField)).sendKeys(caseId);
			  Thread.sleep(1000);
			  WebElement errorCaseId=driver.findElement(HumanCaseIDFieldError);
			  if(errorCaseId.isDisplayed()==true)
			  {
				  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseIDField)).clear();
				  continue;
			  }
			  if(errorCaseId.isDisplayed()==false)
				  break;
		      }
		  System.out.println("Case id: "+ caseId);
		  //Add case id to list
		  caseID.add(caseId);
		  //Enters Question
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseQuestion)).sendKeys(title);
		  //Enters Answer
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAnswer)).sendKeys(title);
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,1700)");
		  Thread.sleep(1000);
		  //Enters Keyword
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewField)).sendKeys(keyword_same);
		  Thread.sleep(1500);
		  if(count==1)
		  {
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewAddButton)).click();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewField)).clear();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewField)).sendKeys(key1);
			  Thread.sleep(1000);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewAddButton)).click();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewField)).clear();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewField)).sendKeys(key2);
			  Thread.sleep(1000);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewAddButton)).click();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewField)).clear();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewField)).sendKeys(key3);
			  Thread.sleep(1000);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewAddButton)).click();
			  //Add keyword with all special characters
			  obj.addKeywordWithAllSpecialCharactersHuman(driver);
		  }
		  else 
		  {
			  WebElement element = driver.findElement(HumanCaseKeywordExistingList);
			  element.findElement(FirstAndLastChildInList).click();
		  }		 
		  //Enters task
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseTaskNewField)).sendKeys(keyword_same);
		  Thread.sleep(1500);
		  if(count==1)
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseTaskNewAddButton)).click();
		  else
		  {
			  WebElement element = driver.findElement(HumanCaseTaskExistingList);
			  element.findElement(FirstAndLastChildInList).click();			  
		  }
		  //Enters purpose
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasePurposeNewField)).sendKeys(keyword_same);
		  Thread.sleep(1500);
		  if(count==1)
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasePurposeNewAddButton)).click();
		  else
		  {
			  WebElement element = driver.findElement(HumanCasePurposeExistingList);
			  element.findElement(FirstAndLastChildInList).click();	
		  }
		  jse.executeScript("scroll(0,2000)");
		  //Enters condition
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseConditionNewField)).sendKeys(keyword_same);
		  Thread.sleep(1500);
		  jse.executeScript("scroll(0,2000)");
		  if(count==1)
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseConditionNewAddButton)).click();
		  else
		  {
			  WebElement element = driver.findElement(HumanCaseConditionExistingList);
			  element.findElement(FirstAndLastChildInList).click();	
		  }
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(1000);
		  //Uploads 5 slides
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseImageInputField)).click();
		  Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlides_Firefox.exe");
		  p.waitFor();
		  Thread.sleep(3000);
		  //Checks if 5 images have been uploaded
		  if(count==1)
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseImageInputCollapsible)).click();
		  Thread.sleep(2000);
		  int i;
		  int n=1000;
		  for (i=0; i<5;i++)
		  {
			  String xpath = ".//*[@id='pii-admin-efsh-upload-form-selectedfiles']/div["+(i+1)+"]";
			  if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).isDisplayed())
			  {
				  System.out.println("Uploaded Image : " + (i+1));
			  }
			  n=n+100;
			  String scroll = "scroll(0,"+n+")";
			  Thread.sleep(1000);
			  jse.executeScript(scroll);
			  Thread.sleep(1000);
		  }
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(1000);
		  //Clicks on save
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSaveButton)).click();
		  //Clicks on create case
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupTitle)).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupConfirmButton)).click();
		  //Waits for black loading message to disappear
		  obj1.loadingServer(driver);
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(1000);
		  }
		  return caseID;
	}
	
	public List<String> createCaseHumanIE10 (WebDriver driver, int m) throws Exception {
		
		  WebDriverWait wait = new WebDriverWait(driver,40);  
		  List<String> caseID = new ArrayList<String>();
		  CaseBrowse obj = new CaseBrowse();
		  ShareCheck obj1 = new ShareCheck();
		  Login obj2 = new Login();
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  //Clicks on admin user name on top right corner
		  wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.LoginNameOnTopRight)).click();
		  //Clicks on admin option
		  wait.until(ExpectedConditions.visibilityOfElementLocated(AdminOption)).click();
		  //Waits for black loading message to disappear
		  obj1.loadingServer(driver);
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(1000);
		  //Clicks on Errorfree bank option
		  if(m==0)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorFreeBankLink)).click();
		  //Waits for black loading message to disappear
		  obj1.loadingServer(driver);
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(1000);
		  
		  //Creates 5 cases
		  //Enters mandatory data
		  //Enters case id
		  Random random = new Random();
		  String caseId="";
		  for(int count=1;count<=5;count++)
		  {
			  //Clicks on Human cases
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink)).click();
			  //Waits for black loading message to disappear
			  obj1.loadingServer(driver);
			  Thread.sleep(1000);
			  jse.executeScript("scroll(0,0)");
			  Thread.sleep(1000);
			  //Waits for black loading message to disappear
			  obj1.loadingServer(driver);
			  Thread.sleep(1000);
			  jse.executeScript("scroll(0,0)");
			  Thread.sleep(1000);
			  //Clicks on new case button
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseNewButton)).click();
			  //Clicks on new case
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupTitle)).click();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupConfirmButton)).click();
			  //Waits for black loading message to disappear
			  obj1.loadingServer(driver);
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
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseIDField)).sendKeys(caseId);
			  Thread.sleep(1000);
			  WebElement errorCaseId=driver.findElement(HumanCaseIDFieldError);
			  if(errorCaseId.isDisplayed()==true)
			  {
				  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseIDField)).clear();
				  continue;
			  }
			  if(errorCaseId.isDisplayed()==false)
				  break;
		      }
		  System.out.println("Case id: "+ caseId);
		  //Add case id to list
		  caseID.add(caseId);
		  //Enters Question
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseQuestion)).sendKeys(title);
		  //Enters Answer
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAnswer)).sendKeys(title);
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,1700)");
		  Thread.sleep(1000);
		  //Enters Keyword
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewField)).sendKeys(keyword_same);
		  Thread.sleep(1500);
		  if(count==1)
		  {
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewAddButton)).click();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewField)).clear();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewField)).sendKeys(key1);
			  Thread.sleep(1000);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewAddButton)).click();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewField)).clear();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewField)).sendKeys(key2);
			  Thread.sleep(1000);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewAddButton)).click();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewField)).clear();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewField)).sendKeys(key3);
			  Thread.sleep(1000);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewAddButton)).click();
			  //Add keyword with all special characters
			  obj.addKeywordWithAllSpecialCharactersHuman(driver);
		  }
		  else 
		  {
			  WebElement element = driver.findElement(HumanCaseKeywordExistingList);
			  element.findElement(FirstAndLastChildInList).click();
		  }		 
		  //Enters task
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseTaskNewField)).sendKeys(keyword_same);
		  Thread.sleep(1500);
		  if(count==1)
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseTaskNewAddButton)).click();
		  else
		  {
			  WebElement element = driver.findElement(HumanCaseTaskExistingList);
			  element.findElement(FirstAndLastChildInList).click();			  
		  }
		  //Enters purpose
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasePurposeNewField)).sendKeys(keyword_same);
		  Thread.sleep(1500);
		  if(count==1)
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasePurposeNewAddButton)).click();
		  else
		  {
			  WebElement element = driver.findElement(HumanCasePurposeExistingList);
			  element.findElement(FirstAndLastChildInList).click();	
		  }
		  jse.executeScript("scroll(0,2000)");
		  //Enters condition
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseConditionNewField)).sendKeys(keyword_same);
		  Thread.sleep(1500);
		  jse.executeScript("scroll(0,2000)");
		  if(count==1)
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseConditionNewAddButton)).click();
		  else
		  {
			  WebElement element = driver.findElement(HumanCaseConditionExistingList);
			  element.findElement(FirstAndLastChildInList).click();	
		  }
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(1000);
		  //Uploads 5 slides
		  WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseImageInputField));
		  Actions act= new Actions(driver);
		  act.doubleClick(ele).build().perform();
		  Thread.sleep(3000);
		  Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlides_IE10.exe");
		  p.waitFor();
		  Thread.sleep(3000);
		  //Checks if 5 images have been uploaded
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseImageInputCollapsible)).click();
		  Thread.sleep(2000);
		  int i;
		  int n=1000;
		  for (i=0; i<5;i++)
		  {
			  String xpath = ".//*[@id='pii-admin-efsh-upload-form-selectedfiles']/div["+(i+1)+"]";
			  if (driver.findElement(By.xpath(xpath)).isDisplayed())
			  {
				  System.out.println("Uploaded Image : " + (i+1));
			  }
			  n=n+100;
			  String scroll = "scroll(0,"+n+")";
			  Thread.sleep(1000);
			  jse.executeScript(scroll);
			  Thread.sleep(1000);
		  }
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(1000);
		  //Clicks on save
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSaveButton)).click();
		  //Clicks on create case
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupTitle)).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupConfirmButton)).click();
		  //Waits for black loading message to disappear
		  obj1.loadingServer(driver);
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(1000);
		  }
		  return caseID;
	}
	
	public List<String> createCaseHumanIE11 (WebDriver driver, int m) throws Exception {
		
		  WebDriverWait wait = new WebDriverWait(driver,40);  
		  List<String> caseID = new ArrayList<String>();
		  CaseBrowse obj = new CaseBrowse();
		  ShareCheck obj1 = new ShareCheck();
		  Login obj2 = new Login();
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  //Clicks on admin user name on top right corner
		  wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.LoginNameOnTopRight)).click();
		  //Clicks on admin option
		  wait.until(ExpectedConditions.visibilityOfElementLocated(AdminOption)).click();
		  //Waits for black loading message to disappear
		  obj1.loadingServer(driver);
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(1000);
		  //Clicks on Errorfree bank option
		  if(m==0)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorFreeBankLink)).click();
		  //Waits for black loading message to disappear
		  obj1.loadingServer(driver);
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(1000);
		  
		  //Creates 5 cases
		  //Enters mandatory data
		  //Enters case id
		  Random random = new Random();
		  String caseId="";
		  for(int count=1;count<=5;count++)
		  {
			  //Clicks on Human cases
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink)).click();
			  //Waits for black loading message to disappear
			  obj1.loadingServer(driver);
			  Thread.sleep(1000);
			  jse.executeScript("scroll(0,0)");
			  Thread.sleep(1000);
			  //Waits for black loading message to disappear
			  obj1.loadingServer(driver);
			  Thread.sleep(1000);
			  jse.executeScript("scroll(0,0)");
			  Thread.sleep(1000);
			  //Clicks on new case button
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseNewButton)).click();
			  //Clicks on new case
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupTitle)).click();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupConfirmButton)).click();
			  //Waits for black loading message to disappear
			  obj1.loadingServer(driver);
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
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseIDField)).sendKeys(caseId);
			  Thread.sleep(1000);
			  WebElement errorCaseId=driver.findElement(HumanCaseIDFieldError);
			  if(errorCaseId.isDisplayed()==true)
			  {
				  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseIDField)).clear();
				  continue;
			  }
			  if(errorCaseId.isDisplayed()==false)
				  break;
		      }
		  System.out.println("Case id: "+ caseId);
		  //Add case id to list
		  caseID.add(caseId);
		  //Enters Question
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseQuestion)).sendKeys(title);
		  //Enters Answer
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAnswer)).sendKeys(title);
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,1700)");
		  Thread.sleep(1000);
		  //Enters Keyword
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewField)).sendKeys(keyword_same);
		  Thread.sleep(1500);
		  if(count==1)
		  {
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewAddButton)).click();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewField)).clear();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewField)).sendKeys(key1);
			  Thread.sleep(1000);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewAddButton)).click();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewField)).clear();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewField)).sendKeys(key2);
			  Thread.sleep(1000);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewAddButton)).click();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewField)).clear();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewField)).sendKeys(key3);
			  Thread.sleep(1000);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewAddButton)).click();
			  //Add keyword with all special characters
			  obj.addKeywordWithAllSpecialCharactersHuman(driver);
		  }
		  else 
		  {
			  WebElement element = driver.findElement(HumanCaseKeywordExistingList);
			  element.findElement(FirstAndLastChildInList).click();
		  }		 
		  //Enters task
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseTaskNewField)).sendKeys(keyword_same);
		  Thread.sleep(1500);
		  if(count==1)
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseTaskNewAddButton)).click();
		  else
		  {
			  WebElement element = driver.findElement(HumanCaseTaskExistingList);
			  element.findElement(FirstAndLastChildInList).click();			  
		  }
		  //Enters purpose
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasePurposeNewField)).sendKeys(keyword_same);
		  Thread.sleep(1500);
		  if(count==1)
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasePurposeNewAddButton)).click();
		  else
		  {
			  WebElement element = driver.findElement(HumanCasePurposeExistingList);
			  element.findElement(FirstAndLastChildInList).click();	
		  }
		  jse.executeScript("scroll(0,2000)");
		  //Enters condition
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseConditionNewField)).sendKeys(keyword_same);
		  Thread.sleep(1500);
		  jse.executeScript("scroll(0,2000)");
		  if(count==1)
			  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseConditionNewAddButton)).click();
		  else
		  {
			  WebElement element = driver.findElement(HumanCaseConditionExistingList);
			  element.findElement(FirstAndLastChildInList).click();	
		  }
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(1000);
		  //Uploads 5 slides
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseImageInputField)).click();
		  Thread.sleep(3000);
		  Process p =Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/UploadHumanCaseSlides_IE10.exe");
		  p.waitFor();
		  Thread.sleep(3000);
		  //Checks if 5 images have been uploaded
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseImageInputCollapsible)).click();
		  Thread.sleep(2000);
		  int i;
		  int n=1000;
		  for (i=0; i<5;i++)
		  {
			  String xpath = ".//*[@id='pii-admin-efsh-upload-form-selectedfiles']/div["+(i+1)+"]";
			  if (driver.findElement(By.xpath(xpath)).isDisplayed())
			  {
				  System.out.println("Uploaded Image : " + (i+1));
			  }
			  n=n+100;
			  String scroll = "scroll(0,"+n+")";
			  Thread.sleep(1000);
			  jse.executeScript(scroll);
			  Thread.sleep(1000);
		  }
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(1000);
		  //Clicks on save
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSaveButton)).click();
		  //Clicks on create case
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupTitle)).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupConfirmButton)).click();
		  //Waits for black loading message to disappear
		  obj1.loadingServer(driver);
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(1000);
		  }
		  return caseID;
	}
	
	public void changeKeywordKALE1969(WebDriver driver, List<String> caseID, String keyword_same) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		ShareCheck obj = new ShareCheck();
		Login obj1 = new Login();
		CaseBrowse obj2 = new CaseBrowse();
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.LoginNameOnTopRight)).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(AdminOption)).click();
		Thread.sleep(1000);
		//Clicks on Errorfree bank option
		if (driver.findElement(HumanCasesLink).isDisplayed()==false)
		{
		  wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorFreeBankLink)).click();
		}
		//Clicks on Human cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink)).click();
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
		Thread.sleep(1000);
		jse.executeScript("scroll(0,0)");
		Thread.sleep(1000);
		//CLick on enter case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSearchCaseIDAdmin)).sendKeys(caseID.get(1));
		Thread.sleep(2000);
		//Clicks on case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSearchCaseIDDropdownAdmin)).click();
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
		Thread.sleep(1000);
		jse.executeScript("scroll(0,0)");
		Thread.sleep(1000);
		//Click on Edit
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseEditButton)).click();
		Thread.sleep(2000);
		//Scroll down
		jse.executeScript("scroll(0,2000)");
		Thread.sleep(1000);
		//Click on added existing keyword
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseExistingKeywordOnlyOne)).click();
		Thread.sleep(2000);
		//Clicks on remove keyword
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupConfirmButton)).click();
		//Waits for black loading message to disappear
		obj.loadingServer(driver);
		Thread.sleep(2000);
		//Scroll down
		jse.executeScript("scroll(0,2000)");
		Thread.sleep(1000);
		//Add new keyword
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewField)).sendKeys(keyword_same+"changed");
		Thread.sleep(1500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewAddButton)).click();
		Thread.sleep(1000);
	    jse.executeScript("scroll(0,0)");
	    Thread.sleep(1000);
	    //Clicks on save
	    wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSaveButton)).click();
	    //Clicks on create case
	    wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupTitle)).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupConfirmButton)).click();
	    //Waits for black loading message to disappear
	    obj.loadingServer(driver);
	    Thread.sleep(1000);
	    jse.executeScript("scroll(0,0)");
	    Thread.sleep(1000);
	    //Clicks on Error free bank
		try
		{
		  wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorFreeBankTopLink)).click();
		}catch (UnhandledAlertException f){			  
		  driver.switchTo().alert().dismiss();
		}
		//Clicks on Human Performance Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.HumanPerformanceLink)).click();
		//Waits for black loading message to disappear
	    obj.loadingServer(driver);
	    //Checks for search method with magnifying glass
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.HumanSearchKeywordField)).sendKeys(keyword_same+"changed");
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.HumanSearchKeywordFieldSearchButton)).click();
	  	//Wait for loading message to disappear
	  	obj.loadingServer(driver);
	  	//Waits for case
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+caseID.get(1))));
	}
	
	public void compareSlide(WebDriver driver, List<String> caseID, String title) throws Exception{
		
		  WebDriverWait wait = new WebDriverWait(driver,40);
		  CaseBrowse obj = new CaseBrowse();
		  //Clicks on Error free bank
		  try
		  {
			  wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorFreeBankTopLink)).click();
		  }catch (UnhandledAlertException f){			  
			  driver.switchTo().alert().dismiss();
		  }
		  //Clicks on Human Performance Search
		  wait.until(ExpectedConditions.visibilityOfElementLocated(obj.HumanPerformanceLink)).click();
		  //Look for case id
		  obj.browseCaseIDHuman(driver, caseID.get(0), title);		  
	}
	
	public void checkkeyword (WebDriver driver, List<String> caseID, String keyword_same, String key1, String key2, String key3, String title) throws Exception {
		
		  WebDriverWait wait = new WebDriverWait(driver,40);
		  CaseBrowse obj = new CaseBrowse();
		  //Enters the term and check the search by enter
		  wait.until(ExpectedConditions.visibilityOfElementLocated(obj.HumanSearchClearButton)).click();
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(obj.HumanSearchKeywordField)).sendKeys(keyword_same);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(obj.HumanSearchKeywordField)).sendKeys(Keys.ENTER);
		  //Checks for the five cases
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+caseID.get(0))));
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+caseID.get(1))));
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+caseID.get(2))));
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+caseID.get(3))));
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+caseID.get(4))));
		  Thread.sleep(1000);
		  //Clicks on clear
		  wait.until(ExpectedConditions.visibilityOfElementLocated(obj.HumanSearchClearButton)).click();
		  //Enters the term with 3 unique keywords
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(obj.HumanSearchKeywordField)).sendKeys(key1);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(obj.HumanSearchKeywordField)).sendKeys(Keys.ENTER);
		  //Checks for the case id 1
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+caseID.get(0))));
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(obj.HumanSearchClearButton)).click();
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(obj.HumanSearchKeywordField)).sendKeys(key2);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(obj.HumanSearchKeywordField)).sendKeys(Keys.ENTER);
		  //Checks for the case id 1
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+caseID.get(0))));
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(obj.HumanSearchClearButton)).click();
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(obj.HumanSearchKeywordField)).sendKeys(key3);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(obj.HumanSearchKeywordField)).sendKeys(Keys.ENTER);
		  //Checks for the case id 1
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+caseID.get(0))));
		  Thread.sleep(1000);
		  //Enters the title and check the search by enter
		  wait.until(ExpectedConditions.visibilityOfElementLocated(obj.HumanSearchClearButton)).click();
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(obj.HumanSearchKeywordField)).sendKeys(title);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(obj.HumanSearchKeywordField)).sendKeys(Keys.ENTER);
		  //Checks for the five cases
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+caseID.get(0))));
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+caseID.get(1))));
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+caseID.get(2))));
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+caseID.get(3))));
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+caseID.get(4))));
		  Thread.sleep(1000);
		  //Clicks on clear
		  wait.until(ExpectedConditions.visibilityOfElementLocated(obj.HumanSearchClearButton)).click();		  
	}
	
	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}

}
