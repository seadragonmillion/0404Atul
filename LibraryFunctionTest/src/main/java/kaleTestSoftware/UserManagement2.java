package kaleTestSoftware;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserManagement2 {
	
	UserManagementPageObj um = new UserManagementPageObj();

	public void verifyErrorOnCompanyPage (WebDriver driver, SoftAssertions softly) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,40);
		//Click on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(um.CompanySaveButton)).click();
		//Verify all errors
		String idError = driver.findElement(um.CompanyIdError).getText();
		softly.assertThat(idError).as("test data").isEqualTo("Company ID is required");
		String nameError = driver.findElement(um.CompanyNameError).getText();
		softly.assertThat(nameError).as("test data").isEqualTo("Company name is required");
		String addressError = driver.findElement(um.CompanyAddressError).getText();
		softly.assertThat(addressError).as("test data").isEqualTo("Company address is required");
		String phoneError = driver.findElement(um.CompanyPhoneError).getText();
		softly.assertThat(phoneError).as("test data").isEqualTo("Company telephone is required");
		String busContactError = driver.findElement(um.CompanyBusinessContactError).getText();
		softly.assertThat(busContactError).as("test data").isEqualTo("Company business contact is required");
		String techContactError = driver.findElement(um.CompanyTechnicalContactError).getText();
		softly.assertThat(techContactError).as("test data").isEqualTo("Company technical contact is required");
		//softly.assertAll();
	}

}
