package kaleTestSoftware;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class EiRCAPath2 {

	SoftAssertions softly = new SoftAssertions();

	TextBoxResizing tbr = new TextBoxResizing ();
	ShareCheck2 share2 = new ShareCheck2();
	EiRCAV2PageObj eirca = new EiRCAV2PageObj();
	EiRCAV2 e1 = new EiRCAV2();

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
		//Click next
		share2.scrollToElement(driver, wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.NextButtonBottomOfStep1Page)));
		jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.NextButtonBottomOfStep1Page)));	
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
		//Clicks on Save button
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASaveButton)).click();
		Thread.sleep(2000);
		//Clicks on Save Report button			  
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupTitle)).click();
		Thread.sleep(2000);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupConfirmButton)).click();
	}

	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}

}
