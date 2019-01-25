import java.util.Iterator;
import java.util.List;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.Iterables;


public class PassReview {
	SoftAssertions softly = new SoftAssertions();

	By PassReviewLink = By.id("pii-a-menu-3pr");

	//HTML report
	By PassReviewSidePanel = By.id("pii-user-home-panel-btn-3pr");
	By FirstRecord = By.xpath(".//*[@id='pii-user-home-activities-3pr']/ul/li[2]/a");
	By DeleteButton = By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]");
	By ShareButton = By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[3]");
	By PassReviewMarkCriticalIndicatorText = By.xpath(".//*[@id='3pr-rpt']/table[1]/tbody/tr/th/strong[1]");
	By PassReviewShareIconOrCriticalIcon = By.xpath(".//*[@id='pii-user-home-activities-3pr']/ul/li[2]/a/span[1]");
	By PassReviewShareIconWhenAlsoMarkedCritical = By.xpath(".//*[@id='pii-user-home-activities-3pr']/ul/li[2]/a/span[2]");

	//Basic Info
	By Reviewer = By.id("pii-3pr-tab-1-reviewer");
	By DocumentTitle = By.id("pii-3pr-tab-1-title");
	By Organisation = By.id("pii-3pr-tab-1-org");
	By DocumentType = By.id("pii-3pr-tab-1-doctype");
	By SaveButton = By.id("pii-3pr-save");
	By SavePopupTitle = By.id("pii-3pr-dialog-title");
	By SavePopupConfirmButton = By.id("pii-3pr-dialog-confirmed");
	By SavedAcivitiesButton = By.id("pii-3pr-savedactivities");
	By NextButttonAtBottom = By.xpath(".//*[@id='pii-3pr-tab-1-form']/div[6]/div/button");

	//Pass 1 Tab
	By Pass1RequirementText = By.xpath(".//*[@id='pii-3pr-tab-2']/div[3]/table/tbody/tr[2]/td[2]/textarea");
	By Pass1OperatingText = By.xpath(".//*[@id='pii-3pr-tab-2']/div[3]/table/tbody/tr[3]/td[2]/textarea");
	By Pass1AssumptionText = By.xpath(".//*[@id='pii-3pr-tab-2']/div[3]/table/tbody/tr[4]/td[2]/textarea");
	By Pass1ScopeText = By.xpath(".//*[@id='pii-3pr-tab-2']/div[3]/table/tbody/tr[5]/td[2]/textarea");
	By Pass1TestingText = By.xpath(".//*[@id='pii-3pr-tab-2']/div[3]/table/tbody/tr[6]/td[2]/textarea");
	By NextButton = By.id("pii-3pr-next");
	By Pass1Tab = By.id("pii-3pr-tab-2-a");
	
	//Pass 2 Tab
	By Pass2Tab = By.id("pii-3pr-tab-3-a");

	//Pass 3 Tab
	By Pass3CriticalText = By.xpath(".//*[@id='pii-3pr-tab-4']/div[3]/table/tbody/tr[2]/td[2]/textarea");
	By Pass3Tab = By.id("pii-3pr-tab-4-a");

	//HTML
	By HTMLPass3CriticalText = By.xpath(".//*[@id='3pr-rpt']/div[9]/table/tbody/tr[2]/td[2]");

	public void pass1Tab(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		ErrorMeter obj = new ErrorMeter ();
		ShareCheck obj1 = new ShareCheck();
		List<String> textList = obj.error100Data(driver);
		Iterator<String> iter = Iterables.cycle(textList).iterator();
		//Fill text in Requirement
		if(iter.hasNext()) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Pass1RequirementText)).sendKeys(iter.next());
		}
		//Operating mode
		if(iter.hasNext()) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Pass1OperatingText)).sendKeys(iter.next());
		}
		//Assumption
		if(iter.hasNext()) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Pass1AssumptionText)).sendKeys(iter.next());
		}
		//Scope of work
		if(iter.hasNext()) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Pass1ScopeText)).sendKeys(iter.next());
		}
		//Testing
		if(iter.hasNext()) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Pass1TestingText)).sendKeys(iter.next());
		}
		//Scroll down
		obj1.scrollToAPoint(driver, 1500);
		Thread.sleep(1000);
		//Click on each checkbox twice - check and uncheck it
		//q1 to q10
		for(int i=2;i<=11;i++)
		{
			//Check it
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-2']/div[5]/table/tbody/tr["+i+"]/td[2]/div/input"))).click();
			Thread.sleep(500);
			//Uncheck it
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-2']/div[5]/table/tbody/tr["+i+"]/td[2]/div/input"))).click();
		}
		//Check boxes for every alternate questions
		//q1 to q10
		for(int i=2;i<=11;i=i+2)
		{
			//Check it
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-2']/div[5]/table/tbody/tr["+i+"]/td[2]/div/input"))).click();
		}
		//Enter text in each text box for q1 to q10
		for(int i=2;i<=11;i++)
		{
			if(iter.hasNext()) 
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-2']/div[5]/table/tbody/tr["+i+"]/td[3]/textarea"))).sendKeys(iter.next());
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-2']/div[5]/table/tbody/tr["+i+"]/td[3]/textarea"))).getAttribute("value");
			if(s.equals(""))
			{
				if(iter.hasNext()) 
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-2']/div[5]/table/tbody/tr["+i+"]/td[3]/textarea"))).sendKeys(iter.next());
			}
		}
		//Scroll up
		obj1.scrollToTop(driver);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(NextButton)).click();
	}

	public void pass2Tab(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		ErrorMeter obj = new ErrorMeter ();
		ShareCheck obj1 = new ShareCheck();
		List<String> textList = obj.error100Data(driver);
		Iterator<String> iter = Iterables.cycle(textList).iterator();
		//Table 1
		//Enter text in each text box
		for(int i=2;i<=5;i++)
		{
			if(iter.hasNext()) 
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[3]/table/tbody/tr["+i+"]/td[2]/textarea"))).sendKeys(iter.next());
		}
		//Table 2
		//Click on each checkbox twice - check and uncheck it
		//q1 to q12
		int m=2;
		for(int i=2;i<=13;i++)
		{
			if(i==2||i==5||i==8||i==11)
			{
				m=3;
			}
			else
				m=2;
			//Scroll to element
			obj1.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[5]/table/tbody/tr["+i+"]/td["+m+"]/div/input"))));
			//Check it
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[5]/table/tbody/tr["+i+"]/td["+m+"]/div/input"))).click();
			Thread.sleep(500);
			//Uncheck it
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[5]/table/tbody/tr["+i+"]/td["+m+"]/div/input"))).click();
		}
		//Check boxes for every alternate questions
		//q1 to q10
		for(int i=2;i<=13;i=i+2)
		{
			if(i==2||i==5||i==8||i==11)
			{
				m=3;
			}
			else
				m=2;
			//Scroll to element
			obj1.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[5]/table/tbody/tr["+i+"]/td["+m+"]/div/input"))));
			//Check it
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[5]/table/tbody/tr["+i+"]/td["+m+"]/div/input"))).click();
		}
		//Enter text in each text box
		for(int i=2;i<=13;i++)
		{
			if(i==2||i==5||i==8||i==11)
			{
				m=3;
			}
			else
				m=2;
			//Scroll to element
			obj1.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[5]/table/tbody/tr["+i+"]/td["+m+"]/div/input"))));
			if(iter.hasNext()) 
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[5]/table/tbody/tr["+i+"]/td["+(m+1)+"]/textarea"))).sendKeys(iter.next());
		}
		//Table 3
		//Enter text in each text box
		for(int i=2;i<=5;i++)
		{
			//Scroll to element
			obj1.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[8]/table/tbody/tr["+i+"]/td[2]/textarea"))));
			if(iter.hasNext()) 
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[8]/table/tbody/tr["+i+"]/td[2]/textarea"))).sendKeys(iter.next());
		}
		//Table 4
		//Click on each checkbox twice - check and uncheck it
		//q1 to q12
		for(int i=2;i<=13;i++)
		{
			if(i==2||i==5||i==8||i==11)
			{
				m=3;
			}
			else
				m=2;
			//Scroll to element
			obj1.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[10]/table/tbody/tr["+i+"]/td["+m+"]/div/input"))));
			//Check it
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[10]/table/tbody/tr["+i+"]/td["+m+"]/div/input"))).click();
			Thread.sleep(500);
			//Uncheck it
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[10]/table/tbody/tr["+i+"]/td["+m+"]/div/input"))).click();
		}
		//Check boxes for every alternate questions
		//q1 to q10
		for(int i=2;i<=13;i=i+2)
		{
			if(i==2||i==5||i==8||i==11)
			{
				m=3;
			}
			else
				m=2;
			//Scroll to element
			obj1.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[10]/table/tbody/tr["+i+"]/td["+m+"]/div/input"))));
			//Check it
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[10]/table/tbody/tr["+i+"]/td["+m+"]/div/input"))).click();
		}
		//Enter text in each text box
		for(int i=2;i<=13;i++)
		{
			if(i==2||i==5||i==8||i==11)
			{
				m=3;
			}
			else
				m=2;
			//Scroll to element
			obj1.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[10]/table/tbody/tr["+i+"]/td["+m+"]/div/input"))));
			if(iter.hasNext()) 
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[10]/table/tbody/tr["+i+"]/td["+(m+1)+"]/textarea"))).sendKeys(iter.next());
		}
		//Scroll up
		obj1.scrollToTop(driver);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(NextButton)).click();
	}

	public void pass3Tab(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		ErrorMeter obj = new ErrorMeter ();
		ShareCheck obj1 = new ShareCheck();
		List<String> textList = obj.error100Data(driver);
		Iterator<String> iter = Iterables.cycle(textList).iterator();
		//Table 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(Pass3CriticalText)).sendKeys(iter.next());
		//Table 2
		//Click on each checkbox twice - check and uncheck it
		//q1 to q6
		for(int i=2;i<=7;i++)
		{
			//Scroll to element
			obj1.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-4']/div[5]/table/tbody/tr["+i+"]/td[2]/div/input"))));
			//Check it
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-4']/div[5]/table/tbody/tr["+i+"]/td[2]/div/input"))).click();
			Thread.sleep(500);
			//Uncheck it
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-4']/div[5]/table/tbody/tr["+i+"]/td[2]/div/input"))).click();
		}
		//Check boxes for every alternate questions
		//q1 to q6
		for(int i=2;i<=7;i=i+2)
		{
			//Check it
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-4']/div[5]/table/tbody/tr["+i+"]/td[2]/div/input"))).click();
		}
		//Enter text in each text box
		for(int i=2;i<=7;i++)
		{
			if(iter.hasNext()) 
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-4']/div[5]/table/tbody/tr["+i+"]/td[3]/textarea"))).sendKeys(iter.next());
		}
		//Scroll up
		obj1.scrollToTop(driver);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(NextButton)).click();
	}

	public void verifyHTMLReport(WebDriver driver, List<String> textList) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Pass 1
		//Table 1
		for(int i=2;i<=6;i++)
		{
			//Verify text
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='3pr-rpt']/div[3]/table/tbody/tr["+i+"]/td[2]"))).getText();
			String r1 = s.replaceAll("\u00AD", "");
			softly.assertThat(r1).as("test data").isIn(textList);
		}
		//Table 2
		for(int i=2;i<=11;i++)
		{
			//Verify text
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='3pr-rpt']/div[4]/table/tbody/tr["+i+"]/td[3]"))).getText();
			String r1 = s.replaceAll("\u00AD", "");
			softly.assertThat(r1).as("test data").isIn(textList);
			//Verify Yes for checkbox
			if(i%2==0)
			{
				String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='3pr-rpt']/div[4]/table/tbody/tr["+i+"]/td[2]"))).getText();
				softly.assertThat(s1).as("test data").isEqualTo("Yes");
			}
		}
		//Pass 2
		//Analysis
		//Table 1
		for(int i=2;i<=5;i++)
		{
			//Verify text
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='3pr-rpt']/div[5]/table/tbody/tr["+i+"]/td[2]"))).getText();
			String r1 = s.replaceAll("\u00AD", "");
			softly.assertThat(r1).as("test data").isIn(textList);
		}
		int m = 2;
		//Table 2
		for(int i=2;i<=13;i++)
		{
			if(i==2||i==5||i==8||i==11)
			{
				m=3;
			}
			else
				m=2;
			//Verify text
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='3pr-rpt']/div[6]/table/tbody/tr["+i+"]/td["+(m+1)+"]"))).getText();
			String r1 = s.replaceAll("\u00AD", "");
			softly.assertThat(r1).as("test data").isIn(textList);
			//Verify Yes for checkbox
			if(i%2==0)
			{
				String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='3pr-rpt']/div[6]/table/tbody/tr["+i+"]/td["+m+"]"))).getText();
				softly.assertThat(s1).as("test data").isEqualTo("Yes");
			}
		}
		//Procedure
		//Table 3
		for(int i=2;i<=5;i++)
		{
			//Verify text
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='3pr-rpt']/div[7]/table/tbody/tr["+i+"]/td[2]"))).getText();
			String r1 = s.replaceAll("\u00AD", "");
			softly.assertThat(r1).as("test data").isIn(textList);
		}
		//Table 4
		for(int i=2;i<=13;i++)
		{
			if(i==2||i==5||i==8||i==11)
			{
				m=3;
			}
			else
				m=2;
			//Verify text
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='3pr-rpt']/div[8]/table/tbody/tr["+i+"]/td["+(m+1)+"]"))).getText();
			String r1 = s.replaceAll("\u00AD", "");
			softly.assertThat(r1).as("test data").isIn(textList);
			//Verify Yes for checkbox
			if(i%2==0)
			{
				String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='3pr-rpt']/div[8]/table/tbody/tr["+i+"]/td["+m+"]"))).getText();
				softly.assertThat(s1).as("test data").isEqualTo("Yes");
			}
		}
		//Pass 3
		//Table 1
		//Verify text
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(HTMLPass3CriticalText)).getText();
		String r1 = s.replaceAll("\u00AD", "");
		softly.assertThat(r1).as("test data").isIn(textList);
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		//Table 2
		for(int i=2;i<=7;i++)
		{
			//Verify text
			if (browserName.equals("internet explorer"))
			{
				String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='3pr-rpt']/div[10]/table/tbody/tr["+i+"]/td[3]"))).getText();
				System.out.println(s1);
				String r2 = s1.replaceAll("\u00AD", "");
				softly.assertThat(r2).as("test data").isIn(textList);
				//System.out.println(s1+"\n"+r2);
			}
			else
			{
				String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='3pr-rpt']/div[10]/table/tbody/tr["+i+"]/td[3]"))).getText();
				String r2 = s1.replaceAll("\u00AD", "");
				softly.assertThat(r2).as("test data").isIn(textList);
			}
			//Verify Yes for checkbox
			if(i%2==0)
			{
				String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='3pr-rpt']/div[10]/table/tbody/tr["+i+"]/td[2]"))).getText();
				softly.assertThat(s2).as("test data").isEqualTo("Yes");
			}
		}
	}

	public void markCritical(WebDriver driver,String username, String password1,int y) throws Exception{

		WebDriverWait wait1 = new WebDriverWait(driver,60);
		ErrorMeter obj = new ErrorMeter();
		ShareCheck obj1 = new ShareCheck();
		EiRCA2 obj2 = new EiRCA2();
		OPiRCA obj3 = new OPiRCA();
		EiRCA eirca = new EiRCA();
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(FirstRecord)).click();
		//Wait for loading message to disappear
		obj1.loadingServer(driver);	
		//Clicks on mark critical
		wait1.until(ExpectedConditions.visibilityOfElementLocated(obj3.MarkCritical)).click();
		//Mark critical pop up
		obj2.verifyMarkCriticalPopup(driver, softly);
		//Clicks on confirm change
		wait1.until(ExpectedConditions.visibilityOfElementLocated(obj3.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(obj3.ConfirmPopupButton)).click();
		//Checks if marked critical
		String critical=wait1.until(ExpectedConditions.visibilityOfElementLocated(PassReviewMarkCriticalIndicatorText)).getText();
		softly.assertThat(critical).as("test data").contains("Critical");
		if(driver.findElement(PassReviewMarkCriticalIndicatorText).isDisplayed())
			System.out.println("Marked critical");
		//Click back
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.BackButton)).click();
		obj1.loadingServer(driver);
		//Verify Marked critical icon
		wait1.until(ExpectedConditions.visibilityOfElementLocated(PassReviewShareIconOrCriticalIcon));
		//Verify presence of shared icon 
		wait1.until(ExpectedConditions.visibilityOfElementLocated(PassReviewShareIconWhenAlsoMarkedCritical));
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(FirstRecord)).click();
		obj1.loadingServer(driver);
		//Clicks on mark critical again
		wait1.until(ExpectedConditions.visibilityOfElementLocated(obj3.MarkCritical)).click();
		//Un-mark critical pop up
		obj2.verifyUnMarkCriticalPopup(driver, softly);
		//Clicks on confirm change
		wait1.until(ExpectedConditions.visibilityOfElementLocated(obj3.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(obj3.ConfirmPopupButton)).click();
		Thread.sleep(2000);
		if(driver.findElement(PassReviewMarkCriticalIndicatorText).isDisplayed()==false)
		{
			System.out.println("Unmarked critical");
		}
		//Verify report not retrieved by shared to person
		String sharer = obj.decideSharer (y);		
		obj1.checkCriticalNotification(driver, sharer, username, password1, softly);		
		//Clicks on 3 pass side panel
		wait1.until(ExpectedConditions.visibilityOfElementLocated(PassReviewSidePanel)).click();
		//Wait for loading message to disappear
		obj1.loadingServer(driver);	    					
	}	

	public void shareReport(WebDriver driver,String username, String password1,int y ) throws Exception{

		WebDriverWait wait1 = new WebDriverWait(driver,60);
		ErrorMeter obj = new ErrorMeter();
		ShareCheck obj1 = new ShareCheck();
		EiRCA2 obj2 = new EiRCA2();
		OPiRCA obj3 = new OPiRCA();
		EiRCA eirca = new EiRCA();
		String sharer = obj.decideSharer (y);
		String sharerAdded = obj.decideSharerAdded (y);	 
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(FirstRecord)).click();
		obj1.loadingServer(driver);
		//Verify change in text
		verifyHTMLReport(driver, obj.error50Data(driver));
		//Clicks on share button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(ShareButton)).click();
		//Enters username
		wait1.until(ExpectedConditions.visibilityOfElementLocated(obj3.ShareTextBox)).sendKeys(sharer);
		//Selects from dropdown
		WebElement dropdown = wait1.until(ExpectedConditions.visibilityOfElementLocated(obj3.ShareDropdown));
		dropdown.findElement(obj3.FirstSelectionUnderDropdown).click();
		//Clicks on add user
		wait1.until(ExpectedConditions.visibilityOfElementLocated(obj3.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(obj3.ConfirmPopupButton)).click();
		//Verifies user added
		String user=wait1.until(ExpectedConditions.visibilityOfElementLocated(obj3.SharerAdded)).getText();
		softly.assertThat(user).as("test data").isEqualTo(sharerAdded);
		obj1.shareTwice (driver,softly);
		//Clicks on save
		wait1.until(ExpectedConditions.visibilityOfElementLocated(obj3.ShareSaveButton)).click();
		//Verify share save sticky
		obj2.verifyStickyShareSave(driver, softly);
		//Wait for loading message to disappear
		obj1.loadingServer(driver);
		//Click back
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.BackButton)).click();
		obj1.loadingServer(driver);
		//Verify Share icon
		wait1.until(ExpectedConditions.visibilityOfElementLocated(PassReviewShareIconOrCriticalIcon));
		//Calls the Share check function
		obj1.receiptReport(driver, sharer, username, password1);
		//Clicks on 3 Pass Review side panel
		wait1.until(ExpectedConditions.visibilityOfElementLocated(PassReviewSidePanel)).click();
		//Wait for loading message to disappear
		obj1.loadingServer(driver);
	}

	public void deleteNewRecord(WebDriver driver, String recordName, int y, String username) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,10);
		ShareCheck obj = new ShareCheck();
		EiRCA obj1 = new EiRCA ();
		ErrorMeter obj2 = new ErrorMeter();
		LanguageCheckOfReports obj3 = new LanguageCheckOfReports();
		//Clicks on first newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(FirstRecord)).click();
		obj.loadingServer(driver);
		//Clicks on delete button
		wait.until(ExpectedConditions.visibilityOfElementLocated(DeleteButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.ConfirmPopupTitle));
		String noHtml = wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.ConfirmPopupTitle)).getText();
		softly.assertThat(noHtml).as("test data").doesNotContain("<br/>");
		//Clicks on delete report
		driver.findElement(obj1.ConfirmPopupButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.StickyNote));
		obj.loadingServer(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(PassReviewSidePanel)).click();
		obj.loadingServer(driver);
		//Verify record deleted
		//Click on 1st record
		Thread.sleep(2000);
		String name = driver.findElement(FirstRecord).getText();
		System.out.println(name);
		if (name!=recordName)
			System.out.println("Record deleted");
		else
			System.out.println("Record could not be deleted");	
		//verify admin user account page
		if(y==0||y==2||y==4||y==6)
			obj3.verifyAccountPageAdminUser(driver, username, softly);
		//Verify report not retrieved by shared to person		
		String sharer = obj2.decideSharer (y);
		obj.checkNoReportAfterDelete(driver, sharer, softly);		
	}

	public void changeText(WebDriver driver) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,10); 
		ErrorMeter obj = new ErrorMeter();
		ShareCheck obj1 = new ShareCheck();
		//Click on Pass 1 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(Pass1Tab)).click();
		//Change text
		List<String> textList = obj.error50Data(driver);
		Iterator<String> iter = Iterables.cycle(textList).iterator();
		//Fill text in Requirement
		if(iter.hasNext()) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Pass1RequirementText)).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Pass1RequirementText)).sendKeys(iter.next());
		}
		//Operating mode
		if(iter.hasNext()) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Pass1OperatingText)).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Pass1OperatingText)).sendKeys(iter.next());
		}
		//Assumption
		if(iter.hasNext()) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Pass1AssumptionText)).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Pass1AssumptionText)).sendKeys(iter.next());
		}
		//Scope of work
		if(iter.hasNext()) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Pass1ScopeText)).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Pass1ScopeText)).sendKeys(iter.next());
		}
		//Testing
		if(iter.hasNext()) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Pass1TestingText)).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Pass1TestingText)).sendKeys(iter.next());
		}
		//Scroll down
		obj1.scrollToAPoint(driver, 1500);
		Thread.sleep(1000);
		//Enter text in each text box for q1 to q10
		for(int i=2;i<=11;i++)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-2']/div[5]/table/tbody/tr["+i+"]/td[3]/textarea"))).clear();
			if(iter.hasNext()) 
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-2']/div[5]/table/tbody/tr["+i+"]/td[3]/textarea"))).sendKeys(iter.next());
		}
		//Scroll up
		obj1.scrollToTop(driver);
		//Click on Pass 2 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(Pass2Tab)).click();
		//Table 1
		//Enter text in each text box
		for(int i=2;i<=5;i++)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[3]/table/tbody/tr["+i+"]/td[2]/textarea"))).clear();
			if(iter.hasNext()) 
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[3]/table/tbody/tr["+i+"]/td[2]/textarea"))).sendKeys(iter.next());
		}
		//Enter text in each text box
		int m=2;
		for(int i=2;i<=13;i++)
		{
			if(i==2||i==5||i==8||i==11)
			{
				m=3;
			}
			else
				m=2;
			//Scroll to element
			obj1.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[5]/table/tbody/tr["+i+"]/td["+m+"]/div/input"))));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[5]/table/tbody/tr["+i+"]/td["+(m+1)+"]/textarea"))).clear();
			if(iter.hasNext()) 
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[5]/table/tbody/tr["+i+"]/td["+(m+1)+"]/textarea"))).sendKeys(iter.next());
		}
		//Table 3
		//Enter text in each text box
		for(int i=2;i<=5;i++)
		{
			//Scroll to element
			obj1.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[8]/table/tbody/tr["+i+"]/td[2]/textarea"))));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[8]/table/tbody/tr["+i+"]/td[2]/textarea"))).clear();
			if(iter.hasNext()) 
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[8]/table/tbody/tr["+i+"]/td[2]/textarea"))).sendKeys(iter.next());
		}
		//Table 4
		//Enter text in each text box
		for(int i=2;i<=13;i++)
		{
			if(i==2||i==5||i==8||i==11)
			{
				m=3;
			}
			else
				m=2;
			//Scroll to element
			obj1.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[10]/table/tbody/tr["+i+"]/td["+m+"]/div/input"))));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[10]/table/tbody/tr["+i+"]/td["+(m+1)+"]/textarea"))).clear();
			if(iter.hasNext()) 
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-3']/div[10]/table/tbody/tr["+i+"]/td["+(m+1)+"]/textarea"))).sendKeys(iter.next());
		}
		//Scroll up
		obj1.scrollToTop(driver);
		//Click on Pass 3 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(Pass3Tab)).click();
		//Table 1
		if(iter.hasNext()) 
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(Pass3CriticalText)).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Pass3CriticalText)).sendKeys(iter.next());
		}
		//Enter text in each text box
		for(int i=2;i<=7;i++)
		{
			//Scroll to element
			obj1.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-4']/div[5]/table/tbody/tr["+i+"]/td[3]/textarea"))));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-4']/div[5]/table/tbody/tr["+i+"]/td[3]/textarea"))).clear();
			if(iter.hasNext()) 
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-3pr-tab-4']/div[5]/table/tbody/tr["+i+"]/td[3]/textarea"))).sendKeys(iter.next());
		}
		//Scroll up
		obj1.scrollToTop(driver);
	}

	public void openReport(WebDriver driver) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,10); 
		ShareCheck obj = new ShareCheck();
		EiRCA obj1 = new EiRCA ();
		ErrorMeter obj2 = new ErrorMeter ();
		//Clicks on record
		wait.until(ExpectedConditions.visibilityOfElementLocated(FirstRecord)).click();
		//Wait for loading message
		obj.loadingServer(driver);
		//Verify final report
		verifyHTMLReport(driver, obj2.error100Data(driver));
		//Clicks on open
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.OpenButton)).click();
		//Clicks on open
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.ConfirmPopupTitle)).click();
		String noHtml = wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.ConfirmPopupTitle)).getText();
		softly.assertThat(noHtml).as("test data").doesNotContain("<br/>");
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.ConfirmPopupButton)).click();
		//Change text
		changeText(driver);
		//Click on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(SaveButton)).click();
		Thread.sleep(2000);
		//Clicks on save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(SavePopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(SavePopupConfirmButton)).click();
		//Waits for the green popup on the right top corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.StickyNote));
		obj.loadingServer(driver);
		//Clicks on saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(SavedAcivitiesButton)).click();
		obj.loadingServer(driver);
		//Clicks on side panel option for 3 pass review
		wait.until(ExpectedConditions.visibilityOfElementLocated(PassReviewSidePanel)).click();
		obj.loadingServer(driver);
	}

	public String createReport (WebDriver driver) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,10); 
		ShareCheck obj = new ShareCheck();
		EiRCA obj1 = new EiRCA ();
		HiRCALOPBug obj2 = new HiRCALOPBug();
		FontCheck obj3 = new FontCheck();
		String text = obj1.textCreate(driver);
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Clicks on Analysis 
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.AnalysisLink)).click();
		}catch (UnhandledAlertException f){			  
			driver.switchTo().alert().dismiss();
		}
		//Check font on Analysis page
		obj3.analysisModuleFontCheck(driver, softly);
		//Clicks on 3 Pass review
		wait.until(ExpectedConditions.visibilityOfElementLocated(PassReviewLink)).click();
		Thread.sleep(2000);
		//Fills in mandatory details
		driver.findElement(Reviewer).sendKeys(text);
		driver.findElement(DocumentTitle).sendKeys(text);
		driver.findElement(Organisation).sendKeys(text);
		String ev1 = driver.findElement(Reviewer).getAttribute("value");
		String ev2 = driver.findElement(DocumentTitle).getAttribute("value");
		String ev3 = driver.findElement(Organisation).getAttribute("value");
		if ((ev1.equals(text)==false))
		{
			driver.findElement(Reviewer).clear();
			driver.findElement(Reviewer).sendKeys(text);
		}
		if ((ev2.equals(text)==false))
		{
			driver.findElement(DocumentTitle).clear();
			driver.findElement(DocumentTitle).sendKeys(text);
		}
		if ((ev3.equals(text)==false))
		{
			driver.findElement(Organisation).clear();
			driver.findElement(Organisation).sendKeys(text);
		}
		//Select Purpose from dropdown
		WebElement element = driver.findElement(DocumentType);
		Select s = new Select (element);
		s.selectByVisibleText("Drawing");
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(NextButttonAtBottom)).click();
		//Pass 1 Tab
		pass1Tab(driver);
		//Pass 2 Tab
		pass2Tab(driver);
		//Pass 3 Tab
		pass3Tab(driver);
		//Click on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(SaveButton)).click();
		Thread.sleep(2000);
		//Clicks on save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(SavePopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(SavePopupConfirmButton)).click();
		//Waits for the green popup on the right top corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.StickyNote));
		//Wait for loading message
		obj.loadingServer(driver);
		//Clicks on saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(SavedAcivitiesButton)).click();
		obj.loadingServer(driver);
		//Clicks on side panel option for 3 pass
		wait.until(ExpectedConditions.visibilityOfElementLocated(PassReviewSidePanel)).click();
		obj.loadingServer(driver);
		//Gets the name of the record created
		WebElement record = driver.findElement(FirstRecord);
		String recordName = record.getText();
		String r1 = recordName.replaceAll("\u00AD", "");
		softly.assertThat(r1).as("test data").contains(text);
		return r1;
	}
	
	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}

}
