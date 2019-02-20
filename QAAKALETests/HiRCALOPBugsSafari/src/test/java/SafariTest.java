import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;


public class SafariTest {

	private WebDriver driver;
	private String username = "ritica_only_nonadmin";
	private String password = "S2FsZWplbmtpbnNAMTIz";

	@Before
	public void beforeTest() throws MalformedURLException{

		System.out.println("HiRCA LOP Bug Check Safari on MAC");
		//System.setProperty("webdriver.safari.driver", "/Applications/Safari Technology Preview.app/Contents/MacOS/safaridriver");
		driver = new SafariDriver();
		System.out.println("driver=" + driver); 
		//Browser is maximized
		driver.manage().window().maximize();
		//Browser navigates to the KALE url
		driver.navigate().to("https://kaleqa.error-free.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public int LoginUser(WebDriver driver, String username, String password) throws Exception{

		//Login obj1 = new Login();
		Thread.sleep(2000);
		//ShareCheck obj = new ShareCheck();
		WebElement ele = driver.findElement(By.className("pii-slogan"));
		String s = ele.getText();
		System.out.println(s);
		assertEquals("\"An Error-Free Knowledge and Tool Bank\"", s);
		//Login button is located and clicked
		 WebElement ele = driver.findElement(By.id("pii-login-button"));
		ele.click();
		//Enter Username
		driver.findElement(By.id("pii-un")).sendKeys(username);
		//Enter password
		driver.findElement(By.id("pii-pw")).sendKeys(decodePassword(password));
		Thread.sleep(2000);
		String user = driver.findElement(By.id("pii-un")).getAttribute("value");
		String pw = driver.findElement(By.id("pii-pw")).getAttribute("value");
		int c=1;
		int login=0;
		if (user.equals(username)==true)
		{
			if(pw.equals(decodePassword(password))==true)
			{
				//Sign in button is located and clicked
				driver.findElement(By.id("pii-signin-button")).click();  
				//obj.loadingServer(driver);
				Thread.sleep(2000);
				while(c>0)
				{
					Thread.sleep(2000);
					WebElement element = driver.findElement(By.id("pii-signin-message"));
					String text = element.getText();
					System.out.println(text);
					if (element.isDisplayed())
					{
						if(text.isEmpty())
						{
							System.out.println("Logged in");
							break;
						}
						else
						{
							driver.findElement(By.id("pii-pw")).sendKeys(decodePassword(password));
							//Sign in button is located and clicked
							driver.findElement(By.id("pii-signin-button")).click();
							if(text.contains("Warning: This user has an existing login session"))
								login =1;
							Thread.sleep(2000);
							break;
						}

					}
					else break;
				}
			}
		}
		if ((user.equals(username)==false)||(pw.equals(decodePassword(password))==false))
		{
			while(c>0)
			{
				Thread.sleep(1000);
				driver.findElement(By.id("pii-un")).clear();
				driver.findElement(By.id("pii-pw")).clear();
				Thread.sleep(2000);
				//Username text field is located and the username is entered
				driver.findElement(By.id("pii-un")).sendKeys(username);
				//Password field is located and the password is entered
				driver.findElement(By.id("pii-pw")).sendKeys(decodePassword(password));
				Thread.sleep(2000);
				user = driver.findElement(By.id("pii-un")).getAttribute("value");
				pw = driver.findElement(By.id("pii-pw")).getAttribute("value");
				if (user.equals(username)==true)
				{
					if(pw.equals(decodePassword(password))==true)
					{
						//Sign in button is located and clicked
						driver.findElement(By.id("pii-signin-button")).click();
						Thread.sleep(2000);
						break;
					}
				}
			}		  
		}
		Thread.sleep(3000);
		return login;
	}

	public String decodePassword(String pw){

		byte[] decryptedPasswordBytes = Base64.getDecoder().decode(pw);
		String decryptedPassword = new String(decryptedPasswordBytes);
		return (decryptedPassword);
	}

	public void logout (WebDriver driver) throws Exception {

		//Login obj = new Login();
		Thread.sleep(4000);
		Actions act = new Actions (driver);
		driver.findElement(By.id("pii-user-loginname"));
		WebElement element = driver.findElement(By.id("pii-user-loginname"));
		act.click(element).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.id("pii-signout-button"));
		element = driver.findElement(By.id("pii-signout-button"));
		act.click(element).build().perform();
		Thread.sleep(4000);
	}

	@Test
	public void test() throws Exception{
		//Login obj = new Login ();
		//HiRCALOPBug obj1 = new HiRCALOPBug();
		int login = LoginUser(driver, username, password);
		System.out.println("Title after login: "+driver.getTitle());
		Thread.sleep(5000);
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
		Thread.sleep(4000);/*
		//Fill mandatory data
		obj1.fillUpHiRCAEventInfo(driver,obj1.text);
		//Bug KALE 1959
		obj1.bugPath1KALE1959(driver);
		//Bug KALE 1926
		obj1.bugPathWith2LopsKALE1926(driver);
		//Bug KALE 1947
		obj1.bugPath1KALE1947(driver);
		//Bug KALE 1957
		obj1.bugKALE1957(driver);
		//Bug KALE 1846
		obj1.bugKALE1846(driver);
		//Bug KALE 1852
		obj1.bugKALE1852(driver);
		//Bug KALE 2219 and KALE 2246
		//obj1.bugKALE2219KALE2246(driver);*/
		//Logout
		logout(driver);
		afterTest();
	}

	public void afterTest() throws Exception {

		driver.quit();
		//obj1.softAssert();
	}
}
