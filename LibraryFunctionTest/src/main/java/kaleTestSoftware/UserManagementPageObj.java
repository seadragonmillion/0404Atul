package kaleTestSoftware;

import org.openqa.selenium.By;

public class UserManagementPageObj {

	//Company
	public By CompanySaveButton = By.id("pii-admin-cust-button-save");
	public By CompanySaveConfirmButton = By.id("pii-admin-cust-dialog-confirmed");
	//Errors
	public By CompanyIdError = By.id("pii-admin-cust-cid-error");
	public By CompanyNameError = By.id("pii-admin-cust-name-error");
	public By CompanyAddressError = By.id("pii-admin-cust-address-error");
	public By CompanyPhoneError = By.id("pii-admin-cust-tel-error");
	public By CompanyBusinessContactError = By.id("pii-admin-cust-busCts-error");
	public By CompanyTechnicalContactError = By.id("pii-admin-cust-tecCts-error");
	
}
