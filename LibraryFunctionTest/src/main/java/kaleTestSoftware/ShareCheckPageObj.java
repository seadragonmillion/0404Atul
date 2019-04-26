package kaleTestSoftware;

import org.openqa.selenium.By;


public class ShareCheckPageObj {

	public By LoadingMessage = By.className("ui-icon-loading");
	public By StickyPopUp = By.cssSelector(".sticky.border-top-right.sticky-error");
	public By NotificationBell = By.id("pii-notification-button");
	public By NotificationFirstRecord = By.xpath(".//*[@id='pii-notif-jqgrid']/tbody/tr[2]");
	public By NotificationFirstRecordReportTitle = By.xpath(".//*[@id='pii-notif-jqgrid']/tbody/tr[2]/td[7]");
	public By NotificationOpenButton = By.id("pii-notif-report-btn");
	public By NotificationCount = By.id("pii-notification-count");
	public By NotificationFirstRecordDescriptionText = By.xpath(".//*[@id='pii-notif-jqgrid']/tbody/tr[2]/td[6]");
	public By NotificationReadButton = By.id("pii-notif-ack-btn");
	public By NotificationReadConfirmButton = By.id("pii-notifcenter-dialog-confirmed");
	public By LoginNameOnTopRight = By.id("pii-user-loginname");
	public By ActivityOnTopRight = By.id("pii-user-activity");
	public By AccountOnTopRight = By.id("pii-user-acct");
	public By ModuleTitle = By.id("pii-user-home-title");
	public By SharedReportDownloadButton = By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[1]");
	public By PIIContactButton = By.linkText("CONTACT");
	public By KALESupportButton = By.id("pii-contact-mailto");
	public By UserAccountSaveButton = By.id("pii-admin-user-button-save");
	public By UserAccountSavePopupTitle = By.id("pii-admin-user-dialog-title");
	public By UserAccountSavePopupSaveButton = By.id("pii-admin-user-dialog-confirmed");
	public By SharePageCancelButton = By.id("pii-uhshare-cancel");
}
