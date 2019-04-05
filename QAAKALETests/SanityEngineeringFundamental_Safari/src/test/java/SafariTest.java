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
	private String username ="qaasafari_admin";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String url = System.getProperty("qaurl");

	@Before
	public void beforeTest() throws MalformedURLException{

		System.out.println("Case Search for EF in Safari on MAC");
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
	public void test() throws Exception {
		Login obj = new Login ();
		EquipmentPDDandEF obj1 = new EquipmentPDDandEF ();
		CreateEquipmentCase2 obj2 = new CreateEquipmentCase2();
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
		//Go to Engineering Fundamentals
		obj1.getEFLink(driver);
		//Search with keyword %
		obj1.searchWithPercent(driver, obj1.keywordEFDevPercent, obj1.caseEFDev);
		//Search with keyword ./
		obj1.searchWithSpcl(driver, obj1.keywordEFDevSpcl, obj1.caseEFDev);
		//Verify search options
		obj1.verifySearchOptions(driver, obj1.keywordEFDev, obj1.caseEFDev);
		//Browse case with keyword
		obj1.browseCase(driver, obj1.keywordEFDev, obj1.caseEFDev, obj1.titleEFDev);
		//Browse case with case id
		obj1.browseCaseID(driver, obj1.caseEFDev, obj1.titleEFDev);
		//Search for case in Equipment non pii by keyword
		obj1.searchCaseInEquipSearchByKeyword(driver, obj1.keywordEFDev, obj1.caseEFDev);
		//Search for case in Equipment non pii by case id
		obj1.searchCaseInEquipSearchByCaseID(driver, obj1.caseEFDev);
		//Add new keyword to old case
		obj2.addNewKeywordToOldCase(driver, obj1.caseEFDev);
		//Logout
		obj.logout(driver);
		afterTest(obj1);		
	}

	public void afterTest(EquipmentPDDandEF obj1) throws Exception{
		driver.quit();
		obj1.softAssert();
	}
}