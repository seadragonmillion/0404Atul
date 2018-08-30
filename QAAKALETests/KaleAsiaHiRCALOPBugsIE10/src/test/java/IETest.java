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
	private String username = "qaacfi";
	private String password = "S2FsZTk0OTM1ODMwQA==";
	private String ie_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\IEDriverServer.exe";
	private String url = "https://kaleasia.error-free.com/";
	   
		@Before
		  public void beforeTest() throws MalformedURLException{
			  
			  System.out.println("HiRCA LOP Bug Check IE");
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
	public void test() throws Exception{
		Login obj = new Login ();
		HiRCALOPBug obj1 = new HiRCALOPBug();
		int login = obj.LoginUser(driver, username, password);
		System.out.println("Title after login: "+driver.getTitle());
		Thread.sleep(6000);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Switches to the iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		Thread.sleep(8000);
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
		//Fill mandatory data
		obj1.fillUpHiRCAEventInfo(driver);
		//Bug KALE 1959
		obj1.bugPath1KALE1959(driver);
		//Bug KALE 1926
		obj1.bugPathWith2LopsKALE1926(driver);
		//Bug KALE 1947
		obj1.bugPath1KALE1947(driver);
		//Bug KALE 1957
		obj1.bugKALE1957(driver);
		//Bug KALE 1846
		obj1.bugKALE1846(driver);
		//Bug KALE 1852
		obj1.bugKALE1852(driver);
		//Logout
		obj.logout(driver);
		afterTest(obj1);
	}
	
	 public void afterTest(HiRCALOPBug obj1) throws Exception {
		  
		  driver.quit();
		  obj1.softAssert();
		  
	  }

}
