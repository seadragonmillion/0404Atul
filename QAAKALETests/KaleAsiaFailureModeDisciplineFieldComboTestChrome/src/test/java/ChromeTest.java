import kaleTestSoftware.*;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChromeTest {

	private WebDriver driver;
	private String username ="ritica";
	private String password = "S2FsZTQ2MTkxODAyQA==";
	private String chrome_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\chromedriver.exe";
	private String url = "https://kaleasia.error-free.com/";
		  
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Failure mode discipline field combo test in Chrome");
		  System.setProperty("webdriver.chrome.driver",chrome_path);
		  driver = new ChromeDriver();
		  //Browser is maximized
		  driver.manage().window().maximize();
		  //Browser navigates to the KALE url
		  driver.navigate().to(url);
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }
	  
	
	@Test
	  public void SanityTest() throws Exception{
		  
		CreateEquipmentCase obj = new CreateEquipmentCase();
		Login obj1 = new Login();
		int login = obj1.LoginUser(driver, username, password);
		System.out.println("Title after login: "+driver.getTitle());
		Thread.sleep(8000);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    Thread.sleep(4000);
		//Switches to the iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		Thread.sleep(8000);
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
		//Deletes previous cases
		obj.deletePreviousCase(driver, obj.titleCombo);
		Thread.sleep(1000);
		//Creates cases in each discipline and field combo and verify cases in failure mode and deletes all cases
		obj.createCaseWithDifferentDisciplineField(driver, obj.titleCombo, obj.keywordCombo);
		//Logs out
		obj1.logout(driver);
		afterTest(obj);		
	}
	
	public void afterTest(CreateEquipmentCase obj) throws Exception{
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-login-button")));
		//Browser closes
		driver.quit();
		obj.softAssert();
	}

}
