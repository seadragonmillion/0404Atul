import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.*;
import org.openqa.selenium.interactions.Actions;
import org.junit.Rule;
import org.junit.rules.Timeout;
import java.util.concurrent.TimeoutException;
import org.junit.Assert;
import java.util.Base64;

public class ChromeTest {

	private WebDriver driver;
	private String username ="jenkinsvmnonadmin";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String chrome_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\chromedriver.exe";
	private String url = "https://kale.error-free.com/";
	private int login =0;
	private String keyword = "failure";
		  
	@SuppressWarnings("deprecation")
	@Rule
	  public Timeout globalTimeout= new Timeout(240000);
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Performing sanity test on Electrical Failure in Chrome");
		  System.setProperty("webdriver.chrome.driver",chrome_path);
		  driver = new ChromeDriver();
		  //Browser is maximized
		  driver.manage().window().maximize();
		  //Browser navigates to the KALE url
		  driver.navigate().to(url);
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }
	  

	public String decode(String pw){
		
		byte[] decryptedPasswordBytes = Base64.getDecoder().decode(pw);
		String decryptedPassword = new String(decryptedPasswordBytes);
		return (decryptedPassword);
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
		  driver.findElement(By.id("pii-pw")).sendKeys(decode(password));
		  //Sign in button is located and clicked
		  String user = driver.findElement(By.id("pii-un")).getAttribute("value");
		  String pw = driver.findElement(By.id("pii-pw")).getAttribute("value");
		  int c=1;
		  if (user.equals(username)==true)
		  {
			  if(pw.equals(decode(password))==true)
			  {
				  //Sign in button is located and clicked
				  driver.findElement(By.id("pii-signin-button")).click();  
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
						  driver.findElement(By.id("pii-pw")).sendKeys(decode(password));
						  //Sign in button is located and clicked
						  driver.findElement(By.id("pii-signin-button")).click();
						  login =1;
						  break;
					  }
					  			  
				  }
				  else break;
			  }}
			
		  }
		  if ((user.equals(username)==false)||(pw.equals(decode(password))==false))
		    {
				  while(c>0)
				  {
					  Thread.sleep(1000);
					  driver.findElement(By.id("pii-un")).clear();
					  driver.findElement(By.id("pii-pw")).clear();
					  //Username text field is located and the username is entered
					  driver.findElement(By.id("pii-un")).sendKeys(username);
					  //Password field is located and the password is entered
					  driver.findElement(By.id("pii-pw")).sendKeys(decode(password));
					  user = driver.findElement(By.id("pii-un")).getAttribute("value");
					  pw = driver.findElement(By.id("pii-pw")).getAttribute("value");
					  if (user.equals(username)==true)
					  {
						  if(pw.equals(decode(password))==true)
						  {
							  //Sign in button is located and clicked
							  driver.findElement(By.id("pii-signin-button")).click();
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
		  Thread.sleep(8000);
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
		  Thread.sleep(4000);
		  WebDriverWait wait = new WebDriverWait(driver,20);
		  //Clicks on Error free bank
		  try
		  {
			  driver.findElement(By.id("pii-main-menu-button-e")).click();
		  }catch (UnhandledAlertException f){			  
			  driver.switchTo().alert().dismiss();
		  }
		  Thread.sleep(2000);
		  //Checks for equipment search pii
		  if(driver.findElement(By.id("pii-e-menu-equipPII")).isDisplayed()==false)
		  {
			  System.out.println("Non admin user cannot see Equipment Search PII");
		  }
		  else fail();
		  //Clicks on Electrical failure mode search
		  driver.findElement(By.linkText("Electrical Failure Modes")).click();
		  //Checks if clear feature works on term field
		  driver.findElement(By.id("pii-efse-searchbykw-input")).sendKeys(keyword);
		  Thread.sleep(1000);
		  Actions act1 = new Actions(driver);
		  WebElement act= driver.findElement(By.xpath(".//*[@id='pii-keyword-block-equip']/div[4]/div/div/a"));
		  act1.click(act).build().perform();
		  //Checks for search method with magnifying glass
		  driver.findElement(By.id("pii-efse-searchbykw-input")).sendKeys(keyword);
		  driver.findElement(By.id("pii-efse-searchbykw-btn")).click();
		  driver.findElement(By.id("pii-efse-clear")).click();
		  Thread.sleep(2000);
		  //Checks for search method with dropdown
		  driver.findElement(By.id("pii-efse-searchbykw-input")).clear();
		  driver.findElement(By.id("pii-efse-searchbykw-input")).sendKeys(keyword);
		  Thread.sleep(2000);
		  WebElement match=driver.findElement(By.xpath(".//*[@id='pii-efse-keyword-list']/li"));
		  String text = match.getText();
		  System.out.println(text);
		  if(text.equals("Exact Match Keywords"))
		  {
			  driver.findElement(By.xpath(".//*[@id='pii-efse-keyword-list']/li[2]")).click();				  
		  }
		  else if(text.equals("Similar Match Keywords"))
		  {
			  driver.findElement(By.xpath(".//*[@id='pii-efse-keyword-list']/li[2]")).click();
		  }
		  else if(text.equals("Other Match Keywords"))
		  {
			  driver.findElement(By.xpath(".//*[@id='pii-efse-keyword-list']/li[2]")).click();
		  }
		  //Enters the term and check the search by enter
		  driver.findElement(By.id("pii-efse-clear")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.id("pii-efse-searchbykw-input")).sendKeys(keyword);
		  driver.findElement(By.id("pii-efse-searchbykw-input")).sendKeys(Keys.ENTER);
		  //Clicks on F1260
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F1260"))).click();
		  Thread.sleep(2000);
		  //Clicks on Show Slides
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-button-equip-F1260")));
		  Thread.sleep(2000);
		  WebElement element =  driver.findElement(By.id("pii-slideshow-button-equip-F1260"));
		  String slide = element.getText();
		  element.sendKeys(Keys.TAB);
		  element.sendKeys(Keys.ENTER);
		  driver.findElement(By.id("pii-slideshow-equip-F1260-popup"));
		  System.out.println(slide);
		  char c = slide.charAt(12);
		  int n = Character.getNumericValue(c);
		  Thread.sleep(2000);
		  System.out.println("Found Slide 1");
		  Thread.sleep(1000);
		  
		  
		   //Checking if title is correct
		  String actual_title = driver.findElement(By.xpath(".//*[@id='pii-slideshow-equip-F1260']/ul/li/div")).getText();
		  String expected_title = "F1260: What are the operating principles and failure modes of a pneumatic controller?";
		  assertEquals (actual_title, expected_title);
		  //Checking if footer image appears
		  if(driver.findElement(By.xpath(".//*[@id='pii-slideshow-equip-F1260']/ul/li/span/img")).isDisplayed())
			  System.out.println("Logo is displayed");
		  //Checking if copyright is correct
		  String actual_copyright = driver.findElement(By.xpath(".//*[@id='pii-slideshow-equip-F1260']/ul/li/span/span")).getText();
		  String expected_copyright = "Copyright and Proprietary, Error-Free Inc. and Performance Improvement International LLC, 2017. Derivative Product Strictly Prohibited.";
		  assertEquals (actual_copyright, expected_copyright);
		  //Checking if slide number appears and is correct
		  String actual_slide = driver.findElement(By.xpath(".//*[@id='pii-slideshow-equip-F1260']/ul/li/span/span[2]")).getText();
		  String expected_slide = "1/"+n;
		  assertEquals (actual_slide, expected_slide);
		  //Moves out of the slideshow and checks for security
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F1260']/ul/li/div"))).click();
		  Thread.sleep(3000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-equip-show-F1260"))).click();

		  //Click on next
		  driver.findElement(By.linkText("Next")).click();
		  //Checks if there are slides present
		  for (int i=2;i<=n;i++)
		  {
			  String id = "pii-slideimg-F1260-"+(i-1);
			  Thread.sleep(2000);
			  if (driver.findElement(By.id(id)).isDisplayed())
				  System.out.println("Found Slide "+(i));
			  else System.out.println("Didn't find slide "+i);
			  Thread.sleep(1000);
			  //String title_id= "centered-btns1_s"+(i-1);
			  String title_xpath = ".//*[@id='pii-slideshow-equip-F1260']/ul/li["+i+"]/div";
			  actual_title = driver.findElement(By.xpath(title_xpath)).getText();
			  assertEquals (actual_title, expected_title);
			  //Checking if copyright is correct
			  String copyright_xpath = ".//*[@id='pii-slideshow-equip-F1260']/ul/li["+i+"]/span/span";
			  actual_copyright = driver.findElement(By.xpath(copyright_xpath)).getText();
			  assertEquals (actual_copyright, expected_copyright);
			  //Checking if footer image appears
			  String image_xpath = ".//*[@id='pii-slideshow-equip-F1260']/ul/li["+i+"]/span/img";
			  if(driver.findElement(By.xpath(image_xpath)).isDisplayed())
				  System.out.println("Logo is displayed");
			  //Checking if slide number appears and is correct
			  String slide_xpath = ".//*[@id='pii-slideshow-equip-F1260']/ul/li["+i+"]/span/span[2]";
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
				  act2.moveByOffset(1600, 0).click().build().perform();
			  }
			  //Clicks on title
			  else 
				  driver.findElement(By.xpath(title_xpath)).click();
			  Thread.sleep(3000);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-equip-show-F1260"))).click();
			  //Click on next
			  driver.findElement(By.linkText("Next")).click();
		  }
		  //Click on previous
		  driver.findElement(By.linkText("Previous")).click();
		  //Checks if there are slides present
		  for (int i=n;i>=2;i--)
		  {
			  String id = "pii-slideimg-F1260-"+(i-1);
			  Thread.sleep(2000);
			  if (driver.findElement(By.id(id)).isDisplayed())
				  System.out.println("Found Slide "+(i));
			  else System.out.println("Didn't find slide "+i);
			  Thread.sleep(1000);
			  //String title_id= "centered-btns1_s"+(i-1);
			  String title_xpath = ".//*[@id='pii-slideshow-equip-F1260']/ul/li["+i+"]/div";
			  actual_title = driver.findElement(By.xpath(title_xpath)).getText();
			  assertEquals (actual_title, expected_title);
			  //Checking if copyright is correct
			  String copyright_xpath = ".//*[@id='pii-slideshow-equip-F1260']/ul/li["+i+"]/span/span";
			  actual_copyright = driver.findElement(By.xpath(copyright_xpath)).getText();
			  assertEquals (actual_copyright, expected_copyright);
			  //Checking if footer image appears
			  String image_xpath = ".//*[@id='pii-slideshow-equip-F1260']/ul/li["+i+"]/span/img";
			  if(driver.findElement(By.xpath(image_xpath)).isDisplayed())
				  System.out.println("Logo is displayed");
			  //Checking if slide number appears and is correct
			  String slide_xpath = ".//*[@id='pii-slideshow-equip-F1260']/ul/li["+i+"]/span/span[2]";
			  actual_slide = driver.findElement(By.xpath(slide_xpath)).getText();
			  expected_slide = i+"/"+n;
			  assertEquals (actual_slide, expected_slide);
			  //Click on previous
			  driver.findElement(By.linkText("Previous")).click();
		  }
		  //Clicks on close button
		  driver.findElement(By.xpath(".//*[@id='pii-slideshow-equip-F1260']/a")).click();
		  //Clicks on clear
		  driver.findElement(By.id("pii-efse-clear")).click();
		  //Searches for case id box
		  try{
		  	WebElement caseSearch= driver.findElement(By.id("pii-efse-searchbyid-input"));
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
		  }catch(TimeoutException e)
		  {
			  System.out.println(e);
			  driver.quit();
		  }
		  
	}
	
	public void afterTest(){
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-login-button")));
		//Browser closes
		driver.quit();
	}


}
