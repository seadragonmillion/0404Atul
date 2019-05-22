package kaleTestSoftware;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class ErrorMeter3 {

	ErrorMeter2 em2 = new ErrorMeter2 ();
	ErrorMeterPageObj emObj = new ErrorMeterPageObj();

	public void clickElementForSafariBrowser (WebDriver driver, By locator) throws Exception {		

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
	}
	
	public void verifyCheckBoxChecked (WebDriver driver, By locator) throws Exception {		

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		while(true)
		{
			Thread.sleep(500);
			if(wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isSelected())
				break;
			Thread.sleep(1000);
			executor.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
			executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
			Thread.sleep(1000);
		}	
		System.out.println("done");
	}

	public void verifyCheckBoxNotChecked (WebDriver driver, By locator) throws Exception {		

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		while(true)
		{
			Thread.sleep(500);
			if(wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isSelected()==false)
				break;
			executor.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
			executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
			Thread.sleep(1000);
		}		
		System.out.println("done2");
	}

	public String decideSharer (int y) throws Exception{

		/* Dev/Asia
		 * 0=admin
		 * 1=non admin
		 * 2= admin ie11
		 * 3= non admin ie11
		 * US
		 * 4=admin
		 * 5=non admin
		 * 6=admin ie11
		 * 7=non admin ie11
		 */
		if(y==0)
		{
			String sharer ="qaasharer";
			return sharer;
		}
		if(y==1)
		{
			String sharer ="qaasharernonadmin";
			return sharer;
		}
		if(y==2)
		{
			String sharer ="qaasharerie11";
			return sharer;
		}
		if(y==3)
		{
			String sharer ="qaasharernonadminie11";
			return sharer;
		}
		if(y==4)
		{
			String sharer ="qaasharerus";
			return sharer;
		}
		if(y==5)
		{
			String sharer ="qaasharernonadminus";
			return sharer;
		}
		if(y==6)
		{
			String sharer ="qaasharerusie11";
			return sharer;
		}
		else
		{
			String sharer ="qaasharernonadminusie11";
			return sharer;
		}

	}

	public String decideSharerAdded (int y) throws Exception{

		/* Dev/Asia
		 * 0=admin
		 * 1=non admin
		 * 2= admin ie11
		 * 3= non admin ie11
		 * US
		 * 4=admin
		 * 5=non admin
		 * 6=admin ie11
		 * 7=non admin ie11
		 */
		if(y==0)
		{
			String sharer ="QAA (qaasharer)";
			return sharer;
		}
		if(y==1)
		{
			String sharer ="QAA (qaasharernonadmin)";
			return sharer;
		}
		if(y==2)
		{
			String sharer ="QAA (qaasharerie11)";
			return sharer;
		}
		if(y==3)
		{
			String sharer ="QAA (qaasharernonadminie11)";
			return sharer;
		}
		if(y==4)
		{
			String sharer ="QAA (qaasharerus)";
			return sharer;
		}
		if(y==5)
		{
			String sharer ="QAA (qaasharernonadminus)";
			return sharer;
		}
		if(y==6)
		{
			String sharer ="QAA (qaasharerusie11)";
			return sharer;
		}
		else
		{
			String sharer ="QAA (qaasharernonadminusie11)";
			return sharer;
		}
	}
	
	public void verifyChangeOfTabTitleWhenScreenIsSmall(WebDriver driver, SoftAssertions softly) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Set new size to make it small
		driver.manage().window().setSize(new Dimension(650,900));
		//Verify tab titles
		//E
		String e = wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentTab)).getText();
		softly.assertThat(e).as("test data").isEqualTo("E");
		//P
		String pr = wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleTab)).getText();
		softly.assertThat(pr).as("test data").isEqualTo("P");
		//A
		String a = wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityTab)).getText();
		softly.assertThat(a).as("test data").isEqualTo("A");
		//P
		String p = wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureTab)).getText();
		softly.assertThat(p).as("test data").isEqualTo("P");
		//Set window to maximise
		driver.manage().window().maximize();
		//softly.assertAll();
	}
}