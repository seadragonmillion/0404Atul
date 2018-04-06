import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HiRCALevel1 {
	
	SoftAssertions softly = new SoftAssertions();
	String text = "HiRCA Level 1 test";

	public void HiRCAPathCheck(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Clicks on Analysis 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-a"))).click();
		//Clicks on HiRCA
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-hirca"))).click();
		Thread.sleep(2000);
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
		//Select Equipment failure
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div/label"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//Verify 3.17
		verify317(driver);
		//Click on skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		//Click on LOP
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		//Click on Yes
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-initialquestions']/div/fieldset[1]/div/div/label"))).click();
		//Verify the LOP selection
		verifyLOP(driver);
		//Click on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		//Wait for black server load message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			  }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Click on No
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-initialquestions']/div/fieldset[2]/div/div/label"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//Verify 2.21
		verify221(driver);
		//Click on skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		//Verify 2.22
		verify222(driver);
		//Click on skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		//Verify Step 3 SUEP
		verifySUEP(driver);
		//Click on skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		//Verify Step 4
		//Verify title
		String title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(title).as("test data").contains("Step 4 - Level of Importance Attribution For Root Causes & Contributing Factors");
		//Click on skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		//Verify Step 5
		verifyHiRCAChecklist(driver);
		//Click on skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		//Verify if on Report Tab by looking for finalize button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-finalize")));
		//Click on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		//Wait for black server load message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			  }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Click on saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-btn-savedactivities"))).click();
		//Wait for black server load message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			  }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
	}
	
	public void deleteReport (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-irca"))).click();
		//Wait for black server load message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			  }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Click on newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();
		//Wait for black server load message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			  }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Click on delete
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[3]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		//Wait for black server load message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			  }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
	}
	
	public void verifyHiRCAChecklist(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Verify title
		String title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(title).as("test data").contains("Step 5 - HiRCA");
		softly.assertThat(title).as("test data").contains(" Self Checklist");
		//Verify category General and its questions
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[1]/strong"))).getText();
		softly.assertThat(s1).as("test data").isEqualTo("General");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(s2).as("test data").isEqualTo("All involved parties interviewed and all relevant data collected?");
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(s3).as("test data").isEqualTo("Past similar events examined?");
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Triggering event and related LOPs identified?");
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[5]/td[1]/strong"))).getText();
		softly.assertThat(s5).as("test data").isEqualTo("Triggering Event");
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(s6).as("test data").isEqualTo("Error type involving the triggering event determined?");
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[6]/td[2]"))).getText();
		softly.assertThat(s7).as("test data").isEqualTo("Any equipment failure (if any) involving in the triggering event investigated for its triggering errors?");
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[7]/td[2]"))).getText();
		softly.assertThat(s8).as("test data").isEqualTo("Contributing factors determined?");
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[8]/td[1]/strong"))).getText();
		softly.assertThat(s9).as("test data").isEqualTo("Root Causes");
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[8]/td[2]"))).getText();
		softly.assertThat(s10).as("test data").contains("Root causes meeting SUEP");
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[8]/td[2]"))).getText();
		softly.assertThat(s11).as("test data").contains(" criteria?");
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[9]/td[2]"))).getText();
		softly.assertThat(s12).as("test data").contains("Root causes surviving the CHOP'N");
		String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[9]/td[2]"))).getText();
		softly.assertThat(s13).as("test data").contains(" challenge?");
		String s14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[10]/td[2]"))).getText();
		softly.assertThat(s14).as("test data").isEqualTo("Levels of importance for root causes identified?");
		String s15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[11]/td[1]/strong"))).getText();
		softly.assertThat(s15).as("test data").isEqualTo("Corrective Actions");
		String s16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[11]/td[2]"))).getText();
		softly.assertThat(s16).as("test data").isEqualTo("Recommended corrective actions covering all root causes and contributing factors?");
		String s17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[12]/td[2]"))).getText();
		softly.assertThat(s17).as("test data").isEqualTo("Recommended corrective actions cost effective?");
	}
	
	public void verifySUEP (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Verify SUEP title
		String title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(title).as("test data").contains("Step 3 - Root Causes Determination Checklist (SUEP");
		//Verify SUEP full form
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		softly.assertThat(s1).as("test data").isEqualTo("S: Substandard Practice?");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]"))).getText();
		softly.assertThat(s2).as("test data").isEqualTo("U: Under Management Control?");
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]"))).getText();
		softly.assertThat(s3).as("test data").isEqualTo("E: Early in Event Sequence?");
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]"))).getText();
		softly.assertThat(s4).as("test data").isEqualTo("P: Prevention Of Recurrence?");
	}
	
	public void verify222 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Verify LOP title
		String title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(title).as("test data").contains("[2.22] Was HiRCA");
		softly.assertThat(title).as("test data").contains("adequate in leading this investigation?");
		//Verify 3.17 questions
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div/label"))).getText();
		softly.assertThat(s1).as("test data").isEqualTo("No");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div/label"))).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Yes, but need more training");
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div/label"))).getText();
		softly.assertThat(s3).as("test data").isEqualTo("Yes");
	}
	
	public void verify221(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Verify LOP title
		String title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(title).as("test data").contains("[2.21] What LOPs can prevent this event from happening?");
		//Verify 3.17 questions
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div/label"))).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Briefings (PJB, MJB, PSM, TO, etc.)");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div/label"))).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Concurrent check");
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div/label"))).getText();
		softly.assertThat(s3).as("test data").isEqualTo("Error-proof design");
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div/label"))).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Independent check");
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div/label"))).getText();
		softly.assertThat(s5).as("test data").isEqualTo("JIT alarm");
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div/label"))).getText();
		softly.assertThat(s6).as("test data").isEqualTo("JIT reminder (signage, not-to do postings)");
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div/label"))).getText();
		softly.assertThat(s7).as("test data").isEqualTo("Passive protection (safety net, fall protection, air bags, safety belt, etc.)");
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div/label"))).getText();
		softly.assertThat(s8).as("test data").isEqualTo("Peer coaching");
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div/label"))).getText();
		softly.assertThat(s9).as("test data").isEqualTo("Review (PNR, Technical review)");
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div/label"))).getText();
		softly.assertThat(s10).as("test data").isEqualTo("Self-check");
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[12]/fieldset/div/div/label"))).getText();
		softly.assertThat(s11).as("test data").isEqualTo("Supervisory intervention");
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[13]/fieldset/div/div/label"))).getText();
		softly.assertThat(s12).as("test data").isEqualTo("Other:");
	}
	
	public void verifyLOP(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Verify LOP title
		String title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(title).as("test data").contains("[2.0] What were the failed LOPs (3 max) that caused this event to happen?");
		//Verify 3.17 questions
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div/label"))).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Briefings (PJB, MJB, PSM, TO, etc.)");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div/label"))).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Concurrent check");
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div/label"))).getText();
		softly.assertThat(s3).as("test data").isEqualTo("Error-proof design");
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div/label"))).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Independent check");
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div/label"))).getText();
		softly.assertThat(s5).as("test data").isEqualTo("JIT alarm");
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div/label"))).getText();
		softly.assertThat(s6).as("test data").isEqualTo("JIT reminder (signage, not-to do postings)");
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div/label"))).getText();
		softly.assertThat(s7).as("test data").isEqualTo("Passive protection (safety net, fall protection, air bags, safety belt, etc.)");
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div/label"))).getText();
		softly.assertThat(s8).as("test data").isEqualTo("Peer coaching");
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div/label"))).getText();
		softly.assertThat(s9).as("test data").isEqualTo("Review (PNR, Technical review)");
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div/label"))).getText();
		softly.assertThat(s10).as("test data").isEqualTo("Self-check");
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[12]/fieldset/div/div/label"))).getText();
		softly.assertThat(s11).as("test data").isEqualTo("Supervisory intervention");
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[13]/fieldset/div/div/label"))).getText();
		softly.assertThat(s12).as("test data").isEqualTo("Other:");
	}
	
	public void verify317(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Verify 3.17 title
		String title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(title).as("test data").contains("QTM - equipment qualification, testing and maintenance");
		//Verify 3.17 questions
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div/label"))).getText();
		softly.assertThat(s1).as("test data").contains("[3.17.1] Inadequate procurement and/or design specifications");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div/label"))).getText();
		softly.assertThat(s2).as("test data").contains("[3.17.2] Inadequate source audit / inspection QA/QC for compliance (if applicable)");
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div/label"))).getText();
		softly.assertThat(s3).as("test data").contains("[3.17.3] Inadequate design qualification and/or testing before use");
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div/label"))).getText();
		softly.assertThat(s4).as("test data").contains("[3.17.4] Inadequate operation: (1) Inadequate operation procedure; (2) Inadequate operating condition; (3) Operation errors");
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div/label"))).getText();
		softly.assertThat(s5).as("test data").contains("[3.17.5] Inadequate periodic surveillance testing");
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div/label"))).getText();
		softly.assertThat(s6).as("test data").contains("[3.17.6] Inadequate maintenance");
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div/label"))).getText();
		softly.assertThat(s7).as("test data").contains("[3.17.7] Inadequate equipment labeling and identification");
	}
	
	public void softAssert() throws Exception {
		softly.assertAll();
	}

}
