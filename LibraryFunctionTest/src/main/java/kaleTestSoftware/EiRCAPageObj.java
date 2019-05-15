package kaleTestSoftware;

import org.openqa.selenium.By;


public class EiRCAPageObj {

	//Buttons on HTML report page
	public By DeleteButton = By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[3]");
	public By OpenButton = By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[1]");
	public By DownloadButton = By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]");
	public By ShareButton = By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[4]");
	public By BackButton = By.id("pii-uhome-back");
	public By EiRCAShareIconOrCriticalIcon = By.xpath(".//*[@id='pii-user-home-activities-mirca']/ul/li[2]/a/span[1]");
	public By EiRCAShareIconWhenAlsoMarkedCritical = By.xpath(".//*[@id='pii-user-home-activities-mirca']/ul/li[2]/a/span[2]");

	//Share page
	public By ShareTextBox = By.id("pii-uhshare-search-input");
	public By ShareDropdown = By.xpath(".//*[@id='pii-uhshare-blocks']/div[2]/ul");
	public By FirstSelectionUnderDropdown = By.cssSelector(".ui-first-child");
	public By SharerAdded = By.xpath(".//*[@id='pii-uhshare-blocks']/div/form/div/ul/li/a");
	public By ShareSaveButton = By.id("pii-uhshare-save");

	public By EiRCASidePanel = By.id("pii-user-home-panel-btn-mirca");
	public By MarkCritical = By.xpath(".//*[@id='pii-user-home-activities-single']/div[2]/div/label");
	public By EiRCAMarkCriticalIndicatorText = By.xpath(".//*[@id='mirca-rpt']/div/table/thead/tr/th/strong");

	//Info page
	public By InfoTab = By.id("pii-ircam-tab-1-a");
	public By NextButtonBottomOfInfoPage = By.id("pii-ircam-tab-1-form-submit");
	public By ReportCreationDateField = By.id("pii-ircam-tab-1-repdatetime");
	public By EiRCASaveButton = By.id("pii-ircam-save");
	public By TitleCharacterCount = By.id("pii-ircam-tab-1-title-count");
	public By NewButton = By.id("pii-ircam-new");
	public By EventTitleError = By.id("pii-ircam-tab-1-title-error");
	public By EventLocationError = By.id("pii-ircam-tab-1-location-error");
	public By ProblemStatementError = By.id("pii-ircam-tab-1-problem-statement-error");
	public By FailedComponentError = By.id("pii-ircam-tab-1-failed-component-error");
	public By WhoDiscoveredError = By.id("pii-ircam-tab-1-who-error");
	public By InvestigatorError = By.id("pii-ircam-tab-1-investigators-error");
	public By ReviewerError = By.id("pii-ircam-tab-1-reviewer-error");
	public By SponsorError = By.id("pii-ircam-tab-1-management-sponsor-error");

	//Save pop up
	public By EiRCAPopupHeader = By.id("pii-ircam-dialog-header");
	public By EiRCAPopupTitle = By.id("pii-ircam-dialog-title");
	public By EiRCAPopupConfirmButton = By.id("pii-ircam-dialog-confirmed");
	public By EiRCAPopUpMessageNote = By.id("pii-ircam-dialog-note");
	public By EiRCAPopupCancelButton = By.id("pii-ircam-dialog-cancel");
	public By EiRCANextButton = By.id("pii-ircam-next");
	public By EiRCASavedActivitiesButton = By.id("pii-ircam-savedactivities");

	//Report pop up on HTML page
	public By ConfirmPopupHeader = By.id("pii-user-home-dialog-header");
	public By ConfirmPopupNote = By.id("pii-user-home-dialog-note");
	public By ConfirmPopupTitle = By.id("pii-user-home-dialog-title");
	public By ConfirmPopupButton = By.id("pii-user-home-dialog-confirmed");
	public By ConfirmCancelButton = By.id("pii-user-home-dialog-cancel");

	public By EiRCAFirstRecord = By.xpath(".//*[@id='pii-user-home-activities-mirca']/ul/li[2]/a");
	public By StickyNote = By.className("sticky-note");
	public By StickySuccess = By.className("sticky-success");
	public By StickyClose = By.className("sticky-close");

	//Sequence of Events in HTML
	public By SequenceOfEventPageTitle = By.xpath(".//*[@id='mirca-rpt']/div[5]/div");
	public By SequenceOfEventPageDateTimeTitle1 = By.xpath(".//*[@id='mirca-rpt']/div[5]/table/tbody/tr[1]/td[1]");
	public By SequenceOfEventPageWhatHappenedTitle1 = By.xpath(".//*[@id='mirca-rpt']/div[5]/table/tbody/tr[1]/td[2]");
	public By SequenceOfEventPageWhatShouldHappenTitle1 = By.xpath(".//*[@id='mirca-rpt']/div[5]/table/tbody/tr[1]/td[3]");
	public By SequenceOfEventPageDateTimeTitle2 = By.xpath(".//*[@id='mirca-rpt']/div[5]/table/tbody/tr[2]/td[1]");
	public By SequenceOfEventPageWhatHappenedTitle2 = By.xpath(".//*[@id='mirca-rpt']/div[5]/table/tbody/tr[2]/td[2]");
	public By SequenceOfEventPageWhatShouldHappenTitle2 = By.xpath(".//*[@id='mirca-rpt']/div[5]/table/tbody/tr[2]/td[3]");
	public By SequenceOfEventPageDateTimeTitle3 = By.xpath(".//*[@id='mirca-rpt']/div[5]/table/tbody/tr[3]/td[1]");

	//Sequence of Events page
	public By DescriptionPlusSign = By.xpath(".//*[@id='pii-ircam-tab-1-description']/h4/a");
	public By DescriptionText = By.id("pii-ircam-tab-1-description-text");
	public By DateHeader = By.xpath(".//*[@id='pii-ircam-tab-1-events']/div/div[1]/div[1]");
	public By TimeHeader = By.xpath(".//*[@id='pii-ircam-tab-1-events']/div/div[2]/div[1]");
	public By WhatHappenedHeader = By.xpath(".//*[@id='pii-ircam-tab-1-events']/div/div[3]/div[1]");
	public By WhatIsSupposedToHappenHeader = By.xpath(".//*[@id='pii-ircam-tab-1-events']/div/div[4]/div[1]");
	public By WhatHappenedField = By.id("pii-ircam-newevent-descr");
	public By WhatIsSupposedToHappenField = By.id("pii-ircam-newevent-trigevt");
	public By EventAddSign = By.id("pii-ircam-newevent-add");
	public By DateField = By.id("pii-ircam-tab-1-newevent-date");
	public By TimeField = By.id("pii-ircam-tab-1-newevent-time");
	public By Date1stEvent = By.xpath(".//*[@id='pii-ircam-events-table']/tbody/tr[1]/td[2]/div/div/input");
	public By Time1stEvent = By.xpath(".//*[@id='pii-ircam-events-table']/tbody/tr[1]/td[3]/div/div/input");
	public By WhatHappened1stEvent = By.xpath(".//*[@id='pii-ircam-events-table']/tbody/tr[1]/td[4]/textarea");
	public By WhatIsSupposedToHappen1stEvent = By.xpath(".//*[@id='pii-ircam-events-table']/tbody/tr[1]/td[5]/textarea");
	public By Date2ndEvent = By.xpath(".//*[@id='pii-ircam-events-table']/tbody/tr[2]/td[2]/div/div/input");
	public By Time2ndEvent = By.xpath(".//*[@id='pii-ircam-events-table']/tbody/tr[2]/td[3]/div/div/input");
	public By WhatHappened2ndEvent = By.xpath(".//*[@id='pii-ircam-events-table']/tbody/tr[2]/td[4]/textarea");
	public By WhatIsSupposedToHappen2ndEvent = By.xpath(".//*[@id='pii-ircam-events-table']/tbody/tr[2]/td[5]/textarea");
	public By DeleteSign2ndEvent = By.xpath(".//*[@id='pii-ircam-events-table']/tbody/tr[2]/td[6]/a");
	public By CalendarIcon2ndEvent = By.xpath(".//*[@id='pii-ircam-events-table']/tbody/tr[2]/td[2]/div/div/a");
	public By ClockIcon2ndEvent = By.xpath(".//*[@id='pii-ircam-events-table']/tbody/tr[2]/td[3]/div/div/a");
	public By CalendarIconAddEvent = By.xpath(".//*[@id='pii-ircam-tab-1-events']/div/div[1]/div[2]/div/div/a");
	public By CalendarMinusSign = By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div/div/a");
	public By Calendar1stRow1stDate = By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div[2]/div[2]/div");
	public By ClockIconAddEvent = By.xpath(".//*[@id='pii-ircam-tab-1-events']/div/div[2]/div[2]/div/div/a");
	public By ClockSetTime = By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div[2]/div/a");
	public By ClockTimeHourField = By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div/div/div[2]/input");
	public By ClockHourMinusSign = By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div/div/div[3]");
	public By Date3rdEvent = By.xpath(".//*[@id='pii-ircam-events-table']/tbody/tr[3]/td[2]/div/div/input");
	public By Time3rdEvent = By.xpath(".//*[@id='pii-ircam-events-table']/tbody/tr[3]/td[3]/div/div/input");
	public By CalendarIcon3rdEvent = By.xpath(".//*[@id='pii-ircam-events-table']/tbody/tr[3]/td[2]/div/div/a");
	public By ClockIcon3rdEvent = By.xpath(".//*[@id='pii-ircam-events-table']/tbody/tr[3]/td[3]/div/div/a");
	//Table headers
	public By TableDateHeader = By.xpath(".//*[@id='pii-ircam-events-table']/thead/tr[1]/th[2]");
	public By TableTimeHeader = By.xpath(".//*[@id='pii-ircam-events-table']/thead/tr[1]/th[3]");
	public By TableWhatHappenedHeader = By.xpath(".//*[@id='pii-ircam-events-table']/thead/tr[1]/th[4]");
	public By TableWhatIsSupposedToHappenHeader = By.xpath(".//*[@id='pii-ircam-events-table']/thead/tr[1]/th[5]");
	//First Sequence of event
	public By ClockSignTime1stEvent = By.xpath(".//*[@id='pii-ircam-events-table']/tbody/tr[1]/td[3]/div/div/a");
	public By CalenderSignTime1stEvent = By.xpath(".//*[@id='pii-ircam-events-table']/tbody/tr[1]/td[2]/div/div/a");
	public By CalendarPlusSign = By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div/div[2]/a");

	//Step 1
	public By EiRCAStep1Q11AnswerSelected = By.xpath(".//*[@id='pii-ircam-tab-2']/div[4]/div/span");
	public By EiRCAStep1Q12AnswerSelected = By.xpath(".//*[@id='pii-ircam-tab-2']/div[6]/div/span");
	public By EiRCAStep1Q13AnswerSelected = By.xpath(".//*[@id='pii-ircam-tab-2']/div[9]/div/span");
	public By EiRCAStep1Q14AnswerTextBox = By.xpath(".//*[@id='pii-ircam-tab-2']/textarea[1]");
	public By EiRCAStep1Q15AnswerTextBox = By.xpath(".//*[@id='pii-ircam-tab-2']/textarea[2]");
	public By EiRCAStep1Q16AnswerTextBox = By.xpath(".//*[@id='pii-ircam-tab-2']/textarea[3]");
	public By EiRCAStep1Q12AnswerTextBox = By.xpath(".//*[@id='pii-ircam-1-2-other-div']/div/input");
	public By EiRCAStep1Q13AnswerTextBox = By.xpath(".//*[@id='pii-ircam-1-3-other-div']/div/input");
	public By EiRCAStep1Tab = By.id("pii-ircam-tab-2-a");

	//Step 2
	public By EiRCAStep2Tab = By.id("pii-ircam-tab-3-a");

	//Step 3
	public By Step3FailureCollapsibleFailureMode2 = By.xpath(".//*[@id='pii-ircam-tab-4']/div[4]");
	public By Step3TableOption31CheckBoxFM2 = By.xpath(".//*[@id='pii-ircam-tab-4']/div[4]/div/table/tbody/tr[1]/td[2]/div/input");
	public By Step3TableOption31Textbox = By.xpath(".//*[@id='pii-ircam-tab-4']/div[3]/div/table/tbody/tr[1]/td[4]/textarea");
	public By Step3TableOption32Textbox = By.xpath(".//*[@id='pii-ircam-tab-4']/div[3]/div/table/tbody/tr[2]/td[4]/textarea");
	public By Step3TableOption33Textbox = By.xpath(".//*[@id='pii-ircam-tab-4']/div[3]/div/table/tbody/tr[3]/td[4]/textarea");
	public By Step3TableOption34Textbox = By.xpath(".//*[@id='pii-ircam-tab-4']/div[3]/div/table/tbody/tr[4]/td[4]/textarea");
	public By Step3TableOption35Textbox = By.xpath(".//*[@id='pii-ircam-tab-4']/div[3]/div/table/tbody/tr[5]/td[4]/textarea");
	public By Step3TableOption36Textbox = By.xpath(".//*[@id='pii-ircam-tab-4']/div[3]/div/table/tbody/tr[6]/td[4]/textarea");
	public By EiRCAStep3Tab = By.id("pii-ircam-tab-4-a");

	//Step 4
	public By Step4FailureMode1Option42CheckBox = By.xpath(".//*[@id='pii-ircam-tab-5']/div[3]/div/table/tbody/tr[2]/td[2]/div/input");
	public By Step4FailureMode1Option43CheckBox = By.xpath(".//*[@id='pii-ircam-tab-5']/div[3]/div/table/tbody/tr[3]/td[2]/div/input");
	public By Step4FailureMode1Option44CheckBox = By.xpath(".//*[@id='pii-ircam-tab-5']/div[3]/div/table/tbody/tr[4]/td[2]/div/input");
	public By Step4FailureMode1Option45CheckBox = By.xpath(".//*[@id='pii-ircam-tab-5']/div[3]/div/table/tbody/tr[5]/td[2]/div/input");
	public By Step4FailureMode1Option46CheckBox = By.xpath(".//*[@id='pii-ircam-tab-5']/div[3]/div/table/tbody/tr[6]/td[2]/div/input");
	public By Step4FailureMode1Option47CheckBox = By.xpath(".//*[@id='pii-ircam-tab-5']/div[3]/div/table/tbody/tr[7]/td[2]/div/input");
	public By Step4FailureMode1Option44TextBox = By.xpath(".//*[@id='pii-ircam-tab-5']/div[3]/div/table/tbody/tr[4]/td[3]/textarea");
	public By Step4FailureCollapsibleFailureMode2 = By.xpath(".//*[@id='pii-ircam-tab-5']/div[4]/h4/a");
	public By Step4FailureMode2Option41CheckBox = By.xpath(".//*[@id='pii-ircam-tab-5']/div[4]/div/table/tbody/tr[1]/td[2]/div/input");
	public By Step4FailureMode2Option42CheckBox = By.xpath(".//*[@id='pii-ircam-tab-5']/div[4]/div/table/tbody/tr[2]/td[2]/div/input");
	public By Step4FailureMode2Option43CheckBox = By.xpath(".//*[@id='pii-ircam-tab-5']/div[4]/div/table/tbody/tr[3]/td[2]/div/input");
	public By Step4FailureMode2Option44CheckBox = By.xpath(".//*[@id='pii-ircam-tab-5']/div[4]/div/table/tbody/tr[4]/td[2]/div/input");
	public By Step4FailureMode2Option45CheckBox = By.xpath(".//*[@id='pii-ircam-tab-5']/div[4]/div/table/tbody/tr[5]/td[2]/div/input");
	public By Step4FailureMode2Option46CheckBox = By.xpath(".//*[@id='pii-ircam-tab-5']/div[4]/div/table/tbody/tr[6]/td[2]/div/input");
	public By Step4FailureMode2Option47CheckBox = By.xpath(".//*[@id='pii-ircam-tab-5']/div[4]/div/table/tbody/tr[7]/td[2]/div/input");
	public By Step4FailureMode2Option44TextBox = By.xpath(".//*[@id='pii-ircam-tab-5']/div[4]/div/table/tbody/tr[4]/td[3]/textarea");
	public By Step4FailureMode1Option44Row = By.xpath(".//*[@id='pii-ircam-tab-5']/div[3]/div/table/tbody/tr[4]");
	public By Step4FailureMode2Option44Row = By.xpath(".//*[@id='pii-ircam-tab-5']/div[4]/div/table/tbody/tr[4]");
	public By Step4FailureModeOption44Textbox = By.xpath(".//*[@id='pii-ircam-tab-5']/div[3]/div/table/tbody/tr[1]/td[3]/textarea");	
	public By EiRCAStep4Tab = By.id("pii-ircam-tab-5-a");

	//Step 5
	public By Step5TableOption55Textbox = By.xpath(".//*[@id='pii-ircam-tab-6']/div[3]/div/table[9]/tbody/tr[1]/td[3]/textarea");
	public By Step5TableOption56Textbox = By.xpath(".//*[@id='pii-ircam-tab-6']/div[3]/div/table[9]/tbody/tr[2]/td[3]/textarea");
	public By EiRCAStep5Tab = By.id("pii-ircam-tab-6-a");

	//Step 6
	public By Step6TableOption65Textbox = By.xpath(".//*[@id='pii-ircam-tab-7']/div[3]/div/table/tbody/tr[5]/td[3]/textarea");
	public By EiRCAStep6Tab = By.id("pii-ircam-tab-7-a");

	//Step 7
	public By Step7SUEPTableRow2CorrectiveAction = By.xpath(".//*[@id='pii-ircam-tab-8']/div[7]/table/tbody/tr[2]/td[6]/textarea");
	public By Step7SUEPTableRow3CorrectiveAction = By.xpath(".//*[@id='pii-ircam-tab-8']/div[7]/table/tbody/tr[3]/td[6]/textarea");
	public By Step7SUEPTableRow4CorrectiveAction = By.xpath(".//*[@id='pii-ircam-tab-8']/div[7]/table/tbody/tr[4]/td[6]/textarea");
	public By Step7SUEPTableRow5CorrectiveAction = By.xpath(".//*[@id='pii-ircam-tab-8']/div[7]/table/tbody/tr[5]/td[6]/textarea");

	//Report Tab
	//Table 1
	public By ReportTabTable1EventTitle = By.xpath(".//*[@id='pii-ircam-tab-9']/div[1]/table/tbody/tr[1]/td[2]");
	public By ReportTabTable1LocationOfEvent = By.xpath(".//*[@id='pii-ircam-tab-9']/div[1]/table/tbody/tr[3]/td[2]");
	public By ReportTabTable1WhoDiscovered = By.xpath(".//*[@id='pii-ircam-tab-9']/div[1]/table/tbody/tr[5]/td[2]");
	public By ReportTabTable1Investigators = By.xpath(".//*[@id='pii-ircam-tab-9']/div[1]/table/tbody/tr[8]/td[2]");
	public By ReportTabTable1Reviewers = By.xpath(".//*[@id='pii-ircam-tab-9']/div[1]/table/tbody/tr[9]/td[2]");
	public By ReportTabTable1ManagementSponsors = By.xpath(".//*[@id='pii-ircam-tab-9']/div[1]/table/tbody/tr[10]/td[2]");
	public By ReportTabTable1ProblemStatement = By.xpath(".//*[@id='pii-ircam-tab-9']/div[1]/table/tbody/tr[11]/td[2]");
	public By ReportTabTable1SuspectedFailedComponent = By.xpath(".//*[@id='pii-ircam-tab-9']/div[1]/table/tbody/tr[12]/td[2]");
	
	//HTML
	//Table 1
	public By HTMLTable1EventTitle = By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[1]/td[2]");
	public By HTMLTable1LocationOfEvent = By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[3]/td[2]");
	public By HTMLTable1WhoDiscovered = By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[5]/td[2]");
	public By HTMLTable1Investigators = By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[8]/td[2]");
	public By HTMLTable1Reviewers = By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[9]/td[2]");
	public By HTMLTable1ManagementSponsors = By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[10]/td[2]");
	public By HTMLTable1ProblemStatement = By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[11]/td[2]");
	public By HTMLTable1SuspectedFailedComponent = By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[12]/td[2]");
	//Step 3
	public By HTMLTable7Step3Row1Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[1]/td[2]");
	public By HTMLTable7Step3Row1Column3 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[1]/td[3]");
	public By HTMLTable7Step3Row2Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[2]/td[2]");
	public By HTMLTable7Step3Row2Column3 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[2]/td[3]");
	public By HTMLTable7Step3Row3Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[3]/td[2]");
	public By HTMLTable7Step3Row3Column3 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[3]/td[3]");
	public By HTMLTable7Step3Row4Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[4]/td[2]");
	public By HTMLTable7Step3Row4Column3 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[4]/td[3]");
	public By HTMLTable7Step3Row5Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[5]/td[2]");
	public By HTMLTable7Step3Row5Column3 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[5]/td[3]");
	public By HTMLTable7Step3Row6Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[6]/td[2]");
	public By HTMLTable7Step3Row6Column3 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[6]/td[3]");
	public By HTMLTable7Step3Row1Column4 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[1]/td[4]");
	public By HTMLTable7Step3Row2Column4 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[2]/td[4]");
	public By HTMLTable7Step3Row3Column4 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[3]/td[4]");
	public By HTMLTable7Step3Row4Column4 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[4]/td[4]");
	public By HTMLTable7Step3Row5Column4 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[5]/td[4]");
	public By HTMLTable7Step3Row6Column4 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[6]/td[4]");
	//Step1 Table 4
	public By HTMLTable4Step1Q11 = By.xpath(".//*[@id='mirca-rpt']/div[6]/table/tbody/tr[1]/td[2]");
	public By HTMLTable4Step1Q12 = By.xpath(".//*[@id='mirca-rpt']/div[6]/table/tbody/tr[2]/td[2]");
	public By HTMLTable4Step1Q13 = By.xpath(".//*[@id='mirca-rpt']/div[6]/table/tbody/tr[3]/td[2]");
	public By HTMLTable4Step1Q14 = By.xpath(".//*[@id='mirca-rpt']/div[6]/table/tbody/tr[4]/td[2]");
	public By HTMLTable4Step1Q15 = By.xpath(".//*[@id='mirca-rpt']/div[6]/table/tbody/tr[5]/td[2]");
	public By HTMLTable4Step1Q16 = By.xpath(".//*[@id='mirca-rpt']/div[6]/table/tbody/tr[6]/td[2]");
	//Step 2
	public By HTMLTable5Step2Row1Column1 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/table/tbody/tr[1]/td[1]");
	public By HTMLTable5Step2Row2Column1 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/table/tbody/tr[2]/td[1]");
	public By HTMLTable5Step2Row1Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/table/tbody/tr[1]/td[2]");
	//Step 4
	public By HTMLStep4Table1Row1Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[3]/table/tbody/tr[1]/td[2]");
	public By HTMLStep4Table1Row2Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[3]/table/tbody/tr[2]/td[2]");
	public By HTMLStep4Table1Row3Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[3]/table/tbody/tr[3]/td[2]");
	public By HTMLStep4Table1Row4Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[3]/table/tbody/tr[4]/td[2]");
	public By HTMLStep4Table1Row4Column3 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[3]/table/tbody/tr[4]/td[3]");
	public By HTMLStep4Table1Row5Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[3]/table/tbody/tr[5]/td[2]");
	public By HTMLStep4Table1Row6Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[3]/table/tbody/tr[6]/td[2]");
	public By HTMLStep4Table1Row7Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[3]/table/tbody/tr[7]/td[2]");
	public By HTMLStep4Table2Row1Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[4]/table/tbody/tr[1]/td[2]");
	public By HTMLStep4Table2Row2Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[4]/table/tbody/tr[2]/td[2]");
	public By HTMLStep4Table2Row3Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[4]/table/tbody/tr[3]/td[2]");
	public By HTMLStep4Table2Row4Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[4]/table/tbody/tr[4]/td[2]");
	public By HTMLStep4Table2Row5Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[4]/table/tbody/tr[5]/td[2]");
	public By HTMLStep4Table2Row6Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[4]/table/tbody/tr[6]/td[2]");
	public By HTMLStep4Table2Row7Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[4]/table/tbody/tr[7]/td[2]");
	//Step 3 skipped
	public By HTMLTable7Step3Skipped = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]");
	//Skipped steps 4,5,6,7
	public By HTMLStep4SkippedRCA = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]");
	public By HTMLStep4SkippedRCA2 = By.xpath(".//*[@id='mirca-rpt']/div[8]");
	public By HTMLStep4SkippedTr = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]");
	public By HTMLStep4SkippedTr1 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[2]");
	public By HTMLStep5Skipped = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]");
	public By HTMLStep5Skipped2 = By.xpath(".//*[@id='mirca-rpt']/div[9]");
	public By HTMLStep5Skipped3 = By.xpath(".//*[@id='mirca-rpt']/div[8]");
	public By HTMLStep6Skipped = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[6]");
	public By HTMLStep6Skipped2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[3]");
	public By HTMLStep6Skipped3 = By.xpath(".//*[@id='mirca-rpt']/div[10]");
	public By HTMLStep7Skipped = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]");
	public By HTMLStep7Skipped2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]");
	public By HTMLStep7Skipped3 = By.xpath(".//*[@id='mirca-rpt']/div[11]");
	//Step 5
	public By HTMLTable14Step5Row1Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[2]/div[7]/table/tbody/tr[1]/td[2]");
	public By HTMLTable14Step5Row2Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[2]/div[8]/table/tbody/tr[1]/td[2]");
	public By HTMLTable14Step5Row1Column3 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[2]/div[7]/table/tbody/tr[1]/td[3]");
	public By HTMLTable14Step5Row2Column3 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[2]/div[8]/table/tbody/tr[1]/td[3]");
	public By HTMLTable14Step5Row1Column2a = By.xpath(".//*[@id='mirca-rpt']/div[8]/div[2]/div[7]/table/tbody/tr[1]/td[2]");
	public By HTMLTable14Step5Row2Column2a = By.xpath(".//*[@id='mirca-rpt']/div[8]/div[2]/div[8]/table/tbody/tr[1]/td[2]");
	public By HTMLTable14Step5Row1Column3a = By.xpath(".//*[@id='mirca-rpt']/div[8]/div[2]/div[7]/table/tbody/tr[1]/td[3]");
	public By HTMLTable14Step5Row2Column3a = By.xpath(".//*[@id='mirca-rpt']/div[8]/div[2]/div[8]/table/tbody/tr[1]/td[3]");
	//Step 6
	public By HTMLStep6Row5Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[3]/div[2]/table/tbody/tr[5]/td[2]");
	public By HTMLStep6Row6Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[3]/div[2]/table/tbody/tr[6]/td[2]");
	public By HTMLStep6Row7Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[3]/div[2]/table/tbody/tr[7]/td[2]");
	public By HTMLStep6Row8Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[3]/div[2]/table/tbody/tr[8]/td[2]");
	public By HTMLStep6Row5Column3 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[3]/div[2]/table/tbody/tr[5]/td[3]");
	public By HTMLStep6Row5Column2a = By.xpath(".//*[@id='mirca-rpt']/div[8]/div[3]/div[2]/table/tbody/tr[5]/td[2]");
	public By HTMLStep6Row6Column2a = By.xpath(".//*[@id='mirca-rpt']/div[8]/div[3]/div[2]/table/tbody/tr[6]/td[2]");
	public By HTMLStep6Row7Column2a = By.xpath(".//*[@id='mirca-rpt']/div[8]/div[3]/div[2]/table/tbody/tr[7]/td[2]");
	public By HTMLStep6Row8Column2a = By.xpath(".//*[@id='mirca-rpt']/div[8]/div[3]/div[2]/table/tbody/tr[8]/td[2]");
	public By HTMLStep6Row5Column3a = By.xpath(".//*[@id='mirca-rpt']/div[8]/div[3]/div[2]/table/tbody/tr[5]/td[3]");
	//Step 7
	public By HTMLStep7Row2Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[2]/td[2]");
	public By HTMLStep7Row2Column3 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[2]/td[3]");
	public By HTMLStep7Row2Column4 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[2]/td[4]");
	public By HTMLStep7Row2Column5 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[2]/td[5]");
	public By HTMLStep7Row3Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[3]/td[2]");
	public By HTMLStep7Row3Column3 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[3]/td[3]");
	public By HTMLStep7Row3Column4 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[3]/td[4]");
	public By HTMLStep7Row3Column5 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[3]/td[5]");
	public By HTMLStep7Row4Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[4]/td[2]");
	public By HTMLStep7Row4Column3 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[4]/td[3]");
	public By HTMLStep7Row4Column4 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[4]/td[4]");
	public By HTMLStep7Row4Column5 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[4]/td[5]");
	public By HTMLStep7Row5Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[5]/td[2]");
	public By HTMLStep7Row5Column3 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[5]/td[3]");
	public By HTMLStep7Row5Column4 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[5]/td[4]");
	public By HTMLStep7Row5Column5 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[5]/td[5]");
	public By HTMLStep7Row2Column6 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[2]/td[6]");
	public By HTMLStep7Row3Column6 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[3]/td[6]");
	public By HTMLStep7Row4Column6 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[4]/td[6]");
	public By HTMLStep7Row5Column6 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[5]/td[6]");
	public By HTMLStep7Row2Column2a = By.xpath(".//*[@id='mirca-rpt']/div[8]/div[4]/div[6]/table/tbody/tr[2]/td[2]");
	public By HTMLStep7Row2Column3a = By.xpath(".//*[@id='mirca-rpt']/div[8]/div[4]/div[6]/table/tbody/tr[2]/td[3]");
	public By HTMLStep7Row2Column4a = By.xpath(".//*[@id='mirca-rpt']/div[8]/div[4]/div[6]/table/tbody/tr[2]/td[4]");
	public By HTMLStep7Row2Column5a = By.xpath(".//*[@id='mirca-rpt']/div[8]/div[4]/div[6]/table/tbody/tr[2]/td[5]");
	public By HTMLStep7Row3Column2a = By.xpath(".//*[@id='mirca-rpt']/div[8]/div[4]/div[6]/table/tbody/tr[3]/td[2]");
	public By HTMLStep7Row3Column3a = By.xpath(".//*[@id='mirca-rpt']/div[8]/div[4]/div[6]/table/tbody/tr[3]/td[3]");
	public By HTMLStep7Row3Column4a = By.xpath(".//*[@id='mirca-rpt']/div[8]/div[4]/div[6]/table/tbody/tr[3]/td[4]");
	public By HTMLStep7Row3Column5a = By.xpath(".//*[@id='mirca-rpt']/div[8]/div[4]/div[6]/table/tbody/tr[3]/td[5]");
	public By HTMLStep7Row4Column2a = By.xpath(".//*[@id='mirca-rpt']/div[8]/div[4]/div[6]/table/tbody/tr[4]/td[2]");
	public By HTMLStep7Row4Column3a = By.xpath(".//*[@id='mirca-rpt']/div[8]/div[4]/div[6]/table/tbody/tr[4]/td[3]");
	public By HTMLStep7Row4Column4a = By.xpath(".//*[@id='mirca-rpt']/div[8]/div[4]/div[6]/table/tbody/tr[4]/td[4]");
	public By HTMLStep7Row4Column5a = By.xpath(".//*[@id='mirca-rpt']/div[8]/div[4]/div[6]/table/tbody/tr[4]/td[5]");
	public By HTMLStep7Row5Column2a = By.xpath(".//*[@id='mirca-rpt']/div[8]/div[4]/div[6]/table/tbody/tr[5]/td[2]");
	public By HTMLStep7Row5Column3a = By.xpath(".//*[@id='mirca-rpt']/div[8]/div[4]/div[6]/table/tbody/tr[5]/td[3]");
	public By HTMLStep7Row5Column4a = By.xpath(".//*[@id='mirca-rpt']/div[8]/div[4]/div[6]/table/tbody/tr[5]/td[4]");
	public By HTMLStep7Row5Column5a = By.xpath(".//*[@id='mirca-rpt']/div[8]/div[4]/div[6]/table/tbody/tr[5]/td[5]");
	public By HTMLStep7Row2Column6a = By.xpath(".//*[@id='mirca-rpt']/div[8]/div[4]/div[6]/table/tbody/tr[2]/td[6]");
	public By HTMLStep7Row3Column6a = By.xpath(".//*[@id='mirca-rpt']/div[8]/div[4]/div[6]/table/tbody/tr[3]/td[6]");
	public By HTMLStep7Row4Column6a = By.xpath(".//*[@id='mirca-rpt']/div[8]/div[4]/div[6]/table/tbody/tr[4]/td[6]");
	public By HTMLStep7Row5Column6a = By.xpath(".//*[@id='mirca-rpt']/div[8]/div[4]/div[6]/table/tbody/tr[5]/td[6]");
	//RCA
	public By HTMLStep7Row2Column2RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[2]/td[2]");
	public By HTMLStep7Row2Column3RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[2]/td[3]");
	public By HTMLStep7Row2Column4RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[2]/td[4]");
	public By HTMLStep7Row2Column5RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[2]/td[5]");
	public By HTMLStep7Row3Column2RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[3]/td[2]");
	public By HTMLStep7Row3Column3RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[3]/td[3]");
	public By HTMLStep7Row3Column4RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[3]/td[4]");
	public By HTMLStep7Row3Column5RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[3]/td[5]");
	public By HTMLStep7Row4Column2RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[4]/td[2]");
	public By HTMLStep7Row4Column3RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[4]/td[3]");
	public By HTMLStep7Row4Column4RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[4]/td[4]");
	public By HTMLStep7Row4Column5RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[4]/td[5]");
	public By HTMLStep7Row5Column2RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[5]/td[2]");
	public By HTMLStep7Row5Column3RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[5]/td[3]");
	public By HTMLStep7Row5Column4RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[5]/td[4]");
	public By HTMLStep7Row5Column5RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/div[6]/table/tbody/tr[5]/td[5]");
	public By HTMLStep7Row2Column6RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[2]/td[6]");
	public By HTMLStep7Row3Column6RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[3]/td[6]");
	public By HTMLStep7Row4Column6RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[4]/td[6]");
	public By HTMLStep7Row5Column6RC = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]/div[4]/div[6]/table/tbody/tr[5]/td[6]");
	

	//Main module links
	public By EiRCALink = By.id("pii-a-menu-eirca");
	public By AnalysisLink = By.id("pii-main-menu-button-a");
	public By KALEHomePage = By.className("pii-logo-div-element-kale");

	//Info page
	public By EiRCAInfoPageTitle = By.id("pii-ircam-tab-1-pagetitle");
	public By EiRCAInfoPageDesc = By.id("pii-ircam-tab-1-help");
	public By EiRCAEventTitleLabel = By.id("pii-ircam-tab-1-title-label");
	public By EiRCAEventTitleField = By.id("pii-ircam-tab-1-title");
	public By EiRCAEventIdLabel = By.id("pii-ircam-tab-1-id-label");
	public By EiRCAEventIdField = By.id("pii-ircam-tab-1-id");
	public By EiRCAEventLocationLabel = By.id("pii-ircam-tab-1-location-label");
	public By EiRCAEventLocationField = By.id("pii-ircam-tab-1-location");
	public By EiRCAEventFailureDateLabel = By.id("pii-ircam-tab-1-failure-date-label");
	public By EiRCAEventProblemStatementLabel = By.id("pii-ircam-tab-1-problem-statement-label");
	public By EiRCAEventProblemStatementField = By.id("pii-ircam-tab-1-problem-statement");
	public By EiRCAEventComponentLabel = By.id("pii-ircam-tab-1-failed-component-label");
	public By EiRCAEventComponentField = By.id("pii-ircam-tab-1-failed-component");
	public By EiRCAEventDiscoveryDateLabel = By.id("pii-ircam-tab-1-discovery-date-label");
	public By EiRCAEventReporterLabel = By.id("pii-ircam-tab-1-who-label");
	public By EiRCAEventReporterField = By.id("pii-ircam-tab-1-who");
	public By EiRCAEventInitiatedDateLabel = By.id("pii-ircam-tab-1-initiation-date-label");
	public By EiRCAEventInvestigatorLabel = By.id("pii-ircam-tab-1-investigators-label");
	public By EiRCAEventInvestigatorField = By.id("pii-ircam-tab-1-investigators");
	public By EiRCAEventReviewerLabel = By.id("pii-ircam-tab-1-reviewer-label");
	public By EiRCAEventReviewerField = By.id("pii-ircam-tab-1-reviewer");
	public By EiRCAEventSponsorLabel = By.id("pii-ircam-tab-1-management-sponsor-label");
	public By EiRCAEventSponsorField = By.id("pii-ircam-tab-1-management-sponsor");
	public By EiRCAEventReportDateLabel = By.id("pii-ircam-tab-1-repdatetime-label");

	//Step 1
	public By Step1Title = By.xpath(".//*[@id='pii-ircam-tab-2']/div[1]");
	public By Step1TextUnderTitle = By.xpath(".//*[@id='pii-ircam-tab-2']/div[2]");
	public By Step1Q11 = By.xpath(".//*[@id='pii-ircam-tab-2']/div[3]");
	public By Step1Q12 = By.xpath(".//*[@id='pii-ircam-tab-2']/div[5]");
	public By Step1Q13 = By.xpath(".//*[@id='pii-ircam-tab-2']/div[8]");
	public By Step1Q14 = By.xpath(".//*[@id='pii-ircam-tab-2']/div[11]");
	public By Step1Q15 = By.xpath(".//*[@id='pii-ircam-tab-2']/div[12]");
	public By Step1Q16 = By.xpath(".//*[@id='pii-ircam-tab-2']/div[13]");
	public By Step1Q11Answer = By.xpath(".//*[@piiqref='1.1']");
	public By Step1Q12Answer = By.xpath(".//*[@piiqref='1.2']");
	public By Step1Q13Answer = By.xpath(".//*[@piiqref='1.3']");
	public By Step1Q12AnswerTextBox = By.id("pii-ircam-1-2-other");
	public By Step1Q13AnswerTextBox = By.id("pii-ircam-1-3-other");
	public By AnswerOptionNone = By.xpath(".//*[@piiindex='none']");
	public By AnswerOption0 = By.xpath(".//*[@piiindex='0']");
	public By AnswerOption1 = By.xpath(".//*[@piiindex='1']");
	public By AnswerOption2 = By.xpath(".//*[@piiindex='2']");
	public By AnswerOption3 = By.xpath(".//*[@piiindex='3']");
	public By AnswerOption4 = By.xpath(".//*[@piiindex='4']");
	public By AnswerOption5 = By.xpath(".//*[@piiindex='5']");
	public By AnswerOption6 = By.xpath(".//*[@piiindex='6']");
	public By AnswerOption7 = By.xpath(".//*[@piiindex='7']");
	public By AnswerOption8 = By.xpath(".//*[@piiindex='8']");
	public By AnswerOption9 = By.xpath(".//*[@piiindex='9']");
	public By AnswerOption10 = By.xpath(".//*[@piiindex='10']");
	public By AnswerOption11 = By.xpath(".//*[@piiindex='11']");
	public By AnswerOption12 = By.xpath(".//*[@piiindex='12']");
	public By AnswerOption13 = By.xpath(".//*[@piiindex='13']");
	public By AnswerOption14 = By.xpath(".//*[@piiindex='14']");
	public By AnswerOption15 = By.xpath(".//*[@piiindex='15']");
	public By AnswerOption16 = By.xpath(".//*[@piiindex='16']");
	public By AnswerOption17 = By.xpath(".//*[@piiindex='17']");
	public By AnswerOption18 = By.xpath(".//*[@piiindex='18']");
	public By AnswerOption19 = By.xpath(".//*[@piiindex='19']");
	public By AnswerOption20 = By.xpath(".//*[@piiindex='20']");
	public By AnswerOption21 = By.xpath(".//*[@piiindex='21']");
	public By AnswerOption22 = By.xpath(".//*[@piiindex='22']");
	public By AnswerOption23 = By.xpath(".//*[@piiindex='23']");
	public By AnswerOption24 = By.xpath(".//*[@piiindex='24']");
	public By AnswerOption25 = By.xpath(".//*[@piiindex='25']");
	public By AnswerOption26 = By.xpath(".//*[@piiindex='26']");
	public By AnswerOption27 = By.xpath(".//*[@piiindex='27']");
	public By AnswerOption28 = By.xpath(".//*[@piiindex='28']");
	public By AnswerOption29 = By.xpath(".//*[@piiindex='29']");
	public By AnswerOption30 = By.xpath(".//*[@piiindex='30']");
	public By AnswerOption31 = By.xpath(".//*[@piiindex='31']");
	public By AnswerOption32 = By.xpath(".//*[@piiindex='32']");

	//Step 2
	public By Step2Title = By.xpath(".//*[@id='pii-ircam-tab-3']/div[1]");
	public By Step2TextUnderTitle = By.xpath(".//*[@id='pii-ircam-tab-3']/div[2]");
	public By Step2Row11stTextBoxTitle = By.xpath(".//*[@id='pii-ircam-tab-3']/div[3]/div[1]/div");
	public By Step2Row12ndTextBoxTitle = By.xpath(".//*[@id='pii-ircam-tab-3']/div[3]/div[2]/div");
	public By Step2Row11stTextBoxField = By.xpath(".//*[@id='pii-ircam-tab-3']/div[3]/div[1]/textarea");
	public By Step2Row12ndTextBoxField = By.xpath(".//*[@id='pii-ircam-tab-3']/div[3]/div[2]/textarea");
	public By Step2Row21stTextBoxTitle = By.xpath(".//*[@id='pii-ircam-tab-3']/div[4]/div[1]/div");
	public By Step2Row22ndTextBoxTitle = By.xpath(".//*[@id='pii-ircam-tab-3']/div[4]/div[2]/div");
	public By Step2Row21stTextBoxField = By.xpath(".//*[@id='pii-ircam-tab-3']/div[4]/div[1]/textarea");

	public By Step2AddFailureButton = By.id("pii-ircam-addnewfmt");

	

	//Step 3
	public By Step3Tab = By.id("pii-ircam-tab-4-a");
	public By Step3Title = By.xpath(".//*[@id='pii-ircam-tab-4']/div[1]");
	public By Step3TextUnderTitle = By.xpath(".//*[@id='pii-ircam-tab-4']/div[2]");
	public By Step3FailureCollapsible = By.xpath(".//*[@id='pii-ircam-tab-4']/div[3]");
	public By Step3TitleUnderCollapsible = By.xpath(".//*[@id='pii-ircam-tab-4']/div[3]/div/div[1]/div[1]");
	public By Step3TextUnderTitleUnderCollapsible = By.xpath(".//*[@id='pii-ircam-tab-4']/div[3]/div/div[1]/div[2]");
	public By Step3TableTitleUnderCollapsible = By.xpath(".//*[@id='pii-ircam-tab-4']/div[3]/div/div[2]");
	public By Step3TableColumn1Title = By.xpath(".//*[@id='pii-ircam-tab-4']/div[3]/div/table/thead/tr/th[1]");
	public By Step3TableColumn2Title = By.xpath(".//*[@id='pii-ircam-tab-4']/div[3]/div/table/thead/tr/th[2]");
	public By Step3TableColumn3Title = By.xpath(".//*[@id='pii-ircam-tab-4']/div[3]/div/table/thead/tr/th[3]");
	public By Step3TableColumn4TitlePart1 = By.xpath(".//*[@id='pii-ircam-tab-4']/div[3]/div/table/thead/tr/th[4]");
	public By Step3TableColumn4TitlePart2 = By.xpath(".//*[@id='pii-ircam-tab-4']/div[3]/div/table/thead/tr/th[4]/div");
	public By Step3TableOption31 = By.xpath(".//*[@id='pii-ircam-tab-4']/div[3]/div/table/tbody/tr[1]/td[1]");
	public By Step3TableOption32 = By.xpath(".//*[@id='pii-ircam-tab-4']/div[3]/div/table/tbody/tr[2]/td[1]");
	public By Step3TableOption33 = By.xpath(".//*[@id='pii-ircam-tab-4']/div[3]/div/table/tbody/tr[3]/td[1]");
	public By Step3TableOption34 = By.xpath(".//*[@id='pii-ircam-tab-4']/div[3]/div/table/tbody/tr[4]/td[1]");
	public By Step3TableOption35 = By.xpath(".//*[@id='pii-ircam-tab-4']/div[3]/div/table/tbody/tr[5]/td[1]");
	public By Step3TableOption36 = By.xpath(".//*[@id='pii-ircam-tab-4']/div[3]/div/table/tbody/tr[6]/td[1]");
	public By Step3TableOption31CheckBox = By.xpath(".//*[@id='pii-ircam-tab-4']/div[3]/div/table/tbody/tr[1]/td[2]/div/input");
	public By Step3TableOption32CheckBox = By.xpath(".//*[@id='pii-ircam-tab-4']/div[3]/div/table/tbody/tr[2]/td[2]/div/input");
	public By Step3TableOption33CheckBox = By.xpath(".//*[@id='pii-ircam-tab-4']/div[3]/div/table/tbody/tr[3]/td[2]/div/input");
	public By Step3TableOption34CheckBox = By.xpath(".//*[@id='pii-ircam-tab-4']/div[3]/div/table/tbody/tr[4]/td[2]/div/input");
	public By Step3TableOption35CheckBox = By.xpath(".//*[@id='pii-ircam-tab-4']/div[3]/div/table/tbody/tr[5]/td[2]/div/input");
	public By Step3TableOption36CheckBox = By.xpath(".//*[@id='pii-ircam-tab-4']/div[3]/div/table/tbody/tr[6]/td[2]/div/input");
	public By Step3TableOption31Column3 = By.xpath(".//*[@id='pii-ircam-tab-4']/div[3]/div/table/tbody/tr[1]/td[3]/strong");
	public By Step3TableOption32Column3 = By.xpath(".//*[@id='pii-ircam-tab-4']/div[3]/div/table/tbody/tr[2]/td[3]/strong");
	public By Step3TableOption33Column3 = By.xpath(".//*[@id='pii-ircam-tab-4']/div[3]/div/table/tbody/tr[3]/td[3]/strong");
	public By Step3TableOption34Column3 = By.xpath(".//*[@id='pii-ircam-tab-4']/div[3]/div/table/tbody/tr[4]/td[3]/strong");
	public By Step3TableOption35Column3 = By.xpath(".//*[@id='pii-ircam-tab-4']/div[3]/div/table/tbody/tr[5]/td[3]/strong");
	public By Step3TableOption36Column3 = By.xpath(".//*[@id='pii-ircam-tab-4']/div[3]/div/table/tbody/tr[6]/td[3]/strong");

	//Step 4
	public By Step4Title = By.xpath(".//*[@id='pii-ircam-tab-5']/div[1]");
	public By Step4TextUnderTitle = By.xpath(".//*[@id='pii-ircam-tab-5']/div[2]");
	public By Step4FailureCollapsible = By.xpath(".//*[@id='pii-ircam-tab-5']/div[3]/h4/a");
	public By Step4TitleUnderCollapsible = By.xpath(".//*[@id='pii-ircam-tab-5']/div[3]/div/div[1]/div[1]");
	public By Step4TextUnderTitleUnderCollapsible = By.xpath(".//*[@id='pii-ircam-tab-5']/div[3]/div/div[1]/div[2]");
	public By Step4TableColumn1Title = By.xpath(".//*[@id='pii-ircam-tab-5']/div[3]/div/table/thead/tr/th[1]");
	public By Step4TableColumn2Title = By.xpath(".//*[@id='pii-ircam-tab-5']/div[3]/div/table/thead/tr/th[2]");
	public By Step4TableColumn3TitlePart1 = By.xpath(".//*[@id='pii-ircam-tab-5']/div[3]/div/table/thead/tr/th[3]");
	public By Step4TableColumn3TitlePart2 = By.xpath(".//*[@id='pii-ircam-tab-5']/div[3]/div/table/thead/tr/th[3]/div");
	public By Step4TableOption44Part1 = By.xpath(".//*[@id='pii-ircam-tab-5']/div[3]/div/table/tbody/tr[1]/td[1]");
	public By Step4TableOption44Part2 = By.xpath(".//*[@id='pii-ircam-tab-5']/div[3]/div/table/tbody/tr[1]/td[1]/div");
	public By Step4TableOption44CheckBox = By.xpath(".//*[@id='pii-ircam-tab-5']/div[3]/div/table/tbody/tr[1]/td[2]/div/input");

	//Step 5
	public By Step5Title = By.xpath(".//*[@id='pii-ircam-tab-6']/div[1]");
	public By Step5TextUnderTitle = By.xpath(".//*[@id='pii-ircam-tab-6']/div[2]");
	public By Step5FailureCollapsible = By.xpath(".//*[@id='pii-ircam-tab-6']/div[3]");
	public By Step5TitleUnderCollapsible = By.xpath(".//*[@id='pii-ircam-tab-6']/div[3]/div/div[1]/div[1]");
	public By Step5TextUnderTitleUnderCollapsible = By.xpath(".//*[@id='pii-ircam-tab-6']/div[3]/div/div[1]/div[2]");
	public By Step5Table1Option51 = By.xpath(".//*[@id='pii-ircam-tab-6']/div[3]/div/table[1]/tbody/tr[1]/td[1]");
	public By Step5Table2Under51Column1Title = By.xpath(".//*[@id='pii-ircam-tab-6']/div[3]/div/table[2]/thead/tr[1]/th[1]");
	public By Step5Table2Under51Column2Title = By.xpath(".//*[@id='pii-ircam-tab-6']/div[3]/div/table[2]/thead/tr[1]/th[2]");
	public By Step5Table2Under51Textbox1 = By.id("pii-ircam-step5-ta-ch-name-0-1-0");
	public By Step5Table2Under51Textbox2 = By.xpath(".//*[@id='pii-ircam-tab-6']/div[3]/div/table[2]/tbody/tr[1]/td[2]/textarea");
	public By Step5Table2Under51AddContributingFactorButton = By.xpath(".//*[@id='pii-ircam-tab-6']/div[3]/div/table[2]/tbody/tr[2]/td/div/div/button");
	public By Step5Table3Option52 = By.xpath(".//*[@id='pii-ircam-tab-6']/div[3]/div/table[3]/tbody/tr[1]/td[1]");
	public By Step5Table4Under52Column1Title = By.xpath(".//*[@id='pii-ircam-tab-6']/div[3]/div/table[4]/thead/tr[1]/th[1]");
	public By Step5Table4Under52Column2Title = By.xpath(".//*[@id='pii-ircam-tab-6']/div[3]/div/table[4]/thead/tr[1]/th[2]");
	public By Step5Table4Under52Textbox1 = By.id("pii-ircam-step5-ta-ch-name-0-2-0");
	public By Step5Table4Under52Textbox2 = By.xpath(".//*[@id='pii-ircam-tab-6']/div[3]/div/table[4]/tbody/tr[1]/td[2]/textarea");
	public By Step5Table4Under52AddContributingFactorButton = By.xpath(".//*[@id='pii-ircam-tab-6']/div[3]/div/table[4]/tbody/tr[2]/td/div/div/button");
	public By Step5Table5Option53 = By.xpath(".//*[@id='pii-ircam-tab-6']/div[3]/div/table[5]/tbody/tr[1]/td[1]");
	public By Step5Table6Under53Column1Title = By.xpath(".//*[@id='pii-ircam-tab-6']/div[3]/div/table[6]/thead/tr[1]/th[1]");
	public By Step5Table6Under53Column2Title = By.xpath(".//*[@id='pii-ircam-tab-6']/div[3]/div/table[6]/thead/tr[1]/th[2]");
	public By Step5Table6Under53Textbox1 = By.id("pii-ircam-step5-ta-ch-name-0-3-0");
	public By Step5Table6Under53Textbox2 = By.xpath(".//*[@id='pii-ircam-tab-6']/div[3]/div/table[6]/tbody/tr[1]/td[2]/textarea");
	public By Step5Table6Under53AddContributingFactorButton = By.xpath(".//*[@id='pii-ircam-tab-6']/div[3]/div/table[6]/tbody/tr[2]/td/div/div/button");
	public By Step5Table7Option54 = By.xpath(".//*[@id='pii-ircam-tab-6']/div[3]/div/table[7]/tbody/tr[1]/td[1]");
	public By Step5Table8Under54Column1Title = By.xpath(".//*[@id='pii-ircam-tab-6']/div[3]/div/table[8]/thead/tr[1]/th[1]");
	public By Step5Table8Under54Column2Title = By.xpath(".//*[@id='pii-ircam-tab-6']/div[3]/div/table[8]/thead/tr[1]/th[2]");
	public By Step5Table8Under54Textbox1 = By.id("pii-ircam-step5-ta-ch-name-0-4-0");
	public By Step5Table8Under54Textbox2 = By.xpath(".//*[@id='pii-ircam-tab-6']/div[3]/div/table[8]/tbody/tr[1]/td[2]/textarea");
	public By Step5Table8Under54AddContributingFactorButton = By.xpath(".//*[@id='pii-ircam-tab-6']/div[3]/div/table[8]/tbody/tr[2]/td/div/div/button");
	public By Step5Table9Column1Title = By.xpath(".//*[@id='pii-ircam-tab-6']/div[3]/div/table[9]/thead/tr/th[1]");
	public By Step5Table9Column2Title = By.xpath(".//*[@id='pii-ircam-tab-6']/div[3]/div/table[9]/thead/tr/th[2]");
	public By Step5Table9Column3TitlePart1 = By.xpath(".//*[@id='pii-ircam-tab-6']/div[3]/div/table[9]/thead/tr/th[3]");
	public By Step5Table9Column3TitlePart2 = By.xpath(".//*[@id='pii-ircam-tab-6']/div[3]/div/table[9]/thead/tr/th[3]/div");
	public By Step5Table9Option55Part1 = By.xpath(".//*[@id='pii-ircam-tab-6']/div[3]/div/table[9]/tbody/tr[1]/td[1]");
	public By Step5Table9Option55Part2 = By.xpath(".//*[@id='pii-ircam-tab-6']/div[3]/div/table[9]/tbody/tr[1]/td[1]/div");
	public By Step5Table9Option56Part1 = By.xpath(".//*[@id='pii-ircam-tab-6']/div[3]/div/table[9]/tbody/tr[2]/td[1]");
	public By Step5Table9Option56Part2 = By.xpath(".//*[@id='pii-ircam-tab-6']/div[3]/div/table[9]/tbody/tr[2]/td[1]/div");
	public By Step5TableOption55CheckBox = By.xpath(".//*[@id='pii-ircam-tab-6']/div[3]/div/table[9]/tbody/tr[1]/td[2]/div/input");
	public By Step5TableOption56CheckBox = By.xpath(".//*[@id='pii-ircam-tab-6']/div[3]/div/table[9]/tbody/tr[2]/td[2]/div/input");

	//Step 6
	public By Step6Title = By.xpath(".//*[@id='pii-ircam-tab-7']/div[1]");
	public By Step6TextUnderTitle = By.xpath(".//*[@id='pii-ircam-tab-7']/div[2]");
	public By Step6FailureCollapsible = By.xpath(".//*[@id='pii-ircam-tab-7']/div[3]");
	public By Step6TitleUnderCollapsible = By.xpath(".//*[@id='pii-ircam-tab-7']/div[3]/div/div[1]/div[1]");
	public By Step6TextUnderTitleUnderCollapsible = By.xpath(".//*[@id='pii-ircam-tab-7']/div[3]/div/div[1]/div[2]");
	public By Step6TableColumn1Title = By.xpath(".//*[@id='pii-ircam-tab-7']/div[3]/div/table/thead/tr/th[1]");
	public By Step6TableColumn2Title = By.xpath(".//*[@id='pii-ircam-tab-7']/div[3]/div/table/thead/tr/th[2]");
	public By Step6TableColumn3Title = By.xpath(".//*[@id='pii-ircam-tab-7']/div[3]/div/table/thead/tr/th[3]");
	public By Step6TableOption61 = By.xpath(".//*[@id='pii-ircam-tab-7']/div[3]/div/table/tbody/tr[1]/td[1]");
	public By Step6TableOption62 = By.xpath(".//*[@id='pii-ircam-tab-7']/div[3]/div/table/tbody/tr[2]/td[1]");
	public By Step6TableOption63 = By.xpath(".//*[@id='pii-ircam-tab-7']/div[3]/div/table/tbody/tr[3]/td[1]");
	public By Step6TableOption64 = By.xpath(".//*[@id='pii-ircam-tab-7']/div[3]/div/table/tbody/tr[4]/td[1]");
	public By Step6TableOption65Part1 = By.xpath(".//*[@id='pii-ircam-tab-7']/div[3]/div/table/tbody/tr[5]/td[1]");
	public By Step6TableOption65Part2 = By.xpath(".//*[@id='pii-ircam-tab-7']/div[3]/div/table/tbody/tr[5]/td[1]/div");
	public By Step6TableOption66 = By.xpath(".//*[@id='pii-ircam-tab-7']/div[3]/div/table/tbody/tr[6]/td[1]");
	public By Step6TableOption67 = By.xpath(".//*[@id='pii-ircam-tab-7']/div[3]/div/table/tbody/tr[7]/td[1]");
	public By Step6TableOption68 = By.xpath(".//*[@id='pii-ircam-tab-7']/div[3]/div/table/tbody/tr[8]/td[1]");
	public By Step6TableOption65CheckBox = By.xpath(".//*[@id='pii-ircam-tab-7']/div[3]/div/table/tbody/tr[5]/td[2]/div/input");
	public By Step6TableOption66CheckBox = By.xpath(".//*[@id='pii-ircam-tab-7']/div[3]/div/table/tbody/tr[6]/td[2]/div/input");
	public By Step6TableOption67CheckBox = By.xpath(".//*[@id='pii-ircam-tab-7']/div[3]/div/table/tbody/tr[7]/td[2]/div/input");
	public By Step6TableOption68CheckBox = By.xpath(".//*[@id='pii-ircam-tab-7']/div[3]/div/table/tbody/tr[8]/td[2]/div/input");
	public By Step6TableOption66MessageColumn3 = By.xpath(".//*[@id='pii-ircam-tab-7']/div[3]/div/table/tbody/tr[6]/td[3]");
	public By Step6TableOption67MessageColumn3 = By.xpath(".//*[@id='pii-ircam-tab-7']/div[3]/div/table/tbody/tr[7]/td[3]");
	public By Step6TableOption68MessageColumn3 = By.xpath(".//*[@id='pii-ircam-tab-7']/div[3]/div/table/tbody/tr[8]/td[3]");

	//Step 7 - SUEP
	public By Step7Title = By.xpath(".//*[@id='pii-ircam-tab-8']/div[1]");
	public By Step7TextUnderTitle = By.xpath(".//*[@id='pii-ircam-tab-8']/div[2]");
	public By Step7SUEP_S = By.xpath(".//*[@id='pii-ircam-tab-8']/div[3]");
	public By Step7SUEP_U = By.xpath(".//*[@id='pii-ircam-tab-8']/div[4]");
	public By Step7SUEP_E = By.xpath(".//*[@id='pii-ircam-tab-8']/div[5]");
	public By Step7SUEP_P = By.xpath(".//*[@id='pii-ircam-tab-8']/div[6]");
	public By Step7TextAboveTable = By.xpath(".//*[@id='pii-ircam-tab-8']/div[7]/div");
	public By Step7SUEPTableColumn1Heading = By.xpath(".//*[@id='pii-ircam-tab-8']/div[7]/table/thead/tr/th[1]");
	public By Step7SUEPTableColumn6Heading = By.xpath(".//*[@id='pii-ircam-tab-8']/div[7]/table/thead/tr/th[6]");
	public By Step7SUEPTableRow1 = By.xpath(".//*[@id='pii-ircam-tab-8']/div[7]/table/tbody/tr[1]/td[1]/strong");
	public By Step7SUEPTableRow2 = By.xpath(".//*[@id='pii-ircam-tab-8']/div[7]/table/tbody/tr[2]/td[1]");
	public By Step7SUEPTableRow3 = By.xpath(".//*[@id='pii-ircam-tab-8']/div[7]/table/tbody/tr[3]/td[1]");
	public By Step7SUEPTableRow4 = By.xpath(".//*[@id='pii-ircam-tab-8']/div[7]/table/tbody/tr[4]/td[1]");
	public By Step7SUEPTableRow5 = By.xpath(".//*[@id='pii-ircam-tab-8']/div[7]/table/tbody/tr[5]/td[1]");
	public By Step7SUEPTableRow2Chk1 = By.xpath(".//*[@id='pii-ircam-tab-8']/div[7]/table/tbody/tr[2]/td[2]/div/input");
	public By Step7SUEPTableRow2Chk2 = By.xpath(".//*[@id='pii-ircam-tab-8']/div[7]/table/tbody/tr[2]/td[3]/div/input");
	public By Step7SUEPTableRow2Chk3 = By.xpath(".//*[@id='pii-ircam-tab-8']/div[7]/table/tbody/tr[2]/td[4]/div/input");
	public By Step7SUEPTableRow2Chk4 = By.xpath(".//*[@id='pii-ircam-tab-8']/div[7]/table/tbody/tr[2]/td[5]/div/input");
	public By Step7SUEPTableRow3Chk1 = By.xpath(".//*[@id='pii-ircam-tab-8']/div[7]/table/tbody/tr[3]/td[2]/div/input");
	public By Step7SUEPTableRow3Chk2 = By.xpath(".//*[@id='pii-ircam-tab-8']/div[7]/table/tbody/tr[3]/td[3]/div/input");
	public By Step7SUEPTableRow3Chk3 = By.xpath(".//*[@id='pii-ircam-tab-8']/div[7]/table/tbody/tr[3]/td[4]/div/input");
	public By Step7SUEPTableRow3Chk4 = By.xpath(".//*[@id='pii-ircam-tab-8']/div[7]/table/tbody/tr[3]/td[5]/div/input");
	public By Step7SUEPTableRow4Chk1 = By.xpath(".//*[@id='pii-ircam-tab-8']/div[7]/table/tbody/tr[4]/td[2]/div/input");
	public By Step7SUEPTableRow4Chk2 = By.xpath(".//*[@id='pii-ircam-tab-8']/div[7]/table/tbody/tr[4]/td[3]/div/input");
	public By Step7SUEPTableRow4Chk3 = By.xpath(".//*[@id='pii-ircam-tab-8']/div[7]/table/tbody/tr[4]/td[4]/div/input");
	public By Step7SUEPTableRow4Chk4 = By.xpath(".//*[@id='pii-ircam-tab-8']/div[7]/table/tbody/tr[4]/td[5]/div/input");
	public By Step7SUEPTableRow5Chk1 = By.xpath(".//*[@id='pii-ircam-tab-8']/div[7]/table/tbody/tr[5]/td[2]/div/input");
	public By Step7SUEPTableRow5Chk2 = By.xpath(".//*[@id='pii-ircam-tab-8']/div[7]/table/tbody/tr[5]/td[3]/div/input");
	public By Step7SUEPTableRow5Chk3 = By.xpath(".//*[@id='pii-ircam-tab-8']/div[7]/table/tbody/tr[5]/td[4]/div/input");
	public By Step7SUEPTableRow5Chk4 = By.xpath(".//*[@id='pii-ircam-tab-8']/div[7]/table/tbody/tr[5]/td[5]/div/input");

	//Report Tab
	public By ReportTabTable1Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[1]/table/thead/tr/th");
	public By ReportTabTable1Label1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[1]/table/tbody/tr[1]/td[1]");
	public By ReportTabTable1Label2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[1]/table/tbody/tr[2]/td[1]");
	public By ReportTabTable1Label3 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[1]/table/tbody/tr[3]/td[1]");
	public By ReportTabTable1Label4 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[1]/table/tbody/tr[4]/td[1]");
	public By ReportTabTable1Label5 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[1]/table/tbody/tr[5]/td[1]");
	public By ReportTabTable1Label6 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[1]/table/tbody/tr[6]/td[1]");
	public By ReportTabTable1Label7 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[1]/table/tbody/tr[7]/td[1]");
	public By ReportTabTable1Label8 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[1]/table/tbody/tr[8]/td[1]");
	public By ReportTabTable1Label9 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[1]/table/tbody/tr[9]/td[1]");
	public By ReportTabTable1Label10 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[1]/table/tbody/tr[10]/td[1]");
	public By ReportTabTable1Label11 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[1]/table/tbody/tr[11]/td[1]");
	public By ReportTabTable1Label12 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[1]/table/tbody/tr[12]/td[1]");
	public By ReportTabTable1Label13 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[1]/table/tbody/tr[13]/td[1]");

	public By ReportTabTable2Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[2]");
	public By ReportTabTable2Column1Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[3]/table/thead/tr/th[1]");
	public By ReportTabTable2Column2Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[3]/table/thead/tr/th[2]");
	public By ReportTabTable2Row1Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[3]/table/tbody/tr[1]/td[1]");
	public By ReportTabTable2Row1Column2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[3]/table/tbody/tr[1]/td[2]");
	public By ReportTabTable2Row2Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[3]/table/tbody/tr[2]/td[1]");

	public By ReportTabTable3Column1Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[4]/table/thead/tr/th[1]");
	public By ReportTabTable3Column2Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[4]/table/thead/tr/th[2]");
	public By ReportTabTable3Row1Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[4]/table/tbody/tr[1]/td[1]");
	public By ReportTabTable3Row1Column2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[4]/table/tbody/tr[1]/td[2]");
	public By ReportTabTable3Row2Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[4]/table/tbody/tr[2]/td[1]");
	public By ReportTabTable3Row3Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[4]/table/tbody/tr[3]/td[1]");
	public By ReportTabTable3Row4Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[4]/table/tbody/tr[4]/td[1]");

	public By ReportTabTable4Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[5]/div");
	public By ReportTabTable4Column1Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[5]/table/thead/tr/th[1]");
	public By ReportTabTable4Column2Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[5]/table/thead/tr/th[2]");
	public By ReportTabTable4Column3Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[5]/table/thead/tr/th[3]");
	public By ReportTabTable4Row1Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[5]/table/tbody/tr[1]/td[1]");
	public By ReportTabTable4Row1Column2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[5]/table/tbody/tr[1]/td[2]");
	public By ReportTabTable4Row2Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[5]/table/tbody/tr[2]/td[1]");
	public By ReportTabTable4Row2Column2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[5]/table/tbody/tr[2]/td[2]");
	public By ReportTabTable4Row3Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[5]/table/tbody/tr[3]/td[1]");
	public By ReportTabTable4Row3Column2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[5]/table/tbody/tr[3]/td[2]");
	public By ReportTabTable4Row4Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[5]/table/tbody/tr[4]/td[1]");
	public By ReportTabTable4Row5Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[5]/table/tbody/tr[5]/td[1]");
	public By ReportTabTable4Row6Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[5]/table/tbody/tr[6]/td[1]");
	public By Path3ReportTabTable4Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[5]/div");
	public By Path3ReportTabTable4Column1Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[5]/table/thead/tr/th[1]");
	public By Path3ReportTabTable4Column2Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[5]/table/thead/tr/th[2]");
	public By Path3ReportTabTable4Row1Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[5]/table/tbody/tr[1]/td[1]");
	public By Path3ReportTabTable4Row1Column2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[5]/table/tbody/tr[1]/td[2]");
	public By Path3ReportTabTable4Row2Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[5]/table/tbody/tr[2]/td[1]");
	public By Path3ReportTabTable4Row2Column2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[5]/table/tbody/tr[2]/td[2]");
	public By Path3ReportTabTable4Row3Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[5]/table/tbody/tr[3]/td[1]");
	public By Path3ReportTabTable4Row3Column2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[5]/table/tbody/tr[3]/td[2]");
	public By Path3ReportTabTable4Row4Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[5]/table/tbody/tr[4]/td[1]");
	public By Path3ReportTabTable4Row5Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[5]/table/tbody/tr[5]/td[1]");
	public By Path3ReportTabTable4Row6Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[5]/table/tbody/tr[6]/td[1]");

	public By ReportTabTable5Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div");
	public By ReportTabTable5Column1Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/table/thead/tr/th[1]");
	public By ReportTabTable5Column2Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/table/thead/tr/th[2]");
	public By ReportTabTable5Row1Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/table/tbody/tr[1]/td[1]");
	public By ReportTabTable5Row1Column2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/table/tbody/tr[1]/td[2]");
	public By ReportTabTable5Row2Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/table/tbody/tr[2]/td[1]");
	public By ReportTabTable5Row2Column2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/table/tbody/tr[2]/td[2]");
	public By ReportTabTable5Row3Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/table/tbody/tr[3]/td[1]");
	public By ReportTabTable5Row3Column2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/table/tbody/tr[3]/td[2]");
	public By ReportTabTable5Row4Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/table/tbody/tr[4]/td[1]");
	public By ReportTabTable5Row5Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/table/tbody/tr[5]/td[1]");
	public By ReportTabTable5Row6Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/table/tbody/tr[6]/td[1]");
	public By Path2ReportTabTable5Column1Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[2]/table/thead/tr/th[1]");
	public By Path2ReportTabTable5Column2Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[2]/table/thead/tr/th[2]");
	public By Path2ReportTabTable5Row1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[2]/table/tbody/tr/td[1]/strong");
	public By Path3ReportTabTable5Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[1]");
	public By Path3ReportTabTable5Column1Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[2]/table/thead/tr/th[1]");
	public By Path3ReportTabTable5Column2Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[2]/table/thead/tr/th[2]");
	public By Path3ReportTabTable5Row1Column2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[2]/table/tbody/tr/td[2]");

	public By Path2ReportTabTable6Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[3]/div[1]");
	public By Path2ReportTabTable6SubTitle1Part1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[3]/div[2]/div/span[1]");
	public By Path2ReportTabTable6SubTitle1Part2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[3]/div[2]/div/span[2]");
	public By Path2ReportTabTable6SubTitle2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[3]/div[2]/div[2]/span[1]");
	public By ReportTabTable6Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[1]");
	public By ReportTabTable6Column1Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[2]/table/thead/tr/th[1]");
	public By ReportTabTable6Column2Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[2]/table/thead/tr/th[2]");
	public By ReportTabTable6Row1Column2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[2]/table/tbody/tr/td[2]");
	public By Path2ReportTabTable6Column1Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[3]/div[2]/table/thead/tr/th[1]");
	public By Path2ReportTabTable6Column2Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[3]/div[2]/table/thead/tr/th[2]");
	public By Path2ReportTabTable6Column3Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[3]/div[2]/table/thead/tr/th[3]");
	public By Path2ReportTabTable6Column4Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[3]/div[2]/table/thead/tr/th[4]");
	public By Path2ReportTabTable6Row1Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[3]/div[2]/table/tbody/tr[1]/td[1]");
	public By Path2ReportTabTable6Row1Column2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[3]/div[2]/table/tbody/tr[1]/td[2]");
	public By Path2ReportTabTable6Row1Column3 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[3]/div[2]/table/tbody/tr[1]/td[3]");
	public By Path2ReportTabTable6Row2Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[3]/div[2]/table/tbody/tr[2]/td[1]");
	public By Path2ReportTabTable6Row2Column2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[3]/div[2]/table/tbody/tr[2]/td[2]");
	public By Path2ReportTabTable6Row2Column3 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[3]/div[2]/table/tbody/tr[2]/td[3]");
	public By Path2ReportTabTable6Row3Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[3]/div[2]/table/tbody/tr[3]/td[1]");
	public By Path2ReportTabTable6Row3Column2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[3]/div[2]/table/tbody/tr[3]/td[2]");
	public By Path2ReportTabTable6Row3Column3 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[3]/div[2]/table/tbody/tr[3]/td[3]");
	public By Path2ReportTabTable6Row4Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[3]/div[2]/table/tbody/tr[4]/td[1]");
	public By Path2ReportTabTable6Row4Column2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[3]/div[2]/table/tbody/tr[4]/td[2]");
	public By Path2ReportTabTable6Row4Column3 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[3]/div[2]/table/tbody/tr[4]/td[3]");
	public By Path2ReportTabTable6Row5Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[3]/div[2]/table/tbody/tr[5]/td[1]");
	public By Path2ReportTabTable6Row5Column2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[3]/div[2]/table/tbody/tr[5]/td[2]");
	public By Path2ReportTabTable6Row5Column3 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[3]/div[2]/table/tbody/tr[5]/td[3]");
	public By Path2ReportTabTable6Row6Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[3]/div[2]/table/tbody/tr[6]/td[1]");
	public By Path2ReportTabTable6Row6Column2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[3]/div[2]/table/tbody/tr[6]/td[2]");
	public By Path2ReportTabTable6Row6Column3 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[3]/div[2]/table/tbody/tr[6]/td[3]");
	public By Path3ReportTabTable6Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[3]");/*
	public By Path3ReportTabTable6SubTitle1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[3]/div[2]/div[1]/span[1]");
	public By Path3ReportTabTable6SubTitle2Part1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[3]/div[2]/div[2]/span[1]");
	public By Path3ReportTabTable6SubTitle2Part2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[3]/div[2]/div[2]/span[2]");
	public By Path3ReportTabTable6Column1Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[3]/div[2]/table/thead/tr/th[1]");
	public By Path3ReportTabTable6Column2Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[3]/div[2]/table/thead/tr/th[2]");
	public By Path3ReportTabTable6Column3Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[3]/div[2]/table/thead/tr/th[3]");
	public By Path3ReportTabTable6Column4Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[3]/div[2]/table/thead/tr/th[4]");
	public By Path3ReportTabTable6Row1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[3]/div[2]/table/tbody/tr[1]/td[1]");
	public By Path3ReportTabTable6Row2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[3]/div[2]/table/tbody/tr[2]/td[1]");
	public By Path3ReportTabTable6Row3 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[3]/div[2]/table/tbody/tr[3]/td[1]");
	public By Path3ReportTabTable6Row4 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[3]/div[2]/table/tbody/tr[4]/td[1]");
	public By Path3ReportTabTable6Row5 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[3]/div[2]/table/tbody/tr[5]/td[1]");
	public By Path3ReportTabTable6Row6 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[3]/div[2]/table/tbody/tr[6]/td[1]");*/

	public By ReportTabTable7Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[3]/div[1]");
	public By ReportTabTable7SubTitle1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[3]/div[2]/div[1]/span[1]");
	public By ReportTabTable7SubTitle2Part1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[3]/div[2]/div[2]/span[1]");
	public By ReportTabTable7SubTitle2Part2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[3]/div[2]/div[2]/span[2]");
	public By ReportTabTable7Column1Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[3]/div[2]/table/thead/tr/th[1]");
	public By ReportTabTable7Column2Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[3]/div[2]/table/thead/tr/th[2]");
	public By ReportTabTable7Column3Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[3]/div[2]/table/thead/tr/th[3]");
	public By ReportTabTable7Column4Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[3]/div[2]/table/thead/tr/th[4]");
	public By ReportTabTable7Row1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[3]/div[2]/table/tbody/tr[1]/td[1]");
	public By ReportTabTable7Row2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[3]/div[2]/table/tbody/tr[2]/td[1]");
	public By ReportTabTable7Row3 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[3]/div[2]/table/tbody/tr[3]/td[1]");
	public By ReportTabTable7Row4 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[3]/div[2]/table/tbody/tr[4]/td[1]");
	public By ReportTabTable7Row5 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[3]/div[2]/table/tbody/tr[5]/td[1]");
	public By ReportTabTable7Row6 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[3]/div[2]/table/tbody/tr[6]/td[1]");
	public By Path3ReportTabTable7Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[4]/div[1]");
	public By Path3ReportTabTable7SubTitle1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[4]/div[2]");
	public By Path3ReportTabTable7SubTitle2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[4]/div[3]/div[1]/span[1]");
	public By Path3ReportTabTable7SubTitle3Part1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[4]/div[3]/div[2]/span[1]");
	public By Path3ReportTabTable7SubTitle3Part2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[4]/div[3]/div[2]/span[2]");
	public By Path3ReportTabTable7Column1Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[4]/div[3]/table/thead/tr/th[1]");
	public By Path3ReportTabTable7Column2Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[4]/div[3]/table/thead/tr/th[2]");
	public By Path3ReportTabTable7Column3Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[4]/div[3]/table/thead/tr/th[3]");
	public By Path3ReportTabTable7Row1Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[4]/div[3]/table/tbody/tr[1]/td[1]");
	public By Path3ReportTabTable7Row1Column2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[4]/div[3]/table/tbody/tr[1]/td[2]");
	public By Path3ReportTabTable7Row2Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[4]/div[3]/table/tbody/tr[2]/td[1]");
	public By Path3ReportTabTable7Row2Column2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[4]/div[3]/table/tbody/tr[2]/td[2]");
	public By Path3ReportTabTable7Row3Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[4]/div[3]/table/tbody/tr[3]/td[1]");
	public By Path3ReportTabTable7Row3Column2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[4]/div[3]/table/tbody/tr[3]/td[2]");
	public By Path3ReportTabTable7Row4Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[4]/div[3]/table/tbody/tr[4]/td[1]");
	public By Path3ReportTabTable7Row4Column2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[4]/div[3]/table/tbody/tr[4]/td[2]");
	public By Path3ReportTabTable7Row5Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[4]/div[3]/table/tbody/tr[5]/td[1]");
	public By Path3ReportTabTable7Row5Column2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[4]/div[3]/table/tbody/tr[5]/td[2]");
	public By Path3ReportTabTable7Row6Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[4]/div[3]/table/tbody/tr[6]/td[1]");
	public By Path3ReportTabTable7Row6Column2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[4]/div[3]/table/tbody/tr[6]/td[2]");
	public By Path3ReportTabTable7Row7Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[4]/div[3]/table/tbody/tr[7]/td[1]");
	public By Path3ReportTabTable7Row7Column2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[4]/div[3]/table/tbody/tr[7]/td[2]");

	public By ReportTabTable8Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[4]/div[1]");
	public By ReportTabTable8SubTitle1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[4]/div[2]");
	public By ReportTabTable8SubTitle2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[4]/div[3]/div[1]/span[1]");
	public By ReportTabTable8SubTitle3Part1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[4]/div[3]/div[2]/span[1]");
	public By ReportTabTable8SubTitle3Part2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[4]/div[3]/div[2]/span[2]");
	public By ReportTabTable8Column1Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[4]/div[3]/table/thead/tr/th[1]");
	public By ReportTabTable8Column2Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[4]/div[3]/table/thead/tr/th[2]");
	public By ReportTabTable8Column3Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[4]/div[3]/table/thead/tr/th[3]");
	public By ReportTabTable8Row1Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[4]/div[3]/table/tbody/tr[1]/td[1]");
	public By ReportTabTable8Row1Column2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[4]/div[3]/table/tbody/tr[1]/td[2]");
	public By ReportTabTable8Row2Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[4]/div[3]/table/tbody/tr[2]/td[1]");
	public By ReportTabTable8Row2Column2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[4]/div[3]/table/tbody/tr[2]/td[2]");
	public By ReportTabTable8Row3Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[4]/div[3]/table/tbody/tr[3]/td[1]");
	public By ReportTabTable8Row3Column2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[4]/div[3]/table/tbody/tr[3]/td[2]");
	public By ReportTabTable8Row4Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[4]/div[3]/table/tbody/tr[4]/td[1]");
	public By ReportTabTable8Row4Column2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[4]/div[3]/table/tbody/tr[4]/td[2]");
	public By ReportTabTable8Row5Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[4]/div[3]/table/tbody/tr[5]/td[1]");
	public By ReportTabTable8Row5Column2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[4]/div[3]/table/tbody/tr[5]/td[2]");
	public By ReportTabTable8Row6Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[4]/div[3]/table/tbody/tr[6]/td[1]");
	public By ReportTabTable8Row6Column2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[4]/div[3]/table/tbody/tr[6]/td[2]");
	public By ReportTabTable8Row7Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[4]/div[3]/table/tbody/tr[7]/td[1]");
	public By ReportTabTable8Row7Column2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[4]/div[3]/table/tbody/tr[7]/td[2]");
	public By Path3ReportTabTable8Title1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[1]");
	public By Path3ReportTabTable8Title2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[2]/div[1]/span[1]");
	public By Path3ReportTabTable8Title3Part1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[2]/div[2]/span[1]");
	public By Path3ReportTabTable8Title3Part2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[2]/div[2]/span[2]");
	public By Path3ReportTabTable8Column1Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[2]/div[3]/table/thead/tr/th[1]");
	public By Path3ReportTabTable8Column2Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[2]/div[3]/table/thead/tr/th[2]");
	public By Path3ReportTabTable8Row1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[2]/div[3]/table/tbody[1]/tr/td");

	public By Path3ReportTabTable9Column1Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[2]/div[4]/table/thead/tr/th[1]");
	public By Path3ReportTabTable9Column2Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[2]/div[4]/table/thead/tr/th[2]");
	public By Path3ReportTabTable9Row1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[2]/div[4]/table/tbody[1]/tr/td");

	public By Path3ReportTabTable10Column1Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[2]/div[5]/table/thead/tr/th[1]");
	public By Path3ReportTabTable10Column2Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[2]/div[5]/table/thead/tr/th[2]");
	public By Path3ReportTabTable10Row1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[2]/div[5]/table/tbody[1]/tr/td");

	public By Path3ReportTabTable11Column1Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[2]/div[6]/table/thead/tr/th[1]");
	public By Path3ReportTabTable11Column2Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[2]/div[6]/table/thead/tr/th[2]");
	public By Path3ReportTabTable11Row1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[2]/div[6]/table/tbody[1]/tr/td");

	public By Path3ReportTabTable12Column1Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[2]/div[7]/table/thead/tr/th[1]");
	public By Path3ReportTabTable12Column2Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[2]/div[7]/table/thead/tr/th[2]");
	public By Path3ReportTabTable12Column3Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[2]/div[7]/table/thead/tr/th[3]");
	public By Path3ReportTabTable12Row1Column1Part1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[2]/div[7]/table/tbody/tr/td[1]");
	public By Path3ReportTabTable12Row1Column1Part2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[2]/div[7]/table/tbody/tr/td[1]/div");
	public By Path3ReportTabTable12Row1Column2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[2]/div[7]/table/tbody/tr/td[2]/strong");

	public By Path3ReportTabTable13Column1Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[2]/div[8]/table/thead/tr/th[1]");
	public By Path3ReportTabTable13Column2Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[2]/div[8]/table/thead/tr/th[2]");
	public By Path3ReportTabTable13Column3Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[2]/div[8]/table/thead/tr/th[3]");
	public By Path3ReportTabTable13Row1Column1Part1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[2]/div[8]/table/tbody/tr/td[1]");
	public By Path3ReportTabTable13Row1Column1Part2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[2]/div[8]/table/tbody/tr/td[1]/div");
	public By Path3ReportTabTable13Row1Column2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[2]/div[8]/table/tbody/tr/td[2]/strong");

	public By Path3ReportTabTable14Title1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[3]/div[1]");
	public By Path3ReportTabTable14Title2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[3]/div[2]/div[1]/span[1]");
	public By Path3ReportTabTable14Title3Part1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[3]/div[2]/div[2]/span[1]");
	public By Path3ReportTabTable14Title3Part2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[3]/div[2]/div[2]/span[2]");
	public By Path3ReportTabTable14Column1Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[3]/div[2]/table/thead/tr/th[1]");
	public By Path3ReportTabTable14Column2Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[3]/div[2]/table/thead/tr/th[2]");
	public By Path3ReportTabTable14Column3Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[3]/div[2]/table/thead/tr/th[3]");
	public By Path3ReportTabTable14Row1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[3]/div[2]/table/tbody/tr[1]/td");
	public By Path3ReportTabTable14Row2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[3]/div[2]/table/tbody/tr[2]/td");
	public By Path3ReportTabTable14Row3 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[3]/div[2]/table/tbody/tr[3]/td");
	public By Path3ReportTabTable14Row4 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[3]/div[2]/table/tbody/tr[4]/td");
	public By Path3ReportTabTable14Row5Column1Part1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[3]/div[2]/table/tbody/tr[5]/td[1]");
	public By Path3ReportTabTable14Row5Column1Part2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[3]/div[2]/table/tbody/tr[5]/td[1]/div");
	public By Path3ReportTabTable14Row5Column2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[3]/div[2]/table/tbody/tr[5]/td[2]/strong");
	public By Path3ReportTabTable14Row6Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[3]/div[2]/table/tbody/tr[6]/td[1]");
	public By Path3ReportTabTable14Row6Column2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[3]/div[2]/table/tbody/tr[6]/td[2]/strong");
	public By Path3ReportTabTable14Row6Column3 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[3]/div[2]/table/tbody/tr[6]/td[3]/strong");
	public By Path3ReportTabTable14Row7Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[3]/div[2]/table/tbody/tr[7]/td[1]");
	public By Path3ReportTabTable14Row7Column2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[3]/div[2]/table/tbody/tr[7]/td[2]/strong");
	public By Path3ReportTabTable14Row7Column3 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[3]/div[2]/table/tbody/tr[7]/td[3]/strong");
	public By Path3ReportTabTable14Row8Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[3]/div[2]/table/tbody/tr[8]/td[1]");
	public By Path3ReportTabTable14Row8Column2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[3]/div[2]/table/tbody/tr[8]/td[2]/strong");
	public By Path3ReportTabTable14Row8Column3 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[3]/div[2]/table/tbody/tr[8]/td[3]/strong");

	public By Path3ReportTabTable15SUEPTitle = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[4]/div[1]");
	public By Path3ReportTabTable15SUEP_S = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[4]/div[2]/span[2]");
	public By Path3ReportTabTable15SUEP_U = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[4]/div[3]/span[2]");
	public By Path3ReportTabTable15SUEP_E = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[4]/div[4]/span[2]");
	public By Path3ReportTabTable15SUEP_P = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[4]/div[5]/span[2]");
	public By Path3ReportTabTable15Column1Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[4]/div[6]/table/thead/tr/th[1]");
	public By Path3ReportTabTable15Column6Title = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[4]/div[6]/table/thead/tr/th[6]");
	public By Path3ReportTabTable15Row1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[4]/div[6]/table/tbody/tr[1]/td/strong");
	public By Path3ReportTabTable15Row2Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[4]/div[6]/table/tbody/tr[2]/td[1]");
	public By Path3ReportTabTable15Row2Column2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[4]/div[6]/table/tbody/tr[2]/td[2]/strong");
	public By Path3ReportTabTable15Row2Column3 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[4]/div[6]/table/tbody/tr[2]/td[3]/strong");
	public By Path3ReportTabTable15Row2Column4 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[4]/div[6]/table/tbody/tr[2]/td[4]/strong");
	public By Path3ReportTabTable15Row2Column5 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[4]/div[6]/table/tbody/tr[2]/td[5]/strong");
	public By Path3ReportTabTable15Row3 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[4]/div[6]/table/tbody/tr[3]/td[1]");
	public By Path3ReportTabTable15Row4 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[4]/div[6]/table/tbody/tr[4]/td[1]");
	public By Path3ReportTabTable15Row5 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[4]/div[6]/table/tbody/tr[5]/td[1]");

	public By ReportTabSkippedStep3Message = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[3]");
	public By ReportTabSkippedStep4Message = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[4]");
	public By ReportTabSkippedStep5Message = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[5]");
	public By ReportTabSkippedStep6Message = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[6]");
	public By ReportTabSkippedStep7Message = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[7]");
	public By Path2ReportTabSkippedStep4MessagePart1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]");
	//public By Path2ReportTabSkippedStep4MessagePart2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[6]/div[4]/div[2]");
	public By Path2ReportTabSkippedStep5Message = By.xpath(".//*[@id='pii-ircam-tab-9']/div[8]");
	public By Path2ReportTabSkippedStep6Message = By.xpath(".//*[@id='pii-ircam-tab-9']/div[9]");
	public By Path2ReportTabSkippedStep7Message = By.xpath(".//*[@id='pii-ircam-tab-9']/div[10]");

	public By ReportTabTable9Heading = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[8]/div");
	public By ReportTabTable9Row1Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[8]/table/tbody/tr[1]/td[1]");
	public By ReportTabTable9Row1Column2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[8]/table/tbody/tr[1]/td[2]");
	public By ReportTabTable9Row2Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[8]/table/tbody/tr[2]/td[1]");
	public By ReportTabTable9Row2Column2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[8]/table/tbody/tr[2]/td[2]");
	public By ReportTabTable9Row3Column1 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[8]/table/tbody/tr[3]/td[1]");
	public By ReportTabTable9Row3Column2 = By.xpath(".//*[@id='pii-ircam-tab-9']/div[7]/div[8]/table/tbody/tr[3]/td[2]");

	//HTML
	public By HTMLTable1Title = By.xpath(".//*[@id='mirca-rpt']/div[1]/table/thead/tr/th");
	public By HTMLTable1Label1 = By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[1]/td[1]");
	public By HTMLTable1Label2 = By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[2]/td[1]");
	public By HTMLTable1Label3 = By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[3]/td[1]");
	public By HTMLTable1Label4 = By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[4]/td[1]");
	public By HTMLTable1Label5 = By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[5]/td[1]");
	public By HTMLTable1Label6 = By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[6]/td[1]");
	public By HTMLTable1Label7 = By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[7]/td[1]");
	public By HTMLTable1Label8 = By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[8]/td[1]");
	public By HTMLTable1Label9 = By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[9]/td[1]");
	public By HTMLTable1Label10 = By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[10]/td[1]");
	public By HTMLTable1Label11 = By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[11]/td[1]");
	public By HTMLTable1Label12 = By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[12]/td[1]");
	public By HTMLTable1Label13 = By.xpath(".//*[@id='mirca-rpt']/div[1]/table/tbody/tr[13]/td[1]");

	public By HTMLTable2Title = By.xpath(".//*[@id='mirca-rpt']/div[2]");
	public By HTMLTable2Column1Title = By.xpath(".//*[@id='mirca-rpt']/div[3]/table/thead/tr/th[1]");
	public By HTMLTable2Column2Title = By.xpath(".//*[@id='mirca-rpt']/div[3]/table/thead/tr/th[2]");
	public By HTMLTable2Row1Column1 = By.xpath(".//*[@id='mirca-rpt']/div[3]/table/tbody/tr[1]/td[1]");
	public By HTMLTable2Row1Column2 = By.xpath(".//*[@id='mirca-rpt']/div[3]/table/tbody/tr[1]/td[2]");
	public By HTMLTable2Row2Column1 = By.xpath(".//*[@id='mirca-rpt']/div[3]/table/tbody/tr[2]/td[1]");

	public By HTMLTable3Column1Title = By.xpath(".//*[@id='mirca-rpt']/div[4]/table/thead/tr/th[1]");
	public By HTMLTable3Column2Title = By.xpath(".//*[@id='mirca-rpt']/div[4]/table/thead/tr/th[2]");
	public By HTMLTable3Row1Column1 = By.xpath(".//*[@id='mirca-rpt']/div[4]/table/tbody/tr[1]/td[1]");
	public By HTMLTable3Row1Column2 = By.xpath(".//*[@id='mirca-rpt']/div[4]/table/tbody/tr[1]/td[2]");
	public By HTMLTable3Row2Column1 = By.xpath(".//*[@id='mirca-rpt']/div[4]/table/tbody/tr[2]/td[1]");
	public By HTMLTable3Row3Column1 = By.xpath(".//*[@id='mirca-rpt']/div[4]/table/tbody/tr[3]/td[1]");
	public By HTMLTable3Row4Column1 = By.xpath(".//*[@id='mirca-rpt']/div[4]/table/tbody/tr[4]/td[1]");

	public By HTMLTable4Title = By.xpath(".//*[@id='mirca-rpt']/div[5]/div");
	public By HTMLTable4Column1Title = By.xpath(".//*[@id='mirca-rpt']/div[5]/table/thead/tr/th[1]");
	public By HTMLTable4Column2Title = By.xpath(".//*[@id='mirca-rpt']/div[5]/table/thead/tr/th[2]");
	public By HTMLTable4Column3Title = By.xpath(".//*[@id='mirca-rpt']/div[5]/table/thead/tr/th[3]");
	public By HTMLTable4Row1Column1 = By.xpath(".//*[@id='mirca-rpt']/div[5]/table/tbody/tr[1]/td[1]");
	public By HTMLTable4Row1Column2 = By.xpath(".//*[@id='mirca-rpt']/div[5]/table/tbody/tr[1]/td[2]");
	public By HTMLTable4Row2Column1 = By.xpath(".//*[@id='mirca-rpt']/div[5]/table/tbody/tr[2]/td[1]");
	public By HTMLTable4Row2Column2 = By.xpath(".//*[@id='mirca-rpt']/div[5]/table/tbody/tr[2]/td[2]");
	public By HTMLTable4Row3Column1 = By.xpath(".//*[@id='mirca-rpt']/div[5]/table/tbody/tr[3]/td[1]");
	public By HTMLTable4Row3Column2 = By.xpath(".//*[@id='mirca-rpt']/div[5]/table/tbody/tr[3]/td[2]");
	public By HTMLTable4Row4Column1 = By.xpath(".//*[@id='mirca-rpt']/div[5]/table/tbody/tr[4]/td[1]");
	public By HTMLTable4Row5Column1 = By.xpath(".//*[@id='mirca-rpt']/div[5]/table/tbody/tr[5]/td[1]");
	public By HTMLTable4Row6Column1 = By.xpath(".//*[@id='mirca-rpt']/div[5]/table/tbody/tr[6]/td[1]");
	public By Path3HTMLTable4Title = By.xpath(".//*[@id='mirca-rpt']/div[5]/div");
	public By Path3HTMLTable4Column1Title = By.xpath(".//*[@id='mirca-rpt']/div[5]/table/thead/tr/th[1]");
	public By Path3HTMLTable4Column2Title = By.xpath(".//*[@id='mirca-rpt']/div[5]/table/thead/tr/th[2]");
	public By Path3HTMLTable4Row1Column1 = By.xpath(".//*[@id='mirca-rpt']/div[5]/table/tbody/tr[1]/td[1]");
	public By Path3HTMLTable4Row1Column2 = By.xpath(".//*[@id='mirca-rpt']/div[5]/table/tbody/tr[1]/td[2]");
	public By Path3HTMLTable4Row2Column1 = By.xpath(".//*[@id='mirca-rpt']/div[5]/table/tbody/tr[2]/td[1]");
	public By Path3HTMLTable4Row2Column2 = By.xpath(".//*[@id='mirca-rpt']/div[5]/table/tbody/tr[2]/td[2]");
	public By Path3HTMLTable4Row3Column1 = By.xpath(".//*[@id='mirca-rpt']/div[5]/table/tbody/tr[3]/td[1]");
	public By Path3HTMLTable4Row3Column2 = By.xpath(".//*[@id='mirca-rpt']/div[5]/table/tbody/tr[3]/td[2]");
	public By Path3HTMLTable4Row4Column1 = By.xpath(".//*[@id='mirca-rpt']/div[5]/table/tbody/tr[4]/td[1]");
	public By Path3HTMLTable4Row5Column1 = By.xpath(".//*[@id='mirca-rpt']/div[5]/table/tbody/tr[5]/td[1]");
	public By Path3HTMLTable4Row6Column1 = By.xpath(".//*[@id='mirca-rpt']/div[5]/table/tbody/tr[6]/td[1]");

	public By HTMLTable5Title = By.xpath(".//*[@id='mirca-rpt']/div[6]/div");
	public By HTMLTable5Column1Title = By.xpath(".//*[@id='mirca-rpt']/div[6]/table/thead/tr/th[1]");
	public By HTMLTable5Column2Title = By.xpath(".//*[@id='mirca-rpt']/div[6]/table/thead/tr/th[2]");
	public By HTMLTable5Row1Column1 = By.xpath(".//*[@id='mirca-rpt']/div[6]/table/tbody/tr[1]/td[1]");
	public By HTMLTable5Row1Column2 = By.xpath(".//*[@id='mirca-rpt']/div[6]/table/tbody/tr[1]/td[2]");
	public By HTMLTable5Row2Column1 = By.xpath(".//*[@id='mirca-rpt']/div[6]/table/tbody/tr[2]/td[1]");
	public By HTMLTable5Row2Column2 = By.xpath(".//*[@id='mirca-rpt']/div[6]/table/tbody/tr[2]/td[2]");
	public By HTMLTable5Row3Column1 = By.xpath(".//*[@id='mirca-rpt']/div[6]/table/tbody/tr[3]/td[1]");
	public By HTMLTable5Row3Column2 = By.xpath(".//*[@id='mirca-rpt']/div[6]/table/tbody/tr[3]/td[2]");
	public By HTMLTable5Row4Column1 = By.xpath(".//*[@id='mirca-rpt']/div[6]/table/tbody/tr[4]/td[1]");
	public By HTMLTable5Row5Column1 = By.xpath(".//*[@id='mirca-rpt']/div[6]/table/tbody/tr[5]/td[1]");
	public By HTMLTable5Row6Column1 = By.xpath(".//*[@id='mirca-rpt']/div[6]/table/tbody/tr[6]/td[1]");
	public By Path2HTMLTable5Column1Title = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[2]/table/thead/tr/th[1]");
	public By Path2HTMLTable5Column2Title = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[2]/table/thead/tr/th[2]");
	public By Path2HTMLTable5Row1 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[2]/table/tbody/tr/td[1]/strong");
	public By Path3HTMLTable5Title = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[1]");
	public By Path3HTMLTable5Column1Title = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[2]/table/thead/tr/th[1]");
	public By Path3HTMLTable5Column2Title = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[2]/table/thead/tr/th[2]");
	public By Path3HTMLTable5Row1Column2 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[2]/table/tbody/tr/td[2]");

	public By Path2HTMLTable6Title = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[3]/div[1]");
	public By Path2HTMLTable6SubTitle1Part1 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[3]/div[2]/div/span[1]");
	public By Path2HTMLTable6SubTitle1Part2 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[3]/div[2]/div/span[2]");
	public By Path2HTMLTable6SubTitle2 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[3]/div[2]/div[2]/span[1]");
	public By HTMLTable6Title = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[1]");
	public By HTMLTable6Column1Title = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/table/thead/tr/th[1]");
	public By HTMLTable6Column2Title = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/table/thead/tr/th[2]");
	public By HTMLTable6Row1Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/table/tbody/tr/td[2]");
	public By Path2HTMLTable6Column1Title = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[3]/div[2]/table/thead/tr/th[1]");
	public By Path2HTMLTable6Column2Title = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[3]/div[2]/table/thead/tr/th[2]");
	public By Path2HTMLTable6Column3Title = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[3]/div[2]/table/thead/tr/th[3]");
	public By Path2HTMLTable6Column4Title = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[3]/div[2]/table/thead/tr/th[4]");
	public By Path2HTMLTable6Row1Column1 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[3]/div[2]/table/tbody/tr[1]/td[1]");
	public By Path2HTMLTable6Row1Column2 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[3]/div[2]/table/tbody/tr[1]/td[2]");
	public By Path2HTMLTable6Row1Column3 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[3]/div[2]/table/tbody/tr[1]/td[3]");
	public By Path2HTMLTable6Row2Column1 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[3]/div[2]/table/tbody/tr[2]/td[1]");
	public By Path2HTMLTable6Row2Column2 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[3]/div[2]/table/tbody/tr[2]/td[2]");
	public By Path2HTMLTable6Row2Column3 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[3]/div[2]/table/tbody/tr[2]/td[3]");
	public By Path2HTMLTable6Row3Column1 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[3]/div[2]/table/tbody/tr[3]/td[1]");
	public By Path2HTMLTable6Row3Column2 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[3]/div[2]/table/tbody/tr[3]/td[2]");
	public By Path2HTMLTable6Row3Column3 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[3]/div[2]/table/tbody/tr[3]/td[3]");
	public By Path2HTMLTable6Row4Column1 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[3]/div[2]/table/tbody/tr[4]/td[1]");
	public By Path2HTMLTable6Row4Column2 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[3]/div[2]/table/tbody/tr[4]/td[2]");
	public By Path2HTMLTable6Row4Column3 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[3]/div[2]/table/tbody/tr[4]/td[3]");
	public By Path2HTMLTable6Row5Column1 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[3]/div[2]/table/tbody/tr[5]/td[1]");
	public By Path2HTMLTable6Row5Column2 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[3]/div[2]/table/tbody/tr[5]/td[2]");
	public By Path2HTMLTable6Row5Column3 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[3]/div[2]/table/tbody/tr[5]/td[3]");
	public By Path2HTMLTable6Row6Column1 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[3]/div[2]/table/tbody/tr[6]/td[1]");
	public By Path2HTMLTable6Row6Column2 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[3]/div[2]/table/tbody/tr[6]/td[2]");
	public By Path2HTMLTable6Row6Column3 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[3]/div[2]/table/tbody/tr[6]/td[3]");
	public By Path3HTMLTable6Title = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[3]");/*
	public By Path3HTMLTable6SubTitle1 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[3]/div[2]/div[1]/span[1]");
	public By Path3HTMLTable6SubTitle2Part1 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[3]/div[2]/div[2]/span[1]");
	public By Path3HTMLTable6SubTitle2Part2 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[3]/div[2]/div[2]/span[2]");
	public By Path3HTMLTable6Column1Title = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[3]/div[2]/table/thead/tr/th[1]");
	public By Path3HTMLTable6Column2Title = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[3]/div[2]/table/thead/tr/th[2]");
	public By Path3HTMLTable6Column3Title = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[3]/div[2]/table/thead/tr/th[3]");
	public By Path3HTMLTable6Column4Title = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[3]/div[2]/table/thead/tr/th[4]");
	public By Path3HTMLTable6Row1 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[3]/div[2]/table/tbody/tr[1]/td[1]");
	public By Path3HTMLTable6Row2 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[3]/div[2]/table/tbody/tr[2]/td[1]");
	public By Path3HTMLTable6Row3 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[3]/div[2]/table/tbody/tr[3]/td[1]");
	public By Path3HTMLTable6Row4 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[3]/div[2]/table/tbody/tr[4]/td[1]");
	public By Path3HTMLTable6Row5 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[3]/div[2]/table/tbody/tr[5]/td[1]");
	public By Path3HTMLTable6Row6 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[3]/div[2]/table/tbody/tr[6]/td[1]");*/

	public By HTMLTable7Title = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[1]");
	public By HTMLTable7SubTitle1 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/div[1]/span[1]");
	public By HTMLTable7SubTitle2Part1 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/div[2]/span[1]");
	public By HTMLTable7SubTitle2Part2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/div[2]/span[2]");
	public By HTMLTable7Column1Title = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/thead/tr/th[1]");
	public By HTMLTable7Column2Title = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/thead/tr/th[2]");
	public By HTMLTable7Column3Title = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/thead/tr/th[3]");
	public By HTMLTable7Column4Title = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/thead/tr/th[4]");
	public By HTMLTable7Row1 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[1]/td[1]");
	public By HTMLTable7Row2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[2]/td[1]");
	public By HTMLTable7Row3 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[3]/td[1]");
	public By HTMLTable7Row4 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[4]/td[1]");
	public By HTMLTable7Row5 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[5]/td[1]");
	public By HTMLTable7Row6 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[6]/td[1]");
	public By Path3HTMLTable7Title = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[4]/div[1]");
	public By Path3HTMLTable7SubTitle1 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[4]/div[2]");
	public By Path3HTMLTable7SubTitle2 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[4]/div[3]/div[1]/span[1]");
	public By Path3HTMLTable7SubTitle3Part1 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[4]/div[3]/div[2]/span[1]");
	public By Path3HTMLTable7SubTitle3Part2 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[4]/div[3]/div[2]/span[2]");
	public By Path3HTMLTable7Column1Title = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[4]/div[3]/table/thead/tr/th[1]");
	public By Path3HTMLTable7Column2Title = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[4]/div[3]/table/thead/tr/th[2]");
	public By Path3HTMLTable7Column3Title = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[4]/div[3]/table/thead/tr/th[3]");
	public By Path3HTMLTable7Row1Column1 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[4]/div[3]/table/tbody/tr[1]/td[1]");
	public By Path3HTMLTable7Row1Column2 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[4]/div[3]/table/tbody/tr[1]/td[2]");
	public By Path3HTMLTable7Row2Column1 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[4]/div[3]/table/tbody/tr[2]/td[1]");
	public By Path3HTMLTable7Row2Column2 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[4]/div[3]/table/tbody/tr[2]/td[2]");
	public By Path3HTMLTable7Row3Column1 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[4]/div[3]/table/tbody/tr[3]/td[1]");
	public By Path3HTMLTable7Row3Column2 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[4]/div[3]/table/tbody/tr[3]/td[2]");
	public By Path3HTMLTable7Row4Column1 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[4]/div[3]/table/tbody/tr[4]/td[1]");
	public By Path3HTMLTable7Row4Column2 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[4]/div[3]/table/tbody/tr[4]/td[2]");
	public By Path3HTMLTable7Row5Column1 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[4]/div[3]/table/tbody/tr[5]/td[1]");
	public By Path3HTMLTable7Row5Column2 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[4]/div[3]/table/tbody/tr[5]/td[2]");
	public By Path3HTMLTable7Row6Column1 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[4]/div[3]/table/tbody/tr[6]/td[1]");
	public By Path3HTMLTable7Row6Column2 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[4]/div[3]/table/tbody/tr[6]/td[2]");
	public By Path3HTMLTable7Row7Column1 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[4]/div[3]/table/tbody/tr[7]/td[1]");
	public By Path3HTMLTable7Row7Column2 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[4]/div[3]/table/tbody/tr[7]/td[2]");

	public By HTMLTable8Title = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[1]");
	public By HTMLTable8SubTitle1 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[2]");
	public By HTMLTable8SubTitle2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[3]/div[1]/span[1]");
	public By HTMLTable8SubTitle3Part1 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[3]/div[2]/span[1]");
	public By HTMLTable8SubTitle3Part2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[3]/div[2]/span[2]");
	public By HTMLTable8Column1Title = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[3]/table/thead/tr/th[1]");
	public By HTMLTable8Column2Title = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[3]/table/thead/tr/th[2]");
	public By HTMLTable8Column3Title = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[3]/table/thead/tr/th[3]");
	public By HTMLTable8Row1Column1 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[3]/table/tbody/tr[1]/td[1]");
	public By HTMLTable8Row1Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[3]/table/tbody/tr[1]/td[2]");
	public By HTMLTable8Row2Column1 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[3]/table/tbody/tr[2]/td[1]");
	public By HTMLTable8Row2Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[3]/table/tbody/tr[2]/td[2]");
	public By HTMLTable8Row3Column1 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[3]/table/tbody/tr[3]/td[1]");
	public By HTMLTable8Row3Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[3]/table/tbody/tr[3]/td[2]");
	public By HTMLTable8Row4Column1 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[3]/table/tbody/tr[4]/td[1]");
	public By HTMLTable8Row4Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[3]/table/tbody/tr[4]/td[2]");
	public By HTMLTable8Row5Column1 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[3]/table/tbody/tr[5]/td[1]");
	public By HTMLTable8Row5Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[3]/table/tbody/tr[5]/td[2]");
	public By HTMLTable8Row6Column1 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[3]/table/tbody/tr[6]/td[1]");
	public By HTMLTable8Row6Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[3]/table/tbody/tr[6]/td[2]");
	public By HTMLTable8Row7Column1 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[3]/table/tbody/tr[7]/td[1]");
	public By HTMLTable8Row7Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[3]/table/tbody/tr[7]/td[2]");
	public By Path3HTMLTable8Title1 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[1]");
	public By Path3HTMLTable8Title2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/div[1]/span[1]");
	public By Path3HTMLTable8Title3Part1 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/div[2]/span[1]");
	public By Path3HTMLTable8Title3Part2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/div[2]/span[2]");
	public By Path3HTMLTable8Column1Title = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/div[3]/table/thead/tr/th[1]");
	public By Path3HTMLTable8Column2Title = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/div[3]/table/thead/tr/th[2]");
	public By Path3HTMLTable8Row1 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/div[3]/table/tbody[1]/tr/td");

	public By Path3HTMLTable9Column1Title = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/div[4]/table/thead/tr/th[1]");
	public By Path3HTMLTable9Column2Title = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/div[4]/table/thead/tr/th[2]");
	public By Path3HTMLTable9Row1 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/div[4]/table/tbody[1]/tr/td");

	public By Path3HTMLTable10Column1Title = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/div[5]/table/thead/tr/th[1]");
	public By Path3HTMLTable10Column2Title = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/div[5]/table/thead/tr/th[2]");
	public By Path3HTMLTable10Row1 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/div[5]/table/tbody[1]/tr/td");

	public By Path3HTMLTable11Column1Title = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/div[6]/table/thead/tr/th[1]");
	public By Path3HTMLTable11Column2Title = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/div[6]/table/thead/tr/th[2]");
	public By Path3HTMLTable11Row1 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/div[6]/table/tbody[1]/tr/td");

	public By Path3HTMLTable12Column1Title = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/div[7]/table/thead/tr/th[1]");
	public By Path3HTMLTable12Column2Title = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/div[7]/table/thead/tr/th[2]");
	public By Path3HTMLTable12Column3Title = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/div[7]/table/thead/tr/th[3]");
	public By Path3HTMLTable12Row1Column1Part1 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/div[7]/table/tbody/tr/td[1]");
	public By Path3HTMLTable12Row1Column1Part2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/div[7]/table/tbody/tr/td[1]/div");
	public By Path3HTMLTable12Row1Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/div[7]/table/tbody/tr/td[2]/strong");

	public By Path3HTMLTable13Column1Title = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/div[8]/table/thead/tr/th[1]");
	public By Path3HTMLTable13Column2Title = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/div[8]/table/thead/tr/th[2]");
	public By Path3HTMLTable13Column3Title = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/div[8]/table/thead/tr/th[3]");
	public By Path3HTMLTable13Row1Column1Part1 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/div[8]/table/tbody/tr/td[1]");
	public By Path3HTMLTable13Row1Column1Part2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/div[8]/table/tbody/tr/td[1]/div");
	public By Path3HTMLTable13Row1Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/div[8]/table/tbody/tr/td[2]/strong");

	public By Path3HTMLTable14Title1 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[1]");
	public By Path3HTMLTable14Title2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/div[1]/span[1]");
	public By Path3HTMLTable14Title3Part1 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/div[2]/span[1]");
	public By Path3HTMLTable14Title3Part2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/div[2]/span[2]");
	public By Path3HTMLTable14Column1Title = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/thead/tr/th[1]");
	public By Path3HTMLTable14Column2Title = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/thead/tr/th[2]");
	public By Path3HTMLTable14Column3Title = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/thead/tr/th[3]");
	public By Path3HTMLTable14Row1 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[1]/td");
	public By Path3HTMLTable14Row2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[2]/td");
	public By Path3HTMLTable14Row3 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[3]/td");
	public By Path3HTMLTable14Row4 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[4]/td");
	public By Path3HTMLTable14Row5Column1Part1 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[5]/td[1]");
	public By Path3HTMLTable14Row5Column1Part2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[5]/td[1]/div");
	public By Path3HTMLTable14Row5Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[5]/td[2]/strong");
	public By Path3HTMLTable14Row6Column1 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[6]/td[1]");
	public By Path3HTMLTable14Row6Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[6]/td[2]/strong");
	public By Path3HTMLTable14Row6Column3 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[6]/td[3]/strong");
	public By Path3HTMLTable14Row7Column1 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[7]/td[1]");
	public By Path3HTMLTable14Row7Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[7]/td[2]/strong");
	public By Path3HTMLTable14Row7Column3 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[7]/td[3]/strong");
	public By Path3HTMLTable14Row8Column1 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[8]/td[1]");
	public By Path3HTMLTable14Row8Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[8]/td[2]/strong");
	public By Path3HTMLTable14Row8Column3 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]/div[2]/table/tbody/tr[8]/td[3]/strong");

	public By Path3HTMLTable15SUEPTitle = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[1]");
	public By Path3HTMLTable15SUEP_S = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[2]/span[2]");
	public By Path3HTMLTable15SUEP_U = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[3]/span[2]");
	public By Path3HTMLTable15SUEP_E = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[4]/span[2]");
	public By Path3HTMLTable15SUEP_P = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[5]/span[2]");
	public By Path3HTMLTable15Column1Title = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[6]/table/thead/tr/th[1]");
	public By Path3HTMLTable15Column6Title = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[6]/table/thead/tr/th[6]");
	public By Path3HTMLTable15Row1 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[6]/table/tbody/tr[1]/td/strong");
	public By Path3HTMLTable15Row2Column1 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[6]/table/tbody/tr[2]/td[1]");
	public By Path3HTMLTable15Row2Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[6]/table/tbody/tr[2]/td[2]/strong");
	public By Path3HTMLTable15Row2Column3 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[6]/table/tbody/tr[2]/td[3]/strong");
	public By Path3HTMLTable15Row2Column4 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[6]/table/tbody/tr[2]/td[4]/strong");
	public By Path3HTMLTable15Row2Column5 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[6]/table/tbody/tr[2]/td[5]/strong");
	public By Path3HTMLTable15Row3 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[6]/table/tbody/tr[3]/td[1]");
	public By Path3HTMLTable15Row4 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[6]/table/tbody/tr[4]/td[1]");
	public By Path3HTMLTable15Row5 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/div[6]/table/tbody/tr[5]/td[1]");

	public By HTMLSkippedStep3Message = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[3]");
	public By HTMLSkippedStep4Message = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]");
	public By HTMLSkippedStep5Message = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[5]");
	public By HTMLSkippedStep6Message = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[6]");
	public By HTMLSkippedStep7Message = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]");
	public By Path2HTMLSkippedStep4MessagePart1 = By.xpath(".//*[@id='mirca-rpt']/div[7]");
	//public By Path2HTMLSkippedStep4MessagePart2 = By.xpath(".//*[@id='mirca-rpt']/div[6]/div[4]/div[2]");
	public By Path2HTMLSkippedStep5Message = By.xpath(".//*[@id='mirca-rpt']/div[8]");
	public By Path2HTMLSkippedStep6Message = By.xpath(".//*[@id='mirca-rpt']/div[9]");
	public By Path2HTMLSkippedStep7Message = By.xpath(".//*[@id='mirca-rpt']/div[10]");

	public By HTMLTable9Heading = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[8]/div");
	public By HTMLTable9Row1Column1 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[8]/table/tbody/tr[1]/td[1]");
	public By HTMLTable9Row1Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[8]/table/tbody/tr[1]/td[2]");
	public By HTMLTable9Row2Column1 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[8]/table/tbody/tr[2]/td[1]");
	public By HTMLTable9Row2Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[8]/table/tbody/tr[2]/td[2]");
	public By HTMLTable9Row3Column1 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[8]/table/tbody/tr[3]/td[1]");
	public By HTMLTable9Row3Column2 = By.xpath(".//*[@id='mirca-rpt']/div[7]/div[8]/table/tbody/tr[3]/td[2]");
}
