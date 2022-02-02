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

public class DeleteRedudantProductionCases {
	
	private WebDriver driver;
	private String username ="jenkinsvm";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private  String chrome_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\chromedriver.exe";
	private  String url = "https://kale.error-free.com/";
	public ShareCheck2 share2 = new ShareCheck2();
	public String k1 = "QAAcamelEF";
	public String k2 = "QAAcameleeUS";
	public String k3 = "QAAcameleqUS";
	public String k4 = "QAAcamelPDD";
	public String k5 = "QAAcamelPDDie11";
	public String k6 = "QAAEFTestSlides";
	public String k7 = "QAAfiveeeUSbegonia";
	public String k8 = "QAAfiveeqUSadded";
	public String k9 ="QAAfiveeeUS";
	public String k10 = "QAAfiveeqUSadded";
	public String k11 = "QAAfiveeqUSchanged";
	public String k12 = "QAAfiveeqUSjoker";
	public String k13 = "Qaafoo qaafoo";
	public String k14 = "Qaafoo,qaafoo";
	public String k15 = "Qaafoo!qaafoo";
	public String k16=  "Qaafoo?qaafoo";
	public String k17 = "Qaafoo.qaafoo";
	public String k18 = "Qaafoo(pqrs)qaafoo";
	public String k19 = "Qaafoo[abcd]qaafoo";
	public String k20 = "Qaafoo@qaafoo";
	public String k21 = "	Qaafoo/qaafoo";
	public String k22 = "Qaafoo&qaafoo";
	public String k23 = "	Qaafoo#qaafoo";
	public String k24 = "Qaafoo%qaafoo";
	public String k25 = "	Qaafoo$qaafoo";
	public String k26 = "QAAgiraffeeeUS";
	public String k27 = "QAAgiraffeeqUS";
	public String k28 = "QAAhorseEF";
	public String k29 = "QAAhorsePDD";
	public String k30 = "QAAhorsePDDie11";
	public String k31 = "QAAPDDTestSlides";
	public String k32 = "QAAPDDTestSlidesie11";
	public String k33 = "QAAUSDiscFieldCombo";
	public String k34 = "QAAzebraeeUS";
	public String k35 = "QAAzebraEF";
	public String k36 = "QAAzebraeqUS";
    public String k37 = "QAAzebraPDD";
	public String k38 = "QAAzebraPDDie11";
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
	
			deletePreviousCase(driver, k1);
			deletePreviousCase(driver, k2);
			
		
	}
		

		
		
		
		public int deletePreviousCase(WebDriver driver, String keyword) throws Exception{
			WebDriverWait wait = new WebDriverWait(driver,40);
			//Wait for loading message to disappear
			share2.loadingServer(driver);
			//Clicks on Error free bank
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-e"))).click();
			//Clicks on Equipment Performance Search (PII)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pii-e-menu']/article/div[2]/ul/li[2]/a"))).click();
			//Click clear button
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-clear"))).click();
			Thread.sleep(1000);
			//Enter Keyword 
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).sendKeys(keyword);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).sendKeys(Keys.ENTER);
			//Wait for loading message to disappear
			share2.loadingServer(driver);
			//Checks if Exact matches appear
			try{
				driver.findElement(By.xpath(".//*[@id='pii-question-list-equip']/div/h4/a/div"));			
			}catch (NoSuchElementException e)
			{
				System.out.println("No existing cases for "+keyword);
				return 0;
			}		
			int i=1;
			String [] caseIdArray=new String[50];
			while(true)
			{
				try
				{
					String xpath=".//*[@id='pii-question-list-equip']/div[1]/div[1]/div["+i+"]";
					System.out.println(xpath);
					WebElement row=driver.findElement(By.xpath(xpath));
					String rowCaseId=row.getAttribute("qid");
					rowCaseId=rowCaseId.substring(1);
					System.out.println("Case id:" +rowCaseId);
					caseIdArray[i-1]=rowCaseId;
					i=i+1;
				}catch(NoSuchElementException e)
				{
					break;
				}
			}
			for(int count = 0;count<=(i-2);count++)
			{
				System.out.println(caseIdArray[count]);
				deleteCase(driver, caseIdArray[count]);
			}
			return 1;				
		}

		public void deleteCase(WebDriver driver, String caseId) throws Exception{
			WebDriverWait wait = new WebDriverWait(driver,40);
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			//Clicks on admin user name on top right corner
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
			//Clicks on admin option
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-admin"))).click();
			Thread.sleep(1000);
			//Clicks on Errorfree bank option
			if (driver.findElement(By.id("pii-admin-efse-manage-button")).isDisplayed()==false)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efbank']/h3/a"))).click();
			}
			//Clicks on Equipment cases
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-manage-button"))).click();
			//Wait for loading message to disappear
			share2.loadingServer(driver);
			//Click on enter case id
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-list-input"))).sendKeys(caseId);
			Thread.sleep(2000);
			//Clicks on case id
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-list-ul"))).click();
			//Wait for loading message to disappear
			share2.loadingServer(driver);
			//Clicks on delete button
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-button-delete"))));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-button-delete"))));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-button-delete"))).click();
			//Clicks on delete case
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-title"))).click();
			jse.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-confirmed"))));
			//Wait for loading message to disappear
			share2.loadingServer(driver);
			share2.scrollToTop(driver);
			//Checks if case deleted
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-list-input"))).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-list-input"))).sendKeys(caseId);
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-list-input"))).sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			if(driver.findElement(By.id("pii-admin-efse-list-ul")).isDisplayed()==false)
				System.out.println("Case deleted "+caseId);		  
		}
		
		/*
		//Logs out
		obj.logout(driver);*/
	

	
	public void afterTest(UserManagement obj) throws Exception{

		//Browser closes
//		driver.quit();
//		obj.softAssert();
	}
}
