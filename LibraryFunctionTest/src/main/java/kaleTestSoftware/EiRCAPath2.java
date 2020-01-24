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
		//Get Step 3 FACT data
		HashMap<String,List<String>> hm = new HashMap<String,List<String>>();
		for(int i=1;i<=9;i++)
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
		for(int i=1;i<=9;i++)
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
		//Verify Step 3 data
		for(int i=1;i<=9;i++)
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
