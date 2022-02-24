package seleniumTests;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import kaleTestSoftware.EiRCA2;
import kaleTestSoftware.EiRCAPageObj;
import kaleTestSoftware.ErrorMeter3;
import kaleTestSoftware.JobObservation2;
import kaleTestSoftware.JobObservationObj;
import kaleTestSoftware.LoginPageObj;
import kaleTestSoftware.ShareCheck;
import kaleTestSoftware.ShareCheck2;
import kaleTestSoftware.ShareCheck3;

public class CreateMultipleJO {
	EiRCAPageObj eirca = new EiRCAPageObj();
	EiRCA2 eirca2 = new EiRCA2();
	ShareCheck2 share2 = new ShareCheck2();
	ShareCheck share = new ShareCheck();
	ShareCheck3 share3 = new ShareCheck3();
	ErrorMeter3 em3 = new ErrorMeter3 ();
	JobObservation2 jo2 = new JobObservation2();
	JobObservationObj jo = new JobObservationObj();
	LoginPageObj lpo = new LoginPageObj();
	SoftAssertions softly = new SoftAssertions();

	public void reportCreate(WebDriver driver) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		String text = eirca2.textCreate(driver);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on Analysis 
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.AnalysisLink)).click();
		}catch (UnhandledAlertException f){			  
			driver.switchTo().alert().dismiss();
		}
		//Clicks on Job Observation
		wait.until(ExpectedConditions.visibilityOfElementLocated(jo.JobObservationLink)).click();
		Thread.sleep(3000);
		   //Select a date (1st date on 2nd row)
		  jse.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.id("pii-joa-subtitle-select")));
		   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pii-joa-datepicker']/div/div[2]/table/tbody/tr[3]/td[1]/a"))).click();
		   Thread.sleep(2000);
		  //Delete previous report if any
		  for(int i=0;i<5; i++) {
		  try{
			  WebElement reportLinkName= driver.findElement(By.xpath("//a[contains(@pii-obs-i,'"+i+"')]"));
		  if(reportLinkName.isDisplayed())
		  {
			  System.out.println("Yes, previously JO record-"+(i+1)+ "is there");
			    reportLinkName.click();
			    driver.findElement(jo.JODelButton).click();
			    wait.until(ExpectedConditions.visibilityOfElementLocated(jo.JOPopupConfirmButton)).click();
		  }
		  }
		  catch(Exception e)
		  {
		  }
		  }
		  //Select a date (1st date on 2nd row) again
		  jse.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.id("pii-joa-subtitle-select")));
		   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pii-joa-datepicker']/div/div[2]/table/tbody/tr[3]/td[1]/a"))).click();
