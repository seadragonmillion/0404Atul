import java.net.URL;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeLoginTest {

	 private WebDriver driver;
	
	  
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  /*DesiredCapabilities capability = DesiredCapabilities.chrome();
		  driver = new RemoteWebDriver(new URL("http://PII-HANY-PC.piionline.local:4445"), capability);
		  capability.setBrowserName("chrome");*/
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\rramakrishnan\\DriversForSelenium\\chromedriver.exe");
		  driver = new ChromeDriver();
		  //Browser is maximized
		  driver.manage().window().maximize();
		  //Browser navigates to the KALE url
		  driver.navigate().to("https://kaledev.error-free.com/");
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }
	  @Test 
	  public void f() {
		  
		  System.out.println("Title: "+driver.getTitle());
		  //Login button is located and clicked
		  driver.findElement(By.id("pii-login-button")).click();
		  //Login pop up is located and clicked
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("popupLogin"))).click();
		  //Username text field is located and the username is entered
		  driver.findElement(By.id("pii-un")).sendKeys("ritica");
		  //Password field is located and the password is entered
		  driver.findElement(By.id("pii-pw")).sendKeys("Kale24982417@");
		  //Sign in button is located and clicked
		  driver.findElement(By.id("pii-signin-button")).click();
	  }
	  @After
	  public void afterTest() {
		  driver.close();
	  }

}
