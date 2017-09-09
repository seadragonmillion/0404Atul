import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class FirefoxTest {
	String path_gecko_firefox ="C:\\Users\\rramakrishnan\\DriversForSelenium\\geckodriver.exe";
	WebDriver driver;
	
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
  public void beforeTest() throws Exception{
	  
	  //Firefox browser is launched
	  System.setProperty("webdriver.gecko.driver",path_gecko_firefox);
	  driver = new FirefoxDriver();
	  //Browser is maximized
	  driver.manage().window().maximize();
	  //Browser navigates to the KALE url
	  driver.navigate().to("https://kaledev.error-free.com/");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() {
	  //Browser is closed
	  driver.close();	
  }

}
