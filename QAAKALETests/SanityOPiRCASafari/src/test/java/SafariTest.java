import kaleTestSoftware.*;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

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
import org.openqa.selenium.support.ui.WebDriverWait;

public class SafariTest {

	private WebDriver driver;
	private String username ="ritica_only_nonadmin";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String url = "https://kaleqa.error-free.com/";

	@Before
	public void beforeTest() throws MalformedURLException{

		System.out.println("Performing sanity test on O&P-IRCA in Safari on MAC");
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
		OPiRCA obj1 = new OPiRCA();
		//Logs in
		int login = obj.LoginUser(driver, username, password);
		System.out.println("Title after login: "+driver.getTitle());
		Thread.sleep(5000);
		//Switches to the iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		try{
			if (login==1)
			{
				WebDriverWait wait2 = new WebDriverWait(driver,20);
				wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();
			}
		}catch (NoSuchElementException |org.openqa.selenium.TimeoutException e){

		}
		Thread.sleep(5000);
		//Clicks on Analysis 
		try
		{
			driver.findElement(By.id("pii-main-menu-button-a")).click();
		}catch (UnhandledAlertException f){			  
			driver.switchTo().alert().dismiss();
		}
		obj1.reportCreate(driver, username);
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
		obj1.shareReport(driver, username, password, 1);
		//Mark critical integer same as shareReport
		obj1.markCritical(driver,username, password,1);
		WebElement record = driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-opa']/ul/li[2]/a"));
		String recordName = record.getText();
		//Deletes the newly created record, integer same as shareReport
		obj1.deleteNewRecord(driver, recordName,1);
		//Logs out
		obj.logout(driver);
		afterTest(obj1);		 
	}

	public void afterTest(OPiRCA obj1) throws Exception{

		//Browser closes
		driver.quit();
		obj1.softAssert();
	}	
}