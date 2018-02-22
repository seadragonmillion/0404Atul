import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Base64;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;

import org.assertj.core.api.SoftAssertions;
import org.junit.Rule;
import org.junit.rules.Timeout;

public class SanityChromeTest {

	private WebDriver driver;
	private String username ="ritica";
	private String password = "S2FsZTQ2MTkxODAyQA==";
	private String company_id="aatestqaa";
	private String chrome_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\chromedriver.exe";
	private String url = "https://kaleasia.error-free.com/";
	private int login =0;
	SoftAssertions softly = new SoftAssertions();

	@SuppressWarnings("deprecation")
	@Rule
	  public Timeout globalTimeout= new Timeout(900000);
	
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Performing sanity test on create Company/Group/User in Chrome");
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
		
		
		public void deleteUser() throws Exception{
		  
		  WebDriverWait wait = new WebDriverWait(driver,20);
		  //Clicks on Edit user
		  driver.findElement(By.id("pii-admin-user-edit")).click();
		  Thread.sleep(4000);
		  //Searches for newly created user
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-user-list']/form/div/input"))).sendKeys(company_id);
		  driver.findElement(By.xpath(".//*[@id='pii-admin-user-list']/form/div/input")).sendKeys(Keys.ENTER);
		  Thread.sleep(2000);
		  //Selects the newly created user
		  WebElement select = driver.findElement(By.id("pii-admin-user-list"));
		  WebElement option = select.findElement(By.cssSelector(".ui-li-static.ui-body-inherit.ui-first-child.ui-last-child"));
		  option.click();
		  //Clicks on delete
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-button-delete"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-title"))).click();
		  //Clicks on delete user
		  Thread.sleep(2000);
		  driver.findElement(By.id("pii-admin-user-dialog-confirmed")).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  System.out.println("User deleted");
	}
	
	public void deleteGroup() throws Exception{
		  
		  WebDriverWait wait = new WebDriverWait(driver,20);
		  //Clicks on Edit group
		  driver.findElement(By.id("pii-admin-group-edit")).click();
		  Thread.sleep(4000);
		  //Searches for newly created group
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-group-list']/form/div/input"))).clear();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-group-list']/form/div/input"))).sendKeys(company_id);
		  driver.findElement(By.xpath(".//*[@id='pii-admin-group-list']/form/div/input")).sendKeys(Keys.ENTER);
		  //Selects the newly created group
		  WebElement select = driver.findElement(By.id("pii-admin-group-list"));
		  WebElement option = select.findElement(By.cssSelector(".ui-li-static.ui-body-inherit.ui-first-child.ui-last-child"));
		  option.click();
		  //Clicks on delete
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-group-button-delete"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-group-dialog-title"))).click();
		  //Clicks on delete group
		  driver.findElement(By.id("pii-admin-group-dialog-confirmed")).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  System.out.println("Group deleted");
	}
	
	public void deleteCompany() throws Exception{
		  
		  WebDriverWait wait = new WebDriverWait(driver,20);
		  //Clicks on Companies
		  driver.findElement(By.id("pii-admin-customers-button")).click();
		  Thread.sleep(3000);
		  //Enters company id in ID field 
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input"))).clear();
		  driver.findElement(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input")).sendKeys(company_id);
		  driver.findElement(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input")).sendKeys(Keys.ENTER);
		  //Clicks on newly created company id
		  driver.findElement(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div[2]/table/tbody/tr/td")).click();
		  Thread.sleep(4000);
		  //Clicks on delete
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-button-delete"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-dialog-title"))).click();
		  //Clicks on delete company
		  driver.findElement(By.id("pii-admin-cust-dialog-confirmed")).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  System.out.println("Company deleted");
	}
	
	public void LoginDummyUser() throws Exception{
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		//Login button is located and clicked
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-login-button"))).click();
		//Enter Username
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-un"))).sendKeys(company_id);
		//Enter password
		driver.findElement(By.id("pii-pw")).sendKeys(decode(password));
		Thread.sleep(2000);
		String user = driver.findElement(By.id("pii-un")).getAttribute("value");
		String pw = driver.findElement(By.id("pii-pw")).getAttribute("value");
		int c=1;
		login=0;
		if (user.equals(company_id)==true)
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
			}
	   }
	   }
	   if ((user.equals(company_id)==false)||(pw.equals(decode(password))==false))
	   {
		  while(c>0)
			{
			  Thread.sleep(1000);
			  driver.findElement(By.id("pii-un")).clear();
			  driver.findElement(By.id("pii-pw")).clear();
			  //Username text field is located and the username is entered
			  driver.findElement(By.id("pii-un")).sendKeys(company_id);
			  //Password field is located and the password is entered
			  driver.findElement(By.id("pii-pw")).sendKeys(decode(password));
			  Thread.sleep(2000);
			  user = driver.findElement(By.id("pii-un")).getAttribute("value");
			  pw = driver.findElement(By.id("pii-pw")).getAttribute("value");
			  if (user.equals(company_id)==true)
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
	
	public void editGroupCheckAccess() throws Exception{
		String SMTP_HOST = "smtp.gmail.com";
	    String EMAIL_ADDRESS = "fakeemailtestqaa@gmail.com";
	    String PASSWORD = "5sepkale";
	    String INBOX_FOLDER = "INBOX";	    
	    Properties props = new Properties();
	    props.load(new FileInputStream(new File( "C:\\Users\\rramakrishnan\\DriversForSelenium\\smtp.properties" )));
	    Session session = Session.getDefaultInstance(props, null);
	    Store store = session.getStore("imaps");
	    store.connect(SMTP_HOST, EMAIL_ADDRESS, PASSWORD);
	    Folder inbox = store.getFolder(INBOX_FOLDER);
	    inbox.open(Folder.READ_ONLY);
	    int messageCount = inbox.getMessageCount(); 
	    System.out.println("Total Messages:- " + messageCount);
        Flags seen = new Flags(Flags.Flag.SEEN);
        FlagTerm unseenFlagTerm = new FlagTerm(seen, false);
        Message[] messages1 = inbox.search(unseenFlagTerm);
        int messageCount1 = messages1.length;
        while(true)
        {
        	Thread.sleep(2000);
        	if (messageCount1>0)
        		break;
        	messages1 = inbox.getMessages();
        	Thread.sleep(1000);
        	messages1 = inbox.search(unseenFlagTerm);
        	messageCount1 = messages1.length;
        }
        System.out.println("Unread messages: "+messageCount1);
        for (int i = 0; i < messageCount1; i++) {
        	Message message1 = messages1[i];
        	System.out.println(i);
            System.out.println("Mail Subject:- " + messages1[i].getSubject());
            System.out.println("From: " + message1.getFrom());
            System.out.println("Text: " + message1.getContent().toString());
        }
        String emailText=messages1[messageCount1-1].getContent().toString();
        int n=emailText.indexOf("https");
        int e=emailText.indexOf(">click ");
        System.out.println();
        String activate=emailText.substring(n, e-1);
        System.out.println(activate);
        inbox.close(true);
        store.close();
        //Open activate URL in new window
        WebDriver driver2= new ChromeDriver();
        driver2.get(activate);
        Thread.sleep(2000);
        driver2.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver2.quit();
        //Logs out of admin user
        WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-signout-button"))).click();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Switches to main content
		driver.switchTo().defaultContent();
		LoginDummyUser();
		//Waits for the page to load
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(5000);
		//Click on agree terms box
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-license-checkbox-div']/fieldset/div/div/label"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-license-next"))).click();
		//Scroll to end and click on I accept
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0,2000)");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-license-accept"))).click();
		Thread.sleep(2000);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    //Switches to the iframe
	    driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
	    Thread.sleep(2000);
		//Waits for the page to load
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Click on Analysis
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-a"))).click();
	    try{
            if (login==1)
            {
                  WebDriverWait wait2 = new WebDriverWait(driver,20);
                  wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();
            }
          }catch (NoSuchElementException r){
            throw r;
          }
	    //Verifies if all modules with no group access are disabled
	    WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-em")));
	    if(element.getAttribute("class").contains("ui-state-disabled"))
	    	System.out.println("SPV disabled");
	    else softly.fail("SPV enabled");
	    element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-hpi")));
	    if(element.getAttribute("class").contains("ui-state-disabled"))
	    	System.out.println("HPI disabled");
	    else softly.fail("HPI enabled");
	    element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-hirca")));
	    if(element.getAttribute("class").contains("ui-state-disabled"))
	    	System.out.println("HiRCA disabled");
	    else softly.fail("HiRCA enabled");
	    element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-opirca")));
	    if(element.getAttribute("class").contains("ui-state-disabled"))
	    	System.out.println("O&PiRCA disabled");
	    else softly.fail("O&PiRCA enabled");
	    element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-jo")));
	    if(element.getAttribute("class").contains("ui-state-disabled"))
	    	System.out.println("Job Observation disabled");
	    else softly.fail("Job Observation enabled");
	    element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-3pr")));
	    if(element.getAttribute("class").contains("ui-state-disabled"))
	    	System.out.println("3 Pass Review disabled");
	    else softly.fail("3 Pass Review enabled");
	    element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-rv")));
	    if(element.getAttribute("class").contains("ui-state-disabled"))
	    	System.out.println("Remote Verification disabled");
	    else softly.fail("Remote Verification enabled");
	    //Checks if module with access is enabled : EiRCA and ICCA
	    element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-eirca")));
	    if(element.getAttribute("class").contains("ui-state-disabled")==false)
	    	System.out.println("EiRCA enabled");
	    else softly.fail("EiRCA disabled");
	    element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-icca")));
	    if(element.getAttribute("class").contains("ui-state-disabled")==false)
	    	System.out.println("ICCA enabled");
	    else softly.fail("ICCA disabled");
	    //Clicks on EiRCA
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-eirca"))).click();
	    //Goes back to Analysis
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
	    //Clicks on ICCA
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-icca"))).click();
	    //Logs out
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-signout-button"))).click();
		Thread.sleep(3000);
		//Switches to main content
		driver.switchTo().defaultContent();
		//Waits for the page to load
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		login=0;
		Login();
		System.out.println("Title after login: "+driver.getTitle());
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
          }catch (NoSuchElementException t){
                 throw t;
          }
		 Thread.sleep(5000);
		 //Clicks on admin user name on top right corner
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		 //Clicks on admin option
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-admin"))).click();
		 //Clicks on Accounts
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-accounts']/h3/a"))).click();
		//Clicks on Edit group
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-group-edit"))).click();
		Thread.sleep(2000);
		//Searches for newly created group
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-group-list']/form/div/input"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-group-list']/form/div/input"))).sendKeys(company_id);
		driver.findElement(By.xpath(".//*[@id='pii-admin-group-list']/form/div/input")).sendKeys(Keys.ENTER);
		//Selects the newly created group
		WebElement select = driver.findElement(By.id("pii-admin-group-list"));
		WebElement option = select.findElement(By.cssSelector(".ui-li-static.ui-body-inherit.ui-first-child.ui-last-child"));
		option.click();
		//Waits for black loading message to disappear
		  try{
			  Thread.sleep(2000);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException y)
			  {
				  
			  }
		//Clicks on group modules list
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-group-modules-button"))).click();
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.id("pii-admin-group-modules-menu"));
		Thread.sleep(1000);
		//Un-check EiRCA and ICCA
		ele.findElement(By.linkText("Equipment Failure Instant RCA")).click();
		Thread.sleep(1000);
		ele.findElement(By.linkText("Instant Common Cause Analysis")).click();
		Thread.sleep(1000);
		//Check Job Observation and HiRCA
		ele.findElement(By.linkText("Human Error Instant RCA")).click();
		Thread.sleep(1000);
		ele.findElement(By.linkText("Job Observation Analysis")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='pii-admin-group-modules-listbox']/div/a")).click();
		//Clicks on Save
		//Clicks on save
		driver.findElement(By.id("pii-admin-group-button-save")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-group-dialog-title"))).click();
		//Clicks on Save
		driver.findElement(By.id("pii-admin-group-dialog-confirmed")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		Thread.sleep(3000);
		//Logs out
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-signout-button"))).click();
		//Logs in as dummy user
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		LoginDummyUser();
		Thread.sleep(2000);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    //Switches to the iframe
	    driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
	    Thread.sleep(2000);
		//Waits for the page to load
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Click on Analysis
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-a"))).click();
	    try{
            if (login==1)
            {
                  WebDriverWait wait2 = new WebDriverWait(driver,20);
                  wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();
            }
          }catch (NoSuchElementException r){
            throw r;
          }
	    //Verifies if all modules with no group access are disabled
	    element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-em")));
	    if(element.getAttribute("class").contains("ui-state-disabled"))
	    	System.out.println("SPV disabled");
	    else softly.fail("SPV enabled");
	    element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-hpi")));
	    if(element.getAttribute("class").contains("ui-state-disabled"))
	    	System.out.println("HPI disabled");
	    else softly.fail("HPI enabled");
	    element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-eirca")));
	    if(element.getAttribute("class").contains("ui-state-disabled"))
	    	System.out.println("EiRCA disabled");
	    else softly.fail("EiRCA enabled");
	    element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-opirca")));
	    if(element.getAttribute("class").contains("ui-state-disabled"))
	    	System.out.println("O&PiRCA disabled");
	    else softly.fail("O&PiRCA enabled");
	    element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-icca")));
	    if(element.getAttribute("class").contains("ui-state-disabled"))
	    	System.out.println("ICCA disabled");
	    else softly.fail("ICCA enabled");
	    element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-3pr")));
	    if(element.getAttribute("class").contains("ui-state-disabled"))
	    	System.out.println("3 Pass Review disabled");
	    else softly.fail("3 Pass Review enabled");
	    element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-rv")));
	    if(element.getAttribute("class").contains("ui-state-disabled"))
	    	System.out.println("Remote Verification disabled");
	    else softly.fail("Remote Verification enabled");
	    //Checks if module with access is enabled : HiRCA and Job Observation
	    element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-hirca")));
	    if(element.getAttribute("class").contains("ui-state-disabled")==false)
	    	System.out.println("HiRCA enabled");
	    else softly.fail("HiRCA disabled");
	    element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-jo")));
	    if(element.getAttribute("class").contains("ui-state-disabled")==false)
	    	System.out.println("Job Observation enabled");
	    else softly.fail("Job Observation disabled");
	    //Clicks on HiRCA
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-hirca"))).click();
	    //Goes back to Analysis
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
	    //Clicks on Job Observation
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-jo"))).click();
	}

	public void editPassword() throws Exception{
		
		//Mark all messages in inbox as read
		emailMarkRead();
		WebDriverWait wait = new WebDriverWait(driver,20);
	    //Clicks on Account
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-acct"))).click();
		//Changes password
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-password"))).sendKeys("Dummypass@123");
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-password-again"))).sendKeys("Dummypass@123");
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
		Thread.sleep(3000);
		//Login with new password
		//Login button is located and clicked
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-login-button"))).click();
		//Enter Username
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-un"))).sendKeys(company_id);
		//Enter password
		driver.findElement(By.id("pii-pw")).sendKeys("Dummypass@123");
		Thread.sleep(2000);
		driver.findElement(By.id("pii-signin-button")).click();  		
		Thread.sleep(3000);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Switches to the iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		Thread.sleep(5000);
		//Logs out
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-signout-button"))).click();
		Thread.sleep(3000);
		//Switches to main content
		driver.switchTo().defaultContent();
		//Waits for the page to load
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		login=0;
		Login();
		System.out.println("Title after login: "+driver.getTitle());
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
		  }catch (NoSuchElementException t){
		      throw t;
		}
		Thread.sleep(5000);
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-admin"))).click();
		//Clicks on Accounts
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-accounts']/h3/a"))).click();
		//Clicks on Edit user
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-edit"))).click();
		Thread.sleep(2000);
		//Searches for newly created user
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-user-list']/form/div/input"))).sendKeys(company_id);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-user-list']/form/div/input"))).sendKeys(Keys.ENTER);
		//Waits for loading message to disappear
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
		}catch (org.openqa.selenium.TimeoutException e)
		{
						  
		}
		//Selects the newly created user
		WebElement select = driver.findElement(By.id("pii-admin-user-list"));
		WebElement option = select.findElement(By.cssSelector(".ui-li-static.ui-body-inherit.ui-first-child.ui-last-child"));
		option.click();
		//Waits for loading message to disappear
		try{
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
		}catch (org.openqa.selenium.TimeoutException e)
		{
						  
		}
		//Clicks on reset password send email
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-resend-button"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-confirmed"))).click();
		//Waits for loading message to disappear
		try{
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
		}catch (org.openqa.selenium.TimeoutException e)
		{
						  
		}
		//Reads new password from email
		String SMTP_HOST = "smtp.gmail.com";
	    String EMAIL_ADDRESS = "fakeemailtestqaa@gmail.com";
	    String PASSWORD = "5sepkale";
	    String INBOX_FOLDER = "INBOX";	    
	    Properties props = new Properties();
	    props.load(new FileInputStream(new File( "C:\\Users\\rramakrishnan\\DriversForSelenium\\smtp.properties" )));
	    Session session = Session.getDefaultInstance(props, null);
	    Store store = session.getStore("imaps");
	    store.connect(SMTP_HOST, EMAIL_ADDRESS, PASSWORD);
	    Folder inbox = store.getFolder(INBOX_FOLDER);
	    inbox.open(Folder.READ_ONLY);
	    Flags seen = new Flags(Flags.Flag.SEEN);
        FlagTerm unseenFlagTerm = new FlagTerm(seen, false);
        Message[] messages1 = inbox.search(unseenFlagTerm);
        int messageCount1 = messages1.length;
        while(true)
        {
        	Thread.sleep(2000);
        	if (messageCount1>0)
        		break;
        	messages1 = inbox.getMessages();
        	Thread.sleep(1000);
        	messages1 = inbox.search(unseenFlagTerm);
        	messageCount1 = messages1.length;
        }
        System.out.println("Unread messages: "+messageCount1);
        for (int i = 0; i < messageCount1; i++) {
        	Message message1 = messages1[i];
        	System.out.println(i);
            System.out.println("Mail Subject:- " + messages1[i].getSubject());
            System.out.println("From: " + message1.getFrom());
            System.out.println("Text: " + message1.getContent().toString());
        }
        String emailText=messages1[messageCount1-1].getContent().toString();
        int n=emailText.indexOf("user account password has been reset to ");
        int e=emailText.indexOf(".</p><p>You may change this after your next login.");
        System.out.println(n);
        String activate=emailText.substring(n+40, e);
        System.out.println(activate);
        inbox.close(true);
        store.close();
        //Logs out
      	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
      	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-signout-button"))).click();
      	Thread.sleep(3000);
      	//Login with new password
      	driver.switchTo().defaultContent();
      	//Login button is located and clicked
      	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-login-button"))).click();
      	//Enter Username
      	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-un"))).sendKeys(company_id);
      	//Enter password
      	driver.findElement(By.id("pii-pw")).sendKeys(activate);
      	Thread.sleep(2000);
      	driver.findElement(By.id("pii-signin-button")).click();  		
      	Thread.sleep(3000);
      	//Waits for the page to load
      	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Switches to the iframe
      	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
      	Thread.sleep(5000);
      	//Logs out
      	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
      	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-signout-button"))).click();
      	Thread.sleep(3000);
      	//Switches to main content
      	driver.switchTo().defaultContent();
      	//Waits for the page to load
      	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
      	login=0;
      	Login();
      	System.out.println("Title after login: "+driver.getTitle());
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
      	  }catch (NoSuchElementException t){
      	     throw t;
      	}
      	Thread.sleep(5000);
      	//Clicks on admin user name on top right corner
      	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
      	//Clicks on admin option
      	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-admin"))).click();
      	//Clicks on Accounts
      	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-accounts']/h3/a"))).click();          
	}
	
	public void emailMarkRead() throws Exception{
		
		String SMTP_HOST = "smtp.gmail.com";
	    String EMAIL_ADDRESS = "fakeemailtestqaa@gmail.com";
	    String PASSWORD = "5sepkale";
	    String INBOX_FOLDER = "INBOX";	    
	    Properties props = new Properties();
	    props.load(new FileInputStream(new File( "C:\\Users\\rramakrishnan\\DriversForSelenium\\smtp.properties" )));
	    Session session = Session.getDefaultInstance(props, null);
	    Store store = session.getStore("imaps");
	    store.connect(SMTP_HOST, EMAIL_ADDRESS, PASSWORD);
	    Folder inbox = store.getFolder(INBOX_FOLDER);
	    inbox.open(Folder.READ_WRITE);
	    Message[] messages = inbox.getMessages();
	    inbox.setFlags(messages, new Flags(Flags.Flag.SEEN), true);
	    System.out.println("Marked all messages read");	    
	    inbox.close(true);
        store.close();
	}
	@Test
	  public void SanityTest() throws Exception{
		  
		  //Mark all messages in inbox as read
		  emailMarkRead();
		  Login();
		  System.out.println("Title after login: "+driver.getTitle());
		  Thread.sleep(7000);
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
		  Thread.sleep(4000);
		  WebDriverWait wait = new WebDriverWait(driver,20);
		  //Clicks on admin user name on top right corner
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		  //Clicks on admin option
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-admin"))).click();
		  //Clicks on Accounts
		  driver.findElement(By.xpath(".//*[@id='pii-admin-accounts']/h3/a")).click();
		  //Clicks on Companies
		  driver.findElement(By.id("pii-admin-customers-button")).click();
		  //Enters company id in ID field 
		  driver.findElement(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input")).sendKeys(company_id);
		  driver.findElement(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input")).sendKeys(Keys.ENTER);
		  Thread.sleep(3000);
		  String comp = driver.findElement(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div[2]/table/tbody/tr/td")).getText();
		  System.out.println(comp);
		  if(comp.contains(company_id))
		  {
			  //delete company, group, user
			  //Goes to edit user and searches for user
			  //Clicks on Edit user
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-edit"))).click();
			  Thread.sleep(2000);
			  //Searches for newly created user
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-user-list']/form/div/input"))).sendKeys(company_id);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-user-list']/form/div/input"))).sendKeys(Keys.ENTER);
			  try{
				  WebElement select = driver.findElement(By.id("pii-admin-user-list"));
				  select.findElement(By.cssSelector(".ui-li-static.ui-body-inherit.ui-first-child.ui-last-child"));
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-user-list']/form/div/input"))).clear();
				  Thread.sleep(1000);
				  deleteUser();
				  deleteGroup();
				  deleteCompany();
			  }catch (org.openqa.selenium.NoSuchElementException u)
			  {
				  //Clicks on Edit group
				  driver.findElement(By.id("pii-admin-group-edit")).click();
				  Thread.sleep(2000);
				  //Searches for newly created group
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-group-list']/form/div/input"))).clear();
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-group-list']/form/div/input"))).sendKeys(company_id);
				  driver.findElement(By.xpath(".//*[@id='pii-admin-group-list']/form/div/input")).sendKeys(Keys.ENTER);
				  try{
					  WebElement select = driver.findElement(By.id("pii-admin-group-list"));
					  select.findElement(By.cssSelector(".ui-li-static.ui-body-inherit.ui-first-child.ui-last-child"));
					  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-group-list']/form/div/input"))).clear();
					  Thread.sleep(1000);
					  deleteGroup();
					  deleteCompany();
				  }catch (org.openqa.selenium.NoSuchElementException u1)
				  {
					  deleteCompany();
				  }
			  }
		  }
		  else
		  {
			  System.out.println("Company does not exist, it can be created");
		  }
		  //Waits for black loading message to disappear
		  try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		  //CLicks on new button
		  driver.findElement(By.id("pii-admin-cust-button-new")).click();
		  Thread.sleep(2000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-dialog-title"))).click();
		  //Clicks on new company
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-dialog-confirmed"))).click();
		  //Fills all mandatory details
		  driver.findElement(By.id("pii-admin-cust-cid")).sendKeys(company_id);
		  driver.findElement(By.id("pii-admin-cust-name")).sendKeys("Sanity Test");
		  driver.findElement(By.id("pii-admin-cust-address")).sendKeys("Sanity Test");
		  driver.findElement(By.id("pii-admin-cust-tel")).sendKeys("123456");
		  driver.findElement(By.id("pii-admin-cust-busCts")).sendKeys("Sanity Test");
		  driver.findElement(By.id("pii-admin-cust-tecCts")).sendKeys("Sanity Test"); 
		  String ev1 = driver.findElement(By.id("pii-admin-cust-cid")).getAttribute("value");
		  String ev2 = driver.findElement(By.id("pii-admin-cust-name")).getAttribute("value");
		  String ev3 = driver.findElement(By.id("pii-admin-cust-address")).getAttribute("value");
		  String ev4 = driver.findElement(By.id("pii-admin-cust-tel")).getAttribute("value");
		  String ev5 = driver.findElement(By.id("pii-admin-cust-busCts")).getAttribute("value");
		  String ev6 = driver.findElement(By.id("pii-admin-cust-tecCts")).getAttribute("value");
		  if ((ev1.equals(company_id)==false))
		  {
			  driver.findElement(By.id("pii-admin-cust-cid")).clear();
			  driver.findElement(By.id("pii-admin-cust-cid")).sendKeys(company_id);
		  }
		  if ((ev2.equals("Sanity Test")==false))
		  {
			  driver.findElement(By.id("pii-admin-cust-name")).clear();
			  driver.findElement(By.id("pii-admin-cust-name")).sendKeys("Sanity Test");
		  }
		  if ((ev3.equals("Sanity Test")==false))
		  {
			  driver.findElement(By.id("pii-admin-cust-address")).clear();
			  driver.findElement(By.id("pii-admin-cust-address")).sendKeys("Sanity Test");
		  }
		  if ((ev4.equals("123456")==false))
		  {
			  driver.findElement(By.id("pii-admin-cust-tel")).clear();
			  driver.findElement(By.id("pii-admin-cust-tel")).sendKeys("123456");
		  }
		  if ((ev5.equals("Sanity Test")==false))
		  {
			  driver.findElement(By.id("pii-admin-cust-busCts")).clear();
			  driver.findElement(By.id("pii-admin-cust-busCts")).sendKeys("Sanity Test");
		  }
		  if ((ev6.equals("Sanity Test")==false))
		  {
			  driver.findElement(By.id("pii-admin-cust-tecCts")).clear();
			  driver.findElement(By.id("pii-admin-cust-tecCts")).sendKeys("Sanity Test");
		  }
		  //Clicks on save
		  driver.findElement(By.id("pii-admin-cust-button-save")).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-dialog-title"))).click();
		  //Clicks on create company
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-dialog-confirmed"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  //Enters company id in ID field 
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input"))).clear();
		  driver.findElement(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input")).sendKeys(company_id);
		  driver.findElement(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input")).sendKeys(Keys.ENTER);
		  //Waits for black loading message to disappear
		  try{
			  Thread.sleep(2000);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		  //Clicks on newly created company id
		  driver.findElement(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div[2]/table/tbody/tr/td")).click();
		  //Waits for black loading message to disappear
		  try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		  System.out.println("Company created");
		  //Clicks on edit company
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-button-edit"))).click();
		  //Changes the address
		  driver.findElement(By.id("pii-admin-cust-address")).clear();
		  driver.findElement(By.id("pii-admin-cust-address")).sendKeys("QAA edit company");
		  //Clicks on Save
		  driver.findElement(By.id("pii-admin-cust-button-save")).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-dialog-title"))).click();
		  //Clicks on update company
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-dialog-confirmed"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  //Enters company id in ID field 
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input"))).clear();
		  driver.findElement(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input")).sendKeys(company_id);
		  driver.findElement(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input")).sendKeys(Keys.ENTER);
		  //Clicks on newly created company id
		  driver.findElement(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div[2]/table/tbody/tr/td")).click();
		  //Checks if company address has been edited
		  String changeAddress= driver.findElement(By.id("pii-admin-cust-address")).getAttribute("value");
		  softly.assertThat(changeAddress).as("test data").isEqualTo("QAA edit company");
		  
		  
		  Thread.sleep(2000);
		  //Clicks on create group
		  driver.findElement(By.id("pii-admin-group-create")).click();
		  Thread.sleep(2000);
		  //Fills all mandatory 
		  driver.findElement(By.id("pii-admin-group-name")).sendKeys(company_id);
		  driver.findElement(By.id("pii-admin-group-cases")).sendKeys("all");
		  ev1 = driver.findElement(By.id("pii-admin-group-name")).getAttribute("value");
		  ev2 = driver.findElement(By.id("pii-admin-group-cases")).getAttribute("value");
		  if ((ev1.equals(company_id)==false))
		  {
			  driver.findElement(By.id("pii-admin-group-name")).clear();
			  driver.findElement(By.id("pii-admin-group-name")).sendKeys(company_id);
		  }
		  if ((ev2.equals("all")==false))
		  {
			  driver.findElement(By.id("pii-admin-group-cases")).clear();
			  driver.findElement(By.id("pii-admin-group-cases")).sendKeys("all");
		  }
		  Thread.sleep(2000);
		  WebElement element = driver.findElement(By.id("pii-admin-group-cid"));
		  Select dropdown = new Select (element);
		  dropdown.selectByVisibleText(company_id);
		  driver.findElement(By.id("pii-admin-group-modules-button")).click();
		  Thread.sleep(5000);
		  WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-group-modules-menu")));
		  ele.findElement(By.linkText("Equipment Failure Instant RCA")).click();
		  Thread.sleep(1000);
		  ele.findElement(By.linkText("Instant Common Cause Analysis")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath(".//*[@id='pii-admin-group-modules-listbox']/div/a")).click();
		  //Clicks on save
		  driver.findElement(By.id("pii-admin-group-button-save")).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-group-dialog-title"))).click();
		  //Clicks on Save
		  driver.findElement(By.id("pii-admin-group-dialog-confirmed")).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  System.out.println("Group created");
		  
		  
		  Thread.sleep(2000);
		  //Clicks on create user
		  driver.findElement(By.id("pii-admin-user-create")).click();
		  Thread.sleep(2000);
		  //Enters mandatory details
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-loginname"))).sendKeys(company_id);
		  driver.findElement(By.id("pii-admin-user-name")).sendKeys(company_id);
		  driver.findElement(By.id("pii-admin-user-password")).sendKeys(decode(password));
		  driver.findElement(By.id("pii-admin-user-password-again")).sendKeys(decode(password));
		  driver.findElement(By.id("pii-admin-user-company")).sendKeys("Sanity Test");
		  driver.findElement(By.id("pii-admin-user-email")).sendKeys("fakeemailtestqaa@gmail.com");
		  ev1 = driver.findElement(By.id("pii-admin-user-name")).getAttribute("value");
		  ev2 = driver.findElement(By.id("pii-admin-user-company")).getAttribute("value");
		  ev3 = driver.findElement(By.id("pii-admin-user-email")).getAttribute("value");
		  if ((ev1.equals(company_id)==false))
		  {
			  driver.findElement(By.id("pii-admin-user-name")).clear();
			  driver.findElement(By.id("pii-admin-user-name")).sendKeys(company_id);
		  }
		  if ((ev2.equals("Sanity Test")==false))
		  {
			  driver.findElement(By.id("pii-admin-user-company")).clear();
			  driver.findElement(By.id("pii-admin-user-company")).sendKeys("Sanity Test");
		  }
		  if ((ev3.equals("fakeemailtestqaa@gmail.com")==false))
		  {
			  driver.findElement(By.id("pii-admin-user-email")).clear();
			  driver.findElement(By.id("pii-admin-user-email")).sendKeys("fakeemailtestqaa@gmail.com");
		  }
		  Thread.sleep(2000);
		  driver.findElement(By.id("pii-admin-user-groups-button")).click();
		  Thread.sleep(2000);
		  WebElement ele1 = driver.findElement(By.id("pii-admin-user-groups-menu"));
		  ele1.findElement(By.linkText(company_id)).click();
		  driver.findElement(By.xpath(".//*[@id='pii-admin-user-groups-dialog']/div/div/a")).click();
		  Select dd2 = new Select (driver.findElement(By.id("pii-admin-user-dept")));
		  dd2.selectByVisibleText("Accounting");
		  Select dd3 = new Select (driver.findElement(By.id("pii-admin-user-jobtitle")));
		  dd3.selectByVisibleText("Engineer");
		  Select dd4 = new Select (driver.findElement(By.id("pii-admin-user-customerId")));
		  dd4.selectByVisibleText(company_id);
		  //Clicks on save button
		  Thread.sleep(2000);
		  driver.findElement(By.id("pii-admin-user-button-save")).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-title"))).click();
		  //Clicks on Save button
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-confirmed"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  System.out.println("User created");
		  
		  Thread.sleep(10000);
		  editGroupCheckAccess();

		  Thread.sleep(4000);
		  editPassword();
		  
		  Thread.sleep(4000);
		  deleteUser();		  
		  
		  Thread.sleep(4000);
		  deleteGroup();		  
		  
		  Thread.sleep(4000);
		  deleteCompany();	
		  
		  //Logs out
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-signout-button"))).click();
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
