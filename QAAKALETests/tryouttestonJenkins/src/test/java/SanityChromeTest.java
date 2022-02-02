import kaleTestSoftware.*;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Base64;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;

import org.junit.Rule;
import org.junit.rules.Timeout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnhandledAlertException;

public class SanityChromeTest {
	
	private WebDriver driver;
	private String username ="jenkinsvm";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private  String chrome_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\chromedriver.exe";
	private  String url = "https://kaleqa.error-free.com/";
	public RemoteVerification2 rv2 = new RemoteVerification2();
	public RemoteVerificationPageObj rv = new RemoteVerificationPageObj();	
	public ShareCheck2 share2 = new ShareCheck2();
	
/*		
		 System.out.println("Check pre-test config on Chrome");
		  System.setProperty("webdriver.chrome.driver",chrome_path);
		  driver = new ChromeDriver();
		  driver.navigate().to(url);
		  driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
	      // fetching the current window size with getSize()
	      System.out.println(driver.manage().window().getSize());
		  driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		Dimension dm = new Dimension(1024,768);
//	      //Setting the current window to that dimension
	      driver.manage().window().setSize(dm);
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  System.out.println(driver.manage().window().getSize());
		  Thread.sleep(10000);
	}
}

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
//           driver.quit();
        }
	};
*/		  
	@Before
	  public void beforeTest() throws MalformedURLException{
		  System.setProperty("webdriver.chrome.driver",chrome_path);
		  driver = new ChromeDriver();
		  //Browser is maximized
		  driver.manage().window().maximize();
		  //Browser navigates to the KALE url
		  driver.navigate().to(url);
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }

	@Test
	public void test() throws Exception{
		
		Login obj = new Login();
		int login = obj.LoginUser(driver, username, password);
		//Switches to the iframe
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
		try{
			if (login==1)
			{
				WebDriverWait wait2 = new WebDriverWait(driver,20);
				wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();
			}
		}catch (NoSuchElementException |org.openqa.selenium.TimeoutException e){

		}
		//Clicks on Analysis 
				try
				{
					driver.findElement(rv.AnalysisLink).click();
				}catch (UnhandledAlertException f){			  
					driver.switchTo().alert().dismiss();
				}
				//Clicks on Remote Verification
				driver.findElement(rv.RVLink).click();
				//FillPage
				wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVEventTitle)).sendKeys("0101test");
				wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVEventDetails)).sendKeys("spv");
				//FillPage(click in-person)
				share2.scrollToAPoint(driver, 800);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-tab-1-5-inperson-radio-ip-label"))).click();
				share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-tab-1-6-inperson-name"))));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-tab-1-6-inperson-name"))).sendKeys("MarryAnne");
				//Fill in (6) Verifier sign-off's Title
				share2.scrollToAPoint(driver,400);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-tab-1-6-inperson-title"))).sendKeys("Site Manager");
				//Click on Save Button
				share2.scrollToTop(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-save"))).click();
				//Click Save in Save report popup
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-dialog-confirmed"))).click();
				
				
		/*
		//Logs out
		obj.logout(driver);*/
	}

	
	public void afterTest(UserManagement obj) throws Exception{

		//Browser closes
//		driver.quit();
//		obj.softAssert();
	}
}
