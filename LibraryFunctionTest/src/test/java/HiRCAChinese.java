import java.util.concurrent.TimeUnit;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
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
	
	public void changeToChinese (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
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
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Go to KALE homepage
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pii-logo-div-element-kale"))).click();
	}
	
	public void changeToEnglish (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
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
		//Changes language to English
		WebElement dropdown1 = driver.findElement(By.id("pii-admin-user-language"));
		Select s4 = new Select (dropdown1);
		s4.selectByVisibleText("English");
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-button-save"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-confirmed"))).click();
		//Waits for loading message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Go to KALE homepage
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pii-logo-div-element-kale"))).click();
	}

	public void pathHiRCA(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Clicks on Analysis 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-a"))).click();
		//Clicks on HiRCA
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-hirca"))).click();
		Thread.sleep(2000);
		//Verify everything on Event Information page is in 
		chineseEventInfo(driver);
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
		jse.executeScript("scroll(0,6500)");
		//Clicks on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[16]/div/button"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.1
		chineseStepOneq11(driver);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.2
		chineseStepOneq12(driver);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.4
		chineseStepOneL34(driver);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify 3.18
		chineseStepOneL318(driver);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.6
		chineseStepOneq16(driver);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.15
		chineseStepOneL315(driver);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.7
		chineseStepOneq17(driver);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.8
		chineseStepOneq18(driver);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.9
		chineseStepOneL39(driver);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify 3.10
		chineseStepOneL310(driver);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify 3.11
		chineseStepOneL311(driver);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
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
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify 3.11
		chineseStepOneL311(driver);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
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
		chineseStepOneL39(driver);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.12
		chineseStepOneq112(driver);
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
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.15
		chineseStepOneq115(driver);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.6
		chineseStepOneL36(driver);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
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
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
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
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.18
		chineseStepOneq118(driver);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.22
		chineseStepOneL322(driver);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
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
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify 3.5
		chineseStepOneL35(driver);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
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
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify pop up for LOP/RC
		chineseLOPRC(driver);
		//LOP pop up opens, click cancel
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-cancel"))).click();
		//Click on Step 1 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-tab-1"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.1
		chineseStepOneq11(driver);
		//Select answer 2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.17
		chineseStepOneL317(driver);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify pop up for LOP/RC
		chineseLOPRC(driver);
		//LOP pop up opens, click cancel
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-cancel"))).click();
		//Click on Step 1 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-tab-1"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.1
		chineseStepOneq11(driver);
		//Select answer 3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify pop up for LOP/RC
		chineseLOPRC(driver);
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
		//Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))).click();
		//Verify Save box
		chineseSave(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		//Wait for black server load message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			  }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Click on saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-btn-savedactivities"))).click();
		//Wait for black server load message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			  }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Clicks on first newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();
		//Wait for black server load message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			  }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Verify buttons on top
		chineseReportButtons(driver);
	}
	
	public void chineseReportButtons(WebDriver driver)throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Back Button
		String back = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-uhome-back"))).getText();
		System.out.println(back);
		softly.assertThat(back).as("test data").contains("返回");
		//Other buttons
		String b1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[1]"))).getText();
		System.out.println(b1);
		softly.assertThat(b1).as("test data").contains("开启");
		String b2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).getText();
		System.out.println(b2);
		softly.assertThat(b2).as("test data").contains("打印");
		String b3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[3]"))).getText();
		System.out.println(b3);
		softly.assertThat(b3).as("test data").contains("删除");
		String b4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[4]"))).getText();
		System.out.println(b4);
		softly.assertThat(b4).as("test data").contains("分享");
	}
	
	public void chineseSave(WebDriver driver)throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Dialog header
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-header"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("保存报告");
		//Dialog title
		String title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).getText();
		System.out.println(title);
		softly.assertThat(title).as("test data").contains("请确认你要存入现有报告进度?");
		//Cancel button
		String cn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-cancel"))).getText();
		System.out.println(cn);
		softly.assertThat(cn).as("test data").contains("取消");
		//Save button
		String lop = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).getText();
		System.out.println(lop);
		softly.assertThat(lop).as("test data").contains("保存报告");
	}
	
	public void chineseReport(WebDriver driver)throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Table1 header 
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[1]/table/thead/tr/th"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("事件信息");
		//Table1 Side titles of report 
		String title1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[1]/table/tbody/tr[1]/td[1]"))).getText();
		System.out.println(title1);
		softly.assertThat(title1).as("test data").contains("事件名称");
		String title2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[1]/table/tbody/tr[2]/td[1]"))).getText();
		System.out.println(title2);
		softly.assertThat(title2).as("test data").contains("事件编号");
		String title3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[1]/table/tbody/tr[3]/td[1]"))).getText();
		System.out.println(title3);
		softly.assertThat(title3).as("test data").contains("事件发生日期");
		String title4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[1]/table/tbody/tr[3]/td[3]"))).getText();
		System.out.println(title4);
		softly.assertThat(title4).as("test data").contains("事件发生时间");
		String title5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[1]/table/tbody/tr[4]/td[1]"))).getText();
		System.out.println(title5);
		softly.assertThat(title5).as("test data").contains("事件发生地点");
		String title6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[1]/table/tbody/tr[5]/td[1]"))).getText();
		System.out.println(title6);
		softly.assertThat(title6).as("test data").contains("部门");
		String title7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[1]/table/tbody/tr[6]/td[1]"))).getText();
		System.out.println(title7);
		softly.assertThat(title7).as("test data").contains("组");
		String title8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[1]/table/tbody/tr[7]/td[1]"))).getText();
		System.out.println(title8);
		softly.assertThat(title8).as("test data").contains("事件调查员");
		String title9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[1]/table/tbody/tr[8]/td[1]"))).getText();
		System.out.println(title9);
		softly.assertThat(title9).as("test data").contains("报告编写者");
		String title10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[1]/table/tbody/tr[9]/td[1]"))).getText();
		System.out.println(title10);
		softly.assertThat(title10).as("test data").contains("报告编写时间");
		//Table2 header 
		String heading1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[2]/table/thead/tr/th"))).getText();
		System.out.println(heading1);
		softly.assertThat(heading1).as("test data").contains("事件名称");
		//Table2 Side titles of report 
		String title11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[2]/table/tbody/tr[1]/td[1]"))).getText();
		System.out.println(title11);
		softly.assertThat(title11).as("test data").contains("报告摘要");
		String title12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[2]/table/tbody/tr[2]/td[1]"))).getText();
		System.out.println(title12);
		softly.assertThat(title12).as("test data").contains("事件描述");
		String title13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[2]/table/tbody/tr[3]/td[1]"))).getText();
		System.out.println(title13);
		softly.assertThat(title13).as("test data").contains("事件详细过程（时序构建）");
		String title14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[2]/table/tbody/tr[4]/td[1]"))).getText();
		System.out.println(title14);
		softly.assertThat(title14).as("test data").contains("相关信息");
		//header
		String header3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[3]"))).getText();
		System.out.println(header3);
		softly.assertThat(header3).as("test data").contains("事件原因");
		//Table3 header 
		String heading4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[4]/table/thead/tr/th[1]"))).getText();
		System.out.println(heading4);
		softly.assertThat(heading4).as("test data").contains("根本原因");
		String heading5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[4]/table/thead/tr/th[2]"))).getText();
		System.out.println(heading5);
		softly.assertThat(heading5).as("test data").contains("重要性分级");
		String heading6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[4]/table/thead/tr/th[3]"))).getText();
		System.out.println(heading6);
		softly.assertThat(heading6).as("test data").contains("纠正行动");
		//Table3 row
		String r1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[4]/table/tbody/tr[1]/td[1]"))).getText();
		System.out.println(r1);
		softly.assertThat(r1).as("test data").contains("不适用");
		String r2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[4]/table/tbody/tr[1]/td[2]"))).getText();
		System.out.println(r2);
		softly.assertThat(r2).as("test data").contains("不适用");
		String r3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[4]/table/tbody/tr[1]/td[3]"))).getText();
		System.out.println(r3);
		softly.assertThat(r3).as("test data").contains("不适用");
		//Table4 header 
		String heading7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/thead/tr/th[1]"))).getText();
		System.out.println(heading7);
		softly.assertThat(heading7).as("test data").contains("促成因素");
		String heading8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/thead/tr/th[2]"))).getText();
		System.out.println(heading8);
		softly.assertThat(heading8).as("test data").contains("重要性分级");
		String heading9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/thead/tr/th[3]"))).getText();
		System.out.println(heading9);
		softly.assertThat(heading9).as("test data").contains("纠正行动");
		//Table4 row
		String r4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[1]/td[1]"))).getText();
		System.out.println(r4);
		softly.assertThat(r4).as("test data").contains("不适用");
		String r5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[1]/td[2]"))).getText();
		System.out.println(r5);
		softly.assertThat(r5).as("test data").contains("不适用");
		String r6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[1]/td[3]"))).getText();
		System.out.println(r6);
		softly.assertThat(r6).as("test data").contains("不适用");
		//Table 5 heading
		String heading10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/table/thead/tr/th[1]"))).getText();
		System.out.println(heading10);
		softly.assertThat(heading10).as("test data").contains("缺少的屏障");
		//Table 5 row
		String r7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/table/tbody/tr[1]/td[1]"))).getText();
		System.out.println(r7);
		softly.assertThat(r7).as("test data").contains("未缺少屏障");
		//header
		String header11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/div"))).getText();
		System.out.println(header11);
		softly.assertThat(header11).as("test data").contains("根本原因分析过程");
	}
	
	public void chineseHIRCAChecklist(WebDriver driver)throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//header
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("第五步");
		softly.assertThat(heading).as("test data").contains("自检清单");
		//Table headers
		String th = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[1]/th[1]"))).getText();
		System.out.println(th);
		softly.assertThat(th).as("test data").contains("类别");
		String th1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[1]/th[2]"))).getText();
		System.out.println(th1);
		softly.assertThat(th1).as("test data").contains("调查内容");
		String th2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[1]/th[3]"))).getText();
		System.out.println(th2);
		softly.assertThat(th2).as("test data").contains("完成打勾?");
		//Row 1
		String tr = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[1]/strong"))).getText();
		System.out.println(tr);
		softly.assertThat(tr).as("test data").contains("调查概述");
		String tr1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[2]"))).getText();
		System.out.println(tr1);
		softly.assertThat(tr1).as("test data").contains("是否访谈了所有相关方，是否收集了所有相关数据？");
		//Row 2
		String tr2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[3]/td[2]"))).getText();
		System.out.println(tr2);
		softly.assertThat(tr2).as("test data").contains("是否检查了以往的类似事件？");
		//Row 3
		String tr3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[4]/td[2]"))).getText();
		System.out.println(tr3);
		softly.assertThat(tr3).as("test data").contains("是否识别出始发事件和相关屏障？");
		//Row 4
		String tr4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[5]/td[1]/strong"))).getText();
		System.out.println(tr4);
		softly.assertThat(tr4).as("test data").contains("始发事件");
		String tr5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[5]/td[2]"))).getText();
		System.out.println(tr5);
		softly.assertThat(tr5).as("test data").contains("是否确定始发事件的相关错误类型？");
		//Row 5
		String tr6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[6]/td[2]"))).getText();
		System.out.println(tr6);
		softly.assertThat(tr6).as("test data").contains("进行始发失误分析的始发事件中是否有相关的设备故障？");
		//Row 6
		String tr7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[7]/td[2]"))).getText();
		System.out.println(tr7);
		softly.assertThat(tr7).as("test data").contains("是否确定促成因子？");
		//Row 7
		String tr8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[8]/td[1]/strong"))).getText();
		System.out.println(tr8);
		softly.assertThat(tr8).as("test data").contains("根本原因");
		String tr9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[8]/td[2]"))).getText();
		System.out.println(tr9);
		softly.assertThat(tr9).as("test data").contains("根本原因是否符合");
		softly.assertThat(tr9).as("test data").contains(" 标准？");
		//Row 8
		String tr10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[9]/td[2]"))).getText();
		System.out.println(tr10);
		softly.assertThat(tr10).as("test data").contains("根本原因是否经得住");
		softly.assertThat(tr10).as("test data").contains("挑战？");
		//Row 9
		String tr11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[10]/td[2]"))).getText();
		System.out.println(tr11);
		softly.assertThat(tr11).as("test data").contains("是否识别根本原因的重要性？");
		//Row 10
		String tr12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[11]/td[1]/strong"))).getText();
		System.out.println(tr12);
		softly.assertThat(tr12).as("test data").contains("纠正行动");
		String tr13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[11]/td[2]"))).getText();
		System.out.println(tr13);
		softly.assertThat(tr13).as("test data").contains("建议的纠正行动是否涵盖所有直接原因、根本原因和关键促成因素？");
		//Row 11
		String tr14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[12]/td[2]"))).getText();
		System.out.println(tr14);
		softly.assertThat(tr14).as("test data").contains("建议的纠正行动是否具有成本效益？");
	}
	
	public void chineseStep4(WebDriver driver)throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//header
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("第四步 - 判别根本原因和促成因素的重要性");
		//Table headers
		String th = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[1]/th[1]"))).getText();
		System.out.println(th);
		softly.assertThat(th).as("test data").contains("始发事件的根本原因与促成因素");
		String th1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[1]/th[2]"))).getText();
		System.out.println(th1);
		softly.assertThat(th1).as("test data").contains("R:根本原因 或 C:促成因素");
		String th1d = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[1]/th[2]/div"))).getText();
		System.out.println(th1d);
		softly.assertThat(th1d).as("test data").contains("(R 或 C)");
		String th2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[1]/th[3]"))).getText();
		System.out.println(th2);
		softly.assertThat(th2).as("test data").contains("重要性分级");
		String th2d = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[1]/th[3]/div"))).getText();
		System.out.println(th2d);
		softly.assertThat(th2d).as("test data").contains("(H:高, M:中 或 L:低)");
		//Row
		String tr = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[1]"))).getText();
		System.out.println(tr);
		softly.assertThat(tr).as("test data").contains("不适用");
		String tr1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[2]"))).getText();
		System.out.println(tr1);
		softly.assertThat(tr1).as("test data").contains("不适用");
		String tr2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[3]"))).getText();
		System.out.println(tr2);
		softly.assertThat(tr2).as("test data").contains("不适用");
	}
	
	public void chineseSUEP(WebDriver driver)throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//header
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("第三步 - 判别根本原因");
		//S
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		System.out.println(s);
		softly.assertThat(s).as("test data").contains(": 是否存在不合标准的实践?");
		//U
		String u = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]"))).getText();
		System.out.println(u);
		softly.assertThat(u).as("test data").contains(": 是否在管理层控制下?");
		//E
		String e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]"))).getText();
		System.out.println(e);
		softly.assertThat(e).as("test data").contains(": 是否在事件时序早期?");
		//P
		String p = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]"))).getText();
		System.out.println(p);
		softly.assertThat(p).as("test data").contains(": 是否防止再次发生?");
		//Table heading
		String th = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[1]/th[1]"))).getText();
		System.out.println(th);
		softly.assertThat(th).as("test data").contains("促成因素");
		//Row
		String tr = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[1]"))).getText();
		System.out.println(tr);
		softly.assertThat(tr).as("test data").contains("不适用");
		String tr1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[2]"))).getText();
		System.out.println(tr1);
		softly.assertThat(tr1).as("test data").contains("不适用");
		String tr2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[3]"))).getText();
		System.out.println(tr2);
		softly.assertThat(tr2).as("test data").contains("不适用");
		String tr3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[4]"))).getText();
		System.out.println(tr3);
		softly.assertThat(tr3).as("test data").contains("不适用");
		String tr4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[5]"))).getText();
		System.out.println(tr4);
		softly.assertThat(tr4).as("test data").contains("不适用");
	}
	
	public void chineseLOPRC(WebDriver driver)throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Dialog header
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-header"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("屏障或根本原因分析");
		//Dialog title
		String title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).getText();
		System.out.println(title);
		softly.assertThat(title).as("test data").contains("您要(1)继续分析屏障失效或是(2)前往根本原因分析？");
		//Dialog note
		String note = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-note"))).getText();
		System.out.println(note);
		softly.assertThat(note).as("test data").contains("提醒：屏障失效分析可以随时回头再做。");
		//Cancel button
		String cn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-cancel"))).getText();
		System.out.println(cn);
		softly.assertThat(cn).as("test data").contains("取消");
		//LOP button
		String lop = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).getText();
		System.out.println(lop);
		softly.assertThat(lop).as("test data").contains("屏障");
		//Root cause button
		String rc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed2"))).getText();
		System.out.println(rc);
		softly.assertThat(rc).as("test data").contains("根本原因");
	}
	
	public void chineseStepOneL317 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("设备的鉴定、试验和维修");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		System.out.println(textD);
		softly.assertThat(textD).as("test data").contains("若不适用点选skip略过。使用者可于底部新增促成因素。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("若始发事件是由设备失效造成，可初步评估设备可能失效原因。完整的设备根本原因分析或故障排除请使用EiRCA模块。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.17.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(q341);
		softly.assertThat(q341).as("test data").contains("[3.17.1] 采购和（或）设计规范不充分");
		//Click on 3.17.1 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).getText();
		System.out.println(ev1);
		softly.assertThat(ev1).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Evidence entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-0"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Click on 3.17.1 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//2nd collapsible for 3.17.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c1);
		softly.assertThat(c1).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.17.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c2);
		softly.assertThat(c2).as("test data").contains("用于制定技术规范的行业标准？QA/QC?");
		String c26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c26);
		softly.assertThat(c26).as("test data").contains("供应商资格？");
		//Click on 2nd collapsible for 3.17.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.17.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c10);
		softly.assertThat(c10).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.17.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c3);
		softly.assertThat(c3).as("test data").contains("提高风险管理");
		String c35 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c35);
		softly.assertThat(c35).as("test data").contains("针对高风险技术规范，利用专家委员会");
		String c37 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[3]"))).getText();
		System.out.println(c37);
		softly.assertThat(c37).as("test data").contains("对重复技术规范实现标准化");
		//Click on 3rd collapsible for 3.17.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.17.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(q342);
		softly.assertThat(q342).as("test data").contains("[3.17.2] 来源合规性的审计/检查(QA/QC) 不充分（如适用）");
		//Click on 3.17.2 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).getText();
		System.out.println(ev2);
		softly.assertThat(ev2).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Evidence entry place holder
		String ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-1"))).getAttribute("placeholder");
		System.out.println(ph2);
		softly.assertThat(ph2).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Click on 3.17.2 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//2nd collapsible for 3.17.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c4);
		softly.assertThat(c4).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.17.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c5);
		softly.assertThat(c5).as("test data").contains("QA/QC 人员的培训和授权？全范围QA审计？");
		String c46 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c46);
		softly.assertThat(c46).as("test data").contains("连续审计/检查或抽查审计/检查？");
		//Click on 2nd collapsible for 3.17.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.17.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c11);
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.17.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c6);
		softly.assertThat(c6).as("test data").contains("改善来源QA/QC 项目");
		//Click on 3rd collapsible for 3.17.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.17.3 question
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(q343);
		softly.assertThat(q343).as("test data").contains("[3.17.3] 设计确认和（或）使用前试验不充分");
		//Click on 3.17.3 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).getText();
		System.out.println(ev3);
		softly.assertThat(ev3).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Evidence entry place holder
		String ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-2"))).getAttribute("placeholder");
		System.out.println(ph3);
		softly.assertThat(ph3).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Click on 3.17.3 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//2nd collapsible for 3.17.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c7);
		softly.assertThat(c7).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.17.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c8);
		softly.assertThat(c8).as("test data").contains("外推过多而没有执行鉴定试验？");
		String c36 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c36);
		softly.assertThat(c36).as("test data").contains("复杂分析或计算的独立验证？");
		String c47 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();
		System.out.println(c47);
		softly.assertThat(c47).as("test data").contains("非编码计算的不确定性分析？");
		//Click on 2nd collapsible for 3.17.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.17.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c12);
		softly.assertThat(c12).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.17.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c9);
		softly.assertThat(c9).as("test data").contains("改善设计确认和鉴定试验项目");
		//Click on 3rd collapsible for 3.17.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.17.4 question
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		System.out.println(q344);
		softly.assertThat(q344).as("test data").contains("[3.17.4] 运行不到位: (1) 运行程序不到位; (2) 运行条件不到位; (3) 运行失误");
		//Click on 3.17.4 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).getText();
		System.out.println(ev4);
		softly.assertThat(ev4).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Evidence entry place holder
		String ph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-3"))).getAttribute("placeholder");
		System.out.println(ph4);
		softly.assertThat(ph4).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Click on 3.17.4 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		//2nd collapsible for 3.17.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c13);
		softly.assertThat(c13).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.17.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c14);
		softly.assertThat(c14).as("test data").contains("审查运行程序编写指导文件");
		//Click on 2nd collapsible for 3.17.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.17.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c16);
		softly.assertThat(c16).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.17.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c17);
		softly.assertThat(c17).as("test data").contains("纠正运行程序中的缺陷");
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c22);
		softly.assertThat(c22).as("test data").contains("完善运行程序编写指导文件");
		//Click on 3rd collapsible for 3.17.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.17.5 question
		String q345 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		System.out.println(q345);
		softly.assertThat(q345).as("test data").contains("[3.17.5] 定期监督试验不到位");
		//Click on 3.17.5 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).getText();
		System.out.println(ev5);
		softly.assertThat(ev5).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Evidence entry place holder
		String ph5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-4"))).getAttribute("placeholder");
		System.out.println(ph5);
		softly.assertThat(ph5).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Click on 3.17.5 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		//2nd collapsible for 3.17.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c18);
		softly.assertThat(c18).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.17.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c19);
		softly.assertThat(c19).as("test data").contains("没有执行监督试验？");
		//Click on 2nd collapsible for 3.17.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.17.5
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c20);
		softly.assertThat(c20).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.17.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c21);
		softly.assertThat(c21).as("test data").contains("完善监督试验大纲");
		//Click on 3rd collapsible for 3.17.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Scroll to the end
		Thread.sleep(2000);
		jse.executeScript("scroll(0,1100)");
		Thread.sleep(2000);
		//3.17.6 question
		String q396 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).getText();
		System.out.println(q396);
		softly.assertThat(q396).as("test data").contains("[3.17.6] 维修不到位");
		//Click on 3.17.6 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).getText();
		System.out.println(ev6);
		softly.assertThat(ev6).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).click();
		//Evidence entry place holder
		String ph6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-5"))).getAttribute("placeholder");
		System.out.println(ph6);
		softly.assertThat(ph6).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).click();
		//Click on 3.17.6 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).click();
		//2nd collapsible for 3.17.6
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c15);
		softly.assertThat(c15).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.17.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c28);
		softly.assertThat(c28).as("test data").contains("没有执行预防性维修？");
		String c40 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c40);
		softly.assertThat(c40).as("test data").contains("纠正性维修没有效果？");
		//Click on 2nd collapsible for 3.17.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.17.6
		String c30 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c30);
		softly.assertThat(c30).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.17.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c31 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c31);
		softly.assertThat(c31).as("test data").contains("完善预防性维修大纲");
		String c32 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c32);
		softly.assertThat(c32).as("test data").contains("完善纠正性维修大纲");
		//Click on 3rd collapsible for 3.17.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.17.7 question
		String q367 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']"))).getText();
		System.out.println(q367);
		softly.assertThat(q367).as("test data").contains("[3.17.7] 设备的标识和识别不到位");
		//Click on 3.17.7 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-6']/h4/a"))).getText();
		System.out.println(ev7);
		softly.assertThat(ev7).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-6']/h4/a"))).click();
		//Evidence entry place holder
		String ph7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-6"))).getAttribute("placeholder");
		System.out.println(ph7);
		softly.assertThat(ph7).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-6']/h4/a"))).click();
		//Click on 3.17.7 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']"))).click();
		//2nd collapsible for 3.17.7
		String c41 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c41);
		softly.assertThat(c41).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.17.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c42 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c42);
		softly.assertThat(c42).as("test data").contains("检查所有提及的设备不仅有标识，且标识正确");
		//Click on 2nd collapsible for 3.17.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.17.7
		String c44 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c44);
		softly.assertThat(c44).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.3.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c45 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c45);
		softly.assertThat(c45).as("test data").contains("改进设备标识和识别");
		//Click on 3rd collapsible for 3.17.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Add new contributing factor button
		String c33 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-button"))).getText();
		System.out.println(c33);
		softly.assertThat(c33).as("test data").contains("新增促成因素");
		//Scroll to the top
		Thread.sleep(2000);
		jse.executeScript("scroll(0,0)");
		Thread.sleep(2000);
	}
	
	public void chineseStepOneq120 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.20 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(q11);
		softly.assertThat(q11).as("test data").contains("[1.20] 错误是否与工作时发生改变有关？");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();
		System.out.println(reason);
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("这一问题探讨了工作过程中的变更是否促成失误发生的原因。工作过程中的变更可能会产生新的、不熟悉的事物，这会造成易出错状态的形成");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(ans1);
		softly.assertThat(ans1).as("test data").contains("是");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(ans2);
		softly.assertThat(ans2).as("test data").contains("是，为无法预测的天灾");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(ans3);
		softly.assertThat(ans3).as("test data").contains("否");
	}	
	
	public void chineseStepOneL35 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("情况警觉不充分");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		System.out.println(textD);
		softly.assertThat(textD).as("test data").contains("若不适用点选skip略过。使用者可于底部新增促成因素。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("情况警觉识别和分析影响失误率的内部和外部风险。内部分析涉及易出错的精神状态。外部风险涉及高风险状态。有证据表明缺乏情况警觉会促成这个失误发生吗？");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.5.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(q341);
		softly.assertThat(q341).as("test data").contains("[3.5.1] 作业前情况警觉（如易出错的精神状态和高风险情况）不充分");
		//Click on 3.5.1 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).getText();
		System.out.println(ev1);
		softly.assertThat(ev1).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Evidence entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-0"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Click on 3.5.1 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//2nd collapsible for 3.5.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c1);
		softly.assertThat(c1).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.5.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c2);
		softly.assertThat(c2).as("test data").contains("情况警觉培训？");
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c22);
		softly.assertThat(c22).as("test data").contains("作业前意识体系的改善？");
		//Click on 2nd collapsible for 3.5.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.5.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c10);
		softly.assertThat(c10).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.5.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c3);
		softly.assertThat(c3).as("test data").contains("情况警觉培训");
		String c23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c23);
		softly.assertThat(c23).as("test data").contains("作业前情况警觉（如 TAPE、工前会等）关于何时、何人、何事的要求");
		//Click on 3rd collapsible for 3.5.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.5.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(q342);
		softly.assertThat(q342).as("test data").contains("[3.5.2] 作业过程中情况警觉（如易出错的精神状态和高风险情况）不充分");
		//Click on 3.5.2 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).getText();
		System.out.println(ev2);
		softly.assertThat(ev2).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Evidence entry place holder
		String ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-1"))).getAttribute("placeholder");
		System.out.println(ph2);
		softly.assertThat(ph2).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Click on 3.5.2 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//2nd collapsible for 3.5.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c4);
		softly.assertThat(c4).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.5.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c5);
		softly.assertThat(c5).as("test data").contains("情况警觉培训？");
		//Click on 2nd collapsible for 3.5.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.5.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c11);
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.5.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c6);
		softly.assertThat(c6).as("test data").contains("情况警觉培训");
		//Click on 3rd collapsible for 3.5.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.5.3 question
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(q343);
		softly.assertThat(q343).as("test data").contains("[3.5.3] 对人员表现的观察技能不足");
		//Click on 3.22.3 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).getText();
		System.out.println(ev3);
		softly.assertThat(ev3).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Evidence entry place holder
		String ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-2"))).getAttribute("placeholder");
		System.out.println(ph3);
		softly.assertThat(ph3).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Click on 3.5.3 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//2nd collapsible for 3.5.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c7);
		softly.assertThat(c7).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.5.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c8);
		softly.assertThat(c8).as("test data").contains("情况警觉培训？");
		//Click on 2nd collapsible for 3.5.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.5.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c12);
		softly.assertThat(c12).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.5.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		System.out.println(c9);
		softly.assertThat(c9).as("test data").contains("开展人员表现观察技能方面的培训");
		//Click on 3rd collapsible for 3.5.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.5.4 question
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		System.out.println(q344);
		softly.assertThat(q344).as("test data").contains("[3.5.4] 对设备性能的观察技能不足");
		//Click on 3.5.4 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).getText();
		System.out.println(ev4);
		softly.assertThat(ev4).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Evidence entry place holder
		String ph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-3"))).getAttribute("placeholder");
		System.out.println(ph4);
		softly.assertThat(ph4).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Click on 3.5.4 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		//2nd collapsible for 3.5.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c13);
		softly.assertThat(c13).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.5.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c14);
		softly.assertThat(c14).as("test data").contains("情况警觉培训？");
		//Click on 2nd collapsible for 3.5.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.5.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c16);
		softly.assertThat(c16).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.5.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c17);
		softly.assertThat(c17).as("test data").contains("开展退化、异常和变化等设备性能观察技能方面的培训");
		//Click on 3rd collapsible for 3.5.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Add new contributing factor button
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-button"))).getText();
		System.out.println(c15);
		softly.assertThat(c15).as("test data").contains("新增促成因素");
	}
	
	public void chineseStepOneq119 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.19 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(q11);
		softly.assertThat(q11).as("test data").contains("[1.19] 是否有类似事件重发的趋势？");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();
		System.out.println(reason);
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("这个问题探讨了此事件是否与组织的绩效控制管理有关。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(ans1);
		softly.assertThat(ans1).as("test data").contains("是");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(ans2);
		softly.assertThat(ans2).as("test data").contains("没有，趋势下降");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(ans3);
		softly.assertThat(ans3).as("test data").contains("没有");
	}
	
	public void chineseStepOneL322 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("规则不正确");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		System.out.println(textD);
		softly.assertThat(textD).as("test data").contains("若不适用点选skip略过。使用者可于底部新增促成因素。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("若规则不正确，是什么原因导致的？");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.22.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(q341);
		softly.assertThat(q341).as("test data").contains("[3.22.1] 对规则的现场试验不充分");
		//Click on 3.22.1 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).getText();
		System.out.println(ev1);
		softly.assertThat(ev1).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Evidence entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-0"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Click on 3.22.1 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//2nd collapsible for 3.22.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c1);
		softly.assertThat(c1).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.22.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c2);
		softly.assertThat(c2).as("test data").contains("有无现场试验？");
		//Click on 2nd collapsible for 3.22.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.22.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c10);
		softly.assertThat(c10).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.22.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c3);
		softly.assertThat(c3).as("test data").contains("发布规则/程序前，执行现场试验");
		//Click on 3rd collapsible for 3.22.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.22.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(q342);
		softly.assertThat(q342).as("test data").contains("[3.22.2] 给规则编写人的反馈不充分，从而使其纠正错误规则");
		//Click on 3.22.2 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).getText();
		System.out.println(ev2);
		softly.assertThat(ev2).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Evidence entry place holder
		String ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-1"))).getAttribute("placeholder");
		System.out.println(ph2);
		softly.assertThat(ph2).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Click on 3.22.2 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//2nd collapsible for 3.22.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c4);
		softly.assertThat(c4).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.22.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c5);
		softly.assertThat(c5).as("test data").contains("有无反馈？");
		//Click on 2nd collapsible for 3.22.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.22.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c11);
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.22.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c6);
		softly.assertThat(c6).as("test data").contains("设计出允许执行人员记录失误方便编写人改正的程序");
		String c28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c28);
		softly.assertThat(c28).as("test data").contains("制定遇到程序关键错误后要求停止操作的政策");
		//Click on 3rd collapsible for 3.22.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.22.3 question
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(q343);
		softly.assertThat(q343).as("test data").contains("[3.22.3] 盲目信任错误规则");
		//Click on 3.22.3 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).getText();
		System.out.println(ev3);
		softly.assertThat(ev3).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Evidence entry place holder
		String ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-2"))).getAttribute("placeholder");
		System.out.println(ph3);
		softly.assertThat(ph3).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Click on 3.22.3 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//2nd collapsible for 3.22.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c7);
		softly.assertThat(c7).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.22.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c8);
		softly.assertThat(c8).as("test data").contains("是否要求澄清？");
		//Click on 2nd collapsible for 3.22.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.22.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c12);
		softly.assertThat(c12).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.22.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		System.out.println(c9);
		softly.assertThat(c9).as("test data").contains("培训");
		//Click on 3rd collapsible for 3.22.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.22.4 question
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		System.out.println(q344);
		softly.assertThat(q344).as("test data").contains("[3.22.4] 规则审核不到位");
		//Click on 3.22.4 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).getText();
		System.out.println(ev4);
		softly.assertThat(ev4).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Evidence entry place holder
		String ph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-3"))).getAttribute("placeholder");
		System.out.println(ph4);
		softly.assertThat(ph4).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Click on 3.22.4 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		//2nd collapsible for 3.22.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c13);
		softly.assertThat(c13).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.22.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c14);
		softly.assertThat(c14).as("test data").contains("程序/规则当时是如何审核的？");
		//Click on 2nd collapsible for 3.22.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.22.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c16);
		softly.assertThat(c16).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.22.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c17);
		softly.assertThat(c17).as("test data").contains("提供有效审核的相关培训");
		//Click on 3rd collapsible for 3.22.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.22.5 question
		String q345 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		System.out.println(q345);
		softly.assertThat(q345).as("test data").contains("[3.22.5] 工前会、班前会、交底会的规则不充分");
		//Click on 3.22.5 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).getText();
		System.out.println(ev5);
		softly.assertThat(ev5).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Evidence entry place holder
		String ph5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-4"))).getAttribute("placeholder");
		System.out.println(ph5);
		softly.assertThat(ph5).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Click on 3.22.5 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		//2nd collapsible for 3.22.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c18);
		softly.assertThat(c18).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.22.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c19);
		softly.assertThat(c19).as("test data").contains("工前会、班前会、交底会上是否识别出错误的规则/程序？");
		//Click on 2nd collapsible for 3.22.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.22.5
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c20);
		softly.assertThat(c20).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.22.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c21);
		softly.assertThat(c21).as("test data").contains("完善关于工前会、班前会、交底会的规则");
		//Click on 3rd collapsible for 3.22.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Add new contributing factor button
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-button"))).getText();
		System.out.println(c15);
		softly.assertThat(c15).as("test data").contains("新增促成因素");
	}
	
	public void chineseStepOneq118 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.18 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(q11);
		softly.assertThat(q11).as("test data").contains("[1.18] 事件是因程序规则有误导致？");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();
		System.out.println(reason);
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("这个问题探讨了现有规制是否不仅促成这一实例的发生，还促成了这一失误的多次发生");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(ans1);
		softly.assertThat(ans1).as("test data").contains("是");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(ans2);
		softly.assertThat(ans2).as("test data").contains("不是");
	}
	
	public void chineseStepOneL33 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("经理层面");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		System.out.println(textD);
		softly.assertThat(textD).as("test data").contains("若不适用点选skip略过。使用者可于底部新增促成因素。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("这些促成因素归因于经理层，因为这关系到影响组织绩效的失误。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.3.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(q341);
		softly.assertThat(q341).as("test data").contains("[3.3.1] 经理团队资源分配不到位");
		//Click on 3.3.1 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).getText();
		System.out.println(ev1);
		softly.assertThat(ev1).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Evidence entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-0"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Click on 3.3.1 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//2nd collapsible for 3.3.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c1);
		softly.assertThat(c1).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.3.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c2);
		softly.assertThat(c2).as("test data").contains("是否一些工作组工作量过多，而另一些工作组工作量过少？");
		String c26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c26);
		softly.assertThat(c26).as("test data").contains("分配工作更多的是为了纠正问题，而不是防治问题？");
		//Click on 2nd collapsible for 3.3.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.3.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c10);
		softly.assertThat(c10).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.3.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c3);
		softly.assertThat(c3).as("test data").contains("提升管理技能，完善资源分配体系");
		//Click on 3rd collapsible for 3.3.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.3.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(q342);
		softly.assertThat(q342).as("test data").contains("[3.3.2] 经理团队所需培训开展不充分");
		//Click on 3.3.2 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).getText();
		System.out.println(ev2);
		softly.assertThat(ev2).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Evidence entry place holder
		String ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-1"))).getAttribute("placeholder");
		System.out.println(ph2);
		softly.assertThat(ph2).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Click on 3.3.2 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//2nd collapsible for 3.3.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c4);
		softly.assertThat(c4).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.3.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c5);
		softly.assertThat(c5).as("test data").contains("培训计划是否从提高效率和提高质量两个方面考虑？");
		//Click on 2nd collapsible for 3.3.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.3.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c11);
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.3.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c6);
		softly.assertThat(c6).as("test data").contains("成立培训计划委员会");
		//Click on 3rd collapsible for 3.3.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.3.3 question
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(q343);
		softly.assertThat(q343).as("test data").contains("[3.3.3] 经理团队问责制不到位");
		//Click on 3.3.3 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).getText();
		System.out.println(ev3);
		softly.assertThat(ev3).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Evidence entry place holder
		String ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-2"))).getAttribute("placeholder");
		System.out.println(ph3);
		softly.assertThat(ph3).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Click on 3.3.3 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//2nd collapsible for 3.3.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c7);
		softly.assertThat(c7).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.3.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c8);
		softly.assertThat(c8).as("test data").contains("PM&T是否充分？");
		String c36 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c36);
		softly.assertThat(c36).as("test data").contains("JO是否充分？");
		String c37 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();
		System.out.println(c37);
		softly.assertThat(c37).as("test data").contains("RCA是否充分？");
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[4]"))).getText();
		System.out.println(c22);
		softly.assertThat(c22).as("test data").contains("ORRA是否充分？");
		//Click on 2nd collapsible for 3.3.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.3.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c12);
		softly.assertThat(c12).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.3.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c9);
		softly.assertThat(c9).as("test data").contains("完善问责制");
		//Click on 3rd collapsible for 3.3.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.3.4 question
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		System.out.println(q344);
		softly.assertThat(q344).as("test data").contains("[3.3.4] 经理团队对确定工作优先级和计划方面不到位");
		//Click on 3.3.4 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).getText();
		System.out.println(ev4);
		softly.assertThat(ev4).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Evidence entry place holder
		String ph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-3"))).getAttribute("placeholder");
		System.out.println(ph4);
		softly.assertThat(ph4).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Click on 3.3.4 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		//2nd collapsible for 3.3.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c13);
		softly.assertThat(c13).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.3.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c14);
		softly.assertThat(c14).as("test data").contains("工作流程中没有包括工作优先级的确定？");
		String c38 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c38);
		softly.assertThat(c38).as("test data").contains("优先级确定标准在时间、范围（质量）和成本三个方面没有平衡好？");
		//Click on 2nd collapsible for 3.3.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.3.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c16);
		softly.assertThat(c16).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.3.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c17);
		softly.assertThat(c17).as("test data").contains("完善管理优先级确定和计划体系？");
		//Click on 3rd collapsible for 3.3.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.3.5 question
		String q345 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		System.out.println(q345);
		softly.assertThat(q345).as("test data").contains("[3.3.5] 经理管理人员对以下标准制定不充分：(1) 行为规范 (2) 程序和屏障");
		//Click on 3.3.5 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).getText();
		System.out.println(ev5);
		softly.assertThat(ev5).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Evidence entry place holder
		String ph5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-4"))).getAttribute("placeholder");
		System.out.println(ph5);
		softly.assertThat(ph5).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Click on 3.3.5 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		//2nd collapsible for 3.3.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c18);
		softly.assertThat(c18).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.3.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c19);
		softly.assertThat(c19).as("test data").contains("自我分析（自评）？");
		String c23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c23);
		softly.assertThat(c23).as("test data").contains("与表现优秀者对标？");
		//Click on 2nd collapsible for 3.3.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.3.5
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c20);
		softly.assertThat(c20).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.3.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c21);
		softly.assertThat(c21).as("test data").contains("开展关于标准设定的管理培训");
		String c24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c24);
		softly.assertThat(c24).as("test data").contains("开展关于程序和保护屏障设计的培训");
		//Click on 3rd collapsible for 3.3.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Scroll to the end
		Thread.sleep(2000);
		jse.executeScript("scroll(0,1300)");
		Thread.sleep(2000);
		//3.3.6 question
		String q396 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).getText();
		System.out.println(q396);
		softly.assertThat(q396).as("test data").contains("[3.3.6] 经理团队绩效跟踪与趋势分析不到位");
		//Click on 3.3.6 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).getText();
		System.out.println(ev6);
		softly.assertThat(ev6).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).click();
		//Evidence entry place holder
		String ph6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-5"))).getAttribute("placeholder");
		System.out.println(ph6);
		softly.assertThat(ph6).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).click();
		//Click on 3.3.6 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).click();
		//2nd collapsible for 3.3.6
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c15);
		softly.assertThat(c15).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.3.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c28);
		softly.assertThat(c28).as("test data").contains("KPI不充分？");
		String c40 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c40);
		softly.assertThat(c40).as("test data").contains("没有定期开展共因分析？");
		String c25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();
		System.out.println(c25);
		softly.assertThat(c25).as("test data").contains("未对类似事件或失误进行趋势分析？");
		//Click on 2nd collapsible for 3.3.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.3.6
		String c30 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c30);
		softly.assertThat(c30).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.3.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c31 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c31);
		softly.assertThat(c31).as("test data").contains("定期开展共因分析");
		String c32 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c32);
		softly.assertThat(c32).as("test data").contains("改善绩效跟踪与趋势分析项目");
		String c27 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[3]"))).getText();
		System.out.println(c27);
		softly.assertThat(c27).as("test data").contains("完善KPI");
		//Click on 3rd collapsible for 3.3.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.3.7 question
		String q367 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']"))).getText();
		System.out.println(q367);
		softly.assertThat(q367).as("test data").contains("[3.3.7] 经理团队内未充分建立关于团队合作的共同目标、共同利益和共同责任");
		//Click on 3.3.7 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-6']/h4/a"))).getText();
		System.out.println(ev7);
		softly.assertThat(ev7).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-6']/h4/a"))).click();
		//Evidence entry place holder
		String ph7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-6"))).getAttribute("placeholder");
		System.out.println(ph7);
		softly.assertThat(ph7).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-6']/h4/a"))).click();
		//Click on 3.3.7 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']"))).click();
		//2nd collapsible for 3.3.7
		String c41 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c41);
		softly.assertThat(c41).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.3.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c42 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c42);
		softly.assertThat(c42).as("test data").contains("经理之间的接口问题？");
		String c43 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c43);
		softly.assertThat(c43).as("test data").contains("主管或经理之间存在不和？");
		String c29 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();
		System.out.println(c29);
		softly.assertThat(c29).as("test data").contains("因两个管理团队之间接口问题，导致工作没有做？");
		//Click on 2nd collapsible for 3.3.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.3.7
		String c44 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c44);
		softly.assertThat(c44).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.3.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c45 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c45);
		softly.assertThat(c45).as("test data").contains("开展组织设计方面的管理培训");
		String c34 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c34);
		softly.assertThat(c34).as("test data").contains("在经理人员之间建立共同目标、共同利益和共同责任");
		//Click on 3rd collapsible for 3.3.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.3.8 question
		String q368 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-7']"))).getText();
		System.out.println(q368);
		softly.assertThat(q368).as("test data").contains("[3.3.8] 经理团队纠正行动不足");
		//Click on 3.3.8 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-7']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-7']/h4/a"))).getText();
		System.out.println(ev8);
		softly.assertThat(ev8).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-7']/h4/a"))).click();
		//Evidence entry place holder
		String ph8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-7"))).getAttribute("placeholder");
		System.out.println(ph8);
		softly.assertThat(ph8).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-7']/h4/a"))).click();
		//Click on 3.3.8 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-7']"))).click();
		//2nd collapsible for 3.3.8
		String c46 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c46);
		softly.assertThat(c46).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.3.8
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c47 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c47);
		softly.assertThat(c47).as("test data").contains("根本原因分析不足导致事件重发？");
		String c48 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c48);
		softly.assertThat(c48).as("test data").contains("没有注意到关键的在变化的问题导致未能解决紧急问题？");
		String c35 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();
		System.out.println(c35);
		softly.assertThat(c35).as("test data").contains("纠正行动制定过多导致大量纠正行动仍然积压？");
		//Click on 2nd collapsible for 3.3.8
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.3.8
		String c49 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c49);
		softly.assertThat(c49).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.3.8
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c50 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c50);
		softly.assertThat(c50).as("test data").contains("提高纠正行动计划的落实");
		String c39 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c39);
		softly.assertThat(c39).as("test data").contains("改善根本原因分析方法");
		String c56 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/div/ul/li[3]"))).getText();
		System.out.println(c56);
		softly.assertThat(c56).as("test data").contains("完善突发紧急问题（危机）管理机制");
		//Click on 3rd collapsible for 3.3.8
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.3.9 question
		String q369 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-8']"))).getText();
		System.out.println(q369);
		softly.assertThat(q369).as("test data").contains("[3.3.9] 经理团队垂直沟通体系不完善");
		//Click on 3.3.9 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-8']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-8']/h4/a"))).getText();
		System.out.println(ev9);
		softly.assertThat(ev9).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-8']/h4/a"))).click();
		//Evidence entry place holder
		String ph9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-8"))).getAttribute("placeholder");
		System.out.println(ph9);
		softly.assertThat(ph9).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-8']/h4/a"))).click();
		//Click on 3.3.9 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-8']"))).click();
		//2nd collapsible for 3.3.9
		String c51 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c51);
		softly.assertThat(c51).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.3.9
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c52 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c52);
		softly.assertThat(c52).as("test data").contains("方针培训？");
		String c53 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c53);
		softly.assertThat(c53).as("test data").contains("对员工的管理指导？");
		String c57 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();
		System.out.println(c57);
		softly.assertThat(c57).as("test data").contains("传达给员工的工作指令不充分？");
		String c58 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/div/ul/li[4]"))).getText();
		System.out.println(c58);
		softly.assertThat(c58).as("test data").contains("是否定期召开员工会议？");
		//Click on 2nd collapsible for 3.3.9
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.3.9
		String c54 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c54);
		softly.assertThat(c54).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.3.9
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c55 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c55);
		softly.assertThat(c55).as("test data").contains("完善垂直沟通体系");
		//Click on 3rd collapsible for 3.6.9
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.3.10 question
		String q3310 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-9']"))).getText();
		System.out.println(q3310);
		softly.assertThat(q3310).as("test data").contains("[3.3.10] 经理团队横向沟通体系不完善");
		//Click on 3.3.10 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-9']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-9']/h4/a"))).getText();
		System.out.println(ev10);
		softly.assertThat(ev10).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-9']/h4/a"))).click();
		//Evidence entry place holder
		String ph10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-9"))).getAttribute("placeholder");
		System.out.println(ph10);
		softly.assertThat(ph10).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-9']/h4/a"))).click();
		//Click on 3.3.10 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-9']"))).click();
		Thread.sleep(1000);
		//2nd collapsible for 3.3.10
		String c59 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c59);
		softly.assertThat(c59).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.3.10
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c60 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c60);
		softly.assertThat(c60).as("test data").contains("共同目标和共同利益不充分？");
		String c61 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c61);
		softly.assertThat(c61).as("test data").contains("程序设计不当？");
		//Click on 2nd collapsible for 3.3.10
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.3.10
		String c62 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c62);
		softly.assertThat(c62).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.3.10
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c63 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c63);
		softly.assertThat(c63).as("test data").contains("完善程序设计");
		String c64 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c64);
		softly.assertThat(c64).as("test data").contains("制定共同目标和共同利益");
		//Click on 3rd collapsible for 3.3.10
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Add new contributing factor button
		String c33 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-button"))).getText();
		System.out.println(c33);
		softly.assertThat(c33).as("test data").contains("新增促成因素");
		//Scroll to the top
		Thread.sleep(2000);
		jse.executeScript("scroll(0,0)");
		Thread.sleep(2000);
	}
	
	public void chineseStepOneq117 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.17 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(q11);
		softly.assertThat(q11).as("test data").contains("[1.17] 事件是与经理管理不当有关？");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();
		System.out.println(reason);
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("这个问题探讨了失误受管理效力影响的可能性；相关影响要素包括设定组织标准、绩效问责机制等。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(ans1);
		softly.assertThat(ans1).as("test data").contains("有");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(ans2);
		softly.assertThat(ans2).as("test data").contains("没有");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(ans3);
		softly.assertThat(ans3).as("test data").contains("未知");
	}
	
	public void chineseStepOneq116 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.16 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(q11);
		softly.assertThat(q11).as("test data").contains("[1.16] 事件是与组长监督管理不当有关？");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();
		System.out.println(reason);
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("这个问题探讨了失误受监管效力影响的可能性；相关影响要素包括行为标准的强化、绩效反馈、与现场员工交流、指导计划等。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(ans1);
		softly.assertThat(ans1).as("test data").contains("是，跟其他组长相比下有缺失");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(ans2);
		softly.assertThat(ans2).as("test data").contains("没有");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(ans3);
		softly.assertThat(ans3).as("test data").contains("未知");
	}
	
	public void chineseStepOneL36 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("全面性不足");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		System.out.println(textD);
		softly.assertThat(textD).as("test data").contains("若不适用点选skip略过。使用者可于底部新增促成因素。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("该失误的促成原因是否为制度、程序、等规范缺少要求、运行工况、假设、范围、试验/测量和缺少章节或部分。全面性不足查看程序设计是否涵盖所有要求、工况、假设和工作范围。如果是由于程序中缺少既定指导或者遗漏必要功能/步骤而造成困惑，从而导致发生失误，那么全面性方面非常可能存在不足。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.6.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(q341);
		softly.assertThat(q341).as("test data").contains("[3.6.1] 要求有遗漏");
		//Click on 3.6.1 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).getText();
		System.out.println(ev1);
		softly.assertThat(ev1).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Evidence entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-0"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Click on 3.6.1 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//2nd collapsible for 3.6.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c1);
		softly.assertThat(c1).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.6.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c2);
		softly.assertThat(c2).as("test data").contains("规范和标准？");
		String c26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c26);
		softly.assertThat(c26).as("test data").contains("规范和标准？");
		String c29 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();
		System.out.println(c29);
		softly.assertThat(c29).as("test data").contains("与其他项目之间的接口要求？");
		//Click on 2nd collapsible for 3.6.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.6.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c10);
		softly.assertThat(c10).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.6.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c3);
		softly.assertThat(c3).as("test data").contains("完善规则");
		String c27 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c27);
		softly.assertThat(c27).as("test data").contains("开展程序设计方面的培训");
		//Click on 3rd collapsible for 3.6.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.6.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(q342);
		softly.assertThat(q342).as("test data").contains("[3.6.2] 运行条件有遗漏");
		//Click on 3.6.2 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).getText();
		System.out.println(ev2);
		softly.assertThat(ev2).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Evidence entry place holder
		String ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-1"))).getAttribute("placeholder");
		System.out.println(ph2);
		softly.assertThat(ph2).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Click on 3.6.2 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//2nd collapsible for 3.6.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c4);
		softly.assertThat(c4).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.6.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c5);
		softly.assertThat(c5).as("test data").contains("规则适用的运行条件范围？");
		String c34 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c34);
		softly.assertThat(c34).as("test data").contains("进入规则的前提条件？");
		String c35 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();
		System.out.println(c35);
		softly.assertThat(c35).as("test data").contains("退出规则的条件？");
		//Click on 2nd collapsible for 3.6.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.6.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c11);
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.6.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c6);
		softly.assertThat(c6).as("test data").contains("完善规则");
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c22);
		softly.assertThat(c22).as("test data").contains("开展程序设计方面的培训");
		//Click on 3rd collapsible for 3.6.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.6.3 question
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(q343);
		softly.assertThat(q343).as("test data").contains("[3.6.3] 假设有遗漏");
		//Click on 3.6.3 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).getText();
		System.out.println(ev3);
		softly.assertThat(ev3).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Evidence entry place holder
		String ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-2"))).getAttribute("placeholder");
		System.out.println(ph3);
		softly.assertThat(ph3).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Click on 3.6.3 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//2nd collapsible for 3.6.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c7);
		softly.assertThat(c7).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.6.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c8);
		softly.assertThat(c8).as("test data").contains("假设未予以说明？");
		String c36 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c36);
		softly.assertThat(c36).as("test data").contains("未要求在任务完成前对假设进行验证？");
		String c37 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();
		System.out.println(c37);
		softly.assertThat(c37).as("test data").contains("对未经验证的假设没有制定缓解措施？");
		//Click on 2nd collapsible for 3.6.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.6.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c12);
		softly.assertThat(c12).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.6.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c9);
		softly.assertThat(c9).as("test data").contains("完善规则");
		String c23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c23);
		softly.assertThat(c23).as("test data").contains("开展程序设计方面的培训");
		//Click on 3rd collapsible for 3.6.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.6.4 question
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		System.out.println(q344);
		softly.assertThat(q344).as("test data").contains("[3.6.4] 范围有遗漏");
		//Click on 3.6.4 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).getText();
		System.out.println(ev4);
		softly.assertThat(ev4).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Evidence entry place holder
		String ph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-3"))).getAttribute("placeholder");
		System.out.println(ph4);
		softly.assertThat(ph4).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Click on 3.6.4 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		//2nd collapsible for 3.6.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c13);
		softly.assertThat(c13).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.6.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c14);
		softly.assertThat(c14).as("test data").contains("使用通用规则，缺少针对各种特殊情况的具体描述？");
		String c38 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c38);
		softly.assertThat(c38).as("test data").contains("步骤遗漏？");
		String c39 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();
		System.out.println(c39);
		softly.assertThat(c39).as("test data").contains("遗漏了碰到异常情况时需采取的行动？");
		//Click on 2nd collapsible for 3.6.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.6.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c16);
		softly.assertThat(c16).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.6.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c17);
		softly.assertThat(c17).as("test data").contains("完善规则");
		String c25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c25);
		softly.assertThat(c25).as("test data").contains("开展程序设计方面的培训");
		//Click on 3rd collapsible for 3.6.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.6.5 question
		String q345 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		System.out.println(q345);
		softly.assertThat(q345).as("test data").contains("[3.6.5] 试验或测量有遗漏");
		//Click on 3.6.5 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).getText();
		System.out.println(ev5);
		softly.assertThat(ev5).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Evidence entry place holder
		String ph5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-4"))).getAttribute("placeholder");
		System.out.println(ph5);
		softly.assertThat(ph5).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Click on 3.6.5 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		//2nd collapsible for 3.6.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c18);
		softly.assertThat(c18).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.6.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c19);
		softly.assertThat(c19).as("test data").contains("遗漏了用于验收是否正确执行的相关试验或测量？");
		//Click on 2nd collapsible for 3.6.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.6.5
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c20);
		softly.assertThat(c20).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.6.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c21);
		softly.assertThat(c21).as("test data").contains("完善规则");
		String c24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c24);
		softly.assertThat(c24).as("test data").contains("开展程序设计方面的培训");
		//Click on 3rd collapsible for 3.6.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Scroll to the end
		Thread.sleep(2000);
		jse.executeScript("scroll(0,1200)");
		Thread.sleep(2000);
		//3.6.6 question
		String q396 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).getText();
		System.out.println(q396);
		softly.assertThat(q396).as("test data").contains("[3.6.6] 遗漏以下信息: (1) 目的; (2) 先决条件; (3) 定义; (4) 经验反馈用");
		softly.assertThat(q396).as("test data").contains("不准做清单");
		softly.assertThat(q396).as("test data").contains("体现; (5) 参考资料; (6) 要求使用者反馈");
		//Click on 3.6.6 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).getText();
		System.out.println(ev6);
		softly.assertThat(ev6).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).click();
		//Evidence entry place holder
		String ph6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-5"))).getAttribute("placeholder");
		System.out.println(ph6);
		softly.assertThat(ph6).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).click();
		//Click on 3.6.6 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).click();
		//2nd collapsible for 3.6.6
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c15);
		softly.assertThat(c15).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.6.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c28);
		softly.assertThat(c28).as("test data").contains("调查程序编写者");
		String c40 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c40);
		softly.assertThat(c40).as("test data").contains("调查程序设计编写培训");
		//Click on 2nd collapsible for 3.6.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.6.6
		String c30 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c30);
		softly.assertThat(c30).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.6.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c31 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c31);
		softly.assertThat(c31).as("test data").contains("开展程序设计编写培训");
		String c32 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c32);
		softly.assertThat(c32).as("test data").contains("改善程序编写导则");
		//Click on 3rd collapsible for 3.6.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.6.7 question
		String q367 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']"))).getText();
		System.out.println(q367);
		softly.assertThat(q367).as("test data").contains("[3.6.7] 审查不到位导致制度有遗漏项");
		//Click on 3.6.7 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-6']/h4/a"))).getText();
		System.out.println(ev7);
		softly.assertThat(ev7).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-6']/h4/a"))).click();
		//Evidence entry place holder
		String ph7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-6"))).getAttribute("placeholder");
		System.out.println(ph7);
		softly.assertThat(ph7).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-6']/h4/a"))).click();
		//Click on 3.6.7 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']"))).click();
		//2nd collapsible for 3.6.7
		String c41 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c41);
		softly.assertThat(c41).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.6.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c42 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c42);
		softly.assertThat(c42).as("test data").contains("调查程序审查者");
		String c43 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c43);
		softly.assertThat(c43).as("test data").contains("调查程序审查培训");
		//Click on 2nd collapsible for 3.6.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.6.7
		String c44 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c44);
		softly.assertThat(c44).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.6.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c45 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c45);
		softly.assertThat(c45).as("test data").contains("开展程序审查培训");
		//Click on 3rd collapsible for 3.6.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.6.8 question
		String q368 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-7']"))).getText();
		System.out.println(q368);
		softly.assertThat(q368).as("test data").contains("[3.6.8] 根本原因分析不到位导致制度有遗漏项");
		//Click on 3.6.8 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-7']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-7']/h4/a"))).getText();
		System.out.println(ev8);
		softly.assertThat(ev8).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-7']/h4/a"))).click();
		//Evidence entry place holder
		String ph8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-7"))).getAttribute("placeholder");
		System.out.println(ph8);
		softly.assertThat(ph8).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-7']/h4/a"))).click();
		//Click on 3.6.8 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-7']"))).click();
		//2nd collapsible for 3.6.8
		String c46 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c46);
		softly.assertThat(c46).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.6.8
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c47 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c47);
		softly.assertThat(c47).as("test data").contains("调查事件调查者");
		String c48 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c48);
		softly.assertThat(c48).as("test data").contains("调查事件根本原因培训");
		//Click on 2nd collapsible for 3.6.8
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.6.8
		String c49 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c49);
		softly.assertThat(c49).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.6.8
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c50 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c50);
		softly.assertThat(c50).as("test data").contains("开展根本原因培训");
		//Click on 3rd collapsible for 3.6.8
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.6.9 question
		String q369 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-8']"))).getText();
		System.out.println(q369);
		softly.assertThat(q369).as("test data").contains("[3.6.9] 纠正措施执行不到位导致制度有遗漏项");
		//Click on 3.6.9 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-8']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-8']/h4/a"))).getText();
		System.out.println(ev9);
		softly.assertThat(ev9).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-8']/h4/a"))).click();
		//Evidence entry place holder
		String ph9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-8"))).getAttribute("placeholder");
		System.out.println(ph9);
		softly.assertThat(ph9).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-8']/h4/a"))).click();
		//Click on 3.6.9 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-8']"))).click();
		//2nd collapsible for 3.6.9
		String c51 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c51);
		softly.assertThat(c51).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.6.9
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c52 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c52);
		softly.assertThat(c52).as("test data").contains("调查纠正措施主管");
		String c53 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c53);
		softly.assertThat(c53).as("test data").contains("调查纠正措施制度缺陷");
		//Click on 2nd collapsible for 3.6.9
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.6.9
		String c54 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c54);
		softly.assertThat(c54).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.6.9
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c55 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c55);
		softly.assertThat(c55).as("test data").contains("改善纠正措施制度的监督与执行");
		//Click on 3rd collapsible for 3.6.9
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Add new contributing factor button
		String c33 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-button"))).getText();
		System.out.println(c33);
		softly.assertThat(c33).as("test data").contains("新增促成因素");
		//Scroll to the top
		Thread.sleep(2000);
		jse.executeScript("scroll(0,0)");
		Thread.sleep(2000);
	}
	
	public void chineseStepOneq115 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.15 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(q11);
		softly.assertThat(q11).as("test data").contains("[1.15] 始发事件是否有单项弱点？");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();
		System.out.println(reason);
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("单项弱点（SPV）是指一个失效或执行不正确的程序步骤、行动、工具或一个设备引起后果事件或导致整个过程失效。此外，SPV是不会自我披露的，直至其导致最终故障发生才披露");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(ans1);
		softly.assertThat(ans1).as("test data").contains("有，但未提前识别");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(ans2);
		softly.assertThat(ans2).as("test data").contains("有，识别出单项弱点但未缓解");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(ans3);
		softly.assertThat(ans3).as("test data").contains("没有");
	}
	
	public void chineseStepOneq114 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.14 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(q11);
		softly.assertThat(q11).as("test data").contains("[1.14] 组长是否固定开展经验反馈？");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();
		System.out.println(reason);
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("这个问题探讨是否在日常经验反馈学习时上强调类似任务相关的风险与常见失误。经验教训学习会有两个目标：（1）学习如何预防类似事件；（2）主管强化标准要求");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(ans1);
		softly.assertThat(ans1).as("test data").contains("没有，但其他组长有");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(ans2);
		softly.assertThat(ans2).as("test data").contains("没有，这为常态");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(ans3);
		softly.assertThat(ans3).as("test data").contains("有");
	}
	
	public void chineseStepOneq113 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.13 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(q11);
		softly.assertThat(q11).as("test data").contains("[1.13] 错误的发生是否存在易出错精神状态或是高风险状态？");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();
		System.out.println(reason);
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("这个问题检查易出错精神状态或高风险状态是否被识别出。我们的研究表明存在16个易出错精神状态和16个高风险状态，它们会显著增加失误率（参见");
		softly.assertThat(desc).as("test data").contains("关于");
		softly.assertThat(desc).as("test data").contains("部分）。70%的失误是由于易出错精神状态推动产生的，不存在任何外部因素（例如：恶劣的工作条件、工作指令不当）。大约有30%的间接失误是由于异常、外部影响促成的，也就是我们熟知的高风险状态。高风险表示事件发生概率或后果方面的风险增加。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(ans1);
		softly.assertThat(ans1).as("test data").contains("没有，请重新思考您的答案");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(ans2);
		softly.assertThat(ans2).as("test data").contains("有");
	}
	
	public void chineseStepOneq112 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.12 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(q11);
		softly.assertThat(q11).as("test data").contains("[1.12] 若班前会、工前会或交底会未执行，为什么？");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();
		System.out.println(reason);
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("执行任务前，若执行班前会、工前会或交底会以可以提前识别和缓解风险。不执行若班前会、工前会或交底会将促进失误的发生。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(ans1);
		softly.assertThat(ans1).as("test data").contains("违反程序规定未执行");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(ans2);
		softly.assertThat(ans2).as("test data").contains("不当的程序要求而未执行");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(ans3);
		softly.assertThat(ans3).as("test data").contains("没有要求执行所以未执行");
	}
	
	public void chineseStepOneq111 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.11 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(q11);
		softly.assertThat(q11).as("test data").contains("[1.11] 这个错为何是现在发生而不是以前发生？");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();
		System.out.println(reason);
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("这个问题探讨了为什么这个失误在之前有没有发生过？");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(ans1);
		softly.assertThat(ans1).as("test data").contains("新程序的使用未有妥当培训");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(ans2);
		softly.assertThat(ans2).as("test data").contains("对于犯错人员而言是新任务或是不熟悉的任务");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(ans3);
		softly.assertThat(ans3).as("test data").contains("过去有发生过类似错误");
	}
	
	public void chineseStepOneq110 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.10 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(q11);
		softly.assertThat(q11).as("test data").contains("[1.10] 若有开班前会、工前会、交底会，为何犯错者未能意识到这个风险且缓解？");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();
		System.out.println(reason);
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("这个问题探讨了开班前会、工前会、交底会在风险识别和缓解方面的效力");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(ans1);
		softly.assertThat(ans1).as("test data").contains("没有专心参与");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(ans2);
		softly.assertThat(ans2).as("test data").contains("因技能不足未讨论这个风险");
	}
	
	public void chineseStepOneL32 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("组长主管层面");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		System.out.println(textD);
		softly.assertThat(textD).as("test data").contains("若不适用点选skip略过。使用者可于底部新增促成因素。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("这些促成因素归因于主管，因为这关系到影响个人和组织绩效的失误。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.2.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(q341);
		softly.assertThat(q341).as("test data").contains("[3.2.1] 组长强化标准方面的管理能力不足");
		//Click on 3.2.1 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).getText();
		System.out.println(ev1);
		softly.assertThat(ev1).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Evidence entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-0"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Click on 3.2.1 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//2nd collapsible for 3.2.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c1);
		softly.assertThat(c1).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.2.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c2);
		softly.assertThat(c2).as("test data").contains("访谈同事？");
		//Click on 2nd collapsible for 3.2.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.2.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c10);
		softly.assertThat(c10).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.2.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c3);
		softly.assertThat(c3).as("test data").contains("监督管理方面的培训");
		String c27 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c27);
		softly.assertThat(c27).as("test data").contains("监督行为规范的管理");
		//Click on 3rd collapsible for 3.2.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.2.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(q342);
		softly.assertThat(q342).as("test data").contains("[3.2.2] 组长绩效反馈方面的管理能力不足");
		//Click on 3.2.2 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).getText();
		System.out.println(ev2);
		softly.assertThat(ev2).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Evidence entry place holder
		String ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-1"))).getAttribute("placeholder");
		System.out.println(ph2);
		softly.assertThat(ph2).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Click on 3.2.2 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//2nd collapsible for 3.2.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c4);
		softly.assertThat(c4).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.2.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c5);
		softly.assertThat(c5).as("test data").contains("访谈同事？");
		//Click on 2nd collapsible for 3.2.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.2.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c11);
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.2.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c6);
		softly.assertThat(c6).as("test data").contains("监督管理方面的培训");
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c22);
		softly.assertThat(c22).as("test data").contains("监督行为规范的管理");
		//Click on 3rd collapsible for 3.2.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.2.3 question
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(q343);
		softly.assertThat(q343).as("test data").contains("[3.2.3] 组长召开经验反馈的管理技能不足");
		//Click on 3.2.3 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).getText();
		System.out.println(ev3);
		softly.assertThat(ev3).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Evidence entry place holder
		String ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-2"))).getAttribute("placeholder");
		System.out.println(ph3);
		softly.assertThat(ph3).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Click on 3.2.3 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//2nd collapsible for 3.2.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c7);
		softly.assertThat(c7).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.2.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c8);
		softly.assertThat(c8).as("test data").contains("访谈同事？");
		//Click on 2nd collapsible for 3.2.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.2.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c12);
		softly.assertThat(c12).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.2.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c9);
		softly.assertThat(c9).as("test data").contains("监督管理方面的培训");
		String c23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c23);
		softly.assertThat(c23).as("test data").contains("监督行为规范的管理");
		//Click on 3rd collapsible for 3.2.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.2.4 question
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		System.out.println(q344);
		softly.assertThat(q344).as("test data").contains("[3.2.4] 组长在岗培训方面管理能力不足");
		//Click on 3.2.4 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).getText();
		System.out.println(ev4);
		softly.assertThat(ev4).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Evidence entry place holder
		String ph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-3"))).getAttribute("placeholder");
		System.out.println(ph4);
		softly.assertThat(ph4).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Click on 3.2.4 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		//2nd collapsible for 3.2.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c13);
		softly.assertThat(c13).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.2.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c14);
		softly.assertThat(c14).as("test data").contains("访谈同事？");
		//Click on 2nd collapsible for 3.2.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.2.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c16);
		softly.assertThat(c16).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.2.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c17);
		softly.assertThat(c17).as("test data").contains("监督管理方面的培训");
		String c25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c25);
		softly.assertThat(c25).as("test data").contains("监督行为规范的管理");
		//Click on 3rd collapsible for 3.2.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.2.5 question
		String q345 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		System.out.println(q345);
		softly.assertThat(q345).as("test data").contains("[3.2.5] 组长对团队缺点认识不足，缺乏相应弥补措施");
		//Click on 3.2.5 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).getText();
		System.out.println(ev5);
		softly.assertThat(ev5).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Evidence entry place holder
		String ph5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-4"))).getAttribute("placeholder");
		System.out.println(ph5);
		softly.assertThat(ph5).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Click on 3.2.5 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		//2nd collapsible for 3.2.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c18);
		softly.assertThat(c18).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.2.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c19);
		softly.assertThat(c19).as("test data").contains("访谈同事？");
		//Click on 2nd collapsible for 3.2.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.2.5
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c20);
		softly.assertThat(c20).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.2.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c21);
		softly.assertThat(c21).as("test data").contains("监督管理方面的培训");
		String c24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c24);
		softly.assertThat(c24).as("test data").contains("监督行为规范的管理");
		//Click on 3rd collapsible for 3.2.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.2.6 question
		String q396 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).getText();
		System.out.println(q396);
		softly.assertThat(q396).as("test data").contains("[3.2.6] 组长发出指令和后续贯彻的沟通及协调能力不足");
		//Click on 3.2.6 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).getText();
		System.out.println(ev6);
		softly.assertThat(ev6).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).click();
		//Evidence entry place holder
		String ph6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-5"))).getAttribute("placeholder");
		System.out.println(ph6);
		softly.assertThat(ph6).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).click();
		//Click on 3.2.6 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).click();
		//2nd collapsible for 3.2.6
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c15);
		softly.assertThat(c15).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.2.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c28);
		softly.assertThat(c28).as("test data").contains("访谈下属？");
		//Click on 2nd collapsible for 3.2.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.2.6
		String c30 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c30);
		softly.assertThat(c30).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.2.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c31 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c31);
		softly.assertThat(c31).as("test data").contains("监督管理方面的培训");
		String c32 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c32);
		softly.assertThat(c32).as("test data").contains("监督行为规范的管理");
		//Click on 3rd collapsible for 3.2.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Add new contributing factor button
		String c33 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-button"))).getText();
		System.out.println(c33);
		softly.assertThat(c33).as("test data").contains("新增促成因素");
	}
	
	public void chineseStepOneq19 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.9 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(q11);
		softly.assertThat(q11).as("test data").contains("[1.9] 犯错者在事后是否有经组长或管理层问责？");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();
		System.out.println(reason);
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("这个问题探讨了现有的问责机制。如果出现失误，无论是无意或有意的，都可从中学习到经验教训。问责机制不表示要接受惩罚，而是针对失误负责任。如果主管或管理层没有与犯错人员交谈，且没有完成全面调查，那么说明问责机制存在问题。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(ans1);
		softly.assertThat(ans1).as("test data").contains("没有");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(ans2);
		softly.assertThat(ans2).as("test data").contains("有");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(ans3);
		softly.assertThat(ans3).as("test data").contains("未知");
	}
	
	public void chineseStepOneL311 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("工作问责");
		softly.assertThat(heading).as("test data").contains("不充分");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		System.out.println(textD);
		softly.assertThat(textD).as("test data").contains("若不适用点选skip略过。使用者可于底部新增促成因素。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("问责机制系指业主对制度绩效负责的机制。缺乏问责机制是否是发生这种失误的促成因素？");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.11.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(q341);
		softly.assertThat(q341).as("test data").contains("[3.11.1] 绩效跟踪与趋势分析(PM&T)以及给员工的反馈不到位");
		//Click on 3.11.1 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).getText();
		System.out.println(ev1);
		softly.assertThat(ev1).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Evidence entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-0"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Click on 3.11.1 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//2nd collapsible for 3.11.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c1);
		softly.assertThat(c1).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.11.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c2);
		softly.assertThat(c2).as("test data").contains("向员工反馈绩效趋势结果？");
		//Click on 2nd collapsible for 3.11.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.11.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c10);
		softly.assertThat(c10).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.11.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c3);
		softly.assertThat(c3).as("test data").contains("完善趋势分析体系");
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c22);
		softly.assertThat(c22).as("test data").contains("完善趋势反馈");
		//Click on 3rd collapsible for 3.11.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.11.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(q342);
		softly.assertThat(q342).as("test data").contains("[3.11.2] 即时反馈和持续强化(IF&CR)的管理技能不到位");
		//Click on 3.11.2 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).getText();
		System.out.println(ev2);
		softly.assertThat(ev2).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Evidence entry place holder
		String ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-1"))).getAttribute("placeholder");
		System.out.println(ph2);
		softly.assertThat(ph2).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Click on 3.11.2 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//2nd collapsible for 3.11.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c4);
		softly.assertThat(c4).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.11.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c5);
		softly.assertThat(c5).as("test data").contains("花在现场观察和监督工作的时间是否足够？");
		String c23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c23);
		softly.assertThat(c23).as("test data").contains("标准的持续强化？");
		String c24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();
		System.out.println(c24);
		softly.assertThat(c24).as("test data").contains("观察到偏差时，是否及时反馈？");
		String c27 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[4]"))).getText();
		System.out.println(c27);
		softly.assertThat(c27).as("test data").contains("正面反馈多余负面反馈？");
		//Click on 2nd collapsible for 3.11.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.11.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c11);
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.11.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c6);
		softly.assertThat(c6).as("test data").contains("提高主管人员的问责意识");
		String c28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c28);
		softly.assertThat(c28).as("test data").contains("改善关于管理技能的培训");
		//Click on 3rd collapsible for 3.11.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.11.3 question
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(q343);
		softly.assertThat(q343).as("test data").contains("[3.11.3] 用于绩效控制的奖惩制度不到位");
		//Click on 3.11.3 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).getText();
		System.out.println(ev3);
		softly.assertThat(ev3).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Evidence entry place holder
		String ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-2"))).getAttribute("placeholder");
		System.out.println(ph3);
		softly.assertThat(ph3).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Click on 3.11.3 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//2nd collapsible for 3.11.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c7);
		softly.assertThat(c7).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.11.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c8);
		softly.assertThat(c8).as("test data").contains("奖惩制度是否及时？");
		String c25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c25);
		softly.assertThat(c25).as("test data").contains("奖惩制度是否公平？");
		String c29 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();
		System.out.println(c29);
		softly.assertThat(c29).as("test data").contains("奖惩制度是否坚定？");
		//Click on 2nd collapsible for 3.11.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.11.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c12);
		softly.assertThat(c12).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.11.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		System.out.println(c9);
		softly.assertThat(c9).as("test data").contains("完善奖惩制度");
		//Click on 3rd collapsible for 3.11.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.11.4 question
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		System.out.println(q344);
		softly.assertThat(q344).as("test data").contains("[3.11.4] 问题报告、RCA和纠正行动不到位，给员工的反馈不到位");
		//Click on 3.11.4 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).getText();
		System.out.println(ev4);
		softly.assertThat(ev4).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Evidence entry place holder
		String ph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-3"))).getAttribute("placeholder");
		System.out.println(ph4);
		softly.assertThat(ph4).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Click on 3.11.4 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		//2nd collapsible for 3.11.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c13);
		softly.assertThat(c13).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.11.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c14);
		softly.assertThat(c14).as("test data").contains("核实汇报分析的小事件数量比例以及受伤数量(<10)？");
		//Click on 2nd collapsible for 3.11.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.11.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c16);
		softly.assertThat(c16).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.11.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c17);
		softly.assertThat(c17).as("test data").contains("在问题报告政策中要求包含一切问题和及时性");
		String c26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c26);
		softly.assertThat(c26).as("test data").contains("RCA培训和授权");
		String c30 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[3]"))).getText();
		System.out.println(c30);
		softly.assertThat(c30).as("test data").contains("改善对RCA结果的反馈");
		//Click on 3rd collapsible for 3.11.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.11.5 question
		String q345 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		System.out.println(q345);
		softly.assertThat(q345).as("test data").contains("[3.11.5] 现场观察不充分，给员工的反馈不到位");
		//Click on 3.11.5 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).getText();
		System.out.println(ev5);
		softly.assertThat(ev5).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Evidence entry place holder
		String ph5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-4"))).getAttribute("placeholder");
		System.out.println(ph5);
		softly.assertThat(ph5).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Click on 3.11.5 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		//2nd collapsible for 3.11.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c18);
		softly.assertThat(c18).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.11.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c19);
		softly.assertThat(c19).as("test data").contains("各部门均建立了现场观察指导制度？");
		String c31 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c31);
		softly.assertThat(c31).as("test data").contains("对过去现场观察指导结果的有效性审查？");
		String c32 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();
		System.out.println(c32);
		softly.assertThat(c32).as("test data").contains("花在现场观察指导上的时间？");
		//Click on 2nd collapsible for 3.11.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.11.5
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c20);
		softly.assertThat(c20).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.11.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c21);
		softly.assertThat(c21).as("test data").contains("针对现场观察结果，改善给员工的反馈");
		String c33 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c33);
		softly.assertThat(c33).as("test data").contains("改进现场观察员的制度和TQA");
		//Click on 3rd collapsible for 3.11.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Add new contributing factor button
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-button"))).getText();
		System.out.println(c15);
		softly.assertThat(c15).as("test data").contains("新增促成因素");
	}
	
	public void chineseStepOneL310 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("资格授权");
		softly.assertThat(heading).as("test data").contains("不充分");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		System.out.println(textD);
		softly.assertThat(textD).as("test data").contains("若不适用点选skip略过。使用者可于底部新增促成因素。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("授权是对所学技能和影响安全或生产的关键工作能力的证明（如电厂操纵员、审查人员、经理等）");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.10.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(q341);
		softly.assertThat(q341).as("test data").contains("[3.10.1] 关键岗位员工的作业授权不充分");
		//Click on 3.10.1 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).getText();
		System.out.println(ev1);
		softly.assertThat(ev1).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Evidence entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-0"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Click on 3.10.1 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//2nd collapsible for 3.10.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c1);
		softly.assertThat(c1).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.10.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c2);
		softly.assertThat(c2).as("test data").contains("授权政策和证书？");
		//Click on 2nd collapsible for 3.10.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.10.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c10);
		softly.assertThat(c10).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.10.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		System.out.println(c3);
		softly.assertThat(c3).as("test data").contains("完善作业授权");
		//Click on 3rd collapsible for 3.10.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.10.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(q342);
		softly.assertThat(q342).as("test data").contains("[3.10.2] 关键岗位主管和（或）经理授权不充分");
		//Click on 3.10.2 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).getText();
		System.out.println(ev2);
		softly.assertThat(ev2).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Evidence entry place holder
		String ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-1"))).getAttribute("placeholder");
		System.out.println(ph2);
		softly.assertThat(ph2).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Click on 3.10.2 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//2nd collapsible for 3.10.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c4);
		softly.assertThat(c4).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.10.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c5);
		softly.assertThat(c5).as("test data").contains("授权政策和证书？");
		//Click on 2nd collapsible for 3.10.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.10.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c11);
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.10.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		System.out.println(c6);
		softly.assertThat(c6).as("test data").contains("完善主管和经理的岗位授权");
		//Click on 3rd collapsible for 3.10.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.10.3 question
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(q343);
		softly.assertThat(q343).as("test data").contains("[3.10.3] 供应商服务（QA/RC、来源检查）授权不充分");
		//Click on 3.10.3 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).getText();
		System.out.println(ev3);
		softly.assertThat(ev3).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Evidence entry place holder
		String ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-2"))).getAttribute("placeholder");
		System.out.println(ph3);
		softly.assertThat(ph3).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Click on 3.10.3 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//2nd collapsible for 3.10.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c7);
		softly.assertThat(c7).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.10.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c8);
		softly.assertThat(c8).as("test data").contains("授权政策和证书？");
		//Click on 2nd collapsible for 3.10.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.10.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c12);
		softly.assertThat(c12).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.10.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		System.out.println(c9);
		softly.assertThat(c9).as("test data").contains("完善供应商控制制度");
		//Click on 3rd collapsible for 3.10.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.10.4 question
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		System.out.println(q344);
		softly.assertThat(q344).as("test data").contains("[3.10.4] 现场供应商人员授权不充分");
		//Click on 3.10.4 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).getText();
		System.out.println(ev4);
		softly.assertThat(ev4).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Evidence entry place holder
		String ph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-3"))).getAttribute("placeholder");
		System.out.println(ph4);
		softly.assertThat(ph4).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Click on 3.10.4 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		//2nd collapsible for 3.10.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c13);
		softly.assertThat(c13).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.10.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c14);
		softly.assertThat(c14).as("test data").contains("授权政策和证书？");
		//Click on 2nd collapsible for 3.10.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.4.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c16);
		softly.assertThat(c16).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.10.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		System.out.println(c17);
		softly.assertThat(c17).as("test data").contains("完善供应商控制制度");
		//Click on 3rd collapsible for 3.10.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.10.5 question
		String q345 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		System.out.println(q345);
		softly.assertThat(q345).as("test data").contains("[3.10.5] 培训教员授权不充分");
		//Click on 3.10.5 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).getText();
		System.out.println(ev5);
		softly.assertThat(ev5).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Evidence entry place holder
		String ph5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-4"))).getAttribute("placeholder");
		System.out.println(ph5);
		softly.assertThat(ph5).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Click on 3.10.5 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		//2nd collapsible for 3.10.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c18);
		softly.assertThat(c18).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.10.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c19);
		softly.assertThat(c19).as("test data").contains("授权政策和证书？");
		//Click on 2nd collapsible for 3.10.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.10.5
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c20);
		softly.assertThat(c20).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.10.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		System.out.println(c21);
		softly.assertThat(c21).as("test data").contains("完善有关培训教员资格授权的管理标准与方针");
		//Click on 3rd collapsible for 3.10.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Add new contributing factor button
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-button"))).getText();
		System.out.println(c22);
		softly.assertThat(c22).as("test data").contains("新增促成因素");
	}
	
	public void chineseStepOneL39 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("培训");
		softly.assertThat(heading).as("test data").contains("不充分");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		System.out.println(textD);
		softly.assertThat(textD).as("test data").contains("若不适用点选skip略过。使用者可于底部新增促成因素。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("若培训不充分导致失误发生，需要探讨是培训范围和内容还是实际教学出问题。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.9.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(q341);
		softly.assertThat(q341).as("test data").contains("[3.9.1] 培训材料在适用性、及时性或实用性方面有所欠缺");
		//Click on 3.9.1 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).getText();
		System.out.println(ev1);
		softly.assertThat(ev1).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Evidence entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-0"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Click on 3.9.1 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//2nd collapsible for 3.9.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c1);
		softly.assertThat(c1).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.9.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c2);
		softly.assertThat(c2).as("test data").contains("与类似组织对标？");
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c22);
		softly.assertThat(c22).as("test data").contains("通过现场观察审查培训效果？");
		//Click on 2nd collapsible for 3.9.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.9.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c10);
		softly.assertThat(c10).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.9.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c3);
		softly.assertThat(c3).as("test data").contains("加强培训资源");
		String c27 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c27);
		softly.assertThat(c27).as("test data").contains("开展作业任务分析，从而使培训材料、课程及时间与员工执行的任务相匹配");
		//Click on 3rd collapsible for 3.9.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.9.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(q342);
		softly.assertThat(q342).as("test data").contains("[3.9.2] 复训频率不高(>> 一年)");
		//Click on 3.9.2 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).getText();
		System.out.println(ev2);
		softly.assertThat(ev2).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Evidence entry place holder
		String ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-1"))).getAttribute("placeholder");
		System.out.println(ph2);
		softly.assertThat(ph2).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Click on 3.9.2 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//2nd collapsible for 3.9.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c4);
		softly.assertThat(c4).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.9.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c5);
		softly.assertThat(c5).as("test data").contains("复训频率是否是根据复杂程度和使用频率来确定的？");
		String c23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c23);
		softly.assertThat(c23).as("test data").contains("复训的形式？");
		//Click on 2nd collapsible for 3.9.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.9.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c11);
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.9.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		System.out.println(c6);
		softly.assertThat(c6).as("test data").contains("增加复训频率，改善复训形式");
		//Click on 3rd collapsible for 3.9.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.9.3 question
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(q343);
		softly.assertThat(q343).as("test data").contains("[3.9.3] 部门管理层未充分参与培训材料的编写和培训的实施");
		//Click on 3.9.3 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).getText();
		System.out.println(ev3);
		softly.assertThat(ev3).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Evidence entry place holder
		String ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-2"))).getAttribute("placeholder");
		System.out.println(ph3);
		softly.assertThat(ph3).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Click on 3.9.3 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//2nd collapsible for 3.9.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c7);
		softly.assertThat(c7).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.9.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c8);
		softly.assertThat(c8).as("test data").contains("部门经理审查关于培训材料的意见？");
		String c25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c25);
		softly.assertThat(c25).as("test data").contains("部门经理监督对上课情况？");
		//Click on 2nd collapsible for 3.9.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.9.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c12);
		softly.assertThat(c12).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.9.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		System.out.println(c9);
		softly.assertThat(c9).as("test data").contains("完善关于管理层参与培训材料编写或培训实施的相关要求");
		//Click on 3rd collapsible for 3.9.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.9.4 question
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		System.out.println(q344);
		softly.assertThat(q344).as("test data").contains("[3.9.4] 未将经验教训充分包含到培训中");
		//Click on 3.9.4 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).getText();
		System.out.println(ev4);
		softly.assertThat(ev4).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Evidence entry place holder
		String ph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-3"))).getAttribute("placeholder");
		System.out.println(ph4);
		softly.assertThat(ph4).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Click on 3.9.4 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		//2nd collapsible for 3.9.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c13);
		softly.assertThat(c13).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.9.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c14);
		softly.assertThat(c14).as("test data").contains("审查对以往事件根本原因和共同原因的调查情况（从屏障、失误陷阱等角度）？");
		//Click on 2nd collapsible for 3.9.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.9.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c16);
		softly.assertThat(c16).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.9.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		System.out.println(c17);
		softly.assertThat(c17).as("test data").contains("提高对培训效果的审查");
		//Click on 3rd collapsible for 3.9.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.9.5 question
		String q345 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		System.out.println(q345);
		softly.assertThat(q345).as("test data").contains("[3.9.5] 所需培训开展不充分（脱岗）");
		//Click on 3.9.5 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).getText();
		System.out.println(ev5);
		softly.assertThat(ev5).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Evidence entry place holder
		String ph5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-4"))).getAttribute("placeholder");
		System.out.println(ph5);
		softly.assertThat(ph5).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Click on 3.9.5 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		//2nd collapsible for 3.9.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c18);
		softly.assertThat(c18).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.9.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c19);
		softly.assertThat(c19).as("test data").contains("培训签到表，%员工接受了培训？");
		String c24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c24);
		softly.assertThat(c24).as("test data").contains("现场承包商没有经过培训？");
		//Click on 2nd collapsible for 3.9.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.9.5
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c20);
		softly.assertThat(c20).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.9.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c21);
		softly.assertThat(c21).as("test data").contains("完善承包商控制方针");
		String c26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c26);
		softly.assertThat(c26).as("test data").contains("完善培训资源");
		//Click on 3rd collapsible for 3.9.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.9.6 question
		String q396 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).getText();
		System.out.println(q396);
		softly.assertThat(q396).as("test data").contains("[3.9.6] 所需培训开展不充分（在岗）");
		//Click on 3.9.6 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).getText();
		System.out.println(ev6);
		softly.assertThat(ev6).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).click();
		//Evidence entry place holder
		String ph6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-5"))).getAttribute("placeholder");
		System.out.println(ph6);
		softly.assertThat(ph6).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).click();
		//Click on 3.9.6 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).click();
		//2nd collapsible for 3.9.6
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c15);
		softly.assertThat(c15).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.9.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c28);
		softly.assertThat(c28).as("test data").contains("在岗培训方针？");
		String c29 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c29);
		softly.assertThat(c29).as("test data").contains("经验不足的员工没有经过培训？");
		//Click on 2nd collapsible for 3.9.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.9.6
		String c30 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c30);
		softly.assertThat(c30).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.9.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c31 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c31);
		softly.assertThat(c31).as("test data").contains("完善在岗培训方针");
		String c32 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c32);
		softly.assertThat(c32).as("test data").contains("完善培训资源");
		//Click on 3rd collapsible for 3.9.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Add new contributing factor button
		String c33 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-button"))).getText();
		System.out.println(c33);
		softly.assertThat(c33).as("test data").contains("新增促成因素");
	}
	
	public void chineseStepOneq18 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.8 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(q11);
		softly.assertThat(q11).as("test data").contains("[1.8] 犯错人员是否受过培训知道如何管理易出错精神状态和高风险");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();
		System.out.println(reason);
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("这个问题探讨了犯错人员是否知晓需提前准备避免易出错精神状态或高风险状态促成的个人失误。如果没有，需要进行培训。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(ans1);
		softly.assertThat(ans1).as("test data").contains("没有");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(ans2);
		softly.assertThat(ans2).as("test data").contains("有，但超过两年了");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(ans3);
		softly.assertThat(ans3).as("test data").contains("两年内受过培训");
	}
	
	public void chineseStepOneq17 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.7 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(q11);
		softly.assertThat(q11).as("test data").contains("[1.7] 这个错误是否可以透过自检或独立检查避免");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();
		System.out.println(reason);
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("执行独立检查的程序步骤或自我检查可以以保证执行工作者的正确性。可在行动前执行独立检查（监护制），或在行动结束后执行独立验证。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(ans1);
		softly.assertThat(ans1).as("test data").contains("不能");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(ans2);
		softly.assertThat(ans2).as("test data").contains("能，程序有规定但未执行");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(ans3);
		softly.assertThat(ans3).as("test data").contains("能，但程序未规定");
	}
	
	public void chineseStepOneL315 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("同事互助提醒（好文化）");
		softly.assertThat(heading).as("test data").contains("不充分的促成因素");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		System.out.println(textD);
		softly.assertThat(textD).as("test data").contains("若不适用点选skip略过。使用者可于底部新增促成因素。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("缺乏同事互助提醒是否是这个失误的促成因素？如果是，同事互助提醒为什么会缺乏或无效？同事互助（好文化）是指互相指导或协助，帮助对方免受受害或违反规则。只有在同事互助按照制度标准建立、工作人员经过培训且对指导对方负责的情况下，同事互助才有效。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.15.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(q341);
		softly.assertThat(q341).as("test data").contains("[3.15.1] 员工未经过相互指导的培训，或纠正他人违规情况的培训");
		//Click on 3.15.1 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).getText();
		System.out.println(ev1);
		softly.assertThat(ev1).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Evidence entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-0"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Click on 3.15.1 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//2nd collapsible for 3.15.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c1);
		softly.assertThat(c1).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.15.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c2);
		softly.assertThat(c2).as("test data").contains("审查相关培训？");
		//Click on 2nd collapsible for 3.15.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.15.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c10);
		softly.assertThat(c10).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.15.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		System.out.println(c3);
		softly.assertThat(c3).as("test data").contains("同事互助提醒（好文化）培训");
		//Click on 3rd collapsible for 3.15.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.15.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(q342);
		softly.assertThat(q342).as("test data").contains("[3.15.2] 未要求员工对纠正他人违规的情况承担责任");
		//Click on 3.15.2 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).getText();
		System.out.println(ev2);
		softly.assertThat(ev2).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Evidence entry place holder
		String ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-1"))).getAttribute("placeholder");
		System.out.println(ph2);
		softly.assertThat(ph2).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Click on 3.15.2 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//2nd collapsible for 3.15.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c4);
		softly.assertThat(c4).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.15.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c5);
		softly.assertThat(c5).as("test data").contains("审查关于同事互助提醒（好文化）的管理期望和标准？");
		//Click on 2nd collapsible for 3.15.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.15.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c11);
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.15.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		System.out.println(c6);
		softly.assertThat(c6).as("test data").contains("建立关于同事互助提醒（好文化）的管理期望");
		//Click on 3rd collapsible for 3.15.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.15.3 question
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(q343);
		softly.assertThat(q343).as("test data").contains("[3.15.3] 员工未充分理解相关行为规范");
		//Click on 3.15.3 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).getText();
		System.out.println(ev3);
		softly.assertThat(ev3).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Evidence entry place holder
		String ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-2"))).getAttribute("placeholder");
		System.out.println(ph3);
		softly.assertThat(ph3).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Click on 3.15.3 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//2nd collapsible for 3.15.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c7);
		softly.assertThat(c7).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.15.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c8);
		softly.assertThat(c8).as("test data").contains("观察工前会和工作的执行，以了解对行为规范的管理强化情况？");
		//Click on 2nd collapsible for 3.15.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.15.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c12);
		softly.assertThat(c12).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.15.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c9);
		softly.assertThat(c9).as("test data").contains("行为规范培训");
		String c23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c23);
		softly.assertThat(c23).as("test data").contains("采用行为规范提醒物");
		String c24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[3]"))).getText();
		System.out.println(c24);
		softly.assertThat(c24).as("test data").contains("采用禁止事项警告清单");
		//Click on 3rd collapsible for 3.15.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.18.4 question
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		System.out.println(q344);
		softly.assertThat(q344).as("test data").contains("[3.15.4] 主管未到现场强化");
		softly.assertThat(q344).as("test data").contains("同事指导");
		//Click on 3.15.4 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).getText();
		System.out.println(ev4);
		softly.assertThat(ev4).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Evidence entry place holder
		String ph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-3"))).getAttribute("placeholder");
		System.out.println(ph4);
		softly.assertThat(ph4).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Click on 3.15.4 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		//2nd collapsible for 3.15.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c13);
		softly.assertThat(c13).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.15.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c14);
		softly.assertThat(c14).as("test data").contains("观察工前会和工作的执行，以了解对行为规范的管理强化情况？");
		//Click on 2nd collapsible for 3.15.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.15.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c16);
		softly.assertThat(c16).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.15.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c17);
		softly.assertThat(c17).as("test data").contains("监督管理能力培训");
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c15);
		softly.assertThat(c15).as("test data").contains("就监督管理强化，对管理者实施问责");
		//Click on 3rd collapsible for 3.15.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Add new contributing factor button
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-button"))).getText();
		System.out.println(c22);
		softly.assertThat(c22).as("test data").contains("新增促成因素");
	}
	
	public void chineseStepOneq16 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.6 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(q11);
		softly.assertThat(q11).as("test data").contains("[1.6] 犯错者违规时是否有旁人观看");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();
		System.out.println(reason);
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("这个问题是评估公司/组织文化。如果有许多工作人员目睹犯错者的失误行为却没有认加以干预，这是一个文化和管理问题，需制定标准和问责机制。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(ans1);
		softly.assertThat(ans1).as("test data").contains("有");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(ans2);
		softly.assertThat(ans2).as("test data").contains("没有");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(ans3);
		softly.assertThat(ans3).as("test data").contains("未知");
	}
	
	public void chineseStepOneL318 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("知识型错误");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		System.out.println(textD);
		softly.assertThat(textD).as("test data").contains("若不适用点选skip略过。使用者可于底部新增促成因素。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("是否有证据表明以下思维模式促使犯错人员在本失误中的判断错误？");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.18.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(q341);
		softly.assertThat(q341).as("test data").contains("[3.18.1] 盲目信任: 关键信息使用质疑的态度QV&V℠不到位");
		//Click on 3.18.1 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).getText();
		System.out.println(ev1);
		softly.assertThat(ev1).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Evidence entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-0"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Click on 3.18.1 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//2nd collapsible for 3.18.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c1);
		softly.assertThat(c1).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.18.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c2);
		softly.assertThat(c2).as("test data").contains("审查培训材料？");
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c22);
		softly.assertThat(c22).as("test data").contains("审查以往类似事件？");
		//Click on 2nd collapsible for 3.18.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.18.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c10);
		softly.assertThat(c10).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.18.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		System.out.println(c3);
		softly.assertThat(c3).as("test data").contains("提高质疑的态度");
		softly.assertThat(c3).as("test data").contains("培训");
		//Click on 3rd collapsible for 3.18.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.4.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(q342);
		softly.assertThat(q342).as("test data").contains("[3.18.2] 过度自信: (1) 高估自我效能; (2) 未意识到影响变化; (3) 未寻求他人智慧; (4) 没有从过去中学习; (5) 缺少屏障预防错误发生");
		//Click on 3.18.2 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).getText();
		System.out.println(ev2);
		softly.assertThat(ev2).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Evidence entry place holder
		String ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-1"))).getAttribute("placeholder");
		System.out.println(ph2);
		softly.assertThat(ph2).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Click on 3.18.2 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//2nd collapsible for 3.18.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c4);
		softly.assertThat(c4).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.18.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c5);
		softly.assertThat(c5).as("test data").contains("执行首次执行的任务而没有仔细规划?");
		String c23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c23);
		softly.assertThat(c23).as("test data").contains("过去有过超出能力工作的事件?");
		String c24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();
		System.out.println(c24);
		softly.assertThat(c24).as("test data").contains("对设计工作推断不当而未执行适当试验?");
		//Click on 2nd collapsible for 3.18.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.18.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c11);
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.18.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		System.out.println(c6);
		softly.assertThat(c6).as("test data").contains("行为培训，避免过度自信");
		//Click on 3rd collapsible for 3.18.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.18.3 question
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(q343);
		softly.assertThat(q343).as("test data").contains("[3.18.3] 眼不见心不想: (1) 对低概率/高风险事件的风险控制不到位; (2) 忽略与绩效指标或激励无关的问题; (3) 因忽略相关风险而未设置屏障");
		//Click on 3.18.3 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).getText();
		System.out.println(ev3);
		softly.assertThat(ev3).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Evidence entry place holder
		String ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-2"))).getAttribute("placeholder");
		System.out.println(ph3);
		softly.assertThat(ph3).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Click on 3.18.3 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//2nd collapsible for 3.18.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c7);
		softly.assertThat(c7).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.18.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c8);
		softly.assertThat(c8).as("test data").contains("因忽略相关风险而未设置屏障");
		String c25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c25);
		softly.assertThat(c25).as("test data").contains("审查管理监督或项目委员会会议纪要?");
		//Click on 2nd collapsible for 3.18.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.18.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c12);
		softly.assertThat(c12).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.18.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		System.out.println(c9);
		softly.assertThat(c9).as("test data").contains("改善风险控制项目");
		String c26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		System.out.println(c26);
		softly.assertThat(c26).as("test data").contains("完善");
		softly.assertThat(c26).as("test data").contains("体系");
		//Click on 3rd collapsible for 3.18.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.18.4 question
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		System.out.println(q344);
		softly.assertThat(q344).as("test data").contains("[3.18.4] 未能及时止损: (1) 因自满和（或）无知，捍卫过去错误的决定或犹豫不决; (2) 期望通过重复同样的问题处理方法、标准或策略来实现不同的结果");
		//Click on 3.18.4 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).getText();
		System.out.println(ev4);
		softly.assertThat(ev4).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Evidence entry place holder
		String ph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-3"))).getAttribute("placeholder");
		System.out.println(ph4);
		softly.assertThat(ph4).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Click on 3.18.4 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		//2nd collapsible for 3.18.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c13);
		softly.assertThat(c13).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.18.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c14);
		softly.assertThat(c14).as("test data").contains("审查管理监督或项目委员会会议纪要?");
		//Click on 2nd collapsible for 3.18.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.18.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c16);
		softly.assertThat(c16).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.18.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		System.out.println(c17);
		softly.assertThat(c17).as("test data").contains("审查以往决策的有效性，提高管理监督");
		//Click on 3rd collapsible for 3.18.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.18.5 question
		String q345 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		System.out.println(q345);
		softly.assertThat(q345).as("test data").contains("[3.18.5] 陷入两选一的陷阱: 决策、问题解决或计划不充分，未能确保全面考虑多个选择方案进行分析");
		//Click on 3.18.5 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).getText();
		System.out.println(ev5);
		softly.assertThat(ev5).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Evidence entry place holder
		String ph5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-4"))).getAttribute("placeholder");
		System.out.println(ph5);
		softly.assertThat(ph5).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Click on 3.18.5 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		//2nd collapsible for 3.18.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c18);
		softly.assertThat(c18).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.18.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c19);
		softly.assertThat(c19).as("test data").contains("审查管理监督或项目委员会会议纪要?");
		//Click on 2nd collapsible for 3.18.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.18.5
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c20);
		softly.assertThat(c20).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.18.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		System.out.println(c21);
		softly.assertThat(c21).as("test data").contains("提高决策、问题解决和计划的结构（委员会）和流程");
		//Click on 3rd collapsible for 3.18.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Add new contributing factor button
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-button"))).getText();
		System.out.println(c15);
		softly.assertThat(c15).as("test data").contains("新增促成因素");
	}
	
	public void chineseStepOneL34 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("关键思考和关键追问不充分");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		System.out.println(textD);
		softly.assertThat(textD).as("test data").contains("若不适用点选skip略过。使用者可于底部新增促成因素。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		System.out.println(desc);
		softly.assertThat(desc).as("test data").contains("是否多次遇到过这样的情况：如果花时间进行关键思考或关键追问，本来可以缓解失误？关键思考指的是省思如何让一天或一项任务获得成功；包括检查个人和他人的精神状态或检查程序问题。关键追问指的是探讨准备工作是否足以取得成功；包括澄清任何未知情况。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.4.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(q341);
		softly.assertThat(q341).as("test data").contains("[3.4.1] 采取行动前没有思考如何规划（如优先顺序、机会、沟通、时间管理等）");
		//Click on 3.4.1 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).getText();
		System.out.println(ev1);
		softly.assertThat(ev1).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Evidence entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-0"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Click on 3.4.1 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//2nd collapsible for 3.4.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c1);
		softly.assertThat(c1).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.4.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c2);
		softly.assertThat(c2).as("test data").contains("访谈犯错者");
		//Click on 2nd collapsible for 3.4.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.4.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c10);
		softly.assertThat(c10).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.4.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		System.out.println(c3);
		softly.assertThat(c3).as("test data").contains("开展关键思考和关键追问方面的培训");
		//Click on 3rd collapsible for 3.4.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.4.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(q342);
		softly.assertThat(q342).as("test data").contains("[3.4.2] 采取行动前没有考虑易出错的心理状况");
		//Click on 3.4.2 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).getText();
		System.out.println(ev2);
		softly.assertThat(ev2).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Evidence entry place holder
		String ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-1"))).getAttribute("placeholder");
		System.out.println(ph2);
		softly.assertThat(ph2).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Click on 3.4.2 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//2nd collapsible for 3.4.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c4);
		softly.assertThat(c4).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.4.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c5);
		softly.assertThat(c5).as("test data").contains("访谈犯错者");
		//Click on 2nd collapsible for 3.4.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.4.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c11);
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.4.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		System.out.println(c6);
		softly.assertThat(c6).as("test data").contains("开展关键思考和关键追问方面的培训");
		//Click on 3rd collapsible for 3.4.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.4.3 question
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(q343);
		softly.assertThat(q343).as("test data").contains("[3.4.3] 采取行动前没有考虑高风险情境（如单项弱点）");
		//Click on 3.4.3 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).getText();
		System.out.println(ev3);
		softly.assertThat(ev3).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Evidence entry place holder
		String ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-2"))).getAttribute("placeholder");
		System.out.println(ph3);
		softly.assertThat(ph3).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Click on 3.4.3 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//2nd collapsible for 3.4.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c7);
		softly.assertThat(c7).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.4.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c8);
		softly.assertThat(c8).as("test data").contains("访谈犯错者");
		//Click on 2nd collapsible for 3.4.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.4.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c12);
		softly.assertThat(c12).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.4.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		System.out.println(c9);
		softly.assertThat(c9).as("test data").contains("开展关键思考和关键追问方面的培训");
		//Click on 3rd collapsible for 3.4.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.4.4 question
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		System.out.println(q344);
		softly.assertThat(q344).as("test data").contains("[3.4.4] 感到疑惑时质疑不充分");
		//Click on 3.4.4 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).getText();
		System.out.println(ev4);
		softly.assertThat(ev4).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Evidence entry place holder
		String ph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-3"))).getAttribute("placeholder");
		System.out.println(ph4);
		softly.assertThat(ph4).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Click on 3.4.4 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).click();
		//2nd collapsible for 3.4.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c13);
		softly.assertThat(c13).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.4.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		System.out.println(c14);
		softly.assertThat(c14).as("test data").contains("访谈犯错者");
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		System.out.println(c15);
		softly.assertThat(c15).as("test data").contains("访谈主管");
		//Click on 2nd collapsible for 3.4.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.4.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c16);
		softly.assertThat(c16).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.4.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		System.out.println(c17);
		softly.assertThat(c17).as("test data").contains("开展关键思考和关键追问方面的培训");
		//Click on 3rd collapsible for 3.4.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.4.5 question
		String q345 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		System.out.println(q345);
		softly.assertThat(q345).as("test data").contains("[3.4.5] 任务准备过程中质疑不充分");
		//Click on 3.4.5 to reveal evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).getText();
		System.out.println(ev5);
		softly.assertThat(ev5).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Evidence entry place holder
		String ph5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-4"))).getAttribute("placeholder");
		System.out.println(ph5);
		softly.assertThat(ph5).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Click on 3.4.5 to disable evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).click();
		//2nd collapsible for 3.4.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		System.out.println(c18);
		softly.assertThat(c18).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.4.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		System.out.println(c19);
		softly.assertThat(c19).as("test data").contains("访谈犯错者");
		//Click on 2nd collapsible for 3.4.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.4.5
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		System.out.println(c20);
		softly.assertThat(c20).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.4.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		System.out.println(c21);
		softly.assertThat(c21).as("test data").contains("开展关键思考和关键追问方面的培训");
		//Click on 3rd collapsible for 3.4.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Add new contributing factor button
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-button"))).getText();
		System.out.println(c22);
		softly.assertThat(c22).as("test data").contains("新增促成因素");
	}
	
	public void chineseStepOneq12 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.2 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(q11);
		softly.assertThat(q11).as("test data").contains("[1.2] 始发事件的错误类型为何");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();
		System.out.println(reason);
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(ans1);
		softly.assertThat(ans1).as("test data").contains("知识型错误");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(ans2);
		softly.assertThat(ans2).as("test data").contains("规则型错误");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(ans3);
		softly.assertThat(ans3).as("test data").contains("技能型错误");
	}
	
	public void chineseStepOneq11 (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.1 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(q11);
		softly.assertThat(q11).as("test data").contains("[1.1] 始发事件为人因、设备失效还是天灾");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();
		System.out.println(reason);
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");
		System.out.println(ph1);
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		System.out.println(ans1);
		softly.assertThat(ans1).as("test data").contains("人因");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		System.out.println(ans2);
		softly.assertThat(ans2).as("test data").contains("设备失效");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		System.out.println(ans3);
		softly.assertThat(ans3).as("test data").contains("天灾");
	}
	
	public void chineseEventInfo (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Check if title contains chinese HiRCA
		String hirca_title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		System.out.println(hirca_title);
		softly.assertThat(hirca_title).as("test data").contains(" - 事件信息");
		//Heading of event info page in chinese?
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(heading);
		softly.assertThat(heading).as("test data").contains("输入事件信息");
		//Checks if the textboxes have the correct titles
		//Event title
		String ev_title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-title-label"))).getText();
		System.out.println(ev_title);
		softly.assertThat(ev_title).as("test data").contains("事件名称:");
		//Verify place holder of event title
		String ev_ph = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-title"))).getAttribute("placeholder");
		System.out.println(ev_ph);
		softly.assertThat(ev_ph).as("test data").contains("输入 事件名称");
		//Event id
		String ev_id = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[2]/label"))).getText();
		System.out.println(ev_id);
		softly.assertThat(ev_id).as("test data").contains("事件编号:");
		//Verify place holder of event id
		String ev_ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-crnumber"))).getAttribute("placeholder");
		System.out.println(ev_ph1);
		softly.assertThat(ev_ph1).as("test data").contains("输入 事件编号 (非必填)");
		//Event location
		String loc=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[3]/label"))).getText();
		System.out.println(loc);
		softly.assertThat(loc).as("test data").contains("事件发生地点:");
		//Verify place holder of event location
		String ev_ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-location"))).getAttribute("placeholder");
		System.out.println(ev_ph2);
		softly.assertThat(ev_ph2).as("test data").contains("输入 事件发生地点");
		//Department
		String dept=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[4]/fieldset/div/legend"))).getText();
		System.out.println(dept);
		softly.assertThat(dept).as("test data").contains("部门:");
		//Sub department
		String sub_dept=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[5]/fieldset/div/legend"))).getText();
		System.out.println(sub_dept);
		softly.assertThat(sub_dept).as("test data").contains("组:");
		//Date of event
		String date=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[6]/label"))).getText();
		System.out.println(date);
		softly.assertThat(date).as("test data").contains("事件发生日期:");
		//Time of event
		String time=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[7]/label"))).getText();
		System.out.println(time);
		softly.assertThat(time).as("test data").contains("事件发生时间:");
		//Problem statement
		String prob=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[8]/label"))).getText();
		System.out.println(prob);
		softly.assertThat(prob).as("test data").contains("事件描述:");
		//Verify place holder of problem statement
		String ev_ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-pbstatement"))).getAttribute("placeholder");
		System.out.println(ev_ph3);
		softly.assertThat(ev_ph3).as("test data").contains("输入 事件描述");
		//Executive summary
		String exec=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[9]/label"))).getText();
		System.out.println(exec);
		softly.assertThat(exec).as("test data").contains("报告摘要:");
		//Verify place holder of executive summary
		String ev_ph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-execsummary"))).getAttribute("placeholder");
		System.out.println(ev_ph4);
		softly.assertThat(ev_ph4).as("test data").contains("输入 报告摘要 (非必填)");
		//Timeline of event
		String timeline=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[10]/label"))).getText();
		System.out.println(timeline);
		softly.assertThat(timeline).as("test data").contains("事件详细过程（时序构建）:");
		//Verify place holder of timeline of event
		String ev_ph5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-events"))).getAttribute("placeholder");
		System.out.println(ev_ph5);
		softly.assertThat(ev_ph5).as("test data").contains("输入 事件详细过程（时序构建）");
		//Background information
		String back=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[11]/label"))).getText();
		System.out.println(back);
		softly.assertThat(back).as("test data").contains("相关信息:");
		//Verify place holder of background information
		String ev_ph6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-bginfos"))).getAttribute("placeholder");
		System.out.println(ev_ph6);
		softly.assertThat(ev_ph6).as("test data").contains("输入 相关信息");
		//Supporting file (1)
		String supp1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-fieldcontain-label-0"))).getText();
		System.out.println(supp1);
		softly.assertThat(supp1).as("test data").contains("支援文件 (1):");
		//Header of supporting file
		String supp1_header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-filecollapsible-header-0"))).getText();
		System.out.println(supp1_header);
		softly.assertThat(supp1_header).as("test data").contains("支援文件描述细节");
		//Add new file button
		String newFilebutton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewfile-button"))).getText();
		System.out.println(newFilebutton);
		softly.assertThat(newFilebutton).as("test data").contains("上传另一个档案");
		//Investigators
		String inve=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[14]/label"))).getText();
		System.out.println(inve);
		softly.assertThat(inve).as("test data").contains("事件调查员:");
		//Verify place holder of investigator
		String ev_ph7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-investigators"))).getAttribute("placeholder");
		System.out.println(ev_ph7);
		softly.assertThat(ev_ph7).as("test data").contains("输入 事件调查员");
		//Report creation date
		String repo=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[15]/label"))).getText();
		System.out.println(repo);
		softly.assertThat(repo).as("test data").contains("报告编写时间:");
	}

	
	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}
}
