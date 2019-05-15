package kaleTestSoftware;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RemoteVerification3 {

	RemoteVerificationPageObj rv = new RemoteVerificationPageObj();
	ShareCheck2 share2 = new ShareCheck2();
	EiRCAPageObj eirca = new EiRCAPageObj();

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

	public void verifySavePopupAfterRename(WebDriver driver, SoftAssertions softly)throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Enter a very long name in Event title
		driver.findElement(rv.RVEventTitle).clear();
		driver.findElement(rv.RVEventTitle).sendKeys("Really long text which will make the report name o overflow out of the popup");
		//click on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSaveButton)).click();
		//Verify the popup
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupNote)).getText();
		softly.assertThat(s).as("test data").contains("‑");
		System.out.println(s);
		String overflow = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupNote)).getCssValue("word-wrap");
		softly.assertThat(overflow).as("test data").isEqualTo("break-word");
		System.out.println(overflow);
		//Click on cancel
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupCancelButton)).click();
		//Click on saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavedAcivitiesButton)).click();
		share2.loadingServer(driver);
		//Click on first record
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVNewlyCreatedFirstRecord)).click();		
		share2.loadingServer(driver);
		//Click on Open
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.OpenButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
		Thread.sleep(1000);
	}

}
