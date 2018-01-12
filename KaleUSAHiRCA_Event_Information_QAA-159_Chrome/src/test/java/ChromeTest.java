import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.interactions.Actions;

public class ChromeTest {

	 private WebDriver driver;
	 private int login =0;
	 private String username = "jenkinsvmnonadmin";
	 private String password = "Kalejenkins@123";
	 private String reason1="I think I will buy the red car, or I will lease the blue one.";
	 SoftAssertions softly = new SoftAssertions();
	 @Rule
	    public ErrorCollector collector = new ErrorCollector();

	 @SuppressWarnings("deprecation")
	@Rule
	  public Timeout globalTimeout= new Timeout(800000);
	  
		@Before
		  public void beforeTest() throws MalformedURLException{
			  
			  System.out.println("Performing verification on event information page in HiRCA for non admin in Chrome");
			  System.setProperty("webdriver.chrome.driver","C:\\Users\\rramakrishnan\\DriversForSelenium\\chromedriver.exe");
			  ChromeOptions options = new ChromeOptions();
	          String chromeProfilePath="C:\\Users\\IEUser\\Chrome Profile\\Profile 1";
	          options.addArguments("user-data-dir="+chromeProfilePath);
	          HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
	          options.setExperimentalOption("prefs", chromeOptionsMap);
	          DesiredCapabilities cap = DesiredCapabilities.chrome();
	          cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
	          cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	          cap.setCapability(ChromeOptions.CAPABILITY, options);
	          chromeOptionsMap.put("plugins.plugins_disabled", new String[] {
	        		    "Chrome PDF Viewer"
	        		});
	          String downloadFilepath = "C:\\Users\\IEUser\\Downloads\\reports";
	          chromeOptionsMap.put("download.default_directory", downloadFilepath);
	          driver = new ChromeDriver(cap);
			  //Browser is maximized
			  driver.manage().window().maximize();
			  //Browser navigates to the KALE url
			  driver.navigate().to("https://kale.error-free.com/");
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
			  driver.findElement(By.id("pii-pw")).sendKeys(password);
			  //Sign in button is located and clicked
			  
			 String user = driver.findElement(By.id("pii-un")).getAttribute("value");
		  String pw = driver.findElement(By.id("pii-pw")).getAttribute("value");
		  int c=1;
		  if (user.equals(username)==true)
		  {
			  if(pw.equals(password)==true)
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
						  driver.findElement(By.id("pii-pw")).sendKeys(password);
						  //Sign in button is located and clicked
						  driver.findElement(By.id("pii-signin-button")).click();
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
							  driver.findElement(By.id("pii-signin-button")).click();
							  break;
						  }
						
					  }
				  }
			  
			  
		  }
		  }
			  
		      
		  
		    public void deleteNewRecord(String recordName) throws Exception{
			  
		      
			  WebDriverWait wait = new WebDriverWait(driver,40);
			  //Compares name of newly created record with expected name
			  String name1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).getText();
			  //Clicks on new record
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();
			  if(name1.equals(recordName))
			  {
			  //Clicks on delete button
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[3]"))).click();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title")));
			  //Clicks on delete report
			  driver.findElement(By.id("pii-user-home-dialog-confirmed")).click();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
			  Thread.sleep(2000);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-irca"))).click();
			  //Verify record deleted
			  //Click on 1st record
			  String name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).getText();
			  System.out.println(name);
			  if (name!=recordName)
				  System.out.println("Record deleted "+name);
			  else
				  System.out.println("Record could not be deleted");
			  }
			  else softly.fail("Record not deleted "+recordName);	
			  			  
		  }
		  public void saveNewReport() throws Exception{
		    	
		    	//Clicks on Open button
		    	WebDriverWait wait1 = new WebDriverWait(driver,30);
		    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a"))).click();
		    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		    	//Clicks on open report
		    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		    	//Clicks on Info tab
		    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-tab-0"))).click();
		    	//Changes the event title
		    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-title"))).clear();
		    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-title"))).sendKeys("changed title");
		    	//Clicks on Save
		    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))).click();
				//Clicks on Save report
			    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).click();
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-success")));
				Thread.sleep(1000);
				String creationDate = driver.findElement(By.id("pii-irca-event-repdatetime")).getAttribute("value");
				String newRecord=creationDate + "_"+username+"_"+ "changed title";
		        //Clicks on Saved activities
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-btn-savedactivities"))).click();
				Thread.sleep(2000);
				//call delete function and delete the record also before deleting compare the record name if correct record is getting deleted
				deleteNewRecord(newRecord);
				
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
		    
		    public void downloadRecord(String executive,String event_id,String text184, String text, String paragraph_investigators,String paragraph_background,String paragraph_timeline,String paragraph_problem, String get_date, String get_time, String get_dept, String creationDate) throws Exception {
		    	
		    	//deletes files in reports folder before starting to download
		    	File file = new File("C://Users//IEUser//Downloads//reports//");
		    	deleteFiles(file);
		    	WebDriverWait wait1 = new WebDriverWait(driver,60);
		    	//Clicks on first newly created record
		    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();
				String window = driver.getWindowHandle();
				//Clicks on download button
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).click();
				try{
					  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
					  wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
					 }catch (org.openqa.selenium.TimeoutException e)
					  {
						  
					  }
				//Clicks on open pdf report
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		    	Thread.sleep(3000);
		    	pdfCheck(executive,text184,text,paragraph_investigators,paragraph_background,paragraph_timeline,paragraph_problem,get_date,get_time,get_dept,creationDate);
		        for(String winHandle : driver.getWindowHandles()){
	    	    driver.switchTo().window(winHandle);
	    	    }
		        driver.close();
		    	driver.switchTo().window(window);
		    	Thread.sleep(1000);
		    		    	
		    }
		  
			public void pdfCheck(String executive,String text184, String text, String paragraph_investigators,String paragraph_background,String paragraph_timeline,String paragraph_problem, String get_date, String get_time, String get_dept, String creationDate) throws Exception{
		    	
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
		        String newData=null;
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
		       // System.out.println(newData);
		        //Verifies title
		        text184=text184.replace("  ", " ");
		        softly.assertThat("Event title "+text184).as("test data").isSubstringOf(newData);
		        //Verifies location of event
		        text=text.replace("  ", " ");
		        softly.assertThat(text).as("test data").isSubstringOf(newData);
		        //Verifies investigators data
		        paragraph_investigators=paragraph_investigators.replace("\n", "");
		        paragraph_investigators=paragraph_investigators.replace("  ", " ");
		        softly.assertThat("Investigators"+paragraph_investigators).as("test data").isSubstringOf(newData);
		        //Verifies background data
		        paragraph_background=paragraph_background.replace("\n", "");
		        paragraph_background=paragraph_background.replace("  ", " ");
		        softly.assertThat("Background information"+paragraph_background).as("test data").isSubstringOf(newData);
		        //Verifies Timeline data
		        paragraph_timeline=paragraph_timeline.replace("\n", "");
		        paragraph_timeline=paragraph_timeline.replace("  ", " ");
		        softly.assertThat("Timeline of event"+paragraph_timeline).as("test data").isSubstringOf(newData);
		        //Verifies Problem statement
		        paragraph_problem=paragraph_problem.replace("\n", "");
		        paragraph_problem=paragraph_problem.replace("  ", " ");
		        softly.assertThat("Problem statement"+paragraph_problem).as("test data").isSubstringOf(newData);
		        //Verifies date
		        softly.assertThat(get_date).as("test data").isSubstringOf(newData);
		        //Verifies time
		        softly.assertThat(get_time).as("test data").isSubstringOf(newData);
		        //Verifies Department
		        softly.assertThat(get_dept).as("test data").isSubstringOf(newData);
		        //Verfies creation date
		        softly.assertThat(creationDate).as("test data").isSubstringOf(newData);
		        //Verifies executive summary
		        executive=executive.replace("  ", " ");
		        softly.assertThat(executive).as("test data").isSubstringOf(newData);
		        //Verifies supporting reason in act of nature
		        reason1=reason1.replace("  ", " ");
		        softly.assertThat(reason1).as("test data").isSubstringOf(newData);
		        //Verifies HiRCA self checklist
		        softly.assertThat("General").as("test data").isSubstringOf(newData);
		        softly.assertThat("All involved parties interviewed and all relevant data collected?").as("test data").isSubstringOf(newData);
		        softly.assertThat("Past similar events examined?").as("test data").isSubstringOf(newData);
		        softly.assertThat("Triggering event and related LOPs identified?").as("test data").isSubstringOf(newData);
		        softly.assertThat("Triggering Event").as("test data").isSubstringOf(newData);
		        softly.assertThat("Error type involving the triggering event determined?").as("test data").isSubstringOf(newData);
		        softly.assertThat("Any equipment failure (if any) involving in the triggering event investigated for its triggering errors?").as("test data").isSubstringOf(newData);
		        softly.assertThat("Contributing factors determined?").as("test data").isSubstringOf(newData);
		        softly.assertThat("Root Causes").as("test data").isSubstringOf(newData);
		        softly.assertThat("Root causes meeting SUEP").as("test data").isSubstringOf(newData);
		        softly.assertThat("criteria?").as("test data").isSubstringOf(newData);
		        softly.assertThat("Root causes surviving the CHOP'N").as("test data").isSubstringOf(newData);
		        softly.assertThat("challenge?").as("test data").isSubstringOf(newData);
		        softly.assertThat("Levels of importance for root causes identified?").as("test data").isSubstringOf(newData);
		        softly.assertThat("Corrective Actions").as("test data").isSubstringOf(newData);
		        softly.assertThat("Recommended corrective actions covering all root causes and contributing factors?").as("test data").isSubstringOf(newData);
		        softly.assertThat("Recommended corrective actions cost effective?").as("test data").isSubstringOf(newData);
		        //Verifies for Root Cause
		        softly.assertThat("1.1 Was the triggering event a human error, an equipment failure, or an act of nature? Act of nature").as("test data").isSubstringOf(newData);
		        softly.assertThat("1.2 What was the type of human error? n/a n/a").as("test data").isSubstringOf(newData);
		        softly.assertThat("1.3 For a rule-based error, was the error intentional or unintentional? n/a n/a").as("test data").isSubstringOf(newData);
		        softly.assertThat("1.4 Was the unintentional error related to inattention-to-detail behavior or inadequate rules? n/a n/a").as("test data").isSubstringOf(newData);
		        softly.assertThat("1.5 If I were the error-maker, would I make the same error? n/a n/a").as("test data").isSubstringOf(newData);
		        softly.assertThat("1.6 When the error-maker violated the established standards or policies, was there other staff looking on? n/a n/a").as("test data").isSubstringOf(newData);
		        softly.assertThat("1.7 Could the error have been prevented by self check or independent check? n/a n/a").as("test data").isSubstringOf(newData);
		        softly.assertThat("1.8 Was the error-maker trained to manage error-prone mental states and high risk situations? n/a n/a").as("test data").isSubstringOf(newData);
		        softly.assertThat("1.9 Was the error-maker held accountable after the event by his or her supervisor or by management? n/a n/a").as("test data").isSubstringOf(newData);
		        softly.assertThat("1.10 If a PJB (or PSM, TO, MJB) was held, why was the participant not aware so that he or she could mitigate the risk? n/a n/a").as("test data").isSubstringOf(newData);
		        softly.assertThat("1.11 Why did this error occur now, and not before? n/a n/a").as("test data").isSubstringOf(newData);
		        softly.assertThat("1.12 If PJB (or PSM, TO, MJB) was not performed, why? n/a n/a").as("test data").isSubstringOf(newData);
		        softly.assertThat("1.13 Was the error contributed to by error-prone mental states and/ or high risk situations? n/a n/a").as("test data").isSubstringOf(newData);
		        softly.assertThat("1.14 Did the supervisor conduct routine meetings to discuss lessons learned? n/a n/a").as("test data").isSubstringOf(newData);
		        softly.assertThat("1.15 Did the event involve a single-point-vulnerability item? n/a n/a").as("test data").isSubstringOf(newData);
		        softly.assertThat("1.16 Was the error related to inadequate supervision? n/a n/a").as("test data").isSubstringOf(newData);
		        softly.assertThat("1.17 Did inadequate management by the manager contribute to this error? n/a n/a").as("test data").isSubstringOf(newData);
		        softly.assertThat("1.18 Was the error caused by incorrect rules? n/a n/a").as("test data").isSubstringOf(newData);
		        softly.assertThat("1.19 Was there a rising trend of similar errors? n/a n/a").as("test data").isSubstringOf(newData);
		        softly.assertThat("1.20 Was the error contributed to by changes during jobs? n/a n/a").as("test data").isSubstringOf(newData);
		        //Verify LOP failure inquiry
		        softly.assertThat("Were there LOPs in place to prevent the triggering event? No n/a").as("test data").isSubstringOf(newData);
		        softly.assertThat("2.21 What LOPs can prevent this event from happening? n/a n/a").as("test data").isSubstringOf(newData);
		        softly.assertThat("2.22 Was HiRCA").as("test data").isSubstringOf(newData);
		        softly.assertThat("adequate in leading this investigation? n/a n/a").as("test data").isSubstringOf(newData);
		        //Verify SUEP
		        softly.assertThat("Contributing factor(s)S: Substandard Practice?U: Under Management Control?E: Early in Event Sequence?P: Prevention Of Recurrence? n/a n/a n/a n/a n/a").as("test data").isSubstringOf(newData);
		        //Verify Missing LOPS
		        softly.assertThat("Missing LOPs No missing LOPs specified").as("test data").isSubstringOf(newData);
		        cosDoc.close();
		        pddoc.close();	      
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
		    
		  public void openCheckRecord(String executive,String event_id,String text184, String text, String paragraph_investigators,String paragraph_background,String paragraph_timeline,String paragraph_problem, String get_date, String get_time, String get_dept, String creationDate) throws Exception{
			  
			  WebDriverWait wait1 = new WebDriverWait(driver,30);
			  JavascriptExecutor jse = (JavascriptExecutor)driver;
			  //Clicks on first newly created record
			  driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a")).click();
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
			  softly.assertThat(eve_inv).as("test data").isEqualTo(paragraph_investigators);
			  //Checks for Report creation date data
			  String creation_date =  driver.findElement(By.xpath(".//*[@id='irca-rpt']/div/table/tbody/tr[8]/td[2]")).getText();
			  softly.assertThat(creation_date).as("test data").isEqualTo(creationDate);
			  //Checks for Problem statement data
			  String eve_prob =  driver.findElement(By.xpath(".//*[@id='irca-rpt']/div[2]/table/tbody/tr[2]/td[2]")).getText();
			  softly.assertThat(eve_prob).as("test data").isEqualTo(paragraph_problem);
			  //Checks for Timeline of event data
			  String eve_timeline =  driver.findElement(By.xpath(".//*[@id='irca-rpt']/div[2]/table/tbody/tr[3]/td[2]")).getText();
			  softly.assertThat(eve_timeline).as("test data").isEqualTo(paragraph_timeline);
			  //Checks for Background information data
			  String eve_back =  driver.findElement(By.xpath(".//*[@id='irca-rpt']/div[2]/table/tbody/tr[4]/td[2]")).getText();
			  softly.assertThat(eve_back).as("test data").isEqualTo(paragraph_background);
			  //Check for creator
		      String eve_creator =  driver.findElement(By.xpath(".//*[@id='irca-rpt']/div/table/tbody/tr[7]/td[2]")).getText();
		      softly.assertThat(username).as("test data").isSubstringOf(eve_creator);
		      System.out.println(eve_creator);
		      //Check for Executive summary
		      String eve_exec =  driver.findElement(By.xpath(".//*[@id='irca-rpt']/div[2]/table/tbody/tr/td[2]")).getText();
			  softly.assertThat(eve_exec).as("test data").isEqualTo(executive);
			  //Verify the n/a in LOPs
			  String lop1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[4]/table/tbody/tr/td[1]"))).getText();
			  softly.assertThat(lop1).as("test data").isEqualTo("n/a");
			  String lop2 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[4]/table/tbody/tr/td[2]"))).getText();
			  softly.assertThat(lop2).as("test data").isEqualTo("n/a");
			  String lop3 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[4]/table/tbody/tr/td[3]"))).getText();
			  softly.assertThat(lop3).as("test data").isEqualTo("n/a");
			  String lop4 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr/td[1]"))).getText();
			  softly.assertThat(lop4).as("test data").isEqualTo("n/a");
			  String lop5 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr/td[2]"))).getText();
			  softly.assertThat(lop5).as("test data").isEqualTo("n/a");
			  String lop6 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr/td[3]"))).getText();
			  softly.assertThat(lop6).as("test data").isEqualTo("n/a");
			  String lop7 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/table/tbody/tr/td"))).getText();
			  softly.assertThat(lop7).as("test data").isEqualTo("No missing LOPs specified");
			  //Verify root causes
			  String rc1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[1]/td[2]"))).getText();
			  softly.assertThat(rc1).as("test data").isEqualTo("Act of nature");
			  String rc2 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[1]/td[3]"))).getText();
			  softly.assertThat(rc2).as("test data").isEqualTo(reason1);
			  String rc3 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[2]/td[2]"))).getText();
			  softly.assertThat(rc3).as("test data").isEqualTo("n/a");
			  String rc4 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[2]/td[3]"))).getText();
			  softly.assertThat(rc4).as("test data").isEqualTo("n/a");
			  String rc5 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[3]/td[2]"))).getText();
			  softly.assertThat(rc5).as("test data").isEqualTo("n/a");
			  String rc6 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[3]/td[3]"))).getText();
			  softly.assertThat(rc6).as("test data").isEqualTo("n/a");
			  String rc7 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[4]/td[2]"))).getText();
			  softly.assertThat(rc7).as("test data").isEqualTo("n/a");
			  String rc8 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[4]/td[3]"))).getText();
			  softly.assertThat(rc8).as("test data").isEqualTo("n/a");
			  String rc9 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[2]"))).getText();
			  softly.assertThat(rc9).as("test data").isEqualTo("n/a");
			  String rc10 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[3]"))).getText();
			  softly.assertThat(rc10).as("test data").isEqualTo("n/a");
			  String rc11 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[6]/td[2]"))).getText();
			  softly.assertThat(rc11).as("test data").isEqualTo("n/a");
			  String rc12 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[6]/td[3]"))).getText();
			  softly.assertThat(rc12).as("test data").isEqualTo("n/a");
			  String rc13 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[7]/td[2]"))).getText();
			  softly.assertThat(rc13).as("test data").isEqualTo("n/a");
			  String rc14 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[7]/td[3]"))).getText();
			  softly.assertThat(rc14).as("test data").isEqualTo("n/a");
			  String rc15 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[8]/td[2]"))).getText();
			  softly.assertThat(rc15).as("test data").isEqualTo("n/a");
			  String rc16 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[8]/td[3]"))).getText();
			  softly.assertThat(rc16).as("test data").isEqualTo("n/a");
			  String rc17 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[9]/td[2]"))).getText();
			  softly.assertThat(rc17).as("test data").isEqualTo("n/a");
			  String rc18 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[9]/td[3]"))).getText();
			  softly.assertThat(rc18).as("test data").isEqualTo("n/a");
			  String rc19 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[10]/td[2]"))).getText();
			  softly.assertThat(rc19).as("test data").isEqualTo("n/a");
			  String rc20 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[10]/td[3]"))).getText();
			  softly.assertThat(rc20).as("test data").isEqualTo("n/a");
			  String rc21 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[11]/td[2]"))).getText();
			  softly.assertThat(rc21).as("test data").isEqualTo("n/a");
			  String rc22 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[11]/td[3]"))).getText();
			  softly.assertThat(rc22).as("test data").isEqualTo("n/a");
			  String rc23 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[12]/td[2]"))).getText();
			  softly.assertThat(rc23).as("test data").isEqualTo("n/a");
			  String rc24 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[12]/td[3]"))).getText();
			  softly.assertThat(rc24).as("test data").isEqualTo("n/a");
			  String rc25 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[13]/td[2]"))).getText();
			  softly.assertThat(rc25).as("test data").isEqualTo("n/a");
			  String rc26 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[13]/td[3]"))).getText();
			  softly.assertThat(rc26).as("test data").isEqualTo("n/a");
			  String rc27 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[14]/td[2]"))).getText();
			  softly.assertThat(rc27).as("test data").isEqualTo("n/a");
			  String rc28 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[14]/td[3]"))).getText();
			  softly.assertThat(rc28).as("test data").isEqualTo("n/a");
			  String rc29 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[15]/td[2]"))).getText();
			  softly.assertThat(rc29).as("test data").isEqualTo("n/a");
			  String rc30 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[15]/td[3]"))).getText();
			  softly.assertThat(rc30).as("test data").isEqualTo("n/a");
			  String rc31 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[16]/td[2]"))).getText();
			  softly.assertThat(rc31).as("test data").isEqualTo("n/a");
			  String rc32 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[16]/td[3]"))).getText();
			  softly.assertThat(rc32).as("test data").isEqualTo("n/a");
			  String rc33 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[17]/td[2]"))).getText();
			  softly.assertThat(rc33).as("test data").isEqualTo("n/a");
			  String rc34 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[17]/td[3]"))).getText();
			  softly.assertThat(rc34).as("test data").isEqualTo("n/a");
			  String rc35 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[18]/td[2]"))).getText();
			  softly.assertThat(rc35).as("test data").isEqualTo("n/a");
			  String rc36 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[18]/td[3]"))).getText();
			  softly.assertThat(rc36).as("test data").isEqualTo("n/a");
			  String rc37 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[19]/td[2]"))).getText();
			  softly.assertThat(rc37).as("test data").isEqualTo("n/a");
			  String rc38 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[19]/td[3]"))).getText();
			  softly.assertThat(rc38).as("test data").isEqualTo("n/a");
			  String rc39 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[20]/td[2]"))).getText();
			  softly.assertThat(rc39).as("test data").isEqualTo("n/a");
			  String rc40 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[20]/td[3]"))).getText();
			  softly.assertThat(rc40).as("test data").isEqualTo("n/a");
			  //Verify LOP failure inquiry
			  String lop8 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr/td[2]"))).getText();
			  softly.assertThat(lop8).as("test data").isEqualTo("No");
			  String lop9 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr/td[3]"))).getText();
			  softly.assertThat(lop9).as("test data").isEqualTo("n/a");
			  String lop10 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[2]/td[2]"))).getText();
			  softly.assertThat(lop10).as("test data").isEqualTo("n/a");
			  String lop11 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[2]/td[3]"))).getText();
			  softly.assertThat(lop11).as("test data").isEqualTo("n/a");
			  String lop12 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[3]/td[2]"))).getText();
			  softly.assertThat(lop12).as("test data").isEqualTo("n/a");
			  String lop13 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[3]/td[3]"))).getText();
			  softly.assertThat(lop13).as("test data").isEqualTo("n/a");
			  //Verify SUEP
			  String rc41 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr/td[1]"))).getText();
			  softly.assertThat(rc41).as("test data").isEqualTo("n/a");
			  String rc42 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr/td[2]"))).getText();
			  softly.assertThat(rc42).as("test data").isEqualTo("n/a");
			  String rc43 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr/td[3]"))).getText();
			  softly.assertThat(rc43).as("test data").isEqualTo("n/a");
			  String rc44 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr/td[4]"))).getText();
			  softly.assertThat(rc44).as("test data").isEqualTo("n/a");
			  String rc45 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr/td[5]"))).getText();
			  softly.assertThat(rc45).as("test data").isEqualTo("n/a");
			  //Verify HiRCA checklist
			  String rc46 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[1]/td[1]"))).getText();
			  softly.assertThat(rc46).as("test data").isEqualTo("General");
			  String rc47 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[1]/td[2]"))).getText();
			  softly.assertThat(rc47).as("test data").isEqualTo("All involved parties interviewed and all relevant data collected?");
			  String rc48 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[1]/td[3]"))).getText();
			  softly.assertThat(rc48).as("test data").isEqualTo("");
			  String rc49 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[2]/td[1]"))).getText();
			  softly.assertThat(rc49).as("test data").isEqualTo("");
			  String rc50 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[2]/td[2]"))).getText();
			  softly.assertThat(rc50).as("test data").isEqualTo("Past similar events examined?");
			  String rc51 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[2]/td[3]"))).getText();
			  softly.assertThat(rc51).as("test data").isEqualTo("");
			  String rc52 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[3]/td[1]"))).getText();
			  softly.assertThat(rc52).as("test data").isEqualTo("");
			  String rc53 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[3]/td[2]"))).getText();
			  softly.assertThat(rc53).as("test data").isEqualTo("Triggering event and related LOPs identified?");
			  String rc54 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[3]/td[3]"))).getText();
			  softly.assertThat(rc54).as("test data").isEqualTo("");
			  String rc55 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[4]/td[1]"))).getText();
			  softly.assertThat(rc55).as("test data").isEqualTo("Triggering Event");
			  String rc56 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[4]/td[2]"))).getText();
			  softly.assertThat(rc56).as("test data").isEqualTo("Error type involving the triggering event determined?");
			  String rc57 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[4]/td[3]"))).getText();
			  softly.assertThat(rc57).as("test data").isEqualTo("");
			  String rc58 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[5]/td[1]"))).getText();
			  softly.assertThat(rc58).as("test data").isEqualTo("");
			  String rc59 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[5]/td[2]"))).getText();
			  softly.assertThat(rc59).as("test data").isEqualTo("Any equipment failure (if any) involving in the triggering event investigated for its triggering errors?");
			  String rc60 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[5]/td[3]"))).getText();
			  softly.assertThat(rc60).as("test data").isEqualTo("");
			  String rc61 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[6]/td[1]"))).getText();
			  softly.assertThat(rc61).as("test data").isEqualTo("");
			  String rc62 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[6]/td[2]"))).getText();
			  softly.assertThat(rc62).as("test data").isEqualTo("Contributing factors determined?");
			  String rc63 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[6]/td[3]"))).getText();
			  softly.assertThat(rc63).as("test data").isEqualTo("");
			  String rc64 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[7]/td[1]"))).getText();
			  softly.assertThat(rc64).as("test data").isEqualTo("Root Causes");
			  String rc65 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[7]/td[2]"))).getText();
			  softly.assertThat(rc65).as("test data").contains("Root causes meeting SUEP");
			  softly.assertThat(rc65).as("test data").contains(" criteria?");
			  String rc66 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[7]/td[3]"))).getText();
			  softly.assertThat(rc66).as("test data").isEqualTo("");
			  String rc67 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[8]/td[1]"))).getText();
			  softly.assertThat(rc67).as("test data").isEqualTo("");
			  String rc68 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[8]/td[2]"))).getText();
			  softly.assertThat(rc68).as("test data").contains("Root causes surviving the CHOP'N");
			  softly.assertThat(rc68).as("test data").contains(" challenge?");
			  String rc69 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[8]/td[3]"))).getText();
			  softly.assertThat(rc69).as("test data").isEqualTo("");
			  String rc70 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[9]/td[1]"))).getText();
			  softly.assertThat(rc70).as("test data").isEqualTo("");
			  String rc71 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[9]/td[2]"))).getText();
			  softly.assertThat(rc71).as("test data").isEqualTo("Levels of importance for root causes identified?");
			  String rc72 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[9]/td[3]"))).getText();
			  softly.assertThat(rc72).as("test data").isEqualTo("");
			  String rc73 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[10]/td[1]"))).getText();
			  softly.assertThat(rc73).as("test data").isEqualTo("Corrective Actions");
			  String rc74 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[10]/td[2]"))).getText();
			  softly.assertThat(rc74).as("test data").contains("Recommended corrective actions covering all root causes and contributing factors?");
			  String rc75 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[10]/td[3]"))).getText();
			  softly.assertThat(rc75).as("test data").isEqualTo("");
			  String rc76 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[11]/td[1]"))).getText();
			  softly.assertThat(rc76).as("test data").isEqualTo("");
			  String rc77 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[11]/td[2]"))).getText();
			  softly.assertThat(rc77).as("test data").isEqualTo("Recommended corrective actions cost effective?");
			  String rc78 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[11]/td[3]"))).getText();
			  softly.assertThat(rc78).as("test data").isEqualTo("");
			  jse.executeScript("scroll(0, 3300)");
			  int n =3500;
			  //Checks the 5 images if appearing
			  for (int j=0; j<5; j++)
			  {				  
				  //Click on Supporting file details
				  Thread.sleep(500);
				  String id = "pii-hirca-h-event-report-filecollapsible-"+j;
				  driver.findElement(By.id(id)).click();
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
		  
		   public void rootCause() throws Exception {
			  
			  WebDriverWait wait1 = new WebDriverWait(driver,30);
			  //Clicks on next
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[15]/div/button"))).click();
			  //Click on Act of Nature
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div/label"))).click();
			  //Verify the texts on the options
			  String hum_err = driver.findElement(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div/label")).getText();
			  System.out.println(hum_err);
			  softly.assertThat(hum_err).as("test data").isEqualTo("Human error");
			  String eq_err = driver.findElement(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div/label")).getText();
			  System.out.println(eq_err);
			  softly.assertThat(eq_err).as("test data").isEqualTo("Equipment failure");
			  String nat_err = driver.findElement(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div/label")).getText();
			  System.out.println(nat_err);
			  softly.assertThat(nat_err).as("test data").isEqualTo("Act of nature");
			  String rc11 = driver.findElement(By.id("efi-irca-question")).getText();
			  System.out.println(rc11);
			  softly.assertThat(rc11).as("test data").contains("[1.1] Was the triggering event a human error, an equipment failure, or an act of nature?");
			  //Enter data in reason entry
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason1);
			  //Click on garbage can
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-clear"))).click();
			  //Clicks on clear answers
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
			  wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.id("pii-irca-dialog-title")));
			  //Click on Act of Nature
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div/label"))).click();
			  //Enter data in reason entry
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason1);
			  //Click on next
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			  //Clicks on Root Cause
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed2"))).click();
			  //Verify the n/a in LOPs
			  String lop1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[1]"))).getText();
			  System.out.println(lop1);
			  softly.assertThat(lop1).as("test data").isEqualTo("n/a");
			  String lop2 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[2]"))).getText();
			  System.out.println(lop2);
			  softly.assertThat(lop2).as("test data").isEqualTo("n/a");
			  String lop3 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[3]"))).getText();
			  System.out.println(lop3);
			  softly.assertThat(lop3).as("test data").isEqualTo("n/a");
			  String lop4 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[4]"))).getText();
			  System.out.println(lop4);
			  softly.assertThat(lop4).as("test data").isEqualTo("n/a");
			  String lop5 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[5]"))).getText();
			  System.out.println(lop5);
			  softly.assertThat(lop5).as("test data").isEqualTo("n/a");
			  //Click on skip
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
			  Thread.sleep(1000);
			  //Verify the n/a in LOPs
			  String lop6 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[1]"))).getText();
			  System.out.println(lop6);
			  softly.assertThat(lop6).as("test data").isEqualTo("n/a");
			  String lop7 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[2]"))).getText();
			  System.out.println(lop7);
			  softly.assertThat(lop7).as("test data").isEqualTo("n/a");
			  String lop8 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[3]"))).getText();
			  System.out.println(lop8);
			  softly.assertThat(lop8).as("test data").isEqualTo("n/a");
			  //Click on skip
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
			  Thread.sleep(1000);
			  //Clicks on check boxes from top to bottom and unchecks them from bottom to top
			  //Checks the check boxes
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[3]/div/input"))).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[3]/td[3]/div/input"))).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[4]/td[3]/div/input"))).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[5]/td[3]/div/input"))).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[6]/td[3]/div/input"))).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[7]/td[3]/div/input"))).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[8]/td[3]/div/input"))).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[9]/td[3]/div/input"))).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[10]/td[3]/div/input"))).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[11]/td[3]/div/input"))).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[12]/td[3]/div/input"))).click();
			  //Unchecks them all
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[12]/td[3]/div/input"))).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[11]/td[3]/div/input"))).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[10]/td[3]/div/input"))).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[9]/td[3]/div/input"))).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[8]/td[3]/div/input"))).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[7]/td[3]/div/input"))).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[6]/td[3]/div/input"))).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[5]/td[3]/div/input"))).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[4]/td[3]/div/input"))).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[3]/td[3]/div/input"))).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[3]/div/input"))).click();
			  //Click on skip
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
			  Thread.sleep(1000);
			  
			  
		  }
		@Test
		  public void SanityTest() throws Exception{
		  try{
			  JavascriptExecutor jse = (JavascriptExecutor)driver;
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
			  WebDriverWait wait = new WebDriverWait(driver,30);
			  //Clicks on Analysis 
			  try
			  {
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-a"))).click();
			  }catch (UnhandledAlertException f){			  
				  driver.switchTo().alert().dismiss();
			  }
			  //Clicks on HiRCA
			  driver.findElement(By.id("pii-a-menu-hirca")).click();
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
			  driver.findElement(By.id("efi-irca-button-save")).click();
			  WebDriverWait wait1 = new WebDriverWait(driver,30);
			  String error_save = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).getText();
			  if(error_save.equals("Please fix all errors mentioned in red."))
			  {
				  //Clicks on ok
				  driver.findElement(By.id("pii-irca-dialog-confirmed")).click();
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
			  String paragraph_investigators = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus eu lorem sapien. Donec molestie ligula nec diam mollis scelerisque ac et orci. Phasellus facilisis urna quis nibh faucibus, quis vestibulum nunc fringilla. Sed efficitur elit a nulla ultrices, at cursus ligula pharetra. Ut sollicitudin libero in nunc iaculis, ac mollis eros finibus. Nam iaculis pretium augue, vel tristique ligula sodales id. Maecenas sit amet tellus lobortis, pellentesque urna non, rutrum ante. Etiam enim quam, porta vel iaculis tincidunt, feugiat in nisl.@#$%&*()"
					  +"\n"
					  +"Donec gravida ante congue orci dictum, ut pretium velit elementum. Aliquam mattis sapien ut felis consequat tempor. Integer eget justo libero. Etiam hendrerit massa odio, non scelerisque leo fringilla nec. Curabitur ac magna dolor. Suspendisse mi nisi, dictum non dolor sit amet, venenatis tempor ipsum. Praesent maximus mauris tortor, ut hendrerit est pulvinar vitae. Aenean vel justo dignissim, scelerisque urna ultricies, hendrerit magna. Etiam elementum accumsan turpis ut efficitur. Aliquam luctus, nulla eget faucibus fermentum, tortor eros dignissim ante, vitae fermentum tellus ligula consectetur ligula. Etiam sagittis nisl mi, sit amet scelerisque eros venenatis sit amet. Fusce facilisis nisl nunc, eu euismod dui tristique nec. Donec lorem enim, sodales eu sem in, feugiat varius nunc. Phasellus cursus laoreet sapien, ac posuere tortor!?:;"
					  ;
			  //Investigators
			  driver.findElement(By.id("pii-irca-event-investigators")).sendKeys(paragraph_investigators);
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
			  driver.findElement(By.id("pii-irca-event-investigators")).sendKeys(paragraph_investigators);
			  
			  //Paragraph for Background info
			  String paragraph_background= "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
					  +"\n"+"\n"
					  +"Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. The Apache FontBox library is an open source Java tool to obtain low level information from font files. FontBox is a subproject of Apache PDFBox. The Apache PDFBox library is an open source Java tool for working with PDF documents. This artefact contains commandline tools using Apache PDFBox."
					  ;			 
			  //Background info
			  driver.findElement(By.id("pii-irca-event-bginfos")).sendKeys(paragraph_background);
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
			  driver.findElement(By.id("pii-irca-event-bginfos")).sendKeys(paragraph_background);
			  
			  //Paragraph for Timeline of event
			  String paragraph_timeline = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for lorem ipsum will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose. I have a house."
					  +"\n"+"\n"
					  +"There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The Apache PDFBox library is an open source Java tool for working with PDF documents. This artefact contains examples on how the library can be used."
					  ;
			  //Timeline of event
			  driver.findElement(By.id("pii-irca-event-events")).sendKeys(paragraph_timeline);
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
			  driver.findElement(By.id("pii-irca-event-events")).sendKeys(paragraph_timeline);
			  
			  //Paragraph for Problem Statement
			  String paragraph_problem = "But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil and pain can procure him some great pleasure. To take a trivial example, which of us ever undertakes laborious physical exercise, except to obtain some advantage from it."
					  +"\n"+"\n"
					  +"On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment, so blinded by desire, that they cannot foresee the pain and trouble that are bound to ensue; and equal blame belongs to those who fail in their duty through weakness of will, which is the same as saying through shrinking from toil and pain. These cases are perfectly simple and easy to distinguish. In a free hour, when our power of choice is untrammelled and when nothing prevents our being able to do what we like best, every pleasure is to be welcomed and every pain avoided. But in certain circumstances and owing to the claims of duty or the obligations of business it will frequently occur that pleasures have to be repudiated and annoyances accepted."
					  ;
			  //Problem Statement
			  driver.findElement(By.id("pii-irca-event-pbstatement")).sendKeys(paragraph_problem);
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
			  driver.findElement(By.id("pii-irca-event-pbstatement")).sendKeys(paragraph_problem);
			  
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
			  String text = "As it currently stands, this question is not a good fit for our Q&A format. We expect answers to be supported by facts.";
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
			  driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[3]/div/a")).click();
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
			  driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div/div/a")).click();
			  //Re enters text
			  driver.findElement(By.id("pii-irca-event-title")).sendKeys(text);
			  //Clears all text
			  driver.findElement(By.id("pii-irca-event-title")).clear();
			  //Re enters text
			  driver.findElement(By.id("pii-irca-event-title")).sendKeys(text);
			  			
			  //Checks event title text box limit
			  driver.findElement(By.id("pii-irca-event-title")).clear();
			  String text184 = "This list looks quite big but the setup is quite easy but time-consuming and once you are done with setup next time it will hardly take two min to start you Mobile test.";
			  driver.findElement(By.id("pii-irca-event-title")).sendKeys(text184);
			  Thread.sleep(1000);
			  String limit_text = driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div/span")).getText(); 
			  limit_text=limit_text.substring(5,8);
			  int limit = Integer.parseInt(limit_text);
			  System.out.println(limit_text+ " "+limit);
			  for(int i=text184.length()+1; i<=limit+1;i++)
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
			  driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[5]/div/a")).click();
			  //Close the popup
			  driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/a")).click();
			  Thread.sleep(2000);
			  //Click on date picker
			  driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[5]/div/a")).click();
			  //Check if the title is correct
			  String date_title=driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/div/h1")).getText();
			  System.out.println(date_title);
			  softly.assertThat(date_title).as("test data").isEqualTo("Date of event:");
			  //Click on + sign for next month
			  driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div/div[2]/a")).click();
			  //Click on - sign for previous month
			  driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div/div/a")).click();
			  //Select date as 1st
			  driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div[2]/div[2]/div")).click();
			  
			  //Check the time picker
			  Thread.sleep(1000);
			  driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[6]/div/a")).click();
			  //Close the popup
			  driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/a")).click();
			  Thread.sleep(2000);
			  //Click on time picker
			  driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[6]/div/a")).click();
			  //Check if the title is correct
			  String time_title=driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/div/h1")).getText();
			  System.out.println(time_title);
			  softly.assertThat(time_title).as("test data").isEqualTo("Time of event:");
			  //Click on + second
			  driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div/div[2]/div")).click();
			  //Click on - second
			  driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div/div[2]/div[3]")).click();
			  //Click on + minute
			  driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div/div/div")).click();
			  //Click on - minute
			  driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div/div/div[3]")).click();
			  Thread.sleep(2000);
			  //Check the error on minute
    		  driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div/div/div[2]/input")).sendKeys("666");
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
			  driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div[2]/div/a")).click();
			  
			  jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			  //Check if it allows for uploading more than one file
			  driver.findElement(By.id("pii-irca-addnewfile-button")).click();
			  String error_attach=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).getText();
			  softly.assertThat(error_attach).as("test data").isEqualTo("Please use existing empty supporting file form above");
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
			  
			  String filepath = "C:/Users/Public/Pictures/Sample Pictures/Chrysanthemum.jpg";
			  int n=450;
			  for (int j=0; j<5; j++)
			  {
				  
				  //Click on Supporting file details
				  Thread.sleep(500);
				  String id = "pii-irca-event-filecollapsible-"+j;
				  driver.findElement(By.id(id)).click();
				  //Uploads file
				  String file = "pii-irca-event-file-"+j;
				  WebElement l=driver.findElement(By.id(file));
				  Actions act= new Actions(driver);
				  act.moveToElement(l).build().perform();
				  l.sendKeys(filepath);
				  String img = "pii-irca-event-file-img-"+j;
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(img)));
				  if(driver.findElement(By.id(img)).isDisplayed())
				  {
					  //delete file
					  String del = "pii-irca-event-file-remove-"+j;
					  Thread.sleep(1000);
					  if (j==1||j==3)
				  {
				  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-filecollapsible-"+j))).sendKeys(Keys.ARROW_DOWN);
				  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-filecollapsible-"+j))).sendKeys(Keys.ARROW_DOWN);
				  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))).sendKeys(Keys.ARROW_DOWN);
				  }
					  driver.findElement(By.id(del)).click(); 
					  
					  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).click();
					  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
					  if(j!=0)
					  {
						  driver.findElement(By.id("pii-irca-addnewfile-button")).click();
						  Thread.sleep(1000);
						  n=n+80;
						  String scroll = "scroll(0,"+n+")";
						  jse.executeScript(scroll);
					  }
					  //Click on Supporting file details
					  driver.findElement(By.id(id)).click();
					  //Fill title and description
					  String title_id="pii-irca-event-file-title-"+j;
					  driver.findElement(By.id(title_id)).sendKeys("Title0"+j);
					  String desc = "pii-irca-event-file-description-"+j;
					  driver.findElement(By.id(desc)).sendKeys("Description0"+j);
					  //re-upload file
					  driver.findElement(By.id(file)).sendKeys(filepath);
					  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(img)));
					  Thread.sleep(3000);
					  if(driver.findElement(By.id(img)).isDisplayed())
					  {
						//rotate file
						  String rotate= "pii-irca-event-file-rotate-"+j;
						  for(int r=0;r<=j;r++)
							  {
								  Thread.sleep(2000);
								  if(j==4)
									  jse.executeScript("scroll(0, 1000)");
								  l=driver.findElement(By.id(rotate));
							      act.moveToElement(l).build().perform();
							  }
					  }
					  
					  Thread.sleep(3000);
					  if(driver.findElement(By.id(img)).isDisplayed())
					  {
						  jse.executeScript("scroll(0, 1600)");
						  //Click on attach another file
						  Thread.sleep(3000);
						 WebElement add= driver.findElement(By.id("pii-irca-addnewfile-button"));
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
					  driver.findElement(By.id(id)).click();
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
			  jse.executeScript("scroll(0,6500)");
			  //Clicks on next
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[15]/div/button"))).click();
			  //Clicks on back
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-back"))).click();
			  //Fills optional data
			  //Executive summary
			  String executive= "According to the 1993 Israel-Palestinian peace accords, the final status of Jerusalem is meant to be discussed in the latter stages of peace talks.";
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-execsummary"))).sendKeys(executive);
			  //Event id
			  String event_id="Its a small world after all";
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-crnumber"))).sendKeys(event_id);
			  //Clicks on Next and proceeds with Root Cause
			  jse.executeScript("scroll(0,6500)");
			  rootCause();
			  //Clicks on Save
			  driver.findElement(By.id("efi-irca-button-save")).click();
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
			  driver.findElement(By.id("efi-irca-button-save")).click();
			  //Clicks on Save report
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-success")));
			  Thread.sleep(1000);
			  //All changed supporting files saved successfully
			  //Clicks on Info tab
		      wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-tab-0"))).click();
			  //Create an expected name
			  String creationDate = driver.findElement(By.id("pii-irca-event-repdatetime")).getAttribute("value");
			  String name = creationDate + "_"+username+"_"+ text184 ;
			  System.out.println(name);
			  //Clicks on Saved activities
			  driver.findElement(By.id("efi-irca-btn-savedactivities")).click();
			  Thread.sleep(2000);
			  //Clicks on side panel
			  driver.findElement(By.id("pii-user-home-panel-btn-irca")).click();
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
			  //Opens new record and checks if entered data is same after being saved in report
			  openCheckRecord(executive,event_id,text184,text,paragraph_investigators,paragraph_background,paragraph_timeline,paragraph_problem,get_date,get_time,get_dept,creationDate);
			  Thread.sleep(2000);
			  //Opens record
			  openReport();
			  Thread.sleep(2000);
			  //Downloads record
			  downloadRecord(executive,event_id,text184,text,paragraph_investigators,paragraph_background,paragraph_timeline,paragraph_problem,get_date,get_time,get_dept,creationDate);
			  Thread.sleep(2000);
			  //Shares report
			  shareReport();
			  Thread.sleep(2000);
			  //Mark critical
			  markCritical();
			  Thread.sleep(2000);
			  //Creates new record by changing title
			  saveNewReport();
			  //Deletes the newly created record
			  deleteNewRecord(recordName);
			  
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
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-signout-button"))).click();
			  
			  afterTest();
			  }catch (TimeoutException e)
			  {
				  driver.quit();
			  }
		  	  
		  }
		  
		  		  
		 
		  public void afterTest() {
			  WebDriverWait wait = new WebDriverWait(driver,20);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-login-button")));
			  driver.quit();
			  softly.assertAll();
			  
		  }
		  

}
