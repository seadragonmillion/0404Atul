import kaleTestSoftware.*;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class IE10Test {

	private WebDriver driver;
	private String username ="jenkins_us_chinese";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String ie_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\IEDriverServer.exe";
	private String url = "https://kale.error-free.com/";
	
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Logout message check and remember password check in Internet Explorer");
		  System.setProperty("webdriver.ie.driver",ie_path);
		  DesiredCapabilities cap = new DesiredCapabilities(); 
		  cap.setCapability("ignoreZoomSettings", true);
		  cap.setCapability("requireWindowFocus", true);
		  driver = new InternetExplorerDriver(cap);
		  //Browser is maximized
		  driver.manage().window().maximize();
		  //Browser navigates to the KALE url
		  driver.navigate().to(url);
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);		  
	  }
	
		@Test
	public void test() throws Exception {
		
		UserSessionExpired obj = new UserSessionExpired();
		obj.loginSessionExpired(driver, username, password);
		afterTest(obj);		
	}
	
	public void afterTest(UserSessionExpired obj) throws Exception{
		
		//Browser closes
		driver.quit();
		obj.softAssert();
	}

}
