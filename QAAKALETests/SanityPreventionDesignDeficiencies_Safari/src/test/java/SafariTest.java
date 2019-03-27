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

		System.out.println("Case Search for PDD in Safari on MAC");
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
		obj1.getPDDLink(driver);
		//Search with keyword %
		obj1.searchWithPercent(driver, obj1.keywordPDDDevPercent, obj1.casePDDDev);
		//Search with keyword ./
		obj1.searchWithSpcl(driver, obj1.keywordPDDDevSpcl, obj1.casePDDDev);
		//Verify search options
		obj1.verifySearchOptions(driver, obj1.keywordPDDDev, obj1.casePDDDev);
		//Browse case with keyword
		obj1.browseCase(driver, obj1.keywordPDDDev, obj1.casePDDDev, obj1.titlePDDDev);
		//Browse case with case id
		obj1.browseCaseID(driver, obj1.casePDDDev, obj1.titlePDDDev);
		//Search for case in Equipment non pii by keyword
		obj1.searchCaseInEquipSearchByKeyword(driver, obj1.keywordPDDDev, obj1.casePDDDev);
		//Search for case in Equipment non pii by case id
		obj1.searchCaseInEquipSearchByCaseID(driver, obj1.casePDDDev);
		//Add new keyword to old case
		obj2.addNewKeywordToOldCase(driver, obj1.casePDDDev);
		//Logout
		obj.logout(driver);
		afterTest(obj1);		
	}

	public void afterTest(EquipmentPDDandEF obj1) throws Exception{
		driver.quit();
		obj1.softAssert();
	}
}