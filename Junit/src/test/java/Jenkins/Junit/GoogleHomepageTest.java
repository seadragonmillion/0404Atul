package Jenkins.Junit;

//import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleHomepageTest {

	private WebDriver driver;
	@Before
	public void startBrowser(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rramakrishnan\\DriversForSelenium\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void test() {
		//fail("Not yet implemented");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("http:\\www.google.com");
	}
	
	@After
	public void closeBrowser(){
		driver.quit();
	}

}
