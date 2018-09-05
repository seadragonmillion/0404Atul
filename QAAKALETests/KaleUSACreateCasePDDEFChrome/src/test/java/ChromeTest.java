import java.net.MalformedURLException;
import java.util.List;
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
	private String username ="jenkinsvm";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String chrome_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\chromedriver.exe";
	private String url = "https://kale.error-free.com/";
	
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
		CreateEquipmentCase obj1 = new CreateEquipmentCase ();
		EquipmentPDDandEF obj2 = new EquipmentPDDandEF ();
		ShareCheck obj3 = new ShareCheck();
		int login = obj.LoginUser(driver, username, password);
		System.out.println("Title after login: "+driver.getTitle());
		Thread.sleep(5000);
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
        }catch (NoSuchElementException |org.openqa.selenium.TimeoutException e){
                    
              }
		Thread.sleep(5000);
		//Waits for black loading message
		obj3.loadingServer(driver);
		//Deletes any previous cases if any for Prevention of Design Deficiencies
	    obj1.deletePreviousCase(driver, obj2.titlePDDUS);
	    //Deletes any previous cases if any for Engineering Fundamentals
	    obj1.deletePreviousCase(driver, obj2.titleEFUS);
	    //Create one case for Prevention of Design Deficiencies
	    List<String> casePDD = obj2.createCaseChrome(driver, obj2.keywordPDDUS, obj2.key1PDDUS, obj2.key2PDDUS, obj2.key3PDDUS, obj2.titlePDDUS);
	    System.out.println("Cases for Design "+casePDD);
	    //Create one case for Engineering Fundamentals
	    List<String> caseEF = obj2.createCaseChrome(driver, obj2.keywordEFUS, obj2.key1EFUS, obj2.key2EFUS, obj2.key3EFUS, obj2.titleEFUS);
	    System.out.println("Cases for Fundamentals "+caseEF);
	    Thread.sleep(2000);
	    //Verify if names of case modules correct
	    obj2.verifyCaseModuleNames(driver);
	    Thread.sleep(2000);
	    //Go to Equipment PII link
	    obj2.getEquipPerformancePIILink(driver);
	    Thread.sleep(2000);
	    //Browse for Prevention of Design Deficiencies case in Equipment PII
	    obj2.browseCase(driver, obj2.keywordPDDUS, casePDD.get(0), obj2.titlePDDUS);
	    Thread.sleep(2000);
	    //Go to Equipment PII link
	    obj2.getEquipPerformancePIILink(driver);
	    //Browse for Engineering Fundamentals case in Equipment PII
	    obj2.browseCase(driver, obj2.keywordEFUS, caseEF.get(0), obj2.titleEFUS);
	    Thread.sleep(2000);
	    //Go to Prevention of Design Deficiencies link
	    obj2.getPDDLink(driver);
	    //Browse for Prevention of Design Deficiencies case in PDD
	    obj2.browseCase(driver, obj2.keywordPDDUS, casePDD.get(0), obj2.titlePDDUS);
	    //Go to Engineering Fundamentals link
	    obj2.getEFLink(driver);
	    //Browse for Engineering Fundamentals case in EF
	    obj2.browseCase(driver, obj2.keywordEFUS, caseEF.get(0), obj2.titleEFUS);
	    //Search for case in Equipment performance by keyword
		obj2.searchCaseInEquipSearchByKeyword(driver, obj2.keywordPDDUS, casePDD.get(0));
		//Search for case in Equipment performance by case id
		obj2.searchCaseInEquipSearchByCaseID(driver, casePDD.get(0));
		//Search for case in Equipment performance by keyword
		obj2.searchCaseInEquipSearchByKeyword(driver, obj2.keywordEFUS, caseEF.get(0));
		//Search for case in Equipment performance by case id
		obj2.searchCaseInEquipSearchByCaseID(driver, caseEF.get(0));
		//Search for PDD and EF case in Failure Modes
		obj2.searchCaseInFailureModes(driver, caseEF.get(0), casePDD.get(0), obj2.keywordEFUS, obj2.keywordPDDUS);
		//Search for PDD and EF case in each other
		obj2.searchCasesInPDDAndEFModules(driver, caseEF.get(0), casePDD.get(0), obj2.keywordEFUS, obj2.keywordPDDUS);
		//Check keyword and cases in EF
		obj1.checkkeyword(driver, caseEF, obj2.keywordEFUS, obj2.key1EFUS, obj2.key2EFUS, obj2.key3EFUS, 2, obj2.titleEFUS);
		//Check keyword and cases in PDD
		obj1.checkkeyword(driver, casePDD, obj2.keywordPDDUS, obj2.key1PDDUS, obj2.key2PDDUS, obj2.key3PDDUS, 2, obj2.titlePDDUS);
	    //Delete Prevention of Design Deficiencies case
	    obj1.deleteCase(driver, casePDD);
	    System.out.println("Cases deleted for Design");
	    //Delete Engineering Fundamentals case
	    obj1.deleteCase(driver, caseEF);
	    System.out.println("Cases deleted for Fundamentals");
	    //Logout
	    obj.logout(driver);
		afterTest(obj2);		
	}
	
	public void afterTest(EquipmentPDDandEF obj2) throws Exception{
		  driver.quit();
		  obj2.softAssert();
	  }

}
