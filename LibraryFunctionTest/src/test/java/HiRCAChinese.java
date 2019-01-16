import java.util.List;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HiRCAChinese {

	SoftAssertions softly = new SoftAssertions();
	String text = "Chinese check";

	public void chineseEventInfoFill (WebDriver driver, String text) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		HiRCAChinese4 obj = new HiRCAChinese4();
		ShareCheck obj1 = new ShareCheck();
		//Clicks on HiRCA
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-hirca"))).click();
		Thread.sleep(2000);
		//Verify everything on Event Information page is in 
		obj.chineseEventInfo(driver,softly);
		//Event title
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-title"))).sendKeys(text);
		//Location of event
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-location"))).sendKeys(text);
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
		//Gets value of date
		String get_date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-date"))).getAttribute("value");
		System.out.println(get_date);
		//Gets value of time
		String get_time = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-time"))).getAttribute("value");
		System.out.println(get_time);
		//Gets value of department
		String get_dept = driver.findElement(By.id("pii-irca-event-department")).getAttribute("value");
		System.out.println(get_dept);
		obj1.scrollToAPoint(driver, 6500);
		//Clicks on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[16]/div/button"))).click();
		Thread.sleep(2000);
	}

	public void pathHiRCA(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		ShareCheck obj = new ShareCheck();
		HiRCAChinese4 obj1 = new HiRCAChinese4();
		HiRCA2 obj2 = new HiRCA2();
		obj.loadingServer(driver);  
		//Clicks on Analysis 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-a"))).click();
		//Go to hirca and fill mandatory details on event info
		chineseEventInfoFill(driver,text);		
		//Verify chinese on Step1 tab q1.1
		obj1.chineseStepOneq11(driver,softly);
		//Check language change
		obj2.verifyChangeLanguage(driver, softly);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.2
		obj1.chineseStepOneq12(driver,softly);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.4
		obj1.chineseStepOneL34(driver,softly);
		//Check language change
		obj2.verifyChangeLanguage(driver, softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.18
		obj1.chineseStepOneL318(driver,softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.6
		obj1.chineseStepOneq16(driver,softly);
		//Check language change
		obj2.verifyChangeLanguage(driver, softly);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.15
		obj1.chineseStepOneL315(driver,softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.7
		obj1.chineseStepOneq17(driver,softly);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.8
		obj1.chineseStepOneq18(driver,softly);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.9
		obj1.chineseStepOneL39(driver,softly);
		//Check language change
		obj2.verifyChangeLanguage(driver, softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.10
		obj1.chineseStepOneL310(driver,softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.11
		obj1.chineseStepOneL311(driver,softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.9
		chineseStepOneq19(driver);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.2
		chineseStepOneL32(driver);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.11
		obj1.chineseStepOneL311(driver,softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.10
		chineseStepOneq110(driver);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.11
		chineseStepOneq111(driver);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.9
		obj1.chineseStepOneL39(driver,softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.12
		chineseStepOneq112(driver);
		//Check language change
		obj2.verifyChangeLanguage(driver, softly);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.13
		chineseStepOneq113(driver);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.14
		chineseStepOneq114(driver);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.2
		chineseStepOneL32(driver);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.15
		chineseStepOneq115(driver);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.6
		chineseStepOneL36(driver,softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.16
		chineseStepOneq116(driver);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.2
		chineseStepOneL32(driver);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.17
		chineseStepOneq117(driver);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.3
		chineseStepOneL33(driver);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.18
		chineseStepOneq118(driver);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.22
		chineseStepOneL322(driver,softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.19
		chineseStepOneq119(driver);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.3
		chineseStepOneL33(driver);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.5
		chineseStepOneL35(driver);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.20
		chineseStepOneq120(driver);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.5
		chineseStepOneL35(driver);
		//Check language change
		obj2.verifyChangeLanguage(driver, softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify pop up for LOP/RC
		chineseLOPRC(driver);
		//Save 1st path
		saveReport1st(driver);
		obj.loadingServer(driver); 
		//2nd path
		//Go to Analysis
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
		//Go to hirca and fill mandatory details on event info
		chineseEventInfoFill(driver,text);
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.1
		obj1.chineseStepOneq11(driver,softly);
		//Select answer 2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.17
		chineseStepOneL317(driver);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify pop up for LOP/RC
		chineseLOPRC(driver);		
		//Save 2nd path
		saveReport2nd(driver);	
		//3rd path
		obj.loadingServer(driver); 
		//Go to Analysis
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();		
		//Go to hirca and fill mandatory details on event info
		chineseEventInfoFill(driver,text);
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.1
		obj1.chineseStepOneq11(driver,softly);
		//Select answer 3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify pop up for LOP/RC
		chineseLOPRC(driver);
		//Save 3rd path
		saveReport3rd(driver);
		//4th path
		obj.loadingServer(driver); 
		//Go to Analysis
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
		//Go to hirca and fill mandatory details on event info
		chineseEventInfoFill(driver,text);
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.1
		obj1.chineseStepOneq11(driver,softly);
		//Select answer 1.1.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.2
		obj1.chineseStepOneq12(driver,softly);
		//Select answer 1.2.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.3
		obj1.chineseStepOneq13(driver,softly);
		//Select answer 1.3.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.12
		chineseStepOneL312(driver,softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.13
		chineseStepOneL313(driver,softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.14
		chineseStepOneL314(driver,softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.15
		obj1.chineseStepOneL315(driver,softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.5
		obj1.chineseStepOneq15(driver,softly);
		//Select answer 1.5.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.1
		obj1.chineseStepOneL31(driver,softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Skip 1.6 to 1.9
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.10
		chineseStepOneq110(driver);
		//Select answer 1.10.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.21
		obj1.chineseStepOneL321(driver,softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Skip 1.11 to 1.20
		for(int i=1;i<=10;i++)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
			Thread.sleep(2000);
		}
		//Verify pop up for LOP/RC
		chineseLOPRC(driver);
		//Save 4th path
		saveReport4th(driver);		
		//5th path
		obj.loadingServer(driver); 
		//Go to Analysis
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
		//Go to hirca and fill mandatory details on event info
		chineseEventInfoFill(driver,text);
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.1
		obj1.chineseStepOneq11(driver,softly);
		//Select answer 1.1.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.2
		obj1.chineseStepOneq12(driver,softly);
		//Select answer 1.2.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.3
		obj1.chineseStepOneq13(driver,softly);
		//Select answer 1.3.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.4
		obj1.chineseStepOneq14(driver,softly);
		//Select answer 1.4.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.16
		chineseStepOneL316(driver,softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Skip 1.5 to 1.20
		for(int i=1;i<=16;i++)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
			Thread.sleep(2000);
		}
		//Verify pop up for LOP/RC
		chineseLOPRC(driver);
		//Save 5th path
		saveReport5th(driver);
		//6th path
		obj.loadingServer(driver); 
		//Go to Analysis
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
		//Go to hirca and fill mandatory details on event info
		chineseEventInfoFill(driver,text);
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.1
		obj1.chineseStepOneq11(driver,softly);
		//Select answer 1.1.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.2
		obj1.chineseStepOneq12(driver,softly);
		//Select answer 1.2.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.3
		obj1.chineseStepOneq13(driver,softly);
		//Select answer 1.3.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.4
		obj1.chineseStepOneq14(driver,softly);
		//Select answer 1.4.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.6
		chineseStepOneL36(driver,softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.7
		chineseStepOneL37(driver,softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.8
		chineseStepOneL38(driver,softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.18
		obj1.chineseStepOneL318(driver,softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Skip 1.5 to 1.20
		for(int i=1;i<=16;i++)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
			Thread.sleep(2000);
		}
		//Verify pop up for LOP/RC
		chineseLOPRC(driver);
		//Save 6th path
		saveReport6th(driver);
	}

	public void saveReport6th (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		HiRCAChinese2 obj = new HiRCAChinese2();
		HiRCAChinese3 obj2 = new HiRCAChinese3();
		HiRCAChinese4 obj3 = new HiRCAChinese4();
		//LOP pop up opens, click Root Cause
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed2"))).click();
		Thread.sleep(2000);
		//Verify SUEP
		chineseSUEP(driver);
		//Verify all selections in SUEP as 6th path
		obj2.chineseLevel3SelectionsSUEP6th(driver, softly);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify Step 4
		chineseStep4(driver);
		//Verify all selections in step 4 as 6th path		
		obj3.chineseLevel3SelectionsStep4_6th(driver, softly);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify HiRCA Checklist
		chineseHIRCAChecklist(driver);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify Report
		chineseReport(driver);
		//Verify report for 6th path
		obj.chineseReport6thPath(driver,softly);
		//Save
		saveNewReport(driver);
		//Verify HTML report
		List <String> verifyChinese=obj2.chineseHTMLReport6thPath(driver, softly);
		//Download report and check pdf
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		String v = cap.getVersion().toString();
		System.out.println(v);
		//Download report to check pdf
		if (browserName.equals("chrome"))
			obj.downloadReportChrome(driver,softly,verifyChinese);
		if (browserName.equals("firefox"))
			obj.downloadReportFirefox(driver,softly,verifyChinese);
		if (browserName.equals("internet explorer"))
		{
			if (v.startsWith("10"))
				obj.downloadReportIE(driver,softly,verifyChinese);
			if (v.startsWith("11"))
				obj.downloadReportIE11(driver,softly,verifyChinese);
		}
		Thread.sleep(2000);
		//Delete report function is in main calling function
	}

	public void saveReport5th (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		HiRCAChinese3 obj = new HiRCAChinese3();
		HiRCAChinese2 obj1 = new HiRCAChinese2();
		HiRCAChinese4 obj2 = new HiRCAChinese4();
		HiRCALevel1 obj3 = new HiRCALevel1();
		//LOP pop up opens, click Root Cause
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed2"))).click();
		Thread.sleep(2000);
		//Verify SUEP
		chineseSUEP(driver);
		//Verify all selections in SUEP as 5th path
		obj.chineseLevel3SelectionsSUEP5th(driver, softly);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify Step 4
		chineseStep4(driver);
		//Verify all selections in step 4 as 5th path		
		obj2.chineseLevel3SelectionsStep4_5th(driver, softly);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify HiRCA Checklist
		chineseHIRCAChecklist(driver);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify Report
		chineseReport(driver);
		//Verify report for 5th path
		obj1.chineseReport5thPath(driver,softly);
		//Save
		saveNewReport(driver);
		//Verify HTML report
		List <String> verifyChinese=obj.chineseHTMLReport5thPath(driver, softly);
		//Download report and check pdf
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		String v = cap.getVersion().toString();
		System.out.println(v);
		//Download report to check pdf
		if (browserName.equals("chrome"))
			obj1.downloadReportChrome(driver,softly,verifyChinese);
		if (browserName.equals("firefox"))
			obj1.downloadReportFirefox(driver,softly,verifyChinese);
		if (browserName.equals("internet explorer"))
		{
			if (v.startsWith("10"))
				obj1.downloadReportIE(driver,softly,verifyChinese);
			if (v.startsWith("11"))
				obj1.downloadReportIE11(driver,softly,verifyChinese);
		}
		Thread.sleep(2000);
		//Delete report
		obj3.deleteReport(driver);
	}

	public void saveReport4th (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		HiRCAChinese3 obj = new HiRCAChinese3();
		HiRCAChinese2 obj1 = new HiRCAChinese2();
		HiRCALevel1 obj2 = new HiRCALevel1();
		HiRCAChinese4 obj3 = new HiRCAChinese4();
		//LOP pop up opens, click Root Cause
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed2"))).click();
		Thread.sleep(2000);
		//Verify SUEP
		chineseSUEP(driver);
		//Verify all selections in SUEP as 4th path
		obj.chineseLevel3SelectionsSUEP4th(driver, softly);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify Step 4
		chineseStep4(driver);
		//Verify all selections in step 4 as 4th path		
		obj3.chineseLevel3SelectionsStep4_4th(driver, softly);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify HiRCA Checklist
		chineseHIRCAChecklist(driver);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify Report
		chineseReport(driver);
		//Verify report for 4th path
		obj1.chineseReport4thPath(driver,softly);
		//Save
		saveNewReport(driver);
		//Verify HTML report
		List <String> verifyChinese=obj.chineseHTMLReport4thPath(driver, softly);
		//Download report and check pdf
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		String v = cap.getVersion().toString();
		System.out.println(v);
		//Download report to check pdf
		if (browserName.equals("chrome"))
			obj1.downloadReportChrome(driver,softly,verifyChinese);
		if (browserName.equals("firefox"))
			obj1.downloadReportFirefox(driver,softly,verifyChinese);
		if (browserName.equals("internet explorer"))
		{
			if (v.startsWith("10"))
				obj1.downloadReportIE(driver,softly,verifyChinese);
			if (v.startsWith("11"))
				obj1.downloadReportIE11(driver,softly,verifyChinese);
		}
		Thread.sleep(2000);
		//Delete report
		obj2.deleteReport(driver);
	}

	public void saveReport3rd (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		HiRCAChinese3 obj = new HiRCAChinese3();
		HiRCAChinese2 obj1 = new HiRCAChinese2();
		//LOP pop up opens, click Root Cause
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed2"))).click();
		Thread.sleep(2000);
		//Verify SUEP
		chineseSUEP(driver);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify Step 4
		chineseStep4(driver);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify HiRCA Checklist
		chineseHIRCAChecklist(driver);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify Report
		chineseReport(driver);
		//Verify report for 3rd path
		obj1.chineseReport3rdPath(driver,softly);
		//Save
		saveNewReport(driver);
		//Verify HTML report
		List <String> verifyChinese=obj.chineseHTMLReport3rdPath(driver, softly);
		//Download report and check pdf
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		String v = cap.getVersion().toString();
		System.out.println(v);
		//Download report to check pdf
		if (browserName.equals("chrome"))
			obj1.downloadReportChrome(driver,softly,verifyChinese);
		if (browserName.equals("firefox"))
			obj1.downloadReportFirefox(driver,softly,verifyChinese);
		if (browserName.equals("internet explorer"))
		{
			if (v.startsWith("10"))
				obj1.downloadReportIE(driver,softly,verifyChinese);
			if (v.startsWith("11"))
				obj1.downloadReportIE11(driver,softly,verifyChinese);
		}
		Thread.sleep(2000);
		//Delete report
		HiRCALevel1 obj2 = new HiRCALevel1();
		obj2.deleteReport(driver);
	}	

	public void saveReport2nd (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		HiRCAChinese2 obj = new HiRCAChinese2();
		HiRCAChinese3 obj2 = new HiRCAChinese3();
		//LOP pop up opens, click Root Cause
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed2"))).click();
		Thread.sleep(2000);
		//Verify SUEP
		chineseSUEP(driver);
		//Verify all selections in SUEP as 2nd path
		obj.chineseLevel3SelectionsSUEP2nd(driver, softly);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify Step 4
		chineseStep4(driver);
		//Verify all selections in step 4 as 2nd path		
		obj.chineseLevel3SelectionsStep4_2nd(driver, softly);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify HiRCA Checklist
		chineseHIRCAChecklist(driver);
		obj.selectAllChecklist(driver);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify Report
		chineseReport(driver);
		//Verify report for 2nd path
		obj.chineseReport2ndPath(driver,softly);
		//Save
		saveNewReport(driver);
		//Verify HTML report
		List <String> verifyChinese=obj2.chineseHTMLReport2ndPath(driver, softly);
		//Download report and check pdf
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		String v = cap.getVersion().toString();
		System.out.println(v);
		//Download report to check pdf
		if (browserName.equals("chrome"))
			obj.downloadReportChrome(driver,softly,verifyChinese);
		if (browserName.equals("firefox"))
			obj.downloadReportFirefox(driver,softly,verifyChinese);
		if (browserName.equals("internet explorer"))
		{
			if (v.startsWith("10"))
				obj.downloadReportIE(driver,softly,verifyChinese);
			if (v.startsWith("11"))
				obj.downloadReportIE11(driver,softly,verifyChinese);
		}
		Thread.sleep(2000);
		//Delete report
		HiRCALevel1 obj1 = new HiRCALevel1();
		obj1.deleteReport(driver);
	}	

	public void saveNewReport (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))).click();
		//Verify Save box
		chineseSave(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		//Wait for black server load message to disappear
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);
		//Click on saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-btn-savedactivities"))).click();
		//Wait for black server load message to disappear
		obj.loadingServer(driver);
		//Clicks on first newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();
		//Wait for black server load message to disappear
		obj.loadingServer(driver);
		//Verify buttons on top
		chineseReportButtons(driver);
	}

	public void saveReport1st (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		HiRCAChinese3 obj = new HiRCAChinese3();
		HiRCAChinese2 obj1 = new HiRCAChinese2();
		HiRCALevel1 obj2 = new HiRCALevel1();
		HiRCAChinese4 obj3 = new HiRCAChinese4();
		//LOP pop up opens, click Root Cause
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed2"))).click();
		Thread.sleep(2000);
		//Verify SUEP
		chineseSUEP(driver);
		//Verify all selections in SUEP as 1st path
		obj.chineseLevel3SelectionsSUEP1st(driver, softly);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify Step 4
		chineseStep4(driver);
		//Verify all selections in step 4 as 1st path		
		obj3.chineseLevel3SelectionsStep4_1st(driver, softly);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify HiRCA Checklist
		chineseHIRCAChecklist(driver);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify Report
		chineseReport(driver);
		//Verify report for 1st path
		obj1.chineseReport1stPath(driver,softly);
		//Save
		saveNewReport(driver);
		//Verify HTML report
		List <String> verifyChinese=obj.chineseHTMLReport1stPath(driver, softly);
		//Download report and check pdf
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		String v = cap.getVersion().toString();
		System.out.println(v);
		//Download report to check pdf
		if (browserName.equals("chrome"))
			obj1.downloadReportChrome(driver,softly,verifyChinese);
		if (browserName.equals("firefox"))
			obj1.downloadReportFirefox(driver,softly,verifyChinese);
		if (browserName.equals("internet explorer"))
		{
			if (v.startsWith("10"))
				obj1.downloadReportIE(driver,softly,verifyChinese);
			if (v.startsWith("11"))
				obj1.downloadReportIE11(driver,softly,verifyChinese);
		}
		Thread.sleep(2000);
		//Delete report
		obj2.deleteReport(driver);
	}	



	public void changeToChinese (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		Login obj = new Login();
		ShareCheck obj1 = new ShareCheck();
		while(true)
		{
			try{
				if (driver.findElement(obj.StickyNote).isDisplayed())
				{
					Thread.sleep(1000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj.StickyClose)).click();

				}}catch (NoSuchElementException e)
			{
					break;
			}
			catch( StaleElementReferenceException f)
			{

				break;
			}
			catch (org.openqa.selenium.TimeoutException u)
			{
				break;
			}
			catch (org.openqa.selenium.ElementNotInteractableException u)
			{
				break;
			}
			catch (org.openqa.selenium.JavascriptException t)
			{
				Thread.sleep(2000);
				break;
			}

		}
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		if(browserName.equals("firefox"))
		{
			//Clicks on Account
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-acct"))).click();
		}
		else
		{
			Actions act = new Actions (driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname")));
			WebElement element = driver.findElement(By.id("pii-user-loginname"));
			act.click(element).build().perform();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-acct")));
			element = driver.findElement(By.id("pii-user-acct"));
			act.click(element).build().perform();
			Thread.sleep(2000);
		}
		//Changes language to Chinese
		WebElement dropdown1 = driver.findElement(By.id("pii-admin-user-language"));
		Select s4 = new Select (dropdown1);
		s4.selectByVisibleText("Chinese");
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-button-save"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-confirmed"))).click();
		//Waits for loading message to disappear
		obj1.loadingServer(driver);
		//Go to KALE homepage
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pii-logo-div-element-kale"))).click();
	}



	public void changeToEnglish (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		while(true)
		{
			try{
				if (driver.findElement(By.className("sticky-note")).isDisplayed())
				{
					Thread.sleep(1000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();

				}}catch (NoSuchElementException e)
			{
					break;
			}
			catch( StaleElementReferenceException f)
			{

				break;
			}
			catch (org.openqa.selenium.TimeoutException u)
			{
				break;
			}
			catch (org.openqa.selenium.ElementNotInteractableException u)
			{
				break;
			}
			catch (org.openqa.selenium.JavascriptException t)
			{
				Thread.sleep(2000);
				break;
			}

		}
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		if(browserName.equals("firefox"))
		{
			//Clicks on Admin
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
			while(true)
			{
				Thread.sleep(1000);
				try{
					//Clicks on Account
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-acct"))).click();
					break;
				}catch(org.openqa.selenium.TimeoutException r)
				{
					//Clicks on Admin
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
				}
			}
		}
		else
		{
			Actions act = new Actions (driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname")));
			WebElement element = driver.findElement(By.id("pii-user-loginname"));
			act.click(element).build().perform();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-acct")));
			element = driver.findElement(By.id("pii-user-acct"));
			act.click(element).build().perform();
			Thread.sleep(2000);
		}
		//Changes language to English
		WebElement dropdown1 = driver.findElement(By.id("pii-admin-user-language"));
		Select s4 = new Select (dropdown1);
		s4.selectByVisibleText("English");
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-button-save"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-confirmed"))).click();
		//Waits for loading message to disappear
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);
		//Go to KALE homepage
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pii-logo-div-element-kale"))).click();
	}	

	public void chineseReportButtons(WebDriver driver)throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Back Button
		String back = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-uhome-back"))).getText();
		softly.assertThat(back).as("test data").contains("返回");
		//Other buttons
		String b1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[1]"))).getText();
		softly.assertThat(b1).as("test data").contains("开启");
		String b2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).getText();
		softly.assertThat(b2).as("test data").contains("打印");
		String b3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[3]"))).getText();
		softly.assertThat(b3).as("test data").contains("删除");
		String b4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[4]"))).getText();
		softly.assertThat(b4).as("test data").contains("分享");
	}

	public void chineseSave(WebDriver driver)throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		HiRCA2 obj = new HiRCA2();
		//Dialog header
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.HiRCAPopupHeader)).getText();
		softly.assertThat(heading).as("test data").contains("保存报告");
		//Dialog title
		String title = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.HiRCAPopupMessage)).getText();
		softly.assertThat(title).as("test data").contains("请确认你要存入现有报告进度?");
		//Cancel button
		String cn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-cancel"))).getText();
		softly.assertThat(cn).as("test data").contains("取消");
		//Save button
		String lop = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).getText();
		softly.assertThat(lop).as("test data").contains("保存报告");
	}

	public void chineseReport(WebDriver driver)throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Table1 header 
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[1]/table/thead/tr/th"))).getText();
		softly.assertThat(heading).as("test data").contains("事件信息");
		//Table1 Side titles of report 
		String title1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[1]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(title1).as("test data").contains("事件名称");
		String title2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[1]/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(title2).as("test data").contains("事件编号");
		String title3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[1]/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(title3).as("test data").contains("事件发生日期");
		String title4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[1]/table/tbody/tr[3]/td[3]"))).getText();
		softly.assertThat(title4).as("test data").contains("事件发生时间");
		String title5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[1]/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(title5).as("test data").contains("事件发生地点");
		String title6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[1]/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(title6).as("test data").contains("部门");
		String title7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[1]/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(title7).as("test data").contains("组");
		String title8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[1]/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(title8).as("test data").contains("事件调查员");
		String title9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[1]/table/tbody/tr[8]/td[1]"))).getText();
		softly.assertThat(title9).as("test data").contains("报告编写者");
		String title10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[1]/table/tbody/tr[9]/td[1]"))).getText();
		softly.assertThat(title10).as("test data").contains("报告编写时间");
		//Table2 header 
		String heading1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[2]/table/thead/tr/th"))).getText();
		softly.assertThat(heading1).as("test data").contains("事件名称");
		//Table2 Side titles of report 
		String title11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[2]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(title11).as("test data").contains("报告摘要");
		String title12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[2]/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(title12).as("test data").contains("事件描述");
		String title13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[2]/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(title13).as("test data").contains("事件详细过程（时序构建）");
		String title14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[2]/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(title14).as("test data").contains("相关信息");
		//header
		String header3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[3]"))).getText();
		softly.assertThat(header3).as("test data").contains("事件原因");
		//Table3 header 
		String heading4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[4]/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading4).as("test data").contains("根本原因");
		String heading5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[4]/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading5).as("test data").contains("重要性分级");
		String heading6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[4]/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading6).as("test data").contains("纠正行动");
		//Table4 header 
		String heading7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading7).as("test data").contains("促成因素");
		String heading8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading8).as("test data").contains("重要性分级");
		String heading9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading9).as("test data").contains("纠正行动");
		//Table4 row
		/*String r4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r4).as("test data").contains("不适用");
		String r5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r5).as("test data").contains("不适用");
		String r6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r6).as("test data").contains("不适用");*/
		//Table 5 heading
		String heading10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading10).as("test data").contains("缺少的屏障");
		//Table 5 row
		String r7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r7).as("test data").contains("未缺少屏障");
		//header
		String header11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/div"))).getText();
		softly.assertThat(header11).as("test data").contains("根本原因分析过程");
	}

	public void chineseHIRCAChecklist(WebDriver driver)throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//header
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(heading).as("test data").contains("第五步");
		softly.assertThat(heading).as("test data").contains("自检清单");
		//Table headers
		String th = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[1]/th[1]"))).getText();
		softly.assertThat(th).as("test data").contains("类别");
		String th1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[1]/th[2]"))).getText();
		softly.assertThat(th1).as("test data").contains("调查内容");
		String th2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[1]/th[3]"))).getText();
		softly.assertThat(th2).as("test data").contains("完成打勾?");
		//Row 1
		String tr = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[1]/strong"))).getText();
		softly.assertThat(tr).as("test data").contains("调查概述");
		String tr1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(tr1).as("test data").contains("是否访谈了所有相关方，是否收集了所有相关数据？");
		//Row 2
		String tr2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(tr2).as("test data").contains("是否检查了以往的类似事件？");
		//Row 3
		String tr3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(tr3).as("test data").contains("是否识别出始发事件和相关屏障？");
		//Row 4
		String tr4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[5]/td[1]/strong"))).getText();
		softly.assertThat(tr4).as("test data").contains("始发事件");
		String tr5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(tr5).as("test data").contains("是否确定始发事件的相关错误类型？");
		//Row 5
		String tr6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[6]/td[2]"))).getText();
		softly.assertThat(tr6).as("test data").contains("进行始发失误分析的始发事件中是否有相关的设备故障？");
		//Row 6
		String tr7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[7]/td[2]"))).getText();
		softly.assertThat(tr7).as("test data").contains("是否确定促成因子？");
		//Row 7
		String tr8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[8]/td[1]/strong"))).getText();
		softly.assertThat(tr8).as("test data").contains("根本原因");
		String tr9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[8]/td[2]"))).getText();
		softly.assertThat(tr9).as("test data").contains("根本原因是否符合");
		softly.assertThat(tr9).as("test data").contains(" 标准？");
		//Row 8
		String tr10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[9]/td[2]"))).getText();
		softly.assertThat(tr10).as("test data").contains("根本原因是否经得住");
		softly.assertThat(tr10).as("test data").contains("挑战？");
		//Row 9
		String tr11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[10]/td[2]"))).getText();
		softly.assertThat(tr11).as("test data").contains("是否识别根本原因的重要性？");
		//Row 10
		String tr12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[11]/td[1]/strong"))).getText();
		softly.assertThat(tr12).as("test data").contains("纠正行动");
		String tr13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[11]/td[2]"))).getText();
		softly.assertThat(tr13).as("test data").contains("建议的纠正行动是否涵盖所有直接原因、根本原因和关键促成因素？");
		//Row 11
		String tr14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[12]/td[2]"))).getText();
		softly.assertThat(tr14).as("test data").contains("建议的纠正行动是否具有成本效益？");
	}

	public void chineseStep4(WebDriver driver)throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//header
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(heading).as("test data").contains("第四步 - 判别根本原因和促成因素的重要性");
		//Table headers
		String th = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[1]/th[1]"))).getText();
		softly.assertThat(th).as("test data").contains("始发事件的根本原因与促成因素");
		String th1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[1]/th[2]"))).getText();
		softly.assertThat(th1).as("test data").contains("R:根本原因 或 C:促成因素");
		String th1d = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[1]/th[2]/div"))).getText();
		softly.assertThat(th1d).as("test data").contains("(R 或 C)");
		String th2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[1]/th[3]"))).getText();
		softly.assertThat(th2).as("test data").contains("重要性分级");
		String th2d = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[1]/th[3]/div"))).getText();
		softly.assertThat(th2d).as("test data").contains("(H:高, M:中 或 L:低)");
		/*
		//Row
		String tr = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(tr).as("test data").contains("不适用");
		String tr1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(tr1).as("test data").contains("不适用");
		String tr2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[3]"))).getText();
		softly.assertThat(tr2).as("test data").contains("不适用");
		 */
	}

	public void chineseSUEP(WebDriver driver)throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//header
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(heading).as("test data").contains("第三步 - 判别根本原因");
		//S
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		softly.assertThat(s).as("test data").contains(": 是否存在不合标准的实践?");
		//U
		String u = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]"))).getText();
		softly.assertThat(u).as("test data").contains(": 是否在管理层控制下?");
		//E
		String e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]"))).getText();
		softly.assertThat(e).as("test data").contains(": 是否在事件时序早期?");
		//P
		String p = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]"))).getText();
		softly.assertThat(p).as("test data").contains(": 是否防止再次发生?");
		//Table heading
		String th = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[1]/th[1]"))).getText();
		softly.assertThat(th).as("test data").contains("促成因素");
		/*
		//Row
		String tr = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(tr).as("test data").contains("不适用");
		String tr1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(tr1).as("test data").contains("不适用");
		String tr2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[3]"))).getText();
		softly.assertThat(tr2).as("test data").contains("不适用");
		String tr3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[4]"))).getText();
		softly.assertThat(tr3).as("test data").contains("不适用");
		String tr4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[5]"))).getText();
		softly.assertThat(tr4).as("test data").contains("不适用");
		 */
	}

	public void chineseLOPRC(WebDriver driver)throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		HiRCA2 obj = new HiRCA2();
		//Dialog header
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.HiRCAPopupHeader)).getText();
		softly.assertThat(heading).as("test data").contains("屏障或根本原因分析");
		//Dialog title
		String title = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.HiRCAPopupMessage)).getText();
		softly.assertThat(title).as("test data").contains("您要(1)继续分析屏障失效或是(2)前往根本原因分析？");
		//Dialog note
		String note = wait.until(ExpectedConditions.visibilityOfElementLocated(obj.HiRCAPopupNote)).getText();
		softly.assertThat(note).as("test data").contains("提醒：屏障失效分析可以随时回头再做。");
		//Cancel button
		String cn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-cancel"))).getText();
		softly.assertThat(cn).as("test data").contains("取消");
		//LOP button
		String lop = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).getText();
		softly.assertThat(lop).as("test data").contains("屏障");
		//Root cause button
		String rc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed2"))).getText();
		softly.assertThat(rc).as("test data").contains("根本原因");
	}

	public void chineseStepOneL313 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		ShareCheck obj = new ShareCheck();
		HiRCAChinese4 obj1 = new HiRCAChinese4();
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(heading).as("test data").contains("不当动机");
		softly.assertThat(heading).as("test data").contains("的促成因素");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		softly.assertThat(textD).as("test data").contains("若不适用点选skip略过。使用者可于底部新增促成因素。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		softly.assertThat(desc).as("test data").contains("这个问题探讨了不当动机（如提前下班回家、逃避恶劣的工作环境等）是否是故意违反（如简化屏障使用要求，不按照要求执行工前会等）的原因。请陈述动机不当是这个失误的促成因素的证据。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.13.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		softly.assertThat(q341).as("test data").contains("[3.13.1] 尽早完成工作，以便尽早回家");
		//Click on 3.13.1 to reveal evidence entry
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']")));
		String s = ele.getAttribute("class");
		if(s.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).getText();
		softly.assertThat(ev1).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Evidence entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-0"))).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//2nd collapsible for 3.13.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c1).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.13.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c2).as("test data").contains("观察到员工早于下班时间回家？");
		//Click on 2nd collapsible for 3.13.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.13.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c10).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.13.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c3).as("test data").contains("要求员工在办公室做其他相关工作，从而消除不当动机");
		//Click on 3rd collapsible for 3.13.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.13.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		softly.assertThat(q342).as("test data").contains("[3.13.2] 尽早完成工作，以便获得奖励或免受惩罚");
		//Click on 3.13.2 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']")));
		String s1 = ele.getAttribute("class");
		if(s1.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).getText();
		softly.assertThat(ev2).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Evidence entry place holder
		String ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-1"))).getAttribute("placeholder");
		softly.assertThat(ph2).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//2nd collapsible for 3.13.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c4).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.13.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c5).as("test data").contains("访谈员工了解影响他们的问责机制？");
		//Click on 2nd collapsible for 3.13.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.13.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.13.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c6).as("test data").contains("消除不当动机");
		String c26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		softly.assertThat(c26).as("test data").contains("采用质量和生产相平衡的奖励机制");
		//Click on 3rd collapsible for 3.13.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.13.3 question
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		softly.assertThat(q343).as("test data").contains("[3.13.3] 尽早完成工作，以便开始其他工作（尤其是根据完成的工作量计算价钱的承包商）");
		//Click on 3.13.3 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']")));
		String s2 = ele.getAttribute("class");
		if(s2.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).getText();
		softly.assertThat(ev3).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Evidence entry place holder
		String ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-2"))).getAttribute("placeholder");
		softly.assertThat(ph3).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//2nd collapsible for 3.13.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c7).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.13.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c8).as("test data").contains("访谈同事？");
		//Click on 2nd collapsible for 3.13.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.13.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c12).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.13.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c9).as("test data").contains("使用奖惩机制来杜绝赶时间的态度");
		//Click on 3rd collapsible for 3.13.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.13.4 question
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		softly.assertThat(q344).as("test data").contains("[3.13.4] 尽早完成工作，以便到更为舒适的环境中休息（尤其是在高温、有辐射或潮湿环境下工作）");
		//Click on 3.13.4 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']")));
		String s3 = ele.getAttribute("class");
		if(s3.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).getText();
		softly.assertThat(ev4).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Evidence entry place holder
		String ph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-3"))).getAttribute("placeholder");
		softly.assertThat(ph4).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//2nd collapsible for 3.13.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c13).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.13.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c14).as("test data").contains("观察工作环境？");
		//Click on 2nd collapsible for 3.13.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.13.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c16).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.13.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c17).as("test data").contains("给予充分的休息时间");
		String c35 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		softly.assertThat(c35).as("test data").contains("减少工作场所不舒适的工作条件");
		//Click on 3rd collapsible for 3.13.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Scroll to the end
		obj.scrollToAPoint(driver, 1100);
		//Verify Add Contributing factor
		obj1.chineseAddContributingFactor(driver, softly);
		//Scroll to the top
		Thread.sleep(2000);
		obj.scrollToTop(driver);
		Thread.sleep(2000);
	}

	public void chineseStepOneL314 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		ShareCheck obj = new ShareCheck();
		HiRCAChinese4 obj1 = new HiRCAChinese4();
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(heading).as("test data").contains("预期风险低");
		softly.assertThat(heading).as("test data").contains("的促成因素");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		softly.assertThat(textD).as("test data").contains("若不适用点选skip略过。使用者可于底部新增促成因素。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		softly.assertThat(desc).as("test data").contains("这个问题探讨了预期风险低是否促成犯错的原因。我们的研究发现当工作人员认为违章风险较低，他们更容易违反规则。风险是两个方面的和。一个方面是被抓到的概率和惩罚后果的乘积。另一方面是受伤概率和受伤后果的乘积。选择促成因素并针对所发现的预期风险低提供证据。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.14.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		softly.assertThat(q341).as("test data").contains("[3.14.1] 观察主管向下属提供反馈的频率和质量");
		//Click on 3.14.1 to reveal evidence entry
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']")));
		String s = ele.getAttribute("class");
		if(s.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).getText();
		softly.assertThat(ev1).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Evidence entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-0"))).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//2nd collapsible for 3.14.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c1).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.14.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c2).as("test data").contains("观察主管向下属提供反馈的频率和质量");
		//Click on 2nd collapsible for 3.14.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.14.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c10).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.14.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c3).as("test data").contains("监督管理能力培训");
		//Click on 3rd collapsible for 3.14.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.14.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		softly.assertThat(q342).as("test data").contains("[3.14.2] 违反既定规定的情况不容易被知道（尤其是单独工作时）");
		//Click on 3.14.2 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']")));
		String s1 = ele.getAttribute("class");
		if(s1.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).getText();
		softly.assertThat(ev2).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Evidence entry place holder
		String ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-1"))).getAttribute("placeholder");
		softly.assertThat(ph2).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//2nd collapsible for 3.14.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c4).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.14.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c5).as("test data").contains("访谈主管了解可能的捷径");
		//Click on 2nd collapsible for 3.14.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.14.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.14.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c6).as("test data").contains("提高工作绩效跟踪");
		//Click on 3rd collapsible for 3.14.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.14.3 question
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		softly.assertThat(q343).as("test data").contains("[3.14.3] 由于缺乏明确的问责制，认为违规的后果不严重");
		//Click on 3.14.3 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']")));
		String s2 = ele.getAttribute("class");
		if(s2.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).getText();
		softly.assertThat(ev3).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Evidence entry place holder
		String ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-2"))).getAttribute("placeholder");
		softly.assertThat(ph3).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//2nd collapsible for 3.14.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c7).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.14.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c8).as("test data").contains("访谈员工主管了解他们对问责制的感受");
		//Click on 2nd collapsible for 3.14.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.14.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c12).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.14.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c9).as("test data").contains("改善问责制");
		//Click on 3rd collapsible for 3.14.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.14.4 question
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		softly.assertThat(q344).as("test data").contains("[3.14.4] 违规造成的受伤风险被认为很低或没有");
		//Click on 3.14.4 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']")));
		String s3 = ele.getAttribute("class");
		if(s3.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).getText();
		softly.assertThat(ev4).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Evidence entry place holder
		String ph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-3"))).getAttribute("placeholder");
		softly.assertThat(ph4).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Click on 3.14.4 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		//2nd collapsible for 3.14.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c13).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.14.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c14).as("test data").contains("观察经验反馈学习会，以便了解是否经常讨论到受伤风险");
		//Click on 2nd collapsible for 3.14.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.14.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c16).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.14.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c17).as("test data").contains("改善问责制");
		//Click on 3rd collapsible for 3.14.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.14.5 question
		String q345 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		softly.assertThat(q345).as("test data").contains("[3.14.5] 由于有监护人在场，预期风险更低");
		//Click on 3.14.5 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']")));
		String s5 = ele.getAttribute("class");
		if(s5.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).getText();
		softly.assertThat(ev5).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Evidence entry place holder
		String ph5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-4"))).getAttribute("placeholder");
		softly.assertThat(ph5).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Click on 3.14.5 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		//2nd collapsible for 3.14.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c18).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.14.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c19).as("test data").contains("调查员工了解他们的惯常做法");
		//Click on 2nd collapsible for 3.14.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.14.5
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c20).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.14.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c21).as("test data").contains("提高监督");
		String c26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		softly.assertThat(c26).as("test data").contains("改善现场观察");
		String c35 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[3]"))).getText();
		softly.assertThat(c35).as("test data").contains("改善问责制");
		//Click on 3rd collapsible for 3.14.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Scroll to the end
		obj.scrollToAPoint(driver, 1100);
		//Verify Add Contributing factor
		obj1.chineseAddContributingFactor(driver, softly);
		//Scroll to the top
		Thread.sleep(2000);
		obj.scrollToTop(driver);
		Thread.sleep(2000);
	}

	public void chineseStepOneL312 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		ShareCheck obj = new ShareCheck();
		HiRCAChinese4 obj1 = new HiRCAChinese4();
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(heading).as("test data").contains("负担");
		softly.assertThat(heading).as("test data").contains("的促成因素");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		softly.assertThat(textD).as("test data").contains("若不适用点选skip略过。使用者可于底部新增促成因素。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		softly.assertThat(desc).as("test data").contains("这个问题探讨了故意违反是否是由于执行工作任务或使用屏障时感到麻烦负担造成的。负麻烦担仅仅是一种感觉，认为执行所花费的时间或努力都是不值得的。如果麻烦负担是失误发生的促成因素，为什么犯错者会有这种负担呢？");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.12.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		softly.assertThat(q341).as("test data").contains("[3.12.1] 觉得获取工具和设备有负担");
		//Click on 3.12.1 to reveal evidence entry
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']")));
		String s = ele.getAttribute("class");
		if(s.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).getText();
		softly.assertThat(ev1).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Evidence entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-0"))).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Click on 3.12.1 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//2nd collapsible for 3.12.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c1).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.12.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c2).as("test data").contains("观察员工；使用他们自己的工具（如多功能口袋工具，即：瑞士军刀）");
		//Click on 2nd collapsible for 3.12.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.12.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c10).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.12.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c3).as("test data").contains("紧急情况下工具的发放");
		String c35 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		softly.assertThat(c35).as("test data").contains("简化工具放置流程");
		String c37 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[3]"))).getText();
		softly.assertThat(c37).as("test data").contains("在方便的位置放置工具和设备");
		//Click on 3rd collapsible for 3.12.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.12.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		softly.assertThat(q342).as("test data").contains("[3.12.2] 觉得获取文件或程序有负担");
		//Click on 3.12.2 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']")));
		String s1 = ele.getAttribute("class");
		if(s1.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).getText();
		softly.assertThat(ev2).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Evidence entry place holder
		String ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-1"))).getAttribute("placeholder");
		softly.assertThat(ph2).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Click on 3.12.2 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//2nd collapsible for 3.12.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c4).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.12.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c5).as("test data").contains("观察员工现场携带程序");
		String c46 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c46).as("test data").contains("观察员工在开始工作前找到正确的程序");
		//Click on 2nd collapsible for 3.12.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.12.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.12.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c6).as("test data").contains("使用自动化系统获取文件或程序");
		String c26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		softly.assertThat(c26).as("test data").contains("将所参考程序的适用章节附在主程序后面");
		//Click on 3rd collapsible for 3.12.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.12.3 question
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		softly.assertThat(q343).as("test data").contains("[3.12.3] 觉得获取和穿戴PPE有负担");
		//Click on 3.12.3 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']")));
		String s2 = ele.getAttribute("class");
		if(s2.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).getText();
		softly.assertThat(ev3).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Evidence entry place holder
		String ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-2"))).getAttribute("placeholder");
		softly.assertThat(ph3).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Click on 3.12.3 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//2nd collapsible for 3.12.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c7).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.12.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c8).as("test data").contains("观察员工到作业现场时忘记携带安全帽、手套或安全鞋；观察员工是否可以轻松更换个人防护用品？");
		//Click on 2nd collapsible for 3.12.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.12.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c12).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.12.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c9).as("test data").contains("将PPE放置在方便的位置");
		String c36 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		softly.assertThat(c36).as("test data").contains("避免对PPE规定过度");
		//Click on 3rd collapsible for 3.12.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.12.4 question
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		softly.assertThat(q344).as("test data").contains("[3.12.4] 觉得使用过于复杂或繁琐的程序有负担");
		//Click on 3.12.4 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']")));
		String s3 = ele.getAttribute("class");
		if(s3.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).getText();
		softly.assertThat(ev4).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Evidence entry place holder
		String ph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-3"))).getAttribute("placeholder");
		softly.assertThat(ph4).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Click on 3.12.4 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		//2nd collapsible for 3.12.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c13).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.12.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c14).as("test data").contains("观察员工工作时没有逐步遵守手头程序？");
		//Click on 2nd collapsible for 3.12.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.12.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c16).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.12.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c17).as("test data").contains("使用无纸化程序系统");
		//Click on 3rd collapsible for 3.12.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.12.5 question
		String q345 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		softly.assertThat(q345).as("test data").contains("[3.12.5] 因觉得负担麻烦未到现场核实");
		//Click on 3.12.5 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']")));
		String s5 = ele.getAttribute("class");
		if(s5.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).getText();
		softly.assertThat(ev5).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Evidence entry place holder
		String ph5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-4"))).getAttribute("placeholder");
		softly.assertThat(ph5).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Click on 3.12.5 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		//2nd collapsible for 3.12.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c18).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.12.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c19).as("test data").contains("访谈犯错者和同事");
		//Click on 2nd collapsible for 3.12.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.12.5
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c20).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.12.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c21).as("test data").contains("增加偏出控制手段如拍照现场核实照片");
		//Click on 3rd collapsible for 3.12.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Scroll to the end
		obj.scrollToAPoint(driver, 1100);
		//Verify Add Contributing factor
		obj1.chineseAddContributingFactor(driver, softly);
		//Scroll to the top
		Thread.sleep(2000);
		obj.scrollToTop(driver);
		Thread.sleep(2000);
	}

	public void chineseStepOneL317 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		ShareCheck obj = new ShareCheck();
		HiRCAChinese4 obj1 = new HiRCAChinese4();
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(heading).as("test data").contains("设备的鉴定、试验和维修");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		softly.assertThat(textD).as("test data").contains("若不适用点选skip略过。使用者可于底部新增促成因素。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		softly.assertThat(desc).as("test data").contains("若始发事件是由设备失效造成，可初步评估设备可能失效原因。完整的设备根本原因分析或故障排除请使用EiRCA模块。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.17.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		softly.assertThat(q341).as("test data").contains("[3.17.1] 采购和（或）设计规范不充分");
		//Click on 3.17.1 to reveal evidence entry
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']")));
		String s = ele.getAttribute("class");
		if(s.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).getText();
		softly.assertThat(ev1).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Evidence entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-0"))).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Click on 3.17.1 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//2nd collapsible for 3.17.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c1).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.17.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c2).as("test data").contains("用于制定技术规范的行业标准？QA/QC?");
		String c26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c26).as("test data").contains("供应商资格？");
		//Click on 2nd collapsible for 3.17.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.17.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c10).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.17.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c3).as("test data").contains("提高风险管理");
		String c35 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		softly.assertThat(c35).as("test data").contains("针对高风险技术规范，利用专家委员会");
		String c37 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[3]"))).getText();
		softly.assertThat(c37).as("test data").contains("对重复技术规范实现标准化");
		//Click on 3rd collapsible for 3.17.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.17.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		softly.assertThat(q342).as("test data").contains("[3.17.2] 来源合规性的审计/检查(QA/QC) 不充分（如适用）");
		//Click on 3.17.2 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']")));
		String s1 = ele.getAttribute("class");
		if(s1.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).getText();
		softly.assertThat(ev2).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Evidence entry place holder
		String ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-1"))).getAttribute("placeholder");
		softly.assertThat(ph2).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//2nd collapsible for 3.17.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c4).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.17.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c5).as("test data").contains("QA/QC 人员的培训和授权？全范围QA审计？");
		String c46 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c46).as("test data").contains("连续审计/检查或抽查审计/检查？");
		//Click on 2nd collapsible for 3.17.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.17.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.17.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c6).as("test data").contains("改善来源QA/QC 项目");
		//Click on 3rd collapsible for 3.17.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.17.3 question
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		softly.assertThat(q343).as("test data").contains("[3.17.3] 设计确认和（或）使用前试验不充分");
		//Click on 3.17.3 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']")));
		String s2 = ele.getAttribute("class");
		if(s2.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).getText();
		softly.assertThat(ev3).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Evidence entry place holder
		String ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-2"))).getAttribute("placeholder");
		softly.assertThat(ph3).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Click on 3.17.3 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//2nd collapsible for 3.17.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c7).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.17.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c8).as("test data").contains("外推过多而没有执行鉴定试验？");
		String c36 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c36).as("test data").contains("复杂分析或计算的独立验证？");
		String c47 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();
		softly.assertThat(c47).as("test data").contains("非编码计算的不确定性分析？");
		//Click on 2nd collapsible for 3.17.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.17.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c12).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.17.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c9).as("test data").contains("改善设计确认和鉴定试验项目");
		//Click on 3rd collapsible for 3.17.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.17.4 question
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		softly.assertThat(q344).as("test data").contains("[3.17.4] 运行不到位: (1) 运行程序不到位; (2) 运行条件不到位; (3) 运行失误");
		//Click on 3.17.4 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']")));
		String s3 = ele.getAttribute("class");
		if(s3.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).getText();
		softly.assertThat(ev4).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Evidence entry place holder
		String ph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-3"))).getAttribute("placeholder");
		softly.assertThat(ph4).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Click on 3.17.4 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		//2nd collapsible for 3.17.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c13).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.17.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c14).as("test data").contains("审查运行程序编写指导文件");
		//Click on 2nd collapsible for 3.17.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.17.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c16).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.17.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c17).as("test data").contains("纠正运行程序中的缺陷");
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		softly.assertThat(c22).as("test data").contains("完善运行程序编写指导文件");
		//Click on 3rd collapsible for 3.17.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.17.5 question
		String q345 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		softly.assertThat(q345).as("test data").contains("[3.17.5] 定期监督试验不到位");
		//Click on 3.17.5 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']")));
		String s5 = ele.getAttribute("class");
		if(s5.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).getText();
		softly.assertThat(ev5).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Evidence entry place holder
		String ph5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-4"))).getAttribute("placeholder");
		softly.assertThat(ph5).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Click on 3.17.5 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		//2nd collapsible for 3.17.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c18).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.17.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c19).as("test data").contains("没有执行监督试验？");
		//Click on 2nd collapsible for 3.17.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.17.5
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c20).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.17.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c21).as("test data").contains("完善监督试验大纲");
		//Click on 3rd collapsible for 3.17.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Scroll to the end
		obj.scrollToAPoint(driver, 1100);
		//3.17.6 question
		String q396 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).getText();
		softly.assertThat(q396).as("test data").contains("[3.17.6] 维修不到位");
		//Click on 3.17.6 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']")));
		String s6 = ele.getAttribute("class");
		if(s6.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).getText();
		softly.assertThat(ev6).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).click();
		//Evidence entry place holder
		String ph6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-5"))).getAttribute("placeholder");
		softly.assertThat(ph6).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).click();
		//Click on 3.17.6 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).click();
		//2nd collapsible for 3.17.6
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c15).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.17.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c28).as("test data").contains("没有执行预防性维修？");
		String c40 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c40).as("test data").contains("纠正性维修没有效果？");
		//Click on 2nd collapsible for 3.17.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.17.6
		String c30 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c30).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.17.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c31 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c31).as("test data").contains("完善预防性维修大纲");
		String c32 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		softly.assertThat(c32).as("test data").contains("完善纠正性维修大纲");
		//Click on 3rd collapsible for 3.17.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.17.7 question
		String q367 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']"))).getText();
		softly.assertThat(q367).as("test data").contains("[3.17.7] 设备的标识和识别不到位");
		//Click on 3.17.7 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']")));
		String s7 = ele.getAttribute("class");
		if(s7.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-6']/h4/a"))).getText();
		softly.assertThat(ev7).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-6']/h4/a"))).click();
		//Evidence entry place holder
		String ph7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-6"))).getAttribute("placeholder");
		softly.assertThat(ph7).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-6']/h4/a"))).click();
		//Click on 3.17.7 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']"))).click();
		//2nd collapsible for 3.17.7
		String c41 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c41).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.17.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c42 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c42).as("test data").contains("检查所有提及的设备不仅有标识，且标识正确");
		//Click on 2nd collapsible for 3.17.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.17.7
		String c44 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c44).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.3.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c45 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c45).as("test data").contains("改进设备标识和识别");
		//Click on 3rd collapsible for 3.17.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Add new contributing factor button
		String c33 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-button"))).getText();
		softly.assertThat(c33).as("test data").contains("新增促成因素");
		//Verify Add Contributing factor
		obj1.chineseAddContributingFactor(driver,softly);
		//Scroll to the top
		Thread.sleep(2000);
		obj.scrollToTop(driver);
		Thread.sleep(2000);
	}

	public void chineseStepOneq120 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.20 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(q11).as("test data").contains("[1.20] 错误是否与工作时发生改变有关？");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		softly.assertThat(desc).as("test data").contains("这一问题探讨了工作过程中的变更是否促成失误发生的原因。工作过程中的变更可能会产生新的、不熟悉的事物，这会造成易出错状态的形成");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		softly.assertThat(ans1).as("test data").contains("是");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		softly.assertThat(ans2).as("test data").contains("是，为无法预测的天灾");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		softly.assertThat(ans3).as("test data").contains("否");
	}	

	public void chineseStepOneL35 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		HiRCAChinese4 obj = new HiRCAChinese4();
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(heading).as("test data").contains("情况警觉不充分");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		softly.assertThat(textD).as("test data").contains("若不适用点选skip略过。使用者可于底部新增促成因素。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		softly.assertThat(desc).as("test data").contains("情况警觉识别和分析影响失误率的内部和外部风险。内部分析涉及易出错的精神状态。外部风险涉及高风险状态。有证据表明缺乏情况警觉会促成这个失误发生吗？");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.5.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		softly.assertThat(q341).as("test data").contains("[3.5.1] 作业前情况警觉（如易出错的精神状态和高风险情况）不充分");
		//Click on 3.5.1 to reveal evidence entry
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']")));
		String s1 = ele.getAttribute("class");
		if(s1.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).getText();
		softly.assertThat(ev1).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Evidence entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-0"))).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Click on 3.5.1 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//2nd collapsible for 3.5.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c1).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.5.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c2).as("test data").contains("情况警觉培训？");
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c22).as("test data").contains("作业前意识体系的改善？");
		//Click on 2nd collapsible for 3.5.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.5.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c10).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.5.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c3).as("test data").contains("情况警觉培训");
		String c23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		softly.assertThat(c23).as("test data").contains("作业前情况警觉（如 TAPE、工前会等）关于何时、何人、何事的要求");
		//Click on 3rd collapsible for 3.5.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.5.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		softly.assertThat(q342).as("test data").contains("[3.5.2] 作业过程中情况警觉（如易出错的精神状态和高风险情况）不充分");
		//Click on 3.5.2 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']")));
		String s2 = ele.getAttribute("class");
		if(s2.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).getText();
		softly.assertThat(ev2).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Evidence entry place holder
		String ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-1"))).getAttribute("placeholder");
		softly.assertThat(ph2).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Click on 3.5.2 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//2nd collapsible for 3.5.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c4).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.5.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c5).as("test data").contains("情况警觉培训？");
		//Click on 2nd collapsible for 3.5.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.5.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.5.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c6).as("test data").contains("情况警觉培训");
		//Click on 3rd collapsible for 3.5.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.5.3 question
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		softly.assertThat(q343).as("test data").contains("[3.5.3] 对人员表现的观察技能不足");
		//Click on 3.5.3 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']")));
		String s3 = ele.getAttribute("class");
		if(s3.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).getText();
		softly.assertThat(ev3).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Evidence entry place holder
		String ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-2"))).getAttribute("placeholder");
		softly.assertThat(ph3).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Click on 3.5.3 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//2nd collapsible for 3.5.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c7).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.5.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c8).as("test data").contains("情况警觉培训？");
		//Click on 2nd collapsible for 3.5.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.5.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c12).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.5.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		softly.assertThat(c9).as("test data").contains("开展人员表现观察技能方面的培训");
		//Click on 3rd collapsible for 3.5.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.5.4 question
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		softly.assertThat(q344).as("test data").contains("[3.5.4] 对设备性能的观察技能不足");
		//Click on 3.5.4 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']")));
		String s4 = ele.getAttribute("class");
		if(s4.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).getText();
		softly.assertThat(ev4).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Evidence entry place holder
		String ph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-3"))).getAttribute("placeholder");
		softly.assertThat(ph4).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Click on 3.5.4 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		//2nd collapsible for 3.5.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c13).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.5.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c14).as("test data").contains("情况警觉培训？");
		//Click on 2nd collapsible for 3.5.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.5.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c16).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.5.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c17).as("test data").contains("开展退化、异常和变化等设备性能观察技能方面的培训");
		//Click on 3rd collapsible for 3.5.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Add new contributing factor button
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-button"))).getText();
		softly.assertThat(c15).as("test data").contains("新增促成因素");
		//Verify Add Contributing factor
		obj.chineseAddContributingFactor(driver, softly);
	}

	public void chineseStepOneq119 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.19 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(q11).as("test data").contains("[1.19] 是否有类似事件重发的趋势？");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		softly.assertThat(desc).as("test data").contains("这个问题探讨了此事件是否与组织的绩效控制管理有关。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		softly.assertThat(ans1).as("test data").contains("是");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		softly.assertThat(ans2).as("test data").contains("没有，趋势下降");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		softly.assertThat(ans3).as("test data").contains("没有");
	}

	public void chineseStepOneL322 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		HiRCAChinese4 obj = new HiRCAChinese4();
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(heading).as("test data").contains("规则不正确");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		softly.assertThat(textD).as("test data").contains("若不适用点选skip略过。使用者可于底部新增促成因素。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		softly.assertThat(desc).as("test data").contains("若规则不正确，是什么原因导致的？");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.22.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		softly.assertThat(q341).as("test data").contains("[3.22.1] 对规则的现场试验不充分");
		//Click on 3.22.1 to reveal evidence entry
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']")));
		String s1 = ele.getAttribute("class");
		if(s1.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).getText();
		softly.assertThat(ev1).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Evidence entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-0"))).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Click on 3.22.1 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//2nd collapsible for 3.22.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c1).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.22.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c2).as("test data").contains("有无现场试验？");
		//Click on 2nd collapsible for 3.22.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.22.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c10).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.22.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c3).as("test data").contains("发布规则/程序前，执行现场试验");
		//Click on 3rd collapsible for 3.22.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.22.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		softly.assertThat(q342).as("test data").contains("[3.22.2] 给规则编写人的反馈不充分，从而使其纠正错误规则");
		//Click on 3.22.2 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']")));
		String s2 = ele.getAttribute("class");
		if(s2.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).getText();
		softly.assertThat(ev2).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Evidence entry place holder
		String ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-1"))).getAttribute("placeholder");
		softly.assertThat(ph2).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Click on 3.22.2 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//2nd collapsible for 3.22.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c4).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.22.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c5).as("test data").contains("有无反馈？");
		//Click on 2nd collapsible for 3.22.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.22.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.22.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c6).as("test data").contains("设计出允许执行人员记录失误方便编写人改正的程序");
		String c28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		softly.assertThat(c28).as("test data").contains("制定遇到程序关键错误后要求停止操作的政策");
		//Click on 3rd collapsible for 3.22.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.22.3 question
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		softly.assertThat(q343).as("test data").contains("[3.22.3] 盲目信任错误规则");
		//Click on 3.22.3 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']")));
		String s3 = ele.getAttribute("class");
		if(s3.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).getText();
		softly.assertThat(ev3).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Evidence entry place holder
		String ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-2"))).getAttribute("placeholder");
		softly.assertThat(ph3).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Click on 3.22.3 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//2nd collapsible for 3.22.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c7).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.22.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c8).as("test data").contains("是否要求澄清？");
		//Click on 2nd collapsible for 3.22.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.22.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c12).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.22.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		softly.assertThat(c9).as("test data").contains("培训");
		//Click on 3rd collapsible for 3.22.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.22.4 question
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		softly.assertThat(q344).as("test data").contains("[3.22.4] 规则审核不到位");
		//Click on 3.22.4 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']")));
		String s4 = ele.getAttribute("class");
		if(s4.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).getText();
		softly.assertThat(ev4).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Evidence entry place holder
		String ph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-3"))).getAttribute("placeholder");
		softly.assertThat(ph4).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Click on 3.22.4 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		//2nd collapsible for 3.22.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c13).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.22.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c14).as("test data").contains("程序/规则当时是如何审核的？");
		//Click on 2nd collapsible for 3.22.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.22.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c16).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.22.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c17).as("test data").contains("提供有效审核的相关培训");
		//Click on 3rd collapsible for 3.22.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.22.5 question
		String q345 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		softly.assertThat(q345).as("test data").contains("[3.22.5] 工前会、班前会、交底会的规则不充分");
		//Click on 3.22.5 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']")));
		String s5 = ele.getAttribute("class");
		if(s5.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).getText();
		softly.assertThat(ev5).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Evidence entry place holder
		String ph5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-4"))).getAttribute("placeholder");
		softly.assertThat(ph5).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Click on 3.22.5 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		//2nd collapsible for 3.22.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c18).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.22.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c19).as("test data").contains("工前会、班前会、交底会上是否识别出错误的规则/程序？");
		//Click on 2nd collapsible for 3.22.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.22.5
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c20).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.22.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c21).as("test data").contains("完善关于工前会、班前会、交底会的规则");
		//Click on 3rd collapsible for 3.22.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Add new contributing factor button
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-button"))).getText();
		softly.assertThat(c15).as("test data").contains("新增促成因素");
		//Verify Add Contributing factor
		obj.chineseAddContributingFactor(driver, softly);
	}

	public void chineseStepOneL316 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		ShareCheck obj = new ShareCheck();
		HiRCAChinese4 obj1 = new HiRCAChinese4();
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(heading).as("test data").contains("粗心犯错的促成因素");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		softly.assertThat(textD).as("test data").contains("若不适用点选skip略过。使用者可于底部新增促成因素。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		softly.assertThat(desc).as("test data").contains("粗心犯错是容易发生失误的行为。它的特点是由于没有完全注意手头工作任务而导致的失误。存在一个或以上的易错精神状态可能会导致");
		softly.assertThat(desc).as("test data").contains("不注意细节");
		softly.assertThat(desc).as("test data").contains("的失误。这五个易错精神状态为（1）困倦（2）分心（3）过度自信（4）时间压力和（5）注意力不足");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.16.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		softly.assertThat(q341).as("test data").contains("[3.16.1] 疲倦: (1) 大约上午3-4点; (2) 大约下午2-3点; (3) 长时间工作后");
		//Click on 3.16.1 to reveal evidence entry
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']")));
		String s1 = ele.getAttribute("class");
		if(s1.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).getText();
		softly.assertThat(ev1).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Evidence entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-0"))).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Click on 3.16.1 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//2nd collapsible for 3.16.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c1).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.16.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c2).as("test data").contains("查阅以往事件？");
		//Click on 2nd collapsible for 3.16.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.16.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c10).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.16.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c3).as("test data").contains("休息时间管理");
		String c26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		softly.assertThat(c26).as("test data").contains("行为培训");
		//Click on 3rd collapsible for 3.16.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.16.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		softly.assertThat(q342).as("test data").contains("[3.16.2] 注意力不集中（分心）: (1) 同时执行多个任务; (2) 被打断; (3) 有心事");
		//Click on 3.16.2 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']")));
		String s2 = ele.getAttribute("class");
		if(s2.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).getText();
		softly.assertThat(ev2).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Evidence entry place holder
		String ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-1"))).getAttribute("placeholder");
		softly.assertThat(ph2).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Click on 3.16.2 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//2nd collapsible for 3.16.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c4).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.16.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c5).as("test data").contains("访谈犯错者？");
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c22).as("test data").contains("访谈同事？");
		//Click on 2nd collapsible for 3.16.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.16.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.16.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c6).as("test data").contains("行为培训");
		//Click on 3rd collapsible for 3.16.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.16.3 question
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		softly.assertThat(q343).as("test data").contains("[3.16.3] 过度自信: (1) 首次执行的操作(FTE)，而没有寻求充分帮助；(2) 日常工作，而没有注意到微小变化和新情况；(3) 繁琐任务未定期自检 (如数据输入)；(4) 使用信息数据未审核且核实 (5) 不识别单项弱点也不自检单项弱点；(6) 按记忆中（印象中）的程序作业（未持程序作业）");
		//Click on 3.16.3 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']")));
		String s3 = ele.getAttribute("class");
		if(s3.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).getText();
		softly.assertThat(ev3).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Evidence entry place holder
		String ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-2"))).getAttribute("placeholder");
		softly.assertThat(ph3).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Click on 3.16.3 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//2nd collapsible for 3.16.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c7).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.16.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c8).as("test data").contains("访谈犯错者？");
		//Click on 2nd collapsible for 3.16.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.16.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c12).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.16.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c9).as("test data").contains("在工前会、班前会和交底会讨论单项弱点和首次作业");
		String c36 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		softly.assertThat(c36).as("test data").contains("行为培训");
		//Click on 3rd collapsible for 3.16.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.16.4 question
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		softly.assertThat(q344).as("test data").contains("[3.16.4] 时间压力: 急着完工");
		//Click on 3.16.4 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']")));
		String s4 = ele.getAttribute("class");
		if(s4.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).getText();
		softly.assertThat(ev4).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Evidence entry place holder
		String ph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-3"))).getAttribute("placeholder");
		softly.assertThat(ph4).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Click on 3.16.4 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		//2nd collapsible for 3.16.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c13).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.16.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c14).as("test data").contains("现场观察？");
		String c38 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c38).as("test data").contains("访谈同事？");
		//Click on 2nd collapsible for 3.16.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.16.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c16).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.16.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c17).as("test data").contains("行为培训");
		String c37 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		softly.assertThat(c37).as("test data").contains("改善排程和计划系统");
		//Click on 3rd collapsible for 3.16.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Scroll to the end
		obj.scrollToAPoint(driver, 1500);
		//3.16.5 question
		String q345 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		softly.assertThat(q345).as("test data").contains("[3.16.5] 注意不足: 1.长时间工作而没有休息(> 140分钟); 2. 早上10点时做事; 3. 工作超过10小时");
		//Click on 3.16.5 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']")));
		String s5 = ele.getAttribute("class");
		if(s5.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).getText();
		softly.assertThat(ev5).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Evidence entry place holder
		String ph5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-4"))).getAttribute("placeholder");
		softly.assertThat(ph5).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Click on 3.16.5 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		//2nd collapsible for 3.16.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c18).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.16.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c19).as("test data").contains("现场观察？");
		String c23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c23).as("test data").contains("访谈同事？");
		//Click on 2nd collapsible for 3.16.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.16.5
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c20).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.16.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c21).as("test data").contains("中间适当休息");
		String c24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		softly.assertThat(c24).as("test data").contains("最大程度减少干扰");
		//Click on 3rd collapsible for 3.16.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.16.6 question
		String q396 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).getText();
		softly.assertThat(q396).as("test data").contains("[3.16.6] 学习技能时相关规定有误");
		//Click on 3.16.6 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']")));
		String s6 = ele.getAttribute("class");
		if(s6.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).getText();
		softly.assertThat(ev6).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).click();
		//Evidence entry place holder
		String ph6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-5"))).getAttribute("placeholder");
		softly.assertThat(ph6).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).click();
		//Click on 3.16.6 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).click();
		//2nd collapsible for 3.16.6
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c15).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.16.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c28).as("test data").contains("审查技能相关规定");
		//Click on 2nd collapsible for 3.16.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.16.6
		String c30 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c30).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.16.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c31 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c31).as("test data").contains("学习正确所需技能");
		//Click on 3rd collapsible for 3.16.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.16.7 question
		String q367 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']"))).getText();
		softly.assertThat(q367).as("test data").contains("[3.16.7] 判断出错未能选择正确技能使用");
		//Click on 3.16.7 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']")));
		String s7 = ele.getAttribute("class");
		if(s7.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-6']/h4/a"))).getText();
		softly.assertThat(ev7).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-6']/h4/a"))).click();
		//Evidence entry place holder
		String ph7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-6"))).getAttribute("placeholder");
		softly.assertThat(ph7).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-6']/h4/a"))).click();
		//Click on 3.16.7 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']"))).click();
		//2nd collapsible for 3.16.7
		String c41 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c41).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.16.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c42 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c42).as("test data").contains("访谈犯错人");
		//Click on 2nd collapsible for 3.16.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.16.7
		String c44 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c44).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.16.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c45 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c45).as("test data").contains("培训技能的选择");
		String c34 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		softly.assertThat(c34).as("test data").contains("透过强化规定减少选择错误的机会");
		//Click on 3rd collapsible for 3.16.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Add new contributing factor button
		String c33 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-button"))).getText();
		softly.assertThat(c33).as("test data").contains("新增促成因素");
		//Verify Add Contributing factor
		obj1.chineseAddContributingFactor(driver, softly);
		//Scroll to the top
		Thread.sleep(2000);
		obj.scrollToTop(driver);
		Thread.sleep(2000);
	}

	public void chineseStepOneq118 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.18 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(q11).as("test data").contains("[1.18] 事件是因程序规则有误导致？");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		softly.assertThat(desc).as("test data").contains("这个问题探讨了现有规制是否不仅促成这一实例的发生，还促成了这一失误的多次发生");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		softly.assertThat(ans1).as("test data").contains("是");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		softly.assertThat(ans2).as("test data").contains("不是");
	}

	public void chineseStepOneL33 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		ShareCheck obj = new ShareCheck();
		HiRCAChinese4 obj1 = new HiRCAChinese4();
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(heading).as("test data").contains("经理层面");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		softly.assertThat(textD).as("test data").contains("若不适用点选skip略过。使用者可于底部新增促成因素。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		softly.assertThat(desc).as("test data").contains("这些促成因素归因于经理层，因为这关系到影响组织绩效的失误。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.3.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		softly.assertThat(q341).as("test data").contains("[3.3.1] 经理团队资源分配不到位");
		//Click on 3.3.1 to reveal evidence entry
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']")));
		String s1 = ele.getAttribute("class");
		if(s1.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).getText();
		softly.assertThat(ev1).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Evidence entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-0"))).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Click on 3.3.1 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//2nd collapsible for 3.3.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c1).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.3.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c2).as("test data").contains("是否一些工作组工作量过多，而另一些工作组工作量过少？");
		String c26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c26).as("test data").contains("分配工作更多的是为了纠正问题，而不是防治问题？");
		//Click on 2nd collapsible for 3.3.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.3.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c10).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.3.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c3).as("test data").contains("提升管理技能，完善资源分配体系");
		//Click on 3rd collapsible for 3.3.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.3.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		softly.assertThat(q342).as("test data").contains("[3.3.2] 经理团队所需培训开展不充分");
		//Click on 3.3.2 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']")));
		String s2 = ele.getAttribute("class");
		if(s2.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).getText();
		softly.assertThat(ev2).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Evidence entry place holder
		String ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-1"))).getAttribute("placeholder");
		softly.assertThat(ph2).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Click on 3.3.2 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//2nd collapsible for 3.3.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c4).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.3.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c5).as("test data").contains("培训计划是否从提高效率和提高质量两个方面考虑？");
		//Click on 2nd collapsible for 3.3.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.3.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.3.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c6).as("test data").contains("成立培训计划委员会");
		//Click on 3rd collapsible for 3.3.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.3.3 question
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		softly.assertThat(q343).as("test data").contains("[3.3.3] 经理团队问责制不到位");
		//Click on 3.3.3 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']")));
		String s3 = ele.getAttribute("class");
		if(s3.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).getText();

		softly.assertThat(ev3).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Evidence entry place holder
		String ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-2"))).getAttribute("placeholder");
		softly.assertThat(ph3).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Click on 3.3.3 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//2nd collapsible for 3.3.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c7).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.3.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();

		softly.assertThat(c8).as("test data").contains("PM&T是否充分？");
		String c36 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();

		softly.assertThat(c36).as("test data").contains("JO是否充分？");
		String c37 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();

		softly.assertThat(c37).as("test data").contains("RCA是否充分？");
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[4]"))).getText();

		softly.assertThat(c22).as("test data").contains("ORRA是否充分？");
		//Click on 2nd collapsible for 3.3.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.3.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c12).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.3.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c9).as("test data").contains("完善问责制");
		//Click on 3rd collapsible for 3.3.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.3.4 question
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();

		softly.assertThat(q344).as("test data").contains("[3.3.4] 经理团队对确定工作优先级和计划方面不到位");
		//Click on 3.3.4 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']")));
		String s4 = ele.getAttribute("class");
		if(s4.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).getText();

		softly.assertThat(ev4).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Evidence entry place holder
		String ph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-3"))).getAttribute("placeholder");

		softly.assertThat(ph4).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Click on 3.3.4 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		//2nd collapsible for 3.3.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c13).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.3.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();

		softly.assertThat(c14).as("test data").contains("工作流程中没有包括工作优先级的确定？");
		String c38 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();

		softly.assertThat(c38).as("test data").contains("优先级确定标准在时间、范围（质量）和成本三个方面没有平衡好？");
		//Click on 2nd collapsible for 3.3.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.3.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c16).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.3.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c17).as("test data").contains("完善管理优先级确定和计划体系？");
		//Click on 3rd collapsible for 3.3.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.3.5 question
		String q345 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		System.out.println(q345);
		softly.assertThat(q345).as("test data").contains("[3.3.5] 经理管理人员对以下标准制定不充分：(1) 行为规范 (2) 程序和屏障");
		//Click on 3.3.5 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']")));
		String s5 = ele.getAttribute("class");
		if(s5.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).getText();

		softly.assertThat(ev5).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Evidence entry place holder
		String ph5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-4"))).getAttribute("placeholder");

		softly.assertThat(ph5).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Click on 3.3.5 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		//2nd collapsible for 3.3.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c18).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.3.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();

		softly.assertThat(c19).as("test data").contains("自我分析（自评）？");
		String c23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();

		softly.assertThat(c23).as("test data").contains("与表现优秀者对标？");
		//Click on 2nd collapsible for 3.3.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.3.5
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c20).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.3.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c21).as("test data").contains("开展关于标准设定的管理培训");
		String c24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();

		softly.assertThat(c24).as("test data").contains("开展关于程序和保护屏障设计的培训");
		//Click on 3rd collapsible for 3.3.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Scroll to the end
		obj.scrollToAPoint(driver, 1300);
		//3.3.6 question
		String q396 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).getText();

		softly.assertThat(q396).as("test data").contains("[3.3.6] 经理团队绩效跟踪与趋势分析不到位");
		//Click on 3.3.6 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']")));
		String s6 = ele.getAttribute("class");
		if(s6.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).getText();

		softly.assertThat(ev6).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).click();
		//Evidence entry place holder
		String ph6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-5"))).getAttribute("placeholder");

		softly.assertThat(ph6).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).click();
		//Click on 3.3.6 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).click();
		//2nd collapsible for 3.3.6
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c15).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.3.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();

		softly.assertThat(c28).as("test data").contains("KPI不充分？");
		String c40 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();

		softly.assertThat(c40).as("test data").contains("没有定期开展共因分析？");
		String c25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();

		softly.assertThat(c25).as("test data").contains("未对类似事件或失误进行趋势分析？");
		//Click on 2nd collapsible for 3.3.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.3.6
		String c30 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c30).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.3.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c31 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c31).as("test data").contains("定期开展共因分析");
		String c32 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();

		softly.assertThat(c32).as("test data").contains("改善绩效跟踪与趋势分析项目");
		String c27 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[3]"))).getText();

		softly.assertThat(c27).as("test data").contains("完善KPI");
		//Click on 3rd collapsible for 3.3.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.3.7 question
		String q367 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']"))).getText();

		softly.assertThat(q367).as("test data").contains("[3.3.7] 经理团队内未充分建立关于团队合作的共同目标、共同利益和共同责任");
		//Click on 3.3.7 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']")));
		String s7 = ele.getAttribute("class");
		if(s7.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-6']/h4/a"))).getText();

		softly.assertThat(ev7).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-6']/h4/a"))).click();
		//Evidence entry place holder
		String ph7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-6"))).getAttribute("placeholder");

		softly.assertThat(ph7).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-6']/h4/a"))).click();
		//Click on 3.3.7 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']"))).click();
		//2nd collapsible for 3.3.7
		String c41 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c41).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.3.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c42 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();

		softly.assertThat(c42).as("test data").contains("经理之间的接口问题？");
		String c43 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();

		softly.assertThat(c43).as("test data").contains("主管或经理之间存在不和？");
		String c29 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();

		softly.assertThat(c29).as("test data").contains("因两个管理团队之间接口问题，导致工作没有做？");
		//Click on 2nd collapsible for 3.3.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.3.7
		String c44 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c44).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.3.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c45 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c45).as("test data").contains("开展组织设计方面的管理培训");
		String c34 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();

		softly.assertThat(c34).as("test data").contains("在经理人员之间建立共同目标、共同利益和共同责任");
		//Click on 3rd collapsible for 3.3.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.3.8 question
		String q368 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-7']"))).getText();

		softly.assertThat(q368).as("test data").contains("[3.3.8] 经理团队纠正行动不足");
		//Click on 3.3.8 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-7']")));
		String s8 = ele.getAttribute("class");
		if(s8.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-7']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-7']/h4/a"))).getText();

		softly.assertThat(ev8).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-7']/h4/a"))).click();
		//Evidence entry place holder
		String ph8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-7"))).getAttribute("placeholder");

		softly.assertThat(ph8).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-7']/h4/a"))).click();
		//Click on 3.3.8 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-7']"))).click();
		//2nd collapsible for 3.3.8
		String c46 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c46).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.3.8
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c47 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();

		softly.assertThat(c47).as("test data").contains("根本原因分析不足导致事件重发？");
		String c48 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();

		softly.assertThat(c48).as("test data").contains("没有注意到关键的在变化的问题导致未能解决紧急问题？");
		String c35 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();

		softly.assertThat(c35).as("test data").contains("纠正行动制定过多导致大量纠正行动仍然积压？");
		//Click on 2nd collapsible for 3.3.8
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.3.8
		String c49 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c49).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.3.8
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c50 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c50).as("test data").contains("提高纠正行动计划的落实");
		String c39 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();

		softly.assertThat(c39).as("test data").contains("改善根本原因分析方法");
		String c56 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/div/ul/li[3]"))).getText();

		softly.assertThat(c56).as("test data").contains("完善突发紧急问题（危机）管理机制");
		//Click on 3rd collapsible for 3.3.8
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.3.9 question
		String q369 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-8']"))).getText();

		softly.assertThat(q369).as("test data").contains("[3.3.9] 经理团队垂直沟通体系不完善");
		//Click on 3.3.9 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-8']")));
		String s9 = ele.getAttribute("class");
		if(s9.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-8']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-8']/h4/a"))).getText();

		softly.assertThat(ev9).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-8']/h4/a"))).click();
		//Evidence entry place holder
		String ph9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-8"))).getAttribute("placeholder");

		softly.assertThat(ph9).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-8']/h4/a"))).click();
		//Click on 3.3.9 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-8']"))).click();
		//2nd collapsible for 3.3.9
		String c51 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c51).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.3.9
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c52 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();

		softly.assertThat(c52).as("test data").contains("方针培训？");
		String c53 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();

		softly.assertThat(c53).as("test data").contains("对员工的管理指导？");
		String c57 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();

		softly.assertThat(c57).as("test data").contains("传达给员工的工作指令不充分？");
		String c58 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/div/ul/li[4]"))).getText();

		softly.assertThat(c58).as("test data").contains("是否定期召开员工会议？");
		//Click on 2nd collapsible for 3.3.9
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.3.9
		String c54 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c54).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.3.9
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c55 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c55).as("test data").contains("完善垂直沟通体系");
		//Click on 3rd collapsible for 3.6.9
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.3.10 question
		String q3310 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-9']"))).getText();
		System.out.println(q3310);
		softly.assertThat(q3310).as("test data").contains("[3.3.10] 经理团队横向沟通体系不完善");
		//Click on 3.3.10 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-9']")));
		String s10 = ele.getAttribute("class");
		if(s10.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-9']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-9']/h4/a"))).getText();
		softly.assertThat(ev10).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-9']/h4/a"))).click();
		//Evidence entry place holder
		String ph10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-9"))).getAttribute("placeholder");

		softly.assertThat(ph10).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-9']/h4/a"))).click();
		//Click on 3.3.10 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-9']"))).click();
		Thread.sleep(1000);
		//2nd collapsible for 3.3.10
		String c59 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c59).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.3.10
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c60 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c60).as("test data").contains("共同目标和共同利益不充分？");
		String c61 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c61).as("test data").contains("程序设计不当？");
		//Click on 2nd collapsible for 3.3.10
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.3.10
		String c62 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c62).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.3.10
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c63 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c63).as("test data").contains("完善程序设计");
		String c64 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		softly.assertThat(c64).as("test data").contains("制定共同目标和共同利益");
		//Click on 3rd collapsible for 3.3.10
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Add new contributing factor button
		String c33 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-button"))).getText();
		softly.assertThat(c33).as("test data").contains("新增促成因素");
		//Verify Add Contributing factor
		obj1.chineseAddContributingFactor(driver, softly);
		//Scroll to the top
		Thread.sleep(2000);
		obj.scrollToTop(driver);
		Thread.sleep(2000);
	}

	public void chineseStepOneq117 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();		
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.17 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();		
		softly.assertThat(q11).as("test data").contains("[1.17] 事件是与经理管理不当有关？");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();		
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");		
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();		
		softly.assertThat(desc).as("test data").contains("这个问题探讨了失误受管理效力影响的可能性；相关影响要素包括设定组织标准、绩效问责机制等。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();		
		softly.assertThat(ans1).as("test data").contains("有");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();		
		softly.assertThat(ans2).as("test data").contains("没有");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();		
		softly.assertThat(ans3).as("test data").contains("未知");
	}

	public void chineseStepOneq116 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();		
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.16 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();		
		softly.assertThat(q11).as("test data").contains("[1.16] 事件是与组长监督管理不当有关？");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();		
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");		
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();		
		softly.assertThat(desc).as("test data").contains("这个问题探讨了失误受监管效力影响的可能性；相关影响要素包括行为标准的强化、绩效反馈、与现场员工交流、指导计划等。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();		
		softly.assertThat(ans1).as("test data").contains("是，跟其他组长相比下有缺失");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();		
		softly.assertThat(ans2).as("test data").contains("没有");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();		
		softly.assertThat(ans3).as("test data").contains("未知");
	}

	public void chineseStepOneL36 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		ShareCheck obj = new ShareCheck();
		HiRCAChinese4 obj1 = new HiRCAChinese4();
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();		
		softly.assertThat(heading).as("test data").contains("全面性不足");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		softly.assertThat(textD).as("test data").contains("若不适用点选skip略过。使用者可于底部新增促成因素。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();

		softly.assertThat(desc).as("test data").contains("该失误的促成原因是否为制度、程序、等规范缺少要求、运行工况、假设、范围、试验/测量和缺少章节或部分。全面性不足查看程序设计是否涵盖所有要求、工况、假设和工作范围。如果是由于程序中缺少既定指导或者遗漏必要功能/步骤而造成困惑，从而导致发生失误，那么全面性方面非常可能存在不足。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.6.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(q341);
		softly.assertThat(q341).as("test data").contains("[3.6.1] 要求有遗漏");
		//Click on 3.6.1 to reveal evidence entry
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']")));
		String s1 = ele.getAttribute("class");
		if(s1.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).getText();

		softly.assertThat(ev1).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Evidence entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-0"))).getAttribute("placeholder");

		softly.assertThat(ph1).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Click on 3.6.1 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//2nd collapsible for 3.6.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c1).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.6.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();

		softly.assertThat(c2).as("test data").contains("规范和标准？");
		String c26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();

		softly.assertThat(c26).as("test data").contains("规范和标准？");
		String c29 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();

		softly.assertThat(c29).as("test data").contains("与其他项目之间的接口要求？");
		//Click on 2nd collapsible for 3.6.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.6.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c10).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.6.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c3).as("test data").contains("完善规则");
		String c27 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();

		softly.assertThat(c27).as("test data").contains("开展程序设计方面的培训");
		//Click on 3rd collapsible for 3.6.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.6.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(q342);
		softly.assertThat(q342).as("test data").contains("[3.6.2] 运行条件有遗漏");
		//Click on 3.6.2 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']")));
		String s2 = ele.getAttribute("class");
		if(s2.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).getText();

		softly.assertThat(ev2).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Evidence entry place holder
		String ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-1"))).getAttribute("placeholder");

		softly.assertThat(ph2).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Click on 3.6.2 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//2nd collapsible for 3.6.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c4).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.6.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();

		softly.assertThat(c5).as("test data").contains("规则适用的运行条件范围？");
		String c34 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();

		softly.assertThat(c34).as("test data").contains("进入规则的前提条件？");
		String c35 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();

		softly.assertThat(c35).as("test data").contains("退出规则的条件？");
		//Click on 2nd collapsible for 3.6.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.6.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.6.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c6).as("test data").contains("完善规则");
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();

		softly.assertThat(c22).as("test data").contains("开展程序设计方面的培训");
		//Click on 3rd collapsible for 3.6.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.6.3 question
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(q343);
		softly.assertThat(q343).as("test data").contains("[3.6.3] 假设有遗漏");
		//Click on 3.6.3 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']")));
		String s3 = ele.getAttribute("class");
		if(s3.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).getText();

		softly.assertThat(ev3).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Evidence entry place holder
		String ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-2"))).getAttribute("placeholder");

		softly.assertThat(ph3).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Click on 3.6.3 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//2nd collapsible for 3.6.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c7).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.6.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();

		softly.assertThat(c8).as("test data").contains("假设未予以说明？");
		String c36 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();

		softly.assertThat(c36).as("test data").contains("未要求在任务完成前对假设进行验证？");
		String c37 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();

		softly.assertThat(c37).as("test data").contains("对未经验证的假设没有制定缓解措施？");
		//Click on 2nd collapsible for 3.6.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.6.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c12).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.6.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c9).as("test data").contains("完善规则");
		String c23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();

		softly.assertThat(c23).as("test data").contains("开展程序设计方面的培训");
		//Click on 3rd collapsible for 3.6.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.6.4 question
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();

		softly.assertThat(q344).as("test data").contains("[3.6.4] 范围有遗漏");
		//Click on 3.6.4 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']")));
		String s4 = ele.getAttribute("class");
		if(s4.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).getText();

		softly.assertThat(ev4).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Evidence entry place holder
		String ph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-3"))).getAttribute("placeholder");

		softly.assertThat(ph4).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Click on 3.6.4 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		//2nd collapsible for 3.6.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c13).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.6.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();

		softly.assertThat(c14).as("test data").contains("使用通用规则，缺少针对各种特殊情况的具体描述？");
		String c38 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();

		softly.assertThat(c38).as("test data").contains("步骤遗漏？");
		String c39 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();

		softly.assertThat(c39).as("test data").contains("遗漏了碰到异常情况时需采取的行动？");
		//Click on 2nd collapsible for 3.6.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.6.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c16).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.6.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c17).as("test data").contains("完善规则");
		String c25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();

		softly.assertThat(c25).as("test data").contains("开展程序设计方面的培训");
		//Click on 3rd collapsible for 3.6.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.6.5 question
		String q345 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		System.out.println(q345);
		softly.assertThat(q345).as("test data").contains("[3.6.5] 试验或测量有遗漏");
		//Click on 3.6.5 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']")));
		String s5 = ele.getAttribute("class");
		if(s5.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).getText();

		softly.assertThat(ev5).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Evidence entry place holder
		String ph5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-4"))).getAttribute("placeholder");

		softly.assertThat(ph5).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Click on 3.6.5 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		//2nd collapsible for 3.6.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c18).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.6.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();

		softly.assertThat(c19).as("test data").contains("遗漏了用于验收是否正确执行的相关试验或测量？");
		//Click on 2nd collapsible for 3.6.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.6.5
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c20).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.6.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c21).as("test data").contains("完善规则");
		String c24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();

		softly.assertThat(c24).as("test data").contains("开展程序设计方面的培训");
		//Click on 3rd collapsible for 3.6.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Scroll to the end
		obj.scrollToAPoint(driver, 1200);
		//3.6.6 question
		String q396 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).getText();

		softly.assertThat(q396).as("test data").contains("[3.6.6] 遗漏以下信息: (1) 目的; (2) 先决条件; (3) 定义; (4) 经验反馈用");
		softly.assertThat(q396).as("test data").contains("不准做清单");
		softly.assertThat(q396).as("test data").contains("体现; (5) 参考资料; (6) 要求使用者反馈");
		//Click on 3.6.6 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']")));
		String s6 = ele.getAttribute("class");
		if(s6.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).getText();

		softly.assertThat(ev6).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).click();
		//Evidence entry place holder
		String ph6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-5"))).getAttribute("placeholder");

		softly.assertThat(ph6).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).click();
		//Click on 3.6.6 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).click();
		//2nd collapsible for 3.6.6
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c15).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.6.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();

		softly.assertThat(c28).as("test data").contains("调查程序编写者");
		String c40 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();

		softly.assertThat(c40).as("test data").contains("调查程序设计编写培训");
		//Click on 2nd collapsible for 3.6.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.6.6
		String c30 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c30).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.6.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c31 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c31).as("test data").contains("开展程序设计编写培训");
		String c32 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();

		softly.assertThat(c32).as("test data").contains("改善程序编写导则");
		//Click on 3rd collapsible for 3.6.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.6.7 question
		String q367 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']"))).getText();

		softly.assertThat(q367).as("test data").contains("[3.6.7] 审查不到位导致制度有遗漏项");
		//Click on 3.6.7 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']")));
		String s7 = ele.getAttribute("class");
		if(s7.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-6']/h4/a"))).getText();

		softly.assertThat(ev7).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-6']/h4/a"))).click();
		//Evidence entry place holder
		String ph7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-6"))).getAttribute("placeholder");

		softly.assertThat(ph7).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-6']/h4/a"))).click();
		//Click on 3.6.7 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']"))).click();
		//2nd collapsible for 3.6.7
		String c41 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).getText();		
		softly.assertThat(c41).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.6.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c42 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();		
		softly.assertThat(c42).as("test data").contains("调查程序审查者");
		String c43 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();		
		softly.assertThat(c43).as("test data").contains("调查程序审查培训");
		//Click on 2nd collapsible for 3.6.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.6.7
		String c44 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c44).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.6.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c45 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c45).as("test data").contains("开展程序审查培训");
		//Click on 3rd collapsible for 3.6.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.6.8 question
		String q368 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-7']"))).getText();		
		softly.assertThat(q368).as("test data").contains("[3.6.8] 根本原因分析不到位导致制度有遗漏项");
		//Click on 3.6.8 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-7']")));
		String s8 = ele.getAttribute("class");
		if(s8.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-7']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-7']/h4/a"))).getText();		
		softly.assertThat(ev8).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-7']/h4/a"))).click();
		//Evidence entry place holder
		String ph8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-7"))).getAttribute("placeholder");

		softly.assertThat(ph8).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-7']/h4/a"))).click();
		//Click on 3.6.8 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-7']"))).click();
		//2nd collapsible for 3.6.8
		String c46 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c46).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.6.8
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c47 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();

		softly.assertThat(c47).as("test data").contains("调查事件调查者");
		String c48 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();

		softly.assertThat(c48).as("test data").contains("调查事件根本原因培训");
		//Click on 2nd collapsible for 3.6.8
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.6.8
		String c49 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c49).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.6.8
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c50 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c50).as("test data").contains("开展根本原因培训");
		//Click on 3rd collapsible for 3.6.8
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.6.9 question
		String q369 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-8']"))).getText();
		softly.assertThat(q369).as("test data").contains("[3.6.9] 纠正措施执行不到位导致制度有遗漏项");
		//Click on 3.6.9 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-8']")));
		String s9 = ele.getAttribute("class");
		if(s9.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-8']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-8']/h4/a"))).getText();

		softly.assertThat(ev9).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-8']/h4/a"))).click();
		//Evidence entry place holder
		String ph9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-8"))).getAttribute("placeholder");

		softly.assertThat(ph9).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-8']/h4/a"))).click();
		//Click on 3.6.9 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-8']"))).click();
		//2nd collapsible for 3.6.9
		String c51 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c51).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.6.9
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c52 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();

		softly.assertThat(c52).as("test data").contains("调查纠正措施主管");
		String c53 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();

		softly.assertThat(c53).as("test data").contains("调查纠正措施制度缺陷");
		//Click on 2nd collapsible for 3.6.9
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.6.9
		String c54 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c54).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.6.9
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c55 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c55).as("test data").contains("改善纠正措施制度的监督与执行");
		//Click on 3rd collapsible for 3.6.9
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Add new contributing factor button
		String c33 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-button"))).getText();

		softly.assertThat(c33).as("test data").contains("新增促成因素");
		//Verify Add Contributing factor
		obj1.chineseAddContributingFactor(driver, softly);
		//Scroll to the top
		Thread.sleep(2000);
		obj.scrollToTop(driver);
		Thread.sleep(2000);
	}

	public void chineseStepOneL38 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		ShareCheck obj = new ShareCheck();
		HiRCAChinese4 obj1 = new HiRCAChinese4();
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(heading).as("test data").contains("\"明确性\"欠缺");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		softly.assertThat(textD).as("test data").contains("若不适用点选skip略过。使用者可于底部新增促成因素。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		softly.assertThat(desc).as("test data").contains("缺乏明确性是否是这种失误发生的促成因素？缺乏明确性为词语模糊，需要判断，技术词语缺少定义，配置说明缺少直观工具或者说明有明显错误。相关示例包括：在规则或程序中经常使用主观性词语、组织制定模糊的要求已避免QA方面的发现、错误的步骤。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.8.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		softly.assertThat(q341).as("test data").contains("[3.8.1] 规则编写人经验不足，使用了模糊的或需自行判断的字词（例如，\"根据情况\"、\"根据需要\"、\"必要时\"等等）");
		//Click on 3.8.1 to reveal evidence entry
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']")));
		String s1 = ele.getAttribute("class");
		if(s1.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).getText();
		softly.assertThat(ev1).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Evidence entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-0"))).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Click on 3.8.1 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//2nd collapsible for 3.8.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c1).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.8.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();

		softly.assertThat(c2).as("test data").contains("访谈规则编写人？");
		String c26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();

		softly.assertThat(c26).as("test data").contains("审查规则编写指导文件？");
		//Click on 2nd collapsible for 3.8.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.8.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c10).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.8.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c3).as("test data").contains("建立规则编写人规则编写标准或指导文件");
		//Click on 3rd collapsible for 3.8.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.8.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(q342);
		softly.assertThat(q342).as("test data").contains("[3.8.2] 使用了不可定量的或需自行判断的条件（例如，检查\"足够多的\"样品）来避免内部QA审查");
		//Click on 3.8.2 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']")));
		String s2 = ele.getAttribute("class");
		if(s2.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).getText();

		softly.assertThat(ev2).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Evidence entry place holder
		String ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-1"))).getAttribute("placeholder");

		softly.assertThat(ph2).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Click on 3.8.2 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//2nd collapsible for 3.8.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c4).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.8.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();

		softly.assertThat(c5).as("test data").contains("访谈规则编写人？");
		String c34 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();

		softly.assertThat(c34).as("test data").contains("审查规则编写指导文件？");
		//Click on 2nd collapsible for 3.8.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.8.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.8.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c6).as("test data").contains("建立规则编写人规则编写标准或指导文件");
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();

		softly.assertThat(c22).as("test data").contains("就屏障明确性，对管理人员实施问责");
		//Click on 3rd collapsible for 3.8.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.8.3 question
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(q343);
		softly.assertThat(q343).as("test data").contains("[3.8.3] 要求判断执行程序步骤");
		//Click on 3.8.3 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']")));
		String s3 = ele.getAttribute("class");
		if(s3.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).getText();

		softly.assertThat(ev3).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Evidence entry place holder
		String ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-2"))).getAttribute("placeholder");

		softly.assertThat(ph3).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Click on 3.8.3 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//2nd collapsible for 3.8.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c7).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.8.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();

		softly.assertThat(c8).as("test data").contains("访谈规则编写人？");
		String c36 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();

		softly.assertThat(c36).as("test data").contains("审查规则编写指导文件？");
		//Click on 2nd collapsible for 3.8.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.8.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c12).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.8.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c9).as("test data").contains("建立规则编写人规则编写标准或指导文件");
		//Click on 3rd collapsible for 3.8.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.8.4 question
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();

		softly.assertThat(q344).as("test data").contains("[3.8.4] 没有明确与其他程序之间的接口");
		//Click on 3.8.4 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']")));
		String s4 = ele.getAttribute("class");
		if(s4.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).getText();

		softly.assertThat(ev4).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Evidence entry place holder
		String ph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-3"))).getAttribute("placeholder");

		softly.assertThat(ph4).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Click on 3.8.4 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		//2nd collapsible for 3.8.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c13).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.8.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();

		softly.assertThat(c14).as("test data").contains("访谈规则编写人？");
		String c38 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();

		softly.assertThat(c38).as("test data").contains("审查规则编写指导文件？");
		//Click on 2nd collapsible for 3.8.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.8.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c16).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.8.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c17).as("test data").contains("建立关于屏障接口设计的规则编写标准或指导文件");
		//Click on 3rd collapsible for 3.8.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.8.5 question
		String q345 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		System.out.println(q345);
		softly.assertThat(q345).as("test data").contains("[3.8.5] 可读性不高（即：高于八年级阅读水平）");
		//Click on 3.8.5 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']")));
		String s5 = ele.getAttribute("class");
		if(s5.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).getText();

		softly.assertThat(ev5).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Evidence entry place holder
		String ph5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-4"))).getAttribute("placeholder");

		softly.assertThat(ph5).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Click on 3.8.5 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		//2nd collapsible for 3.8.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c18).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.8.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c19).as("test data").contains("访谈规则编写人？");
		String c23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c23).as("test data").contains("审查规则编写指导文件？");
		//Click on 2nd collapsible for 3.8.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.8.5
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c20).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.8.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c21).as("test data").contains("建立关于保护屏障接口设计的规则编写标准或指导文件");
		//Click on 3rd collapsible for 3.8.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Scroll to the end
		obj.scrollToAPoint(driver, 1200);
		//3.8.6 question
		String q396 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).getText();

		softly.assertThat(q396).as("test data").contains("[3.8.6] 程序里和设备上出现不明确和不一致的设备标识与识别");
		//Click on 3.8.6 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']")));
		String s6 = ele.getAttribute("class");
		if(s6.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).getText();

		softly.assertThat(ev6).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).click();
		//Evidence entry place holder
		String ph6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-5"))).getAttribute("placeholder");

		softly.assertThat(ph6).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).click();
		//Click on 3.8.6 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).click();
		//2nd collapsible for 3.8.6
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c15).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.8.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();

		softly.assertThat(c28).as("test data").contains("验证程序和设备的标识确保明确性和一致性");
		//Click on 2nd collapsible for 3.8.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.8.6
		String c30 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c30).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.8.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c31 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c31).as("test data").contains("改善设备标识和程序对设备的识别的明确性和一致性");
		//Click on 3rd collapsible for 3.8.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.8.7 question
		String q367 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']"))).getText();

		softly.assertThat(q367).as("test data").contains("[3.8.7] 时间敏感步骤未明确写出");
		//Click on 3.8.7 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']")));
		String s7 = ele.getAttribute("class");
		if(s7.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-6']/h4/a"))).getText();

		softly.assertThat(ev7).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-6']/h4/a"))).click();
		//Evidence entry place holder
		String ph7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-6"))).getAttribute("placeholder");

		softly.assertThat(ph7).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-6']/h4/a"))).click();
		//Click on 3.8.7 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']"))).click();
		//2nd collapsible for 3.8.7
		String c41 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c41).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.8.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c42 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();

		softly.assertThat(c42).as("test data").contains("访谈编写者与审查者");
		//Click on 2nd collapsible for 3.8.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.8.7
		String c44 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c44).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.8.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c45 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c45).as("test data").contains("升版程序");
		//Click on 3rd collapsible for 3.8.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.8.8 question
		String q368 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-7']"))).getText();

		softly.assertThat(q368).as("test data").contains("[3.8.8] 程序未明确量化，使用描述如：稳定、异常");
		//Click on 3.8.8 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-7']")));
		String s8 = ele.getAttribute("class");
		if(s8.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-7']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-7']/h4/a"))).getText();

		softly.assertThat(ev8).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-7']/h4/a"))).click();
		//Evidence entry place holder
		String ph8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-7"))).getAttribute("placeholder");

		softly.assertThat(ph8).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-7']/h4/a"))).click();
		//Click on 3.8.8 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-7']"))).click();
		//2nd collapsible for 3.8.8
		String c46 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c46).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.8.8
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c47 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();

		softly.assertThat(c47).as("test data").contains("访谈编写者与审查者");
		//Click on 2nd collapsible for 3.8.8
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.8.8
		String c49 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c49).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.8.8
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c50 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c50).as("test data").contains("升版程序");
		//Click on 3rd collapsible for 3.8.8
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Add new contributing factor button
		String c33 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-button"))).getText();

		softly.assertThat(c33).as("test data").contains("新增促成因素");
		//Verify Add Contributing factor
		obj1.chineseAddContributingFactor(driver, softly);
		//Scroll to the top
		Thread.sleep(2000);
		obj.scrollToTop(driver);
		Thread.sleep(2000);
	}

	public void chineseStepOneL37 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		ShareCheck obj = new ShareCheck();
		HiRCAChinese4 obj1 = new HiRCAChinese4();
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();

		softly.assertThat(heading).as("test data").contains("偏差控制");
		softly.assertThat(heading).as("test data").contains("不到位");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();

		softly.assertThat(textD).as("test data").contains("若不适用点选skip略过。使用者可于底部新增促成因素。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();

		softly.assertThat(desc).as("test data").contains("是否缺少操作标记、停工待检或要求而促使该失误的发生?");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.7.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(q341);
		softly.assertThat(q341).as("test data").contains("[3.7.1] 进入和退出程序指引不到位");
		//Click on 3.7.1 to reveal evidence entry
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']")));
		String s1 = ele.getAttribute("class");
		if(s1.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).getText();
		softly.assertThat(ev1).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Evidence entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-0"))).getAttribute("placeholder");

		softly.assertThat(ph1).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Click on 3.7.1 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//2nd collapsible for 3.7.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c1).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.7.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c2).as("test data").contains("访谈规则编写人？");
		String c26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c26).as("test data").contains("审查规则编写指导文件？");
		//Click on 2nd collapsible for 3.7.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.7.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c10).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.7.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c3).as("test data").contains("建立关于");
		softly.assertThat(c3).as("test data").contains("偏差控制");
		softly.assertThat(c3).as("test data").contains("的规则编写标准或指导文件\", \"规则编写人的培训、授权和问责");
		//Click on 3rd collapsible for 3.7.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.7.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		softly.assertThat(q342).as("test data").contains("[3.7.2] 对于单项弱点步骤未设置自检或是独立检查");
		//Click on 3.7.2 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']")));
		String s2 = ele.getAttribute("class");
		if(s2.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).getText();

		softly.assertThat(ev2).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Evidence entry place holder
		String ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-1"))).getAttribute("placeholder");

		softly.assertThat(ph2).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Click on 3.7.2 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//2nd collapsible for 3.7.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c4).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.7.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();

		softly.assertThat(c5).as("test data").contains("访谈规则编写人？");
		String c34 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();

		softly.assertThat(c34).as("test data").contains("审查规则编写指导文件？");
		//Click on 2nd collapsible for 3.7.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.7.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.7.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c6).as("test data").contains("建立关于\"偏差控制\"的规则编写标准或指导文件\", \"规则编写人的培训、授权和问责");
		//Click on 3rd collapsible for 3.7.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.7.3 question
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(q343);
		softly.assertThat(q343).as("test data").contains("[3.7.3] 未识别出不可逆点(PNR)的操作步骤（予以审查），从而确保继续操作前先前的失误得到纠正");
		//Click on 3.7.3 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']")));
		String s3 = ele.getAttribute("class");
		if(s3.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).getText();

		softly.assertThat(ev3).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Evidence entry place holder
		String ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-2"))).getAttribute("placeholder");

		softly.assertThat(ph3).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Click on 3.7.3 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//2nd collapsible for 3.7.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();		
		softly.assertThat(c7).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.7.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();		
		softly.assertThat(c8).as("test data").contains("访谈规则编写人？");
		String c36 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();		
		softly.assertThat(c36).as("test data").contains("审查规则编写指导文件？");
		//Click on 2nd collapsible for 3.7.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.7.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();		
		softly.assertThat(c12).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.7.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();		
		softly.assertThat(c9).as("test data").contains("建立关于\"偏差控制\"的规则编写标准或指导文件\", \"规则编写人的培训、授权和问责");
		//Click on 3rd collapsible for 3.7.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.7.4 question
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();		
		softly.assertThat(q344).as("test data").contains("[3.7.4] 未使用操作标记法来防止跳步或跳页");
		//Click on 3.7.4 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']")));
		String s4 = ele.getAttribute("class");
		if(s4.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).getText();		
		softly.assertThat(ev4).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Evidence entry place holder
		String ph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-3"))).getAttribute("placeholder");		
		softly.assertThat(ph4).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Click on 3.7.4 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		//2nd collapsible for 3.7.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c13).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.7.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();

		softly.assertThat(c14).as("test data").contains("访谈规则编写人？");
		String c38 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();

		softly.assertThat(c38).as("test data").contains("审查规则编写指导文件？");
		//Click on 2nd collapsible for 3.7.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.7.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c16).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.7.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c17).as("test data").contains("建立关于\"偏差控制\"的规则编写标准或指导文件\", \"规则审查人的培训、授权和问责");
		//Click on 3rd collapsible for 3.7.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.7.5 question
		String q345 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		System.out.println(q345);
		softly.assertThat(q345).as("test data").contains("[3.7.5] 未分析并缓解很有可能出现违章的情况（通过迹象核实、复核、禁止操作警告等方式）");
		//Click on 3.7.5 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']")));
		String s5 = ele.getAttribute("class");
		if(s5.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).getText();

		softly.assertThat(ev5).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Evidence entry place holder
		String ph5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-4"))).getAttribute("placeholder");

		softly.assertThat(ph5).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Click on 3.7.5 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		//2nd collapsible for 3.7.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c18).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.7.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c19).as("test data").contains("访谈规则编写人？");
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c22).as("test data").contains("审查规则编写指导文件？");
		//Click on 2nd collapsible for 3.7.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.7.5
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c20).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.7.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c21).as("test data").contains("建立关于\"偏差控制\"的规则编写标准或指导文件\", \"规则编写人的培训、授权和问责");
		//Click on 3rd collapsible for 3.7.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Scroll to the end
		obj.scrollToAPoint(driver, 1200);
		//3.7.6 question
		String q396 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).getText();
		softly.assertThat(q396).as("test data").contains("[3.7.6] 例行作业未有充分的及时提醒标牌预防粗心犯错");
		//Click on 3.7.6 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']")));
		String s6 = ele.getAttribute("class");
		if(s6.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).getText();		
		softly.assertThat(ev6).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).click();
		//Evidence entry place holder
		String ph6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-5"))).getAttribute("placeholder");		
		softly.assertThat(ph6).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).click();
		//Click on 3.7.6 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).click();
		//2nd collapsible for 3.7.6
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c15).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.7.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();

		softly.assertThat(c28).as("test data").contains("访谈规则编写人？");
		String c40 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();

		softly.assertThat(c40).as("test data").contains("审查规则编写指导文件");
		//Click on 2nd collapsible for 3.7.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.7.6
		String c30 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c30).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.7.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c31 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c31).as("test data").contains("建立关于\"偏差控制\"的规则编写标准或指导文件\", \"规则编写人的培训、授权和问责");
		//Click on 3rd collapsible for 3.7.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.7.7 question
		String q367 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']"))).getText();

		softly.assertThat(q367).as("test data").contains("[3.7.7] 未使用清单预防遗忘相关错误");
		//Click on 3.7.7 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']")));
		String s7 = ele.getAttribute("class");
		if(s7.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-6']/h4/a"))).getText();

		softly.assertThat(ev7).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-6']/h4/a"))).click();
		//Evidence entry place holder
		String ph7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-6"))).getAttribute("placeholder");

		softly.assertThat(ph7).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-6']/h4/a"))).click();
		//Click on 3.7.7 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']"))).click();
		//2nd collapsible for 3.7.7
		String c41 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c41).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.7.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c42 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c42).as("test data").contains("访谈规则编写人？");
		String c43 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c43).as("test data").contains("审查规则编写指导文件");
		//Click on 2nd collapsible for 3.7.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.7.7
		String c44 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c44).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.7.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c45 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c45).as("test data").contains("建立关于\"偏差控制\"的规则编写标准或指导文件\", \"规则编写人的培训、授权和问责");
		//Click on 3rd collapsible for 3.7.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.7.8 question
		String q368 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-7']"))).getText();

		softly.assertThat(q368).as("test data").contains("[3.7.8] 同事指导的好文化不到位，未能鼓励和强调守规行为标准");
		//Click on 3.7.8 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-7']")));
		String s8 = ele.getAttribute("class");
		if(s8.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-7']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-7']/h4/a"))).getText();
		softly.assertThat(ev8).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-7']/h4/a"))).click();
		//Evidence entry place holder
		String ph8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-7"))).getAttribute("placeholder");
		softly.assertThat(ph8).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-7']/h4/a"))).click();
		//Click on 3.7.8 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-7']"))).click();
		//2nd collapsible for 3.7.8
		String c46 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c46).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.7.8
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c47 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c47).as("test data").contains("访谈犯错人");
		String c48 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c48).as("test data").contains("访谈同事");
		//Click on 2nd collapsible for 3.7.8
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.7.8
		String c49 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c49).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.7.8
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c50 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c50).as("test data").contains("培训如何做好同事指导守规文化");
		String c23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();

		softly.assertThat(c23).as("test data").contains("改善有缺陷的程序");
		//Click on 3rd collapsible for 3.7.8
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.7.9 question
		String q369 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-8']"))).getText();
		softly.assertThat(q369).as("test data").contains("[3.7.9] 审查不到位");
		//Click on 3.7.9 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-8']")));
		String s9 = ele.getAttribute("class");
		if(s9.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-8']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-8']/h4/a"))).getText();
		softly.assertThat(ev9).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-8']/h4/a"))).click();
		//Evidence entry place holder
		String ph9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-8"))).getAttribute("placeholder");
		softly.assertThat(ph9).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-8']/h4/a"))).click();
		//Click on 3.7.9 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-8']"))).click();
		//2nd collapsible for 3.7.9
		String c51 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c51).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.7.9
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c52 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c52).as("test data").contains("访谈审查者?");
		String c53 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c53).as("test data").contains("调查审查标准?");
		//Click on 2nd collapsible for 3.7.9
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.7.9
		String c54 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c54).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.7.9
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c55 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c55).as("test data").contains("建立关于\"偏差控制\"的规则编写标准或指导文件\", \"规则审查人的培训、授权和问责");
		//Click on 3rd collapsible for 3.7.9
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.7.10 question
		String q3691 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-9']"))).getText();
		softly.assertThat(q3691).as("test data").contains("[3.7.10] 维修不到位: (1) 预见性维修不到位 (2) 预防性维修不到位 3) 纠正性维修不到位 (4) 修后试验不到位 (5) 故障查找和根本原因分析不到位 (6) 维修失误");
		//Click on 3.7.10 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-9']")));
		String s91 = ele.getAttribute("class");
		if(s91.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-9']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev91 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-9']/h4/a"))).getText();
		softly.assertThat(ev91).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-9']/h4/a"))).click();
		//Evidence entry place holder
		String ph91 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-9"))).getAttribute("placeholder");
		softly.assertThat(ph91).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-9']/h4/a"))).click();
		//Click on 3.7.10 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-9']"))).click();
		//2nd collapsible for 3.7.10
		String c25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c25).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.7.10
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c24).as("test data").contains("与类似组织就维修实践进行对标");
		String c29 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c29).as("test data").contains("确定故障查找和根本原因分析报告的质量");
		String c32 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();
		softly.assertThat(c32).as("test data").contains("调查重复失效背后的共同原因");
		//Click on 2nd collapsible for 3.7.10
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.7.10
		String c35 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c35).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.7.10
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c37 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c37).as("test data").contains("纠正维修大纲中的缺陷");
		//Click on 3rd collapsible for 3.7.10
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Add new contributing factor button
		String c33 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-button"))).getText();

		softly.assertThat(c33).as("test data").contains("新增促成因素");
		//Verify Add Contributing factor
		obj1.chineseAddContributingFactor(driver, softly);
		//Scroll to the top
		Thread.sleep(2000);
		obj.scrollToTop(driver);
		Thread.sleep(2000);
	}

	public void chineseStepOneq115 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();

		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.15 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();

		softly.assertThat(q11).as("test data").contains("[1.15] 始发事件是否有单项弱点？");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();

		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");

		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();

		softly.assertThat(desc).as("test data").contains("单项弱点（SPV）是指一个失效或执行不正确的程序步骤、行动、工具或一个设备引起后果事件或导致整个过程失效。此外，SPV是不会自我披露的，直至其导致最终故障发生才披露");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();

		softly.assertThat(ans1).as("test data").contains("有，但未提前识别");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();

		softly.assertThat(ans2).as("test data").contains("有，识别出单项弱点但未缓解");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();

		softly.assertThat(ans3).as("test data").contains("没有");
	}

	public void chineseStepOneq114 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();

		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.14 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();

		softly.assertThat(q11).as("test data").contains("[1.14] 组长是否固定开展经验反馈？");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();

		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");

		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();

		softly.assertThat(desc).as("test data").contains("这个问题探讨是否在日常经验反馈学习时上强调类似任务相关的风险与常见失误。经验教训学习会有两个目标：（1）学习如何预防类似事件；（2）主管强化标准要求");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();

		softly.assertThat(ans1).as("test data").contains("没有，但其他组长有");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();

		softly.assertThat(ans2).as("test data").contains("没有，这为常态");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();

		softly.assertThat(ans3).as("test data").contains("有");
	}

	public void chineseStepOneq113 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();

		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.13 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();

		softly.assertThat(q11).as("test data").contains("[1.13] 错误的发生是否存在易出错精神状态或是高风险状态？");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();

		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");

		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();

		softly.assertThat(desc).as("test data").contains("这个问题检查易出错精神状态或高风险状态是否被识别出。我们的研究表明存在16个易出错精神状态和16个高风险状态，它们会显著增加失误率（参见");
		softly.assertThat(desc).as("test data").contains("关于");
		softly.assertThat(desc).as("test data").contains("部分）。70%的失误是由于易出错精神状态推动产生的，不存在任何外部因素（例如：恶劣的工作条件、工作指令不当）。大约有30%的间接失误是由于异常、外部影响促成的，也就是我们熟知的高风险状态。高风险表示事件发生概率或后果方面的风险增加。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();

		softly.assertThat(ans1).as("test data").contains("没有，请重新思考您的答案");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();

		softly.assertThat(ans2).as("test data").contains("有");
	}

	public void chineseStepOneq112 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();

		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.12 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();

		softly.assertThat(q11).as("test data").contains("[1.12] 若班前会、工前会或交底会未执行，为什么？");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();

		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");

		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();

		softly.assertThat(desc).as("test data").contains("执行任务前，若执行班前会、工前会或交底会以可以提前识别和缓解风险。不执行若班前会、工前会或交底会将促进失误的发生。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();

		softly.assertThat(ans1).as("test data").contains("违反程序规定未执行");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();

		softly.assertThat(ans2).as("test data").contains("不当的程序要求而未执行");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();

		softly.assertThat(ans3).as("test data").contains("没有要求执行所以未执行");
	}

	public void chineseStepOneq111 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();

		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.11 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();

		softly.assertThat(q11).as("test data").contains("[1.11] 这个错为何是现在发生而不是以前发生？");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();

		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");

		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();

		softly.assertThat(desc).as("test data").contains("这个问题探讨了为什么这个失误在之前有没有发生过？");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();

		softly.assertThat(ans1).as("test data").contains("新程序的使用未有妥当培训");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();

		softly.assertThat(ans2).as("test data").contains("对于犯错人员而言是新任务或是不熟悉的任务");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();

		softly.assertThat(ans3).as("test data").contains("过去有发生过类似错误");
	}

	public void chineseStepOneq110 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();

		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.10 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();

		softly.assertThat(q11).as("test data").contains("[1.10] 若有开班前会、工前会、交底会，为何犯错者未能意识到这个风险且缓解？");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();

		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");

		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();

		softly.assertThat(desc).as("test data").contains("这个问题探讨了开班前会、工前会、交底会在风险识别和缓解方面的效力");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();

		softly.assertThat(ans1).as("test data").contains("没有专心参与");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();

		softly.assertThat(ans2).as("test data").contains("因技能不足未讨论这个风险");
	}

	public void chineseStepOneL32 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		ShareCheck obj = new ShareCheck();
		HiRCAChinese4 obj1 = new HiRCAChinese4();
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();

		softly.assertThat(heading).as("test data").contains("组长主管层面");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();

		softly.assertThat(textD).as("test data").contains("若不适用点选skip略过。使用者可于底部新增促成因素。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();

		softly.assertThat(desc).as("test data").contains("这些促成因素归因于主管，因为这关系到影响个人和组织绩效的失误。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.2.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(q341);
		softly.assertThat(q341).as("test data").contains("[3.2.1] 组长强化标准方面的管理能力不足");
		//Click on 3.2.1 to reveal evidence entry
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']")));
		String s1 = ele.getAttribute("class");
		if(s1.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).getText();

		softly.assertThat(ev1).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Evidence entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-0"))).getAttribute("placeholder");

		softly.assertThat(ph1).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Click on 3.2.1 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//2nd collapsible for 3.2.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c1).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.2.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();

		softly.assertThat(c2).as("test data").contains("访谈同事？");
		//Click on 2nd collapsible for 3.2.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.2.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c10).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.2.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c3).as("test data").contains("监督管理方面的培训");
		String c27 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();

		softly.assertThat(c27).as("test data").contains("监督行为规范的管理");
		//Click on 3rd collapsible for 3.2.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.2.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(q342);
		softly.assertThat(q342).as("test data").contains("[3.2.2] 组长绩效反馈方面的管理能力不足");
		//Click on 3.2.2 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']")));
		String s2 = ele.getAttribute("class");
		if(s2.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).getText();

		softly.assertThat(ev2).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Evidence entry place holder
		String ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-1"))).getAttribute("placeholder");

		softly.assertThat(ph2).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Click on 3.2.2 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//2nd collapsible for 3.2.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c4).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.2.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();

		softly.assertThat(c5).as("test data").contains("访谈同事？");
		//Click on 2nd collapsible for 3.2.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.2.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.2.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c6).as("test data").contains("监督管理方面的培训");
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();

		softly.assertThat(c22).as("test data").contains("监督行为规范的管理");
		//Click on 3rd collapsible for 3.2.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.2.3 question
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(q343);
		softly.assertThat(q343).as("test data").contains("[3.2.3] 组长召开经验反馈的管理技能不足");
		//Click on 3.2.3 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']")));
		String s3 = ele.getAttribute("class");
		if(s3.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).getText();

		softly.assertThat(ev3).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Evidence entry place holder
		String ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-2"))).getAttribute("placeholder");

		softly.assertThat(ph3).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Click on 3.2.3 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//2nd collapsible for 3.2.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c7).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.2.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();

		softly.assertThat(c8).as("test data").contains("访谈同事？");
		//Click on 2nd collapsible for 3.2.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.2.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c12).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.2.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c9).as("test data").contains("监督管理方面的培训");
		String c23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();

		softly.assertThat(c23).as("test data").contains("监督行为规范的管理");
		//Click on 3rd collapsible for 3.2.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.2.4 question
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();

		softly.assertThat(q344).as("test data").contains("[3.2.4] 组长在岗培训方面管理能力不足");
		//Click on 3.2.4 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']")));
		String s4 = ele.getAttribute("class");
		if(s4.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).getText();

		softly.assertThat(ev4).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Evidence entry place holder
		String ph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-3"))).getAttribute("placeholder");

		softly.assertThat(ph4).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Click on 3.2.4 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		//2nd collapsible for 3.2.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c13).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.2.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();

		softly.assertThat(c14).as("test data").contains("访谈同事？");
		//Click on 2nd collapsible for 3.2.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.2.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c16).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.2.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c17).as("test data").contains("监督管理方面的培训");
		String c25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();

		softly.assertThat(c25).as("test data").contains("监督行为规范的管理");
		//Click on 3rd collapsible for 3.2.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.2.5 question
		String q345 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		System.out.println(q345);
		softly.assertThat(q345).as("test data").contains("[3.2.5] 组长对团队缺点认识不足，缺乏相应弥补措施");
		//Click on 3.2.5 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']")));
		String s5 = ele.getAttribute("class");
		if(s5.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).getText();

		softly.assertThat(ev5).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Evidence entry place holder
		String ph5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-4"))).getAttribute("placeholder");

		softly.assertThat(ph5).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Click on 3.2.5 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		//2nd collapsible for 3.2.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c18).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.2.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();

		softly.assertThat(c19).as("test data").contains("访谈同事？");
		//Click on 2nd collapsible for 3.2.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.2.5
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c20).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.2.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c21).as("test data").contains("监督管理方面的培训");
		String c24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();

		softly.assertThat(c24).as("test data").contains("监督行为规范的管理");
		//Click on 3rd collapsible for 3.2.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		obj.scrollToAPoint(driver, 1200);
		//3.2.6 question
		String q396 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).getText();

		softly.assertThat(q396).as("test data").contains("[3.2.6] 组长发出指令和后续贯彻的沟通及协调能力不足");
		//Click on 3.2.6 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']")));
		String s6 = ele.getAttribute("class");
		if(s6.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).getText();		
		softly.assertThat(ev6).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).click();
		//Evidence entry place holder
		String ph6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-5"))).getAttribute("placeholder");		
		softly.assertThat(ph6).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).click();
		//Click on 3.2.6 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).click();
		//2nd collapsible for 3.2.6
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c15).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.2.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();

		softly.assertThat(c28).as("test data").contains("访谈下属？");
		//Click on 2nd collapsible for 3.2.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.2.6
		String c30 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c30).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.2.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c31 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c31).as("test data").contains("监督管理方面的培训");
		String c32 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();

		softly.assertThat(c32).as("test data").contains("监督行为规范的管理");
		//Click on 3rd collapsible for 3.2.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Add new contributing factor button
		String c33 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-button"))).getText();

		softly.assertThat(c33).as("test data").contains("新增促成因素");
		//Verify Add Contributing factor
		obj1.chineseAddContributingFactor(driver, softly);
		Thread.sleep(2000);
		obj.scrollToTop(driver);
		Thread.sleep(2000);
	}

	public void chineseStepOneq19 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.9 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(q11).as("test data").contains("[1.9] 犯错者在事后是否有经组长或管理层问责？");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		softly.assertThat(desc).as("test data").contains("这个问题探讨了现有的问责机制。如果出现失误，无论是无意或有意的，都可从中学习到经验教训。问责机制不表示要接受惩罚，而是针对失误负责任。如果主管或管理层没有与犯错人员交谈，且没有完成全面调查，那么说明问责机制存在问题。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		softly.assertThat(ans1).as("test data").contains("没有");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		softly.assertThat(ans2).as("test data").contains("有");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		softly.assertThat(ans3).as("test data").contains("未知");
	}
	
	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}
}
