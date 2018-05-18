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
	SoftAssertions softly = new SoftAssertions();

	public void fillUpHiRCAEventInfo(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Clicks on Analysis 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-a"))).click();
		//Clicks on HiRCA
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-hirca"))).click();
		Thread.sleep(2000);
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
		jse.executeScript("scroll(0,6500)");
		//Clicks on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[16]/div/button"))).click();
		Thread.sleep(2000);
	}
	
	public void bugPathWith3LopsKALE1926(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Click on new for new report
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-new"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		Thread.sleep(2000);
		//Go to KALE homepage
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pii-logo-div-element-kale"))).click();
		fillUpHiRCAEventInfo(driver);
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
		jse.executeScript("scroll(0,1200)");
		Thread.sleep(1000);
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
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))).click();
		}
		//Scroll to the top
		Thread.sleep(2000);
		jse.executeScript("scroll(0,0)");
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
	
	public void bugPathWith2LopsKALE1926(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Click on new for new report
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-new"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		Thread.sleep(2000);
		//Go to KALE homepage
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pii-logo-div-element-kale"))).click();
		fillUpHiRCAEventInfo(driver);
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
		jse.executeScript("scroll(0,1200)");
		Thread.sleep(1000);
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
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))).click();
		}
		//Scroll to the top
		Thread.sleep(2000);
		jse.executeScript("scroll(0,0)");
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
		//Skip 2.22
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		//Verify SUEP Tab appeared
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(s).as("test data").contains("Step 3 - Root Causes Determination Checklist (SUEP");
		//with 3 LOPs
		bugPathWith3LopsKALE1926(driver);
	}
	
	public void select317Random(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Random random = new Random();
		//Choose a number between 0 and 7 for number of selections
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
			  jse.executeScript("scroll(0,1200)");
		  if(y<=5)
			  jse.executeScript("scroll(0,0)");
		  Thread.sleep(1000);
		  //Click on a lop inquiry in 3.17
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))).click();
		}
		Thread.sleep(2000);
		jse.executeScript("scroll(0,0)");
		Thread.sleep(2000);
	}
	
	public void bugPath1KALE1959(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
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
		//Scroll down
		jse.executeScript("scroll(0,1200)");
		Thread.sleep(1000);
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))).click();
		//Scroll to the top
		Thread.sleep(2000);
		jse.executeScript("scroll(0,0)");
		Thread.sleep(2000);
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
		Thread.sleep(2000);
		jse.executeScript("scroll(0,1200)");
		Thread.sleep(2000);
		//Click on same LOP
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))).click();
		//Click on modify
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		//Scroll to the top
		Thread.sleep(2000);
		jse.executeScript("scroll(0,0)");
		Thread.sleep(2000);
		//Make selections from 2.1, 2.2 , 2.9-2.12
		makeSelections(driver);
		//Verify if previous selections there
		previousSelectionVerify(driver);
		//Select 2nd LOP and repeat verification
		select2ndLOP(driver);
		//Create new report
		//Click on new for new report
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-new"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		Thread.sleep(2000);
		//Go to KALE homepage
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pii-logo-div-element-kale"))).click();
		fillUpHiRCAEventInfo(driver);
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
		//Scroll down
		jse.executeScript("scroll(0,1200)");
		Thread.sleep(1000);
		//Select on LOP randomly
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))).click();
		//Scroll to the top
		Thread.sleep(2000);
		jse.executeScript("scroll(0,0)");
		Thread.sleep(2000);
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
		Thread.sleep(2000);
		jse.executeScript("scroll(0,1200)");
		Thread.sleep(2000);
		//Click on same LOP
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))).click();
		//Click on modify
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		//Scroll to the top
		Thread.sleep(2000);
		jse.executeScript("scroll(0,0)");
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
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Click on back
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-back"))).click();
		Thread.sleep(2000);
		//Select 2nd LOP
		//Scroll down
		jse.executeScript("scroll(0,1200)");
		Thread.sleep(1000);
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))).click();
		//Click modify
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		//Scroll to the top
		Thread.sleep(2000);
		jse.executeScript("scroll(0,0)");
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
