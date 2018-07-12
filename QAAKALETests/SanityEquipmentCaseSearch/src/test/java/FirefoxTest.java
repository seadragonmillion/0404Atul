import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirefoxTest {

	private FirefoxDriver driver;
	private String username ="jenkinsvm";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String gecko_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\geckodriver.exe";
	private String url = "https://kaledev.error-free.com/";
	
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		 System.out.println("Performing sanity test on Equipment Performance Search in Firefox");
		 System.setProperty("webdriver.gecko.driver",gecko_path);
		 ProfilesIni ffProfiles = new ProfilesIni();
		 FirefoxProfile profile = ffProfiles.getProfile("HiRCAEvent");
		 profile.setPreference("browser.download.folderList", 2);
		 profile.setPreference("browser.download.dir", "C:\\Users\\IEUser\\Downloads\\reports");
		 FirefoxOptions options = new FirefoxOptions();
		 options.setCapability(FirefoxDriver.PROFILE, profile);
		 driver = new FirefoxDriver(options);
		Dimension initialSize= driver.manage().window().getSize();
		 System.out.println(initialSize);
		 int height=initialSize.getHeight();
		 if(height<930)
		 {
			//Browser is maximized
			driver.manage().window().maximize(); 
		 }
		 Dimension finalSize=driver.manage().window().getSize();
		 System.out.println(finalSize);
		  //Browser navigates to the KALE url
		  driver.navigate().to(url);
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }

	
	@Test
	  public void SanityTest() throws Exception{
		  Login obj = new Login();
		  CaseBrowse obj1 = new CaseBrowse();
		  //Logs in
		  int login = obj.LoginUser(driver, username, password);
		  System.out.println("Title after login: "+driver.getTitle());
		  Thread.sleep(5000);
		  //Waits for the page to load
	      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	      Thread.sleep(5000);
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
		  Thread.sleep(4000);
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
		  //Logs out
		  obj.logout(driver);
		  Thread.sleep(2000);
		  afterTest(obj1);		
	}
	
	public void afterTest(CaseBrowse obj) throws Exception{
		driver.manage().window().maximize(); 
		//Browser closes
		driver.quit();
		obj.softAssert();
	}
		  

}
