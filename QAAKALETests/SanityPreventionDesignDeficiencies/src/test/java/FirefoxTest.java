import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FirefoxTest {

	private WebDriver driver;
	private String username ="jenkinsvm";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String gecko_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\geckodriver.exe";
	private String url = System.getProperty("qaurl");
	
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Case Search for PDD in Firefox");
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
        }catch (NoSuchElementException |org.openqa.selenium.TimeoutException e){
                    
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
		driver.manage().window().maximize(); 
		  driver.quit();
		  obj1.softAssert();
	  }


}
