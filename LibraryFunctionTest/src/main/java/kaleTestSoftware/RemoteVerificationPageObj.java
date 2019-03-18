package kaleTestSoftware;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RemoteVerificationPageObj {

	public By AnalysisLink = By.id("pii-main-menu-button-a");
	public By RVLink = By.id("pii-a-menu-rv");

	//Inside Module
	public By RVSaveAndSendButton = By.xpath(".//*[@id='pii-rv-tabs']/div[2]/div/a[2]");
	public By RVSaveButton = By.id("pii-rv-save");
	public By RVSavePopupTitle = By.id("pii-rv-dialog-title");
	public By RVSavePopupComfirmButton = By.id("pii-rv-dialog-confirmed");
	public By RVSavedAcivitiesButton = By.id("pii-rv-savedactivities");
	public By RV1stImageField = By.id("pii-rv-imgwork-photo-input");
	public By RV1stImageClearButton = By.id("pii-rv-imgwork-clear");
	public By RV1stImageRotateButton = By.id("pii-rv-imgwork-rotate");
	public By RV2ndImageField = By.id("pii-rv-imgperson-photo-input");
	public By RV2ndImageClearButton = By.id("pii-rv-imgperson-clear");
	public By RV2ndImageRotateButton = By.id("pii-rv-imgperson-rotate");
	public By RVDateTimeAboveLocationImage = By.id("pii-rv-tab-1-repdatetime");
	public By RVVerifierField = By.id("pii-rv-verifier-list-input");
	public By RVVerifierDropdown = By.id("pii-rv-verifier-list-ul");
	public By RVLatitudeLongitudeAboveLocationImage = By.id("pii-rv-imgwork-location");
	public By RVLocationImage = By.id("pii-rv-imgwork-googlemap");
	public By RVEventTitle = By.id("pii-rv-tab-1-title");
	public By RVEventDetails = By.id("pii-rv-tab-1-details");
	public By RVVerifierValue = By.id("pii-rv-verifier-name");
	public By RVTitleCharacterCount = By.id("pii-rv-tab-1-title-count");

	public By RVNewlyCreatedFirstRecord = By.xpath(".//*[@id='pii-user-home-activities-rv']/ul/li[2]/a");
	public By RVSidePanel = By.id("pii-user-home-panel-btn-rv");
	public By RVShareIconOrCriticalIcon = By.xpath(".//*[@id='pii-user-home-activities-rv']/ul/li[2]/a/span[1]");
	public By RVShareIconWhenAlsoMarkedCritical = By.xpath(".//*[@id='pii-user-home-activities-rv']/ul/li[2]/a/span[2]");

	//HTML
	public By RVReportNotSentStatusMessage = By.xpath(".//*[@id='rv-rpt']/div/div[2]/div[4]/span");
	public By RVReportSentStatusMessage = By.xpath(".//*[@id='rv-rpt']/div/div[2]/div[5]/span");
	public By RVCreationDate = By.xpath(".//*[@id='rv-rpt']/div/div[2]/div[3]");
	public By RVShareButton = By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[3]");
	public By RVReportCreatorUsername = By.xpath(".//*[@id='rv-rpt']/div/div[2]/div");
	public By RVReportVerifierUsername = By.xpath(".//*[@id='rv-rpt']/div/div[2]/div[2]");
	public By RVDownloadButton = By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a");
	public By RVReportTitle = By.xpath(".//*[@id='rv-rpt']/div/div/table/tbody/tr[2]/td/strong");
	public By RVReportEventDetails = By.xpath(".//*[@id='rv-rpt']/div/div[3]/table/tbody/tr[2]/td/span");
	public By RVMarkedCriticalText = By.xpath(".//*[@id='rv-rpt']/div/div/table/tbody/tr/th/strong");
	public By RVDeleteButton = By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]");
	public By AcceptRejectConfirmPopupTitle = By.id("pii-user-home-rv-dialog-title");

	//Share Page
	public By RVSharePageVerifierBlock = By.xpath(".//*[@id='pii-uhshare-verifier-list-div']/div/div/div/ul");
	
	//Verifier report view
	public By VerifierAcceptButton = By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]");
	public By VerifierRejectButton = By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[3]");
	public By VerifierRejectComment = By.id("pii-rv-dialog-comments");
	public By VerifierRejectConfirmButton = By.id("pii-user-home-rv-dialog-confirmed");
	
	//HTML creator
	public By RVReportVerificationStatus = By.xpath(".//*[@id='rv-rpt']/div/div[2]/div[5]");
	public By RVReportVerificationRejectedResult = By.xpath(".//*[@id='rv-rpt']/div/div[2]/div[7]/div/strong[2]");
	public By RVReportVerificationAcceptedResult = By.xpath(".//*[@id='rv-rpt']/div/div[2]/div[7]/strong[2]");
	public By RVReportVerificationReviseButton = By.xpath(".//*[@id='rv-rpt']/div/div[2]/div[7]/div/a");
	public By RVReportVerificationComments = By.xpath(".//*[@id='rv-rpt']/div/div[2]/div[8]");
	
	public String eventTitle(WebDriver driver) throws Exception {

		if(driver.getCurrentUrl().contains("kaleqa"))
			return ("I think I will <strong> buy the red car, or \"title\" I will lease the blue one.");
		else return ("I think I will buy the red car, or \"title\" I will lease the blue one.");
	}

	public String details(WebDriver driver) throws Exception {

		if(driver.getCurrentUrl().contains("kaleqa"))
			return ("There was no <input> ice cream in the freezer, nor did they have money to go to the store./?.,><';:*-+()@#$%&01234567890");
		else return ("There was no ice cream in the freezer, nor did they have money to go to the store./?.,><';:*-+()@#$%&01234567890");
	}

}
