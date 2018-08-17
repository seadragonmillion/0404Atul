import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.w3c.dom.Document;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RemoteVerification {
	
	SoftAssertions softly = new SoftAssertions();
	
	By AnalysisLink = By.id("pii-main-menu-button-a");
	By RVLink = By.id("pii-a-menu-rv");
	
	//Inside Module
	By RVSaveAndSendButton = By.xpath(".//*[@id='pii-rv-tabs']/div[2]/div/a[2]");
	By RVSaveButton = By.id("pii-rv-save");
	By RVSavePopupTitle = By.id("pii-rv-dialog-title");
	By RVSavePopupComfirmButton = By.id("pii-rv-dialog-confirmed");
	By RVSavedAcivitiesButton = By.id("pii-rv-savedactivities");
	By RV1stImageField = By.id("pii-rv-imgwork-photo-input");
	By RV1stImageClearButton = By.id("pii-rv-imgwork-clear");
	By RV1stImageRotateButton = By.id("pii-rv-imgwork-rotate");
	By RV2ndImageField = By.id("pii-rv-imgperson-photo-input");
	By RV2ndImageClearButton = By.id("pii-rv-imgperson-clear");
	By RV2ndImageRotateButton = By.id("pii-rv-imgperson-rotate");
	By RVDateTimeAboveLocationImage = By.id("pii-rv-tab-1-repdatetime");
	By RVVerifierField = By.id("pii-rv-verifier-list-input");
	By RVVerifierDropdown = By.id("pii-rv-verifier-list-ul");
	By RVLatitudeLongitudeAboveLocationImage = By.id("pii-rv-imgwork-location");
	By RVLocationImage = By.id("pii-rv-imgwork-googlemap");
	By RVEventTitle = By.id("pii-rv-tab-1-title");
	By RVEventDetails = By.id("pii-rv-tab-1-details");
	By RVVerifierValue = By.id("pii-rv-verifier-name");
		
	By RVNewlyCreatedFirstRecord = By.xpath(".//*[@id='pii-user-home-activities-rv']/ul/li[2]/a");
	By RVSidePanel = By.id("pii-user-home-panel-btn-rv");
	
	//HTML
	By RVReportNotSentStatusMessage = By.xpath(".//*[@id='rv-rpt']/div/div[2]/div[4]/span");
	By RVReportSentStatusMessage = By.xpath(".//*[@id='rv-rpt']/div/div[2]/div[5]/span");
	By RVCreationDate = By.xpath(".//*[@id='rv-rpt']/div/div[2]/div[3]");
	By RVShareButton = By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[3]");
	By RVReportCreatorUsername = By.xpath(".//*[@id='rv-rpt']/div/div[2]/div");
	By RVReportVerifierUsername = By.xpath(".//*[@id='rv-rpt']/div/div[2]/div[2]");
	By RVDownloadButton = By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a");
	By RVReportTitle = By.xpath(".//*[@id='rv-rpt']/div/div/table/tbody/tr[2]/td/strong");
	By RVReportEventDetails = By.xpath(".//*[@id='rv-rpt']/div/div[3]/table/tbody/tr[2]/td/span");
	By RVMarkedCriticalText = By.xpath(".//*[@id='rv-rpt']/div/div/table/tbody/tr/th/strong");
	By RVDeleteButton = By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]");
	
	//Share Page
	By RVSharePageVerifierBlock = By.xpath(".//*[@id='pii-uhshare-verifier-list-div']/div/div/div/ul");
	
	public String eventTitle(WebDriver driver) throws Exception {
		
		if(driver.getCurrentUrl().contains("kaleqa"))
			return ("I think I will <strong> buy the red car, or I will lease the blue one.");
		else return ("I think I will buy the red car, or I will lease the blue one.");
	}
	
	public String details(WebDriver driver) throws Exception {
		
		if(driver.getCurrentUrl().contains("kaleqa"))
			return ("There was no <input> ice cream in the freezer, nor did they have money to go to the store./?.,><';:*-+()@#$%&01234567890");
		else return ("There was no ice cream in the freezer, nor did they have money to go to the store./?.,><';:*-+()@#$%&01234567890");
	}
	
	public void checkStatusReport (WebDriver driver, String username, int k) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		UserManagement obj1 = new UserManagement();
		ShareCheck obj = new ShareCheck();
		EiRCA obj2 = new EiRCA();
		//Mark read verifier email		
		String email = selectEmail(k);
		obj1.emailMarkRead(email, driver);
		//Clicks on Save
		wait.until(ExpectedConditions.visibilityOfElementLocated(RVSaveButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(RVSavePopupComfirmButton)).click();
		//Wait for loading message to disappear		
		obj.loadingServer(driver);
		//Click on Saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(RVSavedAcivitiesButton)).click();
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Clicks on newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(RVNewlyCreatedFirstRecord)).click();
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Verify status
		String status = wait.until(ExpectedConditions.visibilityOfElementLocated(RVReportNotSentStatusMessage)).getText();
		softly.assertThat(status).as("test data").contains("Not yet sent to verifier");
		//Click on Open
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.OpenButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj2.ConfirmPopupButton)).click();
		Thread.sleep(1000);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Clicks on Save and Send
		driver.findElement(RVSaveAndSendButton).click();
		//Clicks on save and send report
		wait.until(ExpectedConditions.visibilityOfElementLocated(RVSavePopupTitle)).click();
		driver.findElement(RVSavePopupComfirmButton).click();
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Verify status
		String status1 = wait.until(ExpectedConditions.visibilityOfElementLocated(RVReportSentStatusMessage)).getText();
		softly.assertThat(status1).as("test data").contains("Sent, waiting upon verification");
		//Creates the expected name of record
		String creation_date = driver.findElement(RVCreationDate).getText();
		creation_date= creation_date.substring(22, creation_date.length());
		String reportName = creation_date +"_"+ username + "_" + eventTitle(driver);
		//Verify email
		verifyEmailForVerifier (driver,username,reportName,k);
	}
	
	public String selectEmail(int k) throws Exception{
		
		UserManagement obj = new UserManagement();
		//dev admin
		if(k==1)
		{
			return obj.emailDev;
		}
		//dev nonadmin
		if(k==2)
		{
			return obj.emailDev;
		}
		//dev admin ie11
		if(k==3)
		{
			return obj.emailDevie11;
		}
		//dev nonadmin ie11
		if(k==4)
		{
			return obj.emailDevie11;
		}
		//asia admin
		if(k==5)
		{
			return obj.emailAsia;
		}
		//asia nonadmin
		if(k==6)
		{
			return obj.emailAsia;
		}
		//asia admin ie11
		if(k==7)
		{
			return obj.emailAsiaie11;
		}
		//asia nonadmin ie11
		if(k==8)
		{
			return obj.emailAsiaie11;
		}
		//us admin
		if(k==9)
		{
			return obj.emailUS;
		}
		//us nonadmin
		if(k==10)
		{
			return obj.emailUS;
		}
		//us admin ie11
		if(k==11)
		{
			return obj.emailUSie11;
		}
		//us nonadmin ie11
		else
		{
			return obj.emailUSie11;
		}
	}
	
	public void verifyEmailForVerifier (WebDriver driver,String username, String reportName, int k) throws Exception {
		
		UserManagement obj = new UserManagement();
		//Get current Time
        long currentTime = System.currentTimeMillis();
        //Add 15 minutes to it
        long time15 = currentTime + (15*60*1000);
		String SMTP_HOST = "smtp.gmail.com";
	    String EMAIL_ADDRESS = selectEmail(k);
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
        		obj.excelStore();
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
        StringBuffer sb=new StringBuffer();
        for (int i = 0; i < messageCount1; i++) {
        	Message message1 = messages1[i];
        	System.out.println(i);
            System.out.println("Mail Subject:- " + messages1[i].getSubject());
            System.out.println("From: " + message1.getFrom());
            System.out.println("Text: " + message1.getContent().toString());
            sb = new StringBuffer( message1.getContent().toString());
        }
        String emailText=sb.toString();
        System.out.println("\n ******** \n"+emailText+"\n ******** \n");
		//Verify content of email
        softly.assertThat(emailText).as("test data").contains(username);        
        //Modify reportname
        String s = emailText.replace((char)173,'*');
        System.out.println(s);
        String s1 = s.replace((char)60, '<');
        String s2 = s1.replace("<*", "<");
        System.out.println(s2);
        softly.assertThat(emailText).as("test data").contains(s2);
	}
	
	public void upload1stpictureChrome(WebDriver driver) throws Exception {
		
		WebDriverWait wait1 = new WebDriverWait(driver,20);
		//Uploads picture 1
		String filepath = "C:/Users/Public/Pictures/Sample Pictures/Chrysanthemum.jpg";
		driver.findElement(RV1stImageField).sendKeys(filepath);
		//Clears image
		wait1.until(ExpectedConditions.visibilityOfElementLocated(RV1stImageClearButton)).click();
		//Re-uploads same picture 1
		driver.findElement(RV1stImageField).sendKeys(filepath);
		//Clears image
		wait1.until(ExpectedConditions.visibilityOfElementLocated(RV1stImageClearButton)).click();
		//Re-uploads different picture 1
		driver.findElement(RV1stImageField).sendKeys("C:/Users/Public/Pictures/Sample Pictures/Desert.jpg");
		//Rotates image 1 twice
		wait1.until(ExpectedConditions.visibilityOfElementLocated(RV1stImageRotateButton)).click();
		Thread.sleep(1000);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(RV1stImageRotateButton)).click();
	}
	
	public void upload1stpictureFirefox(WebDriver driver) throws Exception {
		
		WebDriverWait wait1 = new WebDriverWait(driver,20);
		//Clicks on browse button of 1st picture
		driver.findElement(RV1stImageField).click();
		Thread.sleep(2000);
		//Uploads picture 1
		Process p=Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaDesert.exe");
		p.waitFor();
		Thread.sleep(4000);
		//Clears image
		wait1.until(ExpectedConditions.visibilityOfElementLocated(RV1stImageClearButton)).click();
		//Re-uploads same picture 1
		driver.findElement(RV1stImageField).click();
		Thread.sleep(2000);
		Process p1=Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaDesert.exe");
		p1.waitFor();
		Thread.sleep(4000);
		//Clears image
		wait1.until(ExpectedConditions.visibilityOfElementLocated(RV1stImageClearButton)).click();
		//Re-uploads different picture 1
		driver.findElement(RV1stImageField).click();
		Thread.sleep(2000);
		Process p2=Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaChrysanthemum.exe");
		p2.waitFor();
		Thread.sleep(4000);
		//Rotates image 1 twice
		wait1.until(ExpectedConditions.visibilityOfElementLocated(RV1stImageRotateButton)).click();
		Thread.sleep(1000);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(RV1stImageRotateButton)).click();
	}
	
	public void upload1stpictureIE10(WebDriver driver) throws Exception {
		
		WebDriverWait wait1 = new WebDriverWait(driver,20);
		Actions act = new Actions(driver);
		//Clicks twice on browse button of 1st picture
		WebElement element2 =  driver.findElement(RV1stImageField);
		act.doubleClick(element2).build().perform();
		Thread.sleep(3000);
		try{
		 try {
				  //Uploads picture 1
				  Process q=Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/IEChrysanthemum.exe");				  
				  q.waitFor();
		      }catch (UnhandledAlertException g){
		    	  System.out.println("Unexpected alert for picture 1");
				  driver.switchTo().alert().accept();
		      }
		    }catch (NoAlertPresentException g){			  
		  System.out.println ("No unexpected alerts for picture 1");
		     }			 
		 Thread.sleep(4000);
		//*Clears image
		wait1.until(ExpectedConditions.visibilityOfElementLocated(RV1stImageClearButton)).click();
		//Re-uploads picture 1
		act.doubleClick(element2).build().perform();
		Thread.sleep(3000);
		try{
		  try {
				  //Uploads picture 1
				  Process q=Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/IEDesert.exe");				  
				  q.waitFor();
		      }catch (UnhandledAlertException g){
		    	  System.out.println("Unexpected alert for picture 1");
				  driver.switchTo().alert().accept();
		      }
		    }catch (NoAlertPresentException g){			  
		  System.out.println ("No unexpected alerts for picture 1");
		    }			 
		Thread.sleep(4000);
		//Rotates image 1 twice
		wait1.until(ExpectedConditions.visibilityOfElementLocated(RV1stImageRotateButton)).click();
		Thread.sleep(1000);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(RV1stImageRotateButton)).click();
	}
	
	public void upload1stpictureIE11(WebDriver driver) throws Exception {
		
		WebDriverWait wait1 = new WebDriverWait(driver,20);
		//Clicks twice on browse button of 1st picture
		WebElement element2 =  driver.findElement(RV1stImageField);
		Actions act = new Actions(driver);
		act.doubleClick(element2).build().perform();
		Thread.sleep(3000);
		try{
		  try {
				  //Uploads picture 1
				  Process q=Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/IEChrysanthemum.exe");				  
				  q.waitFor();
		      }catch (UnhandledAlertException g){
		    	  System.out.println("Unexpected alert for picture 1");
				  driver.switchTo().alert().accept();
		      }
		    }catch (NoAlertPresentException g){			  
		  System.out.println ("No unexpected alerts for picture 1");
		    }			 
		Thread.sleep(4000);
		//Clears image
		wait1.until(ExpectedConditions.visibilityOfElementLocated(RV1stImageClearButton)).click();
		//Same image
		act.doubleClick(element2).build().perform();
		Thread.sleep(3000);
		try{
		  try {
				  //Uploads picture 1
				  Process q=Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/IEChrysanthemum.exe");				  
				  q.waitFor();
		      }catch (UnhandledAlertException g){
		    	  System.out.println("Unexpected alert for picture 1");
				  driver.switchTo().alert().accept();
		      }
		    }catch (NoAlertPresentException g){			  
		  System.out.println ("No unexpected alerts for picture 1");
		    }			 
		Thread.sleep(4000);
		//Clears image
		wait1.until(ExpectedConditions.visibilityOfElementLocated(RV1stImageClearButton)).click();
		//Re-uploads different picture 1
		act.doubleClick(element2).build().perform();
		Thread.sleep(3000);
		try{
		  try {
				  //Uploads picture 1
				  Process q=Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/IEDesert.exe");				  
				  q.waitFor();
		      }catch (UnhandledAlertException g){
		    	  System.out.println("Unexpected alert for picture 1");
				  driver.switchTo().alert().accept();
		      }
		   }catch (NoAlertPresentException g){			  
		System.out.println ("No unexpected alerts for picture 1");
		}			 
		Thread.sleep(4000);
		//Rotates image 1 twice
		wait1.until(ExpectedConditions.visibilityOfElementLocated(RV1stImageRotateButton)).click();
		Thread.sleep(1000);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(RV1stImageRotateButton)).click();
	}
		
    public void upload2ndpictureChrome(WebDriver driver) throws Exception {
		
    	WebDriverWait wait1 = new WebDriverWait(driver,20);
		//Uploads picture 2
		String file2 = "C:/Users/Public/Pictures/Sample Pictures/Desert.jpg";
		driver.findElement(RV2ndImageField).sendKeys(file2);
		//Clears image
		wait1.until(ExpectedConditions.visibilityOfElementLocated(RV2ndImageClearButton)).click();
		//Re-uploads same picture 2
		driver.findElement(RV2ndImageField).sendKeys(file2);
		//Clears image
		wait1.until(ExpectedConditions.visibilityOfElementLocated(RV2ndImageClearButton)).click();
		//Re-uploads different picture 2
		driver.findElement(RV2ndImageField).sendKeys("C:/Users/Public/Pictures/Sample Pictures/Chrysanthemum.jpg");
		//Rotates image 2 once
		wait1.until(ExpectedConditions.visibilityOfElementLocated(RV2ndImageRotateButton)).click();
	}
	
	public void upload2ndpictureFirefox(WebDriver driver) throws Exception {
		
		WebDriverWait wait1 = new WebDriverWait(driver,20);
		//Clicks on browse button of 2nd picture
		driver.findElement(RV2ndImageField).click();
		Thread.sleep(2000);
		//Uploads picture 2
		Process p3=Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaChrysanthemum.exe");
		p3.waitFor();
		Thread.sleep(8000);
		//Clears image
		wait1.until(ExpectedConditions.visibilityOfElementLocated(RV2ndImageClearButton)).click();
		//Re-uploads same picture 2
		driver.findElement(RV2ndImageField).click();
		Thread.sleep(2000);
		Process p2=Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaChrysanthemum.exe");
		p2.waitFor();
		Thread.sleep(8000);
		//Clears image
		wait1.until(ExpectedConditions.visibilityOfElementLocated(RV2ndImageClearButton)).click();
		//Re-uploads different picture 2
		driver.findElement(RV2ndImageField).click();
		Thread.sleep(2000);
		Process p1=Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaDesert.exe");
		p1.waitFor();
		Thread.sleep(8000);
		//Rotates image 2 once
		wait1.until(ExpectedConditions.visibilityOfElementLocated(RV2ndImageRotateButton)).click();
	}
	
	public void upload2ndpictureIE10(WebDriver driver) throws Exception {
		
		//Clicks twice on browse button of 2nd picture
		WebElement element =  driver.findElement(RV2ndImageField);
		Actions act = new Actions(driver);
		act.doubleClick(element).build().perform();
		Thread.sleep(3000);
		try{
		  try {
				//Uploads picture 2
				Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/IEChrysanthemum.exe");
		    	p.waitFor();
			}catch (UnhandledAlertException f){		
			  System.out.println("Unexpected alert for picture 2");
			  driver.switchTo().alert().accept();
		 }
		 }catch (NoAlertPresentException f){			  
		  System.out.println ("No unexpected alert for picture 2");
		 }
		 Thread.sleep(4000);
		 //Clears image
		 WebDriverWait wait1 = new WebDriverWait(driver,20);
		 wait1.until(ExpectedConditions.visibilityOfElementLocated(RV2ndImageClearButton)).click();
		 //Re-uploads picture 2
		 act.doubleClick(element).build().perform();
		 Thread.sleep(3000);
		 try{
		  try {
				//Uploads picture 2
				  Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/IEDesert.exe");
				  p.waitFor();
			  }catch (UnhandledAlertException f){		
				  System.out.println("Unexpected alert for picture 2");
				  driver.switchTo().alert().accept();
			  }
		  
		 }catch (NoAlertPresentException f){			  
		  System.out.println ("No unexpected alert for picture 2");
		 }
		 Thread.sleep(4000);
		 //Rotates image 2 once
		 wait1.until(ExpectedConditions.visibilityOfElementLocated(RV2ndImageRotateButton)).click();
	}
	
	public void upload2ndpictureIE11(WebDriver driver) throws Exception {
		
		  //Clicks twice on browse button of 2nd picture
		  WebElement element =  driver.findElement(RV2ndImageField);
		  Actions act = new Actions(driver);
		  act.doubleClick(element).build().perform();
		  Thread.sleep(3000);
		  try{
			  try {
					//Uploads picture 2
					  Process p =Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/IEChrysanthemum.exe");
					  p.waitFor();
				  }catch (UnhandledAlertException f){		
					  System.out.println("Unexpected alert for picture 2");
					  driver.switchTo().alert().accept();
				  }
			  
		  }catch (NoAlertPresentException f){			  
			  System.out.println ("No unexpected alert for picture 2");
		  }
		  Thread.sleep(4000);
		  //Clears image
		  WebDriverWait wait1 = new WebDriverWait(driver,20);
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(RV2ndImageClearButton)).click();
		  //Re-uploads same picture 2
		  act.doubleClick(element).build().perform();
		  Thread.sleep(3000);
		  try{
			  try {
					//Uploads picture 2
					  Process p =Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/IEChrysanthemum.exe");
					  p.waitFor();
				  }catch (UnhandledAlertException f){		
					  System.out.println("Unexpected alert for picture 2");
					  driver.switchTo().alert().accept();
				  }
			  
		  }catch (NoAlertPresentException f){			  
			  System.out.println ("No unexpected alert for picture 2");
		  }
		  Thread.sleep(4000);
		  //Clears image
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(RV2ndImageClearButton)).click();
		  //Re-uploads same picture 2
		  act.doubleClick(element).build().perform();
		  Thread.sleep(3000);
		  try{
			  try {
					//Uploads picture 2
					  Process p =Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/IEDesert.exe");
					  p.waitFor();
				  }catch (UnhandledAlertException f){		
					  System.out.println("Unexpected alert for picture 2");
					  driver.switchTo().alert().accept();
				  }
			  
		  }catch (NoAlertPresentException f){			  
			  System.out.println ("No unexpected alert for picture 2");
		  }
		  Thread.sleep(4000);
		  //Rotates image 2 once
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(RV2ndImageRotateButton)).click();
	}
	
	public void verifyDateTime(WebDriver driver) throws Exception {
		
		WebDriverWait wait1 = new WebDriverWait(driver,30);
		//Get time and date from RV location map
		String timeDate = wait1.until(ExpectedConditions.visibilityOfElementLocated(RVDateTimeAboveLocationImage)).getText();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
		int minute = cal.get(Calendar.MINUTE);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		//Verify if hour is correct
		softly.assertThat(timeDate).as("test data").contains(Integer.toString(hour));
		//Verify if minute is within 20 minutes of present time + or -
		if((minute>=minute-10) ||(minute<=minute+10))
		{
			System.out.println("Minute correct");
		}
		else softly.fail("Time minutes part is not within 20 minutes of actual time");
		//Verify if date is correct
		softly.assertThat(timeDate).as("test data").contains(dateFormat1.format(cal.getTime()));
		
	}
	
	public void verifierSelect(WebDriver driver, int k) throws Exception {
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		EiRCA obj = new EiRCA ();
		//dev admin
		if(k==1)
		{
			driver.findElement(RVVerifierField).sendKeys("qaarvverifier");
		}
		//dev nonadmin
		if(k==2)
		{
			driver.findElement(RVVerifierField).sendKeys("qaarvverifiernonadmin");
		}
		//dev admin ie11
		if(k==3)
		{
			driver.findElement(RVVerifierField).sendKeys("qaaie11rvverifier");
		}
		//dev nonadmin ie11
		if(k==4)
		{
			driver.findElement(RVVerifierField).sendKeys("qaaie11rvverifiernonadmin");
		}
		//asia admin
		if(k==5)
		{
			driver.findElement(RVVerifierField).sendKeys("qaarvverifier");
		}
		//asia nonadmin
		if(k==6)
		{
			driver.findElement(RVVerifierField).sendKeys("qaarvverifiernonadmin");
		}
		//asia admin ie11
		if(k==7)
		{
			driver.findElement(RVVerifierField).sendKeys("qaaie11rvverifier");
		}
		//asia nonadmin ie11
		if(k==8)
		{
			driver.findElement(RVVerifierField).sendKeys("qaaie11rvverifiernonadmin");
		}
		//us admin
		if(k==9)
		{
			driver.findElement(RVVerifierField).sendKeys("qaausrvverifier");
		}
		//us nonadmin
		if(k==10)
		{
			driver.findElement(RVVerifierField).sendKeys("qaausrvverifiernonadmin");
		}
		//us admin ie11
		if(k==11)
		{
			driver.findElement(RVVerifierField).sendKeys("qaausie11rvverifier");
		}
		//us nonadmin ie11
		if(k==12)
		{
			driver.findElement(RVVerifierField).sendKeys("qaausie11rvverifiernonadmin");
		}
	    //Selects the remote verifier		
		jse.executeScript("scroll(0, 1500)");
		WebElement select = driver.findElement(RVVerifierDropdown);
		WebElement option=select.findElement(obj.FirstSelectionUnderDropdown);
		option.click();
	}
	
	public void verifyLongitudeLatitude(WebDriver driver) throws Exception {
		
		WebDriverWait wait1 = new WebDriverWait(driver,30);
		//Get browser value
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
	    String browserName = cap.getBrowserName().toLowerCase();
	    //Get longitude latitude from rv location image
	    String location = wait1.until(ExpectedConditions.visibilityOfElementLocated(RVLatitudeLongitudeAboveLocationImage)).getText();
	    System.out.println(location); 
	    String url = driver.getCurrentUrl();
	    if(url.contains("kaleqa"))
	    {
	    	//Store in excel
		    excelStore(location,browserName);
	    }	    
		String address = "462 Stevens Avenue, Suite #306 Solana Beach, CA 92705";
		Thread.sleep(4000);
		String latLongs[] = getLatLongPositions(address);
		if((latLongs[0]!="") && (latLongs[1]!=""))
		{
	    System.out.println("Latitude: "+latLongs[0]+" and Longitude: "+latLongs[1]);
	    //Verify image appears
	    wait1.until(ExpectedConditions.visibilityOfElementLocated(RVLocationImage));
	    //check if longitude matches upto first decimal point
	    String longitude = latLongs[1].toString().substring(0, 5);
	    softly.assertThat(location).as("test data").contains(longitude);
	    //check if latitude matches upto first decimal point
	    String latitude = latLongs[0].toString().substring(0, 3);
	    softly.assertThat(location).as("test data").contains(latitude);
		}		
	}
	
	public void excelStore (String location, String browserName) throws Exception{
		
		File file = new File("E:/EmailError.xlsx");		
		// Open the Excel file
		FileInputStream ExcelFile = new FileInputStream(file);
		// Access the required test data sheet
		XSSFWorkbook ExcelWBook = new XSSFWorkbook(ExcelFile);
		XSSFSheet ExcelWSheet = ExcelWBook.getSheet("RV location DEV");
		//Get number of rows
		int rows = ExcelWSheet.getPhysicalNumberOfRows();
		//Get current date 
		SimpleDateFormat sfdate = new SimpleDateFormat("MM/dd/yyy HH:mm:ss a");
		Date date = new Date();
		System.out.println(sfdate.format(date));
		//Create a new row for only images
		Row row1 = ExcelWSheet.createRow(rows);
		row1.createCell(0).setCellValue(sfdate.format(date));
		row1.createCell(1).setCellValue(browserName);
		row1.createCell(2).setCellValue(location);
		//Close File input stream
		ExcelFile.close();
		//Create an object of FileOutputStream class to create write data in excel file
		FileOutputStream outputStream = new FileOutputStream(file);
		ExcelWBook.write(outputStream);
		ExcelWBook.close();
		outputStream.close();
	}
	
	public String[] getLatLongPositions(String address) throws Exception
	  {
	    int responseCode = 0;
	    String api = "http://maps.googleapis.com/maps/api/geocode/xml?address=" + URLEncoder.encode(address, "UTF-8") + "&sensor=true";
	    URL url = new URL(api);
	    HttpURLConnection httpConnection = (HttpURLConnection)url.openConnection();
	    httpConnection.connect();
	    responseCode = httpConnection.getResponseCode();
	    if(responseCode == 200)
	    {
	      DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();;
	      Document document = builder.parse(httpConnection.getInputStream());
	      XPathFactory xPathfactory = XPathFactory.newInstance();
	      XPath xpath = xPathfactory.newXPath();
	      XPathExpression expr = xpath.compile("/GeocodeResponse/status");
	      String status = (String)expr.evaluate(document, XPathConstants.STRING);
	      if(status.equals("OK"))
	      {
	         expr = xpath.compile("//geometry/location/lat");
	         String latitude = (String)expr.evaluate(document, XPathConstants.STRING);
	         expr = xpath.compile("//geometry/location/lng");
	         String longitude = (String)expr.evaluate(document, XPathConstants.STRING);
	         return new String[] {latitude, longitude};
	      }
	      else
	      {
	         System.out.println("Error from the API - response status: "+status);
	      }
	    }
	    return new String[] {"",""};
	  }
	
	public void shareReport(WebDriver driver, String verifier, String username,String password1,int y) throws Exception{
    	
    	WebDriverWait wait1 = new WebDriverWait(driver,60);
    	ErrorMeter obj = new ErrorMeter();
    	ShareCheck obj1 = new ShareCheck();
    	EiRCA obj2 = new EiRCA ();
    	String sharer = obj.decideSharer (y);
    	String sharerAdded = obj.decideSharerAdded (y);    	
		//Switches to the iframe
		wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
    	//Clicks on share button
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(RVShareButton)).click();
    	//Verifies if verifier displayed is disabled
    	WebElement verify = wait1.until(ExpectedConditions.visibilityOfElementLocated(RVSharePageVerifierBlock));
    	String s = verify.getAttribute("data-inset");
    	System.out.println(s);
    	if(s.equals("true")==false)
    		softly.fail("Verifier text box not suppose to be enabled");    	
    	//Enters verifier username and tries to add verifier
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(obj2.ShareTextBox)).sendKeys(verifier);
    	//Selects from dropdown
    	WebElement dropdown1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(obj2.ShareDropdown));
    	dropdown1.findElement(obj2.FirstSelectionUnderDropdown).click();
    	//Gets text from error pop up and verifies text
    	String error = wait1.until(ExpectedConditions.visibilityOfElementLocated(obj2.ConfirmPopupTitle)).getText();
    	softly.assertThat(error).as("test data").contains("Sorry, the current activity is already shared to user");
    	//Verifies cancel button not available
    	WebElement cancel = driver.findElement(obj2.ConfirmCancelButton);
    	if(cancel.isDisplayed()==true)
    		softly.fail("Cancel button not suppose to be displayed");
    	//Verifies if only ok button available and clicks on ok
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(obj2.ConfirmPopupButton)).click();
    	//Adds sharer
		//Enters sharer username
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(obj2.ShareTextBox)).clear();
    	Thread.sleep(1000);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(obj2.ShareTextBox)).sendKeys(sharer);
    	//Selects from dropdown
		WebElement dropdown = wait1.until(ExpectedConditions.visibilityOfElementLocated(obj2.ShareDropdown));
		dropdown.findElement(obj2.FirstSelectionUnderDropdown).click();
		//Clicks on add user
		wait1.until(ExpectedConditions.visibilityOfElementLocated(obj2.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(obj2.ConfirmPopupButton)).click();
		//Verifies user added
		String user=wait1.until(ExpectedConditions.visibilityOfElementLocated(obj2.SharerAdded)).getText();
		softly.assertThat(user).as("test data").isEqualTo(sharerAdded);		
		obj1.shareTwice (driver);
		//Clicks on save
		wait1.until(ExpectedConditions.visibilityOfElementLocated(obj2.ShareSaveButton)).click();
		//Wait for loading message to disappear
		obj1.loadingServer(driver);
		 //Checks the username of creator and verifier
		 WebElement creator = wait1.until(ExpectedConditions.visibilityOfElementLocated(RVReportCreatorUsername));
		 String creatorUsername= creator.getText();
		 System.out.println(creatorUsername);
		 softly.assertThat(username).as("test data").isSubstringOf(creatorUsername);
		 WebElement verifier1=wait1.until(ExpectedConditions.visibilityOfElementLocated(RVReportVerifierUsername));
		 String verifierUsername = verifier1.getText();
		 System.out.println(verifierUsername);
		 softly.assertThat(verifier).as("test data").isSubstringOf(verifierUsername);
		 //Calls the Share check function
		 obj1.receiptReport(driver, sharer, username, password1);
		 //Clicks on Remote Verification side panel
		 wait1.until(ExpectedConditions.visibilityOfElementLocated(RVSidePanel)).click();
			//Wait for loading message to disappear
			obj1.loadingServer(driver);
		 //Clicks on first newly created record
		 wait1.until(ExpectedConditions.visibilityOfElementLocated(RVNewlyCreatedFirstRecord)).click();;
    }
	
	public void downloadRecordChrome(WebDriver driver, String verifier, String username) throws Exception {
    	
		ShareCheck obj = new ShareCheck();
		EiRCA obj1 = new EiRCA();
		//deletes files in reports folder before starting to download
    	File file = new File("C://Users//IEUser//Downloads//reports//");
    	deleteFiles(file);	    	
	    WebDriverWait wait1 = new WebDriverWait(driver,60);
    	//Clicks on first newly created record
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(RVNewlyCreatedFirstRecord)).click();
		String window = driver.getWindowHandle();
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(RVDownloadButton)).click();
		//Wait for loading message to disappear		
		obj.loadingServer(driver);		
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(obj1.ConfirmPopupTitle)).click();
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(obj1.ConfirmPopupButton)).click();
    	Thread.sleep(7000);
    	pdfCheck(driver,verifier,username);
        for(String winHandle : driver.getWindowHandles()){
	    driver.switchTo().window(winHandle);
	    }
        driver.close();
    	driver.switchTo().window(window);
    	Thread.sleep(1000);
    		    	
    }
    
	public void downloadRecordFirefox(WebDriver driver, String verifier, String username) throws Exception {
    	
		EiRCA obj1 = new EiRCA();
		ShareCheck obj = new ShareCheck();
		//deletes files in reports folder before starting to download
    	File file = new File("C://Users//IEUser//Downloads//reports//");
    	deleteFiles(file);		  
	    WebDriverWait wait1 = new WebDriverWait(driver,60);
    	//Clicks on first newly created record
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(RVNewlyCreatedFirstRecord)).click();
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(RVDownloadButton)).click();
		//Wait for loading message to disappear		
		obj.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(obj1.ConfirmPopupTitle)).click();
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(obj1.ConfirmPopupButton)).click();
    	Thread.sleep(8000);
    	for(String winHandle : driver.getWindowHandles()){
    	    driver.switchTo().window(winHandle);
    	}
    	Thread.sleep(2000);
    	Robot robot = new Robot();
    	// press Ctrl+S the Robot's way
    	robot.keyPress(KeyEvent.VK_CONTROL);
    	robot.keyPress(KeyEvent.VK_S);
    	robot.keyRelease(KeyEvent.VK_CONTROL);
    	robot.keyRelease(KeyEvent.VK_S);
    	Process p= Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/PDFReportFirefox.exe");
    	p.waitFor();
    	pdfCheck(driver,verifier,username);
    	Thread.sleep(4000);
    	driver.close();
    	Thread.sleep(4000);
    	driver.switchTo().window(window);
    	driver.switchTo().defaultContent();
    		    	
    }
	
	public void downloadRecordIE(WebDriver driver, String verifier, String username) throws Exception {
    	
		ShareCheck obj = new ShareCheck();
		EiRCA obj1 = new EiRCA();
		//deletes files in reports folder before starting to download
    	File file = new File("C://Users//IEUser//Downloads//reports//");
    	deleteFiles(file);		  
	    WebDriverWait wait1 = new WebDriverWait(driver,60);
    	//Clicks on first newly created record
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(RVNewlyCreatedFirstRecord)).click();
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(RVDownloadButton)).click();
		//Wait for loading message to disappear		
		obj.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(obj1.ConfirmPopupTitle)).click();
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(obj1.ConfirmPopupButton)).click();
    	Thread.sleep(4000);
    	try {
			  Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/SavePdf.exe");
			  q.waitFor();
			  }catch (UnhandledAlertException f){	
				  System.out.println("Unexpected alert");
				  driver.switchTo().alert().accept();
				  
		  	  }catch (NoAlertPresentException f){
		  		  System.out.println ("No unexpected alert");
		  		  }
    	Thread.sleep(10000);
    	//pdf verification
    	pdfCheck(driver,verifier,username);
    	Thread.sleep(4000);
    	driver.switchTo().window(window);
    		    	
    }
	
	
	public void downloadRecordIE11(WebDriver driver, String verifier, String username) throws Exception {
    	
		ShareCheck obj = new ShareCheck();
		EiRCA obj1 = new EiRCA();
		//deletes files in reports folder before starting to download
    	File file = new File("C://Users//IEUser//Downloads//reports//");
    	deleteFiles(file);		  
	    WebDriverWait wait1 = new WebDriverWait(driver,60);
    	//Clicks on first newly created record
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(RVNewlyCreatedFirstRecord)).click();
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(RVDownloadButton)).click();
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(obj1.ConfirmPopupTitle)).click();
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(obj1.ConfirmPopupButton)).click();
    	Thread.sleep(4000);
    	try {
			  Process q = Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/SavePdf.exe");
			  q.waitFor();
			  }catch (UnhandledAlertException f){	
				  System.out.println("Unexpected alert");
				  driver.switchTo().alert().accept();
				  
		  	  }catch (NoAlertPresentException f){
		  		  System.out.println ("No unexpected alert");
		  		  }
    	Thread.sleep(10000);
    	//pdf verification
    	pdfCheck(driver,verifier,username);
    	Thread.sleep(4000);
    	driver.switchTo().window(window);
    		    	
    }
	
  public void deleteFiles(File folder) throws IOException {
        File[] files = folder.listFiles();
         for(File file: files){
                if(file.isFile()){
                    String fileName = file.getName();
                    boolean del= file.delete();
                    System.out.println(fileName + " : got deleted ? " + del);
                }else if(file.isDirectory()) {
                    deleteFiles(file);
                }
            }
        }
	
	public void pdfCheck(WebDriver driver, String verifier, String username) throws Exception {
		  List<String> results = new ArrayList<String>();
	      //Gets the file name which has been downloaded
	      File[] files = new File("C://Users//IEUser//Downloads//reports//").listFiles();
	      //If this pathname does not denote a directory, then listFiles() returns null. 
	      for (File file : files) {
	    	   if (file.isFile()) {
	    	      results.add(file.getName());
	    	   }
	      }
	      System.out.println(results.get(0));
	      //Loads the file to check if correct data is present
	      String fileName="C://Users//IEUser//Downloads//reports//"+results.get(0);
	      File oldfile = new File(fileName);
	      //Checks number of images in pdf
	      PDDocument pddoc= PDDocument.load(oldfile);
	      List<RenderedImage> images = new ArrayList<>();
	      images=getImagesFromPDF(pddoc);
	      System.out.println("Number of images: "+images.size());
	      softly.assertThat(images.size()).as("test data").isEqualTo(3);
	      //Checks text in pdf
	      String data = new PDFTextStripper().getText(pddoc);
	      List<String> ans= Arrays.asList(data.split("\r\n"));
	      String newData="";
	      for (int i = 0; i < ans.size(); i++)
	        {
	        	
	        	//System.out.println(ans.get(i));
	        	int n=ans.get(i).length()-1;
	        	if (ans.get(i).charAt(n)==' ')
	        		newData = newData+ans.get(i);
	        	if (ans.get(i).charAt(n)!=' ')
	        		newData = newData+" "+ans.get(i);
	        	
	      }
	      String newData2=newData.replace("  ", " ");
	      String newData1 = newData2.replace("$ ", "$");
	      System.out.println(newData1);
	      //Checks verifier
	      softly.assertThat(verifier).as("test data").isSubstringOf(newData1);
	      //Checks username
	      softly.assertThat(username).as("test data").isSubstringOf(newData1);
	      //Checks event title
	      softly.assertThat(eventTitle(driver)).as("test data").isSubstringOf(newData1);
	      //Checks verification details
	      softly.assertThat(details(driver)).as("test data").isSubstringOf(newData1);
	      //Close pdf
		  pddoc.close();
	  }
	 
	 public List<RenderedImage> getImagesFromPDF(PDDocument document) throws IOException {
	        List<RenderedImage> images = new ArrayList<>();
	    for (PDPage page : document.getPages()) {
	        images.addAll(getImagesFromResources(page.getResources()));
	    }

	    return images;
	}

	private List<RenderedImage> getImagesFromResources(PDResources resources) throws IOException {
	    List<RenderedImage> images = new ArrayList<>();

	    for (COSName xObjectName : resources.getXObjectNames()) {
	        PDXObject xObject = resources.getXObject(xObjectName);

	        if (xObject instanceof PDFormXObject) {
	            images.addAll(getImagesFromResources(((PDFormXObject) xObject).getResources()));
	        } else if (xObject instanceof PDImageXObject) {
	            images.add(((PDImageXObject) xObject).getImage());
	        }
	    }

	    return images;
	}
	
	public void verifyTextInHTML(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify report title
		String title=wait.until(ExpectedConditions.visibilityOfElementLocated(RVReportTitle)).getText();
		String r = title.replaceAll("\u00AD", "");
		softly.assertThat(r).as("test data").contains(eventTitle(driver));
		//Verify event details
		String details=wait.until(ExpectedConditions.visibilityOfElementLocated(RVReportEventDetails)).getText();
		String r1 = details.replaceAll("\u00AD", "");
		softly.assertThat(r1).as("test data").contains(details(driver));
	}
	
	public void markCritical(WebDriver driver,String username, String password1,int y) throws Exception{
    	
    	WebDriverWait wait1 = new WebDriverWait(driver,60);
    	ErrorMeter obj = new ErrorMeter();
    	ShareCheck obj1 = new ShareCheck();
		EiRCA obj2 = new EiRCA();
    	//Verify text in HTML
    	verifyTextInHTML(driver);
    	//Clicks on mark critical
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(obj2.MarkCritical)).click();
    	//Clicks on confirm change
		wait1.until(ExpectedConditions.visibilityOfElementLocated(obj2.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(obj2.ConfirmPopupButton)).click();
		//Checks if marked critical
		String critical=wait1.until(ExpectedConditions.visibilityOfElementLocated(RVMarkedCriticalText)).getText();
		softly.assertThat(critical).as("test data").contains("Critical");
		if(driver.findElement(RVMarkedCriticalText).isDisplayed())
			System.out.println("Marked critical");
		//Clicks on mark critical again
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(obj2.MarkCritical)).click();
    	//Clicks on confirm change
		wait1.until(ExpectedConditions.visibilityOfElementLocated(obj2.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(obj2.ConfirmPopupButton)).click();
		Thread.sleep(2000);
		if(driver.findElement(RVMarkedCriticalText).isDisplayed()==false)
		{
			System.out.println("Unmarked critical");
		}
		//Verify report not retrieved by shared to person	    
		String sharer = obj.decideSharer (y);
		obj1.checkCriticalNotification(driver, sharer, username, password1, softly);		
		//Clicks on rv side panel
		wait1.until(ExpectedConditions.visibilityOfElementLocated(RVSidePanel)).click();
		//Wait for loading message to disappear
		obj1.loadingServer(driver);
    	//Clicks on first newly created record
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(RVNewlyCreatedFirstRecord)).click();	
    }
	
	public void deleteNewRecord(WebDriver driver, String recordName, int y) throws Exception{
		  
		  Thread.sleep(2000);
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  ErrorMeter obj = new ErrorMeter();
		  ShareCheck obj1 = new ShareCheck();
		  EiRCA obj3 = new EiRCA ();
		  ShareCheck obj2 = new ShareCheck();
		  //Clicks on delete button
		  wait.until(ExpectedConditions.visibilityOfElementLocated(RVDeleteButton)).click();		 
		  wait.until(ExpectedConditions.visibilityOfElementLocated(obj3.ConfirmPopupTitle));
		  //Clicks on delete report
		  driver.findElement(obj2.ConfirmPopupButton).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.StickyNote));
		  Thread.sleep(2000);
		  driver.findElement(RVSidePanel).click();
			//Wait for loading message to disappear		  
			obj2.loadingServer(driver);
		  //Verify record deleted
		  //Get name of 1st record
		  String name = driver.findElement(RVNewlyCreatedFirstRecord).getText();
		  System.out.println(name);
		  if (name!=recordName)
			  System.out.println("Record deleted");
		  else
			  System.out.println("Record could not be deleted");
		  
		  while(true)
		  {
			  Thread.sleep(1000);
			  try{
			  if (driver.findElement(obj1.StickyNote).isDisplayed())
			  {
				  wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.StickyClose)).click();
				  
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
		  
		  //Verify report not retrieved by shared to person
	      String sharer = obj.decideSharer (y);
		  obj1.checkNoReportAfterDelete(driver, sharer, softly);	  			  
	  }
	
	public void upload2ndPicture(WebDriver driver) throws Exception{
		
		//Get browser name and version
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
	    String browserName = cap.getBrowserName().toLowerCase();
	    System.out.println(browserName);
	    String v = cap.getVersion().toString();
	    System.out.println(v);
	    if(browserName.equals("chrome"))
	    	upload2ndpictureChrome(driver);
	    if(browserName.equals("firefox"))
	    	upload2ndpictureFirefox(driver);
	    if(browserName.equals("internet explorer"))
	    {
	    	if(v.startsWith("10"))
	    		upload2ndpictureIE10(driver);
	    	if(v.startsWith("11"))
	    		upload2ndpictureIE11(driver);
	    }
	}
	
	public void upload1stPicture(WebDriver driver) throws Exception{
		
		//Get browser name and version
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
	    String browserName = cap.getBrowserName().toLowerCase();
	    System.out.println(browserName);
	    String v = cap.getVersion().toString();
	    System.out.println(v);
	    if(browserName.equals("chrome"))
	    	upload1stpictureChrome(driver);
	    if(browserName.equals("firefox"))
	    	upload1stpictureFirefox(driver);
	    if(browserName.equals("internet explorer"))
	    {
	    	if(v.startsWith("10"))
	    		upload1stpictureIE10(driver);
	    	if(v.startsWith("11"))
	    		upload1stpictureIE11(driver);
	    }
	}
	
	public List<String> createReport(WebDriver driver, String username, int k) throws Exception{
		
		  ShareCheck obj = new ShareCheck();
		  //Waits for black loading message to disappear
		  obj.loadingServer(driver);
		  //Clicks on Analysis 
		  try
		  {
			  driver.findElement(AnalysisLink).click();
		  }catch (UnhandledAlertException f){			  
			  driver.switchTo().alert().dismiss();
		  }
		  //Clicks on Remote Verification
		  driver.findElement(RVLink).click();
		  //Fills the mandatory fields
		  driver.findElement(RVEventTitle).sendKeys(eventTitle(driver));
		  driver.findElement(RVEventDetails).sendKeys(details(driver));
		  String ev1 = driver.findElement(RVEventTitle).getAttribute("value");
		  String ev2 = driver.findElement(RVEventDetails).getAttribute("value");
		  if ((ev1.equals(eventTitle(driver))==false))
		  {
			  driver.findElement(RVEventTitle).clear();
			  driver.findElement(RVEventTitle).sendKeys(eventTitle(driver));
		  }
		  if((ev2.equals(details(driver)))==false)
		  {
			  driver.findElement(RVEventDetails).clear();
			  driver.findElement(RVEventDetails).sendKeys(details(driver));
		  }
		  
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  //Select verifier
		  verifierSelect(driver,k);
		  Thread.sleep(1000);
		  String verifier= driver.findElement(RVVerifierValue).getAttribute("piivalue");
		  //Uploads picture 2
		  upload2ndPicture(driver);
		  //*
		  jse.executeScript("scroll(0, 250)");
		  Thread.sleep(3000);
		  //Uploads picture 1
		  upload1stPicture(driver);
		  //*
		  Thread.sleep(3000);
		  jse.executeScript("scroll(0, 0)");
		  //Verifies Date and time
		  verifyDateTime(driver);
		  //Verifies location of office
		  verifyLongitudeLatitude(driver);
		  //Verify status 
		  checkStatusReport(driver,username,k);
		  Thread.sleep(3000);
		  //Creates the expected name of record
		  String creation_date = driver.findElement(RVCreationDate).getText();
		  creation_date= creation_date.substring(22, creation_date.length());
		  String name = creation_date +"_"+ username + "_" + eventTitle(driver);
		  System.out.println("Expected name of record: " + name);
		  //Clicks on Remote Verification
		  driver.findElement(RVSidePanel).click();
		  Thread.sleep(3000);
		  //Gets the name of the record created
		  WebElement record = driver.findElement(RVNewlyCreatedFirstRecord);
		  String recordName = record.getText();
		  String r = recordName.replaceAll("\u00AD", "");
		  if (record.isDisplayed())
		  {
			  System.out.println("Record found: "+ recordName);
		  }
		  else
			  System.out.println ("Record not found.");
		  //Checks if the name displayed on record is same as expected
		  softly.assertThat(r).as("test data").isEqualTo(name);
		  return Arrays.asList(verifier,r);
	}
	
	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}

}
