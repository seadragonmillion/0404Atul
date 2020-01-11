package kaleTestSoftware;

import java.util.HashMap;
import java.util.List;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EiRCAV2_8 {

	ShareCheck2 share2 = new ShareCheck2();
	EiRCAV2PageObj eirca = new EiRCAV2PageObj();

	public void EiRCAStep10 (WebDriver driver, SoftAssertions softly, String text, int n5, List<String> step3) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
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
		for(int fm=0;fm<2;fm++)
		{
			//Click on collapsible
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-10']/div["+(fm+2)+"]/h4/a"))));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-10']/div["+(fm+2)+"]/h4/a"))).click();
			//Get name of failure mode 
			//String fmName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-10']/div["+(fm+1)+"]/h4/a/span[1]"))).getText();
			//Direct Cause
			for(int i=0;i<2;i++)
			{
				//Fill text in corrective actions
				share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t10-fm-"+(fm+startFM)+"-dc-table']/table["+(i+1)+"]/tbody/tr[1]/td[2]"))));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t10-fm-"+(fm+startFM)+"-dc-table']/table["+(i+1)+"]/tbody/tr[1]/td[2]/div/textarea[1]"))).sendKeys(text);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t10-fm-"+(fm+startFM)+"-dc-table']/table["+(i+1)+"]/tbody/tr[1]/td[2]/div/textarea[2]"))).sendKeys(text);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t10-fm-"+(fm+startFM)+"-dc-table']/table["+(i+1)+"]/tbody/tr[1]/td[2]/div/textarea[3]"))).sendKeys(text);
				//Fill text in impact analysis of corrective actions
				share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t10-fm-"+(fm+startFM)+"-dc-table']/table["+(i+1)+"]/tbody/tr[2]/td[2]"))));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t10-fm-"+(fm+startFM)+"-dc-table']/table["+(i+1)+"]/tbody/tr[2]/td[2]/div/textarea[1]"))).sendKeys(text);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t10-fm-"+(fm+startFM)+"-dc-table']/table["+(i+1)+"]/tbody/tr[2]/td[2]/div/textarea[2]"))).sendKeys(text);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t10-fm-"+(fm+startFM)+"-dc-table']/table["+(i+1)+"]/tbody/tr[2]/td[2]/div/textarea[3]"))).sendKeys(text);
			}
			//Apparent Cause
			for(int i=0;i<2;i++)
			{
				//Fill text in corrective actions
				share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t10-fm-"+(fm+startFM)+"-ac-table']/table["+(i+1)+"]/tbody/tr[1]/td[2]"))));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t10-fm-"+(fm+startFM)+"-ac-table']/table["+(i+1)+"]/tbody/tr[1]/td[2]/div/textarea[1]"))).sendKeys(text);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t10-fm-"+(fm+startFM)+"-ac-table']/table["+(i+1)+"]/tbody/tr[1]/td[2]/div/textarea[2]"))).sendKeys(text);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t10-fm-"+(fm+startFM)+"-ac-table']/table["+(i+1)+"]/tbody/tr[1]/td[2]/div/textarea[3]"))).sendKeys(text);
				//Fill text in impact analysis of corrective actions
				share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t10-fm-"+(fm+startFM)+"-ac-table']/table["+(i+1)+"]/tbody/tr[2]/td[2]"))));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t10-fm-"+(fm+startFM)+"-ac-table']/table["+(i+1)+"]/tbody/tr[2]/td[2]/div/textarea[1]"))).sendKeys(text);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t10-fm-"+(fm+startFM)+"-ac-table']/table["+(i+1)+"]/tbody/tr[2]/td[2]/div/textarea[2]"))).sendKeys(text);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t10-fm-"+(fm+startFM)+"-ac-table']/table["+(i+1)+"]/tbody/tr[2]/td[2]/div/textarea[3]"))).sendKeys(text);
			}
			//Click on collapsible
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-10']/div["+(fm+2)+"]/h4/a"))));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-10']/div["+(fm+2)+"]/h4/a"))).click();
		}
		//next
		share2.scrollToTop(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
	}

	public void verifyReportTab(WebDriver driver, SoftAssertions softly, 
			HashMap<String,String>hmStep1, HashMap<String,String> hmStep2symptomsData, HashMap<String,String> hmStep3Data, 
			HashMap<String,List<String>> hmStep3FACTSData, List<String> step4, List<String> step3, int n5) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		WebDriverWait wait1 = new WebDriverWait(driver,3);
		//Step 1
		//Event title
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ReportTabTable1EventTitle)).getText();
		String r3 = s4.replace("\u00AD", "");
		softly.assertThat(r3).as("test data").contains(hmStep1.get("Event title"));
		//Location of event
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ReportTabTable1LocationOfEvent)).getText();
		String r4 = s5.replace("\u00AD", "");
		softly.assertThat(r4).as("test data").isEqualTo(hmStep1.get("Event location"));
		//Who discovered
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ReportTabTable1WhoDiscovered)).getText();
		String r5 = s6.replace("\u00AD", "");
		softly.assertThat(r5).as("test data").isEqualTo(hmStep1.get("Event reporter"));
		//Investigators
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ReportTabTable1Investigators)).getText();
		String r6 = s7.replace("\u00AD", "");
		softly.assertThat(r6).as("test data").isEqualTo(hmStep1.get("Investigator"));
		//Reviewers
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ReportTabTable1Reviewers)).getText();
		String r7 = s8.replace("\u00AD", "");
		softly.assertThat(r7).as("test data").isEqualTo(hmStep1.get("Reviewer"));
		//Management sponsors
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ReportTabTable1ManagementSponsors)).getText();
		String r8 = s9.replace("\u00AD", "");
		softly.assertThat(r8).as("test data").isEqualTo(hmStep1.get("Sponsor"));
		//Problem Statement
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ReportTabTable1ProblemStatement)).getText();
		String r9 = s10.replace("\u00AD", "");
		softly.assertThat(r9).as("test data").isEqualTo(hmStep1.get("Problem statement"));
		//Suspected failed component
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ReportTabTable1SuspectedFailedComponent)).getText();
		String r10 = s11.replace("\u00AD", "");
		if(r10.toLowerCase().contains("other")) softly.assertThat(r10).as("test data").isEqualTo(hmStep1.get("Other suspected failed component"));
		else softly.assertThat(r10).as("test data").isEqualTo(hmStep1.get("Suspected failed component"));
		//Primary symptoms
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ReportTabTable1PrimarySymptom)).getText();
		String r11 = s12.replace("\u00AD", "");
		if(r11.toLowerCase().contains("other")) softly.assertThat(r11).as("test data").isEqualTo(hmStep1.get("Other primary symptom"));
		else softly.assertThat(r11).as("test data").isEqualTo(hmStep1.get("Primary symptom"));

		//Step 2
		//Design
		for(int i=1;i<=4;i++)
		{
			for(int j=2;j<=4;j++)
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-11']/div[3]/table/tbody/tr["+i+"]/td["+j+"]"))).getText();
				softly.assertThat(s).as("test data").isEqualTo(eirca.textStep2WithNextLine);
			}
		}
		//O
		for(int i=1;i<=3;i++)
		{
			for(int j=2;j<=4;j++)
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-11']/div[4]/table/tbody/tr["+i+"]/td["+j+"]"))).getText();
				softly.assertThat(s).as("test data").isEqualTo(eirca.textStep2WithNextLine);
			}
		}
		//O
		for(int i=1;i<=1;i++)
		{
			for(int j=2;j<=2;j++)
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-11']/div[5]/table[1]/tbody/tr["+i+"]/td["+j+"]"))).getText();
				softly.assertThat(s).as("test data").isEqualTo(eirca.textStep2WithNextLine);
			}
		}
		for(int i=1;i<=1;i++)
		{
			for(int j=2;j<=3;j++)
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-11']/div[5]/table[2]/tbody/tr["+i+"]/td["+j+"]"))).getText();
				softly.assertThat(s).as("test data").isEqualTo(eirca.textStep2WithNextLine);
			}
		}
		//M
		for(int i=1;i<=3;i++)
		{
			for(int j=2;j<=4;j++)
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-11']/div[6]/table/tbody/tr["+i+"]/td["+j+"]"))).getText();
				softly.assertThat(s).as("test data").isEqualTo(eirca.textStep2WithNextLine);
			}
		}
		//Table 5 : Symptoms
		//1
		for(int i=1;i<=3;i++)
		{
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-11']/div[7]/table/tbody/tr["+i+"]/td[2]"))).getText();
			softly.assertThat(s).as("test data").isEqualTo("Symptom "+i);
		}
		//2
		//SBI
		for (int i=1;i<=100;i++)
		{
			try{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-11']/div[7]/div[2]/table/tbody[1]/tr[1]/td[2]/table/thead/tr["+(i+1)+"]/td[5]")));
				String a1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-11']/div[7]/div[2]/table/tbody[1]/tr[1]/td[2]/table/thead/tr["+(i+1)+"]/td[1]"))).getText();
				softly.assertThat(a1).as("test data").isEqualTo(hmStep2symptomsData.get("SBI Symptom for inspection "+i));
				String a2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-11']/div[7]/div[2]/table/tbody[1]/tr[1]/td[2]/table/thead/tr["+(i+1)+"]/td[2]"))).getText();
				softly.assertThat(a2).as("test data").isEqualTo(hmStep2symptomsData.get("SBI Inspection parameter "+i));
				String a3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-11']/div[7]/div[2]/table/tbody[1]/tr[1]/td[2]/table/thead/tr["+(i+1)+"]/td[3]"))).getText();
				softly.assertThat(a3).as("test data").isEqualTo(hmStep2symptomsData.get("SBI Inspection notes "+i));
				String a4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-11']/div[7]/div[2]/table/tbody[1]/tr[1]/td[2]/table/thead/tr["+(i+1)+"]/td[4]"))).getText();
				softly.assertThat(a4).as("test data").isEqualTo(hmStep2symptomsData.get("SBI Inspection findings "+i));
			}catch(org.openqa.selenium.TimeoutException t)
			{
				try{
					String a2 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-11']/div[7]/div[2]/table/tbody[1]/tr[1]/td[2]/table/thead/tr["+(i+1)+"]/td[1]"))).getText();
					softly.assertThat(a2).as("test data").isEqualTo(hmStep2symptomsData.get("SBI Inspection parameter "+i));
					String a3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-11']/div[7]/div[2]/table/tbody[1]/tr[1]/td[2]/table/thead/tr["+(i+1)+"]/td[2]"))).getText();
					softly.assertThat(a3).as("test data").isEqualTo(hmStep2symptomsData.get("SBI Inspection notes "+i));
					String a4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-11']/div[7]/div[2]/table/tbody[1]/tr[1]/td[2]/table/thead/tr["+(i+1)+"]/td[3]"))).getText();
					softly.assertThat(a4).as("test data").isEqualTo(hmStep2symptomsData.get("SBI Inspection findings "+i));
				}catch(org.openqa.selenium.TimeoutException e)
				{
					break;
				}				
			}
		}
		//SRI
		for (int i=1;i<=100;i++)
		{
			try{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-11']/div[7]/div[2]/table/tbody[2]/tr[1]/td[2]/table/thead/tr["+(i+1)+"]/td[5]")));
				String a1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-11']/div[7]/div[2]/table/tbody[2]/tr[1]/td[2]/table/thead/tr["+(i+1)+"]/td[1]"))).getText();
				softly.assertThat(a1).as("test data").isEqualTo(hmStep2symptomsData.get("SRI Symptom for inspection "+i));
				String a2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-11']/div[7]/div[2]/table/tbody[2]/tr[1]/td[2]/table/thead/tr["+(i+1)+"]/td[2]"))).getText();
				softly.assertThat(a2).as("test data").isEqualTo(hmStep2symptomsData.get("SRI Inspection parameter "+i));
				String a3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-11']/div[7]/div[2]/table/tbody[2]/tr[1]/td[2]/table/thead/tr["+(i+1)+"]/td[3]"))).getText();
				softly.assertThat(a3).as("test data").isEqualTo(hmStep2symptomsData.get("SRI Inspection notes "+i));
				String a4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-11']/div[7]/div[2]/table/tbody[2]/tr[1]/td[2]/table/thead/tr["+(i+1)+"]/td[4]"))).getText();
				softly.assertThat(a4).as("test data").isEqualTo(hmStep2symptomsData.get("SRI Inspection findings "+i));
			}catch(org.openqa.selenium.TimeoutException t)
			{
				try{
					String a2 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-11']/div[7]/div[2]/table/tbody[2]/tr[1]/td[2]/table/thead/tr["+(i+1)+"]/td[1]"))).getText();
					softly.assertThat(a2).as("test data").isEqualTo(hmStep2symptomsData.get("SRI Inspection parameter "+i));
					String a3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-11']/div[7]/div[2]/table/tbody[2]/tr[1]/td[2]/table/thead/tr["+(i+1)+"]/td[2]"))).getText();
					softly.assertThat(a3).as("test data").isEqualTo(hmStep2symptomsData.get("SRI Inspection notes "+i));
					String a4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-11']/div[7]/div[2]/table/tbody[2]/tr[1]/td[2]/table/thead/tr["+(i+1)+"]/td[3]"))).getText();
					softly.assertThat(a4).as("test data").isEqualTo(hmStep2symptomsData.get("SRI Inspection findings "+i));
				}catch(org.openqa.selenium.TimeoutException e)
				{
					break;
				}				
			}
		}
		//Interviews
		//1
		for(int i=1;i<=2;i++)
		{
			for(int j=1;j<=2;j++)
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-11']/div[8]/div[4]/table/tbody/tr["+i+"]/td["+j+"]"))).getText();
				softly.assertThat(s).as("test data").isEqualTo(eirca.textStep2);
			}
		}
		//2
		for(int i=1;i<=2;i++)
		{
			for(int j=1;j<=2;j++)
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-11']/div[8]/div[7]/table/tbody/tr["+i+"]/td["+j+"]"))).getText();
				softly.assertThat(s).as("test data").isEqualTo(eirca.textStep2);
			}
		}
		//3
		for(int i=1;i<=2;i++)
		{
			for(int j=1;j<=2;j++)
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-11']/div[8]/div[10]/table/tbody/tr["+i+"]/td["+j+"]"))).getText();
				softly.assertThat(s).as("test data").isEqualTo(eirca.textStep2);
			}
		}
		//4
		for(int i=1;i<=2;i++)
		{
			for(int j=1;j<=2;j++)
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-11']/div[8]/div[13]/table/tbody/tr["+i+"]/td["+j+"]"))).getText();
				softly.assertThat(s).as("test data").isEqualTo(eirca.textStep2);
			}
		}

		//Step 3 
		//FACTS table
		for(int i=1;i<=step3.size();i++)
		{
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-11']/div[9]/table/tbody/tr["+i+"]/td[1]"))).getText();
			softly.assertThat(s).as("test data").isEqualTo(hmStep3Data.get("Symptoms type"+i));
			String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-11']/div[9]/table/tbody/tr["+i+"]/td[2]"))).getText();
			softly.assertThat(s1).as("test data").isEqualTo(hmStep3Data.get("Symptoms name"+i));
			String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-11']/div[9]/table/tbody/tr["+i+"]/td[5]"))).getText();
			softly.assertThat(s2).as("test data").isEqualTo(hmStep3Data.get("Implication"+i));
			List<String> f1 = hmStep3FACTSData.get("FACT "+i);
			List<String> c1 = hmStep3FACTSData.get("Char "+i);
			for(int j=0;j<f1.size();j++)
			{
				String f = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-11']/div[9]/table/tbody/tr["+i+"]/td[3]/ul/li["+(j+1)+"]"))).getText();
				softly.assertThat(f).as("test data").isEqualTo("["+(j+1)+"] "+hmStep3Data.get(f1.get(j)));
				String c = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-11']/div[9]/table/tbody/tr["+i+"]/td[4]/ul/li["+(j+1)+"]"))).getText();
				softly.assertThat(c).as("test data").isEqualTo("["+(j+1)+"] "+hmStep3Data.get(c1.get(j)));
			}
		}

		//Step 4
		int count =1;
		for(int i = 0;i<(step4.size()-3);i++)
		{
			if(count>3) break;
			String num = step4.get(i);
			System.out.println(num);
			int n = Integer.parseInt(num);
			for(int j=1;j<=n;j++)
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-11']/div[10]/table/tbody/tr["+count+"]/td[1]/ul/li["+j+"]"))).getText();
				softly.assertThat(s).as("test data").isEqualTo(step4.get(i+j));
			}
			i=i+n+1;			
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-11']/div[10]/table/tbody/tr["+count+"]/td[2]"))).getText();
			softly.assertThat(s).as("test data").isEqualTo(step4.get(i));
			String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-11']/div[10]/table/tbody/tr["+count+"]/td[3]"))).getText();
			softly.assertThat(s1).as("test data").isEqualTo(step4.get(i));
			count = count + 1;
		}
		for(int i=4;i<=step3.size();i++)
		{
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-11']/div[10]/table/tbody/tr["+i+"]/td[1]/ul/li[1]"))).getText();
			softly.assertThat(s).as("test data").isEqualTo("Symptoms (failure factor analysis)");
			String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-11']/div[10]/table/tbody/tr["+i+"]/td[2]"))).getText();
			int n = s1.indexOf("Generated from Step 3 symptoms' implications");
			softly.assertThat(s1.substring(0,n-1)).as("test data").isIn(step3);
		}
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-11']/div[10]/table/tbody/tr["+(4+step3.size())+"]/td[1]/ul/li[1]"))).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Initiation factors (failure factor analysis)");
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-11']/div[10]/table/tbody/tr["+(4+step3.size())+"]/td[2]"))).getText();
		softly.assertThat(s3).as("test data").isIn(step4.get(step4.size()-1));

		//Step 5
		if(n5>0)
		{
			//Refuted failure mode
			String f = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ReportTabStep5RefutedFailureModeTitle)).getText();
			softly.assertThat(f).as("test data").isEqualTo("Refuted failure modes:");
			String f1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ReportTabStep5RefutedFailureModeName1)).getText();
			softly.assertThat(f1).as("test data").contains("Sanity Test \"title\" Sanity1");
			String f2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ReportTabStep5RefutedFailureModeDescription1)).getText();
			softly.assertThat(f2).as("test data").contains("Sanity Test \"title\" Sanity1");
			String f3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ReportTabStep5RefutedFailureModeMethods1)).getText();
			softly.assertThat(f3).as("test data").isEqualTo("Initiation factors (failure factor analysis), Symptoms (failure factor analysis), Delta analysis, Past events");
			String f4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ReportTabStep5UnrefutedFailureModeTitle)).getText();
			softly.assertThat(f4).as("test data").isEqualTo("Un-refuted failure modes:");
			//Refuted table
			for(int i=1;i<=n5;i++)
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-11']/div[11]/table/tbody/tr["+i+"]/td[2]/strong"))).getText();
				softly.assertThat(s).as("test data").isEqualTo("Yes");
				String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-11']/div[11]/table/tbody/tr["+i+"]/td[3]"))).getText();
				softly.assertThat(s1).as("test data").isEqualTo(eirca.textEiRCAv2);
			}
		}
		else{
			String f4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ReportTabStep5UnrefutedFailureModeTitleWithNoneRefuted)).getText();
			softly.assertThat(f4).as("test data").isEqualTo("Un-refuted failure modes: ");
		}
		//List of unrefuted failure modes
		//total number of fms
		int addedFM;
		if(n5==0) {
			addedFM = 4;
		}
		else {
			addedFM = 3;
		}
		int totalFms = addedFM+step3.size();
		for(int i=1;i<=totalFms;i++)
		{
			String fm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-11']/div[11]/ol/li["+i+"]"))).getText();
			if(n5>0)
			{
				if(i==1)
					softly.assertThat(fm).as("test data").isEqualTo(eirca.textEiRCAv2+"2");
				if(i==2)
					softly.assertThat(fm).as("test data").isEqualTo(eirca.textEiRCAv2+"3");
				if(i>2 && i<totalFms) 
					softly.assertThat(fm).as("test data").isIn(step3);
			}
			else {
				if(i==1)
					softly.assertThat(fm).as("test data").isEqualTo(eirca.textEiRCAv2+"1");
				if(i==2)
					softly.assertThat(fm).as("test data").isEqualTo(eirca.textEiRCAv2+"2");
				if(i==3)
					softly.assertThat(fm).as("test data").isEqualTo(eirca.textEiRCAv2+"3");
				if(i>3 && i<totalFms) 
					softly.assertThat(fm).as("test data").isIn(step3);
			}
			if(i==totalFms)
				softly.assertThat(fm).as("test data").isEqualTo(eirca.textEiRCAv2+"4");
		}
		
		//Step 6
		
		//Step 7
		
		//Step 8
		
		//Step 9
		
		//Step 10
		
	}

}
