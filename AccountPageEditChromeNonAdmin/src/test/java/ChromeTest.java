import java.net.MalformedURLException;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ChromeTest {

	private WebDriver driver;
	private String username ="qaacfi";
	private String password = "S2FsZTk0OTM1ODMwQA==";
	private String chrome_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\chromedriver.exe";
	private String url = "https://kaledev.error-free.com/";
	private int login =0;
    SoftAssertions softly = new SoftAssertions();
	
	@SuppressWarnings("deprecation")
	@Rule
	  public Timeout globalTimeout= new Timeout(300000);
		  
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Ability to edit account page for non admin user in Chrome");
		  System.setProperty("webdriver.chrome.driver",chrome_path);
		  driver = new ChromeDriver();
		  //Browser is maximized
		  driver.manage().window().maximize();
		  //Browser navigates to the KALE url
		  driver.navigate().to(url);
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }
	
	public String decode(String pw){
		
		byte[] decryptedPasswordBytes = Base64.getDecoder().decode(pw);
		String decryptedPassword = new String(decryptedPasswordBytes);
		return (decryptedPassword);
	}

	public void Login() throws Exception{
		  
		  System.out.println("Title before login: "+driver.getTitle());
		  //Login button is located and clicked
		  driver.findElement(By.id("pii-login-button")).click();
		  //Login pop up is located and clicked
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("popupLogin"))).click();
		  //Username text field is located and the username is entered
		  driver.findElement(By.id("pii-un")).sendKeys(username);
		  //Password field is located and the password is entered
		  driver.findElement(By.id("pii-pw")).sendKeys(decode(password));
		  //Sign in button is located and clicked
		  String user = driver.findElement(By.id("pii-un")).getAttribute("value");
		  String pw = driver.findElement(By.id("pii-pw")).getAttribute("value");
		  int c=1;
		  if (user.equals(username)==true)
		  {
			  if(pw.equals(decode(password))==true)
			  {
				  //Sign in button is located and clicked
				  driver.findElement(By.id("pii-signin-button")).click();  
				  while(c>0)
				  {
				  Thread.sleep(2000);
				  WebElement element = driver.findElement(By.id("pii-signin-message"));
				  String text = element.getText();
				  if (element.isDisplayed())
				  {
					  if(text.isEmpty())
					  {
						  System.out.println("Logged in");
						  break;
						  }
					  else
					  {
						  driver.findElement(By.id("pii-pw")).sendKeys(decode(password));
						  //Sign in button is located and clicked
						  driver.findElement(By.id("pii-signin-button")).click();
						  login =1;
						  break;
					  }
					  			  
				  }
				  else break;
			  }}
			
		  }
		  if ((user.equals(username)==false)||(pw.equals(decode(password))==false))
		    {
				  while(c>0)
				  {
					  Thread.sleep(1000);
					  driver.findElement(By.id("pii-un")).clear();
					  driver.findElement(By.id("pii-pw")).clear();
					  //Username text field is located and the username is entered
					  driver.findElement(By.id("pii-un")).sendKeys(username);
					  //Password field is located and the password is entered
					  driver.findElement(By.id("pii-pw")).sendKeys(decode(password));
					  user = driver.findElement(By.id("pii-un")).getAttribute("value");
					  pw = driver.findElement(By.id("pii-pw")).getAttribute("value");
					  if (user.equals(username)==true)
					  {
						  if(pw.equals(decode(password))==true)
						  {
							  //Sign in button is located and clicked
							  driver.findElement(By.id("pii-signin-button")).click();
							  break;
						  }
						
					  }
				  }
			  
			  
		  }
			  
		}
	@Test
	public void test() throws Exception {
		
		//Logs in without checking Remember Me
		WebDriverWait wait = new WebDriverWait(driver,40);
		Login();
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
		//Clicks on Account
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-acct"))).click();
		//Change Name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-name"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-name"))).sendKeys("QAA changed");
		//Change Company name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-company"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-company"))).sendKeys("QAA-PII changed");
		//Change department
		WebElement dropdown = driver.findElement(By.id("pii-admin-user-dept"));
		Select s = new Select (dropdown);
		s.selectByVisibleText("Design Engineering");
		//Change job title
		WebElement dropdown1 = driver.findElement(By.id("pii-admin-user-jobtitle"));
		Select s1 = new Select (dropdown1);
		s1.selectByVisibleText("Support");
		//Change email id
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-email"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-email"))).sendKeys("Email changed");
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-button-save"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-confirmed"))).click();
		//Waits for loading message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Logs out
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-signout-button"))).click();
		Thread.sleep(2000);
		//Login again
		Login();
		Thread.sleep(3000);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Switches to the iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		Thread.sleep(5000);
		//Clicks on Account
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-acct"))).click();
		//Verifies changed data
		String name=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-name"))).getAttribute("value");
		System.out.println(name);
		softly.assertThat(name).as("test data").isEqualTo("QAA changed");
		String company =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-company"))).getAttribute("value");
		System.out.println(company);
		softly.assertThat(company).as("test data").isEqualTo("QAA-PII changed");
		String dept=driver.findElement(By.xpath(".//*[@id='pii-admin-user-dept-button']/span")).getText();
		System.out.println(dept);
		softly.assertThat(dept).as("test data").isEqualTo("Design Engineering");
		String jobTitle=driver.findElement(By.xpath(".//*[@id='pii-admin-user-jobtitle-button']/span")).getText();
		System.out.println(jobTitle);
		softly.assertThat(jobTitle).as("test data").isEqualTo("Support");
		String email=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-email"))).getAttribute("value");
		System.out.println(email);
		softly.assertThat(email).as("test data").isEqualTo("Email changed");
		//Changes data back to original value
		//Change Name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-name"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-name"))).sendKeys("QAA");
		//Change Company name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-company"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-company"))).sendKeys("QAA-PII");
		//Change department
		WebElement dropdown2 = driver.findElement(By.id("pii-admin-user-dept"));
		Select s2 = new Select (dropdown2);
		s2.selectByVisibleText("Information Technology (IT)");
		//Change job title
		WebElement dropdown3 = driver.findElement(By.id("pii-admin-user-jobtitle"));
		Select s3 = new Select (dropdown3);
		s3.selectByVisibleText("Engineer");
		//Change email id
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-email"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-email"))).sendKeys("rramakrishnan@errorfree.com");
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-button-save"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-confirmed"))).click();
		//Waits for loading message to disappear
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Logs out
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-signout-button"))).click();
		Thread.sleep(2000);
		afterTest();		
	}
	
	public void afterTest(){
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-login-button")));
		//Browser closes
		driver.quit();
		softly.assertAll();
	}

}
