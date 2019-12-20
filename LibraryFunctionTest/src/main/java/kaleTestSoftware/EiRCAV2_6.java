package kaleTestSoftware;

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

	public void EiRCAStep9 (WebDriver driver, SoftAssertions softly, String text, int n5, List<String> step3) throws Exception {

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
		for(int fm=0;fm<totalFms;fm++)
		{
			//Click on collapsible
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-9']/div["+(fm+2)+"]/h4/a"))));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-9']/div["+(fm+2)+"]/h4/a"))).click();
			//Get name of failure mode 
			String fmName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-9']/div["+(fm+2)+"]/h4/a/span[1]"))).getText();
			//Fill direct cause twice and select
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-dcsof-table']/table/tbody/tr[1]/td[1]/textarea"))));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-dcsof-table']/table/tbody/tr[1]/td[1]/textarea"))).sendKeys(fmName+" DC 1");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-dcsof-table']/table/tbody/tr[1]/td[2]/div/input"))).click();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-dcsof-table']/table/tbody/tr[2]/td[1]/textarea"))).sendKeys(fmName+" DC 2");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-dcsof-table']/table/tbody/tr[2]/td[2]/div/input"))).click();
			//Fill apparent cause twice and select
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-acsoe-table']/table/tbody/tr[1]/td[1]/textarea"))));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-acsoe-table']/table/tbody/tr[1]/td[1]/textarea"))).sendKeys(fmName+" AC 1");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-acsoe-table']/table/tbody/tr[1]/td[2]/div/input"))).click();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-acsoe-table']/table/tbody/tr[2]/td[1]/textarea"))).sendKeys(fmName+" AC 2");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-acsoe-table']/table/tbody/tr[2]/td[2]/div/input"))).click();
			//Direct Cause
			for(int i=0;i<2;i++)
			{
				//Select SUEP for 1st one
				share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t9-fm-"+(fm+startFM)+"-dcqc-table']/table["+(i+1)+"]/tbody/tr[1]/td[1]"))));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-ircam2-t9-qdc"+(fm+startFM)+"-"+i+"-1']"))).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-ircam2-t9-qdc"+(fm+startFM)+"-"+i+"-2']"))).click();
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
		}
		//next
		share2.scrollToTop(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
	}
	
}
