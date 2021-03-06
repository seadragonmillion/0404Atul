import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import kaleTestSoftware.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Error50SafariTest {

	private WebDriver driver;
	private String username ="qaasafari_nonadmin";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String url = System.getProperty("qaurl");
	
	@Rule
    public TestWatcher watcher = new TestWatcher() {
        @Override
        protected void failed(Throwable throwable, Description description) {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(scrFile,
                        new File("target/screenshots/"+"failshot.png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }

        @Override
        protected void finished(Description description) {
            driver.quit();
        }
	};
		  
	@Before
	public void beforeTest() throws MalformedURLException{

		System.out.println("Performing sanity test on SPV Error Meter in Safari on MAC");
		System.setProperty("webdriver.safari.driver", "/Applications/Safari Technology Preview.app/Contents/MacOS/safaridriver");
		SafariOptions options = new SafariOptions();
		options.setUseTechnologyPreview(true);
		driver = new SafariDriver(options);
		//Browser is maximized
		driver.manage().window().maximize();
		//Browser navigates to the KALE url
		driver.navigate().to(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}


	@Test
	public void SanityTest() throws Exception{
		Login obj = new Login();
		ErrorMeter obj1 = new ErrorMeter();
		EiRCA2 obj2 = new EiRCA2();
		//Logs in
		int login = obj.LoginUser(driver,username,password);
		System.out.println("Title after login: "+driver.getTitle());
		//Thread.sleep(4000);
		//Waits for the page to load
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Switches to the iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		try{
			if (login==1)
			{
				WebDriverWait wait2 = new WebDriverWait(driver,20);
				wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();
			}
		}catch (NoSuchElementException e){
			throw e;
		}
		/*Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait(driver,20);
		//Clicks on Analysis 
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-a"))).click();
		}catch (UnhandledAlertException f){			  
			driver.switchTo().alert().dismiss();
		}
		//Clicks on SPV Error meter
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-em"))).click();
		Thread.sleep(2000);
		//Select Purpose from dropdown
		WebElement element = driver.findElement(By.id("pii-epm-select-purpose"));
		Select s = new Select (element);
		s.selectByVisibleText("PJB");
		Thread.sleep(2000);
		//Select Job type
		element = driver.findElement(By.id("pii-epm-select-condition"));
		Select s1 = new Select (element);
		s1.selectByVisibleText("Analysis");
		Thread.sleep(2000);
		//Fills Job title
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-job-title"))).sendKeys(obj2.textCreate(driver));
		String ev1= driver.findElement(By.id("pii-epm-job-title")).getAttribute("value");
		if(ev1.equals(obj2.textCreate(driver))==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-job-title"))).sendKeys(obj2.textCreate(driver));
		Thread.sleep(2000);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-btn-next"))).click();
		Thread.sleep(2000);*/
		obj1.papeError50(driver);
		//Save report
		String recordName = obj1.saveReport(driver, username);
		Thread.sleep(2000);
		obj1.reportCheck50(driver);/*
		  //Downloads record, the integer indicates error meter tests based on error %= 0,50,100
		  obj1.downloadReportChrome(driver, 50);*/
		Thread.sleep(2000);
		//Shares report
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
		obj1.shareReport(driver,username,password, 1);
		Thread.sleep(2000);
		//Mark critical integer same as shareReport
		obj1.markCritical(driver,username, password,1);
		//Deletes the newly created record, integer same as shareReport
		obj1.deleteNewRecord(driver, recordName,1);
		Thread.sleep(2000);
		//Logs out
		obj.logout(driver);
		Thread.sleep(2000);
		afterTest(obj1);		  
	}


	public void afterTest(ErrorMeter obj) throws Exception{

		//Browser closes
		driver.quit();
		obj.softAssert();
	}
}
