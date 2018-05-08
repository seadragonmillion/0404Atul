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
import org.openqa.selenium.TimeoutException;
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
	String companyPII="pii";
	String groupPII="pii";
	String groupAdmin="admin";
	String company_id1DevAsia="2017qaagroupedit1";
	String company_id2DevAsia="2017qaagroupedit2";
	String company_id1DevAsiaIE11="2017qaagroupedit1ie11";
	String company_id2DevAsiaIE11="2017qaagroupedit2ie11";
	String company_id1US="2017qaagroupedit1us";
	String company_id2US="2017qaagroupedit2us";
	String company_id1USIE11="2017qaagroupedit1ie11us";
	String company_id2USIE11="2017qaagroupedit2ie11us";
	
	public void verifyGroupListGroupModeratorChange (WebDriver driver, String company_id1, String company_id2) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Clicks on create user
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-create"))).click();
		Thread.sleep(2000);
		//Click on Select group dropdown
		driver.findElement(By.id("pii-admin-user-groups-button")).click();
		//Verify Group List is empty
		try{
			driver.findElement(By.xpath(".//*[@id='pii-admin-user-groups-menu']/li[1]"));
			softly.fail("No Group list should exist without company selection");
		}catch (NoSuchElementException u)
		{
			System.out.println("Group list empty");
		}
		//Close group pop up
		driver.findElement(By.xpath(".//*[@id='pii-admin-user-groups-listbox-popup']/div/div/a")).click();
		Thread.sleep(2000);
		jse.executeScript("scroll(0,1500)");
		Thread.sleep(2000);
		//Click on Select group moderator
		driver.findElement(By.id("pii-admin-user-modgroups-button")).click();
		//Verify Group moderator list is empty
		try{
			driver.findElement(By.xpath(".//*[@id='pii-admin-user-modgroups-menu']/li[1]"));
		softly.fail("No Group moderator list should exist without group selection");
		}catch (NoSuchElementException u)
		{
			System.out.println("Group moderator list empty");
		}
		//Close group moderator pop up
		driver.findElement(By.xpath(".//*[@id='pii-admin-user-modgroups-listbox-popup']/div/div/a")).click();
		//Select company1
		Select dd = new Select (driver.findElement(By.id("pii-admin-user-customerId")));
		dd.selectByVisibleText(company_id1);
		Thread.sleep(2000);
		jse.executeScript("scroll(0,0)");
		Thread.sleep(2000);
		//Click on Select group dropdown
		driver.findElement(By.id("pii-admin-user-groups-button")).click();
		//Verify group1 of company1 is only present in list
		int c=2;
		while(true)
		{
			try{
				driver.findElement(By.xpath(".//*[@id='pii-admin-user-groups-menu']/li["+c+"]"));
				String s = driver.findElement(By.xpath(".//*[@id='pii-admin-user-groups-menu']/li["+c+"]/a")).getText();
				System.out.println(s);
				softly.assertThat(s).as("test data").isEqualTo(company_id1);
				c=c+1;
			}catch (NoSuchElementException u)
			{
				break;
			}
		}	
		//Select group1
		WebElement ele1 = driver.findElement(By.id("pii-admin-user-groups-menu"));
		ele1.findElement(By.linkText(company_id1)).click();
		//Close group pop up
		driver.findElement(By.xpath(".//*[@id='pii-admin-user-groups-listbox-popup']/div/div/a")).click();
		Thread.sleep(2000);
		jse.executeScript("scroll(0,1500)");
		Thread.sleep(2000);
		//Click on Select group moderator
		driver.findElement(By.id("pii-admin-user-modgroups-button")).click();
		//Verify group moderator list
		c=2;
		while(true)
		{
			try{
				driver.findElement(By.xpath(".//*[@id='pii-admin-user-modgroups-menu']/li["+c+"]"));
				String s = driver.findElement(By.xpath(".//*[@id='pii-admin-user-modgroups-menu']/li["+c+"]/a")).getText();
				System.out.println(s);
				softly.assertThat(s).as("test data").isEqualTo(company_id1);
				c=c+1;
			}catch (NoSuchElementException u)
			{
				break;
			}
		}
		//Select moderated group 1
		ele1 = driver.findElement(By.id("pii-admin-user-modgroups-menu"));
		ele1.findElement(By.linkText(company_id1)).click();
		//Close group moderator pop up
		driver.findElement(By.xpath(".//*[@id='pii-admin-user-modgroups-listbox-popup']/div/div/a")).click();
		//Change to company 2
		dd.selectByVisibleText(company_id2);
		Thread.sleep(2000);
		jse.executeScript("scroll(0,0)");
		Thread.sleep(2000);
		//Click on Select group dropdown
		driver.findElement(By.id("pii-admin-user-groups-button")).click();
		//Verify group2 of company2 is only present in list
		c=2;
		while(true)
		{
			try{
				driver.findElement(By.xpath(".//*[@id='pii-admin-user-groups-menu']/li["+c+"]"));
				String s = driver.findElement(By.xpath(".//*[@id='pii-admin-user-groups-menu']/li["+c+"]/a")).getText();
				System.out.println(s);
				softly.assertThat(s).as("test data").isEqualTo(company_id2);
				c=c+1;
			}catch (NoSuchElementException u)
			{
				break;
			}
		}	
		//Select group2
		ele1 = driver.findElement(By.id("pii-admin-user-groups-menu"));
		ele1.findElement(By.linkText(company_id2)).click();
		//Close group pop up
		driver.findElement(By.xpath(".//*[@id='pii-admin-user-groups-listbox-popup']/div/div/a")).click();
		Thread.sleep(2000);
		jse.executeScript("scroll(0,1500)");
		Thread.sleep(2000);
		//Click on Select group moderator
		driver.findElement(By.id("pii-admin-user-modgroups-button")).click();
		//Verify group2 moderator list
		c=2;
		while(true)
		{
			try{
				driver.findElement(By.xpath(".//*[@id='pii-admin-user-modgroups-menu']/li["+c+"]"));
				String s = driver.findElement(By.xpath(".//*[@id='pii-admin-user-modgroups-menu']/li["+c+"]/a")).getText();
				System.out.println(s);
				softly.assertThat(s).as("test data").isEqualTo(company_id2);
				c=c+1;
			}catch (NoSuchElementException u)
			{
				break;
			}
		}
		//Select moderated group 2
		ele1 = driver.findElement(By.id("pii-admin-user-modgroups-menu"));
		ele1.findElement(By.linkText(company_id2)).click();
		//Close group moderator pop up
		driver.findElement(By.xpath(".//*[@id='pii-admin-user-modgroups-listbox-popup']/div/div/a")).click();
		Thread.sleep(2000);
		jse.executeScript("scroll(0,0)");
		Thread.sleep(2000);
	}
	
	
	
	public void userRetrieveAfterProfileView(WebDriver driver, String company_id, String username, String password, Login obj) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		//Logout and login as admin
		logoutLogin(driver,obj,username,password);		
		//Clicks on admin user name on top right corner
      	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
      	//Click on Account
      	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-acct"))).click();
      	//Verify if User profile opened 
      	String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-title"))).getText();
      	softly.assertThat(s).as("test data").isEqualTo("User Profile");
      	System.out.println(s);
      	//Verify if username is displayed
      	String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-loginname"))).getAttribute("value");
      	softly.assertThat(s1).as("test data").isEqualTo(username);
      	System.out.println(s1);
        //Clicks on admin user name on top right corner
      	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
      	//Click on Admin
      	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-admin"))).click();
      	//Click on Accounts
      	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-accounts']/h3/a"))).click();
      	//Click on edit user
      	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-edit"))).click();
        //Searches for newly created user
      	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-user-list']/form/div/input"))).sendKeys(company_id);
      	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-user-list']/form/div/input"))).sendKeys(Keys.ENTER);
      	Thread.sleep(2000);
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
      	//Verify login name of new user
      	String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-loginname"))).getAttribute("value");
      	System.out.println(s2);
      	softly.assertThat(s2).as("test data").isEqualTo(company_id);
	}
	
	public void companyRetrieveAgain(WebDriver driver, String company_id) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		//Clear company id from search field
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input"))).clear();
		//Click enter
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input"))).sendKeys(Keys.ENTER);
		//Click on new button to create a company with same company id
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-button-new"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-dialog-title")));
		//Clicks on new company
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-dialog-confirmed"))).click();
		//Enter same company id in company id field
		driver.findElement(By.id("pii-admin-cust-cid")).sendKeys(company_id);
		Thread.sleep(2000);
		//Verify error that company id exists
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-cid-error")));
		String s = ele.getText();
		softly.assertThat(s).as("test data").isEqualTo("This company ID is already in use");
		System.out.println(s);
		Thread.sleep(2000);
		//Enter company id in search field
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input"))).clear();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input"))).sendKeys(company_id);
		Thread.sleep(2000);
		//Verify if table is still there
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div[2]/table")));
		//Click enter
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input"))).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		//Verify if company comes up
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div[2]/table/tbody/tr/td")));
		Thread.sleep(2000);
		//Clear the field
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input"))).clear();
		Thread.sleep(2000);
		//Enter company id in search field
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input"))).sendKeys(company_id);
		Thread.sleep(2000);
		//Verify if table is still there
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div[2]/table")));
		//Verify that company "Not found" does not come up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div[2]/table/tbody/tr/td"))).getText();
		softly.assertThat(s1).as("test data").isNotEqualTo("Not found");
		System.out.println(s1);
		//Click enter
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input"))).sendKeys(Keys.ENTER);
		//Verify if company comes up and click on it
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div[2]/table/tbody/tr/td"))).click();
		//Verify that company "Not found" does not come up
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div[2]/table/tbody/tr/td"))).getText();
		softly.assertThat(s2).as("test data").isNotEqualTo("Not found");
		System.out.println(s2);
	}
	
	public String[] allModuleList () throws Exception {
		
		List<String> text = new ArrayList<String>();
		text.add("Event Reports");
		text.add("JIT Wisdom");
		text.add("JIT Risk Joggers");
		text.add("Knowledge Bank");
		text.add("Knowledge Exchange");
		text.add("Performance Accountability & Analytics");
		text.add("SPV Error Meter");
		text.add("Human Performance Inspector");
		text.add("Human Error Instant RCA");
		text.add("Equipment Failure Instant RCA");
		text.add("Organization & Programmatic Instant RCA");
		text.add("Instant Common Cause Analysis");
		text.add("Job Observation Analysis");
		text.add("3-Pass Review");
		text.add("Remote Verification");
		text.add("eLearning");
		text.add("Error-Free Trainings");
		text.add("Human Performance");
		text.add("Equipment Performance");
		text.add("Electrical Failure Modes");
		text.add("Mechanical Failure Modes");
		String[] list = text.stream().toArray(String[]::new);
		return list;
	}
	
	public void accessOneModule(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		Thread.sleep(2000);
		//Click on Analysis
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-a"))).click();
		Thread.sleep(2000);
		//Verify HiRCA is enabled
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-hirca")));
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
		//Click on HiRCA
		element.click();
		Thread.sleep(2000);
		//Verify all other mpdules don't have access
		//Go to KALE homepage
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pii-logo-div-element-kale"))).click();
	    //Click on Knowledge
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-k"))).click();
	  	element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Event Reports")));
		if(element.getAttribute("class").contains("ui-state-disabled")==false)
		{
			softly.fail("Event Reports enabled");
			Thread.sleep(2000);
		}
		else System.out.println("Event Reports disabled");
	  	element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("JIT Wisdom")));
		if(element.getAttribute("class").contains("ui-state-disabled")==false)
		{
			softly.fail("JIT Wisdom enabled");
			Thread.sleep(2000);
		}
		else System.out.println("JIT Wisdom disabled");
	  	element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("JIT Risk Joggers")));
		if(element.getAttribute("class").contains("ui-state-disabled")==false)
		{
			softly.fail("JIT Risk Joggers enabled");
			Thread.sleep(2000);
		}
		else System.out.println("JIT Risk Joggers disabled");
	  	element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Knowledge Bank")));
		if(element.getAttribute("class").contains("ui-state-disabled")==false)
		{
			softly.fail("Knowledge Bank enabled");
			Thread.sleep(2000);
		}
		else System.out.println("Knowledge Bank disabled");
	  	element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Knowledge Exchange")));
		if(element.getAttribute("class").contains("ui-state-disabled")==false)
		{
			softly.fail("Knowledge Exchange enabled");
			Thread.sleep(2000);
		}
		else System.out.println("Knowledge Exchange disabled");
	  	element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Performance Accountability & Analytics")));
		if(element.getAttribute("class").contains("ui-state-disabled")==false)
		{
			softly.fail("Performance Accountability & Analytics enabled");
			Thread.sleep(2000);
		}
		else System.out.println("Performance Accountability & Analytics disabled");
		//Click on Analysis
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
		element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-em")));
		if(element.getAttribute("class").contains("ui-state-disabled")==false)
		{
			softly.fail("SPV Error Meter enabled");
			Thread.sleep(2000);
		}
		else System.out.println("SPV Error Meter disabled");
	  	element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-hpi")));
		if(element.getAttribute("class").contains("ui-state-disabled")==false)
		{
			softly.fail("HPI enabled");
			Thread.sleep(2000);
		}
		else System.out.println("HPI disabled");
	  	/*element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-hirca")));
		if(element.getAttribute("class").contains("ui-state-disabled")==false)
		{
			softly.fail("HiRCA enabled");
			Thread.sleep(2000);
		}
		else System.out.println("HiRCA disabled");*/
	  	element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-eirca")));
		if(element.getAttribute("class").contains("ui-state-disabled")==false)
		{
			softly.fail("EiRCA enabled");
			Thread.sleep(2000);
		}
		else System.out.println("EiRCA disabled");
	  	element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-opirca")));
		if(element.getAttribute("class").contains("ui-state-disabled")==false)
		{
			softly.fail("O&PiRCA enabled");
			Thread.sleep(2000);
		}
		else System.out.println("O&PiRCA disabled");
	  	element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-icca")));
		if(element.getAttribute("class").contains("ui-state-disabled")==false)
		{
			softly.fail("ICCA enabled");
			Thread.sleep(2000);
		}
		else System.out.println("ICCA disabled");
	  	element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-jo")));
		if(element.getAttribute("class").contains("ui-state-disabled")==false)
		{
			softly.fail("Job Observation enabled");
			Thread.sleep(2000);
		}
		else System.out.println("Job Observation disabled");
	  	element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-3pr")));
		if(element.getAttribute("class").contains("ui-state-disabled")==false)
		{
			softly.fail("3 Pass Review enabled");
			Thread.sleep(2000);
		}
		else System.out.println("3 Pass Review disabled");
	  	element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-rv")));
		if(element.getAttribute("class").contains("ui-state-disabled")==false)
		{
			softly.fail("Remote Verification enabled");
			Thread.sleep(2000);
		}
		else System.out.println("Remote Verification disabled");
		//Clicks on Learning
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Learning"))).click();
		//Clicks on Error-Free Bank
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='links']/a[4]"))).click();
	  	element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Human Performance")));
		if(element.getAttribute("class").contains("ui-state-disabled")==false)
		{
			softly.fail("Human Performance enabled");
			Thread.sleep(2000);
		}
		else System.out.println("Human Performance disabled");
	  	element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Equipment Performance")));
		if(element.getAttribute("class").contains("ui-state-disabled")==false)
		{
			softly.fail("Equipment Performance enabled");
			Thread.sleep(2000);
		}
		else System.out.println("Equipment Performance disabled");
	  	element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Electrical Failure Modes")));
		if(element.getAttribute("class").contains("ui-state-disabled")==false)
		{
			softly.fail("Electrical Failure Modes enabled");
			Thread.sleep(2000);
		}
		else System.out.println("Electrical Failure Modes disabled");
	  	element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Mechanical Failure Modes")));
		if(element.getAttribute("class").contains("ui-state-disabled")==false)
		{
			softly.fail("Mechanical Failure Modes enabled");
			Thread.sleep(2000);
		}
		else System.out.println("Mechanical Failure Modes disabled");
	}
	
	public void logoutLogin(WebDriver driver, Login obj, String username, String password) throws Exception {
		
		//Logout as admin/new user
		obj.logout(driver);
		//If browser is firefox then switch to default content
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		if(browserName.equals("firefox"))
		{
		 	driver.switchTo().defaultContent();
		}
		Thread.sleep(2000);
		//Login as new user/admin
		int login = obj.LoginUser(driver, username, password);
		System.out.println("Title after login: "+driver.getTitle());
		Thread.sleep(5000);
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
	}
	
	public void changeGroupCompany (WebDriver driver, String company_id, String groupChange, String companyChange) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-admin"))).click();
		//Clicks on Accounts
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-accounts']/h3/a"))).click();
		//Click on edit user
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-edit"))).click();
		//Searches for newly created user
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-user-list']/form/div/input"))).sendKeys(company_id);
		driver.findElement(By.xpath(".//*[@id='pii-admin-user-list']/form/div/input")).sendKeys(Keys.ENTER);
		//Selects the newly created user
		WebElement select = driver.findElement(By.id("pii-admin-user-list"));
		WebElement option = select.findElement(By.cssSelector(".ui-li-static.ui-body-inherit.ui-first-child.ui-last-child"));
		option.click();
		//Waits for black loading message to disappear
		try{
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			}catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Change company id
		Select dd1 = new Select (driver.findElement(By.id("pii-admin-user-customerId")));
		dd1.selectByVisibleText(companyChange);
		//Select pii group
		driver.findElement(By.id("pii-admin-user-groups-button")).click();
		WebElement ele1 = driver.findElement(By.id("pii-admin-user-groups-menu"));
		ele1.findElement(By.linkText(groupChange)).click();
		driver.findElement(By.xpath(".//*[@id='pii-admin-user-groups-listbox-popup']/div/div/a")).click();
		//Click on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-button-save"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-confirmed"))).click();
		//Waits for black loading message to disappear
		try{
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			}catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
	}
	
	public void groupView (WebDriver driver, String company_id1, String company_id2) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);	
		//Click on Companies
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-customers-button"))).click();
		//Enters company id in ID field 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input"))).clear();
		driver.findElement(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input")).sendKeys(company_id1);
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
		 //Click on edit
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-button-edit"))).click();
		 //Get name of group to verify if group name is as expected
		 String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-groups-jsgrid']/div[2]/table/tbody/tr/td[1]"))).getText();
		 softly.assertThat(s).as("test data").isEqualTo(company_id1);
		 //Click on group under company
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-groups-jsgrid']/div[2]/table/tbody/tr/td[1]"))).click();
		 //Waits for black loading message to disappear
		 try{
		     Thread.sleep(1000);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		 //Verify if group name is as expected
		 String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-group-name"))).getAttribute("value");
		 softly.assertThat(s1).as("test data").isEqualTo(company_id1);
		 //Edit the group by changing the module access
		 driver.findElement(By.id("pii-admin-group-modules-button")).click();
		 WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-group-modules-menu")));
		 //Checks it
		 ele.findElement(By.linkText("Human Error Instant RCA")).click();
		 Thread.sleep(2000);
		 ele.findElement(By.linkText("Equipment Failure Instant RCA")).click();
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
		 //Waits for black loading message to disappear
		 try{
		     Thread.sleep(2000);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Click on Companies
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-customers-button"))).click();
		//Enters company id in ID field 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input"))).clear();
		driver.findElement(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input")).sendKeys(company_id2);
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
		 //Click on edit
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-button-edit"))).click();
		 //Get name of group to verify if group name is as expected
		 String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-groups-jsgrid']/div[2]/table/tbody/tr/td[1]"))).getText();
		 softly.assertThat(s3).as("test data").isEqualTo(company_id2);
		 //Click on group under company
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-groups-jsgrid']/div[2]/table/tbody/tr/td[1]"))).click();
		 //Waits for black loading message to disappear
		 try{
		     Thread.sleep(1000);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		 //Verify if group name is as expected
		 String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-group-name"))).getAttribute("value");
		 softly.assertThat(s4).as("test data").isEqualTo(company_id2);
	}
	
	public void createGroupWithExpirationDate (WebDriver driver, String company_id) throws Exception {
		
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
		  //Fill expiration date
		  driver.findElement(By.xpath(".//*[@title='Open Date Picker']")).click();
		  Thread.sleep(2000);
		  //Waits for the page to load
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  //Click on + sign for next month
		  //WebElement ele1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']")));
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-datebox-gridplus"))).click();
		  Thread.sleep(2000);
		  //Select a date
		  WebElement ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-datebox-grid")));
		  ele1.findElement(By.xpath(".//*[@class='ui-datebox-gridrow ui-datebox-gridrow-last']/div[5]")).click();
		  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("28"))).click();
		  //Clicks on save
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-group-button-save"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-group-dialog-title"))).click();
		  //Clicks on Save
		  driver.findElement(By.id("pii-admin-group-dialog-confirmed")).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  System.out.println("Group created");
		  
	}
	
	public void activateUser(String email,WebDriver driver)throws Exception {
		
		//Get current Time
        long currentTime = System.currentTimeMillis();
        //Add 15 minutes to it
        long time15 = currentTime + (15*60*1000);
		String SMTP_HOST = "smtp.gmail.com";
	    String EMAIL_ADDRESS = email;
	    String PASSWORD = "5sepkale";
	    String INBOX_FOLDER = "INBOX";	    
	    Properties props = new Properties();
	    //Get browser name
	  	Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
	  	String browserName = cap.getBrowserName().toLowerCase();
	  	System.out.println(browserName);
	  	String v = cap.getVersion().toString();
	  	System.out.println(v);
	  	if (browserName.equals("internet explorer"))
	  	{
	  	   	if (v.startsWith("11"))
	  	   		props.load(new FileInputStream(new File( "C:\\Users\\IEUser\\DriversForSelenium\\smtp.properties" )));
	  	   	else
	  	   		props.load(new FileInputStream(new File( "C:\\Users\\rramakrishnan\\DriversForSelenium\\smtp.properties" )));
	  	}
	  	else
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
        		excelStore();
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
        		excelStore();
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
	
	public void emailMarkRead(String email, WebDriver driver) throws Exception{
		
		String SMTP_HOST = "smtp.gmail.com";
	    String EMAIL_ADDRESS = email;
	    String PASSWORD = "5sepkale";
	    String INBOX_FOLDER = "INBOX";	    
	    Properties props = new Properties();
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
	    String browserName = cap.getBrowserName().toLowerCase();
	    System.out.println(browserName);
	    String v = cap.getVersion().toString();
	    System.out.println(v);
	    if (browserName.equals("internet explorer"))
	    {
	    	if (v.startsWith("11"))
	    		props.load(new FileInputStream(new File( "C:\\Users\\IEUser\\DriversForSelenium\\smtp.properties" )));
	    	else
	    		props.load(new FileInputStream(new File( "C:\\Users\\rramakrishnan\\DriversForSelenium\\smtp.properties" )));
	    }
	    else
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
		  if(driver.findElement(By.id("pii-admin-customers-button")).isDisplayed()==false)
		  {
			  //Clicks on Accounts
			  driver.findElement(By.xpath(".//*[@id='pii-admin-accounts']/h3/a")).click();
		  }		  
		  //Clicks on Companies
		  driver.findElement(By.id("pii-admin-customers-button")).click();
		  //Enters company id in ID field 
		  driver.findElement(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input")).clear();
		  Thread.sleep(1000);
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
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-user-list']/form/div/input"))).clear();
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
		  //Click on companies
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-customers-button"))).click();
		  Thread.sleep(2000);
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
		catch (TimeoutException r){
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
		if(f.contains("Performance Accountability & Analytics"))
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
		if(f.contains("Human Performance"))
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
		if(f.contains("Equipment Performance"))
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
		if(f.contains("Electrical Failure Modes"))
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
		if(f.contains("Mechanical Failure Modes"))
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
		  Thread.sleep(4000);
		  //Searches for newly created user
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-user-list']/form/div/input"))).clear();
		  Thread.sleep(2000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-user-list']/form/div/input"))).sendKeys(company_id);
		  driver.findElement(By.xpath(".//*[@id='pii-admin-user-list']/form/div/input")).sendKeys(Keys.ENTER);
		  //Selects the newly created user
		  WebElement select = driver.findElement(By.id("pii-admin-user-list"));
		  WebElement option = select.findElement(By.cssSelector(".ui-li-static.ui-body-inherit.ui-first-child.ui-last-child"));
		  option.click();
		  Thread.sleep(4000);
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
		  Thread.sleep(4000);
		  //Searches for newly created group
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-group-list']/form/div/input"))).clear();
		  Thread.sleep(2000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-group-list']/form/div/input"))).sendKeys(company_id);
		  driver.findElement(By.xpath(".//*[@id='pii-admin-group-list']/form/div/input")).sendKeys(Keys.ENTER);
		  //Selects the newly created group
		  WebElement select = driver.findElement(By.id("pii-admin-group-list"));
		  WebElement option = select.findElement(By.cssSelector(".ui-li-static.ui-body-inherit.ui-first-child.ui-last-child"));
		  option.click();
		  Thread.sleep(4000);
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
		  Thread.sleep(2000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input"))).sendKeys(company_id);
		  Thread.sleep(2000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input"))).sendKeys(Keys.ENTER);
		  //Clicks on newly created company id
		  driver.findElement(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div[2]/table/tbody/tr/td")).click();
		  Thread.sleep(4000);
		  //Clicks on delete
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-button-delete"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-dialog-title"))).click();
		  //Clicks on delete company
		  driver.findElement(By.id("pii-admin-cust-dialog-confirmed")).click();
		  Thread.sleep(4000);
		  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  System.out.println("Company deleted");
	}
	
	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}

}
