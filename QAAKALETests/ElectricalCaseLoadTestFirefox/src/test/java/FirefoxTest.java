import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FirefoxTest {

	private FirefoxDriver driver;
	private String username ="ritica_only_admin";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String gecko_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\geckodriver.exe";
	private String url = "https://kaledev.error-free.com/";
	SoftAssertions softly = new SoftAssertions();
	
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Load test 100 slides Electrical Failure mode search in Firefox");
		  System.setProperty("webdriver.gecko.driver",gecko_path);
		  ProfilesIni ffProfiles = new ProfilesIni();
		  FirefoxProfile profile = ffProfiles.getProfile("customFirefox");
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
		EquipmentCaseLoad obj1 = new EquipmentCaseLoad ();
		int login = obj.LoginUser(driver, username, password);
		System.out.println("Title after login: "+driver.getTitle());
		Thread.sleep(2000);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Switches to the iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		try{
               if (login==1)
               {
                     WebDriverWait wait2 = new WebDriverWait(driver,20);
                     wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();
               }
        }catch (NoSuchElementException e){
               throw e;
        }
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver,20);
		//Waits for black loading message
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Goes to Electrical Failure mode Search
		obj1.getElecPerformanceLink(driver);
		//Case F8909
		System.out.println("Case with only images");
		long total1 = obj1.searchCase100(driver, obj1.keyword1ee, "8909");
		//Case F5689		
		System.out.println("Case with no images");
		long total2 = obj1.searchCase100(driver, obj1.keyword2ee, "5689");
		//Case F5679
		System.out.println("Case with 50 images and text");
		long total3 = obj1.searchCase100(driver, obj1.keyword3ee, "5679");
		System.out.println("Total time in seconds for case with only images:"+(total1/1000));
		System.out.println("Total time in seconds for case with no images:"+(total2/1000));
		System.out.println("Total time in seconds for case with 50 images:"+(total3/1000));
		//Store data in excel 
		obj1.storeData(driver,total1,total2,total3,obj1.sheetElecDev);
		//Logout
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-signout-button"))).click();
		afterTest();		
	}
	
	public void afterTest() {
		  driver.quit();
		  softly.assertAll();
		  
	  }

}
