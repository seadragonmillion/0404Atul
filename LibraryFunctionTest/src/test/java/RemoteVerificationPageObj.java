import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RemoteVerificationPageObj {

	By AnalysisLink = By.id("pii-main-menu-button-a");
	By RVLink = By.id("pii-a-menu-rv");

	//Inside Module
	By RVSaveAndSendButton = By.xpath(".//*[@id='pii-rv-tabs']/div[2]/div/a[2]");
	By RVSaveButton = By.id("pii-rv-save");
	By RVSavePopupTitle = By.id("pii-rv-dialog-title");
	By RVSavePopupComfirmButton = By.id("pii-rv-dialog-confirmed");
	By RVSavedAcivitiesButton = By.id("pii-rv-savedactivities");
	By RV1stImageField = By.id("pii-rv-imgwork-photo-input");
	By RV1stImageClearButton = By.id("pii-rv-imgwork-clear");
	By RV1stImageRotateButton = By.id("pii-rv-imgwork-rotate");
	By RV2ndImageField = By.id("pii-rv-imgperson-photo-input");
	By RV2ndImageClearButton = By.id("pii-rv-imgperson-clear");
	By RV2ndImageRotateButton = By.id("pii-rv-imgperson-rotate");
	By RVDateTimeAboveLocationImage = By.id("pii-rv-tab-1-repdatetime");
	By RVVerifierField = By.id("pii-rv-verifier-list-input");
	By RVVerifierDropdown = By.id("pii-rv-verifier-list-ul");
	By RVLatitudeLongitudeAboveLocationImage = By.id("pii-rv-imgwork-location");
	By RVLocationImage = By.id("pii-rv-imgwork-googlemap");
	By RVEventTitle = By.id("pii-rv-tab-1-title");
	By RVEventDetails = By.id("pii-rv-tab-1-details");
	By RVVerifierValue = By.id("pii-rv-verifier-name");
	By RVTitleCharacterCount = By.id("pii-rv-tab-1-title-count");

	By RVNewlyCreatedFirstRecord = By.xpath(".//*[@id='pii-user-home-activities-rv']/ul/li[2]/a");
	By RVSidePanel = By.id("pii-user-home-panel-btn-rv");
	By RVShareIconOrCriticalIcon = By.xpath(".//*[@id='pii-user-home-activities-rv']/ul/li[2]/a/span[1]");
	By RVShareIconWhenAlsoMarkedCritical = By.xpath(".//*[@id='pii-user-home-activities-rv']/ul/li[2]/a/span[2]");

	//HTML
	By RVReportNotSentStatusMessage = By.xpath(".//*[@id='rv-rpt']/div/div[2]/div[4]/span");
	By RVReportSentStatusMessage = By.xpath(".//*[@id='rv-rpt']/div/div[2]/div[5]/span");
	By RVCreationDate = By.xpath(".//*[@id='rv-rpt']/div/div[2]/div[3]");
	By RVShareButton = By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[3]");
	By RVReportCreatorUsername = By.xpath(".//*[@id='rv-rpt']/div/div[2]/div");
	By RVReportVerifierUsername = By.xpath(".//*[@id='rv-rpt']/div/div[2]/div[2]");
	By RVDownloadButton = By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a");
	By RVReportTitle = By.xpath(".//*[@id='rv-rpt']/div/div/table/tbody/tr[2]/td/strong");
	By RVReportEventDetails = By.xpath(".//*[@id='rv-rpt']/div/div[3]/table/tbody/tr[2]/td/span");
	By RVMarkedCriticalText = By.xpath(".//*[@id='rv-rpt']/div/div/table/tbody/tr/th/strong");
	By RVDeleteButton = By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]");
	By AcceptRejectConfirmPopupTitle = By.id("pii-user-home-rv-dialog-title");

	//Share Page
	By RVSharePageVerifierBlock = By.xpath(".//*[@id='pii-uhshare-verifier-list-div']/div/div/div/ul");
	
	//Verifier report view
	By VerifierAcceptButton = By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]");
	By VerifierRejectButton = By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[3]");
	By VerifierRejectComment = By.id("pii-rv-dialog-comments");
	By VerifierRejectConfirmButton = By.id("pii-user-home-rv-dialog-confirmed");
	
	//HTML creator
	By RVReportVerificationStatus = By.xpath(".//*[@id='rv-rpt']/div/div[2]/div[5]");
	By RVReportVerificationRejectedResult = By.xpath(".//*[@id='rv-rpt']/div/div[2]/div[7]/div/strong[2]");
	By RVReportVerificationAcceptedResult = By.xpath(".//*[@id='rv-rpt']/div/div[2]/div[7]/strong[2]");
	By RVReportVerificationReviseButton = By.xpath(".//*[@id='rv-rpt']/div/div[2]/div[7]/div/a");
	By RVReportVerificationComments = By.xpath(".//*[@id='rv-rpt']/div/div[2]/div[8]");
	
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
