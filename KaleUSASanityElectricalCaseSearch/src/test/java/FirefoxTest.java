import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.interactions.Actions;

public class FirefoxTest {

	private FirefoxDriver driver;
	private String username ="ritica";
	private String password = "Kale46191802@";
	private String gecko_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\geckodriver.exe";
	private String url = "https://kale.error-free.com/";
	private int login =0;
	private String keyword = "failure";
	
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		 System.out.println("Performing sanity test on Electrical failure mode search in Firefox");
		 System.setProperty("webdriver.gecko.driver",gecko_path);
		 ProfilesIni ffProfiles = new ProfilesIni();
		 FirefoxProfile profile = ffProfiles.getProfile("customFirefox");
		 DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		 capabilities.setCapability(FirefoxDriver.PROFILE, profile);
		 driver = new FirefoxDriver(capabilities);
		  //Browser is maximized
		  driver.manage().window().maximize();
		  //Browser navigates to the KALE url
		  driver.navigate().to(url);
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
	
	@Test
	public void SanityTest() throws Exception{
		  try{
		Login();
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
		  Thread.sleep(4000);
		  WebDriverWait wait = new WebDriverWait(driver,20);
		  //Clicks on Error free bank
		  try
		  {
			  driver.findElement(By.id("pii-main-menu-button-e")).click();
		  }catch (UnhandledAlertException f){			  
			  driver.switchTo().alert().dismiss();
		  }
		  //Clicks on Electrical failure mode search
		  driver.findElement(By.linkText("Electrical Failure Mode Search")).click();
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
		  String actual_title = driver.findElement(By.xpath(".//*[@id='centered-btns1_s0']/div")).getText();
		  String expected_title = "F1260: What are the operating principles and failure modes of a pneumatic controller?";
		  assertEquals (expected_title,actual_title);
		  //Checking if footer image appears
		  if(driver.findElement(By.xpath(".//*[@id='centered-btns1_s0']/span/img")).isDisplayed())
			  System.out.println("Logo is displayed");
		  //Checking if slide number appears and is correct
		  Thread.sleep(2000);
		  String actual_slide = driver.findElement(By.xpath(".//*[@id='centered-btns1_s0']/span/span[2]")).getAttribute("textContent");
		  String expected_slide = "1/"+n;
		  assertEquals (expected_slide,actual_slide);
		  //Checking if copyright is correct
		  Thread.sleep(2000);
		  String actual_copyright = driver.findElement(By.xpath(".//*[@id='centered-btns1_s0']/span/span")).getAttribute("textContent");
		  String expected_copyright = "Copyright and Proprietary, Error-Free Inc. and Performance Improvement International LLC, 2017. Derivative Product Strictly Prohibited.";
		  assertEquals (expected_copyright,actual_copyright);
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
			  //Checking if title is correct
			  String title_id= "centered-btns1_s"+(i-1);
			  String title_xpath = ".//*[@id='"+title_id+"']/div";
			  actual_title = driver.findElement(By.xpath(title_xpath)).getText();
			  assertEquals (actual_title, expected_title);
			  //Checking if copyright is correct
			  String copyright_xpath = ".//*[@id='"+title_id+"']/span/span";
			  actual_copyright = driver.findElement(By.xpath(copyright_xpath)).getAttribute("textContent");
			  assertEquals (actual_copyright, expected_copyright);
			  //Checking if footer image appears
			  String image_xpath = ".//*[@id='"+title_id+"']/span/img";
			  if(driver.findElement(By.xpath(image_xpath)).isDisplayed())
				  System.out.println("Logo is displayed");
			  //Checking if slide number appears and is correct
			  String slide_xpath = ".//*[@id='"+title_id+"']/span/span[2]";
			  actual_slide = driver.findElement(By.xpath(slide_xpath)).getAttribute("textContent");
			  expected_slide = i+"/"+n;
			  assertEquals (actual_slide, expected_slide);
			  //Click on next
			  driver.findElement(By.linkText("Next")).click();
		  }
		  //Clicks on close button
		  driver.findElement(By.xpath(".//*[@id='pii-slideshow-equip-F1260']/a")).click();
		  //Clicks on clear
		  driver.findElement(By.id("pii-efse-clear")).click();
		  //Checks if clear feature works on case id field
		  driver.findElement(By.id("pii-efse-searchbyid-input")).sendKeys("207");
		  Thread.sleep(1000);
		  act= driver.findElement(By.xpath(".//*[@id='pii-keyword-block-equip']/div[3]/div/div/a"));
		  act1.click(act).build().perform();
		  //Checks for search method with magnifying glass
		  driver.findElement(By.id("pii-efse-searchbyid-input")).sendKeys("207");
		  driver.findElement(By.id("pii-efse-searchbyid-btn")).click();
		  driver.findElement(By.id("pii-efse-clear")).click();
		  Thread.sleep(2000);
		  //Enters case id
		  driver.findElement(By.id("pii-efse-searchbyid-input")).sendKeys("207");
		  driver.findElement(By.id("pii-efse-searchbyid-input")).sendKeys(Keys.ENTER);
		  //Clicks on F207
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F207"))).click();
		  Thread.sleep(2000);
		  //Clicks on Show Slides
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-button-equip-F207")));
		  Thread.sleep(2000);
		  element =  driver.findElement(By.id("pii-slideshow-button-equip-F207"));
		  slide = element.getText();
		  element.sendKeys(Keys.TAB);
		  element.sendKeys(Keys.ENTER);
		  driver.findElement(By.id("pii-slideshow-equip-F207-popup"));
		  System.out.println(slide);
		  c = slide.charAt(12);
		  n = Character.getNumericValue(c);
		  Thread.sleep(1000);
		  System.out.println("Found Slide 1");
		  Thread.sleep(500);
		  //Checking if slide number appears and is correct
		  String actual_slide1 = driver.findElement(By.xpath(".//*[@id='centered-btns2_s0']/span/span[2]")).getAttribute("textContent");
		  String expected_slide1 = "1/"+n;
		  assertEquals (actual_slide1, expected_slide1);
		  Thread.sleep(1000);
		  //Checking if title is correct
		  String actual_title1 = driver.findElement(By.xpath(".//*[@id='centered-btns2_s0']/div")).getText();
		  String expected_title1 = "F207: What are the failure modes related to DC motor starters?";
		  assertEquals (actual_title1, expected_title1);
		  //Checking if footer image appears
		  if(driver.findElement(By.xpath(".//*[@id='centered-btns2_s0']/span/img")).isDisplayed())
			  System.out.println("Logo is displayed");
		  //Checking if copyright is correct
		  String actual_copyright1 = driver.findElement(By.xpath(".//*[@id='centered-btns2_s0']/span/span")).getAttribute("textContent");
		  String expected_copyright1 = "Copyright and Proprietary, Error-Free Inc. and Performance Improvement International LLC, 2017. Derivative Product Strictly Prohibited.";
		  assertEquals (actual_copyright1, expected_copyright1);
		  //Click on next
		  driver.findElement(By.linkText("Next")).click();
		  //Checks if there are slides present
		  for (int j=2;j<=n;j++)
		  {
			  String id = "pii-slideimg-F207-"+(j-1);
			  Thread.sleep(1000);
			  if(driver.findElement(By.id(id)).isDisplayed())
				  System.out.println("Found Slide "+(j));
			  else System.out.println("Didn't find slide "+j);
			  Thread.sleep(500);
			  //Checking if title is correct
			  String title_id= "centered-btns2_s"+(j-1);
			  String title_xpath = ".//*[@id='"+title_id+"']/div";
			  actual_title1 = driver.findElement(By.xpath(title_xpath)).getText();
			  assertEquals (actual_title1, expected_title1);
			  //Checking if copyright is correct
			  String copyright_xpath = ".//*[@id='"+title_id+"']/span/span";
			  actual_copyright1 = driver.findElement(By.xpath(copyright_xpath)).getAttribute("textContent");
			  assertEquals (actual_copyright1, expected_copyright1);
			  //Checking if footer image appears
			  String image_xpath = ".//*[@id='"+title_id+"']/span/img";
			  if(driver.findElement(By.xpath(image_xpath)).isDisplayed())
				  System.out.println("Logo is displayed");
			  //Checking if slide number appears and is correct
			  String slide_xpath = ".//*[@id='"+title_id+"']/span/span[2]";
			  actual_slide1 = driver.findElement(By.xpath(slide_xpath)).getAttribute("textContent");
			  expected_slide1 = j+"/"+n;
			  assertEquals (actual_slide1, expected_slide1);
			  //Click on next
			  driver.findElement(By.linkText("Next")).click();
		  }
		  //Clicks on close button
		  driver.findElement(By.xpath(".//*[@id='pii-slideshow-equip-F207']/a")).click();
		  //Clicks on clear
		  driver.findElement(By.id("pii-efse-clear")).click();
		  //Logs out
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-signout-button"))).click();
		  Thread.sleep(2000);
		  afterTest();
		  }catch(Exception e)
		  {
			  System.out.println(e);
			  driver.manage().window().maximize();
			  driver.quit();
		  }
		  
	}
	
	public void afterTest(){
		driver.manage().window().maximize();
		//Browser closes
		driver.quit();
	}


}
