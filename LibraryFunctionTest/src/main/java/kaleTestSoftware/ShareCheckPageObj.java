package kaleTestSoftware;

import org.openqa.selenium.By;


public class ShareCheckPageObj {

	By LoadingMessage = By.className("ui-icon-loading");
	By StickyPopUp = By.cssSelector(".sticky.border-top-right.sticky-error");
	By NotificationBell = By.id("pii-notification-button");
	By NotificationFirstRecord = By.xpath(".//*[@id='pii-notif-jqgrid']/tbody/tr[2]");
	By NotificationFirstRecordReportTitle = By.xpath(".//*[@id='pii-notif-jqgrid']/tbody/tr[2]/td[7]");
	By NotificationOpenButton = By.id("pii-notif-report-btn");
	By NotificationCount = By.id("pii-notification-count");
	By NotificationFirstRecordDescriptionText = By.xpath(".//*[@id='pii-notif-jqgrid']/tbody/tr[2]/td[6]");
	By NotificationReadButton = By.id("pii-notif-ack-btn");
	By NotificationReadConfirmButton = By.id("pii-notifcenter-dialog-confirmed");
	By LoginNameOnTopRight = By.id("pii-user-loginname");
	By ActivityOnTopRight = By.id("pii-user-activity");
	By ModuleTitle = By.id("pii-user-home-title");
	By SharedReportDownloadButton = By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[1]");
	By PIIContactButton = By.linkText("CONTACT");
	By KALESupportButton = By.id("pii-contact-mailto");
}
