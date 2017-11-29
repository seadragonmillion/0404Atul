import static org.junit.Assert.*;

import java.awt.Robot;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Rule;
import org.junit.rules.Timeout;

import java.util.concurrent.TimeoutException;

public class IETest {

	private InternetExplorerDriver driver;
	private String username ="qaacfi";
	 private String password = "Kale94935830@";
	private String ie_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\IEDriverServer.exe";
	private String url = "https://kaledev.error-free.com/";
	private int login =0;
	private String keyword = "test data";
	private String keyspcl = "test.1/1";
	
	@SuppressWarnings("deprecation")
	@Rule
	  public Timeout globalTimeout= new Timeout(600000);
	
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Performing sanity test on Human Performance Search in Internet Explorer");
		  System.setProperty("webdriver.ie.driver",ie_path);
		  DesiredCapabilities cap = new DesiredCapabilities(); 
		  cap.setCapability("ignoreZoomSettings", true);
		  cap.setCapability("requireWindowFocus", true);
		  cap.setCapability("enablePersistentHover",false);
		  driver = new InternetExplorerDriver(cap);
		  //Browser is maximized
		  driver.manage().window().maximize();
		  //Browser navigates to the KALE url
		  driver.navigate().to(url);
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
	  }
	
	public void Login() throws Exception{
		  
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  System.out.println("Title before login: "+driver.getTitle());
		  //Login button is located and clicked
		  jse.executeScript("return document.getElementById('pii-login-button').click();");
		  //Login pop up is located and clicked
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("popupLogin"))).click();
		  Thread.sleep(2000);
		  //Username text field is located and the username is entered
		  driver.findElement(By.id("pii-un")).sendKeys(username);
		  //Password field is located and the password is entered
		  driver.findElement(By.id("pii-pw")).sendKeys(password);
		  Thread.sleep(2000);
		  //Sign in button is located and clicked
		  String user = driver.findElement(By.id("pii-un")).getAttribute("value");
		  String pw = driver.findElement(By.id("pii-pw")).getAttribute("value");
		  int c=1;
		  if (user.equals(username)==true)
		  {
			  if(pw.equals(password)==true)
			  {
				  //Sign in button is located and clicked
				  jse.executeScript("return document.getElementById('pii-signin-button').click();");  
				  while(c>0)
				  {
				  Thread.sleep(2000);
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
						  jse.executeScript("return document.getElementById('pii-signin-button').click();");
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
							  jse.executeScript("return document.getElementById('pii-signin-button').click();");
							  break;
						  }
						
					  }
				  }
			  
			  
		  }
	  }
	
	@Test
	  public void SanityTest() throws Exception{
		  try{
		Login();
		  System.out.println("Title after login: "+driver.getTitle());
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  WebDriverWait wait = new WebDriverWait(driver,60);
		  try{
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
		  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
		  }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		  Thread.sleep(5000);
		  //Switches to the iframe
		  WebDriverWait wait1 = new WebDriverWait(driver,10);
		  wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
		  try{
            if (login==1)
            {
                  WebDriverWait wait2 = new WebDriverWait(driver,20);
                  wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();
            }
            }catch (NoSuchElementException e){
            throw e;
            }
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 
		  //Clicks on Error free bank
		  try
		  {
			  jse.executeScript("return document.getElementById('pii-main-menu-button-e').click();");
		  }catch (UnhandledAlertException f){			  
			  driver.switchTo().alert().dismiss();
		  }
		  //Checks for equipment search pii
		  if(driver.findElement(By.id("pii-e-menu-equipPII")).isDisplayed()==false)
		  {
			  System.out.println("Non admin user cannot see Equipment Search PII");
		  }
		  else fail();
		  //Clicks on Human Performance Search
		  driver.findElement(By.linkText("Human Performance Search")).click();
		  //Checks if clear feature works on term field
		  driver.findElement(By.id("pii-efsh-searchbykw-input")).sendKeys(keyword);
		  Thread.sleep(1000);
		  Actions act1 = new Actions(driver);
		  WebElement act= driver.findElement(By.xpath(".//*[@id='pii-keyword-block']/div[4]/div/div/a"));
		  act1.click(act).build().perform();
		  //Checks with new keyword with . and /
		  driver.findElement(By.id("pii-efsh-searchbykw-input")).sendKeys(keyspcl);
		  driver.findElement(By.id("pii-efsh-searchbykw-btn")).click();
		  try{
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
		  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
		  }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		  //Clicks on Q1459
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q1459"))).click();
		  Thread.sleep(2000);
		  driver.findElement(By.id("pii-efsh-clear")).click();
		  //Checks for search method with magnifying glass
		  driver.findElement(By.id("pii-efsh-searchbykw-input")).sendKeys(keyword);
		  driver.findElement(By.id("pii-efsh-searchbykw-btn")).click();
		  try{
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
		  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
		  }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
			  Thread.sleep(2000);
		  driver.findElement(By.id("pii-efsh-clear")).click();
		  Thread.sleep(2000);
		  //Checks for search method with dropdown
		  driver.findElement(By.id("pii-efsh-searchbykw-input")).clear();
		  driver.findElement(By.id("pii-efsh-searchbykw-input")).sendKeys(keyword);
		  Thread.sleep(2000);
		  WebElement match=driver.findElement(By.xpath(".//*[@id='pii-efsh-keyword-list']/li"));
		  String text = match.getText();
		  System.out.println(text);
		  if(text.equals("Exact Match Keywords"))
		  {
			  driver.findElement(By.xpath(".//*[@id='pii-efsh-keyword-list']/li[2]")).click();				  
		  }
		  else if(text.equals("Similar Match Keywords"))
		  {
			  driver.findElement(By.xpath(".//*[@id='pii-efsh-keyword-list']/li[2]")).click();
		  }
		  else if(text.equals("Other Match Keywords"))
		  {
			  driver.findElement(By.xpath(".//*[@id='pii-efsh-keyword-list']/li[2]")).click();
		  }
		  try{
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
		  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
		  }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		  //Enters the term and check the search by enter
			  Thread.sleep(2000);
		  driver.findElement(By.id("pii-efsh-clear")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.id("pii-efsh-searchbykw-input")).sendKeys(keyword);
		  driver.findElement(By.id("pii-efsh-searchbykw-input")).sendKeys(Keys.ENTER);
		  try{
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
		  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
		  }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		  //Clicks on Q1459
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q1459"))).click();
		  //Clicks on Show Slides
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-button-Q1459")));
		  Thread.sleep(4000);
		  WebElement element =  driver.findElement(By.id("pii-slideshow-button-Q1459"));
		  String slide = element.getText();
		  element.sendKeys(Keys.TAB);
		  element.sendKeys(Keys.ENTER);
		  driver.findElement(By.id("pii-slideshow-Q1459-popup"));
		  System.out.println(slide);
		  char c = slide.charAt(12);
		  int n = Character.getNumericValue(c);
		  Thread.sleep(1000);
		  System.out.println("Found Slide 1");
		  Thread.sleep(500);
		  //Checking if title is correct
		  String actual_title = driver.findElement(By.xpath(".//*[@id='pii-slideshow-Q1459']/ul/li/div")).getText();
		  String expected_title = "Q1459: Sanity Test: DO NOT DELETE: QAA";
		  assertEquals (actual_title, expected_title);
		  //Checking if footer image appears
		  if(driver.findElement(By.xpath(".//*[@id='pii-slideshow-Q1459']/ul/li/span/img")).isDisplayed())
			  System.out.println("Logo is displayed");
		  //Checking if copyright is correct
		  String actual_copyright = driver.findElement(By.xpath(".//*[@id='pii-slideshow-Q1459']/ul/li/span/span")).getText();
		  String expected_copyright = "Copyright and Proprietary, Error-Free Inc. and Performance Improvement International LLC, 2017. Derivative Product Strictly Prohibited.";
		  assertEquals (actual_copyright, expected_copyright);
		  //Checking if slide number appears and is correct
		  String actual_slide = driver.findElement(By.xpath(".//*[@id='pii-slideshow-Q1459']/ul/li/span/span[2]")).getText();
		  String expected_slide = "1/"+n;
		  assertEquals (actual_slide, expected_slide);
		  //Moves out of the slideshow and checks for security
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-Q1459']/ul/li/div"))).click();
		  Thread.sleep(3000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-show-Q1459"))).click();
		  //Click on next
		  driver.findElement(By.linkText("Next")).click();
		  //Checks if there are slides present
		  for (int i=2;i<=n;i++)
		  {
			  String id = "pii-slideimg-Q1459-"+(i-1);
			  Thread.sleep(1000);
			  if (driver.findElement(By.id(id)).isDisplayed())
				  System.out.println("Found Slide "+i);
			  Thread.sleep(500);
			  //Checking if title is correct
			  //String title_id= "centered-btns1_s"+(i-1);
			  String title_xpath = ".//*[@id='pii-slideshow-Q1459']/ul/li["+i+"]/div";
			  actual_title = driver.findElement(By.xpath(title_xpath)).getText();
			  assertEquals (actual_title, expected_title);
			  //Checking if copyright is correct
			  String copyright_xpath = ".//*[@id='pii-slideshow-Q1459']/ul/li["+i+"]/span/span";
			  actual_copyright = driver.findElement(By.xpath(copyright_xpath)).getText();
			  assertEquals (actual_copyright, expected_copyright);
			  //Checking if footer image appears
			  String image_xpath = ".//*[@id='pii-slideshow-Q1459']/ul/li["+i+"]/span/img";
			  if(driver.findElement(By.xpath(image_xpath)).isDisplayed())
				  System.out.println("Logo is displayed");
			  //Checking if slide number appears and is correct
			  String slide_xpath = ".//*[@id='pii-slideshow-Q1459']/ul/li["+i+"]/span/span[2]";
			  actual_slide = driver.findElement(By.xpath(slide_xpath)).getText();
			  expected_slide = i+"/"+n;
			  assertEquals (actual_slide, expected_slide);
			  //Moves out of the slideshow and checks for security
			  Thread.sleep(1000);
			  //Clicks on copyright
			  if(i==2)
				  driver.findElement(By.xpath(copyright_xpath)).click();
			  //Clicks on logo
			  if(i==3)
				  driver.findElement(By.xpath(image_xpath)).click();
			  //Clicks outside
			  if(i==4)
			  {
				  Actions act2 = new Actions(driver);
				  Point coordinates = driver.findElement(By.linkText("Next")).getLocation();
				  Robot robot = new Robot();
				  robot.mouseMove(coordinates.getX()+100,coordinates.getY());
				  act2.click().build().perform();
			  }
			  //Clicks on title
			  else 
				  driver.findElement(By.xpath(title_xpath)).click();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(title_xpath))).click();
			  Thread.sleep(3000);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-show-Q1459"))).click();
			  //Click on next
			  driver.findElement(By.linkText("Next")).click();
		  }
		  //Clicks on previous button
		  driver.findElement(By.linkText("Previous")).click();
		  //Checks the previous button
		  for (int i=n;i>=2;i--)
		  {
			  String id = "pii-slideimg-Q1459-"+(i-1);
			  Thread.sleep(1000);
			  if (driver.findElement(By.id(id)).isDisplayed())
				  System.out.println("Found Slide "+(i));
			  Thread.sleep(500);
			   //Checking if title is correct
			 // String title_id= "centered-btns1_s"+(i-1);
			  String title_xpath = ".//*[@id='pii-slideshow-Q1459']/ul/li["+i+"]/div";
			  actual_title = driver.findElement(By.xpath(title_xpath)).getText();
			  assertEquals (actual_title, expected_title);
			  //Checking if copyright is correct
			  String copyright_xpath = ".//*[@id='pii-slideshow-Q1459']/ul/li["+i+"]/span/span";
			  actual_copyright = driver.findElement(By.xpath(copyright_xpath)).getText();
			  assertEquals (actual_copyright, expected_copyright);
			  //Checking if footer image appears
			  String image_xpath = ".//*[@id='pii-slideshow-Q1459']/ul/li["+i+"]/span/img";
			  if(driver.findElement(By.xpath(image_xpath)).isDisplayed())
				  System.out.println("Logo is displayed");
			  //Checking if slide number appears and is correct
			  String slide_xpath = ".//*[@id='pii-slideshow-Q1459']/ul/li["+i+"]/span/span[2]";
			  actual_slide = driver.findElement(By.xpath(slide_xpath)).getText();
			  expected_slide = i+"/"+n;
			  assertEquals (actual_slide, expected_slide);
			  //Click on Previous
			  driver.findElement(By.linkText("Previous")).click();
		  }
		  //Clicks on close button
		  driver.findElement(By.xpath(".//*[@id='pii-slideshow-Q1459']/a")).click();
		  //Clicks on clear
		  driver.findElement(By.id("pii-efsh-clear")).click();
		  //Searches for case id box
		  try{
		  	WebElement caseSearch= driver.findElement(By.id("pii-efsh-searchbyid-input"));
		  	if (caseSearch.isDisplayed()==true)
		  		Assert.fail("Case id search displayed");
		  	if(caseSearch.isDisplayed()==false)
		  		System.out.println("Case id search box not displayed");

		  }catch(NoSuchElementException e)
		  {
			  System.out.println("Case id search box not present.");

		  }
		  //Logs out
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-signout-button"))).click();
		  Thread.sleep(2000);
		  afterTest();
		  }catch (TimeoutException e)
			  {
				/*  driver.findElement(By.id("pii-home")).sendKeys(Keys.CONTROL);
		  driver.findElement(By.id("pii-home")).sendKeys(Keys.F11);*/
				  driver.quit();
			  }
		  		  
	}
	
	public void afterTest(){
		
		//Browser closes
		driver.quit();
	}

}
