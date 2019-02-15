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
		WebDriver driver = new SafariDriver();
		//Browser is maximized
		driver.manage().window().maximize();
		//Browser navigates to the KALE url
		driver.navigate().to("https://kaleqa.error-free.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public int LoginUser(WebDriver driver, String username, String password) throws Exception{

		Login obj1 = new Login();		
		Thread.sleep(2000);
		//ShareCheck obj = new ShareCheck();
		String s = driver.findElement(obj1.WebPageMessage).getText();
		System.out.println(s);
		assertEquals("\"An Error-Free Knowledge and Tool Bank\"", s);
		//Login button is located and clicked
		driver.findElement(obj1.LoginButton).click();
		//Enter Username
		driver.findElement(obj1.UserName).sendKeys(username);
		//Enter password
		driver.findElement(obj1.Password).sendKeys(decodePassword(password));
		Thread.sleep(2000);
		String user = driver.findElement(obj1.UserName).getAttribute("value");
		String pw = driver.findElement(obj1.Password).getAttribute("value");
		int c=1;
		int login=0;
		if (user.equals(username)==true)
		{
			if(pw.equals(decodePassword(password))==true)
			{
				//Sign in button is located and clicked
				driver.findElement(obj1.SignInButton).click();  
				//obj.loadingServer(driver);
				Thread.sleep(2000);
				while(c>0)
				{
					Thread.sleep(2000);
					WebElement element = driver.findElement(obj1.SignInMessage);
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
							driver.findElement(obj1.Password).sendKeys(decodePassword(password));
							//Sign in button is located and clicked
							driver.findElement(obj1.SignInButton).click();
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
				driver.findElement(obj1.UserName).clear();
				driver.findElement(obj1.Password).clear();
				Thread.sleep(2000);
				//Username text field is located and the username is entered
				driver.findElement(obj1.UserName).sendKeys(username);
				//Password field is located and the password is entered
				driver.findElement(obj1.Password).sendKeys(decodePassword(password));
				Thread.sleep(2000);
				user = driver.findElement(obj1.UserName).getAttribute("value");
				pw = driver.findElement(obj1.Password).getAttribute("value");
				if (user.equals(username)==true)
				{
					if(pw.equals(decodePassword(password))==true)
					{
						//Sign in button is located and clicked
						driver.findElement(obj1.SignInButton).click();
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

		Login obj = new Login();
		Thread.sleep(4000);
		Actions act = new Actions (driver);
		driver.findElement(obj.LoginNameOnTopRight);
		WebElement element = driver.findElement(obj.LoginNameOnTopRight);
		act.click(element).build().perform();
		Thread.sleep(3000);
		driver.findElement(obj.LogOutButton);
		element = driver.findElement(obj.LogOutButton);
		act.click(element).build().perform();
		Thread.sleep(4000);
	}

	@Test
	public void test() throws Exception{
		//Login obj = new Login ();
		HiRCALOPBug obj1 = new HiRCALOPBug();
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
		afterTest(obj1);
	}

	public void afterTest(HiRCALOPBug obj1) throws Exception {

		driver.quit();
		obj1.softAssert();
	}
}
