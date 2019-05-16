package kaleTestSoftware;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ErrorMeter {

	TextBoxResizing tbr = new TextBoxResizing ();
	ErrorMeter2 em2 = new ErrorMeter2();
	ErrorMeter3 em3 = new ErrorMeter3();
	ErrorMeterPageObj emObj = new ErrorMeterPageObj();
	EiRCA2 eirca2 = new EiRCA2();
	EiRCAPageObj eirca = new EiRCAPageObj();
	ShareCheck2 share2 = new ShareCheck2();
	ShareCheck share = new ShareCheck();

	SoftAssertions softly = new SoftAssertions();

	public void papeError100(WebDriver driver) throws Exception{

		List<String> text=em2.error100Data(driver,driver.getCurrentUrl());
		WebDriverWait wait1 = new WebDriverWait(driver,30);
		String browserName = getBrowser(driver);
		int i;
		int j=text.size()-1;
		//Closes any warning from server
		try{

			//CLoses server warning
			String s=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note"))).getText().trim();
			System.out.println(s);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();			  
		}catch (org.openqa.selenium.TimeoutException e)
		{

		}
		//Click on Environment of PAPE
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentTab)).click();
		//Clicks on checkboxes in Environment Tab
		if(browserName.contains("safari"))
			em3.clickElementForSafariBrowser(driver, emObj.ErrorMeterPAPEEnvironmentCheckBox1);
		else 
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCheckBox1)).click();
		em3.verifyCheckBoxChecked(driver, emObj.ErrorMeterPAPEEnvironmentCheckBox1);
		if(browserName.contains("safari"))
			em3.clickElementForSafariBrowser(driver, emObj.ErrorMeterPAPEEnvironmentCheckBox2);
		else 
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCheckBox2)).click();
		em3.verifyCheckBoxChecked(driver, emObj.ErrorMeterPAPEEnvironmentCheckBox2);

		share2.scrollToAPoint(driver, 800);
		if(browserName.contains("safari"))
			em3.clickElementForSafariBrowser(driver, emObj.ErrorMeterPAPEEnvironmentCheckBox3);
		else 
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCheckBox3)).click();
		em3.verifyCheckBoxChecked(driver, emObj.ErrorMeterPAPEEnvironmentCheckBox3);
		if(browserName.contains("safari"))
			em3.clickElementForSafariBrowser(driver, emObj.ErrorMeterPAPEEnvironmentCheckBox4);
		else 
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCheckBox4)).click();
		em3.verifyCheckBoxChecked(driver, emObj.ErrorMeterPAPEEnvironmentCheckBox4);

		//Fill in texts in Supporting reasons 
		share2.scrollToTop(driver);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentSupportingReason1)).sendKeys(text.get(j));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentSupportingReason1)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentSupportingReason1)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentSupportingReason1)).sendKeys(text.get(j));



		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentSupportingReason2)).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentSupportingReason2)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentSupportingReason2)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentSupportingReason2)).sendKeys(text.get(j));


		share2.scrollToAPoint(driver, 800);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentSupportingReason3)).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentSupportingReason3)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentSupportingReason3)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentSupportingReason3)).sendKeys(text.get(j));



		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentSupportingReason4)).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentSupportingReason4)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentSupportingReason4)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentSupportingReason4)).sendKeys(text.get(j));


		//Fill in texts in Corrective Actions
		share2.scrollToTop(driver);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCorrectiveAction1)).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCorrectiveAction1)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCorrectiveAction1)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCorrectiveAction1)).sendKeys(text.get(j));



		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCorrectiveAction2)).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCorrectiveAction2)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCorrectiveAction2)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCorrectiveAction2)).sendKeys(text.get(j));


		share2.scrollToAPoint(driver, 800);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCorrectiveAction3)).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCorrectiveAction3)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCorrectiveAction3)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCorrectiveAction3)).sendKeys(text.get(j));	



		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCorrectiveAction4)).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCorrectiveAction4)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCorrectiveAction4)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCorrectiveAction4)).sendKeys(text.get(j));


		share2.scrollToTop(driver);
		//Checks error meter as 0%
		WebElement meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPercentageBar));
		String meterText = meter.getText().trim();
		System.out.println(meterText);
		if(driver.getCurrentUrl().contains("kaleqa"))
			softly.assertThat("0%").as("test data").isEqualTo(meterText.trim());
		else
			softly.assertThat("25%").as("test data").isEqualTo(meterText.trim());



		//Click on People of PAPE
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleTab)).click();
		//Clicks on checkboxes in People Tab
		if(browserName.contains("safari"))
			em3.clickElementForSafariBrowser(driver, emObj.ErrorMeterPAPEPeopleCheckBox1);
		else 
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCheckBox1)).click();
		em3.verifyCheckBoxChecked(driver, emObj.ErrorMeterPAPEPeopleCheckBox1);
		Thread.sleep(1000);
		meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPercentageBar));
		meterText = meter.getText().trim();
		System.out.println(meterText);
		if(driver.getCurrentUrl().contains("kaleqa"))
			softly.assertThat("15%").as("test data").isEqualTo(meterText.trim());
		else
			softly.assertThat("31%").as("test data").isEqualTo(meterText.trim());
		if(browserName.contains("safari"))
			em3.clickElementForSafariBrowser(driver, emObj.ErrorMeterPAPEPeopleCheckBox2);
		else 
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCheckBox2)).click();
		em3.verifyCheckBoxChecked(driver, emObj.ErrorMeterPAPEPeopleCheckBox2);
		Thread.sleep(1000);
		meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPercentageBar));
		meterText = meter.getText().trim();
		System.out.println(meterText);
		if(driver.getCurrentUrl().contains("kaleqa"))
			softly.assertThat("30%").as("test data").isEqualTo(meterText.trim());
		else
			softly.assertThat("38%").as("test data").isEqualTo(meterText.trim());

		share2.scrollToAPoint(driver, 800);
		if(browserName.contains("safari"))
			em3.clickElementForSafariBrowser(driver, emObj.ErrorMeterPAPEPeopleCheckBox3);
		else 
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCheckBox3)).click();
		em3.verifyCheckBoxChecked(driver, emObj.ErrorMeterPAPEPeopleCheckBox3);
		Thread.sleep(1000);
		meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPercentageBar));
		meterText = meter.getText().trim();
		System.out.println(meterText);
		if(driver.getCurrentUrl().contains("kaleqa"))
			softly.assertThat("45%").as("test data").isEqualTo(meterText.trim());
		else
			softly.assertThat("44%").as("test data").isEqualTo(meterText.trim());
		if(browserName.contains("safari"))
			em3.clickElementForSafariBrowser(driver, emObj.ErrorMeterPAPEPeopleCheckBox4);
		else 
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCheckBox4)).click();
		em3.verifyCheckBoxChecked(driver, emObj.ErrorMeterPAPEPeopleCheckBox4);
		Thread.sleep(1000);
		meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPercentageBar));
		meterText = meter.getText().trim();
		System.out.println(meterText);
		if(driver.getCurrentUrl().contains("kaleqa"))
			softly.assertThat("60%").as("test data").isEqualTo(meterText.trim());
		else
			softly.assertThat("50%").as("test data").isEqualTo(meterText.trim());

		//Fill in texts in Supporting reasons 
		share2.scrollToTop(driver);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleSupportingReason1)).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleSupportingReason1)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleSupportingReason1)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleSupportingReason1)).sendKeys(text.get(j));



		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleSupportingReason2)).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleSupportingReason2)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleSupportingReason2)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleSupportingReason2)).sendKeys(text.get(j));


		share2.scrollToAPoint(driver, 800);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleSupportingReason3)).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleSupportingReason3)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleSupportingReason3)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleSupportingReason3)).sendKeys(text.get(j));


		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleSupportingReason4)).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleSupportingReason4)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleSupportingReason4)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleSupportingReason4)).sendKeys(text.get(j));


		//Fill in texts in Corrective Actions
		share2.scrollToTop(driver);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCorrectiveAction1)).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCorrectiveAction1)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCorrectiveAction1)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCorrectiveAction1)).sendKeys(text.get(j));



		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCorrectiveAction2)).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCorrectiveAction2)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCorrectiveAction2)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCorrectiveAction2)).sendKeys(text.get(j));


		share2.scrollToAPoint(driver, 800);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCorrectiveAction3)).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCorrectiveAction3)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCorrectiveAction3)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCorrectiveAction3)).sendKeys(text.get(j));



		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCorrectiveAction4)).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCorrectiveAction4)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCorrectiveAction4)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCorrectiveAction4)).sendKeys(text.get(j));




		//Click on Activity of PAPE
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityTab)).click();
		//Clicks on checkboxes in Activity Tab
		if(browserName.contains("safari"))
			em3.clickElementForSafariBrowser(driver, emObj.ErrorMeterPAPEActivityCheckBox1);
		else 
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCheckBox1)).click();
		em3.verifyCheckBoxChecked(driver, emObj.ErrorMeterPAPEActivityCheckBox1);
		Thread.sleep(1000);
		meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPercentageBar));
		meterText = meter.getText().trim();
		System.out.println(meterText);
		if(driver.getCurrentUrl().contains("kaleqa"))
			softly.assertThat("65%").as("test data").isEqualTo(meterText.trim());
		else
			softly.assertThat("56%").as("test data").isEqualTo(meterText.trim());
		if(browserName.contains("safari"))
			em3.clickElementForSafariBrowser(driver, emObj.ErrorMeterPAPEActivityCheckBox2);
		else 
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCheckBox2)).click();
		em3.verifyCheckBoxChecked(driver, emObj.ErrorMeterPAPEActivityCheckBox2);
		Thread.sleep(1000);
		meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPercentageBar));
		meterText = meter.getText().trim();
		System.out.println(meterText);
		if(driver.getCurrentUrl().contains("kaleqa"))
			softly.assertThat("70%").as("test data").isEqualTo(meterText.trim());
		else
			softly.assertThat("63%").as("test data").isEqualTo(meterText.trim());

		share2.scrollToAPoint(driver, 800);
		if(browserName.contains("safari"))
			em3.clickElementForSafariBrowser(driver, emObj.ErrorMeterPAPEActivityCheckBox3);
		else 
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCheckBox3)).click();
		em3.verifyCheckBoxChecked(driver, emObj.ErrorMeterPAPEActivityCheckBox3);
		Thread.sleep(1000);
		meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPercentageBar));
		meterText = meter.getText().trim();
		System.out.println(meterText);
		if(driver.getCurrentUrl().contains("kaleqa"))
			softly.assertThat("75%").as("test data").isEqualTo(meterText.trim());
		else
			softly.assertThat("69%").as("test data").isEqualTo(meterText.trim());
		if(browserName.contains("safari"))
			em3.clickElementForSafariBrowser(driver, emObj.ErrorMeterPAPEActivityCheckBox4);
		else 
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCheckBox4)).click();
		em3.verifyCheckBoxChecked(driver, emObj.ErrorMeterPAPEActivityCheckBox4);
		Thread.sleep(1000);
		meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPercentageBar));
		meterText = meter.getText().trim();
		System.out.println(meterText);
		if(driver.getCurrentUrl().contains("kaleqa"))
			softly.assertThat("80%").as("test data").isEqualTo(meterText.trim());
		else
			softly.assertThat("75%").as("test data").isEqualTo(meterText.trim());

		//Fill in texts in Supporting reasons 
		share2.scrollToTop(driver);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivitySupportingReason1)).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivitySupportingReason1)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivitySupportingReason1)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivitySupportingReason1)).sendKeys(text.get(j));


		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivitySupportingReason2)).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivitySupportingReason2)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivitySupportingReason2)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivitySupportingReason2)).sendKeys(text.get(j));


		share2.scrollToAPoint(driver, 800);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivitySupportingReason3)).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivitySupportingReason3)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivitySupportingReason3)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivitySupportingReason3)).sendKeys(text.get(j));



		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivitySupportingReason4)).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivitySupportingReason4)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivitySupportingReason4)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivitySupportingReason4)).sendKeys(text.get(j));


		//Fill in texts in Corrective Actions
		share2.scrollToTop(driver);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCorrectiveAction1)).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCorrectiveAction1)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCorrectiveAction1)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCorrectiveAction1)).sendKeys(text.get(j));



		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCorrectiveAction2)).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCorrectiveAction2)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCorrectiveAction2)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCorrectiveAction2)).sendKeys(text.get(j));


		share2.scrollToAPoint(driver, 800);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCorrectiveAction3)).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCorrectiveAction3)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCorrectiveAction3)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCorrectiveAction3)).sendKeys(text.get(j));



		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCorrectiveAction4)).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCorrectiveAction4)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCorrectiveAction4)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCorrectiveAction4)).sendKeys(text.get(j));



		//Clicks on Procedure Tab
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureTab)).click();
		//Clicks on checkboxes in Procedure Tab
		if(browserName.contains("safari"))
			em3.clickElementForSafariBrowser(driver, emObj.ErrorMeterPAPEProcedureCheckBox1);
		else 
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCheckBox1)).click();
		em3.verifyCheckBoxChecked(driver, emObj.ErrorMeterPAPEProcedureCheckBox1);
		Thread.sleep(1000);
		meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPercentageBar));
		meterText = meter.getText().trim();
		System.out.println(meterText);
		if(driver.getCurrentUrl().contains("kaleqa"))
			softly.assertThat("85%").as("test data").isEqualTo(meterText.trim());
		else
			softly.assertThat("81%").as("test data").isEqualTo(meterText.trim());
		if(browserName.contains("safari"))
			em3.clickElementForSafariBrowser(driver, emObj.ErrorMeterPAPEProcedureCheckBox2);
		else 
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCheckBox2)).click();
		em3.verifyCheckBoxChecked(driver, emObj.ErrorMeterPAPEProcedureCheckBox2);
		Thread.sleep(1000);
		meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPercentageBar));
		meterText = meter.getText().trim();
		System.out.println(meterText);
		if(driver.getCurrentUrl().contains("kaleqa"))
			softly.assertThat("90%").as("test data").isEqualTo(meterText.trim());
		else
			softly.assertThat("88%").as("test data").isEqualTo(meterText.trim());

		share2.scrollToAPoint(driver, 800);
		if(browserName.contains("safari"))
			em3.clickElementForSafariBrowser(driver, emObj.ErrorMeterPAPEProcedureCheckBox3);
		else 
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCheckBox3)).click();
		em3.verifyCheckBoxChecked(driver, emObj.ErrorMeterPAPEProcedureCheckBox3);
		Thread.sleep(1000);
		meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPercentageBar));
		meterText = meter.getText().trim();
		System.out.println(meterText);
		if(driver.getCurrentUrl().contains("kaleqa"))
			softly.assertThat("95%").as("test data").isEqualTo(meterText.trim());
		else
			softly.assertThat("94%").as("test data").isEqualTo(meterText.trim());
		if(browserName.contains("safari"))
			em3.clickElementForSafariBrowser(driver, emObj.ErrorMeterPAPEProcedureCheckBox4);
		else 
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCheckBox4)).click();
		em3.verifyCheckBoxChecked(driver, emObj.ErrorMeterPAPEProcedureCheckBox4);
		Thread.sleep(1000);
		meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPercentageBar));
		meterText = meter.getText().trim();
		System.out.println(meterText);
		softly.assertThat("100%").as("test data").isEqualTo(meterText.trim());

		//Fill in texts in Supporting reasons 
		share2.scrollToTop(driver);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureSupportingReason1)).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureSupportingReason1)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureSupportingReason1)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureSupportingReason1)).sendKeys(text.get(j));



		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureSupportingReason2)).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureSupportingReason2)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureSupportingReason2)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureSupportingReason2)).sendKeys(text.get(j));


		share2.scrollToAPoint(driver, 800);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureSupportingReason3)).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureSupportingReason3)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureSupportingReason3)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureSupportingReason3)).sendKeys(text.get(j));



		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureSupportingReason4)).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureSupportingReason4)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureSupportingReason4)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureSupportingReason4)).sendKeys(text.get(j));


		//Fill in texts in Corrective Actions
		share2.scrollToTop(driver);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCorrectiveAction1)).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCorrectiveAction1)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCorrectiveAction1)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCorrectiveAction1)).sendKeys(text.get(j));



		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCorrectiveAction2)).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCorrectiveAction2)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCorrectiveAction2)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCorrectiveAction2)).sendKeys(text.get(j));


		share2.scrollToAPoint(driver, 800);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCorrectiveAction3)).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCorrectiveAction3)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCorrectiveAction3)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCorrectiveAction3)).sendKeys(text.get(j));


		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCorrectiveAction4)).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCorrectiveAction4)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCorrectiveAction4)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCorrectiveAction4)).sendKeys(text.get(j));
		share2.scrollToTop(driver);
		share2.scrollToTop(driver);
	}

	public String getBrowser(WebDriver driver) throws Exception {

		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		return browserName;
	}


	public void papeError50(WebDriver driver) throws Exception{

		List<String> text = em2.error50Data(driver,driver.getCurrentUrl());
		WebDriverWait wait1 = new WebDriverWait(driver,30);
		String browserName = getBrowser(driver);
		int i;
		int j=text.size()-1;
		//Closes any warning from server
		try{
			//Closes server warning
			String s=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note"))).getText().trim();
			System.out.println(s);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();			  
		}catch (org.openqa.selenium.TimeoutException e)
		{

		}
		//Click on Environment of PAPE
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentTab)).click();
		//Clicks on checkboxes in Environment Tab
		if(browserName.contains("safari"))
			em3.clickElementForSafariBrowser(driver, emObj.ErrorMeterPAPEEnvironmentCheckBox1);
		else 
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCheckBox1)).click();
		em3.verifyCheckBoxChecked(driver, emObj.ErrorMeterPAPEEnvironmentCheckBox1);

		share2.scrollToAPoint(driver, 800);
		if(browserName.contains("safari"))
			em3.clickElementForSafariBrowser(driver, emObj.ErrorMeterPAPEEnvironmentCheckBox4);
		else 
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCheckBox4)).click();
		em3.verifyCheckBoxChecked(driver, emObj.ErrorMeterPAPEEnvironmentCheckBox4);

		//Fill in texts in Supporting reasons 
		share2.scrollToTop(driver);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentSupportingReason1)).sendKeys(text.get(j));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentSupportingReason1)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentSupportingReason1)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentSupportingReason1)).sendKeys(text.get(j));


		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentSupportingReason4)).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentSupportingReason4)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentSupportingReason4)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentSupportingReason4)).sendKeys(text.get(j));
		//Leave in text in empty boxes
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentSupportingReason3)).sendKeys(text.get(j));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentSupportingReason2)).sendKeys(text.get(j));


		//Fill in texts in Corrective Actions
		share2.scrollToTop(driver);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCorrectiveAction1)).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCorrectiveAction1)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCorrectiveAction1)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCorrectiveAction1)).sendKeys(text.get(j));


		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCorrectiveAction4)).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCorrectiveAction4)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCorrectiveAction4)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCorrectiveAction4)).sendKeys(text.get(j));
		//Leave text in corrective actions
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCorrectiveAction3)).sendKeys(text.get(j));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCorrectiveAction2)).sendKeys(text.get(j));


		share2.scrollToTop(driver);
		//Checks error meter as 0%
		WebElement meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPercentageBar));
		String meterText = meter.getText().trim();
		System.out.println(meterText);
		if(driver.getCurrentUrl().contains("kaleqa"))
			softly.assertThat("0%").as("test data").isEqualTo(meterText.trim());
		else
			softly.assertThat("13%").as("test data").isEqualTo(meterText.trim());



		//Click on People of PAPE
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleTab)).click();
		//Clicks on checkboxes in People Tab
		if(browserName.contains("safari"))
			em3.clickElementForSafariBrowser(driver, emObj.ErrorMeterPAPEPeopleCheckBox2);
		else 
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCheckBox2)).click();
		em3.verifyCheckBoxChecked(driver, emObj.ErrorMeterPAPEPeopleCheckBox2);
		Thread.sleep(1000);
		meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPercentageBar));
		meterText = meter.getText().trim();
		System.out.println(meterText);
		if(driver.getCurrentUrl().contains("kaleqa"))
			softly.assertThat("15%").as("test data").isEqualTo(meterText.trim());
		else
			softly.assertThat("19%").as("test data").isEqualTo(meterText.trim());

		share2.scrollToAPoint(driver, 800);
		if(browserName.contains("safari"))
			em3.clickElementForSafariBrowser(driver, emObj.ErrorMeterPAPEPeopleCheckBox3);
		else 
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCheckBox3)).click();
		em3.verifyCheckBoxChecked(driver, emObj.ErrorMeterPAPEPeopleCheckBox3);
		Thread.sleep(1000);
		meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPercentageBar));
		meterText = meter.getText().trim();
		System.out.println(meterText);
		if(driver.getCurrentUrl().contains("kaleqa"))
			softly.assertThat("30%").as("test data").isEqualTo(meterText.trim());
		else
			softly.assertThat("25%").as("test data").isEqualTo(meterText.trim());

		//Fill in texts in Supporting reasons 
		share2.scrollToTop(driver);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleSupportingReason2)).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleSupportingReason2)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleSupportingReason2)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleSupportingReason2)).sendKeys(text.get(j));
		//leave in text
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleSupportingReason1)).sendKeys(text.get(j));


		share2.scrollToAPoint(driver, 800);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleSupportingReason3)).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleSupportingReason3)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleSupportingReason3)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleSupportingReason3)).sendKeys(text.get(j));
		//leave in text
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleSupportingReason4)).sendKeys(text.get(j));


		//Fill in texts in Corrective Actions
		share2.scrollToTop(driver);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCorrectiveAction2)).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCorrectiveAction2)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCorrectiveAction2)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCorrectiveAction2)).sendKeys(text.get(j));
		//leave in text
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCorrectiveAction1)).sendKeys(text.get(j));


		share2.scrollToAPoint(driver, 800);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCorrectiveAction3)).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCorrectiveAction3)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCorrectiveAction3)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCorrectiveAction3)).sendKeys(text.get(j));
		//leave in text
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCorrectiveAction4)).sendKeys(text.get(j));


		//Click on Activity of PAPE
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityTab)).click();
		//Clicks on checkboxes in Activity Tab
		if(browserName.contains("safari"))
			em3.clickElementForSafariBrowser(driver, emObj.ErrorMeterPAPEActivityCheckBox2);
		else 
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCheckBox2)).click();
		em3.verifyCheckBoxChecked(driver, emObj.ErrorMeterPAPEActivityCheckBox2);
		Thread.sleep(1000);
		meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPercentageBar));
		meterText = meter.getText().trim();
		System.out.println(meterText);
		if(driver.getCurrentUrl().contains("kaleqa"))
			softly.assertThat("35%").as("test data").isEqualTo(meterText.trim());
		else
			softly.assertThat("31%").as("test data").isEqualTo(meterText.trim());

		share2.scrollToAPoint(driver, 800);
		if(browserName.contains("safari"))
			em3.clickElementForSafariBrowser(driver, emObj.ErrorMeterPAPEActivityCheckBox4);
		else 
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCheckBox4)).click();
		em3.verifyCheckBoxChecked(driver, emObj.ErrorMeterPAPEActivityCheckBox4);
		Thread.sleep(1000);
		meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPercentageBar));
		meterText = meter.getText().trim();
		System.out.println(meterText);
		if(driver.getCurrentUrl().contains("kaleqa"))
			softly.assertThat("40%").as("test data").isEqualTo(meterText.trim());
		else
			softly.assertThat("38%").as("test data").isEqualTo(meterText.trim());

		//Fill in texts in Supporting reasons 
		share2.scrollToTop(driver);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivitySupportingReason2)).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivitySupportingReason2)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivitySupportingReason2)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivitySupportingReason2)).sendKeys(text.get(j));


		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivitySupportingReason4)).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivitySupportingReason4)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivitySupportingReason4)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivitySupportingReason4)).sendKeys(text.get(j));
		//leave in text
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivitySupportingReason1)).sendKeys(text.get(j));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivitySupportingReason3)).sendKeys(text.get(j));


		//Fill in texts in Corrective Actions
		share2.scrollToTop(driver);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCorrectiveAction2)).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCorrectiveAction2)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCorrectiveAction2)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCorrectiveAction2)).sendKeys(text.get(j));
		//leave in text
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCorrectiveAction1)).sendKeys(text.get(j));


		share2.scrollToAPoint(driver, 800);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCorrectiveAction4)).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCorrectiveAction4)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCorrectiveAction4)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCorrectiveAction4)).sendKeys(text.get(j));
		//leave in text
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCorrectiveAction3)).sendKeys(text.get(j));


		//Clicks on Procedure Tab
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureTab)).click();
		//Clicks on checkboxes in Procedure Tab
		if(browserName.contains("safari"))
			em3.clickElementForSafariBrowser(driver, emObj.ErrorMeterPAPEProcedureCheckBox1);
		else 
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCheckBox1)).click();
		em3.verifyCheckBoxChecked(driver, emObj.ErrorMeterPAPEProcedureCheckBox1);
		Thread.sleep(1000);
		meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPercentageBar));
		meterText = meter.getText().trim();
		System.out.println(meterText);
		if(driver.getCurrentUrl().contains("kaleqa"))
			softly.assertThat("45%").as("test data").isEqualTo(meterText.trim());
		else
			softly.assertThat("44%").as("test data").isEqualTo(meterText.trim());

		share2.scrollToAPoint(driver, 800);
		if(browserName.contains("safari"))
			em3.clickElementForSafariBrowser(driver, emObj.ErrorMeterPAPEProcedureCheckBox3);
		else 
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCheckBox3)).click();
		em3.verifyCheckBoxChecked(driver, emObj.ErrorMeterPAPEProcedureCheckBox3);
		Thread.sleep(1000);
		meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPercentageBar));
		meterText = meter.getText().trim();
		System.out.println(meterText);
		softly.assertThat("50%").as("test data").isEqualTo(meterText.trim());

		//Fill in texts in Supporting reasons 
		share2.scrollToTop(driver);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureSupportingReason1)).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureSupportingReason1)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureSupportingReason1)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureSupportingReason1)).sendKeys(text.get(j));
		//leave in text
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureSupportingReason2)).sendKeys(text.get(j));


		share2.scrollToAPoint(driver, 800);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureSupportingReason3)).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureSupportingReason3)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureSupportingReason3)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureSupportingReason3)).sendKeys(text.get(j));
		//leave in text
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureSupportingReason4)).sendKeys(text.get(j));
		//Fill in texts in Corrective Actions
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCorrectiveAction1)).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCorrectiveAction1)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCorrectiveAction1)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCorrectiveAction1)).sendKeys(text.get(j));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCorrectiveAction3)).sendKeys(text.get(j--));
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCorrectiveAction3)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCorrectiveAction3)).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCorrectiveAction3)).sendKeys(text.get(j));
		//leave in text
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCorrectiveAction2)).sendKeys(text.get(j));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCorrectiveAction4)).sendKeys(text.get(j));
	}


	public void papeError0(WebDriver driver) throws Exception{

		String text = em2.error0Data(driver,driver.getCurrentUrl());
		WebDriverWait wait1 = new WebDriverWait(driver,30);
		//Closes any warning from server
		Login obj1 = new Login();
		obj1.closePopUpSticky(driver);
		//Verify mark all instruction
		String ins = wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterInstructionText)).getText().trim();
		softly.assertThat(ins).as("test data").isEqualTo("Mark \"Yes\" for all that apply. Do not mark if answer is \"No\" or \"N/A\".");
		//Clicks on checkboxes in Procedure Tab
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCheckBox1)).click();
		em3.verifyCheckBoxChecked(driver, emObj.ErrorMeterPAPEProcedureCheckBox1);
		Thread.sleep(500);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCheckBox1)).click();
		em3.verifyCheckBoxNotChecked(driver, emObj.ErrorMeterPAPEProcedureCheckBox1);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCheckBox2)).click();
		em3.verifyCheckBoxChecked(driver, emObj.ErrorMeterPAPEProcedureCheckBox2);
		Thread.sleep(500);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCheckBox2)).click();
		em3.verifyCheckBoxNotChecked(driver, emObj.ErrorMeterPAPEProcedureCheckBox2);

		share2.scrollToElement(driver, wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCheckBox3)));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCheckBox3)).click();
		em3.verifyCheckBoxChecked(driver, emObj.ErrorMeterPAPEProcedureCheckBox3);
		Thread.sleep(500);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCheckBox3)).click();
		em3.verifyCheckBoxNotChecked(driver, emObj.ErrorMeterPAPEProcedureCheckBox3);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCheckBox4)).click();
		em3.verifyCheckBoxChecked(driver, emObj.ErrorMeterPAPEProcedureCheckBox4);
		Thread.sleep(500);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCheckBox4)).click();
		em3.verifyCheckBoxNotChecked(driver, emObj.ErrorMeterPAPEProcedureCheckBox4);

		//Fill in texts in Supporting reasons 
		share2.scrollToTop(driver);
		int i;
		tbr.sizeCheck(driver, emObj.ErrorMeterPAPEProcedureSupportingReason1, softly);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureSupportingReason1)).sendKeys(text);
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureSupportingReason1)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureSupportingReason1)).clear();

		tbr.sizeCheck(driver, emObj.ErrorMeterPAPEProcedureSupportingReason2, softly);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureSupportingReason2)).sendKeys(text);
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureSupportingReason2)).sendKeys(Keys.BACK_SPACE);
		}
		//wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureSupportingReason2)).clear();

		share2.scrollToAPoint(driver, 800);
		tbr.sizeCheck(driver, emObj.ErrorMeterPAPEProcedureSupportingReason3, softly);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureSupportingReason3)).sendKeys(text);
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureSupportingReason3)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureSupportingReason3)).clear();

		tbr.sizeCheck(driver, emObj.ErrorMeterPAPEProcedureSupportingReason4, softly);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureSupportingReason4)).sendKeys(text);
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureSupportingReason4)).sendKeys(Keys.BACK_SPACE);
		}
		//wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureSupportingReason4)).clear();

		//Fill in texts in Corrective Actions
		share2.scrollToTop(driver);
		tbr.sizeCheck(driver, emObj.ErrorMeterPAPEProcedureCorrectiveAction1, softly);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCorrectiveAction1)).sendKeys(text);
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCorrectiveAction1)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCorrectiveAction1)).clear();

		tbr.sizeCheck(driver, emObj.ErrorMeterPAPEProcedureCorrectiveAction2, softly);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCorrectiveAction2)).sendKeys(text);
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCorrectiveAction2)).sendKeys(Keys.BACK_SPACE);
		}
		//wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCorrectiveAction2)).clear();

		share2.scrollToAPoint(driver, 800);
		tbr.sizeCheck(driver, emObj.ErrorMeterPAPEProcedureCorrectiveAction3, softly);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCorrectiveAction3)).sendKeys(text);
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCorrectiveAction3)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCorrectiveAction3)).clear();

		tbr.sizeCheck(driver, emObj.ErrorMeterPAPEProcedureCorrectiveAction4, softly);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCorrectiveAction4)).sendKeys(text);
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCorrectiveAction4)).sendKeys(Keys.BACK_SPACE);
		}
		//wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureCorrectiveAction4)).clear();
		//Checks error meter as 0%
		WebElement meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPercentageBar));
		String meterText = meter.getText().trim();
		System.out.println(meterText);
		softly.assertThat("0%").as("test data").isEqualTo(meterText.trim());

		//Click on Activity of PAPE
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityTab)).click();
		//Clicks on checkboxes in Activity Tab
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCheckBox1)).click();
		em3.verifyCheckBoxChecked(driver, emObj.ErrorMeterPAPEActivityCheckBox1);
		Thread.sleep(500);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCheckBox1)).click();
		em3.verifyCheckBoxNotChecked(driver, emObj.ErrorMeterPAPEActivityCheckBox1);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCheckBox2)).click();
		em3.verifyCheckBoxChecked(driver, emObj.ErrorMeterPAPEActivityCheckBox2);
		Thread.sleep(500);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCheckBox2)).click();
		em3.verifyCheckBoxNotChecked(driver, emObj.ErrorMeterPAPEActivityCheckBox2);

		share2.scrollToElement(driver, wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCheckBox3)));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCheckBox3)).click();
		em3.verifyCheckBoxChecked(driver, emObj.ErrorMeterPAPEActivityCheckBox3);
		Thread.sleep(500);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCheckBox3)).click();
		em3.verifyCheckBoxNotChecked(driver, emObj.ErrorMeterPAPEActivityCheckBox3);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCheckBox4)).click();
		em3.verifyCheckBoxChecked(driver, emObj.ErrorMeterPAPEActivityCheckBox4);
		Thread.sleep(500);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCheckBox4)).click();
		em3.verifyCheckBoxNotChecked(driver, emObj.ErrorMeterPAPEActivityCheckBox4);

		//Fill in texts in Supporting reasons 
		share2.scrollToTop(driver);
		tbr.sizeCheck(driver, emObj.ErrorMeterPAPEActivitySupportingReason1, softly);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivitySupportingReason1)).sendKeys(text);
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivitySupportingReason1)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivitySupportingReason1)).clear();

		tbr.sizeCheck(driver, emObj.ErrorMeterPAPEActivitySupportingReason2, softly);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivitySupportingReason2)).sendKeys(text);
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivitySupportingReason2)).sendKeys(Keys.BACK_SPACE);
		}
		//wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivitySupportingReason2)).clear();

		share2.scrollToAPoint(driver, 800);
		tbr.sizeCheck(driver, emObj.ErrorMeterPAPEActivitySupportingReason3, softly);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivitySupportingReason3)).sendKeys(text);
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivitySupportingReason3)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivitySupportingReason3)).clear();

		tbr.sizeCheck(driver, emObj.ErrorMeterPAPEActivitySupportingReason4, softly);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivitySupportingReason4)).sendKeys(text);
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivitySupportingReason4)).sendKeys(Keys.BACK_SPACE);
		}
		//wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivitySupportingReason4)).clear();

		//Fill in texts in Corrective Actions
		share2.scrollToTop(driver);
		tbr.sizeCheck(driver, emObj.ErrorMeterPAPEActivityCorrectiveAction1, softly);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCorrectiveAction1)).sendKeys(text);
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCorrectiveAction1)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCorrectiveAction1)).clear();

		tbr.sizeCheck(driver, emObj.ErrorMeterPAPEActivityCorrectiveAction2, softly);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCorrectiveAction2)).sendKeys(text);
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCorrectiveAction2)).sendKeys(Keys.BACK_SPACE);
		}
		//wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCorrectiveAction2)).clear();

		share2.scrollToAPoint(driver, 800);
		tbr.sizeCheck(driver, emObj.ErrorMeterPAPEActivityCorrectiveAction3, softly);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCorrectiveAction3)).sendKeys(text);
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCorrectiveAction3)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCorrectiveAction3)).clear();

		tbr.sizeCheck(driver, emObj.ErrorMeterPAPEActivityCorrectiveAction4, softly);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCorrectiveAction4)).sendKeys(text);
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCorrectiveAction4)).sendKeys(Keys.BACK_SPACE);
		}
		//wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityCorrectiveAction4)).clear();
		//Checks error meter as 0%
		meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPercentageBar));
		meterText = meter.getText().trim();
		System.out.println(meterText);
		softly.assertThat("0%").as("test data").isEqualTo(meterText.trim());

		//Click on People of PAPE
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleTab)).click();
		//Clicks on checkboxes in People Tab
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCheckBox1)).click();
		em3.verifyCheckBoxChecked(driver, emObj.ErrorMeterPAPEPeopleCheckBox1);
		Thread.sleep(500);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCheckBox1)).click();
		em3.verifyCheckBoxNotChecked(driver, emObj.ErrorMeterPAPEPeopleCheckBox1);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCheckBox2)).click();
		em3.verifyCheckBoxChecked(driver, emObj.ErrorMeterPAPEPeopleCheckBox2);
		Thread.sleep(500);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCheckBox2)).click();
		em3.verifyCheckBoxNotChecked(driver, emObj.ErrorMeterPAPEPeopleCheckBox2);

		share2.scrollToElement(driver, wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCheckBox3)));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCheckBox3)).click();
		em3.verifyCheckBoxChecked(driver, emObj.ErrorMeterPAPEPeopleCheckBox3);
		Thread.sleep(500);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCheckBox3)).click();
		em3.verifyCheckBoxNotChecked(driver, emObj.ErrorMeterPAPEPeopleCheckBox3);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCheckBox4)).click();
		em3.verifyCheckBoxChecked(driver, emObj.ErrorMeterPAPEPeopleCheckBox4);
		Thread.sleep(500);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCheckBox4)).click();
		em3.verifyCheckBoxNotChecked(driver, emObj.ErrorMeterPAPEPeopleCheckBox4);

		//Fill in texts in Supporting reasons 
		share2.scrollToTop(driver);
		tbr.sizeCheck(driver, emObj.ErrorMeterPAPEPeopleSupportingReason1, softly);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleSupportingReason1)).sendKeys(text);
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleSupportingReason1)).sendKeys(Keys.BACK_SPACE);
		}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleSupportingReason1)).clear();

		tbr.sizeCheck(driver, emObj.ErrorMeterPAPEPeopleSupportingReason2, softly);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleSupportingReason2)).sendKeys(text);
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleSupportingReason2)).sendKeys(Keys.BACK_SPACE);
		}
		//wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleSupportingReason2)).clear();

		share2.scrollToAPoint(driver, 800);
		tbr.sizeCheck(driver, emObj.ErrorMeterPAPEPeopleSupportingReason3, softly);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleSupportingReason3)).sendKeys(text);
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleSupportingReason3)).sendKeys(Keys.BACK_SPACE);
		}
		//wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleSupportingReason3)).clear();

		tbr.sizeCheck(driver, emObj.ErrorMeterPAPEPeopleSupportingReason4, softly);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleSupportingReason4)).sendKeys(text);
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleSupportingReason4)).sendKeys(Keys.BACK_SPACE);
		}
		//wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleSupportingReason4)).clear();

		//Fill in texts in Corrective Actions
		share2.scrollToTop(driver);
		tbr.sizeCheck(driver, emObj.ErrorMeterPAPEPeopleCorrectiveAction1, softly);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCorrectiveAction1)).sendKeys(text);
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCorrectiveAction1)).sendKeys(Keys.BACK_SPACE);
		}
		//wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCorrectiveAction1)).clear();

		tbr.sizeCheck(driver, emObj.ErrorMeterPAPEPeopleCorrectiveAction2, softly);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCorrectiveAction2)).sendKeys(text);
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCorrectiveAction2)).sendKeys(Keys.BACK_SPACE);
		}
		//wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCorrectiveAction2)).clear();

		share2.scrollToAPoint(driver, 800);
		tbr.sizeCheck(driver, emObj.ErrorMeterPAPEPeopleCorrectiveAction3, softly);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCorrectiveAction3)).sendKeys(text);
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCorrectiveAction3)).sendKeys(Keys.BACK_SPACE);
		}
		//wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCorrectiveAction3)).clear();

		tbr.sizeCheck(driver, emObj.ErrorMeterPAPEPeopleCorrectiveAction4, softly);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCorrectiveAction4)).sendKeys(text);
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCorrectiveAction4)).sendKeys(Keys.BACK_SPACE);
		}
		//wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleCorrectiveAction4)).clear();
		//Checks error meter as 0%
		meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPercentageBar));
		meterText = meter.getText().trim();
		System.out.println(meterText);
		softly.assertThat("0%").as("test data").isEqualTo(meterText.trim());

		//Click on Environment of PAPE
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentTab)).click();
		//Clicks on checkboxes in Environment Tab
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCheckBox1)).click();
		em3.verifyCheckBoxChecked(driver, emObj.ErrorMeterPAPEEnvironmentCheckBox1);
		Thread.sleep(500);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCheckBox1)).click();
		em3.verifyCheckBoxNotChecked(driver, emObj.ErrorMeterPAPEEnvironmentCheckBox1);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCheckBox2)).click();
		em3.verifyCheckBoxChecked(driver, emObj.ErrorMeterPAPEEnvironmentCheckBox2);
		Thread.sleep(500);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCheckBox2)).click();
		em3.verifyCheckBoxNotChecked(driver, emObj.ErrorMeterPAPEEnvironmentCheckBox2);

		share2.scrollToElement(driver, wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCheckBox3)));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCheckBox3)).click();
		em3.verifyCheckBoxChecked(driver, emObj.ErrorMeterPAPEEnvironmentCheckBox3);
		Thread.sleep(500);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCheckBox3)).click();
		em3.verifyCheckBoxNotChecked(driver, emObj.ErrorMeterPAPEEnvironmentCheckBox3);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCheckBox4)).click();
		em3.verifyCheckBoxChecked(driver, emObj.ErrorMeterPAPEEnvironmentCheckBox4);
		Thread.sleep(500);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCheckBox4)).click();
		em3.verifyCheckBoxNotChecked(driver, emObj.ErrorMeterPAPEEnvironmentCheckBox4);

		//Fill in texts in Supporting reasons 
		share2.scrollToTop(driver);
		tbr.sizeCheck(driver, emObj.ErrorMeterPAPEEnvironmentSupportingReason1, softly);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentSupportingReason1)).sendKeys(text);
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentSupportingReason1)).sendKeys(Keys.BACK_SPACE);
		}
		//wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentSupportingReason1)).clear();


		tbr.sizeCheck(driver, emObj.ErrorMeterPAPEEnvironmentSupportingReason2, softly);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentSupportingReason2)).sendKeys(text);
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentSupportingReason2)).sendKeys(Keys.BACK_SPACE);
		}
		//wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentSupportingReason2)).clear();

		share2.scrollToAPoint(driver, 800);
		tbr.sizeCheck(driver, emObj.ErrorMeterPAPEEnvironmentSupportingReason3, softly);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentSupportingReason3)).sendKeys(text);
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentSupportingReason3)).sendKeys(Keys.BACK_SPACE);
		}
		//wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentSupportingReason3)).clear();


		tbr.sizeCheck(driver, emObj.ErrorMeterPAPEEnvironmentSupportingReason4, softly);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentSupportingReason4)).sendKeys(text);
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentSupportingReason4)).sendKeys(Keys.BACK_SPACE);
		}
		//wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentSupportingReason4)).clear();


		//Fill in texts in Corrective Actions
		share2.scrollToTop(driver);
		tbr.sizeCheck(driver, emObj.ErrorMeterPAPEEnvironmentCorrectiveAction1, softly);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCorrectiveAction1)).sendKeys(text);
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCorrectiveAction1)).sendKeys(Keys.BACK_SPACE);
		}
		//wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCorrectiveAction1)).clear();


		tbr.sizeCheck(driver, emObj.ErrorMeterPAPEEnvironmentCorrectiveAction2, softly);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCorrectiveAction2)).sendKeys(text);
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCorrectiveAction2)).sendKeys(Keys.BACK_SPACE);
		}
		//wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCorrectiveAction2)).clear();

		share2.scrollToAPoint(driver, 800);
		tbr.sizeCheck(driver, emObj.ErrorMeterPAPEEnvironmentCorrectiveAction3, softly);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCorrectiveAction3)).sendKeys(text);
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCorrectiveAction3)).sendKeys(Keys.BACK_SPACE);
		}
		//wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCorrectiveAction3)).clear();


		tbr.sizeCheck(driver, emObj.ErrorMeterPAPEEnvironmentCorrectiveAction4, softly);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCorrectiveAction4)).sendKeys(text);
		for (i=0;i<10;i++)
		{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCorrectiveAction4)).sendKeys(Keys.BACK_SPACE);
		}
		//wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentCorrectiveAction4)).clear();
		share2.scrollToTop(driver);
		//Checks error meter as 0%
		meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPercentageBar));
		meterText = meter.getText().trim();
		System.out.println(meterText);
		softly.assertThat("0%").as("test data").isEqualTo(meterText.trim());
	}

	public void downloadReportIE(WebDriver driver, int y) throws Exception {

		//deletes files in reports folder before starting to download
		File file = new File("C://Users//IEUser//Downloads//reports//");
		deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,30);
		String url = driver.getCurrentUrl();
		Thread.sleep(2000);
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a"))).click();
		Thread.sleep(3000);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		Thread.sleep(3000);
		try {
			Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/SavePdf.exe");
			q.waitFor();
		}catch (UnhandledAlertException f){	
			System.out.println("Unexpected alert for picture 2");
			driver.switchTo().alert().accept();

		}catch (NoAlertPresentException f){
			System.out.println ("No unexpected alert for picture 2");
		}
		Thread.sleep(15000);
		//pdf verification
		if (y==0)
			pdfCheckError0(driver,url);
		if(y==50)
			pdfCheckError50(driver,url);
		if(y==100)
			pdfCheckError100(driver,url);
		Thread.sleep(4000);
		//Switch to window    	
		driver.switchTo().window(window);
		//Switches to the iframe
		wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));

	}

	public void downloadReportIE11(WebDriver driver, int y) throws Exception {

		//deletes files in reports folder before starting to download
		File file = new File("C://Users//IEUser//Downloads//reports//");
		deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,30);
		Thread.sleep(2000);
		String url = driver.getCurrentUrl();
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a"))).click();
		Thread.sleep(3000);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		Thread.sleep(3000);
		try {
			Process q = Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/SavePdf.exe");
			q.waitFor();
		}catch (UnhandledAlertException f){	
			System.out.println("Unexpected alert for picture 2");
			driver.switchTo().alert().accept();

		}catch (NoAlertPresentException f){
			System.out.println ("No unexpected alert for picture 2");
		}
		Thread.sleep(15000);
		//pdf verification
		if (y==0)
			pdfCheckError0(driver,url);
		if(y==50)
			pdfCheckError50(driver,url);
		if(y==100)
			pdfCheckError100(driver,url);
		Thread.sleep(4000);
		//Switch to window    	
		driver.switchTo().window(window);
		//Switches to the iframe
		wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));

	}

	public void downloadReportFirefox (WebDriver driver, int y) throws Exception {

		//deletes files in reports folder before starting to download
		File file = new File("C://Users//IEUser//Downloads//reports//");
		deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		String url = driver.getCurrentUrl();
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		Thread.sleep(8000);
		for(String winHandle : driver.getWindowHandles())
		{
			System.out.println(winHandle);
			if(winHandle.isEmpty()==false)
			{
				if(winHandle.equals(window)==false)
					driver.switchTo().window(winHandle);
			}
		}
		Thread.sleep(4000);/*
		Robot robot = new Robot();
		// press Ctrl+S the Robot's way
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_S);
		Thread.sleep(4000);
		Process p= Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/PDFReportFirefox.exe");
		p.waitFor();*/
		Thread.sleep(4000);
		if (y==0)
			pdfCheckError0(driver,url);
		if(y==50)
			pdfCheckError50(driver,url);
		if(y==100)
			pdfCheckError100(driver,url);
		Thread.sleep(4000);
		driver.close();
		Thread.sleep(4000);
		driver.switchTo().window(window);
		driver.switchTo().defaultContent();
		//Switches to the iframe
		wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));

	}

	public void downloadReportChrome (WebDriver driver, int y) throws Exception {
		//deletes files in reports folder before starting to download
		File file = new File("C://Users//IEUser//Downloads//reports");
		String url = driver.getCurrentUrl();
		deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		String window = driver.getWindowHandle();
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		Thread.sleep(3000);
		if (y==0)
			pdfCheckError0(driver,url);
		if(y==50)
			pdfCheckError50(driver,url);
		if(y==100)
			pdfCheckError100(driver,url);
		for(String winHandle : driver.getWindowHandles())
		{
			driver.switchTo().window(winHandle);
		}
		driver.close();
		driver.switchTo().window(window);
		Thread.sleep(1000);
		//Switches to the iframe
		wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
	}

	public void deleteFiles(File folder) throws IOException {
		File[] files = folder.listFiles();
		for(File file: files){
			if(file.isFile()){
				String fileName = file.getName();
				boolean del= file.delete();
				System.out.println(fileName + " : got deleted ? " + del);
			}else if(file.isDirectory()) {
				deleteFiles(file);
			}
		}
	}
	public void checkEditButon(WebDriver driver)throws Exception{
		//Check if enter data and edit data buttons are not visible for non admin user
		WebElement create=driver.findElement(By.id("pii-epm-admin-create"));
		if (create.isDisplayed()==true)
			softly.fail("Enter data button displayed");
		else
			System.out.println("Enter data button not displayed for non admin user");
		WebElement edit=driver.findElement(By.id("pii-epm-admin-edit"));
		if (edit.isDisplayed()==true)
			softly.fail("Edit data button displayed");
		else
			System.out.println("Edit data button not displayed for non admin user");
	}

	public void pdfCheckError0(WebDriver driver, String url) throws Exception{

		String text = em2.error0Data(driver,url);
		// specify your directory
		Path dir = Paths.get("C://Users//IEUser//Downloads//reports//");  
		// here we get the stream with full directory listing
		// exclude subdirectories from listing
		// finally get the last file using simple comparator by lastModified field
		Optional<Path> lastFilePath = Files.list(dir).filter(f -> !Files.isDirectory(f)).max(Comparator.comparingLong(f -> f.toFile().lastModified()));  
		try{
			System.out.println(lastFilePath.get());
		}catch(java.util.NoSuchElementException t)
		{

		}
		//Loads the file to check if correct data is present
		String fileName=lastFilePath.get().toString();
		File oldfile = new File(fileName);
		PDDocument pddoc= PDDocument.load(oldfile);
		//Checks text in pdf
		String data = new PDFTextStripper().getText(pddoc);
		List<String> ans= Arrays.asList(data.split("\r\n"));
		String newData1="";
		for (int i = 0; i < ans.size(); i++)
		{	        	
			int n=ans.get(i).length()-1;
			if (ans.get(i).charAt(n)==' ')
				newData1 = newData1+ans.get(i);
			if (ans.get(i).charAt(n)!=' ')
				newData1 = newData1+" "+ans.get(i);	        	
		}
		newData1=newData1.replace("  ", " ");
		System.out.println(newData1);
		//Verifies 0.00%
		softly.assertThat("0.00%").as("test data").isSubstringOf(newData1);
		//Verifies risk level as Low
		softly.assertThat("risk level: low").as("test data").isSubstringOf(newData1);
		//Verify Non-Issue
		//Don't change Non- Issue (do not remove the space)
		softly.assertThat("Non- Issue").as("test data").isSubstringOf(newData1);
		int countx = countMatches(newData1, "Non- Issue");
		System.out.println("Non- Issue: "+countx);
		softly.assertThat(countx).as("test data").isEqualTo(16);
		//Verify that text left in was not part of pdf
		if (newData1.contains(text)==true)
			softly.fail("text present in pdf: "+text);
		//Close pdf
		pddoc.close();
	}

	public void pdfCheckError50(WebDriver driver, String url) throws Exception{

		List<String> text = em2.error50Data(driver,url);
		// specify your directory
		Path dir = Paths.get("C://Users//IEUser//Downloads//reports//");  
		// here we get the stream with full directory listing
		// exclude subdirectories from listing
		// finally get the last file using simple comparator by lastModified field
		Optional<Path> lastFilePath = Files.list(dir).filter(f -> !Files.isDirectory(f)).max(Comparator.comparingLong(f -> f.toFile().lastModified()));  
		try{
			System.out.println(lastFilePath.get());
		}catch(java.util.NoSuchElementException t)
		{

		}
		//Loads the file to check if correct data is present
		String fileName=lastFilePath.get().toString();
		File oldfile = new File(fileName);
		PDDocument pddoc= PDDocument.load(oldfile);
		//Checks text in pdf
		String data = new PDFTextStripper().getText(pddoc);
		List<String> ans= Arrays.asList(data.split("\r\n"));
		String newData1="";
		for (int i = 0; i < ans.size(); i++)
		{	        	
			int n=ans.get(i).length()-1;
			if (ans.get(i).charAt(n)==' ')
				newData1 = newData1+ans.get(i);
			if (ans.get(i).charAt(n)!=' ')
				newData1 = newData1+" "+ans.get(i);	        	
		}
		newData1=newData1.replace("  ", " ");
		System.out.println(newData1);
		//Verifies 50.00%
		softly.assertThat("50.00%").as("test data").isSubstringOf(newData1);
		//Verifies risk level as Low
		softly.assertThat("risk level: medium").as("test data").isSubstringOf(newData1);
		//Verify Non-Issue
		//Dont change Non- Issue (do not remove the space)
		softly.assertThat("Non- Issue").as("test data").isSubstringOf(newData1);
		int count1 = countMatches(newData1, "Non- Issue");
		System.out.println("Non- Issue: "+count1);
		softly.assertThat(count1).as("test data").isEqualTo(8);
		//Verify SPV
		softly.assertThat("SPV").as("test data").isSubstringOf(newData1);
		int countx = countMatches(newData1, "SPV");
		System.out.println("SPV: "+countx);
		if(url.contains("kaleasia")||url.contains("kale."))
			softly.assertThat(countx).as("test data").isEqualTo(10);
		else
			softly.assertThat(countx).as("test data").isEqualTo(9);
		//Verify all data entered
		for (int i=0;i<text.size();i++)
			softly.assertThat(text.get(i)).as("test data").isSubstringOf(newData1);

		pddoc.close();
	}

	public void pdfCheckError100(WebDriver driver, String url) throws Exception{

		List<String> text = em2.error100Data(driver,url);
		// specify your directory
		Path dir = Paths.get("C://Users//IEUser//Downloads//reports//");  
		// here we get the stream with full directory listing
		// exclude subdirectories from listing
		// finally get the last file using simple comparator by lastModified field
		Optional<Path> lastFilePath = Files.list(dir).filter(f -> !Files.isDirectory(f)).max(Comparator.comparingLong(f -> f.toFile().lastModified()));  
		System.out.println(lastFilePath.get());
		//Loads the file to check if correct data is present
		String fileName=lastFilePath.get().toString();
		File oldfile = new File(fileName);
		PDDocument pddoc= PDDocument.load(oldfile);
		//Checks text in pdf
		String data = new PDFTextStripper().getText(pddoc);
		List<String> ans= Arrays.asList(data.split("\r\n"));
		String newData1="";
		for (int i = 0; i < ans.size(); i++)
		{	        	
			int n=ans.get(i).length()-1;
			if (ans.get(i).charAt(n)==' ')
				newData1 = newData1+ans.get(i);
			if (ans.get(i).charAt(n)!=' ')
				newData1 = newData1+" "+ans.get(i);	        	
		}
		newData1=newData1.replace("  ", " ");
		System.out.println(newData1);
		//Verifies 100.00%
		softly.assertThat("100.00%").as("test data").isSubstringOf(newData1);
		//Verifies risk level as Low
		softly.assertThat("risk level: high").as("test data").isSubstringOf(newData1);
		//Verify SPV
		softly.assertThat("SPV").as("test data").isSubstringOf(newData1);
		int countx = countMatches(newData1, "SPV");
		if(url.contains("kaleasia")||url.contains("kale."))
			softly.assertThat(countx).as("test data").isEqualTo(18);
		else
			softly.assertThat(countx).as("test data").isEqualTo(17);
		System.out.println("SPV: "+countx);
		//Verify all data entered
		for (int i=0;i<text.size();i++)
			softly.assertThat(text.get(i)).as("test data").isSubstringOf(newData1);

		pddoc.close();
	}

	public int countMatches(String str, String sub) {

		int count = 0;
		int idx = 0;
		while ((idx = str.indexOf(sub, idx)) != -1) {
			count++;
			idx += sub.length();
		}
		return count;
	}

	public void reportCheck0Dev (WebDriver driver) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Compare Environment data
		//Supporting reasons
		String text1E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterEnvironmentSupportingReason1)).getText().trim();
		softly.assertThat(text1E).as("test data").isEqualTo("");
		String text2E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterEnvironmentSupportingReason2)).getText().trim();
		softly.assertThat(text2E).as("test data").isEqualTo("");
		String text3E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterEnvironmentSupportingReason3)).getText().trim();
		softly.assertThat(text3E).as("test data").isEqualTo("");
		String text4E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterEnvironmentSupportingReason4)).getText().trim();
		softly.assertThat(text4E).as("test data").isEqualTo("");
		//Corrective actions
		String text5E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterEnvironmentCorrectiveAction1)).getText().trim();
		softly.assertThat(text5E).as("test data").isEqualTo("");    	
		String text6E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterEnvironmentCorrectiveAction2)).getText().trim();
		softly.assertThat(text6E).as("test data").isEqualTo("");    	
		String text7E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterEnvironmentCorrectiveAction3)).getText().trim();
		softly.assertThat(text7E).as("test data").isEqualTo("");    	
		String text8E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterEnvironmentCorrectiveAction4)).getText().trim();
		softly.assertThat(text8E).as("test data").isEqualTo("");


		//Compare People data
		//Supporting reasons
		String text9E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPeopleSupportingReason1)).getText().trim();
		softly.assertThat(text9E).as("test data").isEqualTo("");    	
		String text10E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPeopleSupportingReason2)).getText().trim();
		softly.assertThat(text10E).as("test data").isEqualTo("");    	
		String text11E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPeopleSupportingReason3)).getText().trim();
		softly.assertThat(text11E).as("test data").isEqualTo("");    	
		String text12E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPeopleSupportingReason4)).getText().trim();
		softly.assertThat(text12E).as("test data").isEqualTo("");    	
		//Corrective actions
		String text13E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPeopleCorrectiveAction1)).getText().trim();
		softly.assertThat(text13E).as("test data").isEqualTo("");    	
		String text14E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPeopleCorrectiveAction2)).getText().trim();
		softly.assertThat(text14E).as("test data").isEqualTo("");    	
		String text15E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPeopleCorrectiveAction3)).getText().trim();
		softly.assertThat(text15E).as("test data").isEqualTo("");    	
		String text16E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPeopleCorrectiveAction4)).getText().trim();
		softly.assertThat(text16E).as("test data").isEqualTo("");


		//Compare Activity data
		//Supporting reasons
		String text17E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterActivitySupportingReason1)).getText().trim();
		softly.assertThat(text17E).as("test data").isEqualTo("");    	
		String text18E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterActivitySupportingReason2)).getText().trim();
		softly.assertThat(text18E).as("test data").isEqualTo("");    	
		String text19E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterActivitySupportingReason3)).getText().trim();
		softly.assertThat(text19E).as("test data").isEqualTo("");    	
		String text20E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterActivitySupportingReason4)).getText().trim();
		softly.assertThat(text20E).as("test data").isEqualTo("");    	
		//Corrective actions
		String text21E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterActivityCorrectiveAction1)).getText().trim();
		softly.assertThat(text21E).as("test data").isEqualTo("");    	
		String text22E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterActivityCorrectiveAction2)).getText().trim();
		softly.assertThat(text22E).as("test data").isEqualTo("");    	
		String text23E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterActivityCorrectiveAction3)).getText().trim();
		softly.assertThat(text23E).as("test data").isEqualTo("");    	
		String text24E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterActivityCorrectiveAction4)).getText().trim();
		softly.assertThat(text24E).as("test data").isEqualTo("");    	

		//Compare Procedure data
		//Supporting reasons
		String text25E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterProcedureSupportingReason1)).getText().trim();
		softly.assertThat(text25E).as("test data").isEqualTo("");    	
		String text26E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterProcedureSupportingReason2)).getText().trim();
		softly.assertThat(text26E).as("test data").isEqualTo("");    	
		String text27E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterProcedureSupportingReason3)).getText().trim();
		softly.assertThat(text27E).as("test data").isEqualTo("");    	
		String text28E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterProcedureSupportingReason4)).getText().trim();
		softly.assertThat(text28E).as("test data").isEqualTo("");    	
		//Corrective actions
		String text29E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterProcedureCorrectiveAction1)).getText().trim();
		softly.assertThat(text29E).as("test data").isEqualTo("");    	
		String text30E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterProcedureCorrectiveAction2)).getText().trim();
		softly.assertThat(text30E).as("test data").isEqualTo("");    	
		String text31E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterProcedureCorrectiveAction3)).getText().trim();
		softly.assertThat(text31E).as("test data").isEqualTo("");    	
		String text32E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterProcedureCorrectiveAction4)).getText().trim();
		softly.assertThat(text32E).as("test data").isEqualTo("");

		//Checks for Non issue
		//Procedure
		String textsp1=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterProcedureSPVNonIssue1)).getText().trim();
		softly.assertThat(textsp1.trim()).as("test data").isEqualTo("Non-Issue");
		String textnon1=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterProcedureSPVNonIssue2)).getText().trim();
		softly.assertThat(textnon1.trim()).as("test data").isEqualTo("Non-Issue");
		String textsp2=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterProcedureSPVNonIssue3)).getText().trim();
		softly.assertThat(textsp2.trim()).as("test data").isEqualTo("Non-Issue");
		String textnon2=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterProcedureSPVNonIssue4)).getText().trim();
		softly.assertThat(textnon2.trim()).as("test data").isEqualTo("Non-Issue");

		//Activity
		String textnon3=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterActivitySPVNonIssue1)).getText().trim();
		softly.assertThat(textnon3).as("test data").isEqualTo("Non-Issue");
		String textsp3=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterActivitySPVNonIssue2)).getText().trim();
		softly.assertThat(textsp3).as("test data").isEqualTo("Non-Issue");
		String textnon4=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterActivitySPVNonIssue3)).getText().trim();
		softly.assertThat(textnon4).as("test data").isEqualTo("Non-Issue");
		String textsp4=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterActivitySPVNonIssue4)).getText().trim();
		softly.assertThat(textsp4).as("test data").isEqualTo("Non-Issue");

		//People
		String textnon5=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPeopleSPVNonIssue1)).getText().trim();
		softly.assertThat(textnon5).as("test data").isEqualTo("Non-Issue");
		String textsp5=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPeopleSPVNonIssue2)).getText().trim();
		softly.assertThat(textsp5).as("test data").isEqualTo("Non-Issue");
		String textsp6=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPeopleSPVNonIssue3)).getText().trim();
		softly.assertThat(textsp6).as("test data").isEqualTo("Non-Issue");
		String textnon6=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPeopleSPVNonIssue4)).getText().trim();
		softly.assertThat(textnon6).as("test data").isEqualTo("Non-Issue");

		//Environment
		String textsp7=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterEnvironmentSPVNonIssue1)).getText().trim();
		softly.assertThat(textsp7).as("test data").isEqualTo("Non-Issue");
		String textnon7=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterEnvironmentSPVNonIssue2)).getText().trim();
		softly.assertThat(textnon7).as("test data").isEqualTo("Non-Issue");
		String textnon8=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterEnvironmentSPVNonIssue3)).getText().trim();
		softly.assertThat(textnon8).as("test data").isEqualTo("Non-Issue");
		String textsp8=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterEnvironmentSPVNonIssue4)).getText().trim();
		softly.assertThat(textsp8).as("test data").isEqualTo("Non-Issue");
	}

	public void checkTitleCount(WebDriver driver) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on Analysis on top
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
		//Click on Error Meter
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-em"))).click();
		//Check title count 
		checkTitleCountReset(driver);
		//Click on saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-btn-savedactivities"))).click();
		share2.loadingServer(driver);
		//Click on 1st record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-epm']/ul/li[2]/a"))).click();
		share2.loadingServer(driver);
	}
	public int getCharCountFromTitle(WebDriver driver) throws Exception {

		//Get count of characters
		String s = driver.findElement(emObj.JobTitleCharacterCount).getText().trim();
		s=s.substring(1,s.indexOf("/"));
		int count = Integer.parseInt(s);
		System.out.println(s+ " "+count);
		return count;
	}

	public void checkTitleCountReset(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Enter
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-job-title"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-job-title"))).sendKeys("aaaa");
		//Get count
		int count = getCharCountFromTitle(driver);
		if(count!=4)
			softly.fail("Count did not match: aaaa: " + count);
		//Clear text
		for(int i=0;i<4;i++)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-job-title"))).sendKeys(Keys.BACK_SPACE);
			Thread.sleep(250);
		}
		count = getCharCountFromTitle(driver);
		if(count!=1)
			softly.fail("Count did not match: aaaa: " + count);
	}

	public void reportCheck0(WebDriver driver) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Clicks on first newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-epm']/ul/li[2]/a"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		reportCheck0Dev(driver);
		//Error probability
		WebElement probability=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/table[3]/tbody/tr/td/strong")));
		String probabilityText = probability.getText().trim();
		System.out.println(probabilityText);
		softly.assertThat("0.00%").as("test data").isEqualTo(probabilityText.trim());	
		//Check the title count
		checkTitleCount(driver);
	}

	public void reportCheck50Dev (WebDriver driver) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,30);
		List<String> text = em2.error50Data(driver,driver.getCurrentUrl());
		int j=text.size()-1;
		//Compare Environment data
		//Supporting reasons
		String text1E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterEnvironmentSupportingReason1)).getText().trim();
		String r = text1E.replaceAll("\u00AD", "");
		softly.assertThat(r).as("test data").isEqualTo(text.get(j--));
		String text2E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterEnvironmentSupportingReason2)).getText().trim();
		softly.assertThat(text2E).as("test data").isEqualTo("");
		String text3E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterEnvironmentSupportingReason3)).getText().trim();
		softly.assertThat(text3E).as("test data").isEqualTo("");
		String text4E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterEnvironmentSupportingReason4)).getText().trim();
		String r1 = text4E.replaceAll("\u00AD", "");
		softly.assertThat(r1).as("test data").isEqualTo(text.get(j--));
		//Corrective actions
		String text5E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterEnvironmentCorrectiveAction1)).getText().trim();
		String r2 = text5E.replaceAll("\u00AD", "");
		softly.assertThat(r2).as("test data").isEqualTo(text.get(j--));    	
		String text6E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterEnvironmentCorrectiveAction2)).getText().trim();
		softly.assertThat(text6E).as("test data").isEqualTo("");    	
		String text7E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterEnvironmentCorrectiveAction3)).getText().trim();
		softly.assertThat(text7E).as("test data").isEqualTo("");    	
		String text8E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterEnvironmentCorrectiveAction4)).getText().trim();
		String r3 = text8E.replaceAll("\u00AD", "");
		softly.assertThat(r3).as("test data").isEqualTo(text.get(j--));


		//Compare People data
		//Supporting reasons
		String text9E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPeopleSupportingReason1)).getText().trim();
		softly.assertThat(text9E).as("test data").isEqualTo("");    	
		String text10E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPeopleSupportingReason2)).getText().trim();
		String r4 = text10E.replaceAll("\u00AD", "");
		softly.assertThat(r4).as("test data").isEqualTo(text.get(j--));    	
		String text11E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPeopleSupportingReason3)).getText().trim();
		String r5 = text11E.replaceAll("\u00AD", "");
		softly.assertThat(r5).as("test data").isEqualTo(text.get(j--));    	
		String text12E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPeopleSupportingReason4)).getText().trim();
		softly.assertThat(text12E).as("test data").isEqualTo("");    	
		//Corrective actions
		String text13E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPeopleCorrectiveAction1)).getText().trim();
		softly.assertThat(text13E).as("test data").isEqualTo("");    	
		String text14E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPeopleCorrectiveAction2)).getText().trim();
		String r6 = text14E.replaceAll("\u00AD", "");
		softly.assertThat(r6).as("test data").isEqualTo(text.get(j--));    	
		String text15E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPeopleCorrectiveAction3)).getText().trim();
		String r7 = text15E.replaceAll("\u00AD", "");
		softly.assertThat(r7).as("test data").isEqualTo(text.get(j--));    	
		String text16E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPeopleCorrectiveAction4)).getText().trim();
		softly.assertThat(text16E).as("test data").isEqualTo("");


		//Compare Activity data
		//Supporting reasons
		String text17E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterActivitySupportingReason1)).getText().trim();
		softly.assertThat(text17E).as("test data").isEqualTo("");    	
		String text18E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterActivitySupportingReason2)).getText().trim();
		String r8 = text18E.replaceAll("\u00AD", "");
		softly.assertThat(r8).as("test data").isEqualTo(text.get(j--));    	
		String text19E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterActivitySupportingReason3)).getText().trim();
		softly.assertThat(text19E).as("test data").isEqualTo("");    	
		String text20E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterActivitySupportingReason4)).getText().trim();
		String r9 = text20E.replaceAll("\u00AD", "");
		softly.assertThat(r9).as("test data").isEqualTo(text.get(j--));    	
		//Corrective actions
		String text21E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterActivityCorrectiveAction1)).getText().trim();
		softly.assertThat(text21E).as("test data").isEqualTo("");    	
		String text22E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterActivityCorrectiveAction2)).getText().trim();
		String r10 = text22E.replaceAll("\u00AD", "");
		softly.assertThat(r10).as("test data").isEqualTo(text.get(j--));    	
		String text23E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterActivityCorrectiveAction3)).getText().trim();
		softly.assertThat(text23E).as("test data").isEqualTo("");    	
		String text24E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterActivityCorrectiveAction4)).getText().trim();
		String r11 = text24E.replaceAll("\u00AD", "");
		softly.assertThat(r11).as("test data").isEqualTo(text.get(j--));    	

		//Compare Procedure data
		//Supporting reasons
		String text25E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterProcedureSupportingReason1)).getText().trim();
		String r12 = text25E.replaceAll("\u00AD", "");
		softly.assertThat(r12).as("test data").isEqualTo(text.get(j--));    	
		String text26E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterProcedureSupportingReason2)).getText().trim();
		softly.assertThat(text26E).as("test data").isEqualTo("");    	
		String text27E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterProcedureSupportingReason3)).getText().trim();
		String r13 = text27E.replaceAll("\u00AD", "");
		softly.assertThat(r13).as("test data").isEqualTo(text.get(j--));    	
		String text28E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterProcedureSupportingReason4)).getText().trim();
		softly.assertThat(text28E).as("test data").isEqualTo("");    	
		//Corrective actions
		String text29E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterProcedureCorrectiveAction1)).getText().trim();
		String r14 = text29E.replaceAll("\u00AD", "");
		softly.assertThat(r14).as("test data").isEqualTo(text.get(j--));    	
		String text30E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterProcedureCorrectiveAction2)).getText().trim();
		softly.assertThat(text30E).as("test data").isEqualTo("");    	
		String text31E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterProcedureCorrectiveAction3)).getText().trim();
		String r15 = text31E.replaceAll("\u00AD", "");
		softly.assertThat(r15).as("test data").isEqualTo(text.get(j--));    	
		String text32E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterProcedureCorrectiveAction4)).getText().trim();
		softly.assertThat(text32E).as("test data").isEqualTo("");

		//Checks for Non issue
		//Procedure
		String textsp1=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterProcedureSPVNonIssue1)).getText().trim();
		softly.assertThat(textsp1).as("test data").isEqualTo("SPV");
		String textnon1=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterProcedureSPVNonIssue2)).getText().trim();
		softly.assertThat(textnon1).as("test data").isEqualTo("Non-Issue");
		String textsp2=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterProcedureSPVNonIssue3)).getText().trim();
		softly.assertThat(textsp2).as("test data").isEqualTo("SPV");
		String textnon2=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterProcedureSPVNonIssue4)).getText().trim();
		softly.assertThat(textnon2).as("test data").isEqualTo("Non-Issue");

		//Activity
		String textnon3=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterActivitySPVNonIssue1)).getText().trim();
		softly.assertThat(textnon3).as("test data").isEqualTo("Non-Issue");
		String textsp3=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterActivitySPVNonIssue2)).getText().trim();
		softly.assertThat(textsp3).as("test data").isEqualTo("SPV");
		String textnon4=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterActivitySPVNonIssue3)).getText().trim();
		softly.assertThat(textnon4).as("test data").isEqualTo("Non-Issue");
		String textsp4=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterActivitySPVNonIssue4)).getText().trim();
		softly.assertThat(textsp4).as("test data").isEqualTo("SPV");

		//People
		String textnon5=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPeopleSPVNonIssue1)).getText().trim();
		softly.assertThat(textnon5).as("test data").isEqualTo("Non-Issue");
		String textsp5=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPeopleSPVNonIssue2)).getText().trim();
		softly.assertThat(textsp5).as("test data").isEqualTo("SPV");
		String textsp6=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPeopleSPVNonIssue3)).getText().trim();
		softly.assertThat(textsp6).as("test data").isEqualTo("SPV");
		String textnon6=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPeopleSPVNonIssue4)).getText().trim();
		softly.assertThat(textnon6).as("test data").isEqualTo("Non-Issue");

		//Environment
		String textsp7=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterEnvironmentSPVNonIssue1)).getText().trim();
		softly.assertThat(textsp7).as("test data").isEqualTo("SPV");
		String textnon7=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterEnvironmentSPVNonIssue2)).getText().trim();
		softly.assertThat(textnon7).as("test data").isEqualTo("Non-Issue");
		String textnon8=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterEnvironmentSPVNonIssue3)).getText().trim();
		softly.assertThat(textnon8).as("test data").isEqualTo("Non-Issue");
		String textsp8=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterEnvironmentSPVNonIssue4)).getText().trim();
		softly.assertThat(textsp8).as("test data").isEqualTo("SPV");
	}

	public void reportCheck50(WebDriver driver) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Clicks on first newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-epm']/ul/li[2]/a"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		reportCheck50Dev(driver);
		//Error probability
		WebElement probability=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/table[3]/tbody/tr/td/strong")));
		String probabilityText = probability.getText().trim();
		System.out.println(probabilityText);
		softly.assertThat("50.00%").as("test data").isEqualTo(probabilityText);		
	}

	public void reportCheck100Dev (WebDriver driver) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,30);
		List<String> text = em2.error100Data(driver,driver.getCurrentUrl());
		int j=text.size()-1;
		//Compare Environment data
		//Supporting reasons
		String text1E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterEnvironmentSupportingReason1)).getText().trim();
		String r = text1E.replaceAll("\u00AD", "");
		softly.assertThat(r).as("test data").isEqualTo(text.get(j--));
		String text2E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterEnvironmentSupportingReason2)).getText().trim();
		String r18 = text2E.replaceAll("\u00AD", "");
		softly.assertThat(r18).as("test data").isEqualTo(text.get(j--));
		String text3E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterEnvironmentSupportingReason3)).getText().trim();
		String r19 = text3E.replaceAll("\u00AD", "");
		softly.assertThat(r19).as("test data").isEqualTo(text.get(j--));
		String text4E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterEnvironmentSupportingReason4)).getText().trim();
		String r1 = text4E.replaceAll("\u00AD", "");
		softly.assertThat(r1).as("test data").isEqualTo(text.get(j--));
		//Corrective actions
		String text5E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterEnvironmentCorrectiveAction1)).getText().trim();
		String r2 = text5E.replaceAll("\u00AD", "");
		softly.assertThat(r2).as("test data").isEqualTo(text.get(j--));    	
		String text6E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterEnvironmentCorrectiveAction2)).getText().trim();
		String r20 = text6E.replaceAll("\u00AD", "");
		softly.assertThat(r20).as("test data").isEqualTo(text.get(j--));    	
		String text7E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterEnvironmentCorrectiveAction3)).getText().trim();
		String r21 = text7E.replaceAll("\u00AD", "");
		softly.assertThat(r21).as("test data").isEqualTo(text.get(j--));    	
		String text8E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterEnvironmentCorrectiveAction4)).getText().trim();
		String r3 = text8E.replaceAll("\u00AD", "");
		softly.assertThat(r3).as("test data").isEqualTo(text.get(j--));


		//Compare People data
		//Supporting reasons
		String text9E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPeopleSupportingReason1)).getText().trim();
		String r22 = text9E.replaceAll("\u00AD", "");
		softly.assertThat(r22).as("test data").isEqualTo(text.get(j--));    	
		String text10E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPeopleSupportingReason2)).getText().trim();
		String r4 = text10E.replaceAll("\u00AD", "");
		softly.assertThat(r4).as("test data").isEqualTo(text.get(j--));    	
		String text11E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPeopleSupportingReason3)).getText().trim();
		String r5 = text11E.replaceAll("\u00AD", "");
		softly.assertThat(r5).as("test data").isEqualTo(text.get(j--));    	
		String text12E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPeopleSupportingReason4)).getText().trim();
		String r23 = text12E.replaceAll("\u00AD", "");
		softly.assertThat(r23).as("test data").isEqualTo(text.get(j--));    	
		//Corrective actions
		String text13E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPeopleCorrectiveAction1)).getText().trim();
		String r24 = text13E.replaceAll("\u00AD", "");
		softly.assertThat(r24).as("test data").isEqualTo(text.get(j--));    	
		String text14E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPeopleCorrectiveAction2)).getText().trim();
		String r6 = text14E.replaceAll("\u00AD", "");
		softly.assertThat(r6).as("test data").isEqualTo(text.get(j--));    	
		String text15E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPeopleCorrectiveAction3)).getText().trim();
		String r7 = text15E.replaceAll("\u00AD", "");
		softly.assertThat(r7).as("test data").isEqualTo(text.get(j--));    	
		String text16E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPeopleCorrectiveAction4)).getText().trim();
		String r25 = text16E.replaceAll("\u00AD", "");
		softly.assertThat(r25).as("test data").isEqualTo(text.get(j--));


		//Compare Activity data
		//Supporting reasons
		String text17E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterActivitySupportingReason1)).getText().trim();
		String r26 = text17E.replaceAll("\u00AD", "");
		softly.assertThat(r26).as("test data").isEqualTo(text.get(j--));    	
		String text18E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterActivitySupportingReason2)).getText().trim();
		String r8 = text18E.replaceAll("\u00AD", "");
		softly.assertThat(r8).as("test data").isEqualTo(text.get(j--));    	
		String text19E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterActivitySupportingReason3)).getText().trim();
		String r27 = text19E.replaceAll("\u00AD", "");
		softly.assertThat(r27).as("test data").isEqualTo(text.get(j--));    	
		String text20E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterActivitySupportingReason4)).getText().trim();
		String r9 = text20E.replaceAll("\u00AD", "");
		softly.assertThat(r9).as("test data").isEqualTo(text.get(j--));    	
		//Corrective actions
		String text21E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterActivityCorrectiveAction1)).getText().trim();
		String r28 = text21E.replaceAll("\u00AD", "");
		softly.assertThat(r28).as("test data").isEqualTo(text.get(j--));    	
		String text22E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterActivityCorrectiveAction2)).getText().trim();
		String r10 = text22E.replaceAll("\u00AD", "");
		softly.assertThat(r10).as("test data").isEqualTo(text.get(j--));    	
		String text23E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterActivityCorrectiveAction3)).getText().trim();
		String r29 = text23E.replaceAll("\u00AD", "");
		softly.assertThat(r29).as("test data").isEqualTo(text.get(j--));    	
		String text24E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterActivityCorrectiveAction4)).getText().trim();
		String r11 = text24E.replaceAll("\u00AD", "");
		softly.assertThat(r11).as("test data").isEqualTo(text.get(j--));    	

		//Compare Procedure data
		//Supporting reasons
		String text25E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterProcedureSupportingReason1)).getText().trim();
		String r12 = text25E.replaceAll("\u00AD", "");
		softly.assertThat(r12).as("test data").isEqualTo(text.get(j--));    	
		String text26E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterProcedureSupportingReason2)).getText().trim();
		String r30 = text26E.replaceAll("\u00AD", "");
		softly.assertThat(r30).as("test data").isEqualTo(text.get(j--));    	
		String text27E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterProcedureSupportingReason3)).getText().trim();
		String r13 = text27E.replaceAll("\u00AD", "");
		softly.assertThat(r13).as("test data").isEqualTo(text.get(j--));    	
		String text28E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterProcedureSupportingReason4)).getText().trim();
		String r31 = text28E.replaceAll("\u00AD", "");
		softly.assertThat(r31).as("test data").isEqualTo(text.get(j--));    	
		//Corrective actions
		String text29E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterProcedureCorrectiveAction1)).getText().trim();
		String r14 = text29E.replaceAll("\u00AD", "");
		softly.assertThat(r14).as("test data").isEqualTo(text.get(j--));    	
		String text30E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterProcedureCorrectiveAction2)).getText().trim();
		String r17 = text30E.replaceAll("\u00AD", "");
		softly.assertThat(r17).as("test data").isEqualTo(text.get(j--));    	
		String text31E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterProcedureCorrectiveAction3)).getText().trim();
		String r15 = text31E.replaceAll("\u00AD", "");
		softly.assertThat(r15).as("test data").isEqualTo(text.get(j--));    	
		String text32E=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterProcedureCorrectiveAction4)).getText().trim();
		String r16 = text32E.replaceAll("\u00AD", "");
		softly.assertThat(r16).as("test data").isEqualTo(text.get(j--));

		//Checks for Non issue
		//Procedure
		String textsp1=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterProcedureSPVNonIssue1)).getText().trim();
		softly.assertThat(textsp1).as("test data").isEqualTo("SPV");
		String textnon1=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterProcedureSPVNonIssue2)).getText().trim();
		softly.assertThat(textnon1).as("test data").isEqualTo("SPV");
		String textsp2=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterProcedureSPVNonIssue3)).getText().trim();
		softly.assertThat(textsp2).as("test data").isEqualTo("SPV");
		String textnon2=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterProcedureSPVNonIssue4)).getText().trim();
		softly.assertThat(textnon2).as("test data").isEqualTo("SPV");

		//Activity
		String textnon3=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterActivitySPVNonIssue1)).getText().trim();
		softly.assertThat(textnon3).as("test data").isEqualTo("SPV");
		String textsp3=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterActivitySPVNonIssue2)).getText().trim();
		softly.assertThat(textsp3).as("test data").isEqualTo("SPV");
		String textnon4=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterActivitySPVNonIssue3)).getText().trim();
		softly.assertThat(textnon4).as("test data").isEqualTo("SPV");
		String textsp4=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterActivitySPVNonIssue4)).getText().trim();
		softly.assertThat(textsp4).as("test data").isEqualTo("SPV");

		//People
		String textnon5=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPeopleSPVNonIssue1)).getText().trim();
		softly.assertThat(textnon5).as("test data").isEqualTo("SPV");
		String textsp5=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPeopleSPVNonIssue2)).getText().trim();
		softly.assertThat(textsp5).as("test data").isEqualTo("SPV");
		String textsp6=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPeopleSPVNonIssue3)).getText().trim();
		softly.assertThat(textsp6).as("test data").isEqualTo("SPV");
		String textnon6=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPeopleSPVNonIssue4)).getText().trim();
		softly.assertThat(textnon6).as("test data").isEqualTo("SPV");

		//Environment
		String textsp7=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterEnvironmentSPVNonIssue1)).getText().trim();
		softly.assertThat(textsp7).as("test data").isEqualTo("SPV");
		String textnon7=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterEnvironmentSPVNonIssue2)).getText().trim();
		softly.assertThat(textnon7).as("test data").isEqualTo("SPV");
		String textnon8=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterEnvironmentSPVNonIssue3)).getText().trim();
		softly.assertThat(textnon8).as("test data").isEqualTo("SPV");
		String textsp8=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterEnvironmentSPVNonIssue4)).getText().trim();
		softly.assertThat(textsp8).as("test data").isEqualTo("SPV");
	}

	public void reportCheck100(WebDriver driver) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Clicks on first newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-epm']/ul/li[2]/a"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		reportCheck100Dev(driver);
		//Error probability
		WebElement probability=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/table[3]/tbody/tr/td/strong")));
		String probabilityText = probability.getText().trim();
		System.out.println(probabilityText);
		softly.assertThat("100.00%").as("test data").isEqualTo(probabilityText);		
	}



	public void shareReport(WebDriver driver,String username, String password1,int y ) throws Exception{

		WebDriverWait wait1 = new WebDriverWait(driver,60);
		String sharer = em3.decideSharer (y);
		String sharerAdded = em3.decideSharerAdded (y);
		//Clicks on share button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[3]"))).click();
		//Enters username
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-uhshare-search-input"))).sendKeys(sharer);
		Thread.sleep(500);
		//Selects from dropdown
		WebElement dropdown = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhshare-blocks']/div[2]/ul")));
		dropdown.findElement(By.cssSelector(".ui-first-child")).click();
		//Clicks on add user
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		//Verifies user added
		String user=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhshare-blocks']/div/form/div/ul/li/a"))).getText().trim();
		softly.assertThat(user).as("test data").isEqualTo(sharerAdded);
		Thread.sleep(3000);
		share.shareTwice (driver,softly);
		//Clicks on save
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ShareSaveButton)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Checks the username of creator and shared with
		WebElement creator = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/table/tbody/tr/td")));
		String creatorUsername= creator.getText().trim();
		System.out.println(creatorUsername);
		softly.assertThat(username).as("test data").isSubstringOf(creatorUsername);
		WebElement sharedTo=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/table/tbody/tr[2]/td/span")));
		String sharedToUsername = sharedTo.getText().trim();
		System.out.println(sharedToUsername);
		softly.assertThat(sharer).as("test data").isEqualTo(sharedToUsername);
		WebElement shared=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/table/tbody/tr[2]/td/strong")));
		String sharedText = shared.getText().trim();
		System.out.println(sharedText);
		softly.assertThat("Shared with:").as("test data").isEqualTo(sharedText.trim());
		//Click back
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.BackButton)).click();
		share2.loadingServer(driver);
		//Verify Share icon
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-epm']/ul/li[2]/a/span[1]")));
		//Calls the Share check function
		share.receiptReport(driver, sharer, username, password1);
		//Clicks on Error Meter side panel
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-epm"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-epm']/ul/li[2]/a"))).click();
	}

	public void markCritical(WebDriver driver,String username, String password1,int y) throws Exception{

		WebDriverWait wait1 = new WebDriverWait(driver,60);
		//Clicks on mark critical
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div[2]/div/label"))).click();
		//Clicks on confirm change
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		//Checks if marked critical
		String critical=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/table[2]/tbody/tr/th/strong"))).getText().trim();
		softly.assertThat(critical).as("test data").contains("Critical");
		if(driver.findElement(By.xpath(".//*[@id='epm-rpt']/table[2]/tbody/tr/th/strong")).isDisplayed())
			System.out.println("Marked critical");
		//Click back
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.BackButton)).click();
		share2.loadingServer(driver);
		//Verify Marked critical icon
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-epm']/ul/li[2]/a/span[1]")));
		//Verify presence of shared icon 
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-epm']/ul/li[2]/a/span[2]")));
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-epm']/ul/li[2]/a"))).click();
		share2.loadingServer(driver);
		//Clicks on mark critical again
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div[2]/div/label"))).click();
		//Clicks on confirm change
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		Thread.sleep(2000);
		if(driver.findElement(By.xpath(".//*[@id='epm-rpt']/table[2]/tbody/tr/th/strong")).isDisplayed()==false)
		{
			System.out.println("Unmarked critical");
		}
		//Verify report not retrieved by shared to person
		String sharer = em3.decideSharer (y);
		share.checkCriticalNotification(driver, sharer, username, password1, softly);		
		//Clicks on Error meter side panel
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-epm"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-epm']/ul/li[2]/a"))).click();	
	}

	public void deleteNewRecord(WebDriver driver, String recordName,  int y) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,10);
		//CLicks on first newly created record
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-epm']/ul/li[2]/a"))).click();
		//Clicks on delete button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title")));
		//Clicks on delete report
		driver.findElement(By.id("pii-user-home-dialog-confirmed")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-epm"))).click();
		//Verify record deleted
		//Click on 1st record
		Thread.sleep(2000);
		String name = driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-epm']/ul/li[2]/a")).getText().trim();
		System.out.println(name);
		if (name!=recordName)
			System.out.println("Record deleted");
		else
			System.out.println("Record could not be deleted");		  
		//Verify report not retrieved by shared to person
		String sharer = em3.decideSharer (y);
		share.checkNoReportAfterDelete(driver, sharer, softly);	  
	}  

	public String saveReport(WebDriver driver, String username) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		String text = eirca2.textCreate(driver);
		Thread.sleep(2000);
		//Click on finalize
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-btn-done"))).click();
		Thread.sleep(2000);
		//Click on finalize and save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-dialog-confirmed"))).click(); 
		//Waits for the green popup on the right top corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		share2.loadingServer(driver);
		//Creates expected record name
		String date= driver.findElement(By.xpath(".//*[@id='epm-rpt']/table/tbody/tr/td[2]")).getText().trim();
		date = date.substring(14);
		String time = driver.findElement(By.xpath(".//*[@id='epm-rpt']/table/tbody/tr[2]/td[2]")).getText().trim();
		time = time.substring(14);
		String time2 = time.substring(0, 8);
		String time1=time.substring(9);
		String purpose = driver.findElement(By.xpath(".//*[@id='epm-rpt']/div/div/span/abbr")).getText().trim();
		String name = date + "_" + time2+"_"+time1 + "_" + username +"_" + purpose + "_" + text;
		System.out.println ("Expected name of record: " +name);
		//Clicks on side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterSidePanel)).click();
		share2.loadingServer(driver);
		//Gets the name of the record created
		WebElement record = driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-epm']/ul/li[2]/a"));
		String recordName = record.getText().trim();
		String r = recordName.replaceAll("\u00AD", "");
		if (record.isDisplayed())
		{
			System.out.println("Record found: "+ r);
		}
		else
			System.out.println ("Record not found.");
		//Checks if the record name is correct
		softly.assertThat(r).as("test data").isEqualTo(name);
		return r;
	}

	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}
}