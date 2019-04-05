import kaleTestSoftware.*;
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
		
		System.out.println("Delete notifications in Chrome");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\rramakrishnan\\DriversForSelenium\\chromedriver.exe");
		driver = new ChromeDriver();
		//Browser is maximized
		driver.manage().window().maximize();
		//Browser navigates to the KALE url
		driver.navigate().to(System.getProperty("qaurl"));
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }
	
	@Test
	public void test() throws Exception {
		Login obj = new Login ();
		ErrorMeter3 obj1 = new ErrorMeter3();
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
		//qaaandroidshare1
		login = obj.LoginUser(driver, obj2.decideSharerAndroid(0), password);
		obj2.deleteNotif(driver,obj, login);
		//qaaandroidshare2
		login = obj.LoginUser(driver, obj2.decideSharerAndroid(1), password);
		obj2.deleteNotif(driver,obj, login);
		//qaaandroidshare3
		login = obj.LoginUser(driver, obj2.decideSharerAndroid(2), password);
		obj2.deleteNotif(driver,obj, login);
		//qaarvverifier1
		login = obj.LoginUser(driver, obj2.decideSharerRVVerifier(0), password);
		obj2.deleteNotif(driver,obj, login);
		//qaarvverifiernonadmin
		login = obj.LoginUser(driver, obj2.decideSharerRVVerifier(1), password);
		obj2.deleteNotif(driver,obj, login);
		//qaaie11rvverifier
		login = obj.LoginUser(driver, obj2.decideSharerRVVerifier(2), password);
		obj2.deleteNotif(driver,obj, login);
		//qaaie11rvverifiernonadmin
		login = obj.LoginUser(driver, obj2.decideSharerRVVerifier(3), password);
		obj2.deleteNotif(driver,obj, login);
		afterTest();
	}
	
	 public void afterTest() throws Exception {
		  
		  driver.quit();		  
	  }

}
