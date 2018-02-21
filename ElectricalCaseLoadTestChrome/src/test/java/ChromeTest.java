import java.net.MalformedURLException;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ChromeTest {

	private WebDriver driver;
	private String username ="jenkins";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String chrome_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\chromedriver.exe";
	private String url = "https://kaledev.error-free.com/";
	private String keyword1 = "Slide100imagesee";
	private String keyword2 = "Slide100NoImagesee";
	private String keyword3 = "Slide100Images50ee";
	private int login;
	SoftAssertions softly = new SoftAssertions();
	
	@Rule
	  public Timeout globalTimeout= new Timeout(900000, TimeUnit.MILLISECONDS);
	
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Load test 100 slides Electrical performance search in Chrome");
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
		  
		  login =0;
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
	public void test() throws Exception{
		Login();
		System.out.println("Title after login: "+driver.getTitle());
		Thread.sleep(2000);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Switches to the iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		try{
               if (login==1)
               {
                     WebDriverWait wait2 = new WebDriverWait(driver,20);
                     wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();
               }
        }catch (NoSuchElementException e){
               throw e;
        }
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver,20);
		//Waits for black loading message
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Clicks on ErrorFree Bank
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-e"))).click();
		//Clicks on Equipment Performance Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Electrical Failure Mode Search"))).click();
		System.out.println("Case with only images");
		//Types in the keyword to get slide 8909
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).sendKeys(keyword1);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).sendKeys(Keys.ENTER);
		//Waits for black loading message
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Click on collapsible on F8909
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F8909"))).click();
		//Waits for black loading message
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Clicks on Show Slides
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-button-equip-F8909")));
		WebElement element =  driver.findElement(By.id("pii-slideshow-button-equip-F8909"));
		String slide = element.getText();
		System.out.println(slide);
		while (slide.equals("Show Slides(101)")==false)
		{
			Thread.sleep(1000);
			System.out.println(slide);
			slide = element.getText();
		}		
		System.out.println(slide);
		System.out.println(slide.indexOf("(") + "  "+ slide.indexOf(")"));
		String number= slide.substring(slide.indexOf("(")+1, slide.indexOf(")"));
	    element.sendKeys(Keys.TAB);
	    element.sendKeys(Keys.ENTER);
		driver.findElement(By.id("pii-slideshow-equip-F8909-popup"));
		System.out.println(number);
		int n = Integer.parseInt(number);
		Thread.sleep(1000);
		long total=0;
		for(int i=0;i<n-1;i++)
		{
			long f1=System.currentTimeMillis();
			System.out.println("Slide "+(i+1));
			if(i==0)
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Next"))).click();
			String load=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideimg-F8909-"+(i+1)))).getAttribute("src");
			while (load.contains("loading.gif")==true)
			{
				load=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideimg-F8909-"+(i+1)))).getAttribute("src");	
			}
			long f2=System.currentTimeMillis();
			System.out.println("Total loading time in milliseconds: "+ (f2-f1));
			total=total+(f2-f1);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Next"))).click();
		}
		System.out.println("Total time in milliseconds for case with only images:"+total);
		System.out.println("Total time in seconds for case with only images:"+(total/1000));
		long total1=total;
		//Closes the slideshow
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F8909']/a"))).click();
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-clear"))).click();
		System.out.println("Case with no images");
		//Types in the keyword to get slide 5689
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).sendKeys(keyword2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).sendKeys(Keys.ENTER);
		//Waits for black loading message
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Click on collapsible on F5689
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F5689"))).click();
		//Waits for black loading message
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Clicks on Show Slides
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-button-equip-F5689")));
		element =  driver.findElement(By.id("pii-slideshow-button-equip-F5689"));
		slide = element.getText();
		System.out.println(slide);
		while (slide.equals("Show Slides(101)")==false)
		{
			Thread.sleep(1000);
			System.out.println(slide);
			slide = element.getText();
		}		
		System.out.println(slide);
		System.out.println(slide.indexOf("(") + "  "+ slide.indexOf(")"));
		number= slide.substring(slide.indexOf("(")+1, slide.indexOf(")"));
	    element.sendKeys(Keys.TAB);
	    element.sendKeys(Keys.ENTER);
		driver.findElement(By.id("pii-slideshow-equip-F5689-popup"));
		System.out.println(number);
		n = Integer.parseInt(number);
		Thread.sleep(1000);
		total=0;
		for(int i=0;i<n-1;i++)
		{
			long f1=System.currentTimeMillis();
			System.out.println("Slide "+(i+1));
			if(i==0)
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Next"))).click();
			String load=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideimg-F5689-"+(i+1)))).getAttribute("src");
			while (load.contains("loading.gif")==true)
			{
				load=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideimg-F5689-"+(i+1)))).getAttribute("src");	
			}
			long f2=System.currentTimeMillis();
			System.out.println("Total loading time in milliseconds: "+ (f2-f1));
			total=total+(f2-f1);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Next"))).click();
		}
		System.out.println("Total time in milliseconds for case with no images:"+total);
		System.out.println("Total time in seconds for case with no images:"+(total/1000));
		long total2=total;
		//Closes the slideshow
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F5689']/a"))).click();
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-clear"))).click();
		System.out.println("Case with 50 images and text");
		//Types in the keyword to get slide 5679
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).sendKeys(keyword3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).sendKeys(Keys.ENTER);
		//Waits for black loading message
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Click on collapsible on F5679
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F5679"))).click();
		//Waits for black loading message
		try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Clicks on Show Slides
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-button-equip-F5679")));
		element =  driver.findElement(By.id("pii-slideshow-button-equip-F5679"));
		slide = element.getText();
		System.out.println(slide);
		while (slide.equals("Show Slides(101)")==false)
		{
			Thread.sleep(1000);
			System.out.println(slide);
			slide = element.getText();
		}		
		System.out.println(slide);
		System.out.println(slide.indexOf("(") + "  "+ slide.indexOf(")"));
		number= slide.substring(slide.indexOf("(")+1, slide.indexOf(")"));
	    element.sendKeys(Keys.TAB);
	    element.sendKeys(Keys.ENTER);
		driver.findElement(By.id("pii-slideshow-equip-F5679-popup"));
		System.out.println(number);
		n = Integer.parseInt(number);
		Thread.sleep(1000);
		total=0;
		for(int i=0;i<n-1;i++)
		{
			long f1=System.currentTimeMillis();
			System.out.println("Slide "+(i+1));
			if(i==0)
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Next"))).click();
			String load=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideimg-F5679-"+(i+1)))).getAttribute("src");
			while (load.contains("loading.gif")==true)
			{
				load=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideimg-F5679-"+(i+1)))).getAttribute("src");	
			}
			long f2=System.currentTimeMillis();
			System.out.println("Total loading time in milliseconds: "+ (f2-f1));
			total=total+(f2-f1);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Next"))).click();
		}
		System.out.println("Total time in milliseconds for case with 50 images:"+total);
		System.out.println("Total time in seconds for case with 50 images:"+(total/1000));
		System.out.println("Total time in seconds for case with only images:"+(total1/1000));
		System.out.println("Total time in seconds for case with no images:"+(total2/1000));
		//Closes the slideshow
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F5679']/a"))).click();
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-clear"))).click();
		//Logout
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-signout-button"))).click();
		afterTest();		
	}
	
	public void afterTest() {
		  driver.quit();
		  softly.assertAll();
		  
	  }

}
