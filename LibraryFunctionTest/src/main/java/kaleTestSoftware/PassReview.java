package kaleTestSoftware;

import java.util.Iterator;
import java.util.List;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.Iterables;


public class PassReview {
	SoftAssertions softly = new SoftAssertions();
	ErrorMeter2 em2 = new ErrorMeter2 ();
	ErrorMeter3 em3 = new ErrorMeter3 ();
	OPiRCAPageObj opirca = new OPiRCAPageObj();
	TextBoxResizing tbr = new TextBoxResizing ();
	EiRCAPageObj eirca = new EiRCAPageObj();
	EiRCA2 eirca2 = new EiRCA2();
	ShareCheck2 share2 = new ShareCheck2();
	ShareCheck share = new ShareCheck();
	ShareCheck3 share3 = new ShareCheck3();
	LoginPageObj lpo = new LoginPageObj();
	PassReviewPageObj pr = new PassReviewPageObj();
	PassReview2 pr2 = new PassReview2();
	HiRCAObj hc = new HiRCAObj();
	LanguageCheckOfReports lcr = new LanguageCheckOfReports();

	public void pass1Tab(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		List<String> textList = em2.error100Data(driver,driver.getCurrentUrl());
		Iterator<String> iter = Iterables.cycle(textList).iterator();
		//Fill text in Requirement
		tbr.sizeCheck(driver, pr.Pass1RequirementText,softly);
		if(iter.hasNext()) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(pr.Pass1RequirementText)).sendKeys(iter.next());
		}
		tbr.sizeCheck(driver, pr.Pass1OperatingText,softly);
		//Operating mode
		if(iter.hasNext()) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(pr.Pass1OperatingText)).sendKeys(iter.next());
		}
		tbr.sizeCheck(driver, pr.Pass1AssumptionText,softly);
		//Assumption
		if(iter.hasNext()) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(pr.Pass1AssumptionText)).sendKeys(iter.next());
		}
		tbr.sizeCheck(driver, pr.Pass1ScopeText,softly);
		//Scope of work
		if(iter.hasNext()) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(pr.Pass1ScopeText)).sendKeys(iter.next());
		}
		tbr.sizeCheck(driver, pr.Pass1TestingText,softly);
		//Testing
		if(iter.hasNext()) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(pr.Pass1TestingText)).sendKeys(iter.next());
		}
		//Scroll down
		share2.scrollToAPoint(driver, 1500);
		Thread.sleep(1000);
		//Verify FUSE full form
		String fuse_abbr = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-2']/div[5]/table/tbody/tr[5]/td[1]/abbr"))).getAttribute("globtitle");
		softly.assertThat(fuse_abbr).as("test data").isEqualTo("First Time Evolution, Unbalanced Interests, SPV, Expertise Deficiency");	
		//Click on each checkbox twice - check and uncheck it
		//q1 to q10
		for(int i=2;i<=11;i++)
		{
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-2']/div[5]/table/tbody/tr["+i+"]/td[2]/div/input"))));
			//Check it
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-2']/div[5]/table/tbody/tr["+i+"]/td[2]/div/input"))).click();
			em3.verifyCheckBoxChecked(driver, By.xpath(".//*[@id='pii-3pr-tab-2']/div[5]/table/tbody/tr["+i+"]/td[2]/div/input"));
			Thread.sleep(500);
			//Uncheck it
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-2']/div[5]/table/tbody/tr["+i+"]/td[2]/div/input"))).click();
			em3.verifyCheckBoxNotChecked(driver, By.xpath(".//*[@id='pii-3pr-tab-2']/div[5]/table/tbody/tr["+i+"]/td[2]/div/input"));
		}
		//Check boxes for every alternate questions
		//q1 to q10
		for(int i=2;i<=11;i=i+2)
		{
			//Check it
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-2']/div[5]/table/tbody/tr["+i+"]/td[2]/div/input"))).click();
			em3.verifyCheckBoxChecked(driver, By.xpath(".//*[@id='pii-3pr-tab-2']/div[5]/table/tbody/tr["+i+"]/td[2]/div/input"));
		}
		//Enter text in each text box for q1 to q10
		for(int i=2;i<=11;i++)
		{
			tbr.sizeCheck(driver, By.xpath(".//*[@id='pii-3pr-tab-2']/div[5]/table/tbody/tr["+i+"]/td[3]/textarea"),softly);
			if(iter.hasNext()) 
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-2']/div[5]/table/tbody/tr["+i+"]/td[3]/textarea"))).sendKeys(iter.next());
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-2']/div[5]/table/tbody/tr["+i+"]/td[3]/textarea"))).getAttribute("value");
			if(s.equals(""))
			{
				if(iter.hasNext()) 
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-2']/div[5]/table/tbody/tr["+i+"]/td[3]/textarea"))).sendKeys(iter.next());
			}
		}
		//Scroll up
		share2.scrollToTop(driver);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(pr.NextButton)).click();
	}

	public void pass2Tab(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		List<String> textList = em2.error100Data(driver,driver.getCurrentUrl());
		Iterator<String> iter = Iterables.cycle(textList).iterator();
		//Table 1
		//Enter text in each text box
		for(int i=2;i<=5;i++)
		{
			tbr.sizeCheck(driver, By.xpath(".//*[@id='pii-3pr-tab-3']/div[3]/table/tbody/tr["+i+"]/td[2]/textarea"),softly);
			if(iter.hasNext()) 
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[3]/table/tbody/tr["+i+"]/td[2]/textarea"))).sendKeys(iter.next());
		}
		//Table 2
		//Click on each checkbox twice - check and uncheck it
		//q1 to q12
		int m=2;
		for(int i=2;i<=13;i++)
		{
			if(i==2||i==5||i==8||i==11)
			{
				m=3;
			}
			else
				m=2;
			//Scroll to element
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[5]/table/tbody/tr["+i+"]/td["+m+"]/div/input"))));
			//Check it
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[5]/table/tbody/tr["+i+"]/td["+m+"]/div/input"))).click();
			em3.verifyCheckBoxChecked(driver, By.xpath(".//*[@id='pii-3pr-tab-3']/div[5]/table/tbody/tr["+i+"]/td["+m+"]/div/input"));
			Thread.sleep(500);
			//Uncheck it
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[5]/table/tbody/tr["+i+"]/td["+m+"]/div/input"))).click();
			em3.verifyCheckBoxNotChecked(driver, By.xpath(".//*[@id='pii-3pr-tab-3']/div[5]/table/tbody/tr["+i+"]/td["+m+"]/div/input"));
		}
		//Check boxes for every alternate questions
		//q1 to q10
		for(int i=2;i<=13;i=i+2)
		{
			if(i==2||i==5||i==8||i==11)
			{
				m=3;
			}
			else
				m=2;
			//Scroll to element
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[5]/table/tbody/tr["+i+"]/td["+m+"]/div/input"))));
			//Check it
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[5]/table/tbody/tr["+i+"]/td["+m+"]/div/input"))).click();
			em3.verifyCheckBoxChecked(driver, By.xpath(".//*[@id='pii-3pr-tab-3']/div[5]/table/tbody/tr["+i+"]/td["+m+"]/div/input"));
		}
		//Enter text in each text box
		for(int i=2;i<=13;i++)
		{
			if(i==2||i==5||i==8||i==11)
			{
				m=3;
			}
			else
				m=2;
			//Scroll to element
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[5]/table/tbody/tr["+i+"]/td["+m+"]/div/input"))));
			tbr.sizeCheck(driver, By.xpath(".//*[@id='pii-3pr-tab-3']/div[5]/table/tbody/tr["+i+"]/td["+(m+1)+"]/textarea"),softly);
			if(iter.hasNext()) 
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[5]/table/tbody/tr["+i+"]/td["+(m+1)+"]/textarea"))).sendKeys(iter.next());
		}
		//Table 3
		//Enter text in each text box
		for(int i=2;i<=5;i++)
		{
			//Scroll to element
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[8]/table/tbody/tr["+i+"]/td[2]/textarea"))));
			if(iter.hasNext()) 
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[8]/table/tbody/tr["+i+"]/td[2]/textarea"))).sendKeys(iter.next());
		}
		//Table 4
		//Click on each checkbox twice - check and uncheck it
		//q1 to q12
		for(int i=2;i<=13;i++)
		{
			if(i==2||i==5||i==8||i==11)
			{
				m=3;
			}
			else
				m=2;
			//Scroll to element
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[10]/table/tbody/tr["+i+"]/td["+m+"]/div/input"))));
			//Check it
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[10]/table/tbody/tr["+i+"]/td["+m+"]/div/input"))).click();
			em3.verifyCheckBoxChecked(driver, By.xpath(".//*[@id='pii-3pr-tab-3']/div[10]/table/tbody/tr["+i+"]/td["+m+"]/div/input"));
			Thread.sleep(500);
			//Uncheck it
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[10]/table/tbody/tr["+i+"]/td["+m+"]/div/input"))).click();
			em3.verifyCheckBoxNotChecked(driver, By.xpath(".//*[@id='pii-3pr-tab-3']/div[10]/table/tbody/tr["+i+"]/td["+m+"]/div/input"));
		}
		//Check boxes for every alternate questions
		//q1 to q10
		for(int i=2;i<=13;i=i+2)
		{
			if(i==2||i==5||i==8||i==11)
			{
				m=3;
			}
			else
				m=2;
			//Scroll to element
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[10]/table/tbody/tr["+i+"]/td["+m+"]/div/input"))));
			//Check it
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[10]/table/tbody/tr["+i+"]/td["+m+"]/div/input"))).click();
			em3.verifyCheckBoxChecked(driver, By.xpath(".//*[@id='pii-3pr-tab-3']/div[10]/table/tbody/tr["+i+"]/td["+m+"]/div/input"));
		}
		//Enter text in each text box
		for(int i=2;i<=13;i++)
		{
			if(i==2||i==5||i==8||i==11)
			{
				m=3;
			}
			else
				m=2;
			//Scroll to element
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[10]/table/tbody/tr["+i+"]/td["+m+"]/div/input"))));
			tbr.sizeCheck(driver, By.xpath(".//*[@id='pii-3pr-tab-3']/div[10]/table/tbody/tr["+i+"]/td["+(m+1)+"]/textarea"),softly);
			if(iter.hasNext()) 
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[10]/table/tbody/tr["+i+"]/td["+(m+1)+"]/textarea"))).sendKeys(iter.next());
		}
		//Scroll up
		share2.scrollToTop(driver);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(pr.NextButton)).click();
	}

	public void pass3Tab(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		List<String> textList = em2.error100Data(driver,driver.getCurrentUrl());
		Iterator<String> iter = Iterables.cycle(textList).iterator();
		String titlePass3Tab = wait.until(ExpectedConditions.visibilityOfElementLocated(pr.Pass3Tab1stTableTitle)).getText();
		softly.assertThat(titlePass3Tab).as("test data").isEqualTo("Pass 3: Self-Checklist");
		//Table 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(pr.Pass3CriticalText)).sendKeys(iter.next());
		//Table 2
		//Click on each checkbox twice - check and uncheck it
		//q1 to q6
		for(int i=2;i<=7;i++)
		{
			//Scroll to element
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-4']/div[5]/table/tbody/tr["+i+"]/td[2]/div/input"))));
			//Check it
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-4']/div[5]/table/tbody/tr["+i+"]/td[2]/div/input"))).click();
			em3.verifyCheckBoxChecked(driver, By.xpath(".//*[@id='pii-3pr-tab-4']/div[5]/table/tbody/tr["+i+"]/td[2]/div/input"));
			Thread.sleep(500);
			//Uncheck it
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-4']/div[5]/table/tbody/tr["+i+"]/td[2]/div/input"))).click();
			em3.verifyCheckBoxNotChecked(driver, By.xpath(".//*[@id='pii-3pr-tab-4']/div[5]/table/tbody/tr["+i+"]/td[2]/div/input"));
		}
		//Check boxes for every alternate questions
		//q1 to q6
		for(int i=2;i<=7;i=i+2)
		{
			//Check it
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-4']/div[5]/table/tbody/tr["+i+"]/td[2]/div/input"))));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-4']/div[5]/table/tbody/tr["+i+"]/td[2]/div/input"))).click();
			em3.verifyCheckBoxChecked(driver, By.xpath(".//*[@id='pii-3pr-tab-4']/div[5]/table/tbody/tr["+i+"]/td[2]/div/input"));
			if(i==2)
				em3.verifyCheckBoxChecked(driver, By.xpath(".//*[@id='pii-3pr-tab-4']/div[5]/table/tbody/tr["+i+"]/td[2]/div/input"));
		}
		//Enter text in each text box
		for(int i=2;i<=7;i++)
		{
			tbr.sizeCheck(driver, By.xpath(".//*[@id='pii-3pr-tab-4']/div[5]/table/tbody/tr["+i+"]/td[3]/textarea"),softly);
			if(iter.hasNext()) 
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-4']/div[5]/table/tbody/tr["+i+"]/td[3]/textarea"))).sendKeys(iter.next());
		}
		//Scroll up
		share2.scrollToTop(driver);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(pr.NextButton)).click();
	}

	public void verifyHTMLReport(WebDriver driver, List<String> textList) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Pass 1
		//Table 1
		for(int i=2;i<=6;i++)
		{
			//Verify text
			if(driver.getCurrentUrl().contains("kaleqa"))
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='3pr-rpt']/div[2]/table/tbody/tr["+i+"]/td[2]"))).getText();
				String r1 = s.replaceAll("\u00AD", "");
				softly.assertThat(r1).as("test data").isIn(textList);
			}
			else
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='3pr-rpt']/div[3]/table/tbody/tr["+i+"]/td[2]"))).getText();
				String r1 = s.replaceAll("\u00AD", "");
				softly.assertThat(r1).as("test data").isIn(textList);
			}
		}
		//Table 2
		for(int i=2;i<=11;i++)
		{
			if(driver.getCurrentUrl().contains("kaleqa"))
			{
				//Verify text
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='3pr-rpt']/div[3]/table/tbody/tr["+i+"]/td[3]"))).getText();
				String r1 = s.replaceAll("\u00AD", "");
				softly.assertThat(r1).as("test data").isIn(textList);
				//Verify Yes for checkbox
				if(i%2==0)
				{
					String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='3pr-rpt']/div[3]/table/tbody/tr["+i+"]/td[2]"))).getText();
					softly.assertThat(s1).as("test data").isEqualTo("Yes");
				}
			}
			else
			{
				//Verify text
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='3pr-rpt']/div[4]/table/tbody/tr["+i+"]/td[3]"))).getText();
				String r1 = s.replaceAll("\u00AD", "");
				softly.assertThat(r1).as("test data").isIn(textList);
				//Verify Yes for checkbox
				if(i%2==0)
				{
					String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='3pr-rpt']/div[4]/table/tbody/tr["+i+"]/td[2]"))).getText();
					softly.assertThat(s1).as("test data").isEqualTo("Yes");
				}
			}
		}
		//Pass 2
		//Analysis
		//Table 1
		for(int i=2;i<=5;i++)
		{
			//Verify text
			if(driver.getCurrentUrl().contains("kaleqa"))
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='3pr-rpt']/div[4]/table/tbody/tr["+i+"]/td[2]"))).getText();
				String r1 = s.replaceAll("\u00AD", "");
				softly.assertThat(r1).as("test data").isIn(textList);
			}
			else
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='3pr-rpt']/div[5]/table/tbody/tr["+i+"]/td[2]"))).getText();
				String r1 = s.replaceAll("\u00AD", "");
				softly.assertThat(r1).as("test data").isIn(textList);
			}
		}
		int m = 2;
		//Table 2
		for(int i=2;i<=13;i++)
		{
			if(i==2||i==5||i==8||i==11)
			{
				m=3;
			}
			else
				m=2;
			if(driver.getCurrentUrl().contains("kaleqa"))
			{
				//Verify text
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='3pr-rpt']/div[5]/table/tbody/tr["+i+"]/td["+(m+1)+"]"))).getText();
				String r1 = s.replaceAll("\u00AD", "");
				softly.assertThat(r1).as("test data").isIn(textList);
				//Verify Yes for checkbox
				if(i%2==0)
				{
					String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='3pr-rpt']/div[5]/table/tbody/tr["+i+"]/td["+m+"]"))).getText();
					softly.assertThat(s1).as("test data").isEqualTo("Yes");
				}
			}
			else
			{
				//Verify text
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='3pr-rpt']/div[6]/table/tbody/tr["+i+"]/td["+(m+1)+"]"))).getText();
				String r1 = s.replaceAll("\u00AD", "");
				softly.assertThat(r1).as("test data").isIn(textList);
				//Verify Yes for checkbox
				if(i%2==0)
				{
					String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='3pr-rpt']/div[6]/table/tbody/tr["+i+"]/td["+m+"]"))).getText();
					softly.assertThat(s1).as("test data").isEqualTo("Yes");
				}
			}
		}
		//Procedure
		//Table 3
		for(int i=2;i<=5;i++)
		{
			//Verify text
			if(driver.getCurrentUrl().contains("kaleqa"))
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='3pr-rpt']/div[6]/table/tbody/tr["+i+"]/td[2]"))).getText();
				String r1 = s.replaceAll("\u00AD", "");
				softly.assertThat(r1).as("test data").isIn(textList);
			}
			else
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='3pr-rpt']/div[7]/table/tbody/tr["+i+"]/td[2]"))).getText();
				String r1 = s.replaceAll("\u00AD", "");
				softly.assertThat(r1).as("test data").isIn(textList);
			}
		}
		//Table 4
		for(int i=2;i<=13;i++)
		{
			if(i==2||i==5||i==8||i==11)
			{
				m=3;
			}
			else
				m=2;
			//Verify text
			if(driver.getCurrentUrl().contains("kaleqa"))
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='3pr-rpt']/div[7]/table/tbody/tr["+i+"]/td["+(m+1)+"]"))).getText();
				String r1 = s.replaceAll("\u00AD", "");
				if(r1.equals("")==false)
					softly.assertThat(r1).as("test data").isIn(textList);
				//Verify Yes for checkbox
				if(i%2==0)
				{
					String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='3pr-rpt']/div[7]/table/tbody/tr["+i+"]/td["+m+"]"))).getText();
					softly.assertThat(s1).as("test data").isEqualTo("Yes");
				}
			}
			else
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='3pr-rpt']/div[8]/table/tbody/tr["+i+"]/td["+(m+1)+"]"))).getText();
				String r1 = s.replaceAll("\u00AD", "");
				if(r1.equals("")==false)
					softly.assertThat(r1).as("test data").isIn(textList);
				//Verify Yes for checkbox
				if(i%2==0)
				{
					String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='3pr-rpt']/div[8]/table/tbody/tr["+i+"]/td["+m+"]"))).getText();
					softly.assertThat(s1).as("test data").isEqualTo("Yes");
				}
			}
		}
		//Pass 3
		//Table 1
		if(driver.getCurrentUrl().contains("kaleqa"))
		{
			//Title
			String titlePass3Tab = wait.until(ExpectedConditions.visibilityOfElementLocated(pr.HTMLPass3Tab1stTableTitle)).getText();
			softly.assertThat(titlePass3Tab).as("test data").isEqualTo("Pass 3: Self-Checklist");
			//Verify text
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(pr.HTMLPass3CriticalText)).getText();
			String r1 = s.replaceAll("\u00AD", "");
			if(r1.equals("")==false)
				softly.assertThat(r1).as("test data").isIn(textList);
		}
		else
		{
			//Title
			String titlePass3Tab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='3pr-rpt']/div[9]/div"))).getText();
			softly.assertThat(titlePass3Tab).as("test data").isEqualTo("Pass 3: Self-Checklist");
			//Verify text
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='3pr-rpt']/div[9]/table/tbody/tr[2]/td[2]"))).getText();
			String r1 = s.replaceAll("\u00AD", "");
			if(r1.equals("")==false)
				softly.assertThat(r1).as("test data").isIn(textList);
		}
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		//Table 2
		for(int i=2;i<=7;i++)
		{
			if(driver.getCurrentUrl().contains("kaleqa"))
			{
				//Verify text
				if (browserName.equals("internet explorer"))
				{
					String s1 = driver.findElement(By.xpath(".//*[@id='3pr-rpt']/div[9]/table/tbody/tr["+i+"]/td[3]")).getText();
					System.out.println(s1);
					String r2 = s1.replaceAll("\u00AD", "");
					softly.assertThat(r2).as("test data").isIn(textList);
					//System.out.println(s1+"\n"+r2);
				}
				else
				{
					String s1 = driver.findElement(By.xpath(".//*[@id='3pr-rpt']/div[9]/table/tbody/tr["+i+"]/td[3]")).getText();
					String r2 = s1.replaceAll("\u00AD", "");
					softly.assertThat(r2).as("test data").isIn(textList);
				}
				//Verify Yes for checkbox
				if(i%2==0)
				{
					if((i==2)&&browserName.contains("safari"))
						continue;
					String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='3pr-rpt']/div[9]/table/tbody/tr["+i+"]/td[2]"))).getText();
					System.out.println(s2+" "+i);
					softly.assertThat(s2).as("test data").isEqualTo("Yes");
				}
			}
			else
			{
				//Verify text
				if (browserName.equals("internet explorer"))
				{
					String s1 = driver.findElement(By.xpath(".//*[@id='3pr-rpt']/div[10]/table/tbody/tr["+i+"]/td[3]")).getText();
					System.out.println(s1);
					String r2 = s1.replaceAll("\u00AD", "");
					softly.assertThat(r2).as("test data").isIn(textList);
					//System.out.println(s1+"\n"+r2);
				}
				else
				{
					String s1 = driver.findElement(By.xpath(".//*[@id='3pr-rpt']/div[10]/table/tbody/tr["+i+"]/td[3]")).getText();
					String r2 = s1.replaceAll("\u00AD", "");
					softly.assertThat(r2).as("test data").isIn(textList);
				}
				//Verify Yes for checkbox
				if(i%2==0)
				{
					if((i==2)&&browserName.contains("safari"))
						continue;
					String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='3pr-rpt']/div[10]/table/tbody/tr["+i+"]/td[2]"))).getText();
					System.out.println(s2+" "+i);
					softly.assertThat(s2).as("test data").isEqualTo("Yes");
				}
			}
		}
	}

	public void markCritical(WebDriver driver,String username, String password1,int y) throws Exception{

		WebDriverWait wait1 = new WebDriverWait(driver,60);
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(pr.FirstRecord)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);	
		//Clicks on mark critical
		if(driver.getCurrentUrl().contains("kaleqa"))
			wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.MarkCritical)).click();
		else
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div[2]/div/label"))).click();
		//Mark critical pop up
		eirca2.verifyMarkCriticalPopup(driver, softly);
		//Clicks on confirm change
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupButton)).click();
		//Checks if marked critical
		if(driver.getCurrentUrl().contains("kaleqa"))
		{
			share2.loadingServer(driver);
			String s = wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.MarkCritical)).getAttribute("class");
			softly.assertThat(s).as("test data").contains("ui-checkbox-on");
		}
		else {
			String critical=wait1.until(ExpectedConditions.visibilityOfElementLocated(pr.PassReviewMarkCriticalIndicatorText)).getText();
			softly.assertThat(critical).as("test data").contains("Critical");
			if(driver.findElement(pr.PassReviewMarkCriticalIndicatorText).isDisplayed())
				System.out.println("Marked critical");
		}
		//Click back
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.BackButton)).click();
		share2.loadingServer(driver);
		//Verify Marked critical icon
		wait1.until(ExpectedConditions.visibilityOfElementLocated(pr.PassReviewShareIconOrCriticalIcon));
		//Verify presence of shared icon 
		wait1.until(ExpectedConditions.visibilityOfElementLocated(pr.PassReviewShareIconWhenAlsoMarkedCritical));
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(pr.FirstRecord)).click();
		share2.loadingServer(driver);
		//Clicks on mark critical again
		if(driver.getCurrentUrl().contains("kaleqa"))
			wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.MarkCritical)).click();
		else
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div[2]/div/label"))).click();
		//Un-mark critical pop up
		eirca2.verifyUnMarkCriticalPopup(driver, softly);
		//Clicks on confirm change
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupButton)).click();
		Thread.sleep(2000);
		if(driver.getCurrentUrl().contains("kaleqa"))
		{
			share2.loadingServer(driver);
			String s = wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.MarkCritical)).getAttribute("class");
			softly.assertThat(s).as("test data").contains("ui-checkbox-off");
		}
		else {
			if(driver.findElement(pr.PassReviewMarkCriticalIndicatorText).isDisplayed()==false)
			{
				System.out.println("Unmarked critical");
			}
		}
		//Verify report not retrieved by shared to person
		String sharer = em3.decideSharer (y);		
		share.checkCriticalNotification(driver, sharer, username, password1, softly);		
		//Clicks on 3 pass side panel
		wait1.until(ExpectedConditions.visibilityOfElementLocated(pr.PassReviewSidePanel)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);	    					
	}	

	public void shareReport(WebDriver driver,String username, String password1,int y ) throws Exception{

		WebDriverWait wait1 = new WebDriverWait(driver,60);
		String sharer = em3.decideSharer (y);
		String sharerAdded = em3.decideSharerAdded (y);	 
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(pr.FirstRecord)).click();
		share2.loadingServer(driver);
		//Verify change in text
		verifyHTMLReport(driver, em2.error50Data(driver,driver.getCurrentUrl()));
		//Clicks on share button
		if(driver.getCurrentUrl().contains("kaleqa"))
			wait1.until(ExpectedConditions.visibilityOfElementLocated(pr.ShareButton)).click();
		else
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).click();
		//Enters username
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.ShareTextBox)).sendKeys(sharer);
		Thread.sleep(500);
		//Selects from dropdown
		WebElement dropdown = wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.ShareDropdown));
		dropdown.findElement(opirca.FirstSelectionUnderDropdown).click();
		//Clicks on add user
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupButton)).click();
		//Verifies user added
		String user=wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.SharerAdded)).getText();
		softly.assertThat(user).as("test data").isEqualTo(sharerAdded);
		share3.shareTwice (driver,softly,0);
		//Clicks on save
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.ShareSaveButton)).click();
		//Verify share save sticky
		eirca2.verifyStickyShareSave(driver, softly);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Click back
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.BackButton)).click();
		share2.loadingServer(driver);
		//Verify Share icon
		wait1.until(ExpectedConditions.visibilityOfElementLocated(pr.PassReviewShareIconOrCriticalIcon));
		//see if user account can be saved
		share2.checkIfUserProfileNoFieldsMissing(driver, softly);
		//Calls the Share check function
		share.receiptReport(driver, sharer, username, password1);
		//Clicks on 3 Pass Review side panel
		wait1.until(ExpectedConditions.visibilityOfElementLocated(pr.PassReviewSidePanel)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
	}

	public void deleteNewRecord(WebDriver driver, String recordName, int y, String username) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Clicks on first newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(pr.FirstRecord)).click();
		share2.loadingServer(driver);
		//Clicks on delete button
		if(driver.getCurrentUrl().contains("kaleqa"))
			wait.until(ExpectedConditions.visibilityOfElementLocated(pr.DeleteButton)).click();
		else
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle));
		String noHtml = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).getText();
		softly.assertThat(noHtml).as("test data").doesNotContain("<br/>");
		//Clicks on delete report
		driver.findElement(eirca.ConfirmPopupButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.StickyNote));
		share2.loadingServer(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(pr.PassReviewSidePanel)).click();
		share2.loadingServer(driver);
		//Verify record deleted
		//Click on 1st record
		Thread.sleep(2000);
		String name = driver.findElement(pr.FirstRecord).getText();
		System.out.println(name);
		if (name!=recordName)
			System.out.println("Record deleted");
		else
			System.out.println("Record could not be deleted");	
		//verify admin user account page
		if(y==0||y==2||y==4||y==6)
			lcr.verifyAccountPageAdminUser(driver, username, softly);
		//Verify report not retrieved by shared to person		
		String sharer = em3.decideSharer (y);
		share.checkNoReportAfterDelete(driver, sharer, softly);		
	}

	public void changeText(WebDriver driver) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,10); 
		//Click on Pass 1 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(pr.Pass1Tab)).click();
		//Change text
		List<String> textList = em2.error50Data(driver,driver.getCurrentUrl());
		Iterator<String> iter = Iterables.cycle(textList).iterator();
		//Fill text in Requirement
		if(iter.hasNext()) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(pr.Pass1RequirementText)).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(pr.Pass1RequirementText)).sendKeys(iter.next());
		}
		//Operating mode
		if(iter.hasNext()) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(pr.Pass1OperatingText)).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(pr.Pass1OperatingText)).sendKeys(iter.next());
		}
		//Assumption
		if(iter.hasNext()) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(pr.Pass1AssumptionText)).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(pr.Pass1AssumptionText)).sendKeys(iter.next());
		}
		//Scope of work
		if(iter.hasNext()) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(pr.Pass1ScopeText)).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(pr.Pass1ScopeText)).sendKeys(iter.next());
		}
		//Testing
		if(iter.hasNext()) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(pr.Pass1TestingText)).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(pr.Pass1TestingText)).sendKeys(iter.next());
		}
		//Scroll down
		share2.scrollToAPoint(driver, 1500);
		Thread.sleep(1000);
		//Enter text in each text box for q1 to q10
		for(int i=2;i<=11;i++)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-2']/div[5]/table/tbody/tr["+i+"]/td[3]/textarea"))).clear();
			if(iter.hasNext()) 
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-2']/div[5]/table/tbody/tr["+i+"]/td[3]/textarea"))).sendKeys(iter.next());
		}
		//Scroll up
		share2.scrollToTop(driver);
		//Click on Pass 2 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(pr.Pass2Tab)).click();
		//Table 1
		//Enter text in each text box
		for(int i=2;i<=5;i++)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[3]/table/tbody/tr["+i+"]/td[2]/textarea"))).clear();
			if(iter.hasNext()) 
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[3]/table/tbody/tr["+i+"]/td[2]/textarea"))).sendKeys(iter.next());
		}
		//Enter text in each text box
		int m=2;
		for(int i=2;i<=13;i++)
		{
			if(i==2||i==5||i==8||i==11)
			{
				m=3;
			}
			else
				m=2;
			//Scroll to element
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[5]/table/tbody/tr["+i+"]/td["+m+"]/div/input"))));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[5]/table/tbody/tr["+i+"]/td["+(m+1)+"]/textarea"))).clear();
			if(iter.hasNext()) 
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[5]/table/tbody/tr["+i+"]/td["+(m+1)+"]/textarea"))).sendKeys(iter.next());
		}
		//Table 3
		//Enter text in each text box
		for(int i=2;i<=5;i++)
		{
			//Scroll to element
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[8]/table/tbody/tr["+i+"]/td[2]/textarea"))));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[8]/table/tbody/tr["+i+"]/td[2]/textarea"))).clear();
			if(iter.hasNext()) 
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[8]/table/tbody/tr["+i+"]/td[2]/textarea"))).sendKeys(iter.next());
		}
		//Table 4
		//Enter text in each text box
		for(int i=2;i<=13;i++)
		{
			if(i==2||i==5||i==8||i==11)
			{
				m=3;
			}
			else
				m=2;
			//Scroll to element
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[10]/table/tbody/tr["+i+"]/td["+m+"]/div/input"))));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[10]/table/tbody/tr["+i+"]/td["+(m+1)+"]/textarea"))).clear();
			if(iter.hasNext()) 
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[10]/table/tbody/tr["+i+"]/td["+(m+1)+"]/textarea"))).sendKeys(iter.next());
		}
		//Scroll up
		share2.scrollToTop(driver);
		//Click on Pass 3 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(pr.Pass3Tab)).click();
		//Table 1
		if(iter.hasNext()) 
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(pr.Pass3CriticalText)).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(pr.Pass3CriticalText)).sendKeys(iter.next());
		}
		//Enter text in each text box
		for(int i=2;i<=7;i++)
		{
			//Scroll to element
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-4']/div[5]/table/tbody/tr["+i+"]/td[3]/textarea"))));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-4']/div[5]/table/tbody/tr["+i+"]/td[3]/textarea"))).clear();
			if(iter.hasNext()) 
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-4']/div[5]/table/tbody/tr["+i+"]/td[3]/textarea"))).sendKeys(iter.next());
		}
		//Scroll up
		share2.scrollToTop(driver);
	}

	public void openReport(WebDriver driver) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,10); 
		//Clicks on record
		wait.until(ExpectedConditions.visibilityOfElementLocated(pr.FirstRecord)).click();
		//Wait for loading message
		share2.loadingServer(driver);
		//Verify final report
		verifyHTMLReport(driver, em2.error100Data(driver,driver.getCurrentUrl()));
		//Clicks on open
		if(driver.getCurrentUrl().contains("kaleqa"))
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.OpenButton)).click();
		else
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[1]"))).click();
		//Clicks on open
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).click();
		String noHtml = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).getText();
		softly.assertThat(noHtml).as("test data").doesNotContain("<br/>");
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
		//Change text
		changeText(driver);
		//Click on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(pr.SaveButton)).click();
		Thread.sleep(2000);
		//Clicks on save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(pr.SavePopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(pr.SavePopupConfirmButton)).click();
		//Waits for the green popup on the right top corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.StickyNote));
		share2.loadingServer(driver);
		//Clicks on saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(pr.SavedAcivitiesButton)).click();
		share2.loadingServer(driver);
		//Clicks on side panel option for 3 pass review
		wait.until(ExpectedConditions.visibilityOfElementLocated(pr.PassReviewSidePanel)).click();
		share2.loadingServer(driver);
		//Verify the report rename popup overflow text
		pr2.verifySavePopupAfterRename(driver, softly);
	}

	public int getCharCountFromTitle(WebDriver driver) throws Exception {

		//Get count of characters
		String s = driver.findElement(pr.DocumentTitleCharacterCount).getText();
		s=s.substring(1,s.indexOf("/"));
		int count = Integer.parseInt(s);
		System.out.println(s+ " "+count);
		return count;
	}

	public int getTotalCountFromTitle(WebDriver driver) throws Exception {

		//Get count of characters
		String s = driver.findElement(pr.DocumentTitleCharacterCount).getText();
		s=s.substring((s.indexOf("/")+1), s.indexOf(")"));
		int count = Integer.parseInt(s);
		System.out.println(s+ " "+count);
		return count;
	}

	public void checkTitleCountReset(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Enter
		wait.until(ExpectedConditions.visibilityOfElementLocated(pr.DocumentTitle)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(pr.DocumentTitle)).sendKeys("aaaa");
		//Get count
		int count = getCharCountFromTitle(driver);
		if(count!=4)
			softly.fail("Count did not match: aaaa: " + count);
		//Clear text
		for(int i=0;i<4;i++)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(pr.DocumentTitle)).sendKeys(Keys.BACK_SPACE);
			Thread.sleep(250);
		}
		count = getCharCountFromTitle(driver);
		if(count!=1)
			softly.fail("Count did not match: aaaa: " + count);
	}

	public String createReport (WebDriver driver) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,10); 
		FontCheck obj3 = new FontCheck();
		String text = eirca2.textCreate(driver);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on Analysis 
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(hc.AnalysisLink)).click();
		}catch (UnhandledAlertException f){			  
			driver.switchTo().alert().dismiss();
		}
		//Check font on Analysis page
		obj3.analysisModuleFontCheck(driver, softly);
		//Clicks on 3 Pass review
		wait.until(ExpectedConditions.visibilityOfElementLocated(pr.PassReviewLink)).click();
		Thread.sleep(2000);
		pr2.verifyErrorOnInfoPage(driver,softly);
		//Check title count reset when characters are entered and deleted
		checkTitleCountReset(driver);
		//Fills in mandatory details
		driver.findElement(pr.Reviewer).sendKeys(text);
		driver.findElement(pr.DocumentTitle).sendKeys(text);
		//Get count
		int count = getCharCountFromTitle(driver);
		int total = getTotalCountFromTitle(driver);
		for(int i=count+1;i<=total;i++)
		{
			driver.findElement(pr.DocumentTitle).sendKeys("z");
		}
		driver.findElement(pr.Organisation).sendKeys(text);
		String ev1 = driver.findElement(pr.Reviewer).getAttribute("value");
		String ev2 = driver.findElement(pr.DocumentTitle).getAttribute("value");
		String ev3 = driver.findElement(pr.Organisation).getAttribute("value");
		if ((ev1.equals(text)==false))
		{
			driver.findElement(pr.Reviewer).clear();
			driver.findElement(pr.Reviewer).sendKeys(text);
		}
		/*if ((ev2.equals(text)==false))
		{
			driver.findElement(pr.DocumentTitle).clear();
			driver.findElement(pr.DocumentTitle).sendKeys(text);
		}*/
		if ((ev3.equals(text)==false))
		{
			driver.findElement(pr.Organisation).clear();
			driver.findElement(pr.Organisation).sendKeys(text);
		}
		//Select Purpose from dropdown
		WebElement element = driver.findElement(pr.DocumentType);
		Select s = new Select (element);
		s.selectByVisibleText("Drawing");
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(pr.NextButttonAtBottom)).click();
		//Pass 1 Tab
		pass1Tab(driver);
		//Pass 2 Tab
		pass2Tab(driver);
		//Pass 3 Tab
		pass3Tab(driver);
		//Click on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(pr.SaveButton)).click();
		Thread.sleep(2000);
		//Clicks on save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(pr.SavePopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(pr.SavePopupConfirmButton)).click();
		//Waits for the green popup on the right top corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.StickyNote));
		//Wait for loading message
		share2.loadingServer(driver);
		//Clicks on saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(pr.SavedAcivitiesButton)).click();
		share2.loadingServer(driver);
		//Clicks on side panel option for 3 pass
		wait.until(ExpectedConditions.visibilityOfElementLocated(pr.PassReviewSidePanel)).click();
		share2.loadingServer(driver);
		//Gets the name of the record created
		WebElement record = driver.findElement(pr.FirstRecord);
		String recordName = record.getText();
		String r1 = recordName.replaceAll("\u00AD", "");
		softly.assertThat(r1).as("test data").contains(ev2);
		return r1;
	}

	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}

}
