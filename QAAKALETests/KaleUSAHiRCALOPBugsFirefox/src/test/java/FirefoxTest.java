import kaleTestSoftware.*;
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
import org.openqa.selenium.firefox.ProfilesIni;


public class FirefoxTest {

	private WebDriver driver;
	private String username = "jenkinsvmnonadmin";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String gecko_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\geckodriver.exe";
	private String url = "https://kale.error-free.com/";
	   
		@Before
		  public void beforeTest() throws MalformedURLException{
			  
			  System.out.println("HiRCA LOP Bug Check Firefox");
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
		HiRCALOPBug obj1 = new HiRCALOPBug();
		int login = obj.LoginUser(driver, username, password);
		System.out.println("Title after login: "+driver.getTitle());
		//Switches to the iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
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
		//Fill mandatory data
		obj1.allBugsHiRCA(driver);
		//Logout
		obj.logout(driver);
		afterTest(obj1);
	}
	
	 public void afterTest(HiRCALOPBug obj1) throws Exception {
		  
		 driver.manage().window().maximize(); 
		 driver.quit();
		  obj1.softAssert();
		  
	  }

}
