import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class OPiRCAChinese {
	
	SoftAssertions softly = new SoftAssertions();

	//Main module links
	By OPiRCALink = By.id("pii-a-menu-opirca");
	
	//Event Info page
	By OPiRCAEventTitleError = By.id("pii-opa-event-title-error");
	By OPiRCAEventLocationError = By.id("pii-opa-event-location-error");
	By OPiRCAEventProblemStatementError = By.id("pii-opa-event-pbstatement-error");
	By OPiRCAEventTimelineError = By.id("pii-opa-event-events-error");
	By OPiRCAEventBackgroundError = By.id("pii-opa-event-bginfos-error");
	By OPiRCAEventInvestigatorError = By.id("pii-opa-event-investigators-error");

	By OPiRCAInfoPageTitle = By.id("efi-opa-message");
	By OPiRCAInfoPageDesc = By.id("efi-opa-question");
	By OPiRCAEventTitleLabel = By.id("pii-opa-event-title-label");
	By OPiRCAEventIdLabel = By.xpath(".//*[@for='pii-opa-event-crnumber']");
	By OPiRCAEventIdField = By.id("pii-opa-event-crnumber");
	By OPiRCAEventLocationLabel = By.xpath(".//*[@for='pii-opa-event-location']");
	By OPiRCAEventDateLabel = By.xpath(".//*[@for='pii-opa-event-date']");
	By OPiRCAEventTimeLabel = By.xpath(".//*[@for='pii-opa-event-time']");
	By OPiRCAEventProblemStatementLabel = By.xpath(".//*[@for='pii-opa-event-pbstatement']");
	By OPiRCAEventExecutiveSummaryLabel = By.xpath(".//*[@for='pii-opa-event-execsummary']");
	By OPiRCAEventExecutiveSummaryField = By.id("pii-opa-event-execsummary");
	By OPiRCAEventTimelineOfEventLabel = By.xpath(".//*[@for='pii-opa-event-events']");
	By OPiRCAEventBackgroundInfoLabel = By.xpath(".//*[@for='pii-opa-event-bginfos']");
	By OPiRCAEventInvestigatorLabel = By.xpath(".//*[@for='pii-opa-event-investigators']");
	By OPiRCAReportCreationDateTimeLabel = By.xpath(".//*[@for='pii-opa-event-repdatetime']");
	
	//Step 1
	By OPiRCAStep1TitleAboveDropdown = By.xpath(".//*[@id='efi-opa-answers']/div[1]/div[1]");
	By OPiRCAStep1TitleBelowDropdown = By.xpath(".//*[@id='efi-opa-answers']/div[2]/div[1]");
	By OPiRCAHiRCALevelOption31 = By.xpath(".//*[@id='pii-opa-step1-select']/option[2]");
	By OPiRCAHiRCALevelOption32 = By.xpath(".//*[@id='pii-opa-step1-select']/option[3]");
	By OPiRCAHiRCALevelOption331 = By.xpath(".//*[@id='pii-opa-step1-select']/option[4]");
	By OPiRCAHiRCALevelOption332 = By.xpath(".//*[@id='pii-opa-step1-select']/option[5]");
	By OPiRCAHiRCALevelOption333 = By.xpath(".//*[@id='pii-opa-step1-select']/option[6]");
	By OPiRCAHiRCALevelOption334 = By.xpath(".//*[@id='pii-opa-step1-select']/option[7]");
	By OPiRCAHiRCALevelOption335 = By.xpath(".//*[@id='pii-opa-step1-select']/option[8]");
	By OPiRCAHiRCALevelOption336 = By.xpath(".//*[@id='pii-opa-step1-select']/option[9]");
	By OPiRCAHiRCALevelOption337 = By.xpath(".//*[@id='pii-opa-step1-select']/option[10]");
	By OPiRCAHiRCALevelOption338 = By.xpath(".//*[@id='pii-opa-step1-select']/option[11]");
	By OPiRCAHiRCALevelOption339 = By.xpath(".//*[@id='pii-opa-step1-select']/option[12]");
	By OPiRCAHiRCALevelOption3310 = By.xpath(".//*[@id='pii-opa-step1-select']/option[13]");
	By OPiRCAHiRCALevelOption34 = By.xpath(".//*[@id='pii-opa-step1-select']/option[14]");
	By OPiRCAHiRCALevelOption35 = By.xpath(".//*[@id='pii-opa-step1-select']/option[15]");
	By OPiRCAHiRCALevelOption36 = By.xpath(".//*[@id='pii-opa-step1-select']/option[16]");
	By OPiRCAHiRCALevelOption37 = By.xpath(".//*[@id='pii-opa-step1-select']/option[17]");
	By OPiRCAHiRCALevelOption38 = By.xpath(".//*[@id='pii-opa-step1-select']/option[18]");
	By OPiRCAHiRCALevelOption39 = By.xpath(".//*[@id='pii-opa-step1-select']/option[19]");
	By OPiRCAHiRCALevelOption310 = By.xpath(".//*[@id='pii-opa-step1-select']/option[20]");
	By OPiRCAHiRCALevelOption311 = By.xpath(".//*[@id='pii-opa-step1-select']/option[21]");
	By OPiRCAHiRCALevelOption312 = By.xpath(".//*[@id='pii-opa-step1-select']/option[22]");
	By OPiRCAHiRCALevelOption313 = By.xpath(".//*[@id='pii-opa-step1-select']/option[23]");
	By OPiRCAHiRCALevelOption314 = By.xpath(".//*[@id='pii-opa-step1-select']/option[24]");
	By OPiRCAHiRCALevelOption315 = By.xpath(".//*[@id='pii-opa-step1-select']/option[25]");
	By OPiRCAHiRCALevelOption316 = By.xpath(".//*[@id='pii-opa-step1-select']/option[26]");
	By OPiRCAHiRCALevelOption317 = By.xpath(".//*[@id='pii-opa-step1-select']/option[27]");
	By OPiRCAHiRCALevelOption318 = By.xpath(".//*[@id='pii-opa-step1-select']/option[28]");
	By OPiRCAHiRCALevelOption319 = By.xpath(".//*[@id='pii-opa-step1-select']/option[29]");
	By OPiRCAHiRCALevelOption320 = By.xpath(".//*[@id='pii-opa-step1-select']/option[30]");
	By OPiRCAHiRCALevelOption321 = By.xpath(".//*[@id='pii-opa-step1-select']/option[31]");
	By OPiRCAHiRCALevelOption322 = By.xpath(".//*[@id='pii-opa-step1-select']/option[32]");
	By OPiRCAApparentCauseO1 = By.xpath(".//*[@id='pii-opa-step1-causes']/ul/li[1]");
	By OPiRCAApparentCauseO3 = By.xpath(".//*[@id='pii-opa-step1-causes']/ul/li[2]");
	By OPiRCAApparentCauseO4 = By.xpath(".//*[@id='pii-opa-step1-causes']/ul/li[3]");
	By OPiRCAApparentCauseO5 = By.xpath(".//*[@id='pii-opa-step1-causes']/ul/li[4]");
	By OPiRCAApparentCauseOO1 = By.xpath(".//*[@id='pii-opa-step1-causes']/ul/li[5]");
	By OPiRCAApparentCauseOO2 = By.xpath(".//*[@id='pii-opa-step1-causes']/ul/li[6]");
	By OPiRCAApparentCauseOO3 = By.xpath(".//*[@id='pii-opa-step1-causes']/ul/li[7]");
	By OPiRCAApparentCauseOP1 = By.xpath(".//*[@id='pii-opa-step1-causes']/ul/li[8]");
	By OPiRCAApparentCauseOP2 = By.xpath(".//*[@id='pii-opa-step1-causes']/ul/li[9]");
	By OPiRCAApparentCauseOP3 = By.xpath(".//*[@id='pii-opa-step1-causes']/ul/li[10]");
	By OPiRCAApparentCauseOP4 = By.xpath(".//*[@id='pii-opa-step1-causes']/ul/li[11]");
	By OPiRCAApparentCauseP1 = By.xpath(".//*[@id='pii-opa-step1-causes']/ul/li[12]");
	By OPiRCAApparentCauseP2 = By.xpath(".//*[@id='pii-opa-step1-causes']/ul/li[13]");
	By OPiRCAApparentCauseP3 = By.xpath(".//*[@id='pii-opa-step1-causes']/ul/li[14]");
	By OPiRCAApparentCauseP4 = By.xpath(".//*[@id='pii-opa-step1-causes']/ul/li[15]");
	By OPiRCAApparentCauseP5 = By.xpath(".//*[@id='pii-opa-step1-causes']/ul/li[16]");
	
	//Apparent Causes in Step 1
	By OPiRCAApparentCauseAnswer1 = By.xpath(".//*[@for='efi-opa-answer-0']");
	By OPiRCAApparentCauseAnswer2 = By.xpath(".//*[@for='efi-opa-answer-1']");
	By OPiRCAApparentCauseAnswer3 = By.xpath(".//*[@for='efi-opa-answer-2']");
	By OPiRCAApparentCauseAnswer4 = By.xpath(".//*[@for='efi-opa-answer-3']");
	By OPiRCAApparentCauseAnswer5 = By.xpath(".//*[@for='efi-opa-answer-4']");
	By OPiRCAApparentCauseAnswer6 = By.xpath(".//*[@for='efi-opa-answer-5']");
	By OPiRCAApparentCauseAnswer7 = By.xpath(".//*[@for='efi-opa-answer-6']");
	By OPiRCAApparentCauseAnswer8 = By.xpath(".//*[@for='efi-opa-answer-7']");
	By OPiRCAApparentCauseAnswer9 = By.xpath(".//*[@for='efi-opa-answer-8']");
	By OPiRCAApparentCauseAnswer10 = By.xpath(".//*[@for='efi-opa-answer-9']");
	By OPiRCAApparentCauseAnswer11 = By.xpath(".//*[@for='efi-opa-answer-10']");
	By OPiRCAApparentCauseAnswerEvidenceEntry1 = By.xpath(".//*[@id='efi-opa-evidence-text-div-0']/h4/a");
	By OPiRCAApparentCauseAnswerCorrectiveAction1 = By.xpath(".//*[@id='efi-opa-answers']/div[1]/fieldset/div[1]/div[2]/div[2]/h4/a");
	By OPiRCAApparentCauseAnswerCorrectiveAction1Text1 = By.xpath(".//*[@id='efi-opa-answers']/div[1]/fieldset/div[1]/div[2]/div[2]/div/ul/ul/li[1]");
	By OPiRCAApparentCauseAnswerCorrectiveAction1Text2 = By.xpath(".//*[@id='efi-opa-answers']/div[1]/fieldset/div[1]/div[2]/div[2]/div/ul/ul/li[2]");
	By OPiRCAApparentCauseAnswerCorrectiveAction1Text3 = By.xpath(".//*[@id='efi-opa-answers']/div[1]/fieldset/div[1]/div[2]/div[2]/div/ul/ul/li[3]");
	By OPiRCAApparentCauseAnswerCorrectiveAction1Text4 = By.xpath(".//*[@id='efi-opa-answers']/div[1]/fieldset/div[1]/div[2]/div[2]/div/ul/ul/li[4]");
	By OPiRCAApparentCauseAnswerEvidenceEntry2 = By.xpath(".//*[@id='efi-opa-evidence-text-div-1']/h4/a");
	By OPiRCAApparentCauseAnswerCorrectiveAction2 = By.xpath(".//*[@id='efi-opa-answers']/div[2]/fieldset/div[1]/div[2]/div[2]/h4/a");
	By OPiRCAApparentCauseAnswerCorrectiveAction2Text1 = By.xpath(".//*[@id='efi-opa-answers']/div[2]/fieldset/div[1]/div[2]/div[2]/div/ul/ul/li[1]");
	By OPiRCAApparentCauseAnswerCorrectiveAction2Text2 = By.xpath(".//*[@id='efi-opa-answers']/div[2]/fieldset/div[1]/div[2]/div[2]/div/ul/ul/li[2]");
	By OPiRCAApparentCauseAnswerCorrectiveAction2Text3 = By.xpath(".//*[@id='efi-opa-answers']/div[2]/fieldset/div[1]/div[2]/div[2]/div/ul/ul/li[3]");
	By OPiRCAApparentCauseAnswerCorrectiveAction2Text4 = By.xpath(".//*[@id='efi-opa-answers']/div[2]/fieldset/div[1]/div[2]/div[2]/div/ul/ul/li[4]");
	By OPiRCAApparentCauseAnswerEvidenceEntry3 = By.xpath(".//*[@id='efi-opa-evidence-text-div-2']/h4/a");
	By OPiRCAApparentCauseAnswerCorrectiveAction3 = By.xpath(".//*[@id='efi-opa-answers']/div[3]/fieldset/div[1]/div[2]/div[2]/h4/a");
	By OPiRCAApparentCauseAnswerCorrectiveAction3Text1 = By.xpath(".//*[@id='efi-opa-answers']/div[3]/fieldset/div[1]/div[2]/div[2]/div/ul/ul/li[1]");
	By OPiRCAApparentCauseAnswerCorrectiveAction3Text2 = By.xpath(".//*[@id='efi-opa-answers']/div[3]/fieldset/div[1]/div[2]/div[2]/div/ul/ul/li[2]");
	By OPiRCAApparentCauseAnswerCorrectiveAction3Text3 = By.xpath(".//*[@id='efi-opa-answers']/div[3]/fieldset/div[1]/div[2]/div[2]/div/ul/ul/li[3]");
	By OPiRCAApparentCauseAnswerEvidenceEntry4 = By.xpath(".//*[@id='efi-opa-evidence-text-div-3']/h4/a");
	By OPiRCAApparentCauseAnswerCorrectiveAction4 = By.xpath(".//*[@id='efi-opa-answers']/div[4]/fieldset/div[1]/div[2]/div[2]/h4/a");
	By OPiRCAApparentCauseAnswerCorrectiveAction4Text1 = By.xpath(".//*[@id='efi-opa-answers']/div[4]/fieldset/div[1]/div[2]/div[2]/div/ul/ul/li[1]");
	By OPiRCAApparentCauseAnswerCorrectiveAction4Text2 = By.xpath(".//*[@id='efi-opa-answers']/div[4]/fieldset/div[1]/div[2]/div[2]/div/ul/ul/li[2]");
	By OPiRCAApparentCauseAnswerCorrectiveAction4Text3 = By.xpath(".//*[@id='efi-opa-answers']/div[4]/fieldset/div[1]/div[2]/div[2]/div/ul/ul/li[3]");
	By OPiRCAApparentCauseAnswerEvidenceEntry5 = By.xpath(".//*[@id='efi-opa-evidence-text-div-4']/h4/a");
	By OPiRCAApparentCauseAnswerCorrectiveAction5 = By.xpath(".//*[@id='efi-opa-answers']/div[5]/fieldset/div[1]/div[2]/div[2]/h4/a");
	By OPiRCAApparentCauseAnswerCorrectiveAction5Text1 = By.xpath(".//*[@id='efi-opa-answers']/div[5]/fieldset/div[1]/div[2]/div[2]/div/ul/ul/li[1]");
	By OPiRCAApparentCauseAnswerCorrectiveAction5Text2 = By.xpath(".//*[@id='efi-opa-answers']/div[5]/fieldset/div[1]/div[2]/div[2]/div/ul/ul/li[2]");
	By OPiRCAApparentCauseAnswerCorrectiveAction5Text3 = By.xpath(".//*[@id='efi-opa-answers']/div[5]/fieldset/div[1]/div[2]/div[2]/div/ul/ul/li[3]");
	By OPiRCAApparentCauseAnswerEvidenceEntry6 = By.xpath(".//*[@id='efi-opa-evidence-text-div-5']/h4/a");
	By OPiRCAApparentCauseAnswerCorrectiveAction6 = By.xpath(".//*[@id='efi-opa-answers']/div[6]/fieldset/div[1]/div[2]/div[2]/h4/a");
	By OPiRCAApparentCauseAnswerCorrectiveAction6Text1 = By.xpath(".//*[@id='efi-opa-answers']/div[6]/fieldset/div[1]/div[2]/div[2]/div/ul/ul/li[1]");
	By OPiRCAApparentCauseAnswerCorrectiveAction6Text2 = By.xpath(".//*[@id='efi-opa-answers']/div[6]/fieldset/div[1]/div[2]/div[2]/div/ul/ul/li[2]");
	By OPiRCAApparentCauseAnswerCorrectiveAction6Text3 = By.xpath(".//*[@id='efi-opa-answers']/div[6]/fieldset/div[1]/div[2]/div[2]/div/ul/ul/li[3]");
	By OPiRCAApparentCauseAnswerEvidenceEntry7 = By.xpath(".//*[@id='efi-opa-evidence-text-div-6']/h4/a");
	By OPiRCAApparentCauseAnswerCorrectiveAction7 = By.xpath(".//*[@id='efi-opa-answers']/div[7]/fieldset/div[1]/div[2]/div[2]/h4/a");
	By OPiRCAApparentCauseAnswerCorrectiveAction7Text1 = By.xpath(".//*[@id='efi-opa-answers']/div[7]/fieldset/div[1]/div[2]/div[2]/div/ul/ul/li[1]");
	By OPiRCAApparentCauseAnswerCorrectiveAction7Text2 = By.xpath(".//*[@id='efi-opa-answers']/div[7]/fieldset/div[1]/div[2]/div[2]/div/ul/ul/li[2]");
	By OPiRCAApparentCauseAnswerCorrectiveAction7Text3 = By.xpath(".//*[@id='efi-opa-answers']/div[7]/fieldset/div[1]/div[2]/div[2]/div/ul/ul/li[3]");
	By OPiRCAApparentCauseAnswerCorrectiveAction7Text4 = By.xpath(".//*[@id='efi-opa-answers']/div[7]/fieldset/div[1]/div[2]/div[2]/div/ul/ul/li[4]");
	By OPiRCAApparentCauseAnswerEvidenceEntry8 = By.xpath(".//*[@id='efi-opa-evidence-text-div-7']/h4/a");
	By OPiRCAApparentCauseAnswerCorrectiveAction8 = By.xpath(".//*[@id='efi-opa-answers']/div[8]/fieldset/div[1]/div[2]/div[2]/h4/a");
	By OPiRCAApparentCauseAnswerCorrectiveAction8Text1 = By.xpath(".//*[@id='efi-opa-answers']/div[8]/fieldset/div[1]/div[2]/div[2]/div/ul/ul/li[1]");
	By OPiRCAApparentCauseAnswerCorrectiveAction8Text2 = By.xpath(".//*[@id='efi-opa-answers']/div[8]/fieldset/div[1]/div[2]/div[2]/div/ul/ul/li[2]");
	By OPiRCAApparentCauseAnswerEvidenceEntry9 = By.xpath(".//*[@id='efi-opa-evidence-text-div-8']/h4/a");
	By OPiRCAApparentCauseAnswerCorrectiveAction9 = By.xpath(".//*[@id='efi-opa-answers']/div[9]/fieldset/div[1]/div[2]/div[2]/h4/a");
	By OPiRCAApparentCauseAnswerCorrectiveAction9Text = By.xpath(".//*[@id='efi-opa-answers']/div[9]/fieldset/div[1]/div[2]/div[2]/div/ul/ul/li");
	By OPiRCAApparentCauseAnswerEvidenceEntry10 = By.xpath(".//*[@id='efi-opa-evidence-text-div-9']/h4/a");
	By OPiRCAApparentCauseAnswerCorrectiveAction10 = By.xpath(".//*[@id='efi-opa-answers']/div[10]/fieldset/div[1]/div[2]/div[2]/h4/a");
	By OPiRCAApparentCauseAnswerCorrectiveAction10Text = By.xpath(".//*[@id='efi-opa-answers']/div[10]/fieldset/div[1]/div[2]/div[2]/div/ul/ul/li");
	By OPiRCAApparentCauseAnswerEvidenceEntry11 = By.xpath(".//*[@id='efi-opa-evidence-text-div-10']/h4/a");
	By OPiRCAApparentCauseAnswerCorrectiveAction11 = By.xpath(".//*[@id='efi-opa-answers']/div[11]/fieldset/div[1]/div[2]/div[2]/h4/a");
	By OPiRCAApparentCauseAnswerCorrectiveAction11Text = By.xpath(".//*[@id='efi-opa-answers']/div[11]/fieldset/div[1]/div[2]/div[2]/div/ul/ul/li");
	By OPiRCANewContributingFactorField1Label = By.xpath(".//*[@for='pii-opa-addnewcf-cf']");
	By OPiRCANewContributingFactorField2Label = By.xpath(".//*[@for='pii-opa-addnewcf-ca']");
	By OPiRCANewContributingFactorField2 = By.id("pii-opa-addnewcf-ca");
	
	//Step 2
	By OPiRCAReasonEntryLabel = By.xpath(".//*[@for='pii-opa-reason-entry']");
	By OPiRCAReasonEntryField = By.id("pii-opa-reason-entry");
	
	//Step 3
	By OPiRCAStep3SURETableTitle = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[1]/th[1]");
	By OPiRCAStep3SURETableEntry1 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[2]/td[1]");
	By OPiRCAStep3SURETableEntry1Checkbox1 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[2]/td[2]/div/input");
	By OPiRCAStep3SURETableEntry1Checkbox2 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[2]/td[3]/div/input");
	By OPiRCAStep3SURETableEntry1Checkbox3 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[2]/td[4]/div/input");
	By OPiRCAStep3SURETableEntry1Checkbox4 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[2]/td[5]/div/input");
	By OPiRCAStep3SURETableEntry2 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[3]/td[1]");
	By OPiRCAStep3SURETableEntry3 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[4]/td[1]");
	By OPiRCAStep3SURETableEntry4 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[5]/td[1]");
	By OPiRCAStep3SURETableEntry5 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[6]/td[1]");
	By OPiRCAStep3SURETableEntry6 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[7]/td[1]");
	By OPiRCAStep3SURETableEntry7 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[8]/td[1]");
	By OPiRCAStep3SURETableEntry8 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[9]/td[1]");
	By OPiRCAStep3SURETableEntry9 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[10]/td[1]");
	By OPiRCAStep3SURETableEntry10 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[11]/td[1]");
	By OPiRCAStep3SURETableEntry11 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[12]/td[1]");
	By OPiRCAStep3SURETableEntry12 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[13]/td[1]");
	By OPiRCAStep3SURETableEntry13 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[14]/td[1]");
	By OPiRCAStep3SURETableEntry14 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[15]/td[1]");
	By OPiRCAStep3SURETableEntry15 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[16]/td[1]");
	By OPiRCAStep3SURETableEntry16 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[17]/td[1]");
	By OPiRCAStep3SURETableEntry17 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[18]/td[1]");
	By OPiRCAStep3SURETableEntry18 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[19]/td[1]");
	By OPiRCAStep3SURETableEntry19 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[20]/td[1]");
	By OPiRCAStep3SURETableEntry20 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[21]/td[1]");
	By OPiRCAStep3SURETableEntry21 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[22]/td[1]");
	By OPiRCAStep3SURETableEntry22 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[23]/td[1]");
	By OPiRCAStep3SURETableEntry23 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[24]/td[1]");
	By OPiRCAStep3SURETableEntry24 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[25]/td[1]");
	By OPiRCAStep3SURETableEntry25 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[26]/td[1]");
	By OPiRCAStep3SURETableEntry26 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[27]/td[1]");
	By OPiRCAStep3SURETableEntry27 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[28]/td[1]");
	By OPiRCAStep3SURETableEntry28 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[29]/td[1]");
	By OPiRCAStep3SURETableEntry29 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[30]/td[1]");
	By OPiRCAStep3SURETableEntry30 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[31]/td[1]");
	By OPiRCAStep3SURETableEntry31 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[32]/td[1]");
	By OPiRCAStep3SURETableEntry32 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[33]/td[1]");
	By OPiRCAStep3SURETableEntry33 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[34]/td[1]");
	By OPiRCAStep3SURETableEntry34 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[35]/td[1]");
	By OPiRCAStep3SURETableEntry35 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[36]/td[1]");
	By OPiRCAStep3SURETableEntry36 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[37]/td[1]");
	By OPiRCAStep3SURETableEntry37 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[38]/td[1]");
	By OPiRCAStep3SURETableEntry38 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[39]/td[1]");
	By OPiRCAStep3SURETableEntry39 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[40]/td[1]");
	By OPiRCAStep3SURETableEntry40 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[41]/td[1]");
	By OPiRCAStep3SURETableEntry41 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[42]/td[1]");
	By OPiRCAStep3SURETableEntry42 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[43]/td[1]");
	By OPiRCAStep3SURETableEntry43 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[44]/td[1]");
	By OPiRCAStep3SURETableEntry44 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[45]/td[1]");
	By OPiRCAStep3SURETableEntry45 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[46]/td[1]");
	By OPiRCAStep3SURETableEntry46 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[47]/td[1]");
	By OPiRCAStep3SURETableEntry47 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[48]/td[1]");
	By OPiRCAStep3SURETableEntry48 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[49]/td[1]");
	By OPiRCAStep3SURETableEntry49 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[50]/td[1]");
	By OPiRCAStep3SURETableEntry50 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[51]/td[1]");
	By OPiRCAStep3SURETableEntry51 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[52]/td[1]");
	By OPiRCAStep3SURETableEntry52 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[53]/td[1]");
	By OPiRCAStep3SURETableEntry53 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[54]/td[1]");
	By OPiRCAStep3SURETableEntry54 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[55]/td[1]");
	By OPiRCAStep3SURETableEntry55 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[56]/td[1]");
	By OPiRCAStep3SURETableEntry56 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[57]/td[1]");
	By OPiRCAStep3SURETableEntry57 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[58]/td[1]");
	By OPiRCAStep3SURETableEntry58 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[59]/td[1]");
	By OPiRCAStep3SURETableEntry59 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[60]/td[1]");
	By OPiRCAStep3SURETableEntry60 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[61]/td[1]");
	By OPiRCAStep3SURETableEntry61 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[62]/td[1]");
	By OPiRCAStep3SURETableEntry62 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[63]/td[1]");
	By OPiRCAStep3SURETableEntry63 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[64]/td[1]");
	By OPiRCAStep3SURETableEntry64 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[65]/td[1]");
	By OPiRCAStep3SURETableEntry65 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[66]/td[1]");
	By OPiRCAStep3SURETableEntry66 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[67]/td[1]");
	By OPiRCAStep3SURETableEntry67 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[68]/td[1]");
	By OPiRCAStep3SURETableEntry68 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[69]/td[1]");
	By OPiRCAStep3SURETableEntry69 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[70]/td[1]");
	By OPiRCAStep3SURETableEntry70 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[71]/td[1]");
	By OPiRCAStep3SURETableEntry71 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[72]/td[1]");
	By OPiRCAStep3SURETableEntry72 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[73]/td[1]");
	By OPiRCAStep3SURETableEntry73 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[74]/td[1]");
	By OPiRCAStep3SURETableEntry74 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[75]/td[1]");
	By OPiRCAStep3SURETableEntry75 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[76]/td[1]");
	By OPiRCAStep3SURETableEntry76 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[77]/td[1]");
	By OPiRCAStep3SURETableEntry77 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[78]/td[1]");
	By OPiRCAStep3SURETableEntry78 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[79]/td[1]");
	By OPiRCAStep3SURETableEntry79 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[80]/td[1]");
	By OPiRCAStep3SURETableEntry80 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[81]/td[1]");
	By OPiRCAStep3SURETableEntry81 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[82]/td[1]");
	By OPiRCAStep3SURETableEntry82 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[83]/td[1]");
	By OPiRCAStep3SURETableEntry83 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[84]/td[1]");
	By OPiRCAStep3SURETableEntry84 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[85]/td[1]");
	By OPiRCAStep3SURETableEntry85 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[86]/td[1]");
	By OPiRCAStep3SURETableEntry86 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[87]/td[1]");
	By OPiRCAStep3SURETableEntry87 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[88]/td[1]");
	By OPiRCAStep3SURETableEntry88 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[89]/td[1]");
	By OPiRCAStep3SURETableEntry89 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[90]/td[1]");
	By OPiRCAStep3SURETableEntry90 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[91]/td[1]");
	By OPiRCAStep3SURETableEntry91 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[92]/td[1]");
	By OPiRCAStep3SURETableEntry92 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[93]/td[1]");
	By OPiRCAStep3SURETableEntry93 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[94]/td[1]");
	By OPiRCAStep3SURETableEntry94 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[95]/td[1]");
	By OPiRCAStep3SURETableEntry95 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[96]/td[1]");
	By OPiRCAStep3SURETableEntry96 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[97]/td[1]");
	By OPiRCAStep3SURETableEntry97 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[98]/td[1]");
	By OPiRCAStep3SURETableEntry98 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[99]/td[1]");
	By OPiRCAStep3SURETableEntry99 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[100]/td[1]");
	By OPiRCAStep3SURETableEntry100 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[101]/td[1]");
	By OPiRCAStep3SURETableEntry101 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[102]/td[1]");
	By OPiRCAStep3SURETableEntry102 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[103]/td[1]");
	By OPiRCAStep3SURETableEntry103 = By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[104]/td[1]");
	
	//Save pop up
	By OPiRCASavePopupTitle = By.id("pii-opa-dialog-header");
	By OPiRCASaveCancelButton = By.id("pii-opa-dialog-cancel");

	
	public void OPiRCApath (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		OPiRCA obj = new OPiRCA();
		EiRCAChinese obj1 = new EiRCAChinese();
		OPiRCAChinese2 obj2 = new OPiRCAChinese2(); 
		OPiRCAChinese3 obj3 = new OPiRCAChinese3();
		HiRCALevel1 obj4 = new HiRCALevel1();
	  	//Click on Analysis
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.AnalysisLink)).click();
		//Clicks on OPiRCA
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCALink)).click();
	  	//Scroll down
    	Thread.sleep(1000);
    	jse.executeScript("scroll(0,1500)");	 
    	Thread.sleep(1000);
    	//Click next
    	wait.until(ExpectedConditions.visibilityOfElementLocated(obj.OPiRCANextButtonAtBottomOfInfoTab)).click();
    	//Scroll top
    	Thread.sleep(1000);
    	jse.executeScript("scroll(0,0)");	 
    	Thread.sleep(1000);
		//Verify everything on Event Information page is in 
		chineseInfoPage(driver);
    	//Verify errors in Chinese
    	chineseErrorsInfoPage(driver);
    	//Create a new OPiRCA report 
	  	chineseEventInfoFill(driver);
	  	Thread.sleep(1000);
	  	//Verify step 1
	  	chineseOPiRCAStep1(driver);
	  	Thread.sleep(1000);
	  	//Select all HiRCA Level 3 Options
	  	selectAllHiRCALevel3Options(driver);
	  	Thread.sleep(1000);
	  	//Verify chinese for all apparent causes selected
	  	chineseApparentCauses(driver);
	  	Thread.sleep(1000);
		//Clicks on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.OPiRCANextButton)).click();
		Thread.sleep(1000);
		//Verify chinese O1
		chineseApparentCauseO1(driver);
		Thread.sleep(1000);
		//Select all O1
		selectAllApparentCausesAnswers(driver);
		Thread.sleep(1000);
		//Verify chinese O3
		chineseApparentCauseO3(driver);
		//Select all O3
		selectAllApparentCausesAnswers(driver);
		Thread.sleep(1000);
		//Verify chinese O4
		chineseApparentCauseO4(driver);
		//Select all O4
		selectAllApparentCausesAnswers(driver);
		Thread.sleep(1000);
		//Verify chinese O5
		chineseApparentCauseO5(driver);
		//Select all O5
		selectAllApparentCausesAnswers(driver);
		Thread.sleep(1000);
		//Verify chinese OO1
		chineseApparentCauseOO1(driver);
		//Select all OO1
		selectAllApparentCausesAnswers(driver);
		Thread.sleep(1000);
		//Verify chinese OO2
		chineseApparentCauseOO2(driver);
		//Select all OO2
		selectAllApparentCausesAnswers(driver);
		Thread.sleep(1000);
		//Verify chinese OO3
		chineseApparentCauseOO3(driver);
		//Select all OO3
		selectAllApparentCausesAnswers(driver);
		Thread.sleep(1000);
		//Verify chinese OP1
		chineseApparentCauseOP1(driver);
		//Select all OP1
		selectAllApparentCausesAnswers(driver);
		Thread.sleep(1000);
		//Verify chinese OP2
		chineseApparentCauseOP2(driver);
		//Select all OP2
		selectAllApparentCausesAnswers(driver);
		Thread.sleep(1000);
		//Verify chinese OP3
		chineseApparentCauseOP3(driver);
		//Select all OP3
		selectAllApparentCausesAnswers(driver);
		Thread.sleep(1000);
		//Verify chinese OP4
		chineseApparentCauseOP4(driver);
		//Select all OP4
		selectAllApparentCausesAnswers(driver);
		Thread.sleep(1000);
		//Verify chinese P1
		chineseApparentCauseP1(driver);
		//Select all P1
		selectAllApparentCausesAnswers(driver);
		Thread.sleep(1000);
		//Verify chinese P2
		chineseApparentCauseP2(driver);
		//Select all P2
		selectAllApparentCausesAnswers(driver);
		Thread.sleep(1000);
		//Verify chinese P3
		chineseApparentCauseP3(driver);
		//Select all P3
		selectAllApparentCausesAnswers(driver);
		Thread.sleep(1000);
		//Verify chinese P4
		chineseApparentCauseP4(driver);
		//Select all P4
		selectAllApparentCausesAnswers(driver);
		Thread.sleep(1000);
		//Verify chinese P5
		chineseApparentCauseP5(driver);
		//Select all P5
		selectAllApparentCausesAnswers(driver);
		Thread.sleep(1000);
		//Verify chinese D1
		chineseStep2D1(driver);
		//Click skip
    	wait.until(ExpectedConditions.visibilityOfElementLocated(obj.OPiRCASkipButton)).click();
    	Thread.sleep(1000);
		//Verify chinese D2
		chineseStep2D2(driver);
		//Click skip
    	wait.until(ExpectedConditions.visibilityOfElementLocated(obj.OPiRCASkipButton)).click();
    	Thread.sleep(1000);
		//Verify chinese D3
		chineseStep2D3(driver);
		//Click skip
    	wait.until(ExpectedConditions.visibilityOfElementLocated(obj.OPiRCASkipButton)).click();
    	Thread.sleep(1000);
		//Verify chinese D4
		chineseStep2D4(driver);
		//Click skip
    	wait.until(ExpectedConditions.visibilityOfElementLocated(obj.OPiRCASkipButton)).click();
    	Thread.sleep(1000);
		//Verify chinese D5
		chineseStep2D5(driver);
		//Click skip
    	wait.until(ExpectedConditions.visibilityOfElementLocated(obj.OPiRCASkipButton)).click();
    	Thread.sleep(1000);
		//Verify chinese D6
		chineseStep2D6(driver);
		//Click skip
    	wait.until(ExpectedConditions.visibilityOfElementLocated(obj.OPiRCASkipButton)).click();
    	Thread.sleep(1000);
		//Verify chinese D7
		chineseStep2D7(driver);
		//Click skip
    	wait.until(ExpectedConditions.visibilityOfElementLocated(obj.OPiRCASkipButton)).click();
    	Thread.sleep(1000);
		//Verify chinese D8
		chineseStep2D8(driver);
		//Click skip
    	wait.until(ExpectedConditions.visibilityOfElementLocated(obj.OPiRCASkipButton)).click();
    	Thread.sleep(1000);
		//Verify chinese D9
		chineseStep2D9(driver);
		//Click skip
    	wait.until(ExpectedConditions.visibilityOfElementLocated(obj.OPiRCASkipButton)).click();
    	Thread.sleep(1000);
		//Verify chinese D10
		chineseStep2D10(driver);
		//Click skip
    	wait.until(ExpectedConditions.visibilityOfElementLocated(obj.OPiRCASkipButton)).click();
    	Thread.sleep(1000);
		//Verify chinese D11
		chineseStep2D11(driver);
		//Click skip
    	wait.until(ExpectedConditions.visibilityOfElementLocated(obj.OPiRCASkipButton)).click();
    	Thread.sleep(1000);
		//Verify chinese D12
		chineseStep2D12(driver);
		//Click skip
    	wait.until(ExpectedConditions.visibilityOfElementLocated(obj.OPiRCASkipButton)).click();
    	Thread.sleep(1000);
    	//Verify chinese Step 3
    	chineseStep3SURE(driver);
    	//Mark checkboxes in Step 3 SURE table
    	markSUREcheckboxes(driver);
    	//Click on next
    	wait.until(ExpectedConditions.visibilityOfElementLocated(obj.OPiRCANextButton)).click();    
    	Thread.sleep(1000);
    	//Verify Step 4
    	obj2.chineseStep4(driver,softly);
    	//Check 3 HML boxes
    	obj2.checkStep4HMLBoxes(driver);
    	//Click on next
    	wait.until(ExpectedConditions.visibilityOfElementLocated(obj.OPiRCANextButton)).click();  
    	Thread.sleep(1000);
    	//Verify Step 5
    	obj2.chineseStep5(driver,softly);
    	//Select 1st checkbox in Step 5
    	wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.OPiRCAStep5TableRow1Column3)).click();
    	//Click on next
    	wait.until(ExpectedConditions.visibilityOfElementLocated(obj.OPiRCANextButton)).click();
    	Thread.sleep(1000);
    	//Chinese verify report tab
    	obj2.chineseReportTab(driver,softly);
    	Thread.sleep(1000);
    	//Mark critical
    	markCritical(driver);
    	//Chinese verify HTML report
    	List <String> verifyChinese=obj3.chineseHTMLReport(driver,softly);
    	Thread.sleep(1000);
    	//Download report
    	obj2.downloadReport(driver,verifyChinese, softly);
    	//Delete report
    	obj4.deleteReport(driver);
	}
	
    public void markCritical(WebDriver driver) throws Exception{
    	
    	WebDriverWait wait1 = new WebDriverWait(driver,60);
    	OPiRCA obj = new OPiRCA();
    	ShareCheck obj1 = new ShareCheck();
	    //Clicks on Save
	    wait1.until(ExpectedConditions.visibilityOfElementLocated(obj.OPiRCASaveButton)).click();
	    //Verify chinese in save box
	    chineseSavePopup(driver);
		//Clicks on Save report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(obj.OPiRCASavePopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(obj.OPiRCASaveConfirmButton)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(obj.StickySuccess));
		//Wait for loading message
		obj1.loadingServer(driver);
		Thread.sleep(1000);
	    //Clicks on Saved activities
		wait1.until(ExpectedConditions.visibilityOfElementLocated(obj.OPiRCASavedActivitiesButton)).click();
		Thread.sleep(2000);		  
		//Wait for loading message
		obj1.loadingServer(driver);
		//Click on new record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(obj.OPiRCAFirstRecord)).click();
		//Wait for loading message
		obj1.loadingServer(driver);
		String s = wait1.until(ExpectedConditions.visibilityOfElementLocated(obj.MarkCritical)).getText();
		softly.assertThat(s).as("test data").contains("重要");
    	//Clicks on mark critical
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(obj.MarkCritical)).click();
    	//Clicks on confirm change
		wait1.until(ExpectedConditions.visibilityOfElementLocated(obj.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(obj.ConfirmPopupButton)).click();
		//Checks if marked critical
		String critical=wait1.until(ExpectedConditions.visibilityOfElementLocated(obj.OPIRCAMarkCriticalIndicatorText)).getText();
		softly.assertThat(critical).as("test data").contains("重要");
		String c1=wait1.until(ExpectedConditions.visibilityOfElementLocated(obj.OPIRCAMarkCriticalIndicatorText1)).getText();
		softly.assertThat(c1).as("test data").contains("事件信息");
    }
    
	public void chineseSavePopup (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		OPiRCA obj = new OPiRCA ();
    	//Title of popup
    	String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCASavePopupTitle)).getText();
    	softly.assertThat(s1).as("test data").isEqualTo("保存报告");
    	//Popup message title
    	String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.OPiRCASavePopupTitle)).getText();
    	softly.assertThat(s2).as("test data").isEqualTo("请确认你要存入现有报告进度?");
    	//Confirm button
    	String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.OPiRCASaveConfirmButton)).getText();
    	softly.assertThat(s3).as("test data").isEqualTo("保存报告");
    	//Cancel button
    	String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCASaveCancelButton)).getText();
    	softly.assertThat(s4).as("test data").isEqualTo("取消");
	}
		
    public void markSUREcheckboxes(WebDriver driver) throws Exception{
    	
    	WebDriverWait wait = new WebDriverWait(driver,5);
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
    	//Scroll to top
		Thread.sleep(2000);
		jse.executeScript("scroll(0,0)");
		Thread.sleep(2000);
		//Click on all 4 boxes for 1st Apparent cause
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry1Checkbox1)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry1Checkbox2)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry1Checkbox3)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry1Checkbox4)).click();
		//Scroll up
		jse.executeScript("scroll(0,0)");
		Thread.sleep(2000);
    }
	
    public void chineseStep3SURE(WebDriver driver) throws Exception{
    	
    	WebDriverWait wait = new WebDriverWait(driver,5);
    	OPiRCA obj = new OPiRCA();
		//question
		String opirca_desc = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAInfoPageDesc)).getText();
		softly.assertThat(opirca_desc).as("test data").contains("第三步 - 判别根本原因");
		//SURE expansion
		//S
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.SField)).getText();
		softly.assertThat(s).as("test data").contains(": 是否存在不合标准的实践?");
		//U
		String u = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.UField)).getText();
		softly.assertThat(u).as("test data").contains(": 是否在管理层控制下?");
		//R
		String r = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.RField)).getText();
		softly.assertThat(r).as("test data").contains(": 是否可以降低概率?");
		//E
		String e = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.EField)).getText();
		softly.assertThat(e).as("test data").contains(": 不为其他促成因素的影响?");
		//Title of table
		String title = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableTitle)).getText();
		softly.assertThat(title).as("test data").contains("促成因素");
		//All apparent causes
		//1
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry1)).getText();
		softly.assertThat(s1).as("test data").contains("O1.1: 管理职能不足: (1) 职能协调人或经理不足; (2) 管理决策职能不足; (3) 问题解决职能不足; (4) 工作计划职能不足; (5) 资源分配职能不足; (6) 管理和人员培训职能不足; (7) 人力资源职能（或结构）不足");
		//2
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry2)).getText();
		softly.assertThat(s2).as("test data").contains("O1.2: 跨领域职能管理不足: (1) 职能协调人或经理不足; (2) 人因绩效提升职能不足; (3) 设备性能提升职能不足");
		//3
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry3)).getText();
		softly.assertThat(s3).as("test data").contains("O1.3: 三大组织—生产、监督和管理支持中的独立性不足，例如: (1) 允许纠正行动计划经理向生产相关经理汇报; (2) 允许QA经理出席根本原因审查委员会或者项目管理委员会; (3) 允许IT经理向监督组织经理汇报");
		//4
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry4)).getText();
		softly.assertThat(s4).as("test data").contains("O1.4: 生产组织结构不足，例如: (1) 执行核心工作流程的结构存在不足; (2) 不同生产线的结构分隔存在不足; (3) 班值存在不足");
		//5
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry5)).getText();
		softly.assertThat(s5).as("test data").contains("O1.5: 监督组织结构不足，例如: (1) 生产或管理支持相关管理团队的监督; (2) 生产经理以下管理层级的管理人员监督; (3) 监督结构未基于专业（例如无损试验、QA、QC等）");
		//6
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry6)).getText();
		softly.assertThat(s6).as("test data").contains("O1.6: 管理支持组织结构不足，例如: (1) 招聘结构不足; (2) 继任计划不足; (3) 培训或授权不足");
		//7
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry7)).getText();
		softly.assertThat(s7).as("test data").contains("O1.7: 区分短期和长期工作的组织结构存在不足，例如: (1) 一组工程人员处理短期和长期设计改造; (2) 一组维修人员处理紧急和非紧急工作");
		//8
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry8)).getText();
		softly.assertThat(s8).as("test data").contains("O1.8: 管理层级不足: (1) 规则型和技能型的小组层级过多; (2) 知识型小组层级不足");
		//9
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry9)).getText();
		softly.assertThat(s9).as("test data").contains("O1.9: 管理跨度不足 : (1) 向一位主管或经理汇报的人员过多; (2) 向一位主管或经理汇报的人员过少");
		//10
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry10)).getText();
		softly.assertThat(s10).as("test data").contains("O1.10: 组织设计和改进方面的领导参与存在不足: (1) 领导层未参与组织问题解决过程中; (2) 领导层未参与组织结构和职能设计中");
		//11
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry11)).getText();
		softly.assertThat(s11).as("test data").contains("O1.11: 管理职能方面的领导参与不足");
		//12
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry12)).getText();
		softly.assertThat(s12).as("test data").contains("O3.1: 缺少流程和程序设计、缺乏标准改进");
		//13
		String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry13)).getText();
		softly.assertThat(s13).as("test data").contains("O3.2: 缺少负责日常流程绩效的流程负责人");
		//14
		String s14 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry14)).getText();
		softly.assertThat(s14).as("test data").contains("O3.3: 流程程序设计导则存在不足");
		//15
		String s15 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry15)).getText();
		softly.assertThat(s15).as("test data").contains("O3.4: 流程改进存在不足: (1) 定期自评存在不足; (2)绩效跟踪和趋势分析存在不足; (3)流程失效的根本原因分析存在不足");
		//16
		String s16 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry16)).getText();
		softly.assertThat(s16).as("test data").contains("O3.5: 程序编写导则存在不足，未能有效且可靠地执行流程");
		//17
		String s17 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry17)).getText();
		softly.assertThat(s17).as("test data").contains("O3.6: 发展流程设计和改进能力方面存在不足: (1) 流程的失效模式与影响分析; (2) 功能设计; (3) 效率和可靠性优化; (4) 教学准备; (5) 流程试验和验证");
		//18
		String s18 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry18)).getText();
		softly.assertThat(s18).as("test data").contains("O3.7: 通过培训或指导来发展流程设计和改进能力");
		//19
		String s19 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry19)).getText();
		softly.assertThat(s19).as("test data").contains("O4.1: 高层管理的接口会议不足以处理共性问题");
		//20
		String s20 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry20)).getText();
		softly.assertThat(s20).as("test data").contains("O4.2: 中层管理的接口会议不足以处理共性问题");
		//21
		String s21 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry21)).getText();
		softly.assertThat(s21).as("test data").contains("O4.3: 工作层的接口会议不足以处理共性问题");
		//22
		String s22 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry22)).getText();
		softly.assertThat(s22).as("test data").contains("O4.4: 在使用公用跟踪系统记录各个组织之间情况管理或工作流程沟通方面存在不足");
		//23
		String s23 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry23)).getText();
		softly.assertThat(s23).as("test data").contains("O4.5: 组织中的垂直沟通存在不足，未能报告需要高层管理注意的问题");
		//24
		String s24 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry24)).getText();
		softly.assertThat(s24).as("test data").contains("O4.6: 向工作人员传达管理层期望和经验反馈方面存在不足");
		//25
		String s25 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry25)).getText();
		softly.assertThat(s25).as("test data").contains("O4.7: 由于激励和问责制度存在不足而造成移交（TO）、工前会（PJB）、工作期间会议（MJB）或班前会（PSM）的沟通存在不足");
		//26
		String s26 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry26)).getText();
		softly.assertThat(s26).as("test data").contains("O5.1: 技能不足以避免发生粗心大意的失误");
		//27
		String s27 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry27)).getText();
		softly.assertThat(s27).as("test data").contains("O5.2: 技能不足以遵守规则（例如程序、检查清单、工作现场提示信息、行为标准和不准做清单）");
		//28
		String s28 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry28)).getText();
		softly.assertThat(s28).as("test data").contains("O5.3: 主管和经理知识不足以防止自身的知识型错误");
		//29
		String s29 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry29)).getText();
		softly.assertThat(s29).as("test data").contains("O5.4: 流程设计和改进方面的管理知识不足: (1) 程序的逐步设计和改进方面存在不足; (2) 屏障的设计和改进方面存在不足; (3) 行为标准的设计和改进方面存在不足; (4) 不准做清单的设计和改进方面存在不足; (5) 检查清单的设计和改进方面存在不足; (6) 工作现场提示信息的设计和改进方面存在不足");
		//30
		String s30 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry30)).getText();
		softly.assertThat(s30).as("test data").contains("O5.5: 人因绩效管理方面的管理知识不足");
		//31
		String s31 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry31)).getText();
		softly.assertThat(s31).as("test data").contains("O5.6: 设备性能管理方面的管理知识不足");
		//32
		String s32 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry32)).getText();
		softly.assertThat(s32).as("test data").contains("OO1.1: QA和组织之间的共同目标/利益/问责机制的定义存在不足");
		//33
		String s33 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry33)).getText();
		softly.assertThat(s33).as("test data").contains("OO1.2: 组织间的共同目标/利益/问责机制的定义存在不足");
		//34
		String s34 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry34)).getText();
		softly.assertThat(s34).as("test data").contains("OO1.3: 高管和组织管理人员之间的共同目标/利益/问责机制存在不足: (1) 奖励制度不同且不一致; (2) 高管侧重于一个领域而让管理人员负责另一个领域");
		//35
		String s35 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry35)).getText();
		softly.assertThat(s35).as("test data").contains("OO1.4: 组织管理人员和主管之间的共同目标/利益/问责机制存在不足: (1) 问责体系不同; (2) 管理人员侧重于一个领域而让主管负责另一个领域");
		//36
		String s36 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry36)).getText();
		softly.assertThat(s36).as("test data").contains("OO1.5: 奖励和问责体系不足以建立共同目标/利益");
		//37
		String s37 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry37)).getText();
		softly.assertThat(s37).as("test data").contains("OO2.1: 组织管理人员共同规定的接口要求存在不足，例如数据传达、资源共享、解决跨组织问题等");
		//38
		String s38 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry38)).getText();
		softly.assertThat(s38).as("test data").contains("OO2.2: 接口流程和方法存在不足，例如会议形式、接口频率和沟通通道存在不足");
		//39
		String s39 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry39)).getText();
		softly.assertThat(s39).as("test data").contains("OO2.3: 由于位置过于分散而造成沟通不佳");
		//40
		String s40 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry40)).getText();
		softly.assertThat(s40).as("test data").contains("OO3.1: 两个独立的组织执行一个工作职能");
		//41
		String s41 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry41)).getText();
		softly.assertThat(s41).as("test data").contains("OO3.2: 没有要求两个接口部门执行所需的工作职能");
		//42
		String s42 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry42)).getText();
		softly.assertThat(s42).as("test data").contains("OP1.1: 人员配置和预算不足以实施制度或执行程序");
		//43
		String s43 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry43)).getText();
		softly.assertThat(s43).as("test data").contains("OP1.2: 相关人员的培训和授权不足以实施制度");
		//44
		String s44 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry44)).getText();
		softly.assertThat(s44).as("test data").contains("OP1.3: 管理层对制度落实行动的跟进存在不足");
		//45
		String s45 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry45)).getText();
		softly.assertThat(s45).as("test data").contains("OP1.4: 对落实制度的管理支持存在不足");
		//46
		String s46 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry46)).getText();
		softly.assertThat(s46).as("test data").contains("OP2.1: 先行指标存在不足");
		//47
		String s47 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry47)).getText();
		softly.assertThat(s47).as("test data").contains("OP2.2: 实时指标存在不足");
		//48
		String s48 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry48)).getText();
		softly.assertThat(s48).as("test data").contains("OP2.3: 滞后指标存在不足");
		//49
		String s49 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry49)).getText();
		softly.assertThat(s49).as("test data").contains("OP2.4: 管理层在绩效监督跟踪和趋势分析的结果使用方面存在不足");
		//50
		String s50 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry50)).getText();
		softly.assertThat(s50).as("test data").contains("OP2.5: 在将RCA共因分析作为监督工具方面存在不足");
		//51
		String s51 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry51)).getText();
		softly.assertThat(s51).as("test data").contains("OP2.6: 在使用现场观察结果作为监督工具方面存在不足");
		//52
		String s52 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry52)).getText();
		softly.assertThat(s52).as("test data").contains("OP3.1: 个人的自我分析存在不足");
		//53
		String s53 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry53)).getText();
		softly.assertThat(s53).as("test data").contains("OP3.2: 监督小组的自我分析存在不足");
		//54
		String s54 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry54)).getText();
		softly.assertThat(s54).as("test data").contains("OP3.3: 管理组织的自我分析存在不足");
		//55
		String s55 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry55)).getText();
		softly.assertThat(s55).as("test data").contains("OP3.4: 高风险制度或程序的自我评估存在不足");
		//56
		String s56 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry56)).getText();
		softly.assertThat(s56).as("test data").contains("OP3.5: 对组织事件的根本原因分析分析质量差、事件数据收集和启动调查条件存在不足");
		//57
		String s57 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry57)).getText();
		softly.assertThat(s57).as("test data").contains("OP3.6: 对组织事件的共因分析没有定期执行（不够频繁）或是共因分析质量差");
		//58
		String s58 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry58)).getText();
		softly.assertThat(s58).as("test data").contains("OP4.1: 制度或流程负责人规定方面存在不足");
		//59
		String s59 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry59)).getText();
		softly.assertThat(s59).as("test data").contains("OP4.2: 制度或流程相关人员的角色和责任规定方面存在不足");
		//60
		String s60 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry60)).getText();
		softly.assertThat(s60).as("test data").contains("OP4.3: 用于跟踪制度或流程责任经理绩效（时间、质量和成本）的问责机制存在不足");
		//61
		String s61 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry61)).getText();
		softly.assertThat(s61).as("test data").contains("OP4.4: 总经理层问责机制不存在不足: (1) 未能客观评量总经理层绩效; (2) 未考量所有投资方反馈");
		//62
		String s62 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry62)).getText();
		softly.assertThat(s62).as("test data").contains("P1.1: 由于未意识到风险，而造成制度、程序或屏障（LOP）的遗漏，例如: (1) 新兴高风险问题的危机管理制度; (2) O&P决策制定和问题解决的管理授权制度; (3) 技术审查人员的培训和授权制度; (4) 不道德或违法活动的匿名举报制度; (5) 对标、根本原因分析、自我评估");
		//63
		String s63 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry63)).getText();
		softly.assertThat(s63).as("test data").contains("P1.2: 由于未意识到风险，而造成行为标准的遗漏，例如: (1) 预防粗心大意的失误的行为标准; (2) 关键思考、关键追问和情况警觉的行为标准; (3) 程序使用的行为标准");
		//64
		String s64 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry64)).getText();
		softly.assertThat(s64).as("test data").contains("P1.3: 由于优先级不当而造成程序编写组织发布程序的时间推迟");
		//65
		String s65 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry65)).getText();
		softly.assertThat(s65).as("test data").contains("P1.4: 由于培训组织优先级划分不当而造成实施的推迟");
		//66
		String s66 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry66)).getText();
		softly.assertThat(s66).as("test data").contains("P1.5: 由于管理审查体系存在不足而造成制度、程序或屏障的遗漏");
		//67
		String s67 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry67)).getText();
		softly.assertThat(s67).as("test data").contains("P2.1: 由于程序编写导则存在不足，而造成要求不全面，例如条例、规范要求、用户和内部要求等");
		//68
		String s68 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry68)).getText();
		softly.assertThat(s68).as("test data").contains("P2.2: 验证程序的操作条件存在不足，例如: (1) 进入条件; (2) 退出条件; (3) 中止程序的条件");
		//69
		String s69 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry69)).getText();
		softly.assertThat(s69).as("test data").contains("P2.3: 由于程序编写导则存在不足，而造成程序执行期间要求进行验证的假设存在不足或被遗漏");
		//70
		String s70 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry70)).getText();
		softly.assertThat(s70).as("test data").contains("P2.4: 由于程序编写导则存在不足，而造成工作范围不充分，例如: (1) 逐步说明; (2) 逐项说明");
		//71
		String s71 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry71)).getText();
		softly.assertThat(s71).as("test data").contains("P2.5: 由于程序编写导则存在不足，而造成工后试验、测量或正确性验证方面存在不足");
		//72
		String s72 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry72)).getText();
		softly.assertThat(s72).as("test data").contains("P2.6: 缺少以下部分: (1) 目的说明; (2) 先决条件; (3) 术语定义; (4) 不准做清单经验反馈说明; (5) 参考文件; (6) 用户反馈请求");
		//73
		String s73 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry73)).getText();
		softly.assertThat(s73).as("test data").contains("P2.7: 由于审查存在不足而造成要素的遗漏");
		//74
		String s74 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry74)).getText();
		softly.assertThat(s74).as("test data").contains("P2.8: 由于根本原因分析不到位导致要素的遗漏");
		//75
		String s75 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry75)).getText();
		softly.assertThat(s75).as("test data").contains("P2.9: 由于纠正措施执行不到位导致要素的遗漏");
		//76
		String s76 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry76)).getText();
		softly.assertThat(s76).as("test data").contains("P3.1: 对制度外或程序外进行工作的指导存在不足");
		//77
		String s77 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry77)).getText();
		softly.assertThat(s77).as("test data").contains("P3.2: 由于程序编写导则存在不足，造成通过自检或独立检查单项弱点（SPV）步骤方面存在不足");
		//78
		String s78 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry78)).getText();
		softly.assertThat(s78).as("test data").contains("P3.3: 由于程序编写导则存在不足，造成审查先前不可逆点（PNR）行动方面存在不足");
		//79
		String s79 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry79)).getText();
		softly.assertThat(s79).as("test data").contains("P3.4: 由于程序编写导则存在不足，造成步骤、章节或页次的操作标记使用方面存在不足");
		//80
		String s80 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry80)).getText();
		softly.assertThat(s80).as("test data").contains("P3.5: 由于程序编写导则存在不足，造成使用不准做清单防止违章行为方面存在不足");
		//81
		String s81 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry81)).getText();
		softly.assertThat(s81).as("test data").contains("P3.6: 由于程序编写导则存在不足，造成使用工作现场提示信息防止例行工作出现粗心犯错方面存在不足");
		//82
		String s82 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry82)).getText();
		softly.assertThat(s82).as("test data").contains("P3.7: 由于程序编写导则存在不足，造成使用检查清单防止遗忘相关失误的方面存在不足");
		//83
		String s83 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry83)).getText();
		softly.assertThat(s83).as("test data").contains("P3.8: 由于程序编写导则存在不足，造成使用行为标准提供正面的同事压力以促使遵循规定方面存在不足");
		//84
		String s84 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry84)).getText();
		softly.assertThat(s84).as("test data").contains("P3.9: 由于审查不充分，造成存在偏差控制方面的不足");
		//85
		String s85 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry85)).getText();
		softly.assertThat(s85).as("test data").contains("P3.10: 由于根本原因分析不到位，造成存在偏差控制方面的不足");
		//86
		String s86 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry86)).getText();
		softly.assertThat(s86).as("test data").contains("P3.11: 由于纠正措施执行不到位，造成存在偏差控制方面的不足");
		//87
		String s87 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry87)).getText();
		softly.assertThat(s87).as("test data").contains("P4.1: 由于程序编写导则存在不足，使用需要解释或判断的词语，例如:过度、最大、最小、根据需要等");
		//88
		String s88 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry88)).getText();
		softly.assertThat(s88).as("test data").contains("P4.2: 由于程序编写导则存在不足，使用对一般程序用户而言缺少定义或解释的专业技术词汇");
		//89
		String s89 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry89)).getText();
		softly.assertThat(s89).as("test data").contains("P4.3: 由于程序编写导则存在不足，使用一般程序用户难以读懂的复杂和复合句");
		//90
		String s90 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry90)).getText();
		softly.assertThat(s90).as("test data").contains("P4.4: 由于程序编写导则存在不足，在缺少图纸、图片或图形的情况下描述复杂事物");
		//91
		String s91 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry91)).getText();
		softly.assertThat(s91).as("test data").contains("P4.5: 由于程序编写导则存在不足，使用需要解释的非描述性要求，例如:根据要求、根据需要等");
		//92
		String s92 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry92)).getText();
		softly.assertThat(s92).as("test data").contains("P4.6: 导则或说明存在错误: (1) 过时的导则; (2) 错误的导则或说明; (3) 程序中存在错误的步骤");
		//93
		String s93 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry93)).getText();
		softly.assertThat(s93).as("test data").contains("P4.7: 由于程序审查不充分，造成存在模糊或错误的说明");
		//94
		String s94 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry94)).getText();
		softly.assertThat(s94).as("test data").contains("P4.8: 设备的标识和识别不到位");
		//95
		String s95 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry95)).getText();
		softly.assertThat(s95).as("test data").contains("P5.1: 由于不相关要求造成不必要的工作");
		//96
		String s96 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry96)).getText();
		softly.assertThat(s96).as("test data").contains("P5.2: 没有对程序步骤进行优化，以确保效率和方便执行");
		//97
		String s97 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry97)).getText();
		softly.assertThat(s97).as("test data").contains("P5.3: 加重相关人员或小组不必要的差事（相关小组的多重任务）");
		//98
		String s98 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry98)).getText();
		softly.assertThat(s98).as("test data").contains("P5.4: 制定不必要的工作，而未提高质量，例如进行散弹枪式的根本原因分析，对未发生故障的设备制定不必要工作或制定预防性维修工作");
		//99
		String s99 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry99)).getText();
		softly.assertThat(s99).as("test data").contains("P5.5: 一个组织负责的职责若该由其他组织执行会更有效率");
		//100
		String s100 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry100)).getText();
		softly.assertThat(s100).as("test data").contains("P5.6: 为执行要求而开展不必要的工作，例如长途驱车至场外仓库取用常用工具，填写冗长的表格等");
		//101
		String s101 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry101)).getText();
		softly.assertThat(s101).as("test data").contains("P5.7: 审查人员人数过多，并且未规定角色和责任，导致各个审查员跳过审查，依赖其他人查找失误");
		//102
		String s102 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry102)).getText();
		softly.assertThat(s102).as("test data").contains("P5.8: 在使用软件和连通技术方面存在不足，例如进行RCA的智能电话制度、检查清单、工前会、数据搜索等");
		//103
		String s103 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep3SURETableEntry103)).getText();
		softly.assertThat(s103).as("test data").contains("P5.9: 使用过时且繁重的技术或工具来执行工作");
    }
	
    public void chineseStep2D12(WebDriver driver) throws Exception{
    	
    	WebDriverWait wait = new WebDriverWait(driver,5);
		//OPiRCA Page Title
		String opirca_title = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAInfoPageTitle)).getText();
		softly.assertThat(opirca_title).as("test data").contains("第二步：组织与制度根本原因分析");
		//question
		String opirca_desc = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAInfoPageDesc)).getText();
		softly.assertThat(opirca_desc).as("test data").contains("[D12] 主管人员是否在工作之前或工作期间识别并缓解单项弱点?");
		//Reason entry label
		String reasonEntryLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReasonEntryLabel)).getText();
		softly.assertThat(reasonEntryLabel).as("test data").contains("填写原因:");
		//Reason entry field
		String reasonEntryField = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(reasonEntryField).as("test data").contains("可输入选择原因");
		//Answer 1
		String a1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer1)).getText();
		softly.assertThat(a1).as("test data").contains("是");
		//Answer 2
		String a2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer2)).getText();
		softly.assertThat(a2).as("test data").contains("否，经理和主管对单项弱点管理的理解或认识存在不足");
		//Answer 3
		String a3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer3)).getText();
		softly.assertThat(a3).as("test data").contains("否，对单项弱点管理的理解和认识已经充分，但是，主管和人员未接受相应的培训");
		//Answer 4
		String a4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer4)).getText();
		softly.assertThat(a4).as("test data").contains("否，制度（即工前会、班前会、交代会等）中缺少识别和缓解单项弱点的相关内容");
    }
	
    public void chineseStep2D11(WebDriver driver) throws Exception{
    	
    	WebDriverWait wait = new WebDriverWait(driver,5);
		//OPiRCA Page Title
		String opirca_title = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAInfoPageTitle)).getText();
		softly.assertThat(opirca_title).as("test data").contains("第二步：组织与制度根本原因分析");
		//question
		String opirca_desc = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAInfoPageDesc)).getText();
		softly.assertThat(opirca_desc).as("test data").contains("[D11] 在现场的监督时间（＜20%）是否不足以与工作人员进行互动?");
		//Reason entry label
		String reasonEntryLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReasonEntryLabel)).getText();
		softly.assertThat(reasonEntryLabel).as("test data").contains("填写原因:");
		//Reason entry field
		String reasonEntryField = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(reasonEntryField).as("test data").contains("可输入选择原因");
		//Answer 1
		String a1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer1)).getText();
		softly.assertThat(a1).as("test data").contains("否");
		//Answer 2
		String a2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer2)).getText();
		softly.assertThat(a2).as("test data").contains("是，管理负担过重导致");
		//Answer 3
		String a3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer3)).getText();
		softly.assertThat(a3).as("test data").contains("是，缺少主管人员行为标准或存在不足导致");
    }
	
    public void chineseStep2D10(WebDriver driver) throws Exception{
    	
    	WebDriverWait wait = new WebDriverWait(driver,5);
		//OPiRCA Page Title
		String opirca_title = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAInfoPageTitle)).getText();
		softly.assertThat(opirca_title).as("test data").contains("第二步：组织与制度根本原因分析");
		//question
		String opirca_desc = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAInfoPageDesc)).getText();
		softly.assertThat(opirca_desc).as("test data").contains("[D10] 自我识别的事件数与总事件数的比是低还是高？");
		//Reason entry label
		String reasonEntryLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReasonEntryLabel)).getText();
		softly.assertThat(reasonEntryLabel).as("test data").contains("填写原因:");
		//Reason entry field
		String reasonEntryField = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(reasonEntryField).as("test data").contains("可输入选择原因");
		//Answer 1
		String a1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer1)).getText();
		softly.assertThat(a1).as("test data").contains("低 （小于0.2）");
		//Answer 2
		String a2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer2)).getText();
		softly.assertThat(a2).as("test data").contains("高（大于0.2）");
    }
	
    public void chineseStep2D9(WebDriver driver) throws Exception{
    	
    	WebDriverWait wait = new WebDriverWait(driver,5);
		//OPiRCA Page Title
		String opirca_title = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAInfoPageTitle)).getText();
		softly.assertThat(opirca_title).as("test data").contains("第二步：组织与制度根本原因分析");
		//question
		String opirca_desc = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAInfoPageDesc)).getText();
		softly.assertThat(opirca_desc).as("test data").contains("[D9] 共同目的是否用于管理人员和工作人员的奖惩体系?");
		//Reason entry label
		String reasonEntryLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReasonEntryLabel)).getText();
		softly.assertThat(reasonEntryLabel).as("test data").contains("填写原因:");
		//Reason entry field
		String reasonEntryField = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(reasonEntryField).as("test data").contains("可输入选择原因");
		//Answer 1
		String a1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer1)).getText();
		softly.assertThat(a1).as("test data").contains("是");
		//Answer 2
		String a2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer2)).getText();
		softly.assertThat(a2).as("test data").contains("否，管理人员对设计奖惩体系的认识存在不足");
		//Answer 3
		String a3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer3)).getText();
		softly.assertThat(a3).as("test data").contains("否， 问责、角色职责定义存在不足");
		//Answer 4
		String a4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer4)).getText();
		softly.assertThat(a4).as("test data").contains("否，绩效跟踪和趋势分析方面存在不足，奖惩体系中未使用关键绩效指标");
		//Answer 5
		String a5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer5)).getText();
		softly.assertThat(a5).as("test data").contains("否，共同目标/利益/问责机制存在不足");
    }
	
    public void chineseStep2D8(WebDriver driver) throws Exception{
    	
    	WebDriverWait wait = new WebDriverWait(driver,5);
		//OPiRCA Page Title
		String opirca_title = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAInfoPageTitle)).getText();
		softly.assertThat(opirca_title).as("test data").contains("第二步：组织与制度根本原因分析");
		//question
		String opirca_desc = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAInfoPageDesc)).getText();
		softly.assertThat(opirca_desc).as("test data").contains("[D8] 近期（＜1年）是否存在发生事件发生之前就已经知道其先兆但未进行管理的事件？");
		//Reason entry label
		String reasonEntryLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReasonEntryLabel)).getText();
		softly.assertThat(reasonEntryLabel).as("test data").contains("填写原因:");
		//Reason entry field
		String reasonEntryField = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(reasonEntryField).as("test data").contains("可输入选择原因");
		//Answer 1
		String a1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer1)).getText();
		softly.assertThat(a1).as("test data").contains("是");
		//Answer 2
		String a2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer2)).getText();
		softly.assertThat(a2).as("test data").contains("否");
    }
	
    public void chineseStep2D7(WebDriver driver) throws Exception{
    	
    	WebDriverWait wait = new WebDriverWait(driver,5);
		//OPiRCA Page Title
		String opirca_title = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAInfoPageTitle)).getText();
		softly.assertThat(opirca_title).as("test data").contains("第二步：组织与制度根本原因分析");
		//question
		String opirca_desc = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAInfoPageDesc)).getText();
		softly.assertThat(opirca_desc).as("test data").contains("[D7] 是否有大量积压项？");
		//Reason entry label
		String reasonEntryLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReasonEntryLabel)).getText();
		softly.assertThat(reasonEntryLabel).as("test data").contains("填写原因:");
		//Reason entry field
		String reasonEntryField = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(reasonEntryField).as("test data").contains("可输入选择原因");
		//Answer 1
		String a1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer1)).getText();
		softly.assertThat(a1).as("test data").contains("否");
		//Answer 2
		String a2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer2)).getText();
		softly.assertThat(a2).as("test data").contains("是，工作控制存在不足");
		//Answer 3
		String a3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer3)).getText();
		softly.assertThat(a3).as("test data").contains("是，制度要求过多，例如简单工作需要进行过多的审查");
		//Answer 4
		String a4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer4)).getText();
		softly.assertThat(a4).as("test data").contains("是，快速抢修制度存在不足");
    }
	
    public void chineseStep2D6(WebDriver driver) throws Exception{
    	
    	WebDriverWait wait = new WebDriverWait(driver,5);
		//OPiRCA Page Title
		String opirca_title = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAInfoPageTitle)).getText();
		softly.assertThat(opirca_title).as("test data").contains("第二步：组织与制度根本原因分析");
		//question
		String opirca_desc = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAInfoPageDesc)).getText();
		softly.assertThat(opirca_desc).as("test data").contains("[D6] 该问题是否是同一制度或组织中的重复性问题?");
		//Reason entry label
		String reasonEntryLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReasonEntryLabel)).getText();
		softly.assertThat(reasonEntryLabel).as("test data").contains("填写原因:");
		//Reason entry field
		String reasonEntryField = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(reasonEntryField).as("test data").contains("可输入选择原因");
		//Answer 1
		String a1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer1)).getText();
		softly.assertThat(a1).as("test data").contains("否");
		//Answer 2
		String a2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer2)).getText();
		softly.assertThat(a2).as("test data").contains("是， 监督与趋势存在不足");
		//Answer 3
		String a3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer3)).getText();
		softly.assertThat(a3).as("test data").contains("是，对问题解决的认识存在不足");
		//Answer 4
		String a4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer4)).getText();
		softly.assertThat(a4).as("test data").contains("是， 根本原因分析制度存在不足");
    }
	
    public void chineseStep2D5(WebDriver driver) throws Exception{
    	
    	WebDriverWait wait = new WebDriverWait(driver,5);
		//OPiRCA Page Title
		String opirca_title = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAInfoPageTitle)).getText();
		softly.assertThat(opirca_title).as("test data").contains("第二步：组织与制度根本原因分析");
		//question
		String opirca_desc = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAInfoPageDesc)).getText();
		softly.assertThat(opirca_desc).as("test data").contains("[D5] 会议是否占用人员过多的时间?");
		//Reason entry label
		String reasonEntryLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReasonEntryLabel)).getText();
		softly.assertThat(reasonEntryLabel).as("test data").contains("填写原因:");
		//Reason entry field
		String reasonEntryField = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(reasonEntryField).as("test data").contains("可输入选择原因");
		//Answer 1
		String a1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer1)).getText();
		softly.assertThat(a1).as("test data").contains("否");
		//Answer 2
		String a2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer2)).getText();
		softly.assertThat(a2).as("test data").contains("是，对执行知识型工作任务的认识存在不足导致");
		//Answer 3
		String a3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer3)).getText();
		softly.assertThat(a3).as("test data").contains("是，制度的问责、角色职责存在不足导致");
		//Answer 4
		String a4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer4)).getText();
		softly.assertThat(a4).as("test data").contains("是， O-O接口存在不足导致");
    }
	
    public void chineseStep2D4(WebDriver driver) throws Exception{
    	
    	WebDriverWait wait = new WebDriverWait(driver,5);
		//OPiRCA Page Title
		String opirca_title = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAInfoPageTitle)).getText();
		softly.assertThat(opirca_title).as("test data").contains("第二步：组织与制度根本原因分析");
		//question
		String opirca_desc = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAInfoPageDesc)).getText();
		softly.assertThat(opirca_desc).as("test data").contains("[D4] 每单位产量的生产成本（不包括返工成本）是否高于其他类似公司?");
		//Reason entry label
		String reasonEntryLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReasonEntryLabel)).getText();
		softly.assertThat(reasonEntryLabel).as("test data").contains("填写原因:");
		//Reason entry field
		String reasonEntryField = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(reasonEntryField).as("test data").contains("可输入选择原因");
		//Answer 1
		String a1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer1)).getText();
		softly.assertThat(a1).as("test data").contains("否");
		//Answer 2
		String a2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer2)).getText();
		softly.assertThat(a2).as("test data").contains("是，组织职能和结构存在不足导致");
		//Answer 3
		String a3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer3)).getText();
		softly.assertThat(a3).as("test data").contains("是，管理层在设计有效工作制度或流程方面的认识存在不足导致");
		//Answer 4
		String a4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer4)).getText();
		softly.assertThat(a4).as("test data").contains("是，缺少负责运行效率的经理导致");
		//Answer 5
		String a5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer5)).getText();
		softly.assertThat(a5).as("test data").contains("是，工作控制存在不足（工作流程效率不足）导致");
    }
	
    public void chineseStep2D3(WebDriver driver) throws Exception{
    	
    	WebDriverWait wait = new WebDriverWait(driver,5);
		//OPiRCA Page Title
		String opirca_title = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAInfoPageTitle)).getText();
		softly.assertThat(opirca_title).as("test data").contains("第二步：组织与制度根本原因分析");
		//question
		String opirca_desc = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAInfoPageDesc)).getText();
		softly.assertThat(opirca_desc).as("test data").contains("[D3] 返工率是否较高?");
		//Reason entry label
		String reasonEntryLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReasonEntryLabel)).getText();
		softly.assertThat(reasonEntryLabel).as("test data").contains("填写原因:");
		//Reason entry field
		String reasonEntryField = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(reasonEntryField).as("test data").contains("可输入选择原因");
		//Answer 1
		String a1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer1)).getText();
		softly.assertThat(a1).as("test data").contains("否");
		//Answer 2
		String a2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer2)).getText();
		softly.assertThat(a2).as("test data").contains("是，制度有遗漏导致");
		//Answer 3
		String a3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer3)).getText();
		softly.assertThat(a3).as("test data").contains("是，全面性不足导致");
		//Answer 4
		String a4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer4)).getText();
		softly.assertThat(a4).as("test data").contains("是，偏差控制不到位导致");
		//Answer 5
		String a5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer5)).getText();
		softly.assertThat(a5).as("test data").contains("是，明确性不足导致");
		//Answer 6
		String a6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer6)).getText();
		softly.assertThat(a6).as("test data").contains("是，不当的培训授权问责影响工作管理所导致");
    }
	
    public void chineseStep2D2(WebDriver driver) throws Exception{
    	
    	WebDriverWait wait = new WebDriverWait(driver,5);
		//OPiRCA Page Title
		String opirca_title = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAInfoPageTitle)).getText();
		softly.assertThat(opirca_title).as("test data").contains("第二步：组织与制度根本原因分析");
		//question
		String opirca_desc = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAInfoPageDesc)).getText();
		softly.assertThat(opirca_desc).as("test data").contains("[D2] 加班是否过多?");
		//Reason entry label
		String reasonEntryLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReasonEntryLabel)).getText();
		softly.assertThat(reasonEntryLabel).as("test data").contains("填写原因:");
		//Reason entry field
		String reasonEntryField = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(reasonEntryField).as("test data").contains("可输入选择原因");
		//Answer 1
		String a1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer1)).getText();
		softly.assertThat(a1).as("test data").contains("否");
		//Answer 2
		String a2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer2)).getText();
		softly.assertThat(a2).as("test data").contains("是，由于培训、授权、问责不足而在成效率不足");
		//Answer 3
		String a3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer3)).getText();
		softly.assertThat(a3).as("test data").contains("是，由于人员编制不足以支持制度工作");
		//Answer 4
		String a4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer4)).getText();
		softly.assertThat(a4).as("test data").contains("是，由于工作优先级划分存在不足");
		//Answer 5
		String a5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer5)).getText();
		softly.assertThat(a5).as("test data").contains("是，由于制度要求过多");
    }
	
    public void chineseStep2D1(WebDriver driver) throws Exception{
    	
    	WebDriverWait wait = new WebDriverWait(driver,5);
		//OPiRCA Page Title
		String opirca_title = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAInfoPageTitle)).getText();
		softly.assertThat(opirca_title).as("test data").contains("第二步：组织与制度根本原因分析");
		//question
		String opirca_desc = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAInfoPageDesc)).getText();
		softly.assertThat(opirca_desc).as("test data").contains("[D1] 每年的病假缺勤率（＞5%）是否较高？");
		//Reason entry label
		String reasonEntryLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReasonEntryLabel)).getText();
		softly.assertThat(reasonEntryLabel).as("test data").contains("填写原因:");
		//Reason entry field
		String reasonEntryField = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(reasonEntryField).as("test data").contains("可输入选择原因");
		//Answer 1
		String a1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer1)).getText();
		softly.assertThat(a1).as("test data").contains("否");
		//Answer 2
		String a2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer2)).getText();
		softly.assertThat(a2).as("test data").contains("是，组织内的问责体系（消极性vs积极性）存在不足导致");
		//Answer 3
		String a3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer3)).getText();
		softly.assertThat(a3).as("test data").contains("是，人员编制存在不足以及工作时间过长导致");
		//Answer 4
		String a4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer4)).getText();
		softly.assertThat(a4).as("test data").contains("是，管理层对加班和惩罚性管理方式的负面影响认识不足导致");
    }
	
    public void chineseApparentCauseP5(WebDriver driver) throws Exception{
    	
    	WebDriverWait wait = new WebDriverWait(driver,5);
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
    	OPiRCA obj = new OPiRCA();
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAInfoPageDesc)).getText();
		softly.assertThat(heading).as("test data").contains("要求过多");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionPlusSign)).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionText)).getText();
		softly.assertThat(desc).as("test data").contains("是否有证据表明需要进行非必要性工作以执行制度要求或者没有精简工作？如果是，请选择原因并且输入支持性证据。");
		softly.assertThat(desc).as("test data").contains("要求过多可能会导致由于负担、低效和士气低落而不合规。常见示例如：制度设计效率低、根本原因分析效率低、根本原因分析员资格授权存在不足、技术使用存在不足。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionPlusSign)).click();
		//P5.1 question
		String q1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer1)).getText();
		softly.assertThat(q1).as("test data").contains("[P5.1] 由于不相关要求造成不必要的工作");
		//Evidence entry collapsible text
		String e1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry1)).getText();
		softly.assertThat(e1).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).click();
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).getText();
		softly.assertThat(c1).as("test data").contains("可能的纠正行动");
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1Text1)).getText();
		softly.assertThat(c2).as("test data").contains("减少导则或程序中的负担");
		String c23 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1Text2)).getText();
		softly.assertThat(c23).as("test data").contains("开展Error-Free");
		softly.assertThat(c23).as("test data").contains("工作流程优化的培训");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).click();
		//P5.2 question
		String q2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer2)).getText();
		softly.assertThat(q2).as("test data").contains("[P5.2] 没有对程序步骤进行优化，以确保效率和方便执行");
		//Evidence entry collapsible text
		String e2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry2)).getText();
		softly.assertThat(e2).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).click();
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).getText();
		softly.assertThat(c3).as("test data").contains("可能的纠正行动");
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2Text1)).getText();
		softly.assertThat(c4).as("test data").contains("优化程序，以确保效率和方便执行");
		String c24 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2Text2)).getText();
		softly.assertThat(c24).as("test data").contains("开展Error-Free");
		softly.assertThat(c24).as("test data").contains("工作流程优化的培训");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).click();
		//P5.3 question
		String q3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer3)).getText();
		softly.assertThat(q3).as("test data").contains("[P5.3] 加重相关人员或小组不必要的差事（相关小组的多重任务）");
		//Evidence entry collapsible text
		String e3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry3)).getText();
		softly.assertThat(e3).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).click();
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).getText();
		softly.assertThat(c5).as("test data").contains("可能的纠正行动");
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3Text1)).getText();
		softly.assertThat(c6).as("test data").contains("避免同时进行多重任务");
		String c25 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3Text2)).getText();
		softly.assertThat(c25).as("test data").contains("开展Error-Free");
		softly.assertThat(c25).as("test data").contains("工作流程优化的培训");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).click();
		//P5.4 question
		String q4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer4)).getText();
		softly.assertThat(q4).as("test data").contains("[P5.4] 制定不必要的工作，而未提高质量，例如进行散弹枪式的根本原因分析，对未发生故障的设备制定不必要工作或制定预防性维修工作");
		//Evidence entry collapsible text
		String e4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry4)).getText();
		softly.assertThat(e4).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4)).click();
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4)).getText();
		softly.assertThat(c7).as("test data").contains("可能的纠正行动");
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4Text1)).getText();
		softly.assertThat(c8).as("test data").contains("改善根本原因分析流程");
		String c26 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4Text2)).getText();
		softly.assertThat(c26).as("test data").contains("改善预防性维修工作流程");
		String c31 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4Text3)).getText();
		softly.assertThat(c31).as("test data").contains("开展Error-Free");
		softly.assertThat(c31).as("test data").contains("工作流程优化的培训");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4)).click();
		//P5.5 question
		String q5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer5)).getText();
		softly.assertThat(q5).as("test data").contains("[P5.5] 一个组织负责的职责若该由其他组织执行会更有效率");
		//Evidence entry collapsible text
		String e5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry5)).getText();
		softly.assertThat(e5).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5)).click();
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5)).getText();
		softly.assertThat(c9).as("test data").contains("可能的纠正行动");
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5Text1)).getText();
		softly.assertThat(c10).as("test data").contains("组织改组以提高效率和绩效");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5)).click();
		//Scroll down
		Thread.sleep(1000);
		jse.executeScript("scroll(0,1500)");
		Thread.sleep(1000);
		//P5.6 question
		String q6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer6)).getText();
		softly.assertThat(q6).as("test data").contains("[P5.6] 为执行要求而开展不必要的工作，例如长途驱车至场外仓库取用常用工具，填写冗长的表格等");
		//Evidence entry collapsible text
		String e6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry6)).getText();
		softly.assertThat(e6).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction6)).click();
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction6)).getText();
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction6Text1)).getText();
		softly.assertThat(c12).as("test data").contains("减少导则或程序中的负担");
		String c28 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction6Text2)).getText();
		softly.assertThat(c28).as("test data").contains("开展Error-Free");
		softly.assertThat(c28).as("test data").contains("工作流程优化的培训");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction6)).click();
		//P5.7 question
		String q7 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer7)).getText();
		softly.assertThat(q7).as("test data").contains("[P5.7] 审查人员人数过多，并且未规定角色和责任，导致各个审查员跳过审查，依赖其他人查找失误");
		//Evidence entry collapsible text
		String e7 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry7)).getText();
		softly.assertThat(e7).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction7)).click();
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction7)).getText();
		softly.assertThat(c13).as("test data").contains("可能的纠正行动");
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction7Text1)).getText();
		softly.assertThat(c14).as("test data").contains("开展Error-Free");
		softly.assertThat(c14).as("test data").contains("工作流程优化的培训");
		String c29 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction7Text2)).getText();
		softly.assertThat(c29).as("test data").contains("开展审查培训");
		String c27 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction7Text3)).getText();
		softly.assertThat(c27).as("test data").contains("规定审查人员的角色和责任");
		String c32 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction7Text4)).getText();
		softly.assertThat(c32).as("test data").contains("对审查人员实行问责制");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction7)).click();
		//P5.8 question
		String q8 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer8)).getText();
		softly.assertThat(q8).as("test data").contains("[P5.8] 在使用软件和连通技术方面存在不足，例如进行RCA的智能电话制度、检查清单、工前会、数据搜索等");
		//Evidence entry collapsible text
		String e8 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry8)).getText();
		softly.assertThat(e8).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction8)).click();
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction8)).getText();
		softly.assertThat(c15).as("test data").contains("可能的纠正行动");
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction8Text1)).getText();
		softly.assertThat(c16).as("test data").contains("使用软件或智能电话技术跟踪沟通情况");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction8)).click();
		//P5.9 question
		String q9 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer9)).getText();
		softly.assertThat(q9).as("test data").contains("[P5.9] 使用过时且繁重的技术或工具来执行工作");
		//Evidence entry collapsible text
		String e9 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry9)).getText();
		softly.assertThat(e9).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction9)).click();
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction9)).getText();
		softly.assertThat(c17).as("test data").contains("可能的纠正行动");
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction9Text)).getText();
		softly.assertThat(c18).as("test data").contains("改进工作技术或工具");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction9)).click();
		//Contributing factor
		chineseOPiRCAContributingFactor(driver);
    }
	
    public void chineseApparentCauseP4(WebDriver driver) throws Exception{
    	
    	WebDriverWait wait = new WebDriverWait(driver,5);
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
    	OPiRCA obj = new OPiRCA();
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAInfoPageDesc)).getText();
		softly.assertThat(heading).as("test data").contains("明确性不足或不正确");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionPlusSign)).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionText)).getText();
		softly.assertThat(desc).as("test data").contains("是否由于现场决策的失误率较高，而使得制度或程序容易造成事件的发生？如果是，请选择原因并输入支持性证据");
		softly.assertThat(desc).as("test data").contains("当词语模糊，需要进行判断；技术词语缺少定义；配置说明缺少直观工具或者说明错误明显时，明显存在明确性不足或规则不正确情况。常见示例包括：在规则或程序中经常使用主观性词语、组织制定模糊的要求避免QA方面的发现、错误步骤。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionPlusSign)).click();
		//P4.1 question
		String q1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer1)).getText();
		softly.assertThat(q1).as("test data").contains("[P4.1] 由于程序编写导则存在不足，使用需要解释或判断的词语，例如:过度、最大、最小、根据需要等");
		//Evidence entry collapsible text
		String e1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry1)).getText();
		softly.assertThat(e1).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).click();
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).getText();
		softly.assertThat(c1).as("test data").contains("可能的纠正行动");
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1Text1)).getText();
		softly.assertThat(c2).as("test data").contains("开展程序设计的培训");
		String c23 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1Text2)).getText();
		softly.assertThat(c23).as("test data").contains("改进存在缺陷的导则或程序");
		String c31 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1Text3)).getText();
		softly.assertThat(c31).as("test data").contains("改进程序审查流程");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).click();
		//P4.2 question
		String q2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer2)).getText();
		softly.assertThat(q2).as("test data").contains("[P4.2] 由于程序编写导则存在不足，使用对一般程序用户而言缺少定义或解释的专业技术词汇");
		//Evidence entry collapsible text
		String e2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry2)).getText();
		softly.assertThat(e2).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).click();
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).getText();
		softly.assertThat(c3).as("test data").contains("可能的纠正行动");
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2Text1)).getText();
		softly.assertThat(c4).as("test data").contains("开展程序设计的培训");
		String c24 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2Text2)).getText();
		softly.assertThat(c24).as("test data").contains("改进存在缺陷的导则或程序");
		String c32 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2Text3)).getText();
		softly.assertThat(c32).as("test data").contains("改进程序审查流程");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).click();
		//P4.3 question
		String q3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer3)).getText();
		softly.assertThat(q3).as("test data").contains("[P4.3] 由于程序编写导则存在不足，使用一般程序用户难以读懂的复杂和复合句");
		//Evidence entry collapsible text
		String e3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry3)).getText();
		softly.assertThat(e3).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).click();
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).getText();
		softly.assertThat(c5).as("test data").contains("可能的纠正行动");
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3Text1)).getText();
		softly.assertThat(c6).as("test data").contains("开展程序设计的培训");
		String c25 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3Text2)).getText();
		softly.assertThat(c25).as("test data").contains("改进存在缺陷的导则或程序");
		String c33 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3Text3)).getText();
		softly.assertThat(c33).as("test data").contains("改进程序审查流程");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).click();
		//P4.4 question
		String q4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer4)).getText();
		softly.assertThat(q4).as("test data").contains("[P4.4] 由于程序编写导则存在不足，在缺少图纸、图片或图形的情况下描述复杂事物");
		//Evidence entry collapsible text
		String e4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry4)).getText();
		softly.assertThat(e4).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4)).click();
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4)).getText();
		softly.assertThat(c7).as("test data").contains("可能的纠正行动");
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4Text1)).getText();
		softly.assertThat(c8).as("test data").contains("开展程序设计的培训");
		String c26 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4Text2)).getText();
		softly.assertThat(c26).as("test data").contains("改进存在缺陷的导则或程序");
		String c34 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4Text3)).getText();
		softly.assertThat(c34).as("test data").contains("改进程序审查流程");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4)).click();
		//P4.5 question
		String q5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer5)).getText();
		softly.assertThat(q5).as("test data").contains("[P4.5] 由于程序编写导则存在不足，使用需要解释的非描述性要求，例如:根据要求、根据需要等");
		//Evidence entry collapsible text
		String e5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry5)).getText();
		softly.assertThat(e5).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5)).click();
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5)).getText();
		softly.assertThat(c9).as("test data").contains("可能的纠正行动");
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5Text1)).getText();
		softly.assertThat(c10).as("test data").contains("开展程序设计的培训");
		String c27 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5Text2)).getText();
		softly.assertThat(c27).as("test data").contains("改进存在缺陷的导则或程序");
		String c35 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5Text3)).getText();
		softly.assertThat(c35).as("test data").contains("改进程序审查流程");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5)).click();
		//Scroll down
		Thread.sleep(1000);
		jse.executeScript("scroll(0,1500)");
		Thread.sleep(1000);
		//P4.6 question
		String q6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer6)).getText();
		softly.assertThat(q6).as("test data").contains("[P4.6] 导则或说明存在错误: (1) 过时的导则; (2) 错误的导则或说明; (3) 程序中存在错误的步骤");
		//Evidence entry collapsible text
		String e6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry6)).getText();
		softly.assertThat(e6).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction6)).click();
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction6)).getText();
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction6Text1)).getText();
		softly.assertThat(c12).as("test data").contains("开展程序设计的培训");
		String c28 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction6Text2)).getText();
		softly.assertThat(c28).as("test data").contains("改进存在缺陷的导则或程序");
		String c36 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction6Text3)).getText();
		softly.assertThat(c36).as("test data").contains("改进程序审查流程");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction6)).click();
		//P4.7 question
		String q7 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer7)).getText();
		softly.assertThat(q7).as("test data").contains("[P4.7] 由于程序审查不充分，造成存在模糊或错误的说明");
		//Evidence entry collapsible text
		String e7 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry7)).getText();
		softly.assertThat(e7).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction7)).click();
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction7)).getText();
		softly.assertThat(c13).as("test data").contains("可能的纠正行动");
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction7Text1)).getText();
		softly.assertThat(c14).as("test data").contains("开展程序审查的培训");
		String c29 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction7Text2)).getText();
		softly.assertThat(c29).as("test data").contains("改进程序审查流程");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction7)).click();
		//P4.8 question
		String q8 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer8)).getText();
		softly.assertThat(q8).as("test data").contains("[P4.8] 设备的标识和识别不到位");
		//Evidence entry collapsible text
		String e8 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry8)).getText();
		softly.assertThat(e8).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction8)).click();
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction8)).getText();
		softly.assertThat(c15).as("test data").contains("可能的纠正行动");
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction8Text1)).getText();
		softly.assertThat(c16).as("test data").contains("改进设备标识和识别");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction8)).click();
		//Contributing factor
		chineseOPiRCAContributingFactor(driver);
    }
	
    public void chineseApparentCauseP3(WebDriver driver) throws Exception{
    	
    	WebDriverWait wait = new WebDriverWait(driver,5);
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
    	OPiRCA obj = new OPiRCA();
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAInfoPageDesc)).getText();
		softly.assertThat(heading).as("test data").contains("偏差控制存在不足");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionPlusSign)).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionText)).getText();
		softly.assertThat(desc).as("test data").contains("问题是否源于缺少对程序检测和纠正的适当检查？请选择原因并输入支持性证据。");
		softly.assertThat(desc).as("test data").contains("当发生偏离程序使用目的、跳过步骤或跳过页次和超出程序外作业时，偏差步控制明显存在不足。常见问题如：程序没有对不能颠倒顺序执行的步骤设定操作标记、禁止进行程序外的操作，但是没有指定实时负责人，以便及时解决、没有识别出关键步骤安排适当的自检和独立验证。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionPlusSign)).click();
		//P3.1 question
		String q1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer1)).getText();
		softly.assertThat(q1).as("test data").contains("[P3.1] 对制度外或程序外进行工作的指导存在不足");
		//Evidence entry collapsible text
		String e1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry1)).getText();
		softly.assertThat(e1).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).click();
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).getText();
		softly.assertThat(c1).as("test data").contains("可能的纠正行动");
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1Text1)).getText();
		softly.assertThat(c2).as("test data").contains("开展程序设计的培训");
		String c23 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1Text2)).getText();
		softly.assertThat(c23).as("test data").contains("改进存在缺陷的导则或程序");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).click();
		//P3.2 question
		String q2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer2)).getText();
		softly.assertThat(q2).as("test data").contains("[P3.2] 由于程序编写导则存在不足，造成通过自检或独立检查单项弱点（SPV）步骤方面存在不足");
		//Evidence entry collapsible text
		String e2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry2)).getText();
		softly.assertThat(e2).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).click();
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).getText();
		softly.assertThat(c3).as("test data").contains("可能的纠正行动");
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2Text1)).getText();
		softly.assertThat(c4).as("test data").contains("开展程序设计的培训");
		String c24 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2Text2)).getText();
		softly.assertThat(c24).as("test data").contains("改进存在缺陷的导则或程序");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).click();
		//P3.3 question
		String q3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer3)).getText();
		softly.assertThat(q3).as("test data").contains("[P3.3] 由于程序编写导则存在不足，造成审查先前不可逆点（PNR）行动方面存在不足");
		//Evidence entry collapsible text
		String e3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry3)).getText();
		softly.assertThat(e3).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).click();
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).getText();
		softly.assertThat(c5).as("test data").contains("可能的纠正行动");
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3Text1)).getText();
		softly.assertThat(c6).as("test data").contains("开展程序设计的培训");
		String c25 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3Text2)).getText();
		softly.assertThat(c25).as("test data").contains("改进存在缺陷的导则或程序");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).click();
		//P3.4 question
		String q4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer4)).getText();
		softly.assertThat(q4).as("test data").contains("[P3.4] 由于程序编写导则存在不足，造成步骤、章节或页次的操作标记使用方面存在不足");
		//Evidence entry collapsible text
		String e4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry4)).getText();
		softly.assertThat(e4).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4)).click();
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4)).getText();
		softly.assertThat(c7).as("test data").contains("可能的纠正行动");
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4Text1)).getText();
		softly.assertThat(c8).as("test data").contains("开展程序设计的培训");
		String c26 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4Text2)).getText();
		softly.assertThat(c26).as("test data").contains("改进存在缺陷的导则或程序");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4)).click();
		//P3.5 question
		String q5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer5)).getText();
		softly.assertThat(q5).as("test data").contains("[P3.5] 由于程序编写导则存在不足，造成使用不准做清单防止违章行为方面存在不足");
		//Evidence entry collapsible text
		String e5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry5)).getText();
		softly.assertThat(e5).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5)).click();
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5)).getText();
		softly.assertThat(c9).as("test data").contains("可能的纠正行动");
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5Text1)).getText();
		softly.assertThat(c10).as("test data").contains("开展程序设计的培训");
		String c27 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5Text2)).getText();
		softly.assertThat(c27).as("test data").contains("改进存在缺陷的导则或程序");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5)).click();
		//Scroll down
		Thread.sleep(1000);
		jse.executeScript("scroll(0,1500)");
		Thread.sleep(1000);
		//P3.6 question
		String q6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer6)).getText();
		softly.assertThat(q6).as("test data").contains("[P3.6] 由于程序编写导则存在不足，造成使用工作现场提示信息防止例行工作出现粗心犯错方面存在不足");
		//Evidence entry collapsible text
		String e6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry6)).getText();
		softly.assertThat(e6).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction6)).click();
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction6)).getText();
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction6Text1)).getText();
		softly.assertThat(c12).as("test data").contains("开展程序设计的培训");
		String c28 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction6Text2)).getText();
		softly.assertThat(c28).as("test data").contains("改进存在缺陷的导则或程序");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction6)).click();
		//P3.7 question
		String q7 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer7)).getText();
		softly.assertThat(q7).as("test data").contains("[P3.7] 由于程序编写导则存在不足，造成使用检查清单防止遗忘相关失误的方面存在不足");
		//Evidence entry collapsible text
		String e7 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry7)).getText();
		softly.assertThat(e7).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction7)).click();
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction7)).getText();
		softly.assertThat(c13).as("test data").contains("可能的纠正行动");
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction7Text1)).getText();
		softly.assertThat(c14).as("test data").contains("开展程序设计的培训");
		String c29 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction7Text2)).getText();
		softly.assertThat(c29).as("test data").contains("改进存在缺陷的导则或程序");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction7)).click();
		//P3.8 question
		String q8 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer8)).getText();
		softly.assertThat(q8).as("test data").contains("[P3.8] 由于程序编写导则存在不足，造成使用行为标准提供正面的同事压力以促使遵循规定方面存在不足");
		//Evidence entry collapsible text
		String e8 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry8)).getText();
		softly.assertThat(e8).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction8)).click();
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction8)).getText();
		softly.assertThat(c15).as("test data").contains("可能的纠正行动");
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction8Text1)).getText();
		softly.assertThat(c16).as("test data").contains("开展程序设计的培训");
		String c30 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction8Text2)).getText();
		softly.assertThat(c30).as("test data").contains("改进存在缺陷的导则或程序");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction8)).click();
		//P3.9 question
		String q9 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer9)).getText();
		softly.assertThat(q9).as("test data").contains("[P3.9] 由于审查不充分，造成存在偏差控制方面的不足");
		//Evidence entry collapsible text
		String e9 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry9)).getText();
		softly.assertThat(e9).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction9)).click();
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction9)).getText();
		softly.assertThat(c17).as("test data").contains("可能的纠正行动");
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction9Text)).getText();
		softly.assertThat(c18).as("test data").contains("开展审查方面的培训");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction9)).click();
		//P3.10 question
		String q10 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer10)).getText();
		softly.assertThat(q10).as("test data").contains("[P3.10] 由于根本原因分析不到位，造成存在偏差控制方面的不足");
		//Evidence entry collapsible text
		String e10 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry10)).getText();
		softly.assertThat(e10).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction10)).click();
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction10)).getText();
		softly.assertThat(c19).as("test data").contains("可能的纠正行动");
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction10Text)).getText();
		softly.assertThat(c20).as("test data").contains("开展根本原因分析方面的培训");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction10)).click();
		//P3.11 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer11)).getText();
		softly.assertThat(q11).as("test data").contains("[P3.11] 由于纠正措施执行不到位，造成存在偏差控制方面的不足");
		//Evidence entry collapsible text
		String e11 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry11)).getText();
		softly.assertThat(e11).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction11)).click();
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction11)).getText();
		softly.assertThat(c21).as("test data").contains("可能的纠正行动");
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction11Text)).getText();
		softly.assertThat(c22).as("test data").contains("改善纠正措施的监督跟踪");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction11)).click();
		//Contributing factor
		chineseOPiRCAContributingFactor(driver);
    }
	
    public void chineseApparentCauseP2(WebDriver driver) throws Exception{
    	
    	WebDriverWait wait = new WebDriverWait(driver,5);
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
    	OPiRCA obj = new OPiRCA();
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAInfoPageDesc)).getText();
		softly.assertThat(heading).as("test data").contains("全面性不足");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionPlusSign)).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionText)).getText();
		softly.assertThat(desc).as("test data").contains("人员是否由于没有制定某些工况而对该做什么工作感到困惑？程序中是否完全遗漏了某些必要功能？如果是，请选择原因并输入支持性证据。");
		softly.assertThat(desc).as("test data").contains("存在问题的制度和屏障通常全面性不足，当某些事件发生率较高时尤为明显。常见问题如：制度设计不足以涵盖所有要求、制度设计不足以涵盖遇到的所有工况、假设陈述存在不足、工作范围存在不足、制度审查存在不足、制度设计和审查方面的培训存在不足。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionPlusSign)).click();
		//P2.1 question
		String q1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer1)).getText();
		softly.assertThat(q1).as("test data").contains("[P2.1] 由于程序编写导则存在不足，而造成要求不全面，例如条例、规范要求、用户和内部要求等");
		//Evidence entry collapsible text
		String e1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry1)).getText();
		softly.assertThat(e1).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).click();
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).getText();
		softly.assertThat(c1).as("test data").contains("可能的纠正行动");
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1Text1)).getText();
		softly.assertThat(c2).as("test data").contains("开展程序设计的培训");
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1Text2)).getText();
		softly.assertThat(c19).as("test data").contains("改进存在缺陷的导则或程序");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).click();
		//P2.2 question
		String q2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer2)).getText();
		softly.assertThat(q2).as("test data").contains("[P2.2] 验证程序的操作条件存在不足，例如: (1) 进入条件; (2) 退出条件; (3) 中止程序的条件");
		//Evidence entry collapsible text
		String e2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry2)).getText();
		softly.assertThat(e2).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).click();
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).getText();
		softly.assertThat(c3).as("test data").contains("可能的纠正行动");
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2Text1)).getText();
		softly.assertThat(c4).as("test data").contains("开展程序设计的培训");
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2Text2)).getText();
		softly.assertThat(c20).as("test data").contains("改进存在缺陷的导则或程序");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).click();
		//P2.3 question
		String q3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer3)).getText();
		softly.assertThat(q3).as("test data").contains("[P2.3] 由于程序编写导则存在不足，而造成程序执行期间要求进行验证的假设存在不足或被遗漏");
		//Evidence entry collapsible text
		String e3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry3)).getText();
		softly.assertThat(e3).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).click();
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).getText();
		softly.assertThat(c5).as("test data").contains("可能的纠正行动");
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3Text1)).getText();
		softly.assertThat(c6).as("test data").contains("开展程序设计的培训");
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3Text2)).getText();
		softly.assertThat(c21).as("test data").contains("改进存在缺陷的导则或程序");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).click();
		//P2.4 question
		String q4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer4)).getText();
		softly.assertThat(q4).as("test data").contains("[P2.4] 由于程序编写导则存在不足，而造成工作范围不充分，例如: (1) 逐步说明; (2) 逐项说明");
		//Evidence entry collapsible text
		String e4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry4)).getText();
		softly.assertThat(e4).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4)).click();
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4)).getText();
		softly.assertThat(c7).as("test data").contains("可能的纠正行动");
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4Text1)).getText();
		softly.assertThat(c8).as("test data").contains("开展程序设计的培训");
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4Text2)).getText();
		softly.assertThat(c22).as("test data").contains("改进存在缺陷的导则或程序");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4)).click();
		//P2.5 question
		String q5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer5)).getText();
		softly.assertThat(q5).as("test data").contains("[P2.5] 由于程序编写导则存在不足，而造成工后试验、测量或正确性验证方面存在不足");
		//Evidence entry collapsible text
		String e5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry5)).getText();
		softly.assertThat(e5).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5)).click();
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5)).getText();
		softly.assertThat(c9).as("test data").contains("可能的纠正行动");
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5Text1)).getText();
		softly.assertThat(c10).as("test data").contains("开展程序设计的培训");
		String c23 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5Text2)).getText();
		softly.assertThat(c23).as("test data").contains("改进存在缺陷的导则或程序");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5)).click();
		//Scroll down
		Thread.sleep(1000);
		jse.executeScript("scroll(0,1500)");
		Thread.sleep(1000);
		//P2.6 question
		String q6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer6)).getText();
		softly.assertThat(q6).as("test data").contains("[P2.6] 缺少以下部分: (1) 目的说明; (2) 先决条件; (3) 术语定义; (4) 不准做清单经验反馈说明; (5) 参考文件; (6) 用户反馈请求");
		//Evidence entry collapsible text
		String e6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry6)).getText();
		softly.assertThat(e6).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction6)).click();
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction6)).getText();
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction6Text1)).getText();
		softly.assertThat(c12).as("test data").contains("开展程序设计的培训");
		String c24 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction6Text2)).getText();
		softly.assertThat(c24).as("test data").contains("改进存在缺陷的导则或程序");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction6)).click();
		//P2.7 question
		String q7 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer7)).getText();
		softly.assertThat(q7).as("test data").contains("[P2.7] 由于审查存在不足而造成要素的遗漏");
		//Evidence entry collapsible text
		String e7 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry7)).getText();
		softly.assertThat(e7).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction7)).click();
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction7)).getText();
		softly.assertThat(c13).as("test data").contains("可能的纠正行动");
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction7Text1)).getText();
		softly.assertThat(c14).as("test data").contains("开展审查方面的培训");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction7)).click();
		//P2.8 question
		String q8 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer8)).getText();
		softly.assertThat(q8).as("test data").contains("[P2.8] 由于根本原因分析不到位导致要素的遗漏");
		//Evidence entry collapsible text
		String e8 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry8)).getText();
		softly.assertThat(e8).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction8)).click();
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction8)).getText();
		softly.assertThat(c15).as("test data").contains("可能的纠正行动");
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction8Text1)).getText();
		softly.assertThat(c16).as("test data").contains("开展根本原因分析方面的培训");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction8)).click();
		//P2.9 question
		String q9 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer9)).getText();
		softly.assertThat(q9).as("test data").contains("[P2.9] 由于纠正措施执行不到位导致要素的遗漏");
		//Evidence entry collapsible text
		String e9 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry9)).getText();
		softly.assertThat(e9).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction9)).click();
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction9)).getText();
		softly.assertThat(c17).as("test data").contains("可能的纠正行动");
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction9Text)).getText();
		softly.assertThat(c18).as("test data").contains("开展纠正措施执行进度的监督跟进");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction9)).click();
		//Contributing factor
		chineseOPiRCAContributingFactor(driver);
    }
	
    public void chineseApparentCauseP1(WebDriver driver) throws Exception{
    	
    	WebDriverWait wait = new WebDriverWait(driver,5);
    	OPiRCA obj = new OPiRCA();
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAInfoPageDesc)).getText();
		softly.assertThat(heading).as("test data").contains("制度遗漏");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionPlusSign)).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionText)).getText();
		softly.assertThat(desc).as("test data").contains("是否需要一个制度，但是该制度却不存在？人们是否由于制度被遗漏而对要做什么感到困惑？如果是，请选择原因并输入支持性证据。");
		softly.assertThat(desc).as("test data").contains("某个领域发生重大事件而其他领域未发的情况下可能是由于制度遗漏。可能促成原因为:制度设计不足, 控制人员和设备绩效所需制度的制定管理层经验不足,屏障设计存在不足, 管理层经验不足, 自我评价方面存在不足。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionPlusSign)).click();
		//P1.1 question
		String q1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer1)).getText();
		softly.assertThat(q1).as("test data").contains("[P1.1] 由于未意识到风险，而造成制度、程序或屏障（LOP）的遗漏，例如: (1) 新兴高风险问题的危机管理制度; (2) O&P决策制定和问题解决的管理授权制度; (3) 技术审查人员的培训和授权制度; (4) 不道德或违法活动的匿名举报制度; (5) 对标、根本原因分析、自我评估");
		//Evidence entry collapsible text
		String e1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry1)).getText();
		softly.assertThat(e1).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).click();
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).getText();
		softly.assertThat(c1).as("test data").contains("可能的纠正行动");
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1Text1)).getText();
		softly.assertThat(c2).as("test data").contains("编写被遗漏的制度");
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1Text2)).getText();
		softly.assertThat(c11).as("test data").contains("识别其他被遗漏的类似制度，并实施纠正行动");
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1Text3)).getText();
		softly.assertThat(c12).as("test data").contains("开展规则和制度设置的管理培训");
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1Text4)).getText();
		softly.assertThat(c13).as("test data").contains("改进QA审计流程，识别被遗漏的制度");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).click();
		//P1.2 question
		String q2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer2)).getText();
		softly.assertThat(q2).as("test data").contains("[P1.2] 由于未意识到风险，而造成行为标准的遗漏，例如: (1) 预防粗心大意的失误的行为标准; (2) 关键思考、关键追问和情况警觉的行为标准; (3) 程序使用的行为标准");
		//Evidence entry collapsible text
		String e2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry2)).getText();
		softly.assertThat(e2).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).click();
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).getText();
		softly.assertThat(c3).as("test data").contains("可能的纠正行动");
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2Text1)).getText();
		softly.assertThat(c4).as("test data").contains("制定被遗漏的标准");
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2Text2)).getText();
		softly.assertThat(c14).as("test data").contains("识别其他被遗漏的类似标准，并实施纠正行动");
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2Text3)).getText();
		softly.assertThat(c15).as("test data").contains("开展标准设置方面的管理培训");
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2Text4)).getText();
		softly.assertThat(c16).as("test data").contains("改进QA审计流程，识别被遗漏的行为标准");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).click();
		//P1.3 question
		String q3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer3)).getText();
		softly.assertThat(q3).as("test data").contains("[P1.3] 由于优先级不当而造成程序编写组织发布程序的时间推迟");
		//Evidence entry collapsible text
		String e3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry3)).getText();
		softly.assertThat(e3).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).click();
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).getText();
		softly.assertThat(c5).as("test data").contains("可能的纠正行动");
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3Text1)).getText();
		softly.assertThat(c6).as("test data").contains("改进优先级体系");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).click();
		//P1.4 question
		String q4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer4)).getText();
		softly.assertThat(q4).as("test data").contains("[P1.4] 由于培训组织优先级划分不当而造成实施的推迟");
		//Evidence entry collapsible text
		String e4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry4)).getText();
		softly.assertThat(e4).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4)).click();
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4)).getText();
		softly.assertThat(c7).as("test data").contains("可能的纠正行动");
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4Text1)).getText();
		softly.assertThat(c8).as("test data").contains("改进优先级体系");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4)).click();
		//P1.5 question
		String q5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer5)).getText();
		softly.assertThat(q5).as("test data").contains("[P1.5] 由于管理审查体系存在不足而造成制度、程序或屏障的遗漏");
		//Evidence entry collapsible text
		String e5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry5)).getText();
		softly.assertThat(e5).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5)).click();
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5)).getText();
		softly.assertThat(c9).as("test data").contains("可能的纠正行动");
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5Text1)).getText();
		softly.assertThat(c10).as("test data").contains("独立管理审查体系存在不足");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5)).click();
		//Contributing factor
		chineseOPiRCAContributingFactor(driver);
    }
	
    public void chineseApparentCauseOP4(WebDriver driver) throws Exception{
    	
    	WebDriverWait wait = new WebDriverWait(driver,5);
    	OPiRCA obj = new OPiRCA();
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAInfoPageDesc)).getText();
		softly.assertThat(heading).as("test data").contains("主人翁意识、责任、角色和问责机制存在不足");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionPlusSign)).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionText)).getText();
		softly.assertThat(desc).as("test data").contains("当制度绩效没有随着时间提升或者已知的问题没有得到解决时，主人翁意识、责任、角色和问责机制（ORRA）明显存在不足。如果主人翁意识、责任、角色和问责机制不足促成该事件发生，请选择原因并输入支持性证据");
		softly.assertThat(desc).as("test data").contains("存在不足的示例包括: 关键制度缺少负责人, 预算或资源的投入不足, 责任和问责机制分散,负责人的管理层支持存在不足、当发生事件时，没有人负责进行解决。");
		softly.assertThat(desc).as("test data").contains("存在不足的原因包括: 管理层缺少经验,定义不明确，避免QA调查发现,回避责任的文化。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionPlusSign)).click();
		//OP4.1 question
		String q1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer1)).getText();
		softly.assertThat(q1).as("test data").contains("[OP4.1] 制度或流程负责人规定方面存在不足");
		//Evidence entry collapsible text
		String e1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry1)).getText();
		softly.assertThat(e1).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).click();
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).getText();
		softly.assertThat(c1).as("test data").contains("可能的纠正行动");
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1Text1)).getText();
		softly.assertThat(c2).as("test data").contains("改进制度管理人员的负责人规定");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).click();
		//OP4.2 question
		String q2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer2)).getText();
		softly.assertThat(q2).as("test data").contains("[OP4.2] 制度或流程相关人员的角色和责任规定方面存在不足");
		//Evidence entry collapsible text
		String e2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry2)).getText();
		softly.assertThat(e2).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).click();
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).getText();
		softly.assertThat(c3).as("test data").contains("可能的纠正行动");
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2Text1)).getText();
		softly.assertThat(c4).as("test data").contains("改进制度管理人员角色和责任的规定");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).click();
		//OP4.3 question
		String q3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer3)).getText();
		softly.assertThat(q3).as("test data").contains("[OP4.3] 用于跟踪制度或流程责任经理绩效（时间、质量和成本）的问责机制存在不足");
		//Evidence entry collapsible text
		String e3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry3)).getText();
		softly.assertThat(e3).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).click();
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).getText();
		softly.assertThat(c5).as("test data").contains("可能的纠正行动");
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3Text1)).getText();
		softly.assertThat(c6).as("test data").contains("改进问责机制，使其涵盖三个同样重要的方面（时间、质量和成本）。体系应当有助于实现良好绩效而非侧重于惩罚");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).click();
		//OP4.4 question
		String q4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer4)).getText();
		softly.assertThat(q4).as("test data").contains("[OP4.4] 总经理层问责机制不存在不足: (1) 未能客观评量总经理层绩效; (2) 未考量所有投资方反馈");
		//Evidence entry collapsible text
		String e4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry4)).getText();
		softly.assertThat(e4).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4)).click();
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4)).getText();
		softly.assertThat(c7).as("test data").contains("可能的纠正行动");
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4Text1)).getText();
		softly.assertThat(c8).as("test data").contains("改进问责机制，使其涵盖总经理层");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4)).click();
		//Contributing factor
		chineseOPiRCAContributingFactor(driver);
    }
    
    public void chineseApparentCauseOP3(WebDriver driver) throws Exception{
    	
    	WebDriverWait wait = new WebDriverWait(driver,5);
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
    	OPiRCA obj = new OPiRCA();
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAInfoPageDesc)).getText();
		softly.assertThat(heading).as("test data").contains("自我评价或评估存在不足");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionPlusSign)).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionText)).getText();
		softly.assertThat(desc).as("test data").contains("是否有证据表明由于缺乏对自身或其小组弱项的认知而促使该失误的发生？如果是，请选择原因并输入支持性证据。");
		softly.assertThat(desc).as("test data").contains("自我评价和评估存在不足常见情况为：启动绩效偏差或RCA分析的界限存在不足、预算或资源评价存在不足、相关风险的分析零散、自满、自我评价工具存在不足、小组或组织绩效的自我评估存在不足。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionPlusSign)).click();
		//OP3.1 question
		String q1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer1)).getText();
		softly.assertThat(q1).as("test data").contains("[OP3.1] 个人的自我分析存在不足");
		//Evidence entry collapsible text
		String e1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry1)).getText();
		softly.assertThat(e1).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).click();
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).getText();
		softly.assertThat(c1).as("test data").contains("可能的纠正行动");
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1Text1)).getText();
		softly.assertThat(c2).as("test data").contains("开展Error-Free");
		softly.assertThat(c2).as("test data").contains("自我评价培训，使人员认识到他或她容易发生失误的方面");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).click();
		//OP3.2 question
		String q2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer2)).getText();
		softly.assertThat(q2).as("test data").contains("[OP3.2] 监督小组的自我分析存在不足");
		//Evidence entry collapsible text
		String e2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry2)).getText();
		softly.assertThat(e2).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).click();
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).getText();
		softly.assertThat(c3).as("test data").contains("可能的纠正行动");
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2Text1)).getText();
		softly.assertThat(c4).as("test data").contains("开展Error-Free");
		softly.assertThat(c4).as("test data").contains("自我评价培训，使主管认识到他或她的小组容易发生失误的方面");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).click();
		//OP3.3 question
		String q3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer3)).getText();
		softly.assertThat(q3).as("test data").contains("[OP3.3] 管理组织的自我分析存在不足");
		//Evidence entry collapsible text
		String e3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry3)).getText();
		softly.assertThat(e3).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).click();
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).getText();
		softly.assertThat(c5).as("test data").contains("可能的纠正行动");
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3Text1)).getText();
		softly.assertThat(c6).as("test data").contains("开展Error-Free");
		softly.assertThat(c6).as("test data").contains("自我评价培训，使经理认识到他或她的组织容易发生失误的方面");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).click();
		//OP3.4 question
		String q4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer4)).getText();
		softly.assertThat(q4).as("test data").contains("[OP3.4] 高风险制度或程序的自我评估存在不足");
		//Evidence entry collapsible text
		String e4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry4)).getText();
		softly.assertThat(e4).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4)).click();
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4)).getText();
		softly.assertThat(c7).as("test data").contains("可能的纠正行动");
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4Text1)).getText();
		softly.assertThat(c8).as("test data").contains("改进自我评估制度的频率和彻底性");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4)).click();
		//OP3.5 question
		String q5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer5)).getText();
		softly.assertThat(q5).as("test data").contains("[OP3.5] 对组织事件的根本原因分析分析质量差、事件数据收集和启动调查条件存在不足");
		//Evidence entry collapsible text
		String e5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry5)).getText();
		softly.assertThat(e5).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5)).click();
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5)).getText();
		softly.assertThat(c9).as("test data").contains("可能的纠正行动");
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5Text1)).getText();
		softly.assertThat(c10).as("test data").contains("改进执行组织事件根本原因分析的质量、数据收集和启动调查条件");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5)).click();
		//Scroll down
		Thread.sleep(1000);
		jse.executeScript("scroll(0,1500)");
		Thread.sleep(1000);
		//OP3.6 question
		String q6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer6)).getText();
		softly.assertThat(q6).as("test data").contains("[OP3.6] 对组织事件的共因分析没有定期执行（不够频繁）或是共因分析质量差");
		//Evidence entry collapsible text
		String e6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry6)).getText();
		softly.assertThat(e6).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction6)).click();
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction6)).getText();
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction6Text1)).getText();
		softly.assertThat(c12).as("test data").contains("改进执行组织事件共因分析的频率和质量。评估可以识别弱点加以改进。");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction6)).click();
		//Contributing factor
		chineseOPiRCAContributingFactor(driver);
    }
	
    public void chineseApparentCauseOP2(WebDriver driver) throws Exception{
    	
    	WebDriverWait wait = new WebDriverWait(driver,5);
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
    	OPiRCA obj = new OPiRCA();
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAInfoPageDesc)).getText();
		softly.assertThat(heading).as("test data").contains("绩效监督跟踪和趋势分析存在不足");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionPlusSign)).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionText)).getText();
		softly.assertThat(desc).as("test data").contains("为什么之前没有解决该问题或事项？请选择原因并输入支持性证据。");
		softly.assertThat(desc).as("test data").contains("当自满、过度自信、管理层未意识到薄弱领域时，经常出现绩效跟踪和趋势分析（PM&T）存在不足。示例包括：绩效跟踪和趋势分析制度的人员配置不足或缺少经验、管理层关注度不足、缺少正式的绩效跟踪和趋势分析流程、未监督关键参数（例如失误陷阱和屏障）。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionPlusSign)).click();
		//OP2.1 question
		String q1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer1)).getText();
		softly.assertThat(q1).as("test data").contains("[OP2.1] 先行指标存在不足");
		//Evidence entry collapsible text
		String e1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry1)).getText();
		softly.assertThat(e1).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).click();
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).getText();
		softly.assertThat(c1).as("test data").contains("可能的纠正行动");
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1Text1)).getText();
		softly.assertThat(c2).as("test data").contains("改进先行指标");
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1Text2)).getText();
		softly.assertThat(c13).as("test data").contains("使用过去的绩效对先行指标进行核实");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).click();
		//OP2.2 question
		String q2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer2)).getText();
		softly.assertThat(q2).as("test data").contains("[OP2.2] 实时指标存在不足");
		//Evidence entry collapsible text
		String e2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry2)).getText();
		softly.assertThat(e2).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).click();
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).getText();
		softly.assertThat(c3).as("test data").contains("可能的纠正行动");
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2Text1)).getText();
		softly.assertThat(c4).as("test data").contains("改进实时指标");
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2Text2)).getText();
		softly.assertThat(c14).as("test data").contains("使用过去的绩效对实时指标进行核实");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).click();
		//OP2.3 question
		String q3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer3)).getText();
		softly.assertThat(q3).as("test data").contains("[OP2.3] 滞后指标存在不足");
		//Evidence entry collapsible text
		String e3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry3)).getText();
		softly.assertThat(e3).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).click();
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).getText();
		softly.assertThat(c5).as("test data").contains("可能的纠正行动");
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3Text1)).getText();
		softly.assertThat(c6).as("test data").contains("改进滞后标志");
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3Text2)).getText();
		softly.assertThat(c15).as("test data").contains("使其简单但能够反映所有主要O&P问题");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).click();
		//OP2.4 question
		String q4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer4)).getText();
		softly.assertThat(q4).as("test data").contains("[OP2.4] 管理层在绩效监督跟踪和趋势分析的结果使用方面存在不足");
		//Evidence entry collapsible text
		String e4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry4)).getText();
		softly.assertThat(e4).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4)).click();
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4)).getText();
		softly.assertThat(c7).as("test data").contains("可能的纠正行动");
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4Text1)).getText();
		softly.assertThat(c8).as("test data").contains("改进绩效提升的管理决策流程，纳入绩效监督跟踪和趋势分析中的数据");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4)).click();
		//OP2.5 question
		String q5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer5)).getText();
		softly.assertThat(q5).as("test data").contains("[OP2.5] 在将RCA共因分析作为监督工具方面存在不足");
		//Evidence entry collapsible text
		String e5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry5)).getText();
		softly.assertThat(e5).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5)).click();
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5)).getText();
		softly.assertThat(c9).as("test data").contains("可能的纠正行动");
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5Text1)).getText();
		softly.assertThat(c10).as("test data").contains("改进共因分析方法");
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5Text2)).getText();
		softly.assertThat(c16).as("test data").contains("开展Error-Free");
		softly.assertThat(c16).as("test data").contains(" 共因培训");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5)).click();
		//Scroll down
		Thread.sleep(1000);
		jse.executeScript("scroll(0,1500)");
		Thread.sleep(1000);
		//OP2.6 question
		String q6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer6)).getText();
		softly.assertThat(q6).as("test data").contains("[OP2.6] 在使用现场观察结果作为监督工具方面存在不足");
		//Evidence entry collapsible text
		String e6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry6)).getText();
		softly.assertThat(e6).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction6)).click();
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction6)).getText();
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction6Text1)).getText();
		softly.assertThat(c12).as("test data").contains("改进绩效提升的管理决策流程，纳入现场观察中的数据");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction6)).click();
		//Contributing factor
		chineseOPiRCAContributingFactor(driver);
    }
	
    public void chineseApparentCauseOP1(WebDriver driver) throws Exception{
    	
    	WebDriverWait wait = new WebDriverWait(driver,5);
    	OPiRCA obj = new OPiRCA();
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAInfoPageDesc)).getText();
		softly.assertThat(heading).as("test data").contains("实施投入存在不足");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionPlusSign)).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionText)).getText();
		softly.assertThat(desc).as("test data").contains("是否存在制度已经启动，但组织尚未尝试满足可接受的绩效标准？如果有，选择为什么并输入支持性证据。");
		softly.assertThat(desc).as("test data").contains("I实施投入存在不足可由资源不足或实施计划不足导致的:");
		softly.assertThat(desc).as("test data").contains("- 管理期望（即制度要求）存在不足");
		softly.assertThat(desc).as("test data").contains("- 内部制度要求和外部制度要求之间相容性存在不足");
		softly.assertThat(desc).as("test data").contains("- 未能根据制度要求充分分配资源来执行制度");
		softly.assertThat(desc).as("test data").contains("- 下属未能支持承诺执行");
		softly.assertThat(desc).as("test data").contains("- 外部资源被迫承诺");
		softly.assertThat(desc).as("test data").contains("- 未充分规划前就实施投入");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionPlusSign)).click();
		//OP1.1 question
		String q1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer1)).getText();
		softly.assertThat(q1).as("test data").contains("[OP1.1] 人员配置和预算不足以实施制度或执行程序");
		//Evidence entry collapsible text
		String e1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry1)).getText();
		softly.assertThat(e1).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).click();
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).getText();
		softly.assertThat(c1).as("test data").contains("可能的纠正行动");
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1Text1)).getText();
		softly.assertThat(c2).as("test data").contains("增加人员编制");
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1Text2)).getText();
		softly.assertThat(c9).as("test data").contains("评估制度管理人员或者负责该制度的组织管理人员的能力");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).click();
		//OP1.2 question
		String q2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer2)).getText();
		softly.assertThat(q2).as("test data").contains("[OP1.2] 相关人员的培训和授权不足以实施制度");
		//Evidence entry collapsible text
		String e2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry2)).getText();
		softly.assertThat(e2).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).click();
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).getText();
		softly.assertThat(c3).as("test data").contains("可能的纠正行动");
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2Text1)).getText();
		softly.assertThat(c4).as("test data").contains("增加培训预算");
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2Text2)).getText();
		softly.assertThat(c10).as("test data").contains("针对高风险或者要求知识型绩效的工作开展培训课程");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).click();
		//OP1.3 question
		String q3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer3)).getText();
		softly.assertThat(q3).as("test data").contains("[OP1.3] 管理层对制度落实行动的跟进存在不足");
		//Evidence entry collapsible text
		String e3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry3)).getText();
		softly.assertThat(e3).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).click();
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).getText();
		softly.assertThat(c5).as("test data").contains("可能的纠正行动");
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3Text1)).getText();
		softly.assertThat(c6).as("test data").contains("改进管理层工作投入和跟踪系统");
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3Text2)).getText();
		softly.assertThat(c11).as("test data").contains("评估制度管理人员或者负责该制度的组织管理人员的能力");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).click();
		//OP1.4 question
		String q4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer4)).getText();
		softly.assertThat(q4).as("test data").contains("[OP1.4] 对落实制度的管理支持存在不足");
		//Evidence entry collapsible text
		String e4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry4)).getText();
		softly.assertThat(e4).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4)).click();
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4)).getText();
		softly.assertThat(c7).as("test data").contains("可能的纠正行动");
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4Text1)).getText();
		softly.assertThat(c8).as("test data").contains("改进管理支持");
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4Text2)).getText();
		softly.assertThat(c12).as("test data").contains("评估制度管理人员或者负责该制度的组织管理人员的能力");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4)).click();
		//Contributing factor
		chineseOPiRCAContributingFactor(driver);
    }
	
    public void chineseApparentCauseOO3(WebDriver driver) throws Exception{
    	
    	WebDriverWait wait = new WebDriverWait(driver,5);
    	//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAInfoPageDesc)).getText();
		softly.assertThat(heading).as("test data").contains("两个接口组织之间的工作职能存在重叠或遗漏");
		//OO3.1 question
		String q1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer1)).getText();
		softly.assertThat(q1).as("test data").contains("[OO3.1] 两个独立的组织执行一个工作职能");
		//Evidence entry collapsible text
		String e1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry1)).getText();
		softly.assertThat(e1).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).click();
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).getText();
		softly.assertThat(c1).as("test data").contains("可能的纠正行动");
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1Text1)).getText();
		softly.assertThat(c2).as("test data").contains("简化重叠的工作职能");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).click();
		//OO3.2 question
		String q2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer2)).getText();
		softly.assertThat(q2).as("test data").contains("[OO3.2] 没有要求两个接口部门执行所需的工作职能");
		//Evidence entry collapsible text
		String e2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry2)).getText();
		softly.assertThat(e2).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).click();
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).getText();
		softly.assertThat(c3).as("test data").contains("可能的纠正行动");
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2Text1)).getText();
		softly.assertThat(c4).as("test data").contains("重新定义角色和责任，纳入两个接口组织之间被遗漏的工作职能");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).click();
		//Contributing factor
		chineseOPiRCAContributingFactor(driver);
    }
	
    public void chineseApparentCauseOO2(WebDriver driver) throws Exception{
    	
    	WebDriverWait wait = new WebDriverWait(driver,5);
    	OPiRCA obj = new OPiRCA();
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAInfoPageDesc)).getText();
		softly.assertThat(heading).as("test data").contains("组织之间的接口存在不足");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionPlusSign)).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionText)).getText();
		softly.assertThat(desc).as("test data").contains("该失误是否由于组织之间缺少交流而促成？如果是，请选择原因并输入支持性证据");
		softly.assertThat(desc).as("test data").contains("信息传达存在不足或跨组织问题未得到解决可以看出组织之间的接口存在不足。组织结构适当，但是组织之间没有进行有效的信息共享是由于：缺少正式的接口流程、接口要求存在不足、实际设置存在不足。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionPlusSign)).click();
		//OO2.1 question
		String q1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer1)).getText();
		softly.assertThat(q1).as("test data").contains("[OO2.1] 组织管理人员共同规定的接口要求存在不足，例如数据传达、资源共享、解决跨组织问题等");
		//Evidence entry collapsible text
		String e1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry1)).getText();
		softly.assertThat(e1).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).click();
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).getText();
		softly.assertThat(c1).as("test data").contains("可能的纠正行动");
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1Text1)).getText();
		softly.assertThat(c2).as("test data").contains("改进接口要求");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).click();
		//OO2.2 question
		String q2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer2)).getText();
		softly.assertThat(q2).as("test data").contains("[OO2.2] 接口流程和方法存在不足，例如会议形式、接口频率和沟通通道存在不足");
		//Evidence entry collapsible text
		String e2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry2)).getText();
		softly.assertThat(e2).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).click();
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).getText();
		softly.assertThat(c3).as("test data").contains("可能的纠正行动");
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2Text1)).getText();
		softly.assertThat(c4).as("test data").contains("改进接口流程和方法");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).click();
		//OO2.3 question
		String q3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer3)).getText();
		softly.assertThat(q3).as("test data").contains("[OO2.3] 由于位置过于分散而造成沟通不佳");
		//Evidence entry collapsible text
		String e3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry3)).getText();
		softly.assertThat(e3).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).click();
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).getText();
		softly.assertThat(c5).as("test data").contains("可能的纠正行动");
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3Text1)).getText();
		softly.assertThat(c6).as("test data").contains("通过采用先进的沟通技术，提高沟通的频率和简易度");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).click();
		//Contributing factor
		chineseOPiRCAContributingFactor(driver);
    }
	
    public void chineseApparentCauseOO1(WebDriver driver) throws Exception{
    	
    	WebDriverWait wait = new WebDriverWait(driver,5);
    	OPiRCA obj = new OPiRCA();
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAInfoPageDesc)).getText();
		softly.assertThat(heading).as("test data").contains("共同目标/利益/问责机制存在不足");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionPlusSign)).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionText)).getText();
		softly.assertThat(desc).as("test data").contains("当管理人员之间存在冲突、相互妨碍、相互支持存在不足时，存在明显的共同目标/利益/问责机制不足。");
		softly.assertThat(desc).as("test data").contains("是否有以下方面的证明: 高管层设定的目标/利益/问责机制存在冲突,问责机制的各个因素间存在冲突, 团队合作和相互信任方面存在不足,组织一体化存在不足?如果是，请选择原因并输入支持性证据。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionPlusSign)).click();
		//OO1.1 question
		String q1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer1)).getText();
		softly.assertThat(q1).as("test data").contains("[OO1.1] QA和组织之间的共同目标/利益/问责机制的定义存在不足");
		//Evidence entry collapsible text
		String e1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry1)).getText();
		softly.assertThat(e1).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).click();
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).getText();
		softly.assertThat(c1).as("test data").contains("可能的纠正行动");
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1Text1)).getText();
		softly.assertThat(c2).as("test data").contains("制定QA和组织之间的共同目标/利益/问责机制");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).click();
		//OO1.2 question
		String q2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer2)).getText();
		softly.assertThat(q2).as("test data").contains("[OO1.2] 组织间的共同目标/利益/问责机制的定义存在不足");
		//Evidence entry collapsible text
		String e2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry2)).getText();
		softly.assertThat(e2).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).click();
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).getText();
		softly.assertThat(c3).as("test data").contains("可能的纠正行动");
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2Text1)).getText();
		softly.assertThat(c4).as("test data").contains("制定组织间的共同目标/利益/问责机制，例如利用奖惩体系鼓励组织之间为了实现整体利益而相互支持");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).click();
		//OO1.3 question
		String q3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer3)).getText();
		softly.assertThat(q3).as("test data").contains("[OO1.3] 高管和组织管理人员之间的共同目标/利益/问责机制存在不足: (1) 奖励制度不同且不一致; (2) 高管侧重于一个领域而让管理人员负责另一个领域");
		//Evidence entry collapsible text
		String e3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry3)).getText();
		softly.assertThat(e3).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).click();
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).getText();
		softly.assertThat(c5).as("test data").contains("可能的纠正行动");
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3Text1)).getText();
		softly.assertThat(c6).as("test data").contains("制定高管和组织管理人员之间的共同目标/利益/问责机制");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).click();
		//OO1.4 question
		String q4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer4)).getText();
		softly.assertThat(q4).as("test data").contains("[OO1.4] 组织管理人员和主管之间的共同目标/利益/问责机制存在不足: (1) 问责体系不同; (2) 管理人员侧重于一个领域而让主管负责另一个领域");
		//Evidence entry collapsible text
		String e4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry4)).getText();
		softly.assertThat(e4).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4)).click();
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4)).getText();
		softly.assertThat(c7).as("test data").contains("可能的纠正行动");
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4Text1)).getText();
		softly.assertThat(c8).as("test data").contains("制定组织管理人员和主管之间的共同目标/利益/问责机制");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4)).click();
		//OO1.5 question
		String q5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer5)).getText();
		softly.assertThat(q5).as("test data").contains("[OO1.5] 奖励和问责体系不足以建立共同目标/利益");
		//Evidence entry collapsible text
		String e5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry5)).getText();
		softly.assertThat(e5).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5)).click();
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5)).getText();
		softly.assertThat(c9).as("test data").contains("可能的纠正行动");
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5Text1)).getText();
		softly.assertThat(c10).as("test data").contains("改进奖励体系");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5)).click();
		//Contributing factor
		chineseOPiRCAContributingFactor(driver);
    }
	
    public void chineseApparentCauseO5(WebDriver driver) throws Exception{
    	
    	WebDriverWait wait = new WebDriverWait(driver,5);
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
    	OPiRCA obj = new OPiRCA();
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAInfoPageDesc)).getText();
		softly.assertThat(heading).as("test data").contains("个人技能、规则使用或知识方面存在不足");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionPlusSign)).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionText)).getText();
		softly.assertThat(desc).as("test data").contains("员工是否准备执行即将到来的工作？如果不能，选择为什么并输入支持性证据。");
		softly.assertThat(desc).as("test data").contains("个人技能、规则运用或知识存在不足可导致个人失误，从而影响组织绩效。缺乏技能、规则运用或知识的原因包括：性格/态度方面存在不足、以知识为基础的培训存在不足、缺乏经验。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionPlusSign)).click();
		//O5.1 question
		String q1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer1)).getText();
		softly.assertThat(q1).as("test data").contains("[O5.1] 技能不足以避免发生粗心大意的失误");
		//Evidence entry collapsible text
		String e1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry1)).getText();
		softly.assertThat(e1).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).click();
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).getText();
		softly.assertThat(c1).as("test data").contains("可能的纠正行动");
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1Text1)).getText();
		softly.assertThat(c2).as("test data").contains("建立行为标准，避免发生粗心大意的失误");
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1Text2)).getText();
		softly.assertThat(c13).as("test data").contains("开展预防粗心大意的失误的培训");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).click();
		//O5.2 question
		String q2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer2)).getText();
		softly.assertThat(q2).as("test data").contains("[O5.2] 技能不足以遵守规则（例如程序、检查清单、工作现场提示信息、行为标准和不准做清单）");
		//Evidence entry collapsible text
		String e2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry2)).getText();
		softly.assertThat(e2).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).click();
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).getText();
		softly.assertThat(c3).as("test data").contains("可能的纠正行动");
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2Text1)).getText();
		softly.assertThat(c4).as("test data").contains("建立程序使用的行为标准");
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2Text2)).getText();
		softly.assertThat(c14).as("test data").contains("开展防止发生程序失误的培训");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).click();
		//O5.3 question
		String q3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer3)).getText();
		softly.assertThat(q3).as("test data").contains("[O5.3] 主管和经理知识不足以防止自身的知识型错误");
		//Evidence entry collapsible text
		String e3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry3)).getText();
		softly.assertThat(e3).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).click();
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).getText();
		softly.assertThat(c5).as("test data").contains("可能的纠正行动");
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3Text1)).getText();
		softly.assertThat(c6).as("test data").contains("为管理人员开展Error-Free");
		softly.assertThat(c6).as("test data").contains("预防培训，改进其最薄弱的领域，包括以下主题: (1) 决策制定; (2) 问题解决; (3) 学习; (4) 设计、分析和建模; (5) 审查; (6) 规划; (7) 沟通; (8) 协商; (9) 风险控制; (10) 绩效控制");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).click();
		//O5.4 question
		String q4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer4)).getText();
		softly.assertThat(q4).as("test data").contains("[O5.4] 流程设计和改进方面的管理知识不足: (1) 程序的逐步设计和改进方面存在不足; (2) 屏障的设计和改进方面存在不足; (3) 行为标准的设计和改进方面存在不足; (4) 不准做清单的设计和改进方面存在不足; (5) 检查清单的设计和改进方面存在不足; (6) 工作现场提示信息的设计和改进方面存在不足");
		//Evidence entry collapsible text
		String e4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry4)).getText();
		softly.assertThat(e4).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4)).click();
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4)).getText();
		softly.assertThat(c7).as("test data").contains("可能的纠正行动");
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4Text1)).getText();
		softly.assertThat(c8).as("test data").contains("开展程序设计和改进方面的Error-Free");
		softly.assertThat(c8).as("test data").contains("培训");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4)).click();
		//O5.5 question
		String q5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer5)).getText();
		softly.assertThat(q5).as("test data").contains("[O5.5] 人因绩效管理方面的管理知识不足");
		//Evidence entry collapsible text
		String e5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry5)).getText();
		softly.assertThat(e5).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5)).click();
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5)).getText();
		softly.assertThat(c9).as("test data").contains("可能的纠正行动");
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5Text1)).getText();
		softly.assertThat(c10).as("test data").contains("开展人因绩效管理方面的Error-Free");
		softly.assertThat(c10).as("test data").contains("培训");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5)).click();
		//Scroll down
		Thread.sleep(1000);
		jse.executeScript("scroll(0,1500)");
		Thread.sleep(1000);
		//O5.6 question
		String q6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer6)).getText();
		softly.assertThat(q6).as("test data").contains("[O5.6] 设备性能管理方面的管理知识不足");
		//Evidence entry collapsible text
		String e6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry6)).getText();
		softly.assertThat(e6).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction6)).click();
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction6)).getText();
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction6Text1)).getText();
		softly.assertThat(c12).as("test data").contains("开展设备性能管理方面的Error-Free");
		softly.assertThat(c12).as("test data").contains("培训");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction6)).click();
		//Contributing factor
		chineseOPiRCAContributingFactor(driver);
    }
	
    public void chineseApparentCauseO4(WebDriver driver) throws Exception{
    	
    	WebDriverWait wait = new WebDriverWait(driver,5);
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
    	OPiRCA obj = new OPiRCA();
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAInfoPageDesc)).getText();
		softly.assertThat(heading).as("test data").contains("组织内沟通存在不足");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionPlusSign)).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionText)).getText();
		softly.assertThat(desc).as("test data").contains("组织内的沟通是否通畅？信息传递是否及时沟通给相关人员？若没有，请选择原因并输入支持证据。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionPlusSign)).click();
		//O4.1 question
		String q1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer1)).getText();
		softly.assertThat(q1).as("test data").contains("[O4.1] 高层管理的接口会议不足以处理共性问题");
		//Evidence entry collapsible text
		String e1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry1)).getText();
		softly.assertThat(e1).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).click();
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).getText();
		softly.assertThat(c1).as("test data").contains("可能的纠正行动");
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1Text1)).getText();
		softly.assertThat(c2).as("test data").contains("改进接口会议的质量和效率");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).click();
		//O4.2 question
		String q2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer2)).getText();
		softly.assertThat(q2).as("test data").contains("[O4.2] 中层管理的接口会议不足以处理共性问题");
		//Evidence entry collapsible text
		String e2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry2)).getText();
		softly.assertThat(e2).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).click();
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).getText();
		softly.assertThat(c3).as("test data").contains("可能的纠正行动");
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2Text1)).getText();
		softly.assertThat(c4).as("test data").contains("改进接口会议的质量和效率");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).click();
		//O4.3 question
		String q3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer3)).getText();
		softly.assertThat(q3).as("test data").contains("[O4.3] 工作层的接口会议不足以处理共性问题");
		//Evidence entry collapsible text
		String e3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry3)).getText();
		softly.assertThat(e3).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).click();
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).getText();
		softly.assertThat(c5).as("test data").contains("可能的纠正行动");
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3Text1)).getText();
		softly.assertThat(c6).as("test data").contains("改进接口会议的质量和效率");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).click();
		//O4.4 question
		String q4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer4)).getText();
		softly.assertThat(q4).as("test data").contains("[O4.4] 在使用公用跟踪系统记录各个组织之间情况管理或工作流程沟通方面存在不足");
		//Evidence entry collapsible text
		String e4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry4)).getText();
		softly.assertThat(e4).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4)).click();
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4)).getText();
		softly.assertThat(c7).as("test data").contains("可能的纠正行动");
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4Text1)).getText();
		softly.assertThat(c8).as("test data").contains("使用公用跟踪系统，记录各方之间的沟通");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4)).click();
		//O4.5 question
		String q5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer5)).getText();
		softly.assertThat(q5).as("test data").contains("[O4.5] 组织中的垂直沟通存在不足，未能报告需要高层管理注意的问题");
		//Evidence entry collapsible text
		String e5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry5)).getText();
		softly.assertThat(e5).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5)).click();
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5)).getText();
		softly.assertThat(c9).as("test data").contains("可能的纠正行动");
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5Text1)).getText();
		softly.assertThat(c10).as("test data").contains("改进垂直沟通方式");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5)).click();
		//Scroll down
		Thread.sleep(1000);
		jse.executeScript("scroll(0,1500)");
		Thread.sleep(1000);
		//O4.6 question
		String q6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer6)).getText();
		softly.assertThat(q6).as("test data").contains("[O4.6] 向工作人员传达管理层期望和经验反馈方面存在不足");
		//Evidence entry collapsible text
		String e6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry6)).getText();
		softly.assertThat(e6).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction6)).click();
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction6)).getText();
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction6Text1)).getText();
		softly.assertThat(c12).as("test data").contains("改进期望和经验反馈传达的质量和效率");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction6)).click();
		//O4.7 question
		String q7 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer7)).getText();
		softly.assertThat(q7).as("test data").contains("[O4.7] 由于激励和问责制度存在不足而造成移交（TO）、工前会（PJB）、工作期间会议（MJB）或班前会（PSM）的沟通存在不足");
		//Evidence entry collapsible text
		String e7 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry7)).getText();
		softly.assertThat(e7).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction7)).click();
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction7)).getText();
		softly.assertThat(c13).as("test data").contains("可能的纠正行动");
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction7Text1)).getText();
		softly.assertThat(c14).as("test data").contains("改进监督技能，激励开放式的沟通");
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction7Text2)).getText();
		softly.assertThat(c15).as("test data").contains("改进问责制，以便在移交（TO）、工前会（PJB）、工作期间会议（MJB）或班前会（PSM）进行有效沟通");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction7)).click();
		//Contributing factor
		chineseOPiRCAContributingFactor(driver);
    }
	
    public void chineseApparentCauseO3(WebDriver driver) throws Exception{
    	
    	WebDriverWait wait = new WebDriverWait(driver,5);
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
    	OPiRCA obj = new OPiRCA();
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAInfoPageDesc)).getText();
		softly.assertThat(heading).as("test data").contains("流程设计和改进能力不足");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionPlusSign)).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionText)).getText();
		softly.assertThat(desc).as("test data").contains("是否有证据表明存在无效或不可靠的流程未能随着时间的推移得到改善？如果有，选择为什么并输入支持性证据。");
		softly.assertThat(desc).as("test data").contains("无效的、不可靠的和有缺陷的流程设计可以下列形式举例说明: 缺乏设计和改善流程的整合能力,缺乏流程设计导则,编写程序时未考虑流程失效, 未针对有效性优化流程,未优化流程以降低故障率。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionPlusSign)).click();
		//O3.1 question
		String q1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer1)).getText();
		softly.assertThat(q1).as("test data").contains("[O3.1] 缺少流程和程序设计、缺乏标准改进");
		//Evidence entry collapsible text
		String e1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry1)).getText();
		softly.assertThat(e1).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).click();
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).getText();
		softly.assertThat(c1).as("test data").contains("可能的纠正行动");
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1Text1)).getText();
		softly.assertThat(c2).as("test data").contains("确定协调员或职能经理，监督关键流程的设计和改进");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).click();
		//O3.2 question
		String q2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer2)).getText();
		softly.assertThat(q2).as("test data").contains("[O3.2] 缺少负责日常流程绩效的流程负责人");
		//Evidence entry collapsible text
		String e2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry2)).getText();
		softly.assertThat(e2).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).click();
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).getText();
		softly.assertThat(c3).as("test data").contains("可能的纠正行动");
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2Text1)).getText();
		softly.assertThat(c4).as("test data").contains("确定各个关键流程的负责人及其角色和责任");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).click();
		//O3.3 question
		String q3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer3)).getText();
		softly.assertThat(q3).as("test data").contains("[O3.3] 流程程序设计导则存在不足");
		//Evidence entry collapsible text
		String e3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry3)).getText();
		softly.assertThat(e3).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).click();
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).getText();
		softly.assertThat(c5).as("test data").contains("可能的纠正行动");
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3Text1)).getText();
		softly.assertThat(c6).as("test data").contains("为有效且可靠的流程制定流程设计导则");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).click();
		//O3.4 question
		String q4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer4)).getText();
		softly.assertThat(q4).as("test data").contains("[O3.4] 流程改进存在不足: (1) 定期自评存在不足; (2)绩效跟踪和趋势分析存在不足; (3)流程失效的根本原因分析存在不足");
		//Evidence entry collapsible text
		String e4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry4)).getText();
		softly.assertThat(e4).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4)).click();
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4)).getText();
		softly.assertThat(c7).as("test data").contains("可能的纠正行动");
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4Text1)).getText();
		softly.assertThat(c8).as("test data").contains("制定流程改进导则");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4)).click();
		//O3.5 question
		String q5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer5)).getText();
		softly.assertThat(q5).as("test data").contains("[O3.5] 程序编写导则存在不足，未能有效且可靠地执行流程");
		//Evidence entry collapsible text
		String e5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry5)).getText();
		softly.assertThat(e5).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5)).click();
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5)).getText();
		softly.assertThat(c9).as("test data").contains("可能的纠正行动");
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5Text1)).getText();
		softly.assertThat(c10).as("test data").contains("制定程序编写导则");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5)).click();
		//Scroll down
		Thread.sleep(1000);
		jse.executeScript("scroll(0,1500)");
		Thread.sleep(1000);
		//O3.6 question
		String q6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer6)).getText();
		softly.assertThat(q6).as("test data").contains("[O3.6] 发展流程设计和改进能力方面存在不足: (1) 流程的失效模式与影响分析; (2) 功能设计; (3) 效率和可靠性优化; (4) 教学准备; (5) 流程试验和验证");
		//Evidence entry collapsible text
		String e6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry6)).getText();
		softly.assertThat(e6).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction6)).click();
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction6)).getText();
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction6Text1)).getText();
		softly.assertThat(c12).as("test data").contains("通过培训或指导来发展流程设计和改进能力");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction6)).click();
		//O3.7 question
		String q7 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer7)).getText();
		softly.assertThat(q7).as("test data").contains("[O3.7] 通过培训或指导来发展流程设计和改进能力");
		//Evidence entry collapsible text
		String e7 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry7)).getText();
		softly.assertThat(e7).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction7)).click();
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction7)).getText();
		softly.assertThat(c13).as("test data").contains("可能的纠正行动");
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction7Text1)).getText();
		softly.assertThat(c14).as("test data").contains("当需要时，建立专门的工作组进行流程设计和改进");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction7)).click();
		//Contributing factor
		chineseOPiRCAContributingFactor(driver);
    }
	
    public void chineseApparentCauseO1(WebDriver driver) throws Exception{
    	
    	WebDriverWait wait = new WebDriverWait(driver,5);
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
    	OPiRCA obj = new OPiRCA();
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAInfoPageDesc)).getText();
		softly.assertThat(heading).as("test data").contains("组织职能或结构不足");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionPlusSign)).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionText)).getText();
		softly.assertThat(desc).as("test data").contains("组织设计是否为了执行核心工作流程而忽略了主要职能、相互制衡或结构的不足？如果是，选择为什么并输入支持性证据。");
		softly.assertThat(desc).as("test data").contains("相关例子包含:");
		softly.assertThat(desc).as("test data").contains("- 主要职能存在不足.");
		softly.assertThat(desc).as("test data").contains("- 相互制衡存在不足");
		softly.assertThat(desc).as("test data").contains("- 过多的管理层级阻碍决策制定的质量和工作流程的速度");
		softly.assertThat(desc).as("test data").contains("- 组织结构不足（常规会议、决策流程等）体现在（1）在资源分配（资本预算、O&M预算、人员配置等级、仓库库存等）方面制定质量判定，（2）处理紧急问题和（3）制定绩效标准和控");
		softly.assertThat(desc).as("test data").contains("- 领导经验存在不足");
		softly.assertThat(desc).as("test data").contains("- 组织设计存在不足");
		softly.assertThat(desc).as("test data").contains("- 标杆管理存在不足");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionPlusSign)).click();
		//O1.1 question
		String q1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer1)).getText();
		softly.assertThat(q1).as("test data").contains("[O1.1] 管理职能不足: (1) 职能协调人或经理不足; (2) 管理决策职能不足; (3) 问题解决职能不足; (4) 工作计划职能不足; (5) 资源分配职能不足; (6) 管理和人员培训职能不足; (7) 人力资源职能（或结构）不足");
		//Evidence entry collapsible text
		String e1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry1)).getText();
		softly.assertThat(e1).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).click();
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).getText();
		softly.assertThat(c1).as("test data").contains("可能的纠正行动");
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1Text1)).getText();
		softly.assertThat(c2).as("test data").contains("改进管理职能");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).click();
		//O1.2 question
		String q2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer2)).getText();
		softly.assertThat(q2).as("test data").contains("[O1.2] 跨领域职能管理不足: (1) 职能协调人或经理不足; (2) 人因绩效提升职能不足; (3) 设备性能提升职能不足");
		//Evidence entry collapsible text
		String e2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry2)).getText();
		softly.assertThat(e2).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).click();
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).getText();
		softly.assertThat(c3).as("test data").contains("可能的纠正行动");
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2Text1)).getText();
		softly.assertThat(c4).as("test data").contains("改进跨领域职能");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction2)).click();
		//O1.3 question
		String q3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer3)).getText();
		softly.assertThat(q3).as("test data").contains("[O1.3] 三大组织—生产、监督和管理支持中的独立性不足，例如: (1) 允许纠正行动计划经理向生产相关经理汇报; (2) 允许QA经理出席根本原因审查委员会或者项目管理委员会; (3) 允许IT经理向监督组织经理汇报");
		//Evidence entry collapsible text
		String e3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry3)).getText();
		softly.assertThat(e3).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).click();
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).getText();
		softly.assertThat(c5).as("test data").contains("可能的纠正行动");
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3Text1)).getText();
		softly.assertThat(c6).as("test data").contains("改组");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).click();
		//O1.4 question
		String q4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer4)).getText();
		softly.assertThat(q4).as("test data").contains("[O1.4] 生产组织结构不足，例如: (1) 执行核心工作流程的结构存在不足; (2) 不同生产线的结构分隔存在不足; (3) 班值存在不足");
		//Evidence entry collapsible text
		String e4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry4)).getText();
		softly.assertThat(e4).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4)).click();
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4)).getText();
		softly.assertThat(c7).as("test data").contains("可能的纠正行动");
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4Text1)).getText();
		softly.assertThat(c8).as("test data").contains("改进生产组织结构");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction4)).click();
		//O1.5 question
		String q5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer5)).getText();
		softly.assertThat(q5).as("test data").contains("[O1.5] 监督组织结构不足，例如: (1) 生产或管理支持相关管理团队的监督; (2) 生产经理以下管理层级的管理人员监督; (3) 监督结构未基于专业（例如无损试验、QA、QC等）");
		//Evidence entry collapsible text
		String e5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry5)).getText();
		softly.assertThat(e5).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5)).click();
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5)).getText();
		softly.assertThat(c9).as("test data").contains("可能的纠正行动");
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5Text1)).getText();
		softly.assertThat(c10).as("test data").contains("改进监督组织结构");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction5)).click();
		//Scroll down
		Thread.sleep(1000);
		jse.executeScript("scroll(0,1500)");
		Thread.sleep(1000);
		//O1.6 question
		String q6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer6)).getText();
		softly.assertThat(q6).as("test data").contains("[O1.6] 管理支持组织结构不足，例如: (1) 招聘结构不足; (2) 继任计划不足; (3) 培训或授权不足");
		//Evidence entry collapsible text
		String e6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry6)).getText();
		softly.assertThat(e6).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction6)).click();
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction6)).getText();
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction6Text1)).getText();
		softly.assertThat(c12).as("test data").contains("改进监督组织结构");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction6)).click();
		//O1.7 question
		String q7 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer7)).getText();
		softly.assertThat(q7).as("test data").contains("[O1.7] 区分短期和长期工作的组织结构存在不足，例如: (1) 一组工程人员处理短期和长期设计改造; (2) 一组维修人员处理紧急和非紧急工作");
		//Evidence entry collapsible text
		String e7 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry7)).getText();
		softly.assertThat(e7).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction7)).click();
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction7)).getText();
		softly.assertThat(c13).as("test data").contains("可能的纠正行动");
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction7Text1)).getText();
		softly.assertThat(c14).as("test data").contains("区分处理短期和长期工作的人员");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction7)).click();
		//O1.8 question
		String q8 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer8)).getText();
		softly.assertThat(q8).as("test data").contains("[O1.8] 管理层级不足: (1) 规则型和技能型的小组层级过多; (2) 知识型小组层级不足");
		//Evidence entry collapsible text
		String e8 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry8)).getText();
		softly.assertThat(e8).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction8)).click();
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction8)).getText();
		softly.assertThat(c15).as("test data").contains("可能的纠正行动");
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction8Text1)).getText();
		softly.assertThat(c16).as("test data").contains("根据工作的复杂性优化管理层级");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction8)).click();
		//O1.9 question
		String q9 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer9)).getText();
		softly.assertThat(q9).as("test data").contains("[O1.9] 管理跨度不足 : (1) 向一位主管或经理汇报的人员过多; (2) 向一位主管或经理汇报的人员过少");
		//Evidence entry collapsible text
		String e9 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry9)).getText();
		softly.assertThat(e9).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction9)).click();
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction9)).getText();
		softly.assertThat(c17).as("test data").contains("可能的纠正行动");
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction9Text)).getText();
		softly.assertThat(c18).as("test data").contains("根据人员经验优化管理跨度");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction9)).click();
		//O1.10 question
		String q10 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer10)).getText();
		softly.assertThat(q10).as("test data").contains("[O1.10] 组织设计和改进方面的领导参与存在不足: (1) 领导层未参与组织问题解决过程中; (2) 领导层未参与组织结构和职能设计中");
		//Evidence entry collapsible text
		String e10 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry10)).getText();
		softly.assertThat(e10).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction10)).click();
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction10)).getText();
		softly.assertThat(c19).as("test data").contains("可能的纠正行动");
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction10Text)).getText();
		softly.assertThat(c20).as("test data").contains("提高领导层在组织设计和改进方面的参与");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction10)).click();
		//O1.11 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswer11)).getText();
		softly.assertThat(q11).as("test data").contains("[O1.11] 管理职能方面的领导参与不足");
		//Evidence entry collapsible text
		String e11 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerEvidenceEntry11)).getText();
		softly.assertThat(e11).as("test data").contains("支持证据");
		//Corrective action
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction11)).click();
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction11)).getText();
		softly.assertThat(c21).as("test data").contains("可能的纠正行动");
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction11Text)).getText();
		softly.assertThat(c22).as("test data").contains("提高领导层在管理职能方面的参与");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction11)).click();
		//Contributing factor
		chineseOPiRCAContributingFactor(driver);
    }
    
    public void chineseOPiRCAContributingFactor(WebDriver driver) throws Exception {
    	
    	WebDriverWait wait = new WebDriverWait(driver,5);
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
    	OPiRCA obj = new OPiRCA ();
    	//Scroll down
    	WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.OPiRCAAddContributingFactorButton));
    	Point p = l.getLocation();
		int yaxis= p.getY()-250;
		Thread.sleep(1000);
		jse.executeScript("scroll(0,"+yaxis+")");
		Thread.sleep(1000);
		//Chinese verification of contributing factor
		String s = l.getText();
		softly.assertThat(s).as("test data").isEqualTo("新增促成因素");
		//Click on button
		l.click();
		//Verify chinese for the fields
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCANewContributingFactorField1Label)).getText();
		softly.assertThat(s1).as("test data").contains("促成因素:");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.OPiRCANewContributingFactorField)).getAttribute("placeholder");
		softly.assertThat(s2).as("test data").contains("输入 促成因素");
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCANewContributingFactorField2Label)).getText();
		softly.assertThat(s3).as("test data").contains("可能的纠正行动:");
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCANewContributingFactorField2)).getAttribute("placeholder");
		softly.assertThat(s4).as("test data").contains("输入 可能的纠正行动 (非必填)");
    }
	
    public void selectAllApparentCausesAnswers(WebDriver driver) throws Exception{
    	
    	WebDriverWait wait = new WebDriverWait(driver,5);
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
    	OPiRCA obj = new OPiRCA();
    	int count =0;
    	int k=1;
    	//Identify number of answers for an apparent cause
    	while(true)
    	{
    		try{
    			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/div["+k+"]"))).getAttribute("class");
    			k=k+1;
    			if(s.equals("ui-contain"))
    				count = count +1;
    		}catch(NoSuchElementException | org.openqa.selenium.TimeoutException e)
    		{
    			break;
    		}
    	}
    	for(int j=1;j<=count;j++)
    	{
    		//Click on answer
    		WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/div["+j+"]/fieldset/div/div/label")));
    		//Scroll to element
    		Point p = l.getLocation();
    		int yaxis= p.getY()-250;
    		Thread.sleep(500);
    		jse.executeScript("scroll(0,"+yaxis+")");
    		Thread.sleep(500);
    		l.click();
    	}
    	//Scroll to top
    	Thread.sleep(1000);
    	jse.executeScript("scroll(0,0)");
    	Thread.sleep(1000);
    	//Click on next
    	wait.until(ExpectedConditions.visibilityOfElementLocated(obj.OPiRCANextButton)).click();    	  	
    }
	
	public void chineseApparentCauses (WebDriver driver) throws Exception {
    	WebDriverWait wait = new WebDriverWait(driver,10);
    	String s = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseO1)).getText();
    	softly.assertThat(s).isEqualTo("O1: 组织职能或结构不足");
    	String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseO3)).getText();
    	softly.assertThat(s1).isEqualTo("O3: 流程设计和改进能力不足");
    	String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseO4)).getText();
    	softly.assertThat(s2).isEqualTo("O4: 组织内沟通存在不足");
    	String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseO5)).getText();
    	softly.assertThat(s3).isEqualTo("O5: 个人技能、规则使用或知识方面存在不足");
    	String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseOO1)).getText();
    	softly.assertThat(s4).isEqualTo("OO1: 共同目标/利益/问责机制存在不足");
    	String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseOO2)).getText();
    	softly.assertThat(s5).isEqualTo("OO2: 组织之间的接口存在不足");
    	String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseOO3)).getText();
    	softly.assertThat(s6).isEqualTo("OO3: 两个接口组织之间的工作职能存在重叠或遗漏");
    	String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseOP1)).getText();
    	softly.assertThat(s7).isEqualTo("OP1: 实施投入存在不足");
    	String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseOP2)).getText();
    	softly.assertThat(s8).isEqualTo("OP2: 绩效监督跟踪和趋势分析存在不足");
    	String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseOP3)).getText();
    	softly.assertThat(s9).isEqualTo("OP3: 自我评价或评估存在不足");
    	String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseOP4)).getText();
    	softly.assertThat(s10).isEqualTo("OP4: 主人翁意识、责任、角色和问责机制存在不足");
    	String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseP1)).getText();
    	softly.assertThat(s11).isEqualTo("P1: 制度遗漏");
    	String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseP2)).getText();
    	softly.assertThat(s12).isEqualTo("P2: 全面性不足");
    	String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseP3)).getText();
    	softly.assertThat(s13).isEqualTo("P3: 偏差控制存在不足");
    	String s14 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseP4)).getText();
    	softly.assertThat(s14).isEqualTo("P4: 明确性不足或不正确");
    	String s15 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseP5)).getText();
    	softly.assertThat(s15).isEqualTo("P5: 要求过多");
	}
	
	public void chineseOPiRCAStep1 (WebDriver driver) throws Exception {
    	WebDriverWait wait = new WebDriverWait(driver,10);
    	OPiRCA obj = new OPiRCA();
		//OPiRCA Page Title
		String opirca_title = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAInfoPageTitle)).getText();
		softly.assertThat(opirca_title).as("test data").contains("第一步：直接原因");
		//OPiRCA Description of page
		String opirca_desc = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAInfoPageDesc)).getText();
		softly.assertThat(opirca_desc).as("test data").contains("选择HiRCA的结果（若适用）");
		//Title above dropdown
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep1TitleAboveDropdown)).getText();
		softly.assertThat(s).as("test data").contains("选择HiRCA所得出的结论:");
		//Title below dropdown
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAStep1TitleBelowDropdown)).getText();
		softly.assertThat(s1).as("test data").contains("组织与制度直接原因:");
		//Click on Description
    	wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionPlusSign)).click();
    	//Verify description text
    	String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionText)).getText();
    	softly.assertThat(s2).as("test data").contains("用于调查人因事件。如果有迹象表明人因问题是由于重要的组织与制度（");
    	softly.assertThat(s2).as("test data").contains("）问题引起的或问题十分普遍，则需要运用");
    	softly.assertThat(s2).as("test data").contains("一旦人因事件的根本原因被录入");
    	softly.assertThat(s2).as("test data").contains("，就需要对根本原因进行进一步调查，以确定问题是与不适当的制度或组织问题造成的。");
    	softly.assertThat(s2).as("test data").contains("如果是这样，应通过");
    	softly.assertThat(s2).as("test data").contains(" 调查O&P根本原因。由于多种");
    	softly.assertThat(s2).as("test data").contains("结果可在同一时间处理同一组织的人因问题，应通过相同的");
    	softly.assertThat(s2).as("test data").contains("考虑，以发现O&P问题的根本原因。");
    	softly.assertThat(s2).as("test data").contains("如适用，选择");
    	softly.assertThat(s2).as("test data").contains("报告中的根本原因。如果针对一起事件存在多种");
    	softly.assertThat(s2).as("test data").contains("报告，应输入所有结果。");
    	//Click on Description
    	wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionPlusSign)).click();
    	//Verify chinese for all HiRCA Level 3 options
    	chineseHiRCALevel3(driver);
	}
	
	public void chineseHiRCALevel3(WebDriver driver) throws Exception {
    	String s = driver.findElement(OPiRCAHiRCALevelOption31).getText();
    	softly.assertThat(s).as("test data").isEqualTo("3.1 个人层面");
    	String s1 = driver.findElement(OPiRCAHiRCALevelOption32).getText();
    	softly.assertThat(s1).as("test data").isEqualTo("3.2 组长主管层面");
    	String s2 = driver.findElement(OPiRCAHiRCALevelOption331).getText();
    	softly.assertThat(s2).as("test data").isEqualTo("3.3.1 经理团队资源分配不到位");
    	String s3 = driver.findElement(OPiRCAHiRCALevelOption332).getText();
    	softly.assertThat(s3).as("test data").isEqualTo("3.3.2 经理团队所需培训开展不充分");
    	String s4 = driver.findElement(OPiRCAHiRCALevelOption333).getText();
    	softly.assertThat(s4).as("test data").isEqualTo("3.3.3 经理团队问责制不到位");
    	String s5 = driver.findElement(OPiRCAHiRCALevelOption334).getText();
    	softly.assertThat(s5).as("test data").isEqualTo("3.3.4 经理团队对确定工作优先级和计划方面不到位");
    	String s6 = driver.findElement(OPiRCAHiRCALevelOption335).getText();
    	softly.assertThat(s6).as("test data").isEqualTo("3.3.5 经理管理人员对以下标准制定不充分：(1) 行为规范 (2) 程序和屏障");
    	String s7 = driver.findElement(OPiRCAHiRCALevelOption336).getText();
    	softly.assertThat(s7).as("test data").isEqualTo("3.3.6 经理团队绩效跟踪与趋势分析不到位");
    	String s8 = driver.findElement(OPiRCAHiRCALevelOption337).getText();
    	softly.assertThat(s8).as("test data").isEqualTo("3.3.7 经理团队内未充分建立关于团队合作的共同目标、共同利益和共同责任");
    	String s9 = driver.findElement(OPiRCAHiRCALevelOption338).getText();
    	softly.assertThat(s9).as("test data").isEqualTo("3.3.8 经理团队纠正行动不足");
    	String s10 = driver.findElement(OPiRCAHiRCALevelOption339).getText();
    	softly.assertThat(s10).as("test data").isEqualTo("3.3.9 经理团队垂直沟通体系不完善");
    	String s11 = driver.findElement(OPiRCAHiRCALevelOption3310).getText();
    	softly.assertThat(s11).as("test data").isEqualTo("3.3.10 经理团队横向沟通体系不完善");
    	String s12 = driver.findElement(OPiRCAHiRCALevelOption34).getText();
    	softly.assertThat(s12).as("test data").isEqualTo("3.4 关键思考和关键追问不充分");
    	String s13 = driver.findElement(OPiRCAHiRCALevelOption35).getText();
    	softly.assertThat(s13).as("test data").isEqualTo("3.5 情况警觉不充分");
    	String s14 = driver.findElement(OPiRCAHiRCALevelOption36).getText();
    	softly.assertThat(s14).as("test data").isEqualTo("3.6 全面性不足");
    	String s15 = driver.findElement(OPiRCAHiRCALevelOption37).getText();
    	softly.assertThat(s15).as("test data").isEqualTo("3.7 \"偏差控制\"不到位");
    	String s16 = driver.findElement(OPiRCAHiRCALevelOption38).getText();
    	softly.assertThat(s16).as("test data").isEqualTo("3.8 \"明确性\"欠缺");
    	String s17 = driver.findElement(OPiRCAHiRCALevelOption39).getText();
    	softly.assertThat(s17).as("test data").isEqualTo("3.9 \"培训\"不充分");
    	String s18 = driver.findElement(OPiRCAHiRCALevelOption310).getText();
    	softly.assertThat(s18).as("test data").isEqualTo("3.10 \"资格授权\"不充分");
    	String s19 = driver.findElement(OPiRCAHiRCALevelOption311).getText();
    	softly.assertThat(s19).as("test data").isEqualTo("3.11 \"工作问责\"不充分");
    	String s20 = driver.findElement(OPiRCAHiRCALevelOption312).getText();
    	softly.assertThat(s20).as("test data").isEqualTo("3.12 \"负担\"的促成因素");
    	String s21 = driver.findElement(OPiRCAHiRCALevelOption313).getText();
    	softly.assertThat(s21).as("test data").isEqualTo("3.13 \"不当动机\"的促成因素");
    	String s22 = driver.findElement(OPiRCAHiRCALevelOption314).getText();
    	softly.assertThat(s22).as("test data").isEqualTo("3.14 \"预期风险低\"的促成因素");
    	String s23 = driver.findElement(OPiRCAHiRCALevelOption315).getText();
    	softly.assertThat(s23).as("test data").isEqualTo("3.15 \"同事互助提醒（好文化）\"不充分的促成因素");
    	String s24 = driver.findElement(OPiRCAHiRCALevelOption316).getText();
    	softly.assertThat(s24).as("test data").isEqualTo("3.16 粗心犯错的促成因素");
    	String s25 = driver.findElement(OPiRCAHiRCALevelOption317).getText();
    	softly.assertThat(s25).as("test data").isEqualTo("3.17 设备的鉴定、试验和维修(QTM)");
    	String s26 = driver.findElement(OPiRCAHiRCALevelOption318).getText();
    	softly.assertThat(s26).as("test data").isEqualTo("3.18 知识型错误");
    	String s27 = driver.findElement(OPiRCAHiRCALevelOption319).getText();
    	softly.assertThat(s27).as("test data").isEqualTo("3.19 工前会、班前会、交底会参与不足");
    	String s28 = driver.findElement(OPiRCAHiRCALevelOption320).getText();
    	softly.assertThat(s28).as("test data").contains("技术");
    	String s29 = driver.findElement(OPiRCAHiRCALevelOption321).getText();
    	softly.assertThat(s29).as("test data").contains("3.21 高风险情况(TAPE");
    	String s30 = driver.findElement(OPiRCAHiRCALevelOption322).getText();
    	softly.assertThat(s30).as("test data").isEqualTo("3.22 规则不正确");
	}
	
	public void selectAllHiRCALevel3Options (WebDriver driver) throws Exception {
    	WebDriverWait wait = new WebDriverWait(driver,10);
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
    	OPiRCA obj = new OPiRCA();
    	//Create a List to store HiRCA selections
    	List<String> hircaL3 = new ArrayList<String>();
    	//Click on HiRCA button
    	wait.until(ExpectedConditions.visibilityOfElementLocated(obj.HiRCADropdownMenuButton)).click();
    	for(int i=1;i<=31;i++)
    	{
    		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.HiRCADropdownMenuPopup));
    		WebElement l = ele.findElement(By.xpath(".//*[@data-option-index='"+i+"']/a"));
    		//Scroll to element
    		Point p = l.getLocation();
    		int yaxis= p.getY()-250;
    		Thread.sleep(2000);
    		jse.executeScript("scroll(0,"+yaxis+")");
    		Thread.sleep(2000);
    		//Click on option
    		l.click();
    		//Store selection name in list
    		String s = l.getText();
    		hircaL3.add(s);
    	}
    	//Scroll to the top
    	Thread.sleep(2000);
		jse.executeScript("scroll(0,0)");
		Thread.sleep(2000);
    	//Close the pop up
    	wait.until(ExpectedConditions.visibilityOfElementLocated(obj.HiRCADropdownMenuCloseButton)).click();	
	}
	
	public void chineseErrorsInfoPage (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		//Title error
		String opircaEventTitleError = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAEventTitleError)).getText();
		softly.assertThat(opircaEventTitleError).as("test data").contains("事件名称 必填");
		//Location error
		String opircaEventLocationError = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAEventLocationError)).getText();
		softly.assertThat(opircaEventLocationError).as("test data").contains("事件发生地点 必填");
		//Problem Statement error
		String opircaEventProblemStatementError = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAEventProblemStatementError)).getText();
		softly.assertThat(opircaEventProblemStatementError).as("test data").contains("事件描述 必填");
		//Timeline error
		String opircaEventTimelineError = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAEventTimelineError)).getText();
		softly.assertThat(opircaEventTimelineError).as("test data").contains("事件详细过程（时序构建） 必填");
		//Background Info error
		String opircaEventBackgroundError = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAEventBackgroundError)).getText();
		softly.assertThat(opircaEventBackgroundError).as("test data").contains("相关信息 必填");
		//Investigator error
		String opircaEventInvestigatorError = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAEventInvestigatorError)).getText();
		softly.assertThat(opircaEventInvestigatorError).as("test data").contains("事件调查员 必填");
	}
		
	public void chineseEventInfoFill (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		EiRCAChinese obj = new EiRCAChinese();
		OPiRCA obj1 = new OPiRCA ();
		//Fills the mandatory fields
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.OPiRCAEventTitleField)).sendKeys(obj.text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.OPiRCAEventLocationField)).sendKeys(obj.text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.OPiRCAProblemStatementField)).sendKeys(obj.text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.OPiRCATimelineOfEventField)).sendKeys(obj.text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.OPiRCABackgroundInfoField)).sendKeys(obj.text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.OPiRCAInvestigatorsField)).sendKeys(obj.text);
		Thread.sleep(2000);
		jse.executeScript("scroll(0,1500)");
		//Clicks on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.OPiRCANextButtonAtBottomOfInfoTab)).click();
		//Scroll top
		Thread.sleep(2000);
		jse.executeScript("scroll(0,0)");
		Thread.sleep(2000);		
	}
	
	public void chineseInfoPage (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		OPiRCA obj = new OPiRCA ();
		//OPiRCA Page Title
		String opirca_title = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAInfoPageTitle)).getText();
		softly.assertThat(opirca_title).as("test data").contains("事件信息");
		//OPiRCA Description of page
		String opirca_desc = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAInfoPageDesc)).getText();
		softly.assertThat(opirca_desc).as("test data").contains("输入事件信息");
		//Event title label
		String opircaEventTitleLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAEventTitleLabel)).getText();
		softly.assertThat(opircaEventTitleLabel).as("test data").contains("事件名称:");
		//Event title field placeholder
		String opircaEventTitleField = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.OPiRCAEventTitleField)).getAttribute("placeholder");
		softly.assertThat(opircaEventTitleField).as("test data").contains("输入 事件名称");
		//Event id label
		String opircaEventIdLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAEventIdLabel)).getText();
		softly.assertThat(opircaEventIdLabel).as("test data").contains("事件编号:");
		//Event id field
		String opircaEventIdField = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAEventIdField)).getAttribute("placeholder");
		softly.assertThat(opircaEventIdField).as("test data").contains("输入 事件编号 (非必填)");
		//Event location label
		String opircaEventLocLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAEventLocationLabel)).getText();
		softly.assertThat(opircaEventLocLabel).as("test data").contains("事件发生地点:");
		//Event location field
		String opircaEventLocField = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.OPiRCAEventLocationField)).getAttribute("placeholder");
		softly.assertThat(opircaEventLocField).as("test data").contains("输入 事件发生地点");
		//Event date label
		String opircaEventDateLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAEventDateLabel)).getText();
		softly.assertThat(opircaEventDateLabel).as("test data").contains("事件发生日期:");
		//Event time label
		String opircaEventTimeLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAEventTimeLabel)).getText();
		softly.assertThat(opircaEventTimeLabel).as("test data").contains("事件发生时间:");
		//Event Problem Statement label
		String opircaEventpbLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAEventProblemStatementLabel)).getText();
		softly.assertThat(opircaEventpbLabel).as("test data").contains("事件描述:");
		//Event Problem Statement field
		String opircaEventpbField = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.OPiRCAProblemStatementField)).getAttribute("placeholder");
		softly.assertThat(opircaEventpbField).as("test data").contains("输入 事件描述");
		//Event Executive Summary label
		String opircaEventExecLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAEventExecutiveSummaryLabel)).getText();
		softly.assertThat(opircaEventExecLabel).as("test data").contains("报告摘要:");
		//Event Executive Summary field
		String opircaEventExecField = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAEventExecutiveSummaryField)).getAttribute("placeholder");
		softly.assertThat(opircaEventExecField).as("test data").contains("输入 报告摘要 (非必填)");
		//Event Timeline of Events label
		String opircaEventTimelineLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAEventTimelineOfEventLabel)).getText();
		softly.assertThat(opircaEventTimelineLabel).as("test data").contains("事件详细过程（时序构建）:");
		//Event Timeline of Events field
		String opircaEventTimelineField = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.OPiRCATimelineOfEventField)).getAttribute("placeholder");
		softly.assertThat(opircaEventTimelineField).as("test data").contains("输入 事件详细过程（时序构建）");
		//Event Background info label
		String opircaEventBackgroundLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAEventBackgroundInfoLabel)).getText();
		softly.assertThat(opircaEventBackgroundLabel).as("test data").contains("相关信息:");
		//Event Background info field
		String opircaEventBackgroundField = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.OPiRCABackgroundInfoField)).getAttribute("placeholder");
		softly.assertThat(opircaEventBackgroundField).as("test data").contains("输入 相关信息");
		//Event Investigator label
		String opircaEventInvestigatorLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAEventInvestigatorLabel)).getText();
		softly.assertThat(opircaEventInvestigatorLabel).as("test data").contains("事件调查员:");
		//Event Investigator field
		String opircaEventInvestigatorField = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.OPiRCAInvestigatorsField)).getAttribute("placeholder");
		softly.assertThat(opircaEventInvestigatorField).as("test data").contains("输入 事件调查员");
		//Event Report date label
		String opircaEventRepDateLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAReportCreationDateTimeLabel)).getText();
		softly.assertThat(opircaEventRepDateLabel).as("test data").contains("报告编写时间:");
	}
	
    public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}
}
