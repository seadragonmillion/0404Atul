import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import kaleTestSoftware.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
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

public class SafariTest {

	private WebDriver driver;
	private String username ="qaasafari_nonadmin";
	private String password = "S2FsZWplbmtpbnNAMTIz";
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

		System.out.println("Performing sanity test on Human Performance Search in Safari on MAC");
		/*System.setProperty("webdriver.safari.driver", "/Applications/Safari Technology Preview.app/Contents/MacOS/safaridriver");
		SafariOptions options = new SafariOptions();
		options.setUseTechnologyPreview(true);
		driver = new SafariDriver(options);*/
		driver = new SafariDriver();
		//Browser is maximized
		driver.manage().window().maximize();
		//Browser navigates to the KALE url
		driver.navigate().to(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}	

	@Test
	public void SanityTest() throws Exception{
		Login obj = new Login();
		CaseBrowse obj1 = new CaseBrowse();
		//Logs in
		int login = obj.LoginUser(driver, username, password);
		System.out.println("Title after login: "+driver.getTitle());
		//Waits for the page to load
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
		//Clicks on Human Performance Search
		/*Verify order or modules
		 * admin = 0
		 * nonadmin = 1
		 */
		obj1.getHumanPerformanceLink(driver,1);
		//Verify all search options
		obj1.verifySearchOptionsHuman(driver, obj1.keywordHumanDev, obj1.caseHumanDev);
		//Checks with keyword with %
		obj1.searchWithPercentHuman(driver, obj1.keywordHumanDevPercent, obj1.caseHumanDev);
		//Checks with new keyword with . and /
		obj1.searchWithSpclHuman(driver, obj1.keywordHumanDevSpcl, obj1.caseHumanDev);
		Thread.sleep(1000);
		//Term search
		obj1.browseCaseNonAdminHuman(driver, obj1.keywordHumanDev, obj1.caseHumanDev, obj1.titleDev);
		//Logs out
		obj.logout(driver);
		Thread.sleep(2000);
		afterTest(obj1);		  		  
	}

	public void afterTest(CaseBrowse obj) throws Exception{

		//Browser closes
		driver.quit();
		obj.softAssert();
	}
}