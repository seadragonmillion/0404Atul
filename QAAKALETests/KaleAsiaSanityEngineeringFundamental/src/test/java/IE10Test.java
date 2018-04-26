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
	private String username ="ritica_only_admin";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String ie_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\IEDriverServer.exe";
	private String url = "https://kaleasia.error-free.com/";
	
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
		//obj1.searchWithPercent(driver, obj1.keywordEFProdPercent, obj1.caseEFDev);
		//Search with keyword ./
		obj1.searchWithSpcl(driver, obj1.keywordEFProdSpcl, obj1.caseEFProdSpcl);
		//Verify search options
		obj1.verifySearchOptions(driver, obj1.keywordEFProd, obj1.caseEFProd);
		//Browse case with keyword
		obj1.browseCase(driver, obj1.keywordEFProd, obj1.caseEFProd, obj1.titleEFProd);
		//Browse case with case id
		obj1.browseCaseID(driver, obj1.caseEFProd, obj1.titleEFProd);
		//Logout
		obj.logout(driver);
		afterTest(obj1);		
	}
	
	public void afterTest(EquipmentPDDandEF obj1) throws Exception{
		  driver.quit();
		  obj1.softAssert();
	  }


}
