package kaleTestSoftware;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EiRCAV2_6 {

	EiRCAV2PageObj eirca = new EiRCAV2PageObj();
	ShareCheck2 share2 = new ShareCheck2();

	public void clickACDCCheckBox(WebDriver driver, By element) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Get checkbox clicked or not value
		int i =1;
		while(i<=10)
		{
			Thread.sleep(1000);
			String checkDC1 = wait.until(ExpectedConditions.visibilityOfElementLocated(element)).getAttribute("checked");
			System.out.println(checkDC1);
			if(checkDC1 == "true")
				wait.until(ExpectedConditions.visibilityOfElementLocated(element)).click();
			Thread.sleep(1000);
			String checkDC2 = wait.until(ExpectedConditions.visibilityOfElementLocated(element)).getAttribute("checked");
			System.out.println(checkDC2);
			if(checkDC2 == "false")
				break;
			Thread.sleep(1000);
			i=i+1;
		}
	}

	public void verifyPopupStep9NoDCAC(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//next
		share2.scrollToTop(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
		//Wait for popup
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("No Causes Added");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("No direct or apparent cause has been added");
		//Verify question on pop up
		String s1a = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopUpMessageNote)).getText();
		softly.assertThat(s1a).as("test data").isEqualTo("Please add a direct or apparent cause for the failure mode(s)");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("see report");
		//Save button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupConfirmButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("add direct or apparent cause");
		//Click add DC or AC
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupConfirmButton)).click();
	}

	public List<String> EiRCAStep9 (WebDriver driver, SoftAssertions softly, String text, int n5, List<String> step3) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		List<String> dcNames = new ArrayList<String>();
		List<String> acNames = new ArrayList<String>();
		List<String> cfNames = new ArrayList<String>();
		List<String> qualityScores = new ArrayList<String>();
		//Verify popup
		verifyPopupStep9NoDCAC(driver,softly);
		softly.assertAll();
		//total number of fms
		int addedFM;
		int startFM;
		if(n5==0) {
			addedFM = 4;
			startFM = 0;
		}
		else {
			addedFM = 3;
			startFM = 1;
		}
		int totalFms = addedFM+step3.size();
		int loopEnd;
		if(totalFms<=5)
			loopEnd=totalFms;
		else
			loopEnd = 5;
		for(int fm=0;fm<loopEnd;fm++)
		{
			//Click on collapsible
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-9']/div["+(fm+2)+"]/h4/a"))));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-9']/div["+(fm+2)+"]/h4/a"))).click();
			String sfHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-dcsof-table']/table/thead/tr[1]/th[1]"))).getText();
			softly.assertThat(sfHeading).as("test data").isEqualTo("Sequence of Failures");
			//Get name of failure mode 
			String fmName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-9']/div["+(fm+2)+"]/h4/a/span[1]"))).getText();
			//Fill direct cause twice and select
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-dcsof-table']/table/tbody/tr[1]/td[1]/textarea"))));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-dcsof-table']/table/tbody/tr[1]/td[1]/textarea"))).sendKeys(fmName+" DC 1");
			dcNames.add(fmName+" DC 1");
			Thread.sleep(1000);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-dcsof-table']/table/tbody/tr[1]/td[2]/div/input")));
			try{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-dcsof-table']/table/tbody/tr[1]/td[2]/div/input"))).click();
			}catch(org.openqa.selenium.TimeoutException t){
				driver.findElement(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-dcsof-table']/table/tbody/tr[1]/td[2]/div/input")).click();
			}
			Thread.sleep(1000);
			clickACDCCheckBox(driver,By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-dcsof-table']/table/tbody/tr[1]/td[2]/div/input"));
			/*String checkDC1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-dcsof-table']/table/tbody/tr[1]/td[2]/div/input"))).getAttribute("checked");
			System.out.println(checkDC1);
			if(checkDC1 == "true")
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-dcsof-table']/table/tbody/tr[1]/td[2]/div/input"))).click();
			}
			Thread.sleep(1000);*/
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-dcsof-table']/table/tbody/tr[2]/td[1]/textarea")));
			try{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-dcsof-table']/table/tbody/tr[2]/td[1]/textarea"))).sendKeys(fmName+" DC 2");
			}catch(org.openqa.selenium.TimeoutException t){
				try{
					driver.findElement(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-dcsof-table']/table/tbody/tr[2]/td[1]/textarea")).sendKeys(fmName+" DC 2");
				}catch(org.openqa.selenium.StaleElementReferenceException a){
					Thread.sleep(1000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-dcsof-table']/table/tbody/tr[2]/td[1]/textarea"))).sendKeys(fmName+" DC 2");
				}	
			}
			Thread.sleep(1000);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-dcsof-table']/table/tbody/tr[2]/td[2]/div/input")));
			try{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-dcsof-table']/table/tbody/tr[2]/td[2]/div/input"))).click();
			}catch(org.openqa.selenium.TimeoutException t){

			}
			Thread.sleep(1000);
			System.out.println(fm+startFM);
			clickACDCCheckBox(driver,By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-dcsof-table']/table/tbody/tr[2]/td[2]/div/input"));
			/*WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-dcsof-table']/table/tbody/tr[2]/td[2]/div/input")));
			String checkDC = ele.getAttribute("checked");
			System.out.println(checkDC);
			if(checkDC == "true")
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-dcsof-table']/table/tbody/tr[2]/td[2]/div/input"))).click();
			}
			Thread.sleep(1000);*/
			//Fill apparent cause twice and select
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-acsoe-table']/table/tbody/tr[1]/td[1]/textarea"))));
			String seHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-acsoe-table']/table/thead/tr[1]/th[1]"))).getText();
			softly.assertThat(seHeading).as("test data").isEqualTo("Sequence of Events");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-acsoe-table']/table/tbody/tr[1]/td[1]/textarea"))).sendKeys(fmName+" AC 1");
			Thread.sleep(1000);
			acNames.add(fmName+" AC 1");
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-acsoe-table']/table/tbody/tr[1]/td[2]/div/input")));
			try{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-acsoe-table']/table/tbody/tr[1]/td[2]/div/input"))).click();
			}catch(org.openqa.selenium.TimeoutException t){
				Thread.sleep(1000);
				driver.findElement(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-acsoe-table']/table/tbody/tr[1]/td[2]/div/input")).click();
			}
			clickACDCCheckBox(driver,By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-acsoe-table']/table/tbody/tr[1]/td[2]/div/input"));
			/*Thread.sleep(1000);
			String checkAC = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-acsoe-table']/table/tbody/tr[1]/td[2]/div/input"))).getAttribute("checked");
			System.out.println(checkAC);
			if(checkAC == "true")
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-acsoe-table']/table/tbody/tr[1]/td[2]/div/input"))).click();
			}
			Thread.sleep(1000);*/
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-acsoe-table']/table/tbody/tr[2]/td[1]/textarea")));
			try{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-acsoe-table']/table/tbody/tr[2]/td[1]/textarea"))).sendKeys(fmName+" AC 2");
			}catch(org.openqa.selenium.TimeoutException t){
				try{
					driver.findElement(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-acsoe-table']/table/tbody/tr[2]/td[1]/textarea")).sendKeys(fmName+" AC 2");
				}catch(org.openqa.selenium.StaleElementReferenceException a){
					Thread.sleep(1000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-acsoe-table']/table/tbody/tr[2]/td[1]/textarea"))).sendKeys(fmName+" AC 2");
				}	
			}
			cfNames.add(fmName+" AC 2");
			cfNames.add(fmName+" DC 2");
			Thread.sleep(1000);
			try{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-acsoe-table']/table/tbody/tr[2]/td[2]/div/input"))).click();
			}catch(org.openqa.selenium.StaleElementReferenceException t){
				Thread.sleep(1000);
				driver.findElement(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-acsoe-table']/table/tbody/tr[2]/td[2]/div/input")).click();
			}
			clickACDCCheckBox(driver,By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-acsoe-table']/table/tbody/tr[2]/td[2]/div/input"));
			/*Thread.sleep(1000);
			String checkAC1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-acsoe-table']/table/tbody/tr[2]/td[2]/div/input"))).getAttribute("checked");
			System.out.println(checkAC1);
			if(checkAC1 == "true")
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-acsoe-table']/table/tbody/tr[2]/td[2]/div/input"))).click();
			}*/
			//Direct Cause
			for(int i=0;i<2;i++)
			{
				//Select SUEP for 1st one
				share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-dcqc-table']/table["+(i+1)+"]/tbody/tr[1]/td[1]"))));
				try{
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-ircam2-t9-qdc"+(fm+startFM)+"-"+i+"-1']"))).click();
				}catch(org.openqa.selenium.TimeoutException t){
					driver.findElement(By.xpath(".//*[@for='pii-ircam2-t9-qdc"+(fm+startFM)+"-"+i+"-1']")).click();
				}
				try{
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-ircam2-t9-qdc"+(fm+startFM)+"-"+i+"-2']"))).click();
				}catch(org.openqa.selenium.TimeoutException t){
					driver.findElement(By.xpath(".//*[@for='pii-ircam2-t9-qdc"+(fm+startFM)+"-"+i+"-2']")).click();
				}
				if(i==0)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-ircam2-t9-qdc"+(fm+startFM)+"-"+i+"-3']"))).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-ircam2-t9-qdc"+(fm+startFM)+"-"+i+"-4']"))).click();
				}
				//Fill text
				share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-dcqc-table']/table["+(i+1)+"]/tbody/tr[2]/td[2]"))));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-dcqc-table']/table["+(i+1)+"]/tbody/tr[2]/td[2]/div/textarea[1]"))).sendKeys(text);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-dcqc-table']/table["+(i+1)+"]/tbody/tr[2]/td[2]/div/textarea[2]"))).sendKeys(text);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-dcqc-table']/table["+(i+1)+"]/tbody/tr[2]/td[2]/div/textarea[3]"))).sendKeys(text);
				//Select quality score
				int countQScore = 0;
				for(int j=0;j<10;j++)
				{
					Random random = new Random();
					int n = random.nextInt(4);
					if(n==0) 
						continue;
					share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-ircam2-t9-fm"+(fm+startFM)+"-tdc-c"+i+"-q"+j+"-radio"+(n-1)+"']"))));
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-ircam2-t9-fm"+(fm+startFM)+"-tdc-c"+i+"-q"+j+"-radio"+(n-1)+"']"))).click();
					if(n != 2) countQScore += 1;
					WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-dcqc-table']/table["+(i+1)+"]")));
					String s = l.findElement(By.className("pii-ircam2-t9-fm-qc-score")).getText();
					softly.assertThat(s).as("test data").isEqualTo(String.valueOf(countQScore*10));
				}
				qualityScores.add(String.valueOf(countQScore*10));
			}
			//Apparent Cause
			for(int i=0;i<2;i++)
			{
				//Select SUEP for 1st one
				share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-acqc-table']/table["+(i+1)+"]/tbody/tr[1]/td[2]"))));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-ircam2-t9-qac"+(fm+startFM)+"-"+i+"-1']"))).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-ircam2-t9-qac"+(fm+startFM)+"-"+i+"-2']"))).click();
				if(i==0)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-ircam2-t9-qac"+(fm+startFM)+"-"+i+"-3']"))).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-ircam2-t9-qac"+(fm+startFM)+"-"+i+"-4']"))).click();
				}
				//Fill text
				share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-acqc-table']/table["+(i+1)+"]/tbody/tr[2]/td[2]"))));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-acqc-table']/table["+(i+1)+"]/tbody/tr[2]/td[2]/div/textarea[1]"))).sendKeys(text);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-acqc-table']/table["+(i+1)+"]/tbody/tr[2]/td[2]/div/textarea[2]"))).sendKeys(text);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-acqc-table']/table["+(i+1)+"]/tbody/tr[2]/td[2]/div/textarea[3]"))).sendKeys(text);
				//Select quality score
				int countQScore = 0;
				for(int j=0;j<10;j++)
				{
					Random random = new Random();
					int n = random.nextInt(4);
					if(n==0) 
						continue;
					share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-ircam2-t9-fm"+(fm+startFM)+"-tac-c"+i+"-q"+j+"-radio"+(n-1)+"']"))));
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-ircam2-t9-fm"+(fm+startFM)+"-tac-c"+i+"-q"+j+"-radio"+(n-1)+"']"))).click();
					if(n != 2) countQScore += 1;
					WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-acqc-table']/table["+(i+1)+"]")));
					String s = l.findElement(By.className("pii-ircam2-t9-fm-qc-score")).getText();
					softly.assertThat(s).as("test data").isEqualTo(String.valueOf(countQScore*10));
				}
				qualityScores.add(String.valueOf(countQScore*10));
			}
			//Click on collapsible to close
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-9']/div["+(fm+2)+"]/h4/a"))));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-9']/div["+(fm+2)+"]/h4/a"))).click();
			try{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-dcsof-table']/table/tbody/tr[1]/td[1]/textarea")));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-9']/div["+(fm+2)+"]/h4/a"))).click();				
			}catch(org.openqa.selenium.TimeoutException t){

			}
		}
		//next
		share2.scrollToTop(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
		dcNames.addAll(acNames);
		dcNames.addAll(cfNames);
		dcNames.addAll(qualityScores);
		return (dcNames);
	}

	public HashMap<String,String> getStep1Data(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		HashMap<String,String> hm = new HashMap<String,String>();
		String ev1 = driver.findElement(eirca.EiRCAEventTitleField).getAttribute("value");
		String ev2 = driver.findElement(eirca.EiRCAEventLocationField).getAttribute("value");
		String ev3 = driver.findElement(eirca.EiRCAEventReporterField).getAttribute("value");
		String ev4 = driver.findElement(eirca.EiRCAEventInvestigatorField).getAttribute("value");
		String ev5 = driver.findElement(eirca.EiRCAEventReviewerField).getAttribute("value");
		String ev6 = driver.findElement(eirca.EiRCAEventSponsorField).getAttribute("value");
		String ev7= driver.findElement(eirca.EiRCAEventProblemStatementField).getAttribute("value");
		hm.put("Event title", ev1);
		hm.put("Event location", ev2);
		hm.put("Event reporter", ev3);
		hm.put("Investigator", ev4);
		hm.put("Reviewer", ev5);
		hm.put("Sponsor", ev6);
		hm.put("Problem statement", ev7);
		//Get 1.2 selected answer
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep1Q12AnswerSelected)).getText();
		if(s.contains("Other")){
			String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep1Q12AnswerTextBox)).getAttribute("value");
			hm.put("Other suspected failed component", s+": "+s1);
		}
		else hm.put("Suspected failed component", s);
		//Get 1.3 selected answer
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep1Q13AnswerSelected)).getText();
		if(s1.contains("Other")){
			String s1a = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep1Q13AnswerTextBox)).getAttribute("value");
			hm.put("Other primary symptom", s1+": "+s1a);
		}
		else hm.put("Primary symptom", s1);
		return hm;
	}

	public HashMap<String,String> getStep2SymptomsData(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		HashMap<String,String> hm = new HashMap<String,String>();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SymptomsTab)).click();
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		//SBI
		WebElement sbiTbody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-ircam2-t2t3-inspections-table-tbody")));
		List<WebElement> sbiRows= sbiTbody.findElements(By.tagName("tr"));
		for(int i=1;i<=sbiRows.size();i++)
		{
			WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-tbody']/tr["+i+"]/td[1]")));
			List<WebElement> buttonInsList= l.findElements(By.cssSelector(".pii-ircam2-focus-button"));
			if(buttonInsList.size()>0){
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-tbody']/tr["+i+"]/td[1]/button"))).getText();
				hm.put("SBI Symptom for inspection "+i, s);
			}else
			{
				String idTd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-tbody']/tr["+i+"]/td[1]"))).getAttribute("id");
				//try{
				//String idTd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-tbody']/tr["+i+"]/td[1]"))).getAttribute("id");
				if(idTd.contains("pii-ircam2-t2t3-ifocus-selected"))
				{
					String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-tbody']/tr["+i+"]/td[1]"))).getText();
					hm.put("SBI Inspection parameter "+i, s1);
					System.out.println("*****");
					System.out.println(i + ": "+s1);
				}
				/*}catch(org.openqa.selenium.TimeoutException e){
					break;
				}*/
			}
			String idTd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-tbody']/tr["+i+"]/td[2]"))).getAttribute("id");
			if(idTd.contains("pii-ircam2-t2t3-ifocus-selected"))
			{
				String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-tbody']/tr["+i+"]/td[2]"))).getText();
				hm.put("SBI Inspection parameter "+i, s1);
			}
			else
			{
				String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-tbody']/tr["+i+"]/td[2]/textarea"))).getAttribute("value");
				hm.put("SBI Inspection notes "+i, s1);
				String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-tbody']/tr["+i+"]/td[3]/textarea"))).getAttribute("value");
				hm.put("SBI Inspection findings "+i, s2);
			}
			String idTd1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-tbody']/tr["+i+"]/td[3]"))).getAttribute("id");
			if(idTd1.contains("pii-ircam2-t2t3-inotes-td"))
			{
				String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-tbody']/tr["+i+"]/td[3]/textarea"))).getText();
				hm.put("SBI Inspection notes "+i, s1);
				String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-tbody']/tr["+i+"]/td[4]/textarea"))).getAttribute("value");
				hm.put("SBI Inspection findings "+i, s2);
			}			
		}
		//SRI
		WebElement sriTbody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-ircam2-t2t3-inspections-table-SRI-tbody")));
		List<WebElement> sriRows= sriTbody.findElements(By.tagName("tr"));
		for(int i=1;i<=sriRows.size();i++)
		{
			WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-SRI-tbody']/tr["+i+"]/td[1]")));
			List<WebElement> buttonInsList= l.findElements(By.cssSelector(".pii-ircam2-focus-SRI-button"));
			if(buttonInsList.size()>0){
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-SRI-tbody']/tr["+i+"]/td[1]/button"))).getText();
				hm.put("SRI Symptom for inspection "+i, s);
			}//else
			//{
			List<WebElement> buttonIfocusList= l.findElements(By.id("pii-ircam2-t2t3-ifocus-SRI-selected"));
			//try{
			//String idTd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-SRI-tbody']/tr["+i+"]/td[1]"))).getAttribute("id");
			if(buttonIfocusList.size()>0)
			{
				String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-SRI-tbody']/tr["+i+"]/td[1]"))).getText();
				hm.put("SRI Inspection parameter "+i, s1);
			}
			/*}catch(org.openqa.selenium.TimeoutException e){
					break;
				}*/
			//}
			String idTd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-SRI-tbody']/tr["+i+"]/td[2]"))).getAttribute("id");
			if(idTd.contains("pii-ircam2-t2t3-ifocus-SRI-selected"))
			{
				String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-SRI-tbody']/tr["+i+"]/td[2]"))).getText();
				hm.put("SRI Inspection parameter "+i, s1);
			}
			else
			{
				String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-SRI-tbody']/tr["+i+"]/td[2]/textarea"))).getAttribute("value");
				hm.put("SRI Inspection notes "+i, s1);
				String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-SRI-tbody']/tr["+i+"]/td[3]/textarea"))).getAttribute("value");
				hm.put("SRI Inspection findings "+i, s2);
			}
			String idTd1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-SRI-tbody']/tr["+i+"]/td[3]"))).getAttribute("id");
			if(idTd1.contains("pii-ircam2-t2t3-inotes-SRI-td"))
			{
				String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-SRI-tbody']/tr["+i+"]/td[3]/textarea"))).getText();
				hm.put("SRI Inspection notes "+i, s1);
				String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-SRI-tbody']/tr["+i+"]/td[4]/textarea"))).getAttribute("value");
				hm.put("SRI Inspection findings "+i, s2);
			}			
		}
		System.out.println(hm);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		share2.scrollToTop(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
		return hm;
	}

	public HashMap<String,String> getStep3Data(WebDriver driver, List<String> step3) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		HashMap<String,String> hm = new HashMap<String,String>();
		for(int i=1;i<=step3.size();i++)
		{
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr["+i+"]/td[1]"))).getText();
			hm.put("Symptoms type"+i, s);
			String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr["+i+"]/td[2]"))).getText();
			hm.put("Symptoms name"+i, s1);
			String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr["+i+"]/td[5]/textarea"))).getAttribute("value");
			hm.put("Implication"+i, s2);
		}
		return hm;
	}

	public HashMap<String,List<String>> getStep3FACTSCharaceristicsData(WebDriver driver, List<String> step3) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		HashMap<String,List<String>> hm = new HashMap<String,List<String>>();
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		for(int i=1;i<=step3.size();i++)
		{
			List<String> f1 = new ArrayList<String>();
			List<String> c1 = new ArrayList<String>();
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr["+i+"]/td[3]/button"))).getText();
			f1.add(s);
			WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr["+i+"]/td[3]")));
			List<WebElement> divList = l.findElements(By.id("pii-fact-display-button"));			
			for(int j=1;j<=divList.size();j++)
			{
				//try{
				String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr["+i+"]/td[3]/div[2]/button["+j+"]"))).getText();
				f1.add(s1);
				/*}catch(org.openqa.selenium.TimeoutException r)
				{
					break;
				}*/
			}
			for(int j=1;j<=f1.size();j++)
			{
				//try{
				String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr["+i+"]/td[4]/div["+j+"]/div/span"))).getText();
				c1.add(s1);
				/*}catch(org.openqa.selenium.TimeoutException r)
				{
					break;
				}*/
			}
			hm.put("FACT "+i,f1);
			hm.put("Char "+i,c1);
		}
		System.out.println(hm);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		share2.scrollToTop(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
		return hm;
	}

}
