import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class OPiRCA2 {
	
	//Info Page
	By OPiRCAPopupNote = By.id("pii-opa-dialog-note");
	By NewButton = By.id("efi-opa-button-new");
	By EventTitleError = By.id("pii-opa-event-title-error");
	By EventLocationError = By.id("pii-opa-event-location-error");
	By ProblemStatementError = By.id("pii-opa-event-pbstatement-error");
	By TimelineOfEventsError = By.id("pii-opa-event-events-error");
	By BackgroundInfoError = By.id("pii-opa-event-bginfos-error");
	By InvestigatorError = By.id("pii-opa-event-investigators-error");
	
	public void verifyStickySaveReport(WebDriver driver, SoftAssertions softly, String username, String reportTitle, int n) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,60);
		EiRCA obj = new EiRCA ();
		try{
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.StickyNote)).getText();
		String r = s.replaceAll("\u00AD", "");
		softly.assertThat(r).as("test data").contains(username+"_"+reportTitle);
		if(n == 0)
			softly.assertThat(r).as("test data").contains("Object created for id: ");
		else
			softly.assertThat(r).as("test data").contains("O&P iRCA™ Data updated for id: ");
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.StickyClose)).click();
		}catch(org.openqa.selenium.TimeoutException r)
		{
			System.out.println("Couldn't find save pop up");
		}
	}
	
	public void verifyStickyDeleteReport(WebDriver driver, SoftAssertions softly, String recordName) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,60);
		EiRCA obj = new EiRCA ();
		try{
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.StickyNote)).getText();
		String r = s.replaceAll("\u00AD", "");
		String r1 = recordName.replaceAll("\u00AD", "");
		softly.assertThat(r).as("test data").isEqualTo("O&P iRCA™ data deleted: "+r1);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.StickyClose)).click();
		}catch(org.openqa.selenium.TimeoutException r)
		{
			System.out.println("Couldn't find delete pop up");
		}
	}

	public void verifyErrorMessagesInfoPage(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		OPiRCA obj = new OPiRCA ();		
		//Click on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.OPiRCASaveButton)).click();
		Thread.sleep(1000);
		verifyInfoPageErrorPopup(driver,softly);
		//Click on ok
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.OPiRCASaveConfirmButton)).click();
		Thread.sleep(1000);
		//Verify errors
		//Event title
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(EventTitleError)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Event title is required");
		//Location of event
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(EventLocationError)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Location of event is required");
		//Problem statement
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(ProblemStatementError)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Problem statement is required");
		//Timeline
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(TimelineOfEventsError)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("Timeline of event is required");
		//Background
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(BackgroundInfoError)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Background information is required");
		//investigator
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(InvestigatorError)).getText();
		softly.assertThat(s5).as("test data").isEqualTo("Investigators is required");
	}
	
	public void verifyNoErrorsOnInfoPage(WebDriver driver)throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify no errors
		//Event title
		wait.until(ExpectedConditions.invisibilityOfElementLocated(EventTitleError));
		//Location of event
		wait.until(ExpectedConditions.invisibilityOfElementLocated(EventLocationError));
		//Problem statement
		wait.until(ExpectedConditions.invisibilityOfElementLocated(ProblemStatementError));
		//Failed component
		wait.until(ExpectedConditions.invisibilityOfElementLocated(TimelineOfEventsError));
		//who discovered
		wait.until(ExpectedConditions.invisibilityOfElementLocated(BackgroundInfoError));
		//investigator
		wait.until(ExpectedConditions.invisibilityOfElementLocated(InvestigatorError));
	}
	
	public void verifyInfoPageErrorPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		OPiRCAChinese obj = new OPiRCAChinese();
		OPiRCA obj1 = new OPiRCA();
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.OPiRCASavePopupTitle)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Invalid Data Entry");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.OPiRCASavePopupTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Please fix all errors mentioned in red.");
		//ok button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.OPiRCASaveConfirmButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("ok");
	}
	
	public void verifySavePopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		OPiRCAChinese obj = new OPiRCAChinese();
		OPiRCA obj1 = new OPiRCA();
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.OPiRCASavePopupTitle)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Save Report");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.OPiRCASavePopupTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Are you sure you want to save current event report?");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.OPiRCASaveCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Cancel");
		//Save button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.OPiRCASaveConfirmButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("Save Report");
	}
	
	public void verifyNewReportPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		OPiRCAChinese obj = new OPiRCAChinese();
		OPiRCA obj1 = new OPiRCA();
		//Click on new button
		wait.until(ExpectedConditions.visibilityOfElementLocated(NewButton)).click();
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.OPiRCASavePopupTitle)).getText();
		softly.assertThat(s).as("test data").isEqualTo("New Report");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.OPiRCASavePopupTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Would you like to confirm you want to erase the current report and create a new report?");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAPopupNote)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Note: erased content cannot be recovered later.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.OPiRCASaveCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Cancel");
		//New button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.OPiRCASaveConfirmButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("New Report");
		//Click on cancel
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.OPiRCASaveCancelButton)).click();
	}	

	public void verifyOpenReportPopup(WebDriver driver, SoftAssertions softly, String recordName) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		EiRCA obj = new EiRCA();
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ConfirmPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Open");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ConfirmPopupTitle)).getText();
		String r = s1.replaceAll("\u00AD", "");
		String r1 = recordName.replaceAll("\u00AD", "");
		softly.assertThat(r).as("test data").isEqualTo("Do you confirm you want to open O&P Assessment report referenced as: <br/>"+r1+"?");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ConfirmPopupNote)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Warning: once you load this version, any changes on the report will override existing data.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ConfirmCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Cancel");
		//Open button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ConfirmPopupButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("Open");
	}	
	
	public void verifyDeleteReportPopup(WebDriver driver, SoftAssertions softly, String recordName) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		EiRCA obj = new EiRCA();
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ConfirmPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Delete Report");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ConfirmPopupTitle)).getText();
		String r = s1.replaceAll("\u00AD", "");
		String r1 = recordName.replaceAll("\u00AD", "");
		softly.assertThat(r).as("test data").isEqualTo("Are you sure you want to delete this O&P iRCA™ report ["+r1+"]?");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ConfirmPopupNote)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Note: deleted data cannot be recovered later.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ConfirmCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Cancel");
		//Open button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ConfirmPopupButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("delete report");
	}
}