/////////////////////////////////////////////////////////////	////////////////////////////////////////////////////////////////////	  
		   for(int i=0;i<2;i++) {
		   //Click on Duration To: time picker icon
		   jse.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id='pii-joa-tab-1-duration-to-div']/div/div/a")));
		   Thread.sleep(1000);
		   //Duration To: Set Time Hour: 19:00
		   //Enter hour
			driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div/div/div[2]/input")).sendKeys(Keys.CONTROL,"a");
			driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div/div/div[2]/input")).sendKeys(Keys.DELETE);
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div/div/div[2]/input")).sendKeys("19");
			Thread.sleep(2000);
			//Click on set time
			while(true)
			{
				Thread.sleep(500);
				try{
					driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div[2]/div/a"));
					driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div[2]/div/a")).click();
					driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div[2]/div/a")).click();
				}catch(org.openqa.selenium.NoSuchElementException t)
				{
					break;
				}
			}
			Thread.sleep(4000);
			//Verify 'Number of hours observed' is 19.0
			String numberObserved=driver.findElement(By.xpath("//*[contains(text(),'Number of hours observed: 19.0')]")).getText();
			softly.assertThat(numberObserved).as("test data").contains("19.0");
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
		  //Click on Time of Observation Clock
		   jse.executeScript("arguments[0].scrollIntoView(true);", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-1-observer"))));
		   jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='pii-joa-tab-1-timeofobs-div']//a[contains(.,'Open Date Picker')]"))));
		  //Time of Observation: Set Time Hour: 14:00 
		 //Enter hour
			driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div/div/div[2]/input")).sendKeys(Keys.CONTROL,"a");
			driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div/div/div[2]/input")).sendKeys(Keys.DELETE);
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div/div/div[2]/input")).sendKeys("14");
			Thread.sleep(2000);
			//Click on set time
			while(true)
			{
				Thread.sleep(500);
				try{
					driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div[2]/div/a"));
					driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div[2]/div/a")).click();
				}catch(org.openqa.selenium.NoSuchElementException t)
				{
					break;
				}
			}
			Thread.sleep(500);
		//Fills mandatory details in step1
		jse.executeScript("window.scrollBy(0,-600)");
		driver.findElement(jo.Step1Observer).sendKeys(text); 
		driver.findElement(jo.Step1Organization).sendKeys(text);
		driver.findElement(jo.Step1Department).sendKeys(text);
		driver.findElement(jo.Step1Location).sendKeys(text);
		driver.findElement(jo.Step1JobObserved).sendKeys(text);
		String ev1 = driver.findElement(jo.Step1Observer).getAttribute("value");
		String ev2 = driver.findElement(jo.Step1Location).getAttribute("value");
		String ev3 = driver.findElement(jo.Step1JobObserved).getAttribute("value");
		if ((ev1.equals(text)==false))
		{
			driver.findElement(jo.Step1Observer).clear();
			driver.findElement(jo.Step1Observer).sendKeys(text);
		}
		if ((ev2.equals(text)==false))
		{
			driver.findElement(jo.Step1Location).clear();
			driver.findElement(jo.Step1Location).sendKeys(text);
		}
		if ((ev3.equals(text)==false))
		{
			driver.findElement(jo.Step1JobObserved).clear();
			driver.findElement(jo.Step1JobObserved).sendKeys(text);
		}
		
		//Select Observation Type
		Random random = new Random ();
		int y;
		y = random.nextInt(3);
		if(y<4)
			y=y+1;
		WebElement dropdown1 = driver.findElement(By.id("pii-joa-obstype-select"));
		Select s1 = new Select(dropdown1);
		s1.selectByIndex(y);
		//Select Category
		WebElement dropdown2 = driver.findElement(By.id("pii-joa-obscat-select"));
		Select s2 = new Select(dropdown2);
		s2.selectByIndex(y);
		
		//Click on Factors checkboxes
		for(i=0; i<3; i++) {
		driver.findElement(By.xpath(".//*[@for='pii-joa-obsfactors-"+i+"']")).click();
		}
		//Click on 1st Characteristics checkbox
		driver.findElement(By.xpath(".//*[@id='pii-joa-charac']/table[1]/tbody/tr[1]/td[1]/div/div/label")).click();
		//Send some text for 1stCharacteristics checkbox
		driver.findElement(By.xpath("//*[@id='pii-joa-charac']/table[1]/tbody/tr[1]/td[2]/textarea")).sendKeys("JOText");
		Thread.sleep(3000);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		//Upload Supporting files (2 times) 
		String filepath = "C:/Users/mama/Pictures/Upload/CCYC2355.JPG";
		for (int j=0; j<2; j++)
		{
			//Click on Supporting file {Choose file} button
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-jo-event-file-button-"+j))));
			//Fill each supporting file title
			String title_id="pii-jo-event-file-title-"+j;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(title_id))).sendKeys("Title0"+(j+1));
			//Fill each supporting file description
			String des_id="pii-jo-event-file-description-"+j;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(des_id))).sendKeys("Des0"+(j+1));
			//Choose File upload photo
			driver.findElement(By.id("pii-jo-event-file-"+j)).sendKeys(filepath);
			Runtime.getRuntime().exec("C:\\Users\\mama\\Downloads\\clickcancel2.exe");
			//Click on attach another file to add 2nd supporting file photo
			WebElement clickAddAttachBtn= driver.findElement(By.id("pii-jo-addnewfile-button"));
			if(j==0)
			{
			jse.executeScript("arguments[0].click();", clickAddAttachBtn);
			}else break;
		}
		//Click on Submit JO Button (bottom)
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-jo-addnewfile-button"))));
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		driver.findElement(jo.JOStep1SubmitJOButton).click();
		Thread.sleep(10000);
		   }	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		 //Click on 1st JO link 
		   WebElement firstJO= driver.findElement(By.xpath("//a[contains(@pii-obs-i,'0')]"));
		   jse.executeScript("arguments[0].click();", firstJO);
		   Thread.sleep(2000);
		   //Click/expand 1st JO's 2 supporting file collapsible
		   for(int j=0;j<2;j++) {
			   jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-jo-event-filecollapsible-"+j))));
			   jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-jo-event-filecollapsible-"+j))));
			   Thread.sleep(500);
		   //Verify 1st JO's 2 supporting file photo display
			WebElement JOImgDisplay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-jo-event-file-img-"+j)));
			if (JOImgDisplay.isDisplayed())
			{
				System.out.println("Supporting File Image- "+ (j+1)+ "display successfully");
			}
			else
				System.out.println ("Supproting File Image- "+ (j+1)+" NOT display");
		   }
		//Click on generate button
		 driver.findElement(jo.JOStep1GenerateReportButton).click();
		 //Select Jan From: Month picker
		 WebElement dropdownMonth = driver.findElement(By.className("ui-datepicker-month"));
			Select sJan = new Select(dropdownMonth);
			sJan.selectByIndex(0);
			Thread.sleep(1000);
		 //Click on From: Date picker
		 jse.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id='pii-generate-report-from']/div/table/tbody/tr[3]/td[1]/a")));
		//Click on To: Date picker
		 jse.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id='pii-generate-report-to']/div/table/tbody/tr[1]/td[3]/a")));
		 Thread.sleep(1000);
		//Click on {generate} button   
		 jse.executeScript("arguments[0].click();", driver.findElement(By.id("pii-joa-genrep-do")));
		//Waits for the green popup on the right top corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.StickyNote));
		 //Click on {saved activities} button
		 driver.findElement(jo.JOSavedActivitiesButton).click();
		share2.loadingServer(driver);
		//Clicks on side panel option for job observation
		wait.until(ExpectedConditions.visibilityOfElementLocated(jo.JOSidePanel)).click();
		share2.loadingServer(driver);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		//Verify HTML report
		List<String> JOhtml = JOhtmlReport(driver);
		//Download pdf and verify pdf
		downloadSelectFunction(driver,chineseData);
		
		
	
		
		
		public List<String> JOhtmlReport (WebDriver driver) throws Exception {

			WebDriverWait wait = new WebDriverWait(driver,10);
			List<String> c = new ArrayList<String>();
			
			
			
			
			return c;	
		}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		//Gets the name of the record created
		WebElement record = driver.findElement(jo.JOFirstRecord);
		if (record.isDisplayed())
		{
			System.out.println("JO report found");
		}
		else 
			System.out.println ("JO report NOT found");
		Thread.sleep(10000);
		//Click on 1st report record
		 jse.executeScript("arguments[0].click();", jo.JOFirstRecord);
		 //Verify report title
		 String dateRange_title=driver.findElement(By.xpath(".//*[@id='joa-rpt']/div[1]/table/tbody/tr[2]/td")).getText();
		softly.assertThat(dateRange_title).as("test data").contains("Date Range");
		
		//Gets the name of the record created
		String recordName = record.getText();
		String r = recordName.replaceAll("\u00AD", "");
		softly.assertThat(r).as("test data").contains(text);
//		return(r);
		
	}
}
/*
//Click on Characteristics checkboxes
for(int i=1; i<6; i++) {
driver.findElement(By.xpath(".//*[@id='pii-joa-charac']/table[1]/tbody/tr["+i+"]/td[1]/div/div/label")).click();
i=i+1;
}
//Send some text for  Characteristics checkboxes
for(int i=1; i<6; i++) {
driver.findElement(By.xpath("//*[@id='pii-joa-charac']/table[1]/tbody/tr["+i+"]/td[2]/textarea")).sendKeys("JOText");
i=i+1;
}*/
