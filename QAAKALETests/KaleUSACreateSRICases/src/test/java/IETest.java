import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import kaleTestSoftware.CreateCaseSRI;
import kaleTestSoftware.Login;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class IETest {

	private WebDriver driver;
	private String username ="jenkinsvm";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String ie_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\IEDriverServer.exe";
	private String url = "https://kale.error-free.com/";

	@Before
	public void beforeTest() throws MalformedURLException{

		System.out.println("Case Upload for SRI in IE");
		System.setProperty("webdriver.ie.driver",ie_path);
		DesiredCapabilities cap = new DesiredCapabilities(); 
		cap.setCapability("ignoreZoomSettings", true);
		cap.setCapability("requireWindowFocus", true);
		driver = new InternetExplorerDriver(cap);
		//Browser is maximized
		driver.manage().window().maximize();
		//Browser navigates to the KALE url
		driver.navigate().to(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws Exception {
		Login obj = new Login ();
		CreateCaseSRI obj1 = new CreateCaseSRI ();
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
		//Create SRI cases
		obj1.createCaseSRI(driver, obj1.keywordSRIUS, obj1.key1SRIUS, obj1.key2SRIUS, obj1.key3SRIUS, obj1.titleSRIUS);
		//Logout
		obj.logout(driver);
		afterTest(obj1);		
	}

	public void afterTest(CreateCaseSRI obj1) throws Exception{
		driver.quit();
		obj1.softAssert();
	}
}