package kaleTestSoftware;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class HiRCALevel2Chinese {

	public String text = "HiRCA Level 2 Chinese";
	SoftAssertions softly = new SoftAssertions();
	
	HiRCAFunctionsForLevel1_2_3 hfl123 = new HiRCAFunctionsForLevel1_2_3();
	HiRCAChinese5 hc5 = new HiRCAChinese5();
	HiRCAChinese6 hc6 = new HiRCAChinese6();
	HiRCAChinese17 hc17 = new HiRCAChinese17();
	HiRCAChinese18 hc18 = new HiRCAChinese18();
	HiRCAChinese19 hc19 = new HiRCAChinese19();
	HiRCAChinese20 hc20 = new HiRCAChinese20();
	HiRCAChinese21 hc21 = new HiRCAChinese21();
	HiRCAChinese31 hc31 = new HiRCAChinese31();
	HiRCAChinese33 hc33 = new HiRCAChinese33();
	HiRCAChinese34 hc34 = new HiRCAChinese34();
	HiRCAChinese35 hc35 = new HiRCAChinese35();
	HiRCAChinese39 hc39 = new HiRCAChinese39();
	ShareCheck share = new ShareCheck();
	ShareCheck2 share2 = new ShareCheck2();
	HiRCAObj hirca = new HiRCAObj();
	HiRCALOPBug2 hlb2 = new HiRCALOPBug2 ();

	public void pathHiRCALevel2(WebDriver driver) throws Exception{

		HiRCALevel2 obj3 = new HiRCALevel2();
		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Hashmaps for storing notes and answers
		MultiValuedMap<String,String> hircaNoteLopSURE = new ArrayListValuedHashMap<>();
		//create a new report
		hlb2.fillUpHiRCAEventInfo(driver, text);
		//Select3LOPs means 1. select "Act of Nature" and "Yes + random options"
		List<String> lopSelected = select3LOPs(driver);
		//Select answers for 1st lop
		Pair<MultiValuedMap<String,String>, List<String>> pairOfReturnVariables1 = answerLOPRelatedQuestions(driver);
		List<String> level21stLOP = obj3.level2List(pairOfReturnVariables1.getValue());
		List<String> level31stLOP = obj3.level3List(pairOfReturnVariables1.getValue()).stream().distinct().collect(Collectors.toList());
		//Click next
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//Select answers for 2nd lop
		Pair<MultiValuedMap<String,String>, List<String>> pairOfReturnVariables2 = answerLOPRelatedQuestions(driver);
		List<String> level22ndLOP = obj3.level2List(pairOfReturnVariables2.getValue());
		List<String> level32ndLOP = obj3.level3List(pairOfReturnVariables2.getValue()).stream().distinct().collect(Collectors.toList());
		//Click next
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//Select answers for 3rd lop
		Pair<MultiValuedMap<String,String>, List<String>> pairOfReturnVariables3 = answerLOPRelatedQuestions(driver);
		List<String> level23rdLOP = obj3.level2List(pairOfReturnVariables3.getValue());
		List<String> level33rdLOP = obj3.level3List(pairOfReturnVariables3.getValue()).stream().distinct().collect(Collectors.toList());
		//Click next
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//Verify 2.20
		chineseQ220(driver);
		//2.20 - make some selections and click next
		List<String> list220 = selectAllLevel3(driver,12).stream().distinct().collect(Collectors.toList());
		//Click next
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//2.22 - skip
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		//Step 3 skip
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		/*Step 4 / Step 5 / Report/ pdf
		0=english
		1=chinese
		*/
		hircaNoteLopSURE.putAll(pairOfReturnVariables1.getKey());
		hircaNoteLopSURE.putAll(pairOfReturnVariables2.getKey());
		hircaNoteLopSURE.putAll(pairOfReturnVariables3.getKey());
		obj3.verifyRemainingSteps(driver,lopSelected,level31stLOP,level32ndLOP,level33rdLOP,level21stLOP,level22ndLOP,level23rdLOP,list220,1,hircaNoteLopSURE,softly);
	}
	
	public Pair<MultiValuedMap<String,String>, List<String>> answerLOPRelatedQuestions(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		OPiRCA2 obj = new OPiRCA2();
		HiRCALevel2 obj1 = new HiRCALevel2();
		List<String> combined = new ArrayList<String>();
		List<String> level2 = new ArrayList<String>();
		List<String> level3 = new ArrayList<String>();
		//Hashmaps for storing notes and answers
		MultiValuedMap<String,String> hircaNoteLopSURE = new ArrayListValuedHashMap<>();
		//2.1
		//Choose option to select
		int n = obj.chooseRandomOption(2, 0); //n=0 > Yes, n=1 > No
		Thread.sleep(1000);
		//Add answer to list
		chineseStep2q21(driver); //chineseStep2Q21: assert pagetext, yes and no
		Thread.sleep(5000);
		level2.add(obj1.selectLevel2Answer(driver,n)); //chineseStep2Q21: add Yes or No answer to list
		//Get note
		String note = hfl123.getNoteShowingPreviousAnswer(driver); //print chineseStep2Q21 Yes or No answer 
		if(n==0) //n=0 > select Yes
		{
			//Click next
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
			//Select random level 3 answers for 3.17
			hc33.chineseStepOneL317(driver, softly);
//			chineseStep2verify317(driver, softly);
			level3.addAll(selectAllLevel3(driver,7));
			//Join the list with the note for SURE
			hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note, level3));
			combined.addAll(level2);
			combined.addAll(level3);
			//To return the Pair of List<String> and MultiValuedMap<String,String>
		return new MutablePair<MultiValuedMap<String,String>, List<String>>(hircaNoteLopSURE, combined);
		}
		//Click next
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		
		/*am_tempt
		//2.2
		//Choose option to select
		n = obj.chooseRandomOption(3, 0);
		//Add answer to list
		chineseStep2q22(driver);
		level2.add(obj1.selectLevel2Answer(driver,n));
		//get note
		String note1 = hfl123.getNoteShowingPreviousAnswer(driver);
		*/

		/*am_n==0 > will connect to L317
		if(n==0)
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.16
			hc31.chineseStepOneL316(driver, softly);
			level3.addAll(selectAllLevel3(driver,7));
			hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note, level3));
			/*if((wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText().contains("LOP 1/3"))&&(driver.getCurrentUrl().contains("kaleqa")==false))
			{
				combined.addAll(level2);
				combined.addAll(level3);
				return combined;
			}
			else
			{*/
				//Click next
