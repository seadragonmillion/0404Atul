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

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class FirefoxTest {

	private WebDriver driver;
	private String username = "jenkins_chinese";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String gecko_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\geckodriver.exe";
	private String url = System.getProperty("qaurl");
	   	
	@Rule
    public TestWatcher watcher = new TestWatcher() {
        @Override
        protected void failed(Throwable throwable, Description description) {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(scrFile,
                        new File("target/screenshots/"+"failshot.png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }

        @Override
        protected void finished(Description description) {
            driver.quit();
        }
	};
		  
		@Before
		  public void beforeTest() throws MalformedURLException{
			  
			  System.out.println("O&PiRCA Chinese check in Firefox");
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
	public void test() throws Exception {
		Login obj = new Login ();
		HiRCAChinese obj1 = new HiRCAChinese();
		OPiRCAChinese obj2 = new OPiRCAChinese();
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
		//Change language to chinese
		obj1.changeToChinese(driver);
		//Check path
		obj2.OPiRCApath(driver);
		//Change language to english
		obj1.changeToEnglish(driver);
		//Logout
		obj.logout(driver);
		afterTest(obj2);
	}
	
	 public void afterTest(OPiRCAChinese obj1) throws Exception {
		  
		 driver.manage().window().maximize(); 
		 Thread.sleep(2000); 
		 driver.quit();
		 obj1.softAssert();
		  
	  }

}
