import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class IETest {

	private InternetExplorerDriver driver;
	private String username ="qaacfi";
	 private String password = "Kale94935830@";
	private String ie_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\IEDriverServer_Win32_3.6.0\\IEDriverServer.exe";
	private String url = "https://kale.error-free.com/";
	private int login =0;
	SoftAssertions softly = new SoftAssertions();
	
	@SuppressWarnings("deprecation")
	@Rule
	  public Timeout globalTimeout= new Timeout(800000);
	
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Performing verification on event information page in HiRCA for non admin in Internet Explorer");
		  System.setProperty("webdriver.ie.driver",ie_path);
		  DesiredCapabilities cap = new DesiredCapabilities(); 
		  cap.setCapability("ignoreZoomSettings", true);
		  //cap.setCapability("requireWindowFocus", true);
		  driver = new InternetExplorerDriver(cap);
		  //Browser is maximized
		  driver.manage().window().maximize();
		  //Browser navigates to the KALE url
		  driver.navigate().to(url);
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  
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
		  
	      
		  WebDriverWait wait = new WebDriverWait(driver,40);
		  //Clicks on delete button
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[3]"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title")));
		  //Clicks on delete report
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  Thread.sleep(2000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-irca"))).click();
		  //Verify record deleted
		  //Click on 1st record
		  String name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).getText();
		  System.out.println(name);
		  if (name!=recordName)
			  System.out.println("Record deleted");
		  else
			  System.out.println("Record could not be deleted");
		  			  
	  }
	  
	    public void openReport() throws Exception{

	    	//Clicks on Open button
	    	WebDriverWait wait1 = new WebDriverWait(driver,30);
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a"))).click();
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
	    	//Clicks on open report
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
	    	//Clicks on Save
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))).click();
			//Clicks on Save report
		    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-success")));
			Thread.sleep(1000);
	        //Clicks on Saved activities
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-btn-savedactivities"))).click();
			Thread.sleep(2000);
	    }
	    
	    public void downloadRecord() throws Exception {
	    	
	    	WebDriverWait wait1 = new WebDriverWait(driver,60);
	    	//Clicks on first newly created record
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();
			
			//Clicks on download button
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).click();
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
			Thread.sleep(8000);
			//Switch to window    	
	    	driver.switchTo().window(window);
	    	    	
				    		    	
	    }
	    
	    public void shareReport() throws Exception{
	    	
	    	WebDriverWait wait1 = new WebDriverWait(driver,60);
			//Switches to the iframe
			wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
	    	//Clicks on share button
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[4]"))).click();
			//Enters username
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-uhshare-search-input"))).sendKeys("qaacfiverifier");
	    	//Selects from dropdown
			WebElement dropdown = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhshare-blocks']/div[2]/ul")));
			dropdown.findElement(By.cssSelector(".ui-first-child.ui-last-child")).click();
			//Clicks on add user
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
			//Verifies user added
			String user=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhshare-blocks']/div/form/div/ul/li/a"))).getText();
			softly.assertThat(user).as("test data").isEqualTo("qaacfiverifier");
			//Clicks on save
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-uhshare-save"))).click();
	    }
	    
	    public void markCritical() throws Exception{
	    	
	    	WebDriverWait wait1 = new WebDriverWait(driver,60);
	    	//Clicks on mark critical
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div[2]/div/label"))).click();
	    	//Clicks on confirm change
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
			//Checks if marked critical
			String critical=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div/table/thead/tr/th/strong"))).getText();
			softly.assertThat(critical).as("test data").contains("Critical");
			if(driver.findElement(By.xpath(".//*[@id='irca-rpt']/div/table/thead/tr/th/strong")).isDisplayed())
				System.out.println("Marked critical");
			//Clicks on mark critical again
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div[2]/div/label"))).click();
	    	//Clicks on confirm change
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
			if(driver.findElement(By.xpath(".//*[@id='irca-rpt']/div/table/thead/tr/th/strong")).isDisplayed()==false)
				System.out.println("Unmarked critical");
	    }
	    
	  public void openCheckRecord(String text184, String text, String paragraph, String get_date, String get_time,String creationDate, String get_dept) throws Exception{
		  
		  WebDriverWait wait1 = new WebDriverWait(driver,30);
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  //Clicks on first newly created record
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();
		  //Checks for Event title data
		  String eve_title =  driver.findElement(By.xpath(".//*[@id='irca-rpt']/div/table/tbody/tr/td[2]")).getText();
		  softly.assertThat(eve_title).as("test data").isEqualTo(text184);
		  //Checks for Date of event data
		  String eve_date =  driver.findElement(By.xpath(".//*[@id='irca-rpt']/div/table/tbody/tr[3]/td[2]")).getText();
		  softly.assertThat(eve_date).as("test data").isEqualTo(get_date);
		  //Checks for Time of event data
		  String eve_time =  driver.findElement(By.xpath(".//*[@id='irca-rpt']/div/table/tbody/tr[3]/td[4]")).getText();
		  softly.assertThat(eve_time).as("test data").isEqualTo(get_time);
		  //Checks for Location of event data
		  String eve_loc =  driver.findElement(By.xpath(".//*[@id='irca-rpt']/div/table/tbody/tr[4]/td[2]")).getText();
		  softly.assertThat(eve_loc).as("test data").isEqualTo(text);
		  //Checks for Department data
		  String eve_dept =  driver.findElement(By.xpath(".//*[@id='irca-rpt']/div/table/tbody/tr[5]/td[2]")).getText();
		  softly.assertThat(eve_dept).as("test data").isEqualTo(get_dept);
		  //Checks for Investigators data
		  String eve_inv =  driver.findElement(By.xpath(".//*[@id='irca-rpt']/div/table/tbody/tr[6]/td[2]")).getText();
		  softly.assertThat(eve_inv).as("test data").isEqualTo(paragraph);
		  //Checks for Report creation date data
		  String creation_date =  driver.findElement(By.xpath(".//*[@id='irca-rpt']/div/table/tbody/tr[8]/td[2]")).getText();
		  softly.assertThat(creation_date).as("test data").isEqualTo(creationDate);
		  //Checks for Problem statement data
		  String eve_prob =  driver.findElement(By.xpath(".//*[@id='irca-rpt']/div[2]/table/tbody/tr[2]/td[2]")).getText();
		  softly.assertThat(eve_prob).as("test data").isEqualTo(paragraph);
		  //Checks for Timeline of event data
		  String eve_timeline =  driver.findElement(By.xpath(".//*[@id='irca-rpt']/div[2]/table/tbody/tr[3]/td[2]")).getText();
		  softly.assertThat(eve_timeline).as("test data").isEqualTo(paragraph);
		  //Checks for Background information data
		  String eve_back =  driver.findElement(By.xpath(".//*[@id='irca-rpt']/div[2]/table/tbody/tr[4]/td[2]")).getText();
		  softly.assertThat(eve_back).as("test data").isEqualTo(paragraph);
		  jse.executeScript("scroll(0, 3300)");
		  int n =3500;
		  //Checks the 5 images if appearing
		  for (int j=0; j<5; j++)
		  {				  
			  //Click on Supporting file details
			  Thread.sleep(500);
			  String id = "pii-hirca-h-event-report-filecollapsible-"+j;
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))).click();
			  try{
				  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
				  wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
				  Thread.sleep(3000);
				 }catch (org.openqa.selenium.TimeoutException e)
				  {
					  
				  }
			  n=n+1200;
			  String scroll ="scroll(0,"+n+")";
			  jse.executeScript(scroll);
			  String img = "pii-hirca-h-event-report-file-img-"+j;
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id(img)));
			  if(driver.findElement(By.id(img)).isDisplayed())
			  {
				  System.out.println("Image "+ (j+1) + " is displayed");	
				  
			  }
		  }
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0, 0)");
	  }
	
	@Test
	  public void SanityTest() throws Exception{
		  try{ 
			  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  Login();
		  System.out.println("Title after login: "+driver.getTitle());
		  //Waits for the page to load
	      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	      Thread.sleep(2000);
	      //Switches to the iframe
		  driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		  
		  Thread.sleep(4000);
		  WebDriverWait wait = new WebDriverWait(driver,40);
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
		  
		  Thread.sleep(4000);
		  
		
		  //Clicks on HiRCA
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-hirca"))).click();
		  Thread.sleep(2000);
		  
		  //Checks if the textboxes have the correct titles
		  String ev_title = driver.findElement(By.id("pii-irca-event-title-label")).getText();
		  System.out.println(ev_title);
		  softly.assertThat(ev_title).as("test data").isEqualTo("Event title:");
		  String ev_id = driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[2]/label")).getText();
		  System.out.println(ev_id);
		  softly.assertThat(ev_id).as("test data").isEqualTo("Event ID:");
		  String loc=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[3]/label")).getText();
		  System.out.println(loc);
		  softly.assertThat(loc).as("test data").isEqualTo("Location of event:");
		  String dept=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[4]/fieldset/div/legend")).getText();
		  System.out.println(dept);
		  softly.assertThat(dept).as("test data").isEqualTo("Department:");
		  String date=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[5]/label")).getText();
		  System.out.println(date);
		  softly.assertThat(date).as("test data").isEqualTo("Date of event:");
		  String time=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[6]/label")).getText();
		  System.out.println(time);
		  softly.assertThat(time).as("test data").isEqualTo("Time of event:");
		  String prob=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[7]/label")).getText();
		  System.out.println(prob);
		  softly.assertThat(prob).as("test data").isEqualTo("Problem statement:");
		  String exec=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[8]/label")).getText();
		  System.out.println(exec);
		  softly.assertThat(exec).as("test data").isEqualTo("Executive summary:");
		  String timeline=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[9]/label")).getText();
		  System.out.println(timeline);
		  softly.assertThat(timeline).as("test data").isEqualTo("Timeline of event:");
		  String back=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[10]/label")).getText();
		  System.out.println(back);
		  softly.assertThat(back).as("test data").isEqualTo("Background information:");
		  String supp1 = driver.findElement(By.id("pii-irca-event-file-fieldcontain-label-0")).getText();
		  System.out.println(supp1);
		  softly.assertThat(supp1).as("test data").isEqualTo("Supporting file (1):");
		  String inve=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[13]/label")).getText();
		  System.out.println(inve);
		  softly.assertThat(inve).as("test data").isEqualTo("Investigators:");
		  String repo=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[14]/label")).getText();
		  System.out.println(repo);
		  softly.assertThat(repo).as("test data").isEqualTo("Report creation date:");
		  //Checks if header appears
		  WebElement header = driver.findElement(By.tagName("header"));
		  if(header.isDisplayed())
		  {
			 System.out.println("Header is displayed");
			 if (header.findElement(By.xpath(".//*[@class='pii-logo-div']/img")).isDisplayed())
				 System.out.println("Logo is displayed");
			 if(header.findElement(By.id("links")).isDisplayed())
			 {
				 System.out.println("Links are displayed");
				 if(header.findElement(By.xpath(".//*[@id='links']/a")).isDisplayed())
					 System.out.println("Knowledge link displayed");
				 if(header.findElement(By.xpath(".//*[@id='links']/a[2]")).isDisplayed())
					 System.out.println("Analysis link displayed");
				 if(header.findElement(By.xpath(".//*[@id='links']/a[3]")).isDisplayed())
					 System.out.println("Learning link displayed");
				 if(header.findElement(By.xpath(".//*[@id='links']/a[4]")).isDisplayed())
					 System.out.println("ErrorFree Bank link displayed");
			 }
		 
		  }
		  //Checks if header appears
		  WebElement footer = driver.findElement(By.tagName("footer")); 
		  if(footer.isDisplayed())
		  {
			 System.out.println("Footer is displayed");
			 if (footer.findElement(By.xpath(".//*[@class='ui-grid-c']/a")).isDisplayed())
				 System.out.println("About link is displayed");
			 if(footer.findElement(By.xpath(".//*[@class='ui-grid-c']/a[2]")).isDisplayed())
				 System.out.println("Contact link displayed");
			 if(footer.findElement(By.xpath(".//*[@class='ui-grid-c']/a[3]")).isDisplayed())
				 System.out.println("Privacy link displayed");
			 if(footer.findElement(By.xpath(".//*[@class='ui-grid-c']/a[4]")).isDisplayed())
				 System.out.println("Help link displayed");
			 		 
		  }
		  //Clicks on save to get error message
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))).click();
		  WebDriverWait wait1 = new WebDriverWait(driver,30);
		  String error_save = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).getText();
		  if(error_save.equals("Please fix all errors mentioned in red."))
		  {
			  //Clicks on ok
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
			  //Checks for the error message on each mandatory check box
			  if(driver.findElement(By.id("pii-irca-event-title-error")).isDisplayed())
			  {
				  String error_title = driver.findElement(By.id("pii-irca-event-title-error")).getText();
				  softly.assertThat(error_title).as("test data").isEqualTo("Event title is required");
				  WebElement textbox1=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div"));
				  WebElement error_title_dotted = textbox1.findElement(By.cssSelector(".ui-input-text.ui-body-inherit.ui-corner-all.ui-shadow-inset.ui-input-has-clear.error"));
				  if (error_title_dotted.isDisplayed())
					  System.out.println("Error dotted line displayed on event title textbox");
			  }
			  if(driver.findElement(By.id("pii-irca-event-location-error")).isDisplayed())
			  {
				  String error_location = driver.findElement(By.id("pii-irca-event-location-error")).getText();
				  softly.assertThat(error_location).as("test data").isEqualTo("Location of event is required");
				  WebElement textbox2=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[3]"));
				  WebElement error_location_dotted = textbox2.findElement(By.cssSelector(".ui-input-text.ui-body-inherit.ui-corner-all.ui-shadow-inset.ui-input-has-clear.error"));
				  if (error_location_dotted.isDisplayed())
					  System.out.println("Error dotted line displayed on location of event textbox");
			  }
			  if(driver.findElement(By.id("pii-irca-event-department-error")).isDisplayed())
			  {
				  String error_dept = driver.findElement(By.id("pii-irca-event-department-error")).getText();
				  softly.assertThat(error_dept).as("test data").isEqualTo("Department is required");
				  WebElement textbox3=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[4]"));
				  WebElement error_dept_dotted = textbox3.findElement(By.cssSelector(".ui-btn.ui-icon-carat-d.ui-btn-icon-right.ui-corner-all.ui-shadow.ui-first-child.ui-last-child.error"));
				  if (error_dept_dotted.isDisplayed())
					  System.out.println("Error dotted line displayed on Department textbox");
			  }
			  if(driver.findElement(By.id("pii-irca-event-pbstatement-error")).isDisplayed())
			  {
				  String error_prob = driver.findElement(By.id("pii-irca-event-pbstatement-error")).getText();
				  softly.assertThat(error_prob).as("test data").isEqualTo("Problem statement is required");
				  WebElement textbox4=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[7]"));
				  WebElement error_prob_dotted = textbox4.findElement(By.cssSelector(".ui-input-text.ui-shadow-inset.ui-body-inherit.ui-corner-all.ui-textinput-autogrow.error"));
				  if (error_prob_dotted.isDisplayed())
					  System.out.println("Error dotted line displayed on problem statement textbox");
			  }
			  if(driver.findElement(By.id("pii-irca-event-events-error")).isDisplayed())
			  {
				  String error_timeline = driver.findElement(By.id("pii-irca-event-events-error")).getText();
				  softly.assertThat(error_timeline).as("test data").isEqualTo("Timeline of event is required");
				  WebElement textbox5=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[9]"));
				  WebElement error_timeline_dotted = textbox5.findElement(By.cssSelector(".ui-input-text.ui-shadow-inset.ui-body-inherit.ui-corner-all.ui-textinput-autogrow.error"));
				  if (error_timeline_dotted.isDisplayed())
					  System.out.println("Error dotted line displayed on timeline of event textbox");
			  }
			  if(driver.findElement(By.id("pii-irca-event-bginfos-error")).isDisplayed())
			  {
				  String error_back = driver.findElement(By.id("pii-irca-event-bginfos-error")).getText();
				  softly.assertThat(error_back).as("test data").isEqualTo("Background information is required");
				  WebElement textbox6=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[10]"));
				  WebElement error_back_dotted = textbox6.findElement(By.cssSelector(".ui-input-text.ui-shadow-inset.ui-body-inherit.ui-corner-all.ui-textinput-autogrow.error"));
				  if (error_back_dotted.isDisplayed())
					  System.out.println("Error dotted line displayed on background information textbox");
			  }
			  
			  jse.executeScript("scroll(0, 250)");
			  if(driver.findElement(By.id("pii-irca-event-investigators-error")).isDisplayed())
			  {
				  String error_invest = driver.findElement(By.id("pii-irca-event-investigators-error")).getText();
				  softly.assertThat(error_invest).as("test data").isEqualTo("Investigators is required");
				  WebElement textbox7=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[13]"));
				  WebElement error_invest_dotted = textbox7.findElement(By.cssSelector(".ui-input-text.ui-shadow-inset.ui-body-inherit.ui-corner-all.ui-textinput-autogrow.error"));
				  if (error_invest_dotted.isDisplayed())
					  System.out.println("Error dotted line displayed on investigators textbox");
			  }
		  }
		  
		  //Checks if after entering text if the error message and dotted line disappears
		  String paragraph = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus eu lorem sapien. Donec molestie ligula nec diam mollis scelerisque ac et orci. Phasellus facilisis urna quis nibh faucibus, quis vestibulum nunc fringilla. Sed efficitur elit a nulla ultrices, at cursus ligula pharetra. Ut sollicitudin libero in nunc iaculis, ac mollis eros finibus. Nam iaculis pretium augue, vel tristique ligula sodales id. Maecenas sit amet tellus lobortis, pellentesque urna non, rutrum ante. Etiam enim quam, porta vel iaculis tincidunt, feugiat in nisl."
				  +"\n"+"\n"
				  +"Donec gravida ante congue orci dictum, ut pretium velit elementum. Aliquam mattis sapien ut felis consequat tempor. Integer eget justo libero. Etiam hendrerit massa odio, non scelerisque leo fringilla nec. Curabitur ac magna dolor. Suspendisse mi nisi, dictum non dolor sit amet, venenatis tempor ipsum. Praesent maximus mauris tortor, ut hendrerit est pulvinar vitae. Aenean vel justo dignissim, scelerisque urna ultricies, hendrerit magna. Etiam elementum accumsan turpis ut efficitur. Aliquam luctus, nulla eget faucibus fermentum, tortor eros dignissim ante, vitae fermentum tellus ligula consectetur ligula. Etiam sagittis nisl mi, sit amet scelerisque eros venenatis sit amet. Fusce facilisis nisl nunc, eu euismod dui tristique nec. Donec lorem enim, sodales eu sem in, feugiat varius nunc. Phasellus cursus laoreet sapien, ac posuere tortor."
				  ;
		  //Investigators
		  driver.findElement(By.id("pii-irca-event-investigators")).sendKeys(paragraph);
		  if(driver.findElement(By.id("pii-irca-event-investigators-error")).isDisplayed()==false)
		  {
			  String noerror_invest = driver.findElement(By.id("pii-irca-event-investigators-error")).getText();
			  softly.assertThat(noerror_invest).as("test data").isEqualTo("");
			  WebElement ttextbox7=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[13]"));
			  WebElement noerror_invest_dotted = ttextbox7.findElement(By.cssSelector(".ui-input-text.ui-shadow-inset.ui-body-inherit.ui-corner-all.ui-textinput-autogrow"));
			  Thread.sleep(500);
			  if (noerror_invest_dotted.isDisplayed())
				  System.out.println("Error dotted line disappeared on investigators textbox");
		  }
		  //Clears some text
		  for(int i =0; i<30; i++)
		  {
			  driver.findElement(By.id("pii-irca-event-investigators")).sendKeys(Keys.BACK_SPACE); 
		  }
		  //Clears all text
		  driver.findElement(By.id("pii-irca-event-investigators")).clear();
		  //Re enters text
		  driver.findElement(By.id("pii-irca-event-investigators")).sendKeys(paragraph);
		  
		  //Background info
		  driver.findElement(By.id("pii-irca-event-bginfos")).sendKeys(paragraph);
		  if(driver.findElement(By.id("pii-irca-event-bginfos-error")).isDisplayed()==false)
		  {
			  String noerror_back = driver.findElement(By.id("pii-irca-event-bginfos-error")).getText();
			  softly.assertThat(noerror_back).as("test data").isEqualTo("");
			  WebElement ttextbox6=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[10]"));
			  WebElement noerror_back_dotted = ttextbox6.findElement(By.cssSelector(".ui-input-text.ui-shadow-inset.ui-body-inherit.ui-corner-all.ui-textinput-autogrow"));
			  Thread.sleep(500);
			  if (noerror_back_dotted.isDisplayed())
				  System.out.println("Error dotted line disappeared on background information textbox");
		  }
		  //Clears some text
		  for(int i =0; i<30; i++)
		  {
			  driver.findElement(By.id("pii-irca-event-bginfos")).sendKeys(Keys.BACK_SPACE); 
		  }
		  //Clears all text
		  driver.findElement(By.id("pii-irca-event-bginfos")).clear();
		  //Re enters text
		  driver.findElement(By.id("pii-irca-event-bginfos")).sendKeys(paragraph);
		  
		  //Timeline of event
		  driver.findElement(By.id("pii-irca-event-events")).sendKeys(paragraph);
		  if(driver.findElement(By.id("pii-irca-event-events-error")).isDisplayed()==false)
		  {
			  String noerror_timeline = driver.findElement(By.id("pii-irca-event-events-error")).getText();
			  softly.assertThat(noerror_timeline).as("test data").isEqualTo("");
			  WebElement ttextbox5=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[9]"));
			  WebElement noerror_timeline_dotted = ttextbox5.findElement(By.cssSelector(".ui-input-text.ui-shadow-inset.ui-body-inherit.ui-corner-all.ui-textinput-autogrow"));
			  Thread.sleep(500);
			  if (noerror_timeline_dotted.isDisplayed())
				  System.out.println("Error dotted line disappeared on timeline of event textbox");
		  }
		  //Clears some text
		  for(int i =0; i<30; i++)
		  {
			  driver.findElement(By.id("pii-irca-event-events")).sendKeys(Keys.BACK_SPACE); 
		  }
		  //Clears all text
		  driver.findElement(By.id("pii-irca-event-events")).clear();
		  //Re enters text
		  driver.findElement(By.id("pii-irca-event-events")).sendKeys(paragraph);
		  
		  //Problem Statement
		  driver.findElement(By.id("pii-irca-event-pbstatement")).sendKeys(paragraph);
		  if(driver.findElement(By.id("pii-irca-event-pbstatement-error")).isDisplayed()==false)
		  {
			  String noerror_prob = driver.findElement(By.id("pii-irca-event-pbstatement-error")).getText();
			  softly.assertThat(noerror_prob).as("test data").isEqualTo("");
			  WebElement ttextbox4=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[7]"));
			  WebElement noerror_prob_dotted = ttextbox4.findElement(By.cssSelector(".ui-input-text.ui-shadow-inset.ui-body-inherit.ui-corner-all.ui-textinput-autogrow"));
			  if (noerror_prob_dotted.isDisplayed())
				  System.out.println("Error dotted line disappeared on problem statement textbox");
		  }
		  //Clears some text
		  for(int i =0; i<30; i++)
		  {
			  driver.findElement(By.id("pii-irca-event-pbstatement")).sendKeys(Keys.BACK_SPACE); 
		  }
		  //Clears all text
		  driver.findElement(By.id("pii-irca-event-pbstatement")).clear();
		  //Re enters text
		  driver.findElement(By.id("pii-irca-event-pbstatement")).sendKeys(paragraph);
		  
		  jse.executeScript("scroll(0, 0)");
		  
		  //Department
		  WebElement dropdown = driver.findElement(By.id("pii-irca-event-department"));
		  Select s = new Select (dropdown);
		  s.selectByVisibleText("Construction");
		  if(driver.findElement(By.id("pii-irca-event-department-error")).isDisplayed()==false)
		  {
			  String noerror_dept = driver.findElement(By.id("pii-irca-event-department-error")).getText();
			  softly.assertThat(noerror_dept).as("test data").isEqualTo("");
			  WebElement ttextbox3=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[4]"));
			  WebElement noerror_dept_dotted = ttextbox3.findElement(By.cssSelector(".ui-btn.ui-icon-carat-d.ui-btn-icon-right.ui-corner-all.ui-shadow.ui-first-child.ui-last-child"));
			  if (noerror_dept_dotted.isDisplayed())
				  System.out.println("Error dotted line disappeared on Department textbox");
		  }
		  
		  //Location of event
		  String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris volutpat tincidunt dui.";
		  driver.findElement(By.id("pii-irca-event-location")).sendKeys(text);
		  if(driver.findElement(By.id("pii-irca-event-location-error")).isDisplayed()==false)
		  {
			  String noerror_location = driver.findElement(By.id("pii-irca-event-location-error")).getText();
			  softly.assertThat(noerror_location).as("test data").isEqualTo("");
			  WebElement ttextbox2=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[3]"));
			  WebElement noerror_location_dotted = ttextbox2.findElement(By.cssSelector(".ui-input-text.ui-body-inherit.ui-corner-all.ui-shadow-inset.ui-input-has-clear"));
			  if (noerror_location_dotted.isDisplayed())
				  System.out.println("Error dotted line disappeared on location of event textbox");
		  }
		  //Clears some text
		  for(int i =0; i<20; i++)
		  {
			  driver.findElement(By.id("pii-irca-event-location")).sendKeys(Keys.BACK_SPACE); 
		  }
		  //Clears by cross mark
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[3]/div/a"))).click();
		  //Re enters text
		  driver.findElement(By.id("pii-irca-event-location")).sendKeys(text);
		  //Clears all text
		  driver.findElement(By.id("pii-irca-event-location")).clear();
		  //Re enters text
		  driver.findElement(By.id("pii-irca-event-location")).sendKeys(text);
		  
		  //Event title
		  driver.findElement(By.id("pii-irca-event-title")).sendKeys(text);
		  if(driver.findElement(By.id("pii-irca-event-title-error")).isDisplayed()==false)
		  {
			  String noerror_title = driver.findElement(By.id("pii-irca-event-title-error")).getText();
			  softly.assertThat(noerror_title).as("test data").isEqualTo("");
			  WebElement ttextbox1=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div"));
			  WebElement noerror_title_dotted = ttextbox1.findElement(By.cssSelector(".ui-input-text.ui-body-inherit.ui-corner-all.ui-shadow-inset.ui-input-has-clear"));
			  if (noerror_title_dotted.isDisplayed())
				  System.out.println("Error dotted line disappeared on event title textbox");
		  }
		  //Clears some text
		  for(int i =0; i<20; i++)
		  {
			  driver.findElement(By.id("pii-irca-event-title")).sendKeys(Keys.BACK_SPACE); 
		  }
		  //Clears by cross mark
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div/div/a"))).click();
		  //Re enters text
		  driver.findElement(By.id("pii-irca-event-title")).sendKeys(text);
		  //Clears all text
		  driver.findElement(By.id("pii-irca-event-title")).clear();
		  //Re enters text
		  driver.findElement(By.id("pii-irca-event-title")).sendKeys(text);
		  			
		  //Checks event title text box limit
		  driver.findElement(By.id("pii-irca-event-title")).clear();
		  String text184 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris volutpat tincidunt dui. Phasellus quis orci risus. Vivamus justo urna, porttitor aliquam convallis id, varius eget metus";
		  driver.findElement(By.id("pii-irca-event-title")).sendKeys(text184);
		  String limit_text = driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div/span")).getText(); 
		  limit_text=limit_text.substring(5,8);
		  int limit = Integer.parseInt(limit_text);
		  System.out.println(limit_text+ " "+limit);
		  for(int i=185; i<=limit+1;i++)
			  driver.findElement(By.id("pii-irca-event-title")).sendKeys(".");
		  
		  if(driver.findElement(By.id("pii-irca-event-title-error")).isDisplayed())
		  {
			  String error_title = driver.findElement(By.id("pii-irca-event-title-error")).getText();
			  softly.assertThat(error_title).as("test data").isEqualTo("Event title: is too long, 1 bytes too long.");
			  WebElement textbox1=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div"));
			  WebElement error_title_dotted = textbox1.findElement(By.cssSelector(".ui-input-text.ui-body-inherit.ui-corner-all.ui-shadow-inset.ui-input-has-clear.error"));
			  if (error_title_dotted.isDisplayed())
				  System.out.println("Error dotted line displayed on event title textbox");
		  }
		  driver.findElement(By.id("pii-irca-event-title")).sendKeys(Keys.BACK_SPACE);
		  if(driver.findElement(By.id("pii-irca-event-title-error")).isDisplayed()==false)
		  {
			  String noerror_title = driver.findElement(By.id("pii-irca-event-title-error")).getText();
			  softly.assertThat(noerror_title).as("test data").isEqualTo("");
			  WebElement ttextbox1=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div"));
			  WebElement noerror_title_dotted = ttextbox1.findElement(By.cssSelector(".ui-input-text.ui-body-inherit.ui-corner-all.ui-shadow-inset.ui-input-has-clear"));
			  if (noerror_title_dotted.isDisplayed())
				  System.out.println("Error dotted line disappeared on event title textbox");
		  }
		  //Clears and reenters event title
		  driver.findElement(By.id("pii-irca-event-title")).clear();
		  Thread.sleep(1000);
		  driver.findElement(By.id("pii-irca-event-title")).sendKeys(text184);
		  
		  //Check the date picker
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[5]/div/a"))).click();
		  //Close the popup
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/a"))).click();
		  Thread.sleep(2000);
		  //Click on date picker
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[5]/div/a"))).click();
		  //Check if the title is correct
		  String date_title=driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/div/h1")).getText();
		  System.out.println(date_title);
		  softly.assertThat(date_title).as("test data").isEqualTo("Date of event:");
		  //Click on + sign for next month
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div/div[2]/a"))).click();
		  //Click on - sign for previous month
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div/div/a"))).click();
		  //Select date as 1st
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div[2]/div[2]/div"))).click();
		  
		  //Check the time picker
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[6]/div/a"))).click();
		  //Close the popup
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/a"))).click();
		  Thread.sleep(2000);
		  //Click on time picker
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[6]/div/a"))).click();
		  //Check if the title is correct
		  String time_title=driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/div/h1")).getText();
		  System.out.println(time_title);
		  softly.assertThat(time_title).as("test data").isEqualTo("Time of event:");
		  //Click on + second
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div/div[2]/div"))).click();
		  //Click on - second
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div/div[2]/div[3]"))).click();
		  //Click on + minute
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div/div/div"))).click();
		  //Click on - minute
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div/div/div[3]"))).click();
		  Thread.sleep(2000);
		  //Check the error on minute
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div/div/div[2]/input"))).sendKeys("666");
		  //Check if the error is correct
		  String time_title_error_min=driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/div/h1/div")).getText();
		  System.out.println(time_title_error_min);
		  softly.assertThat(time_title_error_min).as("test data").isEqualTo("(warning: 0>=hours<=23)");
		  //Enter minute
		  driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div/div/div[2]/input")).sendKeys(Keys.CONTROL,"a");
		  driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div/div/div[2]/input")).sendKeys(Keys.DELETE);
		  Thread.sleep(1000);
		  driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div/div/div[2]/input")).sendKeys("01");
		  Thread.sleep(2000);
		  //Check the error on second
		  driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div/div[2]/div[2]/input")).sendKeys("666");
		  //Check if the error is correct
		  String time_title_error_sec=driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/div/h1/div")).getText();
		  System.out.println(time_title_error_sec);
		  softly.assertThat(time_title_error_sec).as("test data").isEqualTo("(warning: 0>=minutes<=59)");
		  //Enter second
		  Thread.sleep(1000);
		  driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div/div[2]/div[2]/input")).sendKeys(Keys.CONTROL,"a");
		  driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div/div[2]/div[2]/input")).sendKeys(Keys.DELETE);
		  Thread.sleep(1000);
		  driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div/div[2]/div[2]/input")).sendKeys("13");
		  Thread.sleep(2000);
		  //Click on set time
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div[2]/div/a"))).click();
		  
		  jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		  Thread.sleep(2000);
		  //Check if it allows for uploading more than one file
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewfile-button"))).click();
		  Thread.sleep(1000);
		  String error_attach=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).getText();
		  softly.assertThat(error_attach).as("test data").isEqualTo("Please use existing empty supporting file form above");
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		  int n=450;
		  for (int j=0; j<5; j++)
		  {
			  
			  //Click on Supporting file details
			  Thread.sleep(500);
			  String id = "pii-irca-event-filecollapsible-"+j;
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))).click();
			  //Uploads file
			  String file = "pii-irca-event-file-"+j;
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(file))).click();
			  WebElement element =  driver.findElement(By.id(file));
			  Actions act = new Actions(driver);
			  act.doubleClick(element).build().perform();
			  Thread.sleep(6000);
			  try {
					  Process p = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaChrysanthemumJOBOBS.exe");
					  p.waitFor();
				  }catch (UnhandledAlertException f){		
					  System.out.println("Unexpecetd alert for picture 2");
					  driver.switchTo().alert().accept();
				  }catch (NoAlertPresentException f){
					  System.out.println ("No unexpected alert for picture 2");
					  }
			  Thread.sleep(6000);
			  String img = "pii-irca-event-file-img-"+j;
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(img)));
			  if(driver.findElement(By.id(img)).isDisplayed())
			  {
				  //delete file
				  String del = "pii-irca-event-file-remove-"+j;
				  Thread.sleep(1000);
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(del))).click(); 
				  
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).click();
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
				  if(j!=0)
				  {
					  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewfile-button"))).click();
					  Thread.sleep(1000);
					  n=n+80;
					  String scroll = "scroll(0,"+n+")";
					  jse.executeScript(scroll);
				  }
				  //Click on Supporting file details
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))).click();
				  //Fill title and description
				  String title_id="pii-irca-event-file-title-"+j;
				  driver.findElement(By.id(title_id)).sendKeys("Title0"+j);
				  String desc = "pii-irca-event-file-description-"+j;
				  driver.findElement(By.id(desc)).sendKeys("Description0"+j);
				  //re-upload file
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(file))).click();
				  WebElement element1 =  driver.findElement(By.id(file));
				  Actions act1 = new Actions(driver);
				  act1.doubleClick(element1).build().perform();
				  Thread.sleep(6000);
				   try {
						  Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaChrysanthemumJOBOBS.exe");
						  q.waitFor();
						  }catch (UnhandledAlertException f){	
							  System.out.println("Unexpecetd alert for picture 2");
							  driver.switchTo().alert().accept();
							  
					  	  }catch (NoAlertPresentException f){
					  		  System.out.println ("No unexpected alert for picture 2");
					  		  }
				  Thread.sleep(6000);
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(img)));
				  
				  if(driver.findElement(By.id(img)).isDisplayed())
				  {
					//rotate file
					  String rotate= "pii-irca-event-file-rotate-"+j;
					  for(int r=0;r<=j;r++)
						  {
							  Thread.sleep(2000);
							  if(j==4)
								  jse.executeScript("scroll(0, 1000)");
							  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(rotate))).click();
						  }
				  }
				  
				  Thread.sleep(3000);
				  if(driver.findElement(By.id(img)).isDisplayed())
				  {
					  jse.executeScript("scroll(0, 1600)");
					  //Click on attach another file
					  Thread.sleep(2000);
					 WebElement add= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewfile-button")));
					 //jse.executeScript("arguments[0].scrollIntoView(true);", add);
					 add.click();
				  }
				  
			  }
		  }
		  Thread.sleep(1000);
		  //Checks if all images have been uploaded
		  //n=2000;
		  for (int j=4; j>=0; j--)
		  {
			  
			  //Click on Supporting file details
			  Thread.sleep(500);
			  String id = "pii-irca-event-filecollapsible-"+j;
			  if(j==3)
			  {
				  jse.executeScript("scroll(0, 1000)");
			  }
			  if(j!=4)
			  {
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))).click();
			  }
			  
			  String img = "pii-irca-event-file-img-"+j;
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(img)));
			  if(driver.findElement(By.id(img)).isDisplayed())
			  {
				  System.out.println("Picture uploaded "+(j+1));
			  }
			  
		  }
		  //Gets value of date
		  String get_date = driver.findElement(By.id("pii-irca-event-date")).getAttribute("value");
		  System.out.println(get_date);
		  //Gets value of time
		  String get_time = driver.findElement(By.id("pii-irca-event-time")).getAttribute("value");
		  System.out.println(get_time);
		  //Gets value of department
		  String get_dept = driver.findElement(By.id("pii-irca-event-department")).getAttribute("value");
		  System.out.println(get_dept);
		  jse.executeScript("scroll(0,0)");
		  //Clicks on Save
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))).click();
		  //Clicks on Save report
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).click();
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-success")));
		  Thread.sleep(500);
		  try{
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
		  wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  }catch (org.openqa.selenium.TimeoutException e)
		  {
			  
		  }
		  //Clicks on Save
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))).click();
		  //Clicks on Save report
		  while(true)
		  {
			  try{
				  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).click();
				  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
			  }catch (NoSuchElementException e)
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
			  
		  }
		  
		  //wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-success")));
		  Thread.sleep(1000);
		  //All changed supporting files saved successfully
		  //Create an expected name
		  String creationDate = driver.findElement(By.id("pii-irca-event-repdatetime")).getAttribute("value");
		  String name = creationDate + "_"+username+"_"+ text184 ;
		  System.out.println(name);
		  //Clicks on Saved activities
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-btn-savedactivities"))).click();
		  Thread.sleep(2000);
		  //Clicks on side panel
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-irca"))).click();
		  Thread.sleep(2000);
		  //Gets newly created record name
		  WebElement record = driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"));
		  String recordName = record.getText();
		  if (record.isDisplayed())
		  {
			  System.out.println("Record found: "+ recordName);
		  }
		  else
			  System.out.println ("Record not found.");
		  //Checks if expected name and actual name is correct
		  softly.assertThat(recordName).as("test data").isEqualTo(name);
		  //Opens new record and checks if entered data is same after being saved in report
		  openCheckRecord(text184,text,paragraph,get_date,get_time,creationDate,get_dept);
		  //Opens record
		  openReport();
		  //Downloads record
		  downloadRecord();
		  //Shares report
		  shareReport();
		  //Mark critical
		  markCritical();
		  //Deletes the newly created record
		  deleteNewRecord(recordName);
		  while(true)
		  {
			 Thread.sleep(1000);
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
			 
		  }
		  
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-signout-button"))).click();
		  
		  afterTest();
		  
		  }catch (TimeoutException e)
		  {
			  driver.manage().window().maximize();
			  driver.quit();
		  }
	}
	public void afterTest(){
		driver.manage().window().maximize();
		//Browser closes
		driver.quit();
		softly.assertAll();
	}

}
