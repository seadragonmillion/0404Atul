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
	private String username = "qaacfi";
	private String password = "S2FsZTk0OTM1ODMwQA==";
	private String url = "https://kaleasia.error-free.com/";
		
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

		System.out.println("EiRCA Bugs test in Chrome");
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
		options.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		options.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(options);
		//Browser is maximized
		driver.manage().window().maximize();
		//Browser navigates to the KALE url
		driver.navigate().to(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws Exception{
		Login obj = new Login ();
		EiRCABug obj1 = new EiRCABug();
		int login = obj.LoginUser(driver, username, password);
		System.out.println("Title after login: "+driver.getTitle());
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
		//Bugs
		obj1.EiRCABugPath(driver);
		//Logout
		obj.logout(driver);
		afterTest(obj1);
	}

	public void afterTest(EiRCABug obj1) throws Exception {

		driver.quit();
		obj1.softAssert();
	}
}