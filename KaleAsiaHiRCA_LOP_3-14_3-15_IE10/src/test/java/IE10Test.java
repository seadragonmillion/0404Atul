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
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
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
import java.util.Random;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IE10Test {

	 private InternetExplorerDriver driver;
	 private int login =0;
	 private String username = "jenkinsvmnonadmin";
	 private String password = "Kalejenkins@123";
	 private String ie_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\IEDriverServer.exe";
	 private String url = "https://kaleasia.error-free.com/";
	 private String reason1="I think I will buy the red car, or I will lease the blue one.";
	 private String reason2="There was no ice cream in the freezer, nor did they have money to go to the store.";
	 private String reason3="He didnt want to go to the dentist, yet he went anyway.";
	 private String reason4="The mysterious diary records the voice.";
	 private String reason5="I am counting my calories, yet I really want dessert.";
	 private String reason6="This is the last random sentence I will be writing and I am going to stop mid-sent";
	 private String reason7="I checked to make sure that he was still alive.";
	 private String reason8="How was the math test?";
	 private String reason9="Abstraction is often one floor above you.";
	 private String reason10="She did her best to help him.";
	 private String reason11="Italy is my favorite country";
	 private String reason12="I plan to spend two weeks there next year.";
	 private String reason13="The memory we used to share is no longer coherent.";
	 private String reason14="The clock within this blog and the clock on my laptop are 1 hour different from each other.";
	 private String reason15="I want more detailed information.";
	 private String reason16="I am never at home on Sundays.";
	 private String reason17="I would have gotten the promotion, but my attendance wasnt good enough.";
	 private String reason18="I hear that Nancy is very pretty.";
	 private String reason19="Malls are great places to shop; I can find everything I need under one roof.";
	 private String reason20="She wrote him a long letter, but he didn't read it.";
	 private String reason21="She works two jobs to make ends meet; at least, that was her reason for not having time to join us.";
	 private String reason22="What was the person thinking when they discovered cow’s milk was fine for human consumption, and why did they do it in the first place!?";
	 private String reason23="Sometimes a random word just isn't enough, and that is where the random sentence generator comes into play.";
	 private String[] lopOptions1=new String[10];
	 private String[] lopOptions2=new String[10];
	 private String[] lopOptions3=new String[10];
	 SoftAssertions softly = new SoftAssertions();
	 private List<String> hml = new ArrayList<String>();
	 private List<String> level3 = new ArrayList<String>();
	 private HashMap<String,String> hm= new HashMap<String,String>();
	 private List<String> cr = new ArrayList<String>();
	 private HashMap<String,String> hm_cr= new HashMap<String,String>();
	 
	 @Rule
	    public ErrorCollector collector = new ErrorCollector();

	 @SuppressWarnings("deprecation")
	@Rule
	  public Timeout globalTimeout= new Timeout(800000);
	  
	 @Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("LOP selection 3.14 and 3.15 in HiRCA for non admin in IE");
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
		    	pdfCheck(executive,text184,text,paragraph_investigators,paragraph_background,paragraph_timeline,paragraph_problem,get_date,get_time,get_dept,creationDate);
		    	Thread.sleep(4000);
		    	driver.switchTo().window(window);
		    	    	
					    		    	
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
		        //System.out.println("Unformatted pdf data \n"+newData1);
		        String newData2= newData1.replace("LOP2: JIT reminder (signage, not-to do postings)Level of Importance Corrective Action(s)", "");
		        //System.out.println("NewData2 \n" +newData2);
		        String newData3= newData2.replace("LOP1: Briefings (PJB, MJB, PSM, TO, etc.)Level of Importance Corrective Action(s)", "");
		        String newData4= newData3.replace("LOP3: Other: "+reason3+"Level of Importance Corrective Action(s)", "");
		        String pattern="KALE™ Report Created on [0-9]{1,2}/[0-9]{1,2}/[0-9]{4}, [0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2} [A|P]M Page [0-9]{1,2} of [0-9]{1,2}";
				Pattern ptn = Pattern.compile(pattern);
				Matcher mtch = ptn.matcher(newData4);
				String newData5=mtch.replaceAll("");
				String pattern1="KALE™ Report Created on [A-Z,a-z]{3} [A-Z,a-z]{3} [0-9]{1,2} [0-9]{4} ";
				ptn = Pattern.compile(pattern1);
				mtch = ptn.matcher(newData5);
				String newData6=mtch.replaceAll("");
				String pattern3="Page [0-9]{1,2} of [0-9]{1,2}";
				ptn = Pattern.compile(pattern3);
				mtch = ptn.matcher(newData6);
				String newData7=mtch.replaceAll("");
				String newData8=newData7.replace("GMT+0000 (UTC) ", "");
		        String newData=newData8.replace("  ", " ");
		        System.out.println(newData);
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
		        //Verifies all text entered in LOPs
		        reason2=reason2.replace("  ", " ");
		        softly.assertThat(reason2).as("test data").isSubstringOf(newData);
		        reason3=reason3.replace("  ", " ");
		        softly.assertThat(reason3).as("test data").isSubstringOf(newData);
		        reason4=reason4.replace("  ", " ");
		        softly.assertThat(reason4).as("test data").isSubstringOf(newData);
		        reason5=reason5.replace("  ", " ");
		        softly.assertThat(reason5).as("test data").isSubstringOf(newData);
		        reason6=reason6.replace("  ", " ");
		        softly.assertThat(reason6).as("test data").isSubstringOf(newData);
		        reason7=reason7.replace("  ", " ");
		        softly.assertThat(reason7).as("test data").isSubstringOf(newData);
		        reason8=reason8.replace("  ", " ");
		        softly.assertThat(reason8).as("test data").isSubstringOf(newData);
		        reason9=reason9.replace("  ", " ");
		        softly.assertThat(reason9).as("test data").isSubstringOf(newData);
		        reason10=reason10.replace("  ", " ");
		        softly.assertThat(reason10).as("test data").isSubstringOf(newData);
		        reason11=reason11.replace("  ", " ");
		        softly.assertThat(reason11).as("test data").isSubstringOf(newData);
		        reason12=reason12.replace("  ", " ");
		        softly.assertThat(reason12).as("test data").isSubstringOf(newData);
		        reason13=reason13.replace("  ", " ");
		        softly.assertThat(reason13).as("test data").isSubstringOf(newData);
		        reason14=reason14.replace("  ", " ");
		        softly.assertThat(reason14).as("test data").isSubstringOf(newData);
		        reason15=reason15.replace("  ", " ");
		        softly.assertThat(reason15).as("test data").isSubstringOf(newData);
		        reason16=reason16.replace("  ", " ");
		        softly.assertThat(reason16).as("test data").isSubstringOf(newData);
		        reason17=reason17.replace("  ", " ");
		        softly.assertThat(reason17).as("test data").isSubstringOf(newData);
		        reason18=reason18.replace("  ", " ");
		        softly.assertThat(reason18).as("test data").isSubstringOf(newData);
		        reason19=reason19.replace("  ", " ");
		        softly.assertThat(reason19).as("test data").isSubstringOf(newData);
		        reason20=reason20.replace("  ", " ");
		        softly.assertThat(reason20).as("test data").isSubstringOf(newData);
		        reason21=reason21.replace("  ", " ");
		        softly.assertThat(reason21).as("test data").isSubstringOf(newData);
		        reason22=reason22.replace("  ", " ");
		        softly.assertThat(reason22).as("test data").isSubstringOf(newData);
		        reason23=reason23.replace("  ", " ");
		        softly.assertThat(reason23).as("test data").isSubstringOf(newData);
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
		        softly.assertThat("LOP 1 - Briefings (PJB, MJB, PSM, TO, etc.) ABC").as("test data").isSubstringOf(newData);
		        softly.assertThat(" Issues? TQA").as("test data").isSubstringOf(newData);
		        softly.assertThat(" Issues? Non-compliance issues (BURP").as("test data").isSubstringOf(newData);
		        softly.assertThat("LOP 2 - JIT reminder (signage, not- to do postings) ABC").as("test data").isSubstringOf(newData);
		        softly.assertThat("LOP 3 - Other: "+reason3+" ABC").as("test data").isSubstringOf(newData);
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
		        softly.assertThat("Were there LOPs in place to prevent the triggering event? Yes n/a").as("test data").isSubstringOf(newData);
		        softly.assertThat("2.0 What were the failed LOPs (3 max) that caused this event to happen?").isSubstringOf(newData);
		        softly.assertThat("Briefings (PJB, MJB, PSM, TO, etc.)").isSubstringOf(newData);
		        softly.assertThat("JIT reminder (signage, not-to do postings)").isSubstringOf(newData);
		        softly.assertThat("Other: "+reason3).as("test data").isSubstringOf(newData);
		        softly.assertThat("2.22 Was HiRCA").as("test data").isSubstringOf(newData);
		        softly.assertThat("adequate in leading this investigation? skipped n/a").as("test data").isSubstringOf(newData);
		        //Verify SUEP
		        softly.assertThat("Contributing factor(s)S: Substandard Practice?U: Under Management Control?E: Early in Event Sequence?P: Prevention Of Recurrence? n/a n/a n/a n/a n/a").as("test data").isSubstringOf(newData);
		        //Verify the Level3 selected and importance
		        for (int i=0;i<lopOptions1.length;i++)
		        {
		        	if(lopOptions1[i]==null || lopOptions1[i].isEmpty() || "null".equals(lopOptions1[i]) )
		        		continue;
		        	lopOptions1[i]=lopOptions1[i].replace("[", "");
		        	lopOptions1[i]=lopOptions1[i].replace("]", "");		        	
		        	System.out.println(lopOptions1[i]);
		        	if(hm.get(lopOptions1[i]).equals("None"))
		        		softly.assertThat(lopOptions1[i]).as("test data").isSubstringOf(newData);
		        	else
		        	{
		        		softly.assertThat(lopOptions1[i]).as("test data").isSubstringOf(newData);
		        		softly.assertThat(hm.get(lopOptions1[i])).as("test data").isSubstringOf(newData);
		        	}
		        }
		        for (int i=0;i<lopOptions2.length;i++)
		        {
		        	if(lopOptions2[i]==null || lopOptions2[i].isEmpty() || "null".equals(lopOptions2[i]) )
		        		continue;
		        	lopOptions2[i]=lopOptions2[i].replace("[", "");
		        	lopOptions2[i]=lopOptions2[i].replace("]", "");
		        	System.out.println(lopOptions2[i]);
		        	if(hm.get(lopOptions2[i]).equals("None"))
		        		softly.assertThat(lopOptions2[i]).as("test data").isSubstringOf(newData);
		        	else
		        	{
		        		softly.assertThat(lopOptions2[i]).as("test data").isSubstringOf(newData);
		        		softly.assertThat(hm.get(lopOptions2[i])).as("test data").isSubstringOf(newData);
		        	}
		        }
		        for (int i=0;i<lopOptions3.length;i++)
		        {
		        	if(lopOptions3[i]==null || lopOptions3[i].isEmpty() || "null".equals(lopOptions3[i]) )
		        		continue;
		        	lopOptions3[i]=lopOptions3[i].replace("[", "");
		        	lopOptions3[i]=lopOptions3[i].replace("]", "");
		        	System.out.println(lopOptions3[i]);
		        	if(hm.get(lopOptions3[i]).equals("None"))
		        		softly.assertThat(lopOptions3[i]).as("test data").isSubstringOf(newData);
		        	else
		        	{
		        		softly.assertThat(lopOptions3[i]).as("test data").isSubstringOf(newData);
		        		softly.assertThat(hm.get(lopOptions3[i])).as("test data").isSubstringOf(newData);
		        	}
		        }
		        //Checks for Corrective actions
		        for (String item: cr)
		        {
		        	softly.assertThat(item).as("test data").isSubstringOf(newData);
		        }
		        softly.assertThat("Reason2.1 Did equipment failure cause LOP to fail? ").as("test data").isSubstringOf(newData);
		        softly.assertThat(" Yes").as("test data").isSubstringOf(newData);
		        softly.assertThat(" No").as("test data").isSubstringOf(newData);
		        softly.assertThat("2.2 Was the LOP failure caused by inadequate rules, incorrect rules, or inattention-to-detail?").as("test data").isSubstringOf(newData); 
		        softly.assertThat("2.9 Was the intentional violation of LOP requirements caused by excessive burden?").as("test data").isSubstringOf(newData);
		        softly.assertThat("2.10 Was the intentional violation of LOP requirements caused by undue motivation?").as("test data").isSubstringOf(newData);
		        softly.assertThat("2.11 Was the intentional violation of LOP requirements caused by low perceived risk?").as("test data").isSubstringOf(newData);
		        softly.assertThat("2.12 Was the intentional violation of LOP requirements caused by tacit acceptance by peers?").as("test data").isSubstringOf(newData);
		        softly.assertThat("Error-proof design").as("test data").isSubstringOf(newData);
		        softly.assertThat("JIT alarm").as("test data").isSubstringOf(newData);
		        softly.assertThat("Passive protection (safety net, fall protection, air bags, safety belt, etc.)").as("test data").isSubstringOf(newData);
		        softly.assertThat("Review (PNR, Technical review)").as("test data").isSubstringOf(newData);
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
			  
			  WebDriverWait wait1 = new WebDriverWait(driver,5);
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
			  String eve_inv =  driver.findElement(By.xpath(".//*[@id='irca-rpt']/div/table/tbody/tr[7]/td[2]")).getText();
			  softly.assertThat(eve_inv).as("test data").isEqualTo(paragraph_investigators);
			  //Checks for Report creation date data
			  String creation_date =  driver.findElement(By.xpath(".//*[@id='irca-rpt']/div/table/tbody/tr[9]/td[2]")).getText();
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
		      String eve_creator =  driver.findElement(By.xpath(".//*[@id='irca-rpt']/div/table/tbody/tr[8]/td[2]")).getText();
		      softly.assertThat(username).as("test data").isSubstringOf(eve_creator);
		      System.out.println(eve_creator);
		      //Check for Executive summary
		      String eve_exec =  driver.findElement(By.xpath(".//*[@id='irca-rpt']/div[2]/table/tbody/tr/td[2]")).getText();
			  softly.assertThat(eve_exec).as("test data").isEqualTo(executive);
			  //Verify Root causes as n/a
			  String rca1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[4]/table/tbody/tr/td[1]"))).getText();
			  softly.assertThat(rca1).as("test data").isEqualTo("n/a");
			  String rca2 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[4]/table/tbody/tr/td[2]"))).getText();
			  softly.assertThat(rca2).as("test data").isEqualTo("n/a");
			  String rca3 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[4]/table/tbody/tr/td[3]"))).getText();
			  softly.assertThat(rca3).as("test data").isEqualTo("n/a");
			  //Verify n/a in contributing factors of root cause
			  String rca4 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr/td[1]"))).getText();
			  softly.assertThat(rca4).as("test data").isEqualTo("n/a");
			  String rca5 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr/td[2]"))).getText();
			  softly.assertThat(rca5).as("test data").isEqualTo("n/a");
			  String rca6 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr/td[3]"))).getText();
			  softly.assertThat(rca6).as("test data").isEqualTo("n/a");
			  //Verify failed LOPs
			  String lop1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/table[1]/tbody/tr/td[1]"))).getText();
			  softly.assertThat(lop1).as("test data").isEqualTo("Briefings (PJB, MJB, PSM, TO, etc.)");
			  String lop2 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/table[1]/tbody/tr/td[2]"))).getText();
			  softly.assertThat(lop2).as("test data").isEqualTo("JIT reminder (signage, not-to do postings)");
			  String lop3 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/table[1]/tbody/tr/td[3]"))).getText();
			  softly.assertThat(lop3).as("test data").isEqualTo("Other: "+reason3);
			  //Verify LOP1 3.17
			  int m=1;
			  String lopOptions1joint="";
			  String lopOptions2joint="";
			  String lopOptions3joint="";
			  for (int i=0;i<10;i++)
			  {
				  lopOptions1joint=lopOptions1joint + " "+ lopOptions1[i];
				  lopOptions2joint=lopOptions2joint + " "+ lopOptions2[i];
				  lopOptions3joint=lopOptions3joint + " "+ lopOptions3[i];
			  }
			  System.out.println(lopOptions1joint);
			  System.out.println(lopOptions2joint);
			  System.out.println(lopOptions3joint);
			  //Converts 2 lists of level3 and importance into a map
			  for(int i=0;i<hml.size();i++)
			  {
				  hm.put(level3.get(i), hml.get(i));
				  System.out.println(hm.containsKey(level3.get(i)) + " "+ hm.containsValue(hml.get(i))+ " "+i);
				  System.out.println(hm.get(level3.get(i))+ " "+level3.get(i));
			  }
			  //Converts 2 lists of level3 and corrective action into a map
			  for(int i=0;i<level3.size();i++)
			  {
				  hm_cr.put(level3.get(i), cr.get(i));
				  System.out.println(hm_cr.containsKey(level3.get(i)) + " "+ hm_cr.containsValue(cr.get(i))+ " "+i);
				  System.out.println(hm_cr.get(level3.get(i))+ " "+level3.get(i));
			  }
			  String lop4="";
			  String s;
			  while(true)
			  {
				  try{
					  lop4=driver.findElement(By.xpath(".//*[@id='irca-rpt']/table[2]/tbody/tr["+m+"]/td[1]")).getText();
					  System.out.println(lop4);
					  lopOptions1joint=lopOptions1joint.replace("[", "");
					  lopOptions1joint=lopOptions1joint.replace("]", "");
					  softly.assertThat(lopOptions1joint).as("test data").contains(lop4);
					  lop4=lop4.replace("  ", " ");
					  System.out.println(hm.containsKey(lop4));
					  s= hm.get(lop4);
				  }catch(org.openqa.selenium.NoSuchElementException u)
				  {
					  break;
				  }
				  String hmlLop=driver.findElement(By.xpath(".//*[@id='irca-rpt']/table[2]/tbody/tr["+m+"]/td[2]")).getText();
				  System.out.println(hmlLop);				  
				  System.out.println(s);
				  if(hmlLop.equals("High"))
				  {
					  softly.assertThat(s).as("test data").isEqualTo(hmlLop);
					  System.out.println(hmlLop);
				  }
				  if(hmlLop.equals("Medium"))
				  {
					  softly.assertThat(s).as("test data").isEqualTo(hmlLop);
					  System.out.println(hmlLop);
				  }
				  if(hmlLop.equals("Low"))
				  {
					  softly.assertThat(s).as("test data").isEqualTo(hmlLop);
					  System.out.println(hmlLop);
				  }
				  if(hmlLop.equals("")||hmlLop==""||hmlLop.equals(null))
				  {
					  softly.assertThat(s).as("test data").isEqualTo("None");
				  }
				  //Verify Corrective actions
				  String cr2=driver.findElement(By.xpath(".//*[@id='irca-rpt']/table[2]/tbody/tr["+m+"]/td[3]")).getText();
				  System.out.println(cr2);
				  softly.assertThat(cr2).as("test data").isEqualTo(hm_cr.get(lop4));
				  m=m+1;
			  }
			  int m1=m;
			  //Verify LOP2 3.16
			  m=1;
			  while(true)
			  {
				  try{
					  lop4=driver.findElement(By.xpath(".//*[@id='irca-rpt']/table[3]/tbody/tr["+m+"]/td[1]")).getText();
					  System.out.println(lop4);
					  lopOptions2joint=lopOptions2joint.replace("[", "");
					  lopOptions2joint=lopOptions2joint.replace("]", "");
					  softly.assertThat(lopOptions2joint).as("test data").contains(lop4);
					  lop4=lop4.replace("  ", " ");
					  System.out.println(hm.containsKey(lop4));
					  s= hm.get(lop4);
				  }catch(org.openqa.selenium.NoSuchElementException u)
				  {
					  break;
				  }
				  String hmlLop=driver.findElement(By.xpath(".//*[@id='irca-rpt']/table[3]/tbody/tr["+m+"]/td[2]")).getText();
				  System.out.println(hmlLop);
				  
				  if(hmlLop.equals("High"))
				  {
					  softly.assertThat(s).as("test data").isEqualTo(hmlLop);
					  System.out.println(hmlLop);
				  }
				  if(hmlLop.equals("Medium"))
				  {
					  softly.assertThat(s).as("test data").isEqualTo(hmlLop);
					  System.out.println(hmlLop);
				  }
				  if(hmlLop.equals("Low"))
				  {
					  softly.assertThat(s).as("test data").isEqualTo(hmlLop);
					  System.out.println(hmlLop);
				  }
				  if(hmlLop.equals("")||hmlLop==""||hmlLop.equals(null))
				  {
					  softly.assertThat(s).as("test data").isEqualTo("None");
				  }
				  //Verify Corrective actions
				  String cr2=driver.findElement(By.xpath(".//*[@id='irca-rpt']/table[3]/tbody/tr["+m+"]/td[3]")).getText();
				  System.out.println(cr2);
				  softly.assertThat(cr2).as("test data").isEqualTo(hm_cr.get(lop4));
				  m=m+1;
			  }
			  int m2=m;
			  //Verify additional LOPs needed to block triggering events
			  String lop23=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/table[5]/tbody/tr[1]/td[1]"))).getText();
			  softly.assertThat(lop23).as("test data").isEqualTo("Briefings (PJB, MJB, PSM, TO, etc.)");
			  String lop24=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/table[5]/tbody/tr[1]/td[2]"))).getText();
			  softly.assertThat(lop24).as("test data").isEqualTo("Error-proof design");
			  String lop25=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/table[5]/tbody/tr[1]/td[3]"))).getText();
			  softly.assertThat(lop25).as("test data").isEqualTo("JIT alarm");
			  String lop26=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/table[5]/tbody/tr[2]/td[1]"))).getText();
			  softly.assertThat(lop26).as("test data").isEqualTo("Passive protection (safety net, fall protection, air bags, safety belt, etc.)");
			  String lop27=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/table[5]/tbody/tr[2]/td[2]"))).getText();
			  softly.assertThat(lop27).as("test data").isEqualTo("Review (PNR, Technical review)");
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
			  //Verify LOP Failure Inquiry
			  String lop7 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr/td[2]"))).getText();
			  softly.assertThat(lop7).as("test data").isEqualTo("Yes");
			  String lop8 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr/td[3]"))).getText();
			  softly.assertThat(lop8).as("test data").isEqualTo("n/a");
			  String lop9 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[2]/td[2]/ul/li[1]"))).getText();
			  softly.assertThat(lop9).as("test data").contains("Briefings (PJB, MJB, PSM, TO, etc.)");
			  lop9 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[2]/td[2]/ul/li[2]"))).getText();
			  softly.assertThat(lop9).as("test data").contains("JIT reminder (signage, not-to do postings)");
			  lop9 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[2]/td[2]/ul/li[3]"))).getText();
			  softly.assertThat(lop9).as("test data").contains("Other: "+reason3);
			  String lop10 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[2]/td[3]"))).getText();
			  softly.assertThat(lop10).as("test data").isEqualTo(reason2);
			  String lop11 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[3]/td[2]"))).getText();
			  softly.assertThat(lop11).as("test data").isEqualTo("skipped");
			  String lop12 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[3]/td[3]"))).getText();
			  softly.assertThat(lop12).as("test data").isEqualTo("n/a");
			  //Verify LOP1 
			  String lop13 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr[1]/td[2]/ul/li"))).getText();
			  softly.assertThat(lop13).as("test data").isEqualTo("No");
			  String lop14 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr[1]/td[3]"))).getText();
			  softly.assertThat(lop14).as("test data").isEqualTo(reason4);
			  String lop28 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr[2]/td[2]/ul/li"))).getText();
			  softly.assertThat(lop28).as("test data").isEqualTo("No");
			  String lop29 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr[2]/td[3]"))).getText();
			  softly.assertThat(lop29).as("test data").isEqualTo(reason5);
			  String lop30 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr[3]/td[2]/ul/li"))).getText();
			  softly.assertThat(lop30).as("test data").isEqualTo("No");
			  String lop31 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr[3]/td[3]"))).getText();
			  softly.assertThat(lop31).as("test data").isEqualTo(reason6);
			  String lop32 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr[4]/td[2]/ul/li"))).getText();
			  softly.assertThat(lop32).as("test data").isEqualTo("No");
			  String lop33 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr[4]/td[3]"))).getText();
			  softly.assertThat(lop33).as("test data").isEqualTo(reason7);
			  String lop34 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr[5]/td[2]/ul/li"))).getText();
			  softly.assertThat(lop34).as("test data").isEqualTo("Yes");
			  String lop35 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr[5]/td[3]"))).getText();
			  softly.assertThat(lop35).as("test data").isEqualTo(reason8);
			  m=1;
			  while(m<=m1)
			  {
				  try{
					  String lop15=driver.findElement(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr[6]/td/div/table/tbody/tr["+m+"]/td[1]")).getText();
					  lopOptions1joint=lopOptions1joint.replace("[", "");
					  lopOptions1joint=lopOptions1joint.replace("]", "");
					  softly.assertThat(lopOptions1joint).as("test data").contains(lop15);
					  String lop16=driver.findElement(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr[6]/td/div/table/tbody/tr["+m+"]/td[2]")).getText();
					  softly.assertThat(lop16).as("test data").isEqualTo(reason9);
				  }catch(org.openqa.selenium.NoSuchElementException u)
				  {
					  break;
				  }
				  m=m+1;
			  }
			  String lop36 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr[7]/td[2]"))).getText();
			  softly.assertThat(lop36).as("test data").isEqualTo("skipped");
			  String lop37 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr[7]/td[3]"))).getText();
			  softly.assertThat(lop37).as("test data").isEqualTo("n/a");
			  //Verify LOP2
			  String lop17 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[9]/table/tbody/tr[1]/td[2]/ul/li"))).getText();
			  softly.assertThat(lop17).as("test data").isEqualTo("No");
			  String lop18 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[9]/table/tbody/tr[1]/td[3]"))).getText();
			  softly.assertThat(lop18).as("test data").isEqualTo(reason10);
			  String lop19 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[9]/table/tbody/tr[2]/td[2]/ul/li"))).getText();
			  softly.assertThat(lop19).as("test data").isEqualTo("No");
			  String lop20 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[9]/table/tbody/tr[2]/td[3]"))).getText();
			  softly.assertThat(lop20).as("test data").isEqualTo(reason11);
			  String lop38 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[9]/table/tbody/tr[3]/td[2]/ul/li"))).getText();
			  softly.assertThat(lop38).as("test data").isEqualTo("No");
			  String lop39 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[9]/table/tbody/tr[3]/td[3]"))).getText();
			  softly.assertThat(lop39).as("test data").isEqualTo(reason12);
			  String lop40 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[9]/table/tbody/tr[4]/td[2]/ul/li"))).getText();
			  softly.assertThat(lop40).as("test data").isEqualTo("No");
			  String lop41 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[9]/table/tbody/tr[4]/td[3]"))).getText();
			  softly.assertThat(lop41).as("test data").isEqualTo(reason13);
			  String lop42 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[9]/table/tbody/tr[5]/td[2]/ul/li"))).getText();
			  softly.assertThat(lop42).as("test data").isEqualTo("No");
			  String lop43 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[9]/table/tbody/tr[5]/td[3]"))).getText();
			  softly.assertThat(lop43).as("test data").isEqualTo(reason14);
			  String lop44 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[9]/table/tbody/tr[6]/td[2]/ul/li"))).getText();
			  softly.assertThat(lop44).as("test data").isEqualTo("Yes");
			  String lop45 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[9]/table/tbody/tr[6]/td[3]"))).getText();
			  softly.assertThat(lop45).as("test data").isEqualTo(reason15);
			  m=1;
			  while(m<=m2)
			  {
				  try{
					  String lop21=driver.findElement(By.xpath(".//*[@id='irca-rpt']/div[9]/table/tbody/tr[7]/td/div/table/tbody/tr["+m+"]/td[1]")).getText();
					  lopOptions2joint=lopOptions2joint.replace("[", "");
					  lopOptions2joint=lopOptions2joint.replace("]", "");
					  softly.assertThat(lopOptions2joint).as("test data").contains(lop21);
					  String lop22=driver.findElement(By.xpath(".//*[@id='irca-rpt']/div[9]/table/tbody/tr[7]/td/div/table/tbody/tr["+m+"]/td[2]")).getText();
					  softly.assertThat(lop22).as("test data").isEqualTo(reason16);
				  }catch(org.openqa.selenium.NoSuchElementException u)
				  {
					  break;
				  }
				  m=m+1;
			  }
			  //Verify LOP3
			  String lop46 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[10]/table/tbody/tr[1]/td[2]/ul/li"))).getText();
			  softly.assertThat(lop46).as("test data").isEqualTo("No");
			  String lop47 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[10]/table/tbody/tr[1]/td[3]"))).getText();
			  softly.assertThat(lop47).as("test data").isEqualTo(reason17);
			  String lop48 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[10]/table/tbody/tr[2]/td[2]/ul/li"))).getText();
			  softly.assertThat(lop48).as("test data").isEqualTo("No");
			  String lop49 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[10]/table/tbody/tr[2]/td[3]"))).getText();
			  softly.assertThat(lop49).as("test data").isEqualTo(reason18);
			  String lop50 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[10]/table/tbody/tr[3]/td[2]/ul/li"))).getText();
			  softly.assertThat(lop50).as("test data").isEqualTo("No");
			  String lop51 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[10]/table/tbody/tr[3]/td[3]"))).getText();
			  softly.assertThat(lop51).as("test data").isEqualTo(reason19);
			  String lop52 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[10]/table/tbody/tr[4]/td[2]/ul/li"))).getText();
			  softly.assertThat(lop52).as("test data").isEqualTo("No");
			  String lop53 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[10]/table/tbody/tr[4]/td[3]"))).getText();
			  softly.assertThat(lop53).as("test data").isEqualTo(reason20);
			  String lop54 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[10]/table/tbody/tr[5]/td[2]/ul/li"))).getText();
			  softly.assertThat(lop54).as("test data").isEqualTo("No");
			  String lop55 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[10]/table/tbody/tr[5]/td[3]"))).getText();
			  softly.assertThat(lop55).as("test data").isEqualTo(reason21);
			  String lop56 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[10]/table/tbody/tr[6]/td[2]/ul/li"))).getText();
			  softly.assertThat(lop56).as("test data").isEqualTo("No");
			  String lop57 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[10]/table/tbody/tr[6]/td[3]"))).getText();
			  softly.assertThat(lop57).as("test data").isEqualTo(reason22);
			  //Verify 2.20 additional LOP
			  String lop61 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr/td[2]/ul/li[1]"))).getText();
			  softly.assertThat(lop61).as("test data").isEqualTo("Briefings (PJB, MJB, PSM, TO, etc.)");
			  String lop62 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr/td[2]/ul/li[2]"))).getText();
			  softly.assertThat(lop62).as("test data").isEqualTo("Error-proof design");
			  String lop63 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr/td[2]/ul/li[3]"))).getText();
			  softly.assertThat(lop63).as("test data").isEqualTo("JIT alarm");
			  String lop64 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr/td[2]/ul/li[4]"))).getText();
			  softly.assertThat(lop64).as("test data").isEqualTo("Passive protection (safety net, fall protection, air bags, safety belt, etc.)");
			  String lop65 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr/td[2]/ul/li[5]"))).getText();
			  softly.assertThat(lop65).as("test data").isEqualTo("Review (PNR, Technical review)");
			  String lop66 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr/td[3]"))).getText();
			  softly.assertThat(lop66).as("test data").isEqualTo(reason23);
			  //Verify SUEP
			  String rc41 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[12]/table/tbody/tr/td[1]"))).getText();
			  softly.assertThat(rc41).as("test data").isEqualTo("n/a");
			  String rc42 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[12]/table/tbody/tr/td[2]"))).getText();
			  softly.assertThat(rc42).as("test data").isEqualTo("n/a");
			  String rc43 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[12]/table/tbody/tr/td[3]"))).getText();
			  softly.assertThat(rc43).as("test data").isEqualTo("n/a");
			  String rc44 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[12]/table/tbody/tr/td[4]"))).getText();
			  softly.assertThat(rc44).as("test data").isEqualTo("n/a");
			  String rc45 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[12]/table/tbody/tr/td[5]"))).getText();
			  softly.assertThat(rc45).as("test data").isEqualTo("n/a");
			  //Verify HiRCA checklist
			  String rc46 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[1]/td[1]"))).getText();
			  softly.assertThat(rc46).as("test data").isEqualTo("General");
			  String rc47 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[1]/td[2]"))).getText();
			  softly.assertThat(rc47).as("test data").isEqualTo("All involved parties interviewed and all relevant data collected?");
			  String rc48 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[1]/td[3]"))).getText();
			  softly.assertThat(rc48).as("test data").isEqualTo("");
			  String rc49 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[2]/td[1]"))).getText();
			  softly.assertThat(rc49).as("test data").isEqualTo("");
			  String rc50 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[2]/td[2]"))).getText();
			  softly.assertThat(rc50).as("test data").isEqualTo("Past similar events examined?");
			  String rc51 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[2]/td[3]"))).getText();
			  softly.assertThat(rc51).as("test data").isEqualTo("");
			  String rc52 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[3]/td[1]"))).getText();
			  softly.assertThat(rc52).as("test data").isEqualTo("");
			  String rc53 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[3]/td[2]"))).getText();
			  softly.assertThat(rc53).as("test data").isEqualTo("Triggering event and related LOPs identified?");
			  String rc54 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[3]/td[3]"))).getText();
			  softly.assertThat(rc54).as("test data").isEqualTo("");
			  String rc55 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[4]/td[1]"))).getText();
			  softly.assertThat(rc55).as("test data").isEqualTo("Triggering Event");
			  String rc56 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[4]/td[2]"))).getText();
			  softly.assertThat(rc56).as("test data").isEqualTo("Error type involving the triggering event determined?");
			  String rc57 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[4]/td[3]"))).getText();
			  softly.assertThat(rc57).as("test data").isEqualTo("");
			  String rc58 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[5]/td[1]"))).getText();
			  softly.assertThat(rc58).as("test data").isEqualTo("");
			  String rc59 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[5]/td[2]"))).getText();
			  softly.assertThat(rc59).as("test data").isEqualTo("Any equipment failure (if any) involving in the triggering event investigated for its triggering errors?");
			  String rc60 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[5]/td[3]"))).getText();
			  softly.assertThat(rc60).as("test data").isEqualTo("");
			  String rc61 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[6]/td[1]"))).getText();
			  softly.assertThat(rc61).as("test data").isEqualTo("");
			  String rc62 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[6]/td[2]"))).getText();
			  softly.assertThat(rc62).as("test data").isEqualTo("Contributing factors determined?");
			  String rc63 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[6]/td[3]"))).getText();
			  softly.assertThat(rc63).as("test data").isEqualTo("");			  
			  String rc64 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[16]/td[1]"))).getText();
			  softly.assertThat(rc64).as("test data").isEqualTo("Root Causes");
			  String rc65 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[16]/td[2]"))).getText();
			  softly.assertThat(rc65).as("test data").contains("Root causes meeting SUEP");
			  softly.assertThat(rc65).as("test data").contains(" criteria?");
			  String rc66 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[16]/td[3]"))).getText();
			  softly.assertThat(rc66).as("test data").isEqualTo("");
			  String rc67 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[17]/td[1]"))).getText();
			  softly.assertThat(rc67).as("test data").isEqualTo("");
			  String rc68 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[17]/td[2]"))).getText();
			  softly.assertThat(rc68).as("test data").contains("Root causes surviving the CHOP'N");
			  softly.assertThat(rc68).as("test data").contains(" challenge?");
			  String rc69 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[17]/td[3]"))).getText();
			  softly.assertThat(rc69).as("test data").isEqualTo("");
			  String rc70 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[18]/td[1]"))).getText();
			  softly.assertThat(rc70).as("test data").isEqualTo("");
			  String rc71 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[18]/td[2]"))).getText();
			  softly.assertThat(rc71).as("test data").isEqualTo("Levels of importance for root causes identified?");
			  String rc72 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[18]/td[3]"))).getText();
			  softly.assertThat(rc72).as("test data").isEqualTo("");
			  String rc73 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[19]/td[1]"))).getText();
			  softly.assertThat(rc73).as("test data").isEqualTo("Corrective Actions");
			  String rc74 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[19]/td[2]"))).getText();
			  softly.assertThat(rc74).as("test data").contains("Recommended corrective actions covering all root causes and contributing factors?");
			  String rc75 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[19]/td[3]"))).getText();
			  softly.assertThat(rc75).as("test data").isEqualTo("");
			  String rc76 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[20]/td[1]"))).getText();
			  softly.assertThat(rc76).as("test data").isEqualTo("");
			  String rc77 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[20]/td[2]"))).getText();
			  softly.assertThat(rc77).as("test data").isEqualTo("Recommended corrective actions cost effective?");
			  String rc78 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[20]/td[3]"))).getText();
			  softly.assertThat(rc78).as("test data").isEqualTo("");
			  String rc79 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[7]/td[1]"))).getText();
			  softly.assertThat(rc79).as("test data").isEqualTo("LOP 1 - Briefings (PJB, MJB, PSM, TO, etc.)");	
			  String rc80 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[7]/td[2]"))).getText();
			  softly.assertThat(rc80).as("test data").contains("ABC");
			  softly.assertThat(rc80).as("test data").contains(" Issues?");
			  String rc81 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[7]/td[3]"))).getText();
			  softly.assertThat(rc81).as("test data").isEqualTo("");
			  String rc82 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[8]/td[1]"))).getText();
			  softly.assertThat(rc82).as("test data").isEqualTo("");	
			  String rc83 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[8]/td[2]"))).getText();
			  softly.assertThat(rc83).as("test data").contains("TQA");
			  softly.assertThat(rc83).as("test data").contains(" Issues?");
			  String rc84 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[8]/td[3]"))).getText();
			  softly.assertThat(rc84).as("test data").isEqualTo("");
			  String rc85 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[9]/td[1]"))).getText();
			  softly.assertThat(rc85).as("test data").isEqualTo("");	
			  String rc86 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[9]/td[2]"))).getText();
			  softly.assertThat(rc86).as("test data").contains("Non-compliance issues (BURP");
			  softly.assertThat(rc86).as("test data").contains(")?");
			  String rc87 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[9]/td[3]"))).getText();
			  softly.assertThat(rc87).as("test data").isEqualTo("");
			  String rc88 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[10]/td[1]"))).getText();
			  softly.assertThat(rc88).as("test data").isEqualTo("LOP 2 - JIT reminder (signage, not-to do postings)");	
			  String rc89 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[10]/td[2]"))).getText();
			  softly.assertThat(rc89).as("test data").contains("ABC");
			  softly.assertThat(rc89).as("test data").contains(" Issues?");
			  String rc90 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[10]/td[3]"))).getText();
			  softly.assertThat(rc90).as("test data").isEqualTo("");
			  String rc91 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[11]/td[1]"))).getText();
			  softly.assertThat(rc91).as("test data").isEqualTo("");	
			  String rc92 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[11]/td[2]"))).getText();
			  softly.assertThat(rc92).as("test data").contains("TQA");
			  softly.assertThat(rc92).as("test data").contains(" Issues?");
			  String rc93 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[11]/td[3]"))).getText();
			  softly.assertThat(rc93).as("test data").isEqualTo("");
			  String rc94 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[12]/td[1]"))).getText();
			  softly.assertThat(rc94).as("test data").isEqualTo("");	
			  String rc95 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[12]/td[2]"))).getText();
			  softly.assertThat(rc95).as("test data").contains("Non-compliance issues (BURP");
			  softly.assertThat(rc95).as("test data").contains(")?");
			  String rc96 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[12]/td[3]"))).getText();
			  softly.assertThat(rc96).as("test data").isEqualTo("");
			  String rc97 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[13]/td[1]"))).getText();
			  softly.assertThat(rc97).as("test data").isEqualTo("LOP 3 - Other: "+reason3);	
			  String rc98 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[13]/td[2]"))).getText();
			  softly.assertThat(rc98).as("test data").contains("ABC");
			  softly.assertThat(rc98).as("test data").contains(" Issues?");
			  String rc99 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[13]/td[3]"))).getText();
			  softly.assertThat(rc99).as("test data").isEqualTo("");
			  String rc100 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[14]/td[1]"))).getText();
			  softly.assertThat(rc100).as("test data").isEqualTo("");	
			  String rc101 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[14]/td[2]"))).getText();
			  softly.assertThat(rc101).as("test data").contains("TQA");
			  softly.assertThat(rc101).as("test data").contains(" Issues?");
			  String rc102 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[14]/td[3]"))).getText();
			  softly.assertThat(rc102).as("test data").isEqualTo("");
			  String rc103 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[15]/td[1]"))).getText();
			  softly.assertThat(rc103).as("test data").isEqualTo("");	
			  String rc104 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[15]/td[2]"))).getText();
			  softly.assertThat(rc104).as("test data").contains("Non-compliance issues (BURP");
			  softly.assertThat(rc104).as("test data").contains(")?");
			  String rc105 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[14]/table/tbody/tr[15]/td[3]"))).getText();
			  softly.assertThat(rc105).as("test data").isEqualTo("");
			  Thread.sleep(1000);
			  jse.executeScript("scroll(0, 0)");
		  }
		  
		  public void fillLOP() throws Exception {
			  
			  WebDriverWait wait1 = new WebDriverWait(driver,30);
			  JavascriptExecutor jse = (JavascriptExecutor)driver;
			  //Click on Act of Nature
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div/label"))).click();
			  //Enter data in reason entry
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason1);
			  //Click on next
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			  //Clicks on LOP
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
			  //Clicks on 2.1.1 means q2.1 answer-yes
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-initialquestions']/div/fieldset/div/div/label"))).click();
			  //Clicks on Description
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-initialquestions']/div/div[2]/h4/a"))).click();
			  //Verify Description text
			  String lop1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-initialquestions']/div/div[2]/div/div"))).getText();
			  System.out.println(lop1);
			  softly.assertThat(lop1).as("test data").isEqualTo("Layer of Protection (LOP): A practice that detects and/or prevents errors to stop an event from occurring. It can be a procedure, an action or a physical barrier (equipment).");
			  //Clicks on Description
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-initialquestions']/div/div[2]/h4/a"))).click();
			  //Enter reason
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason2);
			  //Clicks on 2 LOPS
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div/label"))).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div/label"))).click();
			  jse.executeScript("scroll(0, 1200)");
			  //Clicks on Other LOP
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[13]/fieldset/div/div/label"))).click();
			  //Enter data in other LOP
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-other-entry"))).sendKeys(reason3);
			  jse.executeScript("scroll(0, 0)");
			  //Click on next
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			  //Click No in 2.1 
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div/label"))).click();
			  //Clicks on Description
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
			  //Verify Description text
			  String lop2 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
			  System.out.println(lop2);
			  softly.assertThat(lop2).as("test data").isEqualTo("Some LOPs are related to the use of equipment (e.g. safety belt, fall protection harness, JIT alarm, etc.). There are four categories of contributing factors in equipment failures: Inadequate qualification, Inadequate surveillance testing, Inadequate maintenance, Inadequate operation.");
			  //Enter data in reason
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason4);
			  //Clicks on Description
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
			  //Click on next
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			  //Clicks on Description
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
			  //Verify Description text
			  String lop3 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
			  System.out.println(lop3);
			  softly.assertThat(lop3).as("test data").isEqualTo("This question is to determine whether the LOP failure was intentional or unintentional.");
			  //Clicks on Description
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
			  //Enter data in reason
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason5);
			  //Select No for 1st LOP in 2.2
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div/label"))).click();
			  //Click on next
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			  //Clicks on Description
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
			  //Verify Description text
			  String lop4 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
			  System.out.println(lop4);
			  softly.assertThat(lop4).as("test data").isEqualTo("This question explores if the intentional violation was caused by perceived burden to execute an LOP. Perceived burden is a feeling that the time or effort spent on implementing an LOP is not worthwhile. Causes for the perception of burden could be: Inadequate accountability, Inadequate understanding for the need, or Excessive prescription of an LOP (e.g. PPE required for greater voltage or arc-flash rating).");
			  //Clicks on Description
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
			  //Enters reason entry data
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason6);
			  //Select No for 1st LOP in 2.9
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div/label"))).click();
			  //Click on next
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();		  
			  //Clicks on Description
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
			  //Verify Description text
			  String lop5 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
			  System.out.println(lop5);
			  softly.assertThat(lop5).as("test data").isEqualTo("This question explores if the intentional violation (such as short-cutting LOP requirements like not performing a PJB as required, etc.) is caused by undue motivation such as going home early, getting out of an uncomfortable working environment, etc.");
			  //Clicks on Description
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
			  //Enters reason entry data
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason7);
			  //Select No for 1st LOP in 2.10
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div/label"))).click();
			  //Click on next
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			  //Clicks on Description
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
			  //Verify Description text
			  String lop6 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
			  System.out.println(lop6);
			  softly.assertThat(lop6).as("test data").isEqualTo("This question explores if low perceived risk was the cause for the LOP violation. Our research found when a worker feels the risk of violation is low, there is a greater tendency to violate the rules. Risk is the sum of two terms. One term is the product of the probability of being caught and the consequences of penalty. The other term is the product of the probability of injury and the consequences of the injury.");
			  //Clicks on Description
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
			  //Enters reason entry data
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason8);
			  //Select Yes for 1st LOP in 2.11
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div/label"))).click();
			  //Click on next
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			  Random random = new Random();
			  int n=0;			 
			  //Choose a number between 1 and 5 for number of selections
			  while (true)
			  {
				  n=random.nextInt(6);
				  if (n<1)
					  continue;
				  break;
			  }
			  System.out.println("No of selections: "+n);
			  int n1=n;
			  int y,r=0,j=0;
			  for (int i=1;i<=n;i++)
			  {
				  //Choose a number between 2 and 6 for 3.14
				  while(true)
				  {
					  y=random.nextInt(7);
					  System.out.println("Chose a no"+y);
					  if(y==0||y==1||r==1)
						  continue;
					  WebElement e=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/input")));
					  if(e.isSelected())
						  continue;
					  break;
				  }
				  System.out.println("Picked a no");
				  System.out.println("Option no: "+y);
				  Thread.sleep(1000);
				  //Click on a lop inquiry in 3.14
				  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))).click();
				  //Click on Evidence Entry
				  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div[2]/div/h4/a"))).click();
				  //Fill in evidence entry text
				  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div[2]/div/div/textarea"))).sendKeys(reason9);
				  //Click on Evidence Entry
				  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div[2]/div/h4/a"))).click();
				  //Click on Further Investigation
				  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div[2]/div[2]/h4/a"))).click();
				  //Click on Further Investigation again
				  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div[2]/div[2]/h4/a"))).click();
				  //Click on Possible Corrective Actions
				  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div[2]/div[3]/h4/a"))).click();
				  //Click on Possible Corrective Actions again
				  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div[2]/div[3]/h4/a"))).click();
				  lopOptions1[i-1]=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))).getText();
				  
			  }
			  jse.executeScript("scroll(0,0)");
			  //Click on next
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			  //Click on skip for 2.12
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
			  //Click No in 2.1 for 2nd LOP
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div/label"))).click();
			  //Clicks on Description
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
			  //Verify Description text
			  String lop7 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
			  System.out.println(lop7);
			  softly.assertThat(lop7).as("test data").isEqualTo("Some LOPs are related to the use of equipment (e.g. safety belt, fall protection harness, JIT alarm, etc.). There are four categories of contributing factors in equipment failures: Inadequate qualification, Inadequate surveillance testing, Inadequate maintenance, Inadequate operation.");
			  //Enter data in reason
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason10);
			  //Clicks on Description
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
			  //Click on next
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			  //Clicks on Description
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
			  //Verify Description text
			  String lop8 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
			  System.out.println(lop8);
			  softly.assertThat(lop8).as("test data").isEqualTo("This question is to determine whether the LOP failure was intentional or unintentional.");
			  //Clicks on Description
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
			  //Enter data in reason
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason11);
			  //Select No for 2nd LOP in 2.2
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div/label"))).click();
			  //Click on next
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			  //Clicks on Description
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
			  //Verify Description text
			  String lop9 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
			  System.out.println(lop9);
			  softly.assertThat(lop9).as("test data").isEqualTo("This question explores if the intentional violation was caused by perceived burden to execute an LOP. Perceived burden is a feeling that the time or effort spent on implementing an LOP is not worthwhile. Causes for the perception of burden could be: Inadequate accountability, Inadequate understanding for the need, or Excessive prescription of an LOP (e.g. PPE required for greater voltage or arc-flash rating).");
			  //Clicks on Description
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
			  //Enters reason entry data
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason12);
			  //Select No for 2nd LOP in 2.9
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div/label"))).click();
			  //Click on next
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();		  
			  //Clicks on Description
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
			  //Verify Description text
			  String lop10 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
			  System.out.println(lop10);
			  softly.assertThat(lop10).as("test data").isEqualTo("This question explores if the intentional violation (such as short-cutting LOP requirements like not performing a PJB as required, etc.) is caused by undue motivation such as going home early, getting out of an uncomfortable working environment, etc.");
			  //Clicks on Description
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
			  //Enters reason entry data
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason13);
			  //Select No for 2nd LOP in 2.10
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div/label"))).click();
			  //Click on next
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			  //Clicks on Description
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
			  //Verify Description text
			  String lop11 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
			  System.out.println(lop11);
			  softly.assertThat(lop11).as("test data").isEqualTo("This question explores if low perceived risk was the cause for the LOP violation. Our research found when a worker feels the risk of violation is low, there is a greater tendency to violate the rules. Risk is the sum of two terms. One term is the product of the probability of being caught and the consequences of penalty. The other term is the product of the probability of injury and the consequences of the injury.");
			  //Clicks on Description
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
			  //Enters reason entry data
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason14);
			  //Select No for 2nd LOP in 2.11
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div/label"))).click();
			  //Click on next
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			  //Clicks on Description
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
			  //Verify Description text
			  String lop12 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
			  System.out.println(lop12);
			  softly.assertThat(lop12).as("test data").isEqualTo("This question explores if the inadequate positive peer pressure is a cause of the intentional violation.");
			  //Clicks on Description
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
			  //Enters reason entry data
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason15);
			  //Select Yes for 2nd LOP in 2.12
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div/label"))).click();
			  //Click on next
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			 //Choose a number between 1 and 4 for number of selections for 3.15
			  while (true)
			  {
				  n=random.nextInt(5);
				  if (n<1)
					  continue;
				  break;
			  }
			  System.out.println("No of selections: "+n);
			  int n2=n;
			  for (int i=1;i<=n;i++)
			  {
				  //Choose a number between 2 and 5 for 3.15
				  while(true)
				  {
					  y=random.nextInt(6);
					  System.out.println("Chose a no"+y);
					  if(y==0||y==1||r==1)
						  continue;
					  WebElement e=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/input")));
					  if(e.isSelected())
						  continue;
					  break;
				  }
				 
				  System.out.println("Option no: "+y);
				  Thread.sleep(1000);
				  //Click on a lop inquiry in 3.15
				  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))).click();
				  //Click on Evidence Entry
				  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div[2]/div/h4/a"))).click();
				  //Fill in evidence entry text
				  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div[2]/div/div/textarea"))).sendKeys(reason16);
				  //Click on Evidence Entry
				  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div[2]/div/h4/a"))).click();
				  //Click on Further Investigation
				  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div[2]/div[2]/h4/a"))).click();
				  //Click on Further Investigation again
				  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div[2]/div[2]/h4/a"))).click();
				  //Click on Possible Corrective Actions
				  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div[2]/div[3]/h4/a"))).click();
				  //Click on Possible Corrective Actions again
				  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div[2]/div[3]/h4/a"))).click();
				  lopOptions2[i-1]=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))).getText();
			  }			  
			  jse.executeScript("scroll(0,0)");
			  //Click on next
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();			  
			  //Clicks on Description
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
			  //Verify Description text
			  String lop13 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
			  System.out.println(lop13);
			  softly.assertThat(lop13).as("test data").isEqualTo("Some LOPs are related to the use of equipment (e.g. safety belt, fall protection harness, JIT alarm, etc.). There are four categories of contributing factors in equipment failures: Inadequate qualification, Inadequate surveillance testing, Inadequate maintenance, Inadequate operation.");
			  //Enter data in reason
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason17);
			  //Clicks on Description
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
			  //Click No in 2.1 for 3rd LOP
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div/label"))).click();
			  //Click on next
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			  //Clicks on Description
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
			  //Verify Description text
			  String lop14 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
			  System.out.println(lop14);
			  softly.assertThat(lop14).as("test data").isEqualTo("This question is to determine whether the LOP failure was intentional or unintentional.");
			  //Clicks on Description
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
			  //Enter data in reason
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason18);
			  //Select No for 3rd LOP in 2.2
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div/label"))).click();
			  //Click on next
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			  //Clicks on Description
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
			  //Verify Description text
			  String lop15 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
			  System.out.println(lop15);
			  softly.assertThat(lop15).as("test data").isEqualTo("This question explores if the intentional violation was caused by perceived burden to execute an LOP. Perceived burden is a feeling that the time or effort spent on implementing an LOP is not worthwhile. Causes for the perception of burden could be: Inadequate accountability, Inadequate understanding for the need, or Excessive prescription of an LOP (e.g. PPE required for greater voltage or arc-flash rating).");
			  //Clicks on Description
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
			  //Enters reason entry data
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason19);
			  //Select No for 3rd LOP in 2.9
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div/label"))).click();
			  //Click on next
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();		  
			  //Clicks on Description
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
			  //Verify Description text
			  String lop16 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
			  System.out.println(lop16);
			  softly.assertThat(lop16).as("test data").isEqualTo("This question explores if the intentional violation (such as short-cutting LOP requirements like not performing a PJB as required, etc.) is caused by undue motivation such as going home early, getting out of an uncomfortable working environment, etc.");
			  //Clicks on Description
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
			  //Enters reason entry data
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason20);
			  //Select No for 3rd LOP in 2.10
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div/label"))).click();
			  //Click on next
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			  //Clicks on Description
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
			  //Verify Description text
			  String lop17 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
			  System.out.println(lop17);
			  softly.assertThat(lop17).as("test data").isEqualTo("This question explores if low perceived risk was the cause for the LOP violation. Our research found when a worker feels the risk of violation is low, there is a greater tendency to violate the rules. Risk is the sum of two terms. One term is the product of the probability of being caught and the consequences of penalty. The other term is the product of the probability of injury and the consequences of the injury.");
			  //Clicks on Description
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
			  //Enters reason entry data
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason21);
			  //Select No for 3rd LOP in 2.11
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div/label"))).click();
			  //Click on next
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			  //Clicks on Description
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
			  //Verify Description text
			  String lop18 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
			  System.out.println(lop18);
			  softly.assertThat(lop18).as("test data").isEqualTo("This question explores if the inadequate positive peer pressure is a cause of the intentional violation.");
			  //Clicks on Description
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
			  //Enters reason entry data
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason22);
			  //Select No for 3rd LOP in 2.12
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div/label"))).click();
			  //Click on next
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			  //Clicks on Description 2.20
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
			  //Verify Description text
			  String lop19 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
			  System.out.println(lop19);
			  softly.assertThat(lop19).as("test data").isEqualTo("Please select additional LOPs that can be implemented to prevent this error from happening again.");
			  //Clicks on Description
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
			  //Enters reason entry data
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason23);
			  //Selects 5 options in 2.20
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div/label"))).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div/label"))).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div/label"))).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div/label"))).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div/label"))).click();
			  //Click on next
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			  //wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			  //Click on skip in 2.22
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
			  //Verify n/a in SUEP in root cause
			  String lop20 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[1]"))).getText();
			  System.out.println(lop20);
			  softly.assertThat(lop20).as("test data").isEqualTo("n/a");
			  String lop21 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[2]"))).getText();
			  System.out.println(lop21);
			  softly.assertThat(lop21).as("test data").isEqualTo("n/a");
			  String lop22 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[3]"))).getText();
			  System.out.println(lop22);
			  softly.assertThat(lop22).as("test data").isEqualTo("n/a");
			  String lop23 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[4]"))).getText();
			  System.out.println(lop23);
			  softly.assertThat(lop23).as("test data").isEqualTo("n/a");
			  String lop24 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[5]"))).getText();
			  System.out.println(lop24);
			  softly.assertThat(lop24).as("test data").isEqualTo("n/a");
			  //Click on skip
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
			  //Verify n/a in root cause table
			  String lop25 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table[1]/tbody/tr[2]/td[1]"))).getText();
			  System.out.println(lop25);
			  softly.assertThat(lop25).as("test data").isEqualTo("n/a");
			  String lop26 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table[1]/tbody/tr[2]/td[2]"))).getText();
			  System.out.println(lop26);
			  softly.assertThat(lop26).as("test data").isEqualTo("n/a");
			  String lop27 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table[1]/tbody/tr[2]/td[3]"))).getText();
			  System.out.println(lop27);
			  softly.assertThat(lop27).as("test data").isEqualTo("n/a");
			  //Check the data entered for 3.14 LOP1
			  j=1;
			  Actions act= new Actions(driver);
			  while(j<(n1*3))
			  {
				  j=j+1;
				  //Check if LOP is contributing factor
				  String lop28=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table[2]/tbody/tr["+j+"]/td[2]/fieldset/div/div[2]/input"))).getAttribute("checked");
				  System.out.println(lop28);
				  softly.assertThat(lop28).as("test data").isEqualTo("true");
				  //Stores Level 3 selected in a list
				  String lopLevel3=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table[2]/tbody/tr["+j+"]/td[1]"))).getText();
				  int in=lopLevel3.indexOf(":");
				  if(lopLevel3.charAt(in-1)>='0'&&lopLevel3.charAt(in-1)<='9')
				  {
					  char[] lop = lopLevel3.toCharArray();
					  lop[in]=' ';
					  lopLevel3=String.valueOf(lop);
				  }
				  System.out.println(lopLevel3);
				  lopLevel3=lopLevel3.replace("  ", " ");
				  level3.add(lopLevel3);
				  //Select a number between 0 to 3 for H,M,L
				  y=random.nextInt(4);
				  if(y==1)
				  {
					  //Click on H
					  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table[2]/tbody/tr["+j+"]/td[3]/fieldset/div/div["+y+"]/label"))).click();
					  String lop29=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table[2]/tbody/tr["+j+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue");
					  System.out.println(lop29);
					  softly.assertThat(lop29).as("test data").isEqualTo("H");
					  hml.add("High");
				  }
				  if(y==2)
				  {
					  //Click on M
					  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table[2]/tbody/tr["+j+"]/td[3]/fieldset/div/div["+y+"]/label"))).click();
					  String lop29=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table[2]/tbody/tr["+j+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue");
					  System.out.println(lop29);
					  softly.assertThat(lop29).as("test data").isEqualTo("M");
					  hml.add("Medium");
				  }
				  if(y==3)
				  {
					  //Click on L
					  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table[2]/tbody/tr["+j+"]/td[3]/fieldset/div/div["+y+"]/label"))).click();
					  String lop29=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table[2]/tbody/tr["+j+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue");
					  System.out.println(lop29);
					  softly.assertThat(lop29).as("test data").isEqualTo("L");
					  hml.add("Low");
				  }
				  if(y==0)
					  hml.add("None");				  				  
				  j=j+1;
				  Point coordinates = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table[2]/tbody/tr["+j+"]/td/div/h4/a"))).getLocation();
				  jse.executeScript("scroll(0,"+coordinates.getY()+")");
				  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table[2]/tbody/tr["+j+"]/td/div/h4/a"))).sendKeys(Keys.ARROW_UP);
				  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table[2]/tbody/tr["+j+"]/td/div/h4/a"))).sendKeys(Keys.ARROW_UP);
				  Thread.sleep(1000);				  
				  //Click on Evidence Entry
				  WebElement l=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table[2]/tbody/tr["+j+"]/td/div/h4/a")));
				  act.click(l).build().perform();
				  try{
					  //Verify the text
					  String lop30=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table[2]/tbody/tr["+j+"]/td/div/div/div"))).getText();
					  System.out.println(lop30);
					  softly.assertThat(lop30).as("test data").isEqualTo(reason9);
				  }catch(org.openqa.selenium.TimeoutException u){
					  act.click(l).build().perform();
					  //Verify the text
					  String lop30=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table[2]/tbody/tr["+j+"]/td/div/div/div"))).getText();
					  System.out.println(lop30);
					  softly.assertThat(lop30).as("test data").isEqualTo(reason9);
				  }	
				  
				  //Click on Evidence Entry
				  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table[2]/tbody/tr["+j+"]/td/div/h4/a"))).click();
				  j=j+1;		
				  //Gets Corrective action data
				  String cr1=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table[2]/tbody/tr["+j+"]/td/textarea"))).getText();
				  cr.add(cr1);
			  }
			  Point coordinates1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table[2]/tbody/tr["+(j-1)+"]/td/div/h4/a"))).getLocation();
			  //Check the data entered for 3.15 LOP2
			  int x = coordinates1.getY()+20;
			  j=1;
			  int s=20;
			  while(j<(n2*3))
			  {
				  j=j+1;
				  //Check if LOP is contributing factor
				  String lop31=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table[3]/tbody/tr["+j+"]/td[2]/fieldset/div/div[2]/input"))).getAttribute("checked");
				  System.out.println(lop31);
				  softly.assertThat(lop31).as("test data").isEqualTo("true");
				  //Stores Level 3 selected in a list
				  String lopLevel3=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table[3]/tbody/tr["+j+"]/td[1]"))).getText();
				  int in=lopLevel3.indexOf(":");
				  if(lopLevel3.charAt(in-1)>='0'&&lopLevel3.charAt(in-1)<='9')
				  {
					  char[] lop = lopLevel3.toCharArray();
					  lop[in]=' ';
					  lopLevel3=String.valueOf(lop);
				  }
				  lopLevel3=lopLevel3.replace("  ", " ");
				  level3.add(lopLevel3);
				  
				  //Select a number between 0 to 3 for H,M,L
				  y=random.nextInt(4);
				  if(y==1)
				  {
					  //Click on H
					  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table[3]/tbody/tr["+j+"]/td[3]/fieldset/div/div["+y+"]/label"))).click();
					  String lop32=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table[3]/tbody/tr["+j+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue");
					  System.out.println(lop32);
					  softly.assertThat(lop32).as("test data").isEqualTo("H");
					  hml.add("High");
				  }
				  if(y==2)
				  {
					  //Click on M
					  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table[3]/tbody/tr["+j+"]/td[3]/fieldset/div/div["+y+"]/label"))).click();
					  String lop32=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table[3]/tbody/tr["+j+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue");
					  System.out.println(lop32);
					  softly.assertThat(lop32).as("test data").isEqualTo("M");
					  hml.add("Medium");
				  }
				  if(y==3)
				  {
					  //Click on L
					  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table[3]/tbody/tr["+j+"]/td[3]/fieldset/div/div["+y+"]/label"))).click();
					  String lop32=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table[3]/tbody/tr["+j+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue");
					  System.out.println(lop32);
					  softly.assertThat(lop32).as("test data").isEqualTo("L");
					  hml.add("Low");
				  }
				  if(y==0)
					  hml.add("None");
				  j=j+1;
				  WebElement l=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table[3]/tbody/tr["+j+"]/td/div/h4/a")));
				  s=x+ s;
				  jse.executeScript("scroll(0,"+s+")");
				  act.moveToElement(l).build().perform();
				  if(((n2*3)-j)<6)
				  {
					  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table[3]/tbody/tr["+j+"]/td/div/h4/a"))).sendKeys(Keys.ARROW_DOWN);
					  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table[3]/tbody/tr["+j+"]/td/div/h4/a"))).sendKeys(Keys.ARROW_DOWN);
				  }
				  else
				  {
					  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table[3]/tbody/tr["+j+"]/td/div/h4/a"))).sendKeys(Keys.ARROW_UP);
					  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table[3]/tbody/tr["+j+"]/td/div/h4/a"))).sendKeys(Keys.ARROW_UP);
				  }
				  Thread.sleep(3000);
				  //Click on Evidence Entry
				  act.click(l).build().perform();
				  try{
					  //Verify the text
					  String lop33=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table[3]/tbody/tr["+j+"]/td/div/div/div"))).getText();
					  System.out.println(lop33);
					  softly.assertThat(lop33).as("test data").isEqualTo(reason16);
				  }catch(org.openqa.selenium.TimeoutException u){
					  act.click(l).build().perform();
					  //Verify the text
					  String lop33=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table[3]/tbody/tr["+j+"]/td/div/div/div"))).getText();
					  System.out.println(lop33);
					  softly.assertThat(lop33).as("test data").isEqualTo(reason16);
				  }					  
				  //Click on Evidence Entry
				  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table[3]/tbody/tr["+j+"]/td/div/h4/a"))).click();
				  j=j+1;
				  //Gets Corrective action data
				  String cr1=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table[3]/tbody/tr["+j+"]/td/textarea"))).getText();
				  cr.add(cr1);
			  }
			  System.out.println("HML list "+hml);
			  System.out.println("Level3 list "+level3);
			  System.out.println("Corrective action "+cr);
			  Thread.sleep(2000);
			  jse.executeScript("scroll(0,0)");
			  Thread.sleep(2000);
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).sendKeys(Keys.ARROW_UP);
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).sendKeys(Keys.ARROW_UP);
			  Thread.sleep(2000);
			  //Click on next
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			  //Clicks on check boxes from top to bottom and unchecks them from bottom to top in Step 5
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
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[13]/td[3]/div/input"))).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[14]/td[3]/div/input"))).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[15]/td[3]/div/input"))).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[16]/td[3]/div/input"))).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[17]/td[3]/div/input"))).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[18]/td[3]/div/input"))).click();
			  jse.executeScript("scroll(0,1200)");
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[19]/td[3]/div/input"))).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[20]/td[3]/div/input"))).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[21]/td[3]/div/input"))).click();
			  //Unchecks them all
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[21]/td[3]/div/input"))).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[20]/td[3]/div/input"))).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[19]/td[3]/div/input"))).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[18]/td[3]/div/input"))).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[17]/td[3]/div/input"))).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[16]/td[3]/div/input"))).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[15]/td[3]/div/input"))).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[14]/td[3]/div/input"))).click();
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[13]/td[3]/div/input"))).click();
			  jse.executeScript("scroll(0,0)");
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
			  jse.executeScript("scroll(0,0)");
			  //Click on skip
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
			  Thread.sleep(1000);
		  }		  
		  
		@Test
		  public void SanityTest() throws Exception{
		  try{
			  JavascriptExecutor jse = (JavascriptExecutor)driver;
			  WebDriverWait wait1 = new WebDriverWait(driver,30);
			  Login();
			  System.out.println("Title after login: "+driver.getTitle());
			  //Waits for the page to load
		      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			  //Switches to the iframe
			  driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
			  Thread.sleep(5000);
		  if (login==1)
          {
                
                while(true)
    		  {
               	 Thread.sleep(1000);
    			  if (driver.findElement(By.cssSelector(".sticky.border-top-right.sticky-error")).isDisplayed())
    			  {
    				  WebElement ele =driver.findElement(By.cssSelector(".sticky.border-top-right.sticky-error"));
    				  ele.findElement(By.className("sticky-close")).click();
    				  break;
    			  }
    			  else break;
    		  }
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
			  
			  //Enters Text
			  String paragraph_investigators = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus eu lorem sapien. Donec molestie ligula nec diam mollis scelerisque ac et orci. Phasellus facilisis urna quis nibh faucibus, quis vestibulum nunc fringilla. Sed efficitur elit a nulla ultrices, at cursus ligula pharetra. Ut sollicitudin libero in nunc iaculis, ac mollis eros finibus. Nam iaculis pretium augue, vel tristique ligula sodales id. Maecenas sit amet tellus lobortis, pellentesque urna non, rutrum ante. Etiam enim quam, porta vel iaculis tincidunt, feugiat in nisl.@#$%&*()"
					  +"\n"
					  +"Donec gravida ante congue orci dictum, ut pretium velit elementum. Aliquam mattis sapien ut felis consequat tempor. Integer eget justo libero. Etiam hendrerit massa odio, non scelerisque leo fringilla nec. Curabitur ac magna dolor. Suspendisse mi nisi, dictum non dolor sit amet, venenatis tempor ipsum. Praesent maximus mauris tortor, ut hendrerit est pulvinar vitae. Aenean vel justo dignissim, scelerisque urna ultricies, hendrerit magna. Etiam elementum accumsan turpis ut efficitur. Aliquam luctus, nulla eget faucibus fermentum, tortor eros dignissim ante, vitae fermentum tellus ligula consectetur ligula. Etiam sagittis nisl mi, sit amet scelerisque eros venenatis sit amet. Fusce facilisis nisl nunc, eu euismod dui tristique nec. Donec lorem enim, sodales eu sem in, feugiat varius nunc. Phasellus cursus laoreet sapien, ac posuere tortor!?:;"
					  ;
			  //Investigators
			  driver.findElement(By.id("pii-irca-event-investigators")).sendKeys(paragraph_investigators);
			  		  			  
			  //Paragraph for Background info
			  String paragraph_background= "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
					  +"\n"+"\n"
					  +"Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. The Apache FontBox library is an open source Java tool to obtain low level information from font files. FontBox is a subproject of Apache PDFBox. The Apache PDFBox library is an open source Java tool for working with PDF documents. This artefact contains commandline tools using Apache PDFBox."
					  ;			 
			  //Background info
			  driver.findElement(By.id("pii-irca-event-bginfos")).sendKeys(paragraph_background);
			  
			  //Paragraph for Timeline of event
			  String paragraph_timeline = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for lorem ipsum will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose. I have a house."
					  +"\n"+"\n"
					  +"There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The Apache PDFBox library is an open source Java tool for working with PDF documents. This artefact contains examples on how the library can be used."
					  ;
			  //Timeline of event
			  driver.findElement(By.id("pii-irca-event-events")).sendKeys(paragraph_timeline);
			  
			  //Paragraph for Problem Statement
			  String paragraph_problem = "But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil and pain can procure him some great pleasure. To take a trivial example, which of us ever undertakes laborious physical exercise, except to obtain some advantage from it."
					  +"\n"+"\n"
					  +"On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment, so blinded by desire, that they cannot foresee the pain and trouble that are bound to ensue; and equal blame belongs to those who fail in their duty through weakness of will, which is the same as saying through shrinking from toil and pain. These cases are perfectly simple and easy to distinguish. In a free hour, when our power of choice is untrammelled and when nothing prevents our being able to do what we like best, every pleasure is to be welcomed and every pain avoided. But in certain circumstances and owing to the claims of duty or the obligations of business it will frequently occur that pleasures have to be repudiated and annoyances accepted."
					  ;
			  //Problem Statement
			  driver.findElement(By.id("pii-irca-event-pbstatement")).sendKeys(paragraph_problem);
			  
			  jse.executeScript("scroll(0, 0)");
			  
			  //Department
			  WebElement dropdown = driver.findElement(By.id("pii-irca-event-department"));
			  Select s = new Select (dropdown);
			  s.selectByVisibleText("Construction");
			  
			  //Location of event
			  String text = "As it currently stands, this question is not a good fit for our Q&A format. We expect answers to be supported by facts.";
			  driver.findElement(By.id("pii-irca-event-location")).sendKeys(text);
			  
			  //Event title
			   String text184 = "This list looks quite big but the setup is quite easy but time-consuming and once you are done with setup next time it will hardly take two min to start you Mobile test.I ha";
			  driver.findElement(By.id("pii-irca-event-title")).sendKeys(text184);
			  
			  //Gets value of date
			  String get_date = driver.findElement(By.id("pii-irca-event-date")).getAttribute("value");
			  System.out.println(get_date);
			  //Gets value of time
			  String get_time = driver.findElement(By.id("pii-irca-event-time")).getAttribute("value");
			  System.out.println(get_time);
			  //Gets value of department
			  String get_dept = driver.findElement(By.id("pii-irca-event-department")).getAttribute("value");
			  System.out.println(get_dept);
			  //Fills optional data
			  //Executive summary
			  String executive= "According to the 1993 Israel-Palestinian peace accords, the final status of Jerusalem is meant to be discussed in the latter stages of peace talks.";
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-execsummary"))).sendKeys(executive);
			  //Event id
			  String event_id="Its a small world after all";
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-crnumber"))).sendKeys(event_id);
			  jse.executeScript("scroll(0,6500)");
			  //Clicks on next
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[16]/div/button"))).click();
			  fillLOP();
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
			  Thread.sleep(1000);
			  //All changed supporting files saved successfully
			  
			  //Clicks on Info tab
		      wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-tab-0"))).click();
			  //Create an expected name
			  String creationDate = driver.findElement(By.id("pii-irca-event-repdatetime")).getAttribute("value");
			 // String creationDate = driver.findElement(By.xpath(".//*[@id='efi-irca-answers']/div/div/table/tbody/tr[9]/td[2]")).getText();
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
			  Thread.sleep(2000);
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
			  //Deletes the newly created record
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
