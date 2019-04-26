package kaleTestSoftware;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;

public class PassReview2 {
	
	PassReviewPageObj pr = new PassReviewPageObj ();
	
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

}
