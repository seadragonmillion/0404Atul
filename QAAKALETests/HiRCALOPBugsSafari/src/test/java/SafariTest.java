import kaleTestSoftware.*;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;


public class SafariTest {

	private SafariDriver driver;
	private String username = "qaasafari_nonadmin";
	private String password = "S2FsZWplbmtpbnNAMTIz";

	@Before
	public void beforeTest() throws MalformedURLException{

		System.out.println("HiRCA LOP Bug Check Safari on MAC");
		System.setProperty("webdriver.safari.driver", "/Applications/Safari Technology Preview.app/Contents/MacOS/safaridriver");
		SafariOptions options = new SafariOptions();
		options.setUseTechnologyPreview(true);
		driver = new SafariDriver(options);
		System.out.println("driver=" + driver); 
		//Browser is maximized
		driver.manage().window().maximize();
		//Browser navigates to the KALE url
		driver.navigate().to(System.getProperty("qaurl"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws Exception{
		Login obj = new Login ();
		HiRCALOPBug obj1 = new HiRCALOPBug();
		int login = obj.LoginUser(driver, username, password);
		System.out.println("Title after login: "+driver.getTitle());
		//Switches to the iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
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
		//Fill mandatory data
		obj1.allBugsHiRCA(driver);
		//Logout
		obj.logout(driver);
		afterTest(obj1);
	}

	public void afterTest(HiRCALOPBug obj1) throws Exception {

		driver.quit();
		obj1.softAssert();
	}
}
