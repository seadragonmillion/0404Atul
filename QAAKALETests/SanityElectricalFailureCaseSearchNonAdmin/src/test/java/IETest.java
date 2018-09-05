import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class IETest {

	private InternetExplorerDriver driver;
	private String username ="jenkinsvmnonadmin";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String ie_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\IEDriverServer.exe";
	private String url = System.getProperty("qaurl");
	
	
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Performing sanity test on Electrical Failure in Internet Explorer");
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
			 }catch (NoSuchElementException |org.openqa.selenium.TimeoutException e){

		}
		  Thread.sleep(4000);
		  //Clicks on Electrical Failure Modes
		  /*Verify order or modules
		     * admin = 0
		     * nonadmin = 1
		    */
		  obj1.getElecFailureModeLink(driver,1);
		  //Verify all search options
		  obj1.verifySearchOptionsEquip(driver, obj1.keywordElecDev, obj1.caseElecDev);
		  //Checks with keyword with %
		  obj1.searchWithPercentEquip(driver, obj1.keywordElecDevPercent, obj1.caseElecDev);
		  //Checks with new keyword with . and /
		  obj1.searchWithSpclEquip(driver, obj1.keywordElecDevSpcl, obj1.caseElecDev);
		  Thread.sleep(1000);
		  //Term search
		  obj1.browseCaseNonAdminEquip(driver, obj1.keywordElecDev, obj1.caseElecDev, obj1.titleDev);
		  //Select discipline and verify change in number of cases displayed
		  obj1.chooseDisciplineFailureModeSearch(driver);
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
