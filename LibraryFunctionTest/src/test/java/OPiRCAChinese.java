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
	//By OPiRCAHiRCALevel3ListSelect = By.id("pii-opa-step1-select");
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
	By OPiRCAApparentCauseAnswerCorrectiveAction1 = By.xpath(".//*[@id='efi-opa-answers']/div/fieldset/div[1]/div[2]/div[2]/h4/a");
	By OPiRCAApparentCauseAnswerCorrectiveAction1Text1 = By.xpath(".//*[@id='efi-opa-answers']/div/fieldset/div[1]/div[2]/div[2]/div/ul/ul/li[1]");
	By OPiRCAApparentCauseAnswerCorrectiveAction1Text2 = By.xpath(".//*[@id='efi-opa-answers']/div/fieldset/div[1]/div[2]/div[2]/div/ul/ul/li[2]");
	By OPiRCAApparentCauseAnswerCorrectiveAction1Text3 = By.xpath(".//*[@id='efi-opa-answers']/div/fieldset/div[1]/div[2]/div[2]/div/ul/ul/li[3]");
	By OPiRCAApparentCauseAnswerCorrectiveAction1Text4 = By.xpath(".//*[@id='efi-opa-answers']/div/fieldset/div[1]/div[2]/div[2]/div/ul/ul/li[4]");
	By OPiRCAApparentCauseAnswerEvidenceEntry2 = By.xpath(".//*[@id='efi-opa-evidence-text-div-1']/h4/a");
	By OPiRCAApparentCauseAnswerCorrectiveAction2 = By.xpath(".//*[@id='efi-opa-answers']/div/fieldset/div[2]/div[2]/div[2]/h4/a");
	By OPiRCAApparentCauseAnswerCorrectiveAction2Text1 = By.xpath(".//*[@id='efi-opa-answers']/div/fieldset/div[2]/div[2]/div[2]/div/ul/ul/li[1]");
	By OPiRCAApparentCauseAnswerCorrectiveAction2Text2 = By.xpath(".//*[@id='efi-opa-answers']/div/fieldset/div[2]/div[2]/div[2]/div/ul/ul/li[2]");
	By OPiRCAApparentCauseAnswerCorrectiveAction2Text3 = By.xpath(".//*[@id='efi-opa-answers']/div/fieldset/div[2]/div[2]/div[2]/div/ul/ul/li[3]");
	By OPiRCAApparentCauseAnswerCorrectiveAction2Text4 = By.xpath(".//*[@id='efi-opa-answers']/div/fieldset/div[2]/div[2]/div[2]/div/ul/ul/li[4]");
	By OPiRCAApparentCauseAnswerEvidenceEntry3 = By.xpath(".//*[@id='efi-opa-evidence-text-div-2']/h4/a");
	By OPiRCAApparentCauseAnswerCorrectiveAction3 = By.xpath(".//*[@id='efi-opa-answers']/div/fieldset/div[3]/div[2]/div[2]/h4/a");
	By OPiRCAApparentCauseAnswerCorrectiveAction3Text1 = By.xpath(".//*[@id='efi-opa-answers']/div/fieldset/div[3]/div[2]/div[2]/div/ul/ul/li[1]");
	By OPiRCAApparentCauseAnswerCorrectiveAction3Text2 = By.xpath(".//*[@id='efi-opa-answers']/div/fieldset/div[3]/div[2]/div[2]/div/ul/ul/li[2]");
	By OPiRCAApparentCauseAnswerEvidenceEntry4 = By.xpath(".//*[@id='efi-opa-evidence-text-div-3']/h4/a");
	By OPiRCAApparentCauseAnswerCorrectiveAction4 = By.xpath(".//*[@id='efi-opa-answers']/div/fieldset/div[4]/div[2]/div[2]/h4/a");
	By OPiRCAApparentCauseAnswerCorrectiveAction4Text1 = By.xpath(".//*[@id='efi-opa-answers']/div/fieldset/div[4]/div[2]/div[2]/div/ul/ul/li[1]");
	By OPiRCAApparentCauseAnswerCorrectiveAction4Text2 = By.xpath(".//*[@id='efi-opa-answers']/div/fieldset/div[4]/div[2]/div[2]/div/ul/ul/li[2]");
	By OPiRCAApparentCauseAnswerEvidenceEntry5 = By.xpath(".//*[@id='efi-opa-evidence-text-div-4']/h4/a");
	By OPiRCAApparentCauseAnswerCorrectiveAction5 = By.xpath(".//*[@id='efi-opa-answers']/div/fieldset/div[5]/div[2]/div[2]/h4/a");
	By OPiRCAApparentCauseAnswerCorrectiveAction5Text1 = By.xpath(".//*[@id='efi-opa-answers']/div/fieldset/div[5]/div[2]/div[2]/div/ul/ul/li[1]");
	By OPiRCAApparentCauseAnswerCorrectiveAction5Text2 = By.xpath(".//*[@id='efi-opa-answers']/div/fieldset/div[5]/div[2]/div[2]/div/ul/ul/li[2]");
	By OPiRCAApparentCauseAnswerEvidenceEntry6 = By.xpath(".//*[@id='efi-opa-evidence-text-div-5']/h4/a");
	By OPiRCAApparentCauseAnswerCorrectiveAction6 = By.xpath(".//*[@id='efi-opa-answers']/div/fieldset/div[6]/div[2]/div[2]/h4/a");
	By OPiRCAApparentCauseAnswerCorrectiveAction6Text1 = By.xpath(".//*[@id='efi-opa-answers']/div/fieldset/div[6]/div[2]/div[2]/div/ul/ul/li[1]");
	By OPiRCAApparentCauseAnswerCorrectiveAction6Text2 = By.xpath(".//*[@id='efi-opa-answers']/div/fieldset/div[6]/div[2]/div[2]/div/ul/ul/li[2]");
	By OPiRCAApparentCauseAnswerEvidenceEntry7 = By.xpath(".//*[@id='efi-opa-evidence-text-div-6']/h4/a");
	By OPiRCAApparentCauseAnswerCorrectiveAction7 = By.xpath(".//*[@id='efi-opa-answers']/div/fieldset/div[7]/div[2]/div[2]/h4/a");
	By OPiRCAApparentCauseAnswerCorrectiveAction7Text1 = By.xpath(".//*[@id='efi-opa-answers']/div/fieldset/div[7]/div[2]/div[2]/div/ul/ul/li[1]");
	By OPiRCAApparentCauseAnswerCorrectiveAction7Text2 = By.xpath(".//*[@id='efi-opa-answers']/div/fieldset/div[7]/div[2]/div[2]/div/ul/ul/li[2]");
	By OPiRCAApparentCauseAnswerEvidenceEntry8 = By.xpath(".//*[@id='efi-opa-evidence-text-div-7']/h4/a");
	By OPiRCAApparentCauseAnswerCorrectiveAction8 = By.xpath(".//*[@id='efi-opa-answers']/div/fieldset/div[8]/div[2]/div[2]/h4/a");
	By OPiRCAApparentCauseAnswerCorrectiveAction8Text1 = By.xpath(".//*[@id='efi-opa-answers']/div/fieldset/div[8]/div[2]/div[2]/div/ul/ul/li[1]");
	By OPiRCAApparentCauseAnswerCorrectiveAction8Text2 = By.xpath(".//*[@id='efi-opa-answers']/div/fieldset/div[8]/div[2]/div[2]/div/ul/ul/li[2]");
	By OPiRCAApparentCauseAnswerEvidenceEntry9 = By.xpath(".//*[@id='efi-opa-evidence-text-div-8']/h4/a");
	By OPiRCAApparentCauseAnswerCorrectiveAction9 = By.xpath(".//*[@id='efi-opa-answers']/div/fieldset/div[9]/div[2]/div[2]/h4/a");
	By OPiRCAApparentCauseAnswerCorrectiveAction9Text = By.xpath(".//*[@id='efi-opa-answers']/div/fieldset/div[9]/div[2]/div[2]/div/ul/ul/li");
	By OPiRCAApparentCauseAnswerEvidenceEntry10 = By.xpath(".//*[@id='efi-opa-evidence-text-div-9']/h4/a");
	By OPiRCAApparentCauseAnswerCorrectiveAction10 = By.xpath(".//*[@id='efi-opa-answers']/div/fieldset/div[10]/div[2]/div[2]/h4/a");
	By OPiRCAApparentCauseAnswerCorrectiveAction10Text = By.xpath(".//*[@id='efi-opa-answers']/div/fieldset/div[10]/div[2]/div[2]/div/ul/ul/li");
	By OPiRCAApparentCauseAnswerEvidenceEntry11 = By.xpath(".//*[@id='efi-opa-evidence-text-div-10']/h4/a");
	By OPiRCAApparentCauseAnswerCorrectiveAction11 = By.xpath(".//*[@id='efi-opa-answers']/div/fieldset/div[11]/div[2]/div[2]/h4/a");
	By OPiRCAApparentCauseAnswerCorrectiveAction11Text = By.xpath(".//*[@id='efi-opa-answers']/div/fieldset/div[11]/div[2]/div[2]/div/ul/ul/li");
	By OPiRCANewContributingFactorField1Label = By.xpath(".//*[@for='pii-opa-addnewcf-cf']");
	By OPiRCANewContributingFactorField2Label = By.xpath(".//*[@for='pii-opa-addnewcf-ca']");
	By OPiRCANewContributingFactorField2 = By.id("pii-opa-addnewcf-ca");
	
	public void OPiRCApath (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		OPiRCA obj = new OPiRCA();
		EiRCAChinese obj1 = new EiRCAChinese();
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
	  	//Verify step 1
	  	chineseOPiRCAStep1(driver);
	  	//Select all HiRCA Level 3 Options
	  	selectAllHiRCALevel3Options(driver);
	  	//Verify chinese for all apparent causes selected
	  	chineseApparentCauses(driver);
		//Clicks on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.OPiRCANextButton)).click();
		//Verify chinese O1
		chineseApparentCauseO1(driver);
		//Select all O1
		selectAllApparentCausesAnswers(driver);
		//Verify chinese O3
		chineseApparentCauseO3(driver);
		//Select all O3
		selectAllApparentCausesAnswers(driver);
		//Verify chinese O4
		chineseApparentCauseO4(driver);
		//Select all O4
		selectAllApparentCausesAnswers(driver);
		//Verify chinese O5
		chineseApparentCauseO5(driver);
		//Select all O5
		selectAllApparentCausesAnswers(driver);
		//Verify chinese OO1
		chineseApparentCauseOO1(driver);
		//Select all OO1
		selectAllApparentCausesAnswers(driver);
		//Verify chinese OO2
		chineseApparentCauseOO2(driver);
		//Select all OO2
		selectAllApparentCausesAnswers(driver);
		//Verify chinese OO3
		chineseApparentCauseOO3(driver);
		//Select all OO3
		selectAllApparentCausesAnswers(driver);
		//Verify chinese OP1
		chineseApparentCauseOP1(driver);
		//Select all OP1
		selectAllApparentCausesAnswers(driver);
		//Verify chinese OP2
		chineseApparentCauseOP2(driver);
		//Select all OP2
		selectAllApparentCausesAnswers(driver);
		//Verify chinese OP3
		chineseApparentCauseOP3(driver);
		//Select all OP3
		selectAllApparentCausesAnswers(driver);
		//Verify chinese OP4
		chineseApparentCauseOP4(driver);
		//Select all OP4
		selectAllApparentCausesAnswers(driver);
		//Verify chinese P1
		chineseApparentCauseP1(driver);
		//Select all P1
		selectAllApparentCausesAnswers(driver);
		//Verify chinese P2
		chineseApparentCauseP2(driver);
		//Select all P2
		selectAllApparentCausesAnswers(driver);
		//Verify chinese P3
		chineseApparentCauseP3(driver);
		//Select all P3
		selectAllApparentCausesAnswers(driver);
		//Verify chinese P4
		chineseApparentCauseP4(driver);
		//Select all P4
		selectAllApparentCausesAnswers(driver);
		//Verify chinese P5
		chineseApparentCauseP5(driver);
		//Select all P5
		selectAllApparentCausesAnswers(driver);
		*
	}
	
    public void chineseApparentCauseP4(WebDriver driver) throws Exception{
    	
    	WebDriverWait wait = new WebDriverWait(driver,5);
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
    	OPiRCA obj = new OPiRCA();
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAInfoPageDesc)).getText();
		softly.assertThat(heading).as("test data").contains("偏差控制存在不足");*
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionPlusSign)).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionText)).getText();
		softly.assertThat(desc).as("test data").contains("问题是否源于缺少对程序检测和纠正的适当检查？请选择原因并输入支持性证据。");
		softly.assertThat(desc).as("test data").contains("当发生偏离程序使用目的、跳过步骤或跳过页次和超出程序外作业时，偏差步控制明显存在不足。常见问题如：程序没有对不能颠倒顺序执行的步骤设定操作标记、禁止进行程序外的操作，但是没有指定实时负责人，以便及时解决、没有识别出关键步骤安排适当的自检和独立验证。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.Step1DescriptionPlusSign)).click();
		//P4.1 question
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
		//P4.2 question
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
		//P4.3 question
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).click();
		String c25 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3Text2)).getText();
		softly.assertThat(c25).as("test data").contains("改进存在缺陷的导则或程序");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).click();
		//P4.4 question
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
		//P4.5 question
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
		jse.executeScript("scroll(0,0)");
		Thread.sleep(1000);
		//P4.6 question
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
		//P4.7 question
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction7)).click();
		String c29 = wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction7Text2)).getText();
		softly.assertThat(c29).as("test data").contains("改进存在缺陷的导则或程序");
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction7)).click();
		//P4.8 question
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction3)).click();
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
		jse.executeScript("scroll(0,0)");
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction7)).click();
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
		jse.executeScript("scroll(0,0)");
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
		jse.executeScript("scroll(0,0)");
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
		jse.executeScript("scroll(0,0)");
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(OPiRCAApparentCauseAnswerCorrectiveAction1)).click();
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
		jse.executeScript("scroll(0,0)");
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
		jse.executeScript("scroll(0,0)");
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
		jse.executeScript("scroll(0,0)");
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
		jse.executeScript("scroll(0,0)");
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
    		Thread.sleep(1000);
    		jse.executeScript("scroll(0,"+yaxis+")");
    		Thread.sleep(1000);
    		l.click();
    	}
    	//Scroll to top
    	Thread.sleep(2000);
    	jse.executeScript("scroll(0,0)");
    	Thread.sleep(2000);
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
