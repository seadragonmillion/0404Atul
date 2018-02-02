import static org.junit.Assert.assertEquals;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Rule;
import org.junit.rules.Timeout;
import java.util.concurrent.TimeoutException;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Dimension;
import java.util.Base64;

public class FirefoxTest {

	private FirefoxDriver driver;
	private String username ="jenkins";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String gecko_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\geckodriver.exe";
	private String url = "https://kaledev.error-free.com/";
	private int login =0;
	private String title = "Sanity Test";
	SoftAssertions softly = new SoftAssertions();
	
	@SuppressWarnings("deprecation")
	@Rule
	  public Timeout globalTimeout= new Timeout(600000);
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		 System.out.println("Performing sanity test on SPV Error Meter in Firefox");
		 System.setProperty("webdriver.gecko.driver",gecko_path);
		 ProfilesIni ffProfiles = new ProfilesIni();
		 FirefoxProfile profile = ffProfiles.getProfile("HiRCAEvent");
		 profile.setPreference("browser.download.folderList", 2);
		 profile.setPreference("browser.download.dir", "C:\\Users\\rramakrishnan\\Downloads\\reports");
		 DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		 capabilities.setCapability(FirefoxDriver.PROFILE, profile);
		 driver = new FirefoxDriver(capabilities);
		 Dimension initialSize= driver.manage().window().getSize();
		 System.out.println(initialSize);
		 int height=initialSize.getHeight();
		 if(height<1900)
		 {
			//Browser is maximized
			driver.manage().window().maximize(); 
		 }
		 Dimension finalSize=driver.manage().window().getSize();
		 System.out.println(finalSize);
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
		  
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  //Clicks on delete button
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title")));
		  //Clicks on delete report
		  driver.findElement(By.id("pii-user-home-dialog-confirmed")).click();
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
	    	
