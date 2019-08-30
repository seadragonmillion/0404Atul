package kaleTestSoftware;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JobObservation2 {

	JobObservationObj jo = new JobObservationObj();
	
	public void verifyErrorOnPage (WebDriver driver, SoftAssertions softly) throws Exception{
		
		//Clicks next
		if(driver.getCurrentUrl().contains("kaleqa"))
			driver.findElement(jo.JOStep1NextButton).click();
		else
			driver.findElement(By.xpath(".//*[@id='pii-joa-tab-1-form']/div[6]/div/button")).click();
		//Verify all errors
		String observerError = driver.findElement(jo.Step1ObserverError).getText();
		softly.assertThat(observerError).as("test data").isEqualTo("Observer is required");
		String locationError = driver.findElement(jo.Step1LocationError).getText();
		softly.assertThat(locationError).as("test data").isEqualTo("Location is required");
		String jobObsError = driver.findElement(jo.Step1JobObservedError).getText();
		softly.assertThat(jobObsError).as("test data").isEqualTo("Job is required");
		//softly.assertAll();
	}

}
