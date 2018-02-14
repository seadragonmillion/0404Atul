import static org.junit.Assert.*;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;
import org.junit.Rule;
import org.junit.rules.Timeout;

import java.util.concurrent.TimeoutException;

import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.text.PDFTextStripper;
import org.assertj.core.api.SoftAssertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

public class IETest {

	private InternetExplorerDriver driver;
	private String username ="qaacfi";
	 private String password = "S2FsZTk0OTM1ODMwQA==";
	private String event_title="I think I will buy";
	private String details ="There was no ice cream./?.,><';:*-+()@#$%&01234567890";
	private String ie_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\IEDriverServer.exe";
	private String url = "https://kaleasia.error-free.com/";
	private int login =0;
	SoftAssertions softly = new SoftAssertions();
	  
	@SuppressWarnings("deprecation")
	@Rule
	  public Timeout globalTimeout= new Timeout(600000);
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Performing sanity test on Remote Verification in Internet Explorer");
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
	  
	  
	  public void deleteNewRecord(String recordName) throws Exception{
		  
		JavascriptExecutor jse = (JavascriptExecutor)driver;  
		//CLicks on first newly created record
		 // driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-rv']/ul/li[2]/a")).click();
		  Thread.sleep(2000);
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  //Clicks on delete button
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title")));
		  //Clicks on delete report
		  jse.executeScript("return document.getElementById('pii-user-home-dialog-confirmed').click();");
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  Thread.sleep(2000);
		  jse.executeScript("return document.getElementById('pii-user-home-panel-btn-rv').click();");
		  //Verify record deleted
		  //Click on 1st record
		  String name = driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-rv']/ul/li[2]/a")).getText();
		  System.out.println(name);
		  if (name!=recordName)
			  System.out.println("Record deleted");
		  else
			  System.out.println("Record could not be deleted");
		  			  
	  }

	   public void downloadRecord(String verifier) throws Exception {
	    	
		    //deletes files in reports folder before starting to download
	    	File file = new File("C://Users//rramakrishnan//Downloads//reports//");
	    	deleteFiles(file);		  
		    WebDriverWait wait1 = new WebDriverWait(driver,60);
	    	//Clicks on first newly created record
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-rv']/ul/li[2]/a"))).click();
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
	    	pdfCheck(verifier);
	    	Thread.sleep(4000);
	    	driver.switchTo().window(window);
	    		    	
	    }
	    
