import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HumanCaseLoad {
	
	String keyword1 = "Slide100images";
	String keyword2 = "Slide100NoImages";
	String keyword3 = "Slide100Images50";
	String keyword1ie = "Slide100imagesie";
	String keyword2ie = "Slide100NoImagesie";
	String keyword3ie = "Slide100Images50ie";
	String title1 = "QAA 100 Slides only images";
	String title2 = "QAA 100 Slides no images";
	String title3 = "QAA 100 Slides 50 images";
	String title1ie = "QAA IE11 100 Slides only images";
	String title2ie = "QAA IE11 100 Slides no images";
	String title3ie = "QAA IE11 100 Slides 50 images";
	String sheetHumanDev = "HumanPerformanceDev";
	String sheetHumanAsia = "HumanPerformanceAsia";
	String sheetHumanUSA = "HumanPerformanceUSA";
	String sheetEquipDev = "EquipmentPerformanceDev";
	String sheetEquipAsia = "EquipmentPerformanceAsia";
	String sheetEquipUSA = "EquipmentPerformanceUSA";
	String sheetElecDev = "ElectricalFailureDev";
	String sheetElecAsia = "ElectricalFailureAsia";
	String sheetElecUSA = "ElectricalFailureUSA";
	String sheetMechDev = "MechanicalFailureDev";
	String sheetMechAsia = "MechanicalFailureAsia";
	String sheetMechUSA = "MechanicalFailureUSA";
	
	public void getHumanPerformanceLink(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		//Clicks on ErrorFree Bank
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-e"))).click();
		//Clicks on Human Performance Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Human Performance"))).click();
	}
	
	public String createCaseChrome (WebDriver driver, String title, String keyword, int r) throws Exception {
		
		  WebDriverWait wait = new WebDriverWait(driver,90);
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  //Clicks on admin user name on top right corner
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		  //Clicks on admin option
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-admin"))).click();
		  //Clicks on Errorfree bank option
		  if (driver.findElement(By.id("pii-admin-efsh-manage-button")).isDisplayed()==false)
			  {
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efbank']/h3/a"))).click();
			  }
		  //Clicks on Human cases
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-manage-button"))).click();
		  //Enters mandatory data
		  //Enters case id
		  Random random = new Random();
		  String caseId="";
		  List<WebElement> list = new ArrayList<WebElement>();
			//Wait for loading message to disappear
		  ShareCheck obj = new ShareCheck();
			obj.loadingServer(driver);
			  //Clicks on new case button
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-button-new"))).click();
				//Wait for loading message to disappear
				obj.loadingServer(driver);
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
			  WebElement errorCaseId;
			  try{
				  errorCaseId=driver.findElement(By.id("pii-admin-efsh-id-error"));
			  }catch(org.openqa.selenium.NoSuchElementException e)
			  {
				  	break;
				  }
			  if(errorCaseId.isDisplayed()==true)
			  {
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-id"))).clear();
				  continue;
			  }
			  if(errorCaseId.isDisplayed()==false)
				  break;
		  }
		  System.out.println("Case id: "+ caseId);
		  //Enters Question
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-question"))).sendKeys(title);
		  //Enters Answer
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-answer"))).sendKeys(title);
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,1700)");
		  Thread.sleep(1000);
		  //Enters Keyword
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-keyword-search-input"))).clear();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-keyword-search-input"))).sendKeys(keyword);
		  Thread.sleep(1500);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-keyword-new"))).click();
		  //Enters task
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-task-search-input"))).sendKeys(keyword);
		  Thread.sleep(1500);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-task-new"))).click();
		  //Enters purpose
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-purpose-search-input"))).sendKeys(keyword);
		  Thread.sleep(1500);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-purpose-new"))).click();
		  jse.executeScript("scroll(0,2000)");
		  //Enters condition
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-condition-search-input"))).sendKeys(keyword);
		  Thread.sleep(1500);
		  jse.executeScript("scroll(0,2000)");
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-condition-new"))).click();
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(1000);
		  //Uploads 100 slides r=1 for no images, r=2 for 100 images, r=3 for 50 images
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-upload-file-input"))).click();
		  if(r==1)
		  {
			  Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlidesChromeNoImages100.exe");
			  p.waitFor();
		  }
		  if(r==2)
		  {
			  Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlidesChromeOnlyImages100.exe");
			  p.waitFor();
		  }
		  if(r==3)
		  {
			  Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlidesChrome50ImagesAndText100.exe");
			  p.waitFor();
		  }
		  Thread.sleep(3000);
		  //Checks if 100 images have been uploaded
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efsh-upload-form-selectedfiles-div']/h5/a"))).click();
		  Thread.sleep(2000);
		  int i;
		  for (i=0; i<100;i++)
		  {
			  String xpath = ".//*[@id='pii-admin-efsh-upload-form-selectedfiles']/div["+(i+1)+"]";
			  if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).isDisplayed())
			  {
				  System.out.println("Uploaded Image : " + (i+1));
				  list.add(driver.findElement(By.xpath(xpath)));
			  }
			  
		  }
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efsh-upload-form-selectedfiles-div']/h5/a"))).click();
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(1000);
		  //Clicks on save
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-button-save"))).click();
		  //Clicks on create case
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-dialog-title"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-dialog-confirmed"))).click();
			//Wait for loading message to disappear
			obj.loadingServer(driver);
		  if(r==2 ||r==3)
		  {
			//Waits for black loading message to disappear
			  try{
				  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
				  Thread.sleep(5000);
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
				  Thread.sleep(5000);
				  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
				 }catch (org.openqa.selenium.TimeoutException e)
				  {
					  
				  }
		  }
		  if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-button-delete"))).isEnabled()==false)
		  {
			//Clicks on save
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-button-save"))).click();
			  //Clicks on create case
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-dialog-title"))).click();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-dialog-confirmed"))).click();
				//Wait for loading message to disappear
				obj.loadingServer(driver);
			  if(r==2 ||r==3)
			  {
				//Waits for black loading message to disappear
				  try{
					  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
					  Thread.sleep(5000);
					  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
					  Thread.sleep(5000);
					  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
					 }catch (org.openqa.selenium.TimeoutException e)
					  {
						  
					  }
			  }
		  }
		  return caseId;		  
	}
	
	public String createCaseFirefox (WebDriver driver, String title, String keyword, int r) throws Exception {
		
		  WebDriverWait wait = new WebDriverWait(driver,90);
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  //Clicks on admin user name on top right corner
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		  //Clicks on admin option
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-admin"))).click();
		  //Clicks on Errorfree bank option
		  if (driver.findElement(By.id("pii-admin-efsh-manage-button")).isDisplayed()==false)
			  {
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efbank']/h3/a"))).click();
			  }
		  //Clicks on Human cases
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-manage-button"))).click();
		  //Enters mandatory data
		  //Enters case id
		  Random random = new Random();
		  String caseId="";
		  List<WebElement> list = new ArrayList<WebElement>();
			//Wait for loading message to disappear
		  ShareCheck obj = new ShareCheck();
			obj.loadingServer(driver);
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
			  WebElement errorCaseId;
			  try{
				  errorCaseId=driver.findElement(By.id("pii-admin-efsh-id-error"));
			  }catch(org.openqa.selenium.NoSuchElementException e)
			  {
				  	break;
				  }
			  if(errorCaseId.isDisplayed()==true)
			  {
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-id"))).clear();
				  continue;
			  }
			  if(errorCaseId.isDisplayed()==false)
				  break;
		  }
		  System.out.println("Case id: "+ caseId);
		  //Enters Question
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-question"))).sendKeys(title);
		  //Enters Answer
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-answer"))).sendKeys(title);
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,1700)");
		  Thread.sleep(1000);
		  //Enters Keyword
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-keyword-search-input"))).clear();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-keyword-search-input"))).sendKeys(keyword);
		  Thread.sleep(1500);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-keyword-new"))).click();
		  //Enters task
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-task-search-input"))).sendKeys(keyword);
		  Thread.sleep(1500);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-task-new"))).click();
		  //Enters purpose
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-purpose-search-input"))).sendKeys(keyword);
		  Thread.sleep(1500);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-purpose-new"))).click();
		  jse.executeScript("scroll(0,2000)");
		  //Enters condition
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-condition-search-input"))).sendKeys(keyword);
		  Thread.sleep(1500);
		  jse.executeScript("scroll(0,2000)");
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-condition-new"))).click();
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(1000);
		  //Uploads 100 slides r=1 for no images, r=2 for 100 images, r=3 for 50 images
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-upload-file-input"))).click();
		  if(r==1)
		  {
			  Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlidesFirefoxNoImages100.exe");
			  p.waitFor();
		  }
		  if(r==2)
		  {
			  Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlidesFirefoxOnlyImages100.exe");
			  p.waitFor();
		  }
		  if(r==3)
		  {
			  Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlidesFirefox50ImagesAndText100.exe");
			  p.waitFor();
		  }
		  Thread.sleep(3000);
		  //Checks if 100 images have been uploaded
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efsh-upload-form-selectedfiles-div']/h5/a"))).click();
		  Thread.sleep(2000);
		  int i;
		  for (i=0; i<100;i++)
		  {
			  String xpath = ".//*[@id='pii-admin-efsh-upload-form-selectedfiles']/div["+(i+1)+"]";
			  if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).isDisplayed())
			  {
				  System.out.println("Uploaded Image : " + (i+1));
				  list.add(driver.findElement(By.xpath(xpath)));
			  }
			  
		  }
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efsh-upload-form-selectedfiles-div']/h5/a"))).click();
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(1000);
		  //Clicks on save
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-button-save"))).click();
		  //Clicks on create case
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-dialog-title"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-dialog-confirmed"))).click();
			//Wait for loading message to disappear
			obj.loadingServer(driver);
		  if(r==2 ||r==3)
		  {
			//Waits for black loading message to disappear
			  try{
				  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
				  Thread.sleep(5000);
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
				  Thread.sleep(5000);
				  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
				 }catch (org.openqa.selenium.TimeoutException e)
				  {
					  
				  }
		  }
		  if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-button-delete"))).isEnabled()==false)
		  {
			//Clicks on save
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-button-save"))).click();
			  //Clicks on create case
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-dialog-title"))).click();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-dialog-confirmed"))).click();
				//Wait for loading message to disappear
				obj.loadingServer(driver);
			  if(r==2 ||r==3)
			  {
				//Waits for black loading message to disappear
				  try{
					  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
					  Thread.sleep(5000);
					  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
					  Thread.sleep(5000);
					  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
					 }catch (org.openqa.selenium.TimeoutException e)
					  {
						  
					  }
			  }
		  }
		  jse.executeScript("scroll(0,0)");
		  return caseId;		  
	}
	
	public String createCaseIE (WebDriver driver, String title, String keyword, int r) throws Exception {
		
		  WebDriverWait wait = new WebDriverWait(driver,90);
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  //Clicks on admin user name on top right corner
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		  //Clicks on admin option
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-admin"))).click();
		  //Clicks on Errorfree bank option
		  if (driver.findElement(By.id("pii-admin-efsh-manage-button")).isDisplayed()==false)
			  {
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efbank']/h3/a"))).click();
			  }
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(2000);
		  //Clicks on Human cases
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-manage-button"))).click();
		  //Enters mandatory data
		  //Enters case id
		  Random random = new Random();
		  String caseId="";
		  List<WebElement> list = new ArrayList<WebElement>();
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(2000);
			//Wait for loading message to disappear
		  ShareCheck obj = new ShareCheck();
			obj.loadingServer(driver);
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(2000);
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
			  WebElement errorCaseId;
			  try{
				  errorCaseId=driver.findElement(By.id("pii-admin-efsh-id-error"));
			  }catch(org.openqa.selenium.NoSuchElementException e)
			  {
				  	break;
				  }
			  if(errorCaseId.isDisplayed()==true)
			  {
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-id"))).clear();
				  continue;
			  }
			  if(errorCaseId.isDisplayed()==false)
				  break;
		  }
		  System.out.println("Case id: "+ caseId);
		  //Enters Question
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-question"))).sendKeys(title);
		  //Enters Answer
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-answer"))).sendKeys(title);
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,1700)");
		  Thread.sleep(2000);
		  //Enters Keyword
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-keyword-search-input"))).clear();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-keyword-search-input"))).sendKeys(keyword);
		  Thread.sleep(1500);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-keyword-new"))).click();
		  //Enters task
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-task-search-input"))).sendKeys(keyword);
		  Thread.sleep(1500);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-task-new"))).click();
		  //Enters purpose
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-purpose-search-input"))).sendKeys(keyword);
		  Thread.sleep(1500);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-purpose-new"))).click();
		  jse.executeScript("scroll(0,2000)");
		  //Enters condition
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-condition-search-input"))).sendKeys(keyword);
		  Thread.sleep(1500);
		  jse.executeScript("scroll(0,2000)");
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-condition-new"))).click();
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(2000);
		  //Uploads 100 slides r=1 for no images, r=2 for 100 images, r=3 for 50 images
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-upload-file-input"))).click();
		  if(r==1)
		  {
			  Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlidesIE10NoImages100.exe");
			  p.waitFor();
		  }
		  if(r==2)
		  {
			  Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlidesIE10OnlyImages100.exe");
			  p.waitFor();
		  }
		  if(r==3)
		  {
			  Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlidesIE1050ImagesAndText100.exe");
			  p.waitFor();
		  }
		  Thread.sleep(3000);
		  //Checks if 100 images have been uploaded
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efsh-upload-form-selectedfiles-div']/h5/a"))).click();
		  Thread.sleep(2000);
		  int i;
		  for (i=0; i<100;i++)
		  {
			  String xpath = ".//*[@id='pii-admin-efsh-upload-form-selectedfiles']/div["+(i+1)+"]";
			  if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).isDisplayed())
			  {
				  System.out.println("Uploaded Image : " + (i+1));
				  list.add(driver.findElement(By.xpath(xpath)));
			  }
			  
		  }
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efsh-upload-form-selectedfiles-div']/h5/a"))).click();
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(1000);
		  //Clicks on save
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-button-save"))).click();
		  //Clicks on create case
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-dialog-title"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-dialog-confirmed"))).click();
			//Wait for loading message to disappear
			obj.loadingServer(driver);
		  if(r==2 ||r==3)
		  {
			//Waits for black loading message to disappear
			  try{
				  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
				  Thread.sleep(5000);
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
				  Thread.sleep(5000);
				  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
				 }catch (org.openqa.selenium.TimeoutException e)
				  {
					  
				  }
		  }
		  if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-button-delete"))).isEnabled()==false)
		  {
			  Thread.sleep(1000);
			  jse.executeScript("scroll(0,0)");
			  Thread.sleep(1000);
			  //Clicks on save
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-button-save"))).click();
			  //Clicks on create case
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-dialog-title"))).click();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-dialog-confirmed"))).click();
				//Wait for loading message to disappear
				obj.loadingServer(driver);
			  if(r==2 ||r==3)
			  {
				//Waits for black loading message to disappear
				  try{
					  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
					  Thread.sleep(5000);
					  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
					  Thread.sleep(5000);
					  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
					 }catch (org.openqa.selenium.TimeoutException e)
					  {
						  
					  }
			  }
		  }
		  jse.executeScript("scroll(0,0)");
		  return caseId;		  
	}
	
	public String createCaseIE11 (WebDriver driver, String title, String keyword, int r) throws Exception {
		
		  WebDriverWait wait = new WebDriverWait(driver,90);
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  //Clicks on admin user name on top right corner
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		  //Clicks on admin option
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-admin"))).click();
		  //Clicks on Errorfree bank option
		  if (driver.findElement(By.id("pii-admin-efsh-manage-button")).isDisplayed()==false)
			  {
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efbank']/h3/a"))).click();
			  }
			//Wait for loading message to disappear
		  ShareCheck obj = new ShareCheck();
			obj.loadingServer(driver);
		  Thread.sleep(2000);
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(2000);		
		  //Clicks on Human cases
		  WebElement button1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-manage-button")));
		  Actions act2= new Actions(driver);
		  act2.click(button1).build().perform();
		  //Enters mandatory data
		  //Enters case id
		  Random random = new Random();
		  String caseId="";
		  List<WebElement> list = new ArrayList<WebElement>();
			//Wait for loading message to disappear
			obj.loadingServer(driver);
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(3000);
		  //Clicks on new case button
		  WebElement button2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-button-new")));
		  act2.click(button2).build().perform();
		  Thread.sleep(4000);
		  //Clicks on new case
		  WebElement button3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-dialog-title")));
		  act2.click(button3).build().perform();
		  WebElement button4=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-dialog-confirmed")));
		  act2.click(button4).build().perform();
		  while (true)
		  {
			  Thread.sleep(1000);
			  int y=random.nextInt(10000);
			  if(y<1000)
			     continue;
			  caseId = String.format("%d", y);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-id"))).sendKeys(caseId);
			  Thread.sleep(1000);
			  WebElement errorCaseId;
			  try{
				  errorCaseId=driver.findElement(By.id("pii-admin-efsh-id-error"));
			  }catch(org.openqa.selenium.NoSuchElementException e)
			  {
				  	break;
				  }
			  if(errorCaseId.isDisplayed()==true)
			  {
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-id"))).clear();
				  continue;
			  }
			  if(errorCaseId.isDisplayed()==false)
				  break;
		  }
		  System.out.println("Case id: "+ caseId);
		  //Enters Question
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-question"))).sendKeys(title);
		  //Enters Answer
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-answer"))).sendKeys(title);
		  Thread.sleep(1000);
		  jse.executeScript("scroll(0,1700)");
		  Thread.sleep(3000);
		  //Enters Keyword
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-keyword-search-input"))).clear();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-keyword-search-input"))).sendKeys(keyword);
		  Thread.sleep(1500);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-keyword-new"))).click();
		  //Enters task
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-task-search-input"))).sendKeys(keyword);
		  Thread.sleep(3000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-task-new"))).click();
		  //Enters purpose
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-purpose-search-input"))).sendKeys(keyword);
		  Thread.sleep(3000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-purpose-new"))).click();
		  jse.executeScript("scroll(0,2000)");
		  //Enters condition
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-condition-search-input"))).sendKeys(keyword);
		  Thread.sleep(3000);
		  jse.executeScript("scroll(0,2000)");
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-condition-new"))).click();
		  Thread.sleep(4000);
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(2000);
		  //Uploads 100 slides r=1 for no images, r=2 for 100 images, r=3 for 50 images
		  WebElement ele =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-upload-file-input")));
		  act2.click(ele).build().perform();
		  if(r==1)
		  {
			  Process p =Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/UploadHumanCaseSlidesIE10NoImages100.exe");
			  p.waitFor();
		  }
		  if(r==2)
		  {
			  Process p =Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/UploadHumanCaseSlidesIE10OnlyImages100.exe");
			  p.waitFor();
		  }
		  if(r==3)
		  {
			  Process p =Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/UploadHumanCaseSlidesIE1050ImagesAndText100.exe");
			  p.waitFor();
		  }
		  Thread.sleep(3000);
		  //Checks if 100 images have been uploaded
		  WebElement button11=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-upload-form-selectedfiles-div")));
		  act2.click(button11).build().perform();
		  int i;
		  for (i=0; i<100;i++)
		  {
			  String xpath = ".//*[@id='pii-admin-efsh-upload-form-selectedfiles']/div["+(i+1)+"]";
			  if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).isDisplayed())
			  {
				  System.out.println("Uploaded Image : " + (i+1));
				  list.add(driver.findElement(By.xpath(xpath)));
			  }
			  
		  }
		  WebElement plussign=driver.findElement(By.xpath(".//*[@id='pii-admin-efsh-upload-form-selectedfiles-div']/h5/a"));
		  act2.click(plussign).build().perform();
		  Thread.sleep(3000);
		  jse.executeScript("scroll(0,0)");
		  Thread.sleep(1000);
		  //Clicks on save
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-button-save"))).click();
		  //Clicks on create case
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-dialog-title"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-dialog-confirmed"))).click();
			//Wait for loading message to disappear
			obj.loadingServer(driver);
		  if(r==2 ||r==3)
		  {
			//Waits for black loading message to disappear
			  try{
				  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
				  Thread.sleep(5000);
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
				  Thread.sleep(5000);
				  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
				 }catch (org.openqa.selenium.TimeoutException e)
				  {
					  
				  }
		  }
		  if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-button-delete"))).isEnabled()==false)
		  {
			  Thread.sleep(1000);
			  jse.executeScript("scroll(0,0)");
			  Thread.sleep(1000);
			  //Clicks on save
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-button-save"))).click();
			  //Clicks on create case
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-dialog-title"))).click();
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-dialog-confirmed"))).click();
				//Wait for loading message to disappear
				obj.loadingServer(driver);
			  if(r==2 ||r==3)
			  {
				//Waits for black loading message to disappear
				  try{
					  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
					  Thread.sleep(5000);
					  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
					  Thread.sleep(5000);
					  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
					 }catch (org.openqa.selenium.TimeoutException e)
					  {
						  
					  }
			  }
		  }
		  jse.executeScript("scroll(0,0)");
		  return caseId;		  
	}
	
	public int deletePreviousCase(WebDriver driver, String keyword) throws Exception{
		WebDriverWait wait = new WebDriverWait(driver,40);
		//Clicks on Error free bank
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-e"))).click();
		//Clicks on Human Performance Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Human Performance"))).click();
		//Enters the title in term search field
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-clear"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-searchbykw-input"))).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-searchbykw-input"))).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);
		//Checks if Exact matches appear
		try{
			driver.findElement(By.xpath(".//*[@id='pii-question-list']/div/h4/a/div"));			
		}catch (NoSuchElementException e)
		{
			System.out.println("No existing cases for "+keyword);
			return 0;
		}		
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
			deleteCase(driver, caseIdArray[count]);
		}
		return 1;				
	}

	public void deleteCase(WebDriver driver, String caseId) throws Exception{
		  WebDriverWait wait = new WebDriverWait(driver,40);
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  //Clicks on admin user name on top right corner
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		  //Clicks on admin option
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-admin"))).click();
		  Thread.sleep(1000);
		  //Clicks on Errorfree bank option
		  if (driver.findElement(By.id("pii-admin-efsh-manage-button")).isDisplayed()==false)
			  {
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efbank']/h3/a"))).click();
			  }
		  //Clicks on Human cases
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-manage-button"))).click();
			//Wait for loading message to disappear
		  ShareCheck obj = new ShareCheck();
			obj.loadingServer(driver);
		  jse.executeScript("scroll(0,0)");
		  //Click on enter case id
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-list-input"))).sendKeys(caseId);
		  Thread.sleep(2000);
		  //Clicks on case id
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-list-ul"))).click();
			//Wait for loading message to disappear
			obj.loadingServer(driver);
		  jse.executeScript("scroll(0,0)");
		  //Clicks on delete button
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-button-delete"))).click();
			//Wait for loading message to disappear
			obj.loadingServer(driver);
		  //Clicks on delete case
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-dialog-title"))).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efsh-dialog-confirmed"))).click();
			//Wait for loading message to disappear
			obj.loadingServer(driver);
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
			  System.out.println("Case deleted "+caseId);		  
	}

	public long searchCase100(WebDriver driver, String keyword, String identifier) throws Exception{
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		//Types in the keyword to get slide 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-searchbykw-input"))).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-searchbykw-input"))).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		ShareCheck obj = new ShareCheck();
		obj.loadingServer(driver);
		//Click on collapsible 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-"+identifier))).click();
		//Wait for loading message to disappear
		obj.loadingServer(driver);
		//Clicks on Show Slides
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-button-"+identifier)));
		WebElement element =  driver.findElement(By.id("pii-slideshow-button-"+identifier));
		String slide = element.getText();
		System.out.println(slide);
		while (slide.equals("Show Slides(101)")==false)
		{
			Thread.sleep(1000);
			System.out.println(slide);
			slide = element.getText();
		}		
		System.out.println(slide);
		System.out.println(slide.indexOf("(") + "  "+ slide.indexOf(")"));
		String number= slide.substring(slide.indexOf("(")+1, slide.indexOf(")"));
	    element.sendKeys(Keys.TAB);
	    element.sendKeys(Keys.ENTER);
		driver.findElement(By.id("pii-slideshow-"+identifier+"-popup"));
		System.out.println(number);
		int n = Integer.parseInt(number);
		Thread.sleep(1000);
		long total=0;
		for(int i=0;i<n-1;i++)
		{
			long f1=System.currentTimeMillis();
			System.out.println("Slide "+(i+1));
			if(i==0)
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Next"))).click();
			String load=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideimg-"+identifier+"-"+(i+1)))).getAttribute("src");
			while (load.contains("loading.gif")==true)
			{
				load=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideimg-"+identifier+"-"+(i+1)))).getAttribute("src");	
			}
			long f2=System.currentTimeMillis();
			System.out.println("Total loading time in milliseconds: "+ (f2-f1));
			total=total+(f2-f1);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Next"))).click();
		}
		System.out.println("Total time in milliseconds for case with only images:"+total);
		System.out.println("Total time in seconds for case with only images:"+(total/1000));
		//Closes the slideshow
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-"+identifier+"']/a"))).click();
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efsh-clear"))).click();
		return total;
	}
	
	public void storeData(WebDriver driver, long total1, long total2, long total3, String sheet) throws Exception {
		
		File file = new File("E:/LoadCase.xlsx");		
		// Open the Excel file
		FileInputStream ExcelFile = new FileInputStream(file);
		// Access the required test data sheet
		XSSFWorkbook ExcelWBook = new XSSFWorkbook(ExcelFile);
		XSSFSheet ExcelWSheet = ExcelWBook.getSheet(sheet);
		//Get number of rows
		int rows = ExcelWSheet.getPhysicalNumberOfRows();
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
	    String browserName = cap.getBrowserName().toLowerCase();
	    System.out.println(browserName);
	    //Get date
	    SimpleDateFormat sfdate = new SimpleDateFormat("MM/dd/yyy");
	    Date date = new Date();
	    //System.out.println(sfdate.format(date));
		//Create a new row for only images
		Row row1 = ExcelWSheet.createRow(rows);
		row1.createCell(0).setCellValue("Only Images");
		row1.createCell(1).setCellValue(total1/1000);	
		row1.createCell(2).setCellValue(browserName);
		row1.createCell(3).setCellValue(sfdate.format(date));
		//Create a new row for No images
		Row row2 = ExcelWSheet.createRow(rows+1);
		row2.createCell(0).setCellValue("No Images");
		row2.createCell(1).setCellValue(total2/1000);
		row2.createCell(2).setCellValue(browserName);
		row2.createCell(3).setCellValue(sfdate.format(date));
		//Create a new row for 50 images
		Row row3 = ExcelWSheet.createRow(rows+2);
		row3.createCell(0).setCellValue("50 Images");
		row3.createCell(1).setCellValue(total3/1000);
		row3.createCell(2).setCellValue(browserName);
		row3.createCell(3).setCellValue(sfdate.format(date));
		//Close File input stream
		ExcelFile.close();
		//Create an object of FileOutputStream class to create write data in excel file
		FileOutputStream outputStream = new FileOutputStream(file);
		ExcelWBook.write(outputStream);
		ExcelWBook.close();
		outputStream.close();
		
	}

}
