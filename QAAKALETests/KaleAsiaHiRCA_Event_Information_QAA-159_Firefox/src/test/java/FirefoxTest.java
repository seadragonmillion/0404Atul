import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirefoxTest {

	private FirefoxDriver driver;
	private String username ="qaacfi";
	private String password = "S2FsZTk0OTM1ODMwQA==";
	private String gecko_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\geckodriver.exe";
	private String url = "https://kaleasia.error-free.com/";
		
	SoftAssertions softly = new SoftAssertions();
	 
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		 System.out.println("Performing verification on event information page in HiRCA for non admin in Firefox");
		 System.setProperty("webdriver.gecko.driver",gecko_path);
		 ProfilesIni ffProfiles = new ProfilesIni();
		 FirefoxProfile profile = ffProfiles.getProfile("HiRCAEvent");
		 profile.setPreference("browser.download.folderList", 2);
		 profile.setPreference("browser.download.dir", "C:\\Users\\IEUser\\Downloads\\reports");
		 FirefoxOptions options = new FirefoxOptions();
		 options.setCapability(FirefoxDriver.PROFILE, profile);
		 driver = new FirefoxDriver(options);
		 Dimension initialSize= driver.manage().window().getSize();
		 System.out.println(initialSize);
		 int height=initialSize.getHeight();
		 if(height<950)
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
	
	
	@Test
	public void SanityTest() throws Exception{
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  Login obj = new Login ();
		  HiRCAEvent obj1 = new HiRCAEvent();
		  int login = obj.LoginUser(driver, username, password);
		  System.out.println("Title after login: "+driver.getTitle());
		  //Waits for the page to load
	      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  //Switches to the iframe
		  driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		  Thread.sleep(8000);
		  WebDriverWait wait = new WebDriverWait(driver,20);
		  //Clicks on Analysis 
		  try
		  {
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-a"))).click();
		  }catch (UnhandledAlertException f){			  
			  driver.switchTo().alert().dismiss();
		  }
		  try{
             if (login==1)
             {
                   WebDriverWait wait2 = new WebDriverWait(driver,20);
                   Thread.sleep(2000);
                   wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();
             }
             }catch (NoSuchElementException e){
             	   throw e;
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
		  String sub_dept=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[5]/fieldset/div/legend")).getText();
		  System.out.println(sub_dept);
		  softly.assertThat(sub_dept).as("test data").isEqualTo("Sub-department:");
		  String date=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[6]/label")).getText();
		  System.out.println(date);
		  softly.assertThat(date).as("test data").isEqualTo("Date of event:");
		  String time=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[7]/label")).getText();
		  System.out.println(time);
		  softly.assertThat(time).as("test data").isEqualTo("Time of event:");
		  String prob=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[8]/label")).getText();
		  System.out.println(prob);
		  softly.assertThat(prob).as("test data").isEqualTo("Problem statement:");
		  String exec=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[9]/label")).getText();
		  System.out.println(exec);
		  softly.assertThat(exec).as("test data").isEqualTo("Executive summary:");
		  String timeline=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[10]/label")).getText();
		  System.out.println(timeline);
		  softly.assertThat(timeline).as("test data").isEqualTo("Timeline of event:");
		  String back=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[11]/label")).getText();
		  System.out.println(back);
		  softly.assertThat(back).as("test data").isEqualTo("Background information:");
		  String supp1 = driver.findElement(By.id("pii-irca-event-file-fieldcontain-label-0")).getText();
		  System.out.println(supp1);
		  softly.assertThat(supp1).as("test data").isEqualTo("Supporting file (1):");
		  String inve=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[14]/label")).getText();
		  System.out.println(inve);
		  softly.assertThat(inve).as("test data").isEqualTo("Investigators:");
		  String repo=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[15]/label")).getText();
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
				  WebElement textbox4=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[8]"));
				  WebElement error_prob_dotted = textbox4.findElement(By.cssSelector(".ui-input-text.ui-shadow-inset.ui-body-inherit.ui-corner-all.ui-textinput-autogrow.error"));
				  if (error_prob_dotted.isDisplayed())
					  System.out.println("Error dotted line displayed on problem statement textbox");
			  }
			  if(driver.findElement(By.id("pii-irca-event-events-error")).isDisplayed())
			  {
				  String error_timeline = driver.findElement(By.id("pii-irca-event-events-error")).getText();
				  softly.assertThat(error_timeline).as("test data").isEqualTo("Timeline of event is required");
				  WebElement textbox5=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[10]"));
				  WebElement error_timeline_dotted = textbox5.findElement(By.cssSelector(".ui-input-text.ui-shadow-inset.ui-body-inherit.ui-corner-all.ui-textinput-autogrow.error"));
				  if (error_timeline_dotted.isDisplayed())
					  System.out.println("Error dotted line displayed on timeline of event textbox");
			  }
			  if(driver.findElement(By.id("pii-irca-event-bginfos-error")).isDisplayed())
			  {
				  String error_back = driver.findElement(By.id("pii-irca-event-bginfos-error")).getText();
				  softly.assertThat(error_back).as("test data").isEqualTo("Background information is required");
				  WebElement textbox6=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[11]"));
				  WebElement error_back_dotted = textbox6.findElement(By.cssSelector(".ui-input-text.ui-shadow-inset.ui-body-inherit.ui-corner-all.ui-textinput-autogrow.error"));
				  if (error_back_dotted.isDisplayed())
					  System.out.println("Error dotted line displayed on background information textbox");
			  }
			  
			  jse.executeScript("scroll(0, 250)");
			  if(driver.findElement(By.id("pii-irca-event-investigators-error")).isDisplayed())
			  {
				  String error_invest = driver.findElement(By.id("pii-irca-event-investigators-error")).getText();
				  softly.assertThat(error_invest).as("test data").isEqualTo("Investigators is required");
				  WebElement textbox7=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[14]"));
				  WebElement error_invest_dotted = textbox7.findElement(By.cssSelector(".ui-input-text.ui-shadow-inset.ui-body-inherit.ui-corner-all.ui-textinput-autogrow.error"));
				  if (error_invest_dotted.isDisplayed())
					  System.out.println("Error dotted line displayed on investigators textbox");
			  }
		  }
		  
		  //Checks if after entering text if the error message and dotted line disappears
		  //Investigators
		  driver.findElement(By.id("pii-irca-event-investigators")).sendKeys(obj1.paragraph_investigators);
		  if(driver.findElement(By.id("pii-irca-event-investigators-error")).isDisplayed()==false)
		  {
			  String noerror_invest = driver.findElement(By.id("pii-irca-event-investigators-error")).getText();
			  softly.assertThat(noerror_invest).as("test data").isEqualTo("");
			  WebElement ttextbox7=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[14]"));
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
		  driver.findElement(By.id("pii-irca-event-investigators")).sendKeys(obj1.paragraph_investigators);
		  
		  //Background info
		  driver.findElement(By.id("pii-irca-event-bginfos")).sendKeys(obj1.paragraph_background);
		  if(driver.findElement(By.id("pii-irca-event-bginfos-error")).isDisplayed()==false)
		  {
			  String noerror_back = driver.findElement(By.id("pii-irca-event-bginfos-error")).getText();
			  softly.assertThat(noerror_back).as("test data").isEqualTo("");
			  WebElement ttextbox6=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[11]"));
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
		  driver.findElement(By.id("pii-irca-event-bginfos")).sendKeys(obj1.paragraph_background);
		  
		  //Timeline of event
		  driver.findElement(By.id("pii-irca-event-events")).sendKeys(obj1.paragraph_timeline);
		  if(driver.findElement(By.id("pii-irca-event-events-error")).isDisplayed()==false)
		  {
			  String noerror_timeline = driver.findElement(By.id("pii-irca-event-events-error")).getText();
			  softly.assertThat(noerror_timeline).as("test data").isEqualTo("");
			  WebElement ttextbox5=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[10]"));
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
		  driver.findElement(By.id("pii-irca-event-events")).sendKeys(obj1.paragraph_timeline);
		  
		  //Problem Statement
		  driver.findElement(By.id("pii-irca-event-pbstatement")).sendKeys(obj1.paragraph_problem);
		  if(driver.findElement(By.id("pii-irca-event-pbstatement-error")).isDisplayed()==false)
		  {
			  String noerror_prob = driver.findElement(By.id("pii-irca-event-pbstatement-error")).getText();
			  softly.assertThat(noerror_prob).as("test data").isEqualTo("");
			  WebElement ttextbox4=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[8]"));
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
		  driver.findElement(By.id("pii-irca-event-pbstatement")).sendKeys(obj1.paragraph_problem);
		  
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
		  driver.findElement(By.id("pii-irca-event-location")).sendKeys(obj1.text);
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
		  driver.findElement(By.id("pii-irca-event-location")).sendKeys(obj1.text);
		  //Clears all text
		  driver.findElement(By.id("pii-irca-event-location")).clear();
		  //Re enters text
		  driver.findElement(By.id("pii-irca-event-location")).sendKeys(obj1.text);
		  
		  //Event title
		  driver.findElement(By.id("pii-irca-event-title")).sendKeys(obj1.text);
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
		  driver.findElement(By.id("pii-irca-event-title")).sendKeys(obj1.text);
		  //Clears all text
		  driver.findElement(By.id("pii-irca-event-title")).clear();
		  //Re enters text
		  driver.findElement(By.id("pii-irca-event-title")).sendKeys(obj1.text);
		  			
		  //Checks event title text box limit
		  driver.findElement(By.id("pii-irca-event-title")).clear();
		  driver.findElement(By.id("pii-irca-event-title")).sendKeys(obj1.text184);
		  String limit_text = driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div/span")).getText(); 
		  limit_text=limit_text.substring(5,8);
		  int limit = Integer.parseInt(limit_text);
		  System.out.println(limit_text+ " "+limit);
		  for(int i=obj1.text184.length()+1; i<=limit+1;i++)
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
		  driver.findElement(By.id("pii-irca-event-title")).sendKeys(obj1.text184);
		  
		  //Check the date picker
		  driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[6]/div/a")).click();
		  //Close the popup
		  driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/a")).click();
		  Thread.sleep(2000);
		  //Click on date picker
		  driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[6]/div/a")).click();
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
		  driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[7]/div/a")).click();
		  //Close the popup
		  driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/a")).click();
		  Thread.sleep(2000);
		  //Click on time picker
		  driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[7]/div/a")).click();
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
		  Thread.sleep(2000);
		  //Debug
		  //Clicks on save without images
		  jse.executeScript("scroll(0,0)");
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
		  jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		  Thread.sleep(2000);
		  //Check if it allows for uploading more than one file
		  driver.findElement(By.id("pii-irca-addnewfile-button")).click();
		  String error_attach=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).getText();
		  softly.assertThat(error_attach).as("test data").isEqualTo("Please use existing empty supporting file form above");
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		  //Uploads five images
		  obj1.uploadFiveImagesFirefox(driver);
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
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[16]/div/button"))).click();
		  //Clicks on back
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-back"))).click();
		  //Fills optional data
		  //Executive summary
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-execsummary"))).sendKeys(obj1.executive);
		  //Event id
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-crnumber"))).sendKeys(obj1.event_id);
		  //Clicks on Next and proceeds with Root Cause
		  jse.executeScript("scroll(0,6500)");
		  obj1.rootCause(driver);
		  //Clicks on Save
		  driver.findElement(By.id("efi-irca-button-save")).click();
		  //Clicks on Save report
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).click();
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		  //wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-success")));
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
		  while(true)
		  {
			  Thread.sleep(1000);
			  try{
				  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).click();
				  Thread.sleep(1000);
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
		  //Clicks on Info tab
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-tab-0"))).click();		 
		  //Create an expected name
		  String creationDate = driver.findElement(By.id("pii-irca-event-repdatetime")).getAttribute("value");
		  String name = creationDate + "_"+username+"_"+ obj1.text184 ;
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
		  obj1.openCheckRecord(driver, username, get_date, get_time, get_dept, creationDate);
		  Thread.sleep(2000);
		  //Opens record
		  obj1.openReport(driver);
		  Thread.sleep(2000);
		  //Downloads record
		  obj1.downloadRecordFirefox(driver, get_date, get_time, get_dept, creationDate);
		  Thread.sleep(2000);
		  //Shares report
		  obj1.shareReport(driver);
		  Thread.sleep(2000);
		  //Mark critical
		  obj1.markCritical(driver);
		  Thread.sleep(2000);
		  //Creates new record by changing title if f==1 firefox
		  obj1.saveNewReport(driver, username, password, obj,1);
		  Thread.sleep(2000);
		  //Deletes the newly created record
		  obj1.deleteNewRecord(driver, recordName);
		  
		  Thread.sleep(2000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-signout-button"))).click();
		  
		  afterTest();  
		  
	}
	
	public void afterTest(){
		driver.manage().window().maximize();
		//Browser closes
		driver.quit();
		softly.assertAll();
	}

}
