import kaleTestSoftware.*;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class IETest {

	private WebDriver driver;
	private String username ="jenkinsvm";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String ie_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\IEDriverServer.exe";
	private String url = System.getProperty("qaurl");
	SoftAssertions softly = new SoftAssertions();
	
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
		  
		  System.out.println("Human case upload in Internet Explorer");
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
		  CaseBrowse obj = new CaseBrowse();
		  CreateHumanCase obj1 = new CreateHumanCase();
		  Login obj2 = new Login();
		  int login = obj2.LoginUser(driver, username, password);
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
		  int m=obj1.deletePreviousCase(driver, obj1.title);
		  //Create case
		  List<String> caseID = obj1.createCaseHumanIE10(driver, m, obj1.title, obj1.keyword_same, obj1.key1, obj1.key2, obj1.key3);
		  Thread.sleep(2000);
		  //Browse through a slide
		  obj1.compareSlide(driver, caseID, obj1.title);
		  Thread.sleep(2000);
		  obj1.checkkeyword(driver, caseID, obj1.keyword_same, obj1.key1, obj1.key2, obj1.key3, obj1.title);
		  //Search for keyword with all Special characters
		  obj.searchWithKeyKeywordWithAllSpecialCharacters(driver,caseID.get(0));
		  //Search for keyword with special character in middle and check if dropdown disappears
		  obj.searchWithKeywordKALE1964(driver,softly);
		  //Change keyword and search for it
		  obj1.changeKeywordKALE1969(driver,caseID,obj1.keyword_same);
		  //Youtube link test
		  obj1.searchCaseWithLinks(driver, obj1.keyword_same, caseID);
		  //View case with links and then a case without links
		  obj1.viewCaseInAdmin(driver, caseID, obj1.keyword_same);
		  //Edit links
		  obj1.editLinks(driver, caseID);
		  //Delete links
		  obj1.deleteLinks(driver, caseID);
		  Thread.sleep(2000);
		  //Delete case
		  obj1.deleteCase(driver, caseID);
		  Thread.sleep(2000);
		  //Logs out
		  obj2.logout(driver);
		  afterTest(obj1);
	}
	
	public void afterTest(CreateHumanCase obj) throws Exception{
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-login-button")));
		//Browser closes
		driver.quit();
		obj.softAssert();
	}

}
