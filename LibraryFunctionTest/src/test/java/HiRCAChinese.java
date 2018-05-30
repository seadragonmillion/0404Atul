import java.util.concurrent.TimeUnit;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HiRCAChinese {
	
	SoftAssertions softly = new SoftAssertions();
	String text = "Chinese check";
	
	
	public void pathHiRCA(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Clicks on Analysis 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-a"))).click();
		//Clicks on HiRCA
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-hirca"))).click();
		Thread.sleep(2000);
		//Verify everything on Event Information page is in 
		chineseEventInfo(driver);
		//Event title
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-title"))).sendKeys(text);
		//Location of event
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-location"))).sendKeys(text);
		//Department
		WebElement dropdown = driver.findElement(By.id("pii-irca-event-department"));
		Select s = new Select (dropdown);
		s.selectByVisibleText("Construction");
		//Problem Statement
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-pbstatement"))).sendKeys(text);
		//Timeline of event
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-events"))).sendKeys(text);
		//Background info
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-bginfos"))).sendKeys(text);
		//Investigators
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-investigators"))).sendKeys(text);
		//Gets value of date
		String get_date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-date"))).getAttribute("value");
		System.out.println(get_date);
		//Gets value of time
		String get_time = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-time"))).getAttribute("value");
		System.out.println(get_time);
		//Gets value of department
		String get_dept = driver.findElement(By.id("pii-irca-event-department")).getAttribute("value");
		System.out.println(get_dept);
		jse.executeScript("scroll(0,6500)");
		//Clicks on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[16]/div/button"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.1
		chineseStepOneq11(driver);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.2
		chineseStepOneq12(driver);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.4
		chineseStepOneL34(driver);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.18
		chineseStepOneL318(driver);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.6
		chineseStepOneq16(driver);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.15
		chineseStepOneL315(driver);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.7
		chineseStepOneq17(driver);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.8
		chineseStepOneq18(driver);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.9
		chineseStepOneL39(driver);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.10
		chineseStepOneL310(driver);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.11
		chineseStepOneL311(driver);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.9
		chineseStepOneq19(driver);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.2
		chineseStepOneL32(driver);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.11
		chineseStepOneL311(driver);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.10
		chineseStepOneq110(driver);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.11
		chineseStepOneq111(driver);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.9
		chineseStepOneL39(driver);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.12
		chineseStepOneq112(driver);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.13
		chineseStepOneq113(driver);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.14
		chineseStepOneq114(driver);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.2
		chineseStepOneL32(driver);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.15
		chineseStepOneq115(driver);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.6
		chineseStepOneL36(driver);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.16
		chineseStepOneq116(driver);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.2
		chineseStepOneL32(driver);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.17
		chineseStepOneq117(driver);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.3
		chineseStepOneL33(driver);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.18
		chineseStepOneq118(driver);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.22
		chineseStepOneL322(driver);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.19
		chineseStepOneq119(driver);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.3
		chineseStepOneL33(driver);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.5
		chineseStepOneL35(driver);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.20
		chineseStepOneq120(driver);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.5
		chineseStepOneL35(driver);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify pop up for LOP/RC
		chineseLOPRC(driver);
		//Save 1st path
		saveReport1st(driver);
		//*
		//LOP pop up opens, click cancel
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-cancel"))).click();
		//Click on Step 1 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-tab-1"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.1
		chineseStepOneq11(driver);
		//Select answer 2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.17
		chineseStepOneL317(driver);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify pop up for LOP/RC
		chineseLOPRC(driver);
		//LOP pop up opens, click cancel
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-cancel"))).click();
		//Click on Step 1 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-tab-1"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.1
		chineseStepOneq11(driver);
		//Select answer 3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify pop up for LOP/RC
		chineseLOPRC(driver);
		//LOP pop up opens, click Root Cause
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed2"))).click();
		Thread.sleep(2000);
		//Verify SUEP
		chineseSUEP(driver);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify Step 4
		chineseStep4(driver);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify HiRCA Checklist
		chineseHIRCAChecklist(driver);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify Report
		chineseReport(driver);
		//Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))).click();
		//Verify Save box
		chineseSave(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		//Wait for black server load message to disappear
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);
		//Click on saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-btn-savedactivities"))).click();
		//Wait for black server load message to disappear
		obj.loadingServer(driver);
		//Clicks on first newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();
		//Wait for black server load message to disappear
		obj.loadingServer(driver);
		//Verify buttons on top
		chineseReportButtons(driver);
	}
	
	public void saveReport1st (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//LOP pop up opens, click Root Cause
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed2"))).click();
		Thread.sleep(2000);
		//Verify SUEP
		chineseSUEP(driver);
		//Verify all selections in SUEP as 1st path
		chineseLevel3SelectionsSUEP1st(driver);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify Step 4
		chineseStep4(driver);
		//Verify all selections in step 4 as 1st path
		chineseLevel3SelectionsStep4_1st(driver);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify HiRCA Checklist
		chineseHIRCAChecklist(driver);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify Report
		chineseReport(driver);
		//Verify report for 1st path
		chineseReport1stPath(driver);
		//*
	}
	
	public void chineseLevel3SelectionsStep4_1st(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Verify all selections here
		String tr = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[1]"))).getText();
		System.out.println(tr);
		softly.assertThat(tr).as("test data").isEqualTo("3.2.1: 组长强化标准方面的管理能力不足");
		String tr1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[3]/td[1]/label"))).getText();
		System.out.println(tr1);
		softly.assertThat(tr1).as("test data").contains("纠正行动:");
		String tr2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[3]/td[1]/label/small"))).getText();
		System.out.println(tr2);
		softly.assertThat(tr2).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[3]/td[1]/label/textarea"))).getText();
		System.out.println(tr3);
		softly.assertThat(tr3).as("test data").isEqualTo("监督管理方面的培训, 监督行为规范的管理");
		String tr4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[4]/td[1]"))).getText();
		System.out.println(tr4);
		softly.assertThat(tr4).as("test data").isEqualTo("3.2.2: 组长绩效反馈方面的管理能力不足");
		String tr5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[5]/td[1]/label"))).getText();
		System.out.println(tr5);
		softly.assertThat(tr5).as("test data").contains("纠正行动:");
		String tr6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[5]/td[1]/label/small"))).getText();
		System.out.println(tr6);
		softly.assertThat(tr6).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[5]/td[1]/label/textarea"))).getText();
		System.out.println(tr7);
		softly.assertThat(tr7).as("test data").isEqualTo("监督管理方面的培训, 监督行为规范的管理");
		String tr8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[6]/td[1]"))).getText();
		System.out.println(tr8);
		softly.assertThat(tr8).as("test data").isEqualTo("3.2.3: 组长召开经验反馈的管理技能不足");
		String tr9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[7]/td[1]/label"))).getText();
		System.out.println(tr9);
		softly.assertThat(tr9).as("test data").contains("纠正行动:");
		String tr10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[7]/td[1]/label/small"))).getText();
		System.out.println(tr10);
		softly.assertThat(tr10).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[7]/td[1]/label/textarea"))).getText();
		System.out.println(tr11);
		softly.assertThat(tr11).as("test data").isEqualTo("监督管理方面的培训, 监督行为规范的管理");
		String tr12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[8]/td[1]"))).getText();
		System.out.println(tr12);
		softly.assertThat(tr12).as("test data").isEqualTo("3.2.4: 组长在岗培训方面管理能力不足");
		String tr13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[9]/td[1]/label"))).getText();
		System.out.println(tr13);
		softly.assertThat(tr13).as("test data").contains("纠正行动:");
		String tr14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[9]/td[1]/label/small"))).getText();
		System.out.println(tr14);
		softly.assertThat(tr14).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[9]/td[1]/label/textarea"))).getText();
		System.out.println(tr15);
		softly.assertThat(tr15).as("test data").isEqualTo("监督管理方面的培训, 监督行为规范的管理");
		String tr16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[10]/td[1]"))).getText();
		System.out.println(tr16);
		softly.assertThat(tr16).as("test data").isEqualTo("3.2.5: 组长对团队缺点认识不足，缺乏相应弥补措施");
		String tr17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[11]/td[1]/label"))).getText();
		System.out.println(tr17);
		softly.assertThat(tr17).as("test data").contains("纠正行动:");
		String tr18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[11]/td[1]/label/small"))).getText();
		System.out.println(tr18);
		softly.assertThat(tr18).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[11]/td[1]/label/textarea"))).getText();
		System.out.println(tr19);
		softly.assertThat(tr19).as("test data").isEqualTo("监督管理方面的培训, 监督行为规范的管理");
		String tr20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[12]/td[1]"))).getText();
		System.out.println(tr20);
		softly.assertThat(tr20).as("test data").isEqualTo("3.2.6: 组长发出指令和后续贯彻的沟通及协调能力不足");
		String tr21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[13]/td[1]/label"))).getText();
		System.out.println(tr21);
		softly.assertThat(tr21).as("test data").contains("纠正行动:");
		String tr22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[13]/td[1]/label/small"))).getText();
		System.out.println(tr22);
		softly.assertThat(tr22).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[13]/td[1]/label/textarea"))).getText();
		System.out.println(tr23);
		softly.assertThat(tr23).as("test data").isEqualTo("监督管理方面的培训, 监督行为规范的管理");
		String tr24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[14]/td[1]"))).getText();
		System.out.println(tr24);
		softly.assertThat(tr24).as("test data").isEqualTo("3.3.1: 经理团队资源分配不到位");
		String tr25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[15]/td[1]/label"))).getText();
		System.out.println(tr25);
		softly.assertThat(tr25).as("test data").contains("纠正行动:");
		String tr26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[15]/td[1]/label/small"))).getText();
		System.out.println(tr26);
		softly.assertThat(tr26).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr27 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[15]/td[1]/label/textarea"))).getText();
		System.out.println(tr27);
		softly.assertThat(tr27).as("test data").isEqualTo("提升管理技能，完善资源分配体系");
		String tr28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[16]/td[1]"))).getText();
		System.out.println(tr28);
		softly.assertThat(tr28).as("test data").isEqualTo("3.3.2: 经理团队所需培训开展不充分");
		String tr29 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[17]/td[1]/label"))).getText();
		System.out.println(tr29);
		softly.assertThat(tr29).as("test data").contains("纠正行动:");
		String tr30 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[17]/td[1]/label/small"))).getText();
		System.out.println(tr30);
		softly.assertThat(tr30).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr31 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[17]/td[1]/label/textarea"))).getText();
		System.out.println(tr31);
		softly.assertThat(tr31).as("test data").isEqualTo("成立培训计划委员会");
		String tr32 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[18]/td[1]"))).getText();
		System.out.println(tr32);
		softly.assertThat(tr32).as("test data").isEqualTo("3.3.3: 经理团队问责制不到位");
		String tr33 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[19]/td[1]/label"))).getText();
		System.out.println(tr33);
		softly.assertThat(tr33).as("test data").contains("纠正行动:");
		String tr34 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[19]/td[1]/label/small"))).getText();
		System.out.println(tr34);
		softly.assertThat(tr34).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr35 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[19]/td[1]/label/textarea"))).getText();
		System.out.println(tr35);
		softly.assertThat(tr35).as("test data").isEqualTo("完善问责制");
		String tr36 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[20]/td[1]"))).getText();
		System.out.println(tr36);
		softly.assertThat(tr36).as("test data").isEqualTo("3.3.4: 经理团队对确定工作优先级和计划方面不到位");
		String tr37 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[21]/td[1]/label"))).getText();
		System.out.println(tr37);
		softly.assertThat(tr37).as("test data").contains("纠正行动:");
		String tr38 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[21]/td[1]/label/small"))).getText();
		System.out.println(tr38);
		softly.assertThat(tr38).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr39 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[21]/td[1]/label/textarea"))).getText();
		System.out.println(tr39);
		softly.assertThat(tr39).as("test data").contains("完善管理优先级确定和计划体系");
		String tr40 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[22]/td[1]"))).getText();
		System.out.println(tr40);
		softly.assertThat(tr40).as("test data").isEqualTo("3.3.5: 经理管理人员对以下标准制定不充分：(1) 行为规范 (2) 程序和屏障");
		String tr41 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[23]/td[1]/label"))).getText();
		System.out.println(tr41);
		softly.assertThat(tr41).as("test data").contains("纠正行动:");
		String tr42 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[23]/td[1]/label/small"))).getText();
		System.out.println(tr42);
		softly.assertThat(tr42).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr43 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[23]/td[1]/label/textarea"))).getText();
		System.out.println(tr43);
		softly.assertThat(tr43).as("test data").isEqualTo("开展关于标准设定的管理培训, 开展关于程序和保护屏障设计的培训");
		String tr44 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[24]/td[1]"))).getText();
		System.out.println(tr44);
		softly.assertThat(tr44).as("test data").isEqualTo("3.3.6: 经理团队绩效跟踪与趋势分析不到位");
		String tr45 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[25]/td[1]/label"))).getText();
		System.out.println(tr45);
		softly.assertThat(tr45).as("test data").contains("纠正行动:");
		String tr46 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[25]/td[1]/label/small"))).getText();
		System.out.println(tr46);
		softly.assertThat(tr46).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr47 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[25]/td[1]/label/textarea"))).getText();
		System.out.println(tr47);
		softly.assertThat(tr47).as("test data").isEqualTo("定期开展共因分析, 改善绩效跟踪与趋势分析项目, 完善KPI");
		String tr48 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[26]/td[1]"))).getText();
		System.out.println(tr48);
		softly.assertThat(tr48).as("test data").isEqualTo("3.3.7: 经理团队内未充分建立关于团队合作的共同目标、共同利益和共同责任");
		String tr49 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[27]/td[1]/label"))).getText();
		System.out.println(tr49);
		softly.assertThat(tr49).as("test data").contains("纠正行动:");
		String tr50 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[27]/td[1]/label/small"))).getText();
		System.out.println(tr50);
		softly.assertThat(tr50).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr51 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[27]/td[1]/label/textarea"))).getText();
		System.out.println(tr51);
		softly.assertThat(tr51).as("test data").isEqualTo("开展组织设计方面的管理培训, 在经理人员之间建立共同目标、共同利益和共同责任");
		String tr52 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[28]/td[1]"))).getText();
		System.out.println(tr52);
		softly.assertThat(tr52).as("test data").isEqualTo("3.3.8: 经理团队纠正行动不足");
		String tr53 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[29]/td[1]/label"))).getText();
		System.out.println(tr53);
		softly.assertThat(tr53).as("test data").contains("纠正行动:");
		String tr54 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[29]/td[1]/label/small"))).getText();
		System.out.println(tr54);
		softly.assertThat(tr54).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr55 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[29]/td[1]/label/textarea"))).getText();
		System.out.println(tr55);
		softly.assertThat(tr55).as("test data").isEqualTo("提高纠正行动计划的落实, 改善根本原因分析方法, 完善突发紧急问题（危机）管理机制");
		String tr56 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[30]/td[1]"))).getText();
		System.out.println(tr56);
		softly.assertThat(tr56).as("test data").isEqualTo("3.3.9: 经理团队垂直沟通体系不完善");
		String tr57 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[31]/td[1]/label"))).getText();
		System.out.println(tr57);
		softly.assertThat(tr57).as("test data").contains("纠正行动:");
		String tr58 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[31]/td[1]/label/small"))).getText();
		System.out.println(tr58);
		softly.assertThat(tr58).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr59 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[31]/td[1]/label/textarea"))).getText();
		System.out.println(tr59);
		softly.assertThat(tr59).as("test data").isEqualTo("完善垂直沟通体系");
		String tr60 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[32]/td[1]"))).getText();
		System.out.println(tr60);
		softly.assertThat(tr60).as("test data").isEqualTo("3.3.10: 经理团队横向沟通体系不完善");
		String tr61 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[33]/td[1]/label"))).getText();
		System.out.println(tr61);
		softly.assertThat(tr61).as("test data").contains("纠正行动:");
		String tr62 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[33]/td[1]/label/small"))).getText();
		System.out.println(tr62);
		softly.assertThat(tr62).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr63 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[33]/td[1]/label/textarea"))).getText();
		System.out.println(tr63);
		softly.assertThat(tr63).as("test data").isEqualTo("完善程序设计, 制定共同目标和共同利益");
		String tr64 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[34]/td[1]"))).getText();
		System.out.println(tr64);
		softly.assertThat(tr64).as("test data").isEqualTo("3.4.1: 采取行动前没有思考如何规划（如优先顺序、机会、沟通、时间管理等）");
		String tr65 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[35]/td[1]/label"))).getText();
		System.out.println(tr65);
		softly.assertThat(tr65).as("test data").contains("纠正行动:");
		String tr66 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[35]/td[1]/label/small"))).getText();
		System.out.println(tr66);
		softly.assertThat(tr66).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr67 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[35]/td[1]/label/textarea"))).getText();
		System.out.println(tr67);
		softly.assertThat(tr67).as("test data").isEqualTo("开展关键思考和关键追问方面的培训");
		String tr68 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[36]/td[1]"))).getText();
		System.out.println(tr68);
		softly.assertThat(tr68).as("test data").isEqualTo("3.4.2: 采取行动前没有考虑易出错的心理状况");
		String tr69 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[37]/td[1]/label"))).getText();
		System.out.println(tr69);
		softly.assertThat(tr69).as("test data").contains("纠正行动:");
		String tr70 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[37]/td[1]/label/small"))).getText();
		System.out.println(tr70);
		softly.assertThat(tr70).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr71 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[37]/td[1]/label/textarea"))).getText();
		System.out.println(tr71);
		softly.assertThat(tr71).as("test data").isEqualTo("开展关键思考和关键追问方面的培训");
		String tr72 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[38]/td[1]"))).getText();
		System.out.println(tr72);
		softly.assertThat(tr72).as("test data").isEqualTo("3.4.3: 采取行动前没有考虑高风险情境（如单项弱点）");
		String tr73 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[39]/td[1]/label"))).getText();
		System.out.println(tr73);
		softly.assertThat(tr73).as("test data").contains("纠正行动:");
		String tr74 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[39]/td[1]/label/small"))).getText();
		System.out.println(tr74);
		softly.assertThat(tr74).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr75 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[39]/td[1]/label/textarea"))).getText();
		System.out.println(tr75);
		softly.assertThat(tr75).as("test data").isEqualTo("开展关键思考和关键追问方面的培训");
		String tr76 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[40]/td[1]"))).getText();
		System.out.println(tr76);
		softly.assertThat(tr76).as("test data").isEqualTo("3.4.4: 感到疑惑时质疑不充分");
		String tr77 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[41]/td[1]/label"))).getText();
		System.out.println(tr77);
		softly.assertThat(tr77).as("test data").contains("纠正行动:");
		String tr78 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[41]/td[1]/label/small"))).getText();
		System.out.println(tr78);
		softly.assertThat(tr78).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr79 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[41]/td[1]/label/textarea"))).getText();
		System.out.println(tr79);
		softly.assertThat(tr79).as("test data").isEqualTo("开展关键思考和关键追问方面的培训");
		String tr80 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[42]/td[1]"))).getText();
		System.out.println(tr80);
		softly.assertThat(tr80).as("test data").isEqualTo("3.4.5: 任务准备过程中质疑不充分");
		String tr81 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[43]/td[1]/label"))).getText();
		System.out.println(tr81);
		softly.assertThat(tr81).as("test data").contains("纠正行动:");
		String tr82 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[43]/td[1]/label/small"))).getText();
		System.out.println(tr82);
		softly.assertThat(tr82).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr83 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[43]/td[1]/label/textarea"))).getText();
		System.out.println(tr83);
		softly.assertThat(tr83).as("test data").isEqualTo("开展关键思考和关键追问方面的培训");
		String tr84 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[44]/td[1]"))).getText();
		System.out.println(tr84);
		softly.assertThat(tr84).as("test data").isEqualTo("3.5.1: 作业前情况警觉（如易出错的精神状态和高风险情况）不充分");
		String tr85 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[45]/td[1]/label"))).getText();
		System.out.println(tr85);
		softly.assertThat(tr85).as("test data").contains("纠正行动:");
		String tr86 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[45]/td[1]/label/small"))).getText();
		System.out.println(tr86);
		softly.assertThat(tr86).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr87 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[45]/td[1]/label/textarea"))).getText();
		System.out.println(tr87);
		softly.assertThat(tr87).as("test data").isEqualTo("情况警觉培训, 作业前情况警觉（如 TAPE、工前会等）关于何时、何人、何事的要求");
		String tr88 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[46]/td[1]"))).getText();
		System.out.println(tr88);
		softly.assertThat(tr88).as("test data").isEqualTo("3.5.2: 作业过程中情况警觉（如易出错的精神状态和高风险情况）不充分");
		String tr89 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[47]/td[1]/label"))).getText();
		System.out.println(tr89);
		softly.assertThat(tr89).as("test data").contains("纠正行动:");
		String tr90 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[47]/td[1]/label/small"))).getText();
		System.out.println(tr90);
		softly.assertThat(tr90).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr91 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[47]/td[1]/label/textarea"))).getText();
		System.out.println(tr91);
		softly.assertThat(tr91).as("test data").isEqualTo("情况警觉培训");
		String tr92 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[48]/td[1]"))).getText();
		System.out.println(tr92);
		softly.assertThat(tr92).as("test data").isEqualTo("3.5.3: 对人员表现的观察技能不足");
		String tr93 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[49]/td[1]/label"))).getText();
		System.out.println(tr93);
		softly.assertThat(tr93).as("test data").contains("纠正行动:");
		String tr94 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[49]/td[1]/label/small"))).getText();
		System.out.println(tr94);
		softly.assertThat(tr94).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr95 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[49]/td[1]/label/textarea"))).getText();
		System.out.println(tr95);
		softly.assertThat(tr95).as("test data").isEqualTo("开展人员表现观察技能方面的培训");
		String tr96 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[50]/td[1]"))).getText();
		System.out.println(tr96);
		softly.assertThat(tr96).as("test data").isEqualTo("3.5.4: 对设备性能的观察技能不足");
		String tr97 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[51]/td[1]/label"))).getText();
		System.out.println(tr97);
		softly.assertThat(tr97).as("test data").contains("纠正行动:");
		String tr98 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[51]/td[1]/label/small"))).getText();
		System.out.println(tr98);
		softly.assertThat(tr98).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr99 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[51]/td[1]/label/textarea"))).getText();
		System.out.println(tr99);
		softly.assertThat(tr99).as("test data").isEqualTo("开展退化、异常和变化等设备性能观察技能方面的培训");
		String tr100 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[52]/td[1]"))).getText();
		System.out.println(tr100);
		softly.assertThat(tr100).as("test data").isEqualTo("3.6.1: 要求有遗漏");
		String tr101 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[53]/td[1]/label"))).getText();
		System.out.println(tr101);
		softly.assertThat(tr101).as("test data").contains("纠正行动:");
		String tr102 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[53]/td[1]/label/small"))).getText();
		System.out.println(tr102);
		softly.assertThat(tr102).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr103 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[53]/td[1]/label/textarea"))).getText();
		System.out.println(tr103);
		softly.assertThat(tr103).as("test data").isEqualTo("完善规则, 开展程序设计方面的培训");
		String tr104 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[54]/td[1]"))).getText();
		System.out.println(tr104);
		softly.assertThat(tr104).as("test data").isEqualTo("3.6.2: 运行条件有遗漏");
		String tr105 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[55]/td[1]/label"))).getText();
		System.out.println(tr105);
		softly.assertThat(tr105).as("test data").contains("纠正行动:");
		String tr106 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[55]/td[1]/label/small"))).getText();
		System.out.println(tr106);
		softly.assertThat(tr106).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr107 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[55]/td[1]/label/textarea"))).getText();
		System.out.println(tr107);
		softly.assertThat(tr107).as("test data").isEqualTo("完善规则, 开展程序设计方面的培训");
		String tr108 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[56]/td[1]"))).getText();
		System.out.println(tr108);
		softly.assertThat(tr108).as("test data").isEqualTo("3.6.3: 假设有遗漏");
		String tr109 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[57]/td[1]/label"))).getText();
		System.out.println(tr109);
		softly.assertThat(tr109).as("test data").contains("纠正行动:");
		String tr110 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[57]/td[1]/label/small"))).getText();
		System.out.println(tr110);
		softly.assertThat(tr110).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr111 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[57]/td[1]/label/textarea"))).getText();
		System.out.println(tr111);
		softly.assertThat(tr111).as("test data").isEqualTo("完善规则, 开展程序设计方面的培训");
		String tr112 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[58]/td[1]"))).getText();
		System.out.println(tr112);
		softly.assertThat(tr112).as("test data").isEqualTo("3.6.4: 范围有遗漏");
		String tr113 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[59]/td[1]/label"))).getText();
		System.out.println(tr113);
		softly.assertThat(tr113).as("test data").contains("纠正行动:");
		String tr114 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[59]/td[1]/label/small"))).getText();
		System.out.println(tr114);
		softly.assertThat(tr114).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr115 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[59]/td[1]/label/textarea"))).getText();
		System.out.println(tr115);
		softly.assertThat(tr115).as("test data").isEqualTo("完善规则, 开展程序设计方面的培训");
		String tr116 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[60]/td[1]"))).getText();
		System.out.println(tr116);
		softly.assertThat(tr116).as("test data").isEqualTo("3.6.5: 试验或测量有遗漏");
		String tr117 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[61]/td[1]/label"))).getText();
		System.out.println(tr117);
		softly.assertThat(tr117).as("test data").contains("纠正行动:");
		String tr118 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[61]/td[1]/label/small"))).getText();
		System.out.println(tr118);
		softly.assertThat(tr118).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr119 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[61]/td[1]/label/textarea"))).getText();
		System.out.println(tr119);
		softly.assertThat(tr119).as("test data").isEqualTo("完善规则, 开展程序设计方面的培训");
		String tr120 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[62]/td[1]"))).getText();
		System.out.println(tr120);
		softly.assertThat(tr120).as("test data").contains("3.6.6: 遗漏以下信息: (1) 目的; (2) 先决条件; (3) 定义; (4) 经验反馈用");
		softly.assertThat(tr120).as("test data").contains("不准做清单");
		softly.assertThat(tr120).as("test data").contains("体现; (5) 参考资料; (6) 要求使用者反馈");
		String tr121 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[63]/td[1]/label"))).getText();
		System.out.println(tr121);
		softly.assertThat(tr121).as("test data").contains("纠正行动:");
		String tr122 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[63]/td[1]/label/small"))).getText();
		System.out.println(tr122);
		softly.assertThat(tr122).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr123 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[63]/td[1]/label/textarea"))).getText();
		System.out.println(tr123);
		softly.assertThat(tr123).as("test data").isEqualTo("开展程序设计编写培训, 改善程序编写导则");
		String tr124 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[64]/td[1]"))).getText();
		System.out.println(tr124);
		softly.assertThat(tr124).as("test data").isEqualTo("3.6.7: 审查不到位导致制度有遗漏项");
		String tr125 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[65]/td[1]/label"))).getText();
		System.out.println(tr125);
		softly.assertThat(tr125).as("test data").contains("纠正行动:");
		String tr126 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[65]/td[1]/label/small"))).getText();
		System.out.println(tr126);
		softly.assertThat(tr126).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr127 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[65]/td[1]/label/textarea"))).getText();
		System.out.println(tr127);
		softly.assertThat(tr127).as("test data").isEqualTo("开展程序审查培训");
		String tr128 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[66]/td[1]"))).getText();
		System.out.println(tr128);
		softly.assertThat(tr128).as("test data").isEqualTo("3.6.8: 根本原因分析不到位导致制度有遗漏项");
		String tr129 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[67]/td[1]/label"))).getText();
		System.out.println(tr129);
		softly.assertThat(tr129).as("test data").contains("纠正行动:");
		String tr130 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[67]/td[1]/label/small"))).getText();
		System.out.println(tr130);
		softly.assertThat(tr130).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr131 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[67]/td[1]/label/textarea"))).getText();
		System.out.println(tr131);
		softly.assertThat(tr131).as("test data").isEqualTo("开展根本原因培训");
		String tr132 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[68]/td[1]"))).getText();
		System.out.println(tr132);
		softly.assertThat(tr132).as("test data").isEqualTo("3.6.9: 纠正措施执行不到位导致制度有遗漏项");
		String tr133 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[69]/td[1]/label"))).getText();
		System.out.println(tr133);
		softly.assertThat(tr133).as("test data").contains("纠正行动:");
		String tr134 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[69]/td[1]/label/small"))).getText();
		System.out.println(tr134);
		softly.assertThat(tr134).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr135 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[69]/td[1]/label/textarea"))).getText();
		System.out.println(tr135);
		softly.assertThat(tr135).as("test data").contains("改善纠正措施制度的监督与执行");
		String tr136 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[70]/td[1]"))).getText();
		System.out.println(tr136);
		softly.assertThat(tr136).as("test data").isEqualTo("3.9.1: 培训材料在适用性、及时性或实用性方面有所欠缺");
		String tr137 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[71]/td[1]/label"))).getText();
		System.out.println(tr137);
		softly.assertThat(tr137).as("test data").contains("纠正行动:");
		String tr138 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[71]/td[1]/label/small"))).getText();
		System.out.println(tr138);
		softly.assertThat(tr138).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr139 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[71]/td[1]/label/textarea"))).getText();
		System.out.println(tr139);
		softly.assertThat(tr139).as("test data").contains("加强培训资源, 开展作业任务分析，从而使培训材料、课程及时间与员工执行的任务相匹配");
		String tr140 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[72]/td[1]"))).getText();
		System.out.println(tr140);
		softly.assertThat(tr140).as("test data").isEqualTo("3.9.2: 复训频率不高(>> 一年)");
		String tr141 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[73]/td[1]/label"))).getText();
		System.out.println(tr141);
		softly.assertThat(tr141).as("test data").contains("纠正行动:");
		String tr142 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[73]/td[1]/label/small"))).getText();
		System.out.println(tr142);
		softly.assertThat(tr142).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr143 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[73]/td[1]/label/textarea"))).getText();
		System.out.println(tr143);
		softly.assertThat(tr143).as("test data").contains("增加复训频率，改善复训形式");
		String tr144 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[74]/td[1]"))).getText();
		System.out.println(tr144);
		softly.assertThat(tr144).as("test data").isEqualTo("3.9.3: 部门管理层未充分参与培训材料的编写和培训的实施");
		String tr145 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[75]/td[1]/label"))).getText();
		System.out.println(tr145);
		softly.assertThat(tr145).as("test data").contains("纠正行动:");
		String tr146 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[75]/td[1]/label/small"))).getText();
		System.out.println(tr146);
		softly.assertThat(tr146).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr147 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[75]/td[1]/label/textarea"))).getText();
		System.out.println(tr147);
		softly.assertThat(tr147).as("test data").contains("完善关于管理层参与培训材料编写或培训实施的相关要求");
		String tr148 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[76]/td[1]"))).getText();
		System.out.println(tr148);
		softly.assertThat(tr148).as("test data").isEqualTo("3.9.4: 未将经验教训充分包含到培训中");
		String tr149 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[77]/td[1]/label"))).getText();
		System.out.println(tr149);
		softly.assertThat(tr149).as("test data").contains("纠正行动:");
		String tr150 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[77]/td[1]/label/small"))).getText();
		System.out.println(tr150);
		softly.assertThat(tr150).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr151 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[77]/td[1]/label/textarea"))).getText();
		System.out.println(tr151);
		softly.assertThat(tr151).as("test data").contains("提高对培训效果的审查");
		String tr152 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[78]/td[1]"))).getText();
		System.out.println(tr152);
		softly.assertThat(tr152).as("test data").isEqualTo("3.9.5: 所需培训开展不充分（脱岗）");
		String tr153 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[79]/td[1]/label"))).getText();
		System.out.println(tr153);
		softly.assertThat(tr153).as("test data").contains("纠正行动:");
		String tr154 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[79]/td[1]/label/small"))).getText();
		System.out.println(tr154);
		softly.assertThat(tr154).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr155 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[79]/td[1]/label/textarea"))).getText();
		System.out.println(tr155);
		softly.assertThat(tr155).as("test data").contains("完善承包商控制方针, 完善培训资源");
		String tr156 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[80]/td[1]"))).getText();
		System.out.println(tr156);
		softly.assertThat(tr156).as("test data").isEqualTo("3.9.6: 所需培训开展不充分（在岗）");
		String tr157 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[81]/td[1]/label"))).getText();
		System.out.println(tr157);
		softly.assertThat(tr157).as("test data").contains("纠正行动:");
		String tr158 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[81]/td[1]/label/small"))).getText();
		System.out.println(tr158);
		softly.assertThat(tr158).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr159 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[81]/td[1]/label/textarea"))).getText();
		System.out.println(tr159);
		softly.assertThat(tr159).as("test data").contains("完善在岗培训方针, 完善培训资源");
		String tr160 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[82]/td[1]"))).getText();
		System.out.println(tr160);
		softly.assertThat(tr160).as("test data").isEqualTo("3.10.1: 关键岗位员工的作业授权不充分");
		String tr161 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[83]/td[1]/label"))).getText();
		System.out.println(tr161);
		softly.assertThat(tr161).as("test data").contains("纠正行动:");
		String tr162 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[83]/td[1]/label/small"))).getText();
		System.out.println(tr162);
		softly.assertThat(tr162).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr163 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[83]/td[1]/label/textarea"))).getText();
		System.out.println(tr163);
		softly.assertThat(tr163).as("test data").contains("完善作业授权");
		String tr164 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[84]/td[1]"))).getText();
		System.out.println(tr164);
		softly.assertThat(tr164).as("test data").isEqualTo("3.10.2: 关键岗位主管和（或）经理授权不充分");
		String tr165 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[85]/td[1]/label"))).getText();
		System.out.println(tr165);
		softly.assertThat(tr165).as("test data").contains("纠正行动:");
		String tr166 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[85]/td[1]/label/small"))).getText();
		System.out.println(tr166);
		softly.assertThat(tr166).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr167 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[85]/td[1]/label/textarea"))).getText();
		System.out.println(tr167);
		softly.assertThat(tr167).as("test data").contains("完善主管和经理的岗位授权");
		String tr168 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[86]/td[1]"))).getText();
		System.out.println(tr168);
		softly.assertThat(tr168).as("test data").isEqualTo("3.10.3: 供应商服务（QA/RC、来源检查）授权不充分");
		String tr169 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[87]/td[1]/label"))).getText();
		System.out.println(tr169);
		softly.assertThat(tr169).as("test data").contains("纠正行动:");
		String tr170 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[87]/td[1]/label/small"))).getText();
		System.out.println(tr170);
		softly.assertThat(tr170).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr171 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[87]/td[1]/label/textarea"))).getText();
		System.out.println(tr171);
		softly.assertThat(tr171).as("test data").contains("完善供应商控制制度");
		String tr172 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[88]/td[1]"))).getText();
		System.out.println(tr172);
		softly.assertThat(tr172).as("test data").isEqualTo("3.10.4: 现场供应商人员授权不充分");
		String tr173 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[89]/td[1]/label"))).getText();
		System.out.println(tr173);
		softly.assertThat(tr173).as("test data").contains("纠正行动:");
		String tr174 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[89]/td[1]/label/small"))).getText();
		System.out.println(tr174);
		softly.assertThat(tr174).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr175 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[89]/td[1]/label/textarea"))).getText();
		System.out.println(tr175);
		softly.assertThat(tr175).as("test data").contains("完善供应商控制制度");
		String tr176 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[90]/td[1]"))).getText();
		System.out.println(tr176);
		softly.assertThat(tr176).as("test data").isEqualTo("3.10.5: 培训教员授权不充分");
		String tr177 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[91]/td[1]/label"))).getText();
		System.out.println(tr177);
		softly.assertThat(tr177).as("test data").contains("纠正行动:");
		String tr178 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[91]/td[1]/label/small"))).getText();
		System.out.println(tr178);
		softly.assertThat(tr178).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr179 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[91]/td[1]/label/textarea"))).getText();
		System.out.println(tr179);
		softly.assertThat(tr179).as("test data").contains("完善有关培训教员资格授权的管理标准与方针");
		String tr180 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[92]/td[1]"))).getText();
		System.out.println(tr180);
		softly.assertThat(tr180).as("test data").isEqualTo("3.11.1: 绩效跟踪与趋势分析(PM&T)以及给员工的反馈不到位");
		String tr181 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[93]/td[1]/label"))).getText();
		System.out.println(tr181);
		softly.assertThat(tr181).as("test data").contains("纠正行动:");
		String tr182 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[93]/td[1]/label/small"))).getText();
		System.out.println(tr182);
		softly.assertThat(tr182).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr183 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[93]/td[1]/label/textarea"))).getText();
		System.out.println(tr183);
		softly.assertThat(tr183).as("test data").contains("完善趋势分析体系, 完善趋势反馈");
		String tr184 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[94]/td[1]"))).getText();
		System.out.println(tr184);
		softly.assertThat(tr184).as("test data").isEqualTo("3.11.2: 即时反馈和持续强化(IF&CR)的管理技能不到位");
		String tr185 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[95]/td[1]/label"))).getText();
		System.out.println(tr185);
		softly.assertThat(tr185).as("test data").contains("纠正行动:");
		String tr186 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[95]/td[1]/label/small"))).getText();
		System.out.println(tr186);
		softly.assertThat(tr186).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr187 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[95]/td[1]/label/textarea"))).getText();
		System.out.println(tr187);
		softly.assertThat(tr187).as("test data").contains("提高主管人员的问责意识, 改善关于管理技能的培训");
		String tr188 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[96]/td[1]"))).getText();
		System.out.println(tr188);
		softly.assertThat(tr188).as("test data").isEqualTo("3.11.3: 用于绩效控制的奖惩制度不到位");
		String tr189 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[97]/td[1]/label"))).getText();
		System.out.println(tr189);
		softly.assertThat(tr189).as("test data").contains("纠正行动:");
		String tr190 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[97]/td[1]/label/small"))).getText();
		System.out.println(tr190);
		softly.assertThat(tr190).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr191 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[97]/td[1]/label/textarea"))).getText();
		System.out.println(tr191);
		softly.assertThat(tr191).as("test data").contains("完善奖惩制度");
		String tr192 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[98]/td[1]"))).getText();
		System.out.println(tr192);
		softly.assertThat(tr192).as("test data").isEqualTo("3.11.4: 问题报告、RCA和纠正行动不到位，给员工的反馈不到位");
		String tr193 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[99]/td[1]/label"))).getText();
		System.out.println(tr193);
		softly.assertThat(tr193).as("test data").contains("纠正行动:");
		String tr194 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[99]/td[1]/label/small"))).getText();
		System.out.println(tr194);
		softly.assertThat(tr194).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr195 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[99]/td[1]/label/textarea"))).getText();
		System.out.println(tr195);
		softly.assertThat(tr195).as("test data").contains("在问题报告政策中要求包含一切问题和及时性, RCA培训和授权, 改善对RCA结果的反馈");
		String tr196 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[100]/td[1]"))).getText();
		System.out.println(tr196);
		softly.assertThat(tr196).as("test data").isEqualTo("3.11.5: 现场观察不充分，给员工的反馈不到位");
		String tr197 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[101]/td[1]/label"))).getText();
		System.out.println(tr197);
		softly.assertThat(tr197).as("test data").contains("纠正行动:");
		String tr198 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[101]/td[1]/label/small"))).getText();
		System.out.println(tr198);
		softly.assertThat(tr198).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr199 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[101]/td[1]/label/textarea"))).getText();
		System.out.println(tr199);
		softly.assertThat(tr199).as("test data").contains("针对现场观察结果，改善给员工的反馈, 改进现场观察员的制度和TQA");
		String tr200 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[102]/td[1]"))).getText();
		System.out.println(tr200);
		softly.assertThat(tr200).as("test data").isEqualTo("3.15.1: 员工未经过相互指导的培训，或纠正他人违规情况的培训");
		String tr201 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[103]/td[1]/label"))).getText();
		System.out.println(tr201);
		softly.assertThat(tr201).as("test data").contains("纠正行动:");
		String tr202 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[103]/td[1]/label/small"))).getText();
		System.out.println(tr202);
		softly.assertThat(tr202).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr203 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[103]/td[1]/label/textarea"))).getText();
		System.out.println(tr203);
		softly.assertThat(tr203).as("test data").contains("同事互助提醒（好文化）培训");
		String tr204 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[104]/td[1]"))).getText();
		System.out.println(tr204);
		softly.assertThat(tr204).as("test data").isEqualTo("3.15.2: 未要求员工对纠正他人违规的情况承担责任");
		String tr205 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[105]/td[1]/label"))).getText();
		System.out.println(tr205);
		softly.assertThat(tr205).as("test data").contains("纠正行动:");
		String tr206 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[105]/td[1]/label/small"))).getText();
		System.out.println(tr206);
		softly.assertThat(tr206).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr207 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[105]/td[1]/label/textarea"))).getText();
		System.out.println(tr207);
		softly.assertThat(tr207).as("test data").contains("建立关于同事互助提醒（好文化）的管理期望");
		String tr208 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[106]/td[1]"))).getText();
		System.out.println(tr208);
		softly.assertThat(tr208).as("test data").isEqualTo("3.15.3: 员工未充分理解相关行为规范");
		String tr209 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[107]/td[1]/label"))).getText();
		System.out.println(tr209);
		softly.assertThat(tr209).as("test data").contains("纠正行动:");
		String tr210 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[107]/td[1]/label/small"))).getText();
		System.out.println(tr210);
		softly.assertThat(tr210).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr211 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[107]/td[1]/label/textarea"))).getText();
		System.out.println(tr211);
		softly.assertThat(tr211).as("test data").contains("行为规范培训, 采用行为规范提醒物, 采用禁止事项警告清单");
		String tr212 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[108]/td[1]"))).getText();
		System.out.println(tr212);
		softly.assertThat(tr212).as("test data").contains("3.15.4: 主管未到现场强化");
		softly.assertThat(tr212).as("test data").contains("同事指导");
		String tr213 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[109]/td[1]/label"))).getText();
		System.out.println(tr213);
		softly.assertThat(tr213).as("test data").contains("纠正行动:");
		String tr214 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[109]/td[1]/label/small"))).getText();
		System.out.println(tr214);
		softly.assertThat(tr214).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr215 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[109]/td[1]/label/textarea"))).getText();
		System.out.println(tr215);
		softly.assertThat(tr215).as("test data").contains("监督管理能力培训, 就监督管理强化，对管理者实施问责");
		String tr216 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[110]/td[1]"))).getText();
		System.out.println(tr216);
		softly.assertThat(tr216).as("test data").contains("3.18.1: 盲目信任: 关键信息使用质疑的态度QV&V");
		softly.assertThat(tr216).as("test data").contains("不到位");
		String tr217 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[111]/td[1]/label"))).getText();
		System.out.println(tr217);
		softly.assertThat(tr217).as("test data").contains("纠正行动:");
		String tr218 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[111]/td[1]/label/small"))).getText();
		System.out.println(tr218);
		softly.assertThat(tr218).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr219 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[111]/td[1]/label/textarea"))).getText();
		System.out.println(tr219);
		softly.assertThat(tr219).as("test data").contains("提高质疑的态度QV&V");
		softly.assertThat(tr219).as("test data").contains("培训");
		String tr220 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[112]/td[1]"))).getText();
		System.out.println(tr220);
		softly.assertThat(tr220).as("test data").isEqualTo("3.18.2: 过度自信: (1) 高估自我效能; (2) 未意识到影响变化; (3) 未寻求他人智慧; (4) 没有从过去中学习; (5) 缺少屏障预防错误发生");
		String tr221 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[113]/td[1]/label"))).getText();
		System.out.println(tr221);
		softly.assertThat(tr221).as("test data").contains("纠正行动:");
		String tr222 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[113]/td[1]/label/small"))).getText();
		System.out.println(tr222);
		softly.assertThat(tr222).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr223 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[113]/td[1]/label/textarea"))).getText();
		System.out.println(tr223);
		softly.assertThat(tr223).as("test data").contains("Error-Free");
		softly.assertThat(tr223).as("test data").contains("行为培训，避免过度自信");
		String tr224 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[114]/td[1]"))).getText();
		System.out.println(tr224);
		softly.assertThat(tr224).as("test data").isEqualTo("3.18.3: 眼不见心不想: (1) 对低概率/高风险事件的风险控制不到位; (2) 忽略与绩效指标或激励无关的问题; (3) 因忽略相关风险而未设置屏障");
		String tr225 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[115]/td[1]/label"))).getText();
		System.out.println(tr225);
		softly.assertThat(tr225).as("test data").contains("纠正行动:");
		String tr226 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[115]/td[1]/label/small"))).getText();
		System.out.println(tr226);
		softly.assertThat(tr226).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr227 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[115]/td[1]/label/textarea"))).getText();
		System.out.println(tr227);
		softly.assertThat(tr227).as("test data").contains("改善风险控制项目(FUSE");
		softly.assertThat(tr227).as("test data").contains("), 完善PM&T体系");
		String tr228 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[116]/td[1]"))).getText();
		System.out.println(tr228);
		softly.assertThat(tr228).as("test data").isEqualTo("3.18.4: 未能及时止损: (1) 因自满和（或）无知，捍卫过去错误的决定或犹豫不决; (2) 期望通过重复同样的问题处理方法、标准或策略来实现不同的结果");
		String tr229 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[117]/td[1]/label"))).getText();
		System.out.println(tr229);
		softly.assertThat(tr229).as("test data").contains("纠正行动:");
		String tr230 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[117]/td[1]/label/small"))).getText();
		System.out.println(tr230);
		softly.assertThat(tr230).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr231 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[117]/td[1]/label/textarea"))).getText();
		System.out.println(tr231);
		softly.assertThat(tr231).as("test data").contains("审查以往决策的有效性，提高管理监督");
		String tr232 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[118]/td[1]"))).getText();
		System.out.println(tr232);
		softly.assertThat(tr232).as("test data").isEqualTo("3.18.5: 陷入两选一的陷阱: 决策、问题解决或计划不充分，未能确保全面考虑多个选择方案进行分析");
		String tr233 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[119]/td[1]/label"))).getText();
		System.out.println(tr233);
		softly.assertThat(tr233).as("test data").contains("纠正行动:");
		String tr234 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[119]/td[1]/label/small"))).getText();
		System.out.println(tr234);
		softly.assertThat(tr234).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr235 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[119]/td[1]/label/textarea"))).getText();
		System.out.println(tr235);
		softly.assertThat(tr235).as("test data").contains("提高决策、问题解决和计划的结构（委员会）和流程");
		String tr236 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[120]/td[1]"))).getText();
		System.out.println(tr236);
		softly.assertThat(tr236).as("test data").isEqualTo("3.22.1: 对规则的现场试验不充分");
		String tr237 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[121]/td[1]/label"))).getText();
		System.out.println(tr237);
		softly.assertThat(tr237).as("test data").contains("纠正行动:");
		String tr238 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[121]/td[1]/label/small"))).getText();
		System.out.println(tr238);
		softly.assertThat(tr238).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr239 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[121]/td[1]/label/textarea"))).getText();
		System.out.println(tr239);
		softly.assertThat(tr239).as("test data").contains("发布规则/程序前，执行现场试验");
		String tr240 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[122]/td[1]"))).getText();
		System.out.println(tr240);
		softly.assertThat(tr240).as("test data").isEqualTo("3.22.2: 给规则编写人的反馈不充分，从而使其纠正错误规则");
		String tr241 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[123]/td[1]/label"))).getText();
		System.out.println(tr241);
		softly.assertThat(tr241).as("test data").contains("纠正行动:");
		String tr242 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[123]/td[1]/label/small"))).getText();
		System.out.println(tr242);
		softly.assertThat(tr242).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr243 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[123]/td[1]/label/textarea"))).getText();
		System.out.println(tr243);
		softly.assertThat(tr243).as("test data").contains("设计出允许执行人员记录失误方便编写人改正的程序, 制定遇到程序关键错误后要求停止操作的政策");
		String tr244 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[124]/td[1]"))).getText();
		System.out.println(tr244);
		softly.assertThat(tr244).as("test data").isEqualTo("3.22.3: 盲目信任错误规则");
		String tr245 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[125]/td[1]/label"))).getText();
		System.out.println(tr245);
		softly.assertThat(tr245).as("test data").contains("纠正行动:");
		String tr246 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[125]/td[1]/label/small"))).getText();
		System.out.println(tr246);
		softly.assertThat(tr246).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr247 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[125]/td[1]/label/textarea"))).getText();
		System.out.println(tr247);
		softly.assertThat(tr247).as("test data").contains("QV&V");
		softly.assertThat(tr247).as("test data").contains("培训");
		String tr248 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[126]/td[1]"))).getText();
		System.out.println(tr248);
		softly.assertThat(tr248).as("test data").isEqualTo("3.22.4: 规则审核不到位");
		String tr249 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[127]/td[1]/label"))).getText();
		System.out.println(tr249);
		softly.assertThat(tr249).as("test data").contains("纠正行动:");
		String tr250 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[127]/td[1]/label/small"))).getText();
		System.out.println(tr250);
		softly.assertThat(tr250).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr251 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[127]/td[1]/label/textarea"))).getText();
		System.out.println(tr251);
		softly.assertThat(tr251).as("test data").contains("提供有效审核的相关培训");
		String tr252 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[128]/td[1]"))).getText();
		System.out.println(tr252);
		softly.assertThat(tr252).as("test data").isEqualTo("3.22.5: 工前会、班前会、交底会的规则不充分");
		String tr253 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[129]/td[1]/label"))).getText();
		System.out.println(tr253);
		softly.assertThat(tr253).as("test data").contains("纠正行动:");
		String tr254 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[129]/td[1]/label/small"))).getText();
		System.out.println(tr254);
		softly.assertThat(tr254).as("test data").contains("通用纠正行动已预填。可直接修改为具体纠正行动。");
		String tr255 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[129]/td[1]/label/textarea"))).getText();
		System.out.println(tr255);
		softly.assertThat(tr255).as("test data").contains("完善关于工前会、班前会、交底会的规则");
	}
	
	public void chineseLevel3SelectionsSUEP1st(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Verify all selections here
		String tr = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[1]"))).getText();
		System.out.println(tr);
		softly.assertThat(tr).as("test data").isEqualTo("3.2.1 组长强化标准方面的管理能力不足");
		String tr1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[3]/td[1]"))).getText();
		System.out.println(tr1);
		softly.assertThat(tr1).as("test data").isEqualTo("3.2.2 组长绩效反馈方面的管理能力不足");
		String tr2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[4]/td[1]"))).getText();
		System.out.println(tr2);
		softly.assertThat(tr2).as("test data").isEqualTo("3.2.3 组长召开经验反馈的管理技能不足");
		String tr3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[5]/td[1]"))).getText();
		System.out.println(tr3);
		softly.assertThat(tr3).as("test data").isEqualTo("3.2.4 组长在岗培训方面管理能力不足");
		String tr4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[6]/td[1]"))).getText();
		System.out.println(tr4);
		softly.assertThat(tr4).as("test data").isEqualTo("3.2.5 组长对团队缺点认识不足，缺乏相应弥补措施");
		String tr5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[7]/td[1]"))).getText();
		System.out.println(tr5);
		softly.assertThat(tr5).as("test data").isEqualTo("3.2.6 组长发出指令和后续贯彻的沟通及协调能力不足");
		String tr6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[8]/td[1]"))).getText();
		System.out.println(tr6);
		softly.assertThat(tr6).as("test data").isEqualTo("3.3.1 经理团队资源分配不到位");
		String tr7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[9]/td[1]"))).getText();
		System.out.println(tr7);
		softly.assertThat(tr7).as("test data").isEqualTo("3.3.2 经理团队所需培训开展不充分");
		String tr8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[10]/td[1]"))).getText();
		System.out.println(tr8);
		softly.assertThat(tr8).as("test data").isEqualTo("3.3.3 经理团队问责制不到位");
		String tr9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[11]/td[1]"))).getText();
		System.out.println(tr9);
		softly.assertThat(tr9).as("test data").isEqualTo("3.3.4 经理团队对确定工作优先级和计划方面不到位");
		String tr10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[12]/td[1]"))).getText();
		System.out.println(tr10);
		softly.assertThat(tr10).as("test data").isEqualTo("3.3.5 经理管理人员对以下标准制定不充分：(1) 行为规范 (2) 程序和屏障");
		String tr11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[13]/td[1]"))).getText();
		System.out.println(tr11);
		softly.assertThat(tr11).as("test data").isEqualTo("3.3.6 经理团队绩效跟踪与趋势分析不到位");
		String tr12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[14]/td[1]"))).getText();
		System.out.println(tr12);
		softly.assertThat(tr12).as("test data").isEqualTo("3.3.7 经理团队内未充分建立关于团队合作的共同目标、共同利益和共同责任");
		String tr13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[15]/td[1]"))).getText();
		System.out.println(tr13);
		softly.assertThat(tr13).as("test data").isEqualTo("3.3.8 经理团队纠正行动不足");
		String tr14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[16]/td[1]"))).getText();
		System.out.println(tr14);
		softly.assertThat(tr14).as("test data").isEqualTo("3.3.9 经理团队垂直沟通体系不完善");
		String tr15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[17]/td[1]"))).getText();
		System.out.println(tr15);
		softly.assertThat(tr15).as("test data").isEqualTo("3.3.10 经理团队横向沟通体系不完善");
		String tr16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[18]/td[1]"))).getText();
		System.out.println(tr16);
		softly.assertThat(tr16).as("test data").isEqualTo("3.4.1 采取行动前没有思考如何规划（如优先顺序、机会、沟通、时间管理等）");
		String tr17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[19]/td[1]"))).getText();
		System.out.println(tr17);
		softly.assertThat(tr17).as("test data").isEqualTo("3.4.2 采取行动前没有考虑易出错的心理状况");
		String tr18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[20]/td[1]"))).getText();
		System.out.println(tr18);
		softly.assertThat(tr18).as("test data").isEqualTo("3.4.3 采取行动前没有考虑高风险情境（如单项弱点）");
		String tr19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[21]/td[1]"))).getText();
		System.out.println(tr19);
		softly.assertThat(tr19).as("test data").isEqualTo("3.4.4 感到疑惑时质疑不充分");
		String tr20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[22]/td[1]"))).getText();
		System.out.println(tr20);
		softly.assertThat(tr20).as("test data").isEqualTo("3.4.5 任务准备过程中质疑不充分");
		String tr21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[23]/td[1]"))).getText();
		System.out.println(tr21);
		softly.assertThat(tr21).as("test data").isEqualTo("3.5.1 作业前情况警觉（如易出错的精神状态和高风险情况）不充分");
		String tr22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[24]/td[1]"))).getText();
		System.out.println(tr22);
		softly.assertThat(tr22).as("test data").isEqualTo("3.5.2 作业过程中情况警觉（如易出错的精神状态和高风险情况）不充分");
		String tr23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[25]/td[1]"))).getText();
		System.out.println(tr23);
		softly.assertThat(tr23).as("test data").isEqualTo("3.5.3 对人员表现的观察技能不足");
		String tr24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[26]/td[1]"))).getText();
		System.out.println(tr24);
		softly.assertThat(tr24).as("test data").isEqualTo("3.5.4 对设备性能的观察技能不足");
		String tr25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[27]/td[1]"))).getText();
		System.out.println(tr25);
		softly.assertThat(tr25).as("test data").isEqualTo("3.6.1 要求有遗漏");
		String tr26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[28]/td[1]"))).getText();
		System.out.println(tr26);
		softly.assertThat(tr26).as("test data").isEqualTo("3.6.2 运行条件有遗漏");
		String tr27 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[29]/td[1]"))).getText();
		System.out.println(tr27);
		softly.assertThat(tr27).as("test data").isEqualTo("3.6.3 假设有遗漏");
		String tr28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[30]/td[1]"))).getText();
		System.out.println(tr28);
		softly.assertThat(tr28).as("test data").isEqualTo("3.6.4 范围有遗漏");
		String tr29 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[31]/td[1]"))).getText();
		System.out.println(tr29);
		softly.assertThat(tr29).as("test data").isEqualTo("3.6.5 试验或测量有遗漏");
		String tr30 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[32]/td[1]"))).getText();
		System.out.println(tr30);
		softly.assertThat(tr30).as("test data").contains("3.6.6 遗漏以下信息: (1) 目的; (2) 先决条件; (3) 定义; (4) 经验反馈用");
		softly.assertThat(tr30).as("test data").contains("不准做清单");
		softly.assertThat(tr30).as("test data").contains("体现; (5) 参考资料; (6) 要求使用者反馈");
		String tr31 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[33]/td[1]"))).getText();
		System.out.println(tr31);
		softly.assertThat(tr31).as("test data").isEqualTo("3.6.7 审查不到位导致制度有遗漏项");
		String tr32 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[34]/td[1]"))).getText();
		System.out.println(tr32);
		softly.assertThat(tr32).as("test data").isEqualTo("3.6.8 根本原因分析不到位导致制度有遗漏项");
		String tr33 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[35]/td[1]"))).getText();
		System.out.println(tr33);
		softly.assertThat(tr33).as("test data").isEqualTo("3.6.9 纠正措施执行不到位导致制度有遗漏项");
		String tr34 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[36]/td[1]"))).getText();
		System.out.println(tr34);
		softly.assertThat(tr34).as("test data").isEqualTo("3.9.1 培训材料在适用性、及时性或实用性方面有所欠缺");
		String tr35 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[37]/td[1]"))).getText();
		System.out.println(tr35);
		softly.assertThat(tr35).as("test data").isEqualTo("3.9.2 复训频率不高(>> 一年)");
		String tr36 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[38]/td[1]"))).getText();
		System.out.println(tr36);
		softly.assertThat(tr36).as("test data").isEqualTo("3.9.3 部门管理层未充分参与培训材料的编写和培训的实施");
		String tr37 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[39]/td[1]"))).getText();
		System.out.println(tr37);
		softly.assertThat(tr37).as("test data").isEqualTo("3.9.4 未将经验教训充分包含到培训中");
		String tr38 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[40]/td[1]"))).getText();
		System.out.println(tr38);
		softly.assertThat(tr38).as("test data").isEqualTo("3.9.5 所需培训开展不充分（脱岗）");
		String tr39 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[41]/td[1]"))).getText();
		System.out.println(tr39);
		softly.assertThat(tr39).as("test data").isEqualTo("3.9.6 所需培训开展不充分（在岗）");
		String tr40 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[42]/td[1]"))).getText();
		System.out.println(tr40);
		softly.assertThat(tr40).as("test data").isEqualTo("3.10.1 关键岗位员工的作业授权不充分");
		String tr41 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[43]/td[1]"))).getText();
		System.out.println(tr41);
		softly.assertThat(tr41).as("test data").isEqualTo("3.10.2 关键岗位主管和（或）经理授权不充分");
		String tr42 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[44]/td[1]"))).getText();
		System.out.println(tr42);
		softly.assertThat(tr42).as("test data").isEqualTo("3.10.3 供应商服务（QA/RC、来源检查）授权不充分");
		String tr43 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[45]/td[1]"))).getText();
		System.out.println(tr43);
		softly.assertThat(tr43).as("test data").isEqualTo("3.10.4 现场供应商人员授权不充分");
		String tr44 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[46]/td[1]"))).getText();
		System.out.println(tr44);
		softly.assertThat(tr44).as("test data").isEqualTo("3.10.5 培训教员授权不充分");
		String tr45 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[47]/td[1]"))).getText();
		System.out.println(tr45);
		softly.assertThat(tr45).as("test data").isEqualTo("3.11.1 绩效跟踪与趋势分析(PM&T)以及给员工的反馈不到位");
		String tr46 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[48]/td[1]"))).getText();
		System.out.println(tr46);
		softly.assertThat(tr46).as("test data").isEqualTo("3.11.2 即时反馈和持续强化(IF&CR)的管理技能不到位");
		String tr47 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[49]/td[1]"))).getText();
		System.out.println(tr47);
		softly.assertThat(tr47).as("test data").isEqualTo("3.11.3 用于绩效控制的奖惩制度不到位");
		String tr48 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[50]/td[1]"))).getText();
		System.out.println(tr48);
		softly.assertThat(tr48).as("test data").isEqualTo("3.11.4 问题报告、RCA和纠正行动不到位，给员工的反馈不到位");
		String tr49 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[51]/td[1]"))).getText();
		System.out.println(tr49);
		softly.assertThat(tr49).as("test data").isEqualTo("3.11.5 现场观察不充分，给员工的反馈不到位");
		String tr50 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[52]/td[1]"))).getText();
		System.out.println(tr50);
		softly.assertThat(tr50).as("test data").isEqualTo("3.15.1 员工未经过相互指导的培训，或纠正他人违规情况的培训");
		String tr51 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[53]/td[1]"))).getText();
		System.out.println(tr51);
		softly.assertThat(tr51).as("test data").isEqualTo("3.15.2 未要求员工对纠正他人违规的情况承担责任");
		String tr52 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[54]/td[1]"))).getText();
		System.out.println(tr52);
		softly.assertThat(tr52).as("test data").isEqualTo("3.15.3 员工未充分理解相关行为规范");
		String tr53 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[55]/td[1]"))).getText();
		System.out.println(tr53);
		softly.assertThat(tr53).as("test data").contains("3.15.4 主管未到现场强化");
		softly.assertThat(tr53).as("test data").contains("同事指导");
		String tr54 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[56]/td[1]"))).getText();
		System.out.println(tr54);
		softly.assertThat(tr54).as("test data").contains("3.18.1 盲目信任: 关键信息使用质疑的态度");
		softly.assertThat(tr54).as("test data").contains("不到位");
		String tr55 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[57]/td[1]"))).getText();
		System.out.println(tr55);
		softly.assertThat(tr55).as("test data").isEqualTo("3.18.2 过度自信: (1) 高估自我效能; (2) 未意识到影响变化; (3) 未寻求他人智慧; (4) 没有从过去中学习; (5) 缺少屏障预防错误发生");
		String tr56 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[58]/td[1]"))).getText();
		System.out.println(tr56);
		softly.assertThat(tr56).as("test data").isEqualTo("3.18.3 眼不见心不想: (1) 对低概率/高风险事件的风险控制不到位; (2) 忽略与绩效指标或激励无关的问题; (3) 因忽略相关风险而未设置屏障");
		String tr57 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[59]/td[1]"))).getText();
		System.out.println(tr57);
		softly.assertThat(tr57).as("test data").isEqualTo("3.18.4 未能及时止损: (1) 因自满和（或）无知，捍卫过去错误的决定或犹豫不决; (2) 期望通过重复同样的问题处理方法、标准或策略来实现不同的结果");
		String tr58 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[60]/td[1]"))).getText();
		System.out.println(tr58);
		softly.assertThat(tr58).as("test data").isEqualTo("3.18.5 陷入两选一的陷阱: 决策、问题解决或计划不充分，未能确保全面考虑多个选择方案进行分析");
		String tr59 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[61]/td[1]"))).getText();
		System.out.println(tr59);
		softly.assertThat(tr59).as("test data").isEqualTo("3.22.1 对规则的现场试验不充分");
		String tr60 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[62]/td[1]"))).getText();
		System.out.println(tr60);
		softly.assertThat(tr60).as("test data").isEqualTo("3.22.2 给规则编写人的反馈不充分，从而使其纠正错误规则");
		String tr61 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[63]/td[1]"))).getText();
		System.out.println(tr61);
		softly.assertThat(tr61).as("test data").isEqualTo("3.22.3 盲目信任错误规则");
		String tr62 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[64]/td[1]"))).getText();
		System.out.println(tr62);
		softly.assertThat(tr62).as("test data").isEqualTo("3.22.4 规则审核不到位");
		String tr63 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[65]/td[1]"))).getText();
		System.out.println(tr63);
		softly.assertThat(tr63).as("test data").isEqualTo("3.22.5 工前会、班前会、交底会的规则不充分");
	}
	
	
	public void chineseAddContributingFactor(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Scroll down
		Thread.sleep(2000);
		jse.executeScript("scroll(0,1300)");
		Thread.sleep(2000);
		//Click on add contributing factor
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-button"))).click();
		//Scroll down
		Thread.sleep(2000);
		jse.executeScript("scroll(0,1400)");
		Thread.sleep(2000);
		//Verify all labels
		String label1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-addnewcf-cf']"))).getText();
		System.out.println(label1);
		softly.assertThat(label1).as("test data").contains("促成因素:");
		String label2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-addnewcf-fi']"))).getText();
		System.out.println(label2);
		softly.assertThat(label2).as("test data").contains("进一步调查:");
		String label3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-addnewcf-ca']"))).getText();
		System.out.println(label3);
		softly.assertThat(label3).as("test data").contains("可能的纠正行动:");
		//Verify placeholders
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-cf"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("输入 促成因素");
		String ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-fi"))).getAttribute("placeholder");
		System.out.println(ph2);
		softly.assertThat(ph2).as("test data").contains("输入 进一步调查 (非必填)");
		String ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-ca"))).getAttribute("placeholder");
		System.out.println(ph3);
		softly.assertThat(ph3).as("test data").contains("输入 可能的纠正行动 (非必填)");
		//Cancel button
		String cancel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-cancel"))).getText();
		System.out.println(cancel);
		softly.assertThat(cancel).as("test data").contains("取消");
		//Save button
		String save = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-save"))).getText();
		System.out.println(save);
		softly.assertThat(save).as("test data").contains("保存");
		//Scroll up
		Thread.sleep(2000);
		jse.executeScript("scroll(0,0)");
		Thread.sleep(2000);
	}
	
	public void changeToChinese (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		if(browserName.equals("firefox"))
		{
			//Clicks on Account
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-acct"))).click();
		}
		else
		{
			Actions act = new Actions (driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname")));
			WebElement element = driver.findElement(By.id("pii-user-loginname"));
			act.click(element).build().perform();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-acct")));
			element = driver.findElement(By.id("pii-user-acct"));
			act.click(element).build().perform();
			Thread.sleep(2000);
		}
		//Changes language to Chinese
		WebElement dropdown1 = driver.findElement(By.id("pii-admin-user-language"));
		Select s4 = new Select (dropdown1);
		s4.selectByVisibleText("Chinese");
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-button-save"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-confirmed"))).click();
		//Waits for loading message to disappear
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);
		//Go to KALE homepage
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pii-logo-div-element-kale"))).click();
	}
	

	
	public void changeToEnglish (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		while(true)
		  {
			  try{
			  if (driver.findElement(By.className("sticky-note")).isDisplayed())
			  {
				  Thread.sleep(1000);
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();
				  
			  }}catch (NoSuchElementException e)
			  {
				  break;
			  }
			  catch( StaleElementReferenceException f)
			  {
				  
				 break;
			  }
			  catch (org.openqa.selenium.TimeoutException u)
			  {
				  break;
			  }
			  catch (org.openqa.selenium.ElementNotInteractableException u)
			  {
				  break;
			  }
			  catch (org.openqa.selenium.JavascriptException t)
			  {
				  Thread.sleep(2000);
				  break;
			  }
			 
		  }
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		if(browserName.equals("firefox"))
		{
			//Clicks on Account
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-acct"))).click();
		}
		else
		{
			Actions act = new Actions (driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname")));
			WebElement element = driver.findElement(By.id("pii-user-loginname"));
			act.click(element).build().perform();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-acct")));
			element = driver.findElement(By.id("pii-user-acct"));
			act.click(element).build().perform();
			Thread.sleep(2000);
		}
		//Changes language to English
		WebElement dropdown1 = driver.findElement(By.id("pii-admin-user-language"));
		Select s4 = new Select (dropdown1);
		s4.selectByVisibleText("English");
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-button-save"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-confirmed"))).click();
		//Waits for loading message to disappear
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);
		//Go to KALE homepage
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pii-logo-div-element-kale"))).click();
	}

	
	
	public void chineseReportButtons(WebDriver driver)throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Back Button
		String back = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-uhome-back"))).getText();
		System.out.println(back);
		softly.assertThat(back).as("test data").contains("返回");
		//Other buttons
		String b1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[1]"))).getText();
		System.out.println(b1);
		softly.assertThat(b1).as("test data").contains("开启");
		String b2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).getText();
		System.out.println(b2);
		softly.assertThat(b2).as("test data").contains("打印");
		String b3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[3]"))).getText();
		System.out.println(b3);
		softly.assertThat(b3).as("test data").contains("删除");
		String b4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[4]"))).getText();
		System.out.println(b4);
		softly.assertThat(b4).as("test data").contains("分享");
	}
	
	public void chineseSave(WebDriver driver)throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Dialog header
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-header"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("保存报告");
		//Dialog title
		String title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).getText();
		System.out.println(title);
		softly.assertThat(title).as("test data").contains("请确认你要存入现有报告进度?");
		//Cancel button
		String cn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-cancel"))).getText();
		System.out.println(cn);
		softly.assertThat(cn).as("test data").contains("取消");
		//Save button
		String lop = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).getText();
		System.out.println(lop);
		softly.assertThat(lop).as("test data").contains("保存报告");
	}
	
	public void chineseReport1stPath (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Table4 rows
		String r1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r1).as("test data").contains("3.2.1 组长强化标准方面的管理能力不足");
		String r2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r2).as("test data").contains("监督管理方面的培训, 监督行为规范的管理");
		String r3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r3).as("test data").contains("3.2.2 组长绩效反馈方面的管理能力不足");
		String r4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[2]/td[3]"))).getText();
		softly.assertThat(r4).as("test data").contains("监督管理方面的培训, 监督行为规范的管理");
		String r5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r5).as("test data").contains("3.2.3 组长召开经验反馈的管理技能不足");
		String r6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[3]/td[3]"))).getText();
		softly.assertThat(r6).as("test data").contains("监督管理方面的培训, 监督行为规范的管理");
		String r7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r7).as("test data").contains("3.2.4 组长在岗培训方面管理能力不足");
		String r8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[4]/td[3]"))).getText();
		softly.assertThat(r8).as("test data").contains("监督管理方面的培训, 监督行为规范的管理");
		String r9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r9).as("test data").contains("3.2.5 组长对团队缺点认识不足，缺乏相应弥补措施");
		String r10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[5]/td[3]"))).getText();
		softly.assertThat(r10).as("test data").contains("监督管理方面的培训, 监督行为规范的管理");
		String r11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r11).as("test data").contains("3.2.6 组长发出指令和后续贯彻的沟通及协调能力不足");
		String r12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[6]/td[3]"))).getText();
		softly.assertThat(r12).as("test data").contains("监督管理方面的培训, 监督行为规范的管理");
		String r13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(r13).as("test data").contains("3.3.1 经理团队资源分配不到位");
		String r14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[7]/td[3]"))).getText();
		softly.assertThat(r14).as("test data").contains("提升管理技能，完善资源分配体系");
		String r15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[8]/td[1]"))).getText();
		softly.assertThat(r15).as("test data").contains("3.3.2 经理团队所需培训开展不充分");
		String r16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[8]/td[3]"))).getText();
		softly.assertThat(r16).as("test data").contains("成立培训计划委员会");
		String r17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[9]/td[1]"))).getText();
		softly.assertThat(r17).as("test data").contains("3.3.3 经理团队问责制不到位");
		String r18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[9]/td[3]"))).getText();
		softly.assertThat(r18).as("test data").contains("完善问责制");
		String r19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[10]/td[1]"))).getText();
		softly.assertThat(r19).as("test data").contains("3.3.4 经理团队对确定工作优先级和计划方面不到位");
		String r20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[10]/td[3]"))).getText();
		softly.assertThat(r20).as("test data").contains("完善管理优先级确定和计划体系");
		String r21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[11]/td[1]"))).getText();
		softly.assertThat(r21).as("test data").contains("3.3.5 经理管理人员对以下标准制定不充分：(1) 行为规范 (2) 程序和屏障");
		String r22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[11]/td[3]"))).getText();
		softly.assertThat(r22).as("test data").contains("开展关于标准设定的管理培训, 开展关于程序和保护屏障设计的培训");
		String r23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[12]/td[1]"))).getText();
		softly.assertThat(r23).as("test data").contains("3.3.6 经理团队绩效跟踪与趋势分析不到位");
		String r24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[12]/td[3]"))).getText();
		softly.assertThat(r24).as("test data").contains("定期开展共因分析, 改善绩效跟踪与趋势分析项目, 完善KPI");
		String r25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[13]/td[1]"))).getText();
		softly.assertThat(r25).as("test data").contains("3.3.7 经理团队内未充分建立关于团队合作的共同目标、共同利益和共同责任");
		String r26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[13]/td[3]"))).getText();
		softly.assertThat(r26).as("test data").contains("开展组织设计方面的管理培训, 在经理人员之间建立共同目标、共同利益和共同责任");
		String r27 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[14]/td[1]"))).getText();
		softly.assertThat(r27).as("test data").contains("3.3.8 经理团队纠正行动不足");
		String r28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[14]/td[3]"))).getText();
		softly.assertThat(r28).as("test data").contains("提高纠正行动计划的落实, 改善根本原因分析方法, 完善突发紧急问题（危机）管理机制");
		String r29 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[15]/td[1]"))).getText();
		softly.assertThat(r29).as("test data").contains("3.3.9 经理团队垂直沟通体系不完善");
		String r30 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[15]/td[3]"))).getText();
		softly.assertThat(r30).as("test data").contains("完善垂直沟通体系");
		String r41 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[16]/td[1]"))).getText();
		softly.assertThat(r41).as("test data").contains("3.3.10 经理团队横向沟通体系不完善");
		String r42 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[16]/td[3]"))).getText();
		softly.assertThat(r42).as("test data").contains("完善程序设计, 制定共同目标和共同利益");
		String r43 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[17]/td[1]"))).getText();
		softly.assertThat(r43).as("test data").contains("3.4.1 采取行动前没有思考如何规划（如优先顺序、机会、沟通、时间管理等）");
		String r44 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[17]/td[3]"))).getText();
		softly.assertThat(r44).as("test data").contains("开展关键思考和关键追问方面的培训");
		String r45 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[18]/td[1]"))).getText();
		softly.assertThat(r45).as("test data").contains("3.4.2 采取行动前没有考虑易出错的心理状况");
		String r46 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[18]/td[3]"))).getText();
		softly.assertThat(r46).as("test data").contains("开展关键思考和关键追问方面的培训");
		String r47 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[19]/td[1]"))).getText();
		softly.assertThat(r47).as("test data").contains("3.4.3 采取行动前没有考虑高风险情境（如单项弱点）");
		String r48 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[19]/td[3]"))).getText();
		softly.assertThat(r48).as("test data").contains("开展关键思考和关键追问方面的培训");
		String r49 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[20]/td[1]"))).getText();
		softly.assertThat(r49).as("test data").contains("3.4.4 感到疑惑时质疑不充分");
		String r50 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[20]/td[3]"))).getText();
		softly.assertThat(r50).as("test data").contains("开展关键思考和关键追问方面的培训");
		String r51 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[21]/td[1]"))).getText();
		softly.assertThat(r51).as("test data").contains("3.4.5 任务准备过程中质疑不充分");
		String r52 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[21]/td[3]"))).getText();
		softly.assertThat(r52).as("test data").contains("开展关键思考和关键追问方面的培训");
		String r53 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[22]/td[1]"))).getText();
		softly.assertThat(r53).as("test data").contains("3.5.1 作业前情况警觉（如易出错的精神状态和高风险情况）不充分");
		String r54 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[22]/td[3]"))).getText();
		softly.assertThat(r54).as("test data").contains("情况警觉培训, 作业前情况警觉（如 TAPE、工前会等）关于何时、何人、何事的要求");
		String r55 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[23]/td[1]"))).getText();
		softly.assertThat(r55).as("test data").contains("3.5.2 作业过程中情况警觉（如易出错的精神状态和高风险情况）不充分");
		String r56 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[23]/td[3]"))).getText();
		softly.assertThat(r56).as("test data").contains("情况警觉培训");
		String r57 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[24]/td[1]"))).getText();
		softly.assertThat(r57).as("test data").contains("3.5.3 对人员表现的观察技能不足");
		String r58 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[24]/td[3]"))).getText();
		softly.assertThat(r58).as("test data").contains("开展人员表现观察技能方面的培训");
		String r59 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[25]/td[1]"))).getText();
		softly.assertThat(r59).as("test data").contains("3.5.4 对设备性能的观察技能不足");
		String r60 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[25]/td[3]"))).getText();
		softly.assertThat(r60).as("test data").contains("开展退化、异常和变化等设备性能观察技能方面的培训");
		String r61 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[26]/td[1]"))).getText();
		softly.assertThat(r61).as("test data").contains("3.6.1 要求有遗漏");
		String r62 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[26]/td[3]"))).getText();
		softly.assertThat(r62).as("test data").contains("完善规则, 开展程序设计方面的培训");
		String r63 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[27]/td[1]"))).getText();
		softly.assertThat(r63).as("test data").contains("3.6.2 运行条件有遗漏");
		String r64 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[27]/td[3]"))).getText();
		softly.assertThat(r64).as("test data").contains("完善规则, 开展程序设计方面的培训");
		String r65 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[28]/td[1]"))).getText();
		softly.assertThat(r65).as("test data").contains("3.6.3 假设有遗漏");
		String r66 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[28]/td[3]"))).getText();
		softly.assertThat(r66).as("test data").contains("完善规则, 开展程序设计方面的培训");
		String r67 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[29]/td[1]"))).getText();
		softly.assertThat(r67).as("test data").contains("3.6.4 范围有遗漏");
		String r68 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[29]/td[3]"))).getText();
		softly.assertThat(r68).as("test data").contains("完善规则, 开展程序设计方面的培训");
		String r69 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[30]/td[1]"))).getText();
		softly.assertThat(r69).as("test data").contains("3.6.5 试验或测量有遗漏");
		String r70 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[30]/td[3]"))).getText();
		softly.assertThat(r70).as("test data").contains("完善规则, 开展程序设计方面的培训");
		String r71 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[31]/td[1]"))).getText();
		softly.assertThat(r71).as("test data").contains("3.6.6 遗漏以下信息: (1) 目的; (2) 先决条件; (3) 定义; (4) 经验反馈用");
		softly.assertThat(r71).as("test data").contains("不准做清单");
		softly.assertThat(r71).as("test data").contains("体现; (5) 参考资料; (6) 要求使用者反馈");
		String r72 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[31]/td[3]"))).getText();
		softly.assertThat(r72).as("test data").contains("开展程序设计编写培训, 改善程序编写导则");
		String r73 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[32]/td[1]"))).getText();
		softly.assertThat(r73).as("test data").contains("3.6.7 审查不到位导致制度有遗漏项");
		String r74 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[32]/td[3]"))).getText();
		softly.assertThat(r74).as("test data").contains("开展程序审查培训");
		String r75 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[33]/td[1]"))).getText();
		softly.assertThat(r75).as("test data").contains("3.6.8 根本原因分析不到位导致制度有遗漏项");
		String r76 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[33]/td[3]"))).getText();
		softly.assertThat(r76).as("test data").contains("开展根本原因培训");
		String r77 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[34]/td[1]"))).getText();
		softly.assertThat(r77).as("test data").contains("3.6.9 纠正措施执行不到位导致制度有遗漏项");
		String r78 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[34]/td[3]"))).getText();
		softly.assertThat(r78).as("test data").contains("改善纠正措施制度的监督与执行");
		String r79 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[35]/td[1]"))).getText();
		softly.assertThat(r79).as("test data").contains("3.9.1 培训材料在适用性、及时性或实用性方面有所欠缺");
		String r80 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[35]/td[3]"))).getText();
		softly.assertThat(r80).as("test data").contains("加强培训资源, 开展作业任务分析，从而使培训材料、课程及时间与员工执行的任务相匹配");
		String r81 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[36]/td[1]"))).getText();
		softly.assertThat(r81).as("test data").contains("3.9.2 复训频率不高(>> 一年)");
		String r82 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[36]/td[3]"))).getText();
		softly.assertThat(r82).as("test data").contains("增加复训频率，改善复训形式");
		String r83 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[37]/td[1]"))).getText();
		softly.assertThat(r83).as("test data").contains("3.9.3 部门管理层未充分参与培训材料的编写和培训的实施");
		String r84 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[37]/td[3]"))).getText();
		softly.assertThat(r84).as("test data").contains("完善关于管理层参与培训材料编写或培训实施的相关要求");
		String r85 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[38]/td[1]"))).getText();
		softly.assertThat(r85).as("test data").contains("3.9.4 未将经验教训充分包含到培训中");
		String r86 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[38]/td[3]"))).getText();
		softly.assertThat(r86).as("test data").contains("提高对培训效果的审查");
		String r87 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[39]/td[1]"))).getText();
		softly.assertThat(r87).as("test data").contains("3.9.5 所需培训开展不充分（脱岗）");
		String r88 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[39]/td[3]"))).getText();
		softly.assertThat(r88).as("test data").contains("完善承包商控制方针, 完善培训资源");
		String r89 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[40]/td[1]"))).getText();
		softly.assertThat(r89).as("test data").contains("3.9.6 所需培训开展不充分（在岗）");
		String r90 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[40]/td[3]"))).getText();
		softly.assertThat(r90).as("test data").contains("完善在岗培训方针, 完善培训资源");
		String r91 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[41]/td[1]"))).getText();
		softly.assertThat(r91).as("test data").contains("3.10.1 关键岗位员工的作业授权不充分");
		String r92 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[41]/td[3]"))).getText();
		softly.assertThat(r92).as("test data").contains("完善作业授权");
		String r93 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[42]/td[1]"))).getText();
		softly.assertThat(r93).as("test data").contains("3.10.2 关键岗位主管和（或）经理授权不充分");
		String r94 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[42]/td[3]"))).getText();
		softly.assertThat(r94).as("test data").contains("完善主管和经理的岗位授权");
		String r95 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[43]/td[1]"))).getText();
		softly.assertThat(r95).as("test data").contains("3.10.3 供应商服务（QA/RC、来源检查）授权不充分");
		String r96 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[43]/td[3]"))).getText();
		softly.assertThat(r96).as("test data").contains("完善供应商控制制度");
		String r97 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[44]/td[1]"))).getText();
		softly.assertThat(r97).as("test data").contains("3.10.4 现场供应商人员授权不充分");
		String r98 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[44]/td[3]"))).getText();
		softly.assertThat(r98).as("test data").contains("完善供应商控制制度");
		String r99 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[45]/td[1]"))).getText();
		softly.assertThat(r99).as("test data").contains("3.10.5 培训教员授权不充分");
		String r100 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[45]/td[3]"))).getText();
		softly.assertThat(r100).as("test data").contains("完善有关培训教员资格授权的管理标准与方针");
		String r101 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[46]/td[1]"))).getText();
		softly.assertThat(r101).as("test data").contains("3.11.1 绩效跟踪与趋势分析(PM&T)以及给员工的反馈不到位");
		String r102 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[46]/td[3]"))).getText();
		softly.assertThat(r102).as("test data").contains("完善趋势分析体系, 完善趋势反馈");
		String r103 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[47]/td[1]"))).getText();
		softly.assertThat(r103).as("test data").contains("3.11.2 即时反馈和持续强化(IF&CR)的管理技能不到位");
		String r104 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[47]/td[3]"))).getText();
		softly.assertThat(r104).as("test data").contains("提高主管人员的问责意识, 改善关于管理技能的培训");
		String r105 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[48]/td[1]"))).getText();
		softly.assertThat(r105).as("test data").contains("3.11.3 用于绩效控制的奖惩制度不到位");
		String r106 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[48]/td[3]"))).getText();
		softly.assertThat(r106).as("test data").contains("完善奖惩制度");
		String r107 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[49]/td[1]"))).getText();
		softly.assertThat(r107).as("test data").contains("3.11.4 问题报告、RCA和纠正行动不到位，给员工的反馈不到位");
		String r108 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[49]/td[3]"))).getText();
		softly.assertThat(r108).as("test data").contains("在问题报告政策中要求包含一切问题和及时性, RCA培训和授权, 改善对RCA结果的反馈");
		String r109 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[50]/td[1]"))).getText();
		softly.assertThat(r109).as("test data").contains("3.11.5 现场观察不充分，给员工的反馈不到位");
		String r110 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[50]/td[3]"))).getText();
		softly.assertThat(r110).as("test data").contains("针对现场观察结果，改善给员工的反馈, 改进现场观察员的制度和TQA");
		String r111 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[51]/td[1]"))).getText();
		softly.assertThat(r111).as("test data").contains("3.15.1 员工未经过相互指导的培训，或纠正他人违规情况的培训");
		String r112 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[51]/td[3]"))).getText();
		softly.assertThat(r112).as("test data").contains("同事互助提醒（好文化）培训");
		String r113 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[52]/td[1]"))).getText();
		softly.assertThat(r113).as("test data").contains("3.15.2 未要求员工对纠正他人违规的情况承担责任");
		String r114 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[52]/td[3]"))).getText();
		softly.assertThat(r114).as("test data").contains("建立关于同事互助提醒（好文化）的管理期望");
		String r115 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[53]/td[1]"))).getText();
		softly.assertThat(r115).as("test data").contains("3.15.3 员工未充分理解相关行为规范");
		String r116 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[53]/td[3]"))).getText();
		softly.assertThat(r116).as("test data").contains("行为规范培训, 采用行为规范提醒物, 采用禁止事项警告清单");
		String r117 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[54]/td[1]"))).getText();
		softly.assertThat(r117).as("test data").contains("3.15.4 主管未到现场强化");
		softly.assertThat(r117).as("test data").contains("同事指导");
		String r118 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[54]/td[3]"))).getText();
		softly.assertThat(r118).as("test data").contains("监督管理能力培训, 就监督管理强化，对管理者实施问责");
		String r119 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[55]/td[1]"))).getText();
		softly.assertThat(r119).as("test data").contains("3.18.1 盲目信任: 关键信息使用质疑的态度QV&V");
		softly.assertThat(r119).as("test data").contains("不到位");
		String r120 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[55]/td[3]"))).getText();
		softly.assertThat(r120).as("test data").contains("提高质疑的态度QV&V");
		softly.assertThat(r120).as("test data").contains(" 培训");
		String r121 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[56]/td[1]"))).getText();
		softly.assertThat(r121).as("test data").contains("3.18.2 过度自信: (1) 高估自我效能; (2) 未意识到影响变化; (3) 未寻求他人智慧; (4) 没有从过去中学习; (5) 缺少屏障预防错误发生");
		String r122 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[56]/td[3]"))).getText();
		softly.assertThat(r122).as("test data").contains("行为培训，避免过度自信");
		String r123 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[57]/td[1]"))).getText();
		softly.assertThat(r123).as("test data").contains("3.18.3 眼不见心不想: (1) 对低概率/高风险事件的风险控制不到位; (2) 忽略与绩效指标或激励无关的问题; (3) 因忽略相关风险而未设置屏障");
		String r124 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[57]/td[3]"))).getText();
		softly.assertThat(r124).as("test data").contains("改善风险控制项目(FUSE");
		softly.assertThat(r124).as("test data").contains("), 完善PM&T体系");
		String r125 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[58]/td[1]"))).getText();
		softly.assertThat(r125).as("test data").contains("3.18.4 未能及时止损: (1) 因自满和（或）无知，捍卫过去错误的决定或犹豫不决; (2) 期望通过重复同样的问题处理方法、标准或策略来实现不同的结果");
		String r126 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[58]/td[3]"))).getText();
		softly.assertThat(r126).as("test data").contains("审查以往决策的有效性，提高管理监督");
		String r127 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[59]/td[1]"))).getText();
		softly.assertThat(r127).as("test data").contains("3.18.5 陷入两选一的陷阱: 决策、问题解决或计划不充分，未能确保全面考虑多个选择方案进行分析");
		String r128 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[59]/td[3]"))).getText();
		softly.assertThat(r128).as("test data").contains("提高决策、问题解决和计划的结构（委员会）和流程");
		String r129 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[60]/td[1]"))).getText();
		softly.assertThat(r129).as("test data").contains("3.22.1 对规则的现场试验不充分");
		String r130 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[60]/td[3]"))).getText();
		softly.assertThat(r130).as("test data").contains("发布规则/程序前，执行现场试验");
		String r131 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[61]/td[1]"))).getText();
		softly.assertThat(r131).as("test data").contains("3.22.2 给规则编写人的反馈不充分，从而使其纠正错误规则");
		String r132 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[61]/td[3]"))).getText();
		softly.assertThat(r132).as("test data").contains("设计出允许执行人员记录失误方便编写人改正的程序, 制定遇到程序关键错误后要求停止操作的政策");
		String r133 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[62]/td[1]"))).getText();
		softly.assertThat(r133).as("test data").contains("3.22.3 盲目信任错误规则");
		String r134 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[62]/td[3]"))).getText();
		softly.assertThat(r134).as("test data").contains(" 培训");
		String r135 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[63]/td[1]"))).getText();
		softly.assertThat(r135).as("test data").contains("3.22.4 规则审核不到位");
		String r136 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[63]/td[3]"))).getText();
		softly.assertThat(r136).as("test data").contains("提供有效审核的相关培训");
		String r137 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[64]/td[1]"))).getText();
		softly.assertThat(r137).as("test data").contains("3.22.5 工前会、班前会、交底会的规则不充分");
		String r138 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[64]/td[3]"))).getText();
		softly.assertThat(r138).as("test data").contains("完善关于工前会、班前会、交底会的规则");
		
		//Table 6 Header
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading).as("test data").contains("调查问题");
		String heading1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading1).as("test data").contains("答案");
		String heading2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading2).as("test data").contains("选择原因");
		//Table 6 Rows
		//1.1
		String r139 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r139).as("test data").contains("1.1 始发事件为人因、设备失效还是天灾？");
		String r140 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r140).as("test data").contains("人因");
		String r141 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r141).as("test data").contains("不适用");
		//1.2
		String r142 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r142).as("test data").contains("1.2 始发事件的错误类型为何？");
		String r143 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r143).as("test data").contains("知识型错误");
		String r144 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[3]"))).getText();
		softly.assertThat(r144).as("test data").contains("不适用");
		//3.4 table heading
		String heading3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading3).as("test data").contains("可能促成因素");
		String heading4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading4).as("test data").contains("支持证据");
		String heading5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading5).as("test data").contains("进一步调查");
		String heading6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/thead/tr/th[4]"))).getText();
		softly.assertThat(heading6).as("test data").contains("可能的纠正行动");
		//3.4 table rows
		String r145 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r145).as("test data").contains("3.4.1 采取行动前没有思考如何规划（如优先顺序、机会、沟通、时间管理等）");
		String r146 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r146).as("test data").contains("不适用");
		String r147 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li"))).getText();
		softly.assertThat(r147).as("test data").contains("访谈犯错者");
		String r148 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li"))).getText();
		softly.assertThat(r148).as("test data").contains("开展关键思考和关键追问方面的培训");
		String r149 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r149).as("test data").contains("3.4.2 采取行动前没有考虑易出错的心理状况");
		String r150 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r150).as("test data").contains("不适用");
		String r151 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li"))).getText();
		softly.assertThat(r151).as("test data").contains("访谈犯错者");
		String r152 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li"))).getText();
		softly.assertThat(r152).as("test data").contains("开展关键思考和关键追问方面的培训");
		String r153 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r153).as("test data").contains("3.4.3 采取行动前没有考虑高风险情境（如单项弱点）");
		String r154 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r154).as("test data").contains("不适用");
		String r155 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li"))).getText();
		softly.assertThat(r155).as("test data").contains("访谈犯错者");
		String r156 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li"))).getText();
		softly.assertThat(r156).as("test data").contains("开展关键思考和关键追问方面的培训");
		String r157 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r157).as("test data").contains("3.4.4 感到疑惑时质疑不充分");
		String r158 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(r158).as("test data").contains("不适用");
		String r159 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r159).as("test data").contains("访谈犯错者");
		String r160 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r160).as("test data").contains("访谈主管");
		String r161 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li"))).getText();
		softly.assertThat(r161).as("test data").contains("开展关键思考和关键追问方面的培训");
		String r162 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r162).as("test data").contains("3.4.5 任务准备过程中质疑不充分");
		String r163 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(r163).as("test data").contains("不适用");
		String r164 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[5]/td[3]/ul/li"))).getText();
		softly.assertThat(r164).as("test data").contains("访谈犯错者");
		String r165 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li"))).getText();
		softly.assertThat(r165).as("test data").contains("开展关键思考和关键追问方面的培训");
		//3.18
		String r166 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r166).as("test data").contains("3.18.1 盲目信任: 关键信息使用质疑的态度QV&V");
		softly.assertThat(r166).as("test data").contains("不到位");
		String r167 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[6]/td[2]"))).getText();
		softly.assertThat(r167).as("test data").contains("不适用");
		String r168 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[6]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r168).as("test data").contains("审查培训材料？");
		String r169 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[6]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r169).as("test data").contains("审查以往类似事件？");
		String r170 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li"))).getText();
		softly.assertThat(r170).as("test data").contains("提高质疑的态度QV&V");
		softly.assertThat(r170).as("test data").contains(" 培训");
		String r171 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(r171).as("test data").contains("3.18.2 过度自信: (1) 高估自我效能; (2) 未意识到影响变化; (3) 未寻求他人智慧; (4) 没有从过去中学习; (5) 缺少屏障预防错误发生");
		String r172 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[7]/td[2]"))).getText();
		softly.assertThat(r172).as("test data").contains("不适用");
		String r173 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[7]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r173).as("test data").contains("执行首次执行的任务而没有仔细规划?");
		String r174 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[7]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r174).as("test data").contains("过去有过超出能力工作的事件?");
		String r175 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[7]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r175).as("test data").contains("对设计工作推断不当而未执行适当试验?");
		String r176 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[7]/td[4]/ul/li"))).getText();
		softly.assertThat(r176).as("test data").contains("行为培训，避免过度自信");
		String r177 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[8]/td[1]"))).getText();
		softly.assertThat(r177).as("test data").contains("3.18.3 眼不见心不想: (1) 对低概率/高风险事件的风险控制不到位; (2) 忽略与绩效指标或激励无关的问题; (3) 因忽略相关风险而未设置屏障");
		String r178 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[8]/td[2]"))).getText();
		softly.assertThat(r178).as("test data").contains("不适用");
		String r179 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[8]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r179).as("test data").contains("因忽略相关风险而未设置屏障");
		String r180 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[8]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r180).as("test data").contains("审查管理监督或项目委员会会议纪要?");
		String r181 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[8]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r181).as("test data").contains("改善风险控制项目(");
		String r182 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[8]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r182).as("test data").contains("完善PM&T体系");
		String r183 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[9]/td[1]"))).getText();
		softly.assertThat(r183).as("test data").contains("3.18.4 未能及时止损: (1) 因自满和（或）无知，捍卫过去错误的决定或犹豫不决; (2) 期望通过重复同样的问题处理方法、标准或策略来实现不同的结果");
		String r184 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[9]/td[2]"))).getText();
		softly.assertThat(r184).as("test data").contains("不适用");
		String r185 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[9]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r185).as("test data").contains("审查管理监督或项目委员会会议纪要?");
		String r186 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[9]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r186).as("test data").contains("审查以往决策的有效性，提高管理监督");
		String r187 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[10]/td[1]"))).getText();
		softly.assertThat(r187).as("test data").contains("3.18.5 陷入两选一的陷阱: 决策、问题解决或计划不充分，未能确保全面考虑多个选择方案进行分析");
		String r188 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[10]/td[2]"))).getText();
		softly.assertThat(r188).as("test data").contains("不适用");
		String r189 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[10]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r189).as("test data").contains("审查管理监督或项目委员会会议纪要?");
		String r190 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]/div/table/tbody/tr[10]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r190).as("test data").contains("提高决策、问题解决和计划的结构（委员会）和流程");
		//1.3
		String r191 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r191).as("test data").contains("1.3 若为规则型错误，是否为有意违规还是无意违规？");
		String r192 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(r192).as("test data").contains("不适用");
		String r193 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[3]"))).getText();
		softly.assertThat(r193).as("test data").contains("不适用");
		//1.4
		String r194 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r194).as("test data").contains("1.4 此无意违规是粗心导致还是程序不当导致？");
		String r195 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(r195).as("test data").contains("不适用");
		String r196 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[3]"))).getText();
		softly.assertThat(r196).as("test data").contains("不适用");
		//1.5
		String r197 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r197).as("test data").contains("1.5 若我是犯错者，我是否会犯同样的错？");
		String r198 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[6]/td[2]"))).getText();
		softly.assertThat(r198).as("test data").contains("不适用");
		String r199 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[6]/td[3]"))).getText();
		softly.assertThat(r199).as("test data").contains("不适用");
		//1.6
		String r200 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(r200).as("test data").contains("1.6 犯错者违规时是否有旁人观看？");
		String r201 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[2]"))).getText();
		softly.assertThat(r201).as("test data").contains("有");
		String r202 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[3]"))).getText();
		softly.assertThat(r202).as("test data").contains("不适用");
		//3.15 table heading
		String heading7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]/div/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading7).as("test data").contains("可能促成因素");
		String heading8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]/div/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading8).as("test data").contains("支持证据");
		String heading9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]/div/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading9).as("test data").contains("进一步调查");
		String heading10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]/div/table/thead/tr/th[4]"))).getText();
		softly.assertThat(heading10).as("test data").contains("可能的纠正行动");
		//3.15 table rows
		String r203 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]/div/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r203).as("test data").contains("3.15.1 员工未经过相互指导的培训，或纠正他人违规情况的培训");
		String r204 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]/div/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r204).as("test data").contains("不适用");
		String r205 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li"))).getText();
		softly.assertThat(r205).as("test data").contains("审查相关培训？");
		String r206 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li"))).getText();
		softly.assertThat(r206).as("test data").contains("同事互助提醒（好文化）培训");
		String r207 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]/div/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r207).as("test data").contains("3.15.2 未要求员工对纠正他人违规的情况承担责任");
		String r208 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]/div/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r208).as("test data").contains("不适用");
		String r209 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li"))).getText();
		softly.assertThat(r209).as("test data").contains("审查关于同事互助提醒（好文化）的管理期望和标准？");
		String r210 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li"))).getText();
		softly.assertThat(r210).as("test data").contains("建立关于同事互助提醒（好文化）的管理期望");
		String r211 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]/div/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r211).as("test data").contains("3.15.3 员工未充分理解相关行为规范");
		String r212 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]/div/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r212).as("test data").contains("不适用");
		String r213 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li"))).getText();
		softly.assertThat(r213).as("test data").contains("观察工前会和工作的执行，以了解对行为规范的管理强化情况？");
		String r214 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r214).as("test data").contains("行为规范培训");
		String r215 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r215).as("test data").contains("采用行为规范提醒物");
		String r216 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li[3]"))).getText();
		softly.assertThat(r216).as("test data").contains("采用禁止事项警告清单");
		String r217 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]/div/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r217).as("test data").contains("3.15.4 主管未到现场强化");
		softly.assertThat(r217).as("test data").contains("同事指导");
		String r218 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]/div/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(r218).as("test data").contains("不适用");
		String r219 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li"))).getText();
		softly.assertThat(r219).as("test data").contains("观察工前会和工作的执行，以了解对行为规范的管理强化情况？");
		String r220 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r220).as("test data").contains("监督管理能力培训");
		String r221 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r221).as("test data").contains("就监督管理强化，对管理者实施问责");
		//1.7
		String r222 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[9]/td[1]"))).getText();
		softly.assertThat(r222).as("test data").contains("1.7 这个错误是否可以透过自检或独立检查避免？");
		String r223 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[9]/td[2]"))).getText();
		softly.assertThat(r223).as("test data").contains("不能");
		String r224 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[9]/td[3]"))).getText();
		softly.assertThat(r224).as("test data").contains("不适用");
		//1.8
		String r225 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[10]/td[1]"))).getText();
		softly.assertThat(r225).as("test data").contains("1.8 犯错人员是否受过培训知道如何管理易出错精神状态和高风险？");
		String r226 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[10]/td[2]"))).getText();
		softly.assertThat(r226).as("test data").contains("没有");
		String r227 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[10]/td[3]"))).getText();
		softly.assertThat(r227).as("test data").contains("不适用");
		//3.9 table heading
		String heading11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading11).as("test data").contains("可能促成因素");
		String heading12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading12).as("test data").contains("支持证据");
		String heading13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading13).as("test data").contains("进一步调查");
		String heading14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/thead/tr/th[4]"))).getText();
		softly.assertThat(heading14).as("test data").contains("可能的纠正行动");
		//3.9 table rows
		String r228 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r228).as("test data").contains("3.9.1 培训材料在适用性、及时性或实用性方面有所欠缺");
		String r229 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r229).as("test data").contains("不适用");
		String r230 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r230).as("test data").contains("与类似组织对标？");
		String r231 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r231).as("test data").contains("通过现场观察审查培训效果？");
		String r232 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r232).as("test data").contains("加强培训资源");
		String r233 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r233).as("test data").contains("开展作业任务分析，从而使培训材料、课程及时间与员工执行的任务相匹配");
		String r234 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r234).as("test data").contains("3.9.2 复训频率不高(>> 一年)");
		String r235 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r235).as("test data").contains("不适用");
		String r236 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r236).as("test data").contains("复训频率是否是根据复杂程度和使用频率来确定的？");
		String r237 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r237).as("test data").contains("复训的形式？");
		String r238 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li"))).getText();
		softly.assertThat(r238).as("test data").contains("增加复训频率，改善复训形式");
		String r239 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r239).as("test data").contains("3.9.3 部门管理层未充分参与培训材料的编写和培训的实施");
		String r240 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r240).as("test data").contains("不适用");
		String r241 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r241).as("test data").contains("部门经理审查关于培训材料的意见？");
		String r242 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r242).as("test data").contains("部门经理监督对上课情况？");
		String r243 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li"))).getText();
		softly.assertThat(r243).as("test data").contains("完善关于管理层参与培训材料编写或培训实施的相关要求");
		String r244 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r244).as("test data").contains("3.9.4 未将经验教训充分包含到培训中");
		String r245 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(r245).as("test data").contains("不适用");
		String r246 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li"))).getText();
		softly.assertThat(r246).as("test data").contains("审查对以往事件根本原因和共同原因的调查情况（从屏障、失误陷阱等角度）？");
		String r247 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li"))).getText();
		softly.assertThat(r247).as("test data").contains("提高对培训效果的审查");
		String r248 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r248).as("test data").contains("3.9.5 所需培训开展不充分（脱岗）");
		String r249 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(r249).as("test data").contains("不适用");
		String r250 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[5]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r250).as("test data").contains("培训签到表，%员工接受了培训？");
		String r251 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[5]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r251).as("test data").contains("现场承包商没有经过培训？");
		String r252 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r252).as("test data").contains("完善承包商控制方针");
		String r253 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r253).as("test data").contains("完善培训资源");
		String r254 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r254).as("test data").contains("3.9.6 所需培训开展不充分（在岗）");
		String r255 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[6]/td[2]"))).getText();
		softly.assertThat(r255).as("test data").contains("不适用");
		String r256 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[6]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r256).as("test data").contains("在岗培训方针？");
		String r257 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[6]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r257).as("test data").contains("经验不足的员工没有经过培训？");
		String r258 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r258).as("test data").contains("完善在岗培训方针");
		String r259 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r259).as("test data").contains("完善培训资源");
		//3.10
		String r260 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(r260).as("test data").contains("3.10.1 关键岗位员工的作业授权不充分");
		String r261 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[7]/td[2]"))).getText();
		softly.assertThat(r261).as("test data").contains("不适用");
		String r262 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[7]/td[3]/ul/li"))).getText();
		softly.assertThat(r262).as("test data").contains("授权政策和证书？");
		String r263 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[7]/td[4]/ul/li"))).getText();
		softly.assertThat(r263).as("test data").contains("完善作业授权");
		String r264 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[8]/td[1]"))).getText();
		softly.assertThat(r264).as("test data").contains("3.10.2 关键岗位主管和（或）经理授权不充分");
		String r265 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[8]/td[2]"))).getText();
		softly.assertThat(r265).as("test data").contains("不适用");
		String r266 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[8]/td[3]/ul/li"))).getText();
		softly.assertThat(r266).as("test data").contains("授权政策和证书？");
		String r267 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[8]/td[4]/ul/li"))).getText();
		softly.assertThat(r267).as("test data").contains("完善主管和经理的岗位授权");
		String r268 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[9]/td[1]"))).getText();
		softly.assertThat(r268).as("test data").contains("3.10.3 供应商服务（QA/RC、来源检查）授权不充分");
		String r269 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[9]/td[2]"))).getText();
		softly.assertThat(r269).as("test data").contains("不适用");
		String r270 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[9]/td[3]/ul/li"))).getText();
		softly.assertThat(r270).as("test data").contains("授权政策和证书？");
		String r271 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[9]/td[4]/ul/li"))).getText();
		softly.assertThat(r271).as("test data").contains("完善供应商控制制度");
		String r272 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[10]/td[1]"))).getText();
		softly.assertThat(r272).as("test data").contains("3.10.4 现场供应商人员授权不充分");
		String r273 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[10]/td[2]"))).getText();
		softly.assertThat(r273).as("test data").contains("不适用");
		String r274 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[10]/td[3]/ul/li"))).getText();
		softly.assertThat(r274).as("test data").contains("授权政策和证书？");
		String r275 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[10]/td[4]/ul/li"))).getText();
		softly.assertThat(r275).as("test data").contains("完善供应商控制制度");
		String r276 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[11]/td[1]"))).getText();
		softly.assertThat(r276).as("test data").contains("3.10.5 培训教员授权不充分");
		String r277 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[11]/td[2]"))).getText();
		softly.assertThat(r277).as("test data").contains("不适用");
		String r278 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[11]/td[3]/ul/li"))).getText();
		softly.assertThat(r278).as("test data").contains("授权政策和证书？");
		String r279 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[11]/td[4]/ul/li"))).getText();
		softly.assertThat(r279).as("test data").contains("完善有关培训教员资格授权的管理标准与方针");
		//3.11
		String r280 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[12]/td[1]"))).getText();
		softly.assertThat(r280).as("test data").contains("3.11.1 绩效跟踪与趋势分析(PM&T)以及给员工的反馈不到位");
		String r281 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[12]/td[2]"))).getText();
		softly.assertThat(r281).as("test data").contains("不适用");
		String r282 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[12]/td[3]/ul/li"))).getText();
		softly.assertThat(r282).as("test data").contains("向员工反馈绩效趋势结果？");
		String r283 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[12]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r283).as("test data").contains("完善趋势分析体系");
		String r284 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[12]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r284).as("test data").contains("完善趋势反馈");
		String r285 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[13]/td[1]"))).getText();
		softly.assertThat(r285).as("test data").contains("3.11.2 即时反馈和持续强化(IF&CR)的管理技能不到位");
		String r286 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[13]/td[2]"))).getText();
		softly.assertThat(r286).as("test data").contains("不适用");
		String r287 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[13]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r287).as("test data").contains("花在现场观察和监督工作的时间是否足够？");
		String r288 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[13]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r288).as("test data").contains("标准的持续强化？");
		String r289 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[13]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r289).as("test data").contains("观察到偏差时，是否及时反馈？");
		String r290 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[13]/td[3]/ul/li[4]"))).getText();
		softly.assertThat(r290).as("test data").contains("正面反馈多余负面反馈？");
		String r291 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[13]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r291).as("test data").contains("提高主管人员的问责意识");
		String r292 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[13]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r292).as("test data").contains("改善关于管理技能的培训");
		String r293 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[14]/td[1]"))).getText();
		softly.assertThat(r293).as("test data").contains("3.11.3 用于绩效控制的奖惩制度不到位");
		String r294 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[14]/td[2]"))).getText();
		softly.assertThat(r294).as("test data").contains("不适用");
		String r295 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[14]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r295).as("test data").contains("奖惩制度是否及时？");
		String r296 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[14]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r296).as("test data").contains("奖惩制度是否公平？");
		String r297 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[14]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r297).as("test data").contains("奖惩制度是否坚定？");
		String r298 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[14]/td[4]/ul/li"))).getText();
		softly.assertThat(r298).as("test data").contains("完善奖惩制度");
		String r299 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[15]/td[1]"))).getText();
		softly.assertThat(r299).as("test data").contains("3.11.4 问题报告、RCA和纠正行动不到位，给员工的反馈不到位");
		String r300 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[15]/td[2]"))).getText();
		softly.assertThat(r300).as("test data").contains("不适用");
		String r301 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[15]/td[3]/ul/li"))).getText();
		softly.assertThat(r301).as("test data").contains("核实汇报分析的小事件数量比例以及受伤数量(<10)？");
		String r302 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[15]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r302).as("test data").contains("在问题报告政策中要求包含一切问题和及时性");
		String r303 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[15]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r303).as("test data").contains("RCA培训和授权");
		String r304 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[15]/td[4]/ul/li[3]"))).getText();
		softly.assertThat(r304).as("test data").contains("改善对RCA结果的反馈");
		String r305 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[16]/td[1]"))).getText();
		softly.assertThat(r305).as("test data").contains("3.11.5 现场观察不充分，给员工的反馈不到位");
		String r306 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[16]/td[2]"))).getText();
		softly.assertThat(r306).as("test data").contains("不适用");
		String r307 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[16]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r307).as("test data").contains("各部门均建立了现场观察指导制度？");
		String r308 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[16]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r308).as("test data").contains("对过去现场观察指导结果的有效性审查？");
		String r309 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[16]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r309).as("test data").contains("花在现场观察指导上的时间？");
		String r310 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[16]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r310).as("test data").contains("针对现场观察结果，改善给员工的反馈");
		String r311 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]/div/table/tbody/tr[16]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r311).as("test data").contains("改进现场观察员的制度和TQA");
		//1.9
		String r312 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[12]/td[1]"))).getText();
		softly.assertThat(r312).as("test data").contains("1.9 犯错者在事后是否有经组长或管理层问责？");
		String r313 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[12]/td[2]"))).getText();
		softly.assertThat(r313).as("test data").contains("没有");
		String r314 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[12]/td[3]"))).getText();
		softly.assertThat(r314).as("test data").contains("不适用");
		//3.2 table heading
		String heading15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading15).as("test data").contains("可能促成因素");
		String heading16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading16).as("test data").contains("支持证据");
		String heading17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading17).as("test data").contains("进一步调查");
		String heading18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/thead/tr/th[4]"))).getText();
		softly.assertThat(heading18).as("test data").contains("可能的纠正行动");
		//3.2 table rows
		String r315 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r315).as("test data").contains("3.2.1 组长强化标准方面的管理能力不足");
		String r316 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r316).as("test data").contains("不适用");
		String r317 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li"))).getText();
		softly.assertThat(r317).as("test data").contains("访谈同事？");
		String r318 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r318).as("test data").contains("监督管理方面的培训");
		String r319 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r319).as("test data").contains("监督行为规范的管理");
		String r320 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r320).as("test data").contains("3.2.2 组长绩效反馈方面的管理能力不足");
		String r321 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r321).as("test data").contains("不适用");
		String r322 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li"))).getText();
		softly.assertThat(r322).as("test data").contains("访谈同事？");
		String r323 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r323).as("test data").contains("监督管理方面的培训");
		String r324 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r324).as("test data").contains("监督行为规范的管理");
		String r325 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r325).as("test data").contains("3.2.3 组长召开经验反馈的管理技能不足");
		String r326 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r326).as("test data").contains("不适用");
		String r327 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li"))).getText();
		softly.assertThat(r327).as("test data").contains("访谈同事？");
		String r328 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r328).as("test data").contains("监督管理方面的培训");
		String r329 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r329).as("test data").contains("监督行为规范的管理");
		String r330 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r330).as("test data").contains("3.2.4 组长在岗培训方面管理能力不足");
		String r331 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(r331).as("test data").contains("不适用");
		String r332 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li"))).getText();
		softly.assertThat(r332).as("test data").contains("访谈同事？");
		String r333 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r333).as("test data").contains("监督管理方面的培训");
		String r334 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r334).as("test data").contains("监督行为规范的管理");
		String r335 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r335).as("test data").contains("3.2.5 组长对团队缺点认识不足，缺乏相应弥补措施");
		String r336 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(r336).as("test data").contains("不适用");
		String r337 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[5]/td[3]/ul/li"))).getText();
		softly.assertThat(r337).as("test data").contains("访谈同事？");
		String r338 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r338).as("test data").contains("监督管理方面的培训");
		String r339 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r339).as("test data").contains("监督行为规范的管理");
		String r340 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r340).as("test data").contains("3.2.6 组长发出指令和后续贯彻的沟通及协调能力不足");
		String r341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[6]/td[2]"))).getText();
		softly.assertThat(r341).as("test data").contains("不适用");
		String r342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[6]/td[3]/ul/li"))).getText();
		softly.assertThat(r342).as("test data").contains("访谈下属？");
		String r343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r343).as("test data").contains("监督管理方面的培训");
		String r344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r344).as("test data").contains("监督行为规范的管理");
		//3.11
		String r345 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(r345).as("test data").contains("3.11.1 绩效跟踪与趋势分析(PM&T)以及给员工的反馈不到位");
		String r346 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[7]/td[2]"))).getText();
		softly.assertThat(r346).as("test data").contains("不适用");
		String r347 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[7]/td[3]/ul/li"))).getText();
		softly.assertThat(r347).as("test data").contains("向员工反馈绩效趋势结果？");
		String r348 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[7]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r348).as("test data").contains("完善趋势分析体系");
		String r349 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[7]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r349).as("test data").contains("完善趋势反馈");
		String r350 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[8]/td[1]"))).getText();
		softly.assertThat(r350).as("test data").contains("3.11.2 即时反馈和持续强化(IF&CR)的管理技能不到位");
		String r351 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[8]/td[2]"))).getText();
		softly.assertThat(r351).as("test data").contains("不适用");
		String r352 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[8]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r352).as("test data").contains("花在现场观察和监督工作的时间是否足够？");
		String r353 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[8]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r353).as("test data").contains("标准的持续强化？");
		String r354 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[8]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r354).as("test data").contains("观察到偏差时，是否及时反馈？");
		String r355 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[8]/td[3]/ul/li[4]"))).getText();
		softly.assertThat(r355).as("test data").contains("正面反馈多余负面反馈？");
		String r356 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[8]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r356).as("test data").contains("提高主管人员的问责意识");
		String r357 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[8]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r357).as("test data").contains("改善关于管理技能的培训");
		String r358 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[9]/td[1]"))).getText();
		softly.assertThat(r358).as("test data").contains("3.11.3 用于绩效控制的奖惩制度不到位");
		String r359 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[9]/td[2]"))).getText();
		softly.assertThat(r359).as("test data").contains("不适用");
		String r360 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[9]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r360).as("test data").contains("奖惩制度是否及时？");
		String r361 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[9]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r361).as("test data").contains("奖惩制度是否公平？");
		String r362 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[9]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r362).as("test data").contains("奖惩制度是否坚定？");
		String r363 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[9]/td[4]/ul/li"))).getText();
		softly.assertThat(r363).as("test data").contains("完善奖惩制度");
		String r364 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[10]/td[1]"))).getText();
		softly.assertThat(r364).as("test data").contains("3.11.4 问题报告、RCA和纠正行动不到位，给员工的反馈不到位");
		String r365 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[10]/td[2]"))).getText();
		softly.assertThat(r365).as("test data").contains("不适用");
		String r366 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[10]/td[3]/ul/li"))).getText();
		softly.assertThat(r366).as("test data").contains("核实汇报分析的小事件数量比例以及受伤数量(<10)？");
		String r367 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[10]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r367).as("test data").contains("在问题报告政策中要求包含一切问题和及时性");
		String r368 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[10]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r368).as("test data").contains("RCA培训和授权");
		String r369 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[10]/td[4]/ul/li[3]"))).getText();
		softly.assertThat(r369).as("test data").contains("改善对RCA结果的反馈");
		String r370 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[11]/td[1]"))).getText();
		softly.assertThat(r370).as("test data").contains("3.11.5 现场观察不充分，给员工的反馈不到位");
		String r371 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[11]/td[2]"))).getText();
		softly.assertThat(r371).as("test data").contains("不适用");
		String r372 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[11]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r372).as("test data").contains("各部门均建立了现场观察指导制度？");
		String r373 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[11]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r373).as("test data").contains("对过去现场观察指导结果的有效性审查？");
		String r374 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[11]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r374).as("test data").contains("花在现场观察指导上的时间？");
		String r375 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[11]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r375).as("test data").contains("针对现场观察结果，改善给员工的反馈");
		String r376 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]/div/table/tbody/tr[11]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r376).as("test data").contains("改进现场观察员的制度和TQA");
		//1.10
		String r377 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[14]/td[1]"))).getText();
		softly.assertThat(r377).as("test data").contains("1.10 若有开班前会、工前会、交底会，为何犯错者未能意识到这个风险且缓解？");
		String r378 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[14]/td[2]"))).getText();
		softly.assertThat(r378).as("test data").contains("没有专心参与");
		String r379 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[14]/td[3]"))).getText();
		softly.assertThat(r379).as("test data").contains("不适用");
		//1.11
		String r380 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[15]/td[1]"))).getText();
		softly.assertThat(r380).as("test data").contains("1.11 这个错为何是现在发生而不是以前发生？");
		String r381 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[15]/td[2]"))).getText();
		softly.assertThat(r381).as("test data").contains("新程序的使用未有妥当培训");
		String r382 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[15]/td[3]"))).getText();
		softly.assertThat(r382).as("test data").contains("不适用");
		//3.9 table heading
		String heading19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading19).as("test data").contains("可能促成因素");
		String heading20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading20).as("test data").contains("支持证据");
		String heading21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading21).as("test data").contains("进一步调查");
		String heading22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/thead/tr/th[4]"))).getText();
		softly.assertThat(heading22).as("test data").contains("可能的纠正行动");
		//3.9 table rows
		String r383 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r383).as("test data").contains("3.9.1 培训材料在适用性、及时性或实用性方面有所欠缺");
		String r2291 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r2291).as("test data").contains("不适用");
		String r2301 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r2301).as("test data").contains("与类似组织对标？");
		String r2311 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r2311).as("test data").contains("通过现场观察审查培训效果？");
		String r2321 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r2321).as("test data").contains("加强培训资源");
		String r2331 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r2331).as("test data").contains("开展作业任务分析，从而使培训材料、课程及时间与员工执行的任务相匹配");
		String r2341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r2341).as("test data").contains("3.9.2 复训频率不高(>> 一年)");
		String r2351 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r2351).as("test data").contains("不适用");
		String r2361 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r2361).as("test data").contains("复训频率是否是根据复杂程度和使用频率来确定的？");
		String r2371 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r2371).as("test data").contains("复训的形式？");
		String r2381 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li"))).getText();
		softly.assertThat(r2381).as("test data").contains("增加复训频率，改善复训形式");
		String r2391 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r2391).as("test data").contains("3.9.3 部门管理层未充分参与培训材料的编写和培训的实施");
		String r2401 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r2401).as("test data").contains("不适用");
		String r2411 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r2411).as("test data").contains("部门经理审查关于培训材料的意见？");
		String r2421 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r2421).as("test data").contains("部门经理监督对上课情况？");
		String r2431 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li"))).getText();
		softly.assertThat(r2431).as("test data").contains("完善关于管理层参与培训材料编写或培训实施的相关要求");
		String r2441 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r2441).as("test data").contains("3.9.4 未将经验教训充分包含到培训中");
		String r2451 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(r2451).as("test data").contains("不适用");
		String r2461 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li"))).getText();
		softly.assertThat(r2461).as("test data").contains("审查对以往事件根本原因和共同原因的调查情况（从屏障、失误陷阱等角度）？");
		String r2471 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li"))).getText();
		softly.assertThat(r2471).as("test data").contains("提高对培训效果的审查");
		String r2481 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r2481).as("test data").contains("3.9.5 所需培训开展不充分（脱岗）");
		String r2491 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(r2491).as("test data").contains("不适用");
		String r2501 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[5]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r2501).as("test data").contains("培训签到表，%员工接受了培训？");
		String r2511 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[5]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r2511).as("test data").contains("现场承包商没有经过培训？");
		String r2521 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r2521).as("test data").contains("完善承包商控制方针");
		String r2531 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r2531).as("test data").contains("完善培训资源");
		String r2541 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r2541).as("test data").contains("3.9.6 所需培训开展不充分（在岗）");
		String r2551 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[6]/td[2]"))).getText();
		softly.assertThat(r2551).as("test data").contains("不适用");
		String r2561 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[6]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r2561).as("test data").contains("在岗培训方针？");
		String r2571 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[6]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r2571).as("test data").contains("经验不足的员工没有经过培训？");
		String r2581 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r2581).as("test data").contains("完善在岗培训方针");
		String r2591 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r2591).as("test data").contains("完善培训资源");
		//1.12
		String r3801 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[17]/td[1]"))).getText();
		softly.assertThat(r3801).as("test data").contains("1.12 若班前会、工前会或交底会未执行，为什么？");
		String r3811 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[17]/td[2]"))).getText();
		softly.assertThat(r3811).as("test data").contains("违反程序规定未执行");
		String r3821 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[17]/td[3]"))).getText();
		softly.assertThat(r3821).as("test data").contains("不适用");
		//1.13
		String r38011 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[18]/td[1]"))).getText();
		softly.assertThat(r38011).as("test data").contains("1.13 错误的发生是否存在易出错精神状态或是高风险状态？");
		String r38111 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[18]/td[2]"))).getText();
		softly.assertThat(r38111).as("test data").contains("没有，请重新思考您的答案");
		String r384 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[18]/td[3]"))).getText();
		softly.assertThat(r384).as("test data").contains("不适用");
		//1.14
		String r385= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[19]/td[1]"))).getText();
		softly.assertThat(r385).as("test data").contains("1.14 组长是否固定开展经验反馈？");
		String r386 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[19]/td[2]"))).getText();
		softly.assertThat(r386).as("test data").contains("没有，但其他组长有");
		String r387 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[19]/td[3]"))).getText();
		softly.assertThat(r387).as("test data").contains("不适用");
		//3.2 table heading
		String heading221 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading221).as("test data").contains("可能促成因素");
		String heading23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading23).as("test data").contains("支持证据");
		String heading24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading24).as("test data").contains("进一步调查");
		String heading25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/thead/tr/th[4]"))).getText();
		softly.assertThat(heading25).as("test data").contains("可能的纠正行动");
		//3.2 table rows
		String r3151 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r3151).as("test data").contains("3.2.1 组长强化标准方面的管理能力不足");
		String r3161 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r3161).as("test data").contains("不适用");
		String r3171 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li"))).getText();
		softly.assertThat(r3171).as("test data").contains("访谈同事？");
		String r3181 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r3181).as("test data").contains("监督管理方面的培训");
		String r3191 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r3191).as("test data").contains("监督行为规范的管理");
		String r388 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r388).as("test data").contains("3.2.2 组长绩效反馈方面的管理能力不足");
		String r389 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r389).as("test data").contains("不适用");
		String r390 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li"))).getText();
		softly.assertThat(r390).as("test data").contains("访谈同事？");
		String r391 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r391).as("test data").contains("监督管理方面的培训");
		String r392 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r392).as("test data").contains("监督行为规范的管理");
		String r393 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r393).as("test data").contains("3.2.3 组长召开经验反馈的管理技能不足");
		String r394 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r394).as("test data").contains("不适用");
		String r395 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li"))).getText();
		softly.assertThat(r395).as("test data").contains("访谈同事？");
		String r396 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r396).as("test data").contains("监督管理方面的培训");
		String r3291 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r3291).as("test data").contains("监督行为规范的管理");
		String r3301 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r3301).as("test data").contains("3.2.4 组长在岗培训方面管理能力不足");
		String r3311 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(r3311).as("test data").contains("不适用");
		String r3321 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li"))).getText();
		softly.assertThat(r3321).as("test data").contains("访谈同事？");
		String r3331 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r3331).as("test data").contains("监督管理方面的培训");
		String r3341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r3341).as("test data").contains("监督行为规范的管理");
		String r3351 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r3351).as("test data").contains("3.2.5 组长对团队缺点认识不足，缺乏相应弥补措施");
		String r3361 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(r3361).as("test data").contains("不适用");
		String r3371 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[5]/td[3]/ul/li"))).getText();
		softly.assertThat(r3371).as("test data").contains("访谈同事？");
		String r3381 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r3381).as("test data").contains("监督管理方面的培训");
		String r3391 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r3391).as("test data").contains("监督行为规范的管理");
		String r3401 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r3401).as("test data").contains("3.2.6 组长发出指令和后续贯彻的沟通及协调能力不足");
		String r3411 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[6]/td[2]"))).getText();
		softly.assertThat(r3411).as("test data").contains("不适用");
		String r3421 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[6]/td[3]/ul/li"))).getText();
		softly.assertThat(r3421).as("test data").contains("访谈下属？");
		String r3431 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r3431).as("test data").contains("监督管理方面的培训");
		String r3441 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r3441).as("test data").contains("监督行为规范的管理");
		//1.15
		String r397= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[21]/td[1]"))).getText();
		softly.assertThat(r397).as("test data").contains("1.15 始发事件是否有单项弱点？");
		String r398 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[21]/td[2]"))).getText();
		softly.assertThat(r398).as("test data").contains("有，但未提前识别");
		String r399 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[21]/td[3]"))).getText();
		softly.assertThat(r399).as("test data").contains("不适用");
		//3.6 table heading
		String heading27 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading27).as("test data").contains("可能促成因素");
		String heading28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading28).as("test data").contains("支持证据");
		String heading29 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading29).as("test data").contains("进一步调查");
		String heading30 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/thead/tr/th[4]"))).getText();
		softly.assertThat(heading30).as("test data").contains("可能的纠正行动");
		//3.6 table rows
		String r400 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r400).as("test data").contains("3.6.1 要求有遗漏");
		String r401 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r401).as("test data").contains("不适用");
		String r402 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r402).as("test data").contains("规范和标准？");
		String r403 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r403).as("test data").contains("规范和标准？");
		String r404 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r404).as("test data").contains("与其他项目之间的接口要求？");
		String r405 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r405).as("test data").contains("完善规则");
		String r406 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r406).as("test data").contains("开展程序设计方面的培训");
		String r407 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r407).as("test data").contains("3.6.2 运行条件有遗漏");
		String r408 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r408).as("test data").contains("不适用");
		String r409 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r409).as("test data").contains("规则适用的运行条件范围？");
		String r410 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r410).as("test data").contains("进入规则的前提条件？");
		String r411 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r411).as("test data").contains("退出规则的条件？");
		String r412 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r412).as("test data").contains("完善规则");
		String r413 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r413).as("test data").contains("开展程序设计方面的培训");
		String r414 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r414).as("test data").contains("3.6.3 假设有遗漏");
		String r415 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r415).as("test data").contains("不适用");
		String r416 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r416).as("test data").contains("假设未予以说明？");
		String r417 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r417).as("test data").contains("未要求在任务完成前对假设进行验证？");
		String r418 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r418).as("test data").contains("对未经验证的假设没有制定缓解措施？");
		String r419 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r419).as("test data").contains("完善规则");
		String r420 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r420).as("test data").contains("开展程序设计方面的培训");
		String r421 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r421).as("test data").contains("3.6.4 范围有遗漏");
		String r422 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(r422).as("test data").contains("不适用");
		String r423 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r423).as("test data").contains("使用通用规则，缺少针对各种特殊情况的具体描述？");
		String r424 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r424).as("test data").contains("步骤遗漏？");
		String r425 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r425).as("test data").contains("遗漏了碰到异常情况时需采取的行动？");
		String r426 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r426).as("test data").contains("完善规则");
		String r427 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r427).as("test data").contains("开展程序设计方面的培训");
		String r428 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r428).as("test data").contains("3.6.5 试验或测量有遗漏");
		String r429 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(r429).as("test data").contains("不适用");
		String r430 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[5]/td[3]/ul/li"))).getText();
		softly.assertThat(r430).as("test data").contains("遗漏了用于验收是否正确执行的相关试验或测量？");
		String r431 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r431).as("test data").contains("完善规则");
		String r432 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r432).as("test data").contains("开展程序设计方面的培训");
		String r433 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r433).as("test data").contains("3.6.6 遗漏以下信息: (1) 目的; (2) 先决条件; (3) 定义; (4) 经验反馈用");
		softly.assertThat(r433).as("test data").contains("不准做清单");
		softly.assertThat(r433).as("test data").contains("体现; (5) 参考资料; (6) 要求使用者反馈");
		String r434 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[6]/td[2]"))).getText();
		softly.assertThat(r434).as("test data").contains("不适用");
		String r435 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[6]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r435).as("test data").contains("调查程序编写者");
		String r436 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[6]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r436).as("test data").contains("调查程序设计编写培训");
		String r437 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r437).as("test data").contains("开展程序设计编写培训");
		String r438 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r438).as("test data").contains("改善程序编写导则");
		String r439 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(r439).as("test data").contains("3.6.7 审查不到位导致制度有遗漏项");
		String r440 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[7]/td[2]"))).getText();
		softly.assertThat(r440).as("test data").contains("不适用");
		String r441 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[7]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r441).as("test data").contains("调查程序审查者");
		String r442 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[7]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r442).as("test data").contains("调查程序审查培训");
		String r443 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[7]/td[4]/ul/li"))).getText();
		softly.assertThat(r443).as("test data").contains("开展程序审查培训");
		String r444 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[8]/td[1]"))).getText();
		softly.assertThat(r444).as("test data").contains("3.6.8 根本原因分析不到位导致制度有遗漏项");
		String r445 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[8]/td[2]"))).getText();
		softly.assertThat(r445).as("test data").contains("不适用");
		String r446 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[8]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r446).as("test data").contains("调查事件调查者");
		String r447 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[8]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r447).as("test data").contains("调查事件根本原因培训");
		String r448 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[8]/td[4]/ul/li"))).getText();
		softly.assertThat(r448).as("test data").contains("开展根本原因培训");
		String r449 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[9]/td[1]"))).getText();
		softly.assertThat(r449).as("test data").contains("3.6.9 纠正措施执行不到位导致制度有遗漏项");
		String r450 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[9]/td[2]"))).getText();
		softly.assertThat(r450).as("test data").contains("不适用");
		String r451 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[9]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r451).as("test data").contains("调查纠正措施主管");
		String r452 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[9]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r452).as("test data").contains("调查纠正措施制度缺陷");
		String r453 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[22]/td[1]/div/table/tbody/tr[9]/td[4]/ul/li"))).getText();
		softly.assertThat(r453).as("test data").contains("改善纠正措施制度的监督与执行");
		//1.16
		String r454= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[23]/td[1]"))).getText();
		softly.assertThat(r454).as("test data").contains("1.16 事件是与组长监督管理不当有关？");
		String r455 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[23]/td[2]"))).getText();
		softly.assertThat(r455).as("test data").contains("是，跟其他组长相比下有缺失");
		String r456 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[23]/td[3]"))).getText();
		softly.assertThat(r456).as("test data").contains("不适用");
		//3.2 table heading
		String heading31 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading31).as("test data").contains("可能促成因素");
		String heading32 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading32).as("test data").contains("支持证据");
		String heading33 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading33).as("test data").contains("进一步调查");
		String heading34 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/thead/tr/th[4]"))).getText();
		softly.assertThat(heading34).as("test data").contains("可能的纠正行动");
		//3.2 table rows
		String r457 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r457).as("test data").contains("3.2.1 组长强化标准方面的管理能力不足");
		String r458 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r458).as("test data").contains("不适用");
		String r459 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li"))).getText();
		softly.assertThat(r459).as("test data").contains("访谈同事？");
		String r460 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r460).as("test data").contains("监督管理方面的培训");
		String r461 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r461).as("test data").contains("监督行为规范的管理");
		String r462 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r462).as("test data").contains("3.2.2 组长绩效反馈方面的管理能力不足");
		String r463 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r463).as("test data").contains("不适用");
		String r464 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li"))).getText();
		softly.assertThat(r464).as("test data").contains("访谈同事？");
		String r465 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r465).as("test data").contains("监督管理方面的培训");
		String r466 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r466).as("test data").contains("监督行为规范的管理");
		String r467 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r467).as("test data").contains("3.2.3 组长召开经验反馈的管理技能不足");
		String r468 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r468).as("test data").contains("不适用");
		String r469 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li"))).getText();
		softly.assertThat(r469).as("test data").contains("访谈同事？");
		String r470 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r470).as("test data").contains("监督管理方面的培训");
		String r471 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r471).as("test data").contains("监督行为规范的管理");
		String r472 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r472).as("test data").contains("3.2.4 组长在岗培训方面管理能力不足");
		String r473 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(r473).as("test data").contains("不适用");
		String r474 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li"))).getText();
		softly.assertThat(r474).as("test data").contains("访谈同事？");
		String r475 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r475).as("test data").contains("监督管理方面的培训");
		String r476 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r476).as("test data").contains("监督行为规范的管理");
		String r477 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r477).as("test data").contains("3.2.5 组长对团队缺点认识不足，缺乏相应弥补措施");
		String r478 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(r478).as("test data").contains("不适用");
		String r479 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[5]/td[3]/ul/li"))).getText();
		softly.assertThat(r479).as("test data").contains("访谈同事？");
		String r480 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r480).as("test data").contains("监督管理方面的培训");
		String r481 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r481).as("test data").contains("监督行为规范的管理");
		String r482 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r482).as("test data").contains("3.2.6 组长发出指令和后续贯彻的沟通及协调能力不足");
		String r483 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[6]/td[2]"))).getText();
		softly.assertThat(r483).as("test data").contains("不适用");
		String r484 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[6]/td[3]/ul/li"))).getText();
		softly.assertThat(r484).as("test data").contains("访谈下属？");
		String r485 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r485).as("test data").contains("监督管理方面的培训");
		String r486 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[24]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r486).as("test data").contains("监督行为规范的管理");
		//1.17
		String r487= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[25]/td[1]"))).getText();
		softly.assertThat(r487).as("test data").contains("1.17 事件是与经理管理不当有关？");
		String r488 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[25]/td[2]"))).getText();
		softly.assertThat(r488).as("test data").contains("有");
		String r489 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[25]/td[3]"))).getText();
		softly.assertThat(r489).as("test data").contains("不适用");
		//3.3 table heading
		String heading35 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading35).as("test data").contains("可能促成因素");
		String heading36 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading36).as("test data").contains("支持证据");
		String heading37 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading37).as("test data").contains("进一步调查");
		String heading38 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/thead/tr/th[4]"))).getText();
		softly.assertThat(heading38).as("test data").contains("可能的纠正行动");
		//3.3 table rows
		String r490 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r490).as("test data").contains("3.3.1 经理团队资源分配不到位");
		String r491 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r491).as("test data").contains("不适用");
		String r492 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r492).as("test data").contains("是否一些工作组工作量过多，而另一些工作组工作量过少？");
		String r493 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r493).as("test data").contains("分配工作更多的是为了纠正问题，而不是防治问题？");
		String r495 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li"))).getText();
		softly.assertThat(r495).as("test data").contains("提升管理技能，完善资源分配体系");
		String r497 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r497).as("test data").contains("3.3.2 经理团队所需培训开展不充分");
		String r498 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r498).as("test data").contains("不适用");
		String r499 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li"))).getText();
		softly.assertThat(r499).as("test data").contains("培训计划是否从提高效率和提高质量两个方面考虑？");
		String r500 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li"))).getText();
		softly.assertThat(r500).as("test data").contains("成立培训计划委员会");
		String r501 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r501).as("test data").contains("3.3.3 经理团队问责制不到位");
		String r502 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r502).as("test data").contains("不适用");
		String r503 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r503).as("test data").contains("PM&T是否充分？");
		String r504 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r504).as("test data").contains("JO是否充分？");
		String r505 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r505).as("test data").contains("RCA是否充分？");
		String r506 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li[4]"))).getText();
		softly.assertThat(r506).as("test data").contains("ORRA是否充分？");
		String r507 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li"))).getText();
		softly.assertThat(r507).as("test data").contains("完善问责制");
		String r508 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r508).as("test data").contains("3.3.4 经理团队对确定工作优先级和计划方面不到位");
		String r509 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(r509).as("test data").contains("不适用");
		String r510 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r510).as("test data").contains("工作流程中没有包括工作优先级的确定？");
		String r511 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r511).as("test data").contains("优先级确定标准在时间、范围（质量）和成本三个方面没有平衡好？");
		String r512 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li"))).getText();
		softly.assertThat(r512).as("test data").contains("完善管理优先级确定和计划体系？");
		String r513 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r513).as("test data").contains("3.3.5 经理管理人员对以下标准制定不充分：(1) 行为规范 (2) 程序和屏障");
		String r514 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(r514).as("test data").contains("不适用");
		String r515 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[5]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r515).as("test data").contains("自我分析（自评）？");
		String r516 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[5]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r516).as("test data").contains("与表现优秀者对标？");
		String r517 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r517).as("test data").contains("开展关于标准设定的管理培训");
		String r518 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r518).as("test data").contains("开展关于程序和保护屏障设计的培训");
		String r519 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r519).as("test data").contains("3.3.6 经理团队绩效跟踪与趋势分析不到位");
		String r520 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[6]/td[2]"))).getText();
		softly.assertThat(r520).as("test data").contains("不适用");
		String r521 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[6]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r521).as("test data").contains("KPI不充分？");
		String r522 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[6]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r522).as("test data").contains("没有定期开展共因分析？");
		String r523 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[6]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r523).as("test data").contains("未对类似事件或失误进行趋势分析？");
		String r524 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r524).as("test data").contains("定期开展共因分析");
		String r525 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r525).as("test data").contains("改善绩效跟踪与趋势分析项目");
		String r526 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li[3]"))).getText();
		softly.assertThat(r526).as("test data").contains("完善KPI");
		String r527 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(r527).as("test data").contains("3.3.7 经理团队内未充分建立关于团队合作的共同目标、共同利益和共同责任");
		String r528 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[7]/td[2]"))).getText();
		softly.assertThat(r528).as("test data").contains("不适用");
		String r529 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[7]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r529).as("test data").contains("经理之间的接口问题？");
		String r530 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[7]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r530).as("test data").contains("主管或经理之间存在不和？");
		String r531 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[7]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r531).as("test data").contains("因两个管理团队之间接口问题，导致工作没有做？");
		String r532 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[7]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r532).as("test data").contains("开展组织设计方面的管理培训");
		String r533 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[7]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r533).as("test data").contains("在经理人员之间建立共同目标、共同利益和共同责任");
		String r534 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[8]/td[1]"))).getText();
		softly.assertThat(r534).as("test data").contains("3.3.8 经理团队纠正行动不足");
		String r535 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[8]/td[2]"))).getText();
		softly.assertThat(r535).as("test data").contains("不适用");
		String r536 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[8]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r536).as("test data").contains("根本原因分析不足导致事件重发？");
		String r537 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[8]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r537).as("test data").contains("没有注意到关键的在变化的问题导致未能解决紧急问题？");
		String r538 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[8]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r538).as("test data").contains("纠正行动制定过多导致大量纠正行动仍然积压？");
		String r539 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[8]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r539).as("test data").contains("提高纠正行动计划的落实");
		String r540 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[8]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r540).as("test data").contains("改善根本原因分析方法");
		String r541 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[8]/td[4]/ul/li[3]"))).getText();
		softly.assertThat(r541).as("test data").contains("完善突发紧急问题（危机）管理机制");
		String r542 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[9]/td[1]"))).getText();
		softly.assertThat(r542).as("test data").contains("3.3.9 经理团队垂直沟通体系不完善");
		String r543 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[9]/td[2]"))).getText();
		softly.assertThat(r543).as("test data").contains("不适用");
		String r544 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[9]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r544).as("test data").contains("方针培训？");
		String r545 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[9]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r545).as("test data").contains("对员工的管理指导？");
		String r546 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[9]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r546).as("test data").contains("传达给员工的工作指令不充分？");
		String r547 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[9]/td[3]/ul/li[4]"))).getText();
		softly.assertThat(r547).as("test data").contains("是否定期召开员工会议？");
		String r548 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[9]/td[4]/ul/li"))).getText();
		softly.assertThat(r548).as("test data").contains("完善垂直沟通体系");
		String r549 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[10]/td[1]"))).getText();
		softly.assertThat(r549).as("test data").contains("3.3.10 经理团队横向沟通体系不完善");
		String r550 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[10]/td[2]"))).getText();
		softly.assertThat(r550).as("test data").contains("不适用");
		String r551 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[10]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r551).as("test data").contains("共同目标和共同利益不充分？");
		String r552 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[10]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r552).as("test data").contains("程序设计不当？");
		String r553 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[10]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r553).as("test data").contains("完善程序设计");
		String r554 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[26]/td[1]/div/table/tbody/tr[10]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r554).as("test data").contains("制定共同目标和共同利益");
		//1.18
		String r555= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[27]/td[1]"))).getText();
		softly.assertThat(r555).as("test data").contains("1.18 事件是因程序规则有误导致？");
		String r556 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[27]/td[2]"))).getText();
		softly.assertThat(r556).as("test data").contains("是");
		String r557 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[27]/td[3]"))).getText();
		softly.assertThat(r557).as("test data").contains("不适用");
		//3.22 table heading
		String heading39 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading39).as("test data").contains("可能促成因素");
		String heading40 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading40).as("test data").contains("支持证据");
		String heading41 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading41).as("test data").contains("进一步调查");
		String heading42 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/thead/tr/th[4]"))).getText();
		softly.assertThat(heading42).as("test data").contains("可能的纠正行动");
		//3.22 table rows
		String r558 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r558).as("test data").contains("3.22.1 对规则的现场试验不充分");
		String r559 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r559).as("test data").contains("不适用");
		String r560 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li"))).getText();
		softly.assertThat(r560).as("test data").contains("有无现场试验？");
		String r561 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li"))).getText();
		softly.assertThat(r561).as("test data").contains("发布规则/程序前，执行现场试验");
		String r562 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r562).as("test data").contains("3.22.2 给规则编写人的反馈不充分，从而使其纠正错误规则");
		String r563 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r563).as("test data").contains("不适用");
		String r564 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li"))).getText();
		softly.assertThat(r564).as("test data").contains("有无反馈？");
		String r565 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r565).as("test data").contains("设计出允许执行人员记录失误方便编写人改正的程序");
		String r566 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r566).as("test data").contains("制定遇到程序关键错误后要求停止操作的政策");
		String r567 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r567).as("test data").contains("3.22.3 盲目信任错误规则");
		String r568 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r568).as("test data").contains("不适用");
		String r569 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li"))).getText();
		softly.assertThat(r569).as("test data").contains("是否要求澄清？");
		String r570 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li"))).getText();
		softly.assertThat(r570).as("test data").contains("培训");
		String r571 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r571).as("test data").contains("3.22.4 规则审核不到位");
		String r572 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(r572).as("test data").contains("不适用");
		String r573 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li"))).getText();
		softly.assertThat(r573).as("test data").contains("程序/规则当时是如何审核的？");
		String r574 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li"))).getText();
		softly.assertThat(r574).as("test data").contains("提供有效审核的相关培训");
		String r575 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r575).as("test data").contains("3.22.5 工前会、班前会、交底会的规则不充分");
		String r576 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(r576).as("test data").contains("不适用");
		String r577 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[5]/td[3]/ul/li"))).getText();
		softly.assertThat(r577).as("test data").contains("工前会、班前会、交底会上是否识别出错误的规则/程序？");
		String r578 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li"))).getText();
		softly.assertThat(r578).as("test data").contains("完善关于工前会、班前会、交底会的规则");
		//1.19
		String r579= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[29]/td[1]"))).getText();
		softly.assertThat(r579).as("test data").contains("1.19 是否有类似事件重发的趋势？");
		String r580 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[29]/td[2]"))).getText();
		softly.assertThat(r580).as("test data").contains("是");
		String r581 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[29]/td[3]"))).getText();
		softly.assertThat(r581).as("test data").contains("不适用");
		//3.3 table heading
		String heading351 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading351).as("test data").contains("可能促成因素");
		String heading361 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading361).as("test data").contains("支持证据");
		String heading371 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading371).as("test data").contains("进一步调查");
		String heading381 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/thead/tr/th[4]"))).getText();
		softly.assertThat(heading381).as("test data").contains("可能的纠正行动");
		//3.3 table rows
		String r4901 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r4901).as("test data").contains("3.3.1 经理团队资源分配不到位");
		String r4911 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r4911).as("test data").contains("不适用");
		String r4921 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r4921).as("test data").contains("是否一些工作组工作量过多，而另一些工作组工作量过少？");
		String r4931 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r4931).as("test data").contains("分配工作更多的是为了纠正问题，而不是防治问题？");
		String r4951 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li"))).getText();
		softly.assertThat(r4951).as("test data").contains("提升管理技能，完善资源分配体系");
		String r4971 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r4971).as("test data").contains("3.3.2 经理团队所需培训开展不充分");
		String r4981 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r4981).as("test data").contains("不适用");
		String r4991 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li"))).getText();
		softly.assertThat(r4991).as("test data").contains("培训计划是否从提高效率和提高质量两个方面考虑？");
		String r5001 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li"))).getText();
		softly.assertThat(r5001).as("test data").contains("成立培训计划委员会");
		String r5011 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r5011).as("test data").contains("3.3.3 经理团队问责制不到位");
		String r5021 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r5021).as("test data").contains("不适用");
		String r5031 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r5031).as("test data").contains("PM&T是否充分？");
		String r5041 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r5041).as("test data").contains("JO是否充分？");
		String r5051 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r5051).as("test data").contains("RCA是否充分？");
		String r5061 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li[4]"))).getText();
		softly.assertThat(r5061).as("test data").contains("ORRA是否充分？");
		String r5071 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li"))).getText();
		softly.assertThat(r5071).as("test data").contains("完善问责制");
		String r5081 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r5081).as("test data").contains("3.3.4 经理团队对确定工作优先级和计划方面不到位");
		String r5091 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(r5091).as("test data").contains("不适用");
		String r5101 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r5101).as("test data").contains("工作流程中没有包括工作优先级的确定？");
		String r5111 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r5111).as("test data").contains("优先级确定标准在时间、范围（质量）和成本三个方面没有平衡好？");
		String r5121 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li"))).getText();
		softly.assertThat(r5121).as("test data").contains("完善管理优先级确定和计划体系？");
		String r5131 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r5131).as("test data").contains("3.3.5 经理管理人员对以下标准制定不充分：(1) 行为规范 (2) 程序和屏障");
		String r5141 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(r5141).as("test data").contains("不适用");
		String r5151 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[5]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r5151).as("test data").contains("自我分析（自评）？");
		String r5161 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[5]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r5161).as("test data").contains("与表现优秀者对标？");
		String r5171 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r5171).as("test data").contains("开展关于标准设定的管理培训");
		String r5181 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r5181).as("test data").contains("开展关于程序和保护屏障设计的培训");
		String r5191 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r5191).as("test data").contains("3.3.6 经理团队绩效跟踪与趋势分析不到位");
		String r5201 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[6]/td[2]"))).getText();
		softly.assertThat(r5201).as("test data").contains("不适用");
		String r5211 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[6]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r5211).as("test data").contains("KPI不充分？");
		String r5221 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[6]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r5221).as("test data").contains("没有定期开展共因分析？");
		String r5231 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[6]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r5231).as("test data").contains("未对类似事件或失误进行趋势分析？");
		String r5241 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r5241).as("test data").contains("定期开展共因分析");
		String r5251 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r5251).as("test data").contains("改善绩效跟踪与趋势分析项目");
		String r5261 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li[3]"))).getText();
		softly.assertThat(r5261).as("test data").contains("完善KPI");
		String r5271 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(r5271).as("test data").contains("3.3.7 经理团队内未充分建立关于团队合作的共同目标、共同利益和共同责任");
		String r5281 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[7]/td[2]"))).getText();
		softly.assertThat(r5281).as("test data").contains("不适用");
		String r5291 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[7]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r5291).as("test data").contains("经理之间的接口问题？");
		String r5301 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[7]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r5301).as("test data").contains("主管或经理之间存在不和？");
		String r5311 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[7]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r5311).as("test data").contains("因两个管理团队之间接口问题，导致工作没有做？");
		String r5321 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[7]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r5321).as("test data").contains("开展组织设计方面的管理培训");
		String r5331 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[7]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r5331).as("test data").contains("在经理人员之间建立共同目标、共同利益和共同责任");
		String r5341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[8]/td[1]"))).getText();
		softly.assertThat(r5341).as("test data").contains("3.3.8 经理团队纠正行动不足");
		String r5351 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[8]/td[2]"))).getText();
		softly.assertThat(r5351).as("test data").contains("不适用");
		String r5361 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[8]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r5361).as("test data").contains("根本原因分析不足导致事件重发？");
		String r5371 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[8]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r5371).as("test data").contains("没有注意到关键的在变化的问题导致未能解决紧急问题？");
		String r5381 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[8]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r5381).as("test data").contains("纠正行动制定过多导致大量纠正行动仍然积压？");
		String r5391 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[8]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r5391).as("test data").contains("提高纠正行动计划的落实");
		String r5401 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[8]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r5401).as("test data").contains("改善根本原因分析方法");
		String r5411 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[8]/td[4]/ul/li[3]"))).getText();
		softly.assertThat(r5411).as("test data").contains("完善突发紧急问题（危机）管理机制");
		String r5421 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[9]/td[1]"))).getText();
		softly.assertThat(r5421).as("test data").contains("3.3.9 经理团队垂直沟通体系不完善");
		String r5431 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[9]/td[2]"))).getText();
		softly.assertThat(r5431).as("test data").contains("不适用");
		String r5441 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[9]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r5441).as("test data").contains("方针培训？");
		String r5451 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[9]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r5451).as("test data").contains("对员工的管理指导？");
		String r5461 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[9]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r5461).as("test data").contains("传达给员工的工作指令不充分？");
		String r5471 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[9]/td[3]/ul/li[4]"))).getText();
		softly.assertThat(r5471).as("test data").contains("是否定期召开员工会议？");
		String r5481 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[9]/td[4]/ul/li"))).getText();
		softly.assertThat(r5481).as("test data").contains("完善垂直沟通体系");
		String r5491 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[10]/td[1]"))).getText();
		softly.assertThat(r5491).as("test data").contains("3.3.10 经理团队横向沟通体系不完善");
		String r5501 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[10]/td[2]"))).getText();
		softly.assertThat(r5501).as("test data").contains("不适用");
		String r5511 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[10]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r5511).as("test data").contains("共同目标和共同利益不充分？");
		String r5521 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[10]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r5521).as("test data").contains("程序设计不当？");
		String r5531 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[10]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r5531).as("test data").contains("完善程序设计");
		String r5541 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[10]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r5541).as("test data").contains("制定共同目标和共同利益");
		//3.5
		String r582 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[11]/td[1]"))).getText();
		softly.assertThat(r582).as("test data").contains("3.5.1 作业前情况警觉（如易出错的精神状态和高风险情况）不充分");
		String r583 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[11]/td[2]"))).getText();
		softly.assertThat(r583).as("test data").contains("不适用");
		String r584 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[11]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r584).as("test data").contains("情况警觉培训？");
		String r585 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[11]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r585).as("test data").contains("作业前意识体系的改善？");
		String r586 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[11]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r586).as("test data").contains("情况警觉培训");
		String r587 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[11]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r587).as("test data").contains("作业前情况警觉（如 TAPE、工前会等）关于何时、何人、何事的要求");
		String r588 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[12]/td[1]"))).getText();
		softly.assertThat(r588).as("test data").contains("3.5.2 作业过程中情况警觉（如易出错的精神状态和高风险情况）不充分");
		String r589 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[12]/td[2]"))).getText();
		softly.assertThat(r589).as("test data").contains("不适用");
		String r590 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[12]/td[3]/ul/li"))).getText();
		softly.assertThat(r590).as("test data").contains("情况警觉培训？");
		String r591 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[12]/td[4]/ul/li"))).getText();
		softly.assertThat(r591).as("test data").contains("情况警觉培训");
		String r592 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[13]/td[1]"))).getText();
		softly.assertThat(r592).as("test data").contains("3.5.3 对人员表现的观察技能不足");
		String r593 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[13]/td[2]"))).getText();
		softly.assertThat(r593).as("test data").contains("不适用");
		String r594 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[13]/td[3]/ul/li"))).getText();
		softly.assertThat(r594).as("test data").contains("情况警觉培训？");
		String r595 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[13]/td[4]/ul/li"))).getText();
		softly.assertThat(r595).as("test data").contains("开展人员表现观察技能方面的培训");
		String r596 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[14]/td[1]"))).getText();
		softly.assertThat(r596).as("test data").contains("3.5.4 对设备性能的观察技能不足");
		String r597 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[14]/td[2]"))).getText();
		softly.assertThat(r597).as("test data").contains("不适用");
		String r598 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[14]/td[3]/ul/li"))).getText();
		softly.assertThat(r598).as("test data").contains("情况警觉培训？");
		String r599 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[14]/td[4]/ul/li"))).getText();
		softly.assertThat(r599).as("test data").contains("开展退化、异常和变化等设备性能观察技能方面的培训");
		//1.20
		String r600= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[31]/td[1]"))).getText();
		softly.assertThat(r600).as("test data").contains("1.20 错误是否与工作时发生改变有关？");
		String r601 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[31]/td[2]"))).getText();
		softly.assertThat(r601).as("test data").contains("是");
		String r602 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[31]/td[3]"))).getText();
		softly.assertThat(r602).as("test data").contains("不适用");
		//3.5 table heading
		String heading43 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading43).as("test data").contains("可能促成因素");
		String heading44 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading44).as("test data").contains("支持证据");
		String heading45 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading45).as("test data").contains("进一步调查");
		String heading46 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/thead/tr/th[4]"))).getText();
		softly.assertThat(heading46).as("test data").contains("可能的纠正行动");
		//3.5 rows
		String r603 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r603).as("test data").contains("3.5.1 作业前情况警觉（如易出错的精神状态和高风险情况）不充分");
		String r604 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r604).as("test data").contains("不适用");
		String r605 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r605).as("test data").contains("情况警觉培训？");
		String r606 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r606).as("test data").contains("作业前意识体系的改善？");
		String r607 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r607).as("test data").contains("情况警觉培训");
		String r608 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r608).as("test data").contains("作业前情况警觉（如 TAPE、工前会等）关于何时、何人、何事的要求");
		String r609 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r609).as("test data").contains("3.5.2 作业过程中情况警觉（如易出错的精神状态和高风险情况）不充分");
		String r610 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r610).as("test data").contains("不适用");
		String r611 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li"))).getText();
		softly.assertThat(r611).as("test data").contains("情况警觉培训？");
		String r612 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li"))).getText();
		softly.assertThat(r612).as("test data").contains("情况警觉培训");
		String r613 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r613).as("test data").contains("3.5.3 对人员表现的观察技能不足");
		String r614 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r614).as("test data").contains("不适用");
		String r615 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li"))).getText();
		softly.assertThat(r615).as("test data").contains("情况警觉培训？");
		String r616 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li"))).getText();
		softly.assertThat(r616).as("test data").contains("开展人员表现观察技能方面的培训");
		String r617 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r617).as("test data").contains("3.5.4 对设备性能的观察技能不足");
		String r618 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(r618).as("test data").contains("不适用");
		String r619 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li"))).getText();
		softly.assertThat(r619).as("test data").contains("情况警觉培训？");
		String r620 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li"))).getText();
		softly.assertThat(r620).as("test data").contains("开展退化、异常和变化等设备性能观察技能方面的培训");
		
		//Table 7 title
		String r621 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[7]/div"))).getText();
		softly.assertThat(r621).as("test data").contains("失效屏障分析过程");
		
		//Table 7 headings
		String heading461 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[7]/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading461).as("test data").contains("调查问题");
		String heading47 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[7]/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading47).as("test data").contains("答案");
		String heading48 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[7]/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading48).as("test data").contains("进一步调查");
		//Table 7 rows
		String r622 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[7]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r622).as("test data").contains("屏障是否存在能预防始发事件的发生？");
		String r623 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[7]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r623).as("test data").contains("否");
		String r624 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[7]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r624).as("test data").contains("不适用");
		String r625 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[7]/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r625).as("test data").contains("2.21 哪些屏障可以预防此事件？");
		String r626 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[7]/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r626).as("test data").contains("不适用");
		String r627 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[7]/table/tbody/tr[2]/td[3]"))).getText();
		softly.assertThat(r627).as("test data").contains("不适用");
		String r628 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[7]/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r628).as("test data").contains("是否完善引导你进行人因事件分析？");
		String r629 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[7]/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r629).as("test data").contains("不适用");
		String r630 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[7]/table/tbody/tr[3]/td[3]"))).getText();
		softly.assertThat(r630).as("test data").contains("不适用");		
		//SUEP titles
		String r631 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/div[1]"))).getText();
		softly.assertThat(r631).as("test data").contains("根本原因确认分析（SUEP）");
		String r632 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/div[2]"))).getText();
		softly.assertThat(r632).as("test data").contains(": 是否存在不合标准的实践?");
		String r633 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/div[3]"))).getText();
		softly.assertThat(r633).as("test data").contains(": 是否在管理层控制下?");
		String r634 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/div[4]"))).getText();
		softly.assertThat(r634).as("test data").contains(": 是否在事件时序早期?");
		String r635 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/div[5]"))).getText();
		softly.assertThat(r635).as("test data").contains(": 是否防止再次发生?");
		//SUEP table heading
		String heading49 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading49).as("test data").contains("促成因素");
		//SUEP table rows
		String r636 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r636).as("test data").contains("3.2.1 组长强化标准方面的管理能力不足");
		String r637 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r637).as("test data").contains("3.2.2 组长绩效反馈方面的管理能力不足");
		String r638 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r638).as("test data").contains("3.2.3 组长召开经验反馈的管理技能不足");
		String r639 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r639).as("test data").contains("3.2.4 组长在岗培训方面管理能力不足");
		String r640 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r640).as("test data").contains("3.2.5 组长对团队缺点认识不足，缺乏相应弥补措施");
		String r641 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r641).as("test data").contains("3.2.6 组长发出指令和后续贯彻的沟通及协调能力不足");
		String r642 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(r642).as("test data").contains("3.3.1 经理团队资源分配不到位");
		String r643 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[8]/td[1]"))).getText();
		softly.assertThat(r643).as("test data").contains("3.3.2 经理团队所需培训开展不充分");
		String r644 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[9]/td[1]"))).getText();
		softly.assertThat(r644).as("test data").contains("3.3.3 经理团队问责制不到位");
		String r645 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[10]/td[1]"))).getText();
		softly.assertThat(r645).as("test data").contains("3.3.4 经理团队对确定工作优先级和计划方面不到位");
		String r646 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[11]/td[1]"))).getText();
		softly.assertThat(r646).as("test data").contains("3.3.5 经理管理人员对以下标准制定不充分：(1) 行为规范 (2) 程序和屏障");
		String r647 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[12]/td[1]"))).getText();
		softly.assertThat(r647).as("test data").contains("3.3.6 经理团队绩效跟踪与趋势分析不到位");
		String r648 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[13]/td[1]"))).getText();
		softly.assertThat(r648).as("test data").contains("3.3.7 经理团队内未充分建立关于团队合作的共同目标、共同利益和共同责任");
		String r649 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[14]/td[1]"))).getText();
		softly.assertThat(r649).as("test data").contains("3.3.8 经理团队纠正行动不足");
		String r650 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[15]/td[1]"))).getText();
		softly.assertThat(r650).as("test data").contains("3.3.9 经理团队垂直沟通体系不完善");
		String r651 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[16]/td[1]"))).getText();
		softly.assertThat(r651).as("test data").contains("3.3.10 经理团队横向沟通体系不完善");
		String r652 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[17]/td[1]"))).getText();
		softly.assertThat(r652).as("test data").contains("3.4.1 采取行动前没有思考如何规划（如优先顺序、机会、沟通、时间管理等）");
		String r653 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[18]/td[1]"))).getText();
		softly.assertThat(r653).as("test data").contains("3.4.2 采取行动前没有考虑易出错的心理状况");
		String r654 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[19]/td[1]"))).getText();
		softly.assertThat(r654).as("test data").contains("3.4.3 采取行动前没有考虑高风险情境（如单项弱点）");
		String r655 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[20]/td[1]"))).getText();
		softly.assertThat(r655).as("test data").contains("3.4.4 感到疑惑时质疑不充分");
		String r656 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[21]/td[1]"))).getText();
		softly.assertThat(r656).as("test data").contains("3.4.5 任务准备过程中质疑不充分");
		String r657 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[22]/td[1]"))).getText();
		softly.assertThat(r657).as("test data").contains("3.5.1 作业前情况警觉（如易出错的精神状态和高风险情况）不充分");
		String r658 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[23]/td[1]"))).getText();
		softly.assertThat(r658).as("test data").contains("3.5.2 作业过程中情况警觉（如易出错的精神状态和高风险情况）不充分");
		String r659 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[24]/td[1]"))).getText();
		softly.assertThat(r659).as("test data").contains("3.5.3 对人员表现的观察技能不足");
		String r660 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[25]/td[1]"))).getText();
		softly.assertThat(r660).as("test data").contains("3.5.4 对设备性能的观察技能不足");
		String r661 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[26]/td[1]"))).getText();
		softly.assertThat(r661).as("test data").contains("3.6.1 要求有遗漏");
		String r662 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[27]/td[1]"))).getText();
		softly.assertThat(r662).as("test data").contains("3.6.2 运行条件有遗漏");
		String r663 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[28]/td[1]"))).getText();
		softly.assertThat(r663).as("test data").contains("3.6.3 假设有遗漏");
		String r664 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[29]/td[1]"))).getText();
		softly.assertThat(r664).as("test data").contains("3.6.4 范围有遗漏");
		String r665 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[30]/td[1]"))).getText();
		softly.assertThat(r665).as("test data").contains("3.6.5 试验或测量有遗漏");
		String r666 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[31]/td[1]"))).getText();
		softly.assertThat(r666).as("test data").contains("3.6.6 遗漏以下信息: (1) 目的; (2) 先决条件; (3) 定义; (4) 经验反馈用");
		softly.assertThat(r666).as("test data").contains("不准做清单");
		softly.assertThat(r666).as("test data").contains("体现; (5) 参考资料; (6) 要求使用者反馈");
		String r667 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[32]/td[1]"))).getText();
		softly.assertThat(r667).as("test data").contains("3.6.7 审查不到位导致制度有遗漏项");
		String r668 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[33]/td[1]"))).getText();
		softly.assertThat(r668).as("test data").contains("3.6.8 根本原因分析不到位导致制度有遗漏项");
		String r669 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[34]/td[1]"))).getText();
		softly.assertThat(r669).as("test data").contains("3.6.9 纠正措施执行不到位导致制度有遗漏项");
		String r670 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[35]/td[1]"))).getText();
		softly.assertThat(r670).as("test data").contains("3.9.1 培训材料在适用性、及时性或实用性方面有所欠缺");
		String r671 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[36]/td[1]"))).getText();
		softly.assertThat(r671).as("test data").contains("3.9.2 复训频率不高(>> 一年)");
		String r672 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[37]/td[1]"))).getText();
		softly.assertThat(r672).as("test data").contains("3.9.3 部门管理层未充分参与培训材料的编写和培训的实施");
		String r673 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[38]/td[1]"))).getText();
		softly.assertThat(r673).as("test data").contains("3.9.4 未将经验教训充分包含到培训中");
		String r674 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[39]/td[1]"))).getText();
		softly.assertThat(r674).as("test data").contains("3.9.5 所需培训开展不充分（脱岗）");
		String r675 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[40]/td[1]"))).getText();
		softly.assertThat(r675).as("test data").contains("3.9.6 所需培训开展不充分（在岗）");
		String r676 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[41]/td[1]"))).getText();
		softly.assertThat(r676).as("test data").contains("3.10.1 关键岗位员工的作业授权不充分");
		String r677 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[42]/td[1]"))).getText();
		softly.assertThat(r677).as("test data").contains("3.10.2 关键岗位主管和（或）经理授权不充分");
		String r678 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[43]/td[1]"))).getText();
		softly.assertThat(r678).as("test data").contains("3.10.3 供应商服务（QA/RC、来源检查）授权不充分");
		String r679 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[44]/td[1]"))).getText();
		softly.assertThat(r679).as("test data").contains("3.10.4 现场供应商人员授权不充分");
		String r680 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[45]/td[1]"))).getText();
		softly.assertThat(r680).as("test data").contains("3.10.5 培训教员授权不充分");
		String r681 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[46]/td[1]"))).getText();
		softly.assertThat(r681).as("test data").contains("3.11.1 绩效跟踪与趋势分析(PM&T)以及给员工的反馈不到位");
		String r682 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[47]/td[1]"))).getText();
		softly.assertThat(r682).as("test data").contains("3.11.2 即时反馈和持续强化(IF&CR)的管理技能不到位");
		String r683 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[48]/td[1]"))).getText();
		softly.assertThat(r683).as("test data").contains("3.11.3 用于绩效控制的奖惩制度不到位");
		String r684 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[49]/td[1]"))).getText();
		softly.assertThat(r684).as("test data").contains("3.11.4 问题报告、RCA和纠正行动不到位，给员工的反馈不到位");
		String r685 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[50]/td[1]"))).getText();
		softly.assertThat(r685).as("test data").contains("3.11.5 现场观察不充分，给员工的反馈不到位");
		
		//*
	}
	
	public void chineseReport(WebDriver driver)throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Table1 header 
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[1]/table/thead/tr/th"))).getText();
		softly.assertThat(heading).as("test data").contains("事件信息");
		//Table1 Side titles of report 
		String title1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[1]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(title1).as("test data").contains("事件名称");
		String title2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[1]/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(title2).as("test data").contains("事件编号");
		String title3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[1]/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(title3).as("test data").contains("事件发生日期");
		String title4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[1]/table/tbody/tr[3]/td[3]"))).getText();
		softly.assertThat(title4).as("test data").contains("事件发生时间");
		String title5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[1]/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(title5).as("test data").contains("事件发生地点");
		String title6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[1]/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(title6).as("test data").contains("部门");
		String title7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[1]/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(title7).as("test data").contains("组");
		String title8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[1]/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(title8).as("test data").contains("事件调查员");
		String title9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[1]/table/tbody/tr[8]/td[1]"))).getText();
		softly.assertThat(title9).as("test data").contains("报告编写者");
		String title10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[1]/table/tbody/tr[9]/td[1]"))).getText();
		softly.assertThat(title10).as("test data").contains("报告编写时间");
		//Table2 header 
		String heading1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[2]/table/thead/tr/th"))).getText();
		softly.assertThat(heading1).as("test data").contains("事件名称");
		//Table2 Side titles of report 
		String title11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[2]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(title11).as("test data").contains("报告摘要");
		String title12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[2]/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(title12).as("test data").contains("事件描述");
		String title13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[2]/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(title13).as("test data").contains("事件详细过程（时序构建）");
		String title14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[2]/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(title14).as("test data").contains("相关信息");
		//header
		String header3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[3]"))).getText();
		softly.assertThat(header3).as("test data").contains("事件原因");
		//Table3 header 
		String heading4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[4]/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading4).as("test data").contains("根本原因");
		String heading5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[4]/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading5).as("test data").contains("重要性分级");
		String heading6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[4]/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading6).as("test data").contains("纠正行动");
		//Table3 row
		String r1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[4]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r1).as("test data").contains("不适用");
		String r2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[4]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r2).as("test data").contains("不适用");
		String r3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[4]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r3).as("test data").contains("不适用");
		//Table4 header 
		String heading7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading7).as("test data").contains("促成因素");
		String heading8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading8).as("test data").contains("重要性分级");
		String heading9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading9).as("test data").contains("纠正行动");
		//Table4 row
		/*String r4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[1]/td[1]"))).getText();
		System.out.println(r4);
		softly.assertThat(r4).as("test data").contains("不适用");
		String r5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[1]/td[2]"))).getText();
		System.out.println(r5);
		softly.assertThat(r5).as("test data").contains("不适用");
		String r6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[1]/td[3]"))).getText();
		System.out.println(r6);
		softly.assertThat(r6).as("test data").contains("不适用");*/
		//Table 5 heading
		String heading10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading10).as("test data").contains("缺少的屏障");
		//Table 5 row
		String r7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r7).as("test data").contains("未缺少屏障");
		//header
		String header11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/div"))).getText();
		softly.assertThat(header11).as("test data").contains("根本原因分析过程");
	}
	
	public void chineseHIRCAChecklist(WebDriver driver)throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//header
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("第五步");
		softly.assertThat(heading).as("test data").contains("自检清单");
		//Table headers
		String th = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[1]/th[1]"))).getText();
		System.out.println(th);
		softly.assertThat(th).as("test data").contains("类别");
		String th1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[1]/th[2]"))).getText();
		System.out.println(th1);
		softly.assertThat(th1).as("test data").contains("调查内容");
		String th2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[1]/th[3]"))).getText();
		System.out.println(th2);
		softly.assertThat(th2).as("test data").contains("完成打勾?");
		//Row 1
		String tr = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[1]/strong"))).getText();
		System.out.println(tr);
		softly.assertThat(tr).as("test data").contains("调查概述");
		String tr1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[2]"))).getText();
		System.out.println(tr1);
		softly.assertThat(tr1).as("test data").contains("是否访谈了所有相关方，是否收集了所有相关数据？");
		//Row 2
		String tr2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[3]/td[2]"))).getText();
		System.out.println(tr2);
		softly.assertThat(tr2).as("test data").contains("是否检查了以往的类似事件？");
		//Row 3
		String tr3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[4]/td[2]"))).getText();
		System.out.println(tr3);
		softly.assertThat(tr3).as("test data").contains("是否识别出始发事件和相关屏障？");
		//Row 4
		String tr4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[5]/td[1]/strong"))).getText();
		System.out.println(tr4);
		softly.assertThat(tr4).as("test data").contains("始发事件");
		String tr5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[5]/td[2]"))).getText();
		System.out.println(tr5);
		softly.assertThat(tr5).as("test data").contains("是否确定始发事件的相关错误类型？");
		//Row 5
		String tr6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[6]/td[2]"))).getText();
		System.out.println(tr6);
		softly.assertThat(tr6).as("test data").contains("进行始发失误分析的始发事件中是否有相关的设备故障？");
		//Row 6
		String tr7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[7]/td[2]"))).getText();
		System.out.println(tr7);
		softly.assertThat(tr7).as("test data").contains("是否确定促成因子？");
		//Row 7
		String tr8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[8]/td[1]/strong"))).getText();
		System.out.println(tr8);
		softly.assertThat(tr8).as("test data").contains("根本原因");
		String tr9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[8]/td[2]"))).getText();
		System.out.println(tr9);
		softly.assertThat(tr9).as("test data").contains("根本原因是否符合");
		softly.assertThat(tr9).as("test data").contains(" 标准？");
		//Row 8
		String tr10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[9]/td[2]"))).getText();
		System.out.println(tr10);
		softly.assertThat(tr10).as("test data").contains("根本原因是否经得住");
		softly.assertThat(tr10).as("test data").contains("挑战？");
		//Row 9
		String tr11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[10]/td[2]"))).getText();
		System.out.println(tr11);
		softly.assertThat(tr11).as("test data").contains("是否识别根本原因的重要性？");
		//Row 10
		String tr12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[11]/td[1]/strong"))).getText();
		System.out.println(tr12);
		softly.assertThat(tr12).as("test data").contains("纠正行动");
		String tr13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[11]/td[2]"))).getText();
		System.out.println(tr13);
		softly.assertThat(tr13).as("test data").contains("建议的纠正行动是否涵盖所有直接原因、根本原因和关键促成因素？");
		//Row 11
		String tr14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[12]/td[2]"))).getText();
		System.out.println(tr14);
		softly.assertThat(tr14).as("test data").contains("建议的纠正行动是否具有成本效益？");
	}
	
	public void chineseStep4(WebDriver driver)throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//header
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("第四步 - 判别根本原因和促成因素的重要性");
		//Table headers
		String th = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[1]/th[1]"))).getText();
		System.out.println(th);
		softly.assertThat(th).as("test data").contains("始发事件的根本原因与促成因素");
		String th1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[1]/th[2]"))).getText();
		System.out.println(th1);
		softly.assertThat(th1).as("test data").contains("R:根本原因 或 C:促成因素");
		String th1d = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[1]/th[2]/div"))).getText();
		System.out.println(th1d);
		softly.assertThat(th1d).as("test data").contains("(R 或 C)");
		String th2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[1]/th[3]"))).getText();
		System.out.println(th2);
		softly.assertThat(th2).as("test data").contains("重要性分级");
		String th2d = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[1]/th[3]/div"))).getText();
		System.out.println(th2d);
		softly.assertThat(th2d).as("test data").contains("(H:高, M:中 或 L:低)");
		/*
		//Row
		String tr = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[1]"))).getText();
		System.out.println(tr);
		softly.assertThat(tr).as("test data").contains("不适用");
		String tr1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[2]"))).getText();
		System.out.println(tr1);
		softly.assertThat(tr1).as("test data").contains("不适用");
		String tr2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[3]"))).getText();
		System.out.println(tr2);
		softly.assertThat(tr2).as("test data").contains("不适用");
		*/
	}
	
	public void chineseSUEP(WebDriver driver)throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//header
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("第三步 - 判别根本原因");
		//S
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		System.out.println(s);
		softly.assertThat(s).as("test data").contains(": 是否存在不合标准的实践?");
		//U
		String u = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]"))).getText();
		System.out.println(u);
		softly.assertThat(u).as("test data").contains(": 是否在管理层控制下?");
		//E
		String e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]"))).getText();
		System.out.println(e);
		softly.assertThat(e).as("test data").contains(": 是否在事件时序早期?");
		//P
		String p = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]"))).getText();
		System.out.println(p);
		softly.assertThat(p).as("test data").contains(": 是否防止再次发生?");
		//Table heading
		String th = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[1]/th[1]"))).getText();
		System.out.println(th);
		softly.assertThat(th).as("test data").contains("促成因素");
		/*
		//Row
		String tr = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[1]"))).getText();
		System.out.println(tr);
		softly.assertThat(tr).as("test data").contains("不适用");
		String tr1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[2]"))).getText();
		System.out.println(tr1);
		softly.assertThat(tr1).as("test data").contains("不适用");
		String tr2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[3]"))).getText();
		System.out.println(tr2);
		softly.assertThat(tr2).as("test data").contains("不适用");
		String tr3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[4]"))).getText();
		System.out.println(tr3);
		softly.assertThat(tr3).as("test data").contains("不适用");
		String tr4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[5]"))).getText();
		System.out.println(tr4);
		softly.assertThat(tr4).as("test data").contains("不适用");
		*/
	}
	
	public void chineseLOPRC(WebDriver driver)throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Dialog header
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-header"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("屏障或根本原因分析");
		//Dialog title
		String title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).getText();
		System.out.println(title);
		softly.assertThat(title).as("test data").contains("您要(1)继续分析屏障失效或是(2)前往根本原因分析？");
		//Dialog note
		String note = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-note"))).getText();
		System.out.println(note);
		softly.assertThat(note).as("test data").contains("提醒：屏障失效分析可以随时回头再做。");
		//Cancel button
		String cn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-cancel"))).getText();
		System.out.println(cn);
		softly.assertThat(cn).as("test data").contains("取消");
		//LOP button
		String lop = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).getText();
		System.out.println(lop);
		softly.assertThat(lop).as("test data").contains("屏障");
		//Root cause button
		String rc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed2"))).getText();
		System.out.println(rc);
		softly.assertThat(rc).as("test data").contains("根本原因");
	}
	
	public void chineseStepOneL317 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("设备的鉴定、试验和维修");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		System.out.println(textD);
		softly.assertThat(textD).as("test data").contains("若不适用点选skip略过。使用者可于底部新增促成因素。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("若始发事件是由设备失效造成，可初步评估设备可能失效原因。完整的设备根本原因分析或故障排除请使用EiRCA模块。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.17.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(q341);
		softly.assertThat(q341).as("test data").contains("[3.17.1] 采购和（或）设计规范不充分");
		//Click on 3.17.1 to reveal evidence entry
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']")));
		String s = ele.getAttribute("class");
		if(s.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).getText();
		System.out.println(ev1);
		softly.assertThat(ev1).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Evidence entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-0"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Click on 3.17.1 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//2nd collapsible for 3.17.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c1);
		softly.assertThat(c1).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.17.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c2);
		softly.assertThat(c2).as("test data").contains("用于制定技术规范的行业标准？QA/QC?");
		String c26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c26);
		softly.assertThat(c26).as("test data").contains("供应商资格？");
		//Click on 2nd collapsible for 3.17.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.17.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c10);
		softly.assertThat(c10).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.17.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c3);
		softly.assertThat(c3).as("test data").contains("提高风险管理");
		String c35 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c35);
		softly.assertThat(c35).as("test data").contains("针对高风险技术规范，利用专家委员会");
		String c37 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[3]"))).getText();
		System.out.println(c37);
		softly.assertThat(c37).as("test data").contains("对重复技术规范实现标准化");
		//Click on 3rd collapsible for 3.17.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.17.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(q342);
		softly.assertThat(q342).as("test data").contains("[3.17.2] 来源合规性的审计/检查(QA/QC) 不充分（如适用）");
		//Click on 3.17.2 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']")));
		String s1 = ele.getAttribute("class");
		if(s1.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).getText();
		System.out.println(ev2);
		softly.assertThat(ev2).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Evidence entry place holder
		String ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-1"))).getAttribute("placeholder");
		System.out.println(ph2);
		softly.assertThat(ph2).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Click on 3.17.2 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//2nd collapsible for 3.17.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c4);
		softly.assertThat(c4).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.17.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c5);
		softly.assertThat(c5).as("test data").contains("QA/QC 人员的培训和授权？全范围QA审计？");
		String c46 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c46);
		softly.assertThat(c46).as("test data").contains("连续审计/检查或抽查审计/检查？");
		//Click on 2nd collapsible for 3.17.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.17.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c11);
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.17.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c6);
		softly.assertThat(c6).as("test data").contains("改善来源QA/QC 项目");
		//Click on 3rd collapsible for 3.17.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.17.3 question
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(q343);
		softly.assertThat(q343).as("test data").contains("[3.17.3] 设计确认和（或）使用前试验不充分");
		//Click on 3.17.3 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']")));
		String s2 = ele.getAttribute("class");
		if(s2.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).getText();
		System.out.println(ev3);
		softly.assertThat(ev3).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Evidence entry place holder
		String ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-2"))).getAttribute("placeholder");
		System.out.println(ph3);
		softly.assertThat(ph3).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Click on 3.17.3 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//2nd collapsible for 3.17.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c7);
		softly.assertThat(c7).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.17.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c8);
		softly.assertThat(c8).as("test data").contains("外推过多而没有执行鉴定试验？");
		String c36 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c36);
		softly.assertThat(c36).as("test data").contains("复杂分析或计算的独立验证？");
		String c47 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();
		System.out.println(c47);
		softly.assertThat(c47).as("test data").contains("非编码计算的不确定性分析？");
		//Click on 2nd collapsible for 3.17.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.17.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c12);
		softly.assertThat(c12).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.17.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c9);
		softly.assertThat(c9).as("test data").contains("改善设计确认和鉴定试验项目");
		//Click on 3rd collapsible for 3.17.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.17.4 question
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		System.out.println(q344);
		softly.assertThat(q344).as("test data").contains("[3.17.4] 运行不到位: (1) 运行程序不到位; (2) 运行条件不到位; (3) 运行失误");
		//Click on 3.17.4 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']")));
		String s3 = ele.getAttribute("class");
		if(s3.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).getText();
		System.out.println(ev4);
		softly.assertThat(ev4).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Evidence entry place holder
		String ph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-3"))).getAttribute("placeholder");
		System.out.println(ph4);
		softly.assertThat(ph4).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Click on 3.17.4 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		//2nd collapsible for 3.17.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c13);
		softly.assertThat(c13).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.17.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c14);
		softly.assertThat(c14).as("test data").contains("审查运行程序编写指导文件");
		//Click on 2nd collapsible for 3.17.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.17.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c16);
		softly.assertThat(c16).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.17.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c17);
		softly.assertThat(c17).as("test data").contains("纠正运行程序中的缺陷");
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c22);
		softly.assertThat(c22).as("test data").contains("完善运行程序编写指导文件");
		//Click on 3rd collapsible for 3.17.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.17.5 question
		String q345 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		System.out.println(q345);
		softly.assertThat(q345).as("test data").contains("[3.17.5] 定期监督试验不到位");
		//Click on 3.17.5 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']")));
		String s5 = ele.getAttribute("class");
		if(s5.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).getText();
		System.out.println(ev5);
		softly.assertThat(ev5).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Evidence entry place holder
		String ph5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-4"))).getAttribute("placeholder");
		System.out.println(ph5);
		softly.assertThat(ph5).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Click on 3.17.5 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		//2nd collapsible for 3.17.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c18);
		softly.assertThat(c18).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.17.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c19);
		softly.assertThat(c19).as("test data").contains("没有执行监督试验？");
		//Click on 2nd collapsible for 3.17.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.17.5
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c20);
		softly.assertThat(c20).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.17.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c21);
		softly.assertThat(c21).as("test data").contains("完善监督试验大纲");
		//Click on 3rd collapsible for 3.17.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Scroll to the end
		Thread.sleep(2000);
		jse.executeScript("scroll(0,1100)");
		Thread.sleep(2000);
		//3.17.6 question
		String q396 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).getText();
		System.out.println(q396);
		softly.assertThat(q396).as("test data").contains("[3.17.6] 维修不到位");
		//Click on 3.17.6 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']")));
		String s6 = ele.getAttribute("class");
		if(s6.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).getText();
		System.out.println(ev6);
		softly.assertThat(ev6).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).click();
		//Evidence entry place holder
		String ph6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-5"))).getAttribute("placeholder");
		System.out.println(ph6);
		softly.assertThat(ph6).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).click();
		//Click on 3.17.6 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).click();
		//2nd collapsible for 3.17.6
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c15);
		softly.assertThat(c15).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.17.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c28);
		softly.assertThat(c28).as("test data").contains("没有执行预防性维修？");
		String c40 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c40);
		softly.assertThat(c40).as("test data").contains("纠正性维修没有效果？");
		//Click on 2nd collapsible for 3.17.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.17.6
		String c30 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c30);
		softly.assertThat(c30).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.17.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c31 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c31);
		softly.assertThat(c31).as("test data").contains("完善预防性维修大纲");
		String c32 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c32);
		softly.assertThat(c32).as("test data").contains("完善纠正性维修大纲");
		//Click on 3rd collapsible for 3.17.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.17.7 question
		String q367 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']"))).getText();
		System.out.println(q367);
		softly.assertThat(q367).as("test data").contains("[3.17.7] 设备的标识和识别不到位");
		//Click on 3.17.7 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']")));
		String s7 = ele.getAttribute("class");
		if(s7.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-6']/h4/a"))).getText();
		System.out.println(ev7);
		softly.assertThat(ev7).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-6']/h4/a"))).click();
		//Evidence entry place holder
		String ph7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-6"))).getAttribute("placeholder");
		System.out.println(ph7);
		softly.assertThat(ph7).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-6']/h4/a"))).click();
		//Click on 3.17.7 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']"))).click();
		//2nd collapsible for 3.17.7
		String c41 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c41);
		softly.assertThat(c41).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.17.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c42 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c42);
		softly.assertThat(c42).as("test data").contains("检查所有提及的设备不仅有标识，且标识正确");
		//Click on 2nd collapsible for 3.17.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.17.7
		String c44 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c44);
		softly.assertThat(c44).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.3.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c45 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c45);
		softly.assertThat(c45).as("test data").contains("改进设备标识和识别");
		//Click on 3rd collapsible for 3.17.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Add new contributing factor button
		String c33 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-button"))).getText();
		System.out.println(c33);
		softly.assertThat(c33).as("test data").contains("新增促成因素");
		//Verify Add Contributing factor
		chineseAddContributingFactor(driver);
		//Scroll to the top
		Thread.sleep(2000);
		jse.executeScript("scroll(0,0)");
		Thread.sleep(2000);
	}
	
	public void chineseStepOneq120 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.20 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(q11);
		softly.assertThat(q11).as("test data").contains("[1.20] 错误是否与工作时发生改变有关？");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();
		System.out.println(reason);
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("这一问题探讨了工作过程中的变更是否促成失误发生的原因。工作过程中的变更可能会产生新的、不熟悉的事物，这会造成易出错状态的形成");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(ans1);
		softly.assertThat(ans1).as("test data").contains("是");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(ans2);
		softly.assertThat(ans2).as("test data").contains("是，为无法预测的天灾");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(ans3);
		softly.assertThat(ans3).as("test data").contains("否");
	}	
	
	public void chineseStepOneL35 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("情况警觉不充分");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		System.out.println(textD);
		softly.assertThat(textD).as("test data").contains("若不适用点选skip略过。使用者可于底部新增促成因素。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("情况警觉识别和分析影响失误率的内部和外部风险。内部分析涉及易出错的精神状态。外部风险涉及高风险状态。有证据表明缺乏情况警觉会促成这个失误发生吗？");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.5.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(q341);
		softly.assertThat(q341).as("test data").contains("[3.5.1] 作业前情况警觉（如易出错的精神状态和高风险情况）不充分");
		//Click on 3.5.1 to reveal evidence entry
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']")));
		String s1 = ele.getAttribute("class");
		if(s1.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).getText();
		System.out.println(ev1);
		softly.assertThat(ev1).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Evidence entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-0"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Click on 3.5.1 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//2nd collapsible for 3.5.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c1);
		softly.assertThat(c1).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.5.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c2);
		softly.assertThat(c2).as("test data").contains("情况警觉培训？");
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c22);
		softly.assertThat(c22).as("test data").contains("作业前意识体系的改善？");
		//Click on 2nd collapsible for 3.5.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.5.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c10);
		softly.assertThat(c10).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.5.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c3);
		softly.assertThat(c3).as("test data").contains("情况警觉培训");
		String c23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c23);
		softly.assertThat(c23).as("test data").contains("作业前情况警觉（如 TAPE、工前会等）关于何时、何人、何事的要求");
		//Click on 3rd collapsible for 3.5.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.5.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(q342);
		softly.assertThat(q342).as("test data").contains("[3.5.2] 作业过程中情况警觉（如易出错的精神状态和高风险情况）不充分");
		//Click on 3.5.2 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']")));
		String s2 = ele.getAttribute("class");
		if(s2.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).getText();
		System.out.println(ev2);
		softly.assertThat(ev2).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Evidence entry place holder
		String ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-1"))).getAttribute("placeholder");
		System.out.println(ph2);
		softly.assertThat(ph2).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Click on 3.5.2 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//2nd collapsible for 3.5.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c4);
		softly.assertThat(c4).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.5.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c5);
		softly.assertThat(c5).as("test data").contains("情况警觉培训？");
		//Click on 2nd collapsible for 3.5.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.5.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c11);
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.5.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c6);
		softly.assertThat(c6).as("test data").contains("情况警觉培训");
		//Click on 3rd collapsible for 3.5.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.5.3 question
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(q343);
		softly.assertThat(q343).as("test data").contains("[3.5.3] 对人员表现的观察技能不足");
		//Click on 3.5.3 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']")));
		String s3 = ele.getAttribute("class");
		if(s3.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).getText();
		System.out.println(ev3);
		softly.assertThat(ev3).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Evidence entry place holder
		String ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-2"))).getAttribute("placeholder");
		System.out.println(ph3);
		softly.assertThat(ph3).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Click on 3.5.3 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//2nd collapsible for 3.5.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c7);
		softly.assertThat(c7).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.5.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c8);
		softly.assertThat(c8).as("test data").contains("情况警觉培训？");
		//Click on 2nd collapsible for 3.5.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.5.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c12);
		softly.assertThat(c12).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.5.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		System.out.println(c9);
		softly.assertThat(c9).as("test data").contains("开展人员表现观察技能方面的培训");
		//Click on 3rd collapsible for 3.5.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.5.4 question
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		System.out.println(q344);
		softly.assertThat(q344).as("test data").contains("[3.5.4] 对设备性能的观察技能不足");
		//Click on 3.5.4 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']")));
		String s4 = ele.getAttribute("class");
		if(s4.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).getText();
		System.out.println(ev4);
		softly.assertThat(ev4).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Evidence entry place holder
		String ph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-3"))).getAttribute("placeholder");
		System.out.println(ph4);
		softly.assertThat(ph4).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Click on 3.5.4 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		//2nd collapsible for 3.5.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c13);
		softly.assertThat(c13).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.5.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c14);
		softly.assertThat(c14).as("test data").contains("情况警觉培训？");
		//Click on 2nd collapsible for 3.5.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.5.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c16);
		softly.assertThat(c16).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.5.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c17);
		softly.assertThat(c17).as("test data").contains("开展退化、异常和变化等设备性能观察技能方面的培训");
		//Click on 3rd collapsible for 3.5.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Add new contributing factor button
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-button"))).getText();
		System.out.println(c15);
		softly.assertThat(c15).as("test data").contains("新增促成因素");
		//Verify Add Contributing factor
		chineseAddContributingFactor(driver);
	}
	
	public void chineseStepOneq119 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.19 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(q11);
		softly.assertThat(q11).as("test data").contains("[1.19] 是否有类似事件重发的趋势？");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();
		System.out.println(reason);
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("这个问题探讨了此事件是否与组织的绩效控制管理有关。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(ans1);
		softly.assertThat(ans1).as("test data").contains("是");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(ans2);
		softly.assertThat(ans2).as("test data").contains("没有，趋势下降");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(ans3);
		softly.assertThat(ans3).as("test data").contains("没有");
	}
	
	public void chineseStepOneL322 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("规则不正确");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		System.out.println(textD);
		softly.assertThat(textD).as("test data").contains("若不适用点选skip略过。使用者可于底部新增促成因素。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("若规则不正确，是什么原因导致的？");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.22.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(q341);
		softly.assertThat(q341).as("test data").contains("[3.22.1] 对规则的现场试验不充分");
		//Click on 3.22.1 to reveal evidence entry
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']")));
		String s1 = ele.getAttribute("class");
		if(s1.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).getText();
		System.out.println(ev1);
		softly.assertThat(ev1).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Evidence entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-0"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Click on 3.22.1 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//2nd collapsible for 3.22.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c1);
		softly.assertThat(c1).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.22.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c2);
		softly.assertThat(c2).as("test data").contains("有无现场试验？");
		//Click on 2nd collapsible for 3.22.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.22.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c10);
		softly.assertThat(c10).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.22.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c3);
		softly.assertThat(c3).as("test data").contains("发布规则/程序前，执行现场试验");
		//Click on 3rd collapsible for 3.22.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.22.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(q342);
		softly.assertThat(q342).as("test data").contains("[3.22.2] 给规则编写人的反馈不充分，从而使其纠正错误规则");
		//Click on 3.22.2 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']")));
		String s2 = ele.getAttribute("class");
		if(s2.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).getText();
		System.out.println(ev2);
		softly.assertThat(ev2).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Evidence entry place holder
		String ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-1"))).getAttribute("placeholder");
		System.out.println(ph2);
		softly.assertThat(ph2).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Click on 3.22.2 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//2nd collapsible for 3.22.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c4);
		softly.assertThat(c4).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.22.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c5);
		softly.assertThat(c5).as("test data").contains("有无反馈？");
		//Click on 2nd collapsible for 3.22.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.22.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c11);
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.22.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c6);
		softly.assertThat(c6).as("test data").contains("设计出允许执行人员记录失误方便编写人改正的程序");
		String c28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c28);
		softly.assertThat(c28).as("test data").contains("制定遇到程序关键错误后要求停止操作的政策");
		//Click on 3rd collapsible for 3.22.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.22.3 question
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(q343);
		softly.assertThat(q343).as("test data").contains("[3.22.3] 盲目信任错误规则");
		//Click on 3.22.3 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']")));
		String s3 = ele.getAttribute("class");
		if(s3.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).getText();
		System.out.println(ev3);
		softly.assertThat(ev3).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Evidence entry place holder
		String ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-2"))).getAttribute("placeholder");
		System.out.println(ph3);
		softly.assertThat(ph3).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Click on 3.22.3 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//2nd collapsible for 3.22.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c7);
		softly.assertThat(c7).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.22.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c8);
		softly.assertThat(c8).as("test data").contains("是否要求澄清？");
		//Click on 2nd collapsible for 3.22.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.22.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c12);
		softly.assertThat(c12).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.22.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		System.out.println(c9);
		softly.assertThat(c9).as("test data").contains("培训");
		//Click on 3rd collapsible for 3.22.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.22.4 question
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		System.out.println(q344);
		softly.assertThat(q344).as("test data").contains("[3.22.4] 规则审核不到位");
		//Click on 3.22.4 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']")));
		String s4 = ele.getAttribute("class");
		if(s4.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).getText();
		System.out.println(ev4);
		softly.assertThat(ev4).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Evidence entry place holder
		String ph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-3"))).getAttribute("placeholder");
		System.out.println(ph4);
		softly.assertThat(ph4).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Click on 3.22.4 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		//2nd collapsible for 3.22.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c13);
		softly.assertThat(c13).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.22.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c14);
		softly.assertThat(c14).as("test data").contains("程序/规则当时是如何审核的？");
		//Click on 2nd collapsible for 3.22.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.22.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c16);
		softly.assertThat(c16).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.22.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c17);
		softly.assertThat(c17).as("test data").contains("提供有效审核的相关培训");
		//Click on 3rd collapsible for 3.22.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.22.5 question
		String q345 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		System.out.println(q345);
		softly.assertThat(q345).as("test data").contains("[3.22.5] 工前会、班前会、交底会的规则不充分");
		//Click on 3.22.5 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']")));
		String s5 = ele.getAttribute("class");
		if(s5.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).getText();
		System.out.println(ev5);
		softly.assertThat(ev5).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Evidence entry place holder
		String ph5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-4"))).getAttribute("placeholder");
		System.out.println(ph5);
		softly.assertThat(ph5).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Click on 3.22.5 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		//2nd collapsible for 3.22.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c18);
		softly.assertThat(c18).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.22.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c19);
		softly.assertThat(c19).as("test data").contains("工前会、班前会、交底会上是否识别出错误的规则/程序？");
		//Click on 2nd collapsible for 3.22.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.22.5
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c20);
		softly.assertThat(c20).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.22.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c21);
		softly.assertThat(c21).as("test data").contains("完善关于工前会、班前会、交底会的规则");
		//Click on 3rd collapsible for 3.22.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Add new contributing factor button
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-button"))).getText();
		System.out.println(c15);
		softly.assertThat(c15).as("test data").contains("新增促成因素");
		//Verify Add Contributing factor
		chineseAddContributingFactor(driver);
	}
	
	public void chineseStepOneq118 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.18 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(q11);
		softly.assertThat(q11).as("test data").contains("[1.18] 事件是因程序规则有误导致？");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();
		System.out.println(reason);
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("这个问题探讨了现有规制是否不仅促成这一实例的发生，还促成了这一失误的多次发生");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(ans1);
		softly.assertThat(ans1).as("test data").contains("是");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(ans2);
		softly.assertThat(ans2).as("test data").contains("不是");
	}
	
	public void chineseStepOneL33 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("经理层面");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		System.out.println(textD);
		softly.assertThat(textD).as("test data").contains("若不适用点选skip略过。使用者可于底部新增促成因素。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("这些促成因素归因于经理层，因为这关系到影响组织绩效的失误。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.3.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(q341);
		softly.assertThat(q341).as("test data").contains("[3.3.1] 经理团队资源分配不到位");
		//Click on 3.3.1 to reveal evidence entry
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']")));
		String s1 = ele.getAttribute("class");
		if(s1.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).getText();
		System.out.println(ev1);
		softly.assertThat(ev1).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Evidence entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-0"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Click on 3.3.1 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//2nd collapsible for 3.3.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c1);
		softly.assertThat(c1).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.3.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c2);
		softly.assertThat(c2).as("test data").contains("是否一些工作组工作量过多，而另一些工作组工作量过少？");
		String c26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c26);
		softly.assertThat(c26).as("test data").contains("分配工作更多的是为了纠正问题，而不是防治问题？");
		//Click on 2nd collapsible for 3.3.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.3.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c10);
		softly.assertThat(c10).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.3.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c3);
		softly.assertThat(c3).as("test data").contains("提升管理技能，完善资源分配体系");
		//Click on 3rd collapsible for 3.3.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.3.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(q342);
		softly.assertThat(q342).as("test data").contains("[3.3.2] 经理团队所需培训开展不充分");
		//Click on 3.3.2 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']")));
		String s2 = ele.getAttribute("class");
		if(s2.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).getText();
		System.out.println(ev2);
		softly.assertThat(ev2).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Evidence entry place holder
		String ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-1"))).getAttribute("placeholder");
		System.out.println(ph2);
		softly.assertThat(ph2).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Click on 3.3.2 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//2nd collapsible for 3.3.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c4);
		softly.assertThat(c4).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.3.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c5);
		softly.assertThat(c5).as("test data").contains("培训计划是否从提高效率和提高质量两个方面考虑？");
		//Click on 2nd collapsible for 3.3.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.3.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c11);
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.3.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c6);
		softly.assertThat(c6).as("test data").contains("成立培训计划委员会");
		//Click on 3rd collapsible for 3.3.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.3.3 question
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(q343);
		softly.assertThat(q343).as("test data").contains("[3.3.3] 经理团队问责制不到位");
		//Click on 3.3.3 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']")));
		String s3 = ele.getAttribute("class");
		if(s3.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).getText();
		System.out.println(ev3);
		softly.assertThat(ev3).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Evidence entry place holder
		String ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-2"))).getAttribute("placeholder");
		System.out.println(ph3);
		softly.assertThat(ph3).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Click on 3.3.3 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//2nd collapsible for 3.3.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c7);
		softly.assertThat(c7).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.3.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c8);
		softly.assertThat(c8).as("test data").contains("PM&T是否充分？");
		String c36 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c36);
		softly.assertThat(c36).as("test data").contains("JO是否充分？");
		String c37 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();
		System.out.println(c37);
		softly.assertThat(c37).as("test data").contains("RCA是否充分？");
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[4]"))).getText();
		System.out.println(c22);
		softly.assertThat(c22).as("test data").contains("ORRA是否充分？");
		//Click on 2nd collapsible for 3.3.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.3.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c12);
		softly.assertThat(c12).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.3.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c9);
		softly.assertThat(c9).as("test data").contains("完善问责制");
		//Click on 3rd collapsible for 3.3.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.3.4 question
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		System.out.println(q344);
		softly.assertThat(q344).as("test data").contains("[3.3.4] 经理团队对确定工作优先级和计划方面不到位");
		//Click on 3.3.4 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']")));
		String s4 = ele.getAttribute("class");
		if(s4.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).getText();
		System.out.println(ev4);
		softly.assertThat(ev4).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Evidence entry place holder
		String ph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-3"))).getAttribute("placeholder");
		System.out.println(ph4);
		softly.assertThat(ph4).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Click on 3.3.4 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		//2nd collapsible for 3.3.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c13);
		softly.assertThat(c13).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.3.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c14);
		softly.assertThat(c14).as("test data").contains("工作流程中没有包括工作优先级的确定？");
		String c38 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c38);
		softly.assertThat(c38).as("test data").contains("优先级确定标准在时间、范围（质量）和成本三个方面没有平衡好？");
		//Click on 2nd collapsible for 3.3.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.3.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c16);
		softly.assertThat(c16).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.3.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c17);
		softly.assertThat(c17).as("test data").contains("完善管理优先级确定和计划体系？");
		//Click on 3rd collapsible for 3.3.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.3.5 question
		String q345 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		System.out.println(q345);
		softly.assertThat(q345).as("test data").contains("[3.3.5] 经理管理人员对以下标准制定不充分：(1) 行为规范 (2) 程序和屏障");
		//Click on 3.3.5 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']")));
		String s5 = ele.getAttribute("class");
		if(s5.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).getText();
		System.out.println(ev5);
		softly.assertThat(ev5).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Evidence entry place holder
		String ph5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-4"))).getAttribute("placeholder");
		System.out.println(ph5);
		softly.assertThat(ph5).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Click on 3.3.5 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		//2nd collapsible for 3.3.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c18);
		softly.assertThat(c18).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.3.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c19);
		softly.assertThat(c19).as("test data").contains("自我分析（自评）？");
		String c23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c23);
		softly.assertThat(c23).as("test data").contains("与表现优秀者对标？");
		//Click on 2nd collapsible for 3.3.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.3.5
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c20);
		softly.assertThat(c20).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.3.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c21);
		softly.assertThat(c21).as("test data").contains("开展关于标准设定的管理培训");
		String c24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c24);
		softly.assertThat(c24).as("test data").contains("开展关于程序和保护屏障设计的培训");
		//Click on 3rd collapsible for 3.3.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Scroll to the end
		Thread.sleep(2000);
		jse.executeScript("scroll(0,1300)");
		Thread.sleep(2000);
		//3.3.6 question
		String q396 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).getText();
		System.out.println(q396);
		softly.assertThat(q396).as("test data").contains("[3.3.6] 经理团队绩效跟踪与趋势分析不到位");
		//Click on 3.3.6 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']")));
		String s6 = ele.getAttribute("class");
		if(s6.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).getText();
		System.out.println(ev6);
		softly.assertThat(ev6).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).click();
		//Evidence entry place holder
		String ph6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-5"))).getAttribute("placeholder");
		System.out.println(ph6);
		softly.assertThat(ph6).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).click();
		//Click on 3.3.6 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).click();
		//2nd collapsible for 3.3.6
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c15);
		softly.assertThat(c15).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.3.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c28);
		softly.assertThat(c28).as("test data").contains("KPI不充分？");
		String c40 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c40);
		softly.assertThat(c40).as("test data").contains("没有定期开展共因分析？");
		String c25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();
		System.out.println(c25);
		softly.assertThat(c25).as("test data").contains("未对类似事件或失误进行趋势分析？");
		//Click on 2nd collapsible for 3.3.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.3.6
		String c30 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c30);
		softly.assertThat(c30).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.3.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c31 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c31);
		softly.assertThat(c31).as("test data").contains("定期开展共因分析");
		String c32 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c32);
		softly.assertThat(c32).as("test data").contains("改善绩效跟踪与趋势分析项目");
		String c27 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[3]"))).getText();
		System.out.println(c27);
		softly.assertThat(c27).as("test data").contains("完善KPI");
		//Click on 3rd collapsible for 3.3.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.3.7 question
		String q367 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']"))).getText();
		System.out.println(q367);
		softly.assertThat(q367).as("test data").contains("[3.3.7] 经理团队内未充分建立关于团队合作的共同目标、共同利益和共同责任");
		//Click on 3.3.7 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']")));
		String s7 = ele.getAttribute("class");
		if(s7.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-6']/h4/a"))).getText();
		System.out.println(ev7);
		softly.assertThat(ev7).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-6']/h4/a"))).click();
		//Evidence entry place holder
		String ph7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-6"))).getAttribute("placeholder");
		System.out.println(ph7);
		softly.assertThat(ph7).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-6']/h4/a"))).click();
		//Click on 3.3.7 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']"))).click();
		//2nd collapsible for 3.3.7
		String c41 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c41);
		softly.assertThat(c41).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.3.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c42 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c42);
		softly.assertThat(c42).as("test data").contains("经理之间的接口问题？");
		String c43 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c43);
		softly.assertThat(c43).as("test data").contains("主管或经理之间存在不和？");
		String c29 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();
		System.out.println(c29);
		softly.assertThat(c29).as("test data").contains("因两个管理团队之间接口问题，导致工作没有做？");
		//Click on 2nd collapsible for 3.3.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.3.7
		String c44 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c44);
		softly.assertThat(c44).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.3.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c45 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c45);
		softly.assertThat(c45).as("test data").contains("开展组织设计方面的管理培训");
		String c34 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c34);
		softly.assertThat(c34).as("test data").contains("在经理人员之间建立共同目标、共同利益和共同责任");
		//Click on 3rd collapsible for 3.3.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.3.8 question
		String q368 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-7']"))).getText();
		System.out.println(q368);
		softly.assertThat(q368).as("test data").contains("[3.3.8] 经理团队纠正行动不足");
		//Click on 3.3.8 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-7']")));
		String s8 = ele.getAttribute("class");
		if(s8.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-7']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-7']/h4/a"))).getText();
		System.out.println(ev8);
		softly.assertThat(ev8).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-7']/h4/a"))).click();
		//Evidence entry place holder
		String ph8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-7"))).getAttribute("placeholder");
		System.out.println(ph8);
		softly.assertThat(ph8).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-7']/h4/a"))).click();
		//Click on 3.3.8 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-7']"))).click();
		//2nd collapsible for 3.3.8
		String c46 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c46);
		softly.assertThat(c46).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.3.8
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c47 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c47);
		softly.assertThat(c47).as("test data").contains("根本原因分析不足导致事件重发？");
		String c48 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c48);
		softly.assertThat(c48).as("test data").contains("没有注意到关键的在变化的问题导致未能解决紧急问题？");
		String c35 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();
		System.out.println(c35);
		softly.assertThat(c35).as("test data").contains("纠正行动制定过多导致大量纠正行动仍然积压？");
		//Click on 2nd collapsible for 3.3.8
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.3.8
		String c49 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c49);
		softly.assertThat(c49).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.3.8
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c50 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c50);
		softly.assertThat(c50).as("test data").contains("提高纠正行动计划的落实");
		String c39 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c39);
		softly.assertThat(c39).as("test data").contains("改善根本原因分析方法");
		String c56 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/div/ul/li[3]"))).getText();
		System.out.println(c56);
		softly.assertThat(c56).as("test data").contains("完善突发紧急问题（危机）管理机制");
		//Click on 3rd collapsible for 3.3.8
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.3.9 question
		String q369 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-8']"))).getText();
		System.out.println(q369);
		softly.assertThat(q369).as("test data").contains("[3.3.9] 经理团队垂直沟通体系不完善");
		//Click on 3.3.9 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-8']")));
		String s9 = ele.getAttribute("class");
		if(s9.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-8']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-8']/h4/a"))).getText();
		System.out.println(ev9);
		softly.assertThat(ev9).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-8']/h4/a"))).click();
		//Evidence entry place holder
		String ph9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-8"))).getAttribute("placeholder");
		System.out.println(ph9);
		softly.assertThat(ph9).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-8']/h4/a"))).click();
		//Click on 3.3.9 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-8']"))).click();
		//2nd collapsible for 3.3.9
		String c51 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c51);
		softly.assertThat(c51).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.3.9
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c52 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c52);
		softly.assertThat(c52).as("test data").contains("方针培训？");
		String c53 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c53);
		softly.assertThat(c53).as("test data").contains("对员工的管理指导？");
		String c57 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();
		System.out.println(c57);
		softly.assertThat(c57).as("test data").contains("传达给员工的工作指令不充分？");
		String c58 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/div/ul/li[4]"))).getText();
		System.out.println(c58);
		softly.assertThat(c58).as("test data").contains("是否定期召开员工会议？");
		//Click on 2nd collapsible for 3.3.9
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.3.9
		String c54 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c54);
		softly.assertThat(c54).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.3.9
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c55 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c55);
		softly.assertThat(c55).as("test data").contains("完善垂直沟通体系");
		//Click on 3rd collapsible for 3.6.9
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.3.10 question
		String q3310 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-9']"))).getText();
		System.out.println(q3310);
		softly.assertThat(q3310).as("test data").contains("[3.3.10] 经理团队横向沟通体系不完善");
		//Click on 3.3.10 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-9']")));
		String s10 = ele.getAttribute("class");
		if(s10.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-9']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-9']/h4/a"))).getText();
		System.out.println(ev10);
		softly.assertThat(ev10).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-9']/h4/a"))).click();
		//Evidence entry place holder
		String ph10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-9"))).getAttribute("placeholder");
		System.out.println(ph10);
		softly.assertThat(ph10).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-9']/h4/a"))).click();
		//Click on 3.3.10 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-9']"))).click();
		Thread.sleep(1000);
		//2nd collapsible for 3.3.10
		String c59 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c59);
		softly.assertThat(c59).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.3.10
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c60 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c60);
		softly.assertThat(c60).as("test data").contains("共同目标和共同利益不充分？");
		String c61 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c61);
		softly.assertThat(c61).as("test data").contains("程序设计不当？");
		//Click on 2nd collapsible for 3.3.10
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.3.10
		String c62 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c62);
		softly.assertThat(c62).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.3.10
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c63 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c63);
		softly.assertThat(c63).as("test data").contains("完善程序设计");
		String c64 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c64);
		softly.assertThat(c64).as("test data").contains("制定共同目标和共同利益");
		//Click on 3rd collapsible for 3.3.10
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Add new contributing factor button
		String c33 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-button"))).getText();
		System.out.println(c33);
		softly.assertThat(c33).as("test data").contains("新增促成因素");
		//Verify Add Contributing factor
		chineseAddContributingFactor(driver);
		//Scroll to the top
		Thread.sleep(2000);
		jse.executeScript("scroll(0,0)");
		Thread.sleep(2000);
	}
	
	public void chineseStepOneq117 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.17 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(q11);
		softly.assertThat(q11).as("test data").contains("[1.17] 事件是与经理管理不当有关？");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();
		System.out.println(reason);
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("这个问题探讨了失误受管理效力影响的可能性；相关影响要素包括设定组织标准、绩效问责机制等。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(ans1);
		softly.assertThat(ans1).as("test data").contains("有");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(ans2);
		softly.assertThat(ans2).as("test data").contains("没有");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(ans3);
		softly.assertThat(ans3).as("test data").contains("未知");
	}
	
	public void chineseStepOneq116 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.16 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(q11);
		softly.assertThat(q11).as("test data").contains("[1.16] 事件是与组长监督管理不当有关？");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();
		System.out.println(reason);
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("这个问题探讨了失误受监管效力影响的可能性；相关影响要素包括行为标准的强化、绩效反馈、与现场员工交流、指导计划等。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(ans1);
		softly.assertThat(ans1).as("test data").contains("是，跟其他组长相比下有缺失");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(ans2);
		softly.assertThat(ans2).as("test data").contains("没有");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(ans3);
		softly.assertThat(ans3).as("test data").contains("未知");
	}
	
	public void chineseStepOneL36 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("全面性不足");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		System.out.println(textD);
		softly.assertThat(textD).as("test data").contains("若不适用点选skip略过。使用者可于底部新增促成因素。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("该失误的促成原因是否为制度、程序、等规范缺少要求、运行工况、假设、范围、试验/测量和缺少章节或部分。全面性不足查看程序设计是否涵盖所有要求、工况、假设和工作范围。如果是由于程序中缺少既定指导或者遗漏必要功能/步骤而造成困惑，从而导致发生失误，那么全面性方面非常可能存在不足。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.6.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(q341);
		softly.assertThat(q341).as("test data").contains("[3.6.1] 要求有遗漏");
		//Click on 3.6.1 to reveal evidence entry
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']")));
		String s1 = ele.getAttribute("class");
		if(s1.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).getText();
		System.out.println(ev1);
		softly.assertThat(ev1).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Evidence entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-0"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Click on 3.6.1 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//2nd collapsible for 3.6.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c1);
		softly.assertThat(c1).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.6.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c2);
		softly.assertThat(c2).as("test data").contains("规范和标准？");
		String c26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c26);
		softly.assertThat(c26).as("test data").contains("规范和标准？");
		String c29 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();
		System.out.println(c29);
		softly.assertThat(c29).as("test data").contains("与其他项目之间的接口要求？");
		//Click on 2nd collapsible for 3.6.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.6.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c10);
		softly.assertThat(c10).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.6.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c3);
		softly.assertThat(c3).as("test data").contains("完善规则");
		String c27 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c27);
		softly.assertThat(c27).as("test data").contains("开展程序设计方面的培训");
		//Click on 3rd collapsible for 3.6.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.6.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(q342);
		softly.assertThat(q342).as("test data").contains("[3.6.2] 运行条件有遗漏");
		//Click on 3.6.2 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']")));
		String s2 = ele.getAttribute("class");
		if(s2.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).getText();
		System.out.println(ev2);
		softly.assertThat(ev2).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Evidence entry place holder
		String ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-1"))).getAttribute("placeholder");
		System.out.println(ph2);
		softly.assertThat(ph2).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Click on 3.6.2 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//2nd collapsible for 3.6.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c4);
		softly.assertThat(c4).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.6.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c5);
		softly.assertThat(c5).as("test data").contains("规则适用的运行条件范围？");
		String c34 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c34);
		softly.assertThat(c34).as("test data").contains("进入规则的前提条件？");
		String c35 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();
		System.out.println(c35);
		softly.assertThat(c35).as("test data").contains("退出规则的条件？");
		//Click on 2nd collapsible for 3.6.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.6.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c11);
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.6.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c6);
		softly.assertThat(c6).as("test data").contains("完善规则");
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c22);
		softly.assertThat(c22).as("test data").contains("开展程序设计方面的培训");
		//Click on 3rd collapsible for 3.6.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.6.3 question
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(q343);
		softly.assertThat(q343).as("test data").contains("[3.6.3] 假设有遗漏");
		//Click on 3.6.3 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']")));
		String s3 = ele.getAttribute("class");
		if(s3.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).getText();
		System.out.println(ev3);
		softly.assertThat(ev3).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Evidence entry place holder
		String ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-2"))).getAttribute("placeholder");
		System.out.println(ph3);
		softly.assertThat(ph3).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Click on 3.6.3 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//2nd collapsible for 3.6.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c7);
		softly.assertThat(c7).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.6.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c8);
		softly.assertThat(c8).as("test data").contains("假设未予以说明？");
		String c36 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c36);
		softly.assertThat(c36).as("test data").contains("未要求在任务完成前对假设进行验证？");
		String c37 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();
		System.out.println(c37);
		softly.assertThat(c37).as("test data").contains("对未经验证的假设没有制定缓解措施？");
		//Click on 2nd collapsible for 3.6.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.6.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c12);
		softly.assertThat(c12).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.6.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c9);
		softly.assertThat(c9).as("test data").contains("完善规则");
		String c23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c23);
		softly.assertThat(c23).as("test data").contains("开展程序设计方面的培训");
		//Click on 3rd collapsible for 3.6.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.6.4 question
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		System.out.println(q344);
		softly.assertThat(q344).as("test data").contains("[3.6.4] 范围有遗漏");
		//Click on 3.6.4 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']")));
		String s4 = ele.getAttribute("class");
		if(s4.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).getText();
		System.out.println(ev4);
		softly.assertThat(ev4).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Evidence entry place holder
		String ph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-3"))).getAttribute("placeholder");
		System.out.println(ph4);
		softly.assertThat(ph4).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Click on 3.6.4 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		//2nd collapsible for 3.6.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c13);
		softly.assertThat(c13).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.6.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c14);
		softly.assertThat(c14).as("test data").contains("使用通用规则，缺少针对各种特殊情况的具体描述？");
		String c38 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c38);
		softly.assertThat(c38).as("test data").contains("步骤遗漏？");
		String c39 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();
		System.out.println(c39);
		softly.assertThat(c39).as("test data").contains("遗漏了碰到异常情况时需采取的行动？");
		//Click on 2nd collapsible for 3.6.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.6.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c16);
		softly.assertThat(c16).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.6.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c17);
		softly.assertThat(c17).as("test data").contains("完善规则");
		String c25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c25);
		softly.assertThat(c25).as("test data").contains("开展程序设计方面的培训");
		//Click on 3rd collapsible for 3.6.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.6.5 question
		String q345 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		System.out.println(q345);
		softly.assertThat(q345).as("test data").contains("[3.6.5] 试验或测量有遗漏");
		//Click on 3.6.5 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']")));
		String s5 = ele.getAttribute("class");
		if(s5.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).getText();
		System.out.println(ev5);
		softly.assertThat(ev5).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Evidence entry place holder
		String ph5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-4"))).getAttribute("placeholder");
		System.out.println(ph5);
		softly.assertThat(ph5).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Click on 3.6.5 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		//2nd collapsible for 3.6.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c18);
		softly.assertThat(c18).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.6.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c19);
		softly.assertThat(c19).as("test data").contains("遗漏了用于验收是否正确执行的相关试验或测量？");
		//Click on 2nd collapsible for 3.6.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.6.5
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c20);
		softly.assertThat(c20).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.6.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c21);
		softly.assertThat(c21).as("test data").contains("完善规则");
		String c24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c24);
		softly.assertThat(c24).as("test data").contains("开展程序设计方面的培训");
		//Click on 3rd collapsible for 3.6.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Scroll to the end
		Thread.sleep(2000);
		jse.executeScript("scroll(0,1200)");
		Thread.sleep(2000);
		//3.6.6 question
		String q396 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).getText();
		System.out.println(q396);
		softly.assertThat(q396).as("test data").contains("[3.6.6] 遗漏以下信息: (1) 目的; (2) 先决条件; (3) 定义; (4) 经验反馈用");
		softly.assertThat(q396).as("test data").contains("不准做清单");
		softly.assertThat(q396).as("test data").contains("体现; (5) 参考资料; (6) 要求使用者反馈");
		//Click on 3.6.6 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']")));
		String s6 = ele.getAttribute("class");
		if(s6.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).getText();
		System.out.println(ev6);
		softly.assertThat(ev6).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).click();
		//Evidence entry place holder
		String ph6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-5"))).getAttribute("placeholder");
		System.out.println(ph6);
		softly.assertThat(ph6).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).click();
		//Click on 3.6.6 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).click();
		//2nd collapsible for 3.6.6
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c15);
		softly.assertThat(c15).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.6.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c28);
		softly.assertThat(c28).as("test data").contains("调查程序编写者");
		String c40 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c40);
		softly.assertThat(c40).as("test data").contains("调查程序设计编写培训");
		//Click on 2nd collapsible for 3.6.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.6.6
		String c30 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c30);
		softly.assertThat(c30).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.6.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c31 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c31);
		softly.assertThat(c31).as("test data").contains("开展程序设计编写培训");
		String c32 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c32);
		softly.assertThat(c32).as("test data").contains("改善程序编写导则");
		//Click on 3rd collapsible for 3.6.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.6.7 question
		String q367 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']"))).getText();
		System.out.println(q367);
		softly.assertThat(q367).as("test data").contains("[3.6.7] 审查不到位导致制度有遗漏项");
		//Click on 3.6.7 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']")));
		String s7 = ele.getAttribute("class");
		if(s7.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-6']/h4/a"))).getText();
		System.out.println(ev7);
		softly.assertThat(ev7).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-6']/h4/a"))).click();
		//Evidence entry place holder
		String ph7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-6"))).getAttribute("placeholder");
		System.out.println(ph7);
		softly.assertThat(ph7).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-6']/h4/a"))).click();
		//Click on 3.6.7 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']"))).click();
		//2nd collapsible for 3.6.7
		String c41 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c41);
		softly.assertThat(c41).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.6.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c42 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c42);
		softly.assertThat(c42).as("test data").contains("调查程序审查者");
		String c43 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c43);
		softly.assertThat(c43).as("test data").contains("调查程序审查培训");
		//Click on 2nd collapsible for 3.6.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.6.7
		String c44 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c44);
		softly.assertThat(c44).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.6.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c45 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c45);
		softly.assertThat(c45).as("test data").contains("开展程序审查培训");
		//Click on 3rd collapsible for 3.6.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.6.8 question
		String q368 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-7']"))).getText();
		System.out.println(q368);
		softly.assertThat(q368).as("test data").contains("[3.6.8] 根本原因分析不到位导致制度有遗漏项");
		//Click on 3.6.8 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-7']")));
		String s8 = ele.getAttribute("class");
		if(s8.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-7']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-7']/h4/a"))).getText();
		System.out.println(ev8);
		softly.assertThat(ev8).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-7']/h4/a"))).click();
		//Evidence entry place holder
		String ph8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-7"))).getAttribute("placeholder");
		System.out.println(ph8);
		softly.assertThat(ph8).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-7']/h4/a"))).click();
		//Click on 3.6.8 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-7']"))).click();
		//2nd collapsible for 3.6.8
		String c46 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c46);
		softly.assertThat(c46).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.6.8
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c47 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c47);
		softly.assertThat(c47).as("test data").contains("调查事件调查者");
		String c48 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c48);
		softly.assertThat(c48).as("test data").contains("调查事件根本原因培训");
		//Click on 2nd collapsible for 3.6.8
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.6.8
		String c49 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c49);
		softly.assertThat(c49).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.6.8
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c50 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c50);
		softly.assertThat(c50).as("test data").contains("开展根本原因培训");
		//Click on 3rd collapsible for 3.6.8
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.6.9 question
		String q369 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-8']"))).getText();
		System.out.println(q369);
		softly.assertThat(q369).as("test data").contains("[3.6.9] 纠正措施执行不到位导致制度有遗漏项");
		//Click on 3.6.9 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-8']")));
		String s9 = ele.getAttribute("class");
		if(s9.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-8']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-8']/h4/a"))).getText();
		System.out.println(ev9);
		softly.assertThat(ev9).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-8']/h4/a"))).click();
		//Evidence entry place holder
		String ph9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-8"))).getAttribute("placeholder");
		System.out.println(ph9);
		softly.assertThat(ph9).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-8']/h4/a"))).click();
		//Click on 3.6.9 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-8']"))).click();
		//2nd collapsible for 3.6.9
		String c51 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c51);
		softly.assertThat(c51).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.6.9
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c52 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c52);
		softly.assertThat(c52).as("test data").contains("调查纠正措施主管");
		String c53 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c53);
		softly.assertThat(c53).as("test data").contains("调查纠正措施制度缺陷");
		//Click on 2nd collapsible for 3.6.9
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.6.9
		String c54 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c54);
		softly.assertThat(c54).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.6.9
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c55 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c55);
		softly.assertThat(c55).as("test data").contains("改善纠正措施制度的监督与执行");
		//Click on 3rd collapsible for 3.6.9
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Add new contributing factor button
		String c33 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-button"))).getText();
		System.out.println(c33);
		softly.assertThat(c33).as("test data").contains("新增促成因素");
		//Verify Add Contributing factor
		chineseAddContributingFactor(driver);
		//Scroll to the top
		Thread.sleep(2000);
		jse.executeScript("scroll(0,0)");
		Thread.sleep(2000);
	}
	
	public void chineseStepOneq115 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.15 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(q11);
		softly.assertThat(q11).as("test data").contains("[1.15] 始发事件是否有单项弱点？");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();
		System.out.println(reason);
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("单项弱点（SPV）是指一个失效或执行不正确的程序步骤、行动、工具或一个设备引起后果事件或导致整个过程失效。此外，SPV是不会自我披露的，直至其导致最终故障发生才披露");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(ans1);
		softly.assertThat(ans1).as("test data").contains("有，但未提前识别");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(ans2);
		softly.assertThat(ans2).as("test data").contains("有，识别出单项弱点但未缓解");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(ans3);
		softly.assertThat(ans3).as("test data").contains("没有");
	}
	
	public void chineseStepOneq114 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.14 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(q11);
		softly.assertThat(q11).as("test data").contains("[1.14] 组长是否固定开展经验反馈？");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();
		System.out.println(reason);
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("这个问题探讨是否在日常经验反馈学习时上强调类似任务相关的风险与常见失误。经验教训学习会有两个目标：（1）学习如何预防类似事件；（2）主管强化标准要求");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(ans1);
		softly.assertThat(ans1).as("test data").contains("没有，但其他组长有");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(ans2);
		softly.assertThat(ans2).as("test data").contains("没有，这为常态");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(ans3);
		softly.assertThat(ans3).as("test data").contains("有");
	}
	
	public void chineseStepOneq113 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.13 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(q11);
		softly.assertThat(q11).as("test data").contains("[1.13] 错误的发生是否存在易出错精神状态或是高风险状态？");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();
		System.out.println(reason);
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("这个问题检查易出错精神状态或高风险状态是否被识别出。我们的研究表明存在16个易出错精神状态和16个高风险状态，它们会显著增加失误率（参见");
		softly.assertThat(desc).as("test data").contains("关于");
		softly.assertThat(desc).as("test data").contains("部分）。70%的失误是由于易出错精神状态推动产生的，不存在任何外部因素（例如：恶劣的工作条件、工作指令不当）。大约有30%的间接失误是由于异常、外部影响促成的，也就是我们熟知的高风险状态。高风险表示事件发生概率或后果方面的风险增加。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(ans1);
		softly.assertThat(ans1).as("test data").contains("没有，请重新思考您的答案");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(ans2);
		softly.assertThat(ans2).as("test data").contains("有");
	}
	
	public void chineseStepOneq112 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.12 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(q11);
		softly.assertThat(q11).as("test data").contains("[1.12] 若班前会、工前会或交底会未执行，为什么？");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();
		System.out.println(reason);
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("执行任务前，若执行班前会、工前会或交底会以可以提前识别和缓解风险。不执行若班前会、工前会或交底会将促进失误的发生。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(ans1);
		softly.assertThat(ans1).as("test data").contains("违反程序规定未执行");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(ans2);
		softly.assertThat(ans2).as("test data").contains("不当的程序要求而未执行");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(ans3);
		softly.assertThat(ans3).as("test data").contains("没有要求执行所以未执行");
	}
	
	public void chineseStepOneq111 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.11 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(q11);
		softly.assertThat(q11).as("test data").contains("[1.11] 这个错为何是现在发生而不是以前发生？");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();
		System.out.println(reason);
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("这个问题探讨了为什么这个失误在之前有没有发生过？");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(ans1);
		softly.assertThat(ans1).as("test data").contains("新程序的使用未有妥当培训");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(ans2);
		softly.assertThat(ans2).as("test data").contains("对于犯错人员而言是新任务或是不熟悉的任务");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(ans3);
		softly.assertThat(ans3).as("test data").contains("过去有发生过类似错误");
	}
	
	public void chineseStepOneq110 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.10 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(q11);
		softly.assertThat(q11).as("test data").contains("[1.10] 若有开班前会、工前会、交底会，为何犯错者未能意识到这个风险且缓解？");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();
		System.out.println(reason);
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("这个问题探讨了开班前会、工前会、交底会在风险识别和缓解方面的效力");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(ans1);
		softly.assertThat(ans1).as("test data").contains("没有专心参与");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(ans2);
		softly.assertThat(ans2).as("test data").contains("因技能不足未讨论这个风险");
	}
	
	public void chineseStepOneL32 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("组长主管层面");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		System.out.println(textD);
		softly.assertThat(textD).as("test data").contains("若不适用点选skip略过。使用者可于底部新增促成因素。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("这些促成因素归因于主管，因为这关系到影响个人和组织绩效的失误。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.2.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(q341);
		softly.assertThat(q341).as("test data").contains("[3.2.1] 组长强化标准方面的管理能力不足");
		//Click on 3.2.1 to reveal evidence entry
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']")));
		String s1 = ele.getAttribute("class");
		if(s1.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).getText();
		System.out.println(ev1);
		softly.assertThat(ev1).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Evidence entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-0"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Click on 3.2.1 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//2nd collapsible for 3.2.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c1);
		softly.assertThat(c1).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.2.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c2);
		softly.assertThat(c2).as("test data").contains("访谈同事？");
		//Click on 2nd collapsible for 3.2.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.2.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c10);
		softly.assertThat(c10).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.2.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c3);
		softly.assertThat(c3).as("test data").contains("监督管理方面的培训");
		String c27 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c27);
		softly.assertThat(c27).as("test data").contains("监督行为规范的管理");
		//Click on 3rd collapsible for 3.2.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.2.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(q342);
		softly.assertThat(q342).as("test data").contains("[3.2.2] 组长绩效反馈方面的管理能力不足");
		//Click on 3.2.2 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']")));
		String s2 = ele.getAttribute("class");
		if(s2.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).getText();
		System.out.println(ev2);
		softly.assertThat(ev2).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Evidence entry place holder
		String ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-1"))).getAttribute("placeholder");
		System.out.println(ph2);
		softly.assertThat(ph2).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Click on 3.2.2 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//2nd collapsible for 3.2.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c4);
		softly.assertThat(c4).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.2.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c5);
		softly.assertThat(c5).as("test data").contains("访谈同事？");
		//Click on 2nd collapsible for 3.2.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.2.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c11);
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.2.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c6);
		softly.assertThat(c6).as("test data").contains("监督管理方面的培训");
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c22);
		softly.assertThat(c22).as("test data").contains("监督行为规范的管理");
		//Click on 3rd collapsible for 3.2.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.2.3 question
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(q343);
		softly.assertThat(q343).as("test data").contains("[3.2.3] 组长召开经验反馈的管理技能不足");
		//Click on 3.2.3 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']")));
		String s3 = ele.getAttribute("class");
		if(s3.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).getText();
		System.out.println(ev3);
		softly.assertThat(ev3).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Evidence entry place holder
		String ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-2"))).getAttribute("placeholder");
		System.out.println(ph3);
		softly.assertThat(ph3).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Click on 3.2.3 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//2nd collapsible for 3.2.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c7);
		softly.assertThat(c7).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.2.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c8);
		softly.assertThat(c8).as("test data").contains("访谈同事？");
		//Click on 2nd collapsible for 3.2.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.2.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c12);
		softly.assertThat(c12).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.2.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c9);
		softly.assertThat(c9).as("test data").contains("监督管理方面的培训");
		String c23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c23);
		softly.assertThat(c23).as("test data").contains("监督行为规范的管理");
		//Click on 3rd collapsible for 3.2.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.2.4 question
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		System.out.println(q344);
		softly.assertThat(q344).as("test data").contains("[3.2.4] 组长在岗培训方面管理能力不足");
		//Click on 3.2.4 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']")));
		String s4 = ele.getAttribute("class");
		if(s4.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).getText();
		System.out.println(ev4);
		softly.assertThat(ev4).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Evidence entry place holder
		String ph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-3"))).getAttribute("placeholder");
		System.out.println(ph4);
		softly.assertThat(ph4).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Click on 3.2.4 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		//2nd collapsible for 3.2.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c13);
		softly.assertThat(c13).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.2.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c14);
		softly.assertThat(c14).as("test data").contains("访谈同事？");
		//Click on 2nd collapsible for 3.2.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.2.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c16);
		softly.assertThat(c16).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.2.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c17);
		softly.assertThat(c17).as("test data").contains("监督管理方面的培训");
		String c25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c25);
		softly.assertThat(c25).as("test data").contains("监督行为规范的管理");
		//Click on 3rd collapsible for 3.2.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.2.5 question
		String q345 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		System.out.println(q345);
		softly.assertThat(q345).as("test data").contains("[3.2.5] 组长对团队缺点认识不足，缺乏相应弥补措施");
		//Click on 3.2.5 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']")));
		String s5 = ele.getAttribute("class");
		if(s5.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).getText();
		System.out.println(ev5);
		softly.assertThat(ev5).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Evidence entry place holder
		String ph5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-4"))).getAttribute("placeholder");
		System.out.println(ph5);
		softly.assertThat(ph5).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Click on 3.2.5 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		//2nd collapsible for 3.2.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c18);
		softly.assertThat(c18).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.2.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c19);
		softly.assertThat(c19).as("test data").contains("访谈同事？");
		//Click on 2nd collapsible for 3.2.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.2.5
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c20);
		softly.assertThat(c20).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.2.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c21);
		softly.assertThat(c21).as("test data").contains("监督管理方面的培训");
		String c24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c24);
		softly.assertThat(c24).as("test data").contains("监督行为规范的管理");
		//Click on 3rd collapsible for 3.2.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		Thread.sleep(2000);
		jse.executeScript("scroll(0,1200)");
		Thread.sleep(2000);
		//3.2.6 question
		String q396 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).getText();
		System.out.println(q396);
		softly.assertThat(q396).as("test data").contains("[3.2.6] 组长发出指令和后续贯彻的沟通及协调能力不足");
		//Click on 3.2.6 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']")));
		String s6 = ele.getAttribute("class");
		if(s6.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).getText();
		System.out.println(ev6);
		softly.assertThat(ev6).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).click();
		//Evidence entry place holder
		String ph6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-5"))).getAttribute("placeholder");
		System.out.println(ph6);
		softly.assertThat(ph6).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).click();
		//Click on 3.2.6 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).click();
		//2nd collapsible for 3.2.6
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c15);
		softly.assertThat(c15).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.2.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c28);
		softly.assertThat(c28).as("test data").contains("访谈下属？");
		//Click on 2nd collapsible for 3.2.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.2.6
		String c30 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c30);
		softly.assertThat(c30).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.2.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c31 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c31);
		softly.assertThat(c31).as("test data").contains("监督管理方面的培训");
		String c32 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c32);
		softly.assertThat(c32).as("test data").contains("监督行为规范的管理");
		//Click on 3rd collapsible for 3.2.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Add new contributing factor button
		String c33 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-button"))).getText();
		System.out.println(c33);
		softly.assertThat(c33).as("test data").contains("新增促成因素");
		//Verify Add Contributing factor
		chineseAddContributingFactor(driver);
		Thread.sleep(2000);
		jse.executeScript("scroll(0,0)");
		Thread.sleep(2000);
	}
	
	public void chineseStepOneq19 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.9 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(q11);
		softly.assertThat(q11).as("test data").contains("[1.9] 犯错者在事后是否有经组长或管理层问责？");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();
		System.out.println(reason);
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("这个问题探讨了现有的问责机制。如果出现失误，无论是无意或有意的，都可从中学习到经验教训。问责机制不表示要接受惩罚，而是针对失误负责任。如果主管或管理层没有与犯错人员交谈，且没有完成全面调查，那么说明问责机制存在问题。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(ans1);
		softly.assertThat(ans1).as("test data").contains("没有");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(ans2);
		softly.assertThat(ans2).as("test data").contains("有");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(ans3);
		softly.assertThat(ans3).as("test data").contains("未知");
	}
	
	public void chineseStepOneL311 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("工作问责");
		softly.assertThat(heading).as("test data").contains("不充分");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		System.out.println(textD);
		softly.assertThat(textD).as("test data").contains("若不适用点选skip略过。使用者可于底部新增促成因素。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("问责机制系指业主对制度绩效负责的机制。缺乏问责机制是否是发生这种失误的促成因素？");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.11.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(q341);
		softly.assertThat(q341).as("test data").contains("[3.11.1] 绩效跟踪与趋势分析(PM&T)以及给员工的反馈不到位");
		//Click on 3.11.1 to reveal evidence entry
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']")));
		String s1 = ele.getAttribute("class");
		if(s1.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).getText();
		System.out.println(ev1);
		softly.assertThat(ev1).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Evidence entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-0"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Click on 3.11.1 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//2nd collapsible for 3.11.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c1);
		softly.assertThat(c1).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.11.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c2);
		softly.assertThat(c2).as("test data").contains("向员工反馈绩效趋势结果？");
		//Click on 2nd collapsible for 3.11.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.11.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c10);
		softly.assertThat(c10).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.11.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c3);
		softly.assertThat(c3).as("test data").contains("完善趋势分析体系");
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c22);
		softly.assertThat(c22).as("test data").contains("完善趋势反馈");
		//Click on 3rd collapsible for 3.11.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.11.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(q342);
		softly.assertThat(q342).as("test data").contains("[3.11.2] 即时反馈和持续强化(IF&CR)的管理技能不到位");
		//Click on 3.11.2 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']")));
		String s2 = ele.getAttribute("class");
		if(s2.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).getText();
		System.out.println(ev2);
		softly.assertThat(ev2).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Evidence entry place holder
		String ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-1"))).getAttribute("placeholder");
		System.out.println(ph2);
		softly.assertThat(ph2).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Click on 3.11.2 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//2nd collapsible for 3.11.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c4);
		softly.assertThat(c4).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.11.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c5);
		softly.assertThat(c5).as("test data").contains("花在现场观察和监督工作的时间是否足够？");
		String c23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c23);
		softly.assertThat(c23).as("test data").contains("标准的持续强化？");
		String c24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();
		System.out.println(c24);
		softly.assertThat(c24).as("test data").contains("观察到偏差时，是否及时反馈？");
		String c27 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[4]"))).getText();
		System.out.println(c27);
		softly.assertThat(c27).as("test data").contains("正面反馈多余负面反馈？");
		//Click on 2nd collapsible for 3.11.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.11.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c11);
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.11.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c6);
		softly.assertThat(c6).as("test data").contains("提高主管人员的问责意识");
		String c28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c28);
		softly.assertThat(c28).as("test data").contains("改善关于管理技能的培训");
		//Click on 3rd collapsible for 3.11.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.11.3 question
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(q343);
		softly.assertThat(q343).as("test data").contains("[3.11.3] 用于绩效控制的奖惩制度不到位");
		//Click on 3.11.3 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']")));
		String s3 = ele.getAttribute("class");
		if(s3.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).getText();
		System.out.println(ev3);
		softly.assertThat(ev3).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Evidence entry place holder
		String ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-2"))).getAttribute("placeholder");
		System.out.println(ph3);
		softly.assertThat(ph3).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Click on 3.11.3 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//2nd collapsible for 3.11.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c7);
		softly.assertThat(c7).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.11.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c8);
		softly.assertThat(c8).as("test data").contains("奖惩制度是否及时？");
		String c25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c25);
		softly.assertThat(c25).as("test data").contains("奖惩制度是否公平？");
		String c29 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();
		System.out.println(c29);
		softly.assertThat(c29).as("test data").contains("奖惩制度是否坚定？");
		//Click on 2nd collapsible for 3.11.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.11.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c12);
		softly.assertThat(c12).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.11.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		System.out.println(c9);
		softly.assertThat(c9).as("test data").contains("完善奖惩制度");
		//Click on 3rd collapsible for 3.11.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.11.4 question
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		System.out.println(q344);
		softly.assertThat(q344).as("test data").contains("[3.11.4] 问题报告、RCA和纠正行动不到位，给员工的反馈不到位");
		//Click on 3.11.4 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']")));
		String s4 = ele.getAttribute("class");
		if(s4.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).getText();
		System.out.println(ev4);
		softly.assertThat(ev4).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Evidence entry place holder
		String ph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-3"))).getAttribute("placeholder");
		System.out.println(ph4);
		softly.assertThat(ph4).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Click on 3.11.4 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		//2nd collapsible for 3.11.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c13);
		softly.assertThat(c13).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.11.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c14);
		softly.assertThat(c14).as("test data").contains("核实汇报分析的小事件数量比例以及受伤数量(<10)？");
		//Click on 2nd collapsible for 3.11.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.11.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c16);
		softly.assertThat(c16).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.11.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c17);
		softly.assertThat(c17).as("test data").contains("在问题报告政策中要求包含一切问题和及时性");
		String c26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c26);
		softly.assertThat(c26).as("test data").contains("RCA培训和授权");
		String c30 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[3]"))).getText();
		System.out.println(c30);
		softly.assertThat(c30).as("test data").contains("改善对RCA结果的反馈");
		//Click on 3rd collapsible for 3.11.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.11.5 question
		String q345 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		System.out.println(q345);
		softly.assertThat(q345).as("test data").contains("[3.11.5] 现场观察不充分，给员工的反馈不到位");
		//Click on 3.11.5 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']")));
		String s5 = ele.getAttribute("class");
		if(s5.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).getText();
		System.out.println(ev5);
		softly.assertThat(ev5).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Evidence entry place holder
		String ph5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-4"))).getAttribute("placeholder");
		System.out.println(ph5);
		softly.assertThat(ph5).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Click on 3.11.5 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		//2nd collapsible for 3.11.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c18);
		softly.assertThat(c18).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.11.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c19);
		softly.assertThat(c19).as("test data").contains("各部门均建立了现场观察指导制度？");
		String c31 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c31);
		softly.assertThat(c31).as("test data").contains("对过去现场观察指导结果的有效性审查？");
		String c32 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();
		System.out.println(c32);
		softly.assertThat(c32).as("test data").contains("花在现场观察指导上的时间？");
		//Click on 2nd collapsible for 3.11.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.11.5
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c20);
		softly.assertThat(c20).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.11.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c21);
		softly.assertThat(c21).as("test data").contains("针对现场观察结果，改善给员工的反馈");
		String c33 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c33);
		softly.assertThat(c33).as("test data").contains("改进现场观察员的制度和TQA");
		//Click on 3rd collapsible for 3.11.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Add new contributing factor button
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-button"))).getText();
		System.out.println(c15);
		softly.assertThat(c15).as("test data").contains("新增促成因素");
		//Verify Add Contributing factor
		chineseAddContributingFactor(driver);
	}
	
	public void chineseStepOneL310 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("资格授权");
		softly.assertThat(heading).as("test data").contains("不充分");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		System.out.println(textD);
		softly.assertThat(textD).as("test data").contains("若不适用点选skip略过。使用者可于底部新增促成因素。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("授权是对所学技能和影响安全或生产的关键工作能力的证明（如电厂操纵员、审查人员、经理等）");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.10.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(q341);
		softly.assertThat(q341).as("test data").contains("[3.10.1] 关键岗位员工的作业授权不充分");
		//Click on 3.10.1 to reveal evidence entry
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']")));
		String s1 = ele.getAttribute("class");
		if(s1.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).getText();
		System.out.println(ev1);
		softly.assertThat(ev1).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Evidence entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-0"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Click on 3.10.1 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//2nd collapsible for 3.10.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c1);
		softly.assertThat(c1).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.10.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c2);
		softly.assertThat(c2).as("test data").contains("授权政策和证书？");
		//Click on 2nd collapsible for 3.10.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.10.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c10);
		softly.assertThat(c10).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.10.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		System.out.println(c3);
		softly.assertThat(c3).as("test data").contains("完善作业授权");
		//Click on 3rd collapsible for 3.10.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.10.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(q342);
		softly.assertThat(q342).as("test data").contains("[3.10.2] 关键岗位主管和（或）经理授权不充分");
		//Click on 3.10.2 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']")));
		String s2 = ele.getAttribute("class");
		if(s2.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).getText();
		System.out.println(ev2);
		softly.assertThat(ev2).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Evidence entry place holder
		String ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-1"))).getAttribute("placeholder");
		System.out.println(ph2);
		softly.assertThat(ph2).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Click on 3.10.2 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//2nd collapsible for 3.10.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c4);
		softly.assertThat(c4).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.10.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c5);
		softly.assertThat(c5).as("test data").contains("授权政策和证书？");
		//Click on 2nd collapsible for 3.10.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.10.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c11);
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.10.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		System.out.println(c6);
		softly.assertThat(c6).as("test data").contains("完善主管和经理的岗位授权");
		//Click on 3rd collapsible for 3.10.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.10.3 question
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(q343);
		softly.assertThat(q343).as("test data").contains("[3.10.3] 供应商服务（QA/RC、来源检查）授权不充分");
		//Click on 3.10.3 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']")));
		String s3 = ele.getAttribute("class");
		if(s3.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).getText();
		System.out.println(ev3);
		softly.assertThat(ev3).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Evidence entry place holder
		String ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-2"))).getAttribute("placeholder");
		System.out.println(ph3);
		softly.assertThat(ph3).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Click on 3.10.3 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//2nd collapsible for 3.10.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c7);
		softly.assertThat(c7).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.10.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c8);
		softly.assertThat(c8).as("test data").contains("授权政策和证书？");
		//Click on 2nd collapsible for 3.10.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.10.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c12);
		softly.assertThat(c12).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.10.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		System.out.println(c9);
		softly.assertThat(c9).as("test data").contains("完善供应商控制制度");
		//Click on 3rd collapsible for 3.10.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.10.4 question
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		System.out.println(q344);
		softly.assertThat(q344).as("test data").contains("[3.10.4] 现场供应商人员授权不充分");
		//Click on 3.10.4 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']")));
		String s4 = ele.getAttribute("class");
		if(s4.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).getText();
		System.out.println(ev4);
		softly.assertThat(ev4).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Evidence entry place holder
		String ph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-3"))).getAttribute("placeholder");
		System.out.println(ph4);
		softly.assertThat(ph4).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Click on 3.10.4 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		//2nd collapsible for 3.10.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c13);
		softly.assertThat(c13).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.10.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c14);
		softly.assertThat(c14).as("test data").contains("授权政策和证书？");
		//Click on 2nd collapsible for 3.10.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.4.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c16);
		softly.assertThat(c16).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.10.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		System.out.println(c17);
		softly.assertThat(c17).as("test data").contains("完善供应商控制制度");
		//Click on 3rd collapsible for 3.10.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.10.5 question
		String q345 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		System.out.println(q345);
		softly.assertThat(q345).as("test data").contains("[3.10.5] 培训教员授权不充分");
		//Click on 3.10.5 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']")));
		String s5 = ele.getAttribute("class");
		if(s5.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).getText();
		System.out.println(ev5);
		softly.assertThat(ev5).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Evidence entry place holder
		String ph5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-4"))).getAttribute("placeholder");
		System.out.println(ph5);
		softly.assertThat(ph5).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Click on 3.10.5 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		//2nd collapsible for 3.10.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c18);
		softly.assertThat(c18).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.10.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c19);
		softly.assertThat(c19).as("test data").contains("授权政策和证书？");
		//Click on 2nd collapsible for 3.10.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.10.5
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c20);
		softly.assertThat(c20).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.10.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		System.out.println(c21);
		softly.assertThat(c21).as("test data").contains("完善有关培训教员资格授权的管理标准与方针");
		//Click on 3rd collapsible for 3.10.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Add new contributing factor button
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-button"))).getText();
		System.out.println(c22);
		softly.assertThat(c22).as("test data").contains("新增促成因素");
		//Verify Add Contributing factor
		chineseAddContributingFactor(driver);
	}
	
	public void chineseStepOneL39 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("培训");
		softly.assertThat(heading).as("test data").contains("不充分");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		System.out.println(textD);
		softly.assertThat(textD).as("test data").contains("若不适用点选skip略过。使用者可于底部新增促成因素。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("若培训不充分导致失误发生，需要探讨是培训范围和内容还是实际教学出问题。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.9.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(q341);
		softly.assertThat(q341).as("test data").contains("[3.9.1] 培训材料在适用性、及时性或实用性方面有所欠缺");
		//Click on 3.9.1 to reveal evidence entry
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']")));
		String s1 = ele.getAttribute("class");
		if(s1.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).getText();
		System.out.println(ev1);
		softly.assertThat(ev1).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Evidence entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-0"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Click on 3.9.1 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//2nd collapsible for 3.9.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c1);
		softly.assertThat(c1).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.9.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c2);
		softly.assertThat(c2).as("test data").contains("与类似组织对标？");
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c22);
		softly.assertThat(c22).as("test data").contains("通过现场观察审查培训效果？");
		//Click on 2nd collapsible for 3.9.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.9.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c10);
		softly.assertThat(c10).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.9.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c3);
		softly.assertThat(c3).as("test data").contains("加强培训资源");
		String c27 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c27);
		softly.assertThat(c27).as("test data").contains("开展作业任务分析，从而使培训材料、课程及时间与员工执行的任务相匹配");
		//Click on 3rd collapsible for 3.9.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.9.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(q342);
		softly.assertThat(q342).as("test data").contains("[3.9.2] 复训频率不高(>> 一年)");
		//Click on 3.9.2 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']")));
		String s2 = ele.getAttribute("class");
		if(s2.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).getText();
		System.out.println(ev2);
		softly.assertThat(ev2).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Evidence entry place holder
		String ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-1"))).getAttribute("placeholder");
		System.out.println(ph2);
		softly.assertThat(ph2).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Click on 3.9.2 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//2nd collapsible for 3.9.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c4);
		softly.assertThat(c4).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.9.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c5);
		softly.assertThat(c5).as("test data").contains("复训频率是否是根据复杂程度和使用频率来确定的？");
		String c23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c23);
		softly.assertThat(c23).as("test data").contains("复训的形式？");
		//Click on 2nd collapsible for 3.9.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.9.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c11);
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.9.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		System.out.println(c6);
		softly.assertThat(c6).as("test data").contains("增加复训频率，改善复训形式");
		//Click on 3rd collapsible for 3.9.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.9.3 question
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(q343);
		softly.assertThat(q343).as("test data").contains("[3.9.3] 部门管理层未充分参与培训材料的编写和培训的实施");
		//Click on 3.9.3 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']")));
		String s3 = ele.getAttribute("class");
		if(s3.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).getText();
		System.out.println(ev3);
		softly.assertThat(ev3).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Evidence entry place holder
		String ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-2"))).getAttribute("placeholder");
		System.out.println(ph3);
		softly.assertThat(ph3).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Click on 3.9.3 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//2nd collapsible for 3.9.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c7);
		softly.assertThat(c7).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.9.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c8);
		softly.assertThat(c8).as("test data").contains("部门经理审查关于培训材料的意见？");
		String c25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c25);
		softly.assertThat(c25).as("test data").contains("部门经理监督对上课情况？");
		//Click on 2nd collapsible for 3.9.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.9.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c12);
		softly.assertThat(c12).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.9.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		System.out.println(c9);
		softly.assertThat(c9).as("test data").contains("完善关于管理层参与培训材料编写或培训实施的相关要求");
		//Click on 3rd collapsible for 3.9.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.9.4 question
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		System.out.println(q344);
		softly.assertThat(q344).as("test data").contains("[3.9.4] 未将经验教训充分包含到培训中");
		//Click on 3.9.4 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']")));
		String s4 = ele.getAttribute("class");
		if(s4.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).getText();
		System.out.println(ev4);
		softly.assertThat(ev4).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Evidence entry place holder
		String ph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-3"))).getAttribute("placeholder");
		System.out.println(ph4);
		softly.assertThat(ph4).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Click on 3.9.4 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		//2nd collapsible for 3.9.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c13);
		softly.assertThat(c13).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.9.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c14);
		softly.assertThat(c14).as("test data").contains("审查对以往事件根本原因和共同原因的调查情况（从屏障、失误陷阱等角度）？");
		//Click on 2nd collapsible for 3.9.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.9.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c16);
		softly.assertThat(c16).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.9.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		System.out.println(c17);
		softly.assertThat(c17).as("test data").contains("提高对培训效果的审查");
		//Click on 3rd collapsible for 3.9.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.9.5 question
		String q345 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		System.out.println(q345);
		softly.assertThat(q345).as("test data").contains("[3.9.5] 所需培训开展不充分（脱岗）");
		//Click on 3.9.5 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']")));
		String s5 = ele.getAttribute("class");
		if(s5.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).getText();
		System.out.println(ev5);
		softly.assertThat(ev5).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Evidence entry place holder
		String ph5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-4"))).getAttribute("placeholder");
		System.out.println(ph5);
		softly.assertThat(ph5).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Click on 3.9.5 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		//2nd collapsible for 3.9.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c18);
		softly.assertThat(c18).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.9.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c19);
		softly.assertThat(c19).as("test data").contains("培训签到表，%员工接受了培训？");
		String c24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c24);
		softly.assertThat(c24).as("test data").contains("现场承包商没有经过培训？");
		//Click on 2nd collapsible for 3.9.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.9.5
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c20);
		softly.assertThat(c20).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.9.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c21);
		softly.assertThat(c21).as("test data").contains("完善承包商控制方针");
		String c26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c26);
		softly.assertThat(c26).as("test data").contains("完善培训资源");
		//Click on 3rd collapsible for 3.9.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		Thread.sleep(2000);
		jse.executeScript("scroll(0,1200)");
		Thread.sleep(2000);
		//3.9.6 question
		String q396 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).getText();
		System.out.println(q396);
		softly.assertThat(q396).as("test data").contains("[3.9.6] 所需培训开展不充分（在岗）");
		//Click on 3.9.6 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']")));
		String s6 = ele.getAttribute("class");
		if(s6.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).getText();
		System.out.println(ev6);
		softly.assertThat(ev6).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).click();
		//Evidence entry place holder
		String ph6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-5"))).getAttribute("placeholder");
		System.out.println(ph6);
		softly.assertThat(ph6).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).click();
		//Click on 3.9.6 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).click();
		//2nd collapsible for 3.9.6
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c15);
		softly.assertThat(c15).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.9.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c28);
		softly.assertThat(c28).as("test data").contains("在岗培训方针？");
		String c29 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c29);
		softly.assertThat(c29).as("test data").contains("经验不足的员工没有经过培训？");
		//Click on 2nd collapsible for 3.9.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.9.6
		String c30 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c30);
		softly.assertThat(c30).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.9.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c31 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c31);
		softly.assertThat(c31).as("test data").contains("完善在岗培训方针");
		String c32 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c32);
		softly.assertThat(c32).as("test data").contains("完善培训资源");
		//Click on 3rd collapsible for 3.9.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Add new contributing factor button
		String c33 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-button"))).getText();
		System.out.println(c33);
		softly.assertThat(c33).as("test data").contains("新增促成因素");
		//Verify Add Contributing factor
		chineseAddContributingFactor(driver);
		Thread.sleep(2000);
		jse.executeScript("scroll(0,0)");
		Thread.sleep(2000);
	}
	
	public void chineseStepOneq18 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.8 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(q11);
		softly.assertThat(q11).as("test data").contains("[1.8] 犯错人员是否受过培训知道如何管理易出错精神状态和高风险");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();
		System.out.println(reason);
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("这个问题探讨了犯错人员是否知晓需提前准备避免易出错精神状态或高风险状态促成的个人失误。如果没有，需要进行培训。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(ans1);
		softly.assertThat(ans1).as("test data").contains("没有");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(ans2);
		softly.assertThat(ans2).as("test data").contains("有，但超过两年了");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(ans3);
		softly.assertThat(ans3).as("test data").contains("两年内受过培训");
	}
	
	public void chineseStepOneq17 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.7 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(q11);
		softly.assertThat(q11).as("test data").contains("[1.7] 这个错误是否可以透过自检或独立检查避免");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();
		System.out.println(reason);
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("执行独立检查的程序步骤或自我检查可以以保证执行工作者的正确性。可在行动前执行独立检查（监护制），或在行动结束后执行独立验证。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(ans1);
		softly.assertThat(ans1).as("test data").contains("不能");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(ans2);
		softly.assertThat(ans2).as("test data").contains("能，程序有规定但未执行");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(ans3);
		softly.assertThat(ans3).as("test data").contains("能，但程序未规定");
	}
	
	public void chineseStepOneL315 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("同事互助提醒（好文化）");
		softly.assertThat(heading).as("test data").contains("不充分的促成因素");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		System.out.println(textD);
		softly.assertThat(textD).as("test data").contains("若不适用点选skip略过。使用者可于底部新增促成因素。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("缺乏同事互助提醒是否是这个失误的促成因素？如果是，同事互助提醒为什么会缺乏或无效？同事互助（好文化）是指互相指导或协助，帮助对方免受受害或违反规则。只有在同事互助按照制度标准建立、工作人员经过培训且对指导对方负责的情况下，同事互助才有效。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.15.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(q341);
		softly.assertThat(q341).as("test data").contains("[3.15.1] 员工未经过相互指导的培训，或纠正他人违规情况的培训");
		//Click on 3.15.1 to reveal evidence entry
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']")));
		String s1 = ele.getAttribute("class");
		if(s1.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).getText();
		System.out.println(ev1);
		softly.assertThat(ev1).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Evidence entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-0"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Click on 3.15.1 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//2nd collapsible for 3.15.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c1);
		softly.assertThat(c1).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.15.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c2);
		softly.assertThat(c2).as("test data").contains("审查相关培训？");
		//Click on 2nd collapsible for 3.15.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.15.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c10);
		softly.assertThat(c10).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.15.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		System.out.println(c3);
		softly.assertThat(c3).as("test data").contains("同事互助提醒（好文化）培训");
		//Click on 3rd collapsible for 3.15.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.15.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(q342);
		softly.assertThat(q342).as("test data").contains("[3.15.2] 未要求员工对纠正他人违规的情况承担责任");
		//Click on 3.15.2 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']")));
		String s2 = ele.getAttribute("class");
		if(s2.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).getText();
		System.out.println(ev2);
		softly.assertThat(ev2).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Evidence entry place holder
		String ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-1"))).getAttribute("placeholder");
		System.out.println(ph2);
		softly.assertThat(ph2).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Click on 3.15.2 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//2nd collapsible for 3.15.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c4);
		softly.assertThat(c4).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.15.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c5);
		softly.assertThat(c5).as("test data").contains("审查关于同事互助提醒（好文化）的管理期望和标准？");
		//Click on 2nd collapsible for 3.15.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.15.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c11);
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.15.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		System.out.println(c6);
		softly.assertThat(c6).as("test data").contains("建立关于同事互助提醒（好文化）的管理期望");
		//Click on 3rd collapsible for 3.15.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.15.3 question
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(q343);
		softly.assertThat(q343).as("test data").contains("[3.15.3] 员工未充分理解相关行为规范");
		//Click on 3.15.3 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']")));
		String s3 = ele.getAttribute("class");
		if(s3.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).getText();
		System.out.println(ev3);
		softly.assertThat(ev3).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Evidence entry place holder
		String ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-2"))).getAttribute("placeholder");
		System.out.println(ph3);
		softly.assertThat(ph3).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Click on 3.15.3 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//2nd collapsible for 3.15.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c7);
		softly.assertThat(c7).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.15.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c8);
		softly.assertThat(c8).as("test data").contains("观察工前会和工作的执行，以了解对行为规范的管理强化情况？");
		//Click on 2nd collapsible for 3.15.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.15.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c12);
		softly.assertThat(c12).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.15.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c9);
		softly.assertThat(c9).as("test data").contains("行为规范培训");
		String c23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c23);
		softly.assertThat(c23).as("test data").contains("采用行为规范提醒物");
		String c24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[3]"))).getText();
		System.out.println(c24);
		softly.assertThat(c24).as("test data").contains("采用禁止事项警告清单");
		//Click on 3rd collapsible for 3.15.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.18.4 question
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		System.out.println(q344);
		softly.assertThat(q344).as("test data").contains("[3.15.4] 主管未到现场强化");
		softly.assertThat(q344).as("test data").contains("同事指导");
		//Click on 3.15.4 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']")));
		String s4 = ele.getAttribute("class");
		if(s4.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).getText();
		System.out.println(ev4);
		softly.assertThat(ev4).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Evidence entry place holder
		String ph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-3"))).getAttribute("placeholder");
		System.out.println(ph4);
		softly.assertThat(ph4).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Click on 3.15.4 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		//2nd collapsible for 3.15.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c13);
		softly.assertThat(c13).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.15.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c14);
		softly.assertThat(c14).as("test data").contains("观察工前会和工作的执行，以了解对行为规范的管理强化情况？");
		//Click on 2nd collapsible for 3.15.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.15.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c16);
		softly.assertThat(c16).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.15.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c17);
		softly.assertThat(c17).as("test data").contains("监督管理能力培训");
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c15);
		softly.assertThat(c15).as("test data").contains("就监督管理强化，对管理者实施问责");
		//Click on 3rd collapsible for 3.15.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Add new contributing factor button
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-button"))).getText();
		System.out.println(c22);
		softly.assertThat(c22).as("test data").contains("新增促成因素");
		//Verify Add Contributing factor
		chineseAddContributingFactor(driver);
	}
	
	public void chineseStepOneq16 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.6 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(q11);
		softly.assertThat(q11).as("test data").contains("[1.6] 犯错者违规时是否有旁人观看");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();
		System.out.println(reason);
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("这个问题是评估公司/组织文化。如果有许多工作人员目睹犯错者的失误行为却没有认加以干预，这是一个文化和管理问题，需制定标准和问责机制。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(ans1);
		softly.assertThat(ans1).as("test data").contains("有");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(ans2);
		softly.assertThat(ans2).as("test data").contains("没有");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(ans3);
		softly.assertThat(ans3).as("test data").contains("未知");
	}
	
	public void chineseStepOneL318 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("知识型错误");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		System.out.println(textD);
		softly.assertThat(textD).as("test data").contains("若不适用点选skip略过。使用者可于底部新增促成因素。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("是否有证据表明以下思维模式促使犯错人员在本失误中的判断错误？");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.18.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(q341);
		softly.assertThat(q341).as("test data").contains("[3.18.1] 盲目信任: 关键信息使用质疑的态度QV&V℠不到位");
		//Click on 3.18.1 to reveal evidence entry
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']")));
		String s1 = ele.getAttribute("class");
		if(s1.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).getText();
		System.out.println(ev1);
		softly.assertThat(ev1).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Evidence entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-0"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Click on 3.18.1 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//2nd collapsible for 3.18.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c1);
		softly.assertThat(c1).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.18.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c2);
		softly.assertThat(c2).as("test data").contains("审查培训材料？");
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c22);
		softly.assertThat(c22).as("test data").contains("审查以往类似事件？");
		//Click on 2nd collapsible for 3.18.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.18.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c10);
		softly.assertThat(c10).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.18.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		System.out.println(c3);
		softly.assertThat(c3).as("test data").contains("提高质疑的态度");
		softly.assertThat(c3).as("test data").contains("培训");
		//Click on 3rd collapsible for 3.18.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.4.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(q342);
		softly.assertThat(q342).as("test data").contains("[3.18.2] 过度自信: (1) 高估自我效能; (2) 未意识到影响变化; (3) 未寻求他人智慧; (4) 没有从过去中学习; (5) 缺少屏障预防错误发生");
		//Click on 3.18.2 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']")));
		String s2 = ele.getAttribute("class");
		if(s2.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).getText();
		System.out.println(ev2);
		softly.assertThat(ev2).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Evidence entry place holder
		String ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-1"))).getAttribute("placeholder");
		System.out.println(ph2);
		softly.assertThat(ph2).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Click on 3.18.2 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//2nd collapsible for 3.18.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c4);
		softly.assertThat(c4).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.18.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c5);
		softly.assertThat(c5).as("test data").contains("执行首次执行的任务而没有仔细规划?");
		String c23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c23);
		softly.assertThat(c23).as("test data").contains("过去有过超出能力工作的事件?");
		String c24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();
		System.out.println(c24);
		softly.assertThat(c24).as("test data").contains("对设计工作推断不当而未执行适当试验?");
		//Click on 2nd collapsible for 3.18.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.18.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c11);
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.18.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		System.out.println(c6);
		softly.assertThat(c6).as("test data").contains("行为培训，避免过度自信");
		//Click on 3rd collapsible for 3.18.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.18.3 question
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(q343);
		softly.assertThat(q343).as("test data").contains("[3.18.3] 眼不见心不想: (1) 对低概率/高风险事件的风险控制不到位; (2) 忽略与绩效指标或激励无关的问题; (3) 因忽略相关风险而未设置屏障");
		//Click on 3.18.3 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']")));
		String s3 = ele.getAttribute("class");
		if(s3.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).getText();
		System.out.println(ev3);
		softly.assertThat(ev3).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Evidence entry place holder
		String ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-2"))).getAttribute("placeholder");
		System.out.println(ph3);
		softly.assertThat(ph3).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Click on 3.18.3 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//2nd collapsible for 3.18.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c7);
		softly.assertThat(c7).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.18.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c8);
		softly.assertThat(c8).as("test data").contains("因忽略相关风险而未设置屏障");
		String c25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c25);
		softly.assertThat(c25).as("test data").contains("审查管理监督或项目委员会会议纪要?");
		//Click on 2nd collapsible for 3.18.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.18.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c12);
		softly.assertThat(c12).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.18.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c9);
		softly.assertThat(c9).as("test data").contains("改善风险控制项目");
		String c26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c26);
		softly.assertThat(c26).as("test data").contains("完善");
		softly.assertThat(c26).as("test data").contains("体系");
		//Click on 3rd collapsible for 3.18.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.18.4 question
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		System.out.println(q344);
		softly.assertThat(q344).as("test data").contains("[3.18.4] 未能及时止损: (1) 因自满和（或）无知，捍卫过去错误的决定或犹豫不决; (2) 期望通过重复同样的问题处理方法、标准或策略来实现不同的结果");
		//Click on 3.18.4 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']")));
		String s4 = ele.getAttribute("class");
		if(s4.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).getText();
		System.out.println(ev4);
		softly.assertThat(ev4).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Evidence entry place holder
		String ph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-3"))).getAttribute("placeholder");
		System.out.println(ph4);
		softly.assertThat(ph4).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Click on 3.18.4 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		//2nd collapsible for 3.18.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c13);
		softly.assertThat(c13).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.18.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c14);
		softly.assertThat(c14).as("test data").contains("审查管理监督或项目委员会会议纪要?");
		//Click on 2nd collapsible for 3.18.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.18.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c16);
		softly.assertThat(c16).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.18.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		System.out.println(c17);
		softly.assertThat(c17).as("test data").contains("审查以往决策的有效性，提高管理监督");
		//Click on 3rd collapsible for 3.18.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.18.5 question
		String q345 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		System.out.println(q345);
		softly.assertThat(q345).as("test data").contains("[3.18.5] 陷入两选一的陷阱: 决策、问题解决或计划不充分，未能确保全面考虑多个选择方案进行分析");
		//Click on 3.18.5 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']")));
		String s5 = ele.getAttribute("class");
		if(s5.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).getText();
		System.out.println(ev5);
		softly.assertThat(ev5).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Evidence entry place holder
		String ph5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-4"))).getAttribute("placeholder");
		System.out.println(ph5);
		softly.assertThat(ph5).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Click on 3.18.5 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		//2nd collapsible for 3.18.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c18);
		softly.assertThat(c18).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.18.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c19);
		softly.assertThat(c19).as("test data").contains("审查管理监督或项目委员会会议纪要?");
		//Click on 2nd collapsible for 3.18.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.18.5
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c20);
		softly.assertThat(c20).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.18.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		System.out.println(c21);
		softly.assertThat(c21).as("test data").contains("提高决策、问题解决和计划的结构（委员会）和流程");
		//Click on 3rd collapsible for 3.18.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Add new contributing factor button
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-button"))).getText();
		System.out.println(c15);
		softly.assertThat(c15).as("test data").contains("新增促成因素");
		//Verify Add Contributing factor
		chineseAddContributingFactor(driver);
	}
	
	public void chineseStepOneL34 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("关键思考和关键追问不充分");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		System.out.println(textD);
		softly.assertThat(textD).as("test data").contains("若不适用点选skip略过。使用者可于底部新增促成因素。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("是否多次遇到过这样的情况：如果花时间进行关键思考或关键追问，本来可以缓解失误？关键思考指的是省思如何让一天或一项任务获得成功；包括检查个人和他人的精神状态或检查程序问题。关键追问指的是探讨准备工作是否足以取得成功；包括澄清任何未知情况。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.4.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(q341);
		softly.assertThat(q341).as("test data").contains("[3.4.1] 采取行动前没有思考如何规划（如优先顺序、机会、沟通、时间管理等）");
		//Click on 3.4.1 to reveal evidence entry
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']")));
		String s1 = ele.getAttribute("class");
		if(s1.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).getText();
		System.out.println(ev1);
		softly.assertThat(ev1).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Evidence entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-0"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Click on 3.4.1 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//2nd collapsible for 3.4.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c1);
		softly.assertThat(c1).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.4.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c2);
		softly.assertThat(c2).as("test data").contains("访谈犯错者");
		//Click on 2nd collapsible for 3.4.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.4.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c10);
		softly.assertThat(c10).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.4.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		System.out.println(c3);
		softly.assertThat(c3).as("test data").contains("开展关键思考和关键追问方面的培训");
		//Click on 3rd collapsible for 3.4.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.4.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(q342);
		softly.assertThat(q342).as("test data").contains("[3.4.2] 采取行动前没有考虑易出错的心理状况");
		//Click on 3.4.2 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']")));
		String s2 = ele.getAttribute("class");
		if(s2.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).getText();
		System.out.println(ev2);
		softly.assertThat(ev2).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Evidence entry place holder
		String ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-1"))).getAttribute("placeholder");
		System.out.println(ph2);
		softly.assertThat(ph2).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Click on 3.4.2 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//2nd collapsible for 3.4.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c4);
		softly.assertThat(c4).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.4.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c5);
		softly.assertThat(c5).as("test data").contains("访谈犯错者");
		//Click on 2nd collapsible for 3.4.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.4.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c11);
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.4.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		System.out.println(c6);
		softly.assertThat(c6).as("test data").contains("开展关键思考和关键追问方面的培训");
		//Click on 3rd collapsible for 3.4.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.4.3 question
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(q343);
		softly.assertThat(q343).as("test data").contains("[3.4.3] 采取行动前没有考虑高风险情境（如单项弱点）");
		//Click on 3.4.3 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']")));
		String s3 = ele.getAttribute("class");
		if(s3.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).getText();
		System.out.println(ev3);
		softly.assertThat(ev3).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Evidence entry place holder
		String ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-2"))).getAttribute("placeholder");
		System.out.println(ph3);
		softly.assertThat(ph3).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Click on 3.4.3 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//2nd collapsible for 3.4.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c7);
		softly.assertThat(c7).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.4.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c8);
		softly.assertThat(c8).as("test data").contains("访谈犯错者");
		//Click on 2nd collapsible for 3.4.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.4.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c12);
		softly.assertThat(c12).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.4.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		System.out.println(c9);
		softly.assertThat(c9).as("test data").contains("开展关键思考和关键追问方面的培训");
		//Click on 3rd collapsible for 3.4.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.4.4 question
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		System.out.println(q344);
		softly.assertThat(q344).as("test data").contains("[3.4.4] 感到疑惑时质疑不充分");
		//Click on 3.4.4 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']")));
		String s4 = ele.getAttribute("class");
		if(s4.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).getText();
		System.out.println(ev4);
		softly.assertThat(ev4).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Evidence entry place holder
		String ph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-3"))).getAttribute("placeholder");
		System.out.println(ph4);
		softly.assertThat(ph4).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Click on 3.4.4 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		//2nd collapsible for 3.4.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c13);
		softly.assertThat(c13).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.4.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c14);
		softly.assertThat(c14).as("test data").contains("访谈犯错者");
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c15);
		softly.assertThat(c15).as("test data").contains("访谈主管");
		//Click on 2nd collapsible for 3.4.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.4.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c16);
		softly.assertThat(c16).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.4.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		System.out.println(c17);
		softly.assertThat(c17).as("test data").contains("开展关键思考和关键追问方面的培训");
		//Click on 3rd collapsible for 3.4.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.4.5 question
		String q345 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		System.out.println(q345);
		softly.assertThat(q345).as("test data").contains("[3.4.5] 任务准备过程中质疑不充分");
		//Click on 3.4.5 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']")));
		String s5 = ele.getAttribute("class");
		if(s5.contains("ui-checkbox-on")==false)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).getText();
		System.out.println(ev5);
		softly.assertThat(ev5).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Evidence entry place holder
		String ph5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-4"))).getAttribute("placeholder");
		System.out.println(ph5);
		softly.assertThat(ph5).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Click on 3.4.5 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		//2nd collapsible for 3.4.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c18);
		softly.assertThat(c18).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.4.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c19);
		softly.assertThat(c19).as("test data").contains("访谈犯错者");
		//Click on 2nd collapsible for 3.4.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.4.5
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c20);
		softly.assertThat(c20).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.4.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		System.out.println(c21);
		softly.assertThat(c21).as("test data").contains("开展关键思考和关键追问方面的培训");
		//Click on 3rd collapsible for 3.4.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Add new contributing factor button
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-button"))).getText();
		System.out.println(c22);
		softly.assertThat(c22).as("test data").contains("新增促成因素");
		//Verify Add Contributing factor
		chineseAddContributingFactor(driver);
	}
	
	public void chineseStepOneq12 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.2 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(q11);
		softly.assertThat(q11).as("test data").contains("[1.2] 始发事件的错误类型为何");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();
		System.out.println(reason);
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(ans1);
		softly.assertThat(ans1).as("test data").contains("知识型错误");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(ans2);
		softly.assertThat(ans2).as("test data").contains("规则型错误");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(ans3);
		softly.assertThat(ans3).as("test data").contains("技能型错误");
	}
	
	public void chineseStepOneq11 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.1 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(q11);
		softly.assertThat(q11).as("test data").contains("[1.1] 始发事件为人因、设备失效还是天灾");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();
		System.out.println(reason);
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(ans1);
		softly.assertThat(ans1).as("test data").contains("人因");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(ans2);
		softly.assertThat(ans2).as("test data").contains("设备失效");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(ans3);
		softly.assertThat(ans3).as("test data").contains("天灾");
	}
	
	public void chineseEventInfo (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Check if title contains chinese HiRCA
		String hirca_title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		System.out.println(hirca_title);
		softly.assertThat(hirca_title).as("test data").contains(" - 事件信息");
		//Heading of event info page in chinese?
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("输入事件信息");
		//Checks if the textboxes have the correct titles
		//Event title
		String ev_title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-title-label"))).getText();
		System.out.println(ev_title);
		softly.assertThat(ev_title).as("test data").contains("事件名称:");
		//Verify place holder of event title
		String ev_ph = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-title"))).getAttribute("placeholder");
		System.out.println(ev_ph);
		softly.assertThat(ev_ph).as("test data").contains("输入 事件名称");
		//Event id
		String ev_id = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[2]/label"))).getText();
		System.out.println(ev_id);
		softly.assertThat(ev_id).as("test data").contains("事件编号:");
		//Verify place holder of event id
		String ev_ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-crnumber"))).getAttribute("placeholder");
		System.out.println(ev_ph1);
		softly.assertThat(ev_ph1).as("test data").contains("输入 事件编号 (非必填)");
		//Event location
		String loc=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[3]/label"))).getText();
		System.out.println(loc);
		softly.assertThat(loc).as("test data").contains("事件发生地点:");
		//Verify place holder of event location
		String ev_ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-location"))).getAttribute("placeholder");
		System.out.println(ev_ph2);
		softly.assertThat(ev_ph2).as("test data").contains("输入 事件发生地点");
		//Department
		String dept=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[4]/fieldset/div/legend"))).getText();
		System.out.println(dept);
		softly.assertThat(dept).as("test data").contains("部门:");
		//Sub department
		String sub_dept=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[5]/fieldset/div/legend"))).getText();
		System.out.println(sub_dept);
		softly.assertThat(sub_dept).as("test data").contains("组:");
		//Date of event
		String date=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[6]/label"))).getText();
		System.out.println(date);
		softly.assertThat(date).as("test data").contains("事件发生日期:");
		//Time of event
		String time=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[7]/label"))).getText();
		System.out.println(time);
		softly.assertThat(time).as("test data").contains("事件发生时间:");
		//Problem statement
		String prob=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[8]/label"))).getText();
		System.out.println(prob);
		softly.assertThat(prob).as("test data").contains("事件描述:");
		//Verify place holder of problem statement
		String ev_ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-pbstatement"))).getAttribute("placeholder");
		System.out.println(ev_ph3);
		softly.assertThat(ev_ph3).as("test data").contains("输入 事件描述");
		//Executive summary
		String exec=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[9]/label"))).getText();
		System.out.println(exec);
		softly.assertThat(exec).as("test data").contains("报告摘要:");
		//Verify place holder of executive summary
		String ev_ph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-execsummary"))).getAttribute("placeholder");
		System.out.println(ev_ph4);
		softly.assertThat(ev_ph4).as("test data").contains("输入 报告摘要 (非必填)");
		//Timeline of event
		String timeline=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[10]/label"))).getText();
		System.out.println(timeline);
		softly.assertThat(timeline).as("test data").contains("事件详细过程（时序构建）:");
		//Verify place holder of timeline of event
		String ev_ph5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-events"))).getAttribute("placeholder");
		System.out.println(ev_ph5);
		softly.assertThat(ev_ph5).as("test data").contains("输入 事件详细过程（时序构建）");
		//Background information
		String back=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[11]/label"))).getText();
		System.out.println(back);
		softly.assertThat(back).as("test data").contains("相关信息:");
		//Verify place holder of background information
		String ev_ph6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-bginfos"))).getAttribute("placeholder");
		System.out.println(ev_ph6);
		softly.assertThat(ev_ph6).as("test data").contains("输入 相关信息");
		//Supporting file (1)
		String supp1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-fieldcontain-label-0"))).getText();
		System.out.println(supp1);
		softly.assertThat(supp1).as("test data").contains("支援文件 (1):");
		//Header of supporting file
		String supp1_header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-filecollapsible-header-0"))).getText();
		System.out.println(supp1_header);
		softly.assertThat(supp1_header).as("test data").contains("支援文件描述细节");
		//Add new file button
		String newFilebutton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewfile-button"))).getText();
		System.out.println(newFilebutton);
		softly.assertThat(newFilebutton).as("test data").contains("上传另一个档案");
		//Investigators
		String inve=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[14]/label"))).getText();
		System.out.println(inve);
		softly.assertThat(inve).as("test data").contains("事件调查员:");
		//Verify place holder of investigator
		String ev_ph7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-investigators"))).getAttribute("placeholder");
		System.out.println(ev_ph7);
		softly.assertThat(ev_ph7).as("test data").contains("输入 事件调查员");
		//Report creation date
		String repo=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[15]/label"))).getText();
		System.out.println(repo);
		softly.assertThat(repo).as("test data").contains("报告编写时间:");
	}

	
	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}
}
