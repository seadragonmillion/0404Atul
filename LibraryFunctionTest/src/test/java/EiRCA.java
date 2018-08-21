import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.Iterables;


public class EiRCA {
	
	SoftAssertions softly = new SoftAssertions();
	
	
	//Buttons on HML report page
	By DeleteButton = By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[3]");
	By OpenButton = By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[1]");
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
	By EiRCAPopupCancelButton = By.id("pii-ircam-dialog-cancel");
	
	By EiRCASavedActivitiesButton = By.id("pii-ircam-savedactivities");
	
	//Report pop up on HTML page
	By ConfirmPopupTitle = By.id("pii-user-home-dialog-title");
	By ConfirmPopupButton = By.id("pii-user-home-dialog-confirmed");
	By ConfirmCancelButton = By.id("pii-user-home-dialog-cancel");
	
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
	
	//Step 1
	By EiRCAStep1Q11AnswerSelected = By.xpath(".//*[@id='pii-ircam-tab-2']/div[4]/div/span");
	By EiRCAStep1Q12AnswerSelected = By.xpath(".//*[@id='pii-ircam-tab-2']/div[6]/div/span");
	By EiRCAStep1Q13AnswerSelected = By.xpath(".//*[@id='pii-ircam-tab-2']/div[9]/div/span");
	
	By EiRCANextButton = By.id("pii-ircam-next");
	
