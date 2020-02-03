package kaleTestSoftware;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

	public List<String> EiRCAStep9 (WebDriver driver, SoftAssertions softly, String text, int n5, List<String> step3) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		List<String>dcNames = new ArrayList<String>();
		List<String>acNames = new ArrayList<String>();
		List<String>cfNames = new ArrayList<String>();
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
				for(int j=0;j<10;j++)
				{
					Random random = new Random();
					int n = random.nextInt(4);
					if(n==0) 
						continue;
					share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-ircam2-t9-fm"+(fm+startFM)+"-tdc-c"+i+"-q"+j+"-radio"+(n-1)+"']"))));
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-ircam2-t9-fm"+(fm+startFM)+"-tdc-c"+i+"-q"+j+"-radio"+(n-1)+"']"))).click();
				}
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
				for(int j=0;j<10;j++)
				{
					Random random = new Random();
					int n = random.nextInt(4);
					if(n==0) 
						continue;
					share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-ircam2-t9-fm"+(fm+startFM)+"-tac-c"+i+"-q"+j+"-radio"+(n-1)+"']"))));
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-ircam2-t9-fm"+(fm+startFM)+"-tac-c"+i+"-q"+j+"-radio"+(n-1)+"']"))).click();
				}
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
		//SBI
		for(int i=1;i<=100;i++)
		{
			try{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-tbody']/tr["+i+"]/td[1]/button"))).getText();
				hm.put("SBI Symptom for inspection "+i, s);
			}catch(org.openqa.selenium.TimeoutException r)
			{
				try{
					String idTd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-tbody']/tr["+i+"]/td[1]"))).getAttribute("id");
					if(idTd.contains("pii-ircam2-t2t3-ifocus-selected"))
					{
						String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-tbody']/tr["+i+"]/td[1]"))).getText();
						hm.put("SBI Inspection parameter "+i, s1);
					}
				}catch(org.openqa.selenium.TimeoutException e){
					break;
				}
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
		for(int i=1;i<=100;i++)
		{
			try{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-SRI-tbody']/tr["+i+"]/td[1]/button"))).getText();
				hm.put("SRI Symptom for inspection "+i, s);
			}catch(org.openqa.selenium.TimeoutException r)
			{
				try{
					String idTd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-SRI-tbody']/tr["+i+"]/td[1]"))).getAttribute("id");
					if(idTd.contains("pii-ircam2-t2t3-ifocus-SRI-selected"))
					{
						String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-SRI-tbody']/tr["+i+"]/td[1]"))).getText();
						hm.put("SRI Inspection parameter "+i, s1);
					}
				}catch(org.openqa.selenium.TimeoutException e){
					break;
				}
			}
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
		for(int i=1;i<=step3.size();i++)
		{
			List<String> f1 = new ArrayList<String>();
			List<String> c1 = new ArrayList<String>();
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr["+i+"]/td[3]/button"))).getText();
			f1.add(s);
			for(int j=1;j<=15;j++)
			{
				try{
					String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr["+i+"]/td[3]/div[2]/button["+j+"]"))).getText();
					f1.add(s1);
				}catch(org.openqa.selenium.TimeoutException r)
				{
					break;
				}
			}
			for(int j=1;j<=15;j++)
			{
				try{
					String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t3-symptoms-table']/tbody/tr["+i+"]/td[4]/div["+j+"]/div/span"))).getText();
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
		share2.scrollToTop(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
		return hm;
	}

}
