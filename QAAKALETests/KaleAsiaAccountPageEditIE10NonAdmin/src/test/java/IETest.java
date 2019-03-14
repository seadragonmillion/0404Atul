import kaleTestSoftware.*;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class IETest {

	private WebDriver driver;
	private String username ="jenkins_chinese";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String ie_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\IEDriverServer.exe";
	private String url = "https://kaleasia.error-free.com/";
	
    @Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Ability to edit account page for non admin user in Internet Explorer");
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
		
		Login obj = new Login();
		LanguageCheckOfReports obj1 = new LanguageCheckOfReports();
		//Logs in
		int login = obj.LoginUser(driver,username,password);
		System.out.println("Title after login: "+driver.getTitle());
	    //Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Switches to the iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		Thread.sleep(5000);
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
		Thread.sleep(2000);
		//language check
		obj1.languageChangeTest(driver, username, password);
		//Logs out
		obj.logout(driver);
		afterTest(obj1);		
	}
	
	public void afterTest(LanguageCheckOfReports obj) throws Exception{
		
		//Browser closes
		driver.quit();
		obj.softAssert();
	}

}
