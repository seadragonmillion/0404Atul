import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.w3c.dom.Document;

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
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RemoteVerification {
	
	SoftAssertions softly = new SoftAssertions();	
	String event_title="I think I will buy the red car, or I will lease the blue one.";
	String details ="There was no ice cream in the freezer, nor did they have money to go to the store./?.,><';:*-+()@#$%&01234567890";
		
	
	public void verifyDateTime(WebDriver driver) throws Exception {
		
		WebDriverWait wait1 = new WebDriverWait(driver,30);
		//Get time and date from RV location map
		String timeDate = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-tab-1-repdatetime"))).getText();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
		int minute = cal.get(Calendar.MINUTE);
		int hour = cal.get(Calendar.HOUR);
		//Verify if hour is correct
		softly.assertThat(timeDate).as("test data").contains(Integer.toString(hour));
		//Verify if minute is within 20 minutes of present time + or -
		if((minute>=minute-10) ||(minute<=minute+10))
		{
			System.out.println("Minute correct");
		}
		else softly.fail("Time minutes part is not within 20 minutes of actual time");
		//Verify if date is correct
		softly.assertThat(timeDate).as("test data").contains(dateFormat.format(cal.getTime()));
		
	}
	
	public void verifierSelect(WebDriver driver) throws Exception {
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
	    //Selects the remote verifier
		driver.findElement(By.id("pii-rv-verifier-list-input")).sendKeys("qaarvverifier");
		jse.executeScript("scroll(0, 1500)");
		WebElement select = driver.findElement(By.id("pii-rv-verifier-list-ul"));
		WebElement option=select.findElement(By.cssSelector(".ui-first-child"));
		option.click();
	}
	
	public void verifyLongitudeLatitude(WebDriver driver) throws Exception {
		
		WebDriverWait wait1 = new WebDriverWait(driver,30);
		String address = "462 Stevens Avenue, Suite #306 Solana Beach, CA 92705";
		Thread.sleep(4000);
		String latLongs[] = getLatLongPositions(address);
		if(latLongs.length>0 && latLongs!=null)
		{
	    System.out.println("Latitude: "+latLongs[0]+" and Longitude: "+latLongs[1]);
	    //Verify image appears
	    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-imgwork-googlemap")));
	    //Get longitude latitude from rv location image
	    String location = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-imgwork-location"))).getText();
	    System.out.println(location); 
	    //check if longitude matches upto first decimal point
	    String longitude = latLongs[1].toString().substring(0, 5);
	    softly.assertThat(location).as("test data").contains(longitude);
	    //check if latitude matches upto first decimal point
	    String latitude = latLongs[0].toString().substring(0, 3);
	    softly.assertThat(location).as("test data").contains(latitude);
		}
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
	    return null;
	  }
	
	public String decideSharer (int y) throws Exception{
		
		if(y==0)
    	{
    		String sharer ="qaacreator";
    		return sharer;
       	}
    	else
    	{
    		String sharer ="qaacfiverifier";
    		return sharer;
       	}
		
	}
	
	public String decideSharerAdded (int y) throws Exception{
		
		if(y==0)
    	{
    		String sharer ="QAA Creator (qaacreator)";
    		return sharer;
       	}
    	else
    	{
    		String sharer ="QAA (qaacfiverifier)";
    		return sharer;
       	}
		
	}
	
	public void shareReport(WebDriver driver, String verifier, String username,int y) throws Exception{
    	
    	WebDriverWait wait1 = new WebDriverWait(driver,60);
    	String sharer = decideSharer (y);
    	String sharerAdded = decideSharerAdded (y);
		//Switches to the iframe
		wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
    	//Clicks on share button
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[3]"))).click();
    	//Verifies if verifier displayed is disabled
    	WebElement verify = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhshare-verifier-list-div']/div/div/div/ul/li")));
    	if(verify.isEnabled()==true)
    		softly.fail("Verifier text box not suppose to be enabled");    	
    	//Enters verifier username and tries to add verifier
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-uhshare-search-input"))).sendKeys(verifier);
    	//Selects from dropdown
    	WebElement dropdown1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhshare-blocks']/div[2]/ul")));
    	dropdown1.findElement(By.cssSelector(".ui-first-child")).click();
    	//Gets text from error pop up and verifies text
    	String error = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).getText();
    	softly.assertThat(error).as("test data").contains("Sorry, the current activity is already shared to user");
    	//Verifies cancel button not available
    	WebElement cancel = driver.findElement(By.id("pii-user-home-dialog-cancel"));
    	if(cancel.isDisplayed()==true)
    		softly.fail("Cancel button not suppose to be displayed");
    	//Verifies if only ok button available and clicks on ok
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
    	//Adds sharer
		//Enters sharer username
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-uhshare-search-input"))).clear();
    	Thread.sleep(1000);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-uhshare-search-input"))).sendKeys(sharer);
    	//Selects from dropdown
		WebElement dropdown = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhshare-blocks']/div[2]/ul")));
		dropdown.findElement(By.cssSelector(".ui-first-child.ui-last-child")).click();
		//Clicks on add user
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		//Verifies user added
		String user=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhshare-blocks']/div/form/div/ul/li/a"))).getText();
		softly.assertThat(user).as("test data").isEqualTo(sharerAdded);
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
	
	public void downloadRecordChrome(WebDriver driver, String verifier, String username) throws Exception {
    	
	    //deletes files in reports folder before starting to download
    	File file = new File("C://Users//IEUser//Downloads//reports//");
    	deleteFiles(file);	    	
	    WebDriverWait wait1 = new WebDriverWait(driver,60);
    	//Clicks on first newly created record
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-rv']/ul/li[2]/a"))).click();
		String window = driver.getWindowHandle();
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a"))).click();
		try{
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
    	Thread.sleep(7000);
    	pdfCheck(verifier,username);
        for(String winHandle : driver.getWindowHandles()){
	    driver.switchTo().window(winHandle);
	    }
        driver.close();
    	driver.switchTo().window(window);
    	Thread.sleep(1000);
    		    	
    }
    
	public void downloadRecordFirefox(WebDriver driver, String verifier, String username) throws Exception {
    	
	    //deletes files in reports folder before starting to download
    	File file = new File("C://Users//IEUser//Downloads//reports//");
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
    	Thread.sleep(8000);
    	for(String winHandle : driver.getWindowHandles()){
    	    driver.switchTo().window(winHandle);
    	}
    	Thread.sleep(2000);
    	//wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("viewerContainer"))).sendKeys(Keys.chord(Keys.CONTROL + "s"));
    	Robot robot = new Robot();
    	// press Ctrl+S the Robot's way
    	robot.keyPress(KeyEvent.VK_CONTROL);
    	robot.keyPress(KeyEvent.VK_S);
    	robot.keyRelease(KeyEvent.VK_CONTROL);
    	robot.keyRelease(KeyEvent.VK_S);
    	Process p= Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/PDFReportFirefox.exe");
    	p.waitFor();
    	pdfCheck(verifier,username);
    	Thread.sleep(4000);
    	driver.close();
    	Thread.sleep(4000);
    	driver.switchTo().window(window);
    	driver.switchTo().defaultContent();
    		    	
    }
	
	public void downloadRecordIE(WebDriver driver, String verifier, String username) throws Exception {
    	
	    //deletes files in reports folder before starting to download
    	File file = new File("C://Users//IEUser//Downloads//reports//");
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
    	pdfCheck(verifier,username);
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
	
	public void pdfCheck(String verifier, String username) throws Exception {
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
	
	public void markCritical(WebDriver driver) throws Exception{
    	
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
	
	public void deleteNewRecord(WebDriver driver, String recordName) throws Exception{
		  
		  Thread.sleep(2000);
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  //Clicks on delete button
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[2]"))).click();
		  
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title")));
		  //Clicks on delete report
		  driver.findElement(By.id("pii-user-home-dialog-confirmed")).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		  Thread.sleep(2000);
		  driver.findElement(By.id("pii-user-home-panel-btn-rv")).click();
		  //Verify record deleted
		  //Click on 1st record
		  String name = driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-rv']/ul/li[2]/a")).getText();
		  System.out.println(name);
		  if (name!=recordName)
			  System.out.println("Record deleted");
		  else
			  System.out.println("Record could not be deleted");
		  
		  while(true)
		  {
			  Thread.sleep(1000);
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
		  			  
	  }

}
