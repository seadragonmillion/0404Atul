import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SanityTestEiRCA_FirefoxTest {

	private FirefoxDriver driver;
	private String username ="jenkinsvmnonadmin";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Performing sanity test on EiRCA in Firefox");
		  System.setProperty("webdriver.gecko.driver","C:\\Users\\rramakrishnan\\DriversForSelenium\\geckodriver.exe");
		  driver = new FirefoxDriver();
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
		  driver.navigate().to("https://kaledev.error-free.com/");
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }
	  
	
	  	  
	  @Test
	  public void SanityTest() throws Exception{
		  
		  Login obj = new Login();
		  EiRCA obj1 = new EiRCA();
		  //Logs in
		  int login = obj.LoginUser(driver, username, password);
		  Thread.sleep(5000);
		  System.out.println("Title after login: "+driver.getTitle());
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
		  //Clicks on Analysis 
		  try
		  {
			  driver.findElement(By.id("pii-main-menu-button-a")).click();
		  }catch (UnhandledAlertException f){			  
			  driver.switchTo().alert().dismiss();
		  }
		  obj1.reportCreate(driver, username);
		  //Gets the name of the record created
		  WebElement record = driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-mirca']/ul/li[2]/a"));
		  String recordName = record.getText();
		  //Opens record
		  obj1.openReport(driver);
		  //Downloads record
		  obj1.downloadRecordFirefox(driver);
		  //Shares report 0 for admin and 1 for non admin
		  obj1.shareReport(driver, username, password,1);
		  //Mark critical
		  obj1.markCritical(driver);
		  //Deletes the newly created record
		  obj1.deleteNewRecord(driver, recordName);
		  //Logs out
		  obj.logout(driver);	
		  afterTest(obj1);	  
	  }
	  
		 
		  public void afterTest(EiRCA obj1) throws Exception{
			 
			 driver.manage().window().maximize();
			 //Browser is closed
			 driver.quit();
			 obj1.softAssert();
		  }

}
