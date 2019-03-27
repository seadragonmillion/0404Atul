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


public class SafariTest {

	private WebDriver driver;
	private String username ="ritica_only_admin";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String url = "https://kaleqa.error-free.com/";

	@Before
	public void beforeTest() throws MalformedURLException{

		System.out.println("Performing sanity test on Equipment Performance Search in Safari on MAC");
		System.setProperty("webdriver.safari.driver", "/Applications/Safari Technology Preview.app/Contents/MacOS/safaridriver");
		SafariOptions options = new SafariOptions();
		options.setUseTechnologyPreview(true);
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
		//Clicks on Equip Performance Search
		/*Verify order or modules
		 * admin = 0
		 * nonadmin = 1
		 */
		obj1.getEquipPerformanceLink(driver,0);
		//Verify all search options
		obj1.verifySearchOptionsEquip(driver, obj1.keywordEquipDev, obj1.caseEquipDev);
		//Checks with keyword with %
		obj1.searchWithPercentEquip(driver, obj1.keywordEquipDevPercent, obj1.caseEquipDev);
		//Checks with new keyword with . and /
		obj1.searchWithSpclEquip(driver, obj1.keywordEquipDevSpcl, obj1.caseEquipDev);
		Thread.sleep(1000);
		//Term search
		obj1.browseTermEquip(driver, obj1.keywordEquipDev, obj1.caseEquipDev, obj1.titleDev);
		//Case id search
		obj1.browseCaseIDEquip(driver, obj1.caseEquipDev, obj1.titleDev);
		//Search with keyword color oil
		obj1.searchColorCasesEquip(driver);
		//Add new keyword to old case
		obj2.addNewKeywordToOldCase(driver, obj1.caseEquipDev);
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
