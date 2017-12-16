import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Rule;
import org.junit.rules.Timeout;

import java.util.concurrent.TimeoutException;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.NoAlertPresentException;

public class ErrorMeterIETest {

	private InternetExplorerDriver driver;
	private String username ="jenkinsvm";
	private String password = "Kalejenkins@123";
	private String ie_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\IEDriverServer.exe";
	private String url = "https://kale.error-free.com/";
	private int login =0;
	private String title = "Sanity Test";
	SoftAssertions softly = new SoftAssertions();
	private String text16="Quisque at justo elementum, finibus elit ut, ultrices nibh.";
	private String text15="Pellentesque nec nulla vel neque tincidunt rutrum.";
	private String text14="Donec dictum enim nec mi pulvinar, nec consequat eros tristique.";
	private String text13="Vestibulum lobortis diam vel erat congue pulvinar sed a tortor.";
	private String text12="In non leo et nibh porttitor lobortis.";
	private String text11="Donec hendrerit lacus semper justo bibendum fermentum.";
	private String text10="Sed tempus nunc interdum neque sodales, at mollis magna convallis.";
	private String text9="Aliquam efficitur sem quis facilisis aliquam.";
	private String text8="Proin blandit ante at molestie finibus.";
	private String text7="Etiam quis lorem laoreet, malesuada lorem in, tristique sem.";
	private String text6="Maecenas vitae orci non dui ultrices posuere vulputate at elit.";
	private String text5="Mauris blandit elit sit amet tellus dignissim, eget maximus sem dignissim.";
	private String text4="Morbi in dui semper, sagittis augue in, elementum lorem.";
	private String text3 ="Vivamus ut lacus finibus, dictum neque interdum, tincidunt eros.";
	private String text2="Duis vestibulum ipsum at dui tincidunt, semper eleifend est congue.";
	private String text1 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.";
	
