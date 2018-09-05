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

public class HumanChromeTest {

	private WebDriver driver;
	private String username ="jenkinsvm";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String chrome_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\chromedriver.exe";
	private String url = "https://kale.error-free.com/";

	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Performing sanity test on Human Performance Search in Chrome");
		  System.setProperty("webdriver.chrome.driver",chrome_path);
		  driver = new ChromeDriver();
		  //Browser is maximized
		  driver.manage().window().maximize();
		  //Browser navigates to the KALE url
		  driver.navigate().to(url);
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }	
	
	@Test
	  public void SanityTest() throws Exception{
		  
		  Login obj = new Login();
		  CaseBrowse obj1 = new CaseBrowse();
		  //Logs in
		  int login = obj.LoginUser(driver, username, password);
		  System.out.println("Title after login: "+driver.getTitle());
		  Thread.sleep(5000);
		  //Waits for the page to load
	      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	      Thread.sleep(5000);
		  //Switches to the iframe
		  driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		  try{
                 if (login==1)
                 {
                       WebDriverWait wait2 = new WebDriverWait(driver,20);
                       wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();
                 }
          }catch (NoSuchElementException |org.openqa.selenium.TimeoutException e){
                    
              }
		  Thread.sleep(4000);
		  //Clicks on Human Performance Search
		  obj1.getHumanPerformanceLink(driver,0);
		  //Verify all search options
		  obj1.verifySearchOptionsHuman(driver, obj1.keywordHumanProd, obj1.caseHumanProd);
		  //Checks with keyword with %
		  obj1.searchWithPercentHuman(driver, obj1.keywordHumanProdPercent, obj1.caseHumanProdPercent);
		  Thread.sleep(1000);
		  //Term search
		  obj1.browseTermHuman(driver, obj1.keywordHumanProd, obj1.caseHumanProd, obj1.titleHumanProd);
		  //Case id search
		  obj1.browseCaseIDHuman(driver, obj1.caseHumanProd, obj1.titleHumanProd);
		  //Search for cases with keyword color
		  obj1.searchColorCasesHuman(driver);
		  //Logs out
		  obj.logout(driver);
		  Thread.sleep(2000);
		  afterTest(obj1);		  		  
	}
	
	public void afterTest(CaseBrowse obj) throws Exception{
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-login-button")));
		//Browser closes
		driver.quit();
		obj.softAssert();
	}
		  
	

}