	    public void shareReport(String verifier) throws Exception{
	    	
	    	WebDriverWait wait1 = new WebDriverWait(driver,60);
			//Switches to the iframe
			wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
	    	//Clicks on share button
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[3]"))).click();
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
			//Waits for black loading message to disappear
			  try{
				  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
				  wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
				 }catch (org.openqa.selenium.TimeoutException e)
				  {
					  
				  }	
			 //Checks the username of creator and verifier
			 WebElement creator = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='rv-rpt']/div/div[2]/div")));
			 String creatorUsername= creator.getText();
			 System.out.println(creatorUsername);
			 softly.assertThat(username).as("test data").isSubstringOf(creatorUsername);
			 WebElement verifier1=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='rv-rpt']/div/div[2]/div[2]")));
			 String verifierUsername = verifier1.getText();
			 System.out.println(verifierUsername);
			 softly.assertThat(verifier).as("test data").isSubstringOf(verifierUsername);
	    }
	    
	    public void markCritical() throws Exception{
	    	
	    	WebDriverWait wait1 = new WebDriverWait(driver,60);
	    	//Clicks on mark critical
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div[2]/div/label"))).click();
	    	//Clicks on confirm change
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
			//Checks if marked critical
			String critical=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='rv-rpt']/div/div/table/tbody/tr/th/strong"))).getText();
			softly.assertThat(critical).as("test data").contains("Critical");
			if(driver.findElement(By.xpath(".//*[@id='rv-rpt']/div/div/table/tbody/tr/th/strong")).isDisplayed())
				System.out.println("Marked critical");
			//Clicks on mark critical again
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div[2]/div/label"))).click();
	    	//Clicks on confirm change
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
			Thread.sleep(2000);
			if(driver.findElement(By.xpath(".//*[@id='rv-rpt']/div/div/table/tbody/tr/th/strong")).isDisplayed()==false)
			{
				System.out.println("Unmarked critical");
			}
				
	    }
	  
	    public void pdfCheck(String verifier) throws Exception {
			  List<String> results = new ArrayList<String>();
		      //Gets the file name which has been downloaded
		      File[] files = new File("C://Users//rramakrishnan//Downloads//reports//").listFiles();
		      //If this pathname does not denote a directory, then listFiles() returns null. 
		      for (File file : files) {
		    	   if (file.isFile()) {
		    	      results.add(file.getName());
		    	   }
		      }
		      System.out.println(results.get(0));
		      //Loads the file to check if correct data is present
		      String fileName="C://Users//rramakrishnan//Downloads//reports//"+results.get(0);
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
		      newData=newData.replace("  ", " ");
		      System.out.println(newData);
		      //Checks verifier
		      softly.assertThat(verifier).as("test data").isSubstringOf(newData);
		      //Checks username
		      softly.assertThat(username).as("test data").isSubstringOf(newData);
		      //Checks event title
		      event_title=event_title.replace("  ", " ");
		      softly.assertThat(event_title).as("test data").isSubstringOf(newData);
		      //Checks verification details
		      details=details.replace("  ", " ");
		      softly.assertThat(details).as("test data").isSubstringOf(newData);
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
	  
	  @Test
	  public void SanityTest() throws Exception{
		  try{
		  Login();
		  Thread.sleep(5000);
		  System.out.println("Title after login: "+driver.getTitle());
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 
		  Thread.sleep(2000);
		  //Switches to the iframe
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
		  System.out.println("Waiting for page to load");
		  Thread.sleep(3000);
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  //Clicks on Analysis
		  jse.executeScript("return document.getElementById('pii-main-menu-button-a').click();");
		   try{
                       if (login==1)
                       {
                             WebDriverWait wait2 = new WebDriverWait(driver,20);
                             wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();
                       }
                }catch (NoSuchElementException e){
                       throw e;
                }
		  //Clicks on Remote Verification
		  jse.executeScript("return document.getElementById('pii-a-menu-rv').click();");
		  //Fills the mandatory fields
		  driver.findElement(By.id("pii-rv-tab-1-title")).sendKeys(event_title);
		  int i=0;
		  while(i<=details.length())
		  {
			  if(i+5<=details.length())
			  {
				  String ch= details.substring(i, i+5) ;
				  driver.findElement(By.id("pii-rv-tab-1-details")).sendKeys(ch);
			  }		
			  else
			  {
				  String ch= details.substring(i, details.length()) ;
				  driver.findElement(By.id("pii-rv-tab-1-details")).sendKeys(ch);
			  }	
			  i=i+5;
			  
		  }
		  Thread.sleep(2000);
		  String ev1 = driver.findElement(By.id("pii-rv-tab-1-title")).getAttribute("value");
		  String ev2 = driver.findElement(By.id("pii-rv-tab-1-details")).getAttribute("value");
		  if ((ev1.equals(event_title)==false))
		  {
			  driver.findElement(By.id("pii-rv-tab-1-title")).clear();
			  driver.findElement(By.id("pii-rv-tab-1-title")).sendKeys(event_title);
		  }
		  if((ev2.equals(details))==false)
		  {
			  driver.findElement(By.id("pii-rv-tab-1-details")).clear();
			  i=0;
			  while(i<=details.length())
			  {
				  if(i+5<=details.length())
				  {
					  String ch= details.substring(i, i+5) ;
					  driver.findElement(By.id("pii-rv-tab-1-details")).sendKeys(ch);
				  }		
				  else
				  {
					  String ch= details.substring(i, details.length()) ;
					  driver.findElement(By.id("pii-rv-tab-1-details")).sendKeys(ch);
				  }	
				  i=i+5;
				  
			  }
		  }
		  //Selects the remote verifier
		  driver.findElement(By.id("pii-rv-verifier-list-input")).sendKeys("qaa");
		  WebElement select = driver.findElement(By.id("pii-rv-verifier-list-ul"));
		  WebElement option = select.findElement(By.cssSelector(".ui-li-static.ui-body-inherit.ui-first-child"));
		  option.click();
		  Thread.sleep(1000);
		  String verifier= driver.findElement(By.id("pii-rv-verifier-name")).getAttribute("piivalue");
		  //Clicks twice on browse button of 2nd picture
		  WebElement element =  driver.findElement(By.id("pii-rv-imgperson-photo-input"));
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
		  //*Clears image
		  WebDriverWait wait1 = new WebDriverWait(driver,20);
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-imgperson-clear"))).click();
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
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-imgperson-rotate"))).click();
		  //*
		  jse.executeScript("scroll(0, 250)");
		  Thread.sleep(3000);
		  //Clicks twice on browse button of 1st picture
		  WebElement element2 =  driver.findElement(By.id("pii-rv-imgwork-photo-input"));
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
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-imgwork-clear"))).click();
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
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-imgwork-rotate"))).click();
		  Thread.sleep(1000);
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-imgwork-rotate"))).click();
		  //*
		  jse.executeScript("scroll(0, 0)");
		  //Clicks on Save and Send
		  jse.executeScript("return document.querySelector(\"[class='pii-rv-save-send pii-new-button pii-color-purple ui-block-c ui-btn ui-btn-inline']\").click();");
		  //Clicks on save and send report
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-dialog-title")));
		  jse.executeScript("return document.getElementById('pii-rv-dialog-confirmed').click();");
		  Thread.sleep(3000);
		  //Creates the expected name of record
		  String creation_date = driver.findElement(By.xpath(".//*[@id='rv-rpt']/div/div[2]/div[3]")).getText();
		  creation_date= creation_date.substring(22, creation_date.length());
		  String name = creation_date +"_"+ username + "_" + event_title;
		  System.out.println("Expected name of record: " + name);
		  //Clicks on Remote Verification
		  jse.executeScript("return document.getElementById('pii-user-home-panel-btn-rv').click();");
		  Thread.sleep(3000);
		  //Gets the name of the record created
		  WebElement record = driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-rv']/ul/li[2]/a"));
		  String recordName = record.getText();
		  if (record.isDisplayed())
		  {
			  System.out.println("Record found: "+ recordName);
		  }
		  else
			  System.out.println ("Record not found.");
		  //Checks if the name displayed on record is same as expected
		  assertEquals(name, recordName);
		  //Downloads record
		  downloadRecord(verifier);
		  //Shares report
		  shareReport(verifier);
		  //Mark critical
		  markCritical();
		  //Deletes the newly created record
		  deleteNewRecord(recordName);
		  //Logs out
		  jse.executeScript("return document.getElementById('pii-user-loginname').click();");
		  jse.executeScript("return document.getElementById('pii-signout-button').click();");
		  Thread.sleep(2000);	  
		  afterTest();
		  }catch (TimeoutException e)
			  {
				  driver.quit();
			  }
	  }

	  
	  public void afterTest() {
		   driver.quit();
		   softly.assertAll();
	  }

}
