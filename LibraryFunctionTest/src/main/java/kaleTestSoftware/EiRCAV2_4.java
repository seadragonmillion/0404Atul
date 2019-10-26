package kaleTestSoftware;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EiRCAV2_4 {

	EiRCAV2PageObj eirca = new EiRCAV2PageObj();
	ShareCheck2 share2 = new ShareCheck2();
	LoginPageObj login = new LoginPageObj();
	
	public List<String> EiRCAStep3 (WebDriver driver, SoftAssertions softly, String text) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		List<String> step3 = new ArrayList<String>();
		

		//next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
		return step3;
	}
	
	public void EiRCAStep6 (WebDriver driver, SoftAssertions softly, String text) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		Random random = new Random();
		//Click on collapsible
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step6FailureMode1Collapsible)).click();
		//Select Analysis type
		WebElement analysis = driver.findElement(eirca.Step6FailureMode1AnalysisDropdown);
		Select s = new Select(analysis);
		int n = random.nextInt(3);
		s.selectByValue(String.valueOf(n));
		//Fill Analysis text
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step6FailureMode1AnalysisTextbox)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step6FailureMode1AnalysisTextbox)).sendKeys(text);
		//Fill Component
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step6FailureMode1ComponentTextbox)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step6FailureMode1ComponentTextbox)).sendKeys(text);		
		//Click add
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step6FailureMode1AddAnalysisButton)).click();
		//Verify the added analysis in table
		//Analysis type
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step6FailureMode1AddedAnalysisTypeRow1)).getText();
		if(n==0)
			softly.assertThat(s1).as("test data").isEqualTo("Cause-effect analysis");
		if(n==1)
			softly.assertThat(s1).as("test data").isEqualTo("Severity analysis");
		if(n==2)
			softly.assertThat(s1).as("test data").isEqualTo("Age dating analysis");
		//Analysis
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step6FailureMode1AddedAnalysisTextRow1)).getAttribute("value");
		softly.assertThat(s2).as("test data").isEqualTo(text);
		//Component
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step6FailureMode1AddedComponentTextRow1)).getAttribute("value");
		softly.assertThat(s3).as("test data").isEqualTo(text);
		//Verify error if no analysis type selected
		//Click add
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step6FailureMode1AddAnalysisButton)).click();
		String errorWarning = wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyNote)).getText();
		softly.assertThat(errorWarning).as("test data").isEqualTo("Warning: cannot add an empty analysis.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyClose)).click();
		//Add another analysis
		//Select Analysis type
		WebElement analysis1 = driver.findElement(eirca.Step6FailureMode1AnalysisDropdown);
		Select se = new Select(analysis1);
		int n1 = random.nextInt(3);
		se.selectByValue(String.valueOf(n1));
		//Fill Analysis text
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step6FailureMode1AnalysisTextbox)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step6FailureMode1AnalysisTextbox)).sendKeys(text);
		//Fill Component
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step6FailureMode1ComponentTextbox)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step6FailureMode1ComponentTextbox)).sendKeys(text);		
		//Click add
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step6FailureMode1AddAnalysisButton)).click();
		//Delete 2nd analysis
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step6FailureMode1AddedAnalysisDeleteButtonRow2)).click();
		//Verify pop up header
		String p = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupHeader)).getText();
		softly.assertThat(p).as("test data").isEqualTo("Delete");
		//Verify question on pop up
		String p1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupTitle)).getText();
		softly.assertThat(p1).as("test data").isEqualTo("Are you sure you want to delete the analysis:");
		//Note
		String p4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopUpMessageNote)).getText();
		if(n1==0)
			softly.assertThat(p4).as("test data").isEqualTo("Leading-following differential analysis: Cause-effect analysis, analysis: "+text);
		if(n1==1)
			softly.assertThat(p4).as("test data").isEqualTo("Leading-following differential analysis: Severity analysis, analysis: "+text);
		if(n1==2)
			softly.assertThat(p4).as("test data").isEqualTo("Leading-following differential analysis: Age dating analysis, analysis: "+text);
		//Cancel button
		String p2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupCancelButton)).getText();
		softly.assertThat(p2).as("test data").isEqualTo("cancel");
		//delete button
		String p3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupConfirmButton)).getText();
		softly.assertThat(p3).as("test data").isEqualTo("Delete");
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupConfirmButton)).click();
		//Scroll to the top
		share2.scrollToTop(driver);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();	
	}

	public int EiRCAStep5 (WebDriver driver, SoftAssertions softly, String text) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Thread.sleep(1000);
		//Click on collapsible
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step5FailureCollapsible)).click();
		//Choose a number between 0 to 5
		Random random = new Random();
		int n = random.nextInt(6);
		//Fill text in Step 5
		n = 0;
		Thread.sleep(1000);
		if(n==0)
		{
			System.out.println("No failure modes are refuted.");
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();	
			return n;
		}
		//Select options in Step 5
		for(int i=1;i<=n;i++)
		{
			if(i==1)
			{
				//Click on check box for 5.1
				wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step5TableOption51CheckBox)).click();	
				wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step5TableOption51Textbox)).sendKeys(text);
			}
			if(i==2)
			{
				//Click on check box for 5.2
				share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step5TableOption52CheckBox)));
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step5TableOption52CheckBox)));
				wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step5TableOption52Textbox)).sendKeys(text);
			}
			if(i==3)
			{
				//Click on check box for 5.3
				share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step5TableOption53CheckBox)));
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step5TableOption53CheckBox)));	
				wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step5TableOption53Textbox)).sendKeys(text);
			}
			if(i==4)
			{
				//Click on check box for 5.4
				share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step5TableOption54CheckBox)));
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step5TableOption54CheckBox)));
				wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step5TableOption54Textbox)).sendKeys(text);
			}
			if(i==5)
			{
				//Click on check box for 5.5
				share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step5TableOption55CheckBox)));
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step5TableOption55CheckBox)));	
				wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step5TableOption55Textbox)).sendKeys(text);
			}   		
		}
		//Scroll to the top
		share2.scrollToTop(driver);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();	
		//Click on see report
		//wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupCancelButton)).click();	
		return n;
	}

	public List<String> EiRCAStep4 (WebDriver driver, SoftAssertions softly, String text) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		List<String> step4 = new ArrayList<String>();
		/*Clear methods function will be called when the methods have to be cleared before adding new fm
		 * For now since there is a bug
		 * */
		//Verify error in add new failure mode block
		verifyErrorInAddFailureModeBlock(driver,softly);
		//Check for error in added failure mode
		verifyErrorOnLastFailureMode(driver,softly,text);
		//Add a failure mode with 4 methods
		step4.addAll(addFailureMode(driver,4,text+"1"));
		//Add a failure mode with 3 methods
		step4.addAll(addFailureMode(driver,3,text+"2"));
		//Add a failure mode with 2 methods
		step4.addAll(addFailureMode(driver,2,text+"3"));
		//Add a failure mode with 1 method
		step4.addAll(addFailureMode(driver,1,text+"4"));
		//Add a failure mode with 1 method
		addFailureMode(driver,1,text+"4");
		share2.loadingServer(driver);
		//Delete last failure mode
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureModeTableRow5DeleteButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupConfirmButton)).click();
		share2.loadingServer(driver);
		//Verify added failure modes
		verifyFailureModesAdded(driver,softly,step4);
		//next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
		return step4;
	}

	public void verifyErrorOnLastFailureMode(WebDriver driver, SoftAssertions softly, String text) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Add a failure mode
		addFailureMode(driver,1,text);
		//Delete failure mode text
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureModeTableRow1FailureModeText)).clear();
		share2.loadingServer(driver);
		//Click on description
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureModeTableRow1DescriptionText)).click();
		//Verify error
		String errorWarning = wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyNote)).getText();
		softly.assertThat(errorWarning).as("test data").isEqualTo("Please fix all errors mentioned in red.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyClose)).click();
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureModeTableRow1ErrorMessageLine1)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Failure mode is not specified");
		//Uncheck methods
		uncheckMethodInAddedFailureMode(driver);
		//Verify error
		String errorWarning1 = wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyNote)).getText();
		softly.assertThat(errorWarning1).as("test data").isEqualTo("Please fix all errors mentioned in red.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyClose)).click();
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureModeTableRow1ErrorMessageLine1)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Method is not specified");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureModeTableRow1ErrorMessageLine2)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Failure mode is not specified");
		//Enter fm text
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureModeTableRow1FailureModeText)).sendKeys(text);
		//Click on description
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureModeTableRow1DescriptionText)).click();
		//Verify error
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureModeTableRow1ErrorMessageLine1)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("Method is not specified");
		//Delete failure mode
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureModeTableRow1DeleteButton)).click();
		}catch(org.openqa.selenium.StaleElementReferenceException r){
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureModeTableRow1DeleteButton)).click();
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupConfirmButton)).click();
		share2.loadingServer(driver);
	}
	
	public void clearMethodsInAddedFailureMode(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		share2.scrollToElement(driver, driver.findElement(eirca.Step4FailureModeTableRow1MethodsSelectMenu));
		for(int i=1;i<=4;i++)
		{
			try{
			WebElement menu = driver.findElement(eirca.Step4FailureModeTableRow1MethodsSelectMenu);
			String s = menu.findElement(By.xpath(".//*[@data-option-index='"+i+"']/a")).getAttribute("class");
			if(s.contains("ui-checkbox-on"))
				menu.findElement(By.xpath(".//*[@data-option-index='"+i+"']/a")).click();
			}catch(org.openqa.selenium.StaleElementReferenceException r){
				wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureModeTableRow1MethodsButton)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureModeTableRow1MethodsPopup));		
				WebElement menu = driver.findElement(eirca.Step4FailureModeTableRow1MethodsSelectMenu);
				String s = menu.findElement(By.xpath(".//*[@data-option-index='"+i+"']/a")).getAttribute("class");
				if(s.contains("ui-checkbox-on"))
					menu.findElement(By.xpath(".//*[@data-option-index='"+i+"']/a")).click();
			}
		}
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureModeTableRow1MethodsCloseButton)).click();
		}catch(org.openqa.selenium.TimeoutException r){
			
		}
	}

	public void uncheckMethodInAddedFailureMode(WebDriver driver) throws Exception{ 

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Get browser name
		//Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		//String browserName = cap.getBrowserName().toLowerCase();
		//String v = cap.getVersion().toString();
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureModeTableRow1MethodsButton)));
		/*if (browserName.contains("internet")==true)
		{
			if (v.startsWith("10")==true)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureModeTableRow1MethodsButton)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureModeTableRow1MethodsButton)).sendKeys(Keys.ENTER);
			}
			if (v.startsWith("11")==true)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureModeTableRow1MethodsButton)).click();
			}
		}
		else{*/
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureModeTableRow1MethodsButton)).click();
		//}
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureModeTableRow1MethodsPopup));	
		//Clear
		clearMethodsInAddedFailureMode(driver);/*
		WebElement menu = driver.findElement(eirca.Step4FailureModeTableRow1MethodsSelectMenu);
		for(int i=1;i<=x;i++)
		{
			menu.findElement(By.xpath(".//*[@data-option-index='"+i+"']/a")).click();
		}
		try{
			driver.findElement(eirca.Step4FailureModeTableRow1CloseButton).click();
		}catch (NoSuchElementException | ElementNotInteractableException e)
		{
			driver.findElement(eirca.Step4FailureModeTableRow1CloseButton).click();
		}	*/	
	}

	public void verifyErrorInAddFailureModeBlock(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Click add failure mode
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4NewFailureModeAddButton)).click();
		//Verify error popup
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Cannot Add");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Cannot add until the following error(s) are fixed:");
		//Verify note on pop up for 2 errors
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupNotePoint1)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Failure mode title is required");
		String s4a = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupNotePoint2)).getText();
		softly.assertThat(s4a).as("test data").isEqualTo("Method(s) has not been selected");
		//ok button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupConfirmButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("ok");
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupConfirmButton)).click();
		//Fill failure mode
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4NewFailureModeTextBox)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4NewFailureModeTextBox)).sendKeys("to test error");
		//Click add failure mode
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4NewFailureModeAddButton)).click();
		//Verify error popup
		//Verify pop up header
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupHeader)).getText();
		softly.assertThat(s5).as("test data").isEqualTo("Cannot Add");
		//Verify question on pop up
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupTitle)).getText();
		softly.assertThat(s6).as("test data").isEqualTo("Cannot add until the following error(s) are fixed:");
		//Verify note on pop up for 2 errors
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupNotePoint1)).getText();
		softly.assertThat(s7).as("test data").isEqualTo("Method(s) has not been selected");
		//ok button
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupConfirmButton)).getText();
		softly.assertThat(s8).as("test data").isEqualTo("ok");
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupConfirmButton)).click();
		//Clear fm text
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4NewFailureModeTextBox)).clear();
		//Select method
		selectRandomMethods(driver,1);
		//Click add failure mode
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4NewFailureModeAddButton)).click();
		//Verify error popup
		//Verify pop up header
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupHeader)).getText();
		softly.assertThat(s9).as("test data").isEqualTo("Cannot Add");
		//Verify question on pop up
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupTitle)).getText();
		softly.assertThat(s10).as("test data").isEqualTo("Cannot add until the following error(s) are fixed:");
		//Verify note on pop up for 2 errors
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupNotePoint1)).getText();
		softly.assertThat(s11).as("test data").isEqualTo("Failure mode title is required");
		//ok button
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupConfirmButton)).getText();
		softly.assertThat(s12).as("test data").isEqualTo("ok");
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupConfirmButton)).click();
	}

	public void verifyFailureModesAdded (WebDriver driver, SoftAssertions softly, List<String> step4) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		int rowCount=1;
		System.out.println(step4.size());
		for(int i=0;i<step4.size();i++)
		{
			String numString = step4.get(i);
			System.out.println(numString);
			int num = Integer.parseInt(numString);
			i=i+1;
			for (int j=1;j<=num;j++)
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t4-fms-table']/tbody/tr["+rowCount+"]/td[1]/button/ul/li["+j+"]"))).getText();
				softly.assertThat(s).as("test data").isEqualTo(step4.get(i));
				i=i+1;
			}
			String fm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t4-fms-table']/tbody/tr["+rowCount+"]/td[2]/textarea"))).getAttribute("value");
			softly.assertThat(fm).as("test data").isEqualTo(step4.get(i));
			rowCount = rowCount+2;
		}
	}

	public void clearMethods(WebDriver driver) throws Exception {

		WebElement menu = driver.findElement(eirca.Step4SelectNewMethodSelectMenu);
		for(int i=1;i<=4;i++)
		{
			String s = menu.findElement(By.xpath(".//*[@data-option-index='"+i+"']/a")).getAttribute("class");
			if(s.contains("ui-checkbox-on"))
				menu.findElement(By.xpath(".//*[@data-option-index='"+i+"']/a")).click();
		}
	}

	public List<String> addFailureMode(WebDriver driver, int x, String text) throws Exception{ 

		WebDriverWait wait = new WebDriverWait(driver,10);
		List<String> failureModeDetails = new ArrayList<String>();
		//Select method 
		/*
		 * 1st element = number of methods chosen in String format
		 * rest middle elements = name of methods chosen
		 * last element = failure mode text
		 */
		List<String> methodsSelected = selectRandomMethods(driver,x);
		failureModeDetails.addAll(methodsSelected);
		//Fill failure mode
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4NewFailureModeTextBox)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4NewFailureModeTextBox)).sendKeys(text);
		failureModeDetails.add(text);
		//Click add failure mode
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4NewFailureModeAddButton)).click();
		return failureModeDetails;
	}

	public List<String> selectRandomMethods(WebDriver driver, int x) throws Exception{ 

		WebDriverWait wait = new WebDriverWait(driver,10);
		List<String> methods = new ArrayList<String>();
		//Get browser name
		/*Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		String v = cap.getVersion().toString();*/
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4SelectNewMethodButton)));
		/*if (browserName.contains("internet")==true)
		{
			if (v.startsWith("10")==true)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4SelectNewMethodButton)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4SelectNewMethodButton)).sendKeys(Keys.ENTER);
			}
			if (v.startsWith("11")==true)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4SelectNewMethodButton)).click();
			}
		}
		else{*/
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4SelectNewMethodButton)).click();
		//}
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4SelectNewMethodPopup));	
		methods.add(String.valueOf(x));
		clearMethods(driver);
		WebElement menu = driver.findElement(eirca.Step4SelectNewMethodSelectMenu);
		for(int i=1;i<=x;i++)
		{
			methods.add(menu.findElement(By.xpath(".//*[@data-option-index='"+i+"']/a")).getText());
			menu.findElement(By.xpath(".//*[@data-option-index='"+i+"']/a")).click();
		}
		try{
			driver.findElement(eirca.Step4SelectNewMethodPopupCloseButton).click();
		}catch (NoSuchElementException | ElementNotInteractableException e)
		{
			driver.findElement(eirca.Step4SelectNewMethodPopupCloseButton).click();
		}		
		return methods;
	}	

}
