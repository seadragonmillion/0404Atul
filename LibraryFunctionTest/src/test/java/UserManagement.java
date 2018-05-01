import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


public class UserManagement {
	
	SoftAssertions softly = new SoftAssertions();
	String emailDevie11 = "fakeemailtestqaaie11dev@gmail.com";
	String emailDev = "fakeemailtestqaa@gmail.com";
	String emailUSie11 = "fakeemailtestqaaie11usa@gmail.com";
	String emailUS = "fakeemailtestqaausa@gmail.com";
	String emailAsiaie11 = "fakeemailtestqaaie11asia@gmail.com";
	String emailAsia = "fakeemailtestqaaasia@gmail.com";
		
	public void activateUser(String email,WebDriver driver)throws Exception {
		
		UserManagement obj1 = new UserManagement();
		//Get current Time
        long currentTime = System.currentTimeMillis();
        //Add 15 minutes to it
        long time15 = currentTime + (15*60*1000);
		String SMTP_HOST = "smtp.gmail.com";
	    String EMAIL_ADDRESS = email;
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
        	if(currentTime>time15)
        	{
        		System.out.println("Time elapsed for email: More than 15 minutes");
        		obj1.excelStore();
        		break;
        	}
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
        //Get Browser value
        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
	    String browserName = cap.getBrowserName().toLowerCase();
	    WebDriver driver2 = null;
	    //chrome
	    if(browserName.equals("chrome"))
	    {
	    	driver2= new ChromeDriver();
	    }
        //firefox
	    if(browserName.equals("firefox"))
	    {
	    	driver2= new FirefoxDriver();
	    }
        //ie
	    if(browserName.equals("internet explorer"))
	    {
	    	driver2= new InternetExplorerDriver();
	    }        
        driver2.get(activate);
        Thread.sleep(2000);
        driver2.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver2.quit();
        //Wait for 10 seconds
        Thread.sleep(10000);
	}
	
	public void activateUserIE11(String email,WebDriver driver)throws Exception {
		
		UserManagement obj1 = new UserManagement();
		//Get current Time
        long currentTime = System.currentTimeMillis();
        //Add 15 minutes to it
        long time15 = currentTime + (15*60*1000);
		String SMTP_HOST = "smtp.gmail.com";
	    String EMAIL_ADDRESS = email;
	    String PASSWORD = "5sepkale";
	    String INBOX_FOLDER = "INBOX";	    
	    Properties props = new Properties();
	    props.load(new FileInputStream(new File( "C:\\Users\\IEUser\\DriversForSelenium\\smtp.properties" )));
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
        	if(currentTime>time15)
        	{
        		System.out.println("Time elapsed for email: More than 15 minutes");
        		obj1.excelStore();
        		break;
        	}
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
        //Get Browser value
        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
	    String browserName = cap.getBrowserName().toLowerCase();
	    WebDriver driver2 = null;
	    //chrome
	    if(browserName.equals("chrome"))
	    {
	    	driver2= new ChromeDriver();
	    }
        //firefox
	    if(browserName.equals("firefox"))
	    {
	    	driver2= new FirefoxDriver();
	    }
        //ie
	    if(browserName.equals("internet explorer"))
	    {
	    	driver2= new InternetExplorerDriver();
	    }        
        driver2.get(activate);
        Thread.sleep(2000);
        driver2.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver2.quit();
        //Wait for 10 seconds
        Thread.sleep(10000);
	}
	
	public void emailMarkRead(String email) throws Exception{
		
		String SMTP_HOST = "smtp.gmail.com";
	    String EMAIL_ADDRESS = email;
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
	
	public void emailMarkReadIE11(String email) throws Exception{
		
		String SMTP_HOST = "smtp.gmail.com";
	    String EMAIL_ADDRESS = email;
	    String PASSWORD = "5sepkale";
	    String INBOX_FOLDER = "INBOX";	    
	    Properties props = new Properties();
	    props.load(new FileInputStream(new File( "C:\\Users\\IEUser\\DriversForSelenium\\smtp.properties" )));
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
	
	public void deletesPrevious (WebDriver driver, String company_id) throws Exception {
		
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
				  deleteUser(driver, company_id);
				  deleteGroup(driver, company_id);
				  deleteCompany(driver, company_id);
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
					  deleteGroup(driver, company_id);
				      deleteCompany(driver, company_id);
				  }catch (org.openqa.selenium.NoSuchElementException u1)
				  {
					  deleteCompany(driver, company_id);
				  }
			  }
		  }
		  else
		  {
			  System.out.println("Company does not exist, it can be created");
		  }
		  //Waits for black loading message to disappear
		  try{
			  Thread.sleep(2000);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
	}
	
