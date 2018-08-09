import java.net.MalformedURLException;
import java.util.List;
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
	private String url = "https://kale.error-free.com/";
	  
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Performing sanity test on Remote Verification in Internet Explorer");
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
		  RemoteVerification obj1 = new RemoteVerification();
		  //Logs in
		  int login = obj.LoginUser(driver,username,password);
		  System.out.println("Title after login: "+driver.getTitle());
		  Thread.sleep(8000);		  
		  //Assigns wait time to driver element
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
		  Thread.sleep(2000);
		  /*
		 * 1=admin dev
		 * 2= nonadmin dev
		 * 3= admin ie11 dev
		 * 4= nonadmin ie11 dev
		 * ASIA
		 * 5= admin asia
		 * 6= nonadmin asia
		 * 7= admin ie11 asia
		 * 8= nonadmin ie11 asia
		 * US
		 * 9=admin us
		 * 10=non admin us
		 * 11=admin ie11 us
		 * 12=non admin ie11 us
		   */
		  //create report
		  List<String> b = obj1.createReport(driver, username,10);
		  //Downloads record
		  obj1.downloadRecordIE(driver,b.get(0),username);
		  //Shares report
		  /* Dev/Asia
		 * 0=admin
		 * 1=non admin
		 * 2= admin ie11
		 * 3= non admin ie11
		 * US
		 * 4=admin
		 * 5=non admin
		 * 6=admin ie11
		 * 7=non admin ie11
		 */
		  obj1.shareReport(driver,b.get(0),username,password,5);
		  //Mark critical integer same as shareReport
		  obj1.markCritical(driver,username, password,5);
		  //Deletes the newly created record, integer same as shareReport
		  obj1.deleteNewRecord(driver, b.get(1),5);
		  //Logs out
		  obj.logout(driver);
		  afterTest(obj1);		 
	  }

	  
	  public void afterTest(RemoteVerification obj) throws Exception {
		   driver.quit();
		   obj.softAssert();
	  }

}
