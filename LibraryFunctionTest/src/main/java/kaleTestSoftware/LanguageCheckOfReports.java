package kaleTestSoftware;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LanguageCheckOfReports {

	SoftAssertions softly = new SoftAssertions();
	
	ShareCheck2 share2 = new ShareCheck2();

	public boolean containsHanScript(String s) {
		return s.codePoints().anyMatch(
				codepoint ->
				Character.UnicodeScript.of(codepoint) == Character.UnicodeScript.HAN);
	}

	public void chineseCheck(String s) throws Exception{

		if (containsHanScript(s)==false)
			softly.fail("Not in chinese");
	}

	public void englishCheck(String s) {
		if (containsHanScript(s)==true)
			softly.fail("Not in english: "+s);
	}

	public void downloadSelectFunction(WebDriver driver, int y, WebElement l, String browserName, String v)throws Exception {

		//Download report to check pdf
		if (browserName.equals("chrome"))
			downloadReportChrome (driver, y, l);
		if (browserName.equals("firefox"))
			downloadReportFirefox (driver, y, l);
		if (browserName.equals("internet explorer"))
		{
			if (v.startsWith("10"))
				downloadReportIE (driver, y, l);
			if (v.startsWith("11"))
				downloadReportIE11 (driver, y, l);
		}
	}

	public void verifyLabelUserAccount(WebDriver driver,SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		//page title
		String title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-title"))).getText();
		softly.assertThat(title).as("test data").isEqualTo("User Profile");
		//login name
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-admin-user-loginname']"))).getText();
		softly.assertThat(s).as("test data").isEqualTo("Login name:");
		//Password
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-admin-user-password']"))).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Password:");
		//Retype password
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-admin-user-password-again']"))).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Re-type Password:");
		//Language
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-user-div']/form/div[6]/fieldset/div/legend"))).getText();
		softly.assertThat(s3).as("test data").isEqualTo("Language:");
		//name
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-admin-user-name']"))).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Name:");
		//company name
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-admin-user-company']"))).getText();
		softly.assertThat(s5).as("test data").isEqualTo("Company name:");
		//department
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-user-div']/form/div[10]/fieldset/div/legend"))).getText();
		softly.assertThat(s6).as("test data").isEqualTo("Department:");
		//sub- dept
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-user-div']/form/div[11]/fieldset/div/legend"))).getText();
		softly.assertThat(s7).as("test data").isEqualTo("Sub-department:");
		//job title
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-user-div']/form/div[12]/fieldset/div/legend"))).getText();
		softly.assertThat(s8).as("test data").isEqualTo("Job title:");
		//email
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-admin-user-email']"))).getText();
		softly.assertThat(s9).as("test data").isEqualTo("Email:");
		//certification
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-user-div']/form/div[14]/fieldset/div/legend"))).getText();
		softly.assertThat(s10).as("test data").isEqualTo("PII Certification Level:");
		//license
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-admin-user-license']"))).getText();
		softly.assertThat(s11).as("test data").isEqualTo("License agreement:");
		//Verify place holder for password
		//enter password
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-password"))).getAttribute("placeholder");
		softly.assertThat(s12).as("test data").isEqualTo("(Optional) Enter password: 8 characters min, min 1 number, min 1 letter upper and 1 lower, min 1 special char.");
		//enter password again
		String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-password-again"))).getAttribute("placeholder");
		softly.assertThat(s13).as("test data").isEqualTo("(Optional) Enter password again: must be the exactly the same.");
	}

	public void languageChangeTest(WebDriver driver,String username,String password) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		Login obj = new Login();
		HiRCA2 obj2 = new HiRCA2();
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		String v = cap.getVersion().toString();
		//Set parameters
		changeAccountPage(driver,username);
		//Checks language in error meter
		WebElement l = errorMeter(driver,0);
		downloadSelectFunction(driver, 0, l,browserName,v);
		//Checks language in HPI
		hpi(driver,0);
		//Checks language in HiRCA
		l = hirca(driver,0);
		downloadSelectFunction(driver, 0, l,browserName,v);
		//Checks language in EiRCA
		l = eirca(driver,0);
		downloadSelectFunction(driver, 0, l,browserName,v);
		//Checks language in O&PiRCA
		l = opirca(driver,0);
		downloadSelectFunction(driver, 0, l,browserName,v);
		//Checks language in Job Observation
		jobs(driver,0);
		//Checks language in 3 Pass Review
		passReview(driver,0);
		//Checks language in Remote Verification
		l = rv(driver,0);
		downloadSelectFunction(driver, 0, l,browserName,v);
		//Logs out
		obj.logout(driver);
		if (browserName.equals("firefox"))
			driver.switchTo().defaultContent();
		//Login again
		obj.LoginUser(driver, username, password);
		//wait for loading message
		share2.loadingServer(driver);
		//Switches to the iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		Thread.sleep(5000);
		//Clicks on Account
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-acct"))).click();
		//Verifies changed data
		String name=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-name"))).getAttribute("value");
		System.out.println(name);
		softly.assertThat(name).as("test data").isEqualTo("QAA changed");
		String company =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-company"))).getAttribute("value");
		System.out.println(company);
		softly.assertThat(company).as("test data").isEqualTo("QAA-PII changed");
		String dept=driver.findElement(By.xpath(".//*[@id='pii-admin-user-dept-button']/span")).getText();
		System.out.println(dept);
		softly.assertThat(dept).as("test data").isEqualTo("Design Engineering");
		String jobTitle=driver.findElement(By.xpath(".//*[@id='pii-admin-user-jobtitle-button']/span")).getText();
		System.out.println(jobTitle);
		softly.assertThat(jobTitle).as("test data").isEqualTo("Support");
		String email=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-email"))).getAttribute("value");
		System.out.println(email);
		softly.assertThat(email).as("test data").isEqualTo("Email changed");
		//Changes data back to original value
		//Change Name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-name"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-name"))).sendKeys("QAA");
		//Change Company name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-company"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-company"))).sendKeys("QAA-PII");
		//Change department
		WebElement dropdown2 = driver.findElement(By.id("pii-admin-user-dept"));
		Select s2 = new Select (dropdown2);
		s2.selectByVisibleText("Information Technology (IT)");
		//Change job title
		WebElement dropdown3 = driver.findElement(By.id("pii-admin-user-jobtitle"));
		Select s3 = new Select (dropdown3);
		s3.selectByVisibleText("Engineer");
		//Change email id
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-email"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-email"))).sendKeys("rramakrishnan@errorfree.com");
		//Changes language to English
		WebElement dropdown1 = driver.findElement(By.id("pii-admin-user-language"));
		Select s5 = new Select (dropdown1);
		s5.selectByVisibleText("English");
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-button-save"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-confirmed"))).click();
		//verify sticky
		obj2.verifyStickyUserAccount(driver, softly, username);
		//Waits for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on Activity
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-activity"))).click();
		//Waits for loading message to disappear
		share2.loadingServer(driver);
		//Checks language in error meter
		l=errorMeter(driver,1);
		downloadSelectFunction(driver, 1, l,browserName,v);
		//Checks language in HPI
		hpi(driver,1);
		//Checks language in HiRCA
		l=hirca(driver,1);
		downloadSelectFunction(driver, 1, l,browserName,v);
		//Checks language in EiRCA
		l=eirca(driver,1);
		downloadSelectFunction(driver, 1, l,browserName,v);
		//Checks language in O&PiRCA
		l=opirca(driver,1);
		downloadSelectFunction(driver, 1, l,browserName,v);
		//Checks language in Job Observation
		jobs(driver,1);
		//Checks language in 3 Pass Review
		passReview(driver,1);
		Thread.sleep(2000);
		//Checks language in Remote Verification
		l=rv(driver,1);
		downloadSelectFunction(driver, 1, l,browserName,v);
	}

	public void verifyLabelAdminUserAccount(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		//Verify all label which are same as non admin user
		verifyLabelUserAccount(driver,softly);
		//Labels which are visible only to admin user
		//Activation status
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-admin-user-status']"))).getText();
		softly.assertThat(s).as("test data").isEqualTo("Activation status:");
		//Select group
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-user-groups-div']/fieldset/div[1]/legend"))).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Select group(s):");
		//Cases slide security
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-user-slidesecurity']/div[1]/legend"))).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Cases slide security:");
		//Company ID
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-user-customerId-div']/fieldset/div[1]/legend"))).getText();
		softly.assertThat(s3).as("test data").isEqualTo("Company ID:");
		//Company moderator
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-user-customerAdmin']/div[1]/legend"))).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Company moderator:");
		//Group moderator
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-user-modgroups-div']/fieldset/div[1]/legend"))).getText();
		softly.assertThat(s5).as("test data").isEqualTo("Group moderator:");
		//Verify all fields are present
		//Login name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-loginname")));
		//Reset password and send email button
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-resend-button"))).getText();
		softly.assertThat(s6).as("test data").isEqualTo("reset password and send email");
		//Language
		driver.findElement(By.id("pii-admin-user-language"));
		//Select groups
		driver.findElement(By.id("pii-admin-user-groups-button"));
		//Name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-name")));
		//Company name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-company")));
		//Dept
		driver.findElement(By.id("pii-admin-user-dept"));
		//Sub dept
		driver.findElement(By.id("pii-admin-user-subdept-button"));
		//job title
		driver.findElement(By.id("pii-admin-user-jobtitle"));
		//email
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-email")));
		//cerificate level
		driver.findElement(By.id("pii-admin-user-certif"));
		//case slide on button
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-admin-user-slidesecurity-on']"))).getText();
		softly.assertThat(s7).as("test data").isEqualTo("On");
		//case slide off button
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-admin-user-slidesecurity-off']"))).getText();
		softly.assertThat(s8).as("test data").isEqualTo("Off");
		//company id
		driver.findElement(By.id("pii-admin-user-customerId"));
		//company moderator on button
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-admin-user-customerAdmin-no']"))).getText();
		softly.assertThat(s9).as("test data").isEqualTo("No");
		//company moderator off button
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-admin-user-customerAdmin-yes']"))).getText();
		softly.assertThat(s10).as("test data").isEqualTo("Yes");
		//group moderator
		driver.findElement(By.id("pii-admin-user-modgroups-button"));
		//license
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-license")));
	}

	public void verifyAccountPageAdminUser(WebDriver driver, String username, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		HiRCA2 obj = new HiRCA2();
		//Waits for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on Account
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-acct"))).click();
		//Waits for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on Account
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-acct"))).click();
		//Waits for loading message to disappear
		share2.loadingServer(driver);
		//verify labels
		verifyLabelAdminUserAccount(driver,softly);
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-button-save"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-confirmed"))).click();
		//Verify sticky 
		obj.verifyStickyUserAccount(driver, softly, username);
		//Waits for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on Activity
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-activity"))).click();
		//Waits for loading message to disappear
		share2.loadingServer(driver);
	}

	public void changeAccountPage(WebDriver driver, String username) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		HiRCA2 obj = new HiRCA2();
		//Waits for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on Account
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-acct"))).click();
		//verify labels
		verifyLabelUserAccount(driver,softly);
		//Change Name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-name"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-name"))).sendKeys("QAA changed");
		//Change Company name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-company"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-company"))).sendKeys("QAA-PII changed");
		//Change department
		WebElement dropdown = driver.findElement(By.id("pii-admin-user-dept"));
		Select s = new Select (dropdown);
		s.selectByVisibleText("Design Engineering");
		//Change job title
		WebElement dropdown1 = driver.findElement(By.id("pii-admin-user-jobtitle"));
		Select s1 = new Select (dropdown1);
		s1.selectByVisibleText("Support");
		//Change email id
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-email"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-email"))).sendKeys("Email changed");
		//Changes language to Chinese
		dropdown1 = driver.findElement(By.id("pii-admin-user-language"));
		Select s4 = new Select (dropdown1);
		s4.selectByVisibleText("Chinese");
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-button-save"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-confirmed"))).click();
		//Verify sticky 
		obj.verifyStickyUserAccount(driver, softly, username);
		//Waits for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on Activity
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-activity"))).click();
		//Waits for loading message to disappear
		share2.loadingServer(driver);
	}

	public void downloadReportIE(WebDriver driver, int y, WebElement element) throws Exception {

		//deletes files in reports folder before starting to download
		File file = new File("C://Users//IEUser//Downloads//reports//");
		deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		Thread.sleep(2000);
		//Clicks on download button
		element.click();
		Thread.sleep(3000);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title")));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		Thread.sleep(7000);
		Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/SavePdf.exe");
		q.waitFor();
		Thread.sleep(15000);
		//pdf verification
		pdfCheck(y);
		Thread.sleep(8000);
		//Switch to window    	
		driver.switchTo().window(window);
		Thread.sleep(4000);
		//Switches to the iframe
		wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));

	}

	public void downloadReportIE11(WebDriver driver, int y, WebElement element) throws Exception {

		//deletes files in reports folder before starting to download
		File file = new File("C://Users//IEUser//Downloads//reports//");
		deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		Thread.sleep(2000);
		//Clicks on download button
		element.click();
		Thread.sleep(3000);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title")));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		Thread.sleep(6000);
		try{
			try {
				Process q = Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/SavePdf.exe");
				q.waitFor();
			}catch (UnhandledAlertException g){
				System.out.println("Unexpected alert");
				driver.switchTo().alert().accept();
			}
		}catch (NoAlertPresentException g){			  
			System.out.println ("No unexpected alerts");
		}
		Thread.sleep(15000);
		//pdf verification
		pdfCheck(y);
		Thread.sleep(8000);
		//Switch to window    	
		driver.switchTo().window(window);
		Thread.sleep(8000);
		//Switches to the iframe
		try{
			try{
				wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
			}catch (UnhandledAlertException g1){
				wait1.until(ExpectedConditions.alertIsPresent());
				driver.switchTo().alert().dismiss();
			}
		}catch (NoAlertPresentException g){			  
			System.out.println ("No unexpected alerts");
		}catch(org.openqa.selenium.TimeoutException t){
			System.out.println ("Timed out: No unexpected alerts");
		}
		try{
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		}catch (NoSuchElementException e)
		{

		}
	}

	public void downloadReportFirefox (WebDriver driver, int y, WebElement element) throws Exception {

		//deletes files in reports folder before starting to download
		File file = new File("C://Users//IEUser//Downloads//reports//");
		deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		//Clicks on download button
		element.click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title")));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		Thread.sleep(12000);
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(14000);
		Robot robot = new Robot();
		// press Ctrl+S the Robot's way
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_S);
		Thread.sleep(8000);
		Process p= Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/PDFReportFirefox.exe");
		p.waitFor();
		Thread.sleep(4000);
		pdfCheck(y);
		Thread.sleep(4000);
		driver.close();
		Thread.sleep(4000);
		driver.switchTo().window(window);
		driver.switchTo().defaultContent();
		Thread.sleep(4000);
		//Switches to the iframe
		wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));

	}

	public void downloadReportChrome (WebDriver driver, int y, WebElement element) throws Exception {
		//deletes files in reports folder before starting to download
		File file = new File("C://Users//IEUser//Downloads//reports");
		deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		String window = driver.getWindowHandle();
		//Clicks on download button
		element.click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title")));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		Thread.sleep(3000);
		pdfCheck(y);
		for(String winHandle : driver.getWindowHandles())
		{
			driver.switchTo().window(winHandle);
		}
		driver.close();
		driver.switchTo().window(window);
		Thread.sleep(4000);
		//Switches to the iframe
		wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
	}

	public void deleteFiles(File folder) throws IOException {
		File[] files = folder.listFiles();
		for(File file: files){
			if(file.isFile()){
				String fileName = file.getName();
				boolean del= file.delete();
				System.out.println(fileName + " : got deleted ? " + del);
			}else if(file.isDirectory()) {
				deleteFiles(file);
			}
		}
	}

	public void pdfCheck(int y) throws Exception {

		// specify your directory
		Path dir = Paths.get("C://Users//IEUser//Downloads//reports//");  
		// here we get the stream with full directory listing
		// exclude subdirectories from listing
		// finally get the last file using simple comparator by lastModified field
		Optional<Path> lastFilePath = Files.list(dir).filter(f -> !Files.isDirectory(f)).max(Comparator.comparingLong(f -> f.toFile().lastModified()));  
		try{
			System.out.println(lastFilePath.get());
		}catch(java.util.NoSuchElementException t)
		{
			
		}
		//Loads the file to check if correct data is present
		String fileName=lastFilePath.get().toString();
		File oldfile = new File(fileName);
		PDDocument pddoc= PDDocument.load(oldfile);
		//Checks text in pdf
		String data = new PDFTextStripper().getText(pddoc);
		List<String> ans= Arrays.asList(data.split("\r\n"));
		String newData="";
		for (int i = 0; i < ans.size(); i++)
		{	        	
			int n=ans.get(i).length()-1;
			if (ans.get(i).charAt(n)==' ')
				newData = newData+ans.get(i);
			if (ans.get(i).charAt(n)!=' ')
				newData = newData+" "+ans.get(i);	        	
		}
		if (y==0)
			chineseCheck(newData);
		if (y==1)
			englishCheck(newData);
		//Close pdf
		pddoc.close();
	}

	public WebElement errorMeter(WebDriver driver, int y) throws Exception{
		WebDriverWait wait = new WebDriverWait(driver,40);
		List<String> s = new ArrayList<String>();
		//Clicks on error meter side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-epm"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on first newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-epm']/ul/li[2]/a"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Stores text of SPV title
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-title"))).getText());
		//Stores text of Mark critical
		//s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-uhome-epm-critical-input']"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div[2]/div/label"))).getText());
		//Stores text of username label
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/table/tbody/tr/td/strong"))).getText());
		//Stores text of username label
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/table/tbody/tr[2]/td/strong"))).getText());
		//Stores text of date label
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/table/tbody/tr/td[2]/strong"))).getText());
		//Stores text of time label
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/table/tbody/tr[2]/td[2]/strong"))).getText());
		//Stores text of download button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[1]"))).getText());
		//Stores text of delete button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).getText());
		//Stores text of share button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[3]"))).getText());
		//Stores text of label of error %
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/table[3]/tbody/tr/td/span"))).getText());
		//Stores text of label of error low
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/table[3]/tbody/tr/td[2]/span"))).getText());
		//Stores text of Error Low
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/table[3]/tbody/tr/td[2]/strong"))).getText());
		//Stores text of label of PJB
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div/div[1]/strong"))).getText());
		//Stores text of label of Analysis
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div/div[2]/strong"))).getText());
		//Stores text of label of report title
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div/div[3]/strong"))).getText());
		//Stores text of label of 1-general review
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div/div[4]/strong"))).getText());
		//Stores text of PAPE full form
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/table[4]/tbody/tr/td/span"))).getText());
		//Stores text of label of 1st table 1st column
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr/th[2]"))).getText());
		//Stores text of label of 1st table 2nd column
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr/th[3]"))).getText());
		//Stores text of label of 1st table 3rd column
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr/th[4]"))).getText());
		//Stores text of label of 2nd table 1st column
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr/th[2]"))).getText());
		//Stores text of label of 2nd table 2nd column
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr/th[3]"))).getText());
		//Stores text of label of 2nd table 3rd column
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr/th[4]"))).getText());
		//Stores text of label of 3rd table 1st column
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr/th[2]"))).getText());
		//Stores text of label of 3rd table 2nd column
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr/th[3]"))).getText());
		//Stores text of label of 3rd table 3rd column
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr/th[4]"))).getText());
		//Stores text of label of 4th table 1st column
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr/th[2]"))).getText());
		//Stores text of label of 4th table 2nd column
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr/th[3]"))).getText());
		//Stores text of label of 4th table 3rd column
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr/th[4]"))).getText());
		System.out.println(s);
		//Checks the language is correct or not
		for (int i=0;i<s.size();i++)
		{
			if (y==0)
				chineseCheck(s.get(i));
			if (y==1)
				englishCheck(s.get(i));
		}		
		//Clear the list s
		s.clear();
		return (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[1]"))));
	}


	public void hpi(WebDriver driver, int y) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,40);
		List<String> s = new ArrayList<String>();
		//Clicks on hpi side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-hpi"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on first newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-hpi']/ul/li[2]/a"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Stores text of HPI title
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-title"))).getText());
		//Stores text of Mark critical
		//s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-uhome-hpi-critical-input']"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div[2]/div/label"))).getText());
		//Stores text of delete button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[1]"))).getText());
		//Stores text of share button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).getText());
		System.out.println(s);
		//Checks the language is correct or not
		for (int i=0;i<s.size();i++)
		{
			if (y==0)
				chineseCheck(s.get(i));
			if (y==1)
				englishCheck(s.get(i));
		}		
		//Clear the list s
		s.clear();		
	}

	public WebElement hirca(WebDriver driver, int y) throws Exception{
		WebDriverWait wait = new WebDriverWait(driver,40);
		List<String> s = new ArrayList<String>();
		//Clicks on hirca side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-irca"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on first newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Stores text of HiRCA title
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-title"))).getText());
		//Stores text of Mark critical
		//s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-uhome-irca-critical-input']"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div[2]/div/label"))).getText());
		//Stores text of back button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/button"))).getText());
		//Stores text of open button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[1]"))).getText());
		//Stores text of download button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).getText());
		//Stores text of delete button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[3]"))).getText());
		//Stores text of share button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[4]"))).getText());
		//Stores text of title of 1st table
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[1]/table/thead/tr/th"))).getText());
		//Stores the labels of all the rows in 1st table
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[1]/table/tbody/tr[1]/td[1]"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[1]/table/tbody/tr[2]/td[1]"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[1]/table/tbody/tr[3]/td[1]"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[1]/table/tbody/tr[3]/td[3]"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[1]/table/tbody/tr[4]/td[1]"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[1]/table/tbody/tr[5]/td[1]"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[1]/table/tbody/tr[6]/td[1]"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[1]/table/tbody/tr[7]/td[1]"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[1]/table/tbody/tr[8]/td[1]"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[1]/table/tbody/tr[9]/td[1]"))).getText());
		//Stores text of title of 2nd table
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[2]/table/thead/tr/th"))).getText());
		//Stores the labels of all the rows in 2nd table
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[2]/table/tbody/tr[1]/td[1]"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[2]/table/tbody/tr[2]/td[1]"))).getText());		
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[2]/table/tbody/tr[3]/td[1]"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[2]/table/tbody/tr[4]/td[1]"))).getText());  
		//Randomly generated tables so think about it*****
		System.out.println(s);
		//Checks the language is correct or not
		for (int i=0;i<s.size();i++)
		{
			if (y==0)
				chineseCheck(s.get(i));
			if (y==1)
				englishCheck(s.get(i));
		}		
		//Clear the list s
		s.clear();		
		return (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))));

	}

	public WebElement eirca(WebDriver driver, int y) throws Exception{
		WebDriverWait wait = new WebDriverWait(driver,40);
		List<String> s = new ArrayList<String>();
		//Clicks on eirca side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-mirca"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on first newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-mirca']/ul/li[2]/a"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);	
		//Stores text of EiRCA title
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-title"))).getText());
		//Stores text of Mark critical
		//s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-uhome-mirca-critical-input']"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div[2]/div/label"))).getText());
		//Stores text of back button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/button"))).getText());
		//Stores text of open button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[1]"))).getText());
		//Stores text of download button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).getText());
		//Stores text of delete button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[3]"))).getText());
		//Stores text of share button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[4]"))).getText());
		//Stores text of title of 1st table
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[1]/table/thead/tr/th"))).getText());
		//Stores the labels of all the rows in 1st table
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[1]/td[1]"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[2]/td[1]"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[3]/td[1]"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[4]/td[1]"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[5]/td[1]"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[6]/td[1]"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[7]/td[1]"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[8]/td[1]"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[9]/td[1]"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[10]/td[1]"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[11]/td[1]"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[12]/td[1]"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[13]/td[1]"))).getText());
		//Stores the report header
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[2]"))).getText());		
		System.out.println(s);
		//Checks the language is correct or not
		for (int i=0;i<s.size();i++)
		{
			if (y==0)
				chineseCheck(s.get(i));
			if (y==1)
				englishCheck(s.get(i));
		}		
		//Clear the list s
		s.clear();		

		return (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))));
	}

	public WebElement opirca(WebDriver driver, int y) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,40);
		List<String> s = new ArrayList<String>();
		//Clicks on opirca side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-opa"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on first newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-opa']/ul/li[2]/a"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Checks the language is correct or not
		for (int i=0;i<s.size();i++)
		{
			if (y==0)
				chineseCheck(s.get(i));
			if (y==1)
				englishCheck(s.get(i));
		}		
		//Clear the list s
		s.clear();		
		return (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))));

	}

	public void jobs(WebDriver driver, int y) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,40);
		List<String> s = new ArrayList<String>();
		//Clicks on job observation side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-joa"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on first newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-joa']/ul/li[2]/a"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Stores text of Mark critical
		//s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-uhome-jo-critical-input']"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div[2]/div/label"))).getText());
		//Stores text of back button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/button"))).getText());
		//Stores text of delete button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[1]"))).getText());
		//Stores text of share button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).getText());
		System.out.println(s);
		//Checks the language is correct or not
		for (int i=0;i<s.size();i++)
		{
			if (y==0)
				chineseCheck(s.get(i));
			if (y==1)
				englishCheck(s.get(i));
		}		
		//Clear the list s
		s.clear();		

	}

	public void passReview(WebDriver driver, int y) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,40);
		List<String> s = new ArrayList<String>();
		//Clicks on 3 pass review side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-3pr"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on first newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-3pr']/ul/li[2]/a"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Stores text of Mark critical
		//s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-uhome-3pr-critical-input']"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div[2]/div/label"))).getText());
		//Stores text of back button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/button"))).getText());
		//Stores text of open button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[1]"))).getText());
		//Stores text of delete button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).getText());
		//Stores text of share button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[3]"))).getText());
		System.out.println(s);
		//Checks the language is correct or not
		for (int i=0;i<s.size();i++)
		{
			if (y==0)
				chineseCheck(s.get(i));
			if (y==1)
				englishCheck(s.get(i));
		}		
		//Clear the list s
		s.clear();		

	}

	public WebElement rv(WebDriver driver, int y) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,40);
		List<String> s = new ArrayList<String>();
		//Clicks on remote verification side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-rv"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on first newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-rv']/ul/li[2]/a"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Stores text of Remote Verification title
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-title"))).getText());
		//Stores text of Mark critical
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div[2]/div/label"))).getText());
		//Stores text of download button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[1]"))).getText());
		//Stores text of delete button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).getText());
		//Stores text of share button
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[3]"))).getText());
		//Stores text of title of 1st table
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='rv-rpt']/div/div[1]/table/tbody/tr/th/span[1]"))).getText());
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='rv-rpt']/div/div[1]/table/tbody/tr/th/span[2]"))).getText());
		//Stores text of username
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='rv-rpt']/div/div[2]/div[1]/strong"))).getText());
		//Stores text of verifier
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='rv-rpt']/div/div[2]/div[2]/strong"))).getText());
		//Stores text of time
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='rv-rpt']/div/div[2]/div[3]/strong"))).getText());
		//Stores text of verifier status
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='rv-rpt']/div/div[2]/div[4]/strong"))).getText());
		//Stores text of 2nd table
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='rv-rpt']/div/div[3]/table/tbody/tr[1]/th/div/strong"))).getText());
		//Stores text of 3rd table
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='rv-rpt']/div/div[4]/table/tbody/tr[1]/th/div/strong"))).getText());
		//Stores text of 4th table
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='rv-rpt']/div/div[5]/table/tbody/tr[1]/th/div/strong"))).getText());
		//Stores text of 5th table
		s.add (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='rv-rpt']/div/div[6]/table/tbody/tr[1]/th/div/strong"))).getText());
		System.out.println(s);
		//Checks the language is correct or not
		for (int i=0;i<s.size();i++)
		{
			if (y==0)
				chineseCheck(s.get(i));
			if (y==1)
				englishCheck(s.get(i));
		}		
		//Clear the list s
		s.clear();	
		WebElement element=null;
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		String v = cap.getVersion().toString();
		System.out.println(v);
		if((browserName.equals("internet explorer"))&&(v.startsWith("11")))
		{
			String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[1]"))).getAttribute("class");
			System.out.println(s1);
			String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).getAttribute("class");
			System.out.println(s2);
			if(s1.contains("pii-uhome-rv-print"))
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[1]")));
			if(s2.contains("pii-uhome-rv-print"))
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]")));
			return (element);
		}
		else{
			String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[1]"))).getText();
			System.out.println(s1);
			String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).getText();
			System.out.println(s2);
			if (s1.contains("download") || (s1.contains("打印")) )
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[1]")));	
			else if (s2.contains("download")||(s1.contains("打印")))
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]")));
			return (element);
		}

	}

	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}


}
