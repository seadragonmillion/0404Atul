import kaleTestSoftware.*;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class IETest {

	private WebDriver driver;
	private String username ="jenkinsvmnonadmin";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String ie_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\IEDriverServer.exe";
	private String url = System.getProperty("qaurl");

	@Before
	public void beforeTest() throws MalformedURLException{

		System.out.println("Performing sanity test on SRI in IE");
		System.setProperty("webdriver.ie.driver",ie_path);
		InternetExplorerOptions options = new InternetExplorerOptions(); 
		options.setCapability("ignoreZoomSettings", true);
		options.setCapability("requireWindowFocus", true);
		driver = new InternetExplorerDriver(options);
		//Browser is maximized
		driver.manage().window().maximize();
		//Browser navigates to the KALE url
		driver.navigate().to(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		  
	}

	@Test
	public void SanityTest() throws Exception{
		Login obj = new Login ();
		SRI obj1 = new SRI();
		int login = obj.LoginUser(driver, username, password);
		System.out.println("Title after login: "+driver.getTitle());
		Thread.sleep(7000);
		//Switches to the iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		Thread.sleep(5000);
		if (login==1)
		{

			while(true)
			{
				Thread.sleep(1000);
				if (driver.findElement(By.cssSelector(".sticky.border-top-right.sticky-error")).isDisplayed())
				{
					WebElement ele =driver.findElement(By.cssSelector(".sticky.border-top-right.sticky-error"));
					ele.findElement(By.className("sticky-close")).click();
					break;
				}
				else break;
			}
		}	
		Thread.sleep(4000);
		//Create report
		String recordName = obj1.path_SRI(driver);
		//ShareReport
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
		//Mark critical
		obj1.markCriticalReport(driver, username, password, 1);
		//Delete report
		obj1.deleteReport(driver, recordName,1);
		//Logout
		obj.logout(driver);
		afterTest(obj1);
	}

	public void afterTest(SRI obj) throws Exception{

		//Browser closes
		driver.quit();
		obj.softAssert();		
	}
}