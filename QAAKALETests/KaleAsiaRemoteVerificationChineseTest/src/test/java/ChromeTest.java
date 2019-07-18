import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import kaleTestSoftware.HiRCAChinese;
import kaleTestSoftware.Login;
import kaleTestSoftware.RemoteVerificationChinese;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChromeTest {

	private WebDriver driver;
	private String username ="jenkins_chinese";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String chrome_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\chromedriver.exe";
	private String url = "https://kaleasia.error-free.com/";

	@Before
	public void beforeTest() throws MalformedURLException{

		System.out.println("Chinese Remote Verification in Chrome");
		System.setProperty("webdriver.chrome.driver",chrome_path);
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
		chromeOptionsMap.put("plugins.plugins_disabled", new String[] {
				"Chrome PDF Viewer"
		});
		chromeOptionsMap.put("plugins.always_open_pdf_externally", true);
		options.setExperimentalOption("prefs", chromeOptionsMap);
		String downloadFilepath = "C:\\Users\\IEUser\\Downloads\\reports";
		chromeOptionsMap.put("download.default_directory", downloadFilepath);
		options.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		options.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(options);
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
		obj1.verifyChineseRV(driver, 6, username, password);
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