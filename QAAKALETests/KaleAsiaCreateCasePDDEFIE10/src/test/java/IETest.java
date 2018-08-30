import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class IETest {
	
	private WebDriver driver;
	private String username ="ritica";
	private String password = "S2FsZTQ2MTkxODAyQA==";
	private String ie_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\IEDriverServer.exe";
	private String url = "https://kaleasia.error-free.com/";
	
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Case Upload for PDD and EF in IE");
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
	public void test() throws Exception {
		Login obj = new Login ();
		CreateEquipmentCase obj1 = new CreateEquipmentCase ();
		EquipmentPDDandEF obj2 = new EquipmentPDDandEF ();
		ShareCheck obj3 = new ShareCheck();
		int login = obj.LoginUser(driver, username, password);
		System.out.println("Title after login: "+driver.getTitle());
		Thread.sleep(14000);
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
		//Waits for black loading message
		obj3.loadingServer(driver);
		//Deletes any previous cases if any for Prevention of Design Deficiencies
	    obj1.deletePreviousCase(driver, obj2.titlePDD);
	    //Deletes any previous cases if any for Engineering Fundamentals
	    obj1.deletePreviousCase(driver, obj2.titleEF);
	    //Create one case for Prevention of Design Deficiencies
	    List<String> casePDD = obj2.createCaseIE10(driver, obj2.keywordPDD, obj2.key1PDD, obj2.key2PDD, obj2.key3PDD, obj2.titlePDD);
	    System.out.println("Cases for Design "+casePDD);
	    //Create one case for Engineering Fundamentals
	    List<String> caseEF = obj2.createCaseIE10(driver, obj2.keywordEF, obj2.key1EF, obj2.key2EF, obj2.key3EF, obj2.titleEF);
	    System.out.println("Cases for Fundamentals "+caseEF);
	    Thread.sleep(2000);
	    //Verify if names of case modules correct
	    obj2.verifyCaseModuleNames(driver);
	    Thread.sleep(2000);
	    //Go to Equipment PII link
	    obj2.getEquipPerformancePIILink(driver);
	    Thread.sleep(2000);
	    //Browse for Prevention of Design Deficiencies case in Equipment PII
	    obj2.browseCase(driver, obj2.keywordPDD, casePDD.get(0), obj2.titlePDD);
	    Thread.sleep(2000);
	    //Go to Equipment PII link
	    obj2.getEquipPerformancePIILink(driver);
	    //Browse for Engineering Fundamentals case in Equipment PII
	    obj2.browseCase(driver, obj2.keywordEF, caseEF.get(0), obj2.titleEF);
	    Thread.sleep(2000);
	    //Go to Prevention of Design Deficiencies link
	    obj2.getPDDLink(driver);
	    //Browse for Prevention of Design Deficiencies case in PDD
	    obj2.browseCase(driver, obj2.keywordPDD, casePDD.get(0), obj2.titlePDD);
	    //Go to Engineering Fundamentals link
	    obj2.getEFLink(driver);
	    //Browse for Engineering Fundamentals case in EF
	    obj2.browseCase(driver, obj2.keywordEF, caseEF.get(0), obj2.titleEF);
	    //Search for case in Equipment performance by keyword
		obj2.searchCaseInEquipSearchByKeyword(driver, obj2.keywordPDD, casePDD.get(0));
		//Search for case in Equipment performance by case id
		obj2.searchCaseInEquipSearchByCaseID(driver, casePDD.get(0));
		//Search for case in Equipment performance by keyword
		obj2.searchCaseInEquipSearchByKeyword(driver, obj2.keywordEF, caseEF.get(0));
		//Search for case in Equipment performance by case id
		obj2.searchCaseInEquipSearchByCaseID(driver, caseEF.get(0));
		//Search for PDD and EF case in Failure Modes
		obj2.searchCaseInFailureModes(driver, caseEF.get(0), casePDD.get(0), obj2.keywordEF, obj2.keywordPDD);
		//Search for PDD and EF case in each other
		obj2.searchCasesInPDDAndEFModules(driver, caseEF.get(0), casePDD.get(0), obj2.keywordEF, obj2.keywordPDD);
		//Check keyword and cases in EF
		obj1.checkkeyword(driver, caseEF, obj2.keywordEF, obj2.key1EF, obj2.key2EF, obj2.key3EF, 2, obj2.titleEF);
		//Check keyword and cases in PDD
		obj1.checkkeyword(driver, casePDD, obj2.keywordPDD, obj2.key1PDD, obj2.key2PDD, obj2.key3PDD, 2, obj2.titlePDD);
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
