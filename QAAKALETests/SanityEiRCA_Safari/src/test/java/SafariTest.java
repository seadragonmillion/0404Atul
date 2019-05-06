import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import kaleTestSoftware.EiRCA;
import kaleTestSoftware.Login;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SafariTest {

	private WebDriver driver;
	private String username ="ritica_only_nonadmin";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String url = "https://kaleqa.error-free.com/";

	@Before
	public void beforeTest() throws MalformedURLException{

		System.out.println("Performing sanity test on EiRCA in Safari on MAC");
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
		EiRCA obj1 = new EiRCA();
		//Logs in
		int login = obj.LoginUser(driver, username, password);
		System.out.println("Title after login: "+driver.getTitle());
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
		//Clicks on Analysis 
		try
		{
			driver.findElement(By.id("pii-main-menu-button-a")).click();
		}catch (UnhandledAlertException f){			  
			driver.switchTo().alert().dismiss();
		}
		HashMap<String,String> hm =obj1.reportCreate(driver, username);
		//Gets the name of the record created
		String recordName = hm.get("record name");
		//Opens record
		obj1.openReport(driver,recordName);
		//Add 2nd failure mode
		obj1.add2ndFailureMode(driver,username);	  
		//Shares report 0 for admin and 1 for non admin
		obj1.shareReport(driver, username, password,0);
		//Mark critical, integer same as shareReport
		obj1.markCritical(driver,username, password,0);
		//Deletes the newly created record, integer same as shareReport
		obj1.deleteNewRecord(driver, recordName,0);
		//Logs out
		obj.logout(driver);	
		afterTest(obj1);	  

	}  

	public void afterTest(EiRCA obj) throws Exception{

		//Browser is closed
		driver.quit();
		obj.softAssert();
	}

}