	@SuppressWarnings("deprecation")
	@Rule
	  public Timeout globalTimeout= new Timeout(1000000);
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Performing sanity test on SPV Error Meter in Internet Explorer");
		  System.setProperty("webdriver.ie.driver",ie_path);
		  DesiredCapabilities cap = new DesiredCapabilities(); 
		  cap.setCapability("ignoreZoomSettings", true);
		  cap.setCapability("requireWindowFocus", true);
		  driver = new InternetExplorerDriver(cap);
		  //Browser is maximized
		  driver.manage().window().maximize();
		  //Browser navigates to the KALE url
		  driver.navigate().to(url);
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  /*driver.findElement(By.id("pii-home")).sendKeys(Keys.CONTROL);
		  driver.findElement(By.id("pii-home")).sendKeys(Keys.F11);*/
		  
	  }
	
	public void Login() throws Exception{
		  
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  System.out.println("Title before login: "+driver.getTitle());
		  //Login button is located and clicked
		  jse.executeScript("return document.getElementById('pii-login-button').click();");
		  //Login pop up is located and clicked
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("popupLogin"))).click();
		  Thread.sleep(2000);
		  //Username text field is located and the username is entered
		  driver.findElement(By.id("pii-un")).sendKeys(username);
		  //Password field is located and the password is entered
		  driver.findElement(By.id("pii-pw")).sendKeys(password);
		  Thread.sleep(2000);
		  //Sign in button is located and clicked
		  String user = driver.findElement(By.id("pii-un")).getAttribute("value");
		  String pw = driver.findElement(By.id("pii-pw")).getAttribute("value");
		  int c=1;
		  if (user.equals(username)==true)
		  {
			  if(pw.equals(password)==true)
			  {
				  //Sign in button is located and clicked
				  jse.executeScript("return document.getElementById('pii-signin-button').click();");  
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
						  driver.findElement(By.id("pii-pw")).sendKeys(password);
						  //Sign in button is located and clicked
						  jse.executeScript("return document.getElementById('pii-signin-button').click();");
						  login =1;
						  break;
					  }
					  			  
				  }
				  else break;
			  }}
			
		  }
		  if ((user.equals(username)==false)||(pw.equals(password)==false))
		    {
				  while(c>0)
				  {
					  Thread.sleep(1000);
					  driver.findElement(By.id("pii-un")).clear();
					  driver.findElement(By.id("pii-pw")).clear();
					  //Username text field is located and the username is entered
					  driver.findElement(By.id("pii-un")).sendKeys(username);
					  //Password field is located and the password is entered
					  driver.findElement(By.id("pii-pw")).sendKeys(password);
					  user = driver.findElement(By.id("pii-un")).getAttribute("value");
					  pw = driver.findElement(By.id("pii-pw")).getAttribute("value");
					  if (user.equals(username)==true)
					  {
						  if(pw.equals(password)==true)
						  {
							  //Sign in button is located and clicked
							  jse.executeScript("return document.getElementById('pii-signin-button').click();");
							  break;
						  }
						
					  }
				  }
			  
			  
		  }
	  }
	
	public void deleteNewRecord(String recordName) throws Exception{
		  
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  //CLicks on first newly created record
		 // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-epm']/ul/li[2]/a"))).click();
		  //Clicks on delete button
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title")));
		  //Clicks on delete report
		  driver.findElement(By.id("pii-user-home-dialog-confirmed")).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		   wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  Thread.sleep(2000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-epm"))).click();
		  //Verify record deleted
		  //Click on 1st record
		  Thread.sleep(2000);
		  String name = driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-epm']/ul/li[2]/a")).getText();
		  System.out.println(name);
		  if (name!=recordName)
			  System.out.println("Record deleted");
		  else
			  System.out.println("Record could not be deleted");
		  
		  			  
	  }

	   public void downloadRecord() throws Exception {
	    	
	    	WebDriverWait wait1 = new WebDriverWait(driver,60);
	    	//Clicks on first newly created record
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-epm']/ul/li[2]/a"))).click();
	    	reportCheck();
			//Clicks on download button
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a"))).click();
			try{
				  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
				  wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
				 }catch (org.openqa.selenium.TimeoutException e)
				  {
					  
				  }
			
			String window = driver.getWindowHandle();
			//Clicks on open pdf report
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
	    	Thread.sleep(2000);
	    	try {
				  Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/OpenPdf.exe");
				  q.waitFor();
				  }catch (UnhandledAlertException f){	
					  System.out.println("Unexpected alert for picture 2");
					  driver.switchTo().alert().accept();
					  
			  	  }catch (NoAlertPresentException f){
			  		  System.out.println ("No unexpected alert for picture 2");
			  		  }
	    	Thread.sleep(8000);
	    	//Close pdf
	    	Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/ClosePdf.exe");
			q.waitFor();
			Thread.sleep(4000);
			//Switch to window    	
	    	driver.switchTo().window(window);
	    	driver.switchTo().defaultContent();
	    		    	
	    }
	    
	    public void shareReport() throws Exception{
	    	
	    	WebDriverWait wait1 = new WebDriverWait(driver,60);
			//Switches to the iframe
			wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
	    	//Clicks on share button
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[3]"))).click();
			//Enters username
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-uhshare-search-input"))).sendKeys("qaacreator");
	    	//Selects from dropdown
			WebElement dropdown = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhshare-blocks']/div[2]/ul")));
			dropdown.findElement(By.cssSelector(".ui-first-child.ui-last-child")).click();
			//Clicks on add user
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
			//Verifies user added
			String user=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhshare-blocks']/div/form/div/ul/li/a"))).getText();
			softly.assertThat(user).as("test data").isEqualTo("qaacreator");
			//Clicks on save
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-uhshare-save"))).click();
			//Waits for black loading message to disappear
			  try{
				  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
				  wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
				 }catch (org.openqa.selenium.TimeoutException e)
				  {
					  
				  }	
			 //Checks the username of creator and shared with
			 WebElement creator = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/table/tbody/tr/td")));
			 String creatorUsername= creator.getText();
			 System.out.println(creatorUsername);
			 softly.assertThat(username).as("test data").isSubstringOf(creatorUsername);
			 WebElement sharedTo=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/table/tbody/tr[2]/td/span")));
			 String sharedToUsername = sharedTo.getText();
			 System.out.println(sharedToUsername);
			 softly.assertThat("qaacreator").as("test data").isEqualTo(sharedToUsername);
			 WebElement shared=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/table/tbody/tr[2]/td/strong")));
			 String sharedText = shared.getText();
			 System.out.println(sharedText);
			 softly.assertThat("Shared with:").as("test data").isEqualTo(sharedText);
			 WebElement probability=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/table[3]/tbody/tr/td/strong")));
			 String probabilityText = probability.getText();
			 System.out.println(probabilityText);
			 softly.assertThat("50.00%").as("test data").isEqualTo(probabilityText);
	    }
	    
	    public void markCritical() throws Exception{
	    	
	    	WebDriverWait wait1 = new WebDriverWait(driver,60);
	    	//Clicks on mark critical
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div[2]/div/label"))).click();
	    	//Clicks on confirm change
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
			//Checks if marked critical
			String critical=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/table[2]/tbody/tr/th/strong"))).getText();
			softly.assertThat(critical).as("test data").contains("Critical");
			if(driver.findElement(By.xpath(".//*[@id='epm-rpt']/table[2]/tbody/tr/th/strong")).isDisplayed())
				System.out.println("Marked critical");
			//Clicks on mark critical again
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div[2]/div/label"))).click();
	    	//Clicks on confirm change
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
			Thread.sleep(2000);
			if(driver.findElement(By.xpath(".//*[@id='epm-rpt']/table[2]/tbody/tr/th/strong")).isDisplayed()==false)
			{
				System.out.println("Unmarked critical");
			}
				
	    }
public void pape() throws Exception{
			
			WebDriverWait wait1 = new WebDriverWait(driver,60);
			int i;
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			//Click on Environment of PAPE
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-taba-e"))).click();
			//Clicks on checkboxes in Environment Tab
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-e-q1"))).click();
						
			jse.executeScript("scroll(0, 800)");
			Thread.sleep(1000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-e-q4"))).click();
			
			//Fill in texts in Supporting reasons 
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(text1);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[2]/td[3]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(text1);
			
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(text2);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[5]/td[3]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(text2);
			
			//Fill in texts in Corrective Actions
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(text3);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[2]/td[4]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(text3);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(text4);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[5]/td[4]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(text4);

			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			//Checks error meter as 13%
			WebElement meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
			String meterText = meter.getText();
			System.out.println(meterText);
			softly.assertThat("13%").as("test data").isEqualTo(meterText);



			//Click on People of PAPE
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-taba-p"))).click();
			//Clicks on checkboxes in People Tab
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-p-q2"))).click();
			Thread.sleep(3000);
			meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
			meterText = meter.getText();
			System.out.println(meterText);
			softly.assertThat("19%").as("test data").isEqualTo(meterText);
			
			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-p-q3"))).click();
			Thread.sleep(3000);
			meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
			meterText = meter.getText();
			System.out.println(meterText);
			softly.assertThat("25%").as("test data").isEqualTo(meterText);
			
			//Fill in texts in Supporting reasons 
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(text5);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[3]/td[3]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(text5);
			
			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(text6);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[4]/td[3]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(text6);
			
			//Fill in texts in Corrective Actions
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(text7);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[3]/td[4]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(text7);
			
			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(text8);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[4]/td[4]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(text8);
						
			
			//Click on Activity of PAPE
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-taba-a"))).click();
			//Clicks on checkboxes in Activity Tab
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-a-q2"))).click();
			Thread.sleep(3000);
			meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
			meterText = meter.getText();
			System.out.println(meterText);
			softly.assertThat("31%").as("test data").isEqualTo(meterText);
			
			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-a-q4"))).click();
			Thread.sleep(3000);
			meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
			meterText = meter.getText();
			System.out.println(meterText);
			softly.assertThat("38%").as("test data").isEqualTo(meterText);
			
			//Fill in texts in Supporting reasons 
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(text9);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[3]/td[3]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(text9);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(text10);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[5]/td[3]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(text10);
			
			//Fill in texts in Corrective Actions
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(text11);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[3]/td[4]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(text11);
			
			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(text12);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[5]/td[4]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(text12);



			//Clicks on Procedure Tab
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-taba-t"))).click();
			//Clicks on checkboxes in Procedure Tab
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-t-q1"))).click();
			Thread.sleep(3000);
			meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
			meterText = meter.getText();
			System.out.println(meterText);
			softly.assertThat("44%").as("test data").isEqualTo(meterText);
			
			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-t-q3"))).click();
			Thread.sleep(3000);
			meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
			meterText = meter.getText();
			System.out.println(meterText);
			softly.assertThat("50%").as("test data").isEqualTo(meterText);
				
			//Fill in texts in Supporting reasons 
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(text13);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[2]/td[3]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(text13);
			
			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(text14);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[4]/td[3]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(text14);
			
			//Fill in texts in Corrective Actions
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(text15);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[2]/td[4]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(text15);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(text16);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[4]/td[4]/textarea"))).clear();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(text16);
			
		}
	    
	    public void reportCheck() throws Exception{
	    	
	    	WebDriverWait wait = new WebDriverWait(driver,30);
	    	//Compare Environment data
	    	//Supporting reasons
	    	String text1E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[2]/td[3]"))).getText();
	    	softly.assertThat(text1E).as("test data").isEqualTo(text1);
	    	String text2E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[3]/td[3]"))).getText();
	    	softly.assertThat(text2E).as("test data").isEqualTo("");
	    	String text3E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[4]/td[3]"))).getText();
	    	softly.assertThat(text3E).as("test data").isEqualTo("");
	    	String text4E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[5]/td[3]"))).getText();
	    	softly.assertThat(text4E).as("test data").isEqualTo(text2);
	    	//Corrective actions
	    	String text5E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[2]/td[4]"))).getText();
	    	softly.assertThat(text5E).as("test data").isEqualTo(text3);
	    	String text6E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[3]/td[4]"))).getText();
	    	softly.assertThat(text6E).as("test data").isEqualTo("");
	    	String text7E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[4]/td[4]"))).getText();
	    	softly.assertThat(text7E).as("test data").isEqualTo("");
	    	String text8E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[5]/td[4]"))).getText();
	    	softly.assertThat(text8E).as("test data").isEqualTo(text4);
	    	
	    	//Compare People data
	    	//Supporting reasons
	    	String text9E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[2]/td[3]"))).getText();
	    	softly.assertThat(text9E).as("test data").isEqualTo("");
	    	String text10E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[3]/td[3]"))).getText();
	    	softly.assertThat(text10E).as("test data").isEqualTo(text5);
	    	String text11E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[4]/td[3]"))).getText();
	    	softly.assertThat(text11E).as("test data").isEqualTo(text6);
	    	String text12E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[5]/td[3]"))).getText();
	    	softly.assertThat(text12E).as("test data").isEqualTo("");
	    	//Corrective actions
	    	String text13E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[2]/td[4]"))).getText();
	    	softly.assertThat(text13E).as("test data").isEqualTo("");
	    	String text14E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[3]/td[4]"))).getText();
	    	softly.assertThat(text14E).as("test data").isEqualTo(text7);
	    	String text15E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[4]/td[4]"))).getText();
	    	softly.assertThat(text15E).as("test data").isEqualTo(text8);
	    	String text16E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[5]/td[4]"))).getText();
	    	softly.assertThat(text16E).as("test data").isEqualTo("");
	    	
	    	//Compare Activity data
	    	//Supporting reasons
	    	String text17E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[2]/td[3]"))).getText();
	    	softly.assertThat(text17E).as("test data").isEqualTo("");
	    	String text18E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[3]/td[3]"))).getText();
	    	softly.assertThat(text18E).as("test data").isEqualTo(text9);
	    	String text19E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[4]/td[3]"))).getText();
	    	softly.assertThat(text19E).as("test data").isEqualTo("");
	    	String text20E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[5]/td[3]"))).getText();
	    	softly.assertThat(text20E).as("test data").isEqualTo(text10);
	    	//Corrective actions
	    	String text21E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[2]/td[4]"))).getText();
	    	softly.assertThat(text21E).as("test data").isEqualTo("");
	    	String text22E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[3]/td[4]"))).getText();
	    	softly.assertThat(text22E).as("test data").isEqualTo(text11);
	    	String text23E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[4]/td[4]"))).getText();
	    	softly.assertThat(text23E).as("test data").isEqualTo("");
	    	String text24E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[5]/td[4]"))).getText();
	    	softly.assertThat(text24E).as("test data").isEqualTo(text12);
	    	
	    	//Compare Procedure data
	    	//Supporting reasons
	    	String text25E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[2]/td[3]"))).getText();
	    	softly.assertThat(text25E).as("test data").isEqualTo(text13);
	    	String text26E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[3]/td[3]"))).getText();
	    	softly.assertThat(text26E).as("test data").isEqualTo("");
	    	String text27E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[4]/td[3]"))).getText();
	    	softly.assertThat(text27E).as("test data").isEqualTo(text14);
	    	String text28E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[5]/td[3]"))).getText();
	    	softly.assertThat(text28E).as("test data").isEqualTo("");
	    	//Corrective actions
	    	String text29E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[2]/td[4]"))).getText();
	    	softly.assertThat(text29E).as("test data").isEqualTo(text15);
	    	String text30E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[3]/td[4]"))).getText();
	    	softly.assertThat(text30E).as("test data").isEqualTo("");
	    	String text31E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[4]/td[4]"))).getText();
	    	softly.assertThat(text31E).as("test data").isEqualTo(text16);
	    	String text32E=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[5]/td[4]"))).getText();
	    	softly.assertThat(text32E).as("test data").isEqualTo("");
	    	
	    	//Checks for SPV and non issue
	    	//Procedure
	    	String textsp1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[2]/td[1]"))).getText();
	    	softly.assertThat(textsp1).as("test data").isEqualTo("SPV");
	    	String textnon1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[3]/td[1]"))).getText();
	    	softly.assertThat(textnon1).as("test data").isEqualTo("Non-Issue");
	    	String textsp2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[4]/td[1]"))).getText();
	    	softly.assertThat(textsp2).as("test data").isEqualTo("SPV");
	    	String textnon2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[2]/table/tbody/tr[5]/td[1]"))).getText();
	    	softly.assertThat(textnon2).as("test data").isEqualTo("Non-Issue");
	    	
	    	//Activity
	    	String textnon3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[2]/td[1]"))).getText();
	    	softly.assertThat(textnon3).as("test data").isEqualTo("Non-Issue");
	    	String textsp3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[3]/td[1]"))).getText();
	    	softly.assertThat(textsp3).as("test data").isEqualTo("SPV");
	    	String textnon4=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[4]/td[1]"))).getText();
	    	softly.assertThat(textnon4).as("test data").isEqualTo("Non-Issue");
	    	String textsp4=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[3]/table/tbody/tr[5]/td[1]"))).getText();
	    	softly.assertThat(textsp4).as("test data").isEqualTo("SPV");
	    	
	    	//People
	    	String textnon5=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[2]/td[1]"))).getText();
	    	softly.assertThat(textnon5).as("test data").isEqualTo("Non-Issue");
	    	String textsp5=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[3]/td[1]"))).getText();
	    	softly.assertThat(textsp5).as("test data").isEqualTo("SPV");
	    	String textsp6=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[4]/td[1]"))).getText();
	    	softly.assertThat(textsp6).as("test data").isEqualTo("SPV");
	    	String textnon6=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[4]/table/tbody/tr[5]/td[1]"))).getText();
	    	softly.assertThat(textnon6).as("test data").isEqualTo("Non-Issue");
	    	
	    	//Environment
	    	String textsp7=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[2]/td[1]"))).getText();
	    	softly.assertThat(textsp7).as("test data").isEqualTo("SPV");
	    	String textnon7=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[3]/td[1]"))).getText();
	    	softly.assertThat(textnon7).as("test data").isEqualTo("Non-Issue");
	    	String textnon8=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[4]/td[1]"))).getText();
	    	softly.assertThat(textnon8).as("test data").isEqualTo("Non-Issue");
	    	String textsp8=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='epm-rpt']/div[5]/table/tbody/tr[5]/td[1]"))).getText();
	    	softly.assertThat(textsp8).as("test data").isEqualTo("SPV");
	    }

	  @Test
	  public void SanityTest() throws Exception{
		  try{ 
		  Login();
		  System.out.println("Title after login: "+driver.getTitle());
		  //Waits for the page to load
	      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	      Thread.sleep(2000);
	      //Switches to the iframe
		  driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		  
		  Thread.sleep(4000);
		  WebDriverWait wait = new WebDriverWait(driver,20);
		  //Clicks on Analysis 
		  try
		  {
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-a"))).click();
		  }catch (UnhandledAlertException f){			  
			  driver.switchTo().alert().dismiss();
		  }
		  if (login==1)
        {
              
              while(true)
  		  {
             	 Thread.sleep(1000);
  			  if (driver.findElement(By.cssSelector(".sticky-queue.top-right")).isDisplayed())
  			  {
  				  WebElement ele =driver.findElement(By.cssSelector(".sticky-queue.top-right"));
  				  ele.findElement(By.className("sticky-close")).click();
  				  break;
  			  }
  			  else break;
  		  }
        }
		//Clicks on SPV Error meter
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-em"))).click();
		  Thread.sleep(4000);
		  //Select Purpose from dropdown
		  WebElement element = driver.findElement(By.id("pii-epm-select-purpose"));
		  Select s = new Select (element);
		  s.selectByVisibleText("PJB");
		  Thread.sleep(3000);
		  //Select Job type
		  element = driver.findElement(By.id("pii-epm-select-condition"));
		  Select s1 = new Select (element);
		  s1.selectByVisibleText("Construction");
		  Thread.sleep(3000);
		  //Fills Job title
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-job-title"))).sendKeys(title);
		  String ev1= driver.findElement(By.id("pii-epm-job-title")).getAttribute("value");
		  if(ev1.equals(title)==false)
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-job-title"))).sendKeys(title);
		  Thread.sleep(3000);
		  //Click on next
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-btn-next"))).click();
		  Thread.sleep(3000);
		  pape();
		  //Click on finalize
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-btn-done"))).click();
		  Thread.sleep(3000);
		  //Click on finalize and save
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-dialog-title"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-dialog-confirmed"))).click(); 
		  //Waits for the green popup on the right top corner
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  //Creates expected record name
		  String date= driver.findElement(By.xpath(".//*[@id='epm-rpt']/table/tbody/tr/td[2]")).getText();
		  date = date.substring(14);
		  String time = driver.findElement(By.xpath(".//*[@id='epm-rpt']/table/tbody/tr[2]/td[2]")).getText();
		  time = time.substring(14);
		  String time2 = time.substring(0, 8);
		  String time1=time.substring(9);
		  String purpose = driver.findElement(By.xpath(".//*[@id='epm-rpt']/div/div/span/abbr")).getText();
		  String name = date + "_" + time2+"_"+time1 + "_" + username +"_" + purpose + "_" + title;
		  System.out.println ("Expected name of record: " +name);
		  //Clicks on side panel
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-epm"))).click();
		  //Gets the name of the record created
		  WebElement record = driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-epm']/ul/li[2]/a"));
		  String recordName = record.getText();
		  if (record.isDisplayed())
		  {
			  System.out.println("Record found: "+ recordName);
		  }
		  else
			  System.out.println ("Record not found.");
		  	
		  //Checks if the record name is correct
		  assertEquals(name,recordName);
		  Thread.sleep(2000);
		  //Downloads record
		  downloadRecord();
		  Thread.sleep(2000);
		  //Shares report
		  shareReport();
		  Thread.sleep(2000);
		  //Mark critical
		  markCritical();
		  Thread.sleep(2000);
		  //Deletes the record
		  deleteNewRecord(recordName);
		  Thread.sleep(2000);
		  
		   //Logs out
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-signout-button"))).click();
		  Thread.sleep(2000);
		  afterTest();
		   }catch(TimeoutException e)
		   {
			   System.out.println(e);
			  /* driver.findElement(By.id("pii-home")).sendKeys(Keys.CONTROL);
			   driver.findElement(By.id("pii-home")).sendKeys(Keys.F11);*/
			   
			   driver.quit();
		   }
		 
		  
	}
	
	
	public void afterTest(){
		
		/*driver.findElement(By.id("pii-home")).sendKeys(Keys.CONTROL);
		driver.findElement(By.id("pii-home")).sendKeys(Keys.F11);*/
		//Browser closes
		driver.quit();
		softly.assertAll();
	}
}
