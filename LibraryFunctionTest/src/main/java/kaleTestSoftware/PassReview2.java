package kaleTestSoftware;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PassReview2 {

	PassReviewPageObj pr = new PassReviewPageObj ();
	ShareCheck2 share2 = new ShareCheck2();
	EiRCAPageObj eirca = new EiRCAPageObj();

	public void verifyErrorOnInfoPage (WebDriver driver, SoftAssertions softly) throws Exception{

		//Clicks on Save
		driver.findElement(pr.SaveButton).click();
		//Verify all errors
		String reviewerError = driver.findElement(pr.InfoPageReviewerError).getText();
		softly.assertThat(reviewerError).as("test data").isEqualTo("Reviewer name is required");
		String docTitleError = driver.findElement(pr.InfoPageDocTitleError).getText();
		softly.assertThat(docTitleError).as("test data").isEqualTo("Document title is required");
		String docTypeError = driver.findElement(pr.InfoPageDocTypeError).getText();
		softly.assertThat(docTypeError).as("test data").isEqualTo("Document type is required");
		String organizationError = driver.findElement(pr.InfoPageOrganizationError).getText();
		softly.assertThat(organizationError).as("test data").isEqualTo("Orgnanization name is required");
		//softly.assertAll();
	}

	public void verifySavePopupAfterRename(WebDriver driver, SoftAssertions softly)throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Clicks on record
		wait.until(ExpectedConditions.visibilityOfElementLocated(pr.FirstRecord)).click();
		//Wait for loading message
		share2.loadingServer(driver);
		//Click on open button
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.OpenButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
		//Click on Info tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(pr.InfoTab)).click();
		//Enter a very long name in Event title
		driver.findElement(pr.DocumentTitle).clear();
		driver.findElement(pr.DocumentTitle).sendKeys("Really long text which will make the report name o overflow out of the popup");
		//click on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(pr.SaveButton)).click();
		//Verify the popup
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(pr.SavePopupNote)).getText();
		softly.assertThat(s).as("test data").contains("‑");
		System.out.println(s);
		String overflow = wait.until(ExpectedConditions.visibilityOfElementLocated(pr.SavePopupNote)).getCssValue("word-wrap");
		softly.assertThat(overflow).as("test data").isEqualTo("break-word");
		System.out.println(overflow);
		//Click on cancel
		wait.until(ExpectedConditions.visibilityOfElementLocated(pr.SavePopupCancelButton)).click();
		//Clicks on saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(pr.SavedAcivitiesButton)).click();
		share2.loadingServer(driver);
	}
	
	public void verifyNewReportPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on new button
		wait.until(ExpectedConditions.visibilityOfElementLocated(pr.NewButton)).click();
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(pr.SavePopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Start New Report");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(pr.SavePopupTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Are you sure you want to erase current changes and start a new report?");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(pr.SavePopupNote)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Warning: erased content cannot be recovered later.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(pr.SavePopupCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("cancel");
		//New button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(pr.SavePopupConfirmButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("new report");
		//Click on cancel
		wait.until(ExpectedConditions.visibilityOfElementLocated(pr.SavePopupCancelButton)).click();
	}
	
	public void verifySaveReportPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);		
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(pr.SavePopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Save Report");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(pr.SavePopupTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Are you sure you want to save current report?");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(pr.SavePopupNote)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Note: saved data can be seen by clicking \"saved activities\" button.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(pr.SavePopupCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("cancel");
		//save button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(pr.SavePopupConfirmButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("save report");
	}

}
