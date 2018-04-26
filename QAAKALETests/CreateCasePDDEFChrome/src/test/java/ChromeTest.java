import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

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
	private String username ="ritica_only_admin";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String chrome_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\chromedriver.exe";
	private String url = "https://kaledev.error-free.com/";
	
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Case Upload for PDD and EF in Chrome");
		  System.setProperty("webdriver.chrome.driver",chrome_path);
		  driver = new ChromeDriver();
		  //Browser is maximized
		  driver.manage().window().maximize();
		  //Browser navigates to the KALE url
		  driver.navigate().to(url);
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }

	@Test
	public void test() throws Exception {
		Login obj = new Login ();
		EquipmentCaseLoad obj1 = new EquipmentCaseLoad ();
		EquipmentPDDandEF obj2 = new EquipmentPDDandEF ();
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
		//Deletes any previous cases if any for Prevention of Design Deficiencies
	    obj1.deletePreviousCase(driver, obj2.keywordPDD);
	    //Go to KALE homepage
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pii-logo-div-element-kale"))).click();
	    //Deletes any previous cases if any for Engineering Fundamentals
	    obj1.deletePreviousCase(driver, obj2.keywordEF);
	    //Create one case for Prevention of Design Deficiencies
	    String casePDD = obj2.createCaseChrome(driver, obj2.keywordPDD, obj2.titlePDD);
	    //Create one case for Engineering Fundamentals
	    String caseEF = obj2.createCaseChrome(driver, obj2.keywordEF, obj2.titleEF);
	    Thread.sleep(2000);
	    //Verify if names of case modules correct
	    obj2.verifyCaseModuleNames(driver);
	    Thread.sleep(2000);
	    //Go to Equipment PII link
	    obj2.getEquipPerformancePIILink(driver);
	    Thread.sleep(2000);
	    //Browse for Prevention of Design Deficiencies case in Equipment PII
	    obj2.browseCase(driver, obj2.keywordPDD, casePDD, obj2.titlePDD);
	    //Go to KALE homepage
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pii-logo-div-element-kale"))).click();
	    Thread.sleep(2000);
	    //Go to Equipment PII link
	    obj2.getEquipPerformancePIILink(driver);
	    //Browse for Engineering Fundamentals case in Equipment PII
	    obj2.browseCase(driver, obj2.keywordEF, caseEF, obj2.titleEF);
	    Thread.sleep(2000);
	    //Go to KALE homepage
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pii-logo-div-element-kale"))).click();	    
	    //Go to Prevention of Design Deficiencies link
	    obj2.getPDDLink(driver);
	    //Browse for Prevention of Design Deficiencies case in PDD
	    obj2.browseCase(driver, obj2.keywordPDD, casePDD, obj2.titlePDD);
	    //Go to KALE homepage
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pii-logo-div-element-kale"))).click();	    
	    //Go to Engineering Fundamentals link
	    obj2.getEFLink(driver);
	    //Browse for Engineering Fundamentals case in EF
	    obj2.browseCase(driver, obj2.keywordEF, caseEF, obj2.titleEF);
	    //Delete Prevention of Design Deficiencies case
	    obj1.deleteCase(driver, casePDD);
	    //Delete Engineering Fundamentals case
	    obj1.deleteCase(driver, caseEF);
	    //Logout
	    obj.logout(driver);
		afterTest(obj2);		
	}
	
	public void afterTest(EquipmentPDDandEF obj2) throws Exception{
		  driver.quit();
		  obj2.softAssert();
	  }

}
