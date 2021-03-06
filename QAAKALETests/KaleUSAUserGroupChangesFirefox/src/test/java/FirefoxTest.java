import kaleTestSoftware.*;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
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


public class FirefoxTest {

	private WebDriver driver;
	private String username ="jenkinsvm";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String gecko_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\geckodriver.exe";
	private String url = "https://kale.error-free.com/";
			
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
		  
		  System.out.println("Verify group change in Firefox");
		  System.setProperty("webdriver.gecko.driver",gecko_path);
		  ProfilesIni ffProfiles = new ProfilesIni();
		  FirefoxProfile profile = ffProfiles.getProfile("HiRCAEvent");
		  profile.setPreference("browser.download.folderList", 2);
		  profile.setPreference("browser.download.dir", "C:\\Users\\IEUser\\Downloads\\reports");
		  FirefoxOptions options = new FirefoxOptions();
		  options.setCapability(FirefoxDriver.PROFILE, profile);
		  driver = new FirefoxDriver(options);
		  Dimension initialSize= driver.manage().window().getSize();
		  System.out.println(initialSize);
		  int height=initialSize.getHeight();
		  if(height<930)
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
		Thread.sleep(5000);	
		WebDriverWait wait = new WebDriverWait(driver,20);	
		//Mark all email read
		obj1.emailMarkRead(obj1.emailUS,driver);
		//Deletes previous created group 2 under company 1
		obj1.deletesPreviousGroup(driver, obj1.group2US);
		//Deletes previous created company1,user1,group1
		obj1.deletesPrevious(driver, obj1.company_id1US);
		//Deletes previous created company1,user1,group1
		obj1.deletesPrevious(driver, obj1.company_id1US);
		//Deletes previous created company2,user2,group2
		obj1.deletesPrevious(driver, obj1.company_id2US);
		//Create company 1
		obj1.createCompany(driver, obj1.company_id1US);
		//Create group 1 under company 1
		HashMap<String, String> gpc1g1=obj1.createGroupWithExpirationDate(driver, obj1.company_id1US, obj1.company_id1US);
		//Create group 2 under company 1
		HashMap<String, String> gpc1g2=obj1.createGroupWithExpirationDate(driver, obj1.company_id1US, obj1.group2US);
		//Create company 2
		obj1.createCompany(driver, obj1.company_id2US);
		//Create group 2
		HashMap<String, String> gpc2g2=obj1.createGroupWithExpirationDate(driver, obj1.company_id2US, obj1.company_id2US);
		//Check if group view is correct
		obj1.groupView(driver, obj1.company_id1US, obj1.company_id2US, obj1.group2US, gpc1g1, gpc1g2, gpc2g2);
		//Verify change in group list and group moderator list when company is changed while creating new user
		obj1.verifyGroupListGroupModeratorChange(driver, obj1.company_id1US, obj1.company_id2US, obj1.group2US);
		//Create user in group 2
		obj1.createUser(driver, obj1.company_id2US, password, obj1.emailUS);
		//Logout as admin
		obj.logout(driver);
		//Activate user
		obj1.activateUser(obj1.emailUS,obj1.company_id2US,driver);
		//Login as new user under company 2
		obj1.loginAsNewUser(driver, obj1.company_id2US, password);
		//Logout as new user of company 2, login as Admin
		obj1.logoutLogin(driver, obj, username, password);
		//Change group and company to PII
		obj1.changeGroupCompany(driver, obj1.company_id2US, obj1.groupPII, obj1.companyPII);
		//Logout as Admin login as new user from company 2
		obj1.logoutLogin(driver, obj, obj1.company_id2US, password);
		//Get the list of all modules under PII group
		String [] op = obj1.allModuleList();
		//Check access to all modules
		obj1.checkAccess(driver, login, op);
		//Logout as new user of company 2, login as Admin
		obj1.logoutLogin(driver, obj, username, password);
		//Change user access to group 2 company 2
		obj1.changeGroupCompany(driver, obj1.company_id2US, obj1.company_id2US, obj1.company_id2US);
		//Logout as Admin login as new user from company 2
		obj1.logoutLogin(driver, obj, obj1.company_id2US, password);
		//Verify new user has access to one module only
		obj1.accessOneModule(driver,gpc2g2);
		//Logout as new user of company 2, login as Admin
		obj1.logoutLogin(driver, obj, username, password);
		//Change group to admin and company pii
		obj1.changeGroupCompany(driver, obj1.company_id2US, obj1.groupAdmin, obj1.companyPII);
		//Logout as Admin login as new user from company 2
		obj1.logoutLogin(driver, obj, obj1.company_id2US, password);		
		//Check access to all modules
		obj1.checkAccess(driver, login, op);
		//Logout as new user of company 2, login as Admin
		obj1.logoutLogin(driver, obj, username, password);
		//Change user access to group 2 company 2
		obj1.changeGroupCompany(driver, obj1.company_id2US, obj1.company_id2US, obj1.company_id2US);
		//Logout as Admin login as new user from company 2
		obj1.logoutLogin(driver, obj, obj1.company_id2US, password);		
		//Verify new user has access to only module
		obj1.accessOneModule(driver,gpc2g2);
		//Logout as new user of company 2, login as Admin
		obj1.logoutLogin(driver, obj, username, password);
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-admin"))).click();
		//Clicks on Accounts
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-accounts']/h3/a"))).click();
		//Delete user
		obj1.deleteUser(driver, obj1.company_id2US);
		//Delete group 2
		obj1.deleteGroup(driver, obj1.company_id2US);
		//Delete company 2
		obj1.deleteCompany(driver, obj1.company_id2US);
		//Delete group 2 under company 1
		obj1.deleteGroup(driver, obj1.group2US);
		//Delete group 1
		obj1.deleteGroup(driver, obj1.company_id1US);
		//Delete company 1
		obj1.deleteCompany(driver, obj1.company_id1US);
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
