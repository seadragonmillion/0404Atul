import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeleniumGridTest {
	
	WebDriver driver = null;
	
	
	@Parameters  ("browser")
  @Test
  public void f() {
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
  @BeforeTest
  public void beforeTest(String browser) throws MalformedURLException {
	  
	  if (browser.equalsIgnoreCase("firefox"))
	  {
		  DesiredCapabilities capability = DesiredCapabilities.firefox();
		  driver = new RemoteWebDriver(new URL("http://kaledev.error-free.com:4444/wd/hub"), capability);
	  }
	  if (browser.equalsIgnoreCase("chrome"))
	  {
		  DesiredCapabilities capability = DesiredCapabilities.chrome();
		  driver = new RemoteWebDriver(new URL("http://kaledev.error-free.com:4444/wd/hub"), capability);
	  }
	  if (browser.equalsIgnoreCase("ie"))
	  {
		  DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
		  driver = new RemoteWebDriver(new URL("http://kaledev.error-free.com:4444/wd/hub"), capability);
	  }
	  
	  
	  //Browser is maximized
	  driver.manage().window().maximize();
	  //Browser navigates to the KALE url
	  driver.navigate().to("https://kaledev.error-free.com/");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
