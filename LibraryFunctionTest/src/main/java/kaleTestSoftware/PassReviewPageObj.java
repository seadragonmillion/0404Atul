package kaleTestSoftware;

import org.openqa.selenium.By;

public class PassReviewPageObj {

	public By PassReviewLink = By.id("pii-a-menu-3pr");

	//HTML report
	public By PassReviewSidePanel = By.id("pii-user-home-panel-btn-3pr");
	public By FirstRecord = By.xpath(".//*[@id='pii-user-home-activities-3pr']/ul/li[2]/a");
	public By DeleteButton = By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]");
	public By ShareButton = By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[3]");
	public By PassReviewMarkCriticalIndicatorText = By.xpath(".//*[@id='3pr-rpt']/table[1]/tbody/tr/th/strong[1]");
	public By PassReviewShareIconOrCriticalIcon = By.xpath(".//*[@id='pii-user-home-activities-3pr']/ul/li[2]/a/span[1]");
	public By PassReviewShareIconWhenAlsoMarkedCritical = By.xpath(".//*[@id='pii-user-home-activities-3pr']/ul/li[2]/a/span[2]");

	//Basic Info
	public By Reviewer = By.id("pii-3pr-tab-1-reviewer");
	public By DocumentTitle = By.id("pii-3pr-tab-1-title");
	public By DocumentTitleCharacterCount = By.id("pii-3pr-tab-1-title-count");
	public By Organisation = By.id("pii-3pr-tab-1-org");
	public By DocumentType = By.id("pii-3pr-tab-1-doctype");
	public By SaveButton = By.id("pii-3pr-save");
	public By SavePopupTitle = By.id("pii-3pr-dialog-title");
	public By SavePopupConfirmButton = By.id("pii-3pr-dialog-confirmed");
	public By SavedAcivitiesButton = By.id("pii-3pr-savedactivities");
	public By NextButttonAtBottom = By.xpath(".//*[@id='pii-3pr-tab-1-form']/div[6]/div/button");
	//Errors
	public By InfoPageReviewerError = By.id("pii-3pr-tab-1-reviewer-error");
	public By InfoPageDocTitleError = By.id("pii-3pr-tab-1-title-error");
	public By InfoPageDocTypeError = By.id("pii-3pr-tab-1-doctype-error");
	public By InfoPageOrganizationError = By.id("pii-3pr-tab-1-org-error");

	//Pass 1 Tab
	public By Pass1RequirementText = By.xpath(".//*[@id='pii-3pr-tab-2']/div[3]/table/tbody/tr[2]/td[2]/textarea");
	public By Pass1OperatingText = By.xpath(".//*[@id='pii-3pr-tab-2']/div[3]/table/tbody/tr[3]/td[2]/textarea");
	public By Pass1AssumptionText = By.xpath(".//*[@id='pii-3pr-tab-2']/div[3]/table/tbody/tr[4]/td[2]/textarea");
	public By Pass1ScopeText = By.xpath(".//*[@id='pii-3pr-tab-2']/div[3]/table/tbody/tr[5]/td[2]/textarea");
	public By Pass1TestingText = By.xpath(".//*[@id='pii-3pr-tab-2']/div[3]/table/tbody/tr[6]/td[2]/textarea");
	public By NextButton = By.id("pii-3pr-next");
	public By Pass1Tab = By.id("pii-3pr-tab-2-a");

	//Pass 2 Tab
	public By Pass2Tab = By.id("pii-3pr-tab-3-a");

	//Pass 3 Tab
	public By Pass3CriticalText = By.xpath(".//*[@id='pii-3pr-tab-4']/div[3]/table/tbody/tr[2]/td[2]/textarea");
	public By Pass3Tab = By.id("pii-3pr-tab-4-a");

	//HTML
	public By HTMLPass3CriticalText = By.xpath(".//*[@id='3pr-rpt']/div[9]/table/tbody/tr[2]/td[2]");


}