//am_tempt		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
				//2.3 to 2.8
//am_tempt		Pair<MultiValuedMap<String,String>, List<String>> pairOfReturnVariables = followQuestions23To28(driver);
//am_tempt		level2.addAll(obj1.level2List(pairOfReturnVariables.getValue()));
//am_tempt		level3.addAll(obj1.level3List(pairOfReturnVariables.getValue()));
//am_tempt		hircaNoteLopSURE.putAll(pairOfReturnVariables.getKey());
		//	}
//		}
		
		if(n==1)//n==1 > select No
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			
			//////am_added
			//2.2
			//Choose option to select
			int ss = obj.chooseRandomOption(3, 0);
			//Add answer to list
			chineseStep2q22(driver);
			level2.add(obj1.selectLevel2Answer(driver,ss)); //.//*[@for='efi-irca-answer-"+n+"']
			//get note
			String note2 = hfl123.getNoteShowingPreviousAnswer(driver);
			if(ss==0 || ss==3) {
				//Click next
				jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
				
				//Select random level 3 answers for 3.16
				hc31.chineseStepOneL316(driver, softly);
				level3.addAll(selectAllLevel3(driver,7));
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note, level3));
			}	
			if(ss==1) {
				//Click next
				jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
				//2.3 (remove 2.4-2.8)
				Pair<MultiValuedMap<String,String>, List<String>> pairOfReturnVariables = followQuestions23To28(driver);
				level2.addAll(obj1.level2List(pairOfReturnVariables.getValue()));
				level3.addAll(obj1.level3List(pairOfReturnVariables.getValue()));
				hircaNoteLopSURE.putAll(pairOfReturnVariables.getKey());
			}
			if(ss==2) {
				//Click next
				jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
				
			//2.9 to 2.12
			Pair<MultiValuedMap<String,String>, List<String>> pairOfReturnVariables = followQuestions29To212(driver);
			level2.addAll(obj1.level2List(pairOfReturnVariables.getValue()));
			level3.addAll(obj1.level3List(pairOfReturnVariables.getValue()));
			hircaNoteLopSURE.putAll(pairOfReturnVariables.getKey());
			//////am_added
			
			/*am_not applicable
			//2.3 to 2.8
			Pair<MultiValuedMap<String,String>, List<String>> pairOfReturnVariables = followQuestions23To28(driver);
			level2.addAll(obj1.level2List(pairOfReturnVariables.getValue()));
			level3.addAll(obj1.level3List(pairOfReturnVariables.getValue()));
			hircaNoteLopSURE.putAll(pairOfReturnVariables.getKey());*/
			}
		}
		/*am_no n==2
		if(n==2)
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//2.9 to 2.12
			Pair<MultiValuedMap<String,String>, List<String>> pairOfReturnVariables = followQuestions29To212(driver);
			level2.addAll(obj1.level2List(pairOfReturnVariables.getValue()));
			level3.addAll(obj1.level3List(pairOfReturnVariables.getValue()));
			hircaNoteLopSURE.putAll(pairOfReturnVariables.getKey());
		}*/
		
		combined.addAll(level2);
		combined.addAll(level3);
		//To return the Pair of List<String> and MultiValuedMap<String,String>
		return new MutablePair<MultiValuedMap<String,String>, List<String>>(hircaNoteLopSURE, combined);
	}
	
	public Pair<MultiValuedMap<String,String>, List<String>> followQuestions29To212(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		OPiRCA2 obj = new OPiRCA2();
		HiRCALevel2 obj1 = new HiRCALevel2();
		List<String> combined = new ArrayList<String>();
		List<String> level2 = new ArrayList<String>();
		List<String> level3 = new ArrayList<String>();
		//Hashmaps for storing notes and answers
		MultiValuedMap<String,String> hircaNoteLopSURE = new ArrayListValuedHashMap<>();
		//2.9
		//Choose option to select
		int n = obj.chooseRandomOption(2, 0);
		//Add answer to list
		chineseStep2q29(driver);
		level2.add(obj1.selectLevel2Answer(driver,n));
		//Get note
		String note = hfl123.getNoteShowingPreviousAnswer(driver);
		if(n==0) //n==0, select Yes
		{
			//Click next
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.12
			hc35.chineseStepOneL312(driver, softly);
			level3.addAll(selectAllLevel3(driver,5));			
			//Join the list with the note for SURE
			hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note, level3));	
		}
		//Click next
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//2.10
		//Choose option to select
		n = obj.chooseRandomOption(2, 0);
		//Add answer to list
		chineseStep2q210(driver);
		level2.add(obj1.selectLevel2Answer(driver,n));
		//Get note
		String note1 = hfl123.getNoteShowingPreviousAnswer(driver);
		if(n==0)
		{
			//Click next
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.13
			hc17.chineseStepOneL313(driver, softly);
			List<String> lopOptions = selectAllLevel3(driver,4);			
			level3.addAll(lopOptions);	
			//Join the list with the note for SURE
			hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note1, lopOptions));
		}
		//Click next
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//2.11
		//Choose option to select
		n = obj.chooseRandomOption(2, 0);
		//Add answer to list
		chineseStep2q211(driver);
		level2.add(obj1.selectLevel2Answer(driver,n));
		//Get note
		String note2 = hfl123.getNoteShowingPreviousAnswer(driver);
		if(n==0)
		{
			//Click next
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.14
			hc17.chineseStepOneL314(driver, softly);
			List<String> lopOptions = selectAllLevel3(driver,5);		
			level3.addAll(lopOptions);	
			//Join the list with the note for SURE
			hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note2, lopOptions));	
		}
		//Click next
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//2.12
		//Choose option to select
		n = obj.chooseRandomOption(2, 0);
		//Add answer to list
		chineseStep2q212(driver);
		level2.add(obj1.selectLevel2Answer(driver,n));
		//Get note
		String note3 = hfl123.getNoteShowingPreviousAnswer(driver);
		if(n==0)
		{
			//Click next
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.15
			hc39.chineseStepOneL315(driver, softly);
			List<String> lopOptions = selectAllLevel3(driver,4);			
			level3.addAll(lopOptions);	
			//Join the list with the note for SURE
			hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note3, lopOptions));
		}
		combined.addAll(level2);
		combined.addAll(level3);
		//To return the Pair of List<String> and MultiValuedMap<String,String>
		return new MutablePair<MultiValuedMap<String,String>, List<String>>(hircaNoteLopSURE, combined);
	}
	
	public Pair<MultiValuedMap<String,String>, List<String>> followQuestions23To28(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		OPiRCA2 obj = new OPiRCA2();
		HiRCALevel2 obj1 = new HiRCALevel2();
		List<String> combined = new ArrayList<String>();
		List<String> level2 = new ArrayList<String>();
		List<String> level3 = new ArrayList<String>();
		//Hashmaps for storing notes and answers
		MultiValuedMap<String,String> hircaNoteLopSURE = new ArrayListValuedHashMap<>();
		//2.3
		//Choose option to select
		int n = obj.chooseRandomOption(3, 0);
		//Add answer to list
		chineseStep2q23(driver);
		level2.add(obj1.selectLevel2Answer(driver,n));
		//Get note
		String note = hfl123.getNoteShowingPreviousAnswer(driver);
		if(n==0)
		{
			//Click next
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.6
			hc21.chineseStepOneL36(driver, softly);
			level3.addAll(selectAllLevel3(driver,9));			
			//Join the list with the note for SURE
			hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note, level3));	
		}
		if(n==1)
		{
			//Click next
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.22
			hc18.chineseStepOneL322(driver, softly);
			level3.addAll(selectAllLevel3(driver,5));
			//Join the list with the note for SURE
			hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note, level3));	
		}
		if(n==2) {
			//Click next
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.6
			hc21.chineseStepOneL36(driver, softly);
			level3.addAll(selectAllLevel3(driver,9));			
			//Join the list with the note for SURE
			hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note, level3));	
			//Click next
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.22
			hc18.chineseStepOneL322(driver, softly);
			level3.addAll(selectAllLevel3(driver,5));
			//Join the list with the note for SURE
			hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note, level3));	
		}
		/*if((wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText().contains("LOP 1/3"))&&(driver.getCurrentUrl().contains("kaleqa")==false))
		{
			combined.addAll(level2);
			combined.addAll(level3);
			return combined;
		}
		else
		{*/
		//Click next
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//}
		//2.4
		//Choose option to select
		n = obj.chooseRandomOption(2, 0);
		//Add answer to list
		chineseStep2q24(driver);
		level2.add(obj1.selectLevel2Answer(driver,n));
		//Get note
		String note1 = hfl123.getNoteShowingPreviousAnswer(driver);
		if(n==0)
		{
			//Click next
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.7
			hc19.chineseStepOneL37(driver, softly);
			List<String> lopOptions = selectAllLevel3(driver,10);			
			level3.addAll(lopOptions);	
			//Join the list with the note for SURE
			hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note1, lopOptions));	
		}
		//Click next
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//2.5
		//Choose option to select
		n = obj.chooseRandomOption(2, 0);
		//Add answer to list
		chineseStep2q25(driver);
		level2.add(obj1.selectLevel2Answer(driver,n));
		//Get note
		String note2 = hfl123.getNoteShowingPreviousAnswer(driver);
		if(n==0)
		{
			//Click next
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.8
			hc20.chineseStepOneL38(driver, softly);
			List<String> lopOptions = selectAllLevel3(driver,8);			
			level3.addAll(lopOptions);	
			//Join the list with the note for SURE
			hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note2, lopOptions));		
		}
		//Click next
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//2.6
		//Choose option to select
		n = obj.chooseRandomOption(2, 0);
		//Add answer to list
		chineseStep2q26(driver);
		level2.add(obj1.selectLevel2Answer(driver,n));
		//Get note
		String note3 = hfl123.getNoteShowingPreviousAnswer(driver);
		if(n==0)
		{
			//Click next
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.9
			hc39.chineseStepOneL39(driver, softly);
			List<String> lopOptions = selectAllLevel3(driver,6);			
			level3.addAll(lopOptions);	
			//Join the list with the note for SURE
			hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note3, lopOptions));		
		}
		//Click next
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//2.7
		//Choose option to select
		n = obj.chooseRandomOption(2, 0);
		//Add answer to list
		chineseStep2q27(driver);
		level2.add(obj1.selectLevel2Answer(driver,n));
		//Get note
		String note4 = hfl123.getNoteShowingPreviousAnswer(driver);
		if(n==0)
		{
			//Click next
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.10
			hc6.chineseStepOneL310(driver, softly);
			List<String> lopOptions = selectAllLevel3(driver,5);			
			level3.addAll(lopOptions);	
			//Join the list with the note for SURE
			hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note4, lopOptions));		
		}
		//Click next
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//2.8
		//Choose option to select
		n = obj.chooseRandomOption(2, 0);
		//Add answer to list
		chineseStep2q28(driver);
		level2.add(obj1.selectLevel2Answer(driver,n));
		//Get note
		String note5 = hfl123.getNoteShowingPreviousAnswer(driver);
		if(n==0)
		{
			//Click next
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.11
			hc6.chineseStepOneL311(driver, softly);
			List<String> lopOptions = selectAllLevel3(driver,5);			
			level3.addAll(lopOptions);	
			//Join the list with the note for SURE
			hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note5, lopOptions));			
		}
		
		combined.addAll(level2);
		combined.addAll(level3);
		//To return the Pair of List<String> and MultiValuedMap<String,String>
		return new MutablePair<MultiValuedMap<String,String>, List<String>>(hircaNoteLopSURE, combined);
	}
	
	public List<String> selectAllLevel3(WebDriver driver, int count) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		List<String> ac = new ArrayList<String>();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		outer:
			for(int j=1;j<=count;j++)
			{
				//Select any answer between 1 and count
				//Choose a number between 1 and count
				WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+(j+1)+"]/fieldset/div/div/input")));
				if(e.isSelected())
				{
					ac.add(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+(j+1)+"]/fieldset/div/div/label"))).getText());
					continue outer;
				}					
				//Click on answer
				WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+(j+1)+"]/fieldset/div/div/label")));
				//Scroll to element
				share2.scrollToElement(driver, l);
				executor.executeScript("arguments[0].focus();", l);
				executor.executeScript("arguments[0].click();", l);
				//Get answer name and store in list
				String s1 = l.getText();
				ac.add(s1);	
			}
		//Scroll to top
		share2.scrollToTop(driver);
		return ac;		
	}
	
	public List<String> select3LOPs(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,60);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		List<String> a = new ArrayList<String>();
		//Click on Act of nature
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Click on LOP
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		Thread.sleep(2000);
		//Click on Yes
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-lopinplace-yes']"))).click();
		Thread.sleep(2000);
		//Verify Step 2 question 1
		chinesestep2Q20(driver);
		//Select 3 LOPs randomly
		//Choose a number between 2 and 13 for LOPs
		Random random = new Random();
		int y;
		for(int i=0;i<3;i++)
		{
			while(true)
			{
				y=random.nextInt(9);
				//System.out.println("Chose a no"+y);
				if(y==0||y==1)
					continue;
				String e=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))).getAttribute("class");
				if(e.contains("ui-checkbox-on"))
					continue;
				break;
			}
			//System.out.println("Picked a no");
			//System.out.println("Option no: "+y);
			Thread.sleep(500);
			//Scroll to element
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))));
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))));
			//Click on LOP
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))));
			a.add(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))).getText());
		}
		//Scroll to the top
		share2.scrollToTop(driver);
		//Click next
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		return a;
	}
	
	public void chineseQ220(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();
		softly.assertThat(s).as("test data").contains("[2.20] ??????????????????????????????????????????????????????:");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("?????????????????????????????????????????????????????????????????????");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Answers - LOPs
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("???????????????????????????????????????");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("?????????");
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("????????????");
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("????????????");
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer5)).getText();
		softly.assertThat(s5).as("test data").isEqualTo("????????????");
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer6)).getText();
		softly.assertThat(s6).as("test data").isEqualTo("?????????????????????????????????????????????");
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer7)).getText();
		softly.assertThat(s7).as("test data").isEqualTo("????????????????????????????????????????????????");
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer8)).getText();
		softly.assertThat(s8).as("test data").isEqualTo("????????????");
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer9)).getText();
		softly.assertThat(s9).as("test data").isEqualTo("??????");
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer10)).getText();
		softly.assertThat(s10).as("test data").isEqualTo("??????");
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer11)).getText();
		softly.assertThat(s11).as("test data").isEqualTo("????????????");
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer12)).getText();
		softly.assertThat(s12).as("test data").contains("??????:");
	}
	
	public void chineseStep2q212 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("?????????????????????????????? - ?????? ");
		//2.12 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.12] ??????????????????????????????????????????????????????");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("???????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("????????????:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("?????????????????????");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("???");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("???");
	}
	
	public void chineseStep2q211 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("?????????????????????????????? - ?????? ");
		//2.11 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.11] ?????????????????????????????????????????????????????????");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("????????????:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("?????????????????????");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("???");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("???");
	}
	
	public void chineseStep2q210 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("?????????????????????????????? - ?????? ");
		//2.10 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.10] ??????????????????????????????????????????????????????");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("?????????????????????????????????????????????????????????????????????????????????????????????????????????PJB????????????????????????????????????????????????????????????????????????????????????????????????");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("????????????:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("?????????????????????");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("???");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("???");
	}
	
	public void chineseStep2q29 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("?????????????????????????????? - ?????? ");
		//2.9 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.9] ??????????????????????????????????????????????????????");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("??????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("????????????:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("?????????????????????");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("???");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("???");
	}
	
	public void chineseStep2q28 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("?????????????????????????????? - ?????? ");
		//2.8 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.8] ??????????????????????????????????????????");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("?????????????????????????????????????????????????????????????????????????????????????????????????????????");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("????????????:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("?????????????????????");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("???");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("???");
	}
	
	public void chineseStep2q27 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("?????????????????????????????? - ?????? ");
		//2.7 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.7] ????????????????????????????????????????????????");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("???????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("????????????:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("?????????????????????");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("???");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("???");
	}
	
	public void chineseStep2q26 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("?????????????????????????????? - ?????? ");
		//2.6 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.6] ??????????????????????????????????????????");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("????????????:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("?????????????????????");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("???");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("???");
	}
	
	public void chineseStep2q25 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("?????????????????????????????? - ?????? ");
		//2.5 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.5] ???????????????????????????????????????????????????");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("???????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("????????????:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("?????????????????????");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("???");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("???");
	}
	
	public void chineseStep2q24 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("?????????????????????????????? - ?????? ");
		//2.4 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.4] ????????????????????????????????????????????????");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("???????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("????????????:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("?????????????????????");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("???");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("???");
	}
	
	public void chineseStep2q23 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("?????????????????????????????? - ?????? ");
		//2.3 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.3] ???????????????????????????????????????????????????????????????");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????\"??????\"??????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("????????????:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("?????????????????????");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("???????????????");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("????????????");
	}
	
	public void chineseStep2q22 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("?????????????????????????????? - ?????? ");
		//2.2 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.2] ?????????????????????????????????????????????????????????????????????????????????");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("????????????????????????????????????????????????????????????????????????????????????????????????");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("????????????:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("?????????????????????");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("????????????");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("????????????????????????????????????");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)).getText();
		softly.assertThat(ans3).as("test data").contains("??????");
	}
	
	public void chineseStep2q21 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("?????????????????????????????? - ?????? ");
		//2.1 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.1] ???????????????????????????????????????");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("??????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("????????????:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("?????????????????????");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("???");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("???");
	}	

	public void chinesestep2Q20(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		HiRCALevel2Text obj1 = new HiRCALevel2Text();
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("??????????????????????????????");
		//Question before 2.0
		String q11a = wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.PageQuestionBefore20)).getText();		
		softly.assertThat(q11a).as("test data").contains("???????????????????????????????????????????????????");
		//Description
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.DescriptionPlusSignBefore20)).click();
		String descTab = wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.DescriptionPlusSignBefore20)).getText();
		softly.assertThat(descTab).as("test data").contains("??????");
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.DescriptionTextBefore20)).getText();
		softly.assertThat(lop3).as("test data").contains("???????????????????????????????????????????????????????????????????????????????????????????????????????????????");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.DescriptionPlusSignBefore20)).click();
		//Verify Yes 
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.AnswerYes)).getText();		
		softly.assertThat(ans1).as("test data").contains("???");
		//Verify No
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.AnswerNo)).getText();		
		softly.assertThat(ans2).as("test data").contains("???");
		//2.0 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.0] ????????????????????????????????????????????????(??????3???)???");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("????????????:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("?????????????????????");
		//Answer 1
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans3).as("test data").contains("???????????????????????????????????????");
		//Answer 2
		String ans4 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans4).as("test data").contains("?????????");
		//Answer 3
		String ans5 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)).getText();
		softly.assertThat(ans5).as("test data").contains("????????????");
		//Answer 1
		String ans6 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4)).getText();		
		softly.assertThat(ans6).as("test data").contains("????????????");
		//Answer 2
		String ans7 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer5)).getText();		
		softly.assertThat(ans7).as("test data").contains("????????????");
		//Answer 3
		String ans8 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer6)).getText();
		softly.assertThat(ans8).as("test data").contains("?????????????????????????????????????????????");
		//Answer 1
		String ans9 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer7)).getText();		
		softly.assertThat(ans9).as("test data").contains("????????????????????????????????????????????????");
		//Answer 2
		String ans10 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer8)).getText();		
		softly.assertThat(ans10).as("test data").contains("????????????");
		//Answer 3
		String ans11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer9)).getText();
		softly.assertThat(ans11).as("test data").contains("??????");
		//Answer 1
		String ans12 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer10)).getText();		
		softly.assertThat(ans12).as("test data").contains("??????");
		//Answer 2
		String ans13 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer11)).getText();		
		softly.assertThat(ans13).as("test data").contains("????????????");
		//Answer 3
		String ans14 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer12)).getText();
		softly.assertThat(ans14).as("test data").contains("??????:");
	}
	
	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}
}
