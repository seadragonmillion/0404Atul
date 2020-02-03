package kaleTestSoftware;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class EiRCAPath2 {

	SoftAssertions softly = new SoftAssertions();

	TextBoxResizing tbr = new TextBoxResizing ();
	ShareCheck2 share2 = new ShareCheck2();
	EiRCAV2PageObj eirca = new EiRCAV2PageObj();
	EiRCAV2 e1 = new EiRCAV2();
	EiRCAV2_4 eirca4 = new EiRCAV2_4();

	public void verifyFACTCharacteristics(WebDriver driver) throws Exception {

		WebDriverWait wait1 = new WebDriverWait(driver,10);
		//Select all FACTS
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[1]/td[3]/button"))).click();		
		for(int i=1;i<=8;i++)
		{
			WebElement menu1a = driver.findElement(eirca.Step3FACTPopupMenu);
			String cL1a1 = menu1a.findElement(By.xpath(".//*[@data-option-index='"+i+"']/a")).getAttribute("class");
			if(cL1a1.contains("ui-checkbox-off"))
				menu1a.findElement(By.xpath(".//*[@data-option-index='"+i+"']/a")).click();
		}
		//Close popup
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3FACTPopupCloseButton)).click();
		//Verify Characteristics
		for(int j=1;j<=8;j++)
		{
			int count;
			WebElement ele = driver.findElement(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[1]/td[4]/div["+j+"]/div/select"));
			if(j==1) {
				count = 2;
				for(int i=0;i<=count;i++)
				{
					String s = ele.findElement(By.xpath(".//*[@value='"+i+"']")).getText();
					if(i==0) softly.assertThat(s).as("test data").isEqualTo("High (Mega Hz)");
					if(i==1) softly.assertThat(s).as("test data").isEqualTo("Medium (50-2,000 Hz)");
					if(i==2) softly.assertThat(s).as("test data").isEqualTo("DC");
				}
			}
			if(j==2) {
				count = 3;
				for(int i=0;i<=count;i++)
				{
					String s = ele.findElement(By.xpath(".//*[@value='"+i+"']")).getText();
					if(i==0) softly.assertThat(s).as("test data").isEqualTo("Continuous from beginning of operation");
					if(i==1) softly.assertThat(s).as("test data").isEqualTo("Intermittent (appearing and disappearing)");
					if(i==2) softly.assertThat(s).as("test data").isEqualTo("Sudden occurrence");
					if(i==3) softly.assertThat(s).as("test data").isEqualTo("Gradual worsening");
				}
			}
			if(j==3) {
				count = 5;
				for(int i=0;i<=count;i++)
				{
					String s = ele.findElement(By.xpath(".//*[@value='"+i+"']")).getText();
					if(i==0) softly.assertThat(s).as("test data").isEqualTo("Audible alarms");
					if(i==1) softly.assertThat(s).as("test data").isEqualTo("Fault flags");
					if(i==2) softly.assertThat(s).as("test data").isEqualTo("Protective trip flags");
					if(i==3) softly.assertThat(s).as("test data").isEqualTo("Error messages or trouble lights");
					if(i==4) softly.assertThat(s).as("test data").isEqualTo("Under-voltage, over-voltage lockout, and auto-reset flags");
					if(i==5) softly.assertThat(s).as("test data").isEqualTo("No alarms/flags");
				}
			}
			if(j==4) {
				count = 8;
				for(int i=0;i<=count;i++)
				{
					String s = ele.findElement(By.xpath(".//*[@value='"+i+"']")).getText();
					if(i==0) softly.assertThat(s).as("test data").isEqualTo("Coincide with equipment startup");
					if(i==1) softly.assertThat(s).as("test data").isEqualTo("Coincide with power turn off");
					if(i==2) softly.assertThat(s).as("test data").isEqualTo("Coincide with welding activity");
					if(i==3) softly.assertThat(s).as("test data").isEqualTo("Coincide with switch operation");
					if(i==4) softly.assertThat(s).as("test data").isEqualTo("Coincide with temperature change");
					if(i==5) softly.assertThat(s).as("test data").isEqualTo("Coincide with voltage change");
					if(i==6) softly.assertThat(s).as("test data").isEqualTo("Coincide with pressure change");
					if(i==7) softly.assertThat(s).as("test data").isEqualTo("Coincide with abnormal conditions");
					if(i==8) softly.assertThat(s).as("test data").isEqualTo("Coincide with “right after” or “during” a maintenance, operation, construction, installation, or a design change activity (or action)");
				}
			}
			if(j==5) {
				count = 2;
				for(int i=0;i<=count;i++)
				{
					String s = ele.findElement(By.xpath(".//*[@value='"+i+"']")).getText();
					if(i==0) softly.assertThat(s).as("test data").isEqualTo("Happened in a specific time frame");
					if(i==1) softly.assertThat(s).as("test data").isEqualTo("Only one equipment out of many showed symptom in the same time frame");
					if(i==2) softly.assertThat(s).as("test data").isEqualTo("Happened when equipment is on standby");
				}
			}
			if(j==6) {
				count = 2;
				for(int i=0;i<=count;i++)
				{
					String s = ele.findElement(By.xpath(".//*[@value='"+i+"']")).getText();
					if(i==0) softly.assertThat(s).as("test data").isEqualTo("Steadily increasing randomness (or standard deviation) of the related process parameters");
					if(i==1) softly.assertThat(s).as("test data").isEqualTo("Steadily increasing magnitude of the process parameters, such as bearing temperature, insulation resistance, etc");
					if(i==2) softly.assertThat(s).as("test data").isEqualTo("Step change in magnitude; or a step change in randomness of related process parameters");
				}
			}
			if(j==7) {
				count = 10;
				for(int i=0;i<=count;i++)
				{
					String s = ele.findElement(By.xpath(".//*[@value='"+i+"']")).getText();
					if(i==0) softly.assertThat(s).as("test data").isEqualTo("Small magnitude");
					if(i==1) softly.assertThat(s).as("test data").isEqualTo("Large magnitude");
					if(i==2) softly.assertThat(s).as("test data").isEqualTo("Small quantity");
					if(i==3) softly.assertThat(s).as("test data").isEqualTo("Large quantity");
					if(i==4) softly.assertThat(s).as("test data").isEqualTo("Fast speed");
					if(i==5) softly.assertThat(s).as("test data").isEqualTo("Slow speed");
					if(i==6) softly.assertThat(s).as("test data").isEqualTo("Serious deformation");
					if(i==7) softly.assertThat(s).as("test data").isEqualTo("Slight deformation");
					if(i==8) softly.assertThat(s).as("test data").isEqualTo("Low temperature");
					if(i==9) softly.assertThat(s).as("test data").isEqualTo("High temperature");
					if(i==10) softly.assertThat(s).as("test data").isEqualTo("Color change in short period of time");
				}
			}
			if(j==8) {
				count = 8;
				for(int i=0;i<=count;i++)
				{
					String s = ele.findElement(By.xpath(".//*[@value='"+i+"']")).getText();
					if(i==0) softly.assertThat(s).as("test data").isEqualTo("One direction spikes");
					if(i==1) softly.assertThat(s).as("test data").isEqualTo("One direction dips");
					if(i==2) softly.assertThat(s).as("test data").isEqualTo("Up and down spikes at a specific frequency");
					if(i==3) softly.assertThat(s).as("test data").isEqualTo("Up and down intermittent wave signals");
					if(i==4) softly.assertThat(s).as("test data").isEqualTo("DC intermittent signals");
					if(i==5) softly.assertThat(s).as("test data").isEqualTo("Out-of-range signals");
					if(i==6) softly.assertThat(s).as("test data").isEqualTo("Dead failure (no signals)");
					if(i==7) softly.assertThat(s).as("test data").isEqualTo("Dip with short duration (< 1 second)");
					if(i==8) softly.assertThat(s).as("test data").isEqualTo("Dip with medium duration (100- 350 seconds)");
				}
			}

		}
	}

	public void verifyDeletedStep3FailureModeNotPresentInStep4(WebDriver driver, List<String> step3) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,2);	
		int rowCount = 1;
		List<String> step4 = new ArrayList<String>();
		for(int i=0;i<step3.size();i++)
		{
			try{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t4-fms-table']/tbody/tr["+rowCount+"]/td[1]/button/ul/li[1]"))).getText();
				softly.assertThat(s).as("test data").isEqualTo("Symptoms (failure factor analysis)");		
				String fm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t4-fms-table']/tbody/tr["+rowCount+"]/td[2]/textarea"))).getAttribute("value");
				softly.assertThat(fm).as("test data").isIn(step3);
				step4.add(fm);
			}catch(org.openqa.selenium.TimeoutException t){
				break;
			}
			rowCount = rowCount+2;
		}
		if(step4.contains("IMP FM 1"))
			softly.fail("FACTs were unselected in Step 3 for IMP FM 1, but its still showing up in Step 4");
	}

	public void verifyEiRCAPath2 (WebDriver driver) throws Exception {

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebDriverWait wait1 = new WebDriverWait(driver,10);
		String text = eirca.textEiRCAv2Bug;	
		//Clicks on Analysis 
		try
		{
			driver.findElement(By.id("pii-main-menu-button-a")).click();
		}catch (UnhandledAlertException f){			  
			driver.switchTo().alert().dismiss();
		}
		//Clicks on EiRCA
		jse.executeScript("return document.getElementById('pii-a-menu-eirca').click();");
		Thread.sleep(1000);
		//Fills all mandatory fields
		driver.findElement(eirca.EiRCAEventTitleField).sendKeys(text);
		driver.findElement(eirca.EiRCAEventLocationField).sendKeys(text);
		driver.findElement(eirca.EiRCAEventReporterField).sendKeys(text); 
		driver.findElement(eirca.EiRCAEventInvestigatorField).sendKeys(text);
		driver.findElement(eirca.EiRCAEventReviewerField).sendKeys(text);
		driver.findElement(eirca.EiRCAEventSponsorField).sendKeys(text);
		driver.findElement(eirca.EiRCAEventProblemStatementField).sendKeys(text);
		e1.EIRCAStep1Dropboxes(driver,eirca.textEiRCAv2,softly);
		//Clicks on Save button
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASaveButton)).click();
		Thread.sleep(2000);
		//Clicks on Save Report button			  
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupTitle)).click();
		Thread.sleep(2000);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupConfirmButton)).click();
		share2.loadingServer(driver);
		//Saved activities
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASavedActivitiesButton)).click();	
		share2.loadingServer(driver);
		//Side panel
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASidePanel)).click();	
		share2.loadingServer(driver);
		share2.scrollToTop(driver);
		//Click on 1st record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAFirstRecord)).click();	
		share2.loadingServer(driver);
		//Click on open button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.OpenButton)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();	
		share2.loadingServer(driver);
		int intialCount = e1.getCharCountFromTitle(driver);
		//Type something in title field
		driver.findElement(eirca.EiRCAEventTitleField).sendKeys(text);
		driver.findElement(eirca.EiRCAEventTitleField).sendKeys(Keys.TAB);
		Thread.sleep(500);
		int finalCount = e1.getCharCountFromTitle(driver);
		softly.assertThat(finalCount).as("test data").isEqualTo(intialCount+text.length());
		//Click next
		share2.scrollToElement(driver, wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.NextButtonBottomOfStep1Page)));
		jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.NextButtonBottomOfStep1Page)));	
		//Click back
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCABackButton)).click();
		//Verify on step 1, by verifying event title
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAEventTitleField));
		//Click Next
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
		//Click next on Sequence Of events
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
		//Click on symptoms
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SymptomsTab)).click();
		//symptoms
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SymptomsTextbox1)).sendKeys("Symptom 1 \n Symptom 2");
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SymptomsTextbox2)).sendKeys("Symptom 3 \n Symptom 4");
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SymptomsTextbox3)).sendKeys("Symptom 5 \n Symptom 6 \n Symptom 7");	
		//Select one option under SBI
		//Click on button
		share2.scrollToElement(driver, wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SenseBasedInspectionButton)));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SenseBasedInspectionButton)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InspectionSymptomListPopup));
		WebElement menu1 = driver.findElement(eirca.EiRCAStep2InspectionSymptomListMenu);
		String cL1 = menu1.findElement(eirca.EiRCAStep2SymptomsOption1).getAttribute("class");
		if(cL1.contains("ui-checkbox-off"))
			menu1.findElement(eirca.EiRCAStep2SymptomsOption1).click();
		//Click on button for selecting inspection parameter
		share2.scrollToElement(driver, wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-ircam2-t3-inspections-focus-button-0"))));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-ircam2-t3-inspections-focus-button-0"))).click();
		WebElement menu = driver.findElement(By.id("pii-ircam2-t2t3-newentry-ifocus-0-menu"));
		String cL1a = menu.findElement(eirca.EiRCAStep2SymptomsOption1).getAttribute("class");
		if(cL1a.contains("ui-checkbox-off"))
			menu.findElement(eirca.EiRCAStep2SymptomsOption1).click();
		//close popup
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-newentry-ifocus-0-listbox']/div/a"))).click();
		//Findings
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-tbody']/tr[1]/td[4]/textarea"))).sendKeys("Symptom 8 \n Symptom 9");	

		//Select one option under SRI
		//Click on button
		share2.scrollToElement(driver, wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SystematicReliabilityInspectionButton)));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SystematicReliabilityInspectionButton)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InspectionSymptomListPopupSRI));
		menu1 = driver.findElement(eirca.EiRCAStep2InspectionSymptomListMenuSRI);
		String cL2 = menu1.findElement(eirca.EiRCAStep2SymptomsOption1).getAttribute("class");
		if(cL2.contains("ui-checkbox-off"))
			menu1.findElement(eirca.EiRCAStep2SymptomsOption1).click();
		//Click on button for selecting inspection parameter
		share2.scrollToElement(driver, wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-ircam2-t3-inspections-focus-button-SRI-1"))));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-ircam2-t3-inspections-focus-button-SRI-1"))).click();
		menu = driver.findElement(By.id("pii-ircam2-t2t3-newentry-ifocus-SRI-1-menu"));
		String cL = menu.findElement(eirca.EiRCAStep2SymptomsOption1).getAttribute("class");
		if(cL.contains("ui-checkbox-off"))
			menu.findElement(eirca.EiRCAStep2SymptomsOption1).click();
		//close popup
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-newentry-ifocus-SRI-1-listbox']/div/a"))).click();
		//Findings
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-SRI-tbody']/tr[1]/td[4]/textarea"))).sendKeys("Symptom 10 \n Symptom 11");	
		//Click Next
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
		//Step 3
		String symp1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(symp1).as("test data").isEqualTo("Symptom 1");
		String symp2 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(symp2).as("test data").isEqualTo("Symptom 2");
		String symp3 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(symp3).as("test data").isEqualTo("Symptom 3");
		String symp4 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(symp4).as("test data").isEqualTo("Symptom 4");
		String symp5 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(symp5).as("test data").isEqualTo("Symptom 5");
		String symp6 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(symp6).as("test data").isEqualTo("Symptom 6");
		String symp7 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(symp7).as("test data").isEqualTo("Symptom 7");
		String symp8 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[8]/td[2]"))).getText();
		softly.assertThat(symp8).as("test data").isEqualTo("Symptom 8");
		String symp9 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[9]/td[1]"))).getText();
		softly.assertThat(symp9).as("test data").isEqualTo("Symptom 9");
		String symp10 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[10]/td[2]"))).getText();
		softly.assertThat(symp10).as("test data").isEqualTo("Symptom 10");
		String symp11 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[11]/td[1]"))).getText();
		softly.assertThat(symp11).as("test data").isEqualTo("Symptom 11");
		//Click back
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCABackButton)).click();
		//Clear symptoms from Products from failure mechanisms
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SymptomsTextbox3)).clear();	
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SymptomsTextbox3)).sendKeys("Symptom 5 \n Symptom 7");
		//Click Next
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
		//Step 3
		String symp1a = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(symp1a).as("test data").isEqualTo("Symptom 1");
		String symp2a = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(symp2a).as("test data").isEqualTo("Symptom 2");
		String symp3a = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(symp3a).as("test data").isEqualTo("Symptom 3");
		String symp4a = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(symp4a).as("test data").isEqualTo("Symptom 4");
		String symp5a = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(symp5a).as("test data").isEqualTo("Symptom 5");
		String symp7a = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(symp7a).as("test data").isEqualTo("Symptom 7");
		String symp8a = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[7]/td[2]"))).getText();
		softly.assertThat(symp8a).as("test data").isEqualTo("Symptom 8");
		String symp9a = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[8]/td[1]"))).getText();
		softly.assertThat(symp9a).as("test data").isEqualTo("Symptom 9");
		String symp10a = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[9]/td[2]"))).getText();
		softly.assertThat(symp10a).as("test data").isEqualTo("Symptom 10");
		String symp11a = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[10]/td[1]"))).getText();
		softly.assertThat(symp11a).as("test data").isEqualTo("Symptom 11");		
		//Click back
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCABackButton)).click();
		//Clear symptoms from SBI
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-tbody']/tr[1]/td[4]/textarea"))).clear();
		//Findings
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-tbody']/tr[1]/td[4]/textarea"))).sendKeys("Symptom 9");
		//Click Next
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
		//Step 3
		String symp1b = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(symp1b).as("test data").isEqualTo("Symptom 1");
		String symp2b = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(symp2b).as("test data").isEqualTo("Symptom 2");
		String symp3b = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(symp3b).as("test data").isEqualTo("Symptom 3");
		String symp4b = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(symp4b).as("test data").isEqualTo("Symptom 4");
		String symp5b = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(symp5b).as("test data").isEqualTo("Symptom 5");
		String symp7b = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(symp7b).as("test data").isEqualTo("Symptom 7");
		String symp9b = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[7]/td[2]"))).getText();
		softly.assertThat(symp9b).as("test data").isEqualTo("Symptom 9");
		String symp10b = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[8]/td[2]"))).getText();
		softly.assertThat(symp10b).as("test data").isEqualTo("Symptom 10");
		String symp11b = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[9]/td[1]"))).getText();
		softly.assertThat(symp11b).as("test data").isEqualTo("Symptom 11");		
		//Select FACTS
		for(int i=1;i<=9;i++)
		{
			Random random = new Random();
			//Choose number of FACTS 1 to 8
			int n = random.nextInt(9);
			if(n==0)
				n=n+1;
			//Select FACTS
			int tdFact = 3;
			int tdChar = 4;
			int tdImp = 5;
			if(i==2 || i==4 || i==6 || i==9)
			{
				tdFact = 2;
				tdChar = 3;
				tdImp = 4;
			}
			share2.scrollToElement(driver, wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr["+i+"]/td["+tdFact+"]/button"))));
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr["+i+"]/td["+tdFact+"]/button"))).click();
			int indexOfFactFreqOfOcc=0;
			for(int j=1;j<=n;j++)
			{
				WebElement menu1a = driver.findElement(eirca.Step3FACTPopupMenu);
				String cL1a1 = menu1a.findElement(By.xpath(".//*[@data-option-index='"+j+"']/a")).getAttribute("class");
				if(cL1a1.contains("ui-checkbox-off"))
					menu1a.findElement(By.xpath(".//*[@data-option-index='"+j+"']/a")).click();
				if(menu1a.findElement(By.xpath(".//*[@data-option-index='"+j+"']/a")).getText()=="Frequency of occurrence"){
					indexOfFactFreqOfOcc=j;
				}
			}
			//Close popup
			wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3FACTPopupCloseButton)).click();
			//Choose characteristics
			for(int j=1;j<=n;j++)
			{
				share2.scrollToElement(driver, driver.findElement(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr["+i+"]/td["+tdChar+"]/div["+j+"]/div/select")));
				WebElement ele = driver.findElement(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr["+i+"]/td["+tdChar+"]/div["+j+"]/div/select"));
				Select s = new Select(ele);
				//Find number of options under Characteristics
				int count = 0;
				while(true)
				{
					try{
						ele.findElement(By.xpath(".//*[@value='"+count+"']"));
						count += 1;
					}catch(org.openqa.selenium.NoSuchElementException r){
						break;
					}					
				}
				int selectValue = random.nextInt(count);
				s.selectByValue(String.valueOf(selectValue));
				if(j==indexOfFactFreqOfOcc){
					String s1 = ele.findElement(By.xpath(".//*[@value='1']")).getText();
					softly.assertThat(s1).as("test data").isEqualTo("Intermittent (appearing and disappearing)");
				}
			}
			//Enter Implication
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr["+i+"]/td["+tdImp+"]/textarea"))).sendKeys("IMP FM "+i);
		}		

		List<String> listForTestingDeletedFM = new ArrayList<String>();
		for(int i=1;i<=9;i++)
			listForTestingDeletedFM.add("IMP FM "+i);
		//Click Next
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
		//Verify the implication names in Step 4
		eirca4.verifyStep3FailureModes(driver,softly,listForTestingDeletedFM);
		//Click back
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCABackButton)).click();
		share2.scrollToElement(driver, driver.findElement(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[1]/td[3]")));
		//Verify all characteristics
		verifyFACTCharacteristics(driver);
		//unselect all FACTS
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[1]/td[3]/button"))).click();		
		for(int i=1;i<=8;i++)
		{
			WebElement menu1a = driver.findElement(eirca.Step3FACTPopupMenu);
			String cL1a1 = menu1a.findElement(By.xpath(".//*[@data-option-index='"+i+"']/a")).getAttribute("class");
			if(cL1a1.contains("ui-checkbox-on"))
				menu1a.findElement(By.xpath(".//*[@data-option-index='"+i+"']/a")).click();
		}
		//Close popup
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3FACTPopupCloseButton)).click();
		//Verify no Characteristics dropdown shown in next column
		wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[1]/td[4]/div[1]")));
		//Verify no implication textarea shown
		wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[1]/td[5]/textarea")));
		//Click Next
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
		//Verify title on Step 4
		String title1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4TabPageTitle)).getText();
		softly.assertThat(title1).as("test data").isEqualTo("Possible Failure Modes");
		//Verify the implication names in Step 4 do not have IMP FM 1 deleted Failure mode
		//listForTestingDeletedFM.remove("IMP FM 1");
		verifyDeletedStep3FailureModeNotPresentInStep4(driver,listForTestingDeletedFM);
		//Click back
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCABackButton)).click();
		//Verify title on Step 3
		String title2 = wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TabPageTitle)).getText();
		softly.assertThat(title2).as("test data").isEqualTo("FACTS Symptom Characterization");
		//Click back
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCABackButton)).click();
		//Verify title on Step 2
		String title4 = wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2TabInstruction)).getText();
		softly.assertThat(title4).as("test data").isEqualTo("Enter DOOMS Data and Delta DOOMS Data based on evidence collection.");
		//Click Next
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
		//Verify title on Step 3
		String title5 = wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TabPageTitle)).getText();
		softly.assertThat(title5).as("test data").isEqualTo("FACTS Symptom Characterization");
		//Get Step 3 FACT data
		HashMap<String,List<String>> hm = new HashMap<String,List<String>>();
		for(int i=2;i<=9;i++)
		{
			List<String> f1 = new ArrayList<String>();
			List<String> c1 = new ArrayList<String>();
			int tdFact = 3;
			int tdChar = 4;
			if(i==2 || i==4 || i==6 || i==9)
			{
				tdFact = 2;
				tdChar = 3;
			}
			String s = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr["+i+"]/td["+tdFact+"]/button"))).getText();
			f1.add(s);
			for(int j=1;j<=15;j++)
			{
				try{
					String s1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr["+i+"]/td["+tdFact+"]/div[2]/button["+j+"]"))).getText();
					f1.add(s1);
				}catch(org.openqa.selenium.TimeoutException r)
				{
					break;
				}
			}
			for(int j=1;j<=15;j++)
			{
				try{
					String s1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr["+i+"]/td["+tdChar+"]/div["+j+"]/div/span"))).getText();
					c1.add(s1);
				}catch(org.openqa.selenium.TimeoutException r)
				{
					break;
				}
			}
			hm.put("FACT "+i,f1);
			hm.put("Char "+i,c1);
		}
		System.out.println(hm);		
		//Click Next
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
		//Click back
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCABackButton)).click();		
		//Verify Step 3 data
		for(int i=2;i<=9;i++)
		{
			int tdFact = 3;
			int tdChar = 4;
			int tdImp = 5;
			if(i==2 || i==4 || i==6 || i==9)
			{
				tdFact = 2;
				tdChar = 3;
				tdImp = 4;
			}
			String s = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr["+i+"]/td["+tdImp+"]/textarea"))).getAttribute("value");
			softly.assertThat(s).as("test data").isEqualTo("IMP FM "+i);
			List<String> f1 = hm.get("FACT "+i);
			List<String> c1 = hm.get("Char "+i);
			for(int j=0;j<f1.size();j++)
			{
				if(j==0)
				{
					String s1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr["+i+"]/td["+tdFact+"]/button"))).getText();
					softly.assertThat(s1).as("test data").isIn(f1);					
				}else{
					String s1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr["+i+"]/td["+tdFact+"]/div[2]/button["+j+"]"))).getText();
					softly.assertThat(s1).as("test data").isIn(f1);
				}
				String s2 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr["+i+"]/td["+tdChar+"]/div["+(j+1)+"]/div/span"))).getText();
				softly.assertThat(s2).as("test data").isIn(c1);
			}
		}
		//Click back
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCABackButton)).click();
		//Click Next
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
		List<String> listFMs = new ArrayList<String>();
		//Verify Step 3 data
		for(int i=2;i<=9;i++)
		{
			int tdFact = 3;
			int tdChar = 4;
			int tdImp = 5;
			if(i==2 || i==4 || i==6 || i==9)
			{
				tdFact = 2;
				tdChar = 3;
				tdImp = 4;
			}
			String s = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr["+i+"]/td["+tdImp+"]/textarea"))).getAttribute("value");
			softly.assertThat(s).as("test data").isEqualTo("IMP FM "+i);
			listFMs.add("IMP FM "+i);
			List<String> f1 = hm.get("FACT "+i);
			List<String> c1 = hm.get("Char "+i);
			for(int j=0;j<f1.size();j++)
			{
				if(j==0)
				{
					String s1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr["+i+"]/td["+tdFact+"]/button"))).getText();
					softly.assertThat(s1).as("test data").isIn(f1);					
				}else{
					String s1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr["+i+"]/td["+tdFact+"]/div[2]/button["+j+"]"))).getText();
					softly.assertThat(s1).as("test data").isIn(f1);
				}
				String s2 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr["+i+"]/td["+tdChar+"]/div["+(j+1)+"]/div/span"))).getText();
				softly.assertThat(s2).as("test data").isIn(c1);
			}
		}
		//Select 2nd and 4th FACTS in 1st symptom
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[1]/td[3]/button"))).click();		
		WebElement menu1a = driver.findElement(eirca.Step3FACTPopupMenu);
		String cL1a1 = menu1a.findElement(By.xpath(".//*[@data-option-index=2]/a")).getAttribute("class");
		if(cL1a1.contains("ui-checkbox-off"))
			menu1a.findElement(By.xpath(".//*[@data-option-index=2]/a")).click();
		String cL1a2 = menu1a.findElement(By.xpath(".//*[@data-option-index=4]/a")).getAttribute("class");
		if(cL1a2.contains("ui-checkbox-off"))
			menu1a.findElement(By.xpath(".//*[@data-option-index=4]/a")).click();
		//Close popup
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3FACTPopupCloseButton)).click();
		//Choose characteristics
		for(int j=1;j<=2;j++)
		{
			share2.scrollToElement(driver, driver.findElement(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[1]/td[4]/div["+j+"]/div/select")));
			WebElement ele = driver.findElement(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[1]/td[4]/div["+j+"]/div/select"));
			Select s = new Select(ele);
			//Find number of options under Characteristics
			int count = 0;
			while(true)
			{
				try{
					ele.findElement(By.xpath(".//*[@value='"+count+"']"));
					count += 1;
				}catch(org.openqa.selenium.NoSuchElementException r){
					break;
				}					
			}
			Random random = new Random();
			int selectValue = random.nextInt(count);
			s.selectByValue(String.valueOf(selectValue));
		}
		//Store FACT and Characteristics
		List<String> f1a = new ArrayList<String>();
		List<String> c1a = new ArrayList<String>();
		for(int i=2;i<=9;i++)
		{
			String s = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[1]/td[3]/button"))).getText();
			f1a.add(s);
			for(int j=1;j<=2;j++)
			{
				try{
					String s1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[1]/td[3]/div[2]/button["+j+"]"))).getText();
					f1a.add(s1);
				}catch(org.openqa.selenium.TimeoutException r)
				{
					break;
				}
			}
			for(int j=1;j<=2;j++)
			{
				try{
					String s1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[1]/td[4]/div["+j+"]/div/span"))).getText();
					c1a.add(s1);
				}catch(org.openqa.selenium.TimeoutException r)
				{
					break;
				}
			}
		}
		//Choose 1st,3rd and 5th FACT from list and verify the Choose Characteristics appears and old selections of Characteristics is still present
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[1]/td[3]/button"))).click();		
		WebElement menu2a = driver.findElement(eirca.Step3FACTPopupMenu);
		String cL1a3 = menu2a.findElement(By.xpath(".//*[@data-option-index=1]/a")).getAttribute("class");
		if(cL1a3.contains("ui-checkbox-off"))
			menu2a.findElement(By.xpath(".//*[@data-option-index=1]/a")).click();
		String cL1a4 = menu2a.findElement(By.xpath(".//*[@data-option-index=3]/a")).getAttribute("class");
		if(cL1a4.contains("ui-checkbox-off"))
			menu2a.findElement(By.xpath(".//*[@data-option-index=3]/a")).click();
		String cL1a5 = menu2a.findElement(By.xpath(".//*[@data-option-index=5]/a")).getAttribute("class");
		if(cL1a5.contains("ui-checkbox-off"))
			menu2a.findElement(By.xpath(".//*[@data-option-index=5]/a")).click();
		//Close popup
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3FACTPopupCloseButton)).click();
		//Verify characteristics
		for(int j=1;j<=5;j++)
		{
			String s2 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[1]/td[4]/div["+j+"]/div/span"))).getText();
			if(j==1||j==3||j==5)
				softly.assertThat(s2).as("test data").isEqualTo("Choose characteristics");
			else
				softly.assertThat(s2).as("test data").isIn(c1a);
		}
		//Click back
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCABackButton)).click();
		//Click Next
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
		//Verify characteristics
		for(int j=1;j<=5;j++)
		{
			String s2 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[1]/td[4]/div["+j+"]/div/span"))).getText();
			if(j==1||j==3||j==5)
				softly.assertThat(s2).as("test data").isEqualTo("Choose characteristics");
			else
				softly.assertThat(s2).as("test data").isIn(c1a);
		}
		listFMs.add("IMP FM 1");
		//Click Next
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
		//Verify the implication names in Step 4
		eirca4.verifyStep3FailureModes(driver,softly,listFMs);
		//Click back
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCABackButton)).click();
		//Add 2 implications in 1st symptom
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[1]/td[5]/textarea"))).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[1]/td[5]/textarea"))).sendKeys("IMP FM 1"+"\n"+"IMP FM 1a");
		listFMs.add("IMP FM 1a");
		//Click Next
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
		//Verify the implication names in Step 4
		eirca4.verifyStep3FailureModes(driver,softly,listFMs);
		//Click back
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCABackButton)).click();
		//Add clear implications in 1st symptom
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[1]/td[5]/textarea"))).clear();
		listFMs.remove("IMP FM 1a");
		listFMs.remove("IMP FM 1");
		//Click Next
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
		//Verify the implication names in Step 4
		eirca4.verifyStep3FailureModes(driver,softly,listFMs);
		//Click back
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCABackButton)).click();
		//Add 2 implications in 1st symptom
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[1]/td[5]/textarea"))).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[1]/td[5]/textarea"))).sendKeys("\n"+"IMP FM 1b"+"\n"+"\n"+"\n"+"IMP FM 1c"+"\n");
		listFMs.add("IMP FM 1b");
		listFMs.add("IMP FM 1c");
		//Click Next
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
		//Verify the implication names in Step 4
		eirca4.verifyStep3FailureModes(driver,softly,listFMs);		
		//Click back to step 3
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCABackButton)).click();
		//Verify the degraded capabilities in first column first row
		String degCap = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(degCap).as("test data").isEqualTo("Degraded capabilities");
		//Click back to step 2
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCABackButton)).click();
		//Click on symptoms
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SymptomsTab)).click();
		//symptoms
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SymptomsTextbox1)).clear();
		//Click Next
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
		//Verify the degraded capabilities in first column first row
		String degCap1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(degCap1).as("test data").isEqualTo("Abnormalities in operation and configuration");
		//Click back to step 2
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCABackButton)).click();
		//Click on symptoms
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SymptomsTab)).click();
		//symptoms
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SymptomsTextbox2)).clear();
		//Click Next
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
		//Verify the degraded capabilities in first column first row
		String degCap2 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(degCap2).as("test data").isEqualTo("Products from failure mechanisms");
		//Click back to step 2
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCABackButton)).click();
		//Click on symptoms
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SymptomsTab)).click();
		//symptoms
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SymptomsTextbox3)).clear();
		//Click Next
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
		//Verify the degraded capabilities in first column first row
		String degCap3 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(degCap3).as("test data").isEqualTo("Sense based inspection: Abnormal configuration");
		//Click Next
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
		//List of fms
		List<String> fms1 = new ArrayList<String>();
		fms1.add("IMP FM 7"); 
		fms1.add("IMP FM 8");
		fms1.add("IMP FM 9");
		//Verify the implication names in Step 4
		eirca4.verifyStep3FailureModes(driver,softly,fms1);
		//Click back to step 3
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCABackButton)).click();
		//Click back to step 2
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCABackButton)).click();
		//Click on symptoms
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SymptomsTab)).click();
		//Enter symptom in observed symptoms
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SymptomsTextbox1)).sendKeys("Symptom 1");
		//Clear symptoms in Comprehensive Field Inspection
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-tbody']/tr[1]/td[4]/textarea"))).clear();	
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-SRI-tbody']/tr[1]/td[4]/textarea"))).clear();
		//Click Next
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
		//Verify title on Step 3
		String title6 = wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TabPageTitle)).getText();
		softly.assertThat(title6).as("test data").isEqualTo("FACTS Symptom Characterization");


		//Clicks on Save button
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASaveButton)).click();
		Thread.sleep(2000);
		//Clicks on Save Report button			  
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupTitle));
		Thread.sleep(2000);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupConfirmButton)).click();		
		//Clicks on Saved activities button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASavedActivitiesButton)).click();
		share2.loadingServer(driver);
		//Clicks on panel on the left on EiRCA
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASidePanel)).click();
		share2.loadingServer(driver);
		share2.scrollToTop(driver);
		//Click on 1st record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAFirstRecord)).click();
		share2.loadingServer(driver);
		//Delete report
		driver.findElement(eirca.DeleteButton).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
		share2.loadingServer(driver);
	}

	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}

}
