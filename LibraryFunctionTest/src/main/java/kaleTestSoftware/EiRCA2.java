package kaleTestSoftware;

import java.util.Random;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class EiRCA2 {

	EiRCAPageObj eirca = new EiRCAPageObj();
	LoginPageObj login = new LoginPageObj();
	TextBoxResizing tbr = new TextBoxResizing ();
	
	public String textCreate(WebDriver driver) throws Exception {

		if(driver.getCurrentUrl().contains("kaleqa"))
			return ("Sanity <td> Test \"title\" Sanity");
		else
			return("Sanity Test \"title\" Sanity");
	}

	public String textCreate1() throws Exception {

		return("Sanity Test");
	}

	public void detectAdditionalBoxStep1(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Get 1.2 selected answer
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep1Q12AnswerSelected)).getText();
		//Get 1.3 selected answer
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep1Q13AnswerSelected)).getText();
		//1.2 extra box
		if(s.contains("Other MECHANICAL related components")||s.contains("Other ELECTRICAL related components"))
		{
			tbr.sizeCheck(driver, eirca.EiRCAStep1Q12AnswerTextBox, softly);
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep1Q12AnswerTextBox)).sendKeys(textCreate(driver));
		}
		//1.3 extra box
		if(s1.contains("Other MECHANICAL related symptoms")||s1.contains("Other ELECTRICAL related symptoms"))
		{
			tbr.sizeCheck(driver, eirca.EiRCAStep1Q13AnswerTextBox, softly);
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep1Q13AnswerTextBox)).sendKeys(textCreate(driver));
		}
	}

	public void selectDropdown11(WebDriver driver) throws Exception {

		Random random = new Random ();
		int y;
		y = random.nextInt(3);
		if(y<2)
			y=y+1;
		WebElement dropdown1 = driver.findElement(eirca.Step1Q11Answer);
		Select s1 = new Select(dropdown1);
		s1.selectByIndex(y);
	}


	public void selectDropdown12(WebDriver driver) throws Exception {

		Random random = new Random ();
		int y;
		y = random.nextInt(28);
		if(y<27)
			y=y+1;
		WebElement dropdown1 = driver.findElement(eirca.Step1Q12Answer);
		Select s1 = new Select(dropdown1);
		s1.selectByIndex(y);
	}

	public void selectDropdown13(WebDriver driver) throws Exception {

		Random random = new Random ();
		int y = random.nextInt(34);
		if(y<33)
			y=y+1;
		WebElement dropdown1 = driver.findElement(eirca.Step1Q13Answer);
		Select s1 = new Select(dropdown1);
		s1.selectByIndex(y);
	}

	
	public void EIRCAStep1Troubleshooting(WebDriver driver, String text, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify no next button without mandatory dropdowns selected
		if(driver.findElement(eirca.EiRCANextButton).isDisplayed()==true)
			softly.fail("Next button visible in Step 1 without selecting 1.1, 1.2, 1.3");
		//Select 1.1 
		selectDropdown11(driver);
		Thread.sleep(1000);
		//Select 1.2
		selectDropdown12(driver);
		Thread.sleep(1000);
		//Select 1.3
		selectDropdown13(driver);
		Thread.sleep(1000);
		//Verify extra ex box is appears and enter text in it
		detectAdditionalBoxStep1(driver,softly);
		//Verify next button is visible after mandatory dropdowns are selected
		if(driver.findElement(eirca.EiRCANextButton).isDisplayed()==false)
			softly.fail("Next button not visible in Step 1 after selecting 1.1, 1.2, 1.3");
		//Fill text in 1.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep1Q14AnswerTextBox)).sendKeys(text);
		//Fill text in 1.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep1Q15AnswerTextBox)).sendKeys(text);
		//Fill text in 1.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep1Q16AnswerTextBox)).sendKeys(text);
	}
	
	public void createNewEvent(WebDriver driver, String text, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		WebDriverWait wait1 = new WebDriverWait(driver,3);
		//Select date
		//Click on calendar icon
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.CalendarIconAddEvent)).click();
		//Click on - sign
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.CalendarMinusSign)).click();
		//Select 1st date of 1st row
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Calendar1stRow1stDate)).click();
		Thread.sleep(1000);
		//Wait for disappearance of date box
		try{
			wait1.until(ExpectedConditions.invisibilityOfElementLocated(eirca.Calendar1stRow1stDate));
		}catch(org.openqa.selenium.TimeoutException r)
		{

		}
		//Select time
		//Click on clock icon
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ClockIconAddEvent)).click();
		//Click on set time
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ClockSetTime)).click();
		Thread.sleep(1000);
		//Wait for disappearance of time box
		try{
			wait1.until(ExpectedConditions.invisibilityOfElementLocated(eirca.ClockSetTime));
		}catch(org.openqa.selenium.TimeoutException r)
		{

		}
		//Enter text in what happened
		tbr.sizeCheck(driver, eirca.WhatHappenedField, softly);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.WhatHappenedField)).sendKeys(text);
		//Enter text in what is supposed to happen
		tbr.sizeCheck(driver, eirca.WhatIsSupposedToHappenField, softly);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.WhatIsSupposedToHappenField)).sendKeys(text);
		//Click on add sign
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EventAddSign)).click();
	}
	
	public void verifyStickySaveReport(WebDriver driver, SoftAssertions softly, String username, String reportTitle, int n) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,60);
		try{
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyNote)).getText();
		String r = s.replaceAll("\u00AD", "");
		softly.assertThat(r).as("test data").contains(username+"_"+reportTitle);
		if(n == 0)
			softly.assertThat(r).as("test data").contains("EiRCA™ Data created for id:");
		else
			softly.assertThat(r).as("test data").contains("EiRCA™ Data updated for id:");
		wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyClose)).click();
		}catch(org.openqa.selenium.TimeoutException | org.openqa.selenium.ElementNotInteractableException r)
		{
			System.out.println("Couldn't find save pop up");
			Thread.sleep(2000);
		}
	}
	
	public void verifyStickyShareSave(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,60);		
		try{
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyNote)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Sharing updated successfully.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyClose)).click();
		}catch(org.openqa.selenium.TimeoutException | org.openqa.selenium.ElementNotInteractableException r)
		{
			System.out.println("Couldn't find share save pop up");
		}
	}
	
	public void verifyStickyCreatePDF(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,60);		
		try{
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyNote)).getText();
		softly.assertThat(s).as("test data").isEqualTo("PDF successfully built and downloaded");
		wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyClose)).click();
		}catch(org.openqa.selenium.TimeoutException | org.openqa.selenium.ElementNotInteractableException r)
		{
			System.out.println("Couldn't find pdf create pop up");
		}
	}
	
	public void verifyStickyDeleteReport(WebDriver driver, SoftAssertions softly, String recordName) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,60);		
		try{
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyNote)).getText();
		String r = s.replaceAll("\u00AD", "");
		String r1 = recordName.replaceAll("\u00AD", "");
		softly.assertThat(r).as("test data").isEqualTo("EiRCA™ data deleted: "+r1);
		wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyClose)).click();
		}catch(org.openqa.selenium.TimeoutException | org.openqa.selenium.ElementNotInteractableException r)
		{
			System.out.println("Couldn't find delete pop up");
		}
	}

	public void verifyErrorMessagesInfoPage(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);				
		//Click on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASaveButton)).click();
		Thread.sleep(1000);
		verifyInfoPageErrorPopup(driver,softly);
		//Click on ok
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAConfirmButton)).click();
		Thread.sleep(1000);
		//Verify errors
		//Event title
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EventTitleError)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Event title is required");
		//Location of event
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EventLocationError)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Location of event is required");
		//Problem statement
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ProblemStatementError)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Problem statement is required");
		//Failed component
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.FailedComponentError)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("Suspected failed component is required");
		//who discovered
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.WhoDiscoveredError)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Who discovered is required");
		//investigator
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.InvestigatorError)).getText();
		softly.assertThat(s5).as("test data").isEqualTo("Investigator(s) is required");
		//reviewer
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ReviewerError)).getText();
		softly.assertThat(s6).as("test data").isEqualTo("Reviewer(s) is required");
		//sponsor
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.SponsorError)).getText();
		softly.assertThat(s7).as("test data").isEqualTo("Management sponsor(s) is required");
	}

	public void verifyNoErrorsOnInfoPage(WebDriver driver)throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify no errors
		//Event title
		wait.until(ExpectedConditions.invisibilityOfElementLocated(eirca.EventTitleError));
		//Location of event
		wait.until(ExpectedConditions.invisibilityOfElementLocated(eirca.EventLocationError));
		//Problem statement
		wait.until(ExpectedConditions.invisibilityOfElementLocated(eirca.ProblemStatementError));
		//Failed component
		wait.until(ExpectedConditions.invisibilityOfElementLocated(eirca.FailedComponentError));
		//who discovered
		wait.until(ExpectedConditions.invisibilityOfElementLocated(eirca.WhoDiscoveredError));
		//investigator
		wait.until(ExpectedConditions.invisibilityOfElementLocated(eirca.InvestigatorError));
		//reviewer
		wait.until(ExpectedConditions.invisibilityOfElementLocated(eirca.ReviewerError));
		//sponsor
		wait.until(ExpectedConditions.invisibilityOfElementLocated(eirca.SponsorError));
	}
	
	public void verifySavePopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);		
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Save Report");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Are you sure you want to save current event report?");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Cancel");
		//Save button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAConfirmButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("Save Report");
	}
	
	public void verifyNewReportPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on new button
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.NewButton)).click();
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.PopUpTitle)).getText();
		softly.assertThat(s).as("test data").isEqualTo("New Report");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.PopUpMessageTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Would you like to confirm you want to erase the current report and create a new report?");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.PopUpMessage)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Note: erased content cannot be recovered later.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.PopupCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Cancel");
		//New button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.PopupConfirmButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("New Report");
		//Click on cancel
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.PopupCancelButton)).click();
	}
	
	public void verifyInfoPageErrorPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.PopUpTitle)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Invalid Data Entry");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.PopUpMessageTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Please fix all errors mentioned in red.");
		//ok button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.PopupConfirmButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("ok");
	}
	
	public void verifyOpenReportPopup(WebDriver driver, SoftAssertions softly, String recordName) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);		
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Open");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).getText();
		String r = s1.replaceAll("\u00AD", "");
		String r1 = recordName.replaceAll("\u00AD", "");
		//if (driver.getCurrentUrl().contains("kaleqa"))
		softly.assertThat(r).as("test data").isEqualTo("Do you confirm you want to open EiRCA™ report referenced as: "+r1+"?");
		/*else
			softly.assertThat(r).as("test data").isEqualTo("Do you confirm you want to open EiRCA™ report referenced as: <br/>"+r1+"?");*/
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupNote)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Warning: once you load this version, any changes on the report will override existing data.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Cancel");
		//Open button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("Open");
	}
	

	
	public void verifyDownloadReportPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,60);		
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("PDF Report");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Your PDF report is ready.");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupNote)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Note: the report will be display in a seperate web browser window.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Cancel");
		//Open button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("Open PDF report");
	}
	
	public void verifyMarkCriticalPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);		
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Change Criticality");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Are you sure you want to mark critical?");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupNote)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Note: \"Shared to\" users will be notified report is marked critical.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("cancel");
		//Open button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("confirm change");
	}
	
	public void verifyUnMarkCriticalPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);		
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Change Criticality");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Are you sure you want to un-mark critical?");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupNote)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Note: \"Shared to\" users will be notified report is no longer marked critical.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("cancel");
		//Open button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("confirm change");
	}
	
	public void verifyDeleteReportPopup(WebDriver driver, SoftAssertions softly, String recordName) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);		
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Delete Report");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).getText();
		String r = s1.replaceAll("\u00AD", "");
		String r1 = recordName.replaceAll("\u00AD", "");
		softly.assertThat(r).as("test data").isEqualTo("Are you sure you want to delete this EiRCA™ report ["+r1+"]?");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupNote)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Note: deleted data cannot be recovered later.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Cancel");
		//Open button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("delete report");
	}

}