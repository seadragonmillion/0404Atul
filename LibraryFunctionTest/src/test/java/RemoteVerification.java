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
import java.util.concurrent.TimeUnit;

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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RemoteVerification {
	
	SoftAssertions softly = new SoftAssertions();	
	String event_title="I think I will buy the red car, or I will lease the blue one.";
	String details ="There was no ice cream in the freezer, nor did they have money to go to the store./?.,><';:*-+()@#$%&01234567890";
	
	public void checkStatusReport (WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		//Clicks on Save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-save"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-dialog-confirmed"))).click();
		//Waits for black loading message to disappear
		try{
		  Thread.sleep(2000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
		  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
		}catch (org.openqa.selenium.TimeoutException e)
		  {
			  
		  }
		//Click on Saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-savedactivities"))).click();
		//Waits for black loading message to disappear
		try{
			  Thread.sleep(2000);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			}catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Clicks on newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-rv']/ul/li[2]/a"))).click();
		//Waits for black loading message to disappear
		try{
			  Thread.sleep(2000);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			}catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Verify status
		String status = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='rv-rpt']/div/div[2]/div[4]/span"))).getText();
		softly.assertThat(status).as("test data").contains("Not yet sent to verifier");
		//Click on Open
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[1]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		Thread.sleep(1000);
		//Waits for the page to load
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Clicks on Save and Send
		driver.findElement(By.xpath(".//*[@id='pii-rv-tabs']/div[2]/div/a[2]")).click();
		//Clicks on save and send report
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-dialog-title"))).click();
		driver.findElement(By.id("pii-rv-dialog-confirmed")).click();
		//Waits for black loading message to disappear
		try{
			  Thread.sleep(2000);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			}catch (org.openqa.selenium.TimeoutException e)
			  {
				  
			  }
		//Verify status
		String status1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='rv-rpt']/div/div[2]/div[5]/span"))).getText();
		softly.assertThat(status1).as("test data").contains("Sent, waiting upon verification");
	}
	
	public void upload1stpictureChrome(WebDriver driver) throws Exception {
		
		WebDriverWait wait1 = new WebDriverWait(driver,20);
		//Uploads picture 1
		String filepath = "C:/Users/Public/Pictures/Sample Pictures/Chrysanthemum.jpg";
		driver.findElement(By.id("pii-rv-imgwork-photo-input")).sendKeys(filepath);
		//Clears image
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-imgwork-clear"))).click();
		//Re-uploads same picture 1
		driver.findElement(By.id("pii-rv-imgwork-photo-input")).sendKeys(filepath);
		//Clears image
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-imgwork-clear"))).click();
		//Re-uploads different picture 1
		driver.findElement(By.id("pii-rv-imgwork-photo-input")).sendKeys("C:/Users/Public/Pictures/Sample Pictures/Desert.jpg");
		//Rotates image 1 twice
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-imgwork-rotate"))).click();
		Thread.sleep(1000);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-imgwork-rotate"))).click();
	}
	
	public void upload1stpictureFirefox(WebDriver driver) throws Exception {
		
		WebDriverWait wait1 = new WebDriverWait(driver,20);
		//Clicks on browse button of 1st picture
		driver.findElement(By.id("pii-rv-imgwork-photo-input")).click();
		Thread.sleep(2000);
		//Uploads picture 1
		Process p=Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaDesert.exe");
		p.waitFor();
		Thread.sleep(4000);
		//Clears image
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-imgwork-clear"))).click();
		//Re-uploads same picture 1
		driver.findElement(By.id("pii-rv-imgwork-photo-input")).click();
		Thread.sleep(2000);
		Process p1=Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaDesert.exe");
		p1.waitFor();
		Thread.sleep(4000);
		//Clears image
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-imgwork-clear"))).click();
		//Re-uploads different picture 1
		driver.findElement(By.id("pii-rv-imgwork-photo-input")).click();
		Thread.sleep(2000);
		Process p2=Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaChrysanthemum.exe");
		p2.waitFor();
		Thread.sleep(4000);
		//Rotates image 1 twice
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-imgwork-rotate"))).click();
		Thread.sleep(1000);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-imgwork-rotate"))).click();
	}
	
	public void upload1stpictureIE10(WebDriver driver) throws Exception {
		
		WebDriverWait wait1 = new WebDriverWait(driver,20);
		Actions act = new Actions(driver);
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
	}
	
	public void upload1stpictureIE11(WebDriver driver) throws Exception {
		
		WebDriverWait wait1 = new WebDriverWait(driver,20);
		//Clicks twice on browse button of 1st picture
		WebElement element2 =  driver.findElement(By.id("pii-rv-imgwork-photo-input"));
		Actions act = new Actions(driver);
		act.doubleClick(element2).build().perform();
		Thread.sleep(3000);
		try{
		  try {
				  //Uploads picture 1
				  Process q=Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/IEChrysanthemum.exe");				  
				  q.waitFor();
		      }catch (UnhandledAlertException g){
		    	  System.out.println("Unexpected alert for picture 1");
				  driver.switchTo().alert().accept();
		      }
		    }catch (NoAlertPresentException g){			  
		  System.out.println ("No unexpected alerts for picture 1");
		    }			 
		Thread.sleep(4000);
		//Clears image
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-imgwork-clear"))).click();
		//Same image
		act.doubleClick(element2).build().perform();
		Thread.sleep(3000);
		try{
		  try {
				  //Uploads picture 1
				  Process q=Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/IEChrysanthemum.exe");				  
				  q.waitFor();
		      }catch (UnhandledAlertException g){
		    	  System.out.println("Unexpected alert for picture 1");
				  driver.switchTo().alert().accept();
		      }
		    }catch (NoAlertPresentException g){			  
		  System.out.println ("No unexpected alerts for picture 1");
		    }			 
		Thread.sleep(4000);
		//Clears image
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-imgwork-clear"))).click();
		//Re-uploads different picture 1
		act.doubleClick(element2).build().perform();
		Thread.sleep(3000);
		try{
		  try {
				  //Uploads picture 1
				  Process q=Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/IEDesert.exe");				  
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
	}
		
    public void upload2ndpictureChrome(WebDriver driver) throws Exception {
		
    	WebDriverWait wait1 = new WebDriverWait(driver,20);
		//Uploads picture 2
		String file2 = "C:/Users/Public/Pictures/Sample Pictures/Desert.jpg";
		driver.findElement(By.id("pii-rv-imgperson-photo-input")).sendKeys(file2);
		//Clears image
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-imgperson-clear"))).click();
		//Re-uploads same picture 2
		driver.findElement(By.id("pii-rv-imgperson-photo-input")).sendKeys(file2);
		//Clears image
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-imgperson-clear"))).click();
		//Re-uploads different picture 2
		driver.findElement(By.id("pii-rv-imgperson-photo-input")).sendKeys("C:/Users/Public/Pictures/Sample Pictures/Chrysanthemum.jpg");
		//Rotates image 2 once
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-imgperson-rotate"))).click();
	}
	
	public void upload2ndpictureFirefox(WebDriver driver) throws Exception {
		
		WebDriverWait wait1 = new WebDriverWait(driver,20);
		//Clicks on browse button of 2nd picture
		driver.findElement(By.id("pii-rv-imgperson-photo-input")).click();
		Thread.sleep(2000);
		//Uploads picture 2
		Process p3=Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaChrysanthemum.exe");
		p3.waitFor();
		Thread.sleep(8000);
		//Clears image
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-imgperson-clear"))).click();
		//Re-uploads same picture 2
		driver.findElement(By.id("pii-rv-imgperson-photo-input")).click();
		Thread.sleep(2000);
		Process p2=Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaChrysanthemum.exe");
		p2.waitFor();
		Thread.sleep(8000);
		//Clears image
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-imgperson-clear"))).click();
		//Re-uploads different picture 2
		driver.findElement(By.id("pii-rv-imgperson-photo-input")).click();
		Thread.sleep(2000);
		Process p1=Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaDesert.exe");
		p1.waitFor();
		Thread.sleep(8000);
		//Rotates image 2 once
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-imgperson-rotate"))).click();
	}
	
	public void upload2ndpictureIE10(WebDriver driver) throws Exception {
		
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
		 //Clears image
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
	}
	
	public void upload2ndpictureIE11(WebDriver driver) throws Exception {
		
		  //Clicks twice on browse button of 2nd picture
		  WebElement element =  driver.findElement(By.id("pii-rv-imgperson-photo-input"));
		  Actions act = new Actions(driver);
		  act.doubleClick(element).build().perform();
		  Thread.sleep(3000);
		  try{
			  try {
					//Uploads picture 2
					  Process p =Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/IEChrysanthemum.exe");
					  p.waitFor();
				  }catch (UnhandledAlertException f){		
					  System.out.println("Unexpected alert for picture 2");
					  driver.switchTo().alert().accept();
				  }
			  
		  }catch (NoAlertPresentException f){			  
			  System.out.println ("No unexpected alert for picture 2");
		  }
		  Thread.sleep(4000);
		  //Clears image
		  WebDriverWait wait1 = new WebDriverWait(driver,20);
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-imgperson-clear"))).click();
		  //Re-uploads same picture 2
		  act.doubleClick(element).build().perform();
		  Thread.sleep(3000);
		  try{
			  try {
					//Uploads picture 2
					  Process p =Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/IEChrysanthemum.exe");
					  p.waitFor();
				  }catch (UnhandledAlertException f){		
					  System.out.println("Unexpected alert for picture 2");
					  driver.switchTo().alert().accept();
				  }
			  
		  }catch (NoAlertPresentException f){			  
			  System.out.println ("No unexpected alert for picture 2");
		  }
		  Thread.sleep(4000);
		  //Clears image
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-imgperson-clear"))).click();
		  //Re-uploads same picture 2
		  act.doubleClick(element).build().perform();
		  Thread.sleep(3000);
		  try{
			  try {
					//Uploads picture 2
					  Process p =Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/IEDesert.exe");
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
	}
	
	public void verifyDateTime(WebDriver driver) throws Exception {
		
		WebDriverWait wait1 = new WebDriverWait(driver,30);
		//Get time and date from RV location map
		String timeDate = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-tab-1-repdatetime"))).getText();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
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
		softly.assertThat(timeDate).as("test data").contains(dateFormat1.format(cal.getTime()));
		
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
		if((latLongs[0]!="") && (latLongs[1]!=""))
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
	    return new String[] {"",""};
	  }
	
	public void shareReport(WebDriver driver, String verifier, String username,String password1,int y) throws Exception{
    	
    	WebDriverWait wait1 = new WebDriverWait(driver,60);
    	ErrorMeter obj = new ErrorMeter();
    	String sharer = obj.decideSharer (y);
    	String sharerAdded = obj.decideSharerAdded (y);
		//Switches to the iframe
		wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
    	//Clicks on share button
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-single']/div/div/a[3]"))).click();
    	//Verifies if verifier displayed is disabled
    	WebElement verify = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhshare-verifier-list-div']/div/div/div/ul")));
    	String s = verify.getAttribute("data-inset");
    	System.out.println(s);
    	if(s.equals("true")==false)
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
		dropdown.findElement(By.cssSelector(".ui-first-child")).click();
		//Clicks on add user
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		//Verifies user added
		String user=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhshare-blocks']/div/form/div/ul/li/a"))).getText();
		softly.assertThat(user).as("test data").isEqualTo(sharerAdded);
		ShareCheck obj1 = new ShareCheck();
		obj1.shareTwice (driver);
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
		 //Calls the Share check function
		 obj1.receiptReport(driver, sharer, username, password1);
		 //Clicks on Remote Verification side panel
		 wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-rv"))).click();
		 try{
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
			  wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			 }catch (org.openqa.selenium.TimeoutException e)
			  {
					  
			  }
		 //Clicks on first newly created record
		 wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-rv']/ul/li[2]/a"))).click();;
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
	
	
	public void downloadRecordIE11(WebDriver driver, String verifier, String username) throws Exception {
    	
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
			  Process q = Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/SavePdf.exe");
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
			  catch (org.openqa.selenium.ElementNotInteractableException u)
			  {
				  break;
			  }
		  }
		  			  
	  }
	
	public void softAssert() throws Exception {
		softly.assertAll();
	}

}
