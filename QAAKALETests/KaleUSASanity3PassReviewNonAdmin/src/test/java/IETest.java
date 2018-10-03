import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IETest {

	private InternetExplorerDriver driver;
	private String username ="jenkinsvmnonadmin";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String ie_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\IEDriverServer.exe";
	private String url = "https://kale.error-free.com/";

	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Performing sanity test on 3 Pass Review in Internet Explorer");
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
		Login obj = new Login ();
		PassReview obj1 = new PassReview();
		int login = obj.LoginUser(driver, username, password);
		System.out.println("Title after login: "+driver.getTitle());
		Thread.sleep(7000);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Switches to the iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		Thread.sleep(7000);
		if (login==1)
		{
          
          while(true)
		  {
         	 Thread.sleep(1000);
			  if (driver.findElement(By.cssSelector(".sticky.border-top-right.sticky-error")).isDisplayed())
			  {
				  WebElement ele =driver.findElement(By.cssSelector(".sticky.border-top-right.sticky-error"));
				  ele.findElement(By.className("sticky-close")).click();
				  break;
			  }
			  else break;
		  }
        }	
		Thread.sleep(4000);
		//Create report
		String recordName = obj1.createReport(driver);
		//Open report
		obj1.openReport(driver);
		//ShareReport
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
		obj1.shareReport(driver, username, password, 5);
		//Mark critical
		obj1.markCritical(driver, username, password, 5);
		//Delete report
		obj1.deleteNewRecord(driver, recordName,5,username);
		//Logout
		obj.logout(driver);
		afterTest(obj1);
	}
	
	public void afterTest(PassReview obj) throws Exception{
		
		//Browser closes
		driver.quit();
		obj.softAssert();
	}
}




