import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.Iterables;


public class EiRCA {
	
	SoftAssertions softly = new SoftAssertions();
	
	
	//Buttons on HML report page
	By DeleteButton = By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[3]");
	By OpenButton = By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a");
	By DownloadButton = By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]");
	By ShareButton = By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[4]");
	
	//Share page
	By ShareTextBox = By.id("pii-uhshare-search-input");
	By ShareDropdown = By.xpath(".//*[@id='pii-uhshare-blocks']/div[2]/ul");
	By FirstSelectionUnderDropdown = By.cssSelector(".ui-first-child");
	By SharerAdded = By.xpath(".//*[@id='pii-uhshare-blocks']/div/form/div/ul/li/a");
	By ShareSaveButton = By.id("pii-uhshare-save");
	
	By EiRCASidePanel = By.id("pii-user-home-panel-btn-mirca");
	By MarkCritical = By.xpath(".//*[@id='pii-user-home-activities-single']/div[2]/div/label");
	By EiRCAMarkCriticalIndicatorText = By.xpath(".//*[@id='mirca-rpt']/div/table/thead/tr/th/strong");
	
	//Info page
	By InfoTab = By.id("pii-ircam-tab-1-a");
	By NextButtonBottomOfInfoPage = By.id("pii-ircam-tab-1-form-submit");
	By ReportCreationDateField = By.id("pii-ircam-tab-1-repdatetime");
	By EiRCASaveButton = By.id("pii-ircam-save");
	
	//Save pop up
	By EiRCAPopupTitle = By.id("pii-ircam-dialog-title");
	By EiRCAConfirmButton = By.id("pii-ircam-dialog-confirmed");
	
	By EiRCASavedActivitiesButton = By.id("pii-ircam-savedactivities");
	
	//Report pop up on HTML page
	By ConfirmPopupTitle = By.id("pii-user-home-dialog-title");
	By ConfirmPopupButton = By.id("pii-user-home-dialog-confirmed");
	
	By EiRCAFirstRecord = By.xpath(".//*[@id='pii-user-home-activities-mirca']/ul/li[2]/a");
	By StickyNote = By.className("sticky-note");
	By StickySuccess = By.className("sticky-success");
	By StickyClose = By.className("sticky-close");;
	
	//Sequence of Events in HTML
	By SequenceOfEventPageTitle = By.xpath(".//*[@id='mirca-rpt']/div[5]/div");
	By SequenceOfEventPageDateTimeTitle = By.xpath(".//*[@id='mirca-rpt']/div[5]/table/tbody/tr/td[1]");
	By SequenceOfEventPageWhatHappenedTitle = By.xpath(".//*[@id='mirca-rpt']/div[5]/table/tbody/tr/td[2]");
	By SequenceOfEventPageWhatShouldHappenTitle = By.xpath(".//*[@id='mirca-rpt']/div[5]/table/tbody/tr/td[3]");
	
	//Sequence of Events page
	By DescriptionPlusSign = By.xpath(".//*[@id='pii-ircam-tab-1-description']/h4/a");
	By DescriptionText = By.id("pii-ircam-tab-1-description-text");
	By DateHeader = By.xpath(".//*[@id='pii-ircam-tab-1-events']/div/div[1]/div[1]");
	By TimeHeader = By.xpath(".//*[@id='pii-ircam-tab-1-events']/div/div[2]/div[1]");
	By WhatHappenedHeader = By.xpath(".//*[@id='pii-ircam-tab-1-events']/div/div[3]/div[1]");
	By WhatIsSupposedToHappenHeader = By.xpath(".//*[@id='pii-ircam-tab-1-events']/div/div[4]/div[1]");
	By WhatHappenedField = By.id("pii-ircam-newevent-descr");
	By WhatIsSupposedToHappenField = By.id("pii-ircam-newevent-trigevt");
	By EventAddSign = By.id("pii-ircam-newevent-add");
	By Date1stEvent = By.xpath(".//*[@id='pii-ircam-events-table']/tbody/tr[1]/td[2]/div/div/input");
	By Time1stEvent = By.xpath(".//*[@id='pii-ircam-events-table']/tbody/tr[1]/td[3]/div/div/input");
	By WhatHappened1stEvent = By.xpath(".//*[@id='pii-ircam-events-table']/tbody/tr[1]/td[4]/textarea");
	By WhatIsSupposedToHappen1stEvent = By.xpath(".//*[@id='pii-ircam-events-table']/tbody/tr[1]/td[5]/textarea");
	By Date2ndEvent = By.xpath(".//*[@id='pii-ircam-events-table']/tbody/tr[2]/td[2]/div/div/input");
	By Time2ndEvent = By.xpath(".//*[@id='pii-ircam-events-table']/tbody/tr[2]/td[3]/div/div/input");
	By WhatHappened2ndEvent = By.xpath(".//*[@id='pii-ircam-events-table']/tbody/tr[2]/td[4]/textarea");
	By WhatIsSupposedToHappen2ndEvent = By.xpath(".//*[@id='pii-ircam-events-table']/tbody/tr[2]/td[5]/textarea");
	By DeleteSign2ndEvent = By.xpath(".//*[@id='pii-ircam-events-table']/tbody/tr[2]/td[6]/a");
	By CalendarIcon2ndEvent = By.xpath(".//*[@id='pii-ircam-events-table']/tbody/tr[2]/td[2]/div/div/a");
	By ClockIcon2ndEvent = By.xpath(".//*[@id='pii-ircam-events-table']/tbody/tr[2]/td[3]/div/div/a");
	By CalendarIconAddEvent = By.xpath(".//*[@id='pii-ircam-tab-1-events']/div/div[1]/div[2]/div/div/a");
	By CalendarMinusSign = By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div/div/a");
	By Calendar1stRow1stDate = By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div[2]/div[2]/div");
	By ClockIconAddEvent = By.xpath(".//*[@id='pii-ircam-tab-1-events']/div/div[2]/div[2]/div/div/a");
	By ClockSetTime = By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div[2]/div/a");
	By ClockHourMinusSign = By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div/div/div[3]");
	//Table headers
	By TableDateHeader = By.xpath(".//*[@id='pii-ircam-events-table']/thead/tr[1]/th[2]");
	By TableTimeHeader = By.xpath(".//*[@id='pii-ircam-events-table']/thead/tr[1]/th[3]");
	By TableWhatHappenedHeader = By.xpath(".//*[@id='pii-ircam-events-table']/thead/tr[1]/th[4]");
	By TableWhatIsSupposedToHappenHeader = By.xpath(".//*[@id='pii-ircam-events-table']/thead/tr[1]/th[5]");
	
	By EiRCANextButton = By.id("pii-ircam-next");

	public void deleteNewRecord(WebDriver driver,String recordName, int y) throws Exception{
		  
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  //Clicks on delete button
		  driver.findElement(DeleteButton).click();
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupTitle));
		  //Clicks on delete report
		  jse.executeScript("return document.getElementById('pii-user-home-dialog-confirmed').click();");
		  wait.until(ExpectedConditions.visibilityOfElementLocated(StickyNote));
		  Thread.sleep(2000);
		  jse.executeScript("return document.getElementById('pii-user-home-panel-btn-mirca').click();");
		  //Verify record deleted
		  //Click on 1st record
		  String name = driver.findElement(EiRCAFirstRecord).getText();
		  System.out.println(name);
		  if (name!=recordName)
			  System.out.println("Record deleted");
		  else
			  System.out.println("Record could not be deleted");
		  //Verify report not retrieved by shared to person
	      ErrorMeter obj = new ErrorMeter();
		  String sharer = obj.decideSharer (y);
		  ShareCheck obj1 = new ShareCheck();
		  obj1.checkNoReportAfterDelete(driver, sharer, softly);		  			  
	  }
	
	  public void verifyHTML(WebDriver driver,HashMap<String,String>hm)throws Exception {
    	
		  WebDriverWait wait = new WebDriverWait(driver,30);
		  //Clicks on first newly created record
	      wait.until(ExpectedConditions.visibilityOfElementLocated(EiRCAFirstRecord)).click();
	      ShareCheck obj1 = new ShareCheck();
	      obj1.loadingServer(driver);
	      //Verify Sequence of Events title
	      String s = wait.until(ExpectedConditions.visibilityOfElementLocated(SequenceOfEventPageTitle)).getText();
	      softly.assertThat(s).as("test data").isEqualTo("Sequence of Events");
	      String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(SequenceOfEventPageDateTimeTitle)).getText();
	      softly.assertThat(s1).as("test data").isEqualTo(hm.get("date")+", "+hm.get("time"));
	      String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(SequenceOfEventPageWhatHappenedTitle)).getText();
	      softly.assertThat(s2).as("test data").isEqualTo(hm.get("what happened"));
	      String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(SequenceOfEventPageWhatShouldHappenTitle)).getText();
	      softly.assertThat(s3).as("test data").isEqualTo(hm.get("what is supposed to happen"));	      
	  }
	  
		public void pdfCheck(HashMap<String,String>hm) throws Exception{
	    	
			// specify your directory
	    	Path dir = Paths.get("C://Users//IEUser//Downloads//reports//");  
	    	// here we get the stream with full directory listing
	    	// exclude subdirectories from listing
	    	// finally get the last file using simple comparator by lastModified field
	    	Optional<Path> lastFilePath = Files.list(dir).filter(f -> !Files.isDirectory(f)).max(Comparator.comparingLong(f -> f.toFile().lastModified()));  
	    	System.out.println(lastFilePath.get());
	    	//Loads the file to check if correct data is present
		    String fileName=lastFilePath.get().toString();
		    File oldfile = new File(fileName);
		    PDDocument pddoc= PDDocument.load(oldfile);
		    //Checks text in pdf
		    String data = new PDFTextStripper().getText(pddoc);
		    List<String> ans= Arrays.asList(data.split("\r\n"));
		    System.out.println(ans);
		    String newData1="";
		    for (int i = 0; i < ans.size(); i++)
		        {	        	
		        	int n=ans.get(i).length()-1;
		        	if (ans.get(i).charAt(n)==' ')
		        		newData1 = newData1+ans.get(i);
		        	if (ans.get(i).charAt(n)!=' ')
		        		newData1 = newData1+" "+ans.get(i);	        	
		        }
		    //Verify Sequence of Events in pdf
		    softly.assertThat(newData1).as("test data").contains("Sequence of Events");
		    softly.assertThat(newData1).as("test data").contains(hm.get("date")+", "+hm.get("time"));
		    softly.assertThat(newData1).as("test data").contains(hm.get("what happened"));
		    softly.assertThat(newData1).as("test data").contains(hm.get("what is supposed to happen"));
		    //Close pdf
		    pddoc.close();
		}

	   public void openReport(WebDriver driver) throws Exception{

		  WebDriverWait wait1 = new WebDriverWait(driver,30);
		  //Clicks on Open button
	      wait1.until(ExpectedConditions.visibilityOfElementLocated(OpenButton)).click();
	      wait1.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupTitle)).click();
	      //Clicks on open report
	      wait1.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupButton)).click();
	      //Clicks on Save
	      wait1.until(ExpectedConditions.visibilityOfElementLocated(EiRCASaveButton)).click();
		  //Clicks on Save report
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(EiRCAPopupTitle)).click();
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(EiRCAConfirmButton)).click();
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(StickySuccess));
		  Thread.sleep(1000);
	      //Clicks on Saved activities
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(EiRCASavedActivitiesButton)).click();
		  Thread.sleep(2000);
	    }
	   
	   public void downloadRecordChrome(WebDriver driver, HashMap <String,String> hm) throws Exception {
	    	
		    //deletes files in reports folder before starting to download
	    	File file = new File("C://Users//IEUser//Downloads//reports//");
	    	HiRCAEvent obj1 = new HiRCAEvent();
	    	obj1.deleteFiles(file);
		    WebDriverWait wait1 = new WebDriverWait(driver,60);
	    	//Clicks on first newly created record
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(EiRCAFirstRecord)).click();
			String window = driver.getWindowHandle();
			//Clicks on download button
			wait1.until(ExpectedConditions.visibilityOfElementLocated(DownloadButton)).click();
			//Wait for loading message to disappear
			ShareCheck obj = new ShareCheck();
			obj.loadingServer(driver);
			//Clicks on open pdf report
			wait1.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupTitle)).click();
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupButton)).click();
	    	Thread.sleep(8000);
	    	pdfCheck(hm);
	    	for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		    }
	        driver.close();
	    	driver.switchTo().window(window);
	    	Thread.sleep(1000);	    		    	
	    }
	   
	   public void downloadRecordFirefox(WebDriver driver, HashMap <String,String> hm) throws Exception {
	    	
		    //deletes files in reports folder before starting to download
	    	File file = new File("C://Users//IEUser//Downloads//reports//");
	    	HiRCAEvent obj1 = new HiRCAEvent();
	    	obj1.deleteFiles(file);
		    WebDriverWait wait1 = new WebDriverWait(driver,60);
	    	//Clicks on first newly created record
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(EiRCAFirstRecord)).click();
			//Clicks on download button
			wait1.until(ExpectedConditions.visibilityOfElementLocated(DownloadButton)).click();
			//Wait for loading message to disappear
			ShareCheck obj = new ShareCheck();
			obj.loadingServer(driver);
			String window = driver.getWindowHandle();
			//Clicks on open pdf report
			wait1.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupTitle)).click();
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupButton)).click();
	    	Thread.sleep(8000);
	    	for(String winHandle : driver.getWindowHandles()){
	    	    driver.switchTo().window(winHandle);
	    	}
	    	Thread.sleep(2000);
	    	Robot robot = new Robot();
	    	// press Ctrl+S the Robot's way
	    	robot.keyPress(KeyEvent.VK_CONTROL);
	    	robot.keyPress(KeyEvent.VK_S);
	    	robot.keyRelease(KeyEvent.VK_CONTROL);
	    	robot.keyRelease(KeyEvent.VK_S);
	    	Process p= Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/PDFReportFirefox.exe");
	    	p.waitFor();
	    	pdfCheck(hm);
	    	Thread.sleep(4000);
	    	driver.close();
	    	Thread.sleep(4000);
	    	driver.switchTo().window(window);
	    	driver.switchTo().defaultContent();	    		    	
	    }
	   
	    public void downloadRecordIE10(WebDriver driver, HashMap <String,String> hm) throws Exception {
	    	
		    //deletes files in reports folder before starting to download
	    	File file = new File("C://Users//IEUser//Downloads//reports//");
	    	HiRCAEvent obj1 = new HiRCAEvent();
	    	obj1.deleteFiles(file);
	    	WebDriverWait wait1 = new WebDriverWait(driver,60);
	    	//Clicks on first newly created record
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(EiRCAFirstRecord)).click();
			//Clicks on download button
			wait1.until(ExpectedConditions.visibilityOfElementLocated(DownloadButton)).click();
			//Wait for loading message to disappear
			ShareCheck obj = new ShareCheck();
			obj.loadingServer(driver);
			String window = driver.getWindowHandle();
			//Clicks on open pdf report
			wait1.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupTitle)).click();
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupButton)).click();
	    	Thread.sleep(3000);
	    	try {
				  Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/SavePdf.exe");
				  q.waitFor();
				  }catch (UnhandledAlertException f){	
					  System.out.println("Unexpected alert");
					  driver.switchTo().alert().accept();
					  
			  	  }catch (NoAlertPresentException f){
			  		  System.out.println ("No unexpected alert");
			  		  }
	    	Thread.sleep(7000);
	    	//pdf verification
		    pdfCheck(hm);
		    Thread.sleep(4000);
	    	//Switch to window    	
	    	driver.switchTo().window(window);	    		    	
	    }
	    
	    public void downloadRecordIE11(WebDriver driver, HashMap <String,String> hm) throws Exception {
	    	
		    //deletes files in reports folder before starting to download
	    	File file = new File("C://Users//IEUser//Downloads//reports//");
	    	HiRCAEvent obj1 = new HiRCAEvent();
	    	obj1.deleteFiles(file);
	    	WebDriverWait wait1 = new WebDriverWait(driver,60);
	    	//Clicks on first newly created record
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(EiRCAFirstRecord)).click();
			//Clicks on download button
			wait1.until(ExpectedConditions.visibilityOfElementLocated(DownloadButton)).click();
			//Wait for loading message to disappear
			ShareCheck obj = new ShareCheck();
			obj.loadingServer(driver);
			String window = driver.getWindowHandle();
			//Clicks on open pdf report
			wait1.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupTitle)).click();
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupButton)).click();
	    	Thread.sleep(3000);
	    	try {
				  Process q = Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/SavePdf.exe");
				  q.waitFor();
				  }catch (UnhandledAlertException f){	
					  System.out.println("Unexpected alert");
					  driver.switchTo().alert().accept();
					  
			  	  }catch (NoAlertPresentException f){
			  		  System.out.println ("No unexpected alert");
			  		  }
	    	Thread.sleep(7000);
	    	//pdf verification
		    pdfCheck(hm);
		    Thread.sleep(4000);
	    	//Switch to window    	
	    	driver.switchTo().window(window);	
	    }
	    
	    public void shareReport(WebDriver driver,String username, String password1,int y ) throws Exception{
	    	
	    	WebDriverWait wait1 = new WebDriverWait(driver,30);
	    	ErrorMeter obj = new ErrorMeter();
		    String sharer = obj.decideSharer (y);
	    	String sharerAdded = obj.decideSharerAdded (y);	
	    	//Waits for the page to load
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			//Switches to the iframe
			wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
	    	//Clicks on share button
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(ShareButton)).click();
			//Enters username
			wait1.until(ExpectedConditions.visibilityOfElementLocated(ShareTextBox)).sendKeys(sharer);
			Thread.sleep(2000);
	    	//Selects from dropdown
			WebElement dropdown = wait1.until(ExpectedConditions.visibilityOfElementLocated(ShareDropdown));
			dropdown.findElement(FirstSelectionUnderDropdown).click();
			//Clicks on add user
			wait1.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupTitle)).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupButton)).click();
			//Verifies user added
			String user=wait1.until(ExpectedConditions.visibilityOfElementLocated(SharerAdded)).getText();
			softly.assertThat(user).as("test data").isEqualTo(sharerAdded);
			ShareCheck obj1 = new ShareCheck();
			obj1.shareTwice (driver);
			//Clicks on save
			wait1.until(ExpectedConditions.visibilityOfElementLocated(ShareSaveButton)).click();
			//Calls the Share check function
			obj1.receiptReport(driver, sharer, username, password1);
			//Clicks on EiRCA side panel
			wait1.until(ExpectedConditions.visibilityOfElementLocated(EiRCASidePanel)).click();
			//Wait for loading message to disappear
			obj1.loadingServer(driver);
	    	//Clicks on first newly created record
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(EiRCAFirstRecord)).click();
	    }
	    
	    public void markCritical(WebDriver driver,String username, String password1,int y) throws Exception{
	    	
	    	WebDriverWait wait1 = new WebDriverWait(driver,60);
	    	//Clicks on mark critical
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(MarkCritical)).click();
	    	//Clicks on confirm change
			wait1.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupTitle)).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupButton)).click();
			//Checks if marked critical
			String critical=wait1.until(ExpectedConditions.visibilityOfElementLocated(EiRCAMarkCriticalIndicatorText)).getText();
			softly.assertThat(critical).as("test data").contains("Critical");
			if(driver.findElement(EiRCAMarkCriticalIndicatorText).isDisplayed())
				System.out.println("Marked critical");
			//Clicks on mark critical again
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(MarkCritical)).click();
	    	//Clicks on confirm change
			wait1.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupTitle)).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupButton)).click();
			Thread.sleep(2000);
			if(driver.findElement(EiRCAMarkCriticalIndicatorText).isDisplayed()==false)
			{
				System.out.println("Unmarked critical");
			}
			//Verify report not retrieved by shared to person
		    ErrorMeter obj = new ErrorMeter();
			String sharer = obj.decideSharer (y);
			ShareCheck obj1 = new ShareCheck();
			obj1.checkCriticalNotification(driver, sharer, username, password1, softly);		
			//Clicks on EiRCA side panel
			wait1.until(ExpectedConditions.visibilityOfElementLocated(EiRCASidePanel)).click();
			//Wait for loading message to disappear
			obj1.loadingServer(driver);
	    	//Clicks on first newly created record
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(EiRCAFirstRecord)).click();
	    }
	    
	    public void verifyProbStatementPlaceHolder(WebDriver driver) throws Exception {
	    	
	    	WebDriverWait wait = new WebDriverWait(driver,10);
	    	EiRCAChinese obj = new EiRCAChinese();
	    	//Waits for the page to load
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    	//Get place holder of Problem Statement and verify that it is not "foo"
	    	String s = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EiRCAEventProblemStatementField)).getAttribute("placeholder");
	    	softly.assertThat(s).as("test data").isEqualTo("Fill in Problem statement");
	    }
	    
	    public void verifySequenceOfEvents(WebDriver driver) throws Exception {
	    	
	    	WebDriverWait wait = new WebDriverWait(driver,10);
	    	EiRCAChinese obj = new EiRCAChinese();
	    	//Verify title
	    	String s = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EiRCAInfoPageTitle)).getText();
	    	softly.assertThat(s).as("test data").isEqualTo("Sequence of Events");
	    	//Click on Description
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(DescriptionPlusSign)).click();
	    	//Verify description text
	    	String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(DescriptionText)).getText();
	    	String desc = "The sequence of events is a series of related situations occurring prior to and after the triggering error. "
	    			+ "It is composed of a series of time-specific events of facts and data. The time-specific events are presented in a timeline to describe how"
	    			+ " the final failure (or event or unacceptable consequence) occurred. The purpose of developing the sequence of events is to determine the "
	    			+ "triggering error(s) that provoked the chain of events leading to the final failure (or unacceptable consequence)."
	    			+"\n"+"\n"
	    			+"Add and describe each time-specific event (or step) leading up to the final failure or unacceptable consequence. In the column to the right, "
	    			+ "describe what should have happened instead of what actually occurred. This will help point out where any abnormal condition occurred.";
	    	softly.assertThat(s1).as("test data").isEqualTo(desc);
	    	//Click on Description again
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(DescriptionPlusSign)).click();
	    	//Verify date box header
	    	String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(DateHeader)).getText();
	    	softly.assertThat(s2).as("test data").isEqualTo("Date:");
	    	//Verify time box header
	    	String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(TimeHeader)).getText();
	    	softly.assertThat(s3).as("test data").isEqualTo("Time:");
	    	//Verify What happened box header
	    	String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(WhatHappenedHeader)).getText();
	    	softly.assertThat(s4).as("test data").isEqualTo("What happened?:");
	    	//Verify What is supposed to happen box header
	    	String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(WhatIsSupposedToHappenHeader)).getText();
	    	softly.assertThat(s5).as("test data").isEqualTo("What is supposed to happen?:");
	    	//Verify placeholder for What happened box
	    	String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(WhatHappenedField)).getAttribute("placeholder");
	    	softly.assertThat(s6).as("test data").isEqualTo("Description of each related step prior to and after the triggering error, leading to the event.");
	    	//Verify placeholder for What is supposed to happen box
	    	String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(WhatIsSupposedToHappenField)).getAttribute("placeholder");
	    	softly.assertThat(s7).as("test data").isEqualTo("Description of what should happen instead of the abnormal condition that occurred.");
	    }
	    
	    public void createNewEvent(WebDriver driver, String text) throws Exception {
	    	
	    	WebDriverWait wait = new WebDriverWait(driver,10);
	    	WebDriverWait wait1 = new WebDriverWait(driver,5);
	    	//Select date
	    	//Click on calendar icon
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(CalendarIconAddEvent)).click();
	    	//Click on - sign
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(CalendarMinusSign)).click();
	    	//Select 1st date of 1st row
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(Calendar1stRow1stDate)).click();
	    	Thread.sleep(1000);
	    	//Wait for disappearance of date box
	    	try{
	    		wait1.until(ExpectedConditions.invisibilityOfElementLocated(Calendar1stRow1stDate));
	    	}catch(org.openqa.selenium.TimeoutException r)
	    	{
	    		
	    	}
	    	//Select time
	    	//Click on clock icon
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(ClockIconAddEvent)).click();
	    	//Click on set time
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(ClockSetTime)).click();
	    	Thread.sleep(1000);
	    	//Wait for disappearance of time box
	    	try{
	    		wait1.until(ExpectedConditions.invisibilityOfElementLocated(ClockSetTime));
	    	}catch(org.openqa.selenium.TimeoutException r)
	    	{
	    		
	    	}
	    	//Enter text in what happened
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(WhatHappenedField)).sendKeys(text);
	    	//Enter text in what is supposed to happen
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(WhatIsSupposedToHappenField)).sendKeys(text);
	    	//Click on add sign
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(EventAddSign)).click();
	    }
	    
	    public void verifyEmptyTexBox(WebDriver driver) throws Exception {
	    	
	    	WebDriverWait wait = new WebDriverWait(driver,10);
	    	//Verify empty text in what happened
	    	String s = wait.until(ExpectedConditions.visibilityOfElementLocated(WhatHappenedField)).getText();
	    	//Verify empty text in what is supposed to happen
	    	String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(WhatIsSupposedToHappenField)).getText();
	    	//Get browser name
			Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		    String browserName = cap.getBrowserName().toLowerCase();
		    System.out.println(browserName);
		    if (browserName.equals("internet explorer"))
		    {
		    	softly.assertThat(s).as("test data").isEqualTo("Description of each related step prior to and after the triggering error, leading to the event.");
		    	softly.assertThat(s1).as("test data").isEqualTo("Description of what should happen instead of the abnormal condition that occurred.");
		    }
		    else
		    {
		    	softly.assertThat(s).as("test data").isEqualTo("");
		    	softly.assertThat(s1).as("test data").isEqualTo("");
		    }
	    }
	    
	    public void verifyTextEditable(WebDriver driver,WebElement ele, String text) throws Exception {
	    	
	    	//Get text present in text box
		    String s = ele.getAttribute("value");
		    System.out.println(s);
		    //CLear some text
		    for (int i=0;i<6;i++)
		    	ele.sendKeys(Keys.BACK_SPACE);
		    //Clear all text
		    ele.clear();
		    //Enter new text in text box
		    ele.sendKeys(text);
		    String s1 = ele.getAttribute("value");
		    System.out.println(s1);
		    if(s.equals(s1)==true)
		    	softly.fail("Text could not be edited for web element: \n"+ele);
	    }
	    
	    public HashMap<String,String> storeEvent(WebDriver driver) throws Exception {
	    	
	    	WebDriverWait wait = new WebDriverWait(driver,10);
	    	//First listed event
	    	//Get date
	    	String s = wait.until(ExpectedConditions.visibilityOfElementLocated(Date1stEvent)).getAttribute("value");
	    	//Get time
	    	String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(Time1stEvent)).getAttribute("value");
	    	//Get what happened
	    	String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(WhatHappened1stEvent)).getAttribute("value");
	    	//Get what is supposed to happen
	    	String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(WhatIsSupposedToHappen1stEvent)).getAttribute("value");
	    	//Store in HashMap
	    	HashMap <String,String> hm = new HashMap<String,String>();
	    	hm.put("date", s);
	    	hm.put("time", s1);
	    	hm.put("what happened", s2);
	    	hm.put("what is supposed to happen", s3);
	    	return hm;
	    }
	    
	    public HashMap<String,String> verifyOrderOfEvents(WebDriver driver) throws Exception {
	    	
	    	WebDriverWait wait = new WebDriverWait(driver,10);
	    	//Get date from 1st row
	    	String s = wait.until(ExpectedConditions.visibilityOfElementLocated(Date1stEvent)).getAttribute("value");
	    	//Get date from 2nd row
	    	String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(Date2ndEvent)).getAttribute("value");
	    	//Get time from 1st row
	    	String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(Time1stEvent)).getAttribute("value");
	    	//Get time from 2nd row
	    	String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(Time2ndEvent)).getAttribute("value");
	    	//Store date and time in HashMap
	    	HashMap <String,String> hm = new HashMap<String,String>();
	    	hm.put("Date 1st row", s);
	    	hm.put("Date 2nd row", s1);
	    	hm.put("Time 1st row", s2);
	    	hm.put("Time 2nd row", s3);
	    	//Compare date and time
	    	String year1 = s.substring(0, 4);
	    	String year2 = s1.substring(0, 4);
	    	String month1 = s.substring(5, 7);
	    	String month2 = s1.substring(5, 7);
	    	String day1 = s.substring(8, 10);
	    	String day2 = s1.substring(8, 10);	
	    	String hour1 = s2.substring(0, 2);
	    	String hour2 = s3.substring(0, 2);
	    	String minute1 = s2.substring(3, 5);
	    	String minute2 = s3.substring(3, 5);
	    	//Compare year
	    	int n1 = Integer.parseInt(year1);
	    	int n2 = Integer.parseInt(year2);
	    	if(n1>n2)
	    	{
	    		softly.fail("Year: Order wrong as later date "+n1+ " event appears before previous date event"+n2);
	    	}
	    	if(n1==n2)
	    	{
	    		//Compare month
	    		n1 = Integer.parseInt(month1);
	    		n2 = Integer.parseInt(month2);
	    		if(n1>n2)
		    	{
		    		softly.fail("Month: Order wrong as later date "+n1+ " event appears before previous date event"+n2);
		    	}
	    		if(n1==n2)
	    		{
	    			//Compare day
		    		n1 = Integer.parseInt(day1);
		    		n2 = Integer.parseInt(day2);
		    		if(n1>n2)
			    	{
			    		softly.fail("Day: Order wrong as later date "+n1+ " event appears before previous date event"+n2);
			    	}
		    		if(n1==n2)
		    		{
		    			//Compare time
		    			//Minute
		    			n1 = Integer.parseInt(hour1);
			    		n2 = Integer.parseInt(hour2);
			    		if(n1>n2)
				    	{
				    		softly.fail("Minute: Order wrong as later date and time"+n1+ " event appears before previous date and time event"+n2);
				    	}
			    		if(n1==n2)
			    		{
			    			//Compare time
			    			//Second
			    			n1 = Integer.parseInt(minute1);
				    		n2 = Integer.parseInt(minute2);
				    		if(n1>n2)
					    	{
					    		softly.fail("Second: Order wrong as later date and time"+n1+ " event appears before previous date and time event"+n2);
					    	}
			    		}
		    		}
	    		}
	    	}
	    	return hm;
	    }
	    
	    public void changeDate(WebDriver driver) throws Exception {
	    	
	    	WebDriverWait wait = new WebDriverWait(driver,10);
	    	//Click on calendar icon add event
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(CalendarIconAddEvent)).click();
	    	//Click on - sign twice
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(CalendarMinusSign)).click();
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(CalendarMinusSign)).click();
	    	//Select 1st date of 1st row
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(Calendar1stRow1stDate)).click();
	    }
	    
	    public void makeDateSame(WebDriver driver) throws Exception {
	    	
	    	WebDriverWait wait = new WebDriverWait(driver,10);
	    	//Click on calendar icon on 2nd event
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(CalendarIcon2ndEvent)).click();
	    	//Click on - sign twice
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(CalendarMinusSign)).click();
	    	//Select 1st date of 1st row
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(Calendar1stRow1stDate)).click();	    	
	    }
	    
	    public void changeTime(WebDriver driver) throws Exception {
	    	
	    	WebDriverWait wait = new WebDriverWait(driver,10);
	    	//Click on clock icon on 2nd event
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(ClockIcon2ndEvent)).click();
	    	//Click on - sign of hour
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(ClockHourMinusSign)).click();
	    	//Click on set time
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(ClockSetTime)).click();
	    }
	    
	    public String[] editTextBox(WebDriver driver) throws Exception {
	    	
	    	WebDriverWait wait = new WebDriverWait(driver,10);
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(WhatHappened1stEvent)).sendKeys("aaaaa");
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(WhatIsSupposedToHappen1stEvent)).sendKeys("aaaaa");
	    	String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(WhatHappened1stEvent)).getAttribute("value");
	    	String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(WhatIsSupposedToHappen1stEvent)).getAttribute("value");
	    	String[]s = {s1,s2};
	    	return s;
	    }
	    
	    public void verifyEditedText(WebDriver driver, String[]s) throws Exception {
	    	
	    	WebDriverWait wait = new WebDriverWait(driver,10);
	    	String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(WhatHappened2ndEvent)).getAttribute("value");
	    	String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(WhatIsSupposedToHappen2ndEvent)).getAttribute("value");
	    	softly.assertThat(s1).as("test data").isEqualTo(s[0]);
	    	softly.assertThat(s2).as("test data").isEqualTo(s[1]);
	    }
	    
	    public void delete2ndEvent(WebDriver driver) throws Exception {
	    	
	    	WebDriverWait wait = new WebDriverWait(driver,10);
	    	//Click on cross symbol of 2nd event row
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(DeleteSign2ndEvent)).click();
	    	//Click delete button
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(EiRCAConfirmButton)).click();
	    }
	    
	    public HashMap<String,String> pathEiRCASequenceOfEvents(WebDriver driver) throws Exception {
	    	
	    	WebDriverWait wait = new WebDriverWait(driver,10);
	    	JavascriptExecutor jse = (JavascriptExecutor)driver;
	    	//Scroll to the bottom
	    	Thread.sleep(2000);
    		jse.executeScript("scroll(0,1200)");
    		Thread.sleep(2000);
	    	//Click next
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(NextButtonBottomOfInfoPage)).click();
	    	Thread.sleep(2000);
	    	//Waits for the page to load
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    //Scroll to the top
	    	Thread.sleep(2000);
    		jse.executeScript("scroll(0,0)");
    		Thread.sleep(2000);
		    //Verify text in Sequence of Events
		    verifySequenceOfEvents(driver);
		    //Get list of text
		    ErrorMeter obj = new ErrorMeter();
	    	List <String> list1=obj.error50Data();
	    	Iterator<String> iter = Iterables.cycle(list1).iterator();
		    //Create a new event
		    createNewEvent(driver, iter.next());
		    //Verify text boxes empty after adding event
		    verifyEmptyTexBox(driver);
		    //Edit text in boxes of event added
		    String[]s=editTextBox(driver);
		    //Create another new event
		    createNewEvent(driver, iter.next());
		    //Verify text edited in event added first
		    verifyEditedText(driver,s);
		    //Verify text boxes empty after adding event
		    verifyEmptyTexBox(driver);
		    //Verify text is editable in what happened box for 1st row
		    WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(WhatHappened1stEvent));
		    verifyTextEditable(driver,ele, iter.next());
		    //Verify text is editable in what is supposed to happen box for 1st row
		    ele = wait.until(ExpectedConditions.visibilityOfElementLocated(WhatIsSupposedToHappen1stEvent));
		    verifyTextEditable(driver,ele, iter.next());
		    //Verify text is editable in what happened box for 2nd row
		    ele = wait.until(ExpectedConditions.visibilityOfElementLocated(WhatHappened2ndEvent));
		    verifyTextEditable(driver,ele, iter.next());
		    //Verify text is editable in what is supposed to happen box for 2nd row
		    ele = wait.until(ExpectedConditions.visibilityOfElementLocated(WhatIsSupposedToHappen2ndEvent));
		    verifyTextEditable(driver,ele, iter.next());
		    //Verify the events are organised as per date and time
		    HashMap<String,String> hm = verifyOrderOfEvents(driver);
		    System.out.println(hm);
		    //Change date on 2nd row
		    changeDate(driver);
		    Thread.sleep(1000);
		    //Verify the events are organised as per date and time
		    HashMap<String,String> hm1 = verifyOrderOfEvents(driver);
		    System.out.println(hm1);
		    //Make date same and change time on 2nd row
		    makeDateSame(driver);
		    Thread.sleep(1000);
		    changeTime(driver);
		    //Verify the events are organised as per date and time
		    HashMap<String,String> hm2 = verifyOrderOfEvents(driver);
		    System.out.println(hm2);
		    //Delete 2nd event
		    delete2ndEvent(driver);
		    //Store all event data in hashmap
		    HashMap<String,String>hm3 = storeEvent(driver);
		    //Click next
		    wait.until(ExpectedConditions.visibilityOfElementLocated(EiRCANextButton)).click();		
		    return hm3;
	    }
	    	       
	    public HashMap<String,String> reportCreate(WebDriver driver,String username) throws Exception {
	    	
	    	  JavascriptExecutor jse = (JavascriptExecutor)driver;
	    	  EiRCAChinese obj = new EiRCAChinese();
	    	  //Clicks on EiRCA
			  jse.executeScript("return document.getElementById('pii-a-menu-eirca').click();");
			  Thread.sleep(1000);
			  //Verify placeholder of problem statement
			  verifyProbStatementPlaceHolder(driver);
			  //Fills all mandatory fields
			  driver.findElement(obj.EiRCAEventTitleField).sendKeys("Sanity Test");
			  driver.findElement(obj.EiRCAEventLocationField).sendKeys("San Diego");
			  driver.findElement(obj.EiRCAEventReporterField).sendKeys("Sanity Test"); 
			  driver.findElement(obj.EiRCAEventInvestigatorField).sendKeys("Sanity Test");
			  driver.findElement(obj.EiRCAEventReviewerField).sendKeys("Sanity Test");
			  driver.findElement(obj.EiRCAEventSponsorField).sendKeys("Sanity Test");
			  driver.findElement(obj.EiRCAEventProblemStatementField).sendKeys("Sanity Test");
			  driver.findElement(obj.EiRCAEventComponentField).sendKeys("Sanity Test");
			  String ev1 = driver.findElement(obj.EiRCAEventTitleField).getAttribute("value");
			  String ev2 = driver.findElement(obj.EiRCAEventLocationField).getAttribute("value");
			  String ev3 = driver.findElement(obj.EiRCAEventReporterField).getAttribute("value");
			  String ev4 = driver.findElement(obj.EiRCAEventInvestigatorField).getAttribute("value");
			  String ev5 = driver.findElement(obj.EiRCAEventReviewerField).getAttribute("value");
			  String ev6 = driver.findElement(obj.EiRCAEventSponsorField).getAttribute("value");
			  String ev7= driver.findElement(obj.EiRCAEventProblemStatementField).getAttribute("value");
			  String ev8= driver.findElement(obj.EiRCAEventComponentField).getAttribute("value");
			  if ((ev1.equals("Sanity Test")==false))
			  {
				  driver.findElement(obj.EiRCAEventTitleField).clear();
				  driver.findElement(obj.EiRCAEventTitleField).sendKeys("Sanity Test");
			  }
			  if ((ev2.equals("San Diego")==false))
			  {
				  driver.findElement(obj.EiRCAEventLocationField).clear();
				  driver.findElement(obj.EiRCAEventLocationField).sendKeys("San Diego");
			  }
			  if ((ev3.equals("Sanity Test")==false))
			  {
				  driver.findElement(obj.EiRCAEventReporterField).clear();
				  driver.findElement(obj.EiRCAEventReporterField).sendKeys("Sanity Test");
			  }
			  if ((ev4.equals("Sanity Test")==false))
			  {
				  driver.findElement(obj.EiRCAEventInvestigatorField).clear();
				  driver.findElement(obj.EiRCAEventInvestigatorField).sendKeys("Sanity Test");
			  }
			  if ((ev5.equals("Sanity Test")==false))
			  {
				  driver.findElement(obj.EiRCAEventReviewerField).clear();
				  driver.findElement(obj.EiRCAEventReviewerField).sendKeys("Sanity Test");
			  }
			  if ((ev6.equals("Sanity Test")==false))
			  {
				  driver.findElement(obj.EiRCAEventSponsorField).clear();
				  driver.findElement(obj.EiRCAEventSponsorField).sendKeys("Sanity Test");
			  }
			  if ((ev7.equals("Sanity Test")==false))
			  {
				  driver.findElement(obj.EiRCAEventProblemStatementField).clear();
				  driver.findElement(obj.EiRCAEventProblemStatementField).sendKeys("Sanity Test");
			  }
			  if ((ev8.equals("Sanity Test")==false))
			  {
				  driver.findElement(obj.EiRCAEventComponentField).clear();
				  driver.findElement(obj.EiRCAEventComponentField).sendKeys("Sanity Test");
			  }
			  //Sequence of Events
			  HashMap<String,String>hm = pathEiRCASequenceOfEvents(driver);
			  //Clicks on Save button
			  jse.executeScript("return document.getElementById('pii-ircam-save').click();");
			  //Clicks on Save Report button
			  WebDriverWait wait1 = new WebDriverWait(driver,10);
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(EiRCAPopupTitle)).click();
			  jse.executeScript("return document.getElementById('pii-ircam-dialog-confirmed').click();");
			  //Waits for the green popup on the right top corner
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(StickyNote));
			  //Clicks on info tab
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(InfoTab)).click();
			  //Gets the value from the text field report creation date
			  String creationDate = driver.findElement(ReportCreationDateField).getAttribute("value");
			  String name = creationDate + "_"+username+"_Sanity Test" ;
			  System.out.println(name);
			  //Clicks on Saved activities button
			  jse.executeScript("return document.getElementById('pii-ircam-savedactivities').click();");
			  Thread.sleep(2000);
			  //Clicks on panel on the left on EiRCA
			  jse.executeScript("return document.getElementById('pii-user-home-panel-btn-mirca').click();");
			  Thread.sleep(2000);
			  //Gets the name of the record created
			  WebElement record = driver.findElement(EiRCAFirstRecord);
			  String recordName = record.getText();
			  if (record.isDisplayed())
			  {
				  System.out.println("Record found: "+ recordName);
			  }
			  else
				  System.out.println ("Record not found.");
			  //Checks if the name displayed on record is same as expected
			  softly.assertThat(recordName).as("test data").isEqualTo(name);
			  //Open HTML and verify Sequence of Events
			  verifyHTML(driver,hm);
			  return hm;
	    }
	    
	    public void softAssert() throws Exception {
			softly.assertAll();
			System.gc();
		}

}
