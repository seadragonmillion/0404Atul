import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;


public class ChromeTest {

	private WebDriver driver;
	private String username = "qaacfi";
	private String password = "S2FsZTk0OTM1ODMwQA==";
	   
		@Before
		  public void beforeTest() throws MalformedURLException{
			  
			  System.out.println("EiRCA Chinese check in Chrome");
			  System.setProperty("webdriver.chrome.driver","C:\\Users\\rramakrishnan\\DriversForSelenium\\chromedriver.exe");
			  ChromeOptions options = new ChromeOptions();
			  HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
	          chromeOptionsMap.put("plugins.plugins_disabled", new String[] {
	        		    "Chrome PDF Viewer"
	        		});
	          chromeOptionsMap.put("plugins.always_open_pdf_externally", true);
	          options.setExperimentalOption("prefs", chromeOptionsMap);
	          String downloadFilepath = "C:\\Users\\IEUser\\Downloads\\reports";
	          chromeOptionsMap.put("download.default_directory", downloadFilepath);
	          options.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
	          options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	          options.setCapability(ChromeOptions.CAPABILITY, options);
	          driver = new ChromeDriver(options);
			  //Browser is maximized
			  driver.manage().window().maximize();
			  //Browser navigates to the KALE url
			  driver.navigate().to("https://kaleasia.error-free.com/");
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  }
	
	@Test
	public void test() throws Exception{
		Login obj = new Login ();
		HiRCAChinese obj1 = new HiRCAChinese();
		HiRCALevel1 obj2 = new HiRCALevel1();
		EiRCAChinese obj3 = new EiRCAChinese();
		int login = obj.LoginUser(driver, username, password);
		System.out.println("Title after login: "+driver.getTitle());
		Thread.sleep(5000);
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
		Thread.sleep(4000);
		//Change language to english
		obj1.changeToEnglish(driver);
		//Change language to chinese
		obj3.EiRCApath(driver);
		//Delete report
		obj2.deleteReport(driver);
		//Change language to english
		obj1.changeToEnglish(driver);
		//Logout
		obj.logout(driver);
		afterTest(obj3);
	}
	
	 public void afterTest(EiRCAChinese obj1) throws Exception {
		  
		  driver.quit();
		  obj1.softAssert();
		  
	  }

}
