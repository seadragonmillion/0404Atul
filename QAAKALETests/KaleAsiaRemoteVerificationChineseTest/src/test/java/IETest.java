import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import kaleTestSoftware.HiRCAChinese;
import kaleTestSoftware.Login;
import kaleTestSoftware.RemoteVerificationChinese;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IETest {

	private InternetExplorerDriver driver;
	private String username ="jenkins_chinese";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String ie_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\IEDriverServer.exe";
	private String url = "https://kaleasia.error-free.com/";

	@Before
	public void beforeTest() throws MalformedURLException{

		System.out.println("Chinese Remote Verification in Internet Explorer");
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
	public void SanityTest() throws Exception{
		Login obj = new Login();
		RemoteVerificationChinese obj1 = new RemoteVerificationChinese();
		HiRCAChinese obj2 = new HiRCAChinese();
		//Logs in
		int login = obj.LoginUser(driver,username,password);
		System.out.println("Title after login: "+driver.getTitle());
		//Switches to the iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		try{
			if (login==1)
			{
				WebDriverWait wait2 = new WebDriverWait(driver,20);
				wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();
			}
		}catch (org.openqa.selenium.TimeoutException e){
			throw e;
		}
		//Change language to english
		obj2.changeToChinese(driver);
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
		obj1.verifyChineseRV(driver, 2, username, password);
		//Change language to english
		obj2.changeToEnglish(driver);
		//Logs out
		obj.logout(driver);
		afterTest(obj1);		  
	}

	public void afterTest(RemoteVerificationChinese obj) throws Exception {

		//Browser is closed
		driver.quit();
		obj.softAssert();
	}
}