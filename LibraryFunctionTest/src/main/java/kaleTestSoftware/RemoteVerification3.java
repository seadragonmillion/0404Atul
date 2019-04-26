package kaleTestSoftware;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;

public class RemoteVerification3 {
	
	RemoteVerificationPageObj rv = new RemoteVerificationPageObj();

	public void verifyErrorOnPage (WebDriver driver, SoftAssertions softly) throws Exception{
		
		//Clicks on Save and Send
		driver.findElement(rv.RVSaveAndSendButton).click();
		//Verify all errors
		String titleError = driver.findElement(rv.RVTitleError).getText();
		softly.assertThat(titleError).as("test data").isEqualTo("This field is required.");
		String image1stError = driver.findElement(rv.RV1stImageError).getText();
		softly.assertThat(image1stError).as("test data").isEqualTo("This field is required");
		String image2ndError = driver.findElement(rv.RV2ndImageError).getText();
		softly.assertThat(image2ndError).as("test data").isEqualTo("This field is required");
		String detailsError = driver.findElement(rv.RVDetailsError).getText();
		softly.assertThat(detailsError).as("test data").isEqualTo("This field is required");
		String verifierError = driver.findElement(rv.RVVerifierError).getText();
		softly.assertThat(verifierError).as("test data").isEqualTo("Remote Verification Verifier is required");
		//softly.assertAll();
	}

}
