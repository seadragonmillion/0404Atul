import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class EiRCA2 {

	//Info page
	By NewButton = By.id("pii-ircam-new");
	By EventTitleError = By.id("pii-ircam-tab-1-title-error");
	By EventLocationError = By.id("pii-ircam-tab-1-location-error");
	By ProblemStatementError = By.id("pii-ircam-tab-1-problem-statement-error");
	By FailedComponentError = By.id("pii-ircam-tab-1-failed-component-error");
	By WhoDiscoveredError = By.id("pii-ircam-tab-1-who-error");
	By InvestigatorError = By.id("pii-ircam-tab-1-investigators-error");
	By ReviewerError = By.id("pii-ircam-tab-1-reviewer-error");
	By SponsorError = By.id("pii-ircam-tab-1-management-sponsor-error");
	
	public void verifyStickySaveReport(WebDriver driver, SoftAssertions softly, String username, String reportTitle, int n) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,60);
		EiRCA obj = new EiRCA ();
		try{
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.StickyNote)).getText();
		String r = s.replaceAll("\u00AD", "");
		softly.assertThat(r).as("test data").contains(username+"_"+reportTitle);
		if(n == 0)
			softly.assertThat(r).as("test data").contains("EiRCA™ Data created for id:");
		else
			softly.assertThat(r).as("test data").contains("EiRCA™ Data updated for id:");
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.StickyClose)).click();
		}catch(org.openqa.selenium.TimeoutException r)
		{
			System.out.println("Couldn't find save pop up");
		}
	}
	
	public void verifyStickyShareSave(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,60);
		EiRCA obj = new EiRCA ();
		try{
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.StickyNote)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Sharing updated successfully.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.StickyClose)).click();
		}catch(org.openqa.selenium.TimeoutException r)
		{
			System.out.println("Couldn't find share save pop up");
		}
	}
	
	public void verifyStickyCreatePDF(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,60);
		EiRCA obj = new EiRCA ();
		try{
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.StickyNote)).getText();
		softly.assertThat(s).as("test data").isEqualTo("PDF successfully built and downloaded");
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.StickyClose)).click();
		}catch(org.openqa.selenium.TimeoutException r)
		{
			System.out.println("Couldn't find pdf create pop up");
		}
	}
	
	public void verifyStickyDeleteReport(WebDriver driver, SoftAssertions softly, String recordName) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,60);
		EiRCA obj = new EiRCA ();
		try{
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.StickyNote)).getText();
		String r = s.replaceAll("\u00AD", "");
		String r1 = recordName.replaceAll("\u00AD", "");
		softly.assertThat(r).as("test data").isEqualTo("EiRCA™ data deleted: "+r1);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.StickyClose)).click();
		}catch(org.openqa.selenium.TimeoutException r)
		{
			System.out.println("Couldn't find delete pop up");
		}
	}

	public void verifyErrorMessagesInfoPage(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		EiRCA obj = new EiRCA ();		
		//Click on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EiRCASaveButton)).click();
		Thread.sleep(1000);
		verifyInfoPageErrorPopup(driver,softly);
		//Click on ok
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EiRCAConfirmButton)).click();
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
		//Failed component
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(FailedComponentError)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("Suspected failed component is required");
		//who discovered
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(WhoDiscoveredError)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Who discovered is required");
		//investigator
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(InvestigatorError)).getText();
		softly.assertThat(s5).as("test data").isEqualTo("Investigator(s) is required");
		//reviewer
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(ReviewerError)).getText();
		softly.assertThat(s6).as("test data").isEqualTo("Reviewer(s) is required");
		//sponsor
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(SponsorError)).getText();
		softly.assertThat(s7).as("test data").isEqualTo("Management sponsor(s) is required");
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
		wait.until(ExpectedConditions.invisibilityOfElementLocated(FailedComponentError));
		//who discovered
		wait.until(ExpectedConditions.invisibilityOfElementLocated(WhoDiscoveredError));
		//investigator
		wait.until(ExpectedConditions.invisibilityOfElementLocated(InvestigatorError));
		//reviewer
		wait.until(ExpectedConditions.invisibilityOfElementLocated(ReviewerError));
		//sponsor
		wait.until(ExpectedConditions.invisibilityOfElementLocated(SponsorError));
	}
	
	public void verifySavePopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		EiRCA obj = new EiRCA();
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EiRCAPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Save Report");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EiRCAPopupTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Are you sure you want to save current event report?");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EiRCAPopupCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Cancel");
		//Save button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EiRCAConfirmButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("Save Report");
	}
	
	public void verifyNewReportPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		EiRCAChinese obj = new EiRCAChinese();
		//Click on new button
		wait.until(ExpectedConditions.visibilityOfElementLocated(NewButton)).click();
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.PopUpTitle)).getText();
		softly.assertThat(s).as("test data").isEqualTo("New Report");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.PopUpMessageTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Would you like to confirm you want to erase the current report and create a new report?");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.PopUpMessage)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Note: erased content cannot be recovered later.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.PopupCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Cancel");
		//New button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.PopupConfirmButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("New Report");
		//Click on cancel
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.PopupCancelButton)).click();
	}
	
	public void verifyInfoPageErrorPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		EiRCAChinese obj = new EiRCAChinese();
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.PopUpTitle)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Invalid Data Entry");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.PopUpMessageTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Please fix all errors mentioned in red.");
		//ok button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.PopupConfirmButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("ok");
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
		if(driver.getCurrentUrl().contains("kaleqa"))
			softly.assertThat(r).as("test data").isEqualTo("Do you confirm you want to open EiRCA™ report referenced as: "+r1+"?");
		else
			softly.assertThat(r).as("test data").isEqualTo("Do you confirm you want to open EiRCA™ report referenced as: <br/>"+r1+"?");
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
	
	public void verifyAddSharerPopup(WebDriver driver, SoftAssertions softly, String sharer) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		EiRCA obj = new EiRCA();
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ConfirmPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Share to user");
		//Verify question on pop up, sharer in format = QAA (ritica_only_nonadmin)
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ConfirmPopupTitle)).getText();
		if(driver.getCurrentUrl().contains("kaleqa"))
			softly.assertThat(s1).as("test data").isEqualTo("Are you sure you want share current activity to user ["+sharer+"]?");
		else
			softly.assertThat(s1).as("test data").isEqualTo("Are you sure you want share current activity to user <­strong>["+sharer+"]<­/strong>?");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ConfirmPopupNote)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Note: report will be shared after you save your changes.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ConfirmCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Cancel");
		//Open button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ConfirmPopupButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("add user");
	}
	
	public void verifyRemoveSharerPopup(WebDriver driver, SoftAssertions softly, String sharer) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		EiRCA obj = new EiRCA();
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ConfirmPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Remove sharing to a user");
		//Verify question on pop up, sharer in format = QAA (ritica_only_nonadmin)
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ConfirmPopupTitle)).getText();
		if(driver.getCurrentUrl().contains("kaleqa"))
			softly.assertThat(s1).as("test data").isEqualTo("Are you sure you want to remove user ["+sharer+"] from 'shared to' users?");
		else
			softly.assertThat(s1).as("test data").isEqualTo("Are you sure you want to remove user <­strong>["+sharer+"]<­/strong> from 'shared to' users?");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ConfirmPopupNote)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Note: sharing to user will be removed after you save your changes.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ConfirmCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Cancel");
		//Open button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ConfirmPopupButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("Remove sharing");
	}
	
	public void verifyDownloadReportPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		EiRCA obj = new EiRCA();
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ConfirmPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("PDF Report");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ConfirmPopupTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Your PDF report is ready.");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ConfirmPopupNote)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Note: the report will be display in a seperate web browser window.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ConfirmCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Cancel");
		//Open button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ConfirmPopupButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("Open PDF report");
	}
	
	public void verifyMarkCriticalPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		EiRCA obj = new EiRCA();
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ConfirmPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Change Criticality");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ConfirmPopupTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Are you sure you want to mark critical?");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ConfirmPopupNote)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Note: \"Shared to\" users will be notified report is marked critical.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ConfirmCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("cancel");
		//Open button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ConfirmPopupButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("confirm change");
	}
	
	public void verifyUnMarkCriticalPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		EiRCA obj = new EiRCA();
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ConfirmPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Change Criticality");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ConfirmPopupTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Are you sure you want to un-mark critical?");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ConfirmPopupNote)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Note: \"Shared to\" users will be notified report is no longer marked critical.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ConfirmCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("cancel");
		//Open button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.ConfirmPopupButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("confirm change");
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
		softly.assertThat(r).as("test data").isEqualTo("Are you sure you want to delete this EiRCA™ report ["+r1+"]?");
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
