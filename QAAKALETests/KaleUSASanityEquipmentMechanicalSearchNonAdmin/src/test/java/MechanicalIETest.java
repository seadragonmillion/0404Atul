import kaleTestSoftware.*;
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


public class MechanicalIETest {

	private InternetExplorerDriver driver;
	private String username ="jenkinsvmnonadmin";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String ie_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\IEDriverServer.exe";
	private String url = "https://kale.error-free.com/";
	
	
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Performing sanity test on Mechanical Failure Modes in Internet Explorer");
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
		  Thread.sleep(9000);
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
		  //Clicks on Mechanical Failure Modes
		  /*Verify order or modules
		     * admin = 0
		     * nonadmin = 1
		    */
		  obj1.getMechFailureModeLink(driver,1);
		  //Verify all search options
		  obj1.verifySearchOptionsEquip(driver, obj1.keywordMechProd, obj1.caseMechProd);
		  Thread.sleep(1000);
		  //Term search
		  obj1.browseCaseNonAdminEquip(driver, obj1.keywordMechProd, obj1.caseMechProd, obj1.titleMechProd);
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
