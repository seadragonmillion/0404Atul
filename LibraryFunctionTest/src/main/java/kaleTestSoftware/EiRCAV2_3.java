package kaleTestSoftware;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EiRCAV2_3 {

	//EiRCA2 eirca2 = new EiRCA2();
	ShareCheck2 share2 = new ShareCheck2();
	ShareCheck share = new ShareCheck();
	EiRCAV2PageObj eirca = new EiRCAV2PageObj();

	public String textStep2 = "Sanity test for EiRCA v2 Step 2 tabs";
	public String textStep2WithNextLine = textStep2+"\n"+textStep2;

	public List<String> EiRCAStep2 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Enter text in DOOMS Tab
		List<String> symptoms = doomsTab(driver,textStep2WithNextLine);
		//Verify no <br> in text boxes
		verifyNobrInDOOMSTextBoxes(driver,softly);
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
		}
		//Add interviews in Interview Tab
		interviews(driver,textStep2,softly);
		share2.scrollToTop(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
		return symptoms;
	}
	
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
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DOOMSDesignDataTextbox1)).getAttribute("value");
		softly.assertThat(s1).as("test data").doesNotContain("<br>");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DOOMSDesignDataTextbox2)).getAttribute("value");
		softly.assertThat(s2).as("test data").doesNotContain("<br>");
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DOOMSDesignDataTextbox3)).getAttribute("value");
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
	}
	
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
	}

	public List<String> doomsTab(WebDriver driver, String text) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		List<String> symptoms = new ArrayList<String>();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DOOMSTab)).click();
		//Fill text in Design data
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DOOMSDesignDataTextbox1)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DOOMSDesignDataTextbox2)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DOOMSDesignDataTextbox3)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DOOMSDesignDataTextbox4)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DOOMSDesignDataTextbox5)).sendKeys(text);
		//Operating practice and condition data
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DOOMSOperatingPracticeTextbox1)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DOOMSOperatingPracticeTextbox2)).sendKeys(text);
		//operating experience
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DOOMSOperatingExperienceTextbox1)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DOOMSOperatingExperienceTextbox2)).sendKeys(text);		
		//maintenance data
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DOOMSMaintenanceDataTextbox1)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DOOMSMaintenanceDataTextbox2)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DOOMSMaintenanceDataTextbox3)).sendKeys(text);		
		//symptoms
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DOOMSSymptomsTextbox1)).sendKeys("Symptom 1");
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DOOMSSymptomsTextbox2)).sendKeys("Symptom 2");
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DOOMSSymptomsTextbox3)).sendKeys("Symptom 3");		
		symptoms.add(wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DOOMSSymptomsTextbox1)).getText());
		symptoms.add(wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DOOMSSymptomsTextbox2)).getText());
		symptoms.add(wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DOOMSSymptomsTextbox3)).getText());
		return symptoms;
	}

	public void deltaDOOMSTab(WebDriver driver, String text, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DeltaDOOMSTab)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DeltaDOOMSTab)).click();
		//Verify the note on top including *
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DeltaDOOMSNoteForTable)).getText();
		softly.assertThat(s).as("test data").isEqualTo("*Note: Similar components are the same components as the failure component in other trains, channels, or paths that are designed to perform redundant functions.");
		//Fill text in Failure Component
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DeltaDOOMSFailureComponentTextbox1)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DeltaDOOMSFailureComponentTextbox2)).sendKeys(text);
		//Non-Failure Similar Components
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DeltaDOOMSNonFailureSimilarComponentTextbox1)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DeltaDOOMSNonFailureSimilarComponentTextbox2)).sendKeys(text);
		//Non-Failure Components with Similar Functions
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DeltaDOOMSNonFailureComponentSimilarFunctionTextbox1)).sendKeys(text);
	}

	public List<String> comprehensiveFieldInspection(WebDriver driver, String text, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		List<String> inspectionsAndDetailsAll = new ArrayList<String>();
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2ComprehensiveFieldInspectionTab)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2ComprehensiveFieldInspectionTab)).click();
		verifySymptomInspectionDropdownEmpty(driver,softly);
		verifySymptomDropdownIsCorrect(driver,softly);
		verifyInspectionFocusDropdownIsCorrect(driver,softly);
		//Add 5 inspections
		addInspections(driver);
		addInspections(driver);
		addInspections(driver);
		addInspections(driver);
		addInspections(driver);
		//Fill inspection notes and symptoms
		//1
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2CFIInspectionTableRow1InspectionNotes)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2CFIInspectionTableRow1SymptomFindings)).sendKeys("Symptom to be deleted");
		//2
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2CFIInspectionTableRow2InspectionNotes)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2CFIInspectionTableRow2SymptomFindings)).sendKeys("Symptom 4");
		//3
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2CFIInspectionTableRow3InspectionNotes)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2CFIInspectionTableRow3SymptomFindings)).sendKeys("Symptom 5");
		//4
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2CFIInspectionTableRow4InspectionNotes)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2CFIInspectionTableRow4SymptomFindings)).sendKeys("Symptom 6");
		//5
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2CFIInspectionTableRow5InspectionNotes)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2CFIInspectionTableRow5SymptomFindings)).sendKeys("Symptom 7");
		//Delete 1st inspection
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2CFIInspectionTableRow1DeleteButton)).click();
		//Verify popup question
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupTitle)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Are you sure you want to delete the following inspection:");
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupConfirmButton)).click();
		//Verify data selected in dropdown is visible in table
		inspectionsAndDetailsAll.addAll(joinDataInInspectionTable(driver));
		return inspectionsAndDetailsAll;
	}

	public List<String> joinDataInInspectionTable(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		List<String> inspectionsAndDetailsAll = new ArrayList<String>();
		inspectionsAndDetailsAll.add(wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2CFIInspectionTableRow1ComprehensiveFieldInspection)).getText());
		inspectionsAndDetailsAll.add(wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2CFIInspectionTableRow1SymptomForInspection)).getText());
		inspectionsAndDetailsAll.add(wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2CFIInspectionTableRow1InspectionFocus)).getText());
		inspectionsAndDetailsAll.add(wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2CFIInspectionTableRow1InspectionNotes)).getAttribute("textcontent"));
		inspectionsAndDetailsAll.add(wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2CFIInspectionTableRow1SymptomFindings)).getAttribute("textcontent"));
		inspectionsAndDetailsAll.add(wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2CFIInspectionTableRow2ComprehensiveFieldInspection)).getText());
		inspectionsAndDetailsAll.add(wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2CFIInspectionTableRow2SymptomForInspection)).getText());
		inspectionsAndDetailsAll.add(wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2CFIInspectionTableRow2InspectionFocus)).getText());
		inspectionsAndDetailsAll.add(wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2CFIInspectionTableRow2InspectionNotes)).getAttribute("textcontent"));
		inspectionsAndDetailsAll.add(wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2CFIInspectionTableRow2SymptomFindings)).getAttribute("textcontent"));
		inspectionsAndDetailsAll.add(wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2CFIInspectionTableRow3ComprehensiveFieldInspection)).getText());
		inspectionsAndDetailsAll.add(wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2CFIInspectionTableRow3SymptomForInspection)).getText());
		inspectionsAndDetailsAll.add(wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2CFIInspectionTableRow3InspectionFocus)).getText());
		inspectionsAndDetailsAll.add(wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2CFIInspectionTableRow3InspectionNotes)).getAttribute("textcontent"));
		inspectionsAndDetailsAll.add(wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2CFIInspectionTableRow3SymptomFindings)).getAttribute("textcontent"));
		inspectionsAndDetailsAll.add(wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2CFIInspectionTableRow4ComprehensiveFieldInspection)).getText());
		inspectionsAndDetailsAll.add(wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2CFIInspectionTableRow4SymptomForInspection)).getText());
		inspectionsAndDetailsAll.add(wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2CFIInspectionTableRow4InspectionFocus)).getText());
		inspectionsAndDetailsAll.add(wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2CFIInspectionTableRow4InspectionNotes)).getAttribute("textcontent"));
		inspectionsAndDetailsAll.add(wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2CFIInspectionTableRow4SymptomFindings)).getAttribute("textcontent"));
		return inspectionsAndDetailsAll;
	}

	public void addInspections(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		Random random = new Random();
		//Select Inspection type
		int index = random.nextInt(2);
		WebElement inspection = driver.findElement(eirca.EiRCAStep2CFIInspectionTypeDropdown);
		Select s = new Select(inspection);
		s.selectByValue(""+index+"");
		int index1;
		if(index==0)
			index1 = random.nextInt(6);
		else
			index1 = random.nextInt(7);
		inspection = driver.findElement(eirca.EiRCAStep2CFISymptomForInspectionDropdown);
		Select s1 = new Select(inspection);
		s1.selectByValue(""+index1+"");
		//Get number of inspection focus
		int index2=0;
		inspection = driver.findElement(eirca.EiRCAStep2CFIInspectionFocusDropdown);
		for(int i=0;i<10;i++)
		{
			try{
				inspection.findElement(By.xpath(".//*[@value='"+i+"']"));
			}catch(org.openqa.selenium.NoSuchElementException r)
			{
				index2=i-1;
				break;
			}
		}
		//Select inspection focus
		Select s2 = new Select(inspection);
		s2.selectByValue(""+index2+"");	
		//Click on add button
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2CFIAddInspectionButton)).click();
	}

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
	}
	
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
	}
}