		    //deletes files in reports folder before starting to download
	    	File file = new File("C://Users//rramakrishnan//Downloads//reports//");
	    	deleteFiles(file);
	    	WebDriverWait wait1 = new WebDriverWait(driver,60);
	    	//Clicks on first newly created record
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-epm']/ul/li[2]/a"))).click();
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
	    	Thread.sleep(6000);
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
	    	pdfCheck();
	    	Thread.sleep(4000);
	    	driver.close();
	    	Thread.sleep(4000);
	    	driver.switchTo().window(window);
	    	driver.switchTo().defaultContent();
	    		    	
	    }
	  public void pdfCheck() throws Exception{
	    	
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
	    	File file = new File(fileName);
	    	FileInputStream fis = new FileInputStream(file);
	    	PDFParser parser = new PDFParser(fis);
	        parser.parse();
	        COSDocument cosDoc= parser.getDocument();       
	        PDDocument pddoc= new PDDocument(cosDoc);
	        PDFTextStripper pdfStripper= new PDFTextStripper();
	        pdfStripper.setStartPage( 1 );
	        pdfStripper.setEndPage( Integer.MAX_VALUE );
	        String data = pdfStripper.getText(pddoc);
	        List<String> ans= Arrays.asList(data.split("\r\n"));
	        String newData1="";
	        for (int i = 0; i < ans.size(); i++)
	        {
	        	
	        	//System.out.println(ans.get(i));
	        	int n=ans.get(i).length()-1;
	        	if (ans.get(i).charAt(n)==' ')
	        		newData1 = newData1+ans.get(i);
	        	if (ans.get(i).charAt(n)!=' ')
	        		newData1 = newData1+" "+ans.get(i);
	        	
	        }
	        newData1=newData1.replace("  ", " ");
	        System.out.println(newData1);
	        //Verifies 0.00%
	        softly.assertThat("0.00%").as("test data").isSubstringOf(newData1);
	        //Verifies risk level as Low
	        softly.assertThat("risk level: low").as("test data").isSubstringOf(newData1);
	        //Verify Non-Issue
	        softly.assertThat("Non- Issue").as("test data").isSubstringOf(newData1);
	        
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
			Thread.sleep(1000);
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
			 softly.assertThat("0.00%").as("test data").isEqualTo(probabilityText);
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
			//Clicks on checkboxes in Procedure Tab
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-t-q1"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-t-q1"))).click();
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-t-q2"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-t-q2"))).click();
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-t-q3"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-t-q3"))).click();
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-t-q4"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-t-q4"))).click();
			
			//Fill in texts in Supporting reasons 
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			int i;
			String text = "Morbi ut massa elementum, faucibus lorem vitae, imperdiet lectus. Sed pellentesque mauris sit metus.";
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[2]/td[3]/textarea"))).clear();
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[3]/td[3]/textarea"))).clear();
			
			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[4]/td[3]/textarea"))).clear();
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[5]/td[3]/textarea"))).clear();
			
			//Fill in texts in Corrective Actions
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[2]/td[4]/textarea"))).clear();
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[3]/td[4]/textarea"))).clear();
			
			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[4]/td[4]/textarea"))).clear();
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-t']/table/tbody/tr[5]/td[4]/textarea"))).clear();
			//Checks error meter as 0%
			WebElement meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
			String meterText = meter.getText();
			System.out.println(meterText);
			softly.assertThat("0%").as("test data").isEqualTo(meterText);
			
			//Click on Activity of PAPE
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-taba-a"))).click();
			//Clicks on checkboxes in Activity Tab
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-a-q1"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-a-q1"))).click();
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-a-q2"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-a-q2"))).click();
			
			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-a-q3"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-a-q3"))).click();
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-a-q4"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-a-q4"))).click();
			
			//Fill in texts in Supporting reasons 
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[2]/td[3]/textarea"))).clear();
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[3]/td[3]/textarea"))).clear();
			
			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[4]/td[3]/textarea"))).clear();
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[5]/td[3]/textarea"))).clear();
			
			//Fill in texts in Corrective Actions
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[2]/td[4]/textarea"))).clear();
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[3]/td[4]/textarea"))).clear();
			
			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[4]/td[4]/textarea"))).clear();
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-a']/table/tbody/tr[5]/td[4]/textarea"))).clear();
			//Checks error meter as 0%
			meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
			meterText = meter.getText();
			System.out.println(meterText);
			softly.assertThat("0%").as("test data").isEqualTo(meterText);
			
			//Click on People of PAPE
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-taba-p"))).click();
			//Clicks on checkboxes in People Tab
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-p-q1"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-p-q1"))).click();
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-p-q2"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-p-q2"))).click();
			
			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-p-q3"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-p-q3"))).click();
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-p-q4"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-p-q4"))).click();
			
			//Fill in texts in Supporting reasons 
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[2]/td[3]/textarea"))).clear();
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[3]/td[3]/textarea"))).clear();
			
			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[4]/td[3]/textarea"))).clear();
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[5]/td[3]/textarea"))).clear();
			
			//Fill in texts in Corrective Actions
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[2]/td[4]/textarea"))).clear();
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[3]/td[4]/textarea"))).clear();
			
			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[4]/td[4]/textarea"))).clear();
						
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-p']/table/tbody/tr[5]/td[4]/textarea"))).clear();
			//Checks error meter as 0%
			meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
			meterText = meter.getText();
			System.out.println(meterText);
			softly.assertThat("0%").as("test data").isEqualTo(meterText);
			
			//Click on Environment of PAPE
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-taba-e"))).click();
			//Clicks on checkboxes in Environment Tab
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-e-q1"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-e-q1"))).click();
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-e-q2"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-e-q2"))).click();
			
			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-e-q3"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-e-q3"))).click();
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-e-q4"))).click();
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-e-q4"))).click();
			
			//Fill in texts in Supporting reasons 
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[2]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[2]/td[3]/textarea"))).clear();
			
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[3]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[3]/td[3]/textarea"))).clear();
			
			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[4]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[4]/td[3]/textarea"))).clear();
			
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[5]/td[3]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[5]/td[3]/textarea"))).clear();
			
			
			//Fill in texts in Corrective Actions
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[2]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[2]/td[4]/textarea"))).clear();
			
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[3]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[3]/td[4]/textarea"))).clear();
			
			jse.executeScript("scroll(0, 800)");
			Thread.sleep(2000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[4]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[4]/td[4]/textarea"))).clear();
						
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(text);
			for (i=0;i<10;i++)
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[5]/td[4]/textarea"))).sendKeys(Keys.BACK_SPACE);
			}
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-tab-e']/table/tbody/tr[5]/td[4]/textarea"))).clear();
			jse.executeScript("scroll(0, 0)");
			Thread.sleep(2000);
			//Checks error meter as 0%
			meter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-epm-progbar']/div/div/a")));
			meterText = meter.getText();
			System.out.println(meterText);
			softly.assertThat("0%").as("test data").isEqualTo(meterText);

		}
		
	@Test
	  public void SanityTest() throws Exception{
		   try{
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
    }catch (NoSuchElementException e){
           throw e;
    }
		  Thread.sleep(4000);
		  WebDriverWait wait = new WebDriverWait(driver,20);
		  //Clicks on Analysis 
		  try
		  {
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-a"))).click();
		  }catch (UnhandledAlertException f){			  
			  driver.switchTo().alert().dismiss();
		  }
		//Clicks on SPV Error meter
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-em"))).click();
		  //Select Purpose from dropdown
		  WebElement element = driver.findElement(By.id("pii-epm-select-purpose"));
		  Select s = new Select (element);
		  s.selectByVisibleText("PJB");
		  //Select Job type
		  element = driver.findElement(By.id("pii-epm-select-condition"));
		  Select s1 = new Select (element);
		  s1.selectByVisibleText("Analysis");
		  //Fills Job title
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-job-title"))).sendKeys(title);
		  String ev1= driver.findElement(By.id("pii-epm-job-title")).getAttribute("value");
		  if(ev1.equals(title)==false)
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-job-title"))).sendKeys(title);

		  //Click on next
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-btn-next"))).click();
		  Thread.sleep(2000);
		  pape();
		  Thread.sleep(2000);
		   //Click on finalize
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-btn-done"))).click();
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
				 
			  }
		  
		  //Logs out
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-signout-button"))).click();
		  Thread.sleep(2000);
		  afterTest();
		   }catch(TimeoutException e)
		   {
			   driver.manage().window().maximize();
			   System.out.println(e);
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
