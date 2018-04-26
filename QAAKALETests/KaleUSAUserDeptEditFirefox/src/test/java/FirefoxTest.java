import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FirefoxTest {

	private WebDriver driver;
	private String username ="jenkinsvm";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String company_id="2017qaadeptedit";
	private String gecko_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\geckodriver.exe";
	private String url = "https://kale.error-free.com/";
	
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Verify department edit in Firefox");
		  System.setProperty("webdriver.gecko.driver",gecko_path);
		  ProfilesIni ffProfiles = new ProfilesIni();
		  FirefoxProfile profile = ffProfiles.getProfile("customFirefox");
		  FirefoxOptions options = new FirefoxOptions();
		  options.setCapability(FirefoxDriver.PROFILE, profile);
		  driver = new FirefoxDriver(options);
		  Dimension initialSize= driver.manage().window().getSize();
		  System.out.println(initialSize);
		  int height=initialSize.getHeight();
		  if(height<1900)
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
		Login obj = new Login();
		UserManagement obj1 = new UserManagement();
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
          }catch (NoSuchElementException e){
                 throw e;
          }
		 Thread.sleep(5000);
		 WebDriverWait wait = new WebDriverWait(driver,20);	
		 //Mark all email read
		 obj1.emailMarkRead(obj1.emailUS);
		 //Deletes previous created company,user,group
		 obj1.deletesPrevious(driver, company_id);
		 //Create company
		 obj1.createCompany(driver, company_id);
		 //Store dept list
		 List<String> dept1 = obj1.storeDepartmentList(driver);
		 //Create group
		 obj1.createGroup (driver, company_id);
		 //Create user
		 obj1.createUser (driver, company_id, password,obj1.emailUS);
		 //Logout as admin
		 obj.logout(driver);
		 //Activate user
		 obj1.activateUser(obj1.emailUS,driver);
		 //Login as new user
		 obj1.loginAsNewUser(driver, company_id, password);
		 //Go to HiRCA
		 WebElement element = obj1.goToHiRCA (driver);
		 //Create empty dept list
		 List<String> dept = new ArrayList<String>();
		 //Check dept list in HiRCA
		 obj1.checkDeptList(driver, dept1, dept, element);
		 //Logout as new user
		 obj.logout(driver);
		 driver.switchTo().defaultContent();
		 //Login as admin
		 login = obj.LoginUser(driver, username, password);
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
	        }catch (NoSuchElementException e){
	             throw e;
	        }
		 Thread.sleep(5000);
		 //Change dept list
		 obj1.editDept(driver, company_id, dept1);
		 //Logout as admin
		 obj.logout(driver);
		 driver.switchTo().defaultContent();
		 //Login as new user
		 obj1.loginAsNewUser(driver, company_id, password);
		 //Go to HiRCA
		 element = obj1.goToHiRCA (driver);
		 //Check dept list in HiRCA
		 obj1.checkDeptList(driver, dept1, dept, element);
		 //Logout as new user
		 obj.logout(driver);
		 driver.switchTo().defaultContent();
		 //Login as admin
		 login = obj.LoginUser(driver, username, password);
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
	        }catch (NoSuchElementException e){
	             throw e;
	        }
		 Thread.sleep(5000);
		 //Clicks on admin user name on top right corner
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		 //Clicks on admin option
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-admin"))).click();
		 //Clicks on Accounts
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-accounts']/h3/a"))).click();
		 //Delete user
		 obj1.deleteUser(driver, company_id);
		 //Delete group
		 obj1.deleteGroup(driver, company_id);
		 //Delete company
		 obj1.deleteCompany(driver, company_id);
		 //Logout
		 obj.logout(driver);
		 afterTest(obj1);
	}
	
	public void afterTest(UserManagement obj1) throws Exception{
		
		driver.manage().window().maximize();
		driver.quit();
		obj1.softAssert();
	}

}
