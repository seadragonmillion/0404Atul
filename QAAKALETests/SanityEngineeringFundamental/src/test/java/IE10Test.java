import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class IE10Test {

	private WebDriver driver;
	private String username ="jenkinsvm";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String ie_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\IEDriverServer.exe";
	private String url = System.getProperty("qaurl");
	
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Case Search for EF in IE");
		  System.setProperty("webdriver.ie.driver",ie_path);
		  DesiredCapabilities cap = new DesiredCapabilities(); 
		  cap.setCapability("ignoreZoomSettings", true);
		  cap.setCapability("requireWindowFocus", true);
		  driver = new InternetExplorerDriver(cap);
		  //Browser is maximized
		  driver.manage().window().maximize();
		  //Browser navigates to the KALE url
		  driver.navigate().to(url);
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }
	
	@Test
	public void test() throws Exception {
		Login obj = new Login ();
		EquipmentPDDandEF obj1 = new EquipmentPDDandEF ();
		CreateEquipmentCase2 obj2 = new CreateEquipmentCase2();
		int login = obj.LoginUser(driver, username, password);
		System.out.println("Title after login: "+driver.getTitle());
		Thread.sleep(2000);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver,20);
		//Waits for black loading message
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
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
