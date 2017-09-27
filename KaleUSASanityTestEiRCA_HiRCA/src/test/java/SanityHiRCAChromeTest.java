import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;

public class SanityHiRCAChromeTest {
	private WebDriver driver;
    private String username ="ritica";
	private String password = "Kale46191802@";
	private String chrome_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\chromedriver.exe";
	private String url = "https://kale.error-free.com/";
	private String EventTitleChrome = "Sanity Test Chrome";	
	private int login =0;
  
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Performing sanity test on HiRCA in Chrome");
		  System.setProperty("webdriver.chrome.driver",chrome_path);
		  driver = new ChromeDriver();
		  //Browser is maximized
		  driver.manage().window().maximize();
		  //Browser navigates to the KALE url
		  driver.navigate().to(url);
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }
	  
	
	  public void Login() {
		  
		  System.out.println("Title before login: "+driver.getTitle());
		  //Login button is located and clicked
		  driver.findElement(By.id("pii-login-button")).click();
		  //Login pop up is located and clicked
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("popupLogin"))).click();
		  //Username text field is located and the username is entered
		  driver.findElement(By.id("pii-un")).sendKeys(username);
		  //Password field is located and the password is entered
		  driver.findElement(By.id("pii-pw")).sendKeys(password);
		  //Sign in button is located and clicked
		   String user = driver.findElement(By.id("pii-un")).getAttribute("value");
		  String pw = driver.findElement(By.id("pii-pw")).getAttribute("value");
		  int c=1;
		  if (user.equals(username)==true)
		  {
			  if(pw.equals(password)==true)
			  {
				  //Sign in button is located and clicked
				  driver.findElement(By.id("pii-signin-button")).click();  
				  WebElement element = driver.findElement(By.id("pii-signin-message"));
				  String text = element.getText();
				  if (element.isDisplayed())
				  {
					  if(text.isEmpty())
						  System.out.println("Logged in");
					  else
					  {
						  driver.findElement(By.id("pii-pw")).sendKeys(password);
						  //Sign in button is located and clicked
						  driver.findElement(By.id("pii-signin-button")).click();
						  login =1;
					  }
					  			  
				  }
			  }
			
		  }
		  else
		  {
			  while(c>0)
			  {
				  Thread.sleep(1000);
				  driver.findElement(By.id("pii-un")).clear();
				  driver.findElement(By.id("pii-pw")).clear();
				  //Username text field is located and the username is entered
				  driver.findElement(By.id("pii-un")).sendKeys(username);
				  //Password field is located and the password is entered
				  driver.findElement(By.id("pii-pw")).sendKeys(password);
				  c=c+1;
				  if (user.equals(username)==true)
				  {
					  if(pw.equals(password)==true)
					  {
						  //Sign in button is located and clicked
						  driver.findElement(By.id("pii-signin-button")).click();
						  break;
					  }
					
				  }
			  }
		  }
	  }
	  
	  public void deleteNewRecord(String recordName) throws Exception{
			  
			  //CLicks on first newly created record
			  driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a")).click();
			  //Clicks on delete button
			  driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[3]")).click();
			  WebDriverWait wait = new WebDriverWait(driver,10);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title")));
			  //Clicks on delete report
			  driver.findElement(By.id("pii-user-home-dialog-confirmed")).click();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
			  Thread.sleep(2000);
			  driver.findElement(By.id("pii-user-home-panel-btn-irca")).click();
			  //Verify record deleted
			  //Click on 1st record
			  String name = driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a")).getText();
			  System.out.println(name);
			  if (name!=recordName)
				  System.out.println("Record deleted");
			  else
				  System.out.println("Record could not be deleted");
			  			  
		  }

	  
	  @Test
	  public void SanityTest() throws Exception{
		  
		  Login();
		  System.out.println("Title after login: "+driver.getTitle());
		  Thread.sleep(4000);
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  
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
		  //Clicks on Analysis
		  try
		  {
			  driver.findElement(By.id("pii-main-menu-button-a")).click();
		  }catch (UnhandledAlertException f){			  
			  driver.switchTo().alert().dismiss();
		  }
		  //Fills mandatory details
		  driver.findElement(By.id("pii-a-menu-hirca")).click();
		  driver.findElement(By.id("pii-irca-event-title")).sendKeys(EventTitleChrome);
		  driver.findElement(By.id("pii-irca-event-location")).sendKeys("San Diego");
		  driver.findElement(By.id("pii-irca-event-pbstatement")).sendKeys("Sanity Test");
		  driver.findElement(By.id("pii-irca-event-events")).sendKeys("Sanity Test");
		  driver.findElement(By.id("pii-irca-event-bginfos")).sendKeys("Sanity Test");
		  driver.findElement(By.id("pii-irca-event-investigators")).sendKeys("Sanity Test");
		  String ev1 = driver.findElement(By.id("pii-irca-event-title")).getAttribute("value");
		  String ev2 = driver.findElement(By.id("pii-irca-event-location")).getAttribute("value");
		  String ev3 = driver.findElement(By.id("pii-irca-event-pbstatement")).getAttribute("value");
		  String ev4 = driver.findElement(By.id("pii-irca-event-events")).getAttribute("value");
		  String ev5 = driver.findElement(By.id("pii-irca-event-bginfos")).getAttribute("value");
		  String ev6= driver.findElement(By.id("pii-irca-event-investigators")).getAttribute("value");
		  if ((ev1.equals(EventTitleChrome)==false))
		  {
			  driver.findElement(By.id("pii-irca-event-title")).clear();
			  driver.findElement(By.id("pii-irca-event-title")).sendKeys(EventTitleChrome);
		  }
		  if((ev2.equals("San Diego"))==false)
		  {
			  driver.findElement(By.id("pii-irca-event-location")).clear();
			  driver.findElement(By.id("pii-irca-event-location")).sendKeys("San Diego");
		  }
		  if((ev3.equals("Sanity Test"))==false)
		  {
			  driver.findElement(By.id("pii-irca-event-pbstatement")).clear();
			  driver.findElement(By.id("pii-irca-event-pbstatement")).sendKeys("Sanity Test");
		  }
		  if((ev4.equals("Sanity Test"))==false)
		  {
			  driver.findElement(By.id("pii-irca-event-events")).clear();
			  driver.findElement(By.id("pii-irca-event-events")).sendKeys("Sanity Test");
		  }
		  if((ev5.equals("Sanity Test"))==false)
		  {
			  driver.findElement(By.id("pii-irca-event-bginfos")).clear();
			  driver.findElement(By.id("pii-irca-event-bginfos")).sendKeys("Sanity Test");
		  }
		  if((ev6.equals("Sanity Test"))==false)
		  {
			  driver.findElement(By.id("pii-irca-event-investigators")).clear();
			  driver.findElement(By.id("pii-irca-event-investigators")).sendKeys("Sanity Test");
		  }
		  //Clicks on save button
		  driver.findElement(By.id("efi-irca-button-save")).click();
		  WebDriverWait wait1 = new WebDriverWait(driver,10);
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).click();
		  //Clicks on save confirmed
		  driver.findElement(By.id("pii-irca-dialog-confirmed")).click();
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-success")));
		  String creationDate = driver.findElement(By.id("pii-irca-event-repdatetime")).getAttribute("value");
		  String name = creationDate + "_" +username +"_" + EventTitleChrome;
		  System.out.println(name);
		  driver.findElement(By.id("efi-irca-btn-savedactivities")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.id("pii-user-home-panel-btn-irca")).click();
		  Thread.sleep(2000);
		  WebElement record = driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"));
		  String recordName = record.getText();
		  if (record.isDisplayed())
		  {
			  System.out.println("Record found: "+ recordName);
		  }
		  else
			  System.out.println ("Record not found.");
		  assertEquals(name, recordName);
		  //Deletes the newly created record
			  deleteNewRecord(recordName);
		  //Logs out
		  driver.findElement(By.id("pii-user-loginname")).click();
		  driver.findElement(By.id("pii-signout-button")).click();	
		  afterTest();
	  }
	  
	  		  
	 
	  public void afterTest() {
		  WebDriverWait wait = new WebDriverWait(driver,20);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-login-button")));
		  driver.quit();
	  }


}
