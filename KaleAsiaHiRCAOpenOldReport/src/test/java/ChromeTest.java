import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ChromeTest {

	 private WebDriver driver;
	 private int login =0;
	 private String username = "lili";
	 private String password = "S2FsZTY2NDIzMDAyQA==";
	 SoftAssertions softly = new SoftAssertions();
	 @Rule
	    public ErrorCollector collector = new ErrorCollector();

	@Rule
	  public Timeout globalTimeout= new Timeout(300000,TimeUnit.SECONDS);
	  
		@Before
		  public void beforeTest() throws MalformedURLException{
			  
			  System.out.println("Opening and checking an old report in Chrome");
			  System.setProperty("webdriver.chrome.driver","C:\\Users\\rramakrishnan\\DriversForSelenium\\chromedriver.exe");
			  ChromeOptions options = new ChromeOptions();
	          HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
	          chromeOptionsMap.put("plugins.plugins_disabled", new String[] {
	        		    "Chrome PDF Viewer"
	        		});
	          chromeOptionsMap.put("plugins.always_open_pdf_externally", true);
	          options.setExperimentalOption("prefs", chromeOptionsMap);
	          String downloadFilepath = "C:\\Users\\IEUser\\Downloads\\reports";
	          chromeOptionsMap.put("download.default_directory", downloadFilepath);
	          options.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
	          options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	          options.setCapability(ChromeOptions.CAPABILITY, options);
	          driver = new ChromeDriver(options);
			  //Browser is maximized
			  driver.manage().window().maximize();
			  //Browser navigates to the KALE url
			  driver.navigate().to("https://kaleasia.error-free.com/");
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
		
		public void openReportGetData() throws Exception{
			WebDriverWait wait = new WebDriverWait(driver,30);
			//Click on open button
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a"))).click();
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		    //Clicks on open report
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		    //Click on info tab
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-tab-0"))).click(); 
		    //Get data from every field
		    String event_title1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-title"))).getAttribute("value");
		    String event_title = event_title1.trim();
		    System.out.println(event_title);
		    String event_loc1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-location"))).getAttribute("value");
		    String event_loc = event_loc1.trim();
		    System.out.println(event_loc);
		    String event_date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-date"))).getAttribute("value");
		    System.out.println(event_date);
		    String event_time = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-time"))).getAttribute("value");
		    System.out.println(event_time);
		    String prob_statement1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-pbstatement"))).getAttribute("value");
		    String prob_statement = prob_statement1.trim();
		    System.out.println(prob_statement);
		    String timeline1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-events"))).getAttribute("value");
		    String timeline = timeline1.trim();
		    System.out.println(timeline);
		    String background1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-bginfos"))).getAttribute("value");
		    String background = background1.trim();
		    System.out.println(background);
		    String investigator1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-investigators"))).getAttribute("value");
		    String investigator = investigator1.trim();
		    System.out.println(investigator);
		    //Click on Step1
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-tab-1"))).click(); 
		    //Click on next once
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		    List<String> LOP1 = new ArrayList<String>();
		    String a1 =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div/label"))).getText();
		    a1=a1.replace("[", "");
		    a1=a1.replace("]", "");
		    LOP1.add(a1);
		    String a2 =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div/label"))).getText();
		    a2=a2.replace("[", "");
		    a2=a2.replace("]", "");
		    LOP1.add(a2);	
		    String a3 =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div/label"))).getText();
		    a3=a3.replace("[", "");
		    a3=a3.replace("]", "");
		    LOP1.add(a3);
		    String a4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div/label"))).getText();
		    a4=a4.replace("[", "");
		    a4=a4.replace("]", "");
		    LOP1.add(a4);	
		    String a5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div/label"))).getText();
		    a5=a5.replace("[", "");
		    a5=a5.replace("]", "");
		    LOP1.add(a5);
		    String a6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div/label"))).getText();
		    a6=a6.replace("[", "");
		    a6=a6.replace("]", "");
		    LOP1.add(a6);		    
		    //Click on Step 2
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-tab-2"))).click(); 
		    //Click on next twice
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		    List<String> LOP2 = new ArrayList<String>();
		    String a7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div/label"))).getText();
		    a7=a7.replace("[", "");
		    a7=a7.replace("]", "");
		    LOP2.add(a7);
		    String a8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div/label"))).getText();
		    a8=a8.replace("[", "");
		    a8=a8.replace("]", "");
		    LOP2.add(a8);	
		    String a9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div/label"))).getText();
		    a9=a9.replace("[", "");
		    a9=a9.replace("]", "");
		    LOP2.add(a9);
		    String a10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div/label"))).getText();
		    a10=a10.replace("[", "");
		    a10=a10.replace("]", "");
		    LOP2.add(a10);	
		    String a11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div/label"))).getText();
		    a11=a11.replace("[", "");
		    a11=a11.replace("]", "");
		    LOP2.add(a11);
		    String a12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div/label"))).getText();
		    a12=a12.replace("[", "");
		    a12=a12.replace("]", "");
		    LOP2.add(a12);
		    String a13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div/label"))).getText();
		    a13=a13.replace("[", "");
		    a13=a13.replace("]", "");
		    LOP2.add(a13);	
		    String a14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div/label"))).getText();
		    a14=a14.replace("[", "");
		    a14=a14.replace("]", "");
		    LOP2.add(a14);
		    String a15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div/label"))).getText();
		    a15=a15.replace("[", "");
		    a15=a15.replace("]", "");
		    LOP2.add(a15);	
		    String a16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div/label"))).getText();
		    a16=a16.replace("[", "");
		    a16=a16.replace("]", "");
		    LOP2.add(a16);
		    //Click on next once
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		    List<String> LOP3 = new ArrayList<String>();
		    String a17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div/label"))).getText();
		    a17=a17.replace("[", "");
		    a17=a17.replace("]", "");
		    LOP3.add(a17);
		    String a18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div/label"))).getText();
		    a18=a18.replace("[", "");
		    a18=a18.replace("]", "");
		    LOP3.add(a18);
		    String a19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div/label"))).getText();
		    a19=a19.replace("[", "");
		    a19=a19.replace("]", "");
		    LOP3.add(a19);
		    String a20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div/label"))).getText();
		    a20=a20.replace("[", "");
		    a20=a20.replace("]", "");
		    LOP3.add(a20);	
		    String a21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div/label"))).getText();
		    a21=a21.replace("[", "");
		    a21=a21.replace("]", "");
		    LOP3.add(a21);
		    //Click on saved activities
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-btn-savedactivities"))).click();
			//Wait for black loading message to disappear
			try{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			}catch (org.openqa.selenium.TimeoutException e)
				  {
					  
				  }
			//Click on an old report in 09/2016
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[5]/a"))).click();
			//Wait for black loading message to disappear
			try{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			}catch (org.openqa.selenium.TimeoutException e)
				  {
					  
				  }
			//Open and check record
			openCheckRecord(event_title,event_loc,event_date,event_time,prob_statement,timeline,background,investigator,LOP1,LOP2,LOP3);
		}
		
		public void openCheckRecord (String event_title,String event_loc,String event_date,String event_time,String prob_statement,String timeline,String background,String investigator,List<String> LOP1,List<String> LOP2,List<String> LOP3) throws Exception{
			WebDriverWait wait = new WebDriverWait(driver,30);
			//Verifies Event title data
			String eve_title =  driver.findElement(By.xpath(".//*[@id='irca-rpt']/div/table/tbody/tr/td[2]")).getText();
			event_title=event_title.replace("  ", " ");
			softly.assertThat(eve_title).as("test data").isEqualTo(event_title);
			//Verifies Date of event data
			String eve_date =  driver.findElement(By.xpath(".//*[@id='irca-rpt']/div/table/tbody/tr[3]/td[2]")).getText();
			softly.assertThat(eve_date).as("test data").isEqualTo(event_date);
			//Verifies Time of event data
			String eve_time =  driver.findElement(By.xpath(".//*[@id='irca-rpt']/div/table/tbody/tr[3]/td[4]")).getText();
			softly.assertThat(eve_time).as("test data").isEqualTo(event_time);
			//Verifies Location of event data
			String eve_loc =  driver.findElement(By.xpath(".//*[@id='irca-rpt']/div/table/tbody/tr[4]/td[2]")).getText();
			event_loc=event_loc.replace("  ", " ");
			softly.assertThat(eve_loc).as("test data").isEqualTo(event_loc);
			//Verifies Investigators data
			String eve_inv =  driver.findElement(By.xpath(".//*[@id='irca-rpt']/div/table/tbody/tr[7]/td[2]")).getText();
			investigator=investigator.replace("  ", " ");
			softly.assertThat(eve_inv).as("test data").isEqualTo(investigator);
			//Verifies Problem statement data
			String eve_prob =  driver.findElement(By.xpath(".//*[@id='irca-rpt']/div[2]/table/tbody/tr[2]/td[2]")).getText();
			prob_statement=prob_statement.replace("  ", " ");
			softly.assertThat(eve_prob).as("test data").isEqualTo(prob_statement);
			//Verifies Timeline of event data
			String eve_timeline =  driver.findElement(By.xpath(".//*[@id='irca-rpt']/div[2]/table/tbody/tr[3]/td[2]")).getText();
			timeline=timeline.replace("  ", " ");
			softly.assertThat(eve_timeline).as("test data").isEqualTo(timeline);
			//Verifies Background information data
			String eve_back =  driver.findElement(By.xpath(".//*[@id='irca-rpt']/div[2]/table/tbody/tr[4]/td[2]")).getText();
			background=background.replace("  ", " ");
			softly.assertThat(eve_back).as("test data").isEqualTo(background);
			//Verifies failed LOP1 data
			String lop1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table[1]/tbody/tr[1]/td[1]"))).getText();
			softly.assertThat(lop1).as("test data").isEqualTo(LOP1.get(0));
			String lop2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table[1]/tbody/tr[3]/td[1]"))).getText();
			softly.assertThat(lop2).as("test data").isEqualTo(LOP1.get(2));
			String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table[1]/tbody/tr[5]/td[1]"))).getText();
			softly.assertThat(lop3).as("test data").isEqualTo(LOP1.get(4));
			String lop4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table[1]/tbody/tr[7]/td[1]"))).getText();
			softly.assertThat(lop4).as("test data").isEqualTo(LOP1.get(1));
			String lop5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table[1]/tbody/tr[9]/td[1]"))).getText();
			softly.assertThat(lop5).as("test data").isEqualTo(LOP1.get(3));
			String lop6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table[1]/tbody/tr[11]/td[1]"))).getText();
			softly.assertThat(lop6).as("test data").isEqualTo(LOP1.get(5));
			//Verifies HML of 3.17
			String lop7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table[1]/tbody/tr[1]/td[2]"))).getText();
			softly.assertThat(lop7).as("test data").isEqualTo("High");
			String lop8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table[1]/tbody/tr[3]/td[2]"))).getText();
			softly.assertThat(lop8).as("test data").isEqualTo("High");
			String lop9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table[1]/tbody/tr[5]/td[2]"))).getText();
			softly.assertThat(lop9).as("test data").isEqualTo("High");
			String lop10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table[1]/tbody/tr[7]/td[2]"))).getText();
			softly.assertThat(lop10).as("test data").isEqualTo("Medium");
			String lop11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table[1]/tbody/tr[9]/td[2]"))).getText();
			softly.assertThat(lop11).as("test data").isEqualTo("Medium");
			String lop12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table[1]/tbody/tr[11]/td[2]"))).getText();
			softly.assertThat(lop12).as("test data").isEqualTo("Medium");
			//Verify Supporting evidence of 3.17
			String lop13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table[1]/tbody/tr[2]/td"))).getText();
			softly.assertThat(lop13).as("test data").isEqualTo("Supporting Evidence:"+"\n"+"dsfsdf");
			String lop14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table[1]/tbody/tr[4]/td"))).getText();
			softly.assertThat(lop14).as("test data").isEqualTo("Supporting Evidence:"+"\n"+"dsfsdf");
			String lop15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table[1]/tbody/tr[6]/td"))).getText();
			softly.assertThat(lop15).as("test data").isEqualTo("Supporting Evidence:"+"\n"+"cxvxcvxc");
			String lop16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table[1]/tbody/tr[8]/td"))).getText();
			softly.assertThat(lop16).as("test data").isEqualTo("Supporting Evidence:"+"\n"+"sdgfsdf");
			String lop17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table[1]/tbody/tr[10]/td"))).getText();
			softly.assertThat(lop17).as("test data").isEqualTo("Supporting Evidence:"+"\n"+"sdfsfsdf");
			String lop18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table[1]/tbody/tr[12]/td"))).getText();
			softly.assertThat(lop18).as("test data").isEqualTo("Supporting Evidence:"+"\n"+"cxvxcvxcvc");
			//Verify Missing LOPs
			String lop19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/table/tbody/tr[1]/td[1]"))).getText();
			softly.assertThat(lop19).as("test data").isEqualTo("Briefings (PJB, MJB, PSM, TO, etc.)");
			String lop20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/table/tbody/tr[1]/td[2]"))).getText();
			softly.assertThat(lop20).as("test data").isEqualTo("Concurrent check");
			String lop21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/table/tbody/tr[1]/td[3]"))).getText();
			softly.assertThat(lop21).as("test data").isEqualTo("Error-proof design");
			String lop22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/table/tbody/tr[2]/td[1]"))).getText();
			softly.assertThat(lop22).as("test data").isEqualTo("Independent check");
			String lop23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/table/tbody/tr[2]/td[2]"))).getText();
			softly.assertThat(lop23).as("test data").isEqualTo("JIT reminder (signage, not-to do postings)");
			String lop24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/table/tbody/tr[2]/td[3]"))).getText();
			softly.assertThat(lop24).as("test data").isEqualTo("Passive protection (safety net, fall protection, air bags, safety belt, etc.)");
			String lop25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/table/tbody/tr[3]/td[1]"))).getText();
			softly.assertThat(lop25).as("test data").isEqualTo("Peer coaching");
			String lop26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/table/tbody/tr[3]/td[2]"))).getText();
			softly.assertThat(lop26).as("test data").isEqualTo("Review (PNR, Technical review)");
			String lop27 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/table/tbody/tr[3]/td[3]"))).getText();
			softly.assertThat(lop27).as("test data").isEqualTo("Supervisory intervention");
			//Verify root causes
			String rc1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[1]/td[2]"))).getText();
			softly.assertThat(rc1).as("test data").isEqualTo("Equipment failure");
			String rc2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[1]/td[3]"))).getText();
			softly.assertThat(rc2).as("test data").isEqualTo("n/a");
			String rc3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[3]/td[2]"))).getText();
			softly.assertThat(rc3).as("test data").isEqualTo("n/a");
			String rc4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[3]/td[3]"))).getText();
			softly.assertThat(rc4).as("test data").isEqualTo("n/a");
			String rc5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[4]/td[2]"))).getText();
			softly.assertThat(rc5).as("test data").isEqualTo("n/a");
			String rc6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[4]/td[3]"))).getText();
			softly.assertThat(rc6).as("test data").isEqualTo("n/a");
			String rc7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[2]"))).getText();
			softly.assertThat(rc7).as("test data").isEqualTo("n/a");
			String rc8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[3]"))).getText();
			softly.assertThat(rc8).as("test data").isEqualTo("n/a");
			String rc9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[6]/td[2]"))).getText();
			softly.assertThat(rc9).as("test data").isEqualTo("n/a");
			String rc10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[6]/td[3]"))).getText();
			softly.assertThat(rc10).as("test data").isEqualTo("n/a");
			String rc11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[7]/td[2]"))).getText();
			softly.assertThat(rc11).as("test data").isEqualTo("n/a");
			String rc12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[7]/td[3]"))).getText();
			softly.assertThat(rc12).as("test data").isEqualTo("n/a");
			String rc13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[8]/td[2]"))).getText();
			softly.assertThat(rc13).as("test data").isEqualTo("n/a");
			String rc14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[8]/td[3]"))).getText();
			softly.assertThat(rc14).as("test data").isEqualTo("n/a");
			String rc15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[9]/td[2]"))).getText();
			softly.assertThat(rc15).as("test data").isEqualTo("n/a");
			String rc16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[9]/td[3]"))).getText();
			softly.assertThat(rc16).as("test data").isEqualTo("n/a");
			String rc17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[10]/td[2]"))).getText();
			softly.assertThat(rc17).as("test data").isEqualTo("n/a");
			String rc18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[10]/td[3]"))).getText();
			softly.assertThat(rc18).as("test data").isEqualTo("n/a");
			String rc19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[11]/td[2]"))).getText();
			softly.assertThat(rc19).as("test data").isEqualTo("n/a");
			String rc20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[11]/td[3]"))).getText();
			softly.assertThat(rc20).as("test data").isEqualTo("n/a");
			String rc21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[12]/td[2]"))).getText();
			softly.assertThat(rc21).as("test data").isEqualTo("n/a");
			String rc22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[12]/td[3]"))).getText();
			softly.assertThat(rc22).as("test data").isEqualTo("n/a");
			String rc23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[13]/td[2]"))).getText();
			softly.assertThat(rc23).as("test data").isEqualTo("n/a");
			String rc24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[13]/td[3]"))).getText();
			softly.assertThat(rc24).as("test data").isEqualTo("n/a");
			String rc25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[14]/td[2]"))).getText();
			softly.assertThat(rc25).as("test data").isEqualTo("n/a");
			String rc26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[14]/td[3]"))).getText();
			softly.assertThat(rc26).as("test data").isEqualTo("n/a");
			String rc27 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[15]/td[2]"))).getText();
			softly.assertThat(rc27).as("test data").isEqualTo("n/a");
			String rc28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[15]/td[3]"))).getText();
			softly.assertThat(rc28).as("test data").isEqualTo("n/a");
			String rc29 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[16]/td[2]"))).getText();
			softly.assertThat(rc29).as("test data").isEqualTo("n/a");
			String rc30 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[16]/td[3]"))).getText();
			softly.assertThat(rc30).as("test data").isEqualTo("n/a");
			String rc31 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[17]/td[2]"))).getText();
			softly.assertThat(rc31).as("test data").isEqualTo("n/a");
			String rc32 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[17]/td[3]"))).getText();
			softly.assertThat(rc32).as("test data").isEqualTo("n/a");
			String rc33 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[18]/td[2]"))).getText();
			softly.assertThat(rc33).as("test data").isEqualTo("n/a");
			String rc34 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[18]/td[3]"))).getText();
			softly.assertThat(rc34).as("test data").isEqualTo("n/a");
			String rc35 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[19]/td[2]"))).getText();
			softly.assertThat(rc35).as("test data").isEqualTo("n/a");
			String rc36 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[19]/td[3]"))).getText();
			softly.assertThat(rc36).as("test data").isEqualTo("n/a");
			String rc37 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[20]/td[2]"))).getText();
			softly.assertThat(rc37).as("test data").isEqualTo("n/a");
			String rc38 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[20]/td[3]"))).getText();
			softly.assertThat(rc38).as("test data").isEqualTo("n/a");
			String rc39 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[21]/td[2]"))).getText();
			softly.assertThat(rc39).as("test data").isEqualTo("n/a");
			String rc40 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[21]/td[3]"))).getText();
			softly.assertThat(rc40).as("test data").isEqualTo("n/a");
			String rc41 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[22]/td[2]"))).getText();
			softly.assertThat(rc41).as("test data").isEqualTo("n/a");
			String rc42 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[22]/td[3]"))).getText();
			softly.assertThat(rc42).as("test data").isEqualTo("n/a");
			//Verify level 3 3.17
			String rc43 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[1]"))).getText();
			softly.assertThat(rc43).as("test data").isEqualTo(LOP1.get(0));
			String rc44 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[2]/td[1]"))).getText();
			softly.assertThat(rc44).as("test data").isEqualTo(LOP1.get(1));
			String rc45 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[3]/td[1]"))).getText();
			softly.assertThat(rc45).as("test data").isEqualTo(LOP1.get(2));
			String rc46 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[4]/td[1]"))).getText();
			softly.assertThat(rc46).as("test data").isEqualTo(LOP1.get(3));
			String rc47 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[5]/td[1]"))).getText();
			softly.assertThat(rc47).as("test data").isEqualTo(LOP1.get(4));
			String rc48 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[2]/td/div/table/tbody/tr[6]/td[1]"))).getText();
			softly.assertThat(rc48).as("test data").isEqualTo(LOP1.get(5));
			//Verify LOP Failure Inquiry
			String lop28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[1]/td[2]"))).getText();
			softly.assertThat(lop28).as("test data").isEqualTo("No");
			String lop29 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[1]/td[3]"))).getText();
			softly.assertThat(lop29).as("test data").isEqualTo("n/a");
			String lop30 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[2]/td[2]/ul/li[1]"))).getText();
			softly.assertThat(lop30).as("test data").isEqualTo("Briefings (PJB, MJB, PSM, TO, etc.)");
			String lop31 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[2]/td[2]/ul/li[2]"))).getText();
			softly.assertThat(lop31).as("test data").isEqualTo("Concurrent check");
			String lop32 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[2]/td[2]/ul/li[3]"))).getText();
			softly.assertThat(lop32).as("test data").isEqualTo("Error-proof design");
			String lop33 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[2]/td[2]/ul/li[4]"))).getText();
			softly.assertThat(lop33).as("test data").isEqualTo("Independent check");
			String lop34 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[2]/td[2]/ul/li[5]"))).getText();
			softly.assertThat(lop34).as("test data").isEqualTo("JIT reminder (signage, not-to do postings)");
			String lop35 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[2]/td[2]/ul/li[6]"))).getText();
			softly.assertThat(lop35).as("test data").isEqualTo("Passive protection (safety net, fall protection, air bags, safety belt, etc.)");
			String lop36 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[2]/td[2]/ul/li[7]"))).getText();
			softly.assertThat(lop36).as("test data").isEqualTo("Peer coaching");
			String lop37 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[2]/td[2]/ul/li[8]"))).getText();
			softly.assertThat(lop37).as("test data").isEqualTo("Review (PNR, Technical review)");
			String lop38 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[2]/td[2]/ul/li[9]"))).getText();
			softly.assertThat(lop38).as("test data").isEqualTo("Supervisory intervention");
			String lop39 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[2]/td[3]"))).getText();
			softly.assertThat(lop39).as("test data").isEqualTo("n/a");
			//Verify level3 for 3.3
			String lop40 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[3]/td/div/table/tbody/tr[1]/td[1]"))).getText();
			softly.assertThat(lop40).as("test data").isEqualTo(LOP2.get(0));
			String lop41 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[3]/td/div/table/tbody/tr[2]/td[1]"))).getText();
			softly.assertThat(lop41).as("test data").isEqualTo(LOP2.get(1));
			String lop42 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[3]/td/div/table/tbody/tr[3]/td[1]"))).getText();
			softly.assertThat(lop42).as("test data").isEqualTo(LOP2.get(2));
			String lop43 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[3]/td/div/table/tbody/tr[4]/td[1]"))).getText();
			softly.assertThat(lop43).as("test data").isEqualTo(LOP2.get(3));
			String lop44 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[3]/td/div/table/tbody/tr[5]/td[1]"))).getText();
			softly.assertThat(lop44).as("test data").isEqualTo(LOP2.get(4));
			String lop45 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[3]/td/div/table/tbody/tr[6]/td[1]"))).getText();
			softly.assertThat(lop45).as("test data").isEqualTo(LOP2.get(5));
			String lop46 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[3]/td/div/table/tbody/tr[7]/td[1]"))).getText();
			softly.assertThat(lop46).as("test data").isEqualTo(LOP2.get(6));
			String lop47 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[3]/td/div/table/tbody/tr[8]/td[1]"))).getText();
			softly.assertThat(lop47).as("test data").isEqualTo(LOP2.get(7));
			String lop48 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[3]/td/div/table/tbody/tr[9]/td[1]"))).getText();
			softly.assertThat(lop48).as("test data").isEqualTo(LOP2.get(8));
			String lop49 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[3]/td/div/table/tbody/tr[10]/td[1]"))).getText();
			softly.assertThat(lop49).as("test data").isEqualTo(LOP2.get(9));
			//Verify level 3 3.6
			String lop50 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[3]/td/div/table/tbody/tr[11]/td[1]"))).getText();
			softly.assertThat(lop50).as("test data").isEqualTo(LOP3.get(0));
			String lop51 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[3]/td/div/table/tbody/tr[12]/td[1]"))).getText();
			softly.assertThat(lop51).as("test data").isEqualTo(LOP3.get(1));
			String lop52 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[3]/td/div/table/tbody/tr[13]/td[1]"))).getText();
			softly.assertThat(lop52).as("test data").isEqualTo(LOP3.get(2));
			String lop53 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[3]/td/div/table/tbody/tr[14]/td[1]"))).getText();
			softly.assertThat(lop53).as("test data").isEqualTo(LOP3.get(3));
			String lop54 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[3]/td/div/table/tbody/tr[15]/td[1]"))).getText();
			softly.assertThat(lop54).as("test data").isEqualTo(LOP3.get(4));
			//Verify SUEP
			String lop55 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr[1]/td[2]"))).getText();
			softly.assertThat(lop55).as("test data").isEqualTo("Yes");
			String lop56 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr[1]/td[3]"))).getText();
			softly.assertThat(lop56).as("test data").isEqualTo("Yes");
			String lop57 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr[1]/td[5]"))).getText();
			softly.assertThat(lop57).as("test data").isEqualTo("Yes");
			String lop58 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr[2]/td[2]"))).getText();
			softly.assertThat(lop58).as("test data").isEqualTo("Yes");
			String lop59 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr[2]/td[3]"))).getText();
			softly.assertThat(lop59).as("test data").isEqualTo("Yes");
			String lop60 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr[2]/td[5]"))).getText();
			softly.assertThat(lop60).as("test data").isEqualTo("Yes");
			String lop61 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr[3]/td[2]"))).getText();
			softly.assertThat(lop61).as("test data").isEqualTo("Yes");
			String lop62 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr[3]/td[3]"))).getText();
			softly.assertThat(lop62).as("test data").isEqualTo("Yes");
			String lop63 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr[3]/td[5]"))).getText();
			softly.assertThat(lop63).as("test data").isEqualTo("Yes");
			String lop64 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr[4]/td[2]"))).getText();
			softly.assertThat(lop64).as("test data").isEqualTo("Yes");
			String lop65 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr[4]/td[3]"))).getText();
			softly.assertThat(lop65).as("test data").isEqualTo("Yes");
			String lop66 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr[4]/td[5]"))).getText();
			softly.assertThat(lop66).as("test data").isEqualTo("Yes");
			String lop67 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr[5]/td[2]"))).getText();
			softly.assertThat(lop67).as("test data").isEqualTo("Yes");
			String lop68 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr[5]/td[3]"))).getText();
			softly.assertThat(lop68).as("test data").isEqualTo("Yes");
			String lop69 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr[5]/td[5]"))).getText();
			softly.assertThat(lop69).as("test data").isEqualTo("Yes");
			String lop70 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr[6]/td[2]"))).getText();
			softly.assertThat(lop70).as("test data").isEqualTo("Yes");
			String lop71 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr[6]/td[3]"))).getText();
			softly.assertThat(lop71).as("test data").isEqualTo("Yes");
			String lop72 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr[6]/td[5]"))).getText();
			softly.assertThat(lop72).as("test data").isEqualTo("Yes");
			//Downloads report and checks pdf
			downloadReport(event_title,event_loc,event_date,event_time,prob_statement,timeline,background,investigator,LOP1,LOP2,LOP3);
		}
		
		
		public void downloadReport(String event_title,String event_loc,String event_date,String event_time,String prob_statement,String timeline,String background,String investigator,List<String> LOP1,List<String> LOP2,List<String> LOP3) throws Exception{
			//deletes files in reports folder before starting to download
	    	File file = new File("C://Users//IEUser//Downloads//reports//");
	    	deleteFiles(file);
	    	WebDriverWait wait1 = new WebDriverWait(driver,60);
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
	    	pdfCheck(event_title,event_loc,event_date,event_time,prob_statement,timeline,background,investigator,LOP1,LOP2,LOP3);
	        for(String winHandle : driver.getWindowHandles()){
    	    driver.switchTo().window(winHandle);
    	    }
	        driver.close();
	    	driver.switchTo().window(window);
	    	Thread.sleep(1000);
	    	//Switches to the iframe
			wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
	    	
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
		
		public void pdfCheck(String event_title,String event_loc,String event_date,String event_time,String prob_statement,String timeline,String background,String investigator,List<String> LOP1,List<String> LOP2,List<String> LOP3) throws Exception{
	    	
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
		    //Checks text in pdf
		    PDDocument pddoc= PDDocument.load(oldfile);
		    String data = new PDFTextStripper().getText(pddoc);
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
	        String pattern="Report Created on [0-9]{1,2}/[0-9]{1,2}/[0-9]{4}, [0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2} [A|P]M Page [0-9]{1,2} of [0-9]{1,2}";
			Pattern ptn = Pattern.compile(pattern);
			Matcher mtch = ptn.matcher(newData1);
			String newData2=mtch.replaceAll("");
			String pattern1="Report Created on [A-Z,a-z]{3} [A-Z,a-z]{3} [0-9]{1,2} [0-9]{4} [0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}";
			ptn = Pattern.compile(pattern1);
			mtch = ptn.matcher(newData2);
			String newData3=mtch.replaceAll("");
			String pattern3="Page [0-9]{1,2} of [0-9]{1,2}";
			ptn = Pattern.compile(pattern3);
			mtch = ptn.matcher(newData3);
			String newData4=mtch.replaceAll("");
			String newData5=newData4.replace("GMT+0000 (UTC) ", "");
			StringBuilder sb=new StringBuilder(newData5);
			String s1=sb.toString();
			while(s1.contains("KALE")==true)
			{
				int m=sb.indexOf("KALE");
				sb=sb.delete(m, m+5);
				s1=sb.toString();
			}
			String newData6=s1.replace("KALE","");
			String newData7=newData6.replace("KALE?","");
	        String newData=newData7.replace("  ", " ");
	        System.out.println(newData);
	        
	      //Verifies title
	      event_title=event_title.replace("  ", " ");
	      softly.assertThat("Event title "+event_title).as("test data").isSubstringOf(newData);
	      //Verifies location of event
	      event_loc=event_loc.replace("  ", " ");
	      softly.assertThat(event_loc).as("test data").isSubstringOf(newData);
	      //Verifies investigators data
	      investigator=investigator.replace("\n", "");
	      investigator=investigator.replace("  ", " ");
	      softly.assertThat("Investigators "+investigator).as("test data").isSubstringOf(newData);
	      //Verifies background data
	      background=background.replace("\n", "");
	      background=background.replace("  ", " ");
	      softly.assertThat("Background information "+background).as("test data").isSubstringOf(newData);
	      //Verifies Timeline data
	      timeline=timeline.replace("\n", "");
	      timeline=timeline.replace("  ", " ");
	      softly.assertThat("Timeline of event "+timeline).as("test data").isSubstringOf(newData);
	      //Verifies Problem statement
	      prob_statement=prob_statement.replace("\n", "");
	      prob_statement=prob_statement.replace("  ", " ");
	      softly.assertThat("Problem statement "+prob_statement).as("test data").isSubstringOf(newData);
	      //Verifies date
	      softly.assertThat(event_date).as("test data").isSubstringOf(newData);
	      //Verifies time
	      softly.assertThat(event_time).as("test data").isSubstringOf(newData);
	      //Level 3 3.17
	      for (int i=0;i<LOP1.size();i++)
	      {
	    	  softly.assertThat(LOP1.get(i)).as("test data").isSubstringOf(newData);
	      }
	      //Level 3 3.3
	      for (int i=0;i<LOP2.size();i++)
	      {
	    	  softly.assertThat(LOP2.get(i)).as("test data").isSubstringOf(newData);
	      }
	      //Level 3 3.6
	      for (int i=0;i<LOP3.size();i++)
	      {
	    	  softly.assertThat(LOP3.get(i)).as("test data").isSubstringOf(newData);
	      }
	      //Verifies missing LOPs
	      softly.assertThat("Briefings (PJB, MJB, PSM, TO, etc.)").as("test data").isSubstringOf(newData);
	      softly.assertThat("Concurrent check").as("test data").isSubstringOf(newData);
	      softly.assertThat("Error-proof design").as("test data").isSubstringOf(newData);
	      softly.assertThat("Independent check").as("test data").isSubstringOf(newData);
	      softly.assertThat(" JIT reminder (signage, not-to do postings)").as("test data").isSubstringOf(newData);
	      softly.assertThat("Passive protection (safety net, fall protection, air bags, safety belt, etc.)").as("test data").isSubstringOf(newData);
	      softly.assertThat("Peer coaching").as("test data").isSubstringOf(newData);
	      softly.assertThat("Review (PNR, Technical review)").as("test data").isSubstringOf(newData);
	      softly.assertThat("Supervisory intervention").as("test data").isSubstringOf(newData);	      
	      //Verifies for Root Cause
	      softly.assertThat("1.1 Was the triggering event a human error, an equipment failure, or an act of nature? Equipment failure").as("test data").isSubstringOf(newData);
	      softly.assertThat("1.2 What was the type of human error? n/a n/a").as("test data").isSubstringOf(newData);
	      softly.assertThat("1.3 For a rule-based error, was the error intentional or unintentional? n/a n/a").as("test data").isSubstringOf(newData);
	      softly.assertThat("1.4 Was the unintentional error related to inattention-to-detail behavior or inadequate rules? n/a n/a").as("test data").isSubstringOf(newData);
	      softly.assertThat("1.5 If I were the error-maker, would I make the same error? n/a n/a").as("test data").isSubstringOf(newData);
	      softly.assertThat("1.6 When the error-maker violated the established standards or policies, was there other staff looking on? n/a n/a").as("test data").isSubstringOf(newData);
	      softly.assertThat("1.7 Could the error have been prevented by self check or independent check? n/a n/a").as("test data").isSubstringOf(newData);
	      softly.assertThat("1.8 Was the error-maker trained to manage error-prone mental states and high risk situations? n/a n/a").as("test data").isSubstringOf(newData);
	      softly.assertThat("1.9 Was the error-maker held accountable after the event by his or her supervisor or by management? n/a n/a").as("test data").isSubstringOf(newData);
	      softly.assertThat("1.10 If a PJB (or PSM, TO, MJB) was held, why was the participant not aware so that he or she could mitigate the risk? n/a n/a").as("test data").isSubstringOf(newData);
	      softly.assertThat("1.12 If PJB (or PSM, TO, MJB) was not performed, why? n/a n/a").as("test data").isSubstringOf(newData);
	      softly.assertThat("1.13 Was the error contributed to by error-prone mental states and/ or high risk situations? n/a n/a").as("test data").isSubstringOf(newData);
	      softly.assertThat("1.14 Did the supervisor conduct routine meetings to discuss lessons learned? n/a n/a").as("test data").isSubstringOf(newData);
	      softly.assertThat("1.15 Did the event involve a single-point-vulnerability item? n/a n/a").as("test data").isSubstringOf(newData);
	      softly.assertThat("1.16 Was the error related to inadequate supervision? n/a n/a").as("test data").isSubstringOf(newData);
	      softly.assertThat("1.17 Did inadequate management by the manager contribute to this error? n/a n/a").as("test data").isSubstringOf(newData);
	      softly.assertThat("1.18 Was the error caused by incorrect rules? n/a n/a").as("test data").isSubstringOf(newData);
	      softly.assertThat("1.19 Was there a rising trend of similar errors? n/a n/a").as("test data").isSubstringOf(newData);
	      softly.assertThat("1.20 Was the HiRCA").as("test data").isSubstringOf(newData);
	      softly.assertThat("adequate to perform human performance root cause analysis? n/a n/a").as("test data").isSubstringOf(newData);
	      softly.assertThat("1.21 Was the error contributed to by changes during jobs? n/a n/a").as("test data").isSubstringOf(newData);
	      //Verify LOP failure inquiry
	      softly.assertThat("Were there LOPs in place to prevent the triggering event? No n/a").as("test data").isSubstringOf(newData);
	      //Verify SUEP
	      softly.assertThat("(SUEP) S: Substandard Practice? U: Under Management Control? E: Early in Event Sequence? P: Prevention Of Recurrence?").as("test data").isSubstringOf(newData);
	      softly.assertThat("3.17.1 Inadequate procurement and/or design specifications Yes Yes Yes").as("test data").isSubstringOf(newData);
	      softly.assertThat("3.17.2 Inadequate source audit/inspection QA/QC for compliance (if applicable) Yes Yes Yes").as("test data").isSubstringOf(newData);
	      softly.assertThat("3.17.3 Inadequate design qualification and/or testing before use Yes Yes Yes").as("test data").isSubstringOf(newData);
	      softly.assertThat("3.17.4 Inadequate operation: (1) Inadequate operation procedure; (2) Inadequate operating condition; (3) Operation errors Yes Yes Yes").as("test data").isSubstringOf(newData);
	      softly.assertThat("3.17.5 Inadequate periodic surveillance testing Yes Yes Yes 3.17.6 Inadequate maintenance Yes Yes Yes").as("test data").isSubstringOf(newData);
		}
	
	@Test
	public void test()  throws Exception{
		  WebDriverWait wait = new WebDriverWait(driver,30);
		  Login();
		  System.out.println("Title after login: "+driver.getTitle());
		  Thread.sleep(8000);
		  //Waits for the page to load
	      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	      Thread.sleep(5000);
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
		  //Click on Analysis
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-a"))).click();
		  //Click on HiRCA
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-hirca"))).click();
		  //Click on Saved Activities
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-btn-savedactivities"))).click();
		  //Wait for black loading message to disappear
		  try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			  }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		  //Click on an old report in 09/2016
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[5]/a"))).click();
		  //Wait for black loading message to disappear
		  try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			  }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		  //Get data from old report
		  openReportGetData();
		  Thread.sleep(2000);			 
		  /*while(true)
		  {
			  try{
			  if (driver.findElement(By.className("sticky-note")).isDisplayed())
			  {
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();
				  
			  }}catch (org.openqa.selenium.NoSuchElementException e)
			  {
				  break;
			  }
			  catch( org.openqa.selenium.StaleElementReferenceException f)
			  {
				  
				 break;
			  }
			  catch (org.openqa.selenium.TimeoutException u)
			  {
				  break;
			  }
			 
		  }*/
		  
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-signout-button"))).click();
		  
		  afterTest();
		    	  
	  }
	  
	  		  
	 
	  public void afterTest() {
		  driver.quit();
		  softly.assertAll();
		  
	  }

}
