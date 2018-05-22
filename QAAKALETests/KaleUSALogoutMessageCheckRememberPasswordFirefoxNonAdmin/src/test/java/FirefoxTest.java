import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FirefoxTest {

	private FirefoxDriver driver;
	private String username ="virtualcfinonadmin";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String gecko_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\geckodriver.exe";
	private String url = "https://kale.error-free.com/";
	SoftAssertions softly = new SoftAssertions();
	
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		 System.out.println("Logout message check and remember password check in Firefox");
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
		 if(height<950)
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
		
		//Logs in without checking Remember Me
		WebDriverWait wait = new WebDriverWait(driver,40);
		Login obj = new Login();
		int login = obj.LoginUser(driver, username, password);
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
		obj.logout(driver);
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
		driver.findElement(By.id("pii-pw")).sendKeys(obj.decodePassword(password));
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
		obj.logout(driver);
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
		driver.findElement(By.id("pii-pw")).sendKeys(obj.decodePassword(password));
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-header-message-passwd"))).sendKeys(obj.decodePassword(password));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-header-message-passwd"))).sendKeys(Keys.ENTER);
		System.out.println("Logged in");
		Thread.sleep(5000);
		//Logs out
		obj.logout(driver);
		Thread.sleep(2000);
		afterTest();
		/*xpath: id=pii-header-message-div/a
			id:pii-header-message-button //click here
			
			//enter password and press ener
			id:pii-header-message-passwd*/
		
	}
	
	public void afterTest(){
		
		driver.manage().window().maximize();
		//Browser closes
		driver.quit();
		softly.assertAll();
	}

}


