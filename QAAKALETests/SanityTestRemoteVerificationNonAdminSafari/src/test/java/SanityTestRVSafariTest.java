import kaleTestSoftware.*;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SanityTestRVSafariTest {

	private WebDriver driver;
	private String username ="ritica_only_nonadmin";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String url = "https://kaleqa.error-free.com/";

	@Before
	public void beforeTest() throws MalformedURLException{

		System.out.println("Performing sanity test on Remote Verification in Safari on MAC");
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
		RemoteVerification obj1 = new RemoteVerification();
		//Logs in
		int login = obj.LoginUser(driver,username,password);
		System.out.println("Title after login: "+driver.getTitle());
		Thread.sleep(8000);		  
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
		Thread.sleep(2000);
		/*
		 * 1=admin dev
		 * 2= nonadmin dev
		 * 3= admin ie11 dev
		 * 4= nonadmin ie11 dev
		 * ASIA
		 * 5= admin asia
		 * 6= nonadmin asia
		 * 7= admin ie11 asia
		 * 8= nonadmin ie11 asia
		 * US
		 * 9=admin us
		 * 10=non admin us
		 * 11=admin ie11 us
		 * 12=non admin ie11 us
		 */
		//create report
		List<String> b = obj1.createReport(driver, username,2);
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
		obj1.shareReport(driver,b.get(0),username,password,1);
		//Mark critical integer same as shareReport
		obj1.markCritical(driver,username, password,1);
		//Deletes the newly created record, integer same as shareReport
		obj1.deleteNewRecord(driver, b.get(1),1);
		//Logs out
		obj.logout(driver);
		afterTest(obj1);		  
	}


	public void afterTest(RemoteVerification obj) throws Exception {
		//Browser is closed
		driver.quit();
		obj.softAssert();
	}

}