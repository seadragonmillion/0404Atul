import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;


public class FirefoxTest {

	private WebDriver driver;
	private String username = "jenkins_2_nonadmin";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String gecko_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\geckodriver.exe";
	private String url = "https://kaleasia.error-free.com/";
	   
		@Before
		  public void beforeTest() throws MalformedURLException{
			  
			  System.out.println("HiRCA Level 1 path in Firefox");
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
			  if(height<950)
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
	public void test() throws Exception{
		Login obj = new Login ();
		HiRCALevel1 obj1 = new HiRCALevel1();
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
		//Check path
		obj1.HiRCAPathCheck(driver, username);
		//Delete report
		obj1.deleteReport(driver);
		//Logout
		obj.logout(driver);
		afterTest(obj1);
	}
	
	 public void afterTest(HiRCALevel1 obj1) throws Exception {
		  
		  driver.quit();
		  obj1.softAssert();
		  
	  }

}