	//HTML
	//Table 1
	By HTMLTable1EventTitle = By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[1]/td[2]");
	By HTMLTable1LocationOfEvent = By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[3]/td[2]");
	By HTMLTable1WhoDiscovered = By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[5]/td[2]");
	By HTMLTable1Investigators = By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[8]/td[2]");
	By HTMLTable1Reviewers = By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[9]/td[2]");
	By HTMLTable1ManagementSponsors = By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[10]/td[2]");
	By HTMLTable1ProblemStatement = By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[11]/td[2]");
	By HTMLTable1SuspectedFailedComponent = By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[12]/td[2]");
	//Step 3
	By HTMLTable7Step3Row1Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[1]/td[2]");
	By HTMLTable7Step3Row1Column3 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[1]/td[3]");
	By HTMLTable7Step3Row2Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[2]/td[2]");
	By HTMLTable7Step3Row2Column3 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[2]/td[3]");
	By HTMLTable7Step3Row3Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[3]/td[2]");
	By HTMLTable7Step3Row3Column3 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[3]/td[3]");
	By HTMLTable7Step3Row4Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[4]/td[2]");
	By HTMLTable7Step3Row4Column3 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[4]/td[3]");
	By HTMLTable7Step3Row5Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[5]/td[2]");
	By HTMLTable7Step3Row5Column3 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[5]/td[3]");
	By HTMLTable7Step3Row6Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[6]/td[2]");
	By HTMLTable7Step3Row6Column3 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[6]/td[3]");
	//Step1 Table 4
	By HTMLTable4Step1Q11 = By.xpath(".//*[@id='mirca-rpt']/div[6]/table/tbody/tr[1]/td[2]");
	By HTMLTable4Step1Q12 = By.xpath(".//*[@id='mirca-rpt']/div[6]/table/tbody/tr[2]/td[2]");
	By HTMLTable4Step1Q13 = By.xpath(".//*[@id='mirca-rpt']/div[6]/table/tbody/tr[3]/td[2]");
	//Step 2
	By HTMLTable5Step2Row1Column1 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/table/tbody/tr[1]/td[1]");
	//Skipped steps 4,5,6,7
	By HTMLStep4SkippedRCA = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]");
	By HTMLStep4SkippedTr = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[1]");
	By HTMLStep4SkippedTr1 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[2]");
	By HTMLStep5Skipped = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]");
	By HTMLStep6Skipped = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[6]");
	By HTMLStep7Skipped = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]");
	//Step 5
	By HTMLTable14Step5Row1Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[2]/div[7]/table/tbody/tr[1]/td[2]/strong");
	By HTMLTable14Step5Row2Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[2]/div[8]/table/tbody/tr[1]/td[2]/strong");
	//Step 6
	By HTMLStep6Row5Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[3]/div[2]/table/tbody/tr[5]/td[2]/strong");
	By HTMLStep6Row6Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[3]/div[2]/table/tbody/tr[6]/td[2]/strong");
	By HTMLStep6Row7Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[3]/div[2]/table/tbody/tr[7]/td[2]/strong");
	By HTMLStep6Row8Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[3]/div[2]/table/tbody/tr[8]/td[2]/strong");
	//Step 7
	By HTMLStep7Row2Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[2]/td[2]/strong");
	By HTMLStep7Row2Column3 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[2]/td[3]/strong");
	By HTMLStep7Row2Column4 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[2]/td[4]/strong");
	By HTMLStep7Row2Column5 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[2]/td[5]/strong");
	By HTMLStep7Row3Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[3]/td[2]/strong");
	By HTMLStep7Row3Column3 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[3]/td[3]/strong");
	By HTMLStep7Row3Column4 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[3]/td[4]/strong");
	By HTMLStep7Row3Column5 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[3]/td[5]/strong");
	By HTMLStep7Row4Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[4]/td[2]/strong");
	By HTMLStep7Row4Column3 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[4]/td[3]/strong");
	By HTMLStep7Row4Column4 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[4]/td[4]/strong");
	By HTMLStep7Row4Column5 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[4]/td[5]/strong");
	By HTMLStep7Row5Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[5]/td[2]/strong");
	By HTMLStep7Row5Column3 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[5]/td[3]/strong");
	By HTMLStep7Row5Column4 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[5]/td[4]/strong");
	By HTMLStep7Row5Column5 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[5]/td[5]/strong");
	//RCA
	By HTMLStep7Row2Column2RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[2]/td[2]/strong");
	By HTMLStep7Row2Column3RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[2]/td[3]/strong");
	By HTMLStep7Row2Column4RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[2]/td[4]/strong");
	By HTMLStep7Row2Column5RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[2]/td[5]/strong");
	By HTMLStep7Row3Column2RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[3]/td[2]/strong");
	By HTMLStep7Row3Column3RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[3]/td[3]/strong");
	By HTMLStep7Row3Column4RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[3]/td[4]/strong");
	By HTMLStep7Row3Column5RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[3]/td[5]/strong");
	By HTMLStep7Row4Column2RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[4]/td[2]/strong");
	By HTMLStep7Row4Column3RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[4]/td[3]/strong");
	By HTMLStep7Row4Column4RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[4]/td[4]/strong");
	By HTMLStep7Row4Column5RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[4]/td[5]/strong");
	By HTMLStep7Row5Column2RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[5]/td[2]/strong");
	By HTMLStep7Row5Column3RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[5]/td[3]/strong");
	By HTMLStep7Row5Column4RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[5]/td[4]/strong");
	By HTMLStep7Row5Column5RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[5]/td[5]/strong");

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
	
	  public void verifyHTML(WebDriver driver,HashMap<String,String>hm, String text, int n,int x, int y, int z, String ans1, String ans2, String ans3, HashMap<String,Integer> c)throws Exception {
    	
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
	      String r1 = s2.replace("\u00AD", "");
	      softly.assertThat(r1).as("test data").isEqualTo(hm.get("what happened"));
	      String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(SequenceOfEventPageWhatShouldHappenTitle)).getText();
	      String r2 = s3.replace("\u00AD", "");
	      softly.assertThat(r2).as("test data").isEqualTo(hm.get("what is supposed to happen"));	    
	      System.out.println("\n \n"+r1 + "\n" +r2);
	      //Verify text filled in first table
	      //Event title
	      String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLTable1EventTitle)).getText();
	      String r3 = s4.replace("\u00AD", "");
	      softly.assertThat(r3).as("test data").isEqualTo(text);
	      //Location of event
	      String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLTable1LocationOfEvent)).getText();
	      String r4 = s5.replace("\u00AD", "");
	      softly.assertThat(r4).as("test data").isEqualTo(text);
	      //Who discovered
	      String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLTable1WhoDiscovered)).getText();
	      String r5 = s6.replace("\u00AD", "");
	      softly.assertThat(r5).as("test data").isEqualTo(text);
	      //Investigators
	      String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLTable1Investigators)).getText();
	      String r6 = s7.replace("\u00AD", "");
	      softly.assertThat(r6).as("test data").isEqualTo(text);
	      //Reviewers
	      String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLTable1Reviewers)).getText();
	      String r7 = s8.replace("\u00AD", "");
	      softly.assertThat(r7).as("test data").isEqualTo(text);
	      //Management sponsors
	      String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLTable1ManagementSponsors)).getText();
	      String r8 = s9.replace("\u00AD", "");
	      softly.assertThat(r8).as("test data").isEqualTo(text);
	      //Problem Statement
	      String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLTable1ProblemStatement)).getText();
	      String r9 = s10.replace("\u00AD", "");
	      softly.assertThat(r9).as("test data").isEqualTo(text);
	      //Suspected failed component
	      String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLTable1SuspectedFailedComponent)).getText();
	      String r10 = s11.replace("\u00AD", "");
	      softly.assertThat(r10).as("test data").isEqualTo(text);
	      //Convert Value of hashmap to list
	      List<Integer> c1 = returnListFromHMValue(c);
	      //Root cause and contributing factor
	      if(z!=0)
	    	  HTMLRCTable(driver,z,c,c1);
	      //Step 1 Table
	      HTMLStep1Table(driver,ans1,ans2,ans3);
	      //Step 2 Table
	      HTMLStep2Table(driver);
	      //Step 3 Table
	      HTMLStep3Table(driver,n);
	      //Verify step 4 skipped
	      if(ans1.contains("Root Cause Analysis"))
	      {
		      String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep4SkippedRCA)).getText();
		      softly.assertThat(s12).as("test data").isEqualTo("Step 4 - Probability of Occurrence and Actions (not applicable)");
		      //Verify step5 skipped
		      if(y==0)
		      {
		    	  String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep5Skipped)).getText();
			      softly.assertThat(s13).as("test data").isEqualTo("Step 5 - Identify Possible Contributing Factors (skipped)");
		      }
		      else
		      {
		    	  HTMLStep5(driver,x);
		      }
		      //Verify step 6 skipped
		      if(z==0)
		      {
		    	  String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep6Skipped)).getText();
			      softly.assertThat(s13).as("test data").isEqualTo("Step 6 - Determine Contributing Factors (skipped)");
		      }
		      else
		      {
		    	  HTMLStep6(driver,y);
		      }
		      //Verify step 7 skipped
		      if(z==0)
		      {
		    	  String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep7Skipped)).getText();
			      softly.assertThat(s13).as("test data").contains("Step 7 - Root Causes Determination Checklist (SUEP");
			      softly.assertThat(s13).as("test data").contains("(skipped)");
		      }
		      else
		      {
		    	  HTMLStep7RCTr(driver,z,c1);
		      }
	      }	      
	      //Verify step 4 skipped
	      if(ans1.contains("Troubleshooting"))
	      {
		      String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep4SkippedTr)).getText();
		      softly.assertThat(s12).as("test data").isEqualTo("Step 4 - Probability of Occurrence and Actions");
		      String s12a = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep4SkippedTr1)).getText();
		      softly.assertThat(s12a).as("test data").isEqualTo("Unrefuted failure modes are shown from highest to lowest probability of occurence.");
		      //Verify step5 skipped
		      if(y==0)
		      {
		    	  String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep5Skipped)).getText();
			      softly.assertThat(s13).as("test data").isEqualTo("Step 5 - Identify Possible Contributing Factors (skipped)");
		      }
		      else
		      {
		    	  HTMLStep5(driver,x);
		      }
		      //Verify step 6 skipped
		      if(z==0)
		      {
		    	  String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep6Skipped)).getText();
			      softly.assertThat(s13).as("test data").isEqualTo("Step 6 - Determine Contributing Factors (skipped)");
		      }
		      else
		      {
		    	  HTMLStep6(driver,y);
		      }
		      //Verify step 7 skipped
		      if(z==0)
		      {
		    	  String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep7Skipped)).getText();
			      softly.assertThat(s13).as("test data").contains("Step 7 - Root Causes Determination Checklist (SUEP");
			      softly.assertThat(s13).as("test data").contains("(skipped)");
		      }
		      else
		      {
		    	  HTMLStep7RCTr(driver,z,c1);
		      }
	      }
	  }
	  
	  public List<Integer> returnListFromHMValue(HashMap<String,Integer> c) throws Exception {
		  
		  List<Integer>c1 = new ArrayList<Integer>();
		  if(c.isEmpty()==false)
		  {
			 if(c.get("Culprit work activities")!=null)
				 c1.add(c.get("Culprit work activities"));
			 if(c.get("Inadequate preventive maintenance schedule")!=null)
				 c1.add(c.get("Inadequate preventive maintenance schedule"));
			 if(c.get("Sub-standard practice: maintenance error")!=null)
				 c1.add(c.get("Sub-standard practice: maintenance error"));
			 if(c.get("Sub-standard practice: operating errors")!=null)
				 c1.add(c.get("Sub-standard practice: operating errors"));
		  }
		  return c1;
	  }
	  
	  public void HTMLRCTable(WebDriver driver, int z, HashMap<String,Integer> c, List<Integer> c1) throws Exception {
		  
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  int i=1;
		  int j=1;
		  if(c.get("Culprit work activities")!=null)
		  {
			  if(c.get("Culprit work activities")==4)
			  {
				  i=i+1;
				  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[3]/table/tbody/tr["+i+"]/td[1]"))).getText();
				  System.out.println(s);
				  softly.assertThat(s).as("test data").isEqualTo("Culprit work activities");
			  }
			  else
			  {
				  j=j+1;
				  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[4]/table/tbody/tr["+j+"]/td[1]"))).getText();
				  System.out.println(s);
				  softly.assertThat(s).as("test data").isEqualTo("Culprit work activities");
			  }
		  }
		  if(c.get("Inadequate preventive maintenance schedule")!=null)
		  {
			  if(c.get("Inadequate preventive maintenance schedule")==4)
			  {
				  i=i+1;
				  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[3]/table/tbody/tr["+i+"]/td[1]"))).getText();
				  softly.assertThat(s).as("test data").isEqualTo("Inadequate preventive maintenance schedule");
			  }
			  else
			  {
				  j=j+1;
				  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[4]/table/tbody/tr["+j+"]/td[1]"))).getText();
				  softly.assertThat(s).as("test data").isEqualTo("Inadequate preventive maintenance schedule");
			  }
		  }
		  if(c.get("Sub-standard practice: maintenance error")!=null)
		  {
			  if(c.get("Sub-standard practice: maintenance error")==4)
			  {
				  i=i+1;
				  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[3]/table/tbody/tr["+i+"]/td[1]"))).getText();
				  softly.assertThat(s).as("test data").isEqualTo("Sub-standard practice: maintenance error");
			  }
			  else
			  {
				  j=j+1;
				  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[4]/table/tbody/tr["+j+"]/td[1]"))).getText();
				  softly.assertThat(s).as("test data").isEqualTo("Sub-standard practice: maintenance error");
			  }
		  }
		  if(c.get("Sub-standard practice: operating errors")!=null)
		  {
			  if(c.get("Sub-standard practice: operating errors")==4)
			  {
				  i=i+1;
				  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[3]/table/tbody/tr["+i+"]/td[1]"))).getText();
				  softly.assertThat(s).as("test data").isEqualTo("Sub-standard practice: operating errors");
			  }
			  else
			  {
				  j=j+1;
				  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[4]/table/tbody/tr["+j+"]/td[1]"))).getText();
				  softly.assertThat(s).as("test data").isEqualTo("Sub-standard practice: operating errors");
			  }
		  }		  
	  }
	  
	  public void HTMLStep7RCTr(WebDriver driver, int z, List<Integer> c) throws Exception {
		  
		  WebDriverWait wait = new WebDriverWait(driver,2);
		  for(int i=1;i<=z;i++)
		  {
			  int f = c.get(i-1);
			  if(i==1)
			  {
				  if(f>=1)
				  {
					  try{
						  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep7Row2Column2RC)).getText();
						  softly.assertThat(s).as("test data").isEqualTo("Yes");
					  }catch(org.openqa.selenium.TimeoutException r)
					  {
						  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep7Row2Column2)).getText();
						  softly.assertThat(s).as("test data").isEqualTo("Yes");
					  }
					  
				  }
				  if(f>=2)
				  {
					  try{
						  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep7Row2Column3RC)).getText();
						  softly.assertThat(s).as("test data").isEqualTo("Yes");
					  }catch(org.openqa.selenium.TimeoutException r)
					  {
						  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep7Row2Column3)).getText();
						  softly.assertThat(s).as("test data").isEqualTo("Yes");
					  }
				  }
				  if(f>=3)
				  {
					  try{
						  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep7Row2Column4RC)).getText();
						  softly.assertThat(s).as("test data").isEqualTo("Yes");
					  }catch(org.openqa.selenium.TimeoutException r)
					  {
						  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep7Row2Column4)).getText();
						  softly.assertThat(s).as("test data").isEqualTo("Yes");
					  }
				  }
				  if(f==4)
				  {
					  try{
						  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep7Row2Column5RC)).getText();
						  softly.assertThat(s).as("test data").isEqualTo("Yes");
					  }catch(org.openqa.selenium.TimeoutException r)
					  {
						  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep7Row2Column5)).getText();
						  softly.assertThat(s).as("test data").isEqualTo("Yes");
					  }
				  }
			  }
			  if(i==2)
			  {
				  if(f>=1)
				  {
					  try{
						  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep7Row3Column2RC)).getText();
						  softly.assertThat(s).as("test data").isEqualTo("Yes");
					  }catch(org.openqa.selenium.TimeoutException r)
					  {
						  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep7Row3Column2)).getText();
						  softly.assertThat(s).as("test data").isEqualTo("Yes");
					  }
				  }
				  if(f>=2)
				  {
					  try{
						  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep7Row3Column3RC)).getText();
						  softly.assertThat(s).as("test data").isEqualTo("Yes");
					  }catch(org.openqa.selenium.TimeoutException r)
					  {
						  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep7Row3Column3)).getText();
						  softly.assertThat(s).as("test data").isEqualTo("Yes");
					  }
				  }
				  if(f>=3)
				  {
					  try{
						  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep7Row3Column4RC)).getText();
						  softly.assertThat(s).as("test data").isEqualTo("Yes");
					  }catch(org.openqa.selenium.TimeoutException r)
					  {
						  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep7Row3Column4)).getText();
						  softly.assertThat(s).as("test data").isEqualTo("Yes");
					  }
				  }
				  if(f==4)
				  {
					  try{
						  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep7Row3Column5RC)).getText();
						  softly.assertThat(s).as("test data").isEqualTo("Yes");
					  }catch(org.openqa.selenium.TimeoutException r)
					  {
						  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep7Row3Column5)).getText();
						  softly.assertThat(s).as("test data").isEqualTo("Yes");
					  }
				  }
			  }
			  if(i==3)
			  {
				  if(f>=1)
				  {
					  try{
						  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep7Row4Column2RC)).getText();
						  softly.assertThat(s).as("test data").isEqualTo("Yes");
					  }catch(org.openqa.selenium.TimeoutException r)
					  {
						  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep7Row4Column2)).getText();
						  softly.assertThat(s).as("test data").isEqualTo("Yes");
					  }
				  }
				  if(f>=2)
				  {
					  try{
						  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep7Row4Column3RC)).getText();
						  softly.assertThat(s).as("test data").isEqualTo("Yes");
					  }catch(org.openqa.selenium.TimeoutException r)
					  {
						  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep7Row4Column3)).getText();
						  softly.assertThat(s).as("test data").isEqualTo("Yes");
					  }
				  }
				  if(f>=3)
				  {
					  try{
						  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep7Row4Column4RC)).getText();
						  softly.assertThat(s).as("test data").isEqualTo("Yes");
					  }catch(org.openqa.selenium.TimeoutException r)
					  {
						  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep7Row4Column4)).getText();
						  softly.assertThat(s).as("test data").isEqualTo("Yes");
					  }
				  }
				  if(f==4)
				  {
					  try{
						  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep7Row4Column5RC)).getText();
						  softly.assertThat(s).as("test data").isEqualTo("Yes");
					  }catch(org.openqa.selenium.TimeoutException r)
					  {
						  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep7Row4Column5)).getText();
						  softly.assertThat(s).as("test data").isEqualTo("Yes");
					  }
				  }
			  }
			  if(i==4)
			  {
				  if(f>=1)
				  {
					  try{
						  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep7Row5Column2RC)).getText();
						  softly.assertThat(s).as("test data").isEqualTo("Yes");
					  }catch(org.openqa.selenium.TimeoutException r)
					  {
						  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep7Row5Column2)).getText();
						  softly.assertThat(s).as("test data").isEqualTo("Yes");
					  }
				  }
				  if(f>=2)
				  {
					  try{
						  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep7Row5Column3RC)).getText();
						  softly.assertThat(s).as("test data").isEqualTo("Yes");
					  }catch(org.openqa.selenium.TimeoutException r)
					  {
						  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep7Row5Column3)).getText();
						  softly.assertThat(s).as("test data").isEqualTo("Yes");
					  }
				  }
				  if(f>=3)
				  {
					  try{
						  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep7Row5Column4RC)).getText();
						  softly.assertThat(s).as("test data").isEqualTo("Yes");
					  }catch(org.openqa.selenium.TimeoutException r)
					  {
						  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep7Row5Column4)).getText();
						  softly.assertThat(s).as("test data").isEqualTo("Yes");
					  }
				  }
				  if(f==4)
				  {
					  try{
						  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep7Row5Column5RC)).getText();
						  softly.assertThat(s).as("test data").isEqualTo("Yes");
					  }catch(org.openqa.selenium.TimeoutException r)
					  {
						  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep7Row5Column5)).getText();
						  softly.assertThat(s).as("test data").isEqualTo("Yes");
					  }
				  }
			  }
		  }
	  }	 
	  
	  public void HTMLStep6(WebDriver driver, int y) throws Exception {
		  
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  for(int i=1;i<=y;i++)
		  {
			  if(i==1)
			  {
				  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep6Row5Column2)).getText();
				  softly.assertThat(s).as("test data").isEqualTo("Yes");
			  }
			  if(i==2)
			  {
				  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep6Row6Column2)).getText();
				  softly.assertThat(s).as("test data").isEqualTo("Yes");
			  }
			  if(i==3)
			  {
				  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep6Row7Column2)).getText();
				  softly.assertThat(s).as("test data").isEqualTo("Yes");
			  }
			  if(i==4)
			  {
				  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep6Row8Column2)).getText();
				  softly.assertThat(s).as("test data").isEqualTo("Yes");
			  }
		  }
	  }
	  
	  public void HTMLStep5(WebDriver driver, int x) throws Exception {
		  
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  for(int i=1;i<=x;i++)
		  {
			  if(i==1)
			  {
				  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLTable14Step5Row1Column2)).getText();
				  softly.assertThat(s).as("test data").isEqualTo("Yes");
			  }
			  if(i==2)
			  {
				  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLTable14Step5Row2Column2)).getText();
				  softly.assertThat(s).as("test data").isEqualTo("Yes");
			  }
		  }
	  }
	  
	  public void HTMLStep3Table(WebDriver driver, int n) throws Exception {
		  
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  for(int i=1;i<=n;i++)
		  {
			  if(i==1)
			  {
				  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLTable7Step3Row1Column2)).getText();
				  softly.assertThat(s).as("test data").isEqualTo("Yes");
				  String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLTable7Step3Row1Column3)).getText();
				  softly.assertThat(s1).as("test data").isEqualTo("Yes");
			  }
			  if(i==2)
			  {
				  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLTable7Step3Row2Column2)).getText();
				  softly.assertThat(s).as("test data").isEqualTo("Yes");
				  String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLTable7Step3Row2Column3)).getText();
				  softly.assertThat(s1).as("test data").isEqualTo("Yes");
			  }
			  if(i==3)
			  {
				  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLTable7Step3Row3Column2)).getText();
				  softly.assertThat(s).as("test data").isEqualTo("Yes");
				  String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLTable7Step3Row3Column3)).getText();
				  softly.assertThat(s1).as("test data").isEqualTo("Yes");
			  }
			  if(i==4)
			  {
				  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLTable7Step3Row4Column2)).getText();
				  softly.assertThat(s).as("test data").isEqualTo("Yes");
				  String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLTable7Step3Row4Column3)).getText();
				  softly.assertThat(s1).as("test data").isEqualTo("Yes");
			  }
			  if(i==5)
			  {
				  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLTable7Step3Row5Column2)).getText();
				  softly.assertThat(s).as("test data").isEqualTo("Yes");
				  String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLTable7Step3Row5Column3)).getText();
				  softly.assertThat(s1).as("test data").isEqualTo("Yes");
			  }
			  if(i==6)
			  {
				  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLTable7Step3Row6Column2)).getText();
				  softly.assertThat(s).as("test data").isEqualTo("Yes");
				  String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLTable7Step3Row6Column3)).getText();
				  softly.assertThat(s1).as("test data").isEqualTo("Yes");
			  }
		  }
	  }
	  
	  public void HTMLStep2Table(WebDriver driver) throws Exception {
		  
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  //Text of failure mode
		  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLTable5Step2Row1Column1)).getText();
		  String r1 = s.replaceAll("\u00AD", "");
		  softly.assertThat(r1).as("test data").contains(EiRCA.this.textCreate(driver));
	  }
	  
	  public void HTMLStep1Table(WebDriver driver, String ans1, String ans2, String ans3) throws Exception {
		  
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  //1.1
		  String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLTable4Step1Q11)).getText();
		  softly.assertThat(s).as("test data").isEqualTo(ans1);
		  //1.2
		  String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLTable4Step1Q12)).getText();
		  softly.assertThat(s1).as("test data").isEqualTo(ans2);
		  //1.3
		  String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLTable4Step1Q13)).getText();
		  softly.assertThat(s2).as("test data").isEqualTo(ans3);
	  }
	  
		public void pdfCheck(WebDriver driver, HashMap<String,String>hm) throws Exception{
	    	
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
		    String newData2="";
		    for (int i = 0; i < ans.size(); i++)
		        {	        	
		        	int n=ans.get(i).length()-1;
		        	if (ans.get(i).charAt(n)==' ')
		        		newData2 = newData2+ans.get(i);
		        	if (ans.get(i).charAt(n)!=' ')
		        		newData2 = newData2+" "+ans.get(i);	        	
		        }
		    String newData1 = newData2.replace("  ", " ");
		    //Verify text with html
		    softly.assertThat(newData1).as("test data").contains(textCreate(driver));
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
	    	pdfCheck(driver,hm);
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
	    	pdfCheck(driver,hm);
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
		    pdfCheck(driver,hm);
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
		    pdfCheck(driver,hm);
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
	    	//Verify description text not visible
	    	try{
	    		WebElement l = driver.findElement(DescriptionText);
	    		if(l.isDisplayed()==true)
	    			softly.fail("Description text visible");
	    	}catch (org.openqa.selenium.NoSuchElementException r)
	    	{
	    		System.out.println("No description text visible as the + sign for description has not been clicked");
	    	}
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
	    	//Verify description text not visible
	    	try{
	    		WebElement l = driver.findElement(DescriptionText);
	    		if(l.isDisplayed()==true)
	    			softly.fail("Description text visible");
	    	}catch (org.openqa.selenium.NoSuchElementException r)
	    	{
	    		System.out.println("No description text visible as the + sign for description has not been clicked");
	    	}
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
	    	hm.put("date", s.replace("\u00AD", ""));
	    	hm.put("time", s1.replace("\u00AD", ""));
	    	hm.put("what happened", s2.replace("\u00AD", ""));
	    	hm.put("what is supposed to happen", s3.replace("\u00AD", ""));
	    	
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
	    	ShareCheck obj1 = new ShareCheck ();
		    ErrorMeter obj = new ErrorMeter();
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
    		obj1.scrollToTop(driver);
    		Thread.sleep(2000);
		    //Verify text in Sequence of Events
		    verifySequenceOfEvents(driver);
		    //Get list of text
	    	List <String> list1=obj.error50Data(driver);
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
	    
	    public void EIRCAStep1Troubleshooting(WebDriver driver) throws Exception {
	    	
	    	EiRCAChinese obj = new EiRCAChinese();
	    	//Verify no next button without mandatory dropdowns selected
	    	if(driver.findElement(EiRCANextButton).isDisplayed()==true)
	    		softly.fail("Next button visible in Step 1 without selecting 1.1, 1.2, 1.3");
	    	//Select 1.1 
	    	selectDropdown11(driver,obj);
	    	Thread.sleep(1000);
			//Select 1.2
			selectDropdown12(driver,obj);
			Thread.sleep(1000);
			//Select 1.3
			selectDropdown13(driver,obj);
			Thread.sleep(1000);
	    	//Verify next button is visible after mandatory dropdowns are selected
	    	if(driver.findElement(EiRCANextButton).isDisplayed()==false)
	    		softly.fail("Next button not visible in Step 1 after selecting 1.1, 1.2, 1.3");
	    }
	    
	    public void selectDropdown11(WebDriver driver,EiRCAChinese obj) throws Exception {
	    	
	    	Random random = new Random ();
	    	int y;
	    	while(true)
	    	{
	    		y = random.nextInt(3);
	    		if(y<1)
	    			continue;
	    		break;
	    	}
	    	WebElement dropdown1 = driver.findElement(obj.Step1Q11Answer);
			Select s1 = new Select(dropdown1);
			s1.selectByIndex(y);
	    }
	    
	    
	    public void selectDropdown12(WebDriver driver,EiRCAChinese obj) throws Exception {
	    	
	    	Random random = new Random ();
	    	int y;
	    	while(true)
	    	{
	    		y = random.nextInt(28);
	    		if(y<1)
	    			continue;
	    		break;
	    	}
	    	WebElement dropdown1 = driver.findElement(obj.Step1Q12Answer);
			Select s1 = new Select(dropdown1);
			s1.selectByIndex(y);
	    }
	    
	    public void selectDropdown13(WebDriver driver,EiRCAChinese obj) throws Exception {
	    	
	    	Random random = new Random ();
	    	int y;
	    	while(true)
	    	{
	    		y = random.nextInt(34);
	    		if(y<1)
	    			continue;
	    		break;
	    	}
	    	WebElement dropdown1 = driver.findElement(obj.Step1Q13Answer);
			Select s1 = new Select(dropdown1);
			s1.selectByIndex(y);
	    }
	    
	    public void EIRCAStep2(WebDriver driver) throws Exception {
	    	
	    	WebDriverWait wait = new WebDriverWait(driver,10);
	    	EiRCAChinese obj = new EiRCAChinese();
	    	Thread.sleep(1000);
	    	//Verify no next button without mandatory dropdowns selected
	    	if(driver.findElement(EiRCANextButton).isDisplayed()==true)
	    		softly.fail("Next button visible in Step 2 without adding a failure mode");
	    	//Fill text in 1st box 1st row
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step2Row11stTextBoxField)).sendKeys(textCreate(driver));
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step2Row12ndTextBoxField)).click();
	    	//Verify next button is visible after mandatory dropdowns are selected
	    	if(driver.findElement(EiRCANextButton).isDisplayed()==false)
	    		softly.fail("Next button not visible in Step 2 after adding failure mode");
	    	//Click on add failure mode button
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step2AddFailureButton)).click();
	    	//Verify visibility of 2nd row of boxes
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step2Row21stTextBoxField));
	    	Thread.sleep(1000);
		    //Click next
		    wait.until(ExpectedConditions.visibilityOfElementLocated(EiRCANextButton)).click();		
	    }
	    
	    public int EIRCAStep3(WebDriver driver) throws Exception {
	    	
	    	WebDriverWait wait = new WebDriverWait(driver,10);
	    	JavascriptExecutor jse = (JavascriptExecutor)driver;
	    	EiRCAChinese obj = new EiRCAChinese();
	    	ShareCheck obj1 = new ShareCheck();
	    	Thread.sleep(1000);
	    	//Click on collapsible
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step3FailureCollapsible)).click();
	    	//Choose a number between 0 to 6
	    	Random random = new Random();
	    	int n = random.nextInt(7);
	    	//int n = 0;
	    	Thread.sleep(1000);
	    	if(n==0)
	    	{
	    		System.out.println("No failure modes are refuted.");
			    //Click next
			    wait.until(ExpectedConditions.visibilityOfElementLocated(EiRCANextButton)).click();	
			    return n;
	    	}
	    	//Select options in Step 3
	    	for(int i=1;i<=n;i++)
	    	{
	    		if(i==1)
	    			//Click on check box for 3.1
	    			wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step3TableOption31CheckBox)).click();
	    		if(i==2)
	    			//Click on check box for 3.2
	    			wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step3TableOption32CheckBox)).click();
	    		if(i==3)
	    			//Click on check box for 3.3
	    			wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step3TableOption33CheckBox)).click();
	    		if(i==4)
	    			//Click on check box for 3.4
	    			wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step3TableOption34CheckBox)).click();
	    		if(i==5)
	    		{
		    		//Scroll to the bottom
		    		Thread.sleep(500);
		    		jse.executeScript("scroll(0,1200)");
		    		Thread.sleep(500);
		    		//Click on check box for 3.5
		    		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step3TableOption35CheckBox)).click();
	    		}
	    		if(i==6)
	    		{
		    		//Scroll to the bottom
		    		Thread.sleep(500);
		    		jse.executeScript("scroll(0,1200)");
		    		Thread.sleep(500);
		    		//Click on check box for 3.6
		    		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step3TableOption36CheckBox)).click();
	    		}	    		
	    	}
    		//Scroll to the top
    		Thread.sleep(500);
    		obj1.scrollToTop(driver);
    		Thread.sleep(500);
		    //Click next
		    wait.until(ExpectedConditions.visibilityOfElementLocated(EiRCANextButton)).click();	
		    //Click on see report
		    wait.until(ExpectedConditions.visibilityOfElementLocated(EiRCAPopupCancelButton)).click();	
		    return n;
	    }
	    
	    public int EIRCAStep4OneFailureMode(WebDriver driver) throws Exception {
	    	
	    	WebDriverWait wait = new WebDriverWait(driver,10);
	    	EiRCAChinese obj = new EiRCAChinese();
	    	//Choose 0 or 1
	    	Random random = new Random ();
	    	int n = random.nextInt(2);
	    	Thread.sleep(1000);
	    	//Click on collapsible
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step4FailureCollapsible)).click();
	    	if(n==1)
	    	{
	    		//Select 4.4
		    	wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step4TableOption44CheckBox)).click();
	    	}
	    	Thread.sleep(1000);
		    //Click next
		    wait.until(ExpectedConditions.visibilityOfElementLocated(EiRCANextButton)).click();	
		    Thread.sleep(1000);
		    //Click on continue
		    wait.until(ExpectedConditions.visibilityOfElementLocated(EiRCAConfirmButton)).click();
		    Thread.sleep(1000);
		    return n;
	    }
	    
	    public int EIRCAStep5OneFailureMode(WebDriver driver) throws Exception {
	    	
	    	WebDriverWait wait = new WebDriverWait(driver,10);
	    	EiRCAChinese obj = new EiRCAChinese();
	    	ShareCheck obj1 = new ShareCheck();
	    	//Click on collapsible
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step5FailureCollapsible)).click();
	    	Thread.sleep(1000);
	    	//Choose 0 to 2
	    	Random random = new Random ();
	    	int n = random.nextInt(3);
	    	if(n==0)
	    	{
			    //Click next
			    wait.until(ExpectedConditions.visibilityOfElementLocated(EiRCANextButton)).click();	
			    return n;
	    	}
	    	for(int i=1;i<=n;i++)
	    	{
		    	if(i==1)
		    	{
			    	WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step5TableOption55CheckBox));
		    		obj1.scrollToElement(driver, l);
		    		//Click on 5.5
			    	l.click();
		    	}
		    	if(i==2)
		    	{
			    	WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step5TableOption56CheckBox));
		    		obj1.scrollToElement(driver, l);
		    		//Click on 5.6
			    	l.click();
		    	}
	    	}
    		//Scroll to the top
    		Thread.sleep(500);
    		obj1.scrollToTop(driver);
    		Thread.sleep(500);
	    	//Click next
		    wait.until(ExpectedConditions.visibilityOfElementLocated(EiRCANextButton)).click();	
		    return n;
	    }
	    
	    public int EIRCAStep6OneFailureMode(WebDriver driver) throws Exception {
	    	
	    	WebDriverWait wait = new WebDriverWait(driver,10);
	    	EiRCAChinese obj = new EiRCAChinese();
	    	ShareCheck obj1 = new ShareCheck();
	    	//Click on collapsible
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step6FailureCollapsible)).click();
	    	//Choose 0 to 4
	    	Random random = new Random ();
	    	int n = random.nextInt(5);
	    	if(n==0)
	    	{
			    //Click next
			    wait.until(ExpectedConditions.visibilityOfElementLocated(EiRCANextButton)).click();	
			    return n;
	    	}
	    	for(int i=1;i<=n;i++)
	    	{
		    	if(i==1)
		    	{
			    	WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step6TableOption65CheckBox));
		    		obj1.scrollToElement(driver, l);
		    		//Click on 6.5
			    	l.click();
		    	}
		    	if(i==2)
		    	{
			    	WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step6TableOption66CheckBox));
		    		obj1.scrollToElement(driver, l);
		    		//Click on 6.6
			    	l.click();
		    	}
		    	if(i==3)
		    	{
			    	WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step6TableOption67CheckBox));
		    		obj1.scrollToElement(driver, l);
		    		//Click on 6.7
			    	l.click();
		    	}
		    	if(i==4)
		    	{
			    	WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step6TableOption68CheckBox));
		    		obj1.scrollToElement(driver, l);
		    		//Click on 6.8
			    	l.click();
		    	}
	    	}
    		//Scroll to the top
    		Thread.sleep(500);
    		obj1.scrollToTop(driver);
    		Thread.sleep(500);
	    	//Click next
		    wait.until(ExpectedConditions.visibilityOfElementLocated(EiRCANextButton)).click();	
		    return n;
	    }
	    
	    public int chooseNumberOfSUEPBoxes() throws Exception {
	    	
	    	//Choose 0 to 4
	    	Random random = new Random();
	    	return random.nextInt(5);
	    }
	    
	    public HashMap<String,Integer> EiRCAStep7OneFailureMode(WebDriver driver, int n) throws Exception {
	    	
	    	WebDriverWait wait = new WebDriverWait(driver,10);
	    	EiRCAChinese obj = new EiRCAChinese();
	    	HashMap<String,Integer> c = new HashMap<String,Integer>();
	    	for(int i=1;i<=n;i++)
	    	{
		    	int k = chooseNumberOfSUEPBoxes();
	    		if(i==1)
		    	{
	    			String key = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step7SUEPTableRow2)).getText();
	    			c.put(key, k);
			    	if(k==1)
			    	{
			    		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step7SUEPTableRow2Chk1)).click();
			    	}
			    	if(k==2)
			    	{
			    		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step7SUEPTableRow2Chk1)).click();
			    		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step7SUEPTableRow2Chk2)).click();
			    	}
			    	if(k==3)
			    	{
			    		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step7SUEPTableRow2Chk1)).click();
			    		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step7SUEPTableRow2Chk2)).click();
			    		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step7SUEPTableRow2Chk3)).click();
			    	}
			    	if(k==4)
			    	{
			    		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step7SUEPTableRow2Chk1)).click();
			    		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step7SUEPTableRow2Chk2)).click();
			    		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step7SUEPTableRow2Chk3)).click();
			    		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step7SUEPTableRow2Chk4)).click();
			    	}
		    	}
		    	if(i==2)
		    	{
		    		String key = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step7SUEPTableRow3)).getText();
	    			c.put(key, k);
		    		if(k==1)
			    	{
			    		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step7SUEPTableRow3Chk1)).click();
			    	}
			    	if(k==2)
			    	{
			    		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step7SUEPTableRow3Chk1)).click();
			    		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step7SUEPTableRow3Chk2)).click();
			    	}
			    	if(k==3)
			    	{
			    		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step7SUEPTableRow3Chk1)).click();
			    		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step7SUEPTableRow3Chk2)).click();
			    		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step7SUEPTableRow3Chk3)).click();
			    	}
			    	if(k==4)
			    	{
			    		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step7SUEPTableRow3Chk1)).click();
			    		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step7SUEPTableRow3Chk2)).click();
			    		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step7SUEPTableRow3Chk3)).click();
			    		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step7SUEPTableRow3Chk4)).click();
			    	}
		    	}
		    	if(i==3)
		    	{
		    		String key = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step7SUEPTableRow4)).getText();
	    			c.put(key, k);
		    		if(k==1)
			    	{
			    		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step7SUEPTableRow4Chk1)).click();
			    	}
			    	if(k==2)
			    	{
			    		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step7SUEPTableRow4Chk1)).click();
			    		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step7SUEPTableRow4Chk2)).click();
			    	}
			    	if(k==3)
			    	{
			    		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step7SUEPTableRow4Chk1)).click();
			    		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step7SUEPTableRow4Chk2)).click();
			    		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step7SUEPTableRow4Chk3)).click();
			    	}
			    	if(k==4)
			    	{
			    		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step7SUEPTableRow4Chk1)).click();
			    		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step7SUEPTableRow4Chk2)).click();
			    		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step7SUEPTableRow4Chk3)).click();
			    		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step7SUEPTableRow4Chk4)).click();
			    	}
		    	}
		    	if(i==4)
		    	{
		    		String key = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step7SUEPTableRow5)).getText();
	    			c.put(key, k);
		    		if(k==1)
			    	{
			    		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step7SUEPTableRow5Chk1)).click();
			    	}
			    	if(k==2)
			    	{
			    		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step7SUEPTableRow5Chk1)).click();
			    		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step7SUEPTableRow5Chk2)).click();
			    	}
			    	if(k==3)
			    	{
			    		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step7SUEPTableRow5Chk1)).click();
			    		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step7SUEPTableRow5Chk2)).click();
			    		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step7SUEPTableRow5Chk3)).click();
			    	}
			    	if(k==4)
			    	{
			    		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step7SUEPTableRow5Chk1)).click();
			    		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step7SUEPTableRow5Chk2)).click();
			    		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step7SUEPTableRow5Chk3)).click();
			    		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step7SUEPTableRow5Chk4)).click();
			    	}
		    	}
	    	}
	    	return c;
	    }
	    
	    public String textCreate(WebDriver driver) throws Exception {
	    	
	    	if(driver.getCurrentUrl().contains("kaleqa"))
	    		return ("Sanity <section> Test \"title\" Sanity");
	    	else
	    		return("Sanity Test \"title\" Sanity");
	    }
	    	       
	    public HashMap<String,String> reportCreate(WebDriver driver,String username) throws Exception {
	    	
	    	  JavascriptExecutor jse = (JavascriptExecutor)driver;
	    	  EiRCAChinese obj = new EiRCAChinese();
	    	  WebDriverWait wait1 = new WebDriverWait(driver,10);
	    	  String text = textCreate(driver);
	    	  //Clicks on EiRCA
			  jse.executeScript("return document.getElementById('pii-a-menu-eirca').click();");
			  Thread.sleep(1000);
			  //Verify placeholder of problem statement
			  verifyProbStatementPlaceHolder(driver);
			  //Fills all mandatory fields
			  driver.findElement(obj.EiRCAEventTitleField).sendKeys(text);
			  driver.findElement(obj.EiRCAEventLocationField).sendKeys(text);
			  driver.findElement(obj.EiRCAEventReporterField).sendKeys(text); 
			  driver.findElement(obj.EiRCAEventInvestigatorField).sendKeys(text);
			  driver.findElement(obj.EiRCAEventReviewerField).sendKeys(text);
			  driver.findElement(obj.EiRCAEventSponsorField).sendKeys(text);
			  driver.findElement(obj.EiRCAEventProblemStatementField).sendKeys(text);
			  driver.findElement(obj.EiRCAEventComponentField).sendKeys(text);
			  String ev1 = driver.findElement(obj.EiRCAEventTitleField).getAttribute("value");
			  String ev2 = driver.findElement(obj.EiRCAEventLocationField).getAttribute("value");
			  String ev3 = driver.findElement(obj.EiRCAEventReporterField).getAttribute("value");
			  String ev4 = driver.findElement(obj.EiRCAEventInvestigatorField).getAttribute("value");
			  String ev5 = driver.findElement(obj.EiRCAEventReviewerField).getAttribute("value");
			  String ev6 = driver.findElement(obj.EiRCAEventSponsorField).getAttribute("value");
			  String ev7= driver.findElement(obj.EiRCAEventProblemStatementField).getAttribute("value");
			  String ev8= driver.findElement(obj.EiRCAEventComponentField).getAttribute("value");
			  if ((ev1.equals(text)==false))
			  {
				  driver.findElement(obj.EiRCAEventTitleField).clear();
				  driver.findElement(obj.EiRCAEventTitleField).sendKeys(text);
			  }
			  if ((ev2.equals(text)==false))
			  {
				  driver.findElement(obj.EiRCAEventLocationField).clear();
				  driver.findElement(obj.EiRCAEventLocationField).sendKeys(text);
			  }
			  if ((ev3.equals(text)==false))
			  {
				  driver.findElement(obj.EiRCAEventReporterField).clear();
				  driver.findElement(obj.EiRCAEventReporterField).sendKeys(text);
			  }
			  if ((ev4.equals(text)==false))
			  {
				  driver.findElement(obj.EiRCAEventInvestigatorField).clear();
				  driver.findElement(obj.EiRCAEventInvestigatorField).sendKeys(text);
			  }
			  if ((ev5.equals(text)==false))
			  {
				  driver.findElement(obj.EiRCAEventReviewerField).clear();
				  driver.findElement(obj.EiRCAEventReviewerField).sendKeys(text);
			  }
			  if ((ev6.equals(text)==false))
			  {
				  driver.findElement(obj.EiRCAEventSponsorField).clear();
				  driver.findElement(obj.EiRCAEventSponsorField).sendKeys(text);
			  }
			  if ((ev7.equals(text)==false))
			  {
				  driver.findElement(obj.EiRCAEventProblemStatementField).clear();
				  driver.findElement(obj.EiRCAEventProblemStatementField).sendKeys(text);
			  }
			  if ((ev8.equals(text)==false))
			  {
				  driver.findElement(obj.EiRCAEventComponentField).clear();
				  driver.findElement(obj.EiRCAEventComponentField).sendKeys(text);
			  }
			  //Sequence of Events
			  HashMap<String,String>hm = pathEiRCASequenceOfEvents(driver);
			  //Step1
			  EIRCAStep1Troubleshooting(driver);
			  String s2 = wait1.until(ExpectedConditions.visibilityOfElementLocated(EiRCAStep1Q11AnswerSelected)).getText();
			  //Get 1.2 selected answer
			  String s = wait1.until(ExpectedConditions.visibilityOfElementLocated(EiRCAStep1Q12AnswerSelected)).getText();
			  //Get 1.3 selected answer
			  String s1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(EiRCAStep1Q13AnswerSelected)).getText();
			  //Click next
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(EiRCANextButton)).click();	
			  //Step2
			  EIRCAStep2(driver);
			  //Step3
			  int n = EIRCAStep3(driver);
			  int x,y,z;
			  x=0;
			  y=0;
			  z=0;
			  if(n==0)
			  {
				  //Step 4
				  if(s2.equals("Troubleshooting"))
					  x = EIRCAStep4OneFailureMode(driver);
				  Thread.sleep(2000);
				  //Step 5
				  y = EIRCAStep5OneFailureMode(driver);
				  Thread.sleep(2000);
				  //Step 6
				  z = EIRCAStep6OneFailureMode(driver);
			  }
			  //Step 7
			  HashMap<String,Integer> c = EiRCAStep7OneFailureMode(driver,z);
			  Thread.sleep(2000);
			  //Clicks on Save button
			  jse.executeScript("return document.getElementById('pii-ircam-save').click();");
			  Thread.sleep(2000);
			  //Clicks on Save Report button			  
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(EiRCAPopupTitle)).click();
			  Thread.sleep(2000);
			  jse.executeScript("return document.getElementById('pii-ircam-dialog-confirmed').click();");
			  //Waits for the green popup on the right top corner
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(StickyNote));
			  Thread.sleep(2000);
			  //Clicks on info tab
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(InfoTab)).click();
			  //Gets the value from the text field report creation date
			  String creationDate = driver.findElement(ReportCreationDateField).getAttribute("value");
			  String name = creationDate + "_"+username+"_"+text ;
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
			  //Replace the shy character in chrome
			  String r1 = recordName.replaceAll("\u00AD", "");
			  if (record.isDisplayed())
			  {
				  System.out.println("Record found: "+ r1);
			  }
			  else
				  System.out.println ("Record not found.");
			  //Checks if the name displayed on record is same as expected
			  softly.assertThat(r1).as("test data").isEqualTo(name);
			  //Open HTML and verify Sequence of Events
			  verifyHTML(driver,hm, text, n, x, y, z, s2, s, s1,c);
			  return hm;
	    }
	    
	    public void softAssert() throws Exception {
			softly.assertAll();
			System.gc();
		}

}
