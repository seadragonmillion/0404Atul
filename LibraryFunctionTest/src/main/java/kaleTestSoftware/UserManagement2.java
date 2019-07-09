package kaleTestSoftware;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserManagement2 {

	UserManagementPageObj um = new UserManagementPageObj();
	ShareCheck2 share2 = new ShareCheck2();
	Login login = new Login ();
	LoginPageObj lpo = new LoginPageObj();

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

	public void verifyNoCompanyIdError (WebDriver driver, SoftAssertions softly) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,40);
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		//Activity		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-acct"))).click();
		share2.loadingServer(driver);
		//Select nothing for company id
		Select dd = new Select (driver.findElement(By.id("pii-admin-user-customerId")));
		dd.selectByIndex(0);
		//Click on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-button-save"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-confirmed"))).click();
		//Verify error
		String message = wait.until(ExpectedConditions.visibilityOfElementLocated(um.EditUserMessageOnTop)).getText().trim();
		softly.assertThat(message).as("test data").contains("a user must have a company id specified.");
	}
	
	public void createExistingUserAndVerifyErrorPopup(WebDriver driver, SoftAssertions softly, String company_id, String password,String email) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,40);
		Thread.sleep(2000);
		//Clicks on create user
		driver.findElement(By.id("pii-admin-user-create")).click();
		Thread.sleep(2000);
		//Enters mandatory details
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-loginname"))).sendKeys(company_id+"testcm");
		driver.findElement(By.id("pii-admin-user-name")).sendKeys(company_id+"testcm");
		driver.findElement(By.id("pii-admin-user-password")).sendKeys(login.decodePassword(password));
		driver.findElement(By.id("pii-admin-user-password-again")).sendKeys(login.decodePassword(password));
		driver.findElement(By.id("pii-admin-user-company")).sendKeys("Sanity Test");
		driver.findElement(By.id("pii-admin-user-email")).sendKeys(email);
		String ev1 = driver.findElement(By.id("pii-admin-user-name")).getAttribute("value");
		String ev2 = driver.findElement(By.id("pii-admin-user-company")).getAttribute("value");
		String ev3 = driver.findElement(By.id("pii-admin-user-email")).getAttribute("value");
		if ((ev1.equals(company_id+"testcm")==false))
		{
			driver.findElement(By.id("pii-admin-user-name")).clear();
			driver.findElement(By.id("pii-admin-user-name")).sendKeys(company_id);
		}
		if ((ev2.equals("Sanity Test")==false))
		{
			driver.findElement(By.id("pii-admin-user-company")).clear();
			driver.findElement(By.id("pii-admin-user-company")).sendKeys("Sanity Test");
		}
		if ((ev3.equals(email)==false))
		{
			driver.findElement(By.id("pii-admin-user-email")).clear();
			driver.findElement(By.id("pii-admin-user-email")).sendKeys(email);
		}
		Select dd4 = new Select (driver.findElement(By.id("pii-admin-user-customerId")));
		dd4.selectByVisibleText(company_id);
		driver.findElement(By.id("pii-admin-user-groups-button")).click();
		WebElement ele1 = driver.findElement(By.id("pii-admin-user-groups-menu"));
		ele1.findElement(By.linkText(company_id)).click();
		driver.findElement(By.xpath(".//*[@id='pii-admin-user-groups-listbox-popup']/div/div/a")).click();
		Select dd2 = new Select (driver.findElement(By.id("pii-admin-user-dept")));
		dd2.selectByVisibleText("Accounting");
		Select dd3 = new Select (driver.findElement(By.id("pii-admin-user-jobtitle")));
		dd3.selectByVisibleText("Engineer");	
		//Click on Company Moderator as yes
		driver.findElement(By.xpath(".//*[@for='pii-admin-user-customerAdmin-yes']")).click();
		//Clicks on save button
		driver.findElement(By.id("pii-admin-user-button-save")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-title")));
		//Clicks on Save button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-confirmed"))).click();
		try{
			String error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note"))).getText();
			softly.assertThat(error).as("test data").isEqualTo("User already exists: "+company_id+"testcm"+".");
			System.out.println(error);
			wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.StickyClose)).click();
		}catch(org.openqa.selenium.TimeoutException r)
		{

		}		
	}
}
