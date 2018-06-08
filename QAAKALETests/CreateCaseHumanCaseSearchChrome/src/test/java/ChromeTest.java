import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Base64;

public class ChromeTest {

	private WebDriver driver;
	private String username ="jenkinsvm";
	private String password = "S2FsZWplbmtpbnNAMTIz";
	private String chrome_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\chromedriver.exe";
	private String url = "https://kaledev.error-free.com/";
	private int numberOfImages=5;
	private int login =0;
	private String keyword_same="QAAfive";
	private String key1="QAAzebra";
	private String key2="QAAcamel";
	private String key3="QAAgiraffe";
	private String title ="QAA Human Performance Case Upload";
	private String caseId1,caseId2,caseId3,caseId4,caseId5;
	SoftAssertions softly = new SoftAssertions();
	
		  
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Human Case Upload in Chrome");
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
		
	public int deletePreviousCase() throws Exception{
		WebDriverWait wait = new WebDriverWait(driver,40);
		//Clicks on Error free bank
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-e"))).click();
		//Clicks on Human Performance Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Human Performance"))).click();
		//Enters the title in term search field
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-clear"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-searchbykw-input"))).sendKeys(title);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-searchbykw-input"))).sendKeys(Keys.ENTER);
		//Waits for black loading message to disappear
		  try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Checks if Exact matches appear
		WebElement exact = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-question-list']/div/h4/a/div")));
		String exactText=exact.getText();
		
		if(exactText.equals("Results")==true)
		{
			int i=1;
			String [] caseIdArray=new String[50];
			while(true)
			{
				try
				{
					String xpath=".//*[@id='pii-question-list']/div[1]/div[1]/div["+i+"]";
					System.out.println(xpath);
					WebElement row=driver.findElement(By.xpath(xpath));
					String rowCaseId=row.getAttribute("qid");
					rowCaseId=rowCaseId.substring(1);
					System.out.println("Case id:" +rowCaseId);
					caseIdArray[i-1]=rowCaseId;
					i=i+1;
				}catch(NoSuchElementException e)
				{
					break;
				}
			}
			for(int count =0;count<=(i-2);count++)
			{
				System.out.println(caseIdArray[count]);
				deleteCase(caseIdArray[count],count+1);
			}
			return 1;
		}
		else 
		{
			System.out.println("No existing cases");
			return 0;
		}
		
	}

	public void deleteCase(String caseId, int y) throws Exception{
		  WebDriverWait wait = new WebDriverWait(driver,40);
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  //Clicks on admin user name on top right corner
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		  //Clicks on admin option
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-admin"))).click();
		  Thread.sleep(1000);
		  //Clicks on Errorfree bank option
		  if(y==1)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efbank']/h3/a"))).click();
		  //Clicks on Human cases
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-manage-button"))).click();
		  //Waits for black loading message to disappear
		  try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		  //CLick on enter case id
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-list-input"))).sendKeys(caseId);
		  Thread.sleep(2000);
		  //Clicks on case id
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-list-ul"))).click();
		 //Waits for black loading message to disappear
		  try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		  //Clicks on delete button
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-button-delete"))).click();
		  //Clicks on delete case
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-dialog-title"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-dialog-confirmed"))).click();
		  try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(1000);
		  //Checks if case deleted
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-list-input"))).clear();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-list-input"))).sendKeys(caseId);
		  Thread.sleep(2000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-list-input"))).sendKeys(Keys.ENTER);
		  Thread.sleep(1000);
		  if(driver.findElement(By.id("pii-admin-efsh-list-ul")).isDisplayed()==false)
			  System.out.println("Case deleted");
		  
	}
	
	public void compareSlide(String caseId,List<WebElement> list) throws Exception{
		
		  WebDriverWait wait = new WebDriverWait(driver,40);
		  //Clicks on Error free bank
		  try
		  {
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='links']/a[4]"))).click();
		  }catch (UnhandledAlertException f){			  
			  driver.switchTo().alert().dismiss();
		  }
		  //Clicks on Human Performance Search
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Human Performance"))).click();
		  //Enters case id
		  driver.findElement(By.id("pii-efsh-searchbyid-input")).sendKeys(caseId);
		  driver.findElement(By.id("pii-efsh-searchbyid-input")).sendKeys(Keys.ENTER);
		  //Clicks on collapsible
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+caseId))).click();
		  //Clicks on Show Slides
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-button-Q"+caseId)));
		  Thread.sleep(4000);
		  WebElement element =  driver.findElement(By.id("pii-slideshow-button-Q"+caseId));
		  String slide = element.getText();
		  element.sendKeys(Keys.TAB);
		  element.sendKeys(Keys.ENTER);
		  System.out.println(slide);
		  int n = numberOfImages+1;
		  Thread.sleep(1000);
		  System.out.println("Found Slide 1");
		  Thread.sleep(500);
		  String id = "pii-slideshow-Q"+caseId;
		  //Checking if slide number appears and is correct
		  String actual_slide1 = driver.findElement(By.xpath(".//*[@id='"+id+"']/ul/li/span/span[2]")).getText();
		  String expected_slide1 = "1/"+n;
		  softly.assertThat(actual_slide1).as("test data").isEqualTo(expected_slide1);
		  Thread.sleep(1000);
		  //Checking if title is correct
		  String actual_title1 = driver.findElement(By.xpath(".//*[@id='"+id+"']/ul/li/div")).getText();
		  String expected_title1 = "Q"+caseId+": "+title;
		  softly.assertThat(actual_title1).as("test data").isEqualTo(expected_title1);
		  //Checking if footer image appears
		  if(driver.findElement(By.xpath(".//*[@id='"+id+"']/ul/li/span/img")).isDisplayed())
			  System.out.println("Logo is displayed");
		  //Checking if copyright is correct
		  String actual_copyright1 = driver.findElement(By.xpath(".//*[@id='"+id+"']/ul/li/span/span")).getText();
		  String expected_copyright1 = "Copyright and Proprietary, Error-Free Inc. and Performance Improvement International LLC, 2018. Derivative Product Strictly Prohibited.";
		  softly.assertThat(actual_copyright1).as("test data").isEqualTo(expected_copyright1);
		  //Click on next
		  driver.findElement(By.linkText("Next")).click();
		  //Checks if there are slides present
		  for (int i=2;i<=n;i++)
		  {
			  String id1 = "pii-slideimg-Q"+caseId+"-"+(i-1);
			  Thread.sleep(1000);
			  WebElement ele = driver.findElement(By.id(id1));
			  if (ele.isDisplayed())
				  System.out.println("Found Slide "+i);
			  Thread.sleep(500);
			  //Checking if title is correct
			  String title_xpath = ".//*[@id='"+id+"']/ul/li["+i+"]/div";
			  actual_title1 = driver.findElement(By.xpath(title_xpath)).getText();
			  softly.assertThat(actual_title1).as("test data").isEqualTo(expected_title1);
			  //Checking if copyright is correct
			  String copyright_xpath = ".//*[@id='"+id+"']/ul/li["+i+"]/span/span";
			  actual_copyright1 = driver.findElement(By.xpath(copyright_xpath)).getText();
			  softly.assertThat(actual_copyright1).as("test data").isEqualTo(expected_copyright1);
			  //Checking if footer image appears
			  String image_xpath = ".//*[@id='"+id+"']/ul/li["+i+"]/span/img";
			  if(driver.findElement(By.xpath(image_xpath)).isDisplayed())
				  System.out.println("Logo is displayed");
			  //Checking if slide number appears and is correct
			  String slide_xpath = ".//*[@id='"+id+"']/ul/li["+i+"]/span/span[2]";
			  actual_slide1 = driver.findElement(By.xpath(slide_xpath)).getText();
			  expected_slide1 = i+"/"+n;
			  softly.assertThat(actual_slide1).as("test data").isEqualTo(expected_slide1);
			  //Click on next
			  driver.findElement(By.linkText("Next")).click();
		  }
		  //Clicks on close button
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='"+id+"']/a"))).click();
		  //Clicks on clear
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-clear"))).click();
		  
	}
	
	public void checkkeyword (String caseId1,String caseId2,String caseId3,String caseId4,String caseId5) throws Exception
	{
		  WebDriverWait wait = new WebDriverWait(driver,40);
		  //Enters the term and check the search by enter
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-clear"))).click();
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-searchbykw-input"))).sendKeys(keyword_same);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-searchbykw-input"))).sendKeys(Keys.ENTER);
		  //Checks for the five cases
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+caseId1)));
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+caseId2)));
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+caseId3)));
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+caseId4)));
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+caseId5)));
		  Thread.sleep(1000);
		  //Clicks on clear
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-clear"))).click();
		  //Enters the term with 3 unique keywords
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-searchbykw-input"))).sendKeys(key1);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-searchbykw-input"))).sendKeys(Keys.ENTER);
		  //Checks for the case id 1
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+caseId1)));
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-clear"))).click();
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-searchbykw-input"))).sendKeys(key2);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-searchbykw-input"))).sendKeys(Keys.ENTER);
		  //Checks for the case id 1
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+caseId1)));
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-clear"))).click();
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-searchbykw-input"))).sendKeys(key3);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-searchbykw-input"))).sendKeys(Keys.ENTER);
		  //Checks for the case id 1
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+caseId1)));
		  Thread.sleep(1000);
		  //Enters the title and check the search by enter
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-clear"))).click();
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-searchbykw-input"))).sendKeys(title);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-searchbykw-input"))).sendKeys(Keys.ENTER);
		  //Checks for the five cases
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+caseId1)));
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+caseId2)));
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+caseId3)));
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+caseId4)));
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+caseId5)));
		  Thread.sleep(1000);
		  //Clicks on clear
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-clear"))).click();
		  
	}
	
	@Test
	  public void SanityTest() throws Exception{
		 try{ 
		 	CaseBrowse obj = new CaseBrowse();
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
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
		  int m=deletePreviousCase();
		  WebDriverWait wait = new WebDriverWait(driver,40);
		  //Clicks on admin user name on top right corner
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		  //Clicks on admin option
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-admin"))).click();
		  //Clicks on Errorfree bank option
		  if(m==0)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efbank']/h3/a"))).click();
		  //Clicks on Human cases
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-manage-button"))).click();
		  //Creates 5 cases
		  //Enters mandatory data
		  //Enters case id
		  Random random = new Random();
		  String caseId="";
		  List<WebElement> list = new ArrayList<WebElement>();
		  
		  for(int count=1;count<=5;count++)
		  {
			  //Waits for black loading message to disappear
		  try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
			  //Clicks on new case button
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-button-new"))).click();
			  //Clicks on new case
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-dialog-title"))).click();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-dialog-confirmed"))).click();
			while (true)
		  {
			  Thread.sleep(1000);
			  int y=random.nextInt(10000);
			  if(y<1000)
			     continue;
			  caseId = String.format("%d", y);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-id"))).sendKeys(caseId);
			  Thread.sleep(1000);
			  WebElement errorCaseId=driver.findElement(By.id("pii-admin-efsh-id-error"));
			  if(errorCaseId.isDisplayed()==true)
			  {
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-id"))).clear();
				  continue;
			  }
			  if(errorCaseId.isDisplayed()==false)
				  break;
		  }
		  System.out.println("Case id: "+ caseId);
		  if(count==1)
			  caseId1=caseId;
		  if(count==2)
			  caseId2=caseId;
		  if(count==3)
			  caseId3=caseId;
		  if(count==4)
			  caseId4=caseId;
		  if(count==5)
			  caseId5=caseId;
		  //Enters Question
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-question"))).sendKeys(title);
		  //Enters Answer
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-answer"))).sendKeys(title);
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,1700)");
		  Thread.sleep(1000);
		  //Enters Keyword
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-keyword-search-input"))).sendKeys(keyword_same);
		  Thread.sleep(1500);
		  if(count==1)
		  {
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-keyword-new"))).click();
			  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-dialog-title"))).click();
			  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-dialog-confirmed"))).click();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-keyword-search-input"))).clear();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-keyword-search-input"))).sendKeys(key1);
			  Thread.sleep(1000);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-keyword-new"))).click();
			  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-dialog-title"))).click();
			  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-dialog-confirmed"))).click();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-keyword-search-input"))).clear();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-keyword-search-input"))).sendKeys(key2);
			  Thread.sleep(1000);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-keyword-new"))).click();
			  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-dialog-title"))).click();
			  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-dialog-confirmed"))).click();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-keyword-search-input"))).clear();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-keyword-search-input"))).sendKeys(key3);
			  Thread.sleep(1000);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-keyword-new"))).click();
			  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-dialog-title"))).click();
			  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-dialog-confirmed"))).click();
			  //Add keyword with all special characters
			  obj.addKeywordWithAllSpecialCharactersHuman(driver);
		  }
		  else 
		  {
			  WebElement element = driver.findElement(By.xpath(".//*[@id='pii-admin-efsh-keyword-blocks']/div[2]/ul"));
			  element.findElement(By.cssSelector(".ui-first-child.ui-last-child")).click();
			//Clicks on add keyword
			  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-dialog-title"))).click();
			  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-dialog-confirmed"))).click();
		  }
		 
		  //Enters task
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-task-search-input"))).sendKeys(keyword_same);
		  Thread.sleep(1500);
		  if(count==1)
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-task-new"))).click();
		  else
		  {
			  WebElement element = driver.findElement(By.xpath(".//*[@id='pii-admin-efsh-task-blocks']/div[2]/ul"));
			  element.findElement(By.cssSelector(".ui-first-child.ui-last-child")).click();			  
		  }
		  //Clicks on add task
		  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-dialog-title"))).click();
		  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-dialog-confirmed"))).click();
		  //Enters purpose
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-purpose-search-input"))).sendKeys(keyword_same);
		  Thread.sleep(1500);
		  if(count==1)
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-purpose-new"))).click();
		  else
		  {
			  WebElement element = driver.findElement(By.xpath(".//*[@id='pii-admin-efsh-purpose-blocks']/div[2]/ul"));
			  element.findElement(By.cssSelector(".ui-first-child.ui-last-child")).click();	
		  }
		  //Clicks on add purpose
		  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-dialog-title"))).click();
		  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-dialog-confirmed"))).click();
		  jse.executeScript("scroll(0,2000)");
		  //Enters condition
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-condition-search-input"))).sendKeys(keyword_same);
		  Thread.sleep(1500);
		  jse.executeScript("scroll(0,2000)");
		  if(count==1)
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-condition-new"))).click();
		  else
		  {
			  WebElement element = driver.findElement(By.xpath(".//*[@id='pii-admin-efsh-condition-blocks']/div[2]/ul"));
			  element.findElement(By.cssSelector(".ui-first-child.ui-last-child")).click();	
		  }
		  //Clicks on add condition
		 // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-dialog-title"))).click();
		 // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-dialog-confirmed"))).click();
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(1000);
		  //Uploads 5 slides
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-upload-file-input"))).click();
		  Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlides.exe");
		  p.waitFor();
		  Thread.sleep(3000);
		  //Checks if 5 images have been uploaded
		  if(count==1)
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efsh-upload-form-selectedfiles-div']/h5/a"))).click();
		  Thread.sleep(2000);
		  int i;
		  int n=1000;
		  for (i=0; i<5;i++)
		  {
			  String xpath = ".//*[@id='pii-admin-efsh-upload-form-selectedfiles']/div["+(i+1)+"]";
			  if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).isDisplayed())
			  {
				  System.out.println("Uploaded Image : " + (i+1));
				  list.add(driver.findElement(By.xpath(xpath)));
			  }
			  n=n+100;
			  String scroll = "scroll(0,"+n+")";
			  Thread.sleep(1000);
			  jse.executeScript(scroll);
			  Thread.sleep(1000);
		  }
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(1000);
		  //Clicks on save
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-button-save"))).click();
		  //Clicks on create case
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-dialog-title"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-dialog-confirmed"))).click();
		  //Waits for black loading message to disappear
		  try{
			  Thread.sleep(1000);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  Thread.sleep(1000);
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		  //Waits for the green popup on the right top corner
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  }
		  Thread.sleep(2000);
		  compareSlide(caseId,list);
		  Thread.sleep(2000);
		  checkkeyword(caseId1,caseId2,caseId3,caseId4,caseId5);
		  //Search for keyword with all Special characters
		  obj.searchWithKeyKeywordWithAllSpecialCharacters(driver,caseId1);
		  //Search for keyword with special character in middle and check if dropdown disappears
		  obj.searchWithKeywordKALE1964(driver,softly);
		  Thread.sleep(2000);
		  deleteCase(caseId1,0);
		  Thread.sleep(2000);
		  deleteCase(caseId2,0);
		  Thread.sleep(2000);
		  deleteCase(caseId3,0);
		  Thread.sleep(2000);
		  deleteCase(caseId4,0);
		  Thread.sleep(2000);
		  deleteCase(caseId5,0);
		  Thread.sleep(2000);
		  //Logs out
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-signout-button"))).click();
		  Thread.sleep(2000);
		  afterTest();
		 }catch (TimeoutException e)
		  {
			  driver.quit();
		  }
	}
public void afterTest(){
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-login-button")));
		//Browser closes
		driver.quit();
		softly.assertAll();
	}

}
