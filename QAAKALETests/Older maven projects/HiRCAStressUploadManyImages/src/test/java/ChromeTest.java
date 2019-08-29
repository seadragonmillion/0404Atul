import kaleTestSoftware.*;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class ChromeTest {

	private static WebDriver driver;
	private static String username = "jenkinsvmnonadmin";
	private static String password = "S2FsZWplbmtpbnNAMTIz";
	private String url = System.getProperty("qaurl");
	
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

		System.out.println("HiRCA Stress test: Upload 10 images in supporting files in Chrome");
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
	public void test() throws Exception {
		Login obj = new Login ();
		HiRCAStress obj1 = new HiRCAStress();
		int login = obj.LoginUser(driver, username, password);
		System.out.println("Title after login: "+driver.getTitle());
		//Thread.sleep(7000);
		//Waits for the page to load
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Switches to the iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		//Thread.sleep(5000);
		try{
			if (login==1)
			{
				WebDriverWait wait2 = new WebDriverWait(driver,20);
				wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();
			}
		}catch (NoSuchElementException |org.openqa.selenium.TimeoutException e){
			throw e;
		}
		//Thread.sleep(4000);
		//upload 10 images
		obj1.HiRCAUpload10Images(driver);
		//Logout
		obj.logout(driver);
		afterTest(obj1);
	}

	public static void afterTest(HiRCAStress obj) throws Exception{

		//Browser closes
		driver.quit();
		obj.softAssert();
	}

}