/*This test script tests the login feature of the KALE Dev software*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class NewTest {
  
	String path_chrome = "C:\\Users\\rramakrishnan\\DriversForSelenium\\chromedriver.exe";
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
	public void BeforeTest() {
		//Chrome browser is launched
		System.setProperty("webdriver.chrome.driver", path_chrome);
		driver = new ChromeDriver();
		//Browser is maximized
		driver.manage().window().maximize();
		//Browser navigates to the KALE url
		driver.navigate().to("https://kaledev.error-free.com/");		
	}
	
	
	 @AfterTest
	 public void AfterTest() {
		 //Browser is closed
		 driver.close();		
	}
}
