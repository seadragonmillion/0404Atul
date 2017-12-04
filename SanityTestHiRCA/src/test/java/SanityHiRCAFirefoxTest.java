import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.NoSuchElementException;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Rule;
import org.junit.rules.Timeout;
import java.util.concurrent.TimeoutException;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.Dimension;

public class SanityHiRCAFirefoxTest {

	private FirefoxDriver driver;
	private int login =0;
	private String username = "jenkins";
	 private String password = "Kalejenkins@123";

	@SuppressWarnings("deprecation")
	@Rule
	  public Timeout globalTimeout= new Timeout(240000);
	  
		@Before
		  public void beforeTest() throws MalformedURLException{
			  System.out.println("Performing sanity test on HiRCA in Firefox");
			  System.setProperty("webdriver.gecko.driver","C:\\Users\\rramakrishnan\\DriversForSelenium\\geckodriver.exe");
			  driver = new FirefoxDriver();
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
			  driver.navigate().to("https://kaledev.error-free.com/");
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  }
		  
		
		  public void Login() throws Exception{
			  
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
				  while(c>0)
				  {
				  
				  WebElement element = driver.findElement(By.id("pii-signin-message"));
				  String text = element.getText();
				  if (element.isDisplayed())
				  {
					  if(text.isEmpty())
					  {
						  System.out.println("Logged in");
						  break;
						  }
					  else
					  {
						  driver.findElement(By.id("pii-pw")).sendKeys(password);
						  //Sign in button is located and clicked
						  driver.findElement(By.id("pii-signin-button")).click();
						  login =1;
						  break;
					  }
					  			  
				  }
				  else break;
			  }}
			
		  }
		  if ((user.equals(username)==false)||(pw.equals(password)==false))
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
					  user = driver.findElement(By.id("pii-un")).getAttribute("value");
					  pw = driver.findElement(By.id("pii-pw")).getAttribute("value");
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
		  try{
			  
			  Login();
			  System.out.println("Title after login: "+driver.getTitle());
			  Thread.sleep(5000);
			 
			 // assertEquals (driver.getTitle(), "KALE�");
			  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			  driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
			 // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			   
			  try{
			  if (login==1)
			  {
				  WebDriverWait wait2 = new WebDriverWait(driver,20);
				  wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();
			  }
		  }catch (NoSuchElementException e){
			  throw e;
		  }
			  //Thread.sleep(5000);
			  try
			  {
				  driver.findElement(By.id("pii-main-menu-button-a")).click();
			  }catch (UnhandledAlertException f){			  
				  driver.switchTo().alert().dismiss();
			  }
			  
			  driver.findElement(By.id("pii-a-menu-hirca")).click();
			   driver.findElement(By.id("pii-irca-event-title")).sendKeys("Sanity Test");
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
		  if ((ev1.equals("Sanity Test")==false))
		  {
			  driver.findElement(By.id("pii-irca-event-title")).clear();
			  driver.findElement(By.id("pii-irca-event-title")).sendKeys("Sanity Test");
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

		  WebElement dropdown = driver.findElement(By.id("pii-irca-event-department"));
			  Select s = new Select (dropdown);
			  s.selectByVisibleText("Construction");
			  driver.findElement(By.id("efi-irca-button-save")).click();
			  WebDriverWait wait1 = new WebDriverWait(driver,10);
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).click();
			  driver.findElement(By.id("pii-irca-dialog-confirmed")).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-success")));
			  String creationDate = driver.findElement(By.id("pii-irca-event-repdatetime")).getAttribute("value");
			  String name = creationDate + "_jenkins_Sanity Test" ;
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
			  while(true)
			  {
				  Thread.sleep(1000);
				  try{
				  if (driver.findElement(By.className("sticky-note")).isDisplayed())
				  {
					  WebDriverWait wait = new WebDriverWait(driver,10);
					  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();
					  
				  }}catch (NoSuchElementException e)
				  {
					  break;
				  }
				  catch( StaleElementReferenceException f)
				  {
					  
					 break;
				  }
				  catch (org.openqa.selenium.TimeoutException u)
				  {
					  break;
				  }
				 
			  }
			  driver.findElement(By.id("pii-user-loginname")).click();
			  driver.findElement(By.id("pii-signout-button")).click();
			  afterTest();
			  }catch (TimeoutException e)
			  {
				  driver.quit();
			  }
		  }
		  
		  		  
		 
		  public void afterTest() throws Exception{
			  driver.switchTo().defaultContent();
			  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			  WebDriverWait wait = new WebDriverWait(driver,20);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-login-button")));
			  driver.quit();
		  }

}
