import kaleTestSoftware.*;
import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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

public class SanityChromeTest {

	private WebDriver driver;
	private String username ="jenkinsvm";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String chrome_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\chromedriver.exe";
	private String url = "https://kaleqa.error-free.com/";
	
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
		  
		  System.out.println("Performing sanity test on create Company/Group/User in Chrome");
		  System.setProperty("webdriver.chrome.driver",chrome_path);
		  driver = new ChromeDriver();
		  //Browser is maximized
		  driver.manage().window().maximize();
		  //Browser navigates to the KALE url
		  driver.navigate().to(url);
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  }
	  

	@Test
	public void test() throws Exception{
		Login obj = new Login();
		UserManagement obj1 = new UserManagement();		  
		//Mark all messages in inbox as read
		obj1.emailMarkRead(obj1.emailDev, driver); 
		int login = obj.LoginUser(driver, username, password);
		System.out.println("Title after login: "+driver.getTitle());
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
		//Deletes previous created company,user,group
		obj1.deletesPrevious(driver, obj1.company_idDevAsiaUS);
		//Create company
		obj1.createCompany(driver, obj1.company_idDevAsiaUS);		
		//Verify if company id can be retrieved as per bug KALE 1733
		obj1.companyRetrieveAgain(driver, obj1.company_idDevAsiaUS);
		Thread.sleep(2000);
		//Clicks on create group
		String []op = obj1.createGroupWithRandomModules(driver, obj1.company_idDevAsiaUS);
		Thread.sleep(2000);
		//Clicks on create user
		obj1.createUser(driver, obj1.company_idDevAsiaUS, password, obj1.emailDev);
		//Verify if new user can be searched
		obj1.userRetrieveAfterProfileView(driver, obj1.company_idDevAsiaUS, username, password, obj);
		obj1.editGroupCheckAccess(driver, obj1.emailDev, obj1.company_idDevAsiaUS, username, password, op);
		obj1.editPassword(driver, obj1.emailDev, obj1.company_idDevAsiaUS, username, password);
		obj1.deleteUser(driver, obj1.company_idDevAsiaUS);
		obj1.deleteGroup(driver, obj1.company_idDevAsiaUS);
		obj1.deleteCompany(driver, obj1.company_idDevAsiaUS);		  	  
		//Logs out
		obj.logout(driver);
		afterTest(obj1);		  
	}

	public void afterTest(UserManagement obj) throws Exception{

		//Browser closes
		driver.quit();
		obj.softAssert();
	}
}
