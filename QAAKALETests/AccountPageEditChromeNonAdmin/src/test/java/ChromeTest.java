import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import kaleTestSoftware.LanguageCheckOfReports;
import kaleTestSoftware.Login;


public class ChromeTest {

	private WebDriver driver;
	private String username ="jenkins_chinese";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String chrome_path = "C:\\drivers\\chromedriver.exe";
	private String url = "https://kaleqa.error-free.com/";

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
//            driver.quit();
        }
	};	

	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Ability to edit account page for non admin user in Chrome");
		  System.setProperty("webdriver.chrome.driver",chrome_path);
		  ChromeOptions options = new ChromeOptions();
          HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
          chromeOptionsMap.put("plugins.plugins_disabled", new String[] {
        		    "Chrome PDF Viewer"
        		});
          chromeOptionsMap.put("plugins.always_open_pdf_externally", true);
          
          String downloadFilepath = "C:\\Users\\mama\\report";
          //chromeOptionsMap.put("download.default_directory", downloadFilepath);
          HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
          chromePrefs.put("download.default_directory",  System.getProperty("user.dir")+ File.separator + "externalFiles");
          chromePrefs.put("profile.default_content_setting_values.automatic_downloads",1);
          chromePrefs.put("profile.default_content_settings.popups", 0);
          chromePrefs.put("download.prompt_for_download", false);
          chromePrefs.put("profile.content_settings.exceptions.automatic_downloads.*.setting", 1);
          options.setExperimentalOption("prefs", chromePrefs);
          
          options.addArguments("disable-popup-blocking");
          DesiredCapabilities cap = DesiredCapabilities.chrome();
          cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
          cap.setCapability(ChromeOptions.CAPABILITY, options);
          driver = new ChromeDriver(cap);
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
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='pii-iframe-main']")));
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
		/*//Logs out
		obj.logout(driver);
		afterTest(obj1);		
	}
	
	public void afterTest(LanguageCheckOfReports obj) throws Exception{
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-login-button")));
		//Browser closes
		driver.quit();
		obj.softAssert();
	}*/
	}
}
