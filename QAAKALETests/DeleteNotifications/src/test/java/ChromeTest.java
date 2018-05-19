import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ChromeTest {

	private WebDriver driver;
	private String password = "S2FsZWplbmtpbnNAMTIz";
	
	@Before
	  public void beforeTest() throws Exception{
		
		deleteNotifications obj = new deleteNotifications();
		System.out.println("Delete notifications in Chrome");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\rramakrishnan\\DriversForSelenium\\chromedriver.exe");
		driver = new ChromeDriver();
		//Browser is maximized
		driver.manage().window().maximize();
		//Browser navigates to the KALE url
		driver.navigate().to(obj.urlDev);
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }
	
	@Test
	public void test() throws Exception {
		Login obj = new Login ();
		ErrorMeter obj1 = new ErrorMeter();
		deleteNotifications obj2 = new deleteNotifications();
		//qaasharer
		int login = obj.LoginUser(driver, obj1.decideSharer(0), password);
		obj2.deleteNotif(driver,obj, login);
		//qaasharernonadmin
		login = obj.LoginUser(driver, obj1.decideSharer(1), password);
		obj2.deleteNotif(driver,obj, login);
		//qaasharerie11
		login = obj.LoginUser(driver, obj1.decideSharer(2), password);
		obj2.deleteNotif(driver,obj, login);
		//qaasharernonadminie11
		login = obj.LoginUser(driver, obj1.decideSharer(3), password);
		obj2.deleteNotif(driver,obj, login);
		afterTest();
	}
	
	 public void afterTest() throws Exception {
		  
		  driver.quit();		  
	  }

}
