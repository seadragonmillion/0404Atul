package kaleTestSoftware;

import java.util.HashMap;
import java.util.Random;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SRI {
	
	SoftAssertions softly = new SoftAssertions();
	Random random = new Random();
	String text = "SRI sanity test";
	
	HiRCALOPBug hlb = new HiRCALOPBug();
	EiRCAPageObj eirca = new EiRCAPageObj();
	EiRCA2 eirca2 = new EiRCA2();
	ShareCheck share = new ShareCheck();
	ErrorMeter3 em3 = new ErrorMeter3 ();
	OPiRCAPageObj opirca = new OPiRCAPageObj();
	ShareCheck2 share2 = new ShareCheck2();
	
	By SRILink = By.id("pii-a-menu-sri");
	//Step1
	By SRIStep1NextButton = By.id("pii-sri-tab-1-form-submit");
	By Step1TitleCharacterCount = By.id("pii-sri-tab-1-title-count");
	By Step1EventTitle = By.id("pii-sri-tab-1-title");
	By Step1InspectionStaff = By.id("pii-sri-tab-1-inspection-staff");
	By Step1Component = By.id("pii-sri-tab-1-component");
	By Step1EventTitleErrorText = By.id("pii-sri-tab-1-title-error");
	By Step1InspectionStaffErrorText = By.id("pii-sri-tab-1-inspection-staff-error");
	By Step1ComponentErrorText = By.id("pii-sri-tab-1-component-error");
	By Step1ComponentOther = By.id("pii-sri-tab-1-component-other");
	By Step1ReportCreation = By.id("pii-sri-tab-1-repdatetime");
	//Step 2
	By Step2Measurement = By.id("pii-sri-newentry-measurement");
	By Step2CalendarIconAddMeasurement = By.xpath(".//*[@id='pii-sri-tab-2-measurements']/div/div[1]/div[2]/div/div/a");
	By Step2ClockIconAddMeasurement = By.xpath(".//*[@id='pii-sri-tab-2-measurements']/div/div[2]/div[2]/div/div/a");
	By Step2Measurment = By.id("pii-sri-newentry-measurement");
	By Step2Value = By.id("pii-sri-newentry-value");
	By Step2Notes = By.id("pii-sri-newentry-notes");
	By Step2AddButton = By.id("pii-sri-newevent-add");
	By Step2Measurement1Date = By.id("pii-sri-tab-1-event-date");
	By Step2Measurement1DateFirefox = By.id("pii-sri-tab-1-event0-date");
	By Step2Measurement2Date = By.id("pii-sri-tab-1-event1-date");
	By Step2Measurement1Time = By.id("pii-sri-tab-1-event-time");
	By Step2Measurement1TimeFirefox = By.id("pii-sri-tab-1-event0-time");
	By Step2Measurement2Time = By.id("pii-sri-tab-1-event1-time");
	By Step2MeasurementDropDown = By.id("pii-sri-newentry-measurement-button");
	By Step2Measurement1Measurement =  By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[1]/td[4]/div/div/span");
	By Step2Measurement2Measurement = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[2]/td[4]/div/div/span");
	By Step2Measurement1Value = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[1]/td[5]/textarea");
	By Step2Measurement2Value = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[2]/td[5]/textarea");
	By Step2Measurement1Note = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[1]/td[6]/textarea");
	By Step2Measurement2Note = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[2]/td[6]/textarea");
			
	By SRINextButton = By.id("pii-sri-next");
	By SRISaveButton = By.id("pii-sri-save");
	By SRISaveConfirmButton = By.id("pii-sri-dialog-confirmed");
	By SRISavedActivitiesButton = By.id("pii-sri-savedactivities");
	By SRINewRecord = By.xpath(".//*[@id='pii-user-home-activities-sri']/ul/li[2]/a");
	By SRISidePanel = By.id("pii-user-home-panel-btn-sri");
	By SRIShareIconOrCriticalIcon = By.xpath(".//*[@id='pii-user-home-activities-sri']/ul/li[2]/a/span[1]");
	By SRIShareIconWhenAlsoMarkedCritical = By.xpath(".//*[@id='pii-user-home-activities-sri']/ul/li[2]/a/span[2]");
	By SRIMarkCriticalIndicatorText = By.xpath(".//*[@id='sri-rpt']/div[1]/table/thead/tr/th/strong");
	
	//Report Tab
	By ReportTabEventTitle = By.xpath(".//*[@id='pii-sri-tab-3']/div[1]/table/tbody/tr[1]/td[2]");
	By ReportTabInspectionStaff = By.xpath(".//*[@id='pii-sri-tab-3']/div[1]/table/tbody/tr[3]/td[2]");
	By ReportTabComponent = By.xpath(".//*[@id='pii-sri-tab-3']/div[1]/table/tbody/tr[4]/td[2]");
	By ReportTabMeasurement1Date = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[1]/td[2]");
	By ReportTabMeasurement1Time = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[1]/td[3]");
	By ReportTabMeasurement1Measurement = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[1]/td[4]");
	By ReportTabMeasurement1Value = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[1]/td[5]");
	By ReportTabMeasurement1Note = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[1]/td[6]");
	By ReportTabMeasurement2Date = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[2]/td[2]");
	By ReportTabMeasurement2Time = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[2]/td[3]");
	By ReportTabMeasurement2Measurement = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[2]/td[4]");
	By ReportTabMeasurement2Value = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[2]/td[5]");
	By ReportTabMeasurement2Note = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[2]/td[6]");
	//HTML
	By HTMLEventTitle = By.xpath(".//*[@id='sri-rpt']/div[1]/table/tbody/tr[1]/td[2]");
	By HTMLInspectionStaff = By.xpath(".//*[@id='sri-rpt']/div[1]/table/tbody/tr[3]/td[2]");
	By HTMLComponent = By.xpath(".//*[@id='sri-rpt']/div[1]/table/tbody/tr[4]/td[2]");
	By HTMLMeasurement1Date = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[1]/td[2]");
	By HTMLMeasurement1Time = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[1]/td[3]");
	By HTMLMeasurement1Measurement = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[1]/td[4]");
	By HTMLMeasurement1Value = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[1]/td[5]");
	By HTMLMeasurement1Note = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[1]/td[6]");
	By HTMLMeasurement2Date = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[2]/td[2]");
	By HTMLMeasurement2Time = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[2]/td[3]");
	By HTMLMeasurement2Measurement = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[2]/td[4]");
	By HTMLMeasurement2Value = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[2]/td[5]");
	By HTMLMeasurement2Note = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[2]/td[6]");
	
	
	public void shareReport(WebDriver driver, String username, String password1, int y) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		String sharer = em3.decideSharer (y);
		String sharerAdded = em3.decideSharerAdded (y);	 
		//Click on share button
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ShareButton)).click();
		//Enters username
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.ShareTextBox)).sendKeys(sharer);
		//Selects from dropdown
		WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.ShareDropdown));
		dropdown.findElement(opirca.FirstSelectionUnderDropdown).click();
		//Clicks on add user
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupButton)).click();
		//Verifies user added
		String user=wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.SharerAdded)).getText();
		softly.assertThat(user).as("test data").isEqualTo(sharerAdded);
		share.shareTwice (driver,softly);
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.ShareSaveButton)).click();
		//Verify share save sticky
		eirca2.verifyStickyShareSave(driver, softly);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		if(driver.getCurrentUrl().contains("kaleqa"))
		{
			//Click back
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.BackButton)).click();
			share2.loadingServer(driver);
			//Verify Share icon
			wait.until(ExpectedConditions.visibilityOfElementLocated(SRIShareIconOrCriticalIcon));
		}
		//Calls the Share check function
		share.receiptReport(driver, sharer, username, password1);
		//Clicks on 3 Pass Review side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(SRISidePanel)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
	}
	
	public void markCriticalReport(WebDriver driver, String username, String password1, int y) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Clicks on first newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(SRINewRecord)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);	
		//Clicks on mark critical
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.MarkCritical)).click();
		//Mark critical pop up
		eirca2.verifyMarkCriticalPopup(driver, softly);
		//Clicks on confirm change
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupButton)).click();
		//Checks if marked critical
		String critical=wait.until(ExpectedConditions.visibilityOfElementLocated(SRIMarkCriticalIndicatorText)).getText();
		softly.assertThat(critical).as("test data").contains("Critical");
		if(driver.findElement(SRIMarkCriticalIndicatorText).isDisplayed())
			System.out.println("Marked critical");
		if(driver.getCurrentUrl().contains("kaleqa"))
		{
			//Click back
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.BackButton)).click();
			share2.loadingServer(driver);
			//Verify Marked critical icon
			wait.until(ExpectedConditions.visibilityOfElementLocated(SRIShareIconOrCriticalIcon));
			//Verify presence of shared icon 
			wait.until(ExpectedConditions.visibilityOfElementLocated(SRIShareIconWhenAlsoMarkedCritical));
			//Clicks on first newly created record
			wait.until(ExpectedConditions.visibilityOfElementLocated(SRINewRecord)).click();
			share2.loadingServer(driver);
		}
		//Clicks on mark critical again
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.MarkCritical)).click();
		//Un-mark critical pop up
		eirca2.verifyUnMarkCriticalPopup(driver, softly);
		//Clicks on confirm change
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupButton)).click();
		Thread.sleep(2000);
		if(driver.findElement(SRIMarkCriticalIndicatorText).isDisplayed()==false)
		{
			System.out.println("Unmarked critical");
		}
		//Verify report not retrieved by shared to person
		String sharer = em3.decideSharer (y);		
		share.checkCriticalNotification(driver, sharer, username, password1, softly);		
		//Clicks on SRI side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(SRISidePanel)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);	    	
		//Clicks on first newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(SRINewRecord)).click();
		share2.loadingServer(driver);
	}
	
	public void verifyDeleteReportPopup(WebDriver driver, String recordName) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Delete Report");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).getText();
		String r = s1.replaceAll("\u00AD", "");
		String r1 = recordName.replaceAll("\u00AD", "");
		softly.assertThat(r).as("test data").isEqualTo("Do you confirm you want to delete SRI™ report referenced as: "+r1+"?");
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
	
	public void deleteReport(WebDriver driver, String recordName, int y) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on delete
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.DeleteButton)).click();		
		//Verify delete popup
		verifyDeleteReportPopup(driver, recordName);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle));
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupButton)).click();
		share2.loadingServer(driver);
		//Verify report not retrieved by shared to person		
		String sharer = em3.decideSharer (y);
		share.checkNoReportAfterDelete(driver, sharer, softly);	
	}
	
	public void step2AddMeasurement(WebDriver driver, String text) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		WebDriverWait wait1 = new WebDriverWait(driver,5);
		//Fill Date
		//Click on calendar icon
		wait.until(ExpectedConditions.visibilityOfElementLocated(Step2CalendarIconAddMeasurement)).click();
		//Click on - sign
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.CalendarMinusSign)).click();
		//Select 1st date of 1st row
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Calendar1stRow1stDate)).click();
		Thread.sleep(1000);
		//Wait for disappearance of date box
		try{
			wait1.until(ExpectedConditions.invisibilityOfElementLocated(eirca.Calendar1stRow1stDate));
		}catch(org.openqa.selenium.TimeoutException r)
		{

		}
		//Fill time
		//Click on clock icon
		wait.until(ExpectedConditions.visibilityOfElementLocated(Step2ClockIconAddMeasurement)).click();
		//Click on set time
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ClockSetTime)).click();
		Thread.sleep(1000);
		//Wait for disappearance of time box
		try{
			wait1.until(ExpectedConditions.invisibilityOfElementLocated(eirca.ClockSetTime));
		}catch(org.openqa.selenium.TimeoutException r)
		{

		}
		//Select Measurement
		//wait.until(ExpectedConditions.visibilityOfElementLocated(Step2MeasurementDropDown)).click();
		Select s = new Select(driver.findElement(Step2Measurment));
		//Choose a number between 1 to 14
		int index = random.nextInt(15);
		if(index<14)
			index=index+1;
		try{
			s.selectByIndex(index);
		}catch(org.openqa.selenium.ElementNotInteractableException e)
		{
			WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-sri-newentry-measurement']/option["+index+"]")));
			/*Actions act = new Actions(driver);
			act.moveToElement(ele).click().build().perform();*/
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].scrollIntoView();", ele);
			jse.executeScript("arguments[0].click();", ele);
		}
		//Clear value 
		wait.until(ExpectedConditions.visibilityOfElementLocated(Step2Value)).clear();
		//Fill value
		wait.until(ExpectedConditions.visibilityOfElementLocated(Step2Value)).sendKeys(text);
		//Fill notes
		wait.until(ExpectedConditions.visibilityOfElementLocated(Step2Notes)).sendKeys(text);
		//Click on add button
		wait.until(ExpectedConditions.visibilityOfElementLocated(Step2AddButton)).click();
	}
	
	public void step1DataFill(WebDriver driver, String text) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Event title
		wait.until(ExpectedConditions.visibilityOfElementLocated(Step1EventTitle)).sendKeys(text);
		//Inspection staff
		wait.until(ExpectedConditions.visibilityOfElementLocated(Step1InspectionStaff)).sendKeys(text);
		//Component
		Select s = new Select(driver.findElement(Step1Component));
		//Choose a number between 1 to 28
		int index = random.nextInt(29);
		if(index<28)
			index=index+1;
		s.selectByIndex(index);
		if(index==14||index==28)
		{
			//Other
			wait.until(ExpectedConditions.visibilityOfElementLocated(Step1ComponentOther)).sendKeys(text);
		}
	}
	
	public void checkForErrorStep1(WebDriver driver)throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		Thread.sleep(1000);
		//Click on next step 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(SRIStep1NextButton)).click();
		//Error on Event title
		wait.until(ExpectedConditions.visibilityOfElementLocated(Step1EventTitleErrorText));
		//Error on Inspection staff
		wait.until(ExpectedConditions.visibilityOfElementLocated(Step1InspectionStaffErrorText));
		//Error on Component
		wait.until(ExpectedConditions.visibilityOfElementLocated(Step1ComponentErrorText));
	}
	
	public HashMap<String,String> getStep1Data(WebDriver driver)throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		HashMap<String,String> storeData = new HashMap<String,String>();
		//Get event title
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(Step1EventTitle)).getAttribute("value");
		//Get Inspection staff
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(Step1InspectionStaff)).getAttribute("value");
		//Get component
		String s2 = driver.findElement(Step1Component).getAttribute("value");
		//Get other text
		if(s2.contains("Other"))
		{
			String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(Step1ComponentOther)).getAttribute("value");
			storeData.put("other", s3);
		}
		//Report creation time and date
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(Step1ReportCreation)).getAttribute("value");
		storeData.put("event title", s);
		storeData.put("inspection staff", s1);
		storeData.put("component", s2);
		storeData.put("report creation", s3);
		return storeData;
	}	
	
	public HashMap<String,String> getStep2Data(WebDriver driver)throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		WebDriverWait wait1 = new WebDriverWait(driver,3);
		HashMap<String,String> storeData = new HashMap<String,String>();
		WebElement ele;
		//Get date 1
		try{
			ele = wait1.until(ExpectedConditions.visibilityOfElementLocated(Step2Measurement1Date));
		}catch(org.openqa.selenium.TimeoutException t)
		{
			ele = wait1.until(ExpectedConditions.visibilityOfElementLocated(Step2Measurement1DateFirefox));
		}
		String s = ele.getAttribute("value");
		//Get time 1
		try{
			ele = wait1.until(ExpectedConditions.visibilityOfElementLocated(Step2Measurement1Time));
		}catch(org.openqa.selenium.TimeoutException t)
		{
			ele = wait1.until(ExpectedConditions.visibilityOfElementLocated(Step2Measurement1TimeFirefox));
		}
		String s1 = ele.getAttribute("value");
		//Get Measurement 1
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(Step2Measurement1Measurement)).getText();
		//Get value 1
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(Step2Measurement1Value)).getAttribute("value");
		//Get note 1
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(Step2Measurement1Note)).getAttribute("value");
		//Get date 2
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(Step2Measurement2Date)).getAttribute("value");
		//Get time 2
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(Step2Measurement2Time)).getAttribute("value");
		//Get Measurement 2
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(Step2Measurement2Measurement)).getText();
		//Get value 2
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(Step2Measurement2Value)).getAttribute("value");
		//Get note 2
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(Step2Measurement2Note)).getAttribute("value");
		storeData.put("date1", s);
		storeData.put("time1", s1);
		storeData.put("measurement1", s2);
		storeData.put("value1", s3);
		storeData.put("note1", s4);
		storeData.put("date2", s5);
		storeData.put("time2", s6);
		storeData.put("measurement2", s7);
		storeData.put("value2", s8);
		storeData.put("note2", s9);
		return storeData;
	}
	
	public void verifyReportTab(WebDriver driver,  HashMap<String,String> storeDataStep1,  HashMap<String,String> storeDataStep2)throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Verify data in Report tab
		//Event information
		//Event title
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(ReportTabEventTitle)).getText();
		softly.assertThat(s).as("test data").isEqualTo(storeDataStep1.get("event title"));
		//Inspection staff
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(ReportTabInspectionStaff)).getText();
		softly.assertThat(s1).as("test data").isEqualTo(storeDataStep1.get("inspection staff"));
		//Component
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(ReportTabComponent)).getText();
		if(storeDataStep1.containsKey("other"))
		{
			softly.assertThat(s2).as("test data").isEqualTo(storeDataStep1.get("other"));
		}
		else
			softly.assertThat(s2).as("test data").isEqualTo(storeDataStep1.get("component"));
		//Measurements
		//1
		//Date
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(ReportTabMeasurement1Date)).getText();
		softly.assertThat(s3).as("test data").isEqualTo(storeDataStep2.get("date1"));
		//Time
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(ReportTabMeasurement1Time)).getText();
		softly.assertThat(s4).as("test data").isEqualTo(storeDataStep2.get("time1"));
		//Measurement
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(ReportTabMeasurement1Measurement)).getText();
		softly.assertThat(s5).as("test data").isEqualTo(storeDataStep2.get("measurement1"));
		//Value
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(ReportTabMeasurement1Value)).getText();
		softly.assertThat(s6).as("test data").isEqualTo(storeDataStep2.get("value1"));
		//Notes
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(ReportTabMeasurement1Note)).getText();
		softly.assertThat(s7).as("test data").isEqualTo(storeDataStep2.get("note1"));
		//2
		//Date
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(ReportTabMeasurement2Date)).getText();
		softly.assertThat(s8).as("test data").isEqualTo(storeDataStep2.get("date2"));
		//Time
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(ReportTabMeasurement2Time)).getText();
		softly.assertThat(s9).as("test data").isEqualTo(storeDataStep2.get("time2"));
		//Measurement
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(ReportTabMeasurement2Measurement)).getText();
		softly.assertThat(s10).as("test data").isEqualTo(storeDataStep2.get("measurement2"));
		//Value
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(ReportTabMeasurement2Value)).getText();
		softly.assertThat(s11).as("test data").isEqualTo(storeDataStep2.get("value2"));
		//Notes
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(ReportTabMeasurement2Note)).getText();
		softly.assertThat(s12).as("test data").isEqualTo(storeDataStep2.get("note2"));
	}
	
	public void verifyHTML(WebDriver driver,  HashMap<String,String> storeDataStep1,  HashMap<String,String> storeDataStep2)throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Verify data in Report tab
		//Event information
		//Event title
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLEventTitle)).getText();
		softly.assertThat(s).as("test data").isEqualTo(storeDataStep1.get("event title"));
		//Inspection staff
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLInspectionStaff)).getText();
		softly.assertThat(s1).as("test data").isEqualTo(storeDataStep1.get("inspection staff"));
		//Component
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLComponent)).getText();
		if(storeDataStep1.containsKey("other"))
		{
			softly.assertThat(s2).as("test data").isEqualTo(storeDataStep1.get("other"));
		}
		else
			softly.assertThat(s2).as("test data").isEqualTo(storeDataStep1.get("component"));
		//Measurements
		//1
		//Date
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLMeasurement1Date)).getText();
		softly.assertThat(s3).as("test data").isEqualTo(storeDataStep2.get("date1"));
		//Time
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLMeasurement1Time)).getText();
		softly.assertThat(s4).as("test data").isEqualTo(storeDataStep2.get("time1"));
		//Measurement
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLMeasurement1Measurement)).getText();
		softly.assertThat(s5).as("test data").isEqualTo(storeDataStep2.get("measurement1"));
		//Value
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLMeasurement1Value)).getText();
		softly.assertThat(s6).as("test data").isEqualTo(storeDataStep2.get("value1"));
		//Notes
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLMeasurement1Note)).getText();
		softly.assertThat(s7).as("test data").isEqualTo(storeDataStep2.get("note1"));
		//2
		//Date
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLMeasurement2Date)).getText();
		softly.assertThat(s8).as("test data").isEqualTo(storeDataStep2.get("date2"));
		//Time
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLMeasurement2Time)).getText();
		softly.assertThat(s9).as("test data").isEqualTo(storeDataStep2.get("time2"));
		//Measurement
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLMeasurement2Measurement)).getText();
		softly.assertThat(s10).as("test data").isEqualTo(storeDataStep2.get("measurement2"));
		//Value
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLMeasurement2Value)).getText();
		softly.assertThat(s11).as("test data").isEqualTo(storeDataStep2.get("value2"));
		//Notes
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLMeasurement2Note)).getText();
		softly.assertThat(s12).as("test data").isEqualTo(storeDataStep2.get("note2"));
	}
	
	public String saveSRIReport(WebDriver driver)throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(SRISaveButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(SRISaveConfirmButton)).click();
		share2.loadingServer(driver);
		//Click on saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(SRISavedActivitiesButton)).click();
		share2.loadingServer(driver);
		String recordName = wait.until(ExpectedConditions.visibilityOfElementLocated(SRINewRecord)).getText();
		//CLick on new record
		wait.until(ExpectedConditions.visibilityOfElementLocated(SRINewRecord)).click();
		share2.loadingServer(driver);
		return recordName;
	}
	
	public int getCharCountFromTitle(WebDriver driver) throws Exception {
		
		//Get count of characters
		String s = driver.findElement(Step1TitleCharacterCount).getText();
		s=s.substring(1,s.indexOf("/"));
		int count = Integer.parseInt(s);
		System.out.println(s+ " "+count);
		return count;
	}
	
	public void checkTitleCountReset(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Enter
		wait.until(ExpectedConditions.visibilityOfElementLocated(Step1EventTitle)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(Step1EventTitle)).sendKeys("aaaa");
		//Get count
		int count = getCharCountFromTitle(driver);
		if(count!=4)
			softly.fail("Count did not match: aaaa: " + count);
		//Clear text
		for(int i=0;i<4;i++)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(Step1EventTitle)).sendKeys(Keys.BACK_SPACE);
			Thread.sleep(250);
		}
		count = getCharCountFromTitle(driver);
		if(count!=1)
			softly.fail("Count did not match: aaaa: " + count);
	}
	
	public String path_SRI(WebDriver driver)throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Clicks on Analysis 
		wait.until(ExpectedConditions.visibilityOfElementLocated(hlb.AnalysisLink)).click();
		//Click on SRI
		wait.until(ExpectedConditions.visibilityOfElementLocated(SRILink)).click();
		//Step 1 check for errors
		checkForErrorStep1(driver);
		//Check title count reset when characters are entered and deleted
		checkTitleCountReset(driver);
		//Fill Step 1
		step1DataFill(driver,text);
		//Get Data from Step 1
		HashMap<String,String> storeDataStep1 = getStep1Data(driver);
		//Click on next step 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(SRIStep1NextButton)).click();
		//Step 2 - add 2 measurements
		//1
		step2AddMeasurement(driver,text);
		//2
		step2AddMeasurement(driver,text);
		//get data from step 2
		HashMap<String,String> storeDataStep2 = getStep2Data(driver);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(SRINextButton)).click();
		//Verify everything on report
		verifyReportTab(driver,storeDataStep1,storeDataStep2);
		//Save report and open the report
		String recordName = saveSRIReport(driver);
		//Verify data on HTML
		verifyHTML(driver,storeDataStep1,storeDataStep2);
		return recordName;
	}

	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}
}
