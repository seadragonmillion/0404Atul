package kaleTestSoftware;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CreateHumanCase {

	SoftAssertions softly = new SoftAssertions();
	LoginPageObj lpo = new LoginPageObj();
	ShareCheck2 share2 = new ShareCheck2();
	ShareCheckPageObj shareObj = new ShareCheckPageObj();
	ShareCheck share = new ShareCheck();
	CaseBrowseObj cb = new CaseBrowseObj();
	
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
	By ErrorFreeBankAdminLink = By.xpath(".//*[@id='pii-admin-efbank']/h3/a");
	By HumanCasesLink = By.id("pii-admin-efsh-manage-button");
	By HumanCaseSearchCaseIDAdmin = By.id("pii-admin-efsh-list-input");
	By HumanCaseSearchCaseIDDropdownAdmin = By.id("pii-admin-efsh-list-ul");
	By HumanCaseDeleteButton = By.id("pii-admin-efsh-button-delete");
	By HumanCaseAdminPopupTitle = By.id("pii-admin-efsh-dialog-title");
	By HumanCaseAdminPopupConfirmButton = By.id("pii-admin-efsh-dialog-confirmed");
	By HumanCaseNewButton = By.id("pii-admin-efsh-button-new");
	By HumanCaseIDField = By.id("pii-admin-efsh-id");
	By HumanCaseIDFieldError = By.id("pii-admin-efsh-id-error");
	By HumanCaseSlideError = By.id("pii-admin-efsh-upload-file-input-error");
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
	By HumanCaseSlidesDivContainingErrorDottedLine = By.xpath(".//*[@id='pii-admin-efsh-upload-form']/div[2]/div[1]");
	By HumanCaseSaveButton = By.id("pii-admin-efsh-button-save");
	By HumanCaseEditButton = By.id("pii-admin-efsh-button-edit");
	By HumanCaseExistingKeywordOnlyOne = By.xpath(".//*[@id='pii-admin-efsh-keyword-form']/div/ul/li/a");
	By HumanCaseExistingTaskOnlyOne = By.xpath(".//*[@id='pii-admin-efsh-task-form']/div/ul/li/a");
	By HumanCaseExistingPurposeOnlyOne = By.xpath(".//*[@id='pii-admin-efsh-purpose-form']/div/ul/li/a");
	By HumanCaseExistingConditionOnlyOne = By.xpath(".//*[@id='pii-admin-efsh-condition-form']/div/ul/li/a");
	By HumanCasesLink1Title = By.id("pii-admin-efsh-linktitle-0");
	By HumanCasesLink1URL = By.id("pii-admin-efsh-linkurl-0");
	By HumanCasesLink2Title = By.id("pii-admin-efsh-linktitle-1");
	By HumanCasesLink2URL = By.id("pii-admin-efsh-linkurl-1");
	By HumanCasesLink3Title = By.id("pii-admin-efsh-linktitle-2");
	By HumanCasesLink3URL = By.id("pii-admin-efsh-linkurl-2");
	By HumanCasesLink4Title = By.id("pii-admin-efsh-linktitle-3");
	By HumanCasesLink4URL = By.id("pii-admin-efsh-linkurl-3");
	By HumanCasesLink5Title = By.id("pii-admin-efsh-linktitle-4");
	By HumanCasesLink5URL = By.id("pii-admin-efsh-linkurl-4");
	By HumanCasesLink6Title = By.id("pii-admin-efsh-linktitle-5");
	By HumanCasesLink6URL = By.id("pii-admin-efsh-linkurl-5");
	By HumanCasesLink7Title = By.id("pii-admin-efsh-linktitle-6");
	By HumanCasesLink7URL = By.id("pii-admin-efsh-linkurl-6");
	By HumanCasesLink8Title = By.id("pii-admin-efsh-linktitle-7");
	By HumanCasesLink8URL = By.id("pii-admin-efsh-linkurl-7");
	By HumanCasesLink9Title = By.id("pii-admin-efsh-linktitle-8");
	By HumanCasesLink9URL = By.id("pii-admin-efsh-linkurl-8");
	By HumanCasesLink10Title = By.id("pii-admin-efsh-linktitle-9");
	By HumanCasesLink10URL = By.id("pii-admin-efsh-linkurl-9");
	By HumanCasesLink11Title = By.id("pii-admin-efsh-linktitle-10");
	By HumanCasesLink11URL = By.id("pii-admin-efsh-linkurl-10");
	By HumanCasesLink12Title = By.id("pii-admin-efsh-linktitle-11");
	By HumanCasesLink12URL = By.id("pii-admin-efsh-linkurl-11");
	By HumanCasesLink13Title = By.id("pii-admin-efsh-linktitle-12");
	By HumanCasesLink13URL = By.id("pii-admin-efsh-linkurl-12");
	By HumanCasesLink2VideoCheckbox = By.xpath(".//*[@id='pii-admin-efsh-linkdiv-1']/div[2]/table/tbody/tr[1]/td[1]/div/label");
	By HumanCasesLink4VideoCheckbox = By.xpath(".//*[@id='pii-admin-efsh-linkdiv-3']/div[2]/table/tbody/tr[1]/td[1]/div/label");
	By HumanCasesLink5VideoCheckbox = By.xpath(".//*[@id='pii-admin-efsh-linkdiv-4']/div[2]/table/tbody/tr[1]/td[1]/div/label");
	By HumanCasesLink6VideoCheckbox = By.xpath(".//*[@id='pii-admin-efsh-linkdiv-5']/div[2]/table/tbody/tr[1]/td[1]/div/label");
	By HumanCasesLinkTitleOnSide = By.id("pii-admin-efsh-linklabel-0");
	By HumanCasesLink1TitleCrossSymbol = By.xpath(".//*[@id='pii-admin-efsh-linkdiv-0']/div[1]/div/a");
	By HumanCasesLink1URLCrossSymbol = By.xpath(".//*[@id='pii-admin-efsh-linkdiv-0']/div[2]/table/tbody/tr[1]/td[2]/div/a");
	By HumanCasesLink2TitleCrossSymbol = By.xpath(".//*[@id='pii-admin-efsh-linkdiv-1']/div[1]/div/a");
	By HumanCasesLink2URLCrossSymbol = By.xpath(".//*[@id='pii-admin-efsh-linkdiv-1']/div[2]/table/tbody/tr[1]/td[2]/div/a");
	
	public void checkForErrorWithoutUploadingSlides(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		//Scroll top
		share.scrollToTop(driver);
		//Click on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSaveButton)).click();
		//Click ok on error message
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupConfirmButton)).click();
		//Verify error message on slides
		String error = wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSlideError)).getText();
		softly.assertThat(error).as("test data").isEqualTo("Please select some PNG files with .png extension");
		//Verify error dotted line present
		String errorDotted = wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSlidesDivContainingErrorDottedLine)).getAttribute("class");
		softly.assertThat(errorDotted).as("test data").contains("error");
	}

	public void checkNoError(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		if(driver.getCurrentUrl().contains("kaleqa"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseImageInputCollapsible)).click();
			//Get browser name
			Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
			String browserName = cap.getBrowserName().toLowerCase();
			System.out.println(browserName);
			if (browserName.equals("internet explorer"))
			{
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseImageInputCollapsible)).click();
			}
			//Verify the red error message is gone
			String errorDotted = wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSlidesDivContainingErrorDottedLine)).getAttribute("class");
			softly.assertThat(errorDotted).as("test data").doesNotContain("error");
		}
	}
	
	public int deletePreviousCase(WebDriver driver, String title) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,40);
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		//Clicks on Error free bank
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.ErrorFreeBankLinkHomePage)).click();
		//Clicks on Human Performance Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanPerformanceLink)).click();
		//Enters the title in term search field
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchClearButton)).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchKeywordField)).sendKeys(title);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchKeywordField)).sendKeys(Keys.ENTER);
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		//Checks if Exact matches appear
		WebElement exact = wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchDropdownListLoaded));
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
		for(int i=0;i<caseID.size();i++)
		{
			//Clicks on admin user name on top right corner
			wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.LoginNameOnTopRight)).click();
			//Clicks on admin option
			wait.until(ExpectedConditions.visibilityOfElementLocated(AdminOption)).click();
			Thread.sleep(1000);
			//Clicks on Errorfree bank option
			if (driver.findElement(HumanCasesLink).isDisplayed()==false)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorFreeBankAdminLink)).click();
			}
			//Clicks on Human cases
			wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink)).click();
			//Waits for black loading message to disappear
			share2.loadingServer(driver);
			share.scrollToTop(driver);
			//CLick on enter case id
			wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSearchCaseIDAdmin)).sendKeys(caseID.get(i));
			Thread.sleep(2000);
			//Clicks on case id
			wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSearchCaseIDDropdownAdmin)).click();
			//Waits for black loading message to disappear
			share2.loadingServer(driver);
			Thread.sleep(1000);
			share.scrollToTop(driver);
			Thread.sleep(1000);
			//Clicks on delete button
			wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseDeleteButton)).click();
			//Clicks on delete case
			wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupTitle)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupConfirmButton)).click();
			//Waits for black loading message to disappear
			share2.loadingServer(driver);
			share.scrollToTop(driver);
			//Checks if case deleted
			wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSearchCaseIDAdmin)).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSearchCaseIDAdmin)).sendKeys(caseID.get(i));
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSearchCaseIDAdmin)).sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			if(driver.findElement(HumanCaseSearchCaseIDDropdownAdmin).isDisplayed()==false)
				System.out.println("Case deleted: "+caseID.get(i));		
			else softly.fail("Case did not get deleted: "+caseID.get(i) );
		}
	}

	public void deleteLinks (WebDriver driver, List<String> cases) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.LoginNameOnTopRight)).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(AdminOption)).click();
		Thread.sleep(1000);
		//Clicks on Errorfree bank option
		if (driver.findElement(HumanCasesLink).isDisplayed()==false)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorFreeBankAdminLink)).click();
		}
		//Clicks on Equipment cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(1000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Enter FM case id with links
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSearchCaseIDAdmin)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSearchCaseIDAdmin)).sendKeys(cases.get(2));
		Thread.sleep(2000);
		//Clicks on case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSearchCaseIDDropdownAdmin)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(2000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Click on Edit
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseEditButton)).click();
		Thread.sleep(2000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Scroll to 2nd Link title
		WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink1Title));
		share.scrollToElement(driver, l);
		//Click on delete link 2 cross symbol of Title
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink1TitleCrossSymbol)).click();
		Thread.sleep(500);
		//Click on delete link 2 cross symbol of URL
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink1URLCrossSymbol)).click();
		Thread.sleep(500);
		//Save case
		Thread.sleep(2000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSaveButton)).click();
		//Clicks on create case
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupConfirmButton)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(1000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Enter FM case id with links
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSearchCaseIDAdmin)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSearchCaseIDAdmin)).sendKeys(cases.get(2));
		Thread.sleep(2000);
		//Clicks on case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSearchCaseIDDropdownAdmin)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(2000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Click on Edit
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseEditButton)).click();
		Thread.sleep(2000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Scroll to 1st Link title
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink1Title));
		share.scrollToElement(driver, l);
		for(int i=1;i<=12;i++)
		{
			//Click on delete link 2 cross symbol of Title
			wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink1TitleCrossSymbol)).click();
			//Click on delete link 2 cross symbol of URL
			wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink1URLCrossSymbol)).click();
			Thread.sleep(500);
		}
		//Save case
		Thread.sleep(2000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSaveButton)).click();
		//Clicks on create case
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupConfirmButton)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(1000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Verify no text from previous links present in text boxes
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink1Title)).getAttribute("textContent");
		softly.assertThat(s).as("test data").isEmpty();
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink1URL)).getAttribute("textContent");
		softly.assertThat(s1).as("test data").isEmpty();
		try{
			WebDriverWait wait1 = new WebDriverWait(driver,3);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink2Title));
			softly.fail("after deleting all links still there is an extra link row visible");
		}catch(org.openqa.selenium.NoSuchElementException |org.openqa.selenium.TimeoutException r)
		{

		}
		//Go back to case browse and verify that no Related Links slide
		//Clicks on Error free bank
		WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorFreeBankTopLink));
		element1.click();
		//Go to Human Performance
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanPerformanceLink)).click();
		Thread.sleep(1000);
		//Browse case 
		//Check for case
		//Enters case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchCaseIdField)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchCaseIdField)).sendKeys(cases.get(2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchCaseIdField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Click on collapsible 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+cases.get(2)))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on Show Slides
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-button-Q"+cases.get(2))));
		WebElement element =  driver.findElement(By.id("pii-slideshow-button-Q"+cases.get(2)));
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
		driver.findElement(By.id("pii-slideshow-Q"+cases.get(2)+"-popup"));
		System.out.println(number);
		//Click on previous
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.SlidePreviousButton)).click();
		//Verify title of Related Links slide doesnt exist
		try{
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-Q"+cases.get(2)+"']/ul/li["+Integer.parseInt(number)+"]/div[2]/div/div"))).getText();
		softly.assertThat(s2).as("test data").doesNotContain("Related Links");
		}catch(org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException t)
		{
			System.out.println("Related links slide not present");
		}
		//Closes the slideshow
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-Q"+cases.get(2)+"']/a"))).click();
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchClearButton)).click();
	}

	public void editLinks (WebDriver driver, List<String> cases) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		CreateEquipmentCase obj1 = new CreateEquipmentCase();
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.LoginNameOnTopRight)).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(AdminOption)).click();
		Thread.sleep(1000);
		//Clicks on Errorfree bank option
		if (driver.findElement(HumanCasesLink).isDisplayed()==false)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorFreeBankAdminLink)).click();
		}
		//Clicks on Human cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(1000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Enter FM case id with links
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSearchCaseIDAdmin)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSearchCaseIDAdmin)).sendKeys(cases.get(2));
		Thread.sleep(2000);
		//Clicks on case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSearchCaseIDDropdownAdmin)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(2000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Click on Edit
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseEditButton)).click();
		//Scroll to 1st Link title
		WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink1Title));
		share.scrollToElement(driver, l);
		//Edit link title
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink1Title)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink1Title)).sendKeys("Edited: "+obj1.videoLinkTitle1);
		//Save case
		Thread.sleep(2000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSaveButton)).click();
		//Clicks on create case
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupTitle));
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupConfirmButton)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(1000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on Error free bank
		wait.until(ExpectedConditions.invisibilityOfElementLocated(HumanCaseAdminPopupConfirmButton));
		WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorFreeBankTopLink));
		element1.click();
		//Go to  Human Performance
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanPerformanceLink)).click();
		Thread.sleep(1000);
		//Check for case
		//Enters case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchCaseIdField)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchCaseIdField)).sendKeys(cases.get(2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchCaseIdField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Click on collapsible 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+cases.get(2)))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on Show Slides
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-button-Q"+cases.get(2))));
		WebElement element =  driver.findElement(By.id("pii-slideshow-button-Q"+cases.get(2)));
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
		driver.findElement(By.id("pii-slideshow-Q"+cases.get(2)+"-popup"));
		System.out.println(number);
		//Click on previous twice
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.SlidePreviousButton)).click();
		//Click on previous
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.SlidePreviousButton)).click();
		int number1 = Integer.parseInt(number)-1;
		//Verify title of Related Links slide
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-Q"+cases.get(2)+"']/ul/li["+number1+"]/div[2]/div/div"))).getText();
		softly.assertThat(s).as("test data").isEqualTo("Related Links");
		//Verify title of 1st link
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-Q"+cases.get(2)+"']/ul/li["+number1+"]/div[2]/div[2]"))).getText();
		softly.assertThat(s1).as("test data").contains("1. Video");
		softly.assertThat(s1).as("test data").contains("Edited: "+obj1.videoLinkTitle1);
		//Closes the slideshow
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-Q"+cases.get(2)+"']/a"))).click();
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchClearButton)).click();
	}

	public void viewCaseInAdmin(WebDriver driver, List<String> caseID, String keyword_same) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,40);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.LoginNameOnTopRight)).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(AdminOption)).click();
		Thread.sleep(1000);
		//Clicks on Errorfree bank option
		if (driver.findElement(HumanCasesLink).isDisplayed()==false)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorFreeBankAdminLink)).click();
		}
		//Clicks on Human cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(1000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//CLick on enter case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSearchCaseIDAdmin)).sendKeys(caseID.get(3));
		Thread.sleep(2000);
		//Clicks on case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSearchCaseIDDropdownAdmin)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(1000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Click on Edit
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseEditButton)).click();
		Thread.sleep(2000);
		//Scroll down
		jse.executeScript("scroll(0,2000)");
		Thread.sleep(1000);
		//Remove old task
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseExistingTaskOnlyOne)).click();
		Thread.sleep(2000);
		//Clicks on remove keyword
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupConfirmButton)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(2000);
		//Scroll down
		jse.executeScript("scroll(0,2000)");
		Thread.sleep(1000);
		//Add new task
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseTaskNewField)).sendKeys(keyword_same+"changed");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseTaskNewAddButton)).click();
		//Remove old purpose
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseExistingPurposeOnlyOne)).click();
		Thread.sleep(2000);
		//Clicks on remove keyword
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupConfirmButton)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(2000);
		//Scroll down
		jse.executeScript("scroll(0,2000)");
		Thread.sleep(1000);
		//Add new purpose
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasePurposeNewField)).sendKeys(keyword_same+"changed");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasePurposeNewAddButton)).click();
		//Scroll down
		jse.executeScript("scroll(0,2000)");
		Thread.sleep(1000);
		//Remove old condition
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseExistingConditionOnlyOne)).click();
		Thread.sleep(4000);
		//Clicks on remove keyword
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupConfirmButton)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(2000);
		//Scroll down
		jse.executeScript("scroll(0,2000)");
		Thread.sleep(1000);
		//Add new condition
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseConditionNewField)).sendKeys(keyword_same+"changed");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseConditionNewAddButton)).click();
		//Scroll up
		Thread.sleep(1000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSaveButton)).click();
		//Clicks on create case
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupConfirmButton)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(1000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Enter case id with links
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSearchCaseIDAdmin)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSearchCaseIDAdmin)).sendKeys(caseID.get(2));
		Thread.sleep(2000);
		//Clicks on case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSearchCaseIDDropdownAdmin)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(1000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Enter case id without links
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSearchCaseIDAdmin)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSearchCaseIDAdmin)).sendKeys(caseID.get(3));
		Thread.sleep(2000);
		//Clicks on case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSearchCaseIDDropdownAdmin)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(1000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Verify all fields
		verifyCaseFieldsInAdmin(driver, keyword_same);
		//Click on Edit
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseEditButton)).click();
		Thread.sleep(2000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSaveButton)).click();
		//Clicks on create case
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupConfirmButton)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(1000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Verify all fields
		verifyCaseFieldsInAdmin(driver, keyword_same);
		//Verify new case form after viewing case with links
		verifyNewCaseForm(driver, caseID.get(2));
	}

	public void verifyNewCaseForm(WebDriver driver, String caseID) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,40);
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.LoginNameOnTopRight)).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(AdminOption)).click();
		Thread.sleep(1000);
		//Clicks on Errorfree bank option
		if (driver.findElement(HumanCasesLink).isDisplayed()==false)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorFreeBankAdminLink)).click();
		}
		//Clicks on Human cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink)).click();
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSearchCaseIDAdmin)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSearchCaseIDAdmin)).sendKeys(caseID);
		Thread.sleep(2000);
		//Clicks on case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSearchCaseIDDropdownAdmin)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(1000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on new case button
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseNewButton)).click();
		//Clicks on new case
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupConfirmButton)).click();
		//Verify Link title is empty
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink1Title)).getAttribute("textContent");
		softly.assertThat(s).as("test data").isEmpty();
		//Verify Link url is empty
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink1URL)).getAttribute("textContent");
		softly.assertThat(s1).as("test data").isEmpty();
		Thread.sleep(1000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on Human cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
	}

	public void verifyCaseFieldsInAdmin(WebDriver driver, String keyword_same) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify Link title is empty
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink1Title)).getAttribute("textContent");
		softly.assertThat(s).as("test data").isEmpty();
		//Verify Link url is empty
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink1URL)).getAttribute("textContent");
		softly.assertThat(s1).as("test data").isEmpty();
		//Verify task
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseExistingTaskOnlyOne)).getText();
		softly.assertThat(s2).as("test data").isEqualTo(keyword_same+"changed");
		//Verify purpose
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseExistingPurposeOnlyOne)).getText();
		softly.assertThat(s3).as("test data").isEqualTo(keyword_same+"changed");
		//Verify condition
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseExistingConditionOnlyOne)).getText();
		softly.assertThat(s4).as("test data").isEqualTo(keyword_same+"changed");
		//Verify keyword
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseExistingKeywordOnlyOne)).getText();
		softly.assertThat(s5).as("test data").isEqualTo(keyword_same);
	}

	public void addLinks(WebDriver driver, String title, String caseID) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		CreateEquipmentCase obj = new CreateEquipmentCase();
		//Scroll to Link element
		WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink1Title));
		share.scrollToElement(driver, l);
		//Enter title for link 1
		l.sendKeys(obj.noVideoLinkTitle3);
		//Scroll to element
		share.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink1URL)));
		//Enter url 3
		wait.until(ExpectedConditions.elementToBeClickable(HumanCasesLink1URL)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink1URL)).sendKeys(obj.noVideoLink);	
		//To make url form appear click on title for link 1
		obj.clickToShowNextRowForLink(driver,HumanCasesLink1Title);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Scroll to link 2
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink2Title));
		share.scrollToElement(driver, l);
		//Enter title for link 2 banana
		l.sendKeys(obj.noVideoLinkTitle2);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink2URL)).click();
		//Link 2 becomes Link 1
		//Enter url 2
		wait.until(ExpectedConditions.elementToBeClickable(HumanCasesLink1URL)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink1URL)).sendKeys(obj.noVideoLink);
		//To make url form appear click on title for link
		obj.clickToShowNextRowForLink(driver,HumanCasesLink1Title);
		share.scrollToTop(driver);
		//Scroll to link 3
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink3Title));
		share.scrollToElement(driver, l);
		//Enter title for link 1 apple
		l.sendKeys(obj.noVideoLinkTitle1);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink3URL)).click();
		//Link 3 becomes Link 1
		//Enter url 3
		wait.until(ExpectedConditions.elementToBeClickable(HumanCasesLink1URL)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink1URL)).sendKeys(obj.noVideoLink);
		//To make url form appear click on title for link
		obj.clickToShowNextRowForLink(driver,HumanCasesLink1Title);
		share.scrollToTop(driver);
		//Enter title for link 4 : video link 1
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink4Title));
		share.scrollToElement(driver, l);
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink4Title)).sendKeys(obj.videoLinkTitle1);
		Thread.sleep(1000);
		//Enter url 4
		wait.until(ExpectedConditions.elementToBeClickable(HumanCasesLink4URL)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink4URL)).sendKeys(obj.videoLink);
		//Move to video checkbox
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink4VideoCheckbox));
		share.scrollToElement(driver, l);
		//Click on video checkbox
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink4VideoCheckbox)).click();
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink4VideoCheckbox));
		share.scrollToElement(driver, l);
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink4VideoCheckbox)).click();
		Thread.sleep(1000);
		//verify video link became the first link
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink1Title)).getAttribute("value");
		softly.assertThat(s).as("test data").contains(obj.videoLinkTitle1);
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink1URL)).getAttribute("value");
		softly.assertThat(s1).as("test data").contains(obj.videoLink);
		//Enter title for link 5 : video link 2
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink5Title));
		share.scrollToElement(driver, l);
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink5Title)).sendKeys(obj.videoLinkTitle2);	
		Thread.sleep(1000);
		//Enter url 5
		wait.until(ExpectedConditions.elementToBeClickable(HumanCasesLink5URL)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink5URL)).sendKeys(obj.videoLink);
		//Move to viedo checkbox
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink5VideoCheckbox));
		share.scrollToElement(driver, l);
		//Click on video checkbox
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink5VideoCheckbox)).click();
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink5VideoCheckbox));
		share.scrollToElement(driver, l);
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink5VideoCheckbox)).click();
		Thread.sleep(1000);
		//verify video link became the first link
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink2Title)).getAttribute("value");
		softly.assertThat(s3).as("test data").contains(obj.videoLinkTitle2);
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink2URL)).getAttribute("value");
		softly.assertThat(s4).as("test data").contains(obj.videoLink);
		//Enter title for link 6 : video link 3
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink6Title));
		share.scrollToElement(driver, l);
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink6Title)).sendKeys(obj.videoLinkTitle3);	
		Thread.sleep(1000);
		//Enter url 6
		wait.until(ExpectedConditions.elementToBeClickable(HumanCasesLink6URL)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink6URL)).sendKeys(obj.videoLink);
		//Move to viedo checkbox
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink6VideoCheckbox));
		share.scrollToElement(driver, l);
		//Click on video checkbox
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink6VideoCheckbox)).click();
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink6VideoCheckbox));
		share.scrollToElement(driver, l);
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink6VideoCheckbox)).click();
		Thread.sleep(1000);
		//verify video link became the first link
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink3Title)).getAttribute("value");
		softly.assertThat(s5).as("test data").contains(obj.videoLinkTitle3);
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink3URL)).getAttribute("value");
		softly.assertThat(s6).as("test data").contains(obj.videoLink);
		//Scroll to link 7
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink7Title));
		share.scrollToElement(driver, l);
		//Enter title for link 7
		l.sendKeys(obj.noVideoLinkTitle4);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink7URL)).click();
		//Enter url 7
		wait.until(ExpectedConditions.elementToBeClickable(HumanCasesLink7URL)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink7URL)).sendKeys(obj.noVideoLink);
		//To make url form appear click on title for link
		obj.clickToShowNextRowForLink(driver,HumanCasesLink7Title);
		share.scrollToTop(driver);
		//Scroll to link 8
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink8Title));
		share.scrollToElement(driver, l);
		//Enter title for link 8
		l.sendKeys(obj.noVideoLinkTitle5);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink8URL)).click();
		//Enter url 8
		wait.until(ExpectedConditions.elementToBeClickable(HumanCasesLink8URL)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink8URL)).sendKeys(obj.noVideoLink);
		//To make url form appear click on title for link
		obj.clickToShowNextRowForLink(driver,HumanCasesLink8Title);
		share.scrollToTop(driver);
		//Scroll to link 9
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink9Title));
		share.scrollToElement(driver, l);
		//Enter title for link 9
		l.sendKeys(obj.noVideoLinkTitle6);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink9URL)).click();
		//Enter url 9
		wait.until(ExpectedConditions.elementToBeClickable(HumanCasesLink9URL)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink9URL)).sendKeys(obj.noVideoLink);
		//To make url form appear click on title for link
		obj.clickToShowNextRowForLink(driver,HumanCasesLink9Title);
		share.scrollToTop(driver);
		//Scroll to link 10
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink10Title));
		share.scrollToElement(driver, l);
		//Enter title for link 10
		l.sendKeys(obj.noVideoLinkTitle7);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink10URL)).click();
		//Enter url 10
		wait.until(ExpectedConditions.elementToBeClickable(HumanCasesLink10URL)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink10URL)).sendKeys(obj.noVideoLink);
		//To make url form appear click on title for link
		obj.clickToShowNextRowForLink(driver,HumanCasesLink10Title);
		share.scrollToTop(driver);
		//Scroll to link 11
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink11Title));
		share.scrollToElement(driver, l);
		//Enter title for link 11
		l.sendKeys(obj.noVideoLinkTitle8);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink11URL)).click();
		//Enter url 11
		wait.until(ExpectedConditions.elementToBeClickable(HumanCasesLink11URL)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink11URL)).sendKeys(obj.noVideoLink);
		//To make url form appear click on title for link
		obj.clickToShowNextRowForLink(driver,HumanCasesLink11Title);
		share.scrollToTop(driver);
		//Scroll to link 12
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink12Title));
		share.scrollToElement(driver, l);
		//Enter title for link 12
		l.sendKeys(obj.noVideoLinkTitle9);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink12URL)).click();
		//Enter url 12
		wait.until(ExpectedConditions.elementToBeClickable(HumanCasesLink12URL)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink12URL)).sendKeys(obj.noVideoLink);
		//To make url form appear click on title for link
		obj.clickToShowNextRowForLink(driver,HumanCasesLink12Title);
		share.scrollToTop(driver);
		//Scroll to link 13
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink13Title));
		share.scrollToElement(driver, l);
		//Enter title for link 11
		l.sendKeys(obj.noVideoLinkTitle10);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink13URL)).click();
		//Enter url 11
		wait.until(ExpectedConditions.elementToBeClickable(HumanCasesLink13URL)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink13URL)).sendKeys(obj.noVideoLink);
		//To make url form appear click on title for link
		obj.clickToShowNextRowForLink(driver,HumanCasesLink13Title);
		share.scrollToTop(driver);
	}

	public void searchCaseWithLinks(WebDriver driver, String keyword, List<String>cases)throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,10);
		CreateEquipmentCase obj2 = new CreateEquipmentCase();
		//Clicks on Error free bank
		WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorFreeBankTopLink));
		element1.click();
		//Go to  FM
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanPerformanceLink)).click();
		Thread.sleep(1000);
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchClearButton)).click();
		//Check for case
		//Enters case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchKeywordField)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchKeywordField)).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchKeywordField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Click on collapsible 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+cases.get(2)))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Get window id
		String window = driver.getWindowHandle();
		//Clicks on Show Slides
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-button-Q"+cases.get(2))));
		WebElement element =  driver.findElement(By.id("pii-slideshow-button-Q"+cases.get(2)));
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
		driver.findElement(By.id("pii-slideshow-Q"+cases.get(2)+"-popup"));
		System.out.println(number);
		//Click on previous
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.SlidePreviousButton)).click();
		//Verify title of Related Links slide
		int number1 = Integer.parseInt(number)-1;
		//Verify title of 1st link with no video
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-Q"+cases.get(2)+"']/ul/li["+Integer.parseInt(number)+"]/div[2]/div[2]"))).getText();
		softly.assertThat(s10).as("test data").contains("10. ");
		softly.assertThat(s10).as("test data").contains(obj2.noVideoLinkTitle7);
		//Verify title of 2nd link with no video
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-Q"+cases.get(2)+"']/ul/li["+Integer.parseInt(number)+"]/div[2]/div[3]"))).getText();
		softly.assertThat(s11).as("test data").contains("11. ");
		softly.assertThat(s11).as("test data").contains(obj2.noVideoLinkTitle8);
		//Verify title of 3rd link with no video
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-Q"+cases.get(2)+"']/ul/li["+Integer.parseInt(number)+"]/div[2]/div[4]"))).getText();
		softly.assertThat(s12).as("test data").contains("12. ");
		softly.assertThat(s12).as("test data").contains(obj2.noVideoLinkTitle9);
		//Verify title of 4th link with no video
		String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-Q"+cases.get(2)+"']/ul/li["+Integer.parseInt(number)+"]/div[2]/div[5]"))).getText();
		softly.assertThat(s13).as("test data").contains("13. ");
		softly.assertThat(s13).as("test data").contains(obj2.noVideoLinkTitle10);
		String s14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-Q"+cases.get(2)+"']/ul/li["+Integer.parseInt(number)+"]/div[2]/div/div"))).getText();
		softly.assertThat(s14).as("test data").isEqualTo("Related Links");
		//Click on 1st link
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-Q"+cases.get(2)+"']/ul/li["+Integer.parseInt(number)+"]/div[2]/div[2]/a"))).click();
		Thread.sleep(2000);
		//Switch window
		obj2.switchWindow(driver,window);
		//Click on previous
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.SlidePreviousButton)).click();
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-Q"+cases.get(2)+"']/ul/li["+number1+"]/div[2]/div/div"))).getText();
		softly.assertThat(s).as("test data").isEqualTo("Related Links");
		//Verify title of 1st link with video
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-Q"+cases.get(2)+"']/ul/li["+number1+"]/div[2]/div[2]"))).getText();
		softly.assertThat(s1).as("test data").contains("1. Video: ");
		softly.assertThat(s1).as("test data").contains(obj2.videoLinkTitle1);
		//Verify title of 2nd link with video
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-Q"+cases.get(2)+"']/ul/li["+number1+"]/div[2]/div[3]"))).getText();
		softly.assertThat(s2).as("test data").contains("2. Video: ");
		softly.assertThat(s2).as("test data").contains(obj2.videoLinkTitle2);
		//Verify title of 3rd link with video
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-Q"+cases.get(2)+"']/ul/li["+number1+"]/div[2]/div[4]"))).getText();
		softly.assertThat(s3).as("test data").contains("3. Video: ");
		softly.assertThat(s3).as("test data").contains(obj2.videoLinkTitle3);
		//Verify title of 4th link with no video
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-Q"+cases.get(2)+"']/ul/li["+number1+"]/div[2]/div[5]"))).getText();
		softly.assertThat(s4).as("test data").contains("4. ");
		softly.assertThat(s4).as("test data").contains(obj2.noVideoLinkTitle1);
		//Verify title of 5th link with no video
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-Q"+cases.get(2)+"']/ul/li["+number1+"]/div[2]/div[6]"))).getText();
		softly.assertThat(s5).as("test data").contains("5. ");
		softly.assertThat(s5).as("test data").contains(obj2.noVideoLinkTitle2);
		//Verify title of 6th link with no video
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-Q"+cases.get(2)+"']/ul/li["+number1+"]/div[2]/div[7]"))).getText();
		softly.assertThat(s6).as("test data").contains("6. ");
		softly.assertThat(s6).as("test data").contains(obj2.noVideoLinkTitle3);
		//Verify title of 4th link with no video
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-Q"+cases.get(2)+"']/ul/li["+number1+"]/div[2]/div[8]"))).getText();
		softly.assertThat(s7).as("test data").contains("7. ");
		softly.assertThat(s7).as("test data").contains(obj2.noVideoLinkTitle4);
		//Verify title of 5th link with no video
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-Q"+cases.get(2)+"']/ul/li["+number1+"]/div[2]/div[9]"))).getText();
		softly.assertThat(s8).as("test data").contains("8. ");
		softly.assertThat(s8).as("test data").contains(obj2.noVideoLinkTitle5);
		//Verify title of 6th link with no video
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-Q"+cases.get(2)+"']/ul/li["+number1+"]/div[2]/div[10]"))).getText();
		softly.assertThat(s9).as("test data").contains("9. ");
		softly.assertThat(s9).as("test data").contains(obj2.noVideoLinkTitle6);
		Thread.sleep(2000);
		//Click on 1st link
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-Q"+cases.get(2)+"']/ul/li["+number1+"]/div[2]/div[2]/a"))).click();
		Thread.sleep(2000);
		//Switch window
		obj2.switchWindow(driver,window);
		//Click on 2nd link
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-Q"+cases.get(2)+"']/ul/li["+number1+"]/div[2]/div[5]/a"))).click();
		Thread.sleep(2000);
		//Switch window
		obj2.switchWindow(driver,window);
		//Closes the slideshow
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-Q"+cases.get(2)+"']/a"))).click();
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchClearButton)).click();
	}

	public List<String> createCaseHumanChrome (WebDriver driver, int m, String title, String keyword_same, String key1, String key2, String key3) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,40);  
		List<String> caseID = new ArrayList<String>();
		CaseBrowse obj = new CaseBrowse();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.LoginNameOnTopRight)).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(AdminOption)).click();
		//Clicks on Errorfree bank option
		if(m==0)
			wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorFreeBankAdminLink)).click();
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
			share2.loadingServer(driver);
			Thread.sleep(1000);
			share.scrollToTop(driver);
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
			share.scrollToTop(driver);
			Thread.sleep(1000);
			if(count==1)
				checkForErrorWithoutUploadingSlides(driver);
			//Uploads 5 slides
			wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseImageInputField)).click();
			Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlides.exe");
			p.waitFor();
			Thread.sleep(3000);
			//Checks if 5 images have been uploaded
			if(count==1)
				wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseImageInputCollapsible)).click();
			if(count==1)
				checkNoError(driver);
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
			if(count==1)
			{
				share.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseImageInputCollapsible)));
				//Click on collapsible
				wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseImageInputCollapsible)).click();
			}
			//Add links in case number 3 
			if(count==3)
			{
				addLinks(driver,title,caseId);
			}
			share.scrollToTop(driver);
			Thread.sleep(1000);
			//Clicks on save
			wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSaveButton)).click();
			//Clicks on create case
			wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupTitle)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupConfirmButton)).click();
			//Waits for black loading message to disappear
			share2.loadingServer(driver);
			share2.loadingServer(driver);
		}
		return caseID;
	}

	public List<String> createCaseHumanFirefox (WebDriver driver, int m, String title, String keyword_same, String key1, String key2, String key3) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,40);  
		List<String> caseID = new ArrayList<String>();
		CaseBrowse obj = new CaseBrowse();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.LoginNameOnTopRight)).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(AdminOption)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(1000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on Errorfree bank option
		if(m==0)
			wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorFreeBankAdminLink)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(1000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on Human cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(1000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Creates 5 cases
		//Enters mandatory data
		//Enters case id
		Random random = new Random();
		String caseId="";
		for(int count=1;count<=5;count++)
		{
			//Waits for black loading message to disappear
			share2.loadingServer(driver);
			Thread.sleep(1000);
			share.scrollToTop(driver);
			Thread.sleep(1000);
			//Clicks on new case button
			wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseNewButton)).click();
			//Clicks on new case
			wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupTitle)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupConfirmButton)).click();
			//Waits for black loading message to disappear
			share2.loadingServer(driver);
			Thread.sleep(1000);
			share.scrollToTop(driver);
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
			share.scrollToTop(driver);
			Thread.sleep(1000);
			if(count==1)
				checkForErrorWithoutUploadingSlides(driver);
			//Uploads 5 slides
			wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseImageInputField)).click();
			Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlides_Firefox.exe");
			p.waitFor();
			Thread.sleep(3000);
			//Checks if 5 images have been uploaded
			if(count==1)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseImageInputCollapsible)).click();if(count==1)
				checkNoError(driver);
			}
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
			//Add links in case number 3 
			if(count==3)
			{
				addLinks(driver,title,caseId);
			}
			share.scrollToTop(driver);
			Thread.sleep(1000);
			//Clicks on save
			wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSaveButton)).click();
			//Clicks on create case
			wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupTitle)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupConfirmButton)).click();
			//Waits for black loading message to disappear
			share2.loadingServer(driver);
			share2.loadingServer(driver);
			Thread.sleep(1000);
			share.scrollToTop(driver);
			Thread.sleep(1000);
		}
		return caseID;
	}

	public List<String> createCaseHumanIE10 (WebDriver driver, int m, String title, String keyword_same, String key1, String key2, String key3) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,40);  
		List<String> caseID = new ArrayList<String>();
		CaseBrowse obj = new CaseBrowse();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.LoginNameOnTopRight)).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(AdminOption)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		share2.loadingServer(driver);
		Thread.sleep(1000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on Errorfree bank option
		if(m==0)
			wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorFreeBankAdminLink)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(1000);
		share.scrollToTop(driver);
		Thread.sleep(1000);

		//Creates 5 cases
		//Enters mandatory data
		//Enters case id
		Random random = new Random();
		String caseId="";
		for(int count=1;count<=5;count++)
		{
			//Waits for black loading message to disappear
			share2.loadingServer(driver);
			share2.loadingServer(driver);
			//Clicks on Human cases
			wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink)).click();
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
			//Clicks on new case button
			wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseNewButton)).click();
			Thread.sleep(1000);
			//Clicks on new case
			wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupTitle)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupConfirmButton)).click();
			Thread.sleep(1000);
			//Waits for black loading message to disappear
			share2.loadingServer(driver);
			share2.loadingServer(driver);
			Thread.sleep(1000);
			share.scrollToTop(driver);
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
			share.scrollToTop(driver);
			Thread.sleep(1000);
			if(count==1)
				checkForErrorWithoutUploadingSlides(driver);
			//Uploads 5 slides
			/*  WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseImageInputField));
		  Actions act= new Actions(driver);
		  act.doubleClick(ele).build().perform();*/
			jse.executeScript("return document.getElementById('pii-admin-efsh-upload-file-input').click();");
			Thread.sleep(3000);
			Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlides_IE10.exe");
			p.waitFor();
			Thread.sleep(3000);
			//Checks if 5 images have been uploaded
			wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseImageInputCollapsible)).click();
			if(count==1)
				checkNoError(driver);
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
			//Add links in case number 3 
			if(count==3)
			{
				addLinks(driver,title,caseId);
			}
			share.scrollToTop(driver);
			Thread.sleep(1000);
			//Clicks on save
			wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSaveButton)).click();
			Thread.sleep(1000);
			//Clicks on create case
			wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupTitle));
			wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupConfirmButton)).click();
			Thread.sleep(1000);
			//Waits for black loading message to disappear
			share2.loadingServer(driver);
			share2.loadingServer(driver);
			Thread.sleep(1000);
			share.scrollToTop(driver);
			Thread.sleep(1000);
		}
		return caseID;
	}

	public List<String> createCaseHumanIE11 (WebDriver driver, int m, String title, String keyword_same, String key1, String key2, String key3) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,40);  
		List<String> caseID = new ArrayList<String>();
		CaseBrowse obj = new CaseBrowse();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.LoginNameOnTopRight)).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(AdminOption)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(1000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on Errorfree bank option
		if(m==0)
			wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorFreeBankAdminLink)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(1000);
		share.scrollToTop(driver);
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
			share2.loadingServer(driver);
			Thread.sleep(1000);
			share.scrollToTop(driver);
			Thread.sleep(1000);
			//Waits for black loading message to disappear
			share2.loadingServer(driver);
			Thread.sleep(1000);
			share.scrollToTop(driver);
			Thread.sleep(1000);
			//Clicks on new case button
			wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseNewButton)).click();
			//Clicks on new case
			wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupTitle)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupConfirmButton)).click();
			//Waits for black loading message to disappear
			share2.loadingServer(driver);
			share2.loadingServer(driver);
			Thread.sleep(1000);
			share.scrollToTop(driver);
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
				Thread.sleep(1000);
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
			share.scrollToTop(driver);
			Thread.sleep(1000);
			if(count==1)
				checkForErrorWithoutUploadingSlides(driver);
			//Uploads 5 slides
			//wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseImageInputField)).click();
			jse.executeScript("return document.getElementById('pii-admin-efsh-upload-file-input').click();");
			Thread.sleep(3000);
			Process p =Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/UploadHumanCaseSlides_IE10.exe");
			p.waitFor();
			Thread.sleep(3000);
			//Checks if 5 images have been uploaded
			wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseImageInputCollapsible)).click();
			if(count==1)
				checkNoError(driver);
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
			//Add links in case number 3 
			if(count==3)
			{
				addLinks(driver,title,caseId);
			}
			share.scrollToTop(driver);
			Thread.sleep(1000);
			//Clicks on save
			wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSaveButton)).click();
			//Clicks on create case
			wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupTitle)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupConfirmButton)).click();
			//Waits for black loading message to disappear
			share2.loadingServer(driver);
			share2.loadingServer(driver);
			Thread.sleep(1000);
			share.scrollToTop(driver);
			Thread.sleep(1000);
		}
		return caseID;
	}

	public void changeKeywordKALE1969(WebDriver driver, List<String> caseID, String keyword_same) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.LoginNameOnTopRight)).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(AdminOption)).click();
		Thread.sleep(1000);
		//Clicks on Errorfree bank option
		if (driver.findElement(HumanCasesLink).isDisplayed()==false)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorFreeBankAdminLink)).click();
		}
		//Clicks on Human cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCasesLink)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(1000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//CLick on enter case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSearchCaseIDAdmin)).sendKeys(caseID.get(1));
		Thread.sleep(2000);
		//Clicks on case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSearchCaseIDDropdownAdmin)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(1000);
		share.scrollToTop(driver);
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
		share2.loadingServer(driver);
		Thread.sleep(2000);
		//Scroll down
		jse.executeScript("scroll(0,2000)");
		Thread.sleep(1000);
		//Add new keyword
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewField)).sendKeys(keyword_same+"changed");
		Thread.sleep(1500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseKeywordNewAddButton)).click();
		Thread.sleep(1000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseSaveButton)).click();
		//Clicks on create case
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(HumanCaseAdminPopupConfirmButton)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(1000);
		share.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on Error free bank
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorFreeBankTopLink)).click();
		}catch (UnhandledAlertException f){			  
			driver.switchTo().alert().dismiss();
		}
		//Clicks on Human Performance Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanPerformanceLink)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		//Checks for search method with magnifying glass
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchKeywordField)).sendKeys(keyword_same+"changed");
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchKeywordFieldSearchButton)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanPerformanceLink)).click();
		//Look for case id
		obj.browseCaseIDHuman(driver, caseID.get(0), title);		  
	}

	public void checkkeyword (WebDriver driver, List<String> caseID, String keyword_same, String key1, String key2, String key3, String title) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,40);
		//Enters the term and check the search by enter
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchClearButton)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchKeywordField)).sendKeys(keyword_same);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchKeywordField)).sendKeys(Keys.ENTER);
		share2.loadingServer(driver);
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchClearButton)).click();
		//Enters the term with 3 unique keywords
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchKeywordField)).sendKeys(key1);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchKeywordField)).sendKeys(Keys.ENTER);
		//Checks for the case id 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+caseID.get(0))));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchClearButton)).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchKeywordField)).sendKeys(key2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchKeywordField)).sendKeys(Keys.ENTER);
		//Checks for the case id 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+caseID.get(0))));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchClearButton)).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchKeywordField)).sendKeys(key3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchKeywordField)).sendKeys(Keys.ENTER);
		//Checks for the case id 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+caseID.get(0))));
		Thread.sleep(1000);
		//Enters the title and check the search by enter
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchClearButton)).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchKeywordField)).sendKeys(title);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchKeywordField)).sendKeys(Keys.ENTER);
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchClearButton)).click();		  
	}

	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}

}