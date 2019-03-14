import kaleTestSoftware.*;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
public class IETest {

	private InternetExplorerDriver driver;
	private String username ="qaacfi";
	private String password = "S2FsZTk0OTM1ODMwQA==";
	private String ie_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\IEDriverServer.exe";
	private String url = "https://kaleasia.error-free.com/";

	@Before
	public void beforeTest() throws MalformedURLException{

		System.out.println("Performing verification on event information page in HiRCA for non admin in Internet Explorer");
		System.setProperty("webdriver.ie.driver",ie_path);
		DesiredCapabilities cap = new DesiredCapabilities(); 
		cap.setCapability("ignoreZoomSettings", true);
		cap.setCapability("requireWindowFocus", true);
		driver = new InternetExplorerDriver(cap);
		//Browser is maximized
		driver.manage().window().maximize();
		//Browser navigates to the KALE url
		driver.navigate().to(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		  
	}


	@Test
	public void SanityTest() throws Exception{

		Login obj = new Login ();
		HiRCAEvent obj1 = new HiRCAEvent();
		int login = obj.LoginUser(driver, username, password);
		System.out.println("Title after login: "+driver.getTitle());
		//Waits for the page to load
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(8000);
		//Switches to the iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		Thread.sleep(8000);
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
		String recordName = obj1.hircaEventInfo(driver, username);
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
		//Mark critical
		obj1.markCritical(driver,username,password,1);
		Thread.sleep(2000);
		//Creates new record by changing title if f==1 firefox
		obj1.saveNewReport(driver, username, password, obj,0,recordName,obj1.text184);
		Thread.sleep(2000);
		//Deletes the newly created record
		obj1.deleteNewRecord(driver, recordName);	 
		//Logout
		obj.logout(driver);
		afterTest(obj1);		  
	}

	public void afterTest(HiRCAEvent obj) throws Exception{
		//Browser closes
		driver.quit();
		obj.softAssert();
	}

}
