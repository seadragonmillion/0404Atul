package kaleTestSoftware;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RemoteVerification4 {

	RemoteVerificationPageObj rv = new RemoteVerificationPageObj();

	public void verifyNewReportPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on new button
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVNewButton)).click();
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Start New Remote Verification");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Are you sure you want to erase current report and start a new remote verification?");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupNote)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Warning: unsaved content cannot be recovered later.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("cancel");
		//New button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupConfirmButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("new remote verification");
		//Click on cancel
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupCancelButton)).click();
	}

	public void verifySaveReportPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);		
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Save Report");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Are you sure you want to save current event report?");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("cancel");
		//Open button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupConfirmButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("save report");
	}

	public void verifySaveAndSendReportPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);		
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Save and Send Report");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupTitle)).getText();
		softly.assertThat(s1).as("test data").contains("Are you sure you want to save & send current report to verification user:");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupNote)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Information: verification user will receive an email and will be able to verify report.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("cancel");
		//Open button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupConfirmButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("save and send report");
	}

}
