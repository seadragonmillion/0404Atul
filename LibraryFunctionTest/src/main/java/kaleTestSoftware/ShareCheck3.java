package kaleTestSoftware;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShareCheck3 {

	EiRCAPageObj eirca = new EiRCAPageObj();
	EiRCA3 eirca3 = new EiRCA3();
	ShareCheck2 share2 = new ShareCheck2();
	ChineseCommonFunctions ccf = new ChineseCommonFunctions();
	
	public void shareTwice (WebDriver driver, SoftAssertions softly, int chOrEn) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		Thread.sleep(2000);
		//Enters sharer username
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ShareTextBox)).sendKeys("jenkins_1_nonadmin");
		Thread.sleep(2000);
		//Selects from dropdown
		WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ShareDropdown));
		dropdown.findElement(eirca.FirstSelectionUnderDropdown).click();
		//Verify add sharer pop up
		if(chOrEn==0)
			eirca3.verifyAddSharerPopup(driver, softly, "QAA (jenkins_1_nonadmin)");
		else
			ccf.verifyChineseAddSharerPopup(driver, softly);
		//Clicks on add user
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
		Thread.sleep(2000);
		if(driver.getCurrentUrl().contains("kaleqa"))
		{
			//Verify sharer does not appear in list after already adding sharer
			share2.verifyNameDoesNotappearInListAfterSharerAdded(driver, "jenkins_1_nonadmin", softly);
		}
		//Click on new shared row
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("QAA (jenkins_1_nonadmin)"))).click();
		//Verify remove sharer pop up
		if(chOrEn==0)
			eirca3.verifyRemoveSharerPopup(driver, softly, "QAA (jenkins_1_nonadmin)");
		else
		{
			if(driver.getCurrentUrl().contains("kaleqa"))
				ccf.verifyChineseRemoveSharerPopup(driver, softly, "QAA (jenkins_1_nonadmin)");
		}
		//Click on remove sharing
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
	}

}
