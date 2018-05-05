import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ChromeTest {

	private WebDriver driver;
	private String username ="jenkinsvmnonadmin";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String chrome_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\chromedriver.exe";
	private String url = "https://kaledev.error-free.com/";
	SoftAssertions softly = new SoftAssertions();
	
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Ability to edit account page for non admin user in Chrome");
		  System.setProperty("webdriver.chrome.driver",chrome_path);
		  ChromeOptions options = new ChromeOptions();
          HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
          chromeOptionsMap.put("plugins.plugins_disabled", new String[] {
        		    "Chrome PDF Viewer"
        		});
          chromeOptionsMap.put("plugins.always_open_pdf_externally", true);
          options.setExperimentalOption("prefs", chromeOptionsMap);
          String downloadFilepath = "C:\\Users\\IEUser\\Downloads\\reports";
          chromeOptionsMap.put("download.default_directory", downloadFilepath);
          options.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
          options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
          options.setCapability(ChromeOptions.CAPABILITY, options);
          driver = new ChromeDriver(options);
		  //Browser is maximized
		  driver.manage().window().maximize();
		  //Browser navigates to the KALE url
		  driver.navigate().to(url);
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }
	
	
	@Test
	public void test() throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		Login obj = new Login();
		LanguageCheckOfReports obj1 = new LanguageCheckOfReports();
		//Logs in
		int login = obj.LoginUser(driver,username,password);
		System.out.println("Title after login: "+driver.getTitle());
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
		Thread.sleep(2000);
		//Clicks on Account
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-acct"))).click();
		//Change Name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-name"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-name"))).sendKeys("QAA changed");
		//Change Company name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-company"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-company"))).sendKeys("QAA-PII changed");
		//Change department
		WebElement dropdown = driver.findElement(By.id("pii-admin-user-dept"));
		Select s = new Select (dropdown);
		s.selectByVisibleText("Design Engineering");
		//Change job title
		WebElement dropdown1 = driver.findElement(By.id("pii-admin-user-jobtitle"));
		Select s1 = new Select (dropdown1);
		s1.selectByVisibleText("Support");
		//Change email id
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-email"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-email"))).sendKeys("Email changed");
		//Changes language to Chinese
		dropdown1 = driver.findElement(By.id("pii-admin-user-language"));
		Select s4 = new Select (dropdown1);
		s4.selectByVisibleText("Chinese");
		//
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-button-save"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-confirmed"))).click();
		//Waits for loading message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Clicks on Activity
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-activity"))).click();
		//Waits for loading message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Checks language in error meter
		WebElement l = obj1.errorMeter(driver,0);
		obj1.downloadReportChrome (driver, 0, l);
		//Checks language in HPI
		obj1.hpi(driver,0);
		//Checks language in HiRCA
		l = obj1.hirca(driver,0);
		obj1.downloadReportChrome (driver, 0, l);
		//Checks language in EiRCA
		l = obj1.eirca(driver,0);
		obj1.downloadReportChrome (driver, 0, l);
		//Checks language in O&PiRCA
		l = obj1.opirca(driver,0);
		obj1.downloadReportChrome (driver, 0, l);
		//Checks language in Job Observation
		obj1.jobs(driver,0);
		//Checks language in 3 Pass Review
		obj1.passReview(driver,0);
		//Checks language in Remote Verification
		l = obj1.rv(driver,0);
		obj1.downloadReportChrome (driver, 0, l);
		//Logs out
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-signout-button"))).click();
		Thread.sleep(2000);
		//Login again
		login = obj.LoginUser(driver, username, password);
		Thread.sleep(3000);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Switches to the iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		Thread.sleep(5000);
		//Clicks on Account
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-acct"))).click();
		//Verifies changed data
		String name=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-name"))).getAttribute("value");
		System.out.println(name);
		softly.assertThat(name).as("test data").isEqualTo("QAA changed");
		String company =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-company"))).getAttribute("value");
		System.out.println(company);
		softly.assertThat(company).as("test data").isEqualTo("QAA-PII changed");
		String dept=driver.findElement(By.xpath(".//*[@id='pii-admin-user-dept-button']/span")).getText();
		System.out.println(dept);
		softly.assertThat(dept).as("test data").isEqualTo("Design Engineering");
		String jobTitle=driver.findElement(By.xpath(".//*[@id='pii-admin-user-jobtitle-button']/span")).getText();
		System.out.println(jobTitle);
		softly.assertThat(jobTitle).as("test data").isEqualTo("Support");
		String email=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-email"))).getAttribute("value");
		System.out.println(email);
		softly.assertThat(email).as("test data").isEqualTo("Email changed");
		//Changes data back to original value
		//Change Name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-name"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-name"))).sendKeys("QAA");
		//Change Company name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-company"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-company"))).sendKeys("QAA-PII");
		//Change department
		WebElement dropdown2 = driver.findElement(By.id("pii-admin-user-dept"));
		Select s2 = new Select (dropdown2);
		s2.selectByVisibleText("Information Technology (IT)");
		//Change job title
		WebElement dropdown3 = driver.findElement(By.id("pii-admin-user-jobtitle"));
		Select s3 = new Select (dropdown3);
		s3.selectByVisibleText("Engineer");
		//Change email id
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-email"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-email"))).sendKeys("rramakrishnan@errorfree.com");
		//Changes language to English
		dropdown1 = driver.findElement(By.id("pii-admin-user-language"));
		Select s5 = new Select (dropdown1);
		s5.selectByVisibleText("English");
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-button-save"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-confirmed"))).click();
		//Waits for loading message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Clicks on Activity
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-activity"))).click();
		//Waits for loading message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Checks language in error meter
		l=obj1.errorMeter(driver,1);
		obj1.downloadReportChrome (driver, 1, l);
		//Checks language in HPI
		obj1.hpi(driver,1);
		//Checks language in HiRCA
		l=obj1.hirca(driver,1);
		obj1.downloadReportChrome (driver, 1, l);
		//Checks language in EiRCA
		l=obj1.eirca(driver,1);
		obj1.downloadReportChrome (driver, 1, l);
		//Checks language in O&PiRCA
		l=obj1.opirca(driver,1);
		obj1.downloadReportChrome (driver, 1, l);
		//Checks language in Job Observation
		obj1.jobs(driver,1);
		//Checks language in 3 Pass Review
		obj1.passReview(driver,1);
		//Checks language in Remote Verification
		Thread.sleep(2000);
		l=obj1.rv(driver,1);
		obj1.downloadReportChrome (driver, 1, l);
		//Logs out
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-signout-button"))).click();
		Thread.sleep(2000);
		afterTest();		
	}
	
	public void afterTest(){
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-login-button")));
		//Browser closes
		driver.quit();
		softly.assertAll();
	}

}
