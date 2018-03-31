import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class IE10Test {

	private WebDriver driver;
	private String username ="ritica_only_admin";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String ie_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\IEDriverServer.exe";
	private String url = "https://kaleasia.error-free.com/";
	SoftAssertions softly = new SoftAssertions();
	
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Load test 100 slides Mechanical Failure mode search in IE");
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
		//Deletes any previous cases if any
		obj1.deletePreviousCase(driver, obj1.keyword1me);
		//Goes to KALE home page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pii-logo-div-element-kale"))).click();
		//Deletes any previous cases if any
		obj1.deletePreviousCase(driver, obj1.keyword2me);
		//Goes to KALE home page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pii-logo-div-element-kale"))).click();
		//Deletes any previous cases if any
		obj1.deletePreviousCase(driver, obj1.keyword3me);
		//Goes to KALE home page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pii-logo-div-element-kale"))).click();
		//Create case r=1 for no images, r=2 for 100 images, r=3 for 50 images
		//No Images
		String case1=obj1.createCaseIE (driver, obj1.title2, obj1.keyword2me, 1);
		//100 Images
		String case2=obj1.createCaseIE (driver, obj1.title1, obj1.keyword1me, 2);
		//50 Images
		String case3=obj1.createCaseIE (driver, obj1.title3, obj1.keyword3me, 3);
		//Goes to KALE home page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pii-logo-div-element-kale"))).click();
		//Goes to Human Performance Search
		obj1.getMechPerformanceLink(driver);
		//Case Q4568
		System.out.println("Case with only images");
		long total1 = obj1.searchCase100(driver, obj1.keyword1me, case2);
		//Case Q9928		
		System.out.println("Case with no images");
		long total2 = obj1.searchCase100(driver, obj1.keyword2me, case1);
		//Case Q9638
		System.out.println("Case with 50 images and text");
		long total3 = obj1.searchCase100(driver, obj1.keyword3me, case3);
		System.out.println("Total time in seconds for case with only images:"+(total1/1000));
		System.out.println("Total time in seconds for case with no images:"+(total2/1000));
		System.out.println("Total time in seconds for case with 50 images:"+(total3/1000));
		//Store data in excel in Equipment Kale Asia
		obj1.storeData(driver,total1,total2,total3,obj1.sheetMechAsia);
		//Deletes all cases
		obj1.deleteCase(driver, case1);
		obj1.deleteCase(driver, case2);
		obj1.deleteCase(driver, case3);
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
