import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class EiRCABug {
	
	SoftAssertions softly = new SoftAssertions();
	
	EiRCA2 eirca2 = new EiRCA2();
	ShareCheck share = new ShareCheck();
	EiRCAPageObj eirca = new EiRCAPageObj();
	
	String textFillBug = "EiRCA bug";
	
	public void EiRCAInfoPageFill(WebDriver driver, String text) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Event title
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAEventTitleField)).sendKeys(text);
		//Event id
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAEventIdField)).sendKeys(text);
		//Location of event
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAEventLocationField)).sendKeys(text);
		//Problem Statement
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAEventProblemStatementField)).sendKeys(text);
		//Component
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAEventComponentField)).sendKeys(text);
		//Reporter
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAEventReporterField)).sendKeys(text);
		//Investigators
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAEventInvestigatorField)).sendKeys(text);
		//Reviewer
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAEventReviewerField)).sendKeys(text);
		//Sponsor
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAEventSponsorField)).sendKeys(text);
		share.scrollToAPoint(driver, 1500);
		//Clicks on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.NextButtonBottomOfInfoPage)).click();
		//Scroll top
		share.scrollToTop(driver);	
	}	
	
	public void EiRCABugKALE2157QAA624(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);				
		//Click next on sequence of events
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
		//Fill step 1
		eirca2.EIRCAStep1Troubleshooting(driver, textFillBug, softly);
		//Select Troubleshooting
		WebElement dropdown1 = driver.findElement(eirca.Step1Q11Answer);
		Select s1 = new Select(dropdown1);
		s1.selectByIndex(1);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
		//Add 2 failure modes
		//Fill text in 1st box 1st row
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step2Row11stTextBoxField)).sendKeys("EiRCA FM 1");
		//Click on add failure mode button
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step2AddFailureButton)).click();
		//Fill text in 2nd row
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step2Row21stTextBoxField)).sendKeys("EiRCA FM 2");
		Thread.sleep(1000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();		
		//Click on failure mode 1 collapsible in Step 3
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3FailureCollapsible)).click();
		//Click on 3.1 for FM 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption31CheckBox)).click();
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();	
		//Click on collapsible in Step 4
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureCollapsible)).click();
		//Click on 4.4 checkbox
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4TableOption44CheckBox)).click();
		//Enter text
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureModeOption44Textbox)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureModeOption44Textbox)).sendKeys(textFillBug);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();	
		//Click on continue
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAConfirmButton)).click();
		Thread.sleep(1000);
		//Click on Step 3
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep3Tab)).click();
		//Click on collapsible
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3FailureCollapsible)).click();
		//Click on 3.1 for FM 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption31CheckBox)).click();
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
		//Verify 4.4 is greyed out for FM 1
		//Click on collapsible for FM 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureCollapsible)).click();
		//Verify 4.4 text is greyed out
		if(wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureMode1Option44Row)).getAttribute("class").contains("ui-state-disabled")==false)
			softly.fail("Text for 4.4 is not greyed out FM 1");
		//Verify 4.4 check is not visible
		if(driver.findElement(eirca.Step4FailureMode1Option44CheckBox).isDisplayed()==true)
			softly.fail("Check box for 4.4 is visible for FM 1");
		//Verify 4.4 textbox is not visible
		if(driver.findElement(eirca.Step4FailureMode1Option44TextBox).isDisplayed()==true)
			softly.fail("Textbox for 4.4 is visible for FM 1");
		//Click on collapsible for FM 1
		share.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureCollapsible)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureCollapsible)).click();
		Thread.sleep(500);
		//Click on collapsible for FM 2
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureCollapsibleFailureMode2)).click();
		Thread.sleep(500);
		//Verify 4.4 text is greyed out
		if(wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureMode2Option44Row)).getAttribute("class").contains("ui-state-disabled")==false)
			softly.fail("Text for 4.4 is not greyed out FM 2");
		//Verify 4.4 check is not visible
		if(driver.findElement(eirca.Step4FailureMode2Option44CheckBox).isDisplayed()==true)
			softly.fail("Check box for 4.4 is visible for FM 2");
		//Verify 4.4 textbox is not visible
		if(driver.findElement(eirca.Step4FailureMode2Option44TextBox).isDisplayed()==true)
			softly.fail("Textbox for 4.4 is visible for FM 2");
		//Click on collapsible for FM 2
		share.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureCollapsibleFailureMode2)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureCollapsibleFailureMode2)).click();
		//scroll up
		share.scrollToTop(driver);
	}
	
	public void EiRCABugPath(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on Analysis
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.AnalysisLink)).click();
		//Clicks on EiRCA
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCALink)).click();
		Thread.sleep(2000);
		//Fill info page and clicks next
		EiRCAInfoPageFill(driver, textFillBug);
		//KALE 2157 or QAA 624 : 4.4 selection still visible when changing answer from 1 Unrefuted to 2 Unrefuted Failure Modes
		EiRCABugKALE2157QAA624(driver);
	}	

	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}
}
