import java.net.MalformedURLException;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ChromeTest {

	private WebDriver driver;
	private String username ="virtualcfi";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String chrome_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\chromedriver.exe";
	private String url = "https://kaledev.error-free.com/";
	private int login =0;
    SoftAssertions softly = new SoftAssertions();
	
	@SuppressWarnings("deprecation")
	@Rule
	  public Timeout globalTimeout= new Timeout(3500000);
		  
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Logout message check and remember password check in Chrome");
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
	public void test() throws Exception {
		
		//Logs in without checking Remember Me
		WebDriverWait wait = new WebDriverWait(driver,40);
		Login();
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
		//Logs out
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-signout-button"))).click();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Switches to main content
		driver.switchTo().defaultContent();
		//Login button is located and clicked
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-login-button"))).click();
		//Get username data to check if empty
		String user = driver.findElement(By.id("pii-un")).getAttribute("value");
		if (user==""||user==null||user.equals(""))
			System.out.println("Username not remembered");
		else softly.fail("Username remembered even with Remember Me unchecked");
		//Enter Username
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-un"))).sendKeys(username);
		//Enter password
		driver.findElement(By.id("pii-pw")).sendKeys(decode(password));
		//Click on Remember Me
		driver.findElement(By.xpath(".//*[@class='ui-checkbox ui-mini']/label")).click();
		//Sign in button is located and clicked
		driver.findElement(By.id("pii-signin-button")).click();
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Switches to the iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		Thread.sleep(5000);
		//Logs out
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-signout-button"))).click();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Switches to main content
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		//Login button is located and clicked
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-login-button"))).click();
		Thread.sleep(2000);
		//Get username data to check if empty
		user = driver.findElement(By.id("pii-un")).getAttribute("value");
		softly.assertThat(user).as("test data").isEqualTo(username);
		//Un-check Remember Me
		driver.findElement(By.xpath(".//*[@class='ui-checkbox ui-mini']/label")).click();
		//Enter password
		driver.findElement(By.id("pii-pw")).sendKeys(decode(password));
		//Sign in button is located and clicked
		driver.findElement(By.id("pii-signin-button")).click();
		//Waits for the page to load
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Switches to the iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		//Comes exactly at the 55th minute
		System.out.println("Wait for 55 minutes for re-login message");
		Thread.sleep(3300000);
		//Check for re login message 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-header-message-div")));
		//Click on re-login button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-header-message-button"))).click();
		//Enter password and press enter
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-header-message-passwd"))).sendKeys(decode(password));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-header-message-passwd"))).sendKeys(Keys.ENTER);
		System.out.println("Logged in");
		//Logs out
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-signout-button"))).click();
		Thread.sleep(2000);
		afterTest();
		/*xpath: id=pii-header-message-div/a
			id:pii-header-message-button //click here
			
			//enter password and press ener
			id:pii-header-message-passwd*/
		
	}
	
	public void afterTest(){
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-login-button")));
		//Browser closes
		driver.quit();
		softly.assertAll();
	}

}