	public void createCompany (WebDriver driver, String company_id) throws Exception {
		
		  WebDriverWait wait = new WebDriverWait(driver,20);
		  //CLicks on new button
		  driver.findElement(By.id("pii-admin-cust-button-new")).click();
		  //Waits for black loading message to disappear
		  try{
			  Thread.sleep(2000);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
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
		  //Waits for black loading message to disappear
		  try{
			  Thread.sleep(2000);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
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
			  Thread.sleep(2000);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		  System.out.println("Company created");
	}
	
	public void createGroup (WebDriver driver, String company_id) throws Exception {
		
		  WebDriverWait wait = new WebDriverWait(driver,20);
		  Thread.sleep(2000);
		  //Clicks on create group
		  driver.findElement(By.id("pii-admin-group-create")).click();
		  Thread.sleep(2000);
		  //Fills all mandatory 
		  driver.findElement(By.id("pii-admin-group-name")).sendKeys(company_id);
		  driver.findElement(By.id("pii-admin-group-cases")).sendKeys("all");
		  String ev1 = driver.findElement(By.id("pii-admin-group-name")).getAttribute("value");
		  String ev2 = driver.findElement(By.id("pii-admin-group-cases")).getAttribute("value");
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
		  WebElement element = driver.findElement(By.id("pii-admin-group-cid"));
		  Select dropdown = new Select (element);
		  dropdown.selectByVisibleText(company_id);
		  driver.findElement(By.id("pii-admin-group-modules-button")).click();
		  WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-group-modules-menu")));
		  //Checks it
		  ele.findElement(By.linkText("Human Error Instant RCA")).click();
		  //driver.findElement(By.xpath(".//*[@id='pii-admin-group-modules-dialog']/div/div/a")).click();
		  //driver.findElement(By.cssSelector(".ui-btn.ui-corner-all.ui-btn-left.ui-btn-icon-notext.ui-icon-delete")).click();
		  try{
			  driver.findElement(By.cssSelector(".ui-btn.ui-corner-all.ui-btn-left.ui-btn-icon-notext.ui-icon-delete")).click();
		  }catch (NoSuchElementException e)
			  {
			     driver.findElement(By.xpath(".//*[@id='pii-admin-group-modules-dialog']/div/div/a")).click();
			  }
		  catch (ElementNotInteractableException e1)
		  {
		     driver.findElement(By.xpath(".//*[@id='pii-admin-group-modules-dialog']/div/div/a")).click();
		  }
		  //Clicks on save
		  driver.findElement(By.id("pii-admin-group-button-save")).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-group-dialog-title"))).click();
		  //Clicks on Save
		  driver.findElement(By.id("pii-admin-group-dialog-confirmed")).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  System.out.println("Group created");
		  
	}
	
	public void createUser(WebDriver driver, String company_id, String password,String email) throws Exception{
		
		  WebDriverWait wait = new WebDriverWait(driver,20);
		  Login obj = new Login ();
		  Thread.sleep(2000);
		  //Clicks on create user
		  driver.findElement(By.id("pii-admin-user-create")).click();
		  Thread.sleep(2000);
		  //Enters mandatory details
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-loginname"))).sendKeys(company_id);
		  driver.findElement(By.id("pii-admin-user-name")).sendKeys(company_id);
		  driver.findElement(By.id("pii-admin-user-password")).sendKeys(obj.decodePassword(password));
		  driver.findElement(By.id("pii-admin-user-password-again")).sendKeys(obj.decodePassword(password));
		  driver.findElement(By.id("pii-admin-user-company")).sendKeys("Sanity Test");
		  driver.findElement(By.id("pii-admin-user-email")).sendKeys(email);
		  String ev1 = driver.findElement(By.id("pii-admin-user-name")).getAttribute("value");
		  String ev2 = driver.findElement(By.id("pii-admin-user-company")).getAttribute("value");
		  String ev3 = driver.findElement(By.id("pii-admin-user-email")).getAttribute("value");
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
		  if ((ev3.equals(email)==false))
		  {
			  driver.findElement(By.id("pii-admin-user-email")).clear();
			  driver.findElement(By.id("pii-admin-user-email")).sendKeys(email);
		  }
		  Select dd4 = new Select (driver.findElement(By.id("pii-admin-user-customerId")));
		  dd4.selectByVisibleText(company_id);
		  driver.findElement(By.id("pii-admin-user-groups-button")).click();
		  WebElement ele1 = driver.findElement(By.id("pii-admin-user-groups-menu"));
		  ele1.findElement(By.linkText(company_id)).click();
		  //ele1.findElement(By.className("ui-first-child ui-last-child")).click();
		  //driver.findElement(By.xpath(".//*[@id='pii-admin-user-groups-dialog']/div/div/a")).click();
		  driver.findElement(By.xpath(".//*[@id='pii-admin-user-groups-listbox-popup']/div/div/a")).click();
		  Select dd2 = new Select (driver.findElement(By.id("pii-admin-user-dept")));
		  dd2.selectByVisibleText("Accounting");
		  Select dd3 = new Select (driver.findElement(By.id("pii-admin-user-jobtitle")));
		  dd3.selectByVisibleText("Engineer");		  
		  //Clicks on save button
		  driver.findElement(By.id("pii-admin-user-button-save")).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-title"))).click();
		  //Clicks on Save button
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-confirmed"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  System.out.println("User created");
		  //Waits for loading message to disappear
		  try{
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
	}
	
	public void loginAsNewUser(WebDriver driver, String company_id, String password) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		Login obj = new Login ();
		//If browser is firefox then switch to default content
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
	    String browserName = cap.getBrowserName().toLowerCase();
	    if(browserName.equals("firefox"))
	    {
	    	driver.switchTo().defaultContent();
	    }
	    Thread.sleep(2000);
		//Login
		int login = obj.LoginUser(driver, company_id, password);
		System.out.println("Title after login: "+driver.getTitle());
		Thread.sleep(5000);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    try{
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
	    }catch (org.openqa.selenium.TimeoutException e)
	    {
	    	
	    }
		//Waits for loading message to disappear
		try{
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
		 }catch (org.openqa.selenium.TimeoutException e)
		  {
				  
		  }
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
		//Clicks on Analysis
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-a"))).click();
		Thread.sleep(2000);
	}
	
	public WebElement goToHiRCA (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);		
		Thread.sleep(2000);
		//Clicks on HiRCA
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-hirca"))).click();
		//Waits for loading message to disappear
		try{
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
		 }catch (org.openqa.selenium.TimeoutException e)
		  {
			  
		  }
		//Wait for appearance of HIRCA page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-department-button")));
		//Get WebElement of department
		WebElement element = driver.findElement(By.id("pii-irca-event-department"));
		return element;
	}
	
	public void checkDeptList(WebDriver driver, List<String> dept1,List<String> dept,WebElement ele) throws Exception {
		
		int num=0;
		if (dept1.size()>dept.size())
			num = dept1.size();
		else num = dept.size();
		for (int i=1;i<=num;i++)
		{
			try{
			//Get each department name and check if it exists in the unchanged dept list
			String s = driver.findElement(By.xpath(".//*[@id='pii-irca-event-department']/option["+(i+1)+"]")).getText();
			if(dept1.contains(s)==true)
			{
				System.out.println(s + " exists");
			}
			if(dept.isEmpty()==false && dept1.contains(s)==false)
			{
				softly.fail(s + "does not exist in original list");
				System.out.println (dept1);
			}
			if(dept.isEmpty()==false)
			{
				if (dept.contains(s)==false)
				{
					System.out.println(s + " should not exist");
				}
				if (dept.contains(s)==true)
				{
					softly.fail(s + "exists");
					System.out.println (dept);
				}
			}
			}catch (NoSuchElementException u)
			{
				System.out.println("Didn't find department at index"+(i+1));
				break;
			}
			
		}
		
	}
	
	
	public void editDept(WebDriver driver, String company_id, List<String> dept1) throws Exception {
	
	 WebDriverWait wait = new WebDriverWait(driver,20);
	 JavascriptExecutor jse = (JavascriptExecutor)driver;
	 //Clicks on admin user name on top right corner
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
	 //Clicks on admin option
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-admin"))).click();
	 //Clicks on Accounts
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-accounts']/h3/a"))).click();
	 //Clicks on Companies
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-customers-button"))).click();
	 Thread.sleep(2000);
	 //Enters company id in ID field 
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input"))).clear();
	 Thread.sleep(1000);
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input"))).sendKeys(company_id);
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input"))).sendKeys(Keys.ENTER);
	 //Clicks on newly created company id
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div[2]/table/tbody/tr/td"))).click();
	 Thread.sleep(2000);
	 //Click on edit
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-button-edit"))).click();
	 //Click on deparments collapsible
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-dept-div']/h3/a"))).click();
	 //Choose 10 random numbers between 0 to 34
	 List<Integer> numbers = new ArrayList<Integer>();
	 int x=-1;
	 //Clear list
	 numbers.clear();
	 for (int i=0; i<10;i++)
	 {
		 Random random = new Random();
		 System.out.println(i);
		 while (true)
		 {
			 x = random.nextInt(35);
			 System.out.println(numbers.contains(x));
			 if(numbers.contains(x)==true)
			 {
				 System.out.println(x);
				 continue;
			 }
			 else break;
		 }	
		 numbers.add(x);
	 }
	//Sorts number list
	Collections.sort(numbers);
	System.out.println(numbers);
	//Unselect any 10 departments and store the unselected ones in a list
	List<String> dept = new ArrayList<String>();
	for (int i=0;i<10;i++)
	{
		numbers.get(i);
		//Get element's y coordinate
		WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@piiindex='"+numbers.get(i)+"']")));
		Point p = l.getLocation();
		int yaxis= p.getY()-250;
		//Scroll to element
		jse.executeScript("scroll(0,"+yaxis+")");
		//Look for pii index number and click on checkbox
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@piiindex='"+numbers.get(i)+"']"))).click();
		//Get department name and store
		String s =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-dept-table']/tbody/tr["+(numbers.get(i)+2) +"]/td[1]"))).getText();
		dept.add(s);
	}
	//Adds a department
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-dept-input"))).sendKeys("QAA sample department");
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-dept-input"))).sendKeys(Keys.ENTER);
	//Click on add
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-dialog-title")));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-dialog-confirmed"))).click();
	dept1.add("QAA sample department");
	jse.executeScript("scroll(0,0)");
	//Save company
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-button-save"))).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-dialog-confirmed"))).click();
	//Waits for loading message to disappear
	try{
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
		  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
		 }catch (org.openqa.selenium.TimeoutException e)
		  {
			  
		  }		
	}
	
	public List<String> storeDepartmentList(WebDriver driver) throws Exception {
	
	List<String> dept1 = new ArrayList<String>();
	WebDriverWait wait = new WebDriverWait(driver,20);
	//Click on deparments collapsible
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-dept-div']/h3/a"))).click();
	for (int i=2;i<=36;i++)
	{
		//Get department name and store
		String s =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-dept-table']/tbody/tr["+i+"]/td[1]"))).getText();
		dept1.add(s);
	}
	System.out.println("Original department list "+dept1);
	return dept1;	
	}
	
	public void excelStore() throws Exception {
		
		File file = new File("E:/EmailError.xlsx");		
		// Open the Excel file
		FileInputStream ExcelFile = new FileInputStream(file);
		// Access the required test data sheet
		XSSFWorkbook ExcelWBook = new XSSFWorkbook(ExcelFile);
		XSSFSheet ExcelWSheet = ExcelWBook.getSheet("Sheet1");
		//Get number of rows
		int rows = ExcelWSheet.getPhysicalNumberOfRows();
		//Get current date 
		SimpleDateFormat sfdate = new SimpleDateFormat("MM/dd/yyy HH:mm:ss a");
		Date date = new Date();
		System.out.println(sfdate.format(date));
		//Create a new row for only images
		Row row1 = ExcelWSheet.createRow(rows);
		row1.createCell(0).setCellValue(sfdate.format(date));
		row1.createCell(1).setCellValue("No Email");
		//Close File input stream
		ExcelFile.close();
		//Create an object of FileOutputStream class to create write data in excel file
		FileOutputStream outputStream = new FileOutputStream(file);
		ExcelWBook.write(outputStream);
		ExcelWBook.close();
		outputStream.close();
				
	}
	
	public void checkAccess(WebDriver driver, int login, String[]op) throws Exception{
		WebDriverWait wait = new WebDriverWait(driver,20);
		Thread.sleep(3000);
		//Click on Knowledge
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-k"))).click();
		try{
			if (login==1)
			{
				WebDriverWait wait2 = new WebDriverWait(driver,20);
				wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();
			}
		}catch (NoSuchElementException r){
			throw r;
		}
		List<String>f = Arrays.asList(op);
		WebElement element;
		//Verify the modules selected
		if(f.contains("Event Reports"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Event Reports")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("Event Reports enabled");
				element.click();
				Thread.sleep(2000);
				//Clicks on Knowledge
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Knowledge"))).click();
				Thread.sleep(2000);
			}
			else softly.fail("Event Reports disabled");
		}
		if(f.contains("JIT Wisdom"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("JIT Wisdom")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("JIT Wisdom enabled");
				element.click();
				Thread.sleep(2000);
				//Clicks on Knowledge
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Knowledge"))).click();
				Thread.sleep(2000);
			}
			else softly.fail("JIT Wisdom disabled");
		}
		if(f.contains("JIT Risk Joggers"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("JIT Risk Joggers")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("JIT Risk Joggers enabled");
				element.click();
				Thread.sleep(2000);
				//Clicks on Knowledge
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Knowledge"))).click();
				Thread.sleep(2000);
			}
			else softly.fail("JIT Risk Joggers disabled");
		}
		if(f.contains("Knowledge Bank"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Knowledge Bank")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("Knowledge Bank enabled");
				element.click();
				Thread.sleep(2000);
				//Clicks on Knowledge
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Knowledge"))).click();
				Thread.sleep(2000);
			}
			else softly.fail("Knowledge Bank disabled");
		}
		if(f.contains("Knowledge Exchange"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Knowledge Exchange")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("Knowledge Exchange enabled");
				element.click();
				Thread.sleep(2000);
				//Clicks on Knowledge
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Knowledge"))).click();
				Thread.sleep(2000);
			}
			else softly.fail("Knowledge Exchange disabled");
		}
		if(f.contains("Project Management"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Performance Accountability & Analytics")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("Performance Accountability & Analytics enabled");
				element.click();
				Thread.sleep(2000);
				//Clicks on Knowledge
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Knowledge"))).click();
				Thread.sleep(2000);
			}
			else softly.fail("Performance Accountability & Analytics disabled");
		}
		//Clicks on Analysis
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
	    if(f.contains("SPV Error Meter"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-em")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("SPV Error Meter enabled");
				element.click();
				Thread.sleep(2000);
				//Clicks on Analysis
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
			    Thread.sleep(2000);
			}
			else softly.fail("SPV Error Meter disabled");
		}
		if(f.contains("Human Performance Inspector"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-hpi")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("HPI enabled");
				element.click();
				Thread.sleep(2000);
				//Clicks on Analysis
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
			    Thread.sleep(2000);
			}
			else softly.fail("HPI disabled");
		}
		if(f.contains("Human Error Instant RCA"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-hirca")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("HiRCA enabled");
				element.click();
				Thread.sleep(2000);
				//Clicks on Analysis
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
			    Thread.sleep(2000);
			}
			else softly.fail("HiRCA disabled");
		}
		if(f.contains("Equipment Failure Instant RCA"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-eirca")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("EiRCA enabled");
				element.click();
				Thread.sleep(2000);
				//Clicks on Analysis
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
			    Thread.sleep(2000);
			}
			else softly.fail("EiRCA disabled");
		}
		if(f.contains("Organization & Programmatic Instant RCA"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-opirca")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("O&PiRCA enabled");
				element.click();
				Thread.sleep(2000);
				//Clicks on Analysis
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
			    Thread.sleep(2000);
			}
			else softly.fail("O&PiRCA disabled");
		}
		if(f.contains("Instant Common Cause Analysis"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-icca")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("ICCA enabled");
				element.click();
				Thread.sleep(2000);
				//Clicks on Analysis
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
			    Thread.sleep(2000);
			}
			else softly.fail("ICCA disabled");
		}
		if(f.contains("Job Observation Analysis"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-jo")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("Job Obs enabled");
				element.click();
				Thread.sleep(2000);
				//Clicks on Analysis
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
			    Thread.sleep(2000);
			}
			else softly.fail("Job Obs disabled");
		}
		if(f.contains("3-Pass Review"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-3pr")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("3 Pass Review enabled");
				element.click();
				Thread.sleep(2000);
				//Clicks on Analysis
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
			    Thread.sleep(2000);
			}
			else softly.fail("3 Pass Review disabled");
		}
		if(f.contains("Remote Verification"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-rv")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("Remote Verification enabled");
				element.click();
				Thread.sleep(2000);
				//Clicks on Analysis
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
			    Thread.sleep(2000);
			}
			else softly.fail("Remote Verification disabled");
		}
		//Clicks on Learning
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Learning"))).click();
		//Clicks on Error-Free Bank
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='links']/a[4]"))).click();
		if(f.contains("Human Performance Search"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Human Performance")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("Human Performance enabled");
				element.click();
				Thread.sleep(2000);
				//Clicks on Error-Free Bank
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='links']/a[4]"))).click();
				Thread.sleep(2000);
			}
			else softly.fail("Human Performance disabled");
		}
		if(f.contains("Equipment Performance Search"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Equipment Performance")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("Equipment Performance enabled");
				element.click();
				Thread.sleep(2000);
				//Clicks on Error-Free Bank
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='links']/a[4]"))).click();
				Thread.sleep(2000);
			}
			else softly.fail("Equipment Performance disabled");
		}
		if(f.contains("Electrical Failure Mode Search"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Electrical Failure Modes")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("Electrical Failure Modes enabled");
				element.click();
				Thread.sleep(2000);
				//Clicks on Error-Free Bank
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='links']/a[4]"))).click();
				Thread.sleep(2000);
			}
			else softly.fail("Electrical Failure Modes disabled");
		}
		if(f.contains("Mechanical Failure Mode Search"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Mechanical Failure Modes")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("Mechanical Failure Modes enabled");
				element.click();
				Thread.sleep(2000);
				//Clicks on Error-Free Bank
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='links']/a[4]"))).click();
				Thread.sleep(2000);
			}
			else softly.fail("Mechanical Failure Modes disabled");
		}		    
	}
	
	
	public void deleteUser(WebDriver driver, String company_id) throws Exception{
		  
		  WebDriverWait wait = new WebDriverWait(driver,20);
		  //Clicks on Edit user
		  driver.findElement(By.id("pii-admin-user-edit")).click();
		  Thread.sleep(2000);
		  //Searches for newly created user
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-user-list']/form/div/input"))).sendKeys(company_id);
		  driver.findElement(By.xpath(".//*[@id='pii-admin-user-list']/form/div/input")).sendKeys(Keys.ENTER);
		  //Selects the newly created user
		  WebElement select = driver.findElement(By.id("pii-admin-user-list"));
		  WebElement option = select.findElement(By.cssSelector(".ui-li-static.ui-body-inherit.ui-first-child.ui-last-child"));
		  option.click();
		  //Clicks on delete
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-button-delete"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-title"))).click();
		  //Clicks on delete user
		  driver.findElement(By.id("pii-admin-user-dialog-confirmed")).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  System.out.println("User deleted");
	}
	
	public void deleteGroup(WebDriver driver, String company_id) throws Exception{
		  
		  WebDriverWait wait = new WebDriverWait(driver,20);
		  //Clicks on Edit group
		  driver.findElement(By.id("pii-admin-group-edit")).click();
		  Thread.sleep(2000);
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
	
	public void deleteCompany(WebDriver driver, String company_id) throws Exception{
		  
		  WebDriverWait wait = new WebDriverWait(driver,20);
		  //Clicks on Companies
		  driver.findElement(By.id("pii-admin-customers-button")).click();
		  Thread.sleep(2000);
		  //Enters company id in ID field 
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input"))).clear();
		  driver.findElement(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input")).sendKeys(company_id);
		  driver.findElement(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input")).sendKeys(Keys.ENTER);
		  //Clicks on newly created company id
		  driver.findElement(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div[2]/table/tbody/tr/td")).click();
		  Thread.sleep(2000);
		  //Clicks on delete
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-button-delete"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-dialog-title"))).click();
		  //Clicks on delete company
		  driver.findElement(By.id("pii-admin-cust-dialog-confirmed")).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  System.out.println("Company deleted");
	}
	
	public void softAssert() throws Exception {
		softly.assertAll();
	}

}
