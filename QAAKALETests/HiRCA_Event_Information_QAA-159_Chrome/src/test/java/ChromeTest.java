import kaleTestSoftware.*;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ChromeTest {

	private WebDriver driver;
	private String username = "jenkinsvmnonadmin";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	
	@Rule
    public TestWatcher watcher = new TestWatcher() {
        @Override
        protected void failed(Throwable throwable, Description description) {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(scrFile,
                        new File("target/screenshots/"+"failshot.png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }

        @Override
        protected void finished(Description description) {
            driver.quit();
        }
	};
		
	@Before
	public void beforeTest() throws MalformedURLException{

		System.out.println("Performing verification on event information page in HiRCA for non admin in Chrome");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\rramakrishnan\\DriversForSelenium\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
		chromeOptionsMap.put("plugins.plugins_disabled", new String[] {
				"Chrome PDF Viewer"
		});
		chromeOptionsMap.put("plugins.always_open_pdf_externally", true);
		options.setExperimentalOption("prefs", chromeOptionsMap);
		String downloadFilepath = "C:\\Users\\IEUser\\Downloads\\reports";
		chromeOptionsMap.put("download.default_directory", downloadFilepath);
		//DesiredCapabilities cap = DesiredCapabilities.chrome();
		options.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		options.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(options);
		//Browser is maximized
		driver.manage().window().maximize();
		//Browser navigates to the KALE url
		driver.navigate().to(System.getProperty("qaurl"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}



	@Test
	public void SanityTest() throws Exception{

		Login obj = new Login ();
		HiRCAEvent obj1 = new HiRCAEvent();
		int login = obj.LoginUser(driver, username, password);
		System.out.println("Title after login: "+driver.getTitle());
		Thread.sleep(5000);
		//Waits for the page to load
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
		Thread.sleep(2000);			 
		//Logout
		obj.logout(driver);
		afterTest(obj1);

	}

	public void afterTest(HiRCAEvent obj) throws Exception {
		driver.quit();
		obj.softAssert();
	}


}
