import java.util.Base64;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {

	SoftAssertions softly = new SoftAssertions();
	By LoginButton = By.id("pii-login-button");
	By UserName = By.id("pii-un");
	By Password = By.id("pii-pw");
	By SignInButton = By.id("pii-signin-button");
	By SignInMessage = By.id("pii-signin-message");
	By StickyNote = By.className("sticky-note");
	By StickyClose = By.className("sticky-close");
	By LoginNameOnTopRight = By.id("pii-user-loginname");
	By LogOutButton = By.id("pii-signout-button");
	
	public int LoginUser(WebDriver driver, String username, String password) throws Exception{
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		//Login button is located and clicked
		wait.until(ExpectedConditions.elementToBeClickable(LoginButton)).click();
		//Enter Username
		wait.until(ExpectedConditions.visibilityOfElementLocated(UserName)).sendKeys(username);
		//Enter password
		driver.findElement(Password).sendKeys(decodePassword(password));
		Thread.sleep(2000);
		String user = driver.findElement(UserName).getAttribute("value");
		String pw = driver.findElement(Password).getAttribute("value");
		int c=1;
		int login=0;
		if (user.equals(username)==true)
		{
		  if(pw.equals(decodePassword(password))==true)
		  {
			  //Sign in button is located and clicked
			  driver.findElement(SignInButton).click();  
			  while(c>0)
			  {
				  Thread.sleep(2000);
				  WebElement element = driver.findElement(SignInMessage);
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
						  driver.findElement(Password).sendKeys(decodePassword(password));
						  //Sign in button is located and clicked
						  driver.findElement(SignInButton).click();
						  login =1;
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
			  driver.findElement(UserName).clear();
			  driver.findElement(Password).clear();
			  //Username text field is located and the username is entered
			  driver.findElement(UserName).sendKeys(username);
			  //Password field is located and the password is entered
			  driver.findElement(Password).sendKeys(decodePassword(password));
			  Thread.sleep(2000);
			  user = driver.findElement(UserName).getAttribute("value");
			  pw = driver.findElement(Password).getAttribute("value");
			  if (user.equals(username)==true)
			  {
			  if(pw.equals(decodePassword(password))==true)
			  {
				  //Sign in button is located and clicked
				  driver.findElement(SignInButton).click();
				  break;
			  }
			  }
			}		  
      }
	   return login;
	}
	
	public String decodePassword(String pw){
		
		byte[] decryptedPasswordBytes = Base64.getDecoder().decode(pw);
		String decryptedPassword = new String(decryptedPasswordBytes);
		return (decryptedPassword);
	}
	
	public void logout (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		while(true)
		  {
			  try{
			  if (driver.findElement(StickyNote).isDisplayed())
			  {
				  Thread.sleep(1000);
				  wait.until(ExpectedConditions.visibilityOfElementLocated(StickyClose)).click();
				  
			  }}catch (NoSuchElementException e)
			  {
				  break;
			  }
			  catch( StaleElementReferenceException f)
			  {
				  
				 break;
			  }
			  catch (org.openqa.selenium.TimeoutException u)
			  {
				  break;
			  }
			  catch (org.openqa.selenium.ElementNotInteractableException u)
			  {
				  break;
			  }
			  catch (org.openqa.selenium.JavascriptException t)
			  {
				  Thread.sleep(2000);
				  break;
			  }
			 
		  }
		Thread.sleep(4000);
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		if(browserName.equals("firefox"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(LoginNameOnTopRight)).click();		
			Thread.sleep(3000);
			while(true)
			{
			try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(LogOutButton)).click();
			break;
			}catch(org.openqa.selenium.TimeoutException t)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(LoginNameOnTopRight)).click();
			}
			}
			Thread.sleep(5000);
		}
		else
		{
		Actions act = new Actions (driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LoginNameOnTopRight));
		WebElement element = driver.findElement(LoginNameOnTopRight);
		act.click(element).build().perform();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LogOutButton));
		element = driver.findElement(LogOutButton);
		act.click(element).build().perform();
		Thread.sleep(2000);
		}
	}
		
}
