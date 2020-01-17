package kaleTestSoftware;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EiRCAV2_3 {

	//EiRCA2 eirca2 = new EiRCA2();
	ShareCheck2 share2 = new ShareCheck2();
	ShareCheck share = new ShareCheck();
	EiRCAV2PageObj eirca = new EiRCAV2PageObj();


	public List<String> EiRCAStep2 (WebDriver driver, SoftAssertions softly) throws Exception {

		List<String> symptoms = new ArrayList<String>();
		//Enter text in all tabs
		designDataTab(driver,eirca.textStep2WithNextLine);		
		operatingPracticeTab(driver,eirca.textStep2WithNextLine);
		operatingExperienceTab(driver,eirca.textStep2WithNextLine);
		maintenanceDataTab(driver,eirca.textStep2WithNextLine);
		symptoms.addAll(symptomsTab(driver,eirca.textStep2WithNextLine,softly));
		//Verify no <br> in text boxes
		/*verifyNobrInDOOMSTextBoxes(driver,softly);
		//Enter text in DELTA DOOMS Tab
		deltaDOOMSTab(driver,textStep2WithNextLine,softly);
		//Verify no <br> in text boxes
		verifyNobrInDeltaDOOMSTextBoxes(driver,softly);
		//Add 4 symptoms in Comprehensive Field Inspection Tab
		List<String> inspectionsAndDetailsAll = comprehensiveFieldInspection(driver,textStep2,softly);
		for(int i=4;i<inspectionsAndDetailsAll.size();i=i+5)
		{
			symptoms.add(inspectionsAndDetailsAll.get(i));
			System.out.println(inspectionsAndDetailsAll.get(i));
		}*/
		//Add interviews in Interview Tab
		interviews(driver,eirca.textStep2,softly);
		share2.scrollToTop(driver);
		return symptoms;
	}
	/*
	public void verifyNobrInDeltaDOOMSTextBoxes(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify text in Failure Component
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DeltaDOOMSFailureComponentTextbox1)).getAttribute("value");
		softly.assertThat(s1).as("test data").doesNotContain("<br>");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DeltaDOOMSFailureComponentTextbox2)).getAttribute("value");
		softly.assertThat(s2).as("test data").doesNotContain("<br>");
		//Non-Failure Similar Components
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DeltaDOOMSNonFailureSimilarComponentTextbox1)).getAttribute("value");
		softly.assertThat(s3).as("test data").doesNotContain("<br>");
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DeltaDOOMSNonFailureSimilarComponentTextbox2)).getAttribute("value");
		softly.assertThat(s4).as("test data").doesNotContain("<br>");
		//Non-Failure Components with Similar Functions
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DeltaDOOMSNonFailureComponentSimilarFunctionTextbox1)).getAttribute("value");
		softly.assertThat(s5).as("test data").doesNotContain("<br>");
	}

	public void verifyNobrInDOOMSTextBoxes(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify text in Design data
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DesignDataTextbox1R1C1)).getAttribute("value");
		softly.assertThat(s1).as("test data").doesNotContain("<br>");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DesignDataTextbox1R1C2)).getAttribute("value");
		softly.assertThat(s2).as("test data").doesNotContain("<br>");
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DesignDataTextbox1R1C3)).getAttribute("value");
		softly.assertThat(s3).as("test data").doesNotContain("<br>");
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DOOMSDesignDataTextbox4)).getAttribute("value");
		softly.assertThat(s4).as("test data").doesNotContain("<br>");
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DOOMSDesignDataTextbox5)).getAttribute("value");
		softly.assertThat(s5).as("test data").doesNotContain("<br>");
		//Operating practice and condition data
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DOOMSOperatingPracticeTextbox1)).getAttribute("value");
		softly.assertThat(s6).as("test data").doesNotContain("<br>");
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DOOMSOperatingPracticeTextbox2)).getAttribute("value");
		softly.assertThat(s7).as("test data").doesNotContain("<br>");
		//operating experience
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DOOMSOperatingExperienceTextbox1)).getAttribute("value");
		softly.assertThat(s8).as("test data").doesNotContain("<br>");
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DOOMSOperatingExperienceTextbox2)).getAttribute("value");
		softly.assertThat(s9).as("test data").doesNotContain("<br>");
		//maintenance data
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DOOMSMaintenanceDataTextbox1)).getAttribute("value");
		softly.assertThat(s10).as("test data").doesNotContain("<br>");
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DOOMSMaintenanceDataTextbox2)).getAttribute("value");
		softly.assertThat(s11).as("test data").doesNotContain("<br>");
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DOOMSMaintenanceDataTextbox3)).getAttribute("value");
		softly.assertThat(s12).as("test data").doesNotContain("<br>");	
	}*/

	public void interviews(WebDriver driver, String text, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewsTab)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewsTab)).click();
		//Table 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable1Row1Column1)).sendKeys(text);
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable1Row1Column2)).click();
		Thread.sleep(500);
		//Verify no undefined in Interview textbox
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable1Row1Column2)).getAttribute("textcontent");
		softly.assertThat(s).as("test data").isNull();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable1Row1Column2)).sendKeys(text);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable1Row2Column2)).click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable1Row2Column2)).sendKeys(text);
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable1Row2Column1)).click();
		Thread.sleep(500);
		//Verify no undefined in Name textbox
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable1Row2Column1)).getAttribute("textcontent");
		softly.assertThat(s1).as("test data").isNull();	
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable1Row2Column1)).sendKeys(text);
		Thread.sleep(500);
		//Table 2
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable2Row1Column1)).click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable2Row1Column1)).sendKeys(text);
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable2Row1Column2)).click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable2Row1Column2)).sendKeys(text);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable2Row2Column1)).click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable2Row2Column1)).sendKeys(text);
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable2Row2Column2)).click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable2Row2Column2)).sendKeys(text);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable2Row3Column1)).click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable2Row3Column1)).sendKeys(text);
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable2Row3Column2)).click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable2Row3Column2)).sendKeys(text);
		Thread.sleep(1000);
		//Delete 3rd interview in table 2
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable2Row3Column3DeleteButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupConfirmButton)).click();
		Thread.sleep(1000);
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable2Row4Column1)).click();		
			softly.fail("interview did not get deleted");
		}catch(org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException t)
		{

		}
		//Table 3
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable3Row1Column1)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable3Row1Column1)).click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable3Row1Column1)).sendKeys(text);
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable3Row1Column2)).click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable3Row1Column2)).sendKeys(text);
		Thread.sleep(1000);
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable3Row2Column1)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable3Row2Column1)).click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable3Row2Column1)).sendKeys(text);
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable3Row2Column2)).click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable3Row2Column2)).sendKeys(text);
		Thread.sleep(500);
		//Table 4
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable4Row1Column1)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable4Row1Column1)).click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable4Row1Column1)).sendKeys(text);
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable4Row1Column2)).click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable4Row1Column2)).sendKeys(text);
		Thread.sleep(1000);
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable4Row2Column1)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable4Row2Column1)).click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable4Row2Column1)).sendKeys(text);
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable4Row2Column2)).click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable4Row2Column2)).sendKeys(text);
		Thread.sleep(500);
	}

	public void designDataTab(WebDriver driver, String text) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DesignDataTab)).click();
		//Fill text in Design data
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DesignDataTextbox1R1C1)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DesignDataTextbox1R1C2)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DesignDataTextbox1R1C3)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DesignDataTextbox2R2C1)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DesignDataTextbox2R2C2)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DesignDataTextbox2R2C3)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DesignDataTextbox3R3C1)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DesignDataTextbox3R3C2)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DesignDataTextbox3R3C3)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DesignDataTextbox4R4C1)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DesignDataTextbox4R4C2)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DesignDataTextbox4R4C3)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DesignDataTextbox5R5C1)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DesignDataTextbox5R5C2)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DesignDataTextbox5R5C3)).sendKeys(text);
	}

	public void operatingPracticeTab(WebDriver driver, String text) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2OperatingPracticeTab)).click();
		//Operating practice and condition data
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2OperatingPracticeTextbox1R1C1)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2OperatingPracticeTextbox1R1C2)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2OperatingPracticeTextbox1R1C3)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2OperatingPracticeTextbox2R2C1)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2OperatingPracticeTextbox2R2C2)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2OperatingPracticeTextbox2R2C3)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2OperatingPracticeTextbox3R3C1)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2OperatingPracticeTextbox3R3C2)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2OperatingPracticeTextbox3R3C3)).sendKeys(text);
	}

	public void operatingExperienceTab(WebDriver driver, String text) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2OperatingExperienceTab)).click();
		//Operating experience
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2OperatingExperienceTextbox1)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2OperatingExperienceTextbox2R2C1)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2OperatingExperienceTextbox2R2C2)).sendKeys(text);	
	}

	public void maintenanceDataTab(WebDriver driver, String text) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2MaintenanceDataTab)).click();
		//maintenance data
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2MaintenanceDataTextbox1R1C1)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2MaintenanceDataTextbox1R1C2)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2MaintenanceDataTextbox1R1C3)).sendKeys(text);		
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2MaintenanceDataTextbox2R2C1)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2MaintenanceDataTextbox2R2C2)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2MaintenanceDataTextbox2R2C3)).sendKeys(text);		
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2MaintenanceDataTextbox3R3C1)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2MaintenanceDataTextbox3R3C2)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2MaintenanceDataTextbox3R3C3)).sendKeys(text);		
	}

	public List<String> symptomsTab(WebDriver driver, String text, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		List<String> symptoms = new ArrayList<String>();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SymptomsTab)).click();
		//symptoms
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SymptomsTextbox1)).sendKeys("Symptom 1");
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SymptomsTextbox2)).sendKeys("Symptom 2");
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SymptomsTextbox3)).sendKeys("Symptom 3");		
		symptoms.add("Symptom 1");
		symptoms.add("Symptom 2");
		symptoms.add("Symptom 3");
		//Add symptoms in Comprehensive field Inspection
		List<String> symp = addSymptomsInComprehensiveFieldInspectionSenseBasedInspection(driver,text,softly);
		symptoms.addAll(symp);	
		symptoms.addAll(addSymptomsInComprehensiveFieldInspectionSRI(driver,text,softly,symp));
		share2.scrollToTop(driver);
		return symptoms;
	}

	public List<String> addSymptomsInComprehensiveFieldInspectionSenseBasedInspection(WebDriver driver, String text, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		List<String> symptoms = new ArrayList<String>();
		//Sense Based inspection
		//Select randomly symptoms
		Random random = new Random();
		int num = random.nextInt(7);
		if(num==0){
			num=num+1;
		}
		//Click on button
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SenseBasedInspectionButton)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SenseBasedInspectionButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InspectionSymptomListPopup));
		WebElement menu1 = driver.findElement(eirca.EiRCAStep2InspectionSymptomListMenu);
		String cL1 = menu1.findElement(eirca.EiRCAStep2SymptomsOption1).getAttribute("class");
		if(cL1.contains("ui-checkbox-off"))
			menu1.findElement(eirca.EiRCAStep2SymptomsOption1).click();
		for(int i=1;i<num;i++)
		{
			//Click on button
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SenseBasedInspectionButton)));
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SenseBasedInspectionButton)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InspectionSymptomListPopup));
			WebElement menu = driver.findElement(eirca.EiRCAStep2InspectionSymptomListMenu);
			String cL = menu.findElement(By.xpath(".//*[@data-option-index='"+i+"']/a")).getAttribute("class");
			if(cL.contains("ui-checkbox-off"))
				menu.findElement(By.xpath(".//*[@data-option-index='"+i+"']/a")).click();
		}
		//List for counting number of rows in SBI
		List<Integer>rows = new ArrayList<Integer>();
		for(int i=1;i<=num;i++)
		{
			//Click on button for selecting inspection parameter
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-ircam2-t3-inspections-focus-button-"+(i-1)))));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-ircam2-t3-inspections-focus-button-"+(i-1)))).click();
			WebElement menu = driver.findElement(By.id("pii-ircam2-t2t3-newentry-ifocus-"+(i-1)+"-menu"));
			int y=2;
			if(i==4)
				y=3;
			//Select options
			int n = random.nextInt(y);
			rows.add(n);
			for(int j=0;j<n+1;j++)
			{
				String cL = menu.findElement(By.xpath(".//*[@data-option-index='"+j+"']/a")).getAttribute("class");
				if(cL.contains("ui-checkbox-off"))
					menu.findElement(By.xpath(".//*[@data-option-index='"+j+"']/a")).click();
			}
			//close popup
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-newentry-ifocus-"+(i-1)+"-listbox']/div/a"))).click();
		}
		//Fill text in notes and findings
		int countRow = 0;
		for(int j=0;j<rows.size();j++)
		{
			for(int i=0;i<=rows.get(j);i++)
			{
				if(i==0){
					//Notes
					share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-tbody']/tr["+(i+countRow+1)+"]/td[3]/textarea"))));
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-tbody']/tr["+(i+countRow+1)+"]/td[3]/textarea"))).sendKeys(text);
					//Findings
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-tbody']/tr["+(i+countRow+1)+"]/td[4]/textarea"))).sendKeys("Symptoms findings SBI "+j+i);	
					symptoms.add("Symptoms findings SBI "+j+i);
				}
				else{
					//Notes
					share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-tbody']/tr["+(i+countRow+1)+"]/td[2]/textarea"))));
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-tbody']/tr["+(i+countRow+1)+"]/td[2]/textarea"))).sendKeys(text);
					//Findings
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-tbody']/tr["+(i+countRow+1)+"]/td[3]/textarea"))).sendKeys("Symptoms findings SBI "+j+i);	
					symptoms.add("Symptoms findings SBI "+j+i);
				}
			}
			countRow += rows.get(j)+1;
		}
		//Pair<type1, type2> pair =  new Pair<type1, type2>(value1, value2);
		return symptoms;
	}
	
	public List<String> addSymptomsInComprehensiveFieldInspectionSRI(WebDriver driver, String text, SoftAssertions softly, List<String>symp) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		List<String> symptoms = new ArrayList<String>();
		//SRI
		//Select randomly symptoms
		Random random = new Random();
		int num = random.nextInt(8);
		if(num==0){
			num=num+1;
		}
		//Click on button
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SystematicReliabilityInspectionButton)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SystematicReliabilityInspectionButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InspectionSymptomListPopupSRI));
		WebElement menu1 = driver.findElement(eirca.EiRCAStep2InspectionSymptomListMenuSRI);
		String cL1 = menu1.findElement(eirca.EiRCAStep2SymptomsOption1).getAttribute("class");
		if(cL1.contains("ui-checkbox-off"))
			menu1.findElement(eirca.EiRCAStep2SymptomsOption1).click();
		for(int i=1;i<num;i++)
		{
			//Click on button
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SystematicReliabilityInspectionButton)));
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SystematicReliabilityInspectionButton)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InspectionSymptomListPopupSRI));
			WebElement menu = driver.findElement(eirca.EiRCAStep2InspectionSymptomListMenuSRI);
			String cL = menu.findElement(By.xpath(".//*[@data-option-index='"+i+"']/a")).getAttribute("class");
			if(cL.contains("ui-checkbox-off"))
				menu.findElement(By.xpath(".//*[@data-option-index='"+i+"']/a")).click();
		}
		//List for counting number of rows in SRI
		List<Integer>rows = new ArrayList<Integer>();
		int lastIndexOfSBI = symp.size();		
		for(int i=1;i<=num;i++)
		{
			//Click on button for selecting inspection parameter
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-ircam2-t3-inspections-focus-button-SRI-"+(lastIndexOfSBI+i-1)))));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-ircam2-t3-inspections-focus-button-SRI-"+(lastIndexOfSBI+i-1)))).click();
			WebElement menu = driver.findElement(By.id("pii-ircam2-t2t3-newentry-ifocus-SRI-"+(lastIndexOfSBI+i-1)+"-menu"));
			int y=2;
			if(i==4)
				y=3;
			//Select options
			int n = random.nextInt(y);
			rows.add(n);
			for(int j=0;j<n+1;j++)
			{
				String cL = menu.findElement(By.xpath(".//*[@data-option-index='"+j+"']/a")).getAttribute("class");
				if(cL.contains("ui-checkbox-off"))
					menu.findElement(By.xpath(".//*[@data-option-index='"+j+"']/a")).click();
			}
			//close popup
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-newentry-ifocus-SRI-"+(lastIndexOfSBI+i-1)+"-listbox']/div/a"))).click();
		}
		//Fill text in notes and findings
		int countRow = 0;
		for(int j=0;j<rows.size();j++)
		{
			for(int i=0;i<=rows.get(j);i++)
			{
				if(i==0){
					//Notes
					share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-SRI-tbody']/tr["+(i+countRow+1)+"]/td[3]/textarea"))));
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-SRI-tbody']/tr["+(i+countRow+1)+"]/td[3]/textarea"))).sendKeys(text);
					//Findings
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-SRI-tbody']/tr["+(i+countRow+1)+"]/td[4]/textarea"))).sendKeys("Symptoms findings SRI "+j+i);	
					symptoms.add("Symptoms findings SRI "+j+i);
				}
				else{
					//Notes
					share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-SRI-tbody']/tr["+(i+countRow+1)+"]/td[2]/textarea"))));
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-SRI-tbody']/tr["+(i+countRow+1)+"]/td[2]/textarea"))).sendKeys(text);
					//Findings
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-SRI-tbody']/tr["+(i+countRow+1)+"]/td[3]/textarea"))).sendKeys("Symptoms findings SRI "+j+i);	
					symptoms.add("Symptoms findings SRI "+j+i);
				}
			}
			countRow += rows.get(j)+1;
		}
		return symptoms;
	}
	/*	
	public void verifyInspectionFocusDropdownIsCorrect(WebDriver driver, SoftAssertions softly) throws Exception {

		//Select Inspection type = SRI
		WebElement inspection = driver.findElement(eirca.EiRCAStep2CFIInspectionTypeDropdown);
		Select s = new Select(inspection);
		s.selectByValue("1");
		//Select Symptoms = Burning / Overheating
		WebElement inspection1 = driver.findElement(eirca.EiRCAStep2CFISymptomForInspectionDropdown);
		Select s1 = new Select(inspection1);
		s1.selectByValue("0");
		//Verify the values in symptoms dropdown
		List<String> inspectionFocus = inspectionFocusForBurningOverheating(driver);
		inspection = driver.findElement(eirca.EiRCAStep2CFIInspectionFocusDropdown);
		for(int i=0;i<2;i++)
		{
			String s2 = inspection.findElement(By.xpath(".//*[@value='"+i+"']")).getText();
			softly.assertThat(s2).as("test data").isIn(inspectionFocus);
		}
		inspectionFocus.clear();
		//Select Symptoms = Dust and Water
		inspection1 = driver.findElement(eirca.EiRCAStep2CFISymptomForInspectionDropdown);
		Select s1a = new Select(inspection1);
		s1a.selectByValue("1");
		//Verify the values in symptoms dropdown
		inspectionFocus.addAll(inspectionFocusForDustAndWater(driver));
		inspection = driver.findElement(eirca.EiRCAStep2CFIInspectionFocusDropdown);
		for(int i=0;i<3;i++)
		{
			String s2 = inspection.findElement(By.xpath(".//*[@value='"+i+"']")).getText();
			softly.assertThat(s2).as("test data").isIn(inspectionFocus);
		}
		inspectionFocus.clear();
		//Select Symptoms = Electronic and Electrical Equipment
		inspection1 = driver.findElement(eirca.EiRCAStep2CFISymptomForInspectionDropdown);
		Select s1b = new Select(inspection1);
		s1b.selectByValue("2");
		//Verify the values in symptoms dropdown
		inspectionFocus.addAll(inspectionFocusForElectronicAndElectricalEquipment(driver));
		inspection = driver.findElement(eirca.EiRCAStep2CFIInspectionFocusDropdown);
		for(int i=0;i<6;i++)
		{
			String s2 = inspection.findElement(By.xpath(".//*[@value='"+i+"']")).getText();
			softly.assertThat(s2).as("test data").isIn(inspectionFocus);
		}
		inspectionFocus.clear();
		//Select Symptoms = EM Near Field
		inspection1 = driver.findElement(eirca.EiRCAStep2CFISymptomForInspectionDropdown);
		Select s1c = new Select(inspection1);
		s1c.selectByValue("3");
		//Verify the values in symptoms dropdown
		inspectionFocus.addAll(inspectionFocusForEMNearField(driver));
		inspection = driver.findElement(eirca.EiRCAStep2CFIInspectionFocusDropdown);
		for(int i=0;i<3;i++)
		{
			String s2 = inspection.findElement(By.xpath(".//*[@value='"+i+"']")).getText();
			softly.assertThat(s2).as("test data").isIn(inspectionFocus);
		}
		inspectionFocus.clear();
		//Select Symptoms = Leak/Drain related
		inspection1 = driver.findElement(eirca.EiRCAStep2CFISymptomForInspectionDropdown);
		Select s1d = new Select(inspection1);
		s1d.selectByValue("4");
		//Verify the values in symptoms dropdown
		inspectionFocus.addAll(inspectionFocusForLeakDrainRelated(driver));
		inspection = driver.findElement(eirca.EiRCAStep2CFIInspectionFocusDropdown);
		for(int i=0;i<5;i++)
		{
			String s2 = inspection.findElement(By.xpath(".//*[@value='"+i+"']")).getText();
			softly.assertThat(s2).as("test data").isIn(inspectionFocus);
		}
		inspectionFocus.clear();
		//Select Symptoms = Vibration Related
		inspection1 = driver.findElement(eirca.EiRCAStep2CFISymptomForInspectionDropdown);
		Select s1e = new Select(inspection1);
		s1e.selectByValue("5");
		//Verify the values in symptoms dropdown
		inspectionFocus.addAll(inspectionFocusForVibrationRelated(driver));
		inspection = driver.findElement(eirca.EiRCAStep2CFIInspectionFocusDropdown);
		for(int i=0;i<5;i++)
		{
			String s2 = inspection.findElement(By.xpath(".//*[@value='"+i+"']")).getText();
			softly.assertThat(s2).as("test data").isIn(inspectionFocus);
		}
		inspectionFocus.clear();
		//Select Symptoms = Wear and Tear
		inspection1 = driver.findElement(eirca.EiRCAStep2CFISymptomForInspectionDropdown);
		Select s1f = new Select(inspection1);
		s1f.selectByValue("6");
		//Verify the values in symptoms dropdown
		inspectionFocus.addAll(inspectionFocusForWearAndTear(driver));
		inspection = driver.findElement(eirca.EiRCAStep2CFIInspectionFocusDropdown);
		for(int i=0;i<5;i++)
		{
			String s2 = inspection.findElement(By.xpath(".//*[@value='"+i+"']")).getText();
			softly.assertThat(s2).as("test data").isIn(inspectionFocus);
		}
		inspectionFocus.clear();
		//Select Inspection type = Sense Based Inspection
		inspection = driver.findElement(eirca.EiRCAStep2CFIInspectionTypeDropdown);
		Select sa = new Select(inspection);
		sa.selectByValue("0");
		//Select Symptoms = Abnormal Configuration
		inspection1 = driver.findElement(eirca.EiRCAStep2CFISymptomForInspectionDropdown);
		Select s1g = new Select(inspection1);
		s1g.selectByValue("0");
		//Verify the values in symptoms dropdown
		inspectionFocus.addAll(inspectionFocusForAbnormalConfiguration(driver));
		inspection = driver.findElement(eirca.EiRCAStep2CFIInspectionFocusDropdown);
		for(int i=0;i<2;i++)
		{
			String s2 = inspection.findElement(By.xpath(".//*[@value='"+i+"']")).getText();
			softly.assertThat(s2).as("test data").isIn(inspectionFocus);
		}
		inspectionFocus.clear();
		//Select Symptoms =  Abnormal Noises
		inspection1 = driver.findElement(eirca.EiRCAStep2CFISymptomForInspectionDropdown);
		Select s1h = new Select(inspection1);
		s1h.selectByValue("1");
		//Verify the values in symptoms dropdown
		inspectionFocus.addAll(inspectionFocusForAbnormalNoises(driver));
		inspection = driver.findElement(eirca.EiRCAStep2CFIInspectionFocusDropdown);
		for(int i=0;i<2;i++)
		{
			String s2 = inspection.findElement(By.xpath(".//*[@value='"+i+"']")).getText();
			softly.assertThat(s2).as("test data").isIn(inspectionFocus);
		}
		inspectionFocus.clear();
		//Select Symptoms = Abnormal Smell
		inspection1 = driver.findElement(eirca.EiRCAStep2CFISymptomForInspectionDropdown);
		Select s1i = new Select(inspection1);
		s1i.selectByValue("2");
		//Verify the values in symptoms dropdown
		inspectionFocus.addAll(inspectionFocusForAbnormalSmell(driver));
		inspection = driver.findElement(eirca.EiRCAStep2CFIInspectionFocusDropdown);
		for(int i=0;i<2;i++)
		{
			String s2 = inspection.findElement(By.xpath(".//*[@value='"+i+"']")).getText();
			softly.assertThat(s2).as("test data").isIn(inspectionFocus);
		}
		inspectionFocus.clear();
		//Select Symptoms = Crack/Wear/Pitting
		inspection1 = driver.findElement(eirca.EiRCAStep2CFISymptomForInspectionDropdown);
		Select s1j = new Select(inspection1);
		s1j.selectByValue("3");
		//Verify the values in symptoms dropdown
		inspectionFocus.addAll(inspectionFocusForCrackWearPitting(driver));
		inspection = driver.findElement(eirca.EiRCAStep2CFIInspectionFocusDropdown);
		for(int i=0;i<3;i++)
		{
			String s2 = inspection.findElement(By.xpath(".//*[@value='"+i+"']")).getText();
			softly.assertThat(s2).as("test data").isIn(inspectionFocus);
		}
		inspectionFocus.clear();
		//Select Symptoms = Discoloration
		inspection1 = driver.findElement(eirca.EiRCAStep2CFISymptomForInspectionDropdown);
		Select s1k = new Select(inspection1);
		s1k.selectByValue("4");
		//Verify the values in symptoms dropdown
		inspectionFocus.addAll(inspectionFocusForDiscoloration(driver));
		inspection = driver.findElement(eirca.EiRCAStep2CFIInspectionFocusDropdown);
		for(int i=0;i<2;i++)
		{
			String s2 = inspection.findElement(By.xpath(".//*[@value='"+i+"']")).getText();
			softly.assertThat(s2).as("test data").isIn(inspectionFocus);
		}
		inspectionFocus.clear();
		//Select Symptoms = Leak/Corrosion
		inspection1 = driver.findElement(eirca.EiRCAStep2CFISymptomForInspectionDropdown);
		Select s1l = new Select(inspection1);
		s1l.selectByValue("5");
		//Verify the values in symptoms dropdown
		inspectionFocus.addAll(inspectionFocusForLeakCorrosion(driver));
		inspection = driver.findElement(eirca.EiRCAStep2CFIInspectionFocusDropdown);
		for(int i=0;i<2;i++)
		{
			String s2 = inspection.findElement(By.xpath(".//*[@value='"+i+"']")).getText();
			softly.assertThat(s2).as("test data").isIn(inspectionFocus);
		}
		inspectionFocus.clear();
	}*/

	public List<String> inspectionFocusForLeakCorrosion(WebDriver driver) throws Exception {

		List<String> inspectionFocus = new ArrayList<String>();
		inspectionFocus.add("Corrosion marks in pipe insulation");
		inspectionFocus.add("Water pool underneath pipe");
		return inspectionFocus;
	}

	public List<String> inspectionFocusForDiscoloration(WebDriver driver) throws Exception {

		List<String> inspectionFocus = new ArrayList<String>();
		inspectionFocus.add("Chemical reactions");
		inspectionFocus.add("Over-heating in loose terminals");
		return inspectionFocus;
	}

	public List<String> inspectionFocusForCrackWearPitting(WebDriver driver) throws Exception {

		List<String> inspectionFocus = new ArrayList<String>();
		inspectionFocus.add("Arcing pits");
		inspectionFocus.add("Cracking in casing, shaft or containers");
		inspectionFocus.add("Scratch marks from pipe movements");
		return inspectionFocus;
	}

	public List<String> inspectionFocusForAbnormalSmell(WebDriver driver) throws Exception {

		List<String> inspectionFocus = new ArrayList<String>();
		inspectionFocus.add("Burning of insulation polymers");
		inspectionFocus.add("Burning of lubrication oil");
		return inspectionFocus;
	}

	public List<String> inspectionFocusForAbnormalNoises(WebDriver driver) throws Exception {

		List<String> inspectionFocus = new ArrayList<String>();
		inspectionFocus.add("Ball bearing grinding");
		inspectionFocus.add("Check valve banging");
		return inspectionFocus;
	}

	public List<String> inspectionFocusForAbnormalConfiguration(WebDriver driver) throws Exception {

		List<String> inspectionFocus = new ArrayList<String>();
		inspectionFocus.add("Pipe deformation from water hammers");
		inspectionFocus.add("Sagging of pipe from inadequate support");
		return inspectionFocus;
	}

	public List<String> inspectionFocusForWearAndTear(WebDriver driver) throws Exception {

		List<String> inspectionFocus = new ArrayList<String>();
		inspectionFocus.add("Bearing lining thinning (Ultrasound)");
		inspectionFocus.add("Gasket and cable aging (Durometer)");
		inspectionFocus.add("Internal tear and wear (Endoscope, Mirror)");
		inspectionFocus.add("Pipe wall thinning (Ultrasound)");
		inspectionFocus.add("Wear patterns (Microscope)");
		return inspectionFocus;
	}

	public List<String> inspectionFocusForVibrationRelated(WebDriver driver) throws Exception {

		List<String> inspectionFocus = new ArrayList<String>();
		inspectionFocus.add("Cavitation induced vibrations (Acoustic emission)");
		inspectionFocus.add("Heat from loss of lubrication (Thermal image)");
		inspectionFocus.add("Impact noises (Acoustic emission)");
		inspectionFocus.add("Valve stem facture (Thermal image)");
		inspectionFocus.add("Vibrating components (Vibration meter)");
		return inspectionFocus;
	}

	public List<String> inspectionFocusForLeakDrainRelated(WebDriver driver) throws Exception {

		List<String> inspectionFocus = new ArrayList<String>();
		inspectionFocus.add("Cold steam traps/tanks (Thermal image)");
		inspectionFocus.add("Condenser in-leak (Acoustic emission, Smoke meter)");
		inspectionFocus.add("Heat from steam pipe leak (Thermal image)");
		inspectionFocus.add("Leaks (Acoustic emission and humidity meters)");
		inspectionFocus.add("Leak detection by smoke (Smoke meter)");
		return inspectionFocus;
	}

	public List<String> inspectionFocusForEMNearField(WebDriver driver) throws Exception {

		List<String> inspectionFocus = new ArrayList<String>();
		inspectionFocus.add("Alternating electrical field from unshielded power cable (Electric field meter)");
		inspectionFocus.add("Alternating magnetic field from welding machine (Magnetic field meter)");
		inspectionFocus.add("Gauss field (Gauss meter)");
		return inspectionFocus;
	}

	public List<String> inspectionFocusForElectronicAndElectricalEquipment(WebDriver driver) throws Exception {

		List<String> inspectionFocus = new ArrayList<String>();
		inspectionFocus.add("EMI noises from arcing (EMI meter)");
		inspectionFocus.add("Heat from arcing (Thermal image)");
		inspectionFocus.add("Heat in cables and windings (Thermal image)");
		inspectionFocus.add("Heat in circuit boards (Thermal image)");
		inspectionFocus.add("Heat in loose connections (Thermal image)");
		inspectionFocus.add("Ozone from arcing (Ozone meter)");
		return inspectionFocus;
	}

	public List<String> inspectionFocusForDustAndWater(WebDriver driver) throws Exception {

		List<String> inspectionFocus = new ArrayList<String>();
		inspectionFocus.add("Dust ingress (PM2.5)");
		inspectionFocus.add("Humidity related condensation (Humidity meter)");
		inspectionFocus.add("Internal particle generation (PM2.5 meter)");
		return inspectionFocus;
	}

	public List<String> inspectionFocusForBurningOverheating(WebDriver driver) throws Exception {

		List<String> inspectionFocus = new ArrayList<String>();
		inspectionFocus.add("Smoke dust (PM2.5 meter)");
		inspectionFocus.add("Total organic volatile (TVOC meter)");
		return inspectionFocus;
	}

	public List<String> symptomsForInspectionForSenseBasedInspection(WebDriver driver) throws Exception {

		List<String> symptoms = new ArrayList<String>();
		symptoms.add("Abnormal configuration");
		symptoms.add("Abnormal noises");
		symptoms.add("Abnormal smell");
		symptoms.add("Crack/Wear/Pitting");
		symptoms.add("Discoloration");
		symptoms.add("Leak/Corrosion");
		return symptoms;
	}

	public List<String> symptomsForInspectionForSystematicReliabilityInspection(WebDriver driver) throws Exception {

		List<String> symptoms = new ArrayList<String>();
		symptoms.add("Burning/Overheating");
		symptoms.add("Dust and water");
		symptoms.add("Electronic and electrical equipment");
		symptoms.add("EM near field");
		symptoms.add("Leak/Drain related");
		symptoms.add("Vibration related");
		symptoms.add("Wear and tear");
		return symptoms;
	}
	/*
	public void verifySymptomDropdownIsCorrect(WebDriver driver, SoftAssertions softly) throws Exception {

		//Select Inspection type = Sense Based Inspection
		WebElement inspection = driver.findElement(eirca.EiRCAStep2CFIInspectionTypeDropdown);
		Select s = new Select(inspection);
		s.selectByValue("0");
		//Verify the values in symptoms dropdown
		List<String> symptoms = symptomsForInspectionForSenseBasedInspection(driver);
		inspection = driver.findElement(eirca.EiRCAStep2CFISymptomForInspectionDropdown);
		for(int i=0;i<6;i++)
		{
			String s1 = inspection.findElement(By.xpath(".//*[@value='"+i+"']")).getText();
			softly.assertThat(s1).as("test data").isIn(symptoms);
		}
		//Select Inspection type = Systematic Reliability Inspection
		WebElement inspection1 = driver.findElement(eirca.EiRCAStep2CFIInspectionTypeDropdown);
		Select s1 = new Select(inspection1);
		s1.selectByValue("1");
		//Verify the values in symptoms dropdown
		List<String> symptoms1 = symptomsForInspectionForSystematicReliabilityInspection(driver);
		inspection = driver.findElement(eirca.EiRCAStep2CFISymptomForInspectionDropdown);
		for(int i=0;i<7;i++)
		{
			String s1a = inspection.findElement(By.xpath(".//*[@value='"+i+"']")).getText();
			softly.assertThat(s1a).as("test data").isIn(symptoms1);
		}
	}

	public void verifySymptomInspectionDropdownEmpty(WebDriver driver, SoftAssertions softly) throws Exception {

		//Verify inspection type has values
		WebElement inspection = driver.findElement(eirca.EiRCAStep2CFIInspectionTypeDropdown);
		for(int i=0;i<2;i++)
		{
			inspection.findElement(By.xpath(".//*[@value='"+i+"']"));
		}
		//Verify symptom dropdown is empty
		inspection = driver.findElement(eirca.EiRCAStep2CFISymptomForInspectionDropdown);
		try{
			inspection.findElement(By.xpath(".//*[@value='0']"));
			softly.fail("Symptom for inspection dropdown not empty: "+inspection.findElement(By.xpath(".//*[@value='0']")).getText());
		}catch(org.openqa.selenium.NoSuchElementException e)
		{

		}
		//Verify inspection focus dropdown is empty
		inspection = driver.findElement(eirca.EiRCAStep2CFIInspectionFocusDropdown);	
		try{
			inspection.findElement(By.xpath(".//*[@value='0']"));
			softly.fail("Inspection focus dropdown not empty: "+inspection.findElement(By.xpath(".//*[@value='0']")).getText());
		}catch(org.openqa.selenium.NoSuchElementException e)
		{

		}
	}*/
}
