package kaleTestSoftware;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HiRCALOPBug2 {

	public String text = "HiRCA bug LOP";
	public String reason = "reason entry";
	public String reason1 = "reason entry 1";
	public String reason2 = "reason entry 2";
	public String reason3 = "reason entry 3";

	ShareCheck2 share2 = new ShareCheck2();
	ShareCheck share = new ShareCheck();
	HiRCAObj hc = new HiRCAObj();
	HiRCA2 hc2 = new HiRCA2();
	HiRCALevel1 hl1 = new HiRCALevel1();

	public void fillUpHiRCAEventInfo(WebDriver driver,String text) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		fillPage(driver,text);
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[16]/div/button"))));
		//Clicks on next
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[16]/div/button"))).click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[16]/div/button"))));
		Thread.sleep(2000);
	}

	public void fillPage(WebDriver driver,String text) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on Analysis 
		wait.until(ExpectedConditions.visibilityOfElementLocated(hc.AnalysisLink)).click();
		//Clicks on HiRCA
		wait.until(ExpectedConditions.visibilityOfElementLocated(hc.HiRCALink)).click();
		Thread.sleep(2000);
		//Event title
		wait.until(ExpectedConditions.visibilityOfElementLocated(hc.HiRCAEventTitleField)).sendKeys(text);
		//Location of event
		wait.until(ExpectedConditions.visibilityOfElementLocated(hc.HiRCAEventLocationField)).sendKeys(text);
		//Department
		WebElement dropdown = driver.findElement(By.id("pii-irca-event-department"));
		Select s = new Select (dropdown);
		s.selectByVisibleText("Construction");
		//Problem Statement
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-pbstatement"))).sendKeys(text);
		//Timeline of event
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-events"))).sendKeys(text);
		//Background info
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-bginfos"))).sendKeys(text);
		//Investigators
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-investigators"))).sendKeys(text);
	}
	
	public void bugKALE2494(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on About
		wait.until(ExpectedConditions.visibilityOfElementLocated(hc.HiRCAStep5AboutLink)).click();
		//Verify text for chinese
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(hc.HiRCAStep5AboutLastParagraphUnderBurp)).getText();
		System.out.println("2494: "+s);
		softly.assertThat(s).as("test data").contains("根据过去23年分析超过4,500个案例，");
		softly.assertThat(s).as("test data").contains("研究发现不遵守率受四个控制参数影而造成违章行为。");
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hc.HiRCAStep5AboutParagraphUnderTQA)).getText();
		System.out.println("2494: "+s1);
		softly.assertThat(s1).as("test data").isEqualTo("失败率与未受培训的员工百分比成正比。");
		//Click on About
		wait.until(ExpectedConditions.visibilityOfElementLocated(hc.HiRCAStep5AboutLink)).click();
	}

	public void bugKALE2493(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on About
		wait.until(ExpectedConditions.visibilityOfElementLocated(hc.HiRCAStep1AboutLink)).click();
		//Verify text for chinese
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(hc.HiRCAStep1About4thParagraph)).getText();
		System.out.println("2493: "+s);
		softly.assertThat(s).as("test data").isEqualTo("为了回答该问题，根本原因分析员需要检查失误人员可能从故意违反要求中有某些\"获益\"的所有情况。\"获益\"包括:");
		//Click on About
		wait.until(ExpectedConditions.visibilityOfElementLocated(hc.HiRCAStep1AboutLink)).click();
	}
	
	public void bugKALE2412(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		fillUpHiRCAEventInfo(driver,text);
		//Click on Human error
		wait.until(ExpectedConditions.visibilityOfElementLocated(hc.Answer1)).click();
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(hc.NextButton)).click();
		Thread.sleep(2000);
		//Click on Knowledge-based 1.2.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(hc.Answer1)).click();
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(hc.NextButton)).click();
		//Skip till 1.20 - 17 times as per current path version 4.6.3
		for(int i=1;i<=17;i++)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(hc.SkipButton)).click();
			Thread.sleep(1000);
		}
		//Click on Root Cause
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed2"))).click();
		//Skip from step 3 to Step 5 - 2 times as per current path version 4.6.3
		for(int i=1;i<=2;i++)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(hc.SkipButton)).click();
			Thread.sleep(1000);
		}
		//Click skip on step 5
		wait.until(ExpectedConditions.visibilityOfElementLocated(hc.SkipButton)).click();
		//Report tab
		//verify the n/a is center aligned in the table for questions 1.1 to 1.20 and SUEP table
		//Answer for 1.3 to 1.5
		for(int i=3;i<=5;i++)
		{
			String align = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr["+i+"]/td[2]"))).getAttribute("align");
			softly.assertThat(align).as("test data").isEqualTo("center");
		}
		//Supporting answers
		for(int i=1;i<=20;i++)
		{
			String align = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr["+i+"]/td[3]"))).getAttribute("align");
			softly.assertThat(align).as("test data").isEqualTo("center");
		}
		//SUEP
		for(int i=1;i<=5;i++)
		{
			String align = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[1]/td["+i+"]"))).getAttribute("align");
			softly.assertThat(align).as("test data").isEqualTo("center");
		}
		//Scroll top
		share2.scrollToTop(driver);
		//Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))).click();
		//Clicks on Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-success")));
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Click on saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-btn-savedactivities"))).click();
		//Wait for loading message to disappear		  
		share2.loadingServer(driver);
		//Click on newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();
		//Wait for loading message to disappear		  
		share2.loadingServer(driver);
		//HTML
		//verify the n/a is center aligned in the table for questions 1.1 to 1.20 and SUEP table
		//Answer for 1.3 to 1.5
		for(int i=3;i<=5;i++)
		{
			String align = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr["+i+"]/td[2]"))).getAttribute("align");
			softly.assertThat(align).as("test data").isEqualTo("center");
		}
		//Supporting answers
		for(int i=1;i<=20;i++)
		{
			String align = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr["+i+"]/td[3]"))).getAttribute("align");
			softly.assertThat(align).as("test data").isEqualTo("center");
		}
		//SUEP
		for(int i=1;i<=5;i++)
		{
			String align = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr[1]/td["+i+"]"))).getAttribute("align");
			softly.assertThat(align).as("test data").isEqualTo("center");
		}
		//Delete
		hl1.deleteReport(driver);
		//Go to KALE homepage
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pii-logo-div-element-kale"))).click();
	}

	public void bugKALE2219KALE2246(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on new for new report
		wait.until(ExpectedConditions.visibilityOfElementLocated(hc.HiRCANewReportButton)).click();
		//Verify new report pop up
		hc2.verifyNewReportPopup(driver, softly);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		Thread.sleep(2000);
		//Event title
		wait.until(ExpectedConditions.visibilityOfElementLocated(hc.HiRCAEventTitleField)).sendKeys(text+" \"title\" "+text);
		//Location of event
		wait.until(ExpectedConditions.visibilityOfElementLocated(hc.HiRCAEventLocationField)).sendKeys(text+" \"foo\" "+text);
		//Department
		WebElement dropdown = driver.findElement(By.id("pii-irca-event-department"));
		Select s = new Select (dropdown);
		s.selectByVisibleText("Construction");
		//Problem Statement
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-pbstatement"))).sendKeys(text);
		//Timeline of event
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-events"))).sendKeys(text);
		//Background info
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-bginfos"))).sendKeys(text);
		//Investigators
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-investigators"))).sendKeys(text);
		//Scroll top
		share2.scrollToTop(driver);
		//Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))).click();
		//Clicks on Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-success")));
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Click on saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-btn-savedactivities"))).click();
		//Wait for loading message to disappear		  
		share2.loadingServer(driver);
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).getText();
		softly.assertThat(s2).as("test data").contains(text+" \"title\" "+text);
		//Click on newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();
		//Wait for loading message to disappear		  
		share2.loadingServer(driver);
		//Click on Open button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		//Clicks on open report
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		//Clicks on Info tab
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-tab-0"))).click();
		}catch(org.openqa.selenium.WebDriverException t)
		{
			share2.scrollToTop(driver);
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-tab-0"))));
		}
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hc.HiRCAEventLocationField)).getAttribute("value");
		softly.assertThat(s1).as("test data").isEqualTo(text+" \"foo\" "+text);
		//Click on saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-btn-savedactivities"))).click();
		//Wait for loading message to disappear		  
		share2.loadingServer(driver);
		//Click on newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();
		//Wait for loading message to disappear		  
		share2.loadingServer(driver);
		//Delete
		hl1.deleteReport(driver);
		//Go to KALE homepage
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pii-logo-div-element-kale"))).click();
	}

	public void makeSelections (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(hc.NextButton)).click();
		Thread.sleep(2000);
		//Enter reason entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(hc.ReasonEntryField)).sendKeys(reason);
		//Click no for 2.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(hc.Answer2)).click();
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(hc.NextButton)).click();
		Thread.sleep(2000);
		//Enter reason entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(hc.ReasonEntryField)).sendKeys(reason);
		//Click no for 2.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(hc.Answer3)).click();
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(hc.NextButton)).click();
		Thread.sleep(2000);
		//Enter reason entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(hc.ReasonEntryField)).sendKeys(reason);
		//Click no for 2.9
		wait.until(ExpectedConditions.visibilityOfElementLocated(hc.Answer2)).click();
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(hc.NextButton)).click();
		Thread.sleep(2000);
		//Enter reason entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(hc.ReasonEntryField)).sendKeys(reason);
		//Click no for 2.10
		wait.until(ExpectedConditions.visibilityOfElementLocated(hc.Answer2)).click();
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(hc.NextButton)).click();
		Thread.sleep(2000);
		//Enter reason entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(hc.ReasonEntryField)).sendKeys(reason);
		//Click no for 2.11
		wait.until(ExpectedConditions.visibilityOfElementLocated(hc.Answer2)).click();
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(hc.NextButton)).click();
		Thread.sleep(2000);
		//Enter reason entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(hc.ReasonEntryField)).sendKeys(reason);
		//Click no for 2.12
		wait.until(ExpectedConditions.visibilityOfElementLocated(hc.Answer2)).click();
		Thread.sleep(2000);
		//Click on trash can for 2.12
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-clear"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		Thread.sleep(2000);
		//Click on back
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-back"))).click();
		Thread.sleep(2000);
		//Click on trash can for 2.11
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-clear"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		Thread.sleep(2000);
		//Click on back
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-back"))).click();
		Thread.sleep(2000);
		//Click on trash can for 2.10
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-clear"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		Thread.sleep(2000);
		//Click on back
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-back"))).click();
		Thread.sleep(2000);
		//Click on trash can for 2.9
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-clear"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		Thread.sleep(2000);
		//Click on back
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-back"))).click();
		Thread.sleep(2000);
		//Click on trash can for 2.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-clear"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		Thread.sleep(2000);
		//Click on back
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-back"))).click();
		Thread.sleep(2000);
		//Click on trash can for 2.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-clear"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		Thread.sleep(2000);
		//Click on back
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-back"))).click();
		Thread.sleep(2000);
		//Click next at 2.0
		wait.until(ExpectedConditions.visibilityOfElementLocated(hc.NextButton)).click();
		Thread.sleep(2000);
	}


	public void previousSelectionVerify (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Verify if 2.1 selection exists for answer No
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(hc.Answer2)).getAttribute("class");
		softly.assertThat(s).as("test data").contains("ui-radio-off");
		String r = wait.until(ExpectedConditions.visibilityOfElementLocated(hc.ReasonEntryField)).getAttribute("value");
		softly.assertThat(r).as("test data").contains("");
		//Verify if next button is disabled
		if(driver.findElement(hc.NextButton).isEnabled())
		{
			softly.fail("Next button enabled 2.1");
			//Click next 2.1
			wait.until(ExpectedConditions.visibilityOfElementLocated(hc.NextButton)).click();
			Thread.sleep(2000);
			//Verify if 2.2 selection exists for answer No
			String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hc.Answer3)).getAttribute("class");
			softly.assertThat(s1).as("test data").contains("ui-radio-off");
			String r1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hc.ReasonEntryField)).getAttribute("value");
			softly.assertThat(r1).as("test data").contains("");
			//Verify if next button is disabled
			if(driver.findElement(hc.NextButton).isEnabled())
			{
				softly.fail("Next button enabled 2.2");
				//Click next 2.2
				wait.until(ExpectedConditions.visibilityOfElementLocated(hc.NextButton)).click();
				Thread.sleep(2000);
				//Verify if 2.9 selection exists for answer No
				String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hc.Answer2)).getAttribute("class");
				softly.assertThat(s2).as("test data").contains("ui-radio-off");
				String r2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hc.ReasonEntryField)).getAttribute("value");
				softly.assertThat(r2).as("test data").contains("");
				//Verify if next button is disabled
				if(driver.findElement(hc.NextButton).isEnabled())
				{
					softly.fail("Next button enabled 2.9");
					//Click next at 2.9
					wait.until(ExpectedConditions.visibilityOfElementLocated(hc.NextButton)).click();
					Thread.sleep(2000);
					//Verify if 2.10 selection exists for answer No
					String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hc.Answer2)).getAttribute("class");
					softly.assertThat(s3).as("test data").contains("ui-radio-off");
					String r3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hc.ReasonEntryField)).getAttribute("value");
					softly.assertThat(r3).as("test data").contains("");
					//Verify if next button is disabled
					if(driver.findElement(hc.NextButton).isEnabled())
					{
						softly.fail("Next button enabled 2.10");
						//Click next at 2.10
						wait.until(ExpectedConditions.visibilityOfElementLocated(hc.NextButton)).click();
						Thread.sleep(2000);
						//Verify if 2.11 selection exists for answer No
						String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(hc.Answer2)).getAttribute("class");
						softly.assertThat(s4).as("test data").contains("ui-radio-off");
						String r4 = wait.until(ExpectedConditions.visibilityOfElementLocated(hc.ReasonEntryField)).getAttribute("value");
						softly.assertThat(r4).as("test data").contains("");
						//Verify if next button is disabled
						if(driver.findElement(hc.NextButton).isEnabled())
						{
							softly.fail("Next button enabled 2.11");
							//Click next at 2.11
							wait.until(ExpectedConditions.visibilityOfElementLocated(hc.NextButton)).click();
							Thread.sleep(2000);
							//Verify if 2.12 selection exists for answer No
							String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(hc.Answer2)).getAttribute("class");
							softly.assertThat(s5).as("test data").contains("ui-radio-off");
							String r5 = wait.until(ExpectedConditions.visibilityOfElementLocated(hc.ReasonEntryField)).getAttribute("value");
							softly.assertThat(r5).as("test data").contains("");
						}
					}
				}
			}
		}

	}

}
