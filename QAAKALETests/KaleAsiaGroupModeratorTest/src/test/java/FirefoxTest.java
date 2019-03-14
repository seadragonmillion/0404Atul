import kaleTestSoftware.*;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;


public class FirefoxTest {

	private WebDriver driver;
	private String gecko_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\geckodriver.exe";
	private String url = "https://kaleasia.error-free.com/";

	@Before
	public void beforeTest() throws MalformedURLException{

		System.out.println("Group Moderator test in Firefox");
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
		GroupModerator obj = new GroupModerator();
		obj.groupModeratorTest(driver, obj.username1, obj.username2, obj.username3, obj.username4, obj.username5);
		afterTest(obj);		
	}

	public void afterTest(GroupModerator obj) throws Exception{

		driver.manage().window().maximize();
		//Browser closes
		driver.quit();
		obj.softAssert();
	}

}
