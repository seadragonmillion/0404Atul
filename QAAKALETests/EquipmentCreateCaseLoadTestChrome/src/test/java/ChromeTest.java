import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 

public class ChromeTest {

	private WebDriver driver;
	private String username ="jenkins";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String chrome_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\chromedriver.exe";
	private String url = System.getProperty("qaurl");
	SoftAssertions softly = new SoftAssertions();
	
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Load test 100 slides Equipment performance search in Chrome");
		  System.setProperty("webdriver.chrome.driver",chrome_path);
		  driver = new ChromeDriver();
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
		obj1.deletePreviousCase(driver, obj1.keyword1eq);
		//Goes to KALE home page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pii-logo-div-element-kale"))).click();
		//Deletes any previous cases if any
		obj1.deletePreviousCase(driver, obj1.keyword2eq);
		//Goes to KALE home page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pii-logo-div-element-kale"))).click();
		//Deletes any previous cases if any
		obj1.deletePreviousCase(driver, obj1.keyword3eq);
		//Goes to KALE home page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pii-logo-div-element-kale"))).click();
		//Create case r=1 for no images, r=2 for 100 images, r=3 for 50 images
		//No Images
		String case1=obj1.createCaseChrome (driver, obj1.title2, obj1.keyword2eq, 1);
		//100 Images
		String case2=obj1.createCaseChrome (driver, obj1.title1, obj1.keyword1eq, 2);
		//50 Images
		String case3=obj1.createCaseChrome (driver, obj1.title3, obj1.keyword3eq, 3);
		//Goes to KALE home page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pii-logo-div-element-kale"))).click();
		//Goes to Human Performance Search
		obj1.getEquipPerformanceLink(driver);
		//Case Q4568
		System.out.println("Case with only images");
		long total1 = obj1.searchCase100(driver, obj1.keyword1eq, case2);
		//Case Q9928		
		System.out.println("Case with no images");
		long total2 = obj1.searchCase100(driver, obj1.keyword2eq, case1);
		//Case Q9638
		System.out.println("Case with 50 images and text");
		long total3 = obj1.searchCase100(driver, obj1.keyword3eq, case3);
		System.out.println("Total time in seconds for case with only images:"+(total1/1000));
		System.out.println("Total time in seconds for case with no images:"+(total2/1000));
		System.out.println("Total time in seconds for case with 50 images:"+(total3/1000));
		//Store data in excel in Equipment Kale Asia
		obj1.storeData(driver,total1,total2,total3,obj1.sheetEquipAsia);
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
