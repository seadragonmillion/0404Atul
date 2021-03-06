package kaleTestSoftware;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RemoteVerificationChinese {

	ShareCheck2 share2 = new ShareCheck2();
	ShareCheck share = new ShareCheck();
	ShareCheckPageObj shareObj = new ShareCheckPageObj();
	EiRCAPageObj eirca = new EiRCAPageObj();
	RemoteVerificationPageObj rv = new RemoteVerificationPageObj();	
	RemoteVerification2 rv2 = new RemoteVerification2();
	RemoteVerification3 rv3 = new RemoteVerification3();
	RemoteVerificationChinese2 rc2 = new RemoteVerificationChinese2();

	SoftAssertions softly = new SoftAssertions();

	public void verifyChineseRV(WebDriver driver, int k, String username, String password1) throws Exception {

		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		rc2.verifyEmailOfUser(driver, username, password1);
		//Clicks on Analysis 
		try
		{
			driver.findElement(rv.AnalysisLink).click();
		}catch (UnhandledAlertException f){			  
			driver.switchTo().alert().dismiss();
		}
		//Clicks on Remote Verification
		driver.findElement(rv.RVLink).click();
		//Buttons and tab
		verifyChineseRVButtonsTabs(driver);
		//titles and placeholders
		verifyChineseRVTitlesPlaceholders(driver);
		rc2.verifyNewReportPopup(driver,softly);
		String verifier = rv3.fillRVPage(driver, k,1,softly);	
		verifierNotification(driver,verifier,username,password1,k);
		//Delete report
		rv2.deleteReport(driver);
	}
	
	public void verifierNotification(WebDriver driver, String verifier, String username, String password1, int k) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		rv2.loginToUser(driver,verifier,rv2.password);
		//Click on 1st record/notification
		while(true)
		{
			if(browserName.equals("safari")||browserName.equals("firefox"))
			{
				executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.NotificationFirstRecord)));
			}
			else
			{
				try{
					wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.NotificationFirstRecord)).click();
				}catch(org.openqa.selenium.WebDriverException r)
				{

				}
			}
			if(driver.findElement(shareObj.NotificationOpenButton).isEnabled())
				break;		
		}
		share2.loadingServer(driver);
		//Click on Open Report button
		wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.NotificationOpenButton)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Click on Reject button
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.VerifierRejectButton)).click();
		//Click on reject confirm button
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.VerifierRejectConfirmButton)).click();
		share2.loadingServer(driver);
		share.markNotificationsRead(driver, browserName,0,softly);
		//login to report creator
		rv2.loginToUser(driver,username,password1);
		//Click on 1st record/notification
		while(true)
		{
			if(browserName.equals("safari")||browserName.equals("firefox"))
			{
				executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.NotificationFirstRecord)));
			}
			else
			{
				try{
					wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.NotificationFirstRecord)).click();
				}catch(org.openqa.selenium.WebDriverException r)
				{

				}
			}
			if(driver.findElement(shareObj.NotificationOpenButton).isEnabled())
				break;		
		}
		share2.loadingServer(driver);
		//Click on Open Report button
		wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.NotificationOpenButton)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Verify the Verification status
		String status = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVReportVerificationStatus)).getText();
		softly.assertThat(status).as("test data").contains("?????????????????????");
		//Verification result
		String result = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVReportVerificationRejectedResult)).getText();
		softly.assertThat(result).as("test data").contains("???????????????");
		//Click on Revise button
		String revise = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVReportVerificationReviseButton)).getText();
		softly.assertThat(revise).as("test data").contains("????????????");
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVReportVerificationReviseButton)).click();
		rc2.verifyReviseReportPopup(driver, softly);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
		//Clicks on Save and Send
		driver.findElement(rv.RVSaveAndSendButton).click();
		//Clicks on save and send report
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupTitle)).click();
		driver.findElement(rv.RVSavePopupConfirmButton).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Mark notification as read
		share.markNotificationsRead(driver, browserName,1,softly);
		//Login to verifier
		rv2.loginToUser(driver,verifier,rv2.password);
		//Click on 1st record/notification
		while(true)
		{
			if(browserName.equals("safari")||browserName.equals("firefox"))
			{
				executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.NotificationFirstRecord)));
			}
			else
			{
				try{
					wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.NotificationFirstRecord)).click();
				}catch(org.openqa.selenium.WebDriverException r)
				{

				}
			}
			if(driver.findElement(shareObj.NotificationOpenButton).isEnabled())
				break;		
		}
		share2.loadingServer(driver);
		//Click on Open Report button
		wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.NotificationOpenButton)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Click on Accept button
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.VerifierAcceptButton)).click();
		//Click on reject confirm button
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.VerifierRejectConfirmButton)).click();
		share2.loadingServer(driver);
		//Mark notification as read
		share.markNotificationsRead(driver, browserName,0,softly);
		//login to report creator
		rv2.loginToUser(driver,username,password1);
		//Click on 1st record/notification
		while(true)
		{
			if(browserName.equals("safari")||browserName.equals("firefox"))
			{
				executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.NotificationFirstRecord)));
			}
			else
			{
				try{
					wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.NotificationFirstRecord)).click();
				}catch(org.openqa.selenium.WebDriverException r)
				{

				}
			}
			if(driver.findElement(shareObj.NotificationOpenButton).isEnabled())
				break;		
		}
		share2.loadingServer(driver);
		//Click on Open Report button
		wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.NotificationOpenButton)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Mark notification as read
		share.markNotificationsRead(driver, browserName,1,softly);
		//Login to report creator
		rv2.loginToUser(driver,username,password1);
		//Click on 1st record/notification
		while(true)
		{
			if(browserName.equals("safari")||browserName.equals("firefox"))
			{
				executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.NotificationFirstRecord)));
			}
			else
			{
				try{
					wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.NotificationFirstRecord)).click();
				}catch(org.openqa.selenium.WebDriverException r)
				{

				}
			}
			if(driver.findElement(shareObj.NotificationOpenButton).isEnabled())
				break;		
		}
		share2.loadingServer(driver);
		//Click on Open Report button
		wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.NotificationOpenButton)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//reload rv page activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSidePanel)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//click on 1st record
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVNewlyCreatedFirstRecord)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Verify the Verification status
		String status1 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVReportVerificationStatus)).getText();
		softly.assertThat(status1).as("test data").contains("?????????????????????");
		//Verification result
		String result1 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVReportVerificationAcceptedResult)).getText().trim();
		softly.assertThat(result1).as("test data").isEqualTo("????????????");
	}

	public void verifyChineseRVTitlesPlaceholders(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Main title
		String mainTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVMainTitle)).getText();
		softly.assertThat(mainTitle).as("test data").isEqualTo("???????????????????????????????????????????????????????????? - v1");
		//Report info
		String reportInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVReportInfoTitle)).getText();
		softly.assertThat(reportInfo).as("test data").isEqualTo("(1) ????????????.");
		//Report title
		String reportTitleLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVReportTitleLabel)).getText();
		softly.assertThat(reportTitleLabel).as("test data").isEqualTo("??????:");
		String reportTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVEventTitle)).getAttribute("placeholder");
		softly.assertThat(reportTitle).as("test data").isEqualTo("?????????????????? ");
		//date time
		String dateTimeLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVReportDateTimeLabel)).getText();
		softly.assertThat(dateTimeLabel).as("test data").isEqualTo("????????????:");
		//location
		String locationLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVReportLocationLabel)).getText();
		softly.assertThat(locationLabel).as("test data").isEqualTo("??????????????????:");
		//photo 1
		String image1Label = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVReportImage1Label)).getText();
		softly.assertThat(image1Label).as("test data").isEqualTo("(2) ???????????????????????????????????????????????????.");
		//photo 2
		String image2Label = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVReportImage2Label)).getText();
		softly.assertThat(image2Label).as("test data").isEqualTo("(3) ?????????????????????????????????????????????????????????.");
		//details
		String detailsLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVReportDetailsLabel)).getText();
		softly.assertThat(detailsLabel).as("test data").isEqualTo("(4) ???????????????????????????.");
		String detailsPlaceholder = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVEventDetails)).getAttribute("placeholder");
		softly.assertThat(detailsPlaceholder).as("test data").isEqualTo("(1)???????????????????????????????????? (2)??????????????????????????? (3)?????????????????????");
		//verifier
		String verifierLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVReportVerifierLabel)).getText();
		softly.assertThat(verifierLabel).as("test data").isEqualTo("(5) ????????????????????????????????????????????????.");
		String verifierPlaceholder = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVVerifierField)).getAttribute("placeholder");
		softly.assertThat(verifierPlaceholder).as("test data").isEqualTo("???????????????????????????????????????");
		String verifierSelectedLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVReportVerifierSelectedLabel)).getText();
		softly.assertThat(verifierSelectedLabel).as("test data").isEqualTo("?????????:");
		//report verify title
		String reportVerifySend = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVReportVerifierSendLabel)).getText();
		softly.assertThat(reportVerifySend).as("test data").isEqualTo("(6) ??????????????????????????????????????????????????????.");
	}

	public void verifyChineseRVButtonsTabs(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//New button
		String newButton = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVNewButton)).getText();
		softly.assertThat(newButton).as("test data").isEqualTo("??????");
		//Save
		String save = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSaveButton)).getText();
		softly.assertThat(save).as("test data").isEqualTo("??????");
		//Save and send
		String saveSend = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSaveAndSendButton)).getText();
		softly.assertThat(saveSend).as("test data").isEqualTo("????????????");
		//saved activities
		String savedActivities = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavedActivitiesButton)).getText();
		softly.assertThat(savedActivities).as("test data").isEqualTo("??????????????????");
		//Current verification tab
		String cv = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVCurrentVerificationTab)).getText();
		softly.assertThat(cv).as("test data").isEqualTo("??????????????????");
		//Rejected tab
		String rv1 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVRejectedVerificationTab)).getText();
		softly.assertThat(rv1).as("test data").isEqualTo("????????????????????????");
	}
	
	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}

}
