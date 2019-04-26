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
	public String text = "SRI sanity test";

	HiRCALOPBug hlb = new HiRCALOPBug();
	EiRCAPageObj eirca = new EiRCAPageObj();
	EiRCA2 eirca2 = new EiRCA2();
	EiRCA3 eirca3 = new EiRCA3();
	ShareCheck share = new ShareCheck();
	ErrorMeter3 em3 = new ErrorMeter3 ();
	OPiRCAPageObj opirca = new OPiRCAPageObj();
	ShareCheck2 share2 = new ShareCheck2();
	SRIPageObj sri = new SRIPageObj();



	public void shareReport(WebDriver driver, String username, String password1, int y) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		String sharer = em3.decideSharer (y);
		String sharerAdded = em3.decideSharerAdded (y);	 
		//Click on share button
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ShareButton)).click();
		//Enters username
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.ShareTextBox)).sendKeys(sharer);
		Thread.sleep(500);
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
			wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIShareIconOrCriticalIcon));
		}
		//Calls the Share check function
		share.receiptReport(driver, sharer, username, password1);
		//Clicks on 3 Pass Review side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRISidePanel)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
	}

	public void markCriticalReport(WebDriver driver, String username, String password1, int y) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Clicks on first newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRINewRecord)).click();
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
		String critical=wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIMarkCriticalIndicatorText)).getText();
		softly.assertThat(critical).as("test data").contains("Critical");
		if(driver.findElement(sri.SRIMarkCriticalIndicatorText).isDisplayed())
			System.out.println("Marked critical");
		if(driver.getCurrentUrl().contains("kaleqa"))
		{
			//Click back
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.BackButton)).click();
			share2.loadingServer(driver);
			//Verify Marked critical icon
			wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIShareIconOrCriticalIcon));
			//Verify presence of shared icon 
			wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIShareIconWhenAlsoMarkedCritical));
			//Clicks on first newly created record
			wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRINewRecord)).click();
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
		if(driver.findElement(sri.SRIMarkCriticalIndicatorText).isDisplayed()==false)
		{
			System.out.println("Unmarked critical");
		}
		//Verify report not retrieved by shared to person
		String sharer = em3.decideSharer (y);		
		share.checkCriticalNotification(driver, sharer, username, password1, softly);		
		//Clicks on SRI side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRISidePanel)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);	    	
		//Clicks on first newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRINewRecord)).click();
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

	public void changeTimeOfMeasurementsAndVerifyOrderOfMeasurements(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		WebDriverWait wait1 = new WebDriverWait(driver,5);
		//Change date of 2nd event to match 1st event
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement2CalendarIcon)).click();
		//Click on - sign five times
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
		//get data from step 2
		HashMap<String,String> storeDataStep2 = getStep2Data(driver);
		//Verify order of measurements
		verifyOrderOfMeasurements(driver,storeDataStep2.get("date1"),storeDataStep2.get("date2"),storeDataStep2.get("time1"),storeDataStep2.get("time2"));	
		//Change time of 1st measurement
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement1ClockIcon)).click();
		//Set hour to 5
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ClockTimeHourField)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ClockTimeHourField)).clear();
		while(true)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ClockTimeHourField)).sendKeys(Keys.CONTROL,"a");
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ClockTimeHourField)).sendKeys(Keys.DELETE);
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ClockTimeHourField)).sendKeys("05");
			Thread.sleep(500);
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ClockTimeHourField)).getAttribute("value");
			System.out.println(s);
			if(s.equals("05"))
				break;
		}
		//Click on set time
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ClockSetTime)).click();
		Thread.sleep(1000);
		//Wait for disappearance of time box
		try{
			wait1.until(ExpectedConditions.invisibilityOfElementLocated(eirca.ClockSetTime));
		}catch(org.openqa.selenium.TimeoutException r)
		{

		}
		//get data from step 2
		HashMap<String,String> storeDataStep2a = getStep2Data(driver);
		System.out.println(storeDataStep2a);
		//Verify order of measurements
		verifyOrderOfMeasurements(driver,storeDataStep2a.get("date1"),storeDataStep2a.get("date2"),storeDataStep2a.get("time1"),storeDataStep2a.get("time2"));	
		//Verify the current 1st meaurement time is equal to old 2nd measurement time
		softly.assertThat(storeDataStep2.get("time2")).as("test data").isEqualTo(storeDataStep2a.get("time1"));
		//Verify the hour changed in current measurement 2 
		softly.assertThat(storeDataStep2a.get("time2").substring(0, 2)).as("test data").isEqualTo("05");
	}

	public void changeDate1stMeasurementAndVerifyOrderOfMeasurements(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		WebDriverWait wait1 = new WebDriverWait(driver,5);
		//Get date of present 1st measurement
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement2Date)).getAttribute("value");
		//Change date of 1st measurement to 2 months ahead of present 2nd event
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement1CalendarIcon)).click();
		//Click on + sign five times
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.CalendarPlusSign)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.CalendarPlusSign)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.CalendarPlusSign)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.CalendarPlusSign)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.CalendarPlusSign)).click();
		//Select 1st date of 1st row
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Calendar1stRow1stDate)).click();
		Thread.sleep(1000);
		//Wait for disappearance of date box
		try{
			wait1.until(ExpectedConditions.invisibilityOfElementLocated(eirca.Calendar1stRow1stDate));
		}catch(org.openqa.selenium.TimeoutException r)
		{

		}
		//Verify the current 1st measurement has the date of previous 2nd event
		WebElement ele;
		//Get date 1
		try{
			ele = wait1.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement1Date));
		}catch(org.openqa.selenium.TimeoutException t)
		{
			ele = wait1.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement1DateFirefox));
		}
		String date1 = ele.getAttribute("value");
		softly.assertThat(date1).as("test data").isEqualTo(s);
		//get data from step 2
		HashMap<String,String> storeDataStep2 = getStep2Data(driver);
		//Verify order of measurements
		verifyOrderOfMeasurements(driver,storeDataStep2.get("date1"),storeDataStep2.get("date2"),storeDataStep2.get("time1"),storeDataStep2.get("time2"));		
	}

	public void verifyOrderOfMeasurements(WebDriver driver, String date1, String date2, String time1, String time2) throws Exception {

		//Compare date and time
		String year1 = date1.substring(0, 4);
		String year2 = date2.substring(0, 4);
		String month1 = date1.substring(5, 7);
		String month2 = date2.substring(5, 7);
		String day1 = date1.substring(8, 10);
		String day2 = date2.substring(8, 10);	
		String hour1 = time1.substring(0, 2);
		String hour2 = time2.substring(0, 2);
		String minute1 = time1.substring(3, 5);
		String minute2 = time2.substring(3, 5);
		//Verify order of 1st and 2nd measurement
		eirca3.compareDateTime(year1,year2,month1,month2,day1,day2,hour1,hour2,minute1,minute2,softly);
	}

	public void step2AddMeasurement(WebDriver driver, String text) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		WebDriverWait wait1 = new WebDriverWait(driver,5);
		//Fill Date
		//Click on calendar icon
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2CalendarIconAddMeasurement)).click();
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2ClockIconAddMeasurement)).click();
		//Set hour to 2
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ClockTimeHourField)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ClockTimeHourField)).clear();
		Thread.sleep(500);
		while(true)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ClockTimeHourField)).sendKeys(Keys.CONTROL,"a");
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ClockTimeHourField)).sendKeys(Keys.DELETE);
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ClockTimeHourField)).sendKeys("02");
			Thread.sleep(500);
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ClockTimeHourField)).getAttribute("value");
			System.out.println(s);
			if(s.equals("02"))
				break;
		}
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
		//wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2MeasurementDropDown)).click();
		Select s = new Select(driver.findElement(sri.Step2Measurment));
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Value)).clear();
		//Fill value
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Value)).sendKeys(text);
		//Fill notes
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Notes)).sendKeys(text);
		//Click on add button
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2AddButton)).click();
	}

	public void step1DataFill(WebDriver driver, String text) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Event title
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step1EventTitle)).sendKeys(text);
		//Inspection staff
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step1InspectionStaff)).sendKeys(text);
		//Component
		Select s = new Select(driver.findElement(sri.Step1Component));
		//Choose a number between 1 to 28
		int index = random.nextInt(29);
		if(index<28)
			index=index+1;
		s.selectByIndex(index);
		if(index==14||index==28)
		{
			//Other
			wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step1ComponentOther)).sendKeys(text);
		}
	}

	public void checkForErrorStep1(WebDriver driver)throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		Thread.sleep(1000);
		//Click on next step 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIStep1NextButton)).click();
		//Error on Event title
		String titleError = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step1EventTitleErrorText)).getText();
		softly.assertThat(titleError).as("test data").isEqualTo("Report title is required");
		//Error on Inspection staff
		String inspectionStaffError = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step1InspectionStaffErrorText)).getText();
		softly.assertThat(inspectionStaffError).as("test data").isEqualTo("Inspection staff is required");
		//Error on Component
		String componentError = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step1ComponentErrorText)).getText();
		softly.assertThat(componentError).as("test data").isEqualTo("Component is required");
		//softly.assertAll();
	}

	public HashMap<String,String> getStep1Data(WebDriver driver)throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		HashMap<String,String> storeData = new HashMap<String,String>();
		//Get event title
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step1EventTitle)).getAttribute("value");
		//Get Inspection staff
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step1InspectionStaff)).getAttribute("value");
		//Get component
		String s2 = driver.findElement(sri.Step1Component).getAttribute("value");
		//Get other text
		if(s2.contains("Other"))
		{
			String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step1ComponentOther)).getAttribute("value");
			storeData.put("other", s3);
		}
		//Report creation time and date
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step1ReportCreation)).getAttribute("value");
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
			ele = wait1.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement1Date));
		}catch(org.openqa.selenium.TimeoutException t)
		{
			ele = wait1.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement1DateFirefox));
		}
		String s = ele.getAttribute("value");
		//Get time 1
		try{
			ele = wait1.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement1Time));
		}catch(org.openqa.selenium.TimeoutException t)
		{
			ele = wait1.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement1TimeFirefox));
		}
		String s1 = ele.getAttribute("value");
		//Get Measurement 1
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement1Measurement)).getText();
		//Get value 1
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement1Value)).getAttribute("value");
		//Get note 1
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement1Note)).getAttribute("value");
		//Get date 2
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement2Date)).getAttribute("value");
		//Get time 2
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement2Time)).getAttribute("value");
		//Get Measurement 2
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement2Measurement)).getText();
		//Get value 2
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement2Value)).getAttribute("value");
		//Get note 2
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement2Note)).getAttribute("value");
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
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabEventTitle)).getText();
		softly.assertThat(s).as("test data").isEqualTo(storeDataStep1.get("event title"));
		//Inspection staff
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabInspectionStaff)).getText();
		softly.assertThat(s1).as("test data").isEqualTo(storeDataStep1.get("inspection staff"));
		//Component
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabComponent)).getText();
		if(storeDataStep1.containsKey("other"))
		{
			softly.assertThat(s2).as("test data").isEqualTo(storeDataStep1.get("other"));
		}
		else
			softly.assertThat(s2).as("test data").isEqualTo(storeDataStep1.get("component"));
		//Measurements
		//1
		//Date
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement1Date)).getText();
		softly.assertThat(s3).as("test data").isEqualTo(storeDataStep2.get("date1"));
		//Time
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement1Time)).getText();
		softly.assertThat(s4).as("test data").isEqualTo(storeDataStep2.get("time1"));
		//Measurement
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement1Measurement)).getText();
		softly.assertThat(s5).as("test data").isEqualTo(storeDataStep2.get("measurement1"));
		//Value
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement1Value)).getText();
		softly.assertThat(s6).as("test data").isEqualTo(storeDataStep2.get("value1"));
		//Notes
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement1Note)).getText();
		softly.assertThat(s7).as("test data").isEqualTo(storeDataStep2.get("note1"));
		//2
		//Date
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement2Date)).getText();
		softly.assertThat(s8).as("test data").isEqualTo(storeDataStep2.get("date2"));
		//Time
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement2Time)).getText();
		softly.assertThat(s9).as("test data").isEqualTo(storeDataStep2.get("time2"));
		//Measurement
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement2Measurement)).getText();
		softly.assertThat(s10).as("test data").isEqualTo(storeDataStep2.get("measurement2"));
		//Value
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement2Value)).getText();
		softly.assertThat(s11).as("test data").isEqualTo(storeDataStep2.get("value2"));
		//Notes
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement2Note)).getText();
		softly.assertThat(s12).as("test data").isEqualTo(storeDataStep2.get("note2"));
	}

	public void verifyHTML(WebDriver driver,  HashMap<String,String> storeDataStep1,  HashMap<String,String> storeDataStep2)throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Verify data in Report tab
		//Event information
		//Event title
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLEventTitle)).getText();
		softly.assertThat(s).as("test data").isEqualTo(storeDataStep1.get("event title"));
		//Inspection staff
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLInspectionStaff)).getText();
		softly.assertThat(s1).as("test data").isEqualTo(storeDataStep1.get("inspection staff"));
		//Component
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLComponent)).getText();
		if(storeDataStep1.containsKey("other"))
		{
			softly.assertThat(s2).as("test data").isEqualTo(storeDataStep1.get("other"));
		}
		else
			softly.assertThat(s2).as("test data").isEqualTo(storeDataStep1.get("component"));
		//Measurements
		//1
		//Date
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement1Date)).getText();
		softly.assertThat(s3).as("test data").isEqualTo(storeDataStep2.get("date1"));
		//Time
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement1Time)).getText();
		softly.assertThat(s4).as("test data").isEqualTo(storeDataStep2.get("time1"));
		//Measurement
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement1Measurement)).getText();
		softly.assertThat(s5).as("test data").isEqualTo(storeDataStep2.get("measurement1"));
		//Value
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement1Value)).getText();
		softly.assertThat(s6).as("test data").isEqualTo(storeDataStep2.get("value1"));
		//Notes
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement1Note)).getText();
		softly.assertThat(s7).as("test data").isEqualTo(storeDataStep2.get("note1"));
		//2
		//Date
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement2Date)).getText();
		softly.assertThat(s8).as("test data").isEqualTo(storeDataStep2.get("date2"));
		//Time
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement2Time)).getText();
		softly.assertThat(s9).as("test data").isEqualTo(storeDataStep2.get("time2"));
		//Measurement
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement2Measurement)).getText();
		softly.assertThat(s10).as("test data").isEqualTo(storeDataStep2.get("measurement2"));
		//Value
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement2Value)).getText();
		softly.assertThat(s11).as("test data").isEqualTo(storeDataStep2.get("value2"));
		//Notes
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement2Note)).getText();
		softly.assertThat(s12).as("test data").isEqualTo(storeDataStep2.get("note2"));
	}

	public void savePartialReport(WebDriver driver)	throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRISaveButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRISaveConfirmButton)).click();
		share2.loadingServer(driver);
	}

	public String saveSRIReport(WebDriver driver)throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Save report
		savePartialReport(driver);
		//Click on saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRISavedActivitiesButton)).click();
		share2.loadingServer(driver);
		String recordName = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRINewRecord)).getText();
		//CLick on new record
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRINewRecord)).click();
		share2.loadingServer(driver);
		return recordName;
	}

	public int getCharCountFromTitle(WebDriver driver) throws Exception {

		//Get count of characters
		String s = driver.findElement(sri.Step1TitleCharacterCount).getText();
		s=s.substring(1,s.indexOf("/"));
		int count = Integer.parseInt(s);
		System.out.println(s+ " "+count);
		return count;
	}

	public void checkTitleCountReset(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Enter
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step1EventTitle)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step1EventTitle)).sendKeys("aaaa");
		//Get count
		int count = getCharCountFromTitle(driver);
		if(count!=4)
			softly.fail("Count did not match: aaaa: " + count);
		//Clear text
		for(int i=0;i<4;i++)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step1EventTitle)).sendKeys(Keys.BACK_SPACE);
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRILink)).click();
		//Step 1 check for errors
		checkForErrorStep1(driver);
		//Check title count reset when characters are entered and deleted
		checkTitleCountReset(driver);
		//Fill Step 1
		step1DataFill(driver,text);
		//Get Data from Step 1
		HashMap<String,String> storeDataStep1 = getStep1Data(driver);
		//Click on next step 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIStep1NextButton)).click();
		//Step 2 - add 2 measurements
		//1
		step2AddMeasurement(driver,text);
		//2
		step2AddMeasurement(driver,text);
		//Change date of 1st measurement twice
		changeDate1stMeasurementAndVerifyOrderOfMeasurements(driver);
		changeDate1stMeasurementAndVerifyOrderOfMeasurements(driver);
		//Change time of 1st measurement twice and make date equal with 2nd measurement
		changeTimeOfMeasurementsAndVerifyOrderOfMeasurements(driver);
		//get data from step 2
		HashMap<String,String> storeDataStep2 = getStep2Data(driver);
		//Verify order of measurements
		verifyOrderOfMeasurements(driver,storeDataStep2.get("date1"),storeDataStep2.get("date2"),storeDataStep2.get("time1"),storeDataStep2.get("time2"));
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRINextButton)).click();
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
