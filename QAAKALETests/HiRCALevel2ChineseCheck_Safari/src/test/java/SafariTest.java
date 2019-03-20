import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import kaleTestSoftware.HiRCAChinese;
import kaleTestSoftware.HiRCALevel2Chinese;
import kaleTestSoftware.Login;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;


public class SafariTest {

	private WebDriver driver;
	private String username = "ritica_only_nonadmin";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String url = "https://kaleqa.error-free.com/";

	@Before
	public void beforeTest() throws MalformedURLException{

		System.out.println("HiRCA Level 2 Chinese check in Safari on MAC");
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
	public void test() throws Exception{
		
		Login obj = new Login ();
		HiRCAChinese obj1 = new HiRCAChinese();
		HiRCALevel2Chinese obj2 = new HiRCALevel2Chinese();
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
		Thread.sleep(4000);
		//Change language to chinese
		obj1.changeToChinese(driver);
		//Check path
		obj2.pathHiRCALevel2(driver);
		//Change language to english
		obj1.changeToEnglish(driver);
		//Logout
		obj.logout(driver);
		afterTest(obj2);
	}

	public void afterTest(HiRCALevel2Chinese obj1) throws Exception {

		driver.quit();
		obj1.softAssert();
	}
}

