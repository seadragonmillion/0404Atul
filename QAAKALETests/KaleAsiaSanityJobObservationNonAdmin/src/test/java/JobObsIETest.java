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

public class JobObsIETest {

	private InternetExplorerDriver driver;
	private String username ="qaacfi";
	 private String password = "S2FsZTk0OTM1ODMwQA==";
	private String ie_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\IEDriverServer.exe";
	private String url = "https://kaleasia.error-free.com/";
	
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Performing sanity test on Job Observation Analysis in Internet Explorer");
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
		  JobObservation obj1 = new JobObservation();
		  //Logs in
		  int login = obj.LoginUser(driver, username, password);
		  System.out.println("Title after login: "+driver.getTitle());
		  //Waits for the page to load
	      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	      Thread.sleep(7000);
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
		  //Create report
		  String recordName = obj1.reportCreate(driver);
		  Thread.sleep(2000);
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
		  obj1.shareReport(driver,username,password, 1);
		  Thread.sleep(2000);
		  //Mark critical integer same as shareReport
		  obj1.markCritical(driver,username, password,1);
		  //Deletes the newly created record, integer same as shareReport
		  obj1.deleteNewRecord(driver, recordName,1);
		  //Logs out
		  obj.logout(driver);
		  Thread.sleep(2000);
		  afterTest(obj1);
		  		  
	}
	
	
	public void afterTest(JobObservation obj) throws Exception{
		
	    //Browser closes
		driver.quit();
		obj.softAssert();
	}

}
