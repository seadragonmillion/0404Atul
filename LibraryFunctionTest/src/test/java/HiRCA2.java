import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HiRCA2 {

	EiRCAPageObj eirca = new EiRCAPageObj();
	LoginPageObj login = new LoginPageObj();
	ShareCheck2 share2 = new ShareCheck2();
	
	//Info Page
	By HiRCANewReportButton = By.id("efi-irca-button-new");
	//Popup inside report
	By HiRCAPopupHeader = By.id("pii-irca-dialog-header");
	By HiRCAPopupMessage = By.id("pii-irca-dialog-title");
	By HiRCAPopupNote = By.id("pii-irca-dialog-note");
	By HiRCAPopupConfirmButton = By.id("pii-irca-dialog-confirmed");
	By HiRCAPopupConfirmButton2 = By.id("pii-irca-dialog-confirmed2");
	By HiRCAPopupCancelButton = By.id("pii-irca-dialog-cancel");
	
	public void verifyStickyUserAccount(WebDriver driver, SoftAssertions softly, String username) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,60);
		try{
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyNote)).getText();
			softly.assertThat(s).as("test data").isEqualTo("User updated: "+username+".");
			System.out.println(s);
			wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyClose)).click();
		}catch(org.openqa.selenium.TimeoutException r)
		{
			System.out.println("Couldn't find share save pop up");
		}
	}

	public void verifySticky1ImageUploaded(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,60);
		try{
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyNote)).getText();
			softly.assertThat(s).as("test data").isEqualTo("All changed supporting files saved successfully (1)");
			System.out.println(s);
			wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyClose)).click();
		}catch(org.openqa.selenium.TimeoutException r)
		{
			System.out.println("Couldn't find share save pop up");
		}
	}

	public void verifySticky5ImageUploaded(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,60);
		try{
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyNote)).getText();
			softly.assertThat(s).as("test data").isEqualTo("All changed supporting files saved successfully (5)");
			System.out.println(s);
			wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyClose)).click();
		}catch(org.openqa.selenium.TimeoutException r)
		{
			System.out.println("Couldn't find share save pop up");
		}
	}

	public void verifyStickySaveReport(WebDriver driver, SoftAssertions softly, String username, String reportTitle, int n) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,60);
		try{
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyNote)).getText();
			String r = s.replaceAll("\u00AD", "");
			softly.assertThat(r).as("test data").contains(username+"_"+reportTitle);
			if(n == 0)
				softly.assertThat(r).as("test data").contains("HiRCA™ Data created for id: ");
			else
				softly.assertThat(r).as("test data").contains("HiRCA™ Data updated for id: ");
			wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyClose)).click();
		}catch(org.openqa.selenium.TimeoutException r)
		{
			System.out.println("Couldn't find save pop up");
		}
	}

	public void verifyStickyDeleteReport(WebDriver driver, SoftAssertions softly, String recordName) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,60);
		try{
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyNote)).getText();
			String r = s.replaceAll("\u00AD", "");
			String r1 = recordName.replaceAll("\u00AD", "");
			softly.assertThat(r).as("test data").isEqualTo("HiRCA™ data deleted: "+r1);
			wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyClose)).click();
		}catch(org.openqa.selenium.TimeoutException r)
		{
			System.out.println("Couldn't find delete pop up");
		}
	}

	public void verifyDeleteFilePopup(WebDriver driver, SoftAssertions softly, int k) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HiRCAPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Delete Supporting file");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(HiRCAPopupMessage)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Are you sure you want to delete supporting file ("+k+")?");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(HiRCAPopupNote)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Warning: deleted content cannot be recovered later.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(HiRCAPopupCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Cancel");
		//Save button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(HiRCAPopupConfirmButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("Delete");
	}

	public void verifyNoSupportingFilePopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HiRCAPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Use existing empty form");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(HiRCAPopupMessage)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Please use existing empty supporting file form above");
		//ok button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(HiRCAPopupConfirmButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("ok");
	}

	public void verifyInfoPageErrorPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HiRCAPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Invalid Data Entry");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(HiRCAPopupMessage)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Please fix all errors mentioned in red.");
		//ok button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(HiRCAPopupConfirmButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("ok");
	}

	public void verifySavePopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HiRCAPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Save Report");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(HiRCAPopupMessage)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Are you sure you want to save current event report?");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(HiRCAPopupCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Cancel");
		//Save button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(HiRCAPopupConfirmButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("Save Report");
	}

	public void verifyNewReportPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HiRCAPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("New Report");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(HiRCAPopupMessage)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Would you like to confirm you want to erase the current report and create a new report?");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(HiRCAPopupNote)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Note: erased content cannot be recovered later.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(HiRCAPopupCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Cancel");
		//New button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(HiRCAPopupConfirmButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("New Report");
	}	

	public void verifyOpenReportPopup(WebDriver driver, SoftAssertions softly, String recordName) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Open");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).getText();
		String r = s1.replaceAll("\u00AD", "");
		String r1 = recordName.replaceAll("\u00AD", "");
		softly.assertThat(r).as("test data").isEqualTo("Do you confirm you want to open HiRCA™ report referenced as: "+r1+"?");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupNote)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Warning: once you load this version, any changes on the report will override existing data.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Cancel");
		//Open button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("Open");
	}	

	public void verifyDeleteReportPopup(WebDriver driver, SoftAssertions softly, String recordName) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Delete Report");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).getText();
		String r = s1.replaceAll("\u00AD", "");
		String r1 = recordName.replaceAll("\u00AD", "");
		if(r.contains("This report is currently open in "))
				softly.assertThat(r).as("test data").isEqualTo("This report is currently open in HiRCA™, are you sure you want to delete this report ["+r1+"]?");
			else
				softly.assertThat(r).as("test data").isEqualTo("Are you sure you want to delete this HiRCA™ report ["+r1+"]?");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupNote)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Note: deleted data cannot be recovered later.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Cancel");
		//Open button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("delete report");
	}
	
	public void verifyLOPRCPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HiRCAPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("LOP or Root Cause");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(HiRCAPopupMessage)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Do you want to (1) continue to analyze Layer Of Protection failures or (2) proceed to determine event root cause?");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(HiRCAPopupNote)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Note: LOP can be done afterwards by re-opening an existing report.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(HiRCAPopupCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Cancel");
		//LOP button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(HiRCAPopupConfirmButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("LOP");
		//LOP button
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(HiRCAPopupConfirmButton2)).getText();
		softly.assertThat(s5).as("test data").isEqualTo("Root Cause");
	}

	public void verifyChangeLanguage(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		HiRCAChinese obj1 = new HiRCAChinese();
		LanguageCheckOfReports obj2 = new LanguageCheckOfReports();
		//Change language to english
		obj1.changeToEnglish(driver);
		//Click on Analysis
		share2.loadingServer(driver);  
		//Clicks on Analysis 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-a"))).click();
		//Click on HiRCA
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-hirca"))).click();
		//Verify the language as english
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();		
		if (obj2.containsHanScript(s)==true)
			softly.fail("Not in english");
		//Change language to chinese
		obj1.changeToChinese(driver);		
		//Click on Analysis
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-a"))).click();
		//Click on HiRCA
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-hirca"))).click();
		//Verify the language as chinese in test		
		share2.loadingServer(driver);
	}	
}
