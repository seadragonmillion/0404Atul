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
import org.assertj.core.util.Strings;
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


	//Buttons on HTML report page
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
	By EiRCAPopupHeader = By.id("pii-ircam-dialog-header");
	By EiRCAPopupTitle = By.id("pii-ircam-dialog-title");
	By EiRCAConfirmButton = By.id("pii-ircam-dialog-confirmed");
	By EiRCAPopupCancelButton = By.id("pii-ircam-dialog-cancel");
	By EiRCANextButton = By.id("pii-ircam-next");
	By EiRCASavedActivitiesButton = By.id("pii-ircam-savedactivities");

	//Report pop up on HTML page
	By ConfirmPopupHeader = By.id("pii-user-home-dialog-header");
	By ConfirmPopupNote = By.id("pii-user-home-dialog-note");
	By ConfirmPopupTitle = By.id("pii-user-home-dialog-title");
	By ConfirmPopupButton = By.id("pii-user-home-dialog-confirmed");
	By ConfirmCancelButton = By.id("pii-user-home-dialog-cancel");

	By EiRCAFirstRecord = By.xpath(".//*[@id='pii-user-home-activities-mirca']/ul/li[2]/a");
	By StickyNote = By.className("sticky-note");
	By StickySuccess = By.className("sticky-success");
	By StickyClose = By.className("sticky-close");;

	//Sequence of Events in HTML
	By SequenceOfEventPageTitle = By.xpath(".//*[@id='mirca-rpt']/div[5]/div");
	By SequenceOfEventPageDateTimeTitle1 = By.xpath(".//*[@id='mirca-rpt']/div[5]/table/tbody/tr[1]/td[1]");
	By SequenceOfEventPageWhatHappenedTitle1 = By.xpath(".//*[@id='mirca-rpt']/div[5]/table/tbody/tr[1]/td[2]");
	By SequenceOfEventPageWhatShouldHappenTitle1 = By.xpath(".//*[@id='mirca-rpt']/div[5]/table/tbody/tr[1]/td[3]");
	By SequenceOfEventPageDateTimeTitle2 = By.xpath(".//*[@id='mirca-rpt']/div[5]/table/tbody/tr[2]/td[1]");
	By SequenceOfEventPageWhatHappenedTitle2 = By.xpath(".//*[@id='mirca-rpt']/div[5]/table/tbody/tr[2]/td[2]");
	By SequenceOfEventPageWhatShouldHappenTitle2 = By.xpath(".//*[@id='mirca-rpt']/div[5]/table/tbody/tr[2]/td[3]");
	By SequenceOfEventPageDateTimeTitle3 = By.xpath(".//*[@id='mirca-rpt']/div[5]/table/tbody/tr[3]/td[1]");

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
	By Date3rdEvent = By.xpath(".//*[@id='pii-ircam-events-table']/tbody/tr[3]/td[2]/div/div/input");
	By Time3rdEvent = By.xpath(".//*[@id='pii-ircam-events-table']/tbody/tr[3]/td[3]/div/div/input");
	By CalendarIcon3rdEvent = By.xpath(".//*[@id='pii-ircam-events-table']/tbody/tr[3]/td[2]/div/div/a");
	By ClockIcon3rdEvent = By.xpath(".//*[@id='pii-ircam-events-table']/tbody/tr[3]/td[3]/div/div/a");
	//Table headers
	By TableDateHeader = By.xpath(".//*[@id='pii-ircam-events-table']/thead/tr[1]/th[2]");
	By TableTimeHeader = By.xpath(".//*[@id='pii-ircam-events-table']/thead/tr[1]/th[3]");
	By TableWhatHappenedHeader = By.xpath(".//*[@id='pii-ircam-events-table']/thead/tr[1]/th[4]");
	By TableWhatIsSupposedToHappenHeader = By.xpath(".//*[@id='pii-ircam-events-table']/thead/tr[1]/th[5]");

	//Step 1
	By EiRCAStep1Q11AnswerSelected = By.xpath(".//*[@id='pii-ircam-tab-2']/div[4]/div/span");
	By EiRCAStep1Q12AnswerSelected = By.xpath(".//*[@id='pii-ircam-tab-2']/div[6]/div/span");
	By EiRCAStep1Q13AnswerSelected = By.xpath(".//*[@id='pii-ircam-tab-2']/div[9]/div/span");
	By EiRCAStep1Q14AnswerTextBox = By.xpath(".//*[@id='pii-ircam-tab-2']/textarea[1]");
	By EiRCAStep1Q15AnswerTextBox = By.xpath(".//*[@id='pii-ircam-tab-2']/textarea[2]");
	By EiRCAStep1Q16AnswerTextBox = By.xpath(".//*[@id='pii-ircam-tab-2']/textarea[3]");
	By EiRCAStep1Q12AnswerTextBox = By.xpath(".//*[@id='pii-ircam-1-2-other-div']/div/input");
	By EiRCAStep1Q13AnswerTextBox = By.xpath(".//*[@id='pii-ircam-1-3-other-div']/div/input");

	//Step 2
	By EiRCAStep2Tab = By.id("pii-ircam-tab-3-a");

	//Step 3
	By Step3FailureCollapsibleFailureMode2 = By.xpath(".//*[@id='pii-ircam-tab-4']/div[4]");
	By Step3TableOption31Textbox = By.xpath(".//*[@id='pii-ircam-tab-4']/div[3]/div/table/tbody/tr[1]/td[4]/textarea");
	By Step3TableOption32Textbox = By.xpath(".//*[@id='pii-ircam-tab-4']/div[3]/div/table/tbody/tr[2]/td[4]/textarea");
	By Step3TableOption33Textbox = By.xpath(".//*[@id='pii-ircam-tab-4']/div[3]/div/table/tbody/tr[3]/td[4]/textarea");
	By Step3TableOption34Textbox = By.xpath(".//*[@id='pii-ircam-tab-4']/div[3]/div/table/tbody/tr[4]/td[4]/textarea");
	By Step3TableOption35Textbox = By.xpath(".//*[@id='pii-ircam-tab-4']/div[3]/div/table/tbody/tr[5]/td[4]/textarea");
	By Step3TableOption36Textbox = By.xpath(".//*[@id='pii-ircam-tab-4']/div[3]/div/table/tbody/tr[6]/td[4]/textarea");

	//Step 4
	By Step4FailureMode1Option42CheckBox = By.xpath(".//*[@id='pii-ircam-tab-5']/div[3]/div/table/tbody/tr[2]/td[2]/div/input");
	By Step4FailureMode1Option43CheckBox = By.xpath(".//*[@id='pii-ircam-tab-5']/div[3]/div/table/tbody/tr[3]/td[2]/div/input");
	By Step4FailureMode1Option44CheckBox = By.xpath(".//*[@id='pii-ircam-tab-5']/div[3]/div/table/tbody/tr[4]/td[2]/div/input");
	By Step4FailureMode1Option45CheckBox = By.xpath(".//*[@id='pii-ircam-tab-5']/div[3]/div/table/tbody/tr[5]/td[2]/div/input");
	By Step4FailureMode1Option46CheckBox = By.xpath(".//*[@id='pii-ircam-tab-5']/div[3]/div/table/tbody/tr[6]/td[2]/div/input");
	By Step4FailureMode1Option47CheckBox = By.xpath(".//*[@id='pii-ircam-tab-5']/div[3]/div/table/tbody/tr[7]/td[2]/div/input");
	By Step4FailureCollapsibleFailureMode2 = By.xpath(".//*[@id='pii-ircam-tab-5']/div[4]");
	By Step4FailureMode2Option41CheckBox = By.xpath(".//*[@id='pii-ircam-tab-5']/div[4]/div/table/tbody/tr[1]/td[2]/div/input");
	By Step4FailureMode2Option42CheckBox = By.xpath(".//*[@id='pii-ircam-tab-5']/div[4]/div/table/tbody/tr[2]/td[2]/div/input");
	By Step4FailureMode2Option43CheckBox = By.xpath(".//*[@id='pii-ircam-tab-5']/div[4]/div/table/tbody/tr[3]/td[2]/div/input");
	By Step4FailureMode2Option44CheckBox = By.xpath(".//*[@id='pii-ircam-tab-5']/div[4]/div/table/tbody/tr[4]/td[2]/div/input");
	By Step4FailureMode2Option45CheckBox = By.xpath(".//*[@id='pii-ircam-tab-5']/div[4]/div/table/tbody/tr[5]/td[2]/div/input");
	By Step4FailureMode2Option46CheckBox = By.xpath(".//*[@id='pii-ircam-tab-5']/div[4]/div/table/tbody/tr[6]/td[2]/div/input");
	By Step4FailureMode2Option47CheckBox = By.xpath(".//*[@id='pii-ircam-tab-5']/div[4]/div/table/tbody/tr[7]/td[2]/div/input");
	By Step4FailureMode1Option44Row = By.xpath(".//*[@id='pii-ircam-tab-5']/div[3]/div/table/tbody/tr[4]");
	By Step4FailureMode2Option44Row = By.xpath(".//*[@id='pii-ircam-tab-5']/div[4]/div/table/tbody/tr[4]");
	By Step3TableOption44Textbox = By.xpath(".//*[@id='pii-ircam-tab-5']/div[3]/div/table/tbody/tr[1]/td[3]/textarea");	

	//Step 5
	By Step5TableOption55Textbox = By.xpath(".//*[@id='pii-ircam-tab-6']/div[3]/div/table[9]/tbody/tr[1]/td[3]/textarea");
	By Step5TableOption56Textbox = By.xpath(".//*[@id='pii-ircam-tab-6']/div[3]/div/table[9]/tbody/tr[2]/td[3]/textarea");

	//Step 6
	By Step6TableOption65Textbox = By.xpath(".//*[@id='pii-ircam-tab-7']/div[3]/div/table/tbody/tr[5]/td[3]/textarea");

	//Step 7
	By Step7SUEPTableRow2CorrectiveAction = By.xpath(".//*[@id='pii-ircam-tab-8']/div[7]/table/tbody/tr[2]/td[6]/textarea");
	By Step7SUEPTableRow3CorrectiveAction = By.xpath(".//*[@id='pii-ircam-tab-8']/div[7]/table/tbody/tr[3]/td[6]/textarea");
	By Step7SUEPTableRow4CorrectiveAction = By.xpath(".//*[@id='pii-ircam-tab-8']/div[7]/table/tbody/tr[4]/td[6]/textarea");
	By Step7SUEPTableRow5CorrectiveAction = By.xpath(".//*[@id='pii-ircam-tab-8']/div[7]/table/tbody/tr[5]/td[6]/textarea");

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
	By HTMLTable7Step3Row1Column4 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[1]/td[4]");
	By HTMLTable7Step3Row2Column4 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[2]/td[4]");
	By HTMLTable7Step3Row3Column4 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[3]/td[4]");
	By HTMLTable7Step3Row4Column4 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[4]/td[4]");
	By HTMLTable7Step3Row5Column4 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[5]/td[4]");
	By HTMLTable7Step3Row6Column4 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[6]/td[4]");
	//Step1 Table 4
	By HTMLTable4Step1Q11 = By.xpath(".//*[@id='mirca-rpt']/div[6]/table/tbody/tr[1]/td[2]");
	By HTMLTable4Step1Q12 = By.xpath(".//*[@id='mirca-rpt']/div[6]/table/tbody/tr[2]/td[2]");
	By HTMLTable4Step1Q13 = By.xpath(".//*[@id='mirca-rpt']/div[6]/table/tbody/tr[3]/td[2]");
	By HTMLTable4Step1Q14 = By.xpath(".//*[@id='mirca-rpt']/div[6]/table/tbody/tr[4]/td[2]");
	By HTMLTable4Step1Q15 = By.xpath(".//*[@id='mirca-rpt']/div[6]/table/tbody/tr[5]/td[2]");
	By HTMLTable4Step1Q16 = By.xpath(".//*[@id='mirca-rpt']/div[6]/table/tbody/tr[6]/td[2]");
	//Step 2
	By HTMLTable5Step2Row1Column1 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/table/tbody/tr[1]/td[1]");
	By HTMLTable5Step2Row2Column1 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/table/tbody/tr[2]/td[1]");
	By HTMLTable5Step2Row1Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/table/tbody/tr[1]/td[2]");
	//Step 4
	By HTMLStep4Table1Row1Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[3]/table/tbody/tr[1]/td[2]");
	By HTMLStep4Table1Row2Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[3]/table/tbody/tr[2]/td[2]");
	By HTMLStep4Table1Row3Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[3]/table/tbody/tr[3]/td[2]");
	By HTMLStep4Table1Row4Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[3]/table/tbody/tr[4]/td[2]");
	By HTMLStep4Table1Row5Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[3]/table/tbody/tr[5]/td[2]");
	By HTMLStep4Table1Row6Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[3]/table/tbody/tr[6]/td[2]");
	By HTMLStep4Table1Row7Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[3]/table/tbody/tr[7]/td[2]");
	By HTMLStep4Table2Row1Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[4]/table/tbody/tr[1]/td[2]");
	By HTMLStep4Table2Row2Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[4]/table/tbody/tr[2]/td[2]");
	By HTMLStep4Table2Row3Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[4]/table/tbody/tr[3]/td[2]");
	By HTMLStep4Table2Row4Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[4]/table/tbody/tr[4]/td[2]");
	By HTMLStep4Table2Row5Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[4]/table/tbody/tr[5]/td[2]");
	By HTMLStep4Table2Row6Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[4]/table/tbody/tr[6]/td[2]");
	By HTMLStep4Table2Row7Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[4]/table/tbody/tr[7]/td[2]");
	//Skipped steps 4,5,6,7
	By HTMLStep4SkippedRCA = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]");
	By HTMLStep4SkippedTr = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[1]");
	By HTMLStep4SkippedTr1 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[2]");
	By HTMLStep5Skipped = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]");
	By HTMLStep6Skipped = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[6]");
	By HTMLStep7Skipped = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]");
	By HTMLStep7Skipped2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]");
	//Step 5
	By HTMLTable14Step5Row1Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[2]/div[7]/table/tbody/tr[1]/td[2]");
	By HTMLTable14Step5Row2Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[2]/div[8]/table/tbody/tr[1]/td[2]");
	By HTMLTable14Step5Row1Column3 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[2]/div[7]/table/tbody/tr[1]/td[3]");
	By HTMLTable14Step5Row2Column3 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[2]/div[8]/table/tbody/tr[1]/td[3]");
	//Step 6
	By HTMLStep6Row5Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[3]/div[2]/table/tbody/tr[5]/td[2]");
	By HTMLStep6Row6Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[3]/div[2]/table/tbody/tr[6]/td[2]");
	By HTMLStep6Row7Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[3]/div[2]/table/tbody/tr[7]/td[2]");
	By HTMLStep6Row8Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[3]/div[2]/table/tbody/tr[8]/td[2]");
	By HTMLStep6Row5Column3 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[3]/div[2]/table/tbody/tr[5]/td[3]");
	//Step 7
	By HTMLStep7Row2Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[2]/td[2]");
	By HTMLStep7Row2Column3 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[2]/td[3]");
	By HTMLStep7Row2Column4 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[2]/td[4]");
	By HTMLStep7Row2Column5 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[2]/td[5]");
	By HTMLStep7Row3Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[3]/td[2]");
	By HTMLStep7Row3Column3 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[3]/td[3]");
	By HTMLStep7Row3Column4 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[3]/td[4]");
	By HTMLStep7Row3Column5 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[3]/td[5]");
	By HTMLStep7Row4Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[4]/td[2]");
	By HTMLStep7Row4Column3 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[4]/td[3]");
	By HTMLStep7Row4Column4 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[4]/td[4]");
	By HTMLStep7Row4Column5 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[4]/td[5]");
	By HTMLStep7Row5Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[5]/td[2]");
	By HTMLStep7Row5Column3 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[5]/td[3]");
	By HTMLStep7Row5Column4 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[5]/td[4]");
	By HTMLStep7Row5Column5 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[5]/td[5]");
	By HTMLStep7Row2Column6 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[2]/td[6]");
	By HTMLStep7Row3Column6 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[3]/td[6]");
	By HTMLStep7Row4Column6 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[4]/td[6]");
	By HTMLStep7Row5Column6 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[5]/td[6]");
	//RCA
	By HTMLStep7Row2Column2RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[2]/td[2]");
	By HTMLStep7Row2Column3RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[2]/td[3]");
	By HTMLStep7Row2Column4RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[2]/td[4]");
	By HTMLStep7Row2Column5RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[2]/td[5]");
	By HTMLStep7Row3Column2RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[3]/td[2]");
	By HTMLStep7Row3Column3RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[3]/td[3]");
	By HTMLStep7Row3Column4RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[3]/td[4]");
	By HTMLStep7Row3Column5RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[3]/td[5]");
	By HTMLStep7Row4Column2RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[4]/td[2]");
	By HTMLStep7Row4Column3RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[4]/td[3]");
	By HTMLStep7Row4Column4RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[4]/td[4]");
	By HTMLStep7Row4Column5RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[4]/td[5]");
	By HTMLStep7Row5Column2RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[5]/td[2]");
	By HTMLStep7Row5Column3RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[5]/td[3]");
	By HTMLStep7Row5Column4RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[5]/td[4]");
	By HTMLStep7Row5Column5RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[5]/td[5]");
	By HTMLStep7Row2Column6RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[2]/td[6]");
	By HTMLStep7Row3Column6RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[3]/td[6]");
	By HTMLStep7Row4Column6RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[4]/td[6]");
	By HTMLStep7Row5Column6RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[5]/td[6]");

	public void deleteNewRecord(WebDriver driver,String recordName, int y) throws Exception{

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		ErrorMeter obj = new ErrorMeter();
		ShareCheck obj1 = new ShareCheck();
		EiRCA2 obj2 = new EiRCA2();
		//Clicks on delete button
		driver.findElement(DeleteButton).click();
		//Verify delete popup
		obj2.verifyDeleteReportPopup(driver, softly, recordName);
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupTitle));
		//Clicks on delete report
		jse.executeScript("return document.getElementById('pii-user-home-dialog-confirmed').click();");
		//Verify delete pop up
		obj2.verifyStickyDeleteReport(driver, softly, recordName);
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
		String sharer = obj.decideSharer (y);
		obj1.checkNoReportAfterDelete(driver, sharer, softly);		  			  
	}

	public void add2ndFailureMode(WebDriver driver, String username) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		EiRCAChinese obj = new EiRCAChinese();
		ShareCheck obj1 = new ShareCheck();
		EiRCA2 obj2 = new EiRCA2();
		String text = textCreate(driver);
		if(wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLTable4Step1Q11)).getText().contains("Troubleshooting"))
		{
			//Click on open button
			wait.until(ExpectedConditions.visibilityOfElementLocated(OpenButton)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupTitle));
			//Clicks on open report
			wait.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupButton)).click();
			//Click on step 3
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step3Tab)).click();
			//Remove any selection made in Step 3 if any
			removeAllStep3Selections(driver);
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(EiRCANextButton)).click();
			//Verify Step 4 has only 4.4
			verifyStep4Uncheck44(driver);
			//Click on step 2
			wait.until(ExpectedConditions.visibilityOfElementLocated(EiRCAStep2Tab)).click();
			//Enter text in 2nd row failure 
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step2Row21stTextBoxField)).sendKeys(text);
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(EiRCANextButton)).click();
			//Verify that 2 collapsibles are visible in Step 3
			//Click on collapsible
			wait.until(ExpectedConditions.visibilityOfElementLocated(Step3FailureCollapsibleFailureMode2)).click();
			//Click on collapsible
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step3FailureCollapsible)).click();
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(EiRCANextButton)).click();
			//Verify Step 4 with 2 failure modes
			verifyStep4With2FailureModes(driver);
			//In 1st failure mode select all but 4.3 and 4.4
			enable45In1stFailureMode(driver);
			//In 2nd failure mode make 4.4 enabled
			enable44In2ndFailureMode(driver);
			//Save report
			wait.until(ExpectedConditions.visibilityOfElementLocated(EiRCASaveButton)).click();
			//Save pop verify
			obj2.verifySavePopup(driver, softly);
			//Clicks on Save report
			wait.until(ExpectedConditions.visibilityOfElementLocated(EiRCAPopupTitle)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(EiRCAConfirmButton)).click();
			//Verify save sticky
			obj2.verifyStickySaveReport(driver, softly, username, text,1);
			obj1.loadingServer(driver);
			//Clicks on Saved activities
			wait.until(ExpectedConditions.visibilityOfElementLocated(EiRCASavedActivitiesButton)).click();
			obj1.loadingServer(driver);
			//Clicks on first newly created record
			wait.until(ExpectedConditions.visibilityOfElementLocated(EiRCAFirstRecord)).click();
			obj1.loadingServer(driver);
			//Verify html
			verifyHTMLWith2FailureModesAndStep4(driver);
		}
	}

	public void verifyHTMLWith2FailureModesAndStep4(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Text of failure mode
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLTable5Step2Row2Column1)).getText();
		String r1 = s.replaceAll("\u00AD", "");
		softly.assertThat(r1).as("test data").contains(EiRCA.this.textCreate(driver));
		//Step 4 table 1
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep4Table1Row1Column2)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep4Table1Row2Column2)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Yes");
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep4Table1Row3Column2)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("Yes");
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep4Table1Row4Column2)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Yes");
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep4Table1Row5Column2)).getText();
		softly.assertThat(s5).as("test data").isEqualTo("n/a");
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep4Table1Row6Column2)).getText();
		softly.assertThat(s6).as("test data").isEqualTo("Yes");
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep4Table1Row7Column2)).getText();
		softly.assertThat(s7).as("test data").isEqualTo("Yes");
		//Step 4 table 2
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep4Table2Row1Column2)).getText();
		softly.assertThat(s8).as("test data").isEqualTo("Yes");
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep4Table2Row2Column2)).getText();
		softly.assertThat(s9).as("test data").isEqualTo("Yes");
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep4Table2Row3Column2)).getText();
		softly.assertThat(s10).as("test data").isEqualTo("");
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep4Table2Row4Column2)).getText();
		softly.assertThat(s11).as("test data").isEqualTo("n/a");
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep4Table2Row5Column2)).getText();
		softly.assertThat(s12).as("test data").isEqualTo("Yes");
		String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep4Table2Row6Column2)).getText();
		softly.assertThat(s13).as("test data").isEqualTo("Yes");
		String s14 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep4Table2Row7Column2)).getText();
		softly.assertThat(s14).as("test data").isEqualTo("Yes");
	}

	public void enable44In2ndFailureMode(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		ShareCheck obj = new ShareCheck();
		//Scroll to the bottom
		Thread.sleep(1000);
		try{
			jse.executeScript("scroll(0,1500)");
		}catch (org.openqa.selenium.ScriptTimeoutException r)
		{
			Thread.sleep(3000);
			jse.executeScript("scroll(0,1500)");
		}
		Thread.sleep(1000);
		//4.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(Step4FailureMode2Option42CheckBox)).click();
		//4.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(Step4FailureMode2Option43CheckBox)).click();
		Thread.sleep(1000);
		//4.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(Step4FailureMode2Option44CheckBox)).click();
		//4.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(Step4FailureMode2Option46CheckBox)).click();
		//4.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(Step4FailureMode2Option47CheckBox)).click();
		//Scroll to top
		obj.scrollToTop(driver);
	}

	public void enable45In1stFailureMode(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		EiRCAChinese obj = new EiRCAChinese();
		ShareCheck obj1 = new ShareCheck();
		//Scroll to top
		obj1.scrollToTop(driver);
		//4.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step4TableOption44CheckBox)).click();
		//4.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(Step4FailureMode1Option42CheckBox)).click();
		//4.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(Step4FailureMode1Option45CheckBox)).click();
		//4.6
		WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(Step4FailureMode1Option46CheckBox));
		//Scroll to 4.6
		obj1.scrollToElement(driver, l);
		l.click();
		//4.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(Step4FailureMode1Option47CheckBox)).click();
	}

	public void verifyStep4With2FailureModes(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		EiRCAChinese obj = new EiRCAChinese();
		ShareCheck obj1 = new ShareCheck();
		//Click on 1st collapsible
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step4FailureCollapsible)).click();
		//Verify 4.4 is disabled
		if(driver.findElement(Step4FailureMode1Option44Row).getAttribute("class").contains("disabled")==false)
			softly.fail("In Step 4, option 4.4 is enabled.");
		//Verify presence of all checkboxes other than 4.4
		//4.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step4TableOption44CheckBox));
		//4.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(Step4FailureMode1Option42CheckBox));
		//4.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(Step4FailureMode1Option43CheckBox));
		//4.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(Step4FailureMode1Option45CheckBox));
		//4.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(Step4FailureMode1Option46CheckBox));
		//4.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(Step4FailureMode1Option47CheckBox));
		//Scroll to 2nd collapsible
		WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(Step4FailureCollapsibleFailureMode2));
		obj1.scrollToElement(driver, l);
		//Click on 2nd collapsible
		l.click();
		//Verify 4.4 is disabled
		if(driver.findElement(Step4FailureMode2Option44Row).getAttribute("class").contains("disabled")==false)
			softly.fail("In Step 4, option 4.4 is enabled.");
		//Verify presence of all checkboxes other than 4.4
		//4.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(Step4FailureMode2Option41CheckBox));
		//4.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(Step4FailureMode2Option42CheckBox));
		//4.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(Step4FailureMode2Option43CheckBox));
		//4.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(Step4FailureMode2Option45CheckBox));
		//4.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(Step4FailureMode2Option46CheckBox));
		//4.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(Step4FailureMode2Option47CheckBox));
	}

	public void verifyStep4Uncheck44(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		WebDriverWait wait1 = new WebDriverWait(driver,3);
		EiRCAChinese obj = new EiRCAChinese();
		//Click on collapsible
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step4FailureCollapsible)).click();
		//Verify 4.4 is only present as the only option
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step4TableOption44Part1)).getText();
		softly.assertThat(s).as("test data").contains("4.4: Does the failure mode occur right after and related to a design, operation, or maintenance activity?");
		//UnSelect 4.4
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step4TableOption44CheckBox)).getAttribute("checked");
		if(Strings.isNullOrEmpty(s1)==false&&s1.contains("true"))
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step4TableOption44CheckBox)).click();
		//Verify no subsequent rows are present
		try{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(Step4FailureMode1Option42CheckBox));
			softly.fail("Subsequent Step 4 rows present after 1st option (in this case should be 4.4)");
		}catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException r)
		{
			System.out.println("Only 4.4 present in one failure mode");
		}
	}

	public void removeAllStep3Selections(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		EiRCAChinese obj = new EiRCAChinese();
		ShareCheck obj1 = new ShareCheck();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Thread.sleep(1000);
		//Click on collapsible
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step3FailureCollapsible)).click();
		Thread.sleep(1000);
		//3.1
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step3TableOption31CheckBox)).getAttribute("checked");
		System.out.println(s);
		if(Strings.isNullOrEmpty(s)==false&&s.contains("true"))
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step3TableOption31CheckBox)).click();
		//3.2
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step3TableOption32CheckBox)).getAttribute("checked");
		System.out.println(s1);
		if(Strings.isNullOrEmpty(s1)==false&&s1.contains("true"))
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step3TableOption32CheckBox)).click();
		//3.3
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step3TableOption33CheckBox)).getAttribute("checked");
		System.out.println(s2);
		if(Strings.isNullOrEmpty(s2)==false&&s2.contains("true"))
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step3TableOption33CheckBox)).click();
		//3.4
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step3TableOption34CheckBox)).getAttribute("checked");
		System.out.println(s3);
		if(Strings.isNullOrEmpty(s3)==false&&s3.contains("true"))
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step3TableOption34CheckBox)).click();
		//3.5
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step3TableOption35CheckBox)).getAttribute("checked");
		System.out.println(s4);
		if(Strings.isNullOrEmpty(s4)==false&&s4.contains("true"))
		{
			//Scroll to the bottom
			Thread.sleep(500);
			jse.executeScript("scroll(0,1200)");
			Thread.sleep(500);
			//Click on check box for 3.5
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step3TableOption35CheckBox)).click();
		}
		//3.5
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step3TableOption36CheckBox)).getAttribute("checked");
		System.out.println(s5);
		if(Strings.isNullOrEmpty(s5)==false&&s5.contains("true"))
		{
			//Scroll to the bottom
			Thread.sleep(500);
			jse.executeScript("scroll(0,1200)");
			Thread.sleep(500);
			//Click on check box for 3.6
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step3TableOption36CheckBox)).click();
		}
		//Scroll to top
		obj1.scrollToTop(driver);
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
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(SequenceOfEventPageDateTimeTitle1)).getText();
		softly.assertThat(s1).as("test data").isEqualTo(hm.get("date1")+", "+hm.get("time1"));
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(SequenceOfEventPageWhatHappenedTitle1)).getText();
		String r1 = s2.replace("\u00AD", "");
		softly.assertThat(r1).as("test data").isEqualTo(hm.get("what happened1"));
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(SequenceOfEventPageWhatShouldHappenTitle1)).getText();
		String r2 = s3.replace("\u00AD", "");
		softly.assertThat(r2).as("test data").isEqualTo(hm.get("what is supposed to happen1"));	
		System.out.println("\n \n"+r1 + "\n" +r2);
		String s14 = wait.until(ExpectedConditions.visibilityOfElementLocated(SequenceOfEventPageDateTimeTitle2)).getText();
		softly.assertThat(s14).as("test data").isEqualTo(hm.get("date2")+", "+hm.get("time2"));
		String s15 = wait.until(ExpectedConditions.visibilityOfElementLocated(SequenceOfEventPageWhatHappenedTitle2)).getText();
		String r11 = s15.replace("\u00AD", "");
		softly.assertThat(r11).as("test data").isEqualTo(hm.get("what happened2"));
		String s16 = wait.until(ExpectedConditions.visibilityOfElementLocated(SequenceOfEventPageWhatShouldHappenTitle2)).getText();
		String r12 = s16.replace("\u00AD", "");
		softly.assertThat(r12).as("test data").isEqualTo(hm.get("what is supposed to happen2"));	
		System.out.println("\n \n"+r11 + "\n" +r12);
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
		//Verify Step 5,6,7 skipped when there is some selections in Step 3
		if(n>0)
		{
			String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep4SkippedRCA)).getText();
			if(ans1.contains("Root Cause Analysis"))
				softly.assertThat(s12).as("test data").isEqualTo("Step 4 - Probability of Occurrence and Actions (not applicable)");
			else{
				softly.assertThat(s12).as("test data").contains("Step 4 - Probability of Occurrence and Actions");
				softly.assertThat(s12).as("test data").contains("Unrefuted failure modes are shown from highest to lowest probability of occurence.");
			}
			String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep5Skipped)).getText();
			softly.assertThat(s13).as("test data").isEqualTo("Step 5 - Identify Possible Contributing Factors (skipped)");
			String s17 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep6Skipped)).getText();
			softly.assertThat(s17).as("test data").isEqualTo("Step 6 - Determine Contributing Factors (skipped)");
			String s18 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep7Skipped)).getText();
			softly.assertThat(s18).as("test data").contains("Step 7 - Root Causes Determination Checklist (SUEP");
			softly.assertThat(s18).as("test data").contains("(skipped)");
		}
		else{
			//Verify step 4 skipped
			if(ans1.contains("Root Cause Analysis"))
			{
				String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep4SkippedRCA)).getText();
				softly.assertThat(s12).as("test data").isEqualTo("Step 4 - Probability of Occurrence and Actions (not applicable)");
				//Verify step5 skipped
				if(y==0)
				{
					/*String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep5Skipped)).getText();
				softly.assertThat(s13).as("test data").isEqualTo("Step 5 - Identify Possible Contributing Factors (skipped)");*/
					//Commented the lines because the bug exists for eirca, even if nothing is selected, the text enetered will show up in report and step 5 is not skipped
					int x1 = 2;
					HTMLStep5Text(driver,x1);
				}
				else
				{
					//bug exists for eirca, even if nothing is selected, the text enetered will show up in report and step 5 is not skipped
					int x1 = 2;
					HTMLStep5Text(driver,x1);
					HTMLStep5(driver,x);
				}
				//Verify step 6 skipped
				if(z==0)
				{
					/*String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep6Skipped)).getText();
				softly.assertThat(s13).as("test data").isEqualTo("Step 6 - Determine Contributing Factors (skipped)");*/
					//Commented the lines because the bug exists for eirca, even if nothing is selected, the text enetered will show up in report and step 6 is not skipped
					int x1 = 2;
					HTMLStep6Text(driver,x1);
				}
				else
				{
					//bug exists for eirca, even if nothing is selected, the text enetered will show up in report and step 6 is not skipped
					int x1 = 1;
					HTMLStep6Text(driver,x1);
					HTMLStep6(driver,y);
				}
				//Verify step 7 skipped
				if(z==0)
				{
					try{
						String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep7Skipped)).getText();
						softly.assertThat(s13).as("test data").contains("Step 7 - Root Causes Determination Checklist (SUEP");
						softly.assertThat(s13).as("test data").contains("(skipped)");
					}catch(org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException r)
					{
						String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep7Skipped2)).getText();
						softly.assertThat(s13).as("test data").contains("Step 7 - Root Causes Determination Checklist (SUEP");
						softly.assertThat(s13).as("test data").contains("(skipped)");
					}

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
					/*
				String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep5Skipped)).getText();
				softly.assertThat(s13).as("test data").isEqualTo("Step 5 - Identify Possible Contributing Factors (skipped)");*/
					//Commented the lines because the bug exists for eirca, even if nothing is selected, the text enetered will show up in report and step 5 is not skipped
					int x1 = 2;
					HTMLStep5Text(driver,x1);
				}
				else
				{
					//bug exists for eirca, even if nothing is selected, the text enetered will show up in report and step 5 is not skipped
					int x1 = 2;
					HTMLStep5Text(driver,x1);
					HTMLStep5(driver,x);
				}
				//Verify step 6 skipped
				if(z==0)
				{
					/*String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep6Skipped)).getText();
				softly.assertThat(s13).as("test data").isEqualTo("Step 6 - Determine Contributing Factors (skipped)");*/
					//Commented the lines because the bug exists for eirca, even if nothing is selected, the text enetered will show up in report and step 6 is not skipped
					int x1 = 2;
					HTMLStep6Text(driver,x1);
				}
				else
				{
					//bug exists for eirca, even if nothing is selected, the text enetered will show up in report and step 6 is not skipped
					int x1 = 1;
					HTMLStep6Text(driver,x1);
					HTMLStep6(driver,y);
				}
				//Verify step 7 skipped
				if(z==0)
				{
					try{
						String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep7Skipped)).getText();
						softly.assertThat(s13).as("test data").contains("Step 7 - Root Causes Determination Checklist (SUEP");
						softly.assertThat(s13).as("test data").contains("(skipped)");
					}catch(org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException r)
					{
						String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep7Skipped2)).getText();
						softly.assertThat(s13).as("test data").contains("Step 7 - Root Causes Determination Checklist (SUEP");
						softly.assertThat(s13).as("test data").contains("(skipped)");
					}
				}
				else
				{
					HTMLStep7RCTr(driver,z,c1);
				}
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
				softly.assertThat(s).as("test data").contains("Culprit work activities");
				String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[3]/table/tbody/tr["+i+"]/td[2]"))).getText();
				String r1 = s1.replaceAll("\u00AD", "");
				softly.assertThat(r1).as("test data").contains(EiRCA.this.textCreate(driver));
			}
			else
			{
				j=j+1;
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[4]/table/tbody/tr["+j+"]/td[1]"))).getText();
				System.out.println(s);
				softly.assertThat(s).as("test data").contains("Culprit work activities");
				String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[4]/table/tbody/tr["+j+"]/td[2]"))).getText();
				String r1 = s1.replaceAll("\u00AD", "");
				softly.assertThat(r1).as("test data").contains(EiRCA.this.textCreate(driver));
			}
		}
		if(c.get("Inadequate preventive maintenance schedule")!=null)
		{
			if(c.get("Inadequate preventive maintenance schedule")==4)
			{
				i=i+1;
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[3]/table/tbody/tr["+i+"]/td[1]"))).getText();
				softly.assertThat(s).as("test data").isEqualTo("Inadequate preventive maintenance schedule");
				String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[3]/table/tbody/tr["+i+"]/td[2]"))).getText();
				String r1 = s1.replaceAll("\u00AD", "");
				softly.assertThat(r1).as("test data").contains(EiRCA.this.textCreate(driver));
			}
			else
			{
				j=j+1;
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[4]/table/tbody/tr["+j+"]/td[1]"))).getText();
				softly.assertThat(s).as("test data").isEqualTo("Inadequate preventive maintenance schedule");
				String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[4]/table/tbody/tr["+j+"]/td[2]"))).getText();
				String r1 = s1.replaceAll("\u00AD", "");
				softly.assertThat(r1).as("test data").contains(EiRCA.this.textCreate(driver));
			}
		}
		if(c.get("Sub-standard practice: maintenance error")!=null)
		{
			if(c.get("Sub-standard practice: maintenance error")==4)
			{
				i=i+1;
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[3]/table/tbody/tr["+i+"]/td[1]"))).getText();
				softly.assertThat(s).as("test data").isEqualTo("Sub-standard practice: maintenance error");
				String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[3]/table/tbody/tr["+i+"]/td[2]"))).getText();
				String r1 = s1.replaceAll("\u00AD", "");
				softly.assertThat(r1).as("test data").contains(EiRCA.this.textCreate(driver));
			}
			else
			{
				j=j+1;
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[4]/table/tbody/tr["+j+"]/td[1]"))).getText();
				softly.assertThat(s).as("test data").isEqualTo("Sub-standard practice: maintenance error");
				String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[4]/table/tbody/tr["+j+"]/td[2]"))).getText();
				String r1 = s1.replaceAll("\u00AD", "");
				softly.assertThat(r1).as("test data").contains(EiRCA.this.textCreate(driver));
			}
		}
		if(c.get("Sub-standard practice: operating errors")!=null)
		{
			if(c.get("Sub-standard practice: operating errors")==4)
			{
				i=i+1;
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[3]/table/tbody/tr["+i+"]/td[1]"))).getText();
				softly.assertThat(s).as("test data").isEqualTo("Sub-standard practice: operating errors");
				String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[3]/table/tbody/tr["+i+"]/td[2]"))).getText();
				String r1 = s1.replaceAll("\u00AD", "");
				softly.assertThat(r1).as("test data").contains(EiRCA.this.textCreate(driver));
			}
			else
			{
				j=j+1;
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[4]/table/tbody/tr["+j+"]/td[1]"))).getText();
				softly.assertThat(s).as("test data").isEqualTo("Sub-standard practice: operating errors");
				String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[4]/table/tbody/tr["+j+"]/td[2]"))).getText();
				String r1 = s1.replaceAll("\u00AD", "");
				softly.assertThat(r1).as("test data").contains(EiRCA.this.textCreate(driver));
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
				//Verify corrective action
				try{
					String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep7Row2Column6RC)).getText();
					String r1 = s.replaceAll("\u00AD", "");
					softly.assertThat(r1).as("test data").contains(EiRCA.this.textCreate(driver));
				}catch(org.openqa.selenium.TimeoutException r)
				{
					String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep7Row2Column6)).getText();
					String r1 = s.replaceAll("\u00AD", "");
					softly.assertThat(r1).as("test data").contains(EiRCA.this.textCreate(driver));
				}				
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
				//Verify corrective action
				try{
					String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep7Row3Column6RC)).getText();
					String r1 = s.replaceAll("\u00AD", "");
					softly.assertThat(r1).as("test data").contains(EiRCA.this.textCreate(driver));
				}catch(org.openqa.selenium.TimeoutException r)
				{
					String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep7Row3Column6)).getText();
					String r1 = s.replaceAll("\u00AD", "");
					softly.assertThat(r1).as("test data").contains(EiRCA.this.textCreate(driver));
				}
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
				//Verify corrective action
				try{
					String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep7Row4Column6RC)).getText();
					String r1 = s.replaceAll("\u00AD", "");
					softly.assertThat(r1).as("test data").contains(EiRCA.this.textCreate(driver));
				}catch(org.openqa.selenium.TimeoutException r)
				{
					String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep7Row4Column6)).getText();
					String r1 = s.replaceAll("\u00AD", "");
					softly.assertThat(r1).as("test data").contains(EiRCA.this.textCreate(driver));
				}
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
				//Verify corrective action
				try{
					String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep7Row5Column6RC)).getText();
					String r1 = s.replaceAll("\u00AD", "");
					softly.assertThat(r1).as("test data").contains(EiRCA.this.textCreate(driver));
				}catch(org.openqa.selenium.TimeoutException r)
				{
					String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep7Row5Column6)).getText();
					String r1 = s.replaceAll("\u00AD", "");
					softly.assertThat(r1).as("test data").contains(EiRCA.this.textCreate(driver));
				}
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

	public void HTMLStep6Text(WebDriver driver, int x) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		for(int i=1;i<=x;i++)
		{
			if(i==1)
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLStep6Row5Column3)).getText();
				String r1 = s.replaceAll("\u00AD", "");
				softly.assertThat(r1).as("test data").contains(EiRCA.this.textCreate(driver));
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

	public void HTMLStep5Text(WebDriver driver, int x) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		for(int i=1;i<=x;i++)
		{
			if(i==1)
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLTable14Step5Row1Column3)).getText();
				String r1 = s.replaceAll("\u00AD", "");
				softly.assertThat(r1).as("test data").contains(EiRCA.this.textCreate(driver));
			}
			if(i==2)
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLTable14Step5Row2Column3)).getText();
				String r1 = s.replaceAll("\u00AD", "");
				softly.assertThat(r1).as("test data").contains(EiRCA.this.textCreate(driver));
			}
		}
	}

	public void HTMLStep3TableText(WebDriver driver, int n) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		for(int i=1;i<=n;i++)
		{
			if(i==1)
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLTable7Step3Row1Column4)).getText();
				String r1 = s.replaceAll("\u00AD", "");
				softly.assertThat(r1).as("test data").contains(EiRCA.this.textCreate(driver));
			}
			if(i==2)
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLTable7Step3Row2Column4)).getText();
				String r1 = s.replaceAll("\u00AD", "");
				softly.assertThat(r1).as("test data").contains(EiRCA.this.textCreate(driver));
			}
			if(i==3)
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLTable7Step3Row3Column4)).getText();
				String r1 = s.replaceAll("\u00AD", "");
				softly.assertThat(r1).as("test data").contains(EiRCA.this.textCreate(driver));
			}
			if(i==4)
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLTable7Step3Row4Column4)).getText();
				String r1 = s.replaceAll("\u00AD", "");
				softly.assertThat(r1).as("test data").contains(EiRCA.this.textCreate(driver));
			}
			if(i==5)
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLTable7Step3Row5Column4)).getText();
				String r1 = s.replaceAll("\u00AD", "");
				softly.assertThat(r1).as("test data").contains(EiRCA.this.textCreate(driver));
			}
			if(i==6)
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLTable7Step3Row6Column4)).getText();
				String r1 = s.replaceAll("\u00AD", "");
				softly.assertThat(r1).as("test data").contains(EiRCA.this.textCreate(driver));
			}
		}
	}

	public void HTMLStep3Table(WebDriver driver, int n) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//For now x is 6 because there is a bug that exists in eirca, by which even if nothing is selected, the ext still shows up
		//Once it is fixed change function
		int x=6;
		HTMLStep3TableText(driver,x);
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
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLTable5Step2Row1Column2)).getText();
		String r2 = s1.replaceAll("\u00AD", "");
		softly.assertThat(r2).as("test data").contains(EiRCA.this.textCreate(driver));
	}

	public void HTMLStep1Table(WebDriver driver, String ans1, String ans2, String ans3) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//1.1
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLTable4Step1Q11)).getText();
		softly.assertThat(s).as("test data").isEqualTo(ans1);
		//1.2
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLTable4Step1Q12)).getText();
		softly.assertThat(s1).as("test data").contains(ans2);
		if(ans2.contains("Other MECHANICAL related components")||ans2.contains("Other ELECTRICAL related components"))
		{
			String r = s1.replaceAll("\u00AD", "");
			softly.assertThat(r).as("test data").contains(EiRCA.this.textCreate(driver));
		}
		//1.3
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLTable4Step1Q13)).getText();
		softly.assertThat(s2).as("test data").contains(ans3);
		if(ans3.contains("Other MECHANICAL related symptoms")||ans3.contains("Other ELECTRICAL related symptoms"))
		{
			String r = s2.replaceAll("\u00AD", "");
			softly.assertThat(r).as("test data").contains(EiRCA.this.textCreate(driver));
		}
		//1.4
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLTable4Step1Q14)).getText();
		String r1 = s3.replaceAll("\u00AD", "");
		softly.assertThat(r1).as("test data").contains(EiRCA.this.textCreate(driver));
		//1.5
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLTable4Step1Q15)).getText();
		String r2 = s4.replaceAll("\u00AD", "");
		softly.assertThat(r2).as("test data").contains(EiRCA.this.textCreate(driver));
		//1.6
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLTable4Step1Q16)).getText();
		String r3 = s5.replaceAll("\u00AD", "");
		softly.assertThat(r3).as("test data").contains(EiRCA.this.textCreate(driver));
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
		softly.assertThat(newData1).as("test data").contains(hm.get("date1")+", "+hm.get("time1"));
		softly.assertThat(newData1).as("test data").contains(hm.get("what happened1"));
		softly.assertThat(newData1).as("test data").contains(hm.get("what is supposed to happen1"));
		softly.assertThat(newData1).as("test data").contains(hm.get("date2")+", "+hm.get("time2"));
		softly.assertThat(newData1).as("test data").contains(hm.get("what happened2"));
		softly.assertThat(newData1).as("test data").contains(hm.get("what is supposed to happen2"));
		//Close pdf
		pddoc.close();
	}

	public void openReport(WebDriver driver, String recordName) throws Exception{

		WebDriverWait wait1 = new WebDriverWait(driver,30);
		EiRCA2 obj = new EiRCA2();
		//Clicks on Open button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(OpenButton)).click();
		//Verify open report pop up
		obj.verifyOpenReportPopup(driver, softly, recordName);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupTitle)).click();
		//Clicks on open report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupButton)).click();
		//Clicks on Save
		wait1.until(ExpectedConditions.visibilityOfElementLocated(EiRCASaveButton)).click();
		//Save pop verify
		obj.verifySavePopup(driver, softly);
		//Clicks on Save report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(EiRCAPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(EiRCAConfirmButton)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(StickyClose)).click();
		Thread.sleep(1000);
		//Clicks on Saved activities
		wait1.until(ExpectedConditions.visibilityOfElementLocated(EiRCASavedActivitiesButton)).click();
		Thread.sleep(2000);
	}

	public void downloadRecordChrome(WebDriver driver, HashMap <String,String> hm) throws Exception {

		//deletes files in reports folder before starting to download
		File file = new File("C://Users//IEUser//Downloads//reports//");
		ShareCheck obj = new ShareCheck();		
		HiRCAEvent obj1 = new HiRCAEvent();
		EiRCA2 obj2 = new EiRCA2();
		obj1.deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(EiRCAFirstRecord)).click();
		String window = driver.getWindowHandle();
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(DownloadButton)).click();
		//Verify pdf pop up
		obj2.verifyStickyCreatePDF(driver, softly);
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Verify download pop up
		obj2.verifyDownloadReportPopup(driver, softly);
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
		Thread.sleep(3000);
		//Switches to the iframe
		wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
	}

	public void downloadRecordFirefox(WebDriver driver, HashMap <String,String> hm) throws Exception {

		//deletes files in reports folder before starting to download
		File file = new File("C://Users//IEUser//Downloads//reports//");
		HiRCAEvent obj1 = new HiRCAEvent();
		EiRCA2 obj2 = new EiRCA2();
		obj1.deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(EiRCAFirstRecord)).click();
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(DownloadButton)).click();
		//Verify pdf pop up
		obj2.verifyStickyCreatePDF(driver, softly);
		//Wait for loading message to disappear
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Verify download pop up
		obj2.verifyDownloadReportPopup(driver, softly);
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
		Thread.sleep(3000);
		//Switches to the iframe
		wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
	}

	public void downloadRecordIE10(WebDriver driver, HashMap <String,String> hm) throws Exception {

		//deletes files in reports folder before starting to download
		File file = new File("C://Users//IEUser//Downloads//reports//");
		HiRCAEvent obj1 = new HiRCAEvent();
		EiRCA2 obj2 = new EiRCA2();
		obj1.deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(EiRCAFirstRecord)).click();
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(DownloadButton)).click();
		//Verify pdf pop up
		obj2.verifyStickyCreatePDF(driver, softly);
		//Wait for loading message to disappear
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Verify download pop up
		obj2.verifyDownloadReportPopup(driver, softly);
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
		Thread.sleep(3000);
		//Switches to the iframe
		wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
	}

	public void downloadRecordIE11(WebDriver driver, HashMap <String,String> hm) throws Exception {

		//deletes files in reports folder before starting to download
		File file = new File("C://Users//IEUser//Downloads//reports//");
		HiRCAEvent obj1 = new HiRCAEvent();
		EiRCA2 obj2 = new EiRCA2();
		obj1.deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(EiRCAFirstRecord)).click();
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(DownloadButton)).click();
		//Verify pdf pop up
		obj2.verifyStickyCreatePDF(driver, softly);
		//Wait for loading message to disappear
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Verify download pop up
		obj2.verifyDownloadReportPopup(driver, softly);
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
		Thread.sleep(3000);
		//Switches to the iframe
		wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
	}

	public void shareReport(WebDriver driver,String username, String password1,int y ) throws Exception{

		WebDriverWait wait1 = new WebDriverWait(driver,30);
		ErrorMeter obj = new ErrorMeter();
		ShareCheck obj1 = new ShareCheck();
		EiRCA2 obj2 = new EiRCA2();
		String sharer = obj.decideSharer (y);
		String sharerAdded = obj.decideSharerAdded (y);	
		//Waits for the page to load
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
		obj1.shareTwice (driver,softly);
		//Clicks on save
		wait1.until(ExpectedConditions.visibilityOfElementLocated(ShareSaveButton)).click();
		//Verify share save sticky
		obj2.verifyStickyShareSave(driver, softly);
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
		EiRCA2 obj2 = new EiRCA2();
		//Clicks on mark critical
		wait1.until(ExpectedConditions.visibilityOfElementLocated(MarkCritical)).click();
		//Mark critical pop up
		obj2.verifyMarkCriticalPopup(driver, softly);
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
		//Un Mark critical pop up
		obj2.verifyUnMarkCriticalPopup(driver, softly);
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
		WebDriverWait wait1 = new WebDriverWait(driver,3);
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
		//Second listed event
		//Get date
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(Date2ndEvent)).getAttribute("value");
		//Get time
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(Time2ndEvent)).getAttribute("value");
		//Get what happened
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(WhatHappened2ndEvent)).getAttribute("value");
		//Get what is supposed to happen
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(WhatIsSupposedToHappen2ndEvent)).getAttribute("value");
		//Store in HashMap
		HashMap <String,String> hm = new HashMap<String,String>();
		hm.put("date1", s.replace("\u00AD", ""));
		hm.put("time1", s1.replace("\u00AD", ""));
		hm.put("what happened1", s2.replace("\u00AD", ""));
		hm.put("what is supposed to happen1", s3.replace("\u00AD", ""));	    	
		hm.put("date2", s4.replace("\u00AD", ""));
		hm.put("time2", s5.replace("\u00AD", ""));
		hm.put("what happened2", s6.replace("\u00AD", ""));
		hm.put("what is supposed to happen2", s7.replace("\u00AD", ""));	
		return hm;
	}

	public HashMap<String,String> verifyOrderOfEvents(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Get date from 1st row
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(Date1stEvent)).getAttribute("value");
		//Get date from 2nd row
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(Date2ndEvent)).getAttribute("value");
		//Get date from 3rd row
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(Date3rdEvent)).getAttribute("value");
		//Get time from 1st row
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(Time1stEvent)).getAttribute("value");
		//Get time from 2nd row
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(Time2ndEvent)).getAttribute("value");
		//Get time from 3rd row
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(Time3rdEvent)).getAttribute("value");
		//Store date and time in HashMap
		HashMap <String,String> hm = new HashMap<String,String>();
		hm.put("Date 1st row", s);
		hm.put("Date 2nd row", s1);
		hm.put("Date 3rd row", s4);
		hm.put("Time 1st row", s2);
		hm.put("Time 2nd row", s3);
		hm.put("Time 3rd row", s5);
		//Compare date and time
		String year1 = s.substring(0, 4);
		String year2 = s1.substring(0, 4);
		String year3 = s4.substring(0, 4);
		String month1 = s.substring(5, 7);
		String month2 = s1.substring(5, 7);
		String month3 = s4.substring(5, 7);
		String day1 = s.substring(8, 10);
		String day2 = s1.substring(8, 10);	
		String day3 = s4.substring(8, 10);
		String hour1 = s2.substring(0, 2);
		String hour2 = s3.substring(0, 2);
		String hour3 = s5.substring(0, 2);
		String minute1 = s2.substring(3, 5);
		String minute2 = s3.substring(3, 5);
		String minute3 = s5.substring(3, 5);
		//Verify order of 1st and 2nd event
		compareDateTime(year1,year2,month1,month2,day1,day2,hour1,hour2,minute1,minute2);
		//Verify order of 2nd and 3rd event
		compareDateTime(year2,year3,month2,month3,day2,day3,hour2,hour3,minute2,minute3);
		return hm;
	}

	public void compareDateTime (String year1, String year2, String month1, String month2, String day1, String day2, String hour1, String hour2, String minute1, String minute2) throws Exception {

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
	}

	public void changeDate(WebDriver driver, By CalendarIcon) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Click on calendar icon add event
		wait.until(ExpectedConditions.visibilityOfElementLocated(CalendarIcon)).click();
		//Click on - sign twice
		wait.until(ExpectedConditions.visibilityOfElementLocated(CalendarMinusSign)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(CalendarMinusSign)).click();
		//Select 1st date of 1st row
		wait.until(ExpectedConditions.visibilityOfElementLocated(Calendar1stRow1stDate)).click();
	}

	public void makeDateSame(WebDriver driver, By CalendarIcon) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Click on calendar icon on event
		wait.until(ExpectedConditions.visibilityOfElementLocated(CalendarIcon)).click();
		//Click on - sign once
		wait.until(ExpectedConditions.visibilityOfElementLocated(CalendarMinusSign)).click();
		//Select 1st date of 1st row
		wait.until(ExpectedConditions.visibilityOfElementLocated(Calendar1stRow1stDate)).click();	    	
	}

	public void changeTime(WebDriver driver, By ClockIcon) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Click on clock icon on 2nd event
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClockIcon)).click();
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

	public HashMap<String,String> pathEiRCASequenceOfEvents(WebDriver driver, String username) throws Exception {

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
		//Create another new event
		createNewEvent(driver, iter.next());
		//Verify the events are organised as per date and time
		HashMap<String,String> hm = verifyOrderOfEvents(driver);
		System.out.println(hm);
		//Change date on 2nd row
		changeDate(driver,CalendarIcon2ndEvent);
		Thread.sleep(1000);
		//Verify the events are organised as per date and time
		HashMap<String,String> hm1 = verifyOrderOfEvents(driver);
		System.out.println(hm1);
		//Verify changes have been saved
		verifyChangesSavedSequenceOfEvents(driver,hm1, username,0);
		//Change date on 3rd row
		changeDate(driver,CalendarIcon3rdEvent);
		Thread.sleep(1000);
		//Verify the events are organised as per date and time
		HashMap<String,String> hm4 = verifyOrderOfEvents(driver);
		System.out.println(hm4);
		//Verify changes have been saved
		verifyChangesSavedSequenceOfEvents(driver,hm4, username,1);
		//Make date same and change time on 3rd row
		makeDateSame(driver,CalendarIcon3rdEvent);
		Thread.sleep(1000);
		//Make date same and change time on 3rd row
		makeDateSame(driver,CalendarIcon3rdEvent);
		Thread.sleep(1000);
		//Make time different
		changeTime(driver,ClockIcon2ndEvent);
		Thread.sleep(1000);
		changeTime(driver,ClockIcon3rdEvent);
		Thread.sleep(1000);
		changeTime(driver,ClockIcon2ndEvent);
		Thread.sleep(1000);
		//Verify the events are organised as per date and time
		HashMap<String,String> hm2 = verifyOrderOfEvents(driver);
		System.out.println(hm2);
		//Verify changes have been saved
		verifyChangesSavedSequenceOfEvents(driver,hm2, username,1);
		//Delete 2nd event
		delete2ndEvent(driver);
		//Store all event data in hashmap
		HashMap<String,String>hm3 = storeEvent(driver);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(EiRCANextButton)).click();		
		return hm3;
	}

	public void verifyChangesSavedSequenceOfEvents(WebDriver driver, HashMap<String,String> hm1, String username, int n) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		ShareCheck obj = new ShareCheck();
		EiRCA2 obj1 = new EiRCA2();
		Thread.sleep(1000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(EiRCANextButton)).click();	
		Thread.sleep(1000);
		//Click on info page
		wait.until(ExpectedConditions.visibilityOfElementLocated(InfoTab)).click();	
		Thread.sleep(1000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(EiRCANextButton)).click();	
		//Verify the events are organised as per date and time
		HashMap<String,String> hm = verifyOrderOfEvents(driver);
		System.out.println(hm);
		Thread.sleep(1000);
		//boolean b = hm.entrySet().stream().filter(value -> hm1.entrySet().stream().anyMatch(value1 -> (value1.getKey() == value.getKey() && value1.getValue() == value.getValue()))).findAny().isPresent();
		boolean b = hm.equals(hm1);
		System.out.println(b);
		if(b==false)
			softly.fail("Changes did not get saved: \n"+hm1+"\n"+hm);
		//Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(EiRCASaveButton)).click();	
		//Save pop verify
		obj1.verifySavePopup(driver, softly);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EiRCAConfirmButton)).click();
		//Verify sticky save
		obj1.verifyStickySaveReport(driver, softly, username, textCreate(driver), n);
		obj.loadingServer(driver);
		obj.loadingServer(driver);
		Thread.sleep(1000);
		//Saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(EiRCASavedActivitiesButton)).click();	
		obj.loadingServer(driver);
		obj.loadingServer(driver);
		//Click on 1st record
		wait.until(ExpectedConditions.visibilityOfElementLocated(EiRCAFirstRecord)).click();
		obj.loadingServer(driver);
		//Verify the time and date of the sequence of events
		//Verify Sequence of Events title
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(SequenceOfEventPageDateTimeTitle1)).getText();
		softly.assertThat(s1).as("test data").isEqualTo(hm1.get("Date 1st row")+", "+hm1.get("Time 1st row"));    
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(SequenceOfEventPageDateTimeTitle2)).getText();
		softly.assertThat(s2).as("test data").isEqualTo(hm1.get("Date 2nd row")+", "+hm1.get("Time 2nd row"));    
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(SequenceOfEventPageDateTimeTitle3)).getText();
		softly.assertThat(s3).as("test data").isEqualTo(hm1.get("Date 3rd row")+", "+hm1.get("Time 3rd row"));    
		//Click on open button
		wait.until(ExpectedConditions.visibilityOfElementLocated(OpenButton)).click();	
		wait.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPopupButton)).click();
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(EiRCANextButton)).click();	
	}

	public void EIRCAStep1Troubleshooting(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
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
		//Verify extra ex box is appears and enter text in it
		detectAdditionalBoxStep1(driver);
		//Verify next button is visible after mandatory dropdowns are selected
		if(driver.findElement(EiRCANextButton).isDisplayed()==false)
			softly.fail("Next button not visible in Step 1 after selecting 1.1, 1.2, 1.3");
		//Fill text in 1.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(EiRCAStep1Q14AnswerTextBox)).sendKeys(textCreate(driver));
		//Fill text in 1.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(EiRCAStep1Q15AnswerTextBox)).sendKeys(textCreate(driver));
		//Fill text in 1.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(EiRCAStep1Q16AnswerTextBox)).sendKeys(textCreate(driver));
	}

	public void detectAdditionalBoxStep1(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Get 1.2 selected answer
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(EiRCAStep1Q12AnswerSelected)).getText();
		//Get 1.3 selected answer
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(EiRCAStep1Q13AnswerSelected)).getText();
		//1.2 extra box
		if(s.contains("Other MECHANICAL related components")||s.contains("Other ELECTRICAL related components"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(EiRCAStep1Q12AnswerTextBox)).sendKeys(textCreate(driver));
		}
		//1.3 extra box
		if(s1.contains("Other MECHANICAL related symptoms")||s1.contains("Other ELECTRICAL related symptoms"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(EiRCAStep1Q13AnswerTextBox)).sendKeys(textCreate(driver));
		}
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step2Row12ndTextBoxField)).sendKeys(textCreate(driver));
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
		//Fill text in Step 3
		fillTextStep3(driver);
		//n = 0;
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
			{
				//Click on check box for 3.1
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step3TableOption31CheckBox)).click();
			}
			if(i==2)
			{
				//Click on check box for 3.2
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step3TableOption32CheckBox)).click();
			}
			if(i==3)
			{
				//Click on check box for 3.3
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step3TableOption33CheckBox)).click();
			}
			if(i==4)
			{
				//Click on check box for 3.4
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step3TableOption34CheckBox)).click();
			}
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

	public void fillTextStep3(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		ShareCheck obj = new ShareCheck();
		//Fill in text in 3.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(Step3TableOption31Textbox)).sendKeys(textCreate(driver));
		//Fill in text in 3.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(Step3TableOption32Textbox)).sendKeys(textCreate(driver));
		//Fill in text in 3.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(Step3TableOption33Textbox)).sendKeys(textCreate(driver));
		//Fill in text in 3.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(Step3TableOption34Textbox)).sendKeys(textCreate(driver));
		Thread.sleep(500);
		jse.executeScript("scroll(0,1200)");
		Thread.sleep(500);
		//Fill in text in 3.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(Step3TableOption35Textbox)).sendKeys(textCreate(driver));
		//Fill in text in 3.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(Step3TableOption36Textbox)).sendKeys(textCreate(driver));
		//Scroll to the top
		Thread.sleep(500);
		obj.scrollToTop(driver);
		Thread.sleep(500);
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
		//Fill in text in 4.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(Step3TableOption44Textbox)).sendKeys(textCreate(driver));
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
		//Fill text in 5.5 and 5.6
		fillTextStep5(driver);
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

	public void fillTextStep5(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		EiRCAChinese obj = new EiRCAChinese();
		ShareCheck obj1 = new ShareCheck();
		WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step5TableOption56CheckBox));
		obj1.scrollToElement(driver, l);
		//Fill in text in 5.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(Step5TableOption55Textbox)).sendKeys(textCreate(driver));
		//Fill in text in 5.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(Step5TableOption56Textbox)).sendKeys(textCreate(driver));
		//Scroll to the top
		Thread.sleep(500);
		obj1.scrollToTop(driver);
		Thread.sleep(500);
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
		//Fill in text in 6.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(Step6TableOption65Textbox)).sendKeys(textCreate(driver));
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
	public String checkIfStep6Option65IsSelected(String key) throws Exception {

		if(key.contains("Culprit work activities"))
		{
			int n = key.indexOf(":");
			String s = key.substring(0, n);
			return s;
		}
		else return key;
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
				c.put(checkIfStep6Option65IsSelected(key), k);
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
				//Fill corrective action
				wait.until(ExpectedConditions.visibilityOfElementLocated(Step7SUEPTableRow2CorrectiveAction)).sendKeys(textCreate(driver));
			}
			if(i==2)
			{
				String key = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step7SUEPTableRow3)).getText();
				c.put(checkIfStep6Option65IsSelected(key), k);
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
				//Fill corrective action
				wait.until(ExpectedConditions.visibilityOfElementLocated(Step7SUEPTableRow3CorrectiveAction)).sendKeys(textCreate(driver));
			}
			if(i==3)
			{
				String key = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step7SUEPTableRow4)).getText();
				c.put(checkIfStep6Option65IsSelected(key), k);
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
				//Fill corrective action
				wait.until(ExpectedConditions.visibilityOfElementLocated(Step7SUEPTableRow4CorrectiveAction)).sendKeys(textCreate(driver));
			}
			if(i==4)
			{
				String key = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step7SUEPTableRow5)).getText();
				c.put(checkIfStep6Option65IsSelected(key), k);
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
				//Fill corrective action
				wait.until(ExpectedConditions.visibilityOfElementLocated(Step7SUEPTableRow5CorrectiveAction)).sendKeys(textCreate(driver));
			}
		}
		return c;
	}

	public String textCreate(WebDriver driver) throws Exception {

		if(driver.getCurrentUrl().contains("kaleqa"))
			return ("Sanity <div> Test \"title\" Sanity");
		else
			return("Sanity Test \"title\" Sanity");
	}

	public String textCreate1() throws Exception {

		return("Sanity Test");
	}

	public HashMap<String,String> reportCreate(WebDriver driver,String username) throws Exception {

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		EiRCAChinese obj = new EiRCAChinese();
		EiRCA2 obj1 = new EiRCA2();
		WebDriverWait wait1 = new WebDriverWait(driver,10);
		String text = textCreate(driver);
		//Clicks on EiRCA
		jse.executeScript("return document.getElementById('pii-a-menu-eirca').click();");
		Thread.sleep(1000);
		//Verify placeholder of problem statement
		verifyProbStatementPlaceHolder(driver);
		//Verify new report pop up
		obj1.verifyNewReportPopup(driver, softly);
		//Verify Error Messages for mandatory fields on Info page
		obj1.verifyErrorMessagesInfoPage(driver,softly);
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
		//Verify errors have disappeared
		obj1.verifyNoErrorsOnInfoPage(driver);
		//Sequence of Events
		HashMap<String,String>hm = pathEiRCASequenceOfEvents(driver,username);
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
		//Verify sticky save
		obj1.verifyStickySaveReport(driver, softly, username, text,1);
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
		hm.put("record name", r1);
		//Open HTML and verify Sequence of Events
		verifyHTML(driver,hm, text, n, x, y, z, s2, s, s1,c);
		return hm;
	}

	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}

}
