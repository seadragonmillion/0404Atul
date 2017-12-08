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
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class IE10Test {

	private WebDriver driver;
	private String username ="jenkinsvm";
	private String password = "Kalejenkins@123";
	private String ie_path = "C:\\Users\\rramakrishnan\\DriversForSelenium\\IEDriverServer.exe";
	private String url = "https://kaledev.error-free.com/";
	private int numberOfImages=5;
	private int login =0;
	private String keyword_same_eq="QAAfiveeq";
	private String key1_eq="QAAzebraeq";
	private String key2_eq="QAAcameleq";
	private String key3_eq="QAAgiraffeeq";
	private String keyword_same_ee="QAAfiveee";
	private String key1_ee="QAAzebraee";
	private String key2_ee="QAAcamelee";
	private String key3_ee="QAAgiraffeee";
	private String keyword_same_me="QAAfiveme";
	private String key1_me="QAAzebrame";
	private String key2_me="QAAcamelme";
	private String key3_me="QAAgiraffeme";
	private String caseId1,caseId2,caseId3,caseId4,caseId5;
	private String eq_title="QAA Equipment Search Case Upload";
	private String ee_title="QAA Electrical Failure Case Upload";
	private String me_title="QAA Mechanical Failure Case Upload";
	SoftAssertions softly = new SoftAssertions();
	
	@SuppressWarnings("deprecation")
	@Rule
	  public Timeout globalTimeout= new Timeout(8000000);
		  
	@SuppressWarnings("deprecation")
	@Before
	  public void beforeTest() throws MalformedURLException{
		  
		  System.out.println("Equipment case upload in Internet Explorer");
		  System.setProperty("webdriver.ie.driver",ie_path);
		  DesiredCapabilities cap = new DesiredCapabilities(); 
		  cap.setCapability("ignoreZoomSettings", true);
		  cap.setCapability("requireWindowFocus", true);
		  cap.isJavascriptEnabled();
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
	public void deletePreviousCase(String title) throws Exception{
		WebDriverWait wait = new WebDriverWait(driver,40);
		//Clicks on Error free bank
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-e"))).click();
		//Clicks on Equipment Performance Search (PII)
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Equipment Performance Search (PII)"))).click();
		//Enters the title in term search field
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-clear"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).sendKeys(title);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).sendKeys(Keys.ENTER);
		//Waits for black loading message to disappear
		  try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Checks if Exact matches appear
		WebElement exact = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-question-list-equip']/div/h4/a/div")));
		String exactText=exact.getText();
		
		if(exactText.equals("Results")==true)
		{
			int i=1;
			String [] caseIdArray=new String[50];
			while(true)
			{
				try
				{
					String xpath=".//*[@id='pii-question-list-equip']/div[1]/div[1]/div["+i+"]";
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
			deleteCase(caseIdArray,(i-1));
		}
		else 
		{
			System.out.println("No existing cases for: "+title);
		}
		//Clicks on Error free bank
		WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='links']/a[4]")));
		Actions act = new Actions(driver);
		act.click(element1).build().perform();
		Thread.sleep(1000);
		
	}

	public String[] createCase(String keyword_same, String key1, String key2, String key3, String title)throws Exception{
		
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  WebDriverWait wait = new WebDriverWait(driver,40);
		  //Creates 5 cases
		  //Enters mandatory data
		  //Enters case id
		  Random random = new Random();
		  String caseId="";
		  List<WebElement> list = new ArrayList<WebElement>();
		  
		  for(int count=1;count<=5;count++)
		  {
			  //Clicks on Equipment cases
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-manage-button"))).click();
			  //Waits for black loading message to disappear
			  try{
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
				  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
				 }catch (org.openqa.selenium.TimeoutException e)
				  {
					  
				  }
			  
			  Thread.sleep(1000);
			  jse.executeScript("scroll(0,0)");
			  Thread.sleep(3000);
			  //Waits for black loading message to disappear
		  try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		      Thread.sleep(1000);
		      jse.executeScript("scroll(0,0)");
		      Thread.sleep(3000);
			  //Clicks on new case button
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-button-new"))).click();
			  //Clicks on new case
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-title"))).click();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-confirmed"))).click();
			while (true)
		  {
			  Thread.sleep(1000);
			  int y=random.nextInt(10000);
			  if(y<1000)
			     continue;
			  caseId = String.format("%d", y);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-id"))).sendKeys(caseId);
			  Thread.sleep(2000);
			  WebElement errorCaseId;
			  try{
			  errorCaseId=driver.findElement(By.id("pii-admin-efse-id-error"));
			  }catch(org.openqa.selenium.NoSuchElementException e)
			  {
			  	break;
			  }
			  if(errorCaseId.isDisplayed()==true)
			  {
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-id"))).clear();
				  continue;
			  }
			  if(errorCaseId.isDisplayed()==false)
				  break;
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-id"))).clear();
			
			  
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
		  
		  //Selects Category
		  if(title.equals(eq_title))
		  {
			  WebElement dropdown = driver.findElement(By.id("pii-admin-efse-level"));
			  Select s = new Select (dropdown);
			  if(count==1)
				  s.selectByVisibleText("General");
			  if(count==2)
				  s.selectByVisibleText("Mechanical Case Study");
			  if(count==3)
				  s.selectByVisibleText("I&C Case Study");
			  if(count==4)
				  s.selectByVisibleText("Electrical Case Study");
			  if(count==5)
				  s.selectByVisibleText("Software Case Study");
		  }
		  if(title.equals(ee_title))
		  {
			  WebElement dropdown = driver.findElement(By.id("pii-admin-efse-level"));
			  Select s = new Select (dropdown);
			  s.selectByVisibleText("Electrical Failure Mode");
		  }
		  if(title.equals(me_title))
		  {
			  WebElement dropdown = driver.findElement(By.id("pii-admin-efse-level"));
			  Select s = new Select (dropdown);
			  s.selectByVisibleText("Mechanical Failure Mode");
		  }
		  //Enters Question
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-question"))).sendKeys(title);
		  //Enters Answer
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-answer"))).sendKeys(title);
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,1700)");
		  Thread.sleep(1000);
		  //Enters Keyword
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-keyword-search-input"))).sendKeys(keyword_same);
		  Thread.sleep(1500);
		  if(count==1)
		  {
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-keyword-new"))).click();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-title"))).click();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-confirmed"))).click();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-keyword-search-input"))).clear();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-keyword-search-input"))).sendKeys(key1);
			  Thread.sleep(1000);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-keyword-new"))).click();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-title"))).click();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-confirmed"))).click();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-keyword-search-input"))).clear();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-keyword-search-input"))).sendKeys(key2);
			  Thread.sleep(1000);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-keyword-new"))).click();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-title"))).click();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-confirmed"))).click();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-keyword-search-input"))).clear();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-keyword-search-input"))).sendKeys(key3);
			  Thread.sleep(1000);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-keyword-new"))).click();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-title"))).click();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-confirmed"))).click();
		  }
		  else 
		  {
			  Thread.sleep(1000);
			  jse.executeScript("scroll(0,1700)");
			  Thread.sleep(1000);
			  WebElement element = driver.findElement(By.xpath(".//*[@id='pii-admin-efse-keyword-blocks']/div[2]/ul"));
			  element.findElement(By.cssSelector(".ui-first-child.ui-last-child")).click();
			  //Clicks on add keyword
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-title"))).click();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-confirmed"))).click();
		  }
		 
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(1000);
		  //Uploads 5 slides
		  Actions act = new Actions(driver);
		  WebElement ele =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-upload-file-input")));
		  act.doubleClick(ele).build().perform();
		  Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlides_IE10.exe");
		  p.waitFor();
		  Thread.sleep(3000);
		  //Checks if 5 images have been uploaded
		  //if(count==1 && title.equals(eq_title))
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efse-upload-form-selectedfiles-div']/h5/a"))).click();
		  Thread.sleep(2000);
		  int i;
		  for (i=0; i<5;i++)
		  {
			  String xpath = ".//*[@id='pii-admin-efse-upload-form-selectedfiles']/div["+(i+1)+"]";
			  if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).isDisplayed())
			  {
				  System.out.println("Uploaded Image : " + (i+1));
				  list.add(driver.findElement(By.xpath(xpath)));
			  }
			  Thread.sleep(1000);
		  }
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(1000);
		  //Clicks on save
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-button-save"))).click();
		  //Clicks on create case
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-title"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-confirmed"))).click();
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
		  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  }
		  String[] array={caseId1,caseId2,caseId3,caseId4,caseId5};
		return array;
	}
	
	public void compareSlide(String caseId, String title,int y) throws Exception{
		
		  WebDriverWait wait = new WebDriverWait(driver,40);
		  Thread.sleep(1000);
		  //Clicks on Error free bank
		  WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='links']/a[4]")));
		  Actions act = new Actions(driver);
		  act.click(element1).build().perform();
		  Thread.sleep(1000);
		  if(title.equals(eq_title)&&y==0)
		  {
			//Clicks on Equipment Performance Search
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Equipment Performance Search"))).click();
		  }
		  if(y==1)
		  {
			//Clicks on Equipment Performance Search (PII)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Equipment Performance Search (PII)"))).click();
		  }
		  if(title.equals(ee_title))
		  {
			//Clicks on Electrical Failure Mode Search
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Electrical Failure Mode Search"))).click();
		  }
		  if(title.equals(me_title))
		  {
			//Clicks on Mechanical Failure Mode Search
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Mechanical Failure Mode Search"))).click();
		  }
		  //Enters case id
		  driver.findElement(By.id("pii-efse-searchbyid-input")).sendKeys(caseId);
		  driver.findElement(By.id("pii-efse-searchbyid-input")).sendKeys(Keys.ENTER);
		  //Clicks on collapsible
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId))).click();
		  //Clicks on Show Slides
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-button-equip-F"+caseId)));
		  Thread.sleep(4000);
		  WebElement element =  driver.findElement(By.id("pii-slideshow-button-equip-F"+caseId));
		  String slide = element.getText();
		  element.sendKeys(Keys.TAB);
		  element.sendKeys(Keys.ENTER);
		  System.out.println(slide);
		  int n = numberOfImages+1;
		  Thread.sleep(1000);
		  System.out.println("Found Slide 1");
		  Thread.sleep(500);
		  String id = "pii-slideshow-equip-F"+caseId;
		  //Checking if slide number appears and is correct
		  String actual_slide1 = driver.findElement(By.xpath(".//*[@id='"+id+"']/ul/li/span/span[2]")).getText();
		  String expected_slide1 = "1/"+n;
		  softly.assertThat(actual_slide1).as("test data").isEqualTo(expected_slide1);
		  Thread.sleep(1000);
		  //Checking if title is correct
		  String actual_title1 = driver.findElement(By.xpath(".//*[@id='"+id+"']/ul/li/div")).getText();
		  String expected_title1 = "F"+caseId+": "+title;
		  softly.assertThat(actual_title1).as("test data").isEqualTo(expected_title1);
		  //Checking if footer image appears
		  if(driver.findElement(By.xpath(".//*[@id='"+id+"']/ul/li/span/img")).isDisplayed())
			  System.out.println("Logo is displayed");
		  //Checking if copyright is correct
		  String actual_copyright1 = driver.findElement(By.xpath(".//*[@id='"+id+"']/ul/li/span/span")).getText();
		  String expected_copyright1 = "Copyright and Proprietary, Error-Free Inc. and Performance Improvement International LLC, 2017. Derivative Product Strictly Prohibited.";
		  softly.assertThat(actual_copyright1).as("test data").isEqualTo(expected_copyright1);
		  //Click on next
		  driver.findElement(By.linkText("Next")).click();
		  //Checks if there are slides present
		  for (int i=2;i<=n;i++)
		  {
			  String id1 = "pii-slideimg-F"+caseId+"-"+(i-1);
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
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-clear"))).click();
		  Thread.sleep(2000);
		  
	}
	public void checkkeyword (String[]caseId, String keyword_same, String key1, String key2, String key3, int y, String title) throws Exception
	{
		  WebDriverWait wait = new WebDriverWait(driver,40);
		  //Clicks on Error free bank
		  try
		  {
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='links']/a[4]"))).click();
		  }catch (UnhandledAlertException f){			  
			  driver.switchTo().alert().dismiss();
		  }
		  if(keyword_same.equals(keyword_same_eq)&&y==0)
		  {
			//Clicks on Equipment Performance Search
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Equipment Performance Search"))).click();
		  }
		  if(y==1)
		  {
			//Clicks on Equipment Performance Search (PII)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Equipment Performance Search (PII)"))).click();
		  }
		  if(keyword_same.equals(keyword_same_ee))
		  {
			//Clicks on Electrical Failure Mode Search
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Electrical Failure Mode Search"))).click();
		  }
		  if(keyword_same.equals(keyword_same_me))
		  {
			//Clicks on Mechanical Failure Mode Search
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Mechanical Failure Mode Search"))).click();
		  }
		  //Enters the term and check the search by enter
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-clear"))).click();
		  Thread.sleep(1000);
		  //Waits for black loading message to disappear
		  try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).sendKeys(keyword_same);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).sendKeys(Keys.ENTER);
		  //Checks for the five cases
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId[0])));
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId[1])));
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId[2])));
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId[3])));
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId[4])));
		  Thread.sleep(1000);
		  //Clicks on clear
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-clear"))).click();
		  //Enters the term with 3 unique keywords
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).sendKeys(key1);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).sendKeys(Keys.ENTER);
		  //Checks for the case id 1
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId[0])));
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-clear"))).click();
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).sendKeys(key2);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).sendKeys(Keys.ENTER);
		  //Checks for the case id 1
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId[0])));
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-clear"))).click();
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).sendKeys(key3);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).sendKeys(Keys.ENTER);
		  //Waits for black loading message to disappear
		  try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		  //Checks for the case id 1
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId[0])));
		  Thread.sleep(1000);		 
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-clear"))).click();
		  Thread.sleep(1000);
		  //Search by title
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).sendKeys(title);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).sendKeys(Keys.ENTER);
		  //Checks for the five cases
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId[0])));
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId[1])));
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId[2])));
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId[3])));
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId[4])));
		  Thread.sleep(1000);
		  //Clicks on clear
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-clear"))).click();
	}
	
	public void checkCase(String eq_caseId, String ee_caseId, String me_caseId) throws Exception{
		
		  WebDriverWait wait = new WebDriverWait(driver,40);
		  //Clicks on Error free bank
		  try
		  {
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='links']/a[4]"))).click();
		  }catch (UnhandledAlertException f){			  
			  driver.switchTo().alert().dismiss();
		  }
		  //Clicks on Equipment Performance Search
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Equipment Performance Search"))).click();
		  //Clicks on clear
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-clear"))).click();
		  //Enters Electrical Case id to see if it exists
		  driver.findElement(By.id("pii-efse-searchbyid-input")).sendKeys(ee_caseId);
		  driver.findElement(By.id("pii-efse-searchbyid-input")).sendKeys(Keys.ENTER);
		  //Waits for black loading message to disappear
		  try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		  //Checks for the error message
		  if (driver.findElement(By.xpath(".//*[@id='pii-efse-search-message']/div")).isDisplayed())
			  System.out.println("Electrical case not found in Equipment Search");
		  //Clicks on clear
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-clear"))).click();
		  //Enters Mechanical Case id to see if it exists
		  driver.findElement(By.id("pii-efse-searchbyid-input")).sendKeys(me_caseId);
		  driver.findElement(By.id("pii-efse-searchbyid-input")).sendKeys(Keys.ENTER);
		  //Waits for black loading message to disappear
		  try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		  //Checks for the error message
		  if (driver.findElement(By.xpath(".//*[@id='pii-efse-search-message']/div")).isDisplayed())
			  System.out.println("Mechanical case not found in Equipment Search");
		  //Clicks on Error free bank
		  try
		  {
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='links']/a[4]"))).click();
		  }catch (UnhandledAlertException f){			  
			  driver.switchTo().alert().dismiss();
		  }
		  //Clicks on Equipment Performance Search (PII)
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Equipment Performance Search (PII)"))).click();
		  //Clicks on clear
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-clear"))).click();
		  //Enters Electrical Case id to see if it exists
		  driver.findElement(By.id("pii-efse-searchbyid-input")).sendKeys(ee_caseId);
		  driver.findElement(By.id("pii-efse-searchbyid-input")).sendKeys(Keys.ENTER);
		  //Waits for black loading message to disappear
		  try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		  //Checks for electrical case
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+ee_caseId)));
		  System.out.println("Electrical case found in Equipment Performance Search (PII)");
		  //Clicks on clear
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-clear"))).click();
		  //Enters Mechanical Case id to see if it exists
		  driver.findElement(By.id("pii-efse-searchbyid-input")).sendKeys(me_caseId);
		  driver.findElement(By.id("pii-efse-searchbyid-input")).sendKeys(Keys.ENTER);
		  //Waits for black loading message to disappear
		  try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		  //Checks for mechanical case
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+me_caseId)));
		  System.out.println("Mechanical case found in Equipment Performance Search (PII)");
		  //Clicks on Error free bank
		  try
		  {
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='links']/a[4]"))).click();
		  }catch (UnhandledAlertException f){			  
			  driver.switchTo().alert().dismiss();
		  }
		  //Clicks on Electrical Failure Mode Search
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Electrical Failure Mode Search"))).click();
		  //Clicks on clear
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-clear"))).click();
		  //Enters Equipment Case id to see if it exists
		  driver.findElement(By.id("pii-efse-searchbyid-input")).sendKeys(eq_caseId);
		  driver.findElement(By.id("pii-efse-searchbyid-input")).sendKeys(Keys.ENTER);
		  //Waits for black loading message to disappear
		  try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		  //Checks for the error message
		  if (driver.findElement(By.xpath(".//*[@id='pii-efse-search-message']/div")).isDisplayed())
			  System.out.println("Equipment case not found in Electrical Search");
		  //Clicks on clear
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-clear"))).click();
		  //Clicks on Error free bank
		  try
		  {
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='links']/a[4]"))).click();
		  }catch (UnhandledAlertException f){			  
			  driver.switchTo().alert().dismiss();
		  }
		  //Clicks on Mechanical Failure Mode Search
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Mechanical Failure Mode Search"))).click();
		  //Clicks on clear
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-clear"))).click();
		  //Enters Equipment Case id to see if it exists
		  driver.findElement(By.id("pii-efse-searchbyid-input")).sendKeys(eq_caseId);
		  driver.findElement(By.id("pii-efse-searchbyid-input")).sendKeys(Keys.ENTER);
		  //Waits for black loading message to disappear
		  try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		  //Checks for the error message
		  if (driver.findElement(By.xpath(".//*[@id='pii-efse-search-message']/div")).isDisplayed())
			  System.out.println("Equipment case not found in Mechanical Search");
		  //Clicks on clear
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-clear"))).click();
	}
	
	public void deleteCase(String[] caseId1, int len) throws Exception{
		  WebDriverWait wait = new WebDriverWait(driver,40);
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  //Clicks on admin user name on top right corner
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		  //Clicks on admin option
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-admin"))).click();
		  Thread.sleep(1000);
		  //Clicks on Errorfree bank option
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efbank']/h3/a"))).click();
		  for(int i=0;i<len;i++)
		  {
		   String caseId = caseId1[i];
		  //Clicks on Equipment cases
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-manage-button"))).click();
		  //Waits for black loading message to disappear
		  try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		  //Click on enter case id
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-list-input"))).sendKeys(caseId);
		  Thread.sleep(2000);
		  //Clicks on case id
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-list-ul"))).click();
		 //Waits for black loading message to disappear
		  try{
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(3000);
		  //Clicks on delete button
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-button-delete"))).click();
		  //Clicks on delete case
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-title"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-confirmed"))).click();
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
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-list-input"))).clear();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-list-input"))).sendKeys(caseId);
		  Thread.sleep(2000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-list-input"))).sendKeys(Keys.ENTER);
		  Thread.sleep(1000);
		  if(driver.findElement(By.id("pii-admin-efse-list-ul")).isDisplayed()==false)
			  System.out.println("Case deleted: "+caseId1[i]);
		  }
		  //Clicks on Errorfree bank option to close the collapsible menu
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efbank']/h3/a"))).click();
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
		  Thread.sleep(8000);
		  WebDriverWait wait = new WebDriverWait(driver,40);
		  //Clicks on Error free bank
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-e"))).click();
		  deletePreviousCase(eq_title);
		  Thread.sleep(1000);
		  deletePreviousCase(ee_title);
		  Thread.sleep(1000);
		  deletePreviousCase(me_title);
		  Thread.sleep(1000);
		  //Clicks on admin user name on top right corner
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		  //Clicks on admin option
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-admin"))).click();
		  //Clicks on Errorfree bank option
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efbank']/h3/a"))).click();
		  //Clicks on Equipment cases
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-manage-button"))).click();
		  //Creates 5 slides for Equipment Case Search
		  String[] eq_caseid=createCase(keyword_same_eq,key1_eq,key2_eq,key3_eq,eq_title);
		  System.out.println("Slides created for equipment: "+ eq_caseid[0] +" "+ eq_caseid[1] +" "+ eq_caseid[2] +" "+ eq_caseid[3] +" "+ eq_caseid[4]);
		  Thread.sleep(2000);
		  //Creates 5 slides for Electrical Case Search
		  String[] ee_caseid=createCase(keyword_same_ee,key1_ee,key2_ee,key3_ee,ee_title);
		  System.out.println("Slides created for electrical "+ee_caseid[0] +" "+ ee_caseid[1] +" "+ ee_caseid[2] +" "+ ee_caseid[3] +" "+ ee_caseid[4]);
		  Thread.sleep(2000);
		  //Creates 5 slides for Mechanical Case Search
		  String[] me_caseid=createCase(keyword_same_me,key1_me,key2_me,key3_me,me_title);
		  System.out.println("Slides created for mechanical "+me_caseid[0] +" "+ me_caseid[1] +" "+ me_caseid[2] +" "+ me_caseid[3] +" "+ me_caseid[4]);
		  //Clicks on Errorfree bank option to close the collapsible menu
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efbank']/h3/a"))).click();
		  Thread.sleep(2000);
		  //Checks slides for one Equipment non PII case
		  compareSlide(eq_caseid[0],eq_title,0);
		  System.out.println("Slide checked for equipment");
		  Thread.sleep(2000);
		  //Checks slides for one Equipment PII case
		  compareSlide(eq_caseid[0],eq_title,1);
		  System.out.println("Slide checked for equipment pii");
		  Thread.sleep(2000);
		  //Checks slides for one Electrical case
		  compareSlide(ee_caseid[0],ee_title,0);
		  System.out.println("Slide checked for electrical");
		  Thread.sleep(2000);
		  //Checks slides for one Mechanical case
		  compareSlide(me_caseid[0],me_title,0);
		  System.out.println("Slide checked for mechanical");
		  Thread.sleep(2000);
		  //Check the keyword search for Equipment
		  checkkeyword (eq_caseid,keyword_same_eq,key1_eq,key2_eq,key3_eq,0,eq_title);
		  System.out.println("Keyword checked for equipment");
		  Thread.sleep(2000);
		  //Check the keyword search for Equipment PII
		  checkkeyword (eq_caseid,keyword_same_eq,key1_eq,key2_eq,key3_eq,1,eq_title);
		  System.out.println("Keyword checked for equipment pii");
		  Thread.sleep(2000);
		  //Check the keyword search for Electrical
		  checkkeyword (ee_caseid,keyword_same_ee,key1_ee,key2_ee,key3_ee,0,ee_title);
		  System.out.println("Keyword checked for electrical");
		  Thread.sleep(2000);
		  //Check the keyword search for Mechanical
		  checkkeyword (me_caseid,keyword_same_me,key1_me,key2_me,key3_me,0,me_title);
		  System.out.println("Keyword checked for mechanical");
		  Thread.sleep(2000);
		  //Check for presence of Equipment cases in Mechanical or Electrical modules
		  checkCase(eq_caseid[1],ee_caseid[1],me_caseid[1]);
		  System.out.println("Cases checked in each module");
		  Thread.sleep(2000);
		  //Deletes Equipment cases
		  deleteCase(eq_caseid,5);
		  System.out.println("Slides deleted for equipment");
		  Thread.sleep(2000);
		  //Deletes Electrical cases
		  deleteCase(ee_caseid,5);
		  System.out.println("Slides deleted for electrical");
		  Thread.sleep(2000);
		  //Deletes Mechanical cases
		  deleteCase(me_caseid,5);
		  System.out.println("Slides deleted for mechanical");
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
		
		driver.manage().window().maximize();
		//Browser closes
		driver.quit();
		softly.assertAll();
	}

}
