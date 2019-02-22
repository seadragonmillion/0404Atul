import java.util.Random;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HiRCALOPBug {

	String text = "HiRCA bug LOP";
	String reason = "reason entry";
	String reason1 = "reason entry 1";
	String reason2 = "reason entry 2";
	String reason3 = "reason entry 3";
	SoftAssertions softly = new SoftAssertions();

	By AnalysisLink = By.id("pii-main-menu-button-a");
	By HiRCALink = By.id("pii-a-menu-hirca");

	//Info Page
	By HiRCAEventTitleField = By.id("pii-irca-event-title");
	By HiRCAEventLocationField = By.id("pii-irca-event-location");

	By DescriptionPlusSign = By.xpath(".//*[@id='efi-irca-description']/h4/a");
	By DescriptionText = By.id("efi-irca-description-text");

	public void fillUpHiRCAEventInfo(WebDriver driver,String text) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		ShareCheck obj = new ShareCheck();
		fillPage(driver,text);
		obj.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[16]/div/button"))));
		//Clicks on next
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[16]/div/button"))).click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[16]/div/button"))));
		Thread.sleep(2000);
	}
	
	public void fillPage(WebDriver driver,String text) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		ShareCheck obj = new ShareCheck();
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Clicks on Analysis 
		wait.until(ExpectedConditions.visibilityOfElementLocated(AnalysisLink)).click();
		//Clicks on HiRCA
		wait.until(ExpectedConditions.visibilityOfElementLocated(HiRCALink)).click();
		Thread.sleep(2000);
		//Event title
		wait.until(ExpectedConditions.visibilityOfElementLocated(HiRCAEventTitleField)).sendKeys(text);
		//Location of event
		wait.until(ExpectedConditions.visibilityOfElementLocated(HiRCAEventLocationField)).sendKeys(text);
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

	public void bugKALE2219KALE2246(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		ShareCheck obj = new ShareCheck();
		HiRCALevel1 obj1 = new HiRCALevel1();
		HiRCA2 obj2 = new HiRCA2();
		//Click on new for new report
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.HiRCANewReportButton)).click();
		//Verify new report pop up
		obj2.verifyNewReportPopup(driver, softly);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		Thread.sleep(2000);
		//Event title
		wait.until(ExpectedConditions.visibilityOfElementLocated(HiRCAEventTitleField)).sendKeys(text+" \"title\" "+text);
		//Location of event
		wait.until(ExpectedConditions.visibilityOfElementLocated(HiRCAEventLocationField)).sendKeys(text+" \"foo\" "+text);
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
		obj.scrollToTop(driver);
		//Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))).click();
		//Clicks on Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-success")));
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Click on saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-btn-savedactivities"))).click();
		//Wait for loading message to disappear		  
		obj.loadingServer(driver);
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).getText();
		softly.assertThat(s2).as("test data").contains(text+" \"title\" "+text);
		//Click on newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();
		//Wait for loading message to disappear		  
		obj.loadingServer(driver);
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
			obj.scrollToTop(driver);
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-tab-0"))));
		}
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(HiRCAEventLocationField)).getAttribute("value");
		softly.assertThat(s1).as("test data").isEqualTo(text+" \"foo\" "+text);
		//Click on saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-btn-savedactivities"))).click();
		//Wait for loading message to disappear		  
		obj.loadingServer(driver);
		//Click on newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();
		//Wait for loading message to disappear		  
		obj.loadingServer(driver);
		//Delete
		obj1.deleteReport(driver);
		//Go to KALE homepage
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pii-logo-div-element-kale"))).click();
	}

	public void bugKALE1957(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		ShareCheck obj = new ShareCheck();
		HiRCA2 obj1 = new HiRCA2();
		//Click on new for new report
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.HiRCANewReportButton)).click();
		//Verify new report pop up
		obj1.verifyNewReportPopup(driver, softly);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		Thread.sleep(2000);
		//Go to KALE homepage
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pii-logo-div-element-kale"))).click();
		fillUpHiRCAEventInfo(driver,text);
		//Click on Act of nature
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//Click on LOP
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		Thread.sleep(2000);
		//Click on Yes
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-lopinplace-yes']"))).click();
		Thread.sleep(2000);
		//Scroll down
		obj.scrollToAPoint(driver, 1200);
		Thread.sleep(1000);//Select number of LOPs and LOPs randomly
		int y = selectNumberOfLOPs(driver);
		System.out.println(y);
		//Scroll to the top
		Thread.sleep(2000);
		obj.scrollToTop(driver);
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Select Yes for 2.1 and answers for 3.17 for both LOPs
		for(int i=1;i<=y;i++)
		{
			//Click Yes for 2.1
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
			Thread.sleep(2000);
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			Thread.sleep(2000);
			//Select L 3.17 random options
			select317Random(driver);
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			Thread.sleep(2000);
		}
		//Go Back to Step 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-tab-1"))).click();
		//Select Human error
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Click on Knowledge-based 1.2.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Select 3.4 as random
		select34Random(driver);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Skip from 3.18, 1.6-1.20
		for(int i=1;i<=16;i++)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
			Thread.sleep(1000);
		}
		Thread.sleep(2000);
		//Select RC from pop up
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed2"))));
		obj.scrollToTop(driver);
		//Go to Step 2
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("pii-irca-dialog-confirmed2")));
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-tab-2"))).click();
		}catch(org.openqa.selenium.WebDriverException t)
		{
			obj.scrollToTop(driver);
			executor.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-tab-2"))));
		}
		//Verify Step 2 page of question 2.0
		verifyStep2Q2_0(driver);
	}

	public void verifyStep2Q2_0(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-initialquestions']/div/div[1]"))).getText();
		softly.assertThat(s).as("test data").contains("Were there LOPs in place to prevent the triggering event?");
		String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(s13).as("test data").contains("[2.0] What were the failed LOPs (3 max) that caused this event to happen?");
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]"))).getText().trim();
		softly.assertThat(s1).as("test data").isEqualTo("Briefings (PJB, MJB, PSM, TO, etc.)");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]"))).getText().trim();
		softly.assertThat(s2).as("test data").isEqualTo("Concurrent check");
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]"))).getText().trim();
		softly.assertThat(s3).as("test data").isEqualTo("Error-proof design");
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]"))).getText().trim();
		softly.assertThat(s4).as("test data").isEqualTo("Independent check");
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]"))).getText().trim();
		softly.assertThat(s5).as("test data").isEqualTo("JIT alarm");
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]"))).getText().trim();
		softly.assertThat(s6).as("test data").isEqualTo("JIT reminder (signage, not-to do postings)");
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]"))).getText().trim();
		softly.assertThat(s7).as("test data").isEqualTo("Passive protection (safety net, fall protection, air bags, safety belt, etc.)");
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]"))).getText().trim();
		softly.assertThat(s8).as("test data").isEqualTo("Peer coaching");
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]"))).getText().trim();
		softly.assertThat(s9).as("test data").isEqualTo("Review (PNR, Technical review)");
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]"))).getText().trim();
		softly.assertThat(s10).as("test data").isEqualTo("Self-check");
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[12]"))).getText().trim();
		softly.assertThat(s11).as("test data").isEqualTo("Supervisory intervention");
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[13]"))).getText().trim();
		softly.assertThat(s12).as("test data").contains("Other:");
	}


	public void bugPathWith3LopsKALE1926(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		ShareCheck obj = new ShareCheck();
		HiRCA2 obj1 = new HiRCA2();
		//Click on new for new report
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.HiRCANewReportButton)).click();
		//Verify new report pop up
		obj1.verifyNewReportPopup(driver, softly);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		Thread.sleep(2000);
		//Go to KALE homepage
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pii-logo-div-element-kale"))).click();
		fillUpHiRCAEventInfo(driver,text);
		//Click on Act of nature
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Click on Root Cause
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed2"))).click();
		//Click back
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-back"))).click();
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Click on LOP
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		Thread.sleep(2000);
		//Click on Yes
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-lopinplace-yes']"))).click();
		Thread.sleep(2000);
		//Scroll down
		obj.scrollToAPoint(driver, 1200);
		//Select 3 LOPs randomly
		//Choose a number between 2 and 13 for LOPs
		Random random = new Random();
		int y;
		for(int i=0;i<3;i++)
		{
			while(true)
			{
				y=random.nextInt(9);
				System.out.println("Chose a no"+y);
				if(y==0)
					y=y+2;
				if(y==1)
					y=y+1;
				String e=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))).getAttribute("class");
				if(e.contains("ui-checkbox-on"))
					continue;
				break;
			}
			System.out.println("Picked a no");
			System.out.println("Option no: "+y);
			Thread.sleep(500);
			//Click on LOP
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))));
		}
		//Scroll to the top
		Thread.sleep(2000);
		obj.scrollToTop(driver);
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Enter reason entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason1);
		//Click Yes for 2.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Select L 3.17 random options
		select317Random(driver);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Enter reason entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason);
		//Click no for 2.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Enter reason entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason);
		//Click no for 2.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Skip 2.9
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		//Skip 2.10
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		//Skip 2.11
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		//Skip 2.12
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		//Verify 2.1 question appeared
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(s).as("test data").contains("[2.1] Did equipment failure cause LOP to fail?");
		//Verify 2.1 of 3/3 LOP
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		softly.assertThat(s1).as("test data").contains("Step 2: Layers of Protection Failure Inquiry - LOP 3/3:");
		//Verify reason entry empty
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getText();
		softly.assertThat(s2).as("test data").contains("");
	}

	public void bugPathWith1LopKALE1926(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		ShareCheck obj = new ShareCheck();
		HiRCA2 obj1 = new HiRCA2();
		//Click on new for new report
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.HiRCANewReportButton)).click();
		//Verify new report pop up
		obj1.verifyNewReportPopup(driver, softly);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		Thread.sleep(2000);
		//Go to KALE homepage
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pii-logo-div-element-kale"))).click();
		fillUpHiRCAEventInfo(driver,text);
		//Click on Act of nature
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Click on Root Cause
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed2"))).click();
		//Click back
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-back"))).click();
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Click on LOP
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		Thread.sleep(2000);
		//Click on Yes
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-lopinplace-yes']"))).click();
		Thread.sleep(2000);
		//Scroll down
		obj.scrollToAPoint(driver, 1200);
		//Select 1 LOP randomly
		//Choose a number between 2 and 13 for LOPs
		Random random = new Random();
		int y;
		while(true)
		{
			y=random.nextInt(9);
			System.out.println("Chose a no"+y);
			if(y==0)
				y=y+2;
			if(y==1)
				y=y+1;
			String e=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))).getAttribute("class");
			if(e.contains("ui-checkbox-on"))
				continue;
			break;
		}
		System.out.println("Picked a no");
		System.out.println("Option no: "+y);
		Thread.sleep(500);
		//Click on LOP
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))));
		//Scroll to the top
		Thread.sleep(2000);
		obj.scrollToTop(driver);
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Enter reason entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason1);
		//Click Yes for 2.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Select L 3.17 random options
		select317Random(driver);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Skip 2.20 and 2.22
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(1000);
		//Verify 2.22
		verify222(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(1000);		
		//Verify Step 3 SUEP tab
		verifyStep3SUEP(driver);
	}

	public void verify222(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(s).as("test data").contains("[2.22] Was HiRCA");
		softly.assertThat(s).as("test data").contains(" adequate in leading this investigation?");
		//Verify collapsible of description
		collapsibleCheckDescription(driver);
		//Click on Description
		if(driver.findElement(DescriptionText).isDisplayed()==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(DescriptionPlusSign)).click();
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(DescriptionText)).getText();
		softly.assertThat(s1).as("test data").contains("This question looks into how HiRCA");
		softly.assertThat(s1).as("test data").contains(" has provided support in the investigation.");
		//Close description
		wait.until(ExpectedConditions.visibilityOfElementLocated(DescriptionPlusSign)).click();		
	}

	public void collapsibleCheckDescription(WebDriver driver) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify the presence of description
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(DescriptionPlusSign));	    		
		}catch (org.openqa.selenium.NoSuchElementException|org.openqa.selenium.TimeoutException r)
		{
			System.out.println("No description text on this page");
			return;
		}
		//Verify description text not visible
		try{
			WebElement l = driver.findElement(DescriptionText);
			if(l.isDisplayed()==true)
				softly.fail("Description text visible");
		}catch (org.openqa.selenium.NoSuchElementException r)
		{
			System.out.println("No description text visible as the + sign for description has not been clicked");
		}
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(DescriptionPlusSign)).click();
		//Verify description text
		wait.until(ExpectedConditions.visibilityOfElementLocated(DescriptionText));
		//Click on Description again
		wait.until(ExpectedConditions.visibilityOfElementLocated(DescriptionPlusSign)).click();
		//Verify description text not visible
		try{
			WebElement l = driver.findElement(DescriptionText);
			if(l.isDisplayed()==true)
				softly.fail("Description text visible");
		}catch (org.openqa.selenium.NoSuchElementException r)
		{
			System.out.println("No description text visible as the + sign for description has not been clicked");
		}
	}

	public void bugPathWith2LopsKALE1926(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		ShareCheck obj = new ShareCheck();
		HiRCA2 obj1 = new HiRCA2();
		//Click on new for new report
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.HiRCANewReportButton)).click();
		//Verify new report pop up
		obj1.verifyNewReportPopup(driver, softly);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		Thread.sleep(2000);
		//Go to KALE homepage
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pii-logo-div-element-kale"))).click();
		fillUpHiRCAEventInfo(driver,text);
		//Click on Act of nature
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Click on Root Cause
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed2"))).click();
		//Click back
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-back"))).click();
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Click on LOP
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		Thread.sleep(2000);
		//Click on Yes
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-lopinplace-yes']"))).click();
		Thread.sleep(2000);
		//Scroll down
		obj.scrollToAPoint(driver, 1200);
		//Select 2 LOPs randomly
		//Choose a number between 2 and 13 for LOPs
		Random random = new Random();
		int y;
		for(int i=0;i<2;i++)
		{
			while(true)
			{
				y=random.nextInt(9);
				System.out.println("Chose a no"+y);
				if(y==0)
					y=y+2;
				if(y==1)
					y=y+1;
				String e=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))).getAttribute("class");
				if(e.contains("ui-checkbox-on"))
					continue;
				break;
			}
			System.out.println("Picked a no");
			System.out.println("Option no: "+y);
			Thread.sleep(500);
			//Click on LOP
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))));
		}
		//Scroll to the top
		Thread.sleep(2000);
		obj.scrollToTop(driver);
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Enter reason entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason1);
		//Click no for 2.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Select L 3.17 random options
		select317Random(driver);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Enter reason entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason);
		//Click no for 2.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Enter reason entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason);
		//Click no for 2.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Skip 2.9
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		//Skip 2.10
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		//Skip 2.11
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		//Skip 2.12
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		//Skip 2.20
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		//Verify 2.22
		verify222(driver);
		//Skip 2.22
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		//Verify SUEP Tab appeared
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(s).as("test data").contains("Step 3 - Root Causes Determination Checklist (SUEP");
		//with 3 LOPs
		bugPathWith3LopsKALE1926(driver);
		//with 1 LOP
		bugPathWith1LopKALE1926(driver);
	}

	public void bugPath1KALE1947(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		HiRCA2 obj = new HiRCA2();
		//Click on new for new report
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.HiRCANewReportButton)).click();
		//Verify new report pop up
		obj.verifyNewReportPopup(driver, softly);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		Thread.sleep(2000);
		//Go to KALE homepage
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pii-logo-div-element-kale"))).click();
		fillUpHiRCAEventInfo(driver,text);
		//Click on Human error
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Click on Knowledge-based 1.2.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Select 3.4 as random
		select34Random(driver);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Skip from 3.18, 1.6-1.20
		for(int i=1;i<=16;i++)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
			Thread.sleep(1000);
		}
		Thread.sleep(2000);
		//Select LOP from pop up
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		Thread.sleep(2000);
		//Click on Yes
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-lopinplace-yes']"))).click();
		Thread.sleep(2000);
		//Select LOPs Briefings and Concurrent Check
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Click yes for equipment failure
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Enter reason entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason1);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Select 3.17.1 for briefings
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(1000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Click yes for equipment failure
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Enter reason entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason2);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Select 3.17.2 for concurrent check
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(1000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 2.20 
		verify220(driver);
		//Click on Step 2 Tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-tab-2"))).click();
		Thread.sleep(2000);
		//Select error-proof design as 3rd LOP
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//Click modify
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))));
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify LOP 1/3 title
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		softly.assertThat(s).as("test data").contains("Step 2: Layers of Protection Failure Inquiry - LOP 1/3: Briefings (PJB, MJB, PSM, TO, etc.)");
		//Verify yes selection for equipment
		if(driver.findElement(By.xpath(".//*[@id='efi-irca-answer-0']")).isSelected()==false)
		{
			softly.fail("LOP 1/3 yes is not selected for equipment failure");
		}
		//Verify reason entry
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getText();
		softly.assertThat(s1).as("test data").isEqualTo(reason1);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.17.1 selection for LOP 1/3
		if(driver.findElement(By.xpath(".//*[@id='efi-irca-answer-0']")).isSelected()==false)
		{
			softly.fail("3.17.1 not selected for lop 1/3");
		}
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify LOP 2/3 title
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		softly.assertThat(s2).as("test data").contains("Step 2: Layers of Protection Failure Inquiry - LOP 2/3: Concurrent check");
		//Verify yes selection for equipment
		if(driver.findElement(By.xpath(".//*[@id='efi-irca-answer-0']")).isSelected()==false)
		{
			softly.fail("LOP 2/3 yes is not selected for equipment failure");
		}
		//Verify reason entry
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getText();
		softly.assertThat(s3).as("test data").isEqualTo(reason2);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.17.2 selection for LOP 2/3
		if(driver.findElement(By.xpath(".//*[@id='efi-irca-answer-1']")).isSelected()==false)
		{
			softly.fail("3.17.2 not selected for lop 2/3");
		}
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Click yes for equipment failure
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Enter reason entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason3);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Select 3.17.3 for error-proof design
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Skip 2.20 and 2.22
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(1000);
		//Verify 2.22
		verify222(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(1000);
		//Verify Step 3 SUEP tab
		verifyStep3SUEP(driver);
		//Click back for 2.20 and 2.22
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-back"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-back"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-back"))).click();
		Thread.sleep(2000);
		//Verify 3.17.3 selection for LOP 3/3
		if(driver.findElement(By.xpath(".//*[@id='efi-irca-answer-2']")).isSelected()==false)
		{
			softly.fail("3.17.3 not selected for lop 3/3");
		}
		//Back
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-back"))).click();
		Thread.sleep(2000);
		//Verify LOP 3/3 title
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		softly.assertThat(s4).as("test data").contains("Step 2: Layers of Protection Failure Inquiry - LOP 3/3: Error-proof design");
		//Verify yes selection for equipment
		if(driver.findElement(By.xpath(".//*[@id='efi-irca-answer-0']")).isSelected()==false)
		{
			softly.fail("LOP 3/3 yes is not selected for equipment failure");
		}
		//Verify reason entry
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getText();
		softly.assertThat(s5).as("test data").isEqualTo(reason3);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.17.3 selection for LOP 3/3
		if(driver.findElement(By.xpath(".//*[@id='efi-irca-answer-2']")).isSelected()==false)
		{
			softly.fail("3.17.3 not selected for lop 3/3");
		}
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 2.20 
		verify220(driver);
		//Skip 2.20 and 2.22
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(1000);
		//Verify 2.22
		verify222(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(1000);
		//Verify Step 3 SUEP tab
		verifyStep3SUEP(driver);
	}

	public void createReportForbugKALE1846(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		HiRCA2 obj = new HiRCA2();
		//Click on new for new report
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.HiRCANewReportButton)).click();
		//Verify new report pop up
		obj.verifyNewReportPopup(driver, softly);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		Thread.sleep(2000);
		//Go to KALE homepage
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pii-logo-div-element-kale"))).click();
		fillUpHiRCAEventInfo(driver,text);
		//Click on Equipment error 1.1.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Select 3.17 random
		select317Random(driver);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Select LOP from pop up
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		Thread.sleep(2000);
		//Click on Yes
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-lopinplace-yes']"))).click();
		Thread.sleep(2000);
		//Select LOPs Briefings, Concurrent Check and Error Proof Design
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Click yes for equipment failure
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Enter reason entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason1);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Select 3.17.1 for briefings
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(1000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Click yes for equipment failure
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Enter reason entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason2);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Select 3.17.2 for concurrent check
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(1000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Click yes for equipment failure
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Enter reason entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason3);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Select 3.17.3 for error proof design
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(1000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 2.20 
		verify220(driver);
	}

	public int selectNumberOfLOPs(WebDriver driver)throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,30);
		ShareCheck obj = new ShareCheck();
		//Scroll down
		obj.scrollToAPoint(driver, 1200);
		//Select no of LOPs randomly 1 to 3
		Random random = new Random();
		int y;
		while(true)
		{
			y=random.nextInt(4);
			if(y==0)
				continue;
			break;
		}
		System.out.println("Number of LOPs: "+y);
		int x;
		for(int i=1;i<=y;i++)
		{
			//Select LOP randomly
			//Choose a number between 2 and 13 for LOPs		
			while(true)
			{
				x=random.nextInt(9);
				if(x==0||x==1)
					continue;
				String e=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+x+"]/fieldset/div/div/label"))).getAttribute("class");
				if(e.contains("ui-checkbox-on"))
					continue;
				break;
			}
			System.out.println("Option no: "+x);
			Thread.sleep(500);
			//Click on LOP
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+x+"]/fieldset/div/div/label"))));
		}
		//Scroll to the top
		Thread.sleep(2000);
		obj.scrollToTop(driver);
		Thread.sleep(2000);
		return y;
	}

	public void bugKALE1852(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		HiRCALevel1 obj = new HiRCALevel1();
		HiRCA2 obj1 = new HiRCA2();
		ShareCheck obj2 = new ShareCheck();
		//Click on new for new report
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.HiRCANewReportButton)).click();
		//Verify new report pop up
		obj1.verifyNewReportPopup(driver, softly);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		Thread.sleep(2000);
		//Go to KALE homepage
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pii-logo-div-element-kale"))).click();
		fillUpHiRCAEventInfo(driver,text);
		//Click on Act of Nature 1.1.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Select LOP from pop up
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		Thread.sleep(2000);
		//Click on No
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-lopinplace-no']"))).click();
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 2.21
		obj.verify221(driver);
		//Randomly select one LOP option
		int k = select221Random(driver);
		//Go to Step 2 Tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-tab-2"))).click();
		//Click on Yes
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-lopinplace-yes']"))).click();
		//Select number of LOPs and LOPs randomly
		int y = selectNumberOfLOPs(driver);
		System.out.println(y);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		for(int i=1;i<=y;i++)
		{
			//Verify 2.1 for LOP 1/1
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
			softly.assertThat(s).as("test data").contains("Step 2: Layers of Protection Failure Inquiry - LOP");
			String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
			softly.assertThat(s1).as("test data").contains("[2.1] Did equipment failure cause LOP to fail?");
			//Select No 2.1.2
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
			Thread.sleep(2000);		
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			Thread.sleep(2000);
			//Select No 2.2.3
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
			Thread.sleep(2000);		
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			Thread.sleep(2000);
			//Select No 2.9.2
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
			Thread.sleep(2000);		
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			Thread.sleep(2000);
			//Select No 2.10.2
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
			Thread.sleep(2000);		
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			Thread.sleep(2000);
			//Select No 2.11.2
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
			Thread.sleep(2000);		
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			Thread.sleep(2000);
			//Select No 2.12.2
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
			Thread.sleep(2000);		
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			Thread.sleep(2000);
		}
		//Skip 2.20
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(1000);
		//Go to Step 2 Tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-tab-2"))).click();
		//Click on No
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-lopinplace-no']"))).click();
		Thread.sleep(2000);
		//Modify
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))));
		Thread.sleep(2000);		
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 2.21
		obj.verify221(driver);
		//Verify LOP selected before is still selected
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-"+k+"']"))).getAttribute("class");
		if(s2.contains("ui-checkbox-on")==false)
			softly.fail("LOP is not selected in 2.21");
		//Click next
		obj2.scrollToTop(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
	}

	public int select221Random(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		ShareCheck obj = new ShareCheck();
		Random random = new Random();
		int y;
		//Choose a number between 0 and 11
		y=random.nextInt(12);
		System.out.println("Option no: "+y);
		Thread.sleep(1000);
		if(y>6)
		{
			obj.scrollToAPoint(driver, 1100);
		}
		//Click on a lop
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-"+y+"']"))));		
		Thread.sleep(2000);
		obj.scrollToTop(driver);
		Thread.sleep(2000);
		return y;
	}

	public void bugKALE1846(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Create a new report with 3 LOPs, reason entry and 3.17 selections
		createReportForbugKALE1846(driver);
		//Go to Step 2 Tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-tab-2"))).click();
		//Uncheck EPD
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//Click on modify
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))));
		//Click next till 2.20
		for (int i=1;i<=5;i++)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			Thread.sleep(2000);
		}
		//Click back
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-back"))).click();
		//Verify that 3.17 for Concurrent check occurs
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		softly.assertThat(s).as("test data").contains("Step 2: Layers of Protection Failure Inquiry - LOP 2/2: Concurrent check");
		//Verify 3.17.2 is checked
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getAttribute("class");
		if(s1.contains("ui-checkbox-on")==false)
			softly.fail("3.17.2 not checked for Concurrent Check");
		//Click back
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-back"))).click();
		//Verify that 2.1 for Concurrent check
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		softly.assertThat(s2).as("test data").contains("Step 2: Layers of Protection Failure Inquiry - LOP 2/2: Concurrent check");
		//Verify reason entry
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getText();
		softly.assertThat(s3).as("test data").isEqualTo(reason2);
		//Verify 2.1 question
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(s6).as("test data").contains("[2.1] Did equipment failure cause LOP to fail?");	
		//Click back
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-back"))).click();
		//Verify that 3.17 for Briefings occurs
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		softly.assertThat(s4).as("test data").contains("Step 2: Layers of Protection Failure Inquiry - LOP 1/2: Briefings (PJB, MJB, PSM, TO, etc.)");
		//Verify 3.17.1 is checked
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getAttribute("class");
		if(s5.contains("ui-checkbox-on")==false)
			softly.fail("3.17.1 not checked for Briefings");
		//Click back
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-back"))).click();
		//Verify that 2.1 for Concurrent check
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		softly.assertThat(s7).as("test data").contains("Step 2: Layers of Protection Failure Inquiry - LOP 1/2: Briefings (PJB, MJB, PSM, TO, etc.)");
		//Verify reason entry
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getText();
		softly.assertThat(s8).as("test data").isEqualTo(reason1);
		//Verify 2.1 question
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(s9).as("test data").contains("[2.1] Did equipment failure cause LOP to fail?");		
		//Click back
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-back"))).click();
		//Verify 2.0 question
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		softly.assertThat(s10).as("test data").contains("Step 2: Layers of Protection Failure Inquiry");
		//Verify LOP mentioned in 2.0
		HiRCALevel1 obj = new HiRCALevel1();
		obj.verifyLOP(driver);
		//Click next till you get to 2.20
		for (int i=1;i<=5;i++)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			Thread.sleep(2000);
		}
		//Click skip till report tab
		for (int i=1;i<=5;i++)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
			Thread.sleep(2000);
		}
		//Verify on Report Tab
		//Failed LOPs
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/table[1]/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(s11).as("test data").isEqualTo("Briefings (PJB, MJB, PSM, TO, etc.)");
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/table[1]/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(s12).as("test data").isEqualTo("Concurrent check");
		//LOP1 table
		String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/table[2]/thead/tr[1]/th[1]"))).getText();
		softly.assertThat(s13).as("test data").isEqualTo("LOP1: Briefings (PJB, MJB, PSM, TO, etc.)");
		//3.17.1 selected for briefings
		String s14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/table[2]/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(s14).as("test data").isEqualTo("3.17.1 Inadequate procurement and/or design specifications");
		//LOP2
		String s15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/table[3]/thead/tr[1]/th[1]"))).getText();
		softly.assertThat(s15).as("test data").isEqualTo("LOP2: Concurrent check");
		//3.17.2 selected for concurrent check
		String s16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/table[3]/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(s16).as("test data").isEqualTo("3.17.2 Inadequate source audit / inspection QA/QC for compliance (if applicable)");
		//2.0 selection of LOPs
		String s17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[7]/table[1]/tbody/tr[2]/td[2]/ul/li[1]"))).getText();
		softly.assertThat(s17).as("test data").isEqualTo("Briefings (PJB, MJB, PSM, TO, etc.)");
		String s18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[7]/table[1]/tbody/tr[2]/td[2]/ul/li[2]"))).getText();
		softly.assertThat(s18).as("test data").isEqualTo("Concurrent check");
		//LOP1
		String s19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/thead/tr[1]/th[1]"))).getText();
		softly.assertThat(s19).as("test data").isEqualTo("LOP1: Briefings (PJB, MJB, PSM, TO, etc.)");
		String s20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(s20).as("test data").isEqualTo(reason1);
		//3.17.1 selected for briefings
		String s21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[2]/td/div/table/tbody/tr/td[1]"))).getText();
		softly.assertThat(s21).as("test data").isEqualTo("3.17.1 Inadequate procurement and/or design specifications");
		//LOP2
		String s22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[9]/table/thead/tr[1]/th[1]"))).getText();
		softly.assertThat(s22).as("test data").isEqualTo("LOP2: Concurrent check");
		String s23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[9]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(s23).as("test data").isEqualTo(reason2);
		//3.17.2 selected for concurrent check
		String s24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[9]/table/tbody/tr[2]/td/div/table/tbody/tr/td[1]"))).getText();
		softly.assertThat(s24).as("test data").isEqualTo("3.17.2 Inadequate source audit / inspection QA/QC for compliance (if applicable)");
	}

	public void verifyStep3SUEP(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(s).as("test data").contains("Step 3 - Root Causes Determination Checklist (SUEP");
		//Verify SUEP full form
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		softly.assertThat(s1).as("test data").isEqualTo("S: Substandard Practice?");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]"))).getText();
		softly.assertThat(s2).as("test data").isEqualTo("U: Under Management Control?");
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]"))).getText();
		softly.assertThat(s3).as("test data").isEqualTo("E: Early in Event Sequence?");
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]"))).getText();
		softly.assertThat(s4).as("test data").isEqualTo("P: Prevention Of Recurrence?");
	}

	public void verify220(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(s).as("test data").contains("[2.20] If the triggering events need to be blocked by extra LOPs, please select them below:");
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Briefings (PJB, MJB, PSM, TO, etc.)");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Concurrent check");
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		softly.assertThat(s3).as("test data").isEqualTo("Error-proof design");
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Independent check");
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		softly.assertThat(s5).as("test data").isEqualTo("JIT alarm");
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).getText();
		softly.assertThat(s6).as("test data").isEqualTo("JIT reminder (signage, not-to do postings)");
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']"))).getText();
		softly.assertThat(s7).as("test data").isEqualTo("Passive protection (safety net, fall protection, air bags, safety belt, etc.)");
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-7']"))).getText();
		softly.assertThat(s8).as("test data").isEqualTo("Peer coaching");
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-8']"))).getText();
		softly.assertThat(s9).as("test data").isEqualTo("Review (PNR, Technical review)");
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-9']"))).getText();
		softly.assertThat(s10).as("test data").isEqualTo("Self-check");
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-10']"))).getText();
		softly.assertThat(s11).as("test data").isEqualTo("Supervisory intervention");
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-11']"))).getText();
		softly.assertThat(s12).as("test data").contains("Other:");
	}

	public void select34Random(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		ShareCheck obj = new ShareCheck();
		Random random = new Random();
		//Choose a number between 1 and 5 for number of selections
		int n;
		while(true)
		{
			n=random.nextInt(6);
			if(n==0)
				continue;
			else
				break;
		}
		System.out.println("No of selections: "+n);
		int y;
		for (int i=1;i<=n;i++)
		{
			//Choose a number between 2 and 6 for 3.4
			while(true)
			{
				y=random.nextInt(7);
				System.out.println("Chose a no"+y);
				if(y==0||y==1)
					continue;
				WebElement e=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/input")));
				if(e.isSelected())
					continue;
				break;
			}
			System.out.println("Picked a no");
			System.out.println("Option no: "+y);
			Thread.sleep(1000);
			//Click on a lop inquiry in 3.4
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))));
		}
		Thread.sleep(2000);
		obj.scrollToTop(driver);
		Thread.sleep(2000);
	}

	public void select317Random(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		ShareCheck obj = new ShareCheck();
		Random random = new Random();
		//Choose a number between 1 and 7 for number of selections
		int n;
		while(true)
		{
			n=random.nextInt(8);
			if(n==0)
				continue;
			else
				break;
		}
		System.out.println("No of selections: "+n);
		int y;
		for (int i=1;i<=n;i++)
		{
			//Choose a number between 2 and 8 for 3.17
			while(true)
			{
				y=random.nextInt(9);
				System.out.println("Chose a no"+y);
				if(y==0||y==1)
					continue;
				WebElement e=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/input")));
				if(e.isSelected())
					continue;
				break;
			}
			System.out.println("Picked a no");
			System.out.println("Option no: "+y);
			Thread.sleep(500);
			if(y>5)
				obj.scrollToAPoint(driver, 1200);
			if(y<=5)
				obj.scrollToTop(driver);
			Thread.sleep(1000);
			//Click on a lop inquiry in 3.17
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))));
		}
		Thread.sleep(2000);
		obj.scrollToTop(driver);
		Thread.sleep(2000);
	}

	public int selectOneLOP(WebDriver driver)throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,30);
		ShareCheck obj = new ShareCheck();
		//Scroll down
		obj.scrollToAPoint(driver, 1200);
		//Select on LOP randomly
		//Choose a number between 2 and 13 for LOPs
		Random random = new Random();
		int y;
		while(true)
		{
			y=random.nextInt(9);
			System.out.println("Chose a no"+y);
			if(y==0||y==1)
				continue;
			String e=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))).getAttribute("class");
			if(e.contains("ui-checkbox-on"))
				continue;
			break;
		}
		System.out.println("Picked a no");
		System.out.println("Option no: "+y);
		Thread.sleep(500);
		//Click on LOP
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))));
		//Scroll to the top
		Thread.sleep(2000);
		obj.scrollToTop(driver);
		Thread.sleep(2000);
		return y;
	}

	public void bugPath1KALE1959(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		ShareCheck obj = new ShareCheck();
		HiRCA2 obj1 = new HiRCA2();
		//Click on Act of nature
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Click on LOP
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		Thread.sleep(2000);
		//Click on Yes
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-lopinplace-yes']"))).click();
		Thread.sleep(2000);
		//Select one LOP randomly
		int y = selectOneLOP(driver);
		//Make selections from 2.1, 2.2 , 2.9-2.12
		makeSelections(driver);
		//Verify if previous selections there
		previousSelectionVerify(driver);
		//Click on back
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-back"))).click();
		Thread.sleep(2000);
		//Clear 2.0
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-clear"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		Thread.sleep(2000);
		//Scroll down 
		//Scroll to the top
		obj.scrollToAPoint(driver, 1200);
		//Click on same LOP
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))));
		//Click on modify
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed")));
		executor.executeScript("arguments[0].click();",	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))));
		//Scroll to the top
		Thread.sleep(2000);
		obj.scrollToTop(driver);
		Thread.sleep(2000);
		//Make selections from 2.1, 2.2 , 2.9-2.12
		makeSelections(driver);
		//Verify if previous selections there
		previousSelectionVerify(driver);
		//Select 2nd LOP and repeat verification
		select2ndLOP(driver);
		//Create new report
		//Click on new for new report
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.HiRCANewReportButton)).click();
		//Verify new report pop up
		obj1.verifyNewReportPopup(driver, softly);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		Thread.sleep(2000);
		//Go to KALE homepage
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pii-logo-div-element-kale"))).click();
		fillUpHiRCAEventInfo(driver,text);
		//Click on Human error
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Click on Rule-based 1.2.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Click on intentional 1.3.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		//Click no in 1.5.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Click no in 1.6.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Click no in 1.7.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Click no in 1.8.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Click no in 1.9.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Click no in 1.10.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Click no in 1.11.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Click no in 1.12.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Click no in 1.13.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Click yes in 1.14.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Click no in 1.15.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Click no in 1.16.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Click no in 1.17.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Click no in 1.18.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Click no in 1.19.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Click no in 1.20.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Click on LOP
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		Thread.sleep(2000);
		//Click on Yes
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-lopinplace-yes']"))).click();
		Thread.sleep(2000);
		//Select one LOP randomly
		y = selectOneLOP(driver);
		//Make selections from 2.1, 2.2 , 2.9-2.12
		makeSelections(driver);
		//Verify if previous selections there
		previousSelectionVerify(driver);
		//Click on back
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-back"))).click();
		Thread.sleep(2000);
		//Clear 2.0
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-clear"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		Thread.sleep(2000);
		//Scroll down 
		//Scroll to the top
		obj.scrollToAPoint(driver, 1200);
		//Click on same LOP
		executor.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))));
		//Click on modify
		executor.executeScript("arguments[0].click();",	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))));
		//Scroll to the top
		Thread.sleep(2000);
		obj.scrollToTop(driver);
		Thread.sleep(2000);
		//Make selections from 2.1, 2.2 , 2.9-2.12
		makeSelections(driver);
		//Verify if previous selections there
		previousSelectionVerify(driver);
		//Select 2nd LOP and repeat verification
		select2ndLOP(driver);
	}

	public void select2ndLOP (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		ShareCheck obj = new ShareCheck();
		//Click on back
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-back"))).click();
		Thread.sleep(2000);
		//Select 2nd LOP
		//Scroll down
		obj.scrollToAPoint(driver, 1200);
		//Select on LOP randomly
		int y;
		Random random = new Random();
		//Choose a number between 2 and 13 for LOPs
		while(true)
		{
			y=random.nextInt(9);
			System.out.println("Chose a no"+y);
			if(y==0||y==1)
				continue;
			String e=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))).getAttribute("class");
			if(e.contains("ui-checkbox-on"))
				continue;
			break;
		}
		System.out.println("Picked a no");
		System.out.println("Option no: "+y);
		Thread.sleep(500);
		//Click on LOP
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))));
		//Click modify
		executor.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))));
		//Scroll to the top
		Thread.sleep(2000);
		obj.scrollToTop(driver);
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Enter reason entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason);
		//Click no for 2.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Enter reason entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason);
		//Click no for 2.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Enter reason entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason);
		//Click no for 2.9
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Enter reason entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason);
		//Click no for 2.10
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Enter reason entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason);
		//Click no for 2.11
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Enter reason entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason);
		//Click no for 2.12
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(2000);
		//Click next
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Make selections from 2.1, 2.2 , 2.9-2.12 for 2nd LOP
		makeSelections(driver);
		//Verify if previous selections there for 2nd LOP
		previousSelectionVerify(driver);
	}

	public void makeSelections (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Enter reason entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason);
		//Click no for 2.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Enter reason entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason);
		//Click no for 2.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Enter reason entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason);
		//Click no for 2.9
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Enter reason entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason);
		//Click no for 2.10
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Enter reason entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason);
		//Click no for 2.11
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Enter reason entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason);
		//Click no for 2.12
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
	}


	public void previousSelectionVerify (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Verify if 2.1 selection exists for answer No
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getAttribute("class");
		softly.assertThat(s).as("test data").contains("ui-radio-off");
		String r = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("value");
		softly.assertThat(r).as("test data").contains("");
		//Verify if next button is disabled
		if(driver.findElement(By.id("efi-irca-button-next")).isEnabled())
		{
			softly.fail("Next button enabled 2.1");
			//Click next 2.1
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			Thread.sleep(2000);
			//Verify if 2.2 selection exists for answer No
			String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getAttribute("class");
			softly.assertThat(s1).as("test data").contains("ui-radio-off");
			String r1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("value");
			softly.assertThat(r1).as("test data").contains("");
			//Verify if next button is disabled
			if(driver.findElement(By.id("efi-irca-button-next")).isEnabled())
			{
				softly.fail("Next button enabled 2.2");
				//Click next 2.2
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
				Thread.sleep(2000);
				//Verify if 2.9 selection exists for answer No
				String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getAttribute("class");
				softly.assertThat(s2).as("test data").contains("ui-radio-off");
				String r2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("value");
				softly.assertThat(r2).as("test data").contains("");
				//Verify if next button is disabled
				if(driver.findElement(By.id("efi-irca-button-next")).isEnabled())
				{
					softly.fail("Next button enabled 2.9");
					//Click next at 2.9
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
					Thread.sleep(2000);
					//Verify if 2.10 selection exists for answer No
					String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getAttribute("class");
					softly.assertThat(s3).as("test data").contains("ui-radio-off");
					String r3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("value");
					softly.assertThat(r3).as("test data").contains("");
					//Verify if next button is disabled
					if(driver.findElement(By.id("efi-irca-button-next")).isEnabled())
					{
						softly.fail("Next button enabled 2.10");
						//Click next at 2.10
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
						Thread.sleep(2000);
						//Verify if 2.11 selection exists for answer No
						String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getAttribute("class");
						softly.assertThat(s4).as("test data").contains("ui-radio-off");
						String r4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("value");
						softly.assertThat(r4).as("test data").contains("");
						//Verify if next button is disabled
						if(driver.findElement(By.id("efi-irca-button-next")).isEnabled())
						{
							softly.fail("Next button enabled 2.11");
							//Click next at 2.11
							wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
							Thread.sleep(2000);
							//Verify if 2.12 selection exists for answer No
							String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getAttribute("class");
							softly.assertThat(s5).as("test data").contains("ui-radio-off");
							String r5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("value");
							softly.assertThat(r5).as("test data").contains("");
						}
					}
				}
			}
		}

	}


	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}

}
