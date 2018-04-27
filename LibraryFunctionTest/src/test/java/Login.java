import java.util.Base64;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {

	SoftAssertions softly = new SoftAssertions();
	
	public int LoginUser(WebDriver driver, String username, String password) throws Exception{
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		//Login button is located and clicked
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-login-button"))).click();
		//Enter Username
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-un"))).sendKeys(username);
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
						  driver.findElement(By.id("pii-pw")).sendKeys(decodePassword(password));
						  //Sign in button is located and clicked
						  driver.findElement(By.id("pii-signin-button")).click();
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
			  driver.findElement(By.id("pii-un")).clear();
			  driver.findElement(By.id("pii-pw")).clear();
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
			  if (driver.findElement(By.className("sticky-note")).isDisplayed())
			  {
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();
				  
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
			 
		  }
		Actions act = new Actions (driver);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname")));
		act.click(element).build().perform();
		Thread.sleep(2000);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-signout-button")));
		act.click(element).build().perform();
		Thread.sleep(2000);
	}
		
}
